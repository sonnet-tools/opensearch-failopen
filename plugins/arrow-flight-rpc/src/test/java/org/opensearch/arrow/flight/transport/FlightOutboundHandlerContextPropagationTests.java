                    try {
                    }
                            responseCount.incrementAndGet();
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {
 * this file be licensed under the Apache-2.0 license or a
        String action = "internal:test/context-propagation";
            public TestResponse read(StreamInput in) throws IOException {
                }
                        handlerException.set(e);
                }
            @Override
            }
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
            }
            } catch (Exception e) {
                channel.sendResponseBatch(new TestResponse("Response 1"));
                } catch (IOException ioException) {}
                    handlerLatch.countDown();
                // Verify context is set before sending batch
                // Verify context is still preserved after second batch
import java.util.concurrent.atomic.AtomicInteger;
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
        };
                    try {
            public void handleException(TransportException exp) {
        AtomicInteger responseCount = new AtomicInteger(0);
            public void handleException(TransportException exp) {
                return new TestResponse(in);
                // Set a header in the request handler's thread context
                    try {
                handlerLatch.countDown();
            public String executor() {
            }
    private static final int TIMEOUT_SEC = 10;
        CountDownLatch handlerLatch = new CountDownLatch(1);
            public void onResponseSent(long requestId, String action, TransportResponse response) {
            public TestResponse read(StreamInput in) throws IOException {
        AtomicReference<Exception> handlerException = new AtomicReference<>();
                assertEquals(CONTEXT_VALUE, threadPool.getThreadContext().getHeader(CONTEXT_HEADER));
            }
    private static final String CONTEXT_VALUE = "propagated-value";
            CONTEXT_VALUE,
                try {
    public void testContextHeaderPropagatedToResponseHeaders() throws InterruptedException {
            } catch (IOException ignored) {}
            @Override
import org.opensearch.transport.StreamTransportResponseHandler;
                messageSentCount.incrementAndGet();
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
import org.opensearch.core.common.io.stream.StreamInput;
                    }
                messageSentLatch.countDown();
                threadPool.getThreadContext().putHeader(CONTEXT_HEADER, CONTEXT_VALUE);
        });
        // 2 batches + 1 completeStream = 3 message sent events
            @Override
                return new TestResponse(in);
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
            @Override
 * when sending response batches, completing streams, and sending errors.
                assertEquals(CONTEXT_VALUE, threadPool.getThreadContext().getHeader(CONTEXT_HEADER));
                channel.completeStream();
    }
        };
    }
            @Override
    }
                        }
                try {
    public void testThreadContextPropagatedThroughErrorResponse() throws InterruptedException {
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
    private static final String CONTEXT_HEADER = "test-context-header";
                }
                        while (streamResponse.nextResponse() != null) {
        };
        );
        AtomicReference<Exception> handlerException = new AtomicReference<>();
                return ThreadPool.Names.SAME;
        });
            }
            }
            @Override
import org.opensearch.core.transport.TransportResponse;
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
                // Verify the caller's context is preserved after sendErrorResponse
        TransportMessageListener testListener = new TransportMessageListener() {
            @Override
        assertEquals(2, responseCount.get());
                } catch (IOException ignored) {}
                            responseCount.incrementAndGet();
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
                // Send an error
                channel.sendResponseBatch(new TestResponse("batch-2"));
            }
                        handlerException.set(e);
 * compatible open source license.
import java.util.concurrent.CountDownLatch;
import org.opensearch.transport.stream.StreamTransportResponse;
                threadPool.getThreadContext().putHeader(CONTEXT_HEADER, CONTEXT_VALUE);
            }
        AtomicInteger messageSentCount = new AtomicInteger(0);
                try (streamResponse) {
                return ThreadPool.Names.SAME;
                capturedHeaderOnServer.set(threadPool.getThreadContext().getHeader(CONTEXT_HEADER));
        TestRequest testRequest = new TestRequest();
        assertEquals(3, messageSentCount.get());
                handlerLatch.countDown();
 * The OpenSearch Contributors require contributions made to
            }
            }
