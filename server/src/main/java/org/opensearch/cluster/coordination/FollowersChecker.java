        if (request.term < responder.term) {
        private final DiscoveryNode sender;
        void failNode(String reason) {
    );
                transportChannel.sendResponse(Empty.INSTANCE);
public class FollowersChecker {
import org.opensearch.cluster.ClusterManagerMetrics;
            });
                            return;
            transportService.sendRequest(
        }
 *
    private class FollowerChecker {
    private void setFollowerCheckTimeout(TimeValue followerCheckTimeout) {
        final long term;
import org.opensearch.threadpool.ThreadPool.Names;
                    @Override
import org.opensearch.transport.TransportRequestOptions.Type;
    public static final String NODE_LEFT_REASON_LAGGING = "lagging";
    FastResponseState getFastResponseState() {
            throw new CoordinationStateRejectedException("rejecting " + request + " since local state is " + this);
            transportService.getThreadPool().schedule(new Runnable() {
        BiConsumer<DiscoveryNode, String> onNodeFailure,
    }
    }
        private void scheduleNextWakeUp() {
                    handleWakeUp();
            faultyNodes.removeIf(isUnknownNode);
        TimeValue.timeValueMillis(10000),
 * Unless required by applicable law or agreed to in writing,
            logger.info(() -> new ParameterizedMessage("{} disconnected", followerChecker));
                }
                        }
    // the number of failed checks that must happen before the follower is considered to have failed.
        }
        FastResponseState(final long term, final Mode mode) {
                            reason = NODE_LEFT_REASON_DISCONNECTED;
                        if (running() == false) {
                    return;
import org.opensearch.transport.TransportResponseHandler;
                    }
        void start() {
import org.apache.logging.log4j.LogManager;
     * Update the set of known nodes, starting to check any new ones and stopping checking any previously-known-but-now-unknown ones.
            }
    // the time between checks sent to each node
            throw new NodeHealthCheckFailureException(message);
            }
/*
                + "discoveryNode="
    @Override
     */
        return fastResponseState;
            (request, transportChannel, task) -> handleFollowerCheck(request, transportChannel)
        private boolean running() {
import java.util.function.Consumer;
                new TransportResponseHandler<Empty>() {
     */
     * entirely on the network thread, and only if the fast path fails do we perform some work in the background, by notifying the
            final Set<DiscoveryNode> knownFollowers = new HashSet<>(faultyNodes);
            transportChannel.sendResponse(Empty.INSTANCE);
        }
            + ", followerCheckRetryCount="
                public String toString() {
        private int failureCountSinceLastSuccess;
                            logger.info(() -> new ParameterizedMessage("{} failed too many times", FollowerChecker.this), exp);
 * ownership. Elasticsearch licenses this file to you under
                    final FollowerChecker followerChecker = new FollowerChecker(discoveryNode);
 * under the License.
            return new HashSet<>(this.faultyNodes);
        Consumer<FollowerCheckRequest> handleRequestAndUpdateState,
                            logger.info(() -> new ParameterizedMessage("{} disconnected", FollowerChecker.this), exp);
        if (responder.mode == Mode.FOLLOWER && responder.term == request.term) {
 * Modifications Copyright OpenSearch Contributors. See
            false,
        synchronized (mutex) {
                    }
            false,
            handleWakeUp();
                }
        if (followerChecker != null) {
        fastResponseState = new FastResponseState(term, mode);
            FOLLOWER_CHECK_ACTION_NAME,
    }
        public FollowerCheckRequest(final long term, final DiscoveryNode sender) {
            @Override
    private volatile FastResponseState fastResponseState;
    private final Object mutex = new Object(); // protects writes to this state; read access does not need sync
                    && faultyNodes.contains(discoveryNode) == false) {
        }
        }
        TimeValue.timeValueMillis(1),
     * A checker for an individual follower.
        this.nodeHealthService = nodeHealthService;
                return "slow path response to " + request;
        public String toString() {
import org.opensearch.cluster.node.DiscoveryNode;
            this.term = term;
import org.opensearch.common.settings.ClusterSettings;
                discoveryNode,
            sender = new DiscoveryNode(in);
                        }
import org.opensearch.common.util.concurrent.AbstractRunnable;
            + ", followerCheckers="
 * license agreements. See the NOTICE file distributed with
     *
        });
                    @Override
            FollowerCheckRequest::new,
            + ", fastResponseState="
        }
import org.opensearch.transport.TransportService;
        }
                        followerCheckers.remove(discoveryNode);
    public void updateFastResponseState(final long term, final Mode mode) {
        }
