    List<String> getActiveOperations() {
        private final String debugInfo;
     * @param timeout    the maximum time to wait for the in-flight operations block
import java.util.Collections;
     * @throws InterruptedException      if calling thread is interrupted
 * @opensearch.internal
import org.opensearch.common.collect.Tuple;
import java.io.Closeable;
            final AtomicBoolean closed = new AtomicBoolean();
     */
     *                        isn't used
        if (Assertions.ENABLED) {
        } else {
                }
    }
        }
 * completed.
        }
import java.util.stream.Collectors;
     */
                try {
        final Object debugInfo
            } else {
                        assert existing != null;
             *     recovery
            if (queuedBlockOperations == 0) {
        synchronized (this) {
     * @param <E>       the type of checked exception thrown by {@code onBlocked}
        }
        final boolean forceExecution,
    /**
            });
    private void releaseDelayedOperations() {
     * @throws IndexShardClosedException if operation permit has been closed
     */
            issuedPermits = null;
import org.opensearch.core.Assertions;
            queuedBlockOperations++;
    }
/*
        final boolean forceExecution,
        final String executorOnDelay,
             */
                                    super.onRejection(e);
            issuedPermits = new ConcurrentHashMap<>();
            // since delayed is not volatile, we have to synchronize even here for visibility
        delayOperations();
                        );
