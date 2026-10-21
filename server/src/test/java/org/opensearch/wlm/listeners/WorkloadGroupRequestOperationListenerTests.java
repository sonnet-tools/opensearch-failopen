 *
                th.join();
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.cancel_after_time_interval", "30s").build());
        mockSearchRequest = new SearchRequest();
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),
        );
        String wgId = "test-wg";
        assertEquals(TimeValue.timeValueMinutes(1), mockSearchRequest.source().timeout());
        }
        workloadGroupStateMap = new HashMap<>();
        sut.onRequestStart(mockSearchRequestContext);
import static org.mockito.Mockito.doThrow;
    ThreadPool testThreadPool;
                    sut.onRequestFailure(null, null);
    public void testInvalidWorkloadGroupFailure() throws IOException {
        mockSearchRequest.source(new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(30)));
                mockWorkloadManagementSettings,
                ),
        assertSuccess(testWorkloadGroupId, workloadGroupStateMap, expectedStats, testWorkloadGroupId);
            Settings.builder()
                        ResourceType.MEMORY,
    private WorkloadGroup createWorkloadGroup(String id, Settings searchSettings) {
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
    }
                mockClusterService,
            )
            assertEquals(expectedStats, actualStats);
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),
        Metadata metadata = mock(Metadata.class);
            )
        assertEquals(TimeValue.timeValueSeconds(5), mockSearchRequest.source().timeout());
    public void testApplySearchSettings_OverrideRequestValues_True() {
        WorkloadGroup wg = createWorkloadGroup(
            System.currentTimeMillis()
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
                Collections.emptySet(),
        workloadGroupStateMap.put(testWorkloadGroupId, new WorkloadGroupState());
    SearchRequestContext mockSearchRequestContext;
import org.opensearch.threadpool.ThreadPool;
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
        testWorkloadGroupId = "safjgagnakg-3r3fads";
        mockSearchRequest.setCancelAfterTimeInterval(TimeValue.timeValueSeconds(10));
        doNothing().when(workloadGroupService).rejectIfNeeded(testWorkloadGroupId);
        sut.onRequestStart(mockSearchRequestContext);
    public void testApplySearchSettings_MaxConcurrentShardRequests_WlmAppliedWhenDefault() {
            mockClusterService,
        sut = new WorkloadGroupRequestOperationListener(workloadGroupService, testThreadPool);
                    testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, testWorkloadGroupId);
                    0,
    }
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
        String wgId = "test-wg";
            sut.onRequestFailure(null, null);
                Map.of(ResourceType.MEMORY, 0.5),
        sut.onRequestStart(mockSearchRequestContext);
        threads.forEach(Thread::start);
                .put("search.max_concurrent_shard_requests", "3")
        String wgId = "test-wg";
                    0,
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.batched_reduce_size", "100").build());
    }
                    )
        assertNull(mockSearchRequest.getCancelAfterTimeInterval());
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.max_concurrent_shard_requests", "10").build());
            wgId,
        assertEquals(TimeValue.timeValueMinutes(1), mockSearchRequest.source().timeout());
                    0,
            )
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
    public void testApplySearchSettings_Timeout_WlmAppliedWhenNull() {
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
            testThreadPool,
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
            Settings.builder()
        when(mockSearchRequestContext.getRequest()).thenReturn(mockSearchRequest);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        List<Thread> threads = new ArrayList<>();
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, testWorkloadGroupId);
        mockSearchRequest.source(new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(5)));
        assertNull(mockSearchRequest.source().timeout());
        WorkloadGroup wg = createWorkloadGroup(
    private WorkloadManagementSettings mockWorkloadManagementSettings;
                WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get(),
                    )
