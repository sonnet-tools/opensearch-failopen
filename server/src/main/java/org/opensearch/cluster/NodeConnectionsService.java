                onCompletion(ActivityType.DISCONNECTING, e, connectActivity);
    }
            }
            synchronized (mutex) {
                ConnectionTarget connectionTarget = targetsByNode.get(discoveryNode);
        @Override
    private final ThreadPool threadPool;
        final List<Runnable> runnables = new ArrayList<>();
                        @Override
            final Collection<ConnectionTarget> connectionTargets = targetsByNode.values();
            future = PlainListenableActionFuture.newListenableFuture();
                assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";
                return "connect to " + discoveryNode;
import org.opensearch.cluster.service.ClusterApplier;
        nodes.forEach(transportService::setPendingDisconnection);
            }
                addListener(listener);
import org.apache.logging.log4j.Logger;
    public void disconnectFromNodesExcept(DiscoveryNodes discoveryNodes) {
import org.opensearch.common.unit.TimeValue;
                    ActionListener.wrap(onCompletion),
            return "periodic reconnection checker";
     * <p>
            } else {
                    connectionTarget = new ConnectionTarget(discoveryNode);
            }
            final Runnable cleanup;
        };
 * NodeConnectionsService#disconnectFromNodesExcept(DiscoveryNodes)} methods are called on the {@link ClusterApplier} thread. This component
 * license agreements. See the NOTICE file distributed with
            }
            return addListenerAndStartActivity(
     * nodes which are in the process of disconnecting. The onCompletion handler is called after all ongoing connection/disconnection
                    cleanup = e == null ? () -> oldFuture.onResponse(null) : () -> oldFuture.onFailure(e);
 * this file be licensed under the Apache-2.0 license or a
        private final Runnable connectActivity = new AbstractRunnable() {
     * - awaiting connection        ({@link ConnectionTarget#future} may contain listeners awaiting a connection)
    @Override
                    return () -> listener.onResponse(null);
                assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";
                return () -> {};
        Runnable disconnect() {
            logger.warn("unexpected error while checking for node reconnects", e);
import org.apache.logging.log4j.Level;
import java.util.Map;
                            logger.debug("connected to {}", discoveryNode);
                } else {
                    level,
 */
                null,
 * not use this file except in compliance with the License.
                threadPool.scheduleUnlessShuttingDown(reconnectInterval, ThreadPool.Names.GENERIC, this);
    }
        private ActivityType activityType = ActivityType.IDLE; // indicates what any listeners are awaiting
                // we may not have disconnected, but will not retry, so this connection might have leaked
            @Nullable ActionListener<Void> listener,
 * need not block on re-establishing existing connections because if a connection is down then we are already in an exceptional situation
    @Override
/*
        TimeValue.timeValueSeconds(10),
        }
    public void setPendingDisconnections(Set<DiscoveryNode> nodes) {
     * Makes a single attempt to reconnect to any nodes which are disconnected but should be connected. Does not attempt to reconnect any
        private final Runnable disconnectActivity = new AbstractRunnable() {
 * the Apache License, Version 2.0 (the "License"); you may
/*
    private static final Logger logger = LogManager.getLogger(NodeConnectionsService.class);
                        }
                runnables.add(targetsByNode.get(discoveryNode).disconnect());
            if (listener != null) {
     * removed from the list so they can be notified of failure; once the connecting process has finished a disconnection will be started.
     *
 * GitHub history for details.
                    }
        public void onFailure(Exception e) {
 * under the License.
import java.util.Collection;
        }
import org.opensearch.common.settings.Setting;
                    // new node, set up target and listener
                    // known node, try and ensure it's connected but do not wait
                for (final ConnectionTarget connectionTarget : connectionTargets) {
     * connection attempts to _new_ nodes, but not on attempts to re-establish connections to nodes that are already known.
import org.opensearch.cluster.node.DiscoveryNode;
     * A connection checker.
                return () -> {};
            return drainedFuture;
            }
            scheduleNextCheck();
        boolean isPendingDisconnection() {
 * The {@link NodeConnectionsService#connectToNodes(DiscoveryNodes, Runnable)} and {@link
     * we are currently connecting and then {@link ConnectionTarget#disconnect()} is called then all connection listeners are
            final Collection<ConnectionTarget> connectionTargets = targetsByNode.values();
 * attempt to complete first.
        runnables.forEach(Runnable::run);
    public NodeConnectionsService(Settings settings, ThreadPool threadPool, TransportService transportService) {
     * These methods return a {@link Runnable} which starts the connection/disconnection process iff it was idle before the method was
                    // target is disconnected, and we are currently idle, so start a connection process.
        runnables.forEach(Runnable::run);
                    onConnected();
                    targetsByNode.put(discoveryNode, connectionTarget);
            for (final DiscoveryNode discoveryNode : discoveryNodes) {
                assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";
import org.opensearch.action.support.PlainListenableActionFuture;
    class ConnectionChecker extends AbstractRunnable {
                for (final ConnectionTarget connectionTarget : connectionTargets) {
 * disconnecting from nodes once they are removed from the cluster state. It periodically checks that all connections are still open and
                }
                activityType = newActivityType;
import org.apache.logging.log4j.LogManager;
                if (transportService.nodeConnected(discoveryNode)) {
            }
        synchronized (mutex) {
        this.connectionChecker = connectionChecker;
                onCompletion(ActivityType.CONNECTING, e, disconnectActivity);
        }
        this.transportService = transportService;
            if (activityType == ActivityType.IDLE) {
    }
        private void onCompletion(ActivityType completedActivityType, @Nullable Exception e, Runnable oppositeActivity) {
 * this work for additional information regarding copyright
                    isNewNode = true;
 */
            public void onFailure(Exception e) {
                } else {
                    logger.trace("still connected to {}", discoveryNode);
                        @Override
                    transportService.connectToNode(discoveryNode, new ActionListener<Void>() {
            if (activityType == ActivityType.IDLE) {
import org.opensearch.core.action.ActionListener;
     */
    private final TransportService transportService;
            assert activityType != ActivityType.IDLE;
    protected void doClose() {}
     */
        // Called by tests after some disruption has concluded. It is possible that one or more targets are currently CONNECTING and have
    private final Object mutex = new Object();
            );
            final Set<DiscoveryNode> nodesToDisconnect = new HashSet<>(targetsByNode.keySet());
 * specific language governing permissions and limitations
                } else {
                final boolean isNewNode;
                    logger.debug("connecting to {}", discoveryNode);
                }
            Runnable activity,
            final PlainListenableActionFuture<Void> drainedFuture = future;
 *
        CONNECTING,
                addListener(listener);
            ActionListener.wrap(onCompletion),
    protected final Map<DiscoveryNode, ConnectionTarget> targetsByNode = new HashMap<>();
                final GroupedActionListener<Void> listener = new GroupedActionListener<>(
            public String toString() {
     * @opensearch.internal
@PublicApi(since = "1.0.0")
/*
            }
            }
            assert Thread.holdsLock(mutex) : "mutex not held";
                if (connectionTarget == null) {
        private void addListener(@Nullable ActionListener<Void> listener) {
                } else {
                    runnables.add(() -> listener.onResponse(null));
            protected void doRun() {
        public String toString() {
import org.opensearch.OpenSearchException;
        "cluster.nodes.reconnect_interval",
        });
                "connection cancelled by disconnection"
                logger.debug("disconnected from {}", discoveryNode);
                assert activityType != ActivityType.IDLE;
        final GroupedActionListener<Void> listener = new GroupedActionListener<>(
        }
    private final TimeValue reconnectInterval;
     * @opensearch.internal
        private PlainListenableActionFuture<Void> future = PlainListenableActionFuture.newListenableFuture();
     */
                final int currentFailureCount = consecutiveFailureCount.incrementAndGet();
            }
        // If so, we cannot simply add our listener to the queue because it will be notified when this CONNECTING activity completes even
 * compatible open source license.
            } else {
            }
        Runnable awaitCurrentActivity(ActionListener<Void> listener) {
                    // existing node, but maybe we're disconnecting from it, in which case it was recently removed from the cluster
        synchronized (mutex) {
    }
        }
                    connectionTargets.size()
        final ConnectionChecker connectionChecker = new ConnectionChecker();
import static org.opensearch.common.settings.Setting.Property;
            }
                "disconnection cancelled by reconnection"
            if (activityType == ActivityType.IDLE) {
    /**
                final GroupedActionListener<Void> listener = new GroupedActionListener<>(
 * You may obtain a copy of the License at
 * and it doesn't matter much if we stay in this situation a little longer.
    // Protects changes to targetsByNode and its values (i.e. ConnectionTarget#activityType and ConnectionTarget#listener).
            return activityType == ActivityType.DISCONNECTING;
            if (connectionTargets.isEmpty()) {
            this.discoveryNode = discoveryNode;
        }
                consecutiveFailureCount.incrementAndGet();
import org.opensearch.threadpool.ThreadPool;
                connectDisconnectedTargets(this::scheduleNextCheck);
                if (transportService.nodeConnected(discoveryNode)) {
 * KIND, either express or implied.  See the License for the
 * are unresponsive: this is the job of the cluster-manager's fault detection components, particularly {@link FollowersChecker}.
    // Crucially there are no blocking calls under this mutex: it is not held while connecting or disconnecting.
        final List<Runnable> runnables = new ArrayList<>();
        // any missing nodes.
                    // since we run this for every node on every cluster state update.
    private void awaitPendingActivity(Runnable onCompletion) {
                            assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";
            final AbstractRunnable abstractRunnable = this;
            private void onConnected() {
            assert newActivityType.equals(ActivityType.IDLE) == false;
 *
     * <p>
            } else {
            assert Thread.holdsLock(mutex) : "mutex not held";
     * It will be awaiting connection (respectively disconnection) after calling {@code connect()} (respectively {@code disconnect()}). It
                            abstractRunnable.onFailure(e);
    protected void doStart() {
    }
        );
                logger.trace("connectDisconnectedTargets: {}", targetsByNode);
            discoveryNodes.getSize()
                    if (completedActivityType.equals(ActivityType.DISCONNECTING)) {
                ActivityType.DISCONNECTING,
                transportService.disconnectFromNode(discoveryNode);
        private final AtomicInteger consecutiveFailureCount = new AtomicInteger();
                        }
        @Override
                assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";
                // only warn every 6th failure
            public void onFailure(Exception e) {
    protected void doStop() {
     * complete.
 * This component does not block on disconnections at all, because a disconnection might need to wait for an ongoing (background) connection
        }
            }
            }
            assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";
     * <p>
        // been since the disruption was active, and that the connection attempt was thwarted by a concurrent disruption to the connection.
import java.util.Set;
                );
     * Disconnect from any nodes to which we are currently connected which do not appear in the given nodes. Does not wait for the
                    final PlainListenableActionFuture<Void> oldFuture = getAndClearFuture();
 * allows the {@code ClusterApplier} to block on forming connections to _new_ nodes, because the rest of the system treats a missing
     * <p>
                    runnables.add(connectionTarget.connect(null));
        synchronized (mutex) {
        DISCONNECTING
                        final ConnectionTarget removedTarget = targetsByNode.remove(discoveryNode);
    @Inject
    }
            }
        }
                ActivityType.CONNECTING,
     * will eventually become idle if these methods are not called infinitely often.
    /**
    }
        }
     * {@link ConnectionTarget#disconnect()} was called last.
                nodesToDisconnect.remove(discoveryNode);
            final PlainListenableActionFuture<Void> oldFuture = getAndClearFuture();
                onCompletion(ActivityType.DISCONNECTING, null, connectActivity);
package org.opensearch.cluster;
    @Override
        @Override
        Runnable connect(@Nullable ActionListener<Void> listener) {
                onCompletion(ActivityType.CONNECTING, null, disconnectActivity);
        IDLE,
    }
        final List<Runnable> runnables = new ArrayList<>();
    }
            }
            }
 * This component is responsible for maintaining connections from this node to all the nodes listed in the cluster state, and for
 * @opensearch.api
        }
            cleanup.run();
     * Each {@link ConnectionTarget} is in one of these states:
            String cancellationMessage
 *
        return new ConnectionTarget(discoveryNode);
    private enum ActivityType {
        runnables.forEach(Runnable::run);
        }
            @Override
    }
     * attempts have completed.
                    cleanup = oppositeActivity;
    public static final Setting<TimeValue> CLUSTER_NODE_RECONNECT_INTERVAL_SETTING = positiveTimeSetting(
        Runnable ensureConnected(@Nullable ActionListener<Void> listener) {
        this.reconnectInterval = NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.get(settings);
        };
     * Connect to all the given nodes, but do not disconnect from any extra nodes. Calls the completion handler on completion of all
            assert Thread.holdsLock(mutex) : "mutex not held";
     * disconnection listeners are immediately removed for failure notification and a connection is started once the disconnection is
            return;
                    connectionTargets.size()
            onCompletion.run();
                logger.warn(new ParameterizedMessage("failed to disconnect from {}, possible connection leak", discoveryNode), e);
        protected void doRun() {
        final List<Runnable> runnables = new ArrayList<>(discoveryNodes.getSize());
        private final DiscoveryNode discoveryNode;
        }
    );
import org.opensearch.common.annotation.PublicApi;
            activityType = newActivityType;
                return activity;
                            onConnected();
                return "ConnectionTarget{" + "discoveryNode=" + discoveryNode + ", activityType=" + activityType + '}';
        connectionChecker = null;
        }
                    activityType = ActivityType.IDLE;
            addListener(listener);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Modifications Copyright OpenSearch Contributors. See
     * Additionally if the last step of the process was a disconnection then this target is removed from the current set of targets. Thus
    protected void connectDisconnectedTargets(Runnable onCompletion) {
     * if this {@link ConnectionTarget} is idle and in the current set of targets then it should be connected.
     *
                listener,
        }
    }
            disconnectFromNodesExcept(discoveryNodes);
                        public void onFailure(Exception e) {
        runnables.forEach(Runnable::run);
            return () -> oldFuture.onFailure(new OpenSearchException(cancellationMessage));
        }
            }
        awaitPendingActivity(() -> connectDisconnectedTargets(onCompletion));
 * Licensed to Elasticsearch under one or more contributor
        this.threadPool = threadPool;
                final Level level = currentFailureCount % 6 == 1 ? Level.WARN : Level.DEBUG;
 * restores them if needed. Note that this component is *not* responsible for removing nodes from the cluster state if they disconnect or
/**
                runnables.add(onCompletion);
     * - idle                       ({@link ConnectionTarget#future} has no listeners)
                    runnables.add(connectionTarget.awaitCurrentActivity(listener));
    protected volatile ConnectionChecker connectionChecker;
     * either connect to or disconnect from it according to whether {@link ConnectionTarget#connect(ActionListener)} or
            @Override
import static org.opensearch.common.settings.Setting.positiveTimeSetting;
 * <p>
            } else {
                future.addListener(listener);
                    runnables.add(connectionTarget.connect(listener));
                assert false : "failed to disconnect from " + discoveryNode + ", possible connection leak\n" + e;
import org.apache.logging.log4j.message.ParameterizedMessage;
            }
        synchronized (mutex) {
            assert Thread.holdsLock(mutex) : "mutex not held";
                    activityType = ActivityType.CONNECTING;
            assert Thread.holdsLock(mutex) : "mutex not held";
                logger.log(
     * All of the {@code listeners} are awaiting the completion of the same activity, which is either a connection or a disconnection.  If
        connectionChecker.scheduleNextCheck();
import org.opensearch.action.support.GroupedActionListener;
                    isNewNode = connectionTarget.isPendingDisconnection();
     * - awaiting disconnection     ({@link ConnectionTarget#future} may contain listeners awaiting a disconnection)
                }
                );
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
 * The OpenSearch Contributors require contributions made to
    // contains an entry for every node in the latest cluster state, as well as for nodes from which we are in the process of
                    e
                addListener(listener);
     * <p>
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
    }
    // exposed for testing
import java.util.HashSet;
     * disconnections to complete, because they might have to wait for ongoing connection attempts first.
            if (connectionChecker == this) {
            for (final DiscoveryNode discoveryNode : discoveryNodes) {
        connectToNodes(discoveryNodes, () -> {
        }
            }
        }
        }
import org.opensearch.cluster.node.DiscoveryNodes;
            synchronized (mutex) {
        Property.NodeScope
 * <p>
            if (connectionChecker == this) {
                );
        }
            );
    /**
 */
                } else {
    }
 * software distributed under the License is distributed on an
import org.opensearch.common.util.concurrent.AbstractRunnable;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.transport.TransportService;
import java.util.ArrayList;
            for (final DiscoveryNode discoveryNode : nodesToDisconnect) {
            if (connectionTargets.isEmpty()) {
            @Override
        transportService.clearPendingDisconnections();
        }
    /**
            }
                    // transportService.connectToNode is a no-op if already connected, but we don't want any DEBUG logging in this case
                }
        private Runnable addListenerAndStartActivity(
import java.util.HashMap;
                    ActionListener.wrap(onCompletion),
                disconnectActivity,
                consecutiveFailureCount.set(0);
public class NodeConnectionsService extends AbstractLifecycleComponent {
                }
     * called, and which notifies any failed listeners if the {@code ConnectionTarget} went from {@code CONNECTING} to {@code DISCONNECTING}
            if (activityType == newActivityType) {
     */
 * connection with another node in the cluster state as an exceptional condition and we don't want this to happen to new nodes. However we
            @Override
                    // state and has now been re-added so we should wait for the re-connection
            return addListenerAndStartActivity(
                    addListener(listener);
    public void reconnectToNodes(DiscoveryNodes discoveryNodes, Runnable onCompletion) {
    }
    protected class ConnectionTarget {
        if (discoveryNodes.getSize() == 0) {
        void scheduleNextCheck() {
                        assert removedTarget == this : removedTarget + " vs " + this;
                    });
                addListener(listener);
    void ensureConnections(Runnable onCompletion) {
    /**
import org.opensearch.common.Nullable;
            @Override
            ActivityType newActivityType,
 *     http://www.apache.org/licenses/LICENSE-2.0
     * <p>
 *
                connectActivity,
                return () -> listener.onResponse(null);
        private PlainListenableActionFuture<Void> getAndClearFuture() {
 * ownership. Elasticsearch licenses this file to you under
     * or vice versa. The connection/disconnection process continues until all listeners have been removed, at which point it becomes idle
            protected void doRun() {
                consecutiveFailureCount.set(0);
     */
                runnables.add(onCompletion);
                    return connectActivity;
     * again.
import org.opensearch.cluster.coordination.FollowersChecker;
    // for disruption tests, re-establish any disrupted connections
 * SPDX-License-Identifier: Apache-2.0
                        public void onResponse(Void aVoid) {
                }
 */
                if (activityType == completedActivityType) {
        ConnectionTarget(DiscoveryNode discoveryNode) {
    }
    public void connectToNodes(DiscoveryNodes discoveryNodes, Runnable onCompletion) {
     * {@link ConnectionTarget} ensures that we are never concurrently connecting to and disconnecting from a node, and that we eventually
}
                return () -> {};
        public String toString() {
            ensureConnections(onCompletion);
                }
import org.opensearch.common.inject.Inject;
    // disconnecting
import org.opensearch.common.settings.Settings;
        ) {
                    runnables.add(connectionTarget.ensureConnected(listener));
                    new ParameterizedMessage("failed to connect to {} (tried [{}] times)", discoveryNode, currentFailureCount),
    public void clearPendingDisconnections() {
                if (isNewNode) {
     * Similarly if we are currently disconnecting and then {@link ConnectionTarget#connect(ActionListener)} is called then all
            assert Thread.holdsLock(mutex) : "mutex not held";
        // though it was disrupted. We must therefore wait for all the current activity to finish and then go through and reconnect to
    protected ConnectionTarget createConnectionTarget(DiscoveryNode discoveryNode) {
