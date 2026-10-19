        return queryUtils;
            for (QueryBuilderProtoConverter converter : queryConverters) {
            aggregateRegistry.updateRegistryOnAllConverters();
     * @param circuitBreakerService The circuit breaker service
            xContentRegistry,
            }  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_HOST;  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONNECTION_AGE;
                queryRegistry.registerConverter(converter);
     * @param threadPool The thread pool  
     * This method is called by the OpenSearch plugin system to load extensions from other plugins.
     * @param xContentRegistry The named content registry
                    logger.info(
     * Creates a dedicated thread pool for gRPC request processing that integrates
                    "Loaded {} gRPC interceptors into chain in order: [{}]",
import org.opensearch.transport.AuxTransport;
    public List<Setting<?>> getSettings() {  
                    .initSettings(settings)  
        this.aggregationRegistry = new AggregationBuilderProtoConverterRegistryImpl();
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider.OrderedGrpcInterceptor;
    public AbstractQueryBuilderProtoUtils getQueryUtils() {  
                }
                    converter.getClass().getName(),
import org.opensearch.common.settings.Setting;  
    /** The name of the gRPC thread pool */  
        if (extensions != null && !extensions.isEmpty()) {  
            );
}
            for (AggregateProtoConverter converter : aggregateConverters) {
     * Provides auxiliary transports for the plugin.
        if (aggResponseExtensions != null && !aggResponseExtensions.isEmpty()) {
 * compatible open source license.
        }
        }  
                logger.info(
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_KEEPALIVE_TIMEOUT;  
                    orderedList.size(),
                        "{} gRPC services loaded from plugin: {}",  
            throw new IllegalStateException("Query utils not initialized. Make sure createComponents has been called.");
import static org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport.GRPC_SECURE_TRANSPORT_SETTING_KEY;  
                grpcServices.addAll(pluginServices);
     */
                    new SearchServiceImpl(client, queryUtils, aggregationRegistry, aggregateRegistry, circuitBreakerService)
 * this file be licensed under the Apache-2.0 license or a
                List<BindableService> pluginServices = serviceFac.initClient(client)
        this.queryRegistry = new QueryBuilderProtoConverterRegistryImpl();
                logger.info(
import java.util.Collections;
                // Inject the populated registry into the converter
        if (services != null) {
        } else {
    public List<QueryBuilderProtoConverter> getQueryConverters() {
                    );  
                    );  
            SETTING_GRPC_MAX_CONNECTION_IDLE,
import org.opensearch.threadpool.ExecutorBuilder;
                        .map(i -> i.getInterceptor().getClass().getName() + "(order=" + i.order() + ")")
     *
                // Register the converter
import org.opensearch.threadpool.FixedExecutorBuilder;  
            SETTING_GRPC_EXECUTOR_COUNT,  
        // Load discovered gRPC service factories  
                        serviceFac.plugin()
                aggregateConverters.add(converter);  
            logger.info("Loading {} AggregateProtoConverter extensions from other plugins", aggResponseExtensions.size());
    }
        List<GrpcInterceptorProvider> providers = loader.loadExtensions(GrpcInterceptorProvider.class);
            return new SecureNetty4GrpcServerTransport(
import java.util.ArrayList;
     * @param environment The environment
            );  
            List<BindableService> grpcServices = new ArrayList<>(
        ScriptService scriptService,  
import org.opensearch.threadpool.ThreadPool;
     * @param threadPool The thread pool
     * @param networkService The network service
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_PORT;
    }
                logger.info(
                )
                    converter.getHandledQueryCase()  
                serverInterceptor
        // Then add plugin-provided interceptors  
                        serviceFac.plugin()
     * Creates and returns a map of transport names to transport suppliers.  
            for (QueryBuilderProtoConverter converter : extensions) {
                    converter.getHandledAggregationCase()
import java.util.List;
                    .build();  
                    "Discovered AggregateProtoConverter extension: {} (handles: {})",
     * @param tracer The tracer
        Settings settings,
                        pluginService.bindService().getServiceDescriptor().getName(),
     */
                threadPool,
    /**
 */  
     * @param namedWriteableRegistry The named writeable registry
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider;
                    throw new IllegalArgumentException(  
     *
        NamedWriteableRegistry namedWriteableRegistry,
        CircuitBreakerService circuitBreakerService,  
                "Successfully injected registry and registered all {} external aggregation converters",  
     * @param clusterSettings The cluster settings
            SETTING_GRPC_PORT,
                providers.size(),
     */
                        .map(i -> i.getInterceptor().getClass().getName())
    private List<GrpcInterceptorProvider> interceptorProviders = new ArrayList<>();  
    }
            logger.info("No external AggregationBuilderProtoConverter(s) to register");
                grpcServices.addAll(pluginServices);
        this.serverInterceptor = new GrpcInterceptorChain(threadPool.getThreadContext());
            repositoriesServiceSupplier
     * @param tracer The tracer  
     * @return executor builders for this plugin's custom thread pools  
        if (client == null || queryRegistry == null) {
                logger.info(
    }
     * @param settings The node settings
                    converter.getHandledAggregationType().getName()  
        if (providers != null) {
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.GRPC_TRANSPORT_SETTING_KEY;
     * Returns the settings defined by this plugin.
        });
        if (client == null || queryRegistry == null) {  
                // Inject the populated registry into the converter
            new FixedExecutorBuilder(settings, GRPC_THREAD_POOL_NAME, executorCount, 1000, "thread_pool." + GRPC_THREAD_POOL_NAME)  
    /**  
            servicesFactory.addAll(services);  
                logger.info("Injected aggregation registry into converter: {}", converter.getClass().getName());  
            Map<Integer, List<OrderedGrpcInterceptor>> orderMap = new HashMap<>();
     */
    private AbstractQueryBuilderProtoUtils queryUtils;
     * @param nodeEnvironment The node environment  
            // Update the registry on all converters (including built-in ones) so they can access external converters
 *
            );  
     * @param indexNameExpressionResolver The index name expression resolver
    private final List<AggregateProtoConverter> aggregateConverters = new ArrayList<>();
            // Sort by order and create a chain - similar to OpenSearch's ActionFilter pattern
    @Override
    @Override
            resourceWatcherService,  
        } else {
        // Create the registry
        // Register external aggregate converters (response-side)
                services.stream().map(GrpcServiceFactory::plugin).collect(Collectors.joining(", "))
    public Map<String, Supplier<AuxTransport>> getSecureAuxTransports(  
        });  
                    .initClusterSettings(clusterSettings)
            for (GrpcServiceFactory serviceFac : servicesFactory) {
     * Registered under a distinct key from gRPC transport.
            );
            logger.info("No AggregateProtoConverter extensions found from other plugins");
     * @throws IllegalStateException if queryRegistry is not initialized  
    private AggregateProtoConverterRegistryImpl aggregateRegistry;  
            logger.info("No external AggregateProtoConverter(s) to register");
            logger.info("Successfully loaded {} AggregateProtoConverter extensions", aggResponseExtensions.size());
            environment,  
     * @param circuitBreakerService The circuit breaker service  
        NamedXContentRegistry xContentRegistry,
/*  
                    converter.getClass().getName(),
                );
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;
     * @return A collection of components
                settings,
        List<OrderedGrpcInterceptor> orderedList = new ArrayList<>();
        return Collections.singletonMap(GRPC_SECURE_TRANSPORT_SETTING_KEY, () -> {  
import org.opensearch.script.ScriptService;  
            for (Map.Entry<Integer, List<OrderedGrpcInterceptor>> entry : orderMap.entrySet()) {  
                        pluginService.bindService().getServiceDescriptor().getName(),
import org.opensearch.transport.client.Client;  
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;  
                    "Processing external converter: {} (handles: {})",  
     * Provides secure auxiliary transports for the plugin.  
                );  
    private static final Logger logger = LogManager.getLogger(GrpcPlugin.class);
        // Load aggregation converters from other plugins  
            logger.info("Successfully registered all {} external aggregate converters", aggregateConverters.size());
        Supplier<RepositoriesService> repositoriesServiceSupplier  
                    "Discovered QueryBuilderProtoConverter extension: {} (handles: {})",
        if (!aggregationConverters.isEmpty()) {
        NodeEnvironment nodeEnvironment,  
        List<AggregationBuilderProtoConverter> aggExtensions = loader.loadExtensions(AggregationBuilderProtoConverter.class);
    @Override
                "Found {} gRPC interceptor providers [{}], will initialize during component creation",
     * @throws IllegalStateException if queryUtils is not initialized
                aggregationRegistry.registerConverter(converter);  
        List<QueryBuilderProtoConverter> extensions = loader.loadExtensions(QueryBuilderProtoConverter.class);
                grpcServices,  
import org.opensearch.transport.grpc.interceptor.GrpcInterceptorChain;
            for (GrpcServiceFactory serviceFac : servicesFactory) {
        if (queryUtils == null) {
                converter.setRegistry(queryRegistry);  
                    .initSettings(settings)  
        // Inject registry into external converters and register them
import io.grpc.BindableService;  
     *
                    orderedList.stream()  
            // Note: ThreadContext will be provided during component creation  
     * @param client The client
            this.interceptorProviders = providers;
        // Load query converters from other plugins
     * Get the list of query converters, including those loaded from extensions.
            SETTING_GRPC_MAX_MSG_SIZE,
            // Update the registry on all converters (including built-in ones) so they can access external converters
import org.opensearch.common.settings.ClusterSettings;
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_EXECUTOR_COUNT;
            logger.info("Injecting registry and registering {} external QueryBuilderProtoConverter(s)", queryConverters.size());  
                "Successfully loaded {} GrpcServiceFactory extensions [{}]",
    private Client client;
import java.util.HashMap;  
                orderMap.computeIfAbsent(order, k -> new ArrayList<>()).add(interceptor);
     * @param clusterSettings The cluster settings  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS;
import java.util.function.Supplier;  
            throw new RuntimeException("createComponents must be called first to initialize server provided resources.");
        if (!queryConverters.isEmpty()) {
    public static final String GRPC_THREAD_POOL_NAME = "grpc";
                // This ensures proper ordering and exception handling  
     * @param repositoriesServiceSupplier The repositories service supplier  
            // Check for duplicates and throw exception if found
        ThreadPool threadPool,
     */
import org.opensearch.common.network.NetworkService;
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
            List<BindableService> grpcServices = new ArrayList<>(
            logger.info(
                );  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_MSG_SIZE;
    private final List<AggregationBuilderProtoConverter> aggregationConverters = new ArrayList<>();
        ThreadPool threadPool,
            // For now, we collect providers to be initialized later with ThreadContext
import org.apache.logging.log4j.LogManager;  
            logger.info("Loading {} AggregationBuilderProtoConverter extensions from other plugins", aggExtensions.size());  
        return Collections.singletonMap(GRPC_TRANSPORT_SETTING_KEY, () -> {  
import org.opensearch.telemetry.tracing.Tracer;
        );  
                aggregationConverters.size()
            );
                queryConverters.add(converter);
        );
     * @return The list of query converters  
            }
        }  
        } else {  
        Settings settings,
        // Create the query utils instance
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
            indexNameExpressionResolver,  
            logger.info("Registering {} external AggregateProtoConverter(s)", aggregateConverters.size());
    public Map<String, Supplier<AuxTransport>> getAuxTransports(  
                logger.info(  
    private final List<QueryBuilderProtoConverter> queryConverters = new ArrayList<>();  
        }
    ) {
    /**
                    "Processing external aggregate converter: {} (handles: {})",
        IndexNameExpressionResolver indexNameExpressionResolver,
        CircuitBreakerService circuitBreakerService,  
                serverInterceptor.addInterceptors(orderedList);
            namedWriteableRegistry,
        SecureAuxTransportSettingsProvider secureAuxTransportSettingsProvider,  
            for (OrderedGrpcInterceptor interceptor : orderedList) {  
            }  
                            + ". Each interceptor must have a unique order value."
        Tracer tracer
            for (AggregateProtoConverter converter : aggResponseExtensions) {  
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.service.ClusterService;  
    /**  
                List<BindableService> pluginServices = serviceFac.initClient(client)
                logger.info("Injected registry into converter: {}", converter.getClass().getName());
            logger.info("No QueryBuilderProtoConverter extensions found from other plugins");  
    /**
                        .collect(Collectors.joining(", "))
        // Create the aggregate registry (response-side)
            logger.info("Successfully loaded {} AggregationBuilderProtoConverter extensions", aggExtensions.size());  
            // Validate that no two interceptors have the same order
        ResourceWatcherService resourceWatcherService,
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
            SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS,
        }
            SETTING_GRPC_WORKER_COUNT,
            return new Netty4GrpcServerTransport(settings, grpcServices, networkService, threadPool, serverInterceptor);
    /**  
     *  
                    new DocumentServiceImpl(client, circuitBreakerService),  
            }
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
    @Override
            logger.info(  
                    .initClusterSettings(clusterSettings)
import org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport;
                )
        }  
        } else {
     * @return A map of transport names to transport suppliers
                    .initThreadPool(threadPool)
            threadPool,
        } else {
                // Register the converter  
     * @param settings The node settings
            logger.info("Updated aggregate registry on all converters to include external converters");  
import java.util.stream.Collectors;
    @Override  
    }
        if (aggExtensions != null && !aggExtensions.isEmpty()) {
                for (BindableService pluginService : pluginServices) {
            }  
     */
            SETTING_GRPC_KEEPALIVE_TIMEOUT
                logger.info(  
    private final List<GrpcServiceFactory> servicesFactory = new ArrayList<>();  
     * @param loader The extension loader to use for loading extensions  
        }
     */
import org.opensearch.transport.grpc.spi.GrpcServiceFactory;  
import org.opensearch.watcher.ResourceWatcherService;  
            }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        Client client,
            for (AggregationBuilderProtoConverter converter : aggregationConverters) {  
                    new SearchServiceImpl(client, queryUtils, aggregationRegistry, aggregateRegistry, circuitBreakerService)
            logger.info("Updated aggregation registry on all converters to include external converters");  
     * Loads extensions from other plugins.  
     * @return A map of transport names to transport suppliers
                services.size(),  
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {  
        }  
        // Inject registry into external aggregation converters and register them  
                );
                );
     * Get the query utils instance.
            logger.info("Loading {} QueryBuilderProtoConverter extensions from other plugins", extensions.size());
            SETTING_GRPC_MAX_CONNECTION_AGE,  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_HOST;
     * Stores the client for later use in creating gRPC services, and the query registry which registers the types of supported GRPC Search queries.  
            }
            }
                if (entry.getValue().size() > 1) {
import org.opensearch.plugins.Plugin;  
        return Collections.unmodifiableList(queryConverters);  
        NetworkService networkService,
     * Consumes pluggable security settings as provided by a SecureAuxTransportSettingsProvider.
                    logger.info(
import org.opensearch.env.Environment;
            scriptService,
                providers.stream().map(p -> p.getClass().getName()).collect(Collectors.joining(", "))  
import java.util.Comparator;
        this.client = client;
            aggregationRegistry.updateRegistryOnAllConverters();
            if (!orderedList.isEmpty()) {
     * Returns the executor builders for this plugin's custom thread pools.
import org.opensearch.core.xcontent.NamedXContentRegistry;
    private GrpcInterceptorChain serverInterceptor; // Initialized in createComponents
     * @param settings the current settings
            queryRegistry.updateRegistryOnAllConverters();  
                    converter.getClass().getName(),  
            logger.info("Successfully loaded {} QueryBuilderProtoConverter extensions", extensions.size());
            logger.info("No AggregationBuilderProtoConverter extensions found from other plugins");
                );  
                    .build();  
            client,  
     *
        ThreadPool threadPool,
        return List.of(
                for (BindableService pluginService : pluginServices) {
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;  
        ClusterService clusterService,  
     * @throws IllegalStateException if queryRegistry is not initialized  
    /**  
                        "Multiple gRPC interceptors have the same order value ["
            clusterService,
                            + conflictingInterceptors
     *
                secureAuxTransportSettingsProvider,  
        }
        }  
                    "Processing external aggregation converter: {} (handles: {})",
            logger.info("Injecting registry and registering {} external AggregationBuilderProtoConverter(s)", aggregationConverters.size());
    public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {  
 * Main class for the gRPC plugin.
     */
                        .collect(Collectors.joining(", "));
                );
            }
            logger.info("No external QueryBuilderProtoConverter(s) to register");  
                    converter.getClass().getName(),
import org.opensearch.transport.grpc.proto.request.search.aggregation.AggregationBuilderProtoConverterRegistryImpl;
            nodeEnvironment,
     * @param resourceWatcherService The resource watcher service
            }
                List.of(
        NetworkService networkService,
import org.opensearch.transport.grpc.services.DocumentServiceImpl;  
        if (!aggregateConverters.isEmpty()) {  
            logger.info(
                    "Discovered AggregationBuilderProtoConverter extension: {} (handles: {})",  
            SETTING_GRPC_SECURE_PORT,
        Tracer tracer  
     * @param secureAuxTransportSettingsProvider provides ssl context params
        }
                            + entry.getKey()
     * Creates components used by the plugin.
                    converter.getHandledQueryCase()
package org.opensearch.transport.grpc;
    ) {
    /**  
import org.opensearch.env.NodeEnvironment;  
        ClusterSettings clusterSettings,
    ) {
                logger.info(  
import org.opensearch.repositories.RepositoriesService;
     * Creates a new GrpcPlugin instance.
public final class GrpcPlugin extends Plugin implements NetworkPlugin, ExtensiblePlugin {  
        );
import java.util.Map;
                    converter.getClass().getName(),
                    .initThreadPool(threadPool)
     *
                }
                aggregationConverters.add(converter);
            SETTING_GRPC_BIND_HOST,
     * with OpenSearch's thread pool monitoring and management system.  
    private AggregationBuilderProtoConverterRegistryImpl aggregationRegistry;
     * @return A list of settings  
                // Create a single chain interceptor that manages the execution
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        // Create the aggregation registry
            }  
                aggregateRegistry.registerConverter(converter);  
import org.opensearch.common.settings.Settings;
     */
        final int executorCount = SETTING_GRPC_EXECUTOR_COUNT.get(settings);
            // Update the registry on all converters (including built-in ones) so they can access external converters
 * The OpenSearch Contributors require contributions made to  
     * @param scriptService The script service  
        List<AggregateProtoConverter> aggResponseExtensions = loader.loadExtensions(AggregateProtoConverter.class);  
                    converter.getHandledAggregationType().getName()
    public GrpcPlugin() {}  
            SETTING_GRPC_PUBLISH_PORT,  
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
        return super.createComponents(
     * @param threadPool The thread pool
     * @param clusterService The cluster service  
        return List.of(
/**  
                    );  
                int order = interceptor.order();
                networkService,
import java.util.Collection;  
                    converter.getHandledAggregationCase()
    }  
    }  
        Environment environment,
     * @return The query utils instance  
                        .stream()  
            logger.info("Successfully injected registry and registered all {} external converters", queryConverters.size());  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONNECTION_IDLE;  
            );
        this.aggregateRegistry = new AggregateProtoConverterRegistryImpl();
    private QueryBuilderProtoConverterRegistryImpl queryRegistry;
        List<GrpcServiceFactory> services = loader.loadExtensions(GrpcServiceFactory.class);
            SETTING_GRPC_PUBLISH_HOST,  
    /**
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_WORKER_COUNT;
    }
import org.opensearch.transport.grpc.services.SearchServiceImpl;
        // Load aggregate converters (response-side) from other plugins
                    String conflictingInterceptors = entry.getValue()
                provider.initNodeSettings(environment.settings());  
     *
                    new DocumentServiceImpl(client, circuitBreakerService),  
            for (GrpcInterceptorProvider provider : interceptorProviders) {
import org.opensearch.plugins.ExtensiblePlugin;
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PORT;
    public Collection<Object> createComponents(
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_BIND_HOST;  
            SETTING_GRPC_HOST,
                            + "]: "  
                    converter.getClass().getName(),  
        ClusterSettings clusterSettings,
     * @param networkService The network service
            throw new RuntimeException("createComponents must be called first to initialize server provided resources.");  
            for (AggregationBuilderProtoConverter converter : aggExtensions) {
                }
    @Override
        // Initialize the interceptor chain with ThreadContext
import static org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport.SETTING_GRPC_SECURE_PORT;
            logger.info("Updated registry on all converters to include external converters");
                converter.setRegistry(aggregationRegistry);
        this.queryUtils = new AbstractQueryBuilderProtoUtils(queryRegistry);
import org.opensearch.plugins.NetworkPlugin;
        } else {
                List.of(
                orderedList.addAll(provider.getOrderedGrpcInterceptors(threadPool.getThreadContext()));
        }
            }
                        "{} gRPC services loaded from plugin: {}",  
            orderedList.sort(Comparator.comparingInt(OrderedGrpcInterceptor::order));
        if (!interceptorProviders.isEmpty()) {
 */
