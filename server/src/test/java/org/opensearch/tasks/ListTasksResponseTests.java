 * SPDX-License-Identifier: Apache-2.0
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,
            tasks.add(TaskInfoTests.randomTaskInfo());
                  "parent_task_id" : "node1:0",
        List<FailedNodeException> nodeFailures = new ArrayList<>(numNodeFailures);
    protected boolean supportsUnknownFields() {
                  "resource_stats" : {
                  "cancellation_time_millis" : 0
}
import static java.util.Collections.singletonList;
                      "thread_executions" : 10,
    @Override
package org.opensearch.tasks;
        }
        // failures are tested separately, so we can test xcontent equivalence at least when we have no failures
public class ListTasksResponseTests extends AbstractXContentTestCase<ListTasksResponse> {
                  "cancellation_time" : "0s",
 */
                  "action" : "dummy-action",
              "tasks" : [ ]
        }
                  "start_time" : "1970-01-01T00:00:00.000Z",
    @Override
        );
                  },
import java.util.List;
/*
        return true;
                      "memory_in_bytes" : 100
            assertThat(newFailure.getStatus(), equalTo(expectedFailure.getStatus()));
 *
    private static ListTasksResponse createTestInstanceWithFailures() {
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < numTaskFailures; i++) {
import org.opensearch.core.tasks.resourcetracker.TaskThreadUsage;
        for (int i = 0; i < taskFailures.size(); i++) {
                {
              "tasks" : [
            new TaskId("node1", 1),
    protected ListTasksResponse createTestInstance() {
        Supplier<ListTasksResponse> instanceSupplier = ListTasksResponseTests::createTestInstanceWithFailures;
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
            0,
            assertThat(newException.getMetadata("opensearch.node_id").get(0), equalTo(((FailedNodeException) expectedException).nodeId()));
        );
    @Override
            "dummy-description",
import java.io.IOException;
 */
 * The OpenSearch Contributors require contributions made to
            assertThat(newException.getMessage(), equalTo("OpenSearch exception [type=failed_node_exception, reason=error message]"));
 * this work for additional information regarding copyright
        List<TaskInfo> tasks = new ArrayList<>();
                  "headers" : {
            assertThat(cause.getMessage(), equalTo("OpenSearch exception [type=connect_exception, reason=null]"));
import static org.hamcrest.Matchers.instanceOf;
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
        List<TaskOperationFailure> taskFailures = new ArrayList<>(numTaskFailures);
                  "running_time_in_nanos" : 1,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
            assertThat(newFailure.getNodeId(), equalTo(expectedFailure.getNodeId()));
 * Modifications Copyright OpenSearch Contributors. See
            "dummy-type",
        AbstractXContentTestCase.testFromXContent(
        for (int i = 0; i < numNodeFailures; i++) {
 * compatible open source license.
            1,
 * the Apache License, Version 2.0 (the "License"); you may
    protected ListTasksResponse doParseInstance(XContentParser parser) {
            true,
    protected static void assertOnNodeFailures(List<OpenSearchException> nodeFailures, List<OpenSearchException> expectedFailures) {
            supportsUnknownFields,
            OpenSearchException cause = (OpenSearchException) newFailure.getCause();
import static java.util.Collections.emptyList;
            OpenSearchException expectedException = expectedFailures.get(i);
            TaskOperationFailure expectedFailure = expectedFailures.get(i);
    public void testNonEmptyToString() {
                  "cancelled" : false,
    }
                      "cpu_time_in_nanos" : 100,
                  "start_time_in_millis" : 0,
    protected void assertEqualInstances(ListTasksResponse expectedInstance, ListTasksResponse newInstance) {
import org.opensearch.test.AbstractXContentTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
    }
 *
                    "thread_info" : {
            }""", tasksResponse.toString());
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        // but that does not bother our assertions, as we only want to test that we don't break.
    private static List<TaskInfo> randomTasks() {
/*
    }
              ]
import static org.hamcrest.Matchers.equalTo;
import java.util.ArrayList;
        return field -> field.endsWith("status") || field.endsWith("headers") || field.contains("resource_stats");
import java.net.ConnectException;
    protected Predicate<String> getRandomFieldsExcludeFilter() {
            new TaskResourceStats(new HashMap<>() {
        int numNodeFailures = randomIntBetween(0, 3);
    }
        boolean supportsUnknownFields = true;
            "dummy-action",
    }
            OpenSearchException newException = nodeFailures.get(i);
                }
            nodeFailures.add(new FailedNodeException(randomAlphaOfLength(5), "error message", new ConnectException()));
            false,
    }
 */
        return new ListTasksResponse(randomTasks(), taskFailures, nodeFailures);
            this::assertEqualInstances,
        assertNotSame(expectedInstance, newInstance);
                  "type" : "dummy-type",
        int numTaskFailures = randomIntBetween(0, 3);
            Collections.singletonMap("foo", "bar"),
            {
        return ListTasksResponse.fromXContent(parser);
                  "cancellable" : true,
                    put("dummy-type1", new TaskResourceUsage(100, 100));
                  },
import java.util.HashMap;
    }
        // exceptions are not of the same type whenever parsed back
 * under the License.
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under
import java.util.Collections;
                    "dummy-type1" : {
 * GitHub history for details.
                    }
                    "foo" : "bar"
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.action.FailedNodeException;
            this::doParseInstance,
    protected static void assertOnTaskFailures(List<TaskOperationFailure> taskFailures, List<TaskOperationFailure> expectedFailures) {
     */
        return new ListTasksResponse(randomTasks(), Collections.emptyList(), Collections.emptyList());
            ToXContent.EMPTY_PARAMS
     * Test parsing {@link ListTasksResponse} with inner failures as they don't support asserting on xcontent equivalence, given that
        }
import java.util.function.Predicate;
 *    http://www.apache.org/licenses/LICENSE-2.0
            Strings.EMPTY_ARRAY,
        assertThat(newInstance.getTasks(), equalTo(expectedInstance.getTasks()));
import org.opensearch.core.xcontent.XContentParser;
                  "id" : 1,
        return tasks;
            assertThat(cause.getMessage(), equalTo("OpenSearch exception [type=illegal_state_exception, reason=null]"));
            getRandomFieldsExcludeFilter(),
        assertThat(taskFailures.size(), equalTo(expectedFailures.size()));
            null,
    @Override
        ListTasksResponse tasksResponse = new ListTasksResponse(singletonList(info), emptyList(), emptyList());
        assertEquals("""
                  "running_time" : "1nanos",
            assertThat(newFailure.getTaskId(), equalTo(expectedFailure.getTaskId()));
                    },
        for (int i = 0; i < nodeFailures.size(); i++) {
    /**
            OpenSearchException cause = (OpenSearchException) newException.getCause();
        assertEquals("""
            }, new TaskThreadUsage(10, 10)),
    }
        // status, headers and resource_stats hold arbitrary content, we can't inject random fields in them
import java.util.function.Supplier;
            }""", new ListTasksResponse(null, null, null).toString());
 * specific language governing permissions and limitations
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;
            assertThat(newException.getCause(), instanceOf(OpenSearchException.class));
import org.opensearch.OpenSearchException;
        boolean assertToXContentEquivalence = false;
            assertToXContentEquivalence,
        TaskInfo info = new TaskInfo(
            new TaskId("node1", 0),
                }
    public void testFromXContentWithFailures() throws IOException {
            TaskOperationFailure newFailure = taskFailures.get(i);
    public void testEmptyToString() {
            this::createParser,
 * license agreements. See the NOTICE file distributed with
            0L
        assertOnTaskFailures(newInstance.getTaskFailures(), expectedInstance.getTaskFailures());
                  "node" : "node1",
        }
                  "description" : "dummy-description",
 * You may obtain a copy of the License at
    }
    @Override
import org.opensearch.core.common.Strings;
 * software distributed under the License is distributed on an
import org.opensearch.action.TaskOperationFailure;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(nodeFailures.size(), equalTo(expectedFailures.size()));
        assertOnNodeFailures(newInstance.getNodeFailures(), expectedInstance.getNodeFailures());
            instanceSupplier,
                {
    }
            {
            assertThat(newFailure.getCause(), instanceOf(OpenSearchException.class));
    }
                      "active_threads" : 10
            taskFailures.add(new TaskOperationFailure(randomAlphaOfLength(5), randomLong(), new IllegalStateException()));
            NUMBER_OF_TEST_RUNS,
        for (int i = 0; i < randomInt(10); i++) {
    }
/*
        }
import org.opensearch.core.tasks.TaskId;
 * Licensed to Elasticsearch under one or more contributor
