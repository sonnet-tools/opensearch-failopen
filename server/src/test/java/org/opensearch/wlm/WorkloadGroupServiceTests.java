        // Charged to all_access, not readall.
            mockClusterService,
        assertTrue(workloadGroupService.shouldSBPHandle(task));  
        expectThrows(
import java.util.Set;
    }
        );
        );  
        mockThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "testId");
        );
        verify(spyState, never()).getResourceState();
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", userAB));  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            new HashSet<>(),
        // Valid workload group task but wlm not enabled
            new WorkloadGroup(
        }
        );
        mockWorkloadGroupStateMap = new HashMap<>();
import org.opensearch.common.io.stream.BytesStreamOutput;
        task = new SearchTask(1, "", "test", () -> "", null, null);  
        WorkloadGroupState state = new WorkloadGroupState();
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", userA));
            new HashSet<>()  
    }
    public void testAcquireThrottleChargesASearchWhoseParentWasNotCounted() {
        WorkloadGroupState spyState = spy(workloadGroupState);
                                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
            new HashSet<>()
import org.opensearch.tasks.Task;
            "explicit-group",  
        assertNull(workloadGroupService.acquireThrottleOrReject(nestedB, () -> rootA.isThrottleCounted()));  
            emptyMapAccessor,  
        String name,
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        };
        workloadGroupService.doStart();  
        assertNull(workloadGroupService.getCurrentWorkloadGroup());  
        mockWorkloadGroupStateMap.put("testId", workloadGroupState);  
            }
            OpenSearchRejectedExecutionException.class,  
        when(mockNodeDuressTrackers.isNodeInDuress()).thenReturn(true);  
        super.setUp();  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    }
        String delim = WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER;
        WorkloadGroup testWorkloadGroup = new WorkloadGroup(  
        Map<String, WorkloadGroupState> spyMap = spy(mockWorkloadGroupStateMap);
    }
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
    public void testRejectIfNeeded_whenWorkloadGroupIsEnforcedMode_andBreaching() {
    private WorkloadManagementSettings mockWorkloadManagementSettings;
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.DISABLED);
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
import org.opensearch.wlm.stats.WorkloadGroupState;
            mockNodeDuressTrackers,
        );
        // readall's bucket is still empty.  
        Mockito.verify(mockThreadPool).scheduleWithFixedDelay(any(Runnable.class), any(TimeValue.class), eq(ThreadPool.Names.GENERIC));
        // test the case when SBP should not track the task
            mockCancellationService,
        assertNotNull(bob);  
        mockThreadPool = Mockito.mock(ThreadPool.class);
        assertNotNull(serviceWithThrowingState.acquireThrottleOrReject("wg-1", null)); // fills the single slot
        assertNotNull(alice);  
            mockWorkloadGroupsStateAccessor,  
            mockNodeDuressTrackers,
        mockScheduledFuture = Mockito.mock(Scheduler.Cancellable.class);  
        assertEquals(
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling, MutableWorkloadGroupFragment.ResiliencyMode.MONITOR));  
        Settings throttling = Settings.builder().put("node_limit", 1).build();  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            mockThreadPool,
            "4242",  
    }
            Collection<WorkloadGroup> activeWorkloadGroups,  
        WorkloadGroupService serviceWithThrowingState = new WorkloadGroupService(  
        workloadGroupService = new WorkloadGroupService(
            mockClusterService,
import org.opensearch.wlm.cancellation.TaskSelectionStrategy;  
        assertEquals(
        workloadGroupService.doRun();
        );  
        WorkloadGroupState workloadGroupState = new WorkloadGroupState();
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
            "an _msearch sub-search rejected by the limit is a real throttle",  
        workloadGroupService = new WorkloadGroupService(
                            1L
                new MutableWorkloadGroupFragment(
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", null));  
    }  
            new HashSet<>()
        assertEquals(1, workloadGroupState.totalCompletions.count());  
        );
        assertEquals(
            mockThreadPool,  
            mockWorkloadManagementSettings,
    public void testAcquireThrottleFailsOpenForUnsupportedThrottlingSchema() {  
    public void testClusterChanged() {
import org.opensearch.threadpool.Scheduler;  
        WorkloadGroupService serviceWithNullState = new WorkloadGroupService(  
            mockClusterService,  
    public void testRejectIfNeeded_whenFeatureIsNotEnabled() {
            OpenSearchRejectedExecutionException.class,
        when(mockClusterService.state()).thenReturn(clusterState);
        Task task = new SearchTask(12, "", "", () -> "", null, null);
        for (Map.Entry<String, Settings> entry : unsupportedConfigs.entrySet()) {  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            "4241",  
    private void stubClusterStateWithGroup(WorkloadGroup wg) {  
            mockNodeDuressTrackers,
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
            mockNodeDuressTrackers,  
            mockClusterService,
        Releasable permit = workloadGroupService.acquireThrottleOrReject("wg-1", null); // first admit succeeds  
    private ClusterService mockClusterService;  
    }
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        String delim = WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER;
    public void testDoRun_WhenModeEnabled() {  
        Map<String, WorkloadGroup> previousWorkloadGroups = new HashMap<>();
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        // The accounting must not leak into unrelated requests: the group is still at its limit for anyone else.
            WorkloadGroupTask outer = throttleTask("wg-1");
            activeWorkloadGroups,
            0,  
            mockCancellationService,  
    public void testAcquireThrottleUsernameKeepsPerUserBuckets() {
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
        // second admit hits node_limit of 1 -> 429 + total_throttled incremented
    private static Set<WorkloadGroup> getActiveWorkloadGroups(
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null)); // first admit takes the only slot
        );  
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice"));
    public void testAcquireThrottleRejectsAtLimitAndIncrementsStat() {  
        ) {
            mockClusterService,
        );
        // principal for user "a,b" with a role token appended
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);  
        workloadGroupService = new WorkloadGroupService(
        return new WorkloadGroup(in);
        // A nested rewrite search has a counted parent, so it's admitted without a permit (null = nothing to release).
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>();
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        Settings throttling = Settings.builder().put("node_limit", 1).build();
    public void testAcquireThrottleDoesNotMisattributeToDefaultDuringRegistrationLag() {
        assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
 */  
            {  
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
    public void testRejectIfNeeded_whenSoftModeWorkloadGroupIsContendedAndNodeInDuress() {
        when(mockThreadPool.getThreadContext()).thenReturn(threadContext);  
        Mockito.verify(mockScheduledFuture).cancel();  
import static org.mockito.Mockito.never;
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");  
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalWouldThrottle());  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        String id,  
            activeWorkloadGroups,  
            activeWorkloadGroups,
        // second acquire is over the limit; a null state must not let the stat update swallow the 429  
        );
        stubClusterStateWithGroup(throttledGroup("wg-1", Settings.EMPTY)); // throttling not configured
        // Deserialization can keep a zero limit; admission must treat it as disabled before reaching the tracker.
        workloadGroupService.clusterChanged(mockClusterChangedEvent);  
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling, MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED));
        WorkloadGroupTask independent = throttleTask("wg-1");
        ClusterState clusterState = Mockito.mock(ClusterState.class);
            new MutableWorkloadGroupFragment(  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);  
            {  
        mockWorkloadManagementSettings = Mockito.mock(WorkloadManagementSettings.class);
import java.util.Map;
    public void testDoStop_CancelsScheduledTask() {
        verify(spuWorkloadGroup, times(2)).getResourceLimits();
            mockThreadPool,
        Releasable ab = workloadGroupService.acquireThrottleOrReject("wg-1", userAB); // fills "a,b" bucket
        return activeWorkloadGroups;
            when(fragment.getThrottling()).thenReturn(entry.getValue());
        expectThrows(  
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");  
    }
            when(workloadGroup.get_id()).thenReturn(entry.getKey());  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            WorkloadGroupsStateAccessor workloadGroupsStateAccessor,
            "testWorkloadGroup",
            new HashSet<>()
            OpenSearchRejectedExecutionException.class,
            mockNodeDuressTrackers,
                }
        stubClusterStateWithGroup(deserializedThrottledGroup("wg-1", throttling));
        String workloadGroupId = wg.get_id();  
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "role|all_access" + delim + "role|zzz")
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|readall"));
    public void testOnTaskCompleted() {
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        mockWorkloadGroupStateMap = new HashMap<>();
    }
        // An _msearch parent never goes through admission, so each sub-search is charged.
            mockWorkloadGroupsStateAccessor.getWorkloadGroupState(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get())  
    private static WorkloadGroup getWorkloadGroup(
        // The failure listener passes null for an untagged request, and ConcurrentHashMap rejects null keys.
        task.setWorkloadGroupId(mockThreadPool.getThreadContext());  
        assertFalse(workloadGroupService.shouldSBPHandle(task));
            Collection<WorkloadGroup> deletedWorkloadGroups
        // test non WorkloadGroupTask
        // state map with no entry for wg-1 (as during the state-registration lag) -> raw get(id) returns null  
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        );
            () -> workloadGroupService.acquireThrottleOrReject(secondSubSearch, () -> false)
    }  
            }
        mockWorkloadGroupStateMap = new HashMap<>();
        // bob is a different bucket, so he is admitted even while alice is at her limit.
        workloadGroupState.getResourceState().get(ResourceType.CPU).setLastRecordedUsage(0.18);
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice"));
    }
        );
        Settings throttling = Settings.builder().put("by", "username").put("node_limit", 1).build();
        expectThrows(OpenSearchRejectedExecutionException.class, () -> serviceWithNullState.acquireThrottleOrReject("wg-1", null));
import static org.opensearch.wlm.tracker.ResourceUsageCalculatorTests.createMockTaskWithResourceStats;
    public void testRejectIfNeeded_whenWorkloadGroupIsSoftMode() {
        when(clusterState.metadata()).thenReturn(metadata);
        WorkloadGroupState.ResourceTypeState cpuResourceState = new WorkloadGroupState.ResourceTypeState(ResourceType.CPU);
        );  
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
     */  
        String userAB = "username|a,b" + delim + "role|admin";  
        MutableWorkloadGroupFragment.ResiliencyMode mode,
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>() {
    }  
    }
            new HashSet<>()
                    Map.of(ResourceType.CPU, 0.10, ResourceType.MEMORY, 0.10)
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        when(mockThreadPool.scheduleWithFixedDelay(any(), any(), any())).thenReturn(mockScheduledFuture);  
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", ""));
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers;  
    }
            "workloadGroupId1",
                            "testId",
        );  
        workloadGroupService.rejectIfNeeded(null);
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    public void testAcquireThrottleRolePicksMatchingSubfieldFromMultiTokenPrincipal() {  
            Map.of(ResourceType.CPU, 0.10)
import org.opensearch.cluster.ClusterState;  
    public void testAcquireThrottleReturnsNullWhenNodeLimitIsZero() throws IOException {  
    }  
            new HashSet<>()  
            OpenSearchRejectedExecutionException.class,
            assertTrue(outer.isThrottleCounted());
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.DISABLED);
        );
            BooleanSupplier isNodeInDuress,
        outerPermit.close();
            mockClusterService,  
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
            )
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
import java.util.HashMap;
        assertSame(wg, workloadGroupService.getCurrentWorkloadGroup());  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);  
            .putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get());  
            mockCancellationService,  
        assertNotNull(analyst);
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "role|analyst" + delim + "role|admin")  
        assertTrue(workloadGroupService.shouldSBPHandle(task));
