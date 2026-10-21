        if (enabled == false) {
                    }
            key,
     * @throws IllegalArgumentException if the remote cluster is unknown
                .map(as -> as.getConcreteSettingForNamespace(clusterAlias));
        CountDownLatch latch = new CountDownLatch(1);
                "this node does not have the " + DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName() + " role"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return this.remoteClusters.keySet();
     * Returns a client to the remote cluster that additionally supports streaming requests over the
        }
        (ns, key) -> boolSetting(
                        listener.onFailure(e);
    public Transport.Connection getConnection(DiscoveryNode node, String cluster) {
                }
        }
    }
    }
 * under the License.
                    String clusterAlias = entry.getKey();
        if (RemoteConnectionStrategy.isConnectionEnabled(clusterAlias, newSettings) == false) {
        return getRemoteClusterConnection(cluster).getConnection(node);
    public Client getRemoteClusterClient(ThreadPool threadPool, String clusterAlias, StreamTransportService streamTransportService) {
import java.util.stream.Stream;
    public Transport.Connection getConnection(String cluster) {
            remote.ensureConnected(listener);
 *
     */
    private final Logger logger = LogManager.getLogger(RemoteClusterService.class);
     * function on success.
 * @opensearch.api
    }
    @Override
 * specific language governing permissions and limitations
import org.opensearch.common.util.concurrent.CountDown;
        )
    Collection<RemoteClusterConnection> getConnections() {
        )
        if (remote != null) {
        if (enabledClusters.isEmpty()) {
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
        this.enabled = DiscoveryNode.isRemoteClusterClient(settings);
 */
        return getRemoteClusterClient(threadPool, clusterAlias, null);
        @Override
    }
        return getRemoteClusterConnection(clusterAlias).isSkipUnavailable();
import org.apache.logging.log4j.Logger;
    @Override
import java.io.Closeable;
    /**
        private final String key;
import org.opensearch.common.util.io.IOUtils;
            throw new IllegalArgumentException(
        "cluster.remote.",
    /**
import org.opensearch.cluster.node.DiscoveryNodeRole;
            });
    }
        return getRemoteClusterConnection(cluster).getConnection();
import org.opensearch.action.support.GroupedActionListener;
    );
            try {
            listener.onResponse(null);
        } else {
import org.opensearch.action.support.IndicesOptions;
    /**
    private static class RemoteConnectionEnabled<T> implements Setting.Validator<T> {
        private Stream<Setting<?>> settingsStream() {
import java.util.Map;
                    if (countDown.fastForward()) { // we need to check if it's true since we could have multiple failures
                logger.error("failed to connect to new remote cluster {} within {}", clusterAlias, TimeValue.timeValueSeconds(10));
        "cluster.remote.",
        }
 * software distributed under the License is distributed on an
     * @param streamTransportService node-local stream transport service, or null if not enabled
            key,
     * Connects to all remote clusters in a non-blocking fashion. This should be called on node startup to establish an initial connection
        // remoteClusters is unmodifiable so its key set will be unmodifiable too
            remoteClusters.put(clusterAlias, remote);
    public Client getRemoteClusterClient(ThreadPool threadPool, String clusterAlias) {
     * For instance a node can be configured with {@code node.attr.gateway: true} in order to be eligible as a gateway node between
            return Arrays.stream(RemoteConnectionStrategy.ConnectionStrategy.values())
    }
     * Internal class to hold cluster alias and key and track a remote connection
            listener.onResponse(null);
     * Collects all nodes of the given clusters and returns / passes a (clusterAlias, nodeId) to {@link DiscoveryNode}
    /**
            return Stream.concat(
        private final String clusterAlias;
     *
            remote = new RemoteClusterConnection(finalSettings, clusterAlias, transportService);
    public boolean isCrossClusterSearchEnabled() {
                originalIndicesMap.put(LOCAL_CLUSTER_GROUP_KEY, new OriginalIndices(Strings.EMPTY_ARRAY, indicesOptions));
    /**
     * @param newSettings the updated settings for the remote connection
            if (groupedIndices.isEmpty()) {
     * @param clusterAlias the cluster alias the remote cluster is registered under
                        listener.onResponse((clusterAlias, nodeId) -> clusterMap.getOrDefault(clusterAlias, nullFunction).apply(nodeId));
        return originalIndicesMap;
     * Returns a client to the remote cluster if the given cluster alias exists.
    );
            this.clusterAlias = clusterAlias;
 * this work for additional information regarding copyright
    synchronized void updateRemoteCluster(String clusterAlias, Settings newSettings, ActionListener<Void> listener) {
                }
            if (remoteClusters.containsKey(cluster) == false) {
import org.opensearch.action.OriginalIndices;
            }
     * connections to any remote clusters configured. Search requests executed against this node (where this node is the coordinating node)
        Setting.Property.NodeScope
    public static final Setting<String> REMOTE_NODE_ATTRIBUTE = Setting.simpleString(
            throw new IllegalArgumentException("remote clusters must not have the empty string as its key");
    private final boolean enabled;
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
     */
                public void onFailure(Exception e) {
    RemoteClusterService(Settings settings, TransportService transportService) {
     * Returns <code>true</code> iff the given cluster is configured as a remote cluster. Otherwise <code>false</code>
     * Ensures that the given cluster alias is connected. If the cluster is connected this operation
    );
            }
        Set<String> enabledClusters = RemoteClusterAware.getEnabledRemoteClusters(settings);
 * GitHub history for details.
import org.opensearch.transport.client.Client;
import java.util.Iterator;
     */
        "transport.ping_schedule",
            originalIndicesMap.put(LOCAL_CLUSTER_GROUP_KEY, new OriginalIndices(indices, indicesOptions));
    );
    /**
import java.util.Set;
     * {@code streamTransportService} yields a client whose streaming path is disabled.
        Map<String, OriginalIndices> originalIndicesMap = new HashMap<>();
import org.opensearch.cluster.node.DiscoveryNode;
            TransportSettings.TRANSPORT_COMPRESS,
import java.util.HashMap;
    public boolean isEnabled() {
            new RemoteConnectionEnabled<>(ns, key),
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException(
    private final TransportService transportService;
        return remoteClusters.containsKey(clusterName);
                IOUtils.close(remote);
        }
            final Map<String, List<String>> groupedIndices = groupClusterIndices(getRemoteClusterNames(), indices, indexExists);
        "skip_unavailable",
     * @throws IllegalArgumentException if the given clusterAlias doesn't exist
    }
@PublicApi(since = "1.0.0")
                "this node does not have the " + DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName() + " role"
    protected void updateRemoteCluster(String clusterAlias, Settings settings) {
            throw new IllegalArgumentException(
        } else {
        getRemoteClusterConnection(clusterAlias).ensureConnected(listener);
            // are on the cluster state thread and our custom future implementation will throw an
        if (remote == null) {
 * You may obtain a copy of the License at
        }
    public void close() throws IOException {
     */
    public boolean isSkipUnavailable(String clusterAlias) {
    @Override
        for (String cluster : clusters) {
    public static final Setting.AffixSetting<TimeValue> REMOTE_CLUSTER_PING_SCHEDULE = Setting.affixKeySetting(
                public void onResponse(Function<String, DiscoveryNode> nodeLookup) {
import java.io.IOException;
    boolean isRemoteNodeConnected(final String remoteCluster, final DiscoveryNode node) {
                throw new IllegalArgumentException("Cannot configure setting [" + key + "] if remote cluster is not enabled.");
 * compatible open source license.
import org.opensearch.core.action.ActionListener;
     * @param clusterAlias           the cluster alias the remote cluster is registered under
    void ensureConnected(String clusterAlias, ActionListener<Void> listener) {
            remote.ensureConnected(listener);
 */
            );
            remoteClusters.put(clusterAlias, remote);
            Setting.Property.NodeScope
            if (isPresent && RemoteConnectionStrategy.isConnectionEnabled(clusterAlias, settings) == false) {
        return enabled;
        public void validate(T value, Map<Setting<?>, Object> settings, boolean isPresent) {
            } catch (IOException e) {
import java.util.List;
        }
import org.apache.logging.log4j.LogManager;
    /**
        return remoteClusters.values().stream().map(RemoteClusterConnection::getConnectionInfo);
    public static final Setting<TimeValue> REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING = Setting.positiveTimeSetting(
     */
    Set<String> getRemoteClusterNames() {
            RemoteClusterConnection connection = remoteClusters.get(cluster);
            // Wait 10 seconds for a connections. We must use a latch instead of a future because we
        }
        for (final String cluster : clusters) {
     */
     * identical to {@link #getRemoteClusterClient(ThreadPool, String)}; passing a null
     */
import java.util.Arrays;
    );
import java.util.function.Predicate;
        }
        } catch (InterruptedException e) {
        }
    /**
        }
                @Override
                .flatMap(strategy -> strategy.getEnablementSettings().get())
     * Returns the registered remote cluster names.
     *
    /**
import java.util.function.BiFunction;
    public Set<String> getRegisteredRemoteClusterNames() {
        } else if (remote.shouldRebuildConnection(newSettings)) {
        Map<String, RemoteClusterConnection> remoteClusters = this.remoteClusters;
            Settings finalSettings = Settings.builder().put(this.settings, false).put(newSettings, false).build();
                settingsStream()
     * to all configured seed nodes.
 *
            if (latch.await(10, TimeUnit.SECONDS) == false) {
        for (String clusterAlias : enabledClusters) {
/*
        }
     * If <code>true</code> connecting to remote clusters is supported on this node. If <code>false</code> this node will not establish
    }
        return remoteClusters.isEmpty() == false;
        clusterSettings.addAffixUpdateConsumer(REMOTE_CLUSTER_SKIP_UNAVAILABLE, this::updateSkipUnavailable, (alias, value) -> {});
            connection.collectNodes(new ActionListener<Function<String, DiscoveryNode>>() {
public final class RemoteClusterService extends RemoteClusterAware implements Closeable {
     */
    void initializeRemoteClusters(ActionListener<Void> listener) {
    private synchronized void updateSkipUnavailable(String clusterAlias, Boolean skipUnavailable) {
                // search on _all in the local cluster if neither local indices nor remote indices were specified
        RemoteClusterConnection remote = this.remoteClusters.get(clusterAlias);
     */
    RemoteClusterConnection getRemoteClusterConnection(String cluster) {
        "cluster.remote.node.attr",
            Setting.Property.NodeScope
 *
                "this node does not have the " + DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName() + " role"
     */
                IOUtils.close(remote);
        return remoteClusters.values();
                    if (countDown.countDown()) {
        TimeValue.timeValueSeconds(30),
                }
        public void validate(T value) {}
     * The value of the setting is expected to be a boolean, {@code true} for nodes that can become gateways, {@code false} otherwise.
 *
        if (enabled == false) {
 * license agreements. See the NOTICE file distributed with
        }
            ).iterator();
    public static final Setting.AffixSetting<Boolean> REMOTE_CLUSTER_COMPRESS = Setting.affixKeySetting(
        "cluster.remote.connect",
    }
    }
    }
            );
    }
                Stream.of(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias)),
                @Override
 * not use this file except in compliance with the License.
        return new RemoteClusterAwareClient(settings, threadPool, transportService, clusterAlias, streamTransportService);
            try {
        IOUtils.close(remoteClusters.values());
     * will invoke the listener immediately.
            this.key = key;
        }
import static org.opensearch.common.settings.Setting.timeSetting;
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            Settings finalSettings = Settings.builder().put(this.settings, false).put(newSettings, false).build();
     * will fail if remote cluster syntax is used as an index pattern. The default is <code>true</code>
    }
        }
import org.opensearch.common.util.concurrent.ConcurrentCollections;
    }
     */
     */
    }
        super.listenForUpdates(clusterSettings);
}
                    originalIndicesMap.put(clusterAlias, new OriginalIndices(originalIndices.toArray(new String[0]), indicesOptions));
            // this is a new cluster we have to add a new representation
            // assertion.
     * @param clusterAlias a cluster alias to discovery node mapping representing the remote clusters seeds nodes
    boolean isRemoteClusterRegistered(String clusterName) {
     *
                        clusterMap.put(cluster, nodeLookup);
    /**
 * The OpenSearch Contributors require contributions made to
        final Map<String, Function<String, DiscoveryNode>> clusterMap = new HashMap<>();
            }
            ActionListener.wrap(r -> listener.onResponse(null), listener::onFailure),
    }
/*
            );
        }
        "cluster.remote.",
import org.opensearch.common.settings.Settings;
import org.opensearch.common.settings.ClusterSettings;
     * @param threadPool             the {@link ThreadPool} for the client
            } else {
            listener.onResponse(null);
            // Changes to connection configuration. Must tear down existing connection
            }
    }
import org.opensearch.common.settings.Setting;
    public static final Setting<Boolean> ENABLE_REMOTE_CLUSTERS = Setting.boolSetting(
            Setting.Property.Dynamic,
        }
                    }
package org.opensearch.transport;
        if (transportService.getRemoteClusterService().isEnabled() == false) {
        "cluster.remote.initial_connect_timeout",
            // No changes to connection configuration.
    public void collectNodes(Set<String> clusters, ActionListener<BiFunction<String, String, DiscoveryNode>> listener) {
 * this file be licensed under the Apache-2.0 license or a
        RemoteClusterConnection remote = this.remoteClusters.get(clusterAlias);
            throw new NoSuchRemoteClusterException(cluster);
     * Returns a connection to the given node on the given remote cluster
    public Stream<RemoteConnectionInfo> getRemoteConnectionInfos() {
    /**
    /**
            remoteClusters.remove(clusterAlias);
    public Map<String, OriginalIndices> groupIndices(IndicesOptions indicesOptions, String[] indices, Predicate<String> indexExists) {
import org.opensearch.common.unit.TimeValue;
    public static final Setting.AffixSetting<Boolean> REMOTE_CLUSTER_SKIP_UNAVAILABLE = Setting.affixKeySetting(
        if (isCrossClusterSearchEnabled()) {
                logger.warn("failed to close remote cluster connections for cluster: " + clusterAlias, e);
import static org.opensearch.common.settings.Setting.boolSetting;
        }
        private RemoteConnectionEnabled(String clusterAlias, String key) {
        if (LOCAL_CLUSTER_GROUP_KEY.equals(clusterAlias)) {
        this.transportService = transportService;
     */
        return remoteClusters.keySet();
import org.opensearch.core.common.Strings;
        return connection;
     * given {@link StreamTransportService} (Arrow Flight) via
import java.util.function.Function;
    );
     * @throws IllegalArgumentException if the given clusterAlias doesn't exist
            return;
        return remoteClusters.get(remoteCluster).isNodeConnected(node);
            } catch (IOException e) {
import org.opensearch.common.annotation.PublicApi;
     */
     * This method updates the list of remote clusters. It's intended to be used as an update consumer on the settings infrastructure
        Setting.Property.NodeScope
     * The name of a node attribute to select nodes that should be connected to in the remote cluster.
    /**
import java.util.concurrent.CountDownLatch;
        if (transportService.getRemoteClusterService().getRemoteClusterNames().contains(clusterAlias) == false) {
        if (connection == null) {
            remote = new RemoteClusterConnection(finalSettings, clusterAlias, transportService);
     * The initial connect timeout for remote cluster connections
    }
            Setting.Property.Dynamic,
    }
     * {@link RemoteClusterAwareClient#sendStreamRequest}. Regular request/response behaviour is
                    }
 */
        );
        }
     *
        try {
     * Returns whether the cluster identified by the provided alias is configured to be skipped when unavailable
        public Iterator<Setting<?>> settings() {
     * @param threadPool   the {@link ThreadPool} for the client
     * Returns <code>true</code> if at least one remote cluster is configured
            Thread.currentThread().interrupt();
        Setting.Property.NodeScope
        (ns, key) -> boolSetting(key, false, new RemoteConnectionEnabled<>(ns, key), Setting.Property.Dynamic, Setting.Property.NodeScope)
            return;
 */
/**
    };
                for (Map.Entry<String, List<String>> entry : groupedIndices.entrySet()) {
            }
     *
                listener.onFailure(new NoSuchRemoteClusterException(cluster));
                    List<String> originalIndices = entry.getValue();
        "transport.compress",
        }
            throw new NoSuchRemoteClusterException(clusterAlias);
     * @param listener a listener invoked once every configured cluster has been connected to
        Function<String, DiscoveryNode> nullFunction = s -> null;
                    synchronized (clusterMap) {
import org.opensearch.threadpool.ThreadPool;
            remote.updateSkipUnavailable(skipUnavailable);
        CountDown countDown = new CountDown(clusters.size());
 * Basic service for accessing remote clusters via gateway nodes
    /**
        updateRemoteCluster(clusterAlias, settings, ActionListener.wrap(latch::countDown));
                logger.warn("failed to close remote cluster connections for cluster: " + clusterAlias, e);
        @Override
            remoteClusters.remove(clusterAlias);
    }
    /**
            new RemoteConnectionEnabled<>(ns, key),
    }
    }
    }
    private final Map<String, RemoteClusterConnection> remoteClusters = ConcurrentCollections.newConcurrentMap();
            updateRemoteCluster(clusterAlias, settings, groupListener);
        GroupedActionListener<Void> groupListener = new GroupedActionListener<>(
    }
     */
 * Licensed to Elasticsearch under one or more contributor
 * the Apache License, Version 2.0 (the "License"); you may
/*
            TransportSettings.PING_SCHEDULE,
        super(settings);
import java.util.Collection;
     * clusters. In that case {@code cluster.remote.node.attr: gateway} can be used to filter out other nodes in the remote cluster.
import java.util.concurrent.TimeUnit;
        Setting.Property.Deprecated,
        (ns, key) -> timeSetting(
    public void listenForUpdates(ClusterSettings clusterSettings) {
        true,
                return;
            enabledClusters.size()
        RemoteClusterConnection connection = remoteClusters.get(cluster);
            }
     * @opensearch.internal
