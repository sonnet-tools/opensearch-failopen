        CircuitBreaker breaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
import org.opensearch.core.common.breaker.CircuitBreaker;  
     * @param t The error that occurred
    /**
    @Override  
    /**
public class CircuitBreakerStreamObserver<T> implements StreamObserver<T> {
}
/*  
    @Override  
    }
    }  
 */
        releaseBytes();
    /**  
        this.circuitBreakerService = circuitBreakerService;
    public void onError(Throwable t) {
     * @param value The next value in the stream  
import io.grpc.stub.StreamObserver;
     *
     * @param requestSize The size of the request in bytes that was added to the circuit breaker
import org.opensearch.core.indices.breaker.CircuitBreakerService;
 * this file be licensed under the Apache-2.0 license or a
        delegate.onCompleted();  
     * Releases circuit breaker bytes and forwards the completion signal to the delegate observer.
import java.util.concurrent.atomic.AtomicBoolean;  
 * The OpenSearch Contributors require contributions made to  
 *
     */
    private void releaseBytes() {  
    private final AtomicBoolean released = new AtomicBoolean(false);  
/**
    @Override
        delegate.onError(t);  
        releaseBytes();
        if (released.compareAndSet(false, true) == false) {
        breaker.addWithoutBreaking(-requestSize);
     */
     *
        this.requestSize = requestSize;  
    private final CircuitBreakerService circuitBreakerService;
    public void onNext(T value) {  
 * Bytes are released exactly once when either onCompleted() or onError() is called.
        this.delegate = delegate;
    public CircuitBreakerStreamObserver(StreamObserver<T> delegate, CircuitBreakerService circuitBreakerService, int requestSize) {  
    private final StreamObserver<T> delegate;  
     * Creates a new CircuitBreakerStreamObserver wrapper.  
 * Wrapper for StreamObserver that automatically releases circuit breaker bytes when a gRPC response completes.
    }
 * SPDX-License-Identifier: Apache-2.0
    /**  
     *  
     */
        delegate.onNext(value);
     * @param delegate The underlying StreamObserver to delegate calls to
     * Releases circuit breaker bytes and forwards the error to the delegate observer.
    }
 *
 * @param <T> The type of message observed  
 * This ensures that in-flight request memory is properly tracked and released, preventing memory leaks.  
 * compatible open source license.
     * Forwards the next value to the delegate observer.
 */  
    private final int requestSize;
            return;
package org.opensearch.transport.grpc.util;
     * @param circuitBreakerService The circuit breaker service for tracking in-flight requests  
    }
        }  
    public void onCompleted() {
     */
