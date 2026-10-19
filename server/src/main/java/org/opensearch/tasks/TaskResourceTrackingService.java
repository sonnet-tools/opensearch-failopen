        List<Long> activeThreads = new ArrayList<>();  
    // Legacy JSON parser for headers emitted by pre-V_3_8_0 data nodes during rolling upgrade.
     * Get the task resource usages from {@link ThreadContext}.
    @Inject
     * It doesn't have feature enabled check to avoid any issues if setting was disable while the task was in progress.
     */
    private static final Logger logger = LogManager.getLogger(TaskResourceTrackingService.class);  
            assert false;
    @Override
                : taskResourceInfo.toString();
import org.opensearch.core.tasks.resourcetracker.TaskResourceInfo;
        Setting.Property.NodeScope  
     *  
            assert false;  
    }
 */  
            }
        this.taskCompletionListeners.add(listener);  
            // Remove the existing TASK_RESOURCE_USAGE header since it would have come from an earlier phase in the same request.  
                return;
     * Caller can call context.restore() to get the existing ThreadContext back.
     *  
            } catch (Exception jsonFailure) {
            || isTaskResourceTrackingEnabled() == false  
        List<ThreadResourceInfo> threadResourceInfos = task.getResourceStats().getOrDefault(threadId, Collections.emptyList());
        }
        this.binaryResourceUsageHeaderEnabled = BINARY_RESOURCE_USAGE_HEADER_ENABLED.get(settings);
        if (isBinaryResourceUsageHeaderEnabled() == false) {  
package org.opensearch.tasks;
            threadPool.getThreadContext().updateResponseHeader(TASK_RESOURCE_USAGE, headerValue);
            String headerValue = canCoordinatorReadBinaryHeader(task)  
        clusterSettings.addSettingsUpdateConsumer(TASK_RESOURCE_TRACKING_ENABLED, this::setTaskResourceTrackingEnabled);
import org.opensearch.common.util.concurrent.ThreadContext;
            return false;
    /**
 * this file be licensed under the Apache-2.0 license or a
    public static final Setting<Boolean> TASK_RESOURCE_TRACKING_ENABLED = Setting.boolSetting(
        try {
import java.util.List;
        threadPool.getThreadContext().removeResponseHeader(TASK_RESOURCE_USAGE);  
            threadsWorkingOnTask.forEach(
        } catch (Exception e) {
import org.opensearch.threadpool.RunnableTaskExecutionListener;  
    public void removeTaskResourceUsage() {
    private boolean canCoordinatorReadBinaryHeader(SearchShardTask task) {
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            if (isCurrentThreadWorkingOnTask(task)) {  
    }  
     * @param task {@link SearchShardTask}
     * @param threadId of the thread which will be executing the runnable and we need to check resource usage for this
    /**  
     */
        for (TaskCompletionListener listener : taskCompletionListeners) {
    // Without ClusterService, writeTaskResourceUsage cannot verify the coordinator's version
import java.util.Collections;  
        }  
    }
            logger.debug("Error during writing task resource usage: ", e);  
     * @param tasks for which resource stats needs to be refreshed.
    }  
    private void refreshResourceStats(Task resourceAwareTask) {  
     * @param taskId   of the task for which runnable is starting
    }  
        List<Exception> exceptions = new ArrayList<>();
            }
        }
        ThreadContext threadContext = threadPool.getThreadContext();
    }
            return WriteableBase64.decode(usage, TaskResourceInfo::readFromStream);  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
