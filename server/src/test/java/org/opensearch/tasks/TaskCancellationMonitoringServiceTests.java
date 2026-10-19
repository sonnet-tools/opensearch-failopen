    public void testShouldRunGetsDisabledAfterTaskCompletion() throws InterruptedException {
        );
        completeTasksConcurrently(tasks, numTasksToBeCancelledInFirstIteration, tasks.size() - 1).await();
        );  
        @Override
 */  
        assertEquals(  
        assert cancelTillIdx >= cancelFromIdx;
    }
        taskCancellationMonitoringService.doRun();
        TaskManager mockTaskManager = mock(TaskManager.class);  
            threadPool,
        int numTasks = randomIntBetween(5, 50);  
        return countDownLatch;
        assertEquals(numberOfTasksCancelled, statsExtractor.apply(stats).getCurrentLongRunningCancelledTaskCount());
        );
import java.util.concurrent.Phaser;  
    }  
            taskManager,
        }  
        assertFalse(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());  
            taskManager,
            threadPool,
    @Before  
        assertEquals(0, stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount());
import org.opensearch.common.settings.Settings;
    public void testStatsReturnsNullNativeStatsWhenProviderIsNull() {
    }
        }
import java.util.concurrent.CountDownLatch;
        List<T> tasks = new ArrayList<>(numTasks);
                taskManager.cancel(tasks.get(idx), "test", () -> {});
        phaser.arriveAndAwaitAdvance();  
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        );  
        List<CancellableTask> tasks = new ArrayList<>(createTasks(SearchShardTask.class, searchShardTaskNum));  
        int numTasksToBeCancelledInFirstIteration = randomIntBetween(2, taskNum - 1);  
import org.opensearch.action.search.SearchTask;  
 * compatible open source license.
        assertNull(stats.getNativeStats());
import java.io.IOException;
    // Caller can call this method with a list of tasks specifically mentioning which ones to cancel. And can call CountDownLatch
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        taskManager.setTaskCancellationService(new TaskCancellationService(transportService));
        for (int itr = 0; itr < tasks.size(); itr++) {
        when(mockTaskManager.getCancellableTasks()).thenReturn(new java.util.HashMap<>());
        int searchTaskNum = randomIntBetween(5, 50);
            .put(DURATION_MILLIS_SETTING.getKey(), 0) // Setting to zero for testing
            threads[i].start();
        Phaser phaser = new Phaser(totalTasksToBeCancelled + 1); // Used to concurrently cancel tasks by multiple threads.
        assertNotNull(stats.getNativeStats());
            settings,
            mockSupplier  
import java.util.function.Supplier;  
            threadPool,
        assertEquals(numTasksToBeCancelledInFirstIteration, taskCancellationMonitoringService.getCancelledTaskTracker().size());
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
        assertEquals(500, stats.getNativeStats().getSearchShardTaskTotal());
    @SuppressWarnings("unchecked")
    }
                countDownLatch.countDown();
        // Use the 3-arg constructor which passes null for the provider
            taskCancellationMonitoringSettings
        @Override
        TaskCancellationStats stats = service.stats();  
                throw new IllegalArgumentException("Unsupported task type: " + taskType);
                countDownLatch.countDown();
        // captured as part of stats.
                return new SearchShardTask(id, type, action, getDescription(), parentTaskId, headers);
            taskCancellationMonitoringSettings
    }  
            settings
        );
