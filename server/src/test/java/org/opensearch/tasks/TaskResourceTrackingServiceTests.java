            "old_data_node",  
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);
        taskResourceTrackingService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
import org.opensearch.action.search.SearchTask;
        assertNull(threadPool.getThreadContext().getTransient(TASK_ID));
        String binaryHeader = WriteableBase64.encode(original);
        TaskId parent = new TaskId(coordinatorNodeId, randomLong());  
        assertFalse("expected binary header, got: " + headerValue, headerValue.startsWith("{"));  
        assertEquals(expected, result);
        assertTrue("expected JSON when ClusterService is null, got: " + headerValue, headerValue.startsWith("{"));
import org.opensearch.core.tasks.resourcetracker.TaskResourceInfo;
        // rather than risk a hang if the coordinator turns out to be old.  
            new ResourceUsageMetric(CPU, 100),
        // No parent task means there's no coordinator to verify against — emit JSON for safety.  
        long threadId = Thread.currentThread().threadId();
     */
import org.junit.Before;
        clusterService = ClusterServiceUtils.createClusterService(threadPool, localNode);  
    }
        noClusterService.setTaskResourceTrackingEnabled(true);
        // Operator-controlled kill switch: when disabled, the producer must emit JSON even
        threadPool.getThreadContext().putTransient(key, value);  
import java.util.concurrent.TimeUnit;
        assertEquals("node_1", result.getNodeId());  
import org.opensearch.cluster.node.DiscoveryNode;  
        );
        // when the coordinator is on the current version and would otherwise accept binary.  
            threadPool
        assertEquals(threadPool.getThreadContext().getHeader(key), value);
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
        String value = "VALUE";
        executor.shutdown();  
        assertTrue(task.getAverageResourceStats().getMemoryInBytes() < task.getMaxResourceStats().getMemoryInBytes());
        threadPool.getThreadContext().putHeader(key, value);
            threadPool,
 * SPDX-License-Identifier: Apache-2.0
        String binary = WriteableBase64.encode(expected);
    private ClusterService clusterService;
        for (int i = 0; i < numTasks; i++) {  
            new HashMap<>()  
import org.junit.After;  
    }
        // EMPTY_TASK_ID means we can't resolve a coordinator, so the producer falls back to JSON;  
        // Basic sanity testing that min < average < max < total  
        ClusterState newState = ClusterState.builder(current).nodes(updated).build();
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();  
            Settings.EMPTY,
                if (executor.awaitTermination(1, TimeUnit.MINUTES)) break;  
        return info.toString();
