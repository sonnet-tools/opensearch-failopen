        assertTrue("Should have batches requested", clientBatchMetrics.getBatchesRequested() >= 3);
                try {
            @Override
        long errorStatusCount = 0;
        FlightMetrics.ClientCallMetrics clientCallMetrics = metrics.getClientCallMetrics();
        assertNull("Cancelled streaming should not fail in client", exception.get());
        long cancelledStatusCount = metrics.getStatusCount(true, StreamErrorCode.CANCELLED.name());
        AtomicReference<Exception> exception = new AtomicReference<>();
            }
        AtomicReference<Exception> exception = new AtomicReference<>();
                    } catch (IOException ioException) {}
                    }
            public TestResponse read(StreamInput in) throws IOException {
            StreamErrorCode.UNKNOWN,
import org.opensearch.arrow.flight.transport.FlightTransportTestBase;
                        if (response != null) {
                try (streamResponse) {
                } catch (Exception ignored) {} finally {
        assertTrue("Client request bytes should be recorded", clientCallMetrics.getRequestBytes().getSum() > 0);
    @Override
        streamTransportService.registerRequestHandler(
                    channel.sendResponseBatch(response3);
                        channel.sendResponseBatch(response2);
                    while (streamResponse.nextResponse() != null) {
                latch.countDown();
        );
                    }
                } catch (Exception e) {
            "internal:test/metrics/cancel",
            ThreadPool.Names.SAME,
        FlightMetrics.ClientBatchMetrics clientBatchMetrics = metrics.getClientBatchMetrics();
            @Override
                try (streamResponse) {
            ThreadPool.Names.SAME,
        assertEquals("Should have one error status", 1, errorStatusCount);
                return new TestResponse(in);
        CountDownLatch latch = new CountDownLatch(1);
            public String executor() {
            public void handleException(TransportException exp) {
            }
        FlightMetrics.ServerCallMetrics serverCallMetrics = metrics.getServerCallMetrics();
            StreamErrorCode.UNKNOWN,
import java.util.concurrent.atomic.AtomicInteger;
            (request, channel, task) -> {
                    } catch (Exception e) {
            }
                    latch.countDown();
        assertEquals("Should have 1 CANCELLED status", 1, cancelledStatusCount);
                return new TestResponse(in);
            @Override
        TestRequest testRequest = new TestRequest();
            public String executor() {
        streamTransportService.registerRequestHandler(
import org.opensearch.transport.TransportException;
            @Override
            @Override
            ThreadPool.Names.SAME,
            @Override
        };
                exception.set(exp);
 * this file be licensed under the Apache-2.0 license or a
/*
    private final int TIMEOUT_SEC = 10;
        streamTransportService.sendRequest(remoteNode, "internal:test/metrics/success", testRequest, options, responseHandler);
            "internal:test/metrics/success",
        // Check for error statuses
        );
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
        };
        okStatusCount = metrics.getStatusCount(false, StreamErrorCode.OK.name());
                        }
        sendSimpleMessage();
            @Override
                        exception.set(e);
                    channel.completeStream();
 */
        // Check server status counts
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
                } catch (Exception ignored) {}
    }
            @Override
            ThreadPool.Names.SAME,
                        channel.sendResponse(e);
            "internal:test/metrics/failure",
                    channel.sendResponseBatch(response1);
            public TestResponse read(StreamInput in) throws IOException {
                return ThreadPool.Names.SAME;
        assertEquals("Should have 1 OK status", 2, okStatusCount);
                        latch.countDown();
                try {
                        TestResponse response = streamResponse.nextResponse();
    private void sendSuccessfulStreamingRequest() throws Exception {
        assertNull("Simple message should not fail", exception.get());
                            streamResponse.cancel("Client cancellation", null);
                    throw e;
                    try {
        super.setUp();
        // Client batch metrics
        streamTransportService.sendRequest(remoteNode, "internal:test/metrics/cancel", testRequest, options, responseHandler);
                    Thread.sleep(1000);
        FlightMetrics metrics = statsCollector.collectStats();
        for (StreamErrorCode errorCode : new StreamErrorCode[] {
                    TestResponse response1 = new TestResponse("Response 1");
            public void handleException(TransportException exp) {
        assertEquals("Should have 4 server calls completed", 4, serverCallMetrics.getCompleted());
            }
                    TestResponse response2 = new TestResponse("Response 2");
                try {
                return ThreadPool.Names.SAME;
        assertEquals("Should have 4 client calls completed", 4, clientCallMetrics.getCompleted());
        sendCancelledStreamingRequest();
                    } catch (IOException ioException) {}
                }
    private void registerHandlers() {
                }
                    } catch (Exception e) {
        registerHandlers();
        // Check for error statuses
            }
public class FlightMetricsTests extends FlightTransportTestBase {
    }
package org.opensearch.arrow.flight.stats;
        streamTransportService.registerRequestHandler(
            @Override
        assertTrue("Simple message should complete", latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
            }
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
                    try {
                        }
        assertNull("Successful streaming should not fail", exception.get());
                        TestResponse response = streamResponse.nextResponse();
        };
            @Override
 * SPDX-License-Identifier: Apache-2.0
            @Override
        sendSuccessfulStreamingRequest();
            }
                    try {
    }
        verifyMetrics();
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<>() {
    private void verifyMetrics() {
            (request, channel, task) -> {
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<>() {
            @Override
                    TestResponse response1 = new TestResponse("Response 1");
            }
            (request, channel, task) -> {
        assertTrue("Should have batches sent", serverBatchMetrics.getBatchesSent() >= 5);
    }
import org.opensearch.transport.StreamTransportResponseHandler;
            @Override
        TestRequest testRequest = new TestRequest();
import org.opensearch.threadpool.ThreadPool;
                    channel.sendResponseBatch(response);
                            responseCount.incrementAndGet();
                } catch (Exception ignored) {} finally {
            (request, channel, task) -> {
                        channel.sendResponse(e);
        assertTrue("Cancelled streaming should complete", latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
    }
            public TestResponse read(StreamInput in) throws IOException {
 * compatible open source license.
        AtomicInteger responseCount = new AtomicInteger(0);
            }
 *
                } catch (IOException ignored) {}
        AtomicReference<Exception> exception = new AtomicReference<>();
                    channel.completeStream();
            }
                        exception.set(e);
        long okStatusCount = metrics.getStatusCount(true, StreamErrorCode.OK.name());
            StreamErrorCode.UNAVAILABLE }) {
            }
    private void sendCancelledStreamingRequest() throws Exception {
                } catch (Exception e) {
                    channel.sendResponseBatch(response2);
        // Server batch metrics
        sendFailingStreamingRequest();
    }
                    TestResponse response = new TestResponse("Simple Response");
import java.util.concurrent.CountDownLatch;
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<>() {
        );
                        // Get first response then cancel
                } finally {
                        TestResponse response2 = new TestResponse("Response 2");
                    channel.sendResponse(new RuntimeException("Simulated failure"));
    private void sendFailingStreamingRequest() throws Exception {
                }
                    }
            }
    private void sendSimpleMessage() throws Exception {
        }
        // Server call metrics
            @Override
 * The OpenSearch Contributors require contributions made to
        assertEquals("Should have 4 client calls started", 4, clientCallMetrics.getStarted());
        );
            "internal:test/simple",
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
import org.opensearch.transport.TransportRequestOptions;
        assertTrue("Successful streaming should complete", latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
                        }
                    } catch (IOException ioException) {}
                try (streamResponse) {
        assertEquals("Should have 4 server calls started", 4, serverCallMetrics.getStarted());
            errorStatusCount += metrics.getStatusCount(false, errorCode.name());
        Thread.sleep(2000);
            public void handleException(TransportException exp) {
        // Client call metrics
        CountDownLatch latch = new CountDownLatch(1);
                }
            TestRequest::new,
        assertEquals("Should receive 3 responses", 3, responseCount.get());
                    channel.sendResponseBatch(response1);
                return ThreadPool.Names.SAME;
                } catch (Exception e) {
            TestRequest::new,
    public void setUp() throws Exception {
            @Override
        // Check status counts from the status map
                return ThreadPool.Names.SAME;
import java.util.concurrent.TimeUnit;
            }
        assertTrue("Server batch sent bytes should be recorded", serverBatchMetrics.getSentBytes().getSum() > 0);
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.core.common.io.stream.StreamInput;
                try {
            }
                    latch.countDown();
        assertTrue("Server request bytes should be recorded", serverCallMetrics.getRequestBytes().getSum() > 0);
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
import org.opensearch.transport.stream.StreamErrorCode;
                    }
                    exception.set(e);
                exception.set(exp);
                    TestResponse response3 = new TestResponse("Response 3");
            }
            StreamErrorCode.INTERNAL,
            public TestResponse read(StreamInput in) throws IOException {
            }
        }
                }
            }
            StreamErrorCode.INTERNAL,
        assertTrue("Failing streaming should complete", latch.await(TIMEOUT_SEC, TimeUnit.SECONDS));
                        // Process responses
                        exception.set(e);
            @Override
            public void handleException(TransportException exp) {
                exception.set(exp);
        TestRequest testRequest = new TestRequest();
                        if (response != null) {
        streamTransportService.sendRequest(remoteNode, "internal:test/metrics/failure", testRequest, options, responseHandler);
            }
                    latch.countDown();
                    try {
                }
            public String executor() {
        cancelledStatusCount = metrics.getStatusCount(false, StreamErrorCode.CANCELLED.name());
    }
                    } catch (Exception e) {
        streamTransportService.registerRequestHandler(
        streamTransportService.sendRequest(remoteNode, "internal:test/simple", testRequest, options, responseHandler);
            }
        errorStatusCount = 0;
            errorStatusCount += metrics.getStatusCount(true, errorCode.name());
                latch.countDown();
            StreamErrorCode.UNAVAILABLE }) {
                try {
}
        assertNotNull("Failing streaming should fail", exception.get());
            TestRequest::new,
        CountDownLatch latch = new CountDownLatch(1);
            TestRequest::new,
        assertTrue("Should have batches received", clientBatchMetrics.getBatchesReceived() >= 5);
        CountDownLatch latch = new CountDownLatch(1);
                exception.set(exp);
                    try {
        for (StreamErrorCode errorCode : new StreamErrorCode[] {
                        channel.sendResponse(e);
            }
                    } catch (Exception e) {}
                    try {
        StreamTransportResponseHandler<TestResponse> responseHandler = new StreamTransportResponseHandler<>() {
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
                            latch.countDown();
        TestRequest testRequest = new TestRequest();
        assertEquals("Should have 1 CANCELLED status", 1, cancelledStatusCount);
import java.io.IOException;
        AtomicReference<Exception> exception = new AtomicReference<>();
                latch.countDown();
import org.opensearch.transport.stream.StreamTransportResponse;
            public String executor() {
                    try {
                } catch (Exception e) {
                return new TestResponse(in);
        assertEquals("Should have 2 OK status", 2, okStatusCount);
        };
            public void handleStreamResponse(StreamTransportResponse<TestResponse> streamResponse) {
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build();
    }
                return new TestResponse(in);
    public void testComprehensiveMetrics() throws Exception {
                latch.countDown();
        FlightMetrics.ServerBatchMetrics serverBatchMetrics = metrics.getServerBatchMetrics();
        assertTrue("Should have at least one error status", errorStatusCount > 0);
        assertTrue("Client batch received bytes should be recorded", clientBatchMetrics.getReceivedBytes().getSum() > 0);
                        while (streamResponse.nextResponse() != null) {
