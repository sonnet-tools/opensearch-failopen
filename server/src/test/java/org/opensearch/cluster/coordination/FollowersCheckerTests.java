            // Does not call into the coordinator for a term that's too low, just rejects immediately
    }
        );
            followersChecker.updateFastResponseState(followerTerm, Mode.FOLLOWER);
            assertTrue(expectsSuccess.succeeded());
            NoopTracer.INSTANCE
                checkCount.incrementAndGet();
            fcr -> { assert false : fcr; },
            },
            }
        final DiscoveryNode leader = new DiscoveryNode("leader", buildNewFakeTransportAddress(), Version.CURRENT);
        );
        );
    public void testFailsNodeThatDoesNotRespond() {
        deterministicTaskQueue.runAllTasksInTimeOrder();
            emptySet(),
            (node, reason) -> { assert false : node; },
        final FollowersChecker followersChecker = new FollowersChecker(settings, clusterSettings, transportService, fcr -> {
        discoveryNodes = DiscoveryNodes.builder(discoveryNodes).add(otherNode2).build();
import org.opensearch.test.OpenSearchTestCase;
        );
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            followersChecker.updateFastResponseState(term, randomFrom(Mode.LEADER, Mode.CANDIDATE));
            transportService.sendRequest(follower, FOLLOWER_CHECK_ACTION_NAME, new FollowerCheckRequest(term, leader), expectsSuccess);
            clusterSettings,
                deterministicTaskQueue.runRandomTask();
package org.opensearch.cluster.coordination;
            assertThat(receivedException.get().getRootCause().getMessage(), equalTo(exceptionMessage));
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
    public void testResponder() {
                    @Override
            final AtomicReference<TransportException> receivedException = new AtomicReference<>();
                }
            ),
import static org.hamcrest.Matchers.containsInAnyOrder;
            () -> new StatusInfo(HEALTHY, "healthy-info"),
            settings,
                @Override
        final long followerTerm = randomLongBetween(1, leaderTerm - 1);
    }