import static org.mockito.Mockito.times;
    }
            TaskSelectionStrategy taskSelectionStrategy,  
        public void cancelTasks(
    ) {  
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor();
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
            Collection<WorkloadGroup> activeWorkloadGroups,  
    public void testAcquireThrottleReturnsNullWhenWlmDisabled() {
        return throttledGroup(id, throttling, MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED);
        workloadGroupService.doStop();
        Map<String, WorkloadGroupState> spyMap = spy(mockWorkloadGroupStateMap);
    }  
            mockWorkloadGroupsStateAccessor,
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
            mockThreadPool,
            mockCancellationService,
        ).writeTo(out);
                Map.of(ResourceType.CPU, 0.10, ResourceType.MEMORY, 0.10)
    }
            "deletedWorkloadGroup",
            1L
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        when(clusterState.metadata()).thenReturn(metadata);
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling, MutableWorkloadGroupFragment.ResiliencyMode.SOFT));
            mockCancellationService,
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.5)),
        Set<WorkloadGroup> currentWorkloadGroupsExpected = Set.of(currentWorkloadGroups.get("4241"));
        // user "a" must NOT be treated as the same bucket as "a,b" -> still admitted  
        // C reads only B; if exempt B recorded nothing, C would take a fresh permit and self-reject.
            OpenSearchRejectedExecutionException.class,  
    public void testAcquireThrottleAdmitsNestedRequestWithoutASecondPermit() {
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));  
        OpenSearchRejectedExecutionException e = expectThrows(  
        Releasable outerPermit = workloadGroupService.acquireThrottleOrReject(outer, () -> false);
    }  
        mockThreadPool = new TestThreadPool("workloadGroupServiceTests");
        ClusterState mockPreviousClusterState = Mockito.mock(ClusterState.class);  
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        workloadGroupService.rejectIfNeeded(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get());  
        threadContext.putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-1");
        mockThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "testId");
        }
        // releasing the first permit frees the slot so a subsequent acquire succeeds  
        assertNotNull(outerPermit);
        mockThreadPool.shutdown();  
            mockCancellationService,
            new HashSet<>()  
        assertTrue("a successful acquire must mark the task as counted", outer.isThrottleCounted());  
    public void testAcquireThrottleRoleChargesOnlySmallestRole() {  
        Metadata mockMetadata = Mockito.mock(Metadata.class);  
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|admin"));
        // accessor whose state-map lookup throws must also still propagate the 429  
                add(testWorkloadGroup);
     * request. Whether the state map lookup returns null (group not yet registered / just deleted) or throws, the
        assertEquals(0, workloadGroupState.totalRejections.count());
        mockWorkloadGroupStateMap.put("workloadGroupId1", spyState);
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
            mockWorkloadGroupsStateAccessor,
        // this should happen 3 times => 1 to check whether the resource limit has the TRACKED resource type and 1 to get the value  
        Settings throttling = Settings.builder().put("by", "username").put("node_limit", 1).build();
            WorkloadGroupTask nested = throttleTask("wg-1");  
                .getTotalThrottled()
        analyst.close();
        try (Releasable occupyingPermit = workloadGroupService.acquireThrottleOrReject(throttleTask("wg-1"), () -> false)) {  
    ) {  
        return testWorkloadGroup;
            mockCancellationService,  
            OpenSearchRejectedExecutionException.class,  
        );
        );
            throttling  
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", "role|admin"));
            1L  
            assertNull(workloadGroupService.acquireThrottleOrReject(nested, outer::isThrottleCounted));
            mockClusterService,
    }
        Metadata metadata = Mockito.mock(Metadata.class);
        OpenSearchRejectedExecutionException e = expectThrows(
        return new WorkloadGroup(
import org.opensearch.cluster.ClusterChangedEvent;
        ((WorkloadGroupTask) task).setWorkloadGroupId(mockThreadPool.getThreadContext());  
        Metadata mockPreviousMetadata = Mockito.mock(Metadata.class);
 *
        mockThreadPool.shutdown();
import static org.mockito.ArgumentMatchers.any;  
        task = new Task(1, "simple", "test", "mock task", null, null);  
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|admin" + delim + "role|analyst"));  
            WorkloadManagementSettings workloadManagementSettings,
        Settings throttling = Settings.builder().put("node_limit", 0).build();  
        task.setWorkloadGroupId(mockThreadPool.getThreadContext());  
            MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
            mockWorkloadManagementSettings,  
    }
    public void testRejectIfNeeded_whenWorkloadGroupIdIsNullOrDefaultOne() {
        // total_would_throttle is exclusive to MONITOR.
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");  
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));  
            mockThreadPool,
            MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,  
        Releasable alice = workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice");
        workloadGroupService.rejectIfNeeded("workloadGroupId1");
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());  
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "username|bob" + delim + "role|analyst")
}  
        WorkloadGroup spuWorkloadGroup = spy(testWorkloadGroup);  
            "testWorkloadGroup",
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));  
        WorkloadGroup testWorkloadGroup = getWorkloadGroup(  
            OpenSearchRejectedExecutionException.class,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        return task;
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice")
import java.io.IOException;
            mockThreadPool,  
        // this should happen 3 times => 2 to check whether the resource limit has the TRACKED resource type and 1 to get the value
    private WorkloadGroup deserializedThrottledGroup(String id, Settings throttling) throws IOException {
import java.util.Collection;  
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        Map<String, WorkloadGroup> currentWorkloadGroups = new HashMap<>();  
        // releasing alice frees her bucket
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.5)),
        );  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        WorkloadGroupsStateAccessor emptyMapAccessor = Mockito.mock(WorkloadGroupsStateAccessor.class);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        WorkloadGroupTask grandchildC = throttleTask("wg-1");  
            0,
        task.setWorkloadGroupId(threadContext);
        Map<String, Settings> unsupportedConfigs = Map.of(
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");  
import static org.mockito.Mockito.verify;
            mockNodeDuressTrackers,
    public void testGetCurrentWorkloadGroupReturnsNullWhenHeaderMissing() {  
        );
        when(mockWorkloadManagementSettings.getNodeLevelCpuRejectionThreshold()).thenReturn(0.8);
        String delim = WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER;  
        assertThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.rejectIfNeeded("workloadGroupId1"));  
        when(emptyMapAccessor.getWorkloadGroupStateMap()).thenReturn(new HashMap<>());
            assertNull(workloadGroupService.acquireThrottleOrReject(independent, () -> false));
        assertTrue(e.getMessage(), e.getMessage().contains("workload group [wg-1-name]"));  
            throwingStateAccessor,  
            new MutableWorkloadGroupFragment(mode, Map.of(ResourceType.MEMORY, 0.5), Settings.EMPTY, throttling),
            "testWorkloadGroup",  
            "workloadGroupId1",
        assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalWouldThrottle());
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
    }  
        Settings throttling = Settings.builder().put("by", "username").put("node_limit", 1).build();
        String id,  
        // Assert the behavior of the BooleanSupplier  
        Settings throttling = Settings.builder().put("node_limit", 1).build();  
    public void testGetCurrentWorkloadGroupReturnsGroupWhenPresent() {  
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        Settings throttling = Settings.builder().put("node_limit", 1).build();  
            mockWorkloadManagementSettings,  
            "addedWorkloadGroup",
        WorkloadGroupTask secondSubSearch = throttleTask("wg-1");
                        )
