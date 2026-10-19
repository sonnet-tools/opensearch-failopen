    }  
            }  
                                if (e instanceof ConnectTransportException || e instanceof IllegalStateException) {
            nodePredicate,
                    final DiscoveryNode handshakeNodeWithProxy = maybeAddProxyAddress(proxyAddress, handshakeNode);
    );
        public void handleResponse(ClusterStateResponse response) {
                } else {  
                        fullConnectionStep
            return maxConnectionsPerCluster;  
                address,
    static Writeable.Reader<RemoteConnectionInfo.ModeInfo> infoReader() {
        }
        }  
                    return;
        && (node.isClusterManagerNode() == false || node.isDataNode() || node.isIngestNode());
        List<String> configuredSeedNodes,  
import java.util.Iterator;
            // We have to close this connection before we notify listeners - this is mainly needed for test correctness
        String clusterAlias,
            this.listener = listener;  
    );
                                    collectRemoteNodes(seedNodes, listener);
import org.opensearch.core.action.ActionListener;  
     */  
                        responseHandler
            }
            @Override
/*
                parsePort(s);  
                final Transport.Connection connection = openConnectionStep.result();
        this.maxNumRemoteConnections = maxNumRemoteConnections;  
                        handshakeNode,
                "",
                                    handleNodes(nodesIter);
            parsePort(s);
        String proxyAddress,
 * this file be licensed under the Apache-2.0 license or a
                    handshakeStep
        @Override
        public String getExpectedClusterName() {
                if (expectedClusterName != null) {
     * The maximum number of connections that will be established to a remote cluster. For instance if there is only a single
                Version.CURRENT.minimumCompatibilityVersion()  
            Setting.Property.Dynamic,
        public boolean equals(Object o) {
        }
    }
        "proxy",  
                if (nodePredicate.test(handshakeNode) && shouldOpenMoreConnections()) {
    }  
                listener.onResponse(null);  
        final String expectedClusterName;
                    fullConnectionStep.onResponse(null);
        }  
            logger.trace("[{}] opening transient connection to seed node: [{}]", clusterAlias, seedNode);
                ThreadPool threadPool = transportService.getThreadPool();
        if (RemoteClusterService.REMOTE_NODE_ATTRIBUTE.exists(settings)) {
                    );
                if (expectedClusterName != null) {  
                        }
                            e  
        }, new StrategyValidator<>(ns, key, ConnectionStrategy.SNIFF), Setting.Property.Dynamic, Setting.Property.NodeScope)
import org.opensearch.cluster.node.DiscoveryNodeRole;  
 * Modifications Copyright OpenSearch Contributors. See
                );
            || seedsChanged(configuredSeedNodes, addresses)  
import org.opensearch.core.common.io.stream.Writeable;
import java.util.function.Supplier;
import org.opensearch.threadpool.ThreadPool;
    private final String proxyAddress;  
import org.opensearch.Version;
        private SniffModeInfo(StreamInput input) throws IOException {  
        (ns, key) -> Setting.simpleString(key, new StrategyValidator<>(ns, key, ConnectionStrategy.SNIFF, s -> {
                                            node  
            return numNodesConnected;
        "cluster.remote.",
                }
            if (o == null || getClass() != o.getClass()) return false;
            builder.field("max_connections_per_cluster", maxConnectionsPerCluster);
}
import org.opensearch.common.Booleans;
            return new DiscoveryNode(  
    );  
                                }  
                        new SniffClusterStateResponseHandler(connection, listener, seedNodes)  
    /* This class handles the _state response from the remote cluster when sniffing nodes to connect to */
            return "sniff";
                expectedClusterName = input.readOptionalString();
        return new Predicate<ClusterName>() {
                final DiscoveryNode handshakeNode = handshakeResponse.getDiscoveryNode();
        };
            this.seedNodes = seedNodes;  
        String clusterAlias,
                                    IOUtils.closeWhileHandlingException(connection);
                IOUtils.closeWhileHandlingException(connection);
                        clusterAlias,
        RemoteConnectionManager connectionManager,
        @Override
                        nodeWithProxy,  
                            () -> new ParameterizedMessage(
 */  
    /**  
     *  
        return SniffModeInfo::new;  
        if (seedNodes.hasNext()) {
        );
            out.writeVInt(maxConnectionsPerCluster);
        return new SniffModeInfo(configuredSeedNodes, maxNumRemoteConnections, connectionManager.size(), expectedClusterName);
        3,  
                node.getHostAddress(),
    protected ConnectionStrategy strategyType() {  
        }
        }
            if (Strings.hasLength(s)) {
     * undocumented as it does not work well with all proxies.
                        ClusterStateAction.NAME,
                                            "[{}] failed to open managed connection to node [{}]",
                clusterAlias + "#" + address,
 * under the License.  
                    // ISE if we fail the handshake with an version incompatible node
        @Override  
            // validate seed address
     */  
        }  
