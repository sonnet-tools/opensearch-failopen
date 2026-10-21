        assertTrue(client().admin().cluster().prepareDeleteTask(parentTaskId).get().isAcknowledged());
        assertNull(getResponse.getTask().getResponse());
            .setWaitForCompletion(true)
        request.setShouldBlock(false);
    public void testTransportReplicationAllShardsTasks() {
        doReturn(mockJsonString).when(resultsService).taskResultIndexMapping();
        // when & then
     * @param storeResult should the task store its results
                assertEquals(TestTaskPlugin.TestTaskAction.NAME, response.getTask().getTask().getAction());
        assertEquals(0L, task.getStartTime());
                sTask = findEvents(
                // There should be only one parent task
        });
        GetTaskResponse response = expectFinishedTask(new TaskId("fake:1"));
            future.join();
            assertEquals(0L, deleteSearchResponse.getHits().getTotalHits().value());
            }
            .setActions(TestTaskPlugin.TestTaskAction.NAME)
    private void assertDeleteTaskConflict(TaskId taskId, String expectedMessage) {
        assertEquals(1L, task.getRunningTimeNanos());
            id -> client().admin().cluster().prepareGetTask(id).setWaitForCompletion(true).execute(),
 */
        assertThat(response.getTasks().size(), greaterThanOrEqualTo(1));
                // A [s][r] level task should have a corresponding [s] level task on the a different node (where primary is located)
        assertEquals("my_value", taskInfo.getHeaders().get("Custom-Task-Header"));
                String description = taskInfo.getDescription();
                assertEquals(0, response.getTask().getResponseAsMap().get("failure_count"));
        waitForCompletionTestCase(
        Map<?, ?> error = (Map<?, ?>) taskResult.getErrorAsMap();
            TaskId taskId = waitForTestTaskStartOnAllNodes();
                // in turn the parent of the task 1 should be the main task
     * @param wait wait for the running task and return all the failures you accumulated waiting for it
import org.opensearch.transport.TransportService;
            .setActions(TestTaskPlugin.TestTaskAction.NAME + "[n]")
import java.util.HashMap;
                    @Override
 * under the License.
}
        // the search operation should produce one main task
        SearchResponse searchResponse = client().prepareSearch(TaskResultsService.TASK_INDEX)
        try {
            assertNotNull(taskInfo.getCancellationStartTime());
    public void testTransportBulkTasks() {
    protected final TaskInfo taskInfo = new TaskInfo(
        }
                            }
                .setActions(TestTaskPlugin.TestTaskAction.NAME + "[n]")
        assertEquals("requests[1], indices[test]", topTask.get(0).getDescription());
import org.opensearch.OpenSearchTimeoutException;
                client().admin().cluster().prepareListTasks().setActions(TestTaskPlugin.TestTaskAction.NAME + "[n]").get().getTasks().size()
public class TasksIT extends AbstractTasksIT {
        internalCluster().getInstance(TaskResultsService.class)
        assertEquals(failedTaskInfo.getDescription(), taskResult.getTask().getDescription());
        }
        // the validate operation should produce one main task
    }
import org.opensearch.action.search.SearchResponse;
        TaskResultsService resultsService = spy(internalCluster().getInstance(TaskResultsService.class));
        assertEquals(failedTaskInfo.getStartTime(), taskResult.getTask().getStartTime());
        assertThat(taskInfo.getHeaders().keySet(), hasSize(3));
        NumShards numberOfShards = getNumShards("test");
        // tasks
                    break;
import java.io.IOException;
                });
        ActionFuture<TestTaskPlugin.NodesResponse> future = client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request);
        assertEquals(1, task.getResourceStats().getResourceUsageInfo().size());
        // It should finish quickly and without complaint
            .prepareListTasks()
                IndexResponse indexResponse = client().prepareIndex("test").setSource("test", "test").get();
                    public void taskExecutionStarted(Task task, Boolean closeableInvoked) {}
        storeTaskResult(childTaskId, parentTaskId);
    private void storeTaskResult(TaskId taskId, TaskId parentTaskId) throws IOException {
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;
        IllegalArgumentException ex = expectThrows(
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
        // Spin up a request to wait for all tasks in the cluster to make sure it doesn't cause an infinite loop
                .setActions(TestTaskPlugin.TestTaskAction.NAME)
        List<TaskInfo> spEvents = findEvents(RefreshAction.NAME + "[s][*]", Tuple::v1);
        ActionFuture<T> waitResponseFuture;
                    @Override
import static org.mockito.Mockito.doReturn;
            .getTasks();
        if (tasks.get(0).getParentTaskId().isSet()) {
        assertEquals("illegal_state_exception", error.get("type"));
        TaskId parentTaskId = new TaskId("fake", 200);
        );
        request.setShouldFail(true);
            Iterable<? extends Throwable> failures = wait.apply(taskId);
    }
    public void testTasksUnblocking() throws Exception {
        resultsService.storeResult(new TaskResult(taskInfo, new RuntimeException("test")), new ActionListener<Void>() {
import org.opensearch.action.search.SearchTransportService;
            () -> client().admin().cluster().prepareDeleteTask(taskId).get()
        TaskId grandchildTaskId = new TaskId("fake", 102);
            .setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON)
    }
        for (TaskInfo taskInfo : taskInfoList) {
        expectNotFound(() -> client().admin().cluster().prepareDeleteTask(taskId).get());
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;
                // A [s][p] level task should have a corresponding [s] level task on the same node
            IllegalArgumentException.class,
        );
                assertArrayEquals(ReplicationResponse.EMPTY, indexResponse.getShardInfo().getFailures());
    }
            0,
    }
        resetTaskManagerListeners(ClusterHealthAction.NAME);
            if (mainTask.getTaskId().getNodeId().equals(taskInfo.getTaskId().getNodeId())) {
        // First run the health on the cluster-manager node - should produce only one task on the cluster-manager node
     * particular status results from indexing. For that, look at {@link TransportReplicationActionTests}. We intentionally don't use the
        request.setShouldStoreResult(storeResult);
            .get();
            () -> client().filterWithHeader(headers).admin().cluster().prepareListTasks().get()
            1L,
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
                .cluster()
    public void testClusterManagerNodeOperationTasks() {
            .cluster()
                case SearchTransportService.QUERY_ACTION_NAME:
                .setWaitForCompletion(true)
    public void testTaskStoringFailureResult() throws Exception {
        logger.debug("number of shards, total: [{}], primaries: [{}] ", numberOfShards.totalNumShards, numberOfShards.numPrimaries);
            ListTasksResponse response = client().admin()
        assertEquals(taskInfo.getParentTaskId(), taskResult.getTask().getParentTaskId());
        // and then one operation per each node where shards are located
        registerTaskManagerListeners(SearchAction.NAME);  // main task
    }
            List<TaskInfo> sTask;
                .setTimeout(timeValueMillis(100))
import org.opensearch.action.admin.indices.upgrade.post.UpgradeAction;
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(40, task.getResourceStats().getThreadUsage().getActiveThreads());
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksAction;
        assertEquals(numberOfShards.numPrimaries, numberOfEvents(ValidateQueryAction.NAME + "[s]", Tuple::v1));
            }
            // It will timeout because we haven't unblocked the tasks
            public void onResponse(Void response) {
                    RefreshAction.NAME + "[s]",
        assertEquals("Simulating operation failure", error.get("reason"));
            }
                    }
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        // the refresh operation should produce one main task
        // This is complicated because if the shard task runs on the same node it has main task as a parent
 */
                    @Override
        TaskId failedTaskId = failedTaskInfo.getTaskId();
            }
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import java.nio.charset.StandardCharsets;
        }
    /**
            true,
        List<TaskInfo> topTask = findEvents(BulkAction.NAME, Tuple::v1);
            List<TaskInfo> tasks = client().admin()
        client().prepareBulk()
    }
                            logger.debug("Blocking [{}] starting", task);
        client().prepareIndex("test")
        // the bulk operation should produce one main task
            .execute();
        headers.put("Custom-Task-Header", randomAlphaOfLengthBetween(maxSize, maxSize + 100));
 *
            assertEquals(internalCluster().size(), tasks.size());
    }
        Collections.emptyMap(),
import java.util.List;
                // in turn the parent of the task 0 should be the main task
        assertEquals(1L, searchResponse.getHits().getTotalHits().value());
        registerTaskManagerListeners(UpgradeAction.NAME);  // main task
            resultsService.storeResult(new TaskResult(taskInfo, new RuntimeException("test")), new ActionListener<Void>() {
        // Select the effective shard task
        assertEquals(numberOfShards.totalNumShards, numberOfEvents(RefreshAction.NAME + "[s][*]", Tuple::v1));
        throws Exception {
     * task recording mechanism used in other places in this test so we can make sure that the status fetching works properly over the wire.
            SearchResponse deleteSearchResponse = client().prepareSearch(TaskResultsService.TASK_INDEX)
            );
            "test_action",
    }
 * KIND, either express or implied.  See the License for the
        waitForTimeoutTestCase(id -> {
        createIndex("test");
                    public void onTaskUnregistered(Task task) {}
                            } catch (InterruptedException e) {
                                                                        // level
            @Override
 * specific language governing permissions and limitations
import org.opensearch.action.admin.cluster.health.ClusterHealthAction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            return response.getNodeFailures();
                assertTrue(response.getTask().isCompleted());
            randomBoolean(),
import org.opensearch.tasks.Task;
        });
import java.util.function.Function;
        assertParentTask(findEvents(UpgradeAction.NAME + "[n]", Tuple::v1), findEvents(UpgradeAction.NAME, Tuple::v1).get(0));
            assertParentTask(Collections.singletonList(tasks.get(1)), tasks.get(0));
import org.opensearch.action.search.SearchAction;
                );
        assertParentTask(findEvents(BulkAction.NAME + "[s][r]", Tuple::v1), shardTask);
        // Verify that all [s] events have the proper parent
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;
import org.opensearch.action.bulk.BulkAction;
            assertThat(response.getNodeFailures(), not(empty()));
        assertDeleteTaskConflict(childTaskId, "stored child task results");
            });
    }
        assertNull(taskResult.getResponse());
        new TaskResourceStats(new HashMap<>() {
            false,
        TaskInfo failedTaskInfo = events.get(0);
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
import org.opensearch.ExceptionsHelper;
import java.util.concurrent.CyclicBarrier;
                assertTrue(response.getTask().isCompleted());
        OpenSearchStatusException exception = expectThrows(
        ensureGreen("test"); // Make sure all shards are allocated to catch replication tasks
                    public void waitForTaskCompletion(Task task) {
     * Test wait for completion.
                // is running
            for (Throwable failure : failures) {
        logger.debug("main event node {}", findEvents(RefreshAction.NAME, Tuple::v1).get(0).getTaskId().getNodeId());
/*
                    assertTrue(
        client().admin().indices().prepareUpgrade("test").get();
                assertEquals(TestTaskPlugin.TestTaskAction.NAME, task.getAction());
 * Integration tests for task management API
import static java.util.Collections.emptyList;
import java.util.concurrent.CompletableFuture;
            .setActions(TestTaskPlugin.TestTaskAction.NAME + "*")
        assertBusy(
import org.opensearch.common.regex.Regex;
            assertBusy(() -> {
                .setActions("indices:data/write/index*")
    }
        GetTaskResponse getResponse = expectFinishedTask(failedTaskId);
        assertThat(waitResponseFuture.get().getTasks(), empty());
                    onFailure(e);
        storeTaskResult(grandchildTaskId, childTaskId);
        try {
        assertParentTask(findEvents(ValidateQueryAction.NAME + "[s]", Tuple::v1), findEvents(ValidateQueryAction.NAME, Tuple::v1).get(0));
                assertNull(response.getTask().getResponse());
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
package org.opensearch.action.admin.cluster.node.tasks;
                throw new RuntimeException(e);
        TaskId parentTaskId = new TaskId("parent_node", randomLong());
            response -> {
        // coordinating node due to replication.
        assertEquals(1, topTask.size());
        assertThat(response.getTaskFailures(), emptyCollectionOf(TaskOperationFailure.class));
                );
                .prepareListTasks()
    }
import org.opensearch.core.action.ActionListener;
import org.opensearch.tasks.TaskResultsService;
                assertEquals(task.getStartTime(), fetchedWithGet.getStartTime());
     * Test waiting for a task that times out.
                                assertTrue(letTaskFinish.await(10, TimeUnit.SECONDS));
            /* Wait for the wait to start. This should count down just *before* we wait for completion but after the list/get has got a
        assertThat(numberOfEvents(RefreshAction.NAME + "[s]", Tuple::v1), greaterThanOrEqualTo(numberOfShards.numPrimaries));
            }
        waitForCompletionTestCase(
        TaskResult taskResult = response.getTask();
            .setTimeout(timeValueMillis(10))
import org.opensearch.OpenSearchStatusException;
        assertFalse(task.isCancelled());
                        && taskInfo.getTaskId().getNodeId().equals(event.v2().getTaskId().getNodeId())
            assertNoFailures(client().admin().indices().prepareRefresh(TaskResultsService.TASK_INDEX).get());
            assertEquals(mainTask.get(0).getTaskId(), taskInfo.getParentTaskId());
            for (TaskInfo task : listResponse.getTasks()) {
        // all node level tasks should have the main task as a parent
                );
        request.setParentTask(parentTaskId);
            id -> client().admin().cluster().prepareGetTask(id).setWaitForCompletion(true).execute(),
                .prepareListTasks()
        registerTaskManagerListeners(RefreshAction.NAME + "[s][*]"); // primary and replica shard tasks
        );
                assertEquals(task.getType(), fetchedWithGet.getType());
            new TestTaskPlugin.UnblockTestTasksRequestBuilder(client(), TestTaskPlugin.UnblockTestTasksAction.INSTANCE).get();
        // the shard level tasks should have the main task as a parent
                    fail("Unexpected action [" + taskInfo.getAction() + "] with description [" + taskInfo.getDescription() + "]");
import org.opensearch.action.support.replication.TransportReplicationActionTests;
        assertEquals(
            response -> {
        "test_type",
        assertThat(numberOfEvents(RefreshAction.NAME + "[s]", Tuple::v1), lessThanOrEqualTo(numberOfShards.numPrimaries * 2));
            }
                            try {
                case SearchTransportService.FETCH_ID_ACTION_NAME:
        // the percolate operation should produce one main task
        request.setShouldStoreResult(true);
        TaskInfo task = taskResult.getTask();
            .get();
        } finally {
                sTask = findEvents(
                        Regex.simpleMatch("id[*], size[1], lastEmittedDoc[null]", taskInfo.getDescription())
            .get();
        TaskResult taskResult = client().admin().cluster().getTask(new GetTaskRequest().setTaskId(failedTaskId)).get().getTask();
                try {
                // But the task's details should still be there because we grabbed a reference to the task before waiting for it to complete
        registerTaskManagerListeners(ValidateQueryAction.NAME + "[s]"); // shard
    }
        // Wait for the task to start on all nodes
                assertEquals(task.getDescription(), fetchedWithGet.getDescription());
            }
        assertEquals("my_id", taskInfo.getHeaders().get(Task.X_OPAQUE_ID));
import static org.hamcrest.Matchers.empty;
        assertEquals(1, numberOfEvents(RefreshAction.NAME, Tuple::v1));
        // It should finish quickly and without complaint and list the list tasks themselves
                .cluster()
                // This shard level task runs on the same node as a parent task - it should have the main task as a direct parent
        // check that if we have any shard-level requests they all have non-zero length description
        expectNotFound(waitResponseFuture::get);
                }
        // Save a fake task that looks like it is from a node that isn't part of the cluster
        client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request).get();
        for (TaskInfo taskInfo : shardTasks) {
        client().admin().indices().prepareValidateQuery("test").setAllShards(true).get();
        storeTaskResult(parentTaskId, TaskId.EMPTY_TASK_ID);
        TaskInfo taskInfo = events.get(0);
        assertEquals(taskInfo.getAction(), taskResult.getTask().getAction());
 * compatible open source license.
    /**
        }, new TaskThreadUsage(30, 40)),
                .get();
import org.opensearch.test.tasks.MockTaskManagerListener;
import org.opensearch.action.admin.indices.refresh.RefreshAction;
                assertParentTask(Collections.singletonList(taskInfo), sTasksOnRequestingNode.get(0));
    public void testListTasksWaitForTimeout() throws Exception {
            client().admin().cluster().prepareListTasks().setActions(TestTaskPlugin.TestTaskAction.NAME + "*").get().getTasks().size()
        assertEquals(failedTaskInfo.getType(), taskResult.getTask().getType());
        waitForTimeoutTestCase(id -> {
                        && taskInfo.getParentTaskId().getNodeId().equals(event.v2().getTaskId().getNodeId())
            () -> assertEquals(
        InputStream mockInputStream = getClass().getResourceAsStream("/org/opensearch/tasks/missing-fields-task-index-mapping.json");
                assertFalse("task should still be running", getResponse.getTask().isCompleted());
        2L
 * You may obtain a copy of the License at
        // Node isn't found, tasks index doesn't even exist
        registerTaskManagerListeners(UpgradeAction.NAME + "[n]"); // node level tasks
        );
                    );
        }
        headers.put(Task.X_REQUEST_ID, SAMPLE_REQUEST_ID_HEADER);
                    RefreshAction.NAME + "[s]",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;
        searchResponse = client().prepareSearch(TaskResultsService.TASK_INDEX)
                assertEquals(TestTaskPlugin.TestTaskAction.NAME, response.getTask().getTask().getAction());
        registerTaskManagerListeners(BulkAction.NAME + "[s][p]");  // shard task on primary
        );
        assertTrue(client().admin().cluster().prepareDeleteTask(grandchildTaskId).get().isAcknowledged());
            .get()
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
 */
        assertTrue(client().admin().cluster().prepareDeleteTask(task.getTaskId()).get().isAcknowledged());
        Map<?, ?> result = taskResult.getResponseAsMap();
     */
                // The task's details should also be there
        List<TaskInfo> events = findEvents(TestTaskPlugin.TestTaskAction.NAME, Tuple::v1);
                    public void taskExecutionStarted(Task task, Boolean closeableInvoked) {}
        }
 * The OpenSearch Contributors require contributions made to
