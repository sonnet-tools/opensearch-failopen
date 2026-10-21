        // second acquire is over the limit; a null state must not let the stat update swallow the 429
            OpenSearchRejectedExecutionException.class,
        task = new SearchTask(1, "", "test", () -> "", null, null);
            mockWorkloadGroupsStateAccessor,
        Settings throttling = Settings.builder().put("by", "username").put("node_limit", 1).build();
            Map.of(ResourceType.CPU, 0.10)
        WorkloadGroup testWorkloadGroup = getWorkloadGroup(name, id, mode, resourceLimits);
    public void testDoRun_WhenModeDisabled() {
                1L
    public void testAcquireThrottleRolePicksMatchingSubfieldFromMultiTokenPrincipal() {
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        WorkloadGroupTask nested = throttleTask("wg-1");
            mockClusterService,
        when(mockClusterState.metadata()).thenReturn(mockMetadata);
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
            {
    }
import org.opensearch.cluster.ClusterChangedEvent;
        WorkloadGroupTask grandchildC = throttleTask("wg-1");
        expectThrows(OpenSearchRejectedExecutionException.class, () -> serviceWithThrowingState.acquireThrottleOrReject("wg-1", null));
            mockClusterService,
        // this should happen 3 times => 2 to check whether the resource limit has the TRACKED resource type and 1 to get the value
        Set<WorkloadGroup> previousWorkloadGroupsExpected = Set.of(previousWorkloadGroups.get("4242"));
                add(spuWorkloadGroup);
        Settings throttling = Settings.builder().put("by", "username").put("node_limit", 1).build();
        assertNotNull(serviceWithNullState.acquireThrottleOrReject("wg-1", null)); // first admit fills the single slot
    public void testGetCurrentWorkloadGroupReturnsNullWhenHeaderMissing() {
    }
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers;
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|bob" + delim + "role|analyst"));
            mockClusterService,
    }
        assertNull(
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor();
        previousWorkloadGroups.put("4242", addedWorkloadGroup);
        );
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice")); // no role token
        Releasable bob = workloadGroupService.acquireThrottleOrReject("wg-1", "username|bob");
        ClusterState clusterState = Mockito.mock(ClusterState.class);
    ) {
            id + "-name",
            "testWorkloadGroup",
        );
        expectThrows(
            () -> workloadGroupService.acquireThrottleOrReject(independent, () -> false)
            new HashSet<>()
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|all_access" + delim + "role|readall"));
    }
        Settings throttling = Settings.builder().put("node_limit", 1).build();
