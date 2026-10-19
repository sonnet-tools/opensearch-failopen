        );
 * The OpenSearch Contributors require contributions made to  
            assertEquals(action, this.action);  
    public void testStartScrollDone() throws InterruptedException {  
    }
        SearchHits hits = new SearchHits(
        hitSource.start();
    private static class ExecuteRequest<Request extends ActionRequest, Response extends ActionResponse> {
    }
            r -> fail(),
        TaskId parentTask = new TaskId("thenode", randomInt());
            new ParentTaskAssigningClient(client, parentTask),
        int expectedSearchRetries = 0;
    }
        // create a simulated response.
import org.opensearch.threadpool.TestThreadPool;  
 * software distributed under the License is distributed on an
import org.junit.Before;
            0
    @After  
        MockClient client = new MockClient(threadPool);  
        private final ActionListener<Response> listener;
import org.opensearch.core.common.bytes.BytesArray;
            super(Settings.EMPTY, threadPool);  
        public <Response extends ActionResponse> void fail(ActionType<Response> action, Exception response) {
            ((ExecuteRequest<Request, Response>) executeRequest).validateRequest(action, validator);
    }  
        ) {  
    @Before
            ExecuteRequest<?, ?> executeRequest;  
import org.opensearch.common.settings.Settings;
 */  
            0,  
            }
 * ownership. Elasticsearch licenses this file to you under  
        @SuppressWarnings("unchecked")
 * KIND, either express or implied.  See the License for the
            new TotalHits(0, TotalHits.Relation.EQUAL_TO),  
import org.opensearch.core.tasks.TaskId;
        private final Request request;
            ((ExecuteRequest<Request, Response>) executeRequest).respond(action, response);  
            ActionType<Response> action,
        client.respond(SearchAction.INSTANCE, searchResponse);
    private static class MockClient extends AbstractClient {
        ) {
            e -> fail(),  
        assertEquals(actual.size(), expected.length);
import org.opensearch.common.unit.TimeValue;
import org.opensearch.action.search.SearchScrollRequest;  
import org.opensearch.threadpool.ThreadPool;
            assertNotNull(asyncResponse);
                executeRequest = this.executeRequest;  
            assertEquals(actual.get(i).getPrimaryTerm(), expected[i].getPrimaryTerm());
    public void testScrollKeepAlive() {
        protected synchronized <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
 * specific language governing permissions and limitations
import org.opensearch.action.ActionType;  
        }
            assertEquals(actual.get(i).getVersion(), expected[i].getVersion());  
import org.opensearch.core.action.ActionResponse;
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
            responses::add,
        assertEquals(actualSearchRetries.get(), expectedSearchRetries);
import java.util.concurrent.atomic.AtomicInteger;
/*  
                this.executeRequest = null;
        InternalSearchResponse internalResponse = new InternalSearchResponse(hits, null, null, null, false, false, 1);  
            this.action = action;
/*
    private static class ExpectedException extends RuntimeException {  
            ++expectedSearchRetries;  
                this.executeRequest = null;  
            synchronized (this) {
    }  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            actualSearchRetries::incrementAndGet,
        return new SearchResponse(
        }  
/*  
        dotestBasicsWithRetry(0, 0, 0, e -> fail());
            searchResponse = createSearchResponse();
        public void respond(ActionType<Response> action, Function<Request, Response> response) {
            ScrollableHitSource.AsyncResponse asyncResponse = responses.poll(10, TimeUnit.SECONDS);
            assertEquals(actual.get(i).getSeqNo(), expected[i].getSeqNo());
            Consumer<? super Request> validator
            assertEquals(action, this.action);
            this.request = request;  
import org.opensearch.search.internal.InternalSearchResponse;
 * under the License.  
        for (int i = 0; i < actual.size(); ++i) {  
import org.opensearch.search.SearchHits;  
        }  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
    }
            }
            threadPool,  
    private SearchResponse createSearchResponse() {
        assertThat(ex.getCause(), instanceOf(OpenSearchRejectedExecutionException.class));
            new ParentTaskAssigningClient(client, parentTask),
            4,
            logger,
        public <Request extends ActionRequest, Response extends ActionResponse> void respondx(  
            assertEquals(actual.get(i).getSource(), expected[i].getSourceRef());
        SearchHit hit = new SearchHit(0, "id", emptyMap(), emptyMap()).sourceRef(new BytesArray("{}"));  
 * this work for additional information regarding copyright
            5,
        public void fail(ActionType<Response> action, Exception response) {  
            if (executeRequest == null) {
        int retries = randomIntBetween(1, 10);
    private void assertSameHits(List<? extends ScrollableHitSource.Hit> actual, SearchHit[] expected) {
                wait(10000);  
        BlockingQueue<ScrollableHitSource.AsyncResponse> responses = new ArrayBlockingQueue<>(100);
            assertEquals(actual.get(i).getIndex(), expected[i].getIndex());
        SearchResponse searchResponse = createSearchResponse();  
        ClientScrollableHitSource hitSource = new ClientScrollableHitSource(  
            logger,
    private ThreadPool threadPool;
        ClientScrollableHitSource hitSource = new ClientScrollableHitSource(  
            Function<Request, Response> response
}
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
 * license agreements. See the NOTICE file distributed with
        }
            IntStream.range(0, randomIntBetween(0, 20)).mapToObj(i -> hit).toArray(SearchHit[]::new),
 * not use this file except in compliance with the License.
            ActionType<Response> action,
            assertEquals(action, this.action);
            new SearchRequest().scroll("1m")
            respondx(action, req -> response);
            ActionType<Response> action,
        public void validateRequest(ActionType<Response> action, Consumer<? super Request> validator) {
            assertEquals(actual.get(i).getIndex(), expected[i].getIndex());
        ExpectedException(Throwable cause) {
            listener.onResponse(response.apply(request));  
            }
                executeRequest = this.executeRequest;
 *
        );
        private ExecuteRequest<?, ?> executeRequest;  
        client.validateRequest(SearchAction.INSTANCE, (SearchRequest r) -> assertTrue(r.allowPartialSearchResults() == Boolean.FALSE));
import org.opensearch.action.search.SearchAction;
            this.notifyAll();
import static org.hamcrest.Matchers.instanceOf;  
        ExecuteRequest(ActionType<Response> action, Request request, ActionListener<Response> listener) {
    // ensure we test the happy path on every build.
    }
import java.util.function.Function;
            null,
        @SuppressWarnings("unchecked")
            Request request,  
        throws InterruptedException {  
        ) {  
import static java.util.Collections.emptyMap;
import org.apache.lucene.search.TotalHits;
        }
        @Override
import java.util.concurrent.BlockingQueue;  
        );  
        public void close() {}
                assertNotNull("Must receive next request within 10s", executeRequest);
public class ClientScrollableHitSourceTests extends OpenSearchTestCase {  
import org.opensearch.transport.client.ParentTaskAssigningClient;
        public <Response extends ActionResponse> void respond(ActionType<Response> action, Response response) {  
import org.opensearch.action.search.SearchResponse;
            super(cause);
        int retries = randomInt(10);
        }
            new SearchRequest().scroll(timeValueSeconds(10))  
        @SuppressWarnings("unchecked")
        TaskId parentTask = new TaskId("thenode", randomInt());  
import org.opensearch.search.SearchHit;
import java.util.function.Consumer;  
            ActionListener<Response> listener
        );
        MockClient(ThreadPool threadPool) {
            randomLong(),
    private void dotestBasicsWithRetry(int retries, int minFailures, int maxFailures, Consumer<Exception> failureHandler)
            BackoffPolicy.constantBackoff(TimeValue.ZERO, retries),
            listener.onFailure(response);
 */
            assertEquals(actual.get(i).getId(), expected[i].getId());  
            for (int retry = 0; retry < randomIntBetween(minFailures, maxFailures); ++retry) {
            client.fail(SearchAction.INSTANCE, new OpenSearchRejectedExecutionException());
                client.fail(SearchScrollAction.INSTANCE, new OpenSearchRejectedExecutionException());
        }
            this.executeRequest = new ExecuteRequest<>(action, request, listener);
 * GitHub history for details.
            BackoffPolicy.constantBackoff(TimeValue.ZERO, 0),
            randomSimpleString(random(), 1, 10),  
        }  
    }  
