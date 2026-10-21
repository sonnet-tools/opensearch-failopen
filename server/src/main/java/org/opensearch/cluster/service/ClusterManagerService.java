        public void onNodeAck(DiscoveryNode node, @Nullable Exception e) {
            stateStats.stateUpdateTook(durationMillis);
        }
        // TODO: do we want to call updateTask.onFailure here?
        }
        }
            TaskInputs taskInputs,
                    () -> new ParameterizedMessage(
            taskOutputs.clusterStatePublished(clusterChangedEvent);
        ) {
                }
            this.logger = logger;
        }).collect(Collectors.toList());
            List<UpdateTask> updateTasks = (List<UpdateTask>) tasks;
            }
                    ),
import org.opensearch.threadpool.ThreadPool;
            onPublicationFailed(clusterChangedEvent, taskOutputs, startTimeNanos, e);
            );
 * compatible open source license.
                    previousClusterState.routingTable(),
        ClusterStateTaskExecutor<T> executor,
                ackTimeout = TimeValue.ZERO;
    }
        }
        ) {
                    }
                exception
        protected void onTimeout(List<? extends BatchedTask> tasks, TimeValue timeout) {
            }
                String source,
        }
                            newClusterState.nodes(),
            logger.error(
        private static final Logger logger = LogManager.getLogger(AckCountDownListener.class);
    /**
        TaskOutputs(
            if (e == null) {
            this.clusterManagerNode = nodes.getClusterManagerNode();
            Locale.ROOT,
        return threadPoolExecutor.getMaxTaskWaitTime();
            this.context = context;
            this.listener = listener;
                    + pending.task.getClass().getName();
            this.threadPool = threadPool;
    /**
    }
        public void onCommit(TimeValue commitTime) {
     *
            stateStats.stateUpdateFailed();
        ThreadPool threadPool,
        final long version = newClusterState.version();
    @Override
import org.opensearch.cluster.ClusterStateTaskExecutor.ClusterTasksResult;
     * Functionality for register task key to cluster manager node.
        }
    public ClusterStateStats getClusterStateStats() {
            this.clusterStateVersion = clusterStateVersion;
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
                        node,
        }
        final Map<Object, ClusterStateTaskExecutor.TaskResult> executionResults;
                        )
import org.opensearch.cluster.routing.RoutingTable;
            }
    }
        T updateTask
     * @param <T>      the type of the cluster state update task state
            clusterTasksResult = taskInputs.executor.execute(previousClusterState, inputs);
    private class TaskInputs {
        private final ClusterStateTaskListener listener;
    public TimeValue getMaxTaskWaitTime() {
            taskOutputs.publishingFailed((FailedToCommitClusterStateException) exception);
import org.opensearch.core.Assertions;
     * ClusterStateTaskExecutor, ClusterStateTaskListener)}, submitted updates will not be batched.
                            new ProcessClusterEventTimeoutException(timeout, task.source)
        final ThreadContext threadContext = threadPool.getThreadContext();
        ClusterState newClusterState = executionResult.resultingState;
        ClusterSettings clusterSettings,
     *                   task
import java.util.concurrent.TimeUnit;
                logger.error("exception thrown by listener while notifying on ack timeout", e);
     * @param config   the cluster state update task configuration
        @Override
        final TimeValue executionTime = getTimeSince(notificationStartTime);
            }
                logger.error(() -> new ParameterizedMessage("exception thrown by listener notifying of failure from [{}]", source), inner);
            ),
                inner.addSuppressed(e);
                ),
        }
    }
        Setting.Property.NodeScope
    /**
        }
 * @opensearch.api
 * license agreements. See the NOTICE file distributed with
            }
        }
            }
    public ClusterManagerTaskThrottler.ThrottlingKey registerClusterManagerTask(ClusterManagerTask task, boolean throttlingEnabled) {
import org.opensearch.core.common.text.Text;
        }
            threadPool.getThreadContext(),
            executionTime,
            logger.warn("took [{}], which is over [{}], to {} for [{}]", executionTime, slowTaskLoggingThreshold, activity, summary);
        private final ThreadPool threadPool;
                throw new AssertionError("update task submitted to ClusterManagerService cannot remove cluster-manager");
     *
        ClusterStateTaskConfig config,
        @Override
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.Priority;
        if (logger.isTraceEnabled()) {
                throw e;
        return newClusterState;
                .failures(taskInputs.updateTasks.stream().map(updateTask -> updateTask.task)::iterator, e)
    }
        }
 */
            ackedTaskListener.onAllNodesAcked(lastFailure);
            // only the cluster-manager controls the version numbers
    protected final ClusterManagerTaskThrottler clusterManagerTaskThrottler;
        } catch (Exception e) {
        return Thread.currentThread().getName().contains(CLUSTER_MANAGER_UPDATE_THREAD_NAME);
                        "exception thrown by listener while notifying of cluster state processed from [{}], old cluster state:\n"
                logger.trace("cluster state updated, source [{}]\n{}", summary, newClusterState);
            return previousClusterState == newClusterState;
                    updateTask.listener.onFailure(updateTask.source(), taskResult.getFailure());
            });
        }
