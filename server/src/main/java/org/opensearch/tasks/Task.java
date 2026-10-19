            action,
    /**
     * Individual tasks can override this if they want to support task resource tracking. We just need to make sure that
     */  
     */
                    threadResourceInfo.recordResourceUsageMetrics(resourceUsageMetrics);
    }
     * Returns thread level resource consumption of the task
import java.util.List;
     * @param resourceUsageMetrics resource consumption metrics of the thread
                {
        }
     *                     In the future, task-index-mapping.json can be modified to add resource stats.
     */
     * @param resourceUsageMetrics resource consumption metrics of the thread  
/*  
    }
                    threadResourceInfo.recordResourceUsageMetrics(resourceUsageMetrics);  
        String description,
        return null;  
     *            should the information include detailed, potentially slow to
     */
    /**
            new TaskId(localNodeId, getId()),  
 * software distributed under the License is distributed on an
     * This ensures that the number of active threads doesn't drop to zero pre-maturely.
    private long getMaxResourceUtilization(ResourceStats stats) {  
        return startTime;  
     * @opensearch.api
            resourceStats = new TaskResourceStats(new HashMap<>() {
    public TaskResult result(final String nodeId, Exception error) throws IOException {
    }
    public boolean supportsResourceTracking() {
                    "unexpected active thread resource entry present [" + threadId + "]:[" + threadResourceInfo + "]"
    /**
        }
    }
            if (threadResourceInfo.getStatsType() == statsType && threadResourceInfo.isActive()) {
     */
     * result. But if we change the way a request is implemented it might not
        return action;
                final ResourceUsageInfo.ResourceStatsInfo statsInfo = threadResourceInfo.getResourceUsageInfo().getStatsInfo().get(stats);
                // the active entry present in the list is updated  
        // active thread entry should not be present in the list  
import org.opensearch.core.xcontent.ToXContentObject;
    }
            }
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
                throw new IllegalStateException(  
     * Generates task description
    }  
    public TaskResourceUsage getMinResourceStats() {
     * <p>  
    /**
    }
 */
     * The request header to mark tasks with specific ids  
    public Task(
    }
    /**
        }  
     * Returns stored task header associated with the task
 */
    public long getId() {
     */  
     * Registers a task resource tracking completion listener on this task if resource tracking is still active.  
    public String getDescription() {
                        listener.onFailure(e1);
     * own thread as complete). When the active thread count becomes zero, the onTaskResourceTrackingCompleted method  
    public boolean addResourceTrackingCompletionListener(NotifyOnceListener<Task> listener) {  
    }  
        int threadResourceInfoCount = 0;
        final List<ThreadResourceInfo> threadResourceInfoList = resourceStats.get(threadId);
    /**
     * This method is only used during creating TaskResult to avoid storing resource information into the task index.  
    private final String type;  
            description = getDescription();  
        }
     */
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
     *
    /**
    public TaskResourceUsage getTotalResourceStats() {  
                    decrementResourceTrackingThreads();
     * If active thread entry is present in the list, the entry is updated. If one is not found, it throws an exception.
     *
        this.headers = headers;
                    put(MAX, getMaxResourceStats());  
 * compatible open source license.
     * the task's own/self thread. When this value becomes 0, all threads have been marked inactive and the resource
     * Keeps track of the number of active resource tracking threads for this task. It is initialized to 1 to track  
                }  
 *
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;  
     * collating lists of results, etc. So only use it if you need the value.  
        if (count == 0) {  
                );
 *
     * Returns the task's start time in nanoseconds ({@link System#nanoTime()} style).
        long startTimeNanos,
        if (threadResourceInfoList != null) {
    public TaskThreadUsage getThreadUsage() {
 * this work for additional information regarding copyright
import org.opensearch.core.tasks.TaskId;  
import org.opensearch.core.action.NotifyOnceListener;
     * @param statsType stats type
        long totalResourceConsumption = 0L;  
     * @param threadId ID of the thread
        for (List<ThreadResourceInfo> threadResourceInfosList : resourceStats.values()) {
        return numActiveResourceTrackingThreads.incrementAndGet();  
    /**
 * SPDX-License-Identifier: Apache-2.0
    public Task(long id, String type, String action, String description, TaskId parentTask, Map<String, String> headers) {
        if (resourceStats.size() == 0) {  
 */  
     * @return true if resource tracking is supported by the task
        List<NotifyOnceListener<Task>> resourceTrackingCompletionListeners
            getAction(),
        Long cancellationStartTime = null;
                }  
            cancellationStartTime  
     * Increments the number of active resource tracking threads.
     * Returns total resource consumption for a specific task stat.
                    listener.onResponse(this);
        return taskInfo(localNodeId, description, status, null);
     * is called exactly once on all registered listeners.
            id,  
@PublicApi(since = "1.0.0")  
     * @return the number of active resource tracking threads.  
        return taskInfo(localNodeId, description, status, resourceStats);
        int count = numActiveResourceTrackingThreads.decrementAndGet();
    private final String description;
     */
     * @throws IllegalStateException if no matching active thread entry was found.
            type,
        return count;
            cancelled,
    }
    private final long id;
     * Adds thread's starting resource consumption information