import java.util.function.Function;
    }
        taskCancellationMonitoringService.doStart();  
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount());
import org.opensearch.common.settings.ClusterSettings;
        assertEquals(7, stats.getNativeStats().getSearchShardTaskCurrent());
        protected String requestName;  
        );
    public void testDoStartAndStop() {  
        assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());  
        taskManager = transportService.getTaskManager();  
            stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount()
            threadPool,  
            settings,
            mockSupplier  
        int cancelTillIdx = randomIntBetween(cancelFromIdx, numTasks - 1);
        phaser.arriveAndAwaitAdvance();  
        assertEquals(numberOfTasksCancelled, statsExtractor.apply(stats).getTotalLongRunningCancelledTaskCount());
        stats = taskCancellationMonitoringService.stats();
        TaskCancellationMonitoringService service = new TaskCancellationMonitoringService(threadPool, mockTaskManager, settings);
            throw new RuntimeException("Native runtime not initialized");
        Class<T> taskType,  
        stats = taskCancellationMonitoringService.stats();
    }  
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(
import org.opensearch.core.common.io.stream.StreamOutput;  
        }
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount());
            Settings.EMPTY,
            assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(itr).getId()));
    public void testStatsHandlesProviderExceptionGracefully() {
        testWithNonZeroCancelledTasksRunning(SearchTask.class, TaskCancellationStats::getSearchTaskCancellationStats);
        );
            numTasksToBeCancelledInFirstIteration,  
        testWithNonZeroCancelledTasksRunning(SearchShardTask.class, TaskCancellationStats::getSearchShardTaskCancellationStats);
            stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount()
    ) throws InterruptedException {
import org.opensearch.Version;
import org.opensearch.test.transport.MockTransportService;
        // Verify no current running tasks  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            } else {  
    }  
            if (taskType == SearchTask.class) {
                phaser.arriveAndAwaitAdvance();  
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount());
        Settings settings = Settings.builder()  
        Function<TaskCancellationStats, BaseSearchTaskCancellationStats> statsExtractor
        );
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import org.opensearch.test.OpenSearchTestCase;
            this.taskType = taskType;
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount());
        cancelTasksConcurrently(tasks, numTasksToBeCancelledInFirstIteration, taskNum - 1).await();
        assertEquals(0, taskCancellationMonitoringService.getCancelledTaskTracker().size());
        assertFalse(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(0).getId()));
        // Task manager should not be invoked.
        when(mockTaskManager.getCancellableTasks()).thenReturn(new java.util.HashMap<>());
        assertEquals(0, stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount());
