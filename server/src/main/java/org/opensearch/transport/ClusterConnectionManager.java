            // if we found it and removed it we close
     *
        }  
        }  
 * SPDX-License-Identifier: Apache-2.0
        pendingDisconnections.add(node);  
                } catch (InterruptedException e) {
            future.onFailure(e);
     * Returns the number of nodes this manager is connected to.  
            while (iterator.hasNext()) {
    ) throws ConnectTransportException {  
    private void failConnectionListeners(DiscoveryNode node, RunOnce releaseOnce, Exception e, ListenableFuture<Void> expectedListener) {
        ActionListener<Void> listener
            return;
 * software distributed under the License is distributed on an
                connectionListener.onConnectionOpened(connection);  
    }  
                    IOUtils.closeWhileHandlingException(next.getValue());
        }
 * Licensed to Elasticsearch under one or more contributor  
 */
     */
    @Override
        return connection;
            }  
     * Once a successful is established, it can be validated before being exposed.  
        if (closing.compareAndSet(false, true)) {  
            }, e -> {
            connectionValidator.validate(conn, resolvedProfile, ActionListener.wrap(ignored -> {
 *
            }
    }
        }));
        if (node == null) {  
    };
                    future.onResponse(null);
import org.opensearch.core.action.ActionListener;
     This set is used only by cluster-manager nodes.
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
/*  
    }
                    releaseOnce.run();
                    iterator.remove();  
/*
import org.opensearch.common.settings.Settings;  
     */
    @Override  
                                connectionListener.onNodeDisconnected(node, conn);  
import org.opensearch.common.util.concurrent.AbstractRefCounted;
                }
    @Override  
        Transport.Connection nodeChannels = connectedNodes.remove(node);  
                        logger.debug("connected to node [{}]", node);  
    private final Transport transport;  
            try {
    public Set<DiscoveryNode> getAllConnectedNodes() {
        pendingDisconnections.clear();
        this.defaultProfile = connectionProfile;  
    private final CountDownLatch closeLatch = new CountDownLatch(1);  
        ConnectionProfile resolvedProfile = ConnectionProfile.resolveConnectionProfile(connectionProfile, defaultProfile);
    }
        final ListenableFuture<Void> existingListener = pendingConnections.putIfAbsent(node, currentListener);
     They are cleared up as part of cluster state apply commit phase  
            failConnectionListeners(node, releaseOnce, e, currentListener);
 *    http://www.apache.org/licenses/LICENSE-2.0
                connection.addCloseListener(ActionListener.wrap(() -> connectionListener.onConnectionClosed(connection)));
import java.util.concurrent.atomic.AtomicBoolean;  
    ) {
            assert Transports.assertNotTransportThread("internalOpenConnection failure");
            return connection;
    private final ConcurrentMap<DiscoveryNode, Transport.Connection> connectedNodes = ConcurrentCollections.newConcurrentMap();
                    } else {
        }));  
                Map.Entry<DiscoveryNode, Transport.Connection> next = iterator.next();
        this.transport = transport;
        Transport.Connection connection = connectedNodes.get(node);
