        assertTrue(errorMessage.contains("Each interceptor must have a unique order value"));
        when(mockThreadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
        GrpcInterceptorProvider mockProvider = Mockito.mock(GrpcInterceptorProvider.class);  
        assertNotNull("QueryUtils should not be null after createComponents", plugin.getQueryUtils());
        // Mock ThreadPool/ThreadContext/Environment
        );  
            // If we reach here, the interceptor succeeded
            null, // NamedWriteableRegistry
                        // no-op interceptor  
    }
            public int order() {  
     */
                }
            null, // ScriptService  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_MSG_SIZE;
        Metadata headers = new Metadata();  
            }  
            }
        // createComponents throws exception with empty setting  
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        Map<String, Supplier<AuxTransport>> transports = plugin.getSecureAuxTransports(  
                    ) {  
            if (callClosed.get()) {
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
        newPlugin.createComponents(client, null, mockThreadPool, null, null, null, null, null, null, null, null);
        testInterceptorLoading(List.of(3, 1, 2), null); // Out of order - should be sorted  
        }
        ) {
    // Test cases for interceptor chain failure handling
        // Verify that all expected settings are returned  
        newPlugin.loadExtensions(extensionLoader);
        @SuppressWarnings("unchecked")  
    private ExtensiblePlugin.ExtensionLoader createMockLoaderWithMultipleProviders(List<List<Integer>> providerOrders) {
import org.opensearch.transport.AuxTransport;
     */  
        GrpcPlugin newPlugin = new GrpcPlugin();
    public void testLoadExtensionsWithGrpcInterceptorsOrdering() {
            }
     * Creates a mock extension loader with multiple providers
        Map<String, Supplier<AuxTransport>> transports = plugin.getSecureAuxTransports(
        }
        // Note: getHandledQueryCase() is called 3 times:  
        GrpcPlugin plugin = new GrpcPlugin();
            null, // NamedXContentRegistry
        // Verify that setRegistry was called to inject the registry  
    }
        @SuppressWarnings("unchecked")
                return order;  
        // Test that GrpcPlugin correctly creates and uses GrpcInterceptorChain
        // Create a new plugin instance
        List<OrderedGrpcInterceptor> interceptors = List.of(
        List<OrderedGrpcInterceptor> interceptors = List.of(createTestInterceptor(10, false), createTestInterceptor(20, false));  
        } else {  
        }
        ServerCallHandler<String, String> mockHandler = Mockito.mock(ServerCallHandler.class);
        when(mockThreadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));  
        GrpcInterceptorProvider mockProvider = Mockito.mock(GrpcInterceptorProvider.class);
        testRequestProcessing(  
        testGrpcInterceptorChain(interceptors, true, null);  
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
    public void testCreateComponentsWithExternalAggregateConverters() {  
    }
        try {
        when(mockProvider.getOrderedGrpcInterceptors(Mockito.any())).thenReturn(interceptors);
            assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
        // Mock extension loading for GrpcPlugin
     * Test interceptor loading with multiple providers
        GrpcPlugin newPlugin = new GrpcPlugin();
            Settings.EMPTY,
        ServerCallHandler<String, String> mockHandler = Mockito.mock(ServerCallHandler.class);
            };
    public void testGetAuxTransportsWithNullClient() {  
        // setRegistry called in: createComponents manual injection, registerConverter, updateRegistryOnAllConverters
        when(mockLoader.loadExtensions(GrpcServiceFactory.class)).thenReturn(List.of(new LoadableMockServiceFactory()));
            null, // IndexNameExpressionResolver
            return "MockHealthServicePluginServiceFactory";
        ServerCall.Listener<String> mockListener = Mockito.mock(ServerCall.Listener.class);
            if (expectedErrorMessage != null) {
    public void testLoadExtensionsWithAggregationConverters() {
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
    }
        @SuppressWarnings("unchecked")  
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);
 * compatible open source license.
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(List.of(mockConverter));
        AuxTransport transport = transports.get(GRPC_SECURE_TRANSPORT_SETTING_KEY).get();
        @Override  
                        executionOrder.add(name);
                        ServerCall<ReqT, RespT> call,
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        GrpcPlugin newPlugin = new GrpcPlugin();
            createTestInterceptorWithCallback(10, executionOrder, "First"),
    }  
    public void testLoadExtensionsWithDuplicateGrpcInterceptorOrder() {  
        assertEquals(3, executionOrder.size());  
        when(mockThreadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
        Settings emptySetting = Settings.builder().build();  
        when(mockLoader.loadExtensions(AggregateProtoConverter.class)).thenReturn(List.of(mockAggregateConverter));  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONNECTION_IDLE;  
        // Mock ThreadPool for createComponents
            @Override
        AggregationBuilderProtoConverter mockAggConverter = Mockito.mock(AggregationBuilderProtoConverter.class);
                );
    private OrderedGrpcInterceptor createTestInterceptor(int order, boolean shouldFail) {
        } catch (RuntimeException e) {
import org.opensearch.search.aggregations.metrics.InternalMax;  
            null, // ClusterService  
            createTestInterceptorWithCallback(20, executionOrder, "Second")
            // For failure cases, the call should be closed  
        // Create a real ClusterSettings instance with the plugin's settings
import org.opensearch.transport.grpc.interceptor.GrpcInterceptorChain;
        when(emptyEnv.settings()).thenReturn(emptySetting);
    ) {  
        testRequestProcessing(
            tracer
            fail("Expected no exception, but got: " + e.getMessage());  
        // Verify the number of settings  
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;  
        GrpcPlugin newPlugin = new GrpcPlugin();  
                return new ServerInterceptor() {  
            () -> plugin.createComponents(client, null, mockThreadPool, null, null, null, environment, null, null, null, null)
            assertFalse("Call should not be closed for successful chain", callClosed.get());
 * SPDX-License-Identifier: Apache-2.0
        Settings validSetting = Settings.builder().put("test-setting", true).build();
            return List.of(new HealthStatusManager().getHealthService());  
            when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(null);
        // Use real instances instead of mocks for final classes
        // Set the client in the plugin  
import static org.mockito.Mockito.doAnswer;  
        // Create a mock converter
        );  
        );
    private Client client;
        Settings settings = Settings.builder().put(SETTING_GRPC_PORT.getKey(), "9200-9300").build();
        assertEquals("createComponents must be called first to initialize server provided resources.", exception.getMessage());  
    public void testCreateComponents() {  
        );
        newPlugin.createComponents(client, null, mockThreadPool, null, null, null, null, null, null, null, null);
        }  
        GrpcPlugin newPlugin = new GrpcPlugin();
        Collection<Object> components = newPlugin.createComponents(
            // Check if the call was closed (indicating failure)  
            "Security check failed"
        Mockito.verify(mockConverter, Mockito.times(3)).setRegistry(Mockito.any());  
        GrpcPlugin newPlugin = new GrpcPlugin();
                new TestRequestInterceptor(3, true, "Validation passed")     // Should not execute  
        }
            Settings.EMPTY,
     * @param orders List of interceptor orders (null for no interceptors)
                assertNotNull("Should have closed status", closedStatus.get());  
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
    }
        assertTrue("SETTING_GRPC_HOST should be included", settings.contains(SETTING_GRPC_HOST));  
        Mockito.verify(mockAggregateConverter, Mockito.times(2)).setRegistry(Mockito.any());
    }
    }
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
            assertEquals("test-setting not found or not set to true", e.getMessage());
    public void testInterceptorRequestProcessingWithFailure() {
            IllegalArgumentException.class,
            GrpcInterceptorProvider mockProvider = Mockito.mock(GrpcInterceptorProvider.class);  
        assertTrue("Should contain GRPC_TRANSPORT_SETTING_KEY", transports.containsKey(GRPC_TRANSPORT_SETTING_KEY));  
                throw new RuntimeException(message);
            List.of(  
    public void testLoadExtensionsWithNullGrpcInterceptorProviders() {
        when(mockLoader.loadExtensions(AggregateProtoConverter.class)).thenReturn(List.of(mockAggregateConverter));  
            when(provider.getOrderedGrpcInterceptors(Mockito.any())).thenReturn(interceptors);
            @Override
    private OrderedGrpcInterceptor createTestInterceptorWithCallback(int order, List<String> executionOrder, String name) {  
        GrpcPlugin plugin = new GrpcPlugin();
                };
            Metadata headers,  
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
        ExtensiblePlugin.ExtensionLoader mockLoader = createMockLoader(List.of(1, 1));
    private ClusterSettings clusterSettings;  
            List.of(  
    public void testInterceptorChainExceptionPropagation() {  
        // Test that getQueryUtils returns the queryUtils instance after createComponents is called  
                        @Override  
                }
    }  
    }
        }
            null, // NodeEnvironment
                        ServerCall<ReqT, RespT> call,  
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);  
    /**
        }
import java.util.Comparator;
        String errorMessage = exception.getMessage();
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
            RuntimeException.class,
        Mockito.verify(mockConverter, Mockito.times(2)).setRegistry(Mockito.any());
        );
                .map(order -> createMockInterceptor(order))
        when(mockConverter.getHandledAggregationCase()).thenReturn(AggregationContainer.AggregationContainerCase.MIN);
    private NetworkService networkService;
     * Test interceptor that simulates request processing with success/failure
        newPlugin.loadExtensions(mockLoader);
            null, // NamedXContentRegistry  
            tracer
    }
import org.opensearch.plugins.ExtensiblePlugin;
        // Create a mock extension loader
            if (settings == null || !settings.getAsBoolean("test-setting", false)) {
        // Track if call.close() was called
            // Success case - continue to next interceptor/handler  
        // Should throw exception due to duplicate orders during createComponents
        );
        String errorMessage = exception.getMessage();
            null  // Supplier<RepositoriesService>
    private Environment environment;
        ServerCallHandler<String, String> mockHandler = Mockito.mock(ServerCallHandler.class);
        Mockito.verify(mockConverter, Mockito.atLeast(2)).getHandledAggregationType();
        assertTrue("SETTING_GRPC_KEEPALIVE_TIMEOUT should be included", settings.contains(SETTING_GRPC_KEEPALIVE_TIMEOUT));
        // Load extensions first
        AggregateProtoConverter mockConverter = Mockito.mock(AggregateProtoConverter.class);  
    };
        // Test that exceptions in interceptor chain stop processing
 * The OpenSearch Contributors require contributions made to  
            return next.startCall(call, headers);
        assertEquals("Should return 13 settings", 13, settings.size());
     */
        assertTrue(errorMessage.contains("Each interceptor must have a unique order value"));
        ServerCall.Listener<String> result = chain.interceptCall(mockCall, headers, mockHandler);  
    }  
                return new ServerInterceptor() {
        ServerCall<String, String> mockCall = Mockito.mock(ServerCall.class);
            callClosed.set(true);
        }  
        }  
                        Metadata headers,
            return provider;  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.GRPC_TRANSPORT_SETTING_KEY;
            networkService,
            new TestExceptionThrowingInterceptor(1, "Security check failed"),  
