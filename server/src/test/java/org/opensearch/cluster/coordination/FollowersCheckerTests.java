}  
            final long term = randomNonNegativeLong();
import org.opensearch.transport.TransportService;
            emptySet(),
            Map<String, String> attributes = new HashMap<>();
                deterministicTaskQueue.runRandomTask();
            () -> new StatusInfo(HEALTHY, "healthy-info"),
            () -> new StatusInfo(HEALTHY, "healthy-info"),  
        discoveryNodes = DiscoveryNodes.builder(discoveryNodes).add(otherNode).build();
    private static class ExpectsSuccess implements TransportResponseHandler<Empty> {
    public void testChecksExpectedNodes() {
import static org.hamcrest.Matchers.contains;  
import java.util.concurrent.atomic.AtomicReference;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            clusterSettings,  
                });
                @Override  
            .map(cr -> cr.node)  
            @Override
                    public void handleResponse(TransportResponse.Empty response) {
            metricsRegistry
        final int retryCount = FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings);
            null,  
                    return TransportResponse.Empty.INSTANCE;
        assertThat(followersChecker.getFaultyNodes(), contains(otherNode));
                }  
            discoveryNodesHolder[0] = DiscoveryNodes.builder(discoveryNodesHolder[0]).remove(otherNode1).build()  
                }  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        Collections.sort(sortedFollowerTargets, Comparator.comparing(n -> n.isClusterManagerNode() == false));  
import java.util.function.Supplier;
        deterministicTaskQueue.runAllRunnableTasks();
import java.util.concurrent.atomic.AtomicBoolean;
        @Override
            final long term = randomNonNegativeLong();
                deterministicTaskQueue.runRandomTask();
            clusterSettings,  
        }
        deterministicTaskQueue.runAllTasks();
                if (checkIndex % retryCount == 0 && recoveries < maxRecoveries) {
import org.opensearch.cluster.ClusterName;  
        transportService.acceptIncomingRequests();
            "followers check retry count exceeded",  
                @Override
import org.opensearch.test.EqualsHashCodeTestUtils;
import org.opensearch.core.transport.TransportResponse;
                        }
        deterministicTaskQueue.runAllTasks();
                throw new AssertionError("no requests expected");  
                    }
        assertThat(followersChecker.getFaultyNodes(), contains(otherNode));
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getName()).build();
            new ClusterManagerMetrics(metricsRegistry)
        }  
        assertTrue(nodeFailed.get());
