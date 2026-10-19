import org.opensearch.transport.TransportConnectionListener;
                    public void handleResponse(Empty response) {
                            return;
/*
            );
     */
                }
    private void handleDisconnectedNode(DiscoveryNode discoveryNode) {
    public DiscoveryNode leader() {
                                leader
            super(in);
        public int hashCode() {
 *
        transportService.registerRequestHandler(
import org.opensearch.threadpool.ThreadPool.Names;
import org.opensearch.transport.TransportRequestOptions;
            previousChecker.close();
    void updateLeader(@Nullable final DiscoveryNode leader) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.transport.TransportRequest;
/*
        private final AtomicLong failureCountSinceLastSuccess = new AtomicLong();
     *
            sender = new DiscoveryNode(in);
        CheckScheduler checkScheduler = currentChecker.get();
import org.opensearch.transport.TransportRequestOptions.Type;
                        if (isClosed.get()) {
                + "] "
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
        }
                            leaderFailed(
    private final TimeValue leaderCheckInterval;
            checkScheduler = null;
                                    LEADER_CHECK_RETRY_COUNT_SETTING.getKey(),
     * @opensearch.internal
    /**
                    }
                @Override
import org.opensearch.cluster.node.DiscoveryNodes;
        LeaderCheckRequest(final StreamInput in) throws IOException {
        public boolean equals(final Object o) {
import java.io.IOException;
     * @opensearch.internal
            } else {
 * this file be licensed under the Apache-2.0 license or a
        } else if (discoveryNodes.nodeExists(request.getSender()) == false) {
    /**
    }
            sender.writeTo(out);
        @Override
                logger.trace("already closed, doing nothing");
                    }
                    @Override
    public static final Setting<TimeValue> LEADER_CHECK_TIMEOUT_SETTING = Setting.timeSetting(
                    @Override
    // the number of failed checks that must happen before the leader is considered to have failed.
                            logger.debug(new ParameterizedMessage("leader [{}] disconnected during check", leader), exp);
                + "since node is unhealthy ["
                        scheduleNextWakeUp();
import org.opensearch.transport.NodeDisconnectedException;
        clusterSettings.addSettingsUpdateConsumer(LEADER_CHECK_TIMEOUT_SETTING, this::setLeaderCheckTimeout);
                                new OpenSearchException("node [" + leader + "] failed [" + failureCount + "] consecutive checks", exp)
            Names.SAME,
        CheckScheduler checkScheduler = currentChecker.get();
                    public void run() {
                    handleWakeUp();
        return checkScheduler == null ? null : checkScheduler.leader;
        public DiscoveryNode getSender() {
    // the timeout for each check sent to the leader
        this.clusterManagerMetrics = clusterManagerMetrics;
    ) {
        });
        final TransportService transportService,
                return;
import org.apache.logging.log4j.LogManager;
                        return Names.SAME;
        public void close() {
                channel.sendResponse(Empty.INSTANCE);
    private final int leaderCheckRetryCount;
        }
 * specific language governing permissions and limitations
                        return "notification of leader failure: " + e.getMessage();
                            return;
                        } else if (exp.getCause() instanceof NodeHealthCheckFailureException) {
                                exp
    }
                        if (failureCount >= leaderCheckRetryCount) {
                    @Override
                            exp
                            logger.debug(
        TimeValue.timeValueMillis(100),
            @Override
    }
 *
                        logger.debug(
        final ClusterSettings clusterSettings,
        private final DiscoveryNode leader;
            throw new CoordinationStateRejectedException(
    /**
    boolean currentNodeIsClusterManager() {
                        );
import org.opensearch.common.settings.Settings;
                        }
        Setting.Property.NodeScope,
                transportService.getThreadPool().generic().execute(new Runnable() {
        "cluster.fault_detection.leader_check.timeout",
            final LeaderCheckRequest that = (LeaderCheckRequest) o;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        leaderCheckInterval = LEADER_CHECK_INTERVAL_SETTING.get(settings);
import org.opensearch.cluster.ClusterManagerMetrics;
        }
import org.opensearch.common.Nullable;
    );
        this.nodeHealthService = nodeHealthService;
        TimeValue.timeValueMillis(1),
                                LEADER_CHECK_RETRY_COUNT_SETTING.getKey(),
 * the Apache License, Version 2.0 (the "License"); you may
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
        } else if (discoveryNodes.isLocalNodeElectedClusterManager() == false) {
                                "{} consecutive failures (limit [{}] is {}) with leader [{}]",
        LeaderCheckRequest(final DiscoveryNode sender) {
    private static final Logger logger = LogManager.getLogger(LeaderChecker.class);
                + request.getSender()
    }
                new TransportResponseHandler<TransportResponse.Empty>() {
        public void writeTo(final StreamOutput out) throws IOException {
                    }
     * Update the "known" discovery nodes. Should be called on the leader before a new cluster state is published to reflect the new
import java.util.function.Consumer;
                    @Override
        );
            transportService.sendRequest(
                clusterManagerMetrics.incrementCounter(clusterManagerMetrics.leaderCheckFailureCounter, 1.0);
        @Override
                            new ParameterizedMessage(
 * You may obtain a copy of the License at
                            return;
    );
                    @Override
        @Override
            }
/*
import org.opensearch.common.settings.ClusterSettings;
 * ownership. Elasticsearch licenses this file to you under
            }, leaderCheckInterval, Names.SAME);
        leaderCheckTimeout = LEADER_CHECK_TIMEOUT_SETTING.get(settings);
            return "LeaderCheckRequest{" + "sender=" + sender + '}';
                + "]";
        } else {
        1,
        }
                + statusInfo.getInfo()
            if (this == o) return true;
                        return Empty.INSTANCE;
            logger.trace("disconnect event ignored for {}, no check scheduler", discoveryNode);
        CheckScheduler(final DiscoveryNode leader) {
        }
                            );
        this.discoveryNodes = discoveryNodes;
 * temporarily stand down on occasion, e.g. if it needs to move to a higher term. On deciding that the leader has failed a follower will
    }
        this.settings = settings;
import org.apache.logging.log4j.Logger;
 * SPDX-License-Identifier: Apache-2.0
                LEADER_CHECK_ACTION_NAME,
                                    "leader [{}] has failed {} consecutive checks (limit [{}] is {}); last failure was:",
    private class CheckScheduler implements Releasable {
    }
                                ),
 */
        if (checkScheduler != null) {
 */
            logger.debug(message);
 *
    }
     */
            (request, channel, task) -> {
import org.opensearch.core.transport.TransportResponse.Empty;
            false,
                            leaderFailed(new NodeHealthCheckFailureException("node [" + leader + "] failed health checks", exp));
        }
import org.opensearch.monitor.NodeHealthService;
                        scheduleNextWakeUp(); // logs trace message indicating success
                }
                    }
     *
    public static final Setting<TimeValue> LEADER_CHECK_INTERVAL_SETTING = Setting.timeSetting(
    }
        final StatusInfo statusInfo = nodeHealthService.getHealth();
        private final AtomicBoolean isClosed = new AtomicBoolean();
import org.opensearch.OpenSearchException;
        CheckScheduler previousChecker = currentChecker.getAndSet(checkScheduler);
        leaderCheckRetryCount = LEADER_CHECK_RETRY_COUNT_SETTING.get(settings);
    private void handleLeaderCheck(LeaderCheckRequest request) {
    private final ClusterManagerMetrics clusterManagerMetrics;
                                    leaderCheckRetryCount
            logger.trace("handling {}", request);
            return Objects.equals(sender, that.sender);
                        failureCountSinceLastSuccess.set(0);
                leader,
import org.opensearch.transport.Transport;
    );
            transportService.getThreadPool().schedule(new Runnable() {
        void handleDisconnectedNode(DiscoveryNode discoveryNode) {
        "cluster.fault_detection.leader_check.retry_count",
    }
            logger.debug("rejecting leader check on non-cluster-manager {}", request);
            this.leader = leader;
                logger.trace("already closed, not failing leader");
                            ),
 * Modifications Copyright OpenSearch Contributors. See
            LeaderCheckRequest::new,
                });
                    public String toString() {
import org.apache.logging.log4j.message.ParameterizedMessage;
            return sender;
                new LeaderCheckRequest(transportService.getLocalNode()),
                        if (isClosed.get()) {
     * A check scheduler.
import org.opensearch.common.unit.TimeValue;
            logger.trace("checking {} with [{}] = {}", leader, LEADER_CHECK_TIMEOUT_SETTING.getKey(), leaderCheckTimeout);
            return Objects.hash(sender);
                        if (exp instanceof ConnectTransportException || exp.getCause() instanceof ConnectTransportException) {
     */
        public String toString() {
        }
    private final NodeHealthService nodeHealthService;
        }
            this.sender = sender;
    public static final Setting<Integer> LEADER_CHECK_RETRY_COUNT_SETTING = Setting.intSetting(
        Setting.Property.Dynamic
            false,
 * not use this file except in compliance with the License.
            LEADER_CHECK_ACTION_NAME,
    LeaderChecker(
     */
            }
                            logger.debug(new ParameterizedMessage("leader [{}] health check failed", leader), exp);
        } else {
            super.writeTo(out);
            if (isClosed.compareAndSet(false, true) == false) {
                    return "scheduled check of leader " + leader;
     * Starts and / or stops a leader checker for the given leader. Should only be called after successfully joining this leader.
import org.opensearch.transport.TransportService;
        }
    private TimeValue leaderCheckTimeout;
        }
import java.util.Objects;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.node.DiscoveryNode;
                handleLeaderCheck(request);
        } else {
        if (leader != null) {
                            leaderFailed(new ConnectTransportException(leader, "disconnected during check", exp));
    /**
        }
                    public void handleException(TransportException exp) {
                        }
                @Override
            } else {
        this.leaderCheckTimeout = leaderCheckTimeout;
                    }
    // For assertions
 * this work for additional information regarding copyright
                                failureCount,
        if (statusInfo.getStatus() == UNHEALTHY) {
        assert discoveryNodes != null;
                }
import org.opensearch.core.common.io.stream.StreamOutput;
                            logger.debug("closed check scheduler received a response, doing nothing");
                        }
        }
        "cluster.fault_detection.leader_check.interval",
        }
 * under the License.
                handleDisconnectedNode(node);
                logger.trace("closed check scheduler woken up, doing nothing");
            if (discoveryNode.equals(leader)) {
                                leaderCheckRetryCount,
            checkScheduler = new CheckScheduler(leader);
        this.onLeaderFailure = onLeaderFailure;
 */
     * @param leader the node to be checked as leader, or null if checks should be disabled
                        onLeaderFailure.accept(e);
 * GitHub history for details.
        TimeValue.timeValueMillis(1000),
            throw new NodeHealthCheckFailureException(message);
/**
import org.opensearch.common.lease.Releasable;
    private void setLeaderCheckTimeout(TimeValue leaderCheckTimeout) {
    }
        Setting.Property.NodeScope
                            logger.debug("closed check scheduler received a response, doing nothing");
        private void scheduleNextWakeUp() {
public class LeaderChecker {
                                    failureCount,
                            return;
                        long failureCount = failureCountSinceLastSuccess.incrementAndGet();
    // the time between checks sent to the leader
import org.opensearch.transport.TransportResponseHandler;
        TimeValue.timeValueMillis(10000),
 * KIND, either express or implied.  See the License for the
    private final TransportService transportService;
    void setCurrentNodes(DiscoveryNodes discoveryNodes) {
    private volatile DiscoveryNodes discoveryNodes;
 *
        this.transportService = transportService;
            if (isClosed.compareAndSet(false, true)) {
        }
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.transport.ConnectTransportException;
                TransportRequestOptions.builder().withTimeout(leaderCheckTimeout).withType(Type.PING).build(),
 * Unless required by applicable law or agreed to in writing,
        NodeHealthService nodeHealthService,
        final DiscoveryNodes discoveryNodes = this.discoveryNodes;
            }
package org.opensearch.cluster.coordination;
        @Override
        assert transportService.getLocalNode().equals(leader) == false;
 * become a candidate and attempt to become a leader itself.
        private final DiscoveryNode sender;
        transportService.addConnectionListener(new TransportConnectionListener() {
                        }
                            );
        final CheckScheduler checkScheduler;
     * publication targets, and also called if a leader becomes a non-leader.
                logger.debug("closed");
                    public String executor() {
            if (o == null || getClass() != o.getClass()) return false;
        }
 * @opensearch.internal
        Setting.Property.NodeScope
                public void run() {
        return discoveryNodes.isLocalNodeElectedClusterManager();
            }
import org.opensearch.common.settings.Setting;
                    }
        }
                public String toString() {
        @Override
        }
            checkScheduler.handleWakeUp();
import java.util.concurrent.atomic.AtomicBoolean;
    static class LeaderCheckRequest extends TransportRequest {
 */
                            return;
    private AtomicReference<CheckScheduler> currentChecker = new AtomicReference<>();
 * Licensed to Elasticsearch under one or more contributor
        final ClusterManagerMetrics clusterManagerMetrics
            }
}
     *
        void handleWakeUp() {
            logger.debug("rejecting leader check from removed node: {}", request);
import java.util.concurrent.atomic.AtomicLong;
        }
        3,
 *     http://www.apache.org/licenses/LICENSE-2.0
                logger.debug("leader [{}] disconnected", leader);
import org.opensearch.core.transport.TransportResponse;
            checkScheduler.handleDisconnectedNode(discoveryNode);
     * A leader check request.
    private final Consumer<Exception> onLeaderFailure;
        if (previousChecker != null) {
                                new ParameterizedMessage(
import org.opensearch.transport.TransportException;
 * compatible open source license.
                                    leader,
                leaderFailed(new NodeDisconnectedException(discoveryNode, "disconnected"));
    private final Settings settings;
 * The LeaderChecker is responsible for allowing followers to check that the currently elected leader is still connected and healthy. We are
        final Settings settings,
        void leaderFailed(Exception e) {
            );
                    @Override
            if (isClosed.get()) {
            throw new CoordinationStateRejectedException(
    static final String LEADER_CHECK_ACTION_NAME = "internal:coordination/fault_detection/leader_check";
            final String message = "rejecting leader check from ["
            logger.trace("scheduling next check of {} for [{}] = {}", leader, LEADER_CHECK_INTERVAL_SETTING.getKey(), leaderCheckInterval);
            }
 * software distributed under the License is distributed on an
        final Consumer<Exception> onLeaderFailure,
        if (checkScheduler != null) {
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.monitor.StatusInfo;
            );
 * fairly lenient, possibly allowing multiple checks to fail before considering the leader to be faulty, to allow for the leader to
                "rejecting leader check since [" + request.getSender() + "] has been removed from the cluster"
        TimeValue.timeValueMillis(60000),
                "rejecting leader check from [" + request.getSender() + "] sent to a node that is no longer the cluster-manager"
                    public Empty read(StreamInput in) {
        logger.trace("setCurrentNodes: {}", discoveryNodes);
