            super(limit);  
     */  
    }
        BurstAwareLimit burst = new BurstAwareLimit(base, 0, 3, 3);
 *
        MutableLimit(int initial) {
        burst.onSample(0, RTT, 12, false); // counter=3 — not yet (threshold=4)  
        FixedLimit base = new FixedLimit(20);  
        burst.onSample(0, RTT, 20, false); // counter=1  
        burst.onSample(0, RTT, 13, false); // counter=4 → reopens
            return getLimit();
        void updateTo(int newLimit) {
        burst.onSample(0, RTT, 19, false); // counter=4 — still < threshold=5
    private static final long RTT = TimeUnit.MILLISECONDS.toNanos(10);  
    public void testBurstWindowReopensAfterSustainedQuiet() {
        // After threshold quiet samples the window reopens.
        burst.onSample(0, RTT, 21, false);
     * A delegate whose limit never changes, regardless of onSample inputs.
        assertEquals("samples below base must not close the burst window", 25, burst.getLimit());
public class BurstAwareLimitTests extends OpenSearchTestCase {
    public void testIndependentCloseAndRecoveryThresholds() {
        burst.onSample(0, RTT, 15, false); // counter=2  
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 3, 5);
        }  
 * this file be licensed under the Apache-2.0 license or a
        burst.onSample(0, RTT, 20, false);
        burst.onSample(0, RTT, 21, false); // counter=1
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 21, false);
    public void testListenerNotifiedOnLimitChange() {  
        assertEquals(25, burst.getLimit());
        burst.onSample(0, RTT, 18, false); // counter=1
    public void testBurstLimitFollowsAlgorithmUpdates() {  
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 15, false); // counter=1 again
            return getLimit();
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 20, false); // counter=1  
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 2, 3);
        assertEquals("listener must receive new limit on burst close", 20, lastNotified[0]);
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 3, 5);
        MutableLimit base = new MutableLimit(20);
        burst.onSample(0, RTT, 20, false);  
        // inflight in burst range but below base (< 20) — should not advance close counter.  
        @Override  
 * The OpenSearch Contributors require contributions made to  
        FixedLimit base = new FixedLimit(20);
        assertEquals(25, burst.getLimit());
    }  
        assertEquals("burst window must not reopen before recovery threshold", 20, burst.getLimit());  
        burst.onSample(0, RTT, 20, false); // counter=1
            super(initial);
    }
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 3, 3);
        assertEquals(30, burst.getLimit()); // 25 + 5  
        // Spike above base (counter=1), then quiet (counter resets), then spike (counter=1 again).
        assertEquals(25, burst.getLimit());  
import org.opensearch.test.OpenSearchTestCase;
        // Close the window.
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 1, 1);
        assertEquals("burst must be closed after N consecutive over-base samples", 30, burst.getLimit());
        FixedLimit base = new FixedLimit(20);
        // Close after 2 consecutive over-base; recover after 4 consecutive below-base.  
    public void testGetDelegateReturnsDelegate() {
    }
        }
        FixedLimit base = new FixedLimit(20);
        assertEquals(25, burst.getLimit());
    }  
        assertEquals("window must close after 3 consecutive over-base samples", 20, burst.getLimit());
        burst.onSample(0, RTT, 17, false); // quiet counter=3 → reopens
     * Used to isolate BurstAwareLimit's window state machine from Vegas's adaptive behavior.
 * SPDX-License-Identifier: Apache-2.0
        burst.onSample(0, RTT, 15, false); // counter=2  
        burst.onSample(0, RTT, 22, false); // counter=2
import com.netflix.concurrency.limits.limit.AbstractLimit;
        burst.onSample(0, RTT, 17, false); // resets to 0  
     */
        assertEquals("burst window must remain closed before recovery threshold", 20, burst.getLimit());  
        FixedLimit(int limit) {
        FixedLimit base = new FixedLimit(20);  
            setLimit(newLimit);  
        assertEquals(25, burst.getLimit());  
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 2, 4);
        burst.onSample(0, RTT, 18, false); // quiet counter=1
        assertEquals(base.getLimit(), burst.getLimit());  
