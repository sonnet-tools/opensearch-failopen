            @Override
    public static class TestRequest extends ActionRequest {
            }
            }
 */
        @Override
            String action,
            if (testFilter.callback == RequestOperation.LISTENER_FAILURE) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            String action,
            this.lastActionName = action;
import org.opensearch.common.settings.Settings;
        assertThat(finalTestFilters.size(), equalTo(expectedActionFilters.size()));
            }
import java.util.concurrent.atomic.AtomicInteger;
        volatile String lastActionName;
            @Override
                listener.onResponse(new TestResponse());
            orders.add(randomInt(10));
        ArrayList<RequestTestFilter> finalTestFilters = new ArrayList<>();
            assertThat(future.get(), notNullValue());
            Task task,
import org.opensearch.node.Node;
                ActionFilterChain<Request, Response> actionFilterChain
    }
            @Override
        RequestTestFilter(int order, RequestCallback callback) {
            assertThat(testFilter, equalTo(expectedActionFilters.get(i)));
        }
            @SuppressWarnings("unchecked")  // Safe because its all we test with
        final CountDownLatch latch = new CountDownLatch(additionalContinueCount + 1);
            protected void doExecute(Task task, TestRequest request, ActionListener<TestResponse> listener) {
        TransportAction<TestRequest, TestResponse> transportAction = new TransportAction<TestRequest, TestResponse>(
            @Override
            Task task,
            if (!(testFilter.callback == RequestOperation.CONTINUE_PROCESSING)) {
        volatile int executionToken = Integer.MAX_VALUE; // the filters that don't run will go last in the sorted list
        public <Request extends ActionRequest, Response extends ActionResponse> void apply(
import org.junit.After;
    public void testActionFiltersRequest() throws InterruptedException {
}
        }
        LISTENER_RESPONSE {
import java.util.concurrent.CopyOnWriteArrayList;
            this.runs.incrementAndGet();
import java.util.ArrayList;
        assertThat(failures.size(), equalTo(additionalContinueCount));
            ) {
            assertThat(failure, instanceOf(IllegalStateException.class));
        for (int i = 0; i < finalTestFilters.size(); i++) {
        private final RequestCallback callback;
        <Request extends ActionRequest, Response extends ActionResponse> void execute(
        }
            assertThat("shouldn't get here if an error is not expected " + e.getMessage(), errorExpected, equalTo(true));
import org.opensearch.action.ActionRequestValidationException;
                ActionListener<Response> listener,
                errorExpected = true;
        }
        CONTINUE_PROCESSING {
        public void writeTo(StreamOutput out) throws IOException {}
        String actionName = randomAlphaOfLength(randomInt(30));
    }
            expectedActionFilters.add(testFilter);
        }
            public <Request extends ActionRequest, Response extends ActionResponse> void execute(
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet())
            Request request,
        List<RequestTestFilter> testFiltersByLastExecution = new ArrayList<>();
        terminate(threadPool);
            filters.add(new RequestTestFilter(order, randomFrom(RequestOperation.values())));
                ActionFilterChain<Request, Response> actionFilterChain
                String action,
        transportAction.execute(new TestRequest(), future);
        ActionFilters actionFilters = new ActionFilters(filters);
import org.opensearch.tasks.Task;
            actionName,
                }
        };
    public void testTooManyContinueProcessingRequest() throws InterruptedException {
    private static class TestResponse extends ActionResponse {
import java.util.List;
            ActionFilterChain<Request, Response> actionFilterChain
        String actionName = randomAlphaOfLength(randomInt(30));
    public void init() throws Exception {
    }
            @Override
 * Unless required by applicable law or agreed to in writing,
/*
            assertThat(testFilter.runs.get(), equalTo(1));
import org.opensearch.OpenSearchTimeoutException;
import org.opensearch.core.common.io.stream.StreamOutput;
                actionFilterChain.proceed(task, action, request, listener);
        }
            }
                ActionListener<Response> listener,
                ActionFilterChain<Request, Response> actionFilterChain
        assertThat(responses.get(), equalTo(1));
                ActionListener<Response> listener,
            assertThat(testFilter.lastActionName, equalTo(actionName));
                Request request,
 * ownership. Elasticsearch licenses this file to you under
            RequestTestFilter testFilter = (RequestTestFilter) filter;
public class TransportActionFilterChainTests extends OpenSearchTestCase {
        final List<Throwable> failures = new CopyOnWriteArrayList<>();
import org.opensearch.core.action.ActionListener;
            this.callback.execute(task, action, request, listener, chain);
                ActionFilterChain<Request, Response> actionFilterChain
        PlainActionFuture<TestResponse> future = PlainActionFuture.newFuture();
            fail("timeout waiting for the filter to notify the listener as many times as expected");
        List<ActionFilter> expectedActionFilters = new ArrayList<>();
/*
import org.opensearch.action.ActionRequest;
        }, latch));
            }
        @Override
        }
        ) {
        ) {
        AtomicInteger runs = new AtomicInteger();
            return null;
        }
            public <Request extends ActionRequest, Response extends ActionResponse> void execute(
    @After
        try {
import java.util.Comparator;
        counter = new AtomicInteger();
import org.opensearch.tasks.TaskManager;
            ) {
        @Override
    }
        });
        @Override
            ) {
                listener.onFailure(new OpenSearchTimeoutException(""));
        boolean errorExpected = false;
            }
        }
            protected void doExecute(Task task, TestRequest request, ActionListener<TestResponse> listener) {
 *
            }
    }
                Task task,
        public int order() {
            if (!(testFilter.callback == RequestOperation.CONTINUE_PROCESSING)) {
import java.util.Collections;
                failures.add(e);
import java.util.HashSet;
package org.opensearch.action.support;
            }
            Request request,
        } catch (ExecutionException e) {
            this.executionToken = counter.incrementAndGet();
    private enum RequestOperation implements RequestCallback {
    private interface RequestCallback {
            finalTestFilters.add(testFilter);
 * under the License.
            }
import org.opensearch.action.LatchedActionListener;
        Set<ActionFilter> filters = new HashSet<>();
import java.util.concurrent.CountDownLatch;
import org.opensearch.test.OpenSearchTestCase;
                ActionListener<Response> listener,
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(testFilter.lastActionName, equalTo(actionName));
            ActionFilterChain<Request, Response> chain
    }
 *
        Set<ActionFilter> filters = new HashSet<>();
 * You may obtain a copy of the License at
                Task task,
        threadPool = new ThreadPool(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "TransportActionFilterChainTests").build());
                responses.incrementAndGet();
 * KIND, either express or implied.  See the License for the
        };
                for (int i = 0; i <= additionalContinueCount; i++) {
    public void shutdown() throws Exception {
 * this work for additional information regarding copyright
            public <Request extends ActionRequest, Response extends ActionResponse> void execute(
        ArrayList<ActionFilter> actionFiltersByOrder = new ArrayList<>(filters);
import org.junit.Before;
        while (orders.size() < numFilters) {
            this.callback = callback;
        ) {
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet())
                String action,
            actionFilters,
        assertThat(testFilter.runs.get(), equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
                ((ActionListener<TestResponse>) listener).onResponse(new TestResponse());
 * not use this file except in compliance with the License.
    }
        TransportAction<TestRequest, TestResponse> transportAction = new TransportAction<TestRequest, TestResponse>(
 *    http://www.apache.org/licenses/LICENSE-2.0
        },
        RequestTestFilter testFilter = new RequestTestFilter(randomInt(), new RequestCallback() {
        actionFiltersByOrder.sort(Comparator.comparingInt(ActionFilter::order));
                Task task,
            public void onFailure(Exception e) {
 */
    @Before
                    actionFilterChain.proceed(task, action, request, listener);
        for (ActionFilter filter : testFiltersByLastExecution) {
    private ThreadPool threadPool;
            @Override
            ActionListener<Response> listener,
                Request request,
            }
import org.opensearch.core.action.ActionResponse;
    private class RequestTestFilter implements ActionFilter {
        filters.add(testFilter);
 * Licensed to Elasticsearch under one or more contributor
            public void onResponse(TestResponse testResponse) {
        ActionFilters actionFilters = new ActionFilters(filters);
        for (Integer order : orders) {
import java.util.concurrent.ExecutionException;
        }
                Request request,
        final AtomicInteger responses = new AtomicInteger();
            actionFilters,
        for (ActionFilter actionFilter : actionFilters.filters()) {
import java.io.IOException;
    private AtomicInteger counter;
import static org.hamcrest.CoreMatchers.instanceOf;
            public <Request extends ActionRequest, Response extends ActionResponse> void execute(
        }
            }
            ) {
        }
 * The OpenSearch Contributors require contributions made to
            this.order = order;
import org.opensearch.threadpool.ThreadPool;
 * Modifications Copyright OpenSearch Contributors. See
            @Override
                break;
        public ActionRequestValidationException validate() {
import java.util.Set;
        private final int order;
        }
            return order;
 */
            @Override
    }
            actionName,
        for (ActionFilter filter : actionFiltersByOrder) {
        for (Throwable failure : failures) {
        );
            RequestTestFilter testFilter = finalTestFilters.get(i);
                Request request,
            ActionListener<Response> listener,
        testFiltersByLastExecution.sort(Comparator.comparingInt(o -> o.executionToken));
    }
        final int additionalContinueCount = randomInt(10);
import static org.hamcrest.CoreMatchers.notNullValue;
 * specific language governing permissions and limitations
/*
            testFiltersByLastExecution.add((RequestTestFilter) actionFilter);
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
        if (!latch.await(10, TimeUnit.SECONDS)) {
        int numFilters = randomInt(10);
        LISTENER_FAILURE {
                listener.onResponse(new TestResponse());
            RequestTestFilter testFilter = (RequestTestFilter) filter;
                Task task,
 *
        }
        transportAction.execute(new TestRequest(), new LatchedActionListener<>(new ActionListener<TestResponse>() {
 * GitHub history for details.
import static org.hamcrest.CoreMatchers.equalTo;
        Set<Integer> orders = new HashSet<>(numFilters);
 * SPDX-License-Identifier: Apache-2.0
            assertThat("shouldn't get here if an error is expected", errorExpected, equalTo(false));
import java.util.concurrent.TimeUnit;
                String action,
                String action,
            ActionRequestMetadata<Request, Response> actionRequestMetadata,
 * software distributed under the License is distributed on an
        },
                break;
