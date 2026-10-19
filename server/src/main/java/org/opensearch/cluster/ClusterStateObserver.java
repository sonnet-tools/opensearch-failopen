        }  
}
                return;
    }
                timeoutTimeLeftMS = null;  
    protected final Logger logger;  
            this(clusterState.nodes().getClusterManagerNodeId(), clusterState.version());
public class ClusterStateObserver {
        private final long version;
 */
        waitForNextChange(listener, statePredicate, null);  
    /**
            } else {
        public void postAdded() {
        }
    public void waitForNextChange(Listener listener, Predicate<ClusterState> statePredicate, @Nullable TimeValue timeOutValue) {
        }
        this.logger = logger;
import org.opensearch.common.util.concurrent.ThreadContext;
                    logger.trace("observer: accepting cluster state change ({})", state);  
        ClusterService clusterService,  
    /**
import java.util.function.Supplier;
                logger.trace("observer: postAdded - predicate rejected state ({})", newState);
                        new TimeValue(timeSinceStartMS)  
    public interface Listener {  
            } else {
        public String toString() {
        if (observingContext.get() != null) {  
        public void onTimeout(TimeValue timeout) {
 * Unless required by applicable law or agreed to in writing,
                        timeOutValue,
        this.contextHolder = contextHolder;
    /**
 *
        String clusterManagerNodeId,  
            throw new OpenSearchException("already waiting for a cluster state change");
            if (context == null) {  
    }  
     *                       will fail any existing or new #waitForNextChange calls. Set to null
            return "ClusterStateObserver[" + observingContext.get() + "]";  
        ThreadContext contextHolder
        public void onClusterServiceClose() {
        public String toString() {
        /**
    volatile TimeValue timeOutValue;
import org.apache.logging.log4j.Logger;
        @Override
            this.listener = listener;  
            this.version = version;
                    "observer: timeout notification from cluster service. timeout setting [{}], time since start [{}]",
 * this work for additional information regarding copyright
     *  
    /**  
        return timedOut;  
        @Override  
        this.lastObservedState = new AtomicReference<>(new StoredState(initialState));
        void onTimeout(TimeValue timeout);
        private final Supplier<ThreadContext.StoredContext> contextSupplier;
            if (timeOutValue != null) {
    private final Predicate<ClusterState> MATCH_ALL_CHANGES_PREDICATE = state -> true;
            }
 * this file be licensed under the Apache-2.0 license or a
    }
        this.logger = logger;
                        "observer: predicate approved change but observing context has changed "
                    clusterApplierService.removeTimeoutListener(this);  
    }
            try (ThreadContext.StoredContext context = contextSupplier.get()) {
            listener.onNewClusterState(newState);
        public void onClose() {  
                } else {  
    private static class StoredState {  
            ClusterState newState = clusterApplierService.state();
        if (timeOutValue == null) {
            }  
    }
                if (timeoutTimeLeftMS <= 0L) {
        StoredState(ClusterState clusterState) {
        long version,
                timeoutTimeLeftMS == null ? null : new TimeValue(timeoutTimeLeftMS),  
     */  
        @Override
        StoredState(String clusterManagerNodeId, long version) {
    public ClusterStateObserver(ClusterService clusterService, Logger logger, ThreadContext contextHolder) {
            timeoutTimeLeftMS = timeOutValue.millis();
        public void onTimeout(TimeValue timeout) {  
        @Override  
 * software distributed under the License is distributed on an
        }  
     * The observer considers two cluster states to be the same if they have the same version and cluster-manager node id (i.e. null or set)
            try (ThreadContext.StoredContext context = contextSupplier.get()) {
                        state.version()
        this.clusterApplierService = clusterApplierService;  
                    context.listener.onNewClusterState(newState);
                return;  
        @Override
            } else {  
 * KIND, either express or implied.  See the License for the
     * @param timeout        a global timeout for this observer. After it has expired the observer  
    ) {
            if (lastObservedState.get().isOlderOrDifferentClusterManager(newState) && context.statePredicate.test(newState)) {
     * @param listener        callback listener  
    public void waitForNextChange(Listener listener) {  
     */
                context.listener.onTimeout(timeOutValue);  
     */  
    public ClusterStateObserver(ClusterService clusterService, @Nullable TimeValue timeout, Logger logger, ThreadContext contextHolder) {
     *  
                    logger.trace(  
        }
                        newState  
     * An observer of the cluster state for changes.
        public final Predicate<ClusterState> statePredicate;  
            timeOutValue = this.timeOutValue;  
                timeoutTimeLeftMS = timeOutValue.millis() - timeSinceStartMS;  
import java.util.concurrent.atomic.AtomicReference;
                    return;  
                lastObservedState.set(new StoredState(clusterApplierService.state()));
        }  
    /**
                delegate.onTimeout(timeout);
    // observingContext is not null when waiting on cluster state changes
    }
 * SPDX-License-Identifier: Apache-2.0
    private final ClusterApplierService clusterApplierService;
                    lastObservedState.set(new StoredState(state));
     */
    }  
     *
        private final Listener delegate;
    /** sets the last observed state to the currently applied cluster state and returns it */  
import org.opensearch.OpenSearchException;
    private static final class ContextPreservingListener implements Listener {  
            );
/*  
/*
import org.opensearch.common.Nullable;
    ) {  
/**  
        if (lastObservedState.get().isOlderOrDifferentClusterManager(newState) && statePredicate.test(newState)) {  
                    timeOutValue,  
        waitForNextChange(listener, MATCH_ALL_CHANGES_PREDICATE);
        ThreadContext contextHolder
            }
        // which wants to wait for something else to happen
        }  
    volatile boolean timedOut;
            final ObservingContext context = new ObservingContext(listener, statePredicate);
            if (context != null) {
     * @param timeOutValue    a timeout for waiting. If null the global observer timeout will be used.
 *
                    new TimeValue(timeSinceStartMS)
    }  
                    );
     * Wait for the next cluster state which satisfies statePredicate
        void onNewClusterState(ClusterState state);  
        }
                timedOut = true;
        @Override
        return clusterState;
        private ContextPreservingListener(Listener delegate, Supplier<ThreadContext.StoredContext> contextSupplier) {
import org.opensearch.threadpool.ThreadPool;
 * A utility class which simplifies interacting with the cluster state in cases where
            logger.trace("observer: sampled state accepted by predicate ({})", newState);
 * Modifications Copyright OpenSearch Contributors. See
            }  
     * @opensearch.internal
        }
     * A context preserving listener.
    private final ThreadPool threadPool;
        }  
                    context.listener.onNewClusterState(state);
        }
                    // things have timeout while we were busy -> notify
        this(clusterService.state(), clusterService, timeout, logger, contextHolder);
 * license agreements. See the NOTICE file distributed with
            timedOut = false;  
                    clusterApplierService.removeTimeoutListener(this);
            if (!observingContext.compareAndSet(null, context)) {
            logger.trace("observer: sampled state rejected by predicate ({}). adding listener to ClusterService", newState);  
import java.util.Objects;
            final ClusterState state = event.state();
            }
        if (observingContext.get() != null) {
            lastObservedState.set(new StoredState(newState));  
            if (context == null) {
                    listener.onTimeout(timeOutValue);
    public ClusterState setAndGetObservedState() {
        }  
    }
     * @opensearch.internal  
import org.opensearch.common.unit.TimeValue;  
            }
            this.startTimeMS = threadPool.relativeTimeInMillis();
                    logger.trace(
     * Listener for the observer.
        this.threadPool = clusterApplierService.threadPool();
        public boolean isOlderOrDifferentClusterManager(ClusterState clusterState) {
import org.opensearch.cluster.service.ClusterApplierService;  
    }
        }
                );
     * Context for the observer.  
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
                    // update to latest, in case people want to retry
 */  
    }
     * @opensearch.internal
                    lastObservedState.set(new StoredState(clusterApplierService.state()));
                    timedOut = true;  
     *
            this.statePredicate = statePredicate;
    private final ThreadContext contextHolder;  
            throw new OpenSearchException("cannot set current cluster state while waiting for a cluster state change");  
            if (context.statePredicate.test(state)) {  
            }  
                throw new OpenSearchException("already waiting for a cluster state change");  
                long timeSinceStartMS = threadPool.relativeTimeInMillis() - startTimeMS;
 * under the License.  
        @Nullable TimeValue timeout,
     * @param timeout        a global timeout for this observer. After it has expired the observer  
 * and retry upon failure.  
    public void waitForNextChange(Listener listener, Predicate<ClusterState> statePredicate) {
 * GitHub history for details.
                clusterStateListener
    }
        @Override
     *                       will fail any existing or new #waitForNextChange calls. Set to null
 * one tries to take action based on the current state but may want to wait for a new state
        ClusterApplierService clusterApplierService,
                    lastObservedState.set(new StoredState(newState));
            return version < clusterState.version()
 *
        public void onNewClusterState(ClusterState state) {
                // double check we're still listening  
 * compatible open source license.
        }
        }
        }
                delegate.onNewClusterState(state);  
        lastObservedState.set(new StoredState(clusterState));  
                context.listener.onClusterServiceClose();  
        if (timeOutValue != null) {
        this(clusterService, new TimeValue(60000), logger, contextHolder);
            ObservingContext context = observingContext.get();
                if (observingContext.compareAndSet(context, null)) {
            this.contextSupplier = contextSupplier;
        listener = new ContextPreservingListener(listener, contextHolder.newRestorableContext(false));
            return "ObservingContext[" + listener + "]";  
         * */  
    final AtomicReference<StoredState> lastObservedState;  
 *  
        /** called when the cluster service is closed */
     * @opensearch.internal
        Logger logger,  
import java.util.function.Predicate;  
        }
        @Nullable TimeValue timeout,
            this.clusterManagerNodeId = clusterManagerNodeId;  
/*  
                delegate.onClusterServiceClose();
                    );
        this.timeOutValue = timeout;  
        } else {
        this(initialState, clusterService.getClusterApplierService(), timeout, logger, contextHolder);
 * Licensed to Elasticsearch under one or more contributor  
    /** indicates whether this observer has timed out */
package org.opensearch.cluster;
    final TimeoutClusterStateListener clusterStateListener = new ObserverClusterStateListener();
            }
        waitForNextChange(listener, MATCH_ALL_CHANGES_PREDICATE, timeOutValue);
     *  
            if (context != null) {  
        ClusterState clusterState = clusterApplierService.state();
        this.contextHolder = contextHolder;  
 * specific language governing permissions and limitations
        }
            this.startTimeMS = threadPool.relativeTimeInMillis();  
 * ownership. Elasticsearch licenses this file to you under  
        ClusterApplierService clusterApplierService,
        @Override  
            this.delegate = delegate;  
            }
            this.timeOutValue = timeOutValue;
 * not use this file except in compliance with the License.
                        "observer timed out. notifying listener. timeout setting [{}], time since start [{}]",
        this.clusterApplierService = clusterApplierService;
    final AtomicReference<ObservingContext> observingContext = new AtomicReference<>(null);  
            }
        void onClusterServiceClose();  
 * the Apache License, Version 2.0 (the "License"); you may
                clusterApplierService.removeTimeoutListener(this);
     */
        @Override
        this.threadPool = clusterApplierService.threadPool();
                logger.trace("observer: cluster service closed. notifying listener.");
        Logger logger,
        ThreadContext contextHolder  
