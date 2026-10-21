                        // to the global pipeline if the global pipeline exists,
                    finishHim();
                        // if not, set to null to ensure the default pipeline can be resolved and set
     * Invokes #accept(BulkRequest, ActionListener). Backs off on the provided exception. Retries will be scheduled using
            this.consumer = consumer;
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
            for (BulkItemResponse bulkItemResponse : bulkItemResponses.getItems()) {
        private final long startTimestampNanos;
            BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
        private void retry(BulkRequest bulkRequestForRetry) {
import org.opensearch.action.DocWriteRequest;
import java.util.function.BiConsumer;
 * GitHub history for details.
            long stopTimestamp = System.nanoTime();
        this.scheduler = scheduler;
                if (retryCancellable != null) {
            }
            this.backoff = backoffPolicy.iterator();
            int index = 0;
    public Retry(BackoffPolicy backoffPolicy, Scheduler scheduler) {
 *
            String globalPipeline = this.currentBulkRequest.pipeline();
                    synchronized (responses) {
 * @opensearch.internal
        this.backoffPolicy = backoffPolicy;
                        indexRequest.isPipelineResolved(false);
                        retryCancellable.cancel();
        }
     * @opensearch.internal
            BulkItemResponse[] itemResponses;
        private final BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer;
            }
        return future;
            return new BulkResponse(itemResponses, totalLatencyMs);
 * Encapsulates synchronous and asynchronous retry logic.
 * specific language governing permissions and limitations
     *
            // global pipeline should be set in the new Bulk Request
    ) {
/*
                        indexRequest.setPipeline(globalPipeline);
     * the class's thread pool.
        }
        private void addResponses(BulkResponse response, Predicate<BulkItemResponse> filter) {
import org.opensearch.action.index.IndexRequest;
        }
                    }
    }
        }
import java.util.Iterator;
                        return false;
 */
 * SPDX-License-Identifier: Apache-2.0
            retryCancellable = scheduler.schedule(() -> this.execute(bulkRequestForRetry), next, ThreadPool.Names.SAME);
        private final Iterator<TimeValue> backoff;
            Scheduler scheduler
                // we're done here, include all responses
        RetryHandler r = new RetryHandler(backoffPolicy, consumer, listener, scheduler);
                        // see org.opensearch.ingest.IngestService.resolvePipelines()
            this.currentBulkRequest = bulkRequest;
                    final RestStatus status = bulkItemResponse.status();
 * this file be licensed under the Apache-2.0 license or a
        BulkRequest bulkRequest,
        private BulkRequest createBulkRequestForRetry(BulkResponse bulkItemResponses) {
        private boolean canRetry(BulkResponse bulkItemResponses) {
        private final List<BulkItemResponse> responses = new ArrayList<>();
                    if (bulkItemResponse.getFailure().getSource() == BulkItemResponse.Failure.FailureSource.PIPELINE
                    DocWriteRequest<?> docWriteRequest = currentBulkRequest.requests().get(index);
 */
    static class RetryHandler implements ActionListener<BulkResponse> {
        private static final Logger logger = LogManager.getLogger(RetryHandler.class);
        BulkRequest bulkRequest
            BackoffPolicy backoffPolicy,
                    retryCancellable.cancel();
                    addResponses(bulkItemResponses, (r -> !r.isFailed()));
                }
                if (canRetry(bulkItemResponses)) {
                    }
                    // Use client-side lock here to avoid visibility issues. This method may be called multiple times
        }
            for (BulkItemResponse bulkItemResponse : response) {
    }
        private volatile Scheduler.Cancellable retryCancellable;
    }
     */
        }
        private BulkResponse getAccumulatedResponse() {
            if (e instanceof RemoteTransportException && ((RemoteTransportException) e).status() == RETRY_STATUS && backoff.hasNext()) {
import org.opensearch.threadpool.ThreadPool;
     */
                }
 * software distributed under the License is distributed on an
import org.apache.logging.log4j.LogManager;
            long totalLatencyMs = TimeValue.timeValueNanos(stopTimestamp - startTimestampNanos).millis();
                try {
            for (BulkItemResponse bulkItemResponse : bulkItemResponses) {
                    }
            assert backoff.hasNext();
            if (!backoff.hasNext()) {
                    addResponses(bulkItemResponses, (r -> true));
        }
 * Unless required by applicable law or agreed to in writing,
    public PlainActionFuture<BulkResponse> withBackoff(
}
import org.opensearch.threadpool.Scheduler;
 * You may obtain a copy of the License at
    private final BackoffPolicy backoffPolicy;
        // needed to construct the next bulk request based on the response to the previous one
        ActionListener<BulkResponse> listener
                if (bulkItemResponse.isFailed()) {
    private final Scheduler scheduler;
    ) {
                    }
            try {
            ActionListener<BulkResponse> listener,
 */
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
            }
            BulkRequest requestToReissue = new BulkRequest().pipeline(globalPipeline);
                }
     * @param bulkRequest The bulk request that should be executed.
            // in contrast to System.currentTimeMillis(), nanoTime() uses a monotonic clock under the hood
            this.scheduler = scheduler;
                    // scheduled on the same thread is fragile.
                    // (based on how many retries we have to issue) and relying that the response handling code will be
     * @param listener A listener that is invoked when the bulk request finishes or completes with an exception. The listener is not
        }
 * The OpenSearch Contributors require contributions made to
            } else {
            return true;
 */
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
        private final ActionListener<BulkResponse> listener;
    /**
            TimeValue next = backoff.next();
        private static final RestStatus RETRY_STATUS = RestStatus.TOO_MANY_REQUESTS;
    /**
        public void execute(BulkRequest bulkRequest) {
            this.startTimestampNanos = System.nanoTime();
 * Licensed to Elasticsearch under one or more contributor
    /**
            }
import org.opensearch.transport.RemoteTransportException;
                        && docWriteRequest instanceof IndexRequest indexRequest) {
import java.util.List;
        PlainActionFuture<BulkResponse> future = PlainActionFuture.newFuture();
     */
import java.util.function.Predicate;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
import org.opensearch.core.action.ActionListener;
 *
        @Override
     * provided listener. Retries will be scheduled using the class's thread pool.
 * compatible open source license.
            }
import org.apache.logging.log4j.Logger;
                    requestToReissue.add(docWriteRequest);
                if (filter.test(bulkItemResponse)) {
                listener.onResponse(getAccumulatedResponse());
                } else {
import org.opensearch.core.rest.RestStatus;
                        responses.add(bulkItemResponse);
                if (bulkItemResponse.isFailed()) {
        }
                retry(currentBulkRequest);
            synchronized (responses) {
     * @param bulkRequest The bulk request that should be executed.
            logger.trace("Retry of bulk request scheduled in {} ms.", next.millis());
 * this work for additional information regarding copyright
 * under the License.
/**
import java.util.ArrayList;
                    listener.onFailure(e);
                }
package org.opensearch.action.bulk;
     * Invokes #accept(BulkRequest, ActionListener). Backs off on the provided exception and delegates results to the
            }
        public void onFailure(Exception e) {
     * @param consumer The consumer to which apply the request and listener
                        // reset it
    public void withBackoff(
     * @param consumer The consumer to which apply the request and listener
        RetryHandler(
            }
    }
     * Retry handler
 *
        @Override
                    if (status != RETRY_STATUS) {
            } finally {
     *
            if (!bulkItemResponses.hasFailures()) {
     * @return a future representing the bulk response returned by the client.
            consumer.accept(bulkRequest, this);
/*
            } else {
        private void finishHim() {
        ) {
                    if (retryCancellable != null) {
                }
        r.execute(bulkRequest);
 *
 * ownership. Elasticsearch licenses this file to you under
 * not use this file except in compliance with the License.
                    // when executing pipeline failed with retryable exception, the pipeline needs to be executed again
                addResponses(bulkItemResponses, (r -> true));
 * KIND, either express or implied.  See the License for the
        }
                finishHim();
import org.opensearch.action.support.PlainActionFuture;
                index++;
 * Modifications Copyright OpenSearch Contributors. See
                } finally {
        // Access only when holding a client-side lock, see also #addResponses()
public class Retry {
        withBackoff(consumer, bulkRequest, future);
        private volatile BulkRequest currentBulkRequest;
import org.opensearch.common.unit.TimeValue;
 * license agreements. See the NOTICE file distributed with
            }
                    retry(createBulkRequestForRetry(bulkItemResponses));
                }
        private final Scheduler scheduler;
            return requestToReissue;
        // volatile as we're called from a scheduled thread
            this.listener = listener;
                        // Reset pipeline configuration for retry, after the first execution, the pipeline was set to _none, so we need to
                itemResponses = responses.toArray(new BulkItemResponse[1]);
                return false;
        public void onResponse(BulkResponse bulkItemResponses) {
