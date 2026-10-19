        (nodeDuressTrackers) -> true,
                            String.format(java.util.Locale.ROOT, "%.4f", threshold),
                            "native memory duress probe: usedFraction={}, threshold={}, breached={}",
                settings.getSearchTaskSettings()::getHeapVarianceThreshold,
        if (task instanceof SearchTask) {  
        return new SearchBackpressureStats(searchTaskStats, searchShardTaskStats, getSettings().getMode());  
    private volatile Scheduler.Cancellable scheduledFuture;  
    // exclusive at install time (see getTrackers): when isNativeTrackingSupported()  
                }, () -> settings.getNodeDuressSettings().getNumSuccessiveBreaches()));  
        int heapMovingAverageWindowSize,
            taskManager,
        if (isNativeTrackingSupported()) {  
     * @param searchTasks inFlight co-ordinator requests
    /**  
                    ResourceType.MEMORY,
                new HeapUsageTracker(
    boolean isNodeInDuress() {  
                .stream()
import org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker;
        CancellableTask task = taskCancellation.getTask();
            Class<? extends SearchBackpressureTask> taskType = getTaskType(taskCancellation.getTask());
            new SearchBackpressureState(
        WorkloadGroupService workloadGroupService
                settings.getSearchShardTaskSettings()::getNativeMemoryPercentThreshold,
import org.opensearch.threadpool.ThreadPool;  
                exceptions.add(e);  
                settings.getSearchShardTaskSettings().getHeapMovingAverageWindowSize(),
                        return false;
    // - Native-memory tracker fires when native memory is in duress (and tracking is supported).  
                searchShardHeapDominated ? searchShardTasks : Collections.emptyList()
 *
        return taskCancellations;
        return trackers;
        final Map<Class<? extends SearchBackpressureTask>, List<CancellableTask>> cancellableTasks;
        SearchBackpressureSettings settings,
        TaskManager taskManager,  
    SearchBackpressureState getSearchBackpressureState(Class<? extends SearchBackpressureTask> taskType) {  
            .stream()
        taskCancellations = mergeTaskCancellations(taskCancellations).stream()  
import java.util.Map;
                getSettings().getSearchShardTaskSettings().getCancellationRate()
    void doRun() {
                    if (usedFraction < 0.0d) {
import org.apache.logging.log4j.Logger;
        TaskResourceUsageTrackers trackers = taskTrackers.get(taskType);
                .stream()
                getSettings().getSearchShardTaskSettings().getTotalHeapPercentThreshold()
        newOnCancelCallbacks.add(toAddCancellationCallbackForSBPState);
        (nodeDuressTrackers) -> isNativeTrackingSupported() && nodeDuressTrackers.isResourceInDuress(ResourceType.NATIVE_MEMORY)  
                        () -> JvmStats.jvmStats().getMem().getHeapUsedPercent() / 100.0 >= settings.getNodeDuressSettings()
    private final WorkloadGroupService workloadGroupService;  
        TaskResourceUsageTrackers trackers = new TaskResourceUsageTrackers();
    public SearchBackpressureService(
    }
                tracker.update(task);
        return nodeDuressTrackers.isNodeInDuress();
    private List<TaskCancellation> addResourceTrackerBasedCancellations(
                        if (logger.isDebugEnabled()) {
        if (scheduledFuture != null) {
import static org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker.isNativeTrackingSupported;  
        );  
            final Optional<TaskResourceUsageTracker> taskResourceUsageTracker = taskResourceUsageTrackers.getValue().getTracker(type);
            .map(type::cast)  
        }  
                new NativeMemoryUsageTracker(nativeMemoryPercentThresholdSupplier),
        TaskResourceUsageTrackers searchShardTaskTrackers,
import org.opensearch.tasks.TaskResourceTrackingService;  
        if (mode == SearchBackpressureMode.DISABLED) {
     * @return a boolean value based on whether the threshold is breached
    SearchBackpressureSettings getSettings() {
     */  
                put(
import org.opensearch.search.backpressure.settings.SearchTaskSettings;  
                SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
                settings.getSearchTaskSettings()::getElapsedTimeNanosThreshold,
        }
        LongSupplier cpuThresholdSupplier,
                addResourceTrackerBasedCancellations(trackerType, taskCancellations, cancellableTasks);  
            cancellableTasks = Map.of(SearchTask.class, searchTasks, SearchShardTask.class, searchShardTasks);
        } else {
    }  
 */  
        TaskResourceUsageTrackerType type,
                settings.getSearchShardTaskSettings()::getHeapVarianceThreshold,  
    private static final Map<TaskResourceUsageTrackerType, Function<NodeDuressTrackers, Boolean>> trackerApplyConditions = Map.of(
        Class<? extends SearchBackpressureTask> taskType = getTaskType(task);
            boolean ratioLimitReached = searchBackpressureState.getRatioLimiter().request() == false;
                        () -> settings.getNodeDuressSettings().getNumSuccessiveBreaches()  
    public void onTaskCompleted(Task task) {  
        }
    private final Map<Class<? extends SearchBackpressureTask>, SearchBackpressureState> searchBackpressureStates;
        TaskManager taskManager,  
    }  
        if (getSettings().getMode() == SearchBackpressureMode.DISABLED) {
            toAddCancellationCallbackForSBPState = searchBackpressureStates.get(SearchTask.class)::incrementCancellationCount;
import java.util.stream.Collectors;  
            searchBackpressureStates.get(SearchTask.class).getCancellationCount(),
    public SearchBackpressureStats nodeStats() {
            .filter(type::isInstance)
/*  
                    heapVarianceSupplier,
        TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
        (nodeDuressTrackers) -> isHeapTrackingSupported() && nodeDuressTrackers.isResourceInDuress(ResourceType.MEMORY),
        ClusterSettings clusterSettings,
import java.util.HashMap;
            final Class<? extends SearchBackpressureTask> taskType = taskResourceUsageTrackers.getKey();  
        for (Map.Entry<Class<? extends SearchBackpressureTask>, TaskResourceUsageTrackers> taskResourceUsageTrackers : taskTrackers  
            // Stop cancelling tasks if there are no tokens in either of the two token buckets.  
            SearchTask.class,  
        } else {  
    // - Elapsed-time tracker always fires.
        Map<Class<? extends SearchBackpressureTask>, List<CancellableTask>> cancellableTasks
                getSettings().getSearchTaskSettings().getCancellationRate()  
        this(settings, taskResourceTrackingService, threadPool, System::nanoTime, new NodeDuressTrackers(new EnumMap<>(ResourceType.class) {  
            }
                    new NodeDuressTracker(  
            boolean rateLimitReached = searchBackpressureState.getRateLimiter().request() == false;  
        return new ArrayList<>(uniqueTaskCancellations.values());
            trackers.addTracker(new CpuUsageTracker(cpuThresholdSupplier), TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);  
    // Tracker-apply rules (each tracker decides independently via this map):
        SearchBackpressureSettings settings,  
import org.opensearch.wlm.ResourceType;
            .map(this::addSBPStateUpdateCallback)
        NodeDuressTrackers nodeDuressTrackers,  
        );
    // multiple resource pressures compound, and each tracker independently contributes
                .all()  
        if (task instanceof SearchTask) {
        scheduledFuture = threadPool.scheduleWithFixedDelay(() -> {  
        } else if (task instanceof SearchShardTask) {
     */
import org.opensearch.common.settings.Setting;
            trackers.addTracker(
    SearchBackpressureService(
     * penalised when not breaching the threshold
package org.opensearch.search.backpressure;
                            .getCpuThreshold(),  
    }
            return;  
        this.searchBackpressureStates = Map.of(
                    windowSizeSetting  
            TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER  
    private final SearchBackpressureSettings settings;
import org.opensearch.monitor.process.ProcessProbe;
                    double used = OsProbe.getInstance().getProcessNativeMemoryBytes();
                    clusterSettings,
 * The OpenSearch Contributors require contributions made to  
                        () -> ProcessProbe.getInstance().getProcessCpuPercent() / 100.0 >= settings.getNodeDuressSettings()
import org.opensearch.action.search.SearchShardTask;
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType;
                .all()
            );
    }
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
                searchHeapDominated ? searchTasks : Collections.emptyList(),
 * compatible open source license.
                        return false;
            return SearchShardTask.class;  
            ),
        this.workloadGroupService = workloadGroupService;  
                settings.getSearchShardTaskSettings()::getHeapPercentThreshold,
                );  
        }
        }),
