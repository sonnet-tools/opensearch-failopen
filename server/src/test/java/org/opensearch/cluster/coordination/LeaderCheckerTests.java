        // noinspection RedundantCast since it is needed for some IDEs (specifically Eclipse 4.8.0) to infer the right type
            deterministicTaskQueue.runAllRunnableTasks();
            final CapturingTransportResponseHandler handler = new CapturingTransportResponseHandler();
        final LeaderChecker leaderChecker = new LeaderChecker(
        }
            deterministicTaskQueue.advanceTime();
        assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("leader.checker.failure.count").getCounterValue());
            null,
 * Licensed to Elasticsearch under one or more contributor
            deterministicTaskQueue.runAllRunnableTasks();
        if (randomBoolean()) {
            @Override
/*
            }
                }
        if (randomBoolean()) {
            assertThat(
            assertThat(handler.transportException, nullValue());
 * compatible open source license.
import org.opensearch.common.settings.ClusterSettings;
    public void testLeaderCheckRequestEqualsHashcodeSerialization() {
            deterministicTaskQueue.runAllTasks();
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            deterministicTaskQueue.runAllRunnableTasks();
            assertThat(handler.transportException.getRootCause(), instanceOf(CoordinationStateRejectedException.class));
        transportService.start();
        }, () -> new StatusInfo(StatusInfo.Status.HEALTHY, "healthy-info"), clusterManagerMetrics);
                        switch (response) {
import org.opensearch.OpenSearchException;
                    public void run() {
                if (action.equals(HANDSHAKE_ACTION_NAME)) {
import org.opensearch.cluster.ClusterManagerMetrics;
 * software distributed under the License is distributed on an
                final Response response = responseHolder[0];
            final long failureTime = deterministicTaskQueue.getCurrentTimeMillis();
            null,
        final long leaderCheckIntervalMillis;
        final MockTransport mockTransport = new MockTransport() {
                        }
            boundTransportAddress -> localNode,
                deterministicTaskQueue.runAllRunnableTasks();
            clusterSettings,
            }
import org.opensearch.monitor.StatusInfo;
    }
                            case REMOTE_ERROR:
            @Override
            final long maxCheckCount = randomLongBetween(2, 1000);
                    public void run() {
                )
            deterministicTaskQueue.runAllRunnableTasks();
            transportService.sendRequest(localNode, LEADER_CHECK_ACTION_NAME, new LeaderCheckRequest(otherNode), handler);
    private class CapturingTransportResponseHandler implements TransportResponseHandler<Empty> {
        @Override
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
        final TransportService transportService = mockTransport.createTransportService(
        {
        boolean successfulResponseReceived;
                deterministicTaskQueue.advanceTime();
            NoopTracer.INSTANCE
 *     http://www.apache.org/licenses/LICENSE-2.0
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
            NoopTracer.INSTANCE
        leaderChecker.updateLeader(null);
            ? leader1
import org.opensearch.transport.TransportResponseHandler;
        @Override
        final DiscoveryNode leader = new DiscoveryNode("leader", buildNewFakeTransportAddress(), Version.CURRENT);
        final ClusterManagerMetrics clusterManagerMetrics = new ClusterManagerMetrics(metricsRegistry);
            e -> fail("shouldn't be checking anything"),
                });
            emptySet(),
import java.util.concurrent.atomic.AtomicReference;
        final LeaderChecker leaderChecker = new LeaderChecker(settings, clusterSettings, transportService, e -> {
        }
import org.opensearch.cluster.coordination.LeaderChecker.LeaderCheckRequest;
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
            assertFalse(leaderFailed.get());
 * license agreements. See the NOTICE file distributed with
                super.onSendRequest(requestId, action, request, node);
            leaderChecker.setCurrentNodes(discoveryNodes);
            deterministicTaskQueue.getThreadPool(),
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.hamcrest.Matchers.anyOf;
            CoordinationStateRejectedException cause = (CoordinationStateRejectedException) handler.transportException.getRootCause();
            assertFalse(leaderFailed.get());
            transportService,
        deterministicTaskQueue.runAllTasks();
                cause.getMessage(),
            rq -> new LeaderCheckRequest(new DiscoveryNode(randomAlphaOfLength(10), buildNewFakeTransportAddress(), Version.CURRENT))
        TransportException transportException;
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
            assertThat(cause.getMessage(), equalTo("rejecting leader check since [" + otherNode + "] has been removed from the cluster"));
            assertFalse(handler.successfulResponseReceived);
        leaderFailed.set(false);
                    (leaderCheckIntervalMillis + leaderCheckTimeoutMillis) * leaderCheckRetryCount
                deterministicTaskQueue.runAllRunnableTasks();
 * Modifications Copyright OpenSearch Contributors. See
            while (deterministicTaskQueue.getCurrentTimeMillis() < 10 * LEADER_CHECK_INTERVAL_SETTING.get(Settings.EMPTY).millis()) {
        {
        final LeaderChecker leaderChecker = new LeaderChecker(settings, clusterSettings, transportService, e -> {
            leaderCheckIntervalMillis = randomLongBetween(1000, 60000);
        leaderChecker.updateLeader(leader);
        }
                    handleResponse(requestId, new TransportService.HandshakeResponse(node, ClusterName.DEFAULT, Version.CURRENT));
        leaderFailed.set(false);
            assertTrue(leaderFailed.get());
        SUCCESS,
                            handleResponse(requestId, Empty.INSTANCE);
/*
                if (responseDelay >= leaderCheckTimeoutMillis || successResponse == false) {
                        switch (response) {
            allResponsesFail.set(true);
        }, () -> new StatusInfo(StatusInfo.Status.HEALTHY, "healthy-info"), clusterManagerMetrics);
            while (deterministicTaskQueue.getCurrentTimeMillis() < 10 * LEADER_CHECK_INTERVAL_SETTING.get(Settings.EMPTY).millis()) {
        }
            leaderCheckTimeoutMillis = randomLongBetween(1, 60000);
        if (randomBoolean()) {
    }
        transportService.start();
        leaderChecker.updateLeader(null);
            assertThat(handler.transportException.getRootCause(), instanceOf(CoordinationStateRejectedException.class));
            }
                                handleResponse(requestId, Empty.INSTANCE);
            (CopyFunction<LeaderCheckRequest>) rq -> copyWriteable(rq, writableRegistry(), LeaderCheckRequest::new),
            );
        transportService.acceptIncomingRequests();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                        return response + " response to request " + requestId;
                });
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
package org.opensearch.cluster.coordination;
                                break;
            logger.info("--> checking that no failure is detected in {} checks", maxCheckCount);
import org.opensearch.core.common.io.stream.StreamInput;
        final ClusterManagerMetrics clusterManagerMetrics = new ClusterManagerMetrics(metricsRegistry);
            assertThat(e.getMessage(), matchesRegex("node \\[.*\\] failed \\[[1-9][0-9]*\\] consecutive checks"));
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final TransportService transportService = mockTransport.createTransportService(
                        } else {
        }
import static org.hamcrest.Matchers.endsWith;
            NoopTracer.INSTANCE
            leaderCheckIntervalMillis = LEADER_CHECK_INTERVAL_SETTING.get(Settings.EMPTY).millis();
import org.opensearch.transport.ConnectTransportException;
        final Response[] responseHolder = new Response[] { Response.SUCCESS };
        final AtomicBoolean allResponsesFail = new AtomicBoolean();
 * Unless required by applicable law or agreed to in writing,
        };
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under
        } else {
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.core.transport.TransportResponse.Empty;
            checkCount.set(0);
import org.opensearch.transport.TransportException;
/*
            responseHolder[0] = Response.DIRECT_ERROR;
                        return (successResponse ? "successful" : "unsuccessful") + " response to request " + requestId;
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_INTERVAL_SETTING;
                    return;
        };
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_ACTION_NAME;
                assertThat(action, equalTo(LEADER_CHECK_ACTION_NAME));
        }
                        return response + " response to request " + requestId;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                final boolean successResponse = allResponsesFail.get() == false && (mustSucceed || randomBoolean());
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
                final boolean mustSucceed = leaderCheckRetryCount - 1 <= consecutiveFailedRequestsCount;
        final LeaderChecker leaderChecker = new LeaderChecker(settings, clusterSettings, transportService, e -> {
                });
                        // needed because a successful check response might be in flight at the time of failure
 * under the License.
            assertTrue(leaderFailed.compareAndSet(false, true));
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
                    handleResponse(requestId, new TransportService.HandshakeResponse(node, ClusterName.DEFAULT, Version.CURRENT));
                    @Override
            assertThat(e.getMessage(), anyOf(endsWith("disconnected"), endsWith("disconnected during check")));
                    public String toString() {
                    public String toString() {
        }
            assertTrue(leaderFailed.get());
            boundTransportAddress -> localNode,
                lessThanOrEqualTo(
    }
        @Override
        public String executor() {
 * The OpenSearch Contributors require contributions made to
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
            assertFalse(leaderFailed.get());
            leaderChecker.setCurrentNodes(discoveryNodes);
 * this file be licensed under the Apache-2.0 license or a
                                break;
            transportService.sendRequest(localNode, LEADER_CHECK_ACTION_NAME, new LeaderCheckRequest(otherNode), handler);
            }
        deterministicTaskQueue.runAllTasks();
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getId()).build();
        {
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
        }
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(node, leader);
        }
import static org.opensearch.transport.TransportService.HANDSHAKE_ACTION_NAME;
                deterministicTaskQueue.advanceTime();
            settings,
            deterministicTaskQueue.advanceTime();
            deterministicTaskQueue.getThreadPool(),
        final AtomicBoolean leaderFailed = new AtomicBoolean();
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
                equalTo("rejecting leader check from [" + otherNode + "] sent to a node that is no longer the cluster-manager")
        LeaderCheckRequest request = new LeaderCheckRequest(
            assertTrue(leaderFailed.compareAndSet(false, true));
                                handleRemoteError(requestId, new ConnectTransportException(leader, "simulated error"));
            assertTrue(leaderFailed.compareAndSet(false, true));
            leaderCheckRetryCount = LEADER_CHECK_RETRY_COUNT_SETTING.get(Settings.EMPTY);
        @Override
                    }
        final ClusterManagerMetrics clusterManagerMetrics = new ClusterManagerMetrics(metricsRegistry);
                cause.getMessage(),
            }
        final ClusterManagerMetrics clusterManagerMetrics = new ClusterManagerMetrics(metricsRegistry);
        final DiscoveryNode leader = new DiscoveryNode("leader", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.test.transport.CapturingTransport;
        final Response[] responseHolder = new Response[] { Response.SUCCESS };
import org.opensearch.threadpool.ThreadPool.Names;
            deterministicTaskQueue.runAllRunnableTasks();
 */
        final int leaderCheckRetryCount;
import static java.util.Collections.emptySet;
            deterministicTaskQueue.runAllTasks();
 */
            assertTrue(handler.successfulResponseReceived);
        final TransportService transportService = mockTransport.createTransportService(
                deterministicTaskQueue.runAllRunnableTasks();
 * specific language governing permissions and limitations
        );
                            case SUCCESS:
            );
            transportService.sendRequest(localNode, LEADER_CHECK_ACTION_NAME, new LeaderCheckRequest(otherNode), handler);
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getId()).build();
                            case DIRECT_ERROR:
            responseHolder[0] = Response.REMOTE_ERROR;
            deterministicTaskQueue.getThreadPool(),
