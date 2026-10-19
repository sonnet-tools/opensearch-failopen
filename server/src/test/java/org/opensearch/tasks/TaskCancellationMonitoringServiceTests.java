            settings,
        int totalTasksToBeCancelled = cancelTillIdx - cancelFromIdx + 1;
        for (int itr = numTasksToBeCancelledInFirstIteration; itr < tasks.size(); itr++) {
            threadPool,
        assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());
            stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount()
        );
    }
        assertFalse(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(0).getId()));
            taskManager,
    public void testWithNoCurrentRunningCancelledTasks() {
            out.writeString(requestName);
    }
        when(mockTaskManager.getCancellableTasks()).thenReturn(new java.util.HashMap<>());
    }
        assert completeTillIdx >= completeFromIdx;
    }
        completeTasksConcurrently(tasks, 0, tasks.size() - 1).await();
import org.opensearch.threadpool.ThreadPool;
        return countDownLatch;
        return countDownLatch;
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
        for (int itr = 0; itr < tasks.size(); itr++) {
        assertNull(stats.getNativeStats());
import org.opensearch.threadpool.TestThreadPool;
        assertEquals(
        ThreadPool mockThreadPool = mock(ThreadPool.class);
        Thread[] threads = new Thread[totalTasksToBeCompleted];
        Supplier<AnalyticsBackendTaskCancellationStats> mockSupplier = () -> {
        // Complete one task to start with.
 * SPDX-License-Identifier: Apache-2.0
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        TaskCancellationMonitoringService service = new TaskCancellationMonitoringService(threadPool, mockTaskManager, settings);
        TaskManager mockTaskManager = mock(TaskManager.class);
    private CountDownLatch completeTasksConcurrently(List<? extends CancellableTask> tasks, int completeFromIdx, int completeTillIdx) {
        List<T> tasks = createTasks(taskType, numTasks);
        );
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount());
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount());
        Settings settings = Settings.builder()
        Phaser phaser = new Phaser(totalTasksToBeCancelled + 1); // Used to concurrently cancel tasks by multiple threads.
import static org.opensearch.tasks.TaskCancellationMonitoringSettings.DURATION_MILLIS_SETTING;
        transportService.close();
        phaser.arriveAndAwaitAdvance();
            Settings.EMPTY,
            mockThreadPool,
            .put(DURATION_MILLIS_SETTING.getKey(), cancelledTaskDurationThresholdMilis) // Setting to one for testing
        }
            if (taskType == SearchTask.class) {
        when(scheduleFuture.cancel()).thenReturn(true);
        taskCancellationMonitoringService.doRun();
        taskManager.setTaskCancellationService(new TaskCancellationService(transportService));
        @Override
            super.writeTo(out);
        stats = taskCancellationMonitoringService.stats();
        taskCancellationMonitoringService.doRun();
        assertEquals(7, stats.getNativeStats().getSearchShardTaskCurrent());
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings = new TaskCancellationMonitoringSettings(
        cancelTasksConcurrently(tasks, numTasksToBeCancelledInFirstIteration, taskNum - 1).await();
        Settings settings = Settings.builder()
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(
    }
        when(mockTaskManager.getCancellableTasks()).thenReturn(new java.util.HashMap<>());
        assertEquals(numTasksToBeCancelledInFirstIteration, taskCancellationMonitoringService.getCancelledTaskTracker().size());
        cancelTasksConcurrently(tasks, 0, tasks.size() - 1).await();
        Phaser phaser = new Phaser(totalTasksToBeCompleted + 1);
            settings
        assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());
        int numTasks = randomIntBetween(5, 50);
            .build();
        assertEquals(0, statsExtractor.apply(stats).getCurrentLongRunningCancelledTaskCount());
    @Before
        taskCancellationMonitoringService.doRun(); // 3rd run to verify current count is 0 and total remains the same.
    }
    public void testTasksAreGettingEvictedCorrectlyAfterCompletion() throws InterruptedException {
        // Start few tasks.
import java.util.ArrayList;
                return new SearchShardTask(id, type, action, getDescription(), parentTaskId, headers);
import static org.mockito.Mockito.verify;
    }
            super();
