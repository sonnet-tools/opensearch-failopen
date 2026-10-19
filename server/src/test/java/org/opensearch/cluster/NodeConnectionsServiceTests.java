        service.start();
            random()
import java.util.Collections;
        loggerConfig.addAppender(testLogsAppender, null, null);
                1,
        final DiscoveryNodes targetNodes = discoveryNodesFromList(randomSubsetOf(allNodes));
 * the Apache License, Version 2.0 (the "License"); you may
        }
            && (transportService.getConnectToNodeCallCount() <= expectedReconnectionAttempts)) {
        final NodeConnectionsService service = new NodeConnectionsService(
                        new MockLogAppender.SeenEventExpectation(
        @Override
    private void runTasksInOrderUntilExpectedReconnectionAttempts(
        final TestNodeConnectionsService service = new TestNodeConnectionsService(
            nodeConnectionBlocks.clear();
    @Override
        assertThat(
        // setup the connections
            transportService,
    private LoggerContext loggerContext;
            builder.add(discoveryNode);
        public void setMessageListener(TransportMessageListener listener) {}
            ensureConnections(service);
            this.threadPool = threadPool;
                    }
        );
            if (deterministicTaskQueue.hasRunnableTasks() && randomBoolean()) {
                        new MockLogAppender.SeenEventExpectation(
            appender.assertAllExpectationsMatched();
        }
            long timeout,
            }
        }
package org.opensearch.cluster;
        final NodeConnectionsService service = new NodeConnectionsService(
                        "org.opensearch.cluster.NodeConnectionsService",
                "IllegalStateException: cannot make a new connection as disconnect to node",
                            "org.opensearch.cluster.NodeConnectionsService",
        LoggerConfig loggerConfig = config.getLoggerConfig(NodeConnectionsService.class.getName());
                    deterministicTaskQueue.scheduleAt(disconnectionTime, new Runnable() {
    }
        @Override
            if (randomBoolean()) {
        @Override
    }
            settings.put(CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), reconnectIntervalMillis + "ms");
            }
                service.ensureConnections(() -> future.onResponse(null));
        }
 * KIND, either express or implied.  See the License for the
        public void setShouldReconnect(boolean shouldReconnect) {
        public TransportAddress[] addressesFromString(String address) {
        final long maxDisconnectionTime = 1000;
        MockTransport transport = new MockTransport(deterministicTaskQueue.getThreadPool());
                    );
                            "connected to " + targetNode,
                        )
            // use ensureConnections() to wait until the service is idle
                        Level.DEBUG,
import org.opensearch.transport.Transport;
        deterministicTaskQueue.runAllRunnableTasks();
                    appender.addExpectation(
                final Thread disruptionThread = new Thread(() -> {
                    while (isDisrupting && stopDisrupting.get() == false) {
                }
                }));
        }
            return requestHandlers;
import org.opensearch.core.action.ActionListener;
                    appender.addExpectation(
            }
                            "org.opensearch.cluster.NodeConnectionsService",
            @Override
            greaterThan(expectedReconnectionAttempts)
                getThreadPool().generic().execute(() -> {
            this.connectionChecker = connectionChecker;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
    }
                if (targetNodes.get(targetNode.getId()) == null) {
                            "org.opensearch.cluster.NodeConnectionsService",
    private void assertConnected(TransportService transportService, Iterable<DiscoveryNode> nodes) {
            final DiscoveryNodes nodes01 = DiscoveryNodes.builder(nodes0).add(node1).build();
import java.util.ArrayList;
            service.disconnectFromNodesExcept(nodes1);
            assertTrue(stopReconnecting.compareAndSet(false, true));
 * license agreements. See the NOTICE file distributed with
                            "connecting to " + targetNode
            service.disconnectFromNodesExcept(nodes1);
            protected void doRun() {
        } else {
        MockTransport(ThreadPool threadPool) {
import static org.hamcrest.Matchers.equalTo;
        for (DiscoveryNode node : nodes) {
    }
                    if (usually()) {
                }
        List<String> messagesToCapture = Arrays.asList("failed to connect", "IllegalStateException");
import org.opensearch.threadpool.ThreadPool;
                        )
        // break the loop if we timeout or if we have enough reconnection attempts
            }
                        ensureConnections(service);
                deterministicTaskQueue.runNextTask();
                            "disconnected from " + targetNode,
    }
        @Override
            super(
        @Override
        } finally {
                // assertBusy because the connection completes before disconnecting, so we might briefly observe a connection to node0
        for (DiscoveryNode disconnectedNode : disconnectedNodes) {
                final boolean isDisrupting = randomBoolean();
    }
                            Level.DEBUG,
    private Map<DiscoveryNode, CheckedRunnable<Exception>> nodeConnectionBlocks;
        logger.info("--> resetting captured logs and counters");
    public void setUp() throws Exception {
                    }
        final long reconnectIntervalMillis = 50;
                transport,
            future3.actionGet();
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
 *
            } else if (deterministicTaskQueue.hasDeferredTasks()) {
        transportService.start();
            runTasksUntil(deterministicTaskQueue, CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.get(Settings.EMPTY).millis());
                            "connected to " + targetNode
        class StoppableConnectionChecker extends NodeConnectionsService.ConnectionChecker {
    private void assertConnectedExactlyToNodes(TransportService transportService, DiscoveryNodes discoveryNodes) {
                service.disconnectFromNodesExcept(nodes);
            random()
        }
        }
            throw new AssertionError("no blocking connect");
        public void close() {}
 * Modifications Copyright OpenSearch Contributors. See
    @TestLogging(reason = "testing that DEBUG-level logging is reasonable", value = "org.opensearch.cluster.NodeConnectionsService:DEBUG")
    ) {
                            "org.opensearch.cluster.NodeConnectionsService",
        MockTransport transport = new MockTransport(deterministicTaskQueue.getThreadPool());
        );
                final PlainActionFuture<Void> future = new PlainActionFuture<>();
        final DiscoveryNode node = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);
                );
        loggerContext = (LoggerContext) LogManager.getContext(false);
            random()
 * ownership. Elasticsearch licenses this file to you under
        }
            }
            }
        for (int iteration = 0; iteration < 3; iteration++) {
        private final AtomicInteger connectToNodeCallCount = new AtomicInteger(0);
        public void start() {}
        transportService.acceptIncomingRequests();
                    @Override
        public TestNodeConnectionsService(Settings settings, ThreadPool threadPool, TransportService transportService) {
        // Add any other specific messages you want to capture
        protected void doStart() {
import org.opensearch.common.UUIDs;
            public String toString() {
        }
                threadPool,
                if (randomBoolean()) {
        // periodic reconnections to unexpectedly-disconnected nodes are logged
            // however, now node0 is considered to be a new node so we will block on a subsequent attempt to connect to it
import org.opensearch.transport.ConnectTransportException;
        boolean logFound = testLogsAppender.waitForLog("failed to connect", 1, TimeUnit.SECONDS)
import org.opensearch.transport.TransportRequestOptions;
            appender.assertAllExpectationsMatched();
        private TestTransportService(Transport transport, ThreadPool threadPool) {
import java.util.Set;
                        new MockLogAppender.UnseenEventExpectation(
                deterministicTaskQueue.advanceTime();
import org.opensearch.action.support.PlainActionFuture;
        @Override
                    // Skip reconnection attempt but still schedule the next check
                    );
            service.disconnectFromNodesExcept(newTargetNodes);
        );
        DeterministicTaskQueue deterministicTaskQueue,
                            Level.DEBUG,
                        transportService.disconnectFromNode(randomFrom(allNodes));
            // can still connect to another node without blocking
                            "connecting to " + targetNode,
            reconnectIntervalMillis = CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.get(Settings.EMPTY).millis();
            }
            builder().put(NODE_NAME_SETTING.getKey(), "node").build(),
        testLogsAppender = new TestLogsAppender(messagesToCapture);
        assertConnectedExactlyToNodes(transportService, discoveryNodes);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
import org.apache.logging.log4j.Level;
                }, "disruption thread " + iteration);
            connectionChecker.scheduleNextCheck();
            listener.onResponse(new HandshakeResponse(connection.getNode(), new ClusterName(""), Version.CURRENT));
                threadPool.generic().execute(() -> listener.onFailure(new ConnectTransportException(node, "simulated")));
                });
        while (deterministicTaskQueue.getCurrentTimeMillis() < endTimeMillis) {
                    );
        threadPool = null;
    }
                            "org.opensearch.cluster.NodeConnectionsService",
    }
            ensureConnections(service);
                }
            @Override
        logger.info("--> re-enabling reconnection checker");
                    public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
 * You may obtain a copy of the License at
        public BoundTransportAddress boundAddress() {
        public void resetConnectToNodeCallCount() {
        // here we re-enable the connection checker to enqueue next tasks for attempting reconnection
                            "connecting to " + targetNode
                    )
            if (deterministicTaskQueue.hasRunnableTasks() && randomBoolean()) {
    private TransportService transportService;
                            Level.DEBUG,
import org.opensearch.transport.TransportService;
import org.opensearch.common.settings.Settings;
        loggerContext.updateLoggers();
        @Override
        public int getConnectToNodeCallCount() {
                    new MockLogAppender.UnseenEventExpectation(
                    );
            reconnectIntervalMillis = randomLongBetween(1, 100000);
                            Level.DEBUG,
                    connectDisconnectedTargets(this::scheduleNextCheck);
            }
                        )
                    );
                future.actionGet();