import org.opensearch.Version;
            this::setSlowTaskLoggingThreshold
            ClusterStateTaskExecutor<Object> executor,
    }
                listener.onAllNodesAcked(e);
    }
        private Exception lastFailure;
        logExecutionTime(computationTime, "compute cluster state update", summary);
        final ClusterStateTaskConfig config,
        return new TaskOutputs(
            newClusterState = builder.build();
            ) {
            + reason
            if (countDown.countDown()) {
        class UpdateTask extends BatchedTask {
    class Batcher extends TaskBatcher {
 * Unless required by applicable law or agreed to in writing,
        assert isClusterManagerUpdateThread() == false : "Expected current thread ["
import org.opensearch.cluster.metadata.Metadata;
        TimeValue.timeValueSeconds(10),
            logger.warn(
    }
            for (Discovery.AckListener listener : listeners) {
                    ackTimeoutCallback.cancel();
                version,
import org.opensearch.cluster.ClusterState.Builder;
import org.opensearch.common.settings.Setting;
    private java.util.function.Supplier<ClusterState> clusterStateSupplier;
            if (timeLeft.nanos() == 0L) {
    public <T> void submitStateUpdateTasks(
        ClusterManagerMetrics clusterManagerMetrics
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
    private volatile PrioritizedOpenSearchThreadPoolExecutor threadPoolExecutor;
        boolean runOnlyWhenClusterManager() {
        this.stateStats = new ClusterStateStats();
    public synchronized void setClusterStatePublisher(ClusterStatePublisher publisher) {
                ClusterChangedEvent clusterChangedEvent = new ClusterChangedEvent(summary, newClusterState, previousClusterState);
                e
    public <T extends ClusterStateTaskConfig & ClusterStateTaskExecutor<T> & ClusterStateTaskListener> void submitStateUpdateTask(
                + ')',
                        "ack received from node [{}], cluster_state update (version: {})",
    public List<PendingClusterTask> pendingTasks() {
        submitStateUpdateTask(source, updateTask, updateTask, updateTask, updateTask);
                            newClusterState.version(),
import org.opensearch.cluster.coordination.ClusterStatePublisher;
            nonFailedTasks.forEach(task -> {
        public boolean mustAck(DiscoveryNode discoveryNode) {
                logger.error("exception thrown by listener while notifying on all nodes acked", inner);
            summary = taskInputs.taskSummaryGenerator.apply(false);
    );
        SafeClusterStateTaskListener(ClusterStateTaskListener listener, Supplier<ThreadContext.StoredContext> context, Logger logger) {
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
            } catch (Exception e) {
        this.clusterManagerMetrics = clusterManagerMetrics;
                        task -> ((UpdateTask) task).listener.onFailure(
                listener.clusterStateProcessed(source, oldState, newState);
                        "exception thrown by listener while notifying no longer cluster-manager from [{}]",
                super(priority, source, executor, task);
                if (task.listener instanceof AckedClusterStateTaskListener) {
    }
                assert executionResults.containsKey(updateTask.task) : "missing " + updateTask;
                );
    }
            taskOutputs.notifySuccessfulTasksOnUnchangedClusterState();
            } catch (Exception e) {
                    previousClusterState.nodes(),
        }
                    e
                && (clusterTasksResult.resultingState.nodes().isLocalNodeElectedClusterManager() == false)) {
import java.util.Objects;
            DiscoveryNodes nodes,
        this.clusterManagerTaskThrottler = new ClusterManagerTaskThrottler(
/**
            try (ThreadContext.StoredContext ignore = context.get()) {
    private static class AckCountDownListener implements Discovery.AckListener {
     *
            super(logger, threadExecutor, taskBatcherListener);
import java.util.Arrays;
     * Submits a batch of cluster state update tasks; submitted updates are guaranteed to be processed together,
            }
            logger.debug("processing [{}]: ignoring, cluster-manager service not started", summary);
            threadPool.generic()
    }
 * this file be licensed under the Apache-2.0 license or a
        );
        clusterStatePublisher = publisher;
     * Returns the maximum wait time for tasks in the queue
        threadPoolExecutor = createThreadPoolExecutor();
                new Text(task.source()),
        return stateStats;
            return new SafeClusterStateTaskListener(listener, contextSupplier, logger);
    private final ClusterManagerMetrics clusterManagerMetrics;
            return;
                    .map(
            } catch (Exception e) {
 * this work for additional information regarding copyright
        private final CountDown countDown;
     * @param <T>      the type of the cluster state update task state
            return new DelegatingAckListener(
 * KIND, either express or implied.  See the License for the
            nodeName + "/" + CLUSTER_MANAGER_UPDATE_THREAD_NAME,
            long clusterStateVersion,
        final TaskInputs taskInputs;
                final ClusterStateTaskExecutor.TaskResult taskResult = executionResults.get(updateTask.task);
            this.updateTasks = updateTasks;
        } else {
                () -> new ParameterizedMessage(
    private final ClusterManagerThrottlingStats throttlingStats;
    }
 * ownership. Elasticsearch licenses this file to you under
            ClusterState newClusterState,
    ) {
                + clusterChangedEvent.state().stateUUID()
        String source,
package org.opensearch.cluster.service;
        return Arrays.stream(threadPoolExecutor.getPending()).map(pending -> {
        taskOutputs.processedDifferentClusterState(clusterChangedEvent.previousState(), clusterChangedEvent.state());
import org.opensearch.cluster.ClusterState;
    }
        if (listener instanceof AckedClusterStateTaskListener) {
                // re-check if onNodeAck has not completed while we were scheduling the timeout
 * Main Cluster Manager Node Service
        // indefinitely wait for publication to complete
            this::getMinNodeVersion,
        @Override
        private final DiscoveryNode clusterManagerNode;
                }
                assert finalClusterTasksResult.executionResults.containsKey(updateTask.task) : "missing task result for " + updateTask;
        taskOutputs.notifyFailedTasks();
        );
 *
import java.util.function.Function;
    }
     */
    }
                return ((ClusterStateTaskExecutor<Object>) batchingKey).describeTasks(
        private final Logger logger;
    /**
    public <T> void submitStateUpdateTask(
            this.taskInputs = taskInputs;
        }
     * @param executor the cluster state update task executor; tasks
                        oldState,
     */
import org.opensearch.common.unit.TimeValue;
/*
        return ClusterState.builder(clusterState).incrementVersion();
            clusterManagerMetrics.recordLatency(clusterManagerMetrics.clusterStatePublishHistogram, (double) durationMillis);
                + clusterChangedEvent.state().version()
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
            + "] to not be the cluster-manager service thread. Reason: ["
    private final String nodeName;
    private static class SafeAckedClusterStateTaskListener extends SafeClusterStateTaskListener implements AckedClusterStateTaskListener {
            runTasks(new TaskInputs(taskExecutor, updateTasks, taskSummaryGenerator));
    // The setting below is going to replace the above.
                listener.onFailure(source, e);
    /**
    void onPublicationFailed(ClusterChangedEvent clusterChangedEvent, TaskOutputs taskOutputs, long startTimeMillis, Exception exception) {
        final Map<T, ClusterStateTaskListener> tasks,
    private TaskOutputs calculateTaskOutputs(TaskInputs taskInputs, ClusterState previousClusterState, String taskSummary) {
            if (previousClusterState.routingTable() != newClusterState.routingTable()) {
                task.listener.clusterStateProcessed(task.source(), newClusterState, newClusterState);
            clusterManagerMetrics.clusterStateComputeHistogram,
        }
        if (!previousClusterState.nodes().isLocalNodeElectedClusterManager() && taskInputs.runOnlyWhenClusterManager()) {
    }
        clusterSettings.addSettingsUpdateConsumer(
            settings,
            );
        this.throttlingStats = new ClusterManagerThrottlingStats();
            } else {
            taskInputs.updateTasks.forEach(updateTask -> {
    private final ClusterStateStats stateStats;
    ) {
                logger.trace("ack received from node [{}], cluster_state update (version: {})", node, clusterStateVersion);
     * tasks will all be executed on the executor in a single batch
            Optional.of(Tags.create().addTag("Operation", taskInputs.executor.getClass().getSimpleName()))
            Map<Object, ClusterStateTaskExecutor.TaskResult> executionResults
import java.util.stream.Collectors;
                logger.debug(
                .execute(
            @Override
        }
            }
    }
            throttlingStats
        if (!lifecycle.started()) {
        final TimeValue executionTime = getTimeSince(startTimeMillis);
    public int numberOfPendingTasks() {
        private final AckedClusterStateTaskListener listener;
            return taskResult.isSuccess();
     * @param source   the source of the cluster state update task
        private final long clusterStateVersion;
            if (countDown.fastForward()) {
            assert pending.task instanceof SourcePrioritizedRunnable
        );
    @Override
            taskInputs.updateTasks.size() == 1 ? "" : "s",
        protected final Supplier<ThreadContext.StoredContext> context;
            }
                logger.debug("cluster state updated, version [{}], source [{}]", newClusterState.version(), summary);
import org.apache.logging.log4j.LogManager;
            this.nonFailedTasks = nonFailedTasks;
    }
                return;
    protected synchronized void doClose() {}
import org.opensearch.threadpool.Scheduler;
     * Output created by executing a set of tasks provided as TaskInputs
     * @param executor the cluster state update task executor; tasks
    protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {
            ThreadPool threadPool
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
                        source
 * software distributed under the License is distributed on an
                            newClusterState.version(),
    private volatile TimeValue slowTaskLoggingThreshold;
    private static class DelegatingAckListener implements Discovery.AckListener {
        return throttlingStats.getTotalThrottledTaskCount();
        return taskInputs.updateTasks.stream().filter(updateTask -> {
            }
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
    }
            final long notificationStartTime = threadPool.preciseRelativeTimeInNanos();
    public Builder incrementVersion(ClusterState clusterState) {
            logger.trace("executing cluster state update for [{}]", summary);
        } else {
    }
            Builder builder = incrementVersion(newClusterState);
     * @return throttling task key which needs to be passed while submitting task to cluster manager
     * @param updateTask the full context for the cluster state update
        } catch (OpenSearchRejectedExecutionException e) {
        }
                );
        }).collect(Collectors.toList());
            List<Object> inputs = taskInputs.updateTasks.stream().map(tUpdateTask -> tUpdateTask.task).collect(Collectors.toList());
        this.slowTaskLoggingThreshold = CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(settings);
                ackTimeoutCallback.cancel();
        Setting.Property.Dynamic,
        );
     * Returns the tasks that are pending.
                listener.onAckTimeout();
        } else {
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
            clusterChangedEvent.source()
                    // no need to wait for ack if nothing changed, the update can be counted as acknowledged
                if (countDown.isCountedDown()) {
        } else {
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;
        logger.warn(
    void onPublicationSuccess(ClusterChangedEvent clusterChangedEvent, TaskOutputs taskOutputs) {
import org.opensearch.common.util.concurrent.ThreadContext;
            logger.debug("took [{}] to {} for [{}]", executionTime, activity, summary);
        private final Logger logger;
        }
            Supplier<ThreadContext.StoredContext> context,
            if (previousClusterState != clusterTasksResult.resultingState
            handleException(clusterChangedEvent.source(), startTimeMillis, clusterChangedEvent.state(), exception);
                stateUUID,
                ackedTaskListener.onAckTimeout();
        }
        "cluster.service.slow_cluster_manager_task_logging_threshold",
        );
            this.listeners = listeners;
    }
    }
                builder.metadata(Metadata.builder(newClusterState.metadata()).version(newClusterState.metadata().version() + 1));
        public void onTimeout() {
            Logger logger
                this.listener = listener;
            }
                pending.insertionOrder,
        }
 * not use this file except in compliance with the License.
                listener.onNoLongerClusterManager(source);
                Object task,
import org.opensearch.cluster.AckedClusterStateTaskListener;
    static final String CLUSTER_MANAGER_UPDATE_THREAD_NAME = "clusterManagerService#updateTask";
        }
                );
            }
    }
            threadPool.scheduler()
        return clusterTasksResult;
        if (previousClusterState != newClusterState) {
                    .collect(Collectors.toList())
        final String source,
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        clusterManagerMetrics.recordLatency(
        } else {
            } else {
                .collect(Collectors.toList());
            return new SafeAckedClusterStateTaskListener((AckedClusterStateTaskListener) listener, contextSupplier, logger);
            }
        final long notificationStartTime = threadPool.preciseRelativeTimeInNanos();
            taskInputs.executor.clusterStatePublished(clusterChangedEvent);
import org.opensearch.discovery.Discovery;
        clusterStatePublisher.publish(clusterChangedEvent, fut, taskOutputs.createAckListener(threadPool, clusterChangedEvent.state()));
    public Version getMinNodeVersion() {
import org.opensearch.common.annotation.PublicApi;
        final List<Batcher.UpdateTask> updateTasks;
     * @return A zero time value if the queue is empty, otherwise the time value oldest task waiting in the queue
                task.getAgeInMillis(),
        private final AckedClusterStateTaskListener ackedTaskListener;
        TaskInputs(
    public ClusterManagerThrottlingStats getThrottlingStats() {
            for (Batcher.UpdateTask updateTask : taskInputs.updateTasks) {
import java.util.List;
    }
    }
    public ClusterManagerService(Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {
 *
import org.opensearch.cluster.ClusterStateTaskConfig;
                && previousClusterState.nodes().isLocalNodeElectedClusterManager()
        Batcher(Logger logger, PrioritizedOpenSearchThreadPoolExecutor threadExecutor, TaskBatcherListener taskBatcherListener) {
                        newState
                ),
                final DiscoveryNodes.Delta nodesDelta = clusterChangedEvent.nodesDelta();
                            task.source,
                        );
            for (Discovery.AckListener listener : listeners) {
        );
        void notifyFailedTasks() {
                        clusterStateVersion
                inner.addSuppressed(e);
                Priority priority,
                );
            return;
        }
                        logger.info(
import org.opensearch.common.util.concurrent.FutureUtils;
        }
     * @param tasks    a map of update tasks and their corresponding listeners
                // new cluster state, notify all listeners
                builder.routingTable(
                () -> new ParameterizedMessage(
            final TimeValue timeLeft = TimeValue.timeValueNanos(Math.max(0, ackTimeout.nanos() - commitTime.nanos()));
                    ),
            } catch (Exception inner) {
                .map(e -> taskBatcher.new UpdateTask(config.priority(), source, e.getKey(), safe(e.getValue(), supplier), executor))
    private TimeValue getTimeSince(long startTimeNanos) {
                    "failed to execute cluster state update (on version: [{}], uuid: [{}]) for [{}]\n{}{}{}",
                        task -> new AckCountDownListener(
            FutureUtils.get(fut);
                    String nodesDeltaSummary = nodesDelta.shortSummary();
        this.clusterStateSupplier = clusterStateSupplier;
     * @param task - cluster manager task
    private ClusterState patchVersions(ClusterState previousClusterState, ClusterTasksResult<?> executionResult) {
                            + "{}\nnew cluster state:\n{}",
import org.apache.logging.log4j.message.ParameterizedMessage;
     */
            final ClusterStateTaskListener listener;
     * potentially with more tasks of the same executor.
                logger.error(
            assert clusterTasksResult.executionResults.containsKey(updateTask.task) : "missing " + updateTask;
                }
     * Returns the number of throttled pending tasks.
            logger.debug("executing cluster state update for [{}]", summary);
    }
        }
                );
import org.apache.logging.log4j.Logger;
 *
            return listener.mustAck(discoveryNode);
        final String stateUUID = newClusterState.stateUUID();
            + "]";
import org.opensearch.action.support.PlainActionFuture;
            AckedClusterStateTaskListener ackedTaskListener,
        Discovery.AckListener createAckListener(ThreadPool threadPool, ClusterState newClusterState) {
                () -> new ParameterizedMessage(
public class ClusterManagerService extends AbstractLifecycleComponent {
            this.countDown = new CountDown(countDown + 1); // we also wait for onCommit to be called
import java.util.Locale;
            "notify listeners on successful publication of cluster state (version: "
        ) {
            final long version = clusterChangedEvent.state().version();
            public String describeTasks(List<? extends BatchedTask> tasks) {
     * @param throttlingEnabled - throttling is enabled for task or not i.e does data node perform retries on it or not
    private static class SafeClusterStateTaskListener implements ClusterStateTaskListener {
import org.opensearch.cluster.ClusterStateTaskListener;
        return state().getNodes().getMinNodeVersion();
            protected boolean blockingAllowed() {
            daemonThreadFactory(nodeName, CLUSTER_MANAGER_UPDATE_THREAD_NAME),
    }
        }
        final List<Batcher.UpdateTask> nonFailedTasks;
    }
            try (ThreadContext.StoredContext ignore = context.get()) {
 * specific language governing permissions and limitations
                if (nodesDelta.hasChanges() && logger.isInfoEnabled()) {
            logger.trace("all expected nodes acknowledged cluster_state update (version: {})", clusterStateVersion);
                            "{}, term: {}, version: {}, delta: {}",
            clusterSettings,
                this.ackTimeoutCallback = threadPool.schedule(this::onTimeout, timeLeft, ThreadPool.Names.GENERIC);
        final ClusterState previousClusterState = state();
            this.executor = executor;
import org.opensearch.cluster.node.DiscoveryNodes;
    }
    /**
                nonFailedTasks.stream()
            SourcePrioritizedRunnable task = (SourcePrioritizedRunnable) pending.task;
        }
}
    private void runTasks(TaskInputs taskInputs) {
     * @param listener callback after the cluster state update task
        );
                .build(previousClusterState);
            List<Batcher.UpdateTask> nonFailedTasks,
    protected void publish(ClusterChangedEvent clusterChangedEvent, TaskOutputs taskOutputs, long startTimeNanos) {
        logExecutionTime(
import org.opensearch.common.util.concurrent.ThreadContextAccess;
        this.nodeName = Objects.requireNonNull(Node.NODE_NAME_SETTING.get(settings));
        void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {
    public ClusterManagerService(
    class TaskOutputs {
                    e
        @Override
        public void onAckTimeout() {
            ClusterStateTaskExecutor<Object> taskExecutor = (ClusterStateTaskExecutor<Object>) batchingKey;
    ) {
     *
                listener.onNodeAck(node, e);
            taskInputs,
    }
            }
 * You may obtain a copy of the License at
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            onPublicationSuccess(clusterChangedEvent, taskOutputs);
        }
    private void setSlowTaskLoggingThreshold(TimeValue slowTaskLoggingThreshold) {
            final ClusterStateTaskExecutor.TaskResult taskResult = clusterTasksResult.executionResults.get(updateTask.task);
                .stream()
                );
            e
     * Returns the number of currently pending tasks.
    ClusterStatePublisher clusterStatePublisher;
                    .filter(task -> task.listener instanceof AckedClusterStateTaskListener)
        }
 * SPDX-License-Identifier: Apache-2.0
     * @param source   the source of the cluster state update task
                return isClusterManagerUpdateThread() || super.blockingAllowed();
                    clusterChangedEvent.source(),
        if (taskOutputs.clusterStateUnchanged()) {
    }
            clusterTasksResult = ClusterTasksResult.builder()
    private volatile Batcher taskBatcher;
    /**
            if (!lifecycle.stoppedOrClosed()) {
                    () -> new ParameterizedMessage(
                    countDown++;
        }
    protected synchronized void doStart() {
                            summary,
            nonFailedTasks.forEach(task -> task.listener.onFailure(task.source(), t));
        @Override
                publish(clusterChangedEvent, taskOutputs, publicationStartTime);
                    )
        Settings settings,
/*
            try {
        }
                ClusterStateTaskListener listener,
        if (logger.isTraceEnabled()) {
    ClusterState state() {
                this.lastFailure = e;
        }
                e
            );
    @Override
            nonFailedTasks.forEach(task -> task.listener.clusterStateProcessed(task.source(), previousClusterState, newClusterState));
    public static final Setting<TimeValue> CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING = Setting.positiveTimeSetting(
     */
            if (node.equals(clusterManagerNode) == false && ackedTaskListener.mustAck(node) == false) {
                    if (nodesDeltaSummary.length() > 0) {
     * @param config   the cluster state update task configuration
                    () -> new ParameterizedMessage(
            final long publicationStartTime = threadPool.preciseRelativeTimeInNanos();
        if (exception instanceof FailedToCommitClusterStateException) {
                            newClusterState.term(),
                    clusterChangedEvent.source()
        boolean clusterStateUnchanged() {
        final Function<Boolean, String> taskSummaryGenerator;
        final String summary;
        @Override
    private SafeClusterStateTaskListener safe(ClusterStateTaskListener listener, Supplier<ThreadContext.StoredContext> contextSupplier) {
            TimeValue ackTimeout = ackedTaskListener.ackTimeout();
                    e
        T task,
    }
        ThreadPool.terminate(threadPoolExecutor, 10, TimeUnit.SECONDS);
        @Override
    private List<Batcher.UpdateTask> getNonFailedTasks(TaskInputs taskInputs, ClusterTasksResult<Object> clusterTasksResult) {
        protected void run(Object batchingKey, List<? extends BatchedTask> tasks, Function<Boolean, String> taskSummaryGenerator) {
        public void onFailure(String source, Exception e) {
                logger.debug("publishing cluster state version [{}]", newClusterState.version());
        AckCountDownListener(
            if (previousClusterState.metadata() != newClusterState.metadata()) {
            return new PendingClusterTask(
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
                ClusterStateTaskExecutor<?> executor
        }
                    previousClusterState.stateUUID(),
    /**
        return throttlingStats;
import org.opensearch.common.settings.Settings;
            CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING,
            if (logger.isTraceEnabled()) {
     *                 batches on this executor
 * under the License.
                executionTime,
            clusterTasksResult.executionResults.size()
        this.slowTaskLoggingThreshold = slowTaskLoggingThreshold;
import java.util.Optional;
        final long computationStartTime = threadPool.preciseRelativeTimeInNanos();
        taskBatcher = new Batcher(logger, threadPoolExecutor, clusterManagerTaskThrottler);
            (double) computationTime.getMillis(),
            previousClusterState,
    }
            }
     * batched across the same instance of executor. The exact batching
        }
    ) {
        public TimeValue ackTimeout() {
        @Override
        }
        @Override
            }
            getNonFailedTasks(taskInputs, clusterTasksResult),
            + Thread.currentThread()
            }
 */
            }
            try (ThreadContext.StoredContext ignore = context.get()) {
    }
        if (executionTime.getMillis() > slowTaskLoggingThreshold.getMillis()) {
     * semantics depend on the underlying implementation but a rough
            }
                finish();
        final ClusterState newClusterState;
        return OpenSearchExecutors.newSinglePrioritizing(
        } catch (Exception e) {
    private static boolean isClusterManagerUpdateThread() {
        ClusterState newClusterState = patchVersions(previousClusterState, clusterTasksResult);
                : "thread pool executor should only use SourcePrioritizedRunnable instances but found: "
import org.opensearch.cluster.node.DiscoveryNode;
            }
            ClusterTasksResult<Object> finalClusterTasksResult = clusterTasksResult;
            this.taskSummaryGenerator = taskSummaryGenerator;
                pending.executing,
            );
    private void logExecutionTime(TimeValue executionTime, String activity, String summary) {
import java.util.Collections;
            } else {
        void onNoLongerClusterManager() {
     * Represents a set of tasks to be processed together with their executor
     * Returns the stats of throttled pending tasks.
    }
     *
     */
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.util.concurrent.CountDown;
                handleException(summary, publicationStartTime, newClusterState, e);
        @Override
    public static boolean assertNotClusterManagerUpdateThread(String reason) {
    public synchronized void setClusterStateSupplier(java.util.function.Supplier<ClusterState> clusterStateSupplier) {
     * are pending update tasks for the same executor, these update
     * Returns the min version of nodes in cluster
 */
import org.opensearch.cluster.ClusterStateTaskExecutor;
    }
            logExecutionTime(executionTime, "notify listeners on unchanged cluster state", summary);
     *                 that share the same executor will be executed
            }
                    tasks.stream().map(BatchedTask::getTask).collect(Collectors.toList())
            new ParameterizedMessage(
    protected synchronized void doStop() {
     * @param task     the state needed for the cluster state update task
            UpdateTask(
     * @param source     the source of the cluster state update task
        return true;
import org.opensearch.cluster.ClusterManagerMetrics;
        return threadPoolExecutor.getNumberOfPendingTasks();
     */
        final ClusterState previousClusterState;
     * Submits a cluster state update task; submitted updates will be
            } catch (Exception inner) {
        private DelegatingAckListener(List<Discovery.AckListener> listeners) {
        }
            this.logger = logger;
        @Override
                    previousClusterState.getRoutingNodes()
            return;
    }
            final Function<Boolean, String> taskSummaryGenerator
 * The OpenSearch Contributors require contributions made to
        private void finish() {
        try {
 */
            }
    private static final Logger logger = LogManager.getLogger(ClusterManagerService.class);
        public void onNodeAck(DiscoveryNode node, @Nullable Exception e) {
        @Override
        submitStateUpdateTasks(source, Collections.singletonMap(task, listener), config, executor);
            return listener.ackTimeout();
            // ignore cases where we are shutting down..., there is really nothing interesting
    /**
     */
        final TaskOutputs taskOutputs = calculateTaskOutputs(taskInputs, previousClusterState, summary);
     */
        this.threadPool = threadPool;
            try (ThreadContext.StoredContext ignore = context.get()) {
                pending.priority,
import org.opensearch.node.Node;
            @Override
            this.previousClusterState = previousClusterState;
            final TimeValue executionTime = getTimeSince(notificationStartTime);
            clusterTasksResult.executionResults
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
     *                 that share the same executor will be executed
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        public void onNoLongerClusterManager(String source) {
                "took [{}] and then failed to publish updated cluster state (version: {}, uuid: {}) for [{}]:\n{}",
        }
    /**
        if (Assertions.ENABLED) {
     *                 batches on this executor
                    taskSummary,
     *                 completes
    }
 *
        ) {
        Objects.requireNonNull(clusterStateSupplier, "please set a cluster state supplier before starting");
                listener.onCommit(commitTime);
                + ", uuid: "
        return true;
        final ClusterStateTaskExecutor<Object> executor;
        void publishingFailed(FailedToCommitClusterStateException t) {
        try {
        }
        SafeAckedClusterStateTaskListener(
        assert clusterTasksResult.executionResults != null;
     * guideline is that if the update task is submitted while there
                // we always wait for at least the cluster-manager node
            ClusterState previousClusterState,
            final ClusterState newClusterState = taskOutputs.newClusterState;
            for (DiscoveryNode node : nodes) {
        );
        private volatile Scheduler.Cancellable ackTimeoutCallback;
            taskInputs.onNoLongerClusterManager();
            this.executionResults = executionResults;
                            (AckedClusterStateTaskListener) task.listener,
        final Supplier<ThreadContext.StoredContext> supplier = threadContext.newRestorableContext(true);
            if (ackTimeout == null) {
                    )
    private ClusterTasksResult<Object> executeTasks(TaskInputs taskInputs, ClusterState previousClusterState, String taskSummary) {
            taskBatcher.submitTasks(safeTasks, config.timeout());
        void processedDifferentClusterState(ClusterState previousClusterState, ClusterState newClusterState) {
        }
        private final List<Discovery.AckListener> listeners;
    }
        assert clusterTasksResult.executionResults.size() == taskInputs.updateTasks.size() : String.format(
        } catch (Exception e) {
                    previousClusterState.version(),
            super(listener, context, logger);
    private void handleException(String summary, long startTimeMillis, ClusterState newClusterState, Exception e) {
                logger.error(
            logger.trace(
        final String fullState = newClusterState.toString();
                onTimeout();
    /**
                fullState
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            logger.trace("expecting {} acknowledgements for cluster_state update (version: {})", countDown, clusterStateVersion);
                    "exception thrown while notifying executor of new cluster state publication [{}]",
                if (node.equals(clusterManagerNode) || ackedTaskListener.mustAck(node)) {
                    ((AckedClusterStateTaskListener) task.listener).onAllNodesAcked(null);
     * The current cluster state exposed by the discovery layer. Package-visible for tests.
                        )
                    version
            stateStats.stateUpdated();
                    () -> tasks.forEach(
            final long durationMillis = getTimeSince(startTimeNanos).millis();
    @SuppressWarnings("unchecked")
        };
                            nodesDeltaSummary
        }
import org.opensearch.cluster.ClusterChangedEvent;
     * Submits a cluster state update task; unlike {@link #submitStateUpdateTask(String, Object, ClusterStateTaskConfig,
import org.opensearch.common.Nullable;
            this.ackedTaskListener = ackedTaskListener;
            if (ackTimeoutCallback != null) {
            this.listener = listener;
            }
                pending.executionTimeInMillis
            }
    }
            AckedClusterStateTaskListener listener,
        Objects.requireNonNull(clusterStatePublisher, "please set a cluster state publisher before starting");
    protected final ThreadPool threadPool;
        return clusterStateSupplier.get();
        } else {
                finish();
            int countDown = 0;
            // fail all tasks that have failed
    public static boolean assertClusterManagerUpdateThread() {
            updateTasks.forEach(task -> task.listener.onNoLongerClusterManager(task.source()));
                logger.trace("timeout waiting for acknowledgement for cluster_state update (version: {})", clusterStateVersion);
            } catch (Exception e) {
        return clusterManagerTaskThrottler.registerClusterManagerTask(task, throttlingEnabled);
                summary,
                ), // may be expensive => construct message lazily
            }
            // to be done here...
            });
    }
        }
        assert isClusterManagerUpdateThread() : "not called from the cluster-manager service thread";
        return TimeValue.timeValueMillis(TimeValue.nsecToMSec(threadPool.preciseRelativeTimeInNanos() - startTimeNanos));
            summary = taskInputs.taskSummaryGenerator.apply(true);
        }
        }
        }
    /**
            List<Batcher.UpdateTask> safeTasks = tasks.entrySet()
                }
                }
            );
        final ClusterStateTaskExecutor<T> executor
        public void onCommit(TimeValue commitTime) {
    public long numberOfThrottledPendingTasks() {
                    RoutingTable.builder(newClusterState.routingTable()).version(newClusterState.routingTable().version() + 1).build()
        void notifySuccessfulTasksOnUnchangedClusterState() {
    // To keep backwards compatibility, the old usage is remained, and it's also used as the fallback for the new usage.
        final PlainActionFuture<Void> fut = new PlainActionFuture<Void>() {
            return executor.runOnlyOnClusterManager();
     */
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        }
            try (ThreadContext.StoredContext ignore = context.get()) {
        ClusterTasksResult<Object> clusterTasksResult;
            "expected [%d] task result%s but was [%d]",
            taskInputs.updateTasks.size(),
        ClusterTasksResult<Object> clusterTasksResult = executeTasks(taskInputs, previousClusterState, taskSummary);
        final TimeValue computationTime = getTimeSince(computationStartTime);
                    "failing [{}]: failed to commit cluster state version [{}]",
     */
    /**
            } else if (countDown.countDown()) {
     */
                    ),
        }
                if (taskResult.isSuccess() == false) {
            this.newClusterState = newClusterState;
                            threadPool
     */
import java.util.function.Supplier;
@PublicApi(since = "2.2.0")
     */
        ClusterStateTaskListener listener
 * GitHub history for details.
        String source,
            List<Batcher.UpdateTask> updateTasks,
            logger.debug("failing [{}]: local node is no longer cluster-manager", summary);
        this(settings, clusterSettings, threadPool, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE));
            newClusterState,
        if (!lifecycle.started()) {
import java.util.Map;
        public void onAllNodesAcked(@Nullable Exception e) {
import org.opensearch.telemetry.metrics.tags.Tags;
        try {
                        source,
