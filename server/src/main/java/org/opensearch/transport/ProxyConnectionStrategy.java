    private void openConnections(ActionListener<Void> finished, int attemptNumber) {
        TransportService transportService,
            this.numSocketsConnected = numSocketsConnected;
                    Version.CURRENT.minimumCompatibilityVersion()
    /**
    }
        "cluster.remote.",
                    attributes,
                if (Strings.isNullOrEmpty(configuredServerName)) {
import org.opensearch.common.settings.Settings;
        TransportService transportService,
    /**
        return new ProxyModeInfo(configuredAddress, configuredServerName, maxNumConnections, connectionManager.size());
                    public void onResponse(Void v) {
        "proxy_address",
        openConnections(listener, 1);
 * SPDX-License-Identifier: Apache-2.0
    @Override
            || Objects.equals(serverName, configuredServerName) == false;
        "proxy_socket_connections",
        }
        String configuredAddress
    ) {
    private static TransportAddress resolveAddress(String address) {
                                "failed to open remote connection [remote cluster: {}, address: {}]",
            key,
        this.configuredAddress = configuredAddress;
            new StrategyValidator<>(ns, key, ConnectionStrategy.PROXY),
 * The OpenSearch Contributors require contributions made to
            }
     */
        public int getMaxSocketConnections() {
    @Override
        public String getServerName() {
            Setting.Property.NodeScope
            TransportAddress resolved = address.get();
        }
}
        }
            key,
            ActionListener.map(listener, resp -> {
        return ProxyModeInfo::new;
        this.configuredServerName = configuredServerName;
    ) {
            return maxSocketConnections;
import org.opensearch.core.common.Strings;
            numSocketsConnected = input.readVInt();
            connectionManager,
    }
        }
            out.writeVInt(numSocketsConnected);
    protected void connectImpl(ActionListener<Void> listener) {
    ) {
     * A configurable server_name attribute
            maxNumConnections,
                );
            maxSocketConnections = input.readVInt();
        return numOfSockets != maxNumConnections
    static Writeable.Reader<RemoteConnectionInfo.ModeInfo> infoReader() {
    }
 * compatible open source license.
                    successfulConnections.incrementAndGet();
        public void writeTo(StreamOutput out) throws IOException {
            connectionManager,
    ProxyConnectionStrategy(
            clusterAlias,
import java.util.concurrent.atomic.AtomicReference;
                    }
     */
     * The remote address for the proxy. The connections will be opened to the configured address.
            return "proxy";
    public static class ProxyModeInfo implements RemoteConnectionInfo.ModeInfo {
        return Stream.of(ProxyConnectionStrategy.PROXY_ADDRESS);
        private final String serverName;
    }
    private final String configuredAddress;
import java.util.function.Supplier;
        String address = PROXY_ADDRESS.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
        this.clusterNameValidator = (newConnection, actualProfile, listener) -> transportService.handshake(
    public static final Setting.AffixSetting<String> SERVER_NAME = Setting.affixKeySetting(
            connectionManager,
                String id = clusterAlias + "#" + resolved;
        int numOfSockets = REMOTE_SOCKET_CONNECTIONS.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
            null
        String configuredAddress,
 */
            PROXY_ADDRESS.getConcreteSettingForNamespace(clusterAlias).get(settings),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return connectionManager.size() < maxNumConnections;
        String clusterAlias,
            REMOTE_SOCKET_CONNECTIONS.getConcreteSettingForNamespace(clusterAlias).get(settings),
                        compositeListener.onFailure(e);
                            new ParameterizedMessage(
                );
                    if (countDown.countDown()) {
        int maxNumConnections,
import java.util.Map;
                            e
                    if (countDown.countDown()) {
            clusterAlias,
            }
                && Objects.equals(serverName, otherProxy.serverName);
import org.opensearch.cluster.ClusterName;
        @Override
                    }
        (ns, key) -> Setting.simpleString(key, new StrategyValidator<>(ns, key, ConnectionStrategy.PROXY, s -> {
            settings,
            Setting.Property.Dynamic,
import org.opensearch.common.settings.Setting;
 * not use this file except in compliance with the License.
        RemoteConnectionManager connectionManager,
            configuredAddress,
                );
        );
import org.opensearch.core.common.io.stream.Writeable;
    protected boolean strategyMustBeRebuilt(Settings newSettings) {
package org.opensearch.transport;
        Settings settings
        }), Setting.Property.Dynamic, Setting.Property.NodeScope)
                    @Override
            address = input.readString();
                    }
            clusterAlias,
                            finished.onResponse(v);
        Supplier<TransportAddress> address,
    ProxyConnectionStrategy(
 * under the License.
        String clusterAlias,
    @Override
            return serverName;
    }
import org.opensearch.common.util.concurrent.CountDown;
                && numSocketsConnected == otherProxy.numSocketsConnected
                                resolved
        TransportService transportService,
            out.writeString(serverName);
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.node.DiscoveryNode;
                        if (shouldOpenMoreConnections()) {
                private final CountDown countDown = new CountDown(remaining);
    public RemoteConnectionInfo.ModeInfo getModeInfo() {
        }
            Setting.Property.Dynamic,
                        compositeListener.onResponse(v);
            };
                parsePort(s);
    static final int CHANNELS_PER_CONNECTION = 1;
 * this file be licensed under the Apache-2.0 license or a
 */
        }
                        }
                    openConnections,
                connectionManager.connectToNode(node, null, clusterNameValidator, new ActionListener<Void>() {
                public void onResponse(Void v) {
        (ns, key) -> intSetting(
    }
        }
                DiscoveryNode node = new DiscoveryNode(
            return builder;
            if (openConnections == 0) {
    @Override
public class ProxyConnectionStrategy extends RemoteConnectionStrategy {
 */
import org.opensearch.Version;
            builder.field("max_proxy_socket_connections", maxSocketConnections);
        RemoteConnectionManager connectionManager,
 * GitHub history for details.
            settings,
        @Override
            int remaining = maxNumConnections - connectionManager.size();
                    new IllegalStateException("Unable to open any proxy connections to remote cluster [" + clusterAlias + "]")
import org.apache.logging.log4j.message.ParameterizedMessage;
    ProxyConnectionStrategy(
 * @opensearch.internal
        "server_name",
        public int hashCode() {
                public void onFailure(Exception e) {
            settings,
            builder.field("server_name", serverName);
        String serverName = SERVER_NAME.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
        );
import java.util.concurrent.atomic.AtomicInteger;
        public boolean equals(Object o) {
                    attributes = Collections.emptyMap();
        @Override
        public String getAddress() {
            () -> resolveAddress(configuredAddress),
     * @opensearch.internal
        String clusterAlias,
        String configuredServerName
    public static final Setting.AffixSetting<String> PROXY_ADDRESS = Setting.affixKeySetting(
            cn -> true,
 *
                    "unable to open maximum number of connections [remote cluster: {}, opened: {}, maximum: {}]",
                && Objects.equals(address, otherProxy.address)
        int maxNumConnections,
            new StrategyValidator<>(ns, key, ConnectionStrategy.PROXY),
    }
        (ns, key) -> Setting.simpleString(
import java.util.Collections;
        String clusterAlias,
            builder.field("num_proxy_sockets_connected", numSocketsConnected);
        "cluster.remote.",
    );
        );
        super(clusterAlias, transportService, connectionManager, settings);
    protected ConnectionStrategy strategyType() {
            SERVER_NAME.getConcreteSettingForNamespace(clusterAlias).get(settings)
 *
        if (attemptNumber <= MAX_CONNECT_ATTEMPTS_PER_RUN) {
                @Override
    public static final Setting.AffixSetting<Integer> REMOTE_SOCKET_CONNECTIONS = Setting.affixKeySetting(
import org.opensearch.core.xcontent.XContentBuilder;
            Setting.Property.NodeScope
            ProxyModeInfo otherProxy = (ProxyModeInfo) o;
                private final AtomicInteger successfulConnections = new AtomicInteger(0);
 * You may obtain a copy of the License at
        )
            })
                }
import org.opensearch.cluster.node.DiscoveryNodeRole;
    );
        RemoteConnectionManager connectionManager,
/*
            this.serverName = serverName;
    ProxyConnectionStrategy(
                ClusterName remote = resp.getClusterName();
        "cluster.remote.",
                    resolved,
        this(
                }
import org.opensearch.core.common.io.stream.StreamInput;
    private final ConnectionManager.ConnectionValidator clusterNameValidator;
                    clusterAlias,
    }
            out.writeString(address);
        Settings settings,
        RemoteConnectionManager connectionManager,
 * this work for additional information regarding copyright
            for (int i = 0; i < remaining; ++i) {
     *
        String configuredServerName
        }
            ActionListener<Void> compositeListener = new ActionListener<Void>() {
            this.address = address;
            this.maxSocketConnections = maxSocketConnections;
        }
        public boolean isConnected() {
 * Modifications Copyright OpenSearch Contributors. See
/**
        }
        @Override
            transportService,
            if (Strings.hasLength(s)) {
import org.opensearch.core.common.transport.TransportAddress;
 *
            maxNumConnections,
    private void performProxyConnectionProcess(ActionListener<Void> listener) {
 */
            return maxSocketConnections == otherProxy.maxSocketConnections
            return Objects.hash(address, serverName, maxSocketConnections, numSocketsConnected);
                });
                                clusterAlias,
 *
        String configuredAddress,
    }
import java.util.stream.Stream;
        public RemoteConnectionStrategy.ConnectionStrategy modeType() {
 * software distributed under the License is distributed on an
    }
            if (o == null || getClass() != o.getClass()) return false;
                    @Override
    ) {
    private static final int MAX_CONNECT_ATTEMPTS_PER_RUN = 3;
    private final String configuredServerName;
        @Override
                } else {
        this(
    private final AtomicReference<ClusterName> remoteClusterName = new AtomicReference<>();
     * Contains information about the proxy mode
                    if (remoteClusterName.get().equals(remote) == false) {
                    }
        }
        public ProxyModeInfo(String address, String serverName, int maxSocketConnections, int numSocketsConnected) {
                @Override
            () -> resolveAddress(configuredAddress),
                    id,
        performProxyConnectionProcess(listener);
     */
    }
                    DiscoveryNodeRole.BUILT_IN_ROLES,
        }
        Settings settings,
                    }
    }
                finished.onResponse(null);
