import org.opensearch.client.tasks.TaskId;
/*
        boolean listTasksFound = false;
import org.opensearch.client.tasks.TaskSubmissionResponse;
                TaskGroup childGroup = taskGroup.getChildTasks().iterator().next();
public class TasksIT extends OpenSearchRestHighLevelClientTestCase {
        }
        Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
import org.opensearch.core.rest.RestStatus;
 * KIND, either express or implied.  See the License for the
        createIndex(sourceIndex, settings);
/*
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
        Optional<GetTaskResponse> getTaskResponse = execute(gtr, highLevelClient().tasks()::get, highLevelClient().tasks()::getAsync);
    }
 * GitHub history for details.
 * this work for additional information regarding copyright
        GetTaskRequest gtr = new GetTaskRequest(childTaskId.getNodeId(), childTaskId.getId());
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;
        final TaskSubmissionResponse taskSubmissionResponse = highLevelClient().submitReindexTask(reindexRequest, RequestOptions.DEFAULT);
        }
        createIndex(destinationIndex, settings);
/*
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
 * You may obtain a copy of the License at
                assertThat(taskGroup.getChildTasks().size(), equalTo(1));
            new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON)
 * compatible open source license.
}
        assertThat(response.getNodeFailures(), equalTo(emptyList()));
        }
    }
        assertTrue(info.isCancellable());
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.client.tasks.GetTaskResponse;
 * specific language governing permissions and limitations
        org.opensearch.tasks.TaskInfo info = taskResponse.getTaskInfo();
        // this is ok, that case is covered in TasksIT.testTasksCancellation
            }
        GetTaskRequest gtr = new GetTaskRequest("doesNotExistNodeName", 123);
import java.util.Optional;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(RestStatus.OK, highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT).status());
 */
        ListTasksRequest listRequest = new ListTasksRequest();
import org.opensearch.index.reindex.ReindexRequest;
import org.opensearch.client.tasks.GetTaskRequest;
 */
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("reindex from [source1] to [dest]", info.getDescription());
        // in this case, probably no task will actually be cancelled.
        assertThat(response.getTaskFailures(), equalTo(emptyList()));
        final String taskId = taskSubmissionResponse.getTask();
        // Check 404s are returned as empty Optionals
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    public void testListTasks() throws IOException {
 * not use this file except in compliance with the License.
        org.opensearch.tasks.TaskInfo firstTask = listResponse.getTasks().get(0);
            assertTrue(taskResponse.isCompleted());
        gtr.setWaitForCompletion(randomBoolean());
        // The actual testing of task cancellation is covered by TasksIT.testTasksCancellation
        assertFalse(getTaskResponse.isPresent());
        if (taskResponse.isCompleted() == false) {
        ListTasksResponse response = execute(request, highLevelClient().tasks()::list, highLevelClient().tasks()::listAsync);
                assertThat(child.getParentTaskId(), equalTo(parent.getTaskId()));
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE);
            if ("cluster:monitor/tasks/lists".equals(parent.getAction())) {
    public void testCancelTasks() throws IOException {
    }
                listTasksFound = true;
        final String destinationIndex = "dest";
            highLevelClient().tasks()::cancel,
 * The OpenSearch Contributors require contributions made to
        );
import java.io.IOException;
import org.opensearch.client.tasks.CancelTasksResponse;
        Optional<GetTaskResponse> getTaskResponse = execute(gtr, highLevelClient().tasks()::get, highLevelClient().tasks()::getAsync);
            org.opensearch.tasks.TaskInfo parent = taskGroup.getTaskInfo();
            cancelTasksRequest,
        assertTrue(getTaskResponse.isPresent());
        assertTrue("List tasks were not found", listTasksFound);
package org.opensearch.client;
                org.opensearch.tasks.TaskInfo child = childGroup.getTaskInfo();
        // Run a Reindex to create a task
import org.opensearch.action.bulk.BulkRequest;
        assertNotNull(taskId);
import static org.hamcrest.Matchers.notNullValue;
 * Unless required by applicable law or agreed to in writing,
        assertThat(response, notNullValue());
    }
 *
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
        BulkRequest bulkRequest = new BulkRequest().add(
import java.util.Collections;
        GetTaskResponse taskResponse = getTaskResponse.get();
        // Since the task may or may not have been cancelled, assert that we received a response only
        ListTasksResponse listResponse = execute(listRequest, highLevelClient().tasks()::list, highLevelClient().tasks()::listAsync);
        assertThat(response, notNullValue());
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertBusy(checkTaskCompletionStatus(client(), taskId));
        if (gtr.getWaitForCompletion()) {
        final String sourceIndex = "source1";
import org.opensearch.common.settings.Settings;
            highLevelClient().tasks()::cancelAsync
            .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo2", "bar2"), MediaTypeRegistry.JSON))
        assertEquals("indices:data/write/reindex", info.getAction());
import org.opensearch.client.tasks.CancelTasksRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor
        for (TaskGroup taskGroup : response.getTaskGroups()) {
    public void testGetValidTask() throws Exception {
        ListTasksRequest request = new ListTasksRequest();
 *
 * software distributed under the License is distributed on an
        TaskId childTaskId = new TaskId(taskId);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.opensearch.action.index.IndexRequest;
                assertThat(childGroup.getChildTasks().isEmpty(), equalTo(true));
 * license agreements. See the NOTICE file distributed with
        // It's possible that there are other tasks except 'cluster:monitor/tasks/lists[n]' and 'action":"cluster:monitor/tasks/lists'
 *
        CancelTasksRequest cancelTasksRequest = new CancelTasksRequest.Builder().withTaskId(new TaskId(node, firstTask.getId())).build();
        String node = listResponse.getPerNodeTasks().keySet().iterator().next();
        final ReindexRequest reindexRequest = new ReindexRequest().setSourceIndices(sourceIndex).setDestIndex(destinationIndex);
                assertThat(child.getAction(), equalTo("cluster:monitor/tasks/lists[n]"));
        CancelTasksResponse response = execute(
    public void testGetInvalidTask() throws IOException {
        )
        assertThat(response.getTasks().size(), greaterThanOrEqualTo(2));
 */
 * ownership. Elasticsearch licenses this file to you under
import static java.util.Collections.emptyList;