import org.opensearch.core.tasks.TaskId;
            });  
            mockThreadPool,
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(
        Supplier<AnalyticsBackendTaskCancellationStats> mockSupplier;
        int numTasks = randomIntBetween(5, 50);
        // Verify rest of the tasks are still present in tracker
        TaskCancellationMonitoringService service = new TaskCancellationMonitoringService(
        taskCancellationMonitoringService.doRun();
            taskManager,  
            super.writeTo(out);  
        CountDownLatch countDownLatch = cancelTasksConcurrently(tasks, cancelFromIdx, cancelTillIdx);
        assertEquals(numberOfTasksCancelled, statsExtractor.apply(stats).getTotalLongRunningCancelledTaskCount());
        stats = taskCancellationMonitoringService.stats();
        // Complete one task to start with.
        private Class<? extends CancellableTask> taskType;
        tasks.addAll(createTasks(SearchTask.class, searchTaskNum));
        for (int i = 0; i < numTasks; i++) {
        // Complete first iteration tasks  
        TaskCancellationStats stats = taskCancellationMonitoringService.stats();
                taskManager.unregister(tasks.get(idx));
        assertEquals(0, stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount());
        int numTasks = randomIntBetween(5, 50);
import static org.mockito.Mockito.when;
            assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(itr).getId()));
        // they have been running longer as per threshold.
        );  
        TaskManager mockTaskManager = mock(TaskManager.class);
        return tasks;
        }
        for (int itr = 0; itr < numTasksToBeCancelledInFirstIteration; itr++) {  
            return "MockQuerySearchRequest[" + requestName + "]";  
import org.opensearch.transport.TransportRequest;  
        int totalTasksToBeCancelled = cancelTillIdx - cancelFromIdx + 1;
        stats = taskCancellationMonitoringService.stats();  
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
        completeTasksConcurrently(tasks, 0, tasks.size() - 1).await();
        }
        }
        TaskCancellationStats stats = taskCancellationMonitoringService.stats();
        }  
        TaskManager mockTaskManager = mock(TaskManager.class);
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings = new TaskCancellationMonitoringSettings(  
import static org.opensearch.tasks.TaskCancellationMonitoringSettings.DURATION_MILLIS_SETTING;
        for (int itr = 0; itr < tasks.size(); itr++) {
            threads[i].start();
            numTasksToBeCancelledInFirstIteration,
        when(scheduleFuture.cancel()).thenReturn(true);
    }
import org.opensearch.threadpool.Scheduler;  
        // verify no cancelled tasks currently being recorded  
import static org.mockito.ArgumentMatchers.any;  
        // tasks.  
            settings  
    public void testWithNoCurrentRunningCancelledTasks() {
        Thread.sleep(cancelledTaskDurationThresholdMilis); // Sleep, so we later verify whether above tasks are being
        Scheduler.Cancellable scheduleFuture = mock(Scheduler.Cancellable.class);  
        TaskCancellationStats stats = taskCancellationMonitoringService.stats();
    }
        // Complete all of them finally
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        when(mockTaskManager.getCancellableTasks()).thenReturn(new java.util.HashMap<>());
            mockTaskManager,
    private <T extends CancellableTask> List<T> createTasks(Class<T> taskType, int numTasks) {  
        assertNull(stats.getNativeStats());
        // being captured as part of stats.  
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings = new TaskCancellationMonitoringSettings(
            int idx = i + cancelFromIdx;
    }  
        TaskCancellationStats stats = service.stats();  
    public void testWithVaryingCancelledTasksDuration() throws InterruptedException {
            .put(DURATION_MILLIS_SETTING.getKey(), cancelledTaskDurationThresholdMilis) // Setting to one for testing
}
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);  
        taskCancellationMonitoringService.doStop();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    public void setup() {
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount());  
            Settings.EMPTY,  
            taskCancellationMonitoringSettings
import java.util.List;  
import java.util.ArrayList;
import org.opensearch.threadpool.ThreadPool;
        for (int i = 0; i < totalTasksToBeCancelled; i++) {  
    @After
        TaskCancellationStats stats = service.stats();
            settings,
        for (int itr = numTasksToBeCancelledInFirstIteration; itr < tasks.size(); itr++) {
        }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    }
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(  
    MockTransportService transportService;
        }  
import org.junit.After;
        // Verify desired tasks were evicted from tracker map
        completeTasksConcurrently(tasks, 0, 0).await();  
        taskCancellationMonitoringService.doRun(); // 1st run to verify whether we are able to track running cancelled
        stats = taskCancellationMonitoringService.stats();
 * this file be licensed under the Apache-2.0 license or a
import org.junit.Before;
        assert cancelFromIdx >= 0;
    private CountDownLatch cancelTasksConcurrently(List<? extends CancellableTask> tasks, int cancelFromIdx, int cancelTillIdx) {
    public static class MockQuerySearchRequest extends TransportRequest {
    public void cleanup() {
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings = new TaskCancellationMonitoringSettings(  
import static org.mockito.Mockito.times;
            mockTaskManager,  
        // Cancel rest of the tasks  
            taskManager,
        assert completeTillIdx <= tasks.size() - 1;  
        public String getDescription() {
        Supplier<AnalyticsBackendTaskCancellationStats> mockSupplier = () -> {
            .build();
        taskCancellationMonitoringService.doRun();
        assert completeTillIdx >= completeFromIdx;
        }
        );
            mockTaskManager,
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            taskCancellationMonitoringSettings  
        completeTasksConcurrently(tasks, 0, tasks.size() - 1).await();  
        Settings settings = Settings.builder()  
        assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());  
            out.writeString(requestName);
        transportService.start();
            assertFalse(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(0).getId()));
    TaskManager taskManager;  
            .build();
            threadPool,  
        assertEquals(numberOfTasksCancelled, statsExtractor.apply(stats).getCurrentLongRunningCancelledTaskCount());
        );  
        for (int itr = 0; itr < numTasksToBeCancelledInFirstIteration; itr++) {  
        Settings settings = Settings.builder()  
        taskCancellationMonitoringService.doRun();
        // Start few tasks.
            assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(itr).getId()));
        countDownLatch = cancelTasksConcurrently(tasks, numTasksToBeCancelledInFirstIteration, numTasks - 1);
            } else if (taskType == SearchShardTask.class) {
import org.opensearch.threadpool.TestThreadPool;
            });  
        ThreadPool mockThreadPool = mock(ThreadPool.class);
            .build();  
        taskCancellationMonitoringService.doRun(); // 3rd run to verify current count is 0 and total remains the same.
        );  
        int searchShardTaskNum = randomIntBetween(5, 50);  
        transportService.acceptIncomingRequests();
    }  
