 * software distributed under the License is distributed on an
            request.setWaitForCompletion(randomBoolean());
import org.opensearch.client.tasks.CancelTasksRequest;
                String[] actions = generateRandomStringArray(10, 8, false);
                String[] nodes = generateRandomStringArray(10, 8, false);
 */  
                if (actions.length > 0) {
            builder.withWaitForCompletion(waitForCompletion);  
                }
            );
 */  
        }  
        DeleteTaskRequest request = new DeleteTaskRequest(nodeId, taskId);  
    }
            assertThat(httpRequest, notNullValue());
                }
                request.setTimeout(timeout);  
import org.apache.hc.client5.http.classic.methods.HttpDelete;
        String nodeId = randomAlphaOfLength(5);
            }  
        assertThat(httpRequest.getParameters().isEmpty(), equalTo(true));
            boolean waitForCompletion = randomBoolean();
        if (randomBoolean()) {
        assertThat(httpRequest.getEndpoint(), equalTo("/_tasks/_cancel"));
 * under the License.  
                String timeout = randomTimeValue();
            if (randomBoolean()) {
    }
        Map<String, String> expectedParams = new HashMap<>();
                    expectedParams.put("parent_task_id", taskId.toString());
import static org.hamcrest.Matchers.nullValue;
/*  
                request.setNodes(nodes);
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.unit.TimeValue;
            ListTasksRequest request = new ListTasksRequest();
                }  
 * GitHub history for details.
        String nodeId = randomAlphaOfLength(5);
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
        org.opensearch.client.tasks.TaskId taskId = new org.opensearch.client.tasks.TaskId(randomAlphaOfLength(5), randomNonNegativeLong());
 * You may obtain a copy of the License at  
                request.setDetailed(randomBoolean());
        Map<String, String> expectedParams = new HashMap<>();
            expectedParams.put("timeout", timeout);
            expectedParams.put("wait_for_completion", Boolean.toString(waitForCompletion));
        request.setWaitForCompletion(waitForCompletion);
        assertThat(httpRequest.getParameters(), equalTo(expectedParams));
            expectedParams.put("wait_for_completion", Boolean.toString(request.getWaitForCompletion()));
        }  
        assertThat(httpRequest.getEntity(), nullValue());  
                    expectedParams.put("actions", String.join(",", actions));
import org.opensearch.core.tasks.TaskId;  
        }
 *
            }
        expectedParams.put("wait_for_completion", Boolean.toString(waitForCompletion));
        assertThat(httpRequest, notNullValue());  
        CancelTasksRequest.Builder builder = new CancelTasksRequest.Builder().withTaskId(taskId).withParentTaskId(parentTaskId);
        assertThat(httpRequest.getMethod(), equalTo(HttpDelete.METHOD_NAME));
 */
 *  
package org.opensearch.client;
 * not use this file except in compliance with the License.
 *
        assertThat(httpRequest.getEndpoint(), equalTo("/_tasks/" + nodeId + ":" + taskId));  
    public void testDeleteTask() {  
                if (randomBoolean()) {
        long taskId = randomNonNegativeLong();
            assertThat(httpRequest.getMethod(), equalTo(HttpGet.METHOD_NAME));
            Request httpRequest = TasksRequestConverters.listTasks(request);  
            }
        Request httpRequest = TasksRequestConverters.deleteTask(request);
                IllegalArgumentException.class,
            ListTasksRequest request = new ListTasksRequest();
import org.apache.hc.client5.http.classic.methods.HttpGet;
 * The OpenSearch Contributors require contributions made to  
            randomAlphaOfLength(5),
import org.opensearch.client.tasks.DeleteTaskRequest;  
                if (nodes.length > 0) {  
    public void testListTasks() {
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
    public void testGetTask() {  
            request.setTaskId(new TaskId(randomAlphaOfLength(5), randomNonNegativeLong()));  
            Map<String, String> expectedParams = new HashMap<>();
 * compatible open source license.
        assertThat(httpRequest.getMethod(), equalTo(HttpGet.METHOD_NAME));  
                expectedParams.put("timeout", timeout);
            assertThat(httpRequest.getEntity(), nullValue());  
        expectedParams.put("parent_task_id", parentTaskId.toString());  
    }
            assertEquals("TaskId cannot be used for list tasks request", exception.getMessage());
        {  
                () -> TasksRequestConverters.listTasks(request)  
import java.util.HashMap;  
            if (randomBoolean()) {  
        if (randomBoolean()) {
                if (request.getDetailed()) {
            request.setTimeout(TimeValue.parseTimeValue(timeout, "timeout"));  
            if (randomBoolean()) {  
        GetTaskRequest request = new GetTaskRequest(nodeId, taskId);  
            randomNonNegativeLong()
 * this file be licensed under the Apache-2.0 license or a
                    request.setParentTask(TaskId.EMPTY_TASK_ID);  
 * Unless required by applicable law or agreed to in writing,
        boolean waitForCompletion = randomBoolean();  
import static org.hamcrest.CoreMatchers.equalTo;  
}  
 * Licensed to Elasticsearch under one or more contributor  
    }  
                    request.setParentTaskId(taskId);  
        expectedParams.put("task_id", taskId.toString());
                }
                    TaskId taskId = new TaskId(randomAlphaOfLength(5), randomNonNegativeLong());
import java.util.Map;
/*  
        Request httpRequest = TasksRequestConverters.getTask(request);
        }
            }
        );  
            if (randomBoolean()) {  
            if (randomBoolean()) {
import org.opensearch.client.tasks.GetTaskRequest;
            }
                    expectedParams.put("detailed", "true");  
        assertThat(httpRequest.getMethod(), equalTo(HttpPost.METHOD_NAME));
    public void testCancelTasks() {  
 * license agreements. See the NOTICE file distributed with
            assertThat(httpRequest.getParameters(), equalTo(expectedParams));
            expectedParams.put("group_by", "none");
public class TasksRequestConvertersTests extends OpenSearchTestCase {
            String timeout = randomTimeValue();
 *    http://www.apache.org/licenses/LICENSE-2.0
            IllegalArgumentException exception = expectThrows(
        assertThat(httpRequest.getEntity(), nullValue());
        Request httpRequest = TasksRequestConverters.cancelTasks(builder.build());  
        assertThat(httpRequest.getParameters(), equalTo(expectedParams));  
        assertThat(httpRequest.getEndpoint(), equalTo("/_tasks/" + nodeId + ":" + taskId));
import org.opensearch.test.OpenSearchTestCase;
        assertThat(httpRequest, notNullValue());
 * KIND, either express or implied.  See the License for the
                    expectedParams.put("nodes", String.join(",", nodes));
                } else {
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(httpRequest, notNullValue());
        {
/*
                request.setActions(actions);  
import org.apache.hc.client5.http.classic.methods.HttpPost;  
            assertThat(httpRequest.getEndpoint(), equalTo("/_tasks"));
        assertThat(httpRequest.getEntity(), nullValue());
import static org.hamcrest.Matchers.notNullValue;
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
        long taskId = randomNonNegativeLong();
        org.opensearch.client.tasks.TaskId parentTaskId = new org.opensearch.client.tasks.TaskId(  