import java.util.function.Consumer;
        "test_description",
    public void testNodeNotFoundButTaskFound() throws Exception {
            }
        assertEquals(1, numberOfEvents(UpgradeAction.NAME, Tuple::v1));
        TaskResultsService resultsService = internalCluster().getInstance(TaskResultsService.class);
            }
        assertThat(response.getNodeFailures(), emptyCollectionOf(OpenSearchException.class));
import static org.hamcrest.Matchers.startsWith;
        expectNotFound(() -> client().admin().cluster().prepareGetTask(new TaskId(internalCluster().getNodeNames()[0], 1)).get());
                assertEquals(task.getId(), fetchedWithGet.getId());
        GetTaskResponse getResponse = expectFinishedTask(taskId);
/*
            .get();
            .get();
        assertTrue(client().admin().cluster().prepareDeleteTask(parentTaskId).get().isAcknowledged());
    }
                        }
        expectNotFound(() -> client().admin().cluster().prepareGetTask("not_a_node:1").get());
                TaskInfo fetchedWithGet = getResponse.getTask().getTask();
        // Add request id to the header
                List<TaskInfo> childTasks = client().admin().cluster().prepareListTasks().setParentTaskId(parentTaskId).get().getTasks();
            for (TransportService transportService : internalCluster().getInstances(TransportService.class)) {
        assertEquals(1, numberOfEvents(ValidateQueryAction.NAME + "[s]", Tuple::v1));
            id -> client().admin()
                );
    }
    }
            }
                    public void waitForTaskCompletion(Task task) {}
            return singleton(e);
                    @Override
            .get();
        client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request).get();
        // Start blocking test task
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
    public void testListTasksWaitForCompletion() throws Exception {
                                throw new RuntimeException(e);
                    b.await();
    }
            if (shardTasks.get(0).getParentTaskId().equals(shardTasks.get(1).getTaskId())) {
    }
        assertNoFailures(client().admin().indices().prepareRefresh(TaskResultsService.TASK_INDEX).get());
        TaskResult taskResult = client().admin().cluster().getTask(new GetTaskRequest().setTaskId(taskId)).get().getTask();
        List<TaskInfo> shardTasks = findEvents(SearchAction.NAME + "[*]", Tuple::v1);
        0L,
            .setSource(SearchSourceBuilder.searchSource().query(QueryBuilders.termQuery("task.node", taskInfo.getTaskId().getNodeId())))
                .setWaitForCompletion(true)
            .prepareCancelTasks()
        // Tasks are marked as cancelled at this point but not yet completed.
        TaskId taskId = taskInfo.getTaskId();
        assertBusy(() -> {
        registerTaskManagerListeners(SearchAction.NAME + "[*]");  // shard task
                        && description.equals(event.v2().getDescription())
        logger.debug("main events {}", numberOfEvents(RefreshAction.NAME, Tuple::v1));
    public void testSearchTaskHeaderLimit() {
 * the Apache License, Version 2.0 (the "License"); you may
                    @Override
        }
        assertEquals(emptyList(), response.failures());
            null,
        // Spin up a request to wait for no matching tasks
        } finally {
        registerTaskManagerListeners(ValidateQueryAction.NAME + "[s]"); // shard level tasks
            }
                @Override
                .get();
        assertThat(exception.getMessage(), containsString(expectedMessage));
        int maxSize = Math.toIntExact(SETTING_HTTP_MAX_HEADER_SIZE.getDefault(Settings.EMPTY).getBytes() / 2 + 1);
            }
            }
    private static final String SAMPLE_REQUEST_ID_HEADER = "19d538d7c42d09240be001d1e4ff6203";
                .setDetailed(true)
 * this file be licensed under the Apache-2.0 license or a
        );
            // assert that all task descriptions have non-zero length
        createIndex("test");
        // Start non-blocking test task that should fail
import java.util.concurrent.CompletionException;
                assertEquals(task.getStatus(), fetchedWithGet.getStatus());
            new TestTaskPlugin.UnblockTestTasksRequestBuilder(client(), TestTaskPlugin.UnblockTestTasksAction.INSTANCE).get();
        assertEquals(1, numberOfEvents(ValidateQueryAction.NAME, Tuple::v1));
            client().admin().cluster().prepareListTasks().setActions(TestTaskPlugin.TestTaskAction.NAME + "[n]").get().getTasks().size()
        ActionFuture<TestTaskPlugin.NodesResponse> future = client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request);
        assertEquals(taskInfo.getDescription(), taskResult.getTask().getDescription());
                    break;
    public void testTasksListWaitForNoTask() throws Exception {
        createIndex("test");
        assertParentTask(findEvents(BulkAction.NAME + "[s][p]", Tuple::v1), shardTask);
            assertThat(listResponse.getTasks(), not(empty()));
import org.opensearch.core.tasks.TaskId;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
    }
        }
        assertEquals(1, events.size());
        ensureGreen("test"); // Make sure all shards are allocated to catch replication tasks
import org.opensearch.common.collect.Tuple;
        logger.info("--> checking that test tasks are not running");
import static org.hamcrest.Matchers.emptyCollectionOf;
        // Verify that one of these tasks is a parent of another task
            "test_description",
            waitForWaitingToStart.await();
        assertParentTask(findEvents(ValidateQueryAction.NAME + "[s]", Tuple::v1), findEvents(ValidateQueryAction.NAME, Tuple::v1).get(0));
        ListTasksResponse response = client().admin()
import java.util.concurrent.BrokenBarrierException;
                case SearchTransportService.QUERY_CAN_MATCH_NAME:
        assertEquals(1, mainTask.size());
import org.opensearch.tasks.TaskInfo;
    private TaskId waitForTestTaskStartOnAllNodes() throws Exception {
import java.io.ByteArrayOutputStream;
        }
        assertEquals(taskInfo.getType(), taskResult.getTask().getType());
/*
    public void testTasksWaitForAllTask() throws Exception {
        Thread index = null;
        b.await();
            } else {
        events = findEvents(TestTaskPlugin.TestTaskAction.NAME, Tuple::v1);
            null
        CountDownLatch taskRegistered = new CountDownLatch(1);
        TaskId.EMPTY_TASK_ID,
        assertEquals("test_description", task.getDescription());
        false,
                assertThat(fetchedWithGet.getRunningTimeNanos(), greaterThanOrEqualTo(task.getRunningTimeNanos()));
        TaskInfo shardTask;
        // but if it runs on non-coordinating node it would have another intermediate [s] task on the coordinating node as a parent
import org.opensearch.action.index.IndexAction;
            false,
            });
 * not use this file except in compliance with the License.
    );
        assertEquals(result, getResponse.getTask().getResponseAsMap());
                List<TaskInfo> sTasksOnRequestingNode = findEvents(
        if (shardTasks.size() == 1) {
        assertEquals(1L, searchResponse.getHits().getTotalHits().value());
        ActionFuture<GetTaskResponse> waitResponseFuture = client().admin()
 * license agreements. See the NOTICE file distributed with
            "test_type",
        assertBusy(
            public void onFailure(Exception e) {
        headers.put(Task.X_OPAQUE_ID, "my_id");
import org.opensearch.transport.ReceiveTimeoutTransportException;
            // Spin up a request that should wait for those tasks to finish
                .get();
        } finally {
        CountDownLatch letTaskFinish = new CountDownLatch(1);
        assertEquals("fake", task.getTaskId().getNodeId());
            });
        assertEquals(30, task.getResourceStats().getThreadUsage().getThreadExecutions());
import java.util.concurrent.TimeUnit;
        waitForCompletionTestCase(
                    public void onTaskUnregistered(Task task) {}
        } finally {
            assertTrue(taskInfo.isCancelled());
/**
    }
import java.util.Map;
 * this work for additional information regarding copyright
                    @Override
            .get();
                .getTasks();
        client().admin().indices().prepareValidateQuery("test").get();
        TaskInfo mainTask = findEvents(RefreshAction.NAME, Tuple::v1).get(0);
        // Run only on data nodes
        assertEquals(taskInfo.getTaskId(), taskResult.getTask().getTaskId());
    }
        headers.put(Task.X_REQUEST_ID, SAMPLE_REQUEST_ID_HEADER);
            if (taskInfo.getAction().endsWith("[s][p]")) {
                client().admin().cluster().prepareListTasks().setActions(TestTaskPlugin.TestTaskAction.NAME + "[n]").get().getTasks().size()
                // otherwise task 1 will control [s][p] and [s][r] tasks
 *    http://www.apache.org/licenses/LICENSE-2.0
        // we should get as many [s][r] operations as we have replica shards
                        && taskInfo.getDescription().equals(event.v2().getDescription())
                default:
        TaskId parentTaskId = new TaskId("fake", 100);
     */
        future.get();
            // Wait for the task to start
            .setId("test_id")
        assertNoFailures(client().admin().indices().prepareRefresh(TaskResultsService.TASK_INDEX).get());
            // we have only one task - it's going to be the parent task for all [s][p] and [s][r] tasks
    }
                internalCluster().size(),
        registerTaskManagerListeners(TestTaskPlugin.TestTaskAction.NAME);  // we need this to get task id of the process
        T waitResponse = waitResponseFuture.get();
            .setTimeout(timeValueMillis(10))
