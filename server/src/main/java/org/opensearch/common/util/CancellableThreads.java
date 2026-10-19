    }
            super(msg);
/*
    }
            // if we're not canceling, we throw the original exception
            assert false : "the passed interruptible can not result in an IOException";
 */
            synchronized (this) {
    @FunctionalInterface
    }
        RuntimeException runtimeException = null;
/**
        }
    }
            cancelledByExternalInterrupt = !cancelled;
            final String reason;
        boolean wasInterrupted = add();
    /** cancel all current running operations. Future calls to {@link #checkForCancel()} will be failed with the given reason */
            throw cancelExp;
     *
import java.util.HashSet;
        if (isCancelled()) {
    public void execute(Interruptible interruptible) {
 * not use this file except in compliance with the License.
 *
    public synchronized void cancel(String reason) {
package org.opensearch.common.util;
            throw new RuntimeException("Interruption via Thread#interrupt() is unsupported. Use CancellableThreads#cancel() instead");
     */
     *
    private synchronized void remove() {
    private void checkForCancel(Exception beforeCancelException) {
         * will fail with the default exception {@link ExecutionCancelledException}.
            runtimeException = t;
            interruptible.run();
            throw runtimeException;
    // needs to be volatile as it is also read outside of synchronized blocks.
 *
 * software distributed under the License is distributed on an
    @PublicApi(since = "1.0.0")
 */
        public ExecutionCancelledException(StreamInput in) throws IOException {
        // our own interrupt. we do so under lock so we know we don't clear our own.
        }
 * GitHub history for details.
        checkForCancel(null);
 * @opensearch.api
     * Called when a thread is cancelled
            // Thread.interrupted without handling it
     *
     * IO Interruptible
                onCancel.onCancel(reason, beforeCancelException);
        } catch (IOException e) {
 * KIND, either express or implied.  See the License for the
 * Cancellation policy: This class does not support external interruption via <code>Thread#interrupt()</code>. Always use #cancel() instead.
     *
            remove();
    @PublicApi(since = "1.0.0")
 *
     * run the Interruptible, capturing the executing thread. Concurrent calls to {@link #cancel(String)} will interrupt this thread
    public synchronized void setOnCancel(OnCancel onCancel) {
 * SPDX-License-Identifier: Apache-2.0
            thread.interrupt();
        for (Thread thread : threads) {
         * @param beforeCancelException any error that was encountered during the execution before the operations were cancelled.
        /**
     * run the Interruptible, capturing the executing thread. Concurrent calls to {@link #cancel(String)} will interrupt this thread
    public void checkForCancel() {
     * @opensearch.api
        }
import org.opensearch.OpenSearchException;
        try {
                cancelExp.addSuppressed(beforeCancelException);
    }
        return Thread.interrupted();
 * license agreements. See the NOTICE file distributed with
    private String reason;
 * A utility class for multi threaded operation that needs to be cancellable via interrupts. Every cancellable operation should be
 * Licensed to Elasticsearch under one or more contributor
         * @param reason                the reason of the cancellation
        boolean cancelledByExternalInterrupt = false;
        if (wasInterrupted) {
    public interface OnCancel {
    public interface Interruptible extends IOInterruptible {
        }
    public void executeIO(IOInterruptible interruptible) throws IOException {
/*
    private synchronized boolean add() {
@PublicApi(since = "1.0.0")
         * @see #setOnCancel(OnCancel)
            super(in);
            // ignore, this interrupt has been triggered by us in #cancel()...
            Thread.currentThread().interrupt();
    public synchronized boolean isCancelled() {
import org.opensearch.core.common.io.stream.StreamInput;
         * If this method throws an exception, cancelling tasks will fail with that exception; otherwise they
import java.io.IOException;
    }
         * Called when some running operations are cancelled or {@link #checkForCancel()} is explicitly called.
            // fallback to the default exception
            // this is important in order to make sure that we don't mark
        // capture and clean the interrupted thread before we start, so we can identify
    /**
 * this work for additional information regarding copyright
     * @param interruptible code to run
     * causing the call to prematurely return.
 * ownership. Elasticsearch licenses this file to you under
        threads.clear();
        void run() throws IOException, InterruptedException;
            // if we're not canceling, we throw the original exception
    private volatile boolean cancelled = false;
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final SetOnce<OnCancel> onCancel = new SetOnce<>();
        } catch (RuntimeException t) {
 * compatible open source license.
    }
    }
     */
        try {
public class CancellableThreads {
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
        void run() throws InterruptedException;
    }
        threads.add(Thread.currentThread());
                onCancel = this.onCancel.get();
            // restore interrupt flag to at least adhere to expected behavior
 * of cancellation.
 * <p>
        checkForCancel();
     */
            }
        } else {
            }
        if (cancelledByExternalInterrupt) {
        }
        threads.remove(Thread.currentThread());
     *
            executeIO(interruptible);
            // we were already cancelled, make sure we don't interrupt threads twice
    private final Set<Thread> threads = new HashSet<>();
        public ExecutionCancelledException(String msg) {
        return cancelled;
    /**
    }
        } finally {
/*
import java.util.Set;
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.util.ThreadInterruptedException;
     */
    public static class ExecutionCancelledException extends OpenSearchException {
        this.onCancel.set(onCancel);
     * @opensearch.api
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
        if (cancelled) {
        }
        IOException ioException = null;
    }
            // been interrupted externally (which we don't support).
    /**
        }
         */
            final OnCancel onCancel;
 *
            throw ioException;
     *
     */
        // we are now out of threads collection so we can't be interrupted any more by this class
     * Thrown if there is an error cancelling execution
        void onCancel(String reason, @Nullable Exception beforeCancelException);
 * the Apache License, Version 2.0 (the "License"); you may
    }
        } catch (InterruptedException | ThreadInterruptedException e) {
 */
    /**
        if (ioException != null) {
    /**
 * under the License.
        cancelled = true;
            // we can only reach here if assertions are disabled. If we reach this code and cancelled is false, this means that we've
        this.reason = reason;
 * specific language governing permissions and limitations
         *
    /**
     * @opensearch.internal
     */
        if (runtimeException != null) {
        // restore old flag and see if we need to fail
            throw new RuntimeException("unexpected IO exception", e);
            final RuntimeException cancelExp = new ExecutionCancelledException("operation was cancelled reason [" + reason + "]");
         * @see #checkForCancel()
import org.opensearch.common.annotation.PublicApi;
            ioException = e;
                reason = this.reason;
            if (onCancel != null) {
        }
import org.opensearch.common.SetOnce;
     */
import org.opensearch.common.Nullable;
        }
    /**
     * @opensearch.api
            Thread.currentThread().interrupt();
        checkForCancel(ioException != null ? ioException : runtimeException);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (beforeCancelException != null) {
 * executed via {@link #execute(Interruptible)}, which will capture the executing thread and make sure it is interrupted in the case
            // clear the flag interrupted flag as we are checking for failure..
        }
}
            Thread.interrupted();
     * @param interruptible code to run
 */
 * You may obtain a copy of the License at
            return;
            }
     * causing the call to prematurely return.
     * Registers a callback that will be invoked when some running operations are cancelled or {@link #checkForCancel()} is called.
            assert cancelled : "Interruption via Thread#interrupt() is unsupported. Use CancellableThreads#cancel() instead";
    public interface IOInterruptible {
    @PublicApi(since = "1.0.0")
     * Interruptible interface
        } catch (IOException e) {
