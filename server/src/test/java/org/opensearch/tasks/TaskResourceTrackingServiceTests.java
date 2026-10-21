import org.opensearch.threadpool.TestThreadPool;
        taskResourceTrackingService.startTracking(task);
        Task task = new SearchTask(1, "test", "test", () -> "Test", TaskId.EMPTY_TASK_ID, new HashMap<>());
    public void terminateThreadPool() {
        task.startThreadResourceTracking(
        executor.shutdown();
 * this file be licensed under the Apache-2.0 license or a
        // XContentParseException escape, the shard response is silently dropped, and the search hangs.
        SearchShardTask task = new SearchShardTask(1, "test", "test", "task", TaskId.EMPTY_TASK_ID, new HashMap<>());
        taskResourceTrackingService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
            1L,
        assertNotNull(result);
                long threadId = Thread.currentThread().threadId();
                // The same thread may pick up multiple runnables for the same task id
        ClusterServiceUtils.setState(clusterService, newState);
        ClusterState newState = ClusterState.builder(current).nodes(updated).build();
            }
            new ResourceUsageMetric(CPU, 100),
}
        );
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);
        // 3-arg constructor: no ClusterService, so the coordinator's version cannot be verified.
        DiscoveryNode localNode = new DiscoveryNode(
        }
    public void testEmptyHeaderReturnsNull() {
        verifyThreadContextFixedHeaders(key, value);
            Settings.EMPTY,
            "test",
            DiscoveryNodeRole.BUILT_IN_ROLES,
            ResourceStatsType.WORKER_STATS,
    }
    public void testBwc_NewDataNode_NewCoordinator() {
import org.junit.After;
        );