import java.util.concurrent.TimeUnit;  
    /**  
        assertEquals("window must not close after 2 of 3", 25, burst.getLimit());  
        int[] lastNotified = { 0 };
        assertEquals("recovery must not trigger before threshold=4", 20, burst.getLimit());
        // Algorithm changes base while window is closed — propagated without burst.  
    public void testBurstWindowClosesAfterConsecutiveOverBaseSamples() {  
        burst.onSample(0, RTT, 10, false); // counter=1
    }
        // Close should trigger after exactly 2 over-base samples.  
        }  
    }
        base.updateTo(30);  
        assertEquals(20, base.getLimit());  
        protected int _update(long s, long rtt, int inflight, boolean dropped) {
        burst.onSample(0, RTT, 18, false);
        assertEquals("listener must receive new limit on burst reopen", 25, lastNotified[0]);
package org.opensearch.concurrency.limit;
        protected int _update(long s, long rtt, int inflight, boolean dropped) {
    }
        assertEquals("quiet counter reset by above-base sample must prevent premature reopen", 20, burst.getLimit());
    public void testBurstWindowDoesNotCloseForBelowBaseSamples() {
        burst.onSample(0, RTT, 15, false); // counter=2 — still < threshold=3  
    private static class FixedLimit extends AbstractLimit {
        assertSame(base, burst.getDelegate());
        FixedLimit base = new FixedLimit(20);
        assertEquals("burst window must remain closed before recovery threshold", 25, burst.getLimit());
        base.updateTo(25);
        burst.onSample(0, RTT, 10, false); // 1 quiet sample → reopens: limit 20 → 25
        burst.onSample(0, RTT, 10, false); // counter=1
        assertEquals(35, burst.getLimit()); // 30 + 5
        assertEquals(20, burst.getLimit());  
        FixedLimit base = new FixedLimit(20);
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 3, 5);  
        // Close the burst window — 2 consecutive samples with inflight >= base (30).  
    }
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 2, 3);  
        burst.onSample(0, RTT, 18, false); // resets to 0
        assertEquals("non-sustaining spikes must not close burst window", 25, burst.getLimit());
    }
        assertEquals(20, burst.getLimit());
        burst.onSample(0, RTT, 20, false); // 1 over-base sample → closes: limit 25 → 20
        }  
        // Recovery should not trigger until 4 below-base samples.  
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 2, 5);
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 2, 3);
     * A delegate that can be driven to a new limit externally, simulating algorithm updates.
        burst.onSample(0, RTT, 30, false); // counter=1
        burst.onSample(0, RTT, 20, false);
        }
 */  
    public void testAboveBaseInflightResetsQuietCounter() {  
        // inflight >= base (20) — these are over-base samples.
        burst.onSample(0, RTT, 14, false); // counter=3 → reopens
    }
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 3, 3);
        burst.onSample(0, RTT, 11, false); // counter=2
        FixedLimit base = new FixedLimit(20);  
        burst.onSample(0, RTT, 21, false); // counter=2 → closes  
    private static class MutableLimit extends AbstractLimit {  
        assertEquals(20, burst.getLimit());
        burst.onSample(0, RTT, 21, false);
    }
    public void testZeroBurstCapacityIsTransparent() {  
        // Algorithm grows the base — burst follows.
    /**  
    public void testNonSustainingSpikesDoNotCloseWindow() {
        burst.onSample(0, RTT, 12, false); // counter=2  
        burst.onSample(0, RTT, 15, false);  
/*  
        burst.onSample(0, RTT, 10, false); // counter=3
    }
    }  
        assertEquals("burst window must reopen after sustained quiet", 25, burst.getLimit());  
        burst.onSample(0, RTT, 19, false); // quiet counter=2
        @Override  
    public void testGetLimitReturnsDelegatePlusBurst() {
        burst.onSample(0, RTT, 15, false); // counter=3 → reopens  
        burst.onSample(0, RTT, 15, false); // counter=1
        burst.notifyOnChange(newLimit -> lastNotified[0] = newLimit);
        assertEquals("window must not close after 1 of 3", 25, burst.getLimit());
        burst.onSample(0, RTT, 21, false); // inflight >= base(20) → counter resets to 0
}
        burst.onSample(0, RTT, 19, false);
        burst.onSample(0, RTT, 24, false); // counter=3 → closes
        burst.onSample(0, RTT, 31, false); // counter=2 → closes  
        assertEquals("burst must not close before threshold", 35, burst.getLimit());
        assertEquals(20, burst.getLimit());  
        assertEquals(25, burst.getLimit());
        assertEquals(25, burst.getLimit());  
    public void testShortQuietPeriodDoesNotReopen() {  
 * compatible open source license.
