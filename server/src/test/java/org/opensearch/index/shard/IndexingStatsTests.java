            + ",\"index_time_in_millis\":"
            + ",\"max_last_index_request_timestamp\":"
                assertEquals(totalStats.getDeleteCount(), deserializedTotalStats.getDeleteCount());  
                assertEquals(totalStats.getIndexTime(), deserializedTotalStats.getIndexTime());  
            + ",\"delete_total\":"
        IndexingStats.Stats stats3 = defaultStats.maxLastIndexRequestTimestamp(ts3).build();  
            + totalStats.getDeleteTime().getMillis()
            + "}}";  
        IndexingStats.Stats totalStats = stats.getTotal();  
        // Use explicit values for all fields except the timestamp
            .deleteTimeInMillis(6)
            .maxLastIndexRequestTimestamp(ts)
    public void testMaxLastIndexRequestTimestampBackwardCompatibility() throws IOException {
        inOld.setVersion(org.opensearch.Version.V_2_11_0);  
        IndexingStats.Stats stats2 = defaultStats.maxLastIndexRequestTimestamp(ts2).build();
            try (StreamInput in = out.bytes().streamInput()) {  
        long ts1 = randomLongBetween(0, 1000000);
            .indexFailedCount(4)  
        long ts2 = randomLongBetween(0, 1000000);  
    }
                IndexingStats deserializedStats = new IndexingStats(in);
    public void testSerialization() throws IOException {  
            + totalStats.isThrottled()
    }
        return new IndexingStats(stats);
    }
        StreamInput inNew = outNew.bytes().streamInput();
    }
            + ",\"is_throttled\":"  
        BytesStreamOutput outNew = new BytesStreamOutput();
        IndexingStats.Stats deserializedNew = new IndexingStats.Stats(inNew);
        IndexingStats.Stats statsNeg2 = defaultStats.maxLastIndexRequestTimestamp(-50L).build();
                assertEquals(totalStats.isThrottled(), deserializedTotalStats.isThrottled());
            .deleteCurrent(randomNonNegativeLong())  
            + totalStats.getIndexFailedCount()  
            .indexTimeInMillis(2)
            .deleteCount(randomNonNegativeLong())
                assertEquals(totalStats.getIndexCount(), deserializedTotalStats.getIndexCount());
        statsZero.add(statsNeg);
import org.opensearch.test.OpenSearchTestCase;  
        xContentBuilder.endObject();
            + totalStats.getDeleteCount()
            .noopUpdateCount(8)
        inNew.setVersion(org.opensearch.Version.V_3_2_0);  
            }  
        assertEquals(Math.max(ts1, ts2), stats1.getMaxLastIndexRequestTimestamp());
        assertEquals(Math.max(Math.max(ts1, ts2), ts3), stats1.getMaxLastIndexRequestTimestamp());
                IndexingStats.Stats deserializedTotalStats = deserializedStats.getTotal();  
     * Tests aggregation logic for maxLastIndexRequestTimestamp in IndexingStats.Stats.
 * this file be licensed under the Apache-2.0 license or a
            + totalStats.getMaxLastIndexRequestTimestamp()
package org.opensearch.index.shard;
            .deleteTimeInMillis(6)
            .deleteCount(5)
            .isThrottled(false)
            + ",\"delete_current\":"
            .noopUpdateCount(randomNonNegativeLong())
        long ts = randomLongBetween(0, 1000000);
                assertEquals(totalStats.getIndexCurrent(), deserializedTotalStats.getIndexCurrent());
        IndexingStats stats = createTestInstance();
        IndexingStats.Stats statsZero = defaultStats.maxLastIndexRequestTimestamp(0L).build();
            .throttleTimeInMillis(9);  
            stats.writeTo(out);
        IndexingStats.Stats stats1 = defaultStats.maxLastIndexRequestTimestamp(ts1).build();
            + totalStats.getIndexCurrent()
            + ",\"index_failed\":"
            + totalStats.getDeleteCurrent()  
        IndexingStats.Stats deserializedOld = new IndexingStats.Stats(inOld);
        assertEquals(0L, statsZero.getMaxLastIndexRequestTimestamp());  
