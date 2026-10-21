        workloadGroupLevelViews = new HashMap<>();
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
        assertEquals(1, deletedWorkloadGroups.size());
    }
        workloadGroupLevelViews.put(workloadGroupId1, resourceUsageView1);
            workloadManagementSettings,
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
        ResourceType resourceType = ResourceType.CPU;
        assertEquals(2, cancellableTasksFrom.size());
        when(mockView2.getResourceUsageData()).thenReturn(
import org.opensearch.tasks.TaskCancellation;
        when(mockView.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage, ResourceType.MEMORY, memoryUsage));
            "transport",
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
        WorkloadGroupLevelResourceUsageView resourceUsageView1 = createResourceUsageViewMock();
        assertTrue(cancellableTasksFrom.get(1).getTask().isCancelled());
    ) {
            workloadManagementSettings,
        workloadGroupLevelViews.put(workloadGroupId2, mockView2);
import java.util.ArrayList;
        );
import java.util.Map;
        assertEquals(workloadGroupId1, deletedWorkloadGroups.get(0).get_id());
        double cpuUsage2 = 0.11;
        );
 * compatible open source license.
        );
        assertFalse(cancellableTasksFromDeletedWorkloadGroups.get(0).getTask().isCancelled());
            1L
import static org.mockito.Mockito.when;
            "testWorkloadGroup",
        );
import static org.mockito.Mockito.mock;
        );
        double usage = 0.02;
        double activeWorkloadGroupMemoryUsage = 0.0;
            "testWorkloadGroup",
        activeWorkloadGroups.add(workloadGroup1);
            "testWorkloadGroup",
            workloadGroupId1,
        activeWorkloadGroups.add(workloadGroup1);
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        ResourceType resourceType = ResourceType.CPU;
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
            1L
        assertTrue(cancellableTasksFrom1.get(1).getTask().isCancelled());
        assertEquals(1001, cancellableTasksFromDeletedWorkloadGroups.get(1).getTask().getId());
            workloadGroupId2,
import java.util.List;
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        );
            List.of(1000, 1001)
            workloadManagementSettings,
    private WorkloadGroupTaskCancellationService taskCancellation;
        deletedWorkloadGroups.add(deletedWorkloadGroup);
            new MaximumResourceTaskSelectionStrategy(),
        deletedWorkloadGroups.add(deletedWorkloadGroup);
        when(mockView2.getResourceUsageData()).thenReturn(
        when(workloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        double cpuUsage = 0.11;
        when(mockView1.getResourceUsageData()).thenReturn(
        );
        );
        ResourceType resourceType = ResourceType.MEMORY;
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(ResourceType.CPU, 0.2)),
            workloadGroupId1,
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        Double threshold = 0.1;
        );
        Double threshold = 0.01;
            "testWorkloadGroup",
            List.of(1000, 1001)
