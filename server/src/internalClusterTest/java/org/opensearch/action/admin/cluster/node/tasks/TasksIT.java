        });
        assertEquals(
        assertEquals("test_description", task.getDescription());
                assertParentTask(Collections.singletonList(taskInfo), sTasksOnRequestingNode.get(0));
 * The OpenSearch Contributors require contributions made to  
            }
    }  
        NumShards numberOfShards = getNumShards("test");
        assertThat(mainTask.get(0).getDescription(), startsWith("indices[test], search_type["));
            Exception e = expectThrows(
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
        assertParentTask(findEvents(UpgradeAction.NAME + "[n]", Tuple::v1), findEvents(UpgradeAction.NAME, Tuple::v1).get(0));
            index = new Thread(() -> {
            assertTrue(taskRegistered.await(10, TimeUnit.SECONDS)); // waiting for at least one task to be registered  
            IllegalArgumentException.class,
                assertArrayEquals(ReplicationResponse.EMPTY, indexResponse.getShardInfo().getFailures());  
            letTaskFinish.countDown();
            1L,
        request.setShouldFail(true);
            assertBusy(() -> {
        // we should get as many [s][r] operations as we have replica shards
        }, new TaskThreadUsage(30, 40)),
                        && taskInfo.getDescription().equals(event.v2().getDescription())
    }
        // Now that the task is unblocked the list response will come back
import org.opensearch.common.collect.Tuple;
        ActionFuture<TestTaskPlugin.NodesResponse> future = client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request);  
        assertEquals("0", result.get("failure_count").toString());
        assertEquals(taskInfo.getParentTaskId(), taskResult.getTask().getParentTaskId());  
        CountDownLatch letTaskFinish = new CountDownLatch(1);
        waitForTimeoutTestCase(id -> {
        0L,  
        // First run the health on the cluster-manager node - should produce only one task on the cluster-manager node  
            assertBusy(() -> client().admin().cluster().prepareGetTask(taskId).get());  
        logger.debug("[s][*] events {}", numberOfEvents(RefreshAction.NAME + "[s][*]", Tuple::v1));
        assertTrue(client().admin().cluster().prepareDeleteTask(grandchildTaskId).get().isAcknowledged());
                @Override
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;
     * Wait for the test task to be running on all nodes and return the TaskId of the primary task.
        );
            Collections.emptyMap(),  
import java.io.IOException;  
        headers.put(Task.X_REQUEST_ID, SAMPLE_REQUEST_ID_HEADER);
        assertEquals(1, events.size());
        TaskId parentTaskId = new TaskId("fake", 200);
                assertEquals(TestTaskPlugin.TestTaskAction.NAME, response.getTask().getTask().getAction());  
    }  
                assertEquals(task.getDescription(), fetchedWithGet.getDescription());
import org.opensearch.core.rest.RestStatus;
                // But the task's details should still be there because we grabbed a reference to the task before waiting for it to complete
        registerTaskManagerListeners(UpgradeAction.NAME);  // main task
            }  
                assertNull(response.getTask().getResponse());  
        client().prepareBulk()  
                    RefreshAction.NAME + "[s]",
        b.await();  
        // Wait for the task to start on all nodes
    public void testListTasksWaitForCompletion() throws Exception {
import static org.mockito.Mockito.spy;  
import org.opensearch.test.tasks.MockTaskManager;  
        // If all primaries are not on the coordinating node, the number of tasks should be equal to the number of primaries times 2
 * this file be licensed under the Apache-2.0 license or a
    public void testTasksUnblocking() throws Exception {
            )
        // This is complicated because if the shard task runs on the same node it has main task as a parent  
        }
            .add(client().prepareIndex("test").setId("test_id").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON))
        internalCluster().getInstance(TaskResultsService.class)
        assertNoFailures(client().admin().indices().prepareRefresh(TaskResultsService.TASK_INDEX).get());
        ActionFuture<GetTaskResponse> waitResponseFuture = client().admin()