import org.opensearch.threadpool.Scheduler;
                        );  
                            .getHeapThreshold(),
    private boolean shouldApply(TaskResourceUsageTrackerType trackerType) {  
import org.opensearch.search.backpressure.stats.SearchBackpressureStats;
            cancellableTasks = Map.of(  
                settings.getSearchShardTaskSettings()::getElapsedTimeNanosThreshold,  
        if (nodeDuressTrackers.isNodeInDuress() == false) {
    protected void doStart() {
        TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER,  
            );
    protected void doStop() {
        TaskResourceTrackingService taskResourceTrackingService,  
        this.taskTrackers = Map.of(SearchTask.class, searchTaskTrackers, SearchShardTask.class, searchShardTaskTrackers);
    }
import org.opensearch.search.backpressure.trackers.HeapUsageTracker;  
                    new NodeDuressTracker(
            uniqueTaskCancellations.put(taskId, uniqueTaskCancellations.getOrDefault(taskId, taskCancellation).merge(taskCancellation));
        for (TaskResourceUsageTrackerType trackerType : TaskResourceUsageTrackerType.values()) {
        TaskResourceUsageTrackers searchTaskTrackers,
        DoubleSupplier heapVarianceSupplier,  
import java.util.function.LongSupplier;
import org.apache.logging.log4j.LogManager;
    private List<TaskCancellation> mergeTaskCancellations(final List<TaskCancellation> taskCancellations) {  
    );
            taskCancellation.cancelTaskAndDescendants(taskManager);
    private final Map<Class<? extends SearchBackpressureTask>, TaskResourceUsageTrackers> taskTrackers;
        }  
        (nodeDuressTrackers) -> nodeDuressTrackers.isResourceInDuress(ResourceType.CPU),  
        return new TaskCancellation(task, taskCancellation.getReasons(), newOnCancelCallbacks);  
import java.util.ArrayList;
    <T extends CancellableTask & SearchBackpressureTask> List<CancellableTask> getTaskByType(Class<T> type) {
 * SPDX-License-Identifier: Apache-2.0
            }
     * Filters and returns the list of currently running tasks of specified type.
import static org.opensearch.search.backpressure.trackers.HeapUsageTracker.isHeapTrackingSupported;
                    boolean breached = usedFraction >= threshold;
        return trackerApplyConditions.get(trackerType).apply(nodeDuressTrackers);
        TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,
                ),
    }
                    ResourceType.CPU,  
                searchShardTasks,  
        } else {
    }
        List<CancellableTask> searchTasks = getTaskByType(SearchTask.class);  
        this.taskManager = taskManager;
            return;  
        List<CancellableTask> searchTasks = getTaskByType(SearchTask.class);
            if (shouldApply(trackerType)) {
                getSettings().getSearchTaskSettings().getCancellationBurst(),
        } else {
                );
            try {  
            searchBackpressureStates.get(SearchShardTask.class).getLimitReachedCount(),
        Runnable toAddCancellationCallbackForSBPState = searchBackpressureStates.get(SearchShardTask.class)::incrementCancellationCount;  
        List<CancellableTask> searchShardTasks = getTaskByType(SearchShardTask.class);
    }
                searchTasks,
            new SearchBackpressureState(  
    protected void doClose() throws IOException {}
                    }
            nativeMemoryUsageService.refresh();
        CancellableTask cancellableTask = (CancellableTask) task;  
    }
        }, getSettings().getInterval(), ThreadPool.Names.GENERIC);  
        }  
            taskTrackers.get(SearchShardTask.class)  
            .collect(Collectors.toList());  
    /**
                put(
    }  
                SearchTask.class,
    }
                getSettings().getSearchShardTaskSettings().getCancellationBurst(),  
        for (TaskCancellation taskCancellation : taskCancellations) {  
        List<TaskCancellation> taskCancellations = new ArrayList<>();  
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers;
                .collect(Collectors.toUnmodifiableMap(t -> TaskResourceUsageTrackerType.fromName(t.name()), t -> t.stats(searchShardTasks)))  
            );
    // we install the native tracker, otherwise we install CPU. The map predicates only
                    )
        SearchTaskStats searchTaskStats = new SearchTaskStats(
     * Returns true if the node is in duress consecutively for the past 'n' observations.
            )  
import java.util.EnumMap;
            searchBackpressureStates.get(taskType).incrementCompletionCount();  
            if (mode != SearchBackpressureMode.ENFORCED) {
    private final ThreadPool threadPool;
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers.NodeDuressTracker;  
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);
import java.util.List;  
                taskCancellation.getTask().getId(),  
 *
            );  
            SearchShardTask.class,
import org.opensearch.search.backpressure.stats.SearchShardTaskStats;
            return;
            searchBackpressureStates.get(SearchTask.class).getCompletionCount(),
        ThreadPool threadPool,
        }  
    Class<? extends SearchBackpressureTask> getTaskType(Task task) {
     */
}
 */
                TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER
     * Given a task, returns the type of the task  
        );
            try {
                        () -> settings.getNodeDuressSettings().getNumSuccessiveBreaches()
import org.opensearch.tasks.Task;  
            taskTrackers.get(SearchTask.class)
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers;
                taskCancellation.getReasonString()
public class SearchBackpressureService extends AbstractLifecycleComponent implements TaskCompletionListener {
        LongSupplier timeNanosSupplier,
    //
     * @return unique task cancellations
import org.opensearch.search.backpressure.stats.SearchTaskStats;  
import org.opensearch.search.backpressure.trackers.CpuUsageTracker;
        TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER,
                    if (logger.isDebugEnabled()) {  
                    heapMovingAverageWindowSize,
    ) {
import org.opensearch.common.settings.ClusterSettings;
                timeNanosSupplier,
            workloadGroupService  
     * Method to reduce the taskCancellations into unique bunch
                    }
            }
 * @opensearch.internal  
                getSettings().getSearchTaskSettings().getCancellationRateNanos(),  
            boolean searchHeapDominated = isHeapUsageDominatedBySearch(
        Setting<Integer> windowSizeSetting  
    private final TaskManager taskManager;
    }
        List<Exception> exceptions = new ArrayList<>();  
            .filter(TaskCancellation::isEligibleForCancellation)
    }
                settings.getSearchTaskSettings()::getCpuTimeNanosThreshold,
        }
            ),
    @Override
            } catch (Exception e) {  
     */
import java.util.Collections;  
        DoubleSupplier nativeMemoryPercentThresholdSupplier,
    /**
    private final NodeDuressTrackers nodeDuressTrackers;
                .collect(Collectors.toUnmodifiableMap(t -> TaskResourceUsageTrackerType.fromName(t.name()), t -> t.stats(searchTasks)))
    ) {
     * @param threshold   miniumum  jvm allocated bytes ratio w.r.t. available heap  
import org.opensearch.tasks.TaskCancellation;
        // We need to merge them
            .collect(Collectors.toUnmodifiableList());
                settings.getSearchShardTaskSettings()::getCpuTimeNanosThreshold,
                getSettings().getSearchTaskSettings().getTotalHeapPercentThreshold()  
                settings.getSearchTaskSettings().getHeapMovingAverageWindowSize(),
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;  
        this.settings = settings;  
        this.threadPool = threadPool;  
            );
            throw new IllegalArgumentException("task must be instance of either SearchTask or SearchShardTask");
        // Since these cancellations might be duplicate due to multiple trackers causing cancellation for same task
                mode.getName(),
            );
        taskResourceTrackingService.refreshResourceStats(searchShardTasks.toArray(new Task[0]));
    ) {
            searchBackpressureStates.get(SearchTask.class).getLimitReachedCount(),  
                getSettings().getSearchTaskSettings().getCancellationRatio(),
            }
        }
        trackers.addTracker(
    // - Heap tracker fires when heap is in duress (and heap tracking is supported).
import org.opensearch.tasks.CancellableTask;
        this.taskResourceTrackingService.addTaskCompletionListener(this);
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
                            String.format(java.util.Locale.ROOT, "%.4f", usedFraction),  
        DoubleSupplier heapPercentThresholdSupplier,
            taskResourceUsageTracker.ifPresent(
        }  
import java.util.function.Function;
            }  
        final Map<Long, TaskCancellation> uniqueTaskCancellations = new HashMap<>();
                SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE  
import org.opensearch.wlm.WorkloadGroupService;
    private TaskCancellation addSBPStateUpdateCallback(TaskCancellation taskCancellation) {
                tracker -> taskCancellations.addAll(tracker.getTaskCancellations(cancellableTasks.get(taskType)))  
                    double threshold = settings.getNodeDuressSettings().getNativeMemoryThreshold();
                settings.getClusterSettings(),
    /**
        final boolean isNativeMemoryInDuress = nodeDuressTrackers.isNativeMemoryInDuress();  
import org.opensearch.tasks.SearchBackpressureTask;
import java.util.function.DoubleSupplier;  
            logger.warn(  
    @Override
            .values()  
        }  
     * Given the threshold suppliers, returns the list of applicable trackers
                    )
import org.opensearch.monitor.os.OsProbe;
import org.opensearch.tasks.TaskManager;
    // tracker that wasn't installed (Optional.ifPresent in TaskResourceUsageTrackers).  
        SearchBackpressureMode mode = getSettings().getMode();  
            } catch (Exception e) {
        }
        WorkloadGroupService workloadGroupService
            final long taskId = taskCancellation.getTask().getId();
import org.opensearch.monitor.jvm.JvmStats;  
        if (task instanceof SearchBackpressureTask == false) {
    }
                "[{} mode] cancelling task [{}] due to high resource consumption [{}]",
import org.opensearch.ExceptionsHelper;  
            scheduledFuture.cancel();  
        return HeapUsageTracker.isHeapUsageDominatedBySearch(searchTasks, threshold);
                logger.debug("task cancellation limit reached");
 * this file be licensed under the Apache-2.0 license or a
                searchBackpressureState.incrementLimitReachedCount();  
    /**
            return SearchTask.class;
                settings.getSearchTaskSettings()::getHeapPercentThreshold,  
        );
                continue;
import org.opensearch.search.backpressure.settings.SearchBackpressureMode;  
            new ElapsedTimeTracker(ElapsedTimeNanosSupplier, System::nanoTime),
                    }  
                timeNanosSupplier,
        ThreadPool threadPool,
        }
    }
                    double totalNative = settings.getNodeDuressSettings().getNodeNativeMemory();
                    heapPercentThresholdSupplier,  
                SearchShardTask.class,  
            if (rateLimitReached && ratioLimitReached) {
        return taskResourceTrackingService.getResourceAwareTasks()
        TaskResourceTrackingService taskResourceTrackingService,
import java.io.IOException;
        if (isNativeMemoryInDuress) {  
     */
    private final TaskResourceTrackingService taskResourceTrackingService;  
    private static final Logger logger = LogManager.getLogger(SearchBackpressureService.class);  
 * SearchBackpressureService is responsible for monitoring and cancelling in-flight search tasks if they are  
    @Override  
                            logger.debug("native memory duress probe: signal unavailable (usedBytes={})", used);  
            getTrackers(
            // Independently remove tokens from both token buckets.
                logger.debug("failure in search search backpressure", e);
            trackers.addTracker(  
                TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER  
    // When native-memory duress is active, doRun() bypasses the heap-dominance gate so all
                break;
    @Override
            return;
                getSettings().getSearchShardTaskSettings().getCancellationRateNanos(),
        List<Runnable> newOnCancelCallbacks = new ArrayList<>(taskCancellation.getOnCancelCallbacks());
            SearchBackpressureState searchBackpressureState = searchBackpressureStates.get(taskType);
        }
import org.opensearch.tasks.TaskResourceTrackingService.TaskCompletionListener;
    ) {
        taskResourceTrackingService.refreshResourceStats(searchTasks.toArray(new Task[0]));  
            ),  
                        }
        for (TaskResourceUsageTracker tracker : trackers.all()) {
    }  
        this.settings.getSearchShardTaskSettings().addListener(searchBackpressureStates.get(SearchShardTask.class));  