import static org.hamcrest.Matchers.nullValue;
            emptySet(),
            deterministicTaskQueue.runAllRunnableTasks();
                            handleRemoteError(requestId, new OpenSearchException("simulated error"));
        final DiscoveryNode leader1 = new DiscoveryNode("leader-1", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.test.EqualsHashCodeTestUtils;
            : new DiscoveryNode("leader-2", buildNewFakeTransportAddress(), Version.CURRENT);
                deterministicTaskQueue.runAllRunnableTasks();
            new DiscoveryNode(randomAlphaOfLength(10), buildNewFakeTransportAddress(), Version.CURRENT)
            while (leaderFailed.get() == false) {
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
                }
import org.opensearch.test.OpenSearchTestCase;
 */
        AtomicReference<StatusInfo> nodeHealthServiceStatus = new AtomicReference<>(new StatusInfo(UNHEALTHY, "unhealthy-info"));
            null,
            .clusterManagerNodeId(localNode.getId())
        }
            request,
import org.opensearch.cluster.node.DiscoveryNode;
                deterministicTaskQueue.advanceTime();
        }
        DIRECT_ERROR
        public void handleException(TransportException exp) {
                deterministicTaskQueue.runAllRunnableTasks();
        {
        responseHolder[0] = Response.SUCCESS;
            () -> nodeHealthServiceStatus.get(),
            assertFalse(handler.successfulResponseReceived);
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;
            );
        transportService.start();
                    @Override
            transportException = exp;
                deterministicTaskQueue.advanceTime();
public class LeaderCheckerTests extends OpenSearchTestCase {
            NodeHealthCheckFailureException cause = (NodeHealthCheckFailureException) handler.transportException.getRootCause();
        final TransportService transportService = capturingTransport.createTransportService(
            NOOP_TRANSPORT_INTERCEPTOR,
                    }
                assertEquals(node, leader);
            clusterManagerMetrics
            final long maxCheckCount = randomLongBetween(2, 1000);
                final long responseDelay = randomLongBetween(0, leaderCheckTimeoutMillis + (mustSucceed ? -1 : 60000));
                        if (successResponse) {
import org.opensearch.cluster.ClusterName;
        leaderChecker.updateLeader(null);
                assertThat(action, equalTo(LEADER_CHECK_ACTION_NAME));
            deterministicTaskQueue.runAllRunnableTasks();
                            case REMOTE_ERROR:
        final CapturingTransport capturingTransport = new CapturingTransport();
            }
                        }
            settingsBuilder.put(LEADER_CHECK_RETRY_COUNT_SETTING.getKey(), leaderCheckRetryCount);
        public void handleResponse(Empty response) {
import org.opensearch.test.telemetry.TestInMemoryMetricsRegistry;
    }
                    @Override
            logger.info("--> failing at {}ms", failureTime);
 *
                                handleError(requestId, new ConnectTransportException(leader, "simulated error"));
import org.opensearch.common.settings.Settings;
                final Response response = responseHolder[0];
            while (checkCount.get() < maxCheckCount) {
            assertTrue(leaderFailed.get());
        final MockTransport mockTransport = new MockTransport() {
            .add(localNode)
            return Names.GENERIC;
            settingsBuilder.put(LEADER_CHECK_TIMEOUT_SETTING.getKey(), leaderCheckTimeoutMillis + "ms");
            transportService.sendRequest(localNode, LEADER_CHECK_ACTION_NAME, new LeaderCheckRequest(otherNode), handler);
        }
        );
 * not use this file except in compliance with the License.
                }
        }
            deterministicTaskQueue.runAllTasks();
                    }
        leaderChecker.updateLeader(leader1);
                deterministicTaskQueue.scheduleNow(new Runnable() {
                                handleResponse(requestId, Empty.INSTANCE);
            settings,
                                handleRemoteError(requestId, new NodeHealthCheckFailureException("simulated error"));
            assertThat(e.getMessage(), endsWith("failed health checks"));
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING;
            final CapturingTransportResponseHandler handler = new CapturingTransportResponseHandler();
            NOOP_TRANSPORT_INTERCEPTOR,
        }
                    }
            transportService.disconnectFromNode(leader);
        {
import org.opensearch.core.transport.TransportResponse;
import java.util.concurrent.atomic.AtomicLong;
        assertEquals(Integer.valueOf(0), metricsRegistry.getCounterStore().get("leader.checker.failure.count").getCounterValue());
        public TransportResponse.Empty read(StreamInput in) {
            }
 *
            boundTransportAddress -> localNode,
                    @Override
        deterministicTaskQueue.runAllTasks();
        final AtomicLong checkCount = new AtomicLong();
import java.util.concurrent.atomic.AtomicBoolean;
                    consecutiveFailedRequestsCount += 1;
import static org.hamcrest.Matchers.matchesRegex;
                        + leaderCheckTimeoutMillis
                    consecutiveFailedRequestsCount = 0;
        );
        }
            null,
        nodeHealthServiceStatus.getAndSet(new StatusInfo(HEALTHY, "healthy-info"));
        leaderChecker.updateLeader(leader);
    public void testFollowerFailsImmediatelyOnDisconnection() {
        final DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING;
                                break;
        final TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
        logger.info("--> creating second checker");
                if (action.equals(HANDSHAKE_ACTION_NAME)) {
                deterministicTaskQueue.runAllRunnableTasks();
            settings,
            leaderCheckTimeoutMillis = LEADER_CHECK_TIMEOUT_SETTING.get(Settings.EMPTY).millis();
import org.opensearch.test.transport.MockTransport;
import org.opensearch.Version;
            NoopTracer.INSTANCE
        REMOTE_ERROR,
        {
                            case SUCCESS:
        {
                    return;
                } else {
        final DiscoveryNode leader2 = randomBoolean()
        final long leaderCheckTimeoutMillis;
        );
        }
 *
 * this work for additional information regarding copyright
        leaderChecker.updateLeader(leader);
            }
            while (deterministicTaskQueue.getCurrentTimeMillis() < 10 * LEADER_CHECK_INTERVAL_SETTING.get(Settings.EMPTY).millis()) {
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
import org.opensearch.transport.TransportService;
            NOOP_TRANSPORT_INTERCEPTOR,
        }
            emptySet(),
            boundTransportAddress -> localNode,
        transportService.start();
                    public String toString() {
}
            @Override
        leaderChecker.updateLeader(leader);
            CoordinationStateRejectedException cause = (CoordinationStateRejectedException) handler.transportException.getRootCause();
            leaderCheckRetryCount = randomIntBetween(1, 10);
import org.opensearch.transport.TransportRequest;
            leaderChecker.setCurrentNodes(DiscoveryNodes.builder(discoveryNodes).add(otherNode).build());
        logger.info("--> running remaining tasks");
 * You may obtain a copy of the License at
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
 * GitHub history for details.
            deterministicTaskQueue.runAllRunnableTasks();
            deterministicTaskQueue.runAllTasks();
            settingsBuilder.put(LEADER_CHECK_INTERVAL_SETTING.getKey(), leaderCheckIntervalMillis + "ms");
        logger.info("--> creating first checker");
            successfulResponseReceived = true;
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getId()).build();
            final CapturingTransportResponseHandler handler = new CapturingTransportResponseHandler();
                deterministicTaskQueue.advanceTime();
            logger.info("--> checking again that no failure is detected in {} checks", maxCheckCount);
        final MockTransport mockTransport = new MockTransport() {
        leaderChecker.updateLeader(leader2);
    public void testLeaderBehaviour() {
            int consecutiveFailedRequestsCount;
            .localNodeId(localNode.getId())
        {
            settings,
            assertThat(
            settings,
            responseHolder[0] = Response.REMOTE_ERROR;
        Settings.Builder settingsBuilder = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getId());
                    @Override
        transportService.acceptIncomingRequests();
import org.opensearch.cluster.node.DiscoveryNodes;
    }
        logger.info("--> using {}", settings);
                        }
            assertFalse(handler.successfulResponseReceived);
            assertTrue(leaderFailed.get());
        );
        transportService.acceptIncomingRequests();
        );
            assertThat(handler.transportException.getRootCause(), instanceOf(NodeHealthCheckFailureException.class));
                assertTrue(node.equals(leader1) || node.equals(leader2));
            transportService.connectToNode(leader); // need to connect first for disconnect to have any effect