import static org.mockito.Mockito.when;  
                            ),  
    }
            1,
        // Control: proves the nulls above are fail-open, not throttling being off.  
    public void testAcquireThrottleMonitorModeDoesNotDoubleCountNestedSearch() {  
            mockWorkloadGroupsStateAccessor,
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        // A principal header may carry both subfields; the role bucket must key off the role token only.  
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());  
        assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());  
            mockWorkloadGroupsStateAccessor,
            OpenSearchRejectedExecutionException.class,
    }
    }
    }
            new HashSet<>() {  
package org.opensearch.wlm;
     */  
        assertNotNull(permit);
            assertEquals(2, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalWouldThrottle());
            mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled()
import java.util.Collections;
        cpuResourceState.setLastRecordedUsage(0.10);  
        task.setWorkloadGroupId(mockThreadPool.getThreadContext());
            1,
    private Map<String, WorkloadGroupState> mockWorkloadGroupStateMap;
import static org.mockito.ArgumentMatchers.eq;
            mockNodeDuressTrackers,
            "workloadGroupId1",
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled()
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.DISABLED);
        WorkloadGroupState workloadGroupState = new WorkloadGroupState();
            mockWorkloadManagementSettings,
        workloadGroupService.rejectIfNeeded(testWorkloadGroup.get_id());  
        assertNotNull("the first sub-search of an _msearch must take its own permit", firstPermit);
    }  
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);  
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
            new HashSet<>(),
     * the state. The rejection stat must not be misattributed to the DEFAULT group in that window.
            mockCancellationService,  
        Settings throttling = Settings.builder().put("by", "role").put("node_limit", 1).build();
    }
        workloadGroupService = new WorkloadGroupService(
        // because it will break out of the loop since the limits are breached
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|bob" + delim + "role|analyst"));
import org.mockito.Mockito;  
        expectThrows(
        mockWorkloadGroupStateMap = new HashMap<>();  
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>() {  
        mockWorkloadGroupStateMap = new HashMap<>();
    private Scheduler.Cancellable mockScheduledFuture;  
        // invalid workloadGroup task
        mockWorkloadGroupStateMap.put("workloadGroupId1", new WorkloadGroupState());  
        activeWorkloadGroups.add(
            WorkloadGroup workloadGroup = Mockito.mock(WorkloadGroup.class);
            "a second level of nesting must inherit the accounting through the exempt middle task",
        }
        Settings throttling = Settings.builder().put("by", "role").put("node_limit", 1).build();  
            mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled()
    }
            mockWorkloadGroupsStateAccessor,
        Settings throttling = Settings.builder().put("node_limit", 1).build();  
            Map.of(ResourceType.CPU, 0.10)  
        WorkloadGroupTask firstSubSearch = throttleTask("wg-1");  
        mockClusterService = Mockito.mock(ClusterService.class);
        assertTrue(firstSubSearch.isThrottleCounted());  
            "an exemption is not a throttle",
            activeWorkloadGroups,  
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>() {
            0,
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null)); // fills the single slot  
        permit.close();
            Settings.EMPTY,
                            new MutableWorkloadGroupFragment(  
            mockWorkloadManagementSettings,  
        Mockito.verify(mockCancellationService, never()).cancelTasks(any(), any(), any());  
                                Map.of(ResourceType.CPU, 0.10, ResourceType.MEMORY, 0.10)
    }  
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get());
    }  
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);  
    // This is needed to test the behavior of WorkloadGroupService#doRun method
        when(mockClusterService.state()).thenReturn(clusterState);  
            mockWorkloadManagementSettings,
                .get(ResourceType.MEMORY).rejections.count()  
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", null));
            Collection<WorkloadGroup> deletedWorkloadGroups
        WorkloadGroup wg = new WorkloadGroup(
        WorkloadGroupTask nestedB = throttleTask("wg-1");
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        ClusterChangedEvent mockClusterChangedEvent = Mockito.mock(ClusterChangedEvent.class);
        );
            mockThreadPool,  
            WORKLOAD_GROUP_ID,
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);  
    }  
        );
    public void setUp() throws Exception {
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            mockThreadPool,
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
            activeWorkloadGroups,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.DISABLED);  
        );
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "username|bob" + delim + "role|admin")
    }
        Settings throttling = Settings.builder().put("by", "role").put("node_limit", 1).build();
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", null)
            mockWorkloadGroupsStateAccessor,
            MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,  
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));  
        // verify the check to compare the current usage and limit
    public void testAcquireThrottleSoftModeStillRejects() {
        ) {
        // The same roles in any order must land in the same bucket.
        WorkloadGroupsStateAccessor throwingStateAccessor = Mockito.mock(WorkloadGroupsStateAccessor.class);
    public void testDoRun_WhenModeDisabled() {  
        Releasable analyst = workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice" + delim + "role|analyst");  
        // The operator (and the caller) must be able to tell which group and which principal was throttled.
        Set<WorkloadGroup> previousWorkloadGroupsExpected = Set.of(previousWorkloadGroups.get("4242"));  
        assertNull(
    /**  
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.SOFT, Map.of(ResourceType.MEMORY, 0.5)),
    public void testAcquireThrottleStillRejectsWhenStatUpdateFails() {
        // Call the method  
                        new WorkloadGroup(  
            new HashSet<>(),  
    public void tearDown() throws Exception {
        BooleanSupplier capturedSupplier = booleanSupplierCaptor.getValue();
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
            {
            "no level of a single request's own nesting may be counted as a throttle",  
            mockThreadPool,
        assertEquals(1, workloadGroupState.totalCompletions.count());
    public void testAcquireThrottleReturnsNullWhenNodeLimitUnset() {
    public void testThrottleRejectionNamesGroupAndByValue() {
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);  
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));  
        String delim = WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER;
import org.opensearch.common.lease.Releasable;
        // Only MONITOR is observe-only; SOFT enforces the throttle like ENFORCED does.
        String name,
import org.opensearch.common.util.concurrent.ThreadContext;
        mockWorkloadGroupStateMap.put("workloadGroupId1", new WorkloadGroupState());  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        mockThreadPool = new TestThreadPool("workloadGroupServiceTests");  
        WorkloadGroup deletedWorkloadGroup = new WorkloadGroup(
            assertNotNull(occupyingPermit);
            () -> workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice")  
    private WorkloadGroupService workloadGroupService;
        // Two levels of nesting: root A pays, and B and C ride on that one permit.
        when(metadata.workloadGroups()).thenReturn(Collections.emptyMap());
        mockNodeDuressTrackers = Mockito.mock(NodeDuressTrackers.class);  
        assertNull(workloadGroupService.getCurrentWorkloadGroup());  
            assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalWouldThrottle());  
            mockWorkloadManagementSettings,  
import org.opensearch.common.unit.TimeValue;
            Settings.builder().put("by", "group").put("node_limit", 1).build(),
        WorkloadGroup testWorkloadGroup = getWorkloadGroup(name, id, mode, resourceLimits);
        WorkloadGroup testWorkloadGroup = new WorkloadGroup(
        assertEquals(1, workloadGroupState.totalRejections.count());
import org.mockito.ArgumentCaptor;
                add(testWorkloadGroup);
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
        // we haven't set the workloadGroupId yet SBP should still track the task for cancellation
        when(mockThreadPool.getThreadContext()).thenReturn(threadContext);  
    public void testThrottleRejectionForWholeGroupOmitsByClause() {
            MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
        when(mockWorkloadManagementSettings.getWorkloadGroupServiceRunInterval()).thenReturn(TimeValue.timeValueSeconds(1));
        // It should still be 1  
        WorkloadGroupTask independent = throttleTask("wg-1");  
        // DEFAULT group state exists, but wg-1 is NOT yet registered (registration lag).  
        // Verify that refreshWorkloadGroups was called  
        String delim = WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER;
        when(mockClusterChangedEvent.previousState()).thenReturn(mockPreviousClusterState);  
    public void testDoStart_SchedulesTask() {  
                ),
        );  
import static org.mockito.Mockito.spy;  
        assertEquals(previousWorkloadGroupsExpected, workloadGroupService.getDeletedWorkloadGroups());  
        mockThreadPool.shutdownNow();
        workloadGroupService.incrementFailuresFor(null);  
        MutableWorkloadGroupFragment.ResiliencyMode mode,
import org.opensearch.test.OpenSearchTestCase;
        // MONITOR admits over-limit requests and counts them in total_would_throttle, not total_throttled.  
        verify(spyMap, never()).get(any());
        WorkloadGroup spuWorkloadGroup = spy(testWorkloadGroup);  
        Metadata metadata = Mockito.mock(Metadata.class);
    /**
        ArgumentCaptor<BooleanSupplier> booleanSupplierCaptor = ArgumentCaptor.forClass(BooleanSupplier.class);  
            1L  
            Map.of(ResourceType.MEMORY, 0.5),
            mockCancellationService,  
        Settings throttling = Settings.builder().put("node_limit", 1).build();
    }  
        Settings throttling = Settings.builder().put("by", "username").put("node_limit", 1).build();
        workloadGroupService = new WorkloadGroupService(
        );
                    add(
            mockClusterService,  
        );
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        previousWorkloadGroups.put("4242", addedWorkloadGroup);
            mockNodeDuressTrackers,  
        mockWorkloadGroupStateMap.put("testId", workloadGroupState);  
        assertEquals(1, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
    NodeDuressTrackers mockNodeDuressTrackers;
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
    public void testAcquireThrottleFailsOpenWhenPrincipalMissingForRole() {  
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
            activeWorkloadGroups,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        );  
        );
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        // the rejection must NOT have landed on the DEFAULT group  
        };  
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.CPU, 0.10)),  
            mockWorkloadManagementSettings,
            {
import java.util.HashSet;  
            },
        verify(spyMap, never()).get(any());
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");  
        out.writeString(id);
        Releasable firstPermit = workloadGroupService.acquireThrottleOrReject(firstSubSearch, () -> false);
        assertNull(workloadGroupService.acquireThrottleOrReject(nested, () -> true));
            mockCancellationService,
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|admin")); // no username token
        );
            "wg-1-name",
        workloadGroupService.doStart();
            1L
            mockWorkloadManagementSettings,  
            new HashSet<>()
            mockClusterService,
        assertTrue("an exempt request must be marked as counted, so the accounting propagates transitively", nested.isThrottleCounted());  
        WorkloadGroupTask nested = throttleTask("wg-1");  
            assertNull(workloadGroupService.acquireThrottleOrReject(entry.getKey(), "username|alice"));
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", ""));  
        mockWorkloadGroupStateMap.put("workloadGroupId1", spyState);
        assertEquals(  
            new HashSet<>()  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
            mockNodeDuressTrackers,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);  
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));  
            WORKLOAD_GROUP_ID,
        assertEquals(
        // alice takes her single slot; a second alice request is rejected.
                add(spuWorkloadGroup);  
        workloadGroupService = new WorkloadGroupService(
                            "testWorkloadGroup",
        ClusterState clusterState = Mockito.mock(ClusterState.class);
                add(spuWorkloadGroup);  
        assertTrue(workloadGroupService.shouldSBPHandle(task));
        firstPermit.close();
    }
        workloadGroupService.onTaskCompleted(task);
import org.opensearch.core.common.io.stream.StreamInput;  
    public void testAcquireThrottleEnforcedModeDoesNotCountWouldThrottle() {  
        rootPermit.close();  
            mockClusterService,
        WorkloadGroupState spyState = spy(state);
        workloadGroupService.doRun();  
    public void testAcquireThrottleExemptionIsTransitiveAcrossTwoLevelsOfNesting() {
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
        // Exempt but still marked counted, so a grandchild search doesn't take a fresh permit.
        // a second "a,b" request hits the "a,b" bucket limit -> rejected
        mockCancellationService = Mockito.mock(TestWorkloadGroupCancellationService.class);
        verify(spuWorkloadGroup, times(3)).getResourceLimits();  
        workloadGroupService.rejectIfNeeded("workloadGroupId1");  
            OpenSearchRejectedExecutionException.class,
        currentWorkloadGroups.put("4241", deletedWorkloadGroup);
        assertEquals(
        String userA = "username|a";
            mockNodeDuressTrackers,  
    }  
        when(clusterState.metadata()).thenReturn(metadata);
        expectThrows(OpenSearchRejectedExecutionException.class, () -> serviceWithThrowingState.acquireThrottleOrReject("wg-1", null));  
            OpenSearchRejectedExecutionException.class,
    }
import org.opensearch.common.settings.Settings;  
    private WorkloadGroupTask throttleTask(String workloadGroupId) {  
        when(mockNodeDuressTrackers.isNodeInDuress()).thenReturn(false);
            assertTrue(nested.isThrottleCounted());
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
            mockClusterService,
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", null));  
        Set<WorkloadGroup> activeWorkloadGroups = getActiveWorkloadGroups(
        WorkloadGroupTask rootA = throttleTask("wg-1");  
     * A failure while recording the total_throttled stat must NOT swallow the rejection and admit the over-limit  
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>() {
     * 429 must still propagate.
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
            mockWorkloadManagementSettings,
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling, MutableWorkloadGroupFragment.ResiliencyMode.MONITOR));
    public static final String WORKLOAD_GROUP_ID = "workloadGroupId1";  
    public void testAcquireThrottleMonitorModeObservesWithoutRejecting() {
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        when(mockClusterService.state()).thenReturn(clusterState);  
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice")); // no role token
        assertEquals(0, workloadGroupState.getResourceState().get(ResourceType.CPU).rejections.count());
        // The outer request takes the group's only permit and is marked as counted.
        expectThrows(
            "wg-1",  
    }
    public void testAcquireThrottleUsernameWithCommaDoesNotCollide() {
            "testWorkloadGroup",
import org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService;
        expectThrows(  
        mockWorkloadGroupStateMap.put(WORKLOAD_GROUP_ID, spyState);  
        expectThrows(
        workloadGroupService.onTaskCompleted(task);
        WorkloadGroup testWorkloadGroup = new WorkloadGroup(name, id, new MutableWorkloadGroupFragment(mode, resourceLimits), 1L);
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));  
    }
    }  
        // Verify that refreshWorkloadGroups was called
import org.opensearch.action.search.SearchTask;
            MutableWorkloadGroupFragment fragment = Mockito.mock(MutableWorkloadGroupFragment.class);
import java.util.function.BooleanSupplier;  
            mockWorkloadGroupsStateAccessor.getWorkloadGroupState(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get()).getFailures()  
        mockWorkloadGroupStateMap.put("workloadGroupId1", new WorkloadGroupState());  
        when(mockClusterChangedEvent.state()).thenReturn(mockClusterState);
    }
public class WorkloadGroupServiceTests extends OpenSearchTestCase {
        assertNotNull(ab);
                add(testWorkloadGroup);
    private WorkloadGroup throttledGroup(String id, Settings throttling) {  
     * During the state-registration lag a node can enforce a new group's limit before its clusterChanged() registers
        };
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);  
            {
            1L
        Set<WorkloadGroup> activeWorkloadGroups = new HashSet<>() {
        Map<ResourceType, Double> resourceLimits
        // An independent request still hits the limit.
            "testWorkloadGroup",  
        Mockito.verify(mockCancellationService).cancelTasks(booleanSupplierCaptor.capture(), any(), any());
    /** {@code by: role} charges only the smallest role, so it does not cap a role (documented limitation). */
        assertTrue(rootA.isThrottleCounted());  
        workloadGroupService = new WorkloadGroupService(
    private WorkloadGroupTaskCancellationService mockCancellationService;
        @Override  
        mockWorkloadGroupStateMap = new HashMap<>();
        threadContext.putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, workloadGroupId);  
    private WorkloadGroup throttledGroup(String id, Settings throttling, MutableWorkloadGroupFragment.ResiliencyMode mode) {
        WorkloadGroupState workloadGroupState = new WorkloadGroupState();
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
import org.opensearch.cluster.metadata.WorkloadGroup;
            1L
                "testId",
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        );
            id,
        SearchTask task = createMockTaskWithResourceStats(SearchTask.class, 100, 200, 0, 12);  
        assertTrue(capturedSupplier.getAsBoolean());
    static class TestWorkloadGroupCancellationService extends WorkloadGroupTaskCancellationService {  
    public void testAcquireThrottleRoleBucketIsStableAcrossTokenOrder() {
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|")); // empty role value  
        WorkloadGroupTask outer = throttleTask("wg-1");  
        ClusterState clusterState = Mockito.mock(ClusterState.class);
            assertNull(workloadGroupService.acquireThrottleOrReject(outer, () -> false));  
        verify(spyMap, never()).get(any());
            mockWorkloadGroupsStateAccessor,
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);  
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|alice" + delim + "role|admin"));
    public void testShouldSBPHandle() {
    }
import org.opensearch.cluster.service.ClusterService;  
        mockThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "testId");
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
import org.opensearch.threadpool.ThreadPool;
        }  
                    );  
    }
            Settings.builder().put("attribute", "username").put("node_limit", 1).build()  
        workloadGroupService = new WorkloadGroupService(  
        };  
        when(throwingStateAccessor.getWorkloadGroupStateMap()).thenThrow(new RuntimeException("state map race"));
        Settings throttling = Settings.builder().put("node_limit", 1).build();
