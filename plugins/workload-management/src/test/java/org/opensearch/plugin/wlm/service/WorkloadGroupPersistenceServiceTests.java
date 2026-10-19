 *
        assertEquals(1, afterDeletionGroups.size());
        );
        List<WorkloadGroup> updatedWorkloadGroups = new ArrayList<>(newClusterState.getMetadata().workloadGroups().values());  
        oldWorkloadGroups.add(workloadGroupOne);
        workloadGroupPersistenceService.updateInClusterStateMetadata(updateWorkloadGroupRequest, listener);
            clusterService,  
                new MutableWorkloadGroupFragment(  
import org.opensearch.common.settings.Settings;  
        workloadGroupPersistenceService.updateInClusterStateMetadata(updateWorkloadGroupRequest, listener);  
     * the total resource limits go above 1  
import static org.mockito.Mockito.anyString;  
        workloadGroupPersistenceService.persistInClusterStateMetadata(workloadGroupOne, listener);  
        ClusterService clusterService = mock(ClusterService.class);  
            return null;
        Collection<WorkloadGroup> groupsCollections = WorkloadGroupPersistenceService.getFromClusterStateMetadata(null, clusterState());  
        ActionListener<UpdateWorkloadGroupResponse> listener = mock(ActionListener.class);
        verify(listener).onFailure(any(RuntimeException.class));  
        WorkloadManagementTestUtils.assertEqualWorkloadGroups(WorkloadManagementTestUtils.workloadGroupList(), res, false);  
            assertNotNull(newState);  
        verify(listener).onResponse(any(UpdateWorkloadGroupResponse.class));
        ClusterState newClusterState = workloadGroupPersistenceService1.saveWorkloadGroupInClusterState(workloadGroupTwo, clusterState);
import org.mockito.ArgumentCaptor;
    /**
import org.opensearch.cluster.metadata.Metadata;
        );  
        assertEqualWorkloadGroups(expectedList, updatedWorkloadGroups, true);
            .findFirst();
import static org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService.SOURCE;
        Settings settings = Settings.builder().put(WORKLOAD_GROUP_COUNT_SETTING_NAME, 2).build();
            clusterSettings()
            clusterService,
        assertThrows(
            .stream()  
        ClusterState clusterState = setup.v2();  
    public void testPersistInClusterStateMetadataInner() {  
    /**
            new MutableWorkloadGroupFragment(ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.15))
        Settings.Builder builder = Settings.builder();
        );  
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.clusterSettings;
            .build();
import static org.mockito.Mockito.argThat;
            RuntimeException.class,  
        );  
            task.clusterStateProcessed(SOURCE, mock(ClusterState.class), mock(ClusterState.class));
        assertThrows(IllegalArgumentException.class, () -> workloadGroupPersistenceService.setMaxWorkloadGroupCount(-1));
import java.util.ArrayList;
            )  
        );  
        );
    /**
        assertEqualWorkloadGroups(workloadGroupList(), new ArrayList<>(values), false);
        ActionListener<UpdateWorkloadGroupResponse> listener = mock(ActionListener.class);  
            .build();
    @SuppressWarnings("unchecked")  
        verify(listener).onFailure(any(RuntimeException.class));
            task.onFailure(SOURCE, exception);
            new MutableWorkloadGroupFragment(ResiliencyMode.SOFT, new HashMap<>())  
import org.opensearch.cluster.ClusterName;
            .values()
        @SuppressWarnings("unchecked")
        @SuppressWarnings("unchecked")
    }
            WorkloadManagementTestUtils.settings(),  
        WorkloadGroupPersistenceService workloadGroupPersistenceService1 = new WorkloadGroupPersistenceService(  
        );  
            .filter(group -> group.getName().equals(NAME_TWO))
    }
import static org.opensearch.plugin.wlm.action.WorkloadGroupActionTestUtils.updateWorkloadGroupRequest;
        );
import static org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService.WORKLOAD_GROUP_COUNT_SETTING_NAME;  
    public void testDeleteInClusterStateMetadata() throws Exception {
import static org.mockito.ArgumentMatchers.any;
        );
import java.util.Set;
    public void testCreateWorkloadGroupDuplicateName() {
    /**
            () -> workloadGroupPersistenceService().deleteWorkloadGroupInClusterState(NAME_NONE_EXISTED, clusterState())
            IllegalArgumentException.class,
            .findFirst();
    public void testMaxWorkloadGroupCount() {  
        @SuppressWarnings("unchecked")
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils._ID_TWO;  
     */
        doAnswer(invocation -> {
    }  
     */  
        ClusterService clusterService = mock(ClusterService.class);  
        @SuppressWarnings("unchecked")
        WorkloadGroup toCreate = builder().name(NAME_ONE)
import org.opensearch.threadpool.ThreadPool;
    }
        WorkloadGroupPersistenceService workloadGroupPersistenceService1 = setup.v1();  
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupTwo;  
        WorkloadGroup workloadGroup = groups.get(0);
     * Tests updating a WorkloadGroup with only updated resourceLimits  
                )
        List<WorkloadGroup> listTwo = new ArrayList<>();
     */
        Tuple<WorkloadGroupPersistenceService, ClusterState> setup = preparePersistenceServiceSetup(Map.of(_ID_TWO, workloadGroupTwo));  
     * Test case to validate the logic for adding a new WorkloadGroup to a cluster state that already contains
            clusterService,
            () -> workloadGroupPersistenceService1.saveWorkloadGroupInClusterState(toCreate, clusterState)  
        ActionListener<CreateWorkloadGroupResponse> listener = mock(ActionListener.class);  
        list2.add(findUpdatedGroupOne.get());
            ClusterStateUpdateTask task = invocation.getArgument(1);
    }  
        );
        UpdateWorkloadGroupRequest updateWorkloadGroupRequest = updateWorkloadGroupRequest(  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test"))  
import org.opensearch.wlm.MutableWorkloadGroupFragment;  
import org.opensearch.wlm.ResourceType;
        );
        verify(clusterService, times(1)).submitStateUpdateTask(eq(SOURCE), captor.capture());
        Settings throttling = Settings.builder().putNull("by").put("node_limit", 9).build();  
        ClusterService clusterService = mock(ClusterService.class);
        Metadata metadata = Metadata.builder().workloadGroups(Map.of(_ID_ONE, workloadGroupOne, _ID_TWO, workloadGroupTwo)).build();
        List<WorkloadGroup> expectedList = new ArrayList<>();
        List<WorkloadGroup> listTwo = new ArrayList<>();  
        List<WorkloadGroup> groups = new ArrayList<>(groupsCollections);  
 */  
        );
        listTwo.add(updatedGroupsMap.get(_ID_ONE));
                    ResiliencyMode.ENFORCED,
        }).when(clusterService).submitStateUpdateTask(anyString(), any());
    }
            workloadGroupPersistenceService.getClusterService().state().metadata().workloadGroups().values()
