            }
                return new TestResponse(in);  
                try (streamResponse) {  
            }
        // Check for error statuses
        }
                    try {
                } catch (Exception ignored) {} finally {
        assertTrue("Should have batches received", clientBatchMetrics.getBatchesReceived() >= 5);
        );
        AtomicReference<Exception> exception = new AtomicReference<>();  
import org.opensearch.core.common.io.stream.StreamInput;
        CountDownLatch latch = new CountDownLatch(1);
    }
 * The OpenSearch Contributors require contributions made to  
                    exception.set(e);
            }  
    }
                        }
            }
        assertEquals("Should have 1 CANCELLED status", 1, cancelledStatusCount);
    private void registerHandlers() {
                    latch.countDown();
        TestRequest testRequest = new TestRequest();
                    }
            @Override
            }
        FlightMetrics.ServerBatchMetrics serverBatchMetrics = metrics.getServerBatchMetrics();
            @Override  
                latch.countDown();
        assertEquals("Should have 2 OK status", 2, okStatusCount);
                    TestResponse response2 = new TestResponse("Response 2");  
import org.opensearch.transport.stream.StreamErrorCode;
import org.opensearch.arrow.flight.transport.FlightTransportTestBase;
        // Client call metrics
        assertTrue("Failing streaming should complete", latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));  
                            latch.countDown();
                } catch (Exception ignored) {}
        assertTrue("Should have batches requested", clientBatchMetrics.getBatchesRequested() >= 3);  
                    channel.sendResponseBatch(response1);
                    }
        assertTrue("Server batch sent bytes should be recorded", serverBatchMetrics.getSentBytes().getSum() > 0);
            @Override
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
import org.opensearch.threadpool.ThreadPool;  
        AtomicInteger responseCount = new AtomicInteger(0);  
            StreamErrorCode.UNKNOWN,
                        channel.sendResponse(e);
                            streamResponse.cancel("Client cancellation", null);
                latch.countDown();
            @Override
    private final int TIMEOUT_SEC = 10;
                exception.set(exp);
            (request, channel, task) -> {  
    private void sendSuccessfulStreamingRequest() throws Exception {
                    } catch (Exception e) {
        TestRequest testRequest = new TestRequest();
            public void handleException(TransportException exp) {  
        AtomicReference<Exception> exception = new AtomicReference<>();  
                    channel.completeStream();
        FlightMetrics metrics = statsCollector.collectStats();
import org.opensearch.transport.stream.StreamTransportResponse;
/*  
                }
            StreamErrorCode.UNKNOWN,
                        exception.set(e);
        assertTrue("Successful streaming should complete", latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
        streamTransportService.registerRequestHandler(
            StreamErrorCode.UNAVAILABLE }) {  
                    channel.sendResponseBatch(response3);
                    channel.sendResponseBatch(response1);
        sendSuccessfulStreamingRequest();  
            @Override
import java.io.IOException;
                    try {  
            @Override
                return new TestResponse(in);
            public TestResponse read(StreamInput in) throws IOException {
        streamTransportService.registerRequestHandler(
            @Override
            }  
        registerHandlers();
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
            public TestResponse read(StreamInput in) throws IOException {
                try {
            StreamErrorCode.INTERNAL,
            public TestResponse read(StreamInput in) throws IOException {
                        if (response != null) {  
            }
            @Override  
            public TestResponse read(StreamInput in) throws IOException {
            @Override
        streamTransportService.sendRequest(remoteNode, "internal:test/metrics/cancel", testRequest, options, responseHandler);
    }
                    } catch (IOException ioException) {}  
                } catch (Exception e) {  
        assertTrue("Should have at least one error status", errorStatusCount > 0);  
            }
            TestRequest::new,
                }
            "internal:test/metrics/success",  
        assertEquals("Should have 4 client calls started", 4, clientCallMetrics.getStarted());  
                } catch (Exception e) {
        streamTransportService.sendRequest(remoteNode, "internal:test/simple", testRequest, options, responseHandler);
            public String executor() {  
        // Check server status counts  
                    TestResponse response = new TestResponse("Simple Response");  
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<>() {
        assertEquals("Should have 1 CANCELLED status", 1, cancelledStatusCount);
                    latch.countDown();  
                exception.set(exp);
        streamTransportService.sendRequest(remoteNode, "internal:test/metrics/success", testRequest, options, responseHandler);  
    private void sendFailingStreamingRequest() throws Exception {
            (request, channel, task) -> {
                        channel.sendResponse(e);  
        };
        long okStatusCount = metrics.getStatusCount(true, StreamErrorCode.OK.name());
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();  
        TestRequest testRequest = new TestRequest();
                try {  
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
import org.opensearch.transport.TransportRequestOptions;  
                return new TestResponse(in);  
        assertEquals("Should have 4 client calls completed", 4, clientCallMetrics.getCompleted());
                    channel.sendResponseBatch(response2);  
            }
        assertEquals("Should have 4 server calls started", 4, serverCallMetrics.getStarted());  
                try (streamResponse) {
            TestRequest::new,  
                }
        assertNotNull("Failing streaming should fail", exception.get());
        for (StreamErrorCode errorCode : new StreamErrorCode[] {  
            ThreadPool.Names.SAME,  
        sendSimpleMessage();
        assertTrue("Client request bytes should be recorded", clientCallMetrics.getRequestBytes().getSum() > 0);
        CountDownLatch latch = new CountDownLatch(1);
                        }  
 *
        AtomicReference<Exception> exception = new AtomicReference<>();  
                try {
                exception.set(exp);
                    try {
    private void sendCancelledStreamingRequest() throws Exception {
        Thread.sleep(2000);  
            ThreadPool.Names.SAME,
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<>() {
                        TestResponse response2 = new TestResponse("Response 2");
                    } catch (Exception e) {  
            "internal:test/metrics/failure",  
        assertTrue("Should have batches sent", serverBatchMetrics.getBatchesSent() >= 5);  
            }  
                try {
        TestRequest testRequest = new TestRequest();
        assertTrue("Simple message should complete", latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));  
                } catch (Exception e) {  
            errorStatusCount += metrics.getStatusCount(true, errorCode.name());
            (request, channel, task) -> {  
import org.opensearch.transport.StreamTransportResponseHandler;
            public void handleException(TransportException exp) {
                    Thread.sleep(1000);
            }
        }
    }
package org.opensearch.arrow.flight.stats;
                        exception.set(e);
    }
import java.util.concurrent.atomic.AtomicInteger;
        assertEquals("Should have one error status", 1, errorStatusCount);  
                return ThreadPool.Names.SAME;
        assertEquals("Should receive 3 responses", 3, responseCount.get());
                    } catch (IOException ioException) {}
            @Override
            "internal:test/simple",
        AtomicReference<Exception> exception = new AtomicReference<>();
        streamTransportService.registerRequestHandler(
            @Override
                    latch.countDown();
            ThreadPool.Names.SAME,
                    TestResponse response1 = new TestResponse("Response 1");
                    throw e;
            }  
        assertEquals("Should have 1 OK status", 2, okStatusCount);
                } catch (Exception e) {  
        assertTrue("Client batch received bytes should be recorded", clientBatchMetrics.getReceivedBytes().getSum() > 0);
 */  
                    channel.sendResponseBatch(response);
                        TestResponse response = streamResponse.nextResponse();  
            @Override  
                }
import java.util.concurrent.TimeUnit;  
        // Server call metrics
        verifyMetrics();
public class FlightMetricsTests extends FlightTransportTestBase {
                        // Process responses
            @Override
            }  
                latch.countDown();
    }
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();  
                } finally {  
            errorStatusCount += metrics.getStatusCount(false, errorCode.name());
        FlightMetrics.ServerCallMetrics serverCallMetrics = metrics.getServerCallMetrics();
                exception.set(exp);  
                        latch.countDown();  
            public String executor() {
 * SPDX-License-Identifier: Apache-2.0
        FlightMetrics.ClientBatchMetrics clientBatchMetrics = metrics.getClientBatchMetrics();
                        }
                        while (streamResponse.nextResponse() != null) {
                }
        okStatusCount = metrics.getStatusCount(false, StreamErrorCode.OK.name());
                    } catch (Exception e) {}  
        errorStatusCount = 0;
                    try {
        );  
        for (StreamErrorCode errorCode : new StreamErrorCode[] {  
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();  
            @Override
            }
                try {
                        channel.sendResponse(e);
            ThreadPool.Names.SAME,
                    channel.completeStream();
    public void setUp() throws Exception {
        streamTransportService.registerRequestHandler(  
        // Check for error statuses
    private void verifyMetrics() {
            public String executor() {  
                latch.countDown();
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
                    try {
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {  
            public void handleException(TransportException exp) {  
            public void handleException(TransportException exp) {  
 * compatible open source license.
    private void sendSimpleMessage() throws Exception {  
            }
            "internal:test/metrics/cancel",
                    try {
        assertNull("Simple message should not fail", exception.get());
        CountDownLatch latch = new CountDownLatch(1);
                        TestResponse response = streamResponse.nextResponse();
            }
            TestRequest::new,
            TestRequest::new,
                    try {  
            @Override
        };
            StreamErrorCode.INTERNAL,
                        // Get first response then cancel
        sendFailingStreamingRequest();
        assertTrue("Cancelled streaming should complete", latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));  
            (request, channel, task) -> {
            @Override
                        exception.set(e);  
                try (streamResponse) {
        // Check status counts from the status map  
            }
        long errorStatusCount = 0;
            StreamErrorCode.UNAVAILABLE }) {  
                } catch (IOException ignored) {}  
        super.setUp();  
        FlightMetrics.ClientCallMetrics clientCallMetrics = metrics.getClientCallMetrics();
import java.util.concurrent.atomic.AtomicReference;
        long cancelledStatusCount = metrics.getStatusCount(true, StreamErrorCode.CANCELLED.name());
                return ThreadPool.Names.SAME;
        assertNull("Cancelled streaming should not fail in client", exception.get());
    public void testComprehensiveMetrics() throws Exception {  
}  
                            responseCount.incrementAndGet();  
        };
        streamTransportService.sendRequest(remoteNode, "internal:test/metrics/failure", testRequest, options, responseHandler);
        );  
    @Override
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<>() {  
                return ThreadPool.Names.SAME;  
                    TestResponse response1 = new TestResponse("Response 1");
                    }
        assertEquals("Should have 4 server calls completed", 4, serverCallMetrics.getCompleted());
        };
        CountDownLatch latch = new CountDownLatch(1);
                    } catch (IOException ioException) {}  
            public String executor() {  
        assertNull("Successful streaming should not fail", exception.get());  
                    channel.sendResponse(new RuntimeException("Simulated failure"));
                        if (response != null) {
            }  
    }
        // Client batch metrics
        // Server batch metrics
            }  
                return ThreadPool.Names.SAME;
                }
                    while (streamResponse.nextResponse() != null) {  
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<>() {
            }  
                return new TestResponse(in);  
 * this file be licensed under the Apache-2.0 license or a
        );
        assertTrue("Server request bytes should be recorded", serverCallMetrics.getRequestBytes().getSum() > 0);
                    TestResponse response3 = new TestResponse("Response 3");
                    } catch (Exception e) {
import org.opensearch.transport.TransportException;
                } catch (Exception ignored) {} finally {  
                    }
                        channel.sendResponseBatch(response2);
import java.util.concurrent.CountDownLatch;
        sendCancelledStreamingRequest();
    }
        cancelledStatusCount = metrics.getStatusCount(false, StreamErrorCode.CANCELLED.name());
