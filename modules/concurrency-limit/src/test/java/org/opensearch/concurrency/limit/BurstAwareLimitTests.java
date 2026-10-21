        // Algorithm changes base while window is closed — propagated without burst.
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 1, 1);
        FixedLimit base = new FixedLimit(20);
        @Override
        assertEquals("window must not close after 2 of 3", 25, burst.getLimit());
    }
     */
    public void testBurstWindowReopensAfterSustainedQuiet() {
        burst.onSample(0, RTT, 21, false);
        burst.onSample(0, RTT, 15, false); // counter=2
        assertEquals(25, burst.getLimit());
        burst.onSample(0, RTT, 20, false);
        // inflight in burst range but below base (< 20) — should not advance close counter.
    public void testBurstLimitFollowsAlgorithmUpdates() {
        burst.onSample(0, RTT, 18, false); // quiet counter=1
        burst.onSample(0, RTT, 20, false); // counter=1
        protected int _update(long s, long rtt, int inflight, boolean dropped) {
    }
        burst.onSample(0, RTT, 20, false);
        // Close should trigger after exactly 2 over-base samples.
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 15, false); // counter=1
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 2, 3);
        }
    public void testBurstWindowClosesAfterConsecutiveOverBaseSamples() {
    public void testIndependentCloseAndRecoveryThresholds() {
/*
        int[] lastNotified = { 0 };
    public void testBurstWindowDoesNotCloseForBelowBaseSamples() {
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 3, 5);
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 21, false);
        }
    }
        @Override
        assertSame(base, burst.getDelegate());
        burst.onSample(0, RTT, 20, false);
        assertEquals("recovery must not trigger before threshold=4", 20, burst.getLimit());
        burst.onSample(0, RTT, 12, false); // counter=3 — not yet (threshold=4)
        burst.onSample(0, RTT, 20, false); // counter=1
            super(limit);
        assertEquals(25, burst.getLimit());
        burst.onSample(0, RTT, 31, false); // counter=2 → closes
        // Algorithm grows the base — burst follows.
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 3, 5);
 * this file be licensed under the Apache-2.0 license or a
        // Close the window.
        void updateTo(int newLimit) {
        FixedLimit base = new FixedLimit(20);
        assertEquals(25, burst.getLimit());
     * A delegate whose limit never changes, regardless of onSample inputs.
        assertEquals("samples below base must not close the burst window", 25, burst.getLimit());
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 2, 3);
        burst.onSample(0, RTT, 15, false); // counter=1 again
        FixedLimit base = new FixedLimit(20);
    }
        assertEquals(20, burst.getLimit());
            super(initial);
        burst.onSample(0, RTT, 10, false); // counter=3
            return getLimit();
    }
    public void testNonSustainingSpikesDoNotCloseWindow() {
    public void testGetLimitReturnsDelegatePlusBurst() {
        assertEquals(20, burst.getLimit());
    }
        }
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 2, 3);
        }
        base.updateTo(25);
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 20, false); // counter=1
        burst.onSample(0, RTT, 15, false); // counter=2 — still < threshold=3
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 10, false); // counter=1
    public void testGetDelegateReturnsDelegate() {
        burst.onSample(0, RTT, 18, false);
        // Spike above base (counter=1), then quiet (counter resets), then spike (counter=1 again).
        MutableLimit(int initial) {
        burst.onSample(0, RTT, 18, false); // resets to 0
package org.opensearch.concurrency.limit;
        assertEquals(25, burst.getLimit());
        burst.notifyOnChange(newLimit -> lastNotified[0] = newLimit);
        // Recovery should not trigger until 4 below-base samples.
        assertEquals("burst window must remain closed before recovery threshold", 20, burst.getLimit());
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 2, 5);
    public void testZeroBurstCapacityIsTransparent() {
        assertEquals("listener must receive new limit on burst reopen", 25, lastNotified[0]);
        assertEquals(35, burst.getLimit()); // 30 + 5
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 24, false); // counter=3 → closes
}
        BurstAwareLimit burst = new BurstAwareLimit(base, 0, 3, 3);
    /**
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 3, 3);
            setLimit(newLimit);
        assertEquals("burst must be closed after N consecutive over-base samples", 30, burst.getLimit());
 *
        burst.onSample(0, RTT, 17, false); // quiet counter=3 → reopens
        burst.onSample(0, RTT, 22, false); // counter=2
        assertEquals("window must not close after 1 of 3", 25, burst.getLimit());
    private static class MutableLimit extends AbstractLimit {
import java.util.concurrent.TimeUnit;
        assertEquals("non-sustaining spikes must not close burst window", 25, burst.getLimit());
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 15, false); // counter=3 → reopens
        assertEquals(30, burst.getLimit()); // 25 + 5
        burst.onSample(0, RTT, 15, false);
        burst.onSample(0, RTT, 17, false); // resets to 0
 */
        burst.onSample(0, RTT, 10, false); // 1 quiet sample → reopens: limit 20 → 25
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 19, false); // quiet counter=2
        assertEquals("burst window must reopen after sustained quiet", 25, burst.getLimit());
        FixedLimit(int limit) {
        burst.onSample(0, RTT, 15, false); // counter=2
        burst.onSample(0, RTT, 30, false); // counter=1
    }
    }
        assertEquals(25, burst.getLimit());
        protected int _update(long s, long rtt, int inflight, boolean dropped) {
    }
        burst.onSample(0, RTT, 18, false); // counter=1
