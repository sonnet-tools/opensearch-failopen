            assertThat(
                });
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_ACTION_NAME;  
            assertFalse(leaderFailed.get());
        final TransportService transportService = mockTransport.createTransportService(
        }  
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
                deterministicTaskQueue.advanceTime();
                if (responseDelay >= leaderCheckTimeoutMillis || successResponse == false) {
                deterministicTaskQueue.scheduleNow(new Runnable() {  
        }
                )  
                                handleRemoteError(requestId, new NodeHealthCheckFailureException("simulated error"));
        final MockTransport mockTransport = new MockTransport() {  
                        switch (response) {  
        leaderChecker.updateLeader(null);
            transportService.sendRequest(localNode, LEADER_CHECK_ACTION_NAME, new LeaderCheckRequest(otherNode), handler);
        final LeaderChecker leaderChecker = new LeaderChecker(settings, clusterSettings, transportService, e -> {  
import static org.hamcrest.Matchers.anyOf;  
                            handleRemoteError(requestId, new OpenSearchException("simulated error"));
            return TransportResponse.Empty.INSTANCE;
                                break;  
            assertTrue(leaderFailed.compareAndSet(false, true));
        assertFalse(leaderFailed.get());  
import org.opensearch.transport.TransportService;
 * KIND, either express or implied.  See the License for the
    public void testLeaderCheckRequestEqualsHashcodeSerialization() {  
            );  
        final ClusterManagerMetrics clusterManagerMetrics = new ClusterManagerMetrics(metricsRegistry);
    public void testLeaderBehaviour() {  
            NoopTracer.INSTANCE
        REMOTE_ERROR,  
            );
        );
                });
        {
                    handleResponse(requestId, new TransportService.HandshakeResponse(node, ClusterName.DEFAULT, Version.CURRENT));
            }  
        deterministicTaskQueue.runAllTasks();
            transportService.sendRequest(localNode, LEADER_CHECK_ACTION_NAME, new LeaderCheckRequest(otherNode), handler);  
            final long failureTime = deterministicTaskQueue.getCurrentTimeMillis();  
        final Response[] responseHolder = new Response[] { Response.SUCCESS };
        }  
        transportService.acceptIncomingRequests();
 * ownership. Elasticsearch licenses this file to you under  
}
                    public void run() {
            deterministicTaskQueue.runAllRunnableTasks();
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());  
        } else {  
            NOOP_TRANSPORT_INTERCEPTOR,  
        final AtomicLong checkCount = new AtomicLong();
 * Modifications Copyright OpenSearch Contributors. See
        transportService.acceptIncomingRequests();
                            case DIRECT_ERROR:
        final AtomicBoolean leaderFailed = new AtomicBoolean();
 * not use this file except in compliance with the License.
/*
            }
        {
import org.opensearch.threadpool.ThreadPool.Names;  
            NoopTracer.INSTANCE
            deterministicTaskQueue.runAllRunnableTasks();
                        } else {  
            leaderChecker.setCurrentNodes(DiscoveryNodes.builder(discoveryNodes).add(otherNode).clusterManagerNodeId(null).build());
            settings,
            leaderChecker.setCurrentNodes(DiscoveryNodes.builder(discoveryNodes).add(otherNode).build());  
                        + leaderCheckTimeoutMillis
            logger.info("--> failing at {}ms", failureTime);
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
        logger.info("--> running remaining tasks");
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.hamcrest.Matchers.endsWith;
        responseHolder[0] = Response.SUCCESS;  
            assertThat(  
import static org.opensearch.node.Node.NODE_NAME_SETTING;  
            assertThat(e.getMessage(), anyOf(endsWith("disconnected"), endsWith("disconnected during check")));
        );  
            checkCount.set(0);
        }
            null,
        final DiscoveryNode leader = new DiscoveryNode("leader", buildNewFakeTransportAddress(), Version.CURRENT);  
        Settings.Builder settingsBuilder = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getId());
            assertThat(  
 * You may obtain a copy of the License at  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertTrue(leaderFailed.get());
            deterministicTaskQueue.runAllRunnableTasks();
            deterministicTaskQueue.runAllTasks();  
        );  
 * the Apache License, Version 2.0 (the "License"); you may
            .clusterManagerNodeId(localNode.getId())
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());  
                final Response response = responseHolder[0];
        if (randomBoolean()) {
                            case REMOTE_ERROR:
                    }
            leaderCheckIntervalMillis = randomLongBetween(1000, 60000);  
        leaderChecker.updateLeader(leader);
            transportException = exp;
import org.opensearch.test.transport.CapturingTransport;
        final long leaderCheckIntervalMillis;
import org.opensearch.OpenSearchException;
        final int leaderCheckRetryCount;
            successfulResponseReceived = true;
            settings,  
                                break;  
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {  
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
            request,  
        }, () -> new StatusInfo(StatusInfo.Status.HEALTHY, "healthy-info"), clusterManagerMetrics);  
                    public String toString() {
        deterministicTaskQueue.runAllTasks();
        final MockTransport mockTransport = new MockTransport() {
            assertThat(handler.transportException.getRootCause(), instanceOf(CoordinationStateRejectedException.class));  
                equalTo("rejecting leader check from [" + otherNode + "] sent to a node that is no longer the cluster-manager")
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getId()).build();
            deterministicTaskQueue.runAllRunnableTasks();
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING;  
            deterministicTaskQueue.runAllTasks();  
            assertTrue(leaderFailed.get());  
                deterministicTaskQueue.advanceTime();
        final long leaderCheckTimeoutMillis;  
            }
import org.opensearch.common.settings.Settings;  
        assertEquals(Integer.valueOf(3), metricsRegistry.getCounterStore().get("leader.checker.failure.count").getCounterValue());
            }
                if (action.equals(HANDSHAKE_ACTION_NAME)) {
                        return response + " response to request " + requestId;
            final CapturingTransportResponseHandler handler = new CapturingTransportResponseHandler();
                deterministicTaskQueue.advanceTime();
        final ClusterManagerMetrics clusterManagerMetrics = new ClusterManagerMetrics(metricsRegistry);  
            while (checkCount.get() < maxCheckCount) {
    private class CapturingTransportResponseHandler implements TransportResponseHandler<Empty> {
                assertTrue(node.equals(leader1) || node.equals(leader2));
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();  
            .add(localNode)  
                                handleRemoteError(requestId, new ConnectTransportException(leader, "simulated error"));
        {
        transportService.start();  
        assertEquals(Integer.valueOf(0), metricsRegistry.getCounterStore().get("leader.checker.failure.count").getCounterValue());
            final CapturingTransportResponseHandler handler = new CapturingTransportResponseHandler();
            transportService,
            responseHolder[0] = Response.DIRECT_ERROR;
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {  
import org.opensearch.test.OpenSearchTestCase;
            assertThat(e.getMessage(), matchesRegex("node \\[.*\\] failed \\[[1-9][0-9]*\\] consecutive checks"));  
        final LeaderChecker leaderChecker = new LeaderChecker(
                } else {
                    public String toString() {
                final boolean successResponse = allResponsesFail.get() == false && (mustSucceed || randomBoolean());  
        @Override  
                                handleResponse(requestId, Empty.INSTANCE);
                    return;  
import org.opensearch.cluster.ClusterName;
            leaderChecker.setCurrentNodes(discoveryNodes);  
                    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
        } else {
        final LeaderChecker leaderChecker = new LeaderChecker(settings, clusterSettings, transportService, e -> {
 * under the License.  
            deterministicTaskQueue.runAllTasks();
import org.opensearch.test.EqualsHashCodeTestUtils;  
                    handleResponse(requestId, new TransportService.HandshakeResponse(node, ClusterName.DEFAULT, Version.CURRENT));
                assertThat(action, equalTo(LEADER_CHECK_ACTION_NAME));
            boundTransportAddress -> localNode,  
            assertThat(handler.transportException, nullValue());
public class LeaderCheckerTests extends OpenSearchTestCase {
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
            return Names.GENERIC;  
            @Override
            while (checkCount.get() < maxCheckCount) {  
    public void testFollowerBehaviour() {
            assertTrue(leaderFailed.compareAndSet(false, true));
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getId()).build();
                });  
                    return;  
            while (leaderFailed.get() == false) {
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
        final CapturingTransport capturingTransport = new CapturingTransport();  
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
    public void testFollowerFailsImmediatelyOnHealthCheckFailure() {
import org.opensearch.core.transport.TransportResponse;
            NOOP_TRANSPORT_INTERCEPTOR,
            ? leader1
import java.util.concurrent.atomic.AtomicBoolean;
                    @Override
import org.opensearch.cluster.node.DiscoveryNode;  
        }  
            new DiscoveryNode(randomAlphaOfLength(10), buildNewFakeTransportAddress(), Version.CURRENT)
            : new DiscoveryNode("leader-2", buildNewFakeTransportAddress(), Version.CURRENT);
        @Override
        leaderChecker.updateLeader(leader1);
        final ClusterManagerMetrics clusterManagerMetrics = new ClusterManagerMetrics(metricsRegistry);
/*  
            assertTrue(leaderFailed.compareAndSet(false, true));
            logger.info("--> checking again that no failure is detected in {} checks", maxCheckCount);
            int consecutiveFailedRequestsCount;
    }
            leaderCheckTimeoutMillis = LEADER_CHECK_TIMEOUT_SETTING.get(Settings.EMPTY).millis();
        DIRECT_ERROR
 * specific language governing permissions and limitations
                        if (successResponse) {
        logger.info("--> using {}", settings);  
        }
            assertFalse(handler.successfulResponseReceived);
            final long maxCheckCount = randomLongBetween(2, 1000);
        }, () -> new StatusInfo(StatusInfo.Status.HEALTHY, "healthy-info"), clusterManagerMetrics);  
                cause.getMessage(),
        deterministicTaskQueue.runAllTasks();  
            NodeHealthCheckFailureException cause = (NodeHealthCheckFailureException) handler.transportException.getRootCause();
                                break;  
                                handleError(requestId, new ConnectTransportException(leader, "simulated error"));
                        switch (response) {  
            boundTransportAddress -> localNode,
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        boolean successfulResponseReceived;
        }  
            transportService.sendRequest(localNode, LEADER_CHECK_ACTION_NAME, new LeaderCheckRequest(otherNode), handler);
                    public void run() {  
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
            settings,
 *     http://www.apache.org/licenses/LICENSE-2.0
                cause.getMessage(),  
                        return (successResponse ? "successful" : "unsuccessful") + " response to request " + requestId;
        }, () -> new StatusInfo(StatusInfo.Status.HEALTHY, "healthy-info"), clusterManagerMetrics);
                    @Override
            clusterManagerMetrics
import org.opensearch.monitor.StatusInfo;
            deterministicTaskQueue.getThreadPool(),
            @Override
            assertTrue(handler.successfulResponseReceived);  
            null,
        public void handleException(TransportException exp) {  
                deterministicTaskQueue.runAllRunnableTasks();
import org.opensearch.test.transport.MockTransport;
                    }
            NOOP_TRANSPORT_INTERCEPTOR,  
            settings,  
            final CapturingTransportResponseHandler handler = new CapturingTransportResponseHandler();
            );
import org.opensearch.core.transport.TransportResponse.Empty;  
        final ClusterManagerMetrics clusterManagerMetrics = new ClusterManagerMetrics(metricsRegistry);
            assertTrue(leaderFailed.get());
 * this file be licensed under the Apache-2.0 license or a
        logger.info("--> creating first checker");
                assertEquals(node, leader);  
        );
            leaderCheckRetryCount = randomIntBetween(1, 10);
import org.opensearch.test.telemetry.TestInMemoryMetricsRegistry;  
        @Override
 * Licensed to Elasticsearch under one or more contributor  
        final AtomicBoolean allResponsesFail = new AtomicBoolean();
    }
import static java.util.Collections.emptySet;
        leaderFailed.set(false);
            settingsBuilder.put(LEADER_CHECK_INTERVAL_SETTING.getKey(), leaderCheckIntervalMillis + "ms");
            deterministicTaskQueue.getThreadPool(),  
            }
            while (deterministicTaskQueue.getCurrentTimeMillis() < 10 * LEADER_CHECK_INTERVAL_SETTING.get(Settings.EMPTY).millis()) {
            settingsBuilder.put(LEADER_CHECK_TIMEOUT_SETTING.getKey(), leaderCheckTimeoutMillis + "ms");  
                            case SUCCESS:
        }
        );
            leaderCheckIntervalMillis = LEADER_CHECK_INTERVAL_SETTING.get(Settings.EMPTY).millis();  
        leaderChecker.updateLeader(null);
    }
                    }
import java.util.concurrent.atomic.AtomicReference;  
        AtomicReference<StatusInfo> nodeHealthServiceStatus = new AtomicReference<>(new StatusInfo(UNHEALTHY, "unhealthy-info"));
            }
                        }
            deterministicTaskQueue.runAllRunnableTasks();  
            boundTransportAddress -> localNode,
        }
            deterministicTaskQueue.getThreadPool(),
                deterministicTaskQueue.getCurrentTimeMillis() - failureTime,
        leaderChecker.updateLeader(leader);
import org.opensearch.transport.TransportResponseHandler;
            deterministicTaskQueue.runAllTasks();
        SUCCESS,
import static org.hamcrest.Matchers.matchesRegex;
 * this work for additional information regarding copyright
        }
        leaderFailed.set(false);
 */  
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
        transportService.acceptIncomingRequests();
            leaderCheckRetryCount = LEADER_CHECK_RETRY_COUNT_SETTING.get(Settings.EMPTY);
                        return response + " response to request " + requestId;  
            null,
                checkCount.incrementAndGet();
 *
import org.opensearch.cluster.node.DiscoveryNodes;
            final long maxCheckCount = randomLongBetween(2, 1000);  
        } else {
            deterministicTaskQueue.getThreadPool(),
        {  
import org.opensearch.transport.TransportException;
            deterministicTaskQueue.advanceTime();  
        }
        final DiscoveryNode localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
            while (deterministicTaskQueue.getCurrentTimeMillis() < 10 * LEADER_CHECK_INTERVAL_SETTING.get(Settings.EMPTY).millis()) {  
                        // needed because a successful check response might be in flight at the time of failure
import org.opensearch.cluster.ClusterManagerMetrics;  
            .build();  
                super.onSendRequest(requestId, action, request, node);
        final AtomicBoolean leaderFailed = new AtomicBoolean();  
            CoordinationStateRejectedException cause = (CoordinationStateRejectedException) handler.transportException.getRootCause();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final DiscoveryNode leader1 = new DiscoveryNode("leader-1", buildNewFakeTransportAddress(), Version.CURRENT);
        assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("leader.checker.failure.count").getCounterValue());
        logger.info("--> creating second checker");
        public TransportResponse.Empty read(StreamInput in) {
            NOOP_TRANSPORT_INTERCEPTOR,
        transportService.start();
        final Settings settings = settingsBuilder.build();
            () -> nodeHealthServiceStatus.get(),
                        }
        // noinspection RedundantCast since it is needed for some IDEs (specifically Eclipse 4.8.0) to infer the right type
            assertThat(handler.transportException.getRootCause(), instanceOf(CoordinationStateRejectedException.class));  
                    @Override  
        final LeaderChecker leaderChecker = new LeaderChecker(settings, clusterSettings, transportService, e -> {  
            deterministicTaskQueue.runAllRunnableTasks();
 */  
        transportService.start();  
            assertFalse(handler.successfulResponseReceived);
            responseHolder[0] = Response.REMOTE_ERROR;  
            deterministicTaskQueue.advanceTime();
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), localNode.getId()).build();  
import static org.hamcrest.Matchers.nullValue;  
            null,  
        final TransportService transportService = capturingTransport.createTransportService(  
        {
                            case REMOTE_ERROR:
    }
            allResponsesFail.set(true);
            responseHolder[0] = Response.REMOTE_ERROR;
                deterministicTaskQueue.scheduleNow(new Runnable() {  
/*  
                final boolean mustSucceed = leaderCheckRetryCount - 1 <= consecutiveFailedRequestsCount;
                    (leaderCheckIntervalMillis + leaderCheckTimeoutMillis) * leaderCheckRetryCount  
            clusterSettings,
        }
                    }
            CoordinationStateRejectedException cause = (CoordinationStateRejectedException) handler.transportException.getRootCause();
    enum Response {
        final TransportService transportService = mockTransport.createTransportService(
                final Response response = responseHolder[0];
        }
import static org.hamcrest.Matchers.instanceOf;  
        }  
import org.opensearch.common.settings.ClusterSettings;
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
    }
                assertThat(action, equalTo(LEADER_CHECK_ACTION_NAME));  
                assertThat(action, equalTo(LEADER_CHECK_ACTION_NAME));
            e -> fail("shouldn't be checking anything"),  
            rq -> new LeaderCheckRequest(new DiscoveryNode(randomAlphaOfLength(10), buildNewFakeTransportAddress(), Version.CURRENT))
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_INTERVAL_SETTING;
                    public void run() {
package org.opensearch.cluster.coordination;
 *  
        TransportException transportException;  
            transportService.connectToNode(leader); // need to connect first for disconnect to have any effect
import java.util.concurrent.atomic.AtomicLong;
                lessThanOrEqualTo(
import org.opensearch.transport.TransportRequest;  
        {
        };
        {  
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        if (randomBoolean()) {
    }
                deterministicTaskQueue.advanceTime();  
                deterministicTaskQueue.runAllRunnableTasks();
                deterministicTaskQueue.scheduleAt(deterministicTaskQueue.getCurrentTimeMillis() + responseDelay, new Runnable() {
import org.opensearch.transport.ConnectTransportException;
            boundTransportAddress -> localNode,
                if (action.equals(HANDSHAKE_ACTION_NAME)) {
            settingsBuilder.put(LEADER_CHECK_RETRY_COUNT_SETTING.getKey(), leaderCheckRetryCount);
            assertTrue(leaderFailed.get());
        leaderChecker.updateLeader(leader2);  
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;
                final long responseDelay = randomLongBetween(0, leaderCheckTimeoutMillis + (mustSucceed ? -1 : 60000));
            (CopyFunction<LeaderCheckRequest>) rq -> copyWriteable(rq, writableRegistry(), LeaderCheckRequest::new),
 * The OpenSearch Contributors require contributions made to  
            emptySet(),  
    public void testFollowerFailsImmediatelyOnDisconnection() {
import org.opensearch.core.common.io.stream.StreamInput;
        {
            while (deterministicTaskQueue.getCurrentTimeMillis() < 10 * LEADER_CHECK_INTERVAL_SETTING.get(Settings.EMPTY).millis()) {
                deterministicTaskQueue.advanceTime();
        @Override  
 * license agreements. See the NOTICE file distributed with
                                handleResponse(requestId, Empty.INSTANCE);
            logger.info("--> checking that no failure is detected in {} checks", maxCheckCount);
                                break;  
 * Unless required by applicable law or agreed to in writing,
                assertEquals(node, leader);  
        );  
            assertThat(handler.transportException.getRootCause(), instanceOf(NodeHealthCheckFailureException.class));
                            case SUCCESS:
        };  
                equalTo("rejecting leader check from [" + otherNode + "] since node is unhealthy [unhealthy-info]")
            deterministicTaskQueue.advanceTime();
            }  
                    consecutiveFailedRequestsCount = 0;
 * software distributed under the License is distributed on an
        LeaderCheckRequest request = new LeaderCheckRequest(
            deterministicTaskQueue.runAllRunnableTasks();
            assertThat(cause.getMessage(), equalTo("rejecting leader check since [" + otherNode + "] has been removed from the cluster"));
 * GitHub history for details.
        final TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();  
        final AtomicBoolean leaderFailed = new AtomicBoolean();
                    consecutiveFailedRequestsCount += 1;  
                deterministicTaskQueue.runAllRunnableTasks();  
        public String executor() {
        transportService.start();
                            handleResponse(requestId, Empty.INSTANCE);
        final DiscoveryNode leader2 = randomBoolean()  
        };
                    @Override
            emptySet(),
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        final DiscoveryNode leader = new DiscoveryNode("leader", buildNewFakeTransportAddress(), Version.CURRENT);  
            leaderChecker.setCurrentNodes(discoveryNodes);
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING;
            leaderCheckTimeoutMillis = randomLongBetween(1, 60000);
        }  
import org.opensearch.cluster.coordination.LeaderChecker.LeaderCheckRequest;
            NoopTracer.INSTANCE
                deterministicTaskQueue.runAllRunnableTasks();
            assertFalse(handler.successfulResponseReceived);  
            NoopTracer.INSTANCE  
            }  
                    @Override
            final CapturingTransportResponseHandler handler = new CapturingTransportResponseHandler();
            transportService.sendRequest(localNode, LEADER_CHECK_ACTION_NAME, new LeaderCheckRequest(otherNode), handler);  
        transportService.acceptIncomingRequests();  
            assertFalse(leaderFailed.get());
import org.opensearch.Version;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        final TransportService transportService = mockTransport.createTransportService(  
                        }  
        final MockTransport mockTransport = new MockTransport() {
        responseHolder[0] = Response.SUCCESS;
 * compatible open source license.
            @Override
import static org.opensearch.transport.TransportService.HANDSHAKE_ACTION_NAME;
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 *
                deterministicTaskQueue.runAllRunnableTasks();  
                }  
        leaderChecker.updateLeader(leader);
        assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("leader.checker.failure.count").getCounterValue());  
        final DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
        }
        if (randomBoolean()) {  
                }
            deterministicTaskQueue.runAllRunnableTasks();  
        public void handleResponse(Empty response) {
            transportService.disconnectFromNode(leader);  
        leaderChecker.updateLeader(leader);
                }
                deterministicTaskQueue.runAllRunnableTasks();  
                    public String toString() {  
        TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
            assertThat(e.getMessage(), endsWith("failed health checks"));
                deterministicTaskQueue.advanceTime();
        leaderChecker.updateLeader(null);  
            settings,
                    }  
            assertFalse(leaderFailed.get());  
import static org.opensearch.transport.TransportService.NOOP_TRANSPORT_INTERCEPTOR;
 */
        }  
        {  
                    }  
            emptySet(),
        {
        );  
        nodeHealthServiceStatus.getAndSet(new StatusInfo(HEALTHY, "healthy-info"));  
        final Response[] responseHolder = new Response[] { Response.SUCCESS };
            }
            emptySet(),  
            .localNodeId(localNode.getId())