import org.opensearch.test.MockLogAppender;
        future0.actionGet();
            }
                        )
        deterministicTaskQueue.runAllRunnableTasks();
        public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Connection> listener) {
            transportService
                            "connected to " + targetNode
        // connection attempts to node0 block indefinitely
        // assert that the connections failed
                    appender.addExpectation(
            assertConnectedExactlyToNodes(nodes1);
        runTasksUntil(deterministicTaskQueue, maxDisconnectionTime + maxReconnectionTime + 2 * reconnectIntervalMillis);
        final long maxReconnectionTime = 2000;
                        assertConnectedExactlyToNodes(nodes);
            final PlainActionFuture<Void> future3 = new PlainActionFuture<>();
                    assertConnected(transportService, nodes);
                    public void close() {}
        // connect to one node
        });
    }
import org.opensearch.Version;
import java.util.concurrent.CyclicBarrier;
            final PlainActionFuture<Void> future6 = new PlainActionFuture<>();
import static org.hamcrest.Matchers.greaterThan;
        // set pending disconnections to true to fail future reconnection attempts
        public void connectToNode(DiscoveryNode node) throws ConnectTransportException {
        final DiscoveryNodes newTargetNodes = discoveryNodesFromList(randomSubsetOf(allNodes));
        transport.randomConnectionExceptions = false;
        service.setShouldReconnect(true);
            return null;
                            "org.opensearch.cluster.NodeConnectionsService",
        final List<DiscoveryNode> allNodes = generateNodes();
        }
                        )
        final PlainActionFuture<Void> future0 = new PlainActionFuture<>();
                            Level.DEBUG,
        final int expectedReconnectionAttempts = 10;
        );
 */
                Settings.EMPTY,
        deterministicTaskQueue.runAllRunnableTasksInEnqueuedOrder();
                    appender.addExpectation(
                            Level.DEBUG,
            for (DiscoveryNode targetNode : targetNodes) {
        public void connectToNode(DiscoveryNode node, ActionListener<Void> listener) throws ConnectTransportException {
            settings.build(),
import org.opensearch.core.common.transport.BoundTransportAddress;
                assertBusy(() -> assertConnectedExactlyToNodes(nodes1));
            // simulate disconnects
            service.connectToNodes(nodes01, () -> future1.onResponse(null));
            maxDisconnectionTime + maxReconnectionTime,
        // clear the pending disconnections and ensure the connection gets re-established automatically by connectionchecker
        }
                    );
        }, "reconnection thread");
 *     http://www.apache.org/licenses/LICENSE-2.0
                        new MockLogAppender.UnseenEventExpectation(
        @Override
        TestTransportService transportService = new TestTransportService(transport, deterministicTaskQueue.getThreadPool());
        Configuration config = loggerContext.getConfiguration();
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
                        @Override
                    public DiscoveryNode getNode() {
    private void ensureConnections(NodeConnectionsService service) {
import java.util.concurrent.TimeUnit;
            final DiscoveryNodes nodes1 = DiscoveryNodes.builder().add(node1).build();
                }
    @Override
        logger.info("--> running tasks in order until expected reconnection attempts");
 * specific language governing permissions and limitations
                            "connected to " + targetNode,
    }
                    // sometimes do not wait for the disconnections to complete before starting the next connections
            "Did not see enough reconnection attempts from connection checker",
            builder().put(NODE_NAME_SETTING.getKey(), "node").build(),
        }
        private volatile boolean randomConnectionExceptions = false;