import org.opensearch.common.settings.Settings;
        when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(List.of(mockProvider));  
        assertEquals(2, newPlugin.getQueryConverters().size());
                circuitBreakerService,  
            } else {  
            () -> newPlugin.getAuxTransports(settings, threadPool, circuitBreakerService, networkService, clusterSettings, tracer)  
        Map<String, Supplier<AuxTransport>> transports = plugin.getAuxTransports(
        );
                return order;
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);  
            }  
        GrpcPlugin newPlugin = new GrpcPlugin();  
    public void testGrpcInterceptorProviderEmpty() {  
                return order;
        newPlugin.createComponents(client, null, mockThreadPool, null, null, null, null, null, null, null, null);
        // Test that plugin validation catches duplicate orders
import org.opensearch.protobufs.QueryContainer;
        networkService = new NetworkService(List.of());  
        newPlugin.createComponents(Mockito.mock(Client.class), null, mockThreadPool, null, null, null, null, null, null, null, null);  
        @SuppressWarnings("unchecked")
public class GrpcPluginTests extends OpenSearchTestCase {  
        assertTrue(transport instanceof Netty4GrpcServerTransport);
     * @param expectedException Expected exception class (null if no exception expected)
        // Verify that the supplier returns a Netty4GrpcServerTransport instance
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
        public List<BindableService> build() {
        IllegalArgumentException exception = expectThrows(  
        private final int order;
            getServerClientAuthNone(),  
        );  
    }
            null, // ScriptService  
        // Create a mock extension loader
        String errorMessage = exception.getMessage();
        assertTrue(  
        assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));  
            tracer
        assertTrue(errorMessage.contains("Multiple gRPC interceptors have the same order value [5]"));  
        return new OrderedGrpcInterceptor() {
                return new ServerInterceptor() {
            assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
            RuntimeException.class,
        plugin.createComponents(
                        Metadata headers,  
            client,
    public void testGrpcInterceptorChainWithSuccessfulInterceptors() {
        // Verify that no converters were loaded
    /**
        when(mockLoader.loadExtensions(GrpcServiceFactory.class)).thenReturn(List.of(new LoadableMockServiceFactory()));
     */
            }
            plugin.createComponents(client, null, threadPool, null, null, null, emptyEnv, null, null, null, null);
        public int getOrder() {
        // Mock ThreadPool for createComponents
    public void testMultipleInterceptorsWithEarlyFailure() {
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;
            createTestInterceptorWithCallback(30, executionOrder, "Third"),  
    public void testGetSecureAuxTransportsWithServiceFactories() {
    public void testGetSettings() {  
        // Verify that the external converter was registered by checking it was called
            closedStatus.set(invocation.getArgument(0));
    }
        List<GrpcInterceptorProvider> providers = providerOrders.stream().map(orders -> {
     */
    }  
        if (expectedException != null) {
     * Generic interceptor loading test helper  
        } else if (orders.isEmpty()) {
        // Verify error message includes order value and interceptor class names
            mockThreadPool, // ThreadPool
    /**
        when(mockConverter.fromProto(Mockito.anyString(), Mockito.any())).thenReturn(new MinAggregationBuilder("external_min"));  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_HOST;
                    @Override
        assertTrue(errorMessage.contains("Each interceptor must have a unique order value"));  
                            ServerCall<ReqT, RespT> call,
        Mockito.verify(mockConverter, Mockito.times(3)).getHandledQueryCase();
            @Override
    public void testGetSecureAuxTransports() {  
            null, // NamedWriteableRegistry
     * Test actual request processing with interceptors
                    return 100;  
    }
                    fail("Unexpected failure in success test case");
    }
        );
        GrpcPlugin newPlugin = new GrpcPlugin();  
     */
    private ExtensiblePlugin.ExtensionLoader createMockLoader(List<Integer> orders) {
                    return result;  
    }
    public void testCreateComponentsWithBothExternalConverters() {  
    }
import static org.mockito.Mockito.when;
            false,
     */  
        newPlugin.loadExtensions(mockLoader);
    public void testGetSecureAuxTransportsWithNullClient() {  
            fail("Expect test interceptor with empty settings throws exception.");  
        // createComponents throws exception with the incorrect setting
    // ===========================================  
    public void setup() {  
        AtomicBoolean callClosed = new AtomicBoolean(false);  
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));  
    public void testGrpcInterceptorChainEmptyList() {  
        @SuppressWarnings("unchecked")
        newPlugin.createComponents(Mockito.mock(Client.class), null, mockThreadPool, null, null, null, null, null, null, null, null);  
                    closedStatus.get().getDescription().contains(expectedErrorMessage)  
        assertEquals("First", executionOrder.get(0));
     * Test interceptor that throws exceptions during request processing
    // Generic helper methods for cleaner, more maintainable tests  
        Mockito.doReturn(InternalMax.class).when(mockAggregateConverter).getHandledAggregationType();
        // Call createComponents  
        // Create a mock converter that will be registered
                    }  
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                @Override
            ),
                        ServerCallHandler<ReqT, RespT> next
        // Create a new plugin instance
            null, // IndexNameExpressionResolver
            ServerCall<ReqT, RespT> call,
     */
        };
                        ServerCallHandler<ReqT, RespT> next  
            @Override  
                // Fail the request with proper gRPC status  
     */  
        testInterceptorLoading(List.of(), null);  
        public int getOrder() {
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        ExtensiblePlugin.ExtensionLoader mockLoader = createMockLoaderWithMultipleProviders(List.of(List.of(5), List.of(5)));  
    public void testInterceptorExceptionDuringRequestPhase() {  
    @Mock
        newPlugin.loadExtensions(mockLoader);
        } else {  
                public ServerCall.Listener<String> startCall(ServerCall<String, String> call, Metadata headers) {
        ) {
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
 */  
                new TestRequestInterceptor(2, false, "Rate limit exceeded"), // Fails here
            client,
    /**
        private final int order;
    public void testLoadExtensionsWithGrpcInterceptors() {
        // Create mock server call and handler
        GrpcPlugin plugin = new GrpcPlugin();
import org.opensearch.common.util.concurrent.ThreadContext;
     * TestSettingsAwareInterceptorProvider will throw an exception if setting "test-setting" is not true.
                        ServerCall<ReqT, RespT> call,
        IllegalArgumentException exception = expectThrows(  
                    ) {
        // Verify that the supplier returns a Netty4GrpcServerTransport instance
        return mockLoader;
import java.util.concurrent.atomic.AtomicReference;
        GrpcPlugin newPlugin = new GrpcPlugin();
        testInterceptorLoading(null, null);
        assertNotNull("QueryUtils should be initialized", newPlugin.getQueryUtils());
        );
    }
import org.opensearch.common.network.NetworkService;
                }
        // 2. In updateRegistryOnAllConverters() to ensure all converters have the complete registry  
        List<OrderedGrpcInterceptor> interceptors = List.of(
        AuxTransport transport = transports.get(GRPC_TRANSPORT_SETTING_KEY).get();
            mockThreadPool, // ThreadPool  
        }
    public void testLoadExtensions() {  
        List<QueryBuilderProtoConverter> mockConverters = new ArrayList<>();
        assertTrue(errorMessage.contains("Multiple gRPC interceptors have the same order value [1]"));  
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        GrpcPlugin plugin = new GrpcPlugin();
    }
        AtomicBoolean callClosed = new AtomicBoolean(false);
        ServerCall<String, String> mockCall = Mockito.mock(ServerCall.class);
        Mockito.doReturn(InternalMax.class).when(mockConverter).getHandledAggregationType();
        assertEquals("Should have 1 query converter loaded", 1, newPlugin.getQueryConverters().size());
    private void testRequestProcessing(List<TestRequestInterceptor> interceptors, boolean shouldSucceed, String description) {
        );
                    @Override
        Mockito.verify(mockConverter, Mockito.times(3)).getHandledAggregationCase();  
        when(mockConverter.getHandledQueryCase()).thenReturn(QueryContainer.QueryContainerCase.MATCH_ALL);
        private Settings settings;
        assertTrue("SETTING_GRPC_PORT should be included", settings.contains(SETTING_GRPC_PORT));
                @Override  
    private void testRequestProcessingWithException(
        plugin.loadExtensions(mockLoader);  
            () -> plugin.createComponents(client, null, mockThreadPool, null, null, null, environment, null, null, null, null)
            public int order() {
    // Test cases for GrpcInterceptorChain
            final ServerCallHandler<String, String> nextHandler = currentHandler;  
                        ServerCallHandler<ReqT, RespT> next
    ) {  
            callClosed.set(true);  
    public void testGrpcInterceptorChainOrdering() {
        GrpcInterceptorChain chain = new GrpcInterceptorChain(threadContext, interceptors);
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);
        assertTrue(transport instanceof SecureNetty4GrpcServerTransport);  
            tracer
import io.grpc.ServerCall;
        assertTrue("SETTING_GRPC_PUBLISH_HOST should be included", settings.contains(SETTING_GRPC_PUBLISH_HOST));
            ServerCall.Listener<String> result = interceptor.interceptCall(mockCall, headers, nextHandler);
        // Verify execution order
            when(mockProvider.getOrderedGrpcInterceptors(Mockito.any())).thenReturn(new ArrayList<>());
    // ===========================================
            List<OrderedGrpcInterceptor> interceptors = orders.stream()
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);  
            when(mockProvider.getOrderedGrpcInterceptors(Mockito.any())).thenReturn(interceptors);  
            null, // ScriptService
            null, // NamedWriteableRegistry  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_WORKER_COUNT;
    private void testGrpcInterceptorChain(List<OrderedGrpcInterceptor> interceptors, boolean shouldSucceed, String expectedErrorMessage) {  
        // Verify the converter was added to the queryConverters list
            circuitBreakerService,
                networkService,
        List<String> executionOrder = new ArrayList<>();  
import io.grpc.ServerInterceptor;
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);  
                };
    @Before
        @SuppressWarnings("unchecked")
            @Override  
        // Create a new plugin instance
    public void testGetAuxTransports() {
        List<List<Integer>> providerOrders,
        assertTrue(errorMessage.contains("Multiple gRPC interceptors have the same order value [5]"));  
        testRequestProcessingWithException(
            assertNotNull(result);  
        interceptors.sort(Comparator.comparingInt(OrderedGrpcInterceptor::order));
        // 1. In loadExtensions() for logging
        List<OrderedGrpcInterceptor> interceptors = List.of(  
            // Simulate request processing logic
            settings,
    @Mock
            when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(List.of(mockProvider));
    }
            "Request should succeed when interceptor succeeds"
        // Should not throw exception and should load providers
                    }  
        }
        when(environment.settings()).thenReturn(Settings.EMPTY);
 *
    }
/*  
            threadPool, // ThreadPool (now properly mocked)
        assertNotNull("QueryUtils should be initialized", newPlugin.getQueryUtils());  
            environment, // Environment
    }  
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider.OrderedGrpcInterceptor;
        return new OrderedGrpcInterceptor() {
            true,  
                threadPool,
        );  
        assertTrue("Should contain GRPC_SECURE_TRANSPORT_SETTING_KEY", transports.containsKey(GRPC_SECURE_TRANSPORT_SETTING_KEY));
            networkService,
        // Note: setRegistry is called 2 times:
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);  
                throw new SecurityException(message);  
                    "Error message should contain expected text",
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS;
    private Tracer tracer;  
    }
    private CircuitBreakerService circuitBreakerService;
        Mockito.verify(mockAggregateConverter).getHandledAggregationType();  
        when(mockLoader.loadExtensions(AggregationBuilderProtoConverter.class)).thenReturn(null);  
        public List<OrderedGrpcInterceptor> getOrderedGrpcInterceptors(ThreadContext threadContext) {
import io.grpc.Metadata;
            threadPool,  
        // Verify that the transport map contains the expected key
    public void testGrpcInterceptorChainWithFailingInterceptor() {
    }
        // Response-side: setRegistry (registerConverter + updateRegistryOnAllConverters)
        Settings settings = Settings.builder().put(SETTING_GRPC_PORT.getKey(), "9200-9300").build();
    }
        GrpcPlugin newPlugin = new GrpcPlugin();  
            () -> plugin.createComponents(client, null, mockThreadPool, null, null, null, environment, null, null, null, null)
        // createComponents should fail with duplicate order
            createTestInterceptor(10, false),
    /**  
            circuitBreakerService,  
        testGrpcInterceptorChain(interceptors, true, null);
        RuntimeException exception = expectThrows(
import java.util.List;
            RuntimeException.class,
        private final String message;
            threadPool,
        };  
            GrpcInterceptorProvider mockProvider = Mockito.mock(GrpcInterceptorProvider.class);
import io.grpc.ServerCallHandler;  
    }
        // createComponents initializes interceptor with the correct setting
        // Expect a RuntimeException when client is null  
            () -> plugin.createComponents(client, null, mockThreadPool, null, null, null, environment, null, null, null, null)
        return mockLoader;
     * Helper method to test GrpcInterceptorChain behavior
        );  
    private void assertDoesNotThrow(Runnable runnable) {
        // Execute the interceptors in chain (simulating real gRPC behavior)
        testGrpcInterceptorChain(interceptors, true, null);
 * this file be licensed under the Apache-2.0 license or a
        assertFalse("Call should not be closed for success case", callClosed.get());
            } else if (message.contains("Rate limit")) {
        TestExceptionThrowingInterceptor interceptor,  
        // Create a list of mock converters
        }  
                    @Override  
        Collection<Object> components = newPlugin.createComponents(  
        if (expectedException != null) {
            null, // ResourceWatcherService
        List<Setting<?>> settings = plugin.getSettings();
        when(mockThreadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider;
        newPlugin.loadExtensions(mockLoader);  
        // Request-side: setRegistry (manual + registerConverter + updateRegistryOnAllConverters)
        }).when(mockCall).close(Mockito.any(Status.class), Mockito.any(Metadata.class));  
            public ServerInterceptor getInterceptor() {
            null, // NamedXContentRegistry
        when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(List.of(mockProvider));  
        interceptors = new ArrayList<>(interceptors);  
     */  
            Mockito.mock(SecureAuxTransportSettingsProvider.class),
    // Test cases for actual request processing with interceptors
            }
        TestExceptionThrowingInterceptor throwingInterceptor = new TestExceptionThrowingInterceptor(2, "Rate limit service down");
    /**  
import org.opensearch.protobufs.AggregationContainer;
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PORT;
        // 1. In createComponents() when processing external converters
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));  
    }
        }).when(mockCall).close(Mockito.any(Status.class), Mockito.any(Metadata.class));  
        assertTrue("SETTING_GRPC_EXECUTOR_COUNT should be included", settings.contains(SETTING_GRPC_EXECUTOR_COUNT));
    public void testCreateComponentsWithExternalAggregationConverters() {
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
     * Creates a test interceptor that can succeed or fail
            assertTrue("Call should be closed for failed chain", callClosed.get());
            return List.of(new OrderedGrpcInterceptor() {  
        @SuppressWarnings("unchecked")  
            public ServerInterceptor getInterceptor() {  
        Mockito.verify(mockAggConverter, Mockito.times(3)).setRegistry(Mockito.any());  
    public void testGrpcInterceptorChainWithDuplicateOrders() {
            null, // ResourceWatcherService
                    };  
    public void testLoadExtensionsWithNullAggregationConverters() {
        } else {
        Environment invalidEnv = Mockito.mock(Environment.class);  
        List<OrderedGrpcInterceptor> interceptors = prov.getOrderedGrpcInterceptors(new ThreadContext(Settings.EMPTY));  
        doAnswer(invocation -> {
            clusterSettings,  
import java.util.Map;  
import static org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport.SETTING_GRPC_SECURE_PORT;
    private void testInterceptorLoadingWithMultipleProviders(  
            settings.contains(SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS)
            () -> { throwingInterceptor.interceptCall(mockCall, headers, mockHandler); }  
    }
                assertTrue(
import org.opensearch.telemetry.tracing.Tracer;
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);  
        AggregateProtoConverter mockAggregateConverter = Mockito.mock(AggregateProtoConverter.class);
    /**
        QueryBuilderProtoConverter mockConverter = Mockito.mock(QueryBuilderProtoConverter.class);
                            return next.startCall(call, headers);
        testInterceptorLoading(List.of(1, 2), null); // Runtime failures don't affect loading
        GrpcPlugin newPlugin = new GrpcPlugin();
        RuntimeException exception = expectThrows(
import io.grpc.protobuf.services.HealthStatusManager;  
            null, // ResourceWatcherService
    }
        assertNotNull("QueryUtils should be initialized", newPlugin.getQueryUtils());  
                public ServerInterceptor getInterceptor() {
        plugin.loadExtensions(mockLoader);  
        // Set up the mock loader to return the mock converters  
    /**  
                // A failure occurred - this is expected for failure test cases
        try {  
            clusterSettings,
        plugin.loadExtensions(mockLoader);
                } else {  
        GrpcInterceptorProvider prov = threadContext -> List.of();
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);  
        AuxTransport transport = transports.get(GRPC_TRANSPORT_SETTING_KEY).get();
        assertTrue(expectedExceptionType.isInstance(thrown));  
        }  
        assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);
            null, // ClusterService  
        private final String message;
                        return next.startCall(call, headers);
        // Sort them as GrpcPlugin would
        Mockito.verify(mockAggConverter).getHandledAggregationCase();
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
            IllegalArgumentException.class,
        try {
            Metadata headers,  
        // For success case, ensure call was not closed
                settings,
        when(mockLoader.loadExtensions(AggregationBuilderProtoConverter.class)).thenReturn(List.of(mockConverter));  
            null, // NodeEnvironment  
            threadPool,  
import java.util.ArrayList;
        Environment emptyEnv = Mockito.mock(Environment.class);
            }
                call.close(Status.PERMISSION_DENIED.withDescription(message), new Metadata());
        doAnswer(invocation -> {  
        Settings settings = Settings.builder().put(SETTING_GRPC_SECURE_PORT.getKey(), "9200-9300").build();
        return new OrderedGrpcInterceptor() {
        GrpcPlugin newPlugin = new GrpcPlugin();
            null, // NodeEnvironment  
            return order;  
        GrpcPlugin plugin = new GrpcPlugin();
        );
            currentHandler = new ServerCallHandler<String, String>() {  
        newPlugin.loadExtensions(mockLoader);
        for (TestRequestInterceptor interceptor : interceptors) {
            this.order = order;
    }
        mockConverters.add(Mockito.mock(QueryBuilderProtoConverter.class));
            clusterSettings,  
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
    @Mock
                    // This is expected - test passes
            expectThrows(expectedException, () -> plugin.loadExtensions(mockLoader));
    public void testGetAuxTransportsWithServiceFactories() {
    }  
    private static class LoadableMockServiceFactory implements GrpcServiceFactory {
            createTestInterceptor(10, false) // Duplicate order  
        plugin.loadExtensions(mockLoader);
        QueryBuilderProtoConverter mockConverter = Mockito.mock(QueryBuilderProtoConverter.class);  
            "SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS should be included",
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
            false,
        assertTrue(thrown.getMessage().contains(expectedMessage));
        }  
        when(mockAggConverter.fromProto(Mockito.anyString(), Mockito.any())).thenReturn(new MinAggregationBuilder("ext_min"));
        // setRegistry called in: registerConverter, updateRegistryOnAllConverters  
        public String plugin() {  
            when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(List.of(mockProvider));
        ServerCallHandler<String, String> mockHandler = Mockito.mock(ServerCallHandler.class);  
        }
        ServerCall<String, String> mockCall = Mockito.mock(ServerCall.class);
    private static class TestRequestInterceptor implements ServerInterceptor {
        when(mockAggConverter.getHandledAggregationCase()).thenReturn(AggregationContainer.AggregationContainerCase.MIN);
            public int order() {
        // Call loadExtensions  
    }  
    public void testLoadExtensionsWithSameExplicitOrderInterceptors() {  
            null  // Supplier<RepositoriesService>  
                public int order() {
        // Verify that the queryUtils instance was created and is available  
    }  
    public void testGrpcInterceptorChainIntegrationWithPlugin() {  
        AuxTransport transport = transports.get(GRPC_SECURE_TRANSPORT_SETTING_KEY).get();
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> newPlugin.getQueryUtils());  
                @Override
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
        );  
        if (!shouldSucceed) {  
    /**  
        Exception thrown = expectThrows(Exception.class, () -> { interceptor.interceptCall(mockCall, headers, mockHandler); });
            }
    }
            expectThrows(expectedException, () -> plugin.loadExtensions(mockLoader));  
                throw new RuntimeException("test-setting not found or not set to true");  
            List.of(new TestRequestInterceptor(1, true, "Auth check passed")),
     * Creates a no-op interceptor with the specified order.
    }  
                };  
                throw new IllegalStateException(message);
        Metadata headers = new Metadata();
        when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(providers);  
        List<OrderedGrpcInterceptor> interceptors = List.of(  
    public void testLoadExtensionsWithMultipleProvidersAndDuplicateOrder() {
            () -> newPlugin.getSecureAuxTransports(  
        );  
        assertTrue("SETTING_GRPC_PUBLISH_PORT should be included", settings.contains(SETTING_GRPC_PUBLISH_PORT));
    public void testCreateComponentsWithExternalConverters() {
            return null;
            this.message = message;  
            });
    // Test cases for gRPC interceptor functionality
                    }
    private void testInterceptorLoading(List<Integer> orders, Class<? extends Exception> expectedException) {
    /**  
        assertEquals("Second", executionOrder.get(1));
        assertTrue(errorMessage.contains("Multiple gRPC interceptors have the same order value [10]"));
        // 2. In createComponents() for logging
        assertEquals("Query utils not initialized. Make sure createComponents has been called.", exception.getMessage());
import org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport;
        assertTrue("SETTING_GRPC_MAX_CONNECTION_IDLE should be included", settings.contains(SETTING_GRPC_MAX_CONNECTION_IDLE));  
        when(mockLoader.loadExtensions(AggregationBuilderProtoConverter.class)).thenReturn(List.of(mockAggConverter));
        MockitoAnnotations.openMocks(this);
        assertTrue("SETTING_GRPC_SECURE_PORT should be included", settings.contains(SETTING_GRPC_SECURE_PORT));
        Mockito.verify(mockConverter, Mockito.times(2)).setRegistry(Mockito.any());
    }
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_HOST;  
        when(extensionLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(List.of(mockConverter));  
        // Verify that the queryUtils instance was created and is available
    }  
            null  // Supplier<RepositoriesService>  
            if (!shouldSucceed) {
        when(mockLoader.loadExtensions(AggregationBuilderProtoConverter.class)).thenReturn(List.of(mockAggConverter));
        @Override  
            networkService,
            this.message = message;  
                new TestRequestInterceptor(2, true, "Rate limit passed"),
        assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
import org.opensearch.transport.grpc.spi.GrpcServiceFactory;  
        assertDoesNotThrow(() -> prov.initNodeSettings(Settings.EMPTY));
            true,
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_PORT;
            createTestInterceptor(10, false), // Success
        @Override
        }
        @Override  
        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        assertNotNull("QueryUtils should be initialized after createComponents", newPlugin.getQueryUtils());
        // Create a new plugin instance without calling createComponents
            null, // Environment
        // Verify that the transport map contains the expected key
        assertTrue("Should return a Netty4GrpcServerTransport instance", transport instanceof Netty4GrpcServerTransport);  
import org.opensearch.threadpool.ThreadPool;
        public TestRequestInterceptor(int order, boolean shouldSucceed, String message) {  
                            Metadata headers,  
    private static class TestSettingsAwareInterceptorProvider implements GrpcInterceptorProvider {
    }
        );
        when(mockThreadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
        plugin = new GrpcPlugin();  
        // Create a new plugin instance
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
            networkService,
    /**
        newPlugin.loadExtensions(mockLoader);  
    public void testInterceptorExceptionHandling() {
            }
    }
        when(invalidEnv.settings()).thenReturn(invalidSetting);
            "Request should fail when any interceptor fails"  
        // Call createComponents to trigger registration of external converters
                tracer
            assertNotNull("Should return a listener for successful chain", result);  
            // Create a new handler for the next interceptor that continues the chain
    }
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_KEEPALIVE_TIMEOUT;  
                        Metadata headers,
            plugin.createComponents(client, null, threadPool, null, null, null, invalidEnv, null, null, null, null);  
import org.opensearch.transport.client.Client;  
            @Override
        ServerCall<String, String> mockCall = Mockito.mock(ServerCall.class);  
        AtomicReference<Status> closedStatus = new AtomicReference<>();
        // loadExtensions should succeed
    private ExtensiblePlugin.ExtensionLoader extensionLoader;  
            }
        Exception thrown = expectThrows(
        ExtensiblePlugin.ExtensionLoader mockLoader = createMockLoader(orders);  
            ServerCallHandler<ReqT, RespT> next
        @SuppressWarnings("unchecked")
        );  
    }
        @SuppressWarnings("unchecked")
     * Creates a test interceptor that tracks execution order
import org.mockito.Mockito;
        // Create a mock extension loader that returns the converter  
    }  
                getServerClientAuthNone(),  
        testGrpcInterceptorChain(interceptors, false, "Test failure");  
        );
        // Mock Environments  
        assertTrue("Should return a SecureNetty4GrpcServerTransport instance", transport instanceof SecureNetty4GrpcServerTransport);  
import java.util.function.Supplier;  
        }
        // If we reach here and shouldSucceed is false, the test failed to fail as expected
        GrpcPlugin plugin = new GrpcPlugin();
    @Mock
        if (shouldSucceed) {
            createTestInterceptor(20, false),
        // Mock ThreadPool for createComponents
        // Need to call createComponents to actually initialize the chain
        // Add the mock converter to the plugin
        // Should not throw — null extensions are handled gracefully
        newPlugin.loadExtensions(mockLoader);
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(mockConverters);
    }
        IllegalArgumentException exception = expectThrows(  
            SecurityException.class,
        assertTrue(interceptors.isEmpty());
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        );
                        if (shouldFail) {
            "Request should fail when interceptor fails"  
import org.opensearch.common.settings.Setting;  
    }
        assertDoesNotThrow(
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);  
            assertEquals("test-setting not found or not set to true", e.getMessage());  
import java.util.concurrent.atomic.AtomicBoolean;
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));  
    private ThreadPool threadPool;
        assertTrue("Should contain GRPC_TRANSPORT_SETTING_KEY", transports.containsKey(GRPC_TRANSPORT_SETTING_KEY));
                clusterSettings,
        AggregationBuilderProtoConverter mockConverter = Mockito.mock(AggregationBuilderProtoConverter.class);
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
    @Mock
        // Create a new plugin instance without initializing the client  
import org.opensearch.common.settings.ClusterSettings;
        ExtensiblePlugin.ExtensionLoader mockLoader = Mockito.mock(ExtensiblePlugin.ExtensionLoader.class);
        assertTrue("SETTING_GRPC_MAX_CONNECTION_AGE should be included", settings.contains(SETTING_GRPC_MAX_CONNECTION_AGE));
        ServerCallHandler<String, String> currentHandler = mockHandler;  
    }
        // Set up the mock loader to return null
            )
        Metadata headers = new Metadata();
        @SuppressWarnings("unchecked")
        ThreadPool mockThreadPool = Mockito.mock(ThreadPool.class);
            createTestInterceptor(30, false)  
     */  
        when(mockProvider.getOrderedGrpcInterceptors(Mockito.any())).thenReturn(interceptors);
        // Execute the chain
import org.opensearch.env.Environment;
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));  
        } catch (RuntimeException e) {
        // getHandledAggregationCase() called in: loadExtensions logging, createComponents logging, SPI registerConverter
        AggregateProtoConverter mockAggregateConverter = Mockito.mock(AggregateProtoConverter.class);
        when(mockLoader.loadExtensions(AggregateProtoConverter.class)).thenReturn(List.of(mockConverter));
        // 3. In QueryBuilderProtoConverterSpiRegistry.registerConverter() for registration  
        );
        assertEquals(0, newPlugin.getQueryConverters().size());  
        // getHandledAggregationType() called in: loadExtensions logging, createComponents logging  
        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        List<OrderedGrpcInterceptor> interceptors = List.of();
                        }
     * Creates a mock extension loader with interceptors of given orders  
            ServerCall<ReqT, RespT> call,
        // Expect a RuntimeException when client is null  
        testRequestProcessing(
import org.opensearch.test.OpenSearchTestCase;  
        assertNotNull("QueryUtils should be initialized after createComponents", newPlugin.getQueryUtils());  
import io.grpc.Status;
        Settings settings = Settings.builder().put(SETTING_GRPC_SECURE_PORT.getKey(), "9200-9300").build();
    /**
     */  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONNECTION_AGE;
        } catch (Exception e) {
    }  
            circuitBreakerService,
        Class<? extends Exception> expectedExceptionType,
        GrpcPlugin newPlugin = new GrpcPlugin();  
    public void testLoadExtensionsWithEmptyGrpcInterceptorList() {
            // Simulate different types of exceptions that can occur during request processing
        assertTrue("SETTING_GRPC_MAX_MSG_SIZE should be included", settings.contains(SETTING_GRPC_MAX_MSG_SIZE));
        }  
        } else {
            () -> plugin.createComponents(client, null, mockThreadPool, null, null, null, environment, null, null, null, null)  
        newPlugin.loadExtensions(mockLoader);  
                        return next.startCall(call, headers);
    public void testGrpcInterceptorProviderSettingsInitialization() {  
        GrpcPlugin plugin = new GrpcPlugin();  
        // Verify that the converters were loaded  
            fail("Expect test interceptor with wrong settings throws exception.");
package org.opensearch.transport.grpc;
}
        when(mockThreadPool.getThreadContext()).thenReturn(new org.opensearch.common.util.concurrent.ThreadContext(Settings.EMPTY));
                new TestRequestInterceptor(1, true, "Auth passed"),
        GrpcPlugin plugin = new GrpcPlugin();
    }
import java.util.stream.Collectors;
    private static class TestExceptionThrowingInterceptor implements ServerInterceptor {  
            "Request should succeed when all interceptors succeed"  
        }
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;  
     */  
                    ) {
            if (message.contains("Security")) {
            public ServerInterceptor getInterceptor() {
            client,
            }
            threadPool,  
    }
        // Test that getQueryUtils throws IllegalStateException when queryUtils is not initialized
        clusterSettings = new ClusterSettings(Settings.EMPTY, plugin.getSettings().stream().collect(java.util.stream.Collectors.toSet()));  
        ServerCall.Listener<String> mockListener = Mockito.mock(ServerCall.Listener.class);  
        private final boolean shouldSucceed;  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                            throw new RuntimeException("Test failure");  
import org.mockito.Mock;
        assertEquals("Rate limit service down", thrown.getMessage());  
    private GrpcPlugin plugin;
        public void initNodeSettings(Settings settings) {
    }
                }; // Empty listener for failed call  
                if (!shouldSucceed) {  
        assertTrue("Should contain GRPC_SECURE_TRANSPORT_SETTING_KEY", transports.containsKey(GRPC_SECURE_TRANSPORT_SETTING_KEY));
    }
                        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                return new ServerCall.Listener<ReqT>() {
        );
                .collect(Collectors.toList());  
    public void testGetQueryUtilsAfterCreateComponents() {
            return null;
     * Test request processing with exception throwing interceptor  
                        ) {
    @Mock
    public void testGetQueryUtilsBeforeCreateComponents() {
        IllegalArgumentException exception = expectThrows(  
        }).collect(Collectors.toList());
        assertTrue(errorMessage.contains("Each interceptor must have a unique order value"));
        ExtensiblePlugin.ExtensionLoader mockLoader = createMockLoaderWithMultipleProviders(providerOrders);
        );  
            createTestInterceptor(20, true),  // Failure
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);
            fail("Expected failure but all interceptors succeeded");
            null, // ClusterService
    }
            this.order = order;
                        return next.startCall(call, headers);
        testRequestProcessing(
        Metadata headers = new Metadata();  
     * Test interceptor provider that validates GrpcInterceptorProvider's access to settings.
        Class<? extends Exception> expectedException
            settings,
        @Override
        when(mockLoader.loadExtensions(QueryBuilderProtoConverter.class)).thenReturn(null);  
    }
                            // No-op interceptor - just pass through  
import static org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport.GRPC_SECURE_TRANSPORT_SETTING_KEY;  
                }
            GrpcInterceptorProvider provider = Mockito.mock(GrpcInterceptorProvider.class);
    /**
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        GrpcPlugin newPlugin = new GrpcPlugin();  
            createTestInterceptor(10, false),
            null, // IndexNameExpressionResolver
                        }
        // Call loadExtensions
        TestSettingsAwareInterceptorProvider provider = new TestSettingsAwareInterceptorProvider();
        when(validEnv.settings()).thenReturn(validSetting);  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_BIND_HOST;  
        AggregationBuilderProtoConverter mockAggConverter = Mockito.mock(AggregationBuilderProtoConverter.class);  
        public TestExceptionThrowingInterceptor(int order, String message) {
        when(mockHandler.startCall(Mockito.any(), Mockito.any())).thenReturn(mockListener);
                new TestRequestInterceptor(3, true, "Validation passed")  
        when(mockLoader.loadExtensions(GrpcInterceptorProvider.class)).thenReturn(List.of(provider));
        assertEquals("Third", executionOrder.get(2));  
import org.mockito.MockitoAnnotations;  
        mockConverters.add(Mockito.mock(QueryBuilderProtoConverter.class));  
                    return;
        String expectedMessage
        // Create a new plugin instance without initializing the client  
import static org.opensearch.transport.grpc.ssl.SecureSettingsHelpers.getServerClientAuthNone;
            circuitBreakerService,
            return order;
    public void testInterceptorRequestProcessingWithSuccess() {  
        when(mockAggConverter.getHandledAggregationCase()).thenReturn(AggregationContainer.AggregationContainerCase.MIN);
        assertEquals("createComponents must be called first to initialize server provided resources.", exception.getMessage());
            this.shouldSucceed = shouldSucceed;
        when(mockHandler.startCall(Mockito.any(), Mockito.any())).thenReturn(mockListener);  
        String errorMessage = exception.getMessage();  
        @Override
        if (orders == null) {  
        assertDoesNotThrow(() -> plugin.createComponents(client, null, threadPool, null, null, null, validEnv, null, null, null, null));
import io.grpc.BindableService;  
            createTestInterceptor(30, false)  // Should not execute  
        ExtensiblePlugin.ExtensionLoader mockLoader = createMockLoader(List.of(5, 5));
            this.settings = settings;  
    public void testLoadExtensionsWithNullExtensions() {
        // Track if call.close() was called (indicates failure)
            List.of(new TestRequestInterceptor(1, false, "Auth failed")),
            runnable.run();
            ServerCallHandler<ReqT, RespT> next
        assertTrue("SETTING_GRPC_BIND_HOST should be included", settings.contains(SETTING_GRPC_BIND_HOST));
        public LoadableMockServiceFactory() {}  
        );  
        Environment validEnv = Mockito.mock(Environment.class);
            clusterSettings,  
        Map<String, Supplier<AuxTransport>> transports = plugin.getAuxTransports(
        when(mockLoader.loadExtensions(AggregateProtoConverter.class)).thenReturn(null);
                    return new ServerInterceptor() {
            ),
        // Verify converters were discovered during loadExtensions
                            ServerCallHandler<ReqT, RespT> next
    }  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_EXECUTOR_COUNT;
        Settings invalidSetting = Settings.builder().put("test-setting", false).build();
        testInterceptorLoading(List.of(1, 2), null);
        // Load the extensions first
        assertTrue("SETTING_GRPC_WORKER_COUNT should be included", settings.contains(SETTING_GRPC_WORKER_COUNT));  
import java.util.Collection;  
            null, // Environment
    private OrderedGrpcInterceptor createMockInterceptor(int order) {
import org.junit.Before;  
        Mockito.doReturn(InternalMax.class).when(mockAggregateConverter).getHandledAggregationType();
        };  
                new TestRequestInterceptor(1, true, "Auth passed"),
            List<OrderedGrpcInterceptor> interceptors = orders.stream().map(this::createMockInterceptor).collect(Collectors.toList());  
    public void testMultipleInterceptorsRequestProcessing() {
        assertTrue(errorMessage.contains("GrpcPluginTests"));
        );
        assertDoesNotThrow(() -> plugin.loadExtensions(mockLoader));
