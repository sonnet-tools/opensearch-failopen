import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.NAME_ONE;
        WorkloadGroupPersistenceService workloadGroupPersistenceService1 = new WorkloadGroupPersistenceService(
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.NAME_NONE_EXISTED;
                new MutableWorkloadGroupFragment(
        doAnswer(invocation -> {
        );
    public void testValidMaxSandboxCountSetting() {
        assertEquals(2, updatedWorkloadGroups.size());
     * Tests the valid value of {@code node.workload_group.max_count}
        );
        assertEqualWorkloadGroups(new ArrayList<>(afterDeletionGroups.values()), oldWorkloadGroups, false);
     */
            NAME_ONE,
        Settings settings = Settings.builder().put(WORKLOAD_GROUP_COUNT_SETTING_NAME, 2).build();
            ClusterStateUpdateTask task = invocation.getArgument(1);
        WorkloadGroupPersistenceService.validateThrottlingIsEnforceable(null);
        Set<String> currentNAME = res.stream().map(WorkloadGroup::getName).collect(Collectors.toSet());
        List<WorkloadGroup> list1 = new ArrayList<>();
        oldWorkloadGroups.add(workloadGroupOne);
        workloadGroupPersistenceService.updateInClusterStateMetadata(updateWorkloadGroupRequest, listener);
            clusterSettings()
        WorkloadGroup workloadGroup = groups.get(0);
        workloadGroupPersistenceService.updateInClusterStateMetadata(updateWorkloadGroupRequest, listener);
     * Tests PersistInClusterStateMetadata function
        ClusterState newClusterState = workloadGroupPersistenceService().updateWorkloadGroupInClusterState(
            updated.getMutableWorkloadGroupFragment()
    public void testUpdateWorkloadGroupAllFields() {
        ClusterService clusterService = mock(ClusterService.class);
        ClusterState clusterState = ClusterState.builder(new ClusterName("test"))
     */
        WorkloadGroupPersistenceService workloadGroupPersistenceService1 = setup.v1();
                Settings.builder().putNull(WorkloadGroupThrottleSettings.BY.getKey()).build()
            settings,
    /**
        List<WorkloadGroup> updatedWorkloadGroups = new ArrayList<>(
        Settings settings = Settings.builder().put(WORKLOAD_GROUP_COUNT_SETTING_NAME, 100).build();
            verify(listener).onResponse(argThat(response -> response.isAcknowledged()));
            clusterSettings()
    }
                Map.of(),
            clusterSettings()
     */
            ClusterStateUpdateTask task = invocation.getArgument(1);
        WorkloadGroupPersistenceService.validateThrottlingIsEnforceable(throttling);
            RuntimeException.class,
        workloadGroupPersistenceService.setMaxWorkloadGroupCount(50);
     * Test case to ensure the error is thrown when we already have the max allowed number of WorkloadGroups, but
        ClusterStateUpdateTask capturedTask = captor.getValue();
        Tuple<WorkloadGroupPersistenceService, ClusterState> setup = preparePersistenceServiceSetup(new HashMap<>());
            .values()
        verify(listener).onFailure(any(RuntimeException.class));
     * Tests UpdateInClusterStateMetadata function
                null,
            updateWorkloadGroupRequest,
        listTwo.add(updatedGroupsMap.get(_ID_ONE));
            NAME_TWO,
    }
        WorkloadManagementTestUtils.assertEqualWorkloadGroups(WorkloadManagementTestUtils.workloadGroupList(), res, false);
import static org.mockito.Mockito.anyString;
import static org.mockito.ArgumentMatchers.eq;
        verify(clusterService, times(1)).submitStateUpdateTask(eq(SOURCE), captor.capture());
            NAME_ONE,
            ClusterStateUpdateTask task = invocation.getArgument(1);
            assertNotNull(newState);
        listOne.add(WorkloadManagementTestUtils.workloadGroupOne);
    }
     */
                Settings.EMPTY,
    /**
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupRequest;
            clusterSettings()
            clusterService,
            clusterService,
    public void testCreateWorkloadGroupOverflowCount() {
        List<WorkloadGroup> oldWorkloadGroups = new ArrayList<>();
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupTwo;
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.clusterSettingsSet;
    /**
        ArgumentCaptor<ClusterStateUpdateTask> captor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
                    Settings.EMPTY,
            updateWorkloadGroupRequest,
        ActionListener<CreateWorkloadGroupResponse> listener = mock(ActionListener.class);
        WorkloadGroupPersistenceService workloadGroupPersistenceService1 = setup.v1();
        Map<String, WorkloadGroup> updatedGroups = newClusterState.getMetadata().workloadGroups();
        assertEquals(2, updatedWorkloadGroups.size());
        );
     */
        Map<String, WorkloadGroup> updatedGroupsMap = newClusterState.getMetadata().workloadGroups();
        List<WorkloadGroup> listTwo = new ArrayList<>();
     * Tests delete a WorkloadGroup with invalid name
        WorkloadGroup updated = builder().name(NAME_ONE)
     * Test case to validate the creation logic of a WorkloadGroup
     * Tests DeleteInClusterStateMetadata function
                    Map.of(ResourceType.MEMORY, 0.3),
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils._ID_TWO;
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.preparePersistenceServiceSetup;
        WorkloadGroupPersistenceService.validateUpdateThrottlingIsEnforceable(request, clusterState);
            clusterService,
            clusterState()
        );
    public void testCreateAnotherWorkloadGroup() {
    }
            )
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.NAME_TWO;
            ClusterState initialState = clusterState();
            .build();
    public void testUpdateValidationClearingByReturnsToGroupScope() {
     * Tests UpdateInClusterStateMetadata function with inner functions
        );
        assertFalse(afterDeletionGroups.containsKey(_ID_TWO));
            () -> workloadGroupPersistenceService().deleteWorkloadGroupInClusterState(NAME_NONE_EXISTED, clusterState())
        WorkloadGroupPersistenceService workloadGroupPersistenceService = WorkloadManagementTestUtils.workloadGroupPersistenceService();
        );
        Collection<WorkloadGroup> groupsCollections = WorkloadGroupPersistenceService.getFromClusterStateMetadata(null, clusterState());
            .build();
    /**
    public void testUpdateWorkloadGroupResourceLimitsOnly() {
        );
import java.util.Set;
        Tuple<WorkloadGroupPersistenceService, ClusterState> setup = preparePersistenceServiceSetup(Map.of(_ID_ONE, workloadGroupOne));
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
        doAnswer(invocation -> {
        workloadGroupPersistenceService.updateInClusterStateMetadata(null, listener);
        );
            ._id(_ID_ONE)
            .values()
        ClusterSettings clusterSettings = new ClusterSettings(settings, clusterSettingsSet());
        ActionListener<UpdateWorkloadGroupResponse> listener = mock(ActionListener.class);
            updated.getMutableWorkloadGroupFragment()
            Exception exception = new RuntimeException("Test Exception");
    }
        expectedList.add(updated);
    public void testValidateThrottlingIgnoresAbsentAndEmptyConfig() {
import java.util.stream.Collectors;
        Collection<WorkloadGroup> groupsCollections = WorkloadGroupPersistenceService.getFromClusterStateMetadata(
            ClusterState newState = task.execute(initialState);
    }
                    ResiliencyMode.ENFORCED,
            .mutableWorkloadGroupFragment(new MutableWorkloadGroupFragment(ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.3)))
            .filter(group -> group.getName().equals(NAME_ONE))
 * this file be licensed under the Apache-2.0 license or a
        Settings.Builder builder = Settings.builder();
        );
import static org.mockito.Mockito.mock;
    /**
        );
        assertEquals(2, updatedWorkloadGroups.size());
            workloadGroupPersistenceService.getClusterService().state().metadata().workloadGroups().values()
    /**
        ClusterService clusterService = mock(ClusterService.class);
    }
import org.opensearch.core.action.ActionListener;
        UpdateWorkloadGroupRequest updateWorkloadGroupRequest = updateWorkloadGroupRequest(
        WorkloadGroup toCreate = builder().name(NAME_ONE)
            NAME_NONE_EXISTED,
            .workloadGroups()
            WorkloadManagementTestUtils.settings(),
            NAME_ONE,
        return builder.build();
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.assertEqualWorkloadGroups;
            .metadata(Metadata.builder().workloadGroups(Map.of(_ID_ONE, existingGroup)))
            )
     */
            .updatedAt(1690934400000L)
        }
    }
            task.clusterStateProcessed(SOURCE, clusterState(), clusterState());
        ActionListener<UpdateWorkloadGroupResponse> listener = mock(ActionListener.class);
        ClusterStateUpdateTask capturedTask = captor.getValue();
    }
     * an existing WorkloadGroup
        assertThrows(
 */
    /**
import static org.opensearch.plugin.wlm.action.WorkloadGroupActionTestUtils.updateWorkloadGroupRequest;
    public void testUpdateInClusterStateMetadata() {
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils._ID_ONE;
        WorkloadGroup toCreate = builder().name(NAME_ONE)
     */
        ClusterState clusterState = ClusterState.builder(new ClusterName("test"))
            .build();
        UpdateWorkloadGroupRequest updateWorkloadGroupRequest = updateWorkloadGroupRequest(
        ClusterState clusterState = setup.v2();
            clusterState()
        @SuppressWarnings("unchecked")
        ClusterService clusterService = mock(ClusterService.class);
        Optional<WorkloadGroup> findUpdatedGroupTwo = newClusterState.metadata()
     * we want to create another one
            .build();
        ClusterState newClusterState = workloadGroupPersistenceService().deleteWorkloadGroupInClusterState(NAME_TWO, clusterState());
    public void testPersistInClusterStateMetadata() {
        assertEquals(0, groups.size());
        WorkloadManagementTestUtils.assertEqualWorkloadGroups(listOne, listTwo, false);
    }
        );
        List<WorkloadGroup> res = new ArrayList<>(groupsCollections);
            () -> WorkloadManagementTestUtils.workloadGroupPersistenceService().setMaxWorkloadGroupCount(-1)
            new MutableWorkloadGroupFragment(ResiliencyMode.SOFT, new HashMap<>())
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        assertTrue(findUpdatedGroupTwo.isPresent());
        listOne.add(workloadGroupOne);
            Exception exception = new RuntimeException("Test Exception");
        Settings settings = Settings.builder().put(WORKLOAD_GROUP_COUNT_SETTING_NAME, 2).build();
import java.util.Optional;
        }).when(clusterService).submitStateUpdateTask(anyString(), any());
        verify(clusterService).submitStateUpdateTask(eq(SOURCE), any());
                    ResiliencyMode.ENFORCED,
            () -> workloadGroupPersistenceService1.saveWorkloadGroupInClusterState(toCreate, clusterState)
                new MutableWorkloadGroupFragment(
        doAnswer(invocation -> {
    public void testPersistInClusterStateMetadataInner() {
        ClusterState newClusterState = workloadGroupPersistenceService1.saveWorkloadGroupInClusterState(workloadGroupOne, clusterState);
            ._id("W5iIqHyhgi4K1qIAAAAIHw==")
import org.opensearch.wlm.MutableWorkloadGroupFragment;
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
    @SuppressWarnings("unchecked")
        );
        assertThrows(
            .updatedAt(1690934400000L)
            .findFirst();
    public void testDeleteInClusterStateMetadata() throws Exception {
        Metadata metadata = Metadata.builder().workloadGroups(Map.of(_ID_ONE, workloadGroupOne, _ID_TWO, workloadGroupTwo)).build();
    }
        doAnswer(invocation -> {
    public void testGetSingleWorkloadGroup() {
        assertTrue(updatedGroupsMap.containsKey(_ID_ONE));
        );
        ClusterService clusterService = mock(ClusterService.class);
            .updatedAt(1690934400000L)
            assertEquals(workloadGroupPersistenceService.deleteWorkloadGroupThrottlingKey, task.getClusterManagerThrottlingKey());
     */
        verify(listener).onResponse(any(UpdateWorkloadGroupResponse.class));
            ResourceNotFoundException.class,
     * Tests UpdateInClusterStateMetadata function with failure
     * Tests updating a WorkloadGroup with invalid name
            clusterSettings()
            IllegalArgumentException.class,
            return null;
        verify(clusterService).submitStateUpdateTask(eq(SOURCE), any());
            RuntimeException.class,
            clusterService,
    /**
        doAnswer(invocation -> {
            WorkloadManagementTestUtils.settings(),
import org.opensearch.cluster.service.ClusterService;
        WorkloadGroupPersistenceService workloadGroupPersistenceService1 = setup.v1();
     * Tests updating a WorkloadGroup with only updated resourceLimits
    public void testUpdateValidationUsesMergedThrottlingConfig() {
     */
        WorkloadGroup toCreate = builder().name(NAME_NONE_EXISTED)
            task.onAllNodesAcked(null);
        List<WorkloadGroup> updatedWorkloadGroups = new ArrayList<>(newClusterState.getMetadata().workloadGroups().values());
        assertEquals(1, afterDeletionGroups.size());
    }
        assertEquals(Integer.valueOf(9), WorkloadGroupThrottleSettings.NODE_LIMIT.get(effectiveThrottling));
            NAME_TWO,
        );
import org.opensearch.wlm.WorkloadGroupThrottleSettings;
            .mutableWorkloadGroupFragment(
            ._id(_ID_ONE)
            .mutableWorkloadGroupFragment(new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.15)))
            ._id("W5iIqHyhgi4K1qIAAAAIHw==")
        Collection<WorkloadGroup> groupsCollections = WorkloadGroupPersistenceService.getFromClusterStateMetadata(NAME_ONE, clusterState());
 *
import org.opensearch.common.settings.ClusterSettings;
    /**
import java.util.List;
     * Test case to validate the logic for adding a new WorkloadGroup to a cluster state that already contains
     * Tests the invalid value of {@code node.workload_group.max_count}
        assertEquals(50, workloadGroupPersistenceService.getMaxWorkloadGroupCount());
        verify(listener).onFailure(any(RuntimeException.class));
                )
        );
        }).when(clusterService).submitStateUpdateTask(anyString(), any());
import org.opensearch.cluster.ClusterState;
        ClusterService clusterService = mock(ClusterService.class);
            AckedClusterStateUpdateTask<?> task = invocation.getArgument(1);
            return null;
     * Test case to ensure the error is thrown when we try to create another WorkloadGroup that will make
    /**
    }
import static org.mockito.Mockito.doAnswer;
    private static Settings throttling(String by, Integer nodeLimit) {
public class WorkloadGroupPersistenceServiceTests extends OpenSearchTestCase {
            ClusterStateUpdateTask task = invocation.getArgument(1);
     */
        assertEquals(2, updatedGroups.size());
import java.util.ArrayList;
            .findFirst();
        ClusterState newClusterState = workloadGroupPersistenceService().updateWorkloadGroupInClusterState(
        assertTrue(currentNAME.contains(WorkloadManagementTestUtils.NAME_TWO));
}
        ClusterState clusterState = setup.v2();
        Settings effectiveThrottling = WorkloadGroupPersistenceService.getEffectiveThrottling(request, clusterState);
        ClusterService clusterService = mock(ClusterService.class);
            return null;
    /**
import org.opensearch.ResourceNotFoundException;
                    throttling("username", 5)
     * Tests PersistInClusterStateMetadata function with inner functions
    public void testUpdateInClusterStateMetadataFailure() {
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupPersistenceService;
            ._id("W5iIqHyhgi4K1qIAAAAIHw==")
        ClusterState clusterState = setup.v2();
        );
            .mutableWorkloadGroupFragment(new MutableWorkloadGroupFragment(ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.5)))
     */
        ClusterService clusterService = new ClusterService(settings, clusterSettings(), mock(ThreadPool.class));
        workloadGroupPersistenceService.persistInClusterStateMetadata(workloadGroupOne, listener);
        workloadGroupPersistenceService.persistInClusterStateMetadata(workloadGroupOne, listener);
        workloadGroupPersistenceService.persistInClusterStateMetadata(workloadGroupOne, listener);
    /**
        );
        assertEquals(workloadGroupPersistenceService.updateWorkloadGroupThrottlingKey, capturedTask.getClusterManagerThrottlingKey());
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
            ._id(_ID_ONE)
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
            .build();
     */
     */
        WorkloadGroup updated = builder().name(NAME_ONE)
        verify(clusterService, times(1)).submitStateUpdateTask(eq(SOURCE), captor.capture());
        WorkloadGroup existingGroup = builder().name(NAME_ONE)
        );
import static org.mockito.Mockito.argThat;
        }).when(clusterService).submitStateUpdateTask(anyString(), any());
 * compatible open source license.
        Collection<WorkloadGroup> values = updatedGroups.values();
