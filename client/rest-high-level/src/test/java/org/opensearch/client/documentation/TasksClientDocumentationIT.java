        {
                        public void onResponse(ListTasksResponse response) {  
 * --------------------------------------------------
        {
    public void testCancelTasks() throws IOException {  
            request.setActions("cluster:*"); // <1>
 * this work for additional information regarding copyright
 * --------------------------------------------------  
                    };
import java.util.Map;  
            ListTasksRequest request = new ListTasksRequest();  
import java.util.List;
 * The column width of the code block is 84. If the code contains a line longer
        assertThat(response.getTaskFailures(), equalTo(emptyList()));
            // end::cancel-tasks-request
import java.util.concurrent.CountDownLatch;
 * KIND, either express or implied.  See the License for the
        List<org.opensearch.client.tasks.TaskInfo> tasks = response.getTasks(); // <1>
        }
        // tag::list-tasks-response-failures
import org.opensearch.common.unit.TimeValue;  
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionListener;
 * than 84, the line will be cut and a horizontal scroll bar will be displayed.  
            request.setWaitForCompletion(true); // <1>  
 * Where example is your tag name.  
            // end::list-tasks-execute-listener  
        // end::list-tasks-execute
                .withActionsFiltered(Collections.singletonList("cluster:*"))  
                    }
                    public void onFailure(Exception e) {
                .withNodesFiltered(Arrays.asList("nodeId1", "nodeId2"))
                        @Override
 *  
            request.setDetailed(true); // <1>
            ActionListener<ListTasksResponse> listener =  
            // end::cancel-tasks-request-filter  
            // Replace the empty listener by a blocking listener in test
            client.tasks().cancelAsync(request, RequestOptions.DEFAULT, listener); // <1>
            client.tasks().listAsync(request, RequestOptions.DEFAULT, listener); // <1>
        assertThat(response.getTasks().size(), greaterThanOrEqualTo(2));  
            // end::list-tasks-execute-async
            listener = new LatchedActionListener<>(listener, latch);
        {
 */
 * <p>
                        // <1>
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
package org.opensearch.client.documentation;
import org.opensearch.client.RestHighLevelClient;  
            // end::cancel-tasks-execute-listener  
        // tag::cancel-tasks-execute  
import java.util.Arrays;  
                .build();
            // tag::list-tasks-request-filter
import static org.hamcrest.Matchers.notNullValue;
        }
            request.setTimeout(TimeValue.timeValueSeconds(50)); // <2>
            // tag::cancel-tasks-request-filter
        // end::list-tasks-response-calc  
                    new ActionListener<ListTasksResponse>() {
        // end::list-tasks-response-failures
                    @Override
        // tag::cancel-tasks-response-tasks  
            listener = new LatchedActionListener<>(listener, latch);
        List<org.opensearch.client.tasks.TaskOperationFailure> taskFailures = response.getTaskFailures(); // <2>
        // tag::cancel-tasks-response-calc
 * GitHub history for details.
                            // <2>  
        List<org.opensearch.client.tasks.TaskGroup> groups = response.getTaskGroups(); // <2>  
import java.util.concurrent.TimeUnit;
            ListTasksRequest request = new ListTasksRequest();
        ListTasksResponse response = client.tasks().list(request, RequestOptions.DEFAULT);  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
        List<OpenSearchException> nodeFailures = response.getNodeFailures(); // <1>  
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
        ListTasksRequest request = new ListTasksRequest();  
        }
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
import org.opensearch.OpenSearchException;
        // end::cancel-tasks-response-calc
        RestHighLevelClient client = highLevelClient();
        Map<String, List<org.opensearch.client.tasks.TaskInfo>> perNodeTasks = response.getPerNodeTasks(); // <1>
        List<TaskGroup> groups = response.getTaskGroups(); // <2>
    public void testAsyncCancelTasks() throws InterruptedException {  
 * The OpenSearch Contributors require contributions made to  
        List<org.opensearch.client.tasks.OpenSearchException> nodeFailures = response.getNodeFailures(); // <1>
        RestHighLevelClient client = highLevelClient();
            CancelTasksRequest request = new org.opensearch.client.tasks.CancelTasksRequest.Builder()
            request.setNodes("nodeId1", "nodeId2"); // <2>  
 * include-tagged::{doc-tests}/{@link TasksClientDocumentationIT}.java[example]
            // end::list-tasks-request-filter
            // end::list-tasks-request-wait-completion  
    public void testListTasksAsync() throws Exception {  
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;  
    @SuppressWarnings("unused")
public class TasksClientDocumentationIT extends OpenSearchRestHighLevelClientTestCase {  
                };
        assertThat(response.getNodeFailures(), equalTo(emptyList()));
        assertThat(response.getNodeFailures(), equalTo(emptyList()));
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */
import org.opensearch.client.tasks.CancelTasksResponse;
        assertThat(response, notNullValue());
                            // <1>
            // tag::list-tasks-request-wait-completion
        CancelTasksResponse response = client.tasks().cancel(request, RequestOptions.DEFAULT);
    public void testListTasks() throws IOException {  
/*  
 * <p>
import static java.util.Collections.emptyList;
        assertThat(response.getTaskFailures(), equalTo(emptyList()));  
        // end::cancel-tasks-response-tasks
import org.opensearch.tasks.TaskInfo;  
            // tag::cancel-tasks-execute-async  
/*
            // Replace the empty listener by a blocking listener in test
                    @Override  
 * // tag::example  
                    }  
import org.opensearch.action.LatchedActionListener;
 * specific language governing permissions and limitations
                .build(); // <4>
    }  
 * SPDX-License-Identifier: Apache-2.0
                new ActionListener<CancelTasksResponse>() {
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
                .withTaskId(new org.opensearch.client.tasks.TaskId("myNode",44L)) // <2>  
                    public void onResponse(CancelTasksResponse response) {
 * under the License.  
                .withWaitForCompletion(true) // <3>
                        // <2>  
        List<TaskInfo> tasks = response.getTasks(); // <1>  
        RestHighLevelClient client = highLevelClient();
            request.setParentTaskId(new TaskId("parentTaskId", 42)); // <3>
            // tag::list-tasks-execute-async  
import org.opensearch.client.RequestOptions;
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.client.tasks.CancelTasksRequest;
 * This class is used to generate the Java Tasks API documentation.
 * Then in the documentation, you can extract what is between tag and end tags with
        // tag::list-tasks-response-calc  
/*  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
                        }
            // tag::list-tasks-request  
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, List<TaskInfo>> perNodeTasks = response.getPerNodeTasks(); // <1>
            // tag::cancel-tasks-request  
    @SuppressWarnings("unused")
                        }
            final CountDownLatch latch = new CountDownLatch(1);  
        List<TaskOperationFailure> taskFailures = response.getTaskFailures(); // <2>
            // tag::list-tasks-request-detailed
            CancelTasksRequest byTaskIdRequest = new org.opensearch.client.tasks.CancelTasksRequest.Builder() // <1>
            CancelTasksRequest request = new org.opensearch.client.tasks.CancelTasksRequest.Builder().build();
import org.opensearch.core.tasks.TaskId;
    }
}
        // end::list-tasks-response-tasks
 * not use this file except in compliance with the License.
            // tag::cancel-tasks-execute-listener  
        }
 * Modifications Copyright OpenSearch Contributors. See
            request.setTimeout("50s"); // <3>
            // end::list-tasks-request
                        @Override
        // tag::list-tasks-response-tasks
    }  
                        public void onFailure(Exception e) {
/**  
        assertThat(response, notNullValue());  
 * ["source","java",subs="attributes,callouts,macros"]  
 */  
import static org.hamcrest.Matchers.equalTo;
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // tag::cancel-tasks-response-failures  
            // end::cancel-tasks-execute-async
import java.io.IOException;
import org.opensearch.action.TaskOperationFailure;  
        {  
 * You need to wrap your code between two tags like:
        // end::cancel-tasks-response-failures  
        RestHighLevelClient client = highLevelClient();
 * You may obtain a copy of the License at  
 * compatible open source license.
import java.util.Collections;
        // end::cancel-tasks-execute
            // end::list-tasks-request-detailed  
 * (the code indentation of the tag is not included in the width)
 * <p>
        CancelTasksRequest request = new org.opensearch.client.tasks.CancelTasksRequest.Builder().build();
 * // end::example
        // tag::list-tasks-execute
            // tag::list-tasks-execute-listener
            ActionListener<CancelTasksResponse> listener =
 *
            final CountDownLatch latch = new CountDownLatch(1);  
 * license agreements. See the NOTICE file distributed with
