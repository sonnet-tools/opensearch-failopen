            responses::add,
import org.junit.After;
        private ExecuteRequest<?, ?> executeRequest;
import static org.hamcrest.Matchers.instanceOf;
        }
 */
import java.util.List;
            assertSameHits(asyncResponse.response().getHits(), searchResponse.getHits().getHits());
            assertEquals(actual.get(i).getSource(), expected[i].getSourceRef());
            super(Settings.EMPTY, threadPool);
            internalResponse,
        client.respond(SearchAction.INSTANCE, searchResponse);
/*
            assertEquals(action, this.action);
        MockClient(ThreadPool threadPool) {
import org.opensearch.transport.client.support.AbstractClient;
 * under the License.
            null,
            0,
    private SearchResponse createSearchResponse() {
        MockClient client = new MockClient(threadPool);
 * GitHub history for details.
import org.opensearch.core.action.ActionResponse;
        @SuppressWarnings("unchecked")
            ActionType<Response> action,
        @SuppressWarnings("unchecked")
        }
            dotestBasicsWithRetry(retries, retries + 1, retries + 1, e -> { throw new ExpectedException(e); });
 */
            logger,
        ExpectedException(Throwable cause) {
        }
    }
import java.util.function.Function;
import static java.util.Collections.emptyMap;
            this.listener = listener;
            synchronized (this) {
    }
        }
            threadPool,
        client.validateRequest(SearchScrollAction.INSTANCE, (SearchScrollRequest r) -> assertEquals(r.scroll().keepAlive().seconds(), 110));
            new SearchRequest().scroll("1m")
        ) {
            Function<Request, Response> response
 * Modifications Copyright OpenSearch Contributors. See
    private static class ExpectedException extends RuntimeException {
 * this file be licensed under the Apache-2.0 license or a
            new ParentTaskAssigningClient(client, parentTask),
    public void setUpThreadPool() {
    private void assertSameHits(List<? extends ScrollableHitSource.Hit> actual, SearchHit[] expected) {
            5,
 * not use this file except in compliance with the License.
                executeRequest = this.executeRequest;
    @After
            new ParentTaskAssigningClient(client, parentTask),
 * Unless required by applicable law or agreed to in writing,
            ScrollableHitSource.AsyncResponse asyncResponse = responses.poll(10, TimeUnit.SECONDS);
        TaskId parentTask = new TaskId("thenode", randomInt());
import org.opensearch.common.unit.TimeValue;
        TaskId parentTask = new TaskId("thenode", randomInt());
    private void dotestBasicsWithRetry(int retries, int minFailures, int maxFailures, Consumer<Exception> failureHandler)
            failureHandler,
import org.opensearch.action.ActionType;
        BlockingQueue<ScrollableHitSource.AsyncResponse> responses = new ArrayBlockingQueue<>(100);
import org.opensearch.transport.client.ParentTaskAssigningClient;
        }
    }
 * compatible open source license.
 *
    }
package org.opensearch.index.reindex;
            ++expectedSearchRetries;
}
            }
            SearchResponse.Clusters.EMPTY
            assertEquals(actual.get(i).getId(), expected[i].getId());
        return new SearchResponse(
            client.awaitOperation();
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
                assertNotNull("Must receive next request within 10s", executeRequest);
 * You may obtain a copy of the License at
            ExecuteRequest<?, ?> executeRequest;
    }
 * The OpenSearch Contributors require contributions made to
        public <Response extends ActionResponse> void fail(ActionType<Response> action, Exception response) {
import org.apache.lucene.search.TotalHits;
        dotestBasicsWithRetry(0, 0, 0, e -> fail());
        @Override
import java.util.concurrent.ArrayBlockingQueue;
        for (int i = 0; i < actual.size(); ++i) {
        public void respond(ActionType<Response> action, Function<Request, Response> response) {
            listener.onFailure(response);
            respondx(action, req -> response);
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import org.opensearch.action.search.SearchScrollRequest;
import java.util.function.Consumer;
        private final ActionListener<Response> listener;
 * Licensed to Elasticsearch under one or more contributor
 * ownership. Elasticsearch licenses this file to you under
 * specific language governing permissions and limitations
            0
        }
 * this work for additional information regarding copyright
    public void testRetryFail() {
            assertEquals(actual.get(i).getPrimaryTerm(), expected[i].getPrimaryTerm());
import org.opensearch.search.SearchHit;
        // create a simulated response.
            IntStream.range(0, randomIntBetween(0, 20)).mapToObj(i -> hit).toArray(SearchHit[]::new),
        threadPool = new TestThreadPool(getTestName());
        public void close() {}
        MockClient client = new MockClient(threadPool);
import org.opensearch.core.action.ActionListener;
            ActionType<Response> action,
            assertNotNull(asyncResponse);
            ((ExecuteRequest<Request, Response>) executeRequest).respond(action, response);
import org.opensearch.action.search.SearchAction;
            r -> fail(),
 *
 *
            super(cause);
        public <Request extends ActionRequest, Response extends ActionResponse> void validateRequest(
            synchronized (this) {
            for (int retry = 0; retry < randomIntBetween(minFailures, maxFailures); ++retry) {
        SearchResponse searchResponse = createSearchResponse();
        throws InterruptedException {
        hitSource.startNextScroll(timeValueSeconds(100));
        assertEquals(actual.size(), expected.length);
        }
        );
            logger,
    }
 * KIND, either express or implied.  See the License for the
        }
import org.opensearch.threadpool.TestThreadPool;
        SearchHits hits = new SearchHits(
        @Override
            ActionListener<Response> listener
 * license agreements. See the NOTICE file distributed with
                executeRequest = this.executeRequest;
            this.executeRequest = new ExecuteRequest<>(action, request, listener);
import org.opensearch.common.settings.Settings;
    }
            searchResponse = createSearchResponse();
    }
                this.executeRequest = null;
import org.junit.Before;
 * the Apache License, Version 2.0 (the "License"); you may
            4,
            }
import org.opensearch.action.search.SearchScrollAction;
import java.util.concurrent.atomic.AtomicInteger;
            assertEquals(actual.get(i).getIndex(), expected[i].getIndex());
        }
        assertThat(ex.getCause(), instanceOf(OpenSearchRejectedExecutionException.class));
        private final ActionType<Response> action;
        int retries = randomIntBetween(1, 10);
        ClientScrollableHitSource hitSource = new ClientScrollableHitSource(
        }
        );
    // ensure we test the happy path on every build.
        }
            assertEquals(actual.get(i).getIndex(), expected[i].getIndex());
    }
            client.respond(SearchScrollAction.INSTANCE, searchResponse);
    private ThreadPool threadPool;
            Request request,
