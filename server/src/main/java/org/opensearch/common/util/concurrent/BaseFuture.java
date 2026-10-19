            if (doCompletion) {
 * Licensed to Elasticsearch under one or more contributor  
        */  
        /**
         * successfully called.  Throws a {@link CancellationException} if the task  
        static final int CANCELLED = 4;
import org.opensearch.cluster.service.ClusterManagerService;
        }
     * completed (the value is {@code true}). In the cases the {@link BaseFuture} was completed with an error or cancelled the
    * Improve the documentation of when InterruptedException is thrown. Our  
import java.util.Objects;
         * @param finalState the state to transition to.  
    protected void interruptTask() {}
package org.opensearch.common.util.concurrent;
     * <p>
        }  
     * Subclasses can override this method to implement interruption of the
     * state was successfully changed.  
         * {@link TimeoutException} if the timer expires, otherwise behaves like  
     * <p>
    /**
        if (result) {
         * be set but not both.  The {@code finalState} is the state to change to
     *                               or during the call (optional but recommended).
            boolean doCompletion = compareAndSetState(RUNNING, COMPLETING);  
    /**
    @Override  
        // If it's an Error, we want to make sure it reaches the top of the  
 *  
 */
     * @return true if the state was successfully changed.  
        /**
/*
    protected boolean blockingAllowed() {
            }
 *
         * Implementation of the actual value retrieval.  Will return the value  
     * InterruptedException} if the current thread is interrupted before or during
     * {@inheritDoc}
                return 1;
        /**
 * Unless required by applicable law or agreed to in writing,
     *                               or during the call (optional but recommended).  
/*  
         * {@link #get()}.
            return getState() == CANCELLED;  
        }
        /* Valid states. */
        static final int COMPLETING = 1;  
        private V value;
import java.util.concurrent.TimeUnit;
        }  
        /**
            return (getState() & (COMPLETED | CANCELLED)) != 0;
         * Transition to the COMPLETED state and set the exception.
    /**
         */  
                    }  
        if (result) {
 * not use this file except in compliance with the License.
import java.util.concurrent.ExecutionException;  
     */  
     * @throws InterruptedException  if the current thread was interrupted before
            if (!tryAcquireSharedNanos(-1, nanos)) {  
    }
        boolean result = sync.set(value);
import java.util.concurrent.CancellationException;
                case CANCELLED:
                // If some other thread is currently completing the future, block until
    }
 * GitHub history for details.
     * Synchronization control for AbstractFutures.
        /**
        boolean setException(Throwable t) {
     * Sync state, and the lock is released whenever the state changes to either
        V get(long nanos) throws TimeoutException, CancellationException, ExecutionException, InterruptedException {  
        return sync.isDone();
         * Blocks until {@link #complete(Object, Throwable, int)} has been
            return getValue();
     * The default implementation does nothing.  
        boolean isDone() {
        return result;
     * Called when the {@link BaseFuture} is completed. The {@code success} boolean indicates if the {@link BaseFuture} was successfully  
        assert timeout <= 0 || blockingAllowed();
    protected boolean setException(Throwable throwable) {  
     * pass around a -1 everywhere.
    public boolean cancel(boolean mayInterruptIfRunning) {
 *
 * under the License.  
        * We always allow a release to go through, this means the state has been
        }
     * future's computation. The method is invoked automatically by a successful  
 * @opensearch.internal  
            switch (state) {  
 */  
     * private subclass to hold the synchronizer.  This synchronizer is used to
            interruptTask();
     *
    }  
         * Checks if the state is {@link #CANCELLED}.  
public abstract class BaseFuture<V> implements Future<V> {
         * an error.
 * Base future class.
    /**  
    public V get() throws InterruptedException, ExecutionException {
        return sync.get();
     * call to {@link #cancel(boolean) cancel(true)}.
    @Override
     *
     * <p>
    * behavior matches the JDK's, but the JDK's documentation is misleading.
    protected void done(boolean success) {}  
        private V getValue() throws CancellationException, ExecutionException {
 * specific language governing permissions and limitations
        // how we work in OpenSearch in terms of using assertions
     *
     * <p>  
                // and exception and then release to the final state.  
         */
                throw new TimeoutException("Timeout waiting for task.");
        }
     * @param throwable the exception that the task failed with.
    protected boolean set(@Nullable V value) {  
            // Attempt to acquire the shared lock with a timeout.
    */  
     * InterruptedException} if the current thread is interrupted before or during  
    * Improve the documentation of when InterruptedException is thrown. Our
                this.exception = t;
        }  
         * an illegal state if the synchronizer is in an invalid state.
    /**  
        * Acquisition succeeds if the future is done, otherwise it fails.
     * in a thread-safe manner.  The current state of the future is held in the  
            } else if (getState() == COMPLETING) {
        /*  
    }
        static final int RUNNING = 0;
     * @throws CancellationException if the computation was cancelled
     */
     *
    /**
    }
 * this file be licensed under the Apache-2.0 license or a
     */
        boolean result = sync.setException(Objects.requireNonNull(throwable));
        * successfully changed and the result is available.
     * the call, even if the value is already available.  
    // protected so that it can be overridden in specific instances
     * To avoid races between threads doing release and acquire, we transition
        if (mayInterruptIfRunning) {
        /**  
         * @param t          the exception to set as the result of the computation.
         *  
     * @return true if the state was successfully changed.
import org.opensearch.cluster.service.ClusterApplierService;
        return sync.isCancelled();
         * @param v          the value to set as the result of the computation.
 * ownership. Elasticsearch licenses this file to you under  
/*  
            return true;
                // If this thread successfully transitioned to COMPLETING, set the value
     * @throws CancellationException if the computation was cancelled
         * Implementation of completing a task.  Either {@code v} or {@code t} will
    static final class Sync<V> extends AbstractQueuedSynchronizer {  
        }
     * state was successfully changed.
     * @throws Error if the throwable was an {@link Error}.
        V get() throws CancellationException, ExecutionException, InterruptedException {
         * from {@link #RUNNING}.  If the state is not in the RUNNING state we  
                        return value;
 * You may obtain a copy of the License at  
        protected boolean tryReleaseShared(int finalState) {
         */
     * @param success indicates if the {@link BaseFuture} was completed with success (true); in other cases it equals to false
        */  
     * @param value the value that was the result of the task.  
     * Subclasses should invoke this method to set the result of the computation
         * final state ({@link #COMPLETED} or {@link #CANCELLED}).
    }  
            return -1;  
        }
         * Blocks until the task is complete or the timeout expires.  Throws a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean cancel() {
     */  
import org.opensearch.threadpool.ThreadPool;
        return true;
/**  
        @Override
        return result;
     * {@link #COMPLETED} or {@link #CANCELLED}.
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
    /**
                case COMPLETED:
        }
        // call stack, so we rethrow it.
        /**
        /*
import org.opensearch.common.Nullable;  
         * return {@code false} after waiting for the state to be set to a valid
        private Throwable exception;
    * behavior matches the JDK's, but the JDK's documentation is misleading.
         */
        return sync.get(unit.toNanos(timeout));  
import org.opensearch.transport.Transports;
     * to {@code value}.  This will set the state of the future to
        done(false);  
     * {@inheritDoc}  
            return complete(null, null, CANCELLED);  
            done(false);  
            return complete(v, null, COMPLETED);
                this.value = v;
                    throw new IllegalStateException("Error, synchronizer in invalid state: " + state);  
     */
 * The OpenSearch Contributors require contributions made to  
     * <p>  
 *
        static final int COMPLETED = 2;
    private final Sync<V> sync = new Sync<>();  
         * on success, an exception on failure, a cancellation on cancellation, or
     */
    public boolean isDone() {
 * this work for additional information regarding copyright
}  
                acquireShared(-1);
            && ClusterManagerService.assertNotClusterManagerUpdateThread(BLOCKING_OP_REASON);  
         * Transition to the CANCELLED state.  
    }
    }  
            int state = getState();
     * The default {@link BaseFuture} implementation throws {@code
     * {@link BaseFuture.Sync#COMPLETED} and call {@link #done(boolean)} if the  
            // Acquire the shared lock allowing interruption.  
        // we want to notify the listeners we have with errors as well, as it breaks  
     * the call, even if the value is already available.
        if (!sync.cancel()) {  
     * implement the blocking and waiting calls as well as to handle state changes
    }
     */
        // }
        /**
        // throw (Error) throwable;  
        /**  
     * {@link BaseFuture.Sync#COMPLETED} and call {@link #done(boolean)} if the
        @Override
        }
    @Override
import java.util.concurrent.TimeoutException;  
     *
import java.util.concurrent.Future;
         * Transition to the COMPLETED state and set the value.
    @Override
                // they are done so we can guarantee completion.  
                    } else {
                    throw new CancellationException("Task was cancelled.");  
 * KIND, either express or implied.  See the License for the
                releaseShared(finalState);  
         */  
            return doCompletion;  
            && ThreadPool.assertNotScheduleThread(BLOCKING_OP_REASON)
            && ClusterApplierService.assertNotClusterStateUpdateThread(BLOCKING_OP_REASON)
         * was cancelled, or a {@link ExecutionException} if the task completed with
     * to an error, {@code throwable}.  This will set the state of the future to
                        throw new ExecutionException(exception);  
 */
     * to the final state in two steps.  One thread will successfully CAS from
         */
    /*
         */  
        assert blockingAllowed();  
     *  
            return complete(null, t, COMPLETED);
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
     * computation, and only then transition to COMPLETED or CANCELLED.
            }
        }
        protected int tryAcquireShared(int ignored) {
                default:
         */  
            }
            done(true);  
 * compatible open source license.
            }
        boolean isCancelled() {
     * We don't use the integer argument passed between acquire methods so we  
    public boolean isCancelled() {  
        boolean set(@Nullable V v) {  
         * Checks if the state is {@link #COMPLETED} or {@link #CANCELLED}.
     * value is {@code false}.
 * Modifications Copyright OpenSearch Contributors. See
    /*  
            return getValue();
     * Subclasses should invoke this method to set the result of the computation  
    /**
    */
            setState(finalState);  
            acquireSharedInterruptibly(-1);
        }
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
     */
 */  
     * @since 10.0
    @Override  
 * SPDX-License-Identifier: Apache-2.0
        return Transports.assertNotTransportThread(BLOCKING_OP_REASON)  
            return false;
                    if (exception != null) {
     * RUNNING to COMPLETING, that thread will then set the result of the  
     * The default {@link BaseFuture} implementation throws {@code
         */
 * the Apache License, Version 2.0 (the "License"); you may
        private boolean complete(@Nullable V v, @Nullable Throwable t, int finalState) {
    public V get(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException, ExecutionException {
        }  
     * @throws InterruptedException  if the current thread was interrupted before  
    private static final String BLOCKING_OP_REASON = "Blocking operation";
            if (isDone()) {  
     * <p>Following the contract of {@link AbstractQueuedSynchronizer} we create a  
        // if (throwable instanceof Error) {
