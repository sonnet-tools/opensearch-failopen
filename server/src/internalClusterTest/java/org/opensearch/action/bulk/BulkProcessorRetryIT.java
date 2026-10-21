import org.opensearch.index.query.QueryBuilders;
 */
                    if (bulkItemResponse.isFailed()) {
import static org.hamcrest.Matchers.lessThan;
            .setConcurrentRequests(randomIntBetween(0, 100))
        private final ThreadLocal<Iterator<TimeValue>> iterators = new ThreadLocal<>();
        }
                            throw new AssertionError("Unexpected failure status: " + failure.getStatus());
                latch.countDown();
/*
        public Iterator<TimeValue> backoffStateFor(Object response) {
    private static class CorrelatingBackoffPolicy extends BackoffPolicy {
    public void testBulkRejectionLoadWithoutBackoff() throws Throwable {
                        rejectedAfterAllRetries = true;
                }
        BulkProcessor bulkProcessor = BulkProcessor.builder(client()::bulk, new BulkProcessor.Listener() {
        ensureGreen();
 * The OpenSearch Contributors require contributions made to
                    .setId(Integer.toString(i))
                // update on every invocation
                    Throwable t = (Throwable) response;
                return delegate.hasNext();
                this.iterators = iterators;
import static org.hamcrest.Matchers.equalTo;
            .setBulkActions(1)
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                return delegate.next();
 * this work for additional information regarding copyright
 */
 * under the License.
package org.opensearch.action.bulk;
                        BulkItemResponse.Failure failure = bulkItemResponse.getFailure();
    private static final String INDEX_NAME = "test";
            @Override
                iterators.set(this);
            .setBackoffPolicy(internalPolicy)
            // zero means that we're in the sync case, more means that we're in the async case
        assertNotNull("backoffState is null (indicates a bulk request got rejected without retry)", backoffState);
                if (response instanceof RemoteTransportException
                        }
        final CorrelatingBackoffPolicy internalPolicy = new CorrelatingBackoffPolicy(backoffPolicy);
        final Set<Object> responses = Collections.newSetFromMap(new ConcurrentHashMap<>());
     * <p>
import org.opensearch.transport.RemoteTransportException;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            public boolean hasNext() {
            }
                        } else {
            private final ThreadLocal<Iterator<TimeValue>> iterators;
        }
                            if (rejectedExecutionExpected == false) {
            }
                    .request()
public class BulkProcessorRetryIT extends OpenSearchIntegTestCase {
            logger.debug("We maxed out the number of bulk retries and got rejected (this is ok).");
            }