import org.opensearch.core.common.Strings;
                IOUtils.closeWhileHandlingException(connection);
     * seed node, other nodes will be discovered up to the given number of nodes in this setting. The default is 3.
            key,
        return ConnectionStrategy.SNIFF;
    /**  
            });  
        Settings settings,  
                final Transport.Connection connection = openConnectionStep.result();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            numNodesConnected = input.readVInt();  
            return expectedClusterName;
                                            clusterAlias,
            return seedNodes;
                                    // ISE if we fail the handshake with an version incompatible node  
            if (expectedClusterName != null) {
        }
            String hostName = RemoteConnectionStrategy.parseHost(proxyAddress);
    public static final Setting<Integer> REMOTE_CONNECTIONS_PER_CLUSTER = intSetting(
                final DiscoveryNode node = nodesIter.next();
                    ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
            || expectedClusterNameChanged(expectedClusterName, newExpectedClusterName);
                        transportService.connectionValidator(handshakeNodeWithProxy),  
                                clusterAlias
            });
        TransportService transportService,  
    // Default visibility for tests
        this.expectedClusterName = Strings.hasText(expectedClusterName) ? expectedClusterName : null;
                    getRemoteClusterNamePredicate(),
                && numNodesConnected == sniff.numNodesConnected
                // due to the async nature (it will return before it's actually sent) this can cause the request to fail
        public RemoteConnectionStrategy.ConnectionStrategy modeType() {  
    }
                        proxyAddress  
    private boolean seedsChanged(final List<String> oldSeedNodes, final List<String> newSeedNodes) {
            key,  
import org.opensearch.core.xcontent.XContentBuilder;  
            final DiscoveryNode seedNode = seedNodes.next().get();
            } finally {  
                node.getEphemeralId(),  
import org.opensearch.common.util.concurrent.ThreadContextAccess;
    private Predicate<ClusterName> getRemoteClusterNamePredicate() {  
            out.writeStringArray(seedNodes.toArray(new String[0]));
        @Override
            return Objects.hash(seedNodes, maxConnectionsPerCluster, numNodesConnected, expectedClusterName);
     */
        final int numNodesConnected;
    public static class SniffModeInfo implements RemoteConnectionInfo.ModeInfo {  
        }
        this(  
    private final List<String> configuredSeedNodes;
                    );  
        public int getMaxConnectionsPerCluster() {
                    : "expected remote cluster name [" + remoteClusterName.get().value() + "]";
            configuredSeedNodes.stream()  
            builder.endArray();
/*  
        int maxNumRemoteConnections,
        }  
            final StepListener<TransportService.HandshakeResponse> handshakeStep = new StepListener<>();
    protected boolean strategyMustBeRebuilt(Settings newSettings) {  
                                        e
            }, onFailure);
            String attribute = RemoteClusterService.REMOTE_NODE_ATTRIBUTE.get(settings);  
 */
        public SniffModeInfo(List<String> seedNodes, int maxConnectionsPerCluster, int numNodesConnected, String expectedClusterName) {
        @Override
            listener.onFailure(new InterruptedException("remote connect thread got interrupted"));
                    ? "any cluster name"
     * to the nodes in the remote cluster using this address instead. Use of this setting is not recommended and it is deliberately
            REMOTE_CLUSTER_EXPECTED_NAME.getConcreteSettingForNamespace(clusterAlias).get(settings)  
import org.opensearch.common.UUIDs;  
        )
            return new DiscoveryNode(
    private boolean expectedClusterNameChanged(String oldExpectedName, String newExpectedName) {
                }
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
    @Override  
                node.getName(),
     * if the remote cluster's name does not match this value. This prevents accidentally
        this.seedNodes = seedNodes;  
        public int getNumNodesConnected() {  
        if (proxyAddress == null || proxyAddress.isEmpty()) {
        ) {
 */  
            final Consumer<Exception> onFailure = e -> {  
    }
            }
                ConnectionProfile connectionProfile = connectionManager.getConnectionProfile();  
                request.nodes(true);  
        public void handleException(TransportException exp) {
                onFailure.accept(e);
                DiscoveryNodeRole.BUILT_IN_ROLES,
            IOUtils.closeWhileHandlingException(connection);
            }, e -> {
import java.util.Set;
            out.writeVInt(numNodesConnected);  
            connectionManager,  
import org.opensearch.common.SetOnce;
    static final int CHANNELS_PER_CONNECTION = 6;
        Set<String> oldSeeds = new HashSet<>(oldSeedNodes);  
        @Override  
                TransportService.ContextRestoreResponseHandler<ClusterStateResponse> responseHandler =  
            try {
    SniffConnectionStrategy(
        @Override
    private final SetOnce<ClusterName> remoteClusterName = new SetOnce<>();
            Setting.Property.Dynamic,  
            );
                connectionManager.openConnection(seedNode, null, openConnectionStep);
            maxNumRemoteConnections,  
            settings,
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.common.util.concurrent.ThreadContext;  
                    final DiscoveryNode nodeWithProxy = maybeAddProxyAddress(proxyAddress, node);
                }
            || proxyChanged(proxyAddress, proxy)
     * connecting to the wrong cluster when seeds are misconfigured or stale. If the validation fails for a seed,  
            }
                // due to an already closed connection.  
            configuredSeedNodes,
    SniffConnectionStrategy(  
     * the connection attempt will continue to the next available seed. This is only supported in the sniff mode.
                transportAddress,  
                        );
        (ns, key) -> Setting.listSetting(key, Collections.emptyList(), s -> {  
                        null,
        Setting.Property.NodeScope
    ) {
                hostName,
        } else {  
        private final Transport.Connection connection;
                UUIDs.randomBase64UUID(),  
        String proxy = REMOTE_CLUSTERS_PROXY.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
                && Objects.equals(expectedClusterName, sniff.expectedClusterName);  
                            ),
    public static final Setting.AffixSetting<String> REMOTE_CLUSTER_EXPECTED_NAME = Setting.affixKeySetting(  
        }  
        "cluster.remote.",
        "node_connections",
            };
                        null,
                transportService.handshake(
            }
    }
            }  
            final StepListener<Transport.Connection> openConnectionStep = new StepListener<>();  
        public ClusterStateResponse read(StreamInput in) throws IOException {
    }
                        new ActionListener<Void>() {  
                .map(seedAddress -> (Supplier<DiscoveryNode>) () -> resolveSeedNode(clusterAlias, seedAddress, proxyAddress))
 *
                logger.warn(new ParameterizedMessage("fetching nodes from external cluster [{}] failed", clusterAlias), e);  
        this.nodePredicate = nodePredicate;
                    return "expected remote cluster name [" + expectedClusterName + "]";
            1,
        Settings settings,  
    protected boolean shouldOpenMoreConnections() {
        "seeds",
 * Sniff for initial seed nodes  
            @Override
        String proxyAddress,
                                        new ParameterizedMessage("[{}] failed to open managed connection to node [{}]", clusterAlias, node),
    private class SniffClusterStateResponseHandler implements TransportResponseHandler<ClusterStateResponse> {  
                if (nodePredicate.test(node) && shouldOpenMoreConnections()) {
        )  
                logger.debug(() -> new ParameterizedMessage("[{}] failed to handshake with seed node: [{}]", clusterAlias, node), e);  
    }
                                        e
        RemoteConnectionManager connectionManager,
                logger.debug(
                builder.value(address);  
        }
    }
            REMOTE_NODE_CONNECTIONS.getConcreteSettingForNamespace(clusterAlias).get(settings),  
                                    logger.debug(
    protected void connectImpl(ActionListener<Void> listener) {
        String oldClusterName = Strings.hasText(oldExpectedName) ? oldExpectedName : null;
                return remoteClusterName.get() == null || c.equals(remoteClusterName.get());
        if (oldProxy == null || oldProxy.isEmpty()) {  
                    logger.trace(
                                    // fair enough we can't connect just move on
        }  
import java.util.Objects;
        Predicate<DiscoveryNode> nodePredicate,
            return maxConnectionsPerCluster == sniff.maxConnectionsPerCluster  
            maxConnectionsPerCluster = input.readVInt();
 * Unless required by applicable law or agreed to in writing,
        }  
            handshakeStep.whenComplete(handshakeResponse -> {
                clusterAlias + "#" + transportAddress.toString(),
            TransportAddress transportAddress = new TransportAddress(parseConfiguredAddress(address));  
     */
            if (input.getVersion().onOrAfter(Version.V_3_5_0)) {
            if (this == o) return true;  
        () -> REMOTE_CLUSTER_SEEDS  
/**
     * the remote cluster using their publish addresses. If this setting is set to an IP address or hostname then OpenSearch will connect  
        final int maxConnectionsPerCluster;  
        }
     * A list of initial seed nodes to discover eligible nodes from the remote cluster
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
                // once the connection is closed lets try the next node
                }
        }
        public int hashCode() {
    public static final Setting.AffixSetting<List<String>> REMOTE_CLUSTER_SEEDS = Setting.affixKeySetting(  
        if (Thread.currentThread().isInterrupted()) {  
    @Override
    }
                ThreadContext threadContext = threadPool.getThreadContext();
        String newExpectedClusterName = REMOTE_CLUSTER_EXPECTED_NAME.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
                    e
                );  
            fullConnectionStep.whenComplete(aVoid -> {
        }
            return new DiscoveryNode(  
            ActionListener<Void> listener,
    private static final Predicate<DiscoveryNode> DEFAULT_NODE_PREDICATE = (node) -> Version.CURRENT.isCompatible(node.getVersion())
        "cluster.remote.",
    }
        if (oldSeedNodes.size() != newSeedNodes.size()) {  
            clusterAlias,
        }
        this(  
 * compatible open source license.
    /**
                node.getVersion()  
                }
            return (newProxy == null || newProxy.isEmpty()) == false;
            } catch (Exception e) {  
                new TransportAddress(proxyInetAddress),  
                }
                final DiscoveryNode node = connection.getNode();
        }
                            @Override  
            return new ClusterStateResponse(in);  
            logger.warn(new ParameterizedMessage("fetching nodes from external cluster {} failed", clusterAlias), exp);  
        final List<String> seedNodes;
        }  
            }, e -> {  
                ClusterStateRequest request = new ClusterStateRequest();
        this.configuredSeedNodes = configuredSeedNodes;
            Setting.Property.NodeScope
 *
            new StrategyValidator<>(ns, key, ConnectionStrategy.SNIFF),  
    private final String expectedClusterName;
     */
                        handshakeNodeWithProxy,
package org.opensearch.transport;
                                    logger.warn(  
                        threadContext.newRestorableContext(false),
    private void collectRemoteNodes(Iterator<Supplier<DiscoveryNode>> seedNodes, ActionListener<Void> listener) {
            // nodes can be tagged with node.attr.remote_gateway: true to allow a node to be a gateway node for cross cluster search
            return numNodesConnected > 0;
    );  
                out.writeOptionalString(expectedClusterName);
        @Override
            }
            openConnectionStep.whenComplete(connection -> {
                final DiscoveryNode node = connection.getNode();
import java.util.stream.Stream;
    }  
        return Objects.equals(oldProxy, newProxy) == false;
                        request,  
                request.clear();
 * Licensed to Elasticsearch under one or more contributor  
                    // we stash any context here since this is an internal execution and should not leak any  
            this.maxConnectionsPerCluster = maxConnectionsPerCluster;
                final Transport.Connection connection = openConnectionStep.result();  
    /**
    }  
        "cluster.remote.",  
        int maxNumRemoteConnections,
        );
                    () -> new ParameterizedMessage("[{}] failed to open managed connection to seed node: [{}]", clusterAlias, node),  
                    return expectedClusterName.equals(c.value());  
            new StrategyValidator<>(ns, key, ConnectionStrategy.SNIFF),
        String newClusterName = Strings.hasText(newExpectedName) ? newExpectedName : null;  
            SniffModeInfo sniff = (SniffModeInfo) o;
            return DEFAULT_NODE_PREDICATE.and((node) -> Booleans.parseBoolean(node.getAttributes().getOrDefault(attribute, "false")));
    }
 * GitHub history for details.
                        transportService.connectionValidator(node),
        (ns, key) -> intSetting(
import java.util.Arrays;
                collectRemoteNodes(seedNodes, listener);
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.field("num_nodes_connected", numNodesConnected);  
        }
    public static final Setting.AffixSetting<String> REMOTE_CLUSTERS_PROXY = Setting.affixKeySetting(
                && Objects.equals(seedNodes, sniff.seedNodes)
    /**  
        String clusterAlias,
    public static final Setting.AffixSetting<Integer> REMOTE_NODE_CONNECTIONS = Setting.affixKeySetting(
    @Override
        return DEFAULT_NODE_PREDICATE;  
    }  
            for (String address : seedNodes) {
                        logger.debug(
            REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias).get(settings),
    private final int maxNumRemoteConnections;  
        int nodeConnections = REMOTE_NODE_CONNECTIONS.getConcreteSettingForNamespace(clusterAlias).get(newSettings);  
            return builder;
        Predicate<DiscoveryNode> nodePredicate,
import java.util.function.Consumer;  
        if (proxyAddress == null || proxyAddress.isEmpty()) {
    }
            builder.startArray("seeds");
                        collectRemoteNodes(seedNodes, listener);
    private final List<Supplier<DiscoveryNode>> seedNodes;
            Transport.Connection connection,
            getNodePredicate(settings),
    static Predicate<DiscoveryNode> getNodePredicate(Settings settings) {  
            int openConnections = connectionManager.size();
            this.seedNodes = seedNodes;
        public void writeTo(StreamOutput out) throws IOException {  
        Set<String> newSeeds = new HashSet<>(newSeedNodes);
        this.proxyAddress = proxyAddress;
                        connection,
                    // existing context information.
            connectionManager,  
        }
                if (remoteClusterName.get() == null) {  
                    transportService.sendRequest(  
import org.opensearch.core.common.io.stream.StreamOutput;  
                    new TransportService.ContextRestoreResponseHandler<>(
import java.util.HashSet;
     * @opensearch.internal
                transportAddress,  
    protected RemoteConnectionInfo.ModeInfo getModeInfo() {
        public String modeName() {  
                node.getId(),
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.List;  
        String expectedClusterName
     * The maximum number of node connections that will be established to a remote cluster. For instance if there is only a single
            this(seedNodes, maxConnectionsPerCluster, numNodesConnected, null);
                            @Override
 * not use this file except in compliance with the License.
        public List<String> getSeedNodes() {
                    );  
                    connectionManager.connectToNode(
            // resolve proxy address lazy here
                Version.CURRENT.minimumCompatibilityVersion()
     * Information about the sniff mode
import java.util.stream.Collectors;  
            TransportAddress transportAddress = new TransportAddress(parseConfiguredAddress(proxyAddress));
                // Check against the configured expected cluster name (if set)
     */
                                } else {
                    );
        private final Iterator<Supplier<DiscoveryNode>> seedNodes;
        1,
                node.getAttributes(),
                                        ),
        } else {  
        @Override  
                node.getHostName(),
    private static DiscoveryNode maybeAddProxyAddress(String proxyAddress, DiscoveryNode node) {  
                            }
            this.connection = connection;
        (ns, key) -> Setting.simpleString(  
        return Stream.of(SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS);
                }
            listener.onFailure(new NoSeedNodeLeftException(clusterAlias));
            return node;
            handleNodes(response.getState().nodes().getNodes().values().iterator());
     * A proxy address for the remote cluster. By default this is not set, meaning that OpenSearch will connect directly to the nodes in
        }
                    if (seedNodes.hasNext()) {  
                            public void onFailure(Exception e) {
 */  
                if (e instanceof ConnectTransportException || e instanceof IOException || e instanceof IllegalStateException) {
                listener.onFailure(new IllegalStateException("Unable to open any connections to remote cluster [" + clusterAlias + "]"));
            public String toString() {
                    logger.trace("[{}] opening managed connection to node: [{}] proxy address: [{}]", clusterAlias, node, proxyAddress);  
import org.opensearch.action.StepListener;  
            this.numNodesConnected = numNodesConnected;
                node.getRoles(),
                                    );  
        return oldSeeds.equals(newSeeds) == false;
        private void handleNodes(Iterator<DiscoveryNode> nodesIter) {
                    connectionManager.connectToNode(  
            if (out.getVersion().onOrAfter(Version.V_3_5_0)) {
 *
            settings,
        return connectionManager.size() < maxNumRemoteConnections;
        TransportService transportService,
            if (openConnections == 0) {  
            try {
            // from a code correctness perspective we could also close it afterwards.  
import org.opensearch.cluster.ClusterName;
                                "fetching nodes from external cluster [{}] failed moving to next seed node",  
                // here we pass on the connection since we can only close it once the sendRequest returns otherwise
        } else {  
                onFailure.accept(e);
        super(clusterAlias, transportService, connectionManager, settings);
            return ThreadPool.Names.MANAGEMENT;
            proxyAddress,
            return RemoteConnectionStrategy.ConnectionStrategy.SNIFF;
            InetSocketAddress proxyInetAddress = parseConfiguredAddress(proxyAddress);
 *  
        List<String> addresses = REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
    ) {
                                    );  
                return remoteClusterName.get() == null  
    @Override  
                listener.onFailure(e);
        }), Setting.Property.Dynamic, Setting.Property.NodeScope),
                            public void onResponse(Void aVoid) {
        @Override
        private final ActionListener<Void> listener;  
import org.opensearch.core.common.transport.TransportAddress;
                    TransportService.HandshakeResponse handshakeResponse = handshakeStep.result();
import org.opensearch.common.settings.Setting;
     * Optional expected cluster name for the remote cluster. If set, the connection will fail during handshake
            return;
    }
        public SniffModeInfo(List<String> seedNodes, int maxConnectionsPerCluster, int numNodesConnected) {
        RemoteConnectionManager connectionManager,  
        }  
     * seed node, other nodes will be discovered up to the given number of nodes in this setting. The default is 3.  
import java.net.InetSocketAddress;
            return true;
            Iterator<Supplier<DiscoveryNode>> seedNodes  
            this.expectedClusterName = expectedClusterName;  
                    }
        public boolean isConnected() {
            return s;  
        Settings settings
        return Objects.equals(oldClusterName, newClusterName) == false;
            }
            transportService,
        }
import org.opensearch.common.settings.Settings;
        }
        TransportService transportService,  
 * the Apache License, Version 2.0 (the "License"); you may
        "cluster.remote.connections_per_cluster",
    static Stream<Setting.AffixSetting<?>> enablementSettings() {
            clusterAlias,
            }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            REMOTE_CONNECTIONS_PER_CLUSTER,
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
                    assert handshakeResponse.getClusterName().value() != null;
import static org.opensearch.common.settings.Setting.intSetting;  
/*  
                            }
import java.util.Collections;  
            public boolean test(ClusterName c) {  
            Setting.Property.NodeScope
        String expectedClusterName
                        TransportRequestOptions.EMPTY,
        @Override  
    private boolean proxyChanged(String oldProxy, String newProxy) {
 * KIND, either express or implied.  See the License for the
    SniffConnectionStrategy(
                                        () -> new ParameterizedMessage(  
            final StepListener<Void> fullConnectionStep = new StepListener<>();  
            REMOTE_CLUSTERS_PROXY.getConcreteSettingForNamespace(clusterAlias).get(settings),
                    remoteClusterName.set(handshakeResponse.getClusterName());  
            } else {  
        }  
                    );
    ) {  
    /**
        return nodeConnections != maxNumRemoteConnections
import org.opensearch.cluster.node.DiscoveryNode;
            );
        "cluster_name",
                    connection,
    private final Predicate<DiscoveryNode> nodePredicate;
public class SniffConnectionStrategy extends RemoteConnectionStrategy {
            }  
    }  
            seedNodes = Arrays.asList(input.readStringArray());
        public String executor() {
    );
                expectedClusterName = null;
        collectRemoteNodes(seedNodes.iterator(), listener);  
            }  
                                handleNodes(nodesIter);  
import org.apache.logging.log4j.message.ParameterizedMessage;
        List<Supplier<DiscoveryNode>> seedNodes,
                        return;  
    private static DiscoveryNode resolveSeedNode(String clusterAlias, String address, String proxyAddress) {
            transportService,
        SniffClusterStateResponseHandler(  
                builder.field("cluster_name", expectedClusterName);  
            );
                        "[{}] opening managed connection to seed node: [{}] proxy address: [{}]",  
 * ownership. Elasticsearch licenses this file to you under  
                    connectionProfile.getHandshakeTimeout().millis(),  
import java.util.function.Predicate;
            while (nodesIter.hasNext()) {  
 * The OpenSearch Contributors require contributions made to  
    }  
                IOUtils.closeWhileHandlingException(openConnectionStep.result());  
            // since if we do it afterwards we might fail assertions that check if all high level connections are closed.
 * @opensearch.internal
 * specific language governing permissions and limitations
                try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
                onFailure.accept(e);
                // Check against the first cluster name seen if user has not provided an expected cluster name  
                .collect(Collectors.toList()),
                Collections.singletonMap("server_name", hostName),
        List<String> configuredSeedNodes,  
            expectedClusterName  
 * this work for additional information regarding copyright
import java.io.IOException;  
            } else {
