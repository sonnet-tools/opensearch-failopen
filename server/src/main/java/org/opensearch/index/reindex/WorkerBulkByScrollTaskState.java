import static org.opensearch.common.unit.TimeValue.timeValueNanos;
/**
            getRequestsPerSecond(),
        if (delayed.scheduled == null) {
    }
     * Schedule prepareBulkRequestRunnable to run after some delay. This is where throttling plugs into reindexing so the request can be
        total.set(totalHits);
        return timeValueNanos(waitTime);
        setRequestsPerSecond(requestsPerSecond);
    /**
            DelayedPrepareBulkRequest delayedPrepareBulkRequest = this.delayedPrepareBulkRequestReference.get();
    }
    private final AtomicLong versionConflicts = new AtomicLong(0);
    private final AtomicLong throttledNanos = new AtomicLong();
 * not use this file except in compliance with the License.
        DelayedPrepareBulkRequest delayed = delayedPrepareBulkRequestReference.get();
        // requests
            noops.get(),
        if (delayed == null) {
     * Maximum wait time allowed for throttling.
    }
    }
    public void setTotal(long totalHits) {
            batch.get(),
     * rescheduled over and over again.
import org.opensearch.threadpool.Scheduler;
                logger.debug(
 * this file be licensed under the Apache-2.0 license or a
import static java.lang.Math.min;
    private final AtomicLong deleted = new AtomicLong(0);
    /**
                 * change in throttle take effect the next time we delay
    TimeValue throttledUntil() {
/*
        );
            searchRetries.get(),
                );
        }
    private final AtomicLong bulkRetries = new AtomicLong(0);
            }, delay, ThreadPool.Names.GENERIC);
    public void handleCancel() {
    private volatile float requestsPerSecond;
        if (requestsPerSecond <= 0) {
            logger.debug("[{}]: rethrottling to [{}] requests per second", task.getId(), newRequestsPerSecond);
        /**
    private final AtomicLong updated = new AtomicLong(0);
            if (scheduled == null || false == scheduled.cancel()) {
            logger.debug("[{}]: rescheduling for [{}] in the future", task.getId(), newDelay);
        long lastBatchStartTimeNS,
        return TimeUnit.SECONDS.toNanos(1) * targetBatchTimeInSeconds;
    }
     */
        noops.incrementAndGet();
    private void setRequestsPerSecond(float requestsPerSecond) {
    }
                    requestsPerSecond
     * The id of the slice that this worker is processing or {@code null} if this task isn't for a sliced request.
            throttledUntil()
    private static final Logger logger = LogManager.getLogger(WorkerBulkByScrollTaskState.class);
