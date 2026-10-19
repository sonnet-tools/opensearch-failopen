                        } else if (failureCountSinceLastSuccess >= followerCheckRetryCount) {  
     * Update the set of known nodes, starting to check any new ones and stopping checking any previously-known-but-now-unknown ones.
                discoveryNode,
                        failureCountSinceLastSuccess++;  
     * @opensearch.internal  
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {  
    }
                        }
    private void handleDisconnectedNode(DiscoveryNode discoveryNode) {
            return sender;
                        faultyNodes.add(discoveryNode);
            final FollowerCheckRequest request = new FollowerCheckRequest(fastResponseState.term, transportService.getLocalNode());  
                }  
 * the Apache License, Version 2.0 (the "License"); you may
                        } else {  
    private void setFollowerCheckTimeout(TimeValue followerCheckTimeout) {
    // For assertions
            }, followerCheckInterval, Names.SAME);
                            reason = NODE_LEFT_REASON_DISCONNECTED;
 * @opensearch.internal  
                        if (running() == false) {
    public static final String NODE_LEFT_REASON_FOLLOWER_CHECK_RETRY_FAIL = "followers check retry count exceeded";
        public boolean equals(Object o) {  
                    @Override
/*
                        if (exp instanceof ConnectTransportException || exp.getCause() instanceof ConnectTransportException) {  
        void start() {
        }  
                    handleRequestAndUpdateState.accept(request);  
        this.followerCheckTimeout = followerCheckTimeout;  
    private TimeValue followerCheckInterval;
        @Override  
        public String toString() {
                            return;
        1,
                    followerChecker.start();
                    followerCheckers.put(discoveryNode, followerChecker);  
 *
    public static final String NODE_LEFT_REASON_DISCONNECTED = "disconnected";
        final FastResponseState responder = this.fastResponseState;
            logger.info(() -> new ParameterizedMessage("{} disconnected", followerChecker));
 * this file be licensed under the Apache-2.0 license or a
     */
                        }
import org.opensearch.transport.TransportRequest;  
import org.opensearch.transport.TransportRequestOptions;
            false,
            FollowerCheckRequest::new,
            this.mode = mode;
                            logger.info(() -> new ParameterizedMessage("{} failed, retrying", FollowerChecker.this), exp);
            sender = new DiscoveryNode(in);
        Setting.Property.NodeScope,  
            });
        public DiscoveryNode getSender() {
    );
        return fastResponseState;
        private int failureCountSinceLastSuccess;  
 * You may obtain a copy of the License at  
     *
    public void clearCurrentNodes() {
        this.clusterManagerMetrics = clusterManagerMetrics;
    }
                logger.trace("responding to {} on slow path", request);
        TimeValue.timeValueMillis(1),
            public void onFailure(Exception e) {  
 */  
                @Override
                }
    public static final String NODE_LEFT_REASON_HEALTHCHECK_FAIL = "health check failed";  
                        } else if (exp.getCause() instanceof NodeHealthCheckFailureException) {  
                logger.trace("handleWakeUp: not running");
            final String message = "handleFollowerCheck: node is unhealthy ["  
import org.opensearch.transport.TransportException;
                    && faultyNodes.contains(discoveryNode) == false) {  
import java.util.Set;
     * Clear the set of known nodes, stopping all checks.
    }
        }  
        );  
            return knownFollowers;  
     * @opensearch.internal
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
                    @Override  
                TransportRequestOptions.builder().withTimeout(followerCheckTimeout).withType(Type.PING).build(),
                @Override
        BiConsumer<DiscoveryNode, String> onNodeFailure,
            super(in);
        Settings settings,  
            }
            throw new NodeHealthCheckFailureException(message);
        ClusterManagerMetrics clusterManagerMetrics  
                    }  
                        return Names.SAME;
     */
     * FollowersChecker whenever our term or mode changes here.  
            if (this == o) return true;
                + "], rejecting "
        });
                            logger.info(() -> new ParameterizedMessage("{} failed too many times", FollowerChecker.this), exp);
                + discoveryNode
            @Override
