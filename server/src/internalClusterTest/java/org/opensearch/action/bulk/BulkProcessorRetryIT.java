        public Iterator<TimeValue> backoffStateFor(Object response) {
                this.delegate = delegate;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            }  
 * this file be licensed under the Apache-2.0 license or a
     */
    public void testBulkRejectionLoadWithoutBackoff() throws Throwable {
                iterators.remove();
                // update on every invocation
                // update on every invocation as we might get rescheduled on a different thread. Unfortunately, there is a chance that
            }
    protected Settings nodeSettings(int nodeOrdinal) {  
    private void assertRetriedCorrectly(CorrelatingBackoffPolicy internalPolicy, Object bulkResponse, Throwable failure) {
 */
            );  
     * Internal helper class to correlate backoff states with bulk responses. This is needed to check whether we maxed out the number
    private static class CorrelatingBackoffPolicy extends BackoffPolicy {
    private static final String INDEX_NAME = "test";  
}
        bulkProcessor.close();
                internalPolicy.logResponse(response);
            // did we ever retry?
                        assertRetriedCorrectly(internalPolicy, response, ((Throwable) response).getCause());
        final CorrelatingBackoffPolicy internalPolicy = new CorrelatingBackoffPolicy(backoffPolicy);  
    }
                responses.add(failure);  
 * SPDX-License-Identifier: Apache-2.0
                }
                return delegate.hasNext();
import java.util.Iterator;
 * KIND, either express or implied.  See the License for the
                    .setIndex(INDEX_NAME)
 * You may obtain a copy of the License at  
        SearchResponse results = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).setSize(0).get();  
import java.util.concurrent.ConcurrentHashMap;
                BulkResponse bulkResponse = (BulkResponse) response;
        if (backoffState.hasNext()) {
            // default is 200
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 */
            .put("thread_pool.get.queue_size", 1)
            this.delegate = delegate;
import java.util.concurrent.CountDownLatch;
                    // ignored, we exceeded the write queue size when dispatching the initial bulk request
            if (response instanceof BulkResponse) {  
            assertThat((int) results.getHits().getTotalHits().value(), lessThanOrEqualTo(numberOfAsyncOps));  
    }
                    .setId(Integer.toString(i))  
            @Override
import org.opensearch.common.unit.TimeValue;  
            assertThat((int) results.getHits().getTotalHits().value(), equalTo(numberOfAsyncOps));
            Iterator<TimeValue> iterator = iterators.get();  
        boolean rejectedAfterAllRetries = false;
import org.opensearch.test.OpenSearchIntegTestCase;  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.lessThan;
                // we should correlate any iterator only once  
                    }  
 * this work for additional information regarding copyright
        BulkProcessor bulkProcessor = BulkProcessor.builder(client()::bulk, new BulkProcessor.Listener() {
        }
        private final Map<Object, Iterator<TimeValue>> correlations = new ConcurrentHashMap<>();  
                } else {
        // validate all responses  
        executeBulkRejectionLoad(BackoffPolicy.exponentialBackoff(), rejectedExecutionExpected);
        private CorrelatingBackoffPolicy(BackoffPolicy delegate) {
            }  
            }
 * specific language governing permissions and limitations
 * compatible open source license.
                iterators.set(this);
            }  
        // Assumption: This method is called from the same thread as the last call to the internal iterator's #hasNext() / #next()  
        for (Object response : responses) {
                this.iterators = iterators;
/*  
    }  
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {  
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
        assertThat(responses.size(), equalTo(numberOfAsyncOps));
            }
    }  
     * as the last call to the backoff policy's iterator. The advantage is that this is non-invasive to the rest of the production code.  
        boolean rejectedExecutionExpected = false;
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            public TimeValue next() {  
                                assertRetriedCorrectly(internalPolicy, bulkResponse, failure.getCause());
        }
                correlations.put(response, iterator);
 * ownership. Elasticsearch licenses this file to you under  
    private static void indexDocs(BulkProcessor processor, int numDocs) {
import org.opensearch.index.query.QueryBuilders;
            // we're not expecting that we overwhelmed it even once when we maxed out the number of retries  
        private final BackoffPolicy delegate;
import java.util.Collections;  
 * Unless required by applicable law or agreed to in writing,
        // thread local to be eligible for garbage collection right after the test to avoid leaks.
package org.opensearch.action.bulk;
import java.util.Map;
        // Have very low pool and queue sizes to overwhelm internal pools easily
                return delegate.next();  
    /**
        })  
            .put("thread_pool.write.queue_size", 30)  
    public void testBulkRejectionLoadWithBackoff() throws Throwable {  
    }
                        rejectedAfterAllRetries = true;
        if (rejectedExecutionExpected) {
                if (response instanceof RemoteTransportException
        public Iterator<TimeValue> iterator() {
                iterators.set(this);
import org.opensearch.action.search.SearchResponse;
import org.opensearch.common.settings.Settings;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2)
            .setBulkActions(1)
            // zero means that we're in the sync case, more means that we're in the async case
        }
        // this is intentionally *not* static final. We will only ever have one instance of this class per test case and want the
            processor.add(  
        for (int i = 1; i <= numDocs; i++) {
import org.opensearch.action.admin.indices.refresh.RefreshRequest;  
            @Override  
        final CountDownLatch latch = new CountDownLatch(numberOfAsyncOps);
            }  
            public void beforeBulk(long executionId, BulkRequest request) {
 */  
            .setConcurrentRequests(randomIntBetween(0, 100))  
                        }  
