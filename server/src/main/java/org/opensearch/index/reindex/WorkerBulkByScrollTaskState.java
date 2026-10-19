    private final AtomicLong deleted = new AtomicLong(0);  
    private final AtomicLong updated = new AtomicLong(0);
     * Schedule prepareBulkRequestRunnable to run after some delay. This is where throttling plugs into reindexing so the request can be
                command.run();  
    class DelayedPrepareBulkRequest {  
public class WorkerBulkByScrollTaskState implements SuccessfullyProcessed {
import java.util.concurrent.atomic.AtomicLong;  
        private final Scheduler.ScheduledCancellable scheduled;
            return 0;  
    /**
    public long getDeleted() {
import java.util.concurrent.TimeUnit;
        deleted.incrementAndGet();
    }
        // requests
import org.opensearch.threadpool.Scheduler;
                // Couldn't cancel, probably because the task has finished or been scheduled. Either way we have nothing to do here.  
            return timeValueNanos(0);
                return;
                // No request has been queued so nothing to reschedule.  
        return new BulkByScrollTask.Status(
        // ------------------- == seconds  
     * How many nanoseconds should a batch of lastBatchSize have taken if it were perfectly throttled? Package private for testing.
        updated.incrementAndGet();
        }
            }  
    private final AtomicLong throttledNanos = new AtomicLong();  
import org.opensearch.threadpool.ThreadPool;
    /**
        DelayedPrepareBulkRequest rethrottle(float newRequestsPerSecond) {
 * compatible open source license.
         */
            logger.debug("[{}]: rescheduling for [{}] in the future", task.getId(), newDelay);
        return TimeUnit.SECONDS.toNanos(1) * targetBatchTimeInSeconds;
        }  
     */  
    private final AtomicLong bulkRetries = new AtomicLong(0);
        }
            logger.debug("[{}]: rethrottling to [{}] requests per second", task.getId(), newRequestsPerSecond);
    ) {
     */
    public long getUpdated() {
import java.util.concurrent.atomic.AtomicInteger;
    }
            TimeValue newDelay = newDelay(remainingDelay, newRequestsPerSecond);
    @Override
        return created.get();  
            updated.get(),
    }  