import org.mockito.Mockito;
            mockClusterService,
    public void testGetCurrentWorkloadGroupReturnsNullWhenGroupMissing() {
        mockThreadPool.shutdown();
        );
        // readall's bucket is still empty.
            mockNodeDuressTrackers,
            "wg-1",
        mockNodeDuressTrackers = Mockito.mock(NodeDuressTrackers.class);
        );
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        assertThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.rejectIfNeeded("workloadGroupId1"));
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.CPU, 0.10)),
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice")
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
            mockWorkloadManagementSettings,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        // The accounting must not leak into unrelated requests: the group is still at its limit for anyone else.
        WorkloadGroupState.ResourceTypeState cpuResourceState = new WorkloadGroupState.ResourceTypeState(ResourceType.CPU);
        Settings throttling = Settings.builder().put("by", "username").put("node_limit", 1).build();
    public void testAcquireThrottleChargesASearchWhoseParentWasNotCounted() {
        );
            mockThreadPool,
            when(workloadGroup.get_id()).thenReturn(entry.getKey());
            () -> workloadGroupService.acquireThrottleOrReject(secondSubSearch, () -> false)
                "testWorkloadGroup",
        workloadGroupState.getResourceState().get(ResourceType.MEMORY).setLastRecordedUsage(0.18);
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    }
    /**
    }
            new HashSet<>()
        return new WorkloadGroup(in);
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        workloadGroupService.doStart();
        assertNotNull(serviceWithThrowingState.acquireThrottleOrReject("wg-1", null)); // fills the single slot
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        assertTrue(firstSubSearch.isThrottleCounted());
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.DISABLED);
        WorkloadGroup testWorkloadGroup = new WorkloadGroup(
        workloadGroupState.getResourceState().get(ResourceType.CPU).setLastRecordedUsage(0.18);
            new MutableWorkloadGroupFragment(
    }
        // principal for user "a,b" with a role token appended
import static org.mockito.ArgumentMatchers.eq;
            new MutableWorkloadGroupFragment(mode, Map.of(ResourceType.MEMORY, 0.5), Settings.EMPTY, throttling),
import static org.mockito.Mockito.when;
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
import org.opensearch.cluster.service.ClusterService;
        verify(spyState, never()).getResourceState();
        BytesStreamOutput out = new BytesStreamOutput();
            super(workloadManagementSettings, taskSelectionStrategy, resourceUsageTrackerService, workloadGroupsStateAccessor);
    public void testAcquireThrottleRoleBucketIsStableAcrossTokenOrder() {
import org.opensearch.cluster.metadata.WorkloadGroup;
            0,
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
            mockClusterService,
        String delim = WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER;
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", null));
            mockWorkloadManagementSettings,
    public void testRejectIfNeeded_whenWorkloadGroupIsSoftMode() {
        );
            }
            "testWorkloadGroup",
        };
        analyst.close();
        workloadGroupService = new WorkloadGroupService(
            MutableWorkloadGroupFragment fragment = Mockito.mock(MutableWorkloadGroupFragment.class);
        threadContext.putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "missing-id");
import java.util.HashSet;
    public void testRejectIfNeeded_whenWorkloadGroupIsEnforcedMode_andBreaching() {
        ClusterState mockPreviousClusterState = Mockito.mock(ClusterState.class);
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "role|all_access" + delim + "role|zzz")
import java.util.Collection;
    public void testAcquireThrottleEnforcedModeDoesNotCountWouldThrottle() {
        }
    private WorkloadGroup throttledGroup(String id, Settings throttling) {
            mockThreadPool,
            WorkloadGroup workloadGroup = Mockito.mock(WorkloadGroup.class);
            1,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null)); // first admit takes the only slot
        WorkloadGroupState workloadGroupState = new WorkloadGroupState();
        try (Releasable occupyingPermit = workloadGroupService.acquireThrottleOrReject(throttleTask("wg-1"), () -> false)) {
            workloadGroupState.getResourceState().get(ResourceType.CPU).rejections.count() + workloadGroupState.getResourceState()
    }
            throwingStateAccessor,
        ((WorkloadGroupTask) task).setWorkloadGroupId(mockThreadPool.getThreadContext());
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
            }
        Metadata mockPreviousMetadata = Mockito.mock(Metadata.class);
            "addedWorkloadGroup",
        mockClusterService = Mockito.mock(ClusterService.class);
        // verify the check to compare the current usage and limit
        Map<String, Settings> unsupportedConfigs = Map.of(
            mockWorkloadManagementSettings,
        // Verify that cancelTasks was called with a BooleanSupplier
        mockWorkloadGroupStateMap.put("testId", workloadGroupState);
        Set<WorkloadGroup> currentWorkloadGroupsExpected = Set.of(currentWorkloadGroups.get("4241"));
        workloadGroupService = new WorkloadGroupService(
        // alice takes her single slot; a second alice request is rejected.
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    }
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
 * this file be licensed under the Apache-2.0 license or a
        when(mockThreadPool.getThreadContext()).thenReturn(threadContext);
            MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", null));
     * A failure while recording the total_throttled stat must NOT swallow the rejection and admit the over-limit
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get());
        BooleanSupplier capturedSupplier = booleanSupplierCaptor.getValue();
        super.setUp();
            Settings.builder().put("attribute", "username").put("node_limit", 1).build()
            assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalWouldThrottle());
        WorkloadGroupsStateAccessor throwingStateAccessor = Mockito.mock(WorkloadGroupsStateAccessor.class);
            WorkloadGroupTask nested = throttleTask("wg-1");
            mockClusterService,
            assertNull(workloadGroupService.acquireThrottleOrReject(outer, () -> false));
        // Call the method
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", null));
            mockClusterService,
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", ""));
    }
            activeWorkloadGroups,
        }
    }
        );
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        when(emptyMapAccessor.getWorkloadGroupStateMap()).thenReturn(new HashMap<>());
            mockThreadPool,
        Map<String, WorkloadGroupState> spyMap = spy(mockWorkloadGroupStateMap);
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        task.setWorkloadGroupId(mockThreadPool.getThreadContext());
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
            Collection<WorkloadGroup> activeWorkloadGroups,
    }
            new HashSet<>()
    public void testClusterChanged() {
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
        );
        workloadGroupService.incrementFailuresFor(null);
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", null)
    private void stubClusterStateWithGroup(WorkloadGroup wg) {
        WorkloadGroup testWorkloadGroup = getWorkloadGroup(
        assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
    private ThreadPool mockThreadPool;
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>() {
        workloadGroupService.doStart();
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>() {
            throttling
            OpenSearchRejectedExecutionException.class,
            "no level of a single request's own nesting may be counted as a throttle",
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
import static org.mockito.Mockito.verify;
            mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled()
import org.opensearch.common.util.concurrent.ThreadContext;
            assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        // No principal (e.g. security plugin not installed) or no matching subfield -> not throttled (fail open).
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        // Valid workload group task but wlm not enabled
                add(testWorkloadGroup);
        Metadata mockMetadata = Mockito.mock(Metadata.class);
        Settings throttling = Settings.builder().put("by", "role").put("node_limit", 1).build();
    }
        WorkloadGroup testWorkloadGroup = new WorkloadGroup(
            emptyMapAccessor,
            mockThreadPool,
        mockWorkloadGroupStateMap.put(WORKLOAD_GROUP_ID, spyState);
        mockWorkloadGroupStateMap.put("workloadGroupId1", spyState);
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
    }
        Metadata metadata = Mockito.mock(Metadata.class);
import org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService;
            mockClusterService,
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
import org.opensearch.threadpool.ThreadPool;
    }
        assertTrue(workloadGroupService.shouldSBPHandle(task));
        expectThrows(
        assertNotNull(permit);
        when(mockNodeDuressTrackers.isNodeInDuress()).thenReturn(true);
            stubClusterStateWithGroup(workloadGroup);
        // MONITOR admits over-limit requests and counts them in total_would_throttle, not total_throttled.
        when(mockClusterChangedEvent.previousState()).thenReturn(mockPreviousClusterState);
        workloadGroupService.clusterChanged(mockClusterChangedEvent);
            {
    public void testOnTaskCompleted() {
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        // the rejection must NOT have landed on the DEFAULT group
            WorkloadGroupTask outer = throttleTask("wg-1");
        // The operator (and the caller) must be able to tell which group and which principal was throttled.
        );
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>() {
    public void testRejectIfNeeded_whenWorkloadGroupIsEnforcedMode_andNotBreaching() {
        WorkloadGroup deletedWorkloadGroup = new WorkloadGroup(
        Settings throttling = Settings.builder().put("node_limit", 0).build();
            OpenSearchRejectedExecutionException.class,
        assertEquals(
            MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
        mockWorkloadGroupStateMap = new HashMap<>();
        verify(spuWorkloadGroup, times(2)).getResourceLimits();
                        )
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "username|bob" + delim + "role|analyst")
            mockWorkloadGroupsStateAccessor.getWorkloadGroupState(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get()).getFailures()
        // The failure listener passes null for an untagged request, and ConcurrentHashMap rejects null keys.
        expectThrows(
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            assertNull(workloadGroupService.acquireThrottleOrReject(entry.getKey(), "username|alice"));
        );
        mockThreadPool = new TestThreadPool("workloadGroupServiceTests");
        // It should still be 1
            mockCancellationService,
            mockWorkloadManagementSettings,
        );
        when(mockPreviousMetadata.workloadGroups()).thenReturn(previousWorkloadGroups);
        workloadGroupService.rejectIfNeeded(testWorkloadGroup.get_id());
            "workloadGroupId1",
        };
        assertEquals(1, workloadGroupState.totalCompletions.count());
        String delim = WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER;
        mockWorkloadGroupStateMap = new HashMap<>();
import java.io.IOException;
    public void testAcquireThrottleMonitorModeDoesNotDoubleCountNestedSearch() {
    }
            assertNull(workloadGroupService.acquireThrottleOrReject(entry.getKey(), "username|alice"));
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>() {
        when(mockNodeDuressTrackers.isNodeInDuress()).thenReturn(false);
        return new WorkloadGroup(
        // second admit hits node_limit of 1 -> 429 + total_throttled incremented
            "workloadGroupId1",
    public void testDoRun_WhenModeEnabled() {
    private Map<String, WorkloadGroupState> mockWorkloadGroupStateMap;
            1L
    public void testAcquireThrottleReturnsNullWhenWlmDisabled() {
        when(mockClusterChangedEvent.state()).thenReturn(mockClusterState);
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling, MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED));
        // test non WorkloadGroupTask
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            "deletedWorkloadGroup",
            mockThreadPool,
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        rootPermit.close();
            "a second level of nesting must inherit the accounting through the exempt middle task",
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.SOFT, Map.of(ResourceType.MEMORY, 0.5)),
        verify(spyMap, never()).get(any());
            mockWorkloadManagementSettings,
                        new WorkloadGroup(
        SearchTask task = createMockTaskWithResourceStats(SearchTask.class, 100, 200, 0, 12);
    WorkloadGroupsStateAccessor mockWorkloadGroupsStateAccessor;
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
    }
            mockCancellationService,
                                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
        );
        Metadata metadata = Mockito.mock(Metadata.class);
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling, MutableWorkloadGroupFragment.ResiliencyMode.MONITOR));
            assertNull(workloadGroupService.acquireThrottleOrReject(independent, () -> false));
    }
        workloadGroupService = new WorkloadGroupService(
        assertEquals(previousWorkloadGroupsExpected, workloadGroupService.getDeletedWorkloadGroups());
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    private Scheduler.Cancellable mockScheduledFuture;
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        return testWorkloadGroup;
            mockClusterService,
            mockCancellationService,
        expectThrows(
    }
        WorkloadGroupsStateAccessor emptyMapAccessor = Mockito.mock(WorkloadGroupsStateAccessor.class);
        verify(spyMap, never()).get(any());
import java.util.Set;
        assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.DISABLED);
        WorkloadGroupTask outer = throttleTask("wg-1");
            }
    public void testShouldSBPHandle() {
        expectThrows(OpenSearchRejectedExecutionException.class, () -> serviceWithNullState.acquireThrottleOrReject("wg-1", null));
            mockThreadPool,
        // Two levels of nesting: root A pays, and B and C ride on that one permit.
            mockCancellationService,
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        // The outer request takes the group's only permit and is marked as counted.
    private static Set<WorkloadGroup> getActiveWorkloadGroups(
        public TestWorkloadGroupCancellationService(
        WorkloadGroup testWorkloadGroup = new WorkloadGroup(name, id, new MutableWorkloadGroupFragment(mode, resourceLimits), 1L);
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice")
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "username|bob" + delim + "role|admin")
            new HashSet<>(),
    public void testThrottleRejectionForWholeGroupOmitsByClause() {
                            ),
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        workloadGroupService.onTaskCompleted(task);
            workloadGroupService.acquireThrottleOrReject(grandchildC, () -> nestedB.isThrottleCounted())
            mockWorkloadGroupsStateAccessor,
            mockWorkloadGroupsStateAccessor,
import org.opensearch.common.lease.Releasable;
        );
import static org.mockito.Mockito.never;
    }
            mockWorkloadManagementSettings,
    }
        );
        permit.close();
    }
        // A nested rewrite search has a counted parent, so it's admitted without a permit (null = nothing to release).
            mockThreadPool,
            mockClusterService,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        expectThrows(
        assertEquals(0, workloadGroupState.getResourceState().get(ResourceType.CPU).rejections.count());
            mockNodeDuressTrackers,
        ClusterState clusterState = Mockito.mock(ClusterState.class);
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    public void testRejectIfNeeded_whenFeatureIsNotEnabled() {
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        when(mockClusterService.state()).thenReturn(clusterState);
            "testWorkloadGroup",
        assertNotNull(alice);
        task.setWorkloadGroupId(mockThreadPool.getThreadContext());
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|carol" + delim + "role|admin"));
        assertNotNull(bob);
        Releasable analyst = workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice" + delim + "role|analyst");
        // verify the check to compare the current usage and limit
        };
        WorkloadGroupTask rootA = throttleTask("wg-1");
    }
        );
        };
        threadContext.putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, workloadGroupId);
        String delim = WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER;
        when(mockNodeDuressTrackers.isNodeInDuress()).thenReturn(true);
        ArgumentCaptor<BooleanSupplier> booleanSupplierCaptor = ArgumentCaptor.forClass(BooleanSupplier.class);
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        );
        String name,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        mockThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "testId");
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice" + delim + "role|admin"));
import static org.opensearch.wlm.tracker.ResourceUsageCalculatorTests.createMockTaskWithResourceStats;
        workloadGroupService = new WorkloadGroupService(
            mockNodeDuressTrackers,
        return task;
            mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled()
        mockThreadPool = Mockito.mock(ThreadPool.class);
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
    public void testAcquireThrottleDoesNotMisattributeToDefaultDuringRegistrationLag() {
        Settings throttling = Settings.builder().put("by", "role").put("node_limit", 1).build();
            WorkloadManagementSettings workloadManagementSettings,
        state.getResourceState().put(ResourceType.CPU, cpuResourceState);
        // this should happen 3 times => 1 to check whether the resource limit has the TRACKED resource type and 1 to get the value
            WorkloadGroupsStateAccessor workloadGroupsStateAccessor,
import org.opensearch.core.tasks.TaskId;
            OpenSearchRejectedExecutionException.class,
import org.mockito.ArgumentCaptor;
        String delim = WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER;
        stubClusterStateWithGroup(throttledGroup("wg-1", Settings.EMPTY)); // throttling not configured
import org.opensearch.cluster.metadata.Metadata;
        );
import org.opensearch.cluster.ClusterState;
        );
     */
        expectThrows(
            activeWorkloadGroups,
            mockNodeDuressTrackers,
        assertTrue(workloadGroupService.shouldSBPHandle(task));
        mockThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "testId");
        // we haven't set the workloadGroupId yet SBP should still track the task for cancellation
        workloadGroupService.rejectIfNeeded(null);
        );
            {
        workloadGroupService = new WorkloadGroupService(
    public void testRejectIfNeeded_whenWorkloadGroupIdIsNullOrDefaultOne() {
        mockWorkloadGroupStateMap.put("workloadGroupId1", spyState);
        Releasable permit = workloadGroupService.acquireThrottleOrReject("wg-1", null); // first admit succeeds
            TaskSelectionStrategy taskSelectionStrategy,
        // Charged to all_access, not readall.
            mockWorkloadGroupsStateAccessor,
        task.setWorkloadGroupId(mockThreadPool.getThreadContext());
            OpenSearchRejectedExecutionException.class,
                            new MutableWorkloadGroupFragment(
        assertEquals(1, workloadGroupState.totalRejections.count());
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        task.setWorkloadGroupId(threadContext);
        assertNotNull(analyst);
import org.opensearch.common.io.stream.BytesStreamOutput;
        );
        Map<String, WorkloadGroupState> spyMap = spy(mockWorkloadGroupStateMap);
        currentWorkloadGroups.put("4241", deletedWorkloadGroup);
        verify(spyMap, never()).get(any());
            id,
    }
        Metadata metadata = Mockito.mock(Metadata.class);
        String workloadGroupId = wg.get_id();
        when(mockMetadata.workloadGroups()).thenReturn(currentWorkloadGroups);
            }
    }
        // An _msearch parent never goes through admission, so each sub-search is charged.
