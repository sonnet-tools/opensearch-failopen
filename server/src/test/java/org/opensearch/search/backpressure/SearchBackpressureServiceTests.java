                return type.getName();
        assertFalse(service.isNodeInDuress());
                }
        );
            TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,
            public Optional<TaskCancellation.Reason> checkAndMaybeGetCancellationReason(Task task) {
                mockTimeNanosSupplier,
            // Prime the native-memory duress streak (consecutive-breach window is 3).
        TaskResourceUsageTracker mockTaskResourceUsageTracker = getMockedTaskResourceUsageTracker(
            org.opensearch.search.backpressure.NativeMemoryUsageService.getInstance().setSnapshotSupplier(Collections::emptyMap);
import org.opensearch.wlm.WorkloadGroupTask;
            new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker),
            taskManager,
                    put(CPU, new NodeDuressTracker(() -> false, () -> 3));
                put(MEMORY, new NodeDuressTracker(() -> false, () -> 3));
            mockTimeNanosSupplier,
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
import java.io.IOException;
        verify(mockTaskManager, times(5)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
        // Run two iterations so that node is marked 'in duress' from the third iteration onwards.
                TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER,
        );
     * CPU and native trackers are mutually exclusive at install time:
    WorkloadGroupService workloadGroupService;
            (task) -> {
            // Exactly the heavy tasks were cancelled — no extras from the "always cancel" CPU/heap mocks.
                )
        assertEquals(3, service.getSearchBackpressureState(SearchShardTask.class).getLimitReachedCount());
import org.opensearch.tasks.TaskManager;
    private SearchBackpressureSettings getBackpressureSettings(String mode, double ratio, double rate, double burst) {
            // candidates. Heap/CPU would want to cancel all 20 — verifying this test's whole point.
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
import org.opensearch.common.settings.Settings;
        long taskHeapUsageBytes = 500;
                    new MockStats(5),
            (task) -> Optional.of(new TaskCancellation.Reason("mem exceeded", 10))
        mockTime.addAndGet(TimeUnit.SECONDS.toNanos(10));
import org.opensearch.core.common.io.stream.StreamInput;
            new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker),
            org.opensearch.search.backpressure.NativeMemoryUsageService.getInstance().resetForTesting();
            TaskResourceUsageTrackers withBackend = SearchBackpressureService.getTrackers(
        SearchBackpressureService service = new SearchBackpressureService(
import org.opensearch.search.backpressure.settings.SearchTaskSettings;
        service.doRun();
            // native-memory tracker is the only one that should contribute cancellations.
        };
        SearchBackpressureSettings settings = getBackpressureSettings("enforced", 0.1, 0.003, 10.0);
 */
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.wlm.ResourceType;
            }
        public MockStats(long cancellationCount) {
            verify(mockTaskManager, times(4)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
import org.opensearch.tasks.TaskCancellationService;
        service.doRun();
        TaskManager mockTaskManager = spy(taskManager);
    }
                activeSearchTasks.put(i, createMockTaskWithResourceStats(SearchTask.class, 100, taskHeapUsageBytes, i));
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker);
     */
                put(MEMORY, heapUsageTracker);
            MockStats mockStats = (MockStats) o;
 * compatible open source license.
                put(MEMORY, new NodeDuressTracker(() -> false, () -> 3));
            new SearchShardTaskStats(12, 3, 20, Map.of(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER, new MockStats(12))),
            assertEquals(4, service.getSearchBackpressureState(SearchTask.class).getCancellationCount());
            // CPU must be the one that's installed.
        when(searchTaskSettings.getTotalHeapPercentThreshold()).thenReturn(0.0);
        service.doRun();
            // Native-memory tracker: cancels tasks whose memory bytes exceed a modest threshold.
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
        assertEquals(100, service.getSearchBackpressureState(SearchShardTask.class).getCompletionCount());
        SearchBackpressureService service = new SearchBackpressureService(
                clusterSettings,
            );
        public boolean equals(Object o) {
        boolean cpu = trackers.getTracker(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER).isPresent();
        assertEquals(2, service.getSearchBackpressureState(SearchTask.class).getLimitReachedCount());
        SearchBackpressureStats actualStats = service.nodeStats();
                (task) -> {
    public void testTrackerStateUpdateOnSearchTaskCompletion() {
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        AtomicReference<Double> heapUsage = new AtomicReference<>();
import static org.mockito.Mockito.anyList;
            new TaskResourceUsageTrackers(),
            assertFalse(withoutBackend.getTracker(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER).isPresent());
import org.opensearch.action.search.SearchTask;
                () -> 1.0,
                }
        AtomicReference<Double> cpuUsage = new AtomicReference<>();
            public void update(Task task) {}
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
        TaskResourceUsageTracker.ResourceUsageBreachEvaluator evaluator
            public Stats stats(List<? extends Task> tasks) {
            // any platform (the Linux + provider + physMem gate fails on the provider check).
        service.doRun();
        try {
            );
                put(CPU, mockNodeDuressTracker);
                clusterSettings,
        service.doRun();
    MockTransportService transportService;
                }
                put(CPU, new NodeDuressTracker(() -> true, () -> 3));
        SearchBackpressureSettings settings = getBackpressureSettings("enforced", 0.1, 0.003, 5.0);
    @After
import org.opensearch.tasks.Task;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers.NodeDuressTracker;
            Settings.EMPTY,
        // which today requires Linux + a readable /proc/meminfo. Non-Linux test hosts cannot
        TaskManager mockTaskManager = spy(taskManager);
                100,
            @Override
            service.onTaskCompleted(createMockTaskWithResourceStats(SearchTask.class, 100, 200, i));
                put(CPU, mockNodeDuressTracker);
import java.util.function.BooleanSupplier;
        SearchBackpressureStats expectedStats = new SearchBackpressureStats(
        Map<Long, WorkloadGroupTask> activeSearchTasks = new HashMap<>();
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers;
        assertEquals(expectedStats, actualStats);
        // Creating heap and cpu usage trackers where heap tracker will always evaluate with reasons to cancel the
import static org.opensearch.wlm.ResourceType.CPU;
        // setting the total heap percent threshold to minimum so that circuit does not break in SearchBackpressureService
import static org.mockito.ArgumentMatchers.anyString;
        TaskResourceUsageTracker cpuUsageTracker = getMockedTaskResourceUsageTracker(
        service.doRun();
            )
        doReturn(activeSearchTasks).when(mockTaskResourceTrackingService).getResourceAwareTasks();
    }
        SearchBackpressureService service = new SearchBackpressureService(
    }
                    new MockStats(0)
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType;
            } else {
            );
            threadPool,
                return Optional.of(new TaskCancellation.Reason("limits exceeded", 5));
        );
        );
        @Override
    }
        threadPool = new TestThreadPool(getClass().getName());
                    return Optional.empty();
            taskResourceUsageTrackers,
        verify(mockTaskManager, times(10)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
        SearchBackpressureService service = new SearchBackpressureService(
        TaskResourceUsageTracker cpuUsageTracker = getMockedTaskResourceUsageTracker(
        // reflected in SearchShardTaskStats.
                        return Optional.empty();
        heapUsage.set(0.0);
    public void testIsNodeInDuress() {
import java.util.List;
        // Create a mix of low and high resource usage tasks (60 low + 15 high resource usage tasks).
            if (o == null || getClass() != o.getClass()) return false;
            // No backend installed.
        doReturn(activeSearchTasks).when(mockTaskResourceTrackingService).getResourceAwareTasks();
            return cancellationCount == mockStats.cancellationCount;
        service.doRun();
            new SearchTaskStats(
        // Run two iterations so that node is marked 'in duress' from the third iteration onwards.
import org.opensearch.common.settings.ClusterSettings;
            System::nanoTime,
            SearchBackpressureMode.ENFORCED
            mockTimeNanosSupplier,
        @Override
        activeSearchShardTasks.values().forEach(task -> task.setWorkloadGroupId(threadPool.getThreadContext()));
            assertTrue(withBackend.getTracker(TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER).isPresent());
        // for SearchTaskStats here.
                () -> 1L,
    private static void assertCpuXorNative(TaskResourceUsageTrackers trackers) {
            settings,
        // Mocking 'settings' with predictable rate limiting thresholds.
    public void testSearchShardTaskInFlightCancellation() {
            }
            }
import org.opensearch.search.backpressure.settings.SearchBackpressureMode;
    public void testSearchTaskInFlightCancellation() {
        // Node not in duress.
                () -> 0.0,
        LongSupplier mockTimeNanosSupplier = () -> TimeUnit.SECONDS.toNanos(1234);
                withoutBackend.getTracker(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER).isPresent()
                mockTaskManager,
        NodeDuressTracker cpuUsageTracker = new NodeDuressTracker(() -> cpuUsage.get() >= 0.5, () -> 5);
            settings,
            nodeDuressTrackers,
                mockTaskResourceTrackingService,
    }
            taskResourceUsageTrackers.addTracker(nativeMemoryTracker, TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER);
                {
            SearchBackpressureSettings settings = getBackpressureSettings("enforced", 0.1, 0.003, 10.0);
        // and reset it in finally so other tests don't see leftover state.
            new SearchShardTaskStats(0, 0, 0, Collections.emptyMap()),
        // Record task completions to update the tracker state. Tasks other than SearchTask & SearchShardTask are ignored.
            }
                () -> 1.0,
            }
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
            mockTimeNanosSupplier,
        // There are 15 SearchShardTasks eligible for cancellation but only 10 will be cancelled (burst limit).
        // This will add 50 tokens (time delta * rate) to 'rateLimitPerTime' but it will cancel only 5 tasks (burst limit).
        SearchBackpressureStats expectedStats = new SearchBackpressureStats(
                    }
            TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
        );
        LongSupplier mockTimeNanosSupplier = mockTime::get;
        service.onTaskCompleted(createMockTaskWithResourceStats(CancellableTask.class, 100, 200, 101));
        );
        TaskManager mockTaskManager = spy(taskManager);
            }
        @Override
    }
            Class<? extends WorkloadGroupTask> taskType = randomBoolean() ? SearchTask.class : SearchShardTask.class;
                activeSearchTasks.put(i, createMockTaskWithResourceStats(SearchTask.class, 100, memoryBytes, i));
            TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
        TaskResourceUsageTracker mockTaskResourceUsageTracker = mock(TaskResourceUsageTracker.class);
            }
        assertEquals(0, service.getSearchBackpressureState(SearchTask.class).getCancellationCount());
                    return Optional.of(new TaskCancellation.Reason("native memory exceeded", 5));
        // Node not in duress anymore.
        SearchTaskSettings searchTaskSettings = mock(SearchTaskSettings.class);
                    TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
            assertCpuXorNative(withBackend);
                activeSearchTasks.put(i, createMockTaskWithResourceStats(SearchTask.class, 500, 800, i));
        verify(mockTaskManager, times(10)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
            }
                }
