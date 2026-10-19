     * Test interceptor provider that validates GrpcInterceptorProvider's access to settings.
            IllegalArgumentException.class,
        assertEquals("Should have 1 query converter loaded", 1, newPlugin.getQueryConverters().size());
                public int order() {
        // Create a new plugin instance
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
    /**
    }
                public ServerInterceptor getInterceptor() {
import org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport;
        ServerCall<String, String> mockCall = Mockito.mock(ServerCall.class);
        private final String message;
        }
        assertDoesNotThrow(() -> plugin.createComponents(client, null, threadPool, null, null, null, validEnv, null, null, null, null));
                assertNotNull("Should have closed status", closedStatus.get());
        // loadExtensions should succeed
        // Create a new plugin instance without initializing the client
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
        assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
import io.grpc.BindableService;
            ServerCallHandler<ReqT, RespT> next
    // Test cases for actual request processing with interceptors
        Mockito.verify(mockConverter, Mockito.atLeast(2)).getHandledAggregationType();
    }
                    @Override
        assertEquals("Rate limit service down", thrown.getMessage());
            runnable.run();
            // For failure cases, the call should be closed
            "Request should succeed when interceptor succeeds"
            expectThrows(expectedException, () -> plugin.loadExtensions(mockLoader));
        // Expect a RuntimeException when client is null
            final ServerCallHandler<String, String> nextHandler = currentHandler;
        );
        ServerCall.Listener<String> mockListener = Mockito.mock(ServerCall.Listener.class);
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
        GrpcPlugin newPlugin = new GrpcPlugin();
        try {
                    return new ServerInterceptor() {
    }
     * Helper method to test GrpcInterceptorChain behavior
        assertTrue(transport instanceof Netty4GrpcServerTransport);
        AggregateProtoConverter mockConverter = Mockito.mock(AggregateProtoConverter.class);
        List<OrderedGrpcInterceptor> interceptors = List.of(
        );
        Metadata headers = new Metadata();
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
    }
import java.util.Map;
            // Success case - continue to next interceptor/handler
import org.opensearch.transport.grpc.interceptor.GrpcInterceptorChain;
        assertTrue(transport instanceof SecureNetty4GrpcServerTransport);
     */
    @Mock
        testRequestProcessing(
        GrpcPlugin plugin = new GrpcPlugin();
        );
        } catch (RuntimeException e) {
        when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(List.of(mockProvider));
            SecurityException.class,
            List<OrderedGrpcInterceptor> interceptors = orders.stream()
                new TestRequestInterceptor(2, false, "Rate limit exceeded"), // Fails here
        Map<String, Supplier<AuxTransport>> transports = plugin.getSecureAuxTransports(
import org.opensearch.protobufs.QueryContainer;
    };
import java.util.stream.Collectors;
        when(mockLoader.loadExtensions(GrpcServiceFactory.class)).thenReturn(List.of(new LoadableMockServiceFactory()));
            clusterSettings,
        String errorMessage = exception.getMessage();
        Settings settings = Settings.builder().put(SETTING_GRPC_PORT.getKey(), "9200-9300").build();
        );
import org.opensearch.search.aggregations.metrics.InternalMax;
     * @param expectedException Expected exception class (null if no exception expected)
        ServerCall<String, String> mockCall = Mockito.mock(ServerCall.class);
                new TestRequestInterceptor(1, true, "Auth passed"),
            }
        GrpcPlugin newPlugin = new GrpcPlugin();
        // setRegistry called in: createComponents manual injection, registerConverter, updateRegistryOnAllConverters
import java.util.List;
    private NetworkService networkService;
