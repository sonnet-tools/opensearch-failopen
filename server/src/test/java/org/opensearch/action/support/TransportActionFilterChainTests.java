    @After  
                Request request,
                ActionListener<Response> listener,  
        PlainActionFuture<TestResponse> future = PlainActionFuture.newFuture();
        } catch (ExecutionException e) {
 */  
}
            assertThat(testFilter, equalTo(expectedActionFilters.get(i)));  
    public void testActionFiltersRequest() throws InterruptedException {
 * You may obtain a copy of the License at  
        final CountDownLatch latch = new CountDownLatch(additionalContinueCount + 1);
        TransportAction<TestRequest, TestResponse> transportAction = new TransportAction<TestRequest, TestResponse>(
import org.opensearch.test.OpenSearchTestCase;  
                }
            }  
            }
        volatile int executionToken = Integer.MAX_VALUE; // the filters that don't run will go last in the sorted list  
        final List<Throwable> failures = new CopyOnWriteArrayList<>();  
                String action,  
            actionName,
            filters.add(new RequestTestFilter(order, randomFrom(RequestOperation.values())));
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet())
    }
import java.util.Comparator;
        };
        assertThat(testFilter.lastActionName, equalTo(actionName));
 *
 * specific language governing permissions and limitations
        }
import static org.hamcrest.CoreMatchers.notNullValue;
        AtomicInteger runs = new AtomicInteger();
                listener.onResponse(new TestResponse());  
            return order;  
 * license agreements. See the NOTICE file distributed with
        }
import org.opensearch.action.ActionRequest;
            assertThat("shouldn't get here if an error is expected", errorExpected, equalTo(false));  
                String action,
        transportAction.execute(new TestRequest(), new LatchedActionListener<>(new ActionListener<TestResponse>() {
            if (!(testFilter.callback == RequestOperation.CONTINUE_PROCESSING)) {
                Request request,
 * under the License.  
        for (ActionFilter actionFilter : actionFilters.filters()) {  
    }
                String action,
            }  
 * the Apache License, Version 2.0 (the "License"); you may
            Task task,
            public <Request extends ActionRequest, Response extends ActionResponse> void execute(
        });
public class TransportActionFilterChainTests extends OpenSearchTestCase {
            expectedActionFilters.add(testFilter);
        ) {  
        boolean errorExpected = false;
        }
        assertThat(finalTestFilters.size(), equalTo(expectedActionFilters.size()));  
            if (!(testFilter.callback == RequestOperation.CONTINUE_PROCESSING)) {
        for (Throwable failure : failures) {
        };
                failures.add(e);
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet())
import org.opensearch.node.Node;  
            fail("timeout waiting for the filter to notify the listener as many times as expected");  
    private class RequestTestFilter implements ActionFilter {
        ) {
            public <Request extends ActionRequest, Response extends ActionResponse> void execute(
import java.util.concurrent.CopyOnWriteArrayList;  
        public <Request extends ActionRequest, Response extends ActionResponse> void apply(
 * SPDX-License-Identifier: Apache-2.0
        RequestTestFilter(int order, RequestCallback callback) {
                ActionListener<Response> listener,  
            Task task,
            @Override  
            return null;  
import org.junit.Before;  
    }  
        try {
        public int order() {
        }
            ActionFilterChain<Request, Response> chain
import org.opensearch.core.action.ActionListener;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collections;
            RequestTestFilter testFilter = finalTestFilters.get(i);
            orders.add(randomInt(10));  
            testFiltersByLastExecution.add((RequestTestFilter) actionFilter);
        },
        ArrayList<RequestTestFilter> finalTestFilters = new ArrayList<>();  
            @SuppressWarnings("unchecked")  // Safe because its all we test with
        }, latch));  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
        private final int order;  
            @Override  
        }
        List<ActionFilter> expectedActionFilters = new ArrayList<>();  
    public static class TestRequest extends ActionRequest {  
/*  
        assertThat(testFilter.runs.get(), equalTo(1));  
 * Modifications Copyright OpenSearch Contributors. See
            }  
        public void writeTo(StreamOutput out) throws IOException {}  
    private static class TestResponse extends ActionResponse {
            }
            ActionListener<Response> listener,  
        @Override  
    private interface RequestCallback {
        RequestTestFilter testFilter = new RequestTestFilter(randomInt(), new RequestCallback() {  
    public void init() throws Exception {
import org.opensearch.threadpool.ThreadPool;
                break;  
import org.opensearch.OpenSearchTimeoutException;
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;
        }
                errorExpected = true;  
            assertThat(testFilter.runs.get(), equalTo(1));
            this.callback = callback;
        LISTENER_RESPONSE {
import static org.hamcrest.CoreMatchers.equalTo;  
        private final RequestCallback callback;
        LISTENER_FAILURE {  
import java.util.ArrayList;  
        public ActionRequestValidationException validate() {
            this.callback.execute(task, action, request, listener, chain);  
        Set<Integer> orders = new HashSet<>(numFilters);
        int numFilters = randomInt(10);  
    }  
        actionFiltersByOrder.sort(Comparator.comparingInt(ActionFilter::order));
        terminate(threadPool);
            ActionListener<Response> listener,
 * this work for additional information regarding copyright
        }
                ActionListener<Response> listener,  
    }
 * not use this file except in compliance with the License.
        @Override
            }
        TransportAction<TestRequest, TestResponse> transportAction = new TransportAction<TestRequest, TestResponse>(
                Task task,  
                ActionFilterChain<Request, Response> actionFilterChain
            @Override  
    public void shutdown() throws Exception {
            assertThat(future.get(), notNullValue());
    private enum RequestOperation implements RequestCallback {
            protected void doExecute(Task task, TestRequest request, ActionListener<TestResponse> listener) {
import org.opensearch.tasks.Task;
 */
            this.runs.incrementAndGet();  
import org.opensearch.core.action.ActionResponse;
            ) {
            public void onFailure(Exception e) {  
    }
        filters.add(testFilter);
                Request request,
                Task task,
        }  
            @Override
                break;
        @Override
        ActionFilters actionFilters = new ActionFilters(filters);  
            String action,
        transportAction.execute(new TestRequest(), future);  
        }
 * software distributed under the License is distributed on an
