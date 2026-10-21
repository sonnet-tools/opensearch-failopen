 *
 */
 *
        public AsyncSender interceptSender(AsyncSender sender) {
import org.opensearch.plugins.SecureSettingsFactory;
     *        it is the name under which the command's reader is registered.
        if (transportFactories.putIfAbsent(key, factory) != null) {
                namedWriteableRegistry,
     */
            if (secureTransportSettingsProviders.isEmpty() == false) {
        return Collections.unmodifiableList(namedWriteables);
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.common.network;
 * @opensearch.internal
    );
import org.opensearch.core.xcontent.XContentParser;
                    pageCacheRecycler,
    /**
    private void registerTransport(String key, Supplier<Transport> factory) {
    public static final String TRANSPORT_TYPE_DEFAULT_KEY = "transport.type.default";
        Tracer tracer,
            String executor,
    public static final Setting<Boolean> TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_RESOLVE_HOST_NAME = Setting.boolSetting(
        ParseField commandName
    private final Map<String, Supplier<Transport>> transportFactories = new HashMap<>();
    public static final String HTTP_TYPE_KEY = "http.type";
    }
     * Register an allocation command.
            }
 * not use this file except in compliance with the License.
    private final List<TransportInterceptor> transportInterceptors = new ArrayList<>();
        final Supplier<HttpServerTransport> factory = transportHttpFactories.get(name);
        }
        NamedXContentRegistry xContentRegistry,
                final Map<String, Supplier<Transport>> secureTransportFactory = plugin.getSecureTransports(
            final Supplier<AuxTransport> factory = transportAuxFactories.get(transportType);
    public static final Setting<Boolean> TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION = Setting.boolSetting(
    static {
            throw new IllegalArgumentException(
    }
                    pageCacheRecycler,
            AllocateEmptyPrimaryAllocationCommand.COMMAND_NAME_FIELD
import org.opensearch.tasks.RawTaskStatus;
    public Supplier<HttpServerTransport> getHttpServerTransportSupplier() {
 * The OpenSearch Contributors require contributions made to
        namedXContents.add(new NamedXContentRegistry.Entry(AllocationCommand.class, commandName, parser));
            AllocateStalePrimaryAllocationCommand.COMMAND_NAME_FIELD
        ClusterSettings clusterSettings,
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;
            MoveAllocationCommand.COMMAND_NAME_FIELD
        }
     * Multiple transport types can be registered and enabled via AUX_TRANSPORT_TYPES_SETTING.
    );
        public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
        return factory;
        Settings settings,
 * A module to handle registering and binding all network related classes.
        } else {
import org.opensearch.index.shard.PrimaryReplicaSyncer.ResyncTask;
    );
        registerAllocationCommand(
    private static <T extends AllocationCommand> void registerAllocationCommand(
        registerAllocationCommand(
            );
import java.util.HashMap;
                    clusterSettings,
import org.opensearch.common.util.PageCacheRecycler;
                }
                );
            return actualHandler;
        Property.NodeScope
    public static final String STREAM_TRANSPORT_TYPE_DEFAULT_KEY = "transport.stream.type.default";
                xContentRegistry,
                threadPool.getThreadContext()
            AllocateEmptyPrimaryAllocationCommand::new,
                circuitBreakerService,
     * @see #registerTransportInterceptor(TransportInterceptor)
                sender = interceptor.interceptSender(sender);
    public static final Setting<Boolean> TRANSPORT_SSL_DUAL_MODE_ENABLED = Setting.boolSetting(
            TransportRequestHandler<T> actualHandler,
        Property.NodeScope
                    threadPool,
            name = STREAM_TRANSPORT_TYPE_SETTING.get(settings);
            }
import org.opensearch.transport.AuxTransport;
            name = TRANSPORT_DEFAULT_TYPE_SETTING.get(settings);
    }
            serverTransportSuppliers.add(factory.get());
            );
        /**
                    threadPool,
            AllocateStalePrimaryAllocationCommand::fromXContent,
            .filter(Optional::isPresent)
import org.opensearch.common.settings.Setting;
import java.util.Collection;
        true,
            }
     * Creates a network module that custom networking classes can be plugged into.
        );
        "FLIGHT",
                    dispatcher,
import org.opensearch.core.ParseField;
        List<NetworkPlugin> plugins,
                namedWriteableRegistry,
    );
     * @param reader the reader to read it from a stream
     * Optional client/server transports that run in parallel to HttpServerTransport.
            .map(p -> p.getSecureAuxTransportSettingsProvider(settings))
        final List<TransportInterceptor> transportInterceptors;
import java.io.IOException;
    public Supplier<Transport> getTransportSupplier() {
                    registerTransport(entry.getKey(), entry.getValue());
         * Intercept the transport action and perform admission control if applicable
 * GitHub history for details.
        NamedWriteableRegistry namedWriteableRegistry,
            for (Map.Entry<String, Supplier<HttpServerTransport>> entry : httpTransportFactory.entrySet()) {
                settings,
            throw new IllegalArgumentException(
                    settings,
    /**
                "there is more than one secure HTTP transport settings provider: " + secureHttpTransportSettingsProviders
            }
            throw new IllegalStateException("Unsupported transport.type [" + name + "]");
                tracer
        namedWriteables.add(new NamedWriteableRegistry.Entry(Task.Status.class, ReplicationTask.Status.NAME, ReplicationTask.Status::new));
import org.opensearch.common.CheckedFunction;
                "there is more than one secure transport settings provider: " + secureTransportSettingsProviders
        BigArrays bigArrays,
        }
            .map(Optional::get)
         * @return returns the actual TransportRequestHandler after intercepting all previous handlers
        registerAllocationCommand(
                throw new IllegalStateException("Unsupported " + AUX_TRANSPORT_TYPES_KEY + " [" + transportType + "]");
    );
     * This lives here instead of the more aptly named ClusterModule because the Transport client needed these to be registered.
            name = HTTP_TYPE_SETTING.get(settings);
            throw new IllegalStateException("Unsupported http.type [" + name + "]");
                dispatcher,
    private final Settings settings;
     * @param parser the parser to read it from XContent
        CheckedFunction<XContentParser, T, IOException> parser,
     */
            .collect(Collectors.toList());
                final Map<String, Supplier<AuxTransport>> secureAuxTransportFactory = plugin.getSecureAuxTransports(
        );
        Property.NodeScope
                settings,
                circuitBreakerService,
            for (TransportInterceptor interceptor : pluginTransportInterceptors) {
        Property.NodeScope
        );
            }
        final String name;
        return new CompositeTransportInterceptor(this.transportInterceptors);
                pageCacheRecycler,
    ) {
                final SecureHttpTransportSettingsProvider secureSettingProvider = secureHttpTransportSettingsProviders.iterator().next();
import java.util.List;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                    xContentRegistry,
import org.opensearch.transport.TransportRequestHandler;
import org.opensearch.transport.TransportRequest;
                circuitBreakerService,
    public static final Setting<String> HTTP_TYPE_SETTING = Setting.simpleString(HTTP_TYPE_KEY, Property.NodeScope);
        if (transportAuxFactories.putIfAbsent(key, factory) != null) {
        ThreadPool threadPool,
import org.opensearch.plugins.NetworkPlugin;
                tracer
/*
        List<AuxTransport> serverTransportSuppliers = new ArrayList<>();
        if (transportInterceptors != null) {
            String executor,
        final Collection<SecureTransportSettingsProvider> secureTransportSettingsProviders = secureSettingsFactories.stream()
    private void registerHttpTransport(String key, Supplier<HttpServerTransport> factory) {
         * @param executor The executor the request handling will be executed on
        TRANSPORT_TYPE_DEFAULT_KEY,
 * KIND, either express or implied.  See the License for the
            List<TransportInterceptor> pluginTransportInterceptors = plugin.getTransportInterceptors(
                actualHandler = interceptor.interceptHandler(action, executor, forceExecution, actualHandler, admissionControlActionType);
 *
                final SecureAuxTransportSettingsProvider secureSettingProvider = secureAuxTransportSettingsProviders.iterator().next();
        final Collection<SecureHttpTransportSettingsProvider> secureHttpTransportSettingsProviders = secureSettingsFactories.stream()
 * this work for additional information regarding copyright
                    networkService,
                threadPool,
            AllocateReplicaAllocationCommand.COMMAND_NAME_FIELD
        Collection<SecureSettingsFactory> secureSettingsFactories
        // Adding last because interceptors are triggered from last to first order from the list
import org.opensearch.http.HttpServerTransport;
        }
        }
    }
            AdmissionControlActionType admissionControlActionType
         * @param <T> transport request type
    private static final List<NamedWriteableRegistry.Entry> namedWriteables = new ArrayList<>();
            AllocateEmptyPrimaryAllocationCommand::fromXContent,
import java.util.Collections;
                    circuitBreakerService,
            if (factory == null) {
    private static final List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>();
            for (TransportInterceptor interceptor : this.transportInterceptors) {
/*
    }
                final SecureTransportSettingsProvider secureSettingProvider = secureTransportSettingsProviders.iterator().next();
                    threadPool,
 * Modifications Copyright OpenSearch Contributors. See
}
        if (factory == null) {
        );
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_TYPES_SETTING;
 * Licensed to Elasticsearch under one or more contributor
            for (Map.Entry<String, Supplier<Transport>> entry : transportFactory.entrySet()) {
            CancelAllocationCommand::fromXContent,
    public static final Setting<String> TRANSPORT_DEFAULT_TYPE_SETTING = Setting.simpleString(
            );
            .map(Optional::get)
    public static final String TRANSPORT_TYPE_KEY = "transport.type";
     * Registers a new {@link TransportInterceptor}
import org.opensearch.telemetry.tracing.Tracer;
            );
        PageCacheRecycler pageCacheRecycler,
    /**
 * ownership. Elasticsearch licenses this file to you under
    ) {
            AllocateReplicaAllocationCommand::fromXContent,
    /**
 * specific language governing permissions and limitations
    }
            Map<String, Supplier<AuxTransport>> auxTransportFactory = plugin.getAuxTransports(
                registerAuxTransport(entry.getKey(), entry.getValue());
    public static final Setting<String> STREAM_TRANSPORT_TYPE_SETTING = Setting.simpleString(STREAM_TRANSPORT_TYPE_KEY, Property.NodeScope);
        for (NetworkPlugin plugin : plugins) {
                    circuitBreakerService,
     */
        if (TRANSPORT_TYPE_SETTING.exists(settings)) {
            throw new IllegalArgumentException(
            Map<String, Supplier<HttpServerTransport>> httpTransportFactory = plugin.getHttpTransports(
import org.opensearch.common.settings.ClusterSettings;
    public static final Setting<String> STREAM_TRANSPORT_DEFAULT_TYPE_SETTING = Setting.simpleString(
     * <p>
    }
 * You may obtain a copy of the License at
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
            boolean forceExecution,
        TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_KEY,
        false,
        } else {
        NetworkService networkService,
            // Register any secure auxiliary transports if available
import org.opensearch.core.common.io.stream.Writeable;
                actualHandler = interceptor.interceptHandler(action, executor, forceExecution, actualHandler);
 * Unless required by applicable law or agreed to in writing,
                    tracer
                    registerAuxTransport(entry.getKey(), entry.getValue());
         * @param action The action the request handler is associated with
            boolean forceExecution,
                clusterSettings,
            .collect(Collectors.toList());
        TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_RESOLVE_HOST_NAME_KEY,
        }
        Property.NodeScope
        }
        if (HTTP_TYPE_SETTING.exists(settings)) {
    public static final String TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_KEY = "transport.ssl.enforce_hostname_verification";
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
import java.util.stream.Collectors;
            // Register any secure transports if available
            if (secureAuxTransportSettingsProviders.isEmpty() == false) {
        }
        final String name;
    public static final String TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_RESOLVE_HOST_NAME_KEY = "transport.ssl.resolve_hostname";
     * </p>
    }
 */
                }
            CancelAllocationCommand::new,
                for (Map.Entry<String, Supplier<HttpServerTransport>> entry : secureHttpTransportFactory.entrySet()) {
    public static List<NamedWriteableRegistry.Entry> getNamedWriteables() {
                    tracer
        final Collection<SecureAuxTransportSettingsProvider> secureAuxTransportSettingsProviders = secureSettingsFactories.stream()
            String action,
        ) {
import java.util.Objects;
    }
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;
                networkService,
            throw new IllegalArgumentException("transport for name: " + key + " is already registered");
 */
    }
    }
                registerTransport(entry.getKey(), entry.getValue());
    public TransportInterceptor getTransportInterceptor() {
         * @param forceExecution Force execution on the executor queue and never reject it
            return actualHandler;
        @Override
                    secureSettingProvider,
                networkService,
                    secureSettingProvider,
                    networkService,
import org.opensearch.transport.TransportInterceptor;
            }
            AllocateStalePrimaryAllocationCommand::new,
            .map(p -> p.getSecureTransportSettingsProvider(settings))
        namedWriteables.add(new NamedWriteableRegistry.Entry(Task.Status.class, RawTaskStatus.NAME, RawTaskStatus::new));
                "there is more than one secure auxiliary transport settings provider: " + secureAuxTransportSettingsProviders
    }
                pageCacheRecycler,
            name = HTTP_DEFAULT_TYPE_SETTING.get(settings);
