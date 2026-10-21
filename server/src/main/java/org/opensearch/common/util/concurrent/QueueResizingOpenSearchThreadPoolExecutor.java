                        totalNanos
                if (oldCapacity != newCapacity && logger.isDebugEnabled()) {
    }
        return super.wrapRunnable(this.runnableWrapper.apply(command));
        int minQueueSize,
        // λ = total tasks divided by measurement time
     */
 *
                final double lambda = calculateLambda(tasksPerFrame, Math.max(totalNanos, 1L));
        // only want runnables that did not throw errors though, because they could be fast-failures
        long keepAliveTime,
                        String.format(Locale.ROOT, "%.2f", lambda * TimeValue.timeValueSeconds(1).nanos()),
            QUEUE_ADJUSTMENT_AMOUNT
 *
 * GitHub history for details.
                if (tasks >= this.tasksPerFrame) {
    /**
     * @return the optimal queue size for the give task rate and targeted response time
                    // so there will be no further adjustments
                        TimeValue.timeValueNanos(totalRuntime),
        return (double) totalNumberOfTasks / totalFrameTaskNanos;
    @Override
        sb.append("adjustment amount = ").append(QUEUE_ADJUSTMENT_AMOUNT).append(", ");
            : "expected task to always take longer than 0 nanoseconds or have '-1' failure code, got: "
                        "[{}]: too many incoming tasks while queue size adjustment occurs, resetting measurements to 0",
    private final int tasksPerFrame;
        ThreadFactory threadFactory,
/**
                    // consider the following:
    static double calculateLambda(final int totalNumberOfTasks, final long totalFrameTaskNanos) {
        super(name, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler, contextHolder);
    }
        );
    private final Function<Runnable, WrappedRunnable> runnableWrapper;
 * @opensearch.internal
            "thread pool [{}] will adjust queue by [{}] when determining automatic queue size",
 * ownership. Elasticsearch licenses this file to you under
     * @return the rate of tasks in the system
    private final int minQueueSize;
    }
    }
 * The OpenSearch Contributors require contributions made to
     * Calculate task rate (λ), for a fixed number of tasks and time it took those tasks to be measured
 *
                            + "[{} tasks/s], optimal queue is [{}], current capacity [{}]",
    ) {
            // is protected by the taskCount memory barrier.
            try {
                    // Start over, because we can potentially reach a "never adjusting" state,
                        oldCapacity
     * Calculate Little's Law (L), which is the "optimal" queue size for a particular task rate (lambda) and targeted response time.
                        tasksPerFrame,
    protected Runnable wrapRunnable(Runnable command) {
 * {@code ResizableBlockingQueue} according to Little's Law.
 * this file be licensed under the Apache-2.0 license or a
        return poolWaitTime.count();
        sb.append("frame size = ").append(tasksPerFrame).append(", ");
    private final ExponentiallyWeightedMovingAverage executionEWMA;
                + ", failedOrRejected: "
        if (unwrapped instanceof WrappedRunnable) {
                    // - If the frame window is 10, and there are 10 tasks, then an adjustment will begin. (taskCount == 10)
                );
        final TimedRunnable timedRunnable = (TimedRunnable) super.unwrap(r);
        XRejectedExecutionHandler handler,
    private long startNs;
                        tasksPerFrame,
 * license agreements. See the NOTICE file distributed with
 * under the License.
            executionEWMA.addValue(taskExecutionNanos);
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final AtomicInteger taskCount = new AtomicInteger(0);
        final int tasksPerFrame,
    /**
                        oldCapacity,
        return Math.toIntExact((long) (lambda * targetedResponseTimeNanos));
                        totalRuntime,
 */
                        "[{}]: there were [{}] tasks in [{}], avg task time [{}], EWMA task execution [{}], "
        poolWaitTime.inc(timedRunnable.getWaitTimeNanos());
        this.runnableWrapper = runnableWrapper;
 * the Apache License, Version 2.0 (the "License"); you may
                assert tasks >= 0 : "tasks should never be negative, got: " + tasks;
        EWMATrackingThreadPoolExecutor {
                + failedOrRejected;
import java.util.concurrent.atomic.AtomicInteger;
 */
    // The amount the queue size is adjusted by for each calcuation
    }
}
        if (taskExecutionNanos != -1) {
        this.workQueue = workQueue;
     *
    @Override
     *
    @Override
                    //
                    );
                final int oldCapacity = workQueue.capacity();
                }
        assert targetedResponseTimeNanos > 0 : "cannot calculate for instantaneous requests";
    }
                // values the queue size can have.
        assert super.unwrap(r) instanceof TimedRunnable : "expected only TimedRunnables in queue";
 * specific language governing permissions and limitations
        }
                // Adjust the queue size towards the desired capacity using an adjust of
    private final CounterMetric poolWaitTime;
                // QUEUE_ADJUSTMENT_AMOUNT (either up or down), keeping in mind the min and max
                int tasks = taskCount.addAndGet(-this.tasksPerFrame);