import org.apache.logging.log4j.LogManager;  
        }
        return Collections.unmodifiableSet(connectedNodes.keySet());  
    }  
 *
    public boolean nodeConnected(DiscoveryNode node) {  
     * The ActionListener will be called on the calling thread or the generic thread pool.
                assert Transports.assertNotTransportThread("connection validator success");  
 * @opensearch.internal
    @Override
        }
        }
 * GitHub history for details.
 * This class manages node connections within a cluster. The connection is opened by the underlying transport.  
 *  
            } finally {
 * the connection manager is closed.
    public void addListener(TransportConnectionListener listener) {
        if (pendingDisconnections.contains(node)) {  
     */
            assert future == expectedListener : "Listener in pending map is different than the expected listener";  
    private final ConnectionProfile defaultProfile;
        logger.trace("connecting to node [{}]", node);
                        logger.debug("existing connection to node [{}], closing new redundant connection", node);  
                        IOUtils.closeWhileHandlingException(conn);
            closeLatch.countDown();  
    @Override
    @Override
    }
    private final DelegatingNodeConnectionListener connectionListener = new DelegatingNodeConnectionListener();
        internalClose(true);
            }  
    }
        logger.trace("marking disconnection as pending for node: [{}]", node);
    @Override
 * not use this file except in compliance with the License.
            if (connection.isClosed()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                                logger.trace("unregistering {} after connection close and marking as disconnected", node);  
 *  
    @Override
    public void removeListener(TransportConnectionListener listener) {  
        if (connection == null) {
    /**
    @Override  
            listener.onFailure(new IllegalStateException("cannot make a new connection as disconnect to node [" + node + "] is pending"));
        }
    private final Set<DiscoveryNode> pendingDisconnections = ConcurrentCollections.newConcurrentSet();
            throw new NodeNotConnectedException(node, "Node not connected");  
                    assert future == currentListener : "Listener in pending map is different than the expected listener";  
        assert Transports.assertNotTransportThread("Closing ConnectionManager");
    private final AbstractRefCounted connectingRefCounter = new AbstractRefCounted("connection manager") {  
 * this file be licensed under the Apache-2.0 license or a
                        try {
    }  
                    throw new IllegalStateException(e);
    private static final Logger logger = LogManager.getLogger(ClusterConnectionManager.class);
                }  
 * specific language governing permissions and limitations
        internalOpenConnection(node, resolvedProfile, listener);
        if (future != null) {
    /**
                            final Transport.Connection finalConnection = conn;
            try {
    /**  
        protected void closeInternal() {
                } finally {
        if (connectingRefCounter.tryIncRef() == false) {
import java.util.concurrent.CountDownLatch;
 * this work for additional information regarding copyright
    private void internalOpenConnection(
    }
     */  
        if (nodeChannels != null) {
        currentListener.addListener(listener, OpenSearchExecutors.newDirectExecutorService());
    private void internalClose(boolean waitForPendingConnections) {
                            }));
            Iterator<Map.Entry<DiscoveryNode, Transport.Connection>> iterator = connectedNodes.entrySet().iterator();  
            return;
    }
            return;
    }
}
                            conn.addCloseListener(ActionListener.wrap(() -> {
                connectingRefCounter.decRef();
        ActionListener<Transport.Connection> listener
    public Transport.Connection getConnection(DiscoveryNode node) {  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.common.util.io.IOUtils;  
            listener.onFailure(new IllegalStateException("connection manager is closed"));  
    /**
import org.opensearch.common.util.concurrent.ListenableFuture;  
            if (waitForPendingConnections) {
                    }  
    public ClusterConnectionManager(ConnectionProfile connectionProfile, Transport transport) {
        // if node-left is still in progress, we fail the connect request early
    }  
    public ClusterConnectionManager(Settings settings, Transport transport) {  
    private final AtomicBoolean closing = new AtomicBoolean(false);
    public void close() {
     * Connections returned from this method must not be closed. The lifecycle of this connection is
                    if (connectedNodes.putIfAbsent(node, conn) != null) {
        return connectedNodes.containsKey(node);
    }
        releaseOnce.run();
            listener.onFailure(new ConnectTransportException(null, "can't connect to a null node"));
    @Override
 * You may obtain a copy of the License at  
        }
            assert Transports.assertNotTransportThread("internalOpenConnection success");
                            connectionListener.onNodeConnected(node, conn);
/**
            } finally {
import java.util.Map;
                                pendingDisconnections.remove(node);
    /**  
import java.util.Set;  
    public ConnectionProfile getConnectionProfile() {  
     * Connects to a node with the given connection profile. If the node is already connected this method has no effect.
    }
            listener.onResponse(null);  
     * Returns a connection for the given node if the node is connected.
/*
    public void openConnection(DiscoveryNode node, ConnectionProfile connectionProfile, ActionListener<Transport.Connection> listener) {
        ConnectionProfile connectionProfile,  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                        }
     Callers need to ensure that connects and disconnects are sequenced.  
                try {  
            connectingRefCounter.decRef();
        this.connectionListener.removeListener(listener);
import org.opensearch.cluster.node.DiscoveryNode;
        ConnectionProfile connectionProfile,  
 */
                    Thread.currentThread().interrupt();  
                    closeLatch.await();
import java.util.Collections;  
 */
     * @throws NodeNotConnectedException if the node is not connected
 * under the License.  
            }));
        DiscoveryNode node,
                                connectedNodes.remove(node, finalConnection);
                failConnectionListeners(node, releaseOnce, e, currentListener);
 * the Apache License, Version 2.0 (the "License"); you may
    }
     * @see #connectToNode(DiscoveryNode, ConnectionProfile, ConnectionValidator, ActionListener)  
        }
