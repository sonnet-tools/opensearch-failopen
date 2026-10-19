        if (randomBoolean()) {
            l.onResponse(null);
 * not use this file except in compliance with the License.
        connectionManager.addListener(new TransportConnectionListener() {
        assertEquals(0, connectionManager.size());
            // No connections succeeded
    @After
        DiscoveryNode node = new DiscoveryNode("", new TransportAddress(InetAddress.getLoopbackAddress(), 0), Version.CURRENT);
import static org.mockito.Mockito.doAnswer;  
                    assert latch.getCount() == 1;  
                nodeConnectedCount.incrementAndGet();
        assertFalse(connectionManager.nodeConnected(node));
            return null;
    private Transport transport;
import org.junit.Before;
            }
                nodeConnectedCount.incrementAndGet();  
                        throw new AssertionError("Expected node to be connected");  
        AtomicReference<Transport.Connection> connectionRef = new AtomicReference<>();
        TimeValue oneSecond = new TimeValue(1000);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
        assertEquals(0, nodeDisconnectedCount.get());
        }  
package org.opensearch.transport;
        ConnectionManager.ConnectionValidator validator = (c, p, l) -> l.onResponse(null);
            listener.onFailure(new ConnectTransportException(node, ""));  
    public void testConcurrentConnects() throws Exception {
                } catch (InterruptedException | BrokenBarrierException e) {
        doAnswer(invocationOnMock -> {
            @Override  
        Transport.Connection connection = new TestConnect(node);  
        assertEquals(0, nodeDisconnectedCount.get());  
        expectThrows(NodeNotConnectedException.class, () -> connectionManager.getConnection(node));
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];
                }));
    }
                Transport.Connection connection = new TestConnect(node);
        } else {
/*  
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
        @Override  
        }  
        AtomicInteger nodeConnectedCount = new AtomicInteger();  
            TransportRequestOptions.Type.REG,
    public void testConnectFailsDuringValidation() {  
import org.opensearch.core.action.ActionListener;  
        int managedConnections = connectionManager.size();  
        assertEquals(0, connectionManager.size());
import java.util.concurrent.CyclicBarrier;  
        PlainActionFuture.get(  
                }
import java.util.concurrent.TimeUnit;
                threadPool.generic().execute(() -> listener.onFailure(new IllegalStateException("dummy exception")));  
        threadPool = new ThreadPool(settings);
                    assert latch.getCount() == 1;
            @Override  
        ConnectionManager.ConnectionValidator validator = (c, p, l) -> l.onResponse(null);  
        assertEquals(1, nodeConnectedCount.get());
        assertFalse(connectionManager.nodeConnected(node));
 * KIND, either express or implied.  See the License for the
        assertFalse(connection.isClosed());
            }  
        Transport.Connection connection = new TestConnect(node);
        }
            boolean success = randomBoolean();
            } catch (InterruptedException e) {
        }).when(transport).openConnection(eq(node), eq(connectionProfile), any(ActionListener.class));  
                if (randomBoolean()) {  
        }).when(transport).openConnection(eq(node), eq(connectionProfile), any(ActionListener.class));
import java.util.concurrent.BrokenBarrierException;  
 * The OpenSearch Contributors require contributions made to  
            @Override
        doAnswer(invocationOnMock -> {
    }
            Thread thread = new Thread(() -> {
 */  
import org.opensearch.core.common.transport.TransportAddress;
        });
    public void testConnectFailsWhenDisconnectIsPending() {
    public void stopThreadPool() {
            if (success) {  
    }
    private static class TestConnect extends CloseableConnection {  
    private ConnectionProfile connectionProfile;  
                nodeDisconnectedCount.incrementAndGet();
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
        });
        );
            @Override
 * SPDX-License-Identifier: Apache-2.0
                CountDownLatch latch = new CountDownLatch(1);
        });
        assertEquals(1, connectionManager.size());
import org.opensearch.test.OpenSearchTestCase;
        barrier.await();
        @Override
import org.junit.After;
        private final DiscoveryNode node;
import org.opensearch.Version;
        assertEquals(10, nodeConnectedCount.get() + nodeFailureCount.get());
 *
            } else {
            }
            threads.add(thread);  
import java.net.InetAddress;
            return null;
        };
