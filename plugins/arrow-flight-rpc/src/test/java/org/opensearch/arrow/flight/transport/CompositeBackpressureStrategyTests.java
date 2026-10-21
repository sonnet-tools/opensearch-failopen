        bp.register(listener);
     */
            result.set(bp.waitForListener(30_000));
            cleanupRanWhileWaiterStillSleeping.set(true);
        ServerStreamListener listener = mock(ServerStreamListener.class);
        BackpressureStrategy.WaitResult result = bp.waitForListener(5_000);
        }, "waiter");
    public void testCancelCallbackRunsCleanupBeforeNotify() throws Exception {
     * waitForListener calls must all see READY without waiting for a fresh handler firing.
     * The channel's own setOnCancelHandler is intentionally NOT called by the channel —
     */
     * register(listener) must install both onReady and onCancel handlers on the listener.
     * the strategy owns it, and channel cleanup runs via the composed cancelCallback.
        }).when(listener).setOnReadyHandler(any(Runnable.class));
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {});
        AtomicBoolean ready = new AtomicBoolean(false);
import org.opensearch.test.OpenSearchTestCase;
        Thread waiter = new Thread(() -> {
    public void testReadyHandlerWakesWaiter() throws Exception {
 */
        ServerStreamListener listener = mock(ServerStreamListener.class);
    }
        waiter.start();
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {});
        assertFalse("Waiter must have exited", waiter.isAlive());
        AtomicReference<Runnable> capturedCancelHandler = new AtomicReference<>();
            assertEquals("call #" + i, BackpressureStrategy.WaitResult.READY, bp.waitForListener(5_000));
     * Simulates gRPC's OnReadyHandler firing while the eventloop is parked.
    /**
     * Firing the captured onReadyHandler must wake a thread parked in waitForListener.
    /**
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {
        assertTrue(waiterEntered.await(2, TimeUnit.SECONDS));
        when(listener.isReady()).thenReturn(true);
        AtomicBoolean cancelled = new AtomicBoolean(false);
 *
        doAnswer(inv -> {
        bp.register(listener);
import java.util.concurrent.atomic.AtomicInteger;
        doAnswer(inv -> {
        });
 * The OpenSearch Contributors require contributions made to
        }).when(listener).setOnReadyHandler(any(Runnable.class));
        assertNotNull("onCancelHandler must be installed", capturedCancelHandler.get());
        CountDownLatch waiterEntered = new CountDownLatch(1);
        when(listener.isCancelled()).thenReturn(false);
 * compatible open source license.
    /**
        AtomicReference<BackpressureStrategy.WaitResult> result = new AtomicReference<>();
     * so any thread that wakes observes the channel in its cancelled state.
     * waitForListener must return READY immediately when the listener is already ready.
        long elapsedMillis = (System.nanoTime() - start) / 1_000_000;
            cancelled.set(true);
        AtomicBoolean cleanupRanWhileWaiterStillSleeping = new AtomicBoolean(false);
        }, "waiter");
        assertTrue("Fast path must not park (elapsed=" + elapsedMillis + "ms)", elapsedMillis < 100);
        // Fire the cancel handler — this is what gRPC would do on client cancel.
        CountDownLatch waiterEntered = new CountDownLatch(1);
        waiter.start();
        ready.set(true);
        BackpressureStrategy.WaitResult result = bp.waitForListener(100);
    }
            result.set(bp.waitForListener(30_000));
        long start = System.nanoTime();
            return null;
import java.util.concurrent.CountDownLatch;
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {});
import static org.mockito.Mockito.mock;
        bp.register(listener);
        when(listener.isCancelled()).thenReturn(false);
        ServerStreamListener listener = mock(ServerStreamListener.class);
import org.apache.arrow.flight.FlightProducer.ServerStreamListener;
            capturedReadyHandler.set(inv.getArgument(0));
        assertEquals("cleanup must run exactly once", 1, cleanupCount.get());
import static org.mockito.Mockito.when;
public class CompositeBackpressureStrategyTests extends OpenSearchTestCase {
        cancelHandler.get().run();
import static org.mockito.Mockito.doAnswer;
    }
        when(listener.isReady()).thenReturn(false);
        AtomicInteger cleanupCount = new AtomicInteger();
import org.apache.arrow.flight.BackpressureStrategy;
        AtomicReference<Runnable> capturedReadyHandler = new AtomicReference<>();
        ServerStreamListener listener = mock(ServerStreamListener.class);
        bp.register(listener);
        doAnswer(inv -> {
        waiter.join(2_000);
        long start = System.nanoTime();
        long elapsedMillis = (System.nanoTime() - start) / 1_000_000;
import java.util.concurrent.atomic.AtomicReference;
    public void testWaitForListenerReadyFastPath() {
import java.util.concurrent.TimeUnit;
        when(listener.isCancelled()).thenAnswer(inv -> cancelled.get());
    public void testRegisterInstallsBothHandlers() {
     * Also verifies cleanup runs exactly once per cancel.
            cancelHandler.set(inv.getArgument(0));
     * isReady()==true state. Once the listener is ready, multiple successive
        for (int i = 0; i < 5; i++) {
        assertTrue(waiterEntered.await(2, TimeUnit.SECONDS));
        Thread waiter = new Thread(() -> {
    public void testRepeatedWaitsReturnReadyWithoutRehandler() {
    }
        assertNotNull("onReadyHandler must be installed", capturedReadyHandler.get());
    }
        assertEquals(BackpressureStrategy.WaitResult.READY, result.get());
            // Channel cleanup flips the cancelled flag the strategy will observe on wake.
        assertBusy(() -> assertEquals(Thread.State.TIMED_WAITING, waiter.getState()), 2, TimeUnit.SECONDS);
            return null;
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {});
        CompositeBackpressureStrategy bp = new CompositeBackpressureStrategy(() -> {});
        assertEquals(BackpressureStrategy.WaitResult.TIMEOUT, result);
    public void testWaitForListenerTimeout() {
            waiterEntered.countDown();
            readyHandler.set(inv.getArgument(0));
        assertEquals(BackpressureStrategy.WaitResult.READY, result);
 * this file be licensed under the Apache-2.0 license or a
    }
        when(listener.isCancelled()).thenReturn(false);
        AtomicReference<BackpressureStrategy.WaitResult> result = new AtomicReference<>();
import java.util.concurrent.atomic.AtomicBoolean;
            capturedCancelHandler.set(inv.getArgument(0));
        assertBusy(() -> assertEquals(Thread.State.TIMED_WAITING, waiter.getState()), 2, TimeUnit.SECONDS);
        doAnswer(inv -> {
import static org.mockito.ArgumentMatchers.any;
        AtomicReference<Runnable> cancelHandler = new AtomicReference<>();
     */
    /**
        assertTrue("Should wait approximately the timeout (elapsed=" + elapsedMillis + "ms)", elapsedMillis >= 90);
 * SPDX-License-Identifier: Apache-2.0
            return null;
     * gRPC's OnReadyHandler fires only on transitions (not-ready → ready), not on every
     */
     * The composed cancel callback must run channel cleanup BEFORE notifying waiters,
     */
        when(listener.isReady()).thenAnswer(inv -> ready.get());
        when(listener.isCancelled()).thenReturn(false);
        assertFalse("Waiter must have exited", waiter.isAlive());
        when(listener.isReady()).thenReturn(true);
        ServerStreamListener listener = mock(ServerStreamListener.class);
        readyHandler.get().run();
}
/*
     * waitForListener must return TIMEOUT when neither ready nor cancelled fires within the timeout.
        waiter.join(2_000);
            cleanupCount.incrementAndGet();
package org.opensearch.arrow.flight.transport;
        when(listener.isReady()).thenReturn(false);
        }).when(listener).setOnCancelHandler(any(Runnable.class));
        }
        bp.register(listener);
        AtomicReference<Runnable> readyHandler = new AtomicReference<>();
    /**
            waiterEntered.countDown();
     */
        ServerStreamListener listener = mock(ServerStreamListener.class);
    /**
        assertEquals(BackpressureStrategy.WaitResult.CANCELLED, result.get());
        assertTrue("cleanup must have run before notify woke the waiter", cleanupRanWhileWaiterStillSleeping.get());
        }).when(listener).setOnCancelHandler(any(Runnable.class));
            return null;
        bp.register(listener);
