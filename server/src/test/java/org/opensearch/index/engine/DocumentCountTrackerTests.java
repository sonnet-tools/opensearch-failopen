import org.opensearch.index.seqno.SequenceNumbers;  
        DocumentCountTracker tracker = new DocumentCountTracker(SHARD_ID, () -> 0L, 100);  
    }
        assertNull(tracker.tryAcquireInFlightDocs(mockPrimaryOp(), 30));
import java.util.concurrent.atomic.AtomicLong;  
    private Operation mockPrimaryOp() {  
        Exception ex = tracker.tryAcquireInFlightDocs(mockPrimaryOp(), 20);
    private static final ShardId SHARD_ID = new ShardId("test", "_na_", 0);
        DocumentCountTracker tracker = new DocumentCountTracker(SHARD_ID, () -> 90L, 100);
        assertNull(tracker.tryAcquireInFlightDocs(mockPrimaryOp(), 30));
        when(op.origin()).thenReturn(Operation.Origin.PRIMARY);
        assertNull(tracker.tryAcquireInFlightDocs(mockPrimaryOp(), 30));  
        DocumentCountTracker tracker = new DocumentCountTracker(SHARD_ID, () -> 90L, 100);  
import org.opensearch.test.OpenSearchTestCase;
    }  
import org.opensearch.core.index.shard.ShardId;
    public void testMultipleAcquiresAccumulate() {
 * SPDX-License-Identifier: Apache-2.0
/*  
import static org.mockito.Mockito.when;  
    public void testIndexedDocsCountedAgainstLimit() {
        // 50 indexed + 40 in-flight = 90, OK
import org.opensearch.index.engine.Engine.Operation;
        assertEquals(40, tracker.getInFlightDocCount());  
        assertNull(tracker.tryAcquireInFlightDocs(mockPrimaryOp(), 10));
        DocumentCountTracker tracker = new DocumentCountTracker(SHARD_ID, indexedDocs::get, 100);  
    public void testReleaseDecrementsCount() {
 * compatible open source license.
    }
        assertEquals(90, tracker.getInFlightDocCount());  
        DocumentCountTracker tracker = new DocumentCountTracker(SHARD_ID, () -> 0L, 100);
}
        assertEquals(0, tracker.getInFlightDocCount());
        assertNotNull(ex);
    }  
        Exception ex = tracker.tryAcquireInFlightDocs(mockPrimaryOp(), 20);  
        assertEquals(90, tracker.getInFlightDocCount());
        assertEquals(10, tracker.getInFlightDocCount());
        // Next one should fail (90 in-flight + 0 indexed + 20 = 110 > 100)
public class DocumentCountTrackerTests extends OpenSearchTestCase {
        assertEquals(10, tracker.getInFlightDocCount());
        tracker.releaseInFlightDocs(3);  
        Exception ex = tracker.tryAcquireInFlightDocs(mockPrimaryOp(), 20);
    }
        Operation op = mock(Operation.class);
 *
        assertEquals(2, tracker.getInFlightDocCount());
    public void testAcquireExactlyAtLimitSucceeds() {
    public void testAcquireExceedingLimitReturnsException() {
        assertTrue(ex instanceof IllegalArgumentException);
        assertNotNull(ex);
        assertNull(tracker.tryAcquireInFlightDocs(mockPrimaryOp(), 10));  
        return op;
        assertNotNull(ex);  
        tracker.tryAcquireInFlightDocs(mockPrimaryOp(), 5);
        assertTrue(ex.getMessage().contains("exceeds the limit"));  
        when(op.seqNo()).thenReturn(SequenceNumbers.UNASSIGNED_SEQ_NO);  
        AtomicLong indexedDocs = new AtomicLong(50);
    }
 */  
        DocumentCountTracker tracker = new DocumentCountTracker(SHARD_ID, () -> 0L, 100);
        // Should have rolled back
        // 50 indexed + 40 in-flight + 20 = 110, exceeds  
    public void testAcquireWithinLimitReturnsNull() {
import static org.mockito.Mockito.mock;
    }
        assertEquals(5, tracker.getInFlightDocCount());
package org.opensearch.index.engine;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        assertNull(tracker.tryAcquireInFlightDocs(mockPrimaryOp(), 40));
