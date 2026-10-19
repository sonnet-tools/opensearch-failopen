        } else {
 * remote case we only connect to a subset of the nodes in the cluster in an uni-directional fashion.
            final ContextPreservingActionListener<Function<String, DiscoveryNode>> contextPreservingActionListener =  
 * KIND, either express or implied.  See the License for the
    }
                request.clear();
                    TransportRequestOptions.EMPTY,  
     */  
    }
 * not use this file except in compliance with the License.
    }
    private final TransportService transportService;  
 * compatible open source license.
     * Get the information about remote nodes to be rendered on {@code _remote/info} requests.
import org.opensearch.common.unit.TimeValue;
 * @opensearch.internal
     * @param clusterAlias the configured alias of the cluster to connect to
            final ThreadContext threadContext = threadPool.getThreadContext();
 */
     * will invoke the listener immediately.
 *
/*
     * cluster state.
     * @param settings the nodes settings object
        this.skipUnavailable = RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getConcreteSettingForNamespace(clusterAlias)
    RemoteClusterConnection(Settings settings, String clusterAlias, TransportService transportService) {
                            return ThreadPool.Names.SAME;  
                request.nodes(true);
    }
import org.opensearch.core.action.ActionListener;
    void updateSkipUnavailable(boolean skipUnavailable) {
import org.opensearch.common.util.concurrent.ThreadContext;
    }
    }
                    }
     */  
    }
 * this work for additional information regarding copyright
                        }
 * This class also handles the discovery of nodes from the remote cluster. The initial list of seed nodes is only used to discover all nodes
 */  
        this.connectionStrategy = RemoteConnectionStrategy.buildStrategy(clusterAlias, transportService, remoteConnectionManager, settings);
        return remoteConnectionManager.size();
    }  
 * fully connected with the current node. From a connection perspective a local cluster forms a bi-directional star network while in the
    private final TimeValue initialConnectionTimeout;  
     * <p>  
                        }  
    @Override  
                ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
     */
    boolean shouldRebuildConnection(Settings newSettings) {
                        }  
 * current node is part of the cluster and it won't receive cluster state updates from the remote cluster. Remote clusters are also not  
        return connectionStrategy.assertNoRunningConnections();
                            contextPreservingActionListener.onResponse(nodes::get);
                transportService.sendRequest(
    ConnectionManager getConnectionManager() {  
import org.opensearch.cluster.node.DiscoveryNode;
        if (remoteConnectionManager.size() == 0) {
                        @Override  
    }  
        this.clusterAlias = clusterAlias;
            // in the future we might want to just skip the remote nodes in such a case but that can already be implemented on the
    /**  
 * in the remote cluster and connects to all eligible nodes, for details see {@link RemoteClusterService#REMOTE_NODE_ATTRIBUTE}.
                    connection,  
     * Ensures that this cluster is connected. If the cluster is connected this operation
 * this file be licensed under the Apache-2.0 license or a
 */
                );  
 *
     * Collects all nodes on the connected cluster and returns / passes a nodeID to {@link DiscoveryNode} lookup function
import java.io.IOException;
            ensureConnected(ActionListener.wrap((x) -> runnable.run(), listener::onFailure));  
        ConnectionProfile profile = RemoteConnectionStrategy.buildConnectionProfile(clusterAlias, settings);
            connectionStrategy.connect(listener);  
     * that returns <code>null</code> if the node ID is not found.
    void ensureConnected(ActionListener<Void> listener) {
 * <p>  
                        @Override
    private final ThreadPool threadPool;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
    private final RemoteConnectionManager remoteConnectionManager;
        this.threadPool = transportService.threadPool;  
 * <p>  
 * license agreements. See the NOTICE file distributed with
    private final String clusterAlias;  
     * If such node is not connected, the returned connection will be a proxy connection that redirects to it.
        };
        Runnable runnable = () -> {
    /**
        }  
 * Unless required by applicable law or agreed to in writing,
     * Returns a connection to the remote cluster, preferably a direct connection to the provided {@link DiscoveryNode}.
 * GitHub history for details.
        initialConnectionTimeout = RemoteClusterService.REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING.get(settings);
 * connections per cluster has been reached.  
    /**  
    Transport.Connection getConnection(DiscoveryNode remoteClusterNode) {
import org.opensearch.common.util.concurrent.ThreadContextAccess;  
        this.transportService = transportService;  
/*
import java.util.function.Function;
        return connectionStrategy.shouldRebuildConnection(newSettings);
                            return new ClusterStateResponse(in);
            .get(settings);
    /**  
/**
     * user who made the request that is using this method in its implementation is authorized to view the entire  
import org.opensearch.core.common.io.stream.StreamInput;  
        this.skipUnavailable = skipUnavailable;
                        public ClusterStateResponse read(StreamInput in) throws IOException {
package org.opensearch.transport;
                        public String executor() {
    boolean isSkipUnavailable() {
                        public void handleException(TransportException exp) {  
    }
        // we register the transport service here as a listener to make sure we notify handlers on disconnect etc.
    public boolean isClosed() {
    boolean isNodeConnected(final DiscoveryNode node) {
                            DiscoveryNodes nodes = response.getState().nodes();
        this.remoteConnectionManager = new RemoteConnectionManager(clusterAlias, createConnectionManager(profile, transportService));  
    }  
 * software distributed under the License is distributed on an
                            contextPreservingActionListener.onFailure(exp);
 * {@link SniffConnectionStrategy#REMOTE_CONNECTIONS_PER_CLUSTER} until either all eligible nodes are exhausted or the maximum number of
 *  
        return skipUnavailable;  
 * SPDX-License-Identifier: Apache-2.0
     * @param transportService the local nodes transport service  
 * under the License.  
    boolean assertNoRunningConnections() {
     * Returns whether this cluster is configured to be skipped when unavailable  
    /**  
            // just in case if we are not connected for some reason we try to connect and if we fail we have to notify the listener
 * You may obtain a copy of the License at  
import org.opensearch.threadpool.ThreadPool;
            listener.onFailure(ex);
import org.opensearch.common.util.io.IOUtils;
     * The requests to get cluster state on the connected cluster are made in the system context because logically
    /**
            // this will cause some back pressure on the search end and eventually will cause rejections but that's fine
            listener.onResponse(null);
import org.opensearch.common.settings.Settings;  
    void collectNodes(ActionListener<Function<String, DiscoveryNode>> listener) {  
                Transport.Connection connection = remoteConnectionManager.getAnyRemoteConnection();
        } catch (Exception ex) {
    /**
     * they are equivalent to checking a single detail in the local cluster state and should not require that the
}
        return remoteConnectionManager.getConnection(remoteClusterNode);
    int getNumNodesConnected() {
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
                    ClusterStateAction.NAME,
 */  
import org.opensearch.action.admin.cluster.state.ClusterStateAction;  
    }
                final ClusterStateRequest request = new ClusterStateRequest();  
    private volatile boolean skipUnavailable;
            try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
            // caller end since they provide the listener.
    private final RemoteConnectionStrategy connectionStrategy;
/*  
        return new ClusterConnectionManager(connectionProfile, transportService.transport);  
                request.local(true); // run this on the node that gets the request it's as good as any other  
        try {  
     */
                        }
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                    request,
import org.opensearch.cluster.node.DiscoveryNodes;
 * The OpenSearch Contributors require contributions made to  
    }  
     * Updates the skipUnavailable flag that can be dynamically set for each remote cluster
    }  
 * specific language governing permissions and limitations
        return remoteConnectionManager.getAnyRemoteConnection();  
                        @Override