import java.util.concurrent.atomic.AtomicLong;
                            + "total frame time [{}ns], tasks [{}], task execution time [{}ns]",
import org.apache.logging.log4j.message.ParameterizedMessage;
                // to zero causes operations that came in during the adjustment to be uncounted
        this.poolWaitTime = new CounterMetric();
        int maxQueueSize,
            // Reset the start time for all tasks. At first glance this appears to need to be
                        getName(),
    private final int maxQueueSize;
                final int newCapacity = workQueue.adjustCapacity(desiredQueueSize, QUEUE_ADJUSTMENT_AMOUNT, minQueueSize, maxQueueSize);
    private final ResizableBlockingQueue<Runnable> workQueue;
            final long totalRuntime = endTimeNs - this.startNs;
/*
 * Unless required by applicable law or agreed to in writing,
public final class QueueResizingOpenSearchThreadPoolExecutor extends OpenSearchThreadPoolExecutor
import org.opensearch.common.metrics.CounterMetric;
 * software distributed under the License is distributed on an
            } catch (ArithmeticException e) {
import org.opensearch.common.unit.TimeValue;
    public long getPoolWaitTimeNanos() {
        int corePoolSize,
        // total time as a combination of the time in the queue and time spent running the task. We
                // do this at the end so there is no concurrent adjustments happening. We also
    public double getTaskExecutionEWMA() {
 * compatible open source license.
            return unwrapped;
                // decrement them instead of resetting them back to zero, as resetting them back
            }
                        newCapacity
 * KIND, either express or implied.  See the License for the
        logger.debug(
                    // Do a regular adjustment
 * this work for additional information regarding copyright
                }
            getName(),
        // total runtime, rather than a fixed interval.
            // Calculate the new desired queue size
        final boolean failedOrRejected = timedRunnable.getFailedOrRejected();
                if (logger.isDebugEnabled()) {
    private static final Logger logger = LogManager.getLogger(QueueResizingOpenSearchThreadPoolExecutor.class);
package org.opensearch.common.util.concurrent;
        this.tasksPerFrame = tasksPerFrame;
 *
                    ),
        return executionEWMA.getAverage();
                    e
     */
import java.util.Locale;
 * Modifications Copyright OpenSearch Contributors. See
        assert taskExecutionNanos >= 0 || (failedOrRejected && taskExecutionNanos == -1)
    @Override
    private final AtomicLong totalTaskNanos = new AtomicLong(0);
