            return response;
        return closed.get();
}
    @Override
import org.apache.logging.log4j.LogManager;
 */  
import org.opensearch.transport.stream.StreamTransportResponse;
    private final AtomicBoolean closed = new AtomicBoolean(false);
            logger.warn("Stream already closed, ignoring close request");  
    }
            throw new IllegalStateException("Stream has been cancelled");
    @Override
    public void close() {
    @Override
    public T nextResponse() {
    }  
        int index = currentIndex.getAndIncrement();  
import java.util.concurrent.atomic.AtomicInteger;
 * compatible open source license.
        // Return the next response from the list, or null if exhausted
    public void cancel(String reason, Throwable cause) {  
import org.opensearch.core.transport.TransportResponse;  
 *  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * @opensearch.internal
import java.util.List;  
 * Mock implementation of StreamTransportResponse for testing streaming transport functionality.
        }
        } else {
        }
package org.opensearch.transport.nio;
class MockStreamTransportResponse<T extends TransportResponse> implements StreamTransportResponse<T> {  
        if (cancelled) {  
        } else {
    }  
    private volatile boolean cancelled = false;  
        cancelled = true;  
    }
            T response = responses.get(index);
    public boolean isCancelled() {
        logger.debug("Mock stream cancelled: {} - {}", reason, cause != null ? cause.getMessage() : "no cause");
            logger.warn("Stream already cancelled, ignoring cancel request: {}", reason);
            return null;
/**
            logger.debug("Mock stream exhausted, returning null (requested index {}, total responses: {})", index, responses.size());  
    private static final Logger logger = LogManager.getLogger(MockStreamTransportResponse.class);
        if (cancelled) {
        if (closed.get()) {
        if (index < responses.size()) {
        }
            throw new IllegalStateException("Stream has been closed");
        this.responses = responses != null ? responses : List.of();
        return cancelled;  
            logger.debug("Returning mock streaming response {}/{}: {}", index + 1, responses.size(), response.getClass().getSimpleName());  
    private final AtomicInteger currentIndex = new AtomicInteger(0);
        }  
            logger.debug("Mock stream closed");
    // Constructor for multiple responses (new batching support)
    public MockStreamTransportResponse(List<T> responses) {  
            return;  
 * The OpenSearch Contributors require contributions made to  
    private final List<T> responses;  
        if (closed.compareAndSet(false, true)) {  
        }
    }
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.Logger;
 * SPDX-License-Identifier: Apache-2.0
    public boolean isClosed() {
 *
 */
    }