import java.util.concurrent.TimeUnit;
        if (rejectedExecutionExpected) {
        client().admin().indices().refresh(new RefreshRequest()).get();
                        assertRetriedCorrectly(internalPolicy, response, ((Throwable) response).getCause());
}
                // no op
        SearchResponse results = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).setSize(0).get();
                    if (rejectedExecutionExpected == false) {
        int numberOfAsyncOps = randomIntBetween(600, 700);
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * license agreements. See the NOTICE file distributed with
            processor.add(
        Iterator<TimeValue> backoffState = internalPolicy.backoffStateFor(bulkResponse);
import org.opensearch.common.unit.TimeValue;
            assertThat((int) results.getHits().getTotalHits().value(), lessThan(numberOfAsyncOps));
    }
                BulkResponse bulkResponse = (BulkResponse) response;
        bulkProcessor.close();
        }
                                rejectedAfterAllRetries = true;
    public void testBulkRejectionLoadWithBackoff() throws Throwable {
            }
        for (Object response : responses) {
            // default is 200
 * Modifications Copyright OpenSearch Contributors. See
            return new CorrelatingIterator(iterators, delegate.iterator());
 * Unless required by applicable law or agreed to in writing,
        return Settings.builder()
                latch.countDown();
    private void executeBulkRejectionLoad(BackoffPolicy backoffPolicy, boolean rejectedExecutionExpected) throws Throwable {
            }
    protected Settings nodeSettings(int nodeOrdinal) {
        private CorrelatingBackoffPolicy(BackoffPolicy delegate) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                    throw new AssertionError("Unexpected failure", t);
        private static class CorrelatingIterator implements Iterator<TimeValue> {
        } else if (rejectedAfterAllRetries) {
                iterators.set(this);
import org.opensearch.common.settings.Settings;
            .build();
                    // we're not expecting any other errors
                // update on every invocation as we might get rescheduled on a different thread. Unfortunately, there is a chance that
import java.util.concurrent.ConcurrentHashMap;
            // did we ever retry?
                    .setSource("field", randomRealisticUnicodeOfLengthBetween(1, 30))
                        if (failure.getStatus() == RestStatus.TOO_MANY_REQUESTS) {
                                assertRetriedCorrectly(internalPolicy, bulkResponse, failure.getCause());
        assertThat(responses.size(), equalTo(numberOfAsyncOps));
            @Override
    }
            if (response instanceof BulkResponse) {
/*
            .put(super.nodeSettings(nodeOrdinal))
        // this is intentionally *not* static final. We will only ever have one instance of this class per test case and want the
    /**
            }
 * not use this file except in compliance with the License.
    }
        } else {
 *
                            }
    }
            public void beforeBulk(long executionId, BulkRequest request) {
            throw new AssertionError("Got rejected although backoff policy would allow more retries", failure);
                // we pollute the thread local map with stale values. Due to the implementation of Retry and the life cycle of the
 * SPDX-License-Identifier: Apache-2.0
        // Have very low pool and queue sizes to overwhelm internal pools easily
            public TimeValue next() {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2)
 * GitHub history for details.
        for (int i = 1; i <= numDocs; i++) {
    }
    }
        } else {
                // we should correlate any iterator only once
 * software distributed under the License is distributed on an
        }
        // thread local to be eligible for garbage collection right after the test to avoid leaks.
     * as the last call to the backoff policy's iterator. The advantage is that this is non-invasive to the rest of the production code.
        private final BackoffPolicy delegate;
                responses.add(failure);
     * This implementation relies on an implementation detail in Retry, namely that the bulk listener is notified on the same thread
                    && ((RemoteTransportException) response).status() == RestStatus.TOO_MANY_REQUESTS) {
            this.delegate = delegate;
import org.opensearch.action.search.SearchResponse;
                correlations.put(response, iterator);
        boolean rejectedAfterAllRetries = false;
    private static void indexDocs(BulkProcessor processor, int numDocs) {
 * compatible open source license.
import org.opensearch.core.rest.RestStatus;
     * Internal helper class to correlate backoff states with bulk responses. This is needed to check whether we maxed out the number
import java.util.Set;
 *
                client().prepareIndex()
                for (BulkItemResponse bulkItemResponse : bulkResponse.getItems()) {
            if (iterator != null) {
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
                    // ignored, we exceeded the write queue size when dispatching the initial bulk request
            } else {
                responses.add(response);
import java.util.Collections;
        })
    @Override
        public Iterator<TimeValue> iterator() {
            private CorrelatingIterator(ThreadLocal<Iterator<TimeValue>> iterators, Iterator<TimeValue> delegate) {
            assertThat((int) results.getHits().getTotalHits().value(), lessThanOrEqualTo(numberOfAsyncOps));
            // .put("thread_pool.listener.queue_size", 1)
            @Override
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
                iterators.remove();
                this.delegate = delegate;
                    }
import java.util.Map;
        boolean rejectedExecutionExpected = false;
        indexDocs(bulkProcessor, numberOfAsyncOps);
/*
                }
 * KIND, either express or implied.  See the License for the
     * of retries but still got rejected (which is perfectly fine and can also happen from time to time under heavy load).
        executeBulkRejectionLoad(BackoffPolicy.exponentialBackoff(), rejectedExecutionExpected);
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
        // see also Retry.AbstractRetryHandler#onResponse().
    }
            private final Iterator<TimeValue> delegate;
            @Override
        // validate all responses
        latch.await(10, TimeUnit.SECONDS);
 * this file be licensed under the Apache-2.0 license or a
            assertThat((int) results.getHits().getTotalHits().value(), equalTo(numberOfAsyncOps));
            // don't mess with this one! It's quite sensitive to a low queue size
import org.opensearch.test.OpenSearchIntegTestCase;
 * You may obtain a copy of the License at
            // (see also ThreadedActionListener which is happily spawning threads even when we already got rejected)
            .put("thread_pool.write.queue_size", 30)
     */
        }
            return correlations.get(response);
            @Override
        boolean rejectedExecutionExpected = true;
            }
                internalPolicy.logResponse(failure);
        if (backoffState.hasNext()) {
        final CountDownLatch latch = new CountDownLatch(numberOfAsyncOps);
        private final Map<Object, Iterator<TimeValue>> correlations = new ConcurrentHashMap<>();
            .put("thread_pool.get.queue_size", 1)
 */
 * Licensed to Elasticsearch under one or more contributor
        }
        // Assumption: This method is called from the same thread as the last call to the internal iterator's #hasNext() / #next()
            .build();
                internalPolicy.logResponse(response);
            }
    private void assertRetriedCorrectly(CorrelatingBackoffPolicy internalPolicy, Object bulkResponse, Throwable failure) {
 * specific language governing permissions and limitations
        public void logResponse(Object response) {
        @Override
        }
                    }
            );
        assertAcked(prepareCreate(INDEX_NAME));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                // enclosing class CorrelatingBackoffPolicy this should not pose a major problem though.
        executeBulkRejectionLoad(BackoffPolicy.noBackoff(), rejectedExecutionExpected);
                } else {
            // we're not expecting that we overwhelmed it even once when we maxed out the number of retries
import java.util.Iterator;
                    .setIndex(INDEX_NAME)
import java.util.concurrent.CountDownLatch;
        }
            Iterator<TimeValue> iterator = iterators.get();
