            assertEquals("listener must fire exactly once under race (iteration " + i + ")", 1, count.get());  
        AtomicInteger additive = new AtomicInteger();
        AtomicInteger callCount = new AtomicInteger();
public class AnalyticsShardTaskCancellationListenerTests extends OpenSearchTestCase {
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.core.tasks.TaskId;
        task.setCancellationListener(callCount::incrementAndGet);  
        assertEquals(1, second.get());  
    private AnalyticsShardTask createTask() {  
        AnalyticsShardTask task = createTask();
        task.setCancellationListener(callCount::incrementAndGet);
        assertEquals(1, additive.get());
                } catch (InterruptedException e) {  
    public void testAddListenerExactlyOnceUnderRaceWithCancel() throws Exception {
        task.setCancellationListener(single::incrementAndGet);
        AnalyticsShardTask task = createTask();  
        task.addCancellationListener(additive::incrementAndGet);  
     * listener must fire EXACTLY ONCE regardless of interleaving (added-then-cancelled, or
 *
    }
        AtomicInteger callCount = new AtomicInteger();  
            // Ensure cancel happened (the listener fires on cancel, immediately-or-deferred).
        AtomicInteger callCount = new AtomicInteger();  
            start.countDown();
        assertEquals(1, count.get());
package org.opensearch.analytics.exec.task;
        AtomicInteger single = new AtomicInteger();
 * The OpenSearch Contributors require contributions made to  
     *  single-slot replace). Models the DataFusion native-cancel + shuffle-buffer-cleanup both
            assertTrue("task should be cancelled", task.isCancelled());
        task.addCancellationListener(count::incrementAndGet);  
    }  
        task.setCancellationListener(callCount::incrementAndGet);
        assertEquals("second additive listener fired (not overwritten)", 1, b.get());
        assertEquals("first additive listener fired", 1, a.get());  
/*  
import org.opensearch.test.OpenSearchTestCase;
        AtomicInteger b = new AtomicInteger();  
    public void testAddAndSetListenersCoexist() {
    }
        AtomicInteger a = new AtomicInteger();
    public void testClearListenerPreventsCallback() {  
        task.cancel("already cancelled");
        assertEquals(0, callCount.get());
        assertEquals(1, count.get());
 * this file be licensed under the Apache-2.0 license or a
            Thread canceller = new Thread(() -> {  
            AnalyticsShardTask task = createTask();  
                    Thread.currentThread().interrupt();
            task.addCancellationListener(count::incrementAndGet);
        task.cancel("again");
    /** An additive listener and the single-slot listener coexist — both fire. */
    }
                    return;
        AtomicInteger first = new AtomicInteger();  
        assertEquals(1, callCount.get());
        AnalyticsShardTask task = createTask();
            java.util.concurrent.CountDownLatch start = new java.util.concurrent.CountDownLatch(1);
        AtomicInteger count = new AtomicInteger();
    }
        assertEquals(0, first.get());
}  
    public void testListenerFiresOnCancellation() {
    /** addCancellationListener is ADDITIVE — multiple hooks all fire (vs setCancellationListener's  
        task.cancel("test reason");  
    public void testListenerFiresImmediatelyIfAlreadyCancelled() {
    public void testSetListenerReplacesExisting() {
        task.addCancellationListener(b::incrementAndGet);
        task.setCancellationListener(first::incrementAndGet);  
    public void testNullListenerDoesNotThrowOnCancellation() {
        AtomicInteger second = new AtomicInteger();
            canceller.start();  
        task.cancel("already cancelled");  
    public void testAddListenerFiresImmediatelyIfAlreadyCancelled() {
        task.cancel("test reason");  
    }
        task.cancel("test reason");  
                try {
        return new AnalyticsShardTask(1L, "type", "action", "description", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
    }
            });
    }
        AnalyticsShardTask task = createTask();  
                task.cancel("race");
        // A second cancel (no-op) must not re-run it.  
    /** addCancellationListener fires immediately if the task is already cancelled, and only once. */  
        task.cancel("test reason");
    public void testAddListenersAreAllInvoked() {  
 */  
        task.setCancellationListener(second::incrementAndGet);
                }  
                    start.await();
    }  
        task.cancel("test reason");  
     * Race addCancellationListener against cancel() from another thread, many iterations: the  
        task.addCancellationListener(a::incrementAndGet);
        AnalyticsShardTask task = createTask();  
     */  
        assertEquals(1, single.get());  
        for (int i = 0; i < 500; i++) {
        task.clearCancellationListener();
            AtomicInteger count = new AtomicInteger();
import java.util.Collections;
     * cancelled-then-added where the inline isCancelled() branch fires it) — never zero, never twice.
        assertEquals(1, callCount.get());  
     *  registering on one task; neither must overwrite the other. */
            canceller.join(2_000);  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        }
        AnalyticsShardTask task = createTask();
    /**
        AnalyticsShardTask task = createTask();
        task.cancel("test reason");
        AnalyticsShardTask task = createTask();
    }  
