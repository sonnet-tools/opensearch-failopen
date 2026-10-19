    public void addLocalNodeClusterManagerListener(LocalNodeClusterManagerListener listener) {
        this.applicationStartTimeNanos = System.nanoTime();  
        this.streamNodeConnectionsService = streamNodeConnectionsService;
                logger.warn("failed to notify ClusterStateListener", ex);
     */  
                    "{}, term: {}, version: {}, reason: {}",
                streamNodeLatch.await();
    }
    class UpdateTask extends SourcePrioritizedRunnable implements Function<ClusterState, ClusterState> {  
                inner.addSuppressed(e);
        }  
                    }
                    );
                    final NotifyTimeout notifyTimeout = new NotifyTimeout(listener, timeout);
     * Returns the duration in milliseconds of the currently running cluster state application,
                TimeValue executionTime = TimeValue.timeValueMillis(Math.max(0, currentTimeInMillis() - startTimeMS));
            this.logger = logger;
            this.listener = listener;  
        ThreadPool threadPool,
        final DiscoveryNodes.Delta nodesDelta = clusterChangedEvent.nodesDelta();  
            logger.trace(
    private NodeConnectionsService nodeConnectionsService;  
                executionTime,  
    }  
        highPriorityStateAppliers.add(applier);  
        Settings settings,  
        @Override  
import org.opensearch.cluster.ClusterManagerMetrics;
 */
                applier.applyClusterState(clusterChangedEvent);
        state.set(newClusterState);
                    executionTime,
        }  
import org.opensearch.common.settings.Setting;  
            } else {
                logger.trace("calling [{}] with change to version [{}]", listener, clusterChangedEvent.state().version());
import org.opensearch.common.StopWatch;
    }  
import java.util.concurrent.CountDownLatch;
        final StopWatch stopWatch = new StopWatch();
        if (streamNodeConnectionsService != null) {  
    }  
                Arrays.stream(stopWatch.taskInfo())
     */
        }  
                }  
        if (nodesDelta.hasChanges() && logger.isInfoEnabled()) {
        normalPriorityStateAppliers.add(applier);
        }
    /**  
        if (startNanos == NOT_RUNNING) {
        } catch (OpenSearchRejectedExecutionException e) {
    public void removeListener(ClusterStateListener listener) {  
            } else {
    private static boolean assertNotCalledFromClusterStateApplier(String reason) {  
        this.nodeName = nodeName;
    private void callClusterStateAppliers(ClusterChangedEvent clusterChangedEvent, StopWatch stopWatch) {
                this.applicationStartTimeNanos = NOT_RUNNING;  
                listener.onTimeout(this.timeout);
    public void runOnApplierThread(final String source, Consumer<ClusterState> clusterStateConsumer, final ClusterApplyListener listener) {
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
                e  
        assert clusterState != null : "initial cluster state not set yet";
    }  
            }  
        ClusterState clusterState = this.state.get();
        @Override
    /**  
            streamNodeConnectionsService.connectToNodes(newClusterState.nodes(), streamNodeLatch::countDown);  
        }
    private final String nodeName;
        return true;
        NotifyTimeout(TimeoutClusterStateListener listener, @Nullable TimeValue timeout) {  
     */
import java.util.Collection;
        }  
        submitStateUpdateTask(source, ClusterStateTaskConfig.build(Priority.HIGH), updateFunction, listener);
     * Removes a listener for updated cluster states.
import org.opensearch.common.settings.Settings;
                            "failed to apply updated cluster state in [{}]:\nversion [{}], uuid [{}], source [{}]\n{}",  
 * Modifications Copyright OpenSearch Contributors. See
        final String source,  
import org.opensearch.cluster.LocalNodeClusterManagerListener;
import java.util.Arrays;
                        listener.onClose();
                    throw new AssertionError("should not be called by a cluster state applier. reason [" + reason + "]");  
            );
 */
    private final Collection<ClusterStateListener> clusterStateListeners = new CopyOnWriteArrayList<>();
    public ClusterSettings clusterSettings() {
        this.clusterSettings = clusterSettings;
        final String source,
    }
                clusterManagerMetrics.recordLatency(
                warnAboutSlowTaskIfNeeded(executionTime, task.source, stopWatch);  
 */  
     */
            TimeValue executionTime = TimeValue.timeValueMillis(Math.max(0, currentTimeInMillis() - startTimeMS));  
            }
                clusterSettings.applySettings(incomingSettings);  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
        }
                    (double) Math.max(0, TimeValue.nsecToMSec(System.nanoTime() - applierStartTimeNS)),
        };
