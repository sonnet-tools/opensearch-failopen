            ch.sendBatch(new TestArrowResponse(root, metadata), FlightServerChannelTests::emptyHeader);  
import java.nio.ByteBuffer;  
                byte[] copy = new byte[(int) buf.readableBytes()];
            }  
            assertEquals("source must be freed even on the empty-vectors throw", 0, realAllocator.getAllocatedMemory());
            // close()-posted free behind it.  
        capturedCancelHandler.get().run(); // cancel -> close
     */
        capturedCancelHandler = new AtomicReference<>();
import static org.mockito.Mockito.doThrow;
    }  
        ready.set(false);
            doThrow(new AssertionError("putNext boom")).when(listener).putNext();
            );  
    public void testCompleteStreamNoOpAfterCancel() {
    /** A removable close listener registered after close() fires immediately. */
        vec.setSafe(0, value);
            waiterEntered.countDown();
        super.setUp();
     * Single-writer model: the send runs on the flight executor and {@code close()} posts the  
    /** A throwing close listener must not strand the remaining listeners. */
        listener = mock(ServerStreamListener.class);  
            assertNotNull("channel must retain the stream root", ch.getRoot());  
        assertBusy(() -> assertEquals(Thread.State.TIMED_WAITING, waiter.getState()), 2, TimeUnit.SECONDS);  
                () -> ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader)  
    }
    /** If the header supplier throws (S8), the source root is still freed and no stream root leaks. */