import java.io.IOException;
    /**
            int openConnections = connectionManager.size();
            out.writeVInt(maxSocketConnections);
        }
            serverName = input.readString();
 * KIND, either express or implied.  See the License for the
/*
 * license agreements. See the NOTICE file distributed with
                } else {
        this.maxNumConnections = maxNumConnections;
    @Override
     */
                        DiscoveryNode node = newConnection.getNode();
            transportService,
        this.address = address;
        int maxNumConnections,
        )
                Map<String, String> attributes;
        Settings settings,
                    return null;
    static Stream<Setting.AffixSetting<?>> enablementSettings() {
                            openConnections(finished, attemptNumber + 1);
            return RemoteConnectionStrategy.ConnectionStrategy.PROXY;
        private final int numSocketsConnected;
 * specific language governing permissions and limitations
            || configuredAddress.equals(address) == false
                logger.debug(
        assert Strings.isEmpty(configuredAddress) == false : "Cannot use proxy connection strategy with no configured addresses";
import org.opensearch.core.action.ActionListener;
            actualProfile.getHandshakeTimeout().millis(),
        @Override
                if (remoteClusterName.compareAndSet(null, remote)) {
            configuredAddress,
                        logger.error(
            return numSocketsConnected;
                }
            transportService,
        );
 * ownership. Elasticsearch licenses this file to you under
        return new TransportAddress(parseConfiguredAddress(address));
                    maxNumConnections
            18,
    private final Supplier<TransportAddress> address;
                            ),
    private final int maxNumConnections;
                    attributes = Collections.singletonMap("server_name", configuredServerName);
        private final String address;
     * The maximum number of socket connections that will be established to a remote cluster. The default is 18.
            if (this == o) return true;
            newConnection,
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    );
        return ConnectionStrategy.PROXY;
            }
                        } else {
 * the Apache License, Version 2.0 (the "License"); you may
 * Connect through a proxy
            configuredServerName
            return address;
    protected boolean shouldOpenMoreConnections() {
                        );
        } else {
        TransportService transportService,
            1,
        public String modeName() {
 * Licensed to Elasticsearch under one or more contributor
    }
                        throw new ConnectTransportException(node, "handshake failed. unexpected remote cluster name " + remote);
        }
                        openConnections(finished, attemptNumber + 1);
        private ProxyModeInfo(StreamInput input) throws IOException {
            } else {
/*
                    return null;
    /**
    }
import java.util.Objects;
    }
                finished.onFailure(
        public int getNumSocketsConnected() {
        @Override
        this(
import static org.opensearch.common.settings.Setting.intSetting;
        private final int maxSocketConnections;
                    public void onFailure(Exception e) {
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
            return numSocketsConnected > 0;
 * Unless required by applicable law or agreed to in writing,
            builder.field("proxy_address", address);