import org.opensearch.common.unit.TimeValue;
 * GitHub history for details.
    }
     * Request to check follower.
        TransportService transportService,
        );
    public static final Setting<TimeValue> FOLLOWER_CHECK_INTERVAL_SETTING = Setting.timeSetting(
    /**
 *
    );
     * The system is normally in a state in which every follower remains a follower of a stable leader in a single term for an extended
            assert running();
import org.opensearch.transport.TransportConnectionListener;
package org.opensearch.cluster.coordination;
    /**
                }
            }, followerCheckInterval, Names.SAME);
                    }
    /**
                        if (running() == false) {
        public DiscoveryNode getSender() {
            return term == that.term && Objects.equals(sender, that.sender);
        @Override
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
            this.discoveryNode = discoveryNode;
    }
        @Override
 * The FollowersChecker is responsible for allowing a leader to check that its followers are still connected and healthy. On deciding that a
    private void handleDisconnectedNode(DiscoveryNode discoveryNode) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                        return Empty.INSTANCE;
import java.io.IOException;
    }
 * KIND, either express or implied.  See the License for the
        followerCheckRetryCount = FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings);
                    @Override
                    public String executor() {
     * period of time, and therefore our response to every follower check is the same. We handle this case with a single volatile read
                }
        "cluster.fault_detection.follower_check.retry_count",
            final Predicate<DiscoveryNode> isUnknownNode = n -> discoveryNodes.nodeExists(n) == false;
     */
 * specific language governing permissions and limitations
                @Override
        FollowerChecker(DiscoveryNode discoveryNode) {
 * SPDX-License-Identifier: Apache-2.0
        followerCheckInterval = FOLLOWER_CHECK_INTERVAL_SETTING.get(settings);
        final FastResponseState responder = this.fastResponseState;
            logger.trace("handleWakeUp: checking {} with {}", discoveryNode, request);
    private final TransportService transportService;
                        logger.trace("{} check successful", FollowerChecker.this);
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                    followerCheckers.put(discoveryNode, followerChecker);
            + '}';
     * FollowersChecker whenever our term or mode changes here.
     *
        }
import org.opensearch.transport.TransportRequestOptions;
 * You may obtain a copy of the License at
    ) {
import org.apache.logging.log4j.Logger;
                        logger.info("{} marking node as faulty", FollowerChecker.this);
        return "FollowersChecker{"
        clusterSettings.addSettingsUpdateConsumer(FOLLOWER_CHECK_INTERVAL_SETTING, this::setFollowerCheckInterval);
        updateFastResponseState(0, Mode.CANDIDATE);
     */
            + ", followerCheckTimeout="
                }
        });
import java.util.Objects;
                @Override
        synchronized (mutex) {
     */
    }
        this.settings = settings;
        public long getTerm() {
    private TimeValue followerCheckInterval;
        if (statusInfo.getStatus() == UNHEALTHY) {
    public static class FollowerCheckRequest extends TransportRequest {
                try {
     * @opensearch.internal
            final String message = "handleFollowerCheck: node is unhealthy ["
    private ClusterManagerMetrics clusterManagerMetrics;
    public static final String NODE_LEFT_REASON_FOLLOWER_CHECK_RETRY_FAIL = "followers check retry count exceeded";
        TimeValue.timeValueMillis(150000),
                        return Names.SAME;
     */
                + "]="
                + failureCountSinceLastSuccess
 * not use this file except in compliance with the License.
        }
            + followerCheckRetryCount
     * A fast response state.
import org.apache.logging.log4j.message.ParameterizedMessage;
    private static final Logger logger = LogManager.getLogger(FollowersChecker.class);
                + followerCheckRetryCount
            }
        this.onNodeFailure = onNodeFailure;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.monitor.NodeHealthService;
 * the Apache License, Version 2.0 (the "License"); you may
    );
            @Override
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.HashSet;
                            logger.info(() -> new ParameterizedMessage("{} health check failed", FollowerChecker.this), exp);
    }
        TimeValue.timeValueMillis(100),
        final Mode mode;
        transportService.registerRequestHandler(
            return "FollowerChecker{"
        Settings settings,
        private final long term;
import org.opensearch.transport.ConnectTransportException;
    }
                }
            super(in);
