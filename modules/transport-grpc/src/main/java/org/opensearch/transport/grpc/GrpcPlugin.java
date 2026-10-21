     */
        ThreadPool threadPool,
            scriptService,
     *
     * Stores the client for later use in creating gRPC services, and the query registry which registers the types of supported GRPC Search queries.
                        serviceFac.plugin()
        ScriptService scriptService,
                networkService,
                        "Multiple gRPC interceptors have the same order value ["
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
                grpcServices.addAll(pluginServices);
        if (extensions != null && !extensions.isEmpty()) {
import java.util.function.Supplier;
import org.opensearch.plugins.ExtensiblePlugin;
     * @param client The client
     * @param environment The environment
                        .map(i -> i.getInterceptor().getClass().getName() + "(order=" + i.order() + ")")
                    .initClusterSettings(clusterSettings)
     */
            logger.info("Updated aggregate registry on all converters to include external converters");
                    converter.getHandledQueryCase()
import org.opensearch.plugins.Plugin;
                logger.info(
     * @param settings The node settings
     * Registered under a distinct key from gRPC transport.
            for (OrderedGrpcInterceptor interceptor : orderedList) {
            SETTING_GRPC_PUBLISH_HOST,
                threadPool,
     * @param namedWriteableRegistry The named writeable registry
    private final List<AggregationBuilderProtoConverter> aggregationConverters = new ArrayList<>();
            indexNameExpressionResolver,
import io.grpc.BindableService;
import org.opensearch.threadpool.ThreadPool;
        if (client == null || queryRegistry == null) {
                logger.info(
import java.util.List;
                    .build();
                aggregateConverters.add(converter);
            xContentRegistry,
                    converter.getClass().getName(),
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_MSG_SIZE;
 * Main class for the gRPC plugin.
        return Collections.singletonMap(GRPC_SECURE_TRANSPORT_SETTING_KEY, () -> {
import org.opensearch.transport.grpc.services.SearchServiceImpl;
     * Provides secure auxiliary transports for the plugin.
        } else {
                    "Processing external converter: {} (handles: {})",
        List<AggregateProtoConverter> aggResponseExtensions = loader.loadExtensions(AggregateProtoConverter.class);
    public List<Setting<?>> getSettings() {
        Client client,
                // Register the converter
        } else {
}
                        serviceFac.plugin()
                    converter.getClass().getName(),
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.script.ScriptService;
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS;
            SETTING_GRPC_MAX_CONCURRENT_CONNECTION_CALLS,
                    .initThreadPool(threadPool)
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONNECTION_AGE;
     * @param tracer The tracer
     * Creates a new GrpcPlugin instance.
 * The OpenSearch Contributors require contributions made to
            );
     * @param clusterSettings The cluster settings
     */
                services.stream().map(GrpcServiceFactory::plugin).collect(Collectors.joining(", "))
     * Consumes pluggable security settings as provided by a SecureAuxTransportSettingsProvider.
        // Inject registry into external aggregation converters and register them
            throw new RuntimeException("createComponents must be called first to initialize server provided resources.");
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
    ) {
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_WORKER_COUNT;
                        .map(i -> i.getInterceptor().getClass().getName())
import org.opensearch.common.settings.ClusterSettings;
                );
                            + entry.getKey()
public final class GrpcPlugin extends Plugin implements NetworkPlugin, ExtensiblePlugin {
                grpcServices,
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
     * @param threadPool The thread pool
            // For now, we collect providers to be initialized later with ThreadContext
                orderedList.addAll(provider.getOrderedGrpcInterceptors(threadPool.getThreadContext()));
                logger.info(
    /**
import org.opensearch.transport.grpc.interceptor.GrpcInterceptorChain;
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_MAX_CONNECTION_IDLE;
                List.of(
            logger.info("Loading {} QueryBuilderProtoConverter extensions from other plugins", extensions.size());
import static org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport.GRPC_SECURE_TRANSPORT_SETTING_KEY;
    @Override
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.GRPC_TRANSPORT_SETTING_KEY;
     * @param clusterSettings The cluster settings
            for (GrpcServiceFactory serviceFac : servicesFactory) {
        // Then add plugin-provided interceptors
    @Override
import java.util.HashMap;
            SETTING_GRPC_MAX_CONNECTION_AGE,
                "Successfully injected registry and registered all {} external aggregation converters",
                providers.stream().map(p -> p.getClass().getName()).collect(Collectors.joining(", "))
                    "Discovered AggregationBuilderProtoConverter extension: {} (handles: {})",
                )
            logger.info(
import org.opensearch.telemetry.tracing.Tracer;
        this.client = client;
    /**
                    logger.info(
    }
                List.of(
                logger.info(
    @Override
            // Update the registry on all converters (including built-in ones) so they can access external converters
    ) {
import java.util.Comparator;
     * @param xContentRegistry The named content registry
                    );
            SETTING_GRPC_KEEPALIVE_TIMEOUT
                List<BindableService> pluginServices = serviceFac.initClient(client)
                );
        NamedWriteableRegistry namedWriteableRegistry,
        ClusterSettings clusterSettings,
            logger.info("No AggregateProtoConverter extensions found from other plugins");
            );
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        // Create the aggregation registry
                logger.info(
     * @return A map of transport names to transport suppliers
                    converter.getHandledAggregationType().getName()
        // Load aggregation converters from other plugins
            logger.info("Successfully loaded {} AggregateProtoConverter extensions", aggResponseExtensions.size());
                queryConverters.add(converter);
     * @return A list of settings
                aggregationConverters.size()
            logger.info("Injecting registry and registering {} external QueryBuilderProtoConverter(s)", queryConverters.size());
    /**
            }
                            + "]: "
            SETTING_GRPC_WORKER_COUNT,
            this.interceptorProviders = providers;
                    converter.getClass().getName(),
        }
            logger.info("Successfully injected registry and registered all {} external converters", queryConverters.size());
                    .build();
                // Inject the populated registry into the converter
        }
    public GrpcPlugin() {}
            Map<Integer, List<OrderedGrpcInterceptor>> orderMap = new HashMap<>();
            new FixedExecutorBuilder(settings, GRPC_THREAD_POOL_NAME, executorCount, 1000, "thread_pool." + GRPC_THREAD_POOL_NAME)
        Environment environment,
            logger.info("Successfully registered all {} external aggregate converters", aggregateConverters.size());
    private AbstractQueryBuilderProtoUtils queryUtils;
                    "Discovered AggregateProtoConverter extension: {} (handles: {})",
            // Check for duplicates and throw exception if found
        this.serverInterceptor = new GrpcInterceptorChain(threadPool.getThreadContext());
     * @param tracer The tracer
            repositoriesServiceSupplier
        ThreadPool threadPool,
    public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {
                for (BindableService pluginService : pluginServices) {
     * Provides auxiliary transports for the plugin.
    }
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;
                "Successfully loaded {} GrpcServiceFactory extensions [{}]",
                    );
            SETTING_GRPC_MAX_CONNECTION_IDLE,
    /**
     */
    @Override
        CircuitBreakerService circuitBreakerService,
import org.opensearch.plugins.NetworkPlugin;
     */
            namedWriteableRegistry,
                aggregationRegistry.registerConverter(converter);
            SETTING_GRPC_BIND_HOST,
        } else {
            for (Map.Entry<Integer, List<OrderedGrpcInterceptor>> entry : orderMap.entrySet()) {
 *
        );
 * this file be licensed under the Apache-2.0 license or a
            clusterService,
     * @param indexNameExpressionResolver The index name expression resolver
            SETTING_GRPC_MAX_MSG_SIZE,
                    "Processing external aggregation converter: {} (handles: {})",
     * @param clusterService The cluster service
                );
        Settings settings,
                logger.info("Injected registry into converter: {}", converter.getClass().getName());
     * Creates components used by the plugin.
            );
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_HOST;
        return queryUtils;
        });
                // Create a single chain interceptor that manages the execution
import org.apache.logging.log4j.Logger;
        List<OrderedGrpcInterceptor> orderedList = new ArrayList<>();
     *
            aggregateRegistry.updateRegistryOnAllConverters();
            for (AggregationBuilderProtoConverter converter : aggExtensions) {
            // Validate that no two interceptors have the same order
                }
     *
        // Create the query utils instance
            SETTING_GRPC_EXECUTOR_COUNT,
                    orderedList.stream()
     * @param threadPool The thread pool
        );
import org.opensearch.watcher.ResourceWatcherService;
     * @param secureAuxTransportSettingsProvider provides ssl context params
     * @param threadPool The thread pool
 * SPDX-License-Identifier: Apache-2.0
            logger.info("Loading {} AggregateProtoConverter extensions from other plugins", aggResponseExtensions.size());
import java.util.ArrayList;
        }
        ClusterService clusterService,
        List<QueryBuilderProtoConverter> extensions = loader.loadExtensions(QueryBuilderProtoConverter.class);
        NetworkService networkService,
     */
import java.util.Collection;
    public Map<String, Supplier<AuxTransport>> getSecureAuxTransports(
     *
        if (!aggregateConverters.isEmpty()) {
                // Inject the populated registry into the converter
        }
        }
        if (services != null) {
                        .collect(Collectors.joining(", "));
                        .stream()
    private final List<AggregateProtoConverter> aggregateConverters = new ArrayList<>();
import org.opensearch.env.NodeEnvironment;
        // Load query converters from other plugins
                    converter.getClass().getName(),
     * @return The query utils instance
                queryRegistry.registerConverter(converter);
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_KEEPALIVE_TIMEOUT;
     * @param networkService The network service
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_EXECUTOR_COUNT;
                    logger.info(
            SETTING_GRPC_SECURE_PORT,
            }
            logger.info(
    }
     * Get the list of query converters, including those loaded from extensions.
        }
            logger.info("Updated aggregation registry on all converters to include external converters");
    }