public class BurstAwareLimitTests extends OpenSearchTestCase {
        // inflight >= base (20) — these are over-base samples.
    }
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    }
        assertEquals("burst must not close before threshold", 35, burst.getLimit());
    }
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 3, 3);
    public void testListenerNotifiedOnLimitChange() {
            return getLimit();
        assertEquals("burst window must not reopen before recovery threshold", 20, burst.getLimit());
        assertEquals(20, base.getLimit());
    }
        assertEquals(25, burst.getLimit());
        // After threshold quiet samples the window reopens.
        assertEquals("window must close after 3 consecutive over-base samples", 20, burst.getLimit());
        assertEquals("burst window must remain closed before recovery threshold", 25, burst.getLimit());
     * Used to isolate BurstAwareLimit's window state machine from Vegas's adaptive behavior.
import com.netflix.concurrency.limits.limit.AbstractLimit;
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 3, 5);
    private static class FixedLimit extends AbstractLimit {
    private static final long RTT = TimeUnit.MILLISECONDS.toNanos(10);
        burst.onSample(0, RTT, 12, false); // counter=2
        MutableLimit base = new MutableLimit(20);
        assertEquals(base.getLimit(), burst.getLimit());
     */
        burst.onSample(0, RTT, 10, false); // counter=1
     * A delegate that can be driven to a new limit externally, simulating algorithm updates.
        assertEquals(25, burst.getLimit());
        base.updateTo(30);
        burst.onSample(0, RTT, 11, false); // counter=2
        // Close the burst window — 2 consecutive samples with inflight >= base (30).
    /**
        }
        burst.onSample(0, RTT, 19, false);
        burst.onSample(0, RTT, 21, false);
        assertEquals("listener must receive new limit on burst close", 20, lastNotified[0]);
        FixedLimit base = new FixedLimit(20);
        burst.onSample(0, RTT, 14, false); // counter=3 → reopens
        BurstAwareLimit burst = new BurstAwareLimit(base, 5, 2, 4);
        burst.onSample(0, RTT, 21, false); // counter=2 → closes
 * The OpenSearch Contributors require contributions made to
        burst.onSample(0, RTT, 21, false); // counter=1
    public void testShortQuietPeriodDoesNotReopen() {
        assertEquals("quiet counter reset by above-base sample must prevent premature reopen", 20, burst.getLimit());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(20, burst.getLimit());
        burst.onSample(0, RTT, 20, false); // 1 over-base sample → closes: limit 25 → 20
    }
        // Close after 2 consecutive over-base; recover after 4 consecutive below-base.
        burst.onSample(0, RTT, 21, false); // inflight >= base(20) → counter resets to 0
    public void testAboveBaseInflightResetsQuietCounter() {
        assertEquals(20, burst.getLimit());
        burst.onSample(0, RTT, 19, false); // counter=4 — still < threshold=5
        burst.onSample(0, RTT, 13, false); // counter=4 → reopens
