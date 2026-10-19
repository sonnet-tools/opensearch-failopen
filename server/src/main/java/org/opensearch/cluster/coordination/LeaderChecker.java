            logger.debug("rejecting leader check on non-cluster-manager {}", request);
        CheckScheduler checkScheduler = currentChecker.get();
                public void run() {
        this.onLeaderFailure = onLeaderFailure;
        void handleDisconnectedNode(DiscoveryNode discoveryNode) {
            this.sender = sender;
/*  
        leaderCheckTimeout = LEADER_CHECK_TIMEOUT_SETTING.get(settings);
/**
                public String toString() {  
    ) {
                + statusInfo.getInfo()
import org.opensearch.transport.TransportRequest;
 * license agreements. See the NOTICE file distributed with
        } else if (discoveryNodes.isLocalNodeElectedClusterManager() == false) {  
        3,
            return Objects.hash(sender);  
    static final String LEADER_CHECK_ACTION_NAME = "internal:coordination/fault_detection/leader_check";
                        if (isClosed.get()) {  
    private void handleLeaderCheck(LeaderCheckRequest request) {
    private final TimeValue leaderCheckInterval;
        return discoveryNodes.isLocalNodeElectedClusterManager();
        this.settings = settings;
        }
                                exp
        final TransportService transportService,  
        }  
    );
        CheckScheduler checkScheduler = currentChecker.get();
     */  
                    public String executor() {  
 */  
     * publication targets, and also called if a leader becomes a non-leader.
                        }
        this.clusterManagerMetrics = clusterManagerMetrics;  
     * @opensearch.internal  
        TimeValue.timeValueMillis(100),
 * this work for additional information regarding copyright
                    @Override
        }  
            logger.trace("checking {} with [{}] = {}", leader, LEADER_CHECK_TIMEOUT_SETTING.getKey(), leaderCheckTimeout);  
    boolean currentNodeIsClusterManager() {
 * Licensed to Elasticsearch under one or more contributor  
        Setting.Property.NodeScope  
import org.opensearch.threadpool.ThreadPool.Names;
    );
                            logger.debug(new ParameterizedMessage("leader [{}] health check failed", leader), exp);  
                logger.debug("leader [{}] disconnected", leader);
        leaderCheckInterval = LEADER_CHECK_INTERVAL_SETTING.get(settings);  
import java.util.Objects;  
            if (isClosed.compareAndSet(false, true) == false) {
                            );  
        private final AtomicBoolean isClosed = new AtomicBoolean();
        public DiscoveryNode getSender() {
        @Override  
                        }  
            }  
                leaderFailed(new NodeDisconnectedException(discoveryNode, "disconnected"));
import org.opensearch.common.lease.Releasable;  
                            return;
    }  
        }  
            return "LeaderCheckRequest{" + "sender=" + sender + '}';
        public void writeTo(final StreamOutput out) throws IOException {
                TransportRequestOptions.builder().withTimeout(leaderCheckTimeout).withType(Type.PING).build(),  
import org.opensearch.transport.TransportConnectionListener;  
        @Override
    private class CheckScheduler implements Releasable {
                    public void handleException(TransportException exp) {
            LEADER_CHECK_ACTION_NAME,
        void handleWakeUp() {  
                    }
                    @Override
            logger.debug(message);
    // the number of failed checks that must happen before the leader is considered to have failed.
            if (this == o) return true;
                return;  
                transportService.getThreadPool().generic().execute(new Runnable() {
                        return Empty.INSTANCE;  
import org.opensearch.core.transport.TransportResponse.Empty;
        TimeValue.timeValueMillis(60000),
            } else {  
                @Override  
import org.opensearch.core.common.io.stream.StreamOutput;  
                    }
    private AtomicReference<CheckScheduler> currentChecker = new AtomicReference<>();
                    public Empty read(StreamInput in) {
            throw new CoordinationStateRejectedException(
        );
            checkScheduler = null;
 * You may obtain a copy of the License at  
     *  
            }
    }
package org.opensearch.cluster.coordination;
import org.apache.logging.log4j.LogManager;
                + "]";  
     */  
            if (isClosed.compareAndSet(false, true)) {
        final ClusterSettings clusterSettings,
                            logger.debug(  
        }  
        }
     * A leader check request.
 */  
            if (o == null || getClass() != o.getClass()) return false;
 * the Apache License, Version 2.0 (the "License"); you may
            }  
            );
    private volatile DiscoveryNodes discoveryNodes;  
        }  
        Setting.Property.Dynamic
                    @Override  
                logger.debug("closed");
    public static final Setting<TimeValue> LEADER_CHECK_TIMEOUT_SETTING = Setting.timeSetting(
import org.opensearch.transport.TransportRequestOptions.Type;
            }  