import org.junit.After;
        );
        Function<TaskCancellationStats, BaseSearchTaskCancellationStats> statsExtractor
                phaser.arriveAndAwaitAdvance();
        assert cancelFromIdx >= 0;
            mockSupplier
        assertEquals(numberOfTasksCancelled, statsExtractor.apply(stats).getCurrentLongRunningCancelledTaskCount());
        TaskManager mockTaskManager = mock(TaskManager.class);
        tasks.addAll(createTasks(SearchTask.class, searchTaskNum));
        );
        // they have been running longer as per threshold.
            threadPool,
            settings,
        // Complete first iteration tasks
    }
        for (int itr = 0; itr < tasks.size(); itr++) {
            taskCancellationMonitoringSettings
 * The OpenSearch Contributors require contributions made to
            taskCancellationMonitoringSettings
        taskManager = transportService.getTaskManager();
    }
        when(mockTaskManager.getCancellableTasks()).thenReturn(new java.util.HashMap<>());
    private <T extends CancellableTask> List<T> createTasks(Class<T> taskType, int numTasks) {
        public void writeTo(StreamOutput out) throws IOException {
        taskCancellationMonitoringService.doStart();
            assertFalse(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(itr).getId()));
        int numTasksToBeCancelledInFirstIteration = randomIntBetween(1, numTasks - 1);
    public void cleanup() {
            stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount()
    public void setup() {
    public static class MockQuerySearchRequest extends TransportRequest {
        TaskCancellationStats stats = taskCancellationMonitoringService.stats();
        taskCancellationMonitoringService.doRun();
        );
        TaskCancellationStats stats = service.stats();
            numTasksToBeCancelledInFirstIteration,
    @After
    }
        int numberOfTasksCancelled = cancelTillIdx - cancelFromIdx + 1;
 *
            assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(itr).getId()));
        }
            this.taskType = taskType;
            } else {
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
        AnalyticsBackendTaskCancellationStats expectedNativeStats = new AnalyticsBackendTaskCancellationStats(3, 100, 7, 500);
/*
        transportService.start();
        for (int itr = 0; itr < numTasksToBeCancelledInFirstIteration; itr++) {
        // Verify desired tasks were evicted from tracker map
        Thread[] threads = new Thread[totalTasksToBeCancelled];
        }
import org.opensearch.threadpool.Scheduler;
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount());
        verify(scheduleFuture, times(1)).cancel();
import org.opensearch.core.tasks.TaskId;
    public void testWithNonZeroCancelledSearchShardTasksRunning() throws InterruptedException {
import org.opensearch.action.search.SearchShardTask;
        // Verify rest of the tasks are still present in tracker
        @Override
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        );
        );
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount());
        int cancelTillIdx = randomIntBetween(cancelFromIdx, numTasks - 1);
    public void testWithNonZeroCancelledSearchTasksRunning() throws InterruptedException {
    private CountDownLatch cancelTasksConcurrently(List<? extends CancellableTask> tasks, int cancelFromIdx, int cancelTillIdx) {
            });
import java.util.function.Supplier;
            mockSupplier
            mockTaskManager,
        }
            Settings.EMPTY,
    }
            threadPool,
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
        List<SearchShardTask> tasks = createTasks(SearchShardTask.class, numTasks);
        stats = taskCancellationMonitoringService.stats();
        }
        // Verify rest of the tasks are still present in tracker
            assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(itr).getId()));
        phaser.arriveAndAwaitAdvance();
        taskCancellationMonitoringService.doRun();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        }
        completeTasksConcurrently(tasks, 0, tasks.size() - 1).await();
        );
        for (int itr = 1; itr < tasks.size(); itr++) {
 * compatible open source license.
        taskCancellationMonitoringService.doRun(); // 1st run to verify whether we are able to track running cancelled
        List<SearchShardTask> tasks = createTasks(SearchShardTask.class, numTasks);
        Thread.sleep(cancelledTaskDurationThresholdMilis); // Sleep again, so we now verify whether all tasks are
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            threads[i] = new Thread(() -> {
    public void testDoStartAndStop() {
        // Verify no current running tasks
                taskManager.unregister(tasks.get(idx));
        stats = taskCancellationMonitoringService.stats();
        // Complete all of them finally
        assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());
    }
import org.opensearch.test.transport.MockTransportService;
        countDownLatch = cancelTasksConcurrently(tasks, numTasksToBeCancelledInFirstIteration, numTasks - 1);
        assertNotNull(stats.getNativeStats());
        CountDownLatch countDownLatch = cancelTasksConcurrently(tasks, 0, numTasksToBeCancelledInFirstIteration - 1);
        for (int i = 0; i < totalTasksToBeCancelled; i++) {
        TaskCancellationStats stats = service.stats();
import org.opensearch.core.common.io.stream.StreamOutput;
        assert completeFromIdx >= 0;
        Class<T> taskType,
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
            .put(DURATION_MILLIS_SETTING.getKey(), 0) // Setting to zero for testing
        int cancelFromIdx = randomIntBetween(0, numTasks - 1);
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(
            taskManager,
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount());
            threadPool,
        );
        completeTasksConcurrently(tasks, 0, 0).await();
import java.util.List;
            mockTaskManager,
    public void testStatsReturnsNullNativeStatsWhenProviderIsNull() {
        int searchTaskNum = randomIntBetween(5, 50);
    TaskManager taskManager;
            assertFalse(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(0).getId()));
            threadPool,
        transportService.acceptIncomingRequests();
        // verify no cancelled tasks currently being recorded
        Thread.sleep(cancelledTaskDurationThresholdMilis); // Sleep, so we later verify whether above tasks are being
        assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());
        countDownLatch.await(); // Wait for all tasks to be cancelled in first iteration
        Settings settings = Settings.builder()
    public void testShouldRunGetsDisabledAfterTaskCompletion() throws InterruptedException {
        TaskManager mockTaskManager = mock(TaskManager.class);
        countDownLatch.await(); // Wait for rest of tasks to be cancelled.
        int taskNum = searchShardTaskNum + searchTaskNum;
        assertEquals(0, taskCancellationMonitoringService.getCancelledTaskTracker().size());
        );
    @SuppressWarnings("unchecked")
        assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());
        @Override
        );
    }
        int numTasksToBeCancelledInFirstIteration = randomIntBetween(2, taskNum - 1);
        assertEquals(0, stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount());
        when(mockThreadPool.scheduleWithFixedDelay(any(), any(), any())).thenReturn(scheduleFuture);
        assertEquals(numberOfTasksCancelled, statsExtractor.apply(stats).getTotalLongRunningCancelledTaskCount());
            Settings.EMPTY,
            threadPool,
    }
            taskManager,
        }
            }
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        );
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.Version;
                return new SearchTask(id, type, action, this::getDescription, parentTaskId, headers);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            mockTaskManager,
        // Cancel rest of the tasks
        for (int i = 0; i < numTasks; i++) {
                countDownLatch.countDown();
        threadPool = new TestThreadPool(getClass().getName());
        taskCancellationMonitoringService.doRun(); // 2nd run. Verify same.
        assert cancelTillIdx <= tasks.size() - 1;
        // captured as part of stats.
        int totalTasksToBeCompleted = completeTillIdx - completeFromIdx + 1;
import java.io.IOException;
        TaskCancellationStats stats = taskCancellationMonitoringService.stats();
            tasks.add((T) taskManager.register("type-" + i, "action-" + i, new MockQuerySearchRequest(taskType)));
import org.opensearch.common.settings.Settings;
            });
        assertEquals(0, stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount());
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import static org.mockito.ArgumentMatchers.any;
        long cancelledTaskDurationThresholdMilis = 2000;
            settings,
 * this file be licensed under the Apache-2.0 license or a
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
            Settings.EMPTY,
        }
    // .await() to wait for all tasks be cancelled.
}
        completeTasksConcurrently(tasks, 1, numTasksToBeCancelledInFirstIteration - 1).await();
package org.opensearch.tasks;
import org.opensearch.action.search.SearchTask;
        Supplier<AnalyticsBackendTaskCancellationStats> mockSupplier;
        testWithNonZeroCancelledTasksRunning(SearchTask.class, TaskCancellationStats::getSearchTaskCancellationStats);
        stats = taskCancellationMonitoringService.stats();
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(
        assertEquals(3, stats.getNativeStats().getSearchTaskCurrent());
        // Verify desired task ids are present.
import org.junit.Before;
            taskManager,
            threads[i] = new Thread(() -> {
        completeTasksConcurrently(tasks, numTasksToBeCancelledInFirstIteration, tasks.size() - 1).await();
        // Start few tasks.
            .build();
        CountDownLatch countDownLatch = cancelTasksConcurrently(tasks, cancelFromIdx, cancelTillIdx);
    public void testWithVaryingCancelledTasksDuration() throws InterruptedException {
        public MockQuerySearchRequest(Class<? extends CancellableTask> taskType) {
    MockTransportService transportService;
        };
        TaskCancellationMonitoringService service = new TaskCancellationMonitoringService(
        TaskCancellationStats stats = taskCancellationMonitoringService.stats();
import org.opensearch.common.settings.ClusterSettings;
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings = new TaskCancellationMonitoringSettings(
        int numTasks = randomIntBetween(5, 50);
            .build();
        // Task manager should not be invoked.
        CountDownLatch countDownLatch = new CountDownLatch(totalTasksToBeCompleted);
        assertEquals(
            assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(itr).getId()));
        );
        TaskCancellationStats stats = service.stats();
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
    private <T extends CancellableTask> void testWithNonZeroCancelledTasksRunning(
        // Verify only tasks that were cancelled as part of first iteration is being captured as part of stats as
            numTasksToBeCancelledInFirstIteration,
        assert completeTillIdx <= tasks.size() - 1;
        TaskCancellationMonitoringService service = new TaskCancellationMonitoringService(
        List<T> tasks = new ArrayList<>(numTasks);
            .put(DURATION_MILLIS_SETTING.getKey(), 0) // Setting to zero for testing
import java.util.concurrent.TimeUnit;
        assertEquals(0, stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount());
        List<CancellableTask> tasks = new ArrayList<>(createTasks(SearchShardTask.class, searchShardTaskNum));
        taskCancellationMonitoringService.doRun();
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        completeTasksConcurrently(tasks, 0, tasks.size() - 1).await();
                phaser.arriveAndAwaitAdvance();
    }
        Settings settings = Settings.builder()
            throw new RuntimeException("Native runtime not initialized");
    ThreadPool threadPool;
        // tasks.
        assertEquals(500, stats.getNativeStats().getSearchShardTaskTotal());
        countDownLatch.await(); // Wait for all threads execution.
            threads[i].start();
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
        assertEquals(numberOfTasksCancelled, statsExtractor.apply(stats).getTotalLongRunningCancelledTaskCount());
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount());
        }
            .build();
 */
        assertEquals(100, stats.getNativeStats().getSearchTaskTotal());
        int numTasks = randomIntBetween(5, 50);
        assertEquals(numberOfTasksCancelled, statsExtractor.apply(stats).getCurrentLongRunningCancelledTaskCount());
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
        // Should handle exception gracefully and return null native stats
    public void testStatsHandlesProviderExceptionGracefully() {
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings = new TaskCancellationMonitoringSettings(
        }
        stats = taskCancellationMonitoringService.stats();
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings = new TaskCancellationMonitoringSettings(
                countDownLatch.countDown();
import java.util.concurrent.CountDownLatch;
        int searchShardTaskNum = randomIntBetween(5, 50);
import static org.mockito.Mockito.when;
            Settings.EMPTY,
        );
    public void testStatsIncludesNativeCountersWhenProviderAvailable() {
        );
import java.util.function.Function;
    // Caller can call this method with a list of tasks specifically mentioning which ones to cancel. And can call CountDownLatch
        countDownLatch.await(); // Wait for all tasks to be cancelled in first iteration
        assertEquals(0, stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount());
        );
            taskCancellationMonitoringSettings
        }
                taskManager.cancel(tasks.get(idx), "test", () -> {});
            } else if (taskType == SearchShardTask.class) {
        mockSupplier = () -> expectedNativeStats;
            int idx = i + completeFromIdx;
        protected String requestName;
import java.util.Map;
    }
        taskCancellationMonitoringService.doStop();
        CountDownLatch countDownLatch = new CountDownLatch(totalTasksToBeCancelled); // To wait for all threads to finish.
        taskCancellationMonitoringService.doRun();