import com.sun.management.ThreadMXBean;
            return false;
        if (taskResourceUsages == null || taskResourceUsages.isEmpty()) {
        try {
        }  
        this.clusterService = clusterService;  
                NamedXContentRegistry.EMPTY,  
                threadId -> resourceAwareTask.updateThreadResourceStats(threadId, WORKER_STATS, getResourceUsageMetricsForThread(threadId))
    }
        threadContext.putTransient(TASK_ID, task.getId());  
     * happens before runnable finishes.
    /**
                exceptions.add(e);  
                return;  
                refreshResourceStats(task);
        return binaryResourceUsageHeaderEnabled;  
     * @return {@link TaskResourceInfo} or null if the header is absent or cannot be deserialized  
        }
            }
                .setParentTaskId(task.getParentTaskId().getId())  
            if (cpu == -1 || mem == -1) {
                .build();
public class TaskResourceTrackingService implements RunnableTaskExecutionListener {
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public boolean isBinaryResourceUsageHeaderEnabled() {
        }
import static org.opensearch.core.tasks.resourcetracker.ResourceStatsType.WORKER_STATS;
                logger.debug("Task execution finished on thread. Task: {}, Thread: {}", taskId, threadId);
                }
    private ResourceUsageMetric[] getResourceUsageMetricsForThread(long threadId) {
        }
            final Task task = resourceAwareTasks.get(taskId);
            resourceAwareTasks.remove(task.getId());
import org.opensearch.core.tasks.resourcetracker.ResourceUsageMetric;
                MediaTypeRegistry.JSON  
                return deserializeFromJson(usage);  
    // cluster state — falls back to JSON, since the cost of an unwarranted JSON emission is small and  
            ResourceStats.MEMORY,
import org.opensearch.common.settings.ClusterSettings;
    /**
            if (threadResourceInfo.isActive()) {
    private static final ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
            }
            || isTaskResourceTrackingSupported() == false) {
     *
import org.apache.logging.log4j.Logger;
            if (task.supportsResourceTracking() && resourceAwareTasks.containsKey(task.getId())) {  
                listener.onTaskCompleted(task);
            logger.warn(new ParameterizedMessage("Failed to mark thread execution finished for task: [{}]", taskId), e);
    /**
    ) {
    public void taskExecutionStartedOnThread(long taskId, long threadId) {  
        if (isTaskResourceTrackingEnabled() == false || isTaskResourceTrackingSupported() == false) {
            // Get current resource usages  
     *
        for (Task task : tasks) {
     * @param task for which resources needs to be tracked
import org.opensearch.common.SuppressForbidden;
        } finally {  
import org.apache.logging.log4j.message.ParameterizedMessage;
     * @param task for which Task Id needs to be added in ThreadContext.
        }  
            final Task task = resourceAwareTasks.get(taskId);
        logger.debug("Starting resource tracking for task: {}", task.getId());
                task.stopThreadResourceTracking(threadId, WORKER_STATS, getResourceUsageMetricsForThread(threadId));
        return threadMXBean.isThreadAllocatedMemorySupported() && threadMXBean.isThreadAllocatedMemoryEnabled();
     * @param threadId of the thread which executed the runnable and we need to check resource usage for this thread  
        resourceAwareTasks.put(task.getId(), task);  
    }  
    }
import org.opensearch.core.common.bytes.BytesArray;  
     * @return Autocloseable stored context to restore ThreadContext to the state before this method changed it.
    private final List<TaskCompletionListener> taskCompletionListeners = new ArrayList<>();
        }
    }  
    /**
 * Service that helps track resource usage of tasks running on a node.
    private volatile boolean binaryResourceUsageHeaderEnabled;  
     *  
                if (threadResourceInfo.isActive()) {  
            long cpu = -1, mem = -1;
import java.lang.management.ManagementFactory;
        void onTaskCompleted(Task task);
        if (coordinator == null) {
    }  
    private List<Long> getThreadsWorkingOnTask(Task task) {
            return TaskResourceInfo.PARSER.apply(parser, null);  
                    new TaskResourceUsage(  
                ResourceStatsType.WORKER_STATS  
                )
import org.opensearch.threadpool.ThreadPool;
            }
        } catch (Exception e) {  
 */
import org.opensearch.common.settings.Settings;
        ClusterService clusterService
            return false;
    public void refreshResourceStats(Task... tasks) {  
            if (!(startValues.containsKey(ResourceStats.CPU) && startValues.containsKey(ResourceStats.MEMORY))) {  
                logger.debug("Invalid resource usage value, cpu [{}], memory [{}]: ", cpu, mem);
     * 1. Starts tracking the task in map of resourceAwareTasks.
    public void addTaskCompletionListener(TaskCompletionListener listener) {
import java.util.ArrayList;
    public static final String TASK_ID = "TASK_ID";
            if (task != null) {  
                .setTaskResourceUsage(
                return true;
    );
        if (task.supportsResourceTracking() == false
        return new ResourceUsageMetric[] { currentMemoryUsage, currentCPUUsage };
            );  
            }
        }
    }  
        try (
import org.opensearch.cluster.node.DiscoveryNode;  
     */
            if (threadResourceInfo == null) {
        }  
            }  
        return coordinator.getVersion().onOrAfter(BINARY_RESOURCE_USAGE_HEADER_VERSION);
    public interface TaskCompletionListener {
    /**
        ClusterSettings clusterSettings,
                ? WriteableBase64.encode(taskResourceInfo)
     *                 thread  
import org.opensearch.common.xcontent.XContentHelper;
    // First OpenSearch version that emits and parses the Base64 binary form of the
     * 2. Adds Task Id in thread context to make sure it's available while task is processed across multiple threads.
    public boolean isTaskResourceTrackingEnabled() {  
        Setting.Property.Dynamic,
import org.opensearch.core.tasks.resourcetracker.ResourceUsageInfo;  
        for (ThreadResourceInfo threadResourceInfo : threadResourceInfos) {  
        );  
            return null;  
     * that resource usage from older data nodes is preserved during a rolling upgrade.
        if (clusterService == null) {  
        return storedContext;
import org.opensearch.common.util.concurrent.ConcurrentMapLong;  
        } catch (Exception e) {
    }
            try {  
import org.opensearch.ExceptionsHelper;  
            } catch (Exception e) {
    /**
                } else if (endValue.getStats() == ResourceStats.CPU) {  
     */
import org.opensearch.core.xcontent.DeprecationHandler;
     * @param taskId   of the task for which runnable is complete
    }
            Map<ResourceStats, ResourceUsageInfo.ResourceStatsInfo> startValues = threadResourceInfo.getResourceUsageInfo().getStatsInfo();
            logger.debug("Resource stats already updated.");
        return activeThreads;
            ThreadResourceInfo threadResourceInfo = task.getActiveThreadResourceInfo(
     */  
    }
                    )  
            }  
            return null;
     * Refreshes the resource stats for the tasks provided by looking into which threads are actively working on these
            logger.debug("Refreshing resource stats for Task: {}", resourceAwareTask.getId());
