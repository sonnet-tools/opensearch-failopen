import static org.mockito.Mockito.doAnswer;
                }
                    err.set(t);
    // ── Byte-serialized path: stream root reused, freed once ──
                try {
            assertEquals("rejected source must be freed", 0, realAllocator.getAllocatedMemory());
            VectorSchemaRoot empty = new VectorSchemaRoot(new ArrayList<>(), new ArrayList<>(), 0);
            waiterEntered.countDown();
        return root;
            super(root, metadata);
            });
            releasePutNext.countDown();
            ch.sendBatch(new TestArrowResponse(root, metadata), FlightServerChannelTests::emptyHeader);
        executor = Executors.newSingleThreadExecutor();
        CountDownLatch start = new CountDownLatch(1);
    }
                return null;
            // Fire the cancel -> close() from this (gRPC-like) thread. It must NOT block, and must post
            );
        }).when(listener).setOnCancelHandler(any(Runnable.class));
    public void testCloseFreesStreamRootOnExecutor() throws Exception {
            ch.close(); // from the test thread (not the executor)
        Thread waiter = new Thread(() -> {
        ready.set(true);
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
        ready.set(false);
            // The executor thread is still inside putNext, so the queued free has not run: buffers live.
    /**
        try (RootAllocator realAllocator = new RootAllocator()) {
                return null;
            });
        }
        IntVector vec = (IntVector) root.getVector("v");
            assertEquals("byte stream root must be freed exactly once at close", 0, realAllocator.getAllocatedMemory());
        try (RootAllocator realAllocator = new RootAllocator()) {
        ready.set(true);
        assertEquals(StreamErrorCode.CANCELLED, ((StreamException) t).getErrorCode());
import static org.mockito.Mockito.never;
        assertTrue("channel must remain open after timeout — handler may still relay", ch.isOpen());
     * executor runs the posted free.
    /**
     * fires immediately on {@code close()} (it touches no Arrow buffers), but the buffers stay alive
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.arrow.vector.types.pojo.Schema;
     */
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
        }
            StreamException ex = expectThrows(
     * executor so the free has run before asserting allocator state — submitting a no-op and waiting
        assertTrue(waiterEntered.await(2, TimeUnit.SECONDS));
        ch.addCloseListener(removed);
    }
    /** When the channel is cancelled, sendBatch rejects and frees the source root exactly once (no leak). */
            verify(listener, times(2)).putNext();
     * The channel cleanup ({@code recordCallEnd}, close) must run exactly once.
            ts.add(t);
        AtomicBoolean fired = new AtomicBoolean(false);
            drainExecutor();
import static org.mockito.Mockito.verify;
    public void testSendBatchPutNextThrowableFreesSourceAndStreamRootClosable() throws Exception {
                inPutNext.countDown();
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
        ch.close();
        capturedCancelHandler.get().run(); // cancel -> close
                buf.getBytes(0, copy);
    // ── Source-root ownership (the channel frees it exactly once) ──
    private AtomicBoolean listenerCancelled;
    private static VectorSchemaRoot newSingleIntRoot(BufferAllocator allocator, int value) {
        FlightServerChannel ch = newChannel(5_000);
import org.opensearch.core.transport.TransportResponse;
            blockExecutor.countDown();
        vec.setValueCount(1);
        }, "producer-waiter");
        for (int i = 0; i < listeners; i++) {
        List<Thread> waiters = new ArrayList<>(n);
            verify(listener, times(1)).putNext();
                    ch.awaitReadyOrThrow();
            for (int i = 0; i < queued; i++) {
        assertFalse("Waiter must have exited", waiter.isAlive());
    @Override
        callTracker = mock(FlightCallTracker.class);
            }).when(listener).putNext();
        capturedCancelHandler.get().run();
        FlightServerChannel ch = newChannel(5_000);
     * native batches, then fire the cancel (which sets cancelled/closed and posts the root free behind
                () -> ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader)
        FlightServerChannel ch = newChannel(30_000);
                });
                waiterError.set(t);
        assertNull("awaitReadyOrThrow must return normally on READY", waiterError.get());
        assertTrue("Message should reference the timeout", ex.getMessage().contains("100ms"));
        }
        ch.addCloseListener(org.opensearch.core.action.ActionListener.wrap(r -> secondFired.set(true), e -> {}));
    // ── Native send: metadata framing ──
        assertTrue("Fast path must not park (elapsed=" + elapsedMs + "ms)", elapsedMs < 100);
        ch.removeCloseListener(removed);
    private static ByteBuffer emptyHeader() {
    }
            CountDownLatch executorBusy = new CountDownLatch(1);
            // source was freed by its own sendBatch finally.
        try (RootAllocator realAllocator = new RootAllocator()) {
    /**
            List<Throwable> sendErrors = new ArrayList<>();
     * channel's own cancelled flag short-circuits before we consult the strategy.
        StreamException ex = expectThrows(StreamException.class, ch::awaitReadyOrThrow);
        try (RootAllocator realAllocator = new RootAllocator()) {
        for (Thread w : waiters) {
        TestArrowResponse(VectorSchemaRoot root, byte[] metadata) {
     */
        long start = System.nanoTime();
/*
        }
            drainExecutor();
                            sendErrors.add(t);
    /**
}
                }
            assertNotNull("stream root was adopted before putNext threw", ch.getRoot());
     * close() posts the stream-root free onto the flight executor (single-writer model). Drain the
     * Cross-thread close() never frees buffers inline: when close() is called from a non-executor
    }
            // Send a batch on the executor so the channel adopts a stream root, then drain.
            assertTrue("send must reach putNext", inPutNext.await(5, TimeUnit.SECONDS));
        FlightServerChannel ch = newChannel(30_000);
        // Channel cleanup must be invoked exactly once even though N threads observed cancel.
        vec.allocateNew();
        AtomicInteger fires = new AtomicInteger(0);
            assertTrue("must be StreamException, got " + t, t instanceof StreamException);
        listenerCancelled.set(true);
        FlightServerChannel ch = newChannel(5_000);
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 5);
    }
import java.util.List;
    private AtomicReference<Runnable> capturedCancelHandler;
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 11);
            // to the BACK of the executor queue (after the queued batches).
        listenerCancelled.set(true);
package org.opensearch.arrow.flight.transport;
        int threads = 8;
     * sendBatch with non-null metadata must call {@code putNext(ArrowBuf)} (not {@code putNext()})
            assertEquals("header-throw must not leak source or created stream root", 0, realAllocator.getAllocatedMemory());
    public void testSendErrorNoOpAfterComplete() {
    private AtomicReference<Runnable> capturedReadyHandler;
        ch.completeStream(emptyHeader());
        assertEquals("the listener that was kept must fire exactly once", 1, fires.get());
                    }
            assertTrue("stream root should be alive after a batch", realAllocator.getAllocatedMemory() > 0);
        return new FlightServerChannel(listener, allocator, middleware, callTracker, executor, readyTimeoutMillis);
        ready.set(false);
     * single executor thread), a concurrent cancel -> {@code close()} must NOT free the stream root —
    public void testCompleteStreamOnlyOnce() {
import org.opensearch.test.OpenSearchTestCase;
            assertNotNull("channel must retain the stream root", ch.getRoot());
        }, "producer-waiter");
        try (RootAllocator realAllocator = new RootAllocator()) {
        verify(callTracker).recordCallEnd(StreamErrorCode.CANCELLED.name());
     * them). When the executor drains: each queued batch hits the {@code cancelled} guard in
        CountDownLatch waiterEntered = new CountDownLatch(1);
            assertEquals("no queued source root may leak after cancel", 0, realAllocator.getAllocatedMemory());
    }
        ch.close();
    /** Concurrent close() callers must each fire every close listener exactly once (no double-fire). */
     */
import java.util.ArrayList;
            Thread t = new Thread(() -> {
    public void testAwaitReadyParksUntilOnReadyFires() throws Exception {
        }
            }
        }
    /** At most one terminal gRPC op: a second completeStream is a no-op. */
     * Batches queued behind a cancel must not leak. While the executor is busy, we enqueue several
        executor.awaitTermination(5, TimeUnit.SECONDS);
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
        waiter.join(2_000);
    /** A successful native send empties+frees the source root and retains the stream root until close(). */
        listenerCancelled.set(true);
                IllegalStateException.class,
        Schema schema = new Schema(List.of(new Field("v", FieldType.nullable(new ArrowType.Int(32, true)), null)));
                    } catch (Throwable t) {
        return ByteBuffer.allocate(0);
 *
            assertFalse("channel must be marked closed immediately", ch.isOpen());
import org.opensearch.arrow.transport.ArrowBatchResponse;
        assertTrue("must be StreamException, got " + t, t instanceof StreamException);
        listenerCancelled.set(true);
                }
        TestArrowResponse(StreamInput in) throws IOException {
            assertEquals("source must be freed even on the empty-vectors throw", 0, realAllocator.getAllocatedMemory());
        for (Thread w : waiters) {
    /** Minimal non-Arrow response that drives the byte-serialization path. */
        capturedCancelHandler.get().run();
            VectorSchemaRoot afterFirst = ch.getRoot();
    private FlightServerChannel newChannel(long readyTimeoutMillis) {
        ch.addCloseListener(kept);
        }).when(listener).setOnReadyHandler(any(Runnable.class));
    public void testAwaitReadyOnAlreadyCancelledChannelThrows() {
    }
import org.apache.arrow.memory.ArrowBuf;
     * All concurrent producer threads parked in {@code awaitReadyOrThrow} must wake on a
            assertEquals("close must free the stream root", 0, realAllocator.getAllocatedMemory());
            assertNotNull("each waiter must have thrown", t);
            capturedCancelHandler.get().run(); // cancel -> close
            try {
            super(in);
                assertTrue("queued batches must reject with CANCELLED, got " + t, t instanceof StreamException);
                try {
            assertTrue("all queued sources must be allocated", realAllocator.getAllocatedMemory() > 0);
        ch.sendError(emptyHeader(), new RuntimeException("after complete"));
        verify(listener, never()).completed();
        }
            // behind both the send and the free.
                ArrowBuf buf = inv.getArgument(0);
import java.util.concurrent.atomic.AtomicReference;
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;
        assertEquals(StreamErrorCode.CANCELLED, ex.getErrorCode());
            assertTrue("executor must be busy", executorBusy.await(5, TimeUnit.SECONDS));
        waiter.join(2_000);
                return null;
     */
            ch.close();
        try (RootAllocator realAllocator = new RootAllocator()) {
        FlightServerChannel ch = newChannel(5_000);
            assertEquals("every queued batch must have rejected", queued, sendErrors.size());
            assertEquals("all buffers must be freed", 0, realAllocator.getAllocatedMemory());
            VectorSchemaRoot root = newSingleIntRoot(realAllocator, 7);
            // The mock doesn't, so close it here to avoid an allocator leak at test teardown.
        Thread waiter = new Thread(() -> {
        ch.sendError(emptyHeader(), new RuntimeException("late"));
            AtomicReference<byte[]> capturedMetadata = new AtomicReference<>();
import static org.mockito.Mockito.when;
    }
    private AtomicBoolean ready;
    public void testCompleteStreamNoOpAfterCancel() {
            } catch (Throwable t) {
        start.countDown();
import java.nio.charset.StandardCharsets;
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
    public void testCancelWakesAllParkedProducers() throws Exception {
        ch.awaitReadyOrThrow();
        for (int i = 0; i < n; i++) {
    public void testRemovableCloseListenerCanBeGivenBack() {
    public void testReleaseUnsentFreesSource() throws Exception {
                buf.close();
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 13);
            ch.close();
        }
        assertNotNull("waiter must have thrown", t);
            // Run the send ON the executor, exactly as production does — this is what serializes the
            });
    public void testByteMultiBatchReusesStreamRootFreedOnce() throws Exception {
import java.util.concurrent.atomic.AtomicBoolean;
        }
    }
import static org.mockito.ArgumentMatchers.any;
            assertEquals("source root must be empty/freed after the throw", 0, source.getRowCount());
     */
        try (RootAllocator realAllocator = new RootAllocator()) {
        super.tearDown();
 * The OpenSearch Contributors require contributions made to
     * — even if the underlying listener somehow reports {@code isReady()==true}. The
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
        assertTrue("listener added after close must fire immediately", fired.get());
     */
                    assertTrue(blockExecutor.await(5, TimeUnit.SECONDS));
            }
            doThrow(new AssertionError("putNext boom")).when(listener).putNext();
        FlightServerChannel ch = newChannel(30_000);
            drainExecutor();
        verify(callTracker, org.mockito.Mockito.times(1)).recordCallEnd(StreamErrorCode.CANCELLED.name());
    }
        FlightServerChannel ch = newChannel(5_000);
    }
        java.util.function.BiConsumer<Void, ? super Exception> removed = (v, e) -> fail("a removed listener must not fire");
            );
    public void testSendBatchWithMetadataCallsPutNextWithBuf() throws Exception {
        executor.submit(() -> {}).get(5, TimeUnit.SECONDS);
    private void drainExecutor() throws Exception {
                try {
    }
                byte[] copy = new byte[(int) buf.readableBytes()];
            verify(listener, never()).start(any());
    private BufferAllocator allocator;
            // Release the executor and let it drain the blocked task, the queued batches, and the free.
    /**
        assertTrue(waiterEntered.await(2, TimeUnit.SECONDS));
            AtomicReference<Throwable> sendError = new AtomicReference<>();
        public void writeTo(StreamOutput out) throws IOException {
            assertFalse("channel must be marked closed immediately", ch.isOpen());
            // Let the send finish; the executor then runs the queued free task. drainExecutor() waits
    /** Minimal send-side ArrowBatchResponse for tests. */
    }
    static final class TestArrowResponse extends ArrowBatchResponse {
    public void testSendBatchAfterCloseRejectsAndFreesSource() throws Exception {
    /** When the channel is closed, sendBatch rejects and frees the source root exactly once. */
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
            verify(listener, never()).putNext(any(ArrowBuf.class));
            t.join(5_000);
    public void testAwaitReadyTimeoutThrowsTimedOut() {
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;
            ch.close();
    private ServerStreamListener listener;
        ch.addCloseListener(org.opensearch.core.action.ActionListener.wrap(r -> { throw new RuntimeException("listener boom"); }, e -> {}));
import static org.mockito.Mockito.doThrow;
        Throwable t = waiterError.get();
        try (RootAllocator realAllocator = new RootAllocator()) {
        FlightServerChannel ch = newChannel(5_000);
    /**
        List<Thread> ts = new ArrayList<>();
            assertSame("byte path must reuse the same stream root across batches", afterFirst, ch.getRoot());
    }
        assertEquals(StreamErrorCode.CANCELLED, ex.getErrorCode());
import static org.mockito.Mockito.mock;
                        synchronized (sendErrors) {
                capturedMetadata.set(copy);
        FlightServerChannel ch = newChannel(5_000);
                }
    }
        super.setUp();
    /** completeStream is a no-op after the channel was cancelled (no terminal op after cancel). */
            AtomicReference<Throwable> err = new AtomicReference<>();
        verify(listener, never()).error(any());
import java.nio.ByteBuffer;
        ch.completeStream(emptyHeader());
                    Thread.currentThread().interrupt();
        vec.setSafe(0, value);
            assertEquals("close() must free the adopted stream root after a putNext Throwable", 0, realAllocator.getAllocatedMemory());
    /** A removable close listener fires on close, and is no longer fired once it has been removed. */
                        ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader);
            VectorSchemaRoot root = newSingleIntRoot(realAllocator, 1);
            super(root);
import org.apache.arrow.flight.FlightProducer.ServerStreamListener;
        }
        // the contract, and is verified end-to-end via the handler/transport-channel paths.
        }
        AtomicBoolean fired = new AtomicBoolean(false);
        ch.completeStream(emptyHeader());
            drainExecutor();
        java.util.function.BiConsumer<Void, ? super Exception> kept = (v, e) -> fires.incrementAndGet();
            }).when(listener).putNext(any(ArrowBuf.class));
            drainExecutor();
            try {
        listenerCancelled.set(true);
                    ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader);
    }
            assertTrue("stream root must still be alive while the send occupies the executor", realAllocator.getAllocatedMemory() > 0);
            capturedReadyHandler.set(inv.getArgument(0));
