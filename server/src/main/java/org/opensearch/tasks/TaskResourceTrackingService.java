     * <p>
     * Remove the current task level resource usages.
            );
import org.opensearch.cluster.service.ClusterService;
        }
    /**
     * and how much resources these have consumed till now.
    /**
                MediaTypeRegistry.JSON
import org.opensearch.common.settings.ClusterSettings;
                .setTaskId(task.getId())
            }
    public Map<Long, Task> getResourceAwareTasks() {
        return taskResourceTrackingEnabled;
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.ArrayList;
import org.opensearch.core.xcontent.DeprecationHandler;
    }
            String headerValue = canCoordinatorReadBinaryHeader(task)
        } catch (Exception e) {
            logger.debug("Error during writing task resource usage: ", e);
        if (usage == null || usage.isEmpty()) {
/*
                } else if (endValue.getStats() == ResourceStats.CPU) {
        }
    /**
        threadPool.getThreadContext().removeResponseHeader(TASK_RESOURCE_USAGE);
    public void setBinaryResourceUsageHeaderEnabled(boolean binaryResourceUsageHeaderEnabled) {
            }
                task.startThreadResourceTracking(threadId, WORKER_STATS, getResourceUsageMetricsForThread(threadId));
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfos) {
import org.opensearch.cluster.node.DiscoveryNode;
    }
     *
 *
                new BytesArray(headerValue),
        if (isBinaryResourceUsageHeaderEnabled() == false) {
    // bounded, while the cost of an unwarranted binary emission to an old coordinator is a hung search.
    ) {
     * It's also responsible to stop tracking the current thread's resources against this task if not already done.
        } catch (Exception e) {
            long cpu = -1, mem = -1;
                : taskResourceInfo.toString();
            }
    }
            }
    public void refreshResourceStats(Task... tasks) {
                logger.debug("failed to parse task resource usage header (binary and JSON), skipping: ", jsonFailure);
                }
        }
        DiscoveryNode coordinator = clusterService.state().nodes().get(coordinatorNodeId);
        return storedContext;
    }
import org.opensearch.core.tasks.resourcetracker.ResourceUsageInfo;
        return coordinator.getVersion().onOrAfter(BINARY_RESOURCE_USAGE_HEADER_VERSION);
    }
     * This happens when the thread executing the request logic itself calls the unregister method. So in this case unregister
            }
    public void removeTaskResourceUsage() {
        if (coordinator == null) {
        true,
            resourceAwareTasks.remove(task.getId());
import org.opensearch.common.io.stream.WriteableBase64;
            return () -> {};
     *
     * It doesn't have feature enabled check to avoid any issues if setting was disable while the task was in progress.
    private void refreshResourceStats(Task resourceAwareTask) {
    // Returns true only with positive confirmation that the coordinator can parse the binary header.
        threadContext.putTransient(TASK_ID, task.getId());
        }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.xcontent.MediaTypeRegistry;
     *
            final Task task = resourceAwareTasks.get(taskId);
    }
    public TaskResourceTrackingService(
    );
            logger.warn(new ParameterizedMessage("Failed to mark thread execution started for task: [{}]", taskId), e);
            )
 */
        return false;
     * @param nodeId the local nodeId
        this.binaryResourceUsageHeaderEnabled = BINARY_RESOURCE_USAGE_HEADER_ENABLED.get(settings);
            return null;
    }
        clusterSettings.addSettingsUpdateConsumer(TASK_RESOURCE_TRACKING_ENABLED, this::setTaskResourceTrackingEnabled);
            // Get resource usages from when the task started
     * that resource usage from older data nodes is preserved during a rolling upgrade.
            logger.debug("Refreshing resource stats for Task: {}", resourceAwareTask.getId());
        }
            return;
            final Task task = resourceAwareTasks.get(taskId);
                    mem = endValue.getValue();
     * <p>
                refreshResourceStats(task);
    }
    // First OpenSearch version that emits and parses the Base64 binary form of the
