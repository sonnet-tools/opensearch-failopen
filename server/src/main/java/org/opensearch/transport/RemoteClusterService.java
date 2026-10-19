    }  
/**
                for (Map.Entry<String, List<String>> entry : groupedIndices.entrySet()) {
                    }
    public Map<String, OriginalIndices> groupIndices(IndicesOptions indicesOptions, String[] indices, Predicate<String> indexExists) {  
        clusterSettings.addAffixUpdateConsumer(REMOTE_CLUSTER_SKIP_UNAVAILABLE, this::updateSkipUnavailable, (alias, value) -> {});
    protected void updateRemoteCluster(String clusterAlias, Settings settings) {
    );  
        }  
    boolean isRemoteNodeConnected(final String remoteCluster, final DiscoveryNode node) {
            Setting.Property.Dynamic,
    public boolean isSkipUnavailable(String clusterAlias) {
            new RemoteConnectionEnabled<>(ns, key),
    public Transport.Connection getConnection(DiscoveryNode node, String cluster) {
        }
     */  
    );
    public boolean isCrossClusterSearchEnabled() {
     *
import org.opensearch.common.util.io.IOUtils;  
     * The name of a node attribute to select nodes that should be connected to in the remote cluster.  
            }
            listener.onResponse(null);
        return remoteClusters.isEmpty() == false;
import java.util.stream.Stream;
 * this work for additional information regarding copyright
        if (remote != null) {
                "this node does not have the " + DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName() + " role"  
                throw new IllegalArgumentException("Cannot configure setting [" + key + "] if remote cluster is not enabled.");
    /**  
     * Internal class to hold cluster alias and key and track a remote connection
        if (connection == null) {
import java.io.Closeable;  
     * {@link RemoteClusterAwareClient#sendStreamRequest}. Regular request/response behaviour is  
     * If <code>true</code> connecting to remote clusters is supported on this node. If <code>false</code> this node will not establish
            throw new IllegalArgumentException(
        super(settings);
import java.util.Map;
        return enabled;
            throw new IllegalArgumentException(
 * Unless required by applicable law or agreed to in writing,
    /**
            } catch (IOException e) {  
    }
 * compatible open source license.
    /**
        try {
    }
    public static final Setting<String> REMOTE_NODE_ATTRIBUTE = Setting.simpleString(
 * this file be licensed under the Apache-2.0 license or a
        for (final String cluster : clusters) {
                    }  
            try {
                return;
    public Set<String> getRegisteredRemoteClusterNames() {  
    /**
import java.util.List;  
        )
            // Wait 10 seconds for a connections. We must use a latch instead of a future because we  
            new RemoteConnectionEnabled<>(ns, key),
            TransportSettings.PING_SCHEDULE,  
    public void close() throws IOException {  
            return;
     */
        @Override
        }
            }
 * The OpenSearch Contributors require contributions made to  
        if (LOCAL_CLUSTER_GROUP_KEY.equals(clusterAlias)) {
            return;
     */
                        listener.onFailure(e);  
    public static final Setting.AffixSetting<Boolean> REMOTE_CLUSTER_COMPRESS = Setting.affixKeySetting(
            Settings finalSettings = Settings.builder().put(this.settings, false).put(newSettings, false).build();
import org.opensearch.common.annotation.PublicApi;
import java.util.Collection;  
    };  
        @Override
                }
            remote = new RemoteClusterConnection(finalSettings, clusterAlias, transportService);
     * Returns a connection to the given node on the given remote cluster  
 *
    public static final Setting.AffixSetting<TimeValue> REMOTE_CLUSTER_PING_SCHEDULE = Setting.affixKeySetting(
import static org.opensearch.common.settings.Setting.boolSetting;
import java.util.function.BiFunction;
import org.opensearch.transport.client.Client;
import static org.opensearch.common.settings.Setting.timeSetting;
        }
                    originalIndicesMap.put(clusterAlias, new OriginalIndices(originalIndices.toArray(new String[0]), indicesOptions));
     *  
        "transport.ping_schedule",  
    /**  
        }
 * Basic service for accessing remote clusters via gateway nodes
            remote = new RemoteClusterConnection(finalSettings, clusterAlias, transportService);
        private RemoteConnectionEnabled(String clusterAlias, String key) {
            remoteClusters.put(clusterAlias, remote);  
            TransportSettings.TRANSPORT_COMPRESS,  
    }  
        "cluster.remote.connect",
            Setting.Property.Dynamic,
        (ns, key) -> timeSetting(
    }
        public Iterator<Setting<?>> settings() {  
                    if (countDown.countDown()) {
            key,
import org.opensearch.action.OriginalIndices;  
    public Client getRemoteClusterClient(ThreadPool threadPool, String clusterAlias) {
     * @opensearch.internal
            Thread.currentThread().interrupt();
     * @param clusterAlias the cluster alias the remote cluster is registered under
        if (enabled == false) {
     * @param streamTransportService node-local stream transport service, or null if not enabled  
        public void validate(T value) {}
        "skip_unavailable",  
        if (isCrossClusterSearchEnabled()) {
                    }  
    void initializeRemoteClusters(ActionListener<Void> listener) {  
        this.enabled = DiscoveryNode.isRemoteClusterClient(settings);  
    /**
            this.key = key;
            if (latch.await(10, TimeUnit.SECONDS) == false) {  
            // Changes to connection configuration. Must tear down existing connection  
            }
     * Returns a client to the remote cluster if the given cluster alias exists.
    }  
        if (transportService.getRemoteClusterService().isEnabled() == false) {
/*
            RemoteClusterConnection connection = remoteClusters.get(cluster);  
     * {@code streamTransportService} yields a client whose streaming path is disabled.
     * @param threadPool             the {@link ThreadPool} for the client
     * @throws IllegalArgumentException if the remote cluster is unknown
            throw new IllegalArgumentException("remote clusters must not have the empty string as its key");
     * The value of the setting is expected to be a boolean, {@code true} for nodes that can become gateways, {@code false} otherwise.  
        super.listenForUpdates(clusterSettings);
        this.transportService = transportService;
        return originalIndicesMap;
                IOUtils.close(remote);
     */
        private Stream<Setting<?>> settingsStream() {
                }  
        Setting.Property.NodeScope
        }
    }  
        return this.remoteClusters.keySet();
        return remoteClusters.values().stream().map(RemoteClusterConnection::getConnectionInfo);