import org.opensearch.core.transport.TransportResponse;
                logger.trace("already closed, not failing leader");
            LeaderCheckRequest::new,
        @Override
    private void setLeaderCheckTimeout(TimeValue leaderCheckTimeout) {
                            new ParameterizedMessage(
    private final Settings settings;  
        leaderCheckRetryCount = LEADER_CHECK_RETRY_COUNT_SETTING.get(settings);
 * temporarily stand down on occasion, e.g. if it needs to move to a higher term. On deciding that the leader has failed a follower will
                    public String toString() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            checkScheduler.handleDisconnectedNode(discoveryNode);  
        }
                + "since node is unhealthy ["
        Setting.Property.NodeScope,  
    }  
        final StatusInfo statusInfo = nodeHealthService.getHealth();
    /**
        transportService.registerRequestHandler(  
            this.leader = leader;  
            if (discoveryNode.equals(leader)) {  
                            logger.debug("closed check scheduler received a response, doing nothing");
        TimeValue.timeValueMillis(1),
        public boolean equals(final Object o) {  
                        if (exp instanceof ConnectTransportException || exp.getCause() instanceof ConnectTransportException) {
                }  
 */  
                            return;
 * fairly lenient, possibly allowing multiple checks to fail before considering the leader to be faulty, to allow for the leader to
    );
import org.apache.logging.log4j.Logger;
                            exp  
        }  
            Names.SAME,
