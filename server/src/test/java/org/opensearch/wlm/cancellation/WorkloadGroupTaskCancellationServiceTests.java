            "testWorkloadGroup2",
            new MaximumResourceTaskSelectionStrategy(),  
    private WorkloadGroupLevelResourceUsageView createResourceUsageViewMock() {  
        );  
            1L  
        Double threshold = 0.1;  
            workloadGroupId2,
    }
        double activeWorkloadGroupCpuUsage = 0.11;  
        when(mockView.getResourceUsageData()).thenReturn(Map.of(resourceType, cpuUsage, ResourceType.MEMORY, memoryUsage));  
            1L
        );  
            workloadGroupId1,  
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;  
        assertEquals(2, cancellableTasksFrom.size());  
        assertEquals(1000, cancellableTasksFromDeletedWorkloadGroups.get(0).getTask().getId());  
            1L  
        workloadGroupLevelViews.put(workloadGroupId1, mockView1);
        assertEquals(2, cancellableTasksFrom.size());
        activeWorkloadGroups.add(workloadGroup1);
        when(mockView.getActiveTasks()).thenReturn(List.of(getRandomSearchTask(5678), getRandomSearchTask(8765)));  
        when(workloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        taskCancellation.cancelTasks(() -> true, activeWorkloadGroups, deletedWorkloadGroups);
        when(mockView.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage, ResourceType.MEMORY, memoryUsage));
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
            new MaximumResourceTaskSelectionStrategy(),  
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(List.of(workloadGroup1));
        assertEquals(2, cancellableTasksFrom.size());
            "testWorkloadGroup",
        double cpuUsage = 0.81;  
        when(mockView.getActiveTasks()).thenReturn(List.of(getRandomSearchTask(1234), getRandomSearchTask(4321)));
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
        );
        double activeWorkloadGroupMemoryUsage = 0.0;
        double deletedWorkloadGroupCpuUsage = 0.11;
            workloadManagementSettings,  
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());  
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());  
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
            "test description",
        double cpuUsage = 0.0;
    private Map<String, WorkloadGroupLevelResourceUsageView> workloadGroupLevelViews;
        when(mockView.getActiveTasks()).thenReturn(ids.stream().map(this::getRandomSearchTask).collect(Collectors.toList()));
        workloadGroupLevelViews.put(workloadGroupId1, mockView);  
        Double threshold = 0.01;
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
        );  
        WorkloadGroupLevelResourceUsageView mockView1 = createResourceUsageViewMock();
            workloadGroupId2,  
        WorkloadGroup deletedWorkloadGroup = new WorkloadGroup(
        WorkloadGroup workloadGroup2 = new WorkloadGroup(
            "testWorkloadGroup",
        double workloadGroupCpuUsage = 0.09;
            "testWorkloadGroup",  
            activeWorkloadGroups  
            Collections.emptyMap(),  
            "testWorkloadGroup",
        WorkloadGroupLevelResourceUsageView resourceUsageView1 = createResourceUsageViewMock();
import org.opensearch.core.tasks.TaskId;  
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),  
        assertEquals(2, cancellableTasksFromDeletedWorkloadGroups.size());
        when(workloadManagementSettings.getNodeLevelMemoryCancellationThreshold()).thenReturn(0.9);  
        when(workloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        Collection<Integer> ids  
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
        double cpuUsage = 0.11;
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
            workloadManagementSettings,
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
 * compatible open source license.
            stateAccessor
import java.util.Map;
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
            ResiliencyMode.ENFORCED,
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;  
        );  
    private Set<WorkloadGroup> deletedWorkloadGroups;  
        );  
        double activeWorkloadGroupCpuUsage = 0.01;
    }
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),  
        assertEquals(2, cancellableTasksFrom1.size());
    public void testGetCancellableTasksFrom_returnsTasksWhenBreachingThreshold() {
        ResourceType resourceType = ResourceType.CPU;
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
        );
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(ResourceType.CPU, 0.1)),
            "testWorkloadGroup",
        activeWorkloadGroups.add(workloadGroup1);  
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
            "testWorkloadGroup1",
        );  
            workloadGroupId1,  
    }
    }
        workloadGroupLevelViews.put(workloadGroupId1, mockView);  
        double cpuUsage = 0.11;  
            stateAccessor
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
            workloadGroupId1,
        clock = new TestClock();
        );
        when(resourceUsageTrackerService.constructWorkloadGroupLevelUsageViews()).thenReturn(workloadGroupLevelViews);
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
            1L  
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
import org.opensearch.wlm.tracker.WorkloadGroupResourceUsageTrackerService;
        double cpuUsage2 = 0.11;
    public void testGetAllCancellableTasks_ReturnsTasksWhenBreachingThresholds() {
    }  
    }
        ResourceType resourceType = ResourceType.CPU;
        assertEquals(5678, cancellableTasksFrom1.get(0).getTask().getId());  
        Double threshold = 0.9;
            stateAccessor
        );  
            new MaximumResourceTaskSelectionStrategy(),
        assertTrue(cancellableTasksFrom1.get(0).getTask().isCancelled());
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(  
import org.opensearch.wlm.WorkloadGroupsStateAccessor;  
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
        assertTrue(cancellableTasksFrom.get(0).getTask().isCancelled());
        WorkloadGroup deletedWorkloadGroup = new WorkloadGroup(
        assertTrue(cancellableTasksFrom.get(1).getTask().isCancelled());
        assertFalse(cancellableTasksFromDeletedWorkloadGroups.get(0).getTask().isCancelled());  
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        assertEquals(1, deletedWorkloadGroups.size());
        ResourceType resourceType = ResourceType.CPU;
 *
    private WorkloadGroupLevelResourceUsageView createResourceUsageViewMock(  
        );  
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
            workloadManagementSettings,
        ResourceType resourceType = ResourceType.CPU;  
        assertTrue(cancellableTasksFromDeletedWorkloadGroups.get(1).getTask().isCancelled());
            workloadGroupId2,
import java.util.Collections;  
        activeWorkloadGroups.add(activeWorkloadGroup);
    }  
        when(mockView2.getResourceUsageData()).thenReturn(
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();  
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;  
public class WorkloadGroupTaskCancellationServiceTests extends OpenSearchTestCase {
    }
            deletedWorkloadGroupCpuUsage,  
            Map.of(ResourceType.CPU, workloadGroupCpuUsage, ResourceType.MEMORY, workloadGroupMemoryUsage)  
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());  
        ResourceType resourceType = ResourceType.CPU;
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
import org.opensearch.wlm.WorkloadGroupLevelResourceUsageView;
        );  
            1L  
    private WorkloadManagementSettings workloadManagementSettings;
        ResourceType resourceType = ResourceType.CPU;  
    public void setup() {
        );  
        double memoryUsage = 0.0;  
    public void testGetCancellableTasksFrom_setupAppropriateCancellationReasonAndScore() {  
            "testWorkloadGroup",
 * The OpenSearch Contributors require contributions made to  
            workloadGroupId1,
        workloadManagementSettings = mock(WorkloadManagementSettings.class);
        activeWorkloadGroups.add(activeWorkloadGroup);
    public void testGetCancellableTasksFrom_returnsNoTasksWhenNotBreachingThreshold() {
    private static final String workloadGroupId1 = "workloadGroup1";
    }  
        activeWorkloadGroups.add(workloadGroup1);  
        );
        when(resourceUsageView1.getActiveTasks()).thenReturn(activeTasks);
        double memoryUsage = 0.0;
        List<TaskCancellation> cancellableTasksFromDeletedWorkloadGroups = taskCancellation.getAllCancellableTasks(
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
            resourceUsageTrackerService,  
        );
        double usage = 0.11;
        );  
        activeWorkloadGroups = new HashSet<>();
            new TaskId(randomLong() + ":" + randomLong()),