import org.opensearch.common.action.ActionFuture;
        ensureGreen("test"); // Make sure all shards are allocated
                    event -> event.v1()
        future.get();
        // the shard level operation should have the main task as its parent
                assertParentTask(Collections.singletonList(taskInfo), mainTask);
     * Wait for the test task to be running on all nodes and return the TaskId of the primary task.
        // Start blocking test task
        assertThat(response.getTasks().size(), greaterThanOrEqualTo(cluster().numDataNodes()));
        try {
        List<TaskInfo> events = findEvents(TestTaskPlugin.TestTaskAction.NAME, Tuple::v1);
        assertBusy(() -> {
        "test_action",
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2)
    public void testStoreTaskResultFailsDueToMissingIndexMappingFields() throws IOException {
            } else {
        assertNull(getResponse.getTask().getError());
            // Unblock the request so the wait for completion request can finish
            {
        assertEquals(1, numberOfEvents(BulkAction.NAME + "[s][p]", Tuple::v1));
        createIndex("test");
        // we will have as many [s][p] and [s][r] tasks as we have primary and replica shards
 * GitHub history for details.
    }
            // Spin up a request to wait for the test task to finish
import org.opensearch.action.support.PlainActionFuture;
                assertNotNull(response.getTask().getTask());
        assertEquals(TaskId.EMPTY_TASK_ID, task.getParentTaskId());
        logger.debug("nodes with the index {}", internalCluster().nodesInclude("test"));
            Collections.emptyMap(),
                    client().admin().cluster().prepareListTasks().setActions("indices:data/write/index*").get().getTasks()
             * reference to the running task. Because we unblock immediately after this the task may no longer be running for us to wait
        request.setParentTask(parentTaskId);
    }
        expectNotFound(() -> client().admin().cluster().prepareDeleteTask(failedTaskId).get());
        // we should also get 1 or 2 [s] operation with main operation as a parent
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
import org.opensearch.action.index.IndexResponse;
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
        ActionFuture<TestTaskPlugin.NodesResponse> future = client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request);
    public void testTaskCounts() {
            assertBusy(() -> client().admin().cluster().prepareGetTask(taskId).get());
        assertEquals(
        for (TaskInfo taskInfo : sTasks) {
 * ownership. Elasticsearch licenses this file to you under
                    emptyList(),
        // Spin up a request to wait for no matching tasks
        CancelTasksResponse cancelTasksResponse = client().admin()
                assertThat(response.getNodeFailures(), empty());
        assertNull(taskResult.getResponse());
        new TaskId("fake", 1),
        assertTrue(taskResult.isCompleted());
                // This shard level task runs on another node - it should have a corresponding shard level task on the node where main task
import java.util.Collections;
    public void testTaskStoringSuccessfulResult() throws Exception {
                assertParentTask(shardTasks.get(0), findEvents(BulkAction.NAME, Tuple::v1).get(0));
        assertEquals("0", result.get("failure_count").toString());
            .execute();
                put("dummy-type1", new TaskResourceUsage(10, 20));
        assertThat(task, hasSize(1));
 * SPDX-License-Identifier: Apache-2.0
                .cluster()
        assertEquals(2, numberOfEvents(ClusterHealthAction.NAME, Tuple::v1)); // counting only registration events
        );
                    event -> event.v1()
                TaskInfo task = response.getTasks().get(0);
        assertEquals(error, getResponse.getTask().getErrorAsMap());
    }
                        && taskInfo.getDescription().equals(event.v2().getDescription())
                    }
        });
        assertSearchResponse(client().filterWithHeader(headers).prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).get());
    private void assertTaskHeaders(TaskInfo taskInfo) {
        // If all primaries are not on the coordinating node, the number of tasks should be equal to the number of primaries times 2
            // Need to run the task in a separate thread because node client's .execute() is blocked by our task listener
                assertEquals(task.getAction(), fetchedWithGet.getAction());
            taskId,
        registerTaskManagerListeners(ValidateQueryAction.NAME); // main task
            if (index != null) {
            });
            .setSource(SearchSourceBuilder.searchSource().query(QueryBuilders.termQuery("task.action", taskInfo.getAction())))
                .get()
            .cluster()
        registerTaskManagerListeners(ClusterHealthAction.NAME);
        }
            response -> {
                public void onResponse(Void response) {
    }
        assertNotNull(taskResult.getError());
            )
        future.get();
        assertThat(mainTask.get(0).getDescription(), startsWith("indices[test], search_type["));
