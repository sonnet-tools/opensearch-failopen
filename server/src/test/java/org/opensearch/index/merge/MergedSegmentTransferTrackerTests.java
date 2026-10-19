package org.opensearch.index.merge;
    @Override  
        assertEquals(new TimeValue(300), stats.getTotalReceiveTime());  
        assertEquals(TimeValue.ZERO, stats.getTotalReceiveTime());
        assertEquals(0, stats.getTotalReceivedSize().getBytes());
        tracker.addTotalBytesSent(500);
        assertEquals(2, tracker.stats().getOngoingCount());
        tracker.addTotalBytesSent(1024);  
    private MergedSegmentTransferTracker tracker;
        MergedSegmentWarmerStats stats = tracker.stats();
public class MergedSegmentTransferTrackerTests extends OpenSearchTestCase {
        assertEquals(2048, stats.getTotalReceivedSize().getBytes());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(ByteSizeValue.class, stats.getTotalSentSize().getClass());
 * The OpenSearch Contributors require contributions made to  
    public void setUp() throws Exception {
        tracker.incrementOngoingWarms();  
        assertEquals(0, stats.getOngoingCount());
        tracker.addTotalBytesSent(1000);
    public void testCumulativeStats() {
        assertEquals(0, stats.getTotalFailureCount());
}
 * SPDX-License-Identifier: Apache-2.0
/*  
        assertEquals(new TimeValue(100), stats.getTotalTime());
 * compatible open source license.
        tracker.addTotalWarmTimeMillis(50);
        tracker.addTotalWarmTimeMillis(100);  
        MergedSegmentWarmerStats stats = tracker.stats();  
        tracker.decrementOngoingWarms();
        assertEquals(1, stats.getTotalInvocationsCount());
    }  
        assertEquals(1500, tracker.stats().getTotalSentSize().getBytes());  
    public void testIncrementCounters() {
    public void testOngoingWarms() {
        assertEquals(new TimeValue(200), stats.getTotalSendTime());
        super.setUp();
        tracker.incrementOngoingWarms();
 */  
        assertEquals(new TimeValue(150), tracker.stats().getTotalTime());
    }  
        tracker.addTotalWarmTimeMillis(100);  
    }
        assertEquals(TimeValue.ZERO, stats.getTotalTime());  
    public void testInitialStats() {  
        tracker = new MergedSegmentTransferTracker();  
        assertEquals(1, tracker.stats().getOngoingCount());
        tracker.addTotalSendTimeMillis(200);
        tracker.addTotalBytesReceived(2048);
import org.opensearch.common.unit.TimeValue;
        assertEquals(0, stats.getTotalInvocationsCount());
        assertEquals(1, stats.getTotalFailureCount());
import org.opensearch.test.OpenSearchTestCase;  
        tracker.addTotalReceiveTimeMillis(300);
        assertEquals(ByteSizeValue.class, stats.getTotalReceivedSize().getClass());
 *
        tracker.incrementTotalWarmInvocationsCount();  
        assertEquals(0, stats.getTotalSentSize().getBytes());  
import org.opensearch.core.common.unit.ByteSizeValue;
        MergedSegmentWarmerStats stats = tracker.stats();  
    }
    public void testAddTimeAndBytes() {
    }  
        assertEquals(TimeValue.ZERO, stats.getTotalSendTime());  
        assertEquals(1024, stats.getTotalSentSize().getBytes());
    }  
        tracker.incrementTotalWarmFailureCount();