import org.opensearch.cluster.metadata.Metadata;
                    0,
        try (ThreadContext.StoredContext currentContext = testThreadPool.getThreadContext().stashContext()) {
        assertThrows(OpenSearchRejectedExecutionException.class, () -> sut.onRequestStart(mockSearchRequestContext));
        assertEquals(TimeValue.timeValueSeconds(10), mockSearchRequest.getCancelAfterTimeInterval());
                )
            workloadGroupService = new WorkloadGroupService(
        );
                new WorkloadGroupStats.WorkloadGroupStatsHolder(
                        ResourceType.CPU,
                    0,
        mockSearchRequest.source(new SearchSourceBuilder());
            workloadGroupStateMap.put(testWorkloadGroupId, new WorkloadGroupState());
import org.opensearch.common.unit.TimeValue;
        mockWorkloadManagementSettings = mock(WorkloadManagementSettings.class);
        // WLM values applied (override=true, but nothing to override - same result as override=false)
        threads.forEach(th -> {
    }
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
import org.opensearch.cluster.service.ClusterService;
        // No workload group ID in thread context
        assertNull(mockSearchRequest.source());
        assertEquals(TimeValue.timeValueSeconds(5), mockSearchRequest.source().timeout());
        // Set explicit values on the request
                    0,
        );
        mockSearchRequest.setBatchedReduceSize(50);
    }
        WorkloadGroupStats expectedStats = new WorkloadGroupStats(
                    0,
                    0,
        // Request values should be preserved (override defaults to false)
                .put("search.default_search_timeout", "1m")
    public static final int ITERATIONS = 20;
                .put("search.max_concurrent_shard_requests", "3")
    }
        mockSearchRequest.setCancelAfterTimeInterval(TimeValue.timeValueSeconds(10));
    private void assertSuccess(
        WorkloadGroup wg = createWorkloadGroup(
        when(state.metadata()).thenReturn(metadata);
            wgId,
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
                    0,
    }
        assertEquals(256, mockSearchRequest.getBatchedReduceSize());
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
                    0,
            wgId,
        sut.onRequestStart(mockSearchRequestContext);
        assertNull(mockSearchRequest.getCancelAfterTimeInterval());
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.default_search_timeout", "1m").build());
        mockSearchRequest.setMaxConcurrentShardRequests(20);
    }
                searchSettings
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
import static org.mockito.Mockito.when;
import org.opensearch.search.builder.SearchSourceBuilder;
                .put("search.batched_reduce_size", "256")
