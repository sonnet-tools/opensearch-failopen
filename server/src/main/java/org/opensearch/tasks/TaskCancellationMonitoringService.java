     * Constructs a TaskCancellationMonitoringService without native stats support.  
/**
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
import java.io.IOException;  
     * Invoked when a task is cancelled. This is to keep track of tasks being cancelled. More importantly also helps  
        }, taskCancellationMonitoringSettings.getInterval(), ThreadPool.Names.GENERIC);
    @Override  
    }  
     * problem.
    }  
    private Map<Class<? extends CancellableTask>, List<CancellableTask>> getCurrentRunningTasksPostCancellation() {  
            scheduledFuture.cancel();
    }  
                long runningTimeSinceCancellationSeconds = TimeUnit.NANOSECONDS.toSeconds(  
        if (!TASKS_TO_TRACK.contains(task.getClass())) {  
/*  
        Map<Class<? extends CancellableTask>, List<CancellableTask>> taskCancellationListByType = getCurrentRunningTasksPostCancellation();  
            .filter(CancellableTask::isCancelled)
                cancellationStatsHolder.get(SearchShardTask.class).totalLongRunningCancelledTaskCount.count()
            new SearchTaskCancellationStats(
            .collect(Collectors.toConcurrentMap(task -> task, task -> new TaskCancellationStatsHolder()));
        TaskManager taskManager,  
import java.util.Arrays;
        if (scheduledFuture != null) {
        );
     *  This map holds statistics for each cancellable task type.
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings  
        if (!taskCancellationMonitoringSettings.isEnabled() || this.cancelledTaskTracker.isEmpty()) {  
            }
        if (nativeStatsSupplier == null) {
        this.cancelledTaskTracker.putIfAbsent(task.getId(), false);
    ) {  
 *
            try {  
     * Constructs a TaskCancellationMonitoringService with optional native stats support.  
 * compatible open source license.
        }
    public void onTaskCancelled(CancellableTask task) {
     * @param nativeStatsSupplier                 supplier for native task cancellation stats, or null
    /**
import org.opensearch.action.search.SearchTask;
    }
            long uniqueTasksRunningCount = value.stream().filter(task -> {
    /**
    @Nullable
                    currentTimeInNanos - task.getCancellationStartTimeNanos()
        this.taskManager = taskManager;
                );
        this.cancelledTaskTracker.remove(task.getId());
    public TaskCancellationMonitoringService(
        } catch (Exception e) {  
     * running to avoid wasteful work.  
            return;  
        return this.cancelledTaskTracker;
     * @param taskCancellationMonitoringSettings  the monitoring settings
        }  
     * metric.  
     * @param taskManager                         the task manager to monitor  
     */
        this.nativeStatsSupplier = nativeStatsSupplier;
     *
    /**
                    return true;  
        if (!TASKS_TO_TRACK.contains(task.getClass())) {
        }
    protected void doStop() {  
     * this M(if still running) again, but using below map we will not double count this task as part of our cumulative
import java.util.List;
            logger.debug("Failed to fetch native task cancellation stats", e);
     */
     */
import java.util.stream.Collectors;
    // For testing
    @Override
import java.util.Optional;
        TaskManager taskManager,
    public TaskCancellationMonitoringService(  
     *
    public void onTaskCompleted(Task task) {
        }  
    @Override  
            getCurrentRunningTasksPostCancellation();  
import org.opensearch.threadpool.ThreadPool;
        ThreadPool threadPool,
    }  
        return taskManager.getCancellableTasks()  
    private final Map<Long, Boolean> cancelledTaskTracker;
                } else {
     * @param threadPool                          the thread pool for scheduling
}
 * This monitoring service is responsible to track long-running(defined by a threshold) cancelled tasks as part of
 */  
 */
        this.cancelledTaskTracker = new ConcurrentHashMap<>();
    ) {
    /**
     * M for the first time and adds it as part of stats. In next iteration of monitoring service, it might see
            return;
     * Invoked when a task is completed. This helps us to disable monitoring service when there are no cancelled tasks
    private final Map<Class<? extends CancellableTask>, TaskCancellationStatsHolder> cancellationStatsHolder;  
                if (this.cancelledTaskTracker.containsKey(task.getId()) && !this.cancelledTaskTracker.get(task.getId())) {  
        try {
     * @param task task which got cancelled.
            .collect(Collectors.groupingBy(CancellableTask::getClass, Collectors.toList()));
import java.util.concurrent.TimeUnit;  
                Optional.of(currentRunningCancelledTasks).map(mapper -> mapper.get(SearchShardTask.class)).map(List::size).orElse(0),
                doRun();
    }
package org.opensearch.tasks;
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
            .filter(task -> {
     * This is to keep track of currently running cancelled tasks. This is needed to accurately calculate cumulative
     * @param taskManager                         the task manager to monitor  
    private static final Logger logger = LogManager.getLogger(TaskCancellationMonitoringService.class);
     */
import java.util.Map;  
        ThreadPool threadPool,
        }
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings,
        AnalyticsBackendTaskCancellationStats nativeStats = fetchNativeStats();
                    // Mark it as seen by the stats logic.
    @Nullable
    public static class TaskCancellationStatsHolder {
    void doRun() {
            .stream()
     * For example:
 * this file be licensed under the Apache-2.0 license or a
        });  
            new SearchShardTaskCancellationStats(  
     * @param threadPool                          the thread pool for scheduling
import java.util.concurrent.ConcurrentHashMap;
    }
    protected void doStart() {
            })
        return new TaskCancellationStats(
            ),
            return null;
            ),  
        this(threadPool, taskManager, taskCancellationMonitoringSettings, null);
    private final Supplier<AnalyticsBackendTaskCancellationStats> nativeStatsSupplier;  
            return nativeStatsSupplier.get();
     * us to enable this monitoring service only when needed.