public class TaskCancellationMonitoringServiceTests extends OpenSearchTestCase {
        CountDownLatch countDownLatch = cancelTasksConcurrently(tasks, 0, numTasksToBeCancelledInFirstIteration - 1);
        testWithNonZeroCancelledTasksRunning(SearchShardTask.class, TaskCancellationStats::getSearchShardTaskCancellationStats);
            taskManager,
                throw new IllegalArgumentException("Unsupported task type: " + taskType);
    ) throws InterruptedException {
            return "MockQuerySearchRequest[" + requestName + "]";
        }
import java.util.concurrent.Phaser;
        // Use the 3-arg constructor which passes null for the provider
            settings,
import static org.mockito.Mockito.mock;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        for (int i = 0; i < totalTasksToBeCompleted; i++) {
    }
        stats = taskCancellationMonitoringService.stats();
        Scheduler.Cancellable scheduleFuture = mock(Scheduler.Cancellable.class);
            .put(DURATION_MILLIS_SETTING.getKey(), 0) // Setting to one for testing
            taskCancellationMonitoringSettings
        assertNull(stats.getNativeStats());
            settings,
            assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(itr).getId()));
        public String getDescription() {
        private Class<? extends CancellableTask> taskType;
            settings
        );
            settings,
        verify(mockTaskManager, times(0)).getTasks();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        TaskManager mockTaskManager = mock(TaskManager.class);
        );
            int idx = i + cancelFromIdx;
        assert cancelTillIdx >= cancelFromIdx;
        assertEquals(numberOfTasksCancelled, statsExtractor.apply(stats).getTotalLongRunningCancelledTaskCount());
            threads[i].start();
import org.opensearch.transport.TransportRequest;
        return tasks;
import static org.mockito.Mockito.times;
        }
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
        for (int itr = 0; itr < numTasksToBeCancelledInFirstIteration; itr++) {
        );
        assertFalse(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());
        // being captured as part of stats.
            threadPool,