import static org.opensearch.core.tasks.resourcetracker.ResourceStats.MEMORY;
        int numExecutions = 0;
        // Operator-controlled kill switch: when disabled, the producer must emit JSON even
        addCoordinatorNodeWithVersion(NEW_COORDINATOR_ID, Version.CURRENT);
    }
    }
        TaskResourceInfo expected = new TaskResourceInfo(
import org.junit.Before;
        return task;
    }
        task.startThreadResourceTracking(
            new TaskResourceUsage(1500L, 2500L)
        Map<String, List<String>> headers = threadPool.getThreadContext().getResponseHeaders();
            new ResourceUsageMetric(CPU, 100),
        TaskResourceInfo expected = new TaskResourceInfo("testAction", 1L, 2L, "nodeId", new TaskResourceUsage(1000L, 2000L));
            }
            33L,
        DiscoveryNodes updated = DiscoveryNodes.builder(current.nodes()).add(coordinator).build();
        assertEquals(fromOldNode, result);
        for (int i = 0; i < numTasks; i++) {
        Map<Long, List<ThreadResourceInfo>> stats = task.getResourceStats();
        TaskResourceInfo original = new TaskResourceInfo(
        storedContext.restore();
            "data_node",
        ClusterState current = clusterService.state();
            } catch (InterruptedException e) {
        SearchShardTask task = new SearchShardTask(randomLong(), "test", "test", "task", parent, new HashMap<>());
    private static final String OLD_COORDINATOR_ID = "old_coord_node";
        return info.toString();
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        taskResourceTrackingService.setBinaryResourceUsageHeaderEnabled(false);
import org.opensearch.action.search.SearchShardTask;
    private void verifyThreadContextFixedHeaders(String key, String value) {
        taskResourceTrackingService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
            "indices:data/read/search[phase/query]",
    }
public class TaskResourceTrackingServiceTests extends OpenSearchTestCase {
        // the consumer's JSON path must still round-trip cleanly.
    }
        assertTrue(task.getResourceStats().get(threadId).get(0).isActive());
            new ResourceUsageMetric(CPU, 100),
        assertTrue("expected JSON when ClusterService is null, got: " + headerValue, headerValue.startsWith("{"));
        taskResourceTrackingService.startTracking(task);
            "task",
        );
    public void testBwc_OldDataNode_NewCoordinator() {
            2L,
            6L,
        clusterService = ClusterServiceUtils.createClusterService(threadPool, localNode);
        // No parent task means there's no coordinator to verify against — emit JSON for safety.
     * Test if taskResourceTrackingService properly tracks resource usage when multiple threads work on the same task
        task.startThreadResourceTracking(
package org.opensearch.tasks;
import java.util.Collections;
            5L,
    private ThreadPool threadPool;
        );
        assertEquals(1, headers.size());
    // tests and not reachable from this branch, so it has no test here.
        Task task = new SearchTask(1, "test", "test", () -> "Test", TaskId.EMPTY_TASK_ID, new HashMap<>());
        assertEquals((long) threadPool.getThreadContext().getTransient(TASK_ID), task.getId());
        assertTrue("expected JSON when coordinator is unknown, got: " + headerValue, headerValue.startsWith("{"));
    public void testConsumerPrefersBinaryOverJsonFallback() throws Exception {
        ThreadContext.StoredContext storedContext = taskResourceTrackingService.startTracking(task);
        assertTrue(task.getMaxResourceStats().getMemoryInBytes() < task.getTotalResourceStats().getMemoryInBytes());
            new ResourceUsageMetric(MEMORY, 100)
        // Prepare thread context
                throw new RuntimeException(e);
            new ResourceUsageMetric(MEMORY, 100)
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
            for (ThreadResourceInfo info : task.getResourceStats().get(threadId)) {
        noClusterService.startTracking(task);
        threadPool.getThreadContext().putTransient(key, value);
 */
                assertTrue(info.getResourceUsageInfo().getStatsInfo().get(CPU).getTotalValue() > 0);
            "old_data_node",
            ResourceStatsType.WORKER_STATS,
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);
        verifyThreadContextFixedHeaders(key, value);
import org.opensearch.core.tasks.resourcetracker.ResourceUsageMetric;
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        Task task = new SearchTask(1, "test", "test", () -> "Test", TaskId.EMPTY_TASK_ID, new HashMap<>());
            Collections.emptyMap(),
        // EMPTY_TASK_ID means we can't resolve a coordinator, so the producer falls back to JSON;
            randomLong(),
        // The kill switch only gates the producer. The consumer must still decode binary so that
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
            Version.CURRENT
            threadPool,
            DiscoveryNodeRole.BUILT_IN_ROLES,
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.node.DiscoveryNodes;
 * SPDX-License-Identifier: Apache-2.0
    public void testProducerEmitsJsonHeaderWhenBinaryHeaderKillSwitchIsOff() {
        String key = "KEY";
    private static String legacyJsonOf(TaskResourceInfo info) {
        taskResourceTrackingService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
        assertTrue("expected JSON when no parent task, got: " + headerValue, headerValue.startsWith("{"));
        );
        // Coordinator's version is unknown (left the cluster, or state lag) — emit JSON for safety
            new ResourceUsageMetric(MEMORY, 100)
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
        int numTasks = randomIntBetween(2, 100);
        );
            "indices:data/read/search[phase/query]",
        SearchShardTask task = new SearchShardTask(1, "test", "test", "task", TaskId.EMPTY_TASK_ID, new HashMap<>());
            ResourceStatsType.WORKER_STATS,
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
        assertTrue("expected JSON header for old coordinator, got: " + headerValue, headerValue.startsWith("{"));
    }
        taskResourceTrackingService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        // Each execution of a runnable should record an entry in resourceStats even if it's the same thread
import org.opensearch.cluster.service.ClusterService;
            Thread.currentThread().threadId(),
    }
import org.opensearch.threadpool.ThreadPool;
        assertEquals(expected, result);
        assertTrue("expected JSON when kill switch is off, got: " + headerValue, headerValue.startsWith("{"));
    public void testWriteTaskResourceUsageRoundTrips() {
            new TaskResourceUsage(7777L, 8888L)
    public void testBinaryHeaderReadFromThreadContext() throws Exception {
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
            7L,
            Settings.EMPTY,
    private static final String LOCAL_NODE_ID = "local_node";
        // when the coordinator is on the current version and would otherwise accept binary.
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        for (Long threadId : stats.keySet()) {
    public void testStartingTrackingHandlesMultipleThreadsPerTask() throws InterruptedException {
        noClusterService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
import org.opensearch.cluster.node.DiscoveryNodeRole;
    }
    public void testProducerEmitsJsonHeaderWhenClusterServiceIsNull() {
            Thread.currentThread().threadId(),
    }
import java.util.concurrent.ExecutorService;
        // Post restore only task id should be removed from the thread context
        assertEquals(threadPool.getThreadContext().getResponseHeaders().get(key).get(0), value);
import org.opensearch.action.search.SearchTask;
        SearchShardTask task = searchShardTaskWithParent(OLD_COORDINATOR_ID);
                if (executor.awaitTermination(1, TimeUnit.MINUTES)) break;
        task.startThreadResourceTracking(
    public void testProducerEmitsJsonHeaderWhenNoParentTask() {
    public void testStopTrackingHandlesCurrentActiveThread() {
        terminate(threadPool);
    }
        taskResourceTrackingService.taskExecutionStartedOnThread(task.getId(), threadId);
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);
        taskResourceTrackingService.writeTaskResourceUsage(task, LOCAL_NODE_ID);
        String binaryHeader = WriteableBase64.encode(original);
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);
    public void testWriteTaskResourceUsage() {
        // If the data node emits binary here, the old coordinator's IOException-only catch lets
        String binary = WriteableBase64.encode(expected);
 * The OpenSearch Contributors require contributions made to
            executor.execute(() -> {
        SearchShardTask task = searchShardTaskWithParent(NEW_COORDINATOR_ID);
    private static final String NEW_COORDINATOR_ID = "new_coord_node";
    @Before
        assertEquals(threadPool.getThreadContext().getTransient(key), value);
    // response header is one-way (data node -> coordinator), so the matrix is exhaustive.
        threadPool.getThreadContext().putHeader(key, value);
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, binary);
/*
            Thread.currentThread().threadId(),
        assertEquals(LOCAL_NODE_ID, result.getNodeId());
        taskResourceTrackingService.startTracking(task);
    private void addCoordinatorNodeWithVersion(String nodeId, Version version) {
import org.opensearch.core.tasks.resourcetracker.ResourceStatsType;
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
import org.opensearch.common.io.stream.WriteableBase64;
            new TaskResourceUsage(11L, 22L)
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        assertFalse(task.getResourceStats().get(threadId).get(0).isActive());
import org.opensearch.cluster.ClusterState;
        assertFalse("expected binary header, got: " + headerValue, headerValue.startsWith("{"));
            nodeId,
        assertEquals(original, result);
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.concurrent.atomic.AtomicReference;
            Collections.emptyMap(),
            buildNewFakeTransportAddress(),
        }
    }
    // Quadrant 4 (old data -> old coord) is the pre-PR baseline; it's exercised by prior releases'
        TaskResourceTrackingService noClusterService = new TaskResourceTrackingService(
     */
    public void testCorruptedHeaderReturnsNullGracefully() {
    }
        assertTrue(task.getResourceStats().get(threadId).get(0).getResourceUsageInfo().getStatsInfo().get(MEMORY).getTotalValue() > 0);
    private ClusterService clusterService;
        DiscoveryNode coordinator = new DiscoveryNode(
        assertNotNull(result);
 * compatible open source license.
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, binary);
    }
        SearchShardTask task = searchShardTaskWithParent(NEW_COORDINATOR_ID);
        assertNull(threadPool.getThreadContext().getTransient(TASK_ID));
        addCoordinatorNodeWithVersion(OLD_COORDINATOR_ID, Version.CURRENT.minimumCompatibilityVersion());
        assertNull("Corrupted header should return null gracefully", result);
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
        assertEquals(threadPool.getThreadContext().getHeader(key), value);
        taskResourceTrackingService.setBinaryResourceUsageHeaderEnabled(false);
        taskResourceTrackingService.writeTaskResourceUsage(task, "node_1");
            Thread.currentThread().threadId(),
        assertTrue(headers.containsKey(TASK_RESOURCE_USAGE));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        taskResourceTrackingService.stopTracking(task);
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);
        assertNotNull(result);
            clusterService
import org.opensearch.common.settings.Settings;
        taskResourceTrackingService = new TaskResourceTrackingService(
        assertEquals(0, task.getResourceStats().get(threadId).get(0).getResourceUsageInfo().getStatsInfo().get(MEMORY).getTotalValue());
import org.opensearch.Version;
        ExecutorService executor = threadPool.executor(ThreadPool.Names.GENERIC);
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
            threadPool
        assertEquals("node_1", result.getNodeId());
        taskResourceTrackingService.writeTaskResourceUsage(task, "node_1");
        assertTrue(task.getTotalResourceStats().getCpuTimeInNanos() > 0);
    @After
        assertNull(result);
        TaskResourceInfo expected = new TaskResourceInfo(
            });
    public void testThreadContextUpdateOnTrackingStart() {
            new ResourceUsageMetric(CPU, 100),
        noClusterService.setTaskResourceTrackingEnabled(true);
        TaskId parent = new TaskId(coordinatorNodeId, randomLong());
    public void testProducerEmitsJsonHeaderWhenCoordinatorMissingFromClusterState() {
        // a coordinator can read headers from data nodes that haven't yet picked up the flip.
        assertNotNull(result);
            new ResourceUsageMetric(MEMORY, 100)
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
        }
            Thread.currentThread().threadId(),
        assertNotNull(result);
    /**
        assertNotNull(result);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        );
        addCoordinatorNodeWithVersion(NEW_COORDINATOR_ID, Version.CURRENT);
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
import org.opensearch.core.tasks.resourcetracker.TaskResourceInfo;
    }
        SearchShardTask task = new SearchShardTask(randomLong(), "test", "test", "task", TaskId.EMPTY_TASK_ID, new HashMap<>());
    }
        taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
    }
            99L,
            new ResourceUsageMetric(CPU, 100),
        assertNotNull(result);
        String binary = WriteableBase64.encode(expected);
            ResourceStatsType.WORKER_STATS,
    }
        );
        assertEquals(numTasks, numExecutions);
        threadPool.getThreadContext().addResponseHeader(key, value);
        clusterService.close();
        String binary = WriteableBase64.encode(expected);
    // Rolling-upgrade BC: one test per (data node, coordinator) quadrant. The TASK_RESOURCE_USAGE
    private SearchShardTask searchShardTaskWithParent(String coordinatorNodeId) {
import org.opensearch.action.admin.cluster.node.tasks.TransportTasksActionTests;
    }
import org.opensearch.core.tasks.TaskId;
                assertFalse(info.isActive());
            "indices:data/read/search[phase/query]",
        threadPool = new TestThreadPool(TransportTasksActionTests.class.getSimpleName(), new AtomicReference<>());
        TaskResourceInfo fromOldNode = new TaskResourceInfo(
        // Makes sure stop tracking marks the current active thread inactive and refreshes the resource stats before returning.
            "indices:data/read/search[phase/query]",
    public void setup() {
            try {
import org.opensearch.common.settings.ClusterSettings;
        );
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, binaryHeader);
import java.util.List;
                numExecutions++;
            new TaskResourceUsage(1000L, 2000L)
        SearchShardTask task = searchShardTaskWithParent("ghost_coordinator");
        assertTrue(task.getAverageResourceStats().getMemoryInBytes() < task.getMaxResourceStats().getMemoryInBytes());
        taskResourceTrackingService.startTracking(task);
    }
    }
import java.util.HashMap;
import java.util.Map;
                taskResourceTrackingService.taskExecutionFinishedOnThread(task.getId(), threadId);
        String value = "VALUE";
            "node_x",
        // rather than risk a hang if the coordinator turns out to be old.
            buildNewFakeTransportAddress(),
            ResourceStatsType.WORKER_STATS,
        SearchShardTask task = new SearchShardTask(
            new HashMap<>()
        task.startThreadResourceTracking(
        );
    public void testBwc_NewDataNode_OldCoordinator() {
    private TaskResourceTrackingService taskResourceTrackingService;
        );
    }
import static org.opensearch.core.tasks.resourcetracker.ResourceStats.CPU;
            version
        // Producer must default to JSON to remain rolling-upgrade safe.
                taskResourceTrackingService.taskExecutionStartedOnThread(task.getId(), threadId);
        while (true) {
        String headerValue = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE).get(0);
            42L,
            new TaskId(NEW_COORDINATOR_ID, randomLong()),
    public void testConsumerStillReadsBinaryWhenKillSwitchIsOff() throws Exception {
        );
        );
        ThreadContext.StoredContext storedContext = taskResourceTrackingService.startTracking(task);
import org.opensearch.common.util.concurrent.ThreadContext;
            "nodeA",
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, "not-valid-base64!!!");
        assertEquals(expected, result);
    public void testGetTaskResourceUsageFromThreadContext() throws Exception {
            "test",
            new ResourceUsageMetric(MEMORY, 100)
                assertTrue(info.getResourceUsageInfo().getStatsInfo().get(MEMORY).getTotalValue() > 0);
import java.util.concurrent.TimeUnit;
                assertEquals(1, task.getResourceStats().get(threadId).stream().filter(ThreadResourceInfo::isActive).count());
        TaskResourceInfo result = taskResourceTrackingService.getTaskResourceUsageFromThreadContext();
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, binary);
        taskResourceTrackingService.startTracking(task);
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, "");
    }
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, legacyJsonOf(fromOldNode));
            LOCAL_NODE_ID,
        assertTrue(task.getMinResourceStats().getMemoryInBytes() < task.getAverageResourceStats().getMemoryInBytes());
 *
        );
        // Basic sanity testing that min < average < max < total
    }
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_ID;
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_RESOURCE_USAGE;
        long threadId = Thread.currentThread().threadId();
        assertTrue(task.getTotalResourceStats().getMemoryInBytes() > 0);
        // All headers should be preserved and Task Id should also be included in thread context
import org.opensearch.test.ClusterServiceUtils;
        assertEquals(expected, result);
