import java.util.List;  
        sut = new WorkloadGroupRequestOperationListener(workloadGroupService, testThreadPool);
    }  
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
                testWorkloadGroupId,
        setupMockedWorkloadGroupsFromClusterState();
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.max_concurrent_shard_requests", "10").build());
    public void testMultiThreadedValidWorkloadGroupRequestFailures() {
                    Map.of(
                    )
    }
        assertEquals(TimeValue.timeValueSeconds(5), mockSearchRequest.source().timeout());
        when(mockClusterService.state()).thenReturn(state);
        assertNull(mockSearchRequest.source().timeout()); // No settings applied
        String wgId = "test-wg";  
        sut.onRequestStart(mockSearchRequestContext);
            sut = new WorkloadGroupRequestOperationListener(workloadGroupService, testThreadPool);
                .put("search.batched_reduce_size", "256")
            Collections.emptySet(),
    }
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
        String threadContextQG_Id
                testWorkloadGroupId,
                    0,
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.batched_reduce_size", "100").build());
        mockSearchRequest.setBatchedReduceSize(50);
        String wgId = "test-wg";  
    SearchRequestContext mockSearchRequestContext;  
                        ResourceType.CPU,
                .build()  
        when(mockSearchRequestContext.getRequest()).thenReturn(mockSearchRequest);
    }
                    0,
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
        }  
            } catch (InterruptedException ignored) {  
        // All values should be overridden by WLM settings
                .put("search.batched_reduce_size", "256")
        try (ThreadContext.StoredContext currentContext = testThreadPool.getThreadContext().stashContext()) {
        taskCancellationService = mock(WorkloadGroupTaskCancellationService.class);
/*  
import static org.mockito.Mockito.when;  
import org.opensearch.common.unit.TimeValue;
import org.opensearch.wlm.WorkloadManagementSettings;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService;  
        sut.onRequestStart(mockSearchRequestContext);
        assertNull(mockSearchRequest.source().timeout());
                .put("search.default_search_timeout", "30s")  
        );  
            threads.add(new Thread(() -> {  
    }
        // Set explicit values on the request  
import org.opensearch.wlm.stats.WorkloadGroupState;
                .put("search.max_concurrent_shard_requests", "3")  
    }
        );  
import static org.mockito.Mockito.doNothing;  
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.default_search_timeout", "1m").build());
import org.opensearch.cluster.service.ClusterService;  
        final String testWorkloadGroupId = "asdgasgkajgkw3141_3rt4t";
                WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get(),
        threads.forEach(Thread::start);
        mockSearchRequest.setCancelAfterTimeInterval(TimeValue.timeValueSeconds(10));
                    0,
    public void testApplySearchSettings_MultipleSettings() {
        assertNull(mockSearchRequest.getCancelAfterTimeInterval());
    }
    public void testApplySearchSettings_EmptySearchSettings() {
            Settings.builder()
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.max_concurrent_shard_requests", "5").build());
                        ResourceType.CPU,
    }  
        workloadGroupStateMap = new HashMap<>();
        );
                    Map.of(  
        assertEquals(20, mockSearchRequest.getMaxConcurrentShardRequests());
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
        // Request should remain unchanged - source is null, no timeout set  
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
                    0,
    }
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),  
    private WorkloadManagementSettings mockWorkloadManagementSettings;
        String wgId = "test-wg";
        sut.onRequestStart(mockSearchRequestContext);  
    }  
    public static final int ITERATIONS = 20;  
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),  
        mockSearchRequest.source(new SearchSourceBuilder());  
                    0,
    }
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
            testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, threadContextQG_Id);
        assertEquals(TimeValue.timeValueSeconds(30), mockSearchRequest.source().timeout()); // Request value preserved
                    0,
        doThrow(OpenSearchRejectedExecutionException.class).when(workloadGroupService).rejectIfNeeded(testWorkloadGroupId);  
                taskCancellationService,
        WorkloadGroupStats expectedStats = new WorkloadGroupStats(  
            wgId,  
        mockSearchRequest.source(new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(30)));
                    0,  
        when(state.metadata()).thenReturn(metadata);
    public void testNonRejectionCase() {
            );
                .put("search.default_search_timeout", "1m")
                .put("search.batched_reduce_size", "256")
                .put("search.cancel_after_time_interval", "2m")
    public void testInvalidWorkloadGroupFailure() throws IOException {
                .put("search.default_search_timeout", "1m")
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
    }
        testThreadPool = new TestThreadPool("RejectionTestThreadPool");
import java.util.HashMap;
                .put("search.cancel_after_time_interval", "1m")
            Map.of(
        // Request has default value (not explicitly set), raw field is 0  
        workloadGroupStateMap.put(testWorkloadGroupId, new WorkloadGroupState());  
        WorkloadGroup wg = createWorkloadGroup(  
        sut.onRequestStart(mockSearchRequestContext);
        assertNull(mockSearchRequest.source());
                    0,
                )  
    SearchRequest mockSearchRequest;
                Collections.emptySet()  
        String wgId = "test-wg";  
            wgId,
        return new WorkloadGroup(
            )
        WorkloadGroupStats expectedStats = new WorkloadGroupStats(  
    ThreadPool testThreadPool;
                    )  
        String wgId = "test-wg";
                )
        );
                .put("search.max_concurrent_shard_requests", "5")
    }  
                    0,  
            assertEquals(expectedStats, actualStats);
        sut.onRequestStart(mockSearchRequestContext);  
        mockSearchRequest.setCancelAfterTimeInterval(TimeValue.timeValueSeconds(10));
            try {
        WorkloadGroupsStateAccessor accessor = new WorkloadGroupsStateAccessor(workloadGroupStateMap);
}  
    }
                        ResourceType.MEMORY,
            mockWorkloadManagementSettings,
        mockSearchRequest.source(new SearchSourceBuilder());
            Map.of(  
        assertEquals(256, mockSearchRequest.getBatchedReduceSize());  
            Settings.builder().put("search.default_search_timeout", "1m").put("search.cancel_after_time_interval", "2m").build()
                .put("override_request_values", "false")
                mockWorkloadManagementSettings,
        assertEquals(TimeValue.timeValueMinutes(2), mockSearchRequest.getCancelAfterTimeInterval());
            taskCancellationService,
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
                new WorkloadGroupStats.WorkloadGroupStatsHolder(  
    String testWorkloadGroupId;
        assertEquals(SearchRequest.DEFAULT_BATCHED_REDUCE_SIZE, mockSearchRequest.getBatchedReduceSize());
                    0,
    public void setUp() throws Exception {  
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),  
        assertEquals(TimeValue.timeValueMinutes(1), mockSearchRequest.source().timeout());
    ) {
                    sut.onRequestFailure(null, null);  
                MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(TimeValue.timeValueSeconds(30), mockSearchRequest.source().timeout());
import org.opensearch.wlm.MutableWorkloadGroupFragment;  
                    )  
        mockSearchRequest.source(new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(5)));
    }
                )
                    1,  
        Metadata mockMetaData = mock(Metadata.class);
        WorkloadGroup wg = createWorkloadGroup(
        );
        assertEquals(TimeValue.timeValueSeconds(30), mockSearchRequest.getCancelAfterTimeInterval());
import org.opensearch.action.search.SearchRequest;
        when(metadata.workloadGroups()).thenReturn(Collections.emptyMap());  
            wgId,
        mockSearchRequest.source(new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(5)));
    private WorkloadGroupTaskCancellationService taskCancellationService;  
            WorkloadGroupStats actualStats = workloadGroupService.nodeStats(set, null);
            null,
import org.opensearch.wlm.stats.WorkloadGroupStats;
            Settings.builder()  
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
        String wgId = "test-wg";
    public void testApplySearchSettings_Timeout_RequestAlreadySet() {
import org.opensearch.cluster.metadata.WorkloadGroup;
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, testWorkloadGroupId);  
                    0,
        set.add("_all");  
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
    private void setupMockedWorkloadGroupsFromClusterState() {
            set.add("_all");  
        HashSet<String> set = new HashSet<>();
                    0,
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
                ),  
            HashSet<String> set = new HashSet<>();
                .build()  
                ),
                    0,
        assertEquals(TimeValue.timeValueMinutes(1), mockSearchRequest.getCancelAfterTimeInterval());  
        sut.onRequestStart(mockSearchRequestContext);  
        assertEquals(100, mockSearchRequest.getBatchedReduceSize());
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
        String wgId = "test-wg";
        sut.onRequestStart(mockSearchRequestContext);
        sut.onRequestStart(mockSearchRequestContext);
                    0,  
                    0,
        // No workload group ID in thread context  
    public void testApplySearchSettings_OverrideRequestValues_DefaultsToFalseWhenAbsent() {
                    0,  
        final String testWorkloadGroupId = "asdgasgkajgkw3141_3rt4t";
    public void testValidWorkloadGroupRequestFailure() throws IOException {  
            ),
            mockClusterService,
                        ResourceType.CPU,
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.default_search_timeout", "30s").build());  
            wgId,
        assertEquals(50, mockSearchRequest.getBatchedReduceSize());
        mockSearchRequest.source(new SearchSourceBuilder());  
        // All request values should be preserved
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, testWorkloadGroupId);
        assertEquals(20, mockSearchRequest.getMaxConcurrentShardRequests()); // Request value preserved
                .put("search.default_search_timeout", "1m")
import org.opensearch.wlm.WorkloadGroupTask;  
        // Request values should be preserved (override defaults to false)  
        mockSearchRequestContext = mock(SearchRequestContext.class);  
                    0,  
    public void testApplySearchSettings_NullWorkloadGroupId() {
                    0,
        mockSearchRequest.setBatchedReduceSize(50); // explicitly set by user
import java.util.HashSet;
            id,  
import org.opensearch.common.settings.Settings;
        String wgId = "test-wg";
                ),
import org.opensearch.wlm.WorkloadGroupService;
    }
                WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get(),
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),  
        WorkloadGroup wg = createWorkloadGroup(
        sut.onRequestStart(mockSearchRequestContext);
        String wgId = "test-wg";
        mockSearchRequest.setMaxConcurrentShardRequests(20);  
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
    public void testApplySearchSettings_OverrideRequestValues_True() {
        sut.onRequestStart(mockSearchRequestContext);  
        workloadGroupService = mock(WorkloadGroupService.class);  
                new WorkloadGroupStats.WorkloadGroupStatsHolder(  
            Collections.emptySet()
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
        assertNull(mockSearchRequest.getCancelAfterTimeInterval());  
    }  
import java.util.Map;
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);
        WorkloadGroupStats actualStats = workloadGroupService.nodeStats(set, null);
        doNothing().when(workloadGroupService).rejectIfNeeded(testWorkloadGroupId);
 */  
        assertNull(mockSearchRequest.source()); // Should not throw, source remains null  
        assertEquals(TimeValue.timeValueSeconds(10), mockSearchRequest.getCancelAfterTimeInterval()); // Request value preserved
    }  
        assertEquals(TimeValue.timeValueSeconds(5), mockSearchRequest.source().timeout());
                .put("search.max_concurrent_shard_requests", "3")
            testThreadPool,  
    public void testApplySearchSettings_CancelAfterTimeInterval_WlmAppliedWhenNull() {  
                    0,
import java.util.ArrayList;
        sut.onRequestStart(mockSearchRequestContext);  
            System.currentTimeMillis()  
        // Set explicit values on the request  
        assertEquals(10, mockSearchRequest.getMaxConcurrentShardRequests()); // WLM applied
                    ITERATIONS,  
        WorkloadGroupsStateAccessor stateAccessor = new WorkloadGroupsStateAccessor(workloadGroupStateMap);  
        );
                    0,
            new MutableWorkloadGroupFragment(
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
        mockSearchRequest.source(new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(5)));
    public void testApplySearchSettings_MaxConcurrentShardRequests_RequestAlreadySet() {
import org.opensearch.cluster.ClusterState;  
 *
        // WLM values applied (override=true, but nothing to override - same result as override=false)
                Collections.emptySet(),
        assertEquals(3, mockSearchRequest.getMaxConcurrentShardRequests());
        workloadGroupService = new WorkloadGroupService(  
                        ResourceType.MEMORY,  
            }
    private ClusterService mockClusterService;
                    testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, testWorkloadGroupId);
                .build()
            accessor,  
        assertNull(mockSearchRequest.source());
        assertEquals(SearchRequest.DEFAULT_BATCHED_REDUCE_SIZE, mockSearchRequest.getBatchedReduceSize());
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);  
 * this file be licensed under the Apache-2.0 license or a
        sut.onRequestStart(mockSearchRequestContext);
        assertEquals(TimeValue.timeValueSeconds(10), mockSearchRequest.getCancelAfterTimeInterval());  
                testThreadPool,
                    0,  
        sut.onRequestStart(mockSearchRequestContext);
        mockSearchRequest.setMaxConcurrentShardRequests(20);  
        assertEquals(TimeValue.timeValueMinutes(1), mockSearchRequest.source().timeout());
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        // Set explicit values on the request  
        testThreadPool.shutdown();  
                        ResourceType.CPU,
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.cancel_after_time_interval", "30s").build());
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
        assertSuccess(testWorkloadGroupId, workloadGroupStateMap, expectedStats, testWorkloadGroupId);
        assertEquals(TimeValue.timeValueSeconds(10), mockSearchRequest.getCancelAfterTimeInterval());
            setupMockedWorkloadGroupsFromClusterState();
