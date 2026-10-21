        statsCollector = new FlightStatsCollector();
import java.util.function.Supplier;
                    tracer,
    ) {
            ServerConfig.getServerExecutorBuilder(),
import org.opensearch.core.indices.breaker.CircuitBreakerService;
 * FlightStreamPlugin class extends BaseFlightStreamPlugin and provides implementation for FlightStream plugin.
            SslContextProvider sslContextProvider = new DefaultSslContextProvider(secureTransportSettingsProvider, settings);
    }
 *
                () -> new FlightTransport(
     * Constructor for FlightStreamPluginImpl.
import org.opensearch.common.network.NetworkService;
        }
     * @param pageCacheRecycler The page cache recycler instance.
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.settings.Setting;
     * @param restController The REST controller instance.
 */
            }
     * @return A list of action handlers.
     * @param pageCacheRecycler The page cache recycler instance.
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    sslContextProvider,
                ServerConfig.SETTING_FLIGHT_PUBLISH_HOST,
            return Collections.emptyList();
import org.opensearch.arrow.flight.bootstrap.ServerConfig;
                    threadPool,
     * @param networkService The network service instance.
                () -> new FlightTransport(
/*
        NamedWriteableRegistry namedWriteableRegistry,
        }
                    Version.CURRENT,
                )
    ) {
                    namedWriteableRegistry,
     * @param settings The settings for the plugin.
            ServerConfig.getGrpcExecutorBuilder(),
        ClusterService clusterService,
                ServerConfig.SETTING_FLIGHT_BIND_HOST,
     */
import org.opensearch.core.xcontent.NamedXContentRegistry;
        NetworkService networkService,
    ) {
            ServerConfig.getClientExecutorBuilder()
    @Override
    }
     * @param threadPool The thread pool instance.
        Tracer tracer
     * @return A list of REST handlers.
import org.opensearch.arrow.flight.stats.FlightStatsRestHandler;
import org.opensearch.transport.AuxTransport;
     * @param settings The settings for the plugin
import org.opensearch.plugins.NetworkPlugin;
    public FlightStreamPlugin(Settings settings) {
        ThreadPool threadPool,
        return Collections.singletonList(new ActionHandler<>(FlightStatsAction.INSTANCE, TransportFlightStatsAction.class));
                    nativeAllocator
        Environment environment,
import org.opensearch.arrow.flight.bootstrap.tls.DefaultSslContextProvider;
        SecureTransportSettingsProvider secureTransportSettingsProvider,
        if (isStreamTransportEnabled && ServerConfig.isSslEnabled()) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import java.util.Collections;
import org.opensearch.transport.client.Client;
                ServerConfig.SETTING_FLIGHT_PORTS,
    }
            return Collections.emptyList();
        return Collections.singletonList(new FlightStatsRestHandler());
    @Override
import org.opensearch.script.ScriptService;
    @Override
     */
        Settings settings,
                    threadPool,
import org.opensearch.cluster.node.DiscoveryNodes;
    public List<ActionHandler<?, ?>> getActions() {
    /**
        return Collections.emptyMap();
import java.util.Arrays;
import org.opensearch.plugins.Plugin;
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
        PluginComponentRegistry pluginComponentRegistry
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.SettingsFilter;
import org.opensearch.repositories.RepositoriesService;
                addAll(ServerConfig.getSettings());
        RestController restController,
     */
     * @return A map of secure transports.
import org.opensearch.transport.Transport;
        if (!isStreamTransportEnabled) {
        CircuitBreakerService circuitBreakerService,
        }
    }
    /**
     * @param settings The settings for the FlightStreamPlugin.
/**
                    settings,
     * Gets the secure transports for the FlightStream plugin.
        }
        CircuitBreakerService circuitBreakerService,
    }
            Arrays.asList(
                    nativeAllocator
import org.opensearch.plugins.SecureTransportSettingsProvider;
import org.opensearch.arrow.flight.stats.TransportFlightStatsAction;
    private ArrowNativeAllocator nativeAllocator;
        ThreadPool threadPool,
        if (isStreamTransportEnabled) {
 * The OpenSearch Contributors require contributions made to
        Tracer tracer
import org.opensearch.plugins.ClusterPlugin;
     */
import java.util.ArrayList;
    ) {
        IndexNameExpressionResolver indexNameExpressionResolver,
            );
    /**
                ServerConfig.SETTING_FLIGHT_HOST,
    }
                    pageCacheRecycler,
     * Gets the list of ExecutorBuilder instances for building thread pools used for FlightServer.
        if (!isStreamTransportEnabled) {
                ServerConfig.SETTING_FLIGHT_PUBLISH_PORT
    @Override
    @Override
            )
    @Override
        if (isStreamTransportEnabled && !ServerConfig.isSslEnabled()) {
        NodeEnvironment nodeEnvironment,
import java.util.Collection;
     * @param indexScopedSettings The index scoped settings instance.
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        ResourceWatcherService resourceWatcherService,
import java.util.Map;
                    circuitBreakerService,
            .orElseThrow(() -> new IllegalStateException("ArrowNativeAllocator not available; arrow-base plugin must be installed"));
        ClusterSettings clusterSettings,
     */
                ServerConfig.init(settings);
 * compatible open source license.
     * @param namedWriteableRegistry The named writeable registry.
        IndexNameExpressionResolver indexNameExpressionResolver,
     * @param circuitBreakerService The circuit breaker service instance.
     * Gets the list of action handlers for the FlightStream plugin.
                    Version.CURRENT,
     * @param circuitBreakerService The circuit breaker service instance.
            );
     * Gets the list of settings for the Flight plugin.
    }
     * @return A map of auxiliary transports.
    public Map<String, Supplier<AuxTransport>> getAuxTransports(
     * @param tracer The tracer instance.
            return Collections.emptyList();
        if (!isStreamTransportEnabled) {
import org.opensearch.telemetry.tracing.Tracer;
    ) {
import org.opensearch.env.NodeEnvironment;
        }
        CircuitBreakerService circuitBreakerService,
            }
        return List.of(statsCollector);
     * @param circuitBreakerService The circuit breaker service instance.
        PageCacheRecycler pageCacheRecycler,
     * @param namedWriteableRegistry The named writeable registry.
                    networkService,