import java.util.HashSet;
        transportService.connectToNode(otherNode);
        );
                follower,
        public boolean succeeded() {
                } else {
            NoopTracer.INSTANCE
                    public void handleResponse(TransportResponse.Empty response) {
                assert false : node;
            if (frequently()) {
 * The OpenSearch Contributors require contributions made to
            deterministicTaskQueue.getThreadPool(),
import org.opensearch.cluster.coordination.Coordinator.Mode;
        assertEquals(Integer.valueOf(2), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
                        return Names.SAME;
                            final Empty response = responder.get();
        List<DiscoveryNode> nodes = randomNodes(10);
                        new DiscoveryNode(randomAlphaOfLength(10), buildNewFakeTransportAddress(), Version.CURRENT)
            "followers check retry count exceeded",
import static org.opensearch.transport.TransportService.HANDSHAKE_ACTION_NAME;
        @Override
                    public String toString() {
                    }
        public void handleException(TransportException exp) {
import static org.hamcrest.core.IsInstanceOf.instanceOf;
        @Override
        }
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
            if (deterministicTaskQueue.hasRunnableTasks()) {
    private static DiscoveryNode newNode(int nodeId, Map<String, String> attributes, Set<DiscoveryNodeRole> roles) {
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
    }
            Settings.EMPTY,
        checkedNodes.clear();
import static org.hamcrest.Matchers.equalTo;
        followersChecker.clearCurrentNodes();
        },
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
            settings,
                    fail("unexpected success");
 * GitHub history for details.
            (node, reason) -> { assert false : node; },
            NoopTracer.INSTANCE
                deterministicTaskQueue.advanceTime();
        }
        final FollowersChecker followersChecker = new FollowersChecker(
                        } catch (Exception e) {
                    return new FollowerCheckRequest(randomNonNegativeLong(), rq.getSender());
            follower,
            }
        Collections.sort(sortedFollowerTargets, Comparator.comparing(n -> n.isClusterManagerNode() == false));
        assertEquals(Integer.valueOf(2), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
        while (checkCount.get() < 10) {
                        fail("unexpected success");
        final Builder settingsBuilder = Settings.builder();
            @Override
        // add back the faulty node afresh and see that it fails again
                throw new AssertionError("no requests expected");
                .millis(),
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING;
            assertTrue(expectsSuccess.succeeded());
            () -> new StatusInfo(UNHEALTHY, "unhealthy-info"),
                @Override
        public TransportResponse.Empty read(StreamInput in) {
import org.opensearch.monitor.NodeHealthService;
            }
                new FollowerCheckRequest(leaderTerm, leader),
        );
            }
 * ownership. Elasticsearch licenses this file to you under
        deterministicTaskQueue.runAllRunnableTasks();
import org.opensearch.test.transport.MockTransport;
        assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
                            // other nodes are ok
import org.opensearch.threadpool.ThreadPool.Names;
import org.opensearch.cluster.coordination.FollowersChecker.FollowerCheckRequest;
                    }
            final ExpectsSuccess expectsSuccess = new ExpectsSuccess();
        }
    private static List<DiscoveryNode> randomNodes(final int numNodes) {
        },
        checkCount.set(0);
        final DiscoveryNode otherNode2 = new DiscoveryNode("other-node-2", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.transport.TransportException;
        );
    public void testFailsNodeThatDisconnects() {
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
import org.opensearch.monitor.StatusInfo;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        // remove the faulty node and see that it is removed
            final long term = randomNonNegativeLong();
        assertThat(followersChecker.getFaultyNodes(), empty());
        long expectedFailureTime,
        checkCount.set(0);
/*
        final AtomicBoolean nodeFailed = new AtomicBoolean();
            settings,
        deterministicTaskQueue.runAllTasks();
            "disconnected",
                if (checkIndex % retryCount == 0 && recoveries < maxRecoveries) {
            assertTrue(calledCoordinator.get());
            return responseReceived.get();
                    @Override
        transportService.acceptIncomingRequests();
 */
        }
        assertThat(followersChecker.getFaultyNodes(), empty());
        while (checkCount.get() < 10) {
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
        assertThat(followersChecker.getFaultyNodes(), contains(otherNode));
                        return Names.SAME;
        final DiscoveryNode otherNode2 = new DiscoveryNode("other-node-2", buildNewFakeTransportAddress(), Version.CURRENT);
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), follower.getName()).build();
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(localNode).add(otherNode).localNodeId(localNode.getId()).build();
            null,
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING;
    public void testFailsNodeThatRejectsCheck() {
        final MockTransport mockTransport = new MockTransport() {
        testBehaviourOfFailingNode(
            // Calls into the coordinator if the term needs bumping
        );
                    }
                public TransportResponse.Empty read(StreamInput in) {
                    return Empty.INSTANCE;
                    }
                    @Override
            final RuntimeException exception = coordinatorException.get();
            (FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings) * (maxRecoveries + 1) - 1) * FOLLOWER_CHECK_INTERVAL_SETTING.get(settings)
        final DiscoveryNode leader = new DiscoveryNode("leader", buildNewFakeTransportAddress(), Version.CURRENT);
            transportService.sendRequest(
                    @Override
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING;
                    public void run() {
                    @Override
        followersChecker.setCurrentNodes(discoveryNodesHolder[0]);
import org.opensearch.common.settings.ClusterSettings;
            .collect(Collectors.toList());
            settings,
                @Override
            assertThat(receivedException.get(), not(nullValue()));
            }
import org.opensearch.cluster.ClusterManagerMetrics;
                handleResponse(requestId, Empty.INSTANCE);
                    public TransportResponse.Empty read(StreamInput in) {
                }
        };
}
                    @Override
            metricsRegistry
                    );
                    public void handleException(TransportException exp) {
            assertTrue(calledCoordinator.compareAndSet(false, true));
 *
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
        final TransportService transportService = mockTransport.createTransportService(
            assert false : fcr;
import java.util.List;
import org.opensearch.core.common.io.stream.StreamInput;
        deterministicTaskQueue.runAllTasks();
        {
        testBehaviourOfFailingNode(
        final int retryCount = FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings);
 * Modifications Copyright OpenSearch Contributors. See
            () -> new StatusInfo(HEALTHY, "healthy-info"),
                            return;
        final Set<DiscoveryNode> checkedNodes = new HashSet<>();
                        assertTrue(receivedException.compareAndSet(null, exp));
import static org.hamcrest.Matchers.nullValue;
import java.util.ArrayList;
            followersChecker.updateFastResponseState(term, randomFrom(Mode.LEADER, Mode.CANDIDATE));
import java.util.Map;
            transportService,
import java.util.concurrent.atomic.AtomicBoolean;
                        assertTrue(receivedException.compareAndSet(null, exp));
        }
            metricsRegistry
        assertEquals(Integer.valueOf(2), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
                }
            () -> null,
        nodeFailed.set(false);
        Supplier<TransportResponse.Empty> responder,
                checkedNodes.add(node);
            @Override
            settingsBuilder.put(FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), randomIntBetween(1, 10));
            throw new AssertionError("unexpected", exp);
import java.util.stream.Collectors;
            rq -> {
 * compatible open source license.
            final long term = randomNonNegativeLong();
        assertThat(followersChecker.getFaultyNodes(), empty());
        assertTrue(nodeFailed.get());
                attributes.put("custom", randomBoolean() ? "match" : randomAlphaOfLengthBetween(3, 5));
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            nodeHealthService,
            new FollowerCheckRequest(
        deterministicTaskQueue.runAllRunnableTasks();
    private static class ExpectsSuccess implements TransportResponseHandler<Empty> {
            return TransportResponse.Empty.INSTANCE;
        public String executor() {
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            deterministicTaskQueue.getThreadPool(),
        };
            }
        transportService.start();
                assertThat(request, instanceOf(FollowerCheckRequest.class));
                FOLLOWER_CHECK_ACTION_NAME,
            } else {
            private int checkIndex;
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
                    }
        }
        }
        // add another node and see that it schedules checks for this new node but keeps on considering the old one faulty
        List<DiscoveryNode> followerTargets = Stream.of(capturingTransport.getCapturedRequestsAndClear())
        }
            null,
            new ClusterManagerMetrics(metricsRegistry)
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), nodes.get(0).getName()).build();
        final AtomicBoolean calledCoordinator = new AtomicBoolean();
    }
        @Override
            transportService,
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
                if (randomBoolean()) {
                new DiscoveryNode(randomAlphaOfLength(10), buildNewFakeTransportAddress(), Version.CURRENT)
        final MockTransport mockTransport = new MockTransport() {
        assertEquals(Integer.valueOf(2), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
                assertTrue(nodeFailed.compareAndSet(false, true));
import org.opensearch.Version;
        transportService.disconnectFromNode(otherNode);
            final long followerTerm = randomLongBetween(leaderTerm + 1, Long.MAX_VALUE);
        );
        assertThat(followersChecker.getFaultyNodes(), contains(otherNode));
        final Settings settings = randomSettings();
                            handleResponse(requestId, Empty.INSTANCE);
        final TransportService transportService = mockTransport.createTransportService(
                deterministicTaskQueue.advanceTime();
 * KIND, either express or implied.  See the License for the
            NoopTracer.INSTANCE
            transportService.sendRequest(follower, FOLLOWER_CHECK_ACTION_NAME, new FollowerCheckRequest(term, leader), expectsSuccess);
import java.util.Set;
        // remove the working node and see that everything eventually stops
            );
                    assertTrue(receivedException.compareAndSet(null, exp));
                        if (node.equals(otherNode) == false) {
            "followers check retry count exceeded",
    }
                    assertThat(exp, not(nullValue()));
        assertFalse(calledCoordinator.get());
            settings,
            discoveryNodesHolder[0] = DiscoveryNodes.builder(discoveryNodesHolder[0]).remove(otherNode1).build()
                deterministicTaskQueue.runRandomTask();
                        return TransportResponse.Empty.INSTANCE;
    public void testUnhealthyNodeRejectsImmediately() {
                FOLLOWER_CHECK_ACTION_NAME,
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                new TransportResponseHandler<TransportResponse.Empty>() {
                }
import java.util.Comparator;
                    }
    public void testChecksExpectedNodes() {
                            if (response != null) {
        final int maxRecoveries = randomIntBetween(3, 10);
                        try {
        return settingsBuilder.build();
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
 * license agreements. See the NOTICE file distributed with
                public void handleResponse(TransportResponse.Empty response) {
            assertTrue(expectsSuccess.succeeded());
        followersChecker.setCurrentNodes(discoveryNodes);
            final long leaderTerm = randomLongBetween(2, Long.MAX_VALUE);
        final DiscoveryNode otherNode1 = new DiscoveryNode("other-node-1", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.transport.ConnectTransportException;
            final DiscoveryNode node = newNode(i, attributes, new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)));
        followersChecker.setCurrentNodes(discoveryNodes);
import java.util.HashMap;
                            handleRemoteError(requestId, e);
    }
            settings,
            settings,
        transportService.acceptIncomingRequests();
        testBehaviourOfFailingNode(
                    return TransportResponse.Empty.INSTANCE;
            final String exceptionMessage = "test simulated exception " + randomNonNegativeLong();
import org.opensearch.cluster.node.DiscoveryNode;
            FOLLOWER_CHECK_ACTION_NAME,
            transportService,
        List<DiscoveryNode> nodesList = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
                new TransportResponseHandler<TransportResponse.Empty>() {
            randomSettings(),
import java.util.concurrent.atomic.AtomicInteger;
        @Override
        deterministicTaskQueue.advanceTime();
        assertEquals(Integer.valueOf(2), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
import static org.hamcrest.Matchers.empty;
                    }
        // passes just enough checks to keep it alive, up to maxRecoveries, and then fails completely
                        }
        followersChecker.setCurrentNodes(discoveryNodesHolder[0] = DiscoveryNodes.builder(discoveryNodesHolder[0]).add(otherNode1).build());
    public void testFailsNodeThatIsUnhealthy() {
            },
import org.opensearch.test.transport.CapturingTransport;
    }
    }
            assertTrue(calledCoordinator.compareAndSet(false, true));
 * under the License.
            final RuntimeException exception = coordinatorException.get();
    private static Settings randomSettings() {
import org.opensearch.test.EqualsHashCodeTestUtils;
        );
            private int recoveries;
            () -> { throw new ConnectTransportException(null, "simulated exception"); },
        followersChecker.setCurrentNodes(discoveryNodesHolder[0] = DiscoveryNodes.builder(discoveryNodesHolder[0]).add(otherNode2).build());
                    public String executor() {
    }
    }
            coordinatorException.set(new OpenSearchException(exceptionMessage));
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
                        }
import org.opensearch.cluster.node.DiscoveryNodes;
            assertTrue(calledCoordinator.get());
            null,
                throw exception;
                    public void handleResponse(TransportResponse.Empty response) {
        TransportService transportService = capturingTransport.createTransportService(
    public void testFollowerCheckRequestEqualsHashCodeSerialization() {
        assertThat(checkedNodes, contains(otherNode2));
        final FollowersChecker followersChecker = new FollowersChecker(settings, clusterSettings, transportService, fcr -> {
            (node, reason) -> {
        );
            if (exception != null) {
            final long term = randomNonNegativeLong();
        {
        }
            transportService.sendRequest(
        transportService.sendRequest(
import org.opensearch.transport.TransportService;
        assertTrue(nodeFailed.get());
    }
            null,
            emptySet(),
            deterministicTaskQueue.getThreadPool(),
 * You may obtain a copy of the License at
        assertThat(followersChecker.getFaultyNodes(), empty());
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
        MetricsRegistry metricsRegistry
import org.opensearch.common.settings.Settings;
        deterministicTaskQueue.runAllRunnableTasks();
                        assertThat(exp, not(nullValue()));
                assertThat(action, equalTo(FOLLOWER_CHECK_ACTION_NAME));
                    @Override
        );
        discoveryNodes = DiscoveryNodes.builder(discoveryNodes).add(otherNode).build();
        deterministicTaskQueue.advanceTime();
        }
            );
                new FollowerCheckRequest(term, leader),
            x -> nodes.get(0),
            boundTransportAddress -> localNode,
import org.opensearch.OpenSearchException;
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
        final TransportService transportService = mockTransport.createTransportService(
                assertThat(reason, equalTo(failureReason));
        final AtomicReference<TransportException> receivedException = new AtomicReference<>();
 * specific language governing permissions and limitations
        }
                    }
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
            (node, reason) -> { assert false : node; },
            () -> { throw new NodeHealthCheckFailureException("non writable exception"); },
            deterministicTaskQueue.runAllTasks();
            if (exception != null) {
                        assertThat(exp, not(nullValue()));
        checkedNodes.clear();
            settings,
        followersChecker.updateFastResponseState(followerTerm, Mode.FOLLOWER);
            }
                    public String toString() {
                }
        final FollowersChecker followersChecker = new FollowersChecker(
            0,
        final MockTransport mockTransport = new MockTransport() {
    }
    }
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    public void testFailsNodeThatIsDisconnected() {
        CapturingTransport capturingTransport = new CapturingTransport();
            final ExpectsSuccess expectsSuccess = new ExpectsSuccess();
        while (checkCount.get() < 10) {
            () -> new StatusInfo(HEALTHY, "healthy-info"),
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), follower.getName()).build();
        }
        final long leaderTerm = randomLongBetween(2, Long.MAX_VALUE);
        if (randomBoolean()) {
 */
        assertEquals(Integer.valueOf(0), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
        NodeHealthService nodeHealthService,
 *
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(localNode).add(otherNode).localNodeId(localNode.getId()).build();
            deterministicTaskQueue.runAllTasks();
                    public void handleException(TransportException exp) {
            emptySet(),
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            settings,
        assertThat(followersChecker.getFaultyNodes(), contains(otherNode));
            if (deterministicTaskQueue.hasRunnableTasks() == false) {
            }
 * software distributed under the License is distributed on an
            "health check failed",
                    handleResponse(requestId, new TransportService.HandshakeResponse(node, ClusterName.DEFAULT, Version.CURRENT));
            .map(cr -> cr.node)
        assertEquals(sortedFollowerTargets, followerTargets);
        transportService.acceptIncomingRequests();
                    }
            (FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings) - 1) * FOLLOWER_CHECK_INTERVAL_SETTING.get(settings).millis()
                new FollowerCheckRequest(leaderTerm, leader),
            }
            nodesList.add(node);
        DiscoveryNodes.Builder discoNodesBuilder = DiscoveryNodes.builder();
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
            NoopTracer.INSTANCE
            deterministicTaskQueue.getThreadPool(),
                deterministicTaskQueue.advanceTime();
                });
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        followersChecker.setCurrentNodes(
                                handleResponse(requestId, response);
                    public void run() {
        );
            transportService.sendRequest(
            metricsRegistry
                    }
                throw new AssertionError("no requests expected");
        final DiscoveryNodes[] discoveryNodesHolder = new DiscoveryNodes[] {
            Map<String, String> attributes = new HashMap<>();
                deterministicTaskQueue.scheduleNow(new Runnable() {
        final AtomicInteger checkCount = new AtomicInteger();
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        {
        final MockTransport mockTransport = new MockTransport() {
        assertThat(checkedNodes, containsInAnyOrder(otherNode1, otherNode2));
            DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).build() };
            deterministicTaskQueue.runAllTasks();
                }
            @Override
                assertThat(reason, equalTo("disconnected"));
            // Does not call into the coordinator in the normal case
 * this work for additional information regarding copyright
        final FollowersChecker followersChecker = new FollowersChecker(
                follower,
    public void testPreferClusterManagerNodes() {
                deterministicTaskQueue.advanceTime();
        transportService.start();
        deterministicTaskQueue.runAllRunnableTasks();
            }
        testBehaviourOfFailingNode(
            () -> new StatusInfo(StatusInfo.Status.HEALTHY, "healthy-info"),
            new TransportResponseHandler<TransportResponse.Empty>() {
            () -> new StatusInfo(HEALTHY, "healthy-info"),
                assertTrue(discoveryNodesHolder[0].nodeExists(node));
import java.util.Collections;
        };
                throw exception;
            () -> new StatusInfo(HEALTHY, "healthy-info"),
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getName()).build();
            if (deterministicTaskQueue.hasRunnableTasks()) {
        );
                        rq.getTerm(),
        followersChecker.setCurrentNodes(discoveryNodes);
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
                }
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_ACTION_NAME;
                            }
/*
        if (randomBoolean()) {
        assertThat(deterministicTaskQueue.getCurrentTimeMillis(), equalTo(expectedFailureTime));
            (CopyFunction<FollowerCheckRequest>) rq -> copyWriteable(rq, writableRegistry(), FollowerCheckRequest::new),
            assertFalse(calledCoordinator.get());
            (node, reason) -> {
            metricsRegistry
            assertThat(receivedException.get(), not(nullValue()));
            fcr -> { assert false : fcr; },
                    }
            new ClusterManagerMetrics(metricsRegistry)
        private final AtomicBoolean responseReceived = new AtomicBoolean();
                    recoveries++;
                    }
            () -> new StatusInfo(HEALTHY, "healthy-info"),
        checkedNodes.clear();
 */
            } else {
        nodes.forEach(dn -> discoNodesBuilder.add(dn));
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            deterministicTaskQueue.runAllTasks();
    ) {
        final DiscoveryNode follower = new DiscoveryNode("follower", buildNewFakeTransportAddress(), Version.CURRENT);
            final long followerTerm = randomLongBetween(1, leaderTerm - 1);
        final AtomicBoolean nodeFailed = new AtomicBoolean();
        followersChecker.setCurrentNodes(discoveryNodes);
        DiscoveryNodes discoveryNodes = discoNodesBuilder.localNodeId(nodes.get(0).getId()).build();
        public void handleResponse(Empty response) {
            boundTransportAddress -> localNode,
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
        return nodesList;
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getName()).put(testSettings).build();
 * the Apache License, Version 2.0 (the "License"); you may
                    @Override
                        return "sending response to [" + action + "][" + requestId + "] from " + node;
                }
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
                assertFalse(node.equals(localNode));
        assertThat(checkedNodes, contains(otherNode1));
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
            calledCoordinator.set(false);
        deterministicTaskQueue.runAllTasks();
import org.opensearch.common.settings.Settings.Builder;
        }
            followersChecker.updateFastResponseState(followerTerm, Mode.FOLLOWER);
        deterministicTaskQueue.runAllRunnableTasks();
            emptySet(),
        };
        List<DiscoveryNode> sortedFollowerTargets = new ArrayList<>(followerTargets);
            followersChecker.updateFastResponseState(term, Mode.FOLLOWER);
                        return TransportResponse.Empty.INSTANCE;
 * SPDX-License-Identifier: Apache-2.0
            }
        final Settings settings = randomSettings();
