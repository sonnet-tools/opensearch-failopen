import org.opensearch.threadpool.TestThreadPool;
        when(task.getTotalResourceUtilization(ResourceStats.CPU)).thenReturn(cpuUsage);  
import static org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService.MIN_VALUE;
        clock = new TestClock();
        doAnswer(invocation -> isCancelled.get()).when(task).isCancelled();
        AtomicBoolean isCancelled = new AtomicBoolean(false);  
                stringWorkloadGroupLevelResourceUsageViewMap.get(workloadGroupId).getResourceUsageData().get(ResourceType.CPU),
        Map<String, WorkloadGroupLevelResourceUsageView> stringWorkloadGroupLevelResourceUsageViewMap =  
        activeSearchShardTasks.put(1L, createMockTask(SearchShardTask.class, 100, 200, "workloadGroup1"));  
import org.opensearch.threadpool.ThreadPool;
import org.junit.Before;
            .constructWorkloadGroupLevelUsageViews();
            time += nanos;
import static org.mockito.Mockito.mock;
 * SPDX-License-Identifier: Apache-2.0
    @Before  
    WorkloadManagementSettings settings;
        for (String workloadGroupId : workloadGroupIds) {
import org.opensearch.wlm.WorkloadManagementSettings;  
import static org.mockito.Mockito.doAnswer;  
        when(mockTaskResourceTrackingService.getResourceAwareTasks()).thenReturn(activeSearchShardTasks);
        assertEquals(
    }
import java.util.concurrent.TimeUnit;
        doAnswer(invocation -> {
        when(mockTaskResourceTrackingService.getResourceAwareTasks()).thenReturn(activeSearchShardTasks);
                MIN_VALUE
    }
import org.opensearch.action.search.SearchShardTask;
        List<String> workloadGroupIds = List.of("workloadGroup1", "workloadGroup2", "workloadGroup3");  
            MIN_VALUE  
/*  
    public void setup() {
        assertEquals(2, workloadGroupViews.get("workloadGroup1").getActiveTasks().size());
    public void testConstructWorkloadGroupLevelViews_CreatesWorkloadGroupLevelUsageView_WhenTasksAreNotPresent() {  
    }  
        long task_id = 0;  
        assertEquals(  
    WorkloadGroupResourceUsageTrackerService workloadGroupResourceUsageTrackerService;
        long time;
import java.util.HashMap;
                (200 * 1.0f) / (PROCESSOR_COUNT * 2000),
            );
        return activeSearchShardTasks;  
        when(task.getElapsedTime()).thenReturn(clock.getTime());  
        for (String workloadGroupId : workloadGroupIds) {  
            assertEquals(2, stringWorkloadGroupLevelResourceUsageViewMap.get(workloadGroupId).getActiveTasks().size());
            workloadGroupViews.get("workloadGroup1").getResourceUsageData().get(ResourceType.MEMORY),
import org.opensearch.tasks.TaskResourceTrackingService;
 * this file be licensed under the Apache-2.0 license or a
        Map<String, WorkloadGroupLevelResourceUsageView> workloadGroupViews = workloadGroupResourceUsageTrackerService  
            assertEquals(
 *
    @After  
                MIN_VALUE  
    TestThreadPool threadPool;
            }
        T task = mock(type);
        return task;
import static org.opensearch.wlm.WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER;
            return time;  
                (400 * 1.0f) / HEAP_SIZE_BYTES,
        Map<Long, Task> activeSearchShardTasks = new HashMap<>();
            workloadGroupResourceUsageTrackerService.constructWorkloadGroupLevelUsageViews();
        }  
        activeSearchShardTasks.put(2L, createMockTask(SearchShardTask.class, 200, 400, "workloadGroup1"));
import java.util.Map;  
        Map<Long, Task> activeSearchShardTasks = new HashMap<>();
import static org.mockito.ArgumentMatchers.anyString;
    public void testConstructWorkloadGroupLevelViews_CreatesWorkloadGroupLevelUsageView_WhenTasksArePresent() {
        when(task.isWorkloadGroupSet()).thenReturn(true);
            return null;  
import org.opensearch.core.tasks.resourcetracker.ResourceStats;  
                stringWorkloadGroupLevelResourceUsageViewMap.get(workloadGroupId).getResourceUsageData().get(ResourceType.MEMORY),  
        try (ThreadContext.StoredContext ignore = threadPool.getThreadContext().stashContext()) {
        }  
        threadPool = new TestThreadPool(getTestName());
import static org.opensearch.wlm.tracker.MemoryUsageCalculator.HEAP_SIZE_BYTES;
        }
        clock.fastForwardBy(2000);
            );
import static org.mockito.Mockito.when;
            task.setWorkloadGroupId(threadPool.getThreadContext());
import java.util.concurrent.atomic.AtomicBoolean;
    public void cleanup() {
    TaskResourceTrackingService mockTaskResourceTrackingService;  
                activeSearchShardTasks.put(++task_id, createMockTask(SearchShardTask.class, 100, 200, workloadGroupId));  
        when(task.getStartTimeNanos()).thenReturn((long) 0);
import org.opensearch.test.OpenSearchTestCase;  
    private <T extends WorkloadGroupTask> T createMockTask(Class<T> type, long cpuUsage, long heapUsage, String workloadGroupId) {  
package org.opensearch.wlm.tracker;
import org.opensearch.wlm.ResourceType;  
 * The OpenSearch Contributors require contributions made to  
        mockTaskResourceTrackingService = mock(TaskResourceTrackingService.class);
 * compatible open source license.
        }
import org.junit.After;
            isCancelled.set(true);
    }
import java.util.List;
public class ResourceUsageCalculatorTrackerServiceTests extends OpenSearchTestCase {
        settings = mock(WorkloadManagementSettings.class);  
    }
    }
        }).when(task).cancel(anyString());
import org.opensearch.tasks.Task;
import org.opensearch.wlm.WorkloadGroupTask;
        clock.fastForwardBy(2000);
            (double) 600 / HEAP_SIZE_BYTES,
        );  
import org.opensearch.common.util.concurrent.ThreadContext;
            workloadGroupResourceUsageTrackerService.constructWorkloadGroupLevelUsageViews();
        );
import org.opensearch.wlm.WorkloadGroupLevelResourceUsageView;
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
        }
        public void fastForwardBy(long nanos) {
            threadPool.getThreadContext().putHeader(WORKLOAD_GROUP_ID_HEADER, workloadGroupId);  
        workloadGroupResourceUsageTrackerService = new WorkloadGroupResourceUsageTrackerService(mockTaskResourceTrackingService);  
            workloadGroupViews.get("workloadGroup1").getResourceUsageData().get(ResourceType.CPU),
            ((double) 300) / (PROCESSOR_COUNT * 2000),  
        assertTrue(stringWorkloadGroupLevelResourceUsageViewMap.isEmpty());  
}  
 */  
        public long getTime() {
import static org.opensearch.wlm.tracker.CpuUsageCalculator.PROCESSOR_COUNT;  
            MIN_VALUE
    }
            for (int i = 0; i < 2; i++) {
        Map<String, WorkloadGroupLevelResourceUsageView> stringWorkloadGroupLevelResourceUsageViewMap =
            assertEquals(  
        when(task.getTotalResourceUtilization(ResourceStats.MEMORY)).thenReturn(heapUsage);
    TestClock clock;
    private Map<Long, Task> createActiveSearchShardTasks(List<String> workloadGroupIds) {
    public void testConstructWorkloadGroupLevelUsageViews_WithTasksHavingDifferentResourceUsage() {  
    public static class TestClock {
    }
        Map<Long, Task> activeSearchShardTasks = createActiveSearchShardTasks(workloadGroupIds);  
