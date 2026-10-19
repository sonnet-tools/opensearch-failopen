            assertTrue("test must release getStream", proceed.await(5, TimeUnit.SECONDS));
            new NamedWriteableRegistry(List.of()),
        FlightClient client = mock(FlightClient.class);
        response.close(); // must not propagate the IllegalStateException
    public void testOnClosedFiresOnceAfterStreamClose() throws Exception {
        CompletableFuture<Header> future = new CompletableFuture<>();
    public void testOnClosedFiresAfterPrefetchSelfClose() throws Exception {
    private static final class TestArrowHandler extends ArrowBatchResponseHandler<TestArrowResponse> {
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
    public void testCloseRethrowsUnexpectedErrorAsStreamException() throws Exception {
        future.get(5, TimeUnit.SECONDS); // prefetch finished → flightStream published
     * {@code afterStreamPublished} seam rather than raced: close() runs (and gets as far as being
        verify(stream, times(1)).close();
        response.openAndPrefetchAsync(future);
        assertTrue(wrapped.skipsDeserialization());
        assertEquals(0, notifications.get());
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
        assertEquals(1, notifications.get());
        response.close();
    public void testNonArrowHandlerDoesNotSkip() {
    }
            notifications.incrementAndGet();
    }
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
            buf.writeBytes(payload);
    }
        response.setOnClosed(notifications::incrementAndGet);
        FlightStream stream = mock(FlightStream.class);
        CompletableFuture<Header> future = new CompletableFuture<>();
        AtomicInteger notifications = new AtomicInteger();
        FlightClient client = mock(FlightClient.class);
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
    public void testCopyMetadataNullBuffer() {
            assertTrue("test must release getStream", proceed.await(5, TimeUnit.SECONDS));
        assertTrue(enteredGetStream.await(5, TimeUnit.SECONDS));
import org.opensearch.arrow.transport.ArrowBatchResponse;
        @Override
        response.setOnClosed(() -> {
        verify(stream, timeout(5_000)).close(); // prefetch closed re-check self-closes
            enteredGetStream.countDown();
        response.openAndPrefetchAsync(future);
        CompletableFuture<Header> future = new CompletableFuture<>();
        }
        AtomicInteger notifications = new AtomicInteger();
import org.opensearch.transport.stream.StreamException;
            new Ticket(new byte[0]),
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        response.openAndPrefetchAsync(future);
                }
        public String executor() {
    /** close() is idempotent: a second call short-circuits and does not re-close the stream. */
            new Ticket(new byte[0]),
    /** onClosed fires when the prefetch failed before publishing a stream and close() runs later. */
            insideStreamClose.countDown();
        AtomicInteger notifications = new AtomicInteger();
        response.close();
    }
            }
        MetricsTrackingResponseHandler<TestArrowResponse> wrapped = new MetricsTrackingResponseHandler<>(new TestArrowHandler(), null);
        when(stream.next()).thenReturn(true);
        response.close();
        response.setOnClosed(notifications::incrementAndGet);
        try (var ignored = response.markDispatchThread()) {
        assertEquals(1, notifications.get());
            client,
        // The prefetch passed its closed-check before publishing the future, so it never self-closes;
            return delegate.executor();
        assertEquals(1, notifications.get());
        CompletableFuture<Header> future = new CompletableFuture<>();
    public void testCloseClosesPublishedStream() throws Exception {
        public void handleResponse(T response) {
            streamCloseInProgress.set(true);
        future.get(5, TimeUnit.SECONDS);
        return new FlightTransportResponse<>(
        @Override
        CountDownLatch notified = new CountDownLatch(1);
 * SPDX-License-Identifier: Apache-2.0
    }
        future.get(5, TimeUnit.SECONDS);
        // only the first close() closes the stream and the later calls short-circuit.
        TestArrowResponse() {
        }
        FlightStream stream = mock(FlightStream.class);
    /** A failed stream close must not report the buffers released, on either racing thread. */
        CompletableFuture<Header> future = new CompletableFuture<>();
    }
        verify(stream, times(1)).close();
        public String executor() {
        public TestArrowResponse read(org.opensearch.core.common.io.stream.StreamInput in) {
        when(client.getStream(any(Ticket.class), any())).thenAnswer(inv -> {
        assertEquals(0, notifications.get());
        when(client.getStream(any(Ticket.class), any())).thenAnswer(inv -> {
import org.apache.arrow.memory.RootAllocator;
        response.openAndPrefetchAsync(future);
            @Override
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        FlightClient client = mock(FlightClient.class);
    /** cancelStreamOnly on a published stream cancels it but must NOT close it: the consumer owns close. */
            if (streamCloseInProgress.get()) {
        response.cancelStreamOnly("channel closed");
                    Thread.currentThread().interrupt();
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        response.close(); // sees flightStream==null → closes nothing itself
            waitUntil(() -> notifications.get() > 0, 300, TimeUnit.MILLISECONDS)
    /** cancelStreamOnly before the stream is published falls back to close() so the prefetch self-closes. */
        FlightClient client = mock(FlightClient.class);
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
    }
            new FlightTransportConfig()
        ForwardingWrapper(TransportResponseHandler<T> delegate) {
            return delegate.read(in);
import org.opensearch.transport.TransportException;
import static org.mockito.Mockito.timeout;
        CountDownLatch enteredGetStream = new CountDownLatch(1);
     * while the winner is still inside {@link FlightStream#close()}, or a channel waiting on that
        response.openAndPrefetchAsync(future);
        assertNull(response.getDispatchThread());
     * may observe the other's write. Whichever loses the race must not report the buffers released
    // ── cancelStreamOnly() / onClosed notification (channel-close support) ──────
        response.close();
        response.close();
        finishStreamClose.countDown();
     * inside {@code FlightStream#close}) while the prefetch is parked between publishing the stream
        expectThrows(StreamException.class, response::close);
        assertTrue("prefetch must publish the stream", streamPublished.await(5, TimeUnit.SECONDS));
            return null;
        // close() ran after publish; the prefetch had already passed its closed-check, so close() owns the close.
        CompletableFuture<Header> future = new CompletableFuture<>();
    /** close() before any prefetch has a null stream — must be a no-op, no NPE. */
     * so close() sees flightStream==null and closes nothing. When the prefetch then publishes the
        // Whichever of close() and the prefetch's finally runs second fires the notification, so
        verify(stream, times(1)).cancel("channel closed", null);
        when(stream.next()).thenReturn(true);
        future.get(5, TimeUnit.SECONDS);
        response.openAndPrefetchAsync(future);
import static org.mockito.Mockito.times;
    /**
            }
                try {
    }
        FlightStream stream = mock(FlightStream.class);
        future.get(5, TimeUnit.SECONDS);
        FlightClient client = mock(FlightClient.class);
        }
     * {@link FlightTransportResponse#close()} and the prefetch's closed re-check can both reach the
        response.close();
            notifications.incrementAndGet();
        verify(stream, timeout(5_000).atLeastOnce()).close();
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
 */
            void afterStreamPublished() {
        assertTrue("close must reach the stream close", insideStreamClose.await(5, TimeUnit.SECONDS));
        assertNull(response.getDispatchThread());
        @Override
            new HeaderContext(),
import java.util.concurrent.TimeUnit;
    }
        try (RootAllocator allocator = new RootAllocator(); ArrowBuf buf = allocator.buffer(0)) {
        when(stream.next()).thenReturn(true);
    }
        assertFalse(new TestByteHandler().skipsDeserialization());
            return stream;
        proceed.countDown();
     */
    /** onClosed fires when close() raced the prefetch: notification follows the self-close. */
        @Override
import org.apache.arrow.flight.FlightClient;
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
    public void testCloseDuringPrefetchSelfClosesStream() throws Exception {
            new NamedWriteableRegistry(List.of()),
            delegate.handleResponse(response);
    public void testWrapperForwardsTrueFromArrowHandler() {
        FlightClient client = mock(FlightClient.class);
}
        assertTrue(enteredGetStream.await(5, TimeUnit.SECONDS));
            byte[] copy = FlightTransportResponse.copyMetadata(buf);
        assertFalse(
    }
        // Prefetch thread is parked inside getStream(); flightStream is still null.
                    throw new AssertionError(e);
        when(stream.next()).thenReturn(true);
    }
        public void handleException(TransportException exp) {
        doThrow(new RuntimeException("boom")).when(stream).close();
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
        doThrow(new RuntimeException("boom")).when(stream).close();
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
        verify(stream, times(1)).close();
        response.close();
     * <p>The window is only a few instructions wide, so the interleaving is forced through the
        FlightStream stream = mock(FlightStream.class);
        });
import java.util.concurrent.atomic.AtomicBoolean;
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    /**
    public void testWrapperForwardsFalseFromNonArrowHandler() {
    /**
import org.apache.arrow.memory.ArrowBuf;
    public void testCopyMetadataEmptyBuffer() {
        private final TransportResponseHandler<T> delegate;
        FlightClient client = mock(FlightClient.class);
import java.io.IOException;
    }
        FlightClient client = mock(FlightClient.class);
            1L,
            new FlightTransportConfig()
        @Override
     * directly (the test lives in the same package).
                } catch (InterruptedException e) {
        response.openAndPrefetchAsync(future);
        @Override
            assertSame(Thread.currentThread(), response.getDispatchThread());
    public void testCancelStreamOnlyBeforePublishClosesResponse() throws Exception {
    public void testOnClosedFiresWhenPrefetchFailedBeforePublish() throws Exception {
        when(client.getStream(any(Ticket.class), any())).thenThrow(new RuntimeException("connection refused"));
        public TransportResponse read(org.opensearch.core.common.io.stream.StreamInput in) {
        AtomicInteger notifications = new AtomicInteger();
        @Override
     * stream, its synchronous closed-check must self-close it (closed already true) so the first-batch
        FlightClient client = mock(FlightClient.class);
        verify(stream, times(1)).close();
        });
        );
        CompletableFuture<Header> future = new CompletableFuture<>();
    public void testRealMetricsTrackingWrapperForwards() {
        ) {
            return delegate.skipsDeserialization();
        assertBusy(() -> assertEquals(1, notifications.get()), 5, TimeUnit.SECONDS);
            super((org.apache.arrow.vector.VectorSchemaRoot) null);
    public void testOnClosedFiresWhenClosedBeforePrefetch() {
        CompletableFuture<Header> future = new CompletableFuture<>();
        try (RootAllocator allocator = new RootAllocator(); ArrowBuf buf = allocator.buffer(payload.length)) {
        byte[] payload = "{\"output_rows\":42}".getBytes(StandardCharsets.UTF_8);
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
    public void testArrowHandlerSkipsDeserialization() {
            assertNotSame(payload, copy);
        CompletableFuture<Header> future = new CompletableFuture<>();
import org.opensearch.core.transport.TransportResponse;
        assertFalse("closer did not finish", closer.isAlive());
    // ── close() / prefetch-race stream lifecycle ─────────────────────────────
        public T read(org.opensearch.core.common.io.stream.StreamInput in) throws IOException {
            delegate.handleException(exp);
        CountDownLatch streamPublished = new CountDownLatch(1);
import org.apache.arrow.flight.Ticket;
        // Loser: the prefetch now observes closed == true and reaches the same stream close.
import static org.mockito.Mockito.doThrow;
        public boolean skipsDeserialization() {
            return "same";
        when(stream.next()).thenReturn(true);
            new TestArrowHandler(),
        @Override
        assertFalse("release was reported while FlightStream#close was still in progress", notifiedDuringStreamClose.get());
        when(client.getStream(any(Ticket.class), any())).thenAnswer(inv -> {
        public void handleResponse(TransportResponse response) {}
        public void handleException(TransportException exp) {}
        };
     * Builds a response wired to the given client. Uses package-private collaborators
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
        }
        @Override
        // Winner: sees the published stream and parks inside FlightStream#close.
        verify(stream, never()).close();
        }
    public void testCloseBeforePrefetchIsNoOp() {
import static org.mockito.Mockito.doAnswer;
        }).when(stream).close();
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
            notified.countDown();
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
        doAnswer(inv -> {
import static org.mockito.Mockito.never;
        FlightClient client = mock(FlightClient.class);
            enteredGetStream.countDown();
            throw new UnsupportedOperationException();
     * stream close: they write {@code flightStream} and {@code closed} in opposite orders, so each
        assertTrue(new ForwardingWrapper<>(new TestArrowHandler()).skipsDeserialization());
        assertTrue("onClosed should fire after prefetch self-close", notified.await(5, TimeUnit.SECONDS));
        response.openAndPrefetchAsync(future);
                    assertTrue("test must resume the prefetch", resumePrefetch.await(5, TimeUnit.SECONDS));
        FlightStream stream = mock(FlightStream.class);
    /** onClosed fires even when the response is closed before any prefetch started. */
import org.apache.arrow.flight.FlightStream;
    private static final class TestByteHandler implements StreamTransportResponseHandler<TransportResponse> {
    }
        when(stream.next()).thenReturn(true);
        );
        proceed.countDown();
        CountDownLatch enteredGetStream = new CountDownLatch(1);
        response.cancelStreamOnly("channel closed"); // stream not yet published → close()
    }
        }
        AtomicInteger notifications = new AtomicInteger();
    }
        closer.start();
        response.openAndPrefetchAsync(new CompletableFuture<>());
import static org.mockito.ArgumentMatchers.any;
    /** A benign already-closed error from the stream is swallowed. */
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
    /** onClosed fires exactly once, after the published stream has been closed. */
        assertTrue(new TestArrowHandler().skipsDeserialization());
        response.close();
/*
    }
            1L,
        });
        CompletableFuture<Header> future = new CompletableFuture<>();
import java.nio.charset.StandardCharsets;
        response.close();
        });
        response.close();
        }
        doThrow(new IllegalStateException("already closed")).when(stream).close();
    }
        response.setOnClosed(() -> {
        }
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
        // The consumer's close still runs and releases the stream.
        public String executor() {
    private static final class TestArrowResponse extends ArrowBatchResponse {
            return stream;
    private FlightTransportResponse<TestArrowResponse> newResponse(FlightClient client, HeaderContext headerContext) {
    public void testCloseSwallowsAlreadyClosedError() throws Exception {
            this.delegate = delegate;
     */
package org.opensearch.arrow.flight.transport;
        assertFalse(new ForwardingWrapper<>(new TestByteHandler()).skipsDeserialization());
    }
        response.close(); // no stream yet
    public void testDispatchThreadMarkIsScopedToTheCallback() {
 * compatible open source license.
        future.get(5, TimeUnit.SECONDS);
    /** The dispatch-thread mark identifies the thread running the consumer callback, and clears after. */
        response.setOnClosed(notifications::incrementAndGet);
        response.close(); // prefetch still in flight → its closed re-check owns close + notify
        response.setOnClosed(notifications::incrementAndGet);
     *
            streamCloseInProgress.set(false);
            assertArrayEquals(payload, copy);
        Thread closer = new Thread(response::close, "stream-close-winner");
        CountDownLatch insideStreamClose = new CountDownLatch(1);
    public void testFailedStreamCloseNeverNotifies() throws Exception {
        response.openAndPrefetchAsync(future);
 *
import org.opensearch.transport.StreamTransportResponseHandler;
        verify(stream, never()).close();
                streamPublished.countDown();
        resumePrefetch.countDown();
            new TestArrowHandler(),
 * The OpenSearch Contributors require contributions made to
        @Override
        proceed.countDown();
        // MetricsTrackingResponseHandler in production path; null tracker is fine for this check.
import static org.mockito.Mockito.verify;
        CountDownLatch proceed = new CountDownLatch(1);
        AtomicInteger notifications = new AtomicInteger();
        CountDownLatch finishStreamClose = new CountDownLatch(1);
            return "same";
        FlightStream stream = mock(FlightStream.class);
 * this file be licensed under the Apache-2.0 license or a
            "no release may be reported while the stream close is in progress",
    }
        FlightClient client = mock(FlightClient.class);
        // Let the prefetch publish the stream; its closed-check must self-close it.
        CountDownLatch enteredGetStream = new CountDownLatch(1);
        CountDownLatch proceed = new CountDownLatch(1);
        FlightClient client = mock(FlightClient.class);
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.CountDownLatch;
        });
        FlightStream stream = mock(FlightStream.class);
        FlightStream stream = mock(FlightStream.class);
        when(stream.next()).thenReturn(true);
    public void testCloseIsIdempotent() throws Exception {
        response.setOnClosed(notifications::incrementAndGet);
        FlightStream stream = mock(FlightStream.class);
                notifiedDuringStreamClose.set(true);
        @Override
    }
    }
        CompletableFuture<Header> future = new CompletableFuture<>();
            // The copy is independent of the wire buffer.
        // A second caller observes the recorded failure instead of re-closing, and still must not notify.
        assertTrue("the stream close must still be in progress", streamCloseInProgress.get());
        public void handleException(TransportException exp) {}
    }
        public void handleResponse(TestArrowResponse response) {}
        verify(stream, timeout(5_000)).close();
        CountDownLatch resumePrefetch = new CountDownLatch(1);
        future.get(5, TimeUnit.SECONDS);
        AtomicBoolean streamCloseInProgress = new AtomicBoolean();
        }
        assertTrue(enteredGetStream.await(5, TimeUnit.SECONDS));
        FlightStream stream = mock(FlightStream.class);
    private static final class ForwardingWrapper<T extends TransportResponse> implements TransportResponseHandler<T> {
        expectThrows(StreamException.class, response::close);
            throw new UnsupportedOperationException();
    }
        response.close();
    /** An unexpected error from the stream is wrapped as a StreamException. */
import java.util.concurrent.CompletableFuture;
    }
        }
        AtomicInteger notifications = new AtomicInteger();
    /** Normal path: once the stream is published, close() closes it. */
            assertNull(FlightTransportResponse.copyMetadata(buf));
    }
        FlightClient client = mock(FlightClient.class);
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
    public void testCancelStreamOnlyCancelsWithoutClosing() throws Exception {
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
        }
        when(stream.next()).thenReturn(true);
import org.opensearch.transport.Header;
     * The race the fix targets: close() runs while the prefetch thread is still inside getStream(),
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
            enteredGetStream.countDown();
        when(client.getStream(any(Ticket.class), any())).thenReturn(stream);
        response.openAndPrefetchAsync(future);
public class FlightTransportResponseTests extends OpenSearchTestCase {
        when(stream.next()).thenReturn(true);
        }
        expectThrows(Exception.class, () -> future.get(5, TimeUnit.SECONDS));
        assertBusy(() -> assertEquals("stream must be reported released exactly once", 1, notifications.get()));
     * root is not stranded on the client allocator.
        when(stream.next()).thenReturn(true);
    public void testCopyMetadataPopulatedBuffer() {
        AtomicBoolean notifiedDuringStreamClose = new AtomicBoolean();
            assertNotNull(copy);
        // A second close is still safe.
import org.opensearch.transport.TransportResponseHandler;
        FlightClient client = mock(FlightClient.class);
     * notification closes its allocator too early.
        }
        assertNull(FlightTransportResponse.copyMetadata(null));
        @Override
            headerContext,
            assertTrue("test must release the stream close", finishStreamClose.await(5, TimeUnit.SECONDS));
        // it may arrive asynchronously on the prefetch thread.
    }
    }
     */
        CountDownLatch proceed = new CountDownLatch(1);
        response.openAndPrefetchAsync(future);
        assertEquals(1, notifications.get());
        assertEquals("failed stream close must not report allocator buffers released", 0, notifications.get());
        verify(stream, times(1)).close();
            return stream;
            assertTrue("test must release getStream", proceed.await(5, TimeUnit.SECONDS));
        FlightClient client = mock(FlightClient.class);
        @Override
        FlightStream stream = mock(FlightStream.class);
        FlightTransportResponse<TestArrowResponse> response = newResponse(client, new HeaderContext());
        FlightTransportResponse<TestArrowResponse> response = new FlightTransportResponse<>(
        when(stream.next()).thenReturn(true);
            client,
    public void testLosingThreadDoesNotReportReleaseWhileCloseInProgress() throws Exception {
        closer.join(TimeUnit.SECONDS.toMillis(5));
     * and re-checking the closed flag.