import java.io.IOException;
import org.opensearch.common.settings.Setting;
    private boolean canCoordinatorReadBinaryHeader(SearchShardTask task) {
     */
     * <p>
    public boolean isTaskResourceTrackingEnabled() {
            ThreadResourceInfo threadResourceInfo = task.getActiveThreadResourceInfo(
     */
        try (
    public TaskResourceTrackingService(Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {
     * @param task for which Task Id needs to be added in ThreadContext.
    }
                }
        } catch (Exception e) {
                threadId -> resourceAwareTask.updateThreadResourceStats(threadId, WORKER_STATS, getResourceUsageMetricsForThread(threadId))
        List<Exception> exceptions = new ArrayList<>();
     * Refreshes the resource stats for the tasks provided by looking into which threads are actively working on these
    private final ClusterService clusterService;
package org.opensearch.tasks;
    // cluster state — falls back to JSON, since the cost of an unwarranted JSON emission is small and
        this.taskCompletionListeners.add(listener);
        String usage = taskResourceUsages.get(0);
     * Tries the new Base64 binary format first; on failure falls back to the legacy JSON form so
        for (Task task : tasks) {
    /**
 * compatible open source license.
                .build();
                if (threadResourceInfo.isActive()) {
     */
    // Without ClusterService, writeTaskResourceUsage cannot verify the coordinator's version
        if (isTaskResourceTrackingEnabled() == false || isTaskResourceTrackingSupported() == false) {
    /**
    private static final ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
            assert false;
        Settings settings,
        if (task.supportsResourceTracking() == false
            if (task != null) {
            }
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        Setting.Property.Dynamic,
    private volatile boolean taskResourceTrackingEnabled;
     * @param threadId of the thread which will be executing the runnable and we need to check resource usage for this
     *
                taskExecutionFinishedOnThread(task.getId(), Thread.currentThread().threadId());
     */
    // Legacy JSON parser for headers emitted by pre-V_3_8_0 data nodes during rolling upgrade.
            return false;
    private final ThreadPool threadPool;
import org.opensearch.core.tasks.resourcetracker.ResourceStatsType;
    }
import org.opensearch.threadpool.RunnableTaskExecutionListener;
import org.opensearch.core.common.bytes.BytesArray;
    }
        }
        return Collections.unmodifiableMap(resourceAwareTasks);
    private ThreadContext.StoredContext addTaskIdToThreadContext(Task task) {
        for (List<ThreadResourceInfo> threadResourceInfos : task.getResourceStats().values()) {
 * Service that helps track resource usage of tasks running on a node.
            threadPool.getThreadContext().updateResponseHeader(TASK_RESOURCE_USAGE, headerValue);
import org.opensearch.common.util.concurrent.ConcurrentMapLong;
                return deserializeFromJson(usage);
        for (TaskCompletionListener listener : taskCompletionListeners) {
    /**
        }
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
    public void taskExecutionFinishedOnThread(long taskId, long threadId) {
    @Inject
                return;
            XContentParser parser = XContentHelper.createParser(
            return null;
    /**
        } catch (Exception binaryFailure) {
            return WriteableBase64.decode(usage, TaskResourceInfo::readFromStream);
                task.stopThreadResourceTracking(threadId, WORKER_STATS, getResourceUsageMetricsForThread(threadId));
     * Caller can call context.restore() to get the existing ThreadContext back.
            if (!(startValues.containsKey(ResourceStats.CPU) && startValues.containsKey(ResourceStats.MEMORY))) {
    }
            }
import org.apache.logging.log4j.Logger;
     * @param tasks for which resource stats needs to be refreshed.
        logger.debug("Starting resource tracking for task: {}", task.getId());
    public void setTaskResourceTrackingEnabled(boolean taskResourceTrackingEnabled) {
     * Adds Task Id in the ThreadContext.
import java.lang.management.ManagementFactory;
        clusterSettings.addSettingsUpdateConsumer(BINARY_RESOURCE_USAGE_HEADER_ENABLED, this::setBinaryResourceUsageHeaderEnabled);
    }
    /**
        }
        }
     * Get the current task level resource usage.
        ) {
    /**
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
                        cpu - startValues.get(ResourceStats.CPU).getStartValue(),
     */
    public interface TaskCompletionListener {
import org.opensearch.core.xcontent.XContentParser;
     * Called when a thread finishes working on a task's runnable.
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);
            if (isCurrentThreadWorkingOnTask(task)) {
        }
        return new ResourceUsageMetric[] { currentMemoryUsage, currentCPUUsage };
            return TaskResourceInfo.PARSER.apply(parser, null);
        ResourceUsageMetric currentCPUUsage = new ResourceUsageMetric(ResourceStats.CPU, threadMXBean.getThreadCpuTime(threadId));
            try {
            } catch (Exception jsonFailure) {
                    )
                ResourceStatsType.WORKER_STATS
     *                 thread
            return false;
            );
    }
import java.util.List;
    );
        try {
    private final ConcurrentMapLong<Task> resourceAwareTasks = ConcurrentCollections.newConcurrentMapLongWithAggressiveConcurrency();
                return true;
                return;
    }
        ClusterSettings clusterSettings,
import org.opensearch.common.inject.Inject;
    static TaskResourceInfo deserializeFromJson(String headerValue) throws IOException {
        ThreadContext threadContext = threadPool.getThreadContext();
}
        }
            || isTaskResourceTrackingSupported() == false) {
    // data nodes always emit the legacy JSON header. The consumer always falls back to JSON regardless.
            // Get current resource usages
            if (task != null) {
    public TaskResourceInfo getTaskResourceUsageFromThreadContext() {
                return;
        List<String> taskResourceUsages = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE);
            || isTaskResourceTrackingEnabled() == false
        void onTaskCompleted(Task task);
        }
     *
    public static final Setting<Boolean> BINARY_RESOURCE_USAGE_HEADER_ENABLED = Setting.boolSetting(
        if (clusterService == null) {
     */
    }
     * @param taskId   of the task for which runnable is starting
 */
import org.apache.logging.log4j.LogManager;
    public boolean isTaskResourceTrackingSupported() {
        try {
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
            // Remove the existing TASK_RESOURCE_USAGE header since it would have come from an earlier phase in the same request.
            threadMXBean.getThreadAllocatedBytes(threadId)
            if (threadResourceInfo == null) {
                .setParentTaskId(task.getParentTaskId().getId())
import org.opensearch.ExceptionsHelper;
            return false;
        ResourceUsageMetric currentMemoryUsage = new ResourceUsageMetric(
        "task_resource_tracking.binary_header.enabled",
                ? WriteableBase64.encode(taskResourceInfo)
import org.opensearch.Version;
            threadsWorkingOnTask.forEach(
        this.binaryResourceUsageHeaderEnabled = binaryResourceUsageHeaderEnabled;
    public ThreadContext.StoredContext startTracking(Task task) {
            if (cpu == -1 || mem == -1) {
import org.opensearch.common.settings.Settings;
        }
     * <p>
     * Stops tracking task registered earlier for tracking.
                logger.debug("Task execution started on thread. Task: {}, Thread: {}", taskId, threadId);
        } catch (Exception e) {
     * 2. Adds Task Id in thread context to make sure it's available while task is processed across multiple threads.
     */
            for (ResourceUsageMetric endValue : endValues) {
    public static final String TASK_ID = "TASK_ID";
     * @param threadId of the thread which executed the runnable and we need to check resource usage for this thread
     */
    private volatile boolean binaryResourceUsageHeaderEnabled;
            }
                Thread.currentThread().threadId(),
            ResourceUsageMetric[] endValues = getResourceUsageMetricsForThread(Thread.currentThread().threadId());
        }
                NamedXContentRegistry.EMPTY,
        "task_resource_tracking.enabled",
        try {
    private ResourceUsageMetric[] getResourceUsageMetricsForThread(long threadId) {
    public void taskExecutionStartedOnThread(long taskId, long threadId) {
        return binaryResourceUsageHeaderEnabled;
    // and will always emit the legacy JSON header. Forgoes the binary CPU win but is rolling-upgrade safe.
        try {
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
     * @return {@link TaskResourceInfo} or null if the header is absent or cannot be deserialized
            TaskResourceInfo taskResourceInfo = new TaskResourceInfo.Builder().setAction(task.getAction())
     * Called when a thread starts working on a task's runnable.
                .setNodeId(nodeId)
    private final List<TaskCompletionListener> taskCompletionListeners = new ArrayList<>();
    }
        this(settings, clusterSettings, threadPool, null);
        this.clusterService = clusterService;
                    cpu = endValue.getValue();
    }
            logger.debug("Resource stats already updated.");
    }
        List<ThreadResourceInfo> threadResourceInfos = task.getResourceStats().getOrDefault(threadId, Collections.emptyList());
        ThreadPool threadPool,
    }
        }
            // Build task resource usage info
     * Get the task resource usages from {@link ThreadContext}.
     * Stashes the existing ThreadContext and preserves all the existing ThreadContext's data in the new ThreadContext
            }
                return null;
            Map<ResourceStats, ResourceUsageInfo.ResourceStatsInfo> startValues = threadResourceInfo.getResourceUsageInfo().getStatsInfo();
        return addTaskIdToThreadContext(task);
     * @param task {@link SearchShardTask}
        } finally {
        ClusterService clusterService
        String coordinatorNodeId = task.getParentTaskId().getNodeId();
    public void writeTaskResourceUsage(SearchShardTask task, String nodeId) {
    @Override
     * happens before runnable finishes.
     * @param task for which resources needs to be tracked
    // Kill-switch for emitting the Base64 binary TASK_RESOURCE_USAGE response header. When false,
     * Executes logic only if task supports resource tracking and resource tracking setting is enabled.
        } catch (IllegalStateException e) {
                logger.debug("Task execution finished on thread. Task: {}, Thread: {}", taskId, threadId);
    private List<Long> getThreadsWorkingOnTask(Task task) {
            if (threadResourceInfo.isActive()) {
                    new TaskResourceUsage(
import org.opensearch.core.tasks.resourcetracker.TaskResourceInfo;
import org.opensearch.common.util.concurrent.ThreadContext;
        return activeThreads;
import java.util.Collections;
     * @param task task which has finished and doesn't need resource tracking.
     * @return Autocloseable stored context to restore ThreadContext to the state before this method changed it.
        for (ThreadResourceInfo threadResourceInfo : threadResourceInfos) {
        try {
        this.taskResourceTrackingEnabled = taskResourceTrackingEnabled;
public class TaskResourceTrackingService implements RunnableTaskExecutionListener {
            }
        if (coordinatorNodeId.isEmpty()) {
     * @param taskId   of the task for which runnable is complete
    public static final String TASK_RESOURCE_USAGE = "TASK_RESOURCE_USAGE";
        }
    }
     * Listener that gets invoked when a task execution completes.
            return false;
import static org.opensearch.core.tasks.resourcetracker.ResourceStatsType.WORKER_STATS;
    public static final Setting<Boolean> TASK_RESOURCE_TRACKING_ENABLED = Setting.boolSetting(
     */
                        mem - startValues.get(ResourceStats.MEMORY).getStartValue()
        List<Long> activeThreads = new ArrayList<>();
    /**
     *
                )
            }
    // Any unknown — kill-switch off, no ClusterService, empty parent task, coordinator missing from
        resourceAwareTasks.put(task.getId(), task);
 * SPDX-License-Identifier: Apache-2.0
        Setting.Property.NodeScope
/**
                exceptions.add(e);
import org.opensearch.core.tasks.resourcetracker.ResourceUsageMetric;
        Setting.Property.NodeScope
                listener.onTaskCompleted(task);
     */
import org.opensearch.threadpool.ThreadPool;
                    activeThreads.add(threadResourceInfo.getThreadId());
    }
    // TASK_RESOURCE_USAGE response header. Coordinators older than this only understand JSON.
    private static final Logger logger = LogManager.getLogger(TaskResourceTrackingService.class);
            } catch (Exception e) {
        }
            logger.warn("Failed while trying to mark the task execution on current thread completed.", e);
        return threadMXBean.isThreadAllocatedMemorySupported() && threadMXBean.isThreadAllocatedMemoryEnabled();
        try {
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            List<Long> threadsWorkingOnTask = getThreadsWorkingOnTask(resourceAwareTask);
        }
            assert false;
    }
        long threadId = Thread.currentThread().threadId();
    @Override
            ResourceStats.MEMORY,
        this.threadPool = threadPool;
     *
import com.sun.management.ThreadMXBean;
     * as well.
@SuppressForbidden(reason = "ThreadMXBean#getThreadAllocatedBytes")
     *
import java.util.Map;
        true,
        this.taskResourceTrackingEnabled = TASK_RESOURCE_TRACKING_ENABLED.get(settings);
import org.opensearch.action.search.SearchShardTask;
     * <p>
            if (task.supportsResourceTracking() && resourceAwareTasks.containsKey(task.getId())) {
import org.opensearch.common.xcontent.XContentHelper;
 * this file be licensed under the Apache-2.0 license or a
    private boolean isCurrentThreadWorkingOnTask(Task task) {
            }
        logger.debug("Stopping resource tracking for task: {}", task.getId());
            logger.warn(new ParameterizedMessage("Failed to mark thread execution finished for task: [{}]", taskId), e);
        Setting.Property.Dynamic,
     * 1. Starts tracking the task in map of resourceAwareTasks.
    public void stopTracking(Task task) {
    }
    public void addTaskCompletionListener(TaskCompletionListener listener) {
                .setTaskResourceUsage(
            assert false;
    public boolean isBinaryResourceUsageHeaderEnabled() {
        if (taskResourceUsages == null || taskResourceUsages.isEmpty()) {
    static final Version BINARY_RESOURCE_USAGE_HEADER_VERSION = Version.V_3_8_0;
            try {
import org.opensearch.common.SuppressForbidden;
                if (endValue.getStats() == ResourceStats.MEMORY) {
        );
        }
        ThreadContext.StoredContext storedContext = threadContext.newStoredContext(true, Collections.singletonList(TASK_ID));
     * @return StoredContext reference to restore the ThreadContext from which we created a new one.
                logger.debug("Invalid resource usage value, cpu [{}], memory [{}]: ", cpu, mem);