import org.junit.Before;
        WorkloadGroupLevelResourceUsageView mockView1 = createResourceUsageViewMock();
        Double threshold = 0.01;
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
            activeWorkloadGroups
            stateAccessor
        WorkloadGroup deletedWorkloadGroup = new WorkloadGroup(
        when(mockView.getActiveTasks()).thenReturn(ids.stream().map(this::getRandomSearchTask).collect(Collectors.toList()));
        activeWorkloadGroups.add(activeWorkloadGroup);
        when(mockView.getResourceUsageData()).thenReturn(
import org.opensearch.wlm.tracker.WorkloadGroupResourceUsageTrackerService;
        return new WorkloadGroupTask(
            ResiliencyMode.ENFORCED,
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        double memoryUsage = 0.0;
        assertTrue(cancellableTasksFrom.get(1).getTask().isCancelled());
    }
    }
        taskCancellation = new WorkloadGroupTaskCancellationService(
import org.opensearch.cluster.metadata.WorkloadGroup;
            clock::getTime
        );
            activeWorkloadGroups
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
            stateAccessor
        when(mockView.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage, ResourceType.MEMORY, memoryUsage));
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
            activeWorkloadGroups
        when(stateAccessor.getWorkloadGroupState(any())).thenReturn(new WorkloadGroupState());
            resourceUsageTrackerService,
            ResiliencyMode.ENFORCED,
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(
    }
            workloadGroupId1,
    public void testCancelTasks_does_not_cancelTasksFromDeletedWorkloadGroups_whenNodeNotInDuress() {
        );
        double cpuUsage = 0.11;
        assertEquals(0, cancellableTasksFrom.size());
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
            activeWorkloadGroups
            null,
    public void testGetCancellableTasksFrom_returnsTasksWhenBreachingThreshold() {
            workloadGroupId1,
        List<TaskCancellation> cancellableTasksFromDeletedWorkloadGroups = taskCancellation.getAllCancellableTasks(
    private WorkloadGroupLevelResourceUsageView createResourceUsageViewMock(
        assertEquals(2, cancellableTasksFrom.size());
        clock.fastForwardBy(1000);
        WorkloadGroup deletedWorkloadGroup = new WorkloadGroup(
        assertEquals(2, cancellableTasksFrom.size());
    private WorkloadGroupsStateAccessor stateAccessor;
            "testWorkloadGroup",
import static org.mockito.ArgumentMatchers.any;
            resourceUsageTrackerService,
        taskCancellation.cancelTasks(() -> false, activeWorkloadGroups, deletedWorkloadGroups);
        double deletedWorkloadGroupCpuUsage = 0.11;
            List.of(deletedWorkloadGroup)
import org.opensearch.wlm.WorkloadManagementSettings;
        Double threshold = 0.1;
        WorkloadGroup activeWorkloadGroup = new WorkloadGroup(
        assertTrue(cancellableTasksFromDeletedWorkloadGroups.get(1).getTask().isCancelled());
        workloadGroupLevelViews.put(workloadGroupId1, mockView1);
            new MutableWorkloadGroupFragment(ResiliencyMode.SOFT, Map.of(resourceType, threshold)),
            stateAccessor
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
        WorkloadGroupLevelResourceUsageView mockView1 = createResourceUsageViewMock();
    public void testGetCancellableTasksFrom_doesNotReturnTasksWhenWorkloadGroupIdNotFound() {
}
            stateAccessor
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
 * The OpenSearch Contributors require contributions made to
        );
        ResourceType resourceType = ResourceType.CPU;
        assertEquals(2, cancellableTasksFrom1.size());
        );
import org.opensearch.wlm.stats.WorkloadGroupState;
 * SPDX-License-Identifier: Apache-2.0
    }
            1L
    }
    }
    public void testCancelTasks_cancelsGivenTasks_WhenNodeInDuress() {
            workloadGroupId1,
        workloadGroupLevelViews.put(workloadGroupId2, resourceUsageView2);
        activeWorkloadGroups.add(activeWorkloadGroup);
 */
        );
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
        ResourceType resourceType = ResourceType.CPU;
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
            new MaximumResourceTaskSelectionStrategy(),
            new MaximumResourceTaskSelectionStrategy(),
import org.opensearch.wlm.WorkloadGroupsStateAccessor;
        double workloadGroupMemoryUsage = 0.0;
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        Double threshold = 0.01;
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
            SearchAction.NAME,
            Collections.emptyMap(),
        );
            stateAccessor
        WorkloadGroupLevelResourceUsageView mockView = mock(WorkloadGroupLevelResourceUsageView.class);
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
    private WorkloadGroupLevelResourceUsageView createResourceUsageViewMock() {
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
        deletedWorkloadGroups.add(workloadGroup2);
        );
        assertTrue(allCancellableTasks.isEmpty());
        assertTrue(cancellableTasksFromDeletedWorkloadGroups.get(0).getTask().isCancelled());
        );
        ResourceType resourceType = ResourceType.CPU;
        workloadGroupLevelViews.put(workloadGroupId1, mockView1);
    }
