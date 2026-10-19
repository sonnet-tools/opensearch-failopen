            assertSame("handler should pass the response straight to the channel", response, sent.get());
        StreamException thrown = expectThrows(
            Collections.emptySet(),
        when(mockFlightChannel.getExecutor()).thenReturn(submitTrap);
                    mockFlightChannel,
            mock(TransportResponse.class),
                    Version.CURRENT,
    }
    public void testSendResponseBatchDoesNotReleaseOnSuccessfulHandoff() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);  
    static class TestArrowResponse extends ArrowBatchResponse {  
     * releaseUnsent — the accepted task already owns and frees the source, so a second free would be a  
    public void testSendResponseBatchPropagatesAwaitReadyException() {  
        // original cause that the listener receives.
                )
        ExecutorService submitTrap = mock(ExecutorService.class);  
        doThrow(new RejectedExecutionException("shutting down")).when(rejectingExecutor).execute(any());  
        );
            released.countDown();
            mock(TransportResponse.class),  
    @After  
            1L,
 * SPDX-License-Identifier: Apache-2.0
        executor = Executors.newSingleThreadExecutor();
                    false,  
        doThrow(new RuntimeException("send failed")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
            "test-action",  
            released.countDown();
        inOrder.verify(transportChannel).releaseChannel(true);  
                false  
                Version.CURRENT,
    /**
        );
            flightExecutor.shutdownNow();
        assertEquals(  
package org.opensearch.arrow.flight.transport;
import static org.mockito.Mockito.when;
import org.opensearch.transport.stream.StreamException;
    public void testSyncSendSurfacesWorkFailureAsStreamException() throws Exception {  
            doThrow(new RuntimeException("send failed")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
            Version.CURRENT,
        threadContext.putHeader(HEADER_KEY, HEADER_VALUE);
        doThrow(timeoutEx).when(mockFlightChannel).awaitReadyOrThrow();
            "test-action",
        FlightTransportChannel mockTransportChannel = mock(FlightTransportChannel.class);
        handler.sendResponseBatch(
            null,
            transportChannel,
        assertEquals("Caller's thread context should be preserved after completeStream", HEADER_VALUE, threadContext.getHeader(HEADER_KEY));
    public void testSendResponseBatchPreservesCallerThreadContext() throws Exception {  
            () -> handler.sendResponseBatch(
            mockFlightChannel,  
        doThrow(new AssertionError("putNext boom")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
                false
            expectThrows(
            );
        ExecutorService submitTrap = mock(ExecutorService.class);
            // The accepted task owns the source; releaseUnsent must NOT run (that would be the double free).
        inOrder.verify(mockFlightChannel).sendError(any(), any(Exception.class));
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);  
        doThrow(cancelled).when(mockFlightChannel).awaitReadyOrThrow();
        }
     * Sync (sync=true): the batch send is submitted to the channel executor (so it is serialized against
            false
            "test-action",
            super(in);  
            () -> handler.sendResponseBatch(  
                    mock(TransportResponse.class),
        when(mockFlightChannel.getExecutor()).thenReturn(rejectingExecutor);
    /** With no transport channel, the Throwable path must close the channel directly (still frees the root). */  
    }  
    }  
                response,  
            Version.CURRENT,  
        when(mockFlightChannel.getExecutor()).thenReturn(submitTrap);
        }  
            false  
        doAnswer(invocation -> null).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
                mock(FlightTransportChannel.class),
        }).when(transportChannel).releaseChannel(true);  
            "test-action",
    public void tearDown() throws Exception {
    // these tests verify delegation + listener notification. Root ownership is covered in
            return null;
    }
    public void testProcessBatchTaskThrowableClosesChannelWhenNoTransportChannel() throws Exception {
import org.apache.arrow.vector.types.pojo.Schema;
            "test-action",  
import org.apache.arrow.vector.types.pojo.Field;
                false,
import org.apache.arrow.flight.FlightRuntimeException;
        assertTrue("Task should complete", latch.await(5, TimeUnit.SECONDS));  
                mockFlightChannel,
    }
        // The sendError failure must not be lost: it is attached as a suppressed exception on the  
        handler.sendResponseBatch(  
        );
                false,
        );  
                threadContext.getHeader(HEADER_KEY)
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
            Collections.emptySet(),
        assertEquals("Caller's thread context should be preserved after completeStream", HEADER_VALUE, threadContext.getHeader(HEADER_KEY));