/*  
            1L
        );
    }
        assertTrue(cancellableTasksFrom.get(0).getTask().isCancelled());
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;  
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(ResiliencyMode.SOFT, activeWorkloadGroups);
            new MutableWorkloadGroupFragment(ResiliencyMode.SOFT, Map.of(resourceType, threshold)),
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
            List.of(deletedWorkloadGroup)  
            new MaximumResourceTaskSelectionStrategy(),  
            workloadGroupId1,  
        assertEquals(0, cancellableTasksFrom.size());  
import org.opensearch.wlm.WlmMode;  
        taskCancellation.cancelTasks(() -> true, activeWorkloadGroups, deletedWorkloadGroups);
        );
        double memoryUsage = 0.0;
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
package org.opensearch.wlm.cancellation;
            1L
            workloadGroupId1,
        when(stateAccessor.getWorkloadGroupState(any())).thenReturn(new WorkloadGroupState());  
        return mockView;
            workloadManagementSettings,
import org.opensearch.wlm.WorkloadManagementSettings;
    public void testCancelTasks_does_not_cancelTasksFromDeletedWorkloadGroups_whenNodeNotInDuress() {
        );
            resourceUsageTrackerService,
    private WorkloadGroupTaskCancellationService taskCancellation;
            null,
        );
        assertEquals(2, cancellableTasksFromDeletedWorkloadGroups.size());
        Double threshold = 0.01;
        double memoryUsage = 0.11;
        double memoryUsage = 0.011;  
            workloadGroupId1,
        WorkloadGroup workloadGroup1 = new WorkloadGroup(  
            resourceUsageTrackerService,
            ResiliencyMode.ENFORCED,  
            workloadManagementSettings,
        when(resourceUsageTrackerService.constructWorkloadGroupLevelUsageViews()).thenReturn(workloadGroupLevelViews);  
            workloadManagementSettings,
        deletedWorkloadGroups.add(deletedWorkloadGroup);
        double deletedWorkloadGroupCpuUsage = 0.01;  
            stateAccessor  
import org.opensearch.wlm.MutableWorkloadGroupFragment;  
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(  
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(List.of(workloadGroup2));
            1L
            1L
import org.junit.Before;
import java.util.stream.Collectors;  
    }
        assertTrue(cancellableTasksFrom.get(0).getTask().isCancelled());
        workloadGroupLevelViews.put(workloadGroupId1, resourceUsageView1);  
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());  
import java.util.ArrayList;
        );
        clock.fastForwardBy(1000);  
            1L
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        double usage,
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
            "testWorkloadGroup",  
        when(mockView1.getResourceUsageData()).thenReturn(
            SearchAction.NAME,  
        assertEquals(1001, cancellableTasksFromDeletedWorkloadGroups.get(1).getTask().getId());
        return mockView;  
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold, ResourceType.MEMORY, threshold)),
        taskCancellation.cancelTasks(() -> false, activeWorkloadGroups, deletedWorkloadGroups);  
            activeWorkloadGroups
        when(mockView.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage, resourceType, memoryUsage));
import org.opensearch.wlm.tracker.ResourceUsageCalculatorTrackerServiceTests.TestClock;  
        );  
        WorkloadGroupLevelResourceUsageView resourceUsageView2 = createResourceUsageViewMock();  
        List<TaskCancellation> allCancellableTasks = taskCancellation.getAllCancellableTasks(ResiliencyMode.ENFORCED, activeWorkloadGroups);
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
        Double threshold = 0.1;
        activeWorkloadGroups.add(workloadGroup1);
        assertTrue(cancellableTasksFrom1.get(1).getTask().isCancelled());  
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
        workloadGroupLevelViews.put(workloadGroupId1, mockView1);
            "testWorkloadGroup1",
            resourceUsageTrackerService,
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
            workloadGroupId2,  
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(List.of(workloadGroup1));
        Double threshold = 0.01;
        ResourceType resourceType = ResourceType.CPU;  
    public void testCancelTasks_cancelsGivenTasks() {  
import org.opensearch.wlm.stats.WorkloadGroupState;
    }  
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
    }  
 */  
        double memoryUsage = 0.0;
        assertTrue(cancellableTasksFrom.get(0).getTask().isCancelled());  
        workloadGroupLevelViews.put(workloadGroupId2, mockView);
        double memoryUsage1 = 0.0;
            "testWorkloadGroup",
            "testWorkloadGroup2",
