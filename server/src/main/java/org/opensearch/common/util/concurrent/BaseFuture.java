                    } else {
     * @since 10.0
 * Licensed to Elasticsearch under one or more contributor
 * specific language governing permissions and limitations
        return sync.get(unit.toNanos(timeout));
}
     * private subclass to hold the synchronizer.  This synchronizer is used to
        done(false);
/**
     * value is {@code false}.
         * an error.
            return complete(null, t, COMPLETED);
            return doCompletion;
        }
        }
     * <p>
    private final Sync<V> sync = new Sync<>();
     * completed (the value is {@code true}). In the cases the {@link BaseFuture} was completed with an error or cancelled the
    * Improve the documentation of when InterruptedException is thrown. Our
         * final state ({@link #COMPLETED} or {@link #CANCELLED}).
        * successfully changed and the result is available.
    }
     * in a thread-safe manner.  The current state of the future is held in the
         * be set but not both.  The {@code finalState} is the state to change to
            setState(finalState);
    * behavior matches the JDK's, but the JDK's documentation is misleading.
    }
 * SPDX-License-Identifier: Apache-2.0
        */
import java.util.Objects;
        }
package org.opensearch.common.util.concurrent;
         */
                this.value = v;
            return getState() == CANCELLED;
    }
import java.util.concurrent.TimeUnit;
    /**
     *
     * {@inheritDoc}
     * <p>
 * You may obtain a copy of the License at
     *
    /**
            boolean doCompletion = compareAndSetState(RUNNING, COMPLETING);
         */
     * The default {@link BaseFuture} implementation throws {@code
import org.opensearch.common.Nullable;
 */
            if (isDone()) {
            return false;
        // throw (Error) throwable;
     * computation, and only then transition to COMPLETED or CANCELLED.
import org.opensearch.threadpool.ThreadPool;
     * @throws CancellationException if the computation was cancelled
        boolean isCancelled() {
     * The default {@link BaseFuture} implementation throws {@code
        if (result) {
        @Override
                // they are done so we can guarantee completion.
            return getValue();
            return getValue();
    @Override
        if (!sync.cancel()) {
        // call stack, so we rethrow it.
        }
            if (!tryAcquireSharedNanos(-1, nanos)) {
         * Transition to the CANCELLED state.
     * @param success indicates if the {@link BaseFuture} was completed with success (true); in other cases it equals to false
         * from {@link #RUNNING}.  If the state is not in the RUNNING state we
                    throw new CancellationException("Task was cancelled.");
        static final int COMPLETED = 2;
        private V getValue() throws CancellationException, ExecutionException {
        }
 * license agreements. See the NOTICE file distributed with
            // Acquire the shared lock allowing interruption.
    }
        private V value;
        boolean isDone() {
    public V get(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException, ExecutionException {
        /*
        /* Valid states. */
/*
            done(false);
         * return {@code false} after waiting for the state to be set to a valid
    protected boolean setException(Throwable throwable) {
 * under the License.
     * Called when the {@link BaseFuture} is completed. The {@code success} boolean indicates if the {@link BaseFuture} was successfully
        /**
            if (doCompletion) {
 * Unless required by applicable law or agreed to in writing,
                        return value;
 *
     * To avoid races between threads doing release and acquire, we transition
        if (mayInterruptIfRunning) {
     */
                this.exception = t;
            && ClusterManagerService.assertNotClusterManagerUpdateThread(BLOCKING_OP_REASON);
     * RUNNING to COMPLETING, that thread will then set the result of the
        // If it's an Error, we want to make sure it reaches the top of the
    protected boolean set(@Nullable V value) {
     * @return true if the state was successfully changed.
        }
     * <p>Following the contract of {@link AbstractQueuedSynchronizer} we create a
/*
        return result;
    /**
 * @opensearch.internal
        boolean cancel() {
        }
                default:
        static final int COMPLETING = 1;
     *                               or during the call (optional but recommended).
     * implement the blocking and waiting calls as well as to handle state changes
 */
        * Acquisition succeeds if the future is done, otherwise it fails.
        /**
            }
            switch (state) {
 * Base future class.
 *     http://www.apache.org/licenses/LICENSE-2.0
        return result;
         * Transition to the COMPLETED state and set the value.
     * @throws CancellationException if the computation was cancelled
        /**
     * the call, even if the value is already available.
            int state = getState();
 *
    public boolean cancel(boolean mayInterruptIfRunning) {
         * @param finalState the state to transition to.
            interruptTask();
     * Subclasses should invoke this method to set the result of the computation
        boolean set(@Nullable V v) {
         * Blocks until the task is complete or the timeout expires.  Throws a
            && ThreadPool.assertNotScheduleThread(BLOCKING_OP_REASON)
         * @param t          the exception to set as the result of the computation.
        }
     * future's computation. The method is invoked automatically by a successful
         * Checks if the state is {@link #CANCELLED}.
     * @return true if the state was successfully changed.
     * state was successfully changed.
            return true;
                    if (exception != null) {
         * Blocks until {@link #complete(Object, Throwable, int)} has been
        static final int RUNNING = 0;
 *
        protected int tryAcquireShared(int ignored) {
     * @throws InterruptedException  if the current thread was interrupted before
     * {@link BaseFuture.Sync#COMPLETED} and call {@link #done(boolean)} if the
    // protected so that it can be overridden in specific instances
import java.util.concurrent.TimeoutException;
        /**
        /**
public abstract class BaseFuture<V> implements Future<V> {
         */
     * InterruptedException} if the current thread is interrupted before or during
        return Transports.assertNotTransportThread(BLOCKING_OP_REASON)
     *
        V get() throws CancellationException, ExecutionException, InterruptedException {
 * Modifications Copyright OpenSearch Contributors. See
    /**
        // }
     */
     * Sync state, and the lock is released whenever the state changes to either
     * pass around a -1 everywhere.
     * Synchronization control for AbstractFutures.
import org.opensearch.cluster.service.ClusterApplierService;
        boolean result = sync.set(value);
        }
         * successfully called.  Throws a {@link CancellationException} if the task
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
                acquireShared(-1);
        // we want to notify the listeners we have with errors as well, as it breaks
     * the call, even if the value is already available.
 */
     * We don't use the integer argument passed between acquire methods so we
         * on success, an exception on failure, a cancellation on cancellation, or
                case COMPLETED:
        boolean setException(Throwable t) {
 *
     * {@link #COMPLETED} or {@link #CANCELLED}.
     * The default implementation does nothing.
                        throw new ExecutionException(exception);
 * compatible open source license.
         * {@link #get()}.
 * GitHub history for details.
         */
                // If some other thread is currently completing the future, block until
    /*
        }
    /*
 */
            }
     * @param throwable the exception that the task failed with.
     * Subclasses can override this method to implement interruption of the
            // Attempt to acquire the shared lock with a timeout.
    }
         */
 * software distributed under the License is distributed on an
     * <p>
 * the Apache License, Version 2.0 (the "License"); you may
                releaseShared(finalState);
        return true;
            }
         */
            return -1;
import java.util.concurrent.CancellationException;
            } else if (getState() == COMPLETING) {
     * to the final state in two steps.  One thread will successfully CAS from
     *
                    }
                    throw new IllegalStateException("Error, synchronizer in invalid state: " + state);
    */
     * {@link BaseFuture.Sync#COMPLETED} and call {@link #done(boolean)} if the
        /**
         * Implementation of the actual value retrieval.  Will return the value
 * KIND, either express or implied.  See the License for the
        // if (throwable instanceof Error) {
                // If this thread successfully transitioned to COMPLETING, set the value
        boolean result = sync.setException(Objects.requireNonNull(throwable));
         * Implementation of completing a task.  Either {@code v} or {@code t} will
            return complete(null, null, CANCELLED);
            acquireSharedInterruptibly(-1);
import java.util.concurrent.Future;
                // and exception and then release to the final state.
     */
            return complete(v, null, COMPLETED);
            && ClusterApplierService.assertNotClusterStateUpdateThread(BLOCKING_OP_REASON)
     * to an error, {@code throwable}.  This will set the state of the future to
     *
        }
     * Subclasses should invoke this method to set the result of the computation
         * Transition to the COMPLETED state and set the exception.
 * not use this file except in compliance with the License.
         * an illegal state if the synchronizer is in an invalid state.
                throw new TimeoutException("Timeout waiting for task.");
        @Override
     * call to {@link #cancel(boolean) cancel(true)}.
        V get(long nanos) throws TimeoutException, CancellationException, ExecutionException, InterruptedException {
    public V get() throws InterruptedException, ExecutionException {
        /*
    @Override
    static final class Sync<V> extends AbstractQueuedSynchronizer {
         * was cancelled, or a {@link ExecutionException} if the task completed with
    * Improve the documentation of when InterruptedException is thrown. Our
         */
    protected void done(boolean success) {}
import org.opensearch.transport.Transports;
         */
     * <p>
     *                               or during the call (optional but recommended).
     * {@inheritDoc}
import org.opensearch.cluster.service.ClusterManagerService;
        }
import java.util.concurrent.ExecutionException;
        if (result) {
    @Override
        // how we work in OpenSearch in terms of using assertions
        static final int CANCELLED = 4;
    public boolean isCancelled() {
         * {@link TimeoutException} if the timer expires, otherwise behaves like
        }
    private static final String BLOCKING_OP_REASON = "Blocking operation";
        return sync.isCancelled();
        /**
     */
    }
        private Throwable exception;
         * @param v          the value to set as the result of the computation.
         *
     */
    }
        return sync.isDone();
    /**
 * this file be licensed under the Apache-2.0 license or a
        */
     * @param value the value that was the result of the task.
 * this work for additional information regarding copyright
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected void interruptTask() {}
        assert blockingAllowed();
        /**
     * state was successfully changed.
        assert timeout <= 0 || blockingAllowed();
    /**
     *
    /**
         * Checks if the state is {@link #COMPLETED} or {@link #CANCELLED}.
                case CANCELLED:
     */
            return (getState() & (COMPLETED | CANCELLED)) != 0;
     * <p>
        * We always allow a release to go through, this means the state has been
    public boolean isDone() {
     */
        protected boolean tryReleaseShared(int finalState) {
     * to {@code value}.  This will set the state of the future to
         */
     * @throws InterruptedException  if the current thread was interrupted before
            }
    */
    protected boolean blockingAllowed() {
        /**
    }
        private boolean complete(@Nullable V v, @Nullable Throwable t, int finalState) {
            done(true);
        return sync.get();
    /**
    * behavior matches the JDK's, but the JDK's documentation is misleading.
/*
    @Override
    @Override
        }
 * ownership. Elasticsearch licenses this file to you under
     */
     * @throws Error if the throwable was an {@link Error}.
    }
                return 1;
     * InterruptedException} if the current thread is interrupted before or during
 * The OpenSearch Contributors require contributions made to