import org.junit.Before;  
        handler.completeStream(  
            transportChannel,  
        verify(transportChannel).releaseChannel(true);  
            mock(TransportResponse.class),  
            Collections.emptySet(),  
        handler.sendResponseBatch(
            notified.countDown();
import java.io.IOException;
            return null;
            AtomicBoolean sentBeforeReturn = new AtomicBoolean(false);  
            latch.countDown();
            Collections.emptySet(),  
    private static VectorSchemaRoot newSingleIntRoot(BufferAllocator allocator, int value) {
                    1L,
     */
        try {
        try (RootAllocator allocator = new RootAllocator()) {
        verify(mockTransportChannel).releaseChannel(true);
        assertEquals("Context should be propagated to executor thread", HEADER_VALUE, capturedHeader.get());  
     * If awaitReadyOrThrow throws (timeout / cancellation), the StreamException must
    public void testSendErrorResponsePreservesCallerThreadContext() throws Exception {
        ThreadContext threadContext = threadPool.getThreadContext();
    // --- Hand-off discipline: a batch that never reaches the channel must be released (S7) ---  
            "test-action",
        );
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
            );
     */
            producerRoot.close();  
            mockFlightChannel,
                ranOnThread.set(Thread.currentThread().getName());  
                mockFlightChannel,  
            // ...and it ran on the flight executor thread, not the calling test thread.
        doAnswer(invocation -> null).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
    }
import org.opensearch.common.util.concurrent.ThreadContext;
        try {  
import java.util.concurrent.atomic.AtomicReference;  
        }  
        ExecutorService flightExecutor = Executors.newSingleThreadExecutor();
            flightExecutor.shutdownNow();
            latch.countDown();
            mock(TransportResponse.class),
        }
                false,
            )
            1L,
                StreamException.class,
    /**
            Collections.emptySet(),
                false
            }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));  
                false
            // Force the blocking wait to throw AFTER submit succeeds: the task runs, its send fails, and
    // --- processCompleteTask error path ---  
            false
                false,
 * compatible open source license.
                "test-action",  
                Collections.emptySet(),
        verify(mockFlightChannel).awaitReadyOrThrow();
            // sendBatch's own catch routes processBatchTask failures to the listener; make that listener
            AtomicReference<TransportResponse> sent = new AtomicReference<>();  
import java.util.concurrent.TimeUnit;
            mock(FlightTransportChannel.class),
            return null;  
 * this file be licensed under the Apache-2.0 license or a
     * runOnExecutorAndWait. Uses an executor that runs the task but lets its exception escape the Future.
        assertTrue("stream must still be failed and the listener notified", notified.await(5, TimeUnit.SECONDS));  
                "Caller's thread context should be preserved after batch " + (i + 1),
    public void setUp() throws Exception {
                false,  
            return null;  
                    mock(TransportResponse.class),  
                mock(FlightTransportChannel.class),
    // FlightServerChannelTests.
            doThrow(new RuntimeException("listener boom")).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
    }
        // Verify the caller's thread context is NOT cleared
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));  
        }
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));  
                "test-action",
            threadContext.getHeader(HEADER_KEY)
        TransportResponse response = mock(TransportResponse.class);
            "test-action",
            Version.CURRENT,
import static org.mockito.ArgumentMatchers.anyString;
            mock(TransportResponse.class),
     * adopted the stream root) must still release the channel so its close()-posted stream-root free  
    }
            Version.CURRENT,
        // sendError itself fails (consumer already gone) — must be swallowed.
            Version.CURRENT,  
                Version.CURRENT,  
                Collections.emptySet(),
     * When the back-pressure gate throws (cancel/timeout), the batch is never submitted, so the  
import org.apache.arrow.vector.VectorSchemaRoot;  
            capturedHeader.set(threadPool.getThreadContext().getHeader(HEADER_KEY));
        CountDownLatch notified = new CountDownLatch(1);  
        TransportResponse response = mock(TransportResponse.class);
            false,
        assertTrue("Executor task should complete", executorRan.await(5, TimeUnit.SECONDS));  
     * {@code Throwable} must not be swallowed.
        handler.completeStream(
            false,
                mock(FlightTransportChannel.class),  
            false,
        AtomicReference<Object> notifiedArg = new AtomicReference<>();
        assertTrue("Task should complete", latch.await(5, TimeUnit.SECONDS));
        assertEquals("sendError failed too", suppressed[0].getMessage());
 */  
            Version.CURRENT,
import static org.mockito.Mockito.never;
            false,
            Collections.emptySet(),
            1L,
            1L,  
            false,
            Collections.emptySet(),  
            mockFlightChannel,
            StreamException.class,  
            false,
        handler.sendResponseBatch(
            "test-action"
        doThrow(completeError).when(mockFlightChannel).completeStream(any());
        handler.sendResponseBatch(
    @Override  
            );
        // Send multiple batches
        verify(submitTrap, never()).execute(any());        // not submitted after the gate failed
            // routing that failure to the listener throws, so the exception escapes to Future.get().  
            mockTransportChannel,
        // The Throwable path must release the channel (-> close() -> stream-root free) even though  
                "test-action",
            doThrow(new RuntimeException("listener boom")).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));  
        ExecutorService flightExecutor = Executors.newSingleThreadExecutor(r -> new Thread(r, "flight-eventloop-unittest"));  
                    1L,
        Throwable[] suppressed = ((Throwable) notifiedArg.get()).getSuppressed();  
        // Complete the stream
    }
        );
                "test-action",
    }
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService submitTrap = mock(ExecutorService.class);
                Collections.emptySet(),  
    /**
            "test-action",
            null,
        );
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
        AtomicReference<String> capturedHeader = new AtomicReference<>();  
        doAnswer(invocation -> {  
        when(mockFlightChannel.getExecutor()).thenReturn(executor);
            mock(FlightTransportChannel.class),
            false,
        doAnswer(invocation -> {
                    Collections.emptySet(),
import java.util.List;
            flightExecutor.shutdownNow();
            "Caller's thread context should be preserved after sendResponseBatch",  
    private TransportMessageListener mockListener;  
            false,  
import static org.mockito.Mockito.verify;  
     * handler must free the source root via releaseUnsent and must NOT submit the task.
            handler.sendResponseBatch(
     * the root free that close() posts to the same executor) AND the caller blocks until it has run.  
            }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));  
     * A sync send whose executor work throws (e.g. onResponseSent itself fails) must surface the failure
            mockFlightChannel,
     * Regression: a sync send whose blocking wait throws AFTER the task was accepted must NOT also run
            mock(FlightTransportChannel.class),  
        doAnswer(inv -> {
            );  
        assertTrue("channel must be released on a non-Exception Throwable", released.await(5, TimeUnit.SECONDS));
                1L,  
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
        ThreadContext threadContext = threadPool.getThreadContext();
        super.tearDown();  
                response,
    // --- failStream: a batch send failure fails the stream instead of hanging the consumer ---
                false
            Version.CURRENT,  
            "test-action",
import static org.mockito.Mockito.doAnswer;
                1L,
                mock(TransportResponse.class),
        verify(mockFlightChannel).close();  
            "test-action",
            mockFlightChannel,
            1L,
                response,
        }).when(mockFlightChannel).close();
        handler = new FlightOutboundHandler("test-node", Version.CURRENT, new String[0], new StatsTracker(), threadPool);
    public void testSendResponseBatchReleasesSourceWhenExecutorRejects() {  
                )
    }
            StreamException thrown = expectThrows(  
            1L,  
            false,
    // --- Test helpers ---
        // Capture the thread context header inside onResponseSent, which runs
import org.opensearch.transport.StatsTracker;
import org.opensearch.threadpool.ThreadPool;  
            when(mockFlightChannel.getExecutor()).thenReturn(flightExecutor);
            Collections.emptySet(),
import java.util.concurrent.Executors;
                latch.countDown();
            transportChannel,  
        handler.sendResponseBatch(
        FlightTransportChannel transportChannel = mock(FlightTransportChannel.class);
        );  
        when(mockFlightChannel.getExecutor()).thenReturn(submitTrap);
        }
        handler.sendErrorResponse(
            notified.countDown();
        return root;  
        StreamException cancelled = StreamException.cancelled("client gone");
        CountDownLatch closed = new CountDownLatch(1);
            response,  
        verify(transportChannel).releaseChannel(true);
                1L,
import org.apache.arrow.memory.RootAllocator;
            false,
     * NOT silently swallow the failure.
            false,
    /** A successful hand-off must NOT also release the source (it is owned by sendBatch's finally). */
                1L,
                return null;
