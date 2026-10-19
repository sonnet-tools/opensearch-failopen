        future.get(5, TimeUnit.SECONDS);  
        response.setOnClosed(notifications::incrementAndGet);  
    private static final class TestArrowResponse extends ArrowBatchResponse {  
        future.get(5, TimeUnit.SECONDS);
 * SPDX-License-Identifier: Apache-2.0
        @Override
    // ── close() / prefetch-race stream lifecycle ─────────────────────────────  
        assertBusy(() -> assertEquals(1, notifications.get()), 5, TimeUnit.SECONDS);
                notifiedDuringStreamClose.set(true);  
            notifications.incrementAndGet();
        response.close(); // prefetch still in flight → its closed re-check owns close + notify
        verify(stream, times(1)).cancel("channel closed", null);
        verify(stream, times(1)).close();
            notified.countDown();
    }  
            delegate.handleException(exp);
        doThrow(new RuntimeException("boom")).when(stream).close();
        resumePrefetch.countDown();
        );  
            insideStreamClose.countDown();
import org.apache.arrow.flight.FlightClient;
    public void testArrowHandlerSkipsDeserialization() {
     * {@code afterStreamPublished} seam rather than raced: close() runs (and gets as far as being  
        assertNull(response.getDispatchThread());  
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);  
        @Override  
    }
import java.util.List;
                    Thread.currentThread().interrupt();
    }
            return delegate.skipsDeserialization();
     * directly (the test lives in the same package).
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        // Let the prefetch publish the stream; its closed-check must self-close it.  
    /** An unexpected error from the stream is wrapped as a StreamException. */
        }  
        response.close(); // sees flightStream==null → closes nothing itself  
        }
        FlightStream stream = mock(FlightStream.class);
        // The prefetch passed its closed-check before publishing the future, so it never self-closes;
    }  
        AtomicInteger notifications = new AtomicInteger();
import java.nio.charset.StandardCharsets;  
        response.openAndPrefetchAsync(new CompletableFuture<>());
        when(stream.next()).thenReturn(true);
        future.get(5, TimeUnit.SECONDS);
        }
 *
        response.cancelStreamOnly("channel closed");  
import org.apache.arrow.memory.ArrowBuf;
        response.openAndPrefetchAsync(future);
    /** A failed stream close must not report the buffers released, on either racing thread. */
        FlightClient client = mock(FlightClient.class);
import org.opensearch.test.OpenSearchTestCase;
    /** Normal path: once the stream is published, close() closes it. */  
        CountDownLatch notified = new CountDownLatch(1);
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        FlightStream stream = mock(FlightStream.class);  
     *
        FlightClient client = mock(FlightClient.class);
     * and re-checking the closed flag.
        CompletableFuture<Header> future = new CompletableFuture<>();
        };  
        when(client.getStream(any(Ticket.class), any())).thenAnswer(inv -> {  
        CountDownLatch enteredGetStream = new CountDownLatch(1);  
            @Override
    }
        ForwardingWrapper(TransportResponseHandler<T> delegate) {  
    /** cancelStreamOnly before the stream is published falls back to close() so the prefetch self-closes. */  
        public void handleException(TransportException exp) {}
import java.util.concurrent.TimeUnit;
        public String executor() {
        FlightClient client = mock(FlightClient.class);  
        }).when(stream).close();  
        AtomicInteger notifications = new AtomicInteger();
    public void testOnClosedFiresAfterPrefetchSelfClose() throws Exception {
import java.util.concurrent.CompletableFuture;
        CountDownLatch proceed = new CountDownLatch(1);
        CompletableFuture<Header> future = new CompletableFuture<>();
        response.setOnClosed(notifications::incrementAndGet);  
        CountDownLatch enteredGetStream = new CountDownLatch(1);
        public void handleResponse(TestArrowResponse response) {}
        future.get(5, TimeUnit.SECONDS);
        @Override  
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);  
     */  
    }
            new FlightTransportConfig()
        });  
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        assertFalse("closer did not finish", closer.isAlive());
            return stream;
        response.close();  
    public void testCloseIsIdempotent() throws Exception {  
            streamCloseInProgress.set(true);
        CountDownLatch resumePrefetch = new CountDownLatch(1);  
            return delegate.executor();  
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
    }
            }
    }
        Thread closer = new Thread(response::close, "stream-close-winner");  
        public void handleException(TransportException exp) {  
    }
    public void testNonArrowHandlerDoesNotSkip() {  
        response.close();
        response.close(); // must not propagate the IllegalStateException
            assertNotSame(payload, copy);  
        assertTrue("prefetch must publish the stream", streamPublished.await(5, TimeUnit.SECONDS));  
        proceed.countDown();
            new NamedWriteableRegistry(List.of()),
    public void testWrapperForwardsFalseFromNonArrowHandler() {
            enteredGetStream.countDown();
    /** onClosed fires when close() raced the prefetch: notification follows the self-close. */  
            return null;
        response.close();  
            return stream;  
        CountDownLatch proceed = new CountDownLatch(1);  
            return delegate.read(in);  
        verify(stream, timeout(5_000).atLeastOnce()).close();
            buf.writeBytes(payload);
            assertTrue("test must release the stream close", finishStreamClose.await(5, TimeUnit.SECONDS));  
        when(stream.next()).thenReturn(true);  
    }
        AtomicBoolean streamCloseInProgress = new AtomicBoolean();  
        when(stream.next()).thenReturn(true);
        response.close();
        }
     * while the winner is still inside {@link FlightStream#close()}, or a channel waiting on that
import static org.mockito.Mockito.when;
        response.setOnClosed(notifications::incrementAndGet);  
        public void handleResponse(TransportResponse response) {}
    }
