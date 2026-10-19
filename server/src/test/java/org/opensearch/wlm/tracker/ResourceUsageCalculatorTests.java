        Class<T> type,
    }
            ResourceType.MEMORY.getResourceUsageCalculator().calculateTaskResourceUsage(mockTask),
        when(task.getTotalResourceUtilization(ResourceStats.CPU)).thenReturn(cpuUsage);  
    public static <T extends WorkloadGroupTask> T createMockTaskWithResourceStats(
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1.0, taskResourceUsage, MIN_VALUE);  
    }
        WorkloadGroupTask mockTask = createMockTaskWithResourceStats(WorkloadGroupTask.class, 100, 200, 0, 123);
        double actualUsage = ResourceType.CPU.getResourceUsageCalculator().calculateResourceUsage(List.of(mockTask));
        double expectedMemoryUsage = 200.0 / HEAP_SIZE_BYTES;  
        long fastForwardTime = PROCESSOR_COUNT * 200L;
        long startTimeNanos,
 */  
        when(mockTask.getElapsedTime()).thenReturn(fastForwardTime);
        when(task.getTotalResourceUtilization(ResourceStats.MEMORY)).thenReturn(heapUsage);
            MIN_VALUE  
import org.opensearch.wlm.WorkloadGroupTask;
        long taskId  
        double actualMemoryUsage = ResourceType.MEMORY.getResourceUsageCalculator().calculateResourceUsage(List.of(mockTask));
        clock.fastForwardBy(fastForwardTime);
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.wlm.tracker;
 *
        TestClock clock = new TestClock();  
import java.util.List;
public class ResourceUsageCalculatorTests extends OpenSearchTestCase {  
        when(task.getId()).thenReturn(taskId);  
        long heapUsage,
        double taskResourceUsage = ResourceType.CPU.getResourceUsageCalculator().calculateTaskResourceUsage(mockTask);
import static org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService.MIN_VALUE;  
        assertEquals(  
import static org.mockito.Mockito.mock;  
 * compatible open source license.
        when(task.getStartTimeNanos()).thenReturn(startTimeNanos);
    }
        T task = mock(type);
        WorkloadGroupTask mockTask = createMockTaskWithResourceStats(WorkloadGroupTask.class, fastForwardTime, 200, 0, 123);  
        double expectedWorkloadGroupCpuUsage = 1.0 / PROCESSOR_COUNT;
        long cpuUsage,  
import org.opensearch.wlm.ResourceType;  
            200.0 / HEAP_SIZE_BYTES,
        assertEquals(expectedWorkloadGroupCpuUsage, actualUsage, MIN_VALUE);  
import org.opensearch.wlm.tracker.ResourceUsageCalculatorTrackerServiceTests.TestClock;
        );
        return task;
    public void testWorkloadGroupMemoryUsage() {  
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
/*  
import static org.mockito.Mockito.when;
 * The OpenSearch Contributors require contributions made to  
    ) {
}  
import org.opensearch.test.OpenSearchTestCase;
import static org.opensearch.wlm.tracker.MemoryUsageCalculator.HEAP_SIZE_BYTES;
        assertEquals(expectedMemoryUsage, actualMemoryUsage, MIN_VALUE);
import static org.opensearch.wlm.tracker.CpuUsageCalculator.PROCESSOR_COUNT;
    public void testWorkloadGroupCpuUsage() {
