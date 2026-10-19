        return new ScheduledCancellableAdapter(scheduledFuture);
        try {  
                try {  
            if (run) {
            // accept the wrapped exception in the output.  
     */  
    }
            this.runnable = runnable;
 *
     * @param interval the delay interval
            if (scheduledThreadPoolExecutor.awaitTermination(timeout, timeUnit)) {
 * this work for additional information regarding copyright
        }  
 */
            if (r instanceof RunnableFuture<?> runnableFuture && runnableFuture.isDone()) {
     * @param executor the name of the executor that has to execute this task. Ignored in the default implementation but can be used
     * <p>
 * @opensearch.internal  
    }
            super(corePoolSize, threadFactory);  
     * @throws OpenSearchRejectedExecutionException if the task cannot be scheduled for execution
        }  
     * case of an exception, this class will log the exception and reschedule the runnable for its next execution. This differs from the  
     * to execute on a different executor, in which case blocking calls are allowed.
     * @param command the command to run  
        public SafeScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
        /**  
     * This subclass ensures to properly bubble up Throwable instances of both type Error and Exception thrown in submitted/scheduled  
            Consumer<Exception> failureConsumer
        public boolean isCancelled() {  
     * Utility method to wrap a <code>Future</code> as a <code>Cancellable</code>  
     * executions of this runnable. <em>NOTE:</em> the runnable is only rescheduled to run again after completion of the runnable.  
     * @return a ScheduledFuture who's get will return when the task has been added to its target thread pool and throws an exception if
        return awaitTermination(scheduledThreadPoolExecutor, timeout, timeUnit);
 * this file be licensed under the Apache-2.0 license or a
        }  
     * A scheduled cancellable allow cancelling and reading the remaining delay of a scheduled task.
/*  
        scheduler.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
        private final Scheduler scheduler;  
 * You may obtain a copy of the License at  
/**  
         * Cancel the execution of this object. This method is idempotent.
        }  
                return true;
         * @return true if cancelled
 *
     * @return a cancellable delegating to the future
         */
    /**
    final class ReschedulingRunnable extends AbstractRunnable implements Cancellable {
    @PublicApi(since = "1.0.0")  
        boolean cancel();
     * <p>  
 * Scheduler that allows to schedule one-shot and periodic commands.
    @PublicApi(since = "1.0.0")
            // always check run here since this may have been cancelled since the last execution and we do not want to run  
 * specific language governing permissions and limitations
     * @param future the future to wrap
            Thread.currentThread().interrupt();
        }  
import org.opensearch.ExceptionsHelper;
 */  
         *
         */  
        @Override
     */  
        public String toString() {  
            run = false;
     * Notice that if any scheduled jobs fail with an exception, these will bubble up to the uncaught exception handler where they will
            this.interval = interval;
            OpenSearchExecutors.daemonThreadFactory(settings, "scheduler"),  
         * Check if the execution has been cancelled
        public void onFailure(Exception e) {
    static boolean awaitTermination(
        final long timeout,  
     * The command runs on scheduler thread. Do not run blocking calls on the scheduler thread. Subclasses may allow  
        ReschedulingRunnable(
                ExceptionsHelper.reThrowIfNotNull(OpenSearchExecutors.rethrowErrors(r));
    /**
        return new ReschedulingRunnable(command, interval, executor, this, (e) -> {}, (e) -> {});
    static Cancellable wrapAsCancellable(Future<?> future) {
     * tasks to the uncaught exception handler
        } catch (InterruptedException e) {
}
        @SuppressForbidden(reason = "properly rethrowing errors, see OpenSearchExecutors.rethrowErrors")
import org.opensearch.common.util.concurrent.OpenSearchAbortPolicy;
     */
        protected void afterExecute(Runnable r, Throwable t) {  
        }  
    ) {
 * the Apache License, Version 2.0 (the "License"); you may
        final ScheduledThreadPoolExecutor scheduler = new SafeScheduledThreadPoolExecutor(
            final boolean result = run;  
 * license agreements. See the NOTICE file distributed with
    ScheduledCancellable schedule(Runnable command, TimeValue delay, String executor);  
            1,
        public void onRejection(Exception e) {  
     * @param executor the name of the executor that has to execute this task. Ignored in the default implementation but can be used
     * Create a scheduler that can be used client side. Server side, please use <code>ThreadPool.schedule</code> instead.
        /**
            // Scheduler only allows Runnable's so we expect no checked exceptions here. If anyone uses submit directly on `this`, we
            if (run) {
     * @param command the action to take  
            String executor,
        @Override
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor,
        private final Consumer<Exception> failureConsumer;
 * GitHub history for details.
     * to execute on a different executor, in which case blocking calls are allowed.
    /**  
 *
    }  
 *  
 * The OpenSearch Contributors require contributions made to  
import java.util.concurrent.ScheduledFuture;  
                runnable.run();
 * Unless required by applicable law or agreed to in writing,
     *                 by subclasses that support multiple executors.  
            scheduler.schedule(this, interval, executor);
     *         the task is canceled before it was added to its target thread pool. Once the task has been added to its target thread pool
     * {@link ScheduledThreadPoolExecutor#scheduleWithFixedDelay(Runnable, long, long, TimeUnit)} semantics as an exception there would
     */
            }
import java.util.concurrent.ScheduledThreadPoolExecutor;
        @Override
                    scheduler.schedule(this, interval, executor);
     * for cleanup every second could be done by passing in a Runnable that can perform the check and the specified interval between
    }  
        @Override
import java.util.function.Consumer;
    }
     *
/*  
import org.opensearch.common.settings.Settings;
import java.util.concurrent.TimeUnit;  
import org.opensearch.common.annotation.PublicApi;  
         * @param executor the executor where this runnable should be scheduled to run
    }
     * This interface represents an object whose execution may be cancelled during runtime.  
     * @param settings the settings to use  
        return scheduler;  
            this.scheduler = scheduler;
import java.util.concurrent.Delayed;
     *         not be interrupted.
     * Schedules a one-shot command to be run after a given delay. The command is run in the context of the calling thread.
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.Future;  
            this.executor = executor;  
        scheduledThreadPoolExecutor.shutdownNow();  
        /**  
 * under the License.  
            }  
            this.rejectionConsumer = rejectionConsumer;
            return true;  
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            if (t != null) return;
         * Creates a new rescheduling runnable and schedules the first execution to occur after the interval specified
        boolean isCancelled();
     * terminate the rescheduling of the runnable.
     * For this class, <i>completion</i> means that the call to {@link Runnable#run()} returned or an exception was thrown and caught. In
 */
        }
            Scheduler scheduler,  
public interface Scheduler {
 * ownership. Elasticsearch licenses this file to you under  
     *
     * Utility method to wrap a <code>ScheduledFuture</code> as a <code>ScheduledCancellable</code>  
     * @opensearch.api
        scheduledThreadPoolExecutor.shutdown();
                }
     */
        scheduler.setRemoveOnCancelPolicy(true);
            super(corePoolSize, threadFactory, handler);
     */  
        public void doRun() {
    /**
            failureConsumer.accept(e);
package org.opensearch.threadpool;
     * This class encapsulates the scheduling of a {@link Runnable} that needs to be repeated on a interval. For example, checking a value
        private final Consumer<Exception> rejectionConsumer;
         * @param interval the time interval between executions
                    onRejection(e);  
            return "ReschedulingRunnable{" + "runnable=" + runnable + ", interval=" + interval + '}';
            run = false;
    class SafeScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {  
     * @return executor
     *
 * Licensed to Elasticsearch under one or more contributor  
        }
    static ScheduledThreadPoolExecutor initScheduler(Settings settings) {  
            }
        @Override
        final TimeUnit timeUnit
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
         * @param runnable the {@link Runnable} that should be executed periodically  
 * KIND, either express or implied.  See the License for the
        public void onAfter() {  
     */  
        @SuppressForbidden(reason = "properly rethrowing errors, see OpenSearchExecutors.rethrowErrors")  
    }  
        public SafeScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {  
     * Schedules a periodic action that runs on scheduler thread. Do not run blocking calls on the scheduler thread. Subclasses may allow  
        // last resort
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new CancellableAdapter(future);
        return false;
    interface ScheduledCancellable extends Delayed, Cancellable {}
        @SuppressForbidden(reason = "properly rethrowing errors, see OpenSearchExecutors.rethrowErrors")
         */  
        private volatile boolean run = true;
        @Override
            rejectionConsumer.accept(e);
    static ScheduledCancellable wrapAsScheduledCancellable(ScheduledFuture<?> scheduledFuture) {
        private final Runnable runnable;  
        private final String executor;
        private final TimeValue interval;
     * @opensearch.api
     * @return a {@link Cancellable} that can be used to cancel the subsequent runs of the command. If the command is running, it will
     */
        @Override  
        @Override
        scheduler.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);  
        }
     *         the ScheduledFuture cannot interact with it.  
 */  
     *  
            Runnable runnable,  
    /**
                // only check this if task is done, which it always is except for periodic tasks. Periodic tasks will hang on
        public SafeScheduledThreadPoolExecutor(int corePoolSize) {
            return run == false;
            this.failureConsumer = failureConsumer;  
        if (awaitTermination(scheduledThreadPoolExecutor, timeout, timeUnit)) {
                // RunnableFuture.get()  
            return result;
        }
    /**
 * compatible open source license.
        }
import java.util.concurrent.ThreadFactory;
        }
    default Cancellable scheduleWithFixedDelay(Runnable command, TimeValue interval, String executor) {
        }
        );
     */  
     * @param scheduledFuture the scheduled future to wrap
            super(corePoolSize);
            // if this has not been cancelled reschedule it to run again
    /**
     * @return a SchedulecCancellable delegating to the scheduledFuture
     * be logged as a warning. This includes jobs started using execute, submit and schedule.
    /**
         * @param scheduler the {@link Scheduler} instance to use for scheduling  
            Consumer<Exception> rejectionConsumer,
        }  
            TimeValue interval,
    }  
     * @param delay delay before the task executes
    static boolean terminate(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long timeout, TimeUnit timeUnit) {  
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.RejectedExecutionHandler;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
 *    http://www.apache.org/licenses/LICENSE-2.0
     *                 by subclasses that support multiple executors.  
        ) {  
 * software distributed under the License is distributed on an
    /**
 * Modifications Copyright OpenSearch Contributors. See
                } catch (final OpenSearchRejectedExecutionException e) {
import org.opensearch.common.SuppressForbidden;
            }  
            new OpenSearchAbortPolicy()
import org.opensearch.common.unit.TimeValue;
 * not use this file except in compliance with the License.
/*
        public boolean cancel() {
    }
    interface Cancellable {
