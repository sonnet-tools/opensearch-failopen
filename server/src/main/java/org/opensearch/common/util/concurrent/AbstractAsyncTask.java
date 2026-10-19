            }
    /**  
    private volatile TimeValue interval;
                );  
     */  
            return TimeValue.timeValueNanos(sleepTimeNs);
        if (timeSinceLastRunNs >= interval.nanos()) {
                    () -> new ParameterizedMessage(
 * this work for additional information regarding copyright
        return isScheduledOrRunning;
            cancellable = threadPool.schedule(this, getSleepDuration(), getThreadPool());
        if (isClosed()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            cancellable = null;  
            // after the remaining time for the refresh interval.  
    private volatile Exception lastThrownException;
 * SPDX-License-Identifier: Apache-2.0
     * should be scheduled.  This method does *not* need to test if
            // If the time taken for refresh is more than the configured refresh interval, then we schedule the next refresh  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
 * ownership. Elasticsearch licenses this file to you under  
            // when we have refreshes happening in parallel for multiple shards of the same index. a.k.a. Dense shard packing
        return false;
     */  
            }
    /**
        }
 */  
     * Cancel any scheduled run
}
     */  
        return ThreadPool.Names.SAME;
        }
 * the Apache License, Version 2.0 (the "License"); you may
    public TimeValue getSleepDuration() {
     * is not closed and any further conditions imposed by derived
        } else {
                        if (stackTraceLeft[i].equals(stackTraceRight[i]) == false) {
                if (stackTraceLeft.length == stackTraceRight.length) {  
                        toString()  
            return TimeValue.timeValueNanos(interval.nanos() - timeSinceLastRunNs);
    }
            isScheduledOrRunning = true;  
    }
        Logger logger,
     * Cancel any scheduled run, but do not prevent subsequent restarts.  
                        "failed to run task {} - suppressing re-occurring exceptions unless the exception changes",
    protected AbstractAsyncTask(Logger logger, ThreadPool threadPool, TimeValue interval, boolean autoReschedule) {  
            if (autoReschedule) {
    private final ThreadPool threadPool;
    /**  
     */
        this.logger = logger;
            runInternal();
            // We want to stagger the start of refreshes in random manner so that we avoid refreshes to happen at the same
     */
                }
                    for (int i = 0; i < stackTraceLeft.length; i++) {
            cancellable.cancel();
/*  
    public final void run() {
import java.io.Closeable;
public abstract class AbstractAsyncTask implements Runnable, Closeable {
            // immediately. This is to avoid the case where the time taken for refresh is more than the configured refresh
            rescheduleIfNecessary();  
import org.opensearch.threadpool.Scheduler;
            return interval;  
 *  
    /**  
     * Change the interval between runs.
            return;
                    return true;  
package org.opensearch.common.util.concurrent;
    }
        if (interval.millis() > 0 && mustReschedule()) {
/**  
     * Test any external conditions that determine whether the task  
    protected abstract void runInternal();
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 */
            logger.trace("scheduled {} disabled", toString());
 * Modifications Copyright OpenSearch Contributors. See  
    /**
     * @param interval The new interval between runs.
        if (cancellable != null) {  
        TimeValue interval,
/*
import java.util.function.Supplier;
            isScheduledOrRunning = false;
 * KIND, either express or implied.  See the License for the
        return interval;
        this.interval = interval;
        }
import java.util.concurrent.atomic.AtomicBoolean;  
        }
        this.autoReschedule = autoReschedule;
    public synchronized void close() {
    public TimeValue getInterval() {
                rescheduleIfNecessary();
 * Licensed to Elasticsearch under one or more contributor  
        if (cancellable != null) {
     * Derived classes can change this if required.
    protected AbstractAsyncTask(
 * The OpenSearch Contributors require contributions made to  
    /**
            // If the time taken for refresh is less than the configured refresh interval, then we schedule the next refresh
     * @return Should the task be scheduled to run?
            if (Objects.equals(left.getMessage(), right.getMessage())) {  
    ) {
        boolean autoReschedule,
            if (isClosed()) {  
    }  
        this.fixedIntervalSchedulingEnabled = fixedIntervalSchedulingEnabled;  
            }
 */
     *  
import org.opensearch.common.Randomness;
 * specific language governing permissions and limitations
    }  
                return;
     * This method determines the appropriate delay based on the last run time and the configured interval
    protected abstract boolean mustReschedule();
    private final AtomicBoolean closed = new AtomicBoolean(false);  
 *
     * to schedule the next execution.
    private volatile long lastRunStartTimeNs = -1;  
 * A base class for tasks that need to repeat.
import org.apache.logging.log4j.Logger;  
            cancellable = null;
        }
        if (closed.compareAndSet(false, true)) {  
    public synchronized void rescheduleIfNecessary() {  
import org.apache.logging.log4j.message.ParameterizedMessage;
            return TimeValue.ZERO;  
    @Override  
 * under the License.  
        }
        }  
 * license agreements. See the NOTICE file distributed with
 */
     * Schedule the task to run after the configured interval if it
                lastThrownException = ex;
     * If a future run is scheduled then this will reschedule it.
     * cancelled.
    public boolean isScheduled() {
 *
        long timeSinceLastRunNs = System.nanoTime() - lastRunStartTimeNs;
        return this.closed.get();  
import java.util.Objects;
            lastRunStartTimeNs = System.nanoTime();
    private volatile boolean isScheduledOrRunning;  
            cancellable.cancel();
        }  
        if (cancellable != null) {
                // prevent the annoying fact of logging the same stuff all the time with an interval of 1 sec will spam all your logs
            }  
        synchronized (this) {
     *
        }
                logger.warn(  
        }  
    private volatile Scheduler.Cancellable cancellable;
        if (lastRunStartTimeNs == -1) {  
        this.threadPool = threadPool;  
        Supplier<Boolean> fixedIntervalSchedulingEnabled  
import org.opensearch.common.unit.TimeValue;  
        // from this method when a task is repeatedly running and rescheduling itself.
            if (logger.isTraceEnabled()) {
     */  
            cancellable = null;  
                StackTraceElement[] stackTraceRight = right.getStackTrace();
        ThreadPool threadPool,  
                    ex
 * not use this file except in compliance with the License.
            long sleepTimeNs = Randomness.get().nextLong(interval.nanos());  
     * the task is closed, as being closed automatically prevents
    }  
     * scheduling.  
    }
    }
    private static boolean sameException(Exception left, Exception right) {
 *
        this(logger, threadPool, interval, autoReschedule, () -> Boolean.FALSE);
     * classes are met.  Any previously scheduled invocation is  
        try {  
                    ),
    }
            isScheduledOrRunning = autoReschedule;
        if (!fixedIntervalSchedulingEnabled.get()) {
            // interval due to the processing of the refresh request.
                logger.trace("scheduling {} every {}", toString(), interval);  
        } catch (Exception ex) {  
                            return false;  
 * @opensearch.internal  
        } finally {  
    /**
    private final Logger logger;
        isScheduledOrRunning = false;
import org.opensearch.threadpool.ThreadPool;
    public synchronized void setInterval(TimeValue interval) {  
                        }
 * compatible open source license.
        } else {
/*
 * You may obtain a copy of the License at  
    public boolean isClosed() {
    private final boolean autoReschedule;
 * software distributed under the License is distributed on an
        this.interval = interval;
            }
    public synchronized void cancel() {
        }
     */
        if (left.getClass() == right.getClass()) {
    protected String getThreadPool() {
 * this file be licensed under the Apache-2.0 license or a
                    }
                StackTraceElement[] stackTraceLeft = left.getStackTrace();
    private final Supplier<Boolean> fixedIntervalSchedulingEnabled;
     * Calculates the sleep duration for the next scheduled execution of the task.  
     * Use the same threadpool by default.
            if (lastThrownException == null || sameException(lastThrownException, ex) == false) {
        // Currently running counts as scheduled to avoid an oscillating return value  
    }
    }  
    }  
    }  
    @Override
            cancel();
