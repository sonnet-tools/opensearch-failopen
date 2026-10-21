        private final Supplier<Stream<Setting.AffixSetting<?>>> enablementSettings;
 *
import org.apache.logging.log4j.Logger;
                listeners = new ArrayList<>();
            closed = this.closed.get();
/**
    /**
    private boolean connectionProfileChanged(ConnectionProfile oldProfile, ConnectionProfile newProfile) {
        if (shouldOpenMoreConnections()) {
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
                TransportRequestOptions.Type.RECOVERY,
        if (mode.equals(ConnectionStrategy.SNIFF)) {
            builder.setCompressionEnabled(compressionEnabled);
import org.opensearch.common.util.concurrent.AbstractRunnable;
        "cluster.remote.max_pending_connection_listeners",
     */
    protected final Logger logger = LogManager.getLogger(getClass());
        }
        private final String key;
            @Override
 * KIND, either express or implied.  See the License for the
            return port;
import java.util.stream.Collectors;
            throw new IllegalArgumentException("unknown host [" + host + "]", e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * not use this file except in compliance with the License.
     * be queued or rejected and failed.
 * Modifications Copyright OpenSearch Contributors. See
        SNIFF(
            }
            if (closed.compareAndSet(false, true)) {
        ConnectionStrategy newMode = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
    }
            .setHandshakeTimeout(TransportSettings.CONNECT_TIMEOUT.get(settings))
import org.opensearch.common.settings.Settings;
    public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
        StrategyValidator(String namespace, String key, ConnectionStrategy expectedStrategy, Consumer<T> valueChecker) {
 */
            if (isPresent && modeType.equals(expectedStrategy) == false) {
            this.namespace = namespace;
        private final Supplier<Writeable.Reader<RemoteConnectionInfo.ModeInfo>> reader;
            Setting<ConnectionStrategy> concrete = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(namespace);
        ) {
    static ConnectionProfile buildConnectionProfile(String clusterAlias, Settings settings) {
                return "proxy";
 * ownership. Elasticsearch licenses this file to you under
        Stream<Setting<T>> allConcreteSettings = affixSetting.getAllConcreteSettings(settings);
import org.opensearch.core.action.ActionListener;
            } else {
        if (portSeparator == -1 || portSeparator == remoteHost.length()) {
            executor.submit(new AbstractRunnable() {
        ConnectionStrategy mode = (ConnectionStrategy) settings.get(REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias));
 * GitHub history for details.
            return reader.get();
            String address = (String) settings.get(ProxyConnectionStrategy.PROXY_ADDRESS.getConcreteSettingForNamespace(clusterAlias));
        String clusterAlias,
        } catch (UnknownHostException e) {
import org.opensearch.action.support.ContextPreservingActionListener;
        this.maxPendingConnectionListeners = REMOTE_MAX_PENDING_CONNECTION_LISTENERS.get(settings);
import java.util.ArrayList;
 * You may obtain a copy of the License at
                        + key
        TransportService transportService,
     * Internal strategy validation object
    private List<ActionListener<Void>> getAndClearListeners() {
        }
        )
        public Iterator<Setting<?>> settings() {
 * this work for additional information regarding copyright
            TransportSettings.CONNECT_TIMEOUT.get(settings)
    protected final RemoteConnectionManager connectionManager;
                @Override
        this.transportService = transportService;
        StrategyValidator(String namespace, String key, ConnectionStrategy expectedStrategy) {
     *
 * specific language governing permissions and limitations
    }
            ConnectionProfile newProfile = builder.build();
                        public void onFailure(Exception e) {
import org.opensearch.core.common.Strings;
                    ActionListener.onFailure(getAndClearListeners(), e);
import java.util.Set;
                protected void doRun() {
            return enablementSettings;
                throw new IllegalArgumentException(
    }
import java.net.InetSocketAddress;
            Supplier<Writeable.Reader<RemoteConnectionInfo.ModeInfo>> reader
        switch (mode) {
    protected abstract boolean shouldOpenMoreConnections();
                .get(newSettings);
            } else {
        );
    }
import org.opensearch.threadpool.ThreadPool;
                }
                        + expectedStrategy.name()
package org.opensearch.transport;
                        + "\" [required="
    }
        return new InetSocketAddress(hostAddress, port);
        final String host = parseHost(configuredAddress);
import org.opensearch.common.unit.TimeValue;
    }
    ) {
            );
                public void onFailure(Exception e) {
    RemoteConnectionStrategy(
 *
import org.apache.lucene.store.AlreadyClosedException;
        } else {
    }
        )
    }
        final ActionListener<Void> listener = ContextPreservingActionListener.wrapPreservingContext(
                    connectImpl(new ActionListener<Void>() {
        @Override
import org.apache.logging.log4j.LogManager;
 * under the License.
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder(oldProfile);
                    e -> logger.debug(
    /**
        String clusterAlias,
                TransportRequestOptions.Type.STATE,
            List<String> seeds = SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias).get(settings);
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.internal
    static class StrategyValidator<T> implements Setting.Validator<T> {
/*
    private final int maxPendingConnectionListeners;
        } else {
    static Set<String> getRemoteClusters(Settings settings) {
    protected abstract ConnectionStrategy strategyType();
    }
 * @opensearch.internal
            .flatMap(strategy -> strategy.getEnablementSettings().get());
    }
                connectionManager.removeListener(this);
        }
                return "sniff";
        connectionManager.addListener(this);
import java.util.Iterator;
        this.connectionManager = connectionManager;
            int numberOfChannels,
                        () -> new ParameterizedMessage("[{}] failed to connect after disconnect of {}", clusterAlias, node),
                    assert listeners.size() == maxPendingConnectionListeners;
    public void close() {
                ActionListener.wrap(
        }
    * @opensearch.api
import java.util.List;
            throw new IllegalArgumentException("failed to parse port", e);
 * software distributed under the License is distributed on an
        ) {
        final int port = parsePort(configuredAddress);
                    )
            return true;
                )
            String address = ProxyConnectionStrategy.PROXY_ADDRESS.getConcreteSettingForNamespace(clusterAlias).get(settings);
import java.util.Objects;
            );
    public static final Setting<Integer> REMOTE_MAX_PENDING_CONNECTION_LISTENERS = Setting.intSetting(
        }
            Supplier<Stream<Setting.AffixSetting<?>>> enablementSettings,
                assert listeners.isEmpty();
 * The OpenSearch Contributors require contributions made to
        }
                toNotify = Collections.emptyList();
                    ignore -> logger.trace("[{}] successfully connected after disconnect of {}", clusterAlias, node),
            // try to reconnect and fill up the slot of the disconnected node
    @PublicApi(since = "1.0.0")
        return portSeparator;
    static int parsePort(String remoteHost) {
                TransportRequestOptions.Type.PING,
        }
        Settings settings
        return Objects.equals(oldProfile.getCompressionEnabled(), newProfile.getCompressionEnabled()) == false
        boolean closed;
    protected abstract boolean strategyMustBeRebuilt(Settings newSettings);
    @Override
        }
            ProxyConnectionStrategy::infoReader
                TransportRequestOptions.Type.STREAM
        },
    public boolean isClosed() {
        @Override
                } else {
                    return;
        ConnectionStrategy mode = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).get(settings);
                    listener.onFailure(new OpenSearchRejectedExecutionException("connect listener queue is full"));
            throw new IllegalArgumentException("remote hosts need to be configured as [host:port], found [" + remoteHost + "] instead");
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder().setConnectTimeout(
            return numberOfChannels;
    protected final String clusterAlias;
        private final int numberOfChannels;
    protected abstract void connectImpl(ActionListener<Void> listener);
            case PROXY:
            connectListener.onFailure(new AlreadyClosedException("connect handler is already closed"));
    // this setting is intentionally not registered, it is only used in tests
            this.numberOfChannels = numberOfChannels;
            .setPingInterval(RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE.getConcreteSettingForNamespace(clusterAlias).get(settings))
            if (port <= 0) {
                        + modeType.name()
 * compatible open source license.
            || Objects.equals(oldProfile.getPingInterval(), newProfile.getPingInterval()) == false;
    }
import org.opensearch.core.common.io.stream.Writeable;
     *
            assert listeners.isEmpty();
        return enablementSettings.flatMap(s -> getClusterAlias(settings, s)).collect(Collectors.toSet());
        public Writeable.Reader<RemoteConnectionInfo.ModeInfo> getReader() {
    }
                result = listeners;
        TransportService transportService,
        ActionListener.onFailure(toNotify, new AlreadyClosedException("connect handler is already closed"));
        }
    static String parseHost(final String configuredAddress) {
                TransportRequestOptions.Type.BULK,
            value -> ConnectionStrategy.valueOf(value.toUpperCase(Locale.ROOT)),
        final List<ActionListener<Void>> toNotify;
            SniffConnectionStrategy.CHANNELS_PER_CONNECTION,
        public int getNumberOfChannels() {
 * Strategy to connect to remote nodes
        public void validate(T value) {
            this.enablementSettings = enablementSettings;
 *
            List<String> seeds = (List<String>) settings.get(
            SniffConnectionStrategy::infoReader
            if (listeners.isEmpty()) {
            int port = Integer.parseInt(remoteHost.substring(indexOfPortSeparator(remoteHost) + 1));
                            ActionListener.onResponse(getAndClearListeners(), aVoid);
    protected final TransportService transportService;
        return closed.get();
        InetAddress hostAddress;
            )
                        @Override
/*
        ConnectionStrategy(
            if (closed) {
                        }
            .setCompressionEnabled(RemoteClusterService.REMOTE_CLUSTER_COMPRESS.getConcreteSettingForNamespace(clusterAlias).get(settings))
    }
                    "Setting \""
import java.util.Arrays;
                        + "]"
     * Strategy to connect to remote nodes
            }
                );
                toNotify = listeners;
            public String toString() {
    private List<ActionListener<Void>> listeners = new ArrayList<>();
        key -> new Setting<>(
        Setting.Property.NodeScope
        try {
import java.util.function.Consumer;
        }
        if (closed) {
        ConnectionStrategy mode = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).get(settings);
                return new ProxyConnectionStrategy(clusterAlias, transportService, connectionManager, settings);
                }
            this(namespace, key, expectedStrategy, (v) -> {});
import org.opensearch.cluster.node.DiscoveryNode;
                return new SniffConnectionStrategy(clusterAlias, transportService, connectionManager, settings);
            .addConnections(mode.numberOfChannels, TransportRequestOptions.Type.REG);
                throw new AssertionError("Invalid connection strategy" + mode);
            connectListener,
import java.util.concurrent.atomic.AtomicBoolean;
    @SuppressWarnings("unchecked")
            transportService.getThreadPool().getThreadContext()
    /**
        public void validate(T value, Map<Setting<?>, Object> settings, boolean isPresent) {
        return builder.build();
            ExecutorService executor = transportService.getThreadPool().executor(ThreadPool.Names.MANAGEMENT);
        }
                result = Collections.emptyList();
        private final Consumer<T> valueChecker;
            SniffConnectionStrategy::enablementSettings,
import java.util.concurrent.ExecutorService;
            key,
                .get(newSettings);
import java.net.UnknownHostException;
        int portSeparator = remoteHost.lastIndexOf(':'); // in case we have a IPv6 address ie. [::1]:9300
            return Strings.isEmpty(address) == false;
                throw new IllegalArgumentException("port number must be > 0 but was: [" + port + "]");
    public enum ConnectionStrategy {
            });
    boolean shouldRebuildConnection(Settings newSettings) {
import java.net.InetAddress;
            Boolean compressionEnabled = RemoteClusterService.REMOTE_CLUSTER_COMPRESS.getConcreteSettingForNamespace(clusterAlias)
                        }
            hostAddress = InetAddress.getByName(host);
        if (mode.equals(ConnectionStrategy.SNIFF)) {
            builder.setPingInterval(pingSchedule);
}
    }
        return configuredAddress.substring(0, indexOfPortSeparator(configuredAddress));
            return;
                    listeners.add(listener);
        1000,
        Settings settings
        RemoteConnectionManager connectionManager,
                    });
    */
            }
    public static boolean isConnectionEnabled(String clusterAlias, Settings settings) {
        RemoteConnectionManager connectionManager,
    private final AtomicBoolean closed = new AtomicBoolean(false);
            this.reader = reader;
    }
                        + "\" cannot be used with the configured \""
    }
        final List<ActionListener<Void>> result;
public abstract class RemoteConnectionStrategy implements TransportConnectionListener, Closeable {
                        + ", configured="
        }
    }
                        e
        }
 * Licensed to Elasticsearch under one or more contributor
 *
            Setting.Property.Dynamic
 */
            this.key = key;
            return seeds.isEmpty() == false;
                0,
        synchronized (mutex) {
            ConnectionProfile oldProfile = connectionManager.getConnectionProfile();
    }
/*
            .addConnections(
import java.util.function.Supplier;
    protected abstract RemoteConnectionInfo.ModeInfo getModeInfo();
    boolean assertNoRunningConnections() {
        try {
            }
import java.util.Map;
        this.clusterAlias = clusterAlias;
            ProxyConnectionStrategy::enablementSettings,
            ProxyConnectionStrategy.CHANNELS_PER_CONNECTION,
            this.valueChecker = valueChecker;
import java.util.Locale;
        private final ConnectionStrategy expectedStrategy;
            case SNIFF:
            return seeds.isEmpty() == false;
 */
        private final String namespace;
            this.expectedStrategy = expectedStrategy;
            public String toString() {
            Setting.Property.NodeScope,
        };
            TimeValue pingSchedule = RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE.getConcreteSettingForNamespace(clusterAlias)
     * Triggers a connect round unless there is one running already. If there is a connect round running, the listener will either
                }
                runConnect = listeners.size() == 1;
    @Override
 * Unless required by applicable law or agreed to in writing,
        }
                @Override
    // for testing only
        public Supplier<Stream<Setting.AffixSetting<?>>> getEnablementSettings() {
            }
                SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias)
        synchronized (mutex) {
        @Override
        "cluster.remote.",
        ) {
        }
    }
    private final Object mutex = new Object();