package org.opensearch.plugin.wlm.service;
import org.opensearch.cluster.service.ClusterService;  
            ClusterStateUpdateTask task = invocation.getArgument(1);  
    /**
        WorkloadGroupPersistenceService workloadGroupPersistenceService = WorkloadManagementTestUtils.workloadGroupPersistenceService();
import org.opensearch.cluster.AckedClusterStateUpdateTask;  
            clusterService,
import java.util.Collection;  
        assertTrue(currentNAME.contains(WorkloadManagementTestUtils.NAME_TWO));
import java.util.Map;  
        if (by != null) {
        ClusterService clusterService = mock(ClusterService.class);  
        assertFalse(effectiveThrottling.keySet().contains(WorkloadGroupThrottleSettings.BY.getKey()));  
                null,  
            NAME_TWO,
        Tuple<WorkloadGroupPersistenceService, ClusterState> setup = preparePersistenceServiceSetup(Map.of(_ID_ONE, workloadGroupOne));
        List<WorkloadGroup> list1 = new ArrayList<>();
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.clusterSettingsSet;  
        Optional<WorkloadGroup> findUpdatedGroupOne = newClusterState.metadata()  
            task.clusterStateProcessed(SOURCE, clusterState(), clusterState());  
    /**  
     */
            NAME_NONE_EXISTED,  
        workloadGroupPersistenceService.updateInClusterStateMetadata(updateWorkloadGroupRequest, listener);
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
        workloadGroupPersistenceService.setMaxWorkloadGroupCount(50);  
