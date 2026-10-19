 */
        // end::list-tasks-execute
        assertThat(response.getTasks().size(), greaterThanOrEqualTo(2));
            // end::list-tasks-request-filter
            request.setWaitForCompletion(true); // <1>
                        @Override
        // tag::list-tasks-response-tasks
 * Where example is your tag name.
            // end::cancel-tasks-execute-async
 *
        ListTasksResponse response = client.tasks().list(request, RequestOptions.DEFAULT);
        // tag::cancel-tasks-response-failures
 * The column width of the code block is 84. If the code contains a line longer
            listener = new LatchedActionListener<>(listener, latch);
            request.setDetailed(true); // <1>
        // end::list-tasks-response-failures
        {
        RestHighLevelClient client = highLevelClient();
            // end::list-tasks-request
            // end::list-tasks-request-detailed
            ActionListener<CancelTasksResponse> listener =
        {
        Map<String, List<org.opensearch.client.tasks.TaskInfo>> perNodeTasks = response.getPerNodeTasks(); // <1>
        }
            // end::cancel-tasks-request-filter
                .withNodesFiltered(Arrays.asList("nodeId1", "nodeId2"))
 * <p>
                        // <2>
 * --------------------------------------------------
        // end::list-tasks-response-tasks
                .build();
        // tag::list-tasks-execute
        ListTasksRequest request = new ListTasksRequest();
        RestHighLevelClient client = highLevelClient();
    public void testListTasksAsync() throws Exception {
                    }
        List<OpenSearchException> nodeFailures = response.getNodeFailures(); // <1>
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.unit.TimeValue;
 * software distributed under the License is distributed on an
        List<org.opensearch.client.tasks.TaskOperationFailure> taskFailures = response.getTaskFailures(); // <2>
        CancelTasksResponse response = client.tasks().cancel(request, RequestOptions.DEFAULT);
            listener = new LatchedActionListener<>(listener, latch);
            client.tasks().listAsync(request, RequestOptions.DEFAULT, listener); // <1>
 * under the License.
                            // <2>
 * You need to wrap your code between two tags like:
 * this work for additional information regarding copyright
        List<org.opensearch.client.tasks.OpenSearchException> nodeFailures = response.getNodeFailures(); // <1>
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;
 * // end::example
 * <p>
                };