import org.opensearch.cluster.metadata.Metadata;
        when(metadata.workloadGroups()).thenReturn(Map.of(workloadGroupId, wg));  
        out.writeString(id + "-name");  
    public void testAcquireThrottleFailsOpenWhenPrincipalMissingForUsername() {
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED, Map.of(ResourceType.CPU, 0.10)),
            assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
            id + "-name",  
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));  
            () -> workloadGroupService.acquireThrottleOrReject(independent, () -> false)  
        assertEquals(currentWorkloadGroupsExpected, workloadGroupService.getActiveWorkloadGroups());
            assertNull(workloadGroupService.acquireThrottleOrReject(entry.getKey(), "username|alice"));  
        workloadGroupState.getResourceState().get(ResourceType.CPU).setLastRecordedUsage(0.05);
        WorkloadGroup testWorkloadGroup = new WorkloadGroup(  
        expectThrows(
            () -> workloadGroupService.acquireThrottleOrReject(independent, () -> false)
        Settings throttling = Settings.builder().put("by", "role").put("node_limit", 1).build();  
            }
    public void testIncrementFailuresForUntaggedRequestDoesNotThrow() {
        mockWorkloadGroupStateMap.put("workloadGroupId1", workloadGroupState);
        assertTrue(e.getMessage(), e.getMessage().contains("workload group [wg-1-name]"));
            mockWorkloadGroupsStateAccessor,
            when(workloadGroup.getMutableWorkloadGroupFragment()).thenReturn(fragment);
            Collections.emptySet()
        assertNotNull(rootPermit);
    }
        Releasable bob = workloadGroupService.acquireThrottleOrReject("wg-1", "username|bob");
    }
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "role|all_access" + delim + "role|readall"));
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        when(mockPreviousClusterState.metadata()).thenReturn(mockPreviousMetadata);
            ),  
        );
        assertThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.rejectIfNeeded("workloadGroupId1"));
        Releasable rootPermit = workloadGroupService.acquireThrottleOrReject(rootA, () -> false);
        );
        Set<WorkloadGroup> activeWorkloadGroups = getActiveWorkloadGroups(
        mockThreadPool.shutdownNow();  
    public void testAcquireThrottleRoleKeepsPerRoleBuckets() {
        WorkloadGroupState workloadGroupState = new WorkloadGroupState();
        BytesStreamOutput out = new BytesStreamOutput();
        };
    }
        expectThrows(OpenSearchRejectedExecutionException.class, () -> workloadGroupService.acquireThrottleOrReject("wg-1", null));
        );  
                {
        state.getResourceState().put(ResourceType.CPU, cpuResourceState);
 * The OpenSearch Contributors require contributions made to  
            WorkloadGroupResourceUsageTrackerService resourceUsageTrackerService,
        when(mockThreadPool.getThreadContext()).thenReturn(threadContext);
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
            stubClusterStateWithGroup(workloadGroup);  
        );
        new MutableWorkloadGroupFragment(
        alice.close();  
        out.writeLong(1L);
        Metadata metadata = Mockito.mock(Metadata.class);
        assertTrue(workloadGroupService.shouldSBPHandle(task));  
        // No principal (e.g. security plugin not installed) or no matching subfield -> not throttled (fail open).
            "workloadGroupId1",
    }
            1,
    }
            mockThreadPool,
        public TestWorkloadGroupCancellationService(
        assertNull(workloadGroupService.acquireThrottleOrReject("wg-1", null));
    private ThreadPool mockThreadPool;
        assertFalse(e.getMessage(), e.getMessage().contains(" for group "));
            workloadGroupService.acquireThrottleOrReject(grandchildC, () -> nestedB.isThrottleCounted())  
        Settings throttling = Settings.builder().put("node_limit", 1).build();
        );  
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
            }  
        assertFalse("a rejected request must not be marked as counted", secondSubSearch.isThrottleCounted());
        );
            mockWorkloadManagementSettings,
            mockThreadPool,
        // Default workloadGroupId  
                "testWorkloadGroup",  
        Map<ResourceType, Double> resourceLimits
            mockCancellationService,
        WorkloadGroup addedWorkloadGroup = new WorkloadGroup(
    public void testGetCurrentWorkloadGroupReturnsNullWhenGroupMissing() {  
        // verify the check to compare the current usage and limit
                1L  
        mockThreadPool = new TestThreadPool("workloadGroupServiceTests");  
            new HashSet<>()
            WorkloadGroupTask independent = throttleTask("wg-1");  
 * compatible open source license.
    public void testRejectIfNeeded_whenWorkloadGroupIsEnforcedMode_andNotBreaching() {
        WorkloadGroupState spyState = spy(new WorkloadGroupState());  
    WorkloadGroupsStateAccessor mockWorkloadGroupsStateAccessor;  
        );  
                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
        assertNotNull(serviceWithNullState.acquireThrottleOrReject("wg-1", null)); // first admit fills the single slot
        workloadGroupState.getResourceState().get(ResourceType.MEMORY).setLastRecordedUsage(0.18);  
    }
import org.opensearch.core.tasks.TaskId;
        when(mockNodeDuressTrackers.isNodeInDuress()).thenReturn(false);  
        mockWorkloadGroupStateMap = new HashMap<>();  
        mockWorkloadGroupsStateAccessor = new WorkloadGroupsStateAccessor(mockWorkloadGroupStateMap);
        Settings throttling = Settings.builder().put("node_limit", 1).build();  
        workloadGroupService = new WorkloadGroupService(
        expectThrows(  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        when(mockPreviousMetadata.workloadGroups()).thenReturn(previousWorkloadGroups);
        // Verify that cancelTasks was called with a BooleanSupplier
            1L
        mockThreadPool.getThreadContext()
        assertTrue(e.getMessage(), e.getMessage().contains("per-node limit of 1"));
            Map.of(ResourceType.CPU, 0.10)  
            workloadGroupState.getResourceState().get(ResourceType.CPU).rejections.count() + workloadGroupState.getResourceState()
        when(mockMetadata.workloadGroups()).thenReturn(currentWorkloadGroups);
        assertNotNull(workloadGroupService.acquireThrottleOrReject("wg-1", "username|carol" + delim + "role|admin"));
            }
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        threadContext.putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "missing-id");
            super(workloadManagementSettings, taskSelectionStrategy, resourceUsageTrackerService, workloadGroupsStateAccessor);  
import org.opensearch.wlm.tracker.WorkloadGroupResourceUsageTrackerService;  
    }  
        // user "a" is a genuinely different principal
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");  
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);
        super.tearDown();  
        assertEquals(0, mockWorkloadGroupsStateAccessor.getWorkloadGroupState("wg-1").getTotalThrottled());
        assertTrue(e.getMessage(), e.getMessage().contains("username [alice]"));  
                    MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,  
            mockNodeDuressTrackers,
import org.opensearch.threadpool.TestThreadPool;
        mockThreadPool = new TestThreadPool("workloadGroupServiceTests");
        when(metadata.workloadGroups()).thenReturn(Map.of("wg-1", wg));
        mockWorkloadGroupsStateAccessor.addNewWorkloadGroup("wg-1");
        );
    }
        StreamInput in = out.bytes().streamInput();
        when(mockNodeDuressTrackers.isNodeInDuress()).thenReturn(true);
        WorkloadGroupTask task = new WorkloadGroupTask(1L, "transport", "Search", "test task", TaskId.EMPTY_TASK_ID, Map.of());
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));
        stubClusterStateWithGroup(throttledGroup("wg-1", throttling));  
        );
        when(mockWorkloadManagementSettings.getWlmMode()).thenReturn(WlmMode.ENABLED);  
        );
            activeWorkloadGroups,  
        );  
        ClusterState mockClusterState = Mockito.mock(ClusterState.class);
            "testWorkloadGroup",  
/*  
        Settings throttling = Settings.builder().put("by", "role").put("node_limit", 1).build();  
        when(mockClusterState.metadata()).thenReturn(mockMetadata);  
            "legacy-attribute",