import org.opensearch.cluster.ClusterStateUpdateTask;  
     */
        WorkloadGroupPersistenceService.validateThrottlingIsEnforceable(throttling(null, 9));
            ClusterStateUpdateTask task = invocation.getArgument(1);
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.preparePersistenceServiceSetup;
            WorkloadManagementTestUtils.settings(),
        doAnswer(invocation -> {  
import java.util.stream.Collectors;  
    }  
        List<WorkloadGroup> updatedWorkloadGroups = new ArrayList<>(
        );
            .mutableWorkloadGroupFragment(new MutableWorkloadGroupFragment(ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.3)))
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
     */
    public void testDeleteNonExistedWorkloadGroup() {
        Map<String, WorkloadGroup> afterDeletionGroups = newClusterState.getMetadata().workloadGroups();  
    /**
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
        WorkloadGroupPersistenceService workloadGroupPersistenceService1 = setup.v1();  
 * compatible open source license.
     */  
import java.util.HashMap;
    public void testDeleteSingleWorkloadGroup() {
            () -> workloadGroupPersistenceService1.saveWorkloadGroupInClusterState(toCreate, clusterState)
            builder.put("by", by);  
     * Tests getting a WorkloadGroup with invalid name
            () -> workloadGroupPersistenceService1.saveWorkloadGroupInClusterState(toCreate, clusterState)
            .mutableWorkloadGroupFragment(new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.15)))
     */
        ClusterState newClusterState = workloadGroupPersistenceService().deleteWorkloadGroupInClusterState(NAME_TWO, clusterState());
            builder.put("node_limit", nodeLimit);  
                    throttling("username", 5)
            return null;  
    /**  
                    ResiliencyMode.ENFORCED,
        );
    public void testGetSingleWorkloadGroup() {
        if (nodeLimit != null) {
        WorkloadGroupPersistenceService.validateThrottlingIsEnforceable(Settings.EMPTY);
import org.opensearch.core.action.ActionListener;
                    throttling("username", 5)
        ClusterState newClusterState = workloadGroupPersistenceService().updateWorkloadGroupInClusterState(
            .values()
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(NAME_ONE);
        assertEquals(WorkloadGroupThrottleSettings.GROUP_SCOPE, WorkloadGroupThrottleSettings.getEffectiveBy(effectiveThrottling));
        assertTrue(currentNAME.contains(WorkloadManagementTestUtils.NAME_ONE));
    /**  
        UpdateWorkloadGroupRequest request = updateWorkloadGroupRequest(  
    }  
    }
            ClusterState newState = task.execute(initialState);
    public void testUpdateWorkloadGroupAllFields() {
        workloadGroupPersistenceService.updateInClusterStateMetadata(null, listener);
            WorkloadManagementTestUtils.settings(),
        Collection<WorkloadGroup> values = updatedGroups.values();  
            .updatedAt(1690934400000L)  
        WorkloadManagementTestUtils.assertEqualWorkloadGroups(listOne, listTwo, false);
        assertEquals(Integer.valueOf(5), WorkloadGroupThrottleSettings.NODE_LIMIT.get(effectiveThrottling));
     */  
 * this file be licensed under the Apache-2.0 license or a
        ClusterState newClusterState = workloadGroupPersistenceService().updateWorkloadGroupInClusterState(  
        workloadGroupPersistenceService.setMaxWorkloadGroupCount(50);
    /**  
    }
        workloadGroupPersistenceService.persistInClusterStateMetadata(workloadGroupOne, listener);
     * Test case to ensure the error is thrown when we try to create another WorkloadGroup that will make
        assertFalse(afterDeletionGroups.containsKey(_ID_TWO));
                    Settings.EMPTY,  
    }  
            ._id("W5iIqHyhgi4K1qIAAAAIHw==")
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
     * Tests getting all WorkloadGroups
    public void testUpdateWorkloadGroupNonExistedName() {  
        ClusterService clusterService = mock(ClusterService.class);
        ClusterState newClusterState = workloadGroupPersistenceService1.saveWorkloadGroupInClusterState(workloadGroupOne, clusterState);
            new MutableWorkloadGroupFragment(null, Map.of(), Settings.EMPTY, throttling(null, 9))
        assertThrows(
    }
        WorkloadGroupPersistenceService.validateUpdateThrottlingIsEnforceable(request, clusterState);  
import org.opensearch.ResourceNotFoundException;
            WorkloadManagementTestUtils.settings(),
            updated.getMutableWorkloadGroupFragment()
import org.opensearch.common.collect.Tuple;
     */
        }
            .build();  
            task.onAllNodesAcked(null);
     */
            RuntimeException.class,
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            WorkloadManagementTestUtils.settings(),  
            .metadata(Metadata.builder().workloadGroups(Map.of(_ID_ONE, existingGroup)))
     * Tests the invalid value of {@code node.workload_group.max_count}  
        @SuppressWarnings("unchecked")
        verify(clusterService, times(1)).submitStateUpdateTask(eq(SOURCE), captor.capture());  
    public void testCreateWorkloadGroupOverflowCount() {
            clusterSettings()
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.NAME_TWO;
        assertEquals(workloadGroupPersistenceService.updateWorkloadGroupThrottlingKey, capturedTask.getClusterManagerThrottlingKey());
        ActionListener<CreateWorkloadGroupResponse> listener = mock(ActionListener.class);
        WorkloadGroupPersistenceService workloadGroupPersistenceService1 = setup.v1();
     * Tests PersistInClusterStateMetadata function with failure
    }
        );
        ClusterStateUpdateTask capturedTask = captor.getValue();
        doAnswer(invocation -> {
        assertTrue(findUpdatedGroupTwo.isPresent());
            clusterState()
        List<WorkloadGroup> expectedList = new ArrayList<>();
    public void testCreateWorkloadGroupOverflowAllocation() {
     */
            () -> workloadGroupPersistenceService.updateWorkloadGroupInClusterState(updateWorkloadGroupRequest, clusterState())
            .workloadGroups()
        WorkloadGroupPersistenceService workloadGroupPersistenceService = workloadGroupPersistenceService();
        listTwo.add(workloadGroup);  
            WorkloadManagementTestUtils.settings(),
            NAME_ONE,
            clusterService,
    public void testUpdateInClusterStateMetadata() {
            WorkloadManagementTestUtils.settings(),  
    }
        expectedList.add(workloadGroupOne);
    }  
        ClusterState clusterState = setup.v2();
    }
        assertTrue(findUpdatedGroupOne.isPresent());  
    /**
        Settings settings = Settings.builder().put(WORKLOAD_GROUP_COUNT_SETTING_NAME, 100).build();  
            .updatedAt(1690934400000L)
            updateWorkloadGroupRequest,  
     * Tests DeleteInClusterStateMetadata function
        list1.add(updated);  
        );
            clusterService,  
    }  
     * Tests PersistInClusterStateMetadata function  
    /**  
        ClusterSettings clusterSettings = new ClusterSettings(settings, clusterSettingsSet());  
            RuntimeException.class,
            .mutableWorkloadGroupFragment(new MutableWorkloadGroupFragment(ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.5)))
            clusterSettings()
        UpdateWorkloadGroupRequest updateWorkloadGroupRequest = updateWorkloadGroupRequest(
        );
public class WorkloadGroupPersistenceServiceTests extends OpenSearchTestCase {
     * Test case to validate the creation logic of a WorkloadGroup
        assertEquals(2, updatedWorkloadGroups.size());
     */  
        ClusterState clusterState = setup.v2();
        WorkloadGroup updated = builder().name(NAME_ONE)  
    public void testPersistInClusterStateMetadata() {
     */
        List<WorkloadGroup> updatedWorkloadGroups = new ArrayList<>(newClusterState.getMetadata().workloadGroups().values());
            clusterService,
            .mutableWorkloadGroupFragment(
                )
            )
     * Tests updating a WorkloadGroup with all fields
        }
        assertEquals(2, updatedGroups.size());
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupResponse;  
        Map<String, WorkloadGroup> updatedGroups = newClusterState.getMetadata().workloadGroups();  
            ._id(_ID_ONE)
            .updatedAt(1690934400000L)
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;
     */
     */
            settings,
        UpdateWorkloadGroupRequest request = updateWorkloadGroupRequest(  
        ClusterService clusterService = new ClusterService(settings, clusterSettings, mock(ThreadPool.class));
                    Map.of(ResourceType.MEMORY, 0.3),
    }
        assertEquals(50, workloadGroupPersistenceService.getMaxWorkloadGroupCount());
            NAME_ONE,
     * Tests UpdateInClusterStateMetadata function with inner functions
        workloadGroupPersistenceService.deleteInClusterStateMetadata(request, listener);  
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupResponse;  
import static org.opensearch.cluster.metadata.WorkloadGroup.builder;
     */
        }).when(clusterService).submitStateUpdateTask(anyString(), any());
        Map<String, WorkloadGroup> updatedGroupsMap = newClusterState.getMetadata().workloadGroups();
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.NAME_ONE;  
            .build();
    }
        List<WorkloadGroup> groups = new ArrayList<>(groupsCollections);
            return null;
        );
 * The OpenSearch Contributors require contributions made to  
        Settings effectiveThrottling = WorkloadGroupPersistenceService.getEffectiveThrottling(request, clusterState);
            clusterSettings()  
        ArgumentCaptor<ClusterStateUpdateTask> captor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        Settings settings = Settings.builder().put(WORKLOAD_GROUP_COUNT_SETTING_NAME, 2).build();  
            ._id("W5iIqHyhgi4K1qIAAAAIHw==")  
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupPersistenceService;
        assertTrue(updatedGroupsMap.containsKey(_ID_ONE));
            .updatedAt(1690934400000L)
        assertEquals(workloadGroupPersistenceService.createWorkloadGroupThrottlingKey, capturedTask.getClusterManagerThrottlingKey());
