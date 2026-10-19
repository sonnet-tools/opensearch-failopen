            } catch (Exception e) {
     */
import org.opensearch.env.NodeEnvironment;
     * @param tracer The tracer instance.
        }
    }
import org.opensearch.common.settings.Settings;
                )
/**
     * @param settingsFilter The settings filter instance.
import org.opensearch.arrow.flight.stats.FlightStatsCollector;
            ServerConfig.getGrpcExecutorBuilder(),  
     * @param settings The settings for the plugin.  
        }  
        }
    ) {
        ClusterSettings clusterSettings,
     */
     * Constructor for FlightStreamPluginImpl.  
            SslContextProvider sslContextProvider = new DefaultSslContextProvider(secureTransportSettingsProvider, settings);
    ) {  
        IndexNameExpressionResolver indexNameExpressionResolver,
    /**
        ThreadPool threadPool,  
     * @param clusterSettings The cluster settings instance.  
        PageCacheRecycler pageCacheRecycler,
        if (!isStreamTransportEnabled) {  
        CircuitBreakerService circuitBreakerService,  
        PageCacheRecycler pageCacheRecycler,
import org.opensearch.common.util.FeatureFlags;
import java.util.List;
    }  
     * Gets the secure transports for the FlightStream plugin.
            );
    @Override
    public List<RestHandler> getRestHandlers(
        return Collections.emptyMap();
     * @param namedWriteableRegistry The named writeable registry.
        );
                    circuitBreakerService,  
    }
import org.opensearch.common.settings.Setting;
import org.opensearch.arrow.flight.bootstrap.ServerConfig;  
        Settings settings,
 * SPDX-License-Identifier: Apache-2.0
                "FLIGHT-SECURE",  
 *
     * @param nodesInCluster The supplier for the discovery nodes.
/*  
        statsCollector = new FlightStatsCollector();  
    /**
        SecureTransportSettingsProvider secureTransportSettingsProvider,  
     * @param indexScopedSettings The index scoped settings instance.
                    Version.CURRENT,  
     * @return A map of auxiliary transports.  
            )
                addAll(ServerConfig.getSettings());
        NetworkService networkService,
            {
    }
import org.opensearch.plugins.ExtensiblePlugin;
        ThreadPool threadPool,
    }
import org.opensearch.common.util.PageCacheRecycler;
import org.opensearch.transport.client.Client;  
import java.util.Collections;  
import org.opensearch.transport.AuxTransport;
     * @param threadPool The thread pool instance.
     * @param namedWriteableRegistry The named writeable registry.
        }  
import org.opensearch.script.ScriptService;  
                "FLIGHT",  
        if (!isStreamTransportEnabled) {
import org.opensearch.arrow.flight.bootstrap.tls.DefaultSslContextProvider;
        NamedWriteableRegistry namedWriteableRegistry,
    /**
     * Gets the list of ExecutorBuilder instances for building thread pools used for FlightServer.
    public List<ActionHandler<?, ?>> getActions() {
import org.opensearch.watcher.ResourceWatcherService;
                    nativeAllocator  
            Arrays.asList(
    @Override
            try {  
                throw new RuntimeException("Failed to initialize Arrow Flight server", e);  
     * @param tracer The tracer instance.
     * @param pageCacheRecycler The page cache recycler instance.
    }
        Tracer tracer
        return Collections.singletonList(new ActionHandler<>(FlightStatsAction.INSTANCE, TransportFlightStatsAction.class));
     * @param pageCacheRecycler The page cache recycler instance.
        Settings settings,  
            return Collections.emptyList();
     */  
        if (!isStreamTransportEnabled) {
import org.opensearch.common.settings.SettingsFilter;  
        if (isStreamTransportEnabled) {
                    statsCollector,
                ServerConfig.SETTING_FLIGHT_PUBLISH_PORT
 * compatible open source license.
     * @param indexNameExpressionResolver The index name expression resolver instance.  
            return Collections.emptyList();
                    tracer,  
import org.opensearch.arrow.flight.bootstrap.tls.SslContextProvider;
     */
     * @param settings The settings for the plugin.  
            return Collections.emptyList();
        Settings settings,
    @Override
                    namedWriteableRegistry,
     */
        };
}
     * @param circuitBreakerService The circuit breaker service instance.  
            }  
import org.opensearch.telemetry.tracing.Tracer;
                    sslContextProvider,
            return Collections.emptyList();  
     * Gets the list of action handlers for the FlightStream plugin.
        SettingsFilter settingsFilter,
     * @param circuitBreakerService The circuit breaker service instance.
import java.util.ArrayList;  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
     * @param threadPool The thread pool instance.
        PluginComponentRegistry pluginComponentRegistry  
        Supplier<DiscoveryNodes> nodesInCluster  
    ) {
    @Override
        return List.of(
import org.opensearch.plugins.ClusterPlugin;  
        ClusterService clusterService,
        CircuitBreakerService circuitBreakerService,  
                    threadPool,
     * @param settings The settings for the plugin.  
        ScriptService scriptService,
import org.opensearch.rest.RestHandler;
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
import org.opensearch.arrow.flight.stats.FlightStatsAction;  
    ) {
    ) {
import org.opensearch.plugins.PluginComponentRegistry;
    private ArrowNativeAllocator nativeAllocator;  
import org.opensearch.common.settings.IndexScopedSettings;  
        }  
     * @param networkService The network service instance.  
        ResourceWatcherService resourceWatcherService,
 * FlightStreamPlugin class extends BaseFlightStreamPlugin and provides implementation for FlightStream plugin.  
package org.opensearch.arrow.flight.transport;
            }
    @Override