import org.opensearch.transport.AuxTransport;
        });
import org.opensearch.repositories.RepositoriesService;
                }
     */
                aggregationConverters.add(converter);
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_PORT;
        if (aggExtensions != null && !aggExtensions.isEmpty()) {
            }
     *
                    new DocumentServiceImpl(client, circuitBreakerService),
import org.opensearch.common.settings.Settings;
    /**
            for (AggregateProtoConverter converter : aggResponseExtensions) {
            throw new RuntimeException("createComponents must be called first to initialize server provided resources.");
            servicesFactory.addAll(services);
                    converter.getHandledQueryCase()
            }
    /**
/*
        CircuitBreakerService circuitBreakerService,
     * @param settings the current settings
     * This method is called by the OpenSearch plugin system to load extensions from other plugins.
        final int executorCount = SETTING_GRPC_EXECUTOR_COUNT.get(settings);
            // Update the registry on all converters (including built-in ones) so they can access external converters
        // Create the aggregate registry (response-side)
    private QueryBuilderProtoConverterRegistryImpl queryRegistry;
        } else {
     * @param repositoriesServiceSupplier The repositories service supplier
        ClusterSettings clusterSettings,
            }
                    orderedList.size(),
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PORT;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    @Override
                    new DocumentServiceImpl(client, circuitBreakerService),
     * @param loader The extension loader to use for loading extensions
            for (AggregationBuilderProtoConverter converter : aggregationConverters) {
            for (GrpcServiceFactory serviceFac : servicesFactory) {
     * @param circuitBreakerService The circuit breaker service
                grpcServices.addAll(pluginServices);
            for (QueryBuilderProtoConverter converter : extensions) {
                    .initSettings(settings)
        if (providers != null) {
            logger.info("Registering {} external AggregateProtoConverter(s)", aggregateConverters.size());
        return Collections.singletonMap(GRPC_TRANSPORT_SETTING_KEY, () -> {
        // Load discovered gRPC service factories
        if (aggResponseExtensions != null && !aggResponseExtensions.isEmpty()) {
     * @param networkService The network service
                // Register the converter
        if (!interceptorProviders.isEmpty()) {
    /**
            }
                orderMap.computeIfAbsent(order, k -> new ArrayList<>()).add(interceptor);
    public Map<String, Supplier<AuxTransport>> getAuxTransports(
                aggregateRegistry.registerConverter(converter);
        List<GrpcServiceFactory> services = loader.loadExtensions(GrpcServiceFactory.class);
import java.util.stream.Collectors;
     * Returns the settings defined by this plugin.
    private final List<QueryBuilderProtoConverter> queryConverters = new ArrayList<>();
import static org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport.SETTING_GRPC_SECURE_PORT;
            List<BindableService> grpcServices = new ArrayList<>(
 * compatible open source license.
                    converter.getHandledAggregationCase()
     * @param circuitBreakerService The circuit breaker service
    private static final Logger logger = LogManager.getLogger(GrpcPlugin.class);
import org.opensearch.transport.grpc.spi.GrpcServiceFactory;
                        .collect(Collectors.joining(", "))
        // Create the registry
            logger.info("No AggregationBuilderProtoConverter extensions found from other plugins");
                        pluginService.bindService().getServiceDescriptor().getName(),
import org.opensearch.threadpool.FixedExecutorBuilder;
            }
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_PUBLISH_HOST;
     * @return The list of query converters
                    .initClusterSettings(clusterSettings)
            for (GrpcInterceptorProvider provider : interceptorProviders) {
            }
        this.queryRegistry = new QueryBuilderProtoConverterRegistryImpl();
import java.util.Map;
                secureAuxTransportSettingsProvider,
                if (entry.getValue().size() > 1) {
 */
            resourceWatcherService,
            logger.info("Injecting registry and registering {} external AggregationBuilderProtoConverter(s)", aggregationConverters.size());
            queryRegistry.updateRegistryOnAllConverters();
            logger.info("No QueryBuilderProtoConverter extensions found from other plugins");
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider;
    private AggregationBuilderProtoConverterRegistryImpl aggregationRegistry;
     *
