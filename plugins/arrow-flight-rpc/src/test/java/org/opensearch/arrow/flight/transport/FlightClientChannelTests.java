        CountDownLatch handlerRemoved = new CountDownLatch(1);  
                } finally {  
            sendStreamRequest(streamingHandler(ThreadPool.Names.SAME, streamResponse -> {
            }
                    handlerLatch.countDown();
    public void testStreamResponseProcessingWithValidHandler() throws InterruptedException, IOException {
        }  
            exception.set(ex);
                try {
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),  
import org.opensearch.transport.TransportMessageListener;
     * blocking shutdown indefinitely. Here the stream is registered but stuck in getStream(), so  
        }, "flight-send-close-race-test");
        Header header = mock(Header.class);  
                handlerLatch.countDown();  
            }
    }
                handlerLatch.countDown();
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();  
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);  
     * <p>TRACE is enabled here on purpose. The verbose branch is the one an operator reaches for while  
            }
     * there is nothing to cancel and nothing that can report itself released.
                    received.set(e);
        flightTransport.setMessageListener(listener1);  
    public void testThreadPoolExhaustion() throws InterruptedException {
        testChannel.close();
        streamTransportService.sendRequest(remoteNode, action, new TestRequest(), options, responseHandler);
            public String executor() {
     * the resulting native frame cannot be unmounted, so a contended classloader lock pins the carrier
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.core.common.io.stream.StreamOutput;
        AtomicInteger responseCount = new AtomicInteger(0);
        CountDownLatch handlerLatch = new CountDownLatch(1);
import org.opensearch.core.common.bytes.BytesArray;
        CountDownLatch latch = new CountDownLatch(1);
        channel.close();  
            }
                handlerFailure.set(exp);
        };
            }
                } catch (IOException ex) {}
            @Override
            boundAddress,
            "Server should receive StreamException with CANCELLED code when calling sendResponseBatch after cancellation",