/*  
    public void testCancelStreamOnlyCancelsWithoutClosing() throws Exception {
 */  
        verify(stream, times(1)).close();  
        closer.start();
        // The consumer's close still runs and releases the stream.
    /** onClosed fires when the prefetch failed before publishing a stream and close() runs later. */  
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());  
            enteredGetStream.countDown();  
        CompletableFuture<Header> future = new CompletableFuture<>();
        byte[] payload = "{\"output_rows\":42}".getBytes(StandardCharsets.UTF_8);
            new TestArrowHandler(),
        MetricsTrackingResponseHandler<TestArrowResponse> wrapped = new MetricsTrackingResponseHandler<>(new TestArrowHandler(), null);
        try (RootAllocator allocator = new RootAllocator(); ArrowBuf buf = allocator.buffer(0)) {
        when(stream.next()).thenReturn(true);  
            // The copy is independent of the wire buffer.
    }
import static org.mockito.Mockito.timeout;
        public void handleException(TransportException exp) {}
        assertTrue("onClosed should fire after prefetch self-close", notified.await(5, TimeUnit.SECONDS));
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
        // A second close is still safe.
    public void testRealMetricsTrackingWrapperForwards() {  
    public void testFailedStreamCloseNeverNotifies() throws Exception {  
import static org.mockito.Mockito.verify;  
        expectThrows(Exception.class, () -> future.get(5, TimeUnit.SECONDS));
import org.apache.arrow.flight.Ticket;  
import org.opensearch.transport.Header;
            assertNotNull(copy);  
        doAnswer(inv -> {  
        @Override  
        }
    /** close() is idempotent: a second call short-circuits and does not re-close the stream. */
        response.openAndPrefetchAsync(future);  
        verify(stream, times(1)).close();  
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        FlightStream stream = mock(FlightStream.class);  
        // only the first close() closes the stream and the later calls short-circuit.  
     * Builds a response wired to the given client. Uses package-private collaborators  
        }
    private FlightTransportResponse<TestArrowResponse> newResponse(FlightClient client, HeaderContext headerContext) {  
        proceed.countDown();
        FlightClient client = mock(FlightClient.class);
        AtomicInteger notifications = new AtomicInteger();
import org.opensearch.transport.StreamTransportResponseHandler;  
        finishStreamClose.countDown();  
        when(stream.next()).thenReturn(true);  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        when(client.getStream(any(Ticket.class), any())).thenAnswer(inv -> {
        // it may arrive asynchronously on the prefetch thread.  
        public String executor() {
        response.cancelStreamOnly("channel closed"); // stream not yet published → close()
        // Loser: the prefetch now observes closed == true and reaches the same stream close.
        response.openAndPrefetchAsync(future);
    /**
        response.openAndPrefetchAsync(future);
        @Override  
        response.openAndPrefetchAsync(future);  
        }  
            new HeaderContext(),  
            this.delegate = delegate;
        public T read(org.opensearch.core.common.io.stream.StreamInput in) throws IOException {
    }
            new NamedWriteableRegistry(List.of()),
            return "same";
    // ── cancelStreamOnly() / onClosed notification (channel-close support) ──────
import java.util.concurrent.atomic.AtomicBoolean;
        return new FlightTransportResponse<>(
     * inside {@code FlightStream#close}) while the prefetch is parked between publishing the stream
        CompletableFuture<Header> future = new CompletableFuture<>();
import static org.mockito.Mockito.times;
        assertTrue(new ForwardingWrapper<>(new TestArrowHandler()).skipsDeserialization());
        CountDownLatch enteredGetStream = new CountDownLatch(1);
        when(client.getStream(any(Ticket.class), any())).thenAnswer(inv -> {
            new Ticket(new byte[0]),
import org.opensearch.transport.TransportException;
        @Override
        FlightClient client = mock(FlightClient.class);
    }
import org.opensearch.arrow.transport.ArrowBatchResponse;  
import org.apache.arrow.flight.FlightStream;
            byte[] copy = FlightTransportResponse.copyMetadata(buf);
    }  
        });
        assertTrue(enteredGetStream.await(5, TimeUnit.SECONDS));
        try (var ignored = response.markDispatchThread()) {  
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
        CompletableFuture<Header> future = new CompletableFuture<>();  
        when(stream.next()).thenReturn(true);
    /**
        }
        assertBusy(() -> assertEquals("stream must be reported released exactly once", 1, notifications.get()));  
        assertTrue(enteredGetStream.await(5, TimeUnit.SECONDS));  
    /**
        response.openAndPrefetchAsync(future);
        assertFalse("release was reported while FlightStream#close was still in progress", notifiedDuringStreamClose.get());
        CompletableFuture<Header> future = new CompletableFuture<>();
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        public String executor() {
        future.get(5, TimeUnit.SECONDS);  
        // Winner: sees the published stream and parks inside FlightStream#close.
        assertTrue(wrapped.skipsDeserialization());  
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
    }  
        // A second caller observes the recorded failure instead of re-closing, and still must not notify.  
        assertFalse(new TestByteHandler().skipsDeserialization());
        FlightClient client = mock(FlightClient.class);
            1L,  
            if (streamCloseInProgress.get()) {
     * so close() sees flightStream==null and closes nothing. When the prefetch then publishes the
    /** cancelStreamOnly on a published stream cancels it but must NOT close it: the consumer owns close. */  
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        FlightClient client = mock(FlightClient.class);
            1L,
        assertTrue("close must reach the stream close", insideStreamClose.await(5, TimeUnit.SECONDS));
        CountDownLatch insideStreamClose = new CountDownLatch(1);
    }  
        AtomicBoolean notifiedDuringStreamClose = new AtomicBoolean();
            waitUntil(() -> notifications.get() > 0, 300, TimeUnit.MILLISECONDS)
        verify(stream, never()).close();
        }
        response.setOnClosed(() -> {
            notifications.incrementAndGet();  
        FlightStream stream = mock(FlightStream.class);
        });
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        FlightClient client = mock(FlightClient.class);
    public void testCloseSwallowsAlreadyClosedError() throws Exception {
        FlightClient client = mock(FlightClient.class);
            new TestArrowHandler(),  
        CountDownLatch streamPublished = new CountDownLatch(1);
    public void testDispatchThreadMarkIsScopedToTheCallback() {
        assertEquals(1, notifications.get());
        ) {
    }
import java.util.concurrent.CountDownLatch;  
        closer.join(TimeUnit.SECONDS.toMillis(5));
    /** A benign already-closed error from the stream is swallowed. */
    public void testWrapperForwardsTrueFromArrowHandler() {
        FlightStream stream = mock(FlightStream.class);
    }
        }  
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());  
        doThrow(new RuntimeException("boom")).when(stream).close();
        when(stream.next()).thenReturn(true);
        public TestArrowResponse read(org.opensearch.core.common.io.stream.StreamInput in) {
     * root is not stranded on the client allocator.  
            new FlightTransportConfig()  
        response.close();  
        FlightStream stream = mock(FlightStream.class);
        @Override  
        FlightStream stream = mock(FlightStream.class);
        private final TransportResponseHandler<T> delegate;
 * this file be licensed under the Apache-2.0 license or a
        AtomicInteger notifications = new AtomicInteger();  
     */
        assertFalse(new ForwardingWrapper<>(new TestByteHandler()).skipsDeserialization());  
        }
        when(stream.next()).thenReturn(true);
    }  
        CompletableFuture<Header> future = new CompletableFuture<>();
        verify(stream, times(1)).close();
import org.opensearch.transport.stream.StreamException;  
        response.close();
            assertSame(Thread.currentThread(), response.getDispatchThread());
        when(stream.next()).thenReturn(true);
        response.close();
    public void testOnClosedFiresWhenPrefetchFailedBeforePublish() throws Exception {
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
    }
            assertTrue("test must release getStream", proceed.await(5, TimeUnit.SECONDS));
            delegate.handleResponse(response);
        CompletableFuture<Header> future = new CompletableFuture<>();  
        assertTrue(enteredGetStream.await(5, TimeUnit.SECONDS));
        future.get(5, TimeUnit.SECONDS);  
            client,
     * notification closes its allocator too early.  
        assertTrue(new TestArrowHandler().skipsDeserialization());  
        });  
        FlightClient client = mock(FlightClient.class);  
                try {
        when(client.getStream(any(Ticket.class), any())).thenThrow(new RuntimeException("connection refused"));  
            return stream;
        @Override  
        response.setOnClosed(notifications::incrementAndGet);
    private static final class ForwardingWrapper<T extends TransportResponse> implements TransportResponseHandler<T> {  
                } catch (InterruptedException e) {
        TestArrowResponse() {
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
            client,
    public void testCloseRethrowsUnexpectedErrorAsStreamException() throws Exception {  
    public void testCloseClosesPublishedStream() throws Exception {
        }
        public TransportResponse read(org.opensearch.core.common.io.stream.StreamInput in) {
    }
        // close() ran after publish; the prefetch had already passed its closed-check, so close() owns the close.
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
            headerContext,
    private static final class TestByteHandler implements StreamTransportResponseHandler<TransportResponse> {  
            assertArrayEquals(payload, copy);
        assertEquals(0, notifications.get());
            void afterStreamPublished() {  
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);  
        expectThrows(StreamException.class, response::close);
    }
        // Whichever of close() and the prefetch's finally runs second fires the notification, so
 * The OpenSearch Contributors require contributions made to  
        proceed.countDown();  
            "no release may be reported while the stream close is in progress",
public class FlightTransportResponseTests extends OpenSearchTestCase {  
    }
    private static final class TestArrowHandler extends ArrowBatchResponseHandler<TestArrowResponse> {  
            new Ticket(new byte[0]),  
        assertNull(response.getDispatchThread());
import java.util.concurrent.atomic.AtomicInteger;  
        @Override
        try (RootAllocator allocator = new RootAllocator(); ArrowBuf buf = allocator.buffer(payload.length)) {  
    public void testCloseDuringPrefetchSelfClosesStream() throws Exception {
                    assertTrue("test must resume the prefetch", resumePrefetch.await(5, TimeUnit.SECONDS));  
        response.openAndPrefetchAsync(future);
            throw new UnsupportedOperationException();  
        // MetricsTrackingResponseHandler in production path; null tracker is fine for this check.
        assertEquals(1, notifications.get());  
        FlightClient client = mock(FlightClient.class);
     * stream, its synchronous closed-check must self-close it (closed already true) so the first-batch
            return "same";
        assertTrue("the stream close must still be in progress", streamCloseInProgress.get());
        @Override
        AtomicInteger notifications = new AtomicInteger();
    }
        FlightClient client = mock(FlightClient.class);
        // Prefetch thread is parked inside getStream(); flightStream is still null.
    /** onClosed fires even when the response is closed before any prefetch started. */
        FlightClient client = mock(FlightClient.class);
import static org.mockito.Mockito.mock;
        assertEquals(1, notifications.get());
        FlightStream stream = mock(FlightStream.class);
        response.setOnClosed(() -> {
        CompletableFuture<Header> future = new CompletableFuture<>();
        response.close(); // no stream yet  
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());  
        FlightClient client = mock(FlightClient.class);
                }
        FlightTransportResponse<TestArrowResponse> response = new FlightTransportResponse<>(
        AtomicInteger notifications = new AtomicInteger();  
     * may observe the other's write. Whichever loses the race must not report the buffers released
            super((org.apache.arrow.vector.VectorSchemaRoot) null);
    }
    public void testCopyMetadataPopulatedBuffer() {
        @Override
        response.openAndPrefetchAsync(future);  
    /** The dispatch-thread mark identifies the thread running the consumer callback, and clears after. */  
        CountDownLatch proceed = new CountDownLatch(1);  
        AtomicInteger notifications = new AtomicInteger();
        response.setOnClosed(notifications::incrementAndGet);  
                streamPublished.countDown();
    /** close() before any prefetch has a null stream — must be a no-op, no NPE. */
import org.opensearch.core.transport.TransportResponse;  
package org.opensearch.arrow.flight.transport;
        FlightStream stream = mock(FlightStream.class);
        @Override  
        response.openAndPrefetchAsync(future);
            assertTrue("test must release getStream", proceed.await(5, TimeUnit.SECONDS));
    public void testLosingThreadDoesNotReportReleaseWhileCloseInProgress() throws Exception {
        response.close();
     * {@link FlightTransportResponse#close()} and the prefetch's closed re-check can both reach the
        CompletableFuture<Header> future = new CompletableFuture<>();  
        when(stream.next()).thenReturn(true);
     * <p>The window is only a few instructions wide, so the interleaving is forced through the
        response.close();
        future.get(5, TimeUnit.SECONDS); // prefetch finished → flightStream published
        assertEquals(0, notifications.get());  
        CompletableFuture<Header> future = new CompletableFuture<>();
    public void testCopyMetadataEmptyBuffer() {
import static org.mockito.Mockito.doThrow;
        assertEquals("failed stream close must not report allocator buffers released", 0, notifications.get());  
        CountDownLatch finishStreamClose = new CountDownLatch(1);
        assertEquals(1, notifications.get());
    /** onClosed fires exactly once, after the published stream has been closed. */  
    }
import static org.mockito.Mockito.never;  
        verify(stream, timeout(5_000)).close(); // prefetch closed re-check self-closes  
     */
     * stream close: they write {@code flightStream} and {@code closed} in opposite orders, so each  
        @Override  
            assertTrue("test must release getStream", proceed.await(5, TimeUnit.SECONDS));
        FlightStream stream = mock(FlightStream.class);  
    public void testCopyMetadataNullBuffer() {  
        response.openAndPrefetchAsync(future);
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);  
import org.opensearch.transport.TransportResponseHandler;
import static org.mockito.Mockito.doAnswer;  
            }
        public void handleResponse(T response) {
            streamCloseInProgress.set(false);
    public void testCloseBeforePrefetchIsNoOp() {  
     * The race the fix targets: close() runs while the prefetch thread is still inside getStream(),  
        doThrow(new IllegalStateException("already closed")).when(stream).close();
    public void testOnClosedFiresOnceAfterStreamClose() throws Exception {
        );  
        response.openAndPrefetchAsync(future);
        verify(stream, timeout(5_000)).close();
            assertNull(FlightTransportResponse.copyMetadata(buf));  
        when(stream.next()).thenReturn(true);
    public void testOnClosedFiresWhenClosedBeforePrefetch() {
        expectThrows(StreamException.class, response::close);
 * compatible open source license.
        }  
import java.io.IOException;
            enteredGetStream.countDown();  
        });  
    }
            throw new UnsupportedOperationException();  
}
        response.close();
import org.apache.arrow.memory.RootAllocator;
        verify(stream, never()).close();
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());  
        public boolean skipsDeserialization() {
                    throw new AssertionError(e);  
        assertFalse(  
    public void testCancelStreamOnlyBeforePublishClosesResponse() throws Exception {
        }  
        assertNull(FlightTransportResponse.copyMetadata(null));
import static org.mockito.ArgumentMatchers.any;
        FlightStream stream = mock(FlightStream.class);  
        response.close();
        verify(stream, times(1)).close();  
        FlightClient client = mock(FlightClient.class);