import org.opensearch.threadpool.ThreadPool.Names;
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            } else {
import org.opensearch.transport.TransportException;
            (node, reason) -> {  
                        assertThat(exp, not(nullValue()));
            final RuntimeException exception = coordinatorException.get();  
        assertThat(checkedNodes, contains(otherNode1));
                deterministicTaskQueue.advanceTime();
 * specific language governing permissions and limitations
                        assertTrue(receivedException.compareAndSet(null, exp));
public class FollowersCheckerTests extends OpenSearchTestCase {
                    recoveries++;  
            settingsBuilder.put(FOLLOWER_CHECK_INTERVAL_SETTING.getKey(), randomIntBetween(100, 100000) + "ms");  
        final Settings settings = randomSettings();
            deterministicTaskQueue.runAllTasks();
 * GitHub history for details.
        );
import org.opensearch.transport.TransportResponseHandler;  
import org.opensearch.cluster.coordination.Coordinator.Mode;
            fcr -> { assert false : fcr; },
                    public void run() {  
            assertThat(receivedException.get(), not(nullValue()));
    public void testPreferClusterManagerNodes() {  
                public void handleException(TransportException exp) {
            },  
            assertTrue(calledCoordinator.compareAndSet(false, true));  
                deterministicTaskQueue.scheduleNow(new Runnable() {
            }
                    @Override
import org.opensearch.test.telemetry.TestInMemoryMetricsRegistry;
        deterministicTaskQueue.advanceTime();
            null,
        assertThat(checkedNodes, contains(otherNode2));  
        final AtomicBoolean calledCoordinator = new AtomicBoolean();
        followersChecker.setCurrentNodes(discoveryNodes);
        List<DiscoveryNode> nodesList = new ArrayList<>();
        followersChecker.setCurrentNodes(discoveryNodes);  
            metricsRegistry
                assertNotEquals(node, localNode);  
        while (checkCount.get() < 10) {
        Supplier<TransportResponse.Empty> responder,  
                assert false : node;
                        assertTrue(receivedException.compareAndSet(null, exp));
                throw exception;
                    public void handleResponse(TransportResponse.Empty response) {
        final TransportService transportService = mockTransport.createTransportService(
    public void testFailsNodeThatRejectsCheck() {
                        handleResponse(requestId, Empty.INSTANCE);
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;  
            if (deterministicTaskQueue.hasRunnableTasks()) {  
                    @Override
 *
 * Modifications Copyright OpenSearch Contributors. See  
                throw new OpenSearchException("simulated exception");  
            coordinatorException.set(new OpenSearchException(exceptionMessage));
                        return TransportResponse.Empty.INSTANCE;  
                    return new FollowerCheckRequest(randomNonNegativeLong(), rq.getSender());
        checkCount.set(0);
            (node, reason) -> {
            metricsRegistry
    public void testFailsNodeThatDoesNotRespond() {
        transportService.start();  
            settings,
    }
            if (exception != null) {
        final TransportService transportService = mockTransport.createTransportService(  
            @Override
        followersChecker.setCurrentNodes(discoveryNodes);
            emptySet(),
                    @Override
                    public TransportResponse.Empty read(StreamInput in) {
                            // other nodes are ok
            }
                deterministicTaskQueue.advanceTime();  
            () -> { throw new NodeHealthCheckFailureException("non writable exception"); },
            nodesList.add(node);  
                new FollowerCheckRequest(leaderTerm, leader),
            metricsRegistry
        followersChecker.setCurrentNodes(discoveryNodes);  
import org.opensearch.OpenSearchException;  
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING;  
    }
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
            boundTransportAddress -> localNode,  
                assertThat(reason, equalTo(failureReason));
                    public String toString() {
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING;
        );  
        );
        followersChecker.updateFastResponseState(followerTerm, Mode.FOLLOWER);
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
                public TransportResponse.Empty read(StreamInput in) {  
            () -> new StatusInfo(HEALTHY, "healthy-info"),  
    }
import org.opensearch.common.settings.Settings.Builder;
                    @Override
                assertFalse(node.equals(localNode));
                        return TransportResponse.Empty.INSTANCE;  
        final DiscoveryNode follower = new DiscoveryNode("follower", buildNewFakeTransportAddress(), Version.CURRENT);
                assertTrue(nodeFailed.compareAndSet(false, true));  
            settings,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            (FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings) - 1) * FOLLOWER_CHECK_INTERVAL_SETTING.get(settings).millis(),
                                handleResponse(requestId, response);  
                FOLLOWER_CHECK_ACTION_NAME,
    }  
            0,  
    }
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getName()).build();  
import java.util.Set;
            final AtomicReference<TransportException> receivedException = new AtomicReference<>();
                        fail("unexpected success");
        final MockTransport mockTransport = new MockTransport() {
    public void testFollowerCheckRequestEqualsHashCodeSerialization() {
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), follower.getName()).build();  
            },
            transportService.sendRequest(follower, FOLLOWER_CHECK_ACTION_NAME, new FollowerCheckRequest(term, leader), expectsSuccess);
                    }
            randomSettings(),  
            assertTrue(responseReceived.compareAndSet(false, true));
    }  
                    assertTrue(receivedException.compareAndSet(null, exp));  
            }
import static org.opensearch.node.Node.NODE_NAME_SETTING;
        transportService.acceptIncomingRequests();
 * not use this file except in compliance with the License.
                new TransportResponseHandler<TransportResponse.Empty>() {  
        }
                        }
            deterministicTaskQueue.getThreadPool(),  
        }
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(followersChecker.getFaultyNodes(), empty());
            settings,
        // remove the faulty node and see that it is removed  
                handleResponse(requestId, Empty.INSTANCE);
            settings,  
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
                throw exception;  
            fcr -> { assert false : fcr; },
                    public String executor() {  
        List<DiscoveryNode> followerTargets = Stream.of(capturingTransport.getCapturedRequestsAndClear())
            assertTrue(expectsSuccess.succeeded());
        final AtomicBoolean calledCoordinator = new AtomicBoolean();
            final AtomicReference<TransportException> receivedException = new AtomicReference<>();
            deterministicTaskQueue.getThreadPool(),
                    }
            deterministicTaskQueue.runAllTasks();
            if (deterministicTaskQueue.hasRunnableTasks() == false) {
        final DiscoveryNode otherNode2 = new DiscoveryNode("other-node-2", buildNewFakeTransportAddress(), Version.CURRENT);
        }  
            }
            0,  