import org.opensearch.cluster.coordination.Coordinator.Mode;
        "cluster.fault_detection.follower_check.interval",
        }
                    return "detected failure of " + discoveryNode;
            discoveryNodes.clusterManagersFirstStream().forEach(discoveryNode -> {
        ClusterManagerMetrics clusterManagerMetrics
            return "FollowerCheckRequest{" + "term=" + term + ", sender=" + sender + '}';
            sender.writeTo(out);
        @Override
                        } else if (exp.getCause() instanceof NodeHealthCheckFailureException) {
        public String toString() {
        }
                        } else if (failureCountSinceLastSuccess >= followerCheckRetryCount) {
import org.opensearch.transport.Transport;
    private void handleFollowerCheck(FollowerCheckRequest request, TransportChannel transportChannel) throws IOException {
        @Override
                        scheduleNextWakeUp();
                logger.trace("handleWakeUp: not running");
                    followerChecker.start();
                logger.debug(new ParameterizedMessage("exception while responding to {}", request), e);
                        } else {
     * @opensearch.internal
            return "FastResponseState{" + "term=" + term + ", mode=" + mode + '}';
            out.writeLong(term);
        FollowerChecker followerChecker = followerCheckers.get(discoveryNode);
                        if (exp instanceof ConnectTransportException || exp.getCause() instanceof ConnectTransportException) {
        ClusterSettings clusterSettings,
import org.opensearch.cluster.node.DiscoveryNodes;
 */
            public String toString() {
        followerCheckTimeout = FOLLOWER_CHECK_TIMEOUT_SETTING.get(settings);
            return knownFollowers;
    public static final String NODE_LEFT_REASON_DISCONNECTED = "disconnected";
     * Clear the set of known nodes, stopping all checks.
                + FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey()
 * this file be licensed under the Apache-2.0 license or a
    // For assertions
    }
                            logger.trace("{} no longer running", FollowerChecker.this);
        this.transportService = transportService;
            term = in.readLong();
import org.opensearch.core.common.io.stream.StreamInput;
        private final DiscoveryNode discoveryNode;
            + followerCheckers
                if (discoveryNode.equals(discoveryNodes.getLocalNode()) == false
        }
    static class FastResponseState {
                        failureCountSinceLastSuccess = 0;
/**
                    && followerCheckers.containsKey(discoveryNode) == false
    // For assertions
            logger.debug(message);
            followerChecker.failNode("disconnected");
import org.opensearch.common.settings.Setting;
}
            + fastResponseState
            return Objects.hash(term, sender);
                public void run() {
        @Override
                        if (running() == false) {
                return;
import org.opensearch.transport.TransportRequest;
                public void run() {
        public void writeTo(final StreamOutput out) throws IOException {
    private final Map<DiscoveryNode, FollowerChecker> followerCheckers = newConcurrentMap();
                + discoveryNode
                + statusInfo.getInfo()
            return sender;
    public FollowersChecker(
                        final String reason;
                } catch (Exception e) {
        }
        Setting.Property.Dynamic
                            reason = NODE_LEFT_REASON_FOLLOWER_CHECK_RETRY_FAIL;
/*
    /**
import java.util.Map;
                    synchronized (mutex) {
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
            logger.trace("responding to {} on fast path", request);
        this.clusterManagerMetrics = clusterManagerMetrics;
            this.sender = sender;
                            return;
        Setting.Property.NodeScope
                logger.trace("responding to {} on slow path", request);
            clusterManagerMetrics.incrementCounter(clusterManagerMetrics.followerChecksFailureCounter, 1.0);
                            logger.trace("{} no longer running, not marking faulty", FollowerChecker.this);
                            scheduleNextWakeUp();
 */
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
import org.opensearch.monitor.StatusInfo;
                TransportRequestOptions.builder().withTimeout(followerCheckTimeout).withType(Type.PING).build(),
    }
    private final BiConsumer<DiscoveryNode, String> onNodeFailure;
    private TimeValue followerCheckTimeout;
        Setting.Property.NodeScope,
                + "], rejecting "
                            reason = NODE_LEFT_REASON_HEALTHCHECK_FAIL;
        "cluster.fault_detection.follower_check.timeout",
                }
                    }
        }
            }
            this.mode = mode;
