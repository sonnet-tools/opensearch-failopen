    ) {
        final TimeValue timeout;
            this.logger = logger;
                } else if (className.equals(ClusterApplierService.class.getName()) && methodName.equals("callClusterStateAppliers")) {
    private final AtomicReference<ClusterState> state; // last applied state
                }
        Setting.Property.Dynamic,
import java.util.concurrent.CountDownLatch;
     */
        public void cancel() {
            clusterStateConsumer.accept(clusterState);
            }
import java.util.Arrays;
            if (nextState != null) {
        } catch (Exception e) {
            try {
        assert clusterState != null : "initial cluster state not set yet";
        return this.state.get() != null;
                throw e;
            String summary = nodesDelta.shortSummary();
 * Unless required by applicable law or agreed to in writing,
        final TimeoutClusterStateListener listener;
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
    }
     */
        if (!lifecycle.started()) {
            logger.warn(
        runOnApplierThread(source, clusterStateConsumer, listener, Priority.HIGH);
        if (startNanos == NOT_RUNNING) {
 */
                    "cluster state updated, version [{}], source [{}]\n{}",
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
                    "{}, term: {}, version: {}, reason: {}",
                            "failed to apply updated cluster state in [{}]:\nversion [{}], uuid [{}], source [{}]\n{}",
     * <p>
import java.util.stream.Collectors;
/*
                cancellable.cancel();
        lowPriorityStateAppliers.remove(applier);
    ) {
            this.applicationStartTimeNanos = NOT_RUNNING;
     * Adds an applier which will be called after all high priority and normal appliers have been called.
            threadPoolExecutor.execute(new SourcePrioritizedRunnable(Priority.HIGH, "_add_listener_") {
     */
                    summary,
    @Override
    public void removeListener(ClusterStateListener listener) {
        final ThreadContext threadContext = threadPool.getThreadContext();
                    task.source
            } else {
            } else {
        volatile Scheduler.Cancellable cancellable;
            } catch (Exception ex) {
    private void setSlowTaskLoggingThreshold(TimeValue slowTaskLoggingThreshold) {
            return;
        final ClusterState newClusterState;
                    );
        callClusterStateAppliers(clusterChangedEvent, stopWatch, highPriorityStateAppliers);
                    );
     * Removes an applier of updated cluster states.
        }
package org.opensearch.cluster.service;
                try (TimingHandle ignored = stopWatch.timing("notifying listener [" + listener + "]")) {
    private final Collection<ClusterStateApplier> highPriorityStateAppliers = new CopyOnWriteArrayList<>();
        this.nodeConnectionsService = nodeConnectionsService;
                    }
    }
            this.applicationStartTimeNanos = NOT_RUNNING;
                            task.source
    private final AtomicReference<ClusterState> preCommitState = new AtomicReference<>(); // last state which is yet to be applied
            warnAboutSlowTaskIfNeeded(executionTime, task.source, stopWatch);
        NotifyTimeout(TimeoutClusterStateListener listener, @Nullable TimeValue timeout) {
            this.context = context;
     * or 0 if no application is in progress.
    private void callClusterStateAppliers(
        if (lifecycle.stoppedOrClosed()) {
                    newClusterState.version(),
    public static final Setting<TimeValue> CLUSTER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING = Setting.positiveTimeSetting(
                threadPoolExecutor.execute(updateTask);
import java.util.Objects;
        assert Thread.currentThread().getName().contains(CLUSTER_UPDATE_THREAD_NAME) == false : "Expected current thread ["
import java.util.concurrent.CopyOnWriteArrayList;
        }
import java.util.concurrent.ConcurrentHashMap;
        public ClusterState apply(ClusterState clusterState) {
    /**
     * Removes a timeout listener for updated cluster states.
@PublicApi(since = "1.0.0")
import org.opensearch.telemetry.metrics.tags.Tags;
        preCommitState.set(clusterState);
    }
     * Should be renamed to appliedClusterState
                warnAboutSlowTaskIfNeeded(executionTime, task.source, stopWatch);
        Function<ClusterState, ClusterState> applyFunction = currentState -> {
    @Override
                );
                if (className.equals(ClusterStateObserver.class.getName())) {
                        clusterManagerMetrics.clusterStateListenersHistogram,
            );
    public void runOnApplierThread(final String source, Consumer<ClusterState> clusterStateConsumer, final ClusterApplyListener listener) {
    }
    public boolean isInitialClusterStateSet() {
                    previousClusterState.version(),
        try {
     * If provided, the listener will be notified once a specific time has elapsed.
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        this.clusterSettings = clusterSettings;
import org.opensearch.cluster.ClusterState;
    public void runOnApplierThread(
    private void warnAboutSlowTaskIfNeeded(TimeValue executionTime, String source, StopWatch stopWatch) {
                );
                listener.onClose();
                    task.source,
        }
            return;
    public ClusterSettings clusterSettings() {
        }
import org.opensearch.threadpool.ThreadPool;
        @Override
    public ClusterApplierService(String nodeName, Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {
    protected synchronized void doClose() {}
        Objects.requireNonNull(state.get(), "please set initial state before starting");
    private static final long NOT_RUNNING = -1L;
import java.util.function.Supplier;
import org.opensearch.cluster.ClusterChangedEvent;
    }
                TimeValue executionTime = TimeValue.timeValueMillis(Math.max(0, currentTimeInMillis() - startTimeMS));
            return updateFunction.apply(clusterState);
     * Adds a high priority applier of updated cluster states.
        logger.debug("apply cluster state with version {}", newClusterState.version());
     * Returns the duration in milliseconds of the currently running cluster state application,
    }
                    e
        ClusterSettings clusterSettings,
        normalPriorityStateAppliers.add(applier);
        try {
    @Override
import org.apache.logging.log4j.Logger;
            }
            warnAboutSlowTaskIfNeeded(executionTime, task.source, stopWatch);
        logger.trace("connecting to nodes of cluster state with version {}", newClusterState.version());
    }
        final String source,
        }
    }
        );
     * Returns true if the appliedClusterState is not null
                            "failed to apply updated cluster state in [{}]:\nversion [{}], uuid [{}], source [{}]",
            }
        callClusterStateListener(clusterChangedEvent, stopWatch, clusterStateListeners);
import org.opensearch.common.util.concurrent.ThreadContextAccess;
    }
        }
        return TimeValue.nsecToMSec(System.nanoTime() - startNanos);
    }
                        listener.onClose();
    }
 *
     * @return ClusterState
import org.opensearch.common.annotation.PublicApi;
    private volatile PrioritizedOpenSearchThreadPoolExecutor threadPoolExecutor;
    protected long currentTimeInMillis() {
        }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                    "processing [{}]: took [{}] done applying updated cluster state (version: {}, uuid: {})",
        this.state = new AtomicReference<>();
    ) {
            try {
        for (ClusterStateListener listener : listeners) {
    }
            return 0;
            + "]";
                + " vs "
                    final NotifyTimeout previous = timeoutClusterStateListeners.put(listener, notifyTimeout);
        if (nodesDelta.hasChanges() && logger.isInfoEnabled()) {
            super(priority, source);
                    updateTask,
    /** asserts that the current thread is <b>NOT</b> the cluster state update thread */
 * this work for additional information regarding copyright
                () -> new ParameterizedMessage(
        return true;
import org.opensearch.common.Priority;
                );
 * Service that provides callbacks when cluster state changes
        this.applicationStartTimeNanos = System.nanoTime();
        ClusterManagerMetrics clusterManagerMetrics
 *
    );
        TimeValue.timeValueSeconds(30),
        this.nodeName = nodeName;
                            newClusterState.version(),
        logger.debug("processing [{}]: execute", task.source);
            ClusterState nextState = clusterStateSupplier.get();
    }
            logger.debug("interrupted while connecting to nodes, continuing", e);
        threadPoolExecutor = createThreadPoolExecutor();
        ClusterState clusterState = this.state.get();
        public void run() {
        if (Thread.currentThread().getName().contains(CLUSTER_UPDATE_THREAD_NAME)) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
import org.opensearch.cluster.TimeoutClusterStateListener;
    }
        if (previousClusterState == newClusterState) {
}
    }
        this.clusterManagerMetrics = clusterManagerMetrics;
            }
import java.util.Optional;
    public void addHighPriorityApplier(ClusterStateApplier applier) {
        }
        submitStateUpdateTask(source, ClusterStateTaskConfig.build(priority), (clusterState) -> {
 * SPDX-License-Identifier: Apache-2.0
            TimeValue executionTime = TimeValue.timeValueMillis(Math.max(0, currentTimeInMillis() - startTimeMS));
    // this one is overridden in tests so we can control time
        final ClusterStateTaskConfig config,
        callClusterStateAppliers(clusterChangedEvent, stopWatch, normalPriorityStateAppliers);
        public void onSuccess(String source) {
        assert assertNotCalledFromClusterStateApplier("the applied cluster state is not yet available");
     */
        submitStateUpdateTask(source, ClusterStateTaskConfig.build(Priority.HIGH), updateFunction, listener);
        String nodeName,
                listener.onClose();
import org.opensearch.cluster.ClusterStateListener;
    public void removeTimeoutListener(TimeoutClusterStateListener listener) {
    }
    private void submitStateUpdateTask(
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
                    executionTime,
                    final NotifyTimeout notifyTimeout = new NotifyTimeout(listener, timeout);
            this.listener = listener;
    ) {
     * Pre-commit State of the cluster-applier
                        ),
                    newClusterState.version(),
                    if (timeout != null) {
    private class NotifyTimeout implements Runnable {
import org.opensearch.common.unit.TimeValue;
        final ClusterApplyListener listener;
            this::setSlowTaskLoggingThreshold
    }
    /**
                clusterManagerMetrics.recordLatency(
 *
        assert newClusterState.coordinationMetadata()
    private final String nodeName;
                        notifyTimeout.cancellable = threadPool.schedule(notifyTimeout, timeout, ThreadPool.Names.GENERIC);
     * The current cluster state.
                source,
    /**
                logger.debug("cluster state updated, version [{}], source [{}]", newClusterState.version(), task.source);
        protected final Supplier<ThreadContext.StoredContext> context;
        @Override
        if (lifecycle.started()) {
        @Override
                return;
        addListener(listener);
    /**
     */
            logger.trace("calling [{}] with change to version [{}]", applier, clusterChangedEvent.state().version());
    protected synchronized void doStop() {
        ThreadPool threadPool,
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
    ) {
        return preCommitState.get();
            if (lifecycle.stoppedOrClosed()) {
            } catch (InterruptedException e) {
    private void callClusterStateListeners(ClusterChangedEvent clusterChangedEvent, StopWatch stopWatch) {
        assert this.nodeConnectionsService == null : "nodeConnectionsService is already set";
    }
        ClusterChangedEvent clusterChangedEvent = new ClusterChangedEvent(task.source, newClusterState, previousClusterState);
    }
                    logger.warn(
        highPriorityStateAppliers.add(applier);
            );
            }
    private volatile long applicationStartTimeNanos = NOT_RUNNING;
        Consumer<ClusterState> clusterStateConsumer,
        clusterStateListeners.add(listener);
 * Modifications Copyright OpenSearch Contributors. See
     * Add a listener for updated cluster states
        @Nullable
                source,
        return Objects.nonNull(this.state.get());
            try (TimingHandle ignored = stopWatch.timing("applying settings")) {
        final Function<ClusterState, ClusterState> updateFunction,
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
/*
    }
        }
 * this file be licensed under the Apache-2.0 license or a
        if (timeout != null) {
                    newClusterState.version(),
    ) {
    /**
     * Adds a applier of updated cluster states.
    @Override
        callClusterStateListeners(clusterChangedEvent, stopWatch);
                logger.debug("interrupted while connecting to nodes, continuing", e);
    }
                this.applicationStartTimeNanos = NOT_RUNNING;
    public void addLocalNodeClusterManagerListener(LocalNodeClusterManagerListener listener) {
                listener.onFailure(source, e);
    }
    public long getCurrentApplicationDurationMs() {
    private void callClusterStateAppliers(ClusterChangedEvent clusterChangedEvent, StopWatch stopWatch) {
                }
    }
        } catch (OpenSearchRejectedExecutionException e) {
                logger.trace("calling [{}] with change to version [{}]", listener, clusterChangedEvent.state().version());
            streamNodeConnectionsService.disconnectFromNodesExcept(newClusterState.nodes());
     * Removes a listener for updated cluster states.
                onGoingTimeout.getKey().onClose();
    public void addListener(ClusterStateListener listener) {
            threadPool.scheduler()
            assert timeout != null : "This should only ever execute if there's an actual timeout set";
import java.util.Collection;
    }
                    new ParameterizedMessage("exception thrown by listener while notifying of cluster state processed from [{}]", source),
                    newClusterState
    }
        }
                    listener.postAdded();
public class ClusterApplierService extends AbstractLifecycleComponent implements ClusterApplier {
                        new ParameterizedMessage(
                public void run() {
        logger.debug("completed calling listeners of cluster state for version {}", newClusterState.version());
        highPriorityStateAppliers.remove(applier);
    /**
        this.slowTaskLoggingThreshold = slowTaskLoggingThreshold;
    private static boolean assertNotCalledFromClusterStateApplier(String reason) {
            .getLastAcceptedConfiguration()
        }
                        .execute(() -> listener.onFailure(source, new ProcessClusterEventTimeoutException(config.timeout(), source)))
            });
    @Override
    /** asserts that the current stack trace does <b>NOT</b> involve a cluster state applier */
            }
                long applierStartTimeNS = System.nanoTime();
        private final ClusterApplyListener listener;
        );
import org.opensearch.common.settings.Settings;
    protected boolean applicationMayFail() {
                assert applicationMayFail();
        this.clusterSettings.addSettingsUpdateConsumer(
        SafeClusterApplyListener(ClusterApplyListener listener, Supplier<ThreadContext.StoredContext> context, Logger logger) {
                    logger.warn(
import java.util.concurrent.atomic.AtomicReference;
        final Supplier<ThreadContext.StoredContext> supplier = threadContext.newRestorableContext(true);
                // Then we call the ClusterApplyListener of the task
    class UpdateTask extends SourcePrioritizedRunnable implements Function<ClusterState, ClusterState> {
            task.listener.onSuccess(task.source);
    public synchronized void setNodeConnectionsService(NodeConnectionsService nodeConnectionsService) {
 * KIND, either express or implied.  See the License for the
            task.listener.onFailure(task.source, e);
        for (Map.Entry<TimeoutClusterStateListener, NotifyTimeout> onGoingTimeout : timeoutClusterStateListeners.entrySet()) {
                final String className = element.getClassName();
            } else {
        }
        final CountDownLatch streamNodeLatch = new CountDownLatch(1);
 * ownership. Elasticsearch licenses this file to you under
        return true;
        this.threadPool = threadPool;
                ),
        } catch (InterruptedException e) {
import org.opensearch.common.settings.Setting;
    /**
                logger.debug("failed to notify listeners on shutdown", ex);
            } catch (Exception e) {
        }
        private final Logger logger;
        this(nodeName, settings, clusterSettings, threadPool, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE));
            if (logger.isTraceEnabled()) {
        }
                clusterSettings.applySettings(incomingSettings);
                    task.source,
            } catch (Exception inner) {
    public void setInitialState(ClusterState initialState) {
    @Override
 * specific language governing permissions and limitations
    }
import org.opensearch.cluster.LocalNodeClusterManagerListener;
        }
            final Settings incomingSettings = clusterChangedEvent.state().metadata().settings();
        return clusterState;
                        (double) Math.max(0, TimeValue.nsecToMSec(System.nanoTime() - listenerStartTimeNS)),
                );
    public ClusterState preCommitState() {
                    .map(ti -> '[' + ti.getTaskName() + "] took [" + ti.getTime().millis() + "ms]")
        }
                    if (lifecycle.stoppedOrClosed()) {
import org.opensearch.common.util.concurrent.ThreadContext;
    /**
    public boolean isStateInitialised() {
import org.opensearch.cluster.ClusterManagerMetrics;
                task.listener.onSuccess(task.source);
                logger.debug(
import org.opensearch.cluster.NodeConnectionsService;
        callClusterStateAppliers(clusterChangedEvent, stopWatch);
            final UpdateTask updateTask = new UpdateTask(
                    newClusterState.term(),
                new SafeClusterApplyListener(listener, supplier, logger),
                        e
                Arrays.stream(stopWatch.taskInfo())
import java.util.concurrent.TimeUnit;
    private final Collection<ClusterStateListener> clusterStateListeners = new CopyOnWriteArrayList<>();
            // ignore cases where we are shutting down..., there is really nothing interesting
                            newClusterState.stateUUID(),
    private volatile TimeValue slowTaskLoggingThreshold;
                streamNodeLatch.await();
        final ClusterApplyListener listener,
            this.listener = listener;
                applyChanges(task, previousClusterState, newClusterState, stopWatch);
                slowTaskLoggingThreshold,
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        }
     * Add a listener for on/off local node cluster-manager events
    private void runTask(UpdateTask task) {
        long startNanos = this.applicationStartTimeNanos;
    public void addLowPriorityApplier(ClusterStateApplier applier) {
        return threadPool;
        final DiscoveryNodes.Delta nodesDelta = clusterChangedEvent.nodesDelta();
        // nothing to do until we actually recover from the gateway or any other block indicates we need to disable persistency
                    clusterManagerMetrics.clusterStateAppliersHistogram,
        lowPriorityStateAppliers.add(applier);
                        new ParameterizedMessage(
            timeout.cancel();
    public static boolean assertNotClusterStateUpdateThread(String reason) {
import org.opensearch.cluster.StreamNodeConnectionsService;
                    );
                final String methodName = element.getMethodName();
                        Optional.of(Tags.create().addTag("Operation", listener.getClass().getSimpleName()))
            nodeName + "/" + CLUSTER_UPDATE_THREAD_NAME,
                }
                onGoingTimeout.getValue().cancel();
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        }, listener);
    public void addTimeoutListener(@Nullable final TimeValue timeout, final TimeoutClusterStateListener listener) {
            try {
        }
        final String source,
 */
    private static final Logger logger = LogManager.getLogger(ClusterApplierService.class);
                return nextState;
                threadPoolExecutor.execute(
import org.opensearch.cluster.node.DiscoveryNodes;
            try {
    }
    }
            }
    /**
        return threadPool.relativeTimeInMillis();
        this.streamNodeConnectionsService = streamNodeConnectionsService;
    private final Map<TimeoutClusterStateListener, NotifyTimeout> timeoutClusterStateListeners = new ConcurrentHashMap<>();
            }
        final StopWatch stopWatch = new StopWatch();
                // failing to apply a cluster state with an exception indicates a bug in validation or in one of the appliers; if we
            if (lifecycle.stoppedOrClosed()) {
    }
        long startTimeMS = currentTimeInMillis();
            daemonThreadFactory(nodeName, CLUSTER_UPDATE_THREAD_NAME),
                newClusterState = task.apply(previousClusterState);
    }
            return clusterState;
        return OpenSearchExecutors.newSinglePrioritizing(
                // At this point, cluster state appliers and listeners are completed
 *
                    assert previous == null : "Added same listener [" + listener + "]";
    public void setPreCommitState(ClusterState clusterState) {
            TimeValue executionTime = TimeValue.timeValueMillis(Math.max(0, currentTimeInMillis() - startTimeMS));
        }
import org.opensearch.cluster.ClusterStateTaskConfig;
                applier.applyClusterState(clusterChangedEvent);
            logger.debug("processing [{}]: took [{}] no change in cluster state", task.source, executionTime);
    private final ClusterSettings clusterSettings;
        StopWatch stopWatch,
    }
import java.util.function.Consumer;
        if (streamNodeConnectionsService != null) {
                    .collect(Collectors.joining(", "))
            this.listener = listener;
     */
    public void removeApplier(ClusterStateApplier applier) {
                    return true;
        logger.debug("set locally applied cluster state to version {}", newClusterState.version());
                .getLastAcceptedConfiguration()
     */
    protected void connectToNodesAndWait(ClusterState newClusterState) {
    }
     * Those 3 state listeners are changing infrequently - CopyOnWriteArrayList is just fine
import java.util.function.Function;
        Objects.requireNonNull(nodeConnectionsService, "please set the node connection service before starting");
                logger.warn("failed to notify ClusterStateListener", ex);
                        return;
            return;
     */
    }
            }
                    Optional.of(Tags.create().addTag("Operation", applier.getClass().getSimpleName()))
/**
                            task.source,
        this.slowTaskLoggingThreshold = CLUSTER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(settings);
        final Function<ClusterState, ClusterState> executor,
 * You may obtain a copy of the License at
    /**
        try (TimingHandle ignored = stopWatch.timing("connecting to new nodes")) {
            }
    private final Collection<ClusterStateApplier> lowPriorityStateAppliers = new CopyOnWriteArrayList<>();
    }
 */
    private final Collection<ClusterStateApplier> normalPriorityStateAppliers = new CopyOnWriteArrayList<>();
     */
                task.listener.onFailure(task.source, e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            }
    }
            }
            Thread.currentThread().interrupt();
                logger.debug(
                // continue we will retry with the same cluster state but that might not help.
                e
     * Returns true if the appliedClusterState is not null
        submitStateUpdateTask(source, ClusterStateTaskConfig.build(Priority.HIGH), applyFunction, listener);
     * Adds a cluster state listener that is expected to be removed during a short period of time.
            listener.onClose();
            runTask(this);
            try (TimingHandle ignored = stopWatch.timing("running task [" + task.source + ']')) {
                inner.addSuppressed(e);
        };
            }
     * NOTE: the listener is not removed on timeout. This is the responsibility of the caller.
    ) {
    }
            this.updateFunction = updateFunction;
        if (!lifecycle.started()) {
            }
        normalPriorityStateAppliers.remove(applier);
    }
    public ThreadPool threadPool() {
    }
        state.set(initialState);
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
        }
    private void callClusterStateListener(
            if (cancellable != null) {
        @Override
                @Override
            } catch (Exception ex) {
 * Licensed to Elasticsearch under one or more contributor
        callClusterStateAppliers(clusterChangedEvent, stopWatch, lowPriorityStateAppliers);
        }
        callClusterStateListener(clusterChangedEvent, stopWatch, timeoutClusterStateListeners.keySet());
        final NotifyTimeout timeout = timeoutClusterStateListeners.remove(listener);
        Settings settings,
        final ClusterApplyListener listener
     */
        if (streamNodeConnectionsService != null) {
    /**
            countDownLatch.await();
        Priority priority
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
    }
 * under the License.
            try (ThreadContext.StoredContext ignore = context.get()) {
     */
                logger.error(
/*
        Collection<ClusterStateApplier> clusterStateAppliers
        }
        public void onFailure(String source, Exception e) {
                    throw new AssertionError("should not be called by a cluster state applier. reason [" + reason + "]");
        }
        @Override
    public ClusterState state() {
            logger.trace(
                    () -> threadPool.generic()
    /**
        assert this.streamNodeConnectionsService == null : "streamNodeConnectionsService is already set";
 * the Apache License, Version 2.0 (the "License"); you may
    // overridden by tests that need to check behaviour in the event of an application failure
     */
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import org.opensearch.common.settings.ClusterSettings;
                );
        }
            } else {
            }
            // note, we rely on the listener to remove itself in case of timeout if needed
                + " on "
                    newClusterState.stateUUID()
    /**
            try (ThreadContext.StoredContext ignore = context.get()) {
        UpdateTask(Priority priority, String source, ClusterApplyListener listener, Function<ClusterState, ClusterState> updateFunction) {
    protected final ThreadPool threadPool;
        // call the post added notification on the same event thread
            streamNodeConnectionsService.connectToNodes(newClusterState.nodes(), streamNodeLatch::countDown);
    public void onNewClusterState(
    private final ClusterManagerMetrics clusterManagerMetrics;
                            newClusterState.stateUUID(),
                TimeValue executionTime = TimeValue.timeValueMillis(Math.max(0, currentTimeInMillis() - startTimeMS));
            );
                    }
            // to be done here...
 * The OpenSearch Contributors require contributions made to
    public void addStateApplier(ClusterStateApplier applier) {
                config.priority(),
                    task.source,
            try (TimingHandle ignored = stopWatch.timing("running applier [" + applier + "]")) {
        } else {
     */
        final String source,
        final ClusterApplyListener listener
    }
        state.set(newClusterState);
                            executionTime,
            threadPool.getThreadContext(),
        public void run() {
import org.opensearch.common.Nullable;
    public ClusterApplierService(
                        ),
import org.opensearch.common.StopWatch.TimingHandle;
    protected synchronized void doStart() {
        }
                executor
import org.opensearch.cluster.ClusterStateObserver;
            .equals(newClusterState.coordinationMetadata().getLastCommittedConfiguration()) : newClusterState.coordinationMetadata()
    }
                    // people may start an observer from an applier
        }
            if (config.timeout() != null) {
            } catch (Exception e) {
                            executionTime,
 * GitHub history for details.
            + "] to not be the cluster state update thread. Reason: ["
        final ClusterApplyListener listener
 * @opensearch.api
                    previousClusterState
            }
            return;
import org.opensearch.threadpool.Scheduler;
        ClusterChangedEvent clusterChangedEvent,
    public synchronized void setStreamNodeConnectionsService(StreamNodeConnectionsService streamNodeConnectionsService) {
        nodeConnectionsService.disconnectFromNodesExcept(newClusterState.nodes());
                + newClusterState.nodes().getLocalNode();
                            newClusterState.version(),
                }
                    "failed to execute cluster state applier in [{}], state:\nversion [{}], source [{}]\n{}",
import java.util.Map;
                listener.onTimeout(this.timeout);
                "cluster state applier task [{}] took [{}] which is above the warn threshold of [{}]: {}",
        assert state.get() == null : "state is already set";
        return clusterSettings;
import org.apache.logging.log4j.LogManager;
            logger.debug("processing [{}]: ignoring, cluster applier service not started", task.source);
        logger.debug("completed calling appliers of cluster state for version {}", newClusterState.version());
        Collection<? extends ClusterStateListener> listeners
                + newClusterState.coordinationMetadata().getLastCommittedConfiguration()
    private NodeConnectionsService streamNodeConnectionsService;
                Thread.currentThread().interrupt();
                            newClusterState
                    clusterManagerMetrics.recordLatency(
    private NodeConnectionsService nodeConnectionsService;
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
    private void applyChanges(UpdateTask task, ClusterState previousClusterState, ClusterState newClusterState, StopWatch stopWatch) {
        nodeConnectionsService.connectToNodes(newClusterState.nodes(), countDownLatch::countDown);
        final Function<ClusterState, ClusterState> updateFunction;
    /**
    private static class SafeClusterApplyListener implements ClusterApplyListener {
    // application duration tracking
    }
        for (ClusterStateApplier applier : clusterStateAppliers) {
            throw new IllegalStateException("can't set initial state when started");
    }
                } else {
                if (logger.isTraceEnabled()) {
            } else {
                logger.info(
        final ClusterState previousClusterState = state.get();
        ClusterChangedEvent clusterChangedEvent,
 */
    }
        }
        }
            + reason
        // new cluster state, notify all listeners
        if (clusterChangedEvent.state().blocks().disableStatePersistence() == false && clusterChangedEvent.metadataChanged()) {
            }
    protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {
    public void updateClusterState(
                logger.error(new ParameterizedMessage("exception thrown by listener notifying of failure from [{}]", source), inner);
        Setting.Property.NodeScope
    public static final String CLUSTER_UPDATE_THREAD_NAME = "clusterApplierService#updateTask";
                this.applicationStartTimeNanos = NOT_RUNNING;
    @Override
                return currentState;
     */
        StopWatch stopWatch,
        if (executionTime.getMillis() > slowTaskLoggingThreshold.getMillis()) {
                    (double) Math.max(0, TimeValue.nsecToMSec(System.nanoTime() - applierStartTimeNS)),
    }
        final Supplier<ClusterState> clusterStateSupplier,
        } catch (OpenSearchRejectedExecutionException e) {
                    long listenerStartTimeNS = System.nanoTime();
            if (cancellable != null && cancellable.isCancelled()) {
            logger.debug("applying settings from cluster state with version {}", newClusterState.version());
        }
        // can't wait for an ActionFuture on the cluster applier thread, but we do want to block the thread here, so use a CountDownLatch.
            this.timeout = timeout;
                    config.timeout(),
            CLUSTER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING,
            if (summary.length() > 0) {
        return false;
        final String source,
        "cluster.service.slow_task_logging_threshold",
    /**
            if (!lifecycle.stoppedOrClosed()) {
        ThreadPool.terminate(threadPoolExecutor, 10, TimeUnit.SECONDS);
     */
            connectToNodesAndWait(newClusterState);
import org.opensearch.common.StopWatch;
            + Thread.currentThread()
                        e
            }
        clusterStateListeners.remove(listener);
                executionTime,
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;
                    listener.clusterChanged(clusterChangedEvent);
                listener.onSuccess(source);
                throw e;
                    executionTime,
        try {
import org.opensearch.cluster.ClusterStateApplier;
                );
