/*
                if (bulkItemResponse.isFailed()) {
    /**
                        indexRequest.isPipelineResolved(false);  
                } else {
            synchronized (responses) {
            if (e instanceof RemoteTransportException && ((RemoteTransportException) e).status() == RETRY_STATUS && backoff.hasNext()) {
import org.opensearch.threadpool.ThreadPool;  
     * @param consumer The consumer to which apply the request and listener
                    // when executing pipeline failed with retryable exception, the pipeline needs to be executed again  
            ActionListener<BulkResponse> listener,
            }  
            for (BulkItemResponse bulkItemResponse : bulkItemResponses.getItems()) {  
 * SPDX-License-Identifier: Apache-2.0
     */
        private final List<BulkItemResponse> responses = new ArrayList<>();
     * provided listener. Retries will be scheduled using the class's thread pool.
import java.util.List;
            long stopTimestamp = System.nanoTime();
        private BulkResponse getAccumulatedResponse() {
    }  
                }  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    static class RetryHandler implements ActionListener<BulkResponse> {
                    if (status != RETRY_STATUS) {
        @Override
    }  
            if (!backoff.hasNext()) {
     * the class's thread pool.
 * ownership. Elasticsearch licenses this file to you under  
        private final long startTimestampNanos;
        this.backoffPolicy = backoffPolicy;
    }
     *
     *  
                        // to the global pipeline if the global pipeline exists,
import org.opensearch.action.index.IndexRequest;  
                    }  
                        // see org.opensearch.ingest.IngestService.resolvePipelines()