import java.util.Comparator;
                        ServerCall<ReqT, RespT> call,
        testGrpcInterceptorChain(interceptors, true, null);
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
            @Override
            null, // NamedXContentRegistry
        private final int order;
        assertEquals("Third", executionOrder.get(2));
        // Verify that the external converter was registered by checking it was called
    public void testGetSecureAuxTransportsWithServiceFactories() {
        // Should throw exception due to duplicate orders during createComponents
            settings,
    }
        assertEquals(2, newPlugin.getQueryConverters().size());
            createTestInterceptor(20, true),  // Failure
        // Verify execution order
    public void testGetQueryUtilsAfterCreateComponents() {
        // Set up the mock loader to return null
    }
        when(mockLoader.loadExtensions(GrpcServiceFactory.class)).thenReturn(List.of(new LoadableMockServiceFactory()));
        when(mockLoader.loadExtensions(AggregateProtoConverter.class)).thenReturn(null);
                    ) {
            null, // ResourceWatcherService
        GrpcPlugin newPlugin = new GrpcPlugin();
import org.opensearch.test.OpenSearchTestCase;
        IllegalArgumentException exception = expectThrows(
        // Need to call createComponents to actually initialize the chain
                    return 100;
    /**
        newPlugin.loadExtensions(mockLoader);
        when(mockConverter.getHandledAggregationCase()).thenReturn(AggregationContainer.AggregationContainerCase.MIN);
    private static class TestExceptionThrowingInterceptor implements ServerInterceptor {
        testInterceptorLoading(List.of(1, 2), null); // Runtime failures don't affect loading
            when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(List.of(mockProvider));
            getServerClientAuthNone(),
        List<List<Integer>> providerOrders,
        assertEquals("Query utils not initialized. Make sure createComponents has been called.", exception.getMessage());
        // Create a new plugin instance
        TestSettingsAwareInterceptorProvider provider = new TestSettingsAwareInterceptorProvider();
                tracer
    }
                        return next.startCall(call, headers);
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
     * Test interceptor loading with multiple providers
    }
     * Test request processing with exception throwing interceptor
                return new ServerInterceptor() {
import io.grpc.ServerCall;
            @Override
                return order;
        // Add the mock converter to the plugin
            RuntimeException.class,
    /**
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_KEEPALIVE_TIMEOUT;
        when(mockThreadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
import org.opensearch.env.Environment;
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider.OrderedGrpcInterceptor;
import static org.mockito.Mockito.when;
        plugin.loadExtensions(mockLoader);
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);
            });
        GrpcPlugin newPlugin = new GrpcPlugin();
        when(mockLoader.loadExtensions(AggregateProtoConverter.class)).thenReturn(List.of(mockAggregateConverter));
    public void testCreateComponentsWithExternalAggregateConverters() {
import java.util.function.Supplier;
import org.opensearch.common.network.NetworkService;
        AuxTransport transport = transports.get(GRPC_TRANSPORT_SETTING_KEY).get();
        GrpcPlugin plugin = new GrpcPlugin();
            Settings.EMPTY,
        Mockito.verify(mockAggConverter, Mockito.times(3)).setRegistry(Mockito.any());
            } else {
        @SuppressWarnings("unchecked")
    }
        GrpcPlugin newPlugin = new GrpcPlugin();
            null, // IndexNameExpressionResolver
        Settings emptySetting = Settings.builder().build();
                @Override
    private OrderedGrpcInterceptor createMockInterceptor(int order) {
        QueryBuilderProtoConverter mockConverter = Mockito.mock(QueryBuilderProtoConverter.class);
        assertTrue("SETTING_GRPC_HOST should be included", settings.contains(SETTING_GRPC_HOST));
        Mockito.verify(mockAggregateConverter).getHandledAggregationType();
    public void testLoadExtensionsWithGrpcInterceptors() {
import java.util.ArrayList;
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONNECTION_IDLE;
        when(mockLoader.loadExtensions(AggregationBuilderProtoConverter.class)).thenReturn(List.of(mockAggConverter));
        when(extensionLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(List.of(mockConverter));
    private void testRequestProcessing(List<TestRequestInterceptor> interceptors, boolean shouldSucceed, String description) {
        Mockito.doReturn(InternalMax.class).when(mockConverter).getHandledAggregationType();
    public void testLoadExtensionsWithSameExplicitOrderInterceptors() {
        newPlugin.loadExtensions(mockLoader);
                            ServerCall<ReqT, RespT> call,
        // Sort them as GrpcPlugin would
                @Override
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
        GrpcPlugin newPlugin = new GrpcPlugin();
        ServerCall<String, String> mockCall = Mockito.mock(ServerCall.class);
            callClosed.set(true);
            networkService,
    public void testGrpcInterceptorChainIntegrationWithPlugin() {
        List<QueryBuilderProtoConverter> mockConverters = new ArrayList<>();
     * Test interceptor that simulates request processing with success/failure
        plugin.createComponents(
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        );
        ServerCall.Listener<String> mockListener = Mockito.mock(ServerCall.Listener.class);
        List<Setting<?>> settings = plugin.getSettings();
     */
        newPlugin.loadExtensions(mockLoader);
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);
                        }
        // Test that exceptions in interceptor chain stop processing
            if (message.contains("Security")) {
        if (orders == null) {
        @SuppressWarnings("unchecked")
                        ServerCallHandler<ReqT, RespT> next
import java.util.concurrent.atomic.AtomicReference;
    /**
        when(mockProvider.getOrderedGrpcInterceptors(Mockito.any())).thenReturn(interceptors);
        // Mock ThreadPool/ThreadContext/Environment
            List.of(
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
        ExtensiblePlugin.ExtensionLoader mockLoader = createMockLoader(List.of(1, 1));
    private ClusterSettings clusterSettings;
        // Verify that the supplier returns a Netty4GrpcServerTransport instance
        String errorMessage = exception.getMessage();
        Exception thrown = expectThrows(
    public void testGetAuxTransports() {
                        ServerCallHandler<ReqT, RespT> next
            public int order() {
        );
    public void testGetSettings() {
            // Simulate request processing logic
                            ServerCallHandler<ReqT, RespT> next
            new TestExceptionThrowingInterceptor(1, "Security check failed"),
    }
            networkService,
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
            null, // ScriptService
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_HOST;
        }
            currentHandler = new ServerCallHandler<String, String>() {
    }
        );
        assertNotNull("QueryUtils should be initialized", newPlugin.getQueryUtils());
        }).collect(Collectors.toList());
        ServerCall<String, String> mockCall = Mockito.mock(ServerCall.class);
        when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(List.of(provider));
        // getHandledAggregationType() called in: loadExtensions logging, createComponents logging
        }
            "Request should succeed when all interceptors succeed"
        }
                .map(order -> createMockInterceptor(order))
        assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
        // Call loadExtensions
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
        ServerCallHandler<String, String> mockHandler = Mockito.mock(ServerCallHandler.class);
                public ServerCall.Listener<String> startCall(ServerCall<String, String> call, Metadata headers) {
        GrpcPlugin newPlugin = new GrpcPlugin();
        if (shouldSucceed) {
        // createComponents initializes interceptor with the correct setting
        );
    public void testGetQueryUtilsBeforeCreateComponents() {
        TestExceptionThrowingInterceptor throwingInterceptor = new TestExceptionThrowingInterceptor(2, "Rate limit service down");
        plugin.loadExtensions(mockLoader);
            null, // Environment
     */
        List<String> executionOrder = new ArrayList<>();
                        }
            ServerCall<ReqT, RespT> call,
                        Metadata headers,
    }
            this.order = order;
                };
        Mockito.verify(mockConverter, Mockito.times(2)).setRegistry(Mockito.any());
    public void testGrpcInterceptorChainEmptyList() {
            List.of(
            clusterSettings,
        // Create a new plugin instance without calling createComponents
                circuitBreakerService,
            tracer
            tracer
        } else {
    public void testMultipleInterceptorsWithEarlyFailure() {
            true,
                    @Override
        plugin.loadExtensions(mockLoader);
            null, // IndexNameExpressionResolver
        GrpcPlugin newPlugin = new GrpcPlugin();
            null, // NamedWriteableRegistry
        // Load extensions first
        // Mock Environments
        // Request-side: setRegistry (manual + registerConverter + updateRegistryOnAllConverters)
    }
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
    private void testInterceptorLoadingWithMultipleProviders(
                        if (shouldFail) {
        // Call createComponents
            mockThreadPool, // ThreadPool
        when(mockThreadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
                @Override
        );
        Collection<Object> components = newPlugin.createComponents(
        assertTrue("SETTING_GRPC_PUBLISH_HOST should be included", settings.contains(SETTING_GRPC_PUBLISH_HOST));
    public void testGetAuxTransportsWithServiceFactories() {
        GrpcInterceptorProvider prov = threadContext -> List.of();
                clusterSettings,
        }
        private final String message;
                        ServerCall<ReqT, RespT> call,
        );
                    return;
    }
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
    @Mock
        }
    public void testMultipleInterceptorsRequestProcessing() {
import java.util.Collection;
        // Verify that no converters were loaded
        newPlugin.createComponents(client, null, mockThreadPool, null, null, null, null, null, null, null, null);
        private final boolean shouldSucceed;
        testGrpcInterceptorChain(interceptors, true, null);
            createTestInterceptor(20, false),
        if (expectedException != null) {
        Metadata headers = new Metadata();
        // Verify error message includes order value and interceptor class names
            }
        // Test that plugin validation catches duplicate orders
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> newPlugin.getQueryUtils());
        public int getOrder() {
    }
        when(mockConverter.getHandledQueryCase()).thenReturn(QueryContainer.QueryContainerCase.MATCH_ALL);
    private OrderedGrpcInterceptor createTestInterceptorWithCallback(int order, List<String> executionOrder, String name) {
        // setRegistry called in: registerConverter, updateRegistryOnAllConverters
        TestExceptionThrowingInterceptor interceptor,
    }
    // ===========================================
        // Verify that the converters were loaded
        // Create a mock converter
        when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(providers);
        ) {
        try {
        Settings invalidSetting = Settings.builder().put("test-setting", false).build();
            null, // NodeEnvironment
    // Generic helper methods for cleaner, more maintainable tests
        when(mockHandler.startCall(Mockito.any(), Mockito.any())).thenReturn(mockListener);
        );
import org.opensearch.transport.grpc.spi.GrpcServiceFactory;
        assertEquals("Should return 13 settings", 13, settings.size());
            null, // ResourceWatcherService
        );
            };
            clusterSettings,
        // Create a new plugin instance
            fail("Expect test interceptor with wrong settings throws exception.");
        List<OrderedGrpcInterceptor> interceptors = List.of(
        @SuppressWarnings("unchecked")
import io.grpc.protobuf.services.HealthStatusManager;
    }
        assertTrue("Should contain GRPC_TRANSPORT_SETTING_KEY", transports.containsKey(GRPC_TRANSPORT_SETTING_KEY));
            }
        );
        } else {
        newPlugin.loadExtensions(mockLoader);
            null, // Environment
        ServerCallHandler<String, String> mockHandler = Mockito.mock(ServerCallHandler.class);
    public void testGetAuxTransportsWithNullClient() {
                            return next.startCall(call, headers);
import org.opensearch.common.util.concurrent.ThreadContext;
            assertNotNull("Should return a listener for successful chain", result);
        when(invalidEnv.settings()).thenReturn(invalidSetting);
                };
        assertFalse("Call should not be closed for success case", callClosed.get());
        // Use real instances instead of mocks for final classes
        );
            when(provider.getOrderedGrpcInterceptors(Mockito.any())).thenReturn(interceptors);
     * TestSettingsAwareInterceptorProvider will throw an exception if setting "test-setting" is not true.
    }
                if (!shouldSucceed) {
        // Track if call.close() was called (indicates failure)
        @Override
        IllegalArgumentException exception = expectThrows(
            createTestInterceptorWithCallback(30, executionOrder, "Third"),
            () -> plugin.createComponents(client, null, mockThreadPool, null, null, null, environment, null, null, null, null)
    }
    private static class TestRequestInterceptor implements ServerInterceptor {
        Environment emptyEnv = Mockito.mock(Environment.class);
                .collect(Collectors.toList());
            createTestInterceptor(10, false),
            assertNotNull(result);
        AuxTransport transport = transports.get(GRPC_SECURE_TRANSPORT_SETTING_KEY).get();
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        RuntimeException exception = expectThrows(
    public void testLoadExtensionsWithNullGrpcInterceptorProviders() {
            return order;
        AggregationBuilderProtoConverter mockAggConverter = Mockito.mock(AggregationBuilderProtoConverter.class);
        Settings settings = Settings.builder().put(SETTING_GRPC_SECURE_PORT.getKey(), "9200-9300").build();
    public void testGetSecureAuxTransportsWithNullClient() {
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(mockConverters);
            null, // ResourceWatcherService
    /**
            settings,
        // getHandledAggregationCase() called in: loadExtensions logging, createComponents logging, SPI registerConverter
import org.mockito.Mockito;
        try {
        @SuppressWarnings("unchecked")
                        @Override
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.GRPC_TRANSPORT_SETTING_KEY;
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_EXECUTOR_COUNT;
        when(mockConverter.fromProto(Mockito.anyString(), Mockito.any())).thenReturn(new MinAggregationBuilder("external_min"));
            ServerCallHandler<ReqT, RespT> next
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;
     */
            Metadata headers,
     */
    /**
        );
        assertTrue("Should contain GRPC_TRANSPORT_SETTING_KEY", transports.containsKey(GRPC_TRANSPORT_SETTING_KEY));
     * @param orders List of interceptor orders (null for no interceptors)
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);
        when(mockLoader.loadExtensions(AggregateProtoConverter.class)).thenReturn(List.of(mockConverter));
            when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(List.of(mockProvider));
        @Override
    }
        // Should not throw exception and should load providers
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
 */
        testRequestProcessing(
        assertTrue(errorMessage.contains("Multiple gRPC interceptors have the same order value [1]"));
        mockConverters.add(Mockito.mock(QueryBuilderProtoConverter.class));
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
            return next.startCall(call, headers);
        AggregationBuilderProtoConverter mockConverter = Mockito.mock(AggregationBuilderProtoConverter.class);
        GrpcPlugin newPlugin = new GrpcPlugin();
    private GrpcPlugin plugin;
        assertTrue("SETTING_GRPC_MAX_CONNECTION_IDLE should be included", settings.contains(SETTING_GRPC_MAX_CONNECTION_IDLE));
        assertTrue(errorMessage.contains("Multiple gRPC interceptors have the same order value [5]"));
        );
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_WORKER_COUNT;
    }
        } else {
        assertNotNull("QueryUtils should be initialized", newPlugin.getQueryUtils());
import org.opensearch.threadpool.ThreadPool;
            null, // ScriptService
                    }
            fail("Expect test interceptor with empty settings throws exception.");
     * Test actual request processing with interceptors
            this.shouldSucceed = shouldSucceed;
            } else if (message.contains("Rate limit")) {
            public int order() {
    }
        when(mockLoader.loadExtensions(AggregationBuilderProtoConverter.class)).thenReturn(null);
     */
                }
        testGrpcInterceptorChain(interceptors, true, null);
            IllegalArgumentException.class,
import org.junit.Before;
        // Verify that the queryUtils instance was created and is available
        GrpcPlugin newPlugin = new GrpcPlugin();
        // Test that getQueryUtils throws IllegalStateException when queryUtils is not initialized
            assertTrue("Call should be closed for failed chain", callClosed.get());
            threadPool,
            }
        ServerCallHandler<String, String> mockHandler = Mockito.mock(ServerCallHandler.class);
            null, // NamedWriteableRegistry
            return null;
        // Verify that the supplier returns a Netty4GrpcServerTransport instance
        when(mockProvider.getOrderedGrpcInterceptors(Mockito.any())).thenReturn(interceptors);
        public List<BindableService> build() {
        );
            () -> { throwingInterceptor.interceptCall(mockCall, headers, mockHandler); }
    private void testInterceptorLoading(List<Integer> orders, Class<? extends Exception> expectedException) {
    public void testGrpcInterceptorChainWithFailingInterceptor() {
        // Verify the number of settings
    // Test cases for interceptor chain failure handling
        assertTrue(errorMessage.contains("Multiple gRPC interceptors have the same order value [5]"));
                // A failure occurred - this is expected for failure test cases
                throw new SecurityException(message);
    }
        Mockito.verify(mockConverter, Mockito.times(3)).getHandledAggregationCase();
        newPlugin.createComponents(client, null, mockThreadPool, null, null, null, null, null, null, null, null);
        Mockito.doReturn(InternalMax.class).when(mockAggregateConverter).getHandledAggregationType();
    }
    // Test cases for gRPC interceptor functionality
        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        assertTrue(errorMessage.contains("Each interceptor must have a unique order value"));
     */
        // Verify converters were discovered during loadExtensions
    private void assertDoesNotThrow(Runnable runnable) {
            if (!shouldSucceed) {
            "SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS should be included",
        // createComponents throws exception with empty setting
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
            "Security check failed"
    public void testInterceptorRequestProcessingWithFailure() {
        // Mock ThreadPool for createComponents
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS;
        // createComponents should fail with duplicate order
     * Test interceptor that throws exceptions during request processing
            circuitBreakerService,
            public ServerInterceptor getInterceptor() {
        );
                            Metadata headers,
        Mockito.verify(mockConverter, Mockito.times(3)).setRegistry(Mockito.any());
            )
        when(mockLoader.loadExtensions(AggregateProtoConverter.class)).thenReturn(List.of(mockAggregateConverter));
        newPlugin.loadExtensions(mockLoader);
                new TestRequestInterceptor(3, true, "Validation passed")     // Should not execute
                            throw new RuntimeException("Test failure");
        AtomicBoolean callClosed = new AtomicBoolean(false);
    private ExtensiblePlugin.ExtensionLoader createMockLoaderWithMultipleProviders(List<List<Integer>> providerOrders) {
    @Mock
            () -> plugin.createComponents(client, null, mockThreadPool, null, null, null, environment, null, null, null, null)
        Mockito.verify(mockConverter, Mockito.times(2)).setRegistry(Mockito.any());
            fail("Expected no exception, but got: " + e.getMessage());
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
import io.grpc.ServerCallHandler;
        assertNotNull("QueryUtils should be initialized after createComponents", newPlugin.getQueryUtils());
    }
        }
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_HOST;
            // If we reach here, the interceptor succeeded
        newPlugin.loadExtensions(mockLoader);
        public List<OrderedGrpcInterceptor> getOrderedGrpcInterceptors(ThreadContext threadContext) {
     * Creates a mock extension loader with multiple providers
        private final int order;
            return List.of(new HealthStatusManager().getHealthService());
        assertTrue(expectedExceptionType.isInstance(thrown));
    }
import static org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport.GRPC_SECURE_TRANSPORT_SETTING_KEY;
        AtomicReference<Status> closedStatus = new AtomicReference<>();
        testGrpcInterceptorChain(interceptors, false, "Test failure");
    /**
    private void testRequestProcessingWithException(
 * SPDX-License-Identifier: Apache-2.0
        when(mockThreadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
    }
        // Call loadExtensions
    /**
            false,
        assertEquals("Second", executionOrder.get(1));
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
        public LoadableMockServiceFactory() {}
            assertFalse("Call should not be closed for successful chain", callClosed.get());
        // Note: setRegistry is called 2 times:
/*
        List<OrderedGrpcInterceptor> interceptors = List.of(createTestInterceptor(10, false), createTestInterceptor(20, false));
                        return next.startCall(call, headers);
    }
        GrpcPlugin plugin = new GrpcPlugin();
        Environment invalidEnv = Mockito.mock(Environment.class);
            @Override
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider;
    }
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
    }
        );
        @Override
        if (expectedException != null) {
            assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
        // Execute the chain
    }
            "Request should fail when interceptor fails"
     */
        // Create a mock converter that will be registered
    public void setup() {
            List.of(new TestRequestInterceptor(1, true, "Auth check passed")),
            }
    }
            null, // ScriptService
            RuntimeException.class,
        // Create a mock extension loader that returns the converter
    }
            ),
        String errorMessage = exception.getMessage();
            if (expectedErrorMessage != null) {
        return new OrderedGrpcInterceptor() {
            RuntimeException.class,
        @SuppressWarnings("unchecked")
            client,
 *
        testInterceptorLoading(List.of(1, 2), null);
        // 1. In loadExtensions() for logging
        // Test that GrpcPlugin correctly creates and uses GrpcInterceptorChain
                    }
                getServerClientAuthNone(),
}
        // Create mock server call and handler
        GrpcPlugin plugin = new GrpcPlugin();
    }
            null, // NamedWriteableRegistry
            ),
        testRequestProcessing(
        }
        Mockito.verify(mockAggConverter).getHandledAggregationCase();
        } else if (orders.isEmpty()) {
    @Mock
        plugin = new GrpcPlugin();
        Environment validEnv = Mockito.mock(Environment.class);
        );
            assertEquals("test-setting not found or not set to true", e.getMessage());
        public TestExceptionThrowingInterceptor(int order, String message) {
                return new ServerInterceptor() {
            Mockito.mock(SecureAuxTransportSettingsProvider.class),
                networkService,
            return List.of(new OrderedGrpcInterceptor() {
            null  // Supplier<RepositoriesService>
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        Settings settings = Settings.builder().put(SETTING_GRPC_PORT.getKey(), "9200-9300").build();
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONNECTION_AGE;
        }
    public void testLoadExtensionsWithEmptyGrpcInterceptorList() {
    }
            List<OrderedGrpcInterceptor> interceptors = orders.stream().map(this::createMockInterceptor).collect(Collectors.toList());
                        executionOrder.add(name);
        GrpcPlugin plugin = new GrpcPlugin();
        testRequestProcessingWithException(
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
            if (callClosed.get()) {
                }; // Empty listener for failed call
                    ) {
            assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
            Metadata headers,
     * Creates a no-op interceptor with the specified order.
    }
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            this.message = message;
        }
        MockitoAnnotations.openMocks(this);
    /**
        assertEquals(3, executionOrder.size());
            // Simulate different types of exceptions that can occur during request processing
            @Override
     */
            threadPool,
    /**
        assertDoesNotThrow(() -> prov.initNodeSettings(Settings.EMPTY));
            circuitBreakerService,
    public void testLoadExtensionsWithNullExtensions() {
        newPlugin.createComponents(Mockito.mock(Client.class), null, mockThreadPool, null, null, null, null, null, null, null, null);
    private OrderedGrpcInterceptor createTestInterceptor(int order, boolean shouldFail) {
        }
    }
    private static class TestSettingsAwareInterceptorProvider implements GrpcInterceptorProvider {
import org.opensearch.transport.client.Client;
        @SuppressWarnings("unchecked")
                    @Override
        assertNotNull("QueryUtils should not be null after createComponents", plugin.getQueryUtils());
    }
    private ExtensiblePlugin.ExtensionLoader extensionLoader;
                assertTrue(
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_BIND_HOST;
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
        // Verify that the transport map contains the expected key
        } catch (Exception e) {
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
        // Call createComponents to trigger registration of external converters
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);
        ExtensiblePlugin.ExtensionLoader mockLoader = createMockLoader(List.of(5, 5));
            // Check if the call was closed (indicating failure)
            GrpcInterceptorProvider mockProvider = Mockito.mock(GrpcInterceptorProvider.class);
        // Verify that all expected settings are returned
        @Override
        // Verify that the queryUtils instance was created and is available
    private ThreadPool threadPool;
    public void testLoadExtensionsWithGrpcInterceptorsOrdering() {
            }
    @Mock
                    // This is expected - test passes
        when(mockAggConverter.getHandledAggregationCase()).thenReturn(AggregationContainer.AggregationContainerCase.MIN);
        interceptors = new ArrayList<>(interceptors);
        GrpcInterceptorProvider mockProvider = Mockito.mock(GrpcInterceptorProvider.class);
    public void testLoadExtensionsWithDuplicateGrpcInterceptorOrder() {
        assertTrue("SETTING_GRPC_PUBLISH_PORT should be included", settings.contains(SETTING_GRPC_PUBLISH_PORT));
            fail("Expected failure but all interceptors succeeded");
            this.order = order;
        AuxTransport transport = transports.get(GRPC_TRANSPORT_SETTING_KEY).get();
        @Override
        GrpcPlugin newPlugin = new GrpcPlugin();
            return "MockHealthServicePluginServiceFactory";
    }
                }
    }
            createTestInterceptor(10, false),
        Mockito.verify(mockAggregateConverter, Mockito.times(2)).setRegistry(Mockito.any());
    @Mock
        }
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthNone;
                } else {
        assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
    // ===========================================
            () -> newPlugin.getSecureAuxTransports(
        }
                        Metadata headers,
 * The OpenSearch Contributors require contributions made to
                    return result;
        // Create a mock extension loader
            plugin.createComponents(client, null, threadPool, null, null, null, invalidEnv, null, null, null, null);
        assertTrue("SETTING_GRPC_PORT should be included", settings.contains(SETTING_GRPC_PORT));
        ExtensiblePlugin.ExtensionLoader mockLoader = createMockLoaderWithMultipleProviders(List.of(List.of(5), List.of(5)));
                settings,
        when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(List.of(mockProvider));
        // 2. In updateRegistryOnAllConverters() to ensure all converters have the complete registry
        AggregationBuilderProtoConverter mockAggConverter = Mockito.mock(AggregationBuilderProtoConverter.class);
     * Generic interceptor loading test helper
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
 * compatible open source license.
import static org.mockito.Mockito.doAnswer;
                        ServerCallHandler<ReqT, RespT> next
        public String plugin() {
        // Mock ThreadPool for createComponents
        GrpcPlugin newPlugin = new GrpcPlugin();
                    };
        mockConverters.add(Mockito.mock(QueryBuilderProtoConverter.class));
                        return next.startCall(call, headers);
    /**
        networkService = new NetworkService(List.of());
            }
import org.opensearch.common.settings.Setting;
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
        for (TestRequestInterceptor interceptor : interceptors) {
    }
        // Track if call.close() was called
        GrpcInterceptorProvider mockProvider = Mockito.mock(GrpcInterceptorProvider.class);
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(List.of(mockConverter));
            IllegalArgumentException.class,
        @SuppressWarnings("unchecked")
            environment, // Environment
        assertTrue(thrown.getMessage().contains(expectedMessage));
        Collection<Object> components = newPlugin.createComponents(
        }
        Map<String, Supplier<AuxTransport>> transports = plugin.getAuxTransports(
        testRequestProcessing(
        return new OrderedGrpcInterceptor() {
        // 3. In QueryBuilderProtoConverterSpiRegistry.registerConverter() for registration
        assertTrue("Should return a Netty4GrpcServerTransport instance", transport instanceof Netty4GrpcServerTransport);
    }
        newPlugin.loadExtensions(mockLoader);
        assertEquals(0, newPlugin.getQueryConverters().size());
            if (settings == null || !settings.getAsBoolean("test-setting", false)) {
        }
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);
            circuitBreakerService,
    public void testLoadExtensions() {
    }
            expectThrows(expectedException, () -> plugin.loadExtensions(mockLoader));
    }
        testInterceptorLoading(List.of(), null);
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
            public ServerInterceptor getInterceptor() {
        QueryBuilderProtoConverter mockConverter = Mockito.mock(QueryBuilderProtoConverter.class);
        GrpcPlugin plugin = new GrpcPlugin();
                        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        Metadata headers = new Metadata();
    public void testCreateComponents() {
            client,
        // Expect a RuntimeException when client is null
        when(mockAggConverter.getHandledAggregationCase()).thenReturn(AggregationContainer.AggregationContainerCase.MIN);
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        newPlugin.createComponents(Mockito.mock(Client.class), null, mockThreadPool, null, null, null, null, null, null, null, null);
        assertTrue(errorMessage.contains("Each interceptor must have a unique order value"));
            threadPool,
        ExtensiblePlugin.ExtensionLoader mockLoader = createMockLoaderWithMultipleProviders(providerOrders);
            return null;
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_PORT;
     * Creates a test interceptor that tracks execution order
 * this file be licensed under the Apache-2.0 license or a
import io.grpc.ServerInterceptor;
        when(validEnv.settings()).thenReturn(validSetting);
        // If we reach here and shouldSucceed is false, the test failed to fail as expected
            GrpcInterceptorProvider provider = Mockito.mock(GrpcInterceptorProvider.class);
                    closedStatus.get().getDescription().contains(expectedErrorMessage)
                    fail("Unexpected failure in success test case");
import org.opensearch.transport.AuxTransport;
            null, // NamedXContentRegistry
                        ServerCall<ReqT, RespT> call,
    }
        GrpcPlugin plugin = new GrpcPlugin();
        RuntimeException exception = expectThrows(
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;
                return order;
        // Verify that setRegistry was called to inject the registry
    ) {
        // Response-side: setRegistry (registerConverter + updateRegistryOnAllConverters)
    public void testLoadExtensionsWithNullAggregationConverters() {
        assertTrue("SETTING_GRPC_MAX_CONNECTION_AGE should be included", settings.contains(SETTING_GRPC_MAX_CONNECTION_AGE));
    }
        assertEquals("First", executionOrder.get(0));
    public void testCreateComponentsWithBothExternalConverters() {
            when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(null);
        // Create a new plugin instance without initializing the client
            public int order() {
            }
                throw new RuntimeException("test-setting not found or not set to true");
        );
            networkService,
        IllegalArgumentException exception = expectThrows(
        assertTrue("SETTING_GRPC_KEEPALIVE_TIMEOUT should be included", settings.contains(SETTING_GRPC_KEEPALIVE_TIMEOUT));
        when(mockThreadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
     */
            settings.contains(SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS)
            }
    }
            createTestInterceptor(10, false), // Success
            List.of(new TestRequestInterceptor(1, false, "Auth failed")),
        testInterceptorLoading(List.of(3, 1, 2), null); // Out of order - should be sorted
                // Fail the request with proper gRPC status
        // Set up the mock loader to return the mock converters
    public void testInterceptorChainExceptionPropagation() {
        ExtensiblePlugin.ExtensionLoader mockLoader = createMockLoader(orders);
            null, // ClusterService
    /**
            IllegalArgumentException.class,
        return new OrderedGrpcInterceptor() {
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
            }
        Exception thrown = expectThrows(Exception.class, () -> { interceptor.interceptCall(mockCall, headers, mockHandler); });
            () -> plugin.createComponents(client, null, mockThreadPool, null, null, null, environment, null, null, null, null)
            () -> plugin.createComponents(client, null, mockThreadPool, null, null, null, environment, null, null, null, null)
        assertTrue("SETTING_GRPC_BIND_HOST should be included", settings.contains(SETTING_GRPC_BIND_HOST));
        assertTrue("Should contain GRPC_SECURE_TRANSPORT_SETTING_KEY", transports.containsKey(GRPC_SECURE_TRANSPORT_SETTING_KEY));
    public void testInterceptorRequestProcessingWithSuccess() {
        // Verify the converter was added to the queryConverters list
            GrpcInterceptorProvider mockProvider = Mockito.mock(GrpcInterceptorProvider.class);
    public void testGrpcInterceptorProviderEmpty() {
package org.opensearch.transport.grpc;
        @SuppressWarnings("unchecked")
        assertTrue("SETTING_GRPC_MAX_MSG_SIZE should be included", settings.contains(SETTING_GRPC_MAX_MSG_SIZE));
            // Create a new handler for the next interceptor that continues the chain
        public TestRequestInterceptor(int order, boolean shouldSucceed, String message) {
            client,
        doAnswer(invocation -> {
            when(mockProvider.getOrderedGrpcInterceptors(Mockito.any())).thenReturn(interceptors);
        assertDoesNotThrow(
        return mockLoader;
            ServerCall<ReqT, RespT> call,
        GrpcPlugin newPlugin = new GrpcPlugin();
            clusterSettings,
import org.opensearch.common.settings.Settings;
    private Environment environment;
import org.mockito.MockitoAnnotations;
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        Class<? extends Exception> expectedExceptionType,
    public void testGrpcInterceptorChainWithSuccessfulInterceptors() {
                            // No-op interceptor - just pass through
        newPlugin.createComponents(client, null, mockThreadPool, null, null, null, null, null, null, null, null);
            ServerCall.Listener<String> result = interceptor.interceptCall(mockCall, headers, nextHandler);
     */
            null, // NamedXContentRegistry
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
public class GrpcPluginTests extends OpenSearchTestCase {
    public void testLoadExtensionsWithAggregationConverters() {
        }
            assertEquals("test-setting not found or not set to true", e.getMessage());
        assertTrue(interceptors.isEmpty());
        interceptors.sort(Comparator.comparingInt(OrderedGrpcInterceptor::order));
                }
        assertTrue(errorMessage.contains("Each interceptor must have a unique order value"));
    }
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
            this.message = message;
        public int getOrder() {
    public void testCreateComponentsWithExternalConverters() {
        String expectedMessage
import io.grpc.Status;
            circuitBreakerService,
    }
        when(mockThreadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
        ServerCallHandler<String, String> mockHandler = Mockito.mock(ServerCallHandler.class);
            createTestInterceptor(10, false) // Duplicate order
    @Before
import java.util.concurrent.atomic.AtomicBoolean;
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
        Mockito.doReturn(InternalMax.class).when(mockAggregateConverter).getHandledAggregationType();
        // Mock ThreadPool for createComponents
            null, // IndexNameExpressionResolver
            createTestInterceptorWithCallback(20, executionOrder, "Second")
        assertTrue("SETTING_GRPC_EXECUTOR_COUNT should be included", settings.contains(SETTING_GRPC_EXECUTOR_COUNT));
        List<OrderedGrpcInterceptor> interceptors = List.of();
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
        assertTrue(errorMessage.contains("GrpcPluginTests"));
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);
        Metadata headers = new Metadata();
                new TestRequestInterceptor(1, true, "Auth passed"),
    }
    public void testCreateComponentsWithExternalAggregationConverters() {
            "Request should fail when any interceptor fails"
                throw new IllegalStateException(message);
     */
        // Create a list of mock converters
        assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
     * Creates a mock extension loader with interceptors of given orders
        assertNotNull("QueryUtils should be initialized after createComponents", newPlugin.getQueryUtils());
        @SuppressWarnings("unchecked")
                        Metadata headers,
                return new ServerCall.Listener<ReqT>() {
            null, // NodeEnvironment
        };
            Settings.EMPTY,
        // Note: getHandledQueryCase() is called 3 times:
        }
    public void testGrpcInterceptorChainWithDuplicateOrders() {
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
    // Test cases for GrpcInterceptorChain
    private Client client;
                };
        }
