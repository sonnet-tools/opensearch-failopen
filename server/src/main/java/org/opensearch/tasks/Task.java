        Long cancellationStartTime = null;
            new ConcurrentHashMap<>(),
     * This ensures that the number of active threads doesn't drop to zero pre-maturely.
     *
     * Build a proper {@link TaskInfo} for this task.
        TaskResourceStats resourceStats = null;
     */
     *
                // the active entry present in the list is updated
 * SPDX-License-Identifier: Apache-2.0
/**
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
            new TaskId(localNodeId, getId()),
     */
    /**
    }
     */
     * This method is used to update the resource consumption stats so that the data isn't too stale for long-running task.
        return taskInfo(localNodeId, description, status, resourceStats);
        return numActiveResourceTrackingThreads.incrementAndGet();
    }
            parentTask,
    }
                }
    }
     */
import org.opensearch.core.tasks.resourcetracker.TaskThreadUsage;
     * {@link org.opensearch.common.util.concurrent.OpenSearchExecutors#newResizable}
     * @param resourceUsageMetrics resource consumption metrics of the thread
    public Map<Long, List<ThreadResourceInfo>> getResourceStats() {
        if (detailed) {
import java.util.concurrent.ConcurrentHashMap;
        throw new IllegalStateException("cannot update if active thread resource entry is not present");
        if (numActiveResourceTrackingThreads.get() > 0) {
 * the Apache License, Version 2.0 (the "License"); you may
                }
                final ResourceUsageInfo.ResourceStatsInfo statsInfo = threadResourceInfo.getResourceUsageInfo().getStatsInfo().get(stats);
     * @param threadId ID of the thread
     * X-Request-Id: 19d538d7c42d09240be001d1e4ff6201
                final ResourceUsageInfo.ResourceStatsInfo statsInfo = threadResourceInfo.getResourceUsageInfo().getStatsInfo().get(stats);
        return null;
        if (threadResourceInfoList != null) {
     * this can never perform IO it might be a costly operation, requiring
     * @param detailed
     * Returns current total resource usage of the task.
     * Returns maximum per-execution resource consumption for a specific task stat.
        return startTimeNanos;
        String action,
    public final TaskInfo taskInfo(String localNodeId, boolean detailed) {
    }
    public boolean supportsResourceTracking() {
        if (threadResourceInfoList != null) {
    private final String description;
        List<NotifyOnceListener<Task>> resourceTrackingCompletionListeners
     * the response must have started prior to it (i.e. startThreadResourceTracking called before unregister).
     * Returns current min per-execution resource usage of the task.
                    } catch (Exception e2) {
     */
    public Task(
    public TaskResourceUsage getAverageResourceStats() {
     * Since a task is unregistered after the message is processed, it implies that the threads responsible to produce
                }
     * Report of the internal status of a task. These can vary wildly from task
import org.opensearch.core.tasks.resourcetracker.ResourceUsageInfo;
 * this file be licensed under the Apache-2.0 license or a
        this.description = description;
    protected final TaskInfo taskInfo(String localNodeId, String description, Status status, TaskResourceStats resourceStats) {
     * The task's start time as a relative time ({@link System#nanoTime()} style).
    /**
    }
            resourceTrackingCompletionListeners.add(listener);
    }
    private static final String AVERAGE = "average";
        return new TaskResult(taskInfo(nodeId, true, true), error);
     * tracking can be stopped for this task.
 * Current task information
        TaskId parentTask,
        Map<String, String> headers,
        this.startTime = startTime;
    private long getAverageResourceUtilization(ResourceStats stats) {
        return startTime;
    /**
    /**
        this.resourceStats = resourceStats;
 */
     */
    /**
                }
     * is called exactly once on all registered listeners.
                try {
     * The request header to mark tasks with specific ids
    }
                if (threadResourceInfo.getStatsType().isOnlyForAnalysis() == false && statsInfo != null) {
            }
            getAction(),
     *
     */
    private long getMaxResourceUtilization(ResourceStats stats) {
     * Returns task action
     * Returns minimum per-execution resource consumption for a specific task stat.
 * this work for additional information regarding copyright
    private static final String MIN = "min";
import java.util.Collections;
    /**
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfosList) {
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfoList) {
     * Record the thread's final resource consumption values.
import org.opensearch.core.tasks.resourcetracker.ResourceUsageMetric;
            description,
     */
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfoList) {
        if (excludeStats == false) {
    }
                } catch (Exception e1) {
    }
                    "unexpected active thread resource entry present [" + threadId + "]:[" + threadResourceInfo + "]"
    /**
     * to the user.
    public static final String X_OPAQUE_ID = "X-Opaque-Id";
        return action;
        return description;
                throw new IllegalStateException(
                        listenerExceptions.add(e2);
     * Returns task channel type (netty, transport, direct)
        this.action = action;
     * <p>
import org.opensearch.ExceptionsHelper;
                final ResourceUsageInfo.ResourceStatsInfo statsInfo = threadResourceInfo.getResourceUsageInfo().getStatsInfo().get(stats);
import org.opensearch.core.tasks.TaskId;
public class Task {
                    threadResourceInfo.recordResourceUsageMetrics(resourceUsageMetrics);
    public String getAction() {
            }
     * <p>
        int numThreadExecutions = 0;
 *
    private static final String MAX = "max";
        return new TaskInfo(
        }
        this.resourceTrackingCompletionListeners = resourceTrackingCompletionListeners;
    private final Map<Long, List<ThreadResourceInfo>> resourceStats;
import java.util.List;
        }
            }, getThreadUsage());
            }
            getType(),
        this.startTimeNanos = startTimeNanos;
     * @param excludeStats should information exclude resource stats.
                {
            return true;
        final List<ThreadResourceInfo> threadResourceInfoList = resourceStats.computeIfAbsent(threadId, k -> new ArrayList<>());
        }
     * @opensearch.api
    /**
     *                     In the future, task-index-mapping.json can be modified to add resource stats.
     * This method is called when threads finish execution, and also when the task is unregistered (to mark the task's
            System.nanoTime() - startTimeNanos,
     *            the id of the node this task is running on
    /**
                }
     * Increments the number of active resource tracking threads.
    private final List<NotifyOnceListener<Task>> resourceTrackingCompletionListeners;
        // active thread entry should not be present in the list
 * not use this file except in compliance with the License.
    }
            description,
    }
 *
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
        long startTime,
        if (resourceStats.size() == 0) {
    }
     */
import org.opensearch.common.annotation.PublicApi;
    /**
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
     * with the response, any thread usage info captured after the task is unregistered may be irrelevant.
    ) {
                if (threadResourceInfo.getStatsType().isOnlyForAnalysis() == false && statsInfo != null) {
        long totalResourceConsumption = 0L;
                    put(TOTAL, getTotalResourceStats());
    }
     * Returns the task's start time as a wall clock time since epoch ({@link System#currentTimeMillis()} style).
            ExceptionsHelper.maybeThrowRuntimeAndSuppress(listenerExceptions);
     *
 */
     * Returns thread level resource consumption of the task
        int threadResourceInfoCount = 0;
        return id;
     * @param localNodeId
    /**
     * Individual tasks can override this if they want to support task resource tracking. We just need to make sure that
        }
            resourceStats = new TaskResourceStats(new HashMap<>() {
        return new TaskResourceUsage(getMinResourceUtilization(ResourceStats.CPU), getMinResourceUtilization(ResourceStats.MEMORY));
import org.opensearch.core.tasks.resourcetracker.ResourceStatsType;
                    activeThreads++;
     */
        int count = numActiveResourceTrackingThreads.decrementAndGet();
    public TaskThreadUsage getThreadUsage() {
        }
     *
        final List<ThreadResourceInfo> threadResourceInfoList = resourceStats.get(threadId);
                );
    }
        }
 * Modifications Copyright OpenSearch Contributors. See
                final ResourceUsageInfo.ResourceStatsInfo statsInfo = threadResourceInfo.getResourceUsageInfo().getStatsInfo().get(stats);
    public String getType() {
                if (threadResourceInfo.getStatsType() == statsType && threadResourceInfo.isActive()) {
        return null;
            }
                if (threadResourceInfo.isActive()) {
     *                     But inorder to avoid storing resource stats into task index as strict mapping is enforced and breaks when adding this field.
    }
            cancellationStartTime
    /**
 */
        this(
import java.util.Map;
        }
                if (threadResourceInfo.getStatsType().isOnlyForAnalysis() == false && statsInfo != null) {
    }
import org.opensearch.core.xcontent.ToXContent;
    public int decrementResourceTrackingThreads() {
     * Rarely, some threads may even start execution after the task is unregistered. As resource stats are piggy-backed
    }
    /**
    public boolean addResourceTrackingCompletionListener(NotifyOnceListener<Task> listener) {
import java.io.IOException;
import java.util.HashMap;
        for (List<ThreadResourceInfo> threadResourceInfosList : resourceStats.values()) {
    /**
            resourceTrackingCompletionListeners.forEach(listener -> {
    public long getStartTime() {
     * to keep each task consistent from version to version where possible.
 * @opensearch.api
    public long getTotalResourceUtilization(ResourceStats stats) {
            List<Exception> listenerExceptions = new ArrayList<>();
        threadResourceInfoList.add(new ThreadResourceInfo(threadId, statsType, resourceUsageMetrics));
     */
    }
     * Decrements the number of active resource tracking threads.
     * with the option to include resource stats or not.
                }
     * Adds thread's starting resource consumption information
    public long getStartTimeNanos() {
    /**
     * This header uniquely identifies a request and can be used by users to track it, for example in logs such as slow logs.
     * @throws IllegalStateException if no matching active thread entry was found.
        return false;
        return parentTask;
     * be possible to preserve backwards compatibility. In that case, we
        }
 * The OpenSearch Contributors require contributions made to
        return taskInfo(localNodeId, description, status, null);
        }
    public void stopThreadResourceTracking(long threadId, ResourceStatsType statsType, ResourceUsageMetric... resourceUsageMetrics) {
     */
        if (cancelled) {
     */
        this.headers = headers;
import org.opensearch.core.action.NotifyOnceListener;
     */
        for (List<ThreadResourceInfo> threadResourceInfosList : resourceStats.values()) {
    }
    public int incrementResourceTrackingThreads() {
import org.opensearch.core.action.ActionResponse;
    private long getMinResourceUtilization(ResourceStats stats) {
    /**
                    minResourceConsumption = Math.min(minResourceConsumption, statsInfo.getTotalValue());
     */
            }
                    try {
     * Build a status for this task or null if this task doesn't have status.
     */
    }
     *
    /**
    }
            return 0L;
     * to task because each task is implemented differently but we should try
                    threadResourceInfo.setActive(false);
import java.util.Set;
    public Status getStatus() {
     *
     * result. But if we change the way a request is implemented it might not
    /**
            parentTask,
 * compatible open source license.
    private final long startTimeNanos;
     * @throws IllegalStateException if no matching active thread entry was found.
                    }
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfoList) {
     * @param resourceUsageMetrics resource consumption metrics of the thread
            action,
     * they are used by systems like Kibana.
                if (threadResourceInfo.getStatsType() == statsType && threadResourceInfo.isActive()) {
            throw new IllegalStateException("response has to implement ToXContent to be able to store the results");
     */
    /**
    /**
     * Returns task id
        return maxResourceConsumption;
    public TaskResourceUsage getMaxResourceStats() {
 * You may obtain a copy of the License at
    }
 * Unless required by applicable law or agreed to in writing,
    }
    /**
        incrementResourceTrackingThreads();
 * Licensed to Elasticsearch under one or more contributor
     * @param threadId ID of the thread
    private final String action;
    /**
    private final long id;
            type,
        return new TaskResourceUsage(getTotalResourceUtilization(ResourceStats.CPU), getTotalResourceUtilization(ResourceStats.MEMORY));
     * Returns average per-execution resource consumption for a specific task stat.
        }
    /**
     */
                    totalResourceConsumption += statsInfo.getTotalValue();
    }
        long startTimeNanos,
     * Returns id of the parent task or NO_PARENT_ID if the task doesn't have any parent tasks
            }
            numThreadExecutions += threadResourceInfosList.size();
     * Since most tasks don't have status this defaults to returning null. While
     * @param statsType stats type
    }
     * Registers a task resource tracking completion listener on this task if resource tracking is still active.
    public String getDescription() {
            }
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfosList) {
    private final AtomicInteger numActiveResourceTrackingThreads = new AtomicInteger(1);
                    threadResourceInfoCount++;
     * <b>can</b> change this on version upgrade but we should be careful
     * collating lists of results, etc. So only use it if you need the value.
 * ownership. Elasticsearch licenses this file to you under
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
    @PublicApi(since = "1.0.0")
            System.currentTimeMillis(),
        if (response instanceof ToXContent toXContent) {
     * should avoid making backwards incompatible changes to the rendered
            System.nanoTime(),
    }
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfosList) {
    public ThreadResourceInfo getActiveThreadResourceInfo(long threadId, ResourceStatsType statsType) {
     * In the future, these values can be cached as an optimization.
    public Task(long id, String type, String action, String description, TaskId parentTask, Map<String, String> headers) {
    }
                    return threadResourceInfo;
     */
                }
     * own thread as complete). When the active thread count becomes zero, the onTaskResourceTrackingCompleted method
     */
     */
     * Generates task description
     * Build a version of the task status you can throw over the wire and back
                }
     */
     * @param threadId ID of the thread
    /**
    /**
        for (List<ThreadResourceInfo> threadResourceInfosList : resourceStats.values()) {
            if (threadResourceInfo.getStatsType() == statsType && threadResourceInfo.isActive()) {
     */
        this.type = type;
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
     */
 * specific language governing permissions and limitations
        return taskInfo(localNodeId, detailed, detailed == false);
     */
        }
    /**
        return headers.get(header);
     */
     *            should the information include detailed, potentially slow to
        return new TaskThreadUsage(numThreadExecutions, activeThreads);
        return false;
        String description,
     * Format: 32-character hexadecimal
    public long getId() {
     * Returns the total and active number of thread executions for the task.
     * the task's own/self thread. When this value becomes 0, all threads have been marked inactive and the resource
    public TaskId getParentTaskId() {
     * That means each implementation of {@linkplain Task.Status#toXContent}
    private final String type;
     */
                if (threadResourceInfo.getStatsType() == statsType && threadResourceInfo.isActive()) {
        return (threadResourceInfoCount > 0) ? totalResourceConsumption / threadResourceInfoCount : 0;
    private static final String TOTAL = "total";
     * If active thread entry is present in the list, the entry is updated. If one is not found, it throws an exception.
     *            generate data?
     *                     By default, detailed flag is used to control including resource information.
        if (count == 0) {
     */
     * Build a {@link TaskInfo} for this task without resource stats.
        } else {
    /**
        return new TaskResourceUsage(getAverageResourceUtilization(ResourceStats.CPU), getAverageResourceUtilization(ResourceStats.MEMORY));
     */
        long minResourceConsumption = Long.MAX_VALUE;
 *
        );
     * @return the number of active resource tracking threads.
     * Example:
        Task.Status status = null;
            this instanceof CancellableTask,
    public interface Status extends ToXContentObject, NamedWriteable {}
        String description = null;
/*
        }
    private final long startTime;
     * Returns the task's start time in nanoseconds ({@link System#nanoTime()} style).
            }
            headers,
 * under the License.
        return new TaskResourceUsage(getMaxResourceUtilization(ResourceStats.CPU), getMaxResourceUtilization(ResourceStats.MEMORY));
                    listener.onResponse(this);
     * Keeps track of the number of active resource tracking threads for this task. It is initialized to 1 to track
        for (ThreadResourceInfo threadResourceInfo : threadResourceInfoList) {
/*
        ConcurrentHashMap<Long, List<ThreadResourceInfo>> resourceStats,
                if (threadResourceInfo.getStatsType().isOnlyForAnalysis() == false && statsInfo != null) {
                    decrementResourceTrackingThreads();
    protected final TaskInfo taskInfo(String localNodeId, String description, Status status) {
     * @return true if resource tracking is supported by the task
    private TaskInfo taskInfo(String localNodeId, boolean detailed, boolean excludeStats) {
        long maxResourceConsumption = 0L;
    public TaskResourceUsage getTotalResourceStats() {
    }
        final List<ThreadResourceInfo> threadResourceInfoList = resourceStats.get(threadId);
    /**
}
    /**
            }
                    put(MIN, getMinResourceStats());
    }
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
     */
 * KIND, either express or implied.  See the License for the
     * The task's start time as a wall clock time since epoch ({@link System#currentTimeMillis()} style).
                }
            cancellationStartTime = ((CancellableTask) this).getCancellationStartTime();
                    return;
    /**
        );
            description = getDescription();
            cancelled,
        }
        return totalResourceConsumption;
    public void startThreadResourceTracking(long threadId, ResourceStatsType statsType, ResourceUsageMetric... resourceUsageMetrics) {
        return minResourceConsumption;
                        listener.onFailure(e1);
    /**
        long id,
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfosList) {
        if (threadResourceInfoList != null) {
    /**
/*
                    put(AVERAGE, getAverageResourceStats());
        for (List<ThreadResourceInfo> threadResourceInfosList : resourceStats.values()) {
     * @param statsType stats type
    public TaskResourceUsage getMinResourceStats() {
    public String getHeader(String header) {
     * @throws IllegalStateException matching active thread entry was found which is not expected.
     * @return the number of active resource tracking threads.
                    threadResourceInfo.recordResourceUsageMetrics(resourceUsageMetrics);
    public TaskResult result(final String nodeId, Exception error) throws IOException {
        return count;
     * Build a version of the task status you can throw over the wire and back
                    totalResourceConsumption += statsInfo.getTotalValue();
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfosList) {
                }
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;
     * Returns true on successful subscription, false otherwise.
            });
        return Collections.unmodifiableMap(resourceStats);
     * Returns current average per-execution resource usage of the task.
    public TaskResult result(final String nodeId, ActionResponse response) throws IOException {
    }
        long totalResourceConsumption = 0L;
                    put(MAX, getMaxResourceStats());
        }
     * the ThreadPool on which the task runs on have runnable wrapper similar to
    private final Map<String, String> headers;
import org.opensearch.core.common.io.stream.NamedWriteable;
        }
                    maxResourceConsumption = Math.max(maxResourceConsumption, statsInfo.getTotalValue());
     * Returns stored task header associated with the task
            id,
    /**
            status = getStatus();
     * @param resourceUsageMetrics resource consumption metrics of the thread
        throw new IllegalStateException("cannot update final values if active thread resource entry is not present");
     */
import java.util.concurrent.atomic.AtomicInteger;
    }
    /**
 * GitHub history for details.
            startTime,
     */
            return new TaskResult(taskInfo(nodeId, true, true), toXContent);
            headers,
                    return;
    public static final Set<String> REQUEST_HEADERS = Set.of(Task.X_OPAQUE_ID, Task.X_REQUEST_ID);
package org.opensearch.tasks;
    }
    }
    public void updateThreadResourceStats(long threadId, ResourceStatsType statsType, ResourceUsageMetric... resourceUsageMetrics) {
@PublicApi(since = "1.0.0")
            new ArrayList<>()
        for (List<ThreadResourceInfo> threadResourceInfosList : resourceStats.values()) {
        String type,
import java.util.ArrayList;
 *
        return type;
            status,
        final List<ThreadResourceInfo> threadResourceInfoList = resourceStats.get(threadId);
     * Currently, this method is only called on demand, during get and listing of tasks.
     * because some statuses (reindex) have become defacto standardized because
     * This method is only used during creating TaskResult to avoid storing resource information into the task index.
    /**
        this.parentTask = parentTask;
     * Returns current max per-execution resource usage of the task.
     *
            resourceStats,
    private final TaskId parentTask;
        boolean cancelled = this instanceof CancellableTask cancellableTask && cancellableTask.isCancelled();
        int activeThreads = 0;
     * @param statsType stats type
    }
        }
        this.id = id;
 */
    public static final String X_REQUEST_ID = "X-Request-Id";
     */
     * Returns total resource consumption for a specific task stat.
     */
     * If active thread entry is present in the list, the entry is updated. If one is not found, it throws an exception.
     *
import org.opensearch.core.xcontent.ToXContentObject;
