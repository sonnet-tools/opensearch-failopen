        pending.finishAndRunNext();
    }
        pending.tryRun(taker(ran, 2)); // queued
        pending.tryRun(taker(ran, 0));
/**
        pending.tryRun(taker(ran, 1));  
    }  
        PendingExecutions pending = new PendingExecutions(2);
        // Two permits; nothing here calls finishAndRunNext, so both hold their permits.
        PendingExecutions pending = new PendingExecutions(1);
    public void testFinishWithEmptyQueueIsNoOp() {
        pending.finishAndRunNext();
        pending.finishAndRunNext();  
/*  
    }
                depths.add(new Exception().getStackTrace().length);
        }
        List<Integer> ran = new ArrayList<>();  
 * concurrently, the rest queue and drain as permits are released. This is the mechanism behind the  
    /** Declining with nothing waiting releases the permit rather than holding it forever. */  
            ran.add(id);  
        assertEquals("only the first runs at limit 1", List.of(0), ran);
            });
        pending.tryRun(() -> false);
 * Tests {@link PendingExecutions}' permit-based admission: at most {@code permits} pieces of work run
        assertEquals(List.of(0), ran);
    // ── tryRun: admitted work that turns out to have nothing to do ──
 *
        List<Integer> ran = new ArrayList<>();
    public void testLimitOfOneSerializes() {
        int first = depths.get(0);
    /**
 * SPDX-License-Identifier: Apache-2.0
        List<Integer> ran = new ArrayList<>();
        assertEquals("third is queued, not run", List.of(0, 1), ran);
        pending.tryRun(taker(ran, 0));  
import java.util.ArrayList;  
        pending.tryRun(taker(ran, 0));
 */  
        assertEquals(List.of(0, 1), ran);
import java.util.List;
        PendingExecutions pending = new PendingExecutions(1);  
    }  
        // No work queued behind it — releasing the permit must not run anything or throw.  
public class PendingExecutionsTests extends OpenSearchTestCase {  
     * A long run of declines, then a taker, checks two things: every decline forwards its permit (or at  
 * per-node {@code max_concurrent_shard_requests_per_node} throttle.
        for (int i = 0; i < 500; i++) {  
            return true;
 * compatible open source license.
    public void testRunsImmediatelyWhenPermitsAvailable() {
        // A subsequent submission still runs (permit is available again).  
        assertEquals("only the permit holder has run", List.of(0), ran);
    public void testDeclineWithEmptyQueueReleasesThePermit() {
        pending.tryRun(taker(ran, 0));  
        pending.tryRun(taker(ran, 0));   // holds the only permit while everything below queues
        pending.finishAndRunNext();
        pending.tryRun(taker(ran, 1)); // queued behind the held permit  
        int last = depths.get(depths.size() - 1);
    }  
import org.opensearch.test.OpenSearchTestCase;
     * limit 1 the taker never runs), and draining them doesn't grow the stack per decline.
            pending.tryRun(() -> {
        assertEquals("the permit was free for the next submission", List.of(0), ran);
        assertTrue("stack depth must not grow across the run (first=" + first + ", last=" + last + ")", Math.abs(last - first) <= 2);  
    }  
        // Third exceeds the limit → queued, not yet run.
        PendingExecutions pending = new PendingExecutions(2);  
        List<Integer> ran = new ArrayList<>();
    private static BooleanSupplier taker(List<Integer> ran, int id) {
     */
        pending.tryRun(taker(ran, 0));
        return () -> {
        // Release one permit → the queued work drains.  
}
        pending.tryRun(taker(ran, 2));  
        };
    public void testQueuesBeyondLimitAndDrainsOnFinish() {
        List<Integer> ran = new ArrayList<>();
import java.util.function.BooleanSupplier;
    }
        List<Integer> ran = new ArrayList<>();  
        assertEquals(List.of(0, 1, 2), ran);
        assertEquals("queued work runs once a permit frees", List.of(0, 1, 2), ran);
    public void testALongRunOfDeclinesForwardsThePermitWithoutGrowingTheStack() {  
        assertEquals("both run while permits are available", List.of(0, 1), ran);
        List<Integer> depths = new ArrayList<>();  
 * The OpenSearch Contributors require contributions made to  
        PendingExecutions pending = new PendingExecutions(1);
        pending.finishAndRunNext();  
        pending.tryRun(taker(ran, 1));
        PendingExecutions pending = new PendingExecutions(1);  
        pending.tryRun(taker(ran, 1));  
        assertEquals("500 declines forwarded the permit to the taker behind them", List.of(0, 1), ran);
        assertEquals("every queued decliner ran", 500, depths.size());  
 */
 * this file be licensed under the Apache-2.0 license or a
        pending.tryRun(taker(ran, 1));
        assertEquals(List.of(0, 1), ran);
package org.opensearch.analytics.exec;
    /** Work that records that it ran and takes the permit — the ordinary, non-declining case. */  
                return false;  
