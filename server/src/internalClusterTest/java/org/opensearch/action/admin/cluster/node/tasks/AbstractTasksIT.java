import org.opensearch.cluster.node.DiscoveryNode;
        }
        for (Map.Entry<Tuple<String, String>, RecordingTaskManagerListener> entry : listeners.entrySet()) {
        listeners.clear();
            RecordingTaskManagerListener listener = new RecordingTaskManagerListener(node.getId(), actionMasks.split(","));
        }
     * @param actionMasks action masks to match
                        return threadStats.v2();
     */
    /**
import org.opensearch.ResourceNotFoundException;
    protected GetTaskResponse expectFinishedTask(TaskId taskId) throws IOException {
        return events;
     */
        }
        assertTrue("the task should have been completed before fetching", response.getTask().isCompleted());
    /**
            if (actionMasks == null || entry.getKey().v2().equals(actionMasks)) {
            RecordingTaskManagerListener oldListener = listeners.put(new Tuple<>(node.getName(), actionMasks), listener);
            DiscoveryNode node = internalCluster().getInstance(ClusterService.class, nodeName).localNode();
    protected Settings nodeSettings(int nodeOrdinal) {
    }
     * about the fetched task and returns a map of it's status.
    /**
        Exception e = expectThrows(Exception.class, r);
                    if (taskId.equals(threadStats.v1())) {
        assertTrue(task.getParentTaskId().isSet());
        }
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
     * Resets all recording task event listeners with the given action mask on all nodes
import org.opensearch.tasks.TaskInfo;
            }
    protected Map<Long, List<ThreadResourceInfo>> getThreadStats(String actionMasks, TaskId taskId) {
                }
     */
     * Returns the number of events that satisfy the criteria across all nodes
    protected void assertParentTask(TaskInfo task, TaskInfo parentTask) {
     *
                for (Tuple<TaskId, Map<Long, List<ThreadResourceInfo>>> threadStats : entry.getValue().getThreadStats()) {
     * @param actionMasks action masks to match
    }
     * Asserts that all tasks in the tasks list have the same parentTask
    }
import java.util.List;
     * Registers recording task event listeners with the given action mask on all nodes
        return findEvents(actionMasks, criteria).size();
     */
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
            .put(MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING.getKey(), true)
            }
                .setId("test_id_" + String.valueOf(i))
    /**
                .get();
import org.opensearch.core.xcontent.MediaTypeRegistry;
                .setSource("{\"foo_" + String.valueOf(i) + "\": \"bar_" + String.valueOf(i) + "\"}", MediaTypeRegistry.JSON)
        for (TaskInfo task : tasks) {
        for (Map.Entry<Tuple<String, String>, RecordingTaskManagerListener> entry : listeners.entrySet()) {
import org.opensearch.test.transport.MockTransportService;
abstract class AbstractTasksIT extends OpenSearchIntegTestCase {
    @Override
import java.util.function.Function;
    public void tearDown() throws Exception {
import java.util.Map;
    protected void assertParentTask(List<TaskInfo> tasks, TaskInfo parentTask) {
    protected void expectNotFound(ThrowingRunnable r) {
 */
import org.opensearch.test.OpenSearchIntegTestCase;
                }
    }
    protected void registerTaskManagerListeners(String actionMasks) {
        for (String nodeName : internalCluster().getNodeNames()) {
     * @return List of events that satisfy the criteria
    }
import java.util.Collection;
        return response;
    protected void resetTaskManagerListeners(String actionMasks) {
            assertParentTask(task, parentTask);
        for (Map.Entry<Tuple<String, String>, RecordingTaskManagerListener> entry : listeners.entrySet()) {
    }
        List<TaskInfo> events = new ArrayList<>();
        TaskInfo info = response.getTask().getTask();
import java.util.Arrays;
import org.opensearch.core.common.Strings;
        return Arrays.asList(MockTransportService.TestPlugin.class, TestTaskPlugin.class);
            if (actionMasks == null || entry.getKey().v2().equals(actionMasks)) {
            }
        assertNull(info.getStatus()); // The test task doesn't have any status
                        events.add(taskEvent.v2());
                for (Tuple<Boolean, TaskInfo> taskEvent : entry.getValue().getEvents()) {
    }
import org.opensearch.transport.TransportService;
                entry.getValue()
import java.util.ArrayList;
import java.util.HashMap;
     * @return number of events that satisfy the criteria
        super.tearDown();
                    if (criteria.apply(taskEvent)) {
        Collection<Class<? extends Plugin>> mockPlugins = new ArrayList<>(super.getMockPlugins());
 * The OpenSearch Contributors require contributions made to
 * Base IT test class for Tasks ITs
     */
            .build();
/*
            ((MockTaskManager) internalCluster().getInstance(TransportService.class, nodeName).getTaskManager()).addListener(listener);
    }
        assertEquals(parentTask.getId(), task.getParentTaskId().getId());
        ResourceNotFoundException notFound = (ResourceNotFoundException) ExceptionsHelper.unwrap(e, ResourceNotFoundException.class);
import org.opensearch.ExceptionsHelper;
        if (notFound == null) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        return new HashMap<>();
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;
import org.opensearch.plugins.Plugin;
            .put(super.nodeSettings(nodeOrdinal))
        assertEquals(parentTask.getTaskId().getNodeId(), task.getParentTaskId().getNodeId());
        }
            assertNull(oldListener);
     *
                    }
        }
    /**
        }
    }
    protected void indexDocumentsWithRefresh(String indexName, int numDocs) {
import org.opensearch.common.settings.Settings;
    }
    protected Collection<Class<? extends Plugin>> getMockPlugins() {
        for (Map.Entry<Tuple<String, String>, RecordingTaskManagerListener> entry : listeners.entrySet()) {
import org.opensearch.core.tasks.TaskId;
        assertTrue(Strings.hasLength(task.getParentTaskId().getNodeId()));
        mockPlugins.remove(MockTransportService.TestPlugin.class);
     * Fetch the task status from the list tasks API using it's "fallback to get from the task index" behavior. Asserts some obvious stuff
    }
import org.opensearch.common.collect.Tuple;
}
package org.opensearch.action.admin.cluster.node.tasks;
 */
    }
            throw new AssertionError("Expected " + ResourceNotFoundException.class.getSimpleName(), e);
    }
    @Override
        return mockPlugins;
    /**
                    }
    }
    @Override
import org.opensearch.test.tasks.MockTaskManager;
import org.opensearch.action.support.WriteRequest;
     */
            client().prepareIndex(indexName)
            if (actionMasks == null || entry.getKey().v2().equals(actionMasks)) {
            ((MockTaskManager) internalCluster().getInstance(TransportService.class, entry.getKey().v1()).getTaskManager()).removeListener(
import java.io.IOException;
     * Returns all events that satisfy the criteria across all nodes
        }
        assertEquals(taskId, info.getTaskId());
                entry.getValue().reset();
        GetTaskResponse response = client().admin().cluster().prepareGetTask(taskId).get();
    protected List<TaskInfo> findEvents(String actionMasks, Function<Tuple<Boolean, TaskInfo>, Boolean> criteria) {
 * this file be licensed under the Apache-2.0 license or a
/**
    @Override
        return Settings.builder()
import org.opensearch.cluster.service.ClusterService;
 *
    protected Map<Tuple<String, String>, RecordingTaskManagerListener> listeners = new HashMap<>();
    protected int numberOfEvents(String actionMasks, Function<Tuple<Boolean, TaskInfo>, Boolean> criteria) {
            );
