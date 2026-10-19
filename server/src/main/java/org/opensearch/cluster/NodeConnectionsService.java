     */  
                        @Override
        );
        CONNECTING,
            if (activityType == newActivityType) {  
    public void connectToNodes(DiscoveryNodes discoveryNodes, Runnable onCompletion) {  
            }  
 * ownership. Elasticsearch licenses this file to you under  
@PublicApi(since = "1.0.0")
     * <p>
                    activityType = ActivityType.IDLE;
     * complete.
                connectActivity,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.PlainListenableActionFuture;  
                    runnables.add(connectionTarget.awaitCurrentActivity(listener));
    public void disconnectFromNodesExcept(DiscoveryNodes discoveryNodes) {
/*  
                }
            protected void doRun() {
                nodesToDisconnect.remove(discoveryNode);  
        IDLE,  
import org.apache.logging.log4j.LogManager;
                onCompletion(ActivityType.DISCONNECTING, e, connectActivity);
    protected void doStop() {
/*
                ConnectionTarget connectionTarget = targetsByNode.get(discoveryNode);  
                );
        "cluster.nodes.reconnect_interval",
                // only warn every 6th failure
            String cancellationMessage
                onCompletion(ActivityType.DISCONNECTING, null, connectActivity);
        private PlainListenableActionFuture<Void> future = PlainListenableActionFuture.newListenableFuture();  
                consecutiveFailureCount.incrementAndGet();
/**
            onCompletion.run();  
                return () -> {};  
    }
        private final DiscoveryNode discoveryNode;
                onCompletion(ActivityType.CONNECTING, e, disconnectActivity);  
                    e
                    cleanup = oppositeActivity;
     * disconnection listeners are immediately removed for failure notification and a connection is started once the disconnection is
            } else {
        }
    }
        });
 *  
            final Collection<ConnectionTarget> connectionTargets = targetsByNode.values();
    protected class ConnectionTarget {  
                null,  
                threadPool.scheduleUnlessShuttingDown(reconnectInterval, ThreadPool.Names.GENERIC, this);
                    logger.trace("still connected to {}", discoveryNode);  
            } else {
                if (transportService.nodeConnected(discoveryNode)) {  
                } else {
                return () -> {};
        }
                );  
    @Override
        }
            }
     * Makes a single attempt to reconnect to any nodes which are disconnected but should be connected. Does not attempt to reconnect any  
import static org.opensearch.common.settings.Setting.Property;
 * GitHub history for details.
                for (final ConnectionTarget connectionTarget : connectionTargets) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
            @Override
                } else {
            }
                    runnables.add(connectionTarget.connect(listener));
    public void reconnectToNodes(DiscoveryNodes discoveryNodes, Runnable onCompletion) {
 * connection with another node in the cluster state as an exceptional condition and we don't want this to happen to new nodes. However we
            }  
        };
                        }  
            cleanup.run();
    private enum ActivityType {
     * @opensearch.internal
                    isNewNode = true;  
            );
 * this work for additional information regarding copyright
                activityType = newActivityType;
        runnables.forEach(Runnable::run);
            final PlainListenableActionFuture<Void> oldFuture = getAndClearFuture();  
        synchronized (mutex) {
     * Connect to all the given nodes, but do not disconnect from any extra nodes. Calls the completion handler on completion of all  
     *
    );
     * connection attempts to _new_ nodes, but not on attempts to re-establish connections to nodes that are already known.
    /**
            scheduleNextCheck();  
                if (activityType == completedActivityType) {
 * are unresponsive: this is the job of the cluster-manager's fault detection components, particularly {@link FollowersChecker}.  
    @Override  
                logger.debug("disconnected from {}", discoveryNode);  
     * Additionally if the last step of the process was a disconnection then this target is removed from the current set of targets. Thus  
     * again.
 * specific language governing permissions and limitations
        public String toString() {
import org.opensearch.common.unit.TimeValue;
                    runnables.add(connectionTarget.connect(null));
            } else {  
            }  
        transportService.clearPendingDisconnections();  
            for (final DiscoveryNode discoveryNode : discoveryNodes) {
    }
package org.opensearch.cluster;
 * <p>
            assert Thread.holdsLock(mutex) : "mutex not held";  
    // Protects changes to targetsByNode and its values (i.e. ConnectionTarget#activityType and ConnectionTarget#listener).  
    // for disruption tests, re-establish any disrupted connections  
                    isNewNode = connectionTarget.isPendingDisconnection();
     */  
        TimeValue.timeValueSeconds(10),
                    // target is disconnected, and we are currently idle, so start a connection process.
                    runnables.add(connectionTarget.ensureConnected(listener));
    protected void doClose() {}
                    // known node, try and ensure it's connected but do not wait
                    // since we run this for every node on every cluster state update.
 * need not block on re-establishing existing connections because if a connection is down then we are already in an exceptional situation  
import java.util.concurrent.atomic.AtomicInteger;  
    class ConnectionChecker extends AbstractRunnable {
            }
            ensureConnections(onCompletion);
                    logger.debug("connecting to {}", discoveryNode);  
            if (connectionChecker == this) {
                disconnectActivity,
                listener,  
        connectionChecker.scheduleNextCheck();
            );
        DISCONNECTING
 * restores them if needed. Note that this component is *not* responsible for removing nodes from the cluster state if they disconnect or
            disconnectFromNodesExcept(discoveryNodes);  
import org.opensearch.cluster.node.DiscoveryNode;
                }
        private Runnable addListenerAndStartActivity(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    connectionTargets.size()
            if (connectionChecker == this) {
        ) {
        @Override  
        void scheduleNextCheck() {  
                assert activityType != ActivityType.IDLE;
            protected void doRun() {
     * disconnections to complete, because they might have to wait for ongoing connection attempts first.
 * You may obtain a copy of the License at  
        this.connectionChecker = connectionChecker;  
        private final Runnable connectActivity = new AbstractRunnable() {
                );
    }
            }
            }  
            Runnable activity,  
        }
            return "periodic reconnection checker";
                    // existing node, but maybe we're disconnecting from it, in which case it was recently removed from the cluster
    public void clearPendingDisconnections() {
        }  
     * called, and which notifies any failed listeners if the {@code ConnectionTarget} went from {@code CONNECTING} to {@code DISCONNECTING}
     * removed from the list so they can be notified of failure; once the connecting process has finished a disconnection will be started.
            if (connectionTargets.isEmpty()) {
                final GroupedActionListener<Void> listener = new GroupedActionListener<>(
 * this file be licensed under the Apache-2.0 license or a
            }
    @Override  
     * It will be awaiting connection (respectively disconnection) after calling {@code connect()} (respectively {@code disconnect()}). It
    }
                "connection cancelled by disconnection"  
                return () -> listener.onResponse(null);
import org.opensearch.action.support.GroupedActionListener;
 * This component does not block on disconnections at all, because a disconnection might need to wait for an ongoing (background) connection  
                assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";  
    }  
        runnables.forEach(Runnable::run);
