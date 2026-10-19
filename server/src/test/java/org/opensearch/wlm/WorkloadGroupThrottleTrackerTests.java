                    start.await();
        for (int nodeLimit : new int[] { 0, -1 }) {
        // The tracker returns null over the cap; the caller builds the 429.
        WorkloadGroupThrottleTracker tracker = new WorkloadGroupThrottleTracker();  
        assertEquals(1, tracker.inFlight("a"));  
     */
        // a refused acquire must not leave the count inflated
                            p.close();  
        start.countDown();
        assertTrue("threads did not finish in time", done.await(60, TimeUnit.SECONDS));
        assertNull(tracker.tryAcquire("bucket", 1));  
        Releasable p = tracker.tryAcquire("bucket", 5);
        p1.close();
import java.util.ArrayList;
            assertEquals(0, tracker.bucketCount());
import java.util.concurrent.atomic.AtomicInteger;
        assertEquals(0, tracker.bucketCount());  
        assertEquals("bucket entry was not evicted", 0, tracker.bucketCount());  
            AssertionError error = expectThrows(AssertionError.class, () -> tracker.tryAcquire("bucket", nodeLimit));
        Releasable p2 = tracker.tryAcquire("bucket", 5);  
        assertEquals(0, tracker.bucketCount());
        assertEquals(0, tracker.bucketCount());  
        assertNotNull(tracker.tryAcquire("a", 1));
                        failures.add(e);
    public void testAcquireAtLimitIsRefused() {
        assertEquals(1, tracker.inFlight("bucket"));
     * Hammers one bucket from many threads. Asserts the two properties the whole design rests on and that no  
        p2.close();
    }  
                        if (p != null) {
        // permit freed -> a fresh acquire now succeeds
 * this file be licensed under the Apache-2.0 license or a
public class WorkloadGroupThrottleTrackerTests extends OpenSearchTestCase {
            Releasable p = tracker.tryAcquire("bucket", limit);
                try {
        final int iterations = 200;
package org.opensearch.wlm;
        Releasable p1 = tracker.tryAcquire("bucket", 2);
        final CountDownLatch start = new CountDownLatch(1);
        // re-acquiring after the bucket drained (and was removed) works and starts from 1
import org.opensearch.test.OpenSearchTestCase;
            Thread thread = new Thread(() -> {  
                } finally {
    }
        assertNull(tracker.tryAcquire("bucket", 1)); // at the limit  
        Releasable p2 = tracker.tryAcquire("bucket", 2);  
            permits.add(p);  
        assertNull(tracker.tryAcquire("a", 1)); // "a" is full but "b" is a separate bucket  
    }
        assertEquals(1, tracker.inFlight("bucket"));  
        assertEquals(limit, tracker.inFlight("bucket"));
        assertEquals(1, tracker.inFlight("bucket"));
    }
        assertEquals(1, tracker.bucketCount());
        assertNotNull(p2);
        pb.close();
        WorkloadGroupThrottleTracker tracker = new WorkloadGroupThrottleTracker();
        final int threads = 8;  
        final AtomicInteger concurrentlyHeld = new AtomicInteger();
 * The OpenSearch Contributors require contributions made to  
        int limit = randomIntBetween(2, 5);
        assertNotNull(tracker.tryAcquire("bucket", 1));
import java.util.concurrent.TimeUnit;
        assertEquals("counter did not return to zero", 0, tracker.inFlight("hot"));
import org.opensearch.common.lease.Releasable;
    }  
        assertEquals(0, tracker.bucketCount());  
        p2.close();
        p.close();
        for (int i = 0; i < limit; i++) {  
                    }
        assertNotNull(pb);
import java.util.concurrent.CountDownLatch;  
        Releasable p = tracker.tryAcquire("bucket", 1);
        p.close();
                    synchronized (failures) {
        final List<Throwable> failures = new ArrayList<>();  
        }
        }  
        List<Releasable> permits = new ArrayList<>();
    /**
    public void testBucketsAreIndependent() {  
            assertEquals("nodeLimit must be positive", error.getMessage());  
    }
        assertEquals(1, tracker.inFlight("bucket"));
    public void testAcquireUnderLimitSucceeds() {  
        permits.forEach(Releasable::close);
                    }  
        assertEquals(1, tracker.inFlight("bucket"));
        WorkloadGroupThrottleTracker tracker = new WorkloadGroupThrottleTracker();
                            maxObserved.accumulateAndGet(held, Math::max);
    public void testNonPositiveLimitIsRejectedBeforeCreatingBucket() {
        p1.close(); // double close must not decrement twice  
        assertTrue("admitted " + maxObserved.get() + " concurrently for a limit of " + limit, maxObserved.get() <= limit);
        final AtomicInteger maxObserved = new AtomicInteger();  
        p2.close();  
    }
            thread.start();
        WorkloadGroupThrottleTracker tracker = new WorkloadGroupThrottleTracker();
        final int limit = 4;
        assertNotNull(p2);
            });
        assertNotNull(p1);
import java.util.List;
        final CountDownLatch done = new CountDownLatch(threads);
        Releasable p1 = tracker.tryAcquire("bucket", 5);  
            assertTrue("worker threads threw: " + failures, failures.isEmpty());
    public void testDrainToZeroRemovesBucketThenReacquire() {  
        WorkloadGroupThrottleTracker tracker = new WorkloadGroupThrottleTracker();
        synchronized (failures) {
        // Two permits so the bucket survives the first close, keeping a double decrement visible.
     * single-threaded test can show: the limit is never exceeded, and every entry is evicted once the dust settles.
        assertEquals(limit, tracker.inFlight("bucket"));
}
 */  
        }
                        }
                }  
        Releasable p2 = tracker.tryAcquire("bucket", 5);
        assertEquals(1, tracker.inFlight("b"));
                } catch (Throwable e) {  
    public void testExactlyNAdmittedForLimitAboveOne() {
                        Releasable p = tracker.tryAcquire("hot", limit);
                    for (int i = 0; i < iterations; i++) {  
                    done.countDown();
    public void testReleaseFreesAPermit() {  
        WorkloadGroupThrottleTracker tracker = new WorkloadGroupThrottleTracker();  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
                            concurrentlyHeld.decrementAndGet();
        for (int t = 0; t < threads; t++) {
        WorkloadGroupThrottleTracker tracker = new WorkloadGroupThrottleTracker();
    public void testConcurrentAcquireNeverExceedsLimitAndFullyDrains() throws Exception {  
        p2.close();
        Releasable p2 = tracker.tryAcquire("bucket", 1);  
    public void testReleaseIsIdempotent() {  
        WorkloadGroupThrottleTracker tracker = new WorkloadGroupThrottleTracker();
/*  
        p1.close();
        assertEquals(2, tracker.inFlight("bucket"));  
        assertNull("the limit+1'th acquire must be refused", tracker.tryAcquire("bucket", limit));  
                            int held = concurrentlyHeld.incrementAndGet();  
        Releasable pb = tracker.tryAcquire("b", 1);
        // bucketCount, not inFlight: only it distinguishes an evicted bucket from one at zero.  
 *
            assertNotNull("acquire " + i + " of " + limit + " must be admitted", p);
    }  
    }  
        WorkloadGroupThrottleTracker tracker = new WorkloadGroupThrottleTracker();  
        }  