import org.apache.arrow.vector.IntVector;
            Collections.emptySet(),
        doThrow(new RuntimeException("sendError failed too")).when(mockFlightChannel).sendError(any(), any(Exception.class));  
        vec.setSafe(0, value);  
                false,
            1L,
    private ThreadPool threadPool;
        assertTrue("awaitReadyOrThrow must run before sendResponseBatch returns", awaitCalled.get());
        FlightTransportChannel transportChannel = mock(FlightTransportChannel.class);
                    false,
    }
    }
            return null;
            Collections.emptySet(),  
    // --- processBatchTask delegates to the channel ---
                1L,  
        doThrow(new RuntimeException("send failed")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());  
                sent.set(invocation.getArgument(0));
    public void testProcessBatchTaskThrowableReleasesChannel() throws Exception {
            handler.sendResponseBatch(  
            mock(TransportResponse.class),
            mockFlightChannel,
                () -> handler.sendResponseBatch(
            }).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
    public void testProcessBatchTaskDelegatesToChannelSendBatch() throws Exception {
            verify(mockFlightChannel, never()).releaseUnsent(any());  
                mockFlightChannel,  
     */  
        CountDownLatch released = new CountDownLatch(1);  
            mock(TransportResponse.class),
            1L,  
     */  
            doThrow(new RuntimeException("send failed")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
 *
        verify(submitTrap, never()).execute(any());  
                false,  
            false,  
                    true // sync
        assertTrue("Executor task should complete", latch.await(5, TimeUnit.SECONDS));
            false  
        assertTrue("channel must be closed directly when there is no transport channel", closed.await(5, TimeUnit.SECONDS));
            Collections.emptySet(),
     * Contrast with async, which dispatches via execute() and returns without waiting.
            HEADER_VALUE,
        verify(transportChannel).releaseChannel(true);
        for (int i = 0; i < 3; i++) {
/*  
            flightExecutor.awaitTermination(5, TimeUnit.SECONDS);  
                Collections.emptySet(),  
                mockFlightChannel,
            flightExecutor.awaitTermination(5, TimeUnit.SECONDS);  
    }  
        CountDownLatch latch = new CountDownLatch(1);
            1L,  
            false
        mockFlightChannel = mock(FlightServerChannel.class);
    /** Async (sync=false): the batch send is handed to the channel executor, off the calling thread. */
            false  
            1L,
import org.opensearch.transport.stream.StreamErrorCode;  
        // Real named single-thread executor: the send must run ON it (not the caller thread), and the
            StreamException.class,
        assertEquals("the sendError failure must be attached as suppressed", 1, suppressed.length);
        verify(submitTrap).execute(any()); // dispatched to the executor
        AtomicReference<Exception> capturedError = new AtomicReference<>();
        assertTrue("listener should receive the mapped StreamException", notifiedArg.get() instanceof StreamException);  
                    mock(FlightTransportChannel.class),  
            false  
            false,  
            false // sync=false
        assertSame(timeoutEx, thrown);
    }
import static org.mockito.ArgumentMatchers.any;
            doAnswer(invocation -> {
        org.mockito.InOrder inOrder = org.mockito.Mockito.inOrder(mockFlightChannel, transportChannel, mockListener);
import org.apache.arrow.memory.BufferAllocator;  
        ThreadContext threadContext = threadPool.getThreadContext();
                StreamException.class,
            false,
                features,
            Collections.emptySet(),  
        );
            VectorSchemaRoot producerRoot = newSingleIntRoot(allocator, 42);  
            )  
        }).when(transportChannel).releaseChannel(true);
        root.setRowCount(1);
        doAnswer(invocation -> {
        FlightTransportChannel transportChannel = mock(FlightTransportChannel.class);  
            mockFlightChannel,
        expectThrows(  
            1L,
        ExecutorService rejectingExecutor = mock(ExecutorService.class);
        handler.completeStream(Version.CURRENT, features, mockFlightChannel, mockTransportChannel, 1L, "test-action");  
     * When the executor rejects the task (e.g. shutdown), the batch never runs, so the handler must  
            1L,
    /**  
        // Crucially: we must not have submitted the BatchTask after the gate failed.
            );  
import static org.mockito.Mockito.mock;
            mock(FlightTransportChannel.class),
            mockFlightChannel,
        executor.shutdown();  
            // sync blocks on the submitted task, so the send has completed by the time the call returns...  
            mock(FlightTransportChannel.class),
            // The channel takes the response; the handler must not touch its root.
    /**
            false
        verify(mockFlightChannel).releaseUnsent(response);
        CountDownLatch executorRan = new CountDownLatch(1);  
import org.opensearch.Version;
     * finally must skip releaseUnsent even though the wait threw.
            false,
     * sendResponseBatch must call {@code awaitReadyOrThrow} on the producer thread
            mockFlightChannel,  
            mockFlightChannel,
    }
    }
     * A non-Exception {@code Throwable} from the send (e.g. OOM / AssertionError after the channel
                    Version.CURRENT,  
        threadContext.putHeader(HEADER_KEY, HEADER_VALUE);  
        doAnswer(invocation -> {
                false,
        TransportResponse response = mock(TransportResponse.class);
import org.junit.After;
    public void testProcessBatchTaskFlightRuntimeExceptionFailsStreamWithMappedError() throws Exception {
            mockFlightChannel,  
        assertSame("Error should be passed to listener", completeError, capturedError.get());
    }
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));
    }
                false,
     * free the source root via releaseUnsent.
        // failStream is not invoked for a non-Exception Throwable.
    public void testSendResponseBatchPropagatesContextToExecutorThread() throws Exception {
            return null;
    @Override
     * to the caller as a StreamException rather than hang or swallow it — the ExecutionException unwrap in  
            false
import org.opensearch.arrow.transport.ArrowBatchResponse;  
                sentBeforeReturn.set(true);
        assertSame(cancelled, thrown);  
        vec.allocateNew();
                true // sync=true  
                    Collections.emptySet(),
    public void testFailStreamSwallowsSendErrorFailureAndStillReleases() throws Exception {  
            // Channel mock did not consume buffers; free the producer root so teardown is clean.
            new RuntimeException("error")  
                Version.CURRENT,
                HEADER_VALUE,  
        threadContext.putHeader(HEADER_KEY, HEADER_VALUE);
import java.util.Set;
            mockFlightChannel,
            assertEquals(
        assertTrue("failed batch send must terminate the stream", notified.await(5, TimeUnit.SECONDS));
            false,  
    public void testProcessBatchTaskNonArrowResponseDelegatesToSendBatch() throws Exception {
        assertTrue("listener must still be notified after sendError fails", notified.await(5, TimeUnit.SECONDS));
                return null;  
            mockFlightChannel,
        doAnswer(invocation -> {
        );  
    }
        assertTrue("listener arg must be the original cause", notifiedArg.get() instanceof Exception);
        verify(mockFlightChannel).releaseUnsent(response); // freed on the failed-handoff path
            Version.CURRENT,  
                    "test-action",  
        );
import static org.mockito.ArgumentMatchers.anyLong;  
        assertTrue("FlightRuntimeException must terminate the stream", notified.await(5, TimeUnit.SECONDS));  
            RejectedExecutionException.class,
        handler.sendResponseBatch(  
        );  
            false, // isComplete
            flightExecutor.awaitTermination(5, TimeUnit.SECONDS);  
            assertTrue("Task should complete", latch.await(5, TimeUnit.SECONDS));
        );
        ThreadContext threadContext = threadPool.getThreadContext();
            Version.CURRENT,
            false,  
            );
            latch.countDown();
            Collections.emptySet(),
        } finally {
     */
            Version.CURRENT,
        when(mockFlightChannel.getAllocator()).thenReturn(mock(BufferAllocator.class));  
            1L,
            transportChannel,  
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.concurrent.atomic.AtomicBoolean;
            doAnswer(invocation -> {
        handler.sendResponseBatch(
            new RuntimeException("test error")  
        vec.setValueCount(1);
    }
        java.util.concurrent.atomic.AtomicBoolean awaitCalled = new java.util.concurrent.atomic.AtomicBoolean(false);  
            HEADER_VALUE,
        handler.sendResponseBatch(
            mock(TransportResponse.class),  
        } finally {
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));  
}  
            Collections.emptySet(),
    private FlightOutboundHandler handler;  
    }
    private FlightServerChannel mockFlightChannel;
                () -> handler.sendResponseBatch(  
                mockFlightChannel,
            mock(TransportResponse.class),  
            notifiedArg.set(invocation.getArgument(2));  
        verify(mockFlightChannel).sendError(any(), any(Exception.class));
    }
        RuntimeException completeError = new RuntimeException("complete failed");  
        doAnswer(invocation -> {  
            true,  // isError
        FlightTransportChannel mockTransportChannel = mock(FlightTransportChannel.class);
        // sendResponseBatch returns only after the gate has run.
            handler.sendResponseBatch(
                mockFlightChannel,
        IntVector vec = (IntVector) root.getVector("val");
        FlightRuntimeException flightError = CallStatus.INTERNAL.withDescription("flight send failed").toRuntimeException();
    public void testProcessCompleteTaskErrorPath() throws Exception {
    }
            super(root);
import org.opensearch.test.OpenSearchTestCase;
            assertEquals("sync send must run on the flight executor, not the caller", "flight-eventloop-unittest", ranOnThread.get());  
            threadContext.getHeader(HEADER_KEY)  
                false,  
            CountDownLatch latch = new CountDownLatch(1);
        doThrow(flightError).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());  
    public void testSyncSendDoesNotReleaseUnsentAfterTaskAccepted() throws Exception {
import java.util.concurrent.ExecutorService;
            TestArrowResponse response = new TestArrowResponse(producerRoot);  
            mock(FlightTransportChannel.class),  
            Collections.emptySet(),
                mock(FlightTransportChannel.class),  
        super.setUp();
            1L,
                Version.CURRENT,
    public void testCompleteStreamPreservesCallerThreadContext() throws Exception {  
            mock(FlightTransportChannel.class),
        AtomicReference<Object> notifiedArg = new AtomicReference<>();
        // sync call must not return until the send has completed.
                return null;
                false,  
    }
        doAnswer(invocation -> {
            "test-action",  
            assertEquals(StreamErrorCode.INTERNAL, thrown.getErrorCode());  
                    true // sync  
        ExecutorService flightExecutor = Executors.newSingleThreadExecutor();
            "Caller's thread context should be preserved after sendErrorResponse",
    @Before
     * propagate to the caller — sendResponseBatch must NOT submit the BatchTask, and  
import org.apache.arrow.vector.types.pojo.ArrowType;
                Version.CURRENT,  
            false,
            notified.countDown();  
        CountDownLatch notified = new CountDownLatch(1);
            mock(TransportResponse.class),
                false,
            mock(FlightTransportChannel.class),
        mockListener = mock(TransportMessageListener.class);
        assertTrue("channel must still be released after sendError fails", released.await(5, TimeUnit.SECONDS));  
        // Stream is failed BEFORE the listener is notified (consumer sees an error, not a hang).  
            closed.countDown();  
        handler.sendResponseBatch(
            verify(mockFlightChannel).sendBatch(any(TransportResponse.class), any());  
import java.util.Collections;  
            false,
        doAnswer(invocation -> {  
     * allocation under a slow consumer.  
        TestArrowResponse(StreamInput in) throws IOException {
        );
        CountDownLatch notified = new CountDownLatch(1);  
            Version.CURRENT,  
        CountDownLatch latch = new CountDownLatch(1);  
        threadContext.putHeader(HEADER_KEY, HEADER_VALUE);  
import static org.mockito.Mockito.doThrow;  
            Version.CURRENT,
            false,
            )
        );  
        FlightTransportChannel transportChannel = mock(FlightTransportChannel.class);
            mockFlightChannel,
        StreamException timeoutEx = new StreamException(StreamErrorCode.TIMED_OUT, "consumer not ready");
        doAnswer(invocation -> {
        doThrow(new RuntimeException("send failed")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
            when(mockFlightChannel.getExecutor()).thenReturn(flightExecutor);
        FlightOutboundHandler.BatchTask task = new FlightOutboundHandler.BatchTask(  
        doAnswer(invocation -> {
            return null;
                mock(TransportResponse.class),  
        threadPool.shutdown();
            "test-action"  
import org.opensearch.transport.TransportMessageListener;
            return null;
    }
        );
     * runs — the batch task is non-terminal, so {@code BatchTask.close()} would not release it. The
        );  
            false,
import java.util.concurrent.RejectedExecutionException;  
    public void testSendResponseBatchReleasesSourceWhenGateThrows() {  
            1L,  
import org.opensearch.threadpool.TestThreadPool;
        verify(mockFlightChannel).sendBatch(any(TransportResponse.class), any());  
    public void testSyncSendRunsOnExecutorAndBlocks() throws Exception {  
            false,
            mockFlightChannel,  
                mock(FlightTransportChannel.class),
            1L,
    private static final String HEADER_KEY = "test-header";
            // call itself throw so the exception escapes the submitted Runnable and reaches Future.get().
        threadContext.putHeader(HEADER_KEY, HEADER_VALUE);
            Collections.emptySet(),
    }
    /**
            "test-action",
                "test-action",  
    /**
     */
import org.apache.arrow.vector.types.pojo.FieldType;  
            mock(FlightTransportChannel.class),
                    false,
                Version.CURRENT,
import org.opensearch.core.transport.TransportResponse;  
            mockFlightChannel,  
        } finally {
        CountDownLatch notified = new CountDownLatch(1);
            return null;
public class FlightOutboundHandlerTests extends OpenSearchTestCase {  
            false  
            "test-action",
            mock(TransportResponse.class),
     * double free. Ownership (handedOff) is transferred at submit time, before the wait, so the handler's
                Collections.emptySet(),
    public void testBatchTaskCloseWithIsErrorCallsReleaseChannelWithTrue() {  
        Set<String> features = Collections.emptySet();
    private static final String HEADER_VALUE = "test-value";  
                    false,
        doThrow(new AssertionError("putNext boom")).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
        verify(mockFlightChannel, never()).releaseUnsent(any());
    /**
        try {
            latch.countDown();  
        }
            AtomicReference<String> ranOnThread = new AtomicReference<>();
        task.close();  
        assertEquals(
            return null;  
        TestArrowResponse(VectorSchemaRoot root) {
            return null;  
     */
 * The OpenSearch Contributors require contributions made to  
        StreamException thrown = expectThrows(
            Version.CURRENT,  
            doAnswer(invocation -> {  
        CountDownLatch released = new CountDownLatch(1);
        assertTrue("Task should complete", latch.await(5, TimeUnit.SECONDS));  
                    "test-action",
        );
            Version.CURRENT,
            notified.countDown();
                mockTransportChannel,
    public void testFailStreamWithNullTransportChannelDoesNotThrow() throws Exception {
            "test-action",  
     * BEFORE submitting the BatchTask to the executor — that is what throttles
    public void testAsyncSendUsesChannelExecutor() throws Exception {
        handler.sendResponseBatch(  
        handler.setMessageListener(mockListener);  
            return null;
        }).when(mockFlightChannel).awaitReadyOrThrow();
                1L,
            notifiedArg.set(invocation.getArgument(2));  
        );
        );
                "test-action",
    private ExecutorService executor;
        doAnswer(invocation -> null).when(mockFlightChannel).sendBatch(any(TransportResponse.class), any());
                    mockFlightChannel,  
            awaitCalled.set(true);
            false,  
        verify(mockFlightChannel).sendError(any(), any(Exception.class));
        doAnswer(invocation -> {
        Schema schema = new Schema(List.of(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null)));
            Version.CURRENT,
    // The channel owns the stream root (create/transfer/adopt/free) and builds the header internally;  
        threadPool = new TestThreadPool(getTestName());  
            false,  
        ThreadContext threadContext = threadPool.getThreadContext();
            return null;  
    }  
            Version.CURRENT,
        inOrder.verify(mockListener).onResponseSent(anyLong(), anyString(), any(Exception.class));
        // within the preserveContext wrapper on the executor thread  
            executorRan.countDown();
            false
            null,  
                    mock(FlightTransportChannel.class),
            assertTrue("sync send must have run (and notified) before returning", sentBeforeReturn.get());
            () -> handler.sendResponseBatch(
        handler.sendResponseBatch(
    public void testMultipleBatchesMaintainCallerContext() throws Exception {  
    // --- Back-pressure path: gating on the producer thread before executor submit ---
        );
import org.apache.arrow.flight.CallStatus;
            when(mockFlightChannel.getExecutor()).thenReturn(flightExecutor);  
    public void testSendResponseBatchGatesBeforeExecutor() throws Exception {
     */
            false,
                mock(TransportResponse.class),
    public void testProcessBatchTaskFailureSendsErrorAndReleasesChannel() throws Exception {  
            false,  
import java.util.concurrent.CountDownLatch;  
        }).when(mockListener).onResponseSent(anyLong(), anyString(), any(TransportResponse.class));  
        doAnswer(invocation -> {  
            capturedError.set(invocation.getArgument(2));