import static org.mockito.Mockito.any;
        // Verify search backpressure stats. Since we are not marking any task as completed the completionCount will be 0
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
                () -> 1L,
            mockTaskManager,
        taskManager.setTaskCancellationService(new TaskCancellationService(transportService));
import org.opensearch.core.common.io.stream.StreamOutput;
            TaskResourceUsageTrackers withoutBackend = SearchBackpressureService.getTrackers(
            LongSupplier mockTimeNanosSupplier = mockTime::get;
                long memoryBytes = (i % 5 == 0) ? 800 : 100;
        service.doRun();
            ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            new TaskResourceUsageTrackers(),
                (task) -> Optional.empty()
            );
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
        transportService.acceptIncomingRequests();
        when(service.isHeapUsageDominatedBySearch(anyList(), anyDouble())).thenReturn(false);
            service.onTaskCompleted(createMockTaskWithResourceStats(SearchShardTask.class, 100, 200, i));
import java.util.Optional;
            TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,
                () -> 0.0,
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
        Map<Long, WorkloadGroupTask> activeSearchTasks = new HashMap<>();
        EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {
            assertCpuXorNative(withoutBackend);
            (task) -> {
            TaskResourceUsageTracker nativeMemoryTracker = getMockedTaskResourceUsageTracker(
        activeSearchTasks.values().forEach(task -> task.setWorkloadGroupId(threadPool.getThreadContext()));
                mockTimeNanosSupplier,
            // CPU/heap ResourceType duress both OFF — only the native-memory probe is firing.
            } else {
        taskManager = transportService.getTaskManager();
import static org.opensearch.search.backpressure.SearchBackpressureTestHelpers.createMockTaskWithResourceStats;
                activeSearchTasks.put(i, createMockTaskWithResourceStats(SearchTask.class, 100, 800, i));
            }
        when(settings.getSearchTaskSettings()).thenReturn(searchTaskSettings);
        cpuUsage.set(0.0);
        SearchBackpressureSettings settings = getBackpressureSettings("enforced", 0.1, 0.003, 10.0);
import org.opensearch.wlm.WorkloadGroupService;
            nodeDuressTrackers,
            (task) -> {
        TaskResourceUsageTracker mockTaskResourceUsageTracker = mock(TaskResourceUsageTracker.class);
            {
            {
        // snapshot provider on NativeMemoryUsageService. The mock tracker in this test
        taskResourceUsageTrackers.addTracker(cpuUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
        SearchShardTaskSettings searchShardTaskSettings = mock(SearchShardTaskSettings.class);
            )
}
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
import java.util.HashMap;
            // Don't leak the sentinel supplier into other tests in this suite.
            taskResourceUsageTrackers,
                SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
                return Optional.of(new TaskCancellation.Reason("limits exceeded", 5));
        assertEquals(0, service.getSearchBackpressureState(SearchShardTask.class).getCancellationCount());
            this.cancellationCount = cancellationCount;
        try {
            };
            } else {
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
        for (long i = 0; i < 75; i++) {
        EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {
        // Simulate task completion to replenish some tokens.
        // this will trigger cancellation but these cancellation should only be cpu based
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
            }
                }
            mockTaskManager,
            new SearchBackpressureSettings(
            }
                taskResourceUsageTrackers,
        verify(mockTaskManager, times(12)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
        // Mocking 'settings' with predictable rate limiting thresholds.
        // Node in duress; but not for many consecutive data points.
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker);
        );
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        } finally {
                if (task.getTotalResourceStats().getCpuTimeInNanos() < 400) {
            }
                    return Optional.empty();
        TaskResourceUsageTracker heapUsageTracker = getMockedTaskResourceUsageTracker(
        );
        taskResourceUsageTrackers.addTracker(mockTaskResourceUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
        heapUsage.set(1.0);
        );
        }
import java.util.EnumMap;
                settings,
            AtomicLong mockTime = new AtomicLong(0);
        // this will trigger cancellation but the cancellation should not happen as the node is not is duress because of search traffic
        verify(mockTaskManager, times(5)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
            when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
        for (long i = 0; i < 75; i++) {
        long taskHeapUsageBytes = 500;
        }
            // When native-memory duress is active, heap/CPU trackers MUST NOT run. We install
            @Override
    @Before
        cpuUsage.set(0.0);
        NodeDuressTracker mockNodeDuressTracker = new NodeDuressTracker(() -> true, () -> 3);
    }
            NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker);
import org.junit.Before;
        // The native-memory tracker-apply condition is gated on isNativeTrackingSupported(),
        LongSupplier mockTimeNanosSupplier = mockTime::get;
import org.opensearch.Version;
            if (i % 5 == 0) {
            settings,
            if (i % 3 == 0) {
        SearchBackpressureService service = new SearchBackpressureService(
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
import java.util.concurrent.atomic.AtomicLong;
        verify(mockTaskManager, times(10)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
            new TaskResourceUsageTrackers(),
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
            if (i % 5 == 0) {
        for (int i = 0; i < 100; i++) {
        activeSearchTasks.values().forEach(task -> task.setWorkloadGroupId(threadPool.getThreadContext()));
import java.util.Collections;
            taskResourceUsageTrackers,
        // Mocking 'settings' with predictable totalHeapBytesThreshold so that cancellation logic doesn't get skipped.
import org.opensearch.tasks.CancellableTask;
        assertEquals(1, service.getSearchBackpressureState(SearchShardTask.class).getLimitReachedCount());
                () -> 1L,
        SearchBackpressureStats expectedStats = new SearchBackpressureStats(
        for (long i = 0; i < 75; i++) {
        // Create a mix of low and high resource usage SearchTasks (50 low + 25 high resource usage tasks).
        // Mocking 'settings' with predictable totalHeapBytesThreshold so that cancellation logic doesn't get skipped.
                }
                return evaluator.evaluate(task);
     * Exactly one of the two is in {@code TaskResourceUsageTrackers}, never both, never neither.
                workloadGroupService
    }
        for (int i = 0; i < 100; i++) {
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
                TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER,
        }
            {
                () -> 1.0,
 * The OpenSearch Contributors require contributions made to
            new TaskResourceUsageTrackers(),
        // Creating heap and cpu usage trackers where heap tracker will always evaluate with reasons to cancel the
            threadPool,
        assumeTrue("native memory tracking is only supported on Linux", org.apache.lucene.util.Constants.LINUX);
        // This will add 2 tokens (task count delta * cancellationRatio) to 'rateLimitPerTaskCompletion'.
            SearchBackpressureMode.ENFORCED
            mockTaskManager,
        assertEquals(1, service.getSearchBackpressureState(SearchTask.class).getLimitReachedCount());
            }
                Settings.builder().put(SearchBackpressureSettings.SETTING_MODE.getKey(), mode).build(),
            new TaskResourceUsageTrackers(),
     * {@code isNativeTrackingSupported()} → install native, otherwise install CPU.
            {
            taskManager,
            // Elapsed-time tracker left silent so the cancellation count is unambiguously from
            threadPool,
    }
        for (int i = 0; i < 20; i++) {
            } else {
            taskResourceUsageTrackers.addTracker(cpuUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
        }
            }
        );
                nodeDuressTrackers,
                Map.of(
            );
        assertTrue(service.isNodeInDuress());
        EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {
        assertEquals(100, service.getSearchBackpressureState(SearchTask.class).getCompletionCount());
            taskResourceUsageTrackers,
            Settings.EMPTY,
        workloadGroupService = mock(WorkloadGroupService.class);
    public void testGetTrackersInstallsExactlyOneOfCpuOrNative() {
        transportService.close();
        verify(mockTaskManager, times(5)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
import static org.mockito.ArgumentMatchers.anyBoolean;
        when(searchTaskSettings.getTotalHeapPercentThreshold()).thenReturn(0.0);
            service.doRun();
import static org.opensearch.wlm.ResourceType.MEMORY;
            );
        service.doRun();
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        SearchBackpressureSettings settings = getBackpressureSettings("enforced", 0.1, 0.003, 10.0);
        // There are 25 SearchTasks eligible for cancellation but only 5 will be cancelled (burst limit).
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        when(settings.getSearchTaskSettings()).thenReturn(searchTaskSettings);
        taskResourceUsageTrackers.addTracker(mockTaskResourceUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
            mockTaskResourceTrackingService,
        };
                (task) -> Optional.of(new TaskCancellation.Reason("heap (should not fire)", 10))
        EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {
        Map<Long, WorkloadGroupTask> activeSearchShardTasks = new HashMap<>();
                activeSearchTasks.put(i, createMockTaskWithResourceStats(SearchTask.class, 500, taskHeapUsageBytes, i));
    }
            service.doRun();
                TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
            // Mutual exclusion still holds; which one wins depends on the platform.
    private static class MockStats implements TaskResourceUsageTracker.Stats {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                    if (task.getTotalResourceStats().getMemoryInBytes() < 500) {
            new NodeDuressTrackers(new EnumMap<>(ResourceType.class), resourceCacheExpiryChecker),
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
        @Override
        // doesn't go through that path, so we install a sentinel non-empty supplier here
            {
            }
import java.util.concurrent.atomic.AtomicReference;
    public void testNonCancellationWhenSearchTrafficIsNotQualifyingForCancellation() {
        };
import static org.mockito.Mockito.spy;
    public void testNonCancellationOfHeapBasedTasksWhenHeapNotInDuress() {
    ThreadPool threadPool;
            org.opensearch.search.backpressure.NativeMemoryUsageService.getInstance().resetForTesting();
        // If the clock or completed task count haven't made sufficient progress, we'll continue to be rate-limited.
            TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
        SearchTaskSettings searchTaskSettings = mock(SearchTaskSettings.class);
                put(ResourceType.CPU, cpuUsageTracker);
        }
    }
import static org.mockito.Mockito.when;
            threadPool,
            settings,
                activeSearchShardTasks.put(i, createMockTaskWithResourceStats(SearchShardTask.class, 500, taskHeapUsageBytes, i));
                    return Optional.empty();
            workloadGroupService
                SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
        when(searchTaskSettings.getTotalHeapPercentThreshold()).thenReturn(0.0);
import org.opensearch.action.search.SearchShardTask;
                if (task.getTotalResourceStats().getCpuTimeInNanos() < 300) {
                TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,
            new SearchBackpressureService(
import static org.mockito.Mockito.anyDouble;
            // "always cancel" mocks for CPU and heap, and confirm nothing trips from them; the
        public MockStats(StreamInput in) throws IOException {
        heapUsage.set(0.0);
                    return Optional.empty();
        }
                1,
    /**
        // Mocking 'settings' with predictable rate limiting thresholds.
import org.opensearch.test.transport.MockTransportService;
            if (i % 5 == 0) {
            ),
            out.writeVLong(cancellationCount);
import java.util.Map;
            workloadGroupService
            workloadGroupService
        boolean native_ = trackers.getTracker(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER).isPresent();
            taskResourceUsageTrackers.addTracker(heapUsageTracker, TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER);
        );
import org.opensearch.search.backpressure.stats.SearchShardTaskStats;
        assertTrue("exactly one of CPU/native trackers must be installed (cpu=" + cpu + ", native=" + native_ + ")", cpu ^ native_);
    public void testNativeMemoryDuressRunsOnlyNativeMemoryAndElapsedTrackers() {
        TaskResourceUsageTracker mockTaskResourceUsageTracker = getMockedTaskResourceUsageTracker(
            EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {
public class SearchBackpressureServiceTests extends OpenSearchTestCase {
                return new MockStats(getCancellations());
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
        AtomicLong mockTime = new AtomicLong(0);
                taskResourceUsageTrackers,
        AtomicLong mockTime = new AtomicLong(0);
        taskResourceUsageTrackers.addTracker(heapUsageTracker, TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER);
        Map<Long, WorkloadGroupTask> activeSearchTasks = new HashMap<>();
                    TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,
        taskResourceUsageTrackers.addTracker(cpuUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
        );
        SearchBackpressureStats actualStats = service.nodeStats();
        NodeDuressTracker heapUsageTracker = new NodeDuressTracker(() -> heapUsage.get() >= 0.5, () -> 6);
            mockTaskResourceTrackingService,
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers;
            // Unconditionally-cancelling CPU + heap trackers. These should never be consulted.
                if (task.getTotalResourceStats().getCpuTimeInNanos() < 400) {
        );
    public void setup() {
        );
        };
        verify(mockTaskResourceUsageTracker, times(100)).update(any());
        TaskResourceUsageTrackerType type,
        SearchBackpressureStats actualStats = service.nodeStats();
    final BooleanSupplier resourceCacheExpiryChecker = () -> true;
                if (task.getTotalResourceStats().getCpuTimeInNanos() < 300) {
                return Optional.of(new TaskCancellation.Reason("cpu time limit exceeded", 5));
        }
        SearchBackpressureSettings settings = new SearchBackpressureSettings(
            new SearchTaskStats(0, 0, 0, Collections.emptyMap()),
        AtomicLong mockTime = new AtomicLong(0);
    private TaskResourceUsageTracker getMockedTaskResourceUsageTracker(
        }
                mockTaskManager,
     * (Linux-only signal) so CPU is always installed regardless of supplier installation.
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);
        assertEquals(expectedStats, actualStats);
            TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
        // Node in duress for consecutive data points.
            org.opensearch.search.backpressure.NativeMemoryUsageService.getInstance().resetForTesting();
                    put(ResourceType.NATIVE_MEMORY, new NodeDuressTracker(() -> true, () -> 3));
    public void cleanup() {
        assertEquals(3, service.getSearchBackpressureState(SearchTask.class).getLimitReachedCount());
        return new TaskResourceUsageTracker() {
            activeSearchTasks.values().forEach(task -> task.setWorkloadGroupId(threadPool.getThreadContext()));
        NodeDuressTracker heapUsageTracker = new NodeDuressTracker(() -> false, () -> 3);
            workloadGroupService
                mockTaskResourceTrackingService,
        when(searchShardTaskSettings.getTotalHeapPercentThreshold()).thenReturn(0.0);
        // exercise this short-circuit regardless of how the fixtures are wired.
            TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
                nodeDuressTrackers,
import org.opensearch.threadpool.TestThreadPool;
        doReturn(activeSearchTasks).when(mockTaskResourceTrackingService).getResourceAwareTasks();
            }
import org.opensearch.core.xcontent.XContentBuilder;
        );
        service.doRun();
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
        verify(mockTaskResourceUsageTracker, times(100)).update(any());
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker);
        taskResourceUsageTrackers.addTracker(mockTaskResourceUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
                activeSearchTasks.put(i, createMockTaskWithResourceStats(taskType, 500, 800, i));
        service.doRun();
            public String name() {
        };
            }
        }
 *
                put(ResourceType.MEMORY, heapUsageTracker);
        public int hashCode() {
        SearchBackpressureSettings settings = new SearchBackpressureSettings(
        assertFalse(service.isNodeInDuress());
                threadPool,
        );
        assertEquals(expectedStats, actualStats);
        LongSupplier mockTimeNanosSupplier = mockTime::get;
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
        assertEquals(1, service.getSearchBackpressureState(SearchTask.class).getLimitReachedCount());
        assertFalse(service.isNodeInDuress());
        cpuUsage.set(1.0);
            TaskResourceUsageTracker cpuUsageTracker = getMockedTaskResourceUsageTracker(
        EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {
            @Override
        );
                () -> 1.0,
import org.opensearch.search.backpressure.stats.SearchBackpressureStats;
        org.opensearch.search.backpressure.NativeMemoryUsageService.getInstance().setSnapshotSupplier(java.util.Collections::emptyMap);
            new NodeDuressTrackers(new EnumMap<>(ResourceType.class), resourceCacheExpiryChecker),
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
        assertEquals(5, service.getSearchBackpressureState(SearchTask.class).getCancellationCount());
import static org.mockito.Mockito.verify;
            TaskResourceUsageTracker elapsedTimeTracker = getMockedTaskResourceUsageTracker(
        SearchBackpressureService service = new SearchBackpressureService(
        }
        // setting the total heap percent threshold to minimum so that circuit does not break in SearchBackpressureService
            return Objects.hash(cancellationCount);
        // Create a mix of low and high resource usage tasks (60 low + 15 high resource usage tasks).
        private final long cancellationCount;
        SearchBackpressureSettings settings = new SearchBackpressureSettings(
            threadPool,
            new SearchShardTaskStats(0, 0, 0, Collections.emptyMap()),
            return builder.startObject().field("cancellation_count", cancellationCount).endObject();
            doReturn(activeSearchTasks).when(mockTaskResourceTrackingService).getResourceAwareTasks();
            TaskManager mockTaskManager = spy(taskManager);
            // service.onTaskCompleted(new SearchTask(1, "test", "test", () -> "Test", TaskId.EMPTY_TASK_ID, new HashMap<>()));
        // tasks but heap based cancellation should not happen because heap is not in duress
        // setting the total heap percent threshold to minimum so that circuit does not break in SearchBackpressureService
            TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
        SearchBackpressureService service = spy(
import org.opensearch.search.backpressure.stats.SearchTaskStats;
import org.opensearch.tasks.TaskResourceTrackingService;
            this(in.readVLong());
        // Mocking 'settings' with predictable rate limiting thresholds.
 * SPDX-License-Identifier: Apache-2.0
        TaskManager mockTaskManager = spy(taskManager);
        doReturn(activeSearchShardTasks).when(mockTaskResourceTrackingService).getResourceAwareTasks();
            mockTaskResourceTrackingService,
import java.util.function.LongSupplier;
        assertEquals(2, service.getSearchBackpressureState(SearchShardTask.class).getLimitReachedCount());
            new TaskResourceUsageTrackers(),
            // Load 20 tasks; 4 are heavy (mem >= 500) so exactly 4 are native-memory cancellation
                100,
        return spy(
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
        );
    }
            (task) -> Optional.of(new TaskCancellation.Reason("mem exceeded", 10))
            assertTrue(
                workloadGroupService
                put(MEMORY, new NodeDuressTracker(() -> false, () -> 3));
        LongSupplier mockTimeNanosSupplier = mockTime::get;
    }
            SearchBackpressureService service = new SearchBackpressureService(
            (task) -> {
            // the native-memory tracker.
                threadPool,
            mockTaskResourceTrackingService,
            workloadGroupService
    TaskManager taskManager;
        taskResourceUsageTrackers.addTracker(heapUsageTracker, TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER);
        service.doRun();
            if (this == o) return true;
        // tasks but heap based cancellation should not happen because heap is not in duress
            mockTimeNanosSupplier,
    ) {
            mockTimeNanosSupplier,
        AtomicLong mockTime = new AtomicLong(0);
            service.doRun();
        NodeDuressTracker mockNodeDuressTracker = new NodeDuressTracker(() -> true, () -> 3);
            service.onTaskCompleted(createMockTaskWithResourceStats(SearchShardTask.class, 100, taskHeapUsageBytes, i));
            taskResourceUsageTrackers.addTracker(elapsedTimeTracker, TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER);
    }
            new SearchTaskStats(10, 3, 0, Map.of(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER, new MockStats(10))),
import org.opensearch.tasks.TaskCancellation;
        verify(mockTaskManager, times(0)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
            // Install a snapshot supplier — same proxy a real backend would set.
        }
            TaskResourceUsageTracker heapUsageTracker = getMockedTaskResourceUsageTracker(
        assertFalse(service.isNodeInDuress());
            settings,
        activeSearchTasks.values().forEach(task -> task.setWorkloadGroupId(threadPool.getThreadContext()));
        SearchTaskSettings searchTaskSettings = mock(SearchTaskSettings.class);
import java.util.concurrent.TimeUnit;
                    put(MEMORY, new NodeDuressTracker(() -> false, () -> 3));
                5,
        service.doRun();
import java.util.Objects;
            @Override
        service.doRun();
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
        // Create a mix of low and high resource usage tasks (60 low + 15 high resource usage tasks).
                0,
        // Fast-forward the clock by ten second to replenish some tokens.
                return Optional.of(new TaskCancellation.Reason("cpu time limit exceeded", 5));
        }
                activeSearchShardTasks.put(i, createMockTaskWithResourceStats(SearchShardTask.class, 100, taskHeapUsageBytes, i));
            Map<Long, WorkloadGroupTask> activeSearchTasks = new HashMap<>();
        );
                new TaskResourceUsageTrackers(),
        };
                (task) -> Optional.of(new TaskCancellation.Reason("cpu (should not fire)", 10))
        taskResourceUsageTrackers.addTracker(mockTaskResourceUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
            workloadGroupService
                settings,
            SearchBackpressureMode.ENFORCED
                put(CPU, new NodeDuressTracker(() -> true, () -> 3));
                new TaskResourceUsageTrackers(),
            );
     * This invariant holds across Linux/non-Linux: on macOS test hosts the predicate is false
            taskManager,
                activeSearchTasks.put(i, createMockTaskWithResourceStats(taskType, 100, 800, i));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            // Without the backend's snapshot supplier installed, native cannot be supported on
        // setting the total heap percent threshold to minimum so that circuit does not break in SearchBackpressureService
            threadPool,
        service.doRun();
            for (long i = 0; i < 20; i++) {
            Settings.EMPTY,
            settings,
        when(settings.getSearchTaskSettings()).thenReturn(searchTaskSettings);
/*
package org.opensearch.search.backpressure;
            taskResourceUsageTrackers,
        // Verify search backpressure stats. We are marking 20 SearchShardTasks as completed this should get
        transportService.start();
        TaskResourceUsageTracker heapUsageTracker = getMockedTaskResourceUsageTracker(
import org.opensearch.threadpool.ThreadPool;
                "CPU tracker must be installed when no analytics backend is present",
        } finally {
        for (long i = 0; i < 75; i++) {
        );
import org.junit.After;
        }
            );
        // If the clock or completed task count haven't made sufficient progress, we'll continue to be rate-limited.
            mockTaskResourceTrackingService,
            mockTaskResourceTrackingService,
        // isNativeTrackingSupported() also gates on whether a backend has installed a
    }
        service.doRun();
        when(settings.getSearchShardTaskSettings()).thenReturn(searchShardTaskSettings);
        }
            new TaskResourceUsageTrackers(),
import static org.mockito.Mockito.times;
        LongSupplier mockTimeNanosSupplier = () -> TimeUnit.SECONDS.toNanos(1234);
                () -> 1L,
    public void testTrackerStateUpdateOnSearchShardTaskCompletion() {
