        assertEquals(original.getActivePercent(), deserialized.getActivePercent());
        final long fullFileRemoveCount = randomLongBetween(0, 10000);
                stats.activeUsage(),  
    public static AggregateRefCountedCacheStats getMockCacheStats() {
        return new AggregateFileCacheStats(
            }  
            fileCacheStats.writeTo(out);
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
        return getFileCacheStats(fcSize, getMockCacheStats());
                stats.evictionWeight(),
                fullFileUsage,  
        throws IOException {
        assertEquals(original.getCacheHits(), deserialized.getCacheHits());  
                fullFileHitCount,
                fullFileRemoveCount,
            new RefCountedCacheStats(
    public static AggregateFileCacheStats getMockFileCacheStats() throws IOException {  
        final long evicted = randomLongBetween(0, getMockCacheStats().getFullFileCacheStats().evictionWeight());
        deserializedBuilder.endObject();  
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(original.getTotal(), deserialized.getTotal());
    public static FileCacheStats getMockFullFileCacheStats() {  
                fullFileRemoveCount,
        final long activeUsage = randomLongBetween(10000, BYTES_IN_GB);  
    }  
        final long pinnedUsage = randomLongBetween(10000, BYTES_IN_GB);
                stats.hitCount(),
                fullFileUsage,  
                stats.missCount(),
        assertEquals(original.getOverallActivePercent(), deserialized.getOverallActivePercent(), 0.0);
                FileCacheStatsType.PINNED_FILE_STATS
 * SPDX-License-Identifier: Apache-2.0
        final long evicted = randomLongBetween(10000, BYTES_IN_GB);
    }  
                fullFileActiveUsage,
        final long hit = randomLongBetween(0, 10);
                fullFileReplaceCount,  
                FileCacheStatsType.OVER_ALL_STATS
        final long total = randomLongBetween(100000, BYTES_IN_GB);
                stats.hitCount(),  
            try (StreamInput in = out.bytes().streamInput()) {  
                fileCacheCapacity,  
                fullFileEvictionWeight,
                fullFileReplaceCount,  
        assertEquals(original.getActive(), deserialized.getActive());
        return randomLongBetween(10 * BYTES_IN_GB, 1000 * BYTES_IN_GB);  
                stats.pinnedUsage(),  
        assertEquals(original.getActive(), deserialized.getActive());
                stats.hitCount(),
        final long misses = randomLongBetween(0, 10);
        final long used = randomLongBetween(100000, BYTES_IN_GB);  
        final long active = randomLongBetween(100000, BYTES_IN_GB);
                pinnedUsage
            new FileCacheStats(
                stats.removeWeight(),
            ),  
        assertEquals(original.getUsed(), deserialized.getUsed());  
        assertEquals(original.getCacheMisses(), deserialized.getCacheMisses());
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
}  
                stats.usage(),
            System.currentTimeMillis(),  
        final long fullFileEvictionWeight = randomLongBetween(10000, BYTES_IN_GB);  
            new FileCacheStats(  
            ),
        final long fcSize = getMockCacheCapacity();
                stats.pinnedUsage(),
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;  
                fullFileReplaceCount,  
            )
                stats.pinnedUsage(),
        XContentBuilder deserializedBuilder = XContentFactory.jsonBuilder();  
import org.opensearch.core.xcontent.ToXContent;
            ),  
import org.opensearch.test.OpenSearchTestCase;  
                validateFileCacheStats(fileCacheStats, new AggregateFileCacheStats(in));
                FileCacheStatsType.BLOCK_FILE_STATS
                stats.usage(),
                fullFileActiveUsage,
                fileCacheCapacity,  
    }
                fullFileEvictionCount,
                stats.activeUsage(),
        deserializedBuilder = deserialized.toXContent(deserializedBuilder, ToXContent.EMPTY_PARAMS);
        builder.startObject();
        final long fullFileRemoveWeight = randomLongBetween(10000, BYTES_IN_GB);  
        final long fullFileReplaceCount = randomLongBetween(0, 10000);
                stats.removeWeight(),  
                fullFileRemoveCount,
    }  
                stats.pinnedUsage(),
            new RefCountedCacheStats(hits, miss, 0, removed, replaced, 0, evicted, usage, activeUsage, pinnedUsage),  
                fullFileRemoveWeight,
                stats.usage(),
    public static AggregateFileCacheStats getFileCacheStats(final long fileCacheCapacity, final AggregateRefCountedCacheStats stats)  
        return new AggregateRefCountedCacheStats(
 *
import org.opensearch.common.xcontent.XContentFactory;
        final long pinned = randomLongBetween(100000, BYTES_IN_GB);
import org.opensearch.index.store.remote.utils.cache.stats.RefCountedCacheStats;
        final long replaced = randomLongBetween(0, 10000);
        builder.endObject();
        assertEquals(original.getEvicted(), deserialized.getEvicted());
                stats.evictionWeight(),  
        builder = original.toXContent(builder, ToXContent.EMPTY_PARAMS);  
            new RefCountedCacheStats(
                fullFileEvictionWeight,
                FileCacheStatsType.FULL_FILE_STATS  
                fullFileActiveUsage,
            ),
        assertEquals(original.getUsedPercent(), deserialized.getUsedPercent());
        assertEquals(original.getEvicted(), deserialized.getEvicted());  
                stats.removeWeight(),
                fullFileEvictionWeight,
        final long hits = randomLongBetween(0, 10000);
import org.opensearch.index.store.remote.utils.cache.stats.AggregateRefCountedCacheStats;
            )  
        final long fullFileHitCount = randomLongBetween(0, 10000);
        final AggregateFileCacheStats fileCacheStats = getMockFileCacheStats();  
        final long usage = randomLongBetween(10000, BYTES_IN_GB);
            new FileCacheStats(
                fullFileEvictionCount,
        assertEquals(original.getUsed(), deserialized.getUsed());
        final long miss = randomLongBetween(0, 10000);  
                stats.missCount(),  
                stats.missCount(),
        assertEquals(original.getHits(), deserialized.getHits());  
public class AggregateFileCacheStatsTests extends OpenSearchTestCase {
        final long fullFileEvictionCount = randomLongBetween(0, 10000);
                stats.hitCount(),
                fullFileHitCount,
            new FileCacheStats(
    }
        deserializedBuilder.startObject();
/*  
    }
    }
        assertEquals(original.getActivePercent(), deserialized.getActivePercent());  
        assertEquals(original.getTimestamp(), deserialized.getTimestamp());
                0,  
        return new FileCacheStats(active, total, used, pinned, evicted, removed, hit, misses, FileCacheStatsType.OVER_ALL_STATS);  
    private static final long BYTES_IN_GB = 1024 * 1024 * 1024;
    public static void validateFileCacheStats(AggregateFileCacheStats original, AggregateFileCacheStats deserialized) throws IOException {
                pinnedUsage
        assertTrue(builder.toString().equals(deserializedBuilder.toString()));
    public static long getMockCacheCapacity() {
        final long fullFileActiveUsage = randomLongBetween(0, 10000);
                fullFileRemoveWeight,
        final long fullFileUsage = randomLongBetween(0, 10000);
                0,  
                fileCacheCapacity,
                stats.evictionWeight(),  
import org.opensearch.core.common.io.stream.StreamInput;  
                // Validate original object against deserialized values
        final long removed = randomLongBetween(0, 10);  
                stats.removeWeight(),
            new RefCountedCacheStats(
        XContentBuilder builder = XContentFactory.jsonBuilder();
                stats.activeUsage(),
                stats.missCount(),  
    public void testFileCacheStatsSerialization() throws IOException {
                stats.usage(),  
                fileCacheCapacity,
 * this file be licensed under the Apache-2.0 license or a
            ),  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public static void validateFullFileStats(FileCacheStats original, FileCacheStats deserialized) {
                fullFileUsage,  
                stats.evictionWeight(),
    }
                fullFileRemoveWeight,
                stats.activeUsage(),
package org.opensearch.index.store.remote.filecache;
        );  
        final long removed = randomLongBetween(10000, BYTES_IN_GB);  
                0,  
 */  
        );
                fullFileHitCount,
        }
                pinnedUsage
                fullFileEvictionCount,