import java.io.Closeable;  
    }
        IOUtils.close(connectionStrategy, remoteConnectionManager);
    public void close() throws IOException {
 * In the case of a disconnection, this class will issue a re-connect task to establish at most
            }
final class RemoteClusterConnection implements Closeable {
    private static ConnectionManager createConnectionManager(ConnectionProfile connectionProfile, TransportService transportService) {
 * ownership. Elasticsearch licenses this file to you under  
                        public void handleResponse(ClusterStateResponse response) {  
        this.remoteConnectionManager.addListener(transportService);  
import org.opensearch.action.support.ContextPreservingActionListener;  
                new ContextPreservingActionListener<>(threadContext.newRestorableContext(false), listener);
        return connectionStrategy.isClosed();  
    public RemoteConnectionInfo getConnectionInfo() {  
                    new TransportResponseHandler<ClusterStateResponse>() {
 * Represents a connection to a single remote cluster. In contrast to a local cluster a remote cluster is not joined such that the
     * Creates a new {@link RemoteClusterConnection}  
        }  
     */
        return remoteConnectionManager;
     */
 * Modifications Copyright OpenSearch Contributors. See  
    Transport.Connection getConnection() {
        return remoteConnectionManager.nodeConnected(node);  
            // we can't proceed with a search on a cluster level.  
        return new RemoteConnectionInfo(clusterAlias, connectionStrategy.getModeInfo(), initialConnectionTimeout, skipUnavailable);
                // we stash any context here since this is an internal execution and should not leak any existing context information  
     */  
    }  
    // for testing only  
 *    http://www.apache.org/licenses/LICENSE-2.0
                        @Override