import org.opensearch.tasks.Task;
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        WorkloadGroupTask firstSubSearch = throttleTask("wg-1");
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
import java.util.Map;
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|admin"));
        );
        when(throwingStateAccessor.getWorkloadGroupStateMap()).thenThrow(new RuntimeException("state map race"));
        // Assert the behavior of the BooleanSupplier
        WorkloadGroupTask secondSubSearch = throttleTask("wg-1");
            1L
        assertEquals(
        new MutableWorkloadGroupFragment(
        MutableWorkloadGroupFragment.ResiliencyMode mode,
        );
        when(metadata.workloadGroups()).thenReturn(Map.of(workloadGroupId, wg));
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        ) {
        // Deserialization can keep a zero limit; admission must treat it as disabled before reaching the tracker.
            "legacy-attribute",
    /**
        WorkloadGroupState workloadGroupState = new WorkloadGroupState();
 * The OpenSearch Contributors require contributions made to
            new WorkloadGroup(
        WorkloadGroup spuWorkloadGroup = spy(testWorkloadGroup);
package org.opensearch.wlm;
import org.opensearch.common.settings.Settings;
        String name,
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                }
            mockCancellationService,
        assertEquals(
            mockThreadPool,
            "testWorkloadGroup",
            mockWorkloadGroupsStateAccessor.getWorkloadGroupState(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get())
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        assertTrue(workloadGroupService.shouldSBPHandle(task));
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        String id,
            0,
            "testWorkloadGroup",
        out.writeString(id);
        );
        String userA = "username|a";
        // Exempt but still marked counted, so a grandchild search doesn't take a fresh permit.
        );
            new HashSet<>() {
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
        // invalid workloadGroup task
        workloadGroupService.rejectIfNeeded("workloadGroupId1");
        assertThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.rejectIfNeeded("workloadGroupId1"));
        WorkloadGroupTask independent = throttleTask("wg-1");
            0,
        // Control: proves the nulls above are fail-open, not throttling being off.
    // This is needed to test the behavior of WorkloadGroupService#doRun method
            .putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get());
import org.opensearch.wlm.tracker.WorkloadGroupResourceUsageTrackerService;
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        // user "a" must NOT be treated as the same bucket as "a,b" -> still admitted
        Releasable rootPermit = workloadGroupService.acquireThrottleOrReject(rootA, () -> false);
            assertNull(workloadGroupService.acquireThrottleOrReject(nested, outer::isThrottleCounted));
        task = new Task(1, "simple", "test", "mock task", null, null);
            mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled()
     * request. Whether the state map lookup returns null (group not yet registered / just deleted) or throws, the
        Mockito.verify(mockScheduledFuture).cancel();
        WorkloadGroupTask nestedB = throttleTask("wg-1");
        Mockito.verify(mockThreadPool).scheduleWithFixedDelay(any(Runnable.class), any(TimeValue.class), eq(ThreadPool.Names.GENERIC));
    }
            mockNodeDuressTrackers,
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        alice.close();
        out.writeLong(1L);
        when(clusterState.metadata()).thenReturn(metadata);
        Map<String, WorkloadGroup> previousWorkloadGroups = new HashMap<>();
            {
        StreamInput in = out.bytes().streamInput();
            OpenSearchRejectedExecutionException.class,
        // a second "a,b" request hits the "a,b" bucket limit -> rejected
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
    public void testAcquireThrottleAdmitsNestedRequestWithoutASecondPermit() {
    }
            "workloadGroupId1",
        assertEquals(
        when(mockThreadPool.getThreadContext()).thenReturn(threadContext);
import org.opensearch.threadpool.Scheduler;
        Settings throttling = Settings.builder().put("by", "role").put("node_limit", 1).build();
    }
        return throttledGroup(id, throttling, MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED);
        when(mockThreadPool.scheduleWithFixedDelay(any(), any(), any())).thenReturn(mockScheduledFuture);
        stubClusterStateWithGroup(deserializedThrottledGroup("wg-1", throttling));
        workloadGroupService.doRun();
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        firstPermit.close();
    public void testAcquireThrottleRoleChargesOnlySmallestRole() {
            activeWorkloadGroups,
            mockNodeDuressTrackers,
        when(metadata.workloadGroups()).thenReturn(Map.of("wg-1", wg));
    private WorkloadGroupTaskCancellationService mockCancellationService;
    }
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null)); // fills the single slot
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
        WorkloadGroupState state = new WorkloadGroupState();
        WorkloadGroup testWorkloadGroup = new WorkloadGroup(
        when(mockNodeDuressTrackers.isNodeInDuress()).thenReturn(false);
     * 429 must still propagate.
        outerPermit.close();
            "an _msearch sub-search rejected by the limit is a real throttle",
        mockThreadPool.shutdownNow();
            Map.of(ResourceType.MEMORY, 0.5),
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.DISABLED);
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    public void testAcquireThrottleRoleKeepsPerRoleBuckets() {
        assertTrue(e.getMessage(), e.getMessage().contains("username [alice]"));
            new HashSet<>()
        WorkloadGroupTask independent = throttleTask("wg-1");
            new HashSet<>()
import java.util.Collections;
        workloadGroupService.onTaskCompleted(task);
    }
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|admin" + delim + "role|analyst"));
            mockWorkloadManagementSettings,
        WorkloadGroupTask task = new WorkloadGroupTask(1L, "transport", "Search", "test task", TaskId.EMPTY_TASK_ID, Map.of());
    /** {@code by: role} charges only the smallest role, so it does not cap a role (documented limitation). */
                            1L
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        mockThreadPool = new TestThreadPool("workloadGroupServiceTests");
    public void testAcquireThrottleReturnsNullWhenNodeLimitUnset() {
            mockWorkloadManagementSettings,
        WorkloadGroupState spyState = spy(state);
        );
import java.util.function.BooleanSupplier;
            activeWorkloadGroups,
import org.opensearch.core.common.io.stream.StreamInput;
        mockWorkloadGroupStateMap = new HashMap<>();
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|readall"));
    private WorkloadGroupTask throttleTask(String workloadGroupId) {
        assertEquals(1, workloadGroupState.totalCompletions.count());
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
import org.opensearch.action.search.SearchTask;
        assertEquals(0, workloadGroupState.totalRejections.count());
        mockWorkloadGroupStateMap = new HashMap<>();
        workloadGroupService = new WorkloadGroupService(
            1L
            mockWorkloadGroupsStateAccessor,
        assertTrue("a successful acquire must mark the task as counted", outer.isThrottleCounted());
            Collection<WorkloadGroup> activeWorkloadGroups,
        Set<WorkloadGroup> activeWorkloadGroups = getActiveWorkloadGroups(
        mockWorkloadGroupStateMap.put("testId", workloadGroupState);
            mockCancellationService,
            new HashSet<>(),
            "explicit-group",
        );
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        Mockito.verify(mockCancellationService, never()).cancelTasks(any(), any(), any());
    public void testIncrementFailuresForUntaggedRequestDoesNotThrow() {
        assertNotNull(rootPermit);
            {
    }
            "wg-1-name",
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            OpenSearchRejectedExecutionException.class,
        Task task = new SearchTask(12, "", "", () -> "", null, null);
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
            mockWorkloadManagementSettings,
    public void testAcquireThrottleMonitorModeObservesWithoutRejecting() {
    public void setUp() throws Exception {
    ) {
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        // releasing the first permit frees the slot so a subsequent acquire succeeds
    public void testAcquireThrottleExemptionIsTransitiveAcrossTwoLevelsOfNesting() {
        OpenSearchRejectedExecutionException e = expectThrows(
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        // A principal header may carry both subfields; the role bucket must key off the role token only.
        mockWorkloadGroupStateMap = new HashMap<>();
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
        );
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
            mockNodeDuressTrackers,
                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
        assertNotNull(outerPermit);
public class WorkloadGroupServiceTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
        mockWorkloadGroupStateMap.put("workloadGroupId1", workloadGroupState);
                add(spuWorkloadGroup);
                new MutableWorkloadGroupFragment(
        Mockito.verify(mockCancellationService).cancelTasks(booleanSupplierCaptor.capture(), any(), any());
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
            new HashSet<>()
        mockThreadPool.shutdown();
import org.opensearch.wlm.cancellation.TaskSelectionStrategy;
                    );
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        when(mockWorkloadManagementSettings.getWorkloadGroupServiceRunInterval()).thenReturn(TimeValue.timeValueSeconds(1));
        MutableWorkloadGroupFragment.ResiliencyMode mode,
        assertSame(wg, workloadGroupService.getCurrentWorkloadGroup());
            mockThreadPool,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.DISABLED);
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        assertEquals(
        // accessor whose state-map lookup throws must also still propagate the 429
        );
        // bob is a different bucket, so he is admitted even while alice is at her limit.
        workloadGroupService = new WorkloadGroupService(
        assertNull(workloadGroupService.acquireThrottleOrReject(nested, () -> true));
        WorkloadGroup spuWorkloadGroup = spy(testWorkloadGroup);
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice"));
            BooleanSupplier isNodeInDuress,
            when(fragment.getThrottling()).thenReturn(entry.getValue());
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>() {
        WorkloadGroupState workloadGroupState = new WorkloadGroupState();
        workloadGroupService.rejectIfNeeded("workloadGroupId1");
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        super.tearDown();
        workloadGroupService.rejectIfNeeded(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get());
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        // DEFAULT group state exists, but wg-1 is NOT yet registered (registration lag).
        mockWorkloadGroupStateMap.put("workloadGroupId1", new WorkloadGroupState());
            1,
            mockWorkloadManagementSettings,
    }
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        verify(spuWorkloadGroup, times(3)).getResourceLimits();
            mockCancellationService,
        assertNull(workloadGroupService.acquireThrottleOrReject(nestedB, () -> rootA.isThrottleCounted()));
        mockWorkloadGroupStateMap = new HashMap<>();
            new HashSet<>()
    private WorkloadGroupService workloadGroupService;
        threadContext.putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-1");
        assertTrue(workloadGroupService.shouldSBPHandle(task));
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    private WorkloadGroup deserializedThrottledGroup(String id, Settings throttling) throws IOException {
            Collections.emptySet()
        Settings throttling = Settings.builder().put("by", "role").put("node_limit", 1).build();
            },
        assertTrue(capturedSupplier.getAsBoolean());
            new HashSet<>(),
        ).writeTo(out);
        mockThreadPool = new TestThreadPool("workloadGroupServiceTests");
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        // Only MONITOR is observe-only; SOFT enforces the throttle like ENFORCED does.
        String userAB = "username|a,b" + delim + "role|admin";
        OpenSearchRejectedExecutionException e = expectThrows(
        assertTrue(rootA.isThrottleCounted());
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.5)),
        assertNull(workloadGroupService.getCurrentWorkloadGroup());
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
import static org.mockito.ArgumentMatchers.any;
            when(workloadGroup.getMutableWorkloadGroupFragment()).thenReturn(fragment);
    }
            mockWorkloadGroupsStateAccessor,
        mockCancellationService = Mockito.mock(TestWorkloadGroupCancellationService.class);
            WorkloadGroupResourceUsageTrackerService resourceUsageTrackerService,
        expectThrows(
        when(clusterState.metadata()).thenReturn(metadata);
        workloadGroupService.doStop();
        WorkloadGroup addedWorkloadGroup = new WorkloadGroup(
            }
    public void testAcquireThrottleFailsOpenWhenPrincipalMissingForUsername() {
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            mockWorkloadGroupsStateAccessor,
    }
    private WorkloadGroup throttledGroup(String id, Settings throttling, MutableWorkloadGroupFragment.ResiliencyMode mode) {
        }
            WORKLOAD_GROUP_ID,
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|")); // empty role value
    }
        out.writeString(id + "-name");
    }
            Settings.builder().put("by", "group").put("node_limit", 1).build(),
            )
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        assertEquals(
import org.opensearch.threadpool.TestThreadPool;
/*
            mockCancellationService,
            mockThreadPool,
    public void testAcquireThrottleSoftModeStillRejects() {
    public void testAcquireThrottleRejectsAtLimitAndIncrementsStat() {
    public void testGetCurrentWorkloadGroupReturnsGroupWhenPresent() {
            OpenSearchRejectedExecutionException.class,
        }
    private ClusterService mockClusterService;
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.5)),
        @Override
}
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
    }
    public void testAcquireThrottleUsernameKeepsPerUserBuckets() {
                            "testWorkloadGroup",
            mockWorkloadManagementSettings,
            OpenSearchRejectedExecutionException.class,
        );
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    }
                                Map.of(ResourceType.CPU, 0.10, ResourceType.MEMORY, 0.10)
                {
    }
        assertNotNull("the first sub-search of an _msearch must take its own permit", firstPermit);
        assertNull(workloadGroupService.getCurrentWorkloadGroup());
        workloadGroupService = new WorkloadGroupService(
            "4241",
import static org.mockito.Mockito.spy;
        );
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        mockThreadPool = new TestThreadPool("workloadGroupServiceTests");
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        assertFalse(workloadGroupService.shouldSBPHandle(task));
import org.opensearch.common.unit.TimeValue;
        Releasable firstPermit = workloadGroupService.acquireThrottleOrReject(firstSubSearch, () -> false);
        Settings throttling = Settings.builder().put("by", "username").put("node_limit", 1).build();
                Map.of(ResourceType.CPU, 0.10, ResourceType.MEMORY, 0.10)
        workloadGroupState.getResourceState().get(ResourceType.CPU).setLastRecordedUsage(0.05);
    }
        assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
            1L
        when(mockPreviousClusterState.metadata()).thenReturn(mockPreviousMetadata);
            activeWorkloadGroups,
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", "role|admin"));
            Collection<WorkloadGroup> deletedWorkloadGroups
        public void cancelTasks(
        when(clusterState.metadata()).thenReturn(metadata);
        ClusterState mockClusterState = Mockito.mock(ClusterState.class);
    private static WorkloadGroup getWorkloadGroup(
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
            activeWorkloadGroups,
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        // test the case when SBP should not track the task
        assertEquals(currentWorkloadGroupsExpected, workloadGroupService.getActiveWorkloadGroups());
        assertTrue(e.getMessage(), e.getMessage().contains("per-node limit of 1"));
        Settings throttling = Settings.builder().put("by", "role").put("node_limit", 1).build();
            mockCancellationService,
            OpenSearchRejectedExecutionException.class,
    }
    }
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", null));
                "testId",
        // An independent request still hits the limit.
        );
    }
        WorkloadGroup wg = new WorkloadGroup(
            MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
        Map<String, WorkloadGroup> currentWorkloadGroups = new HashMap<>();
        );
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", userAB));
            Collection<WorkloadGroup> deletedWorkloadGroups
        mockScheduledFuture = Mockito.mock(Scheduler.Cancellable.class);
 */
            ),
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        // C reads only B; if exempt B recorded nothing, C would take a fresh permit and self-reject.
    public void testRejectIfNeeded_whenSoftModeWorkloadGroupIsContendedAndNodeInDuress() {
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        assertFalse(e.getMessage(), e.getMessage().contains(" for group "));
        );
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
    }
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "role|analyst" + delim + "role|admin")
        mockWorkloadGroupStateMap.put("workloadGroupId1", new WorkloadGroupState());
 * compatible open source license.
 *
     * During the state-registration lag a node can enforce a new group's limit before its clusterChanged() registers
        );
        assertTrue(e.getMessage(), e.getMessage().contains("workload group [wg-1-name]"));
    }
        when(mockWorkloadManagementSettings.getNodeLevelCpuRejectionThreshold()).thenReturn(0.8);
    public void tearDown() throws Exception {
        // Verify that refreshWorkloadGroups was called
            WORKLOAD_GROUP_ID,
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice"));
        Settings throttling = Settings.builder().put("node_limit", 1).build();
    }
            1L
            1,
        WorkloadGroupService serviceWithNullState = new WorkloadGroupService(
        assertFalse("a rejected request must not be marked as counted", secondSubSearch.isThrottleCounted());
            mockNodeDuressTrackers,
        // Default workloadGroupId
        cpuResourceState.setLastRecordedUsage(0.10);
    public void testThrottleRejectionNamesGroupAndByValue() {
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
            new HashSet<>()
                .get(ResourceType.MEMORY).rejections.count()
        // releasing alice frees her bucket
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling, MutableWorkloadGroupFragment.ResiliencyMode.SOFT));
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalWouldThrottle());
        ClusterState clusterState = Mockito.mock(ClusterState.class);
        workloadGroupService = new WorkloadGroupService(
            mockNodeDuressTrackers,
        mockThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "testId");
        WorkloadGroupState spyState = spy(new WorkloadGroupState());
                add(testWorkloadGroup);
        workloadGroupService.doRun();
                .getTotalThrottled()
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", userA));
    public void testAcquireThrottleUsernameWithCommaDoesNotCollide() {
        assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalWouldThrottle());
        assertNotNull(ab);
                ),
            Map.of(ResourceType.CPU, 0.10)
            mockCancellationService,
            assertTrue(outer.isThrottleCounted());
