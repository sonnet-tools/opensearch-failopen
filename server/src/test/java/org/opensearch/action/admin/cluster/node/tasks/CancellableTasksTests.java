        final CountDownLatch actionStartedLatch;
        @Override  
        boolean waitForActionToStart = randomBoolean();  
                throw new OpenSearchException("Exception");
        setupTestNodes(Settings.EMPTY);
                public void onResponse(NodesResponse listTasksResponse) {  
            boolean shouldBlock,  
                actionStartedLatch.countDown();  
import org.opensearch.tasks.TaskInfo;
        }  
 * Unless required by applicable law or agreed to in writing,
                @Override
        AtomicBoolean onTaskCompleted = new AtomicBoolean();
import org.opensearch.core.tasks.TaskCancelledException;  
            // (we might have cancelled some non-blocked operations before they even started and that's ok)
        public CancellableNodeRequest(StreamInput in) throws IOException {  
        Task mainTask = startCancellableTestNodesAction(  
            boolean shouldBlock = blockOnNodes.contains(testNodes[i]);  
            assertNull(throwableReference.get());
 *
                onTaskCompleted.set(true);
                // Simulate a job that takes forever to finish
            // Make sure that main task is no longer running
            testNodes[0].transportService,  
        }
        assertBusy(() -> {  
import java.util.concurrent.atomic.AtomicReference;
        responseLatch.await();
        }
            out.writeString(requestName);  
            request
            super(actionName, threadPool, clusterService, transportService, CancellableNodesRequest::new, CancellableNodeRequest::new);  
                            throw new TaskCancelledException("Cancelled");
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportCancelTasksAction,
            return new CancellableNodeRequest(request);
            });
            }
    }  
        assertThat(response.getTasks().size(), greaterThanOrEqualTo(blockedNodesCount));
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        }  
import org.opensearch.core.tasks.TaskId;
import org.opensearch.transport.TransportRequest;
        setupTestNodes(Settings.EMPTY);  
                public void onFailure(Exception e) {
            );
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
        CancelTasksResponse response = ActionTestUtils.executeBlocking(  
    }
            for (int i = 1; i < testNodes.length; i++) {
        int blockedNodesCount = randomIntBetween(0, runNodesCount);
        );  
        ActionListener<NodesResponse> listener
            }  
        for (int i = 0; i < threads.length; i++) {
        setupTestNodes(Settings.EMPTY);
            return "CancellableNodesRequest[" + requestName + "]";
        connectNodes(testNodes);
/*
        // We shouldn't block on the first node since it's leaving the cluster anyway so it doesn't matter
 * specific language governing permissions and limitations
        // Shouldn't have cancelled anything  
import org.opensearch.tasks.CancellableTask;
        }  
        assertTrue(called.get());
        final boolean shouldBlock;  
                testNodes[randomIntBetween(0, testNodes.length - 1)].transportListTasksAction,  
            }  
package org.opensearch.action.admin.cluster.node.tasks;
                taskManager.cancel(cancellingTask, "test", () -> assertTrue(notified.compareAndSet(idx, 0, 1)));  
        }  
        }
            assertEquals(mainTask.getId(), response.getTasks().get(0).getId());  
            new CancellableNodesRequest("Test Request", runOnNodes.stream().map(TestNode::getNodeId).toArray(String[]::new)),  
            false,
        @Override
                responseReference.set(listTasksResponse);
        );
                // And send the cancellation request to a random node
        Phaser phaser = new Phaser(threads.length + 1);  
            for (TaskInfo taskInfo : response.getTasks()) {
                // Notify only nodes that should remain in the cluster
            randomSubsetOf(blockedNodesCount, runOnNodes),
 * this work for additional information regarding copyright
            assertEquals(0, blockedNodesCount);
        responseLatch.await();  
            tasks.add((CancellableTask) taskManager.register("type-" + i, "action-" + i, new CancellableNodeRequest()));
            }
        CancelTasksRequest request = new CancelTasksRequest();
        assertFalse(taskCompleted.get());
                    waitUntil(() -> {
        } else {
                        return false;  
        CancellableNodesRequest request,  
        protected CancellableNodeRequest newNodeRequest(CancellableNodesRequest request) {  
        return startCancellableTestNodesAction(
        // True if the node operation should get stuck until its cancelled
 * the Apache License, Version 2.0 (the "License"); you may
        List<CancellableTask> tasks = new ArrayList<>(numTasks);  
        public CancellableNodeRequest() {
                    responseReference.set(listTasksResponse);
    private Task startCancellableTestNodesAction(  
                assertEquals("No bans on the node " + i, 0, testNodes[i].transportService.getTaskManager().getBanCount());  
        // Cancel main task
        protected NodeResponse nodeOperation(CancellableNodeRequest request, Task task) {
    }
                shouldBlock  
                    return true;  
        @Override
                    logger.error("!!!!");  
                // This node still thinks that's part of the cluster, so cancelling should look successful
        CancelTasksResponse response = ActionTestUtils.executeBlocking(
    }  
 * SPDX-License-Identifier: Apache-2.0
        taskManager.setBan(new TaskId(testNodes[0].getNodeId(), parentTask.getId()), "test");
            assertEquals(1, response.getTasks().size());
import org.opensearch.core.common.io.stream.StreamOutput;
        assertBusy(() -> {  
        connectNodes(testNodes);  
            if (randomBoolean()) {
                    responseLatch.countDown();
        List<TestNode> blockOnNodes = randomSubsetOf(blockedNodesCount, Arrays.copyOfRange(testNodes, 1, nodesCount));
        Thread[] threads = new Thread[randomIntBetween(1, 8)];
        taskManager.unregister(cancellingTask);  
        // Awaiting for the main task to finish
    public static class CancellableNodeRequest extends TransportRequest {
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
            public void onFailure(Exception e) {  
                threadPool,
            }
            blockOnNodes,  
        // Simulate the coordinating node leaving the cluster
            assertEquals(runNodesCount, responseReference.get().failureCount() + responseReference.get().getNodes().size());
        connectNodes(testNodes);
                responseLatch.countDown();
        assertThrows(OpenSearchException.class, () -> taskManager.cancel(cancellableTask, "test", () -> taskCompleted.set(true)));
        );
 * not use this file except in compliance with the License.
            super(in);
            super.writeTo(out);
                @Override
        if (response.getTasks().size() == 0) {
        setupTestNodes(Settings.EMPTY);
            super();  
            debugDelay("op4");
        // Make sure that tasks are running
        }
            this.requestName = requestName;
            assertEquals("No bans on the node " + i, 0, testNodes[i].transportService.getTaskManager().getBanCount());  
    }
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
                discoveryNodes[i - 1] = testNodes[i].discoveryNode();  
        setupTestNodes(Settings.EMPTY);  
            randomSubsetOf(randomIntBetween(1, testNodes.length - 1), testNodes).stream().map(TestNode::getNodeId).toArray(String[]::new)
            int idx = i;  
    ) throws InterruptedException {
        public void writeTo(StreamOutput out) throws IOException {  
        responseLatch.await();
            waitForActionToStart,
}  
import org.opensearch.transport.TransportService;
                request.setReason("Testing Cancellation");
                onTaskCancelled.set(true);  
        if (randomBoolean()) {  
        AtomicBoolean called = new AtomicBoolean();  
        assertEquals(0, listTasksResponse.getTasks().size());  
        }  
        Random random = new Random(delayName.hashCode());
        CancellableTask cancellableTask = (CancellableTask) taskManager.register("type-0", "action-0", new CancellableNodeRequest());
        final CancellableTask cancellingTask = randomFrom(tasks);
 * this file be licensed under the Apache-2.0 license or a
            assertNull(throwableReference.get());
            return new NodeResponse(clusterService.localNode());  
            // We should have the information about the cancelled task in the cancel operation response
    }
            public void onTaskCancelled(CancellableTask task) {
                }  
                @Override
import java.util.ArrayList;
        public String getDescription() {  
            throw new UnsupportedOperationException("the task parameter is required");
 * under the License.  
                public boolean shouldCancelChildrenOnCancellation() {  
        CountDownLatch responseLatch = new CountDownLatch(1);
            threadPool,
                testNodes[i].clusterService,
            if (shouldBlock) {
                responseLatch.countDown();
        assertThat(response.getTasks().size(), lessThanOrEqualTo(runNodesCount));
        private String requestName;
            ListTasksResponse listTasksResponse1 = ActionTestUtils.executeBlocking(
 */
        @Override
        // Cancel a task that doesn't exist
        CancelTasksResponse response = ActionTestUtils.executeBlocking(
        ListTasksResponse listTasksResponse = ActionTestUtils.executeBlocking(
            return new CancellableTask(id, type, action, getDescription(), parentTaskId, headers) {
            } catch (InterruptedException ex) {  
        CancellableNodesRequest childRequest = new CancellableNodesRequest("child");  
            };
        connectNodes(testNodes);
            () -> testAction.execute(childRequest, ActionListener.wrap(() -> fail("must not execute")))  
        request.setTaskId(new TaskId(testNodes[0].getNodeId(), mainTask.getId()));
        );
            }
        CountDownLatch actionLatch = waitForActionToStart ? new CountDownLatch(runOnNodes.size()) : null;  
        assertBusy(() -> {  
        public CancellableNodesRequest(String requestName, String... nodesIds) {  
                    Thread.currentThread().interrupt();
                phaser.arriveAndAwaitAdvance();
 */  
                logger.info("--> Done simulating issuing cancel request on the node that is about to leave the cluster");  
        List<TestNode> runOnNodes,
        CancellableTestNodesAction[] actions = new CancellableTestNodesAction[nodesCount];
                }  
        for (int i = 1; i < testNodes.length; i++) {
 * license agreements. See the NOTICE file distributed with
        public String getDescription() {
        request.setReason("Testing Cancellation");
                testNodes[randomIntBetween(1, testNodes.length - 1)].transportListTasksAction,  
        }
            threads[i].start();  
                public void onResponse(NodesResponse listTasksResponse) {
    public void testCancelConcurrently() throws Exception {
            assertEquals(runNodesCount, responseReference.get().getNodes().size());  
import java.util.concurrent.Phaser;  
        final TaskManager taskManager = testNodes[0].transportService.getTaskManager();  
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();  
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();  
            debugDelay("op1");
            Arrays.asList(testNodes),
        private CancellableNodesRequest(StreamInput in) throws IOException {
                        if (((CancellableTask) task).isCancelled()) {  
    public static class CancellableNodesRequest extends BaseNodesRequest<CancellableNodesRequest> {
                @Override  
        TaskCancelledException cancelledException = expectThrows(
            // We didn't cancel the request and it finished successfully  
        }
/*
import org.opensearch.core.common.io.stream.StreamInput;
            }  
        final TaskManager taskManager = testNodes[0].transportService.getTaskManager();
        CountDownLatch responseLatch = new CountDownLatch(1);
                assertThat(response.getTasks().size(), lessThanOrEqualTo(1));
                    });
                    fail("It should have thrown an exception");
        CountDownLatch latch = new CountDownLatch(1);  
        });
            blockedNodesCount,  
        assertTrue(onTaskCompleted.get());
        AtomicBoolean onTaskCancelled = new AtomicBoolean();
            );  
        ) {
        CancellableNodesRequest parentRequest = new CancellableNodesRequest("parent");
 * software distributed under the License is distributed on an
            testNodes[1].clusterService,
        assertThat(response.getTasks().size(), equalTo(0));
        @Override  
            ListTasksResponse listTasksResponse = ActionTestUtils.executeBlocking(
import static org.hamcrest.Matchers.startsWith;
import java.util.concurrent.CountDownLatch;
            this.actionStartedLatch = actionStartedLatch;
        CancelTasksRequest request = new CancelTasksRequest();  
        return task;
        assertThat(listTasksResponse.getTasks().size(), greaterThanOrEqualTo(blockOnNodes.size()));  
        // but may also encounter some nodes where it was still running  
                );
    public void testRegisterAndExecuteChildTaskWhileParentTaskIsBeingCanceled() throws Exception {
            for (int i = 1; i < testNodes.length; i++) {  
        protected NodeResponse nodeOperation(CancellableNodeRequest request) {
            requestName = in.readString();  
 * ownership. Elasticsearch licenses this file to you under  
            runOnNodes,
        request.setNodes(  
        AtomicBoolean taskCompleted = new AtomicBoolean();  
        );
     * Simulates a cancellable node-based task that can be used to block node tasks so they are guaranteed to be registered by task manager
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();  
                }
    }
 */
import org.opensearch.common.settings.Settings;
        taskManager.startBanOnChildrenNodes(parentTaskId.getId(), latch::countDown, cancelledException.getMessage());
 * compatible open source license.
            }
            new CancellableNodesRequest("Test Request"),
            );
        }  
                throwableReference.set(e);
import org.opensearch.tasks.TaskManager;
            debugDelay("op2");  
 * Modifications Copyright OpenSearch Contributors. See  
        CancellableTestNodesAction testAction = new CancellableTestNodesAction(
                    responseLatch.countDown();  
                    responseLatch.countDown();
        // Make sure that tasks are no longer running
            waitForActionToStart,  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            request
                new ListTasksRequest().setActions(CancelTasksAction.NAME + "*")
            // Make sure that main task is no longer running
        // Wait for clean up  
        }  
            requestName = in.readString();
            public void onTaskCompleted(Task task) {
 * KIND, either express or implied.  See the License for the
            request  
                    return false;
                request.setTaskId(new TaskId(testNodes[0].getNodeId(), mainTask.getId()));  
            new ListTasksRequest().setParentTaskId(new TaskId(mainNode, mainTask.getId()))
    }
        String mainNode = testNodes[0].getNodeId();
                } else {  
                new ListTasksRequest().setTaskId(new TaskId(mainNode, mainTask.getId()))
                        }
                setState(
        setupTestNodes(Settings.EMPTY);  
            logger.info("Done waiting for all actions to start");  
import java.util.List;
                new ListTasksRequest().setTaskId(new TaskId(testNodes[0].getNodeId(), mainTask.getId()))
        taskManager.addTaskEventListeners(new TaskManager.TaskEventListeners() {
public class CancellableTasksTests extends TaskManagerTestCase {  
                assertThat(response.getTaskFailures().size() + response.getTasks().size(), lessThanOrEqualTo(1));
import org.opensearch.threadpool.ThreadPool;  
        for (int i = 0; i < testNodes.length; i++) {
import org.opensearch.cluster.service.ClusterService;
        });
        }
        for (int i = 0; i < numTasks; i++) {
            }  
        request.setReason("Testing Cancellation");
        assertTrue("onChildTasksCompleted() is not invoked", latch.await(1, TimeUnit.SECONDS));
import java.util.concurrent.atomic.AtomicIntegerArray;  
            assertNotNull(responseReference.get());
        ActionListener<NodesResponse> listener
        } else {
                }
            assert task instanceof CancellableTask;  
            TaskCancelledException.class,
            requestName = request.requestName;  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;  
            }
            }
        }
            TransportService transportService,
        int runNodesCount = randomIntBetween(1, nodesCount);
                "internal:testAction",  
                }
                assertTrue(onTaskCancelled.get());
            );
            new ListTasksRequest().setTaskId(new TaskId(testNodes[0].getNodeId(), mainTask.getId()))
                }
            @Override
        public void writeTo(StreamOutput out) throws IOException {
            @Override
        // Awaiting for the main task to finish
        boolean waitForActionToStart,  
            }  
        Task mainTask = startCancellableTestNodesAction(true, runNodesCount, blockedNodesCount, new ActionListener<NodesResponse>() {
            }
            DiscoveryNode clusterManager = discoveryNodes[0];
            true,
        if (randomBoolean()) {  
        @Override  
        );  
 * You may obtain a copy of the License at  
        // And send the cancellation request to a random node  
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        });
            public void onTaskCancelled(CancellableTask task) {
            ClusterService clusterService,
                    responseReference.set(listTasksResponse);
        int blockedNodesCount = randomIntBetween(0, runNodesCount);  
import java.util.Collection;
            ListTasksResponse listTasksResponse = ActionTestUtils.executeBlocking(
            out.writeString(requestName);
 *  
import org.opensearch.cluster.node.DiscoveryNode;  
                public boolean shouldCancelChildrenOnCancellation() {
        }
        int runNodesCount,
                shouldRun,
    }
            threads[i] = new Thread(() -> {
            super(in);
        // Should have cancelled tasks at least on all nodes where it was blocked
        }
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
                @Override  
            listener
                shouldBlock,
                    throwableReference.set(e);
            };  
        @Override
        }
    }  
            );
        List<TestNode> runOnNodes = randomSubsetOf(runNodesCount, testNodes);  
    public void testChildTasksCancellation() throws Exception {
            super(nodesIds);
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksAction;
            logger.info("Awaiting for all actions to start");
        AtomicIntegerArray notified = new AtomicIntegerArray(threads.length);
            assertEquals(0, listTasksResponse.getTasks().size());  
        int numTasks = randomIntBetween(1, 10);
                    ClusterStateCreationUtils.state(testNodes[i].discoveryNode(), clusterManager, discoveryNodes)
            // and we should have at least as many failures as the number of blocked operations  
    public void testCancelWithCancellationListenerThrowingException() {
                @Override
                }
            assertThat(notified.get(i), equalTo(1));
            testNodes[0].close();
                    responseLatch.countDown();  
                logger.info("--> Simulate issuing cancel request on the node that is about to leave the cluster");
     */
                Thread.sleep(RandomNumbers.randomIntBetween(random, 20, 50));
            @Override  
            // Verify that all cancelled tasks reported that they support cancellation
        // Make sure that there are no leftover bans, the ban removal is async, so we might return from the cancellation
            // Make sure that the request was successful  
        String delayName = RandomizedContext.current().getRunnerSeedAsString() + ":" + name;
        request.setActions("do-not-match-anything");
        });
        }
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean waitForActionToStart,
import java.util.Map;  
                    testNodes[0].transportService.getConnection(blockOnNode.discoveryNode()).close();
        );
            actions[i] = new CancellableTestNodesAction(
        childRequest.setParentTask(parentTaskId);
        logger.info("waitForActionToStart is set to {}", waitForActionToStart);
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
        }
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
        );
            new CountDownLatch(1)
            new ActionListener<NodesResponse>() {
import static org.hamcrest.Matchers.equalTo;
        // And send the cancellation request to a random node
            ThreadPool threadPool,  
                actionLatch
 *    http://www.apache.org/licenses/LICENSE-2.0
            "internal:testAction",  
import java.io.IOException;
    }  
            DiscoveryNode[] discoveryNodes = new DiscoveryNode[testNodes.length - 1];
            for (int i = 0; i < testNodes.length; i++) {
            }  
            super.writeTo(out);
        }
            runNodesCount,
                testNodes[randomIntBetween(0, testNodes.length - 1)].transportListTasksAction,  
                testNodes[i].getNodeId(),
            // We canceled the request, in this case it should have fail, but we should get partial response  