import java.util.function.BiConsumer;  
                finishHim();  
                }  
        this.scheduler = scheduler;
    }
        @Override  
            }
     * @return a future representing the bulk response returned by the client.  
                    retry(createBulkRequestForRetry(bulkItemResponses));
            }  
        private final Iterator<TimeValue> backoff;
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,  
            assert backoff.hasNext();
 * The OpenSearch Contributors require contributions made to  
        public void onResponse(BulkResponse bulkItemResponses) {
        private boolean canRetry(BulkResponse bulkItemResponses) {  
        RetryHandler(
            } else {
 *
import org.apache.logging.log4j.Logger;
            for (BulkItemResponse bulkItemResponse : bulkItemResponses) {
    public PlainActionFuture<BulkResponse> withBackoff(
            this.backoff = backoffPolicy.iterator();
            BulkRequest requestToReissue = new BulkRequest().pipeline(globalPipeline);
     * @param listener A listener that is invoked when the bulk request finishes or completes with an exception. The listener is not
    /**  
                if (retryCancellable != null) {
                    final RestStatus status = bulkItemResponse.status();  
                        // reset it
 * GitHub history for details.
        private final Scheduler scheduler;
                index++;
import java.util.function.Predicate;
 * Unless required by applicable law or agreed to in writing,
public class Retry {
            Scheduler scheduler  
                    requestToReissue.add(docWriteRequest);
            this.consumer = consumer;  
                } finally {
            }
import org.opensearch.action.DocWriteRequest;
            }  
            String globalPipeline = this.currentBulkRequest.pipeline();  
 * specific language governing permissions and limitations
                    }  
                        // Reset pipeline configuration for retry, after the first execution, the pipeline was set to _none, so we need to  
     * Retry handler  
            retryCancellable = scheduler.schedule(() -> this.execute(bulkRequestForRetry), next, ThreadPool.Names.SAME);
            this.currentBulkRequest = bulkRequest;
 * compatible open source license.
        }  
                    finishHim();
            try {
                if (bulkItemResponse.isFailed()) {
        return future;
 * Encapsulates synchronous and asynchronous retry logic.
            this.scheduler = scheduler;
 * Modifications Copyright OpenSearch Contributors. See  
            // in contrast to System.currentTimeMillis(), nanoTime() uses a monotonic clock under the hood  
        private static final Logger logger = LogManager.getLogger(RetryHandler.class);  
/**  
    ) {
            BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
 * @opensearch.internal  
            return requestToReissue;  
                addResponses(bulkItemResponses, (r -> true));
        }
                }
                        indexRequest.setPipeline(globalPipeline);
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
        private static final RestStatus RETRY_STATUS = RestStatus.TOO_MANY_REQUESTS;
            logger.trace("Retry of bulk request scheduled in {} ms.", next.millis());  
     * @param bulkRequest The bulk request that should be executed.  
 */  
            // global pipeline should be set in the new Bulk Request
        private void finishHim() {  
        ActionListener<BulkResponse> listener  
        RetryHandler r = new RetryHandler(backoffPolicy, consumer, listener, scheduler);
 *
 * You may obtain a copy of the License at  
                }
                    addResponses(bulkItemResponses, (r -> !r.isFailed()));  
                }
            return new BulkResponse(itemResponses, totalLatencyMs);  
                retry(currentBulkRequest);  
     */  
                        retryCancellable.cancel();  
package org.opensearch.action.bulk;
            int index = 0;
                // we're done here, include all responses
                return false;
        private volatile BulkRequest currentBulkRequest;
            return true;  
                    listener.onFailure(e);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    // (based on how many retries we have to issue) and relying that the response handling code will be
                    // scheduled on the same thread is fragile.  
 * the Apache License, Version 2.0 (the "License"); you may
 */
        // needed to construct the next bulk request based on the response to the previous one  
        }
                    // Use client-side lock here to avoid visibility issues. This method may be called multiple times
/*  
/*
        public void execute(BulkRequest bulkRequest) {  
import java.util.Iterator;
 * Licensed to Elasticsearch under one or more contributor  
            }
                    }
                        && docWriteRequest instanceof IndexRequest indexRequest) {
            BulkItemResponse[] itemResponses;  
import org.opensearch.action.support.PlainActionFuture;
    public Retry(BackoffPolicy backoffPolicy, Scheduler scheduler) {  
 * license agreements. See the NOTICE file distributed with
                try {
 * not use this file except in compliance with the License.
        withBackoff(consumer, bulkRequest, future);
            for (BulkItemResponse bulkItemResponse : response) {
        BulkRequest bulkRequest
                listener.onResponse(getAccumulatedResponse());
                if (filter.test(bulkItemResponse)) {  
    ) {
     * @opensearch.internal
                    DocWriteRequest<?> docWriteRequest = currentBulkRequest.requests().get(index);
        }
            } finally {  
    /**
        public void onFailure(Exception e) {
    public void withBackoff(  
                        return false;
}
import org.opensearch.core.rest.RestStatus;
            }  
import org.opensearch.common.unit.TimeValue;
        // volatile as we're called from a scheduled thread
        // Access only when holding a client-side lock, see also #addResponses()  
        private final ActionListener<BulkResponse> listener;
                    if (retryCancellable != null) {
 * software distributed under the License is distributed on an
                    addResponses(bulkItemResponses, (r -> true));  
        BulkRequest bulkRequest,
                    retryCancellable.cancel();
            this.listener = listener;
            }
 */
 */
        }
                    if (bulkItemResponse.getFailure().getSource() == BulkItemResponse.Failure.FailureSource.PIPELINE
        ) {
                }
        private void retry(BulkRequest bulkRequestForRetry) {  
            consumer.accept(bulkRequest, this);
import org.opensearch.transport.RemoteTransportException;
 *
import org.opensearch.threadpool.Scheduler;
                        // if not, set to null to ensure the default pipeline can be resolved and set  
                    }
            this.startTimestampNanos = System.nanoTime();
    private final Scheduler scheduler;
            BackoffPolicy backoffPolicy,  
     * @param consumer The consumer to which apply the request and listener
     * Invokes #accept(BulkRequest, ActionListener). Backs off on the provided exception and delegates results to the  
        private void addResponses(BulkResponse response, Predicate<BulkItemResponse> filter) {
                if (canRetry(bulkItemResponses)) {
        r.execute(bulkRequest);  
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
import java.util.ArrayList;  
                    synchronized (responses) {
        private volatile Scheduler.Cancellable retryCancellable;  
        private final BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer;  
            long totalLatencyMs = TimeValue.timeValueNanos(stopTimestamp - startTimestampNanos).millis();
            TimeValue next = backoff.next();
import org.apache.logging.log4j.LogManager;  
        }
 *  
    private final BackoffPolicy backoffPolicy;  
        }  
            } else {
import org.opensearch.core.action.ActionListener;  
            if (!bulkItemResponses.hasFailures()) {  
     * @param bulkRequest The bulk request that should be executed.
        private BulkRequest createBulkRequestForRetry(BulkResponse bulkItemResponses) {
     * Invokes #accept(BulkRequest, ActionListener). Backs off on the provided exception. Retries will be scheduled using
        PlainActionFuture<BulkResponse> future = PlainActionFuture.newFuture();  
        }
                itemResponses = responses.toArray(new BulkItemResponse[1]);
                        responses.add(bulkItemResponse);
 * under the License.  
        }
        }
 * this file be licensed under the Apache-2.0 license or a