import java.util.concurrent.ArrayBlockingQueue;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
            assertEquals(responses.size(), 0);  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.reindex;
 * Licensed to Elasticsearch under one or more contributor  
        hitSource.startNextScroll(timeValueSeconds(100));  
        }  
            ExecuteRequest<?, ?> executeRequest;
            threadPool,  
        }
        terminate(threadPool);
        public <Request extends ActionRequest, Response extends ActionResponse> void validateRequest(  
            failureHandler,  
        }  
        });
    public void setUpThreadPool() {
 *
                ++expectedSearchRetries;
        private final ActionType<Response> action;  
        }  
import java.util.stream.IntStream;
            // Set the base for the scroll to wait - this is added to the figure we calculate below
import java.util.List;
import org.opensearch.action.ActionRequest;
                client.awaitOperation();  
        MockClient client = new MockClient(threadPool);
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
            client.awaitOperation();
 * You may obtain a copy of the License at  
        ExpectedException ex = expectThrows(ExpectedException.class, () -> {
        }
    }
            dotestBasicsWithRetry(retries, retries + 1, retries + 1, e -> { throw new ExpectedException(e); });  
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.TimeUnit;
import org.junit.After;
        for (int i = 0; i < randomIntBetween(1, 10); ++i) {  
            validator.accept(request);
        AtomicInteger actualSearchRetries = new AtomicInteger();
            SearchResponse.Clusters.EMPTY  
        client.validateRequest(SearchScrollAction.INSTANCE, (SearchScrollRequest r) -> assertEquals(r.scroll().keepAlive().seconds(), 110));
            internalResponse,
            asyncResponse.done(TimeValue.ZERO);
 * the Apache License, Version 2.0 (the "License"); you may
        for (int retry = 0; retry < randomIntBetween(minFailures, maxFailures); ++retry) {  
import org.opensearch.action.bulk.BackoffPolicy;
            }
            synchronized (this) {
            ((ExecuteRequest<?, Response>) executeRequest).fail(action, response);
 */  
    public void testRetryFail() {  
        threadPool = new TestThreadPool(getTestName());  
    public void tearDownThreadPool() {
import org.opensearch.core.action.ActionListener;  
    }  
            () -> fail(),
        dotestBasicsWithRetry(retries, 0, retries, e -> fail());  
            this.listener = listener;
import org.opensearch.transport.client.support.AbstractClient;  
            client.respond(SearchScrollAction.INSTANCE, searchResponse);
        @Override  
import org.opensearch.action.search.SearchScrollAction;
    public void testRetrySuccess() throws InterruptedException {
    }  
        public synchronized void awaitOperation() throws InterruptedException {
    }
        }
            assertSameHits(asyncResponse.response().getHits(), searchResponse.getHits().getHits());
import org.opensearch.action.search.SearchRequest;  