import java.util.function.Consumer;
        request.setShouldBlock(false);
        assertParentTask(findEvents(BulkAction.NAME + "[s][r]", Tuple::v1), shardTask);
                .execute(),  
        client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request).get();
        CompletionException thrown = assertThrows(CompletionException.class, () -> {
 * the Apache License, Version 2.0 (the "License"); you may
                assertNotNull(response.getTask().getTask());
            response -> {
        assertEquals(failedTaskInfo.getDescription(), taskResult.getTask().getDescription());  
        assertEquals(failedTaskInfo.getType(), taskResult.getTask().getType());
        request.setShouldBlock(false);
            }
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        return task.get(0).getTaskId();
            id -> client().admin()
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;  
        // we the [s][p] and [s][r] tasks should have a corresponding [s] task on the same node as a parent  
            null,
        assertBusy(  
        assertTrue(taskResult.isCompleted());
                .setSource(SearchSourceBuilder.searchSource().query(QueryBuilders.idsQuery().addIds(taskId.toString())))
        logger.debug("nodes with the index {}", internalCluster().nodesInclude("test"));  
import org.opensearch.ExceptionsHelper;
import org.opensearch.action.index.IndexAction;
 * under the License.  
        TaskId taskId;
        T waitResponse = waitResponseFuture.get();
        CyclicBarrier b = new CyclicBarrier(2);
        assertParentTask(findEvents(ValidateQueryAction.NAME + "[s]", Tuple::v1), findEvents(ValidateQueryAction.NAME, Tuple::v1).get(0));
                // We stored the task so we should get its results
                }
                assertParentTask(shardTasks.get(1), findEvents(BulkAction.NAME, Tuple::v1).get(0));
        InputStream mockInputStream = getClass().getResourceAsStream("/org/opensearch/tasks/missing-fields-task-index-mapping.json");
                assertEquals(1, sTasksOnRequestingNode.size());
        List<TaskInfo> topTask = findEvents(BulkAction.NAME, Tuple::v1);
    public void testGetTaskWaitForTimeout() throws Exception {
 */  
        if (tasks.get(0).getParentTaskId().isSet()) {
        request.setShouldStoreResult(true);  
 */
            TaskId taskId = waitForTestTaskStartOnAllNodes();  
import org.opensearch.action.admin.cluster.health.ClusterHealthAction;  
        } finally {
                        Regex.simpleMatch("id[*], size[1], lastEmittedDoc[null]", taskInfo.getDescription())
            assertThat(taskInfo.getParentTaskId(), notNullValue());  
        assertEquals(2, numberOfEvents(ClusterHealthAction.NAME, Tuple::v1)); // counting only registration events  
        assertThat(shardTasks.size(), allOf(lessThanOrEqualTo(2), greaterThanOrEqualTo(1)));  
    public void testCanFetchIndexStatus() throws Exception {
                    client().admin().cluster().prepareListTasks().setActions("indices:data/write/index*").get().getTasks()
            .setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON)
        registerTaskManagerListeners(BulkAction.NAME + "[s][p]");  // shard task on primary  
    }
        IllegalArgumentException ex = expectThrows(  
        null,
        ActionFuture<TestTaskPlugin.NodesResponse> future = client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request);  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                assertEquals(task.getAction(), fetchedWithGet.getAction());
        }
import org.opensearch.test.OpenSearchIntegTestCase;
            assertNotNull(taskInfo.getCancellationStartTime());
                .getTasks();
            }
        assertEquals(1L, task.getRunningTimeNanos());
        // the validate operation should produce one main task  
            .get();
     * @param wait wait for the running task and return all the failures you accumulated waiting for it
        // Add request id to the header
        assertTaskHeaders(mainTask.get(0));
            // Need to run the task in a separate thread because node client's .execute() is blocked by our task listener  
        assertTrue(client().admin().cluster().prepareDeleteTask(parentTaskId).get().isAcknowledged());  
                // The task's details should also be there
        registerTaskManagerListeners(ClusterHealthAction.NAME);
    public void testListTasksWaitForTimeout() throws Exception {  
            taskId,
        try {
 * We need at least 2 nodes so we have a cluster-manager node a non-cluster-manager node
            assertEquals(1, sTask.size());
 * Modifications Copyright OpenSearch Contributors. See
            id -> client().admin().cluster().prepareGetTask(id).setWaitForCompletion(true).execute(),
    private void assertTaskHeaders(TaskInfo taskInfo) {
            }
        GetTaskResponse getResponse = expectFinishedTask(taskId);
        assertEquals(1L, searchResponse.getHits().getTotalHits().value());  
        );
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
            () -> assertEquals(
     */
import org.opensearch.tasks.TaskInfo;
import org.opensearch.index.mapper.StrictDynamicMappingException;
                    onFailure(e);  
        for (TaskInfo taskInfo : spEvents) {
        client().admin().indices().prepareValidateQuery("test").setAllShards(true).get();
        registerTaskManagerListeners(UpgradeAction.NAME + "[n]"); // node level tasks  
                    break;
        }  
                assertEquals(TestTaskPlugin.TestTaskAction.NAME, response.getTask().getTask().getAction());  
        }  
        assertEquals("my_id", taskInfo.getHeaders().get(Task.X_OPAQUE_ID));  
                .setActions("indices:data/write/index*")
 * Integration tests for task management API  
        );
                        && description.equals(event.v2().getDescription())
        headers.put("Custom-Task-Header", randomAlphaOfLengthBetween(maxSize, maxSize + 100));
                    @Override
                        && mainTask.getTaskId().getNodeId().equals(event.v2().getTaskId().getNodeId())  
                // We didn't store the result so it won't come back when we wait
            } else {
        future.get();  
        for (TaskInfo taskInfo : shardTasks) {
import org.opensearch.action.admin.indices.upgrade.post.UpgradeAction;
        assertTrue(client().admin().cluster().prepareDeleteTask(childTaskId).get().isAcknowledged());
        // all node level tasks should have the main task as a parent
                }
        assertThat(ex.getMessage(), startsWith("Request exceeded the maximum size of task headers "));
 * this work for additional information regarding copyright
            });
        "test_action",  
        List<TaskInfo> shardTasks = findEvents(SearchAction.NAME + "[*]", Tuple::v1);
import static org.hamcrest.Matchers.allOf;  
        logger.debug("main events {}", numberOfEvents(RefreshAction.NAME, Tuple::v1));
        assertEquals(1, cancelTasksResponse.getTasks().size());  
    public void testTransportReplicationSingleShardTasks() {
import org.opensearch.action.support.replication.TransportReplicationActionTests;  
            Iterable<? extends Throwable> failures = wait.apply(taskId);
            });
        assertEquals(getNumShards("test").numReplicas, numberOfEvents(BulkAction.NAME + "[s][r]", Tuple::v1));  
        assertSearchResponse(client().filterWithHeader(headers).prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).get());  
        assertThat(task, hasSize(1));  
 * You may obtain a copy of the License at  
        assertThat(numberOfEvents(RefreshAction.NAME + "[s]", Tuple::v1), greaterThanOrEqualTo(numberOfShards.numPrimaries));
        registerTaskManagerListeners(RefreshAction.NAME + "[s]"); // shard level tasks
            ListTasksResponse response = client().admin()
                    event -> event.v1()
        });
        Streams.copy(mockInputStream, out);
        assertEquals(1, numberOfEvents(UpgradeAction.NAME, Tuple::v1));  
        registerTaskManagerListeners(BulkAction.NAME + "[s][r]");  // shard task on replica
                            taskRegistered.countDown();
            // There should be only one parent task  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        }  
    }  
            public void onFailure(Exception e) {
        );
        assertEquals(2, numberOfEvents(ClusterHealthAction.NAME, event -> event.v1() == false)); // counting only unregistration events
        assertBusy(
            }
                    future.completeExceptionally(e);  
            }
                );
        OpenSearchStatusException exception = expectThrows(
                            try {  
                );
                assertEquals(task.getStatus(), fetchedWithGet.getStatus());  
        logger.info("--> started test tasks");
import java.util.concurrent.CompletionException;  
            .setWaitForCompletion(true)
            false,
        assertEquals(TaskId.EMPTY_TASK_ID, task.getParentTaskId());
            .get();
                        }
        assertThat(taskInfo.getHeaders().keySet(), hasSize(3));
                    @Override
 */  
                .setTimeout(timeValueMillis(100))
        assertEquals(taskInfo.getAction(), taskResult.getTask().getAction());