package org.opensearch.tasks;
        assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());
        long cancelledTaskDurationThresholdMilis = 2000;  
        Thread.sleep(cancelledTaskDurationThresholdMilis); // Sleep again, so we now verify whether all tasks are
        AnalyticsBackendTaskCancellationStats expectedNativeStats = new AnalyticsBackendTaskCancellationStats(3, 100, 7, 500);
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(  
        verify(scheduleFuture, times(1)).cancel();
        // Should handle exception gracefully and return null native stats
            .put(DURATION_MILLIS_SETTING.getKey(), 0) // Setting to zero for testing
        // Start few tasks.  
        public void writeTo(StreamOutput out) throws IOException {
        verify(mockTaskManager, times(0)).getTasks();  
        when(mockThreadPool.scheduleWithFixedDelay(any(), any(), any())).thenReturn(scheduleFuture);
        assertEquals(numTasks, stats.getSearchShardTaskCancellationStats().getTotalLongRunningCancelledTaskCount());
            Settings.EMPTY,
        TaskCancellationMonitoringSettings taskCancellationMonitoringSettings = new TaskCancellationMonitoringSettings(  
            assertFalse(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(itr).getId()));
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(  
        CountDownLatch countDownLatch = cancelTasksConcurrently(tasks, 0, numTasksToBeCancelledInFirstIteration - 1);
        assertEquals(
        transportService.close();  
import static org.mockito.Mockito.mock;
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
            threadPool,  
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
            taskManager,
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
        // Verify desired task ids are present.
        @Override  
        countDownLatch.await(); // Wait for rest of tasks to be cancelled.  
        );
        assertEquals(3, stats.getNativeStats().getSearchTaskCurrent());
        assertEquals(numberOfTasksCancelled, statsExtractor.apply(stats).getTotalLongRunningCancelledTaskCount());  
    public void testWithNonZeroCancelledSearchShardTasksRunning() throws InterruptedException {  
        int numTasksToBeCancelledInFirstIteration = randomIntBetween(1, numTasks - 1);  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        );
    }  
            Settings.EMPTY,
            threadPool,  
    ThreadPool threadPool;
                return new SearchTask(id, type, action, this::getDescription, parentTaskId, headers);  
        Settings settings = Settings.builder()
        TaskManager mockTaskManager = mock(TaskManager.class);
            Settings.EMPTY,
        };  
        assertEquals(0, statsExtractor.apply(stats).getCurrentLongRunningCancelledTaskCount());
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
 * The OpenSearch Contributors require contributions made to  
        taskCancellationMonitoringService.doRun();
        for (int itr = 1; itr < tasks.size(); itr++) {  
        TaskCancellationMonitoringService service = new TaskCancellationMonitoringService(
        int numberOfTasksCancelled = cancelTillIdx - cancelFromIdx + 1;
    }
    public void testWithNonZeroCancelledSearchTasksRunning() throws InterruptedException {
        public MockQuerySearchRequest(Class<? extends CancellableTask> taskType) {
        assert cancelTillIdx <= tasks.size() - 1;  
        CountDownLatch countDownLatch = cancelTasksConcurrently(tasks, 0, numTasksToBeCancelledInFirstIteration - 1);
        // Verify only tasks that were cancelled as part of first iteration is being captured as part of stats as  
        int taskNum = searchShardTaskNum + searchTaskNum;
        cancelTasksConcurrently(tasks, 0, tasks.size() - 1).await();  
            settings,
        int cancelFromIdx = randomIntBetween(0, numTasks - 1);
        );
        );  
import java.util.Map;
        return countDownLatch;
        // Verify rest of the tasks are still present in tracker  
        );  
        List<SearchShardTask> tasks = createTasks(SearchShardTask.class, numTasks);
        assert completeFromIdx >= 0;
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        }
        threadPool = new TestThreadPool(getClass().getName());
        );  
                phaser.arriveAndAwaitAdvance();  
