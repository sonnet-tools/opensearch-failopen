                assertTrue(onTaskCancelled.get());
        @Override
    public void testCancelWithCancellationListenerThrowingException() {
            this.requestName = requestName;
        final TaskManager taskManager = testNodes[0].transportService.getTaskManager();
        assertThat(response.getTasks().size(), lessThanOrEqualTo(runNodesCount));
                }
    }
 * not use this file except in compliance with the License.
                    responseLatch.countDown();
        assertTrue(called.get());
        // Cancel all child tasks without cancelling the main task, which should quit on its own
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportListTasksAction,
        taskManager.cancel(cancellingTask, "test", () -> assertTrue(called.compareAndSet(false, true)));
                public void onResponse(NodesResponse listTasksResponse) {
        );
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
        public CancellableNodeRequest(StreamInput in) throws IOException {
            boolean shouldRun = runOnNodes.contains(testNodes[i]);
                    return false;
            if (shouldBlock) {
        // but may also encounter some nodes where it was still running
        String mainNode = testNodes[0].getNodeId();
        );
        request.setNodes(
        taskManager.addTaskEventListeners(new TaskManager.TaskEventListeners() {
            request
            assertEquals(0, listTasksResponse1.getTasks().size());
        protected String requestName;
        Task mainTask = startCancellableTestNodesAction(
                assertTrue(taskInfo.isCancellable());
        } else {
    class CancellableTestNodesAction extends AbstractTestNodesAction<CancellableNodesRequest, CancellableNodeRequest> {
                // And send the cancellation request to a random node
                    responseLatch.countDown();
        for (int i = 0; i < testNodes.length; i++) {
                    responseReference.set(listTasksResponse);
                new ListTasksRequest().setActions(CancelTasksAction.NAME + "*")
        if (waitForActionToStart) {
            }
            assertThat(responseReference.get().failureCount(), greaterThanOrEqualTo(blockedNodesCount));
        }
import org.opensearch.transport.TransportService;
        }
            assertEquals("No bans on the node " + i, 0, testNodes[i].transportService.getTaskManager().getBanCount());
                // Simulate a job that takes forever to finish
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
            assertEquals(1, response.getTasks().size());
            }
        for (int i = 0; i < threads.length; i++) {
        @Override
import org.opensearch.common.settings.Settings;
import java.util.List;
        taskManager.setBan(new TaskId(testNodes[0].getNodeId(), parentTask.getId()), "test");
            super(actionName, threadPool, clusterService, transportService, CancellableNodesRequest::new, CancellableNodeRequest::new);
        request.setReason("Testing Cancellation");
            @Override
        // Cancel a task that doesn't exist
import org.opensearch.action.support.nodes.BaseNodesRequest;
            @Override
            assertEquals(runNodesCount, responseReference.get().getNodes().size());
        CountDownLatch responseLatch = new CountDownLatch(1);
            int idx = i;
package org.opensearch.action.admin.cluster.node.tasks;
 */
        List<TestNode> blockOnNodes = randomSubsetOf(blockedNodesCount, Arrays.copyOfRange(testNodes, 1, nodesCount));
        boolean waitForActionToStart,
                }
            }
        ListTasksResponse listTasksResponse = ActionTestUtils.executeBlocking(
        taskManager.addTaskEventListeners(new TaskManager.TaskEventListeners() {
            new ListTasksRequest().setParentTaskId(new TaskId(mainNode, mainTask.getId()))
        CancelTasksRequest request = new CancelTasksRequest();
     * Simulates a cancellable node-based task that can be used to block node tasks so they are guaranteed to be registered by task manager
        // Awaiting for the main task to finish
            if (randomBoolean()) {
                }
    }
        return task;
            return new NodeResponse(clusterService.localNode());
        });
        }
            for (int i = 1; i < testNodes.length; i++) {
            assertEquals(mainTask.getId(), response.getTasks().get(0).getId());
        CountDownLatch latch = new CountDownLatch(1);
                shouldBlock,
import org.opensearch.tasks.CancellableTask;
        setupTestNodes(Settings.EMPTY);
            public void onTaskCancelled(CancellableTask task) {
        } else {
            super();
        int blockedNodesCount,
                    testNodes[0].transportService.getConnection(blockOnNode.discoveryNode()).close();
            super(in);
        );
import org.opensearch.core.action.ActionListener;
    public static class CancellableNodeRequest extends TransportRequest {
        @Override
            // We didn't cancel the request and it finished successfully
        @Override
            assertEquals(0, responseReference.get().failureCount());
    public void testChildTasksCancellation() throws Exception {
                public void onFailure(Exception e) {
import static org.opensearch.test.ClusterServiceUtils.setState;
                throwableReference.set(e);
import org.opensearch.transport.TransportRequest;
    }
    public void testRegisterAndExecuteChildTaskWhileParentTaskIsBeingCanceled() throws Exception {
        List<TestNode> runOnNodes = randomSubsetOf(runNodesCount, testNodes);
            Arrays.asList(testNodes),
            boolean shouldBlock,
                    ClusterStateCreationUtils.state(testNodes[i].discoveryNode(), clusterManager, discoveryNodes)
        int numTasks = randomIntBetween(1, 10);
        }
            testNodes[randomIntBetween(1, testNodes.length - 1)].transportCancelTasksAction,
            );
        protected CancellableNodeRequest newNodeRequest(CancellableNodesRequest request) {
                "internal:testAction",
                }
        assertBusy(() -> {
                actionStartedLatch.countDown();
 * this work for additional information regarding copyright
            testNodes[0].transportService,
            if (actionStartedLatch != null) {
        );
            public void onResponse(NodesResponse listTasksResponse) {
        setupTestNodes(Settings.EMPTY);
 * ownership. Elasticsearch licenses this file to you under
        final CountDownLatch actionStartedLatch;
        assertTrue("onChildTasksCompleted() is not invoked", latch.await(1, TimeUnit.SECONDS));
        assertThat(listTasksResponse.getTasks().size(), greaterThanOrEqualTo(blockOnNodes.size()));
    /**
                new ListTasksRequest().setTaskId(new TaskId(mainNode, mainTask.getId()))
                logger.info("--> Done simulating issuing cancel request on the node that is about to leave the cluster");
 * KIND, either express or implied.  See the License for the
import com.carrotsearch.randomizedtesting.RandomizedContext;
        CancellableNodesRequest request,
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksAction;
                threadPool,
        );
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                @Override
import org.opensearch.threadpool.ThreadPool;
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportCancelTasksAction,
                    return true;
            new CancellableNodesRequest("Test Request"),
            request
        public String getDescription() {
            return new CancellableTask(id, type, action, getDescription(), parentTaskId, headers) {
            }
 */
        for (int i = 1; i < testNodes.length; i++) {
            CountDownLatch actionStartedLatch
        final boolean shouldBlock;
            }
        Task mainTask = startCancellableTestNodesAction(
 * Licensed to Elasticsearch under one or more contributor
            assertEquals(0, listTasksResponse.getTasks().size());
            runNodesCount,
    public void testNonExistingTaskCancellation() throws Exception {
        ActionListener<NodesResponse> listener
    }
                    });
    }
            assertNotNull(responseReference.get());
            assertNull(throwableReference.get());
            return "CancellableNodesRequest[" + requestName + "]";
        assertTrue(onTaskCompleted.get());
import org.opensearch.cluster.service.ClusterService;
                onTaskCancelled.set(true);
        String delayName = RandomizedContext.current().getRunnerSeedAsString() + ":" + name;
        }
        );
        assertEquals(0, listTasksResponse.getTasks().size());
                Thread.sleep(RandomNumbers.randomIntBetween(random, 20, 50));
            @Override
        });
        request.setParentTaskId(new TaskId(testNodes[0].getNodeId(), mainTask.getId()));
                } else {
            );
        ) {
/*
            boolean shouldBlock = blockOnNodes.contains(testNodes[i]);
            throw new UnsupportedOperationException("the task parameter is required");
    }
                testNodes[i].transportService,
                } catch (InterruptedException ex) {
        // True if the node operation should get stuck until its cancelled
        request.setTaskId(new TaskId(testNodes[0].getNodeId(), mainTask.getId()));
            new ActionListener<NodesResponse>() {
                logger.info("--> Simulate issuing cancel request on the node that is about to leave the cluster");
            threadPool,
            requestName = in.readString();
        final Task parentTask = taskManager.register("test", "test", parentRequest);
        @Override
            true,
        }
            String actionName,
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportListTasksAction,
        responseLatch.await();
                }
                }
            });
            logger.info("Awaiting for all actions to start");
        // And send the cancellation request to a random node
            @Override
import org.opensearch.core.tasks.TaskCancelledException;
        final TaskId parentTaskId = parentTask.taskInfo(testNodes[0].getNodeId(), false).getTaskId();
        }
        // We shouldn't block on the first node since it's leaving the cluster anyway so it doesn't matter
            );
        assertThat(cancelledException.getMessage(), startsWith("Task cancelled before it started:"));
                public void onFailure(Exception e) {
                assertThat(response.getTaskFailures().size(), lessThanOrEqualTo(1));
 *
        // Shouldn't have cancelled anything
                CancelTasksResponse response = ActionTestUtils.executeBlocking(testNodes[0].transportCancelTasksAction, request);
            testNodes[randomIntBetween(1, testNodes.length - 1)].transportCancelTasksAction,
            assertNull(throwableReference.get());
        int runNodesCount = randomIntBetween(1, nodesCount);
                new ListTasksRequest().setTaskId(new TaskId(testNodes[0].getNodeId(), mainTask.getId()))
        }
        AtomicBoolean onTaskCancelled = new AtomicBoolean();
        CancelTasksResponse response = ActionTestUtils.executeBlocking(
            out.writeString(requestName);
            blockOnNodes,
 * specific language governing permissions and limitations
        }
            randomSubsetOf(blockedNodesCount, runOnNodes),
            "internal:testAction",
import org.opensearch.tasks.TaskManager;
                throw new OpenSearchException("Exception");
    ) throws InterruptedException {
        CancelTasksResponse response = ActionTestUtils.executeBlocking(
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
        boolean waitForActionToStart,
        // Wait for clean up
                testNodes[i].clusterService,
                    responseLatch.countDown();
                shouldRun,
        }
            waitForActionToStart,
                }
                    throwableReference.set(e);
    public void testBasicTaskCancellation() throws Exception {
            ListTasksResponse listTasksResponse1 = ActionTestUtils.executeBlocking(
                actionLatch
                // Notify only nodes that should remain in the cluster
 * license agreements. See the NOTICE file distributed with
        setupTestNodes(Settings.EMPTY);
        int runNodesCount,
        }
            debugDelay("op2");
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    private Task startCancellableTestNodesAction(
        final TaskManager taskManager = testNodes[0].transportService.getTaskManager();
        final CancellableTask cancellingTask = randomFrom(tasks);
        private String requestName;
        if (RandomNumbers.randomIntBetween(random, 0, 10) < 1) {
            for (int i = 1; i < testNodes.length; i++) {
            TransportService transportService,
    }
                @Override
            }
        childRequest.setParentTask(parentTaskId);
        phaser.arriveAndAwaitAdvance();
        AtomicBoolean onTaskCompleted = new AtomicBoolean();
        @Override
        );
                );
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
        public CancellableNodeRequest(CancellableNodesRequest request) {
            // That should be rare and can be only in case we didn't block on a single node
            }
                    testNodes[0].transportService.disconnectFromNode(blockOnNode.discoveryNode());
        });
        // Simulate the coordinating node leaving the cluster
    ) throws InterruptedException {
        }
            requestName = request.requestName;
        ListTasksResponse listTasksResponse = ActionTestUtils.executeBlocking(
        List<CancellableTask> tasks = new ArrayList<>(numTasks);
            super.writeTo(out);
    private static void debugDelay(String name) {
import org.opensearch.core.common.io.stream.StreamInput;
        public void writeTo(StreamOutput out) throws IOException {
        Task task = actions[0].execute(request, listener);
            // Make sure that main task is no longer running
        setupTestNodes(Settings.EMPTY);
        assertThrows(OpenSearchException.class, () -> taskManager.cancel(cancellableTask, "test", () -> taskCompleted.set(true)));
import java.util.concurrent.TimeUnit;
            // Make sure that tasks are no longer running
            }
            threads[i] = new Thread(() -> {
    }
            @Override
                @Override
 * The OpenSearch Contributors require contributions made to
import java.util.Random;
                    throwableReference.set(e);
 * the Apache License, Version 2.0 (the "License"); you may
            assert task instanceof CancellableTask;
        for (int i = 0; i < threads.length; i++) {
            logger.info(
        assertThat(response.getTasks().size(), greaterThanOrEqualTo(blockedNodesCount));
        if (randomBoolean()) {
                }
import org.opensearch.core.common.io.stream.StreamOutput;
            this.shouldBlock = shouldBlock;
    }
        CountDownLatch responseLatch = new CountDownLatch(1);
                testNodes[i].getNodeId(),
        }
            public void onTaskCompleted(Task task) {
        for (int i = 0; i < numTasks; i++) {
                    fail("It should have thrown an exception");
        int blockedNodesCount = randomIntBetween(0, nodesCount - 1);
        logger.info("waitForActionToStart is set to {}", waitForActionToStart);
        AtomicBoolean taskCompleted = new AtomicBoolean();
                    waitUntil(() -> {
        connectNodes(testNodes);
            ClusterService clusterService,
            super.writeTo(out);
                            throw new TaskCancelledException("Cancelled");
        });
                request.setReason("Testing Cancellation");
            }
     */
    public void testCancelConcurrently() throws Exception {
            logger.info("Done waiting for all actions to start");
        private CancellableNodesRequest(StreamInput in) throws IOException {
            // Make sure that the request was successful
        @Override
import org.opensearch.action.support.ActionTestUtils;
        // while the ban is still there, but it should disappear shortly
import org.opensearch.cluster.node.DiscoveryNode;
            ThreadPool threadPool,
        if (response.getTasks().size() == 0) {
        public CancellableNodesRequest(String requestName, String... nodesIds) {
        CancellableTestNodesAction testAction = new CancellableTestNodesAction(
        request.setReason("Testing Cancellation");
            }
        });
            for (TaskInfo taskInfo : response.getTasks()) {
        CancelTasksRequest request = new CancelTasksRequest();
import static org.hamcrest.Matchers.equalTo;
            new ActionListener<NodesResponse>() {
        }
 *
                CancelTasksRequest request = new CancelTasksRequest();
                @Override
            this.actionStartedLatch = actionStartedLatch;
        }
            request
        assertFalse(taskCompleted.get());
            super(nodesIds);
import java.util.concurrent.CountDownLatch;
 * You may obtain a copy of the License at
    private Task startCancellableTestNodesAction(
        CancellableNodesRequest parentRequest = new CancellableNodesRequest("parent");
        }
                        if (((CancellableTask) task).isCancelled()) {
        }
        );
        }
            for (int i = 0; i < testNodes.length; i++) {
/*
            };
        if (randomBoolean()) {
            ListTasksResponse listTasksResponse = ActionTestUtils.executeBlocking(
            randomSubsetOf(randomIntBetween(1, testNodes.length - 1), testNodes).stream().map(TestNode::getNodeId).toArray(String[]::new)
import java.util.Map;
        CancellableTestNodesAction(
            DiscoveryNode[] discoveryNodes = new DiscoveryNode[testNodes.length - 1];
    }
            ListTasksResponse listTasksResponse = ActionTestUtils.executeBlocking(
/*
            }
        protected NodeResponse nodeOperation(CancellableNodeRequest request) {
    }
 * GitHub history for details.
            } catch (InterruptedException ex) {
                // This node still thinks that's part of the cluster, so cancelling should look successful
                assertThat(response.getTasks().size(), lessThanOrEqualTo(1));
            public void onTaskCancelled(CancellableTask task) {
        assertBusy(() -> {
                @Override
            false,
public class CancellableTasksTests extends TaskManagerTestCase {
 * Modifications Copyright OpenSearch Contributors. See
                request.setTaskId(new TaskId(testNodes[0].getNodeId(), mainTask.getId()));
        setupTestNodes(Settings.EMPTY);
        responseLatch.await();
            waitForActionToStart,
            return new CancellableNodeRequest(request);
        taskManager.unregister(cancellingTask);
        }
import java.util.concurrent.Phaser;
        CancellableNodesRequest childRequest = new CancellableNodesRequest("child");
        CancellableTask cancellableTask = (CancellableTask) taskManager.register("type-0", "action-0", new CancellableNodeRequest());
        boolean waitForActionToStart = randomBoolean();
        request.setActions("do-not-match-anything");
import org.opensearch.tasks.TaskInfo;
                responseLatch.countDown();
        // Make sure that tasks are no longer running
 * compatible open source license.
        Task mainTask = startCancellableTestNodesAction(true, runNodesCount, blockedNodesCount, new ActionListener<NodesResponse>() {
                    logger.error("!!!!");
                testNodes[randomIntBetween(0, testNodes.length - 1)].transportListTasksAction,
            assertEquals(runNodesCount, responseReference.get().failureCount() + responseReference.get().getNodes().size());
                testNodes[randomIntBetween(0, testNodes.length - 1)].transportListTasksAction,
            assertEquals(0, listTasksResponse.getTasks().size());
            for (TestNode blockOnNode : blockOnNodes) {
            blockedNodesCount,
    }
                responseReference.set(listTasksResponse);
 * software distributed under the License is distributed on an
                testNodes[randomIntBetween(1, testNodes.length - 1)].transportListTasksAction,
        assertBusy(() -> {
            // (we might have cancelled some non-blocked operations before they even started and that's ok)
        Phaser phaser = new Phaser(threads.length + 1);
        // Awaiting for the main task to finish
            new CountDownLatch(1)
            testNodes[1].clusterService,
                public void onResponse(NodesResponse listTasksResponse) {
            // We should have the information about the cancelled task in the cancel operation response
        // Should have cancelled tasks at least on all nodes where it was blocked
        });
            DiscoveryNode clusterManager = discoveryNodes[0];
        // Make sure that there are no leftover bans, the ban removal is async, so we might return from the cancellation
}
                // Simulate issuing cancel request on the node that is about to leave the cluster
            debugDelay("op4");
                if (response.getTasks().size() == 0) {
            threads[i].join();
            try {
            listener
                "The action on the node [{}] should run: [{}] should block: [{}]",
        final TaskManager taskManager = testNodes[0].transportService.getTaskManager();
        public void writeTo(StreamOutput out) throws IOException {
    public static class CancellableNodesRequest extends BaseNodesRequest<CancellableNodesRequest> {
                assertThat(response.getTaskFailures().size() + response.getTasks().size(), lessThanOrEqualTo(1));
        return startCancellableTestNodesAction(
                    Thread.currentThread().interrupt();
import org.opensearch.core.tasks.TaskId;
            // We canceled the request, in this case it should have fail, but we should get partial response
            super(in);
        CancelTasksResponse response = ActionTestUtils.executeBlocking(
import org.opensearch.tasks.Task;
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
                    responseReference.set(listTasksResponse);
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
                assertEquals("No bans on the node " + i, 0, testNodes[i].transportService.getTaskManager().getBanCount());
        ActionListener<NodesResponse> listener
import java.util.ArrayList;
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
import java.util.concurrent.atomic.AtomicReference;
        }
        TaskCancelledException cancelledException = expectThrows(
import java.util.concurrent.atomic.AtomicBoolean;
                try {
                }
        });
        // And send the cancellation request to a random node
                        }
        public CancellableNodeRequest() {
        setupTestNodes(Settings.EMPTY);
            () -> testAction.execute(childRequest, ActionListener.wrap(() -> fail("must not execute")))
    public void testTaskCancellationOnCoordinatingNodeLeavingTheCluster() throws Exception {
        AtomicIntegerArray notified = new AtomicIntegerArray(threads.length);
        );
        connectNodes(testNodes);
            requestName = in.readString();
            threads[i].start();
        }
        // Cancel main task
        }
        int blockedNodesCount = randomIntBetween(0, runNodesCount);
                responseLatch.countDown();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // Make sure that main task is no longer running
                public boolean shouldCancelChildrenOnCancellation() {
                public boolean shouldCancelChildrenOnCancellation() {
import java.util.concurrent.atomic.AtomicIntegerArray;
            // and we should have at least as many failures as the number of blocked operations
            TaskCancelledException.class,
        }
 * Unless required by applicable law or agreed to in writing,
        public String getDescription() {
        @Override
        int blockedNodesCount = randomIntBetween(0, runNodesCount);
            return new CancellableTask(id, type, action, getDescription(), parentTaskId, headers) {
        }
            out.writeString(requestName);
                    responseLatch.countDown();
            runOnNodes,
            assertEquals(0, blockedNodesCount);
                discoveryNodes[i - 1] = testNodes[i].discoveryNode();
                        return false;
                onTaskCompleted.set(true);
        List<TestNode> runOnNodes,
        // Make sure that tasks are running
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
import java.util.Collection;
        responseLatch.await();
            );
            assertThat(notified.get(i), equalTo(1));
        assertBusy(() -> {
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
 * SPDX-License-Identifier: Apache-2.0
            actions[i] = new CancellableTestNodesAction(
                setState(
                if (randomBoolean()) {
            }
            debugDelay("op1");
                @Override
        connectNodes(testNodes);
        connectNodes(testNodes);
        int runNodesCount = randomIntBetween(1, nodesCount);
 * under the License.
        Random random = new Random(delayName.hashCode());
        }
        Collection<TestNode> blockOnNodes,
        Thread[] threads = new Thread[randomIntBetween(1, 8)];
        setupTestNodes(Settings.EMPTY);
            actionLatch.await();
        CountDownLatch actionLatch = waitForActionToStart ? new CountDownLatch(runOnNodes.size()) : null;
        taskManager.startBanOnChildrenNodes(parentTaskId.getId(), latch::countDown, cancelledException.getMessage());
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
        CountDownLatch responseLatch = new CountDownLatch(1);
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
    }
        CancellableTestNodesAction[] actions = new CancellableTestNodesAction[nodesCount];
import java.io.IOException;
 */
 *
                Thread.currentThread().interrupt();
            );
            }