/*
            response -> {  
        CountDownLatch taskRegistered = new CountDownLatch(1);
        assertEquals(1, numberOfEvents(ClusterHealthAction.NAME, Tuple::v1)); // counting only registration events
        assertThat(exception.getMessage(), containsString(expectedMessage));
            .setActions(TestTaskPlugin.TestTaskAction.NAME)
                assertThat(response.getNodeFailures(), empty());
import static org.hamcrest.Matchers.greaterThan;
        assertEquals(40, task.getResourceStats().getThreadUsage().getActiveThreads());
                } catch (InterruptedException | BrokenBarrierException e) {
        assertNoFailures(client().admin().indices().prepareRefresh(TaskResultsService.TASK_INDEX).get());
                Exception.class,
 */  
            false,  
        2L
    /**
                assertFalse("task should still be running", getResponse.getTask().isCompleted());  
                .get();
import org.opensearch.OpenSearchException;
            .setWaitForCompletion(true)
                // A [s][p] level task should have a corresponding [s] level task on the same node
    public void testTransportBroadcastByNodeTasks() {
                    }  
        storeTaskResult(parentTaskId, TaskId.EMPTY_TASK_ID);  
            "test_type",  
import org.opensearch.OpenSearchTimeoutException;
        ActionFuture<T> waitResponseFuture;  
    private void waitForTimeoutTestCase(Function<TaskId, ? extends Iterable<? extends Throwable>> wait) throws Exception {
        for (TaskInfo taskInfo : taskInfoList) {  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;
    public void testDeleteTaskResultRequiresLeafFirstOrder() throws Exception {
            }
                    @Override
import static org.hamcrest.Matchers.empty;
            () -> client().filterWithHeader(headers).admin().cluster().prepareListTasks().get()
    public void testTaskStoringFailureResult() throws Exception {
        // Because it's broadcast replication action we will have as many [s] level requests  
            true,
        assertTrue(thrown.getCause() instanceof StrictDynamicMappingException);
        // Run only on data nodes  
        List<TaskInfo> mainTask = findEvents(SearchAction.NAME, Tuple::v1);  
        logger.debug("number of shards, total: [{}], primaries: [{}] ", numberOfShards.totalNumShards, numberOfShards.numPrimaries);
        // Now we can find it!
        assertEquals(1, topTask.size());  
import org.opensearch.search.builder.SearchSourceBuilder;  
            // Wait for the task to start
                assertNotNull(response.getTask().getTask());
        ListTasksResponse response = client().admin()  
import org.opensearch.action.search.SearchResponse;
        PlainActionFuture<Void> future = new PlainActionFuture<>();
                    public void onTaskRegistered(Task task) {}  
            assertBusy(() -> client().admin().cluster().prepareGetTask(taskId).get());  
        ensureGreen("test"); // Make sure all shards are allocated
                try {  
                );
        registerTaskManagerListeners(ValidateQueryAction.NAME);  // main task  
        assertFalse(task.isCancellable());
            ListTasksResponse listResponse = client().admin()
        ensureGreen("test"); // Make sure all shards are allocated to catch replication tasks
                    future.complete(null);
     * task recording mechanism used in other places in this test so we can make sure that the status fetching works properly over the wire.  
            null,  
        // we should also get one [s][p] operation with shard operation as a parent  
        );
        assertEquals("test_type", task.getType());  
                    b.await();
                assertEquals(task.isCancellable(), fetchedWithGet.isCancellable());  
                    assertTrue(taskInfo.getDescription(), Regex.simpleMatch("shardId[[test][*]]", taskInfo.getDescription()));  
            .prepareCancelTasks()  
                // in turn the parent of the task 1 should be the main task
        // coordinating node due to replication.
    }
        } finally {  
        List<TaskInfo> events = findEvents(TestTaskPlugin.TestTaskAction.NAME, Tuple::v1);  
            });
        registerTaskManagerListeners(RefreshAction.NAME);  // main task  
        assertEquals(RestStatus.CONFLICT, exception.status());  
                });
        // First latch waits for the task to start, second on blocks it from finishing.  
        // Save a fake task that looks like it is from a node that isn't part of the cluster  
        storeTaskResult(parentTaskId, TaskId.EMPTY_TASK_ID);
            .cluster()
 *    http://www.apache.org/licenses/LICENSE-2.0
        Thread index = null;  
                .prepareListTasks()  
        }  
            for (TransportService transportService : internalCluster().getInstances(TransportService.class)) {
        createIndex("test");
            .execute();  
            assertBusy(() -> {
                public void onResponse(Void response) {  
            "test_description",
     */  
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");  
        assertEquals("my_value", taskInfo.getHeaders().get("Custom-Task-Header"));
        assertEquals(numberOfShards.numPrimaries, numberOfEvents(ValidateQueryAction.NAME + "[s]", Tuple::v1));
        waitForCompletionTestCase(  
            // Wait for the task to start
        client().admin().indices().prepareUpgrade("test").get();  
import java.util.List;
import org.opensearch.action.search.SearchTransportService;
            }
                assertEquals(task.getId(), fetchedWithGet.getId());
        createIndex("test");
        logger.debug("main event node {}", findEvents(RefreshAction.NAME, Tuple::v1).get(0).getTaskId().getNodeId());  