import java.io.IOException;
        testWorkloadGroupId = "safjgagnakg-3r3fads";  
    public void testApplySearchSettings_Timeout_NullSource() {
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);  
                WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get(),
            Settings.builder()
import org.opensearch.threadpool.TestThreadPool;
                    0,  
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.cancel_after_time_interval", "30s").build());
    public void testApplySearchSettings_OverrideRequestValues_TrueWithRequestUnset() {
package org.opensearch.wlm.listeners;
    }
    }  
            wgId,
                    0,  
    }
                .build()
        mockWorkloadManagementSettings = mock(WorkloadManagementSettings.class);
        assertEquals(0, mockSearchRequest.getMaxConcurrentShardRequestsRaw());
                .put("search.max_concurrent_shard_requests", "3")  
                    Map.of(  
                    Map.of(
                        ResourceType.MEMORY,  
                searchSettings
                    )
import org.opensearch.search.builder.SearchSourceBuilder;
        // Request uses default value (512)  
        assertSuccess(testWorkloadGroupId, workloadGroupStateMap, expectedStats, "dummy-invalid-qg-id");
        when(mockClusterState.metadata()).thenReturn(mockMetaData);
        for (int i = 0; i < ITERATIONS; i++) {
 * compatible open source license.
            workloadGroupService = new WorkloadGroupService(
    public void testRejectionCase() {  
import org.opensearch.common.util.concurrent.ThreadContext;  
    Map<String, WorkloadGroupState> workloadGroupStateMap;  
        super.setUp();
                new WorkloadGroupStats.WorkloadGroupStatsHolder(
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
    private void assertSuccess(  
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);  
        when(mockClusterService.state()).thenReturn(mockClusterState);  
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);  
        sut.onRequestStart(mockSearchRequestContext);
        // No override_request_values key in settings — should default to false
        }  
                    0,
import java.util.Collections;  
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.EMPTY);
        WorkloadGroup wg = createWorkloadGroup(  
    public void testApplySearchSettings_OverrideRequestValues_False() {
            Map.of(
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
                    )  
                    0,
    WorkloadGroupRequestOperationListener sut;
        String wgId = "test-wg";  
                new WorkloadGroupStats.WorkloadGroupStatsHolder(  
    public void testApplySearchSettings_BatchedReduceSize_RequestAlreadySet() {
        ClusterState state = mock(ClusterState.class);
        assertEquals(TimeValue.timeValueMinutes(2), mockSearchRequest.getCancelAfterTimeInterval());  
        sut = new WorkloadGroupRequestOperationListener(workloadGroupService, testThreadPool);
        sut.onRequestStart(mockSearchRequestContext);
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(null);  
    public void testApplySearchSettings_BatchedReduceSize_WlmAppliedWhenDefault() {
                testWorkloadGroupId,
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);  
                    1,
        );
                null,  
        sut.onRequestStart(mockSearchRequestContext);  
        Map<String, WorkloadGroupState> workloadGroupStateMap,
import org.opensearch.wlm.WorkloadGroupsStateAccessor;
                .put("override_request_values", "true")  
                .put("search.cancel_after_time_interval", "2m")
        String wgId = "test-wg";
                Map.of(ResourceType.MEMORY, 0.5),  
                    0,
            sut.onRequestFailure(null, null);  
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);  
                        ResourceType.MEMORY,
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);  
                }
        mockClusterService = mock(ClusterService.class);  
import org.opensearch.cluster.metadata.Metadata;
        assertEquals(expectedStats, actualStats);
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);  
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.default_search_timeout", "10s").build());
    public void tearDown() throws Exception {
                    0,
        sut.onRequestStart(mockSearchRequestContext);  
        mockSearchRequest.setCancelAfterTimeInterval(TimeValue.timeValueSeconds(10));
                    0,
        assertEquals(5, mockSearchRequest.getMaxConcurrentShardRequests());
                        ResourceType.CPU,
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);  
            Settings.builder()  
        assertEquals(3, mockSearchRequest.getMaxConcurrentShardRequests());
    public void testApplySearchSettings_WorkloadGroupNotFound() {
        );  
        assertThrows(OpenSearchRejectedExecutionException.class, () -> sut.onRequestStart(mockSearchRequestContext));
        assertEquals(256, mockSearchRequest.getBatchedReduceSize());
    public void testApplySearchSettings_Timeout_WlmAppliedWhenNull() {
                    Map.of(
            )
import static org.mockito.Mockito.doThrow;
                    0,
import org.opensearch.threadpool.ThreadPool;
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);  
        assertNull(mockSearchRequest.source().timeout());
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, wgId);  
                    0,  
            )
        super.tearDown();
                stateAccessor,