import org.opensearch.OpenSearchException;
                    testNodes[i].clusterService,
        // Introduce an additional pseudo random repeatable race conditions
            new ListTasksRequest().setTaskId(new TaskId(testNodes[0].getNodeId(), mainTask.getId()))
        request.setReason("Testing Cancellation");
            tasks.add((CancellableTask) taskManager.register("type-" + i, "action-" + i, new CancellableNodeRequest()));
                taskManager.cancel(cancellingTask, "test", () -> assertTrue(notified.compareAndSet(idx, 0, 1)));
                shouldBlock
        connectNodes(testNodes);
                phaser.arriveAndAwaitAdvance();
            public void onFailure(Exception e) {
            return "CancellableNodeRequest[" + requestName + "]";
            testNodes[0].close();
            }
        CancelTasksRequest request = new CancelTasksRequest();
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
            // Verify that all cancelled tasks reported that they support cancellation
        AtomicBoolean called = new AtomicBoolean();
 * this file be licensed under the Apache-2.0 license or a
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
            };
            new CancellableNodesRequest("Test Request", runOnNodes.stream().map(TestNode::getNodeId).toArray(String[]::new)),
        @Override
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
                // Using periodic checks method to identify that the task was cancelled
            }
        );
        protected NodeResponse nodeOperation(CancellableNodeRequest request, Task task) {
import static org.hamcrest.Matchers.startsWith;
        assertThat(response.getTasks().size(), equalTo(0));
import java.util.Arrays;
        // And send the cancellation request to a random node
            }