import org.opensearch.common.settings.ClusterSettings;  
            settings,
            () -> new StatusInfo(UNHEALTHY, "unhealthy-info"),
            ),
            assertTrue(calledCoordinator.get());
                    }  
 * compatible open source license.
        checkedNodes.clear();
            final ExpectsSuccess expectsSuccess = new ExpectsSuccess();  
            clusterSettings,
        },
                }
    }
    private static List<DiscoveryNode> randomNodes(final int numNodes) {
            }
        assertThat(receivedException.get(), not(nullValue()));
            return responseReceived.get();  
        final MockTransport mockTransport = new MockTransport() {
            deterministicTaskQueue.runAllRunnableTasks();
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
            @Override  
            );
        assertThat(followersChecker.getFaultyNodes(), empty());  
        final AtomicReference<RuntimeException> coordinatorException = new AtomicReference<>();  
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
import java.util.stream.Collectors;  
                    }
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            emptySet(),
        assertThat(followersChecker.getFaultyNodes(), empty());
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());  
            final long leaderTerm = randomLongBetween(1, Long.MAX_VALUE - 1);  
                        rq.getTerm(),
            (FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings) * (maxRecoveries + 1) - 1) * FOLLOWER_CHECK_INTERVAL_SETTING.get(settings)
 * this file be licensed under the Apache-2.0 license or a
            // If it calls into the coordinator and the coordinator throws an exception then it's passed back to the caller
                    public void handleException(TransportException exp) {  
                new DiscoveryNode(randomAlphaOfLength(10), buildNewFakeTransportAddress(), Version.CURRENT)
            NoopTracer.INSTANCE
        @Override  
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_ACTION_NAME;
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getName()).put(testSettings).build();
        final Set<DiscoveryNode> checkedNodes = new HashSet<>();
    private void testBehaviourOfFailingNode(
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(localNode).add(otherNode).localNodeId(localNode.getId()).build();
            followersChecker.updateFastResponseState(term, Mode.FOLLOWER);
        }  
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);  
        };  
                    @Override
                            handleResponse(requestId, Empty.INSTANCE);  
        );
import org.opensearch.test.transport.MockTransport;
            @Override
                    @Override
        assertThat(checkedNodes, containsInAnyOrder(otherNode1, otherNode2));  
            deterministicTaskQueue.runAllTasks();  
                    }  
        DiscoveryNodes discoveryNodes = discoNodesBuilder.localNodeId(nodes.get(0).getId()).build();
        MetricsRegistry metricsRegistry