import org.opensearch.threadpool.TestThreadPool;
        sut.onRequestStart(mockSearchRequestContext);
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
    public void tearDown() throws Exception {
        sut.onRequestStart(mockSearchRequestContext);
                .put("search.batched_reduce_size", "256")
        mockSearchRequest.setBatchedReduceSize(50);
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
    // Tests for applyWorkloadGroupSearchSettings
                        ResourceType.CPU,
import org.opensearch.wlm.WorkloadGroupsStateAccessor;
import org.opensearch.cluster.metadata.WorkloadGroup;
import java.util.List;
        final String testWorkloadGroupId = "asdgasgkajgkw3141_3rt4t";
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(null);
                    Map.of(
            taskCancellationService,
    private void setupMockedWorkloadGroupsFromClusterState() {
        ClusterState mockClusterState = mock(ClusterState.class);
        WorkloadGroupsStateAccessor stateAccessor = new WorkloadGroupsStateAccessor(workloadGroupStateMap);
        String wgId = "test-wg";
                .put("search.max_concurrent_shard_requests", "5")
}
        String wgId = "test-wg";
import org.opensearch.wlm.WorkloadGroupService;
                    )
        assertSuccess(testWorkloadGroupId, workloadGroupStateMap, expectedStats, "dummy-invalid-qg-id");
                    0,
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
        // Set explicit values on the request
import org.opensearch.wlm.WorkloadManagementSettings;
            ),
    public void testApplySearchSettings_CancelAfterTimeInterval_WlmAppliedWhenNull() {
        WorkloadGroup wg = createWorkloadGroup(
        );
        sut.onRequestStart(mockSearchRequestContext);
import org.opensearch.action.search.SearchRequest;
        });
                        ResourceType.MEMORY,
    }
        assertEquals(0, mockSearchRequest.getMaxConcurrentShardRequestsRaw());
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
    public void testMultiThreadedValidWorkloadGroupRequestFailures() {
        assertEquals(20, mockSearchRequest.getMaxConcurrentShardRequests()); // Request value preserved
                    0,
                testWorkloadGroupId,
    }
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
                new WorkloadGroupStats.WorkloadGroupStatsHolder(
                .put("search.cancel_after_time_interval", "2m")
        assertEquals(TimeValue.timeValueMinutes(1), mockSearchRequest.source().timeout());
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
                new WorkloadGroupStats.WorkloadGroupStatsHolder(
        );
        // Request should remain unchanged - source is null, no timeout set
                .put("search.default_search_timeout", "30s")
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, testWorkloadGroupId);
            } catch (InterruptedException ignored) {
        HashSet<String> set = new HashSet<>();
                    Map.of(
public class WorkloadGroupRequestOperationListenerTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to
        workloadGroupService = mock(WorkloadGroupService.class);
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "non-existent-id");
        taskCancellationService = mock(WorkloadGroupTaskCancellationService.class);
        sut.onRequestStart(mockSearchRequestContext);
/*
    }
                .build()
        String wgId = "test-wg";
                new WorkloadGroupStats.WorkloadGroupStatsHolder(
    public void testApplySearchSettings_BatchedReduceSize_RequestAlreadySet() {
        mockSearchRequest.source(new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(5)));
        set.add("_all");
        WorkloadGroup wg = createWorkloadGroup(
        sut.onRequestStart(mockSearchRequestContext);
import org.opensearch.common.util.concurrent.ThreadContext;
        assertNull(mockSearchRequest.source()); // Should not throw, source remains null
        assertEquals(0, mockSearchRequest.getMaxConcurrentShardRequestsRaw());
                .put("search.default_search_timeout", "1m")
        String testWorkloadGroupId,
        String wgId = "test-wg";
    public void testApplySearchSettings_BatchedReduceSize_WlmAppliedWhenDefault() {
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),
                testWorkloadGroupId,
import java.util.HashSet;
        assertEquals(expectedStats, actualStats);
        assertEquals(TimeValue.timeValueMinutes(2), mockSearchRequest.getCancelAfterTimeInterval());
        mockSearchRequest.source(new SearchSourceBuilder());
 * this file be licensed under the Apache-2.0 license or a
    }
                    0,
        String wgId = "test-wg";
            Map.of(
        assertEquals(3, mockSearchRequest.getMaxConcurrentShardRequests());
                    0,
                    0,
                    Map.of(
        sut.onRequestStart(mockSearchRequestContext);
import org.opensearch.wlm.ResourceType;
    }
        assertEquals(TimeValue.timeValueMinutes(2), mockSearchRequest.getCancelAfterTimeInterval());
        String wgId = "test-wg";
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
                    0,
            Collections.emptySet()
                WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get(),
                .put("search.batched_reduce_size", "256")
                .build()
    }
import org.opensearch.common.settings.Settings;
        assertNull(mockSearchRequest.source().timeout());
        when(metadata.workloadGroups()).thenReturn(Collections.emptyMap());
            Settings.builder()
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
        sut.onRequestStart(mockSearchRequestContext);
                .put("override_request_values", "false")
import java.util.Collections;
                .put("search.default_search_timeout", "1m")
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
import org.opensearch.wlm.WorkloadGroupTask;
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
                .put("search.cancel_after_time_interval", "2m")
                    0,
        mockSearchRequest.setMaxConcurrentShardRequests(20); // explicitly set by user
            WorkloadGroupStats actualStats = workloadGroupService.nodeStats(set, null);
        for (int i = 0; i < ITERATIONS; i++) {
    public void testApplySearchSettings_CancelAfterTimeInterval_RequestAlreadySet() {
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
                try (ThreadContext.StoredContext currentContext = testThreadPool.getThreadContext().stashContext()) {
    }
                    0,
import org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService;
        assertEquals(50, mockSearchRequest.getBatchedReduceSize());
        assertEquals(3, mockSearchRequest.getMaxConcurrentShardRequests());
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
            HashSet<String> set = new HashSet<>();
        return new WorkloadGroup(
            Map.of(
import org.opensearch.wlm.stats.WorkloadGroupState;
                    )
                    0,
        WorkloadGroupStats expectedStats = new WorkloadGroupStats(
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
        ClusterState state = mock(ClusterState.class);
                    0,
    public void testValidWorkloadGroupRequestFailure() throws IOException {
        final String testWorkloadGroupId = "asdgasgkajgkw3141_3rt4t";
        sut = new WorkloadGroupRequestOperationListener(workloadGroupService, testThreadPool);
            }
                testWorkloadGroupId,
        );
    public void testApplySearchSettings_MaxConcurrentShardRequests_RequestAlreadySet() {
            }));
    }
        );
                        ResourceType.MEMORY,
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.default_search_timeout", "10s").build());
        super.setUp();
        mockSearchRequestContext = mock(SearchRequestContext.class);
            Settings.builder().put("search.default_search_timeout", "1m").put("search.cancel_after_time_interval", "2m").build()
            Map.of(
        sut.onRequestStart(mockSearchRequestContext);
                    )
                .put("search.batched_reduce_size", "100")
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
    Map<String, WorkloadGroupState> workloadGroupStateMap;
        String wgId = "test-wg";
        );
            id,
        mockClusterService = mock(ClusterService.class);
            sut = new WorkloadGroupRequestOperationListener(workloadGroupService, testThreadPool);
    public void testApplySearchSettings_WorkloadGroupNotFound() {
                .put("search.cancel_after_time_interval", "1m")
                    0,
        sut.onRequestStart(mockSearchRequestContext);
        assertEquals(TimeValue.timeValueSeconds(30), mockSearchRequest.source().timeout());
        testThreadPool = new TestThreadPool("RejectionTestThreadPool");
            threads.add(new Thread(() -> {
                .build()
    }
            wgId,
            new MutableWorkloadGroupFragment(
        String wgId = "test-wg";
        assertEquals(20, mockSearchRequest.getMaxConcurrentShardRequests());
                    Map.of(
                        ResourceType.CPU,
 * SPDX-License-Identifier: Apache-2.0
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.cancel_after_time_interval", "30s").build());
            Settings.builder()
                ),
        // All values should be overridden by WLM settings
    public void setUp() throws Exception {
    public void testApplySearchSettings_EmptySearchSettings() {
                    1,
    public void testNonRejectionCase() {
                        ResourceType.MEMORY,
import static org.mockito.Mockito.mock;
    public void testApplySearchSettings_Timeout_RequestAlreadySet() {
        testThreadPool.shutdown();
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
                    )
        sut.onRequestStart(mockSearchRequestContext);
            "test-name",
        assertEquals(100, mockSearchRequest.getBatchedReduceSize());
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),
    }
    }
                    0,
                    Map.of(
        // Request uses default value (512)
    WorkloadGroupService workloadGroupService;
    }
                .build()
            try {
        mockSearchRequest.setCancelAfterTimeInterval(TimeValue.timeValueSeconds(10));
        assertEquals(50, mockSearchRequest.getBatchedReduceSize()); // Request value preserved
                        ResourceType.MEMORY,
    public void testRejectionCase() {
        sut.onRequestStart(mockSearchRequestContext);
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.max_concurrent_shard_requests", "5").build());
        assertEquals(TimeValue.timeValueSeconds(10), mockSearchRequest.getCancelAfterTimeInterval());
        WorkloadGroupStats expectedStats = new WorkloadGroupStats(
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
        );
        String wgId = "test-wg";
import static org.mockito.Mockito.doNothing;
            accessor,
import org.opensearch.test.OpenSearchTestCase;
                .put("search.max_concurrent_shard_requests", "3")
                    0,
                taskCancellationService,
        String wgId = "test-wg";
        workloadGroupService = new WorkloadGroupService(
                stateAccessor,
        sut.onRequestStart(mockSearchRequestContext);
            );
        assertEquals(10, mockSearchRequest.getMaxConcurrentShardRequests()); // WLM applied
                }
    public void testApplySearchSettings_OverrideRequestValues_TrueWithRequestUnset() {
    }
    SearchRequest mockSearchRequest;
        assertNull(mockSearchRequest.source());
                        ResourceType.CPU,
        super.tearDown();
        WorkloadGroupsStateAccessor accessor = new WorkloadGroupsStateAccessor(workloadGroupStateMap);
        assertEquals(TimeValue.timeValueSeconds(30), mockSearchRequest.getCancelAfterTimeInterval());
            setupMockedWorkloadGroupsFromClusterState();
                    0,
        doThrow(OpenSearchRejectedExecutionException.class).when(workloadGroupService).rejectIfNeeded(testWorkloadGroupId);
        mockSearchRequest.source(new SearchSourceBuilder());
import java.io.IOException;
        );
    }
                )
            testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, threadContextQG_Id);
    }
        assertEquals(5, mockSearchRequest.getMaxConcurrentShardRequests());
                    0,
    public void testApplySearchSettings_MultipleSettings() {
import java.util.Map;
        sut.onRequestStart(mockSearchRequestContext);
                MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
        mockSearchRequest.source(new SearchSourceBuilder());
    public void testApplySearchSettings_NullWorkloadGroupId() {
    private WorkloadGroupTaskCancellationService taskCancellationService;
        Metadata mockMetaData = mock(Metadata.class);
        String threadContextQG_Id
package org.opensearch.wlm.listeners;
import org.opensearch.wlm.stats.WorkloadGroupStats;
        WorkloadGroupStats expectedStats,
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.EMPTY);
                null,
                .put("override_request_values", "true")
import org.opensearch.cluster.ClusterState;
            null,
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
import org.opensearch.action.search.SearchRequestContext;
    }
import org.opensearch.wlm.MutableWorkloadGroupFragment;
                    0,
                    0,
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.batched_reduce_size", "100").build());
        mockSearchRequest.setMaxConcurrentShardRequests(20);
        when(mockClusterService.state()).thenReturn(mockClusterState);
        assertEquals(TimeValue.timeValueMinutes(1), mockSearchRequest.getCancelAfterTimeInterval());
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
            set.add("_all");
        Map<String, WorkloadGroupState> workloadGroupStateMap,
                    0,
                    ITERATIONS,
        // Set explicit values on the request
            mockWorkloadManagementSettings,
    String testWorkloadGroupId;
        assertEquals(256, mockSearchRequest.getBatchedReduceSize());
        String wgId = "test-wg";
                WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get(),
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
                .put("search.cancel_after_time_interval", "2m")
                Collections.emptySet()
        // Request has default value (not explicitly set), raw field is 0
                ),
    ) {
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
                )
    public void testApplySearchSettings_OverrideRequestValues_False() {
            Collections.emptySet(),
        assertNull(mockSearchRequest.source().timeout()); // No settings applied
                new WorkloadGroupStats.WorkloadGroupStatsHolder(
        mockSearchRequest.source(new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(5)));
        assertEquals(TimeValue.timeValueSeconds(10), mockSearchRequest.getCancelAfterTimeInterval()); // Request value preserved
                .put("override_request_values", "true")
                    0,
    }
                new WorkloadGroupStats.WorkloadGroupStatsHolder(
 * compatible open source license.
    }
            wgId,
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.default_search_timeout", "30s").build());
    public void testApplySearchSettings_Timeout_NullSource() {
        // No override_request_values key in settings — should default to false
                    0,
        mockSearchRequest.setCancelAfterTimeInterval(TimeValue.timeValueSeconds(10));
        mockSearchRequest.setBatchedReduceSize(50); // explicitly set by user
        String wgId = "test-wg";
    public void testApplySearchSettings_OverrideRequestValues_DefaultsToFalseWhenAbsent() {
        }
    }
                    0,
        WorkloadGroupStats actualStats = workloadGroupService.nodeStats(set, null);
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),
                        ResourceType.CPU,
                        ResourceType.CPU,
        when(mockClusterState.metadata()).thenReturn(mockMetaData);
        // Request has no explicit values set
        sut.onRequestStart(mockSearchRequestContext);
                    1,
        setupMockedWorkloadGroupsFromClusterState();
        when(mockClusterService.state()).thenReturn(state);
        assertEquals(100, mockSearchRequest.getBatchedReduceSize()); // WLM applied
                testThreadPool,
        assertEquals(SearchRequest.DEFAULT_BATCHED_REDUCE_SIZE, mockSearchRequest.getBatchedReduceSize());
        assertNull(mockSearchRequest.source());
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),
    private ClusterService mockClusterService;
        // All request values should be preserved
import java.util.ArrayList;
 */
                    0,
                        ResourceType.MEMORY,
    WorkloadGroupRequestOperationListener sut;
        assertEquals(TimeValue.timeValueSeconds(30), mockSearchRequest.source().timeout()); // Request value preserved
                    0,
                    Map.of(
        assertEquals(SearchRequest.DEFAULT_BATCHED_REDUCE_SIZE, mockSearchRequest.getBatchedReduceSize());
import java.util.HashMap;
