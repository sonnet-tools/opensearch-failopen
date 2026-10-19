        );
        // since the workload group id is not set we should not track this task
            threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "testHeader");
        taskResourceTrackingService = new TaskResourceTrackingService(
            .constructWorkloadGroupLevelUsageViews();  
    }
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        super.tearDown();
    WorkloadGroupResourceUsageTrackerService workloadGroupResourceUsageTrackerService;  
package org.opensearch.wlm.tracker;
}
import org.opensearch.tasks.TaskResourceTrackingService;  
        WorkloadGroupTask task = new SearchTask(1, "test", "test", () -> "Test", TaskId.EMPTY_TASK_ID, new HashMap<>());
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);  
    TaskResourceTrackingService taskResourceTrackingService;
            assertFalse(resourceUsageViewMap.isEmpty());
 */  
import org.opensearch.common.settings.Settings;  
    public void setUp() throws Exception {
    ThreadPool threadPool;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        workloadGroupResourceUsageTrackerService = new WorkloadGroupResourceUsageTrackerService(taskResourceTrackingService);  
import org.opensearch.wlm.WorkloadGroupTask;
    }
        threadPool = new TestThreadPool("workload-management-tracking-thread-pool");  
import org.opensearch.threadpool.TestThreadPool;
    public void testValidWorkloadGroupTasksCase() {
        assertTrue(resourceUsageViewMap.isEmpty());
            task.setWorkloadGroupId(threadPool.getThreadContext());  
        try (ThreadContext.StoredContext context = threadPool.getThreadContext().stashContext()) {
    @Override  
import org.opensearch.action.search.SearchTask;
        // Now since this task has a valid workloadGroupId header it should be tracked  
 *
    }  
        Map<String, WorkloadGroupLevelResourceUsageView> resourceUsageViewMap = workloadGroupResourceUsageTrackerService
            resourceUsageViewMap = workloadGroupResourceUsageTrackerService.constructWorkloadGroupLevelUsageViews();
        }  
import org.opensearch.wlm.WorkloadGroupLevelResourceUsageView;
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
public class WorkloadGroupTaskResourceTrackingTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.threadpool.ThreadPool;  
    public void tearDown() throws Exception {  
        super.setUp();
import org.opensearch.core.tasks.TaskId;
import java.util.HashMap;
            Settings.EMPTY,
        taskResourceTrackingService.startTracking(task);
import java.util.Map;
        threadPool.shutdownNow();
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.common.settings.ClusterSettings;
/*  
            threadPool
