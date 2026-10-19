     * Calculate Little's Law (L), which is the "optimal" queue size for a particular task rate (lambda) and targeted response time.  
     * Calculate task rate (λ), for a fixed number of tasks and time it took those tasks to be measured
                    );
                if (oldCapacity != newCapacity && logger.isDebugEnabled()) {
/**  
        final long totalNanos = totalTaskNanos.addAndGet(taskNanos);  
 *     http://www.apache.org/licenses/LICENSE-2.0
        int maximumPoolSize,
 * Modifications Copyright OpenSearch Contributors. See
        }
        sb.append("task execution EWMA = ").append(TimeValue.timeValueNanos((long) executionEWMA.getAverage())).append(", ");
                assert tasks >= 0 : "tasks should never be negative, got: " + tasks;
import org.opensearch.common.metrics.CounterMetric;
        // total time as a combination of the time in the queue and time spent running the task. We
                    // consider the following:
     * @return the rate of tasks in the system  
        final TimedRunnable timedRunnable = (TimedRunnable) super.unwrap(r);  
    private final ResizableBlockingQueue<Runnable> workQueue;  
        final int tasksPerFrame,
import org.apache.logging.log4j.Logger;
        logger.debug(  
     * Returns the exponentially weighted moving average of the task execution time
/*  
                    // - Prior to the adjustment being done, 15 more tasks come in, the taskCount is now 25  
                + taskExecutionNanos
                );
            } finally {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // volatile, since we are reading from a different thread when it is set, but it  
            } catch (ArithmeticException e) {
                    taskCount.getAndSet(0);  
                // decrement them instead of resetting them back to zero, as resetting them back
 * under the License.  
                        getName(),
     *
        TimeValue targetedResponseTime,  
    protected Runnable wrapRunnable(Runnable command) {
            final long endTimeNs = System.nanoTime();  
                        desiredQueueSize,
    private static final int QUEUE_ADJUSTMENT_AMOUNT = 50;  
        ResizableBlockingQueue<Runnable> workQueue,
                    startNs = System.nanoTime();
 * this work for additional information regarding copyright
    private final AtomicLong totalTaskNanos = new AtomicLong(0);
    }
    @Override
        return Math.toIntExact((long) (lambda * targetedResponseTimeNanos));  
                final int desiredQueueSize = calculateL(lambda, targetedResponseTimeNanos);
                        totalNanos
                } else {
     */
                        tasksPerFrame,
                    logger.debug(
            // Calculate the new desired queue size
    public long getPoolWaitTimeNanos() {  
    public int getCurrentQueueSize() {  
    }  
        this.targetedResponseTimeNanos = targetedResponseTime.getNanos();  
                + failedOrRejected;
    /**  
            startNs = endTimeNs;  
        // queue size at a regular interval. This means we need to calculate our λ by the
    @Override
                        oldCapacity,  
                }
                        getName()  
 * {@code ResizableBlockingQueue} according to Little's Law.
            getName(),
            QUEUE_ADJUSTMENT_AMOUNT  
 * ownership. Elasticsearch licenses this file to you under  
        ThreadContext contextHolder  
        this.tasksPerFrame = tasksPerFrame;
                // values the queue size can have.
                        getName(),
        final boolean failedOrRejected = timedRunnable.getFailedOrRejected();
import org.apache.logging.log4j.message.ParameterizedMessage;  
        XRejectedExecutionHandler handler,
        final Runnable unwrapped = super.unwrap(runnable);
        this.poolWaitTime = new CounterMetric();
    /**
    private final Function<Runnable, WrappedRunnable> runnableWrapper;
 * software distributed under the License is distributed on an
import java.util.concurrent.ThreadFactory;  
    }
 *
        Function<Runnable, WrappedRunnable> runnableWrapper,
     *  
        this.executionEWMA = new ExponentiallyWeightedMovingAverage(EWMA_ALPHA, 0);
                        tasksPerFrame,  
        this.minQueueSize = minQueueSize;
                        newCapacity > oldCapacity ? QUEUE_ADJUSTMENT_AMOUNT : -QUEUE_ADJUSTMENT_AMOUNT,
package org.opensearch.common.util.concurrent;
        TimeUnit unit,  
 * this file be licensed under the Apache-2.0 license or a
        );
        return super.wrapRunnable(this.runnableWrapper.apply(command));  
        super.afterExecute(r, t);  
            return unwrapped;  
            // is protected by the taskCount memory barrier.
        final long taskExecutionNanos = timedRunnable.getTotalExecutionNanos();
 * not use this file except in compliance with the License.
        ThreadFactory threadFactory,
    private final long targetedResponseTimeNanos;
 * An extension to thread pool executor, which automatically adjusts the queue size of the
                        totalRuntime,
    ) {
                            + "[{} tasks/s], optimal queue is [{}], current capacity [{}]",  
    private final CounterMetric poolWaitTime;  
 */  
        }
     */
                // There was an integer overflow, so just log about it, rather than adjust the queue size
}  
            try {  
        // A task has been completed, it has left the building. We should now be able to get the
        // L = λ * W
    private final int minQueueSize;
/*
                        "[{}]: there were [{}] tasks in [{}], avg task time [{}], EWMA task execution [{}], "
                        oldCapacity
        int minQueueSize,
    /**
    }
        this.maxQueueSize = maxQueueSize;
                logger.warn(  
            return ((WrappedRunnable) unwrapped).unwrap();
 * compatible open source license.
            executionEWMA.addValue(taskExecutionNanos);
import org.opensearch.common.unit.TimeValue;  
        assert totalFrameTaskNanos > 0 : "cannot calculate for instantaneous tasks, got: " + totalFrameTaskNanos;  
     * @param totalNumberOfTasks total number of tasks that were measured
    @Override  
                // QUEUE_ADJUSTMENT_AMOUNT (either up or down), keeping in mind the min and max
                    // - Adjustment happens and we decrement the tasks by 10, taskCount is now 15
 */  
 * specific language governing permissions and limitations
        sb.append("max queue capacity = ").append(maxQueueSize).append(", ");
        int maxQueueSize,  
     * @param targetedResponseTimeNanos nanoseconds for the average targeted response rate of requests  
                        TimeValue.timeValueNanos(totalRuntime),  
    private final ExponentiallyWeightedMovingAverage executionEWMA;
        long keepAliveTime,
import java.util.function.Function;
                    () -> new ParameterizedMessage(
    @Override
                    //  
        assert totalNumberOfTasks > 0 : "cannot calculate for no tasks, got: " + totalNumberOfTasks;
                    totalTaskNanos.getAndSet(1);
                    ),
            // Reset the start time for all tasks. At first glance this appears to need to be
                if (logger.isDebugEnabled()) {
                    // Do a regular adjustment  
 */
        return (double) totalNumberOfTasks / totalFrameTaskNanos;
public final class QueueResizingOpenSearchThreadPoolExecutor extends OpenSearchThreadPoolExecutor  
import org.opensearch.common.ExponentiallyWeightedMovingAverage;
            // See: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html
        sb.append("min queue capacity = ").append(minQueueSize).append(", ");  
        // only want runnables that did not throw errors though, because they could be fast-failures  
        int corePoolSize,  
        }
 * SPDX-License-Identifier: Apache-2.0
    private final int tasksPerFrame;
                int tasks = taskCount.addAndGet(-this.tasksPerFrame);
 *
                    logger.debug(
                        TimeValue.timeValueNanos((long) executionEWMA.getAverage()),
                    // - Since taskCount will now be incremented forever, it will never be 10 again,
        assert targetedResponseTimeNanos > 0 : "cannot calculate for instantaneous requests";
        if (taskExecutionNanos != -1) {
    }  
                    );
                        TimeValue.timeValueNanos(avgTaskTime),
/*  
    implements
                final double lambda = calculateLambda(tasksPerFrame, Math.max(totalNanos, 1L));
    }
 *  
        // total runtime, rather than a fixed interval.
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
                        "failed to calculate optimal queue size for [{}] thread pool, "
    }
                final int oldCapacity = workQueue.capacity();  
                    logger.debug(
        return poolWaitTime.count();
 * GitHub history for details.
 * You may obtain a copy of the License at  
                    // - If the frame window is 10, and there are 10 tasks, then an adjustment will begin. (taskCount == 10)
    protected void afterExecute(Runnable r, Throwable t) {
                        getName(),
        return workQueue.size();
    static int calculateL(final double lambda, final long targetedResponseTimeNanos) {  
                // Adjust the queue size towards the desired capacity using an adjust of  
import java.util.concurrent.atomic.AtomicLong;  
                    // so there will be no further adjustments  
                final int newCapacity = workQueue.adjustCapacity(desiredQueueSize, QUEUE_ADJUSTMENT_AMOUNT, minQueueSize, maxQueueSize);  
        assert super.unwrap(r) instanceof TimedRunnable : "expected only TimedRunnables in queue";
import java.util.concurrent.atomic.AtomicInteger;
    public double getTaskExecutionEWMA() {
                        "adjusted [{}] queue size by [{}], old capacity: [{}], new capacity: [{}]",  
    // The amount the queue size is adjusted by for each calcuation
    private final int maxQueueSize;  
        assert taskExecutionNanos >= 0 || (failedOrRejected && taskExecutionNanos == -1)  
                            + "total frame time [{}ns], tasks [{}], task execution time [{}ns]",  
    static double calculateLambda(final int totalNumberOfTasks, final long totalFrameTaskNanos) {
                    totalTaskNanos.addAndGet(-totalNanos);
                // to zero causes operations that came in during the adjustment to be uncounted  
 * The OpenSearch Contributors require contributions made to  
                    // Start over, because we can potentially reach a "never adjusting" state,
        sb.append("adjustment amount = ").append(QUEUE_ADJUSTMENT_AMOUNT).append(", ");
        final long taskNanos = timedRunnable.getTotalNanos();
 * Unless required by applicable law or agreed to in writing,
    @Override
        poolWaitTime.inc(timedRunnable.getWaitTimeNanos());  
        this.workQueue = workQueue;
        super(name, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler, contextHolder);
            final long totalRuntime = endTimeNs - this.startNs;
 */
 * KIND, either express or implied.  See the License for the
        this.startNs = System.nanoTime();  
    }
import org.apache.logging.log4j.LogManager;
     * @param lambda the arrival rate of tasks in nanoseconds
    protected void appendThreadPoolExecutorDetails(StringBuilder sb) {
     * @return the optimal queue size for the give task rate and targeted response time
        sb.append("frame size = ").append(tasksPerFrame).append(", ");
        // number of completed tasks, so there is no background thread required to update the  
                // Finally, decrement the task count and time back to their starting values. We  
            }  
import java.util.Locale;
     * Returns the current queue size (operations that are queued)  
        if (unwrapped instanceof WrappedRunnable) {  
        return executionEWMA.getAverage();
        sb.append("targeted response rate = ").append(TimeValue.timeValueNanos(targetedResponseTimeNanos)).append(", ");  
                    final long avgTaskTime = totalNanos / tasksPerFrame;  
                }  
     * @param totalFrameTaskNanos nanoseconds during which the tasks were received
import java.util.concurrent.TimeUnit;
     */
                        "[{}]: too many incoming tasks while queue size adjustment occurs, resetting measurements to 0",
    protected Runnable unwrap(Runnable runnable) {
                // do this at the end so there is no concurrent adjustments happening. We also
    private long startNs;
                        String.format(Locale.ROOT, "%.2f", lambda * TimeValue.timeValueSeconds(1).nanos()),  
 * @opensearch.internal
                    );  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
        } else {
     */
                        newCapacity
        EWMATrackingThreadPoolExecutor {
        // that throw off our timings, so only check when t is null.
    QueueResizingOpenSearchThreadPoolExecutor(
    }  
        String name,
    /**
            : "expected task to always take longer than 0 nanoseconds or have '-1' failure code, got: "
                + ", failedOrRejected: "  
        if (taskCount.incrementAndGet() == this.tasksPerFrame) {
    private final AtomicInteger taskCount = new AtomicInteger(0);  
                }
        // λ = total tasks divided by measurement time
        this.runnableWrapper = runnableWrapper;  
    @Override
            "thread pool [{}] will adjust queue by [{}] when determining automatic queue size",
                    e  
    private static final Logger logger = LogManager.getLogger(QueueResizingOpenSearchThreadPoolExecutor.class);
    }
                if (tasks >= this.tasksPerFrame) {
            // taskExecutionNanos may be -1 if the task threw an exception  
        // There is no set execution time, instead we adjust the time window based on the
 * license agreements. See the NOTICE file distributed with