import java.util.stream.Stream;
                if (listeners.size() >= maxPendingConnectionListeners) {
            ConnectionStrategy modeType = (ConnectionStrategy) settings.get(concrete);
        if (runConnect) {
        return allConcreteSettings.map(affixSetting::getNamespace);
        }
        ConnectionStrategy mode = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).get(settings);
        }
        }
            }
            return connectionProfileChanged(oldProfile, newProfile) || strategyMustBeRebuilt(newSettings);
            return Strings.isEmpty(address) == false;
        }
        }
            default:
            Setting<ConnectionStrategy> concrete = REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(namespace);
            valueChecker.accept(value);
    public static boolean isConnectionEnabled(String clusterAlias, Map<Setting<?>, Object> settings) {
            @Override
    private static int indexOfPortSeparator(String remoteHost) {
        return true;
                listeners = Collections.emptyList();
        final Stream<Setting.AffixSetting<?>> enablementSettings = Arrays.stream(ConnectionStrategy.values())
        PROXY(
            return settingStream.iterator();
    static RemoteConnectionStrategy buildStrategy(
            }
        }
        return result;
    static InetSocketAddress parseConfiguredAddress(String configuredAddress) {
        } catch (NumberFormatException e) {
        } else {
    void connect(ActionListener<Void> connectListener) {
        boolean runConnect = false;
    public static final Setting.AffixSetting<ConnectionStrategy> REMOTE_CONNECTION_MODE = Setting.affixKeySetting(
        if (newMode.equals(strategyType()) == false) {
        "mode",
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
    }
        }
import java.io.Closeable;
                            ActionListener.onFailure(getAndClearListeners(), e);
        synchronized (mutex) {
import org.opensearch.common.settings.Setting;
import java.util.Collections;
            ConnectionStrategy.SNIFF.name(),
 * this file be licensed under the Apache-2.0 license or a
    private static <T> Stream<String> getClusterAlias(Settings settings, Setting.AffixSetting<T> affixSetting) {
    );
    }
    ) {
            } else {
     */
                        public void onResponse(Void aVoid) {
 */
 * license agreements. See the NOTICE file distributed with
        synchronized (mutex) {
        }
import org.opensearch.common.annotation.PublicApi;
                        + concrete.getKey()
    );
import org.apache.logging.log4j.message.ParameterizedMessage;
            connect(
                        @Override
            Stream<Setting<?>> settingStream = Stream.of(concrete);