import org.opensearch.common.io.stream.WriteableBase64;
        );
            try {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);  
            Thread.currentThread().threadId(),
        assertTrue(task.getResourceStats().get(threadId).get(0).getResourceUsageInfo().getStatsInfo().get(MEMORY).getTotalValue() > 0);  
        task.startThreadResourceTracking(
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        TaskResourceInfo expected = new TaskResourceInfo(  
    private static String legacyJsonOf(TaskResourceInfo info) {
import org.opensearch.threadpool.TestThreadPool;
    public void testBinaryHeaderReadFromThreadContext() throws Exception {
            "indices:data/read/search[phase/query]",
    // Quadrant 4 (old data -> old coord) is the pre-PR baseline; it's exercised by prior releases'
            LOCAL_NODE_ID,  
        assertEquals(expected, result);
            ResourceStatsType.WORKER_STATS,
        );
import org.opensearch.common.util.concurrent.ThreadContext;
import java.util.Collections;  
import org.opensearch.Version;
            "indices:data/read/search[phase/query]",  
    /**  
import java.util.HashMap;
    private ThreadPool threadPool;
import org.opensearch.action.admin.cluster.node.tasks.TransportTasksActionTests;
            1L,
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
    public void testBwc_NewDataNode_OldCoordinator() {
        threadPool.getThreadContext().addResponseHeader(key, value);
            randomLong(),
        TaskResourceInfo fromOldNode = new TaskResourceInfo(
            ResourceStatsType.WORKER_STATS,  
            } catch (InterruptedException e) {
            "nodeA",  
    private static final String OLD_COORDINATOR_ID = "old_coord_node";
import org.opensearch.core.tasks.resourcetracker.ResourceStatsType;  
        task.startThreadResourceTracking(  
    public void testEmptyHeaderReturnsNull() {
        task.startThreadResourceTracking(
            version  
        assertTrue(task.getTotalResourceStats().getMemoryInBytes() > 0);
        );  
        Map<Long, List<ThreadResourceInfo>> stats = task.getResourceStats();
            Version.CURRENT
        taskResourceTrackingService.writeTaskResourceUsage(task, "node_1");
    public void testStopTrackingHandlesCurrentActiveThread() {
                // The same thread may pick up multiple runnables for the same task id
            Thread.currentThread().threadId(),
                assertTrue(info.getResourceUsageInfo().getStatsInfo().get(CPU).getTotalValue() > 0);
            "test",  
        noClusterService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
import org.opensearch.core.tasks.TaskId;
        String binary = WriteableBase64.encode(expected);
        verifyThreadContextFixedHeaders(key, value);  
import org.opensearch.cluster.node.DiscoveryNodes;
        );  
        taskResourceTrackingService.startTracking(task);
        return task;
    }
        assertNotNull(result);
        // a coordinator can read headers from data nodes that haven't yet picked up the flip.
import java.util.List;
        }
        // If the data node emits binary here, the old coordinator's IOException-only catch lets
    }
        ClusterServiceUtils.setState(clusterService, newState);
        assertTrue("expected JSON when kill switch is off, got: " + headerValue, headerValue.startsWith("{"));
        assertNotNull(result);  
            new ResourceUsageMetric(MEMORY, 100)  
            new TaskResourceUsage(1500L, 2500L)
        assertNotNull(result);  
    }
            Thread.currentThread().threadId(),
        taskResourceTrackingService.startTracking(task);  
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
            DiscoveryNodeRole.BUILT_IN_ROLES,
    }
    // tests and not reachable from this branch, so it has no test here.  
                assertTrue(info.getResourceUsageInfo().getStatsInfo().get(MEMORY).getTotalValue() > 0);  
        addCoordinatorNodeWithVersion(NEW_COORDINATOR_ID, Version.CURRENT);  
        assertTrue(headers.containsKey(TASK_RESOURCE_USAGE));  
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, binaryHeader);
        assertTrue(task.getTotalResourceStats().getCpuTimeInNanos() > 0);
        // Prepare thread context
        String key = "KEY";
    public void testBwc_NewDataNode_NewCoordinator() {
import org.opensearch.test.OpenSearchTestCase;  
            for (ThreadResourceInfo info : task.getResourceStats().get(threadId)) {
    public void testProducerEmitsJsonHeaderWhenNoParentTask() {
            new ResourceUsageMetric(CPU, 100),
        DiscoveryNode coordinator = new DiscoveryNode(
    }
            Collections.emptyMap(),
    }  
            6L,  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        assertEquals(fromOldNode, result);
        taskResourceTrackingService.startTracking(task);
        // All headers should be preserved and Task Id should also be included in thread context
        assertEquals((long) threadPool.getThreadContext().getTransient(TASK_ID), task.getId());
        taskResourceTrackingService.setBinaryResourceUsageHeaderEnabled(false);
        addCoordinatorNodeWithVersion(OLD_COORDINATOR_ID, Version.CURRENT.minimumCompatibilityVersion());
            executor.execute(() -> {
        clusterService.close();
    public void testProducerEmitsJsonHeaderWhenCoordinatorMissingFromClusterState() {
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, binary);  
        assertTrue(task.getMaxResourceStats().getMemoryInBytes() < task.getTotalResourceStats().getMemoryInBytes());  
    }
        ThreadContext.StoredContext storedContext = taskResourceTrackingService.startTracking(task);
        taskResourceTrackingService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
        noClusterService.startTracking(task);  
    }
    public void terminateThreadPool() {
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);  
            buildNewFakeTransportAddress(),  
    public void testWriteTaskResourceUsageRoundTrips() {
        task.startThreadResourceTracking(
        int numTasks = randomIntBetween(2, 100);
package org.opensearch.tasks;
            2L,
        // Coordinator's version is unknown (left the cluster, or state lag) — emit JSON for safety
        SearchShardTask task = searchShardTaskWithParent(NEW_COORDINATOR_ID);
/*  
            "test",
        String binary = WriteableBase64.encode(expected);
import org.opensearch.action.search.SearchShardTask;  
        taskResourceTrackingService.startTracking(task);  
            }  
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);
        SearchShardTask task = searchShardTaskWithParent(NEW_COORDINATOR_ID);
        task.startThreadResourceTracking(
    private TaskResourceTrackingService taskResourceTrackingService;  
        SearchShardTask task = new SearchShardTask(1, "test", "test", "task", TaskId.EMPTY_TASK_ID, new HashMap<>());
                throw new RuntimeException(e);
import org.opensearch.core.tasks.resourcetracker.ResourceUsageMetric;
        while (true) {
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
            "node_x",
                long threadId = Thread.currentThread().threadId();
        );
    private SearchShardTask searchShardTaskWithParent(String coordinatorNodeId) {
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
import java.util.Map;  
        assertFalse(task.getResourceStats().get(threadId).get(0).isActive());
        TaskResourceInfo expected = new TaskResourceInfo(
    // response header is one-way (data node -> coordinator), so the matrix is exhaustive.
    public void testThreadContextUpdateOnTrackingStart() {
        // Each execution of a runnable should record an entry in resourceStats even if it's the same thread
        assertEquals(0, task.getResourceStats().get(threadId).get(0).getResourceUsageInfo().getStatsInfo().get(MEMORY).getTotalValue());  
    }  
            nodeId,
    }  
    public void testBwc_OldDataNode_NewCoordinator() {
import static org.opensearch.core.tasks.resourcetracker.ResourceStats.MEMORY;  
        assertEquals(threadPool.getThreadContext().getTransient(key), value);  
        assertNotNull(result);  
        TaskResourceInfo expected = new TaskResourceInfo("testAction", 1L, 2L, "nodeId", new TaskResourceUsage(1000L, 2000L));
        assertTrue(task.getResourceStats().get(threadId).get(0).isActive());
        assertTrue("expected JSON header for old coordinator, got: " + headerValue, headerValue.startsWith("{"));
    }
import org.opensearch.threadpool.ThreadPool;
        );
        taskResourceTrackingService.setBinaryResourceUsageHeaderEnabled(false);
            new TaskResourceUsage(11L, 22L)
        );  
        int numExecutions = 0;  
            Settings.EMPTY,
    }
        Task task = new SearchTask(1, "test", "test", () -> "Test", TaskId.EMPTY_TASK_ID, new HashMap<>());
        for (Long threadId : stats.keySet()) {
    public void testProducerEmitsJsonHeaderWhenBinaryHeaderKillSwitchIsOff() {
        assertNull("Corrupted header should return null gracefully", result);
        }
            5L,
            Collections.emptyMap(),
        assertEquals(LOCAL_NODE_ID, result.getNodeId());
        assertNotNull(result);
            ResourceStatsType.WORKER_STATS,  
        taskResourceTrackingService.taskExecutionStartedOnThread(task.getId(), threadId);  
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        assertTrue("expected JSON when no parent task, got: " + headerValue, headerValue.startsWith("{"));
        TaskResourceInfo original = new TaskResourceInfo(
    public void testConsumerPrefersBinaryOverJsonFallback() throws Exception {  
public class TaskResourceTrackingServiceTests extends OpenSearchTestCase {
import org.opensearch.common.settings.ClusterSettings;
            clusterService
        Task task = new SearchTask(1, "test", "test", () -> "Test", TaskId.EMPTY_TASK_ID, new HashMap<>());  
        // XContentParseException escape, the shard response is silently dropped, and the search hangs.  
}
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);  
            new ResourceUsageMetric(MEMORY, 100)
 * compatible open source license.
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, "");
        ThreadContext.StoredContext storedContext = taskResourceTrackingService.startTracking(task);  
            "task",
        );
        ClusterState current = clusterService.state();
    private static final String NEW_COORDINATOR_ID = "new_coord_node";
    public void testWriteTaskResourceUsage() {
            "indices:data/read/search[phase/query]",
            "data_node",
        assertNotNull(result);  
    private void addCoordinatorNodeWithVersion(String nodeId, Version version) {  
    public void setup() {  
    }
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
            Thread.currentThread().threadId(),  
        Map<String, List<String>> headers = threadPool.getThreadContext().getResponseHeaders();
        );
    }
import org.opensearch.cluster.node.DiscoveryNodeRole;
        addCoordinatorNodeWithVersion(NEW_COORDINATOR_ID, Version.CURRENT);
import org.opensearch.common.settings.Settings;  
        storedContext.restore();  
    // Rolling-upgrade BC: one test per (data node, coordinator) quadrant. The TASK_RESOURCE_USAGE  
        // Producer must default to JSON to remain rolling-upgrade safe.  
        SearchShardTask task = new SearchShardTask(randomLong(), "test", "test", "task", TaskId.EMPTY_TASK_ID, new HashMap<>());
        SearchShardTask task = new SearchShardTask(randomLong(), "test", "test", "task", parent, new HashMap<>());
            33L,
        SearchShardTask task = new SearchShardTask(1, "test", "test", "task", TaskId.EMPTY_TASK_ID, new HashMap<>());  
    public void testProducerEmitsJsonHeaderWhenClusterServiceIsNull() {
    @After  
import static org.opensearch.core.tasks.resourcetracker.ResourceStats.CPU;
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, binary);  
            Thread.currentThread().threadId(),
        Task task = new SearchTask(1, "test", "test", () -> "Test", TaskId.EMPTY_TASK_ID, new HashMap<>());  
import org.opensearch.cluster.service.ClusterService;  
        SearchShardTask task = searchShardTaskWithParent(OLD_COORDINATOR_ID);  
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;  
    }
        assertEquals(threadPool.getThreadContext().getResponseHeaders().get(key).get(0), value);
    }  
            42L,
 *
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
            });
            7L,
 * this file be licensed under the Apache-2.0 license or a
        DiscoveryNode localNode = new DiscoveryNode(
        assertEquals(expected, result);  
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);  
    }  
        taskResourceTrackingService.startTracking(task);
        );  
        }  
        taskResourceTrackingService = new TaskResourceTrackingService(
        DiscoveryNodes updated = DiscoveryNodes.builder(current.nodes()).add(coordinator).build();  
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
            new ResourceUsageMetric(MEMORY, 100)
        taskResourceTrackingService.writeTaskResourceUsage(task, "node_1");  
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_RESOURCE_USAGE;
        assertEquals(1, headers.size());
import org.opensearch.cluster.ClusterState;
            99L,  
        );
        ExecutorService executor = threadPool.executor(ThreadPool.Names.GENERIC);
    public void testGetTaskResourceUsageFromThreadContext() throws Exception {  
import org.opensearch.test.ClusterServiceUtils;
    }  
        taskResourceTrackingService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
        terminate(threadPool);  
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        assertEquals(original, result);  
    public void testCorruptedHeaderReturnsNullGracefully() {  
            new ResourceUsageMetric(MEMORY, 100)
            ResourceStatsType.WORKER_STATS,  
                numExecutions++;  
        // Makes sure stop tracking marks the current active thread inactive and refreshes the resource stats before returning.
    }
        verifyThreadContextFixedHeaders(key, value);  
        // the consumer's JSON path must still round-trip cleanly.
    public void testStartingTrackingHandlesMultipleThreadsPerTask() throws InterruptedException {  
                assertEquals(1, task.getResourceStats().get(threadId).stream().filter(ThreadResourceInfo::isActive).count());
        // 3-arg constructor: no ClusterService, so the coordinator's version cannot be verified.
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);  
 * The OpenSearch Contributors require contributions made to  
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);
        taskResourceTrackingService.writeTaskResourceUsage(task, LOCAL_NODE_ID);  
        taskResourceTrackingService.stopTracking(task);
        assertTrue("expected JSON when coordinator is unknown, got: " + headerValue, headerValue.startsWith("{"));
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, binary);
            "indices:data/read/search[phase/query]",  
        // The kill switch only gates the producer. The consumer must still decode binary so that  
                taskResourceTrackingService.taskExecutionFinishedOnThread(task.getId(), threadId);  
     * Test if taskResourceTrackingService properly tracks resource usage when multiple threads work on the same task
            buildNewFakeTransportAddress(),
        assertEquals(numTasks, numExecutions);
    @Before
    }
        // Post restore only task id should be removed from the thread context
    private static final String LOCAL_NODE_ID = "local_node";  
        SearchShardTask task = new SearchShardTask(  
        assertTrue(task.getMinResourceStats().getMemoryInBytes() < task.getAverageResourceStats().getMemoryInBytes());
        taskResourceTrackingService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
            ResourceStatsType.WORKER_STATS,
        );
        assertNotNull(result);
            new ResourceUsageMetric(MEMORY, 100)
    private void verifyThreadContextFixedHeaders(String key, String value) {
import java.util.concurrent.ExecutorService;
    }
            new ResourceUsageMetric(CPU, 100),
            }
                assertFalse(info.isActive());
            new ResourceUsageMetric(CPU, 100),
            new ResourceUsageMetric(CPU, 100),  
        assertNull(result);
 */  
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, legacyJsonOf(fromOldNode));  
        threadPool = new TestThreadPool(TransportTasksActionTests.class.getSimpleName(), new AtomicReference<>());
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, "not-valid-base64!!!");
            new TaskResourceUsage(1000L, 2000L)
        );  
    }
import java.util.concurrent.atomic.AtomicReference;  
        SearchShardTask task = searchShardTaskWithParent("ghost_coordinator");
        TaskResourceTrackingService noClusterService = new TaskResourceTrackingService(
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_ID;
            DiscoveryNodeRole.BUILT_IN_ROLES,  
            new TaskResourceUsage(7777L, 8888L)  
                taskResourceTrackingService.taskExecutionStartedOnThread(task.getId(), threadId);  
    public void testConsumerStillReadsBinaryWhenKillSwitchIsOff() throws Exception {
            new TaskId(NEW_COORDINATOR_ID, randomLong()),
