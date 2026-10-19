            .map(t -> t.v1() + "\n" + ExceptionsHelper.formatStackTrace(t.v2()))  
import java.io.Closeable;
                this.stackTrace = null;  
            });
            @Override  
 * completed.  
    }  
    private int queuedBlockOperations; // does not need to be volatile as all accesses are done under a lock on this
 * Tracks shard operation permits. Each operation on the shard obtains a permit. When we need to block operations (e.g., to transition  
        onAcquired.onResponse(releasable);  
                    if (executorOnDelay != null) {
        } else {
     *         when the permit was acquired plus a stack traces that was captured when the permit was request.
     * @param onAcquired {@link ActionListener} that is invoked once acquisition is successful or failed
    private static class DelayedOperation {  
 * under the License.  
import java.util.concurrent.atomic.AtomicBoolean;
                for (DelayedOperation queuedAction : queuedActions) {
     *                        the tracing will capture the supplied object's {@link Object#toString()} value. Otherwise the object
     * @param threadPool the thread pool (used to execute delayed operations)
            assert queuedBlockOperations > 0 || delayedOperations.isEmpty();
            return IndexShard.OPERATIONS_BLOCKED; // This occurs when blockOperations() has acquired all the permits.
        }  
import org.opensearch.common.util.concurrent.AbstractRunnable;
     * operations are run once the {@link Releasable} is released or if a failure occurs while acquiring all permits; in this case the
        delayOperations();
package org.opensearch.index.shard;
                    try {
     * @param timeout   the maximum time to wait for the in-flight operations block
 * KIND, either express or implied.  See the License for the
                delayedOperations.clear();
    private Releasable acquireAll(final long timeout, final TimeUnit timeUnit) throws InterruptedException, TimeoutException {  
            if (queuedBlockOperations == 0) {
     *                        isn't used
 * The OpenSearch Contributors require contributions made to  
            synchronized (this) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param <E>       the type of checked exception thrown by {@code onBlocked}
             *     recovery
        final boolean forceExecution,
        final ActionListener<Releasable> onAcquired,  
                                    return forceExecution;
     *
    }  
    }  
             *     onFailure handler is executed on the calling thread; this should not be the recovery thread as it would delay the
            releaseDelayedOperations();
                queuedActions = new ArrayList<>(delayedOperations);  
 * specific language governing permissions and limitations
     *
    // only valid when assertions are enabled. Key is AtomicBoolean associated with each permit to ensure close once semantics.  
                    }  
     * Represents a delayed operation
        if (semaphore.tryAcquire(1, 0, TimeUnit.SECONDS)) { // the un-timed tryAcquire methods do not honor the fairness setting
                    semaphore.release(1);
            issuedPermits = null;
     * @throws IndexShardClosedException if operation permit has been closed
import org.opensearch.common.collect.Tuple;
                    acquire(queuedAction.listener, null, false, queuedAction.debugInfo, queuedAction.stackTrace);  
     * that the {@link ActionListener#onFailure(Exception)} method provided here only contains lightweight operations.
        final Releasable releasable;
 * Licensed to Elasticsearch under one or more contributor  
     *
     * {@link ActionListener} will be called on the calling thread. During calls of
        threadPool.executor(ThreadPool.Names.GENERIC).execute(new AbstractRunnable() {
     * @throws TimeoutException          if timed out waiting for in-flight operations to finish
import org.opensearch.threadpool.ThreadPool;
                                    IOUtils.closeWhileHandlingException(r);
                    final ActionListener<Releasable> wrappedListener;  
 * GitHub history for details.
        } else {
                final Releasable releasable = acquireAll(timeout, timeUnit);
            });
 *
            .collect(Collectors.toList());
    <E extends Exception> void blockOperations(final long timeout, final TimeUnit timeUnit, final CheckedRunnable<E> onBlocked)
     * operations that are occurring in the meanwhile and runs them once {@code onBlocked} has executed.  
        } finally {  
                    return;
import java.util.concurrent.ConcurrentHashMap;  
                                public void onRejection(Exception e) {
    List<String> getActiveOperations() {  
 */  
                                }
            if (Assertions.ENABLED) {
     * Immediately delays operations and on another thread waits for in-flight operations to finish and then acquires all permits. When all  
        acquire(onAcquired, executorOnDelay, forceExecution, debugInfo, stackTrace);
        if (closed) {  
    ) {
        }  
}
        } else {
        return queuedBlockOperations > 0;
    public void asyncBlockOperations(final ActionListener<Releasable> onAcquired, final long timeout, final TimeUnit timeUnit) {  
     * @param timeUnit   the time unit of the {@code timeout} argument
            final RunOnce release = new RunOnce(() -> {
/*  
        }
        }  
                        wrappedListener = new ContextPreservingActionListener<>(contextSupplier, onAcquired);
            this.listener = listener;  
            @Override  
            protected void doRun() throws Exception {
     *  
                if (queuedBlockOperations > 0) {
        if (Assertions.ENABLED) {
            // since delayed is not volatile, we have to synchronize even here for visibility
            threadPool.executor(ThreadPool.Names.GENERIC).execute(() -> {
            final AtomicBoolean closed = new AtomicBoolean();  
        }  
    private Releasable acquire(Object debugInfo, StackTraceElement[] stackTrace) throws InterruptedException {  
        }
 * software distributed under the License is distributed on an
     *
            if (Assertions.ENABLED) {
     */
 * compatible open source license.
                    }
    private void acquire(
        int availablePermits = semaphore.availablePermits();
    private volatile boolean closed;  
        try {
                                    listener.onResponse(r);  
    }
import java.util.concurrent.Semaphore;
    /**
    IndexShardOperationPermits(final ShardId shardId, final ThreadPool threadPool) {
import org.opensearch.action.ActionRunnable;
        delayOperations();  
    private void delayOperations() {
    // Value is a tuple, with a some debug information supplied by the caller and a stack trace of the acquiring thread
                            })
            onAcquired.onFailure(e);
        }
                                @Override
             */  
                            new ContextPreservingActionListener<>(contextSupplier, onAcquired),  
        if (closed) {  
            final RunOnce released = new RunOnce(() -> releaseDelayedOperations());
    synchronized boolean isBlocked() {
/*  
                assert semaphore.availablePermits() == 0;  
    ) {
            return release::run;  
    }
                        assert existing != null;
                assert queuedBlockOperations > 0;
                    } else {
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        final Object debugInfo  
     * @return a list of describing each permit that wasn't released yet. The description consist of the debugInfo supplied  
    private final Map<AtomicBoolean, Tuple<String, StackTraceElement[]>> issuedPermits;
 * the Apache License, Version 2.0 (the "License"); you may
        }
                                @Override
                onAcquired.onResponse(() -> {  
            }
        } else {  
        private final String debugInfo;
        closed = true;
        } else {
    }  
                } finally {
     */
     * {@link #blockOperations(long, TimeUnit, CheckedRunnable)}, permit acquisition can be delayed.  
    private final ThreadPool threadPool;
                if (closed.compareAndSet(false, true)) {
     * @opensearch.internal
        }
        this.threadPool = threadPool;  
     * Acquires a permit whenever permit acquisition is not blocked. If the permit is directly available, the provided
    /**
            .stream()
            synchronized (this) {  
 *  
    private void releaseDelayedOperations() {  
                semaphore.release(TOTAL_PERMITS);
        }
    }  
                        Tuple<String, StackTraceElement[]> existing = issuedPermits.remove(closed);
 *
            return releasable;
                this.debugInfo = "[delayed] " + debugInfo;
                    }  
    }
import org.opensearch.common.lease.Releasable;  
        final Object debugInfo,  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;  
 * not use this file except in compliance with the License.
            assert queuedBlockOperations > 0;  
     * @param onAcquired      {@link ActionListener} that is invoked once acquisition is successful or failed  
import java.util.Map;
        final boolean forceExecution,
     * Obtain the active operation count, or {@link IndexShard#OPERATIONS_BLOCKED} if all permits are held.  
            } else {
 * ownership. Elasticsearch licenses this file to you under  
        synchronized (this) {  
        return issuedPermits.values()
    private final ShardId shardId;  
                } else {  
        });
        final String executorOnDelay,
     * @param timeout    the maximum time to wait for the in-flight operations block  
    final Semaphore semaphore = new Semaphore(TOTAL_PERMITS, true); // fair to ensure a blocking thread is not starved
            return TOTAL_PERMITS - availablePermits;  
     */
            queuedBlockOperations++;
        if (Assertions.ENABLED) {  
                                }
import java.util.List;
    }  
            throw new TimeoutException("timeout while blocking operations");
            }  
     * @return the active operation count, or {@link IndexShard#OPERATIONS_BLOCKED} when all permits are held.
                this.debugInfo = null;
                                    super.onRejection(e);  
            return;
                try {
     * The {@link ActionListener#onResponse(Object)} method will then be called using the provided executor once operations are no
import java.util.ArrayList;
        if (semaphore.tryAcquire(TOTAL_PERMITS, timeout, timeUnit)) {
        final ActionListener<Releasable> onAcquired,  
                        wrappedListener = ActionListener.delegateFailure(
                issuedPermits.put(closed, new Tuple<>(debugInfo.toString(), stackTrace));
    }
        } catch (final InterruptedException e) {
     * directly on the calling thread, which in case of delays, will be a generic thread. Callers should thus make sure  
import org.opensearch.common.CheckedRunnable;
    }
    private final List<DelayedOperation> delayedOperations = new ArrayList<>(); // operations that are delayed
                    releasable = acquire(debugInfo, stackTrace);
import org.opensearch.common.util.concurrent.RunOnce;
    }
             * Try acquiring permits on fresh thread (for two reasons):
    }  
                        released.run();
                    released.run(); // resume delayed operations as soon as possible  
        if (Assertions.ENABLED) {
     * {@code onFailure} handler will be invoked after delayed operations are released.  
 * this work for additional information regarding copyright
    int getActiveOperationsCount() {
                }
        private final ActionListener<Releasable> listener;
            }
            return;  
        assert Thread.holdsLock(this);
    static final int TOTAL_PERMITS = Integer.MAX_VALUE;  
                });  
     * @throws InterruptedException      if calling thread is interrupted  
 */  
            public void onFailure(final Exception e) {
             *     the threaded action listener if the queue of the thread pool on which it submits is full
                                protected void doRun() {
             *   - if a permit is acquired and the queue of the thread pool which the threaded action listener uses is full, the  
                }
 * and return their permits. Delayed operations will acquire permits and be completed after the operation that blocked all operations has
    /**  
            onBlocked.run();
    /**
     * @param executorOnDelay executor to use for the possibly delayed {@link ActionListener#onResponse(Object)} call
     * @param shardId    the shard
        final StackTraceElement[] stackTrace
     * @param onBlocked the action to run once the block has been acquired
    public void acquire(
        // execute this outside the synchronized block!
 */
    /**
                        );  
     * Construct operation permits for the specified shards.
     * @param timeUnit  the time unit of the {@code timeout} argument  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
import java.util.stream.Collectors;  
                            (l, r) -> threadPool.executor(executorOnDelay).execute(new ActionRunnable<Releasable>(l) {
                this.stackTrace = stackTrace;  
        private final StackTraceElement[] stackTrace;  
    @Override
                    final Supplier<StoredContext> contextSupplier = threadPool.getThreadContext().newRestorableContext(false);
     * longer blocked. Note that the executor will not be used for {@link ActionListener#onFailure(Exception)} calls. Those will run
     */
import org.opensearch.common.util.concurrent.ThreadContext.StoredContext;  
     * Wait for in-flight operations to finish and executes {@code onBlocked} under the guarantee that no new operations are started. Queues
    /**
            stackTrace = null;  
     */  
import org.opensearch.action.support.ContextPreservingActionListener;  
        throws InterruptedException, TimeoutException, E {
        final List<DelayedOperation> queuedActions;
        if (availablePermits == 0) {  
            throw new IllegalStateException("failed to obtain permit but operations are not delayed");
 * You may obtain a copy of the License at  
            }  
            // this should never happen, if it does something is deeply wrong  
/**
import java.util.function.Supplier;
        try (Releasable ignored = acquireAll(timeout, timeUnit)) {
            /*
        }
            } else {
import org.opensearch.core.index.shard.ShardId;
 * SPDX-License-Identifier: Apache-2.0
                                public boolean isForceExecution() {  
                }
import org.opensearch.core.action.ActionListener;  
                    onAcquired.onFailure(e);
        synchronized (this) {
        this.shardId = shardId;
    public void close() {  
     */  
            throw new IndexShardClosedException(shardId);
     * @param forceExecution  whether the runnable should force its execution in case it gets rejected
     *  
            }
    /**
                }  
                    if (Assertions.ENABLED) {  
            };  
                queuedActions = Collections.emptyList();  
        final StackTraceElement[] stackTrace;
             *   - blockOperations can be called on a recovery thread which can be expected to be interrupted when recovery is cancelled;  
 */  
        final String executorOnDelay,
 * Unless required by applicable law or agreed to in writing,
     * @param debugInfo       an extra information that can be useful when tracing an unreleased permit. When assertions are enabled  
                        releasable.close();
                    } finally {  
import org.opensearch.common.util.io.IOUtils;
 * between terms) we immediately delay all operations to a queue, obtain all available permits, and wait for outstanding operations to drain
     * permits are acquired, the provided {@link ActionListener} is called under the guarantee that no new operations are started. Delayed
        if (!queuedActions.isEmpty()) {  
                                }
            onAcquired.onFailure(new IndexShardClosedException(shardId));
            issuedPermits = new ConcurrentHashMap<>();
     *  
            }
import org.opensearch.core.Assertions;
        }
import java.util.concurrent.TimeoutException;  
             *     interruptions are bad here as permit acquisition will throw an interrupted exception which will be swallowed by
        }
            final Releasable releasable = () -> {
    }
            stackTrace = Thread.currentThread().getStackTrace();
        }  
            queuedBlockOperations--;
import java.util.concurrent.TimeUnit;
/*
            }
import org.opensearch.ExceptionsHelper;
                                @Override  
 *
 * @opensearch.internal
                    delayedOperations.add(new DelayedOperation(wrappedListener, debugInfo, stackTrace));
        private DelayedOperation(ActionListener<Releasable> listener, Object debugInfo, StackTraceElement[] stackTrace) {
final class IndexShardOperationPermits implements Closeable {
