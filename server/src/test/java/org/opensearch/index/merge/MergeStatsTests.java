        stats.add((MergeStats) null);
        assertEquals(original.getTotalSizeInBytes(), deserialized.getTotalSizeInBytes());  
        assertEquals(0, stats.getTotalSizeInBytes());
        assertEquals(0, stats.getWarmerStats().getTotalReceiveTime().getMillis());  
        assertEquals(512, stats1.getCurrentSizeInBytes()); // not expected to get added with addTotals  
 *
        assertEquals(0, stats.getTotalTimeInMillis());
        assertNotNull(stats.getWarmerStats());
        assertEquals(5, stats.getUnreferencedFileCleanUpsPerformed());
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(json.contains("total_time_in_millis"));
import org.opensearch.common.xcontent.XContentFactory;  
public class MergeStatsTests extends OpenSearchTestCase {  
        assertEquals(0, stats.getWarmerStats().getOngoingCount());
        assertEquals(50, stats.getTotalNumDocs());
    public void testUnreferencedFileCleanUpStats() {
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 0);
        assertEquals(new ByteSizeValue(200), stats1.getWarmerStats().getTotalSentSize());
package org.opensearch.index.merge;
    public void testAdd() {
        stats1.addTotals(stats2);
    public void testSerialization() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(stats.getWarmerStats());
        MergeStats stats2 = new MergeStats();
        String json = builder.toString();  
        stats2.add(3, 50, 30, 512, 1, 15, 256, 5, 10, 1.0, warmerStats);
        assertEquals(512, stats.getCurrentSizeInBytes());  
    }
        assertEquals(original.getTotalBytesPerSecAutoThrottle(), deserialized.getTotalBytesPerSecAutoThrottle());  
        assertEquals(40, stats1.getCurrentNumDocs());
        assertEquals(25, stats.getCurrentNumDocs());
        assertEquals(7, stats1.getWarmerStats().getOngoingCount()); // not expected to get added with addTotals  
/*  
        stats.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
        assertEquals(0, stats.getWarmerStats().getTotalTime().getMillis());  
        assertEquals(0, stats.getTotalThrottledTimeInMillis());  
        MergeStats stats = new MergeStats();  
        MergeStats stats1 = new MergeStats();
        assertEquals(original.getTotalTimeInMillis(), deserialized.getTotalTimeInMillis());
    }  
        assertEquals(2, stats.getCurrent());
        assertEquals(20, stats1.getWarmerStats().getTotalTime().getMillis());  
        assertEquals(100, stats.getTotalTimeInMillis());
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 0);  
        assertEquals(5, stats.getWarmerStats().getTotalSendTime().getMillis());
        assertEquals(2, stats1.getWarmerStats().getTotalInvocationsCount());
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 7);
    }
        assertTrue(json.contains("total_size_in_bytes"));  
        stats1.add(stats2);
        assertEquals(new ByteSizeValue(0), stats.getWarmerStats().getTotalReceivedSize());  
        assertEquals(original.getTotalThrottledTimeInMillis(), deserialized.getTotalThrottledTimeInMillis());
        assertEquals(5, stats.getTotal());  
        assertEquals(10, stats1.getWarmerStats().getTotalSendTime().getMillis());
    }  
        assertEquals(0, stats.getWarmerStats().getTotalFailureCount());
 */  
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 0);
        assertEquals(80, stats1.getTotalNumDocs());
    public void testAddWithNull() {
 * compatible open source license.
        assertEquals(25, stats1.getCurrentNumDocs()); // not expected to get added with addTotals
        assertTrue(json.contains("warmer"));
        assertEquals(original.getTotalStoppedTimeInMillis(), deserialized.getTotalStoppedTimeInMillis());
        stats1.add(1, 10, 5, 100, 0, 0, 0, 0, 0, Double.MAX_VALUE, warmerStats);
        assertTrue(stats.getTotalBytesPerSecAutoThrottle() > 0);
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 0);  
        assertEquals(30, stats1.getWarmerStats().getTotalReceiveTime().getMillis());  
        assertEquals(10, stats.getWarmerStats().getTotalTime().getMillis());
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
import org.opensearch.common.unit.TimeValue;
        assertEquals(25, stats.getCurrentNumDocs());
        assertEquals(original.getTotal(), deserialized.getTotal());  
    public void testDefaultConstructor() {
    }
        assertEquals(new TimeValue(20), stats.getTotalThrottledTime());
        assertEquals(10, stats.getTotalStoppedTimeInMillis());
        assertEquals(new ByteSizeValue(400), stats1.getWarmerStats().getTotalReceivedSize());
        assertEquals(30, stats1.getTotalThrottledTimeInMillis());
        stats1.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
    }  
        stats1.addTotals(stats2);
        MergeStats stats = new MergeStats();  
        assertEquals(new ByteSizeValue(0), stats.getWarmerStats().getTotalSentSize());
        original.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