/*
     * @param totalNumberOfTasks total number of tasks that were measured
                    logger.debug(
import org.opensearch.common.ExponentiallyWeightedMovingAverage;
        final long taskExecutionNanos = timedRunnable.getTotalExecutionNanos();
                        getName()
                    // - Adjustment happens and we decrement the tasks by 10, taskCount is now 15
        final Runnable unwrapped = super.unwrap(runnable);
        // number of completed tasks, so there is no background thread required to update the
     * Returns the exponentially weighted moving average of the task execution time
                        getName(),
            // volatile, since we are reading from a different thread when it is set, but it
 * SPDX-License-Identifier: Apache-2.0
    }
/*
import org.apache.logging.log4j.LogManager;
    implements
                        getName(),
        // There is no set execution time, instead we adjust the time window based on the
import org.apache.logging.log4j.Logger;
 */
                    logger.debug(
                    taskCount.getAndSet(0);
        ThreadContext contextHolder
                    // - Since taskCount will now be incremented forever, it will never be 10 again,
    /**
                    final long avgTaskTime = totalNanos / tasksPerFrame;
    @Override
                    );
        sb.append("min queue capacity = ").append(minQueueSize).append(", ");
                } else {
 * An extension to thread pool executor, which automatically adjusts the queue size of the
        final long taskNanos = timedRunnable.getTotalNanos();
            return ((WrappedRunnable) unwrapped).unwrap();
        this.startNs = System.nanoTime();
        final long totalNanos = totalTaskNanos.addAndGet(taskNanos);
        this.maxQueueSize = maxQueueSize;
     */
                final int desiredQueueSize = calculateL(lambda, targetedResponseTimeNanos);
 * You may obtain a copy of the License at
                        newCapacity > oldCapacity ? QUEUE_ADJUSTMENT_AMOUNT : -QUEUE_ADJUSTMENT_AMOUNT,
                    totalTaskNanos.getAndSet(1);
                logger.warn(
                + taskExecutionNanos
 * not use this file except in compliance with the License.
    private final long targetedResponseTimeNanos;
                        "failed to calculate optimal queue size for [{}] thread pool, "
import java.util.concurrent.TimeUnit;
    protected void appendThreadPoolExecutorDetails(StringBuilder sb) {
        String name,
        }
                        TimeValue.timeValueNanos((long) executionEWMA.getAverage()),
        this.executionEWMA = new ExponentiallyWeightedMovingAverage(EWMA_ALPHA, 0);
        sb.append("targeted response rate = ").append(TimeValue.timeValueNanos(targetedResponseTimeNanos)).append(", ");
        int maximumPoolSize,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // taskExecutionNanos may be -1 if the task threw an exception
                // There was an integer overflow, so just log about it, rather than adjust the queue size
                // Finally, decrement the task count and time back to their starting values. We
    protected void afterExecute(Runnable r, Throwable t) {
                    startNs = System.nanoTime();
        ResizableBlockingQueue<Runnable> workQueue,
    protected Runnable unwrap(Runnable runnable) {
     * @param targetedResponseTimeNanos nanoseconds for the average targeted response rate of requests
        super.afterExecute(r, t);
     * @param lambda the arrival rate of tasks in nanoseconds
    @Override
        TimeValue targetedResponseTime,
        } else {
 */
    }
        assert totalNumberOfTasks > 0 : "cannot calculate for no tasks, got: " + totalNumberOfTasks;
                    totalTaskNanos.addAndGet(-totalNanos);
     * Returns the current queue size (operations that are queued)
            // See: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html
        // A task has been completed, it has left the building. We should now be able to get the
        sb.append("max queue capacity = ").append(maxQueueSize).append(", ");
import java.util.concurrent.ThreadFactory;
        // that throw off our timings, so only check when t is null.
            final long endTimeNs = System.nanoTime();
            startNs = endTimeNs;
    /**
        // queue size at a regular interval. This means we need to calculate our λ by the
        sb.append("task execution EWMA = ").append(TimeValue.timeValueNanos((long) executionEWMA.getAverage())).append(", ");
        if (taskCount.incrementAndGet() == this.tasksPerFrame) {
     * @param totalFrameTaskNanos nanoseconds during which the tasks were received
                        "adjusted [{}] queue size by [{}], old capacity: [{}], new capacity: [{}]",
                    logger.debug(
        }
    }
                    () -> new ParameterizedMessage(
                        desiredQueueSize,
    private static final int QUEUE_ADJUSTMENT_AMOUNT = 50;
                    // - Prior to the adjustment being done, 15 more tasks come in, the taskCount is now 25
    public int getCurrentQueueSize() {
 * Licensed to Elasticsearch under one or more contributor
                        TimeValue.timeValueNanos(avgTaskTime),
import java.util.function.Function;
            } finally {
        return workQueue.size();
    @Override
    QueueResizingOpenSearchThreadPoolExecutor(
                    );
        this.targetedResponseTimeNanos = targetedResponseTime.getNanos();
        TimeUnit unit,
        this.minQueueSize = minQueueSize;
     */
    static int calculateL(final double lambda, final long targetedResponseTimeNanos) {
                }
        assert totalFrameTaskNanos > 0 : "cannot calculate for instantaneous tasks, got: " + totalFrameTaskNanos;
        Function<Runnable, WrappedRunnable> runnableWrapper,
    }
        // L = λ * W
