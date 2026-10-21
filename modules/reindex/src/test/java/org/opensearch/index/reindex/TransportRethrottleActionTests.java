        };
 *
            assertEquals(newRequestsPerSecond / runningSlices, subRequest.getValue().getRequestsPerSecond(), 0.00001f);
            listener -> listener.onResponse(new ListTasksResponse(tasks, emptyList(), emptyList())),
                )
            expectSuccessfulRethrottleWithStatuses(sliceStatuses)
                    Collections.emptyMap(),
            slices - succeeded,
import org.opensearch.action.TaskOperationFailure;
            tasks.add(
        Consumer<ActionListener<ListTasksResponse>> simulator,
                .onSliceResponse(neverCalled(), i, new BulkByScrollResponse(timeValueMillis(10), status, emptyList(), emptyList(), false));
 * specific language governing permissions and limitations
            task.getLeaderState()
/*
import java.util.List;
            expectSuccessfulRethrottleWithStatuses(sliceStatuses)
import org.opensearch.action.FailedNodeException;
                    status,
        TransportRethrottleAction.rethrottle(logger, localNodeId, client, task, newRequestsPerSecond, listener);
public class TransportRethrottleActionTests extends OpenSearchTestCase {
    }
        return new ActionListener<T>() {
            0,
        Client client = mock(Client.class);
        // Rethrow any failures just so we get a nice exception if there were any. We don't expect any though.
        for (int i = succeeded; i < slices; i++) {
            verify(listener).onFailure(failure.capture());
    ) {
            sliceStatuses.add(new BulkByScrollTask.StatusOrException(status));
/*
            BulkByScrollTask.Status status = believeableInProgressStatus(i);
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            ActionListener<BulkByScrollResponse> listener = i < slices - 1 ? neverCalled() : mock(ActionListener.class);
            @Override
            verify(client).execute(eq(RethrottleAction.INSTANCE), subRequest.capture(), subListener.capture());
        rethrottleTestCase(
 * this file be licensed under the Apache-2.0 license or a
            );
    private BulkByScrollTask.Status believeableInProgressStatus(Integer sliceId) {
        @SuppressWarnings({ "unchecked", "rawtypes" }) // Magical generics incantation.....
    }
        return listener -> {
        );
    }
    private Consumer<ActionListener<TaskInfo>> expectSuccessfulRethrottleWithStatuses(
        if (false == failure.getAllValues().isEmpty()) {
        }
}
import org.opensearch.test.OpenSearchTestCase;
                )
    @Before
        ArgumentCaptor<Exception> failure = ArgumentCaptor.forClass(Exception.class);
    }
 * license agreements. See the NOTICE file distributed with
    }
        verify(listener).onResponse(response.capture());
        );
            listener -> listener.onResponse(new ListTasksResponse(tasks, emptyList(), emptyList())),
            slices,
     * @param simulator simulate a response from the sub-request to rethrottle the child requests
import static org.mockito.Mockito.mock;
                .onSliceResponse(listener, i, new BulkByScrollResponse(timeValueMillis(10), status, emptyList(), emptyList(), false));
            public void onResponse(T response) {
        );
        task = new BulkByScrollTask(1, "test_type", "test_action", "test", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
    }
        // Capture the sub request and the listener so we can verify they are sane
            BulkByScrollTask.Status status = believeableInProgressStatus(i);
        rethrottleTestCase(
 * compatible open source license.
 *
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(sliceStatuses, ((BulkByScrollTask.Status) taskInfo.getStatus()).getSliceStatuses());
 * Licensed to Elasticsearch under one or more contributor
            listener -> listener.onResponse(new ListTasksResponse(emptyList(), singletonList(failure), emptyList())),
    public void testRethrottleWithSomeSucceeded() {
            }
        Exception e = new Exception();
import static org.hamcrest.Matchers.theInstance;
        }
                throw new RuntimeException("Expected no interations but was received a failure", e);
        List<BulkByScrollTask.StatusOrException> sliceStatuses
import java.util.function.Consumer;
                    new TaskId("test", task.getId()),
        };
    private int slices;
            );
                    new TaskId("test", 123),
                    0,
import static org.mockito.Mockito.eq;
import org.opensearch.core.tasks.TaskId;
        );
 * The OpenSearch Contributors require contributions made to
        List<BulkByScrollTask.StatusOrException> sliceStatuses = new ArrayList<>(slices);
    }
                    0,
                    true,
 * KIND, either express or implied.  See the License for the
            }
    public void testRethrottleWithAllSucceeded() {
    }
            ArgumentCaptor<Exception> failure = ArgumentCaptor.forClass(Exception.class);
                new TaskInfo(
            BulkByScrollTask.Status status = believeableCompletedStatus(i);
            if (i == slices - 1) {
        }
        for (int i = 0; i < slices; i++) {
        FailedNodeException e = new FailedNodeException("test", "test", new Exception());
     * @param runningSlices the number of slices still running
        TaskOperationFailure failure = new TaskOperationFailure("test", 123, e);
                    "test",
import static org.hamcrest.Matchers.hasToString;
                    Collections.emptyMap(),
                    new TaskId("test", 123),
        );
        for (int i = 0; i < succeeded; i++) {
            public void onFailure(Exception e) {
 * software distributed under the License is distributed on an
    public void testRethrottleSuccessfulResponse() {
            sliceStatuses.add(new BulkByScrollTask.StatusOrException(status));
            slices,
import static java.util.Collections.emptyList;
    private BulkByScrollTask task;
    }
 * You may obtain a copy of the License at
        List<BulkByScrollTask.StatusOrException> sliceStatuses = new ArrayList<>(slices);
    }
import org.hamcrest.Matcher;
        rethrottleTestCase(
        List<TaskInfo> tasks = new ArrayList<>();
    private void rethrottleTestCase(
                throw new RuntimeException("Expected no interactions but got [" + response + "]");
    }
 * Unless required by applicable law or agreed to in writing,
        ActionListener<TaskInfo> listener = mock(ActionListener.class);
import org.opensearch.transport.client.Client;
        rethrottleTestCase(
                    "test",
                    0,
/*
            listener -> { /* There are no async tasks to simulate because the listener is called for us. */},
 */
        verify(listener, atMost(1)).onFailure(failure.capture());
 * ownership. Elasticsearch licenses this file to you under
        }
 */
        List<TaskInfo> tasks = new ArrayList<>();
                    "test",
            expectException(hasToString(containsString("Rethrottle of [test:123] failed")))
            assertThat(failure.getValue(), exceptionMatcher);
                // The whole thing succeeded so we should have got the success
     * @param verifier verify the resulting response
        slices = between(2, 50);
            throw new AssertionError(failure.getValue());
                captureResponse(BulkByScrollResponse.class, listener).getStatus();
                    true,
    public void testRethrottleCatastrophicFailures() {
                    "test",
            slices,
        for (int i = 0; i < slices; i++) {
    /**
        verifier.accept(listener);
                    new TaskId("test", task.getId()),
        }
 * the Apache License, Version 2.0 (the "License"); you may
            expectException(theInstance(e))
    private <T> ActionListener<T> neverCalled() {
     */
        String localNodeId = randomAlphaOfLength(5);
    }
        return new BulkByScrollTask.Status(sliceId, 10, 10, 0, 0, 0, 0, 0, 0, 0, timeValueMillis(0), 0, null, timeValueMillis(0));
package org.opensearch.index.reindex;
                    null
            assertEquals(new TaskId(localNodeId, task.getId()), subRequest.getValue().getParentTaskId());
    public void testRethrottleNodeFailure() {
 * this work for additional information regarding copyright
import org.junit.Before;
        ArgumentCaptor<RethrottleRequest> subRequest = ArgumentCaptor.forClass(RethrottleRequest.class);
            expectSuccessfulRethrottleWithStatuses(sliceStatuses)
    public void createTask() {
        rethrottleTestCase(slices, listener -> listener.onFailure(e), expectException(theInstance(e)));
            @SuppressWarnings("unchecked")
            task.getLeaderState()
                new TaskInfo(
                    status,
        ArgumentCaptor<ActionListener<ListTasksResponse>> subListener = ArgumentCaptor.forClass((Class) ActionListener.class);
    private Consumer<ActionListener<TaskInfo>> expectException(Matcher<Exception> exceptionMatcher) {
        float newRequestsPerSecond = randomValueOtherThanMany(f -> f <= 0, () -> randomFloat());
        return listener -> {
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            listener -> listener.onResponse(new ListTasksResponse(emptyList(), emptyList(), singletonList(e))),
 * GitHub history for details.
import static org.mockito.Mockito.verify;
        rethrottleTestCase(
        @SuppressWarnings("unchecked")
            @Override
                    false,
import java.util.Collections;
    private <T> T captureResponse(Class<T> responseClass, ActionListener<T> listener) {
            simulator.accept(subListener.getValue());
 */
        if (runningSlices > 0) {
        return new BulkByScrollTask.Status(sliceId, 10, 0, 0, 0, 0, 0, 0, 0, 0, timeValueMillis(0), 0, null, timeValueMillis(0));
import static org.mockito.Mockito.atMost;
    }
            sliceStatuses.add(new BulkByScrollTask.StatusOrException(status));
    private BulkByScrollTask.Status believeableCompletedStatus(Integer sliceId) {
            BulkByScrollTask.Status status = believeableCompletedStatus(i);
        return response.getValue();
import org.opensearch.core.action.ActionListener;
import java.util.ArrayList;
            tasks.add(
                    0,
        }
        List<BulkByScrollTask.StatusOrException> sliceStatuses = new ArrayList<>(slices);
        int runningSlices,
 * not use this file except in compliance with the License.
        task.setWorkerCount(slices);
                    false,
import static org.hamcrest.Matchers.containsString;
        Consumer<ActionListener<TaskInfo>> verifier
        };
        int succeeded = between(1, slices - 1);
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
     * Test rethrottling.
                    "test",
 * under the License.
                    "test",
        ArgumentCaptor<T> response = ArgumentCaptor.forClass(responseClass);
        Exception e = new Exception();
    public void testRethrottleTaskOperationFailure() {
            TaskInfo taskInfo = captureResponse(TaskInfo.class, listener);
    ) {
import static java.util.Collections.singletonList;
 *
            }
                    null
import org.mockito.ArgumentCaptor;
import org.opensearch.tasks.TaskInfo;
            sliceStatuses.add(new BulkByScrollTask.StatusOrException(status));
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