public class TaskCancellationMonitoringService extends AbstractLifecycleComponent implements TaskManager.TaskEventListeners {
                return runningTimeSinceCancellationSeconds >= taskCancellationMonitoringSettings.getDuration().getSeconds();  
import org.opensearch.threadpool.Scheduler;  
 * node stats.  
    }  
        CounterMetric totalLongRunningCancelledTaskCount = new CounterMetric();  
        scheduledFuture = threadPool.scheduleWithFixedDelay(() -> {
            cancellationStatsHolder.get(key).totalLongRunningCancelledTaskCount.inc(uniqueTasksRunningCount);
                }  
     */
import org.apache.logging.log4j.Logger;
            }).count();
 * The OpenSearch Contributors require contributions made to  
    private final TaskManager taskManager;  
    private final ThreadPool threadPool;
    /**
            return;
    /**
    protected void doClose() throws IOException {
     * sum(from genesis) of cancelled tasks which have been running beyond a threshold and avoid double count  
            } catch (Exception e) {
        taskCancellationListByType.forEach((key, value) -> {
            nativeStats
                    this.cancelledTaskTracker.put(task.getId(), true);
     */  
     * Holds stats related to monitoring service  
     * @param taskCancellationMonitoringSettings  the monitoring settings
    }  
    }
        long currentTimeInNanos = System.nanoTime();
        taskManager.addTaskEventListeners(this);
        }  
    private final static List<Class<? extends CancellableTask>> TASKS_TO_TRACK = Arrays.asList(SearchShardTask.class, SearchTask.class);
     */  
import org.opensearch.common.Nullable;
    }  
import org.opensearch.action.search.SearchShardTask;  
import java.util.function.Supplier;
    public TaskCancellationStats stats() {
    /**  
    protected Map<Long, Boolean> getCancelledTaskTracker() {  
    }
import org.apache.logging.log4j.LogManager;
        this.taskCancellationMonitoringSettings = taskCancellationMonitoringSettings;  
                Optional.of(currentRunningCancelledTasks).map(mapper -> mapper.get(SearchTask.class)).map(List::size).orElse(0),  
    }
     * @param task task which got completed.
        cancellationStatsHolder = TASKS_TO_TRACK.stream()  
                cancellationStatsHolder.get(SearchTask.class).totalLongRunningCancelledTaskCount.count()
     * A task M was cancelled at some point of time and continues to run for long. This Monitoring service sees this  
            return null;
                logger.debug("Exception occurred in Task monitoring service", e);  
            .values()
        Map<Class<? extends CancellableTask>, List<CancellableTask>> currentRunningCancelledTasks =
    private final TaskCancellationMonitoringSettings taskCancellationMonitoringSettings;
 * SPDX-License-Identifier: Apache-2.0
    @Override  
            .filter(task -> TASKS_TO_TRACK.contains(task.getClass()))  
import org.opensearch.common.metrics.CounterMetric;
    @Override
        this.threadPool = threadPool;
                    return false;
    private volatile Scheduler.Cancellable scheduledFuture;
    private AnalyticsBackendTaskCancellationStats fetchNativeStats() {  
        @Nullable Supplier<AnalyticsBackendTaskCancellationStats> nativeStatsSupplier
        // Add task to tracker and mark it as not seen(false) yet by the stats logic.  