import org.opensearch.wlm.stats.WorkloadGroupState;
        // The same roles in any order must land in the same bucket.
            "testWorkloadGroup",
                    add(
        );
            () -> workloadGroupService.acquireThrottleOrReject(independent, () -> false)
            assertEquals(2, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalWouldThrottle());
        for (Map.Entry<String, Settings> entry : unsupportedConfigs.entrySet()) {
        when(mockClusterService.state()).thenReturn(clusterState);
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        // state map with no entry for wg-1 (as during the state-registration lag) -> raw get(id) returns null
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        String delim = WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER;
    }
        Releasable ab = workloadGroupService.acquireThrottleOrReject("wg-1", userAB); // fills "a,b" bucket
            new HashSet<>()
        );
            1L
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|admin")); // no username token
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", ""));
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        );
    }
        );
 * SPDX-License-Identifier: Apache-2.0
                    MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
    public static final String WORKLOAD_GROUP_ID = "workloadGroupId1";
        mockThreadPool.shutdownNow();
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        Map<ResourceType, Double> resourceLimits
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.CPU, 0.10)),
    public void testAcquireThrottleReturnsNullWhenNodeLimitIsZero() throws IOException {
        WorkloadGroupState spyState = spy(workloadGroupState);
        ) {
        when(mockThreadPool.getThreadContext()).thenReturn(threadContext);
            MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
        assertTrue(e.getMessage(), e.getMessage().contains("workload group [wg-1-name]"));
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>();
            "4242",
    public void testAcquireThrottleFailsOpenWhenPrincipalMissingForRole() {
        when(mockClusterService.state()).thenReturn(clusterState);
            mockNodeDuressTrackers,
        String id,
     * the state. The rejection stat must not be misattributed to the DEFAULT group in that window.
            mockWorkloadGroupsStateAccessor,
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                            "testId",
        activeWorkloadGroups.add(
        assertTrue("an exempt request must be marked as counted, so the accounting propagates transitively", nested.isThrottleCounted());
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
        // Verify that refreshWorkloadGroups was called
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling, MutableWorkloadGroupFragment.ResiliencyMode.MONITOR));
    static class TestWorkloadGroupCancellationService extends WorkloadGroupTaskCancellationService {
    }
            mockThreadPool,
        when(metadata.workloadGroups()).thenReturn(Collections.emptyMap());
        WorkloadGroupState workloadGroupState = new WorkloadGroupState();
        mockWorkloadGroupStateMap = new HashMap<>();
        mockWorkloadGroupStateMap.put("workloadGroupId1", new WorkloadGroupState());
            mockWorkloadGroupsStateAccessor,
    private WorkloadManagementSettings mockWorkloadManagementSettings;
    public void testAcquireThrottleStillRejectsWhenStatUpdateFails() {
            activeWorkloadGroups,
        // because it will break out of the loop since the limits are breached
        );
    }
        Map<ResourceType, Double> resourceLimits
        Releasable alice = workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice");
    public void testDoStop_CancelsScheduledTask() {
        expectThrows(
        ClusterChangedEvent mockClusterChangedEvent = Mockito.mock(ClusterChangedEvent.class);
        mockThreadPool.getThreadContext()
        };
                add(testWorkloadGroup);
            mockNodeDuressTrackers,
    public void testAcquireThrottleFailsOpenForUnsupportedThrottlingSchema() {
            assertTrue(nested.isThrottleCounted());
        WorkloadGroupService serviceWithThrowingState = new WorkloadGroupService(
        );
        Set<WorkloadGroup> activeWorkloadGroups = getActiveWorkloadGroups(
    public void testDoStart_SchedulesTask() {
            WorkloadGroupTask independent = throttleTask("wg-1");
        // total_would_throttle is exclusive to MONITOR.
import static org.mockito.Mockito.times;
        Releasable outerPermit = workloadGroupService.acquireThrottleOrReject(outer, () -> false);
     */
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        mockWorkloadManagementSettings = Mockito.mock(WorkloadManagementSettings.class);
import java.util.HashMap;
    NodeDuressTrackers mockNodeDuressTrackers;
            assertNotNull(occupyingPermit);
        // user "a" is a genuinely different principal
            mockCancellationService,
            mockClusterService,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            new HashSet<>()
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
            1L
            Map.of(ResourceType.CPU, 0.10)
            Settings.EMPTY,
            "workloadGroupId1",
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
            "an exemption is not a throttle",
        return activeWorkloadGroups;
    }
                    Map.of(ResourceType.CPU, 0.10, ResourceType.MEMORY, 0.10)
