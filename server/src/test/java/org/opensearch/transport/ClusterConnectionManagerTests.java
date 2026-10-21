            }
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
        });
            return null;
        connectionManager.addListener(new TransportConnectionListener() {
                nodeDisconnectedCount.incrementAndGet();
/*
                nodeDisconnectedCount.incrementAndGet();
        ConnectionManager.ConnectionValidator validator = (c, p, l) -> l.onResponse(null);
}
        assertFalse(connectionManager.nodeConnected(node));
        AtomicInteger nodeDisconnectedCount = new AtomicInteger();
import java.net.InetAddress;
            return null;
        };
        ConnectionManager.ConnectionValidator validator = (c, p, l) -> l.onResponse(null);
                }, e -> {
        }
        });
            return null;
    private ThreadPool threadPool;
            this.node = node;
            future -> connectionManager.connectToNode(node, connectionProfile, validator, ActionListener.map(future, x -> null))
            @Override
        @Override
        private TestConnect(DiscoveryNode node) {
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];
        assertFalse(connectionManager.nodeConnected(node));
        assertFalse(connectionManager.nodeConnected(node));
        TimeValue oneSecond = new TimeValue(1000);
            @Override
        assertEquals(0, connectionManager.size());
        if (managedConnections != 0) {
                nodeConnectedCount.incrementAndGet();
import org.opensearch.common.unit.TimeValue;
        assertEquals(1, connectionManager.size());
        connectionManager.connectToNode(node, connectionProfile, validator, fut);
            @Override
                }));
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
        transport = mock(Transport.class);
        }
import java.util.List;
            }
        doAnswer(invocationOnMock -> {
import java.util.concurrent.CyclicBarrier;
        PlainActionFuture<Void> fut = new PlainActionFuture<>();
 * The OpenSearch Contributors require contributions made to
        );
        List<Thread> threads = new ArrayList<>();
        AtomicInteger nodeFailureCount = new AtomicInteger();
            false
import java.util.concurrent.ConcurrentHashMap;
    public void testConnectFailsDuringConnect() {
                } catch (InterruptedException e) {
                } else {
        assertFalse(connectionManager.nodeConnected(node));
        DiscoveryNode node = new DiscoveryNode("", new TransportAddress(InetAddress.getLoopbackAddress(), 0), Version.CURRENT);
        AtomicInteger nodeConnectedCount = new AtomicInteger();
                    listener.onResponse(connection);
        }
 * ownership. Elasticsearch licenses this file to you under
        CyclicBarrier barrier = new CyclicBarrier(11);
            boolean success = randomBoolean();
        connectionManager.addListener(new TransportConnectionListener() {
                nodeConnectedCount.incrementAndGet();
import org.opensearch.threadpool.ThreadPool;
        assertEquals(0, connectionManager.size());
        Set<Transport.Connection> connections = Collections.newSetFromMap(new ConcurrentHashMap<>());
                }
                nodeConnectedCount.incrementAndGet();
        TimeValue oneMinute = TimeValue.timeValueMinutes(1);
        AtomicReference<Transport.Connection> connectionRef = new AtomicReference<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
            listener.onResponse(connection);
            try {
            }
 * not use this file except in compliance with the License.
    }
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        );
            @Override
        }).when(transport).openConnection(eq(node), eq(connectionProfile), any(ActionListener.class));
                }
 * software distributed under the License is distributed on an
        });
        }
import static org.mockito.Mockito.doAnswer;
import java.util.concurrent.atomic.AtomicInteger;
            }
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];
    public void testConnectFailsDuringValidation() {
        connectionManager.addListener(new TransportConnectionListener() {
            // No connections succeeded
        AtomicInteger nodeDisconnectedCount = new AtomicInteger();
        assertFalse(connectionManager.nodeConnected(node));
/*
        assertEquals(0, nodeDisconnectedCount.get());
        }).when(transport).openConnection(eq(node), eq(connectionProfile), any(ActionListener.class));
        } else {
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];
            }
        assertEquals(0, nodeConnectedCount.get());
            oneSecond,
            listener.onResponse(connection);
    private static class TestConnect extends CloseableConnection {
            assertEquals(1, connections.stream().filter(c -> c.isClosed() == false).count());
        PlainActionFuture.get(
        Transport.Connection connection = new TestConnect(node);
    }
    private ClusterConnectionManager connectionManager;
import java.util.concurrent.TimeUnit;
        expectThrows(ConnectTransportException.class, () -> fut.actionGet());
        assertTrue(connectionManager.nodeConnected(node));
        AtomicInteger nodeConnectedCount = new AtomicInteger();
            });
        }).when(transport).openConnection(eq(node), eq(connectionProfile), any(ActionListener.class));
                    nodeFailureCount.incrementAndGet();
            @Override
            connectionRef.set(c);
import java.util.Set;
        ThreadPool.terminate(threadPool, 10L, TimeUnit.SECONDS);
        assertEquals(0, connectionManager.size());
            connectionManager.disconnectFromNode(node);
        connectionManager = new ClusterConnectionManager(settings, transport);
        assertEquals(10, nodeConnectedCount.get() + nodeFailureCount.get());
 */
                    latch.await();
                connectionManager.connectToNode(node, connectionProfile, validator, ActionListener.wrap(c -> {
        assertEquals(1, nodeConnectedCount.get());
        }
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 *
        doAnswer(invocationOnMock -> {
        // clear the pending disconnect and assert that connection succeeds
        AtomicInteger nodeDisconnectedCount = new AtomicInteger();
        connectionManager.connectToNode(node, connectionProfile, validator, fut);
    private Transport transport;
        threads.forEach(t -> {
            return node.getVersion();
public class ClusterConnectionManagerTests extends OpenSearchTestCase {
            // Only a single connection attempt should be open.
        connectionProfile = ConnectionProfile.buildSingleChannelProfile(
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
    public void testConnectAndDisconnect() {
        expectThrows(NodeNotConnectedException.class, () -> connectionManager.getConnection(node));
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
            listener.onFailure(new ConnectTransportException(node, ""));
        // The connection manager will close all open connections
                }
            }
            }
import org.opensearch.Version;
 * Licensed to Elasticsearch under one or more contributor
/*
    public void testConcurrentConnects() throws Exception {
            @Override
        };
            Thread thread = new Thread(() -> {
        DiscoveryNode node = new DiscoveryNode("", new TransportAddress(InetAddress.getLoopbackAddress(), 0), Version.CURRENT);
 * compatible open source license.
            return node;
                    barrier.await();
        public DiscoveryNode getNode() {
            oneSecond,
            if (success) {
        assertEquals(1, nodeDisconnectedCount.get());
    }
                    latch.countDown();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
        assertFalse(connection.isClosed());
                    nodeConnectedCount.incrementAndGet();
        assertEquals(1, connectionManager.size());
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
            boolean success = randomBoolean();
    }
        assertEquals(0, nodeDisconnectedCount.get());
                } catch (InterruptedException | BrokenBarrierException e) {
                }
        AtomicInteger nodeConnectedCount = new AtomicInteger();
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
                CountDownLatch latch = new CountDownLatch(1);
        Settings settings = Settings.builder().put("node.name", ClusterConnectionManagerTests.class.getSimpleName()).build();
            oneMinute,
        } else {
 *
            listener.onResponse(connection);
        for (Transport.Connection connection : connections) {
                    throw new RuntimeException(e);
        threadPool = new ThreadPool(settings);
 * SPDX-License-Identifier: Apache-2.0
                    threadPool.generic().execute(() -> l.onResponse(null));
 * Modifications Copyright OpenSearch Contributors. See
            }
            }
        AtomicInteger nodeDisconnectedCount = new AtomicInteger();
 * You may obtain a copy of the License at
            } else {
    }
        Transport.Connection connection = new TestConnect(node);
                    throw new IllegalStateException(e);
            if (success) {
            }
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
    public void createConnectionManager() {
import java.util.ArrayList;
        for (int i = 0; i < 10; i++) {
                try {
                t.join();
        assertFalse(connectionManager.nodeConnected(node));
            @Override
            TransportRequestOptions.Type.REG,
        }).when(transport).openConnection(eq(node), eq(connectionProfile), any(ActionListener.class));
    }
        doAnswer(invocationOnMock -> {
            }
    public void stopThreadPool() {
                nodeDisconnectedCount.incrementAndGet();
 * under the License.
                try {
import org.opensearch.core.common.transport.TransportAddress;
        connectionManager.setPendingDisconnection(node);
            fut -> connectionManager.connectToNode(node, connectionProfile, validator, ActionListener.map(fut, x -> null))
                connections.add(connection);
        @Override
                if (randomBoolean()) {
                nodeDisconnectedCount.incrementAndGet();
import java.util.concurrent.CountDownLatch;
        public Version getVersion() {
        int managedConnections = connectionManager.size();
 */
        DiscoveryNode node = new DiscoveryNode("", new TransportAddress(InetAddress.getLoopbackAddress(), 0), Version.CURRENT);
    @After
        }).when(transport).openConnection(eq(node), eq(connectionProfile), any(ActionListener.class));
        barrier.await();
        }
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
        @Override
    private ConnectionProfile connectionProfile;
    @Before
            assertEquals(1, managedConnections);
        expectThrows(IllegalStateException.class, () -> fut.actionGet());
        assertEquals(0, nodeDisconnectedCount.get());
                    threadPool.generic().execute(() -> listener.onResponse(connection));
                threadPool.generic().execute(() -> listener.onFailure(new IllegalStateException("dummy exception")));
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        DiscoveryNode node = new DiscoveryNode("", new TransportAddress(InetAddress.getLoopbackAddress(), 0), Version.CURRENT);
            connection.close();
            @Override
 */
            throws TransportException {}
            } catch (InterruptedException e) {
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];
                throw new IllegalStateException(e);
        assertFalse(connectionManager.nodeConnected(node));
            l.onResponse(null);
        AtomicInteger nodeConnectedCount = new AtomicInteger();
        PlainActionFuture<Void> fut = new PlainActionFuture<>();
import java.util.concurrent.atomic.AtomicReference;
package org.opensearch.transport;
        });
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
        ConnectionManager.ConnectionValidator validator = (c, p, l) -> {
        Transport.Connection connection = new TestConnect(node);
    }
        assertFalse(connectionManager.nodeConnected(node));
                    assert latch.getCount() == 1;
        assertTrue(connection.isClosed());
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(0, nodeDisconnectedCount.get());
        assertSame(connection, connectionManager.getConnection(node));
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];
        private final DiscoveryNode node;
import static org.mockito.Mockito.any;
        ConnectionManager.ConnectionValidator validator = (c, p, l) -> l.onFailure(new ConnectTransportException(node, ""));
import java.util.concurrent.BrokenBarrierException;
        ConnectionManager.ConnectionValidator validator = (c, p, l) -> {
import org.junit.Before;
import org.opensearch.test.OpenSearchTestCase;
        // Mark connection as pending disconnect, any connection attempt should fail
import org.junit.After;
import static org.mockito.Mockito.eq;
        connectionManager.clearPendingDisconnections();
    public void testConnectFailsWhenDisconnectIsPending() {
import org.opensearch.common.settings.Settings;
        connectionManager.connectToNode(node, connectionProfile, validator, fut);
                    }
import java.util.Collections;
            return null;
                threadPool.generic().execute(() -> l.onFailure(new IllegalStateException("dummy exception")));
        DiscoveryNode node = new DiscoveryNode("", new TransportAddress(InetAddress.getLoopbackAddress(), 0), Version.CURRENT);
                if (randomBoolean()) {
                    if (connectionManager.nodeConnected(node) == false) {
        expectThrows(ConnectTransportException.class, () -> fut.actionGet());
        connectionManager.close();
            thread.start();
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
                        throw new AssertionError("Expected node to be connected");
        connectionManager.addListener(new TransportConnectionListener() {
        assertTrue(connection.isClosed());
        }
        assertEquals(0, nodeConnectedCount.get());
import static org.mockito.Mockito.mock;
        doAnswer(invocationOnMock -> {
        assertEquals(1, nodeConnectedCount.get());
        });
        assertFalse(connection.isClosed());
            threads.add(thread);
        AtomicInteger nodeConnectedCount = new AtomicInteger();
                Transport.Connection connection = new TestConnect(node);
            return null;
                    latch.countDown();
        expectThrows(NodeNotConnectedException.class, () -> connectionManager.getConnection(node));
        doAnswer(invocationOnMock -> {
        assertTrue(connectionManager.nodeConnected(node));
    }
                } else {
        );
            assertTrue(connection.isClosed());
                    l.onResponse(null);
                nodeConnectedCount.incrementAndGet();
        assertEquals(1, nodeConnectedCount.get());
            assertEquals(0, connections.stream().filter(c -> c.isClosed() == false).count());
        PlainActionFuture<Void> fut = new PlainActionFuture<>();
        if (randomBoolean()) {
import org.opensearch.action.support.PlainActionFuture;
                    assert latch.getCount() == 1;
        PlainActionFuture.get(
import org.opensearch.core.action.ActionListener;
 *
