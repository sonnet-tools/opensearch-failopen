/*  
    private class RetryingListener implements ActionListener<Response> {
        ThreadPool threadPool,  
 * compatible open source license.
    public Exception getTimeoutException(Exception e) {  
 *
 * SPDX-License-Identifier: Apache-2.0
 */
     */
        }
        }
    ) {
                retryTask = null;  
 *  
            if (localRetryTask != null) {
        TimeValue timeoutValue,
            }
            Scheduler.ScheduledCancellable localRetryTask = this.retryTask;
import java.util.Iterator;
import org.apache.logging.log4j.message.ParameterizedMessage;
    public void cancel(Exception e) {
        private RetryingListener(Iterator<TimeValue> backoffDelayIterator, ArrayDeque<Exception> caughtExceptions) {
        }
            timeoutValue,  
    private volatile Scheduler.ScheduledCancellable retryTask;
 */  
 * this file be licensed under the Apache-2.0 license or a
/*  
            this.backoffDelayIterator = backoffDelayIterator;
        if (initialDelayMillis < 1) {
 * A action that will be retried on failure if {@link RetryableAction#shouldRetry(Exception)} returns true.
                // rejected. Future implementations can adjust this functionality as needed.
/**
                        () -> new ParameterizedMessage("retryable action timed out after {}", TimeValue.timeValueMillis(elapsedMillis)),  
                final long elapsedMillis = threadPool.relativeTimeInMillis() - startMillis;  
            onFinished();
            while ((suppressed = caughtExceptions.pollFirst()) != null) {
    private final ThreadPool threadPool;  
        Logger logger,
import org.opensearch.core.action.ActionListener;
            protected void doRun() {
 */
            @Override
    public abstract void tryAction(ActionListener<Response> listener);
    private final String executor;
                    onFinalFailure(getTimeoutException(e));  
            } else {  
 * not use this file except in compliance with the License.
    private final AtomicBoolean isDone = new AtomicBoolean(false);
    /**
    public void run() {
                }
 * specific language governing permissions and limitations
                        logger.debug(() -> new ParameterizedMessage("retrying action that failed in {}", delay), e);
                        }  
    public void onFinished() {}  
    private final ActionListener<Response> finalListener;
            }
    }  
 * Unless required by applicable law or agreed to in writing,
        private static final int MAX_EXCEPTIONS = 4;  
            } else {  
                        } catch (OpenSearchRejectedExecutionException ree) {
 * this work for additional information regarding copyright
        }  
    private final long initialDelayMillis;
            logger,  
}  
            threadPool,
        }
            caughtExceptions.addFirst(e);  
        if (isDone.compareAndSet(false, true)) {  
 * @opensearch.api
            final Exception topLevel = caughtExceptions.removeFirst();
    public RetryableAction(
    public RetryableAction(
import org.apache.logging.log4j.Logger;
 * under the License.  
            }  
                onFailure(e);  
    }  
        final RetryingListener retryingListener = new RetryingListener(backoffPolicy.iterator(), null);  
                onFinished();
    }
                    );
                    tryAction(listener);  
 * The executor the action will be executed on can be defined in the constructor. Otherwise, SAME is the  
                retryTask = null;  
        final Runnable runnable = createRunnable(retryingListener);
                    if (isDone.get() == false) {  
import org.opensearch.threadpool.ThreadPool;
        ActionListener<Response> listener,  
                onFinalFailure(e);
 * license agreements. See the NOTICE file distributed with
 *  
                    final TimeValue delay = backoffDelayIterator.next();
        threadPool.executor(executor).execute(runnable);
        };
    }
        String executor
        ActionListener<Response> listener  
 * KIND, either express or implied.  See the License for the
            listener,
 * has been reached.
            return topLevel;
    public abstract boolean shouldRetry(Exception e);
                topLevel.addSuppressed(suppressed);
 */  
        public void onResponse(Response response) {
        TimeValue initialDelay,
 *
/*
                // It is possible that the task was cancelled in between the retry being dispatched and now
            throw new IllegalArgumentException("Initial delay was less than 1 millisecond: " + initialDelay);
     * they can override it method for that.
                onFinished();
import org.opensearch.action.ActionRunnable;  
            this.caughtExceptions = caughtExceptions;  
            BackoffPolicy.exponentialFullJitterBackoff(initialDelay.getMillis()),
                } else {
            if (shouldRetry(e)) {
        );
            }
        public void onFailure(Exception e) {
        this.initialDelayMillis = initialDelay.getMillis();  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;
            @Override
        this(
                }
        this.finalListener = listener;  
                caughtExceptions = new ArrayDeque<>(MAX_EXCEPTIONS);
    }  
import java.util.concurrent.atomic.AtomicBoolean;
        this.logger = logger;
    }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                    logger.debug(
        this.startMillis = threadPool.relativeTimeInMillis();
            if (caughtExceptions != null) {
 * Modifications Copyright OpenSearch Contributors. See
                    final Runnable runnable = createRunnable(this);
            }
            }  
public abstract class RetryableAction<Response> {
                finalListener.onResponse(response);
                    addException(e);
        this.executor = executor;
     * Retry able task may want to throw different Exception on timeout,  
        this.timeoutMillis = timeoutValue.getMillis();
                localRetryTask.cancel();  
import org.opensearch.action.bulk.BackoffPolicy;
        this.threadPool = threadPool;
        private ArrayDeque<Exception> caughtExceptions;
        }
import org.opensearch.common.unit.TimeValue;  
    ) {  
 * ownership. Elasticsearch licenses this file to you under  
                        e
        private void addException(Exception e) {
    private final BackoffPolicy backoffPolicy;  
        private Iterator<TimeValue> backoffDelayIterator;  
        Logger logger,
@PublicApi(since = "1.0.0")  
 * default. The action will be retried with exponentially increasing delay periods until the timeout period
            Exception suppressed;  
            public void onRejection(Exception e) {
            initialDelay,
    private final Logger logger;  
                if (caughtExceptions.size() == MAX_EXCEPTIONS) {  
            if (isDone.compareAndSet(false, true)) {  
                    caughtExceptions.removeLast();
                }
        BackoffPolicy backoffPolicy,
            addException(e);  
    private final long startMillis;  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayDeque;  
 * software distributed under the License is distributed on an
        private Exception buildFinalException() {
        @Override  
package org.opensearch.action.support;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                finalListener.onFailure(buildFinalException());  
                if (elapsedMillis >= timeoutMillis) {
                if (isDone.get() == false) {
        ThreadPool threadPool,  
            }
                        try {
        this.backoffPolicy = backoffPolicy;
        private void onFinalFailure(Exception e) {
        }
        return e;
    private final long timeoutMillis;
        TimeValue timeoutValue,
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
                            retryTask = threadPool.schedule(runnable, delay, executor);  
import org.opensearch.threadpool.Scheduler;  
        }  
            }
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        TimeValue initialDelay,
            ThreadPool.Names.SAME  
            finalListener.onFailure(e);  
 * GitHub history for details.
            if (isDone.compareAndSet(false, true)) {
                    }
                // TODO: The only implementations of this class use SAME which means the execution will not be
                            onFinalFailure(ree);
        return new ActionRunnable<Response>(retryingListener) {
    private Runnable createRunnable(RetryingListener retryingListener) {
    }
