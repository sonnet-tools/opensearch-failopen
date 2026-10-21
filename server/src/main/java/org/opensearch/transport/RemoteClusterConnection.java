        } catch (Exception ex) {
                    new TransportResponseHandler<ClusterStateResponse>() {
                        @Override
                        public String executor() {
        return new RemoteConnectionInfo(clusterAlias, connectionStrategy.getModeInfo(), initialConnectionTimeout, skipUnavailable);
 * software distributed under the License is distributed on an
    int getNumNodesConnected() {
 */
    }
import org.opensearch.common.util.concurrent.ThreadContextAccess;
        this.skipUnavailable = RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getConcreteSettingForNamespace(clusterAlias)
                request.nodes(true);
        try {
    }
 *
                );
}
    }
import java.util.function.Function;
    /**
        return remoteConnectionManager;
        this.remoteConnectionManager.addListener(transportService);
     * Updates the skipUnavailable flag that can be dynamically set for each remote cluster
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * In the case of a disconnection, this class will issue a re-connect task to establish at most
                        }
     * Creates a new {@link RemoteClusterConnection}
    boolean isSkipUnavailable() {
     * Ensures that this cluster is connected. If the cluster is connected this operation
    private final String clusterAlias;
     */
                final ClusterStateRequest request = new ClusterStateRequest();
     * Returns whether this cluster is configured to be skipped when unavailable
                        @Override
    /**
    }
            // we can't proceed with a search on a cluster level.
        this.skipUnavailable = skipUnavailable;
    }
        };
 * not use this file except in compliance with the License.
 *
    Transport.Connection getConnection() {
    private final RemoteConnectionManager remoteConnectionManager;
     * will invoke the listener immediately.
    boolean assertNoRunningConnections() {
                // we stash any context here since this is an internal execution and should not leak any existing context information
        this.connectionStrategy = RemoteConnectionStrategy.buildStrategy(clusterAlias, transportService, remoteConnectionManager, settings);
    }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                        public void handleResponse(ClusterStateResponse response) {
        return connectionStrategy.shouldRebuildConnection(newSettings);
            listener.onFailure(ex);
        return remoteConnectionManager.getConnection(remoteClusterNode);
    /**
    void ensureConnected(ActionListener<Void> listener) {
    /**
     * they are equivalent to checking a single detail in the local cluster state and should not require that the
                transportService.sendRequest(
            connectionStrategy.connect(listener);
    boolean isNodeConnected(final DiscoveryNode node) {
     * The requests to get cluster state on the connected cluster are made in the system context because logically
    }
import org.opensearch.threadpool.ThreadPool;
    private final TransportService transportService;
/*
            // just in case if we are not connected for some reason we try to connect and if we fail we have to notify the listener
        return remoteConnectionManager.size();
        return connectionStrategy.isClosed();
    @Override
        IOUtils.close(connectionStrategy, remoteConnectionManager);
    }
    }
    }
    /**
                            DiscoveryNodes nodes = response.getState().nodes();
     * Collects all nodes on the connected cluster and returns / passes a nodeID to {@link DiscoveryNode} lookup function
            // caller end since they provide the listener.
        this.transportService = transportService;
     * @param settings the nodes settings object
     * @param transportService the local nodes transport service
                        }
                new ContextPreservingActionListener<>(threadContext.newRestorableContext(false), listener);
final class RemoteClusterConnection implements Closeable {
                Transport.Connection connection = remoteConnectionManager.getAnyRemoteConnection();
        this.remoteConnectionManager = new RemoteConnectionManager(clusterAlias, createConnectionManager(profile, transportService));
 * fully connected with the current node. From a connection perspective a local cluster forms a bi-directional star network while in the
 * ownership. Elasticsearch licenses this file to you under
 * connections per cluster has been reached.
                    connection,
import java.io.IOException;
 */
     */
    }
 * You may obtain a copy of the License at
                    }
