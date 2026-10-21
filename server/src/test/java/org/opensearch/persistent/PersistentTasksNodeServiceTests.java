import org.opensearch.cluster.routing.RoutingTable;
        Metadata.Builder metadata = Metadata.builder(state.metadata());
            this.task = task;
        coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(Collections.singletonList(action));
            persistentTasksService,
            state = newClusterState;
                        PersistentTasksCustomMetadata.TYPE,
            persistentTasksService,
            executor.get(0).task.markAsFailed(new RuntimeException());
        );
    public void testParamsStatusAndNodeTaskAreDelegated() throws Exception {
            coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
            executions.clear();
        );
    @Before
            // Simulate removal of the finished task
        @SuppressWarnings("unchecked")
            String failedTaskId = executor.get(0).task.getPersistentTaskId();
import static org.hamcrest.Matchers.empty;
import org.opensearch.common.settings.Settings;
        coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
        tasks.addTask(
        PersistentTasksService persistentTasksService = mock(PersistentTasksService.class);
        Metadata.Builder metadata = Metadata.builder(state.metadata());
        if (randomBoolean()) {
        private final PersistentTaskState state;
import org.opensearch.cluster.ClusterState;
    }
        return state.build();
            return executions.size();
        MockExecutor() {
            state.getMetadata().custom(PersistentTasksCustomMetadata.TYPE)
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            );
        when(client.settings()).thenReturn(Settings.EMPTY);
        private List<Execution> executions = new ArrayList<>();
 * not use this file except in compliance with the License.
import org.opensearch.tasks.Task;
            assertThat(executor.size(), equalTo(1));
            assertThat(executor.get(0).task.isCompleted(), is(false));
import static org.hamcrest.core.IsEqual.equalTo;
            assertThat(executor.executions.size(), equalTo(1));
        PersistentTasksNodeService coordinator = new PersistentTasksNodeService(
        PersistentTaskState taskState = new TestPersistentTasksPlugin.State("_test_phase");
        for (int i = 0; i < (nonLocalNodesCount + 1) * 10; i++) {
            ) {
        when(action.getTaskName()).thenReturn(TestPersistentTasksExecutor.NAME);
        state.routingTable(RoutingTable.builder().build());
            executor
            when(action.createTask(anyLong(), anyString(), anyString(), eq(parentId), any(), any())).thenReturn(
        AtomicReference<ActionListener<CancelTasksResponse>> capturedListener = new AtomicReference<>();
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();
            new TestParams("this_param"),
 *
    private ClusterState createInitialClusterState(int nonLocalNodesCount, Settings settings) {
        final Client mockClient = mock(Client.class);
                }
            .build();
        tasks.updateTaskState(taskId, taskState);
            // Make sure action was called this time
 *
        long localId = runningTask.getId();
            assertThat(executor.get(1).task.isCompleted(), is(false));
import static org.mockito.Mockito.when;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.node.DiscoveryNodes;
                        UUIDs.base64UUID(),
    @Override
            newClusterState = addTask(state, TestPersistentTasksExecutor.NAME, null, "some_other_node");
            state.getMetadata().custom(PersistentTasksCustomMetadata.TYPE)
            newClusterState = removeTask(state, persistentId);
            final PersistentTaskState state,
            return executions.get(i);
            "persistent",
    public void tearDown() throws Exception {
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
            logger.info("No local node action was added");
            executor
 */
                        new TestParams("this_param"),
                    UUIDs.base64UUID(),
        }
 * Unless required by applicable law or agreed to in writing,
            coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
            TaskId parentId = new TaskId("cluster", i);
        // need to account for 5 original tasks on each node and their relocations
        if (added) {
        nodes.localNodeId("this_node");
import org.opensearch.cluster.node.DiscoveryNode;
    public void testRegisterTaskFails() throws InterruptedException {
        super.setUp();
    public void testTaskCancellation() {
 * Modifications Copyright OpenSearch Contributors. See
    private ClusterState reallocateTask(ClusterState state, String taskId, String node) {
                    )
        MockExecutor executor = new MockExecutor();
 * compatible open source license.
                Metadata.builder(state.metadata())
            executor.get(0).task.markAsFailed(new IOException("test"));
import java.util.List;
        if (nonLocalNodesCount > 0) {
import static org.mockito.Mockito.mock;
        String persistentId = runningTask.getPersistentTaskId();
        // Allocate first task
        CountDownLatch latch = new CountDownLatch(1);
/*
/*
import org.opensearch.threadpool.ThreadPool;
                        TestPersistentTasksExecutor.NAME,
                fail("Shouldn't be called during Cluster State cancellation");
 * You may obtain a copy of the License at
import org.opensearch.cluster.ClusterName;
        ) {
            }
        public Execution get(int i) {
        PersistentTasksExecutor<TestParams> action = mock(PersistentTasksExecutor.class);
import static org.mockito.Mockito.anyLong;
        boolean added = false;
            new TestPersistentTasksPlugin.TestTask(1, "persistent", "test", "", new TaskId("cluster", 1), Collections.emptyMap())
        }
                        PersistentTasksCustomMetadata.TYPE,
import org.opensearch.Version;
 * software distributed under the License is distributed on an
            void sendCancelRequest(final long taskId, final String reason, final ActionListener<CancelTasksResponse> listener) {
import org.opensearch.tasks.TaskManager;
                Exception taskFailure,
        }
        assertThat(executor.executions.size(), equalTo(0));
import java.io.IOException;
import org.opensearch.common.util.concurrent.ThreadContext;
        MockExecutor executor = new MockExecutor();
                latch.countDown();
        );
        coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
        when(mockClient.settings()).thenReturn(Settings.EMPTY);
            )
        when(action.getExecutor()).thenReturn(ThreadPool.Names.SAME);
            new RuntimeException("Something went wrong")
            // ActionType for this node was added, let's make sure it was invoked
import java.util.ArrayList;
        };
        String taskId = UUIDs.base64UUID();
            persistentTasksService,
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
            executor.clear();
 */
            coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
                    tasks.addTask(
        );
/*
        assertTrue(builder.hasTask(taskId));
            @Override
    }
        // That should trigger cancellation request
        return ClusterState.builder(state)
            .build();
        PersistentTasksCustomMetadata.Builder builder = PersistentTasksCustomMetadata.builder(
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;
                );
            coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
        if (randomBoolean()) {
import org.opensearch.transport.client.Client;
        PersistentTasksService persistentTasksService = new PersistentTasksService(null, null, mockClient) {
        when(action.getTaskName()).thenReturn(TestPersistentTasksExecutor.NAME);
            UUIDs.base64UUID(),
        );
                    .putCustom(
        PersistentTasksService persistentTasksService = new PersistentTasksService(null, null, client) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.TimeUnit;
                tasks.addTask(
        AllocatedPersistentTask nodeTask = new TestPersistentTasksPlugin.TestTask(
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();
        }
        ClusterState state = createInitialClusterState(1, Settings.EMPTY);
    }
        MockExecutor executor = new MockExecutor();
                        new Assignment("this_node", "test assignment on this node")
import static org.hamcrest.Matchers.instanceOf;
            for (int i = 0; i < randomInt(5); i++) {
            state = newClusterState;
            new Assignment("this_node", "test assignment on this node")
                    .putCustom(
        Metadata.Builder metadata = Metadata.builder(state.metadata());
            .onResponse(new CancelTasksResponse(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
    private <Params extends PersistentTaskParams> ClusterState addTask(ClusterState state, String action, Params params, String node) {
            newClusterState = addTask(state, TestPersistentTasksExecutor.NAME, null, "some_other_node");
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet()),
        for (int i = 0; i < nonLocalNodesCount; i++) {
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            String finishedTaskId = executor.get(1).task.getPersistentTaskId();
                assertThat(taskFailure.getMessage(), equalTo("Something went wrong"));
        );
 * GitHub history for details.
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(Collections.singletonList(action));
        when(action.createTask(anyLong(), anyString(), anyString(), any(), any(), any())).thenThrow(
        );
        );
                capturedTaskId.set(taskId);
        ClusterState state = createInitialClusterState(nonLocalNodesCount, Settings.EMPTY);
                final ActionListener<PersistentTask<?>> listener
        ClusterState newClusterState = ClusterState.builder(state).metadata(metadata).build();
        Client client = mock(Client.class);
            state = newClusterState;
        );
import org.junit.Before;
                capturedListener.set(listener);
    private ClusterState removeTask(ClusterState state, String taskId) {
            // Finish both tasks
    }
        Execution(PersistentTaskParams params, AllocatedPersistentTask task, PersistentTaskState state) {
                        builder.addTask(UUIDs.base64UUID(), action, params, new Assignment(node, "test assignment")).build()
        @Override
    public void testStartTask() {
                final Exception taskFailure,
            )
    @After
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
                    new Assignment("other_node_" + randomInt(nonLocalNodesCount), "test assignment on other node")
            nodes.add(new DiscoveryNode("other_node_" + i, buildNewFakeTransportAddress(), Version.CURRENT));
                    new TestParams("other_" + i),
            executor
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(Collections.singletonList(action));
            }
            newClusterState = addTask(state, TestPersistentTasksExecutor.NAME, new TestParams("this_param"), "this_node");
import org.junit.After;
        return ClusterState.builder(state)
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
                String taskId,
            ) {
        }
        };
            // Simulate reallocation of the failed task on the same node
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;
            }
            Collections.emptyMap()
                        builder.reassignTask(taskId, new Assignment(node, "test assignment")).build()
            super(null);
            assertThat(executor.size(), equalTo(0));
        @SuppressWarnings("unchecked")
        if (added == false) {
        @SuppressWarnings("unchecked")
            TestPersistentTasksExecutor.NAME,
        @SuppressWarnings("unchecked")
            // Start another task on this node
            // Make sure action was only allocated on this node once
import org.opensearch.common.UUIDs;
                    TestPersistentTasksExecutor.NAME,
        private final PersistentTaskParams params;
        when(action.getExecutor()).thenReturn(ThreadPool.Names.SAME);
 * the Apache License, Version 2.0 (the "License"); you may
                    added = true;
        state.metadata(Metadata.builder().generateClusterUuidIfNeeded());
            executor.get(1).task.markAsCompleted();
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet()),
        PersistentTasksService persistentTasksService = mock(PersistentTasksService.class);
            newClusterState = removeTask(state, finishedTaskId);
    @Override
        assertTrue(builder.hasTask(taskId));
        assertThat(executor.get(0).state, sameInstance(taskState));
import static org.hamcrest.Matchers.is;
        state = newClusterState;
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet()),
            registry,
            assertThat(executor.get(1).task.isCompleted(), is(true));
        assertThat(capturedTaskId.get(), equalTo(localId));
        TaskManager taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
import static org.hamcrest.Matchers.sameInstance;
        assertThat(taskManager.getTasks().values(), empty());
            final AllocatedPersistentTask task,
        PersistentTasksExecutor<TestParams> action = mock(PersistentTasksExecutor.class);
        public void clear() {
        coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
            final Params params,
        PersistentTasksNodeService coordinator = new PersistentTasksNodeService(
            .metadata(Metadata.builder(state.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, builder.removeTask(taskId).build()))
        when(action.getTaskName()).thenReturn(TestPersistentTasksExecutor.NAME);
    }
        }
        when(action.getTaskName()).thenReturn("test");
            this.state = state;
        ClusterState state = createInitialClusterState(0, Settings.EMPTY);
        state = newClusterState;
 * SPDX-License-Identifier: Apache-2.0
            assertThat(executor.executions.size(), equalTo(1));
import org.opensearch.core.action.ActionListener;
        nodes.add(DiscoveryNode.createLocal(settings, buildNewFakeTransportAddress(), "this_node"));
            .metadata(
            state = newClusterState;
public class PersistentTasksNodeServiceTests extends OpenSearchTestCase {
            executor.get(0).task.markAsCompleted();
        // Check the task is know to the task manager
        super.tearDown();
        ClusterState newClusterState = ClusterState.builder(state).metadata(metadata).build();
        PersistentTasksNodeService coordinator = new PersistentTasksNodeService(persistentTasksService, registry, taskManager, executor);
                Metadata.builder(state.metadata())
        TaskId parentId = new TaskId("cluster", 1);
        assertThat(taskManager.getTasks().values().iterator().next().getStatus().toString(), equalTo("{\"state\":\"PENDING_CANCEL\"}"));
 * KIND, either express or implied.  See the License for the
            assertThat(executor.size(), equalTo(2));
        metadata.putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
    private class MockExecutor extends NodePersistentTasksExecutor {
        int nonLocalNodesCount = randomInt(10);
            state.getMetadata().custom(PersistentTasksCustomMetadata.TYPE)
import java.util.Collections;
        AtomicLong capturedTaskId = new AtomicLong();
        Task.Status status = runningTask.getStatus();
            this.params = params;
    }
            final PersistentTasksExecutor<Params> executor
            registry,
        PersistentTasksExecutor<TestParams> action = mock(PersistentTasksExecutor.class);
        tasks.addTask(taskId, TestPersistentTasksExecutor.NAME, taskParams, new Assignment("this_node", "test assignment on other node"));
        return ClusterState.builder(state)
import static org.mockito.Mockito.anyString;
            "",
import static org.mockito.Mockito.eq;
        ClusterState state = createInitialClusterState(nonLocalNodesCount, Settings.EMPTY);
    }
 */
                assertThat(taskFailure, instanceOf(RuntimeException.class));
                    );
 * Licensed to Elasticsearch under one or more contributor
    }
 * under the License.
        metadata.putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        assertThat(status.toString(), equalTo("{\"state\":\"STARTED\"}"));
            0,
import org.opensearch.cluster.metadata.Metadata;
        PersistentTasksCustomMetadata.Builder builder = PersistentTasksCustomMetadata.builder(
        // Failed to start the task, make sure it wasn't invoked further
            coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
            }
import java.util.concurrent.atomic.AtomicReference;
            assertThat(executor.get(0).task.isCompleted(), is(true));
        } else {
            public void sendCompletionRequest(
        }
 * this work for additional information regarding copyright
import org.opensearch.cluster.ClusterChangedEvent;
        }
    }
        }
        public int size() {
            @Override
 * specific language governing permissions and limitations
        ClusterState newClusterState = state;
            state = newClusterState;
        newClusterState = addTask(state, "test", null, "this_node");
        assertThat(taskManager.getTasks().size(), equalTo(1));
        coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
        when(action.createTask(anyLong(), anyString(), anyString(), eq(parentId), any(), any())).thenReturn(nodeTask);
            // Make sure action wasn't called again
        terminate(threadPool);
        // finish or fail task
        // Notify successful cancellation
        // Make sure it returns correct status
 * ownership. Elasticsearch licenses this file to you under
                long taskAllocationId,
import java.util.concurrent.CountDownLatch;
            "test",
        // Check the task is now removed from task manager
            parentId,
        state.nodes(nodes);
        threadPool = new TestThreadPool(getClass().getName());
        final ThreadPool threadPool = mock(ThreadPool.class);
        }
 * license agreements. See the NOTICE file distributed with
        when(action.getExecutor()).thenReturn(ThreadPool.Names.SAME);
            registry,
        assertThat(executor.size(), equalTo(1));
        } else {
        PersistentTasksNodeService coordinator = new PersistentTasksNodeService(
        ClusterState newClusterState = ClusterState.builder(state).metadata(metadata).build();
        PersistentTasksCustomMetadata.Builder builder = PersistentTasksCustomMetadata.builder(
                    )
 * this file be licensed under the Apache-2.0 license or a
        ClusterState.Builder state = ClusterState.builder(new ClusterName("PersistentActionExecutorTests"));
                ActionListener<PersistentTask<?>> listener
        public <Params extends PersistentTaskParams> void executeTask(
                final long taskAllocationId,
        AllocatedPersistentTask runningTask = (AllocatedPersistentTask) taskManager.getTasks().values().iterator().next();
 *
    }
import org.opensearch.threadpool.TestThreadPool;
        }
package org.opensearch.persistent;
            .build();
                new TestPersistentTasksPlugin.TestTask(i, "persistent", "test", "", parentId, Collections.emptyMap())
        when(threadPool.generic()).thenReturn(OpenSearchExecutors.newDirectExecutorService());
        MockExecutor executor = new MockExecutor();
import static org.mockito.Mockito.any;
        capturedListener.get()
            newClusterState = reallocateTask(state, failedTaskId, "this_node");
            // Make sure action wasn't called again
        when(action.createTask(anyLong(), anyString(), anyString(), any(), any(), any())).thenReturn(
            @Override
    }
        metadata.putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
}
        TestParams taskParams = new TestParams("other_0");
        );
                if (added == false && randomBoolean()) {
            // Add task on some other node
        }
            newClusterState = reallocateTask(state, persistentId, "some_other_node");
        when(action.getExecutor()).thenReturn(ThreadPool.Names.SAME);
    public void setUp() throws Exception {
        assertThat(taskManager.getTasks().size(), equalTo(1));
    private ThreadPool threadPool;
                final String taskId,
 * The OpenSearch Contributors require contributions made to
        // Relocate the task to some other node or remove it completely
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;
            public void sendCompletionRequest(
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(Collections.singletonList(action));
        PersistentTasksExecutor<TestParams> action = mock(PersistentTasksExecutor.class);
        private final AllocatedPersistentTask task;
        int nonLocalNodesCount = randomInt(10);
        // Make sure it returns correct status
                listener.onResponse(mock(PersistentTask.class));
        when(mockClient.threadPool()).thenReturn(threadPool);
            // Add task on some other node
        assertThat(executor.get(0).task, sameInstance(nodeTask));
import java.util.concurrent.atomic.AtomicLong;
        assertThat(executor.get(0).params, sameInstance(taskParams));
    }
            .metadata(
import org.opensearch.core.tasks.TaskId;
    private class Execution {
        }
            executions.add(new Execution(params, task, state));