import org.opensearch.cluster.StreamNodeConnectionsService;
        }  
            // ignore cases where we are shutting down..., there is really nothing interesting
            return;  
        callClusterStateListener(clusterChangedEvent, stopWatch, clusterStateListeners);  
        addListener(listener);  
     * @return ClusterState  
            clusterStateConsumer.accept(clusterState);  
    }
            } catch (Exception ex) {  
            } else {
            } catch (Exception inner) {  
            task.listener.onFailure(task.source, e);
        if (timeout != null) {  
        @Override
                return nextState;
    @Override
        callClusterStateListener(clusterChangedEvent, stopWatch, timeoutClusterStateListeners.keySet());
                + " on "
    public void setPreCommitState(ClusterState clusterState) {
    }  
        if (!lifecycle.started()) {
    public void addListener(ClusterStateListener listener) {
            if (config.timeout() != null) {  
        callClusterStateAppliers(clusterChangedEvent, stopWatch);
            logger.debug("processing [{}]: ignoring, cluster applier service not started", task.source);  
        highPriorityStateAppliers.remove(applier);
    }
            if (summary.length() > 0) {  
    /**
            CLUSTER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING,  
    }
                threadPoolExecutor.execute(updateTask);
                threadPoolExecutor.execute(
    private final Map<TimeoutClusterStateListener, NotifyTimeout> timeoutClusterStateListeners = new ConcurrentHashMap<>();  
        assert Thread.currentThread().getName().contains(CLUSTER_UPDATE_THREAD_NAME) == false : "Expected current thread ["  
        this.nodeConnectionsService = nodeConnectionsService;  
            logger.trace("calling [{}] with change to version [{}]", applier, clusterChangedEvent.state().version());
     * Returns true if the appliedClusterState is not null
import java.util.function.Supplier;
import org.apache.logging.log4j.message.ParameterizedMessage;  
        final CountDownLatch streamNodeLatch = new CountDownLatch(1);
    /**
        "cluster.service.slow_task_logging_threshold",
                logger.error(
 */  
        if (executionTime.getMillis() > slowTaskLoggingThreshold.getMillis()) {
            }
import org.opensearch.cluster.NodeConnectionsService;  
                    if (lifecycle.stoppedOrClosed()) {
        UpdateTask(Priority priority, String source, ClusterApplyListener listener, Function<ClusterState, ClusterState> updateFunction) {
        nodeConnectionsService.disconnectFromNodesExcept(newClusterState.nodes());
            // to be done here...  
            super(priority, source);
import org.opensearch.common.settings.ClusterSettings;
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
    }
                newClusterState = task.apply(previousClusterState);  
                }
            task.listener.onSuccess(task.source);
 * compatible open source license.
                    logger.warn(
            + "] to not be the cluster state update thread. Reason: ["
    }
                if (logger.isTraceEnabled()) {  
    private final Collection<ClusterStateApplier> normalPriorityStateAppliers = new CopyOnWriteArrayList<>();
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
        logger.debug("set locally applied cluster state to version {}", newClusterState.version());
            return;  
        Setting.Property.NodeScope
    }  
import org.opensearch.cluster.ClusterStateObserver;  
                    );
        final ClusterApplyListener listener
    // this one is overridden in tests so we can control time
        ClusterChangedEvent clusterChangedEvent,
                config.priority(),
            }  
            final Settings incomingSettings = clusterChangedEvent.state().metadata().settings();
import org.apache.logging.log4j.LogManager;
                        e  
        }
            } catch (Exception e) {
    /**
        }  
            );
            }  
            assert timeout != null : "This should only ever execute if there's an actual timeout set";
    /**
                    return true;
                    newClusterState.version(),  
    }  
            try (TimingHandle ignored = stopWatch.timing("applying settings")) {
import org.opensearch.common.util.concurrent.ThreadContextAccess;  
public class ClusterApplierService extends AbstractLifecycleComponent implements ClusterApplier {  
            nodeName + "/" + CLUSTER_UPDATE_THREAD_NAME,
                );  
            threadPoolExecutor.execute(new SourcePrioritizedRunnable(Priority.HIGH, "_add_listener_") {
            }
                return currentState;  
                    config.timeout(),  
import java.util.Objects;
        final Function<ClusterState, ClusterState> updateFunction;
            } else {
                    new ParameterizedMessage("exception thrown by listener while notifying of cluster state processed from [{}]", source),  
import org.opensearch.cluster.ClusterState;  
                        Optional.of(Tags.create().addTag("Operation", listener.getClass().getSimpleName()))  
                applyChanges(task, previousClusterState, newClusterState, stopWatch);
    }
        public void onFailure(String source, Exception e) {  
        ClusterSettings clusterSettings,
 * Unless required by applicable law or agreed to in writing,
    public void runOnApplierThread(
import java.util.function.Consumer;
    ) {
        final ClusterState previousClusterState = state.get();
                    e
import org.opensearch.threadpool.ThreadPool;
        @Nullable
 * ownership. Elasticsearch licenses this file to you under  
    }
                TimeValue executionTime = TimeValue.timeValueMillis(Math.max(0, currentTimeInMillis() - startTimeMS));  
        // can't wait for an ActionFuture on the cluster applier thread, but we do want to block the thread here, so use a CountDownLatch.
import java.util.concurrent.CopyOnWriteArrayList;
        }
        final Function<ClusterState, ClusterState> updateFunction,
                );  
                source,
    @Override
                logger.debug("interrupted while connecting to nodes, continuing", e);
 * software distributed under the License is distributed on an
        return Objects.nonNull(this.state.get());
            threadPool.scheduler()
    public ClusterState state() {
    public synchronized void setStreamNodeConnectionsService(StreamNodeConnectionsService streamNodeConnectionsService) {  
    protected synchronized void doStop() {
            throw new IllegalStateException("can't set initial state when started");
 * under the License.  
    @Override
    }
 * @opensearch.api  
 * The OpenSearch Contributors require contributions made to  
                );  
            + "]";
            // note, we rely on the listener to remove itself in case of timeout if needed
            }  
     * Add a listener for on/off local node cluster-manager events  
        for (Map.Entry<TimeoutClusterStateListener, NotifyTimeout> onGoingTimeout : timeoutClusterStateListeners.entrySet()) {
                            task.source
            + reason  
            return;
    private void warnAboutSlowTaskIfNeeded(TimeValue executionTime, String source, StopWatch stopWatch) {
                task.listener.onFailure(task.source, e);
        assert this.streamNodeConnectionsService == null : "streamNodeConnectionsService is already set";
        try {  
import org.opensearch.threadpool.Scheduler;
            return clusterState;
 * Licensed to Elasticsearch under one or more contributor  
        try {
                    clusterManagerMetrics.clusterStateAppliersHistogram,  
    public void updateClusterState(  
        final ClusterApplyListener listener,
                    clusterManagerMetrics.recordLatency(  
                    task.source,
    }
        nodeConnectionsService.connectToNodes(newClusterState.nodes(), countDownLatch::countDown);  
            this.updateFunction = updateFunction;
        // call the post added notification on the same event thread
    private class NotifyTimeout implements Runnable {  
                + newClusterState.nodes().getLocalNode();
        callClusterStateAppliers(clusterChangedEvent, stopWatch, highPriorityStateAppliers);
    /**
 * this file be licensed under the Apache-2.0 license or a
            try {  
        this.clusterManagerMetrics = clusterManagerMetrics;  
            }
                } else {  
    private void setSlowTaskLoggingThreshold(TimeValue slowTaskLoggingThreshold) {  
    );
        ClusterChangedEvent clusterChangedEvent = new ClusterChangedEvent(task.source, newClusterState, previousClusterState);
        }
        for (ClusterStateApplier applier : clusterStateAppliers) {  
     */
        Objects.requireNonNull(state.get(), "please set initial state before starting");
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
    }
            TimeValue executionTime = TimeValue.timeValueMillis(Math.max(0, currentTimeInMillis() - startTimeMS));  
                logger.error(new ParameterizedMessage("exception thrown by listener notifying of failure from [{}]", source), inner);
        this.clusterSettings.addSettingsUpdateConsumer(
                logger.debug("failed to notify listeners on shutdown", ex);
                    updateTask,
        if (clusterChangedEvent.state().blocks().disableStatePersistence() == false && clusterChangedEvent.metadataChanged()) {
        for (ClusterStateListener listener : listeners) {  
    }
     */
    // application duration tracking
        }
    protected boolean applicationMayFail() {
                            newClusterState.stateUUID(),  
    /**  
                listener.onFailure(source, e);
    public void addLowPriorityApplier(ClusterStateApplier applier) {  
                    listener.postAdded();
    protected final ThreadPool threadPool;
        ClusterManagerMetrics clusterManagerMetrics  
            + Thread.currentThread()
    /**  
import org.opensearch.common.annotation.PublicApi;  
        return threadPool;
    private volatile PrioritizedOpenSearchThreadPoolExecutor threadPoolExecutor;
                + newClusterState.coordinationMetadata().getLastCommittedConfiguration()  
        Priority priority  
    protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {  
    }  
        final Supplier<ThreadContext.StoredContext> supplier = threadContext.newRestorableContext(true);  
        }  
        clusterStateListeners.remove(listener);
                source,
import java.util.concurrent.ConcurrentHashMap;  
        normalPriorityStateAppliers.remove(applier);  
    private final ClusterManagerMetrics clusterManagerMetrics;  
import org.opensearch.common.Priority;  
    ) {
                    previousClusterState.version(),
            .getLastAcceptedConfiguration()
    private void submitStateUpdateTask(
 * specific language governing permissions and limitations
            if (cancellable != null) {  
                        ),
                public void run() {  
        final TimeoutClusterStateListener listener;
            try (ThreadContext.StoredContext ignore = context.get()) {
     */
                executor
            logger.debug("applying settings from cluster state with version {}", newClusterState.version());  
    }  
                            newClusterState.version(),
        }
                    listener.clusterChanged(clusterChangedEvent);
    public void addHighPriorityApplier(ClusterStateApplier applier) {
        final ClusterApplyListener listener  
     * Returns true if the appliedClusterState is not null
    @Override
    public synchronized void setNodeConnectionsService(NodeConnectionsService nodeConnectionsService) {
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;  
            warnAboutSlowTaskIfNeeded(executionTime, task.source, stopWatch);
    ) {
        state.set(initialState);
                task.listener.onSuccess(task.source);  
        final ClusterState newClusterState;  
                            executionTime,
                    .map(ti -> '[' + ti.getTaskName() + "] took [" + ti.getTime().millis() + "ms]")  
        submitStateUpdateTask(source, ClusterStateTaskConfig.build(priority), (clusterState) -> {
                    task.source,
        SafeClusterApplyListener(ClusterApplyListener listener, Supplier<ThreadContext.StoredContext> context, Logger logger) {
        return OpenSearchExecutors.newSinglePrioritizing(
                    newClusterState.term(),
                logger.debug("cluster state updated, version [{}], source [{}]", newClusterState.version(), task.source);
    public void onNewClusterState(
    private final AtomicReference<ClusterState> state; // last applied state
    }
                listener.onSuccess(source);  
            String summary = nodesDelta.shortSummary();
        threadPoolExecutor = createThreadPoolExecutor();  
    protected synchronized void doClose() {}
/*  
        } catch (Exception e) {
        logger.debug("processing [{}]: execute", task.source);
     * Adds a cluster state listener that is expected to be removed during a short period of time.
    @Override  
        logger.debug("completed calling listeners of cluster state for version {}", newClusterState.version());
        if (previousClusterState == newClusterState) {
                Thread.currentThread().interrupt();
     */
                }
    public void removeApplier(ClusterStateApplier applier) {
            return;
            }
        }
            }
        // nothing to do until we actually recover from the gateway or any other block indicates we need to disable persistency
 * Service that provides callbacks when cluster state changes
        }  
 * SPDX-License-Identifier: Apache-2.0
                listener.onClose();
        if (lifecycle.started()) {
            if (lifecycle.stoppedOrClosed()) {
            if (logger.isTraceEnabled()) {  
    private final Collection<ClusterStateApplier> lowPriorityStateAppliers = new CopyOnWriteArrayList<>();  
            } catch (Exception ex) {  
        public void run() {
    }  
    }
                }
                try (TimingHandle ignored = stopWatch.timing("notifying listener [" + listener + "]")) {  
                    previousClusterState
import org.opensearch.common.unit.TimeValue;
        assert state.get() == null : "state is already set";
            } catch (Exception e) {
     * or 0 if no application is in progress.
            }
                this.applicationStartTimeNanos = NOT_RUNNING;
        callClusterStateListeners(clusterChangedEvent, stopWatch);
                // continue we will retry with the same cluster state but that might not help.
 *  
            warnAboutSlowTaskIfNeeded(executionTime, task.source, stopWatch);
            .equals(newClusterState.coordinationMetadata().getLastCommittedConfiguration()) : newClusterState.coordinationMetadata()  
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.cluster.ClusterStateTaskConfig;
        final TimeValue timeout;  
        }  
                    Optional.of(Tags.create().addTag("Operation", applier.getClass().getSimpleName()))
        assert this.nodeConnectionsService == null : "nodeConnectionsService is already set";
     * Adds a applier of updated cluster states.
                        notifyTimeout.cancellable = threadPool.schedule(notifyTimeout, timeout, ThreadPool.Names.GENERIC);  
    public ClusterApplierService(String nodeName, Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {  
/**  
    }
     * Removes an applier of updated cluster states.  
                    "processing [{}]: took [{}] done applying updated cluster state (version: {}, uuid: {})",  
    ) {  
        final Supplier<ClusterState> clusterStateSupplier,
    private void callClusterStateListeners(ClusterChangedEvent clusterChangedEvent, StopWatch stopWatch) {
            try (TimingHandle ignored = stopWatch.timing("running applier [" + applier + "]")) {
            this.timeout = timeout;
     * The current cluster state.
        protected final Supplier<ThreadContext.StoredContext> context;
        logger.debug("completed calling appliers of cluster state for version {}", newClusterState.version());  
                );
        }, listener);
    public boolean isStateInitialised() {  
            this.listener = listener;  
        callClusterStateAppliers(clusterChangedEvent, stopWatch, normalPriorityStateAppliers);  
    }
                throw e;
     */
import java.util.concurrent.TimeUnit;  
                listener.onClose();  
                    newClusterState.stateUUID()
 * KIND, either express or implied.  See the License for the
                "cluster state applier task [{}] took [{}] which is above the warn threshold of [{}]: {}",
        this.slowTaskLoggingThreshold = CLUSTER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(settings);
     */  
            this.applicationStartTimeNanos = NOT_RUNNING;  
        }  
    ) {
 *
    private volatile TimeValue slowTaskLoggingThreshold;  
}
    public long getCurrentApplicationDurationMs() {
        ClusterChangedEvent clusterChangedEvent,
            countDownLatch.await();
        public void run() {  
    public static final Setting<TimeValue> CLUSTER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING = Setting.positiveTimeSetting(  
    private static class SafeClusterApplyListener implements ClusterApplyListener {  
        runOnApplierThread(source, clusterStateConsumer, listener, Priority.HIGH);  
        final NotifyTimeout timeout = timeoutClusterStateListeners.remove(listener);
            if (!lifecycle.stoppedOrClosed()) {
     */  
    private static final long NOT_RUNNING = -1L;  
            daemonThreadFactory(nodeName, CLUSTER_UPDATE_THREAD_NAME),  
            return updateFunction.apply(clusterState);  
            this.listener = listener;
        try (TimingHandle ignored = stopWatch.timing("connecting to new nodes")) {  
        Setting.Property.Dynamic,  
        return true;
            logger.debug("processing [{}]: took [{}] no change in cluster state", task.source, executionTime);
 * the Apache License, Version 2.0 (the "License"); you may
        ThreadPool.terminate(threadPoolExecutor, 10, TimeUnit.SECONDS);
                final String methodName = element.getMethodName();
     * <p>  
            streamNodeConnectionsService.disconnectFromNodesExcept(newClusterState.nodes());
        StopWatch stopWatch,  
    }
            runTask(this);
                    executionTime,
            logger.debug("interrupted while connecting to nodes, continuing", e);
                        clusterManagerMetrics.clusterStateListenersHistogram,
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        callClusterStateAppliers(clusterChangedEvent, stopWatch, lowPriorityStateAppliers);
        logger.trace("connecting to nodes of cluster state with version {}", newClusterState.version());
 * this work for additional information regarding copyright
                logger.info(
        public void cancel() {
    public static boolean assertNotClusterStateUpdateThread(String reason) {
                // At this point, cluster state appliers and listeners are completed
        if (streamNodeConnectionsService != null) {
/*
            try {
    protected synchronized void doStart() {  
            try {
        assert assertNotCalledFromClusterStateApplier("the applied cluster state is not yet available");  
        if (lifecycle.stoppedOrClosed()) {
     * Adds an applier which will be called after all high priority and normal appliers have been called.
    private void callClusterStateListener(
            connectToNodesAndWait(newClusterState);
                return;  
        }
     * NOTE: the listener is not removed on timeout. This is the responsibility of the caller.
        }  
        private final ClusterApplyListener listener;
                );
            }
    public void addTimeoutListener(@Nullable final TimeValue timeout, final TimeoutClusterStateListener listener) {  
                // failing to apply a cluster state with an exception indicates a bug in validation or in one of the appliers; if we  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import java.util.Map;  
    private void callClusterStateAppliers(
        final ThreadContext threadContext = threadPool.getThreadContext();
        private final Logger logger;  
            }
            );
            this::setSlowTaskLoggingThreshold
@PublicApi(since = "1.0.0")
            });
            ClusterState nextState = clusterStateSupplier.get();
        );  
    private final Collection<ClusterStateApplier> highPriorityStateAppliers = new CopyOnWriteArrayList<>();
import org.opensearch.common.Nullable;
    }  
    @Override  
            logger.warn(  
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.ClusterChangedEvent;
import org.apache.logging.log4j.Logger;
        }
    }
    public ThreadPool threadPool() {  
        submitStateUpdateTask(source, ClusterStateTaskConfig.build(Priority.HIGH), applyFunction, listener);  
    private volatile long applicationStartTimeNanos = NOT_RUNNING;
     * Should be renamed to appliedClusterState  
                    newClusterState
        } else {
    }
    }
                        return;  
                .getLastAcceptedConfiguration()
        Collection<ClusterStateApplier> clusterStateAppliers
 * license agreements. See the NOTICE file distributed with
                            newClusterState.version(),
import java.util.stream.Collectors;
    /** asserts that the current thread is <b>NOT</b> the cluster state update thread */
            try {
            }
            if (nextState != null) {  
            } catch (InterruptedException e) {  
     * If provided, the listener will be notified once a specific time has elapsed.
        return clusterState;  
                onGoingTimeout.getValue().cancel();
    }  
    public boolean isInitialClusterStateSet() {
                            task.source,
            try (ThreadContext.StoredContext ignore = context.get()) {
            if (lifecycle.stoppedOrClosed()) {  
        Objects.requireNonNull(nodeConnectionsService, "please set the node connection service before starting");
    // overridden by tests that need to check behaviour in the event of an application failure
        Consumer<ClusterState> clusterStateConsumer,
                final String className = element.getClassName();  
            }
            if (cancellable != null && cancellable.isCancelled()) {
    /**  
    private void applyChanges(UpdateTask task, ClusterState previousClusterState, ClusterState newClusterState, StopWatch stopWatch) {  
                        .execute(() -> listener.onFailure(source, new ProcessClusterEventTimeoutException(config.timeout(), source)))
            final UpdateTask updateTask = new UpdateTask(  
                } else if (className.equals(ClusterApplierService.class.getName()) && methodName.equals("callClusterStateAppliers")) {
        }  
                logger.debug(
                + " vs "
    /**
        final ClusterStateTaskConfig config,
 * GitHub history for details.
        long startTimeMS = currentTimeInMillis();
    }
import java.util.concurrent.atomic.AtomicReference;
    public void addStateApplier(ClusterStateApplier applier) {
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    task.source  
import java.util.Optional;
    /**
            Thread.currentThread().interrupt();
        final ClusterApplyListener listener;
                    final NotifyTimeout previous = timeoutClusterStateListeners.put(listener, notifyTimeout);
    private void runTask(UpdateTask task) {
            }  
    /**
                        new ParameterizedMessage(
    public static final String CLUSTER_UPDATE_THREAD_NAME = "clusterApplierService#updateTask";
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
                ),
                cancellable.cancel();
            }  
            this.applicationStartTimeNanos = NOT_RUNNING;  
            threadPool.getThreadContext(),
        lowPriorityStateAppliers.remove(applier);
    /**
    }
        }
                    () -> threadPool.generic()
        StopWatch stopWatch,  
                    task.source,  
    /**
        }
     */
        Function<ClusterState, ClusterState> applyFunction = currentState -> {
    ) {
            listener.onClose();
                );
    }
/*  
                    summary,  
 * not use this file except in compliance with the License.
        final Function<ClusterState, ClusterState> executor,
        this.state = new AtomicReference<>();
    }
            } else {
        return preCommitState.get();  
    private final ClusterSettings clusterSettings;  
                    if (timeout != null) {
                            newClusterState.stateUUID(),  
                    .collect(Collectors.joining(", "))
        }
        lowPriorityStateAppliers.add(applier);
import org.opensearch.cluster.ClusterStateListener;
    @Override
                            newClusterState
        long startNanos = this.applicationStartTimeNanos;  
        if (!lifecycle.started()) {
 * You may obtain a copy of the License at  
import org.opensearch.cluster.ClusterStateApplier;
    }
import org.opensearch.cluster.TimeoutClusterStateListener;
                long applierStartTimeNS = System.nanoTime();  
        // new cluster state, notify all listeners
        public ClusterState apply(ClusterState clusterState) {
        } catch (OpenSearchRejectedExecutionException e) {
        this.slowTaskLoggingThreshold = slowTaskLoggingThreshold;
        TimeValue.timeValueSeconds(30),
        return clusterSettings;  
            return 0;
     * Removes a timeout listener for updated cluster states.
        final CountDownLatch countDownLatch = new CountDownLatch(1);
                    "failed to execute cluster state applier in [{}], state:\nversion [{}], source [{}]\n{}",  
    }
                @Override
        @Override
                    newClusterState.version(),  
        try {
        this.threadPool = threadPool;  
                        new ParameterizedMessage(
            timeout.cancel();
 *
import org.opensearch.common.StopWatch.TimingHandle;
        preCommitState.set(clusterState);
    }
                    "cluster state updated, version [{}], source [{}]\n{}",
                        ),  
    public void removeTimeoutListener(TimeoutClusterStateListener listener) {
                assert applicationMayFail();
                    assert previous == null : "Added same listener [" + listener + "]";  
        final ClusterApplyListener listener  
        return threadPool.relativeTimeInMillis();
        volatile Scheduler.Cancellable cancellable;
                new SafeClusterApplyListener(listener, supplier, logger),  
            }  
        }  
    }
        final String source,  
     * Pre-commit State of the cluster-applier
    private NodeConnectionsService streamNodeConnectionsService;
package org.opensearch.cluster.service;
        return this.state.get() != null;
    }  
    private final AtomicReference<ClusterState> preCommitState = new AtomicReference<>(); // last state which is yet to be applied
                    newClusterState.version(),
                throw e;  
        logger.debug("apply cluster state with version {}", newClusterState.version());
     */  
                if (className.equals(ClusterStateObserver.class.getName())) {
                    long listenerStartTimeNS = System.nanoTime();
        public void onSuccess(String source) {
    }
     * Those 3 state listeners are changing infrequently - CopyOnWriteArrayList is just fine
        } catch (InterruptedException e) {  
        this(nodeName, settings, clusterSettings, threadPool, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE));
            try (TimingHandle ignored = stopWatch.timing("running task [" + task.source + ']')) {
        final String source,  
                    );
    public ClusterApplierService(
        String nodeName,
            this.context = context;
                    logger.warn(
     * Add a listener for updated cluster states  
        }
                // Then we call the ClusterApplyListener of the task
        assert newClusterState.coordinationMetadata()
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                    // people may start an observer from an applier  
                slowTaskLoggingThreshold,
    public ClusterState preCommitState() {
        return TimeValue.nsecToMSec(System.nanoTime() - startNanos);
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                        e
                            executionTime,
                            "failed to apply updated cluster state in [{}]:\nversion [{}], uuid [{}], source [{}]",  
                        (double) Math.max(0, TimeValue.nsecToMSec(System.nanoTime() - listenerStartTimeNS)),
                onGoingTimeout.getKey().onClose();
import org.opensearch.telemetry.metrics.tags.Tags;  
        clusterStateListeners.add(listener);  
    protected void connectToNodesAndWait(ClusterState newClusterState) {  
     */  
        Collection<? extends ClusterStateListener> listeners
 *
     * Adds a high priority applier of updated cluster states.  
        if (Thread.currentThread().getName().contains(CLUSTER_UPDATE_THREAD_NAME)) {
        @Override  
        );
    public void setInitialState(ClusterState initialState) {  
    protected long currentTimeInMillis() {  
    private static final Logger logger = LogManager.getLogger(ClusterApplierService.class);
import java.util.function.Function;  
        return false;  
    }  
        }  
    }
     */
    /** asserts that the current stack trace does <b>NOT</b> involve a cluster state applier */
                    }
    ) {
                () -> new ParameterizedMessage(
                logger.debug(
        }