import org.opensearch.core.common.io.stream.StreamOutput;
                        followerCheckers.remove(discoveryNode);
 * this work for additional information regarding copyright
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;  
        if (statusInfo.getStatus() == UNHEALTHY) {
                        }
    }
        @Override
        TransportService transportService,
    }
    private final Settings settings;  
    }  
            return Objects.hash(term, sender);
        }
 */  
        Consumer<FollowerCheckRequest> handleRequestAndUpdateState,  
                    handleWakeUp();  
                            reason = NODE_LEFT_REASON_FOLLOWER_CHECK_RETRY_FAIL;
        public int hashCode() {
        }  
            handleWakeUp();  
    public static final Setting<TimeValue> FOLLOWER_CHECK_INTERVAL_SETTING = Setting.timeSetting(
            + ", followerCheckTimeout="
        @Override
        followerCheckRetryCount = FOLLOWER_CHECK_RETRY_COUNT_SETTING.get(settings);
                    public Empty read(StreamInput in) {
                + followerCheckRetryCount
                + "discoveryNode="
        if (followerChecker != null) {  
        }  
 */
        }
        private void handleWakeUp() {  
            + faultyNodes
 * Licensed to Elasticsearch under one or more contributor  
    private class FollowerChecker {
            + followerCheckTimeout
     *
            this.term = term;
        }
    private TimeValue followerCheckTimeout;  
    // the time between checks sent to each node  
    /**  
        TimeValue.timeValueMillis(1000),  
            @Override
                        }
import java.util.function.Predicate;
                new TransportResponseHandler<Empty>() {
        @Override
        private void scheduleNextWakeUp() {
     */  
    private final int followerCheckRetryCount;
        final long term;  
    }
        this.settings = settings;
            return term;
        public String toString() {
            + '}';
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                handleDisconnectedNode(node);
    static class FastResponseState {
            @Override
                            logger.info(() -> new ParameterizedMessage("{} disconnected", FollowerChecker.this), exp);
import org.opensearch.common.settings.Setting;  
 * considering a follower to be faulty, to allow for a brief network partition or a long GC cycle to occur without triggering the removal of  
            transportService.sendRequest(  
import java.util.function.Consumer;  
import org.opensearch.transport.TransportRequestOptions.Type;
                    return FollowerChecker.this + "::handleWakeUp";
                    public void handleException(TransportException exp) {  
 * follower has failed the leader will remove it from the cluster. We are fairly lenient, possibly allowing multiple checks to fail before
    }
        Setting.Property.Dynamic  
        void failNode(String reason) {
                }
     */  
        this.transportService = transportService;  
        FollowerChecker(DiscoveryNode discoveryNode) {
     */
            @Override
        public void writeTo(final StreamOutput out) throws IOException {
    );
        synchronized (mutex) {
                    final FollowerChecker followerChecker = new FollowerChecker(discoveryNode);
                    synchronized (mutex) {
                        return Empty.INSTANCE;
    private final TransportService transportService;  
            out.writeLong(term);
        TimeValue.timeValueMillis(150000),
import java.util.function.BiConsumer;
        }  
        public String toString() {  
import org.opensearch.transport.TransportConnectionListener;
    private volatile FastResponseState fastResponseState;
/**  
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
    private final Consumer<FollowerCheckRequest> handleRequestAndUpdateState;  
        NodeHealthService nodeHealthService,
            throw new CoordinationStateRejectedException("rejecting " + request + " since local state is " + this);
        private final DiscoveryNode discoveryNode;
            final Set<DiscoveryNode> knownFollowers = new HashSet<>(faultyNodes);
        transportService.addConnectionListener(new TransportConnectionListener() {
    }
import org.opensearch.common.settings.ClusterSettings;
        }
            if (o == null || getClass() != o.getClass()) return false;
     * A fast response state.
/*  
        private boolean running() {  
    public String toString() {  
        @Override
import org.apache.logging.log4j.message.ParameterizedMessage;  
    // the timeout for each check sent to each node  
        if (responder.mode == Mode.FOLLOWER && responder.term == request.term) {  
        }
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
                transportChannel.sendResponse(Empty.INSTANCE);
        }
            followerCheckers.keySet().removeIf(isUnknownNode);  
            + followerCheckers  
import org.opensearch.transport.TransportResponseHandler;  
        Setting.Property.Dynamic
        Setting.Property.NodeScope,
                        if (running() == false) {
    public void setCurrentNodes(DiscoveryNodes discoveryNodes) {  
        @Override
                public String toString() {
import org.opensearch.common.unit.TimeValue;
                + "]="
import java.util.HashSet;
                        logger.trace("{} check successful", FollowerChecker.this);
 */
        }
import org.opensearch.cluster.node.DiscoveryNodes;
    }  
import org.opensearch.core.common.io.stream.StreamInput;
                @Override  
            + ", fastResponseState="  
                }
    // the number of failed checks that must happen before the follower is considered to have failed.
        this.followerCheckInterval = followerCheckInterval;
package org.opensearch.cluster.coordination;
            }
            this.sender = sender;
                + statusInfo.getInfo();  
                        scheduleNextWakeUp();
                + FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey()  
                + failureCountSinceLastSuccess
        setCurrentNodes(DiscoveryNodes.EMPTY_NODES);
     *  
 * software distributed under the License is distributed on an
        synchronized (mutex) {  
            this.discoveryNode = discoveryNode;  
            }
     * The system is normally in a state in which every follower remains a follower of a stable leader in a single term for an extended  
                    }  
        FollowerChecker followerChecker = followerCheckers.get(discoveryNode);
        ClusterSettings clusterSettings,
            + followerCheckRetryCount
     */
    public static final String NODE_LEFT_REASON_LAGGING = "lagging";
 * SPDX-License-Identifier: Apache-2.0
                    && followerCheckers.containsKey(discoveryNode) == false
        FastResponseState(final long term, final Mode mode) {  
            FollowerCheckRequest that = (FollowerCheckRequest) o;  
 * Unless required by applicable law or agreed to in writing,
        }
        this.nodeHealthService = nodeHealthService;  
 * The FollowersChecker is responsible for allowing a leader to check that its followers are still connected and healthy. On deciding that a
        }
                public String toString() {
    }  
        public FollowerCheckRequest(final long term, final DiscoveryNode sender) {
        }
    public Set<DiscoveryNode> getFaultyNodes() {
                    @Override  
import org.apache.logging.log4j.LogManager;
                    return "detected failure of " + discoveryNode;  
        }
import org.opensearch.cluster.ClusterManagerMetrics;
 * The OpenSearch Contributors require contributions made to  
                            logger.trace("{} no longer running", FollowerChecker.this);
        final StatusInfo statusInfo = nodeHealthService.getHealth();
            final Predicate<DiscoveryNode> isUnknownNode = n -> discoveryNodes.nodeExists(n) == false;
     * A checker for an individual follower.  
        Setting.Property.NodeScope  
                    @Override
     * entirely on the network thread, and only if the fast path fails do we perform some work in the background, by notifying the
     * @opensearch.internal
    private void setFollowerCheckInterval(TimeValue followerCheckInterval) {
                    onNodeFailure.accept(discoveryNode, reason);
    public void updateFastResponseState(final long term, final Mode mode) {
                public void run() {  
        }
                }
                    }
            return "FollowerChecker{"  
        updateFastResponseState(0, Mode.CANDIDATE);
            return new HashSet<>(this.faultyNodes);
import org.opensearch.core.transport.TransportResponse.Empty;  
                public void run() {
    /**  
    FastResponseState getFastResponseState() {  
import org.opensearch.monitor.StatusInfo;
    Set<DiscoveryNode> getKnownFollowers() {
            return "FastResponseState{" + "term=" + term + ", mode=" + mode + '}';
        public FollowerCheckRequest(final StreamInput in) throws IOException {
                + '}';  
    );
    @Override
import org.opensearch.monitor.NodeHealthService;
            if (running() == false) {
                    public void handleResponse(Empty response) {  
            logger.debug(message);
    }  
 *  
    }
     */
            super.writeTo(out);  
                            return;  
        "cluster.fault_detection.follower_check.interval",
                } catch (Exception e) {
                }
                request,  
import java.util.Map;
            return "FollowerCheckRequest{" + "term=" + term + ", sender=" + sender + '}';  
        private final long term;
import org.apache.logging.log4j.Logger;
import java.io.IOException;  
            public String toString() {
            Names.SAME,
        clusterSettings.addSettingsUpdateConsumer(FOLLOWER_CHECK_TIMEOUT_SETTING, this::setFollowerCheckTimeout);  
                            scheduleNextWakeUp();
        followerCheckTimeout = FOLLOWER_CHECK_TIMEOUT_SETTING.get(settings);  
                @Override
        }
 * a node and the consequent shard reallocation.
            transportService.getThreadPool().generic().execute(new Runnable() {
        });  
            knownFollowers.addAll(followerCheckers.keySet());
            + ", followerCheckers="
        3,
            transportChannel.sendResponse(Empty.INSTANCE);
    private final Object mutex = new Object(); // protects writes to this state; read access does not need sync
            });  
                    }  
                        failureCountSinceLastSuccess = 0;  
            + ", faultyNodes="
                + statusInfo.getInfo()
            protected void doRun() throws IOException {  
    private final BiConsumer<DiscoveryNode, String> onNodeFailure;
import org.opensearch.common.util.concurrent.AbstractRunnable;  
        final Mode mode;
            term = in.readLong();  
    /**
            );
                FOLLOWER_CHECK_ACTION_NAME,
        "cluster.fault_detection.follower_check.timeout",
        TimeValue.timeValueMillis(100),
import org.opensearch.cluster.coordination.Coordinator.Mode;
                + ", failureCountSinceLastSuccess="  
    private static final Logger logger = LogManager.getLogger(FollowersChecker.class);
                        if (running() == false) {
            + "followerCheckInterval="
            }
    public FollowersChecker(
    public static final String FOLLOWER_CHECK_ACTION_NAME = "internal:coordination/fault_detection/follower_check";  
                if (discoveryNode.equals(discoveryNodes.getLocalNode()) == false
                    transportChannel.sendResponse(e);
                    }  
            clusterManagerMetrics.incrementCounter(clusterManagerMetrics.followerChecksFailureCounter, 1.0);  
    public static final Setting<Integer> FOLLOWER_CHECK_RETRY_COUNT_SETTING = Setting.intSetting(
    public static final Setting<TimeValue> FOLLOWER_CHECK_TIMEOUT_SETTING = Setting.timeSetting(
    }  
            assert running();
        public long getTerm() {  
import org.opensearch.cluster.node.DiscoveryNode;  
    /**
 * KIND, either express or implied.  See the License for the
                logger.debug(new ParameterizedMessage("exception while responding to {}", request), e);
            }  
            false,  
        TimeValue.timeValueMillis(10000),  
        }  
        }
        transportService.registerRequestHandler(
     * Request to check follower.
import org.opensearch.transport.Transport;
                            logger.info(() -> new ParameterizedMessage("{} health check failed", FollowerChecker.this), exp);
                try {
        clusterSettings.addSettingsUpdateConsumer(FOLLOWER_CHECK_INTERVAL_SETTING, this::setFollowerCheckInterval);
                            reason = NODE_LEFT_REASON_HEALTHCHECK_FAIL;
            return;  
                }
    private final NodeHealthService nodeHealthService;
                        logger.info("{} marking node as faulty", FollowerChecker.this);  
        private final DiscoveryNode sender;
            return term == that.term && Objects.equals(sender, that.sender);
     * @return nodes in the current cluster state which have failed their follower checks.  
            followerChecker.failNode("disconnected");
import java.util.Objects;  
                        failNode(reason);  
    // For assertions
    private ClusterManagerMetrics clusterManagerMetrics;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final Map<DiscoveryNode, FollowerChecker> followerCheckers = newConcurrentMap();  
                    public String executor() {
        this.handleRequestAndUpdateState = handleRequestAndUpdateState;
 *
            + fastResponseState
 * under the License.  
}
    /**
        if (request.term < responder.term) {  
        return "FollowersChecker{"
            faultyNodes.removeIf(isUnknownNode);
        followerCheckInterval = FOLLOWER_CHECK_INTERVAL_SETTING.get(settings);
            transportService.getThreadPool().schedule(new Runnable() {  
import org.opensearch.transport.ConnectTransportException;
            return this == followerCheckers.get(discoveryNode);
                            return;  
            FOLLOWER_CHECK_ACTION_NAME,  
        }  
            (request, transportChannel, task) -> handleFollowerCheck(request, transportChannel)
        fastResponseState = new FastResponseState(term, mode);  
 * Modifications Copyright OpenSearch Contributors. See
/*  
    /**
        "cluster.fault_detection.follower_check.retry_count",  
 *
                        final String reason;
        this.onNodeFailure = onNodeFailure;
    /**
        }
                + ", ["
        }  
                    return;  
        }
                            return;  
    ) {
                            logger.debug(new ParameterizedMessage("{} no longer running", FollowerChecker.this), exp);
            logger.trace("responding to {} on fast path", request);
            sender.writeTo(out);
    public static class FollowerCheckRequest extends TransportRequest {  
                return "slow path response to " + request;  
 * license agreements. See the NOTICE file distributed with
            logger.trace("handleWakeUp: checking {} with {}", discoveryNode, request);
            + ", followerCheckRetryCount="  
import org.opensearch.transport.TransportChannel;  
        synchronized (mutex) {  
import org.opensearch.threadpool.ThreadPool.Names;  
            + followerCheckInterval  
public class FollowersChecker {
    private final Set<DiscoveryNode> faultyNodes = new HashSet<>();
                            logger.trace("{} no longer running, not marking faulty", FollowerChecker.this);  
            discoveryNodes.clusterManagersFirstStream().forEach(discoveryNode -> {  
    }  
                return;  
    private void handleFollowerCheck(FollowerCheckRequest request, TransportChannel transportChannel) throws IOException {  
import org.opensearch.common.settings.Settings;
 * GitHub history for details.
import org.opensearch.transport.TransportService;
            this.term = term;  
        transportService.getThreadPool().generic().execute(new AbstractRunnable() {
     * period of time, and therefore our response to every follower check is the same. We handle this case with a single volatile read