import org.opensearch.action.support.ActionTestUtils;  
                try {
        request.setReason("Testing Cancellation");  
            assertThat(responseReference.get().failureCount(), greaterThanOrEqualTo(blockedNodesCount));
            this.shouldBlock = shouldBlock;
        });
                CancelTasksRequest request = new CancelTasksRequest();
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportListTasksAction,  
            testNodes[randomIntBetween(1, testNodes.length - 1)].transportCancelTasksAction,
            assertEquals(0, listTasksResponse1.getTasks().size());  
import java.util.Arrays;  
            logger.info(
        }
                }
    class CancellableTestNodesAction extends AbstractTestNodesAction<CancellableNodesRequest, CancellableNodeRequest> {  
        });
            boolean shouldRun = runOnNodes.contains(testNodes[i]);
import com.carrotsearch.randomizedtesting.RandomizedContext;  
            for (TestNode blockOnNode : blockOnNodes) {  
        public CancellableNodeRequest(CancellableNodesRequest request) {
import static org.opensearch.test.ClusterServiceUtils.setState;  
                assertTrue(taskInfo.isCancellable());  
import java.util.concurrent.atomic.AtomicBoolean;
/*  
                } catch (InterruptedException ex) {  
        }  
            CountDownLatch actionStartedLatch
                public void onFailure(Exception e) {  
        );
        for (int i = 0; i < threads.length; i++) {
import org.opensearch.action.support.nodes.BaseNodesRequest;
        // while the ban is still there, but it should disappear shortly  
            if (actionStartedLatch != null) {
        final TaskManager taskManager = testNodes[0].transportService.getTaskManager();
    public void testNonExistingTaskCancellation() throws Exception {
 *
        }  
        );  
            @Override  
        CancelTasksRequest request = new CancelTasksRequest();
                // Using periodic checks method to identify that the task was cancelled  
        phaser.arriveAndAwaitAdvance();
        request.setParentTaskId(new TaskId(testNodes[0].getNodeId(), mainTask.getId()));  
        int runNodesCount = randomIntBetween(1, nodesCount);
            // That should be rare and can be only in case we didn't block on a single node
            @Override
 * Licensed to Elasticsearch under one or more contributor  
            public void onResponse(NodesResponse listTasksResponse) {  
import org.opensearch.OpenSearchException;  
    public void testBasicTaskCancellation() throws Exception {
            assertEquals(0, listTasksResponse.getTasks().size());  
                if (randomBoolean()) {
        protected String requestName;  
    /**  
    private Task startCancellableTestNodesAction(
 * The OpenSearch Contributors require contributions made to  
                CancelTasksResponse response = ActionTestUtils.executeBlocking(testNodes[0].transportCancelTasksAction, request);
        assertBusy(() -> {
        assertThat(cancelledException.getMessage(), startsWith("Task cancelled before it started:"));
    public void testTaskCancellationOnCoordinatingNodeLeavingTheCluster() throws Exception {
        int blockedNodesCount = randomIntBetween(0, nodesCount - 1);
    private static void debugDelay(String name) {
                    throwableReference.set(e);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        if (waitForActionToStart) {  
        }  
        connectNodes(testNodes);  
        taskManager.cancel(cancellingTask, "test", () -> assertTrue(called.compareAndSet(false, true)));
            }  
import java.util.Random;
    }  
            String actionName,
                // Simulate issuing cancel request on the node that is about to leave the cluster  
                    testNodes[0].transportService.disconnectFromNode(blockOnNode.discoveryNode());
import java.util.concurrent.TimeUnit;
        final Task parentTask = taskManager.register("test", "test", parentRequest);  
            return new CancellableTask(id, type, action, getDescription(), parentTaskId, headers) {  
 * GitHub history for details.
            // Make sure that tasks are no longer running
            testNodes[randomIntBetween(0, testNodes.length - 1)].transportListTasksAction,  
                "The action on the node [{}] should run: [{}] should block: [{}]",  
        Collection<TestNode> blockOnNodes,
                assertThat(response.getTaskFailures().size(), lessThanOrEqualTo(1));  
        @Override
        if (RandomNumbers.randomIntBetween(random, 0, 10) < 1) {  
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
        int blockedNodesCount,  
                }
    ) throws InterruptedException {
            try {
        // Introduce an additional pseudo random repeatable race conditions  
                    testNodes[i].clusterService,  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
        });
import org.opensearch.core.action.ActionListener;  
        // Cancel all child tasks without cancelling the main task, which should quit on its own  
        @Override
            return "CancellableNodeRequest[" + requestName + "]";
        taskManager.addTaskEventListeners(new TaskManager.TaskEventListeners() {  
                testNodes[i].transportService,  
        Task mainTask = startCancellableTestNodesAction(  
        final TaskId parentTaskId = parentTask.taskInfo(testNodes[0].getNodeId(), false).getTaskId();
            new ActionListener<NodesResponse>() {
            actionLatch.await();
            testNodes[randomIntBetween(1, testNodes.length - 1)].transportCancelTasksAction,  
        CountDownLatch responseLatch = new CountDownLatch(1);
            assertEquals(0, responseReference.get().failureCount());
import org.opensearch.tasks.Task;  
                if (response.getTasks().size() == 0) {
            }
        // And send the cancellation request to a random node
        );
        CancellableTestNodesAction(
            threads[i].join();  
        Task task = actions[0].execute(request, listener);
                Thread.currentThread().interrupt();
        ListTasksResponse listTasksResponse = ActionTestUtils.executeBlocking(
        setupTestNodes(Settings.EMPTY);  