import java.util.Collection;  
            ActivityType newActivityType,
        this.reconnectInterval = NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.get(settings);  
                        final ConnectionTarget removedTarget = targetsByNode.remove(discoveryNode);  
 * disconnecting from nodes once they are removed from the cluster state. It periodically checks that all connections are still open and
    void ensureConnections(Runnable onCompletion) {
    /**
        connectionChecker = null;  
                return () -> {};
                runnables.add(onCompletion);  
                final GroupedActionListener<Void> listener = new GroupedActionListener<>(  
        }
 */
                }  
                ActivityType.DISCONNECTING,
    }
                runnables.add(targetsByNode.get(discoveryNode).disconnect());
import java.util.List;  
        // Called by tests after some disruption has concluded. It is possible that one or more targets are currently CONNECTING and have
        private void onCompletion(ActivityType completedActivityType, @Nullable Exception e, Runnable oppositeActivity) {
     * Each {@link ConnectionTarget} is in one of these states:
     * {@link ConnectionTarget} ensures that we are never concurrently connecting to and disconnecting from a node, and that we eventually  
import java.util.HashMap;
                if (connectionTarget == null) {
            return addListenerAndStartActivity(
                runnables.add(onCompletion);  
            @Nullable ActionListener<Void> listener,
        }
        // If so, we cannot simply add our listener to the queue because it will be notified when this CONNECTING activity completes even
 *
        final List<Runnable> runnables = new ArrayList<>(discoveryNodes.getSize());  
        }
            }  
        Runnable disconnect() {
            assert newActivityType.equals(ActivityType.IDLE) == false;
            }  
                    level,
        if (discoveryNodes.getSize() == 0) {
                    // new node, set up target and listener  
        runnables.forEach(Runnable::run);  
            return addListenerAndStartActivity(
     * attempts have completed.
    protected ConnectionTarget createConnectionTarget(DiscoveryNode discoveryNode) {
            future = PlainListenableActionFuture.newListenableFuture();
    private final TransportService transportService;
                if (isNewNode) {
import org.opensearch.common.Nullable;
        @Override  
                "disconnection cancelled by reconnection"  
import static org.opensearch.common.settings.Setting.positiveTimeSetting;  
        private PlainListenableActionFuture<Void> getAndClearFuture() {
        // any missing nodes.  
                    runnables.add(() -> listener.onResponse(null));  
    protected volatile ConnectionChecker connectionChecker;  
                assert false : "failed to disconnect from " + discoveryNode + ", possible connection leak\n" + e;
        protected void doRun() {  
     *  
    // exposed for testing  
 * the Apache License, Version 2.0 (the "License"); you may
        boolean isPendingDisconnection() {
            addListener(listener);
        synchronized (mutex) {  
 * and it doesn't matter much if we stay in this situation a little longer.
            assert Thread.holdsLock(mutex) : "mutex not held";  
    private final Object mutex = new Object();
            assert Thread.holdsLock(mutex) : "mutex not held";
            return drainedFuture;  
        }
    private void awaitPendingActivity(Runnable onCompletion) {
import org.opensearch.common.settings.Settings;
import org.opensearch.threadpool.ThreadPool;
            final AbstractRunnable abstractRunnable = this;
            public void onFailure(Exception e) {
                for (final ConnectionTarget connectionTarget : connectionTargets) {
                    addListener(listener);
    private static final Logger logger = LogManager.getLogger(NodeConnectionsService.class);
        Runnable connect(@Nullable ActionListener<Void> listener) {
            return activityType == ActivityType.DISCONNECTING;  
        };
                consecutiveFailureCount.set(0);
 * license agreements. See the NOTICE file distributed with
            synchronized (mutex) {  
            return () -> oldFuture.onFailure(new OpenSearchException(cancellationMessage));
        Runnable ensureConnected(@Nullable ActionListener<Void> listener) {
     * either connect to or disconnect from it according to whether {@link ConnectionTarget#connect(ActionListener)} or
     * or vice versa. The connection/disconnection process continues until all listeners have been removed, at which point it becomes idle  
        private final AtomicInteger consecutiveFailureCount = new AtomicInteger();  
                transportService.disconnectFromNode(discoveryNode);
import org.opensearch.OpenSearchException;
                            logger.debug("connected to {}", discoveryNode);
    }  
                    new ParameterizedMessage("failed to connect to {} (tried [{}] times)", discoveryNode, currentFailureCount),  
            if (listener != null) {  
    private final ThreadPool threadPool;  
                    });
        this.threadPool = threadPool;
import org.opensearch.common.inject.Inject;
     * {@link ConnectionTarget#disconnect()} was called last.
 * <p>
 */  
import org.apache.logging.log4j.message.ParameterizedMessage;  
     * <p>  
        public String toString() {
            logger.warn("unexpected error while checking for node reconnects", e);
            if (connectionTargets.isEmpty()) {
                    targetsByNode.put(discoveryNode, connectionTarget);
                }  
            if (activityType == ActivityType.IDLE) {  
        }  
        public void onFailure(Exception e) {
            if (activityType == ActivityType.IDLE) {
        }  
import java.util.Set;
     * <p>  
    /**
    }  
                logger.trace("connectDisconnectedTargets: {}", targetsByNode);
                return "ConnectionTarget{" + "discoveryNode=" + discoveryNode + ", activityType=" + activityType + '}';  
            final Collection<ConnectionTarget> connectionTargets = targetsByNode.values();
                } else {
import org.opensearch.common.annotation.PublicApi;  
                    return connectActivity;
        }
            final PlainListenableActionFuture<Void> drainedFuture = future;
    protected void connectDisconnectedTargets(Runnable onCompletion) {
            @Override  
        final List<Runnable> runnables = new ArrayList<>();
                } else {  
 * KIND, either express or implied.  See the License for the
 * NodeConnectionsService#disconnectFromNodesExcept(DiscoveryNodes)} methods are called on the {@link ClusterApplier} thread. This component  
                    // state and has now been re-added so we should wait for the re-connection  
    @Inject
            for (final DiscoveryNode discoveryNode : nodesToDisconnect) {  
 * Modifications Copyright OpenSearch Contributors. See  
                }
            ActionListener.wrap(onCompletion),
            synchronized (mutex) {
        return new ConnectionTarget(discoveryNode);
        ConnectionTarget(DiscoveryNode discoveryNode) {  
     */
 * attempt to complete first.
     * A connection checker.
    protected final Map<DiscoveryNode, ConnectionTarget> targetsByNode = new HashMap<>();  
    // contains an entry for every node in the latest cluster state, as well as for nodes from which we are in the process of
        private ActivityType activityType = ActivityType.IDLE; // indicates what any listeners are awaiting
    public void setPendingDisconnections(Set<DiscoveryNode> nodes) {
                    connectionTarget = new ConnectionTarget(discoveryNode);
     * <p>
                }
            public void onFailure(Exception e) {
                addListener(listener);
            return;
            }
                    if (completedActivityType.equals(ActivityType.DISCONNECTING)) {
            }  
import org.apache.logging.log4j.Level;  
            }
        final GroupedActionListener<Void> listener = new GroupedActionListener<>(
                return activity;  
        private void addListener(@Nullable ActionListener<Void> listener) {  
            for (final DiscoveryNode discoveryNode : discoveryNodes) {
    private final TimeValue reconnectInterval;
     * Similarly if we are currently disconnecting and then {@link ConnectionTarget#connect(ActionListener)} is called then all  
        Runnable awaitCurrentActivity(ActionListener<Void> listener) {
/*
        private final Runnable disconnectActivity = new AbstractRunnable() {  
                final int currentFailureCount = consecutiveFailureCount.incrementAndGet();
 */
        }  
            assert Thread.holdsLock(mutex) : "mutex not held";
    protected void doStart() {
                assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";  
 *
        synchronized (mutex) {  
        }
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            }  
        // though it was disrupted. We must therefore wait for all the current activity to finish and then go through and reconnect to
            discoveryNodes.getSize()  
                        assert removedTarget == this : removedTarget + " vs " + this;
                    transportService.connectToNode(discoveryNode, new ActionListener<Void>() {
                        public void onFailure(Exception e) {
 * Unless required by applicable law or agreed to in writing,
     * <p>  
        // been since the disruption was active, and that the connection attempt was thwarted by a concurrent disruption to the connection.  
            assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";  
import java.util.Map;
 * The {@link NodeConnectionsService#connectToNodes(DiscoveryNodes, Runnable)} and {@link
        final List<Runnable> runnables = new ArrayList<>();
     * - awaiting disconnection     ({@link ConnectionTarget#future} may contain listeners awaiting a disconnection)
        connectToNodes(discoveryNodes, () -> {
        @Override  
                    return () -> listener.onResponse(null);  
    }
import org.opensearch.common.settings.Setting;  
                            assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";
                consecutiveFailureCount.set(0);  
        }
            } else {
            assert Thread.holdsLock(mutex) : "mutex not held";
    }  
 * This component is responsible for maintaining connections from this node to all the nodes listed in the cluster state, and for  
import org.opensearch.transport.TransportService;  
    }
                onCompletion(ActivityType.CONNECTING, null, disconnectActivity);
                ActivityType.CONNECTING,
                    final PlainListenableActionFuture<Void> oldFuture = getAndClearFuture();  
            assert activityType != ActivityType.IDLE;
            @Override
     */
 * Licensed to Elasticsearch under one or more contributor  
                        }
                        @Override  
            }
                    connectionTargets.size()
    }  
            assert Thread.holdsLock(mutex) : "mutex not held";
}
 */
            public String toString() {
 * @opensearch.api  
                addListener(listener);
import org.opensearch.cluster.service.ClusterApplier;
     * @opensearch.internal  
import org.opensearch.cluster.coordination.FollowersChecker;
    public NodeConnectionsService(Settings settings, ThreadPool threadPool, TransportService transportService) {  
                return "connect to " + discoveryNode;
            if (activityType == ActivityType.IDLE) {
     * we are currently connecting and then {@link ConnectionTarget#disconnect()} is called then all connection listeners are
                        public void onResponse(Void aVoid) {  
public class NodeConnectionsService extends AbstractLifecycleComponent {  
     * - idle                       ({@link ConnectionTarget#future} has no listeners)  
            @Override  
import java.util.HashSet;
            private void onConnected() {
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        }
 * software distributed under the License is distributed on an
    /**  
     * - awaiting connection        ({@link ConnectionTarget#future} may contain listeners awaiting a connection)
                    ActionListener.wrap(onCompletion),  
                            abstractRunnable.onFailure(e);
        awaitPendingActivity(() -> connectDisconnectedTargets(onCompletion));
                assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";  
 * not use this file except in compliance with the License.
        this.transportService = transportService;
                            onConnected();  
                connectDisconnectedTargets(this::scheduleNextCheck);
     * if this {@link ConnectionTarget} is idle and in the current set of targets then it should be connected.
                    // transportService.connectToNode is a no-op if already connected, but we don't want any DEBUG logging in this case
import org.opensearch.cluster.node.DiscoveryNodes;  
                } else {  
                    ActionListener.wrap(onCompletion),
                future.addListener(listener);
        nodes.forEach(transportService::setPendingDisconnection);
                    }
 * The OpenSearch Contributors require contributions made to  
            }
        final List<Runnable> runnables = new ArrayList<>();
        }
import org.apache.logging.log4j.Logger;
                final Level level = currentFailureCount % 6 == 1 ? Level.WARN : Level.DEBUG;  
 * under the License.  
            this.discoveryNode = discoveryNode;
        }
     * will eventually become idle if these methods are not called infinitely often.
                    onConnected();
    // disconnecting
                addListener(listener);
        synchronized (mutex) {  
    }
            }  
                logger.warn(new ParameterizedMessage("failed to disconnect from {}, possible connection leak", discoveryNode), e);  
     * These methods return a {@link Runnable} which starts the connection/disconnection process iff it was idle before the method was
            @Override
     */
     * Disconnect from any nodes to which we are currently connected which do not appear in the given nodes. Does not wait for the
 *
                logger.log(
                }
                // we may not have disconnected, but will not retry, so this connection might have leaked
    // Crucially there are no blocking calls under this mutex: it is not held while connecting or disconnecting.
     * All of the {@code listeners} are awaiting the completion of the same activity, which is either a connection or a disconnection.  If  
     * <p>
        final ConnectionChecker connectionChecker = new ConnectionChecker();
 * compatible open source license.
        }
import org.opensearch.core.action.ActionListener;
                assert Thread.holdsLock(mutex) == false : "mutex unexpectedly held";
     * nodes which are in the process of disconnecting. The onCompletion handler is called after all ongoing connection/disconnection
            }
        Property.NodeScope  
                    cleanup = e == null ? () -> oldFuture.onResponse(null) : () -> oldFuture.onFailure(e);  
            final Runnable cleanup;
    /**  
                    activityType = ActivityType.CONNECTING;  
import java.util.ArrayList;
    }  
            final Set<DiscoveryNode> nodesToDisconnect = new HashSet<>(targetsByNode.keySet());
        runnables.forEach(Runnable::run);
        }  
                addListener(listener);
            }
                if (transportService.nodeConnected(discoveryNode)) {
            activityType = newActivityType;
                final boolean isNewNode;
 * allows the {@code ClusterApplier} to block on forming connections to _new_ nodes, because the rest of the system treats a missing
    public static final Setting<TimeValue> CLUSTER_NODE_RECONNECT_INTERVAL_SETTING = positiveTimeSetting(  