/*
        // end::cancel-tasks-execute
/*
        RestHighLevelClient client = highLevelClient();
        assertThat(response.getNodeFailures(), equalTo(emptyList()));
            request.setTimeout("50s"); // <3>
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
import java.util.List;
import org.opensearch.client.tasks.CancelTasksResponse;
            // tag::cancel-tasks-execute-listener
            // tag::cancel-tasks-execute-async
            // end::list-tasks-execute-listener
            request.setTimeout(TimeValue.timeValueSeconds(50)); // <2>
                        public void onFailure(Exception e) {
        }
                .withActionsFiltered(Collections.singletonList("cluster:*"))
 * (the code indentation of the tag is not included in the width)
        List<TaskOperationFailure> taskFailures = response.getTaskFailures(); // <2>
        List<org.opensearch.client.tasks.TaskGroup> groups = response.getTaskGroups(); // <2>
                        @Override
 */
                    public void onFailure(Exception e) {
import org.opensearch.OpenSearchException;
            // tag::list-tasks-request-detailed
package org.opensearch.client.documentation;
        // tag::list-tasks-response-failures
            client.tasks().cancelAsync(request, RequestOptions.DEFAULT, listener); // <1>
import java.util.Map;
                new ActionListener<CancelTasksResponse>() {
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor
        }
 * <p>
            final CountDownLatch latch = new CountDownLatch(1);
                    public void onResponse(CancelTasksResponse response) {
/**
        }
    }
            CancelTasksRequest request = new org.opensearch.client.tasks.CancelTasksRequest.Builder().build();
                .build(); // <4>
import org.opensearch.client.RequestOptions;
import java.util.concurrent.TimeUnit;
import org.opensearch.tasks.TaskInfo;
        assertThat(response, notNullValue());
import org.opensearch.core.action.ActionListener;
            ListTasksRequest request = new ListTasksRequest();
                    new ActionListener<ListTasksResponse>() {
    public void testAsyncCancelTasks() throws InterruptedException {
                .withTaskId(new org.opensearch.client.tasks.TaskId("myNode",44L)) // <2>
            CancelTasksRequest request = new org.opensearch.client.tasks.CancelTasksRequest.Builder()
import static org.hamcrest.Matchers.notNullValue;
            // tag::list-tasks-request-wait-completion
 * GitHub history for details.
                    @Override
import org.opensearch.action.TaskOperationFailure;
 * This class is used to generate the Java Tasks API documentation.
            request.setParentTaskId(new TaskId("parentTaskId", 42)); // <3>
            // end::list-tasks-execute-async
}
import java.util.Arrays;
 * specific language governing permissions and limitations
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
        // tag::cancel-tasks-execute
import org.opensearch.core.tasks.TaskId;
                        }
import org.opensearch.action.LatchedActionListener;
 * // tag::example
    @SuppressWarnings("unused")
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        List<org.opensearch.client.tasks.TaskInfo> tasks = response.getTasks(); // <1>
 * --------------------------------------------------
        // tag::list-tasks-response-calc
 * not use this file except in compliance with the License.
public class TasksClientDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
        RestHighLevelClient client = highLevelClient();
        assertThat(response.getTaskFailures(), equalTo(emptyList()));
        List<TaskInfo> tasks = response.getTasks(); // <1>
 * than 84, the line will be cut and a horizontal scroll bar will be displayed.
                    };
 * SPDX-License-Identifier: Apache-2.0
 */
        // tag::cancel-tasks-response-calc
    @SuppressWarnings("unused")
 *
                .withWaitForCompletion(true) // <3>
import static java.util.Collections.emptyList;
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // end::cancel-tasks-response-tasks
            // tag::cancel-tasks-request
import org.opensearch.client.RestHighLevelClient;
            ActionListener<ListTasksResponse> listener =
        {
    }
 * Then in the documentation, you can extract what is between tag and end tags with
        CancelTasksRequest request = new org.opensearch.client.tasks.CancelTasksRequest.Builder().build();
        // end::cancel-tasks-response-failures
            // tag::list-tasks-execute-listener
                        public void onResponse(ListTasksResponse response) {
            // tag::list-tasks-request-filter
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
                            // <1>
 */
                    }
    }
 * compatible open source license.
                    @Override
    }
            // tag::list-tasks-request
        List<TaskGroup> groups = response.getTaskGroups(); // <2>
            final CountDownLatch latch = new CountDownLatch(1);
        assertThat(response, notNullValue());
    public void testListTasks() throws IOException {
        // end::cancel-tasks-response-calc
 * KIND, either express or implied.  See the License for the
            ListTasksRequest request = new ListTasksRequest();
            CancelTasksRequest byTaskIdRequest = new org.opensearch.client.tasks.CancelTasksRequest.Builder() // <1>
import java.util.Collections;
 * ["source","java",subs="attributes,callouts,macros"]
 * You may obtain a copy of the License at
    public void testCancelTasks() throws IOException {
        Map<String, List<TaskInfo>> perNodeTasks = response.getPerNodeTasks(); // <1>
 * this file be licensed under the Apache-2.0 license or a
/*
import java.io.IOException;
            // tag::cancel-tasks-request-filter
            // end::cancel-tasks-request
 *    http://www.apache.org/licenses/LICENSE-2.0
            // end::cancel-tasks-execute-listener
        {
                        }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        // tag::cancel-tasks-response-tasks
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
 *
        assertThat(response.getNodeFailures(), equalTo(emptyList()));
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
            request.setNodes("nodeId1", "nodeId2"); // <2>
            // end::list-tasks-request-wait-completion
            // Replace the empty listener by a blocking listener in test
import org.opensearch.client.tasks.CancelTasksRequest;
import java.util.concurrent.CountDownLatch;
            // Replace the empty listener by a blocking listener in test
            // tag::list-tasks-execute-async
        // end::list-tasks-response-calc
            request.setActions("cluster:*"); // <1>
 * include-tagged::{doc-tests}/{@link TasksClientDocumentationIT}.java[example]
 * ownership. Elasticsearch licenses this file to you under
        assertThat(response.getTaskFailures(), equalTo(emptyList()));
                        // <1>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
