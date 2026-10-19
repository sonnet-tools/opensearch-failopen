        }
        List<Object> children = (List<Object>) topTask.get("children");
import org.opensearch.action.support.ActionTestUtils;
        assertEquals(testNodes.length, response.getTaskGroups().get(0).getChildTasks().size());
        public NodeRequest(NodesRequest request) {
        assertEquals(1, response.getNodeFailures().size());
                        listener.onResponse(new TestTaskResponse(testNodes[node].getNodeId()));
                protected NodeResponse nodeOperation(NodeRequest request) {
            return status;
            }
 * license agreements. See the NOTICE file distributed with
            assertEquals(0, node.transportService.getTaskManager().getTasks().size());
}
        }
 * specific language governing permissions and limitations
        assertEquals(0, response.getNodeFailures().size()); // no nodes failed
        setupTestNodes(Settings.EMPTY);
        }
        NodesResponse responses = future.get();
        assertEquals(1, response.getTasks().size());
    /**
        for (int i = 1; i < testNodes.length; i++) {
                @Override
        TestTaskResponse(StreamInput in) throws IOException {
            super.writeTo(out);
import static org.opensearch.action.support.PlainActionFuture.newFuture;
import org.opensearch.core.xcontent.XContentBuilder;
        request = new CancelTasksRequest();
        assertEquals(testNodes.length, response.getPerNodeTasks().size());
                }
        checkLatch.countDown();
        }
        }
        response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
        assertEquals(testNodes.length, response.getTasks().size());
                protected void taskOperation(TestTasksRequest request, Task task, ActionListener<TestTaskResponse> listener) {
        int testNodeNum = randomIntBetween(0, testNodes.length - 1);
     */
        // And as many child tasks as we have nodes
import org.opensearch.action.support.PlainActionFuture;
                threadPool,
    /**
        assertThat(response.getTaskFailures().get(0).getCause().getMessage(), containsString("Task level failure"));
                testNodes[i].clusterService,
            assertEquals(parentNode, task.getParentTaskId().getNodeId());
        }
        logger.info(
        // There should be a single main task when grouped by tasks
import java.io.IOException;
            public void onResponse(NodesResponse listTasksResponse) {
        response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
            return new NodeResponse(in);
    static class TestTaskResponse implements Writeable {
import static org.hamcrest.Matchers.containsString;
                @Override
            actions[i] = new TestNodesAction(
        for (TestNode node : testNodes) {
        response = ActionTestUtils.executeBlocking(
        assertEquals(nodesCount, responses.failureCount());
        Task mainTask = startBlockingTestNodesAction(checkLatch, new ActionListener<NodesResponse>() {
        ListTasksRequest listTasksRequest = new ListTasksRequest();
        // Make sure that task is still running
        }
            requestName = request.requestName;
 * SPDX-License-Identifier: Apache-2.0
     */
        for (Map.Entry<String, List<TaskInfo>> entry : response.getPerNodeTasks().entrySet()) {
        @Override
            Map<String, Object> otherNode = (Map<String, Object>) byNodes.get(testNodes[i].getNodeId());
        long minimalStartTime = System.currentTimeMillis();
                        checkLatch.await();
        protected NodeRequest newNodeRequest(NodesRequest request) {
 *
        assertEquals(testNodes.length, response.getPerNodeTasks().size());
                }
        byNodes = (Map<String, Object>) byNodes.get("nodes");
        public void writeTo(StreamOutput out) throws IOException {
        assertEquals(2, listeners[0].getUnregistrationEvents().size());
import java.util.stream.Collectors;
import java.util.HashSet;
        }
            super.writeTo(out);
            super.writeTo(out);
                task.writeTo(out);
    }
            assertFalse("Found response from filtered node " + nodeId, filterNodes.contains(nodeId));
        for (Map.Entry<String, List<TaskInfo>> entry : response.getPerNodeTasks().entrySet()) {
        }
            }
     * Simulates node-based task that can be used to block node tasks so they are guaranteed to be registered by task manager
        }
                            throw new RuntimeException("Task level failure (direct)");
        setupTestNodes(settings);