import static org.hamcrest.Matchers.instanceOf;
        }, () -> new StatusInfo(StatusInfo.Status.HEALTHY, "healthy-info"), clusterManagerMetrics);
                checkCount.incrementAndGet();
 * KIND, either express or implied.  See the License for the
    public void testFollowerFailsImmediatelyOnHealthCheckFailure() {
                deterministicTaskQueue.advanceTime();
                deterministicTaskQueue.scheduleNow(new Runnable() {
    }
        assertEquals(Integer.valueOf(3), metricsRegistry.getCounterStore().get("leader.checker.failure.count").getCounterValue());
        );
            return TransportResponse.Empty.INSTANCE;
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
        final Settings settings = settingsBuilder.build();
                                break;
        transportService.acceptIncomingRequests();
                deterministicTaskQueue.scheduleAt(deterministicTaskQueue.getCurrentTimeMillis() + responseDelay, new Runnable() {
    }
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
        assertFalse(leaderFailed.get());
        final AtomicBoolean leaderFailed = new AtomicBoolean();
import static org.hamcrest.Matchers.equalTo;
            NOOP_TRANSPORT_INTERCEPTOR,
            .build();
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
    enum Response {
                    public void run() {
    public void testFollowerBehaviour() {
            }
                equalTo("rejecting leader check from [" + otherNode + "] since node is unhealthy [unhealthy-info]")
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
            emptySet(),
                    }
                    }
        {
import static org.opensearch.transport.TransportService.NOOP_TRANSPORT_INTERCEPTOR;
        responseHolder[0] = Response.SUCCESS;
        assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("leader.checker.failure.count").getCounterValue());
            deterministicTaskQueue.advanceTime();
                    @Override
        };
        } else {
        {
            deterministicTaskQueue.getThreadPool(),
                deterministicTaskQueue.getCurrentTimeMillis() - failureTime,
            while (checkCount.get() < maxCheckCount) {
                assertThat(action, equalTo(LEADER_CHECK_ACTION_NAME));
            assertThat(
            leaderChecker.setCurrentNodes(DiscoveryNodes.builder(discoveryNodes).add(otherNode).clusterManagerNodeId(null).build());
            final CapturingTransportResponseHandler handler = new CapturingTransportResponseHandler();
        final AtomicBoolean leaderFailed = new AtomicBoolean();
        } else {
