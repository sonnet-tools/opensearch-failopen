 * GitHub history for details.
        if (backoffState.hasNext()) {
    private void assertRetriedCorrectly(CorrelatingBackoffPolicy internalPolicy, Object bulkResponse, Throwable failure) {
 * the Apache License, Version 2.0 (the "License"); you may
                internalPolicy.logResponse(response);
    private void executeBulkRejectionLoad(BackoffPolicy backoffPolicy, boolean rejectedExecutionExpected) throws Exception {
        return BulkProcessor.builder(
import java.util.concurrent.ConcurrentHashMap;
import org.opensearch.core.xcontent.MediaTypeRegistry;
                        rejectedAfterAllRetries = true;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            @Override
            }
 * not use this file except in compliance with the License.
        public Iterator<TimeValue> iterator() {
                this.iterators = iterators;
        }
 * this file be licensed under the Apache-2.0 license or a
        }
        }
import org.opensearch.action.get.MultiGetRequest;
        highLevelClient().indices().refresh(new RefreshRequest(), RequestOptions.DEFAULT);
        }
 */
                            }
        final CorrelatingBackoffPolicy internalPolicy = new CorrelatingBackoffPolicy(backoffPolicy);
    private static final String INDEX_NAME = "index";
        bulkProcessor.close();
                    }
                if (response instanceof RemoteTransportException
                // update on every invocation
        executeBulkRejectionLoad(BackoffPolicy.exponentialBackoff(), rejectedExecutionExpected);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            private CorrelatingIterator(ThreadLocal<Iterator<TimeValue>> iterators, Iterator<TimeValue> delegate) {
                BulkResponse bulkResponse = (BulkResponse) response;
        boolean rejectedExecutionExpected = true;
    }
import static org.hamcrest.Matchers.equalTo;
 * specific language governing permissions and limitations
 *
                    if (bulkItemResponse.isFailed()) {
            } else {
import org.opensearch.common.unit.TimeValue;
 * You may obtain a copy of the License at
        public void logResponse(Object response) {
        return multiGetRequest;
                correlations.put(response, iterator);
            public TimeValue next() {
    }
    public void testBulkRejectionLoadWithoutBackoff() throws Exception {
     * as the last call to the backoff policy's iterator. The advantage is that this is non-invasive to the rest of the production code.
            }
            @Override
        assertEquals(responses.size(), numberOfAsyncOps);
        MultiGetRequest multiGetRequest = new MultiGetRequest();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.RemoteTransportException;
            // did we ever retry?
/*
    private static MultiGetRequest indexDocs(BulkProcessor processor, int numDocs) {
import org.opensearch.core.rest.RestStatus;
        }
            assertThat(multiGetResponsesCount, lessThan(numberOfAsyncOps));
                iterators.set(this);
        Iterator<TimeValue> backoffState = internalPolicy.backoffStateFor(bulkResponse);
                internalPolicy.logResponse(failure);
        // see also Retry.AbstractRetryHandler#onResponse().
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
        executeBulkRejectionLoad(BackoffPolicy.noBackoff(), rejectedExecutionExpected);
            throw new AssertionError("Got rejected although backoff policy would allow more retries", failure);
     * This implementation relies on an implementation detail in Retry, namely that the bulk listener is notified on the same thread
            // we're not expecting that we overwhelmed it even once when we maxed out the number of retries
            return correlations.get(response);
            }
        final int numberOfAsyncOps = randomIntBetween(600, 700);
                        assertRetriedCorrectly(internalPolicy, response, ((Throwable) response).getCause());
            private final Iterator<TimeValue> delegate;
                    .source(MediaTypeRegistry.JSON, "field", randomRealisticUnicodeOfCodepointLengthBetween(1, 30))
                    // ignored, we exceeded the write queue size when dispatching the initial bulk request
                latch.countDown();
        private final BackoffPolicy delegate;
import org.opensearch.action.bulk.BackoffPolicy;
                }
import org.opensearch.action.bulk.BulkProcessor;
                return delegate.hasNext();
        for (int i = 1; i <= numDocs; i++) {
        }
 * ownership. Elasticsearch licenses this file to you under
                        BulkItemResponse.Failure failure = bulkItemResponse.getFailure();
import org.opensearch.action.bulk.BulkItemResponse;
                // enclosing class CorrelatingBackoffPolicy this should not pose a major problem though.
package org.opensearch.client;
        if (rejectedExecutionExpected) {
        } else {
            (request, bulkListener) -> highLevelClient().bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
                    if (rejectedExecutionExpected == false) {
import org.opensearch.action.index.IndexRequest;
        private static class CorrelatingIterator implements Iterator<TimeValue> {
        private final Map<Object, Iterator<TimeValue>> correlations = new ConcurrentHashMap<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
                responses.add(response);
        );
 */
import java.util.concurrent.TimeUnit;
            logger.debug("We maxed out the number of bulk retries and got rejected (this is ok).");
        int multiGetResponsesCount = highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT).getResponses().length;
 * Unless required by applicable law or agreed to in writing,
        public Iterator<TimeValue> backoffStateFor(Object response) {
                                rejectedAfterAllRetries = true;
                iterators.set(this);
                // we should correlate any iterator only once
        boolean rejectedExecutionExpected = false;
import org.opensearch.action.bulk.BulkResponse;
                    && ((RemoteTransportException) response).status() == RestStatus.TOO_MANY_REQUESTS) {
        final CountDownLatch latch = new CountDownLatch(numberOfAsyncOps);
        } else if (rejectedAfterAllRetries) {
            }
                        }
        @Override
        final Set<Object> responses = Collections.newSetFromMap(new ConcurrentHashMap<>());
            );
 *
            }
                responses.add(failure);
 * KIND, either express or implied.  See the License for the
            @Override
    /**
/*
import org.opensearch.action.bulk.BulkRequest;
                }
import java.util.concurrent.CountDownLatch;
                } else {
 * software distributed under the License is distributed on an
import java.util.Collections;
        // this is intentionally *not* static final. We will only ever have one instance of this class per test case and want the
        private CorrelatingBackoffPolicy(BackoffPolicy delegate) {
    public void testBulkRejectionLoadWithBackoff() throws Throwable {
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
 *
    }
        latch.await(10, TimeUnit.SECONDS);
            private final ThreadLocal<Iterator<TimeValue>> iterators;
            multiGetRequest.add(INDEX_NAME, Integer.toString(i));
                    throw new AssertionError("Unexpected failure", t);
                this.delegate = delegate;
 * under the License.
            public boolean hasNext() {
        }
            listener
    }
                    }
    private static BulkProcessor.Builder initBulkProcessorBuilder(BulkProcessor.Listener listener) {
            @Override
        for (Object response : responses) {
                return delegate.next();
}
            assertThat(multiGetResponsesCount, equalTo(numberOfAsyncOps));
            if (response instanceof BulkResponse) {
import java.util.Map;
                for (BulkItemResponse bulkItemResponse : bulkResponse.getItems()) {
                            throw new AssertionError("Unexpected failure with status: " + failure.getStatus());
                        } else {
     */
 * compatible open source license.
                // update on every invocation as we might get rescheduled on a different thread. Unfortunately, there is a chance that
            this.delegate = delegate;
            }
        // thread local to be eligible for garbage collection right after the test to avoid leaks.
            @Override
    }