import org.opensearch.core.tasks.resourcetracker.ResourceStatsType;
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfos) {
        String coordinatorNodeId = task.getParentTaskId().getNodeId();  
/**  
        Settings settings,
        return taskResourceTrackingEnabled;
    public TaskResourceTrackingService(Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {
                Thread.currentThread().threadId(),
                new BytesArray(headerValue),
import org.opensearch.core.xcontent.XContentParser;
                if (endValue.getStats() == ResourceStats.MEMORY) {
     * Executes logic only if task supports resource tracking and resource tracking setting is enabled.
            try {
     * Stops tracking task registered earlier for tracking.
     * Tries the new Base64 binary format first; on failure falls back to the legacy JSON form so  
     * <p>
    // data nodes always emit the legacy JSON header. The consumer always falls back to JSON regardless.  
    public Map<Long, Task> getResourceAwareTasks() {
        "task_resource_tracking.enabled",  
            // Get resource usages from when the task started  
     * This happens when the thread executing the request logic itself calls the unregister method. So in this case unregister
import org.apache.logging.log4j.LogManager;  
            }  
    public void writeTaskResourceUsage(SearchShardTask task, String nodeId) {
                taskExecutionFinishedOnThread(task.getId(), Thread.currentThread().threadId());
        this.binaryResourceUsageHeaderEnabled = binaryResourceUsageHeaderEnabled;
     */  
            }  
    public boolean isTaskResourceTrackingSupported() {  
            threadMXBean.getThreadAllocatedBytes(threadId)
    }
    }
        try {
        }
     * Stashes the existing ThreadContext and preserves all the existing ThreadContext's data in the new ThreadContext
     *  
     * as well.  
        }
     * Adds Task Id in the ThreadContext.  
    /**  
     * and how much resources these have consumed till now.
import java.io.IOException;  
        ResourceUsageMetric currentCPUUsage = new ResourceUsageMetric(ResourceStats.CPU, threadMXBean.getThreadCpuTime(threadId));
    @Override
     * Remove the current task level resource usages.  
    public TaskResourceTrackingService(  
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);  
        return addTaskIdToThreadContext(task);
                return null;  
            return () -> {};
    // and will always emit the legacy JSON header. Forgoes the binary CPU win but is rolling-upgrade safe.  
        this(settings, clusterSettings, threadPool, null);
     * Listener that gets invoked when a task execution completes.
    private final ThreadPool threadPool;  
        return Collections.unmodifiableMap(resourceAwareTasks);
import org.opensearch.common.settings.Setting;  
    public void stopTracking(Task task) {  
        } catch (Exception e) {
        if (usage == null || usage.isEmpty()) {
     */
    );  
     * <p>  
                    activeThreads.add(threadResourceInfo.getThreadId());
    private boolean isCurrentThreadWorkingOnTask(Task task) {
        "task_resource_tracking.binary_header.enabled",
            if (task != null) {  
            TaskResourceInfo taskResourceInfo = new TaskResourceInfo.Builder().setAction(task.getAction())
            }  
                return;  
    public void setTaskResourceTrackingEnabled(boolean taskResourceTrackingEnabled) {
        try {
        this.threadPool = threadPool;
     * <p>
            );
        } catch (IllegalStateException e) {
 * compatible open source license.
    }
        for (List<ThreadResourceInfo> threadResourceInfos : task.getResourceStats().values()) {
    // Any unknown — kill-switch off, no ClusterService, empty parent task, coordinator missing from
        }
        return false;
     *  
     */
}
                        cpu - startValues.get(ResourceStats.CPU).getStartValue(),
                logger.debug("Task execution started on thread. Task: {}, Thread: {}", taskId, threadId);
            ResourceUsageMetric[] endValues = getResourceUsageMetricsForThread(Thread.currentThread().threadId());
 *
    // Returns true only with positive confirmation that the coordinator can parse the binary header.
     */