/*  
            .indexCurrent(3)
        assertEquals(expected, xContentBuilder.toString());
    public void testToXContentForIndexingStats() throws IOException {
}
        outOld.setVersion(org.opensearch.Version.V_2_11_0);  
     * This ensures that aggregation (add) always surfaces the maximum value, even across multiple adds and random values.
            + ",\"noop_update_total\":"
 *
            + ",\"throttle_time_in_millis\":"
        BytesStreamOutput outOld = new BytesStreamOutput();
        xContentBuilder.startObject();  
            .throttleTimeInMillis(9)  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(-50L, statsNeg.getMaxLastIndexRequestTimestamp());
                }  
                assertEquals(totalStats.getDeleteCurrent(), deserializedTotalStats.getDeleteCurrent());
                    return;
        // Aggregate stats1 + stats2
                assertEquals(totalStats.getThrottleTime(), deserializedTotalStats.getThrottleTime());
            .indexFailedCount(4)  
            + ",\"delete_time_in_millis\":"  
                    assertNull(deserializedStats.getTotal());
        assertEquals(0L, deserializedOld.getMaxLastIndexRequestTimestamp());
        stats.writeTo(outOld);
        IndexingStats.Stats stats = new IndexingStats.Stats.Builder().indexCount(1)  
        IndexingStats.Stats.Builder defaultStats = new IndexingStats.Stats.Builder().indexCount(1)  
                assertEquals(totalStats.getNoopUpdateCount(), deserializedTotalStats.getNoopUpdateCount());  
            .deleteTimeInMillis(randomNonNegativeLong())
            .maxLastIndexRequestTimestamp(randomLong())
     * Uses reflection because the field is private and not settable via public API.  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
public class IndexingStatsTests extends OpenSearchTestCase {
            .indexCurrent(3)
            + ",\"index_current\":"  
 */  
        StreamInput inOld = outOld.bytes().streamInput();
            .isThrottled(false)
        // Aggregate stats1 + stats3  
 * The OpenSearch Contributors require contributions made to  
        IndexingStats.Stats stats = new IndexingStats.Stats.Builder().indexCount(randomNonNegativeLong())  
    public void testMaxLastIndexRequestTimestampAggregation() throws Exception {  
        // Serialize with V_2_11_0 (should NOT include the field, should default to 0)
        outNew.setVersion(org.opensearch.Version.V_3_2_0);  
 * compatible open source license.
        XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            .indexFailedCount(randomNonNegativeLong())  
        xContentBuilder = stats.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
            .indexTimeInMillis(2)
            + totalStats.getIndexCount()  
import org.opensearch.core.xcontent.XContentBuilder;
            .isThrottled(randomBoolean())
        // Test with zero and negative values
            .throttleTimeInMillis(randomNonNegativeLong())  
import org.opensearch.common.io.stream.BytesStreamOutput;
            .indexTimeInMillis(randomNonNegativeLong())
            .indexCurrent(randomNonNegativeLong())
        // Serialize with V_3_1_0 (should include the field)
        IndexingStats stats = createTestInstance();
        String expected = "{\"indexing\":{\"index_total\":"
import java.io.IOException;
        IndexingStats.Stats statsNeg = defaultStats.maxLastIndexRequestTimestamp(-100L).build();  
            .deleteCurrent(7)  
                assertEquals(totalStats.getDeleteTime(), deserializedTotalStats.getDeleteTime());
            + totalStats.getIndexTime().getMillis()
    }  
        stats1.add(stats2);  
                if (stats.getTotal() == null) {  
        }
     */
        assertEquals(ts, deserializedNew.getMaxLastIndexRequestTimestamp());
    /**
        stats1.add(stats3);
            + totalStats.getThrottleTime().getMillis()  
        stats.writeTo(outNew);
            + totalStats.getNoopUpdateCount()
            .noopUpdateCount(8)
                assertEquals(totalStats.getIndexFailedCount(), deserializedTotalStats.getIndexFailedCount());
            .deleteCount(5)
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.ToXContent;
            .deleteCurrent(7)  
        long ts3 = randomLongBetween(0, 1000000);
            .build();
    private IndexingStats createTestInstance() {
            .build();
        statsNeg.add(statsNeg2);  
                IndexingStats.Stats totalStats = stats.getTotal();