import java.io.IOException;
    /** If the header supplier throws (S8), the source root is still freed and no stream root leaks. */
    /** Multi-batch byte path reuses one VarBinary stream root and frees it exactly once at close(). */
            CountDownLatch releasePutNext = new CountDownLatch(1);
    }
    }
                IllegalStateException.class,
    static final class BytesResponse extends TransportResponse {
    public void tearDown() throws Exception {
            capturedCancelHandler.get().run();
            t.start();
     * Cancellation while a producer thread is parked must wake it with a CANCELLED
            assertEquals("source root must be empty after transfer", 0, source.getRowCount());
        // exception via channel.sendResponse(e), and FlightServerChannel.sendError records
                    Thread.currentThread().interrupt();
    public void testAwaitReadyAfterCancelStaysCancelled() {
            verify(listener, never()).putNext();
    /** Once completed(), a later sendError must not also issue error() (single terminal op). */
import org.opensearch.core.common.io.stream.StreamOutput;
     * Single-writer model: the send runs on the flight executor and {@code close()} posts the
            ch.addCloseListener(org.opensearch.core.action.ActionListener.wrap(r -> fires.incrementAndGet(), e -> {}));
            assertBusy(() -> assertEquals(Thread.State.TIMED_WAITING, w.getState()), 2, TimeUnit.SECONDS);
import org.apache.arrow.vector.types.pojo.FieldType;
            assertEquals("close() must free the stream root via the executor", 0, realAllocator.getAllocatedMemory());
     * for it guarantees the earlier-queued free task completed (FIFO, single-threaded).
            assertNotNull("byte path must create a stream root", afterFirst);
    }
            CountDownLatch inPutNext = new CountDownLatch(1);
    private ServerHeaderMiddleware middleware;
import org.apache.arrow.vector.types.pojo.ArrowType;
            verify(listener, times(1)).putNext(any(ArrowBuf.class));
    public void testCancelWhileWaitingThrowsAndRunsChannelCleanup() throws Exception {
            assertEquals("rejected source must be freed (no leak, no stream root created)", 0, realAllocator.getAllocatedMemory());
    public void setUp() throws Exception {
        }
        allocator = mock(BufferAllocator.class);
            listenerCancelled.set(true);
        try (RootAllocator realAllocator = new RootAllocator()) {
        // the call end. Without that relay, no recordCallEnd would happen here — that is
        verify(callTracker, org.mockito.Mockito.never()).recordCallEnd(any());
            ch.sendBatch(new TestArrowResponse(root), FlightServerChannelTests::emptyHeader);
                assertTrue("test timed out waiting to release putNext", releasePutNext.await(5, TimeUnit.SECONDS));
import org.opensearch.transport.stream.StreamErrorCode;
                waiterError.set(t);
        waiter.start();
    }
    public void testSendBatchFreesSourceRootRetainsStreamRoot() throws Exception {
        AtomicInteger fires = new AtomicInteger(0);
    /** An empty-field-vector native batch throws but still frees the source (S8 early-throw path). */
    }
            ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader);
        ch.close();
    private FlightCallTracker callTracker;
     * stream-root free onto that same executor. While a send is mid-{@code putNext} (occupying the
                ch.sendBatch(new TestArrowResponse(newSingleIntRoot(realAllocator, 8)), FlightServerChannelTests::emptyHeader);
                ch.close();
    // ── close() fire-once + listener semantics ──
            ch.sendBatch(new BytesResponse(new byte[] { 1, 2, 3 }), FlightServerChannelTests::emptyHeader);
 * compatible open source license.
        try (RootAllocator realAllocator = new RootAllocator()) {
        BytesResponse(byte[] data) {
    public void testThrowingCloseListenerDoesNotStrandOthers() {
    /** A throwing close listener must not strand the remaining listeners. */
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 2);
            for (Throwable t : sendErrors) {
            // Occupy the single executor thread so the batches below sit in the queue, not run.
        assertEquals(StreamErrorCode.TIMED_OUT, ex.getErrorCode());
        listener = mock(ServerStreamListener.class);
                } catch (InterruptedException e) {
            waiters.add(w);
            this.data = data;
            );
            expectThrows(IOException.class, () -> ch.sendBatch(new TestArrowResponse(source), () -> { throw new IOException("boom"); }));
     * channel adopted the stream root, the source root is still freed by sendBatch's finally, the stream
        FlightServerChannel ch = newChannel(100);
import org.opensearch.core.common.io.stream.StreamInput;
     * If {@code putNext} throws a non-Exception {@code Throwable} (e.g. OOM / AssertionError) AFTER the
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 15);
     */
            }
        AtomicReference<Throwable> waiterError = new AtomicReference<>();
    /** sendError is a no-op after the channel was cancelled. */
        StreamException ex = expectThrows(StreamException.class, ch::awaitReadyOrThrow);
        ready.set(false);
    public void testAddRemovableCloseListenerAfterCloseFiresImmediately() {
            assertTrue("stream root buffers are still alive (owned by the channel)", realAllocator.getAllocatedMemory() > 0);
     * {@code finally}; the posted root-free task (last in FIFO order) frees the stream root. Nothing is
import org.opensearch.arrow.flight.stats.FlightCallTracker;
    public void testSendErrorNoOpAfterCancel() {
            }).get(5, TimeUnit.SECONDS);
import java.util.concurrent.TimeUnit;
    public void testSendBatchEmptyFieldVectorsFreesSource() throws Exception {
        private final byte[] data;
            expectThrows(AssertionError.class, () -> ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader));
            expectThrows(
        ready = new AtomicBoolean(false);
        assertFalse("Waiter must have exited", waiter.isAlive());
    @Override
        ch.addCloseListener((java.util.function.BiConsumer<Void, ? super Exception>) (v, e) -> fired.set(true));
        ready.set(false);
    }
        FlightServerChannel ch = newChannel(5_000);
        }
        verify(listener, never()).error(any());
import org.apache.arrow.vector.IntVector;
                entered.countDown();
        middleware = mock(ServerHeaderMiddleware.class);
            CountDownLatch blockExecutor = new CountDownLatch(1);
    public void testCloseIsFireOnceUnderConcurrentCallers() throws Exception {
     */
     * is responsible for invoking close() on this path; see FlightOutboundHandlerTests.)
    }
            ch.close();
import org.opensearch.transport.stream.StreamException;
    }
        assertTrue("listener added after close must fire immediately", fired.get());
     */
                executorBusy.countDown();
        FlightServerChannel ch = newChannel(5_000);
    }
        when(middleware.getCorrelationId()).thenReturn("42");
            expectThrows(
            // No stream root was ever created (every batch rejected before transfer), and each queued
            waiterEntered.countDown();
    /** A close listener registered after close() fires immediately. */
     * until the send completes, then are freed exactly once.
    public void testSendBatchHeaderThrowsFreesSource() throws Exception {
    // ── S4: cancel races an in-flight send; the root free must run behind the send (no use-after-free) ──
            verify(listener, times(1)).start(any()); // start only on the first batch
    /**
        assertEquals("each close listener must fire exactly once across all concurrent close() callers", listeners, fires.get());
 */
        List<AtomicReference<Throwable>> errors = new ArrayList<>(n);
        capturedCancelHandler.get().run();
            capturedCancelHandler.set(inv.getArgument(0));
        }
            assertTrue("stream root buffers must still be alive before close", realAllocator.getAllocatedMemory() > 0);
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
            capturedCancelHandler.get().run();
        try (RootAllocator realAllocator = new RootAllocator()) {
        FlightServerChannel ch = newChannel(5_000);
        FlightServerChannel ch = newChannel(30_000);
     * the free is queued behind the in-flight send and runs only after it returns. The close listener
        int listeners = 3;
        when(listener.isReady()).thenAnswer(inv -> ready.get());
            executor.execute(() -> {
        TestArrowResponse(VectorSchemaRoot root) {
        try (RootAllocator realAllocator = new RootAllocator()) {
                    start.await();
            }
public class FlightServerChannelTests extends OpenSearchTestCase {
     * StreamException AND run the channel's onChannelCancelled cleanup (recordCallEnd, close).
            w.start();
                ch.awaitReadyOrThrow();
    }
        try (RootAllocator realAllocator = new RootAllocator()) {
            return null;
        executor.shutdownNow();
        for (Thread t : ts) {
    }
        CountDownLatch entered = new CountDownLatch(n);
        // TIMED_OUT does not run channel cleanup. The handler is expected to relay the
        }
                } catch (InterruptedException e) {
                } catch (Throwable t) {
        doAnswer(inv -> {
    }
        assertBusy(() -> assertEquals(Thread.State.TIMED_WAITING, waiter.getState()), 2, TimeUnit.SECONDS);
            ch.close();
import java.util.concurrent.ExecutorService;
        ready.set(true); // intentionally true to ensure the channel-level guard wins
            verify(listener, never()).start(any());
                ch.awaitReadyOrThrow();
        AtomicBoolean secondFired = new AtomicBoolean(false);
                        }
        }
            executor.submit(() -> {
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 9);
        listenerCancelled.set(true);
    /** sendBatch without metadata must call the no-arg {@code putNext()} variant. */
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
            assertNull("send must complete without error", sendError.get());
     * dropped, leaked, or double-freed.
            int queued = 4;
        }
        capturedCancelHandler = new AtomicReference<>();
            // close()-posted free behind it.
            // Cancel now (from the gRPC-like thread): sets cancelled, flips open, posts the root free
            // Queue several native batches behind the blocked task. Each carries its own source root.
        AtomicReference<Throwable> waiterError = new AtomicReference<>();
    }
        }
            drainExecutor();
            doAnswer(inv -> {
        }
            executor.execute(() -> {
            assertEquals(StreamErrorCode.CANCELLED, ((StreamException) t).getErrorCode());
    public void testAwaitReadyFastPath() {
import org.apache.arrow.vector.types.pojo.Field;
            // the root free onto the busy executor rather than freeing inline.
     * thread, the stream root is freed on the executor (single-writer), so it stays alive until the
            assertEquals(StreamErrorCode.CANCELLED, ex.getErrorCode());
                () -> ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader)
     * After a cancel, subsequent {@code awaitReadyOrThrow} calls must throw immediately
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
            // In production, Flight's putNext(ArrowBuf) takes ownership and frees the buffer.
        capturedCancelHandler.get().run();
    }
            }, "producer-waiter-" + i);
    }
    /** releaseUnsent frees the source root of a batch that never reached sendBatch (failed hand-off). */
                    sendError.set(t);
        }