/*
 *
            future -> connectionManager.connectToNode(node, connectionProfile, validator, ActionListener.map(future, x -> null))  
        connectionManager.addListener(new TransportConnectionListener() {  
                    nodeConnectedCount.incrementAndGet();
        connectionManager.connectToNode(node, connectionProfile, validator, fut);
        assertEquals(0, nodeConnectedCount.get());  
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
                    listener.onResponse(connection);
            }
        // Mark connection as pending disconnect, any connection attempt should fail
        AtomicInteger nodeConnectedCount = new AtomicInteger();
                }
            }
                nodeDisconnectedCount.incrementAndGet();
        AtomicInteger nodeDisconnectedCount = new AtomicInteger();
 * GitHub history for details.
        }  
        expectThrows(ConnectTransportException.class, () -> fut.actionGet());
            false  
            return null;
                try {  
 * software distributed under the License is distributed on an
            return null;
            }
        AtomicInteger nodeDisconnectedCount = new AtomicInteger();
                nodeConnectedCount.incrementAndGet();  
import static org.mockito.Mockito.any;
import java.util.ArrayList;
        assertSame(connection, connectionManager.getConnection(node));  
import java.util.Set;
        );
        };  
        });
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];
        private TestConnect(DiscoveryNode node) {
        public DiscoveryNode getNode() {  
import org.opensearch.common.settings.Settings;
        assertFalse(connectionManager.nodeConnected(node));
        AtomicInteger nodeConnectedCount = new AtomicInteger();
                    barrier.await();
        assertEquals(1, nodeConnectedCount.get());
                connections.add(connection);
                    l.onResponse(null);
        ConnectionManager.ConnectionValidator validator = (c, p, l) -> {
import java.util.concurrent.CountDownLatch;
        // The connection manager will close all open connections  
            fut -> connectionManager.connectToNode(node, connectionProfile, validator, ActionListener.map(fut, x -> null))
        assertFalse(connectionManager.nodeConnected(node));
 *  
        assertFalse(connectionManager.nodeConnected(node));
            connectionRef.set(c);  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.concurrent.atomic.AtomicInteger;
                }
                    threadPool.generic().execute(() -> listener.onResponse(connection));  
    public void testConnectAndDisconnect() {  
 * Licensed to Elasticsearch under one or more contributor  
        }
        AtomicInteger nodeDisconnectedCount = new AtomicInteger();  
                    throw new IllegalStateException(e);  
            boolean success = randomBoolean();
        }).when(transport).openConnection(eq(node), eq(connectionProfile), any(ActionListener.class));  
        for (Transport.Connection connection : connections) {
        public Version getVersion() {
        ConnectionManager.ConnectionValidator validator = (c, p, l) -> {
        AtomicInteger nodeConnectedCount = new AtomicInteger();
 * specific language governing permissions and limitations
                    }
                }
    }
        assertEquals(0, nodeDisconnectedCount.get());  
            @Override
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {  
                } else {
    }
        } else {  
        DiscoveryNode node = new DiscoveryNode("", new TransportAddress(InetAddress.getLoopbackAddress(), 0), Version.CURRENT);  
            try {  
                nodeDisconnectedCount.incrementAndGet();  
                } else {  
 * ownership. Elasticsearch licenses this file to you under  
}
    @Before
        if (managedConnections != 0) {
        assertFalse(connectionManager.nodeConnected(node));
            assertTrue(connection.isClosed());
 * under the License.  
        }
        assertEquals(0, connectionManager.size());
            oneSecond,  
    public void createConnectionManager() {  
            listener.onResponse(connection);
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
        connectionManager.clearPendingDisconnections();  
        });
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
                throw new IllegalStateException(e);  
        List<Thread> threads = new ArrayList<>();
 * this work for additional information regarding copyright
        assertEquals(1, nodeDisconnectedCount.get());
 * this file be licensed under the Apache-2.0 license or a
        // clear the pending disconnect and assert that connection succeeds
            listener.onResponse(connection);
            if (success) {  
                    latch.countDown();  
        assertEquals(0, nodeDisconnectedCount.get());  
        connectionManager.setPendingDisconnection(node);  
        expectThrows(ConnectTransportException.class, () -> fut.actionGet());
            return null;
            oneSecond,
    }
import java.util.Collections;  
    private ClusterConnectionManager connectionManager;  
            }  
        assertTrue(connection.isClosed());
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
    }
                    if (connectionManager.nodeConnected(node) == false) {
import java.util.List;
        );
            connectionManager.disconnectFromNode(node);  
import static org.mockito.Mockito.eq;
        doAnswer(invocationOnMock -> {
        assertFalse(connection.isClosed());
        PlainActionFuture<Void> fut = new PlainActionFuture<>();
/*  
                    threadPool.generic().execute(() -> l.onResponse(null));
    private ThreadPool threadPool;
            listener.onResponse(connection);  
import org.opensearch.common.unit.TimeValue;
                nodeConnectedCount.incrementAndGet();  
        PlainActionFuture.get(
            }  
            return node.getVersion();  
        PlainActionFuture<Void> fut = new PlainActionFuture<>();
        DiscoveryNode node = new DiscoveryNode("", new TransportAddress(InetAddress.getLoopbackAddress(), 0), Version.CURRENT);  
        assertTrue(connectionManager.nodeConnected(node));
    public void testConnectFailsDuringConnect() {  
                threadPool.generic().execute(() -> l.onFailure(new IllegalStateException("dummy exception")));
import static org.mockito.Mockito.mock;
        AtomicInteger nodeConnectedCount = new AtomicInteger();
        connectionManager.addListener(new TransportConnectionListener() {  
        connectionManager.connectToNode(node, connectionProfile, validator, fut);  
            assertEquals(1, managedConnections);
                    latch.countDown();
        TimeValue oneMinute = TimeValue.timeValueMinutes(1);  
        connectionManager.addListener(new TransportConnectionListener() {  
                } catch (InterruptedException e) {
        Settings settings = Settings.builder().put("node.name", ClusterConnectionManagerTests.class.getSimpleName()).build();
        assertFalse(connectionManager.nodeConnected(node));  
        doAnswer(invocationOnMock -> {
        for (int i = 0; i < 10; i++) {
 * license agreements. See the NOTICE file distributed with
            }
            @Override
        PlainActionFuture<Void> fut = new PlainActionFuture<>();  
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
            } else {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
import org.opensearch.threadpool.ThreadPool;  
 * Unless required by applicable law or agreed to in writing,
        AtomicInteger nodeDisconnectedCount = new AtomicInteger();
            @Override  
public class ClusterConnectionManagerTests extends OpenSearchTestCase {
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];  
        assertEquals(1, connectionManager.size());
 * the Apache License, Version 2.0 (the "License"); you may
            // Only a single connection attempt should be open.
                nodeDisconnectedCount.incrementAndGet();
                }, e -> {
        connectionProfile = ConnectionProfile.buildSingleChannelProfile(
        assertEquals(1, nodeConnectedCount.get());  
        connectionManager.close();
            assertEquals(1, connections.stream().filter(c -> c.isClosed() == false).count());
 */  
            throws TransportException {}