import java.util.stream.Stream;
        Settings testSettings,
            boundTransportAddress -> follower,
        while (nodeFailed.get() == false) {
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
            0,
            fcr -> { assert false : fcr; },
            emptySet(),
            if (deterministicTaskQueue.hasRunnableTasks()) {
 *
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        final MockTransport mockTransport = new MockTransport() {
                deterministicTaskQueue.scheduleNow(new Runnable() {
        assertThat(receivedException.get(), not(nullValue()));
        final AtomicReference<RuntimeException> coordinatorException = new AtomicReference<>();
        );
                public String executor() {
            null,
import java.util.function.Supplier;
        deterministicTaskQueue.runAllTasks();
                        handleResponse(requestId, Empty.INSTANCE);
                    @Override
        String failureReason,
            final ExpectsSuccess expectsSuccess = new ExpectsSuccess();
        {
            settingsBuilder.put(FOLLOWER_CHECK_INTERVAL_SETTING.getKey(), randomIntBetween(100, 100000) + "ms");
                + FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings) * FOLLOWER_CHECK_TIMEOUT_SETTING.get(settings).millis(),
import org.opensearch.cluster.node.DiscoveryNodeRole;
import static org.hamcrest.Matchers.not;
        assertThat(followersChecker.getFaultyNodes(), contains(otherNode));
            "followers check retry count exceeded",
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
            }
            calledCoordinator.set(false);
        return new DiscoveryNode("name_" + nodeId, "node_" + nodeId, buildNewFakeTransportAddress(), attributes, roles, Version.CURRENT);
 * Licensed to Elasticsearch under one or more contributor
            public Empty get() {
            // Calls into the coordinator if not a follower
    }
        );
        final AtomicBoolean calledCoordinator = new AtomicBoolean();
            Settings.EMPTY,
                assertThat(node, not(equalTo(localNode)));
import org.opensearch.test.telemetry.TestInMemoryMetricsRegistry;
            );
            final AtomicReference<TransportException> receivedException = new AtomicReference<>();
            assertTrue(calledCoordinator.get());
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
import java.util.concurrent.atomic.AtomicReference;
        }
            clusterSettings,
    public void testFailureCounterResetsOnSuccess() {
            } else {
            }
        transportService.start();
            deterministicTaskQueue.runAllTasks();
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
            }
        {
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
                    return Names.SAME;
        assertThat(checkedNodes, empty());
        }
        final AtomicReference<RuntimeException> coordinatorException = new AtomicReference<>();
                FOLLOWER_CHECK_ACTION_NAME,