import org.opensearch.transport.TransportException;
                request,
 * software distributed under the License is distributed on an
        TimeValue.timeValueMillis(1000),
        public boolean equals(Object o) {
     * @return nodes in the current cluster state which have failed their follower checks.
            return;
        synchronized (mutex) {
            return this == followerCheckers.get(discoveryNode);
            + followerCheckInterval
    }
    private void setFollowerCheckInterval(TimeValue followerCheckInterval) {
import org.opensearch.transport.TransportChannel;
import java.util.Set;
     * @opensearch.internal
            protected void doRun() throws IOException {
    }
    }
                + ", ["
            @Override
import org.opensearch.core.transport.TransportResponse.Empty;
                    public void handleResponse(Empty response) {
        final StatusInfo statusInfo = nodeHealthService.getHealth();
            + ", faultyNodes="
    private final int followerCheckRetryCount;
                        failureCountSinceLastSuccess++;
 * a node and the consequent shard reallocation.
        }
    public static final Setting<TimeValue> FOLLOWER_CHECK_TIMEOUT_SETTING = Setting.timeSetting(
        }
        this.handleRequestAndUpdateState = handleRequestAndUpdateState;
        private void handleWakeUp() {
            @Override
/*
                + ", failureCountSinceLastSuccess="
        transportService.addConnectionListener(new TransportConnectionListener() {
import java.util.function.Predicate;
            );
                        faultyNodes.add(discoveryNode);
            knownFollowers.addAll(followerCheckers.keySet());
    Set<DiscoveryNode> getKnownFollowers() {
                            return;
    /**
            super.writeTo(out);
        setCurrentNodes(DiscoveryNodes.EMPTY_NODES);
                public String toString() {
        public FollowerCheckRequest(final StreamInput in) throws IOException {
 */
                    transportChannel.sendResponse(e);
            Names.SAME,
     *
        public String toString() {
 */
    public String toString() {
        Setting.Property.Dynamic
 * this work for additional information regarding copyright
import java.util.function.BiConsumer;
            FollowerCheckRequest that = (FollowerCheckRequest) o;
                @Override
    private final Consumer<FollowerCheckRequest> handleRequestAndUpdateState;
                    public Empty read(StreamInput in) {
        @Override
    public static final String NODE_LEFT_REASON_HEALTHCHECK_FAIL = "health check failed";
import org.opensearch.common.settings.Settings;
        this.followerCheckTimeout = followerCheckTimeout;
            + faultyNodes
            });
    public Set<DiscoveryNode> getFaultyNodes() {
                            logger.info(() -> new ParameterizedMessage("{} failed, retrying", FollowerChecker.this), exp);
 * considering a follower to be faulty, to allow for a brief network partition or a long GC cycle to occur without triggering the removal of
            this.term = term;
        this.followerCheckInterval = followerCheckInterval;
            followerCheckers.keySet().removeIf(isUnknownNode);
            + followerCheckTimeout
    }
 * The OpenSearch Contributors require contributions made to
 *
                    return FollowerChecker.this + "::handleWakeUp";
                    @Override
        Setting.Property.NodeScope,
            public void onFailure(Exception e) {
    private final Settings settings;
        }
 * @opensearch.internal
        }
    public static final String FOLLOWER_CHECK_ACTION_NAME = "internal:coordination/fault_detection/follower_check";
            }
                    onNodeFailure.accept(discoveryNode, reason);
            transportService.getThreadPool().generic().execute(new Runnable() {
            return term;
    public static final Setting<Integer> FOLLOWER_CHECK_RETRY_COUNT_SETTING = Setting.intSetting(
        }
                FOLLOWER_CHECK_ACTION_NAME,
                handleDisconnectedNode(node);
                            logger.debug(new ParameterizedMessage("{} no longer running", FollowerChecker.this), exp);
    private final NodeHealthService nodeHealthService;
            if (o == null || getClass() != o.getClass()) return false;
     */
        }
                @Override
    private final Set<DiscoveryNode> faultyNodes = new HashSet<>();
 * compatible open source license.
    public void setCurrentNodes(DiscoveryNodes discoveryNodes) {
    /**
        }
            if (running() == false) {
        NodeHealthService nodeHealthService,
                        failNode(reason);
                    }
        public int hashCode() {
        3,
        }
                        }
                + statusInfo.getInfo();
 *
    public void clearCurrentNodes() {
            if (this == o) return true;
            + "followerCheckInterval="
        transportService.getThreadPool().generic().execute(new AbstractRunnable() {
            final FollowerCheckRequest request = new FollowerCheckRequest(fastResponseState.term, transportService.getLocalNode());
        1,
    // the timeout for each check sent to each node
                    handleRequestAndUpdateState.accept(request);
                + '}';
                    public void handleException(TransportException exp) {
                        }
                            return;
 * follower has failed the leader will remove it from the cluster. We are fairly lenient, possibly allowing multiple checks to fail before
        clusterSettings.addSettingsUpdateConsumer(FOLLOWER_CHECK_TIMEOUT_SETTING, this::setFollowerCheckTimeout);