import java.util.Set;
        ResourceType resourceType = ResourceType.CPU;
        assertEquals(2, allCancellableTasks.size());  
        assertEquals(4321, allCancellableTasks.get(1).getTask().getId());
        WorkloadGroup activeWorkloadGroup = new WorkloadGroup(
            1L
        List<TaskCancellation> cancellableTasksFrom1 = taskCancellation.getAllCancellableTasks(ResiliencyMode.SOFT, activeWorkloadGroups);
        assertEquals(2, cancellableTasksFrom.size());  
        );  
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
            workloadGroupId1,
        Double threshold = 0.01;
import static org.mockito.ArgumentMatchers.any;  
import java.util.HashMap;
            id,
        when(mockView2.getResourceUsageData()).thenReturn(
            resourceType,
            1L
        workloadGroupLevelViews.put(workloadGroupId2, mockView2);
            List.of(1000, 1001)
            "testWorkloadGroup",  
        );  
import org.opensearch.cluster.metadata.WorkloadGroup;
        activeWorkloadGroups.add(workloadGroup2);
        activeWorkloadGroups.add(workloadGroup1);
            1L
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
            "transport",
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        double workloadGroupMemoryUsage = 0.0;  
    ) {
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;  
        );
        WorkloadGroupLevelResourceUsageView mockView2 = createResourceUsageViewMock(
        Double threshold = 0.01;
        assertEquals(workloadGroupId1, deletedWorkloadGroups.get(0).get_id());
import java.util.stream.IntStream;
            activeWorkloadGroups
        List<WorkloadGroupTask> activeTasks = IntStream.range(0, 5).mapToObj(this::getRandomSearchTask).collect(Collectors.toList());  
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        taskCancellation.pruneDeletedWorkloadGroups(deletedWorkloadGroups);
        when(mockView.getResourceUsageData()).thenReturn(Map.of(resourceType, cpuUsage, ResourceType.MEMORY, memoryUsage));
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        double usage = 0.02;
        ResourceType resourceType,
    }
    public void testPruneDeletedWorkloadGroups() {  
        assertEquals(8765, cancellableTasksFrom1.get(1).getTask().getId());
        stateAccessor = mock(WorkloadGroupsStateAccessor.class);
            deletedWorkloadGroupCpuUsage,  
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;  
        List<TaskCancellation> allCancellableTasks = taskCancellation.getAllCancellableTasks(ResiliencyMode.ENFORCED, activeWorkloadGroups);  
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(  
            "testWorkloadGroup",
            resourceUsageTrackerService,
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();  
        when(mockView.getResourceUsageData()).thenReturn(
            activeWorkloadGroups
        Double threshold = 0.1;  
        WorkloadGroupLevelResourceUsageView mockView1 = createResourceUsageViewMock();  
            ResiliencyMode.ENFORCED,
            1L
        workloadGroupLevelViews.put(workloadGroupId2, resourceUsageView2);
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
        );
        assertEquals(2, cancellableTasksFrom.size());
        );
    public void testCancelTasks_cancelsGivenTasks_WhenNodeInDuress() {
        double deletedWorkloadGroupMemoryUsage = 0.0;
            "testWorkloadGroup",
        ResourceType resourceType = ResourceType.CPU;
        double memoryUsage2 = 0.0;  
        return new WorkloadGroupTask(  
        when(workloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        ResourceType resourceType = ResourceType.MEMORY;  
        );
    private WorkloadGroupTask getRandomSearchTask(long id) {
        );  
            Map.of(ResourceType.CPU, deletedWorkloadGroupCpuUsage, ResourceType.MEMORY, deletedWorkloadGroupMemoryUsage)
        WorkloadGroupLevelResourceUsageView mockView = mock(WorkloadGroupLevelResourceUsageView.class);
    private Set<WorkloadGroup> activeWorkloadGroups;
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(List.of(workloadGroup1));
import org.opensearch.tasks.TaskCancellation;
        );  
        double cpuUsage = 0.011;
        when(workloadManagementSettings.getNodeLevelCpuCancellationThreshold()).thenReturn(0.9);
            List.of(deletedWorkloadGroup)  
    public void testCancelTasks_cancelsTasksFromDeletedWorkloadGroups() {
        when(mockView1.getResourceUsageData()).thenReturn(
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(
    }
        WorkloadGroup activeWorkloadGroup = new WorkloadGroup(
            ResiliencyMode.ENFORCED,  
import org.opensearch.action.search.SearchAction;
        deletedWorkloadGroups.add(workloadGroup1);
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(
            1L
import static org.mockito.Mockito.mock;
        when(workloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    private static final String workloadGroupId2 = "workloadGroup2";  
        assertFalse(cancellableTasksFromDeletedWorkloadGroups.get(1).getTask().isCancelled());
    }
        ResourceType resourceType = ResourceType.CPU;
        );
        when(resourceUsageTrackerService.constructWorkloadGroupLevelUsageViews()).thenReturn(workloadGroupLevelViews);  
        );
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),  
        );  
import org.opensearch.wlm.WorkloadGroupTask;
            1L
        assertEquals(0, cancellableTasksFrom.size());  
        Double threshold = 0.1;
        taskCancellation.cancelTasks(() -> false, activeWorkloadGroups, deletedWorkloadGroups);
import java.util.Collection;
            Map.of(ResourceType.CPU, deletedWorkloadGroupCpuUsage, ResourceType.MEMORY, deletedWorkloadGroupMemoryUsage)
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        double cpuUsage = 0.11;
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
        assertTrue(cancellableTasksFrom.get(1).getTask().isCancelled());
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
            stateAccessor
        deletedWorkloadGroups.add(deletedWorkloadGroup);
        WorkloadGroup workloadGroup1 = new WorkloadGroup(  
        when(mockView.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage, ResourceType.MEMORY, memoryUsage));  
import java.util.List;  
            resourceUsageTrackerService,
        List<TaskCancellation> cancellableTasksFromDeletedWorkloadGroups = taskCancellation.getAllCancellableTasks(
        );  
    private WorkloadGroupsStateAccessor stateAccessor;
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),  
            stateAccessor
    private WorkloadGroupResourceUsageTrackerService resourceUsageTrackerService;  
            Map.of(ResourceType.CPU, activeWorkloadGroupCpuUsage, ResourceType.MEMORY, activeWorkloadGroupMemoryUsage)
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        assertEquals(1, cancellableTasksFrom.get(0).getReasons().get(0).getCancellationScore());
        activeWorkloadGroups.add(workloadGroup1);
        WorkloadGroup workloadGroup1 = new WorkloadGroup(  
            1L
        when(mockView.getResourceUsageData()).thenReturn(Collections.singletonMap(resourceType, usage));  
            workloadGroupId1,  
        assertTrue(cancellableTasksFrom.get(1).getTask().isCancelled());
        when(resourceUsageView2.getActiveTasks()).thenReturn(new ArrayList<>());
import static org.mockito.Mockito.when;
import java.util.HashSet;
        );  
            "testWorkloadGroup",
        assertTrue(cancellableTasksFrom.get(1).getTask().isCancelled());
        WorkloadGroup workloadGroup1 = new WorkloadGroup(  
        double activeWorkloadGroupMemoryUsage = 0.0;
        activeWorkloadGroups.add(workloadGroup1);
            new MaximumResourceTaskSelectionStrategy(),  
    private TestClock clock;
        taskCancellation = new WorkloadGroupTaskCancellationService(
            "testWorkloadGroup",  
            workloadGroupId1,  
        workloadGroupLevelViews.put(workloadGroupId1, mockView);  
    }  
        double cpuUsage1 = 0.11;  
        deletedWorkloadGroups = new HashSet<>();
            stateAccessor  
            new MaximumResourceTaskSelectionStrategy(),
            new MaximumResourceTaskSelectionStrategy(),
        WorkloadGroupLevelResourceUsageView mockView2 = createResourceUsageViewMock(
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
        when(mockView.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage2, ResourceType.MEMORY, memoryUsage2));
            workloadGroupId1,  
        when(resourceUsageTrackerService.constructWorkloadGroupLevelUsageViews()).thenReturn(workloadGroupLevelViews);  
        assertEquals(1234, allCancellableTasks.get(0).getTask().getId());
            workloadManagementSettings,  
        assertEquals(1001, cancellableTasksFromDeletedWorkloadGroups.get(1).getTask().getId());
        assertTrue(cancellableTasksFromDeletedWorkloadGroups.get(0).getTask().isCancelled());  
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        when(mockView1.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage1, ResourceType.MEMORY, memoryUsage1));  
            resourceUsageTrackerService,
        assertEquals(1000, cancellableTasksFromDeletedWorkloadGroups.get(0).getTask().getId());  
        assertEquals(2, cancellableTasksFrom.size());
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(ResourceType.CPU, 0.2)),
        WorkloadGroupLevelResourceUsageView mockView1 = createResourceUsageViewMock();  
    public void testGetCancellableTasksFrom_returnsTasksWhenBreachingThresholdForMemory() {
        WorkloadGroup workloadGroup2 = new WorkloadGroup(
        Double threshold = 0.01;
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
import org.opensearch.wlm.ResourceType;
            workloadGroupId1,
        deletedWorkloadGroups.add(workloadGroup2);  
            workloadGroupId2,  
        workloadGroupLevelViews.put(workloadGroupId2, mockView2);  
        when(mockView.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage, ResourceType.MEMORY, memoryUsage));  
            ResiliencyMode.ENFORCED,
        WorkloadGroupLevelResourceUsageView mockView = mock(WorkloadGroupLevelResourceUsageView.class);
 * SPDX-License-Identifier: Apache-2.0
    @Before  
        workloadGroupLevelViews.put(workloadGroupId1, mockView1);
            "testWorkloadGroup",
            resourceType,
            clock::getTime
        resourceUsageTrackerService = mock(WorkloadGroupResourceUsageTrackerService.class);
    public void testGetAllCancellableTasks_ReturnsNoTasksWhenNotBreachingThresholds() {  
            1L
        Collections.addAll(activeWorkloadGroups, workloadGroup1, workloadGroup2);  
            Map.of(ResourceType.CPU, activeWorkloadGroupCpuUsage, ResourceType.MEMORY, activeWorkloadGroupMemoryUsage)
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
            workloadGroupId1,  
        assertTrue(allCancellableTasks.isEmpty());
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        );  
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
        workloadGroupLevelViews.put(workloadGroupId1, mockView);  
        );
        );
        );  
            activeWorkloadGroups
        assertTrue(cancellableTasksFrom.isEmpty());
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;
        assertEquals(2, cancellableTasksFrom.size());  
        ResourceType resourceType = ResourceType.CPU;  
    public void testGetCancellableTasksFrom_filtersWorkloadGroupCorrectly() {
    public void testGetCancellableTasksFrom_doesNotReturnTasksWhenWorkloadGroupIdNotFound() {
            List.of(1000, 1001)
        double deletedWorkloadGroupMemoryUsage = 0.0;  
        WorkloadGroup workloadGroup2 = new WorkloadGroup(
        Double threshold = 0.01;
        );
        workloadGroupLevelViews = new HashMap<>();  
}
        List<WorkloadGroup> deletedWorkloadGroups = new ArrayList<>();