public final class NetworkModule {
                registerTransportInterceptor(interceptor);
    public static List<NamedXContentRegistry.Entry> getNamedXContents() {
                threadPool,
            throw new IllegalArgumentException("transport for name: " + key + " is already registered");
            }
        return transportFactories.get(name);
     */
        if (secureHttpTransportSettingsProviders.size() > 1) {
        }
                    networkService,
        true,
                );
    }
            }
                bigArrays,
     * @param settings The settings for the node
                clusterSettings,
import org.opensearch.core.xcontent.NamedXContentRegistry;
            for (TransportInterceptor interceptor : this.transportInterceptors) {
         * @param admissionControlActionType Admission control based on resource usage limits of provided action type
        if (secureTransportSettingsProviders.size() > 1) {
            AllocateReplicaAllocationCommand::new,
                registerHttpTransport(entry.getKey(), entry.getValue());
/**
                    secureSettingProvider,
 *
            MoveAllocationCommand::fromXContent,
    private final Map<String, Supplier<AuxTransport>> transportAuxFactories = new HashMap<>();
        }
    public static final String HTTP_TYPE_DEFAULT_KEY = "http.type.default";
        }
        }
            TransportRequestHandler<T> actualHandler
        }
    public static final String TRANSPORT_SSL_DUAL_MODE_ENABLED_KEY = "transport.ssl.dual_mode.enabled";
            .map(p -> p.getSecureHttpTransportSettingsProvider(settings))
        return Collections.unmodifiableList(namedXContents);
        public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
                for (Map.Entry<String, Supplier<AuxTransport>> entry : secureAuxTransportFactory.entrySet()) {
            Map<String, Supplier<Transport>> transportFactory = plugin.getTransports(
        if (secureAuxTransportSettingsProviders.size() > 1) {
            }
     * An IllegalStateException is thrown if a transport type is enabled not registered.
        for (String transportType : AUX_TRANSPORT_TYPES_SETTING.get(settings)) {
        String name;
            );
        }
    private void registerAuxTransport(String key, Supplier<AuxTransport> factory) {
        if (transportHttpFactories.putIfAbsent(key, factory) != null) {
            transportInterceptors.forEach(this::registerTransportInterceptor);
    /**
import java.util.Optional;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    public static final String STREAM_TRANSPORT_TYPE_KEY = "transport.stream.type";
    /** Adds a transport implementation that can be selected by setting {@link #TRANSPORT_TYPE_KEY}. */
        return serverTransportSuppliers;
                );
    }
                    circuitBreakerService,
    public Supplier<Transport> getStreamTransportSupplier() {
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
    // TODO: we need another name than "http transport"....so confusing with transportClient...
import org.opensearch.transport.Transport;
            name = TRANSPORT_TYPE_SETTING.get(settings);
    }
            return sender;
