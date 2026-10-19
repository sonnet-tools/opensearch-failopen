        for (int i = succeeded; i < slices; i++) {
        }
            sliceStatuses.add(new BulkByScrollTask.StatusOrException(status));
    }
        verify(listener, atMost(1)).onFailure(failure.capture());
import org.opensearch.action.TaskOperationFailure;
    public void createTask() {
            simulator.accept(subListener.getValue());
    }
        );
 *
 */  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;  
        List<BulkByScrollTask.StatusOrException> sliceStatuses = new ArrayList<>(slices);
        ActionListener<TaskInfo> listener = mock(ActionListener.class);
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
            slices - succeeded,
        Consumer<ActionListener<ListTasksResponse>> simulator,
                    Collections.emptyMap(),
                throw new RuntimeException("Expected no interactions but got [" + response + "]");  
            tasks.add(
    public void testRethrottleWithAllSucceeded() {
            task.getLeaderState()
        );  
                    false,
        rethrottleTestCase(  
                    null  
                    status,  
import static org.mockito.Mockito.verify;
                    "test",  
            @Override
                // The whole thing succeeded so we should have got the success
        List<BulkByScrollTask.StatusOrException> sliceStatuses
    @Before
     * @param runningSlices the number of slices still running
            tasks.add(  
 *  
                )
 * compatible open source license.
                    new TaskId("test", task.getId()),
public class TransportRethrottleActionTests extends OpenSearchTestCase {  
        );
        TaskOperationFailure failure = new TaskOperationFailure("test", 123, e);
import static org.mockito.Mockito.eq;
        }
    }  
    }
                    false,  
        };  
    public void testRethrottleWithSomeSucceeded() {  
    }
        verifier.accept(listener);  
        );  
    }
    }
            assertEquals(newRequestsPerSecond / runningSlices, subRequest.getValue().getRequestsPerSecond(), 0.00001f);
        verify(listener).onResponse(response.capture());  
import java.util.List;
import org.opensearch.transport.client.Client;
            listener -> listener.onResponse(new ListTasksResponse(emptyList(), emptyList(), singletonList(e))),
        int succeeded = between(1, slices - 1);
        }
            assertEquals(sliceStatuses, ((BulkByScrollTask.Status) taskInfo.getStatus()).getSliceStatuses());
 *    http://www.apache.org/licenses/LICENSE-2.0
                    "test",  
    public void testRethrottleSuccessfulResponse() {  
import static java.util.Collections.emptyList;
    private void rethrottleTestCase(
/*
            task.getLeaderState()
    private <T> ActionListener<T> neverCalled() {
            TaskInfo taskInfo = captureResponse(TaskInfo.class, listener);
 */
            BulkByScrollTask.Status status = believeableInProgressStatus(i);
            );
                new TaskInfo(
                    "test",
    /**
            BulkByScrollTask.Status status = believeableInProgressStatus(i);
import static org.hamcrest.Matchers.containsString;
                throw new RuntimeException("Expected no interations but was received a failure", e);
import org.opensearch.tasks.TaskInfo;  
    public void testRethrottleNodeFailure() {  
            0,
            }  
        List<TaskInfo> tasks = new ArrayList<>();
            }  
    private Consumer<ActionListener<TaskInfo>> expectException(Matcher<Exception> exceptionMatcher) {
    public void testRethrottleCatastrophicFailures() {  
        TransportRethrottleAction.rethrottle(logger, localNodeId, client, task, newRequestsPerSecond, listener);
            }
        int runningSlices,  
        return response.getValue();
 * You may obtain a copy of the License at  
                    "test",
                )
import org.junit.Before;
        Exception e = new Exception();
}  
import static org.mockito.Mockito.atMost;
            @SuppressWarnings("unchecked")
            ActionListener<BulkByScrollResponse> listener = i < slices - 1 ? neverCalled() : mock(ActionListener.class);
    private BulkByScrollTask.Status believeableInProgressStatus(Integer sliceId) {  
                .onSliceResponse(listener, i, new BulkByScrollResponse(timeValueMillis(10), status, emptyList(), emptyList(), false));
        rethrottleTestCase(
            expectSuccessfulRethrottleWithStatuses(sliceStatuses)
        rethrottleTestCase(
 * Licensed to Elasticsearch under one or more contributor  
        // Rethrow any failures just so we get a nice exception if there were any. We don't expect any though.  
    private Consumer<ActionListener<TaskInfo>> expectSuccessfulRethrottleWithStatuses(  
        Exception e = new Exception();  
import java.util.Collections;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
import static java.util.Collections.singletonList;
            listener -> listener.onResponse(new ListTasksResponse(tasks, emptyList(), emptyList())),
        rethrottleTestCase(  
                    Collections.emptyMap(),  
                    0,
/*  
        if (false == failure.getAllValues().isEmpty()) {
import static org.hamcrest.Matchers.hasToString;
                    true,
 * this work for additional information regarding copyright
                    new TaskId("test", 123),
        slices = between(2, 50);  
        return listener -> {  
        List<BulkByScrollTask.StatusOrException> sliceStatuses = new ArrayList<>(slices);
        rethrottleTestCase(
                    true,  
import java.util.ArrayList;  
        ArgumentCaptor<T> response = ArgumentCaptor.forClass(responseClass);
        @SuppressWarnings({ "unchecked", "rawtypes" }) // Magical generics incantation.....
                    0,
            public void onFailure(Exception e) {
            listener -> listener.onResponse(new ListTasksResponse(tasks, emptyList(), emptyList())),
        List<BulkByScrollTask.StatusOrException> sliceStatuses = new ArrayList<>(slices);
            );  
            listener -> { /* There are no async tasks to simulate because the listener is called for us. */},
 * the Apache License, Version 2.0 (the "License"); you may
            expectSuccessfulRethrottleWithStatuses(sliceStatuses)  
 * software distributed under the License is distributed on an
    private <T> T captureResponse(Class<T> responseClass, ActionListener<T> listener) {
        );  
            expectException(hasToString(containsString("Rethrottle of [test:123] failed")))
            slices,  
    }
 * this file be licensed under the Apache-2.0 license or a
            sliceStatuses.add(new BulkByScrollTask.StatusOrException(status));
            assertThat(failure.getValue(), exceptionMatcher);
        task = new BulkByScrollTask(1, "test_type", "test_action", "test", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
 * under the License.  
                    new TaskId("test", task.getId()),
            ArgumentCaptor<Exception> failure = ArgumentCaptor.forClass(Exception.class);  
    }
                    "test",
        ArgumentCaptor<Exception> failure = ArgumentCaptor.forClass(Exception.class);
 * ownership. Elasticsearch licenses this file to you under  
            BulkByScrollTask.Status status = believeableCompletedStatus(i);  
                    status,