import static org.mockito.Mockito.doAnswer;
        listenerCancelled.set(true);  
            drainExecutor();
        TestArrowResponse(VectorSchemaRoot root) {
        FlightServerChannel ch = newChannel(30_000);
     */
        public void writeTo(StreamOutput out) throws IOException {
    }
        capturedCancelHandler.get().run();
        assertTrue("listener added after close must fire immediately", fired.get());
import org.apache.arrow.vector.IntVector;
            this.data = data;
        FlightServerChannel ch = newChannel(30_000);
            );
                waiterError.set(t);
        ch.addCloseListener(org.opensearch.core.action.ActionListener.wrap(r -> fired.set(true), e -> {}));  
    }
        capturedCancelHandler.get().run();
        AtomicBoolean secondFired = new AtomicBoolean(false);
        verify(callTracker).recordCallEnd(StreamErrorCode.CANCELLED.name());
    /**
        callTracker = mock(FlightCallTracker.class);
    public void testCancelWhileWaitingThrowsAndRunsChannelCleanup() throws Exception {  
            super(root);
    public void testAwaitReadyAfterCancelStaysCancelled() {  
    }
            assertEquals("source root must be empty/freed after the throw", 0, source.getRowCount());
    private void drainExecutor() throws Exception {
        ch.completeStream(emptyHeader());  
        }
    @Override  
        CountDownLatch start = new CountDownLatch(1);
        }  
        }  
    }
            executor.submit(() -> {  
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
    /**
        ch.sendError(emptyHeader(), new RuntimeException("late"));
        FlightServerChannel ch = newChannel(5_000);  
        return root;
import java.util.concurrent.CountDownLatch;
        capturedReadyHandler.get().run();  
                }  
            // source was freed by its own sendBatch finally.  
import org.apache.arrow.memory.ArrowBuf;
        ch.completeStream(emptyHeader());  
        doAnswer(inv -> {  
            ch.close();  
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
import java.util.concurrent.ExecutorService;
     * with a buffer carrying the exact bytes the producer attached.  
import org.apache.arrow.memory.RootAllocator;
            assertEquals("no queued source root may leak after cancel", 0, realAllocator.getAllocatedMemory());
                    ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader);
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
import org.apache.arrow.vector.types.pojo.Field;
            assertTrue("stream root buffers must still be alive before close", realAllocator.getAllocatedMemory() > 0);
        FlightServerChannel ch = newChannel(5_000);  
    private ServerHeaderMiddleware middleware;
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
        assertFalse("Waiter must have exited", waiter.isAlive());
        verify(listener, times(1)).completed();  
     * them). When the executor drains: each queued batch hits the {@code cancelled} guard in  
        assertTrue("listener added after close must fire immediately", fired.get());
    private FlightServerChannel newChannel(long readyTimeoutMillis) {
                ch.close();
        CountDownLatch entered = new CountDownLatch(n);
    public void testReleaseUnsentFreesSource() throws Exception {
            expectThrows(
                buf.getBytes(0, copy);  
        ch.addCloseListener((java.util.function.BiConsumer<Void, ? super Exception>) (v, e) -> fired.set(true));  
            errors.add(err);  
            assertTrue("must be StreamException, got " + t, t instanceof StreamException);  
        AtomicReference<Throwable> waiterError = new AtomicReference<>();
        for (Thread w : waiters) {
            assertEquals(StreamErrorCode.CANCELLED, ex.getErrorCode());  
        assertEquals(StreamErrorCode.CANCELLED, ex.getErrorCode());
        ch.completeStream(emptyHeader());
     * Cross-thread close() never frees buffers inline: when close() is called from a non-executor
        ready.set(false);
        // Channel cleanup must be invoked exactly once even though N threads observed cancel.  
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
            expectThrows(  
     * — even if the underlying listener somehow reports {@code isReady()==true}. The  
        long start = System.nanoTime();
    public void testSendBatchWithMetadataCallsPutNextWithBuf() throws Exception {
    public void testBatchesQueuedBehindCancelAreRejectedAndFreed() throws Exception {
            }  
            CountDownLatch blockExecutor = new CountDownLatch(1);
            // Occupy the single executor thread so the batches below sit in the queue, not run.  
        verify(listener, never()).error(any());
            ts.add(t);  
                    start.await();  
        private final byte[] data;
            assertEquals("header-throw must not leak source or created stream root", 0, realAllocator.getAllocatedMemory());
            assertEquals("all buffers must be freed", 0, realAllocator.getAllocatedMemory());
    /** sendBatch without metadata must call the no-arg {@code putNext()} variant. */  
            CountDownLatch executorBusy = new CountDownLatch(1);
            for (int i = 0; i < queued; i++) {
        }  
    static final class BytesResponse extends TransportResponse {  
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;  
            waiterEntered.countDown();  
import static org.mockito.Mockito.mock;  
    public void testAwaitReadyFastPath() {  
        try (RootAllocator realAllocator = new RootAllocator()) {
            );
        try (RootAllocator realAllocator = new RootAllocator()) {  
        AtomicBoolean fired = new AtomicBoolean(false);
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 11);
            // The mock doesn't, so close it here to avoid an allocator leak at test teardown.
        waiter.join(2_000);  
        CountDownLatch waiterEntered = new CountDownLatch(1);  
    public void setUp() throws Exception {
    }
            assertEquals("rejected source must be freed", 0, realAllocator.getAllocatedMemory());
        }
    }  
        executor.awaitTermination(5, TimeUnit.SECONDS);  
     * The channel cleanup ({@code recordCallEnd}, close) must run exactly once.  
            capturedCancelHandler.get().run();
        FlightServerChannel ch = newChannel(30_000);
                } catch (Throwable t) {
import java.io.IOException;
        FlightServerChannel ch = newChannel(5_000);
            waiters.add(w);  
     */
            verify(listener, times(1)).putNext();
    public void testSendBatchAfterCloseRejectsAndFreesSource() throws Exception {
        listenerCancelled.set(true);  
 */  
            }
    }
    }  
        capturedReadyHandler = new AtomicReference<>();  
        try (RootAllocator realAllocator = new RootAllocator()) {
     */  
            StreamException ex = expectThrows(
     * thread, the stream root is freed on the executor (single-writer), so it stays alive until the
        try (RootAllocator realAllocator = new RootAllocator()) {
        AtomicReference<Throwable> waiterError = new AtomicReference<>();
    public void testSendBatchPutNextThrowableFreesSourceAndStreamRootClosable() throws Exception {  
        middleware = mock(ServerHeaderMiddleware.class);
    /**
            verify(listener, times(1)).start(any()); // start only on the first batch
            assertEquals(StreamErrorCode.CANCELLED, ((StreamException) t).getErrorCode());
                }
    private static VectorSchemaRoot newSingleIntRoot(BufferAllocator allocator, int value) {  
        assertEquals(StreamErrorCode.CANCELLED, ((StreamException) t).getErrorCode());  
        List<Thread> ts = new ArrayList<>();
            });
                waiterError.set(t);
            // Let the send finish; the executor then runs the queued free task. drainExecutor() waits
import java.util.concurrent.TimeUnit;
            return null;
            Throwable t = err.get();
        // exception via channel.sendResponse(e), and FlightServerChannel.sendError records
            super(root, metadata);  
        Schema schema = new Schema(List.of(new Field("v", FieldType.nullable(new ArrowType.Int(32, true)), null)));
            // Channel owns the (transferred) stream root; close() posts the free to the executor.
            t.join(5_000);
     * StreamException AND run the channel's onChannelCancelled cleanup (recordCallEnd, close).
            AtomicReference<byte[]> capturedMetadata = new AtomicReference<>();
import org.opensearch.transport.stream.StreamException;  
    // ── Source-root ownership (the channel frees it exactly once) ──
import static org.mockito.ArgumentMatchers.any;  
    /** A successful native send empties+frees the source root and retains the stream root until close(). */  
import org.opensearch.transport.stream.StreamErrorCode;
    public void testAwaitReadyParksUntilOnReadyFires() throws Exception {
        return new FlightServerChannel(listener, allocator, middleware, callTracker, executor, readyTimeoutMillis);
        assertTrue("Message should reference the timeout", ex.getMessage().contains("100ms"));
    }
                VectorSchemaRoot source = newSingleIntRoot(realAllocator, i);
                entered.countDown();
     */
import org.opensearch.core.common.io.stream.StreamInput;
    private AtomicBoolean ready;
                    Thread.currentThread().interrupt();
            assertFalse("channel must be marked closed immediately", ch.isOpen());  
            }).get(5, TimeUnit.SECONDS);  
        listenerCancelled.set(true);
    /**  
    }  
        when(listener.isReady()).thenAnswer(inv -> ready.get());  
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);  
            expectThrows(AssertionError.class, () -> ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader));  
        for (AtomicReference<Throwable> err : errors) {  
            assertEquals("close must free the stream root", 0, realAllocator.getAllocatedMemory());
        for (int i = 0; i < threads; i++) {  
            try {
            // In production, Flight's putNext(ArrowBuf) takes ownership and frees the buffer.
            w.join(2_000);  
        }  
     * single executor thread), a concurrent cancel -> {@code close()} must NOT free the stream root —
                    }
                });
    }
     * {@code sendBatch}, rejects before touching the stream root, and frees its own source root in the
            drainExecutor();
    public void testAwaitReadyTimeoutThrowsTimedOut() {
            assertTrue("stream root must still be alive while the send occupies the executor", realAllocator.getAllocatedMemory() > 0);  
        }
            drainExecutor();
    public void testCancelDuringInFlightSendDefersRootFree() throws Exception {
                executorBusy.countDown();
            assertEquals("all buffers must be freed", 0, realAllocator.getAllocatedMemory());  
        ch.addCloseListener(kept);
    }
                IllegalStateException.class,
     * Batches queued behind a cancel must not leak. While the executor is busy, we enqueue several
        FlightServerChannel ch = newChannel(30_000);
    }  
            assertNotNull("each waiter must have thrown", t);
            assertArrayEquals("metadata bytes must round-trip into the ArrowBuf", metadata, capturedMetadata.get());
import java.util.concurrent.atomic.AtomicInteger;  
import static org.mockito.Mockito.verify;  
        }
    /** A close listener registered after close() fires immediately. */
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);  
            assertFalse("channel must be marked closed immediately", ch.isOpen());  
            } catch (Throwable t) {  
        verify(callTracker, org.mockito.Mockito.times(1)).recordCallEnd(StreamErrorCode.CANCELLED.name());
import org.opensearch.core.common.io.stream.StreamOutput;
        java.util.function.BiConsumer<Void, ? super Exception> kept = (v, e) -> fires.incrementAndGet();
            VectorSchemaRoot empty = new VectorSchemaRoot(new ArrayList<>(), new ArrayList<>(), 0);
    // ── Native send: metadata framing ──
        FlightServerChannel ch = newChannel(100);  
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 9);
    public void testAddRemovableCloseListenerAfterCloseFiresImmediately() {
            assertNotNull("byte path must create a stream root", afterFirst);
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);  
            Thread w = new Thread(() -> {
     * channel adopted the stream root, the source root is still freed by sendBatch's finally, the stream
/*  
        listenerCancelled.set(true);
            verify(listener, never()).start(any());
    public void testCompleteStreamOnlyOnce() {  
                IllegalStateException.class,
            doAnswer(inv -> {  
     * channel's own cancelled flag short-circuits before we consult the strategy.
        }  
     * After a cancel, subsequent {@code awaitReadyOrThrow} calls must throw immediately
            doAnswer(inv -> {
            verify(listener, never()).putNext();  
        }  
        executor = Executors.newSingleThreadExecutor();
     */
                    ch.awaitReadyOrThrow();
            byte[] metadata = "{\"output_rows\":1}".getBytes(StandardCharsets.UTF_8);
import java.util.concurrent.atomic.AtomicBoolean;
                    sendError.set(t);  
            assertNull("send must complete without error", sendError.get());
     * is responsible for invoking close() on this path; see FlightOutboundHandlerTests.)
                        ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader);
     * single cancel — none should be left hanging until {@code readyTimeoutMillis}.
        TestArrowResponse(StreamInput in) throws IOException {  
        ch.close();
    }
        assertTrue("Fast path must not park (elapsed=" + elapsedMs + "ms)", elapsedMs < 100);
        doAnswer(inv -> {
    }
        }
    /** An empty-field-vector native batch throws but still frees the source (S8 early-throw path). */  
            int queued = 4;
            drainExecutor();
        try (RootAllocator realAllocator = new RootAllocator()) {  
        int threads = 8;  
    private AtomicReference<Runnable> capturedReadyHandler;  
    private BufferAllocator allocator;  
     * for it guarantees the earlier-queued free task completed (FIFO, single-threaded).  
        long start = System.nanoTime();
        assertEquals("the listener that was kept must fire exactly once", 1, fires.get());
        try (RootAllocator realAllocator = new RootAllocator()) {  
            assertFalse("Waiter " + w.getName() + " must have exited", w.isAlive());
                ch.awaitReadyOrThrow();  
        ready.set(true);
        assertEquals(StreamErrorCode.TIMED_OUT, ex.getErrorCode());  
                    assertTrue(blockExecutor.await(5, TimeUnit.SECONDS));  
                    } catch (Throwable t) {  
        }
     * close() posts the stream-root free onto the flight executor (single-writer model). Drain the
                assertEquals(StreamErrorCode.CANCELLED, ((StreamException) t).getErrorCode());  
    }  
    }
            // Queue several native batches behind the blocked task. Each carries its own source root.
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);  
    public void testSendBatchFreesSourceRootRetainsStreamRoot() throws Exception {
            drainExecutor();
        CountDownLatch waiterEntered = new CountDownLatch(1);
import org.opensearch.test.OpenSearchTestCase;
            blockExecutor.countDown();  
            listenerCancelled.set(true);
        assertTrue(entered.await(2, TimeUnit.SECONDS));  
        capturedCancelHandler.get().run();  
    public void testSendErrorNoOpAfterComplete() {
            try {
import java.util.concurrent.Executors;  
        FlightServerChannel ch = newChannel(5_000);  
public class FlightServerChannelTests extends OpenSearchTestCase {  
        FlightServerChannel ch = newChannel(5_000);
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;  
        List<Thread> waiters = new ArrayList<>(n);  
        ch.awaitReadyOrThrow();
 * The OpenSearch Contributors require contributions made to  
    public void testSendErrorNoOpAfterCancel() {
        capturedCancelHandler.get().run();
import org.apache.arrow.flight.FlightProducer.ServerStreamListener;
import org.apache.arrow.vector.types.pojo.FieldType;  
        ready.set(false);
            }).when(listener).putNext();  
                            sendErrors.add(t);
                StreamException.class,  
    /** When the channel is cancelled, sendBatch rejects and frees the source root exactly once (no leak). */  
            ch.addCloseListener(org.opensearch.core.action.ActionListener.wrap(r -> fires.incrementAndGet(), e -> {}));  
            ch.sendBatch(new TestArrowResponse(root), FlightServerChannelTests::emptyHeader);  
                    try {
        TestArrowResponse(VectorSchemaRoot root, byte[] metadata) {
     * until the send completes, then are freed exactly once.
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
        }
 *
        IntVector vec = (IntVector) root.getVector("v");  
        assertFalse("channel must be closed after cancel", ch.isOpen());  
                try {  
        try (RootAllocator realAllocator = new RootAllocator()) {
                () -> ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader)
    @Override  
        assertTrue("a throwing listener must not prevent later listeners from firing", secondFired.get());  
        for (int i = 0; i < listeners; i++) {
        return ByteBuffer.allocate(0);  
        ch.sendError(emptyHeader(), new RuntimeException("after complete"));
                executor.execute(() -> {  
        ready = new AtomicBoolean(false);
            ch.close();
                } catch (Throwable t) {
            // Cancel now (from the gRPC-like thread): sets cancelled, flips open, posts the root free  
    }
            CountDownLatch inPutNext = new CountDownLatch(1);  
        ch.completeStream(emptyHeader());
            drainExecutor();
    // ── close() fire-once + listener semantics ──
import org.opensearch.core.transport.TransportResponse;  
            // No stream root was ever created (every batch rejected before transfer), and each queued
        assertEquals("each close listener must fire exactly once across all concurrent close() callers", listeners, fires.get());
            assertEquals("byte stream root must be freed exactly once at close", 0, realAllocator.getAllocatedMemory());  
        @Override
            // Release the executor and let it drain the blocked task, the queued batches, and the free.
            AtomicReference<Throwable> sendError = new AtomicReference<>();
        // the contract, and is verified end-to-end via the handler/transport-channel paths.  
import java.nio.charset.StandardCharsets;
    public void testCloseIsFireOnceUnderConcurrentCallers() throws Exception {
    // ── Terminal-op contracts ──
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 3);  
        List<AtomicReference<Throwable>> errors = new ArrayList<>(n);
            ch.releaseUnsent(new TestArrowResponse(source));  
    /**
        int n = 4;  
    private ExecutorService executor;  
        assertTrue("must be StreamException, got " + t, t instanceof StreamException);
            // Send a batch on the executor so the channel adopts a stream root, then drain.
            assertEquals("rejected source must be freed (no leak, no stream root created)", 0, realAllocator.getAllocatedMemory());
            verify(listener, never()).putNext(any(ArrowBuf.class));  
            ch.close();  
            // Fire the cancel -> close() from this (gRPC-like) thread. It must NOT block, and must post  
    /**  
        }  
        ch.addCloseListener(org.opensearch.core.action.ActionListener.wrap(r -> { throw new RuntimeException("listener boom"); }, e -> {}));
    public void testRemovableCloseListenerCanBeGivenBack() {
        super.tearDown();
        assertNotNull("waiter must have thrown", t);
        assertTrue(waiterEntered.await(2, TimeUnit.SECONDS));
    }  
        AtomicInteger fires = new AtomicInteger(0);  
        assertEquals(StreamErrorCode.CANCELLED, ex.getErrorCode());
        }
        }).when(listener).setOnCancelHandler(any(Runnable.class));  
        ch.addCloseListener(removed);  
                try {
package org.opensearch.arrow.flight.transport;
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 5);
            } catch (Throwable t) {
            // the root free onto the busy executor rather than freeing inline.
            verify(listener, times(2)).putNext();
        verify(listener, times(1)).completed();
                try {  
    /** Minimal send-side ArrowBatchResponse for tests. */
    public void testSendBatchAfterCancelRejectsAndFreesSource() throws Exception {
    // ── S4: cancel races an in-flight send; the root free must run behind the send (no use-after-free) ──  
    }  
            // Run the send ON the executor, exactly as production does — this is what serializes the
        ready.set(false);  
    }
        Thread waiter = new Thread(() -> {
    }
        StreamException ex = expectThrows(StreamException.class, ch::awaitReadyOrThrow);
        int listeners = 3;
                buf.close();
     * All concurrent producer threads parked in {@code awaitReadyOrThrow} must wake on a
            ch.sendBatch(new TestArrowResponse(source), FlightServerChannelTests::emptyHeader);  
        java.util.function.BiConsumer<Void, ? super Exception> removed = (v, e) -> fail("a removed listener must not fire");  
            }
        }  
    public void testSendBatchWithoutMetadataCallsPutNextNoArg() throws Exception {
        FlightServerChannel ch = newChannel(5_000);
    /** At most one terminal gRPC op: a second completeStream is a no-op. */
                try {
        FlightServerChannel ch = newChannel(30_000);
                assertTrue("queued batches must reject with CANCELLED, got " + t, t instanceof StreamException);
        ready.set(true);
        listenerCancelled.set(true);
            assertEquals("stream root must be freed exactly once after the send drains", 0, realAllocator.getAllocatedMemory());
            drainExecutor();
    /** Concurrent close() callers must each fire every close listener exactly once (no double-fire). */  
    public void testSendBatchEmptyFieldVectorsFreesSource() throws Exception {
                inPutNext.countDown();  
        }  
     * Cancellation while a producer thread is parked must wake it with a CANCELLED  
            CountDownLatch releasePutNext = new CountDownLatch(1);
            assertEquals("every queued batch must have rejected", queued, sendErrors.size());  
     * native batches, then fire the cancel (which sets cancelled/closed and posts the root free behind
            capturedCancelHandler.get().run(); // cancel -> close
                    Thread.currentThread().interrupt();
        listenerCancelled.set(true);
        BytesResponse(byte[] data) {  
        executor.submit(() -> {}).get(5, TimeUnit.SECONDS);  
            executor.execute(() -> {  
        listenerCancelled = new AtomicBoolean(false);
        assertFalse("Waiter must have exited", waiter.isAlive());  
            out.writeByteArray(data);  
    public void testSendBatchHeaderThrowsFreesSource() throws Exception {  
            ch.close();
        assertBusy(() -> assertEquals(Thread.State.TIMED_WAITING, waiter.getState()), 2, TimeUnit.SECONDS);
                () -> ch.sendBatch(new TestArrowResponse(empty), FlightServerChannelTests::emptyHeader)
    /** completeStream is a no-op after the channel was cancelled (no terminal op after cancel). */  
        }
     */
                ch.sendBatch(new TestArrowResponse(newSingleIntRoot(realAllocator, 8)), FlightServerChannelTests::emptyHeader);
        assertTrue("Already-cancelled path must not park (elapsed=" + elapsedMs + "ms)", elapsedMs < 100);  
        try (RootAllocator realAllocator = new RootAllocator()) {
            for (Throwable t : sendErrors) {
            drainExecutor();
        try (RootAllocator realAllocator = new RootAllocator()) {
    /** releaseUnsent frees the source root of a batch that never reached sendBatch (failed hand-off). */  
    /**  
        verify(callTracker, org.mockito.Mockito.never()).recordCallEnd(any());
            }).when(listener).putNext(any(ArrowBuf.class));
            assertTrue("stream root should be alive after a batch", realAllocator.getAllocatedMemory() > 0);
 * this file be licensed under the Apache-2.0 license or a
            });
    public void testAddCloseListenerAfterCloseFiresImmediately() {
    }
                return null;
    public void testThrowingCloseListenerDoesNotStrandOthers() {
        StreamException ex = expectThrows(StreamException.class, ch::awaitReadyOrThrow);
        assertNull("awaitReadyOrThrow must return normally on READY", waiterError.get());
        AtomicBoolean fired = new AtomicBoolean(false);
    }
     * root is retained (owned by the channel), and a subsequent close() frees it — no leak. (The handler  
     */
        vec.allocateNew();
    /** When the channel is closed, sendBatch rejects and frees the source root exactly once. */  
import org.opensearch.arrow.flight.stats.FlightCallTracker;
            }, "producer-waiter-" + i);
            ch.close();  
    // ── Byte-serialized path: stream root reused, freed once ──
            assertTrue("stream root buffers are still alive (owned by the channel)", realAllocator.getAllocatedMemory() > 0);
                ch.awaitReadyOrThrow();
     * executor runs the posted free.  
        assertTrue("channel must remain open after timeout — handler may still relay", ch.isOpen());
            VectorSchemaRoot afterFirst = ch.getRoot();
        ch.close();
import java.util.ArrayList;
     * the free is queued behind the in-flight send and runs only after it returns. The close listener  
        waiter.start();
            assertEquals("close() must free the adopted stream root after a putNext Throwable", 0, realAllocator.getAllocatedMemory());
                assertTrue("test timed out waiting to release putNext", releasePutNext.await(5, TimeUnit.SECONDS));
import java.util.concurrent.atomic.AtomicReference;
        }  
            executor.execute(() -> {
        }  
            // behind both the send and the free.  
    /**  
            AtomicReference<Throwable> err = new AtomicReference<>();
        root.setRowCount(1);
            VectorSchemaRoot root = newSingleIntRoot(realAllocator, 1);
        when(listener.isCancelled()).thenAnswer(inv -> listenerCancelled.get());
            assertTrue("all queued sources must be allocated", realAllocator.getAllocatedMemory() > 0);
    public void testCloseFreesStreamRootOnExecutor() throws Exception {
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);  
                capturedMetadata.set(copy);
    private ServerStreamListener listener;
            verify(listener, never()).start(any());
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);  
                    err.set(t);  
        for (Thread t : ts) {
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 2);  
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);
    }
import org.apache.arrow.vector.types.pojo.ArrowType;
        for (int i = 0; i < n; i++) {
                }  
import org.opensearch.arrow.transport.ArrowBatchResponse;  
        FlightServerChannel ch = newChannel(5_000);  
            return null;
import org.apache.arrow.vector.types.pojo.Schema;
        ch.removeCloseListener(removed);
        vec.setValueCount(1);  
            assertNotNull("stream root was adopted before putNext threw", ch.getRoot());  
                return null;
        }
        start.countDown();  
     * fires immediately on {@code close()} (it touches no Arrow buffers), but the buffers stay alive
        }, "producer-waiter");  
        Thread waiter = new Thread(() -> {  
            List<Throwable> sendErrors = new ArrayList<>();  
        ready.set(false);  
            });
            assertBusy(() -> assertEquals(Thread.State.TIMED_WAITING, w.getState()), 2, TimeUnit.SECONDS);
    }
            super(in);
        }).when(listener).setOnReadyHandler(any(Runnable.class));
        allocator = mock(BufferAllocator.class);
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 13);
        waiter.join(2_000);
        ready.set(true); // intentionally true to ensure the channel-level guard wins
                return null;  
        waiter.start();
        ch.close();
                ArrowBuf buf = inv.getArgument(0);
    /** sendError is a no-op after the channel was cancelled. */
        when(middleware.getCorrelationId()).thenReturn("42");  
import org.apache.arrow.memory.BufferAllocator;  
    public void testByteMultiBatchReusesStreamRootFreedOnce() throws Exception {
            // The executor thread is still inside putNext, so the queued free has not run: buffers live.
        }
        StreamException ex = expectThrows(StreamException.class, ch::awaitReadyOrThrow);
    public void testCancelWakesAllParkedProducers() throws Exception {
    /** Multi-batch byte path reuses one VarBinary stream root and frees it exactly once at close(). */
            verify(listener, never()).start(any());
            assertSame("byte path must reuse the same stream root across batches", afterFirst, ch.getRoot());
    /** A removable close listener fires on close, and is no longer fired once it has been removed. */
        for (Thread w : waiters) {
        }
     * If {@code putNext} throws a non-Exception {@code Throwable} (e.g. OOM / AssertionError) AFTER the
            capturedCancelHandler.set(inv.getArgument(0));
        assertTrue(waiterEntered.await(2, TimeUnit.SECONDS));  
        }  
            capturedCancelHandler.get().run();
        ch.close();  
            assertEquals("releaseUnsent must free the unsent source root", 0, realAllocator.getAllocatedMemory());
    }
        verify(listener, never()).completed();
        try (RootAllocator realAllocator = new RootAllocator()) {  
 * compatible open source license.
    }
import org.apache.arrow.vector.VectorSchemaRoot;  
            Thread t = new Thread(() -> {
     */
    private AtomicReference<Runnable> capturedCancelHandler;
            w.start();
    static final class TestArrowResponse extends ArrowBatchResponse {  
        FlightServerChannel ch = newChannel(5_000);  
    public void testAwaitReadyOnAlreadyCancelledChannelThrows() {  
    private FlightCallTracker callTracker;
    }
    }  
                } catch (InterruptedException e) {
     * sendBatch with non-null metadata must call {@code putNext(ArrowBuf)} (not {@code putNext()})
            t.start();
                        synchronized (sendErrors) {
            VectorSchemaRoot source = newSingleIntRoot(realAllocator, 15);  
            assertEquals("source root must be empty after transfer", 0, source.getRowCount());
            assertTrue("executor must be busy", executorBusy.await(5, TimeUnit.SECONDS));
}  
    }
    }
    private AtomicBoolean listenerCancelled;
                        }  
 * SPDX-License-Identifier: Apache-2.0
    /** Minimal non-Arrow response that drives the byte-serialization path. */
            // to the BACK of the executor queue (after the queued batches).
import java.util.List;  
    /** Once completed(), a later sendError must not also issue error() (single terminal op). */
     * {@code finally}; the posted root-free task (last in FIFO order) frees the stream root. Nothing is
        // the call end. Without that relay, no recordCallEnd would happen here — that is
            ch.sendBatch(new BytesResponse(new byte[] { 4, 5 }), FlightServerChannelTests::emptyHeader);
                } catch (InterruptedException e) {
        executor.shutdownNow();
     * executor so the free has run before asserting allocator state — submitting a no-op and waiting
            assertTrue("send must reach putNext", inPutNext.await(5, TimeUnit.SECONDS));
            FlightServerChannel ch = new FlightServerChannel(listener, realAllocator, middleware, callTracker, executor, 5_000);  
        FlightServerChannel ch = newChannel(5_000);
     * dropped, leaked, or double-freed.  
    public void tearDown() throws Exception {
            assertEquals("close() must free the stream root via the executor", 0, realAllocator.getAllocatedMemory());
            VectorSchemaRoot root = newSingleIntRoot(realAllocator, 7);  
            ch.close();
        ch.addCloseListener(org.opensearch.core.action.ActionListener.wrap(r -> secondFired.set(true), e -> {}));  
        try (RootAllocator realAllocator = new RootAllocator()) {
            expectThrows(IOException.class, () -> ch.sendBatch(new TestArrowResponse(source), () -> { throw new IOException("boom"); }));
import static org.mockito.Mockito.when;
     * stream-root free onto that same executor. While a send is mid-{@code putNext} (occupying the
        capturedCancelHandler.get().run();
    private static ByteBuffer emptyHeader() {
        try (RootAllocator realAllocator = new RootAllocator()) {
        Throwable t = waiterError.get();  
        verify(listener, never()).error(any());
        FlightServerChannel ch = newChannel(5_000);  
        // TIMED_OUT does not run channel cleanup. The handler is expected to relay the  
            ch.close(); // from the test thread (not the executor)  
            ch.sendBatch(new BytesResponse(new byte[] { 1, 2, 3 }), FlightServerChannelTests::emptyHeader);  
                }
    /**  
            releasePutNext.countDown();
    }
        try (RootAllocator realAllocator = new RootAllocator()) {
        AtomicInteger fires = new AtomicInteger(0);
        }
            verify(listener, times(1)).putNext(any(ArrowBuf.class));
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
    }
            capturedReadyHandler.set(inv.getArgument(0));  
    }
        }, "producer-waiter");
