        }
        channel.close();
                    while (streamResponse.nextResponse() != null) {
                }
    }
            ThreadPool.Names.SAME,
            @Override
            namedWriteableRegistry,
                }
import org.opensearch.core.common.bytes.BytesReference;
        verify(stream, times(1)).close();
     * blocking shutdown indefinitely. Here the stream is registered but stuck in getStream(), so
        config.setStreamCloseTimeout(TimeValue.timeValueSeconds(30));
            action,
        CountDownLatch handlerRemoved = new CountDownLatch(1);
        TestRequest testRequest = new TestRequest();
        assertEquals("Header is null", exception.getMessage());
                    serverLatch.countDown();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        LargeTestRequest testRequest = new LargeTestRequest("X".repeat(20 * 1024));
                    try {
            @Override
            @Override
            new TransportMessageListener() {
                        // Handle IO exception
        );
    /**
        assertNotNull(exception.get());
import static org.mockito.ArgumentMatchers.isNull;
            }
                } catch (Exception e) {
                handlerException.set(exp);
            (request, channel, task) -> {
        } finally {
        AtomicReference<Exception> sendListenerFailure = new AtomicReference<>();
        CountDownLatch handlerLatch = new CountDownLatch(1);
                }
        super.setUp();
        AtomicBoolean closed = new AtomicBoolean(false);
                    try {
        streamTransportService.sendRequest(
     */
                );
        assertTrue(exception.get() instanceof TransportException);
                @Override
        assertTrue("no error surfaced for " + code, latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
                        streamResponse.cancel("Client early cancellation", null);
            @Override
    public void testListenerManagement() throws InterruptedException {
        TransportMessageListener blockingListener = new TransportMessageListener() {
                public String executor() {
        assertEquals(StreamErrorCode.UNAVAILABLE, ((StreamException) handlerFailure.get()).getErrorCode());
        assertNull(handlerException.get());
                        + "] logged at "
            public TestResponse read(StreamInput in) throws IOException {
        };
                    channel.completeStream();
        }));
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
import static org.mockito.Mockito.verify;
    // ── channel close vs. active streams ───────────────────────────────────────
        AtomicReference<Exception> handlerException = new AtomicReference<>();
        AtomicReference<Exception> received = new AtomicReference<>();
                    }
    }
