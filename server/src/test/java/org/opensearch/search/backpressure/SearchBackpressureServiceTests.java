import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers;
                        return Optional.empty();
        TaskResourceUsageTracker mockTaskResourceUsageTracker = getMockedTaskResourceUsageTracker(
        assertTrue(service.isNodeInDuress());
                activeSearchShardTasks.put(i, createMockTaskWithResourceStats(SearchShardTask.class, 500, taskHeapUsageBytes, i));
                (task) -> {
        AtomicLong mockTime = new AtomicLong(0);  
                activeSearchTasks.put(i, createMockTaskWithResourceStats(SearchTask.class, 500, 800, i));
    }
        assertEquals(3, service.getSearchBackpressureState(SearchTask.class).getLimitReachedCount());
        assertEquals(2, service.getSearchBackpressureState(SearchShardTask.class).getLimitReachedCount());  
        SearchShardTaskSettings searchShardTaskSettings = mock(SearchShardTaskSettings.class);
        try {  
        // Node not in duress.
        TaskResourceUsageTracker heapUsageTracker = getMockedTaskResourceUsageTracker(
        service.doRun();  
            ),  
        @Override
        );
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType;  
        service.doRun();
        };
        when(settings.getSearchTaskSettings()).thenReturn(searchTaskSettings);
            new SearchShardTaskStats(12, 3, 20, Map.of(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER, new MockStats(12))),  
import org.opensearch.common.settings.Settings;
            TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
            TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,  
