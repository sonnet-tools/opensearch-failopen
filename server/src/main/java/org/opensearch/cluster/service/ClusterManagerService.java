            return new SafeClusterStateTaskListener(listener, contextSupplier, logger);
                listener.onFailure(source, e);
    }  
import org.opensearch.threadpool.Scheduler;
                ),  
        protected final Supplier<ThreadContext.StoredContext> context;
            this.taskInputs = taskInputs;
     *                 that share the same executor will be executed
 * ownership. Elasticsearch licenses this file to you under  
        protected void run(Object batchingKey, List<? extends BatchedTask> tasks, Function<Boolean, String> taskSummaryGenerator) {  
            clusterTasksResult.executionResults.size()
    }  
            }  
        return threadPoolExecutor.getNumberOfPendingTasks();  
            return;
        TaskInputs(  
        @Override  
    private void setSlowTaskLoggingThreshold(TimeValue slowTaskLoggingThreshold) {
    /**  
            this.updateTasks = updateTasks;  
     * @param updateTask the full context for the cluster state update
                throw new AssertionError("update task submitted to ClusterManagerService cannot remove cluster-manager");
        }  
            try (ThreadContext.StoredContext ignore = context.get()) {  
            List<Batcher.UpdateTask> nonFailedTasks,
    }
            clusterTasksResult.executionResults  
                .failures(taskInputs.updateTasks.stream().map(updateTask -> updateTask.task)::iterator, e)  
            this.countDown = new CountDown(countDown + 1); // we also wait for onCommit to be called  
                    previousClusterState.version(),
import java.util.stream.Collectors;
            summary = taskInputs.taskSummaryGenerator.apply(false);
        }
        }
     * Submits a cluster state update task; submitted updates will be  
    );
                listener.onAckTimeout();
 * GitHub history for details.
        final ClusterStateTaskConfig config,  
                "took [{}] and then failed to publish updated cluster state (version: {}, uuid: {}) for [{}]:\n{}",
    }  
            ClusterTasksResult<Object> finalClusterTasksResult = clusterTasksResult;
        return ClusterState.builder(clusterState).incrementVersion();
                ackedTaskListener.onAckTimeout();
            AckedClusterStateTaskListener listener,
        public void onTimeout() {
                            newClusterState.term(),
                );  
        final TimeValue executionTime = getTimeSince(notificationStartTime);
                    ackTimeoutCallback.cancel();  
                        newState
    // To keep backwards compatibility, the old usage is remained, and it's also used as the fallback for the new usage.
/*  
import org.opensearch.cluster.ClusterChangedEvent;
    }  
        "cluster.service.slow_cluster_manager_task_logging_threshold",  
 *  
        }
     */
            ClusterState previousClusterState,  
        return new TaskOutputs(
        }  
            AckedClusterStateTaskListener ackedTaskListener,
        private Exception lastFailure;
import org.opensearch.core.common.text.Text;
    static final String CLUSTER_MANAGER_UPDATE_THREAD_NAME = "clusterManagerService#updateTask";  
            return new DelegatingAckListener(
     * @param executor the cluster state update task executor; tasks
     */
                    + pending.task.getClass().getName();
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;  
    @Override
    private final ClusterManagerThrottlingStats throttlingStats;  
        if (taskOutputs.clusterStateUnchanged()) {
 * The OpenSearch Contributors require contributions made to  
                // re-check if onNodeAck has not completed while we were scheduling the timeout
            }  
        ClusterStateTaskListener listener
        } else {  
            stateStats.stateUpdated();
            taskInputs.updateTasks.size() == 1 ? "" : "s",  
                        );
            }
     * Output created by executing a set of tasks provided as TaskInputs
    private List<Batcher.UpdateTask> getNonFailedTasks(TaskInputs taskInputs, ClusterTasksResult<Object> clusterTasksResult) {
                summary,
                        logger.info(
        if (logger.isTraceEnabled()) {  
     *                   task
        protected void onTimeout(List<? extends BatchedTask> tasks, TimeValue timeout) {
 * Main Cluster Manager Node Service
                            newClusterState.version(),
            final Function<Boolean, String> taskSummaryGenerator  
                task.getAgeInMillis(),
        Discovery.AckListener createAckListener(ThreadPool threadPool, ClusterState newClusterState) {  
        ) {
                        source,
            DiscoveryNodes nodes,  
    ClusterState state() {
    ) {
        void notifyFailedTasks() {
        }
                builder.routingTable(
                ClusterChangedEvent clusterChangedEvent = new ClusterChangedEvent(summary, newClusterState, previousClusterState);
     * Submits a cluster state update task; unlike {@link #submitStateUpdateTask(String, Object, ClusterStateTaskConfig,  
import java.util.Map;
        clusterManagerMetrics.recordLatency(
        public void onCommit(TimeValue commitTime) {
import org.opensearch.cluster.ClusterStateTaskExecutor.ClusterTasksResult;
            // to be done here...  
                    "failed to execute cluster state update (on version: [{}], uuid: [{}]) for [{}]\n{}{}{}",
            summary = taskInputs.taskSummaryGenerator.apply(true);
        if (!previousClusterState.nodes().isLocalNodeElectedClusterManager() && taskInputs.runOnlyWhenClusterManager()) {
        if (Assertions.ENABLED) {  
                // new cluster state, notify all listeners
import org.apache.logging.log4j.message.ParameterizedMessage;  
            } catch (Exception e) {  
                () -> new ParameterizedMessage(  
    ) {
        }  
        public void onNoLongerClusterManager(String source) {  
        }
                ackTimeoutCallback.cancel();
        private final Logger logger;
        return state().getNodes().getMinNodeVersion();
            Builder builder = incrementVersion(newClusterState);  
            }
            logger.trace("executing cluster state update for [{}]", summary);
     *  
            }
                new Text(task.source()),  
        @Override
                            new ProcessClusterEventTimeoutException(timeout, task.source)
            }  
            return;  
        this(settings, clusterSettings, threadPool, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE));
                final DiscoveryNodes.Delta nodesDelta = clusterChangedEvent.nodesDelta();  
    /**  
            } catch (Exception inner) {
        }
                        "ack received from node [{}], cluster_state update (version: {})",
        }
    private volatile PrioritizedOpenSearchThreadPoolExecutor threadPoolExecutor;  
            this.logger = logger;
    }  
        @Override
    void onPublicationFailed(ClusterChangedEvent clusterChangedEvent, TaskOutputs taskOutputs, long startTimeMillis, Exception exception) {
            } else {
        } else {
import org.opensearch.common.Nullable;
     *                 that share the same executor will be executed
        return OpenSearchExecutors.newSinglePrioritizing(
    protected synchronized void doStop() {  
            protected boolean blockingAllowed() {
            + reason  
        }
        this.clusterManagerTaskThrottler = new ClusterManagerTaskThrottler(
                if (nodesDelta.hasChanges() && logger.isInfoEnabled()) {
                    previousClusterState.getRoutingNodes()
                if (taskResult.isSuccess() == false) {
        final long computationStartTime = threadPool.preciseRelativeTimeInNanos();
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
        this.stateStats = new ClusterStateStats();
import org.opensearch.common.settings.Settings;
                + ')',
        Batcher(Logger logger, PrioritizedOpenSearchThreadPoolExecutor threadExecutor, TaskBatcherListener taskBatcherListener) {  
            this.previousClusterState = previousClusterState;  
     * @param <T>      the type of the cluster state update task state  
    private final ClusterStateStats stateStats;
import org.opensearch.discovery.Discovery;  
        }  
    public long numberOfThrottledPendingTasks() {
    }
        }
    public List<PendingClusterTask> pendingTasks() {  
                logger.debug("cluster state updated, version [{}], source [{}]", newClusterState.version(), summary);  
                        clusterStateVersion  
            "expected [%d] task result%s but was [%d]",
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
            }
            }
 */
    /**  
        ClusterState newClusterState = patchVersions(previousClusterState, clusterTasksResult);  
/**  
                inner.addSuppressed(e);  
            try (ThreadContext.StoredContext ignore = context.get()) {
        threadPoolExecutor = createThreadPoolExecutor();
                );
            threadPool.scheduler()
    private void logExecutionTime(TimeValue executionTime, String activity, String summary) {
            return listener.mustAck(discoveryNode);
                            newClusterState.version(),
        final ClusterStateTaskExecutor<T> executor
                finish();
    ) {
            final long durationMillis = getTimeSince(startTimeNanos).millis();  
    /**
     * semantics depend on the underlying implementation but a rough
                logger.debug(
            );
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
    }
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
            nonFailedTasks.forEach(task -> {
                        "exception thrown by listener while notifying of cluster state processed from [{}], old cluster state:\n"  
            taskBatcher.submitTasks(safeTasks, config.timeout());  
                    // no need to wait for ack if nothing changed, the update can be counted as acknowledged
    }
            List<Object> inputs = taskInputs.updateTasks.stream().map(tUpdateTask -> tUpdateTask.task).collect(Collectors.toList());  
import java.util.Locale;
        String source,  
        final String source,
                    countDown++;
    public ClusterStateStats getClusterStateStats() {
        }).collect(Collectors.toList());
    }  
        final List<Batcher.UpdateTask> updateTasks;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
        final ClusterStateTaskExecutor<Object> executor;  
        );
    public synchronized void setClusterStatePublisher(ClusterStatePublisher publisher) {
        );  
     *                 completes
            if (node.equals(clusterManagerNode) == false && ackedTaskListener.mustAck(node) == false) {
        // TODO: do we want to call updateTask.onFailure here?
        }
                listener.onAllNodesAcked(e);
 * Modifications Copyright OpenSearch Contributors. See
            public String describeTasks(List<? extends BatchedTask> tasks) {  
    }  
        boolean runOnlyWhenClusterManager() {
        taskBatcher = new Batcher(logger, threadPoolExecutor, clusterManagerTaskThrottler);  
    public ClusterManagerTaskThrottler.ThrottlingKey registerClusterManagerTask(ClusterManagerTask task, boolean throttlingEnabled) {
    }  
    /**
            }
        } catch (Exception e) {
    }
            List<UpdateTask> updateTasks = (List<UpdateTask>) tasks;
    private ClusterTasksResult<Object> executeTasks(TaskInputs taskInputs, ClusterState previousClusterState, String taskSummary) {  
            clusterManagerMetrics.clusterStateComputeHistogram,  
        final TaskInputs taskInputs;
 *
    }
            threadPool.generic()  
            }
    private java.util.function.Supplier<ClusterState> clusterStateSupplier;  
        @Override
            + "] to not be the cluster-manager service thread. Reason: ["
        submitStateUpdateTask(source, updateTask, updateTask, updateTask, updateTask);
                () -> new ParameterizedMessage(
     * are pending update tasks for the same executor, these update
        );
        Settings settings,  
            ClusterStateTaskExecutor<Object> executor,
        private final CountDown countDown;
                    () -> new ParameterizedMessage(
                    ),
}
    protected final ClusterManagerTaskThrottler clusterManagerTaskThrottler;
        String source,
        public void onFailure(String source, Exception e) {
            final TimeValue timeLeft = TimeValue.timeValueNanos(Math.max(0, ackTimeout.nanos() - commitTime.nanos()));  
            this.logger = logger;
    }  
        }
        boolean clusterStateUnchanged() {
            ClusterState newClusterState,
    }
        taskOutputs.processedDifferentClusterState(clusterChangedEvent.previousState(), clusterChangedEvent.state());  
    private static class SafeAckedClusterStateTaskListener extends SafeClusterStateTaskListener implements AckedClusterStateTaskListener {  
            nonFailedTasks.forEach(task -> task.listener.clusterStateProcessed(task.source(), previousClusterState, newClusterState));
    private static final Logger logger = LogManager.getLogger(ClusterManagerService.class);
        ClusterTasksResult<Object> clusterTasksResult;
            List<Batcher.UpdateTask> updateTasks,
            ),
    private TimeValue getTimeSince(long startTimeNanos) {
     *                 batches on this executor  
                    previousClusterState.nodes(),
            } catch (Exception e) {  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        final long notificationStartTime = threadPool.preciseRelativeTimeInNanos();
            final long notificationStartTime = threadPool.preciseRelativeTimeInNanos();  
            return;
            clusterTasksResult = taskInputs.executor.execute(previousClusterState, inputs);
                .build(previousClusterState);
        public void onAllNodesAcked(@Nullable Exception e) {
        } catch (OpenSearchRejectedExecutionException e) {
 */  
                ),  
    }  
        final Function<Boolean, String> taskSummaryGenerator;
 * Unless required by applicable law or agreed to in writing,
    private ClusterState patchVersions(ClusterState previousClusterState, ClusterTasksResult<?> executionResult) {
                        )  
    }
                stateUUID,
import org.opensearch.threadpool.ThreadPool;
    /**  
                    clusterChangedEvent.source()
        }  
        }  
            this.newClusterState = newClusterState;
                        oldState,  
                    ),
            this.ackedTaskListener = ackedTaskListener;  
        private DelegatingAckListener(List<Discovery.AckListener> listeners) {
            if (logger.isTraceEnabled()) {  
            Optional.of(Tags.create().addTag("Operation", taskInputs.executor.getClass().getSimpleName()))
        if (exception instanceof FailedToCommitClusterStateException) {
        } else {
     */
        }
        this.slowTaskLoggingThreshold = slowTaskLoggingThreshold;
                publish(clusterChangedEvent, taskOutputs, publicationStartTime);  
            taskOutputs.notifySuccessfulTasksOnUnchangedClusterState();
            if (timeLeft.nanos() == 0L) {
import org.opensearch.cluster.AckedClusterStateTaskListener;  
                            task.source,
                ), // may be expensive => construct message lazily
        );
    protected final ThreadPool threadPool;
            handleException(clusterChangedEvent.source(), startTimeMillis, clusterChangedEvent.state(), exception);
        return throttlingStats;
import org.opensearch.cluster.ClusterStateTaskExecutor;  
            taskOutputs.publishingFailed((FailedToCommitClusterStateException) exception);  
                    () -> new ParameterizedMessage(  
import org.opensearch.common.util.concurrent.FutureUtils;
                    ),
                && (clusterTasksResult.resultingState.nodes().isLocalNodeElectedClusterManager() == false)) {
            ) {  
                        )
                    taskSummary,
                    String nodesDeltaSummary = nodesDelta.shortSummary();
        private final ClusterStateTaskListener listener;  
    @Override
        try {
 * under the License.  
 * compatible open source license.
        final long version = newClusterState.version();
package org.opensearch.cluster.service;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
 * specific language governing permissions and limitations
    public static boolean assertClusterManagerUpdateThread() {  
            );
                this.listener = listener;
        ) {
    private void runTasks(TaskInputs taskInputs) {
                ClusterStateTaskExecutor<?> executor
    private SafeClusterStateTaskListener safe(ClusterStateTaskListener listener, Supplier<ThreadContext.StoredContext> contextSupplier) {  
            );
        };
            long clusterStateVersion,
        }  
    }
        Objects.requireNonNull(clusterStateSupplier, "please set a cluster state supplier before starting");
        if (executionTime.getMillis() > slowTaskLoggingThreshold.getMillis()) {  
        assert clusterTasksResult.executionResults.size() == taskInputs.updateTasks.size() : String.format(
            } else if (countDown.countDown()) {  
            logger.warn("took [{}], which is over [{}], to {} for [{}]", executionTime, slowTaskLoggingThreshold, activity, summary);
            assert pending.task instanceof SourcePrioritizedRunnable
                logger.trace("timeout waiting for acknowledgement for cluster_state update (version: {})", clusterStateVersion);  
        AckCountDownListener(  
            logger.debug("processing [{}]: ignoring, cluster-manager service not started", summary);
                    "exception thrown while notifying executor of new cluster state publication [{}]",
        final TimeValue computationTime = getTimeSince(computationStartTime);
 *
        }  
        } else {
        void processedDifferentClusterState(ClusterState previousClusterState, ClusterState newClusterState) {
    }
    private static class DelegatingAckListener implements Discovery.AckListener {
        this.nodeName = Objects.requireNonNull(Node.NODE_NAME_SETTING.get(settings));
                }
    public Version getMinNodeVersion() {
                .collect(Collectors.toList());
            taskInputs.onNoLongerClusterManager();
    public ClusterManagerService(Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {
import org.opensearch.cluster.routing.RoutingTable;  
            }
                    .collect(Collectors.toList())  
                logger.error(
        );
        this.slowTaskLoggingThreshold = CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(settings);
    }  
            // fail all tasks that have failed  
            logger.trace("expecting {} acknowledgements for cluster_state update (version: {})", countDown, clusterStateVersion);
                    "failing [{}]: failed to commit cluster state version [{}]",  
            for (Batcher.UpdateTask updateTask : taskInputs.updateTasks) {
        private final ThreadPool threadPool;
     * @param executor the cluster state update task executor; tasks
     * @param <T>      the type of the cluster state update task state
public class ClusterManagerService extends AbstractLifecycleComponent {  
        }  
    private TaskOutputs calculateTaskOutputs(TaskInputs taskInputs, ClusterState previousClusterState, String taskSummary) {
                ClusterStateTaskListener listener,
        public void onNodeAck(DiscoveryNode node, @Nullable Exception e) {
        }
            }
            taskOutputs.clusterStatePublished(clusterChangedEvent);  
            final long publicationStartTime = threadPool.preciseRelativeTimeInNanos();
     * Returns the number of currently pending tasks.  
        ClusterStateTaskConfig config,
            final ClusterStateTaskExecutor.TaskResult taskResult = clusterTasksResult.executionResults.get(updateTask.task);
     * Functionality for register task key to cluster manager node.
            this.clusterManagerNode = nodes.getClusterManagerNode();  
            stateStats.stateUpdateTook(durationMillis);
            if (previousClusterState != clusterTasksResult.resultingState
                + clusterChangedEvent.state().version()
    class Batcher extends TaskBatcher {
        }
                        task -> new AckCountDownListener(
        if (!lifecycle.started()) {
            });
                String source,
 *    http://www.apache.org/licenses/LICENSE-2.0
            Locale.ROOT,  
import org.opensearch.node.Node;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        }  
     * Submits a batch of cluster state update tasks; submitted updates are guaranteed to be processed together,
        return taskInputs.updateTasks.stream().filter(updateTask -> {
        void onNoLongerClusterManager() {
        return throttlingStats.getTotalThrottledTaskCount();  
                logger.error(() -> new ParameterizedMessage("exception thrown by listener notifying of failure from [{}]", source), inner);
                listener.onNodeAck(node, e);
        @Override
            (double) computationTime.getMillis(),
    }
                version,  
                    RoutingTable.builder(newClusterState.routingTable()).version(newClusterState.routingTable().version() + 1).build()  
                }  
                assert executionResults.containsKey(updateTask.task) : "missing " + updateTask;
        ClusterSettings clusterSettings,
                pending.executing,
                    previousClusterState.stateUUID(),  
        private final long clusterStateVersion;
        ) {
                            (AckedClusterStateTaskListener) task.listener,  
    // The setting below is going to replace the above.  
import org.opensearch.common.util.concurrent.CountDown;  
     * @param tasks    a map of update tasks and their corresponding listeners
        assert isClusterManagerUpdateThread() == false : "Expected current thread ["  
    /**
            this::setSlowTaskLoggingThreshold
            newClusterState,
     */  
            } else {  
    private static class SafeClusterStateTaskListener implements ClusterStateTaskListener {
        // indefinitely wait for publication to complete
                e
                    )
    public ClusterManagerThrottlingStats getThrottlingStats() {  
        @Override
        return TimeValue.timeValueMillis(TimeValue.nsecToMSec(threadPool.preciseRelativeTimeInNanos() - startTimeNanos));
import org.opensearch.common.Priority;
            this.nonFailedTasks = nonFailedTasks;
            this.executionResults = executionResults;  
     * @param source   the source of the cluster state update task
        }  
        }
            final long version = clusterChangedEvent.state().version();  
    }
        final TimeValue executionTime = getTimeSince(startTimeMillis);
            getNonFailedTasks(taskInputs, clusterTasksResult),
        final String fullState = newClusterState.toString();
            nonFailedTasks.forEach(task -> task.listener.onFailure(task.source(), t));
            stateStats.stateUpdateFailed();
        ThreadPool threadPool,
                    version
import org.opensearch.common.util.concurrent.ThreadContextAccess;
import org.opensearch.cluster.node.DiscoveryNode;
     * batched across the same instance of executor. The exact batching
            }
            );
    }
            return listener.ackTimeout();
        class UpdateTask extends BatchedTask {  
     */
/*  
    @SuppressWarnings("unchecked")  
                listener.onNoLongerClusterManager(source);
            TimeValue ackTimeout = ackedTaskListener.ackTimeout();
        private final AckedClusterStateTaskListener ackedTaskListener;
            logger.debug("took [{}] to {} for [{}]", executionTime, activity, summary);  
    protected synchronized void doClose() {}
        }
        logger.warn(
                    e  
 * license agreements. See the NOTICE file distributed with
            }
     * Returns the tasks that are pending.
import org.opensearch.common.util.concurrent.ThreadContext;
            this.executor = executor;
                logger.debug("publishing cluster state version [{}]", newClusterState.version());
            }
            "notify listeners on successful publication of cluster state (version: "
        final Supplier<ThreadContext.StoredContext> supplier = threadContext.newRestorableContext(true);
     * The current cluster state exposed by the discovery layer. Package-visible for tests.
        }  
            CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING,  
                    e
            return taskResult.isSuccess();
    private final String nodeName;
        if (listener instanceof AckedClusterStateTaskListener) {
     */
    }  
                handleException(summary, publicationStartTime, newClusterState, e);
        }).collect(Collectors.toList());  
            super(logger, threadExecutor, taskBatcherListener);
        } else {  
                pending.priority,
    }
        if (previousClusterState != newClusterState) {
     *  
                        source
     * @param task - cluster manager task
     * @param throttlingEnabled - throttling is enabled for task or not i.e does data node perform retries on it or not
            } catch (Exception inner) {
     */  
import java.util.Collections;
    /**  
 * this file be licensed under the Apache-2.0 license or a
                logger.trace("ack received from node [{}], cluster_state update (version: {})", node, clusterStateVersion);
        public boolean mustAck(DiscoveryNode discoveryNode) {  
            TaskInputs taskInputs,
    private final ClusterManagerMetrics clusterManagerMetrics;
     * ClusterStateTaskExecutor, ClusterStateTaskListener)}, submitted updates will not be batched.
                this.lastFailure = e;
    }
        final Map<Object, ClusterStateTaskExecutor.TaskResult> executionResults;
        T task,
        void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {
                onTimeout();
    }
    }
        return clusterStateSupplier.get();
        }
import java.util.Arrays;
                    clusterChangedEvent.source(),
                if (task.listener instanceof AckedClusterStateTaskListener) {  
                this.ackTimeoutCallback = threadPool.schedule(this::onTimeout, timeLeft, ThreadPool.Names.GENERIC);  
    }  
                + clusterChangedEvent.state().stateUUID()
        @Override
                Priority priority,
     * Returns the number of throttled pending tasks.  
        final Map<T, ClusterStateTaskListener> tasks,
            try {  
        @Override
        private final DiscoveryNode clusterManagerNode;  
        final ClusterState previousClusterState = state();  
            if (!lifecycle.stoppedOrClosed()) {
            this.taskSummaryGenerator = taskSummaryGenerator;
                    .map(
        @Override
    }
    public ClusterManagerService(
                );
            if (e == null) {
            }
                throw e;
        }  
        }
     */
    }
        final String summary;  
    }
                    updateTask.listener.onFailure(updateTask.source(), taskResult.getFailure());
     * guideline is that if the update task is submitted while there  
                return;
            onPublicationSuccess(clusterChangedEvent, taskOutputs);
                        task -> ((UpdateTask) task).listener.onFailure(  
 * Licensed to Elasticsearch under one or more contributor  
                    () -> tasks.forEach(
        }
    /**  
        SafeClusterStateTaskListener(ClusterStateTaskListener listener, Supplier<ThreadContext.StoredContext> context, Logger logger) {
            this.threadPool = threadPool;
            if (ackTimeoutCallback != null) {
        }
import org.opensearch.cluster.node.DiscoveryNodes;
                exception
        }
     */  
     * @param source   the source of the cluster state update task
            final ClusterStateTaskListener listener;
import org.opensearch.cluster.ClusterState;  
            new ParameterizedMessage(  
        @Override
            daemonThreadFactory(nodeName, CLUSTER_MANAGER_UPDATE_THREAD_NAME),  
                    .filter(task -> task.listener instanceof AckedClusterStateTaskListener)  
        private final AckedClusterStateTaskListener listener;
        return Thread.currentThread().getName().contains(CLUSTER_MANAGER_UPDATE_THREAD_NAME);  
        ClusterState newClusterState = executionResult.resultingState;
            final ClusterState newClusterState = taskOutputs.newClusterState;
                            threadPool  
    private static class AckCountDownListener implements Discovery.AckListener {  
import org.opensearch.cluster.ClusterManagerMetrics;
            List<Batcher.UpdateTask> safeTasks = tasks.entrySet()
            }
        final String stateUUID = newClusterState.stateUUID();  
                }  
import org.apache.logging.log4j.Logger;
        clusterStatePublisher = publisher;  
            settings,  
            if (countDown.fastForward()) {
        }
                            summary,  
                .stream()  
import org.opensearch.cluster.ClusterState.Builder;
        try {  
            } catch (Exception e) {  
import org.opensearch.telemetry.metrics.tags.Tags;  
            updateTasks.forEach(task -> task.listener.onNoLongerClusterManager(task.source()));  
            assert clusterTasksResult.executionResults.containsKey(updateTask.task) : "missing " + updateTask;  
                            newClusterState.nodes(),
            clusterChangedEvent.source()  
            return previousClusterState == newClusterState;
        }  
                executionTime,
import java.util.function.Supplier;
        final ClusterState newClusterState;  
                finish();
        assert isClusterManagerUpdateThread() : "not called from the cluster-manager service thread";
        if (logger.isTraceEnabled()) {
            });
                + ", uuid: "  
                e  
                        node,
            }
    @Override
                    if (nodesDeltaSummary.length() > 0) {  
     * Returns the stats of throttled pending tasks.
                            nodesDeltaSummary  
        }
            }
            onPublicationFailed(clusterChangedEvent, taskOutputs, startTimeNanos, e);  
     *
                listener.onCommit(commitTime);  
            previousClusterState,  
    private void handleException(String summary, long startTimeMillis, ClusterState newClusterState, Exception e) {  
import org.opensearch.cluster.coordination.ClusterStatePublisher;  
            int countDown = 0;
     * @param source     the source of the cluster state update task  
            logger.error(
        public TimeValue ackTimeout() {  
            // ignore cases where we are shutting down..., there is really nothing interesting
            super(listener, context, logger);  
                    e  
@PublicApi(since = "2.2.0")
                .execute(
                fullState  
    private static boolean isClusterManagerUpdateThread() {
import org.opensearch.common.annotation.PublicApi;  
                builder.metadata(Metadata.builder(newClusterState.metadata()).version(newClusterState.metadata().version() + 1));
            throttlingStats  
        }  
 *
        }
                    tasks.stream().map(BatchedTask::getTask).collect(Collectors.toList())
            logger.debug("failing [{}]: local node is no longer cluster-manager", summary);  
        try {
        private final Logger logger;
import java.util.concurrent.TimeUnit;
     * Returns the maximum wait time for tasks in the queue
            logger.trace(
        }  
import java.util.Objects;  
     */
     *                 batches on this executor  
        private volatile Scheduler.Cancellable ackTimeoutCallback;  
    protected synchronized void doStart() {
            newClusterState = builder.build();
    }  
                assert finalClusterTasksResult.executionResults.containsKey(updateTask.task) : "missing task result for " + updateTask;  
    }
        }
            this.listener = listener;
            if (previousClusterState.metadata() != newClusterState.metadata()) {  
            this.context = context;  
    public synchronized void setClusterStateSupplier(java.util.function.Supplier<ClusterState> clusterStateSupplier) {  
        clusterStatePublisher.publish(clusterChangedEvent, fut, taskOutputs.createAckListener(threadPool, clusterChangedEvent.state()));  
            this.clusterStateVersion = clusterStateVersion;
                );  
                        "exception thrown by listener while notifying no longer cluster-manager from [{}]",  
import org.opensearch.cluster.metadata.Metadata;
     *  
                logger.trace("cluster state updated, source [{}]\n{}", summary, newClusterState);
    ) {
        return Arrays.stream(threadPoolExecutor.getPending()).map(pending -> {
                    ((AckedClusterStateTaskListener) task.listener).onAllNodesAcked(null);
            ackedTaskListener.onAllNodesAcked(lastFailure);
     */
        this.threadPool = threadPool;  
                            "{}, term: {}, version: {}, delta: {}",
            FutureUtils.get(fut);
            taskInputs.executor.clusterStatePublished(clusterChangedEvent);  
    public <T extends ClusterStateTaskConfig & ClusterStateTaskExecutor<T> & ClusterStateTaskListener> void submitStateUpdateTask(
            final TimeValue executionTime = getTimeSince(notificationStartTime);
            return executor.runOnlyOnClusterManager();
                    )
    }
            for (DiscoveryNode node : nodes) {
        @Override
        clusterSettings.addSettingsUpdateConsumer(
            threadPool.getThreadContext(),
                if (countDown.isCountedDown()) {
            Logger logger
                );
    protected void publish(ClusterChangedEvent clusterChangedEvent, TaskOutputs taskOutputs, long startTimeNanos) {
            return new PendingClusterTask(  
        ClusterManagerMetrics clusterManagerMetrics  
            } else {
            try (ThreadContext.StoredContext ignore = context.get()) {
    protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {  
import org.opensearch.cluster.ClusterStateTaskConfig;
            try (ThreadContext.StoredContext ignore = context.get()) {
            try (ThreadContext.StoredContext ignore = context.get()) {  
    }
 * SPDX-License-Identifier: Apache-2.0
                ackTimeout = TimeValue.ZERO;
/*
     * Returns the min version of nodes in cluster
            }  
     *
                Object task,  
            logExecutionTime(executionTime, "notify listeners on unchanged cluster state", summary);  
     * @return throttling task key which needs to be passed while submitting task to cluster manager  
import java.util.function.Function;  
            + Thread.currentThread()
    /**
            taskInputs.updateTasks.forEach(updateTask -> {
            Map<Object, ClusterStateTaskExecutor.TaskResult> executionResults  
            clusterSettings,
            e
    }
        public void onNodeAck(DiscoveryNode node, @Nullable Exception e) {  
                // we always wait for at least the cluster-manager node  
            if (countDown.countDown()) {  
            taskInputs,
            for (Discovery.AckListener listener : listeners) {
                nonFailedTasks.stream()
            this::getMinNodeVersion,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            clusterTasksResult = ClusterTasksResult.builder()
    void onPublicationSuccess(ClusterChangedEvent clusterChangedEvent, TaskOutputs taskOutputs) {
                    }
    private volatile Batcher taskBatcher;
        ClusterTasksResult<Object> clusterTasksResult = executeTasks(taskInputs, previousClusterState, taskSummary);
            return new SafeAckedClusterStateTaskListener((AckedClusterStateTaskListener) listener, contextSupplier, logger);
import java.util.List;  
                inner.addSuppressed(e);  
            taskInputs.updateTasks.size(),
        );  
 * software distributed under the License is distributed on an
    /**
    ClusterStatePublisher clusterStatePublisher;
     * @param listener callback after the cluster state update task
     * potentially with more tasks of the same executor.
        Objects.requireNonNull(clusterStatePublisher, "please set a cluster state publisher before starting");  
            UpdateTask(  
        ClusterStateTaskExecutor<T> executor,  
            clusterManagerMetrics.recordLatency(clusterManagerMetrics.clusterStatePublishHistogram, (double) durationMillis);  
 */  
    }
        ) {
        }
        } catch (Exception e) {
                    previousClusterState.routingTable(),  
        }
                }  
 * You may obtain a copy of the License at  
            this.listeners = listeners;  
        } catch (Exception e) {
import org.opensearch.common.unit.TimeValue;
            this.listener = listener;
     * Represents a set of tasks to be processed together with their executor
     * @param config   the cluster state update task configuration  
        }
        private final List<Discovery.AckListener> listeners;  
    }
            }  
        return threadPoolExecutor.getMaxTaskWaitTime();  
        this.clusterStateSupplier = clusterStateSupplier;
                if (node.equals(clusterManagerNode) || ackedTaskListener.mustAck(node)) {
    public TimeValue getMaxTaskWaitTime() {
                            + "{}\nnew cluster state:\n{}",
            ThreadPool threadPool
    private volatile TimeValue slowTaskLoggingThreshold;
            logger.trace("all expected nodes acknowledged cluster_state update (version: {})", clusterStateVersion);  
    }
            executionTime,  
            }
        assert clusterTasksResult.executionResults != null;
    public static boolean assertNotClusterManagerUpdateThread(String reason) {
                super(priority, source, executor, task);
 * @opensearch.api  
        }  
        return clusterTasksResult;
            logger.debug("executing cluster state update for [{}]", summary);  
        this.throttlingStats = new ClusterManagerThrottlingStats();
                pending.insertionOrder,
    public Builder incrementVersion(ClusterState clusterState) {
            }  
                logger.error("exception thrown by listener while notifying on all nodes acked", inner);
import org.opensearch.common.settings.Setting;  
import org.opensearch.action.support.PlainActionFuture;
        ThreadPool.terminate(threadPoolExecutor, 10, TimeUnit.SECONDS);
        void publishingFailed(FailedToCommitClusterStateException t) {  
        @Override
        Setting.Property.Dynamic,
        final PlainActionFuture<Void> fut = new PlainActionFuture<Void>() {  
        TimeValue.timeValueSeconds(10),
            // only the cluster-manager controls the version numbers
import org.opensearch.cluster.ClusterStateTaskListener;
    /**
        void notifySuccessfulTasksOnUnchangedClusterState() {
                    () -> new ParameterizedMessage(
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
     * tasks will all be executed on the executor in a single batch
        taskOutputs.notifyFailedTasks();
                listener.clusterStateProcessed(source, oldState, newState);
        }
        return newClusterState;
                () -> new ParameterizedMessage(  
        final TaskOutputs taskOutputs = calculateTaskOutputs(taskInputs, previousClusterState, summary);  
        );  
    public <T> void submitStateUpdateTask(
                return isClusterManagerUpdateThread() || super.blockingAllowed();  
    public static final Setting<TimeValue> CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING = Setting.positiveTimeSetting(
            if (previousClusterState.routingTable() != newClusterState.routingTable()) {
        } else {
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);  
        TaskOutputs(
                && previousClusterState.nodes().isLocalNodeElectedClusterManager()  
import org.opensearch.Version;
 */
            ClusterStateTaskExecutor<Object> taskExecutor = (ClusterStateTaskExecutor<Object>) batchingKey;
        }  
        final ClusterState previousClusterState;
        return true;
            logger.warn(
            for (Discovery.AckListener listener : listeners) {  
    /**
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;  
            } catch (Exception e) {
            SourcePrioritizedRunnable task = (SourcePrioritizedRunnable) pending.task;
                }  
            }
            runTasks(new TaskInputs(taskExecutor, updateTasks, taskSummaryGenerator));  
                final ClusterStateTaskExecutor.TaskResult taskResult = executionResults.get(updateTask.task);  
        if (!lifecycle.started()) {  
        final ThreadContext threadContext = threadPool.getThreadContext();  
        private void finish() {
        this.clusterManagerMetrics = clusterManagerMetrics;
                return ((ClusterStateTaskExecutor<Object>) batchingKey).describeTasks(
    }
     * @param task     the state needed for the cluster state update task
        @Override  
                task.listener.clusterStateProcessed(task.source(), newClusterState, newClusterState);
        return stateStats;
                : "thread pool executor should only use SourcePrioritizedRunnable instances but found: "  
            @Override
            }
        T updateTask  
                pending.executionTimeInMillis  
            @Override
 * not use this file except in compliance with the License.
                logger.error(
        return true;
            );
                logger.error("exception thrown by listener while notifying on ack timeout", e);
        logExecutionTime(computationTime, "compute cluster state update", summary);  
 * the Apache License, Version 2.0 (the "License"); you may
        SafeAckedClusterStateTaskListener(
     * @return A zero time value if the queue is empty, otherwise the time value oldest task waiting in the queue  
        public void onAckTimeout() {  
    private class TaskInputs {  
            + "]";
            if (ackTimeout == null) {  
        return clusterManagerTaskThrottler.registerClusterManagerTask(task, throttlingEnabled);  
    public int numberOfPendingTasks() {
    }
        Setting.Property.NodeScope  
        public void onCommit(TimeValue commitTime) {
import org.opensearch.common.settings.ClusterSettings;
import java.util.Optional;
                .map(e -> taskBatcher.new UpdateTask(config.priority(), source, e.getKey(), safe(e.getValue(), supplier), executor))
    public <T> void submitStateUpdateTasks(  
        submitStateUpdateTasks(source, Collections.singletonMap(task, listener), config, executor);  
     */
                );
        private static final Logger logger = LogManager.getLogger(AckCountDownListener.class);
    class TaskOutputs {  
     * @param config   the cluster state update task configuration  
            nodeName + "/" + CLUSTER_MANAGER_UPDATE_THREAD_NAME,
     */
import org.opensearch.core.Assertions;  
        );
            Supplier<ThreadContext.StoredContext> context,  
        logExecutionTime(
        final List<Batcher.UpdateTask> nonFailedTasks;
