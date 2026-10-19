        CacheStats c = new CacheStats(
        );
        expectThrows(NullPointerException.class, () -> new CacheStats(g, g, null, g));
            new CacheGroupStats(11, 0, 3, 1024, 250_000_000),
        assertTrue(json.contains("\"metadata_cache\""));
    public void testCacheGroupStatsHitRate() {
        expectThrows(NullPointerException.class, () -> new CacheStats(g, g, g, null));  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(json.contains("\"miss_count\":7"));
/*  
        assertTrue(json.contains("\"memory_bytes\":4096"));  
        CacheGroupStats meta = new CacheGroupStats(1, 2, 3, 4, 5);
 *  
    public void testCacheGroupStatsFieldsArePopulated() {
        BytesStreamOutput out = new BytesStreamOutput();
    }  
        CacheGroupStats decoded = new CacheGroupStats(in);
    }  
        CacheGroupStats stats = new CacheGroupStats(6, 7, 8, 9, 10);
        assertEquals(0.0, miss.hitRate(), 0.0);
    }  
        assertEquals(a, b);  
        assertEquals(10.0 / 12.0, hits.hitRate(), 1e-9);
        assertEquals(a.hashCode(), b.hashCode());
        String json = builder.toString();  
            new CacheGroupStats(31, 32, 33, 34, 35),
        assertEquals(0.0, empty.hitRate(), 0.0);
        expectThrows(NullPointerException.class, () -> new CacheStats(g, null, g, g));
        CacheGroupStats offset = new CacheGroupStats(11, 12, 13, 14, 15);
        zero.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertEquals(original, decoded);
        assertEquals("expected size_limit_bytes:0 to appear four times (one per sub-cache)", 4, sizeLimitOccurrences);
        assertTrue(json.contains("\"size_limit_bytes\":100000000"));
        assertSame(offset, c.getOffsetIndexCache());
            new CacheGroupStats(0, 0, 0, 0, 0),
        // All four sub-groups present  
    // ---- CacheGroupStats ----  
            new CacheGroupStats(0, 7, 0, 0, 100_000_000),  
    // ---- CacheStats ----
        StreamInput in = out.bytes().streamInput();  
            new CacheGroupStats(16, 17, 18, 19, 20)  
        // Disabled-cache sentinel: all four size_limit_bytes are 0
        // hit_rate must not be NaN
    public void testCacheGroupStatsWriteableRoundTrip() throws IOException {
        );
            new CacheGroupStats(6, 7, 8, 9, 10),
        assertSame(scoped, c.getColumnIndexCache());  
        builder.startObject();
            new CacheGroupStats(11, 12, 13, 14, 15),
        assertEquals(100_000_000L, g.sizeLimitBytes);
        CacheGroupStats hits = new CacheGroupStats(10, 2, 0, 0, 0);  
 * The OpenSearch Contributors require contributions made to  
            new CacheGroupStats(16, 17, 18, 19, 20)  
        assertTrue(json.contains("\"hit_count\":11"));  
        CacheGroupStats miss = new CacheGroupStats(0, 5, 0, 0, 0);
 *
    }
        // Top-level wrapper
            new CacheGroupStats(1, 2, 3, 4, 5),  
        // Match hit_rate by prefix since the JSON formatting of doubles is not pinned  
        );
import org.opensearch.core.xcontent.ToXContent;
        assertTrue(json.contains("\"column_index_cache\""));  
        XContentBuilder builder = XContentFactory.jsonBuilder();
    public void testCacheStatsEqualsAndHashCode() {  
    }  
        builder.endObject();
        assertTrue(json.contains("\"size_limit_bytes\":64000000"));  
        XContentBuilder builder = XContentFactory.jsonBuilder();
        CacheStats original = new CacheStats(
 * <p>Covers transport serialization round-trip, JSON rendering shape,
package org.opensearch.be.datafusion.stats;
/**
        CacheStats decoded = new CacheStats(in);
        assertNotEquals(a, c);
import org.opensearch.common.io.stream.BytesStreamOutput;
        CacheGroupStats b = new CacheGroupStats(1, 2, 3, 4, 5);  
 */  
        assertTrue(json.contains("\"memory_bytes\":1024"));  
        XContentBuilder builder = XContentFactory.jsonBuilder();
        StreamInput in = out.bytes().streamInput();
        CacheStats c = new CacheStats(meta, stats, scoped, offset);
    }
        CacheStats b = new CacheStats(
        original.writeTo(out);
        CacheStats c = new CacheStats(
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 * Unit tests for {@link CacheStats} and {@link CacheGroupStats}.
        assertTrue(json.contains("\"statistics_cache\""));
            new CacheGroupStats(11, 12, 13, 14, 15),
        expectThrows(NullPointerException.class, () -> new CacheStats(null, g, g, g));  
        String json = builder.toString();
            new CacheGroupStats(1, 2, 3, 4, 5),  
            new CacheGroupStats(11, 12, 13, 14, 15),
    public void testCacheGroupStatsToXContent() throws IOException {
    }
    public void testCacheStatsConstructorRejectsNullSubGroups() {
 * the derived {@code hit_rate}, and equality semantics.
}
        CacheGroupStats g = new CacheGroupStats(10, 2, 5, 4096, 100_000_000);  
        builder.startObject();
        CacheGroupStats a = new CacheGroupStats(1, 2, 3, 4, 5);
    }
    public void testCacheStatsAccessors() {  
        long sizeLimitOccurrences = json.split("\"size_limit_bytes\":0", -1).length - 1;  
        c.toXContent(builder, ToXContent.EMPTY_PARAMS);  
import org.opensearch.test.OpenSearchTestCase;  
            new CacheGroupStats(0, 0, 0, 0, 0)  
        String json = builder.toString();
            new CacheGroupStats(1, 2, 3, 4, 5),  
        CacheGroupStats g = new CacheGroupStats(10, 2, 5, 4096, 100_000_000);  
            new CacheGroupStats(6, 7, 8, 9, 10),
    public void testCacheStatsZeroedRendersAllZeros() throws IOException {
            new CacheGroupStats(16, 17, 18, 19, 20)  
        assertEquals(a.hashCode(), b.hashCode());
        CacheStats zero = new CacheStats(
        CacheStats a = new CacheStats(
        assertEquals(2L, g.missCount);
 * compatible open source license.
        assertTrue(json.contains("\"entry_count\":5"));
        assertTrue(json.contains("\"size_limit_bytes\":250000000"));
        );  
        assertTrue(json.contains("\"hit_count\":10"));
        CacheGroupStats original = new CacheGroupStats(123, 45, 67, 89_012, 250_000_000);  
        CacheGroupStats c = new CacheGroupStats(1, 2, 3, 4, 6);
import org.opensearch.core.xcontent.XContentBuilder;
        CacheGroupStats g = new CacheGroupStats(0, 0, 0, 0, 0);
        assertNotEquals(a, c);
        // c differs only in statisticsCache (sizeLimitBytes 10 → 99)
    public void testCacheStatsToXContentShape() throws IOException {  
        assertEquals(4096L, g.memoryBytes);
        CacheGroupStats pure = new CacheGroupStats(7, 0, 0, 0, 0);
        original.writeTo(out);  
        g.toXContent(builder);  
        CacheGroupStats empty = new CacheGroupStats(0, 0, 0, 0, 0);
public class CacheStatsTests extends OpenSearchTestCase {
        assertEquals(10L, g.hitCount);
    }
            new CacheGroupStats(21, 22, 23, 24, 25),
        assertTrue("expected cache_stats wrapper, got: " + json, json.contains("\"cache_stats\""));
        builder.endObject();
        assertFalse("hit_rate must not be NaN: " + json, json.contains("NaN"));  
        assertTrue(json.contains("\"miss_count\":2"));
        );
        assertEquals(1.0, pure.hitRate(), 0.0);
            new CacheGroupStats(5, 2, 3, 256, 32_000_000)
        assertEquals(original, decoded);  
        assertTrue(json.contains("\"size_limit_bytes\":100000000"));
            new CacheGroupStats(11, 12, 13, 14, 15),  
        assertTrue(json.contains("\"size_limit_bytes\":32000000"));
        BytesStreamOutput out = new BytesStreamOutput();
        builder.startObject();  
        );
    public void testCacheStatsWriteableRoundTrip() throws IOException {
            new CacheGroupStats(5, 1, 2, 512, 64_000_000),
    public void testCacheGroupStatsEqualsAndHashCode() {
        // Per-group fields
        // No traffic must yield 0.0, not NaN  
        assertEquals(a, b);  
        assertEquals(5L, g.entryCount);  
        assertSame(stats, c.getStatisticsCache());
 */  
            new CacheGroupStats(0, 0, 0, 0, 0),
    }
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.common.xcontent.XContentFactory;
        assertTrue(json.contains("\"entry_count\":3"));
        assertSame(meta, c.getMetadataCache());
            new CacheGroupStats(0, 0, 0, 0, 0),  
        assertTrue("expected hit_rate ≈ 10/12, got: " + json, json.contains("\"hit_rate\":0.833"));
        builder.endObject();
            new CacheGroupStats(6, 7, 8, 9, 99),
        assertTrue(json.contains("\"offset_index_cache\""));
        CacheGroupStats scoped = new CacheGroupStats(11, 12, 13, 14, 15);  
            new CacheGroupStats(41, 42, 43, 44, 45)  
    }  