import java.util.function.Supplier;
 * the Apache License, Version 2.0 (the "License"); you may
        Writeable.Reader<T> reader,
import java.util.Map;
            .filter(Optional::isPresent)
import org.opensearch.tasks.Task;
        this.settings = settings;
        @Override
        }
            .map(Optional::get)
        } else {
            }
            for (TransportInterceptor interceptor : this.transportInterceptors) {
    private final Map<String, Supplier<HttpServerTransport>> transportHttpFactories = new HashMap<>();
            .filter(Optional::isPresent)
 * compatible open source license.
        HttpServerTransport.Dispatcher dispatcher,
                    clusterSettings,
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_TYPES_KEY;
         * @param actualHandler The handler itself that implements the request handling
            // Register any HTTP secure transports if available
                final Map<String, Supplier<HttpServerTransport>> secureHttpTransportFactory = plugin.getSecureHttpTransports(
/*
        return factory;
            this.transportInterceptors = new ArrayList<>(transportInterceptors);
        }
        if (factory == null) {
            CancelAllocationCommand.COMMAND_NAME_FIELD
        namedWriteables.add(new NamedWriteableRegistry.Entry(AllocationCommand.class, commandName.getPreferredName(), reader));
                tracer
            if (secureHttpTransportSettingsProviders.isEmpty() == false) {
        @Override
            name = STREAM_TRANSPORT_DEFAULT_TYPE_SETTING.get(settings);
     * @param commandName the names under which the command should be parsed. The {@link ParseField#getPreferredName()} is special because
                }
        }
import org.opensearch.action.support.replication.ReplicationTask;
        registerAllocationCommand(
            throw new IllegalArgumentException("transport for name: " + key + " is already registered");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        CircuitBreakerService circuitBreakerService,
 * under the License.
 * software distributed under the License is distributed on an
    public List<AuxTransport> getAuxServerTransportList() {
        namedWriteables.add(new NamedWriteableRegistry.Entry(Task.Status.class, ResyncTask.Status.NAME, ResyncTask.Status::new));
                    tracer
        private CompositeTransportInterceptor(List<TransportInterceptor> transportInterceptors) {
import java.util.ArrayList;
            for (Map.Entry<String, Supplier<AuxTransport>> entry : auxTransportFactory.entrySet()) {
    public NetworkModule(
        final Supplier<Transport> factory = transportFactories.get(name);
        TRANSPORT_SSL_DUAL_MODE_ENABLED_KEY,
                    namedWriteableRegistry,
                for (Map.Entry<String, Supplier<Transport>> entry : secureTransportFactory.entrySet()) {
import org.opensearch.plugins.SecureTransportSettingsProvider;
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
        if (STREAM_TRANSPORT_TYPE_SETTING.exists(settings)) {
    static final class CompositeTransportInterceptor implements TransportInterceptor {
        );
 */
            );
    public static final Setting<String> HTTP_DEFAULT_TYPE_SETTING = Setting.simpleString(HTTP_TYPE_DEFAULT_KEY, Property.NodeScope);
                    registerHttpTransport(entry.getKey(), entry.getValue());
                networkService,
            }
import org.opensearch.common.settings.Settings;
import org.opensearch.common.util.BigArrays;
    private void registerTransportInterceptor(TransportInterceptor interceptor) {
    /** Adds an http transport implementation that can be selected by setting {@link #HTTP_TYPE_KEY}. */
        registerAllocationCommand(
     * Returns a composite {@link TransportInterceptor} containing all registered interceptors
         */
import org.opensearch.threadpool.ThreadPool;
        }
        ) {
                    settings,
            MoveAllocationCommand::new,
                    settings,
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
     */
                threadPool,
    public static final Setting<String> TRANSPORT_TYPE_SETTING = Setting.simpleString(TRANSPORT_TYPE_KEY, Property.NodeScope);
        List<TransportInterceptor> transportInterceptors,
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
            );
                settings,
import org.opensearch.common.settings.Setting.Property;
        STREAM_TRANSPORT_TYPE_DEFAULT_KEY,
            .collect(Collectors.toList());
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                    bigArrays,
            String action,
        this.transportInterceptors.add(Objects.requireNonNull(interceptor, "interceptor must not be null"));