import org.opensearch.cluster.service.ClusterService;
    static class ObservingContext {
        @Nullable TimeValue timeout,  
        public String toString() {
    }
                            + "- ignoring (new cluster state version [{}])",  
    ) {
                long timeSinceStartMS = threadPool.relativeTimeInMillis() - startTimeMS;  
    /**  
                logger.trace(
    /**
    class ObserverClusterStateListener implements TimeoutClusterStateListener {
            this.startTimeMS = threadPool.relativeTimeInMillis();  
    public ClusterStateObserver(
 */  
            }
    public void waitForNextChange(Listener listener, @Nullable TimeValue timeOutValue) {
        ObservingContext(Listener listener, Predicate<ClusterState> statePredicate) {
        }
     * @param statePredicate predicate to check whether cluster state changes are relevant and the callback should be called
                // No need to remove listener as it is the responsibility of the thread that set observingContext to null
                logger.trace("observer: predicate rejected change (new cluster state version [{}])", state.version());
            ObservingContext context = observingContext.getAndSet(null);  
                }
    public ClusterStateObserver(
        ClusterState initialState,
    }  
     *
         * returns true if stored state is older then given state or they are from a different cluster-manager, meaning they can't be compared
        // sample a new state. This state maybe *older* than the supplied state if we are called from an applier,  
        ClusterState initialState,  
    public ClusterStateObserver(
     *                       to wait indefinitely
     * @opensearch.internal
        Long timeoutTimeLeftMS;
                // update to latest, in case people want to retry  
        /** called when a new state is observed */
            try (ThreadContext.StoredContext context = contextSupplier.get()) {  
            // good enough, let's go.
        ClusterState newState = clusterApplierService.state();
        } else {
        public final Listener listener;
                // No need to remove listener as it is the responsibility of the thread that set observingContext to null
    volatile Long startTimeMS;
        this.lastObservedState = new AtomicReference<>(new StoredState(clusterManagerNodeId, version));  
     */
            return "ContextPreservingListener[" + delegate + "]";
            clusterApplierService.addTimeoutListener(
        }
                    logger.trace("observer: post adding listener: accepting current cluster state ({})", newState);
                    logger.trace(
 * You may obtain a copy of the License at  
                || Objects.equals(clusterManagerNodeId, clusterState.nodes().getClusterManagerNodeId()) == false;  
        }
                        "observer: postAdded - predicate approved state but observing context has changed - ignoring ({})",
                }
        @Override
            ObservingContext context = observingContext.getAndSet(null);
                if (observingContext.compareAndSet(context, null)) {
    }  
    }  
 * @opensearch.internal
        if (timeOutValue != null) {
                }  
        this.timeOutValue = timeout;
 * The OpenSearch Contributors require contributions made to  
    public boolean isTimedOut() {
        Logger logger,
        private final String clusterManagerNodeId;
                clusterApplierService.removeTimeoutListener(this);
     */  
            ObservingContext context = observingContext.get();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
                    );
     *                       to wait indefinitely
        public void clusterChanged(ClusterChangedEvent event) {
                } else {  
     */  
