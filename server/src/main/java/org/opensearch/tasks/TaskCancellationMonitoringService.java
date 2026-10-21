            new SearchTaskCancellationStats(
    @Override
    @Override
        }
            .filter(task -> {
    protected Map<Long, Boolean> getCancelledTaskTracker() {
    /**
    private final Map<Long, Boolean> cancelledTaskTracker;
import java.util.stream.Collectors;
    public TaskCancellationStats stats() {
    protected void doClose() throws IOException {
    @Override
        }
     *
        scheduledFuture = threadPool.scheduleWithFixedDelay(() -> {
    private final Supplier<AnalyticsBackendTaskCancellationStats> nativeStatsSupplier;
    void doRun() {
        if (!taskCancellationMonitoringSettings.isEnabled() || this.cancelledTaskTracker.isEmpty()) {
 * node stats.
            .collect(Collectors.toConcurrentMap(task -> task, task -> new TaskCancellationStatsHolder()));
     */
     * @param task task which got completed.
     */
    public TaskCancellationMonitoringService(
            cancellationStatsHolder.get(key).totalLongRunningCancelledTaskCount.inc(uniqueTasksRunningCount);
        TaskManager taskManager,
        }
}
 * this file be licensed under the Apache-2.0 license or a
        ThreadPool threadPool,
     * Holds stats related to monitoring service
import org.apache.logging.log4j.LogManager;
/*
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings,
        }
            return null;
     *  This map holds statistics for each cancellable task type.
                    this.cancelledTaskTracker.put(task.getId(), true);
    public static class TaskCancellationStatsHolder {
    }
import java.io.IOException;
 *
     * M for the first time and adds it as part of stats. In next iteration of monitoring service, it might see
        }
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
            } catch (Exception e) {
     * @param threadPool                          the thread pool for scheduling
 * The OpenSearch Contributors require contributions made to
                if (this.cancelledTaskTracker.containsKey(task.getId()) && !this.cancelledTaskTracker.get(task.getId())) {
 * compatible open source license.
        }, taskCancellationMonitoringSettings.getInterval(), ThreadPool.Names.GENERIC);
            .filter(CancellableTask::isCancelled)
        @Nullable Supplier<AnalyticsBackendTaskCancellationStats> nativeStatsSupplier
     * us to enable this monitoring service only when needed.
    /**
        });
            .collect(Collectors.groupingBy(CancellableTask::getClass, Collectors.toList()));
    /**
        if (!TASKS_TO_TRACK.contains(task.getClass())) {
     */
            logger.debug("Failed to fetch native task cancellation stats", e);
     * @param threadPool                          the thread pool for scheduling
 * This monitoring service is responsible to track long-running(defined by a threshold) cancelled tasks as part of
        this(threadPool, taskManager, taskCancellationMonitoringSettings, null);
     */
        cancellationStatsHolder = TASKS_TO_TRACK.stream()
    ) {
    }
            try {
import org.opensearch.common.metrics.CounterMetric;
    }
            .stream()
import java.util.concurrent.TimeUnit;
     * Constructs a TaskCancellationMonitoringService with optional native stats support.
        long currentTimeInNanos = System.nanoTime();
    }
                doRun();
import java.util.concurrent.ConcurrentHashMap;
            return;
