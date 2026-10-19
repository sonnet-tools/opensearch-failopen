        clock = new ResourceUsageCalculatorTrackerServiceTests.TestClock();
    public void testGetResourceUsageData() {
import java.util.Map;
        assertEquals(1, activeTasks.get(0).getId());
        List<WorkloadGroupTask> activeTasks = workloadGroupLevelResourceUsageView.getActiveTasks();  
import static org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService.MIN_VALUE;
import static org.mockito.Mockito.mock;
 * this file be licensed under the Apache-2.0 license or a
        resourceUsage = Map.of(ResourceType.MEMORY, memoryUsage, ResourceType.CPU, cpuUsage);
        );
        WorkloadGroupLevelResourceUsageView workloadGroupLevelResourceUsageView = new WorkloadGroupLevelResourceUsageView(
    }
import org.opensearch.wlm.tracker.ResourceUsageCalculatorTrackerServiceTests;
        WorkloadGroupLevelResourceUsageView workloadGroupLevelResourceUsageView = new WorkloadGroupLevelResourceUsageView(
}  
        return (resourceUsageData.get(ResourceType.MEMORY) - 200.0 / HEAP_SIZE_BYTES) <= MIN_VALUE  
            activeTasks
        settings = mock(WorkloadManagementSettings.class);  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(1, activeTasks.size());
    public void testGetActiveTasks() {
import static org.opensearch.wlm.tracker.ResourceUsageCalculatorTests.createMockTaskWithResourceStats;
    }
import org.opensearch.test.OpenSearchTestCase;
        clock.fastForwardBy(300);  
package org.opensearch.wlm;
import java.util.List;
    private boolean assertResourceUsageData(Map<ResourceType, Double> resourceUsageData) {
        assertTrue(assertResourceUsageData(resourceUsageData));
    WorkloadManagementSettings settings;
        super.setUp();
    }  
 * compatible open source license.
    public void setUp() throws Exception {
    List<WorkloadGroupTask> activeTasks;  
import static org.opensearch.wlm.tracker.MemoryUsageCalculator.HEAP_SIZE_BYTES;  
/*  
    }
    ResourceUsageCalculatorTrackerServiceTests.TestClock clock;
 */  
import static org.opensearch.wlm.tracker.CpuUsageCalculator.PROCESSOR_COUNT;
            && (resourceUsageData.get(ResourceType.CPU) - 100.0 / (300)) < MIN_VALUE;
            resourceUsage,  
 * SPDX-License-Identifier: Apache-2.0
        );
        double cpuUsage = 100.0 / (PROCESSOR_COUNT * 300.0);
        double memoryUsage = 200.0 / HEAP_SIZE_BYTES;
        Map<ResourceType, Double> resourceUsageData = workloadGroupLevelResourceUsageView.getResourceUsageData();  
public class WorkloadGroupLevelResourceUsageViewTests extends OpenSearchTestCase {
        activeTasks = List.of(createMockTaskWithResourceStats(WorkloadGroupTask.class, 100, 200, 0, 1));
 *
            resourceUsage,  
    Map<ResourceType, Double> resourceUsage;
            activeTasks