import java.util.Collections;
        Double threshold = 0.9;
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
            workloadManagementSettings,
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
            ResiliencyMode.ENFORCED,
        when(workloadManagementSettings.getNodeLevelCpuCancellationThreshold()).thenReturn(0.9);
        List<WorkloadGroupTask> activeTasks = IntStream.range(0, 5).mapToObj(this::getRandomSearchTask).collect(Collectors.toList());
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
        double memoryUsage2 = 0.0;
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold, ResourceType.MEMORY, threshold)),
        clock = new TestClock();
        );
            "testWorkloadGroup",
            resourceUsageTrackerService,
        taskCancellation.cancelTasks(() -> false, activeWorkloadGroups, deletedWorkloadGroups);
            Map.of(ResourceType.CPU, activeWorkloadGroupCpuUsage, ResourceType.MEMORY, activeWorkloadGroupMemoryUsage)
        Double threshold = 0.01;
            workloadManagementSettings,
            workloadManagementSettings,
            workloadGroupId1,
        taskCancellation.pruneDeletedWorkloadGroups(deletedWorkloadGroups);
import org.opensearch.wlm.ResourceType;
            "testWorkloadGroup",
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        assertEquals(2, cancellableTasksFrom.size());
        double cpuUsage = 0.011;
            "test description",
            1L
    }
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
            resourceUsageTrackerService,
    private WorkloadGroupTask getRandomSearchTask(long id) {
            "testWorkloadGroup1",
import java.util.stream.IntStream;
        double usage,
            workloadGroupId1,
        );
import java.util.stream.Collectors;
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
    public void testGetCancellableTasksFrom_returnsTasksWhenBreachingThresholdForMemory() {
            "testWorkloadGroup",
            Map.of(ResourceType.CPU, workloadGroupCpuUsage, ResourceType.MEMORY, workloadGroupMemoryUsage)
        Double threshold = 0.01;
        activeWorkloadGroups.add(workloadGroup1);
    public void testGetCancellableTasksFrom_returnsNoTasksWhenNotBreachingThreshold() {
        when(resourceUsageTrackerService.constructWorkloadGroupLevelUsageViews()).thenReturn(workloadGroupLevelViews);
    }
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
        WorkloadGroupLevelResourceUsageView mockView2 = createResourceUsageViewMock(
        Double threshold = 0.01;
        double memoryUsage = 0.0;
        deletedWorkloadGroups.add(workloadGroup1);
            1L
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
        double activeWorkloadGroupMemoryUsage = 0.0;
        when(workloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        );
        WorkloadGroup workloadGroup2 = new WorkloadGroup(
    }
            "testWorkloadGroup",
        when(mockView.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage, resourceType, memoryUsage));
            workloadGroupId1,
        when(mockView1.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage1, ResourceType.MEMORY, memoryUsage1));
public class WorkloadGroupTaskCancellationServiceTests extends OpenSearchTestCase {
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
        Double threshold = 0.01;
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
            1L
            1L
            new MaximumResourceTaskSelectionStrategy(),
    public void testGetCancellableTasksFrom_setupAppropriateCancellationReasonAndScore() {
        when(resourceUsageTrackerService.constructWorkloadGroupLevelUsageViews()).thenReturn(workloadGroupLevelViews);
        assertTrue(cancellableTasksFrom.get(1).getTask().isCancelled());
        double memoryUsage = 0.011;
        ResourceType resourceType = ResourceType.CPU;
        );
        );
    private WorkloadManagementSettings workloadManagementSettings;
        resourceUsageTrackerService = mock(WorkloadGroupResourceUsageTrackerService.class);
            "testWorkloadGroup",
        );
            id,
            Map.of(ResourceType.CPU, activeWorkloadGroupCpuUsage, ResourceType.MEMORY, activeWorkloadGroupMemoryUsage)
            workloadGroupId2,
            1L
            "testWorkloadGroup1",
    }