import java.util.concurrent.TimeUnit;
                    FlightClientChannel.class.getCanonicalName(),
            ThreadPool.Names.SAME,
            public String executor() {
                    while (streamResponse.nextResponse() != null) {
            // is expected here and must not fail the test.
        streamTransportService.sendRequest(
                    throw new AssertionError("stream consumer failed", e);
        return new StreamTransportResponseHandler<>() {
            action,
                } catch (Exception e) {
        void accept(StreamTransportResponse<TestResponse> streamResponse) throws Exception;
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
            remoteNode,
    }
                handlerException.set(exp);
import org.opensearch.cluster.node.DiscoveryNode;
            @Override
        channel.addCloseListener(kept);
                    handlerLatch.countDown();
                return new TestResponse(in);
                    return ThreadPool.Names.SAME;
        };
        }
                channel.completeStream();
        channel = new FlightClientChannel(
    }
            public DiscoveryNode getNode() {
                throw new AssertionError("consumer must not be invoked after an open failure");
            closeElapsedMillis.set(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
                        streamResponse.close();
            latch.countDown();
    }
    public void testStreamResponseProcessingWithHandlerException() throws InterruptedException {
                    handlerLatch.countDown();
            threadPool,
        assertErrorCodeRoundTrips(StreamErrorCode.UNAVAILABLE, "Network closed for unknown reason");
        assertEquals("FlightClientChannel is closed", exception.get().getMessage());
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        assertEquals(StreamErrorCode.CANCELLED, ((StreamException) serverException.get()).getErrorCode());
        TransportMessageListener testListener = new TransportMessageListener() {
            in -> new TestRequest(in),
        CountDownLatch connectLatch = new CountDownLatch(1);
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
     * expectations all assert that something was seen; this asserts a property of everything that was.
        assertTrue(closeLatch.await(1, TimeUnit.SECONDS));
            }
            @Override
                    }
            @Override
                handlerLatch.countDown();
                    handlerException.set(e);
                streamTransportService.sendRequest(
    public void testNullHeaderFailsStreamWithoutDereferencingIt() throws Exception {
                handlerLatch.countDown();
        TransportResponseHandler<TestResponse> responseHandler = new TransportResponseHandler<>() {
                        streamResponse.close();
        };
                handlerLatch.countDown();
import org.opensearch.transport.TransportRequestOptions;
     *
                    TestResponse response3 = new TestResponse("Response 3");
                        channel.sendResponse(e);
                handlerException.set(exp);
                return new TestResponse(in);
        CountDownLatch latch = new CountDownLatch(1);
        releaseConsumer.countDown();
        return new FlightClientChannel(
        public void assertMatched() {
            }
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
            flightTransport.getResponseHandlers(),
        assertNull(error.get());
        assertEquals(4, messageSentCount.get()); // completeStream is counted too
        AtomicReference<Exception> exception = new AtomicReference<>();
                        throw new IllegalStateException("timed out waiting to continue send");
            headerContext,
        AtomicReference<Exception> handlerException = new AtomicReference<>();
            }
            .orElse(null);
        streamTransportService.registerRequestHandler(
                try {
                try {
    /** A removable close listener fires on close, and is no longer fired once it has been removed. */
        when(mockFlightClient.getStream(any(Ticket.class), any())).thenReturn(stream);
            assertTrue("test must release the consumer", releaseConsumer.await(TIMEOUT_SEC, TimeUnit.SECONDS));
import org.opensearch.transport.TransportMessageListener;
            public void handleException(TransportException exp) {
            }
}
                try {
        StreamConsumer consumer,
            @Override
                return new TestResponse(in);
                handlerLatch.countDown();
        FlightStream stream = mock(FlightStream.class);
        Thread closer = new Thread(channel::close, "channel-closer");
            public void handleResponse(TestResponse response) {
        when(stream.next()).thenReturn(true);
            // The channel closes while the stream is still opening, so the handler is failed; that
            }
    /**
    private final int TIMEOUT_SEC = 10;
            insideGetStream.countDown();
                try {
    /** A header context that answers any correlation id, so a mocked client can drive dispatch. */
            long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
    public void testCloseWaitsForStreamHeldByAnotherThread() throws Exception {
                    Thread.sleep(4000); // Allow client to process and cancel
     * Fails if any event from {@code logger} carries a throwable, whatever its level. The framework's
            }
            statsCollector,
        assertNotNull(channel.getChannelStats());
import java.util.concurrent.atomic.AtomicBoolean;
        };
                    } catch (IOException ignored) {}
        assertTrue(
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {
            statsCollector,
            }
        assertTrue("consumer must take the stream", consumerHoldingStream.await(TIMEOUT_SEC, TimeUnit.SECONDS));
                    event.getThrown()
            @Override
import org.opensearch.threadpool.ThreadPool;
        @Override
        public void match(LogEvent event) {
            }
                try {
            assertThat("close must give up at the timeout", elapsedMillis, lessThan(TimeUnit.SECONDS.toMillis(TIMEOUT_SEC)));
            public TestResponse read(StreamInput in) throws IOException {
                } catch (Exception e) {
            in -> new TestRequest(in),
            public TestResponse read(StreamInput in) throws IOException {
                        // Handle IO exception
            }
        LargeTestRequest(StreamInput in) throws IOException {
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        BytesReference message = new BytesArray("test message");
import org.opensearch.core.common.bytes.BytesArray;
                    try {
        CountDownLatch closeLatch = new CountDownLatch(2);
    public void testSendMessageNotifiesHandlerWhenCloseRacesRegistration() throws Exception {
        );
import java.util.function.BiConsumer;
        assertEquals(3, responseCount.get());
/*
                }
                return ThreadPool.Names.SAME;
                    new TestRequest(),
                }
        when(mockFlightClient.getStream(any(Ticket.class), any())).thenReturn(stream);
        AtomicReference<TransportException> handlerException = new AtomicReference<>();
        channel = createChannel(mockFlightClient, stubHeaderContext(), config);
        TestRequest testRequest = new TestRequest();
            handler
        testChannel.close();
        FlightTransportConfig config = new FlightTransportConfig();
            }
                try {
                    secondBatchCalled.set(true);
        closer.join(500);
    }
    static class LargeTestRequest extends TestRequest {
                    }
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
            }
            serverLocation,
                return false;
    private void assertErrorCodeRoundTrips(StreamErrorCode code, String message) throws InterruptedException {
            flightTransport.getResponseHandlers(),
                public TestResponse read(StreamInput in) throws IOException {
     * instead of yielding it. With one such failure per stream, a mass reconnect can pin every carrier while
            ThreadPool.Names.SAME,
        }, exception -> connectLatch.countDown()));
                        }
            streamResponse.close();
            out.writeString(largeData);
            new FlightTransportConfig()
            sendStreamRequest(streamingHandler(ThreadPool.Names.SAME, streamResponse -> {
        assertTrue(sendListenerFailure.get() instanceof StreamException);
     * <p>A null header is reachable in production: {@code HeaderContext.getHeader} is a plain map removal,
        channel.close();
                handlerException.set(exp);
            context,
    /**
        }
                    TestResponse response1 = new TestResponse("Response 1");
                    channel.sendResponseBatch(response2);
                    try {
            @Override
        assertThat(
import org.opensearch.core.transport.TransportResponse;
            appender.assertAllExpectationsMatched();
            }
        );
        final long timeoutMillis = TimeUnit.SECONDS.toMillis(10);
     * exception type, so the code is the only signal that crosses.
            namedWriteableRegistry,
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options) {
    public void tearDown() throws Exception {
                        assertEquals("Response " + (Integer.valueOf(responseCount.get()) + 1), response.getData());
        AtomicInteger responseCount = new AtomicInteger(0);
        CountDownLatch handlerLatch = new CountDownLatch(1);
        assertTrue("Response count should be 1, but was: " + responseCount.get(), responseCount.get() == 1);
        if (channel != null) {
        }, handlerException));
            @Override
                    channel.sendResponse(new RuntimeException("Simulated handler exception"));
                return header;
        }
                try {
                    handlerLatch.countDown();
import org.apache.arrow.flight.FlightClient;
    public void testStreamFailureIsLoggedWithoutAThrowable() throws Exception {
            public void addCloseListener(ActionListener<Void> listener) {}
import org.apache.arrow.flight.FlightStream;
import java.io.IOException;
        FlightStream stream = mock(FlightStream.class);
                } finally {
                    }
        assertTrue(closed.get());
                        responseCount.incrementAndGet();
                }
            @Override
            public boolean isClosed() {
    public void testErrorInInterimBatchFromServer() throws InterruptedException, IOException {
 * The OpenSearch Contributors require contributions made to
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {
    }
                        streamResponse.close();
                    }
            public void onResponseReceived(long requestId, Transport.ResponseContext context) {
            connectLatch.countDown();
                } finally {
        AtomicInteger responseCount = new AtomicInteger(0);
        String executor,
                    connection,
        AtomicReference<Exception> serverException = new AtomicReference<>();
    }
    }
        );
        String action = "internal:test/interim-batch-error";
            }
                try {
     * the resulting native frame cannot be unmounted, so a contended classloader lock pins the carrier
        channel.close();
        assertNotNull(sendListenerFailure.get());
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
        streamTransportService.registerRequestHandler(
        TestRequest testRequest = new TestRequest();
        CountDownLatch insideGetStream = new CountDownLatch(1);
                    while ((streamResponse.nextResponse()) != null) {
        }, exception -> closeLatch.countDown()));
            public String executor() {
            lessThan(timeoutMillis / 2)
        CountDownLatch continueSend = new CountDownLatch(1);
            public String executor() {
    }
        verify(stream, times(1)).close();
        assertNotNull(exception.get());
        CountDownLatch latch = new CountDownLatch(1);
            },
        NoThrowableAttachedExpectation(String logger) {
        assertTrue(connected.get());
            }
        }
    }
        AtomicBoolean connected = new AtomicBoolean(false);
        Transport.Connection connection = new Transport.Connection() {
                channel.sendMessage(requestId, new BytesArray("test message"), ActionListener.wrap(r -> {}, e -> {
                try {
        assertTrue(closeLatch.await(1, TimeUnit.SECONDS));
        TestRequest testRequest = new TestRequest();
    public void testThreadPoolExhaustion() throws InterruptedException {
    private FlightClient mockFlightClient;
        // A real executor, not SAME: that is where the bug is observable. The dispatch task runs on a
     * message. This is the leg analytics relies on — {@code AnalyticsTransportErrors.toWireError} tags a
        channel = createChannel(mockFlightClient);
        assertEquals(1, responseCount.get());
            super.writeTo(out);
                    if (continueSend.await(5, TimeUnit.SECONDS) == false) {
                } catch (Exception e) {
        );
        CountDownLatch handlerLatch = new CountDownLatch(1);
                } finally {
                    "internal:test/channel-close-race",
    @After
 * this file be licensed under the Apache-2.0 license or a
            }
 *
        channel.close();
            }
        channel = createChannel(mockFlightClient);
                    throw new RuntimeException("Interim batch error");
            }
            }
import org.opensearch.core.action.ActionListener;
            }
        }));
package org.opensearch.arrow.flight.transport;
                channel.sendMessage(
        );
        assertNotNull(handlerException.get());
import org.opensearch.Version;
        AtomicReference<TransportException> handlerException = new AtomicReference<>();
            @Override
            public void handleException(TransportException exp) {
                return new TestResponse(in);
            }
                messageSentCount.incrementAndGet();
            public void onResponseSent(long requestId, String action, TransportResponse response) {
            public TestResponse read(StreamInput in) throws IOException {
        assertTrue(latch.await(1, TimeUnit.SECONDS));
    ) {
            }
                    TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
                return ThreadPool.Names.SAME;
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
    private StreamTransportResponseHandler<TestResponse> streamingHandler(String executor, StreamConsumer consumer) {
        TestRequest testRequest = new TestRequest();
import org.apache.arrow.flight.CallStatus;
            }
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
    }
                @Override
        };
            }
            threadPool,
            }
            }
            @Override
            return stream;
                    handlerLatch.countDown();
            @Override
    }
            in -> new TestRequest(in),
        AtomicReference<Exception> exception = new AtomicReference<>();
                }
    public void testSendMessageWhenClosed() throws InterruptedException {
            @Override
        sendStreamRequest(streamingHandler(ThreadPool.Names.GENERIC, streamResponse -> {
            closeElapsedMillis.get(),
            public boolean isClosed() {
                    while ((response = streamResponse.nextResponse()) != null) {
            }
            releaseGetStream.countDown();
        // Allow for race condition - response count could be 0 or 1 depending on timing
                        channel.sendResponse(e);
        channel = createChannel(mockFlightClient);
            }
        channel.addCloseListener(ActionListener.wrap(response -> {
            @Override
        Exception e = received.get();
     *                      handler exception fails the test.
        };
    }
                    channel.sendResponse(new StreamException(code, message));
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(FlightClientChannel.class))) {
            }
                    } catch (IOException ioException) {
                    channel.sendResponseBatch(response2); // This should throw StreamException with CANCELLED code
    @Override
            public TestResponse read(StreamInput in) throws IOException {
                return executor;
     * Wire round-trip: a {@link StreamException} with a specific {@link StreamErrorCode} sent from the
            }
                handlerLatch.countDown();
            consumerDone.countDown();
    public void testCloseFromConsumerCallbackDoesNotWaitForItsOwnStream() throws Exception {
            serverLocation,
            new StreamTransportResponseHandler<TestResponse>() {
            @Override
            @Override
        sendStreamRequest(streamingHandler(ThreadPool.Names.GENERIC, streamResponse -> {
     * happen until the close returns. Waiting would burn the whole timeout to no effect.
            }
                    throw new AssertionError("unexpected handler exception", exp);
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/18938")
                }
            testRequest,
        assertTrue(handlerFailure.get() instanceof StreamException);
            );
    }
import org.opensearch.transport.Transport;
                } finally {
        assertEquals("the listener that was kept must fire exactly once", 1, fires.get());
            @Override
                    throw new AssertionError("send failed", e);
        config.setStreamCloseTimeout(TimeValue.timeValueMillis(timeoutMillis));
        assertNotNull("expected an error for " + code, e);
     * what arms the deadlock.
        CountDownLatch latch = new CountDownLatch(1);
            } catch (Throwable t) {
import org.junit.After;
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
     * service so the channel resolves it from its response handlers as it would in production.
                    }
            @Override
    // ── stream failure reporting ───────────────────────────────────────────────
                    latch.countDown();
        LargeTestRequest(String data) {
    }
            public String executor() {
                handlerNotifications.incrementAndGet();
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
            (request, channel, task) -> {
            }
        // Generous: a regression here shows up as the elapsed-time assertion below, not as a timeout.
import static org.mockito.Mockito.times;
                    while (streamResponse.nextResponse() != null) {
            @Override
            channel.close();
        streamTransportService.registerRequestHandler(
        assertTrue(latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
                return ThreadPool.Names.SAME;
        };
            @Override
            mockFlightClient,
        channel.addConnectListener(ActionListener.wrap(r -> lateLatch.countDown(), e -> lateLatch.countDown()));
import org.opensearch.test.MockLogAppender;
        public void writeTo(StreamOutput out) throws IOException {
    public void testChannelLifecycle() throws InterruptedException {
            public String executor() {
     *
    public void testRemovableCloseListenerCanBeGivenBack() {
        channel.addConnectListener(ActionListener.wrap(response -> {
            action,
        assertFalse(channel.isServerChannel());
                    "stream failure reported with its cause",
            public void handleException(TransportException exp) {
                    }
            public String executor() {
            sendThread.join(TimeUnit.SECONDS.toMillis(5));
                } catch (Exception e) {
                        responseCount.incrementAndGet();
        assertTrue(channel.isOpen());
     */
                return ThreadPool.Names.SAME;
        assertNull(handlerException.get());
                    consumer.accept(streamResponse);
            }
                    channel.completeStream();
            }
        assertTrue(serverLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
            boundAddress,
        super.tearDown();
                new MockLogAppender.SeenEventExpectation(
        channel.addCloseListener(removed);
        channel = createChannel(mockFlightClient);
                    "*Exception while handling stream response*connection reset*"
    }
                fail("stream response should not be dispatched after channel close");
            @Override
                        streamResponse.close();
                offender.compareAndSet(null, event.toImmutable());
                    received.set(e);
            assertTrue("test must release getStream", releaseGetStream.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        }
                } catch (Exception e) {
    }
        CountDownLatch handlerLatch = new CountDownLatch(1);
        assertTrue("consumer must finish", consumerDone.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        @Override
        AtomicInteger fires = new AtomicInteger(0);
                channel.sendResponseBatch(new TestResponse("OK"));
            public String executor() {
                    throw e;
            long start = System.nanoTime();
import org.apache.logging.log4j.Level;
                    "stack trace rendered as text at TRACE",
            LogEvent event = offender.get();
                } catch (InterruptedException e) {
    }
        try {
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
     */
            "internal:test/channel-close",
        assertTrue("expected a StreamException but got " + exception, exception instanceof StreamException);
            remoteNode,
    }
                } catch (Exception e) {
        when(stream.next()).thenReturn(true);
        when(header.getHeaders()).thenReturn(new Tuple<>(Map.of(), Map.of()));
    }
                        + event.getLevel()
                try {
     */
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
            public TestResponse read(StreamInput in) throws IOException {
            "test-profile",
     * @param exceptionSink where an expected handler exception is recorded; when {@code null}, any
    /** A removable close listener registered after close() fires immediately. */
        assertTrue(connectLatch.await(1, TimeUnit.SECONDS));
public class FlightClientChannelTests extends FlightTransportTestBase {
        channel.sendMessage(-1, message, ActionListener.wrap(response -> latch.countDown(), ex -> {
                try {
        channel.addCloseListener(ActionListener.wrap(r -> closeLatch.countDown(), e -> closeLatch.countDown()));
        assertEquals("error code must survive the wire", code, se.getErrorCode());
            public void addCloseListener(ActionListener<Void> listener) {}
                        // Cancel after first response
                    try {
            @Override
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
    public void testAddRemovableCloseListenerAfterCloseFiresImmediately() {
            assertThat("close must wait for the stream", elapsedMillis, greaterThanOrEqualTo(timeoutMillis));
        Thread sendThread = new Thread(() -> {
            config
import org.apache.logging.log4j.core.LogEvent;
                @Override
            in -> new TestRequest(in),
            @Override
        assertErrorCodeRoundTrips(StreamErrorCode.RESOURCE_EXHAUSTED, "memory budget exhausted on shard");
        when(header.getVersion()).thenReturn(Version.CURRENT);
            @Override
        assertTrue(latch.await(1, TimeUnit.SECONDS));
import static org.hamcrest.Matchers.lessThan;
            public String executor() {
        BiConsumer<Void, ? super Exception> kept = (v, e) -> fires.incrementAndGet();
        assertTrue("listener added after close must fire immediately", fired.get());
            @Override
                return false;
        TransportResponseHandler<TestResponse> responseHandler = new TransportResponseHandler<TestResponse>() {
            closeLatch.countDown();
    public void testStreamResponseWithCustomExecutor() throws InterruptedException, IOException {
                } catch (RuntimeException e) {
        );
    }
        TestRequest testRequest = new TestRequest();
                } catch (IOException ignored) {}
                    Thread.currentThread().interrupt();
            );
     */
import static org.mockito.ArgumentMatchers.any;
            }
    }
                return ThreadPool.Names.SAME;
            public void handleException(TransportException exp) {
     * reporting healthy. The cause must therefore reach the log as text.
            "Expected TransportException but got: " + handlerException.get().getClass(),
            appender.addExpectation(
        flightTransport.setMessageListener(listener1);
            // The stack trace is still available, just pre-rendered as text instead of as a throwable.
                    channel.sendResponseBatch(response1);
        };
        FlightTransportConfig config = new FlightTransportConfig();
        // A long timeout: if the wait ever expires, that is a failure rather than a slow pass.
     * {@code fromWireError} rebuilds a 429 from the code that survives here. Flight does not serialize the
                }));
            public void handleResponse(TestResponse response) {
    /**
            @Override
                return new TestResponse(in);
                    Thread.sleep(1000);
            @Override
                    try {
        assertEquals("Simulated handler exception", handlerException.get().getMessage());
                public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
            if (event != null) {
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options) {
        String action = "internal:test/stream/errorcode/" + code.name();
            @Override
                }
        channel.addConnectListener(ActionListener.wrap(r -> connectLatch.countDown(), e -> connectLatch.countDown()));
     */
            in -> new TestRequest(in),
                    handlerException.set(e);
            "close must skip the stream owned by the calling thread instead of waiting for it",
            try {
                        streamResponse.close();
                    channel.sendResponseBatch(response3);
            appender.addExpectation(
        assertThat(closeElapsedMillis.get(), greaterThanOrEqualTo(0L));
        try {
                return null;
     * debugging this very failure, so it is the branch that most needs to be safe: turning it on must not be
        String action = "internal:test/early-cancel";
                try {
        };
                        streamResponse.close();
    private FlightClientChannel channel;
     * consumer's own stream: it can only be released after the callback returns, which cannot
import org.opensearch.transport.stream.StreamException;
        assertTrue(lateLatch.await(1, TimeUnit.SECONDS));
                } catch (Exception e) {
        assertNotNull(handlerFailure.get());
                    handlerLatch.countDown();
    @TestLogging(value = "org.opensearch.arrow.flight.transport.FlightClientChannel:TRACE", reason = "verbose branch must be safe")
import java.util.concurrent.atomic.AtomicInteger;
            // The cause must still be identifiable from the message alone, since the throwable is gone.
            @Override
                    "*Exception while handling stream response*\n\tat *"
                handlerException.set(exp);
                handlerFailure.set(exp);
                return new TestResponse(in);
                    }
        }, "flight-send-close-race-test");
            assertBusy(() -> assertNotNull("handler must be notified of the failure", handlerException.get()));
                new MockLogAppender.SeenEventExpectation(
            }
import java.util.concurrent.atomic.AtomicLong;
            @Override
            (request, channel, task) -> {
            AtomicReference<TransportException> handlerException = new AtomicReference<>();
    private HeaderContext stubHeaderContext() {
        AtomicReference<TransportException> handlerFailure = new AtomicReference<>();
        String action = "internal:test/custom-executor";
     * Sends a stream request over {@link #channel}, registering the handler through the transport
     * the lock holder sits unmounted and unschedulable, and the node stops making progress while still
        AtomicReference<Exception> handlerException = new AtomicReference<>();
    }
        FlightClientChannel testChannel = createChannel(mockFlightClient, exhaustedThreadPool);
                    error.set(exp);
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
            action,
        );
                }
     */
        assertNull("send thread failed", sendThreadFailure.get());
        assertTrue("close must wait for the consumer to release the stream", closer.isAlive());
                        + " carried "
            (request, channel, task) -> {
import org.opensearch.transport.Header;
            ThreadPool.Names.SAME,
            }
            new TestRequest(),
            }
    }
        CountDownLatch connectLatch = new CountDownLatch(2);
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
            @Override
                handlerException.set(exp);
            sendStreamRequest(streamingHandler(ThreadPool.Names.GENERIC, streamResponse -> streamResponse.close(), handlerException));
                    TestResponse response1 = new TestResponse("Response 1");
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
        assertTrue("message must survive the wire, got: " + se.getMessage(), se.getMessage() != null && se.getMessage().contains(message));
import static org.mockito.Mockito.timeout;
    /**
            "test-profile",
            @Override
        AtomicReference<Exception> handlerException = new AtomicReference<>();
                }
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
                    }
        streamTransportService.sendRequest(remoteNode, action, new TestRequest(), options, responseHandler);
            channel.close();
    public void testFrameworkLevelStreamCreationError() throws InterruptedException {
            continueSend.countDown();
        BytesReference message = new BytesArray("test message");
        };
        config.setStreamCloseTimeout(TimeValue.timeValueMillis(timeoutMillis));
        private final String largeData;
                return new TestResponse(in);
    }
        );
        channel = createChannel(mockFlightClient);
            @Override
        Thread.sleep(100);
        channel = createChannel(mockFlightClient, noHeader, new FlightTransportConfig());
        assertNotNull("error must surface as a StreamException, got: " + e, se);
        CountDownLatch closeLatch = new CountDownLatch(1);
import java.util.concurrent.RejectedExecutionException;
            }
        BiConsumer<Void, ? super Exception> removed = (v, e) -> fail("a removed listener must not fire");
                    FlightClientChannel.class.getCanonicalName(),
        CountDownLatch releaseConsumer = new CountDownLatch(1);
import java.util.concurrent.atomic.AtomicReference;
                throw new AssertionError(
        assertEquals("response handler must be notified exactly once", 1, handlerNotifications.get());
     * its headers arrived).
    /**
            assertTrue("send must remove its response handler before channel close", handlerRemoved.await(5, TimeUnit.SECONDS));
                }
        );
        // pool thread, so without the return the NPE escapes as an uncaught exception and fails the
        when(exhaustedThreadPool.executor(any())).thenThrow(new RejectedExecutionException("Thread pool exhausted"));
                );
                        + event.getThrown(),
            try {
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        assertFalse(channel.isOpen());
                handlerLatch.countDown();
import java.util.concurrent.CountDownLatch;
            public TestResponse read(StreamInput in) throws IOException {
            }
        AtomicReference<Throwable> sendThreadFailure = new AtomicReference<>();
                    Level.ERROR,
            }
                        latch.countDown();
            ThreadPool.Names.SAME,
                }
        // The production path for a header that was never stored.
                    channel.sendResponseBatch(response1);
        }));
        String action = "internal:test/stream/exception";
        channel.close();
                );
        AtomicBoolean secondBatchCalled = new AtomicBoolean(false);
                }
            (request, channel, task) -> {
import org.opensearch.test.junit.annotations.TestLogging;
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
            }
        when(mockFlightClient.getStream(any(Ticket.class), any())).thenAnswer(inv -> {
            @Override
    /**
            action,
        FlightStream stream = mock(FlightStream.class);
import static org.mockito.Mockito.when;
        assertTrue(secondBatchCalled.get());
            appender.addExpectation(new NoThrowableAttachedExpectation(FlightClientChannel.class.getCanonicalName()));
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
        assertNotNull(handlerException.get());
        assertBusy(() -> assertNotNull("handler must be notified of the failure", handlerException.get()));
        channel = createChannel(mockFlightClient, stubHeaderContext(), config);
                } finally {
            exception.set(ex);
                }
            public void handleException(TransportException exp) {
                    responseHandler
        );
                } catch (Exception e) {
    }
        AtomicInteger handlerNotifications = new AtomicInteger();
                )
        when(stream.next()).thenReturn(true);
            public void close() {}
                    handlerException.set(e);
            consumerHoldingStream.countDown();
    /**
        ThreadPool exhaustedThreadPool = mock(ThreadPool.class);
            boundAddress,
            super(in);
        };
        streamTransportService.registerRequestHandler(
            }
                    if (response != null) {
            channel.close();
                    } finally {
        FlightTransportConfig config = new FlightTransportConfig();
            action,
            public void handleException(TransportException exp) {
                handlerRemoved.countDown();
            }
            action,
            }
            serverException.get()
                    } catch (IOException ignored) {}
        };
                    channel.sendResponse(e);
                    } catch (Exception e) {
            Header getHeader(long correlationId) {
            @Override
            flightClient,
            @Override
            ThreadPool.Names.SAME,
        closer.join(TimeUnit.SECONDS.toMillis(TIMEOUT_SEC));
        sendStreamRequest(streamingHandler(ThreadPool.Names.SAME, streamResponse -> {
                return remoteNode;
            this.logger = logger;
            handlerException.get() instanceof TransportException
    private static final class NoThrowableAttachedExpectation implements MockLogAppender.LoggingExpectation {
            }
        String action = "internal:test/stream";
import org.apache.logging.log4j.LogManager;
            public void handleException(TransportException exp) {
            @Override
            CallStatus.UNAVAILABLE.withDescription("connection reset").toRuntimeException()
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
                    } catch (Exception e) {}
        channel = createChannel(mockFlightClient);
        FlightStream stream = mock(FlightStream.class);
                return ThreadPool.Names.SAME;
     * raised inside the dispatch task — where nothing reports it to the handler.
            public void onResponseSent(long requestId, String action, Exception error) {
                if (exceptionSink == null) {
                exceptionSink.set(exp);
            }
        TransportResponseHandler<TestResponse> responseHandler = new TransportResponseHandler<>() {
        TransportException exception = handlerException.get();
        String action = "internal:test/large";
                    } catch (IOException ioException) {}
            @SuppressWarnings("rawtypes")
                }
        channel.close();
        AtomicInteger responseCount = new AtomicInteger(0);
        final long timeoutMillis = 300;
        mockFlightClient = mock(FlightClient.class);
        AtomicLong closeElapsedMillis = new AtomicLong(-1);
     * <p>TRACE is enabled here on purpose. The verbose branch is the one an operator reaches for while
import static org.mockito.ArgumentMatchers.anyString;
            assertTrue("stream must be registered and opening", insideGetStream.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        AtomicReference<Exception> handlerException = new AtomicReference<>();
            }
        channel = createChannel(mockFlightClient);
        CountDownLatch releaseGetStream = new CountDownLatch(1);
                    handlerException.set(e);
                    new BytesArray("test message"),
            public TestResponse read(StreamInput in) throws IOException {
        assertNotNull(
        AtomicReference<Exception> handlerException = new AtomicReference<>();
                        error.set(e);
            remoteNode,
            }
            @Override
                }
        assertNotNull(handlerException.get());
            }
 * SPDX-License-Identifier: Apache-2.0
        };
        TransportMessageListener listener1 = new TransportMessageListener() {
        assertFalse("send thread did not finish", sendThread.isAlive());
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        CountDownLatch consumerDone = new CountDownLatch(1);
            @Override
                    try {
        AtomicInteger messageSentCount = new AtomicInteger(0);
        closer.start();
import org.opensearch.transport.StreamTransportResponseHandler;
        Transport.Connection connection = new Transport.Connection() {
                    Level.TRACE,
                    TestResponse response2 = new TestResponse("Response 2");
                } catch (StreamException e) {
            consumerDone.countDown();
        // Don't register any handler for this action - this will cause framework-level error
import org.apache.arrow.flight.Ticket;
        };
                received.set(exp);
import org.opensearch.transport.TransportException;
                handlerLatch.countDown();
                sendThreadFailure.set(t);
    private void sendStreamRequest(TransportResponseHandler<TestResponse> handler) {
     * <p>These paths run on the per-stream prefetch virtual thread. OpenSearch's JSON layout always applies
            }
                    TestResponse response2 = new TestResponse("Response 2");
     * Close must cancel an active stream and then wait for its consumer — running on another
        verify(stream, timeout(TimeUnit.SECONDS.toMillis(TIMEOUT_SEC))).cancel(anyString(), isNull());
                    try {
import org.opensearch.core.common.io.stream.StreamInput;
            long start = System.nanoTime();
                return ThreadPool.Names.SAME;
                latch.countDown();
            }
        BiConsumer<Void, ? super Exception> late = (v, e) -> fired.set(true);
        CountDownLatch consumerDone = new CountDownLatch(1);
            blockingListener,
            Header getHeader(long correlationId) {
                } catch (IOException ex) {}
        String action = "internal:test/unregistered-action";
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        AtomicReference<TransportException> exceptionSink
import org.opensearch.core.common.io.stream.StreamOutput;
                    latch.countDown();
    /**
            @Override
        TransportMessageListener listener2 = new TransportMessageListener() {
                    } catch (IOException ioException) {
                latch.countDown();
        AtomicReference<Exception> error = new AtomicReference<>();
import org.opensearch.transport.TransportRequest;
                    throw new IllegalStateException("interrupted while waiting to continue send", e);
        });
    }
    /** Consumer body for {@link #streamingHandler}, allowed to block and to throw. */
        channel = createChannel(mockFlightClient, stubHeaderContext(), new FlightTransportConfig());
    }
                // messageSentCount.incrementAndGet();
            }
            public void handleResponse(TestResponse response) {
                    TestResponse response;
        CountDownLatch handlerLatch = new CountDownLatch(1);
import static org.mockito.Mockito.mock;
    public void testStreamResponseWithEarlyCancellation() throws InterruptedException {
                    TestResponse response = streamResponse.nextResponse();
            public void handleException(TransportException exp) {
            @Override
            channel.close();
import java.util.Map;
    public void testCloseGivesUpAfterStreamCloseTimeout() throws Exception {
            public void handleException(TransportException exp) {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> flightTransport.setMessageListener(listener2));
        when(mockFlightClient.getStream(any(Ticket.class), any())).thenReturn(stream);
     * there is nothing to cancel and nothing that can report itself released.
                    } catch (Exception e) {}
            throw new AssertionError("consumer must not be invoked without a header");
        channel.addConnectListener(ActionListener.wrap(r -> connectLatch.countDown(), e -> connectLatch.countDown()));
            public DiscoveryNode getNode() {
        }
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {
import org.opensearch.transport.stream.StreamTransportResponse;
            latch.countDown();
        HeaderContext noHeader = new HeaderContext() {
            @Override
                try {
            in -> new TestRequest(in),
                        responseCount.incrementAndGet();
                        serverException.set(e);
                return ThreadPool.Names.GENERIC;
            }
import org.opensearch.ExceptionsHelper;
                    TestResponse response1 = new TestResponse("Response 1");
            public void close() {}
 */
            }
            if (event.getLoggerName().equals(logger) && event.getThrown() != null) {
            @Override
                    if (e.getErrorCode() == StreamErrorCode.CANCELLED) {
                    }
                        channel.sendResponse(e);
        );
            } catch (Exception e) {
                        + event.getMessage().getFormattedMessage()
            streamResponse.close();
            }
                    ActionListener.wrap(response -> {}, sendListenerFailure::set)
            }
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
        when(mockFlightClient.getStream(any(Ticket.class), any())).thenThrow(
                    handlerException.set(e);
                }
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {
        CountDownLatch serverLatch = new CountDownLatch(1);
     * log4j's extended stack-trace renderer, which resolves every frame's class via {@code Class.forName};
     * A stream that never gets released bounds the close at the configured timeout rather than
                try {
        streamTransportService.registerRequestHandler(action, ThreadPool.Names.SAME, LargeTestRequest::new, (request, channel, task) -> {
     * resource-exhaustion failure RESOURCE_EXHAUSTED on the data node, and the coordinator's
                    TestResponse response1 = new TestResponse("Response 1");
        when(stream.next()).thenReturn(true);
        private final String logger;
        streamTransportService.registerRequestHandler(
        channel.addCloseListener(ActionListener.wrap(r -> closeLatch.countDown(), e -> closeLatch.countDown()));
                try {
            }, handlerException));
import org.opensearch.common.collect.Tuple;
    public void testLargeRequest() throws Exception {
                    } catch (Exception e) {}
                    handlerLatch.countDown();
            public String executor() {
    private interface StreamConsumer {
                        while (streamResponse.nextResponse() != null) {
                } catch (IOException e) {}
        assertEquals("Cannot set message listener twice", exception.getMessage());
     * server handler must arrive at the client as a StreamException carrying the SAME error code and
            @Override
        }
        assertEquals(StreamErrorCode.INTERNAL, ((StreamException) exception).getErrorCode());
                    "no throwable may be attached at any level, but ["
            (request, channel, task) -> {
        Header header = mock(Header.class);
        testChannel.sendMessage(-1, message, ActionListener.wrap(response -> latch.countDown(), ex -> {
        sendThread.start();
            @Override
    private FlightClientChannel createChannel(FlightClient flightClient, HeaderContext context, FlightTransportConfig config) {
                return new TestResponse(in);
                    channel.sendResponseBatch(response1);
        };
        // Cancellation is issued up front, before the wait, to unblock a parked consumer.
        assertTrue(connectLatch.await(1, TimeUnit.SECONDS));
        AtomicBoolean fired = new AtomicBoolean(false);
        });
        assertEquals("test-profile", channel.getProfile());
    public void testSetMessageListenerTwice() {
        channel.removeCloseListener(removed);
            @Override
        CountDownLatch latch = new CountDownLatch(1);
            @Override
        assertNull(handlerException.get());
        return new HeaderContext() {
            exception.set(ex);
                )
        flightTransport.setMessageListener(testListener);
        }
        CountDownLatch consumerHoldingStream = new CountDownLatch(1);
            closed.set(true);
        assertEquals(StreamErrorCode.UNAVAILABLE, ((StreamException) sendListenerFailure.get()).getErrorCode());
        StreamException se = (StreamException) ExceptionsHelper.unwrapCausesAndSuppressed(e, t -> t instanceof StreamException)
    public void setUp() throws Exception {
            }
     * A null header must fail the stream and stop, not fall through. {@code handleStreamException} does not
                    }
            }
import org.opensearch.transport.stream.StreamErrorCode;
            this.largeData = data;
    }
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
            }
            "Server should receive StreamException with CANCELLED code when calling sendResponseBatch after cancellation",
            @Override
        };
        @Override
                public void handleException(TransportException exp) {
                    while ((streamResponse.nextResponse()) != null) {
        };
                try {
     * A stream failure must be reported without ever handing the throwable to log4j, at any level.
    @Override
    public void testStreamResponseProcessingWithValidHandler() throws InterruptedException, IOException {
                    handlerException.set(e);
        );
                return new TestResponse(in);
     */
            connected.set(true);
            this.largeData = in.readString();
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {
        channel = createChannel(mockFlightClient, stubHeaderContext(), config);
                    return new TestResponse(in);
        CountDownLatch handlerLatch = new CountDownLatch(1);
    }
            @Override
        CountDownLatch lateLatch = new CountDownLatch(1);
        AtomicInteger responseCount = new AtomicInteger(0);
     * so it returns null whenever the middleware never stored one (for example a call that closed before
     */
                @Override
        channel.addCloseListener(late);
                    }
     * thread — to release it, so the FlightClient's allocator is not closed while buffers are out.
        } finally {
import org.opensearch.transport.TransportResponseHandler;
     * A close reaching the channel from inside a consumer callback must not wait for that
        private final AtomicReference<LogEvent> offender = new AtomicReference<>();
                        responseCount.incrementAndGet();
     * throw, so continuing would dereference the null header and replace the real failure with an NPE
            connection,
     *
                return remoteNode;
        }
        assertFalse("close must return once the stream is released", closer.isAlive());
        );
                    // Add small delay to ensure batch is processed before error
        streamTransportService.registerRequestHandler(
        assertEquals(1, responseCount.get());
        // test. Under SAME the task runs inside the CompletableFuture callback, which swallows it.
    public void testStreamErrorCodeSurvivesWire() throws InterruptedException {
 * compatible open source license.
                    requestId,
import org.opensearch.common.unit.TimeValue;
        assertTrue("consumer must finish", consumerDone.await(3 * TIMEOUT_SEC, TimeUnit.SECONDS));
                } catch (Exception e) {
    }
    private StreamTransportResponseHandler<TestResponse> streamingHandler(
                    try {
            public TestResponse read(StreamInput in) throws IOException {
            @Override
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        return streamingHandler(executor, consumer, null);
                    channel.sendResponseBatch(response1);
        }));