import org.opensearch.core.rest.RestStatus;
                    && ((RemoteTransportException) response).status() == RestStatus.TOO_MANY_REQUESTS) {
        return Settings.builder()
                internalPolicy.logResponse(failure);
            .build();
            if (iterator != null) {
 *
 *  
                        } else {
            }
import java.util.Set;  
 *
     * This implementation relies on an implementation detail in Retry, namely that the bulk listener is notified on the same thread
 * GitHub history for details.
            @Override  
import java.util.concurrent.TimeUnit;  
                        if (failure.getStatus() == RestStatus.TOO_MANY_REQUESTS) {
 * Modifications Copyright OpenSearch Contributors. See  
        }
                    throw new AssertionError("Unexpected failure", t);
 * under the License.  
    private void executeBulkRejectionLoad(BackoffPolicy backoffPolicy, boolean rejectedExecutionExpected) throws Throwable {
                    Throwable t = (Throwable) response;  
        // see also Retry.AbstractRetryHandler#onResponse().
            throw new AssertionError("Got rejected although backoff policy would allow more retries", failure);
                            }  
        } else {  
        private final ThreadLocal<Iterator<TimeValue>> iterators = new ThreadLocal<>();  
            .put(super.nodeSettings(nodeOrdinal))  
            private final Iterator<TimeValue> delegate;  
                    .request()
                for (BulkItemResponse bulkItemResponse : bulkResponse.getItems()) {
        }
                    // we're not expecting any other errors
        public void logResponse(Object response) {
 * license agreements. See the NOTICE file distributed with
            return correlations.get(response);  
        assertAcked(prepareCreate(INDEX_NAME));
        Iterator<TimeValue> backoffState = internalPolicy.backoffStateFor(bulkResponse);  
            .setBackoffPolicy(internalPolicy)
                    .setSource("field", randomRealisticUnicodeOfLengthBetween(1, 30))
                // we pollute the thread local map with stale values. Due to the implementation of Retry and the life cycle of the
        final Set<Object> responses = Collections.newSetFromMap(new ConcurrentHashMap<>());  
            // don't mess with this one! It's quite sensitive to a low queue size
import org.opensearch.transport.RemoteTransportException;
                // no op
        }  
        }  
                responses.add(response);
        client().admin().indices().refresh(new RefreshRequest()).get();
            return new CorrelatingIterator(iterators, delegate.iterator());
            public boolean hasNext() {  
            private final ThreadLocal<Iterator<TimeValue>> iterators;
        }
     * <p>
        } else if (rejectedAfterAllRetries) {
            // .put("thread_pool.listener.queue_size", 1)  
            @Override
        ensureGreen();  
            private CorrelatingIterator(ThreadLocal<Iterator<TimeValue>> iterators, Iterator<TimeValue> delegate) {  
 * software distributed under the License is distributed on an
        indexDocs(bulkProcessor, numberOfAsyncOps);  
import static org.hamcrest.Matchers.equalTo;  
        } else {
                            throw new AssertionError("Unexpected failure status: " + failure.getStatus());
public class BulkProcessorRetryIT extends OpenSearchIntegTestCase {
                latch.countDown();
            logger.debug("We maxed out the number of bulk retries and got rejected (this is ok).");  
                            if (rejectedExecutionExpected == false) {  
    }
/*
                client().prepareIndex()
 * Licensed to Elasticsearch under one or more contributor  
                latch.countDown();  
            assertThat((int) results.getHits().getTotalHits().value(), lessThan(numberOfAsyncOps));
                    if (rejectedExecutionExpected == false) {  
     * of retries but still got rejected (which is perfectly fine and can also happen from time to time under heavy load).  
        int numberOfAsyncOps = randomIntBetween(600, 700);
                        BulkItemResponse.Failure failure = bulkItemResponse.getFailure();
                    }
                // enclosing class CorrelatingBackoffPolicy this should not pose a major problem though.  
        latch.await(10, TimeUnit.SECONDS);
        assertNotNull("backoffState is null (indicates a bulk request got rejected without retry)", backoffState);
/*
                                rejectedAfterAllRetries = true;
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean rejectedExecutionExpected = true;
        executeBulkRejectionLoad(BackoffPolicy.noBackoff(), rejectedExecutionExpected);  
            // (see also ThreadedActionListener which is happily spawning threads even when we already got rejected)
            @Override
        private static class CorrelatingIterator implements Iterator<TimeValue> {
        }
            .build();
 * The OpenSearch Contributors require contributions made to  
    @Override
            } else {  
        @Override  
                    if (bulkItemResponse.isFailed()) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
