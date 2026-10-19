        stats.add(5, 100, 2, 1024, 2048, 50, 75, 3);
        assertTrue(json.contains("total_bytes_received"));
        assertEquals(original.getTotalSendTime().millis(), deserialized.getTotalSendTime().millis());
        stats.add(5, 100, 2, 1024, 2048, 50, 75, 3);  
    public void testAddTotalsWithNull() {
        assertEquals(75, stats.getTotalReceiveTime().millis());  
        StreamInput in = bytes.streamInput();  
        MergedSegmentWarmerStats stats = new MergedSegmentWarmerStats();
        XContentBuilder builder = XContentFactory.jsonBuilder();
        stats.addTotals(null);  
        assertEquals(0, stats.getTotalFailureCount());  
        assertEquals(3, stats1.getTotalFailureCount());
        assertEquals(0, stats.getOngoingCount());
        assertEquals(105, stats1.getTotalReceiveTime().millis());
    }
        MergedSegmentWarmerStats stats = new MergedSegmentWarmerStats();
        stats1.addTotals(stats2);
package org.opensearch.index.merge;
        assertEquals(new TimeValue(50), stats.getTotalSendTime());
    public void testToXContent() throws IOException {
    public void testDefaultConstructor() {
        assertEquals(0, stats.getTotalTime().getMillis());
        stats1.add(5, 100, 2, 1024, 2048, 50, 75, 3);  
        assertEquals(5, stats.getTotalInvocationsCount());  
        original.add(5, 100, 2, 1024, 2048, 50, 75, 3);  
    public void testAddMultiple() {
        MergedSegmentWarmerStats original = new MergedSegmentWarmerStats();
        assertEquals(0, stats.getTotalReceivedSize().getBytes());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.bytes.BytesReference;
 * The OpenSearch Contributors require contributions made to  
        MergedSegmentWarmerStats stats2 = new MergedSegmentWarmerStats();
        assertEquals(105, stats.getTotalReceiveTime().millis());  
        MergedSegmentWarmerStats stats = new MergedSegmentWarmerStats();  
        assertTrue(json.contains("total_time_millis"));
        stats.add(5, 100, 2, 1024, 2048, 50, 75, 3);
    public void testAdd() {
}
        assertEquals(75, stats1.getTotalSendTime().millis());
    }  
 */  
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
 * compatible open source license.
        stats.add(3, 50, 1, 512, 1024, 25, 30, 1);
        assertEquals(3, stats.getOngoingCount());
        assertEquals(original.getTotalReceiveTime().millis(), deserialized.getTotalReceiveTime().millis());  
        stats.toXContent(builder, null);
import java.io.IOException;
        assertEquals(75, stats.getTotalSendTime().millis());
        assertEquals(1536, stats1.getTotalSentSize().getBytes());
        assertEquals(4, stats1.getOngoingCount());  
        assertTrue(json.contains("total_receive_time_millis"));  
import org.opensearch.common.unit.TimeValue;
        assertTrue(json.contains("total_invocations_count"));  
        assertEquals(150, stats.getTotalTime().getMillis());
        assertEquals(100, stats.getTotalTime().getMillis());
import org.opensearch.common.xcontent.XContentFactory;  
public class MergedSegmentWarmerStatsTests extends OpenSearchTestCase {  
        MergedSegmentWarmerStats stats2 = new MergedSegmentWarmerStats();
        BytesReference bytes = out.bytes();
    }
        MergedSegmentWarmerStats deserialized = new MergedSegmentWarmerStats(in);
    public void testSerialization() throws IOException {
    }
import org.opensearch.core.xcontent.XContentBuilder;
        assertTrue(json.contains("warmer"));
        assertEquals(8, stats1.getTotalInvocationsCount());
        assertEquals(0, stats.getTotalSendTime().millis());  
        MergedSegmentWarmerStats stats = new MergedSegmentWarmerStats();  
        MergedSegmentWarmerStats stats = new MergedSegmentWarmerStats();
        assertEquals(1536, stats.getTotalSentSize().getBytes());  
        assertEquals(150, stats1.getTotalTime().getMillis());  
        original.writeTo(out);  
/*  
        assertTrue(json.contains("total_bytes_sent"));  
        builder.startObject();  
        assertEquals(5, stats.getTotalInvocationsCount());
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(json.contains("total_failure_count"));
        assertEquals(2, stats.getTotalFailureCount());
        String json = builder.toString();
        assertEquals(1024, stats.getTotalSentSize().getBytes());  
        stats.add(5, 100, 2, 1024, 2048, 50, 75, 3);  
        assertEquals(4, stats.getOngoingCount());
        assertEquals(original.getTotalReceivedSize().getBytes(), deserialized.getTotalReceivedSize().getBytes());
        assertEquals(3, stats.getTotalFailureCount());
        assertEquals(3072, stats.getTotalReceivedSize().getBytes());
import org.opensearch.test.OpenSearchTestCase;
    }
        assertEquals(8, stats.getTotalInvocationsCount());  
        assertEquals(new TimeValue(75), stats.getTotalReceiveTime());
        assertEquals(3, stats.getOngoingCount());  
        stats2.add(3, 50, 1, 512, 1024, 25, 30, 1);  
        assertEquals(0, stats.getTotalSentSize().getBytes());
        assertEquals(5, stats.getTotalInvocationsCount());
    }  
        MergedSegmentWarmerStats stats1 = new MergedSegmentWarmerStats();
        MergedSegmentWarmerStats stats1 = new MergedSegmentWarmerStats();
        stats1.add(5, 100, 2, 1024, 2048, 50, 75, 3);
        builder.endObject();
        stats2.add(3, 50, 1, 512, 1024, 25, 30, 1);
    public void testAddTotals() {  
        BytesStreamOutput out = new BytesStreamOutput();
    public void testAddStats() {
        assertEquals(2048, stats.getTotalReceivedSize().getBytes());
        assertEquals(original.getTotalFailureCount(), deserialized.getTotalFailureCount());
        stats1.add(stats2);
        assertEquals(2, stats.getTotalFailureCount());
        MergedSegmentWarmerStats stats = new MergedSegmentWarmerStats();  
    public void testGetters() {
        assertEquals(50, stats.getTotalSendTime().millis());
        assertEquals(original.getTotalInvocationsCount(), deserialized.getTotalInvocationsCount());  
    }
        assertEquals(0, stats.getTotalReceiveTime().millis());
        assertTrue(json.contains("ongoing_count"));
        stats.add(5, 100, 2, 1024, 2048, 50, 75, 3);  
        assertEquals(original.getTotalTime().getMillis(), deserialized.getTotalTime().getMillis());
        assertEquals(new ByteSizeValue(2048), stats.getTotalReceivedSize());  
import org.opensearch.core.common.io.stream.StreamInput;
        assertEquals(new ByteSizeValue(1024), stats.getTotalSentSize());
        assertEquals(new TimeValue(100), stats.getTotalTime());  
        assertEquals(original.getOngoingCount(), deserialized.getOngoingCount());
 *
import org.opensearch.core.common.unit.ByteSizeValue;  
        assertEquals(3072, stats1.getTotalReceivedSize().getBytes());  
        assertEquals(original.getTotalSentSize().getBytes(), deserialized.getTotalSentSize().getBytes());  
    }
        assertEquals(0, stats.getTotalInvocationsCount());
        assertTrue(json.contains("total_send_time_millis"));