import java.io.IOException;
            service.doRun();  
        transportService.close();  
            );
        EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {
}
                () -> 0.0,
            TaskResourceUsageTrackers withBackend = SearchBackpressureService.getTrackers(  
        }  
            TaskManager mockTaskManager = spy(taskManager);
            settings,
            mockTaskResourceTrackingService,
        );
        service.doRun();
        // Mocking 'settings' with predictable rate limiting thresholds.  
            }
            activeSearchTasks.values().forEach(task -> task.setWorkloadGroupId(threadPool.getThreadContext()));  
        SearchBackpressureStats expectedStats = new SearchBackpressureStats(
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.tasks.TaskCancellationService;  
            workloadGroupService  
import org.opensearch.threadpool.ThreadPool;
            }  
        boolean native_ = trackers.getTracker(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER).isPresent();
            mockTaskResourceTrackingService,
            this(in.readVLong());  
            new SearchTaskStats(
            @Override
            when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);  
            TaskResourceUsageTracker heapUsageTracker = getMockedTaskResourceUsageTracker(
        activeSearchTasks.values().forEach(task -> task.setWorkloadGroupId(threadPool.getThreadContext()));
                nodeDuressTrackers,
        taskResourceUsageTrackers.addTracker(heapUsageTracker, TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER);  
import org.opensearch.wlm.WorkloadGroupService;  
                workloadGroupService  
            AtomicLong mockTime = new AtomicLong(0);
                taskResourceUsageTrackers,  
public class SearchBackpressureServiceTests extends OpenSearchTestCase {
            taskResourceUsageTrackers.addTracker(heapUsageTracker, TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER);  
                () -> 1.0,
        verify(mockTaskManager, times(5)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
            if (o == null || getClass() != o.getClass()) return false;
    @After
            new TaskResourceUsageTrackers(),
            public Optional<TaskCancellation.Reason> checkAndMaybeGetCancellationReason(Task task) {
            Class<? extends WorkloadGroupTask> taskType = randomBoolean() ? SearchTask.class : SearchShardTask.class;  
            )
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                return type.getName();
        SearchBackpressureSettings settings = getBackpressureSettings("enforced", 0.1, 0.003, 10.0);
        TaskManager mockTaskManager = spy(taskManager);
        taskResourceUsageTrackers.addTracker(cpuUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
                () -> 1.0,  
        public MockStats(StreamInput in) throws IOException {
                put(CPU, mockNodeDuressTracker);
        public boolean equals(Object o) {
                long memoryBytes = (i % 5 == 0) ? 800 : 100;  
            );
                (task) -> Optional.of(new TaskCancellation.Reason("cpu (should not fire)", 10))
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
            taskResourceUsageTrackers,
            )
        SearchBackpressureStats actualStats = service.nodeStats();  
import java.util.Optional;  
            service.doRun();
        private final long cancellationCount;
import java.util.concurrent.atomic.AtomicLong;
     * {@code isNativeTrackingSupported()} → install native, otherwise install CPU.  
            return builder.startObject().field("cancellation_count", cancellationCount).endObject();
import static org.opensearch.search.backpressure.SearchBackpressureTestHelpers.createMockTaskWithResourceStats;
        TaskResourceUsageTracker.ResourceUsageBreachEvaluator evaluator
        SearchBackpressureStats actualStats = service.nodeStats();
        taskResourceUsageTrackers.addTracker(mockTaskResourceUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
        );
    public void testGetTrackersInstallsExactlyOneOfCpuOrNative() {
            return cancellationCount == mockStats.cancellationCount;  
        );
    }
import java.util.Collections;  
        try {
            TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,
            taskManager,
        // setting the total heap percent threshold to minimum so that circuit does not break in SearchBackpressureService
            new TaskResourceUsageTrackers(),
        }  
     */
                {  
        verify(mockTaskManager, times(5)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());  
            TaskResourceUsageTracker nativeMemoryTracker = getMockedTaskResourceUsageTracker(  
            new TaskResourceUsageTrackers(),
                put(MEMORY, new NodeDuressTracker(() -> false, () -> 3));  
                if (task.getTotalResourceStats().getCpuTimeInNanos() < 300) {
            new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker),
            workloadGroupService  
                return Optional.of(new TaskCancellation.Reason("limits exceeded", 5));  
        service.doRun();
            if (i % 5 == 0) {
            @Override  
                mockTimeNanosSupplier,
import org.opensearch.common.settings.ClusterSettings;
        for (long i = 0; i < 75; i++) {
            (task) -> {
            threadPool,
                activeSearchTasks.put(i, createMockTaskWithResourceStats(taskType, 100, 800, i));
        // doesn't go through that path, so we install a sentinel non-empty supplier here
    }
        SearchTaskSettings searchTaskSettings = mock(SearchTaskSettings.class);
                put(MEMORY, new NodeDuressTracker(() -> false, () -> 3));
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
        org.opensearch.search.backpressure.NativeMemoryUsageService.getInstance().setSnapshotSupplier(java.util.Collections::emptyMap);  
            } else {  
        }  
        assertEquals(1, service.getSearchBackpressureState(SearchShardTask.class).getLimitReachedCount());
            (task) -> {
            taskResourceUsageTrackers.addTracker(elapsedTimeTracker, TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER);
        TaskResourceUsageTracker heapUsageTracker = getMockedTaskResourceUsageTracker(  
import static org.mockito.Mockito.doReturn;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            mockTaskResourceTrackingService,  
        SearchTaskSettings searchTaskSettings = mock(SearchTaskSettings.class);
            );  
            // CPU must be the one that's installed.  
        verify(mockTaskManager, times(10)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
                    new MockStats(0)
        // Run two iterations so that node is marked 'in duress' from the third iteration onwards.
                }
        transportService.start();
                put(MEMORY, new NodeDuressTracker(() -> false, () -> 3));
            if (this == o) return true;  
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();  
        );  
        Map<Long, WorkloadGroupTask> activeSearchTasks = new HashMap<>();
            taskResourceUsageTrackers,
        SearchBackpressureSettings settings = new SearchBackpressureSettings(
 *
                    return Optional.empty();
        @Override
import static org.mockito.ArgumentMatchers.anyBoolean;
        }  
                put(MEMORY, heapUsageTracker);
            for (long i = 0; i < 20; i++) {
        LongSupplier mockTimeNanosSupplier = mockTime::get;
            {  
            // Install a snapshot supplier — same proxy a real backend would set.
        };
        activeSearchTasks.values().forEach(task -> task.setWorkloadGroupId(threadPool.getThreadContext()));
        // Node not in duress anymore.
        service.doRun();
import java.util.concurrent.atomic.AtomicReference;  
 * compatible open source license.
            }
        NodeDuressTracker cpuUsageTracker = new NodeDuressTracker(() -> cpuUsage.get() >= 0.5, () -> 5);  
            threadPool,
        taskResourceUsageTrackers.addTracker(mockTaskResourceUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);  
        );
        assertEquals(5, service.getSearchBackpressureState(SearchTask.class).getCancellationCount());
        assertEquals(100, service.getSearchBackpressureState(SearchShardTask.class).getCompletionCount());  
            taskResourceUsageTrackers,  
        service.doRun();
        // Verify search backpressure stats. Since we are not marking any task as completed the completionCount will be 0  
                    return Optional.of(new TaskCancellation.Reason("native memory exceeded", 5));  
                5,  
            new SearchBackpressureService(  
    public void testTrackerStateUpdateOnSearchTaskCompletion() {
            mockTaskManager,
            workloadGroupService  
                    return Optional.empty();  
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers;
        }  
            );  
 */  
            workloadGroupService  
                    return Optional.empty();
        Map<Long, WorkloadGroupTask> activeSearchTasks = new HashMap<>();
    /**
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);  
                (task) -> Optional.of(new TaskCancellation.Reason("heap (should not fire)", 10))  
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker);
            nodeDuressTrackers,
        assertFalse(service.isNodeInDuress());
    MockTransportService transportService;  
                put(ResourceType.MEMORY, heapUsageTracker);
        heapUsage.set(0.0);  
     * (Linux-only signal) so CPU is always installed regardless of supplier installation.  
        } finally {
                nodeDuressTrackers,
        assertEquals(expectedStats, actualStats);
        assertFalse(service.isNodeInDuress());
        when(searchTaskSettings.getTotalHeapPercentThreshold()).thenReturn(0.0);
            mockTaskManager,
            new TaskResourceUsageTrackers(),
                withoutBackend.getTracker(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER).isPresent()  
            nodeDuressTrackers,
        SearchBackpressureService service = new SearchBackpressureService(  
        assertEquals(0, service.getSearchBackpressureState(SearchTask.class).getCancellationCount());
        assertEquals(1, service.getSearchBackpressureState(SearchTask.class).getLimitReachedCount());
import org.opensearch.tasks.Task;
        verify(mockTaskManager, times(5)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());  
import org.opensearch.tasks.CancellableTask;  
import static org.mockito.Mockito.when;
    public void cleanup() {
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
        long taskHeapUsageBytes = 500;
        return spy(
        );
                put(CPU, new NodeDuressTracker(() -> true, () -> 3));  
    public void testSearchTaskInFlightCancellation() {
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
            LongSupplier mockTimeNanosSupplier = mockTime::get;
        transportService.acceptIncomingRequests();
            // service.onTaskCompleted(new SearchTask(1, "test", "test", () -> "Test", TaskId.EMPTY_TASK_ID, new HashMap<>()));
            TaskResourceUsageTrackers withoutBackend = SearchBackpressureService.getTrackers(
            EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {
            taskResourceUsageTrackers.addTracker(cpuUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
            service.onTaskCompleted(createMockTaskWithResourceStats(SearchShardTask.class, 100, 200, i));
import java.util.Objects;
            this.cancellationCount = cancellationCount;
                if (task.getTotalResourceStats().getCpuTimeInNanos() < 400) {  
            }  
import org.opensearch.core.common.io.stream.StreamInput;  
        // This will add 2 tokens (task count delta * cancellationRatio) to 'rateLimitPerTaskCompletion'.  
import org.junit.Before;  
import static org.mockito.Mockito.mock;
        heapUsage.set(1.0);  
            );
        assertEquals(0, service.getSearchBackpressureState(SearchShardTask.class).getCancellationCount());  
        when(searchTaskSettings.getTotalHeapPercentThreshold()).thenReturn(0.0);
                }
        EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {  
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
            } else {  
            // Don't leak the sentinel supplier into other tests in this suite.
        SearchBackpressureSettings settings = new SearchBackpressureSettings(
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
            // "always cancel" mocks for CPU and heap, and confirm nothing trips from them; the  
        // Mocking 'settings' with predictable rate limiting thresholds.  
            mockTaskResourceTrackingService,
        taskManager = transportService.getTaskManager();  
        verify(mockTaskManager, times(0)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
import java.util.Map;
import org.opensearch.search.backpressure.settings.SearchTaskSettings;  
            taskResourceUsageTrackers.addTracker(nativeMemoryTracker, TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER);
import java.util.HashMap;
import static org.mockito.ArgumentMatchers.anyString;
        service.doRun();
        );
            threadPool,  
        };
        assertFalse(service.isNodeInDuress());
        SearchBackpressureService service = new SearchBackpressureService(  
                1,
import static org.mockito.Mockito.spy;
    }
    @Before
        // setting the total heap percent threshold to minimum so that circuit does not break in SearchBackpressureService  
            }
            TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
            org.opensearch.search.backpressure.NativeMemoryUsageService.getInstance().resetForTesting();
        assumeTrue("native memory tracking is only supported on Linux", org.apache.lucene.util.Constants.LINUX);
                activeSearchTasks.put(i, createMockTaskWithResourceStats(SearchTask.class, 100, taskHeapUsageBytes, i));
            threadPool,  
        doReturn(activeSearchShardTasks).when(mockTaskResourceTrackingService).getResourceAwareTasks();
            new TaskResourceUsageTrackers(),
        }
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        service.doRun();
        } finally {
                clusterSettings,  
            {
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);  
        LongSupplier mockTimeNanosSupplier = mockTime::get;
        taskResourceUsageTrackers.addTracker(mockTaskResourceUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
        // Create a mix of low and high resource usage tasks (60 low + 15 high resource usage tasks).  
                threadPool,
        AtomicReference<Double> heapUsage = new AtomicReference<>();
        // and reset it in finally so other tests don't see leftover state.
        // exercise this short-circuit regardless of how the fixtures are wired.  
                0,
            service.onTaskCompleted(createMockTaskWithResourceStats(SearchTask.class, 100, 200, i));
    }
                activeSearchTasks.put(i, createMockTaskWithResourceStats(SearchTask.class, 100, 800, i));
            new TaskResourceUsageTrackers(),  
    public void testTrackerStateUpdateOnSearchShardTaskCompletion() {
            );
import org.opensearch.action.search.SearchShardTask;
                () -> 1.0,
        AtomicLong mockTime = new AtomicLong(0);
            mockTaskManager,
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        SearchBackpressureService service = new SearchBackpressureService(
            // native-memory tracker is the only one that should contribute cancellations.
        TaskResourceUsageTracker cpuUsageTracker = getMockedTaskResourceUsageTracker(
            SearchBackpressureMode.ENFORCED
    final BooleanSupplier resourceCacheExpiryChecker = () -> true;
    private TaskResourceUsageTracker getMockedTaskResourceUsageTracker(  
        );
            return Objects.hash(cancellationCount);
        );  
                mockTimeNanosSupplier,  
    public void testSearchShardTaskInFlightCancellation() {
    public void testIsNodeInDuress() {
            (task) -> Optional.of(new TaskCancellation.Reason("mem exceeded", 10))
            TaskResourceUsageTracker cpuUsageTracker = getMockedTaskResourceUsageTracker(  
        threadPool = new TestThreadPool(getClass().getName());
    public void testNativeMemoryDuressRunsOnlyNativeMemoryAndElapsedTrackers() {  
            new NodeDuressTrackers(new EnumMap<>(ResourceType.class), resourceCacheExpiryChecker),  
        // If the clock or completed task count haven't made sufficient progress, we'll continue to be rate-limited.  
 * SPDX-License-Identifier: Apache-2.0
            taskManager,
                new TaskResourceUsageTrackers(),
        }  
        // setting the total heap percent threshold to minimum so that circuit does not break in SearchBackpressureService  
        // The native-memory tracker-apply condition is gated on isNativeTrackingSupported(),
        AtomicLong mockTime = new AtomicLong(0);
        assertEquals(3, service.getSearchBackpressureState(SearchShardTask.class).getLimitReachedCount());  
import org.opensearch.search.backpressure.stats.SearchBackpressureStats;
        SearchBackpressureService service = spy(
                mockTaskResourceTrackingService,
                threadPool,  
     * CPU and native trackers are mutually exclusive at install time:
        TaskManager mockTaskManager = spy(taskManager);  
            TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);  
        Map<Long, WorkloadGroupTask> activeSearchShardTasks = new HashMap<>();
        verify(mockTaskManager, times(10)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());  
    }
    private static void assertCpuXorNative(TaskResourceUsageTrackers trackers) {  
                settings,
        public void writeTo(StreamOutput out) throws IOException {  
        service.onTaskCompleted(createMockTaskWithResourceStats(CancellableTask.class, 100, 200, 101));
    }
        EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {
                mockTaskResourceTrackingService,
                "CPU tracker must be installed when no analytics backend is present",
        when(searchShardTaskSettings.getTotalHeapPercentThreshold()).thenReturn(0.0);
        SearchBackpressureSettings settings = new SearchBackpressureSettings(  
            SearchBackpressureMode.ENFORCED
            new NodeDuressTrackers(new EnumMap<>(ResourceType.class), resourceCacheExpiryChecker),
                Map.of(  
            if (i % 5 == 0) {
import java.util.function.LongSupplier;
        long taskHeapUsageBytes = 500;
            // Load 20 tasks; 4 are heavy (mem >= 500) so exactly 4 are native-memory cancellation
            System::nanoTime,
                100,  
                }
            (task) -> Optional.of(new TaskCancellation.Reason("mem exceeded", 10))
            TaskResourceUsageTracker elapsedTimeTracker = getMockedTaskResourceUsageTracker(
            }
        );
            threadPool,  
            taskResourceUsageTrackers,  
    }
        }  
        doReturn(activeSearchTasks).when(mockTaskResourceTrackingService).getResourceAwareTasks();
            // Prime the native-memory duress streak (consecutive-breach window is 3).
    ThreadPool threadPool;
        // Run two iterations so that node is marked 'in duress' from the third iteration onwards.
        // this will trigger cancellation but the cancellation should not happen as the node is not is duress because of search traffic
        assertFalse(service.isNodeInDuress());
import static org.mockito.Mockito.any;  
                }
            // Unconditionally-cancelling CPU + heap trackers. These should never be consulted.
        TaskResourceUsageTracker mockTaskResourceUsageTracker = mock(TaskResourceUsageTracker.class);
                if (task.getTotalResourceStats().getCpuTimeInNanos() < 400) {
                    put(MEMORY, new NodeDuressTracker(() -> false, () -> 3));
        assertEquals(expectedStats, actualStats);
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker);
    TaskManager taskManager;
        );  
        // This will add 50 tokens (time delta * rate) to 'rateLimitPerTime' but it will cancel only 5 tasks (burst limit).  
                (task) -> Optional.empty()
        NodeDuressTracker heapUsageTracker = new NodeDuressTracker(() -> heapUsage.get() >= 0.5, () -> 6);
            assertFalse(withoutBackend.getTracker(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER).isPresent());
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);  
        service.doRun();  
            mockTimeNanosSupplier,
            mockTaskResourceTrackingService,
        AtomicReference<Double> cpuUsage = new AtomicReference<>();
        TaskManager mockTaskManager = spy(taskManager);
            threadPool,  
        @Override  
import static org.mockito.Mockito.anyList;
import java.util.concurrent.TimeUnit;
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
        NodeDuressTracker mockNodeDuressTracker = new NodeDuressTracker(() -> true, () -> 3);
                () -> 1.0,
        // Simulate task completion to replenish some tokens.
import org.junit.After;
                    put(ResourceType.NATIVE_MEMORY, new NodeDuressTracker(() -> true, () -> 3));  
        };
        AtomicLong mockTime = new AtomicLong(0);
                workloadGroupService
        @Override  
                Settings.builder().put(SearchBackpressureSettings.SETTING_MODE.getKey(), mode).build(),  
    private static class MockStats implements TaskResourceUsageTracker.Stats {
            out.writeVLong(cancellationCount);
    public void testNonCancellationOfHeapBasedTasksWhenHeapNotInDuress() {
        TaskResourceUsageTracker mockTaskResourceUsageTracker = getMockedTaskResourceUsageTracker(
            new TaskResourceUsageTrackers(),  
        public MockStats(long cancellationCount) {
    WorkloadGroupService workloadGroupService;  
        // snapshot provider on NativeMemoryUsageService. The mock tracker in this test  
        };
    }
        assertEquals(2, service.getSearchBackpressureState(SearchTask.class).getLimitReachedCount());  
import static org.opensearch.wlm.ResourceType.CPU;
        // this will trigger cancellation but these cancellation should only be cpu based
            settings,  
            SearchBackpressureSettings settings = getBackpressureSettings("enforced", 0.1, 0.003, 10.0);
        SearchBackpressureSettings settings = getBackpressureSettings("enforced", 0.1, 0.003, 10.0);  
                () -> 1L,
        // Fast-forward the clock by ten second to replenish some tokens.
                }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                activeSearchTasks.put(i, createMockTaskWithResourceStats(SearchTask.class, 500, taskHeapUsageBytes, i));
            verify(mockTaskManager, times(4)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
package org.opensearch.search.backpressure;
        }  
        // tasks but heap based cancellation should not happen because heap is not in duress
import org.opensearch.tasks.TaskResourceTrackingService;
                return Optional.of(new TaskCancellation.Reason("limits exceeded", 5));  
import org.opensearch.core.common.io.stream.StreamOutput;
                return Optional.of(new TaskCancellation.Reason("cpu time limit exceeded", 5));  
        activeSearchShardTasks.values().forEach(task -> task.setWorkloadGroupId(threadPool.getThreadContext()));
     * This invariant holds across Linux/non-Linux: on macOS test hosts the predicate is false
        service.doRun();
            assertCpuXorNative(withBackend);
            @Override
        // Create a mix of low and high resource usage tasks (60 low + 15 high resource usage tasks).
        // reflected in SearchShardTaskStats.  
            settings,
            // Exactly the heavy tasks were cancelled — no extras from the "always cancel" CPU/heap mocks.
    }
            workloadGroupService
import org.opensearch.test.OpenSearchTestCase;
            }
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
        service.doRun();
import org.opensearch.wlm.WorkloadGroupTask;
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);
        EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {  
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);  
        // Mocking 'settings' with predictable totalHeapBytesThreshold so that cancellation logic doesn't get skipped.  
        // setting the total heap percent threshold to minimum so that circuit does not break in SearchBackpressureService  
            Map<Long, WorkloadGroupTask> activeSearchTasks = new HashMap<>();
        assertTrue("exactly one of CPU/native trackers must be installed (cpu=" + cpu + ", native=" + native_ + ")", cpu ^ native_);  
                )
            Settings.EMPTY,
        SearchBackpressureSettings settings = getBackpressureSettings("enforced", 0.1, 0.003, 5.0);
        };  
        // isNativeTrackingSupported() also gates on whether a backend has installed a
                put(CPU, mockNodeDuressTracker);  
            public void update(Task task) {}
            }
            }
        // which today requires Linux + a readable /proc/meminfo. Non-Linux test hosts cannot
            {
import java.util.List;  
    }
        );
            mockTaskResourceTrackingService,
                clusterSettings,
        SearchBackpressureService service = new SearchBackpressureService(
            ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                () -> 1L,
        EnumMap<ResourceType, NodeDuressTracker> duressTrackers = new EnumMap<>(ResourceType.class) {  
        when(settings.getSearchShardTaskSettings()).thenReturn(searchShardTaskSettings);
        }  
            org.opensearch.search.backpressure.NativeMemoryUsageService.getInstance().setSnapshotSupplier(Collections::emptyMap);
            // Native-memory tracker: cancels tasks whose memory bytes exceed a modest threshold.
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();  
            assertEquals(4, service.getSearchBackpressureState(SearchTask.class).getCancellationCount());  
            }
            new SearchTaskStats(0, 0, 0, Collections.emptyMap()),
        assertEquals(1, service.getSearchBackpressureState(SearchTask.class).getLimitReachedCount());
        when(service.isHeapUsageDominatedBySearch(anyList(), anyDouble())).thenReturn(false);
        assertEquals(expectedStats, actualStats);  
                new TaskResourceUsageTrackers(),  
        );  
            public String name() {  
            {
        service.doRun();
    private SearchBackpressureSettings getBackpressureSettings(String mode, double ratio, double rate, double burst) {  
                    TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
        }  
        );
            } else {  
            }
            service.onTaskCompleted(createMockTaskWithResourceStats(SearchShardTask.class, 100, taskHeapUsageBytes, i));
import org.opensearch.tasks.TaskCancellation;
            new SearchBackpressureSettings(
        // Verify search backpressure stats. We are marking 20 SearchShardTasks as completed this should get
        // There are 15 SearchShardTasks eligible for cancellation but only 10 will be cancelled (burst limit).
        );
        for (long i = 0; i < 75; i++) {  
            mockTimeNanosSupplier,  
import org.opensearch.search.backpressure.settings.SearchBackpressureMode;  
        heapUsage.set(0.0);
                mockTaskManager,
    public void setup() {  
                TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,
    }  
        LongSupplier mockTimeNanosSupplier = () -> TimeUnit.SECONDS.toNanos(1234);
                TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER,
        for (int i = 0; i < 100; i++) {  
        return new TaskResourceUsageTracker() {
        taskResourceUsageTrackers.addTracker(cpuUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);  
        // tasks but heap based cancellation should not happen because heap is not in duress
        // Node in duress for consecutive data points.  
        // for SearchTaskStats here.
        verify(mockTaskResourceUsageTracker, times(100)).update(any());
        }
                activeSearchTasks.put(i, createMockTaskWithResourceStats(SearchTask.class, 100, memoryBytes, i));
        workloadGroupService = mock(WorkloadGroupService.class);
        doReturn(activeSearchTasks).when(mockTaskResourceTrackingService).getResourceAwareTasks();
        taskResourceUsageTrackers.addTracker(mockTaskResourceUsageTracker, TaskResourceUsageTrackerType.CPU_USAGE_TRACKER);
            (task) -> {  
            );
            }
                TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
        cpuUsage.set(0.0);
import org.opensearch.threadpool.TestThreadPool;  
                mockTaskManager,
            mockTimeNanosSupplier,
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);  
        // Creating heap and cpu usage trackers where heap tracker will always evaluate with reasons to cancel the  
        taskManager.setTaskCancellationService(new TaskCancellationService(transportService));
            }
            // Mutual exclusion still holds; which one wins depends on the platform.
        // Creating heap and cpu usage trackers where heap tracker will always evaluate with reasons to cancel the
/*  
            org.opensearch.search.backpressure.NativeMemoryUsageService.getInstance().resetForTesting();
                    TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,  
                SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
        cpuUsage.set(1.0);
        SearchBackpressureService service = new SearchBackpressureService(  
import org.opensearch.search.backpressure.stats.SearchTaskStats;  
            new SearchShardTaskStats(0, 0, 0, Collections.emptyMap()),
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
            assertCpuXorNative(withoutBackend);  
        for (int i = 0; i < 100; i++) {  
        SearchBackpressureStats actualStats = service.nodeStats();
 * The OpenSearch Contributors require contributions made to  
        public int hashCode() {
                }  
                taskResourceUsageTrackers,
        when(settings.getSearchTaskSettings()).thenReturn(searchTaskSettings);
            {
import org.opensearch.action.search.SearchTask;  
            // candidates. Heap/CPU would want to cancel all 20 — verifying this test's whole point.  
        for (long i = 0; i < 75; i++) {  
        when(settings.getSearchTaskSettings()).thenReturn(searchTaskSettings);
            MockStats mockStats = (MockStats) o;
            taskResourceUsageTrackers,  
                settings,  
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);  
            TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,  
import java.util.function.BooleanSupplier;
            assertTrue(withBackend.getTracker(TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER).isPresent());  
            new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker),
    }
import org.opensearch.wlm.ResourceType;
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers.NodeDuressTracker;
            assertTrue(
        when(workloadGroupService.shouldSBPHandle(any())).thenReturn(true);  
import static org.mockito.Mockito.times;  
                activeSearchTasks.put(i, createMockTaskWithResourceStats(taskType, 500, 800, i));
                return evaluator.evaluate(task);  
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
            SearchBackpressureService service = new SearchBackpressureService(
import org.opensearch.search.backpressure.stats.SearchShardTaskStats;
        service.doRun();
        // Create a mix of low and high resource usage SearchTasks (50 low + 25 high resource usage tasks).
            TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,  
        SearchBackpressureStats expectedStats = new SearchBackpressureStats(
            // Elapsed-time tracker left silent so the cancellation count is unambiguously from  
        TaskManager mockTaskManager = spy(taskManager);
                return new MockStats(getCancellations());
        when(searchTaskSettings.getTotalHeapPercentThreshold()).thenReturn(0.0);  
        TaskResourceUsageTrackerType type,
            new SearchShardTaskStats(0, 0, 0, Collections.emptyMap()),
        Map<Long, WorkloadGroupTask> activeSearchTasks = new HashMap<>();
            mockTimeNanosSupplier,
        NodeDuressTracker heapUsageTracker = new NodeDuressTracker(() -> false, () -> 3);  
        TaskResourceUsageTrackers taskResourceUsageTrackers = new TaskResourceUsageTrackers();
import org.opensearch.tasks.TaskManager;
                if (task.getTotalResourceStats().getCpuTimeInNanos() < 300) {
                () -> 1L,  
            if (i % 3 == 0) {
            SearchBackpressureMode.ENFORCED
                return Optional.of(new TaskCancellation.Reason("cpu time limit exceeded", 5));
            }
            taskManager,  
                put(ResourceType.CPU, cpuUsageTracker);  
        service.doRun();
        // Mocking 'settings' with predictable rate limiting thresholds.  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        );  
        TaskResourceUsageTracker cpuUsageTracker = getMockedTaskResourceUsageTracker(  
        taskResourceUsageTrackers.addTracker(heapUsageTracker, TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER);
            // When native-memory duress is active, heap/CPU trackers MUST NOT run. We install
            Settings.EMPTY,  
            workloadGroupService
            if (i % 5 == 0) {
            // any platform (the Linux + provider + physMem gate fails on the provider check).
        // If the clock or completed task count haven't made sufficient progress, we'll continue to be rate-limited.  
                    if (task.getTotalResourceStats().getMemoryInBytes() < 500) {  
                () -> 0.0,  
            new SearchTaskStats(10, 3, 0, Map.of(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER, new MockStats(10))),  
        boolean cpu = trackers.getTracker(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER).isPresent();
        );
                put(CPU, new NodeDuressTracker(() -> true, () -> 3));
import static org.mockito.Mockito.anyDouble;
    ) {  
import org.opensearch.Version;
                    new MockStats(5),
            );  
import java.util.EnumMap;
            @Override
            org.opensearch.search.backpressure.NativeMemoryUsageService.getInstance().resetForTesting();  
            NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker);  
        // Create a mix of low and high resource usage tasks (60 low + 15 high resource usage tasks).
                    return Optional.empty();  
     * Exactly one of the two is in {@code TaskResourceUsageTrackers}, never both, never neither.
        verify(mockTaskManager, times(10)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());  
import static org.mockito.Mockito.verify;
        activeSearchTasks.values().forEach(task -> task.setWorkloadGroupId(threadPool.getThreadContext()));
        TaskResourceUsageTracker mockTaskResourceUsageTracker = mock(TaskResourceUsageTracker.class);
        }
    }
    public void testNonCancellationWhenSearchTrafficIsNotQualifyingForCancellation() {  
                () -> 1L,
            settings,
            TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
            public Stats stats(List<? extends Task> tasks) {
        for (long i = 0; i < 75; i++) {  
                    put(CPU, new NodeDuressTracker(() -> false, () -> 3));
            Settings.EMPTY,
        );  
        }
    }  
        SearchTaskSettings searchTaskSettings = mock(SearchTaskSettings.class);
        SearchBackpressureService service = new SearchBackpressureService(  
            // Without the backend's snapshot supplier installed, native cannot be supported on
            settings,
            doReturn(activeSearchTasks).when(mockTaskResourceTrackingService).getResourceAwareTasks();
        mockTime.addAndGet(TimeUnit.SECONDS.toNanos(10));
                100,
        assertEquals(100, service.getSearchBackpressureState(SearchTask.class).getCompletionCount());
            // No backend installed.  
        SearchBackpressureSettings settings = getBackpressureSettings("enforced", 0.1, 0.003, 10.0);
        // There are 25 SearchTasks eligible for cancellation but only 5 will be cancelled (burst limit).
            } else {  
        // Record task completions to update the tracker state. Tasks other than SearchTask & SearchShardTask are ignored.
            }
            // CPU/heap ResourceType duress both OFF — only the native-memory probe is firing.
                    }
            // the native-memory tracker.
        );  
                TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER,  
            }
        LongSupplier mockTimeNanosSupplier = () -> TimeUnit.SECONDS.toNanos(1234);  
            service.doRun();  
        }
        // Mocking 'settings' with predictable totalHeapBytesThreshold so that cancellation logic doesn't get skipped.  
        // Node in duress; but not for many consecutive data points.
            };
        NodeDuressTracker mockNodeDuressTracker = new NodeDuressTracker(() -> true, () -> 3);  
            (task) -> {
        verify(mockTaskResourceUsageTracker, times(100)).update(any());
                SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
            mockTimeNanosSupplier,
        LongSupplier mockTimeNanosSupplier = mockTime::get;  
                activeSearchShardTasks.put(i, createMockTaskWithResourceStats(SearchShardTask.class, 100, taskHeapUsageBytes, i));
        // Mocking 'settings' with predictable rate limiting thresholds.
        SearchBackpressureStats expectedStats = new SearchBackpressureStats(
        verify(mockTaskManager, times(12)).cancelTaskAndDescendants(any(), anyString(), anyBoolean(), any());
        cpuUsage.set(0.0);  
            }
        TaskResourceTrackingService mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
        LongSupplier mockTimeNanosSupplier = mockTime::get;
        doReturn(activeSearchTasks).when(mockTaskResourceTrackingService).getResourceAwareTasks();
        service.doRun();
        service.doRun();  
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(duressTrackers, resourceCacheExpiryChecker);  
            settings,
        for (int i = 0; i < 20; i++) {
import static org.opensearch.wlm.ResourceType.MEMORY;  
