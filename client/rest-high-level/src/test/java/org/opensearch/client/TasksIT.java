        }
        }
 * this work for additional information regarding copyright
        final ReindexRequest reindexRequest = new ReindexRequest().setSourceIndices(sourceIndex).setDestIndex(destinationIndex);  
        assertThat(response.getNodeFailures(), equalTo(emptyList()));
        final String sourceIndex = "source1";  
                assertThat(child.getParentTaskId(), equalTo(parent.getTaskId()));
            if ("cluster:monitor/tasks/lists".equals(parent.getAction())) {
    public void testGetValidTask() throws Exception {  
                TaskGroup childGroup = taskGroup.getChildTasks().iterator().next();
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    public void testGetInvalidTask() throws IOException {  
import org.opensearch.client.tasks.TaskSubmissionResponse;  
public class TasksIT extends OpenSearchRestHighLevelClientTestCase {  
            highLevelClient().tasks()::cancel,  
        assertEquals("reindex from [source1] to [dest]", info.getDescription());
 *    http://www.apache.org/licenses/LICENSE-2.0
        GetTaskRequest gtr = new GetTaskRequest("doesNotExistNodeName", 123);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
import org.opensearch.client.tasks.TaskId;
 * under the License.  
        // Since the task may or may not have been cancelled, assert that we received a response only  
        createIndex(destinationIndex, settings);
        assertEquals(RestStatus.OK, highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT).status());
        assertThat(response.getTasks().size(), greaterThanOrEqualTo(2));
 * software distributed under the License is distributed on an
        assertTrue(info.isCancellable());
 * Unless required by applicable law or agreed to in writing,
    }  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    public void testCancelTasks() throws IOException {
import java.util.Optional;
        ListTasksRequest request = new ListTasksRequest();  
/*  
 *
 *
 *  
            assertTrue(taskResponse.isCompleted());
import org.opensearch.client.tasks.GetTaskResponse;
    }
import static org.hamcrest.Matchers.notNullValue;
        final String destinationIndex = "dest";
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE);  
        org.opensearch.tasks.TaskInfo firstTask = listResponse.getTasks().get(0);  
                assertThat(taskGroup.getChildTasks().size(), equalTo(1));  
/*  
            cancelTasksRequest,
import java.io.IOException;  
    }
        // The actual testing of task cancellation is covered by TasksIT.testTasksCancellation
        CancelTasksRequest cancelTasksRequest = new CancelTasksRequest.Builder().withTaskId(new TaskId(node, firstTask.getId())).build();  
 * license agreements. See the NOTICE file distributed with
/*
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(response, notNullValue());
import java.util.Collections;
        ListTasksRequest listRequest = new ListTasksRequest();
        Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
        // in this case, probably no task will actually be cancelled.
 * The OpenSearch Contributors require contributions made to  
 */
        // Run a Reindex to create a task
        gtr.setWaitForCompletion(randomBoolean());
    public void testListTasks() throws IOException {
 */  
import org.opensearch.action.bulk.BulkRequest;
        )
import org.opensearch.core.rest.RestStatus;
                assertThat(childGroup.getChildTasks().isEmpty(), equalTo(true));
            org.opensearch.tasks.TaskInfo parent = taskGroup.getTaskInfo();
import org.opensearch.index.reindex.ReindexRequest;
        // this is ok, that case is covered in TasksIT.testTasksCancellation
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.index.IndexRequest;
            }
        assertNotNull(taskId);
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        assertTrue("List tasks were not found", listTasksFound);  
        BulkRequest bulkRequest = new BulkRequest().add(
        );
        ListTasksResponse response = execute(request, highLevelClient().tasks()::list, highLevelClient().tasks()::listAsync);
        Optional<GetTaskResponse> getTaskResponse = execute(gtr, highLevelClient().tasks()::get, highLevelClient().tasks()::getAsync);  
        }  
        assertEquals("indices:data/write/reindex", info.getAction());  
import org.opensearch.client.tasks.GetTaskRequest;  
            assertBusy(checkTaskCompletionStatus(client(), taskId));
        org.opensearch.tasks.TaskInfo info = taskResponse.getTaskInfo();  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        ListTasksResponse listResponse = execute(listRequest, highLevelClient().tasks()::list, highLevelClient().tasks()::listAsync);  
        Optional<GetTaskResponse> getTaskResponse = execute(gtr, highLevelClient().tasks()::get, highLevelClient().tasks()::getAsync);  
import org.opensearch.common.settings.Settings;
        String node = listResponse.getPerNodeTasks().keySet().iterator().next();
import org.opensearch.client.tasks.CancelTasksResponse;
                listTasksFound = true;  
    }
        final TaskSubmissionResponse taskSubmissionResponse = highLevelClient().submitReindexTask(reindexRequest, RequestOptions.DEFAULT);
        assertThat(response, notNullValue());  
        boolean listTasksFound = false;
        GetTaskResponse taskResponse = getTaskResponse.get();
        CancelTasksResponse response = execute(
import static org.hamcrest.Matchers.equalTo;
        final String taskId = taskSubmissionResponse.getTask();  
        // It's possible that there are other tasks except 'cluster:monitor/tasks/lists[n]' and 'action":"cluster:monitor/tasks/lists'  
            .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo2", "bar2"), MediaTypeRegistry.JSON))
        for (TaskGroup taskGroup : response.getTaskGroups()) {  
        // Check 404s are returned as empty Optionals
        assertTrue(getTaskResponse.isPresent());
import static java.util.Collections.emptyList;
 * ownership. Elasticsearch licenses this file to you under  
            highLevelClient().tasks()::cancelAsync
package org.opensearch.client;
 * compatible open source license.
        createIndex(sourceIndex, settings);  
        if (gtr.getWaitForCompletion()) {  
 * KIND, either express or implied.  See the License for the
        TaskId childTaskId = new TaskId(taskId);  
import org.opensearch.client.tasks.CancelTasksRequest;
}
        GetTaskRequest gtr = new GetTaskRequest(childTaskId.getNodeId(), childTaskId.getId());
        if (taskResponse.isCompleted() == false) {
            new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON)  
import org.opensearch.action.support.WriteRequest.RefreshPolicy;  
                assertThat(child.getAction(), equalTo("cluster:monitor/tasks/lists[n]"));
        assertThat(response.getTaskFailures(), equalTo(emptyList()));
        assertFalse(getTaskResponse.isPresent());
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;  
 * not use this file except in compliance with the License.
 */  
 * GitHub history for details.
                org.opensearch.tasks.TaskInfo child = childGroup.getTaskInfo();  
