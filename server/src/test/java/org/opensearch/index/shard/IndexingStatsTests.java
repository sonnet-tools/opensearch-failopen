    public void testMaxLastIndexRequestTimestampAggregation() throws Exception {
                assertEquals(totalStats.getDeleteTime(), deserializedTotalStats.getDeleteTime());
            + totalStats.getThrottleTime().getMillis()
                IndexingStats.Stats deserializedTotalStats = deserializedStats.getTotal();
    }
     * Uses reflection because the field is private and not settable via public API.
        xContentBuilder.startObject();
        }
import org.opensearch.common.io.stream.BytesStreamOutput;
        IndexingStats.Stats stats1 = defaultStats.maxLastIndexRequestTimestamp(ts1).build();
        long ts = randomLongBetween(0, 1000000);
            + totalStats.getDeleteTime().getMillis()
        stats1.add(stats3);
            + ",\"index_current\":"
 * SPDX-License-Identifier: Apache-2.0
        statsZero.add(statsNeg);
        // Test with zero and negative values
    private IndexingStats createTestInstance() {
        String expected = "{\"indexing\":{\"index_total\":"
import java.io.IOException;
     */
                assertEquals(totalStats.getIndexTime(), deserializedTotalStats.getIndexTime());
            .isThrottled(randomBoolean())
        IndexingStats stats = createTestInstance();
            .throttleTimeInMillis(9);
        StreamInput inNew = outNew.bytes().streamInput();
            .maxLastIndexRequestTimestamp(randomLong())
 * The OpenSearch Contributors require contributions made to
            + ",\"delete_time_in_millis\":"
            .indexFailedCount(randomNonNegativeLong())
    }
        StreamInput inOld = outOld.bytes().streamInput();
            + ",\"max_last_index_request_timestamp\":"
            .noopUpdateCount(8)
    public void testMaxLastIndexRequestTimestampBackwardCompatibility() throws IOException {
            + ",\"delete_current\":"
            .indexFailedCount(4)
            + ",\"throttle_time_in_millis\":"
            + totalStats.isThrottled()
            + ",\"index_time_in_millis\":"
        // Serialize with V_3_1_0 (should include the field)
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
     * Tests aggregation logic for maxLastIndexRequestTimestamp in IndexingStats.Stats.
            .deleteTimeInMillis(6)
        long ts3 = randomLongBetween(0, 1000000);
            .build();
import org.opensearch.test.OpenSearchTestCase;
     * This ensures that aggregation (add) always surfaces the maximum value, even across multiple adds and random values.
                    return;
        IndexingStats.Stats stats = new IndexingStats.Stats.Builder().indexCount(1)
            + ",\"index_failed\":"
                assertEquals(totalStats.isThrottled(), deserializedTotalStats.isThrottled());
 *
        // Use explicit values for all fields except the timestamp
            }
            + totalStats.getIndexCount()
