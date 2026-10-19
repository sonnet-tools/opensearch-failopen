            @Override  
                // we should correlate any iterator only once
    /**
                    // we're not expecting any other errors
            }
 */
            throw new AssertionError("Got rejected although backoff policy would allow more retries", failure);
            assertThat(multiGetResponsesCount, lessThan(numberOfAsyncOps));
            return new CorrelatingIterator(iterators, delegate.iterator());  
        }
 * KIND, either express or implied.  See the License for the
            private final Iterator<TimeValue> delegate;
 *  
        );  
                } else {  
            } else {
     * <p>
import org.opensearch.action.admin.indices.refresh.RefreshRequest;  
        Iterator<TimeValue> backoffState = internalPolicy.backoffStateFor(bulkResponse);
                    Throwable t = (Throwable) response;
                this.iterators = iterators;
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
    public void testBulkRejectionLoadWithBackoff() throws Throwable {
import org.opensearch.core.xcontent.MediaTypeRegistry;
                                rejectedAfterAllRetries = true;  
    public void testBulkRejectionLoadWithoutBackoff() throws Exception {  
            multiGetRequest.add(INDEX_NAME, Integer.toString(i));  
import java.util.Set;
                BulkResponse bulkResponse = (BulkResponse) response;
        return multiGetRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
        public Iterator<TimeValue> iterator() {
                iterators.set(this);
    }
            Iterator<TimeValue> iterator = iterators.get();
        bulkProcessor.close();
 */
        for (int i = 1; i <= numDocs; i++) {
 *
 * this work for additional information regarding copyright
        @Override
        final int numberOfAsyncOps = randomIntBetween(600, 700);  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.action.bulk.BackoffPolicy;
                    .source(MediaTypeRegistry.JSON, "field", randomRealisticUnicodeOfCodepointLengthBetween(1, 30))
/*  
                        }
import java.util.concurrent.TimeUnit;
import java.util.Map;  
            // did we ever retry?
        highLevelClient().indices().refresh(new RefreshRequest(), RequestOptions.DEFAULT);
                for (BulkItemResponse bulkItemResponse : bulkResponse.getItems()) {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.transport.RemoteTransportException;
            @Override
        private final Map<Object, Iterator<TimeValue>> correlations = new ConcurrentHashMap<>();
                        BulkItemResponse.Failure failure = bulkItemResponse.getFailure();
                    if (rejectedExecutionExpected == false) {
                correlations.put(response, iterator);  
            listener
import java.util.Collections;
                // enclosing class CorrelatingBackoffPolicy this should not pose a major problem though.
                internalPolicy.logResponse(failure);
            return correlations.get(response);
        }  
        // see also Retry.AbstractRetryHandler#onResponse().
            );
 *
        boolean rejectedAfterAllRetries = false;
    private void executeBulkRejectionLoad(BackoffPolicy backoffPolicy, boolean rejectedExecutionExpected) throws Exception {
            public TimeValue next() {
import org.opensearch.action.bulk.BulkResponse;
     */
 * this file be licensed under the Apache-2.0 license or a
        }
                this.delegate = delegate;  
                responses.add(response);
        // thread local to be eligible for garbage collection right after the test to avoid leaks.  
 * the Apache License, Version 2.0 (the "License"); you may
        latch.await(10, TimeUnit.SECONDS);  
                        } else {
 * specific language governing permissions and limitations
        if (backoffState.hasNext()) {  
            }
                iterators.set(this);  
                    if (bulkItemResponse.isFailed()) {
            }
                // we pollute the thread local map with stale values. Due to the implementation of Retry and the life cycle of the  
public class BulkProcessorRetryIT extends OpenSearchRestHighLevelClientTestCase {
                }
                    }
        MultiGetRequest multiGetRequest = new MultiGetRequest();  
            if (iterator != null) {  
        return BulkProcessor.builder(  
    private static MultiGetRequest indexDocs(BulkProcessor processor, int numDocs) {
            }
    private void assertRetriedCorrectly(CorrelatingBackoffPolicy internalPolicy, Object bulkResponse, Throwable failure) {  
import org.opensearch.common.unit.TimeValue;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                latch.countDown();  
        private CorrelatingBackoffPolicy(BackoffPolicy delegate) {
            this.delegate = delegate;  
                        if (failure.getStatus() == RestStatus.TOO_MANY_REQUESTS) {  
            assertThat(multiGetResponsesCount, lessThanOrEqualTo(numberOfAsyncOps));  
        }
     * of retries but still got rejected (which is perfectly fine and can also happen from time to time under heavy load).
/*
        private final BackoffPolicy delegate;  
    private static class CorrelatingBackoffPolicy extends BackoffPolicy {  
                new IndexRequest(INDEX_NAME).id(Integer.toString(i))  
        public void logResponse(Object response) {  
import org.opensearch.action.bulk.BulkItemResponse;
                        assertRetriedCorrectly(internalPolicy, response, ((Throwable) response).getCause());
            @Override  
                }  
                            throw new AssertionError("Unexpected failure with status: " + failure.getStatus());  
            if (response instanceof BulkResponse) {
        public Iterator<TimeValue> backoffStateFor(Object response) {  
 * compatible open source license.
                latch.countDown();
        } else {  
            }
 */  
                    throw new AssertionError("Unexpected failure", t);  
        int multiGetResponsesCount = highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT).getResponses().length;  
 * under the License.  
                return delegate.hasNext();  
            }
        MultiGetRequest multiGetRequest = indexDocs(bulkProcessor, numberOfAsyncOps);
        } else if (rejectedAfterAllRetries) {
import org.opensearch.action.bulk.BulkProcessor;  
                iterators.remove();
            // we're not expecting that we overwhelmed it even once when we maxed out the number of retries
                // update on every invocation as we might get rescheduled on a different thread. Unfortunately, there is a chance that
        // this is intentionally *not* static final. We will only ever have one instance of this class per test case and want the
        boolean rejectedExecutionExpected = true;
import static org.hamcrest.Matchers.equalTo;  
     * Internal helper class to correlate backoff states with bulk responses. This is needed to check whether we maxed out the number  
            private final ThreadLocal<Iterator<TimeValue>> iterators;
            processor.add(
        executeBulkRejectionLoad(BackoffPolicy.noBackoff(), rejectedExecutionExpected);
import org.opensearch.action.index.IndexRequest;
}
 * The OpenSearch Contributors require contributions made to  
    }  
import java.util.Iterator;
 * You may obtain a copy of the License at  
     * This implementation relies on an implementation detail in Retry, namely that the bulk listener is notified on the same thread  
        BulkProcessor bulkProcessor = initBulkProcessorBuilder(new BulkProcessor.Listener() {
            public boolean hasNext() {
                return delegate.next();
        // Assumption: This method is called from the same thread as the last call to the internal iterator's #hasNext() / #next()
import java.util.concurrent.CountDownLatch;  
            @Override
                responses.add(failure);  
    }  
        executeBulkRejectionLoad(BackoffPolicy.exponentialBackoff(), rejectedExecutionExpected);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import org.opensearch.core.rest.RestStatus;  
        }
 * not use this file except in compliance with the License.
import org.opensearch.action.get.MultiGetRequest;  
        } else {  
            (request, bulkListener) -> highLevelClient().bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
            private CorrelatingIterator(ThreadLocal<Iterator<TimeValue>> iterators, Iterator<TimeValue> delegate) {
                                assertRetriedCorrectly(internalPolicy, bulkResponse, failure.getCause());
 * GitHub history for details.
        }).setBulkActions(1).setConcurrentRequests(randomIntBetween(0, 100)).setBackoffPolicy(internalPolicy).build();  
 * Licensed to Elasticsearch under one or more contributor  
            logger.debug("We maxed out the number of bulk retries and got rejected (this is ok).");
                            }
        assertEquals(responses.size(), numberOfAsyncOps);  
/*
                        rejectedAfterAllRetries = true;  
                    }
import static org.hamcrest.Matchers.lessThan;
        final CountDownLatch latch = new CountDownLatch(numberOfAsyncOps);
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.ConcurrentHashMap;
        assertNotNull("backoffState is null (indicates a bulk request got rejected without retry)", backoffState);
    private static final String INDEX_NAME = "index";  
        }  
    }
            @Override  
        if (rejectedExecutionExpected) {
import org.opensearch.action.bulk.BulkRequest;
    }  
                            if (rejectedExecutionExpected == false) {
        final CorrelatingBackoffPolicy internalPolicy = new CorrelatingBackoffPolicy(backoffPolicy);
        boolean rejectedExecutionExpected = false;  
 * Unless required by applicable law or agreed to in writing,
                if (response instanceof RemoteTransportException
            public void beforeBulk(long executionId, BulkRequest request) {}  
    }
            }
    private static BulkProcessor.Builder initBulkProcessorBuilder(BulkProcessor.Listener listener) {
        }
        private final ThreadLocal<Iterator<TimeValue>> iterators = new ThreadLocal<>();
                    // ignored, we exceeded the write queue size when dispatching the initial bulk request
package org.opensearch.client;
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
                // update on every invocation
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {  
        }
        }
            assertThat(multiGetResponsesCount, equalTo(numberOfAsyncOps));
                internalPolicy.logResponse(response);
                    && ((RemoteTransportException) response).status() == RestStatus.TOO_MANY_REQUESTS) {  
     * as the last call to the backoff policy's iterator. The advantage is that this is non-invasive to the rest of the production code.
        for (Object response : responses) {  
        private static class CorrelatingIterator implements Iterator<TimeValue> {  
        final Set<Object> responses = Collections.newSetFromMap(new ConcurrentHashMap<>());
