 * SPDX-License-Identifier: Apache-2.0
            public String executor() {
 * Tests that thread context headers are properly propagated through the Flight transport layer
                return new TestResponse(in);
            @Override
        CountDownLatch handlerLatch = new CountDownLatch(1);
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
                    try {
            capturedHeaderOnServer.get()
                    channel.sendResponse(e);
            try {
            CONTEXT_VALUE,
        });  
            @Override  
import org.opensearch.transport.stream.StreamTransportResponse;
        assertEquals(2, responseCount.get());  
            public void onResponseSent(long requestId, String action, TransportResponse response) {  
                try {
        AtomicInteger responseCount = new AtomicInteger(0);  
                    handlerLatch.countDown();  
        CountDownLatch handlerLatch = new CountDownLatch(1);
                    }  
        String action = "internal:test/context-header-in-response";
                handlerException.set(exp);  
                    } catch (Exception e) {
        AtomicReference<String> capturedHeaderOnServer = new AtomicReference<>();  
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);  
        };  
}  
        );
    public void testThreadContextPropagatedThroughErrorResponse() throws InterruptedException {
                } catch (Exception ignored) {} finally {
                    }
            public String executor() {
                } catch (IOException ignored) {}
            @Override
        CountDownLatch handlerLatch = new CountDownLatch(1);  
                handlerLatch.countDown();  
            }
            try {  
        AtomicReference<Exception> handlerException = new AtomicReference<>();
        assertTrue("All message sent events should complete", messageSentLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));  
                        while (streamResponse.nextResponse() != null) {
            }
 * The OpenSearch Contributors require contributions made to  
        });
            }
        assertEquals(  
        assertNotNull(handlerException.get());
                    } catch (Exception e) {
        flightTransport.setMessageListener(testListener);
            public TestResponse read(StreamInput in) throws IOException {  
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
            }
        streamTransportService.registerRequestHandler(action, ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {  
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
    }
            }
                    }  
            @Override  
            @Override  
            CONTEXT_VALUE,  
    }
                } catch (Exception ignored) {} finally {
        assertEquals(3, messageSentCount.get());
            public String executor() {
                }  
        streamTransportService.registerRequestHandler(action, ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
            }  
                    try {
            }
                            responseCount.incrementAndGet();
                        }
        // 2 batches + 1 completeStream = 3 message sent events
                return ThreadPool.Names.SAME;
        assertNull(handlerException.get());
            @Override
            @Override
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
/**
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();  
            public void handleException(TransportException exp) {
            } catch (Exception e) {
 */
                capturedHeaderOnServer.set(threadPool.getThreadContext().getHeader(CONTEXT_HEADER));
        TransportMessageListener testListener = new TransportMessageListener() {
                    try {  
        AtomicReference<Exception> handlerException = new AtomicReference<>();  
                return ThreadPool.Names.SAME;  
                channel.sendResponseBatch(new TestResponse("Response 1"));
            } catch (Exception e) {
                handlerException.set(exp);
    private static final String CONTEXT_VALUE = "propagated-value";  
                handlerLatch.countDown();  
            try {
                try {  
 */  
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {
            }  
import java.util.concurrent.atomic.AtomicInteger;
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {  
                    handlerLatch.countDown();
            @Override  
                        while (streamResponse.nextResponse() != null) {
        assertEquals(2, responseCount.get());
            }  
                    channel.sendResponse(e);  
            @Override
    public void testThreadContextPropagatedThroughStreamResponseBatch() throws InterruptedException {
            @Override  
            }
        assertNull("No exception expected but got: " + handlerException.get(), handlerException.get());  
                handlerException.set(exp);
                channel.sendResponseBatch(new TestResponse("batch-2"));  
            }
        AtomicReference<Exception> handlerException = new AtomicReference<>();
package org.opensearch.arrow.flight.transport;
        streamTransportService.registerRequestHandler(action, ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {  
                        }  
import org.opensearch.core.transport.TransportResponse;
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
 * this file be licensed under the Apache-2.0 license or a
                        while (streamResponse.nextResponse() != null) {
                threadPool.getThreadContext().putHeader(CONTEXT_HEADER, CONTEXT_VALUE);
                // Verify context is still preserved after completeStream
                channel.completeStream();
        AtomicReference<String> capturedHeaderOnServer = new AtomicReference<>();
                messageSentCount.incrementAndGet();
                        }  
            "Thread context header should be preserved on the server handler thread after sendErrorResponse",
                // Set a header in the request handler's thread context
                return new TestResponse(in);
                messageSentLatch.countDown();
            @Override  
        String action = "internal:test/context-propagation";  
        };  
        String action = "internal:test/context-error-propagation";  
                assertEquals(CONTEXT_VALUE, threadPool.getThreadContext().getHeader(CONTEXT_HEADER));  
            @Override
 *
                channel.completeStream();  
import org.opensearch.core.common.io.stream.StreamInput;
                capturedHeaderOnServer.set(threadPool.getThreadContext().getHeader(CONTEXT_HEADER));
        assertEquals(
                assertEquals(CONTEXT_VALUE, threadPool.getThreadContext().getHeader(CONTEXT_HEADER));  
        TestRequest testRequest = new TestRequest();  
                return ThreadPool.Names.SAME;
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<TestResponse>() {  
import org.opensearch.transport.TransportMessageListener;  
            capturedHeaderOnServer.get()  
                } catch (IOException ioException) {}
                        handlerException.set(e);
                // Verify context is set before sending batch
                    handlerLatch.countDown();
            }
            public TestResponse read(StreamInput in) throws IOException {
                handlerLatch.countDown();
            "Thread context header should be preserved on the server handler thread after sendResponseBatch",
                threadPool.getThreadContext().putHeader(CONTEXT_HEADER, CONTEXT_VALUE);  
                try (streamResponse) {
        CountDownLatch messageSentLatch = new CountDownLatch(3);
            public TestResponse read(StreamInput in) throws IOException {  
import java.io.IOException;
        AtomicInteger messageSentCount = new AtomicInteger(0);
                // Verify the caller's context is preserved after sendResponseBatch
    public void testContextHeaderPropagatedToResponseHeaders() throws InterruptedException {
                        handlerException.set(e);  
            }  
                channel.sendResponseBatch(new TestResponse("Response 2"));
            } catch (IOException ignored) {}  
import org.opensearch.transport.TransportRequestOptions;
/*  
            }  
        TestRequest testRequest = new TestRequest();  
        AtomicInteger responseCount = new AtomicInteger(0);
                channel.sendResponseBatch(new TestResponse("batch-1"));
            public void handleException(TransportException exp) {
        });
import java.util.concurrent.CountDownLatch;
                        handlerException.set(e);
            public void handleException(TransportException exp) {
        assertTrue(handlerLatch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
import java.util.concurrent.TimeUnit;  
                try (streamResponse) {  
        TestRequest testRequest = new TestRequest();
import org.opensearch.threadpool.ThreadPool;  
                } catch (Exception ignored) {} finally {
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
                channel.sendResponse(new RuntimeException("Intentional test error"));
                // Verify context is still preserved after second batch  
                            responseCount.incrementAndGet();  
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
import org.opensearch.transport.TransportException;
import java.util.concurrent.atomic.AtomicReference;
                try (streamResponse) {  
                // Verify the caller's context is preserved after sendErrorResponse
                    } catch (Exception e) {
        // Wait for all async onResponseSent callbacks to complete before asserting count
 * when sending response batches, completing streams, and sending errors.  
import org.opensearch.transport.StreamTransportResponseHandler;
                }  
    }  
 * compatible open source license.
        streamTransportService.sendRequest(remoteNode, action, testRequest, options, responseHandler);
                return new TestResponse(in);
        };
public class FlightOutboundHandlerContextPropagationTests extends FlightTransportTestBase {
    private static final int TIMEOUT_SEC = 10;
                // Set a header in the request handler's thread context
            @Override
                // Send an error
                assertEquals(CONTEXT_VALUE, threadPool.getThreadContext().getHeader(CONTEXT_HEADER));
                }
    private static final String CONTEXT_HEADER = "test-context-header";
        );
            }
        };