import java.util.Set;
        );
    private static final String workloadGroupId2 = "workloadGroup2";
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(List.of(workloadGroup1));
    private Map<String, WorkloadGroupLevelResourceUsageView> workloadGroupLevelViews;
        assertTrue(cancellableTasksFrom1.get(0).getTask().isCancelled());
        when(workloadManagementSettings.getNodeLevelMemoryCancellationThreshold()).thenReturn(0.9);
            1L
        );
    private Set<WorkloadGroup> deletedWorkloadGroups;
    private TestClock clock;
        assertEquals(4321, allCancellableTasks.get(1).getTask().getId());
            new TaskId(randomLong() + ":" + randomLong()),
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
        when(mockView.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage, ResourceType.MEMORY, memoryUsage));
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
            1L
            new MaximumResourceTaskSelectionStrategy(),
        WorkloadGroupLevelResourceUsageView mockView1 = createResourceUsageViewMock();
        ResourceType resourceType,
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(List.of(workloadGroup2));
            resourceType,
    private Set<WorkloadGroup> activeWorkloadGroups;
        double cpuUsage = 0.81;
import org.opensearch.core.tasks.TaskId;
    }
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        assertEquals(2, cancellableTasksFrom.size());
        double cpuUsage1 = 0.11;
            new MaximumResourceTaskSelectionStrategy(),
    public void testGetAllCancellableTasks_ReturnsTasksWhenBreachingThresholds() {
            resourceUsageTrackerService,
        taskCancellation.cancelTasks(() -> true, activeWorkloadGroups, deletedWorkloadGroups);
    }
        List<TaskCancellation> allCancellableTasks = taskCancellation.getAllCancellableTasks(ResiliencyMode.ENFORCED, activeWorkloadGroups);
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
        when(mockView.getResourceUsageData()).thenReturn(Map.of(resourceType, cpuUsage, ResourceType.MEMORY, memoryUsage));
        return mockView;
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
            1L
        assertEquals(1001, cancellableTasksFromDeletedWorkloadGroups.get(1).getTask().getId());
        taskCancellation.cancelTasks(() -> true, activeWorkloadGroups, deletedWorkloadGroups);
        when(workloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
        double workloadGroupCpuUsage = 0.09;
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(
        activeWorkloadGroups.add(workloadGroup1);
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
        );
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
            workloadManagementSettings,
            1L
        );
        WorkloadGroup activeWorkloadGroup = new WorkloadGroup(
            deletedWorkloadGroupCpuUsage,
        when(mockView.getActiveTasks()).thenReturn(List.of(getRandomSearchTask(5678), getRandomSearchTask(8765)));
        );
        Collection<Integer> ids
        List<TaskCancellation> cancellableTasksFrom1 = taskCancellation.getAllCancellableTasks(ResiliencyMode.SOFT, activeWorkloadGroups);
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
            workloadGroupId2,
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
    public void testGetCancellableTasksFrom_filtersWorkloadGroupCorrectly() {
 * this file be licensed under the Apache-2.0 license or a
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        assertEquals(4321, cancellableTasksFrom.get(1).getTask().getId());
        Double threshold = 0.1;
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
            1L
    @Before
        when(mockView.getResourceUsageData()).thenReturn(Collections.singletonMap(resourceType, usage));
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(ResourceType.CPU, 0.1)),
        );
            deletedWorkloadGroupCpuUsage,
    public void testCancelTasks_cancelsTasksFromDeletedWorkloadGroups() {
            1L
        double memoryUsage1 = 0.0;
        double memoryUsage = 0.0;
        double activeWorkloadGroupCpuUsage = 0.11;
            workloadGroupId1,
            ResiliencyMode.ENFORCED,
        assertTrue(cancellableTasksFrom.get(0).getTask().isCancelled());
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        workloadManagementSettings = mock(WorkloadManagementSettings.class);
        when(resourceUsageTrackerService.constructWorkloadGroupLevelUsageViews()).thenReturn(workloadGroupLevelViews);
            workloadGroupId2,
        Double threshold = 0.1;
        when(resourceUsageView1.getActiveTasks()).thenReturn(activeTasks);
        double deletedWorkloadGroupMemoryUsage = 0.0;
/*
        assertTrue(cancellableTasksFrom.get(0).getTask().isCancelled());
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
        );
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
            "testWorkloadGroup2",
        WorkloadGroupLevelResourceUsageView resourceUsageView2 = createResourceUsageViewMock();
            "testWorkloadGroup",
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
        );
        WorkloadGroupLevelResourceUsageView mockView = mock(WorkloadGroupLevelResourceUsageView.class);
        assertEquals(2, cancellableTasksFrom.size());
            workloadGroupId1,
        assertEquals(0, cancellableTasksFrom.size());
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        ResourceType resourceType = ResourceType.CPU;
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
    public void testPruneDeletedWorkloadGroups() {
        assertEquals(1000, cancellableTasksFromDeletedWorkloadGroups.get(0).getTask().getId());
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
        assertEquals(5678, cancellableTasksFrom1.get(0).getTask().getId());
            workloadGroupId1,
            Map.of(ResourceType.CPU, deletedWorkloadGroupCpuUsage, ResourceType.MEMORY, deletedWorkloadGroupMemoryUsage)
import org.opensearch.wlm.tracker.ResourceUsageCalculatorTrackerServiceTests.TestClock;
        workloadGroupLevelViews.put(workloadGroupId2, mockView2);
        assertEquals(1, cancellableTasksFrom.get(0).getReasons().get(0).getCancellationScore());
        activeWorkloadGroups.add(workloadGroup1);
        double deletedWorkloadGroupMemoryUsage = 0.0;
        double activeWorkloadGroupCpuUsage = 0.01;
        stateAccessor = mock(WorkloadGroupsStateAccessor.class);
        assertEquals(2, cancellableTasksFromDeletedWorkloadGroups.size());
        workloadGroupLevelViews.put(workloadGroupId2, mockView);
        assertEquals(2, cancellableTasksFrom.size());
            workloadGroupId2,
        assertEquals(2, cancellableTasksFromDeletedWorkloadGroups.size());
import org.opensearch.wlm.WorkloadGroupTask;
        when(mockView.getResourceUsageData()).thenReturn(Map.of(resourceType, cpuUsage, ResourceType.MEMORY, memoryUsage));
            Map.of(ResourceType.CPU, deletedWorkloadGroupCpuUsage, ResourceType.MEMORY, deletedWorkloadGroupMemoryUsage)
    public void setup() {
            stateAccessor
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
import java.util.Collection;
        );
import org.opensearch.wlm.WorkloadGroupLevelResourceUsageView;
        double cpuUsage = 0.11;
        List<TaskCancellation> cancellableTasksFromDeletedWorkloadGroups = taskCancellation.getAllCancellableTasks(
        WorkloadGroup workloadGroup2 = new WorkloadGroup(
        assertTrue(cancellableTasksFrom.get(1).getTask().isCancelled());
    private static final String workloadGroupId1 = "workloadGroup1";
            resourceUsageTrackerService,
        when(mockView1.getResourceUsageData()).thenReturn(
        when(resourceUsageView2.getActiveTasks()).thenReturn(new ArrayList<>());
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        activeWorkloadGroups = new HashSet<>();
        ResourceType resourceType = ResourceType.CPU;
    public void testGetAllCancellableTasks_ReturnsNoTasksWhenNotBreachingThresholds() {
    public void testCancelTasks_cancelsGivenTasks() {
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
            "testWorkloadGroup",
        when(resourceUsageTrackerService.constructWorkloadGroupLevelUsageViews()).thenReturn(workloadGroupLevelViews);
        assertEquals(1000, cancellableTasksFromDeletedWorkloadGroups.get(0).getTask().getId());
        );
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
        WorkloadGroup workloadGroup2 = new WorkloadGroup(
            List.of(deletedWorkloadGroup)
            workloadGroupId1,
        ResourceType resourceType = ResourceType.CPU;
        assertFalse(cancellableTasksFromDeletedWorkloadGroups.get(1).getTask().isCancelled());
        assertTrue(cancellableTasksFrom.get(0).getTask().isCancelled());
        );
        activeWorkloadGroups.add(workloadGroup1);
            activeWorkloadGroups
            1L
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(
    }
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        double cpuUsage = 0.0;
        ResourceType resourceType = ResourceType.CPU;
        assertTrue(cancellableTasksFrom.isEmpty());
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
        assertEquals(2, allCancellableTasks.size());
        List<WorkloadGroup> deletedWorkloadGroups = new ArrayList<>();
import org.opensearch.test.OpenSearchTestCase;
        WorkloadGroupLevelResourceUsageView mockView = createResourceUsageViewMock();
            "testWorkloadGroup",
        activeWorkloadGroups.add(workloadGroup1);
        );
        );
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
            stateAccessor
        assertTrue(cancellableTasksFrom.get(0).getTask().isCancelled());
        WorkloadGroupLevelResourceUsageView mockView2 = createResourceUsageViewMock(
        List<TaskCancellation> allCancellableTasks = taskCancellation.getAllCancellableTasks(ResiliencyMode.ENFORCED, activeWorkloadGroups);
import org.opensearch.wlm.MutableWorkloadGroupFragment;
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(resourceType, threshold)),
        workloadGroupLevelViews.put(workloadGroupId1, mockView);
import java.util.HashMap;
    private WorkloadGroupResourceUsageTrackerService resourceUsageTrackerService;
        when(workloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
package org.opensearch.wlm.cancellation;
        ResourceType resourceType = ResourceType.CPU;
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(ResiliencyMode.SOFT, activeWorkloadGroups);
            ResiliencyMode.ENFORCED,
        double usage = 0.11;
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;
            workloadGroupId1,
 *
        WorkloadGroup workloadGroup1 = new WorkloadGroup(
            resourceUsageTrackerService,
        );
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(List.of(workloadGroup1));
        double memoryUsage = 0.0;
            1L
        List<TaskCancellation> cancellableTasksFrom = taskCancellation.getAllCancellableTasks(List.of(workloadGroup1));
    }
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
        workloadGroupLevelViews.put(workloadGroupId1, mockView1);
            "testWorkloadGroup",
        Collections.addAll(activeWorkloadGroups, workloadGroup1, workloadGroup2);
            resourceType,
        double deletedWorkloadGroupCpuUsage = 0.01;
            1L
        );
            1L
        WorkloadGroupTaskCancellationService taskCancellation = new WorkloadGroupTaskCancellationService(
        double memoryUsage = 0.11;
        );
        when(mockView.getActiveTasks()).thenReturn(List.of(getRandomSearchTask(1234), getRandomSearchTask(4321)));
import org.opensearch.wlm.WlmMode;
        assertEquals(8765, cancellableTasksFrom1.get(1).getTask().getId());
import java.util.HashSet;
            new MaximumResourceTaskSelectionStrategy(),
        activeWorkloadGroups.add(workloadGroup2);
        deletedWorkloadGroups = new HashSet<>();
        assertEquals(1234, allCancellableTasks.get(0).getTask().getId());
        return mockView;
        when(mockView.getResourceUsageData()).thenReturn(Map.of(ResourceType.CPU, cpuUsage2, ResourceType.MEMORY, memoryUsage2));
            "testWorkloadGroup2",
        assertEquals(1234, cancellableTasksFrom.get(0).getTask().getId());
        );
    }
import org.opensearch.action.search.SearchAction;
        taskCancellation.workloadGroupLevelResourceUsageViews = workloadGroupLevelViews;