/*
        // passes just enough checks to keep it alive, up to maxRecoveries, and then fails completely  
                checkedNodes.add(node);
            nodeHealthService,
        List<DiscoveryNode> nodes = randomNodes(10);
    private static Settings randomSettings() {  
        );  
        );
        checkedNodes.clear();  
import org.opensearch.test.transport.CapturingTransport;  
            () -> new StatusInfo(HEALTHY, "healthy-info"),  
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
            final ExpectsSuccess expectsSuccess = new ExpectsSuccess();
        assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());  
                            handleRemoteError(requestId, e);  
        final AtomicInteger checkCount = new AtomicInteger();
                    assertThat(exp, not(nullValue()));
    }
            NoopTracer.INSTANCE  
        while (checkCount.get() < 10) {
        final DiscoveryNode otherNode1 = new DiscoveryNode("other-node-1", buildNewFakeTransportAddress(), Version.CURRENT);
            null,
                new TransportResponseHandler<TransportResponse.Empty>() {  
            transportService.sendRequest(follower, FOLLOWER_CHECK_ACTION_NAME, new FollowerCheckRequest(term, leader), expectsSuccess);
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
    public void testUnhealthyNodeRejectsImmediately() {
            new FollowerCheckRequest(
                    fail("unexpected success");  
        transportService.acceptIncomingRequests();
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
        deterministicTaskQueue.runAllTasks();
        final long leaderTerm = randomLongBetween(2, Long.MAX_VALUE);
                assertThat(reason, equalTo("disconnected"));
            .collect(Collectors.toList());
                    }  
                    @Override
            deterministicTaskQueue.getThreadPool(),
import static org.hamcrest.Matchers.empty;
            transportService.sendRequest(
        deterministicTaskQueue.runAllRunnableTasks();  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            NoopTracer.INSTANCE
        }  
        {
            null,
 * under the License.  
        CapturingTransport capturingTransport = new CapturingTransport();
                    return new FollowerCheckRequest(  
import java.util.Collections;
            assertFalse(calledCoordinator.get());
            DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).build() };  
            () -> new StatusInfo(HEALTHY, "healthy-info"),
        testBehaviourOfFailingNode(
        // add another node and see that it schedules checks for this new node but keeps on considering the old one faulty  
            }  
        assertEquals(Integer.valueOf(2), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
        final TransportService transportService = mockTransport.createTransportService(
            final long followerTerm = randomLongBetween(1, leaderTerm - 1);
 */
        final long followerTerm = randomLongBetween(1, leaderTerm - 1);  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        final MockTransport mockTransport = new MockTransport() {  
import org.opensearch.cluster.coordination.FollowersChecker.FollowerCheckRequest;
        assertThat(followersChecker.getFaultyNodes(), contains(otherNode));
        transportService.acceptIncomingRequests();  
        followersChecker.setCurrentNodes(discoveryNodes);  
    }
            throw new AssertionError("unexpected", exp);  
        {
        if (randomBoolean()) {
        discoveryNodes = DiscoveryNodes.builder(discoveryNodes).remove(otherNode).build();
            metricsRegistry
            // Calls into the coordinator if not a follower  
        transportService.acceptIncomingRequests();  
import org.opensearch.transport.ConnectTransportException;  
        );  
        assertEquals(Integer.valueOf(0), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
        final FollowersChecker followersChecker = new FollowersChecker(settings, clusterSettings, transportService, fcr -> {
            transportService.sendRequest(
                        } catch (Exception e) {
        final AtomicReference<RuntimeException> coordinatorException = new AtomicReference<>();
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
        );
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        deterministicTaskQueue.runAllTasks();  
        private final AtomicBoolean responseReceived = new AtomicBoolean();  
        {
        discoveryNodes = DiscoveryNodes.builder(discoveryNodes).remove(otherNode2).build();  
        followersChecker.clearCurrentNodes();
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {  
package org.opensearch.cluster.coordination;
                            return;
        assertThat(deterministicTaskQueue.getCurrentTimeMillis(), equalTo(expectedFailureTime));
        );
        transportService.start();
        deterministicTaskQueue.runAllRunnableTasks();
            return TransportResponse.Empty.INSTANCE;
            boundTransportAddress -> localNode,
            if (exception != null) {
        assertEquals(Integer.valueOf(2), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());  
        final Builder settingsBuilder = Settings.builder();
        }
    }
    private static DiscoveryNode newNode(int nodeId, Map<String, String> attributes, Set<DiscoveryNodeRole> roles) {
                FOLLOWER_CHECK_ACTION_NAME,
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.node.DiscoveryNode;  
        final Settings settings = randomSettings();
        while (checkCount.get() < 10) {  
                new FollowerCheckRequest(leaderTerm, leader),
            final RuntimeException exception = coordinatorException.get();
            calledCoordinator.set(false);  
            assertFalse(calledCoordinator.get());  
            deterministicTaskQueue.runAllTasks();
        transportService.sendRequest(  
 * KIND, either express or implied.  See the License for the
            (node, reason) -> { assert false : node; },  
            (CopyFunction<FollowerCheckRequest>) rq -> copyWriteable(rq, writableRegistry(), FollowerCheckRequest::new),  
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
        assertThat(followersChecker.getFaultyNodes(), empty());
        );
import java.util.concurrent.atomic.AtomicInteger;  
            }  
            rq -> {
        }
            }
        }
                    }
 * The OpenSearch Contributors require contributions made to  
        return nodesList;
        );  
    }
                        fail("unexpected success");
            final long term = randomNonNegativeLong();  
                .millis(),
        final DiscoveryNode follower = new DiscoveryNode("follower", buildNewFakeTransportAddress(), Version.CURRENT);
            }
        };  
                    }
        followersChecker.setCurrentNodes(discoveryNodesHolder[0] = DiscoveryNodes.builder(discoveryNodesHolder[0]).add(otherNode1).build());
        final TransportService transportService = mockTransport.createTransportService(  
            transportService,
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);  
        final DiscoveryNode otherNode2 = new DiscoveryNode("other-node-2", buildNewFakeTransportAddress(), Version.CURRENT);  
        public String executor() {
            assert false : fcr;
        );
 * Unless required by applicable law or agreed to in writing,
                }  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
                assertTrue(nodeFailed.compareAndSet(false, true));
        final FollowersChecker followersChecker = new FollowersChecker(Settings.EMPTY, clusterSettings, transportService, fcr -> {  
        if (randomBoolean()) {
            deterministicTaskQueue.getThreadPool(),
            if (frequently()) {
        assertEquals(Integer.valueOf(2), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
        transportService.disconnectFromNode(otherNode);
            settingsBuilder.put(FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), randomIntBetween(1, 10));  
            "followers check retry count exceeded",
import java.util.List;
        final AtomicBoolean nodeFailed = new AtomicBoolean();  
                @Override
    public void testFailsNodeThatIsUnhealthy() {  
    public void testFailsNodeThatDisconnects() {
                attributes.put("custom", randomBoolean() ? "match" : randomAlphaOfLengthBetween(3, 5));  
            // Does not call into the coordinator in the normal case
 * ownership. Elasticsearch licenses this file to you under  
        );
        // add back the faulty node afresh and see that it fails again
        final TransportService transportService = mockTransport.createTransportService(
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
 * SPDX-License-Identifier: Apache-2.0
 *  
            final long leaderTerm = randomLongBetween(2, Long.MAX_VALUE);  
            private int recoveries;  
            new TransportResponseHandler<TransportResponse.Empty>() {
        return new DiscoveryNode("name_" + nodeId, "node_" + nodeId, buildNewFakeTransportAddress(), attributes, roles, Version.CURRENT);  
                }  
            "followers check retry count exceeded",
            (node, reason) -> { assert false : node; },
        public void handleResponse(Empty response) {  
        public TransportResponse.Empty read(StreamInput in) {
                    public void handleException(TransportException exp) {  
            settings,
            fcr -> { assert false : fcr; },
import java.util.HashMap;  
                    @Override
        deterministicTaskQueue.runAllTasks();
        };
import org.opensearch.transport.TransportRequest;
        final FollowersChecker followersChecker = new FollowersChecker(settings, clusterSettings, transportService, fcr -> {
            followersChecker.updateFastResponseState(followerTerm, Mode.FOLLOWER);
        final DiscoveryNodes[] discoveryNodesHolder = new DiscoveryNodes[] {
import org.opensearch.monitor.StatusInfo;
            emptySet(),  
                    @Override
            deterministicTaskQueue.getThreadPool(),
        List<DiscoveryNode> sortedFollowerTargets = new ArrayList<>(followerTargets);
        TransportService transportService = capturingTransport.createTransportService(  
                    public TransportResponse.Empty read(StreamInput in) {
            deterministicTaskQueue.runAllTasks();
        nodeFailed.set(false);
        assertThat(checkedNodes, empty());
                } else {
            followersChecker.updateFastResponseState(term, randomFrom(Mode.LEADER, Mode.CANDIDATE));
        assertThat(followersChecker.getFaultyNodes(), empty());
        final int maxRecoveries = randomIntBetween(3, 10);  
                public String executor() {
            assertTrue(calledCoordinator.get());  
        );
/*  
                        assertThat(exp, not(nullValue()));
        nodes.forEach(dn -> discoNodesBuilder.add(dn));  
                        if (node.equals(otherNode) == false) {
        discoveryNodes = DiscoveryNodes.builder(discoveryNodes).add(otherNode2).build();
            Settings.EMPTY,  
            }
                throw new AssertionError("no requests expected");
                new FollowerCheckRequest(term, leader),
            emptySet(),  
            // Does not call into the coordinator for a term that's too low, just rejects immediately
    public void testFailsNodeThatIsDisconnected() {  
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), follower.getName()).build();
 */  
                        return "sending response to [" + action + "][" + requestId + "] from " + node;  
        }
        }  
            NoopTracer.INSTANCE
        final Settings settings = randomSettings();
 */
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
            () -> new StatusInfo(StatusInfo.Status.HEALTHY, "healthy-info"),  
                randomNonNegativeLong(),  
        public void handleException(TransportException exp) {
            boundTransportAddress -> follower,
        deterministicTaskQueue.advanceTime();
    }
                        new DiscoveryNode(randomAlphaOfLength(10), buildNewFakeTransportAddress(), Version.CURRENT)
        long expectedFailureTime,
                deterministicTaskQueue.scheduleNow(new Runnable() {
            final ExpectsSuccess expectsSuccess = new ExpectsSuccess();
        }
                if (action.equals(HANDSHAKE_ACTION_NAME)) {  
            );
            () -> new StatusInfo(HEALTHY, "healthy-info"),
            () -> { throw new OpenSearchException("simulated exception"); },  
import org.opensearch.cluster.ClusterManagerMetrics;
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;  
import org.opensearch.telemetry.metrics.MetricsRegistry;
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
import org.opensearch.common.settings.Settings;
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {  
import org.opensearch.monitor.NodeHealthService;  
                            if (response != null) {
import org.opensearch.core.transport.TransportResponse.Empty;
            } else {
        {
        assertTrue(nodeFailed.get());
    public void testResponder() {
                public void handleResponse(TransportResponse.Empty response) {
            assertTrue(expectsSuccess.succeeded());  
        {  
        assertThat(followersChecker.getFaultyNodes(), contains(otherNode));
        );  
                assertThat(request, instanceOf(FollowerCheckRequest.class));
                deterministicTaskQueue.runRandomTask();
                    );  
            assertTrue(calledCoordinator.compareAndSet(false, true));
            }
        );
            final String exceptionMessage = "test simulated exception " + randomNonNegativeLong();
 * this work for additional information regarding copyright
        if (randomBoolean()) {
            () -> new StatusInfo(HEALTHY, "healthy-info"),
        DiscoveryNodes.Builder discoNodesBuilder = DiscoveryNodes.builder();
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    ) {
        followersChecker.setCurrentNodes(discoveryNodesHolder[0] = DiscoveryNodes.builder(discoveryNodesHolder[0]).add(otherNode2).build());
                        return Names.SAME;
                FOLLOWER_CHECK_ACTION_NAME,
 *
            new FollowerCheckRequest(leaderTerm, leader),  
        final DiscoveryNode leader = new DiscoveryNode("leader", buildNewFakeTransportAddress(), Version.CURRENT);  
            transportService.sendRequest(
            () -> { throw new ConnectTransportException(null, "simulated exception"); },
    }  
        final AtomicBoolean nodeFailed = new AtomicBoolean();  
            if (deterministicTaskQueue.hasRunnableTasks()) {
                assertThat(action, equalTo(FOLLOWER_CHECK_ACTION_NAME));
 * Licensed to Elasticsearch under one or more contributor  
        transportService.start();
        assertEquals(Integer.valueOf(2), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());
        deterministicTaskQueue.runAllTasksInTimeOrder();  
                });
                    }
import java.util.HashSet;
            Settings.EMPTY,
            settings,
import static org.hamcrest.Matchers.nullValue;
            boundTransportAddress -> localNode,
            () -> null,  
        };
            },
        }
            deterministicTaskQueue.getThreadPool(),
    }  
            if (deterministicTaskQueue.hasRunnableTasks()) {  
        return settingsBuilder.build();
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING;
        // remove the working node and see that everything eventually stops
            (node, reason) -> { assert false : node; },  
            public Empty get() {  
        public boolean succeeded() {
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        deterministicTaskQueue.runAllRunnableTasks();  
        assertThat(followersChecker.getFaultyNodes(), empty());
        followersChecker.setCurrentNodes(
        while (nodeFailed.get() == false) {
        );
        Settings testSettings,
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;  
            followersChecker.updateFastResponseState(term, randomFrom(Mode.LEADER, Mode.CANDIDATE));  
        final DiscoveryNode leader = new DiscoveryNode("leader", buildNewFakeTransportAddress(), Version.CURRENT);
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
                if (randomBoolean()) {
                    handleResponse(requestId, new TransportService.HandshakeResponse(node, ClusterName.DEFAULT, Version.CURRENT));
            "health check failed",
        testBehaviourOfFailingNode(
                assertTrue(discoveryNodesHolder[0].nodeExists(node));  
                    return;
                checkCount.incrementAndGet();  
                    public String toString() {
            );
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        assertFalse(calledCoordinator.get());
                follower,  
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
                        try {  
import org.opensearch.cluster.node.DiscoveryNodeRole;
            @Override
            emptySet(),  
                    @Override  
            settingsBuilder.put(FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), randomIntBetween(1, 60000) + "ms");  
        testBehaviourOfFailingNode(
                follower,  
                        return Names.SAME;
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                            }
    public void testFailureCounterResetsOnSuccess() {  
            NoopTracer.INSTANCE
import java.util.ArrayList;  
        @Override
                    }
 * software distributed under the License is distributed on an
        },
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), nodes.get(0).getName()).build();  
        deterministicTaskQueue.runAllRunnableTasks();  
            followersChecker.updateFastResponseState(followerTerm, Mode.FOLLOWER);
                    @Override  
    }
            NoopTracer.INSTANCE  
            (FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings) - 1) * FOLLOWER_CHECK_INTERVAL_SETTING.get(settings).millis()
            new ClusterManagerMetrics(metricsRegistry)
        }  
        followersChecker.setCurrentNodes(discoveryNodesHolder[0]);
        );  
        },
        testBehaviourOfFailingNode(settings, new Supplier<Empty>() {
                assertThat(node, not(equalTo(localNode)));
            return Names.SAME;
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                + FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings) * FOLLOWER_CHECK_TIMEOUT_SETTING.get(settings).millis(),  
        String failureReason,
            }
import static java.util.Collections.emptySet;  
        testBehaviourOfFailingNode(
                }
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();  
            () -> new StatusInfo(HEALTHY, "healthy-info"),  
            }  
/*
                    @Override
            x -> nodes.get(0),
        transportService.connectToNode(otherNode);
        }
import org.opensearch.Version;
            settings,  
                expectsSuccess  
            assertThat(receivedException.get().getRootCause().getMessage(), equalTo(exceptionMessage));
import org.opensearch.core.common.io.stream.StreamInput;  
        transportService.start();  
            follower,
        checkCount.set(0);
                    public String executor() {  
            }
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type  
            (node, reason) -> {  
                    return Empty.INSTANCE;
 *     http://www.apache.org/licenses/LICENSE-2.0
            @Override
        );  
                }
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
                follower,  
        @Override  
import java.util.stream.Stream;
                checkIndex++;
            }
import java.util.Comparator;
                    return Names.SAME;
        assertThat(checkedNodes, empty());  
import java.util.Map;  
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
        );
                @Override  
 * license agreements. See the NOTICE file distributed with
        followersChecker.setCurrentNodes(discoveryNodes);
            assertTrue(expectsSuccess.succeeded());  
        final MockTransport mockTransport = new MockTransport() {
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
                }  
            assertTrue(calledCoordinator.get());
        final FollowersChecker followersChecker = new FollowersChecker(
            boundTransportAddress -> follower,  
        assertEquals(Integer.valueOf(2), metricsRegistry.getCounterStore().get("followers.checker.failure.count").getCounterValue());  
        checkedNodes.clear();  
            private int checkIndex;
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
        final FollowersChecker followersChecker = new FollowersChecker(
            null,
        final MockTransport mockTransport = new MockTransport() {  
import org.opensearch.test.OpenSearchTestCase;
            FOLLOWER_CHECK_ACTION_NAME,
            new ClusterManagerMetrics(metricsRegistry)
import static org.hamcrest.Matchers.not;
                            final Empty response = responder.get();
            transportService,  
                        return "sending response to [" + action + "][" + requestId + "] from " + node;  
            assertThat(receivedException.get(), not(nullValue()));
        }
            calledCoordinator.set(false);
            // Calls into the coordinator if the term needs bumping
            final long followerTerm = randomLongBetween(leaderTerm + 1, Long.MAX_VALUE);
        final AtomicReference<TransportException> receivedException = new AtomicReference<>();
                deterministicTaskQueue.advanceTime();  
                }
        }
            settings,
        };
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
        transportService.start();
            } else {  
                    }  
        for (int i = 0; i < numNodes; i++) {  
        },
            final DiscoveryNode node = newNode(i, attributes, new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)));
 * You may obtain a copy of the License at  
        final FollowersChecker followersChecker = new FollowersChecker(  
            transportService,
import static org.hamcrest.core.IsInstanceOf.instanceOf;  
                    public void run() {  
            "disconnected",
import static org.opensearch.transport.TransportService.HANDSHAKE_ACTION_NAME;
        NodeHealthService nodeHealthService,  
import static org.hamcrest.Matchers.containsInAnyOrder;
        followersChecker.setCurrentNodes(discoveryNodes);
            null,
                deterministicTaskQueue.advanceTime();  
            settings,
        assertEquals(sortedFollowerTargets, followerTargets);
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(localNode).add(otherNode).localNodeId(localNode.getId()).build();
