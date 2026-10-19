                        Metadata headers,
            createTestInterceptor(30, false, null)
            @Override
import org.mockito.Mock;
     */
    private ServerCallHandler<String, String> mockHandler;
            createTestInterceptor(20, false, null),
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
     * Test method that can easily be extended with new interceptor combinations
            }
    }
        headers = new Metadata();
                        return next.startCall(call, headers);
    // FAILURE SCENARIO TESTS
        );
    public void testMultipleSuccessfulInterceptors() {
        if (expectSuccess) {
    private ThreadContext threadContext;
    public void testInterceptorOrdering() {
import io.grpc.ServerCallHandler;
    /**
                        return next.startCall(call, headers);
    public void testVariousInterceptorCombinations() {
        return new OrderedGrpcInterceptor() {
            createTestInterceptor(10, false, null),
import org.opensearch.common.util.concurrent.ThreadContext;
        return new OrderedGrpcInterceptor() {
        );
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
        assertNotNull(result);
            createTestInterceptor(20, false, null)
            argThat(status -> status.getCode() == Status.Code.INTERNAL && status.getDescription().contains("First failure")),
        );
    }
            createTestInterceptor(10, false, null),
     * Generic test method that can be extended for different scenarios
        return new OrderedGrpcInterceptor() {
            @Override
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
    }
import io.grpc.ServerInterceptor;
    }
    public void testFirstInterceptorFails() {
import java.util.List;
            verify(mockCall, never()).close(any(Status.class), any(Metadata.class));
    public void testLastInterceptorFails() {
            argThat(status -> status.getCode() == Status.Code.PERMISSION_DENIED && status.getDescription().equals("Unauthorized access")),
     */
            createTestInterceptor(30, false, null)
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
public class GrpcInterceptorChainTests extends OpenSearchTestCase {
                return new ServerInterceptor() {
        );
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
            @Override
        verify(mockCall).close(
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
            createTestInterceptor(10, false, null),
        List<String> executionLog = new ArrayList<>();
        testChainWithPattern(
    public void testInterceptorThrowsStatusRuntimeExceptionResourceExhausted() {
import static org.mockito.ArgumentMatchers.eq;
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        expectThrows(NullPointerException.class, () -> { new GrpcInterceptorChain(null); });
            createLoggingInterceptor(20, "LOGGING", executionLog),
    }
        assertNotNull(result);
     * Creates an interceptor that throws StatusRuntimeException with specific gRPC status
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                        executionOrder.add(order);
                    @Override
    }
            argThat(status -> status.getCode() == Status.Code.RESOURCE_EXHAUSTED && status.getDescription().equals("Rate limit exceeded")),
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
                    }
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
            @Override
import io.grpc.Metadata;
            argThat(status -> status.getCode() == Status.Code.INTERNAL && status.getDescription().contains("Middle failure")),
            createStatusRuntimeExceptionInterceptor(10, Status.UNAUTHENTICATED.withDescription("Invalid token")),
        );
            false,
                    ) {
        chain.interceptCall(mockCall, headers, mockHandler);
    }
                    }
        // Sort as GrpcPlugin would
    public void setUp() throws Exception {
                    }
            eq(headers)
                        if (shouldFail) {
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
    public void testMiddleInterceptorFails() {
import org.mockito.MockitoAnnotations;
        assertNotNull(result);
        verify(mockCall).close(
 *
import static org.mockito.Mockito.when;
            @Override
            eq(headers)
    }
                        Metadata headers,
            public ServerInterceptor getInterceptor() {
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
            @Override
            createOrderTrackingInterceptor(30, executionOrder),
        );
        // Success scenario
                        ServerCall<ReqT, RespT> call,
package org.opensearch.transport.grpc.interceptor;
                return order;
        chain.interceptCall(mockCall, headers, mockHandler);
import org.junit.Before;
        // The result is now wrapped in a ThreadContextPreservingListener, not the raw mockListener
            createStatusRuntimeExceptionInterceptor(20, Status.PERMISSION_DENIED.withDescription("Unauthorized access")),
        );
        // Constructor should throw NullPointerException for null interceptors
     * Creates a logging interceptor - useful for integration tests
        );
        // Verify execution order
    private Metadata headers;
            }
    /**
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
        assertNotNull(result);
     * Creates an interceptor that tracks execution order - useful for ordering tests
 * this file be licensed under the Apache-2.0 license or a
            public int order() {
    }
        } else {
            createTestInterceptor(20, true, "Middle failure"),
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
        List<Integer> executionOrder = new ArrayList<>();
            createTestInterceptor(20, false, null),
        when(mockHandler.startCall(any(), any())).thenReturn(mockListener);
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
    private OrderedGrpcInterceptor createLoggingInterceptor(int order, String name, List<String> log) {
 */
                return new ServerInterceptor() {
    @SuppressWarnings("unchecked")
            createTestInterceptor(20, false, null),
    }
        );
import org.opensearch.common.settings.Settings;
    public void testInterceptorThrowsStatusRuntimeExceptionPermissionDenied() {
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
                        ServerCallHandler<ReqT, RespT> next
                        ServerCall<ReqT, RespT> call,
    public void testChainIntegrationWithRealScenario() {
        assertEquals(Arrays.asList("AUTH", "LOGGING", "METRICS"), executionLog);
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
        MockitoAnnotations.openMocks(this);
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
        verify(mockCall, never()).close(any(Status.class), any(Metadata.class));
    }
        assertEquals(Arrays.asList(10, 20, 30), executionOrder);
    }
     */
        verify(mockCall).close(
    }
        };
        threadContext = new ThreadContext(Settings.EMPTY);
                        }
                    ) {
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
     * Creates a test interceptor with specified behavior - easily configurable
                        log.add(name);
 * The OpenSearch Contributors require contributions made to
            Arrays.asList(createTestInterceptor(10, false, null), createTestInterceptor(20, true, "Test failure")),
            }
                        return next.startCall(call, headers);