import org.opensearch.test.OpenSearchTestCase;  
                        ResourceType.MEMORY,
                .put("search.cancel_after_time_interval", "2m")  
        assertEquals(50, mockSearchRequest.getBatchedReduceSize()); // Request value preserved
                new WorkloadGroupStats.WorkloadGroupStatsHolder(
        ClusterState mockClusterState = mock(ClusterState.class);
                th.join();
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),
        Metadata metadata = mock(Metadata.class);  
import static org.mockito.Mockito.mock;
        mockSearchRequest.setBatchedReduceSize(50);
        // Request has no explicit values set  
    }
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);  
        WorkloadGroupStats expectedStats = new WorkloadGroupStats(
import org.opensearch.action.search.SearchRequestContext;
        threads.forEach(th -> {  
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);  
import org.opensearch.wlm.ResourceType;
    private WorkloadGroup createWorkloadGroup(String id, Settings searchSettings) {  
        );  
        });  
                    0,
        assertEquals(100, mockSearchRequest.getBatchedReduceSize()); // WLM applied
    public void testApplySearchSettings_MaxConcurrentShardRequests_WlmAppliedWhenDefault() {
        mockSearchRequest.source(new SearchSourceBuilder());
        WorkloadGroup wg = createWorkloadGroup(
        testThreadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "non-existent-id");
                        new WorkloadGroupStats.ResourceStats(0, 0, 0)
    WorkloadGroupService workloadGroupService;
    }
    }  
    public void testApplySearchSettings_CancelAfterTimeInterval_RequestAlreadySet() {
                        ResourceType.MEMORY,
    }  
        String wgId = "test-wg";
        String wgId = "test-wg";  
        assertEquals(TimeValue.timeValueMinutes(1), mockSearchRequest.source().timeout());  
        WorkloadGroupStats expectedStats,  
        mockSearchRequest.setCancelAfterTimeInterval(TimeValue.timeValueSeconds(10));
    }  
        WorkloadGroup wg = createWorkloadGroup(wgId, Settings.builder().put("search.batched_reduce_size", "100").build());
                try (ThreadContext.StoredContext currentContext = testThreadPool.getThreadContext().stashContext()) {
                    0,  
                    )  
public class WorkloadGroupRequestOperationListenerTests extends OpenSearchTestCase {
        String wgId = "test-wg";
            "test-name",
        sut.onRequestStart(mockSearchRequestContext);  
                new WorkloadGroupStats.WorkloadGroupStatsHolder(  
                .put("search.batched_reduce_size", "100")  
                    Map.of(
                        new WorkloadGroupStats.ResourceStats(0, 0, 0),
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
            }));
        List<Thread> threads = new ArrayList<>();
                .put("override_request_values", "true")
        assertNull(mockSearchRequest.source());  
        );
                    0,
                mockClusterService,  
            workloadGroupStateMap.put(testWorkloadGroupId, new WorkloadGroupState());  
        mockSearchRequest = new SearchRequest();
    }
        String testWorkloadGroupId,
        assertEquals(0, mockSearchRequest.getMaxConcurrentShardRequestsRaw());
                        ResourceType.CPU,
        mockSearchRequest.setMaxConcurrentShardRequests(20); // explicitly set by user
        String wgId = "test-wg";  
    // Tests for applyWorkloadGroupSearchSettings  
