                callTracker.recordCallEnd(se.getErrorCode().name());  
                callTracker.recordCallEnd(StreamErrorCode.INTERNAL.name());
import org.opensearch.core.transport.TransportResponse;  
            callTracker.recordCallEnd(StreamErrorCode.OK.name());  
 * compatible open source license.
/*  
    public T read(StreamInput streamInput) throws IOException {  
     * @param callTracker the call tracker for metrics  
        }
                callTracker.recordCallEnd(StreamErrorCode.CANCELLED.name());  
import org.opensearch.transport.stream.StreamErrorCode;  
 * This handler wraps another handler and adds metrics tracking.
            return response;  
    }
    public void handleException(TransportException exp) {
 * The OpenSearch Contributors require contributions made to  
                callTracker.recordBatchReceived(batchSize, processingTimeNanos);
    @Override
import java.io.IOException;
    @Override  
                long processingTimeNanos = System.nanoTime() - startTime;  
    private final TransportResponseHandler<T> delegate;
            }  
     */
            }
 */  
    }
     * A stream response wrapper that tracks metrics for batches.  
    private final FlightCallTracker callTracker;  
    @Override
            callTracker.recordCallEnd(StreamErrorCode.UNAVAILABLE.name());
        @Override  
            }  
            delegate.handleException(exp);  
    public String executor() {
        this.delegate = delegate;  
            if (e instanceof StreamException se) {
            delegate.close();
         * @param delegate the delegate stream response  
        }
        } finally {
import org.opensearch.transport.stream.StreamTransportResponse;
        return delegate.read(streamInput);
        public void close() throws IOException {
        StreamTransportResponse<T> wrappedResponse = new MetricsTrackingStreamResponse<>(flightResponse, callTracker);
    @Override  
        MetricsTrackingStreamResponse(FlightTransportResponse<T> delegate, FlightCallTracker callTracker) {  
        }
         * @param callTracker the call tracker for metrics
            }
        }  
            try {
            callTracker.recordBatchRequested();
            long startTime = System.nanoTime();
    /**
        }
class MetricsTrackingResponseHandler<T extends TransportResponse> implements TransportResponseHandler<T> {
     */
import org.opensearch.transport.TransportException;
    }  
                callTracker.recordCallEnd(StreamErrorCode.INTERNAL.name());  
            } else {
 *
            delegate.handleStreamResponse(wrappedResponse);
        FlightTransportResponse<T> flightResponse = (FlightTransportResponse<T>) response;
import org.opensearch.transport.TransportResponseHandler;
    }
    public void handleResponse(T response) {
}
            } finally {
        private final FlightCallTracker callTracker;
        }  
import org.opensearch.core.common.io.stream.StreamInput;
        private final FlightTransportResponse<T> delegate;  
        return delegate.skipsDeserialization();
            if (response != null) {
        public T nextResponse() {  
    }
         */
        delegate.handleResponse(response);  
        try {
import org.opensearch.arrow.flight.stats.FlightCallTracker;
        try {  
    MetricsTrackingResponseHandler(TransportResponseHandler<T> delegate, FlightCallTracker callTracker) {
package org.opensearch.arrow.flight.transport;
     * Creates a new metrics tracking response handler.  
    }
    }
    @Override
        try {
        this.callTracker = callTracker;
            throw e;
    }  
                callTracker.recordCallEnd(se.getErrorCode().name());
        /**  
        return delegate.executor();  
    }
    public void handleStreamResponse(StreamTransportResponse<T> response) {
            this.callTracker = callTracker;
 * SPDX-License-Identifier: Apache-2.0
            T response = delegate.nextResponse();  
         *
    @Override
     *
            } else {
        @Override
        } catch (Exception e) {
        }
            this.delegate = delegate;
                delegate.cancel(reason, cause);
/**  
         * Creates a new metrics tracking stream response.
    public boolean skipsDeserialization() {
    private static class MetricsTrackingStreamResponse<T extends TransportResponse> implements StreamTransportResponse<T> {
            delegate.handleRejection(exp);  
 * this file be licensed under the Apache-2.0 license or a
    @Override
 */  
        } finally {
import org.opensearch.transport.stream.StreamException;
     * @param delegate the delegate handler
    /**
    public void handleRejection(Exception exp) {
            if (exp instanceof StreamException se) {  
        @Override  
                long batchSize = delegate.getCurrentBatchSize();
        public void cancel(String reason, Throwable cause) {
 * A response handler wrapper that tracks metrics for Flight calls.