import java.util.stream.IntStream;
 * SPDX-License-Identifier: Apache-2.0
        ClientScrollableHitSource hitSource = new ClientScrollableHitSource(
        });
        ) {
            BackoffPolicy.constantBackoff(TimeValue.ZERO, 0),
        int expectedSearchRetries = 0;
            ((ExecuteRequest<?, Response>) executeRequest).fail(action, response);
    }
            Consumer<? super Request> validator
        ExpectedException ex = expectThrows(ExpectedException.class, () -> {
                ++expectedSearchRetries;
import java.util.concurrent.BlockingQueue;
            this.request = request;
            client.fail(SearchAction.INSTANCE, new OpenSearchRejectedExecutionException());
import org.opensearch.action.search.SearchResponse;
        public synchronized void awaitOperation() throws InterruptedException {
        SearchHit hit = new SearchHit(0, "id", emptyMap(), emptyMap()).sourceRef(new BytesArray("{}"));
        terminate(threadPool);
        for (int i = 0; i < randomIntBetween(1, 10); ++i) {
        dotestBasicsWithRetry(retries, 0, retries, e -> fail());
            this.notifyAll();
    public void testScrollKeepAlive() {
            randomLong(),
        }
            if (executeRequest == null) {
                this.executeRequest = null;
import org.opensearch.action.ActionRequest;
import org.opensearch.action.search.SearchRequest;
        }
import java.util.concurrent.TimeUnit;
        );
            threadPool,
        @SuppressWarnings("unchecked")
/*
            ActionType<Response> action,
            listener.onResponse(response.apply(request));
        );
        assertEquals(actualSearchRetries.get(), expectedSearchRetries);
public class ClientScrollableHitSourceTests extends OpenSearchTestCase {
import org.opensearch.core.tasks.TaskId;
import org.opensearch.core.common.bytes.BytesArray;
        hitSource.start();
 */
            assertEquals(actual.get(i).getVersion(), expected[i].getVersion());
            ExecuteRequest<?, ?> executeRequest;
        public <Response extends ActionResponse> void respond(ActionType<Response> action, Response response) {
        private final Request request;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.search.SearchHits;
            BackoffPolicy.constantBackoff(TimeValue.ZERO, retries),
            // Set the base for the scroll to wait - this is added to the figure we calculate below
    @Before
    }
            actualSearchRetries::incrementAndGet,
            ((ExecuteRequest<Request, Response>) executeRequest).validateRequest(action, validator);
            validator.accept(request);
                client.fail(SearchScrollAction.INSTANCE, new OpenSearchRejectedExecutionException());
            assertEquals(action, this.action);
 * software distributed under the License is distributed on an
            this.action = action;
        InternalSearchResponse internalResponse = new InternalSearchResponse(hits, null, null, null, false, false, 1);
            }
import org.opensearch.action.bulk.BackoffPolicy;
    public void testStartScrollDone() throws InterruptedException {
        protected synchronized <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
        }
        client.validateRequest(SearchAction.INSTANCE, (SearchRequest r) -> assertTrue(r.allowPartialSearchResults() == Boolean.FALSE));
            () -> fail(),
            assertEquals(action, this.action);
        public void fail(ActionType<Response> action, Exception response) {
        }
            randomSimpleString(random(), 1, 10),
        int retries = randomInt(10);
        ExecuteRequest(ActionType<Response> action, Request request, ActionListener<Response> listener) {
                wait(10000);
    public void testRetrySuccess() throws InterruptedException {
import org.opensearch.search.internal.InternalSearchResponse;
        for (int retry = 0; retry < randomIntBetween(minFailures, maxFailures); ++retry) {
        public void validateRequest(ActionType<Response> action, Consumer<? super Request> validator) {
                client.awaitOperation();
    private static class ExecuteRequest<Request extends ActionRequest, Response extends ActionResponse> {
            assertEquals(responses.size(), 0);
            asyncResponse.done(TimeValue.ZERO);
        ) {
    private static class MockClient extends AbstractClient {
        AtomicInteger actualSearchRetries = new AtomicInteger();
            new SearchRequest().scroll(timeValueSeconds(10))
            new TotalHits(0, TotalHits.Relation.EQUAL_TO),
    public void tearDownThreadPool() {
            e -> fail(),
    }
        public <Request extends ActionRequest, Response extends ActionResponse> void respondx(
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
/*
            }
            assertEquals(actual.get(i).getSeqNo(), expected[i].getSeqNo());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