import java.util.concurrent.TimeUnit;
        completeTasksConcurrently(tasks, 0, tasks.size() - 1).await();  
            settings,
        }
    // .await() to wait for all tasks be cancelled.  
        CountDownLatch countDownLatch = new CountDownLatch(totalTasksToBeCancelled); // To wait for all threads to finish.
    private CountDownLatch completeTasksConcurrently(List<? extends CancellableTask> tasks, int completeFromIdx, int completeTillIdx) {
import static org.mockito.Mockito.verify;  
public class TaskCancellationMonitoringServiceTests extends OpenSearchTestCase {  
/*  
        Thread[] threads = new Thread[totalTasksToBeCancelled];  
        assertEquals(0, stats.getSearchShardTaskCancellationStats().getCurrentLongRunningCancelledTaskCount());
        List<T> tasks = createTasks(taskType, numTasks);
        countDownLatch.await(); // Wait for all tasks to be cancelled in first iteration
    public void testTasksAreGettingEvictedCorrectlyAfterCompletion() throws InterruptedException {
import org.opensearch.action.search.SearchShardTask;
 *
        Thread[] threads = new Thread[totalTasksToBeCompleted];  
            super();  
        Phaser phaser = new Phaser(totalTasksToBeCompleted + 1);
            }
            threads[i] = new Thread(() -> {
    }  
        );  
        for (int i = 0; i < totalTasksToBeCompleted; i++) {  
        List<SearchShardTask> tasks = createTasks(SearchShardTask.class, numTasks);
            int idx = i + completeFromIdx;
        completeTasksConcurrently(tasks, 1, numTasksToBeCancelledInFirstIteration - 1).await();
        assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());  
            threads[i] = new Thread(() -> {
        TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(  
            assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().containsKey(tasks.get(itr).getId()));  
    }  
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(  
        int totalTasksToBeCompleted = completeTillIdx - completeFromIdx + 1;
            settings,
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        assertTrue(taskCancellationMonitoringService.getCancelledTaskTracker().isEmpty());  
        stats = taskCancellationMonitoringService.stats();
            tasks.add((T) taskManager.register("type-" + i, "action-" + i, new MockQuerySearchRequest(taskType)));  
        taskCancellationMonitoringService.doRun(); // 2nd run. Verify same.
            .put(DURATION_MILLIS_SETTING.getKey(), 0) // Setting to one for testing
        mockSupplier = () -> expectedNativeStats;  
        CountDownLatch countDownLatch = new CountDownLatch(totalTasksToBeCompleted);
        assertEquals(100, stats.getNativeStats().getSearchTaskTotal());  
        taskCancellationMonitoringService.doRun();
        }
        countDownLatch.await(); // Wait for all tasks to be cancelled in first iteration
    public void testStatsIncludesNativeCountersWhenProviderAvailable() {
    private <T extends CancellableTask> void testWithNonZeroCancelledTasksRunning(
            .build();
 * SPDX-License-Identifier: Apache-2.0
        countDownLatch.await(); // Wait for all threads execution.
