                return new ServerInterceptor() {
            createTestInterceptor(10, false, null),
            createLoggingInterceptor(10, "AUTH", executionLog),  
            }
import io.grpc.ServerCall;
        );
                eq(headers)
        assertNotNull(result);
        assertNotNull(result);
                    @Override  
import io.grpc.ServerInterceptor;  
            verify(mockCall).close(
import org.opensearch.common.settings.Settings;
        );
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);  
        assertNotNull(result);  
        verify(mockCall).close(
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
            public int order() {
        );  
        return new OrderedGrpcInterceptor() {
        chain.interceptCall(mockCall, headers, mockHandler);  
    // HELPER METHODS - EASILY EXTENSIBLE
            public ServerInterceptor getInterceptor() {
        );
            argThat(status -> status.getCode() == Status.Code.INTERNAL && status.getDescription().contains("Last failure")),  
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(  
            ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);  
            false,
            public int order() {
    @Before
 *
            createTestInterceptor(20, false, null),
            createOrderTrackingInterceptor(20, executionOrder)
    private ServerCall.Listener<String> mockListener;
                return order;
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
     */
                        ServerCall<ReqT, RespT> call,
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(  
        assertEquals(Arrays.asList("AUTH", "LOGGING", "METRICS"), executionLog);
        List<Integer> executionOrder = new ArrayList<>();
            @Override  
 * The OpenSearch Contributors require contributions made to  
    public void testFirstInterceptorFails() {
    }
        headers = new Metadata();  
import static org.mockito.Mockito.never;  
        assertNotNull(result);  
            public ServerInterceptor getInterceptor() {  
     * Creates an interceptor that throws StatusRuntimeException with specific gRPC status
    private ServerCallHandler<String, String> mockHandler;
                };
        // Sort as GrpcPlugin would
                    @Override
        // Success scenario
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);  
        );
    // =============================================  
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);  
            createTestInterceptor(20, false, null),
        expectThrows(NullPointerException.class, () -> { new GrpcInterceptorChain(null); });
}  
            public ServerInterceptor getInterceptor() {  
            "Test failure"  
                        Metadata headers,  
        };
     */  
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
    public void testInterceptorThrowsStatusRuntimeExceptionUnauthenticated() {
        // Verify execution order
            @Override
    }
                        ServerCallHandler<ReqT, RespT> next
     */
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
            }  
    }  
    }  
                        ServerCallHandler<ReqT, RespT> next  
 * this file be licensed under the Apache-2.0 license or a
                        Metadata headers,  
                return order;  
            createStatusRuntimeExceptionInterceptor(20, Status.PERMISSION_DENIED.withDescription("Unauthorized access")),
        assertEquals(Arrays.asList(10, 20, 30), executionOrder);
            createTestInterceptor(10, false, null),
        chain.interceptCall(mockCall, headers, mockHandler);  
        );
                        return next.startCall(call, headers);  
        );
                        ServerCallHandler<ReqT, RespT> next  
                        ServerCall<ReqT, RespT> call,
        verify(mockCall).close(
            createTestInterceptor(10, true, "First failure"),
 */  
    public void testSingleSuccessfulInterceptor() {
        testChainWithPattern(  
                    }
        List<String> executionLog = new ArrayList<>();  
            eq(headers)  
    /**
    }
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
        } else {  
        };
                        ServerCall<ReqT, RespT> call,
import java.util.Arrays;
 * compatible open source license.
                        return next.startCall(call, headers);  
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
            createTestInterceptor(20, false, null)
            createTestInterceptor(30, false, null)  
    public void testEmptyChain() {
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
        interceptors.sort((a, b) -> Integer.compare(a.order(), b.order()));
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
    private OrderedGrpcInterceptor createOrderTrackingInterceptor(int order, List<Integer> executionOrder) {
    public void testVariousInterceptorCombinations() {
                    ) {
        return new OrderedGrpcInterceptor() {  
    }  
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
        // Reset mocks for next test
        chain.interceptCall(mockCall, headers, mockHandler);
        );
            argThat(status -> status.getCode() == Status.Code.RESOURCE_EXHAUSTED && status.getDescription().equals("Rate limit exceeded")),
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(  
            }  
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
    @Mock
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(  
import org.junit.Before;
    /**  
        if (expectSuccess) {
            eq(headers)
        );  
            argThat(status -> status.getCode() == Status.Code.UNAUTHENTICATED && status.getDescription().equals("Invalid token")),  
                        throw new StatusRuntimeException(status);  
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(  
                };
                };
            verify(mockCall, never()).close(any(Status.class), any(Metadata.class));
            argThat(status -> status.getCode() == Status.Code.INTERNAL && status.getDescription().contains("First failure")),
            public int order() {
            public ServerInterceptor getInterceptor() {
                        log.add(name);
            eq(headers)  
            createTestInterceptor(20, true, "Middle failure"),  
                        ServerCallHandler<ReqT, RespT> next
import static org.mockito.Mockito.when;  
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
        verify(mockCall).close(
import io.grpc.StatusRuntimeException;
                    ) {
    private OrderedGrpcInterceptor createLoggingInterceptor(int order, String name, List<String> log) {
    }
            createTestInterceptor(20, false, null),
    }
            createLoggingInterceptor(30, "METRICS", executionLog)
                };
public class GrpcInterceptorChainTests extends OpenSearchTestCase {
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
        );
        // Simulate a real-world scenario: Auth -> Logging -> Metrics
        chain.interceptCall(mockCall, headers, mockHandler);
    public void setUp() throws Exception {
            assertNotNull(result);
                        }
        }  
                        return next.startCall(call, headers);  
        verify(mockHandler).startCall(mockCall, headers);
import java.util.ArrayList;
        verify(mockCall).close(  
            @Override
import org.mockito.Mock;  
                            throw new RuntimeException(errorMessage);
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
     * Creates a logging interceptor - useful for integration tests
            eq(headers)  
            chain.interceptCall(mockCall, headers, mockHandler);
            );
        );
import io.grpc.Metadata;  
    }
                return new ServerInterceptor() {
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(createTestInterceptor(10, false, null));
    }
            createLoggingInterceptor(20, "LOGGING", executionLog),
                return new ServerInterceptor() {
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);  
                    @Override
            argThat(status -> status.getCode() == Status.Code.INTERNAL && status.getDescription().contains("Middle failure")),
            @Override  
/*  
    private OrderedGrpcInterceptor createTestInterceptor(int order, boolean shouldFail, String errorMessage) {
import static org.mockito.ArgumentMatchers.eq;
        };
                return order;
    @SuppressWarnings("unchecked")  
    /**
    @Mock
import org.opensearch.test.OpenSearchTestCase;  
    }  
    private ThreadContext threadContext;
    }
        assertNotNull(result);
            argThat(status -> status.getCode() == Status.Code.PERMISSION_DENIED && status.getDescription().equals("Unauthorized access")),
import org.mockito.MockitoAnnotations;
    }
    public void testMiddleInterceptorFails() {  
     */
     */  
        MockitoAnnotations.openMocks(this);
import static org.mockito.Mockito.verify;
                        Metadata headers,
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
        super.setUp();  
        );
            Arrays.asList(createTestInterceptor(10, false, null), createTestInterceptor(20, true, "Test failure")),
            }  
                return order;  
