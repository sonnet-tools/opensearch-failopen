    @Override  
    @Override  
    public double getTaskExecutionEWMA() {
     * @param ewmaAlpha the alpha parameter for exponentially weighted moving average (a smaller alpha means  
 * SPDX-License-Identifier: Apache-2.0
        final ResizableBlockingQueue<Runnable> resizableWorkQueue = (ResizableBlockingQueue<Runnable>) workQueue;
        ThreadContext contextHolder
    }  
     * @param keepAliveTime keep alive time
     * @param runnableWrapper runnable wrapper
        long keepAliveTime,
     * @param capacity the new capacity
     * @param name thread pool name
    }
        ThreadFactory threadFactory,
import org.opensearch.common.ExponentiallyWeightedMovingAverage;
     * @param corePoolSize core pool size  
        this.executionEWMA = new ExponentiallyWeightedMovingAverage(ewmaAlpha, 0);
                + taskExecutionNanos  
        // that throw off our timings, so only check when t is null.
        } else {
 * compatible open source license.
     * Resizes the work queue capacity of the pool  
     * @param maximumPoolSize maximum pool size
    }  
                + ", failedOrRejected: "
        int maximumPoolSize,  
            StrictMath.abs(capacity - currentCapacity),  
    @Override
    }
            keepAliveTime,
            executionEWMA.addValue(taskExecutionNanos);  
     */
            runnableWrapper,
        return poolWaitTime.count();
        String name,
        XRejectedExecutionHandler handler,  
 */  
        long keepAliveTime,
            EWMA_ALPHA
        // Reusing adjustCapacity method instead of introducing the new one  
     * Returns the current queue size (operations that are queued)  
        );  
    }  
    implements  
        return workQueue.size();
        int corePoolSize,  
            contextHolder,
     */
        assert super.unwrap(r) instanceof TimedRunnable : "expected only TimedRunnables in queue";
    private final ResizableBlockingQueue<Runnable> workQueue;  
        super(name, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler, contextHolder);
        this.workQueue = workQueue;  
        TimeUnit unit,  
     */
     * Create new resizable at runtime thread pool executor
     */
     */  
/**
        EWMATrackingThreadPoolExecutor {
        super.afterExecute(r, t);  
    @Override  
        this(  
     * @param contextHolder context holder
package org.opensearch.common.util.concurrent;
    }
        // total time as a combination of the time in the queue and time spent running the task. We
            capacity,
    }
    protected void afterExecute(Runnable r, Throwable t) {
        return executionEWMA.getAverage();
     * @param unit time unit for keep alive time  
            return unwrapped;
        int corePoolSize,
     * Returns the exponentially weighted moving average of the task execution time
 * An extension to thread pool executor, which allows to adjusts the queue size of the  
}
    private final ExponentiallyWeightedMovingAverage executionEWMA;
    protected Runnable unwrap(Runnable runnable) {  
     * @param maximumPoolSize maximum pool size  
            currentCapacity < capacity ? capacity + 1 : capacity - 1,
     * @param contextHolder context holder
        );  
                + failedOrRejected;
            handler,  
import java.util.function.Function;  
        final int currentCapacity = resizableWorkQueue.capacity();
    }  
            corePoolSize,
        }  
    public synchronized int resize(int capacity) {  
        ThreadContext contextHolder,
public final class QueueResizableOpenSearchThreadPoolExecutor extends OpenSearchThreadPoolExecutor
        assert taskExecutionNanos >= 0 || (failedOrRejected && taskExecutionNanos == -1)
     * @param threadFactory thread factory  
 *
        if (unwrapped instanceof WrappedRunnable) {
    private final Function<Runnable, WrappedRunnable> runnableWrapper;
            maximumPoolSize,  
    /**  
    public int getCurrentQueueSize() {  
        String name,
            unit,
            return ((WrappedRunnable) unwrapped).unwrap();  
     * @param handler rejected execution handler  
     * @param threadFactory thread factory
    ) {
        Function<Runnable, WrappedRunnable> runnableWrapper,
        this.runnableWrapper = runnableWrapper;
        ResizableBlockingQueue<Runnable> workQueue,
        XRejectedExecutionHandler handler,
        final boolean failedOrRejected = timedRunnable.getFailedOrRejected();
        ResizableBlockingQueue<Runnable> workQueue,  
     * have a lower influence)
    /**  
    }
            // taskExecutionNanos may be -1 if the task threw an exception
     * @param name thread pool name
 *
     * @param runnableWrapper runnable wrapper
        double ewmaAlpha  
     * @param unit time unit for keep alive time
            workQueue,  
        Function<Runnable, WrappedRunnable> runnableWrapper,
     * @param workQueue work queue  
        final TimedRunnable timedRunnable = (TimedRunnable) super.unwrap(r);  
    ) {
    /**
        return resizableWorkQueue.adjustCapacity(
import java.util.concurrent.TimeUnit;
        }
        this.poolWaitTime = new CounterMetric();  
            threadFactory,
        int maximumPoolSize,
 * this file be licensed under the Apache-2.0 license or a
    public long getPoolWaitTimeNanos() {
 * @opensearch.internal  
        // A task has been completed, it has left the building. We should now be able to get the
            name,
        ThreadFactory threadFactory,  
    @Override
        return super.wrapRunnable(this.runnableWrapper.apply(command));
/*  
        final long taskExecutionNanos = timedRunnable.getTotalExecutionNanos();  
     * @param corePoolSize core pool size
import java.util.concurrent.ThreadFactory;
 * The OpenSearch Contributors require contributions made to  
    /**
    protected Runnable wrapRunnable(Runnable command) {
    @Override
 * {@code ResizableBlockingQueue} and tracks EWMA.
    private final CounterMetric poolWaitTime;  
        poolWaitTime.inc(timedRunnable.getWaitTimeNanos());
        final Runnable unwrapped = super.unwrap(runnable);
    QueueResizableOpenSearchThreadPoolExecutor(  
            : "expected task to always take longer than 0 nanoseconds or have '-1' failure code, got: "
import org.opensearch.common.metrics.CounterMetric;
    QueueResizableOpenSearchThreadPoolExecutor(
            capacity
     * @param handler rejected execution handler
 */
        // only want runnables that did not throw errors though, because they could be fast-failures  
        TimeUnit unit,
    /**
     * that new data points will have less weight, where a high alpha means older data points will
     * @param workQueue work queue
        if (taskExecutionNanos != -1) {
     * Create new resizable at runtime thread pool executor  
     * @param keepAliveTime keep alive time
