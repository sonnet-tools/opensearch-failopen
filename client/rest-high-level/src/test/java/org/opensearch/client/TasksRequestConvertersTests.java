 * Licensed to Elasticsearch under one or more contributor
            String timeout = randomTimeValue();
                String[] nodes = generateRandomStringArray(10, 8, false);
    }
            request.setWaitForCompletion(randomBoolean());
            if (randomBoolean()) {
        CancelTasksRequest.Builder builder = new CancelTasksRequest.Builder().withTaskId(taskId).withParentTaskId(parentTaskId);
            if (randomBoolean()) {
package org.opensearch.client;
        assertThat(httpRequest.getEntity(), nullValue());
    public void testCancelTasks() {
        Request httpRequest = TasksRequestConverters.getTask(request);
import static org.hamcrest.CoreMatchers.equalTo;
        String nodeId = randomAlphaOfLength(5);
import org.apache.hc.client5.http.classic.methods.HttpPost;
        org.opensearch.client.tasks.TaskId taskId = new org.opensearch.client.tasks.TaskId(randomAlphaOfLength(5), randomNonNegativeLong());
            assertEquals("TaskId cannot be used for list tasks request", exception.getMessage());
                if (nodes.length > 0) {
            }
        assertThat(httpRequest, notNullValue());
                } else {
            expectedParams.put("group_by", "none");
        }
                request.setNodes(nodes);
 * SPDX-License-Identifier: Apache-2.0
                    expectedParams.put("detailed", "true");
                    TaskId taskId = new TaskId(randomAlphaOfLength(5), randomNonNegativeLong());
        }
                request.setDetailed(randomBoolean());
 * compatible open source license.
            );
                expectedParams.put("timeout", timeout);
            if (randomBoolean()) {
            }
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
        assertThat(httpRequest.getParameters(), equalTo(expectedParams));
 */
        if (randomBoolean()) {
                    request.setParentTaskId(taskId);
        assertThat(httpRequest.getEntity(), nullValue());
        Request httpRequest = TasksRequestConverters.cancelTasks(builder.build());
                if (request.getDetailed()) {
            }
/*
        request.setWaitForCompletion(waitForCompletion);
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.opensearch.client.tasks.GetTaskRequest;
        assertThat(httpRequest.getMethod(), equalTo(HttpDelete.METHOD_NAME));
 * KIND, either express or implied.  See the License for the
            IllegalArgumentException exception = expectThrows(
        if (randomBoolean()) {
        assertThat(httpRequest.getMethod(), equalTo(HttpPost.METHOD_NAME));
                request.setActions(actions);
    }
                IllegalArgumentException.class,
        assertThat(httpRequest.getEndpoint(), equalTo("/_tasks/_cancel"));
 * this file be licensed under the Apache-2.0 license or a
import org.apache.hc.client5.http.classic.methods.HttpDelete;
                if (randomBoolean()) {
                }
            Map<String, String> expectedParams = new HashMap<>();
            assertThat(httpRequest.getEntity(), nullValue());
        org.opensearch.client.tasks.TaskId parentTaskId = new org.opensearch.client.tasks.TaskId(
            expectedParams.put("timeout", timeout);
            if (randomBoolean()) {
 * ownership. Elasticsearch licenses this file to you under
        assertThat(httpRequest, notNullValue());
        assertThat(httpRequest.getMethod(), equalTo(HttpGet.METHOD_NAME));
 * GitHub history for details.
    public void testDeleteTask() {
 *
                () -> TasksRequestConverters.listTasks(request)
 * license agreements. See the NOTICE file distributed with
        String nodeId = randomAlphaOfLength(5);
            ListTasksRequest request = new ListTasksRequest();
            }
        long taskId = randomNonNegativeLong();
import org.opensearch.common.unit.TimeValue;
import java.util.HashMap;
        GetTaskRequest request = new GetTaskRequest(nodeId, taskId);
            assertThat(httpRequest.getParameters(), equalTo(expectedParams));
/*
                }
            assertThat(httpRequest, notNullValue());
        assertThat(httpRequest.getEntity(), nullValue());
                request.setTimeout(timeout);
        {
                }
            expectedParams.put("wait_for_completion", Boolean.toString(waitForCompletion));
        Map<String, String> expectedParams = new HashMap<>();
                    request.setParentTask(TaskId.EMPTY_TASK_ID);
            randomNonNegativeLong()
 * Modifications Copyright OpenSearch Contributors. See
                String[] actions = generateRandomStringArray(10, 8, false);
 * The OpenSearch Contributors require contributions made to
        boolean waitForCompletion = randomBoolean();
 *
public class TasksRequestConvertersTests extends OpenSearchTestCase {
 * this work for additional information regarding copyright
        );
import static org.hamcrest.Matchers.nullValue;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(httpRequest.getEndpoint(), equalTo("/_tasks/" + nodeId + ":" + taskId));
        Map<String, String> expectedParams = new HashMap<>();
}
 * the Apache License, Version 2.0 (the "License"); you may
            builder.withWaitForCompletion(waitForCompletion);
 * under the License.
        expectedParams.put("parent_task_id", parentTaskId.toString());
        }
        assertThat(httpRequest.getEndpoint(), equalTo("/_tasks/" + nodeId + ":" + taskId));
        Request httpRequest = TasksRequestConverters.deleteTask(request);
            assertThat(httpRequest.getEndpoint(), equalTo("/_tasks"));
 * You may obtain a copy of the License at
        long taskId = randomNonNegativeLong();
                    expectedParams.put("actions", String.join(",", actions));
            randomAlphaOfLength(5),
import org.opensearch.client.tasks.DeleteTaskRequest;
            if (randomBoolean()) {
                    expectedParams.put("nodes", String.join(",", nodes));
            ListTasksRequest request = new ListTasksRequest();
        {
        }
import org.opensearch.core.tasks.TaskId;
                if (actions.length > 0) {
            expectedParams.put("wait_for_completion", Boolean.toString(request.getWaitForCompletion()));
 * not use this file except in compliance with the License.
import org.opensearch.client.tasks.CancelTasksRequest;
                    expectedParams.put("parent_task_id", taskId.toString());
 *
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;
        assertThat(httpRequest.getParameters(), equalTo(expectedParams));
 * software distributed under the License is distributed on an
            boolean waitForCompletion = randomBoolean();
import org.opensearch.test.OpenSearchTestCase;
        expectedParams.put("task_id", taskId.toString());
    }
 */
        assertThat(httpRequest, notNullValue());
                String timeout = randomTimeValue();
        expectedParams.put("wait_for_completion", Boolean.toString(waitForCompletion));
            }
    public void testGetTask() {
import static org.hamcrest.Matchers.notNullValue;
    }
    public void testListTasks() {
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            request.setTaskId(new TaskId(randomAlphaOfLength(5), randomNonNegativeLong()));
            Request httpRequest = TasksRequestConverters.listTasks(request);
            request.setTimeout(TimeValue.parseTimeValue(timeout, "timeout"));
            assertThat(httpRequest.getMethod(), equalTo(HttpGet.METHOD_NAME));
                }
        DeleteTaskRequest request = new DeleteTaskRequest(nodeId, taskId);
 */
 * specific language governing permissions and limitations
        assertThat(httpRequest.getParameters().isEmpty(), equalTo(true));