import org.opensearch.core.xcontent.ToXContent;
                IndexingStats.Stats totalStats = stats.getTotal();
            .deleteCurrent(randomNonNegativeLong())
        long ts2 = randomLongBetween(0, 1000000);
 * compatible open source license.
            + "}}";
            + totalStats.getMaxLastIndexRequestTimestamp()
        long ts1 = randomLongBetween(0, 1000000);
            .isThrottled(false)
            .deleteCurrent(7)
        IndexingStats stats = createTestInstance();
        assertEquals(Math.max(ts1, ts2), stats1.getMaxLastIndexRequestTimestamp());
            + totalStats.getDeleteCurrent()
            .isThrottled(false)
}
    }
                assertEquals(totalStats.getIndexCount(), deserializedTotalStats.getIndexCount());
            + totalStats.getIndexTime().getMillis()
            .indexCurrent(3)
        stats.writeTo(outNew);
        IndexingStats.Stats statsNeg = defaultStats.maxLastIndexRequestTimestamp(-100L).build();
            .throttleTimeInMillis(9)
        stats1.add(stats2);
            .indexFailedCount(4)
                assertEquals(totalStats.getIndexFailedCount(), deserializedTotalStats.getIndexFailedCount());
            .deleteCount(5)
        IndexingStats.Stats deserializedOld = new IndexingStats.Stats(inOld);
        BytesStreamOutput outNew = new BytesStreamOutput();
            .indexTimeInMillis(randomNonNegativeLong())
        IndexingStats.Stats statsZero = defaultStats.maxLastIndexRequestTimestamp(0L).build();
                assertEquals(totalStats.getIndexCurrent(), deserializedTotalStats.getIndexCurrent());
            + ",\"delete_total\":"
        XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        outNew.setVersion(org.opensearch.Version.V_3_2_0);
    /**
                    assertNull(deserializedStats.getTotal());
            .indexCurrent(randomNonNegativeLong())
        assertEquals(expected, xContentBuilder.toString());
        IndexingStats.Stats.Builder defaultStats = new IndexingStats.Stats.Builder().indexCount(1)
            .deleteCount(randomNonNegativeLong())
        IndexingStats.Stats stats3 = defaultStats.maxLastIndexRequestTimestamp(ts3).build();
        assertEquals(0L, statsZero.getMaxLastIndexRequestTimestamp());
            .deleteTimeInMillis(randomNonNegativeLong())
        assertEquals(0L, deserializedOld.getMaxLastIndexRequestTimestamp());
public class IndexingStatsTests extends OpenSearchTestCase {
        BytesStreamOutput outOld = new BytesStreamOutput();
            + ",\"noop_update_total\":"
            .deleteCurrent(7)
                assertEquals(totalStats.getThrottleTime(), deserializedTotalStats.getThrottleTime());
            .noopUpdateCount(8)
            try (StreamInput in = out.bytes().streamInput()) {
        assertEquals(Math.max(Math.max(ts1, ts2), ts3), stats1.getMaxLastIndexRequestTimestamp());
        assertEquals(-50L, statsNeg.getMaxLastIndexRequestTimestamp());
        assertEquals(ts, deserializedNew.getMaxLastIndexRequestTimestamp());
            + totalStats.getDeleteCount()
            .indexTimeInMillis(2)
        inOld.setVersion(org.opensearch.Version.V_2_11_0);
                assertEquals(totalStats.getDeleteCount(), deserializedTotalStats.getDeleteCount());
        // Aggregate stats1 + stats2
            .indexTimeInMillis(2)
        IndexingStats.Stats stats = new IndexingStats.Stats.Builder().indexCount(randomNonNegativeLong())
            .throttleTimeInMillis(randomNonNegativeLong())
        IndexingStats.Stats totalStats = stats.getTotal();
                }
        // Serialize with V_2_11_0 (should NOT include the field, should default to 0)
    public void testSerialization() throws IOException {
        stats.writeTo(outOld);
        return new IndexingStats(stats);
/*
            + totalStats.getIndexCurrent()
            + ",\"is_throttled\":"
                IndexingStats deserializedStats = new IndexingStats(in);
                if (stats.getTotal() == null) {
                assertEquals(totalStats.getDeleteCurrent(), deserializedTotalStats.getDeleteCurrent());
        IndexingStats.Stats statsNeg2 = defaultStats.maxLastIndexRequestTimestamp(-50L).build();
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .deleteCount(5)
            .build();
            + totalStats.getIndexFailedCount()
        xContentBuilder = stats.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
    }
        IndexingStats.Stats deserializedNew = new IndexingStats.Stats(inNew);
 */
                assertEquals(totalStats.getNoopUpdateCount(), deserializedTotalStats.getNoopUpdateCount());
        IndexingStats.Stats stats2 = defaultStats.maxLastIndexRequestTimestamp(ts2).build();
import org.opensearch.core.xcontent.XContentBuilder;
        // Aggregate stats1 + stats3
            .noopUpdateCount(randomNonNegativeLong())
        xContentBuilder.endObject();
            .deleteTimeInMillis(6)
            .indexCurrent(3)
        outOld.setVersion(org.opensearch.Version.V_2_11_0);
import org.opensearch.core.common.io.stream.StreamInput;
        inNew.setVersion(org.opensearch.Version.V_3_2_0);
        statsNeg.add(statsNeg2);
            + totalStats.getNoopUpdateCount()
    public void testToXContentForIndexingStats() throws IOException {
            stats.writeTo(out);
 * this file be licensed under the Apache-2.0 license or a
            .maxLastIndexRequestTimestamp(ts)
package org.opensearch.index.shard;