import org.opensearch.common.util.concurrent.RunOnce;
            if (Assertions.ENABLED) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * operations that are occurring in the meanwhile and runs them once {@code onBlocked} has executed.
        }
 * and return their permits. Delayed operations will acquire permits and be completed after the operation that blocked all operations has
                    if (Assertions.ENABLED) {
import java.util.Map;
                if (queuedBlockOperations > 0) {
        }
                            (l, r) -> threadPool.executor(executorOnDelay).execute(new ActionRunnable<Releasable>(l) {
 *
                    releasable = acquire(debugInfo, stackTrace);
     * Represents a delayed operation
                for (DelayedOperation queuedAction : queuedActions) {
                }
        threadPool.executor(ThreadPool.Names.GENERIC).execute(new AbstractRunnable() {
            /*
                this.debugInfo = "[delayed] " + debugInfo;
            };
        } catch (final InterruptedException e) {
 * Unless required by applicable law or agreed to in writing,
    public void close() {
        final ActionListener<Releasable> onAcquired,
            }
        final ActionListener<Releasable> onAcquired,
        final List<DelayedOperation> queuedActions;
     * @param timeUnit   the time unit of the {@code timeout} argument
 * GitHub history for details.
                        released.run();
    }
            throw new IllegalStateException("failed to obtain permit but operations are not delayed");
 * The OpenSearch Contributors require contributions made to
    static final int TOTAL_PERMITS = Integer.MAX_VALUE;
                } else {
             *   - if a permit is acquired and the queue of the thread pool which the threaded action listener uses is full, the
import java.util.List;
    IndexShardOperationPermits(final ShardId shardId, final ThreadPool threadPool) {
        } else {
            return IndexShard.OPERATIONS_BLOCKED; // This occurs when blockOperations() has acquired all the permits.
/**
     */
            }
                    onAcquired.onFailure(e);
 * compatible open source license.
     * @opensearch.internal
     * @param onBlocked the action to run once the block has been acquired
                                }
        } else {
     *
        private DelayedOperation(ActionListener<Releasable> listener, Object debugInfo, StackTraceElement[] stackTrace) {
 * ownership. Elasticsearch licenses this file to you under
        try {
        return issuedPermits.values()
            if (Assertions.ENABLED) {
                this.debugInfo = null;
            queuedBlockOperations--;
                                    IOUtils.closeWhileHandlingException(r);
import org.opensearch.common.lease.Releasable;
            protected void doRun() throws Exception {
        } finally {
                assert queuedBlockOperations > 0;
        onAcquired.onResponse(releasable);
     * {@link #blockOperations(long, TimeUnit, CheckedRunnable)}, permit acquisition can be delayed.
    /**
    }
     * directly on the calling thread, which in case of delays, will be a generic thread. Callers should thus make sure
                    }
                        Tuple<String, StackTraceElement[]> existing = issuedPermits.remove(closed);
import java.util.concurrent.TimeUnit;
    private int queuedBlockOperations; // does not need to be volatile as all accesses are done under a lock on this
     *                        the tracing will capture the supplied object's {@link Object#toString()} value. Otherwise the object
                    } else {
        if (semaphore.tryAcquire(TOTAL_PERMITS, timeout, timeUnit)) {
     * @return the active operation count, or {@link IndexShard#OPERATIONS_BLOCKED} when all permits are held.
        throws InterruptedException, TimeoutException, E {
                    }
 * SPDX-License-Identifier: Apache-2.0
        }
 * You may obtain a copy of the License at
                this.stackTrace = null;
                onAcquired.onResponse(() -> {
        if (!queuedActions.isEmpty()) {
                queuedActions = new ArrayList<>(delayedOperations);
import org.opensearch.common.util.concurrent.AbstractRunnable;
            synchronized (this) {
     * {@code onFailure} handler will be invoked after delayed operations are released.
 * license agreements. See the NOTICE file distributed with
    }
                issuedPermits.put(closed, new Tuple<>(debugInfo.toString(), stackTrace));
            releaseDelayedOperations();
     * @throws TimeoutException          if timed out waiting for in-flight operations to finish
                }
import org.opensearch.action.support.ContextPreservingActionListener;
            @Override
    private final ThreadPool threadPool;
            onBlocked.run();
            }
             *   - blockOperations can be called on a recovery thread which can be expected to be interrupted when recovery is cancelled;
        delayOperations();
            throw new TimeoutException("timeout while blocking operations");
        // execute this outside the synchronized block!
 * under the License.
final class IndexShardOperationPermits implements Closeable {
            });
        acquire(onAcquired, executorOnDelay, forceExecution, debugInfo, stackTrace);
     * Wait for in-flight operations to finish and executes {@code onBlocked} under the guarantee that no new operations are started. Queues
     * The {@link ActionListener#onResponse(Object)} method will then be called using the provided executor once operations are no
 * between terms) we immediately delay all operations to a queue, obtain all available permits, and wait for outstanding operations to drain
        synchronized (this) {
 * Licensed to Elasticsearch under one or more contributor
                }
 * software distributed under the License is distributed on an
            throw new IndexShardClosedException(shardId);
    }
            return release::run;
                                    listener.onResponse(r);
            onAcquired.onFailure(e);
/*
    private final List<DelayedOperation> delayedOperations = new ArrayList<>(); // operations that are delayed
        }
                                public void onRejection(Exception e) {
 * the Apache License, Version 2.0 (the "License"); you may
        private final StackTraceElement[] stackTrace;
 */
            stackTrace = null;
     * @param debugInfo       an extra information that can be useful when tracing an unreleased permit. When assertions are enabled
                    released.run(); // resume delayed operations as soon as possible
                delayedOperations.clear();
     *
        }
                semaphore.release(TOTAL_PERMITS);
import java.util.concurrent.TimeoutException;
                                    return forceExecution;
            assert queuedBlockOperations > 0 || delayedOperations.isEmpty();
        if (Assertions.ENABLED) {
package org.opensearch.index.shard;
                assert semaphore.availablePermits() == 0;
            public void onFailure(final Exception e) {
     * @param threadPool the thread pool (used to execute delayed operations)
        }
            return releasable;
     */
     * that the {@link ActionListener#onFailure(Exception)} method provided here only contains lightweight operations.
        } else {
            }
                    final ActionListener<Releasable> wrappedListener;
    }
                    }
            .collect(Collectors.toList());
        closed = true;
            this.listener = listener;
                    acquire(queuedAction.listener, null, false, queuedAction.debugInfo, queuedAction.stackTrace);
    /**
        if (Assertions.ENABLED) {
            threadPool.executor(ThreadPool.Names.GENERIC).execute(() -> {
     * @param onAcquired      {@link ActionListener} that is invoked once acquisition is successful or failed
                    delayedOperations.add(new DelayedOperation(wrappedListener, debugInfo, stackTrace));
     * @param timeout   the maximum time to wait for the in-flight operations block
        } else {
                queuedActions = Collections.emptyList();
     * @param onAcquired {@link ActionListener} that is invoked once acquisition is successful or failed
            return;
                final Releasable releasable = acquireAll(timeout, timeUnit);
     * operations are run once the {@link Releasable} is released or if a failure occurs while acquiring all permits; in this case the
 * Tracks shard operation permits. Each operation on the shard obtains a permit. When we need to block operations (e.g., to transition
    final Semaphore semaphore = new Semaphore(TOTAL_PERMITS, true); // fair to ensure a blocking thread is not starved
import org.opensearch.core.index.shard.ShardId;
                    semaphore.release(1);
                    } finally {
                                @Override
 */
                });
            // this should never happen, if it does something is deeply wrong
    @Override
             * Try acquiring permits on fresh thread (for two reasons):
     * Obtain the active operation count, or {@link IndexShard#OPERATIONS_BLOCKED} if all permits are held.
     *
     * Immediately delays operations and on another thread waits for in-flight operations to finish and then acquires all permits. When all
     *
 * this file be licensed under the Apache-2.0 license or a
        }
        }
        final StackTraceElement[] stackTrace
            @Override
}
        final Object debugInfo,
            synchronized (this) {
 *
    private static class DelayedOperation {
 *
import java.util.concurrent.atomic.AtomicBoolean;
        if (closed) {
            } else {
    ) {
    }
                if (closed.compareAndSet(false, true)) {
        private final ActionListener<Releasable> listener;
    private final ShardId shardId;
                    final Supplier<StoredContext> contextSupplier = threadPool.getThreadContext().newRestorableContext(false);
            onAcquired.onFailure(new IndexShardClosedException(shardId));
    /**
     * @param shardId    the shard
                                public boolean isForceExecution() {
    /**
    /**
        if (semaphore.tryAcquire(1, 0, TimeUnit.SECONDS)) { // the un-timed tryAcquire methods do not honor the fairness setting
            final RunOnce released = new RunOnce(() -> releaseDelayedOperations());
 * this work for additional information regarding copyright
        final String executorOnDelay,
                        releasable.close();
        int availablePermits = semaphore.availablePermits();
     * permits are acquired, the provided {@link ActionListener} is called under the guarantee that no new operations are started. Delayed
             *     the threaded action listener if the queue of the thread pool on which it submits is full
        return queuedBlockOperations > 0;
    private Releasable acquireAll(final long timeout, final TimeUnit timeUnit) throws InterruptedException, TimeoutException {
                    return;
     * Acquires a permit whenever permit acquisition is not blocked. If the permit is directly available, the provided
import org.opensearch.core.action.ActionListener;
            return TOTAL_PERMITS - availablePermits;
     *
            }
            stackTrace = Thread.currentThread().getStackTrace();
        }
    }
    private final Map<AtomicBoolean, Tuple<String, StackTraceElement[]>> issuedPermits;
             *     onFailure handler is executed on the calling thread; this should not be the recovery thread as it would delay the
    }
    }
            .map(t -> t.v1() + "\n" + ExceptionsHelper.formatStackTrace(t.v2()))
            return;
        }
                this.stackTrace = stackTrace;
import org.opensearch.common.CheckedRunnable;
     * @return a list of describing each permit that wasn't released yet. The description consist of the debugInfo supplied
    }
        this.threadPool = threadPool;
    int getActiveOperationsCount() {
     * longer blocked. Note that the executor will not be used for {@link ActionListener#onFailure(Exception)} calls. Those will run
        }
            }
     */
    /**
    synchronized boolean isBlocked() {
import java.util.function.Supplier;
     * @param executorOnDelay executor to use for the possibly delayed {@link ActionListener#onResponse(Object)} call
            final RunOnce release = new RunOnce(() -> {
import org.opensearch.common.util.io.IOUtils;
 * KIND, either express or implied.  See the License for the
    // only valid when assertions are enabled. Key is AtomicBoolean associated with each permit to ensure close once semantics.
import org.opensearch.action.ActionRunnable;
        assert Thread.holdsLock(this);
    }
 */
/*
    // Value is a tuple, with a some debug information supplied by the caller and a stack trace of the acquiring thread
import java.util.ArrayList;
     *
            assert queuedBlockOperations > 0;
 * Modifications Copyright OpenSearch Contributors. See
        final StackTraceElement[] stackTrace;
                    try {
     *
 * specific language governing permissions and limitations
                            })
    public void asyncBlockOperations(final ActionListener<Releasable> onAcquired, final long timeout, final TimeUnit timeUnit) {
    private void acquire(
     * {@link ActionListener} will be called on the calling thread. During calls of
                                protected void doRun() {
 * not use this file except in compliance with the License.
 */
            final Releasable releasable = () -> {
     * Construct operation permits for the specified shards.
                                }
import org.opensearch.common.util.concurrent.ThreadContext.StoredContext;
    ) {
                    if (executorOnDelay != null) {
    public void acquire(
        try (Releasable ignored = acquireAll(timeout, timeUnit)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.Semaphore;
            }
     * @param timeUnit  the time unit of the {@code timeout} argument
import org.opensearch.threadpool.ThreadPool;
                                @Override
            .stream()
                                @Override
import org.opensearch.ExceptionsHelper;
    private Releasable acquire(Object debugInfo, StackTraceElement[] stackTrace) throws InterruptedException {
                            new ContextPreservingActionListener<>(contextSupplier, onAcquired),
     *         when the permit was acquired plus a stack traces that was captured when the permit was request.
        if (availablePermits == 0) {
import java.util.concurrent.ConcurrentHashMap;
        if (closed) {
        this.shardId = shardId;
             *     interruptions are bad here as permit acquisition will throw an interrupted exception which will be swallowed by
        final Releasable releasable;
    <E extends Exception> void blockOperations(final long timeout, final TimeUnit timeUnit, final CheckedRunnable<E> onBlocked)
    private volatile boolean closed;
    private void delayOperations() {
                } finally {
                                }
                        wrappedListener = ActionListener.delegateFailure(
    }
 *
     */
     * @param forceExecution  whether the runnable should force its execution in case it gets rejected
                        wrappedListener = new ContextPreservingActionListener<>(contextSupplier, onAcquired);
        });
