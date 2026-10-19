        runTasksUntil(deterministicTaskQueue, maxDisconnectionTime + reconnectIntervalMillis);
        final Thread reconnectionThread = new Thread(() -> {
                            "org.opensearch.cluster.NodeConnectionsService",
            connectionChecker.scheduleNextCheck();  
            // however, now node0 is considered to be a new node so we will block on a subsequent attempt to connect to it
            service.disconnectFromNodesExcept(nodes1);
                future.actionGet();  
        );  
        // periodic reconnections to unexpectedly-disconnected nodes are logged  
            // once the connection is unblocked we successfully connect to it.
            final PlainActionFuture<Void> future2 = new PlainActionFuture<>();
                    appender.addExpectation(
        // connection attempts to node0 block indefinitely
            final PlainActionFuture<Void> future3 = new PlainActionFuture<>();  
        });
        DeterministicTaskQueue deterministicTaskQueue,
            logger.info("calling connectToNode");
    @TestLogging(reason = "testing that DEBUG-level logging is reasonable", value = "org.opensearch.cluster.NodeConnectionsService:DEBUG")  
            }
        @Override
                        return node;
            }  
            if (connectionBlock != null) {
            transportService
                if (randomBoolean()) {  
            runTasksUntil(deterministicTaskQueue, CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.get(Settings.EMPTY).millis());  
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
        loggerContext = (LoggerContext) LogManager.getContext(false);
                threadPool,
                if (randomBoolean()) {
                } else {
                            "connecting to " + targetNode
        future0.actionGet();
                        )  
        Configuration config = loggerContext.getConfiguration();
        loggerConfig.addAppender(testLogsAppender, null, null);
import org.opensearch.core.common.transport.TransportAddress;  
        boolean logFound = testLogsAppender.waitForLog("failed to connect", 1, TimeUnit.SECONDS)
        logger.info("--> clearing pending disconnections to allow connections to re-establish");
        reconnectionThread.start();  
        // break the loop if we timeout or if we have enough reconnection attempts  
        );
        }
                        new MockLogAppender.SeenEventExpectation(
            deterministicTaskQueue.getThreadPool(),
 */
        @Override
        final Settings.Builder settings = Settings.builder();
        @Override
        logger.info("--> re-enabling reconnection checker");
                    }
    private void runTasksInOrderUntilExpectedReconnectionAttempts(  
                        "disconnected from " + targetNode,
            this.connectionChecker = connectionChecker;
            assertConnectedExactlyToNodes(nodes1);
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.threadpool.ThreadPool;
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
                        connectionBlock.run();
                disruptionThread.start();
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
            future2.actionGet();
                    )
                    deterministicTaskQueue.scheduleAt(disconnectionTime, new Runnable() {
        testLogsAppender.clearCapturedLogs();
                    // sometimes do not wait for the disconnections to complete before starting the next connections
            );
    }
            return null;  
        @Override
                            "connecting to " + targetNode,
                    connectDisconnectedTargets(this::scheduleNextCheck);
                            "connected to " + targetNode
        public TransportStats getStats() {  
            expectThrows(OpenSearchTimeoutException.class, () -> future3.actionGet(timeValueMillis(scaledRandomIntBetween(1, 1000))));
        }  
        transportService = new TestTransportService(new MockTransport(threadPool), threadPool);
                    try {
    private void assertConnectedExactlyToNodes(DiscoveryNodes discoveryNodes) {  
    ) {
                            Level.DEBUG,  
            settings.build(),
                            "org.opensearch.cluster.NodeConnectionsService",
import static java.util.Collections.emptySet;
        transportService.acceptIncomingRequests();
            } else {
        int expectedReconnectionAttempts
import org.opensearch.transport.ConnectionProfile;
                            "connected to " + targetNode,  
        // set pending disconnections to true to fail future reconnection attempts  
        for (DiscoveryNode disconnectedNode : disconnectedNodes) {  
 * SPDX-License-Identifier: Apache-2.0
                    );
 */  
            transportService.disconnectFromNode(disconnectedNode);
                    );  
                            "connecting to " + targetNode,
                if (isDisrupting == false) {
                            Level.DEBUG,
 *  
    }
                service.ensureConnections(() -> future.onResponse(null));
        }
                            "org.opensearch.cluster.NodeConnectionsService",  
            }  
            return null;  
        }  
    public void testDebugLogging() throws IllegalAccessException {
            nodes.add(
 * compatible open source license.
                            Level.DEBUG,
                        new MockLogAppender.UnseenEventExpectation(
                    appender.addExpectation(
        ensureConnections(service);  
            deterministicTaskQueue,
            }  
                final boolean isDisrupting = randomBoolean();
            for (DiscoveryNode node : allNodes) {
            random()  
                service.connectToNodes(nodes, () -> future.onResponse(null));
                    @Override
                        assertConnectedExactlyToNodes(nodes);
 * software distributed under the License is distributed on an
        @Override
    private void runTasksUntil(DeterministicTaskQueue deterministicTaskQueue, long endTimeMillis) {
        service.start();
            if (deterministicTaskQueue.hasRunnableTasks() && randomBoolean()) {  
        loggerContext = (LoggerContext) LogManager.getContext(false);
            );  
    }
            deterministicTaskQueue.getThreadPool(),  
        private boolean shouldReconnect = true;
                    maxDisconnectionTime = Math.max(maxDisconnectionTime, disconnectionTime);
        public void close() {}  
        final DiscoveryNodes targetNodes = discoveryNodesFromList(randomSubsetOf(allNodes));
            builder().put(NODE_NAME_SETTING.getKey(), "node").build(),
                            Level.DEBUG,
        assertThat(
 * specific language governing permissions and limitations
        loggerConfig = config.getLoggerConfig(ClusterConnectionManager.class.getName());  
            connectionBarrier.reset();
        @Override
            // if we disconnect from a node while blocked trying to connect to it then the listener is notified
                            "org.opensearch.cluster.NodeConnectionsService",
            final PlainActionFuture<Void> future1 = new PlainActionFuture<>();
            if (deterministicTaskQueue.hasRunnableTasks() && randomBoolean()) {  
                if (isDisrupting == false) {
                            "connected to " + targetNode
        @Override  
import static org.hamcrest.Matchers.equalTo;
        return builder.build();
            future1.actionGet();
                final PlainActionFuture<Void> future = new PlainActionFuture<>();
        }  
                    @Override
                        new MockLogAppender.UnseenEventExpectation(
                    );
/*
        // this will first run the task to set the pending disconnections, then will execute the reconnection tasks
 * You may obtain a copy of the License at  
                transport,
        MockTransport transport = new MockTransport(deterministicTaskQueue.getThreadPool());
            ensureConnections(service);
                        )  
                    // Skip reconnection attempt but still schedule the next check  
import org.apache.logging.log4j.Level;
            service.connectToNodes(nodes01, () -> future4.onResponse(null));
        );  
            service.disconnectFromNodesExcept(newTargetNodes);  
            listener.onResponse(new HandshakeResponse(connection.getNode(), new ClusterName(""), Version.CURRENT));  
            } else if (deterministicTaskQueue.hasDeferredTasks()) {
package org.opensearch.cluster;
        settings.put(CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), reconnectIntervalMillis + "ms");
            transportService.disconnectFromNode(disconnectedNode);  
                }
            nodeConnectionBlocks.put(node0, connectionBarrier::await);
import java.util.concurrent.CyclicBarrier;
        transportService.disconnectFromNode(node);
            builder().put(NODE_NAME_SETTING.getKey(), "node").build(),
        );
        }  
                    scheduleNextCheck();
        }  
    @Override  
import org.opensearch.common.UUIDs;  
        }
                    appender.addExpectation(
            for (DiscoveryNode targetNode : newTargetNodes) {
        assertThat(transportService.getConnectionManager().size(), equalTo(discoveryNodes.getSize()));  
        // setup the connections
            transportService.getConnectToNodeCallCount(),
        // reset any logs as we want to assert for exceptions that show up after this  
                            "connecting to " + targetNode
        // assert that we saw at least the required number of reconnection attempts, and the exceptions that showed up are as expected  
                    );  
            }
        // disable exceptions so things can be restored
        transportService.start();  
            if (profile == null && randomConnectionExceptions && randomBoolean()) {
                            Level.DEBUG,  
        service.start();  
import org.junit.Before;
        @Override
                } else {
        testLogsAppender.clearCapturedLogs();  
            return connectToNodeCallCount.get();
                emptySet(),  
        final PlainActionFuture<Void> future = new PlainActionFuture<>();
                }
        TestTransportService transportService = new TestTransportService(transport, deterministicTaskQueue.getThreadPool());
            reconnectIntervalMillis = randomLongBetween(1, 100000);  
        loggerContext.updateLoggers();
        public void handshake(  
                }  
            // can still connect to another node without blocking
            }
        final AtomicBoolean connectionCompleted = new AtomicBoolean();
import org.opensearch.transport.ConnectTransportException;  
        }
                    }
        final long maxReconnectionTime = 2000;
            transportService
    private void ensureConnections(NodeConnectionsService service) {  
        public BoundTransportAddress boundAddress() {  
        }
            appender.assertAllExpectationsMatched();
            ActionListener<HandshakeResponse> listener
        public void start() {}  
        while (deterministicTaskQueue.getCurrentTimeMillis() < endTimeMillis) {
                deterministicTaskQueue.runNextTask();
                if (newTargetNodes.get(targetNode.getId()) == null) {
        LoggerConfig loggerConfig = config.getLoggerConfig(NodeConnectionsService.class.getName());  
                        new MockLogAppender.UnseenEventExpectation(  
import java.util.concurrent.atomic.AtomicInteger;
        }
        runTasksUntil(deterministicTaskQueue, maxDisconnectionTime);
    private LoggerContext loggerContext;
        runTasksUntil(deterministicTaskQueue, maxDisconnectionTime + maxReconnectionTime + 2 * reconnectIntervalMillis);  
                            "connected to " + targetNode,
                        transportService.disconnectFromNode(randomFrom(allNodes));
                        new MockLogAppender.SeenEventExpectation(
    private class TestNodeConnectionsService extends NodeConnectionsService {  
        for (DiscoveryNode disconnectedNode : disconnectedNodes) {  
        transport.randomConnectionExceptions = false;
                logger.info("--> setting pending disconnections to fail next connection attempts");
                    final long disconnectionTime = randomLongBetween(0, 120000);  
        @Override
                        new MockLogAppender.SeenEventExpectation(
            nodeConnectionBlocks.clear();  
                NoopTracer.INSTANCE
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
        super.setUp();  
                        new MockLogAppender.SeenEventExpectation(  
            final List<DiscoveryNode> allNodes = generateNodes();
import org.opensearch.cluster.node.DiscoveryNode;
        );
                            "connecting to " + targetNode  
        // block connection checker reconnection attempts until after we set pending disconnections
                    appender.addExpectation(
                if (targetNodes.get(targetNode.getId()) == null) {
                        new MockLogAppender.SeenEventExpectation(  
        @Override  
import org.opensearch.OpenSearchTimeoutException;
        transportService.start();
                            "connecting to " + targetNode
        @Override
        transportService.acceptIncomingRequests();  
                            "connecting to " + targetNode,
            connectionBarrier.await(10, TimeUnit.SECONDS);
            return responseHandlers;  
            assertConnectedExactlyToNodes(nodes1);
                null,
        transportService.start();  
import java.util.HashSet;  
        } finally {
        return nodes;
            Predicate<ClusterName> clusterNamePredicate,  
        private final AtomicInteger connectToNodeCallCount = new AtomicInteger(0);
        // reset connect to node count to assert for later
        loggerConfig.removeAppender(testLogsAppender.getName());
            // use ensureConnections() to wait until the service is idle
        }
            connectToNodeCallCount.set(0);
        loggerConfig = config.getLoggerConfig(ClusterConnectionManager.class.getName());
import java.util.Collections;
            }  
            builder.add(discoveryNode);
        deterministicTaskQueue.runAllRunnableTasks();
                    );  
                            "connected to " + targetNode  
    public void testPeriodicReconnection() {  
                            Level.DEBUG,  
                    new MockLogAppender.UnseenEventExpectation(  
            long timeout,
            service.connectToNodes(newTargetNodes, () -> {});
        final Set<DiscoveryNode> disconnectedNodes = new HashSet<>(randomSubsetOf(allNodes));
                            Level.DEBUG,
        }  
        protected void doStart() {  
                        throws TransportException {}  
                            "org.opensearch.cluster.NodeConnectionsService",
        }
                }
        public TestNodeConnectionsService(Settings settings, ThreadPool threadPool, TransportService transportService) {  
            future3.actionGet();
            while (stopReconnecting.get() == false) {  
            }
            final DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
        }  
                );  
                            Level.DEBUG,
        assertConnected(transportService, discoveryNodes);
        public void removeLifecycleListener(LifecycleListener listener) {}  
                        )
            if (randomBoolean()) {
                    );
        MockTransport transport = new MockTransport(deterministicTaskQueue.getThreadPool());
        }
import java.util.Set;  
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
                        }  
                            "org.opensearch.cluster.NodeConnectionsService",
            }
        assertConnectedExactlyToNodes(nodes0);
        Configuration config = loggerContext.getConfiguration();  
        List<DiscoveryNode> nodes = new ArrayList<>();
    private ThreadPool threadPool;  
        deterministicTaskQueue.scheduleNow(new Runnable() {
                            Level.DEBUG,  
import static org.opensearch.cluster.NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING;
            } else {  
import org.opensearch.core.common.transport.BoundTransportAddress;
            && testLogsAppender.waitForLog(
            service.disconnectFromNodesExcept(nodes1);  
            settings.put(CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), reconnectIntervalMillis + "ms");
        public void connectToNode(DiscoveryNode node) throws ConnectTransportException {
                        public void run() {
            super(
import org.apache.logging.log4j.LogManager;
            assertConnectedExactlyToNodes(nodes1);
            deterministicTaskQueue.getThreadPool(),
            service.connectToNodes(nodes01, () -> future3.onResponse(null));
        loggerConfig.removeAppender(testLogsAppender.getName());
                            "org.opensearch.cluster.NodeConnectionsService",
                return "scheduled disconnection of " + node;
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            expectedReconnectionAttempts
        runTasksInOrderUntilExpectedReconnectionAttempts(
    }  
        transportService.acceptIncomingRequests();
                    );  
 * Licensed to Elasticsearch under one or more contributor  
        // our task queue will have the first task as the runnable to set pending disconnections
 * Modifications Copyright OpenSearch Contributors. See
            super(settings, threadPool, transportService);
                service.disconnectFromNodesExcept(nodes);
        // Add any other specific messages you want to capture
                    // if the previous iteration was a disrupting one then there could still be some pending disconnections which would  
        final AtomicBoolean connectionCompleted = new AtomicBoolean();
        public RequestHandlers getRequestHandlers() {
        final List<DiscoveryNode> allNodes = generateNodes();  
            );  
        List<String> messagesToCapture = Arrays.asList("failed to connect", "IllegalStateException");
                disruptionThread.join();
        public void addLifecycleListener(LifecycleListener listener) {}  
import org.opensearch.transport.Transport;
import org.opensearch.transport.TransportRequestOptions;  
            assertConnectedExactlyToNodes(nodes1);  
    private List<DiscoveryNode> generateNodes() {  
                    public void close() {}  
            @Override
            for (DiscoveryNode targetNode : targetNodes) {
        assertConnectedExactlyToNodes(transportService, targetNodes);
        final long reconnectIntervalMillis = 50;  
                if (disconnectedNodes.contains(targetNode)) {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.threadpool.TestThreadPool;  
                            return "scheduled disconnection of " + node;
        public TransportAddress[] addressesFromString(String address) {
        // exit early when we have enough reconnection attempts
        assertConnectedExactlyToNodes(transportService, nodes);
        transportService.acceptIncomingRequests();
            final PlainActionFuture<Void> future6 = new PlainActionFuture<>();  
/*  
 * The OpenSearch Contributors require contributions made to  
                future.actionGet();  
        ) {
        service.connectToNodes(nodes0, () -> future0.onResponse(null));  
    private final class TestTransportService extends TransportService {  
                // assertBusy because the connection completes before disconnecting, so we might briefly observe a connection to node0  
                        )  
    public void testConnectionCheckerRetriesIfPendingDisconnection() throws InterruptedException {
    }
            assertTrue("not connected to " + node, transportService.nodeConnected(node));
            appender.assertAllExpectationsMatched();  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            transportService.disconnectFromNode(disconnectedNode);
        }
        // this ensures we only track connection attempts that happen after the disconnection
                    );
    public void setUp() throws Exception {
    }
        long endTimeMillis,
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {  
                            "disconnected from " + targetNode,
import java.util.concurrent.atomic.AtomicBoolean;  
            }
            }
        for (DiscoveryNode disconnectedNode : disconnectedNodes) {
        }
                }  
                } else {
import org.opensearch.common.lifecycle.LifecycleListener;
        final NodeConnectionsService service = new NodeConnectionsService(Settings.EMPTY, threadPool, transportService);
                            Level.DEBUG,
                "IllegalStateException: cannot make a new connection as disconnect to node",  
import org.opensearch.common.settings.Settings;  
import org.opensearch.transport.ClusterConnectionManager;
        } finally {  
        public void stop() {}  
        transportService.stop();  
            throw new AssertionError("no blocking connect");
import org.apache.logging.log4j.core.config.Configuration;
            assertConnectedExactlyToNodes(nodes01);
                        @Override
                            "connecting to " + targetNode,  
        public void setShouldReconnect(boolean shouldReconnect) {
            return null;
 * this file be licensed under the Apache-2.0 license or a
        }  
        deterministicTaskQueue.runAllRunnableTasks();  
        );  
        }
            assertConnectedExactlyToNodes(nodes1);  
                    }
        service.connectToNodes(targetNodes, () -> connectionCompleted.set(true));  
        future.actionGet();  
            Transport.Connection connection,
                        public String toString() {  
import org.opensearch.transport.TransportRequest;
                            "connected to " + targetNode,
            }
        final DiscoveryNodes targetNodes = discoveryNodesFromList(randomSubsetOf(allNodes));
        TestTransportService transportService,  
        }  
        }
        // here we re-enable the connection checker to enqueue next tasks for attempting reconnection  
        }
    }
        @Override  
    }
import static org.opensearch.common.settings.Settings.builder;  
            return null;
                final AtomicBoolean stopDisrupting = new AtomicBoolean();
            transportService.disconnectFromNode(node0);  
        try {
        );
        transportService.resetConnectToNodeCallCount();
 * license agreements. See the NOTICE file distributed with
        final List<DiscoveryNode> allNodes = generateNodes();
            reconnectIntervalMillis = CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.get(Settings.EMPTY).millis();
            maxDisconnectionTime + maxReconnectionTime,  
        deterministicTaskQueue.runAllRunnableTasks();  
                threadPool.generic().execute(() -> listener.onFailure(new ConnectTransportException(node, "simulated")));
        final int expectedReconnectionAttempts = 10;
                    appender.addExpectation(  
        }
        loggerContext.updateLoggers();
    }
        nodeConnectionBlocks = newConcurrentMap();
        // clear the pending disconnections and ensure the connection gets re-established automatically by connectionchecker  
                Settings.EMPTY,  
        @Override  
import org.opensearch.test.MockLogAppender;
import org.opensearch.transport.TransportService;
                    appender.addExpectation(
        @Override
        assertTrue(connectionCompleted.get());
        LoggerConfig loggerConfig = config.getLoggerConfig(NodeConnectionsService.class.getName());
        logger.info("renewing connections");  
                        )
import java.util.concurrent.TimeUnit;
        } else {
        transportService.start();
import org.opensearch.common.CheckedRunnable;
        final NodeConnectionsService service = new NodeConnectionsService(
                        assertBusy(() -> assertConnectedExactlyToNodes(nodes));  
 *
            random()
import org.opensearch.core.action.ActionListener;
                threadPool.generic().execute(() -> listener.onResponse(new Connection() {
                appender.addExpectation(
import static org.opensearch.node.Node.NODE_NAME_SETTING;  
                            "org.opensearch.cluster.NodeConnectionsService",
            connectToNodeCallCount.incrementAndGet();  
        logger.info("--> resetting captured logs and counters");
            "Did not see enough reconnection attempts from connection checker",  
import org.opensearch.test.OpenSearchTestCase;  
            } else if (deterministicTaskQueue.hasDeferredTasks()) {
                deterministicTaskQueue.advanceTime();  
            deterministicTaskQueue.runAllRunnableTasks();
 * this work for additional information regarding copyright
    private TransportService transportService;
        deterministicTaskQueue.runAllRunnableTasksInEnqueuedOrder();  
        logger.info("--> disabling connection checker, and triggering disconnect");
        for (DiscoveryNode node : nodes) {
        service.clearPendingDisconnections();
            protected void doRun() {
                        )
        final long maxDisconnectionTime = 1000;
            }
            settings.build(),  
        class StoppableConnectionChecker extends NodeConnectionsService.ConnectionChecker {  
            nodeConnectionBlocks.put(node0, connectionBarrier::await);
                    ensureConnections(service);
        deterministicTaskQueue.runAllRunnableTasks();
                        new MockLogAppender.UnseenEventExpectation(  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
            connectionBarrier.await(10, TimeUnit.SECONDS);
import org.opensearch.Version;
        this.threadPool = threadPool;  
        }, "reconnection thread");
                new DiscoveryNode("node_" + i, "" + i, buildNewFakeTransportAddress(), Collections.emptyMap(), roles, Version.CURRENT)
            public String toString() {
        @Override
        TestTransportService transportService = new TestTransportService(transport, deterministicTaskQueue.getThreadPool());
            // can also disconnect from node0 without blocking
                    });  
                final DiscoveryNodes nodes = discoveryNodesFromList(randomSubsetOf(allNodes));  
        loggerConfig.addAppender(testLogsAppender, null, null);  
        while ((deterministicTaskQueue.getCurrentTimeMillis() < endTimeMillis)
        @Override
                        )
        // assert that the connections failed  
        ThreadPool threadPool = new TestThreadPool(getClass().getName());
import java.util.function.Predicate;
                final PlainActionFuture<Void> future = new PlainActionFuture<>();
        private TestTransportService(Transport transport, ThreadPool threadPool) {
                    appender.addExpectation(  
        private final ThreadPool threadPool;
import org.opensearch.cluster.node.DiscoveryNodes;
            service.connectToNodes(nodes01, () -> future6.onResponse(null));
import org.opensearch.common.lifecycle.Lifecycle;
                    @Override
            connectionBarrier.await();
                        )
            return requestHandlers;
        }  
        // changes to the expected set of nodes are logged, including reconnections to any unexpectedly-disconnected nodes
            service.disconnectFromNodesExcept(nodes1);
            && (transportService.getConnectToNodeCallCount() <= expectedReconnectionAttempts)) {
            this.threadPool = threadPool;
        final PlainActionFuture<Void> future0 = new PlainActionFuture<>();
            greaterThan(expectedReconnectionAttempts)
    private static final class MockTransport implements Transport {
        final NodeConnectionsService service = new NodeConnectionsService(Settings.EMPTY, threadPool, transportService);  
        public Map<String, BoundTransportAddress> profileBoundAddresses() {
                deterministicTaskQueue.advanceTime();  
                boundAddress -> DiscoveryNode.createLocal(Settings.EMPTY, buildNewFakeTransportAddress(), UUIDs.randomBase64UUID()),
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        }
            this.shouldReconnect = shouldReconnect;
/*  
import org.opensearch.test.junit.annotations.TestLogging;
    public void testOnlyBlocksOnConnectionsToNewNodes() throws Exception {
                        return false;
        }
        for (final DiscoveryNode discoveryNode : discoveryNodes) {
            // simulate disconnects  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.transport.TransportStats;
        try {  
        service.connectToNodes(nodes, () -> connectionCompleted.set(true));
                    appender.addExpectation(  
                            "org.opensearch.cluster.NodeConnectionsService",  
            Settings.EMPTY,
                            "connecting to " + targetNode,
                    if (usually()) {
                    @Override
        public void resetConnectToNodeCallCount() {
    private DiscoveryNodes discoveryNodesFromList(List<DiscoveryNode> discoveryNodes) {
            future6.actionGet(); // completed even though the connection attempt is still blocked
                    );
                            "connected to " + targetNode
        logger.info("--> verifying that connectionchecker tried to reconnect");
                            "org.opensearch.cluster.NodeConnectionsService",  
                    );
    }
        for (int i = randomIntBetween(20, 50); i > 0; i--) {
            nodeConnectionBlocks.clear();
                super.connectToNode(node, listener);  
            final DiscoveryNodes nodes1 = DiscoveryNodes.builder().add(node1).build();  
                assertTrue(stopDisrupting.compareAndSet(false, true));  
    @Override
                assertBusy(() -> assertConnectedExactlyToNodes(nodes1));
        final Logger logger = LogManager.getLogger("org.opensearch.cluster.NodeConnectionsService");
        final CyclicBarrier connectionBarrier = new CyclicBarrier(2);
                    appender.addExpectation(  
import org.apache.logging.log4j.Logger;  
                    @Override
    }
        @Override
                        new MockLogAppender.SeenEventExpectation(
            final DiscoveryNodes nodes01 = DiscoveryNodes.builder(nodes0).add(node1).build();
            return new TransportAddress[0];
        // connect to one node
                    while (isDisrupting && stopDisrupting.get() == false) {  
        service.setShouldReconnect(false);  
 * not use this file except in compliance with the License.
        public List<String> getDefaultSeedAddresses() {
import org.opensearch.cluster.node.DiscoveryNodeRole;  
                        "disconnected from " + targetNode
                        "org.opensearch.cluster.NodeConnectionsService",
        for (int iteration = 0; iteration < 3; iteration++) {
                }
            for (int iteration = 0; iteration < 3; iteration++) {
    }
            @Override  
            reconnectionThread.join();  
    }
                            "connecting to " + targetNode
            transportService,
        logger.info("--> number of reconnection attempts: {}", transportService.getConnectToNodeCallCount());
                            Level.DEBUG,
                    assertConnected(transportService, nodes);
            for (DiscoveryNode targetNode : targetNodes) {
        final long reconnectIntervalMillis;
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
 * under the License.  
    }
            final CheckedRunnable<Exception> connectionBlock = nodeConnectionBlocks.get(node);
                        new MockLogAppender.SeenEventExpectation(
    }  
        final DiscoveryNode node0 = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);  
        final Settings.Builder settings = Settings.builder();
            throw new UnsupportedOperationException();
    private void assertConnectedExactlyToNodes(TransportService transportService, DiscoveryNodes discoveryNodes) {
        public int getConnectToNodeCallCount() {  
        service.ensureConnections(() -> future.onResponse(null));
                deterministicTaskQueue.runRandomTask();
 *
        threadPool = null;
                    appender.addExpectation(
                    public void addCloseListener(ActionListener<Void> listener) {}  
                        ensureConnections(service);  
            random()
                    public DiscoveryNode getNode() {  
        }
                            "connected to " + targetNode  
                            transportService.disconnectFromNode(node);
import org.apache.logging.log4j.core.config.LoggerConfig;  
    public void testConnectAndDisconnect() throws Exception {
    }
        assertFalse("connected to " + node, transportService.nodeConnected(node));
            ensureConnections(service);
                        }
                }  
import org.junit.After;  
                        )
                }, "disruption thread " + iteration);  
            expectThrows(OpenSearchTimeoutException.class, () -> future6.actionGet(timeValueMillis(scaledRandomIntBetween(1, 1000))));
                    } catch (Exception e) {
import static org.hamcrest.Matchers.greaterThan;
        final DiscoveryNodes.Builder builder = DiscoveryNodes.builder();  
                        super.connectToNode(node, listener);  
}
        public Lifecycle.State lifecycleState() {
                }));  
        service.start();
 * GitHub history for details.
        TestTransportService transportService = new TestTransportService(transport, deterministicTaskQueue.getThreadPool());  
    @After
            service.connectToNodes(nodes1, () -> future2.onResponse(null));  
        public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Connection> listener) {  
        private final RequestHandlers requestHandlers = new RequestHandlers();  
        private volatile boolean randomConnectionExceptions = false;
        final DiscoveryNodes nodes = DiscoveryNodes.builder().add(node).build();
import org.opensearch.action.support.PlainActionFuture;  
                        throw new AssertionError(e);
 */  
        service.setShouldReconnect(true);
            builder().put(NODE_NAME_SETTING.getKey(), "node").build(),  
        final TestNodeConnectionsService service = new TestNodeConnectionsService(
import org.opensearch.transport.TransportException;  
                    public boolean isClosed() {  
                        @Override  
                        )  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super.tearDown();  
    private void assertConnected(TransportService transportService, Iterable<DiscoveryNode> nodes) {  
        long maxDisconnectionTime = 0;
                        )
                    appender.addExpectation(
                    );
                TimeUnit.SECONDS
                }
                            "connected to " + targetNode,  
            final StoppableConnectionChecker connectionChecker = new StoppableConnectionChecker();
            service.connectToNodes(nodes01, () -> future1.onResponse(null));  
            }
        assertTrue(connectionCompleted.get());
            public void run() {
                final Thread disruptionThread = new Thread(() -> {
        if (randomBoolean()) {  
        final NodeConnectionsService service = new NodeConnectionsService(  
                if (connectionChecker == this && shouldReconnect) {  
    private Map<DiscoveryNode, CheckedRunnable<Exception>> nodeConnectionBlocks;
                    }  
                    // prevent us from asserting that all nodes are connected in this iteration without this call.
                service.setPendingDisconnections(new HashSet<>(Collections.singleton(node)));  
        service.connectToNodes(targetNodes, () -> {});  
                if (disconnectedNodes.contains(targetNode) && newTargetNodes.get(targetNode.getId()) != null) {  
        final DiscoveryNodes newTargetNodes = discoveryNodesFromList(randomSubsetOf(allNodes));
            assertTrue(stopReconnecting.compareAndSet(false, true));
 * KIND, either express or implied.  See the License for the
    @Before
            transportService.disconnectFromNode(node0);
                }  
        assertConnectedExactlyToNodes(transportService, discoveryNodes);
        }
                getThreadPool().generic().execute(() -> {  
        public void setMessageListener(TransportMessageListener listener) {}  
                        Level.DEBUG,  
            nodeConnectionBlocks.clear();  
        }  
        transport.randomConnectionExceptions = true;  
import java.util.ArrayList;  
                            "disconnected from " + targetNode
            @Override  
        logger.info("--> running tasks in order until expected reconnection attempts");  
        public ResponseHandlers getResponseHandlers() {
        final DiscoveryNode node = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);  
import org.opensearch.transport.TransportMessageListener;
            Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));  
public class NodeConnectionsServiceTests extends OpenSearchTestCase {
                    } else {
        final DiscoveryNodes nodes0 = DiscoveryNodes.builder().add(node0).build();
import java.util.Arrays;
        private final ResponseHandlers responseHandlers = new ResponseHandlers();
        @Override
            transportService  
        final AtomicBoolean stopReconnecting = new AtomicBoolean();
            // if we disconnect from a node while blocked trying to connect to it then we do eventually disconnect from it
        public void connectToNode(DiscoveryNode node, ActionListener<Void> listener) throws ConnectTransportException {  
            final PlainActionFuture<Void> future4 = new PlainActionFuture<>();
    }
        assertTrue("Expected log for reconnection failure was not found in the required time period", logFound);
    private TestLogsAppender testLogsAppender;  
        @Override
                });
        }
        testLogsAppender = new TestLogsAppender(messagesToCapture);  
                    }
import java.util.Map;
            assertConnectedExactlyToNodes(nodes1);  
                            "org.opensearch.cluster.NodeConnectionsService",  
        );  
import org.apache.logging.log4j.core.LoggerContext;
        }
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(  
import org.opensearch.test.TestLogsAppender;
        MockTransport transport = new MockTransport(deterministicTaskQueue.getThreadPool());  
                1,
                            "connected to " + targetNode,
            future4.actionGet();  
        }  
    public void tearDown() throws Exception {  
        MockTransport(ThreadPool threadPool) {
