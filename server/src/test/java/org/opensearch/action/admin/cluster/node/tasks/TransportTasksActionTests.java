        assertEquals(testNodes.length, response.getPerNodeTasks().size());  
            }
                    String[] superNodes = super.filterNodeIds(nodes, nodesIds);
            );
            super(in);
        response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
        assertThat(response.getTaskFailures().get(0).getCause().getMessage(), containsString("Task level failure"));
        String[] allNodes = new String[testNodes.length];
import org.opensearch.tasks.TaskInfo;
        @Override
        request.setActions(actionName);
        Set<String> filterNodes = new HashSet<>(randomSubsetOf(filterNodesSize, allNodes));
                    }
        // Shouldn't match any tasks since testAction doesn't support cancellation
    /**
                        listener.onResponse(new TestTaskResponse(testNodes[node].getNodeId()));
        assertEquals(0, response.getNodeFailures().size());
                .collect(Collectors.joining(","))  
 * Unless required by applicable law or agreed to in writing,
        PlainActionFuture<NodesResponse> future = newFuture();
import static org.hamcrest.Matchers.not;
    /**
    }
    }
     * Test class for testing task operations
                new ActionFilters(new HashSet<>()),
        }
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportListTasksAction,
        public String getDescription() {  
        }
        @Override  
        ) {  
        TestNode testNode = testNodes[randomIntBetween(0, testNodes.length - 1)];
            final int node = i;
import org.opensearch.transport.TransportService;
                            threadPool.generic()
        TestTasksResponse(
                clusterService,  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
        checkLatch.countDown();
    public void testFailedTasksCount() throws ExecutionException, InterruptedException, IOException {
                }  
    abstract static class TestTasksAction extends TransportTasksAction<Task, TestTasksRequest, TestTasksResponse, TestTaskResponse> {
        request = new CancelTasksRequest();
                "internal:testAction",  
            super(in);
            return super.createTask(id, type, action, parentTaskId, headers);  
        }  
                }
import java.util.Collections;  
        CountDownLatch checkLatch = new CountDownLatch(1);  
                    }
                    return filteredNodes.toArray(new String[0]);
        ListTasksRequest listTasksRequest = new ListTasksRequest();
            super.writeTo(out);
    private Task startBlockingTestNodesAction(CountDownLatch checkLatch, NodesRequest request, ActionListener<NodesResponse> listener)
        // Verify that tasks are marked as non-cancellable  
    private ActionFuture<NodesResponse> startBlockingTestNodesAction(CountDownLatch checkLatch) throws InterruptedException {
        ActionFuture<NodesResponse> future = startBlockingTestNodesAction(checkLatch);
        assertEquals(2, listeners[0].getRegistrationEvents().size());  
            public void onResponse(NodesResponse listTasksResponse) {
import org.opensearch.common.settings.Settings;  
        }
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        }
        Task mainTask = startBlockingTestNodesAction(checkLatch, new ActionListener<NodesResponse>() {  
import org.opensearch.action.support.tasks.BaseTasksRequest;  
            actions[i] = new TestNodesAction(  
        return XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
            response.toXContentGroupedByNode(builder, ToXContent.EMPTY_PARAMS, nodes);
            List<TaskOperationFailure> taskOperationFailures,
            List<? extends FailedNodeException> nodeFailures
 *
        @Override
        }  
        );
                    try {  
                protected void taskOperation(TestTasksRequest request, Task task, ActionListener<TestTaskResponse> listener) {
                            threadPool.generic().execute(() -> listener.onResponse(new TestTaskResponse("Success on node (async)" + node)));
        // Check task counts using transport with detailed description  
                }
        Task task = actions[0].execute(request, listener);
            };
            listTasksRequest  
    static class TestTaskResponse implements Writeable {  
    }
                    logger.info("Action on node {} finished", node);
    private ActionFuture<NodesResponse> startBlockingTestNodesAction(CountDownLatch checkLatch, NodesRequest request)
    public void testFindChildTasks() throws Exception {
        for (TaskInfo taskInfo : listResponse.getTasks()) {
    }
        response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
        listTasksRequest.setActions(actionName);  
        }
        connectNodes(testNodes);  
    public void testRunningTasksCount() throws Exception {  
        // Group by parents  
        assertEquals(0, responses.failureCount());
        public void writeTo(StreamOutput out) throws IOException {  
        public String getDescription() {  
        assertEquals(0, response.getTasks().size());  
        );  
        assertEquals(1, listResponse.getPerNodeTasks().size());
            }
import java.util.Map;  
        connectNodes(testNodes);
import static org.hamcrest.Matchers.containsString;  
        public void writeTo(StreamOutput out) throws IOException {  
        });  
        TestTasksResponse response = ActionTestUtils.executeBlocking(tasksActions[0], testTasksRequest);  
        logger.info("Done waiting for all actions to start");
        Map<String, Object> byNodes = serialize(response, true);
        TestNodesAction[] actions = new TestNodesAction[nodesCount];
            assertEquals(1, entry.getValue().size());
            status = in.readString();
        listTasksRequest.setActions("internal:testAction[n]"); // only pick node actions  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
            assertNull(entry.getValue().get(0).getDescription());
        }
        // should be successful on all nodes except one  
        }  
        );
        request.setNodes(testNodes[0].getNodeId());  
        TestTasksRequest() {}
        setupTestNodes(Settings.EMPTY);
        // Release all tasks and wait for response
        assertEquals(testNodes.length, response.getPerNodeTasks().size());  
        return startBlockingTestNodesAction(checkLatch, new NodesRequest("Test Request"));
        assertEquals(0, response.getNodeFailures().size()); // no nodes failed
    }
        response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
        request.setReason("Testing Cancellation");
    @SuppressWarnings("unchecked")  
        }  
        @Override
        assertEquals(mainTask.getId(), response.getTasks().get(0).getId());
            assertThat(remoteTask.getAction(), endsWith("[n]"));
                    actionLatch.countDown();
        assertTrue(responseLatch.await(10, TimeUnit.SECONDS));
                        }
        if (byParents) {
    }
        setupTestNodes(Settings.EMPTY);
            actions[i] = new TestNodesAction(
        protected TestTasksResponse newResponse(
        setupTestNodes(settings);  
        }  
 * You may obtain a copy of the License at  
import org.opensearch.common.xcontent.XContentHelper;
 * the Apache License, Version 2.0 (the "License"); you may
        int testNodeNum = randomIntBetween(0, testNodes.length - 1);  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;  
            assertEquals(1, entry.getValue().size());
import org.opensearch.action.support.nodes.BaseNodesRequest;
    private Map<String, Object> serialize(ListTasksResponse response, boolean byParents) throws IOException {
        XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();  
        assertEquals(1, response.getTasks().size());  
                            listener.onResponse(new TestTaskResponse("Success on node (sync)" + node));
        for (int i = 1; i < testNodes.length; i++) {  
        @Override
            super(in);  
        // Make sure that actions are still registered in the task manager on all nodes  
        listTasksRequest.setActions("internal:testAction"); // only pick the main task
        assertEquals(4, listeners[0].getEvents().size());
    static class TestTasksResponse extends BaseTasksResponse {
        TestTasksAction[] tasksActions = new TestTasksAction[nodesCount];
                TestTasksResponse::new,
        CountDownLatch checkLatch = new CountDownLatch(1);  
}
        // Try to cancel main task using id
     * getting executed on nodes that are not listed in the node filter.
        // Since the main task is not in the list - all tasks should be by themselves  
import java.util.concurrent.atomic.AtomicReference;
        }  
        // Try to cancel main task using action name
        List<Object> children = (List<Object>) topTask.get("children");  
        // One element on the top level  
        TestTasksRequest(StreamInput in) throws IOException {  
        // Shouldn't match any tasks since testAction doesn't support cancellation
 * GitHub history for details.
        for (int i = 0; i < testNodes.length; i++) {
                transportService,
                TestTaskResponse::new,
    public void testTaskNodeFiltering() throws ExecutionException, InterruptedException, IOException {  
            this.requestName = requestName;
 * ownership. Elasticsearch licenses this file to you under  
        listTasksRequest = new ListTasksRequest();  
        setupTestNodes(Settings.EMPTY);
import static org.opensearch.action.support.PlainActionFuture.newFuture;
            final int node = i;
    public void testTaskLevelActionFailures() throws ExecutionException, InterruptedException, IOException {  
        // Release all tasks and wait for response
        assertEquals(testNodes.length, response.getPerNodeTasks().size());
        TestTasksResponse(StreamInput in) throws IOException {
        }
        listTasksRequest.setDetailed(true); // same request only with detailed description
        for (Map.Entry<String, List<TaskInfo>> entry : response.getPerNodeTasks().entrySet()) {
        connectNodes(testNodes);  
import org.opensearch.test.tasks.MockTaskManager;
        // And as many child tasks as we have nodes
            public void onFailure(Exception e) {
        Map<String, Object> firstNode = (Map<String, Object>) byNodes.get(testNodes[0].getNodeId());  
        assertEquals(testNodes.length + 1, response.getTasks().size());  
        assertEquals(1, response.getNodeFailures().size());
        startBlockingTestNodesAction(checkLatch, request, future);
            tasksActions[i] = new TestTasksAction("internal:testTasksAction", testNodes[i].clusterService, testNodes[i].transportService) {
            assertEquals("internal:testAction[n]", task.getAction());
    public void testTasksDescriptions() throws Exception {
import org.opensearch.cluster.node.DiscoveryNodes;  
        TestTasksResponse response = ActionTestUtils.executeBlocking(tasksActions[randomIntBetween(0, nodesCount - 1)], testTasksRequest);
import org.opensearch.core.common.io.stream.StreamInput;
        ListTasksResponse response = ActionTestUtils.executeBlocking(testNodes[0].transportListTasksAction, listTasksRequest);
            assertNull(child.get("children"));
        ListTasksRequest listTasksRequest = new ListTasksRequest();
        // Start some test nodes action so we could have something to run tasks actions on
        // One element on the top level
                responseReference.set(listTasksResponse);  
     */
            final int node = i;  
                task.writeTo(out);
    }
     * it executes a tasks action that targets these blocked node actions. The test verifies that task actions are only  
            List<TaskOperationFailure> taskFailures,
        public void writeTo(StreamOutput out) throws IOException {  
        connectNodes(testNodes);
 * Modifications Copyright OpenSearch Contributors. See  
        }
        for (TaskInfo task : response.getTasks()) {
        for (int i = 1; i < testNodes.length; i++) {  
        }
        throws InterruptedException {  
    /**
        for (int i = 0; i < testNodes.length; i++) {
            return status;  
        TestNodesAction(String actionName, ThreadPool threadPool, ClusterService clusterService, TransportService transportService) {  
        public NodesRequest(String requestName, String... nodesIds) {  
    }  
        ListTasksResponse response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
        for (int i = 0; i < testNodes.length; i++) {
                    } else {  
            requestName = in.readString();  
     * Simulates node-based task that can be used to block node tasks so they are guaranteed to be registered by task manager
                testNodes[i].clusterService,
            out.writeString(status);
import org.opensearch.core.common.Strings;  
            response.toXContentGroupedByParents(builder, ToXContent.EMPTY_PARAMS);  
            @Override
        assertThat(subTask.getAction(), endsWith("[n]"));
            assertFalse(taskInfo.isCancellable());
                        Runnable failureMode = randomFrom(() -> {  
        setupTestNodes(Settings.EMPTY);
import java.util.ArrayList;
                @Override  
                actionName,
                responseLatch.countDown();
                    if (failTaskOnNode == node && task.getParentTaskId().isSet()) {  
            for (TestTaskResponse task : tasks) {
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
                            logger.info("Calling listener synchronously with exception from taskOperation");
            return "CancellableNodeRequest[" + requestName + "]";
import java.util.concurrent.CountDownLatch;
        }
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
        // Get the parent task  
        ListTasksRequest listTasksRequest = new ListTasksRequest();
import org.opensearch.threadpool.ThreadPool;  
 * this work for additional information regarding copyright
        firstNode = (Map<String, Object>) firstNode.get("tasks");
import org.opensearch.common.action.ActionFuture;
/*  
    }
    }  
        assertThat(response.getNodeFailures().get(0).getDetailedMessage(), containsString("doesn't support cancellation"));
        // Make sure that filtered nodes didn't send any responses  
        connectNodes(testNodes);
    }  
        builder.flush();  
        @Override
                                .execute(() -> listener.onFailure(new RuntimeException("Task level failure (async listener)")));  
        listTasksRequest.setParentTaskId(new TaskId(parentNode, parentTaskId));
                protected void taskOperation(TestTasksRequest request, Task task, ActionListener<TestTaskResponse> listener) {  
                        }, () -> {  
            TestTasksRequest request,  
 * software distributed under the License is distributed on an
            // We are testing that it works.
        assertEquals(0, responses.failureCount());
            assertEquals(1, remoteTasks.size());  
            assertNull(entry.getValue().get(0).getDescription());
        for (int i = 1; i < testNodes.length; i++) {
        // Get successful responses from all nodes except one  
                    for (String node : superNodes) {  
        NodesRequest request = new NodesRequest("Test Request");
        assertThat(response.getTaskFailures(), hasSize(1)); // one task failed
        // Release all node tasks and wait for response
        response = ActionTestUtils.executeBlocking(
            this.status = status;
        ListTasksResponse response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
        // There should be a single main task when grouped by tasks  
        }
        Map<Long, Task> localTasks = testNodes[0].transportService.getTaskManager().getTasks();  
            // Simulate a task action that works on all nodes except nodes listed in filterNodes.
            ) {
        ) {
    static class TestTasksRequest extends BaseTasksRequest<TestTasksRequest> {
    private Task startBlockingTestNodesAction(CountDownLatch checkLatch, ActionListener<NodesResponse> listener)  
            }  
        assertEquals(testNodes.length, children.size()); // two tasks for the first node
        }  
        ListTasksRequest listTasksRequest = new ListTasksRequest();  
        // Check task counts using transport
        private final String status;
        }
            assertThat(entry.getValue().get(0).getStartTime(), greaterThanOrEqualTo(minimalStartTime));
        }
     */  
        assertThat(coordinatingTask.getAction(), not(endsWith("[n]")));  
        RecordingTaskManagerListener[] listeners = setupListeners(testNodes, "internal:testAction*");  
            assertEquals(1, listeners[i].getRegistrationEvents().size());
                threadPool,
            assertEquals(parentNode, task.getParentTaskId().getNodeId());  
        for (int i = 1; i < listeners.length; i++) {
 * specific language governing permissions and limitations
        assertEquals(testNodes.length, response.getPerNodeTasks().size());
        }
import org.opensearch.core.common.bytes.BytesReference;
                protected NodeResponse nodeOperation(NodeRequest request) {  
        }
        assertTrue(actionLatch.await(10, TimeUnit.SECONDS));
    public void testTasksToXContentGrouping() throws Exception {
        Task subTask = localTasks.get(Collections.max(localTasks.keySet()));
        @Override  
                    return new NodeResponse(testNodes[node].discoveryNode());  
        assertEquals(1, byParent.size()); // Only one top level task
        public void writeTo(StreamOutput out) throws IOException {
        return future;  
import java.util.stream.Collectors;  
        NodesResponse responses = responseReference.get();
        CountDownLatch actionLatch = new CountDownLatch(nodesCount);
                        logger.info("Failing on node {}", node);
        }
        Task coordinatingTask = localTasks.get(Collections.min(localTasks.keySet()));  
                protected String[] filterNodeIds(DiscoveryNodes nodes, String[] nodesIds) {  
                            listener.onFailure(new RuntimeException("Task level failure (sync listener)"));
import org.opensearch.transport.TransportRequest;
        TestTasksRequest testTasksRequest = new TestTasksRequest();  
        logger.info("Listing currently running tasks using node [{}]", testNodeNum);
        for (TestNode node : testNodes) {
            }
        listTasksRequest.setActions("internal:testAction[n]"); // only pick node actions
            Map<String, Object> otherNode = (Map<String, Object>) byNodes.get(testNodes[i].getNodeId());
            assertThat(entry.getValue().get(0).getRunningTimeNanos(), greaterThanOrEqualTo(minimalDurationNanos));
        throws InterruptedException {  
        setupTestNodes(Settings.EMPTY);  
        for (TestNode testNode : testNodes) {
        TestNode testNode = testNodes[testNodeNum];
    }
        }  
 */  
        assertEquals(2, response.getPerNodeTasks().get(testNodes[0].getNodeId()).size());
            List<TestTaskResponse> builder = new ArrayList<>();
 */
        protected String requestName;  
        @Override
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(0, responses.failureCount());  
                    logger.info("Action on node {}", node);
        listTasksRequest.setDetailed(true); // same request only with detailed description
        protected TestTasksAction(String actionName, ClusterService clusterService, TransportService transportService) {  
        // Get successful responses from all nodes except nodes that we filtered out
            return "CancellableNodesRequest[" + requestName + "]";
        assertEquals(testNodes.length, response.getTaskGroups().get(0).getChildTasks().size());  
        NodesResponse responses = ActionTestUtils.executeBlocking(actions[0], request);  
            assertEquals(0, node.transportService.getTaskManager().getTasks().size());  
        request.setTaskId(new TaskId(testNodes[0].getNodeId(), task.getId()));
import org.opensearch.core.tasks.TaskId;
        setupTestNodes(Settings.EMPTY);
            super(
        listTasksRequest = new ListTasksRequest();
            localTasks.values()  
        ActionFuture<NodesResponse> future = startBlockingTestNodesAction(checkLatch);
        return task;  
                    } else {  
            assertEquals(1, listeners[i].getUnregistrationEvents().size());
        private String requestName;
        long minimalStartTime = System.currentTimeMillis();
                logger.warn("Couldn't get list of tasks", e);  
        ListTasksResponse listResponse = ActionTestUtils.executeBlocking(
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportCancelTasksAction,  
        TestNode testNode = testNodes[randomIntBetween(0, testNodes.length - 1)];
        byParent = (Map<String, Object>) byParent.get("tasks");
            assertEquals(1, response.getPerNodeTasks().get(testNodes[i].getNodeId()).size());
        public String getStatus() {
                @Override  
        }
/*
                        failureMode.run();
    }
        CancelTasksRequest request = new CancelTasksRequest();
        String actionName = "internal:testAction"; // only pick the main action
import org.opensearch.core.action.ActionListener;
        checkLatch.countDown();
        public NodeRequest(NodesRequest request) {
        assertEquals(nodesCount, responses.failureCount());
 * compatible open source license.
            this.tasks = tasks == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(tasks));
     * This test starts nodes actions that blocks on all nodes. While node actions are blocked in the middle of execution
 *
        // Make sure that we don't have any lingering tasks
        int filterNodesSize = randomInt(allNodes.length);  
import java.util.concurrent.TimeUnit;
    }
        connectNodes(testNodes);
        } else {
            assertEquals(0, node.transportService.getTaskManager().getTasks().size());  
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportCancelTasksAction,
        }  
        assertEquals(2, localTasks.size()); // all node tasks + 1 coordinating task
            DiscoveryNodes nodes = testNodes[0].clusterService.state().nodes();  
                    }
            for (int i = 0; i < taskCount; i++) {  
                    }  
        Map<String, Object> topTask = (Map<String, Object>) byParent.values().iterator().next();
        CountDownLatch checkLatch = new CountDownLatch(1);
                        checkLatch.await();
    }  
 * The OpenSearch Contributors require contributions made to  
        Map<String, Object> byParent = serialize(response, false);
                .stream()
        for (TaskGroup taskGroup : response.getTaskGroups()) {
                        });
                protected NodeResponse nodeOperation(NodeRequest request) {
            assertEquals(1, entry.getValue().size());  
        // Check task counts using transport with detailed description
    }
            List<TestTaskResponse> tasks,
        String parentNode = response.getTasks().get(0).getTaskId().getNodeId();
            return new NodeRequest(request);  
        listTasksRequest.setActions("internal:testAction");
                        if (randomBoolean()) {
            List<TestTaskResponse> tasks,  
        assertEquals(2, firstNode.size()); // two tasks for the first node
            otherNode = (Map<String, Object>) otherNode.get("tasks");
        protected NodeRequest newNodeRequest(NodesRequest request) {
            ) {
    }
        Settings settings = Settings.builder().put(MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING.getKey(), true).build();
        CountDownLatch checkLatch = new CountDownLatch(1);  
import java.util.Set;
        for (int i = 0; i < testNodes.length; i++) {  
        connectNodes(testNodes);
        // Get the parent task
        // Run task action on node tasks that are currently running
        testTasksRequest.setActions("internal:testAction[n]"); // pick all test actions
            super(in);  
    abstract class TestNodesAction extends AbstractTestNodesAction<NodesRequest, NodeRequest> {
            };
        // Twice on the coordinating node and once on all other nodes.
            assertFalse("Found response from filtered node " + nodeId, filterNodes.contains(nodeId));  
        checkLatch.countDown();
        // Release all tasks and wait for response  
        public NodeRequest(StreamInput in) throws IOException {
                TestTasksRequest::new,  
            super.writeTo(out);
        // Check task counts using taskManager
        checkLatch.countDown();
        request.setReason("Testing Cancellation");  
        Task task = startBlockingTestNodesAction(checkLatch, ActionListener.wrap(responseLatch::countDown));
        // Other nodes node
            request
        assertEquals(1, response.getTasks().size());
            tasksActions[i] = new TestTasksAction("internal:testTasksAction", testNodes[i].clusterService, testNodes[i].transportService) {  
        @Override
            tasks = Collections.unmodifiableList(builder);  
        assertEquals(testNodes.length, byNodes.size());
                    logger.info("Task action on node {}", node);
            assertEquals(1, entry.getValue().size());
        listTasksRequest.setActions(ListTasksAction.NAME + "*");
            assertEquals(parentTaskId, task.getParentTaskId().getId());
        setupTestNodes(Settings.EMPTY);  
        assertEquals(1, response.getTaskGroups().size());
        }
            assertEquals("CancellableNodeRequest[Test Request]", entry.getValue().get(0).getDescription());  
            request
        for (int i = 0; i < testNodes.length; i++) {
        ActionFuture<NodesResponse> future = startBlockingTestNodesAction(checkLatch);
                testNodes[i].transportService  
import org.opensearch.core.common.io.stream.Writeable;
import java.util.HashSet;
                            filteredNodes.add(node);
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
            assertEquals(1, otherNode.size()); // one tasks for the all other nodes  
                responseLatch.countDown();
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;
        @Override
 * under the License.  
        TestTasksRequest testTasksRequest = new TestTasksRequest();
        builder.startObject();
                .map(t -> Strings.toString(MediaTypeRegistry.JSON, t.taskInfo(testNodes[0].getNodeId(), true)))
                        }, () -> {  
 * not use this file except in compliance with the License.
        assertEquals(0, responses.failureCount());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                testNodes[i].clusterService,  
                            logger.info("Throwing exception from taskOperation");
        long maximumStartTimeNanos = System.nanoTime();
        logger.info(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);  
        // Coordinating node  
package org.opensearch.action.admin.cluster.node.tasks;
        // Make sure that the main task on coordinating node is the task that was returned to us by execute()  
        NodesResponse responses = future.get();  
        }
    public static class NodesRequest extends BaseNodesRequest<NodesRequest> {
        for (Map.Entry<String, List<TaskInfo>> entry : response.getPerNodeTasks().entrySet()) {
                        } else {  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksAction;
                @Override
        CountDownLatch checkLatch = new CountDownLatch(1);
            Map<String, Object> child = (Map<String, Object>) children.get(i);  
            assertEquals("CancellableNodeRequest[Test Request]", entry.getValue().get(0).getDescription());  
            String nodeId = taskResponse.getStatus();
 * license agreements. See the NOTICE file distributed with
        }
        logger.info("Filtering out nodes {} size: {}", filterNodes, filterNodesSize);
import org.opensearch.action.TaskOperationFailure;
        connectNodes(testNodes);
            out.writeVInt(tasks.size());  
import org.opensearch.cluster.service.ClusterService;
        assertEquals(0, response.getTaskFailures().size());
            super(taskFailures, nodeFailures);
                }
            requestName = request.requestName;
    }
            assertEquals(2, listeners[i].getEvents().size());  
        NodesRequest(StreamInput in) throws IOException {
import org.opensearch.action.FailedNodeException;  
        // Release all node tasks and wait for response  
        }
            assertEquals(0, testNode.transportService.getTaskManager().getTasks().size());  
        logger.info("Awaiting for all actions to start");  
        throws InterruptedException {
        for (TestNode node : testNodes) {
 *  
        assertEquals(0, responses.failureCount());
            super(actionName, threadPool, clusterService, transportService, NodesRequest::new, NodeRequest::new);
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.core.common.io.stream.StreamOutput;  
public class TransportTasksActionTests extends TaskManagerTestCase {  
        }  
                        }  
            Map<Long, Task> remoteTasks = testNodes[i].transportService.getTaskManager().getTasks();
        protected NodeResponse newNodeResponse(StreamInput in) throws IOException {
                threadPool,
        assertEquals(0, response.getTasks().size());
            Task remoteTask = remoteTasks.values().iterator().next();
        logger.info("Checking currently running tasks");  
import org.opensearch.action.support.ActionTestUtils;  
        builder.endObject();
        assertEquals(testNodes.length, response.getTaskGroups().size());
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
        assertEquals(testNodes.length, response.getTasks().size());  
 *    http://www.apache.org/licenses/LICENSE-2.0
        final int failTaskOnNode = randomIntBetween(1, nodesCount - 1);
        // Release all tasks and wait for response
                        // Fail in a random way to make sure we can handle all these ways
import org.opensearch.core.xcontent.ToXContent;
    }  
                    List<String> filteredNodes = new ArrayList<>();
        }
        testTasksRequest.setActions("internal:testAction[n]"); // pick all test actions
                testNodes[i].transportService
     */  
            };
/*
        }  
    public static class NodeRequest extends TransportRequest {
        }  
            requestName = in.readString();
                    } catch (InterruptedException ex) {
import static org.hamcrest.Matchers.hasSize;  
        // Check task counts using transport with filtering  
            super.writeTo(out);
        TestTaskResponse(StreamInput in) throws IOException {
            final int node = i;  
                    if (randomBoolean()) {
        checkLatch.countDown();  
            @Override
        TestTasksAction[] tasksActions = new TestTasksAction[nodesCount];  
        CancelTasksResponse response = ActionTestUtils.executeBlocking(  
        NodesResponse responses = future.get();  
    public void testCancellingTasksThatDontSupportCancellation() throws Exception {
            return super.createTask(id, type, action, parentTaskId, headers);  
            out.writeString(requestName);
        @Override
        for (int i = 0; i < testNodes.length; i++) {
        // Make sure that task is still running
        NodesResponse responses = future.get();
                @Override
        // should be successful on all nodes except nodes that we filtered out
        assertEquals(testNodes.length - filterNodes.size(), response.tasks.size());
        // Run task action on node tasks that are currently running
        long parentTaskId = response.getTasks().get(0).getId();  
        // Make sure no tasks are running
        assertEquals(0, response.getTaskFailures().size()); // no task failed  
        ListTasksRequest listTasksRequest = new ListTasksRequest();
        }  
            return new TestTasksResponse(tasks, taskOperationFailures, failedNodeExceptions);
            return new NodeResponse(in);
 * this file be licensed under the Apache-2.0 license or a
            int taskCount = in.readVInt();
            out.writeString(requestName);
        }
        }  
            };
        testNode = testNodes[randomIntBetween(0, testNodes.length - 1)];  
                        threadPool.generic().execute(() -> listener.onResponse(new TestTaskResponse(testNodes[node].getNodeId())));
        assertEquals(2, listeners[0].getUnregistrationEvents().size());
        assertEquals(0, response.getNodeFailures().size()); // no nodes failed
        CountDownLatch responseLatch = new CountDownLatch(1);
        assertEquals(0, response.getTaskFailures().size());  
        for (Map.Entry<String, List<TaskInfo>> entry : response.getPerNodeTasks().entrySet()) {  
 */
import static org.hamcrest.Matchers.endsWith;
 * KIND, either express or implied.  See the License for the
        }
                    logger.info("Action on node {}", node);
    }
                            logger.info("Calling listener asynchronously with exception from taskOperation");
        }
import org.opensearch.action.support.ActionFilters;
        responseLatch.await(10, TimeUnit.SECONDS);
            "local tasks [{}]",
                builder.add(new TestTaskResponse(in));
        }
        CountDownLatch responseLatch = new CountDownLatch(1);  
import org.opensearch.tasks.Task;  
        // Check task counts using transport with filtering
        NodesResponse responses = future.get();
        private List<TestTaskResponse> tasks;  
        listTasksRequest.setActions("internal:testAction*"); // pick all test actions  
        for (Map.Entry<String, List<TaskInfo>> entry : response.getPerNodeTasks().entrySet()) {
                @Override
                            throw new RuntimeException("Task level failure (direct)");
import org.opensearch.action.support.tasks.BaseTasksResponse;
        CountDownLatch checkLatch = new CountDownLatch(1);
                ThreadPool.Names.MANAGEMENT  
        }  
        ActionFuture<NodesResponse> future = startBlockingTestNodesAction(checkLatch);  
                "internal:testAction",
        TestTaskResponse(String status) {
        assertEquals(testNodes.length, response.getPerNodeTasks().size());
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals(testNodes.length - 1, response.tasks.size());
        // Find tasks with common parent
        );
                }  
            allNodes[i] = testNodes[i].getNodeId();  
        return startBlockingTestNodesAction(checkLatch, new NodesRequest("Test Request"), listener);
        }
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
        logger.info(builder.toString());
import java.util.concurrent.ExecutionException;  
import java.io.IOException;
        TestNodesAction[] actions = new TestNodesAction[nodesCount];
                    throw new RuntimeException("Test exception");  
        response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
            assertEquals(0, taskGroup.getChildTasks().size());  
            super(nodesIds);
        long minimalDurationNanos = System.nanoTime() - maximumStartTimeNanos;  
                        if (filterNodes.contains(node) == false) {
                        Thread.currentThread().interrupt();  
        checkLatch.countDown();  
        for (TestTaskResponse taskResponse : response.tasks) {
        }  
            List<FailedNodeException> failedNodeExceptions  
        byNodes = (Map<String, Object>) byNodes.get("nodes");  
        ListTasksResponse response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);  
        }  
            // Simulate task action that fails on one of the tasks on one of the nodes
import org.opensearch.action.support.tasks.TransportTasksAction;