import java.util.concurrent.CountDownLatch;
    @Before  
            public <Request extends ActionRequest, Response extends ActionResponse> void execute(
 */  
        String actionName = randomAlphaOfLength(randomInt(30));
        ArrayList<ActionFilter> actionFiltersByOrder = new ArrayList<>(filters);  
import org.opensearch.action.LatchedActionListener;
                Task task,  
        while (orders.size() < numFilters) {
            this.order = order;  
            String action,  
    }
 * compatible open source license.
            this.executionToken = counter.incrementAndGet();
            assertThat(failure, instanceOf(IllegalStateException.class));  
        final AtomicInteger responses = new AtomicInteger();
            }
 *
import java.util.Set;
                for (int i = 0; i <= additionalContinueCount; i++) {  
            if (testFilter.callback == RequestOperation.LISTENER_FAILURE) {
import java.util.concurrent.ExecutionException;
            RequestTestFilter testFilter = (RequestTestFilter) filter;
 * this file be licensed under the Apache-2.0 license or a
        }  
    private ThreadPool threadPool;
            @Override  
            }
import java.util.concurrent.atomic.AtomicInteger;
            }  
        }
                ActionFilterChain<Request, Response> actionFilterChain  
            @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            ) {
import java.util.concurrent.TimeUnit;  
        for (Integer order : orders) {
import org.opensearch.action.ActionRequestValidationException;  
import static org.hamcrest.CoreMatchers.instanceOf;
        for (int i = 0; i < finalTestFilters.size(); i++) {
    }
        Set<ActionFilter> filters = new HashSet<>();  
            ActionFilterChain<Request, Response> actionFilterChain
            @Override
                actionFilterChain.proceed(task, action, request, listener);
                ((ActionListener<TestResponse>) listener).onResponse(new TestResponse());  
        for (ActionFilter filter : testFiltersByLastExecution) {
        assertThat(responses.get(), equalTo(1));  
        List<RequestTestFilter> testFiltersByLastExecution = new ArrayList<>();
package org.opensearch.action.support;
                String action,
        },
                listener.onResponse(new TestResponse());
            Request request,  
        assertThat(failures.size(), equalTo(additionalContinueCount));
/*  
        if (!latch.await(10, TimeUnit.SECONDS)) {
import java.util.List;
        ActionFilters actionFilters = new ActionFilters(filters);
        );  
        volatile String lastActionName;
            }  
        threadPool = new ThreadPool(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "TransportActionFilterChainTests").build());  
        ) {
        CONTINUE_PROCESSING {
                ActionFilterChain<Request, Response> actionFilterChain
            public <Request extends ActionRequest, Response extends ActionResponse> void execute(
        }
                responses.incrementAndGet();
        for (ActionFilter filter : actionFiltersByOrder) {
        counter = new AtomicInteger();
            Request request,
        Set<ActionFilter> filters = new HashSet<>();  
    private AtomicInteger counter;  
        testFiltersByLastExecution.sort(Comparator.comparingInt(o -> o.executionToken));
import org.opensearch.tasks.TaskManager;
            ActionRequestMetadata<Request, Response> actionRequestMetadata,
            actionFilters,  
            assertThat(testFilter.lastActionName, equalTo(actionName));
import org.junit.After;
    }
            actionName,  
        }  
            assertThat("shouldn't get here if an error is not expected " + e.getMessage(), errorExpected, equalTo(true));
            ) {
 * ownership. Elasticsearch licenses this file to you under  
                Task task,  
        }
            public void onResponse(TestResponse testResponse) {
 * KIND, either express or implied.  See the License for the
        <Request extends ActionRequest, Response extends ActionResponse> void execute(  
            protected void doExecute(Task task, TestRequest request, ActionListener<TestResponse> listener) {
            actionFilters,
 *  
                Request request,
                ActionFilterChain<Request, Response> actionFilterChain
                ActionListener<Response> listener,
 * The OpenSearch Contributors require contributions made to  
    public void testTooManyContinueProcessingRequest() throws InterruptedException {  
import org.opensearch.common.settings.Settings;
            }
            @Override
        @Override
        String actionName = randomAlphaOfLength(randomInt(30));  
            ) {
                    actionFilterChain.proceed(task, action, request, listener);
import java.util.HashSet;  
            finalTestFilters.add(testFilter);  
 * Unless required by applicable law or agreed to in writing,
                listener.onFailure(new OpenSearchTimeoutException(""));  
            this.lastActionName = action;
            RequestTestFilter testFilter = (RequestTestFilter) filter;  
        final int additionalContinueCount = randomInt(10);