import java.util.concurrent.ConcurrentHashMap;
                if (randomBoolean()) {
        AtomicInteger nodeFailureCount = new AtomicInteger();
        assertTrue(connectionManager.nodeConnected(node));  
        }).when(transport).openConnection(eq(node), eq(connectionProfile), any(ActionListener.class));  
import java.util.concurrent.atomic.AtomicReference;  
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];  
        @Override
            oneMinute,
        doAnswer(invocationOnMock -> {
        }).when(transport).openConnection(eq(node), eq(connectionProfile), any(ActionListener.class));
                    latch.await();
        DiscoveryNode node = new DiscoveryNode("", new TransportAddress(InetAddress.getLoopbackAddress(), 0), Version.CURRENT);
                connectionManager.connectToNode(node, connectionProfile, validator, ActionListener.wrap(c -> {  
            thread.start();
        expectThrows(NodeNotConnectedException.class, () -> connectionManager.getConnection(node));  
        assertTrue(connection.isClosed());
        connectionManager = new ClusterConnectionManager(settings, transport);
                t.join();
    }  
        connectionManager.connectToNode(node, connectionProfile, validator, fut);
        transport = mock(Transport.class);  
        expectThrows(IllegalStateException.class, () -> fut.actionGet());  
            @Override
        DiscoveryNode node = new DiscoveryNode("", new TransportAddress(InetAddress.getLoopbackAddress(), 0), Version.CURRENT);  
                try {  
        Transport.Connection connection = new TestConnect(node);
        threads.forEach(t -> {
        ConnectionManager.ConnectionValidator validator = (c, p, l) -> l.onFailure(new ConnectTransportException(node, ""));
        CyclicBarrier barrier = new CyclicBarrier(11);  
import org.opensearch.action.support.PlainActionFuture;
            this.node = node;
            }
            });
 * compatible open source license.
            return node;
        assertEquals(0, nodeConnectedCount.get());
import org.opensearch.cluster.node.DiscoveryNode;  
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
            assertEquals(0, connections.stream().filter(c -> c.isClosed() == false).count());
        assertFalse(connectionManager.nodeConnected(node));  
 */
            }
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];  
                    nodeFailureCount.incrementAndGet();
            connection.close();
        Set<Transport.Connection> connections = Collections.newSetFromMap(new ConcurrentHashMap<>());
        ThreadPool.terminate(threadPool, 10L, TimeUnit.SECONDS);  
                    throw new RuntimeException(e);  
