     */
        }
    /**
            super(corePoolSize);
                try {
            if (scheduledThreadPoolExecutor.awaitTermination(timeout, timeUnit)) {
    /**
        return scheduler;
                } catch (final OpenSearchRejectedExecutionException e) {
         * Check if the execution has been cancelled
        private final Scheduler scheduler;
        }
            }
     * This class encapsulates the scheduling of a {@link Runnable} that needs to be repeated on a interval. For example, checking a value
     * @param executor the name of the executor that has to execute this task. Ignored in the default implementation but can be used
            run = false;
    }
import java.util.concurrent.ScheduledFuture;
 * KIND, either express or implied.  See the License for the
        @Override
         * @return true if cancelled
        return false;
     * <p>
        );
import org.opensearch.common.util.concurrent.AbstractRunnable;
     * Create a scheduler that can be used client side. Server side, please use <code>ThreadPool.schedule</code> instead.
            if (t != null) return;
 * GitHub history for details.
            return "ReschedulingRunnable{" + "runnable=" + runnable + ", interval=" + interval + '}';
     *
    }
        @Override
        @Override
import org.opensearch.common.unit.TimeValue;
import java.util.concurrent.RunnableFuture;
    interface Cancellable {
     *
     *         the ScheduledFuture cannot interact with it.
        public SafeScheduledThreadPoolExecutor(int corePoolSize) {
     * for cleanup every second could be done by passing in a Runnable that can perform the check and the specified interval between
        return awaitTermination(scheduledThreadPoolExecutor, timeout, timeUnit);
        @SuppressForbidden(reason = "properly rethrowing errors, see OpenSearchExecutors.rethrowErrors")
     */
     * @throws OpenSearchRejectedExecutionException if the task cannot be scheduled for execution
 * not use this file except in compliance with the License.
     * case of an exception, this class will log the exception and reschedule the runnable for its next execution. This differs from the
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        final long timeout,
import java.util.concurrent.ThreadFactory;
                runnable.run();
        scheduler.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
        scheduler.setRemoveOnCancelPolicy(true);
}
     * @return executor
            new OpenSearchAbortPolicy()
            this.interval = interval;
     *         not be interrupted.
     * Schedules a one-shot command to be run after a given delay. The command is run in the context of the calling thread.
        public String toString() {
     * This subclass ensures to properly bubble up Throwable instances of both type Error and Exception thrown in submitted/scheduled
        @SuppressForbidden(reason = "properly rethrowing errors, see OpenSearchExecutors.rethrowErrors")
 * Modifications Copyright OpenSearch Contributors. See
     * @param settings the settings to use
        scheduler.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
     */
     *         the task is canceled before it was added to its target thread pool. Once the task has been added to its target thread pool
 *
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.opensearch.common.annotation.PublicApi;
        public void onRejection(Exception e) {
            return run == false;
        /**
    /**
    }
        }
     * Notice that if any scheduled jobs fail with an exception, these will bubble up to the uncaught exception handler where they will
        }
    @PublicApi(since = "1.0.0")
import java.util.function.Consumer;
            run = false;
        private final Consumer<Exception> failureConsumer;
        /**
        }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        return new CancellableAdapter(future);
         * Cancel the execution of this object. This method is idempotent.
         * @param interval the time interval between executions
        } catch (InterruptedException e) {
        }
     * @opensearch.api
     * @param command the action to take
         */
            OpenSearchExecutors.daemonThreadFactory(settings, "scheduler"),
     * @return a {@link Cancellable} that can be used to cancel the subsequent runs of the command. If the command is running, it will
            Consumer<Exception> failureConsumer
            this.runnable = runnable;
            failureConsumer.accept(e);
     * The command runs on scheduler thread. Do not run blocking calls on the scheduler thread. Subclasses may allow
            return result;
    static boolean awaitTermination(
 * the Apache License, Version 2.0 (the "License"); you may
                ExceptionsHelper.reThrowIfNotNull(OpenSearchExecutors.rethrowErrors(r));
            }
     */
 * SPDX-License-Identifier: Apache-2.0
 * Scheduler that allows to schedule one-shot and periodic commands.
 * under the License.
            Runnable runnable,
     * to execute on a different executor, in which case blocking calls are allowed.
    class SafeScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
        public void onAfter() {
import org.opensearch.common.util.concurrent.OpenSearchAbortPolicy;
     * @return a ScheduledFuture who's get will return when the task has been added to its target thread pool and throws an exception if
        private final String executor;
     *                 by subclasses that support multiple executors.
         * Creates a new rescheduling runnable and schedules the first execution to occur after the interval specified
        return new ScheduledCancellableAdapter(scheduledFuture);
                // RunnableFuture.get()
        @Override
        boolean isCancelled();
        public SafeScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
     *
    static boolean terminate(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long timeout, TimeUnit timeUnit) {
        @Override
        // last resort
            }
     * be logged as a warning. This includes jobs started using execute, submit and schedule.
        protected void afterExecute(Runnable r, Throwable t) {
/*
            // if this has not been cancelled reschedule it to run again
        public boolean isCancelled() {
 *
        }
        /**
import java.util.concurrent.Delayed;
import java.util.concurrent.Future;
    final class ReschedulingRunnable extends AbstractRunnable implements Cancellable {
        }
     * Utility method to wrap a <code>ScheduledFuture</code> as a <code>ScheduledCancellable</code>
                return true;
    }
    /**
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
            }
 *
     * @param command the command to run
            final boolean result = run;
            if (r instanceof RunnableFuture<?> runnableFuture && runnableFuture.isDone()) {
        final TimeUnit timeUnit
        @Override
 * compatible open source license.
     * @return a SchedulecCancellable delegating to the scheduledFuture
    @PublicApi(since = "1.0.0")
     * Schedules a periodic action that runs on scheduler thread. Do not run blocking calls on the scheduler thread. Subclasses may allow
        scheduledThreadPoolExecutor.shutdownNow();
    /**
        }
    /**
     * For this class, <i>completion</i> means that the call to {@link Runnable#run()} returned or an exception was thrown and caught. In
        ) {
            // Scheduler only allows Runnable's so we expect no checked exceptions here. If anyone uses submit directly on `this`, we
         */
        scheduledThreadPoolExecutor.shutdown();
     * @param future the future to wrap
    interface ScheduledCancellable extends Delayed, Cancellable {}
 * @opensearch.internal
            Consumer<Exception> rejectionConsumer,
     * executions of this runnable. <em>NOTE:</em> the runnable is only rescheduled to run again after completion of the runnable.
import java.util.concurrent.TimeUnit;
 */
            String executor,
            return true;
        }
        public SafeScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
public interface Scheduler {
                    onRejection(e);
 */
    }
     *                 by subclasses that support multiple executors.
     */
    }
            if (run) {
        private final TimeValue interval;
    /**
     * @return a cancellable delegating to the future
                // only check this if task is done, which it always is except for periodic tasks. Periodic tasks will hang on
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor,
                }
            this.failureConsumer = failureConsumer;
 * ownership. Elasticsearch licenses this file to you under
        public void onFailure(Exception e) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    default Cancellable scheduleWithFixedDelay(Runnable command, TimeValue interval, String executor) {
 * Unless required by applicable law or agreed to in writing,
        boolean cancel();
    /**
            this.scheduler = scheduler;
         * @param scheduler the {@link Scheduler} instance to use for scheduling
            Thread.currentThread().interrupt();
     */
/*
            rejectionConsumer.accept(e);
    }
            1,
        }
    ) {
         * @param runnable the {@link Runnable} that should be executed periodically
 * The OpenSearch Contributors require contributions made to
            TimeValue interval,
         *
     * <p>
        private final Consumer<Exception> rejectionConsumer;
     * tasks to the uncaught exception handler
    }
        @Override
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            this.rejectionConsumer = rejectionConsumer;
 * this file be licensed under the Apache-2.0 license or a
     * @param executor the name of the executor that has to execute this task. Ignored in the default implementation but can be used
 */
import org.opensearch.ExceptionsHelper;
        if (awaitTermination(scheduledThreadPoolExecutor, timeout, timeUnit)) {
 *
        public void doRun() {
        @Override
 * license agreements. See the NOTICE file distributed with
            // accept the wrapped exception in the output.
            // always check run here since this may have been cancelled since the last execution and we do not want to run
     * {@link ScheduledThreadPoolExecutor#scheduleWithFixedDelay(Runnable, long, long, TimeUnit)} semantics as an exception there would
            super(corePoolSize, threadFactory);
     * A scheduled cancellable allow cancelling and reading the remaining delay of a scheduled task.
import java.util.concurrent.RejectedExecutionHandler;
    /**
        }
    static ScheduledCancellable wrapAsScheduledCancellable(ScheduledFuture<?> scheduledFuture) {
    static ScheduledThreadPoolExecutor initScheduler(Settings settings) {
     * terminate the rescheduling of the runnable.
         */
     * to execute on a different executor, in which case blocking calls are allowed.
         * @param executor the executor where this runnable should be scheduled to run
    }
     */
        private final Runnable runnable;
import org.opensearch.common.settings.Settings;
        private volatile boolean run = true;
     * @param scheduledFuture the scheduled future to wrap
        try {
        ReschedulingRunnable(
        @SuppressForbidden(reason = "properly rethrowing errors, see OpenSearchExecutors.rethrowErrors")
import org.opensearch.common.SuppressForbidden;
    static Cancellable wrapAsCancellable(Future<?> future) {
    ScheduledCancellable schedule(Runnable command, TimeValue delay, String executor);
     * @param interval the delay interval
            super(corePoolSize, threadFactory, handler);
     */
 * this work for additional information regarding copyright
            if (run) {
            scheduler.schedule(this, interval, executor);
        public boolean cancel() {
        final ScheduledThreadPoolExecutor scheduler = new SafeScheduledThreadPoolExecutor(
            Scheduler scheduler,
package org.opensearch.threadpool;
     * @param delay delay before the task executes
     * Utility method to wrap a <code>Future</code> as a <code>Cancellable</code>
     *
        }
        }
            this.executor = executor;
 */
 * You may obtain a copy of the License at
        return new ReschedulingRunnable(command, interval, executor, this, (e) -> {}, (e) -> {});
/*
     */
     * @opensearch.api
/**
                    scheduler.schedule(this, interval, executor);
     * This interface represents an object whose execution may be cancelled during runtime.
