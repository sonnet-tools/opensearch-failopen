        when(listener.isCancelled()).thenReturn(false);
        AtomicReference<BackpressureStrategy.WaitResult> result = new AtomicReference<>();
     */
        for (int i = 0; i < 5; i++) {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;  
        when(listener.isReady()).thenReturn(false);
        assertEquals(BackpressureStrategy.WaitResult.READY, result.get());
        AtomicBoolean cancelled = new AtomicBoolean(false);  
        assertBusy(() -> assertEquals(Thread.State.TIMED_WAITING, waiter.getState()), 2, TimeUnit.SECONDS);
import java.util.concurrent.TimeUnit;  
     * Also verifies cleanup runs exactly once per cancel.
    public void testCancelCallbackRunsCleanupBeforeNotify() throws Exception {
 */  
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {});
        when(listener.isCancelled()).thenAnswer(inv -> cancelled.get());
 * compatible open source license.
        when(listener.isCancelled()).thenReturn(false);  
     * The channel's own setOnCancelHandler is intentionally NOT called by the channel —
    /**
     * The composed cancel callback must run channel cleanup BEFORE notifying waiters,  
     * waitForListener calls must all see READY without waiting for a fresh handler firing.
        ready.set(true);  
            result.set(bp.waitForListener(30_000));  
        waiter.join(2_000);  
        Thread waiter = new Thread(() -> {
import java.util.concurrent.atomic.AtomicBoolean;
            capturedReadyHandler.set(inv.getArgument(0));
        AtomicReference<Runnable> capturedCancelHandler = new AtomicReference<>();
    }  
        assertEquals("cleanup must run exactly once", 1, cleanupCount.get());
        }).when(listener).setOnReadyHandler(any(Runnable.class));  
        doAnswer(inv -> {  
        Thread waiter = new Thread(() -> {
        assertTrue("Fast path must not park (elapsed=" + elapsedMillis + "ms)", elapsedMillis < 100);
        }, "waiter");
        ServerStreamListener listener = mock(ServerStreamListener.class);  
        assertNotNull("onCancelHandler must be installed", capturedCancelHandler.get());  
    }
     */  
        ServerStreamListener listener = mock(ServerStreamListener.class);
     * Simulates gRPC's OnReadyHandler firing while the eventloop is parked.  
        }).when(listener).setOnCancelHandler(any(Runnable.class));
    public void testWaitForListenerTimeout() {
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {});
            // Channel cleanup flips the cancelled flag the strategy will observe on wake.  
        waiter.start();  
    /**  
    }
        ServerStreamListener listener = mock(ServerStreamListener.class);
        }
            waiterEntered.countDown();
        waiter.start();
        when(listener.isCancelled()).thenReturn(false);  
        bp.register(listener);
        doAnswer(inv -> {  
        doAnswer(inv -> {
     * gRPC's OnReadyHandler fires only on transitions (not-ready → ready), not on every  
    /**
            readyHandler.set(inv.getArgument(0));
        ServerStreamListener listener = mock(ServerStreamListener.class);
        }, "waiter");
        bp.register(listener);  
        doAnswer(inv -> {
     * waitForListener must return READY immediately when the listener is already ready.
package org.opensearch.arrow.flight.transport;
            assertEquals("call #" + i, BackpressureStrategy.WaitResult.READY, bp.waitForListener(5_000));
            cancelled.set(true);
    /**
        }).when(listener).setOnCancelHandler(any(Runnable.class));  
    public void testRepeatedWaitsReturnReadyWithoutRehandler() {
     * isReady()==true state. Once the listener is ready, multiple successive
    /**  
            return null;
     */  
        when(listener.isReady()).thenReturn(false);
        assertNotNull("onReadyHandler must be installed", capturedReadyHandler.get());
    }
