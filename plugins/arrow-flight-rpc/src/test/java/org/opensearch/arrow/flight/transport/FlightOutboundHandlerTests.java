            mock(TransportResponse.class),
    public void testSendResponseBatchPreservesCallerThreadContext() throws Exception {
            false
                return null;
        verify(mockFlightChannel).close();
        verify(mockFlightChannel).sendError(any(), any(Exception.class));
            mockFlightChannel,
    // --- processBatchTask delegates to the channel ---
            false,
            when(mockFlightChannel.getExecutor()).thenReturn(flightExecutor);
        for (int i = 0; i < 3; i++) {
        TestArrowResponse(StreamInput in) throws IOException {
            mockFlightChannel,
        threadPool = new TestThreadPool(getTestName());
        org.mockito.InOrder inOrder = org.mockito.Mockito.inOrder(mockFlightChannel, transportChannel, mockListener);
        doAnswer(invocation -> {
            1L,
        FlightTransportChannel transportChannel = mock(FlightTransportChannel.class);
                HEADER_VALUE,
    }
        doAnswer(inv -> {
    private TransportMessageListener mockListener;
            // Channel mock did not consume buffers; free the producer root so teardown is clean.
            // call itself throw so the exception escapes the submitted Runnable and reaches Future.get().
            mockFlightChannel,
    /**
    public void testSendResponseBatchReleasesSourceWhenGateThrows() {
        CountDownLatch executorRan = new CountDownLatch(1);
            );
        verify(mockFlightChannel).awaitReadyOrThrow();
            Version.CURRENT,
            false,
        handler.sendErrorResponse(
        doThrow(new RuntimeException("send failed")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
    }
            }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
        assertTrue("Task should complete", latch.await(5, TimeUnit.SECONDS));
        doThrow(timeoutEx).when(mockFlightChannel).awaitReadyOrThrow();
     * runs — the batch task is non-terminal, so {@code BatchTask.close()} would not release it. The
        verify(mockFlightChannel, never()).releaseUnsent(any());
            "test-action",
                mockFlightChannel,
        handler.sendResponseBatch(
                "test-action",
            transportChannel,
        // The Throwable path must release the channel (-> close() -> stream-root free) even though
    public void testSendErrorResponsePreservesCallerThreadContext() throws Exception {
        );
        doAnswer(invocation -> {
        // sendError itself fails (consumer already gone) — must be swallowed.
            Version.CURRENT,
            mockFlightChannel,
        super.setUp();
            mock(TransportResponse.class),
                mock(FlightTransportChannel.class),
            mock(TransportResponse.class),
            latch.countDown();
            mock(FlightTransportChannel.class),
            }).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
            mockFlightChannel,
        doAnswer(invocation -> {
                response,
    private static VectorSchemaRoot newSingleIntRoot(BufferAllocator allocator, int value) {
        );
            mock(FlightTransportChannel.class),
                Collections.emptySet(),
            1L,
    public void testAsyncSendUsesChannelExecutor() throws Exception {
     */
        verify(submitTrap).execute(any()); // dispatched to the executor
        verify(submitTrap, never()).execute(any());
                () -> handler.sendResponseBatch(
                false
            notified.countDown();
        }).when(transportChannel).releaseChannel(true);
                false,
                1L,
        CountDownLatch latch = new CountDownLatch(1);
    // The channel owns the stream root (create/transfer/adopt/free) and builds the header internally;
        );
            threadContext.getHeader(HEADER_KEY)
                    mock(FlightTransportChannel.class),
import java.util.Collections;
            Collections.emptySet(),
    }
        assertSame("Error should be passed to listener", completeError, capturedError.get());
            Version.CURRENT,
            false
            Collections.emptySet(),
import java.io.IOException;
            false,
import org.opensearch.core.common.io.stream.StreamInput;
            AtomicBoolean sentBeforeReturn = new AtomicBoolean(false);
        }
                true // sync=true
            false,
        );
            doAnswer(invocation -> {
            return null;
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
            flightExecutor.awaitTermination(5, TimeUnit.SECONDS);
            // Force the blocking wait to throw AFTER submit succeeds: the task runs, its send fails, and
        FlightTransportChannel mockTransportChannel = mock(FlightTransportChannel.class);
            handler.sendResponseBatch(
        verify(mockTransportChannel).releaseChannel(true);
            awaitCalled.set(true);
            false,
        handler.completeStream(
        verify(mockFlightChannel).sendError(any(), any(Exception.class));
        AtomicReference<String> capturedHeader = new AtomicReference<>();
    public void testProcessBatchTaskDelegatesToChannelSendBatch() throws Exception {
            StreamException.class,
        verify(submitTrap, never()).execute(any());        // not submitted after the gate failed
package org.opensearch.arrow.flight.transport;
/*
        doAnswer(invocation -> null).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
        assertSame(cancelled, thrown);
            return null;
        // Complete the stream
            verify(mockFlightChannel, never()).releaseUnsent(any());
            null,
        doAnswer(invocation -> {
        );
                mock(FlightTransportChannel.class),
    public void setUp() throws Exception {
            false,
            producerRoot.close();
        handler.sendResponseBatch(
            1L,
        threadContext.putHeader(HEADER_KEY, HEADER_VALUE);
    @Override
        } finally {
            handler.sendResponseBatch(
            Version.CURRENT,
            flightExecutor.shutdownNow();
            false
        doThrow(new RuntimeException("send failed")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
        return root;
        handler.setMessageListener(mockListener);
        assertTrue("awaitReadyOrThrow must run before sendResponseBatch returns", awaitCalled.get());
    }
    }
    public void testSendResponseBatchPropagatesContextToExecutorThread() throws Exception {
    private FlightOutboundHandler handler;
        TransportResponse response = mock(TransportResponse.class);
                "Caller's thread context should be preserved after batch " + (i + 1),
                response,
import org.opensearch.transport.stream.StreamException;
        CountDownLatch closed = new CountDownLatch(1);
            // The channel takes the response; the handler must not touch its root.
                return null;
    private static final String HEADER_VALUE = "test-value";
        ExecutorService flightExecutor = Executors.newSingleThreadExecutor();
            mock(TransportResponse.class),
     * A non-Exception {@code Throwable} from the send (e.g. OOM / AssertionError after the channel
            "test-action",
                mock(FlightTransportChannel.class),
    }
                "test-action",
                false
            Collections.emptySet(),
        handler.sendResponseBatch(
        try {
                    "test-action",
        assertTrue("failed batch send must terminate the stream", notified.await(5, TimeUnit.SECONDS));
        );
        doThrow(flightError).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
            false,
        handler.sendResponseBatch(
                false,
    private ExecutorService executor;
            doAnswer(invocation -> {
            assertTrue("sync send must have run (and notified) before returning", sentBeforeReturn.get());
    }
            StreamException thrown = expectThrows(
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
            flightExecutor.awaitTermination(5, TimeUnit.SECONDS);
            mockFlightChannel,
        ThreadContext threadContext = threadPool.getThreadContext();
            () -> handler.sendResponseBatch(
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
            mockFlightChannel,
import org.opensearch.common.util.concurrent.ThreadContext;
    }
        FlightTransportChannel transportChannel = mock(FlightTransportChannel.class);
                1L,
            Version.CURRENT,
                Collections.emptySet(),
    }
        ExecutorService submitTrap = mock(ExecutorService.class);
            mockFlightChannel,
            expectThrows(
            Collections.emptySet(),
                sent.set(invocation.getArgument(0));
    }
            "test-action",
            HEADER_VALUE,
     * free the source root via releaseUnsent.
        // sendResponseBatch returns only after the gate has run.
            assertEquals(StreamErrorCode.INTERNAL, thrown.getErrorCode());
            false,
            new RuntimeException("test error")
        StreamException timeoutEx = new StreamException(StreamErrorCode.TIMED_OUT, "consumer not ready");
            false
        CountDownLatch notified = new CountDownLatch(1);
            mockFlightChannel,
            when(mockFlightChannel.getExecutor()).thenReturn(flightExecutor);
            RejectedExecutionException.class,
            "test-action",
        assertEquals("the sendError failure must be attached as suppressed", 1, suppressed.length);
            mockFlightChannel,
import org.apache.arrow.vector.types.pojo.Schema;
    public void testProcessBatchTaskThrowableClosesChannelWhenNoTransportChannel() throws Exception {
            released.countDown();
            1L,
    private FlightServerChannel mockFlightChannel;
        executor.shutdown();
                mockFlightChannel,
     * releaseUnsent — the accepted task already owns and frees the source, so a second free would be a
                latch.countDown();
                1L,
     * finally must skip releaseUnsent even though the wait threw.
            capturedError.set(invocation.getArgument(2));
            capturedHeader.set(threadPool.getThreadContext().getHeader(HEADER_KEY));
    }
            Collections.emptySet(),
            false,
            TestArrowResponse response = new TestArrowResponse(producerRoot);
 * compatible open source license.
        expectThrows(
        FlightRuntimeException flightError = CallStatus.INTERNAL.withDescription("flight send failed").toRuntimeException();
        inOrder.verify(mockFlightChannel).sendError(any(), any(Exception.class));
        } finally {
        Set<String> features = Collections.emptySet();
                Version.CURRENT,
    @Override
        assertSame(timeoutEx, thrown);
            mock(TransportResponse.class),
    /** A successful hand-off must NOT also release the source (it is owned by sendBatch's finally). */
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
        ThreadContext threadContext = threadPool.getThreadContext();
import static org.mockito.Mockito.verify;
            return null;
            "test-action"
        super.tearDown();
            verify(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
public class FlightOutboundHandlerTests extends OpenSearchTestCase {
            Collections.emptySet(),
            mockFlightChannel,
        assertTrue("stream must still be failed and the listener notified", notified.await(5, TimeUnit.SECONDS));
    // these tests verify delegation + listener notification. Root ownership is covered in
                Collections.emptySet(),
import org.junit.Before;
            latch.countDown();
                    mock(TransportResponse.class),
            );
            true,  // isError
                sentBeforeReturn.set(true);
            false,
        assertTrue("Task should complete", latch.await(5, TimeUnit.SECONDS));
import java.util.concurrent.CountDownLatch;
                    mockFlightChannel,
            mock(FlightTransportChannel.class),
        doAnswer(invocation -> {
            flightExecutor.shutdownNow();
        }
        CountDownLatch released = new CountDownLatch(1);
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
                threadContext.getHeader(HEADER_KEY)
                Collections.emptySet(),
            Collections.emptySet(),
        ThreadContext threadContext = threadPool.getThreadContext();
            Collections.emptySet(),
            mockFlightChannel,
        doThrow(new AssertionError("putNext boom")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
        doAnswer(invocation -> null).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
            return null;
    public void tearDown() throws Exception {
        threadContext.putHeader(HEADER_KEY, HEADER_VALUE);
            closed.countDown();
                    1L,
    @Before
        handler.sendResponseBatch(
    }
                mockFlightChannel,
            mock(TransportResponse.class),
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
            mockFlightChannel,
    public void testFailStreamSwallowsSendErrorFailureAndStillReleases() throws Exception {
        assertTrue("Executor task should complete", executorRan.await(5, TimeUnit.SECONDS));
        // Send multiple batches
                )
import java.util.concurrent.TimeUnit;
        doAnswer(invocation -> {
    }
        }).when(mockFlightChannel).close();
        doAnswer(invocation -> {
                false,
                    1L,
        CountDownLatch latch = new CountDownLatch(1);
            1L,
            threadContext.getHeader(HEADER_KEY)
    private ThreadPool threadPool;
        doAnswer(invocation -> {
    public void testSendResponseBatchDoesNotReleaseOnSuccessfulHandoff() throws Exception {
        threadContext.putHeader(HEADER_KEY, HEADER_VALUE);
    public void testSendResponseBatchReleasesSourceWhenExecutorRejects() {
            false,
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
        verify(transportChannel).releaseChannel(true);
                mock(TransportResponse.class),
        );
            );
        }
import org.opensearch.transport.TransportMessageListener;
        }
                "test-action",
            false
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
        try (RootAllocator allocator = new RootAllocator()) {
            Version.CURRENT,
     * When the back-pressure gate throws (cancel/timeout), the batch is never submitted, so the
            StreamException.class,
        FlightTransportChannel transportChannel = mock(FlightTransportChannel.class);
    }
            doAnswer(invocation -> {
    /**
        handler.sendResponseBatch(
                response,
                1L,
            "Caller's thread context should be preserved after sendErrorResponse",
import java.util.concurrent.RejectedExecutionException;
     * {@code Throwable} must not be swallowed.
        mockFlightChannel = mock(FlightServerChannel.class);
            );
    // --- Test helpers ---
            false,
                mockFlightChannel,
    public void testMultipleBatchesMaintainCallerContext() throws Exception {
            mock(FlightTransportChannel.class),
            1L,
        );
                mock(TransportResponse.class),
import java.util.concurrent.Executors;
        doAnswer(invocation -> {
        handler.completeStream(Version.CURRENT, features, mockFlightChannel, mockTransportChannel, 1L, "test-action");
                    true // sync
            mock(FlightTransportChannel.class),
            // routing that failure to the listener throws, so the exception escapes to Future.get().
import org.apache.arrow.vector.types.pojo.ArrowType;
                false,
            handler.sendResponseBatch(
        AtomicReference<Object> notifiedArg = new AtomicReference<>();
                mockFlightChannel,
            Version.CURRENT,
import org.opensearch.core.transport.TransportResponse;
            assertEquals("sync send must run on the flight executor, not the caller", "flight-eventloop-unittest", ranOnThread.get());
        handler.completeStream(
    }
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
            AtomicReference<TransportResponse> sent = new AtomicReference<>();
        assertEquals("Caller's thread context should be preserved after completeStream", HEADER_VALUE, threadContext.getHeader(HEADER_KEY));
import org.apache.arrow.vector.types.pojo.FieldType;
        assertTrue("Executor task should complete", latch.await(5, TimeUnit.SECONDS));
import java.util.concurrent.atomic.AtomicBoolean;
        ExecutorService rejectingExecutor = mock(ExecutorService.class);
        FlightTransportChannel mockTransportChannel = mock(FlightTransportChannel.class);
    }
        doAnswer(invocation -> null).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
        verify(mockFlightChannel).releaseUnsent(response); // freed on the failed-handoff path
                false,
        doThrow(new RuntimeException("sendError failed too")).when(mockFlightChannel).sendError(any(), any(Exception.class));
     * the root free that close() posts to the same executor) AND the caller blocks until it has run.
        verify(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
                    mock(TransportResponse.class),
        );
                    false,
    // --- processCompleteTask error path ---
            false,
            Version.CURRENT,
                return null;
                    true // sync
        CountDownLatch notified = new CountDownLatch(1);
            // sendBatch's own catch routes processBatchTask failures to the listener; make that listener
     */
    // --- Hand-off discipline: a batch that never reaches the channel must be released (S7) ---
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
            false,
    public void testSendResponseBatchPropagatesAwaitReadyException() {
            AtomicReference<String> ranOnThread = new AtomicReference<>();
import java.util.concurrent.ExecutorService;
        );
            1L,
            executorRan.countDown();
    // --- failStream: a batch send failure fails the stream instead of hanging the consumer ---
            false,
        ExecutorService submitTrap = mock(ExecutorService.class);
        inOrder.verify(transportChannel).releaseChannel(true);
            mockTransportChannel,
import java.util.concurrent.atomic.AtomicReference;
    public void testSendResponseBatchGatesBeforeExecutor() throws Exception {
        // Verify the caller's thread context is NOT cleared
        );
            mockFlightChannel,
    @After
import static org.mockito.ArgumentMatchers.any;
    }
            return null;
                false,
    /**
            mock(TransportResponse.class),
            when(mockFlightChannel.getExecutor()).thenReturn(flightExecutor);
                "test-action",
    }
            false, // isComplete
            1L,
        vec.setSafe(0, value);
                1L,
        handler.sendResponseBatch(
        ThreadContext threadContext = threadPool.getThreadContext();
            mock(FlightTransportChannel.class),
                Version.CURRENT,
}
        doAnswer(invocation -> {
import org.apache.arrow.flight.CallStatus;
        TransportResponse response = mock(TransportResponse.class);
        );
            notified.countDown();
            flightExecutor.awaitTermination(5, TimeUnit.SECONDS);
import static org.mockito.Mockito.never;
        verify(mockFlightChannel).releaseUnsent(response);
     * BEFORE submitting the BatchTask to the executor — that is what throttles
    public void testCompleteStreamPreservesCallerThreadContext() throws Exception {
            () -> handler.sendResponseBatch(
            HEADER_VALUE,
            false
     * If awaitReadyOrThrow throws (timeout / cancellation), the StreamException must
            null,
            return null;
                Version.CURRENT,
        threadContext.putHeader(HEADER_KEY, HEADER_VALUE);
    /**
            )
    public void testProcessBatchTaskNonArrowResponseDelegatesToSendBatch() throws Exception {
            "test-action",
                )
            mock(TransportResponse.class),
            notifiedArg.set(invocation.getArgument(2));
                Version.CURRENT,
                    false,
    public void testFailStreamWithNullTransportChannelDoesNotThrow() throws Exception {
            Version.CURRENT,
     * to the caller as a StreamException rather than hang or swallow it — the ExecutionException unwrap in
            doThrow(new RuntimeException("send failed")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
import static org.mockito.ArgumentMatchers.anyString;
        }
            Collections.emptySet(),
        when(mockFlightChannel.getExecutor()).thenReturn(rejectingExecutor);
            return null;
            Version.CURRENT,
            Version.CURRENT,
            false,
            )
            false,
                1L,
        assertEquals(
import org.apache.arrow.vector.types.pojo.Field;
        assertEquals("Context should be propagated to executor thread", HEADER_VALUE, capturedHeader.get());
        }
            "test-action",
        doThrow(new RuntimeException("send failed")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
            1L,
     * propagate to the caller — sendResponseBatch must NOT submit the BatchTask, and
     */
            return null;
                false,
     * runOnExecutorAndWait. Uses an executor that runs the task but lets its exception escape the Future.
    }
        // Stream is failed BEFORE the listener is notified (consumer sees an error, not a hang).
     * double free. Ownership (handedOff) is transferred at submit time, before the wait, so the handler's
            mock(TransportResponse.class),
        assertTrue("listener should receive the mapped StreamException", notifiedArg.get() instanceof StreamException);
            false
        );
            Version.CURRENT,
    }
        root.setRowCount(1);
import org.opensearch.threadpool.ThreadPool;
        when(mockFlightChannel.getExecutor()).thenReturn(submitTrap);
        executor = Executors.newSingleThreadExecutor();
            false,
 * SPDX-License-Identifier: Apache-2.0
        handler.sendResponseBatch(
            super(in);
    }
        TransportResponse response = mock(TransportResponse.class);
                false,
import org.opensearch.test.OpenSearchTestCase;
        ThreadContext threadContext = threadPool.getThreadContext();
            }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
                false,
            latch.countDown();
            Collections.emptySet(),
        doThrow(new AssertionError("putNext boom")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
        RuntimeException completeError = new RuntimeException("complete failed");
    }
            );
        assertEquals(
            "test-action",
import java.util.List;
        );
import org.opensearch.Version;
            mock(FlightTransportChannel.class),
    public void testProcessBatchTaskFailureSendsErrorAndReleasesChannel() throws Exception {
            // The accepted task owns the source; releaseUnsent must NOT run (that would be the double free).
import static org.mockito.Mockito.when;
            false
    public void testBatchTaskCloseWithIsErrorCallsReleaseChannelWithTrue() {
        ExecutorService flightExecutor = Executors.newSingleThreadExecutor(r -> new Thread(r, "flight-eventloop-unittest"));
        doThrow(cancelled).when(mockFlightChannel).awaitReadyOrThrow();
            new RuntimeException("error")
        vec.allocateNew();
            Version.CURRENT,
        // original cause that the listener receives.
 * The OpenSearch Contributors require contributions made to
    public void testProcessBatchTaskFlightRuntimeExceptionFailsStreamWithMappedError() throws Exception {
        // The sendError failure must not be lost: it is attached as a suppressed exception on the
     * adopted the stream root) must still release the channel so its close()-posted stream-root free
     */
        // within the preserveContext wrapper on the executor thread
            transportChannel,
                false,
            false // sync=false
                    mockFlightChannel,
                false
                false
        handler.sendResponseBatch(
            mock(TransportResponse.class),
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
     * sendResponseBatch must call {@code awaitReadyOrThrow} on the producer thread
import org.apache.arrow.vector.VectorSchemaRoot;
    }
            Version.CURRENT,
            flightExecutor.shutdownNow();
     * NOT silently swallow the failure.
            mock(TransportResponse.class),
        }
            1L,
            "test-action"
                    Collections.emptySet(),
        } finally {
 *
        assertEquals("sendError failed too", suppressed[0].getMessage());
    }
            transportChannel,
            doThrow(new RuntimeException("send failed")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
        // Capture the thread context header inside onResponseSent, which runs
        ExecutorService flightExecutor = Executors.newSingleThreadExecutor();
        threadContext.putHeader(HEADER_KEY, HEADER_VALUE);
        );
            released.countDown();
            "test-action",
    public void testSyncSendDoesNotReleaseUnsentAfterTaskAccepted() throws Exception {
        );
        CountDownLatch latch = new CountDownLatch(1);
            );
        StreamException thrown = expectThrows(
        try {
                false,
        // Crucially: we must not have submitted the BatchTask after the gate failed.
            Collections.emptySet(),
            1L,
import org.junit.After;
            Collections.emptySet(),
            mock(FlightTransportChannel.class),
            assertTrue("Task should complete", latch.await(5, TimeUnit.SECONDS));
    /**
    static class TestArrowResponse extends ArrowBatchResponse {
import static org.mockito.Mockito.doThrow;
import java.util.Set;
            Collections.emptySet(),
                "test-action",
            Version.CURRENT,
            false,
        java.util.concurrent.atomic.AtomicBoolean awaitCalled = new java.util.concurrent.atomic.AtomicBoolean(false);
        }).when(transportChannel).releaseChannel(true);
    }
            notified.countDown();
import org.opensearch.transport.stream.StreamErrorCode;
            return null;
        when(mockFlightChannel.getExecutor()).thenReturn(submitTrap);
            false
            "test-action",
            super(root);
import static org.mockito.Mockito.mock;
        try {
import static org.mockito.Mockito.doAnswer;
    public void testProcessCompleteTaskErrorPath() throws Exception {
            VectorSchemaRoot producerRoot = newSingleIntRoot(allocator, 42);
        );
        handler.sendResponseBatch(
    /**
        }).when(mockFlightChannel).awaitReadyOrThrow();
        assertTrue("FlightRuntimeException must terminate the stream", notified.await(5, TimeUnit.SECONDS));
    }
import org.opensearch.arrow.transport.ArrowBatchResponse;
            1L,
     * Contrast with async, which dispatches via execute() and returns without waiting.
    /** Async (sync=false): the batch send is handed to the channel executor, off the calling thread. */
        AtomicReference<Object> notifiedArg = new AtomicReference<>();
                Version.CURRENT,
    // --- Back-pressure path: gating on the producer thread before executor submit ---
            false,
                    "test-action",
            false
        Schema schema = new Schema(List.of(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null)));
        handler = new FlightOutboundHandler("test-node", Version.CURRENT, new String[0], new StatsTracker(), threadPool);
        CountDownLatch released = new CountDownLatch(1);
     * allocation under a slow consumer.
        IntVector vec = (IntVector) root.getVector("val");
    private static final String HEADER_KEY = "test-header";
        threadPool.shutdown();
import org.apache.arrow.flight.FlightRuntimeException;
        doAnswer(invocation -> {
     * A sync send whose executor work throws (e.g. onResponseSent itself fails) must surface the failure
            return null;
        );
            // sync blocks on the submitted task, so the send has completed by the time the call returns...
        FlightOutboundHandler.BatchTask task = new FlightOutboundHandler.BatchTask(
                    Version.CURRENT,
        vec.setValueCount(1);
     * Sync (sync=true): the batch send is submitted to the channel executor (so it is serialized against
            "test-action",
import org.apache.arrow.memory.BufferAllocator;
        // Real named single-thread executor: the send must run ON it (not the caller thread), and the
        handler.sendResponseBatch(
            false,
                mockTransportChannel,
        CountDownLatch notified = new CountDownLatch(1);
            notifiedArg.set(invocation.getArgument(2));
        Throwable[] suppressed = ((Throwable) notifiedArg.get()).getSuppressed();
        doThrow(completeError).when(mockFlightChannel).completeStream(any());
        CountDownLatch notified = new CountDownLatch(1);
            transportChannel,
            // ...and it ran on the flight executor thread, not the calling test thread.
                features,
            Collections.emptySet(),
    public void testSyncSendRunsOnExecutorAndBlocks() throws Exception {
     */
        inOrder.verify(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
            () -> handler.sendResponseBatch(
    }
            mock(FlightTransportChannel.class),
        StreamException thrown = expectThrows(
     * Regression: a sync send whose blocking wait throws AFTER the task was accepted must NOT also run
            1L,
        FlightTransportChannel transportChannel = mock(FlightTransportChannel.class);
            1L,
                mock(FlightTransportChannel.class),
            assertEquals(
        ExecutorService submitTrap = mock(ExecutorService.class);
import org.opensearch.threadpool.TestThreadPool;
            mockFlightChannel,
        task.close();
        when(mockFlightChannel.getExecutor()).thenReturn(submitTrap);
            Version.CURRENT,
            false
            )
    }
            CountDownLatch latch = new CountDownLatch(1);
                () -> handler.sendResponseBatch(
            false,
            false,
                false
     * handler must free the source root via releaseUnsent and must NOT submit the task.
        assertTrue("listener arg must be the original cause", notifiedArg.get() instanceof Exception);
        CountDownLatch latch = new CountDownLatch(1);
                ranOnThread.set(Thread.currentThread().getName());
                    Collections.emptySet(),
        when(mockFlightChannel.getExecutor()).thenReturn(executor);
        assertTrue("listener must still be notified after sendError fails", notified.await(5, TimeUnit.SECONDS));
            false,
import org.opensearch.transport.StatsTracker;
        mockListener = mock(TransportMessageListener.class);
        AtomicReference<Exception> capturedError = new AtomicReference<>();
            false,
            "Caller's thread context should be preserved after sendResponseBatch",
    // FlightServerChannelTests.
    public void testProcessBatchTaskThrowableReleasesChannel() throws Exception {
        doAnswer(invocation -> {
                Version.CURRENT,
            return null;
                    false,
        handler.sendResponseBatch(
    /**
            doThrow(new RuntimeException("listener boom")).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
            1L,
                    false,
        // sync call must not return until the send has completed.
        assertTrue("channel must be closed directly when there is no transport channel", closed.await(5, TimeUnit.SECONDS));
 */
                StreamException.class,
            notified.countDown();
            "test-action",
        // failStream is not invoked for a non-Exception Throwable.
        );
            false,
                    mock(FlightTransportChannel.class),
            doThrow(new RuntimeException("listener boom")).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
            response,
                StreamException.class,
            Collections.emptySet(),
                    Version.CURRENT,
     */
        StreamException cancelled = StreamException.cancelled("client gone");
        when(mockFlightChannel.getAllocator()).thenReturn(mock(BufferAllocator.class));
            "test-action",
            null,
            return null;
        assertTrue("channel must be released on a non-Exception Throwable", released.await(5, TimeUnit.SECONDS));
    public void testSyncSendSurfacesWorkFailureAsStreamException() throws Exception {
                false,
    /** With no transport channel, the Throwable path must close the channel directly (still frees the root). */
            "test-action",
        verify(transportChannel).releaseChannel(true);
        assertTrue("Task should complete", latch.await(5, TimeUnit.SECONDS));
            assertSame("handler should pass the response straight to the channel", response, sent.get());
    /**
        TestArrowResponse(VectorSchemaRoot root) {
            "test-action",
        verify(transportChannel).releaseChannel(true);
     */
        assertTrue("channel must still be released after sendError fails", released.await(5, TimeUnit.SECONDS));
        doThrow(new RejectedExecutionException("shutting down")).when(rejectingExecutor).execute(any());
import static org.mockito.ArgumentMatchers.anyLong;
            mockFlightChannel,
            latch.countDown();
            Collections.emptySet(),
        );
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.memory.RootAllocator;
                mock(TransportResponse.class),
            1L,
                mockFlightChannel,
                Collections.emptySet(),
     */
                "test-action",
                mock(FlightTransportChannel.class),
 * this file be licensed under the Apache-2.0 license or a
     * When the executor rejects the task (e.g. shutdown), the batch never runs, so the handler must
        assertEquals("Caller's thread context should be preserved after completeStream", HEADER_VALUE, threadContext.getHeader(HEADER_KEY));
        );
            return null;
