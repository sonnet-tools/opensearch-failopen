            ),
import org.opensearch.common.xcontent.XContentFactory;
                stats.removeWeight(),
import org.opensearch.core.xcontent.XContentBuilder;
                fileCacheCapacity,
 */
        final long evicted = randomLongBetween(0, getMockCacheStats().getFullFileCacheStats().evictionWeight());
                FileCacheStatsType.BLOCK_FILE_STATS
                fileCacheCapacity,
        assertEquals(original.getUsed(), deserialized.getUsed());
                stats.missCount(),
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
        assertEquals(original.getUsedPercent(), deserialized.getUsedPercent());
        final long hits = randomLongBetween(0, 10000);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(original.getActive(), deserialized.getActive());
            new FileCacheStats(
            new RefCountedCacheStats(hits, miss, 0, removed, replaced, 0, evicted, usage, activeUsage, pinnedUsage),
                stats.usage(),
                fullFileEvictionCount,
        final long usage = randomLongBetween(10000, BYTES_IN_GB);
                fullFileEvictionCount,
        final long fullFileReplaceCount = randomLongBetween(0, 10000);
        deserializedBuilder.startObject();
        return new AggregateFileCacheStats(
                stats.evictionWeight(),
 *
            new FileCacheStats(
                fullFileRemoveCount,
        assertEquals(original.getActivePercent(), deserialized.getActivePercent());
                fullFileReplaceCount,
                fullFileRemoveWeight,
            )
    public static AggregateRefCountedCacheStats getMockCacheStats() {
                fullFileRemoveWeight,
        final long fullFileActiveUsage = randomLongBetween(0, 10000);
        return new AggregateRefCountedCacheStats(
            ),
                pinnedUsage
        final long removed = randomLongBetween(0, 10);
                fullFileUsage,
    }
package org.opensearch.index.store.remote.filecache;
        final long activeUsage = randomLongBetween(10000, BYTES_IN_GB);
                FileCacheStatsType.OVER_ALL_STATS
        );
        final long fullFileRemoveCount = randomLongBetween(0, 10000);
        }
