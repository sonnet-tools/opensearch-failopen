/*  
        Map<String, Object> pool = poolBlock(stats);
            builder.endObject();
    private static Map<String, Object> toMap(ParquetIngestPoolStats stats) {
        }
        assertEquals(100L, ((Number) pool.get("completed")).longValue());
    }
 * this file be licensed under the Apache-2.0 license or a
/** Unit tests for {@link ParquetIngestPoolStats}: XContent shape, stream round-trip, factory. */  
import org.opensearch.common.xcontent.XContentFactory;
        assertNull(ParquetIngestPoolStats.from(null));
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
        assertEquals(3, ((Number) pool.get("active")).intValue());
        ParquetIngestPoolStats stats = ParquetIngestPoolStats.from(s);
 */  
 *
import org.opensearch.core.xcontent.ToXContent;  
            .largest(20)
    }  
import org.opensearch.threadpool.ThreadPoolStats;
    }
    public void testToXContentShape() {  
    public void testStreamRoundTrip() throws Exception {
            .active(3)  
        original.writeTo(out);
            assertEquals(toMap(original), toMap(restored));
        BytesStreamOutput out = new BytesStreamOutput();  
        assertEquals(12, ((Number) pool.get("queue_depth")).intValue());
        return (Map<String, Object>) toMap(stats).get("native_ingest_pool");
    @SuppressWarnings("unchecked")  
            .completed(100L)  
import org.opensearch.common.xcontent.XContentHelper;  
            .build();
import org.opensearch.common.io.stream.BytesStreamOutput;
            return XContentHelper.convertToMap(JsonXContent.jsonXContent, builder.toString(), true);  
            stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            ParquetIngestPoolStats restored = new ParquetIngestPoolStats(in);  
            .queue(12)
        Map<String, Object> pool = (Map<String, Object>) json.get("native_ingest_pool");
 * compatible open source license.
        ThreadPoolStats.Stats s = new ThreadPoolStats.Stats.Builder().name("parquet_native_write")  
}
        assertEquals(12, ((Number) pool.get("queue_depth")).intValue());
            .rejected(7L)
public class ParquetIngestPoolStatsTests extends OpenSearchTestCase {
        } catch (Exception e) {
        assertNotNull("native_ingest_pool block must be present", pool);
            var builder = XContentFactory.jsonBuilder().startObject();  
            throw new AssertionError(e);
        ParquetIngestPoolStats original = new ParquetIngestPoolStats(2, 5, 1, 9L, 42L);
        }  
        @SuppressWarnings("unchecked")  
package org.opensearch.parquet.stats;
        try (StreamInput in = out.bytes().streamInput()) {
        Map<String, Object> json = toMap(stats);
            .threads(4)
    public void testFromNullReturnsNull() {  
import org.opensearch.common.xcontent.json.JsonXContent;
    private static Map<String, Object> poolBlock(ParquetIngestPoolStats stats) {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.common.io.stream.StreamInput;
    }  
        assertNotNull(stats);  
        assertEquals(7L, ((Number) pool.get("rejected")).longValue());  
        assertEquals(4, ((Number) pool.get("threads")).intValue());  
    }
        ParquetIngestPoolStats stats = new ParquetIngestPoolStats(4, 12, 3, 7L, 100L);
        try {
        assertEquals(7L, ((Number) pool.get("rejected")).longValue());  
    }
    public void testFromThreadPoolStats() {