import org.opensearch.search.backpressure.trackers.ElapsedTimeTracker;
    // gate on duress; addResourceTrackerBasedCancellations is a no-op for any
            }
     * Had to define this method to help mock this static method to test the scenario where SearchTraffic should not be  
    private final NativeMemoryUsageService nativeMemoryUsageService = NativeMemoryUsageService.getInstance();
        this.taskResourceTrackingService = taskResourceTrackingService;
import org.opensearch.action.search.SearchTask;
        // Force-refresh usage stats of these tasks before making a cancellation decision.
    // cancellation reasons that are merged before execution.  
    // metrics). If heap is ALSO in duress simultaneously, its tracker will fire too —
                    if (totalNative <= 0) {  
            searchBackpressureStates.get(SearchShardTask.class).getCompletionCount(),
    // in-flight tasks become cancellation candidates (off-heap pressure is invisible to heap  
                getSettings().getSearchShardTaskSettings().getCancellationRatio(),
                put(ResourceType.NATIVE_MEMORY, new NodeDuressTracker(() -> {  
            searchBackpressureStates.get(SearchShardTask.class).getCancellationCount(),  
        }
        List<TaskCancellation> taskCancellations,  
/**
        );
            boolean searchShardHeapDominated = isHeapUsageDominatedBySearch(
        List<CancellableTask> searchShardTasks = getTaskByType(SearchShardTask.class);  
                settings.getSearchTaskSettings()::getNativeMemoryPercentThreshold,  
    // - CPU tracker fires when CPU is in duress. CPU and native trackers are mutually
            {
     */  
                settings.getClusterSettings(),
            );
    boolean isHeapUsageDominatedBySearch(List<CancellableTask> searchTasks, double threshold) {  
                        logger.debug(
    /**
        this.settings.getSearchTaskSettings().addListener(searchBackpressureStates.get(SearchTask.class));
        for (TaskCancellation taskCancellation : taskCancellations) {
        LongSupplier ElapsedTimeNanosSupplier,  
    }  
            .entrySet()) {
 * breaching resource usage limits when the node is in duress.
        return searchBackpressureStates.get(taskType);
                    return breached;
            .filter(workloadGroupService::shouldSBPHandle)
            getTrackers(  
        }  
                doRun();
        if (isHeapTrackingSupported()) {
            logger.warn("heap size couldn't be determined");
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
        return settings;  
        this.nodeDuressTrackers = nodeDuressTrackers;
                    double usedFraction = used / totalNative;  
        if (cancellableTask.isCancelled() == false) {
import java.util.Optional;
    public static TaskResourceUsageTrackers getTrackers(
                            breached
     * @param taskCancellations all task cancellations  
        SearchShardTaskStats searchShardTaskStats = new SearchShardTaskStats(
