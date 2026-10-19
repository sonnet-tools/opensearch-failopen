        CacheStats decoded = new CacheStats(in);
        CacheGroupStats c = new CacheGroupStats(1, 2, 3, 4, 6);
/**
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(a, b);
        CacheGroupStats original = new CacheGroupStats(123, 45, 67, 89_012, 250_000_000);
    }
        CacheGroupStats hits = new CacheGroupStats(10, 2, 0, 0, 0);
        assertNotEquals(a, c);
        assertTrue(json.contains("\"size_limit_bytes\":100000000"));
            new CacheGroupStats(1, 2, 3, 4, 5),
        CacheGroupStats meta = new CacheGroupStats(1, 2, 3, 4, 5);
        CacheGroupStats a = new CacheGroupStats(1, 2, 3, 4, 5);
        expectThrows(NullPointerException.class, () -> new CacheStats(null, g, g, g));
        // No traffic must yield 0.0, not NaN
        long sizeLimitOccurrences = json.split("\"size_limit_bytes\":0", -1).length - 1;
        assertTrue(json.contains("\"column_index_cache\""));
        assertTrue(json.contains("\"hit_count\":10"));
        CacheGroupStats g = new CacheGroupStats(10, 2, 5, 4096, 100_000_000);
    }
        expectThrows(NullPointerException.class, () -> new CacheStats(g, g, null, g));
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.be.datafusion.stats;
        c.toXContent(builder, ToXContent.EMPTY_PARAMS);
            new CacheGroupStats(0, 7, 0, 0, 100_000_000),
            new CacheGroupStats(0, 0, 0, 0, 0),
public class CacheStatsTests extends OpenSearchTestCase {
            new CacheGroupStats(31, 32, 33, 34, 35),
            new CacheGroupStats(11, 12, 13, 14, 15),
        assertEquals(1.0, pure.hitRate(), 0.0);
        assertTrue(json.contains("\"memory_bytes\":1024"));
            new CacheGroupStats(21, 22, 23, 24, 25),
        );
        assertEquals(original, decoded);
        String json = builder.toString();
        // c differs only in statisticsCache (sizeLimitBytes 10 → 99)
        CacheStats b = new CacheStats(
        CacheGroupStats offset = new CacheGroupStats(11, 12, 13, 14, 15);
    public void testCacheGroupStatsFieldsArePopulated() {
            new CacheGroupStats(11, 12, 13, 14, 15),
        );
        assertEquals(0.0, empty.hitRate(), 0.0);
        g.toXContent(builder);
        original.writeTo(out);
        assertEquals(a.hashCode(), b.hashCode());
        assertTrue(json.contains("\"size_limit_bytes\":250000000"));
        CacheGroupStats pure = new CacheGroupStats(7, 0, 0, 0, 0);
            new CacheGroupStats(41, 42, 43, 44, 45)
        BytesStreamOutput out = new BytesStreamOutput();
        CacheStats c = new CacheStats(meta, stats, scoped, offset);
            new CacheGroupStats(11, 0, 3, 1024, 250_000_000),
import java.io.IOException;
}
        assertTrue(json.contains("\"size_limit_bytes\":32000000"));
            new CacheGroupStats(16, 17, 18, 19, 20)
        assertFalse("hit_rate must not be NaN: " + json, json.contains("NaN"));
        expectThrows(NullPointerException.class, () -> new CacheStats(g, g, g, null));
        expectThrows(NullPointerException.class, () -> new CacheStats(g, null, g, g));
        assertTrue(json.contains("\"offset_index_cache\""));
import org.opensearch.common.xcontent.XContentFactory;
            new CacheGroupStats(6, 7, 8, 9, 99),
        assertEquals(0.0, miss.hitRate(), 0.0);
        CacheGroupStats empty = new CacheGroupStats(0, 0, 0, 0, 0);
        // Match hit_rate by prefix since the JSON formatting of doubles is not pinned
        assertEquals(10.0 / 12.0, hits.hitRate(), 1e-9);
 * Unit tests for {@link CacheStats} and {@link CacheGroupStats}.
            new CacheGroupStats(16, 17, 18, 19, 20)
        // hit_rate must not be NaN
 * The OpenSearch Contributors require contributions made to
    public void testCacheStatsConstructorRejectsNullSubGroups() {
        assertSame(offset, c.getOffsetIndexCache());
    }
 * compatible open source license.
            new CacheGroupStats(5, 2, 3, 256, 32_000_000)
    }
        assertEquals(4096L, g.memoryBytes);
        builder.startObject();
        CacheGroupStats decoded = new CacheGroupStats(in);
        original.writeTo(out);
        );
import org.opensearch.core.xcontent.ToXContent;
        StreamInput in = out.bytes().streamInput();
    public void testCacheGroupStatsHitRate() {
            new CacheGroupStats(16, 17, 18, 19, 20)
        builder.startObject();
        CacheGroupStats b = new CacheGroupStats(1, 2, 3, 4, 5);
        // All four sub-groups present
        // Disabled-cache sentinel: all four size_limit_bytes are 0
    public void testCacheGroupStatsWriteableRoundTrip() throws IOException {
        zero.toXContent(builder, ToXContent.EMPTY_PARAMS);
        // Per-group fields
        XContentBuilder builder = XContentFactory.jsonBuilder();
        String json = builder.toString();
    }
            new CacheGroupStats(11, 12, 13, 14, 15),
        assertEquals(100_000_000L, g.sizeLimitBytes);
        assertEquals("expected size_limit_bytes:0 to appear four times (one per sub-cache)", 4, sizeLimitOccurrences);
        assertTrue(json.contains("\"metadata_cache\""));
        assertTrue(json.contains("\"memory_bytes\":4096"));
        CacheStats original = new CacheStats(
        CacheStats c = new CacheStats(
        CacheStats c = new CacheStats(
    public void testCacheStatsEqualsAndHashCode() {
 *
        assertTrue(json.contains("\"entry_count\":3"));
    public void testCacheGroupStatsToXContent() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        assertNotEquals(a, c);
    }
        CacheStats zero = new CacheStats(
        CacheGroupStats g = new CacheGroupStats(10, 2, 5, 4096, 100_000_000);
        assertSame(scoped, c.getColumnIndexCache());
        builder.startObject();
 *
        CacheGroupStats miss = new CacheGroupStats(0, 5, 0, 0, 0);
        assertEquals(a, b);
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
        assertTrue("expected cache_stats wrapper, got: " + json, json.contains("\"cache_stats\""));
            new CacheGroupStats(1, 2, 3, 4, 5),
        assertEquals(5L, g.entryCount);
        builder.endObject();
        String json = builder.toString();
    }
        CacheGroupStats g = new CacheGroupStats(0, 0, 0, 0, 0);
            new CacheGroupStats(1, 2, 3, 4, 5),
            new CacheGroupStats(5, 1, 2, 512, 64_000_000),
        assertEquals(2L, g.missCount);
        );
        assertTrue(json.contains("\"entry_count\":5"));
            new CacheGroupStats(0, 0, 0, 0, 0),
            new CacheGroupStats(0, 0, 0, 0, 0),
    public void testCacheGroupStatsEqualsAndHashCode() {
        CacheGroupStats scoped = new CacheGroupStats(11, 12, 13, 14, 15);
            new CacheGroupStats(6, 7, 8, 9, 10),
        assertEquals(10L, g.hitCount);
        assertTrue(json.contains("\"hit_count\":11"));
        assertTrue("expected hit_rate ≈ 10/12, got: " + json, json.contains("\"hit_rate\":0.833"));
        BytesStreamOutput out = new BytesStreamOutput();
        assertTrue(json.contains("\"size_limit_bytes\":100000000"));
            new CacheGroupStats(6, 7, 8, 9, 10),
    public void testCacheStatsToXContentShape() throws IOException {
    }
        builder.endObject();
    }
        CacheStats a = new CacheStats(
    }
 * the derived {@code hit_rate}, and equality semantics.
        assertTrue(json.contains("\"statistics_cache\""));
        );
import org.opensearch.test.OpenSearchTestCase;
        assertSame(stats, c.getStatisticsCache());
        StreamInput in = out.bytes().streamInput();
            new CacheGroupStats(11, 12, 13, 14, 15),
        builder.endObject();
    // ---- CacheStats ----
import org.opensearch.core.xcontent.XContentBuilder;
/*
    public void testCacheStatsZeroedRendersAllZeros() throws IOException {
        assertTrue(json.contains("\"miss_count\":7"));
        assertTrue(json.contains("\"size_limit_bytes\":64000000"));
 */
            new CacheGroupStats(0, 0, 0, 0, 0)
        XContentBuilder builder = XContentFactory.jsonBuilder();
        // Top-level wrapper
        assertSame(meta, c.getMetadataCache());
import org.opensearch.core.common.io.stream.StreamInput;
        assertEquals(a.hashCode(), b.hashCode());
    public void testCacheStatsWriteableRoundTrip() throws IOException {
        CacheGroupStats stats = new CacheGroupStats(6, 7, 8, 9, 10);
    public void testCacheStatsAccessors() {
        assertTrue(json.contains("\"miss_count\":2"));
 * <p>Covers transport serialization round-trip, JSON rendering shape,
    // ---- CacheGroupStats ----
 */
        );
        assertEquals(original, decoded);