package org.opensearch.transport.grpc.interceptor;
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);  
     */
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(  
            createStatusRuntimeExceptionInterceptor(30, Status.RESOURCE_EXHAUSTED.withDescription("Rate limit exceeded"))  
    }
     * Generic test method that can be extended for different scenarios  
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
                    }
    /**
            createTestInterceptor(20, false, null),
    private OrderedGrpcInterceptor createStatusRuntimeExceptionInterceptor(int order, Status status) {
            createTestInterceptor(30, true, "Last failure")
        // The result is now wrapped in a ThreadContextPreservingListener, not the raw mockListener  
            createTestInterceptor(30, false, null)
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
    }
 * SPDX-License-Identifier: Apache-2.0
            }  
    public void testLastInterceptorFails() {
    }  
        );  
    }
            @Override  
    public void testMultipleSuccessfulInterceptors() {
import static org.mockito.Mockito.reset;
        reset(mockCall);  
    public void testInterceptorOrdering() {
        when(mockHandler.startCall(any(), any())).thenReturn(mockListener);
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, Collections.emptyList());
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);  
        // Failure scenario
import java.util.Collections;  
    // =============================================
            }  
        );
        return new OrderedGrpcInterceptor() {  
                        Metadata headers,
        chain.interceptCall(mockCall, headers, mockHandler);
            @Override
            @Override
import static org.mockito.ArgumentMatchers.argThat;
            createTestInterceptor(10, false, null),
        verify(mockCall, never()).close(any(Status.class), any(Metadata.class));
    public void testInterceptorThrowsStatusRuntimeExceptionPermissionDenied() {
            @Override  
                        ServerCall<ReqT, RespT> call,
        );
    public void testChainWithPattern(List<OrderedGrpcInterceptor> interceptors, boolean expectSuccess, String expectedErrorMessage) {
            createStatusRuntimeExceptionInterceptor(10, Status.UNAUTHENTICATED.withDescription("Invalid token")),  
    }
                    @Override  
    public void testInterceptorThrowsStatusRuntimeExceptionResourceExhausted() {
        return new OrderedGrpcInterceptor() {
                    ) {
                    }
        );
     * Test method that can easily be extended with new interceptor combinations
            createTestInterceptor(10, false, null),
import org.opensearch.common.util.concurrent.ThreadContext;
     * This is used to test the StatusRuntimeException handling path (lines 71-79)  
            }  
            createTestInterceptor(10, false, null),  
    public void testChainIntegrationWithRealScenario() {
        assertNotNull(result);  
            public int order() {
            createTestInterceptor(30, false, null)  
        // Constructor should throw NullPointerException for null interceptors  
        testChainWithPattern(Arrays.asList(createTestInterceptor(10, false, null), createTestInterceptor(20, false, null)), true, null);  
    /**
            createOrderTrackingInterceptor(30, executionOrder),
import io.grpc.Status;
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
        };
import io.grpc.ServerCallHandler;
    private Metadata headers;
                    ) {
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider.OrderedGrpcInterceptor;
            eq(headers)
            createOrderTrackingInterceptor(10, executionOrder),  
        threadContext = new ThreadContext(Settings.EMPTY);
import static org.mockito.ArgumentMatchers.any;  
    // FAILURE SCENARIO TESTS
     * Creates an interceptor that tracks execution order - useful for ordering tests
import java.util.List;
            createTestInterceptor(30, false, null)  
        verify(mockCall, never()).close(any(Status.class), any(Metadata.class));
        verify(mockCall).close(
    /**
            eq(headers)
                return new ServerInterceptor() {
    private ServerCall<String, String> mockCall;
            }
                        if (shouldFail) {  
                        executionOrder.add(order);
        verify(mockCall).close(
                    }
    public void testNullInterceptorList() {
     * Creates a test interceptor with specified behavior - easily configurable  
                argThat(status -> status.getCode() == Status.Code.INTERNAL && status.getDescription().contains(expectedErrorMessage)),  
    }
    @Mock