import java.util.concurrent.Executors;
        assertTrue("Already-cancelled path must not park (elapsed=" + elapsedMs + "ms)", elapsedMs < 100);
        CountDownLatch waiterEntered = new CountDownLatch(1);
        assertBusy(() -> assertEquals(Thread.State.TIMED_WAITING, waiter.getState()), 2, TimeUnit.SECONDS);
            ch.releaseUnsent(new TestArrowResponse(source));
        doAnswer(inv -> {
        }
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
        verify(listener, times(1)).completed();
    public void testCancelDuringInFlightSendDefersRootFree() throws Exception {
                } catch (Throwable t) {
     * single cancel — none should be left hanging until {@code readyTimeoutMillis}.
                    try {
            verify(listener, never()).start(any());
    }
        verify(listener, times(1)).completed();
            errors.add(err);
            assertFalse("Waiter " + w.getName() + " must have exited", w.isAlive());
            drainExecutor();
            assertEquals("stream root must be freed exactly once after the send drains", 0, realAllocator.getAllocatedMemory());
    }
        int n = 4;
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 3);
import java.util.concurrent.CountDownLatch;
        }
    public void testBatchesQueuedBehindCancelAreRejectedAndFreed() throws Exception {
     * root is retained (owned by the channel), and a subsequent close() frees it — no leak. (The handler
                StreamException.class,
        }
            byte[] metadata = "{\"output_rows\":1}".getBytes(StandardCharsets.UTF_8);
    private ExecutorService executor;
        root.setRowCount(1);
            Thread w = new Thread(() -> {
        long start = System.nanoTime();
            return null;
        }
            } catch (Throwable t) {
 * SPDX-License-Identifier: Apache-2.0
     * with a buffer carrying the exact bytes the producer attached.
            out.writeByteArray(data);
    public void testSendBatchAfterCancelRejectsAndFreesSource() throws Exception {
        assertFalse("channel must be closed after cancel", ch.isOpen());
        listenerCancelled = new AtomicBoolean(false);
            assertArrayEquals("metadata bytes must round-trip into the ArrowBuf", metadata, capturedMetadata.get());
import org.apache.arrow.vector.VectorSchemaRoot;
    }
import org.apache.arrow.memory.RootAllocator;
        for (int i = 0; i < threads; i++) {
    public void testAddCloseListenerAfterCloseFiresImmediately() {
        ch.addCloseListener(org.opensearch.core.action.ActionListener.wrap(r -> fired.set(true), e -> {}));
            ch.sendBatch(new BytesResponse(new byte[] { 4, 5 }), FlightServerChannelTests::emptyHeader);
        capturedReadyHandler.get().run();
            Throwable t = err.get();
    }
        ch.completeStream(emptyHeader());
        capturedReadyHandler = new AtomicReference<>();
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
 * this file be licensed under the Apache-2.0 license or a
                executor.execute(() -> {
import static org.mockito.Mockito.times;
            // Channel owns the (transferred) stream root; close() posts the free to the executor.
        StreamException ex = expectThrows(StreamException.class, ch::awaitReadyOrThrow);
        assertTrue("a throwing listener must not prevent later listeners from firing", secondFired.get());
    /** A removable close listener registered after close() fires immediately. */
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
            w.join(2_000);
            assertEquals("all buffers must be freed", 0, realAllocator.getAllocatedMemory());
        when(listener.isCancelled()).thenAnswer(inv -> listenerCancelled.get());
            doAnswer(inv -> {
        waiter.start();
            assertEquals("releaseUnsent must free the unsent source root", 0, realAllocator.getAllocatedMemory());
    /**
    // ── Terminal-op contracts ──
        ch.close();
    public void testSendBatchWithoutMetadataCallsPutNextNoArg() throws Exception {
        FlightServerChannel ch = newChannel(30_000);
        capturedCancelHandler.get().run();
                try {
    }
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
                assertEquals(StreamErrorCode.CANCELLED, ((StreamException) t).getErrorCode());
    }
                () -> ch.sendBatch(new TestArrowResponse(empty), FlightServerChannelTests::emptyHeader)
        for (AtomicReference<Throwable> err : errors) {
        assertTrue(entered.await(2, TimeUnit.SECONDS));
    /**
        @Override
        }
import org.apache.arrow.memory.BufferAllocator;
     * {@code sendBatch}, rejects before touching the stream root, and frees its own source root in the
        ready.set(false);
                VectorSchemaRoot source = newSingleIntRoot(realAllocator, i);
            drainExecutor();
            ch.close();