import org.opensearch.transport.Transport;
import org.opensearch.env.Environment;  
    }  
    public Map<String, Supplier<AuxTransport>> getAuxTransports(  
import org.opensearch.plugins.ActionPlugin;
import java.util.Arrays;
     * @param secureTransportSettingsProvider The secure transport settings provider.  
     * @return A map of secure transports.
        ) {  
     * @param settings The settings for the plugin.
     * @param restController The REST controller instance.
                )
 * The OpenSearch Contributors require contributions made to  
     * @param tracer The tracer instance.  
    @Override
                    settings,
    }  
                ServerConfig.SETTING_FLIGHT_BIND_HOST,
    private FlightStatsCollector statsCollector;
     * Gets the secure transports for the FlightStream plugin.
    public List<Setting<?>> getSettings() {  
import org.opensearch.cluster.node.DiscoveryNodes;
        Settings settings,  
            );
     * @param threadPool The thread pool instance.
        if (isStreamTransportEnabled && !ServerConfig.isSslEnabled()) {
        if (isStreamTransportEnabled && ServerConfig.isSslEnabled()) {  
        NetworkService networkService,
    public FlightStreamPlugin(Settings settings) {  
    public Map<String, Supplier<Transport>> getSecureTransports(
    /**  
        RestController restController,
                    null,
            ServerConfig.getServerExecutorBuilder(),
     */  
        if (!isStreamTransportEnabled) {
import org.opensearch.rest.RestController;
            .orElseThrow(() -> new IllegalStateException("ArrowNativeAllocator not available; arrow-base plugin must be installed"));
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {  
                ServerConfig.SETTING_FLIGHT_HOST,
        this.isStreamTransportEnabled = FeatureFlags.isEnabled(FeatureFlags.STREAM_TRANSPORT);
                    networkService,
import org.opensearch.plugins.NetworkPlugin;
    /**
        ThreadPool threadPool,
import org.opensearch.threadpool.ExecutorBuilder;
     * @param clusterSettings The cluster settings instance.
    public Map<String, Supplier<Transport>> getTransports(
import org.opensearch.core.xcontent.NamedXContentRegistry;
        return Collections.emptyMap();
public class FlightStreamPlugin extends Plugin implements NetworkPlugin, ActionPlugin, ClusterPlugin, ExtensiblePlugin {
    private final boolean isStreamTransportEnabled;
        Supplier<RepositoriesService> repositoriesServiceSupplier,
        ThreadPool threadPool,  
        NamedXContentRegistry xContentRegistry,  
     * @param settings The settings for the plugin  
            return Collections.singletonMap(
    /**
     * Gets the list of settings for the Flight plugin.  
        CircuitBreakerService circuitBreakerService,
import org.opensearch.Version;
 */  
        }
                () -> new FlightTransport(
                    tracer,  
     * Gets the auxiliary transports for the FlightStream plugin.
    @Override
                ServerConfig.init(settings);
        Environment environment,
                    circuitBreakerService,  
     * Gets the REST handlers for the FlightStream plugin.  
 * this file be licensed under the Apache-2.0 license or a
        IndexScopedSettings indexScopedSettings,  
        }
        Client client,
     * @param circuitBreakerService The circuit breaker service instance.  
                    nativeAllocator  
        ClusterSettings clusterSettings,
                    threadPool,
                    pageCacheRecycler,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.opensearch.common.settings.ClusterSettings;
                ServerConfig.SETTING_FLIGHT_PORTS,  
import org.opensearch.cluster.service.ClusterService;  
    }
    /**
                () -> new FlightTransport(
import java.util.Collection;
import org.opensearch.arrow.flight.stats.FlightStatsRestHandler;
    public Collection<Object> createComponents(  
        NodeEnvironment nodeEnvironment,
     * @return A list of REST handlers.
import org.opensearch.threadpool.ThreadPool;  
        IndexNameExpressionResolver indexNameExpressionResolver,
                ServerConfig.SETTING_FLIGHT_PUBLISH_HOST,  
        this.nativeAllocator = pluginComponentRegistry.getComponent(ArrowNativeAllocator.class)  
        Tracer tracer
        return List.of(statsCollector);
     * @param networkService The network service instance.
     */  
        Tracer tracer  
import org.opensearch.plugins.SecureTransportSettingsProvider;
            return Collections.emptyList();  
        NetworkService networkService,
        return Collections.emptyMap();
        if (!isStreamTransportEnabled) {
import java.util.Map;
     * @return A list of action handlers.
        NamedWriteableRegistry namedWriteableRegistry,  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
     * @return A map of secure transports.
                    pageCacheRecycler,
import java.util.function.Supplier;  
        }  
        NamedWriteableRegistry namedWriteableRegistry,  
        return new ArrayList<>(
                    namedWriteableRegistry,
            ServerConfig.getClientExecutorBuilder()
    @Override  
import org.opensearch.arrow.flight.stats.TransportFlightStatsAction;  
    /**
import org.opensearch.repositories.RepositoriesService;  
import org.opensearch.common.network.NetworkService;
                    Version.CURRENT,  
import org.opensearch.plugins.Plugin;  
     * @param settings The settings for the FlightStreamPlugin.
     * @param networkService The network service instance.
     */
            return Collections.singletonMap(
                    settings,
                    networkService,
 */
                    statsCollector,
        return Collections.singletonList(new FlightStatsRestHandler());  