import org.opensearch.test.OpenSearchTestCase;
                stats.activeUsage(),
        assertEquals(original.getCacheHits(), deserialized.getCacheHits());
 * this file be licensed under the Apache-2.0 license or a
        final long fullFileRemoveWeight = randomLongBetween(10000, BYTES_IN_GB);
        assertEquals(original.getUsed(), deserialized.getUsed());
                stats.missCount(),
    }
                fullFileEvictionWeight,
            }
                FileCacheStatsType.PINNED_FILE_STATS
            ),
    public static void validateFileCacheStats(AggregateFileCacheStats original, AggregateFileCacheStats deserialized) throws IOException {
                fullFileRemoveCount,
        return randomLongBetween(10 * BYTES_IN_GB, 1000 * BYTES_IN_GB);
import org.opensearch.common.io.stream.BytesStreamOutput;
        final long fullFileHitCount = randomLongBetween(0, 10000);
import org.opensearch.core.xcontent.ToXContent;
        final long active = randomLongBetween(100000, BYTES_IN_GB);
        final long evicted = randomLongBetween(10000, BYTES_IN_GB);
        return getFileCacheStats(fcSize, getMockCacheStats());
import org.opensearch.index.store.remote.utils.cache.stats.AggregateRefCountedCacheStats;
import java.io.IOException;
/*
                stats.activeUsage(),
        assertEquals(original.getCacheMisses(), deserialized.getCacheMisses());
                fullFileUsage,
        builder.endObject();
                stats.hitCount(),
        assertEquals(original.getTotal(), deserialized.getTotal());
                0,
            System.currentTimeMillis(),
        deserializedBuilder = deserialized.toXContent(deserializedBuilder, ToXContent.EMPTY_PARAMS);
        final long fullFileEvictionCount = randomLongBetween(0, 10000);
        final long total = randomLongBetween(100000, BYTES_IN_GB);
        final long hit = randomLongBetween(0, 10);
                stats.hitCount(),
            ),
                FileCacheStatsType.FULL_FILE_STATS
                stats.evictionWeight(),
                fullFileActiveUsage,
                fullFileEvictionWeight,
    }
                stats.pinnedUsage(),
        assertEquals(original.getEvicted(), deserialized.getEvicted());
                stats.missCount(),
                stats.activeUsage(),
import org.opensearch.index.store.remote.utils.cache.stats.RefCountedCacheStats;
                stats.evictionWeight(),
        assertTrue(builder.toString().equals(deserializedBuilder.toString()));
            try (StreamInput in = out.bytes().streamInput()) {
        final AggregateFileCacheStats fileCacheStats = getMockFileCacheStats();
    public void testFileCacheStatsSerialization() throws IOException {
                fullFileReplaceCount,
                stats.usage(),
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    private static final long BYTES_IN_GB = 1024 * 1024 * 1024;
                fullFileRemoveWeight,
                fileCacheCapacity,
                stats.usage(),
        XContentBuilder deserializedBuilder = XContentFactory.jsonBuilder();
        final long fcSize = getMockCacheCapacity();
                validateFileCacheStats(fileCacheStats, new AggregateFileCacheStats(in));
            new FileCacheStats(
                fullFileActiveUsage,
                fullFileActiveUsage,
        assertEquals(original.getEvicted(), deserialized.getEvicted());
            new FileCacheStats(
        XContentBuilder builder = XContentFactory.jsonBuilder();
                stats.pinnedUsage(),
                fullFileUsage,
                fullFileHitCount,
                stats.usage(),
        deserializedBuilder.endObject();
    }
public class AggregateFileCacheStatsTests extends OpenSearchTestCase {
}
                pinnedUsage
        return new FileCacheStats(active, total, used, pinned, evicted, removed, hit, misses, FileCacheStatsType.OVER_ALL_STATS);
                stats.hitCount(),
        assertEquals(original.getHits(), deserialized.getHits());
                0,
        final long replaced = randomLongBetween(0, 10000);
    }
import org.opensearch.core.common.io.stream.StreamInput;
    public static FileCacheStats getMockFullFileCacheStats() {
            )
    }
 * compatible open source license.
    public static long getMockCacheCapacity() {
        );
            new RefCountedCacheStats(
        builder = original.toXContent(builder, ToXContent.EMPTY_PARAMS);
        final long removed = randomLongBetween(10000, BYTES_IN_GB);
                fullFileHitCount,
                stats.pinnedUsage(),
        final long misses = randomLongBetween(0, 10);
                fullFileEvictionCount,
        assertEquals(original.getActivePercent(), deserialized.getActivePercent());
                // Validate original object against deserialized values
    }
    public static void validateFullFileStats(FileCacheStats original, FileCacheStats deserialized) {
                stats.removeWeight(),
        final long fullFileUsage = randomLongBetween(0, 10000);
        throws IOException {
        final long used = randomLongBetween(100000, BYTES_IN_GB);
    public static AggregateFileCacheStats getFileCacheStats(final long fileCacheCapacity, final AggregateRefCountedCacheStats stats)
        final long pinnedUsage = randomLongBetween(10000, BYTES_IN_GB);
            ),
        assertEquals(original.getTimestamp(), deserialized.getTimestamp());
                fullFileHitCount,
                stats.removeWeight(),
                stats.missCount(),
    }
    public static AggregateFileCacheStats getMockFileCacheStats() throws IOException {
                stats.pinnedUsage(),
        final long pinned = randomLongBetween(100000, BYTES_IN_GB);
            fileCacheStats.writeTo(out);
                stats.removeWeight(),
 * The OpenSearch Contributors require contributions made to
                fileCacheCapacity,
            new RefCountedCacheStats(
                0,
                pinnedUsage
                fullFileReplaceCount,
        assertEquals(original.getOverallActivePercent(), deserialized.getOverallActivePercent(), 0.0);
                fullFileEvictionWeight,
                stats.activeUsage(),
                stats.evictionWeight(),
                stats.hitCount(),
        final long fullFileEvictionWeight = randomLongBetween(10000, BYTES_IN_GB);
        final long miss = randomLongBetween(0, 10000);
        assertEquals(original.getActive(), deserialized.getActive());
                fullFileRemoveCount,
        builder.startObject();
            new RefCountedCacheStats(
