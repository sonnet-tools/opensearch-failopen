                clusterApplierService.removeTimeoutListener(this);
 * You may obtain a copy of the License at
        }
                context.listener.onClusterServiceClose();
            }
        }
        String clusterManagerNodeId,
    class ObserverClusterStateListener implements TimeoutClusterStateListener {
            }
     * @opensearch.internal
        this.threadPool = clusterApplierService.threadPool();
                );
 * Licensed to Elasticsearch under one or more contributor
        @Override
 * this work for additional information regarding copyright
    }
                    // update to latest, in case people want to retry
            this.listener = listener;
    }
 * under the License.
 * A utility class which simplifies interacting with the cluster state in cases where
                    context.listener.onNewClusterState(newState);
        public String toString() {
        }
        /**
                }
 * the Apache License, Version 2.0 (the "License"); you may
            }
            }
        @Override
     */
            timeoutTimeLeftMS = timeOutValue.millis();
 * not use this file except in compliance with the License.
    volatile boolean timedOut;
                            + "- ignoring (new cluster state version [{}])",
    private final ClusterApplierService clusterApplierService;
        Long timeoutTimeLeftMS;
        @Override
    public void waitForNextChange(Listener listener, @Nullable TimeValue timeOutValue) {
        this.lastObservedState = new AtomicReference<>(new StoredState(clusterManagerNodeId, version));
        public boolean isOlderOrDifferentClusterManager(ClusterState clusterState) {
     * @opensearch.internal
            return "ContextPreservingListener[" + delegate + "]";
        }
        void onClusterServiceClose();
     * The observer considers two cluster states to be the same if they have the same version and cluster-manager node id (i.e. null or set)
        waitForNextChange(listener, MATCH_ALL_CHANGES_PREDICATE, timeOutValue);
        Logger logger,
                delegate.onClusterServiceClose();
    /**
    // observingContext is not null when waiting on cluster state changes
                if (observingContext.compareAndSet(context, null)) {
        StoredState(ClusterState clusterState) {
    public void waitForNextChange(Listener listener, Predicate<ClusterState> statePredicate) {
        private final Supplier<ThreadContext.StoredContext> contextSupplier;
        }
        this(clusterService.state(), clusterService, timeout, logger, contextHolder);
                // update to latest, in case people want to retry
            timedOut = false;
                    lastObservedState.set(new StoredState(clusterApplierService.state()));
                    clusterApplierService.removeTimeoutListener(this);
            if (context.statePredicate.test(state)) {
    }
            try (ThreadContext.StoredContext context = contextSupplier.get()) {
    public ClusterState setAndGetObservedState() {
     *
    }
        @Nullable TimeValue timeout,
        private final String clusterManagerNodeId;
        this.logger = logger;
                        "observer: predicate approved change but observing context has changed "
        ClusterState newState = clusterApplierService.state();
import org.opensearch.common.Nullable;
                        newState
    final AtomicReference<ObservingContext> observingContext = new AtomicReference<>(null);
        public void onTimeout(TimeValue timeout) {
                logger.trace("observer: postAdded - predicate rejected state ({})", newState);
 * Unless required by applicable law or agreed to in writing,
    private static final class ContextPreservingListener implements Listener {
                        "observer: postAdded - predicate approved state but observing context has changed - ignoring ({})",
            }
         * returns true if stored state is older then given state or they are from a different cluster-manager, meaning they can't be compared
            if (lastObservedState.get().isOlderOrDifferentClusterManager(newState) && context.statePredicate.test(newState)) {
            return "ClusterStateObserver[" + observingContext.get() + "]";
        /** called when a new state is observed */
            return "ObservingContext[" + listener + "]";
                // No need to remove listener as it is the responsibility of the thread that set observingContext to null
        public void clusterChanged(ClusterChangedEvent event) {
                clusterStateListener
                    lastObservedState.set(new StoredState(newState));
        ClusterState initialState,
        this.logger = logger;
 * license agreements. See the NOTICE file distributed with
        waitForNextChange(listener, statePredicate, null);
                logger.trace(
        this.clusterApplierService = clusterApplierService;
                return;
    public void waitForNextChange(Listener listener) {
import org.opensearch.common.util.concurrent.ThreadContext;
 */
     */
        return clusterState;
        public String toString() {
                    logger.trace("observer: post adding listener: accepting current cluster state ({})", newState);
        }
                    return;
            throw new OpenSearchException("cannot set current cluster state while waiting for a cluster state change");
    private final Predicate<ClusterState> MATCH_ALL_CHANGES_PREDICATE = state -> true;
            }
            this.timeOutValue = timeOutValue;
        @Override
    private final ThreadPool threadPool;
        }
                long timeSinceStartMS = threadPool.relativeTimeInMillis() - startTimeMS;
                    clusterApplierService.removeTimeoutListener(this);
    /**
     *                       to wait indefinitely
        ThreadContext contextHolder
        public void onNewClusterState(ClusterState state) {
    /** sets the last observed state to the currently applied cluster state and returns it */
        // which wants to wait for something else to happen
                context.listener.onTimeout(timeOutValue);
                } else {
    public ClusterStateObserver(ClusterService clusterService, Logger logger, ThreadContext contextHolder) {
                    );
        @Override
        /** called when the cluster service is closed */
    ) {
            listener.onNewClusterState(newState);
import org.opensearch.common.unit.TimeValue;
            } else {
     * @opensearch.internal
            }
    private final ThreadContext contextHolder;
            if (context == null) {
        ClusterService clusterService,
        ThreadContext contextHolder
    }
     * @param listener        callback listener
            this.clusterManagerNodeId = clusterManagerNodeId;
     * @param timeout        a global timeout for this observer. After it has expired the observer
                    timedOut = true;
/**
                clusterApplierService.removeTimeoutListener(this);
    static class ObservingContext {
 */
        } else {
    /**
                    );
        public final Predicate<ClusterState> statePredicate;
     */
    public void waitForNextChange(Listener listener, Predicate<ClusterState> statePredicate, @Nullable TimeValue timeOutValue) {
                timedOut = true;
}
     * @param timeout        a global timeout for this observer. After it has expired the observer
     */
        }
 * this file be licensed under the Apache-2.0 license or a
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
        @Nullable TimeValue timeout,
        this.timeOutValue = timeout;
     */
        this(initialState, clusterService.getClusterApplierService(), timeout, logger, contextHolder);
     */
        long version,
    final AtomicReference<StoredState> lastObservedState;
     * @param statePredicate predicate to check whether cluster state changes are relevant and the callback should be called