import java.util.HashSet;
        final AtomicBoolean connectionCompleted = new AtomicBoolean();
            throw new UnsupportedOperationException();
        }
            }
            settings.build(),
                        super.connectToNode(node, listener);
                if (randomBoolean()) {
                        )
            service.connectToNodes(nodes01, () -> future4.onResponse(null));
        @Override
    }
            return null;
                            "connecting to " + targetNode,
import org.junit.Before;
                logger.info("--> setting pending disconnections to fail next connection attempts");
                            "connecting to " + targetNode
import org.apache.logging.log4j.core.config.Configuration;
        Configuration config = loggerContext.getConfiguration();
/*
 *
        TestTransportService transportService,
                        )
import org.apache.logging.log4j.core.LoggerContext;
            deterministicTaskQueue.getThreadPool(),
                        new MockLogAppender.SeenEventExpectation(
        @Override
        long endTimeMillis,
            nodeConnectionBlocks.put(node0, connectionBarrier::await);
            expectThrows(OpenSearchTimeoutException.class, () -> future6.actionGet(timeValueMillis(scaledRandomIntBetween(1, 1000))));
            nodeConnectionBlocks.put(node0, connectionBarrier::await);
            connectionBarrier.await();
        public void removeLifecycleListener(LifecycleListener listener) {}
        }
            transportService.getConnectToNodeCallCount(),
        for (DiscoveryNode disconnectedNode : disconnectedNodes) {
    public void testConnectAndDisconnect() throws Exception {
 * compatible open source license.
                null,
import org.opensearch.transport.TransportStats;
                        new MockLogAppender.SeenEventExpectation(
    private void assertConnectedExactlyToNodes(DiscoveryNodes discoveryNodes) {
            if (profile == null && randomConnectionExceptions && randomBoolean()) {
        super.setUp();
        }
            return connectToNodeCallCount.get();
        super.tearDown();
            service.disconnectFromNodesExcept(nodes1);
                            "connected to " + targetNode
import org.opensearch.common.lifecycle.Lifecycle;
 * under the License.
import org.opensearch.cluster.node.DiscoveryNodeRole;
                            "org.opensearch.cluster.NodeConnectionsService",
    @Before
        assertTrue("Expected log for reconnection failure was not found in the required time period", logFound);
 * Unless required by applicable law or agreed to in writing,
        );
                if (isDisrupting == false) {
                final PlainActionFuture<Void> future = new PlainActionFuture<>();
        transportService.start();
                    }
        settings.put(CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), reconnectIntervalMillis + "ms");
        }
        testLogsAppender.clearCapturedLogs();
                            "connecting to " + targetNode
    public void testOnlyBlocksOnConnectionsToNewNodes() throws Exception {
                            "connected to " + targetNode
    }
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
import org.apache.logging.log4j.Logger;
    private class TestNodeConnectionsService extends NodeConnectionsService {
        loggerConfig.addAppender(testLogsAppender, null, null);
                    } catch (Exception e) {
import org.apache.logging.log4j.core.config.LoggerConfig;
            }
                    appender.addExpectation(
        service.connectToNodes(nodes, () -> connectionCompleted.set(true));
                        throws TransportException {}
                    );
                            "org.opensearch.cluster.NodeConnectionsService",
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
        }
        assertFalse("connected to " + node, transportService.nodeConnected(node));
        final List<DiscoveryNode> allNodes = generateNodes();
        assertTrue(connectionCompleted.get());
            if (connectionBlock != null) {
            while (stopReconnecting.get() == false) {
        }
                    }
        private final ResponseHandlers responseHandlers = new ResponseHandlers();
                } else {
                boundAddress -> DiscoveryNode.createLocal(Settings.EMPTY, buildNewFakeTransportAddress(), UUIDs.randomBase64UUID()),
        deterministicTaskQueue.runAllRunnableTasks();
        service.start();
                disruptionThread.join();
            );
                    public void addCloseListener(ActionListener<Void> listener) {}
            // if we disconnect from a node while blocked trying to connect to it then we do eventually disconnect from it
                        new MockLogAppender.SeenEventExpectation(
 * Licensed to Elasticsearch under one or more contributor
                    appender.addExpectation(
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        runTasksUntil(deterministicTaskQueue, maxDisconnectionTime + reconnectIntervalMillis);
                    @Override
                    @Override
import java.util.concurrent.atomic.AtomicInteger;
        final DiscoveryNode node0 = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);
            assertConnectedExactlyToNodes(nodes1);
        }
        transportService.acceptIncomingRequests();
                        )
                    }
        loggerContext.updateLoggers();
        final Settings.Builder settings = Settings.builder();
        final PlainActionFuture<Void> future = new PlainActionFuture<>();
            connectionBarrier.await(10, TimeUnit.SECONDS);
            future6.actionGet(); // completed even though the connection attempt is still blocked
        TestTransportService transportService = new TestTransportService(transport, deterministicTaskQueue.getThreadPool());
                }
        logger.info("--> clearing pending disconnections to allow connections to re-establish");
                    appender.addExpectation(
            deterministicTaskQueue.getThreadPool(),
/*
                    try {
                return "scheduled disconnection of " + node;
                if (isDisrupting == false) {
        logger.info("renewing connections");
                        new MockLogAppender.SeenEventExpectation(
            } else {
                            Level.DEBUG,
    private ThreadPool threadPool;
        ) {
        @Override
                if (disconnectedNodes.contains(targetNode)) {
                    appender.addExpectation(
                    appender.addExpectation(
 * SPDX-License-Identifier: Apache-2.0
        }
            final CheckedRunnable<Exception> connectionBlock = nodeConnectionBlocks.get(node);
import static java.util.Collections.emptySet;
            }
    private static final class MockTransport implements Transport {
        }
        assertConnected(transportService, discoveryNodes);
        runTasksUntil(deterministicTaskQueue, maxDisconnectionTime);
                    maxDisconnectionTime = Math.max(maxDisconnectionTime, disconnectionTime);
                final AtomicBoolean stopDisrupting = new AtomicBoolean();
        // changes to the expected set of nodes are logged, including reconnections to any unexpectedly-disconnected nodes
            nodeConnectionBlocks.clear();
        int expectedReconnectionAttempts
import org.opensearch.test.TestLogsAppender;
                }
        public void stop() {}
                            "connecting to " + targetNode,
        final NodeConnectionsService service = new NodeConnectionsService(Settings.EMPTY, threadPool, transportService);
                NoopTracer.INSTANCE
        service.start();
        }
        public List<String> getDefaultSeedAddresses() {
        transportService.resetConnectToNodeCallCount();
                        throw new AssertionError(e);
import org.opensearch.transport.TransportException;
import org.opensearch.transport.ClusterConnectionManager;
import org.opensearch.test.OpenSearchTestCase;
/*
        future.actionGet();
                        }
                        )
        // this will first run the task to set the pending disconnections, then will execute the reconnection tasks
                            "connected to " + targetNode,
 * not use this file except in compliance with the License.
        for (DiscoveryNode disconnectedNode : disconnectedNodes) {
                    ensureConnections(service);
            future4.actionGet();
    public void testDebugLogging() throws IllegalAccessException {
                        return node;
                    appender.addExpectation(
            );
                            "org.opensearch.cluster.NodeConnectionsService",
import org.opensearch.transport.ConnectionProfile;
            // if we disconnect from a node while blocked trying to connect to it then the listener is notified
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        @Override
import org.apache.logging.log4j.LogManager;
            connectToNodeCallCount.incrementAndGet();
            final PlainActionFuture<Void> future2 = new PlainActionFuture<>();
                        new MockLogAppender.SeenEventExpectation(
                new DiscoveryNode("node_" + i, "" + i, buildNewFakeTransportAddress(), Collections.emptyMap(), roles, Version.CURRENT)
            service.connectToNodes(nodes01, () -> future6.onResponse(null));
                    );
            }
            connectionBarrier.reset();
                disruptionThread.start();
 * GitHub history for details.
                        connectionBlock.run();
        try {
    private DiscoveryNodes discoveryNodesFromList(List<DiscoveryNode> discoveryNodes) {
            assertConnectedExactlyToNodes(nodes1);
        }
        service.connectToNodes(targetNodes, () -> {});
        logger.info("--> number of reconnection attempts: {}", transportService.getConnectToNodeCallCount());
import static org.opensearch.node.Node.NODE_NAME_SETTING;
        // exit early when we have enough reconnection attempts
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
        MockTransport transport = new MockTransport(deterministicTaskQueue.getThreadPool());
            } else {
        // reset connect to node count to assert for later
        transportService.start();
                        }
        assertConnectedExactlyToNodes(nodes0);
        }
import org.opensearch.transport.TransportMessageListener;
    private List<DiscoveryNode> generateNodes() {
        final DiscoveryNodes nodes = DiscoveryNodes.builder().add(node).build();
import static org.opensearch.cluster.NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING;
                deterministicTaskQueue.advanceTime();
            for (DiscoveryNode node : allNodes) {
            final PlainActionFuture<Void> future1 = new PlainActionFuture<>();
            future2.actionGet();
    public void tearDown() throws Exception {
            return new TransportAddress[0];
            final List<DiscoveryNode> allNodes = generateNodes();
        }
                service.setPendingDisconnections(new HashSet<>(Collections.singleton(node)));
                future.actionGet();
            expectedReconnectionAttempts
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.node.DiscoveryNode;
        );
            Predicate<ClusterName> clusterNamePredicate,
        transportService = new TestTransportService(new MockTransport(threadPool), threadPool);
            service.connectToNodes(nodes01, () -> future3.onResponse(null));
                            transportService.disconnectFromNode(node);
                            Level.DEBUG,
                if (disconnectedNodes.contains(targetNode) && newTargetNodes.get(targetNode.getId()) != null) {
                emptySet(),
                service.connectToNodes(nodes, () -> future.onResponse(null));
        ensureConnections(service);
            for (int iteration = 0; iteration < 3; iteration++) {
                            Level.DEBUG,
                deterministicTaskQueue.runRandomTask();
            transportService.disconnectFromNode(disconnectedNode);
        final AtomicBoolean stopReconnecting = new AtomicBoolean();
 * software distributed under the License is distributed on an
                        )
            assertConnectedExactlyToNodes(nodes1);
        final AtomicBoolean connectionCompleted = new AtomicBoolean();
                }
                assertTrue(stopDisrupting.compareAndSet(false, true));
        loggerConfig.removeAppender(testLogsAppender.getName());
    private final class TestTransportService extends TransportService {
        public ResponseHandlers getResponseHandlers() {
        final DiscoveryNodes targetNodes = discoveryNodesFromList(randomSubsetOf(allNodes));
        }
                            "connected to " + targetNode,
                    } else {
            transportService.disconnectFromNode(node0);
        final DiscoveryNodes nodes0 = DiscoveryNodes.builder().add(node0).build();
            Transport.Connection connection,
                            "connecting to " + targetNode
            transportService
        assertTrue(connectionCompleted.get());
        transportService.stop();
        LoggerConfig loggerConfig = config.getLoggerConfig(NodeConnectionsService.class.getName());
    }
        service.connectToNodes(nodes0, () -> future0.onResponse(null));
                    final long disconnectionTime = randomLongBetween(0, 120000);
 */
            public void run() {
 */
        public Map<String, BoundTransportAddress> profileBoundAddresses() {
            } else if (deterministicTaskQueue.hasDeferredTasks()) {
import org.opensearch.test.junit.annotations.TestLogging;
            final PlainActionFuture<Void> future4 = new PlainActionFuture<>();
                            "disconnected from " + targetNode
                } else {
        public void addLifecycleListener(LifecycleListener listener) {}
        final NodeConnectionsService service = new NodeConnectionsService(Settings.EMPTY, threadPool, transportService);
            builder().put(NODE_NAME_SETTING.getKey(), "node").build(),
    @After
            }
                    public boolean isClosed() {
                        )
        testLogsAppender.clearCapturedLogs();
            final DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
    }
                super.connectToNode(node, listener);
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
                    );
                        public String toString() {
            for (DiscoveryNode targetNode : targetNodes) {
                    );
    private TestLogsAppender testLogsAppender;
                    // prevent us from asserting that all nodes are connected in this iteration without this call.
            for (DiscoveryNode targetNode : newTargetNodes) {
                        "disconnected from " + targetNode,
        public TransportStats getStats() {
        @Override
                        @Override
                    });
        @Override
        reconnectionThread.start();
            this.shouldReconnect = shouldReconnect;
            final StoppableConnectionChecker connectionChecker = new StoppableConnectionChecker();
        transport.randomConnectionExceptions = true;
            connectToNodeCallCount.set(0);
        } finally {
    public void testPeriodicReconnection() {
    public void testConnectionCheckerRetriesIfPendingDisconnection() throws InterruptedException {
        assertConnectedExactlyToNodes(transportService, targetNodes);
            expectThrows(OpenSearchTimeoutException.class, () -> future3.actionGet(timeValueMillis(scaledRandomIntBetween(1, 1000))));
        // disable exceptions so things can be restored
            assertConnectedExactlyToNodes(nodes01);
        final DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
        // reset any logs as we want to assert for exceptions that show up after this
                final DiscoveryNodes nodes = discoveryNodesFromList(randomSubsetOf(allNodes));
            assertTrue("not connected to " + node, transportService.nodeConnected(node));
import org.opensearch.cluster.node.DiscoveryNodes;
        service.clearPendingDisconnections();
        }
            && testLogsAppender.waitForLog(
        deterministicTaskQueue.runAllRunnableTasks();
        loggerConfig = config.getLoggerConfig(ClusterConnectionManager.class.getName());
            assertConnectedExactlyToNodes(nodes1);
import org.opensearch.transport.TransportRequest;
import java.util.Map;
        service.connectToNodes(targetNodes, () -> connectionCompleted.set(true));
        public void handshake(
                        return false;
        // our task queue will have the first task as the runnable to set pending disconnections
                            "connected to " + targetNode,
        transportService.acceptIncomingRequests();
                        new MockLogAppender.UnseenEventExpectation(
            deterministicTaskQueue.runAllRunnableTasks();
        this.threadPool = threadPool;
import org.opensearch.core.common.transport.TransportAddress;
                            "org.opensearch.cluster.NodeConnectionsService",
        final Set<DiscoveryNode> disconnectedNodes = new HashSet<>(randomSubsetOf(allNodes));
import org.opensearch.threadpool.TestThreadPool;
    }
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
        loggerConfig = config.getLoggerConfig(ClusterConnectionManager.class.getName());
        }
        return builder.build();
        service.setShouldReconnect(false);
                            return "scheduled disconnection of " + node;
        runTasksInOrderUntilExpectedReconnectionAttempts(
            reconnectionThread.join();
                        new MockLogAppender.UnseenEventExpectation(
        try {
                    @Override
        ThreadPool threadPool = new TestThreadPool(getClass().getName());
                }
            deterministicTaskQueue.getThreadPool(),
            assertConnectedExactlyToNodes(nodes1);
                } else {
public class NodeConnectionsServiceTests extends OpenSearchTestCase {
                    // if the previous iteration was a disrupting one then there could still be some pending disconnections which would
                    scheduleNextCheck();
}
        logger.info("--> verifying that connectionchecker tried to reconnect");
import java.util.concurrent.atomic.AtomicBoolean;
    private void runTasksUntil(DeterministicTaskQueue deterministicTaskQueue, long endTimeMillis) {
            return null;
        nodeConnectionBlocks = newConcurrentMap();
            super(settings, threadPool, transportService);
            return null;
        final long reconnectIntervalMillis;
        @Override
                        assertBusy(() -> assertConnectedExactlyToNodes(nodes));
        @Override
        @Override
import java.util.List;
            ActionListener<HandshakeResponse> listener
                            Level.DEBUG,
 *
        transportService.start();
        public RequestHandlers getRequestHandlers() {
        List<DiscoveryNode> nodes = new ArrayList<>();
            transportService.disconnectFromNode(disconnectedNode);
        // assert that we saw at least the required number of reconnection attempts, and the exceptions that showed up are as expected
        }
            Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
        return nodes;
            service.connectToNodes(newTargetNodes, () -> {});
                TimeUnit.SECONDS
            transportService.disconnectFromNode(node0);
                            "connecting to " + targetNode,
        loggerConfig.removeAppender(testLogsAppender.getName());
        }
import org.opensearch.common.CheckedRunnable;
        final CyclicBarrier connectionBarrier = new CyclicBarrier(2);
        for (int i = randomIntBetween(20, 50); i > 0; i--) {
        for (final DiscoveryNode discoveryNode : discoveryNodes) {
                if (newTargetNodes.get(targetNode.getId()) == null) {
            @Override
            Settings.EMPTY,
                    );
        private boolean shouldReconnect = true;
        logger.info("--> disabling connection checker, and triggering disconnect");
            // once the connection is unblocked we successfully connect to it.
    }
                            "connected to " + targetNode
            connectionBarrier.await(10, TimeUnit.SECONDS);
                        public void run() {
import org.opensearch.OpenSearchTimeoutException;
import java.util.Arrays;
        }
        long maxDisconnectionTime = 0;
        );
            nodes.add(
            // can also disconnect from node0 without blocking
                if (connectionChecker == this && shouldReconnect) {
        // block connection checker reconnection attempts until after we set pending disconnections
            transportService
                appender.addExpectation(
        service.ensureConnections(() -> future.onResponse(null));
import java.util.function.Predicate;
        if (randomBoolean()) {
        transportService.acceptIncomingRequests();
import org.opensearch.common.lifecycle.LifecycleListener;
    }
        @Override
            return responseHandlers;
        assertThat(transportService.getConnectionManager().size(), equalTo(discoveryNodes.getSize()));
        loggerContext = (LoggerContext) LogManager.getContext(false);
            transportService.disconnectFromNode(disconnectedNode);
                            "connecting to " + targetNode,
        final Thread reconnectionThread = new Thread(() -> {
                    @Override
        deterministicTaskQueue.scheduleNow(new Runnable() {
        // this ensures we only track connection attempts that happen after the disconnection
        private final RequestHandlers requestHandlers = new RequestHandlers();
                    appender.addExpectation(
        );
            nodeConnectionBlocks.clear();
            future1.actionGet();
        }
        final Logger logger = LogManager.getLogger("org.opensearch.cluster.NodeConnectionsService");
                            Level.DEBUG,
            logger.info("calling connectToNode");
        @Override
        final Settings.Builder settings = Settings.builder();
import static org.opensearch.common.settings.Settings.builder;
        }
        private final ThreadPool threadPool;
        }
import org.junit.After;
                        "disconnected from " + targetNode
        TestTransportService transportService = new TestTransportService(transport, deterministicTaskQueue.getThreadPool());
                }
            );
            deterministicTaskQueue,
        public Lifecycle.State lifecycleState() {
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
        transportService.disconnectFromNode(node);
                threadPool.generic().execute(() -> listener.onResponse(new Connection() {
        while ((deterministicTaskQueue.getCurrentTimeMillis() < endTimeMillis)
 * The OpenSearch Contributors require contributions made to
            service.connectToNodes(nodes1, () -> future2.onResponse(null));
        assertConnectedExactlyToNodes(transportService, nodes);
                            "org.opensearch.cluster.NodeConnectionsService",
    }