public class CompositeBackpressureStrategyTests extends OpenSearchTestCase {
    public void testRegisterInstallsBothHandlers() {
            waiterEntered.countDown();  
    }  
import org.apache.arrow.flight.BackpressureStrategy;
     * so any thread that wakes observes the channel in its cancelled state.
        AtomicInteger cleanupCount = new AtomicInteger();
        cancelHandler.get().run();
        });  
        assertBusy(() -> assertEquals(Thread.State.TIMED_WAITING, waiter.getState()), 2, TimeUnit.SECONDS);
        CountDownLatch waiterEntered = new CountDownLatch(1);
        assertEquals(BackpressureStrategy.WaitResult.TIMEOUT, result);
import java.util.concurrent.CountDownLatch;
        bp.register(listener);  
        long elapsedMillis = (System.nanoTime() - start) / 1_000_000;
}
        AtomicReference<Runnable> readyHandler = new AtomicReference<>();
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {
        long start = System.nanoTime();
            capturedCancelHandler.set(inv.getArgument(0));
     * the strategy owns it, and channel cleanup runs via the composed cancelCallback.  
        assertEquals(BackpressureStrategy.WaitResult.CANCELLED, result.get());  
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.atomic.AtomicInteger;
        assertFalse("Waiter must have exited", waiter.isAlive());
        assertTrue("Should wait approximately the timeout (elapsed=" + elapsedMillis + "ms)", elapsedMillis >= 90);  
        when(listener.isReady()).thenReturn(true);  
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {});
    public void testReadyHandlerWakesWaiter() throws Exception {
/*  
     * Firing the captured onReadyHandler must wake a thread parked in waitForListener.
    /**
        AtomicBoolean ready = new AtomicBoolean(false);
     */
import static org.mockito.Mockito.mock;
     */
     * waitForListener must return TIMEOUT when neither ready nor cancelled fires within the timeout.  
        assertTrue(waiterEntered.await(2, TimeUnit.SECONDS));
        when(listener.isReady()).thenReturn(true);
import static org.mockito.Mockito.doAnswer;  
import static org.mockito.ArgumentMatchers.any;
            cancelHandler.set(inv.getArgument(0));  
            cleanupRanWhileWaiterStillSleeping.set(true);
     * register(listener) must install both onReady and onCancel handlers on the listener.
        assertTrue("cleanup must have run before notify woke the waiter", cleanupRanWhileWaiterStillSleeping.get());
        long start = System.nanoTime();
        BackpressureStrategy.WaitResult result = bp.waitForListener(5_000);  
 *
            cleanupCount.incrementAndGet();
        readyHandler.get().run();
        }).when(listener).setOnReadyHandler(any(Runnable.class));
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {});  
        ServerStreamListener listener = mock(ServerStreamListener.class);  
 * The OpenSearch Contributors require contributions made to  
        AtomicReference<BackpressureStrategy.WaitResult> result = new AtomicReference<>();  
        waiter.join(2_000);
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {});
        AtomicReference<Runnable> capturedReadyHandler = new AtomicReference<>();
        long elapsedMillis = (System.nanoTime() - start) / 1_000_000;  
import static org.mockito.Mockito.when;
    }  
        BackpressureStrategy.WaitResult result = bp.waitForListener(100);
    public void testWaitForListenerReadyFastPath() {  
        assertFalse("Waiter must have exited", waiter.isAlive());
import java.util.concurrent.atomic.AtomicReference;  
import org.apache.arrow.flight.FlightProducer.ServerStreamListener;
        when(listener.isCancelled()).thenReturn(false);
        bp.register(listener);
        AtomicReference<Runnable> cancelHandler = new AtomicReference<>();
        AtomicBoolean cleanupRanWhileWaiterStillSleeping = new AtomicBoolean(false);
     */
            return null;
            result.set(bp.waitForListener(30_000));
        CountDownLatch waiterEntered = new CountDownLatch(1);  
        bp.register(listener);
        assertEquals(BackpressureStrategy.WaitResult.READY, result);  
            return null;  
        // Fire the cancel handler — this is what gRPC would do on client cancel.
        assertTrue(waiterEntered.await(2, TimeUnit.SECONDS));  
        when(listener.isReady()).thenAnswer(inv -> ready.get());
        ServerStreamListener listener = mock(ServerStreamListener.class);  
        bp.register(listener);  
            return null;