import org.opensearch.test.tasks.MockTaskManager;
            out.writeString(requestName);
        // Try to cancel main task using action name
        // Get successful responses from all nodes except nodes that we filtered out
    static class TestTasksResponse extends BaseTasksResponse {
        logger.info("Done waiting for all actions to start");
            List<TaskOperationFailure> taskOperationFailures,
        assertTrue(responseLatch.await(10, TimeUnit.SECONDS));
        }
                            listener.onResponse(new TestTaskResponse("Success on node (sync)" + node));
                @Override
        ListTasksResponse response = ActionTestUtils.executeBlocking(testNodes[0].transportListTasksAction, listTasksRequest);
                                .execute(() -> listener.onFailure(new RuntimeException("Task level failure (async listener)")));
import java.util.concurrent.CountDownLatch;
import java.util.ArrayList;
 * not use this file except in compliance with the License.
    }
            return "CancellableNodeRequest[" + requestName + "]";
        public String getDescription() {
        }
        TestNodesAction(String actionName, ThreadPool threadPool, ClusterService clusterService, TransportService transportService) {
        }
    }
    }
                    }
        }
import org.opensearch.core.action.ActionListener;
                    return filteredNodes.toArray(new String[0]);
        TestTasksRequest(StreamInput in) throws IOException {
        TestTasksResponse response = ActionTestUtils.executeBlocking(tasksActions[0], testTasksRequest);
                    logger.info("Action on node {}", node);
            request
        throws InterruptedException {
            List<TestTaskResponse> builder = new ArrayList<>();
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
        }
        // Make sure that filtered nodes didn't send any responses
            this.tasks = tasks == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(tasks));
            final int node = i;
        ListTasksResponse response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
        );
            };
            super(nodesIds);
        }
        connectNodes(testNodes);
    public void testFailedTasksCount() throws ExecutionException, InterruptedException, IOException {
import org.opensearch.threadpool.ThreadPool;
            localTasks.values()
                        if (randomBoolean()) {
        return startBlockingTestNodesAction(checkLatch, new NodesRequest("Test Request"));
        assertEquals(0, responses.failureCount());
            out.writeString(status);
        return task;
        CountDownLatch checkLatch = new CountDownLatch(1);
                }
    private ActionFuture<NodesResponse> startBlockingTestNodesAction(CountDownLatch checkLatch) throws InterruptedException {
    }
                        }, () -> {
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.not;
            assertEquals("CancellableNodeRequest[Test Request]", entry.getValue().get(0).getDescription());
        setupTestNodes(Settings.EMPTY);
            List<TaskOperationFailure> taskFailures,
        TestNode testNode = testNodes[randomIntBetween(0, testNodes.length - 1)];
import org.opensearch.transport.TransportRequest;
import org.opensearch.common.action.ActionFuture;
import org.opensearch.cluster.service.ClusterService;
                }
        builder.startObject();
        // Find tasks with common parent
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportCancelTasksAction,
        testTasksRequest.setActions("internal:testAction[n]"); // pick all test actions
                testNodes[i].clusterService,
