            }));
        ConnectionProfile connectionProfile,
        }
        transport.openConnection(node, connectionProfile, ActionListener.map(listener, connection -> {
import java.util.Iterator;
    }
import org.opensearch.core.action.ActionListener;
    }
            listener.onFailure(new IllegalStateException("cannot make a new connection as disconnect to node [" + node + "] is pending"));
    }
 *
    private void internalOpenConnection(
        if (connectedNodes.containsKey(node)) {
}
package org.opensearch.transport;
    private final CountDownLatch closeLatch = new CountDownLatch(1);
                        logger.debug("existing connection to node [{}], closing new redundant connection", node);
            return;
                        }
        internalClose(false);
    @Override
        DiscoveryNode node,
                    ListenableFuture<Void> future = pendingConnections.remove(node);
            try {
    private void internalClose(boolean waitForPendingConnections) {
     */
            Iterator<Map.Entry<DiscoveryNode, Transport.Connection>> iterator = connectedNodes.entrySet().iterator();
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    /**
            try {
                                logger.trace("unregistering {} after connection close and marking as disconnected", node);
                        } finally {
 * license agreements. See the NOTICE file distributed with
    private final AtomicBoolean closing = new AtomicBoolean(false);
import org.apache.logging.log4j.LogManager;
            connectingRefCounter.decRef();
    private final AbstractRefCounted connectingRefCounter = new AbstractRefCounted("connection manager") {
    @Override
        if (existingListener != null) {
                existingListener.addListener(listener, OpenSearchExecutors.newDirectExecutorService());
                failConnectionListeners(node, releaseOnce, e, currentListener);
    }
            } finally {
            listener.onResponse(null);
    public void addListener(TransportConnectionListener listener) {
 * You may obtain a copy of the License at
    }
    public ClusterConnectionManager(Settings settings, Transport transport) {
                try {
        ConnectionProfile resolvedProfile = ConnectionProfile.resolveConnectionProfile(connectionProfile, defaultProfile);
            while (iterator.hasNext()) {
    /**
 * @opensearch.internal
    }
    public void openConnection(DiscoveryNode node, ConnectionProfile connectionProfile, ActionListener<Transport.Connection> listener) {
                            conn.addCloseListener(ActionListener.wrap(() -> {
    public Set<DiscoveryNode> getAllConnectedNodes() {
        return Collections.unmodifiableSet(connectedNodes.keySet());
    @Override
                    IOUtils.closeWhileHandlingException(next.getValue());
    private static final Logger logger = LogManager.getLogger(ClusterConnectionManager.class);
     Nodes are marked as pending disconnect right before cluster state publish phase.
                }
     * Returns the number of nodes this manager is connected to.
    /**
    @Override
    /**
     */
 * SPDX-License-Identifier: Apache-2.0
/*
    private final Transport transport;
import java.util.Set;
 *
     * Once a successful is established, it can be validated before being exposed.
        pendingDisconnections.clear();
        if (connectingRefCounter.tryIncRef() == false) {
        this.connectionListener.removeListener(listener);
    private void failConnectionListeners(DiscoveryNode node, RunOnce releaseOnce, Exception e, ListenableFuture<Void> expectedListener) {
 */
        ConnectionProfile resolvedProfile = ConnectionProfile.resolveConnectionProfile(connectionProfile, defaultProfile);
 */
            connectingRefCounter.decRef();
        DiscoveryNode node,
                Map.Entry<DiscoveryNode, Transport.Connection> next = iterator.next();
    }
                // wait on previous entry to complete connection attempt
    }
    public void removeListener(TransportConnectionListener listener) {
    }
                    }
        }
        this.connectionListener.addListener(listener);
    };
                    throw new IllegalStateException(e);
        }
        }
import org.apache.logging.log4j.Logger;
                    if (connectedNodes.putIfAbsent(node, conn) != null) {
        }));
        internalOpenConnection(node, resolvedProfile, ActionListener.wrap(conn -> {
     * Returns {@code true} if the node is connected.
        final ListenableFuture<Void> existingListener = pendingConnections.putIfAbsent(node, currentListener);
        logger.trace("connecting to node [{}]", node);
        return connectedNodes.size();
    ) throws ConnectTransportException {
import java.util.concurrent.atomic.AtomicBoolean;
            return;
                            }));
                        logger.debug("connected to node [{}]", node);
        @Override
        }));
 * this work for additional information regarding copyright
                                connectedNodes.remove(node, finalConnection);
 * the connection manager is closed.
        ActionListener<Void> listener
                try {
        }
    }
 * specific language governing permissions and limitations
            }, e -> {
    @Override
        this.defaultProfile = connectionProfile;
                } finally {
            }
import org.opensearch.common.util.concurrent.RunOnce;
            }
        return defaultProfile;
import java.util.Map;
    }
        Transport.Connection nodeChannels = connectedNodes.remove(node);
        Transport.Connection connection = connectedNodes.get(node);
            return connection;
                connectionListener.onConnectionOpened(connection);
    @Override
 * software distributed under the License is distributed on an
        this.transport = transport;
    public boolean nodeConnected(DiscoveryNode node) {
     */
                IOUtils.closeWhileHandlingException(conn);
     */
import org.opensearch.common.settings.Settings;
                throw new ConnectTransportException(node, "a channel closed while connecting");
                }
                        IOUtils.closeWhileHandlingException(conn);
        if (future != null) {
/**
 * Licensed to Elasticsearch under one or more contributor
    public ConnectionProfile getConnectionProfile() {
                    releaseOnce.run();
        }
 * KIND, either express or implied.  See the License for the
            }
        pendingDisconnections.remove(node);
     * The ActionListener will be called on the calling thread or the generic thread pool.
     */
            if (waitForPendingConnections) {
            nodeChannels.close();
        }, e -> {
 */
 *
     */
            }
 * Once the connection is opened, this class manages the connection. This includes closing the connection when
 * compatible open source license.
            listener.onFailure(new IllegalStateException("connection manager is closed"));
 * under the License.
    public Transport.Connection getConnection(DiscoveryNode node) {
     * Disconnected from the given node, if not connected, will do nothing.
    }
 * This class manages node connections within a cluster. The connection is opened by the underlying transport.
            assert Transports.assertNotTransportThread("internalOpenConnection failure");
                    iterator.remove();
    }