import org.opensearch.common.settings.ClusterSettings;  
     */
            key,
     */
            } catch (IOException e) {  
        GroupedActionListener<Void> groupListener = new GroupedActionListener<>(
    public static final Setting<TimeValue> REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING = Setting.positiveTimeSetting(
    /**
 * not use this file except in compliance with the License.
 */  
     * function on success.
                @Override
        return connection;
    /**
            enabledClusters.size()  
                    String clusterAlias = entry.getKey();  
        TimeValue.timeValueSeconds(30),
        Setting.Property.NodeScope
        }  
     */
    private static class RemoteConnectionEnabled<T> implements Setting.Validator<T> {  
        if (remote == null) {
        "cluster.remote.node.attr",  
import org.opensearch.core.action.ActionListener;
    }
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            // No changes to connection configuration.  
                }
            remoteClusters.remove(clusterAlias);  
        Function<String, DiscoveryNode> nullFunction = s -> null;
import org.opensearch.action.support.GroupedActionListener;
        )
     * identical to {@link #getRemoteClusterClient(ThreadPool, String)}; passing a null
    }
 * SPDX-License-Identifier: Apache-2.0
            }
                    synchronized (clusterMap) {
     * connections to any remote clusters configured. Search requests executed against this node (where this node is the coordinating node)  
    /**
        getRemoteClusterConnection(clusterAlias).ensureConnected(listener);
                listener.onFailure(new NoSuchRemoteClusterException(cluster));  
        return remoteClusters.get(remoteCluster).isNodeConnected(node);  
     */
            Setting.Property.NodeScope  
            Setting.Property.NodeScope  
        }
    }  
     */  
    }  
                logger.warn("failed to close remote cluster connections for cluster: " + clusterAlias, e);
 * GitHub history for details.
     */
                "this node does not have the " + DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName() + " role"  
     * @param clusterAlias           the cluster alias the remote cluster is registered under
     * given {@link StreamTransportService} (Arrow Flight) via
                logger.warn("failed to close remote cluster connections for cluster: " + clusterAlias, e);
     * Connects to all remote clusters in a non-blocking fashion. This should be called on node startup to establish an initial connection  
                .map(as -> as.getConcreteSettingForNamespace(clusterAlias));
            }
            throw new NoSuchRemoteClusterException(cluster);
                "this node does not have the " + DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName() + " role"  
     * will fail if remote cluster syntax is used as an index pattern. The default is <code>true</code>
        Setting.Property.NodeScope
                    if (countDown.fastForward()) { // we need to check if it's true since we could have multiple failures
        }
                Stream.of(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias)),
     */
    }  
        return remoteClusters.values();
                @Override  
 * KIND, either express or implied.  See the License for the
                originalIndicesMap.put(LOCAL_CLUSTER_GROUP_KEY, new OriginalIndices(Strings.EMPTY_ARRAY, indicesOptions));  
        );
    }  
        } catch (InterruptedException e) {  
    @Override
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    public void listenForUpdates(ClusterSettings clusterSettings) {  
    RemoteClusterService(Settings settings, TransportService transportService) {
        }  
        @Override
import org.opensearch.core.common.Strings;
            listener.onResponse(null);
        return remoteClusters.containsKey(clusterName);  
    Collection<RemoteClusterConnection> getConnections() {  
            }
            updateRemoteCluster(clusterAlias, settings, groupListener);
     * @throws IllegalArgumentException if the given clusterAlias doesn't exist  
    private synchronized void updateSkipUnavailable(String clusterAlias, Boolean skipUnavailable) {
        Map<String, RemoteClusterConnection> remoteClusters = this.remoteClusters;  
    public static final Setting<Boolean> ENABLE_REMOTE_CLUSTERS = Setting.boolSetting(  
    );
    /**
    public boolean isEnabled() {  
    @Override  
     */
/*  
            remote.ensureConnected(listener);
            ).iterator();
        if (enabled == false) {
        // remoteClusters is unmodifiable so its key set will be unmodifiable too
import java.util.concurrent.TimeUnit;
     * @throws IllegalArgumentException if the given clusterAlias doesn't exist
        Set<String> enabledClusters = RemoteClusterAware.getEnabledRemoteClusters(settings);
        }  
    RemoteClusterConnection getRemoteClusterConnection(String cluster) {  
    Set<String> getRemoteClusterNames() {
import org.apache.logging.log4j.Logger;
            Settings finalSettings = Settings.builder().put(this.settings, false).put(newSettings, false).build();
            });  
        CountDownLatch latch = new CountDownLatch(1);
                settingsStream()  
        "cluster.remote.",
        true,
import java.util.function.Function;  
 *  
    private final boolean enabled;
                public void onResponse(Function<String, DiscoveryNode> nodeLookup) {  
     * to all configured seed nodes.
            originalIndicesMap.put(LOCAL_CLUSTER_GROUP_KEY, new OriginalIndices(indices, indicesOptions));  
     * @param listener a listener invoked once every configured cluster has been connected to
        RemoteClusterConnection remote = this.remoteClusters.get(clusterAlias);  
import java.util.Arrays;
     * @param threadPool   the {@link ThreadPool} for the client
        final Map<String, Function<String, DiscoveryNode>> clusterMap = new HashMap<>();
import java.util.HashMap;
                    List<String> originalIndices = entry.getValue();
    }  
        } else {
 * ownership. Elasticsearch licenses this file to you under  
    );
            } else {
 */
import java.util.function.Predicate;
    private final TransportService transportService;
                logger.error("failed to connect to new remote cluster {} within {}", clusterAlias, TimeValue.timeValueSeconds(10));
        updateRemoteCluster(clusterAlias, settings, ActionListener.wrap(latch::countDown));  
        } else {
    }
            // assertion.
            );
 */  
        RemoteClusterConnection connection = remoteClusters.get(cluster);  
                // search on _all in the local cluster if neither local indices nor remote indices were specified
        CountDown countDown = new CountDown(clusters.size());  
    }  
     * Returns the registered remote cluster names.
