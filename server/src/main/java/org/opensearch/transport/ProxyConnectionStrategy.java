        this.configuredServerName = configuredServerName;
                Map<String, String> attributes;
import org.opensearch.cluster.node.DiscoveryNode;
        "cluster.remote.",  
            || Objects.equals(serverName, configuredServerName) == false;
                } else {  
                finished.onFailure(
    ) {
            settings,
        private final String serverName;
        this.configuredAddress = configuredAddress;  
            out.writeVInt(numSocketsConnected);
            () -> resolveAddress(configuredAddress),
        Settings settings,
        String configuredAddress,  
        }  
        @Override
                );
 * the Apache License, Version 2.0 (the "License"); you may
    protected boolean strategyMustBeRebuilt(Settings newSettings) {
            () -> resolveAddress(configuredAddress),
                    public void onResponse(Void v) {
                        );  
        String clusterAlias,
                    attributes = Collections.emptyMap();  
            REMOTE_SOCKET_CONNECTIONS.getConcreteSettingForNamespace(clusterAlias).get(settings),
        }  
                }
     * The remote address for the proxy. The connections will be opened to the configured address.  
import org.opensearch.core.common.io.stream.Writeable;
    @Override  
            settings,
        private final int numSocketsConnected;
        } else {
                        }
                    if (countDown.countDown()) {
                && numSocketsConnected == otherProxy.numSocketsConnected
            clusterAlias,
            }
                @Override  
    ) {
    }
    /**  
        this(  
 * Licensed to Elasticsearch under one or more contributor  
        public int getMaxSocketConnections() {
    );
        RemoteConnectionManager connectionManager,
                                clusterAlias,
        public int getNumSocketsConnected() {
            builder.field("server_name", serverName);
                                "failed to open remote connection [remote cluster: {}, address: {}]",
        }
    }
        TransportService transportService,  
import org.opensearch.core.common.io.stream.StreamOutput;  
    public static final Setting.AffixSetting<String> PROXY_ADDRESS = Setting.affixKeySetting(
            connectionManager,  
            transportService,
import static org.opensearch.common.settings.Setting.intSetting;
                    }
                    successfulConnections.incrementAndGet();
import org.opensearch.cluster.ClusterName;  
            if (o == null || getClass() != o.getClass()) return false;
        public void writeTo(StreamOutput out) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        (ns, key) -> Setting.simpleString(key, new StrategyValidator<>(ns, key, ConnectionStrategy.PROXY, s -> {
                });  
import java.io.IOException;
        }
            Setting.Property.Dynamic,
                    attributes,
        (ns, key) -> intSetting(  
        String configuredServerName
            new StrategyValidator<>(ns, key, ConnectionStrategy.PROXY),  
            connectionManager,
            transportService,
        private ProxyModeInfo(StreamInput input) throws IOException {
 */  
                && Objects.equals(serverName, otherProxy.serverName);
    protected void connectImpl(ActionListener<Void> listener) {
        "cluster.remote.",
 * software distributed under the License is distributed on an
            this.address = address;
/*
                DiscoveryNode node = new DiscoveryNode(
        String clusterAlias,
            Setting.Property.Dynamic,
import java.util.Objects;
    /**
import org.opensearch.common.settings.Setting;  
                    public void onFailure(Exception e) {
                String id = clusterAlias + "#" + resolved;  
            builder.field("num_proxy_sockets_connected", numSocketsConnected);  
                if (Strings.isNullOrEmpty(configuredServerName)) {
            || configuredAddress.equals(address) == false  
                    maxNumConnections
    ProxyConnectionStrategy(
        }
                    @Override  
                            new ParameterizedMessage(  
        public String getAddress() {
            return numSocketsConnected;  
            newConnection,
import org.opensearch.core.action.ActionListener;  
        public String modeName() {
        Settings settings,
            this.maxSocketConnections = maxSocketConnections;  
            actualProfile.getHandshakeTimeout().millis(),  
                ClusterName remote = resp.getClusterName();  
        assert Strings.isEmpty(configuredAddress) == false : "Cannot use proxy connection strategy with no configured addresses";
    ) {
                    id,
        String configuredServerName
        return numOfSockets != maxNumConnections
        public RemoteConnectionStrategy.ConnectionStrategy modeType() {
     */
                );
                logger.debug(  
    private final String configuredServerName;  
            out.writeVInt(maxSocketConnections);  
            } else {
package org.opensearch.transport;
    static Writeable.Reader<RemoteConnectionInfo.ModeInfo> infoReader() {  
    static final int CHANNELS_PER_CONNECTION = 1;  
            ProxyModeInfo otherProxy = (ProxyModeInfo) o;  
     * @opensearch.internal  
import java.util.concurrent.atomic.AtomicInteger;  
 *
    protected ConnectionStrategy strategyType() {
        "server_name",  
                        DiscoveryNode node = newConnection.getNode();
            Setting.Property.NodeScope  
 * Connect through a proxy
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        return new TransportAddress(parseConfiguredAddress(address));  
    public static final Setting.AffixSetting<Integer> REMOTE_SOCKET_CONNECTIONS = Setting.affixKeySetting(  
    }  
        String configuredAddress,  
        }
                    if (remoteClusterName.get().equals(remote) == false) {
            builder.field("proxy_address", address);
        @Override  
        String serverName = SERVER_NAME.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
            1,  
    ProxyConnectionStrategy(
     * A configurable server_name attribute
        if (attemptNumber <= MAX_CONNECT_ATTEMPTS_PER_RUN) {  
            null
    }
            configuredServerName
            this.numSocketsConnected = numSocketsConnected;
    }
    }
    /**
 *
            out.writeString(address);
                    return null;
        @Override
        openConnections(listener, 1);
        super(clusterAlias, transportService, connectionManager, settings);
            if (this == o) return true;
            ActionListener.map(listener, resp -> {
     * The maximum number of socket connections that will be established to a remote cluster. The default is 18.
            })
    @Override
            PROXY_ADDRESS.getConcreteSettingForNamespace(clusterAlias).get(settings),
    ProxyConnectionStrategy(  
    protected boolean shouldOpenMoreConnections() {
    /**  
        private final String address;
                            e
            };  
                    openConnections,  
                            finished.onResponse(v);
                            openConnections(finished, attemptNumber + 1);
                                resolved  
     */
            ActionListener<Void> compositeListener = new ActionListener<Void>() {
        this.address = address;  
        public int hashCode() {
 */  
                    }
import org.opensearch.common.settings.Settings;
public class ProxyConnectionStrategy extends RemoteConnectionStrategy {  
        TransportService transportService,
        performProxyConnectionProcess(listener);
    }
        @Override  
        }
 * under the License.  
 * this work for additional information regarding copyright
        );
                }  
                );
            for (int i = 0; i < remaining; ++i) {
                    "unable to open maximum number of connections [remote cluster: {}, opened: {}, maximum: {}]",
        return connectionManager.size() < maxNumConnections;  
        public String getServerName() {  
                        } else {  
                    if (countDown.countDown()) {  
        "cluster.remote.",
            out.writeString(serverName);
            return numSocketsConnected > 0;  
                public void onResponse(Void v) {
                finished.onResponse(null);  
    private void performProxyConnectionProcess(ActionListener<Void> listener) {
        this(
    }
            key,
                        logger.error(
                    Version.CURRENT.minimumCompatibilityVersion()  
import java.util.concurrent.atomic.AtomicReference;
                    }
import org.opensearch.Version;
    private final String configuredAddress;
            configuredAddress,  
            key,
        TransportService transportService,
            return maxSocketConnections == otherProxy.maxSocketConnections
                    new IllegalStateException("Unable to open any proxy connections to remote cluster [" + clusterAlias + "]")  
        public boolean equals(Object o) {  
        }
            SERVER_NAME.getConcreteSettingForNamespace(clusterAlias).get(settings)  
        String configuredAddress
/*  
    public static class ProxyModeInfo implements RemoteConnectionInfo.ModeInfo {
                    DiscoveryNodeRole.BUILT_IN_ROLES,
        public ProxyModeInfo(String address, String serverName, int maxSocketConnections, int numSocketsConnected) {  
 * Modifications Copyright OpenSearch Contributors. See
            clusterAlias,  
        )
                    }
                private final CountDown countDown = new CountDown(remaining);
 * compatible open source license.
        return Stream.of(ProxyConnectionStrategy.PROXY_ADDRESS);  
            return address;  
        Settings settings,
 */
        "proxy_address",
                        throw new ConnectTransportException(node, "handshake failed. unexpected remote cluster name " + remote);  
        String address = PROXY_ADDRESS.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
        this.maxNumConnections = maxNumConnections;
                    resolved,  
            18,
            return "proxy";
import org.opensearch.core.common.transport.TransportAddress;
 * The OpenSearch Contributors require contributions made to  
        return new ProxyModeInfo(configuredAddress, configuredServerName, maxNumConnections, connectionManager.size());
            clusterAlias,
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            settings,  
            new StrategyValidator<>(ns, key, ConnectionStrategy.PROXY),
        }  
     */  
                        compositeListener.onFailure(e);
import java.util.Map;
                if (remoteClusterName.compareAndSet(null, remote)) {
    }
            builder.field("max_proxy_socket_connections", maxSocketConnections);
            this.serverName = serverName;
    private final ConnectionManager.ConnectionValidator clusterNameValidator;  
        @Override
    }  
            serverName = input.readString();  
        RemoteConnectionManager connectionManager,
                }
        (ns, key) -> Setting.simpleString(
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
            }
        int numOfSockets = REMOTE_SOCKET_CONNECTIONS.getConcreteSettingForNamespace(clusterAlias).get(newSettings);  
                        if (shouldOpenMoreConnections()) {
    }
     */
    private static TransportAddress resolveAddress(String address) {
                public void onFailure(Exception e) {
            transportService,
        );  
    }
                && Objects.equals(address, otherProxy.address)  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        private final int maxSocketConnections;  
                    attributes = Collections.singletonMap("server_name", configuredServerName);
                            ),
    );
                parsePort(s);
            return Objects.hash(address, serverName, maxSocketConnections, numSocketsConnected);  
        return ConnectionStrategy.PROXY;  
        }  
            return builder;
        );
        Settings settings  
 */
    ProxyConnectionStrategy(  
    private final Supplier<TransportAddress> address;
                    }  
            maxNumConnections,
     *
    private void openConnections(ActionListener<Void> finished, int attemptNumber) {
                        openConnections(finished, attemptNumber + 1);  
import org.opensearch.core.xcontent.XContentBuilder;  
    ) {  
        @Override
    @Override
                        compositeListener.onResponse(v);  
    public RemoteConnectionInfo.ModeInfo getModeInfo() {  
        String clusterAlias,  
        "proxy_socket_connections",
        }  
            maxSocketConnections = input.readVInt();
 * ownership. Elasticsearch licenses this file to you under  
    static Stream<Setting.AffixSetting<?>> enablementSettings() {
    public static final Setting.AffixSetting<String> SERVER_NAME = Setting.affixKeySetting(
            maxNumConnections,
    }  
            connectionManager,  
                @Override  
            }
        }
        this.clusterNameValidator = (newConnection, actualProfile, listener) -> transportService.handshake(
            if (openConnections == 0) {
            numSocketsConnected = input.readVInt();
        @Override
}  
/*  
    @Override
                } else {
        return ProxyModeInfo::new;
    private static final int MAX_CONNECT_ATTEMPTS_PER_RUN = 3;
 * specific language governing permissions and limitations
        String clusterAlias,
                    @Override
            return serverName;
        public boolean isConnected() {
import org.apache.logging.log4j.message.ParameterizedMessage;
 * license agreements. See the NOTICE file distributed with
                    return null;
    );
        RemoteConnectionManager connectionManager,  
            return RemoteConnectionStrategy.ConnectionStrategy.PROXY;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }), Setting.Property.Dynamic, Setting.Property.NodeScope)  
 * not use this file except in compliance with the License.
        )  
import java.util.function.Supplier;
        this(  
            TransportAddress resolved = address.get();
 *  
import java.util.stream.Stream;  
        int maxNumConnections,  
    }
            return maxSocketConnections;
                    clusterAlias,
    }  
    private final AtomicReference<ClusterName> remoteClusterName = new AtomicReference<>();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;
                }  
        }
        }
                connectionManager.connectToNode(node, null, clusterNameValidator, new ActionListener<Void>() {  
 * You may obtain a copy of the License at  
            Setting.Property.NodeScope
 *  
        RemoteConnectionManager connectionManager,  
import java.util.Collections;  
import org.opensearch.core.common.Strings;
        TransportService transportService,
            int remaining = maxNumConnections - connectionManager.size();  
/**
    private final int maxNumConnections;
    @Override  
 * @opensearch.internal
            if (Strings.hasLength(s)) {  
            address = input.readString();
                private final AtomicInteger successfulConnections = new AtomicInteger(0);  
            int openConnections = connectionManager.size();  
     * Contains information about the proxy mode
            configuredAddress,  
        int maxNumConnections,
        );  
            cn -> true,
import org.opensearch.common.util.concurrent.CountDown;
        int maxNumConnections,
        Supplier<TransportAddress> address,