import static org.hamcrest.Matchers.lessThan;
                                assertRetriedCorrectly(internalPolicy, bulkResponse, failure.getCause());
        } else {
                    Throwable t = (Throwable) response;
import java.util.Iterator;
                // we pollute the thread local map with stale values. Due to the implementation of Retry and the life cycle of the
 * Licensed to Elasticsearch under one or more contributor
                        if (failure.getStatus() == RestStatus.TOO_MANY_REQUESTS) {
        assertNotNull("backoffState is null (indicates a bulk request got rejected without retry)", backoffState);
                iterators.remove();
        boolean rejectedAfterAllRetries = false;
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
 * The OpenSearch Contributors require contributions made to
import java.util.Set;
            return new CorrelatingIterator(iterators, delegate.iterator());
/*
        MultiGetRequest multiGetRequest = indexDocs(bulkProcessor, numberOfAsyncOps);
            if (iterator != null) {
                latch.countDown();
     * <p>
        }
 */
 * SPDX-License-Identifier: Apache-2.0
                new IndexRequest(INDEX_NAME).id(Integer.toString(i))
            processor.add(
            public void beforeBulk(long executionId, BulkRequest request) {}
public class BulkProcessorRetryIT extends OpenSearchRestHighLevelClientTestCase {
    }
            assertThat(multiGetResponsesCount, lessThanOrEqualTo(numberOfAsyncOps));
    private static class CorrelatingBackoffPolicy extends BackoffPolicy {
     * Internal helper class to correlate backoff states with bulk responses. This is needed to check whether we maxed out the number
        private final ThreadLocal<Iterator<TimeValue>> iterators = new ThreadLocal<>();
    }
        BulkProcessor bulkProcessor = initBulkProcessorBuilder(new BulkProcessor.Listener() {
 * license agreements. See the NOTICE file distributed with
                    // we're not expecting any other errors
            Iterator<TimeValue> iterator = iterators.get();
     * of retries but still got rejected (which is perfectly fine and can also happen from time to time under heavy load).
            }
 * this work for additional information regarding copyright
        // Assumption: This method is called from the same thread as the last call to the internal iterator's #hasNext() / #next()
                            if (rejectedExecutionExpected == false) {
        }).setBulkActions(1).setConcurrentRequests(randomIntBetween(0, 100)).setBackoffPolicy(internalPolicy).build();