import static org.mockito.ArgumentMatchers.eq;
    public void testUpdateValidationUsesMergedThrottlingConfig() {
        doAnswer(invocation -> {
        ClusterService clusterService = mock(ClusterService.class);
        ClusterState clusterState = ClusterState.builder(new ClusterName("test"))  
import org.opensearch.cluster.metadata.WorkloadGroup;
            RuntimeException.class,
    public void testValidateThrottlingIgnoresAbsentAndEmptyConfig() {
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupRequest;
    /**  
            return null;
            .build();
     */
import static org.mockito.Mockito.mock;  
        assertEquals(2, updatedWorkloadGroups.size());
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(  
     */  
        expectedList.add(workloadGroupTwo);  
     * Tests updating a WorkloadGroup with invalid name
        WorkloadGroup existingGroup = builder().name(NAME_ONE)  
import org.opensearch.test.OpenSearchTestCase;
            clusterState()
    public void testUpdateInClusterStateMetadataInner() {  
            ._id(_ID_ONE)
        );
        WorkloadGroup updated = builder().name(NAME_ONE)
                Settings.builder().putNull(WorkloadGroupThrottleSettings.BY.getKey()).build()  
        ArgumentCaptor<ClusterStateUpdateTask> captor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);  
        assertEquals(0, groups.size());  
import static org.mockito.Mockito.verify;
            AckedClusterStateUpdateTask<?> task = invocation.getArgument(1);  
            settings,
     * we want to create another one
        doAnswer(invocation -> {  
     * Tests getting a single WorkloadGroup
import org.opensearch.wlm.WorkloadGroupThrottleSettings;  
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils._ID_ONE;
        assertTrue(updatedGroups.containsKey(_ID_TWO));
        Tuple<WorkloadGroupPersistenceService, ClusterState> setup = preparePersistenceServiceSetup(Map.of(_ID_ONE, workloadGroupOne));
    public void testUpdateValidationClearingByReturnsToGroupScope() {
    /**
            clusterSettings  
    /**
        ClusterService clusterService = mock(ClusterService.class);
        assertEquals(2, WorkloadManagementTestUtils.clusterState().metadata().workloadGroups().size());
            .workloadGroups()
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.assertEqualWorkloadGroups;
                new MutableWorkloadGroupFragment(  
    private static Settings throttling(String by, Integer nodeLimit) {  
    public void testCreateAnotherWorkloadGroup() {
     */
            clusterService,
    public void testUpdateInClusterStateMetadataFailure() {
        assertEquals(2, res.size());
     * an existing WorkloadGroup
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(  
            updated.getMutableWorkloadGroupFragment()  
        List<WorkloadGroup> listOne = new ArrayList<>();  
            verify(listener).onResponse(argThat(response -> response.isAcknowledged()));  
        verify(clusterService).submitStateUpdateTask(eq(SOURCE), any());  
        assertThrows(  
import java.util.Optional;
        @SuppressWarnings("unchecked")  
        );  
import static org.mockito.Mockito.times;
            return null;  
     * Tests PersistInClusterStateMetadata function with inner functions
    /**
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupOne;
        assertEquals(2, updatedWorkloadGroups.size());
        ActionListener<CreateWorkloadGroupResponse> listener = mock(ActionListener.class);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.ClusterState;
     * Test case to ensure the error is thrown when we try to create another WorkloadGroup with duplicate name
        return builder.build();
        WorkloadGroup toCreate = builder().name(NAME_ONE)
            clusterSettings()  
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(effectiveThrottling));
            clusterService,
            task.onFailure(SOURCE, exception);  
    }  
            clusterSettings  
        );  
        );  
            .mutableWorkloadGroupFragment(new MutableWorkloadGroupFragment(ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.41)))  
        listOne.add(workloadGroupOne);
            ._id(_ID_ONE)
        ClusterState clusterState = setup.v2();
     */  
    public void testGetAllWorkloadGroups() {
        Collection<WorkloadGroup> groupsCollections = WorkloadGroupPersistenceService.getFromClusterStateMetadata(NAME_ONE, clusterState());
    /**  
            .build();
}
        ClusterService clusterService = new ClusterService(settings, clusterSettings, mock(ThreadPool.class));
        List<WorkloadGroup> listOne = new ArrayList<>();
     * Tests UpdateInClusterStateMetadata function with failure
        assertEquals(Integer.valueOf(9), WorkloadGroupThrottleSettings.NODE_LIMIT.get(effectiveThrottling));
        List<WorkloadGroup> res = new ArrayList<>(groupsCollections);
    public void testValidateThrottlingTreatsMissingByAsGroupScope() {
     * Tests delete a WorkloadGroup with invalid name  
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(  
    public void testValidMaxSandboxCountSetting() {
        List<WorkloadGroup> oldWorkloadGroups = new ArrayList<>();  
    /**  
        );  
        UpdateWorkloadGroupRequest updateWorkloadGroupRequest = updateWorkloadGroupRequest(
            ClusterState initialState = clusterState();
            clusterState()  
                Settings.EMPTY,
            )  
            ._id(_ID_ONE)  
            .updatedAt(1690934400000L)
            updateWorkloadGroupRequest,
        );
        assertEqualWorkloadGroups(new ArrayList<>(afterDeletionGroups.values()), oldWorkloadGroups, false);
            new MutableWorkloadGroupFragment(
            .build();
        WorkloadGroupPersistenceService.validateThrottlingIsEnforceable(throttling);
        }).when(clusterService).submitStateUpdateTask(anyString(), any());
        assertThrows(  
            () -> WorkloadManagementTestUtils.workloadGroupPersistenceService().setMaxWorkloadGroupCount(-1)  
            .mutableWorkloadGroupFragment(new MutableWorkloadGroupFragment(ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.15)))
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.NAME_NONE_EXISTED;
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupList;  
        assertEqualWorkloadGroups(expectedList, updatedWorkloadGroups, true);
    }  
            clusterSettings()  
    public void testValidateThrottlingTreatsNullByAsGroupScope() {
    /**  
            .updatedAt(1690934400000L)
        }).when(clusterService).submitStateUpdateTask(anyString(), any());
/*  
     * Tests UpdateInClusterStateMetadata function  
        UpdateWorkloadGroupRequest updateWorkloadGroupRequest = updateWorkloadGroupRequest(
        List<WorkloadGroup> list2 = new ArrayList<>();
        Tuple<WorkloadGroupPersistenceService, ClusterState> setup = preparePersistenceServiceSetup(new HashMap<>());
     */  
    public void testPersistInClusterStateMetadataFailure() {  
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
    public void testInvalidMaxWorkloadGroupCount() {
        listOne.add(WorkloadManagementTestUtils.workloadGroupOne);
            ClusterStateUpdateTask task = invocation.getArgument(1);
import static org.mockito.Mockito.doAnswer;
    public void testUpdateWorkloadGroupResourceLimitsOnly() {
        workloadGroupPersistenceService.persistInClusterStateMetadata(workloadGroupOne, listener);
                Map.of(),
import org.opensearch.plugin.wlm.WorkloadManagementTestUtils;
        expectedList.add(workloadGroupTwo);  
     * Tests delete a single WorkloadGroup
        workloadGroupPersistenceService.persistInClusterStateMetadata(workloadGroupOne, listener);
        expectedList.add(updated);
        );
            ._id("W5iIqHyhgi4K1qIAAAAIHw==")  
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(  
        WorkloadGroup toCreate = builder().name(NAME_NONE_EXISTED)
        );
        Settings effectiveThrottling = WorkloadGroupPersistenceService.getEffectiveThrottling(request, clusterState);
import org.opensearch.common.settings.ClusterSettings;
            ResourceNotFoundException.class,
            assertEquals(workloadGroupPersistenceService.deleteWorkloadGroupThrottlingKey, task.getClusterManagerThrottlingKey());
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
        Set<String> currentNAME = res.stream().map(WorkloadGroup::getName).collect(Collectors.toSet());  
    /**
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.clusterState;
    public void testGetNonExistedWorkloadGroups() {  
    }
            clusterSettings()
        ClusterStateUpdateTask capturedTask = captor.getValue();  
            .updatedAt(1690934400000L)
    }
    }
            NAME_ONE,  
        assertEquals(1, groups.size());
            settings,
            Exception exception = new RuntimeException("Test Exception");
            .metadata(Metadata.builder().workloadGroups(Map.of(_ID_ONE, existingGroup)))
    public void testCreateWorkloadGroup() {  
        assertThrows(
        WorkloadGroupPersistenceService workloadGroupPersistenceService1 = setup.v1();
            .filter(group -> group.getName().equals(NAME_ONE))
                    Settings.EMPTY,  
    /**  
        WorkloadGroupPersistenceService.validateThrottlingIsEnforceable(null);  
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupRequest;
            NAME_ONE,
    }  
     * Test case to ensure the error is thrown when we already have the max allowed number of WorkloadGroups, but
        assertEquals(1, updatedGroupsMap.size());  
        assertEqualWorkloadGroups(listOne, listTwo, false);  
        verify(clusterService).submitStateUpdateTask(eq(SOURCE), any(AckedClusterStateUpdateTask.class));
    }
            .build();  
        ClusterSettings clusterSettings = new ClusterSettings(settings, clusterSettingsSet());
        Collection<WorkloadGroup> groupsCollections = WorkloadGroupPersistenceService.getFromClusterStateMetadata(
        ClusterService clusterService = new ClusterService(settings, clusterSettings(), mock(ThreadPool.class));
    /**
            .build();  
            new MutableWorkloadGroupFragment(ResiliencyMode.SOFT, new HashMap<>())
    }
        }).when(clusterService).submitStateUpdateTask(anyString(), any());
            NAME_TWO,
        ActionListener<UpdateWorkloadGroupResponse> listener = mock(ActionListener.class);
        verify(clusterService).submitStateUpdateTask(eq(SOURCE), any());  
                    Map.of(ResourceType.MEMORY, 0.3),
    }
        );
    /**
     * Tests setting maxWorkloadGroupCount
        assertThrows(  
        assertEquals(50, workloadGroupPersistenceService.getMaxWorkloadGroupCount());
            Exception exception = new RuntimeException("Test Exception");
        Optional<WorkloadGroup> findUpdatedGroupTwo = newClusterState.metadata()  
import java.util.List;
            .stream()  
            clusterSettings()
        verify(listener).onResponse(any(CreateWorkloadGroupResponse.class));  
     */  
        WorkloadGroup existingGroup = builder().name(NAME_ONE)  
        assertEqualWorkloadGroups(list1, list2, true);  
     * Tests the valid value of {@code node.workload_group.max_count}  
            .mutableWorkloadGroupFragment(
        UpdateWorkloadGroupRequest updateWorkloadGroupRequest = updateWorkloadGroupRequest(
    }
            NAME_NONE_EXISTED,
            clusterService,