import org.opensearch.common.annotation.PublicApi;
                    }
            });  
                    minResourceConsumption = Math.min(minResourceConsumption, statsInfo.getTotalValue());
     * Since a task is unregistered after the message is processed, it implies that the threads responsible to produce  
 * this file be licensed under the Apache-2.0 license or a
     *                     But inorder to avoid storing resource stats into task index as strict mapping is enforced and breaks when adding this field.
     *
            List<Exception> listenerExceptions = new ArrayList<>();
        return minResourceConsumption;  
    private final long startTime;  
    }
        this.resourceTrackingCompletionListeners = resourceTrackingCompletionListeners;
     */  
    }
        }
    }
        for (ThreadResourceInfo threadResourceInfo : threadResourceInfoList) {
    }
     *
    }
    /**  
                }
    /**
    @PublicApi(since = "1.0.0")
        return description;
     * Returns current total resource usage of the task.
        return new TaskResult(taskInfo(nodeId, true, true), error);  
        threadResourceInfoList.add(new ThreadResourceInfo(threadId, statsType, resourceUsageMetrics));
    private static final String AVERAGE = "average";
            numThreadExecutions += threadResourceInfosList.size();
     * to keep each task consistent from version to version where possible.
            headers,
     * @param statsType stats type
    public Map<Long, List<ThreadResourceInfo>> getResourceStats() {  
        String action,
        if (excludeStats == false) {  
     * Example:  
     * @param resourceUsageMetrics resource consumption metrics of the thread
                    } catch (Exception e2) {
     */  
    ) {  
     */
 */  
                    threadResourceInfoCount++;
     * X-Request-Id: 19d538d7c42d09240be001d1e4ff6201
    /**
     * the response must have started prior to it (i.e. startThreadResourceTracking called before unregister).
     */  
        return null;  
     * Returns task action
import org.opensearch.core.tasks.resourcetracker.ResourceStatsType;
        TaskId parentTask,  
        } else {  
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfoList) {  
    public TaskResult result(final String nodeId, ActionResponse response) throws IOException {  
     * Format: 32-character hexadecimal
                    put(TOTAL, getTotalResourceStats());  
        );
    }
        return new TaskThreadUsage(numThreadExecutions, activeThreads);  
     *
        this.type = type;
 * Licensed to Elasticsearch under one or more contributor  
        int activeThreads = 0;  
     *            the id of the node this task is running on  
            }
                if (threadResourceInfo.getStatsType() == statsType && threadResourceInfo.isActive()) {
        return false;  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
        }
        return parentTask;
     */
     * <p>
    private TaskInfo taskInfo(String localNodeId, boolean detailed, boolean excludeStats) {
     */
     */
    private long getMinResourceUtilization(ResourceStats stats) {
    }  
    public static final String X_OPAQUE_ID = "X-Opaque-Id";
     * Record the thread's final resource consumption values.
 * GitHub history for details.
    /**  
     * @param localNodeId
    }
     * Build a version of the task status you can throw over the wire and back
    /**
     * <b>can</b> change this on version upgrade but we should be careful
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfosList) {  
 *  
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfosList) {  
    /**  
        if (response instanceof ToXContent toXContent) {
        this.parentTask = parentTask;
        }
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfosList) {
     * In the future, these values can be cached as an optimization.
                }
     * This method is used to update the resource consumption stats so that the data isn't too stale for long-running task.
     * to the user.  
                if (threadResourceInfo.getStatsType() == statsType && threadResourceInfo.isActive()) {
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfosList) {
     */
    /**
    public TaskId getParentTaskId() {
     *
                final ResourceUsageInfo.ResourceStatsInfo statsInfo = threadResourceInfo.getResourceUsageInfo().getStatsInfo().get(stats);
     * If active thread entry is present in the list, the entry is updated. If one is not found, it throws an exception.  
        String description = null;
import org.opensearch.core.common.io.stream.NamedWriteable;
    }
        long minResourceConsumption = Long.MAX_VALUE;  
            return 0L;
        return taskInfo(localNodeId, detailed, detailed == false);  
    }
    /**
import java.util.ArrayList;
        }
    }
    public TaskResourceUsage getAverageResourceStats() {
     * Returns current max per-execution resource usage of the task.
        return totalResourceConsumption;
    public Status getStatus() {
    private final Map<Long, List<ThreadResourceInfo>> resourceStats;
     */
     * Build a proper {@link TaskInfo} for this task.  
            this instanceof CancellableTask,
     */
            cancellationStartTime = ((CancellableTask) this).getCancellationStartTime();  
    /**  
    }  
    /**
        int numThreadExecutions = 0;
            System.currentTimeMillis(),
            status,
            }  
}  
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfosList) {  
    private final AtomicInteger numActiveResourceTrackingThreads = new AtomicInteger(1);
    }
        long totalResourceConsumption = 0L;
     * they are used by systems like Kibana.  
     * tracking can be stopped for this task.
 * license agreements. See the NOTICE file distributed with
    public static final Set<String> REQUEST_HEADERS = Set.of(Task.X_OPAQUE_ID, Task.X_REQUEST_ID);  
        return false;
                    return threadResourceInfo;
            startTime,
     * this can never perform IO it might be a costly operation, requiring
     *            generate data?  
                } catch (Exception e1) {
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;
    /**
        this(
     * Report of the internal status of a task. These can vary wildly from task  
    /**  
 * not use this file except in compliance with the License.
     */  
    }  
     * Returns the task's start time as a wall clock time since epoch ({@link System#currentTimeMillis()} style).  
    public void startThreadResourceTracking(long threadId, ResourceStatsType statsType, ResourceUsageMetric... resourceUsageMetrics) {
                if (threadResourceInfo.isActive()) {
        }
import org.opensearch.core.tasks.resourcetracker.ResourceUsageInfo;  
            parentTask,  
        return id;
import java.util.concurrent.atomic.AtomicInteger;
 * Current task information
    private final TaskId parentTask;  
        }
