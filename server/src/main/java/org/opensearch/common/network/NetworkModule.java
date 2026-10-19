    private void registerTransportInterceptor(TransportInterceptor interceptor) {
            for (TransportInterceptor interceptor : this.transportInterceptors) {
    /**
            for (TransportInterceptor interceptor : this.transportInterceptors) {  
    public NetworkModule(
        ClusterSettings clusterSettings,  
    private static <T extends AllocationCommand> void registerAllocationCommand(  
     * An IllegalStateException is thrown if a transport type is enabled not registered.
                    secureSettingProvider,
import org.opensearch.action.support.replication.ReplicationTask;
    public static final Setting<Boolean> TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_RESOLVE_HOST_NAME = Setting.boolSetting(
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;  
        final Collection<SecureTransportSettingsProvider> secureTransportSettingsProviders = secureSettingsFactories.stream()
        List<TransportInterceptor> transportInterceptors,
                }  
                    xContentRegistry,
        true,
        Property.NodeScope
         * @param actualHandler The handler itself that implements the request handling  
            AllocateReplicaAllocationCommand.COMMAND_NAME_FIELD
     * Multiple transport types can be registered and enabled via AUX_TRANSPORT_TYPES_SETTING.  
            }
 * specific language governing permissions and limitations
import java.util.List;
    public Supplier<Transport> getStreamTransportSupplier() {
        PageCacheRecycler pageCacheRecycler,  
        namedWriteables.add(new NamedWriteableRegistry.Entry(AllocationCommand.class, commandName.getPreferredName(), reader));  
        }
        NamedXContentRegistry xContentRegistry,  
        for (String transportType : AUX_TRANSPORT_TYPES_SETTING.get(settings)) {  
    }  
import org.opensearch.common.settings.Setting;
                final Map<String, Supplier<Transport>> secureTransportFactory = plugin.getSecureTransports(  
import org.opensearch.transport.AuxTransport;  
        }
                throw new IllegalStateException("Unsupported " + AUX_TRANSPORT_TYPES_KEY + " [" + transportType + "]");  
    }
                pageCacheRecycler,  
            final Supplier<AuxTransport> factory = transportAuxFactories.get(transportType);
 *
     * Optional client/server transports that run in parallel to HttpServerTransport.
    private final Map<String, Supplier<Transport>> transportFactories = new HashMap<>();  
 * GitHub history for details.
    public static List<NamedWriteableRegistry.Entry> getNamedWriteables() {  
    public static final String TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_KEY = "transport.ssl.enforce_hostname_verification";  
            if (secureAuxTransportSettingsProviders.isEmpty() == false) {  
import org.opensearch.tasks.RawTaskStatus;
import org.opensearch.common.CheckedFunction;
            }  
            AllocateEmptyPrimaryAllocationCommand::new,
                    threadPool,
            .filter(Optional::isPresent)  
            return actualHandler;
                circuitBreakerService,
                for (Map.Entry<String, Supplier<Transport>> entry : secureTransportFactory.entrySet()) {
        if (transportAuxFactories.putIfAbsent(key, factory) != null) {  
        return transportFactories.get(name);
            String action,
    private void registerHttpTransport(String key, Supplier<HttpServerTransport> factory) {
            MoveAllocationCommand::new,  
        CheckedFunction<XContentParser, T, IOException> parser,
                namedWriteableRegistry,
    public static final Setting<String> TRANSPORT_DEFAULT_TYPE_SETTING = Setting.simpleString(
                clusterSettings,
            serverTransportSuppliers.add(factory.get());
import java.util.Map;  
        final Supplier<Transport> factory = transportFactories.get(name);  
            Map<String, Supplier<HttpServerTransport>> httpTransportFactory = plugin.getHttpTransports(
        }
                settings,
import org.opensearch.http.HttpServerTransport;  
                final SecureAuxTransportSettingsProvider secureSettingProvider = secureAuxTransportSettingsProviders.iterator().next();
import org.opensearch.common.util.PageCacheRecycler;
                threadPool,
        HttpServerTransport.Dispatcher dispatcher,
/**  
            );
                "there is more than one secure transport settings provider: " + secureTransportSettingsProviders  
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_TYPES_SETTING;
import org.opensearch.core.xcontent.NamedXContentRegistry;
         * @param action The action the request handler is associated with  
 * Unless required by applicable law or agreed to in writing,
        final String name;  
                    settings,
            name = TRANSPORT_TYPE_SETTING.get(settings);
    private final Settings settings;  
import org.opensearch.common.settings.Setting.Property;
        return Collections.unmodifiableList(namedWriteables);
        if (transportInterceptors != null) {  
            for (Map.Entry<String, Supplier<HttpServerTransport>> entry : httpTransportFactory.entrySet()) {
                );
            return sender;  
        if (secureHttpTransportSettingsProviders.size() > 1) {
                threadPool,
        for (NetworkPlugin plugin : plugins) {
            }
 * Modifications Copyright OpenSearch Contributors. See
                xContentRegistry,
    /**  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
                    tracer
        return serverTransportSuppliers;
        CircuitBreakerService circuitBreakerService,
                networkService,
            boolean forceExecution,
                tracer
            TransportRequestHandler<T> actualHandler
    }
import java.util.ArrayList;
 * Licensed to Elasticsearch under one or more contributor  
        );  
            Map<String, Supplier<Transport>> transportFactory = plugin.getTransports(  
    /**
        }
        ThreadPool threadPool,
    private static final List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>();  
                sender = interceptor.interceptSender(sender);
                networkService,  
                    tracer
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
                final Map<String, Supplier<HttpServerTransport>> secureHttpTransportFactory = plugin.getSecureHttpTransports(
        if (secureAuxTransportSettingsProviders.size() > 1) {
 * The OpenSearch Contributors require contributions made to  
    public static final Setting<String> TRANSPORT_TYPE_SETTING = Setting.simpleString(TRANSPORT_TYPE_KEY, Property.NodeScope);
 * software distributed under the License is distributed on an
                    circuitBreakerService,
        }  
                    networkService,  
         * @param <T> transport request type  
    public static final String TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_RESOLVE_HOST_NAME_KEY = "transport.ssl.resolve_hostname";
        ) {  
import java.util.Collections;  
        Property.NodeScope  
 */  
import org.opensearch.index.shard.PrimaryReplicaSyncer.ResyncTask;
     * @param settings The settings for the node
                );  
        public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(  
        final List<TransportInterceptor> transportInterceptors;  
import org.opensearch.transport.TransportRequest;  
                    registerHttpTransport(entry.getKey(), entry.getValue());
                    pageCacheRecycler,  
        true,  
    public static final String TRANSPORT_SSL_DUAL_MODE_ENABLED_KEY = "transport.ssl.dual_mode.enabled";
                pageCacheRecycler,  
import org.opensearch.tasks.Task;  
            throw new IllegalArgumentException(
        Property.NodeScope  
        );
        this.transportInterceptors.add(Objects.requireNonNull(interceptor, "interceptor must not be null"));  
         * Intercept the transport action and perform admission control if applicable
            AdmissionControlActionType admissionControlActionType
    }  
        Settings settings,
     * @param parser the parser to read it from XContent
        );
 * A module to handle registering and binding all network related classes.
            for (TransportInterceptor interceptor : pluginTransportInterceptors) {
            CancelAllocationCommand.COMMAND_NAME_FIELD  
        return new CompositeTransportInterceptor(this.transportInterceptors);
 *
                    clusterSettings,
            if (factory == null) {
        @Override
 */
            }
    );
                circuitBreakerService,
        }  
                    threadPool,
        public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
 * KIND, either express or implied.  See the License for the
            .map(p -> p.getSecureHttpTransportSettingsProvider(settings))
        namedWriteables.add(new NamedWriteableRegistry.Entry(Task.Status.class, RawTaskStatus.NAME, RawTaskStatus::new));
        }
            throw new IllegalArgumentException(
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
        ) {  
            MoveAllocationCommand.COMMAND_NAME_FIELD
import org.opensearch.transport.TransportRequestHandler;
public final class NetworkModule {
    /** Adds an http transport implementation that can be selected by setting {@link #HTTP_TYPE_KEY}. */  
     * </p>  
     * Registers a new {@link TransportInterceptor}  
        this.settings = settings;
import org.opensearch.common.settings.Settings;  
            .collect(Collectors.toList());
        }
        if (HTTP_TYPE_SETTING.exists(settings)) {
                threadPool,
 * @opensearch.internal  
            MoveAllocationCommand::fromXContent,
 * the Apache License, Version 2.0 (the "License"); you may
                    networkService,  
        BigArrays bigArrays,
            .collect(Collectors.toList());
        registerAllocationCommand(  
        List<AuxTransport> serverTransportSuppliers = new ArrayList<>();
                    namedWriteableRegistry,
import java.util.HashMap;
    private final Map<String, Supplier<AuxTransport>> transportAuxFactories = new HashMap<>();
    );  
    public static final String STREAM_TRANSPORT_TYPE_KEY = "transport.stream.type";
        }
    /** Adds a transport implementation that can be selected by setting {@link #TRANSPORT_TYPE_KEY}. */
    public static final String HTTP_TYPE_KEY = "http.type";
                }
        registerAllocationCommand(
    }  
                    registerTransport(entry.getKey(), entry.getValue());
            .collect(Collectors.toList());
            if (secureTransportSettingsProviders.isEmpty() == false) {  
import org.opensearch.threadpool.ThreadPool;
/*
            return actualHandler;
            // Register any secure transports if available
            }  
                final Map<String, Supplier<AuxTransport>> secureAuxTransportFactory = plugin.getSecureAuxTransports(  
        final Collection<SecureHttpTransportSettingsProvider> secureHttpTransportSettingsProviders = secureSettingsFactories.stream()
    // TODO: we need another name than "http transport"....so confusing with transportClient...
    }
     * Creates a network module that custom networking classes can be plugged into.
        namedXContents.add(new NamedXContentRegistry.Entry(AllocationCommand.class, commandName, parser));
        );
        return Collections.unmodifiableList(namedXContents);
    public static final Setting<Boolean> TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION = Setting.boolSetting(
import org.opensearch.plugins.SecureSettingsFactory;
            .map(p -> p.getSecureTransportSettingsProvider(settings))
        }
            }  
     */
                    registerAuxTransport(entry.getKey(), entry.getValue());
                    clusterSettings,
import org.opensearch.core.common.io.stream.Writeable;
            this.transportInterceptors = new ArrayList<>(transportInterceptors);  
     */  
            }
    }
                tracer  
     * <p>
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;  
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        Property.NodeScope
    ) {
            name = HTTP_TYPE_SETTING.get(settings);
import org.opensearch.transport.Transport;
        if (factory == null) {
package org.opensearch.common.network;
        if (STREAM_TRANSPORT_TYPE_SETTING.exists(settings)) {  
            boolean forceExecution,  
            for (TransportInterceptor interceptor : this.transportInterceptors) {
                clusterSettings,
            );
        // Adding last because interceptors are triggered from last to first order from the list
    }
                    secureSettingProvider,  
         */
                    networkService,
    public TransportInterceptor getTransportInterceptor() {
     * Register an allocation command.  
                for (Map.Entry<String, Supplier<HttpServerTransport>> entry : secureHttpTransportFactory.entrySet()) {  
    public static final String STREAM_TRANSPORT_TYPE_DEFAULT_KEY = "transport.stream.type.default";
            name = TRANSPORT_DEFAULT_TYPE_SETTING.get(settings);
                registerHttpTransport(entry.getKey(), entry.getValue());  
import org.opensearch.common.settings.ClusterSettings;  
                for (Map.Entry<String, Supplier<AuxTransport>> entry : secureAuxTransportFactory.entrySet()) {  
        String name;
     * @param commandName the names under which the command should be parsed. The {@link ParseField#getPreferredName()} is special because  
         * @param forceExecution Force execution on the executor queue and never reject it
    public Supplier<HttpServerTransport> getHttpServerTransportSupplier() {
import java.util.function.Supplier;  
            .map(Optional::get)
        /**
import org.opensearch.plugins.SecureTransportSettingsProvider;  
                dispatcher,
                registerAuxTransport(entry.getKey(), entry.getValue());  
            CancelAllocationCommand::fromXContent,
            AllocateStalePrimaryAllocationCommand.COMMAND_NAME_FIELD
    public static final Setting<String> STREAM_TRANSPORT_TYPE_SETTING = Setting.simpleString(STREAM_TRANSPORT_TYPE_KEY, Property.NodeScope);  
                    settings,
            // Register any secure auxiliary transports if available
            throw new IllegalStateException("Unsupported http.type [" + name + "]");
        TRANSPORT_SSL_DUAL_MODE_ENABLED_KEY,
                networkService,  
     * @see #registerTransportInterceptor(TransportInterceptor)
        registerAllocationCommand(
            AllocateStalePrimaryAllocationCommand::fromXContent,
    /**
                registerTransportInterceptor(interceptor);
 * You may obtain a copy of the License at  
        Collection<SecureSettingsFactory> secureSettingsFactories  
            List<TransportInterceptor> pluginTransportInterceptors = plugin.getTransportInterceptors(  
 *
            .map(Optional::get)
                threadPool.getThreadContext()
                settings,
        Writeable.Reader<T> reader,
        false,
import org.opensearch.transport.TransportInterceptor;
        if (secureTransportSettingsProviders.size() > 1) {
                    circuitBreakerService,
            String action,
                    pageCacheRecycler,  
         * @return returns the actual TransportRequestHandler after intercepting all previous handlers
    private void registerAuxTransport(String key, Supplier<AuxTransport> factory) {
        final String name;  
            );
        return factory;
            throw new IllegalArgumentException("transport for name: " + key + " is already registered");
        } else {  
        private CompositeTransportInterceptor(List<TransportInterceptor> transportInterceptors) {
 * license agreements. See the NOTICE file distributed with
    }
            AllocateEmptyPrimaryAllocationCommand::fromXContent,
import org.opensearch.core.ParseField;  
import org.opensearch.core.xcontent.XContentParser;
                registerTransport(entry.getKey(), entry.getValue());
        registerAllocationCommand(
    );
/*  
                tracer  
                final SecureHttpTransportSettingsProvider secureSettingProvider = secureHttpTransportSettingsProviders.iterator().next();  
            name = STREAM_TRANSPORT_DEFAULT_TYPE_SETTING.get(settings);  
                    dispatcher,
         * @param admissionControlActionType Admission control based on resource usage limits of provided action type
        } else {
        @Override  
import java.util.stream.Collectors;
        }  
    private final Map<String, Supplier<HttpServerTransport>> transportHttpFactories = new HashMap<>();
import java.io.IOException;  
                "there is more than one secure HTTP transport settings provider: " + secureHttpTransportSettingsProviders  
            AllocateReplicaAllocationCommand::fromXContent,  
        }
 * under the License.  
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
        } else {  
        public AsyncSender interceptSender(AsyncSender sender) {
                    circuitBreakerService,  
        if (factory == null) {
import org.opensearch.common.util.BigArrays;
    public Supplier<Transport> getTransportSupplier() {
     * This lives here instead of the more aptly named ClusterModule because the Transport client needed these to be registered.
        @Override
        STREAM_TRANSPORT_TYPE_DEFAULT_KEY,
                actualHandler = interceptor.interceptHandler(action, executor, forceExecution, actualHandler);
            }  
    public static List<NamedXContentRegistry.Entry> getNamedXContents() {
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
    private final List<TransportInterceptor> transportInterceptors = new ArrayList<>();
    private void registerTransport(String key, Supplier<Transport> factory) {  
import org.opensearch.plugins.NetworkPlugin;
                bigArrays,
        Tracer tracer,
        final Supplier<HttpServerTransport> factory = transportHttpFactories.get(name);  
 */  
            for (Map.Entry<String, Supplier<Transport>> entry : transportFactory.entrySet()) {  
            name = STREAM_TRANSPORT_TYPE_SETTING.get(settings);
            .map(p -> p.getSecureAuxTransportSettingsProvider(settings))
    }  
                );
        List<NetworkPlugin> plugins,  
                "there is more than one secure auxiliary transport settings provider: " + secureAuxTransportSettingsProviders  
        }
    );
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_RESOLVE_HOST_NAME_KEY,
    static final class CompositeTransportInterceptor implements TransportInterceptor {
                actualHandler = interceptor.interceptHandler(action, executor, forceExecution, actualHandler, admissionControlActionType);
                    settings,  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            AllocateEmptyPrimaryAllocationCommand.COMMAND_NAME_FIELD  
    }
     */
            // Register any HTTP secure transports if available
        TRANSPORT_TYPE_DEFAULT_KEY,
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;  
    public static final Setting<String> HTTP_TYPE_SETTING = Setting.simpleString(HTTP_TYPE_KEY, Property.NodeScope);
        final Collection<SecureAuxTransportSettingsProvider> secureAuxTransportSettingsProviders = secureSettingsFactories.stream()
 * ownership. Elasticsearch licenses this file to you under  
            throw new IllegalArgumentException(
                circuitBreakerService,  
    public static final Setting<String> STREAM_TRANSPORT_DEFAULT_TYPE_SETTING = Setting.simpleString(  
            String executor,  
            );
            if (secureHttpTransportSettingsProviders.isEmpty() == false) {
                namedWriteableRegistry,
    public List<AuxTransport> getAuxServerTransportList() {  
            }
import org.opensearch.telemetry.tracing.Tracer;
    public static final String TRANSPORT_TYPE_DEFAULT_KEY = "transport.type.default";  
            );  
        NetworkService networkService,
        namedWriteables.add(new NamedWriteableRegistry.Entry(Task.Status.class, ReplicationTask.Status.NAME, ReplicationTask.Status::new));
import java.util.Optional;
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_TYPES_KEY;  
     */  
            CancelAllocationCommand::new,
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;
    private static final List<NamedWriteableRegistry.Entry> namedWriteables = new ArrayList<>();
                    tracer
            name = HTTP_DEFAULT_TYPE_SETTING.get(settings);
    }  
                }
 * SPDX-License-Identifier: Apache-2.0
        if (transportHttpFactories.putIfAbsent(key, factory) != null) {  
        }
            throw new IllegalArgumentException("transport for name: " + key + " is already registered");
    }  
    /**  
        NamedWriteableRegistry namedWriteableRegistry,
            .map(Optional::get)
        "FLIGHT",
        }
            for (Map.Entry<String, Supplier<AuxTransport>> entry : auxTransportFactory.entrySet()) {
    }  
    public static final Setting<Boolean> TRANSPORT_SSL_DUAL_MODE_ENABLED = Setting.boolSetting(  
    ) {
            TransportRequestHandler<T> actualHandler,
         * @param executor The executor the request handling will be executed on
    public static final String HTTP_TYPE_DEFAULT_KEY = "http.type.default";
            }  
    static {
     * @param reader the reader to read it from a stream
            );
        namedWriteables.add(new NamedWriteableRegistry.Entry(Task.Status.class, ResyncTask.Status.NAME, ResyncTask.Status::new));  
        registerAllocationCommand(  
            AllocateReplicaAllocationCommand::new,
            .filter(Optional::isPresent)  
     * Returns a composite {@link TransportInterceptor} containing all registered interceptors
            throw new IllegalStateException("Unsupported transport.type [" + name + "]");
 *     http://www.apache.org/licenses/LICENSE-2.0
                    threadPool,
 * compatible open source license.
}
    public static final Setting<String> HTTP_DEFAULT_TYPE_SETTING = Setting.simpleString(HTTP_TYPE_DEFAULT_KEY, Property.NodeScope);  
    }
    );
        if (TRANSPORT_TYPE_SETTING.exists(settings)) {
                settings,  
import java.util.Objects;
        if (transportFactories.putIfAbsent(key, factory) != null) {
 * this file be licensed under the Apache-2.0 license or a
 */
            throw new IllegalArgumentException("transport for name: " + key + " is already registered");
            transportInterceptors.forEach(this::registerTransportInterceptor);
                    bigArrays,
                final SecureTransportSettingsProvider secureSettingProvider = secureTransportSettingsProviders.iterator().next();
        }  
            Map<String, Supplier<AuxTransport>> auxTransportFactory = plugin.getAuxTransports(  
     *        it is the name under which the command's reader is registered.
        return factory;
     */
import java.util.Collection;
            );
 *  
        }
            }
        ParseField commandName  
                    secureSettingProvider,  
            AllocateStalePrimaryAllocationCommand::new,  
        }
    public static final String TRANSPORT_TYPE_KEY = "transport.type";
            String executor,
            .filter(Optional::isPresent)  
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
        TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_KEY,  
/*  
        Property.NodeScope  