import org.opensearch.test.MockLogAppender;
            "Expected TransportException but got: " + handlerException.get().getClass(),
            @Override
    private void sendStreamRequest(TransportResponseHandler<TestResponse> handler) {  
                    Thread.sleep(4000); // Allow client to process and cancel
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
        streamTransportService.registerRequestHandler(
import static org.mockito.Mockito.timeout;
            }
    public void testFrameworkLevelStreamCreationError() throws InterruptedException {
            public TestResponse read(StreamInput in) throws IOException {  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/18938")
     * server handler must arrive at the client as a StreamException carrying the SAME error code and  
                }  
        TestRequest testRequest = new TestRequest();  
            }  
    /**  
        assertEquals(1, responseCount.get());  
            channel.close();  
            @Override  
    }
        assertEquals(StreamErrorCode.CANCELLED, ((StreamException) serverException.get()).getErrorCode());
    /**
        }));  
            super.writeTo(out);
                try {
            @SuppressWarnings("rawtypes")
                    }
                    handlerLatch.countDown();
    }
            public boolean isClosed() {  
     *                      handler exception fails the test.
    public void testStreamResponseProcessingWithHandlerException() throws InterruptedException {  
                sendThreadFailure.set(t);
                }
            @Override
import org.opensearch.transport.TransportRequestOptions;
    /**  
                    } catch (IOException ignored) {}  
    public void testStreamResponseWithEarlyCancellation() throws InterruptedException {
        }, exception -> connectLatch.countDown()));  
                fail("stream response should not be dispatched after channel close");  
            ThreadPool.Names.SAME,
        };  
            flightClient,
            connection,  
        channel.removeCloseListener(removed);
            public TestResponse read(StreamInput in) throws IOException {
            new TestRequest(),
        AtomicReference<Exception> handlerException = new AtomicReference<>();  
                    channel.sendResponse(new RuntimeException("Simulated handler exception"));
     * debugging this very failure, so it is the branch that most needs to be safe: turning it on must not be
                received.set(exp);
    public void testStreamFailureIsLoggedWithoutAThrowable() throws Exception {
        channel = createChannel(mockFlightClient);
     */  
                }
        TransportResponseHandler<TestResponse> responseHandler = new TransportResponseHandler<>() {
                );
            public String executor() {  
        // A long timeout: if the wait ever expires, that is a failure rather than a slow pass.
        @Override  
        String action = "internal:test/interim-batch-error";  
            public void addCloseListener(ActionListener<Void> listener) {}  
            new StreamTransportResponseHandler<TestResponse>() {  
        assertTrue(closeLatch.await(1, TimeUnit.SECONDS));
            }, handlerException));  
    /** Consumer body for {@link #streamingHandler}, allowed to block and to throw. */
            long start = System.nanoTime();
        channel.addConnectListener(ActionListener.wrap(r -> connectLatch.countDown(), e -> connectLatch.countDown()));  
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));  
import org.apache.arrow.flight.Ticket;
                try {  
import org.opensearch.transport.Transport;  
                } catch (Exception e) {
                    TestResponse response2 = new TestResponse("Response 2");  
        return new FlightClientChannel(  
        return new HeaderContext() {  
        void accept(StreamTransportResponse<TestResponse> streamResponse) throws Exception;
            @Override
    /**
     */
            }
            public void onResponseSent(long requestId, String action, Exception error) {
            }
    /** A header context that answers any correlation id, so a mocked client can drive dispatch. */
                handlerLatch.countDown();
            flightTransport.getResponseHandlers(),
                handlerException.set(exp);
            }
        FlightStream stream = mock(FlightStream.class);
                return new TestResponse(in);  
        channel.addCloseListener(ActionListener.wrap(response -> {  
import org.apache.logging.log4j.core.LogEvent;
                } finally {  
     * service so the channel resolves it from its response handlers as it would in production.
                    "*Exception while handling stream response*\n\tat *"
                return ThreadPool.Names.SAME;
                }
            }
        return streamingHandler(executor, consumer, null);
    }  
        public void writeTo(StreamOutput out) throws IOException {
                    "stream failure reported with its cause",
     * the lock holder sits unmounted and unschedulable, and the node stops making progress while still  
                channel.sendMessage(requestId, new BytesArray("test message"), ActionListener.wrap(r -> {}, e -> {  
            // is expected here and must not fail the test.
        if (channel != null) {
     * resource-exhaustion failure RESOURCE_EXHAUSTED on the data node, and the coordinator's
                    while ((response = streamResponse.nextResponse()) != null) {  
        }));
            long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        AtomicReference<TransportException> handlerFailure = new AtomicReference<>();  
        channel = createChannel(mockFlightClient, stubHeaderContext(), config);
            @Override
            public boolean isClosed() {
                        + event.getLevel()
        assertTrue("close must wait for the consumer to release the stream", closer.isAlive());  
                try {
        String action = "internal:test/stream/errorcode/" + code.name();  
import java.io.IOException;
        BiConsumer<Void, ? super Exception> late = (v, e) -> fired.set(true);  
            }  
                return new TestResponse(in);  
import org.junit.After;  
            this.largeData = in.readString();  
        @Override
     * raised inside the dispatch task — where nothing reports it to the handler.  
            }  
            @Override  
                    handlerException.set(e);
            @Override
import static org.mockito.Mockito.times;
 *
        channel = createChannel(mockFlightClient, stubHeaderContext(), config);
            streamResponse.close();
            channel.close();
                );  
    }
            "test-profile",
        assertNull(error.get());  
        assertEquals(1, responseCount.get());  
                return ThreadPool.Names.SAME;
    private FlightClient mockFlightClient;
            @Override
        }));  
            }
        AtomicBoolean secondBatchCalled = new AtomicBoolean(false);  
            }  
            return stream;
            }  
    public void tearDown() throws Exception {
        };
    public void testAddRemovableCloseListenerAfterCloseFiresImmediately() {
        assertNotNull(handlerException.get());  
    private FlightClientChannel channel;  
            @Override
        CountDownLatch releaseGetStream = new CountDownLatch(1);
                throw new AssertionError(  
                        channel.sendResponse(e);
     */  
        verify(stream, times(1)).close();
                }
        assertNotNull(exception.get());  
    private HeaderContext stubHeaderContext() {
            .orElse(null);
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {  
        when(mockFlightClient.getStream(any(Ticket.class), any())).thenReturn(stream);  
            public TestResponse read(StreamInput in) throws IOException {
        final long timeoutMillis = TimeUnit.SECONDS.toMillis(10);
     */
            public void handleException(TransportException exp) {  
        // Allow for race condition - response count could be 0 or 1 depending on timing
            public TestResponse read(StreamInput in) throws IOException {
        private final String logger;  
                    TestResponse response;
        channel = createChannel(mockFlightClient, stubHeaderContext(), config);
                }
        CountDownLatch serverLatch = new CountDownLatch(1);
        channel.addConnectListener(ActionListener.wrap(r -> connectLatch.countDown(), e -> connectLatch.countDown()));
                    serverLatch.countDown();
            ThreadPool.Names.SAME,
            @Override  
    // ── stream failure reporting ───────────────────────────────────────────────
        channel.addConnectListener(ActionListener.wrap(r -> lateLatch.countDown(), e -> lateLatch.countDown()));
        LargeTestRequest(StreamInput in) throws IOException {
            public String executor() {  
                    TestResponse response1 = new TestResponse("Response 1");
            public void onResponseSent(long requestId, String action, TransportResponse response) {
        final long timeoutMillis = 300;
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(connected.get());
            (request, channel, task) -> {  
    }
import org.opensearch.transport.stream.StreamTransportResponse;
                } catch (Exception e) {
        assertEquals("Header is null", exception.getMessage());
                return new TestResponse(in);  
                }
        assertEquals("FlightClientChannel is closed", exception.get().getMessage());
                return header;  
            long start = System.nanoTime();
        String action = "internal:test/stream/exception";
                return new TestResponse(in);
        return new StreamTransportResponseHandler<>() {
        assertEquals(StreamErrorCode.INTERNAL, ((StreamException) exception).getErrorCode());
            exception.set(ex);  
     * A stream that never gets released bounds the close at the configured timeout rather than
            consumerHoldingStream.countDown();
        private final AtomicReference<LogEvent> offender = new AtomicReference<>();
                handlerException.set(exp);
            remoteNode,
            handler
        mockFlightClient = mock(FlightClient.class);
            sendStreamRequest(streamingHandler(ThreadPool.Names.GENERIC, streamResponse -> streamResponse.close(), handlerException));
                return ThreadPool.Names.SAME;
                }
import org.apache.arrow.flight.FlightClient;
        releaseConsumer.countDown();
            streamResponse.close();  
                    handlerException.set(e);
                } catch (Exception e) {
        assertEquals("error code must survive the wire", code, se.getErrorCode());
                        streamResponse.cancel("Client early cancellation", null);
            threadPool,
            namedWriteableRegistry,
import static org.mockito.Mockito.mock;  
        Transport.Connection connection = new Transport.Connection() {
        assertNull(handlerException.get());
                    channel.sendResponseBatch(response1);  
        AtomicInteger responseCount = new AtomicInteger(0);  
        );
     * <p>These paths run on the per-stream prefetch virtual thread. OpenSearch's JSON layout always applies
                    channel.completeStream();
                try {  
                    channel.sendResponseBatch(response1);  
                try {
                    } catch (Exception e) {}  
            }  
        assertTrue(channel.isOpen());
        flightTransport.setMessageListener(testListener);  
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
                } catch (Exception e) {
            // The channel closes while the stream is still opening, so the handler is failed; that  
            channel.close();
     *
            public void addCloseListener(ActionListener<Void> listener) {}
        CountDownLatch latch = new CountDownLatch(1);  
                    latch.countDown();
                public void handleException(TransportException exp) {  
        assertFalse("send thread did not finish", sendThread.isAlive());
            @Override  
                } catch (Exception e) {
    // ── channel close vs. active streams ───────────────────────────────────────
            sendThread.join(TimeUnit.SECONDS.toMillis(5));
            // The cause must still be identifiable from the message alone, since the throwable is gone.
 */  
                public String executor() {  
            assertTrue("send must remove its response handler before channel close", handlerRemoved.await(5, TimeUnit.SECONDS));
        assertEquals(4, messageSentCount.get()); // completeStream is counted too  
            connectLatch.countDown();
            action,  
        assertTrue(sendListenerFailure.get() instanceof StreamException);  
        CountDownLatch connectLatch = new CountDownLatch(1);
            }
        streamTransportService.registerRequestHandler(
                    throw e;
            new TransportMessageListener() {  
            }
        }
                }  
                    try {
                public TestResponse read(StreamInput in) throws IOException {
import org.opensearch.transport.TransportException;
                channel.sendMessage(  
        streamTransportService.registerRequestHandler(action, ThreadPool.Names.SAME, LargeTestRequest::new, (request, channel, task) -> {  
            @Override
        }
        TestRequest testRequest = new TestRequest();  
        CountDownLatch latch = new CountDownLatch(1);  
                    } catch (Exception e) {}  
        when(exhaustedThreadPool.executor(any())).thenThrow(new RejectedExecutionException("Thread pool exhausted"));
    public void testCloseWaitsForStreamHeldByAnotherThread() throws Exception {
        AtomicReference<Exception> sendListenerFailure = new AtomicReference<>();
        closer.start();
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {  
        assertTrue("listener added after close must fire immediately", fired.get());
    public void testNullHeaderFailsStreamWithoutDereferencingIt() throws Exception {  
                    Thread.sleep(1000);
                    }
     * so it returns null whenever the middleware never stored one (for example a call that closed before  
            ThreadPool.Names.SAME,
            }
     * consumer's own stream: it can only be released after the callback returns, which cannot
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(FlightClientChannel.class))) {
            if (event != null) {
                    }  
import org.opensearch.ExceptionsHelper;
            @Override
            serverException.get()  
        CountDownLatch handlerLatch = new CountDownLatch(1);
                    while ((streamResponse.nextResponse()) != null) {
                    TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
            public void handleException(TransportException exp) {  
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        closer.join(TimeUnit.SECONDS.toMillis(TIMEOUT_SEC));  
                        // Cancel after first response
            in -> new TestRequest(in),
            }
            testRequest,
                    error.set(exp);
        assertEquals("Simulated handler exception", handlerException.get().getMessage());
            @Override
import org.apache.arrow.flight.CallStatus;
                return ThreadPool.Names.SAME;
     * Close must cancel an active stream and then wait for its consumer — running on another
        assertEquals(StreamErrorCode.UNAVAILABLE, ((StreamException) handlerFailure.get()).getErrorCode());
                latch.countDown();  
    }  
        Thread sendThread = new Thread(() -> {
                    channel.sendResponseBatch(response2);  
            );
        when(stream.next()).thenReturn(true);
        Exception e = received.get();
    private StreamTransportResponseHandler<TestResponse> streamingHandler(String executor, StreamConsumer consumer) {
                throw new AssertionError("consumer must not be invoked after an open failure");
                        responseCount.incrementAndGet();
            }  
            }  
                    throw new AssertionError("send failed", e);
            @Override
        };
import org.opensearch.transport.Header;
            @Override
        };  
     */
            @Override
                    FlightClientChannel.class.getCanonicalName(),  
            public void close() {}
            @Override
                    "stack trace rendered as text at TRACE",
                    }
            closeElapsedMillis.set(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));  
    }  
        Transport.Connection connection = new Transport.Connection() {
    public void testRemovableCloseListenerCanBeGivenBack() {
        streamTransportService.registerRequestHandler(
            },
            closeElapsedMillis.get(),
    }
        AtomicBoolean fired = new AtomicBoolean(false);
        config.setStreamCloseTimeout(TimeValue.timeValueMillis(timeoutMillis));  
                    } catch (IOException ioException) {
        };
        CountDownLatch connectLatch = new CountDownLatch(2);
        AtomicReference<Exception> handlerException = new AtomicReference<>();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertTrue(exception.get() instanceof TransportException);
    }  
                    TestResponse response1 = new TestResponse("Response 1");
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
            in -> new TestRequest(in),
    static class LargeTestRequest extends TestRequest {  
                    if (continueSend.await(5, TimeUnit.SECONDS) == false) {  
                handlerException.set(exp);
                    handlerLatch.countDown();
                    // Add small delay to ensure batch is processed before error
            public void handleException(TransportException exp) {
        assertErrorCodeRoundTrips(StreamErrorCode.RESOURCE_EXHAUSTED, "memory budget exhausted on shard");
                    channel.sendResponseBatch(response3);
        );
import org.opensearch.core.action.ActionListener;
        assertBusy(() -> assertNotNull("handler must be notified of the failure", handlerException.get()));
     * A null header must fail the stream and stop, not fall through. {@code handleStreamException} does not
                channel.sendResponseBatch(new TestResponse("OK"));
            remoteNode,
                        streamResponse.close();
                        assertEquals("Response " + (Integer.valueOf(responseCount.get()) + 1), response.getData());
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
    }
                    responseHandler
                    while ((streamResponse.nextResponse()) != null) {
    /**
import static org.mockito.ArgumentMatchers.isNull;
            latch.countDown();
            in -> new TestRequest(in),
                exceptionSink.set(exp);
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {  
                } finally {  
            @Override  
            @Override
    @Override  
            public void close() {}
        };
            channel.close();  
        assertNull("send thread failed", sendThreadFailure.get());  
                        latch.countDown();
        super.setUp();
        assertTrue(latch.await(1, TimeUnit.SECONDS));
        StreamConsumer consumer,
     * exception type, so the code is the only signal that crosses.
        BiConsumer<Void, ? super Exception> removed = (v, e) -> fail("a removed listener must not fire");  
            this.logger = logger;
            public DiscoveryNode getNode() {  
                public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        assertFalse(channel.isOpen());
import static org.mockito.Mockito.verify;  
                    try {
        );  
                handlerLatch.countDown();
                handlerNotifications.incrementAndGet();  
            in -> new TestRequest(in),
            }  
            @Override  
            (request, channel, task) -> {  
                        streamResponse.close();  
                    channel.sendResponseBatch(response1);  
            appender.addExpectation(  
        CountDownLatch handlerLatch = new CountDownLatch(1);
            public String executor() {
        } finally {  
            @Override
    }
        FlightTransportConfig config = new FlightTransportConfig();
        assertThat(closeElapsedMillis.get(), greaterThanOrEqualTo(0L));
            public void handleException(TransportException exp) {  
import java.util.concurrent.atomic.AtomicInteger;
        assertEquals(3, responseCount.get());
            }
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {
        assertNull(handlerException.get());
        channel.close();
                    try {  
                    } catch (Exception e) {
        FlightTransportConfig config = new FlightTransportConfig();  
            }  
import java.util.concurrent.RejectedExecutionException;
    }  
        );
        assertNotNull(handlerException.get());
     * A close reaching the channel from inside a consumer callback must not wait for that
                    TestResponse response1 = new TestResponse("Response 1");
        AtomicReference<TransportException> handlerException = new AtomicReference<>();
                    } finally {  
        );
     * reporting healthy. The cause must therefore reach the log as text.
        assertEquals("Cannot set message listener twice", exception.getMessage());  
        TestRequest testRequest = new TestRequest();  
                    }  
        try {  
                    } catch (Exception e) {}  
                    try {
    private void assertErrorCodeRoundTrips(StreamErrorCode code, String message) throws InterruptedException {
            } catch (Exception e) {
                    }
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
        };
            boundAddress,
            }  
        assertNotNull("error must surface as a StreamException, got: " + e, se);  
        String action = "internal:test/early-cancel";  
        assertTrue(connectLatch.await(1, TimeUnit.SECONDS));
            @Override
        LargeTestRequest testRequest = new LargeTestRequest("X".repeat(20 * 1024));
        channel = createChannel(mockFlightClient);  
                    }  
                @Override
        TransportMessageListener listener1 = new TransportMessageListener() {
            statsCollector,  
            public String executor() {  
            (request, channel, task) -> {  
                }  
        }
                } catch (StreamException e) {
            public TestResponse read(StreamInput in) throws IOException {
            @Override
        channel.addCloseListener(removed);  
        }
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        CountDownLatch consumerDone = new CountDownLatch(1);
                return new TestResponse(in);
        TransportResponseHandler<TestResponse> responseHandler = new TransportResponseHandler<>() {
            }  
                )  
            }
            closed.set(true);
        when(stream.next()).thenReturn(true);
            statsCollector,  
                        error.set(e);
import org.opensearch.transport.TransportRequest;  
                try {
            public void onResponseReceived(long requestId, Transport.ResponseContext context) {  
        AtomicReference<Exception> handlerException = new AtomicReference<>();
                    } catch (IOException ignored) {}
            }
            }
        when(stream.next()).thenReturn(true);
        assertTrue("consumer must finish", consumerDone.await(TIMEOUT_SEC, TimeUnit.SECONDS));
            }
                return ThreadPool.Names.SAME;
            handlerException.get() instanceof TransportException
                        streamResponse.close();
        );
            }
                try {  
            appender.assertAllExpectationsMatched();  
 * compatible open source license.
            public void handleException(TransportException exp) {
        channel = createChannel(mockFlightClient, noHeader, new FlightTransportConfig());  
                    handlerException.set(e);
                    consumer.accept(streamResponse);  
     * {@code fromWireError} rebuilds a 429 from the code that survives here. Flight does not serialize the  
            "internal:test/channel-close",
                handlerLatch.countDown();
    public void testStreamErrorCodeSurvivesWire() throws InterruptedException {  
        assertNotNull(handlerException.get());  
        // The production path for a header that was never stored.
        when(mockFlightClient.getStream(any(Ticket.class), any())).thenReturn(stream);
        );
            @Override
        testChannel.sendMessage(-1, message, ActionListener.wrap(response -> latch.countDown(), ex -> {
            connected.set(true);
            public TestResponse read(StreamInput in) throws IOException {  
                } catch (RuntimeException e) {
        when(mockFlightClient.getStream(any(Ticket.class), any())).thenThrow(  
        channel = new FlightClientChannel(
                    if (e.getErrorCode() == StreamErrorCode.CANCELLED) {  
        FlightTransportConfig config = new FlightTransportConfig();
                        + event.getThrown(),  
                    Level.ERROR,
                latch.countDown();  
import java.util.Map;  
        AtomicReference<Exception> error = new AtomicReference<>();
        assertTrue("consumer must take the stream", consumerHoldingStream.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        when(mockFlightClient.getStream(any(Ticket.class), any())).thenReturn(stream);
        CountDownLatch closeLatch = new CountDownLatch(1);
import org.opensearch.core.common.io.stream.StreamInput;
                @Override
        TransportMessageListener blockingListener = new TransportMessageListener() {  
        CountDownLatch handlerLatch = new CountDownLatch(1);
            }  
            public void handleException(TransportException exp) {
        NoThrowableAttachedExpectation(String logger) {  
        LargeTestRequest(String data) {  
    }
            @Override
        sendThread.start();
    }
                } catch (Exception e) {  
            new FlightTransportConfig()
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {  
        AtomicReference<Throwable> sendThreadFailure = new AtomicReference<>();
                    "*Exception while handling stream response*connection reset*"
     */
            }  
                return remoteNode;
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        assertEquals(StreamErrorCode.UNAVAILABLE, ((StreamException) sendListenerFailure.get()).getErrorCode());
        config.setStreamCloseTimeout(TimeValue.timeValueMillis(timeoutMillis));
            @Override
            continueSend.countDown();
        assertTrue(connectLatch.await(1, TimeUnit.SECONDS));
            public TestResponse read(StreamInput in) throws IOException {
        config.setStreamCloseTimeout(TimeValue.timeValueSeconds(30));  
            public void handleResponse(TestResponse response) {  
        public void match(LogEvent event) {
            }
                } catch (Exception e) {
        StreamException se = (StreamException) ExceptionsHelper.unwrapCausesAndSuppressed(e, t -> t instanceof StreamException)
        verify(stream, timeout(TimeUnit.SECONDS.toMillis(TIMEOUT_SEC))).cancel(anyString(), isNull());  
                    TestResponse response3 = new TestResponse("Response 3");
     * message. This is the leg analytics relies on — {@code AnalyticsTransportErrors.toWireError} tags a
            (request, channel, task) -> {  
                try {
            @Override
    @Override
import org.opensearch.core.common.bytes.BytesReference;  
            }  
        }
        AtomicBoolean closed = new AtomicBoolean(false);
        CountDownLatch closeLatch = new CountDownLatch(2);
        assertTrue("message must survive the wire, got: " + se.getMessage(), se.getMessage() != null && se.getMessage().contains(message));
import static org.mockito.Mockito.when;
        }));
        streamTransportService.registerRequestHandler(
                } catch (IOException e) {}  
            if (event.getLoggerName().equals(logger) && event.getThrown() != null) {  
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
            @Override  
                try {
        CountDownLatch latch = new CountDownLatch(1);
    }
                    handlerException.set(e);
                return remoteNode;
                    secondBatchCalled.set(true);  
            @Override
        };  
        // Generous: a regression here shows up as the elapsed-time assertion below, not as a timeout.
    private interface StreamConsumer {  
        TransportException exception = handlerException.get();
        // test. Under SAME the task runs inside the CompletableFuture callback, which swallows it.
     */
                }
        assertNotNull(sendListenerFailure.get());
                );
                @Override
    }  
                } catch (Exception e) {
            }
            @Override
                channel.completeStream();  
import java.util.concurrent.atomic.AtomicReference;
                try {  
        when(header.getVersion()).thenReturn(Version.CURRENT);
        channel = createChannel(mockFlightClient);  
                    TestResponse response2 = new TestResponse("Response 2");
                    while (streamResponse.nextResponse() != null) {
                        streamResponse.close();
    /**
                return null;  
                    ActionListener.wrap(response -> {}, sendListenerFailure::set)  
                    return ThreadPool.Names.SAME;
                return ThreadPool.Names.SAME;
            @Override
                } catch (IOException ignored) {}
import org.opensearch.Version;  
import org.apache.logging.log4j.Level;
    private FlightClientChannel createChannel(FlightClient flightClient, HeaderContext context, FlightTransportConfig config) {
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> flightTransport.setMessageListener(listener2));
            public void handleResponse(TestResponse response) {
        CountDownLatch consumerDone = new CountDownLatch(1);  
                try {
                }
        });  
        AtomicInteger responseCount = new AtomicInteger(0);  
        when(mockFlightClient.getStream(any(Ticket.class), any())).thenAnswer(inv -> {
        channel.close();  
        AtomicBoolean connected = new AtomicBoolean(false);
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));  
        channel.addConnectListener(ActionListener.wrap(response -> {  
        TransportMessageListener listener2 = new TransportMessageListener() {  
                } finally {  
import java.util.function.BiConsumer;
            public TestResponse read(StreamInput in) throws IOException {
        channel = createChannel(mockFlightClient, stubHeaderContext(), new FlightTransportConfig());
        @Override
        }, handlerException));
            }
    }
        when(header.getHeaders()).thenReturn(new Tuple<>(Map.of(), Map.of()));
            @Override
            public String executor() {  
            }
        assertNotNull(channel.getChannelStats());
        assertTrue(serverLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        // Cancellation is issued up front, before the wait, to unblock a parked consumer.
        CountDownLatch handlerLatch = new CountDownLatch(1);
            LogEvent event = offender.get();
        TestRequest testRequest = new TestRequest();
            @Override
    }
        String action = "internal:test/stream";  
            @Override
            }
        AtomicReference<TransportException> handlerException = new AtomicReference<>();  
        CountDownLatch releaseConsumer = new CountDownLatch(1);
                    channel.completeStream();
            }  
            assertTrue("test must release the consumer", releaseConsumer.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        Thread closer = new Thread(channel::close, "channel-closer");  
        channel.sendMessage(-1, message, ActionListener.wrap(response -> latch.countDown(), ex -> {  
                    throw new AssertionError("stream consumer failed", e);
            @Override
    }
        channel.addCloseListener(ActionListener.wrap(r -> closeLatch.countDown(), e -> closeLatch.countDown()));  
            @Override  
        };
            public String executor() {
    }  
            context,
     */
                    FlightClientChannel.class.getCanonicalName(),  
                        // Handle IO exception  
            "close must skip the stream owned by the calling thread instead of waiting for it",  
            serverLocation,
        channel = createChannel(mockFlightClient);
                    handlerException.set(e);
        TestRequest testRequest = new TestRequest();
        AtomicReference<Exception> serverException = new AtomicReference<>();
                }  
        assertTrue("no error surfaced for " + code, latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
    public void testSetMessageListenerTwice() {  
    public void testCloseFromConsumerCallbackDoesNotWaitForItsOwnStream() throws Exception {
        );
            lessThan(timeoutMillis / 2)
    public void testCloseGivesUpAfterStreamCloseTimeout() throws Exception {  
        verify(stream, times(1)).close();  
 * SPDX-License-Identifier: Apache-2.0
        CountDownLatch consumerHoldingStream = new CountDownLatch(1);  
                return executor;
            headerContext,  
                    handlerLatch.countDown();
        try {
            }
        String action = "internal:test/large";
                    TestResponse response = streamResponse.nextResponse();
    public void testChannelLifecycle() throws InterruptedException {
        streamTransportService.registerRequestHandler(
        FlightStream stream = mock(FlightStream.class);  
            }  
                }
                        throw new IllegalStateException("timed out waiting to continue send");
    }
        closer.join(500);
import static org.mockito.ArgumentMatchers.any;  
        // A real executor, not SAME: that is where the bug is observable. The dispatch task runs on a  
        sendStreamRequest(streamingHandler(ThreadPool.Names.GENERIC, streamResponse -> {  
import static org.mockito.ArgumentMatchers.anyString;
    }
                return false;
            action,  
            remoteNode,  
        }
        channel.addCloseListener(kept);
        };
        TransportMessageListener testListener = new TransportMessageListener() {  
        assertEquals("test-profile", channel.getProfile());  
            config
                    handlerLatch.countDown();  
        AtomicReference<Exception> handlerException = new AtomicReference<>();  
            }  
                handlerLatch.countDown();
            in -> new TestRequest(in),
        };
        assertThat(
                handlerException.set(exp);
        // pool thread, so without the return the NPE escapes as an uncaught exception and fails the
                    while (streamResponse.nextResponse() != null) {
                } catch (Exception e) {  
        CountDownLatch lateLatch = new CountDownLatch(1);
    public void testStreamResponseWithCustomExecutor() throws InterruptedException, IOException {  
        );
     * A stream failure must be reported without ever handing the throwable to log4j, at any level.  
                try {
            }
    public void testSendMessageNotifiesHandlerWhenCloseRacesRegistration() throws Exception {
     * expectations all assert that something was seen; this asserts a property of everything that was.  
                        + " carried "
    /**  
            }
            @Override
        channel.addCloseListener(ActionListener.wrap(r -> closeLatch.countDown(), e -> closeLatch.countDown()));
        };
        assertNotNull(handlerFailure.get());
        AtomicReference<Exception> received = new AtomicReference<>();
            assertBusy(() -> assertNotNull("handler must be notified of the failure", handlerException.get()));
            action,  
        AtomicInteger messageSentCount = new AtomicInteger(0);
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options) {
import org.opensearch.transport.stream.StreamErrorCode;  
    @After
                        streamResponse.close();
                    "internal:test/channel-close-race",
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
     * <p>A null header is reachable in production: {@code HeaderContext.getHeader} is a plain map removal,
        channel = createChannel(mockFlightClient);
            @Override
            @Override
        );
            action,
            public DiscoveryNode getNode() {  
/*  
            public void handleException(TransportException exp) {  
            }  
                        + event.getMessage().getFormattedMessage()
                        responseCount.incrementAndGet();
        }  
                @Override
    public void testErrorInInterimBatchFromServer() throws InterruptedException, IOException {
                new MockLogAppender.SeenEventExpectation(
        FlightClientChannel testChannel = createChannel(mockFlightClient, exhaustedThreadPool);
                    return new TestResponse(in);  
                        responseCount.incrementAndGet();
                return new TestResponse(in);
            out.writeString(largeData);  
        AtomicReference<Exception> exception = new AtomicReference<>();  
        FlightStream stream = mock(FlightStream.class);  
        String action = "internal:test/custom-executor";  
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options) {
                    handlerException.set(e);
        };
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
        assertNotNull("expected an error for " + code, e);  
            threadPool,  
        assertTrue(latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        super.tearDown();
        assertTrue("expected a StreamException but got " + exception, exception instanceof StreamException);  
        FlightStream stream = mock(FlightStream.class);
            throw new AssertionError("consumer must not be invoked without a header");
                return new TestResponse(in);
                    new BytesArray("test message"),
            @Override
        sendStreamRequest(streamingHandler(ThreadPool.Names.GENERIC, streamResponse -> {  
            public TestResponse read(StreamInput in) throws IOException {  
                return ThreadPool.Names.SAME;  
                    channel.sendResponse(e);  
        AtomicReference<Exception> handlerException = new AtomicReference<>();  
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {  
                handlerRemoved.countDown();
            assertTrue("test must release getStream", releaseGetStream.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        CountDownLatch insideGetStream = new CountDownLatch(1);
     * thread — to release it, so the FlightClient's allocator is not closed while buffers are out.
                try {
                    if (response != null) {
                if (exceptionSink == null) {
    }  
                handlerException.set(exp);
import org.apache.arrow.flight.FlightStream;  
            }  
            @Override  
        assertNull(handlerException.get());
                    event.getThrown()
            public String executor() {  
            namedWriteableRegistry,
                        while (streamResponse.nextResponse() != null) {
                }  
            latch.countDown();
            mockFlightClient,  
                    TestResponse response1 = new TestResponse("Response 1");
            }
            @Override  
    ) {
        AtomicLong closeElapsedMillis = new AtomicLong(-1);
                    requestId,
        BytesReference message = new BytesArray("test message");
                return ThreadPool.Names.GENERIC;
                    while (streamResponse.nextResponse() != null) {
     */
                        serverException.set(e);
                        channel.sendResponse(e);
            (request, channel, task) -> {  
    }  
            Header getHeader(long correlationId) {
            }  
            }  
        assertTrue(closed.get());
import java.util.concurrent.TimeUnit;  
        assertEquals("response handler must be notified exactly once", 1, handlerNotifications.get());
    }  
            (request, channel, task) -> {
        channel.addCloseListener(late);
            @Override
                return new TestResponse(in);  
            @Override
        assertTrue(closeLatch.await(1, TimeUnit.SECONDS));  
        channel = createChannel(mockFlightClient);
                        // Handle IO exception
            super(in);
                    try {
            @Override  
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
                messageSentCount.incrementAndGet();  
                    channel.sendResponse(new StreamException(code, message));
            public String executor() {
                new MockLogAppender.SeenEventExpectation(
            action,  
                }  
                    connection,
                }
                    try {  
            public void handleResponse(TestResponse response) {
        AtomicInteger responseCount = new AtomicInteger(0);
    private final int TIMEOUT_SEC = 10;
 * The OpenSearch Contributors require contributions made to  
            }
    private static final class NoThrowableAttachedExpectation implements MockLogAppender.LoggingExpectation {
                    } catch (IOException ioException) {  
        AtomicReference<Exception> handlerException = new AtomicReference<>();
        streamTransportService.sendRequest(
import java.util.concurrent.atomic.AtomicBoolean;
        assertTrue("consumer must finish", consumerDone.await(3 * TIMEOUT_SEC, TimeUnit.SECONDS));  
        assertNotNull(
        }
     * instead of yielding it. With one such failure per stream, a mass reconnect can pin every carrier while
    public void setUp() throws Exception {  
                    Level.TRACE,
        AtomicInteger handlerNotifications = new AtomicInteger();
            this.largeData = data;
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {  
        assertTrue(secondBatchCalled.get());  
    public void testLargeRequest() throws Exception {
            consumerDone.countDown();
        CountDownLatch handlerLatch = new CountDownLatch(1);
                    } catch (IOException ioException) {}
            }
        String action = "internal:test/unregistered-action";  
                    }  
            insideGetStream.countDown();  
            @Override
            try {
            flightTransport.getResponseHandlers(),
        AtomicInteger fires = new AtomicInteger(0);
            blockingListener,
                        }
                        streamResponse.close();
        // Don't register any handler for this action - this will cause framework-level error
    private StreamTransportResponseHandler<TestResponse> streamingHandler(  
import org.opensearch.cluster.node.DiscoveryNode;
    /** A removable close listener registered after close() fires immediately. */
            Header getHeader(long correlationId) {
                    latch.countDown();  
        AtomicReference<TransportException> exceptionSink  
     *
        assertTrue(handlerFailure.get() instanceof StreamException);  
            ThreadPool.Names.SAME,
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {  
            public void handleException(TransportException exp) {
            }
            CallStatus.UNAVAILABLE.withDescription("connection reset").toRuntimeException()
            );
        ThreadPool exhaustedThreadPool = mock(ThreadPool.class);  
            // The stack trace is still available, just pre-rendered as text instead of as a throwable.
            serverLocation,
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
        };
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));  
            appender.addExpectation(new NoThrowableAttachedExpectation(FlightClientChannel.class.getCanonicalName()));
                    try {
        assertEquals("the listener that was kept must fire exactly once", 1, fires.get());
     *
     * Fails if any event from {@code logger} carries a throwable, whatever its level. The framework's
                    new TestRequest(),  
        sendStreamRequest(streamingHandler(ThreadPool.Names.SAME, streamResponse -> {  
                    "no throwable may be attached at any level, but ["
import org.opensearch.common.unit.TimeValue;  
        HeaderContext noHeader = new HeaderContext() {  
                handlerLatch.countDown();
            in -> new TestRequest(in),
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
import java.util.concurrent.CountDownLatch;
        assertFalse(channel.isServerChannel());
                handlerException.set(exp);  
        when(stream.next()).thenReturn(true);  
        assertTrue(  
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
                try {  
            AtomicReference<TransportException> handlerException = new AtomicReference<>();
                } catch (InterruptedException e) {  
                    }
                    throw new AssertionError("unexpected handler exception", exp);  
    @TestLogging(value = "org.opensearch.arrow.flight.transport.FlightClientChannel:TRACE", reason = "verbose branch must be safe")
            @Override
                    try {  
    }
                    Thread.currentThread().interrupt();
     * its headers arrived).
                try {
            try {
                    handlerLatch.countDown();
            } catch (Throwable t) {
package org.opensearch.arrow.flight.transport;
     * throw, so continuing would dereference the null header and replace the real failure with an NPE
    }
     * Sends a stream request over {@link #channel}, registering the handler through the transport  
        }, exception -> closeLatch.countDown()));  
        };
            appender.addExpectation(  
        String executor,
        assertFalse("close must return once the stream is released", closer.isAlive());
        channel = createChannel(mockFlightClient);  
                return false;  
        channel.close();
import java.util.concurrent.atomic.AtomicLong;  
                    }
            @Override
                    }  
            @Override
import org.opensearch.common.collect.Tuple;
     * @param exceptionSink where an expected handler exception is recorded; when {@code null}, any  
    }  
            }
        AtomicReference<Exception> exception = new AtomicReference<>();
        }
        );
import org.opensearch.transport.TransportResponseHandler;
            @Override
    }  
        TestRequest testRequest = new TestRequest();  
                    try {
            ThreadPool.Names.SAME,  
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
import static org.hamcrest.Matchers.lessThan;
                    channel.sendResponseBatch(response2); // This should throw StreamException with CANCELLED code
import org.opensearch.core.transport.TransportResponse;  
    /** A removable close listener fires on close, and is no longer fired once it has been removed. */
    public void testSendMessageWhenClosed() throws InterruptedException {
            assertThat("close must give up at the timeout", elapsedMillis, lessThan(TimeUnit.SECONDS.toMillis(TIMEOUT_SEC)));
        BiConsumer<Void, ? super Exception> kept = (v, e) -> fires.incrementAndGet();
    }
            releaseGetStream.countDown();  
     * log4j's extended stack-trace renderer, which resolves every frame's class via {@code Class.forName};  
        Thread.sleep(100);  
                )  
        assertNotNull(exception.get());
                } finally {  
     * happen until the close returns. Waiting would burn the whole timeout to no effect.  
        assertErrorCodeRoundTrips(StreamErrorCode.UNAVAILABLE, "Network closed for unknown reason");
            consumerDone.countDown();
                    throw new RuntimeException("Interim batch error");  
            }
            }
            ThreadPool.Names.SAME,
        assertTrue(lateLatch.await(1, TimeUnit.SECONDS));  
        );
                } catch (Exception e) {
                    }  
                // messageSentCount.incrementAndGet();
     * Wire round-trip: a {@link StreamException} with a specific {@link StreamErrorCode} sent from the
import org.opensearch.test.junit.annotations.TestLogging;
            action,  
                return new TestResponse(in);  
                        + "] logged at "  
        private final String largeData;
        channel.close();  
            @Override
            assertTrue("stream must be registered and opening", insideGetStream.await(TIMEOUT_SEC, TimeUnit.SECONDS));  
    /**
            assertThat("close must wait for the stream", elapsedMillis, greaterThanOrEqualTo(timeoutMillis));  
        TransportResponseHandler<TestResponse> responseHandler = new TransportResponseHandler<TestResponse>() {
                }));
                offender.compareAndSet(null, event.toImmutable());
            }
            }
                }
        BytesReference message = new BytesArray("test message");
        channel.close();
                streamTransportService.sendRequest(  
        );  
        assertTrue("Response count should be 1, but was: " + responseCount.get(), responseCount.get() == 1);
        streamTransportService.registerRequestHandler(
        CountDownLatch continueSend = new CountDownLatch(1);
import org.opensearch.transport.StreamTransportResponseHandler;
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
                    throw new IllegalStateException("interrupted while waiting to continue send", e);
                        channel.sendResponse(e);  
            "test-profile",  
        } finally {
}
        streamTransportService.sendRequest(
                    channel.sendResponseBatch(response1);
        };
    public void testListenerManagement() throws InterruptedException {
            action,  
    /**
    }  
     * what arms the deadlock.
import org.opensearch.transport.stream.StreamException;
        public void assertMatched() {  
        assertTrue(latch.await(1, TimeUnit.SECONDS));
public class FlightClientChannelTests extends FlightTransportTestBase {  
            public void handleException(TransportException exp) {
        });  
        );  
            closeLatch.countDown();
                        responseCount.incrementAndGet();  
import org.apache.logging.log4j.LogManager;  