import java.util.concurrent.atomic.AtomicLong;
     * How many nanoseconds should a batch of lastBatchSize have taken if it were perfectly throttled? Package private for testing.
}
            versionConflicts.get(),
    private final Integer sliceId;
 * license agreements. See the NOTICE file distributed with
    public void countCreated() {
            bulkRetries.get(),
         * Scale back remaining delay to fit the new delay.
    public long getDeleted() {
            this.threadPool = threadPool;
    public TimeValue throttleWaitTime(long lastBatchStartTimeNS, long nowNS, int lastBatchSize) {
 */
 * ownership. Elasticsearch licenses this file to you under
public class WorkerBulkByScrollTaskState implements SuccessfullyProcessed {
            sliceId,
        }
 * GitHub history for details.
    }
    }
            this.command = command;
        private final float requestsPerSecond;
                );
        return new BulkByScrollTask.Status(
                    "[{}]: skipping rescheduling because the new throttle [{}] is slower than the old one [{}]",
     */
    float perfectlyThrottledBatchTime(int lastBatchSize) {
        }
    public void countUpdated() {
                /* The user is attempting to slow the request down. We'll let the
        }
package org.opensearch.index.reindex;
        synchronized (delayedPrepareBulkRequestReference) {
 * @opensearch.internal
import org.apache.logging.log4j.Logger;
    public void countBulkRetry() {
            setRequestsPerSecond(newRequestsPerSecond);
            created.get(),
        private final Runnable command;
        }
                // No request has been queued so nothing to reschedule.
    }
             * cancelled the request, just that you probably did. If you stress
                    task.getId(),
 * Licensed to Elasticsearch under one or more contributor
     * to process. Its ok that these have the same meaning because any request with 0 actual documents should be quite short lived.
        // Drop the throttle to 0, immediately rescheduling any throttle operation so it will wake up and cancel itself.
    public void countVersionConflict() {
        private final ThreadPool threadPool;
            if (newRequestsPerSecond < requestsPerSecond) {
        DelayedPrepareBulkRequest rethrottle(float newRequestsPerSecond) {
                return this;
    public void delayPrepareBulkRequest(
import org.opensearch.common.util.concurrent.AbstractRunnable;
                // Couldn't cancel, probably because the task has finished or been scheduled. Either way we have nothing to do here.
            throw new IllegalArgumentException("requests per second must be more than 0 but was [" + requestsPerSecond + "]");
    private static final TimeValue MAX_THROTTLE_WAIT_TIME = TimeValue.timeValueHours(1);
    }
        TimeValue newDelay(long remainingDelay, float newRequestsPerSecond) {
                    new DelayedPrepareBulkRequest(threadPool, getRequestsPerSecond(), delay, new RunOnce(prepareBulkRequestRunnable))
    }
/*
    /**
                return this;
            try {
        }
     * style variables but there isn't an AtomicFloat so we just use a volatile.
        long earliestNextBatchStartTime = nowNS + (long) perfectlyThrottledBatchTime(lastBatchSize);
        bulkRetries.incrementAndGet();
    private final AtomicLong noops = new AtomicLong(0);
             * test it you'll find that requests sneak through. So each request
                return;
import org.opensearch.threadpool.ThreadPool;
    public WorkerBulkByScrollTaskState(BulkByScrollTask task, Integer sliceId, float requestsPerSecond) {
    @Override
    ) {
    }
            }
    }
                command.run();
import org.opensearch.common.util.concurrent.RunOnce;
            task.getReasonCancelled(),
     */
             * is given a runOnce boolean to prevent that. */
         */
    public BulkByScrollTask.Status getStatus() {
            TimeValue newDelay = newDelay(remainingDelay, newRequestsPerSecond);
    private final AtomicInteger batch = new AtomicInteger(0);
     */
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
    }
        deleted.incrementAndGet();
     */
        versionConflicts.incrementAndGet();
            /* Strangely enough getting here doesn't mean that you actually
        // request per seconds
            }
            this.delayedPrepareBulkRequestReference.set(delayedPrepareBulkRequest.rethrottle(newRequestsPerSecond));
        rethrottle(Float.POSITIVE_INFINITY);
    }
    @Override
                    newRequestsPerSecond,
 * Modifications Copyright OpenSearch Contributors. See
     * Apply {@code newRequestsPerSecond} as the new rate limit for this task's search requests
            total.get(),
    /**
        if (requestsPerSecond == Float.POSITIVE_INFINITY) {
 * software distributed under the License is distributed on an
        }
     * The total number of documents this request will process. 0 means we don't yet know or, possibly, there are actually 0 documents
     */
            deleted.get(),
    public void countSearchRetry() {
        long waitTime = min(MAX_THROTTLE_WAIT_TIME.nanos(), max(0, earliestNextBatchStartTime - System.nanoTime()));
        return timeValueNanos(max(0, delayed.scheduled.getDelay(TimeUnit.NANOSECONDS)));
 * The OpenSearch Contributors require contributions made to
    }
            return 0;
    public long getUpdated() {
 * Unless required by applicable law or agreed to in writing,
            long remainingDelay = scheduled.getDelay(TimeUnit.NANOSECONDS);
    }
            } catch (OpenSearchRejectedExecutionException e) {
    public long getCreated() {
import java.util.concurrent.atomic.AtomicReference;
    }
        ThreadPool threadPool,
        this.task = task;
/*
 *
    }
    private final AtomicLong total = new AtomicLong(0);
        }
        created.incrementAndGet();
import org.apache.logging.log4j.LogManager;
                prepareBulkRequestRunnable.onRejection(e);
    public void countDeleted() {
 * specific language governing permissions and limitations
import static java.lang.Math.round;
    public void rethrottle(float newRequestsPerSecond) {
 * compatible open source license.
            updated.get(),
            return timeValueNanos(0);
        // Synchronize so we are less likely to schedule the same request twice.
        return created.get();
    /**
    /**
        }
    private final BulkByScrollTask task;
                delayedPrepareBulkRequestReference.set(
 */
            // Actually reschedule the task
                logger.debug("[{}]: skipping rescheduling because we couldn't cancel the task", task.getId());
            return timeValueNanos(round(remainingDelay * requestsPerSecond / newRequestsPerSecond));
 *
 * Task behavior for {@link BulkByScrollTask} that does the actual work of querying and indexing
                return timeValueNanos(0);
        // ------------------- == seconds
        batch.incrementAndGet();
 * KIND, either express or implied.  See the License for the
    float getRequestsPerSecond() {
 *
        DelayedPrepareBulkRequest(ThreadPool threadPool, float requestsPerSecond, TimeValue delay, Runnable command) {
            logger.debug("[{}]: preparing bulk request for [{}]", task.getId(), delay);
    public void countBatch() {
    }
import java.util.concurrent.TimeUnit;
     * The number of requests per second to which to throttle the request that this task represents. The other variables are all AtomicXXX
 *    http://www.apache.org/licenses/LICENSE-2.0
                 * out in the future because the bulk context might time out. */
    }
                 * prepareBulkRequest. We can't just reschedule the request further
            this.requestsPerSecond = requestsPerSecond;
import static java.lang.Math.max;
    private final AtomicReference<DelayedPrepareBulkRequest> delayedPrepareBulkRequestReference = new AtomicReference<>();
        this.sliceId = sliceId;
    /**
                logger.debug("[{}]: skipping rescheduling because there is no scheduled task", task.getId());
        return deleted.get();
import org.opensearch.common.unit.TimeValue;
    public void countNoop() {
            return new DelayedPrepareBulkRequest(threadPool, requestsPerSecond, newDelay, command);
     */
        AbstractRunnable prepareBulkRequestRunnable
            }
            }
            this.scheduled = threadPool.schedule(() -> {
        int lastBatchSize,
 */
    }
    }
    private final AtomicLong created = new AtomicLong(0);
            if (delayedPrepareBulkRequest == null) {
    class DelayedPrepareBulkRequest {
        return requestsPerSecond;
    @Override
     * Reference to any the last delayed prepareBulkRequest call. Used during rethrottling and canceling to reschedule the request.
        updated.incrementAndGet();
            timeValueNanos(throttledNanos.get()),
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * SPDX-License-Identifier: Apache-2.0
                throttledNanos.addAndGet(delay.nanos());
            return timeValueNanos(0);
            TimeValue delay = throttleWaitTime(lastBatchStartTimeNS, System.nanoTime(), lastBatchSize);
        this.requestsPerSecond = requestsPerSecond;
 * under the License.
 * the Apache License, Version 2.0 (the "License"); you may
    private final AtomicLong searchRetries = new AtomicLong(0);
        return updated.get();
            }
    /**
 * You may obtain a copy of the License at
        float targetBatchTimeInSeconds = lastBatchSize / requestsPerSecond;
     */
import java.util.concurrent.atomic.AtomicInteger;
        private final Scheduler.ScheduledCancellable scheduled;
        searchRetries.incrementAndGet();
 *
 */
            if (remainingDelay < 0) {
        // nanoseconds per seconds * seconds == nanoseconds
        synchronized (delayedPrepareBulkRequestReference) {