import java.util.concurrent.atomic.AtomicReference;
        // Make sure that actions are still registered in the task manager on all nodes
        NodesResponse responses = responseReference.get();
            tasksActions[i] = new TestTasksAction("internal:testTasksAction", testNodes[i].clusterService, testNodes[i].transportService) {
            // Simulate a task action that works on all nodes except nodes listed in filterNodes.
            assertEquals(parentTaskId, task.getParentTaskId().getId());
        public void writeTo(StreamOutput out) throws IOException {
        listTasksRequest.setActions("internal:testAction"); // only pick the main task
        NodesResponse responses = ActionTestUtils.executeBlocking(actions[0], request);
                @Override
        startBlockingTestNodesAction(checkLatch, request, future);
        // One element on the top level
            assertThat(remoteTask.getAction(), endsWith("[n]"));
        listTasksRequest.setDetailed(true); // same request only with detailed description
        builder.flush();
        return XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
        Task task = startBlockingTestNodesAction(checkLatch, ActionListener.wrap(responseLatch::countDown));
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        assertEquals(0, responses.failureCount());
        NodesResponse responses = future.get();
        Settings settings = Settings.builder().put(MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING.getKey(), true).build();
        // Since the main task is not in the list - all tasks should be by themselves
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
        CountDownLatch checkLatch = new CountDownLatch(1);
    private Task startBlockingTestNodesAction(CountDownLatch checkLatch, NodesRequest request, ActionListener<NodesResponse> listener)
        Map<String, Object> byParent = serialize(response, false);
import org.opensearch.action.TaskOperationFailure;
 * Licensed to Elasticsearch under one or more contributor
                "internal:testAction",
/*
 */
        responseLatch.await(10, TimeUnit.SECONDS);
        }
                        logger.info("Failing on node {}", node);
        assertEquals(testNodes.length, response.getPerNodeTasks().size());
        }
                            listener.onFailure(new RuntimeException("Task level failure (sync listener)"));
        String parentNode = response.getTasks().get(0).getTaskId().getNodeId();
                logger.warn("Couldn't get list of tasks", e);
        setupTestNodes(Settings.EMPTY);
        ListTasksRequest listTasksRequest = new ListTasksRequest();
            };
        assertEquals(4, listeners[0].getEvents().size());
        Task subTask = localTasks.get(Collections.max(localTasks.keySet()));
        assertEquals(2, localTasks.size()); // all node tasks + 1 coordinating task
 * You may obtain a copy of the License at
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksAction;
import org.opensearch.common.settings.Settings;
            requestName = in.readString();
            assertEquals("CancellableNodeRequest[Test Request]", entry.getValue().get(0).getDescription());
                clusterService,
        response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
        Map<String, Object> firstNode = (Map<String, Object>) byNodes.get(testNodes[0].getNodeId());
                TestTaskResponse::new,
        for (TestNode testNode : testNodes) {
        ListTasksResponse response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
        );
            assertEquals("internal:testAction[n]", task.getAction());
            tasks = Collections.unmodifiableList(builder);
        connectNodes(testNodes);
        logger.info("Listing currently running tasks using node [{}]", testNodeNum);
        // Run task action on node tasks that are currently running
        // Shouldn't match any tasks since testAction doesn't support cancellation
            response.toXContentGroupedByNode(builder, ToXContent.EMPTY_PARAMS, nodes);
                    actionLatch.countDown();
            int taskCount = in.readVInt();
        TestTasksResponse(StreamInput in) throws IOException {
     * This test starts nodes actions that blocks on all nodes. While node actions are blocked in the middle of execution
        logger.info("Awaiting for all actions to start");
        assertEquals(1, response.getTaskGroups().size());
        private String requestName;
        logger.info("Filtering out nodes {} size: {}", filterNodes, filterNodesSize);
        assertThat(subTask.getAction(), endsWith("[n]"));
        TestNodesAction[] actions = new TestNodesAction[nodesCount];
        if (byParents) {
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
        firstNode = (Map<String, Object>) firstNode.get("tasks");
    }
 * this work for additional information regarding copyright
        @Override
        // Coordinating node
                    try {
                protected void taskOperation(TestTasksRequest request, Task task, ActionListener<TestTaskResponse> listener) {
    @SuppressWarnings("unchecked")
import org.opensearch.core.common.io.stream.StreamInput;
import static org.hamcrest.Matchers.endsWith;
        checkLatch.countDown();
import org.opensearch.action.support.ActionFilters;
        }
        listTasksRequest.setActions(ListTasksAction.NAME + "*");
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        // Twice on the coordinating node and once on all other nodes.
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
            this.requestName = requestName;
                .map(t -> Strings.toString(MediaTypeRegistry.JSON, t.taskInfo(testNodes[0].getNodeId(), true)))
 *    http://www.apache.org/licenses/LICENSE-2.0
        String[] allNodes = new String[testNodes.length];
        // Start some test nodes action so we could have something to run tasks actions on
import org.opensearch.action.support.tasks.BaseTasksRequest;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        // Make sure that we don't have any lingering tasks
        TestTasksRequest testTasksRequest = new TestTasksRequest();
        }
        }
        connectNodes(testNodes);
        return future;
        for (TaskInfo taskInfo : listResponse.getTasks()) {
            super(in);
        checkLatch.countDown();
                            logger.info("Calling listener asynchronously with exception from taskOperation");
        checkLatch.countDown();
package org.opensearch.action.admin.cluster.node.tasks;
            final int node = i;
import org.opensearch.cluster.node.DiscoveryNodes;
        XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
        // Check task counts using transport with detailed description
            assertNull(entry.getValue().get(0).getDescription());
    public void testTaskLevelActionFailures() throws ExecutionException, InterruptedException, IOException {
        // One element on the top level
    }
        testNode = testNodes[randomIntBetween(0, testNodes.length - 1)];
            return new TestTasksResponse(tasks, taskOperationFailures, failedNodeExceptions);
        connectNodes(testNodes);
        TestTasksAction[] tasksActions = new TestTasksAction[nodesCount];
                actionName,
                }
            this.status = status;
        // Release all node tasks and wait for response
        public String getStatus() {
        // should be successful on all nodes except one
            List<? extends FailedNodeException> nodeFailures
        PlainActionFuture<NodesResponse> future = newFuture();
        for (TestNode node : testNodes) {
        ActionFuture<NodesResponse> future = startBlockingTestNodesAction(checkLatch);
                new ActionFilters(new HashSet<>()),
            List<TestTaskResponse> tasks,
        assertThat(coordinatingTask.getAction(), not(endsWith("[n]")));
        RecordingTaskManagerListener[] listeners = setupListeners(testNodes, "internal:testAction*");
            Map<Long, Task> remoteTasks = testNodes[i].transportService.getTaskManager().getTasks();
                protected String[] filterNodeIds(DiscoveryNodes nodes, String[] nodesIds) {
        protected TestTasksResponse newResponse(
            DiscoveryNodes nodes = testNodes[0].clusterService.state().nodes();
        setupTestNodes(Settings.EMPTY);
            @Override
        }
        TestTaskResponse(String status) {
        for (int i = 1; i < listeners.length; i++) {
            listTasksRequest
        builder.endObject();
        testTasksRequest.setActions("internal:testAction[n]"); // pick all test actions
    static class TestTasksRequest extends BaseTasksRequest<TestTasksRequest> {
        assertThat(response.getNodeFailures().get(0).getDetailedMessage(), containsString("doesn't support cancellation"));
import java.util.Collections;
        // Make sure that the main task on coordinating node is the task that was returned to us by execute()
            assertEquals(1, entry.getValue().size());
 * The OpenSearch Contributors require contributions made to
        connectNodes(testNodes);
        String actionName = "internal:testAction"; // only pick the main action
        listTasksRequest.setActions("internal:testAction[n]"); // only pick node actions
            assertEquals(0, node.transportService.getTaskManager().getTasks().size());
        }
     * it executes a tasks action that targets these blocked node actions. The test verifies that task actions are only
        for (Map.Entry<String, List<TaskInfo>> entry : response.getPerNodeTasks().entrySet()) {
    }
            return new NodeRequest(request);
                    logger.info("Action on node {}", node);
                            threadPool.generic().execute(() -> listener.onResponse(new TestTaskResponse("Success on node (async)" + node)));
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
        public void writeTo(StreamOutput out) throws IOException {
        // Other nodes node
import org.opensearch.tasks.TaskInfo;
        ActionFuture<NodesResponse> future = startBlockingTestNodesAction(checkLatch);
    private ActionFuture<NodesResponse> startBlockingTestNodesAction(CountDownLatch checkLatch, NodesRequest request)
        @Override
                        Thread.currentThread().interrupt();
        response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
                    } else {
                    String[] superNodes = super.filterNodeIds(nodes, nodesIds);
        assertEquals(0, response.getTaskFailures().size());
        }
        CountDownLatch actionLatch = new CountDownLatch(nodesCount);
        checkLatch.countDown();
            assertEquals(1, response.getPerNodeTasks().get(testNodes[i].getNodeId()).size());
    abstract class TestNodesAction extends AbstractTestNodesAction<NodesRequest, NodeRequest> {
        setupTestNodes(Settings.EMPTY);
        // Check task counts using transport with filtering
        }
            status = in.readString();
            ) {
        ListTasksRequest listTasksRequest = new ListTasksRequest();
            for (TestTaskResponse task : tasks) {
        }
     */
        // Release all tasks and wait for response
        // Check task counts using transport with filtering
        }
        }
            super(actionName, threadPool, clusterService, transportService, NodesRequest::new, NodeRequest::new);
import org.opensearch.common.xcontent.XContentHelper;
        listTasksRequest.setActions("internal:testAction[n]"); // only pick node actions
        listTasksRequest = new ListTasksRequest();
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < testNodes.length; i++) {
        // Get the parent task
        connectNodes(testNodes);
                TestTasksResponse::new,
        assertEquals(1, response.getTasks().size());
        throws InterruptedException {
        request.setNodes(testNodes[0].getNodeId());
        ListTasksRequest listTasksRequest = new ListTasksRequest();
        response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
        assertEquals(0, response.getNodeFailures().size());
    /**
            TestTasksRequest request,
        for (TestTaskResponse taskResponse : response.tasks) {
        @Override
                .stream()
        request.setActions(actionName);
        // Release all tasks and wait for response
import org.opensearch.transport.TransportService;
 * GitHub history for details.
    }
    public static class NodesRequest extends BaseNodesRequest<NodesRequest> {
import java.util.Set;
                    }
                        threadPool.generic().execute(() -> listener.onResponse(new TestTaskResponse(testNodes[node].getNodeId())));
            super(in);
        // Shouldn't match any tasks since testAction doesn't support cancellation
    }
        }
                    if (randomBoolean()) {
        @Override
                testNodes[i].transportService
            tasksActions[i] = new TestTasksAction("internal:testTasksAction", testNodes[i].clusterService, testNodes[i].transportService) {
        assertEquals(mainTask.getId(), response.getTasks().get(0).getId());
            super(
                @Override
            // We are testing that it works.
                "internal:testAction",
                    } else {
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
/*
        connectNodes(testNodes);
        listTasksRequest.setActions("internal:testAction");
        });
        // Release all tasks and wait for response
                        Runnable failureMode = randomFrom(() -> {
            }
            Map<String, Object> child = (Map<String, Object>) children.get(i);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(testNodes.length, response.getPerNodeTasks().size());
                responseReference.set(listTasksResponse);
        assertEquals(2, firstNode.size()); // two tasks for the first node
import org.opensearch.core.common.io.stream.Writeable;
                    }
            response.toXContentGroupedByParents(builder, ToXContent.EMPTY_PARAMS);
            );
import org.opensearch.core.xcontent.ToXContent;
        assertEquals(0, responses.failureCount());
public class TransportTasksActionTests extends TaskManagerTestCase {
        CountDownLatch checkLatch = new CountDownLatch(1);
        );
            @Override
            };
    }
import org.opensearch.core.common.Strings;
        assertEquals(1, byParent.size()); // Only one top level task
        @Override
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportCancelTasksAction,
import java.util.concurrent.ExecutionException;
        throws InterruptedException {
                responseLatch.countDown();
    private Task startBlockingTestNodesAction(CountDownLatch checkLatch, ActionListener<NodesResponse> listener)
        request.setReason("Testing Cancellation");
        @Override
                        // Fail in a random way to make sure we can handle all these ways
        assertEquals(testNodes.length, response.getPerNodeTasks().size());
        CountDownLatch checkLatch = new CountDownLatch(1);
        TestTasksAction[] tasksActions = new TestTasksAction[nodesCount];
     * getting executed on nodes that are not listed in the node filter.
        }
            "local tasks [{}]",
            };
                        failureMode.run();
            assertEquals(1, listeners[i].getUnregistrationEvents().size());
            assertFalse(taskInfo.isCancellable());
            assertEquals(1, entry.getValue().size());
        }
        for (int i = 0; i < testNodes.length; i++) {
        // Check task counts using transport with detailed description
        long maximumStartTimeNanos = System.nanoTime();
        CountDownLatch responseLatch = new CountDownLatch(1);
                .collect(Collectors.joining(","))
 */
            assertThat(entry.getValue().get(0).getRunningTimeNanos(), greaterThanOrEqualTo(minimalDurationNanos));
        listTasksRequest = new ListTasksRequest();
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportListTasksAction,
        assertEquals(2, response.getPerNodeTasks().get(testNodes[0].getNodeId()).size());
        for (int i = 0; i < testNodes.length; i++) {
                responseLatch.countDown();
    public void testTaskNodeFiltering() throws ExecutionException, InterruptedException, IOException {
        Map<Long, Task> localTasks = testNodes[0].transportService.getTaskManager().getTasks();
        // Group by parents
        }
        assertEquals(testNodes.length - 1, response.tasks.size());
        for (TaskGroup taskGroup : response.getTaskGroups()) {
 * Modifications Copyright OpenSearch Contributors. See
        @Override
            assertEquals(2, listeners[i].getEvents().size());
    public void testTasksToXContentGrouping() throws Exception {
        NodesRequest request = new NodesRequest("Test Request");
        public NodesRequest(String requestName, String... nodesIds) {
    }
                            logger.info("Throwing exception from taskOperation");
        assertEquals(testNodes.length, byNodes.size());
            String nodeId = taskResponse.getStatus();
        }
        listTasksRequest.setActions("internal:testAction*"); // pick all test actions
import java.util.Map;
        int filterNodesSize = randomInt(allNodes.length);
            ) {
            assertEquals(1, otherNode.size()); // one tasks for the all other nodes
        ListTasksResponse listResponse = ActionTestUtils.executeBlocking(
        // Get successful responses from all nodes except one
                    if (failTaskOnNode == node && task.getParentTaskId().isSet()) {
            super(in);
                protected NodeResponse nodeOperation(NodeRequest request) {
        setupTestNodes(Settings.EMPTY);
        // Check task counts using transport
        ListTasksRequest listTasksRequest = new ListTasksRequest();
        listTasksRequest.setParentTaskId(new TaskId(parentNode, parentTaskId));
        @Override
        assertEquals(testNodes.length, response.getTaskGroups().size());
 * software distributed under the License is distributed on an
        // Get the parent task
        // should be successful on all nodes except nodes that we filtered out
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(testNodes.length + 1, response.getTasks().size());
        Map<String, Object> topTask = (Map<String, Object>) byParent.values().iterator().next();
                    logger.info("Task action on node {}", node);
        // Run task action on node tasks that are currently running
        }
        }
        CancelTasksResponse response = ActionTestUtils.executeBlocking(
import org.opensearch.action.support.tasks.BaseTasksResponse;
                transportService,
     * Test class for testing task operations
    abstract static class TestTasksAction extends TransportTasksAction<Task, TestTasksRequest, TestTasksResponse, TestTaskResponse> {
        assertEquals(0, response.getTaskFailures().size());
            Task remoteTask = remoteTasks.values().iterator().next();
                TestTasksRequest::new,
        }
        } else {
                    return new NodeResponse(testNodes[node].discoveryNode());
                            logger.info("Calling listener synchronously with exception from taskOperation");
/*
        // Release all node tasks and wait for response
    }
        assertThat(response.getTaskFailures(), hasSize(1)); // one task failed
        TestNodesAction[] actions = new TestNodesAction[nodesCount];
        assertEquals(0, responses.failureCount());
        // Release all tasks and wait for response
            assertEquals(1, entry.getValue().size());
            allNodes[i] = testNodes[i].getNodeId();
        protected NodeResponse newNodeResponse(StreamInput in) throws IOException {
        long parentTaskId = response.getTasks().get(0).getId();
import java.util.concurrent.TimeUnit;
                        }
        ActionFuture<NodesResponse> future = startBlockingTestNodesAction(checkLatch);
                            threadPool.generic()
        connectNodes(testNodes);
        Set<String> filterNodes = new HashSet<>(randomSubsetOf(filterNodesSize, allNodes));
    public void testTasksDescriptions() throws Exception {
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
            List<FailedNodeException> failedNodeExceptions
        public NodeRequest(StreamInput in) throws IOException {
        CountDownLatch checkLatch = new CountDownLatch(1);
        for (int i = 0; i < testNodes.length; i++) {
    }
    public void testRunningTasksCount() throws Exception {
        TestTasksResponse(
                        }, () -> {
import org.opensearch.action.support.nodes.BaseNodesRequest;
        // Check task counts using taskManager
        assertEquals(0, response.getNodeFailures().size()); // no nodes failed
    }
        final int failTaskOnNode = randomIntBetween(1, nodesCount - 1);
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
            assertNull(entry.getValue().get(0).getDescription());
    }
        for (int i = 0; i < testNodes.length; i++) {
                        } else {
import java.util.List;
                    for (String node : superNodes) {
        private List<TestTaskResponse> tasks;
        private final String status;
    }
        for (int i = 0; i < testNodes.length; i++) {
            out.writeVInt(tasks.size());
        assertEquals(2, listeners[0].getRegistrationEvents().size());
                    }
 */
        logger.info(builder.toString());
import org.opensearch.action.support.tasks.TransportTasksAction;
        ) {
import org.opensearch.tasks.Task;
            final int node = i;
            actions[i] = new TestNodesAction(
        }
        TestNode testNode = testNodes[randomIntBetween(0, testNodes.length - 1)];
        ListTasksResponse response = ActionTestUtils.executeBlocking(testNode.transportListTasksAction, listTasksRequest);
                    throw new RuntimeException("Test exception");
        request.setReason("Testing Cancellation");
import org.opensearch.core.common.bytes.BytesReference;
        long minimalDurationNanos = System.nanoTime() - maximumStartTimeNanos;
        // Try to cancel main task using id
        assertEquals(1, listResponse.getPerNodeTasks().size());
            assertEquals(1, remoteTasks.size());
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;
                        });
        }
        );
        Task task = actions[0].execute(request, listener);
    public void testCancellingTasksThatDontSupportCancellation() throws Exception {
        ActionFuture<NodesResponse> future = startBlockingTestNodesAction(checkLatch);
        }
 *
        assertEquals(0, response.getTasks().size());
                            filteredNodes.add(node);
        for (int i = 1; i < testNodes.length; i++) {
        listTasksRequest.setDetailed(true); // same request only with detailed description
        TestTasksRequest() {}
        CountDownLatch checkLatch = new CountDownLatch(1);
            final int node = i;
        byParent = (Map<String, Object>) byParent.get("tasks");
                        if (filterNodes.contains(node) == false) {
            super(in);
 * under the License.
        }
        CountDownLatch responseLatch = new CountDownLatch(1);
        }
            public void onFailure(Exception e) {
                threadPool,
        request.setTaskId(new TaskId(testNodes[0].getNodeId(), task.getId()));
                    } catch (InterruptedException ex) {
        ) {
        listTasksRequest.setActions(actionName);
        public String getDescription() {
        for (int i = 1; i < testNodes.length; i++) {
        assertEquals(testNodes.length, children.size()); // two tasks for the first node
        NodesResponse responses = future.get();
        assertEquals(testNodes.length - filterNodes.size(), response.tasks.size());
    }
 *
        for (TaskInfo task : response.getTasks()) {
        TestNode testNode = testNodes[testNodeNum];
            super(taskFailures, nodeFailures);
    public static class NodeRequest extends TransportRequest {
            assertNull(child.get("children"));
        NodesResponse responses = future.get();
            assertEquals(0, testNode.transportService.getTaskManager().getTasks().size());
    private Map<String, Object> serialize(ListTasksResponse response, boolean byParents) throws IOException {
                    logger.info("Action on node {} finished", node);
            request
            return "CancellableNodesRequest[" + requestName + "]";
        TestTasksResponse response = ActionTestUtils.executeBlocking(tasksActions[randomIntBetween(0, nodesCount - 1)], testTasksRequest);
        // Verify that tasks are marked as non-cancellable
        NodesRequest(StreamInput in) throws IOException {
            otherNode = (Map<String, Object>) otherNode.get("tasks");
        setupTestNodes(Settings.EMPTY);
        assertEquals(0, response.getTaskFailures().size()); // no task failed
            requestName = in.readString();
        CancelTasksRequest request = new CancelTasksRequest();
        // Make sure no tasks are running
        }
            assertEquals(1, listeners[i].getRegistrationEvents().size());
        }
import static org.hamcrest.Matchers.hasSize;
        TestTasksRequest testTasksRequest = new TestTasksRequest();
            assertEquals(0, taskGroup.getChildTasks().size());
            out.writeString(requestName);
        checkLatch.countDown();
        return startBlockingTestNodesAction(checkLatch, new NodesRequest("Test Request"), listener);
                ThreadPool.Names.MANAGEMENT
        for (Map.Entry<String, List<TaskInfo>> entry : response.getPerNodeTasks().entrySet()) {
        assertTrue(actionLatch.await(10, TimeUnit.SECONDS));
            // Simulate task action that fails on one of the tasks on one of the nodes
    public void testFindChildTasks() throws Exception {
                        }
            }
        protected TestTasksAction(String actionName, ClusterService clusterService, TransportService transportService) {
            return super.createTask(id, type, action, parentTaskId, headers);
        Map<String, Object> byNodes = serialize(response, true);
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
        Task coordinatingTask = localTasks.get(Collections.min(localTasks.keySet()));
                testNodes[i].transportService
            for (int i = 0; i < taskCount; i++) {
        protected String requestName;
        }
            List<TestTaskResponse> tasks,
            assertEquals(1, entry.getValue().size());
                    List<String> filteredNodes = new ArrayList<>();
        public void writeTo(StreamOutput out) throws IOException {
                builder.add(new TestTaskResponse(in));
        logger.info("Checking currently running tasks");
        @Override
import org.opensearch.core.tasks.TaskId;
import org.opensearch.action.FailedNodeException;
        }
        assertEquals(0, responses.failureCount());
            assertThat(entry.getValue().get(0).getStartTime(), greaterThanOrEqualTo(minimalStartTime));
        assertEquals(0, response.getTasks().size());
            return super.createTask(id, type, action, parentTaskId, headers);