import org.opensearch.tasks.Task;
                .get();
        try {
        searchResponse = client().prepareSearch(TaskResultsService.TASK_INDEX)
 * Licensed to Elasticsearch under one or more contributor  
                List<TaskInfo> childTasks = client().admin().cluster().prepareListTasks().setParentTaskId(parentTaskId).get().getTasks();  
            .get();
                .prepareListTasks()
    public void testNodeNotFoundButTaskFound() throws Exception {
        List<TaskInfo> spEvents = findEvents(RefreshAction.NAME + "[s][*]", Tuple::v1);
import java.util.concurrent.CompletableFuture;
        expectNotFound(() -> client().admin().cluster().prepareDeleteTask(task.getTaskId()).get());
                assertThat(response.getTasks(), hasSize(1));
        assertEquals("test_action", task.getAction());
        request.setShouldStoreResult(storeResult);  
            assertThat(listResponse.getTasks(), not(empty()));
        // the bulk operation should produce one main task
            index.start();
                    @Override
import org.opensearch.tasks.TaskResult;  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;
        request.setParentTask(parentTaskId);  
        );  
        // Start non-blocking test task that should fail  
    private static final String SAMPLE_REQUEST_ID_HEADER = "19d538d7c42d09240be001d1e4ff6203";
        future.get();
 * KIND, either express or implied.  See the License for the
            .prepareListTasks()
 * Unless required by applicable law or agreed to in writing,
        TaskId parentTaskId = new TaskId("fake", 100);  
                case SearchTransportService.FETCH_ID_ACTION_NAME:
                // This shard level task runs on the same node as a parent task - it should have the main task as a direct parent  
                GetTaskResponse getResponse = client().admin().cluster().prepareGetTask(task.getTaskId()).get();
    }
                .setActions(TestTaskPlugin.TestTaskAction.NAME)
        assertThat(response.getTaskFailures(), emptyCollectionOf(TaskOperationFailure.class));  
    }
            .storeResult(new TaskResult(storedTaskInfo, new RuntimeException("test")), future);  
            new TestTaskPlugin.UnblockTestTasksRequestBuilder(client(), TestTaskPlugin.UnblockTestTasksAction.INSTANCE).get();
        assertEquals(1, task.getResourceStats().getResourceUsageInfo().size());
    }
                // otherwise task 1 will control [s][p] and [s][r] tasks
    public void testTaskStoringSuccessfulResult() throws Exception {
        // Start blocking test task  
    }
    }
                ((MockTaskManager) transportService.getTaskManager()).addListener(new MockTaskManagerListener() {  
        expectNotFound(() -> client().admin().cluster().prepareGetTask(new TaskId(internalCluster().getNodeNames()[0], 1)).get());
    }  
                assertEquals(TestTaskPlugin.TestTaskAction.NAME, task.getAction());  
                    @Override
                                assertTrue(letTaskFinish.await(10, TimeUnit.SECONDS));
            .cluster()
            id -> client().admin().cluster().prepareGetTask(id).setWaitForCompletion(true).execute(),
        TaskInfo storedTaskInfo = new TaskInfo(
        Map<?, ?> result = taskResult.getResponseAsMap();  
            .setSource(SearchSourceBuilder.searchSource().query(QueryBuilders.termQuery("task.action", taskInfo.getAction())))  
        assertEquals(taskInfo.getType(), taskResult.getTask().getType());
            } else {  
                        && taskInfo.getDescription().equals(event.v2().getDescription())  
     * @param wait start waiting for a task. Accepts that id of the task to wait for and returns a future waiting for it.
import org.opensearch.action.search.SearchAction;  
            .prepareListTasks()
        } finally {
        events = findEvents(TestTaskPlugin.TestTaskAction.NAME, Tuple::v1);  
                            }
                    fail("Unexpected action [" + taskInfo.getAction() + "] with description [" + taskInfo.getDescription() + "]");  
                assertEquals(task.getStartTime(), fetchedWithGet.getStartTime());
        assertEquals(1, events.size());  
        registerTaskManagerListeners(TestTaskPlugin.TestTaskAction.NAME);  // we need this to get task id of the process
                assertEquals(  
                IndexResponse indexResponse = client().prepareIndex("test").setSource("test", "test").get();
        assertThat(response.getTasks().size(), greaterThanOrEqualTo(1));
        assertNull(getResponse.getTask().getResponse());
            .setTimeout(timeValueMillis(10))  
        List<TaskInfo> task = client().admin().cluster().prepareListTasks().setActions(TestTaskPlugin.TestTaskAction.NAME).get().getTasks();
        false,  
        } else {  
        assertBusy(() -> {
    protected final TaskInfo taskInfo = new TaskInfo(  
        // in case the primary is located on the coordinating node we will have 1 operation, otherwise - 2
        new TestTaskPlugin.UnblockTestTasksRequestBuilder(client(), TestTaskPlugin.UnblockTestTasksAction.INSTANCE).get();
import org.opensearch.action.admin.indices.refresh.RefreshAction;  
    public void testTransportBroadcastReplicationTasks() {
            .setSource(SearchSourceBuilder.searchSource().query(QueryBuilders.termQuery("task.node", taskInfo.getTaskId().getNodeId())))  
                TaskInfo task = response.getTasks().get(0);
        assertEquals(2, events.size());
        future.get();
        // Verify that one of these tasks is a parent of another task
        Map<String, String> headers = new HashMap<>();  
            if (mainTask.getTaskId().getNodeId().equals(taskInfo.getTaskId().getNodeId())) {
import java.util.Collections;  
        // Get real client (the plugin is not registered on transport nodes)
    }  
    public void testTransportBulkTasks() {  
        assertEquals(1, task.getTaskId().getId());
            0,
    public void testTasksCancellation() throws Exception {
    }
}  
import java.util.function.Function;
        registerTaskManagerListeners(ValidateQueryAction.NAME + "[s]"); // shard level tasks
import java.util.Map;  
        NumShards numberOfShards = getNumShards("test");
        TaskId failedTaskId = failedTaskInfo.getTaskId();  
        GetTaskResponse getResponse = expectFinishedTask(failedTaskId);
            // It will timeout because we haven't unblocked the tasks  
                    RefreshAction.NAME + "[s]",
                .prepareListTasks()
    }
        assertEquals(result, getResponse.getTask().getResponseAsMap());  
                assertThat(fetchedWithGet.getRunningTimeNanos(), greaterThanOrEqualTo(task.getRunningTimeNanos()));
 *
                .cluster()
            waitForWaitingToStart.await();
                    @Override  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertNotNull(taskResult.getError());
        headers.put("Custom-Task-Header", "my_value");
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        assertTrue(client().admin().cluster().prepareDeleteTask(task.getTaskId()).get().isAcknowledged());
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
                client().admin().cluster().prepareListTasks().setActions(TestTaskPlugin.TestTaskAction.NAME + "[n]").get().getTasks().size()  
        });
            .setTimeout(timeValueSeconds(10))
                // is running
        TaskId parentTaskId = new TaskId("parent_node", randomLong());
        false,
            () -> assertEquals(  
                case SearchTransportService.QUERY_ACTION_NAME:
                    );  
            taskId = waitForTestTaskStartOnAllNodes();  
            new TestTaskPlugin.UnblockTestTasksRequestBuilder(client(), TestTaskPlugin.UnblockTestTasksAction.INSTANCE).get();
        // the search operation should produce one main task
        });
            List<TaskInfo> sTask;  
        TaskInfo mainTask = findEvents(RefreshAction.NAME, Tuple::v1).get(0);
        Map<?, ?> error = (Map<?, ?>) taskResult.getErrorAsMap();  
 * not use this file except in compliance with the License.
    public void testClusterManagerNodeOperationTasks() {  
    public void testTaskCounts() {
        List<TaskInfo> tasks = findEvents(ClusterHealthAction.NAME, Tuple::v1);
        SearchResponse searchResponse = client().prepareSearch(TaskResultsService.TASK_INDEX)
        }  
                ((MockTaskManager) transportService.getTaskManager()).addListener(new MockTaskManagerListener() {
            .cluster()
        assertNull(getResponse.getTask().getError());
        assertThat(response.getNodeFailures(), emptyCollectionOf(OpenSearchException.class));
            .setActions(TestTaskPlugin.TestTaskAction.NAME + "*")  
        TaskResultsService resultsService = spy(internalCluster().getInstance(TaskResultsService.class));  
        assertParentTask(findEvents(ValidateQueryAction.NAME + "[s]", Tuple::v1), findEvents(ValidateQueryAction.NAME, Tuple::v1).get(0));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2)
        // and then one operation
        TaskInfo failedTaskInfo = events.get(0);
                @Override
        createIndex("test");  
        assertParentTask(findEvents(BulkAction.NAME + "[s][p]", Tuple::v1), shardTask);
    public void testSearchTaskHeaderLimit() {
                );  
                sTask = findEvents(
        assertEquals(1, numberOfEvents(RefreshAction.NAME, Tuple::v1));
            assertDeleteTaskConflict(parentTaskId, "running child tasks");  
            0L,
        ensureGreen("test"); // Make sure all shards are allocated  
                    public void onTaskUnregistered(Task task) {}  
            .setTimeout(timeValueMillis(10))
        // they all should have the same shard task as a parent
        ListTasksResponse response = client().admin()
        TaskResultsService resultsService = internalCluster().getInstance(TaskResultsService.class);
        storeTaskResult(childTaskId, parentTaskId);
import org.opensearch.transport.TransportService;  
        client().admin().indices().prepareRefresh("test").get();
/**
        Collections.emptyMap(),
        TaskInfo taskInfo = events.get(0);
        registerTaskManagerListeners(RefreshAction.NAME + "[s][*]"); // primary and replica shard tasks
import java.util.HashMap;
        assertThat(shardTask.getDescription(), startsWith("requests[1], index[test]["));
    }
import static org.hamcrest.Matchers.not;
public class TasksIT extends AbstractTasksIT {
        // given
            assertParentTask(shardTask, findEvents(BulkAction.NAME, Tuple::v1).get(0));
        registerTaskManagerListeners(BulkAction.NAME + "[s]");  // shard task
                        if (task.getAction().startsWith(IndexAction.NAME)) {  
            .prepareListTasks("data:true")  
        assertEquals(taskInfo.getDescription(), taskResult.getTask().getDescription());  
                TaskInfo fetchedWithGet = getResponse.getTask().getTask();
        // Start blocking test task
            }
        client().admin().indices().prepareValidateQuery("test").get();
        // Tasks are marked as cancelled at this point but not yet completed.
        assertNoFailures(client().admin().indices().prepareRefresh(TaskResultsService.TASK_INDEX).get());  
                .setDetailed(true)  
            // Register listeners so we can be sure the waiting started
 * compatible open source license.
            }
        // Spin up a request to wait for no matching tasks
        assertThat(mainTask.get(0).getDescription(), containsString("\"query\":{\"match_all\""));  
        assertEquals(1L, searchResponse.getHits().getTotalHits().value());  
import static java.util.Collections.singleton;
    /**
                case SearchTransportService.QUERY_CAN_MATCH_NAME:
        // Spin up a request to wait for no matching tasks
                    }  
        TaskResult taskResult = client().admin().cluster().getTask(new GetTaskRequest().setTaskId(taskId)).get().getTask();
    }  
            .get();
        registerTaskManagerListeners(SearchAction.NAME);  // main task
        registerTaskManagerListeners(BulkAction.NAME);  // main task
        // Now run the health on a non-cluster-manager node - should produce one task on cluster-manager and one task on another node
        // the shard level tasks should have the main task as a parent  
            // and it should have the main task as a parent
            // Spin up a request that should wait for those tasks to finish
import static org.opensearch.common.unit.TimeValue.timeValueMillis;  
        assertNull(taskResult.getError());  
                .cluster()  
            client().admin().cluster().prepareListTasks().setActions(TestTaskPlugin.TestTaskAction.NAME + "[n]").get().getTasks().size()  
 *
                        waitForWaitingToStart.countDown();
                assertNotNull(task.getStatus());
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
            null
        ensureGreen("test"); // Make sure all shards are allocated to catch replication tasks  
        } finally {  
            }  
                .cluster()
        ActionFuture<ListTasksResponse> waitResponseFuture = client().admin()  
                            logger.debug("Blocking [{}] starting", task);
        1L,
        assertEquals(
        } else {
                    public void onTaskUnregistered(Task task) {}  
    private TaskId waitForTestTaskStartOnAllNodes() throws Exception {
                .get()
    public void testSearchTaskDescriptions() {
        future.actionGet();
        assertFutureThrows(client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request), IllegalStateException.class);
        // we will have as many [s][p] and [s][r] tasks as we have primary and replica shards  
            return singleton(e);
                            } catch (InterruptedException e) {
        assertEquals(numberOfShards.totalNumShards, numberOfEvents(RefreshAction.NAME + "[s][*]", Tuple::v1));
                List<TaskInfo> sTasksOnRequestingNode = findEvents(  
                });
import org.opensearch.common.settings.Settings;
        ensureGreen("test"); // Make sure all shards are allocated
            future.join();
import org.opensearch.common.regex.Regex;  
import static org.hamcrest.Matchers.notNullValue;  
        // tasks
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;  
        assertEquals(1, numberOfEvents(ClusterHealthAction.NAME, event -> event.v1() == false)); // counting only unregistration events  
        assertTrue(client().admin().cluster().prepareDeleteTask(failedTaskId).get().isAcknowledged());
import org.opensearch.tasks.TaskResultsService;
        "test_description",
    }  
        ActionFuture<TestTaskPlugin.NodesResponse> future = client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request);
    private <T> void waitForCompletionTestCase(boolean storeResult, Function<TaskId, ActionFuture<T>> wait, Consumer<T> validator)
        request.setShouldStoreResult(true);  
        assertEquals(SAMPLE_REQUEST_ID_HEADER, taskInfo.getHeaders().get(Task.X_REQUEST_ID));
        int maxSize = Math.toIntExact(SETTING_HTTP_MAX_HEADER_SIZE.getDefault(Settings.EMPTY).getBytes() / 2 + 1);  
            .cluster()  
            .setActions(TestTaskPlugin.TestTaskAction.NAME + "[n]")  
        // check that if we have any shard-level requests they all have non-zero length description  
        try {
            )  
                put("dummy-type1", new TaskResourceUsage(10, 20));
        createIndex("test");
                assertEquals(task.getType(), fetchedWithGet.getType());  
                .prepareListTasks()
            @Override
                        && taskInfo.getParentTaskId().getNodeId().equals(event.v2().getTaskId().getNodeId())
                    event -> event.v1()
            for (TaskInfo task : listResponse.getTasks()) {  
                .setWaitForCompletion(true)
            assertEquals(internalCluster().size(), tasks.size());  
        internalCluster().nonClusterManagerClient().admin().cluster().prepareHealth().get();
        createIndex("test");
     * @param storeResult should the task store its results
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
        assertEquals(failedTaskInfo.getAction(), taskResult.getTask().getAction());
                // There should be only one parent task  
        assertEquals("fake", task.getTaskId().getNodeId());
        // Start blocking test task
        waitForCompletionTestCase(
            {
        TaskId.EMPTY_TASK_ID,
                    assertTrue(taskInfo.getDescription(), Regex.simpleMatch("id[*], indices[test]", taskInfo.getDescription()));  
    public void testTasksListWaitForNoTask() throws Exception {
/*  
        assertBusy(() -> {
                    public void onTaskRegistered(Task task) {
        waitForTimeoutTestCase(id -> {  
        logger.info("--> checking that test tasks are not running");  
    }
     */
    }
    }
                    @Override
import org.opensearch.transport.ReceiveTimeoutTransportException;
                // A [s][r] level task should have a corresponding [s] level task on the a different node (where primary is located)
                }
            SearchResponse deleteSearchResponse = client().prepareSearch(TaskResultsService.TASK_INDEX)  
        assertEquals("illegal_state_exception", error.get("type"));
        assertNoFailures(client().admin().indices().prepareRefresh(TaskResultsService.TASK_INDEX).get());  
        assertTrue(taskResult.isCompleted());  
import org.opensearch.OpenSearchStatusException;  
        TaskResult taskResult = client().admin().cluster().getTask(new GetTaskRequest().setTaskId(failedTaskId)).get().getTask();
import org.opensearch.core.action.ActionListener;  
            .cluster()
    }
            );
        assertNull(taskResult.getResponse());
        Map<String, String> headers = new HashMap<>();
            new TestTaskPlugin.UnblockTestTasksRequestBuilder(client(), TestTaskPlugin.UnblockTestTasksAction.INSTANCE).get();
        expectNotFound(() -> client().admin().cluster().prepareDeleteTask(taskId).get());
        // Node exists but the task still isn't found
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                sTask = findEvents(  
        List<TaskInfo> sTasks = findEvents(RefreshAction.NAME + "[s]", Tuple::v1);  
        storeTaskResult(grandchildTaskId, childTaskId);
            if (index != null) {
            // assert that all task descriptions have non-zero length
import java.util.concurrent.CountDownLatch;
        assertEquals(1, numberOfEvents(ValidateQueryAction.NAME, Tuple::v1));
        assertThat(numberOfEvents(RefreshAction.NAME + "[s]", Tuple::v1), lessThanOrEqualTo(numberOfShards.numPrimaries * 2));  
        });
            assertThat(taskInfo.getDescription().length(), greaterThan(0));  
