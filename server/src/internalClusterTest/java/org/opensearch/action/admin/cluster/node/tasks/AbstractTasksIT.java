    /**
        assertNull(info.getStatus()); // The test task doesn't have any status
import org.opensearch.action.support.WriteRequest;
            if (actionMasks == null || entry.getKey().v2().equals(actionMasks)) {  
                .setId("test_id_" + String.valueOf(i))  
import org.opensearch.transport.TransportService;  
     */
import org.opensearch.ExceptionsHelper;
        for (Map.Entry<Tuple<String, String>, RecordingTaskManagerListener> entry : listeners.entrySet()) {
import java.io.IOException;
            }  
    }  
        }
        return events;
abstract class AbstractTasksIT extends OpenSearchIntegTestCase {
    }  
        for (int i = 0; i < numDocs; i++) {
    }
        }
        return Arrays.asList(MockTransportService.TestPlugin.class, TestTaskPlugin.class);  
import org.opensearch.cluster.node.DiscoveryNode;
     */  
        assertEquals(parentTask.getTaskId().getNodeId(), task.getParentTaskId().getNodeId());
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
import org.opensearch.ResourceNotFoundException;
        ResourceNotFoundException notFound = (ResourceNotFoundException) ExceptionsHelper.unwrap(e, ResourceNotFoundException.class);
    protected void registerTaskManagerListeners(String actionMasks) {
        super.tearDown();
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    /**
     * Resets all recording task event listeners with the given action mask on all nodes  
    protected List<TaskInfo> findEvents(String actionMasks, Function<Tuple<Boolean, TaskInfo>, Boolean> criteria) {
    @Override  
            client().prepareIndex(indexName)
 * SPDX-License-Identifier: Apache-2.0
            .put(super.nodeSettings(nodeOrdinal))  
 */
import java.util.Collection;
    }
        return Settings.builder()
        Exception e = expectThrows(Exception.class, r);
     * about the fetched task and returns a map of it's status.
    }
    protected Map<Long, List<ThreadResourceInfo>> getThreadStats(String actionMasks, TaskId taskId) {
        assertEquals(taskId, info.getTaskId());
    }
    protected int numberOfEvents(String actionMasks, Function<Tuple<Boolean, TaskInfo>, Boolean> criteria) {
            RecordingTaskManagerListener oldListener = listeners.put(new Tuple<>(node.getName(), actionMasks), listener);  
    }
        mockPlugins.remove(MockTransportService.TestPlugin.class);  
 * The OpenSearch Contributors require contributions made to  
                entry.getValue().reset();
                    }  
            .put(MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING.getKey(), true)
    /**
        for (TaskInfo task : tasks) {  
    }  
     * Returns all events that satisfy the criteria across all nodes  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            RecordingTaskManagerListener listener = new RecordingTaskManagerListener(node.getId(), actionMasks.split(","));
import org.opensearch.test.transport.MockTransportService;
        TaskInfo info = response.getTask().getTask();  
    protected void assertParentTask(TaskInfo task, TaskInfo parentTask) {
                    if (taskId.equals(threadStats.v1())) {
import java.util.ArrayList;  
     */
        if (notFound == null) {  
                for (Tuple<TaskId, Map<Long, List<ThreadResourceInfo>>> threadStats : entry.getValue().getThreadStats()) {
import java.util.Map;
            .build();
                    if (criteria.apply(taskEvent)) {
            );
import org.opensearch.test.tasks.MockTaskManager;
import org.opensearch.plugins.Plugin;
import org.opensearch.cluster.service.ClusterService;  
     */
import org.opensearch.core.tasks.TaskId;
        GetTaskResponse response = client().admin().cluster().prepareGetTask(taskId).get();
            if (actionMasks == null || entry.getKey().v2().equals(actionMasks)) {
    @Override  
import java.util.HashMap;  
                    }
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;  
            if (actionMasks == null || entry.getKey().v2().equals(actionMasks)) {
            assertParentTask(task, parentTask);
    protected GetTaskResponse expectFinishedTask(TaskId taskId) throws IOException {  
        return findEvents(actionMasks, criteria).size();
    /**
    public void tearDown() throws Exception {  
            }  
                entry.getValue()  
    }
     */
            }
    /**
     * @param actionMasks action masks to match
     */  
 * Base IT test class for Tasks ITs  
    @Override
import java.util.function.Function;  
import org.opensearch.test.OpenSearchIntegTestCase;  
import org.opensearch.core.common.Strings;  
     * @param actionMasks action masks to match
            ((MockTaskManager) internalCluster().getInstance(TransportService.class, entry.getKey().v1()).getTaskManager()).removeListener(
                }
                        return threadStats.v2();  
            assertNull(oldListener);
        }
        for (Map.Entry<Tuple<String, String>, RecordingTaskManagerListener> entry : listeners.entrySet()) {
        }
            ((MockTaskManager) internalCluster().getInstance(TransportService.class, nodeName).getTaskManager()).addListener(listener);
    }  
        }
        }
     *  
            throw new AssertionError("Expected " + ResourceNotFoundException.class.getSimpleName(), e);
        for (String nodeName : internalCluster().getNodeNames()) {
        for (Map.Entry<Tuple<String, String>, RecordingTaskManagerListener> entry : listeners.entrySet()) {  
import org.opensearch.common.settings.Settings;
        assertTrue("the task should have been completed before fetching", response.getTask().isCompleted());
 */  
package org.opensearch.action.admin.cluster.node.tasks;
        Collection<Class<? extends Plugin>> mockPlugins = new ArrayList<>(super.getMockPlugins());
    /**
import java.util.List;
        return new HashMap<>();
    protected void resetTaskManagerListeners(String actionMasks) {
    protected void assertParentTask(List<TaskInfo> tasks, TaskInfo parentTask) {
        assertEquals(parentTask.getId(), task.getParentTaskId().getId());  
        List<TaskInfo> events = new ArrayList<>();  
        return mockPlugins;
 * this file be licensed under the Apache-2.0 license or a
        return response;  
        for (Map.Entry<Tuple<String, String>, RecordingTaskManagerListener> entry : listeners.entrySet()) {
import org.opensearch.tasks.TaskInfo;
     * Registers recording task event listeners with the given action mask on all nodes
                for (Tuple<Boolean, TaskInfo> taskEvent : entry.getValue().getEvents()) {  
    }  
        listeners.clear();  
 *
    }  
     * Asserts that all tasks in the tasks list have the same parentTask  
                }
import org.opensearch.common.collect.Tuple;
        }
    protected void indexDocumentsWithRefresh(String indexName, int numDocs) {  
     * @return number of events that satisfy the criteria
        assertTrue(Strings.hasLength(task.getParentTaskId().getNodeId()));
        }  
            DiscoveryNode node = internalCluster().getInstance(ClusterService.class, nodeName).localNode();  
        assertTrue(task.getParentTaskId().isSet());  
 * compatible open source license.
/**
     * @return List of events that satisfy the criteria  
     *
    protected Map<Tuple<String, String>, RecordingTaskManagerListener> listeners = new HashMap<>();
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
import java.util.Arrays;
    protected Collection<Class<? extends Plugin>> getMockPlugins() {
                .setSource("{\"foo_" + String.valueOf(i) + "\": \"bar_" + String.valueOf(i) + "\"}", MediaTypeRegistry.JSON)
    @Override
                .get();  
    }
}  
    protected Settings nodeSettings(int nodeOrdinal) {
     * Fetch the task status from the list tasks API using it's "fallback to get from the task index" behavior. Asserts some obvious stuff  
     * Returns the number of events that satisfy the criteria across all nodes
    protected void expectNotFound(ThrowingRunnable r) {  
                        events.add(taskEvent.v2());
    }
/*  