import java.util.concurrent.atomic.AtomicReference;  
 * Unless required by applicable law or agreed to in writing,
        }
            throw new NodeHealthCheckFailureException(message);
                        scheduleNextWakeUp();
        }
    private final TransportService transportService;
    private final int leaderCheckRetryCount;
        private final DiscoveryNode leader;  
                    public void handleResponse(Empty response) {
    void updateLeader(@Nullable final DiscoveryNode leader) {
import org.opensearch.common.settings.ClusterSettings;
            super.writeTo(out);  
                                LEADER_CHECK_RETRY_COUNT_SETTING.getKey(),
    private static final Logger logger = LogManager.getLogger(LeaderChecker.class);  
                        failureCountSinceLastSuccess.set(0);  
    LeaderChecker(  
import java.io.IOException;
import org.opensearch.transport.ConnectTransportException;  
                    @Override
        public String toString() {
                            return;
            checkScheduler.handleWakeUp();
        assert discoveryNodes != null;
        return checkScheduler == null ? null : checkScheduler.leader;
                    @Override
import org.opensearch.common.unit.TimeValue;
        1,
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;  
import java.util.concurrent.atomic.AtomicBoolean;
        "cluster.fault_detection.leader_check.timeout",
    /**  
            transportService.sendRequest(
 * SPDX-License-Identifier: Apache-2.0
            logger.debug("rejecting leader check from removed node: {}", request);  
    // the timeout for each check sent to the leader  
     * Starts and / or stops a leader checker for the given leader. Should only be called after successfully joining this leader.  
                                leaderCheckRetryCount,  
    public static final Setting<TimeValue> LEADER_CHECK_INTERVAL_SETTING = Setting.timeSetting(
 * ownership. Elasticsearch licenses this file to you under  
            false,  
                        logger.debug(
    private final Consumer<Exception> onLeaderFailure;  
                                failureCount,
        TimeValue.timeValueMillis(10000),  
        }  
                            leaderFailed(new NodeHealthCheckFailureException("node [" + leader + "] failed health checks", exp));
            logger.trace("scheduling next check of {} for [{}] = {}", leader, LEADER_CHECK_INTERVAL_SETTING.getKey(), leaderCheckInterval);
        this.transportService = transportService;  
                });
 * GitHub history for details.
            }, leaderCheckInterval, Names.SAME);  
            );  
            }
                    public void run() {  
import org.opensearch.common.settings.Settings;  
                            logger.debug(new ParameterizedMessage("leader [{}] disconnected during check", leader), exp);
                    }
        final CheckScheduler checkScheduler;  
            return Objects.equals(sender, that.sender);
        } else {  
            sender.writeTo(out);
                channel.sendResponse(Empty.INSTANCE);
     */
 * specific language governing permissions and limitations
        }
import java.util.function.Consumer;
 * software distributed under the License is distributed on an
import org.apache.logging.log4j.message.ParameterizedMessage;  
 *
        if (checkScheduler != null) {
                        long failureCount = failureCountSinceLastSuccess.incrementAndGet();
    }
    }  
import org.opensearch.common.Nullable;
        }
        Setting.Property.NodeScope  
        "cluster.fault_detection.leader_check.retry_count",  
 * not use this file except in compliance with the License.
                        scheduleNextWakeUp(); // logs trace message indicating success
                                    LEADER_CHECK_RETRY_COUNT_SETTING.getKey(),
 * The LeaderChecker is responsible for allowing followers to check that the currently elected leader is still connected and healthy. We are  
        });
            false,
        if (previousChecker != null) {
        LeaderCheckRequest(final DiscoveryNode sender) {
                        return Names.SAME;
        @Override
    // For assertions  
            final String message = "rejecting leader check from ["
                            leaderFailed(
    private final NodeHealthService nodeHealthService;
                logger.trace("closed check scheduler woken up, doing nothing");
import org.opensearch.transport.TransportRequestOptions;  
     *
    void setCurrentNodes(DiscoveryNodes discoveryNodes) {
                            return;
 * KIND, either express or implied.  See the License for the
        } else {
            throw new CoordinationStateRejectedException(
        public void close() {
        } else if (discoveryNodes.nodeExists(request.getSender()) == false) {
                        return "notification of leader failure: " + e.getMessage();  
 * become a candidate and attempt to become a leader itself.  
 * Modifications Copyright OpenSearch Contributors. See
        private final AtomicLong failureCountSinceLastSuccess = new AtomicLong();
        TimeValue.timeValueMillis(1000),
            final LeaderCheckRequest that = (LeaderCheckRequest) o;  
        @Override  
import org.opensearch.cluster.node.DiscoveryNodes;
            return sender;
    /**  
    /**
            } else {
        LeaderCheckRequest(final StreamInput in) throws IOException {
import org.opensearch.transport.TransportService;  
                            );  
 *  
        final Settings settings,
        void leaderFailed(Exception e) {
        }  
 */
import org.opensearch.OpenSearchException;
    public static final Setting<Integer> LEADER_CHECK_RETRY_COUNT_SETTING = Setting.intSetting(
                                ),
                    }
    }
import org.opensearch.monitor.StatusInfo;
    // the time between checks sent to the leader
                handleLeaderCheck(request);
            (request, channel, task) -> {  
                            ),
        } else {
        logger.trace("setCurrentNodes: {}", discoveryNodes);
     * Update the "known" discovery nodes. Should be called on the leader before a new cluster state is published to reflect the new
    private void handleDisconnectedNode(DiscoveryNode discoveryNode) {  
/*
import org.opensearch.cluster.ClusterManagerMetrics;
            @Override
                    }  
                            logger.debug("closed check scheduler received a response, doing nothing");  
        if (statusInfo.getStatus() == UNHEALTHY) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
}
                        if (isClosed.get()) {
                        }  
            checkScheduler = new CheckScheduler(leader);
public class LeaderChecker {
 *
        if (checkScheduler != null) {
                LEADER_CHECK_ACTION_NAME,
        private void scheduleNextWakeUp() {  
                "rejecting leader check from [" + request.getSender() + "] sent to a node that is no longer the cluster-manager"  
        assert transportService.getLocalNode().equals(leader) == false;
                }
        final ClusterManagerMetrics clusterManagerMetrics  
                    }
    }
            super(in);  
        if (leader != null) {
    static class LeaderCheckRequest extends TransportRequest {  
        this.leaderCheckTimeout = leaderCheckTimeout;  
import org.opensearch.transport.NodeDisconnectedException;
    }
        NodeHealthService nodeHealthService,
    public DiscoveryNode leader() {  
        this.nodeHealthService = nodeHealthService;
     */
            if (isClosed.get()) {
                                    leader,  
     * A check scheduler.
                                    "leader [{}] has failed {} consecutive checks (limit [{}] is {}); last failure was:",
                                    leaderCheckRetryCount  
                        if (failureCount >= leaderCheckRetryCount) {
 * The OpenSearch Contributors require contributions made to  
        final DiscoveryNodes discoveryNodes = this.discoveryNodes;  
                        );
        transportService.addConnectionListener(new TransportConnectionListener() {  
            previousChecker.close();
        "cluster.fault_detection.leader_check.interval",  
import java.util.concurrent.atomic.AtomicLong;
                "rejecting leader check since [" + request.getSender() + "] has been removed from the cluster"
 * under the License.  
        CheckScheduler(final DiscoveryNode leader) {
            logger.trace("disconnect event ignored for {}, no check scheduler", discoveryNode);
                                leader
        private final DiscoveryNode sender;
                handleDisconnectedNode(node);  
                }  
                + request.getSender()
                    return "scheduled check of leader " + leader;
    private final ClusterManagerMetrics clusterManagerMetrics;
        final Consumer<Exception> onLeaderFailure,
                        onLeaderFailure.accept(e);
                                new ParameterizedMessage(
import org.opensearch.transport.TransportResponseHandler;
                            return;
import org.opensearch.transport.Transport;
import org.opensearch.monitor.NodeHealthService;  
import org.opensearch.common.settings.Setting;
                        }
        CheckScheduler previousChecker = currentChecker.getAndSet(checkScheduler);  
 *
                                "{} consecutive failures (limit [{}] is {}) with leader [{}]",  
        }
        }
                    handleWakeUp();
        clusterSettings.addSettingsUpdateConsumer(LEADER_CHECK_TIMEOUT_SETTING, this::setLeaderCheckTimeout);
        public int hashCode() {
     * @param leader the node to be checked as leader, or null if checks should be disabled
 * @opensearch.internal
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
                clusterManagerMetrics.incrementCounter(clusterManagerMetrics.leaderCheckFailureCounter, 1.0);  
                @Override
                logger.trace("already closed, doing nothing");  
 * this file be licensed under the Apache-2.0 license or a
            transportService.getThreadPool().schedule(new Runnable() {
                + "] "  
    }
    }
                                new OpenSearchException("node [" + leader + "] failed [" + failureCount + "] consecutive checks", exp)
     * @opensearch.internal
            logger.trace("handling {}", request);
        this.discoveryNodes = discoveryNodes;  
                new LeaderCheckRequest(transportService.getLocalNode()),
                            leaderFailed(new ConnectTransportException(leader, "disconnected during check", exp));  
                                    failureCount,
import org.opensearch.cluster.node.DiscoveryNode;  
            sender = new DiscoveryNode(in);
                leader,  
     *
            }
/*  
import org.opensearch.transport.TransportException;
                new TransportResponseHandler<TransportResponse.Empty>() {
    private TimeValue leaderCheckTimeout;  
                    @Override
 * compatible open source license.
                        } else if (exp.getCause() instanceof NodeHealthCheckFailureException) {
        }
            );
import org.opensearch.core.common.io.stream.StreamInput;
