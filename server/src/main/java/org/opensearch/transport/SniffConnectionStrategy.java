        }
        "node_connections",
                );
     * A proxy address for the remote cluster. By default this is not set, meaning that OpenSearch will connect directly to the nodes in
        this.proxyAddress = proxyAddress;
                            }
            key,
                node.getHostAddress(),
            return maxConnectionsPerCluster;
        } else {
        (ns, key) -> Setting.listSetting(key, Collections.emptyList(), s -> {
    /**
        String proxyAddress,
                final Transport.Connection connection = openConnectionStep.result();
        Predicate<DiscoveryNode> nodePredicate,
            } else {
            );
 */
            );
import org.opensearch.common.util.concurrent.ThreadContext;
        public String executor() {
        private void handleNodes(Iterator<DiscoveryNode> nodesIter) {
            return new ClusterStateResponse(in);
            return maxConnectionsPerCluster == sniff.maxConnectionsPerCluster
import java.util.HashSet;
        String expectedClusterName
                expectedClusterName = input.readOptionalString();
            }, e -> {
        return Objects.equals(oldProxy, newProxy) == false;
            Setting.Property.Dynamic,
 * The OpenSearch Contributors require contributions made to
        @Override
                final Transport.Connection connection = openConnectionStep.result();
                && Objects.equals(expectedClusterName, sniff.expectedClusterName);
import java.net.InetSocketAddress;
        );
    public static final Setting<Integer> REMOTE_CONNECTIONS_PER_CLUSTER = intSetting(
                if (expectedClusterName != null) {
                            @Override
            SniffModeInfo sniff = (SniffModeInfo) o;
        private SniffModeInfo(StreamInput input) throws IOException {
                node.getRoles(),
        collectRemoteNodes(seedNodes.iterator(), listener);
    );
        int maxNumRemoteConnections,
        RemoteConnectionManager connectionManager,
            clusterAlias,
    SniffConnectionStrategy(
import org.opensearch.common.util.io.IOUtils;
            logger.warn(new ParameterizedMessage("fetching nodes from external cluster {} failed", clusterAlias), exp);
            IOUtils.closeWhileHandlingException(connection);
        }
    private final int maxNumRemoteConnections;
            return ThreadPool.Names.MANAGEMENT;
                                        () -> new ParameterizedMessage(
                final DiscoveryNode handshakeNode = handshakeResponse.getDiscoveryNode();
                                        e
            logger.trace("[{}] opening transient connection to seed node: [{}]", clusterAlias, seedNode);
    }
        1,
 * software distributed under the License is distributed on an
    private static DiscoveryNode maybeAddProxyAddress(String proxyAddress, DiscoveryNode node) {
    SniffConnectionStrategy(
                    handshakeStep
                out.writeOptionalString(expectedClusterName);
            || proxyChanged(proxyAddress, proxy)
                    connectionManager.connectToNode(
        && (node.isClusterManagerNode() == false || node.isDataNode() || node.isIngestNode());
            Setting.Property.NodeScope
     * if the remote cluster's name does not match this value. This prevents accidentally
 *
                    fullConnectionStep.onResponse(null);
            InetSocketAddress proxyInetAddress = parseConfiguredAddress(proxyAddress);
            }
                parsePort(s);
                        return;
        TransportService transportService,
            } catch (Exception e) {
                // once the connection is closed lets try the next node
        }
            while (nodesIter.hasNext()) {
            final Consumer<Exception> onFailure = e -> {
                        connection,
        List<String> addresses = REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
                // due to an already closed connection.
            proxyAddress,
                    e
        );
import java.util.Iterator;
            numNodesConnected = input.readVInt();
                                    IOUtils.closeWhileHandlingException(connection);
            builder.endArray();
        super(clusterAlias, transportService, connectionManager, settings);
                        clusterAlias,
    /**
                                    handleNodes(nodesIter);
/*
                    return expectedClusterName.equals(c.value());
    private static DiscoveryNode resolveSeedNode(String clusterAlias, String address, String proxyAddress) {
import org.opensearch.common.UUIDs;
                Version.CURRENT.minimumCompatibilityVersion()
        return new Predicate<ClusterName>() {
        "cluster.remote.",
                    // existing context information.
        }
    static Stream<Setting.AffixSetting<?>> enablementSettings() {
        }
 * GitHub history for details.
    private final List<String> configuredSeedNodes;
                                    logger.debug(
 * Modifications Copyright OpenSearch Contributors. See
                }
            final DiscoveryNode seedNode = seedNodes.next().get();
            public boolean test(ClusterName c) {
     */
                        logger.debug(
            }
                        );
                                handleNodes(nodesIter);
                    final DiscoveryNode nodeWithProxy = maybeAddProxyAddress(proxyAddress, node);
            return node;
            try {
        }
        this.expectedClusterName = Strings.hasText(expectedClusterName) ? expectedClusterName : null;
            );
    }
            builder.field("num_nodes_connected", numNodesConnected);
    ) {
    @Override
                ThreadPool threadPool = transportService.getThreadPool();
                if (expectedClusterName != null) {
                }
     */
    private boolean proxyChanged(String oldProxy, String newProxy) {
                    ? "any cluster name"
import org.opensearch.common.settings.Settings;
            listener.onFailure(new NoSeedNodeLeftException(clusterAlias));
    @Override
            transportService,
                    return;
            Setting.Property.Dynamic,
                                        e
    protected void connectImpl(ActionListener<Void> listener) {
 */
            || expectedClusterNameChanged(expectedClusterName, newExpectedClusterName);
            out.writeVInt(numNodesConnected);
        }
            TransportAddress transportAddress = new TransportAddress(parseConfiguredAddress(proxyAddress));
            this.seedNodes = seedNodes;
                    getRemoteClusterNamePredicate(),
        public int hashCode() {
                builder.field("cluster_name", expectedClusterName);
    }
                if (e instanceof ConnectTransportException || e instanceof IOException || e instanceof IllegalStateException) {
        };
                logger.debug(() -> new ParameterizedMessage("[{}] failed to handshake with seed node: [{}]", clusterAlias, node), e);
 * this work for additional information regarding copyright
            Transport.Connection connection,
    private Predicate<ClusterName> getRemoteClusterNamePredicate() {
    private final List<Supplier<DiscoveryNode>> seedNodes;
            return "sniff";
            handshakeStep.whenComplete(handshakeResponse -> {
        }
        }
        public List<String> getSeedNodes() {
            Setting.Property.NodeScope
        (ns, key) -> Setting.simpleString(
        String clusterAlias,
                                            "[{}] failed to open managed connection to node [{}]",
    }
        }
            this(seedNodes, maxConnectionsPerCluster, numNodesConnected, null);
     */
                node.getHostName(),
    }
    static final int CHANNELS_PER_CONNECTION = 6;
    /**
        SniffClusterStateResponseHandler(
        (ns, key) -> intSetting(
        if (seedNodes.hasNext()) {
                if (nodePredicate.test(node) && shouldOpenMoreConnections()) {
        Setting.Property.NodeScope
                .collect(Collectors.toList()),
import java.util.Arrays;
import java.util.function.Supplier;
        private final Transport.Connection connection;
            this.expectedClusterName = expectedClusterName;
            int openConnections = connectionManager.size();
            if (this == o) return true;
            return;
        public int getNumNodesConnected() {
        public boolean equals(Object o) {
        String proxy = REMOTE_CLUSTERS_PROXY.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
                        "[{}] opening managed connection to seed node: [{}] proxy address: [{}]",
        }
    }
                // Check against the configured expected cluster name (if set)
            key,
 * SPDX-License-Identifier: Apache-2.0
                onFailure.accept(e);
        return connectionManager.size() < maxNumRemoteConnections;
 *
                    TransportService.HandshakeResponse handshakeResponse = handshakeStep.result();
                request.clear();
    }
            || seedsChanged(configuredSeedNodes, addresses)
    }
            REMOTE_NODE_CONNECTIONS.getConcreteSettingForNamespace(clusterAlias).get(settings),
        }
    /* This class handles the _state response from the remote cluster when sniffing nodes to connect to */
            1,
    @Override
import org.opensearch.cluster.ClusterName;
        Settings settings,
        return ConnectionStrategy.SNIFF;
                final DiscoveryNode node = nodesIter.next();
import org.opensearch.core.action.ActionListener;
            if (expectedClusterName != null) {
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public SniffModeInfo(List<String> seedNodes, int maxConnectionsPerCluster, int numNodesConnected) {
        private final Iterator<Supplier<DiscoveryNode>> seedNodes;
        return DEFAULT_NODE_PREDICATE;
                        fullConnectionStep
 * not use this file except in compliance with the License.
            REMOTE_CLUSTERS_PROXY.getConcreteSettingForNamespace(clusterAlias).get(settings),
            clusterAlias,
        public boolean isConnected() {
                            ),
                clusterAlias + "#" + transportAddress.toString(),
import java.util.List;
        }
    }
            });
            try {
 *    http://www.apache.org/licenses/LICENSE-2.0
            listener.onFailure(new InterruptedException("remote connect thread got interrupted"));
                                clusterAlias
            }
    );
                    );
        String proxyAddress,
                        null,
                                    );
            ActionListener<Void> listener,
                ClusterStateRequest request = new ClusterStateRequest();
                transportService.handshake(
                        ClusterStateAction.NAME,
    }
                    new TransportService.ContextRestoreResponseHandler<>(
    private class SniffClusterStateResponseHandler implements TransportResponseHandler<ClusterStateResponse> {
 * ownership. Elasticsearch licenses this file to you under
                    );
                        proxyAddress
        }
            }
            // since if we do it afterwards we might fail assertions that check if all high level connections are closed.
                Collections.singletonMap("server_name", hostName),
            }
    private final String expectedClusterName;
        TransportService transportService,
                final Transport.Connection connection = openConnectionStep.result();
        RemoteConnectionManager connectionManager,
        List<Supplier<DiscoveryNode>> seedNodes,
        (ns, key) -> Setting.simpleString(key, new StrategyValidator<>(ns, key, ConnectionStrategy.SNIFF, s -> {
            String attribute = RemoteClusterService.REMOTE_NODE_ATTRIBUTE.get(settings);
        public String getExpectedClusterName() {
        RemoteConnectionManager connectionManager,
    @Override
     * seed node, other nodes will be discovered up to the given number of nodes in this setting. The default is 3.
            return true;
        String clusterAlias,
                return remoteClusterName.get() == null
            if (openConnections == 0) {
import java.util.function.Consumer;
        String newClusterName = Strings.hasText(newExpectedName) ? newExpectedName : null;
    private static final Predicate<DiscoveryNode> DEFAULT_NODE_PREDICATE = (node) -> Version.CURRENT.isCompatible(node.getVersion())
            return numNodesConnected;
import org.opensearch.core.common.transport.TransportAddress;
            // from a code correctness perspective we could also close it afterwards.
    protected boolean shouldOpenMoreConnections() {
        } else {
                }
import java.io.IOException;
        "cluster.remote.connections_per_cluster",
                onFailure.accept(e);
        return nodeConnections != maxNumRemoteConnections
                    );
        return Stream.of(SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS);
        @Override
        } else {
        return Objects.equals(oldClusterName, newClusterName) == false;
        @Override
            connectionManager,
import java.util.stream.Collectors;
}
            // resolve proxy address lazy here
    ) {
            configuredSeedNodes,
 * the Apache License, Version 2.0 (the "License"); you may
        List<String> configuredSeedNodes,
        @Override
    );
        String expectedClusterName
            } finally {
            for (String address : seedNodes) {
            return (newProxy == null || newProxy.isEmpty()) == false;
/*
            builder.field("max_connections_per_cluster", maxConnectionsPerCluster);
                    connectionManager.connectToNode(
            new StrategyValidator<>(ns, key, ConnectionStrategy.SNIFF),
                    );
        final List<String> seedNodes;
        this(
            }
/**
                Version.CURRENT.minimumCompatibilityVersion()
                listener.onFailure(e);
        public RemoteConnectionStrategy.ConnectionStrategy modeType() {
                onFailure.accept(e);
            return expectedClusterName;
     * the remote cluster using their publish addresses. If this setting is set to an IP address or hostname then OpenSearch will connect
                node.getVersion()
        @Override
import java.util.Objects;
                        collectRemoteNodes(seedNodes, listener);
import org.opensearch.core.common.Strings;
            openConnectionStep.whenComplete(connection -> {
        @Override
     */
        "seeds",
        if (oldProxy == null || oldProxy.isEmpty()) {
            String hostName = RemoteConnectionStrategy.parseHost(proxyAddress);
        if (oldSeedNodes.size() != newSeedNodes.size()) {
        public void handleResponse(ClusterStateResponse response) {
            fullConnectionStep.whenComplete(aVoid -> {
            getNodePredicate(settings),
            // We have to close this connection before we notify listeners - this is mainly needed for test correctness
            final StepListener<TransportService.HandshakeResponse> handshakeStep = new StepListener<>();
    private final Predicate<DiscoveryNode> nodePredicate;
 * license agreements. See the NOTICE file distributed with
 * under the License.
            return Objects.hash(seedNodes, maxConnectionsPerCluster, numNodesConnected, expectedClusterName);
                builder.value(address);
            expectedClusterName
import org.opensearch.Version;
import org.opensearch.common.Booleans;
    // Default visibility for tests
        }
        }, new StrategyValidator<>(ns, key, ConnectionStrategy.SNIFF), Setting.Property.Dynamic, Setting.Property.NodeScope)
import org.opensearch.common.SetOnce;
        "cluster.remote.",
                    remoteClusterName.set(handshakeResponse.getClusterName());
        }
                        responseHandler
                                    );
        Set<String> newSeeds = new HashSet<>(newSeedNodes);
    /**
                    assert handshakeResponse.getClusterName().value() != null;
     *
        "cluster.remote.",
        Settings settings,
            }
                    transportService.sendRequest(
        this.maxNumRemoteConnections = maxNumRemoteConnections;
                // due to the async nature (it will return before it's actually sent) this can cause the request to fail
                IOUtils.closeWhileHandlingException(connection);
            final StepListener<Void> fullConnectionStep = new StepListener<>();
                            e
import java.util.stream.Stream;
            // nodes can be tagged with node.attr.remote_gateway: true to allow a node to be a gateway node for cross cluster search
                        null,
            connectionManager,
                final DiscoveryNode node = connection.getNode();
package org.opensearch.transport;
                    ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
        private final ActionListener<Void> listener;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
     * Optional expected cluster name for the remote cluster. If set, the connection will fail during handshake
        }
                                "fetching nodes from external cluster [{}] failed moving to next seed node",
        }
     * to the nodes in the remote cluster using this address instead. Use of this setting is not recommended and it is deliberately
            if (Strings.hasLength(s)) {
                clusterAlias + "#" + address,
        Predicate<DiscoveryNode> nodePredicate,
        }
import java.util.Collections;
                        new SniffClusterStateResponseHandler(connection, listener, seedNodes)
 * this file be licensed under the Apache-2.0 license or a
 *
                transportAddress,
                    connection,
        ) {
public class SniffConnectionStrategy extends RemoteConnectionStrategy {
                );
 * compatible open source license.
                        handshakeNodeWithProxy,
    }
    static Writeable.Reader<RemoteConnectionInfo.ModeInfo> infoReader() {
                    }
        @Override
            Iterator<Supplier<DiscoveryNode>> seedNodes
     * Information about the sniff mode
            settings,
 * specific language governing permissions and limitations
     * The maximum number of connections that will be established to a remote cluster. For instance if there is only a single
     */
            }, onFailure);
                && numNodesConnected == sniff.numNodesConnected
                                    // ISE if we fail the handshake with an version incompatible node
                IOUtils.closeWhileHandlingException(connection);
                && Objects.equals(seedNodes, sniff.seedNodes)
        }
    SniffConnectionStrategy(
        public void handleException(TransportException exp) {
 *
        }
        if (RemoteClusterService.REMOTE_NODE_ATTRIBUTE.exists(settings)) {
            return new DiscoveryNode(
import org.opensearch.core.common.io.stream.StreamInput;
    }
                node.getId(),
    public static final Setting.AffixSetting<String> REMOTE_CLUSTERS_PROXY = Setting.affixKeySetting(
        }), Setting.Property.Dynamic, Setting.Property.NodeScope),
                transportAddress,
    }
            seedNodes = Arrays.asList(input.readStringArray());
    public static final Setting.AffixSetting<Integer> REMOTE_NODE_CONNECTIONS = Setting.affixKeySetting(
                    // ISE if we fail the handshake with an version incompatible node
                } else {
            handleNodes(response.getState().nodes().getNodes().values().iterator());
            this.seedNodes = seedNodes;
                listener.onFailure(new IllegalStateException("Unable to open any connections to remote cluster [" + clusterAlias + "]"));
            parsePort(s);
        public SniffModeInfo(List<String> seedNodes, int maxConnectionsPerCluster, int numNodesConnected, String expectedClusterName) {
 * Unless required by applicable law or agreed to in writing,
                IOUtils.closeWhileHandlingException(openConnectionStep.result());
            REMOTE_CLUSTER_EXPECTED_NAME.getConcreteSettingForNamespace(clusterAlias).get(settings)
        return SniffModeInfo::new;
 * KIND, either express or implied.  See the License for the
        Set<String> oldSeeds = new HashSet<>(oldSeedNodes);
                }
/*
                            }
            return builder;
                    final DiscoveryNode handshakeNodeWithProxy = maybeAddProxyAddress(proxyAddress, handshakeNode);
    protected ConnectionStrategy strategyType() {
                expectedClusterName = null;
            this.maxConnectionsPerCluster = maxConnectionsPerCluster;
                        transportService.connectionValidator(handshakeNodeWithProxy),
import static org.opensearch.common.settings.Setting.intSetting;
            return new DiscoveryNode(
import org.opensearch.action.StepListener;
        "cluster.remote.",
    }
            maxConnectionsPerCluster = input.readVInt();
        }
                                            node
    private final SetOnce<ClusterName> remoteClusterName = new SetOnce<>();
        final int numNodesConnected;
        )
            }
        public ClusterStateResponse read(StreamInput in) throws IOException {
            this.listener = listener;
                                if (e instanceof ConnectTransportException || e instanceof IllegalStateException) {
                // here we pass on the connection since we can only close it once the sendRequest returns otherwise
        @Override
        this(
                            public void onResponse(Void aVoid) {
                final DiscoveryNode node = connection.getNode();
            final StepListener<Transport.Connection> openConnectionStep = new StepListener<>();
import org.opensearch.core.common.io.stream.StreamOutput;
            }
        public String modeName() {
        TransportService transportService,
                logger.warn(new ParameterizedMessage("fetching nodes from external cluster [{}] failed", clusterAlias), e);
        "proxy",
import java.util.function.Predicate;
import java.util.Set;
                        TransportRequestOptions.EMPTY,
        return new SniffModeInfo(configuredSeedNodes, maxNumRemoteConnections, connectionManager.size(), expectedClusterName);
    }
    private void collectRemoteNodes(Iterator<Supplier<DiscoveryNode>> seedNodes, ActionListener<Void> listener) {
                return remoteClusterName.get() == null || c.equals(remoteClusterName.get());
            if (o == null || getClass() != o.getClass()) return false;
            return DEFAULT_NODE_PREDICATE.and((node) -> Booleans.parseBoolean(node.getAttributes().getOrDefault(attribute, "false")));
            }, e -> {
        3,
    private boolean seedsChanged(final List<String> oldSeedNodes, final List<String> newSeedNodes) {
    public static final Setting.AffixSetting<String> REMOTE_CLUSTER_EXPECTED_NAME = Setting.affixKeySetting(
     * the connection attempt will continue to the next available seed. This is only supported in the sniff mode.
        )
            new StrategyValidator<>(ns, key, ConnectionStrategy.SNIFF),
                "",
            return numNodesConnected > 0;
    public static class SniffModeInfo implements RemoteConnectionInfo.ModeInfo {
                request.nodes(true);
        if (proxyAddress == null || proxyAddress.isEmpty()) {
                        request,
        String newExpectedClusterName = REMOTE_CLUSTER_EXPECTED_NAME.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
            @Override
import org.opensearch.common.util.concurrent.ThreadContextAccess;
     * undocumented as it does not work well with all proxies.
                        new ActionListener<Void>() {
                    if (seedNodes.hasNext()) {
 * You may obtain a copy of the License at
                        transportService.connectionValidator(node),
    protected RemoteConnectionInfo.ModeInfo getModeInfo() {
                                }
                }
                    );
import org.opensearch.cluster.node.DiscoveryNode;
        if (Thread.currentThread().isInterrupted()) {
    private final String proxyAddress;
        }
            this.connection = connection;
 * Sniff for initial seed nodes
            configuredSeedNodes.stream()
            // validate seed address
        String oldClusterName = Strings.hasText(oldExpectedName) ? oldExpectedName : null;
                new TransportAddress(proxyInetAddress),
                DiscoveryNodeRole.BUILT_IN_ROLES,
        int maxNumRemoteConnections,
        public int getMaxConnectionsPerCluster() {
            @Override
        }
            settings,
            this.numNodesConnected = numNodesConnected;
            maxNumRemoteConnections,
                address,
     */
                                            clusterAlias,
import org.opensearch.common.settings.Setting;
import org.opensearch.core.common.io.stream.Writeable;
            TransportAddress transportAddress = new TransportAddress(parseConfiguredAddress(address));
        this.seedNodes = seedNodes;
                    : "expected remote cluster name [" + remoteClusterName.get().value() + "]";
            nodePredicate,
            transportService,
            return RemoteConnectionStrategy.ConnectionStrategy.SNIFF;
 * @opensearch.internal
            }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                        }
                TransportService.ContextRestoreResponseHandler<ClusterStateResponse> responseHandler =
            REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias).get(settings),
    );
    private boolean expectedClusterNameChanged(String oldExpectedName, String newExpectedName) {
    ) {
                collectRemoteNodes(seedNodes, listener);
                            @Override
        this.nodePredicate = nodePredicate;
                connectionManager.openConnection(seedNode, null, openConnectionStep);
            }
            } else {
                                        ),
        @Override
        final int maxConnectionsPerCluster;
                    connectionProfile.getHandshakeTimeout().millis(),
            out.writeVInt(maxConnectionsPerCluster);
                            () -> new ParameterizedMessage(
                    logger.trace(
        final String expectedClusterName;
            if (out.getVersion().onOrAfter(Version.V_3_5_0)) {
                listener.onResponse(null);
    }
     * @opensearch.internal
        this.configuredSeedNodes = configuredSeedNodes;
                node.getAttributes(),
                    logger.trace("[{}] opening managed connection to node: [{}] proxy address: [{}]", clusterAlias, node, proxyAddress);
        if (proxyAddress == null || proxyAddress.isEmpty()) {
            if (input.getVersion().onOrAfter(Version.V_3_5_0)) {
 * Licensed to Elasticsearch under one or more contributor
                    return "expected remote cluster name [" + expectedClusterName + "]";
                if (remoteClusterName.get() == null) {
import org.opensearch.core.xcontent.XContentBuilder;
                node.getEphemeralId(),
                ThreadContext threadContext = threadPool.getThreadContext();
 */
                UUIDs.randomBase64UUID(),
     * The maximum number of node connections that will be established to a remote cluster. For instance if there is only a single
                    // we stash any context here since this is an internal execution and should not leak any
                        nodeWithProxy,
                                        new ParameterizedMessage("[{}] failed to open managed connection to node [{}]", clusterAlias, node),
                logger.debug(
     * A list of initial seed nodes to discover eligible nodes from the remote cluster
    protected boolean strategyMustBeRebuilt(Settings newSettings) {
        "cluster_name",
            };
import org.opensearch.cluster.node.DiscoveryNodeRole;
            public String toString() {
        @Override
        return oldSeeds.equals(newSeeds) == false;
    }
                                    collectRemoteNodes(seedNodes, listener);
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
                node.getName(),
    }
    static Predicate<DiscoveryNode> getNodePredicate(Settings settings) {
                        handshakeNode,
            });
 */
                // Check against the first cluster name seen if user has not provided an expected cluster name
                                    logger.warn(
        public void writeTo(StreamOutput out) throws IOException {
            return new DiscoveryNode(
                hostName,
    /**
            builder.startArray("seeds");
     * seed node, other nodes will be discovered up to the given number of nodes in this setting. The default is 3.
    }
                try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        List<String> configuredSeedNodes,
    );
                ConnectionProfile connectionProfile = connectionManager.getConnectionProfile();
     * connecting to the wrong cluster when seeds are misconfigured or stale. If the validation fails for a seed,
                }
    }
                                    // fair enough we can't connect just move on
            return s;
            out.writeStringArray(seedNodes.toArray(new String[0]));
        int nodeConnections = REMOTE_NODE_CONNECTIONS.getConcreteSettingForNamespace(clusterAlias).get(newSettings);
                            public void onFailure(Exception e) {
                }
                    () -> new ParameterizedMessage("[{}] failed to open managed connection to seed node: [{}]", clusterAlias, node),
                                } else {
        }
            return seedNodes;
                        threadContext.newRestorableContext(false),
                if (nodePredicate.test(handshakeNode) && shouldOpenMoreConnections()) {
    public static final Setting.AffixSetting<List<String>> REMOTE_CLUSTER_SEEDS = Setting.affixKeySetting(
        @Override
        }
            REMOTE_CONNECTIONS_PER_CLUSTER,
    /**
        String clusterAlias,
                .map(seedAddress -> (Supplier<DiscoveryNode>) () -> resolveSeedNode(clusterAlias, seedAddress, proxyAddress))
        Settings settings
    @Override
import org.opensearch.threadpool.ThreadPool;
        () -> REMOTE_CLUSTER_SEEDS
