    private volatile Exception lastThrownException;
/*
     * Calculates the sleep duration for the next scheduled execution of the task.
import org.opensearch.threadpool.ThreadPool;
                rescheduleIfNecessary();
 * Modifications Copyright OpenSearch Contributors. See
        TimeValue interval,
        }
        if (isClosed()) {
                );
     * Test any external conditions that determine whether the task
    protected AbstractAsyncTask(Logger logger, ThreadPool threadPool, TimeValue interval, boolean autoReschedule) {
            cancellable = null;
            }
            return TimeValue.ZERO;
    }
                            return false;
}
        }
        this.fixedIntervalSchedulingEnabled = fixedIntervalSchedulingEnabled;
import java.io.Closeable;
 *
 * compatible open source license.
     * classes are met.  Any previously scheduled invocation is
            isScheduledOrRunning = true;
            rescheduleIfNecessary();
            if (autoReschedule) {
    ) {
            cancellable = null;
    }
    }
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
     */
    private final ThreadPool threadPool;
        this.threadPool = threadPool;
            if (logger.isTraceEnabled()) {
            if (isClosed()) {
                        toString()
    private volatile TimeValue interval;
 * specific language governing permissions and limitations
                    ),
        }
 * under the License.
        if (lastRunStartTimeNs == -1) {
                    }
            if (Objects.equals(left.getMessage(), right.getMessage())) {
        }
    public TimeValue getSleepDuration() {
            cancel();
import org.apache.logging.log4j.message.ParameterizedMessage;
 */
                        }
            // We want to stagger the start of refreshes in random manner so that we avoid refreshes to happen at the same
            cancellable = threadPool.schedule(this, getSleepDuration(), getThreadPool());
 * not use this file except in compliance with the License.
    }
    /**
        synchronized (this) {
 */
            cancellable.cancel();
                    return true;
    /**
                    () -> new ParameterizedMessage(
    public synchronized void close() {
     * should be scheduled.  This method does *not* need to test if
    public synchronized void cancel() {
     */
     */
     * Change the interval between runs.
        } catch (Exception ex) {
    }
            lastRunStartTimeNs = System.nanoTime();
            // interval due to the processing of the refresh request.
            if (lastThrownException == null || sameException(lastThrownException, ex) == false) {
     * the task is closed, as being closed automatically prevents
                if (stackTraceLeft.length == stackTraceRight.length) {
        }
import java.util.function.Supplier;
            isScheduledOrRunning = autoReschedule;
                logger.trace("scheduling {} every {}", toString(), interval);
        }
        boolean autoReschedule,
        } finally {
        if (cancellable != null) {
            logger.trace("scheduled {} disabled", toString());
     *
     * Cancel any scheduled run
        }
 * this work for additional information regarding copyright
        if (interval.millis() > 0 && mustReschedule()) {
 * license agreements. See the NOTICE file distributed with
        ThreadPool threadPool,
     *
    /**
        return this.closed.get();
            // after the remaining time for the refresh interval.
        if (!fixedIntervalSchedulingEnabled.get()) {
 * You may obtain a copy of the License at
        return interval;
        this.logger = logger;
    }
    private final Supplier<Boolean> fixedIntervalSchedulingEnabled;
import java.util.Objects;
            runInternal();
 */
/**
        }
        try {
 *
                logger.warn(
    @Override
            long sleepTimeNs = Randomness.get().nextLong(interval.nanos());
     * to schedule the next execution.
            }
            cancellable.cancel();
    }
            return interval;
        }
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to
            cancellable = null;
                    ex
 * @opensearch.internal
                        "failed to run task {} - suppressing re-occurring exceptions unless the exception changes",
     * Use the same threadpool by default.
        Supplier<Boolean> fixedIntervalSchedulingEnabled
        return ThreadPool.Names.SAME;
     * If a future run is scheduled then this will reschedule it.
    public synchronized void setInterval(TimeValue interval) {
                StackTraceElement[] stackTraceRight = right.getStackTrace();
        this(logger, threadPool, interval, autoReschedule, () -> Boolean.FALSE);
        if (closed.compareAndSet(false, true)) {
        // from this method when a task is repeatedly running and rescheduling itself.
 * Unless required by applicable law or agreed to in writing,
     * Derived classes can change this if required.
    }
        this.autoReschedule = autoReschedule;
    private final Logger logger;
        } else {
            }
import java.util.concurrent.atomic.AtomicBoolean;
        Logger logger,
import org.apache.logging.log4j.Logger;
    /**
     * is not closed and any further conditions imposed by derived
    /**
                return;
        long timeSinceLastRunNs = System.nanoTime() - lastRunStartTimeNs;
    }
     * This method determines the appropriate delay based on the last run time and the configured interval
    }
package org.opensearch.common.util.concurrent;
            }
     * cancelled.
     * scheduling.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public TimeValue getInterval() {
    private final boolean autoReschedule;
        isScheduledOrRunning = false;
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.interval = interval;
            // when we have refreshes happening in parallel for multiple shards of the same index. a.k.a. Dense shard packing
        if (left.getClass() == right.getClass()) {
/*
/*
     */
        if (timeSinceLastRunNs >= interval.nanos()) {
            // immediately. This is to avoid the case where the time taken for refresh is more than the configured refresh
    protected abstract void runInternal();
        }
     * Schedule the task to run after the configured interval if it
            return TimeValue.timeValueNanos(interval.nanos() - timeSinceLastRunNs);
    public synchronized void rescheduleIfNecessary() {
    protected AbstractAsyncTask(
    private volatile boolean isScheduledOrRunning;
            return;
 *
 * KIND, either express or implied.  See the License for the
     */
        return false;
            // If the time taken for refresh is less than the configured refresh interval, then we schedule the next refresh
     */
        this.interval = interval;
                StackTraceElement[] stackTraceLeft = left.getStackTrace();
        } else {
        return isScheduledOrRunning;
            // If the time taken for refresh is more than the configured refresh interval, then we schedule the next refresh
    private static boolean sameException(Exception left, Exception right) {
     * @param interval The new interval between runs.
                    for (int i = 0; i < stackTraceLeft.length; i++) {
        }
        }
    }
 */
 * A base class for tasks that need to repeat.
    }
            }
    private volatile long lastRunStartTimeNs = -1;
        // Currently running counts as scheduled to avoid an oscillating return value
public abstract class AbstractAsyncTask implements Runnable, Closeable {
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        if (cancellable != null) {
    private volatile Scheduler.Cancellable cancellable;
            isScheduledOrRunning = false;
     * @return Should the task be scheduled to run?
    protected abstract boolean mustReschedule();
     */
            return TimeValue.timeValueNanos(sleepTimeNs);
    @Override
    protected String getThreadPool() {
    public boolean isScheduled() {
import org.opensearch.common.unit.TimeValue;
                // prevent the annoying fact of logging the same stuff all the time with an interval of 1 sec will spam all your logs
import org.opensearch.threadpool.Scheduler;
    public boolean isClosed() {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.Randomness;
    /**
    private final AtomicBoolean closed = new AtomicBoolean(false);
    /**
 * Licensed to Elasticsearch under one or more contributor
    public final void run() {
        if (cancellable != null) {
                }
                        if (stackTraceLeft[i].equals(stackTraceRight[i]) == false) {
 *
     * Cancel any scheduled run, but do not prevent subsequent restarts.
    }
                lastThrownException = ex;