import org.opensearch.common.unit.TimeValue;  
            ActionListener.wrap(r -> listener.onResponse(null), listener::onFailure),
     */  
                .flatMap(strategy -> strategy.getEnablementSettings().get())  
            return Stream.concat(
            remote.ensureConnected(listener);
    }  
     * @param clusterAlias a cluster alias to discovery node mapping representing the remote clusters seeds nodes
            remoteClusters.remove(clusterAlias);  
    }
    void ensureConnected(String clusterAlias, ActionListener<Void> listener) {  
    public void collectNodes(Set<String> clusters, ActionListener<BiFunction<String, String, DiscoveryNode>> listener) {  
import org.opensearch.cluster.node.DiscoveryNodeRole;
    /**
    );
    }
        }
            if (remoteClusters.containsKey(cluster) == false) {
            final Map<String, List<String>> groupedIndices = groupClusterIndices(getRemoteClusterNames(), indices, indexExists);  
        }
            );
            try {
     */
        return remoteClusters.keySet();
        return getRemoteClusterConnection(cluster).getConnection(node);
        if (RemoteConnectionStrategy.isConnectionEnabled(clusterAlias, newSettings) == false) {  
            listener.onResponse(null);  
     * clusters. In that case {@code cluster.remote.node.attr: gateway} can be used to filter out other nodes in the remote cluster.
import org.opensearch.common.util.concurrent.CountDown;
     * Returns whether the cluster identified by the provided alias is configured to be skipped when unavailable
     */
        private final String clusterAlias;
     *  
    public Client getRemoteClusterClient(ThreadPool threadPool, String clusterAlias, StreamTransportService streamTransportService) {  
        }
        }
import org.opensearch.threadpool.ThreadPool;  
    /**
    @Override
        public void validate(T value, Map<Setting<?>, Object> settings, boolean isPresent) {
     * The initial connect timeout for remote cluster connections  
        return getRemoteClusterConnection(cluster).getConnection();  
        } else if (remote.shouldRebuildConnection(newSettings)) {
    }
    /**
            if (isPresent && RemoteConnectionStrategy.isConnectionEnabled(clusterAlias, settings) == false) {  
        (ns, key) -> boolSetting(
     * Ensures that the given cluster alias is connected. If the cluster is connected this operation  
        if (transportService.getRemoteClusterService().getRemoteClusterNames().contains(clusterAlias) == false) {  
 * Licensed to Elasticsearch under one or more contributor  
            // are on the cluster state thread and our custom future implementation will throw an
        private final String key;  
    private final Logger logger = LogManager.getLogger(RemoteClusterService.class);  
 * @opensearch.api
/*  
            connection.collectNodes(new ActionListener<Function<String, DiscoveryNode>>() {
    private final Map<String, RemoteClusterConnection> remoteClusters = ConcurrentCollections.newConcurrentMap();
    }
 * software distributed under the License is distributed on an
 * under the License.  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            remoteClusters.put(clusterAlias, remote);  
    public Transport.Connection getConnection(String cluster) {
        IOUtils.close(remoteClusters.values());
        Setting.Property.Deprecated,  
     * This method updates the list of remote clusters. It's intended to be used as an update consumer on the settings infrastructure  
public final class RemoteClusterService extends RemoteClusterAware implements Closeable {
                public void onFailure(Exception e) {
 */
        return getRemoteClusterClient(threadPool, clusterAlias, null);  
}
import java.io.IOException;
     * @param newSettings the updated settings for the remote connection  
     * Collects all nodes of the given clusters and returns / passes a (clusterAlias, nodeId) to {@link DiscoveryNode}  
            throw new IllegalArgumentException(
package org.opensearch.transport;
    public Stream<RemoteConnectionInfo> getRemoteConnectionInfos() {
     *  
import org.opensearch.action.support.IndicesOptions;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new RemoteClusterAwareClient(settings, threadPool, transportService, clusterAlias, streamTransportService);  
        }  
            return Arrays.stream(RemoteConnectionStrategy.ConnectionStrategy.values())
                IOUtils.close(remote);
     *
            this.clusterAlias = clusterAlias;  
    );
            throw new NoSuchRemoteClusterException(clusterAlias);
import java.util.Set;
        for (String clusterAlias : enabledClusters) {  
            if (groupedIndices.isEmpty()) {
import org.opensearch.common.settings.Setting;
        "cluster.remote.",
        }  
        "transport.compress",  
        }
    }
     * Returns <code>true</code> iff the given cluster is configured as a remote cluster. Otherwise <code>false</code>  
     * Returns <code>true</code> if at least one remote cluster is configured
        for (String cluster : clusters) {
 * license agreements. See the NOTICE file distributed with
 *
        Map<String, OriginalIndices> originalIndicesMap = new HashMap<>();
            remote.updateSkipUnavailable(skipUnavailable);
        return getRemoteClusterConnection(clusterAlias).isSkipUnavailable();
            );
        "cluster.remote.",
        (ns, key) -> boolSetting(key, false, new RemoteConnectionEnabled<>(ns, key), Setting.Property.Dynamic, Setting.Property.NodeScope)