import static java.lang.Math.round;
            /* Strangely enough getting here doesn't mean that you actually  
import org.opensearch.common.util.concurrent.AbstractRunnable;
        created.incrementAndGet();
        long lastBatchStartTimeNS,
        synchronized (delayedPrepareBulkRequestReference) {  
    }
        AbstractRunnable prepareBulkRequestRunnable  
                logger.debug("[{}]: skipping rescheduling because there is no scheduled task", task.getId());
    }
                );  
    public void setTotal(long totalHits) {
                 * prepareBulkRequest. We can't just reschedule the request further
    float getRequestsPerSecond() {
 *  
        this.requestsPerSecond = requestsPerSecond;
    private final BulkByScrollTask task;
        searchRetries.incrementAndGet();
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
    }
        rethrottle(Float.POSITIVE_INFINITY);
 * specific language governing permissions and limitations
        }
    private final AtomicLong versionConflicts = new AtomicLong(0);  
    private final AtomicLong searchRetries = new AtomicLong(0);
        TimeValue newDelay(long remainingDelay, float newRequestsPerSecond) {  
        return updated.get();  
        }
        }  
    public void countBatch() {
 * Unless required by applicable law or agreed to in writing,
import org.apache.logging.log4j.LogManager;
    }
    private void setRequestsPerSecond(float requestsPerSecond) {
                    task.getId(),  
                    "[{}]: skipping rescheduling because the new throttle [{}] is slower than the old one [{}]",
    public void delayPrepareBulkRequest(
     * Reference to any the last delayed prepareBulkRequest call. Used during rethrottling and canceling to reschedule the request.  
    public void countDeleted() {  
                delayedPrepareBulkRequestReference.set(
            this.command = command;  
    /**
    }
            }, delay, ThreadPool.Names.GENERIC);
    }  
    private final Integer sliceId;  
 * this work for additional information regarding copyright
            noops.get(),
            throttledUntil()
        DelayedPrepareBulkRequest(ThreadPool threadPool, float requestsPerSecond, TimeValue delay, Runnable command) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
                logger.debug("[{}]: skipping rescheduling because we couldn't cancel the task", task.getId());
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
    private final AtomicLong created = new AtomicLong(0);
            }
        setRequestsPerSecond(requestsPerSecond);
    }
            this.threadPool = threadPool;
            // Actually reschedule the task
            getRequestsPerSecond(),
    @Override
    public void countCreated() {  
        // request per seconds
 * KIND, either express or implied.  See the License for the
        return timeValueNanos(max(0, delayed.scheduled.getDelay(TimeUnit.NANOSECONDS)));
        total.set(totalHits);
import java.util.concurrent.atomic.AtomicReference;
        private final Runnable command;
    }  
            if (newRequestsPerSecond < requestsPerSecond) {
        float targetBatchTimeInSeconds = lastBatchSize / requestsPerSecond;
    public long getCreated() {
                prepareBulkRequestRunnable.onRejection(e);
     */
    public void countSearchRetry() {  
    public void countBulkRetry() {
            deleted.get(),
        long earliestNextBatchStartTime = nowNS + (long) perfectlyThrottledBatchTime(lastBatchSize);
 */
            total.get(),
import org.apache.logging.log4j.Logger;
    public void handleCancel() {
    public void countNoop() {  
     * Apply {@code newRequestsPerSecond} as the new rate limit for this task's search requests  
        }
    private static final Logger logger = LogManager.getLogger(WorkerBulkByScrollTaskState.class);  
    float perfectlyThrottledBatchTime(int lastBatchSize) {
    TimeValue throttledUntil() {
    }
import static java.lang.Math.min;
            try {  
     */
         * Scale back remaining delay to fit the new delay.
            throw new IllegalArgumentException("requests per second must be more than 0 but was [" + requestsPerSecond + "]");  
    private final AtomicLong noops = new AtomicLong(0);
    private final AtomicInteger batch = new AtomicInteger(0);
 * @opensearch.internal
                );  
    private static final TimeValue MAX_THROTTLE_WAIT_TIME = TimeValue.timeValueHours(1);
            created.get(),  
            sliceId,  
 * this file be licensed under the Apache-2.0 license or a
    public WorkerBulkByScrollTaskState(BulkByScrollTask task, Integer sliceId, float requestsPerSecond) {
            timeValueNanos(throttledNanos.get()),
                 * out in the future because the bulk context might time out. */  
    private final AtomicReference<DelayedPrepareBulkRequest> delayedPrepareBulkRequestReference = new AtomicReference<>();
     * The number of requests per second to which to throttle the request that this task represents. The other variables are all AtomicXXX  
            return timeValueNanos(round(remainingDelay * requestsPerSecond / newRequestsPerSecond));
            if (scheduled == null || false == scheduled.cancel()) {
/**
     */
     * Maximum wait time allowed for throttling.  
    private final AtomicLong total = new AtomicLong(0);  
    /**
        DelayedPrepareBulkRequest delayed = delayedPrepareBulkRequestReference.get();  
 *
     * style variables but there isn't an AtomicFloat so we just use a volatile.
import org.opensearch.common.unit.TimeValue;  
 * software distributed under the License is distributed on an
 *
                return timeValueNanos(0);
    }  
    public void countVersionConflict() {
            versionConflicts.get(),  
                throttledNanos.addAndGet(delay.nanos());
            batch.get(),
}
        private final ThreadPool threadPool;
        noops.incrementAndGet();
            }  
 * under the License.  
            }  
        this.sliceId = sliceId;  
        }
            if (delayedPrepareBulkRequest == null) {
    }
             * cancelled the request, just that you probably did. If you stress
 */  
 * GitHub history for details.
 *
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
            logger.debug("[{}]: preparing bulk request for [{}]", task.getId(), delay);
            bulkRetries.get(),
            this.delayedPrepareBulkRequestReference.set(delayedPrepareBulkRequest.rethrottle(newRequestsPerSecond));
            searchRetries.get(),  
 * The OpenSearch Contributors require contributions made to  
            this.requestsPerSecond = requestsPerSecond;
    }
    public TimeValue throttleWaitTime(long lastBatchStartTimeNS, long nowNS, int lastBatchSize) {
     * The total number of documents this request will process. 0 means we don't yet know or, possibly, there are actually 0 documents  
                return this;
import static java.lang.Math.max;  
    /**
             * is given a runOnce boolean to prevent that. */  
            }  
/*
        if (requestsPerSecond <= 0) {
                return this;
        batch.incrementAndGet();  
    /**  
        private final float requestsPerSecond;  
            DelayedPrepareBulkRequest delayedPrepareBulkRequest = this.delayedPrepareBulkRequestReference.get();
 */  
import static org.opensearch.common.unit.TimeValue.timeValueNanos;  
     */
    /**
            if (remainingDelay < 0) {
                    requestsPerSecond
        int lastBatchSize,
    /**
    }  
     */
        if (requestsPerSecond == Float.POSITIVE_INFINITY) {
                    newRequestsPerSecond,
    @Override
    }
        long waitTime = min(MAX_THROTTLE_WAIT_TIME.nanos(), max(0, earliestNextBatchStartTime - System.nanoTime()));  
                logger.debug(
            } catch (OpenSearchRejectedExecutionException e) {
 * ownership. Elasticsearch licenses this file to you under  
    public void rethrottle(float newRequestsPerSecond) {
            task.getReasonCancelled(),  
    }
/*  
 */  
    private volatile float requestsPerSecond;  
     * rescheduled over and over again.  
     * The id of the slice that this worker is processing or {@code null} if this task isn't for a sliced request.
        // Drop the throttle to 0, immediately rescheduling any throttle operation so it will wake up and cancel itself.  
        synchronized (delayedPrepareBulkRequestReference) {  
            setRequestsPerSecond(newRequestsPerSecond);
    }
 * Licensed to Elasticsearch under one or more contributor  
    public void countUpdated() {  
                /* The user is attempting to slow the request down. We'll let the  
    }
package org.opensearch.index.reindex;
        this.task = task;
        return timeValueNanos(waitTime);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                 * change in throttle take effect the next time we delay
     */
            return new DelayedPrepareBulkRequest(threadPool, requestsPerSecond, newDelay, command);  
                    new DelayedPrepareBulkRequest(threadPool, getRequestsPerSecond(), delay, new RunOnce(prepareBulkRequestRunnable))
 * Task behavior for {@link BulkByScrollTask} that does the actual work of querying and indexing  
        }  
        );
        return deleted.get();  
        if (delayed.scheduled == null) {
             * test it you'll find that requests sneak through. So each request
    }  
        return requestsPerSecond;
        versionConflicts.incrementAndGet();
    }
            TimeValue delay = throttleWaitTime(lastBatchStartTimeNS, System.nanoTime(), lastBatchSize);
        ThreadPool threadPool,  
    public BulkByScrollTask.Status getStatus() {
        if (delayed == null) {
import org.opensearch.common.util.concurrent.RunOnce;
 * SPDX-License-Identifier: Apache-2.0
        bulkRetries.incrementAndGet();  
            return timeValueNanos(0);
            long remainingDelay = scheduled.getDelay(TimeUnit.NANOSECONDS);
        // nanoseconds per seconds * seconds == nanoseconds  
        // Synchronize so we are less likely to schedule the same request twice.
     * to process. Its ok that these have the same meaning because any request with 0 actual documents should be quite short lived.
    }
            this.scheduled = threadPool.schedule(() -> {
/*  
        /**  