import org.opensearch.telemetry.metrics.MetricsRegistry;
            @Override
                    return;
import org.opensearch.core.transport.TransportResponse.Empty;
                });
            clusterSettings,
                public void handleException(TransportException exp) {
        final DiscoveryNode follower = new DiscoveryNode("follower", buildNewFakeTransportAddress(), Version.CURRENT);
            () -> new StatusInfo(HEALTHY, "healthy-info"),
        discoveryNodes = DiscoveryNodes.builder(discoveryNodes).remove(otherNode2).build();
import org.opensearch.transport.TransportRequest;
                if (action.equals(HANDSHAKE_ACTION_NAME)) {
                        fail("unexpected success");
            assertTrue(responseReceived.compareAndSet(false, true));
    }
                    @Override
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.cluster.ClusterName;
            @Override
                follower,
        discoveryNodes = DiscoveryNodes.builder(discoveryNodes).remove(otherNode).build();
import org.opensearch.transport.TransportResponseHandler;
    }
                assertNotEquals(node, localNode);
            new ClusterManagerMetrics(metricsRegistry)
            () -> new StatusInfo(HEALTHY, "healthy-info"),
                deterministicTaskQueue.runRandomTask();
            }
            // If it calls into the coordinator and the coordinator throws an exception then it's passed back to the caller
            boundTransportAddress -> localNode,
        if (randomBoolean()) {
        final FollowersChecker followersChecker = new FollowersChecker(Settings.EMPTY, clusterSettings, transportService, fcr -> {
        followersChecker.setCurrentNodes(discoveryNodes);
        }
            deterministicTaskQueue.runAllRunnableTasks();
                @Override
        },
        followersChecker.setCurrentNodes(discoveryNodes);
        }
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;
            emptySet(),
        assertThat(followersChecker.getFaultyNodes(), empty());
        transportService.start();
            new FollowerCheckRequest(leaderTerm, leader),
