                        return false;
        LongSupplier timeNanosSupplier,
        if (scheduledFuture != null) {
        SearchShardTaskStats searchShardTaskStats = new SearchShardTaskStats(
    ) {
                searchBackpressureState.incrementLimitReachedCount();
                settings.getSearchTaskSettings()::getHeapVarianceThreshold,
            .filter(TaskCancellation::isEligibleForCancellation)
    }
public class SearchBackpressureService extends AbstractLifecycleComponent implements TaskCompletionListener {
        if (mode == SearchBackpressureMode.DISABLED) {
     */
/**
            )
        this.nodeDuressTrackers = nodeDuressTrackers;
            final Optional<TaskResourceUsageTracker> taskResourceUsageTracker = taskResourceUsageTrackers.getValue().getTracker(type);
    boolean isHeapUsageDominatedBySearch(List<CancellableTask> searchTasks, double threshold) {
        ClusterSettings clusterSettings,
        List<Runnable> newOnCancelCallbacks = new ArrayList<>(taskCancellation.getOnCancelCallbacks());
     * Given the threshold suppliers, returns the list of applicable trackers
        }, getSettings().getInterval(), ThreadPool.Names.GENERIC);
            );
            searchBackpressureStates.get(SearchShardTask.class).getCancellationCount(),
        }
        }
            }
        if (isNativeMemoryInDuress) {
                getSettings().getSearchShardTaskSettings().getCancellationRatio(),
                settings.getSearchShardTaskSettings().getHeapMovingAverageWindowSize(),
                doRun();
                    }
            return SearchTask.class;
        }
        for (TaskCancellation taskCancellation : taskCancellations) {
            .map(type::cast)
import org.opensearch.threadpool.Scheduler;
import org.opensearch.tasks.Task;
            }
                timeNanosSupplier,
            return;
                    return breached;
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers.NodeDuressTracker;
                    }
                        if (logger.isDebugEnabled()) {
    }
            scheduledFuture.cancel();
        for (TaskCancellation taskCancellation : taskCancellations) {
            searchBackpressureStates.get(SearchShardTask.class).getLimitReachedCount(),
            new ElapsedTimeTracker(ElapsedTimeNanosSupplier, System::nanoTime),
        List<TaskCancellation> taskCancellations,
 */
            searchBackpressureStates.get(SearchShardTask.class).getCompletionCount(),
            // Independently remove tokens from both token buckets.
            throw new IllegalArgumentException("task must be instance of either SearchTask or SearchShardTask");
    // Tracker-apply rules (each tracker decides independently via this map):
            taskResourceUsageTracker.ifPresent(
            if (mode != SearchBackpressureMode.ENFORCED) {
import org.opensearch.action.search.SearchTask;
        return taskCancellations;
import org.opensearch.ExceptionsHelper;
                searchTasks,
                SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
            SearchTask.class,
        SearchTaskStats searchTaskStats = new SearchTaskStats(
    SearchBackpressureSettings getSettings() {
                        () -> settings.getNodeDuressSettings().getNumSuccessiveBreaches()
            .map(this::addSBPStateUpdateCallback)
        return trackerApplyConditions.get(trackerType).apply(nodeDuressTrackers);
    }
    );
            trackers.addTracker(
                    double totalNative = settings.getNodeDuressSettings().getNodeNativeMemory();
                getSettings().getSearchShardTaskSettings().getTotalHeapPercentThreshold()
import org.opensearch.search.backpressure.trackers.HeapUsageTracker;
            if (shouldApply(trackerType)) {
        trackers.addTracker(
            getTrackers(
    private final Map<Class<? extends SearchBackpressureTask>, TaskResourceUsageTrackers> taskTrackers;
                settings.getClusterSettings(),
                settings.getSearchTaskSettings()::getHeapPercentThreshold,
        if (task instanceof SearchBackpressureTask == false) {
                    ResourceType.MEMORY,
            );
                getSettings().getSearchShardTaskSettings().getCancellationBurst(),
    public static TaskResourceUsageTrackers getTrackers(
            boolean searchShardHeapDominated = isHeapUsageDominatedBySearch(
            );
                        );
import org.opensearch.threadpool.ThreadPool;
                getSettings().getSearchTaskSettings().getCancellationRatio(),
    }
                            String.format(java.util.Locale.ROOT, "%.4f", usedFraction),
            );
        return settings;
            ),
    }
                settings.getSearchShardTaskSettings()::getCpuTimeNanosThreshold,
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);
                .collect(Collectors.toUnmodifiableMap(t -> TaskResourceUsageTrackerType.fromName(t.name()), t -> t.stats(searchTasks)))
import org.opensearch.search.backpressure.stats.SearchShardTaskStats;
                        logger.debug(
        DoubleSupplier heapVarianceSupplier,
 * @opensearch.internal
        Class<? extends SearchBackpressureTask> taskType = getTaskType(task);
        // Force-refresh usage stats of these tasks before making a cancellation decision.
    // - Elapsed-time tracker always fires.
    private final Map<Class<? extends SearchBackpressureTask>, SearchBackpressureState> searchBackpressureStates;
import java.util.function.LongSupplier;
import org.opensearch.search.backpressure.stats.SearchBackpressureStats;
}
            searchBackpressureStates.get(SearchTask.class).getCancellationCount(),
        (nodeDuressTrackers) -> isHeapTrackingSupported() && nodeDuressTrackers.isResourceInDuress(ResourceType.MEMORY),
            searchBackpressureStates.get(SearchTask.class).getLimitReachedCount(),
        this.searchBackpressureStates = Map.of(
import org.opensearch.common.settings.ClusterSettings;
        }
import java.util.HashMap;
    public SearchBackpressureService(
    public SearchBackpressureStats nodeStats() {
        newOnCancelCallbacks.add(toAddCancellationCallbackForSBPState);
            .filter(workloadGroupService::shouldSBPHandle)
    // multiple resource pressures compound, and each tracker independently contributes
                .collect(Collectors.toUnmodifiableMap(t -> TaskResourceUsageTrackerType.fromName(t.name()), t -> t.stats(searchShardTasks)))
                getSettings().getSearchTaskSettings().getCancellationRate()
import org.opensearch.monitor.os.OsProbe;
                settings.getSearchTaskSettings()::getCpuTimeNanosThreshold,
    }
                    if (totalNative <= 0) {
        this(settings, taskResourceTrackingService, threadPool, System::nanoTime, new NodeDuressTrackers(new EnumMap<>(ResourceType.class) {
            .stream()
            return;
        List<Exception> exceptions = new ArrayList<>();
    SearchBackpressureService(
                            logger.debug("native memory duress probe: signal unavailable (usedBytes={})", used);
    // When native-memory duress is active, doRun() bypasses the heap-dominance gate so all
                    heapMovingAverageWindowSize,
                );
        List<CancellableTask> searchShardTasks = getTaskByType(SearchShardTask.class);
import java.util.function.DoubleSupplier;
        }
     * Had to define this method to help mock this static method to test the scenario where SearchTraffic should not be
        ThreadPool threadPool,
        }
    private final SearchBackpressureSettings settings;
        TaskResourceUsageTrackerType type,
            .collect(Collectors.toList());
    // we install the native tracker, otherwise we install CPU. The map predicates only
package org.opensearch.search.backpressure;
                continue;
    // gate on duress; addResourceTrackerBasedCancellations is a no-op for any
                TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER
            new SearchBackpressureState(
            getTrackers(
    private final NativeMemoryUsageService nativeMemoryUsageService = NativeMemoryUsageService.getInstance();
        int heapMovingAverageWindowSize,
                SearchShardTask.class,
import org.opensearch.tasks.TaskResourceTrackingService;
    @Override
/*
        (nodeDuressTrackers) -> true,
                            .getCpuThreshold(),
    ) {
        List<TaskCancellation> taskCancellations = new ArrayList<>();
    /**
            boolean rateLimitReached = searchBackpressureState.getRateLimiter().request() == false;
import org.opensearch.monitor.jvm.JvmStats;
        for (TaskResourceUsageTracker tracker : trackers.all()) {
    private List<TaskCancellation> addResourceTrackerBasedCancellations(
                    windowSizeSetting
        TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,
        }
        if (task instanceof SearchTask) {
 * breaching resource usage limits when the node is in duress.
                TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER
        for (Map.Entry<Class<? extends SearchBackpressureTask>, TaskResourceUsageTrackers> taskResourceUsageTrackers : taskTrackers
        SearchBackpressureSettings settings,
        this.workloadGroupService = workloadGroupService;
                .stream()
                    clusterSettings,
                .all()
                    double used = OsProbe.getInstance().getProcessNativeMemoryBytes();
        return new ArrayList<>(uniqueTaskCancellations.values());
        TaskResourceTrackingService taskResourceTrackingService,
        taskResourceTrackingService.refreshResourceStats(searchTasks.toArray(new Task[0]));
    }
        return HeapUsageTracker.isHeapUsageDominatedBySearch(searchTasks, threshold);
                searchHeapDominated ? searchTasks : Collections.emptyList(),
        TaskManager taskManager,
     * @param threshold   miniumum  jvm allocated bytes ratio w.r.t. available heap
            // Stop cancelling tasks if there are no tokens in either of the two token buckets.
        } else {
        CancellableTask cancellableTask = (CancellableTask) task;
        LongSupplier ElapsedTimeNanosSupplier,
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        if (getSettings().getMode() == SearchBackpressureMode.DISABLED) {
 */
        return trackers;
        TaskManager taskManager,
import java.util.List;
                settings.getSearchShardTaskSettings()::getElapsedTimeNanosThreshold,
        TaskResourceUsageTrackers trackers = taskTrackers.get(taskType);
            logger.warn(
            boolean ratioLimitReached = searchBackpressureState.getRatioLimiter().request() == false;
        this.taskTrackers = Map.of(SearchTask.class, searchTaskTrackers, SearchShardTask.class, searchShardTaskTrackers);
        Setting<Integer> windowSizeSetting
                );
            SearchShardTask.class,
            nativeMemoryUsageService.refresh();
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType;
            new SearchBackpressureState(
    @Override
            boolean searchHeapDominated = isHeapUsageDominatedBySearch(
                    if (logger.isDebugEnabled()) {
    }
            } catch (Exception e) {
        return nodeDuressTrackers.isNodeInDuress();
    }
    // in-flight tasks become cancellation candidates (off-heap pressure is invisible to heap
    }
            } catch (Exception e) {
                    boolean breached = usedFraction >= threshold;
            if (rateLimitReached && ratioLimitReached) {
        TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER,
        }
import org.opensearch.wlm.WorkloadGroupService;
            return SearchShardTask.class;
import java.util.ArrayList;
        }
    SearchBackpressureState getSearchBackpressureState(Class<? extends SearchBackpressureTask> taskType) {
    private volatile Scheduler.Cancellable scheduledFuture;
        }
    }
     */
    private final TaskManager taskManager;
                getSettings().getSearchTaskSettings().getCancellationRateNanos(),
                ),
                        }
        }
    // cancellation reasons that are merged before execution.
            .entrySet()) {
        }
                new NativeMemoryUsageTracker(nativeMemoryPercentThresholdSupplier),
     * Given a task, returns the type of the task
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers;
            final long taskId = taskCancellation.getTask().getId();
        scheduledFuture = threadPool.scheduleWithFixedDelay(() -> {
            ),
                "[{} mode] cancelling task [{}] due to high resource consumption [{}]",
                    )
        } else if (task instanceof SearchShardTask) {
import org.opensearch.tasks.SearchBackpressureTask;
                    new NodeDuressTracker(
            {
import org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker;
import org.opensearch.wlm.ResourceType;
        return new SearchBackpressureStats(searchTaskStats, searchShardTaskStats, getSettings().getMode());
                taskCancellation.getTask().getId(),
import static org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker.isNativeTrackingSupported;
    }
        return taskResourceTrackingService.getResourceAwareTasks()
                    new NodeDuressTracker(
            return;
    private final ThreadPool threadPool;
                    ResourceType.CPU,
     */
            try {
    //
    private boolean shouldApply(TaskResourceUsageTrackerType trackerType) {
        if (nodeDuressTrackers.isNodeInDuress() == false) {
        final Map<Class<? extends SearchBackpressureTask>, List<CancellableTask>> cancellableTasks;
                tracker.update(task);
        if (cancellableTask.isCancelled() == false) {
        if (isHeapTrackingSupported()) {
                getSettings().getSearchShardTaskSettings().getCancellationRate()
                break;
                    double usedFraction = used / totalNative;
import org.opensearch.action.search.SearchShardTask;
            logger.warn("heap size couldn't be determined");
import java.util.EnumMap;
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers;
    }
                settings.getSearchTaskSettings()::getElapsedTimeNanosThreshold,
 *
        Runnable toAddCancellationCallbackForSBPState = searchBackpressureStates.get(SearchShardTask.class)::incrementCancellationCount;
                .stream()
import org.opensearch.search.backpressure.settings.SearchTaskSettings;
        );
        taskResourceTrackingService.refreshResourceStats(searchShardTasks.toArray(new Task[0]));
     * @param searchTasks inFlight co-ordinator requests
                exceptions.add(e);
                }, () -> settings.getNodeDuressSettings().getNumSuccessiveBreaches()));
     * Filters and returns the list of currently running tasks of specified type.
        LongSupplier cpuThresholdSupplier,
        final boolean isNativeMemoryInDuress = nodeDuressTrackers.isNativeMemoryInDuress();
import org.opensearch.search.backpressure.trackers.CpuUsageTracker;
 * The OpenSearch Contributors require contributions made to
            .collect(Collectors.toUnmodifiableList());
    private List<TaskCancellation> mergeTaskCancellations(final List<TaskCancellation> taskCancellations) {
        this.taskResourceTrackingService.addTaskCompletionListener(this);
    public void onTaskCompleted(Task task) {
    protected void doStop() {
     */
        List<CancellableTask> searchTasks = getTaskByType(SearchTask.class);
            cancellableTasks = Map.of(
        DoubleSupplier heapPercentThresholdSupplier,
                        () -> settings.getNodeDuressSettings().getNumSuccessiveBreaches()
import org.opensearch.tasks.TaskCancellation;
            searchBackpressureStates.get(taskType).incrementCompletionCount();
                    }
        );
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.tasks.CancellableTask;
        TaskResourceUsageTrackers searchShardTaskTrackers,
                put(
import java.util.Collections;
                settings.getSearchShardTaskSettings()::getNativeMemoryPercentThreshold,
        return searchBackpressureStates.get(taskType);
    private final NodeDuressTrackers nodeDuressTrackers;
        DoubleSupplier nativeMemoryPercentThresholdSupplier,
                            breached
                settings.getSearchShardTaskSettings()::getHeapPercentThreshold,
    boolean isNodeInDuress() {
        }
    protected void doStart() {
        this.threadPool = threadPool;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.backpressure.stats.SearchTaskStats;
    private final TaskResourceTrackingService taskResourceTrackingService;
 * compatible open source license.
        WorkloadGroupService workloadGroupService
                    )
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
     * @return unique task cancellations
    Class<? extends SearchBackpressureTask> getTaskType(Task task) {
            );
     * @param taskCancellations all task cancellations
            workloadGroupService
                        () -> JvmStats.jvmStats().getMem().getHeapUsedPercent() / 100.0 >= settings.getNodeDuressSettings()
     * penalised when not breaching the threshold
                    heapVarianceSupplier,
import java.util.Optional;
                    double threshold = settings.getNodeDuressSettings().getNativeMemoryThreshold();
                getSettings().getSearchTaskSettings().getCancellationBurst(),
            );
     */
                searchShardHeapDominated ? searchShardTasks : Collections.emptyList()
            }
import org.opensearch.tasks.TaskResourceTrackingService.TaskCompletionListener;
            );
        (nodeDuressTrackers) -> nodeDuressTrackers.isResourceInDuress(ResourceType.CPU),
     */
import org.opensearch.search.backpressure.trackers.ElapsedTimeTracker;
                SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
        this.settings = settings;
                logger.debug("task cancellation limit reached");
            taskManager,
        SearchBackpressureMode mode = getSettings().getMode();
import org.opensearch.search.backpressure.settings.SearchBackpressureMode;
            taskTrackers.get(SearchTask.class)
        this.taskManager = taskManager;
        }),
                logger.debug("failure in search search backpressure", e);
        (nodeDuressTrackers) -> isNativeTrackingSupported() && nodeDuressTrackers.isResourceInDuress(ResourceType.NATIVE_MEMORY)
        ThreadPool threadPool,
        TaskResourceUsageTrackers trackers = new TaskResourceUsageTrackers();
 * SearchBackpressureService is responsible for monitoring and cancelling in-flight search tasks if they are
            cancellableTasks = Map.of(SearchTask.class, searchTasks, SearchShardTask.class, searchShardTasks);
    // - CPU tracker fires when CPU is in duress. CPU and native trackers are mutually
                settings.getSearchTaskSettings()::getNativeMemoryPercentThreshold,
        }
    ) {
    private TaskCancellation addSBPStateUpdateCallback(TaskCancellation taskCancellation) {
    <T extends CancellableTask & SearchBackpressureTask> List<CancellableTask> getTaskByType(Class<T> type) {
            }
            taskTrackers.get(SearchShardTask.class)
import org.opensearch.tasks.TaskManager;
        TaskResourceUsageTrackers searchTaskTrackers,
     * @return a boolean value based on whether the threshold is breached
        } else {
            TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
        if (task instanceof SearchTask) {
import org.opensearch.common.settings.Setting;
import org.opensearch.monitor.process.ProcessProbe;
    protected void doClose() throws IOException {}
                getSettings().getSearchShardTaskSettings().getCancellationRateNanos(),
     * Method to reduce the taskCancellations into unique bunch
    }
import java.io.IOException;
            final Class<? extends SearchBackpressureTask> taskType = taskResourceUsageTrackers.getKey();
    @Override
import static org.opensearch.search.backpressure.trackers.HeapUsageTracker.isHeapTrackingSupported;
        List<CancellableTask> searchShardTasks = getTaskByType(SearchShardTask.class);
        }
        } else {
        TaskResourceTrackingService taskResourceTrackingService,
        SearchBackpressureSettings settings,
            }
        if (isNativeTrackingSupported()) {
    /**
    // exclusive at install time (see getTrackers): when isNativeTrackingSupported()
import java.util.Map;
        CancellableTask task = taskCancellation.getTask();
        this.settings.getSearchTaskSettings().addListener(searchBackpressureStates.get(SearchTask.class));
        } else {
                mode.getName(),
        this.settings.getSearchShardTaskSettings().addListener(searchBackpressureStates.get(SearchShardTask.class));
    ) {
                addResourceTrackerBasedCancellations(trackerType, taskCancellations, cancellableTasks);
    @Override
    /**
            .values()
    }
                            "native memory duress probe: usedFraction={}, threshold={}, breached={}",
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
        for (TaskResourceUsageTrackerType trackerType : TaskResourceUsageTrackerType.values()) {
            trackers.addTracker(new CpuUsageTracker(cpuThresholdSupplier), TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
            searchBackpressureStates.get(SearchTask.class).getCompletionCount(),
            return;
import org.apache.logging.log4j.Logger;
        this.taskResourceTrackingService = taskResourceTrackingService;
        // We need to merge them
    /**
     * Returns true if the node is in duress consecutively for the past 'n' observations.
        }
            SearchBackpressureState searchBackpressureState = searchBackpressureStates.get(taskType);
        WorkloadGroupService workloadGroupService
        final Map<Long, TaskCancellation> uniqueTaskCancellations = new HashMap<>();
                timeNanosSupplier,
                settings.getSearchShardTaskSettings()::getHeapVarianceThreshold,
    // tracker that wasn't installed (Optional.ifPresent in TaskResourceUsageTrackers).
                settings.getClusterSettings(),
                            String.format(java.util.Locale.ROOT, "%.4f", threshold),
        Map<Class<? extends SearchBackpressureTask>, List<CancellableTask>> cancellableTasks
                searchShardTasks,
    }
                .all()
            ),
                    heapPercentThresholdSupplier,
        TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
import java.util.function.Function;
    }
        List<CancellableTask> searchTasks = getTaskByType(SearchTask.class);
        NodeDuressTrackers nodeDuressTrackers,
                new HeapUsageTracker(
                tracker -> taskCancellations.addAll(tracker.getTaskCancellations(cancellableTasks.get(taskType)))
            Class<? extends SearchBackpressureTask> taskType = getTaskType(taskCancellation.getTask());
    private static final Logger logger = LogManager.getLogger(SearchBackpressureService.class);
                taskCancellation.getReasonString()
        );
                    if (usedFraction < 0.0d) {
                put(
                put(ResourceType.NATIVE_MEMORY, new NodeDuressTracker(() -> {
            .filter(type::isInstance)
    void doRun() {
    private final WorkloadGroupService workloadGroupService;
            toAddCancellationCallbackForSBPState = searchBackpressureStates.get(SearchTask.class)::incrementCancellationCount;
 *
            try {
import java.util.stream.Collectors;
                            .getHeapThreshold(),
        TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER,
            }
        // Since these cancellations might be duplicate due to multiple trackers causing cancellation for same task
                        () -> ProcessProbe.getInstance().getProcessCpuPercent() / 100.0 >= settings.getNodeDuressSettings()
            uniqueTaskCancellations.put(taskId, uniqueTaskCancellations.getOrDefault(taskId, taskCancellation).merge(taskCancellation));
        );
                settings.getSearchTaskSettings().getHeapMovingAverageWindowSize(),
            taskCancellation.cancelTaskAndDescendants(taskManager);
                        return false;
    private static final Map<TaskResourceUsageTrackerType, Function<NodeDuressTrackers, Boolean>> trackerApplyConditions = Map.of(
    /**
        );
    // metrics). If heap is ALSO in duress simultaneously, its tracker will fire too —
    // - Native-memory tracker fires when native memory is in duress (and tracking is supported).
        return new TaskCancellation(task, taskCancellation.getReasons(), newOnCancelCallbacks);
                getSettings().getSearchTaskSettings().getTotalHeapPercentThreshold()
        taskCancellations = mergeTaskCancellations(taskCancellations).stream()
    // - Heap tracker fires when heap is in duress (and heap tracking is supported).
                SearchTask.class,
            trackers.addTracker(
import org.apache.logging.log4j.LogManager;
    /**