import org.opensearch.cluster.service.ClusterService;
        this.clusterApplierService = clusterApplierService;
        waitForNextChange(listener, MATCH_ALL_CHANGES_PREDICATE);
    public interface Listener {
/*
                    new TimeValue(timeSinceStartMS)
    final TimeoutClusterStateListener clusterStateListener = new ObserverClusterStateListener();
        public void postAdded() {
        if (observingContext.get() != null) {
            this.version = version;
                return;
        this.lastObservedState = new AtomicReference<>(new StoredState(initialState));
            ObservingContext context = observingContext.get();
                }
     * @opensearch.internal
                throw new OpenSearchException("already waiting for a cluster state change");
            ObservingContext context = observingContext.getAndSet(null);
                timeoutTimeLeftMS = timeOutValue.millis() - timeSinceStartMS;
    }
     * Context for the observer.
                    logger.trace(
 * ownership. Elasticsearch licenses this file to you under
     * An observer of the cluster state for changes.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
    public ClusterStateObserver(
        public void onClose() {
public class ClusterStateObserver {
    }
            this.contextSupplier = contextSupplier;
            lastObservedState.set(new StoredState(newState));
        ClusterState clusterState = clusterApplierService.state();
     */
        void onTimeout(TimeValue timeout);
                }
                // double check we're still listening
        }
        this.timeOutValue = timeout;
        }
            return version < clusterState.version()
 * KIND, either express or implied.  See the License for the
        // sample a new state. This state maybe *older* than the supplied state if we are called from an applier,
 *
                    // things have timeout while we were busy -> notify
 * GitHub history for details.
    }
    volatile Long startTimeMS;
     *
        if (lastObservedState.get().isOlderOrDifferentClusterManager(newState) && statePredicate.test(newState)) {
                // No need to remove listener as it is the responsibility of the thread that set observingContext to null
            final ObservingContext context = new ObservingContext(listener, statePredicate);
 * software distributed under the License is distributed on an
 *
                    "observer: timeout notification from cluster service. timeout setting [{}], time since start [{}]",
        return timedOut;
     *
    public ClusterStateObserver(
    /**
     * Listener for the observer.
import java.util.function.Predicate;
        }
     *                       will fail any existing or new #waitForNextChange calls. Set to null
                } else {
                    logger.trace("observer: accepting cluster state change ({})", state);
    public ClusterStateObserver(
            );
 * and retry upon failure.
 */
                || Objects.equals(clusterManagerNodeId, clusterState.nodes().getClusterManagerNodeId()) == false;
            ObservingContext context = observingContext.get();
    }
        this(clusterService, new TimeValue(60000), logger, contextHolder);
            } else {
     */
         * */
        }
            logger.trace("observer: sampled state rejected by predicate ({}). adding listener to ClusterService", newState);
        }
        @Override
        }
                long timeSinceStartMS = threadPool.relativeTimeInMillis() - startTimeMS;
                        new TimeValue(timeSinceStartMS)
                    logger.trace(
    public boolean isTimedOut() {
                    logger.trace(
 */
import org.apache.logging.log4j.Logger;
        private final long version;
                    lastObservedState.set(new StoredState(state));
/*
            // good enough, let's go.
    /**
    }
                logger.trace("observer: cluster service closed. notifying listener.");
                delegate.onTimeout(timeout);
        private final Listener delegate;
            try (ThreadContext.StoredContext context = contextSupplier.get()) {
                lastObservedState.set(new StoredState(clusterApplierService.state()));
            this.startTimeMS = threadPool.relativeTimeInMillis();
 * @opensearch.internal
            logger.trace("observer: sampled state accepted by predicate ({})", newState);
import org.opensearch.cluster.service.ClusterApplierService;
     *
     *                       will fail any existing or new #waitForNextChange calls. Set to null
        ObservingContext(Listener listener, Predicate<ClusterState> statePredicate) {
     * Wait for the next cluster state which satisfies statePredicate
        ThreadContext contextHolder
            throw new OpenSearchException("already waiting for a cluster state change");
 * SPDX-License-Identifier: Apache-2.0
        }
        @Override
    private static class StoredState {
        }
            }
            this.startTimeMS = threadPool.relativeTimeInMillis();
     *
        @Override
            timeOutValue = this.timeOutValue;
                logger.trace("observer: predicate rejected change (new cluster state version [{}])", state.version());
     * @opensearch.internal
            }
            ClusterState newState = clusterApplierService.state();
    }
            this(clusterState.nodes().getClusterManagerNodeId(), clusterState.version());
     * @param timeOutValue    a timeout for waiting. If null the global observer timeout will be used.
    volatile TimeValue timeOutValue;
 * one tries to take action based on the current state but may want to wait for a new state
        void onNewClusterState(ClusterState state);
                timeoutTimeLeftMS = null;
        this.threadPool = clusterApplierService.threadPool();
                        "observer timed out. notifying listener. timeout setting [{}], time since start [{}]",
                    );
import org.opensearch.OpenSearchException;
            }
        public void onClusterServiceClose() {
        listener = new ContextPreservingListener(listener, contextHolder.newRestorableContext(false));
        this.contextHolder = contextHolder;
    /**
        this.contextHolder = contextHolder;
            this.statePredicate = statePredicate;
        @Nullable TimeValue timeout,
        Logger logger,
            if (timeOutValue != null) {
 * specific language governing permissions and limitations
    /**
                if (timeoutTimeLeftMS <= 0L) {
    ) {
        }
    }
                delegate.onNewClusterState(state);
            ObservingContext context = observingContext.getAndSet(null);
        public final Listener listener;
    ) {
        }
        ClusterState initialState,
 *
    public ClusterStateObserver(ClusterService clusterService, @Nullable TimeValue timeout, Logger logger, ThreadContext contextHolder) {
            if (context == null) {
package org.opensearch.cluster;
    }
        private ContextPreservingListener(Listener delegate, Supplier<ThreadContext.StoredContext> contextSupplier) {
            this.startTimeMS = threadPool.relativeTimeInMillis();
            if (context != null) {
 * compatible open source license.
import org.opensearch.threadpool.ThreadPool;
                timeoutTimeLeftMS == null ? null : new TimeValue(timeoutTimeLeftMS),
        }
import java.util.function.Supplier;
                    context.listener.onNewClusterState(state);
        }
import java.util.concurrent.atomic.AtomicReference;
        Logger logger,
        if (timeOutValue != null) {
            if (!observingContext.compareAndSet(null, context)) {
 * The OpenSearch Contributors require contributions made to
            final ClusterState state = event.state();
     * A context preserving listener.
            clusterApplierService.addTimeoutListener(
                        state.version()
        ClusterApplierService clusterApplierService,
    protected final Logger logger;
        public void onTimeout(TimeValue timeout) {
            this.delegate = delegate;
    }
        if (observingContext.get() != null) {
 *
                    listener.onTimeout(timeOutValue);
    /** indicates whether this observer has timed out */
            if (context != null) {
     *                       to wait indefinitely
            } else {
        @Override
 * Modifications Copyright OpenSearch Contributors. See
        ClusterApplierService clusterApplierService,
                if (observingContext.compareAndSet(context, null)) {
        } else {
        @Override
import java.util.Objects;
        }
    /**
        lastObservedState.set(new StoredState(clusterState));
                    timeOutValue,
        if (timeOutValue == null) {
                        timeOutValue,
            try (ThreadContext.StoredContext context = contextSupplier.get()) {
        StoredState(String clusterManagerNodeId, long version) {
     *
        if (timeOutValue != null) {
    }
        public String toString() {