import org.mockito.Mock;
        newPlugin.loadExtensions(extensionLoader);
        ) {
        when(mockLoader.loadExtensions(AggregationBuilderProtoConverter.class)).thenReturn(List.of(mockAggConverter));
            null  // Supplier<RepositoriesService>
        assertTrue(errorMessage.contains("Each interceptor must have a unique order value"));
    }
    private static class LoadableMockServiceFactory implements GrpcServiceFactory {
     * Creates a test interceptor that can succeed or fail
                }
        GrpcPlugin plugin = new GrpcPlugin();
        assertTrue(
            public ServerInterceptor getInterceptor() {
            @Override
        assertTrue(errorMessage.contains("Multiple gRPC interceptors have the same order value [10]"));
        // Load the extensions first
            () -> newPlugin.getAuxTransports(settings, threadPool, circuitBreakerService, networkService, clusterSettings, tracer)
            callClosed.set(true);
        // Execute the interceptors in chain (simulating real gRPC behavior)
        // Create a new plugin instance
    private CircuitBreakerService circuitBreakerService;
            tracer
    ) {
import org.opensearch.protobufs.AggregationContainer;
        );
        // Mock extension loading for GrpcPlugin
        Map<String, Supplier<AuxTransport>> transports = plugin.getAuxTransports(
        Settings settings = Settings.builder().put(SETTING_GRPC_SECURE_PORT.getKey(), "9200-9300").build();
        // createComponents throws exception with the incorrect setting
        );
        when(emptyEnv.settings()).thenReturn(emptySetting);
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
        };
            createTestInterceptor(30, false)  // Should not execute
        }
        // 2. In createComponents() for logging
        private Settings settings;
    public void testGetSecureAuxTransports() {
    }
    /**
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
        AtomicBoolean callClosed = new AtomicBoolean(false);
            () -> plugin.createComponents(client, null, mockThreadPool, null, null, null, environment, null, null, null, null)
        Map<String, Supplier<AuxTransport>> transports = plugin.getSecureAuxTransports(
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
        @SuppressWarnings("unchecked")
            }
        List<OrderedGrpcInterceptor> interceptors = prov.getOrderedGrpcInterceptors(new ThreadContext(Settings.EMPTY));
        ServerCallHandler<String, String> currentHandler = mockHandler;
import io.grpc.Metadata;
    public void testLoadExtensionsWithMultipleProvidersAndDuplicateOrder() {
                threadPool,
        // Verify that the transport map contains the expected key
        } else {
        IllegalArgumentException exception = expectThrows(
            closedStatus.set(invocation.getArgument(0));
        // Create a real ClusterSettings instance with the plugin's settings
                );
                        // no-op interceptor
    private void testGrpcInterceptorChain(List<OrderedGrpcInterceptor> interceptors, boolean shouldSucceed, String expectedErrorMessage) {
                    ) {
    }
            plugin.createComponents(client, null, threadPool, null, null, null, emptyEnv, null, null, null, null);
        AuxTransport transport = transports.get(GRPC_SECURE_TRANSPORT_SETTING_KEY).get();
            threadPool, // ThreadPool (now properly mocked)
            createTestInterceptor(30, false)
            return order;
        Mockito.verify(mockConverter, Mockito.times(3)).getHandledQueryCase();
        @Override
        AggregateProtoConverter mockAggregateConverter = Mockito.mock(AggregateProtoConverter.class);
        );
                        ) {
    }
    public void testGrpcInterceptorProviderSettingsInitialization() {
        List<OrderedGrpcInterceptor> interceptors = List.of(
                    "Error message should contain expected text",
    }
        doAnswer(invocation -> {
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);
        };
import org.opensearch.telemetry.tracing.Tracer;
        assertEquals("createComponents must be called first to initialize server provided resources.", exception.getMessage());
        if (!shouldSucceed) {
            networkService,
import static org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport.SETTING_GRPC_SECURE_PORT;
            null, // ClusterService
        newPlugin.loadExtensions(mockLoader);
        String errorMessage = exception.getMessage();
        when(mockLoader.loadExtensions(AggregationBuilderProtoConverter.class)).thenReturn(List.of(mockConverter));
        when(environment.settings()).thenReturn(Settings.EMPTY);
            tracer
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
            @Override
            null  // Supplier<RepositoriesService>
        Class<? extends Exception> expectedException
        assertNotNull("QueryUtils should be initialized", newPlugin.getQueryUtils());
        when(mockAggConverter.fromProto(Mockito.anyString(), Mockito.any())).thenReturn(new MinAggregationBuilder("ext_min"));
        );
        assertEquals("createComponents must be called first to initialize server provided resources.", exception.getMessage());
                return order;
        // 1. In createComponents() when processing external converters
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PORT;
import org.opensearch.plugins.ExtensiblePlugin;
                call.close(Status.PERMISSION_DENIED.withDescription(message), new Metadata());
            createTestInterceptorWithCallback(10, executionOrder, "First"),
            false,
        assertTrue("SETTING_GRPC_SECURE_PORT should be included", settings.contains(SETTING_GRPC_SECURE_PORT));
            null, // NodeEnvironment
                    }
        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        testInterceptorLoading(null, null);
        Settings validSetting = Settings.builder().put("test-setting", true).build();
        }).when(mockCall).close(Mockito.any(Status.class), Mockito.any(Metadata.class));
                new TestRequestInterceptor(3, true, "Validation passed")
            null, // ClusterService
        clusterSettings = new ClusterSettings(Settings.EMPTY, plugin.getSettings().stream().collect(java.util.stream.Collectors.toSet()));
                return new ServerInterceptor() {
    public void testInterceptorExceptionDuringRequestPhase() {
            true,
        List<GrpcInterceptorProvider> providers = providerOrders.stream().map(orders -> {
                throw new RuntimeException(message);
        // Should not throw — null extensions are handled gracefully
        // Set the client in the plugin
import org.opensearch.common.settings.ClusterSettings;
    private ExtensiblePlugin.ExtensionLoader createMockLoader(List<Integer> orders) {
        List<OrderedGrpcInterceptor> interceptors = List.of(
        return mockLoader;
            threadPool,
    public void testInterceptorExceptionHandling() {
        }).when(mockCall).close(Mockito.any(Status.class), Mockito.any(Metadata.class));
        assertTrue("Should contain GRPC_SECURE_TRANSPORT_SETTING_KEY", transports.containsKey(GRPC_SECURE_TRANSPORT_SETTING_KEY));
            return provider;
    private Tracer tracer;
            this.settings = settings;
        // Test that getQueryUtils returns the queryUtils instance after createComponents is called
        AggregateProtoConverter mockAggregateConverter = Mockito.mock(AggregateProtoConverter.class);
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_MSG_SIZE;
        assertTrue("SETTING_GRPC_WORKER_COUNT should be included", settings.contains(SETTING_GRPC_WORKER_COUNT));
            when(mockProvider.getOrderedGrpcInterceptors(Mockito.any())).thenReturn(new ArrayList<>());
        GrpcPlugin newPlugin = new GrpcPlugin();
     */
        public void initNodeSettings(Settings settings) {
    public void testGrpcInterceptorChainOrdering() {
        assertTrue("Should return a SecureNetty4GrpcServerTransport instance", transport instanceof SecureNetty4GrpcServerTransport);
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        when(mockHandler.startCall(Mockito.any(), Mockito.any())).thenReturn(mockListener);
        // Create a mock extension loader
        // For success case, ensure call was not closed
                new TestRequestInterceptor(2, true, "Rate limit passed"),
            mockThreadPool, // ThreadPool
        plugin.loadExtensions(mockLoader);
        } catch (RuntimeException e) {