import org.opensearch.OpenSearchException;
            index = new Thread(() -> {
            assertBusy(() -> client().admin().cluster().prepareGetTask(taskId).get());
        ensureGreen("test"); // Make sure all shards are allocated
        // the field stats operation should produce one main task
            .cluster()
            // Register listeners so we can be sure the waiting started
        // Now that the task is unblocked the list response will come back
        registerTaskManagerListeners(TestTaskPlugin.TestTaskAction.NAME);  // we need this to get task id of the process
        List<TaskInfo> tasks = findEvents(ClusterHealthAction.NAME, Tuple::v1);
        CyclicBarrier b = new CyclicBarrier(2);
        logger.debug("[s][*] events {}", numberOfEvents(RefreshAction.NAME + "[s][*]", Tuple::v1));
            .prepareListTasks()
     */
        // Now run the health on a non-cluster-manager node - should produce one task on cluster-manager and one task on another node
                @Override
    public void testGetTaskWaitForTimeout() throws Exception {
 * <p>
        );
        assertThat(mainTask.get(0).getDescription(), containsString("\"query\":{\"match_all\""));
                assertEquals(task.getParentTaskId(), fetchedWithGet.getParentTaskId());
        List<TaskInfo> task = client().admin().cluster().prepareListTasks().setActions(TestTaskPlugin.TestTaskAction.NAME).get().getTasks();
        }
    }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    event -> event.v1()
            }
                .prepareListTasks()
            index.start();
    public void testDeleteTaskResultRequiresLeafFirstOrder() throws Exception {
        Map<String, String> headers = new HashMap<>();
        ListTasksResponse response = client().admin()
        future.get();
            .cluster()
            parentTaskId,
        false,
import org.opensearch.index.mapper.StrictDynamicMappingException;
            switch (taskInfo.getAction()) {
        );
        assertEquals(2, events.size());
        TaskId taskId;
                .cluster()
        headers.put(Task.X_OPAQUE_ID, "my_id");
    public void testTasksGetWaitForNoTask() throws Exception {
        // It should finish quickly and without complaint
                // We stored the task so we should get its results
        CompletionException thrown = assertThrows(CompletionException.class, () -> {
            assertBusy(() -> {
                assertEquals(
    /**
                index.join();
        expectNotFound(() -> client().admin().cluster().prepareDeleteTask(task.getTaskId()).get());
        registerTaskManagerListeners(ValidateQueryAction.NAME);  // main task
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        null,
            letTaskFinish.countDown();
        assertNull(taskResult.getError());
            }
import org.opensearch.search.builder.SearchSourceBuilder;
                .execute(),
        assertEquals(taskInfo.getHeaders(), taskResult.getTask().getHeaders());
        // Because it's broadcast replication action we will have as many [s] level requests
        TaskId childTaskId = new TaskId("fake", 101);
        // If all primaries are on the coordinating node, the number of tasks should be equal to the number of primaries
     * Very basic "is it plugged in" style test that indexes a document and makes sure that you can fetch the status of the process. The
 *
        // they all should have the same shard task as a parent
            .add(client().prepareIndex("test").setId("test_id").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON))
            .storeResult(new TaskResult(storedTaskInfo, new RuntimeException("test")), future);
        ensureGreen("test"); // Make sure all shards are allocated
import static org.hamcrest.Matchers.hasSize;
        assertEquals(Long.valueOf(2L), task.getCancellationStartTime());
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;
            // Now we can unblock those requests
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;
                    @Override
                });
    public void testTasksCancellation() throws Exception {
             * on which is fine. */
import org.opensearch.common.settings.Settings;
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
            @Override
        List<TaskInfo> taskInfoList = client().admin()
        assertTrue(taskResult.isCompleted());
                internalCluster().size(),
            Exception e = expectThrows(
                shardTask = shardTasks.get(0);
    private void waitForTimeoutTestCase(Function<TaskId, ? extends Iterable<? extends Throwable>> wait) throws Exception {
    public void testTransportBroadcastByNodeTasks() {
                assertThat(response.getTaskFailures(), empty());
        ActionFuture<TestTaskPlugin.NodesResponse> future = client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request);
    public void testCanFetchIndexStatus() throws Exception {
                .setActions(TestTaskPlugin.TestTaskAction.NAME)
                    RefreshAction.NAME + "[s]",
        ActionFuture<ListTasksResponse> waitResponseFuture = client().admin()
    }
        assertEquals(RestStatus.CONFLICT, exception.status());
            shardTask = shardTasks.get(0);
            new TestTaskPlugin.UnblockTestTasksRequestBuilder(client(), TestTaskPlugin.UnblockTestTasksAction.INSTANCE).get();
    }
        assertEquals(1, events.size());
    public void testTransportReplicationSingleShardTasks() {
                assertEquals(1, sTasksOnRequestingNode.size());
                    assertTrue(taskInfo.getDescription(), Regex.simpleMatch("shardId[[test][*]]", taskInfo.getDescription()));
        request.setShouldStoreResult(true);
 */
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
    }
import org.opensearch.action.support.replication.ReplicationResponse;
import org.opensearch.test.tasks.MockTaskManager;
        } else {
        assertTrue(client().admin().cluster().prepareDeleteTask(failedTaskId).get().isAcknowledged());
            .setActions(ListTasksAction.NAME + "[n]")
                }
                shardTask = shardTasks.get(1);
        // we the [s][p] and [s][r] tasks should have a corresponding [s] task on the same node as a parent
     */
            for (TransportService transportService : internalCluster().getInstances(TransportService.class)) {
        registerTaskManagerListeners(BulkAction.NAME);  // main task
                .prepareListTasks()
        assertTrue(client().admin().cluster().prepareDeleteTask(taskId).get().isAcknowledged());
            assertEquals(1, sTask.size());
        logger.info("--> started test tasks");
                ((MockTaskManager) transportService.getTaskManager()).addListener(new MockTaskManagerListener() {
        assertEquals("test_action", task.getAction());
        internalCluster().nonClusterManagerClient().admin().cluster().prepareHealth().get();
            assertParentTask(shardTask, findEvents(BulkAction.NAME, Tuple::v1).get(0));
            waitResponseFuture = wait.apply(taskId);
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.common.util.io.Streams;
        });
        assertEquals(internalCluster().nodesInclude("test").size(), numberOfEvents(UpgradeAction.NAME + "[n]", Tuple::v1));
                    future.complete(null);
        // as we have primary shards on the coordinating node plus we will have one task per primary outside of the
                            taskRegistered.countDown();
            .cluster()
            assertTaskHeaders(taskInfo);
    public void testGetTaskWaitForCompletionWithoutStoringResult() throws Exception {
            .prepareListTasks()
        // in case the primary is located on the coordinating node we will have 1 operation, otherwise - 2
            assertThat(taskInfo.getParentTaskId(), notNullValue());
                assertNotNull(ExceptionsHelper.unwrap(failure, OpenSearchTimeoutException.class, ReceiveTimeoutTransportException.class));
                Exception.class,
            assertThat(taskInfo.getDescription().length(), greaterThan(0));
        registerTaskManagerListeners(RefreshAction.NAME);  // main task
    public void testTransportBroadcastReplicationTasks() {
                assertNotNull(task.getStatus());
     * @param validator validate the response and return the task ids that were found
        registerTaskManagerListeners(BulkAction.NAME + "[s]");  // shard task
        assertEquals(failedTaskInfo.getTaskId(), taskResult.getTask().getTaskId());
        for (TaskInfo taskInfo : spEvents) {
        try {
import java.util.concurrent.CountDownLatch;
        new TestTaskPlugin.UnblockTestTasksRequestBuilder(client(), TestTaskPlugin.UnblockTestTasksAction.INSTANCE).get();
        });
        assertEquals(taskInfo.getStartTime(), taskResult.getTask().getStartTime());
            )
            .setWaitForCompletion(true)
        assertEquals(1, numberOfEvents(ValidateQueryAction.NAME, Tuple::v1));
        // Start blocking test task
            // There should be only one parent task
        ensureGreen("test"); // Make sure all shards are allocated
        // we should also get one [s][p] operation with shard operation as a parent
        assertTaskHeaders(mainTask.get(0));
        String mockJsonString = out.toString(StandardCharsets.UTF_8.name());
 * software distributed under the License is distributed on an
                assertEquals(task.isCancellable(), fetchedWithGet.isCancellable());
    public void testGetTaskNotFound() throws Exception {
        headers.put("Custom-Task-Header", "my_value");
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        assertEquals(failedTaskInfo.getAction(), taskResult.getTask().getAction());
     * @param wait start waiting for a task. Accepts that id of the task to wait for and returns a future waiting for it.
            assertTrue(taskRegistered.await(10, TimeUnit.SECONDS)); // waiting for at least one task to be registered
        createIndex("test");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
            .cluster()
                assertThat(childTasks, hasSize(1));
    private <T> void waitForCompletionTestCase(boolean storeResult, Function<TaskId, ActionFuture<T>> wait, Consumer<T> validator)
        assertThat(ex.getMessage(), startsWith("Request exceeded the maximum size of task headers "));
import static org.mockito.Mockito.spy;
            CompletableFuture<Void> future = new CompletableFuture<>();
                assertThat(response.getTasks(), hasSize(1));
                // task 1 is the parent of task 0, that means that task 0 will control [s][p] and [s][r] tasks
        request.setShouldBlock(false);
        assertEquals(1, numberOfEvents(ClusterHealthAction.NAME, Tuple::v1)); // counting only registration events
            assertParentTask(Collections.singletonList(tasks.get(0)), tasks.get(1));
        } else {
        registerTaskManagerListeners(RefreshAction.NAME + "[s]"); // shard level tasks
        client().admin().indices().prepareRefresh("test").get();
        client().admin().indices().preparePutMapping("test").setSource("foo", "type=keyword").get();
            .setWaitForCompletion(true)
            .prepareGetTask("notfound:1")
import java.io.InputStream;
import static org.hamcrest.Matchers.containsString;
    }
        // ensures the mapping is available on all nodes so we won't retry the request (in case replicas don't have the right mapping).
            false,
import static org.hamcrest.Matchers.not;
                    break;
            taskId = waitForTestTaskStartOnAllNodes();
                GetTaskResponse getResponse = client().admin().cluster().prepareGetTask(task.getTaskId()).get();
        // Get real client (the plugin is not registered on transport nodes)
    public void testSearchTaskDescriptions() {
    public void testGetTaskWaitForCompletionWithStoringResult() throws Exception {
        assertThat(shardTask.getDescription(), startsWith("requests[1], index[test]["));
                    assertTrue(taskInfo.getDescription(), Regex.simpleMatch("id[*], indices[test]", taskInfo.getDescription()));
        // Start blocking test task
 * Unless required by applicable law or agreed to in writing,
        TestTaskPlugin.NodesResponse response = future.get();
import org.opensearch.tasks.TaskResult;
        logger.info("--> cancelling the main test task");
            () -> assertEquals(
        storeTaskResult(parentTaskId, TaskId.EMPTY_TASK_ID);
        assertTrue(thrown.getCause() instanceof StrictDynamicMappingException);
            assertParentTask(Collections.singletonList(taskInfo), sTask.get(0));
        assertNoFailures(client().admin().indices().prepareRefresh(TaskResultsService.TASK_INDEX).get());
                } catch (InterruptedException | BrokenBarrierException e) {
                // We didn't store the result so it won't come back when we wait
                    public void onTaskRegistered(Task task) {}
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
            0,
        headers.put("Foo-Header", "bar");
        assertEquals(SAMPLE_REQUEST_ID_HEADER, taskInfo.getHeaders().get(Task.X_REQUEST_ID));
        1L,
        );
import static java.util.Collections.singleton;
        createIndex("test");
        // run it again to check that the tasks index has been successfully created and can be re-used
        assertFutureThrows(client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request), IllegalStateException.class);
import org.opensearch.action.support.WriteRequest;
                        && mainTask.getTaskId().getNodeId().equals(event.v2().getTaskId().getNodeId())
        logger.debug("[s] events {}", numberOfEvents(RefreshAction.NAME + "[s]", Tuple::v1));
                        waitForWaitingToStart.countDown();
        // and then one operation
                }
        List<TaskInfo> mainTask = findEvents(SearchAction.NAME, Tuple::v1);
                    break;
        List<TaskInfo> sTasks = findEvents(RefreshAction.NAME + "[s]", Tuple::v1);
        PlainActionFuture<Void> future = new PlainActionFuture<>();
            assertDeleteTaskConflict(parentTaskId, "running child tasks");
            0L,
                        if (task.getAction().startsWith(IndexAction.NAME)) {
        assertEquals(failedTaskInfo.getHeaders(), taskResult.getTask().getHeaders());
                () -> client().admin().cluster().prepareGetTask(id).setWaitForCompletion(true).setTimeout(timeValueMillis(100)).get()
        // given
                assertNotNull(response.getTask().getTask());
        // Wait for the task to start on all nodes
                public void onFailure(Exception e) {
        // and then one operation per shard
        // Node exists but the task still isn't found
        assertEquals(1, task.getTaskId().getId());
            ListTasksResponse listResponse = client().admin()
import org.opensearch.index.query.QueryBuilders;
        assertEquals(1, numberOfEvents(ClusterHealthAction.NAME, event -> event.v1() == false)); // counting only unregistration events
        // First latch waits for the task to start, second on blocks it from finishing.
        assertEquals(2, numberOfEvents(ClusterHealthAction.NAME, event -> event.v1() == false)); // counting only unregistration events
        Map<String, String> headers = new HashMap<>();
                    public void onTaskRegistered(Task task) {
        validator.accept(waitResponse);
        assertFalse(task.isCancellable());
        });
        List<TaskInfo> shardTasks = findEvents(BulkAction.NAME + "[s]", Tuple::v1);
import static org.hamcrest.Matchers.allOf;
            .prepareListTasks("data:true")
            // and it should have the main task as a parent
                    assertTrue(taskInfo.getDescription(), Regex.simpleMatch("shardId[[test][*]]", taskInfo.getDescription()));
        return task.get(0).getTaskId();
        assertEquals("test_type", task.getType());
        internalCluster().clusterManagerClient().admin().cluster().prepareHealth().get();
            .setTimeout(timeValueSeconds(10))
        ActionFuture<TestTaskPlugin.NodesResponse> future = client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request);
            // Wait for the task to start
 * We need at least 2 nodes so we have a cluster-manager node a non-cluster-manager node
        // Now we can find it!
                case SearchTransportService.DFS_ACTION_NAME:
import org.opensearch.core.tasks.resourcetracker.TaskThreadUsage;
        registerTaskManagerListeners(BulkAction.NAME + "[s][r]");  // shard task on replica
            CountDownLatch waitForWaitingToStart = new CountDownLatch(1);
     * goal here is to verify that the large moving parts that make fetching task status work fit together rather than to verify any
import org.opensearch.action.TaskOperationFailure;
import org.opensearch.core.rest.RestStatus;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(shardTasks.size(), allOf(lessThanOrEqualTo(2), greaterThanOrEqualTo(1)));
        TaskInfo storedTaskInfo = new TaskInfo(
        // Start non-blocking test task
        assertDeleteTaskConflict(parentTaskId, "stored child task results");
                        taskInfo.getDescription(),
        assertTrue(client().admin().cluster().prepareDeleteTask(childTaskId).get().isAcknowledged());
            OpenSearchStatusException.class,
        NumShards numberOfShards = getNumShards("test");
                    @Override
    /**
                case SearchTransportService.QUERY_ID_ACTION_NAME:
        Streams.copy(mockInputStream, out);
 *
                ((MockTaskManager) transportService.getTaskManager()).addListener(new MockTaskManagerListener() {
    public void testDeleteTaskResultRejectsRunningChild() throws Exception {
    }
            null,
 * Licensed to Elasticsearch under one or more contributor
                assertParentTask(shardTasks.get(1), findEvents(BulkAction.NAME, Tuple::v1).get(0));
                    future.completeExceptionally(e);
        future.actionGet();
        assertEquals(1, cancelTasksResponse.getTasks().size());
            } else {
        assertEquals(getNumShards("test").numReplicas, numberOfEvents(BulkAction.NAME + "[s][r]", Tuple::v1));
import static org.hamcrest.Matchers.greaterThan;
                .setSource(SearchSourceBuilder.searchSource().query(QueryBuilders.idsQuery().addIds(taskId.toString())))
        assertNoFailures(client().admin().indices().prepareRefresh(TaskResultsService.TASK_INDEX).get());