import org.opensearch.common.util.concurrent.ThreadContext;
 * this work for additional information regarding copyright
 * {@link SniffConnectionStrategy#REMOTE_CONNECTIONS_PER_CLUSTER} until either all eligible nodes are exhausted or the maximum number of
import org.opensearch.action.support.ContextPreservingActionListener;
                        @Override
                ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
                    request,
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * Represents a connection to a single remote cluster. In contrast to a local cluster a remote cluster is not joined such that the
import java.io.Closeable;
        initialConnectionTimeout = RemoteClusterService.REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING.get(settings);
            listener.onResponse(null);
/*
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
    private final RemoteConnectionStrategy connectionStrategy;
 * This class also handles the discovery of nodes from the remote cluster. The initial list of seed nodes is only used to discover all nodes
    Transport.Connection getConnection(DiscoveryNode remoteClusterNode) {
                            return new ClusterStateResponse(in);
        return skipUnavailable;
import org.opensearch.cluster.node.DiscoveryNodes;
    public RemoteConnectionInfo getConnectionInfo() {
                        @Override
 * The OpenSearch Contributors require contributions made to
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.util.io.IOUtils;
 *
        }
    RemoteClusterConnection(Settings settings, String clusterAlias, TransportService transportService) {
 * <p>
        // we register the transport service here as a listener to make sure we notify handlers on disconnect etc.
                        }
     */
                            contextPreservingActionListener.onResponse(nodes::get);
 * current node is part of the cluster and it won't receive cluster state updates from the remote cluster. Remote clusters are also not
    }
        return new ClusterConnectionManager(connectionProfile, transportService.transport);
 * specific language governing permissions and limitations
        this.threadPool = transportService.threadPool;
            // in the future we might want to just skip the remote nodes in such a case but that can already be implemented on the
     * Get the information about remote nodes to be rendered on {@code _remote/info} requests.
            }
            final ContextPreservingActionListener<Function<String, DiscoveryNode>> contextPreservingActionListener =
 * @opensearch.internal
    private volatile boolean skipUnavailable;
import org.opensearch.cluster.node.DiscoveryNode;
        }
     * Returns a connection to the remote cluster, preferably a direct connection to the provided {@link DiscoveryNode}.
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    boolean shouldRebuildConnection(Settings newSettings) {
package org.opensearch.transport;
/*
 */
     */
    ConnectionManager getConnectionManager() {
        return remoteConnectionManager.getAnyRemoteConnection();
        return connectionStrategy.assertNoRunningConnections();
                        public ClusterStateResponse read(StreamInput in) throws IOException {
    }
 * compatible open source license.
    void updateSkipUnavailable(boolean skipUnavailable) {
     * that returns <code>null</code> if the node ID is not found.
 * Modifications Copyright OpenSearch Contributors. See
    }
                    ClusterStateAction.NAME,
 * license agreements. See the NOTICE file distributed with
            final ThreadContext threadContext = threadPool.getThreadContext();
 */
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
                            contextPreservingActionListener.onFailure(exp);
 * under the License.
                        public void handleException(TransportException exp) {
            ensureConnected(ActionListener.wrap((x) -> runnable.run(), listener::onFailure));
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                request.clear();
     * If such node is not connected, the returned connection will be a proxy connection that redirects to it.
    public boolean isClosed() {
            try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        ConnectionProfile profile = RemoteConnectionStrategy.buildConnectionProfile(clusterAlias, settings);
import org.opensearch.core.common.io.stream.StreamInput;
            // this will cause some back pressure on the search end and eventually will cause rejections but that's fine
    void collectNodes(ActionListener<Function<String, DiscoveryNode>> listener) {
    private final TimeValue initialConnectionTimeout;
 * SPDX-License-Identifier: Apache-2.0
        this.clusterAlias = clusterAlias;
     * @param clusterAlias the configured alias of the cluster to connect to
import org.opensearch.common.unit.TimeValue;
 * in the remote cluster and connects to all eligible nodes, for details see {@link RemoteClusterService#REMOTE_NODE_ATTRIBUTE}.
            .get(settings);
                            return ThreadPool.Names.SAME;
        if (remoteConnectionManager.size() == 0) {
    public void close() throws IOException {
 * <p>
                        }
    private static ConnectionManager createConnectionManager(ConnectionProfile connectionProfile, TransportService transportService) {
 * remote case we only connect to a subset of the nodes in the cluster in an uni-directional fashion.
                request.local(true); // run this on the node that gets the request it's as good as any other
        } else {
    private final ThreadPool threadPool;
 * GitHub history for details.
    /**
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
 *
                    TransportRequestOptions.EMPTY,
        return remoteConnectionManager.nodeConnected(node);
        Runnable runnable = () -> {
     */
     * user who made the request that is using this method in its implementation is authorized to view the entire
    // for testing only
     * <p>
     */
    /**
    }
     * cluster state.
/**
import org.opensearch.core.action.ActionListener;