import org.opensearch.transport.grpc.services.DocumentServiceImpl;
        this.aggregationRegistry = new AggregationBuilderProtoConverterRegistryImpl();
    private AggregateProtoConverterRegistryImpl aggregateRegistry;
     * @return A map of transport names to transport suppliers
        } else {
        }
            }
            SETTING_GRPC_PORT,
                            + ". Each interceptor must have a unique order value."
    /**
        this.aggregateRegistry = new AggregateProtoConverterRegistryImpl();
    }
                converter.setRegistry(queryRegistry);
        }
                logger.info("Injected aggregation registry into converter: {}", converter.getClass().getName());
                services.size(),
            }
                    );
     * @param settings The node settings
        return List.of(
        // Register external aggregate converters (response-side)
            for (AggregateProtoConverter converter : aggregateConverters) {
     * Loads extensions from other plugins.
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
        SecureAuxTransportSettingsProvider secureAuxTransportSettingsProvider,
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;
                );
    @Override
     * @param scriptService The script service
import org.opensearch.env.Environment;
    }
                settings,
                providers.size(),
                    converter.getClass().getName(),
        if (client == null || queryRegistry == null) {
     *
    private final List<GrpcServiceFactory> servicesFactory = new ArrayList<>();
                    "Discovered QueryBuilderProtoConverter extension: {} (handles: {})",
import org.opensearch.threadpool.ExecutorBuilder;
                logger.info(
     * @throws IllegalStateException if queryRegistry is not initialized
                        "{} gRPC services loaded from plugin: {}",
            for (QueryBuilderProtoConverter converter : queryConverters) {
     * with OpenSearch's thread pool monitoring and management system.
            logger.info(
            List<BindableService> grpcServices = new ArrayList<>(
                );
    /**
                    String conflictingInterceptors = entry.getValue()
    public static final String GRPC_THREAD_POOL_NAME = "grpc";
            );
        Settings settings,
        return super.createComponents(
     * @return A collection of components
        Tracer tracer
                    new SearchServiceImpl(client, queryUtils, aggregationRegistry, aggregateRegistry, circuitBreakerService)
            throw new IllegalStateException("Query utils not initialized. Make sure createComponents has been called.");
                provider.initNodeSettings(environment.settings());
            aggregationRegistry.updateRegistryOnAllConverters();
        );
            environment,
                    throw new IllegalArgumentException(
            logger.info("Successfully loaded {} AggregationBuilderProtoConverter extensions", aggExtensions.size());
        if (!aggregationConverters.isEmpty()) {
        if (queryUtils == null) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            // Sort by order and create a chain - similar to OpenSearch's ActionFilter pattern
    }
            logger.info("No external AggregateProtoConverter(s) to register");
     * Get the query utils instance.
        // Initialize the interceptor chain with ThreadContext
     * @return executor builders for this plugin's custom thread pools
        NodeEnvironment nodeEnvironment,
                    "Processing external aggregate converter: {} (handles: {})",
                    .initSettings(settings)
            logger.info("No external AggregationBuilderProtoConverter(s) to register");
    private Client client;
            }
        if (!queryConverters.isEmpty()) {
            nodeEnvironment,
            return new Netty4GrpcServerTransport(settings, grpcServices, networkService, threadPool, serverInterceptor);
import org.opensearch.common.settings.Setting;
                    converter.getHandledAggregationCase()
                    .initThreadPool(threadPool)
                logger.info(
    ) {
 */
            }
        this.queryUtils = new AbstractQueryBuilderProtoUtils(queryRegistry);
        }
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.SETTING_GRPC_BIND_HOST;
        Supplier<RepositoriesService> repositoriesServiceSupplier
        Tracer tracer
                serverInterceptor
            orderedList.sort(Comparator.comparingInt(OrderedGrpcInterceptor::order));
                        pluginService.bindService().getServiceDescriptor().getName(),
        } else {
            return new SecureNetty4GrpcServerTransport(
            // Update the registry on all converters (including built-in ones) so they can access external converters
                )
        ResourceWatcherService resourceWatcherService,
            SETTING_GRPC_PUBLISH_PORT,
    public List<QueryBuilderProtoConverter> getQueryConverters() {
    public Collection<Object> createComponents(
                converter.setRegistry(aggregationRegistry);
import org.opensearch.common.network.NetworkService;
                for (BindableService pluginService : pluginServices) {
     * Returns the executor builders for this plugin's custom thread pools.
            logger.info("Loading {} AggregationBuilderProtoConverter extensions from other plugins", aggExtensions.size());
import org.opensearch.cluster.service.ClusterService;
     * @throws IllegalStateException if queryUtils is not initialized
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider.OrderedGrpcInterceptor;
    private List<GrpcInterceptorProvider> interceptorProviders = new ArrayList<>();
    private GrpcInterceptorChain serverInterceptor; // Initialized in createComponents
            threadPool,
            if (!orderedList.isEmpty()) {
import org.apache.logging.log4j.LogManager;
                int order = interceptor.order();
        ThreadPool threadPool,
                    converter.getClass().getName(),
            logger.info("Successfully loaded {} QueryBuilderProtoConverter extensions", extensions.size());
package org.opensearch.transport.grpc;
     * @param resourceWatcherService The resource watcher service
                }
     */
                );
     * @param nodeEnvironment The node environment
     * @throws IllegalStateException if queryRegistry is not initialized
            );
            logger.info("Updated registry on all converters to include external converters");
                List<BindableService> pluginServices = serviceFac.initClient(client)
        // Inject registry into external converters and register them
        NamedXContentRegistry xContentRegistry,
        NetworkService networkService,
            SETTING_GRPC_HOST,
        List<AggregationBuilderProtoConverter> aggExtensions = loader.loadExtensions(AggregationBuilderProtoConverter.class);
                    "Loaded {} gRPC interceptors into chain in order: [{}]",
                );
/**
        }
        }
        return Collections.unmodifiableList(queryConverters);
    /** The name of the gRPC thread pool */
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
                "Found {} gRPC interceptor providers [{}], will initialize during component creation",
                serverInterceptor.addInterceptors(orderedList);
     * Creates and returns a map of transport names to transport suppliers.
        // Load aggregate converters (response-side) from other plugins
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                        "{} gRPC services loaded from plugin: {}",
                // This ensures proper ordering and exception handling
import org.opensearch.transport.grpc.ssl.SecureNetty4GrpcServerTransport;
                    new SearchServiceImpl(client, queryUtils, aggregationRegistry, aggregateRegistry, circuitBreakerService)
     *
import org.opensearch.transport.grpc.proto.request.search.aggregation.AggregationBuilderProtoConverterRegistryImpl;
import java.util.Collections;
                    converter.getHandledAggregationType().getName()
import org.opensearch.transport.client.Client;
        List<GrpcInterceptorProvider> providers = loader.loadExtensions(GrpcInterceptorProvider.class);
            );
    }
            client,
     */
     * Creates a dedicated thread pool for gRPC request processing that integrates
                            + conflictingInterceptors
    public AbstractQueryBuilderProtoUtils getQueryUtils() {
        }
        return List.of(
            logger.info("No external QueryBuilderProtoConverter(s) to register");
            // Note: ThreadContext will be provided during component creation