import org.opensearch.core.xcontent.XContentBuilder;
        assertTrue(json.contains("merges"));
}  
        assertEquals(20, stats.getTotalThrottledTimeInMillis());
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.common.io.stream.BytesStreamOutput;
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
        assertEquals(512, stats.getCurrentSizeInBytes());  
    public void testAutoThrottleMaxValue() {
        assertEquals(30, stats1.getWarmerStats().getTotalReceiveTime().getMillis());
        assertEquals(2, stats1.getCurrent()); // not expected to get added with addTotals
        assertEquals(original.getCurrent(), deserialized.getCurrent());
        assertEquals(original.getCurrentNumDocs(), deserialized.getCurrentNumDocs());
    public void testGetters() {
        MergeStats stats = new MergeStats();  
        BytesReference bytes = out.bytes();
        stats.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
        assertEquals(20, stats.getTotalThrottledTimeInMillis());
        assertEquals(150, stats1.getTotalTimeInMillis());
        assertEquals(0, stats.getCurrentNumDocs());  
        MergeStats stats = new MergeStats();  
        original.writeTo(out);  
        MergeStats stats2 = new MergeStats();
        assertEquals(1536, stats1.getTotalSizeInBytes());  
    }  
        assertEquals(0, stats.getWarmerStats().getTotalInvocationsCount());
        assertEquals(new ByteSizeValue(200), stats1.getWarmerStats().getTotalSentSize());
        MergeStats stats = new MergeStats();
        assertEquals(0, stats.getWarmerStats().getTotalFailureCount());  
        stats2.add(3, 50, 30, 512, 1, 15, 256, 5, 10, 1.0, warmerStats);
        assertTrue(json.contains("current"));
        assertEquals(0, stats.getUnreferencedFileCleanUpsPerformed());
        original.addUnreferencedFileCleanUpStats(3);  
        stats.addUnreferencedFileCleanUpStats(5);
        assertEquals(2, stats.getCurrent());
        assertEquals(8, stats1.getTotal());  
        assertEquals(1024, stats.getTotalSizeInBytes());  
        stats.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
        assertEquals(0, stats.getCurrent());
        assertEquals(0, stats.getTotal());
        assertEquals(original.getCurrentSizeInBytes(), deserialized.getCurrentSizeInBytes());  
import org.opensearch.core.common.unit.ByteSizeValue;  
        MergeStats stats = new MergeStats();  
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
        assertTrue(json.contains("total_docs"));
        builder.startObject();
    public void testAddMergeStats() {  
 * SPDX-License-Identifier: Apache-2.0
        builder.endObject();
        stats.toXContent(builder, null);  
        assertEquals(0, stats1.getWarmerStats().getOngoingCount());
        MergeStats deserialized = new MergeStats(in);
        assertEquals(0, stats.getCurrent());
        MergeStats stats2 = new MergeStats();
    public void testAddTotals() {  
        stats.addUnreferencedFileCleanUpStats(3);
        assertEquals(15, stats1.getTotalStoppedTimeInMillis());
        XContentBuilder builder = XContentFactory.jsonBuilder();
        assertEquals(new ByteSizeValue(512), stats.getCurrentSize());
import org.opensearch.core.common.bytes.BytesReference;
    public void testAddWithoutMergedSegmentWarmer() {
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();  
    }  
        assertEquals(8, stats.getUnreferencedFileCleanUpsPerformed());
        assertEquals(new TimeValue(10), stats.getTotalStoppedTime());
        assertEquals(1, stats.getWarmerStats().getTotalInvocationsCount());
        MergeStats stats1 = new MergeStats();
        assertEquals(10, stats.getTotalStoppedTimeInMillis());
    public void testToXContent() throws IOException {  
        assertTrue(json.contains("total"));  
        assertEquals(10, stats1.getWarmerStats().getTotalSendTime().getMillis());
        assertEquals(3, stats1.getCurrent());
    }
        assertEquals(100, stats.getTotalTimeInMillis());
        stats1.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
    }
        assertEquals(768, stats1.getCurrentSizeInBytes());  
        assertEquals(1024, stats.getTotalSizeInBytes());  
        assertEquals(0, stats1.getWarmerStats().getTotalFailureCount());
        MergeStats original = new MergeStats();
        assertEquals(0, stats.getTotalNumDocs());  
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
import org.opensearch.test.OpenSearchTestCase;
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 0);
        stats.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5);
        assertEquals(2, stats1.getWarmerStats().getTotalInvocationsCount());
        MergeStats stats1 = new MergeStats();  
        stats.addTotals(null);
        assertEquals(5, stats.getTotal());  
        assertEquals(0, stats.getWarmerStats().getTotalSendTime().getMillis());
        assertEquals(8, stats1.getTotal());  
        BytesStreamOutput out = new BytesStreamOutput();
        stats2.add(1, 10, 5, 100, 0, 0, 0, 0, 0, 1.0, warmerStats);  
        assertEquals(0, stats.getCurrentSizeInBytes());
        assertEquals(15, stats.getWarmerStats().getTotalReceiveTime().getMillis());
        assertEquals(Long.MAX_VALUE, stats1.getTotalBytesPerSecAutoThrottle());  
        StreamInput in = bytes.streamInput();  
        MergeStats stats = new MergeStats();  
        assertEquals(50, stats.getTotalNumDocs());
        assertEquals(new ByteSizeValue(100), stats.getWarmerStats().getTotalSentSize());
        assertEquals(20, stats1.getWarmerStats().getTotalTime().getMillis());
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
        assertEquals(new TimeValue(100), stats.getTotalTime());  
        assertEquals(0, stats1.getWarmerStats().getTotalFailureCount());  
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
    }  
        assertEquals(new ByteSizeValue(200), stats.getWarmerStats().getTotalReceivedSize());
        assertEquals(original.getTotalNumDocs(), deserialized.getTotalNumDocs());
        assertEquals(new ByteSizeValue(1024), stats.getTotalSize());  
        assertEquals(0, stats.getWarmerStats().getOngoingCount());  
        assertEquals(0, stats.getTotal());
        assertEquals(new ByteSizeValue(400), stats1.getWarmerStats().getTotalReceivedSize());  
import java.io.IOException;
        assertEquals(0, stats.getTotalStoppedTimeInMillis());