public class FlightOutboundHandlerContextPropagationTests extends FlightTransportTestBase {
            public String executor() {
import org.opensearch.transport.TransportMessageListener;
                    } catch (Exception e) {
        CountDownLatch handlerLatch = new CountDownLatch(1);
            try {
                } catch (Exception ignored) {} finally {
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {
                } catch (Exception ignored) {} finally {
        assertNull(handlerException.get());
            } catch (Exception e) {
                return ThreadPool.Names.SAME;
        String action = "internal:test/context-header-in-response";
            }
                        handlerException.set(e);
            }
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
}
        flightTransport.setMessageListener(testListener);
import org.opensearch.transport.TransportException;
            }
 */
                    }
                channel.sendResponseBatch(new TestResponse("Response 2"));
            "Thread context header should be preserved on the server handler thread after sendResponseBatch",
                    channel.sendResponse(e);
        assertEquals(
                    } catch (Exception e) {
 * Tests that thread context headers are properly propagated through the Flight transport layer
 */
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(CONTEXT_VALUE, threadPool.getThreadContext().getHeader(CONTEXT_HEADER));
        TestRequest testRequest = new TestRequest();
                    } catch (Exception e) {
            public String executor() {
        streamTransportService.registerRequestHandler(action, ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
            @Override
        });
                channel.completeStream();
                handlerException.set(exp);
            capturedHeaderOnServer.get()
package org.opensearch.arrow.flight.transport;
        TestRequest testRequest = new TestRequest();
                capturedHeaderOnServer.set(threadPool.getThreadContext().getHeader(CONTEXT_HEADER));
        streamTransportService.registerRequestHandler(action, ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
                // Verify the caller's context is preserved after sendResponseBatch
        AtomicReference<String> capturedHeaderOnServer = new AtomicReference<>();
            @Override
                // Set a header in the request handler's thread context
            @Override
            try {
 *
            public TestResponse read(StreamInput in) throws IOException {
                    handlerLatch.countDown();
import org.opensearch.threadpool.ThreadPool;
        AtomicReference<String> capturedHeaderOnServer = new AtomicReference<>();
            CONTEXT_VALUE,
        );
                        }
                return new TestResponse(in);
                    channel.sendResponse(e);
            }
            }
        String action = "internal:test/context-error-propagation";
                try (streamResponse) {
import java.io.IOException;
            @Override
        // Wait for all async onResponseSent callbacks to complete before asserting count
            "Thread context header should be preserved on the server handler thread after sendErrorResponse",
                try (streamResponse) {
        };
            capturedHeaderOnServer.get()
        streamTransportService.registerRequestHandler(action, ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
                handlerException.set(exp);
                channel.sendResponseBatch(new TestResponse("batch-1"));
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
                        while (streamResponse.nextResponse() != null) {
                    handlerLatch.countDown();
        assertNotNull(handlerException.get());
    public void testThreadContextPropagatedThroughStreamResponseBatch() throws InterruptedException {
                handlerLatch.countDown();
            @Override
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
                        }
/*
            public void handleException(TransportException exp) {
import org.opensearch.transport.TransportRequestOptions;
        assertEquals(2, responseCount.get());
        assertEquals(
        assertTrue("All message sent events should complete", messageSentLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
                } catch (Exception ignored) {} finally {
            try {
        CountDownLatch messageSentLatch = new CountDownLatch(3);
/**
                channel.sendResponse(new RuntimeException("Intentional test error"));
        AtomicInteger responseCount = new AtomicInteger(0);
        AtomicReference<Exception> handlerException = new AtomicReference<>();
                        while (streamResponse.nextResponse() != null) {
        CountDownLatch handlerLatch = new CountDownLatch(1);
            @Override
import java.util.concurrent.atomic.AtomicReference;
        assertNull("No exception expected but got: " + handlerException.get(), handlerException.get());
                // Verify context is still preserved after completeStream
import java.util.concurrent.TimeUnit;
                handlerException.set(exp);
