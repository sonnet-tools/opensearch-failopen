    public void testGetters() {
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(new ByteSizeValue(1024), stats.getTotalSize());
        stats2.add(1, 10, 5, 100, 0, 0, 0, 0, 0, 1.0, warmerStats);
        assertEquals(150, stats1.getTotalTimeInMillis());
        stats.addUnreferencedFileCleanUpStats(3);
        MergeStats stats = new MergeStats();
        assertEquals(25, stats.getCurrentNumDocs());
        BytesReference bytes = out.bytes();
        MergeStats original = new MergeStats();
        assertEquals(8, stats1.getTotal());
        assertEquals(new ByteSizeValue(200), stats1.getWarmerStats().getTotalSentSize());
        stats.addUnreferencedFileCleanUpStats(5);
        assertEquals(original.getCurrentNumDocs(), deserialized.getCurrentNumDocs());
        assertEquals(new ByteSizeValue(0), stats.getWarmerStats().getTotalReceivedSize());
    }
        assertEquals(8, stats.getUnreferencedFileCleanUpsPerformed());
        assertEquals(0, stats.getUnreferencedFileCleanUpsPerformed());
    }
        XContentBuilder builder = XContentFactory.jsonBuilder();
 *
        assertEquals(0, stats.getCurrent());
        assertEquals(10, stats.getTotalStoppedTimeInMillis());
 */
        assertEquals(30, stats1.getTotalThrottledTimeInMillis());
        assertEquals(0, stats.getTotal());
        assertEquals(0, stats.getCurrent());
 * The OpenSearch Contributors require contributions made to
        assertEquals(new ByteSizeValue(400), stats1.getWarmerStats().getTotalReceivedSize());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(original.getTotalBytesPerSecAutoThrottle(), deserialized.getTotalBytesPerSecAutoThrottle());
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
        MergeStats stats = new MergeStats();
        assertEquals(0, stats1.getWarmerStats().getOngoingCount());
        assertEquals(new ByteSizeValue(100), stats.getWarmerStats().getTotalSentSize());
        assertTrue(json.contains("merges"));
        assertTrue(json.contains("total_size_in_bytes"));
        assertEquals(25, stats.getCurrentNumDocs());
        assertEquals(2, stats1.getCurrent()); // not expected to get added with addTotals
        stats.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5);
        assertEquals(0, stats.getTotal());
 * compatible open source license.
        assertEquals(1024, stats.getTotalSizeInBytes());
        assertEquals(2, stats1.getWarmerStats().getTotalInvocationsCount());
    public void testAutoThrottleMaxValue() {
    public void testAdd() {
        assertEquals(new TimeValue(100), stats.getTotalTime());
        assertEquals(25, stats1.getCurrentNumDocs()); // not expected to get added with addTotals
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 0);
        assertEquals(1, stats.getWarmerStats().getTotalInvocationsCount());
        assertEquals(10, stats1.getWarmerStats().getTotalSendTime().getMillis());
        MergeStats stats = new MergeStats();
import org.opensearch.common.unit.TimeValue;
    }
        assertEquals(0, stats.getTotalTimeInMillis());
        assertEquals(0, stats.getWarmerStats().getOngoingCount());
        assertEquals(5, stats.getUnreferencedFileCleanUpsPerformed());
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 7);
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
        stats1.add(1, 10, 5, 100, 0, 0, 0, 0, 0, Double.MAX_VALUE, warmerStats);
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
        stats.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
        MergeStats stats = new MergeStats();
        assertEquals(7, stats1.getWarmerStats().getOngoingCount()); // not expected to get added with addTotals
        assertEquals(0, stats1.getWarmerStats().getTotalFailureCount());
