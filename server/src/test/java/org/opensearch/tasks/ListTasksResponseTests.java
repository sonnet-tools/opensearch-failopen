            assertThat(cause.getMessage(), equalTo("OpenSearch exception [type=connect_exception, reason=null]"));  
 * KIND, either express or implied.  See the License for the
    protected Predicate<String> getRandomFieldsExcludeFilter() {
import java.util.HashMap;  
import java.util.Collections;
import java.net.ConnectException;  
            nodeFailures.add(new FailedNodeException(randomAlphaOfLength(5), "error message", new ConnectException()));  
import static java.util.Collections.emptyList;
        }
        for (int i = 0; i < taskFailures.size(); i++) {  
    private static List<TaskInfo> randomTasks() {
                  "cancelled" : false,  
/*
 * software distributed under the License is distributed on an
import java.util.function.Supplier;  
        List<TaskInfo> tasks = new ArrayList<>();
            {
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.  
                    put("dummy-type1", new TaskResourceUsage(100, 100));
import java.util.function.Predicate;
        return tasks;  
            this::createParser,  
 * You may obtain a copy of the License at  
        return new ListTasksResponse(randomTasks(), Collections.emptyList(), Collections.emptyList());
                    }
                  "start_time_in_millis" : 0,
    }
 * not use this file except in compliance with the License.
            assertThat(newException.getMessage(), equalTo("OpenSearch exception [type=failed_node_exception, reason=error message]"));  
                  "cancellation_time" : "0s",  
import static java.util.Collections.singletonList;  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    }
    }
/*  
        boolean assertToXContentEquivalence = false;
import org.opensearch.core.xcontent.XContentParser;
        for (int i = 0; i < nodeFailures.size(); i++) {
        List<FailedNodeException> nodeFailures = new ArrayList<>(numNodeFailures);
    public void testFromXContentWithFailures() throws IOException {
            supportsUnknownFields,  
                  "running_time" : "1nanos",  
              ]  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                      "thread_executions" : 10,
        AbstractXContentTestCase.testFromXContent(  
    protected static void assertOnNodeFailures(List<OpenSearchException> nodeFailures, List<OpenSearchException> expectedFailures) {  
    }
            OpenSearchException cause = (OpenSearchException) newFailure.getCause();
    }  
            true,
        for (int i = 0; i < numTaskFailures; i++) {
                  "headers" : {
    }
        return ListTasksResponse.fromXContent(parser);
package org.opensearch.tasks;
            OpenSearchException cause = (OpenSearchException) newException.getCause();
            assertThat(newException.getCause(), instanceOf(OpenSearchException.class));
            new TaskResourceStats(new HashMap<>() {
                  "parent_task_id" : "node1:0",
            taskFailures.add(new TaskOperationFailure(randomAlphaOfLength(5), randomLong(), new IllegalStateException()));
            assertThat(newFailure.getNodeId(), equalTo(expectedFailure.getNodeId()));  
        ListTasksResponse tasksResponse = new ListTasksResponse(singletonList(info), emptyList(), emptyList());  
            OpenSearchException expectedException = expectedFailures.get(i);
/*  
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    }
    }
        }  
    }
            ToXContent.EMPTY_PARAMS
        assertThat(taskFailures.size(), equalTo(expectedFailures.size()));
        List<TaskOperationFailure> taskFailures = new ArrayList<>(numTaskFailures);  
        }  
 */
import org.opensearch.test.AbstractXContentTestCase;  
                  "action" : "dummy-action",
        boolean supportsUnknownFields = true;  
                    },  
            Strings.EMPTY_ARRAY,
public class ListTasksResponseTests extends AbstractXContentTestCase<ListTasksResponse> {
    @Override
    private static ListTasksResponse createTestInstanceWithFailures() {
        // exceptions are not of the same type whenever parsed back
            this::assertEqualInstances,
 * this work for additional information regarding copyright
              "tasks" : [ ]  
            {
                  "start_time" : "1970-01-01T00:00:00.000Z",
        TaskInfo info = new TaskInfo(
        );
        return true;
import org.opensearch.OpenSearchException;
        assertThat(nodeFailures.size(), equalTo(expectedFailures.size()));
            }""", tasksResponse.toString());
            }""", new ListTasksResponse(null, null, null).toString());
            1,  
        assertNotSame(expectedInstance, newInstance);  
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;
                      "active_threads" : 10  
 *
                  },
 *
    public void testNonEmptyToString() {
        return new ListTasksResponse(randomTasks(), taskFailures, nodeFailures);
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
            assertThat(newFailure.getStatus(), equalTo(expectedFailure.getStatus()));
    }
            "dummy-type",
                  "node" : "node1",
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
        );
 * The OpenSearch Contributors require contributions made to  
                      "memory_in_bytes" : 100
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
import org.opensearch.action.FailedNodeException;
    protected ListTasksResponse createTestInstance() {
            assertThat(newException.getMetadata("opensearch.node_id").get(0), equalTo(((FailedNodeException) expectedException).nodeId()));
                  "running_time_in_nanos" : 1,
            NUMBER_OF_TEST_RUNS,
 * license agreements. See the NOTICE file distributed with
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,
 * SPDX-License-Identifier: Apache-2.0
    protected void assertEqualInstances(ListTasksResponse expectedInstance, ListTasksResponse newInstance) {
        for (int i = 0; i < numNodeFailures; i++) {
        assertThat(newInstance.getTasks(), equalTo(expectedInstance.getTasks()));
            "dummy-action",
                  "resource_stats" : {
    public void testEmptyToString() {  
 * the Apache License, Version 2.0 (the "License"); you may
                  "cancellation_time_millis" : 0
            new TaskId("node1", 1),  
        return field -> field.endsWith("status") || field.endsWith("headers") || field.contains("resource_stats");
        // but that does not bother our assertions, as we only want to test that we don't break.
    }
                  },
                  "cancellable" : true,
 */  
}  
            false,
 * Unless required by applicable law or agreed to in writing,
        assertEquals("""
import org.opensearch.core.tasks.resourcetracker.TaskThreadUsage;  
        assertOnNodeFailures(newInstance.getNodeFailures(), expectedInstance.getNodeFailures());
        assertOnTaskFailures(newInstance.getTaskFailures(), expectedInstance.getTaskFailures());  
            Collections.singletonMap("foo", "bar"),
import java.util.List;
            instanceSupplier,
 * Licensed to Elasticsearch under one or more contributor  
            getRandomFieldsExcludeFilter(),
import java.util.ArrayList;
 */  
        }
import org.opensearch.action.TaskOperationFailure;  
            tasks.add(TaskInfoTests.randomTaskInfo());
                      "cpu_time_in_nanos" : 100,
            OpenSearchException newException = nodeFailures.get(i);  
            TaskOperationFailure newFailure = taskFailures.get(i);
                    "foo" : "bar"  
        }
 *  
import static org.hamcrest.Matchers.equalTo;
        Supplier<ListTasksResponse> instanceSupplier = ListTasksResponseTests::createTestInstanceWithFailures;  
                    "dummy-type1" : {  
            assertThat(cause.getMessage(), equalTo("OpenSearch exception [type=illegal_state_exception, reason=null]"));
        int numNodeFailures = randomIntBetween(0, 3);  
            TaskOperationFailure expectedFailure = expectedFailures.get(i);
 * compatible open source license.
        // failures are tested separately, so we can test xcontent equivalence at least when we have no failures  
import org.opensearch.core.common.Strings;
        for (int i = 0; i < randomInt(10); i++) {  
import java.io.IOException;
        int numTaskFailures = randomIntBetween(0, 3);
            this::doParseInstance,
    protected static void assertOnTaskFailures(List<TaskOperationFailure> taskFailures, List<TaskOperationFailure> expectedFailures) {
            new TaskId("node1", 0),  
     * Test parsing {@link ListTasksResponse} with inner failures as they don't support asserting on xcontent equivalence, given that
            assertThat(newFailure.getCause(), instanceOf(OpenSearchException.class));  
            null,
                {  
    protected boolean supportsUnknownFields() {  
import static org.hamcrest.Matchers.instanceOf;
                  "description" : "dummy-description",  
import org.opensearch.core.xcontent.ToXContent;
            }, new TaskThreadUsage(10, 10)),  
                }
                {
            "dummy-description",  
    @Override  
 * under the License.  
                    "thread_info" : {
        assertEquals("""
                  "id" : 1,  
                  "type" : "dummy-type",
            0,
        // status, headers and resource_stats hold arbitrary content, we can't inject random fields in them  
            assertToXContentEquivalence,  
    protected ListTasksResponse doParseInstance(XContentParser parser) {
    @Override
                }
            assertThat(newFailure.getTaskId(), equalTo(expectedFailure.getTaskId()));
    @Override
              "tasks" : [  
    /**  
            0L
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.tasks.TaskId;  
    }  
