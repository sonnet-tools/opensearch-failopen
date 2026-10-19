 */
        Metadata.Builder metadata = Metadata.builder(state.metadata());  
        public Execution get(int i) {
            assertThat(executor.get(1).task.isCompleted(), is(false));  
        state = newClusterState;  
        state.nodes(nodes);  
        newClusterState = addTask(state, "test", null, "this_node");  
            ) {
                    new Assignment("other_node_" + randomInt(nonLocalNodesCount), "test assignment on other node")
        // Relocate the task to some other node or remove it completely
            new Assignment("this_node", "test assignment on this node")  
            executor.get(0).task.markAsCompleted();  
        coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
    }  
        assertThat(executor.executions.size(), equalTo(0));
import org.opensearch.tasks.TaskManager;  
        }  
        PersistentTaskState taskState = new TestPersistentTasksPlugin.State("_test_phase");
            for (int i = 0; i < randomInt(5); i++) {  
                    tasks.addTask(  
        );
        metadata.putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
 * You may obtain a copy of the License at  
        capturedListener.get()
        PersistentTasksNodeService coordinator = new PersistentTasksNodeService(  
        int nonLocalNodesCount = randomInt(10);
        assertThat(executor.get(0).task, sameInstance(nodeTask));
        }  
        assertThat(executor.size(), equalTo(1));
            "persistent",  
                        UUIDs.base64UUID(),
            // Make sure action was only allocated on this node once
        PersistentTasksNodeService coordinator = new PersistentTasksNodeService(persistentTasksService, registry, taskManager, executor);
        String persistentId = runningTask.getPersistentTaskId();  
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;
        Metadata.Builder metadata = Metadata.builder(state.metadata());
            .build();
        boolean added = false;
 * ownership. Elasticsearch licenses this file to you under  
        coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
public class PersistentTasksNodeServiceTests extends OpenSearchTestCase {
                    new TestParams("other_" + i),
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();
        // Make sure it returns correct status  
import java.util.concurrent.atomic.AtomicLong;
            .metadata(Metadata.builder(state.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, builder.removeTask(taskId).build()))
                Metadata.builder(state.metadata())  
            executor
            executor
            .build();  
        assertTrue(builder.hasTask(taskId));
            persistentTasksService,
            coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));  
            state = newClusterState;  
import org.opensearch.threadpool.ThreadPool;  
            executions.add(new Execution(params, task, state));
            final PersistentTasksExecutor<Params> executor  
        if (added == false) {
        ClusterState state = createInitialClusterState(nonLocalNodesCount, Settings.EMPTY);
    }
        };
            // Add task on some other node
        assertTrue(builder.hasTask(taskId));
            newClusterState = addTask(state, TestPersistentTasksExecutor.NAME, null, "some_other_node");  
        MockExecutor executor = new MockExecutor();
            // Add task on some other node
import static org.hamcrest.Matchers.instanceOf;  
import org.opensearch.tasks.Task;
        nodes.localNodeId("this_node");
    @Override  
        PersistentTasksExecutor<TestParams> action = mock(PersistentTasksExecutor.class);