import org.opensearch.test.OpenSearchTestCase;
        workloadGroupPersistenceService.deleteInClusterStateMetadata(request, listener);
    }
     */
        ClusterSettings clusterSettings = new ClusterSettings(settings, clusterSettingsSet());
        workloadGroupPersistenceService.updateInClusterStateMetadata(updateWorkloadGroupRequest, listener);
        @SuppressWarnings("unchecked")
 * SPDX-License-Identifier: Apache-2.0
            clusterService,
            () -> workloadGroupPersistenceService1.saveWorkloadGroupInClusterState(toCreate, clusterState)
        WorkloadGroupPersistenceService.validateThrottlingIsEnforceable(throttling(null, 9));
        );
     * Tests getting a single WorkloadGroup
            .workloadGroups()
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupRequest;
            clusterService,
        assertEquals(2, WorkloadManagementTestUtils.clusterState().metadata().workloadGroups().size());
    public void testUpdateWorkloadGroupNonExistedName() {
 * The OpenSearch Contributors require contributions made to
            WorkloadManagementTestUtils.settings(),
        ClusterService clusterService = new ClusterService(settings, clusterSettings, mock(ThreadPool.class));
            builder.put("node_limit", nodeLimit);
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupResponse;
    }
    /**
            .updatedAt(1690934400000L)
import org.opensearch.common.collect.Tuple;
        list1.add(updated);
import java.util.HashMap;
        listTwo.add(workloadGroup);
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
        ClusterService clusterService = new ClusterService(settings, clusterSettings, mock(ThreadPool.class));
import org.opensearch.common.settings.Settings;
        }).when(clusterService).submitStateUpdateTask(anyString(), any());
import java.util.Map;
     */
    }
    public void testUpdateInClusterStateMetadataInner() {
            () -> workloadGroupPersistenceService.updateWorkloadGroupInClusterState(updateWorkloadGroupRequest, clusterState())
        @SuppressWarnings("unchecked")
        ClusterState clusterState = setup.v2();
            .mutableWorkloadGroupFragment(new MutableWorkloadGroupFragment(ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.41)))
            .updatedAt(1690934400000L)
            clusterSettings()
        assertTrue(findUpdatedGroupOne.isPresent());
        assertEqualWorkloadGroups(listOne, listTwo, false);
     */
        expectedList.add(workloadGroupOne);
     * Test case to ensure the error is thrown when we try to create another WorkloadGroup with duplicate name
    }
        UpdateWorkloadGroupRequest updateWorkloadGroupRequest = updateWorkloadGroupRequest(
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(NAME_ONE);
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.clusterSettings;
        assertEqualWorkloadGroups(workloadGroupList(), new ArrayList<>(values), false);
            clusterService,
        );
        if (nodeLimit != null) {
        ClusterService clusterService = mock(ClusterService.class);
            RuntimeException.class,
package org.opensearch.plugin.wlm.service;
            new MutableWorkloadGroupFragment(null, Map.of(), Settings.EMPTY, throttling(null, 9))
     */
    }
     */
            settings,
        Tuple<WorkloadGroupPersistenceService, ClusterState> setup = preparePersistenceServiceSetup(Map.of(_ID_ONE, workloadGroupOne));
            task.onFailure(SOURCE, exception);
                    Map.of(ResourceType.MEMORY, 0.3),