import org.opensearch.core.tasks.resourcetracker.TaskThreadUsage;
    public final TaskInfo taskInfo(String localNodeId, boolean detailed) {
     * Rarely, some threads may even start execution after the task is unregistered. As resource stats are piggy-backed
        }  
     */  
        TaskResourceStats resourceStats = null;
            new ConcurrentHashMap<>(),
     * Currently, this method is only called on demand, during get and listing of tasks.  
        if (threadResourceInfoList != null) {
        return new TaskResourceUsage(getTotalResourceUtilization(ResourceStats.CPU), getTotalResourceUtilization(ResourceStats.MEMORY));
        for (List<ThreadResourceInfo> threadResourceInfosList : resourceStats.values()) {
     * Returns task channel type (netty, transport, direct)  
                }
                }  
        ConcurrentHashMap<Long, List<ThreadResourceInfo>> resourceStats,
            description,  
    public void updateThreadResourceStats(long threadId, ResourceStatsType statsType, ResourceUsageMetric... resourceUsageMetrics) {
            resourceTrackingCompletionListeners.add(listener);
     * @throws IllegalStateException if no matching active thread entry was found.  
                final ResourceUsageInfo.ResourceStatsInfo statsInfo = threadResourceInfo.getResourceUsageInfo().getStatsInfo().get(stats);  
public class Task {
    protected final TaskInfo taskInfo(String localNodeId, String description, Status status) {
            System.nanoTime() - startTimeNanos,  
     * Returns minimum per-execution resource consumption for a specific task stat.  
/**
        this.action = action;  
    /**
        return type;  
     */
     * @param excludeStats should information exclude resource stats.
     * @param statsType stats type  
     * The task's start time as a relative time ({@link System#nanoTime()} style).  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
    public long getStartTimeNanos() {  
import java.util.concurrent.ConcurrentHashMap;
    }
                        listenerExceptions.add(e2);  
            }  
     */  
import org.opensearch.core.tasks.resourcetracker.ResourceUsageMetric;
 * KIND, either express or implied.  See the License for the
        this.id = id;
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfoList) {
        final List<ThreadResourceInfo> threadResourceInfoList = resourceStats.get(threadId);
                    threadResourceInfo.setActive(false);
            resourceStats,
                }
        return headers.get(header);
        return (threadResourceInfoCount > 0) ? totalResourceConsumption / threadResourceInfoCount : 0;
     * with the option to include resource stats or not.
     */
     * Build a status for this task or null if this task doesn't have status.  
     * This method is called when threads finish execution, and also when the task is unregistered (to mark the task's
        boolean cancelled = this instanceof CancellableTask cancellableTask && cancellableTask.isCancelled();  
     * This header uniquely identifies a request and can be used by users to track it, for example in logs such as slow logs.
            parentTask,
            throw new IllegalStateException("response has to implement ToXContent to be able to store the results");
    public ThreadResourceInfo getActiveThreadResourceInfo(long threadId, ResourceStatsType statsType) {  
 * under the License.  
    protected final TaskInfo taskInfo(String localNodeId, String description, Status status, TaskResourceStats resourceStats) {
        return new TaskResourceUsage(getMinResourceUtilization(ResourceStats.CPU), getMinResourceUtilization(ResourceStats.MEMORY));  
     */  
    /**  
            new ArrayList<>()  
    }  
            System.nanoTime(),  
 * specific language governing permissions and limitations
    public String getHeader(String header) {
    /**
        Task.Status status = null;  
        return maxResourceConsumption;
    private final List<NotifyOnceListener<Task>> resourceTrackingCompletionListeners;  
     */
        return new TaskInfo(
    private final String action;
import org.opensearch.ExceptionsHelper;
                if (threadResourceInfo.getStatsType().isOnlyForAnalysis() == false && statsInfo != null) {
     * the ThreadPool on which the task runs on have runnable wrapper similar to
        if (numActiveResourceTrackingThreads.get() > 0) {
     * with the response, any thread usage info captured after the task is unregistered may be irrelevant.
    private static final String MIN = "min";  
     */  
        return new TaskResourceUsage(getAverageResourceUtilization(ResourceStats.CPU), getAverageResourceUtilization(ResourceStats.MEMORY));
     */
            resourceTrackingCompletionListeners.forEach(listener -> {
package org.opensearch.tasks;
     * be possible to preserve backwards compatibility. In that case, we  
     * Returns id of the parent task or NO_PARENT_ID if the task doesn't have any parent tasks
    private static final String TOTAL = "total";
                    totalResourceConsumption += statsInfo.getTotalValue();  
                    totalResourceConsumption += statsInfo.getTotalValue();
import java.util.Collections;
     * Returns current min per-execution resource usage of the task.  
                if (threadResourceInfo.getStatsType().isOnlyForAnalysis() == false && statsInfo != null) {  
            headers,
/*
            description,  
            for (ThreadResourceInfo threadResourceInfo : threadResourceInfoList) {  
     * Returns current average per-execution resource usage of the task.
     *                     By default, detailed flag is used to control including resource information.  
            }
import org.opensearch.core.xcontent.ToXContent;  
    public long getTotalResourceUtilization(ResourceStats stats) {
     * to task because each task is implemented differently but we should try
     */  
    }  
     */
        long maxResourceConsumption = 0L;
            return new TaskResult(taskInfo(nodeId, true, true), toXContent);
    public static final String X_REQUEST_ID = "X-Request-Id";
        this.startTime = startTime;  
/*  
                    maxResourceConsumption = Math.max(maxResourceConsumption, statsInfo.getTotalValue());  
        }
    public int decrementResourceTrackingThreads() {  
     * Since most tasks don't have status this defaults to returning null. While
     * @throws IllegalStateException matching active thread entry was found which is not expected.
     * @param threadId ID of the thread  
        String type,  
     */
     * @return the number of active resource tracking threads.
    /**  
     */
                    return;  
        if (threadResourceInfoList != null) {
            return true;  
    /**
     * @param detailed
            }
import org.opensearch.core.action.ActionResponse;  
    public int incrementResourceTrackingThreads() {
     * Returns maximum per-execution resource consumption for a specific task stat.
    }
                    activeThreads++;
        return startTimeNanos;
    private final Map<String, String> headers;
     * {@link org.opensearch.common.util.concurrent.OpenSearchExecutors#newResizable}  
        for (List<ThreadResourceInfo> threadResourceInfosList : resourceStats.values()) {
        return new TaskResourceUsage(getMaxResourceUtilization(ResourceStats.CPU), getMaxResourceUtilization(ResourceStats.MEMORY));
        }
    /**
    /**
    }
     * Decrements the number of active resource tracking threads.
    }
    public long getStartTime() {
    /**  
        }
        this.description = description;
        long id,
            status = getStatus();
    private final long startTimeNanos;
    }
            }  
    }
     * The task's start time as a wall clock time since epoch ({@link System#currentTimeMillis()} style).
        long startTime,
        throw new IllegalStateException("cannot update if active thread resource entry is not present");
        throw new IllegalStateException("cannot update final values if active thread resource entry is not present");  
    public String getAction() {  
                    return;
        for (List<ThreadResourceInfo> threadResourceInfosList : resourceStats.values()) {  
import java.io.IOException;  
                final ResourceUsageInfo.ResourceStatsInfo statsInfo = threadResourceInfo.getResourceUsageInfo().getStatsInfo().get(stats);
            getType(),
                if (threadResourceInfo.getStatsType().isOnlyForAnalysis() == false && statsInfo != null) {
    public void stopThreadResourceTracking(long threadId, ResourceStatsType statsType, ResourceUsageMetric... resourceUsageMetrics) {  
    }  
        return Collections.unmodifiableMap(resourceStats);
    public interface Status extends ToXContentObject, NamedWriteable {}
 * You may obtain a copy of the License at  
            }
    private static final String MAX = "max";
    private long getAverageResourceUtilization(ResourceStats stats) {
import java.util.Set;  
    /**
     * That means each implementation of {@linkplain Task.Status#toXContent}  
        }
        final List<ThreadResourceInfo> threadResourceInfoList = resourceStats.computeIfAbsent(threadId, k -> new ArrayList<>());
     *  
     */  
    /**  
     * Returns true on successful subscription, false otherwise.
     * Build a {@link TaskInfo} for this task without resource stats.
        final List<ThreadResourceInfo> threadResourceInfoList = resourceStats.get(threadId);  
 * The OpenSearch Contributors require contributions made to  
        if (cancelled) {
        this.startTimeNanos = startTimeNanos;
                    try {  
    /**
     */
     */  
                }
     */
import java.util.HashMap;  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.api
     */  
     * because some statuses (reindex) have become defacto standardized because
        );
        this.resourceStats = resourceStats;  
     * Returns task id
    /**
     *  
            }, getThreadUsage());
     * Returns average per-execution resource consumption for a specific task stat.  
            ExceptionsHelper.maybeThrowRuntimeAndSuppress(listenerExceptions);
 * Unless required by applicable law or agreed to in writing,
    /**  
    /**  
    }  
     * Returns the total and active number of thread executions for the task.
                try {  
        Map<String, String> headers,  
        if (detailed) {
    }  
 *  
     * Build a version of the task status you can throw over the wire and back
                    put(AVERAGE, getAverageResourceStats());
                }  
     *
    /**
     * @param threadId ID of the thread
                    put(MIN, getMinResourceStats());
    public String getType() {
        }  
            }
                }
        for (List<ThreadResourceInfo> threadResourceInfosList : resourceStats.values()) {
    /**  
                if (threadResourceInfo.getStatsType() == statsType && threadResourceInfo.isActive()) {
                if (threadResourceInfo.getStatsType().isOnlyForAnalysis() == false && statsInfo != null) {
    public TaskResourceUsage getMaxResourceStats() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        incrementResourceTrackingThreads();  
     * should avoid making backwards incompatible changes to the rendered