import io.grpc.ServerCall;
    @Mock
import io.grpc.Status;
                    @Override
            createLoggingInterceptor(30, "METRICS", executionLog)
            @Override
    }
    }
            ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
        assertNotNull(result);
                        throw new StatusRuntimeException(status);
            public ServerInterceptor getInterceptor() {
                };
        );
        );
        );
import static org.mockito.ArgumentMatchers.argThat;
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(createTestInterceptor(10, false, null));
    private ServerCall<String, String> mockCall;
     */
        return new OrderedGrpcInterceptor() {
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
                        ServerCall<ReqT, RespT> call,
                return order;
    private OrderedGrpcInterceptor createStatusRuntimeExceptionInterceptor(int order, Status status) {
import io.grpc.StatusRuntimeException;
            createOrderTrackingInterceptor(20, executionOrder)
            eq(headers)
            }
import static org.mockito.Mockito.never;
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
                return new ServerInterceptor() {
import static org.mockito.Mockito.reset;
        testChainWithPattern(Arrays.asList(createTestInterceptor(10, false, null), createTestInterceptor(20, false, null)), true, null);
        // Simulate a real-world scenario: Auth -> Logging -> Metrics
import java.util.ArrayList;
            argThat(status -> status.getCode() == Status.Code.UNAUTHENTICATED && status.getDescription().equals("Invalid token")),
            createTestInterceptor(30, false, null)
            createTestInterceptor(30, true, "Last failure")
            assertNotNull(result);
    /**
            public int order() {
    /**
    }
        // Reset mocks for next test
    private ServerCall.Listener<String> mockListener;
        };
        assertNotNull(result);
    private OrderedGrpcInterceptor createOrderTrackingInterceptor(int order, List<Integer> executionOrder) {
    // HELPER METHODS - EASILY EXTENSIBLE
        };
            createTestInterceptor(20, false, null),
                };
    /**
            createStatusRuntimeExceptionInterceptor(30, Status.RESOURCE_EXHAUSTED.withDescription("Rate limit exceeded"))
    }
    @Mock
        reset(mockCall);
    @Before
            eq(headers)
            @Override
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
            public int order() {
import java.util.Collections;
/*
            public int order() {
     * This is used to test the StatusRuntimeException handling path (lines 71-79)
                eq(headers)
}
        }
                        ServerCallHandler<ReqT, RespT> next
            public ServerInterceptor getInterceptor() {
            createLoggingInterceptor(10, "AUTH", executionLog),
            createTestInterceptor(30, false, null)
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, Collections.emptyList());
     */
            eq(headers)
        verify(mockHandler).startCall(mockCall, headers);
                    ) {
            argThat(status -> status.getCode() == Status.Code.INTERNAL && status.getDescription().contains("Last failure")),
                    @Override
                        ServerCallHandler<ReqT, RespT> next
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
        chain.interceptCall(mockCall, headers, mockHandler);
                return order;
        verify(mockCall).close(
    // =============================================
    private OrderedGrpcInterceptor createTestInterceptor(int order, boolean shouldFail, String errorMessage) {
        List<OrderedGrpcInterceptor> interceptors = Arrays.asList(
            createOrderTrackingInterceptor(10, executionOrder),
            }
            eq(headers)
                return new ServerInterceptor() {
                    }
                        ServerCallHandler<ReqT, RespT> next
        interceptors.sort((a, b) -> Integer.compare(a.order(), b.order()));
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                        ServerCall<ReqT, RespT> call,
        );
    // =============================================
    public void testNullInterceptorList() {
    public void testSingleSuccessfulInterceptor() {
    public void testInterceptorThrowsStatusRuntimeExceptionUnauthenticated() {
                return order;
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
     */
            }
        chain.interceptCall(mockCall, headers, mockHandler);
                            throw new RuntimeException(errorMessage);
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider.OrderedGrpcInterceptor;
        // Failure scenario
            }
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
            "Test failure"
import static org.mockito.Mockito.verify;
                        Metadata headers,
        verify(mockCall).close(
                argThat(status -> status.getCode() == Status.Code.INTERNAL && status.getDescription().contains(expectedErrorMessage)),
    @Mock
                    @Override
        verify(mockCall).close(
                    ) {
            public ServerInterceptor getInterceptor() {
            createTestInterceptor(10, true, "First failure"),
            createTestInterceptor(10, false, null),
            );
        );
    }
    /**
import static org.mockito.ArgumentMatchers.any;
 * SPDX-License-Identifier: Apache-2.0
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
        chain.interceptCall(mockCall, headers, mockHandler);
    public void testChainWithPattern(List<OrderedGrpcInterceptor> interceptors, boolean expectSuccess, String expectedErrorMessage) {
        );
            createTestInterceptor(10, false, null),
            chain.interceptCall(mockCall, headers, mockHandler);
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
        };
                };
            verify(mockCall).close(
import java.util.Arrays;
        verify(mockCall, never()).close(any(Status.class), any(Metadata.class));
    }
                        Metadata headers,
        super.setUp();
        );
    public void testEmptyChain() {
 * compatible open source license.
                };
import org.opensearch.test.OpenSearchTestCase;
            }