import org.opensearch.action.search.SearchTask;
            .values()
        AnalyticsBackendTaskCancellationStats nativeStats = fetchNativeStats();
    @Override
    protected void doStart() {
import org.opensearch.threadpool.Scheduler;
        if (nativeStatsSupplier == null) {
    private final ThreadPool threadPool;
            }
            .filter(task -> TASKS_TO_TRACK.contains(task.getClass()))
     *
        this.cancelledTaskTracker.putIfAbsent(task.getId(), false);
        Map<Class<? extends CancellableTask>, List<CancellableTask>> currentRunningCancelledTasks =
    @Nullable
     * @param taskCancellationMonitoringSettings  the monitoring settings
                    return true;
                Optional.of(currentRunningCancelledTasks).map(mapper -> mapper.get(SearchShardTask.class)).map(List::size).orElse(0),
        if (scheduledFuture != null) {
            new SearchShardTaskCancellationStats(
            long uniqueTasksRunningCount = value.stream().filter(task -> {
        taskCancellationListByType.forEach((key, value) -> {
     * metric.
    private static final Logger logger = LogManager.getLogger(TaskCancellationMonitoringService.class);
    }
import java.util.Map;
        );
import java.util.function.Supplier;
     * @param task task which got cancelled.
            ),
    }
    }
import org.opensearch.action.search.SearchShardTask;
            scheduledFuture.cancel();
    private final TaskCancellationMonitoringSettings taskCancellationMonitoringSettings;
    @Override
     * Constructs a TaskCancellationMonitoringService without native stats support.
            })
        // Add task to tracker and mark it as not seen(false) yet by the stats logic.
     * @param taskManager                         the task manager to monitor
                }
            return;
    @Nullable
    private final Map<Class<? extends CancellableTask>, TaskCancellationStatsHolder> cancellationStatsHolder;
    private AnalyticsBackendTaskCancellationStats fetchNativeStats() {
    public void onTaskCompleted(Task task) {
        } catch (Exception e) {
            getCurrentRunningTasksPostCancellation();
    }
     */
     * sum(from genesis) of cancelled tasks which have been running beyond a threshold and avoid double count
            nativeStats
            return nativeStatsSupplier.get();
                } else {
     * Invoked when a task is cancelled. This is to keep track of tasks being cancelled. More importantly also helps
        try {
     * This is to keep track of currently running cancelled tasks. This is needed to accurately calculate cumulative
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings
     * Invoked when a task is completed. This helps us to disable monitoring service when there are no cancelled tasks
                return runningTimeSinceCancellationSeconds >= taskCancellationMonitoringSettings.getDuration().getSeconds();
        return taskManager.getCancellableTasks()
        TaskManager taskManager,
    }
            ),
        return this.cancelledTaskTracker;
import java.util.List;
import org.apache.logging.log4j.Logger;
                Optional.of(currentRunningCancelledTasks).map(mapper -> mapper.get(SearchTask.class)).map(List::size).orElse(0),
package org.opensearch.tasks;
                cancellationStatsHolder.get(SearchShardTask.class).totalLongRunningCancelledTaskCount.count()
    private final TaskManager taskManager;
    }
import java.util.Optional;
        this.cancelledTaskTracker.remove(task.getId());
     * A task M was cancelled at some point of time and continues to run for long. This Monitoring service sees this
        if (!TASKS_TO_TRACK.contains(task.getClass())) {
    }
 */
            return;
import org.opensearch.common.Nullable;
    ) {
    /**
    private volatile Scheduler.Cancellable scheduledFuture;
    /**
import java.util.Arrays;
 * SPDX-License-Identifier: Apache-2.0
    public TaskCancellationMonitoringService(
    public void onTaskCancelled(CancellableTask task) {
        this.cancelledTaskTracker = new ConcurrentHashMap<>();
public class TaskCancellationMonitoringService extends AbstractLifecycleComponent implements TaskManager.TaskEventListeners {
                    currentTimeInNanos - task.getCancellationStartTimeNanos()
                    // Mark it as seen by the stats logic.
        this.taskCancellationMonitoringSettings = taskCancellationMonitoringSettings;
        return new TaskCancellationStats(
 */
        }
            return null;
                );
    private final static List<Class<? extends CancellableTask>> TASKS_TO_TRACK = Arrays.asList(SearchShardTask.class, SearchTask.class);
    private Map<Class<? extends CancellableTask>, List<CancellableTask>> getCurrentRunningTasksPostCancellation() {
                long runningTimeSinceCancellationSeconds = TimeUnit.NANOSECONDS.toSeconds(
        taskManager.addTaskEventListeners(this);
     * problem.
        CounterMetric totalLongRunningCancelledTaskCount = new CounterMetric();
     * @param taskCancellationMonitoringSettings  the monitoring settings
            }).count();
    protected void doStop() {
     * running to avoid wasteful work.
     * For example:
     */
import org.opensearch.threadpool.ThreadPool;
        Map<Class<? extends CancellableTask>, List<CancellableTask>> taskCancellationListByType = getCurrentRunningTasksPostCancellation();
    // For testing
     */
    }
    }
                    return false;
                cancellationStatsHolder.get(SearchTask.class).totalLongRunningCancelledTaskCount.count()
     * @param taskManager                         the task manager to monitor
                logger.debug("Exception occurred in Task monitoring service", e);
    /**
        this.taskManager = taskManager;
     * this M(if still running) again, but using below map we will not double count this task as part of our cumulative
/**
     * @param nativeStatsSupplier                 supplier for native task cancellation stats, or null
    /**
        this.threadPool = threadPool;
        this.nativeStatsSupplier = nativeStatsSupplier;
        ThreadPool threadPool,