import org.opensearch.Version;
    private final ConcurrentMapLong<Task> resourceAwareTasks = ConcurrentCollections.newConcurrentMapLongWithAggressiveConcurrency();
            )
            return;
 * The OpenSearch Contributors require contributions made to  
        ) {
            logger.warn("Failed while trying to mark the task execution on current thread completed.", e);
        true,
        this.taskResourceTrackingEnabled = taskResourceTrackingEnabled;  
                task.startThreadResourceTracking(threadId, WORKER_STATS, getResourceUsageMetricsForThread(threadId));
        true,  
        try {
import org.opensearch.common.io.stream.WriteableBase64;
    public static final Setting<Boolean> BINARY_RESOURCE_USAGE_HEADER_ENABLED = Setting.boolSetting(
            XContentParser parser = XContentHelper.createParser(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;  
        ThreadContext.StoredContext storedContext = threadContext.newStoredContext(true, Collections.singletonList(TASK_ID));
    public static final String TASK_RESOURCE_USAGE = "TASK_RESOURCE_USAGE";
import java.util.Map;
        }  
            assert false;  
     * Get the current task level resource usage.
        if (coordinatorNodeId.isEmpty()) {
    }  
import org.opensearch.action.search.SearchShardTask;
    }
    private volatile boolean taskResourceTrackingEnabled;
        DiscoveryNode coordinator = clusterService.state().nodes().get(coordinatorNodeId);
            }
            // Build task resource usage info  
     * @return StoredContext reference to restore the ThreadContext from which we created a new one.  
        String usage = taskResourceUsages.get(0);
     * <p>  
     * <p>
    private ThreadContext.StoredContext addTaskIdToThreadContext(Task task) {  
    // bounded, while the cost of an unwarranted binary emission to an old coordinator is a hung search.
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
     */  
                .setNodeId(nodeId)
        Setting.Property.Dynamic,
        long threadId = Thread.currentThread().threadId();  
            for (ResourceUsageMetric endValue : endValues) {  
    public TaskResourceInfo getTaskResourceUsageFromThreadContext() {
    public void taskExecutionFinishedOnThread(long taskId, long threadId) {  
        }
     * It's also responsible to stop tracking the current thread's resources against this task if not already done.  
    static TaskResourceInfo deserializeFromJson(String headerValue) throws IOException {  
     * @param task task which has finished and doesn't need resource tracking.
                logger.debug("failed to parse task resource usage header (binary and JSON), skipping: ", jsonFailure);
@SuppressForbidden(reason = "ThreadMXBean#getThreadAllocatedBytes")  
        }
import org.opensearch.cluster.service.ClusterService;
                }
            List<Long> threadsWorkingOnTask = getThreadsWorkingOnTask(resourceAwareTask);  
        } catch (Exception binaryFailure) {
/*  
    static final Version BINARY_RESOURCE_USAGE_HEADER_VERSION = Version.V_3_8_0;  
    private final ClusterService clusterService;
        }
    }  
            logger.warn(new ParameterizedMessage("Failed to mark thread execution started for task: [{}]", taskId), e);
import org.opensearch.common.inject.Inject;  
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
     * Called when a thread starts working on a task's runnable.
    // TASK_RESOURCE_USAGE response header. Coordinators older than this only understand JSON.
    }
    }  
     * @param nodeId the local nodeId
        ThreadPool threadPool,  
    public void setBinaryResourceUsageHeaderEnabled(boolean binaryResourceUsageHeaderEnabled) {
        List<String> taskResourceUsages = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE);  
                        mem - startValues.get(ResourceStats.MEMORY).getStartValue()
    public ThreadContext.StoredContext startTracking(Task task) {
        }  
            return false;  
                    mem = endValue.getValue();
     *
    // Kill-switch for emitting the Base64 binary TASK_RESOURCE_USAGE response header. When false,
                    cpu = endValue.getValue();
        try {
    }
        Setting.Property.NodeScope
        logger.debug("Stopping resource tracking for task: {}", task.getId());
    /**
        ResourceUsageMetric currentMemoryUsage = new ResourceUsageMetric(  
     * Called when a thread finishes working on a task's runnable.  
        clusterSettings.addSettingsUpdateConsumer(BINARY_RESOURCE_USAGE_HEADER_ENABLED, this::setBinaryResourceUsageHeaderEnabled);
                .setTaskId(task.getId())
    }  
        this.taskResourceTrackingEnabled = TASK_RESOURCE_TRACKING_ENABLED.get(settings);  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