import org.opensearch.cluster.ClusterName;
import org.opensearch.cluster.metadata.WorkloadGroup;
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
            return null;
            clusterSettings
import java.util.Collection;
            WorkloadManagementTestUtils.settings(),
            WorkloadManagementTestUtils.settings(),
        assertEqualWorkloadGroups(expectedList, updatedWorkloadGroups, true);
    /**
        Settings throttling = Settings.builder().putNull("by").put("node_limit", 9).build();
        ArgumentCaptor<ClusterStateUpdateTask> captor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
import static org.mockito.ArgumentMatchers.any;
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
        Map<String, WorkloadGroup> afterDeletionGroups = newClusterState.getMetadata().workloadGroups();
    /**
        assertFalse(effectiveThrottling.keySet().contains(WorkloadGroupThrottleSettings.BY.getKey()));
            () -> workloadGroupPersistenceService1.saveWorkloadGroupInClusterState(toCreate, clusterState)
    /**
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.clusterState;
            .build();
        );
        expectedList.add(workloadGroupTwo);
import org.opensearch.cluster.ClusterStateUpdateTask;
        @SuppressWarnings("unchecked")
        );
    /**
        WorkloadGroup existingGroup = builder().name(NAME_ONE)
        List<WorkloadGroup> listOne = new ArrayList<>();
        assertEquals(workloadGroupPersistenceService.createWorkloadGroupThrottlingKey, capturedTask.getClusterManagerThrottlingKey());
     */
        expectedList.add(workloadGroupTwo);
    }
        assertTrue(currentNAME.contains(WorkloadManagementTestUtils.NAME_ONE));
    /**
        ActionListener<CreateWorkloadGroupResponse> listener = mock(ActionListener.class);
            .build();
        List<WorkloadGroup> expectedList = new ArrayList<>();
    }
        ActionListener<CreateWorkloadGroupResponse> listener = mock(ActionListener.class);
    /**
        ClusterState newClusterState = workloadGroupPersistenceService1.saveWorkloadGroupInClusterState(workloadGroupTwo, clusterState);
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupResponse;
    public void testCreateWorkloadGroupDuplicateName() {
        List<WorkloadGroup> list2 = new ArrayList<>();
            .build();
    public void testCreateWorkloadGroupOverflowAllocation() {
    /**
        UpdateWorkloadGroupRequest request = updateWorkloadGroupRequest(
        UpdateWorkloadGroupRequest updateWorkloadGroupRequest = updateWorkloadGroupRequest(
    public void testGetNonExistedWorkloadGroups() {
        Settings effectiveThrottling = WorkloadGroupPersistenceService.getEffectiveThrottling(request, clusterState);
    /**
            builder.put("by", by);
            new MutableWorkloadGroupFragment(ResiliencyMode.SOFT, new HashMap<>())
        assertEquals(Integer.valueOf(5), WorkloadGroupThrottleSettings.NODE_LIMIT.get(effectiveThrottling));
            new MutableWorkloadGroupFragment(ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.15))
        List<WorkloadGroup> listTwo = new ArrayList<>();
        assertEquals(1, updatedGroupsMap.size());
        WorkloadGroupPersistenceService.validateThrottlingIsEnforceable(Settings.EMPTY);
            settings,
     * Tests updating a WorkloadGroup with all fields
     */
        assertThrows(
        );