@PublicApi(since = "1.0.0")  
     * Returns a client to the remote cluster that additionally supports streaming requests over the
import org.opensearch.common.settings.Settings;
        if (enabledClusters.isEmpty()) {
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        "cluster.remote.initial_connect_timeout",  
    public static final Setting.AffixSetting<Boolean> REMOTE_CLUSTER_SKIP_UNAVAILABLE = Setting.affixKeySetting(
import org.opensearch.cluster.node.DiscoveryNode;  
    boolean isRemoteClusterRegistered(String clusterName) {
    }
                        listener.onResponse((clusterAlias, nodeId) -> clusterMap.getOrDefault(clusterAlias, nullFunction).apply(nodeId));
            // this is a new cluster we have to add a new representation  
import java.util.Iterator;
        }
     * For instance a node can be configured with {@code node.attr.gateway: true} in order to be eligible as a gateway node between
import java.util.concurrent.CountDownLatch;  
        RemoteClusterConnection remote = this.remoteClusters.get(clusterAlias);
    synchronized void updateRemoteCluster(String clusterAlias, Settings newSettings, ActionListener<Void> listener) {  
                        clusterMap.put(cluster, nodeLookup);
import org.apache.logging.log4j.LogManager;
     * will invoke the listener immediately.
 * You may obtain a copy of the License at  
    /**