/*
        assertEquals(0, stats.getTotalThrottledTimeInMillis());
        assertEquals(0, stats.getTotalStoppedTimeInMillis());
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 0);
        assertEquals(100, stats.getTotalTimeInMillis());
        assertEquals(2, stats.getCurrent());
        assertEquals(15, stats.getWarmerStats().getTotalReceiveTime().getMillis());
        String json = builder.toString();
        MergeStats stats = new MergeStats();
        assertEquals(new ByteSizeValue(512), stats.getCurrentSize());
        builder.endObject();
    }
        assertEquals(80, stats1.getTotalNumDocs());
        builder.startObject();
        stats1.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
    }
        assertEquals(5, stats.getTotal());
        assertEquals(original.getTotalTimeInMillis(), deserialized.getTotalTimeInMillis());
    public void testUnreferencedFileCleanUpStats() {
        stats2.add(3, 50, 30, 512, 1, 15, 256, 5, 10, 1.0, warmerStats);
        assertEquals(8, stats1.getTotal());
        assertEquals(new TimeValue(20), stats.getTotalThrottledTime());
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(20, stats.getTotalThrottledTimeInMillis());
        assertEquals(new ByteSizeValue(200), stats.getWarmerStats().getTotalReceivedSize());
    }
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
        assertTrue(json.contains("current"));
        assertEquals(10, stats.getWarmerStats().getTotalTime().getMillis());
        assertEquals(20, stats1.getWarmerStats().getTotalTime().getMillis());
    }
        assertEquals(5, stats.getWarmerStats().getTotalSendTime().getMillis());
        assertEquals(50, stats.getTotalNumDocs());
        assertEquals(2, stats.getCurrent());
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 0);
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
public class MergeStatsTests extends OpenSearchTestCase {
        assertEquals(0, stats.getCurrentSizeInBytes());
        MergeStats stats2 = new MergeStats();
    public void testSerialization() throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        MergeStats stats = new MergeStats();
        assertEquals(1536, stats1.getTotalSizeInBytes());
        assertEquals(0, stats.getWarmerStats().getTotalInvocationsCount());
        MergeStats stats2 = new MergeStats();
        assertEquals(10, stats.getTotalStoppedTimeInMillis());
        stats1.addTotals(stats2);
    public void testDefaultConstructor() {
        stats.toXContent(builder, null);
        assertNotNull(stats.getWarmerStats());
        assertEquals(10, stats1.getWarmerStats().getTotalSendTime().getMillis());
import org.opensearch.core.common.io.stream.StreamInput;
        assertEquals(original.getTotal(), deserialized.getTotal());
import org.opensearch.core.common.unit.ByteSizeValue;
        assertEquals(0, stats.getTotalSizeInBytes());
import org.opensearch.common.io.stream.BytesStreamOutput;
        MergeStats stats2 = new MergeStats();
    public void testAddTotals() {
        assertEquals(5, stats.getTotal());
        stats.add((MergeStats) null);
    public void testToXContent() throws IOException {
        assertEquals(0, stats.getTotalNumDocs());
        assertTrue(stats.getTotalBytesPerSecAutoThrottle() > 0);
        assertEquals(Long.MAX_VALUE, stats1.getTotalBytesPerSecAutoThrottle());
        StreamInput in = bytes.streamInput();
        assertEquals(512, stats1.getCurrentSizeInBytes()); // not expected to get added with addTotals
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 0);
        warmerStats.add(1, 10, 0, 100, 200, 5, 15, 0);
        MergeStats stats = new MergeStats();
        stats2.add(3, 50, 30, 512, 1, 15, 256, 5, 10, 1.0, warmerStats);
        assertEquals(0, stats1.getWarmerStats().getTotalFailureCount());
        assertTrue(json.contains("total_docs"));
        assertTrue(json.contains("warmer"));
    public void testAddWithNull() {
        stats1.addTotals(stats2);
        assertEquals(30, stats1.getWarmerStats().getTotalReceiveTime().getMillis());
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
        original.addUnreferencedFileCleanUpStats(3);
        assertEquals(15, stats1.getTotalStoppedTimeInMillis());
        assertEquals(new TimeValue(10), stats.getTotalStoppedTime());
import java.io.IOException;
        assertEquals(original.getCurrent(), deserialized.getCurrent());
        assertEquals(new ByteSizeValue(0), stats.getWarmerStats().getTotalSentSize());
        stats1.add(stats2);
        assertEquals(0, stats.getWarmerStats().getTotalReceiveTime().getMillis());
 * this file be licensed under the Apache-2.0 license or a
    }
    }
        stats1.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
        assertEquals(0, stats.getCurrentNumDocs());
        assertEquals(0, stats.getWarmerStats().getTotalFailureCount());
        assertEquals(768, stats1.getCurrentSizeInBytes());
        assertEquals(original.getTotalNumDocs(), deserialized.getTotalNumDocs());
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.merge;
        assertEquals(40, stats1.getCurrentNumDocs());
        assertEquals(new ByteSizeValue(200), stats1.getWarmerStats().getTotalSentSize());
        original.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
    public void testAddMergeStats() {
    }
        assertEquals(50, stats.getTotalNumDocs());
        assertEquals(30, stats1.getWarmerStats().getTotalReceiveTime().getMillis());
    public void testAddWithoutMergedSegmentWarmer() {
        assertEquals(original.getTotalSizeInBytes(), deserialized.getTotalSizeInBytes());
        assertEquals(0, stats.getWarmerStats().getTotalTime().getMillis());
        stats.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
        assertEquals(20, stats.getTotalThrottledTimeInMillis());
        assertEquals(original.getTotalStoppedTimeInMillis(), deserialized.getTotalStoppedTimeInMillis());
        MergeStats stats1 = new MergeStats();
        stats.addTotals(null);
        assertEquals(0, stats.getWarmerStats().getOngoingCount());
        assertEquals(0, stats.getWarmerStats().getTotalFailureCount());
        assertEquals(3, stats1.getCurrent());
        assertEquals(0, stats.getWarmerStats().getTotalSendTime().getMillis());
        assertEquals(20, stats1.getWarmerStats().getTotalTime().getMillis());
        original.writeTo(out);
        MergeStats stats1 = new MergeStats();
        assertTrue(json.contains("total_time_in_millis"));
        assertEquals(original.getCurrentSizeInBytes(), deserialized.getCurrentSizeInBytes());
        stats.add(5, 100, 50, 1024, 2, 25, 512, 10, 20, 1.5, warmerStats);
        assertEquals(512, stats.getCurrentSizeInBytes());
        assertEquals(new ByteSizeValue(400), stats1.getWarmerStats().getTotalReceivedSize());
        MergeStats stats1 = new MergeStats();
        assertNotNull(stats.getWarmerStats());
        assertEquals(1024, stats.getTotalSizeInBytes());
        assertEquals(512, stats.getCurrentSizeInBytes());
}
        MergeStats deserialized = new MergeStats(in);
        assertEquals(100, stats.getTotalTimeInMillis());
    }
        assertTrue(json.contains("total"));
import org.opensearch.common.xcontent.XContentFactory;
        assertEquals(2, stats1.getWarmerStats().getTotalInvocationsCount());
        assertEquals(original.getTotalThrottledTimeInMillis(), deserialized.getTotalThrottledTimeInMillis());
        MergedSegmentWarmerStats warmerStats = new MergedSegmentWarmerStats();