import org.opensearch.common.settings.Settings;
        PageCacheRecycler pageCacheRecycler,
        return Collections.emptyMap();
     * @param networkService The network service instance.
    public List<Setting<?>> getSettings() {
     * @param settings The settings for the plugin.
            {
    /**
        NamedWriteableRegistry namedWriteableRegistry,
     */
                    namedWriteableRegistry,
        Tracer tracer
        if (!isStreamTransportEnabled) {
                "FLIGHT-SECURE",
    private FlightStatsCollector statsCollector;
import org.opensearch.plugins.PluginComponentRegistry;
            return Collections.singletonMap(
     * @param threadPool The thread pool instance.
        NetworkService networkService,
     * @param threadPool The thread pool instance.
     * @param settings The settings for the plugin.
        return Collections.emptyMap();
    private final boolean isStreamTransportEnabled;
     * @param secureTransportSettingsProvider The secure transport settings provider.
        IndexScopedSettings indexScopedSettings,
import org.opensearch.rest.RestHandler;
    @Override
                    null,
                    settings,
import org.opensearch.env.Environment;
        }
     * @param tracer The tracer instance.
        };
}
    public Collection<Object> createComponents(
import org.opensearch.threadpool.ExecutorBuilder;
    /**
 */
     * Gets the secure transports for the FlightStream plugin.
     * @param settingsFilter The settings filter instance.
    @Override
public class FlightStreamPlugin extends Plugin implements NetworkPlugin, ActionPlugin, ClusterPlugin, ExtensiblePlugin {
    public List<RestHandler> getRestHandlers(
                    pageCacheRecycler,
        return List.of(
import org.opensearch.common.util.PageCacheRecycler;
        ThreadPool threadPool,
import org.opensearch.watcher.ResourceWatcherService;
            return Collections.emptyList();
import org.opensearch.plugins.ActionPlugin;
                    statsCollector,
import org.opensearch.arrow.flight.stats.FlightStatsCollector;
import org.opensearch.plugins.ExtensiblePlugin;
        ScriptService scriptService,
import org.opensearch.common.util.FeatureFlags;
        Settings settings,
import org.opensearch.rest.RestController;
import org.opensearch.arrow.flight.bootstrap.tls.SslContextProvider;
     */
                    tracer,
        NetworkService networkService,
     * Gets the auxiliary transports for the FlightStream plugin.
    /**
                "FLIGHT",
     * @param networkService The network service instance.
import org.opensearch.common.settings.IndexScopedSettings;
                    networkService,
     */
                    circuitBreakerService,
            try {
    /**
        Supplier<DiscoveryNodes> nodesInCluster
     * @param clusterSettings The cluster settings instance.
import org.opensearch.threadpool.ThreadPool;
     * @param nodesInCluster The supplier for the discovery nodes.
            } catch (Exception e) {
        NamedXContentRegistry xContentRegistry,
        Settings settings,
import org.opensearch.common.settings.ClusterSettings;
        Supplier<RepositoriesService> repositoriesServiceSupplier,
        ClusterSettings clusterSettings,
        SettingsFilter settingsFilter,
     * @param indexNameExpressionResolver The index name expression resolver instance.
        return new ArrayList<>(
     * @return A map of secure transports.
        Settings settings,
    public Map<String, Supplier<Transport>> getSecureTransports(
package org.opensearch.arrow.flight.transport;
        Client client,
        if (!isStreamTransportEnabled) {
                    statsCollector,
                throw new RuntimeException("Failed to initialize Arrow Flight server", e);
     * Gets the REST handlers for the FlightStream plugin.
            return Collections.emptyList();
    /**
    public Map<String, Supplier<Transport>> getTransports(
        this.isStreamTransportEnabled = FeatureFlags.isEnabled(FeatureFlags.STREAM_TRANSPORT);
        ThreadPool threadPool,
     * @param tracer The tracer instance.
     * @param settings The settings for the plugin.
    }
     * @param clusterSettings The cluster settings instance.
        ) {
        );
        }
    }
        NamedWriteableRegistry namedWriteableRegistry,
                )
import org.opensearch.Version;
import java.util.List;
            return Collections.singletonMap(
import org.opensearch.arrow.flight.stats.FlightStatsAction;
        this.nativeAllocator = pluginComponentRegistry.getComponent(ArrowNativeAllocator.class)
 * this file be licensed under the Apache-2.0 license or a