import org.opensearch.cluster.AckedClusterStateUpdateTask;
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;
        assertThrows(IllegalArgumentException.class, () -> workloadGroupPersistenceService.setMaxWorkloadGroupCount(-1));
            clusterService,
        list2.add(findUpdatedGroupOne.get());
        UpdateWorkloadGroupRequest updateWorkloadGroupRequest = updateWorkloadGroupRequest(
    }
        @SuppressWarnings("unchecked")
            .stream()
            clusterSettings()
                    throttling("username", 5)
        @SuppressWarnings("unchecked")
            .build();
            WorkloadManagementTestUtils.settings(),
import org.opensearch.threadpool.ThreadPool;
import static org.opensearch.cluster.metadata.WorkloadGroup.builder;
        );
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        if (by != null) {
                )
            .mutableWorkloadGroupFragment(new MutableWorkloadGroupFragment(ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.15)))
            new MutableWorkloadGroupFragment(
            .filter(group -> group.getName().equals(NAME_TWO))
    public void testValidateThrottlingTreatsMissingByAsGroupScope() {
import org.mockito.ArgumentCaptor;
            .updatedAt(1690934400000L)
/*
            .mutableWorkloadGroupFragment(
     */
    public void testGetAllWorkloadGroups() {
    public void testInvalidMaxWorkloadGroupCount() {
    public void testPersistInClusterStateMetadataFailure() {
        assertThrows(
    }
            .metadata(Metadata.builder().workloadGroups(Map.of(_ID_ONE, existingGroup)))
     * Tests PersistInClusterStateMetadata function with failure
    public void testDeleteNonExistedWorkloadGroup() {
        Tuple<WorkloadGroupPersistenceService, ClusterState> setup = preparePersistenceServiceSetup(Map.of(_ID_TWO, workloadGroupTwo));
            clusterService,
            RuntimeException.class,
        assertEquals(2, res.size());
    public void testCreateWorkloadGroup() {
        );
     * Tests getting a WorkloadGroup with invalid name
        WorkloadGroupPersistenceService workloadGroupPersistenceService = workloadGroupPersistenceService();
            return null;
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
        }).when(clusterService).submitStateUpdateTask(anyString(), any());
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
        assertTrue(updatedGroups.containsKey(_ID_TWO));
        List<WorkloadGroup> listOne = new ArrayList<>();
        assertEquals(1, groups.size());
        assertEquals(WorkloadGroupThrottleSettings.GROUP_SCOPE, WorkloadGroupThrottleSettings.getEffectiveBy(effectiveThrottling));
            NAME_NONE_EXISTED,
        );
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupList;
import static org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService.WORKLOAD_GROUP_COUNT_SETTING_NAME;
     */
     * Tests setting maxWorkloadGroupCount
                    Settings.EMPTY,
     * the total resource limits go above 1
            ._id(_ID_ONE)
        );
    }
        verify(clusterService).submitStateUpdateTask(eq(SOURCE), any(AckedClusterStateUpdateTask.class));
import static org.mockito.Mockito.verify;
    public void testValidateThrottlingTreatsNullByAsGroupScope() {
    public void testMaxWorkloadGroupCount() {
     */
        workloadGroupPersistenceService.setMaxWorkloadGroupCount(50);
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
        assertThrows(
        List<WorkloadGroup> groups = new ArrayList<>(groupsCollections);
            clusterSettings
    }
    }
import org.opensearch.cluster.metadata.Metadata;
            .updatedAt(1690934400000L)
        }
            task.clusterStateProcessed(SOURCE, mock(ClusterState.class), mock(ClusterState.class));
        UpdateWorkloadGroupRequest request = updateWorkloadGroupRequest(
        assertEqualWorkloadGroups(list1, list2, true);
        Optional<WorkloadGroup> findUpdatedGroupOne = newClusterState.metadata()
            clusterSettings()
        WorkloadGroupPersistenceService workloadGroupPersistenceService1 = setup.v1();
            clusterService,
    /**
    public void testDeleteSingleWorkloadGroup() {
        workloadGroupPersistenceService.persistInClusterStateMetadata(workloadGroupOne, listener);
            WorkloadManagementTestUtils.settings(),
            )
            task.onFailure(SOURCE, exception);
            .stream()
import org.opensearch.wlm.ResourceType;
import static org.mockito.Mockito.times;
     * Tests getting all WorkloadGroups
            NAME_ONE,
    }
    }
        List<WorkloadGroup> expectedList = new ArrayList<>();
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(effectiveThrottling));
        ActionListener<UpdateWorkloadGroupResponse> listener = mock(ActionListener.class);
     * Tests delete a single WorkloadGroup
import org.opensearch.plugin.wlm.WorkloadManagementTestUtils;
        assertEqualWorkloadGroups(expectedList, updatedWorkloadGroups, true);
    }
import static org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService.SOURCE;
    /**
        assertEquals(50, workloadGroupPersistenceService.getMaxWorkloadGroupCount());
        verify(listener).onResponse(any(CreateWorkloadGroupResponse.class));
            clusterState()
        List<WorkloadGroup> groups = new ArrayList<>(groupsCollections);
        List<WorkloadGroup> updatedWorkloadGroups = new ArrayList<>(newClusterState.getMetadata().workloadGroups().values());
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupOne;
    }
        assertThrows(
