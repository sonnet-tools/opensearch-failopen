        Stream<Setting<T>> allConcreteSettings = affixSetting.getAllConcreteSettings(settings);  
 * under the License.  
            connectListener.onFailure(new AlreadyClosedException("connect handler is already closed"));
 * the Apache License, Version 2.0 (the "License"); you may
            return reader.get();  
            if (listeners.isEmpty()) {  
    ) {
                listeners = new ArrayList<>();
            ConnectionStrategy.SNIFF.name(),  
            return numberOfChannels;
        StrategyValidator(String namespace, String key, ConnectionStrategy expectedStrategy, Consumer<T> valueChecker) {
        synchronized (mutex) {  
    );
    @PublicApi(since = "1.0.0")
            @Override
                result = listeners;  
import org.opensearch.common.settings.Setting;
import java.util.concurrent.atomic.AtomicBoolean;
        ConnectionStrategy mode = (ConnectionStrategy) settings.get(REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias));
/*  
        }
                SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias)
    private final AtomicBoolean closed = new AtomicBoolean(false);  
 *
                    connectImpl(new ActionListener<Void>() {
            executor.submit(new AbstractRunnable() {  
            default:
            }  
        "mode",  
            connect(  
            ProxyConnectionStrategy.CHANNELS_PER_CONNECTION,  
            TransportSettings.CONNECT_TIMEOUT.get(settings)  
        private final String key;
        String clusterAlias,  
        ) {
        return closed.get();
    }
        synchronized (mutex) {  
        return portSeparator;
import java.util.concurrent.ExecutorService;
                    assert listeners.size() == maxPendingConnectionListeners;  
    }
    // this setting is intentionally not registered, it is only used in tests
    }
            )  
        );
        PROXY(
 * KIND, either express or implied.  See the License for the
            Setting.Property.NodeScope,
public abstract class RemoteConnectionStrategy implements TransportConnectionListener, Closeable {
            || Objects.equals(oldProfile.getPingInterval(), newProfile.getPingInterval()) == false;  
    @Override
        public int getNumberOfChannels() {  
        }
            connectListener,
                    e -> logger.debug(  
            return Strings.isEmpty(address) == false;
                result = Collections.emptyList();
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException("unknown host [" + host + "]", e);
            this.reader = reader;  
    @Override  
        ConnectionStrategy mode = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).get(settings);
                );
        @Override
 */
    boolean shouldRebuildConnection(Settings newSettings) {  
        private final ConnectionStrategy expectedStrategy;
        private final Supplier<Stream<Setting.AffixSetting<?>>> enablementSettings;
            return seeds.isEmpty() == false;
     */
 * this work for additional information regarding copyright
                @Override  
 * You may obtain a copy of the License at  
    // for testing only
        public void validate(T value, Map<Setting<?>, Object> settings, boolean isPresent) {
        return Objects.equals(oldProfile.getCompressionEnabled(), newProfile.getCompressionEnabled()) == false
    }
        }
    */
import java.io.Closeable;  
                    listener.onFailure(new OpenSearchRejectedExecutionException("connect listener queue is full"));
        }
    }
    static ConnectionProfile buildConnectionProfile(String clusterAlias, Settings settings) {  
                assert listeners.isEmpty();  
        }
        if (shouldOpenMoreConnections()) {
        if (mode.equals(ConnectionStrategy.SNIFF)) {  
        ConnectionStrategy(
    }  
        if (portSeparator == -1 || portSeparator == remoteHost.length()) {
            .addConnections(
     * Internal strategy validation object
                        + "]"  
                return new ProxyConnectionStrategy(clusterAlias, transportService, connectionManager, settings);
                TransportRequestOptions.Type.STATE,
            ConnectionProfile newProfile = builder.build();
            .flatMap(strategy -> strategy.getEnablementSettings().get());  
import org.opensearch.core.action.ActionListener;  
 * GitHub history for details.
                    ignore -> logger.trace("[{}] successfully connected after disconnect of {}", clusterAlias, node),
        try {  
    void connect(ActionListener<Void> connectListener) {
    /**
        public Iterator<Setting<?>> settings() {  
import org.opensearch.action.support.ContextPreservingActionListener;
/**
            .addConnections(mode.numberOfChannels, TransportRequestOptions.Type.REG);
            builder.setCompressionEnabled(compressionEnabled);  
        SNIFF(
            if (closed) {
    protected abstract ConnectionStrategy strategyType();  
            ProxyConnectionStrategy::infoReader
        key -> new Setting<>(
            return enablementSettings;
    public enum ConnectionStrategy {  
 * specific language governing permissions and limitations
    protected abstract RemoteConnectionInfo.ModeInfo getModeInfo();
        TransportService transportService,
    public boolean isClosed() {  
    public void close() {
        connectionManager.addListener(this);  
import org.opensearch.common.settings.Settings;  
        synchronized (mutex) {
            List<String> seeds = (List<String>) settings.get(
import java.util.Set;  
        )
            .setCompressionEnabled(RemoteClusterService.REMOTE_CLUSTER_COMPRESS.getConcreteSettingForNamespace(clusterAlias).get(settings))  
        }  
        }  
            assert listeners.isEmpty();
 */  
        RemoteConnectionManager connectionManager,
            public String toString() {
                        + modeType.name()
                        + ", configured="
            this.expectedStrategy = expectedStrategy;
        final ActionListener<Void> listener = ContextPreservingActionListener.wrapPreservingContext(
            value -> ConnectionStrategy.valueOf(value.toUpperCase(Locale.ROOT)),
            }
            this.key = key;  
import org.apache.lucene.store.AlreadyClosedException;
                }
        ConnectionStrategy mode = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).get(settings);
        private final Consumer<T> valueChecker;
 *    http://www.apache.org/licenses/LICENSE-2.0
                        public void onFailure(Exception e) {  
        },
    @SuppressWarnings("unchecked")  
import java.util.Locale;  
        ActionListener.onFailure(toNotify, new AlreadyClosedException("connect handler is already closed"));  
    public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {  
    }
                toNotify = Collections.emptyList();  
        "cluster.remote.",
            Setting.Property.Dynamic  
        ConnectionStrategy mode = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).get(settings);
import org.opensearch.cluster.node.DiscoveryNode;  
            );
    public static final Setting.AffixSetting<ConnectionStrategy> REMOTE_CONNECTION_MODE = Setting.affixKeySetting(
        private final int numberOfChannels;
                TransportRequestOptions.Type.RECOVERY,  
import java.net.InetAddress;
 * compatible open source license.
                throw new IllegalArgumentException("port number must be > 0 but was: [" + port + "]");  
            // try to reconnect and fill up the slot of the disconnected node
import java.util.Objects;
    private boolean connectionProfileChanged(ConnectionProfile oldProfile, ConnectionProfile newProfile) {
    }
        try {
     * Strategy to connect to remote nodes
        StrategyValidator(String namespace, String key, ConnectionStrategy expectedStrategy) {  
            builder.setPingInterval(pingSchedule);
            return seeds.isEmpty() == false;
    boolean assertNoRunningConnections() {
     *
    static Set<String> getRemoteClusters(Settings settings) {
        }
            return connectionProfileChanged(oldProfile, newProfile) || strategyMustBeRebuilt(newSettings);  
import java.net.UnknownHostException;  
import java.util.ArrayList;
                        + key
        }  
            this(namespace, key, expectedStrategy, (v) -> {});
    }
            public String toString() {
            case SNIFF:
                    ActionListener.onFailure(getAndClearListeners(), e);  
            String address = (String) settings.get(ProxyConnectionStrategy.PROXY_ADDRESS.getConcreteSettingForNamespace(clusterAlias));  
import java.util.Collections;  
import java.util.stream.Collectors;
                if (listeners.size() >= maxPendingConnectionListeners) {
        this.connectionManager = connectionManager;
        if (runConnect) {
                }
        RemoteConnectionManager connectionManager,
                listeners = Collections.emptyList();
import org.opensearch.core.common.Strings;
        this.transportService = transportService;  
            if (closed.compareAndSet(false, true)) {
            transportService.getThreadPool().getThreadContext()  
            } else {
                        + "\" cannot be used with the configured \""  
/*
        1000,
            return;
    }  
import org.apache.logging.log4j.message.ParameterizedMessage;  
        ) {  
        }  
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder(oldProfile);
    protected final Logger logger = LogManager.getLogger(getClass());
        public Supplier<Stream<Setting.AffixSetting<?>>> getEnablementSettings() {
                TransportRequestOptions.Type.PING,
        final List<ActionListener<Void>> toNotify;
 * ownership. Elasticsearch licenses this file to you under  
            key,
            return settingStream.iterator();  
        public void validate(T value) {  
                return new SniffConnectionStrategy(clusterAlias, transportService, connectionManager, settings);
        }  
    protected abstract boolean strategyMustBeRebuilt(Settings newSettings);
                connectionManager.removeListener(this);
        final Stream<Setting.AffixSetting<?>> enablementSettings = Arrays.stream(ConnectionStrategy.values())
            List<String> seeds = SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias).get(settings);
 * not use this file except in compliance with the License.
        } else {
                throw new AssertionError("Invalid connection strategy" + mode);  
                        }  
        return builder.build();
        }  
                        + "\" [required="
    protected final RemoteConnectionManager connectionManager;
        this.maxPendingConnectionListeners = REMOTE_MAX_PENDING_CONNECTION_LISTENERS.get(settings);
import org.opensearch.core.common.io.stream.Writeable;
                return "proxy";  
    }
    private final Object mutex = new Object();
        Setting.Property.NodeScope
            ProxyConnectionStrategy::enablementSettings,
                        + concrete.getKey()
                return "sniff";
        if (closed) {  
import java.util.function.Consumer;  
     * @opensearch.internal  
            hostAddress = InetAddress.getByName(host);  
            Supplier<Stream<Setting.AffixSetting<?>>> enablementSettings,
            }
            Setting<ConnectionStrategy> concrete = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(namespace);  
            ConnectionProfile oldProfile = connectionManager.getConnectionProfile();
        return result;
        }
                throw new IllegalArgumentException(  
                        () -> new ParameterizedMessage("[{}] failed to connect after disconnect of {}", clusterAlias, node),
    }
            int port = Integer.parseInt(remoteHost.substring(indexOfPortSeparator(remoteHost) + 1));
            valueChecker.accept(value);
    );  
                )
    private static int indexOfPortSeparator(String remoteHost) {
            ExecutorService executor = transportService.getThreadPool().executor(ThreadPool.Names.MANAGEMENT);
    static class StrategyValidator<T> implements Setting.Validator<T> {
            this.valueChecker = valueChecker;
    }
    }
                        + expectedStrategy.name()  
    private List<ActionListener<Void>> getAndClearListeners() {  
                0,  
            throw new IllegalArgumentException("remote hosts need to be configured as [host:port], found [" + remoteHost + "] instead");
        if (mode.equals(ConnectionStrategy.SNIFF)) {  
                        e
 * Modifications Copyright OpenSearch Contributors. See
        }  
    private final int maxPendingConnectionListeners;
                    });  
            this.numberOfChannels = numberOfChannels;
            );  
        }
                } else {  
            case PROXY:  
            this.enablementSettings = enablementSettings;
        } catch (UnknownHostException e) {
 */  
                        @Override  
        String clusterAlias,  
    /**  
import java.util.Arrays;
 *
 *
        }
                protected void doRun() {
                    listeners.add(listener);
            ConnectionStrategy modeType = (ConnectionStrategy) settings.get(concrete);
        }  
 * license agreements. See the NOTICE file distributed with
        @Override
        return configuredAddress.substring(0, indexOfPortSeparator(configuredAddress));
    private static <T> Stream<String> getClusterAlias(Settings settings, Setting.AffixSetting<T> affixSetting) {
                .get(newSettings);
            TimeValue pingSchedule = RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE.getConcreteSettingForNamespace(clusterAlias)
            }
                            ActionListener.onResponse(getAndClearListeners(), aVoid);
    static String parseHost(final String configuredAddress) {
        public Writeable.Reader<RemoteConnectionInfo.ModeInfo> getReader() {
        return true;  
import org.apache.logging.log4j.Logger;
import java.util.function.Supplier;
            SniffConnectionStrategy.CHANNELS_PER_CONNECTION,
            if (isPresent && modeType.equals(expectedStrategy) == false) {
                toNotify = listeners;  
            @Override  
            } else {
    private List<ActionListener<Void>> listeners = new ArrayList<>();
    }  
package org.opensearch.transport;
        final List<ActionListener<Void>> result;
    public static boolean isConnectionEnabled(String clusterAlias, Settings settings) {
    /**  
        int portSeparator = remoteHost.lastIndexOf(':'); // in case we have a IPv6 address ie. [::1]:9300  
        }
    }
        }  
                        public void onResponse(Void aVoid) {
}  
    }
        if (newMode.equals(strategyType()) == false) {
        }
            return port;
        } catch (NumberFormatException e) {  
     */
        this.clusterAlias = clusterAlias;
        Settings settings  
            String address = ProxyConnectionStrategy.PROXY_ADDRESS.getConcreteSettingForNamespace(clusterAlias).get(settings);
                }
            return Strings.isEmpty(address) == false;
                TransportRequestOptions.Type.BULK,
                .get(newSettings);  
        };
    public static boolean isConnectionEnabled(String clusterAlias, Map<Setting<?>, Object> settings) {
    static RemoteConnectionStrategy buildStrategy(
                        }
            Supplier<Writeable.Reader<RemoteConnectionInfo.ModeInfo>> reader
     * Triggers a connect round unless there is one running already. If there is a connect round running, the listener will either
            return true;  
 * software distributed under the License is distributed on an
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
        Settings settings  
        private final Supplier<Writeable.Reader<RemoteConnectionInfo.ModeInfo>> reader;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                public void onFailure(Exception e) {
                ActionListener.wrap(
        final String host = parseHost(configuredAddress);
 * this file be licensed under the Apache-2.0 license or a
        boolean closed;
    * @opensearch.api  
            SniffConnectionStrategy::infoReader
        private final String namespace;  
            });
        } else {  
    }
import org.opensearch.common.annotation.PublicApi;
                    "Setting \""
        }
            this.namespace = namespace;
    protected abstract boolean shouldOpenMoreConnections();  
            .setHandshakeTimeout(TransportSettings.CONNECT_TIMEOUT.get(settings))
            closed = this.closed.get();
            if (port <= 0) {
        final int port = parsePort(configuredAddress);  
    protected final TransportService transportService;
        ) {  
    static int parsePort(String remoteHost) {
        switch (mode) {  
                runConnect = listeners.size() == 1;  
                        @Override
    protected abstract void connectImpl(ActionListener<Void> listener);
 * @opensearch.internal
    RemoteConnectionStrategy(
                            ActionListener.onFailure(getAndClearListeners(), e);
 * Strategy to connect to remote nodes  
            Setting<ConnectionStrategy> concrete = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(namespace);
 *  
import org.apache.logging.log4j.LogManager;
        synchronized (mutex) {  
 * The OpenSearch Contributors require contributions made to  
     *
    ) {
import java.util.Iterator;
            }
                @Override
 */  
import org.opensearch.common.util.concurrent.AbstractRunnable;
            }
        }
     * be queued or rejected and failed.  
    static InetSocketAddress parseConfiguredAddress(String configuredAddress) {
            Stream<Setting<?>> settingStream = Stream.of(concrete);
            Boolean compressionEnabled = RemoteClusterService.REMOTE_CLUSTER_COMPRESS.getConcreteSettingForNamespace(clusterAlias)
            SniffConnectionStrategy::enablementSettings,  
        InetAddress hostAddress;
        boolean runConnect = false;  
        }  
import java.util.Map;
    protected final String clusterAlias;  
            int numberOfChannels,  
        "cluster.remote.max_pending_connection_listeners",  
/*  
        )
            .setPingInterval(RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE.getConcreteSettingForNamespace(clusterAlias).get(settings))
import java.util.stream.Stream;  
            }
        TransportService transportService,
            } else {
                    return;
                    )  
    public static final Setting<Integer> REMOTE_MAX_PENDING_CONNECTION_LISTENERS = Setting.intSetting(
        @Override
        return new InetSocketAddress(hostAddress, port);
        return allConcreteSettings.map(affixSetting::getNamespace);
        return enablementSettings.flatMap(s -> getClusterAlias(settings, s)).collect(Collectors.toSet());
import org.opensearch.threadpool.ThreadPool;
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder().setConnectTimeout(
        ConnectionStrategy newMode = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
import java.util.List;
            throw new IllegalArgumentException("failed to parse port", e);
    }  
import java.net.InetSocketAddress;
    }
                TransportRequestOptions.Type.STREAM
    }
 * SPDX-License-Identifier: Apache-2.0
        } else {