/*  
            )
        assertThat(taskManager.getTasks().values().iterator().next().getStatus().toString(), equalTo("{\"state\":\"PENDING_CANCEL\"}"));
        long localId = runningTask.getId();
        return ClusterState.builder(state)
    @Override
        // Allocate first task
        when(action.getExecutor()).thenReturn(ThreadPool.Names.SAME);
            ) {
    public void testRegisterTaskFails() throws InterruptedException {  
        nodes.add(DiscoveryNode.createLocal(settings, buildNewFakeTransportAddress(), "this_node"));
                fail("Shouldn't be called during Cluster State cancellation");
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;  
        when(action.getTaskName()).thenReturn("test");
        ClusterState state = createInitialClusterState(0, Settings.EMPTY);
            newClusterState = addTask(state, TestPersistentTasksExecutor.NAME, null, "some_other_node");
import static org.mockito.Mockito.anyLong;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.concurrent.atomic.AtomicReference;  
import java.util.concurrent.CountDownLatch;  
            coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
            executor.clear();
import java.util.Collections;
        @Override
            state = newClusterState;
        );
            registry,  
 *
        when(threadPool.generic()).thenReturn(OpenSearchExecutors.newDirectExecutorService());  
import org.junit.Before;  
 * GitHub history for details.
            persistentTasksService,
        when(action.getExecutor()).thenReturn(ThreadPool.Names.SAME);  
import static org.hamcrest.core.IsEqual.equalTo;  
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
import org.opensearch.common.settings.Settings;
            )  
import static org.mockito.Mockito.mock;
        when(mockClient.settings()).thenReturn(Settings.EMPTY);
        for (int i = 0; i < nonLocalNodesCount; i++) {
        for (int i = 0; i < (nonLocalNodesCount + 1) * 10; i++) {  
        return ClusterState.builder(state)
        when(mockClient.threadPool()).thenReturn(threadPool);
 * KIND, either express or implied.  See the License for the
                final String taskId,  
                    added = true;
 */  
    }
            );
                listener.onResponse(mock(PersistentTask.class));
            }
            new TestPersistentTasksPlugin.TestTask(1, "persistent", "test", "", new TaskId("cluster", 1), Collections.emptyMap())
                final long taskAllocationId,
                        new Assignment("this_node", "test assignment on this node")
            // Start another task on this node
        }
        tasks.addTask(taskId, TestPersistentTasksExecutor.NAME, taskParams, new Assignment("this_node", "test assignment on other node"));
            void sendCancelRequest(final long taskId, final String reason, final ActionListener<CancelTasksResponse> listener) {
        MockExecutor() {  
        when(action.createTask(anyLong(), anyString(), anyString(), any(), any(), any())).thenReturn(  
        PersistentTasksCustomMetadata.Builder builder = PersistentTasksCustomMetadata.builder(
            0,
import static org.mockito.Mockito.anyString;  
        private List<Execution> executions = new ArrayList<>();
            assertThat(executor.executions.size(), equalTo(1));
    private ClusterState removeTask(ClusterState state, String taskId) {
        tasks.addTask(
    public void testStartTask() {
        Metadata.Builder metadata = Metadata.builder(state.metadata());
            Collections.emptyMap()
        @SuppressWarnings("unchecked")
            public void sendCompletionRequest(  
            state = newClusterState;  
            newClusterState = addTask(state, TestPersistentTasksExecutor.NAME, new TestParams("this_param"), "this_node");
        when(action.createTask(anyLong(), anyString(), anyString(), any(), any(), any())).thenThrow(
 * The OpenSearch Contributors require contributions made to  
        super.tearDown();
            assertThat(executor.get(1).task.isCompleted(), is(true));
            executor.get(0).task.markAsFailed(new RuntimeException());  
                ActionListener<PersistentTask<?>> listener
import org.opensearch.common.UUIDs;
            registry,
        final ThreadPool threadPool = mock(ThreadPool.class);
            final Params params,  
            new TestParams("this_param"),
    @Before
            coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
                        PersistentTasksCustomMetadata.TYPE,
    private ThreadPool threadPool;
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;  
            TestPersistentTasksExecutor.NAME,
            // Simulate reallocation of the failed task on the same node  
            assertThat(executor.size(), equalTo(0));
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();  
import org.junit.After;
        @SuppressWarnings("unchecked")
        );
            registry,
            parentId,  
    public void setUp() throws Exception {
        }
        String taskId = UUIDs.base64UUID();  
        AllocatedPersistentTask nodeTask = new TestPersistentTasksPlugin.TestTask(
                }  
 * Licensed to Elasticsearch under one or more contributor  
        // Check the task is know to the task manager  
        if (randomBoolean()) {
    }
        }  
        state.metadata(Metadata.builder().generateClusterUuidIfNeeded());
            "test",
            // Finish both tasks
import org.opensearch.core.action.ActionListener;
        }  
                    );
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
    }
        return state.build();
        MockExecutor executor = new MockExecutor();
        );  
        // Check the task is now removed from task manager
        PersistentTasksCustomMetadata.Builder builder = PersistentTasksCustomMetadata.builder(
            state.getMetadata().custom(PersistentTasksCustomMetadata.TYPE)
                        builder.addTask(UUIDs.base64UUID(), action, params, new Assignment(node, "test assignment")).build()  
import static org.mockito.Mockito.any;
        assertThat(taskManager.getTasks().size(), equalTo(1));
        return ClusterState.builder(state)  
        metadata.putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());  
            .onResponse(new CancelTasksResponse(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
                long taskAllocationId,
            }  
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
import org.opensearch.transport.client.Client;
        );  
    public void testParamsStatusAndNodeTaskAreDelegated() throws Exception {  
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();  
                Metadata.builder(state.metadata())
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(Collections.singletonList(action));  
    public void testTaskCancellation() {
            }
        public int size() {  
            this.state = state;
            assertThat(executor.size(), equalTo(2));
 * this work for additional information regarding copyright
        coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));  
    private class Execution {
        private final PersistentTaskParams params;
        public void clear() {
            coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
            executor
        ClusterState newClusterState = ClusterState.builder(state).metadata(metadata).build();
                capturedListener.set(listener);
        PersistentTasksExecutor<TestParams> action = mock(PersistentTasksExecutor.class);  
        threadPool = new TestThreadPool(getClass().getName());
        Client client = mock(Client.class);
    }  
 * license agreements. See the NOTICE file distributed with
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet()),
        assertThat(capturedTaskId.get(), equalTo(localId));
 * specific language governing permissions and limitations
/*
            @Override
        // finish or fail task
        };
        @SuppressWarnings("unchecked")
        when(action.getTaskName()).thenReturn(TestPersistentTasksExecutor.NAME);  
    }
            state.getMetadata().custom(PersistentTasksCustomMetadata.TYPE)
 * software distributed under the License is distributed on an
        PersistentTasksCustomMetadata.Builder builder = PersistentTasksCustomMetadata.builder(
        Execution(PersistentTaskParams params, AllocatedPersistentTask task, PersistentTaskState state) {
                if (added == false && randomBoolean()) {
            this.task = task;
import org.opensearch.Version;
            assertThat(executor.get(0).task.isCompleted(), is(true));  
 * the Apache License, Version 2.0 (the "License"); you may
            final PersistentTaskState state,
            nodes.add(new DiscoveryNode("other_node_" + i, buildNewFakeTransportAddress(), Version.CURRENT));  
 */  
                        PersistentTasksCustomMetadata.TYPE,  
        ClusterState newClusterState = state;  
            // Simulate removal of the finished task
                assertThat(taskFailure.getMessage(), equalTo("Something went wrong"));
        PersistentTasksService persistentTasksService = new PersistentTasksService(null, null, client) {  
                assertThat(taskFailure, instanceOf(RuntimeException.class));  
        }
 * Unless required by applicable law or agreed to in writing,
        );
        @SuppressWarnings("unchecked")  
        when(action.getTaskName()).thenReturn(TestPersistentTasksExecutor.NAME);
            // Make sure action was called this time
                final ActionListener<PersistentTask<?>> listener  
        MockExecutor executor = new MockExecutor();  
        public <Params extends PersistentTaskParams> void executeTask(
package org.opensearch.persistent;
            return executions.size();
        PersistentTasksExecutor<TestParams> action = mock(PersistentTasksExecutor.class);  
import org.opensearch.cluster.ClusterChangedEvent;  
            newClusterState = reallocateTask(state, failedTaskId, "this_node");
            String finishedTaskId = executor.get(1).task.getPersistentTaskId();
import org.opensearch.cluster.node.DiscoveryNode;
        PersistentTasksExecutor<TestParams> action = mock(PersistentTasksExecutor.class);
    private ClusterState reallocateTask(ClusterState state, String taskId, String node) {  
        int nonLocalNodesCount = randomInt(10);
            persistentTasksService,
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(Collections.singletonList(action));  
            this.params = params;  
        ClusterState state = createInitialClusterState(1, Settings.EMPTY);
            .metadata(  
        AtomicLong capturedTaskId = new AtomicLong();
        }
    @After
        }  
                tasks.addTask(
                capturedTaskId.set(taskId);  
            @Override
 *
        if (added) {
    private class MockExecutor extends NodePersistentTasksExecutor {  
        terminate(threadPool);
        ClusterState state = createInitialClusterState(nonLocalNodesCount, Settings.EMPTY);
 * under the License.  
            newClusterState = removeTask(state, persistentId);
        PersistentTasksService persistentTasksService = new PersistentTasksService(null, null, mockClient) {
        tasks.updateTaskState(taskId, taskState);  
                        builder.reassignTask(taskId, new Assignment(node, "test assignment")).build()
        );
                final Exception taskFailure,
        assertThat(executor.get(0).state, sameInstance(taskState));  
                    .putCustom(
import org.opensearch.common.util.concurrent.ThreadContext;
    }
 * compatible open source license.
        final Client mockClient = mock(Client.class);  
        super.setUp();  
import static org.hamcrest.Matchers.is;
    }
            executor.get(1).task.markAsCompleted();
        CountDownLatch latch = new CountDownLatch(1);
            "",
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;
import java.util.List;
                latch.countDown();  
                    TestPersistentTasksExecutor.NAME,  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
        // Failed to start the task, make sure it wasn't invoked further  
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(Collections.singletonList(action));  
        TaskId parentId = new TaskId("cluster", 1);  
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet()),  
import org.opensearch.threadpool.TestThreadPool;
        ClusterState newClusterState = ClusterState.builder(state).metadata(metadata).build();
        assertThat(taskManager.getTasks().values(), empty());  
            newClusterState = reallocateTask(state, persistentId, "some_other_node");  
        ClusterState newClusterState = ClusterState.builder(state).metadata(metadata).build();  
        assertThat(executor.get(0).params, sameInstance(taskParams));
        assertThat(status.toString(), equalTo("{\"state\":\"STARTED\"}"));
            // ActionType for this node was added, let's make sure it was invoked
    private <Params extends PersistentTaskParams> ClusterState addTask(ClusterState state, String action, Params params, String node) {  
        PersistentTasksNodeService coordinator = new PersistentTasksNodeService(
import static org.mockito.Mockito.eq;
import static org.hamcrest.Matchers.sameInstance;
}  
 * this file be licensed under the Apache-2.0 license or a
        PersistentTasksService persistentTasksService = mock(PersistentTasksService.class);
            final AllocatedPersistentTask task,
        // need to account for 5 original tasks on each node and their relocations
                        new TestParams("this_param"),  
        );
        when(action.getExecutor()).thenReturn(ThreadPool.Names.SAME);
    }
            super(null);
    private ClusterState createInitialClusterState(int nonLocalNodesCount, Settings settings) {
            assertThat(executor.get(0).task.isCompleted(), is(false));  
                    )
        when(action.getExecutor()).thenReturn(ThreadPool.Names.SAME);
                Exception taskFailure,  
 * Modifications Copyright OpenSearch Contributors. See
            executions.clear();
        when(action.createTask(anyLong(), anyString(), anyString(), eq(parentId), any(), any())).thenReturn(nodeTask);  
            // Make sure action wasn't called again  
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(Collections.singletonList(action));
            .build();
            state = newClusterState;
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet()),  
        when(client.settings()).thenReturn(Settings.EMPTY);
import static org.mockito.Mockito.when;  
            }
        // Make sure it returns correct status
            coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
            String failedTaskId = executor.get(0).task.getPersistentTaskId();  
import org.opensearch.cluster.metadata.Metadata;  
        ClusterState.Builder state = ClusterState.builder(new ClusterName("PersistentActionExecutorTests"));  
        );
        Task.Status status = runningTask.getStatus();  
            TaskId parentId = new TaskId("cluster", i);
        PersistentTasksNodeService coordinator = new PersistentTasksNodeService(  
        AtomicReference<ActionListener<CancelTasksResponse>> capturedListener = new AtomicReference<>();  
/*  
                        TestPersistentTasksExecutor.NAME,
        AllocatedPersistentTask runningTask = (AllocatedPersistentTask) taskManager.getTasks().values().iterator().next();
            new RuntimeException("Something went wrong")  
                    .putCustom(
 *  
import org.opensearch.test.OpenSearchTestCase;
    }
        PersistentTasksService persistentTasksService = mock(PersistentTasksService.class);
        if (nonLocalNodesCount > 0) {
            assertThat(executor.executions.size(), equalTo(1));  
import org.opensearch.cluster.routing.RoutingTable;  
            assertThat(executor.size(), equalTo(1));
import org.opensearch.cluster.ClusterName;
        } else {
        // Notify successful cancellation  
 * SPDX-License-Identifier: Apache-2.0
        }  
        }  
        private final AllocatedPersistentTask task;
            // Make sure action wasn't called again
        when(action.getTaskName()).thenReturn(TestPersistentTasksExecutor.NAME);
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
            .metadata(
                    UUIDs.base64UUID(),
        TestParams taskParams = new TestParams("other_0");
    public void tearDown() throws Exception {  
                String taskId,
    }
        assertThat(taskManager.getTasks().size(), equalTo(1));
 * not use this file except in compliance with the License.
        // That should trigger cancellation request
        MockExecutor executor = new MockExecutor();  
            state.getMetadata().custom(PersistentTasksCustomMetadata.TYPE)  
        }
        }
        if (randomBoolean()) {
        private final PersistentTaskState state;  
            public void sendCompletionRequest(
        TaskManager taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
            return executions.get(i);  
                    )
import org.opensearch.core.tasks.TaskId;  
        } else {
        state.routingTable(RoutingTable.builder().build());
            logger.info("No local node action was added");
                new TestPersistentTasksPlugin.TestTask(i, "persistent", "test", "", parentId, Collections.emptyMap())  
        );  
                );  
            state = newClusterState;  
        metadata.putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        state = newClusterState;
            @Override
        coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
import java.io.IOException;
import static org.hamcrest.Matchers.empty;
            UUIDs.base64UUID(),  
import java.util.concurrent.TimeUnit;
import org.opensearch.cluster.ClusterState;
        coordinator.clusterChanged(new ClusterChangedEvent("test", newClusterState, state));
        ) {
            newClusterState = removeTask(state, finishedTaskId);
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();  
            when(action.createTask(anyLong(), anyString(), anyString(), eq(parentId), any(), any())).thenReturn(
            executor.get(0).task.markAsFailed(new IOException("test"));