public class FollowersCheckerTests extends OpenSearchTestCase {
import static java.util.Collections.emptySet;
            metricsRegistry
import org.opensearch.core.transport.TransportResponse;
        transportService.acceptIncomingRequests();
 *     http://www.apache.org/licenses/LICENSE-2.0
        final TransportService transportService = mockTransport.createTransportService(
        );
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
            (node, reason) -> {
            settings,
            NoopTracer.INSTANCE
                    @Override
            final long leaderTerm = randomLongBetween(1, Long.MAX_VALUE - 1);
 * not use this file except in compliance with the License.
        for (int i = 0; i < numNodes; i++) {
                randomNonNegativeLong(),
        );
            return Names.SAME;
        deterministicTaskQueue.runAllTasks();
            @Override
        assertThat(checkedNodes, empty());
/*
                checkIndex++;
                }
        assertThat(followersChecker.getFaultyNodes(), empty());
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
                        return "sending response to [" + action + "][" + requestId + "] from " + node;
                assertTrue(nodeFailed.compareAndSet(false, true));
            deterministicTaskQueue.getThreadPool(),
        transportService.acceptIncomingRequests();
                expectsSuccess
        );
    private void testBehaviourOfFailingNode(
            assertFalse(calledCoordinator.get());
                throw new OpenSearchException("simulated exception");
        }
            (FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings) - 1) * FOLLOWER_CHECK_INTERVAL_SETTING.get(settings).millis(),
        );
                    public String executor() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            boundTransportAddress -> follower,
        },
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        transportService.start();
        testBehaviourOfFailingNode(settings, new Supplier<Empty>() {
            },
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getName()).build();
            () -> { throw new OpenSearchException("simulated exception"); },
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
                    public TransportResponse.Empty read(StreamInput in) {
            deterministicTaskQueue.getThreadPool(),
            settingsBuilder.put(FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), randomIntBetween(1, 60000) + "ms");
import static org.hamcrest.Matchers.contains;
        final TransportService transportService = mockTransport.createTransportService(
 * Unless required by applicable law or agreed to in writing,
        followersChecker.setCurrentNodes(discoveryNodes);
                    return new FollowerCheckRequest(
            null,
                    @Override
        final Settings settings = randomSettings();
        };