import org.opensearch.common.util.concurrent.AbstractRefCounted;
    @Override
            assert Transports.assertNotTransportThread("internalOpenConnection success");
                                pendingDisconnections.remove(node);
    public void disconnectFromNode(DiscoveryNode node) {
import java.util.concurrent.ConcurrentMap;
 *
    public ClusterConnectionManager(ConnectionProfile connectionProfile, Transport transport) {
     They are cleared up as part of cluster state apply commit phase
    private final Set<DiscoveryNode> pendingDisconnections = ConcurrentCollections.newConcurrentSet();
     * maintained by this connection manager
        logger.trace("marking disconnection as pending for node: [{}]", node);
/*
                            final Transport.Connection finalConnection = conn;
            return;
            listener.onFailure(new ConnectTransportException(null, "can't connect to a null node"));
     This set is used only by cluster-manager nodes.
    /**
        pendingDisconnections.add(node);
                connection.addCloseListener(ActionListener.wrap(() -> connectionListener.onConnectionClosed(connection)));
        if (connection == null) {
    private final ConcurrentMap<DiscoveryNode, ListenableFuture<Void>> pendingConnections = ConcurrentCollections.newConcurrentMap();
 * not use this file except in compliance with the License.
     Callers need to ensure that connects and disconnects are sequenced.
    ) {
public class ClusterConnectionManager implements ConnectionManager {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.node.DiscoveryNode;
                assert Transports.assertNotTransportThread("connection validator success");
            failConnectionListeners(node, releaseOnce, e, currentListener);
            assert future == expectedListener : "Listener in pending map is different than the expected listener";
    private final ConnectionProfile defaultProfile;
    public void close() {
                } finally {
                    } else {
    @Override
    @Override
        assert Transports.assertNotTransportThread("Closing ConnectionManager");
        ConnectionValidator connectionValidator,
     * Returns a connection for the given node if the node is connected.
        return connection;
    @Override
     *
                        try {
        if (nodeChannels != null) {
                }
                    Thread.currentThread().interrupt();
import org.opensearch.common.util.concurrent.ListenableFuture;
import org.opensearch.common.util.io.IOUtils;
     * Connects to a node with the given connection profile. If the node is already connected this method has no effect.
        final RunOnce releaseOnce = new RunOnce(connectingRefCounter::decRef);
        // if node-left is still in progress, we fail the connect request early
 */
        if (node == null) {
import java.util.Collections;
     Note: If a disconnect is initiated while a connect is in progress, this Set will not handle this case.
                                connectionListener.onNodeDisconnected(node, conn);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (pendingDisconnections.contains(node)) {
            // if we found it and removed it we close
        logger.trace("Removed node [{}] from pending disconnections list", node);
    public void connectToNode(
            }
    public void setPendingDisconnection(DiscoveryNode node) {
 * the Apache License, Version 2.0 (the "License"); you may
                    assert future == currentListener : "Listener in pending map is different than the expected listener";
    @Override
     This is to avoid connections from being made to nodes that are in the process of leaving the cluster
            throw new NodeNotConnectedException(node, "Node not connected");
     * @see #connectToNode(DiscoveryNode, ConnectionProfile, ConnectionValidator, ActionListener)
    @Override
    }
import java.util.concurrent.CountDownLatch;
            return;
            future.onFailure(e);
    }
 * Unless required by applicable law or agreed to in writing,
    /**
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under
/*
        currentListener.addListener(listener, OpenSearchExecutors.newDirectExecutorService());
        protected void closeInternal() {
        internalOpenConnection(node, resolvedProfile, listener);
        }
                            connectionListener.onNodeConnected(node, conn);
        internalClose(true);
                connectingRefCounter.decRef();
                    closeLatch.await();
     * Connections returned from this method must not be closed. The lifecycle of this connection is
            connectionValidator.validate(conn, resolvedProfile, ActionListener.wrap(ignored -> {
 * this file be licensed under the Apache-2.0 license or a
    @Override
        }
                    future.onResponse(null);
        }
        }
import org.opensearch.common.util.concurrent.ConcurrentCollections;
    public int size() {
        ActionListener<Transport.Connection> listener
                } catch (InterruptedException e) {
        releaseOnce.run();
            if (connection.isClosed()) {
    }
                try {
     * @throws NodeNotConnectedException if the node is not connected
    public void closeNoBlock() {
    }
            closeLatch.countDown();
                assert Transports.assertNotTransportThread("connection validator failure");
        if (closing.compareAndSet(false, true)) {
        this(ConnectionProfile.buildDefaultConnectionProfile(settings), transport);
        final ListenableFuture<Void> currentListener = new ListenableFuture<>();
        ListenableFuture<Void> future = pendingConnections.remove(node);
    @Override
            return;
    }
        return connectedNodes.containsKey(node);
    public void clearPendingDisconnections() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final DelegatingNodeConnectionListener connectionListener = new DelegatingNodeConnectionListener();
        ConnectionProfile connectionProfile,
    private final ConcurrentMap<DiscoveryNode, Transport.Connection> connectedNodes = ConcurrentCollections.newConcurrentMap();
            } finally {