import org.opensearch.test.OpenSearchTestCase;
        if (runningSlices > 0) {
            sliceStatuses.add(new BulkByScrollTask.StatusOrException(status));
    }
            slices,  
    }
                    0,
import org.hamcrest.Matcher;  
        @SuppressWarnings("unchecked")
                    new TaskId("test", 123),
        }
        float newRequestsPerSecond = randomValueOtherThanMany(f -> f <= 0, () -> randomFloat());  
        };
import org.opensearch.action.FailedNodeException;
        return new BulkByScrollTask.Status(sliceId, 10, 10, 0, 0, 0, 0, 0, 0, 0, timeValueMillis(0), 0, null, timeValueMillis(0));
                new TaskInfo(  
    private BulkByScrollTask.Status believeableCompletedStatus(Integer sliceId) {
            expectException(theInstance(e))
            assertEquals(new TaskId(localNodeId, task.getId()), subRequest.getValue().getParentTaskId());
                    "test",
            sliceStatuses.add(new BulkByScrollTask.StatusOrException(status));  
    }
            @Override  
        for (int i = 0; i < succeeded; i++) {  
     * @param simulator simulate a response from the sub-request to rethrottle the child requests
        Consumer<ActionListener<TaskInfo>> verifier
 * not use this file except in compliance with the License.
        List<TaskInfo> tasks = new ArrayList<>();  
 * license agreements. See the NOTICE file distributed with
                captureResponse(BulkByScrollResponse.class, listener).getStatus();
import java.util.function.Consumer;  
 * GitHub history for details.
        };  
        Client client = mock(Client.class);
     */
            if (i == slices - 1) {  
 * SPDX-License-Identifier: Apache-2.0
        }
        ArgumentCaptor<ActionListener<ListTasksResponse>> subListener = ArgumentCaptor.forClass((Class) ActionListener.class);  
        for (int i = 0; i < slices; i++) {  
        // Capture the sub request and the listener so we can verify they are sane  
    public void testRethrottleTaskOperationFailure() {
/*  
            verify(client).execute(eq(RethrottleAction.INSTANCE), subRequest.capture(), subListener.capture());
                .onSliceResponse(neverCalled(), i, new BulkByScrollResponse(timeValueMillis(10), status, emptyList(), emptyList(), false));  
        return new ActionListener<T>() {  
    }  
    }  
import org.opensearch.core.action.ActionListener;
        return new BulkByScrollTask.Status(sliceId, 10, 0, 0, 0, 0, 0, 0, 0, 0, timeValueMillis(0), 0, null, timeValueMillis(0));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.tasks.TaskId;
    ) {
        return listener -> {
            slices,  
    ) {  
        }
import org.mockito.ArgumentCaptor;
import static org.hamcrest.Matchers.theInstance;  
            verify(listener).onFailure(failure.capture());
    private BulkByScrollTask task;
    private int slices;
        rethrottleTestCase(slices, listener -> listener.onFailure(e), expectException(theInstance(e)));
                    null
import static org.mockito.Mockito.mock;  
        String localNodeId = randomAlphaOfLength(5);
package org.opensearch.index.reindex;
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        task.setWorkerCount(slices);
            listener -> listener.onResponse(new ListTasksResponse(emptyList(), singletonList(failure), emptyList())),
 * specific language governing permissions and limitations
                    0,  
        ArgumentCaptor<RethrottleRequest> subRequest = ArgumentCaptor.forClass(RethrottleRequest.class);
     * @param verifier verify the resulting response  
            BulkByScrollTask.Status status = believeableCompletedStatus(i);
        FailedNodeException e = new FailedNodeException("test", "test", new Exception());
            expectSuccessfulRethrottleWithStatuses(sliceStatuses)  
 */  
            public void onResponse(T response) {
            throw new AssertionError(failure.getValue());  
        for (int i = 0; i < slices; i++) {  
     * Test rethrottling.  