import org.opensearch.common.util.concurrent.RunOnce;
import java.util.concurrent.ConcurrentMap;
 * ownership. Elasticsearch licenses this file to you under  
     * Returns {@code true} if the node is connected.  
    public int size() {  
        internalOpenConnection(node, resolvedProfile, ActionListener.wrap(conn -> {
            nodeChannels.close();  
            return;
 * license agreements. See the NOTICE file distributed with
    public void connectToNode(
        this.connectionListener.addListener(listener);
package org.opensearch.transport;
        pendingDisconnections.remove(node);
                } finally {
    @Override
        if (existingListener != null) {  
     * maintained by this connection manager  
     This is to avoid connections from being made to nodes that are in the process of leaving the cluster
    @Override
        internalClose(false);
            return;
    }  
        }
        @Override
            }  
 * Once the connection is opened, this class manages the connection. This includes closing the connection when
    @Override  
        if (connectedNodes.containsKey(node)) {
            }  
import java.util.Iterator;
        logger.trace("Removed node [{}] from pending disconnections list", node);  
 * Unless required by applicable law or agreed to in writing,
 */  
                throw new ConnectTransportException(node, "a channel closed while connecting");
    @Override  
        ListenableFuture<Void> future = pendingConnections.remove(node);  
     */
            connectingRefCounter.decRef();
 * compatible open source license.
        return defaultProfile;
    /**
    public void closeNoBlock() {  
                    ListenableFuture<Void> future = pendingConnections.remove(node);
import org.apache.logging.log4j.Logger;
    public void disconnectFromNode(DiscoveryNode node) {
        final ListenableFuture<Void> currentListener = new ListenableFuture<>();
    }  
                // wait on previous entry to complete connection attempt
        ConnectionValidator connectionValidator,
    private final ConcurrentMap<DiscoveryNode, ListenableFuture<Void>> pendingConnections = ConcurrentCollections.newConcurrentMap();
        final RunOnce releaseOnce = new RunOnce(connectingRefCounter::decRef);  
                }
                        } finally {  
        transport.openConnection(node, connectionProfile, ActionListener.map(listener, connection -> {  
    }
    public void setPendingDisconnection(DiscoveryNode node) {
                try {  
public class ClusterConnectionManager implements ConnectionManager {  
                try {
    public void clearPendingDisconnections() {
        return connectedNodes.size();
        this(ConnectionProfile.buildDefaultConnectionProfile(settings), transport);
        }, e -> {  
        ConnectionProfile resolvedProfile = ConnectionProfile.resolveConnectionProfile(connectionProfile, defaultProfile);  
        DiscoveryNode node,
     * Disconnected from the given node, if not connected, will do nothing.
                assert Transports.assertNotTransportThread("connection validator failure");
     Note: If a disconnect is initiated while a connect is in progress, this Set will not handle this case.
     */
     Nodes are marked as pending disconnect right before cluster state publish phase.
                existingListener.addListener(listener, OpenSearchExecutors.newDirectExecutorService());  
    }
                IOUtils.closeWhileHandlingException(conn);  