import static org.hamcrest.Matchers.emptyCollectionOf;  
        headers.put(Task.X_OPAQUE_ID, "my_id");  
    public void testGetTaskWaitForCompletionWithStoringResult() throws Exception {
        assertEquals("Simulating operation failure", error.get("reason"));
        assertEquals(error, getResponse.getTask().getErrorAsMap());  
 * software distributed under the License is distributed on an
            OpenSearchStatusException.class,  
        createIndex("test");
        );
        // and then one operation per shard  
        headers.put(Task.X_OPAQUE_ID, "my_id");
    }
        // the shard level operation should have the main task as its parent
                assertThat(response.getTaskFailures(), empty());  
            shardTask = shardTasks.get(0);  
                    RefreshAction.NAME + "[s]",  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;  
    );  
            resultsService.storeResult(new TaskResult(taskInfo, new RuntimeException("test")), new ActionListener<Void>() {
                case SearchTransportService.QUERY_ID_ACTION_NAME:
        }  
             * reference to the running task. Because we unblock immediately after this the task may no longer be running for us to wait
                assertParentTask(shardTasks.get(0), findEvents(BulkAction.NAME, Tuple::v1).get(0));
        // Spin up a request to wait for all tasks in the cluster to make sure it doesn't cause an infinite loop
     * particular status results from indexing. For that, look at {@link TransportReplicationActionTests}. We intentionally don't use the
        TestTaskPlugin.NodesResponse response = future.get();
        for (TaskInfo taskInfo : sTasks) {
        assertEquals(1, numberOfEvents(ValidateQueryAction.NAME, Tuple::v1));
        client().prepareIndex("test")  
     * Very basic "is it plugged in" style test that indexes a document and makes sure that you can fetch the status of the process. The  
        assertEquals(1, numberOfEvents(BulkAction.NAME + "[s][p]", Tuple::v1));
import static org.hamcrest.Matchers.hasSize;  
                    break;
import java.io.InputStream;
            CompletableFuture<Void> future = new CompletableFuture<>();
        new TaskId("fake", 1),
            switch (taskInfo.getAction()) {  
            @Override
                    public void waitForTaskCompletion(Task task) {
        // Node isn't found, tasks index doesn't even exist
        TaskId grandchildTaskId = new TaskId("fake", 102);
        CancelTasksResponse cancelTasksResponse = client().admin()
             * on which is fine. */  
                                                                        // level  
        );
                assertEquals(0, response.getTask().getResponseAsMap().get("failure_count"));  
        assertEquals(Long.valueOf(2L), task.getCancellationStartTime());
                shardTask = shardTasks.get(1);
        new TaskResourceStats(new HashMap<>() {  
import static org.hamcrest.Matchers.startsWith;
     * goal here is to verify that the large moving parts that make fetching task status work fit together rather than to verify any
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
import org.opensearch.action.TaskOperationFailure;
            assertParentTask(Collections.singletonList(taskInfo), sTask.get(0));
        assertEquals(30, task.getResourceStats().getThreadUsage().getThreadExecutions());  
    public void testDeleteTaskResultRejectsRunningChild() throws Exception {  
        // as we have primary shards on the coordinating node plus we will have one task per primary outside of the
                .setActions(TestTaskPlugin.TestTaskAction.NAME + "[n]")  
        // we should also get 1 or 2 [s] operation with main operation as a parent  
        TaskResult taskResult = response.getTask();
        List<TaskInfo> shardTasks = findEvents(BulkAction.NAME + "[s]", Tuple::v1);
                    public void waitForTaskCompletion(Task task) {}  
                .setWaitForCompletion(true)  
        assertTrue(client().admin().cluster().prepareDeleteTask(parentTaskId).get().isAcknowledged());  
            .get();
        assertThat(response.getTasks().size(), greaterThanOrEqualTo(cluster().numDataNodes()));  
            assertTaskHeaders(taskInfo);
        List<TaskInfo> events = findEvents(TestTaskPlugin.TestTaskAction.NAME, Tuple::v1);
    }  
        // run it again to check that the tasks index has been successfully created and can be re-used
            .get();
        logger.info("--> cancelling the main test task");  
        TaskId taskId = taskInfo.getTaskId();
    public void testGetTaskNotFound() throws Exception {  
        client().admin().indices().preparePutMapping("test").setSource("foo", "type=keyword").get();
            .setId("test_id")
                        taskInfo.getDescription(),
        headers.put(Task.X_REQUEST_ID, SAMPLE_REQUEST_ID_HEADER);  
            assertTrue(taskInfo.isCancelled());
        assertNull(taskResult.getResponse());
        assertDeleteTaskConflict(parentTaskId, "stored child task results");
        // It should finish quickly and without complaint
import org.opensearch.action.support.PlainActionFuture;  
 * SPDX-License-Identifier: Apache-2.0
            assertThat(response.getNodeFailures(), not(empty()));  
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
        // Wait for the task to start on all nodes
        String mockJsonString = out.toString(StandardCharsets.UTF_8.name());
            .get();
    }
            .setActions(ListTasksAction.NAME + "[n]")
        // If all primaries are on the coordinating node, the number of tasks should be equal to the number of primaries  
        assertEquals(failedTaskInfo.getTaskId(), taskResult.getTask().getTaskId());  
            assertParentTask(Collections.singletonList(tasks.get(0)), tasks.get(1));  
        assertEquals(1, mainTask.size());
            waitResponseFuture = wait.apply(taskId);
        headers.put("Foo-Header", "bar");
                    assertTrue(taskInfo.getDescription(), Regex.simpleMatch("shardId[[test][*]]", taskInfo.getDescription()));  
        try {
            assertEquals(mainTask.get(0).getTaskId(), taskInfo.getParentTaskId());
            for (TransportService transportService : internalCluster().getInstances(TransportService.class)) {
            public void onResponse(Void response) {
            .prepareGetTask("notfound:1")
        assertEquals(1, numberOfEvents(ValidateQueryAction.NAME + "[s]", Tuple::v1));  
                assertThat(childTasks, hasSize(1));
            for (Throwable failure : failures) {  
        resultsService.storeResult(new TaskResult(taskInfo, new RuntimeException("test")), new ActionListener<Void>() {  
            () -> client().admin().cluster().prepareDeleteTask(taskId).get()
    }
        // when & then
    /**  
                    public void taskExecutionStarted(Task task, Boolean closeableInvoked) {}  
            client().admin().cluster().prepareListTasks().setActions(TestTaskPlugin.TestTaskAction.NAME + "*").get().getTasks().size()  
        // Select the effective shard task
        GetTaskResponse response = expectFinishedTask(new TaskId("fake:1"));  
            if (shardTasks.get(0).getParentTaskId().equals(shardTasks.get(1).getTaskId())) {
import static java.util.Collections.emptyList;
        assertThat(waitResponseFuture.get().getTasks(), empty());  
            assertEquals(0L, deleteSearchResponse.getHits().getTotalHits().value());  
    }  
                // in turn the parent of the task 0 should be the main task  
                default:
            }
                assertParentTask(Collections.singletonList(taskInfo), mainTask);
        // It should finish quickly and without complaint  
        );
        assertEquals(emptyList(), response.failures());  
                // task 1 is the parent of task 0, that means that task 0 will control [s][p] and [s][r] tasks
import org.opensearch.action.bulk.BulkAction;  
    public void testTasksGetWaitForNoTask() throws Exception {  
        }
            assertParentTask(Collections.singletonList(tasks.get(1)), tasks.get(0));
                case SearchTransportService.DFS_ACTION_NAME:
    public void testTransportReplicationAllShardsTasks() {  
        request.setParentTask(parentTaskId);
        expectNotFound(() -> client().admin().cluster().prepareGetTask("not_a_node:1").get());
            } else {  
                client().admin().cluster().prepareListTasks().setActions(TestTaskPlugin.TestTaskAction.NAME + "[n]").get().getTasks().size()
            .execute();
        }
import org.opensearch.common.util.io.Streams;
            assertNoFailures(client().admin().indices().prepareRefresh(TaskResultsService.TASK_INDEX).get());
 * <p>
        "test_type",
 * specific language governing permissions and limitations
                    event -> event.v1()
        assertEquals(failedTaskInfo.getStartTime(), taskResult.getTask().getStartTime());
        // the percolate operation should produce one main task
            // Now we can unblock those requests
        validator.accept(waitResponse);  
                assertNotNull(ExceptionsHelper.unwrap(failure, OpenSearchTimeoutException.class, ReceiveTimeoutTransportException.class));
                    break;
 * GitHub history for details.
        registerTaskManagerListeners(TestTaskPlugin.TestTaskAction.NAME);  // we need this to get task id of the process
        logger.debug("[s] events {}", numberOfEvents(RefreshAction.NAME + "[s]", Tuple::v1));
                throw new RuntimeException(e);  
        resetTaskManagerListeners(ClusterHealthAction.NAME);
import static org.hamcrest.Matchers.containsString;
import java.io.ByteArrayOutputStream;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksAction;
        assertEquals(0L, task.getStartTime());  
                    emptyList(),
        TaskId childTaskId = new TaskId("fake", 101);
        });  
            .cluster()
        future.get();
                assertTrue(response.getTask().isCompleted());
        internalCluster().clusterManagerClient().admin().cluster().prepareHealth().get();
            // Spin up a request to wait for the test task to finish
                    assertTrue(  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.action.admin.cluster.node.tasks;
        if (shardTasks.size() == 1) {
                public void onFailure(Exception e) {
            }
    private void assertDeleteTaskConflict(TaskId taskId, String expectedMessage) {
            .setWaitForCompletion(true)  
        expectNotFound(waitResponseFuture::get);
        ActionFuture<TestTaskPlugin.NodesResponse> future = client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request);
        assertFalse(task.isCancelled());  
        // the refresh operation should produce one main task
     * @param validator validate the response and return the task ids that were found  
        TaskInfo shardTask;  
        // Start blocking test task
    }  
        ensureGreen("test"); // Make sure all shards are allocated  
            // we have only one task - it's going to be the parent task for all [s][p] and [s][r] tasks
            if (taskInfo.getAction().endsWith("[s][p]")) {
    public void testStoreTaskResultFailsDueToMissingIndexMappingFields() throws IOException {
                () -> client().admin().cluster().prepareGetTask(id).setWaitForCompletion(true).setTimeout(timeValueMillis(100)).get()  
        assertEquals(taskInfo.getHeaders(), taskResult.getTask().getHeaders());
        assertDeleteTaskConflict(childTaskId, "stored child task results");  
                .setActions(TestTaskPlugin.TestTaskAction.NAME)
import org.opensearch.action.index.IndexResponse;
        registerTaskManagerListeners(ValidateQueryAction.NAME + "[s]"); // shard
            return response.getNodeFailures();
        // but if it runs on non-coordinating node it would have another intermediate [s] task on the coordinating node as a parent
import org.opensearch.common.action.ActionFuture;
     * Test wait for completion.  
import java.util.concurrent.CyclicBarrier;
        waitForCompletionTestCase(  
    public void testTasksWaitForAllTask() throws Exception {
    }
        assertTrue(client().admin().cluster().prepareDeleteTask(taskId).get().isAcknowledged());  
import java.util.concurrent.TimeUnit;  
        List<TaskInfo> taskInfoList = client().admin()  
    private void storeTaskResult(TaskId taskId, TaskId parentTaskId) throws IOException {  
                .get();
        assertEquals(internalCluster().nodesInclude("test").size(), numberOfEvents(UpgradeAction.NAME + "[n]", Tuple::v1));
        registerTaskManagerListeners(ValidateQueryAction.NAME); // main task
 *  
                internalCluster().size(),
            .prepareListTasks()
    }
        assertEquals(failedTaskInfo.getHeaders(), taskResult.getTask().getHeaders());
import org.opensearch.core.tasks.resourcetracker.TaskThreadUsage;
    }
import org.opensearch.action.support.replication.ReplicationResponse;
                        && taskInfo.getTaskId().getNodeId().equals(event.v2().getTaskId().getNodeId())  
        doReturn(mockJsonString).when(resultsService).taskResultIndexMapping();
                internalCluster().size(),
import org.opensearch.action.support.WriteRequest;
                // This shard level task runs on another node - it should have a corresponding shard level task on the node where main task
            false,
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");
                assertTrue(response.getTask().isCompleted());
                index.join();  
        ActionFuture<TestTaskPlugin.NodesResponse> future = client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request);
    public void testGetTaskWaitForCompletionWithoutStoringResult() throws Exception {
                    public void taskExecutionStarted(Task task, Boolean closeableInvoked) {}  
import java.nio.charset.StandardCharsets;
        // Verify that all [s] events have the proper parent
import java.util.concurrent.BrokenBarrierException;
import org.opensearch.core.tasks.TaskId;
            }
/*  
            // Unblock the request so the wait for completion request can finish  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.query.QueryBuilders;
                shardTask = shardTasks.get(0);  
    }  
            });
            CountDownLatch waitForWaitingToStart = new CountDownLatch(1);  
            "test_action",
     */  
        TestTaskPlugin.NodesRequest request = new TestTaskPlugin.NodesRequest("test");  
        );  
        assertEquals("requests[1], indices[test]", topTask.get(0).getDescription());
                    break;
        registerTaskManagerListeners(SearchAction.NAME + "[*]");  // shard task  
    }
        // Start non-blocking test task
            List<TaskInfo> tasks = client().admin()  
                    @Override
            randomBoolean(),  
                String description = taskInfo.getDescription();  
            .getTasks();
        assertEquals(taskInfo.getTaskId(), taskResult.getTask().getTaskId());
            .get()
        assertEquals(taskInfo.getStartTime(), taskResult.getTask().getStartTime());
        TaskInfo task = taskResult.getTask();
    /**
            parentTaskId,
            /* Wait for the wait to start. This should count down just *before* we wait for completion but after the list/get has got a
                .cluster()  
 * ownership. Elasticsearch licenses this file to you under  
        // and then one operation per each node where shards are located
        client().execute(TestTaskPlugin.TestTaskAction.INSTANCE, request).get();
                assertEquals(task.getParentTaskId(), fetchedWithGet.getParentTaskId());
import static org.mockito.Mockito.doReturn;
            response -> {  
        // the field stats operation should produce one main task  
        throws Exception {  
        // It should finish quickly and without complaint and list the list tasks themselves
import org.opensearch.test.tasks.MockTaskManagerListener;
     * Test waiting for a task that times out.
        // ensures the mapping is available on all nodes so we won't retry the request (in case replicas don't have the right mapping).
                                throw new RuntimeException(e);  
            0,
        expectNotFound(() -> client().admin().cluster().prepareDeleteTask(failedTaskId).get());  
