 */  
        verify(delegateObserver).onError(error);
    private StreamObserver<String> delegateObserver;  
import org.junit.Before;  
import org.opensearch.core.common.breaker.CircuitBreaker;  
        wrapperObserver.onCompleted();  
        // Verify delegate was called for both
package org.opensearch.transport.grpc.util;
        // Verify bytes were released exactly once
import io.grpc.stub.StreamObserver;
        verify(circuitBreaker, never()).addWithoutBreaking(anyLong());  
import static org.mockito.Mockito.verify;
        // Verify delegate was called
        MockitoAnnotations.openMocks(this);
        wrapperObserver.onCompleted();  
        verify(circuitBreaker, times(1)).addWithoutBreaking(eq((long) -REQUEST_SIZE));
    }  
    }
    @Mock
        wrapperObserver.onNext("value2");
        wrapperObserver.onNext("value3");  
        wrapperObserver.onError(error);
    public void testOnNextDelegatesToDelegate() {  
        wrapperObserver.onCompleted();
        verify(circuitBreaker, times(1)).addWithoutBreaking(eq((long) -REQUEST_SIZE));  
        verify(delegateObserver).onError(any());
        wrapperObserver.onCompleted();
import org.mockito.Mock;  
        wrapperObserver.onError(new RuntimeException("Error"));
        verify(delegateObserver).onNext(value);  
        verify(delegateObserver, times(2)).onNext(any());
    public void setup() {  
 * compatible open source license.
    private CircuitBreaker circuitBreaker;  
        // Call onCompleted first  
        verify(delegateObserver).onCompleted();  
        // Verify delegate was called for both
 * This wrapper ensures circuit breaker bytes are released when gRPC responses complete.
        verify(circuitBreaker, times(1)).addWithoutBreaking(eq((long) -REQUEST_SIZE));
        verify(delegateObserver, times(3)).onNext(any());
    public void testMultipleOnNextCallsDoNotReleaseBytes() {  
        verify(delegateObserver).onCompleted();  
/*  
    public void testOnCompletedReleasesBytes() {
        wrapperObserver = new CircuitBreakerStreamObserver<>(delegateObserver, circuitBreakerService, REQUEST_SIZE);  
        wrapperObserver.onNext("value1");
 * SPDX-License-Identifier: Apache-2.0
public class CircuitBreakerStreamObserverTests extends OpenSearchTestCase {  
    }
        wrapperObserver.onNext(value);
import org.opensearch.test.OpenSearchTestCase;
    }
        verify(delegateObserver).onCompleted();  
    @Before
    public void testBytesReleasedExactlyOnceOnErrorThenCompleted() {
    }
        verify(circuitBreaker, never()).addWithoutBreaking(anyLong());
    }
        verify(circuitBreaker, times(1)).addWithoutBreaking(eq((long) -REQUEST_SIZE));
    @Mock
import static org.mockito.ArgumentMatchers.any;  
 */
 * Tests for CircuitBreakerStreamObserver wrapper.  
        wrapperObserver.onNext("value2");
        verify(circuitBreaker, times(1)).addWithoutBreaking(eq((long) -REQUEST_SIZE));  
import static org.mockito.Mockito.times;
        verify(circuitBreaker, times(1)).addWithoutBreaking(eq((long) -REQUEST_SIZE));
/**
    }  
    private CircuitBreakerService circuitBreakerService;  
        // Verify bytes were released exactly once
    public void testOnCompletedAfterMultipleOnNextReleasesBytes() {  
        // Call onError first
import static org.mockito.Mockito.never;  
        Throwable error = new RuntimeException("Test error");
        wrapperObserver.onNext("value1");
        // Call onError - should not release again
import org.mockito.MockitoAnnotations;
        verify(delegateObserver).onCompleted();  
}  
        wrapperObserver.onError(new RuntimeException("Error"));  
        String value = "test-value";
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;  
    }
        // Verify delegate was called
        verify(delegateObserver).onError(any());
 * this file be licensed under the Apache-2.0 license or a
        // Call onCompleted - should not release again  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        verify(circuitBreaker, times(1)).addWithoutBreaking(eq((long) -REQUEST_SIZE));
    public void testOnErrorReleasesBytes() {  
    private CircuitBreakerStreamObserver<String> wrapperObserver;
 *
    @Mock
        when(circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS)).thenReturn(circuitBreaker);
    private static final int REQUEST_SIZE = 1024;  
    public void testBytesReleasedExactlyOnceOnMultipleCalls() {
import static org.mockito.ArgumentMatchers.eq;
        // Bytes should not be released on onNext
