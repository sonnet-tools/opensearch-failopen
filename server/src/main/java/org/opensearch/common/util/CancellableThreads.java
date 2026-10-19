            // fallback to the default exception
        if (cancelledByExternalInterrupt) {  
        }
/*  
    private final Set<Thread> threads = new HashSet<>();
            throw new RuntimeException("Interruption via Thread#interrupt() is unsupported. Use CancellableThreads#cancel() instead");  
        if (wasInterrupted) {  
            Thread.currentThread().interrupt();
 * license agreements. See the NOTICE file distributed with
    public synchronized void setOnCancel(OnCancel onCancel) {
            Thread.currentThread().interrupt();
     */  
     * Thrown if there is an error cancelling execution
            assert false : "the passed interruptible can not result in an IOException";
            runtimeException = t;
     * IO Interruptible  
    @PublicApi(since = "1.0.0")
 * @opensearch.api  
        boolean cancelledByExternalInterrupt = false;  
         * will fail with the default exception {@link ExecutionCancelledException}.
 * executed via {@link #execute(Interruptible)}, which will capture the executing thread and make sure it is interrupted in the case
 * the Apache License, Version 2.0 (the "License"); you may
    /** cancel all current running operations. Future calls to {@link #checkForCancel()} will be failed with the given reason */  
        if (runtimeException != null) {
            // if we're not canceling, we throw the original exception  
        }  
            super(in);  
        if (cancelled) {
            Thread.interrupted();
        return cancelled;
import org.opensearch.OpenSearchException;
 * compatible open source license.
            throw new RuntimeException("unexpected IO exception", e);  
        checkForCancel(null);  
         * @see #checkForCancel()
                cancelExp.addSuppressed(beforeCancelException);
    }
 */
        try {
 * specific language governing permissions and limitations
        // we are now out of threads collection so we can't be interrupted any more by this class
    @PublicApi(since = "1.0.0")
            cancelledByExternalInterrupt = !cancelled;
            thread.interrupt();
    }  
 * this file be licensed under the Apache-2.0 license or a
     *
            return;  
        checkForCancel(ioException != null ? ioException : runtimeException);  
     */
        } catch (RuntimeException t) {  
    public synchronized void cancel(String reason) {
import java.util.HashSet;
 */  
         */
    private volatile boolean cancelled = false;
        RuntimeException runtimeException = null;
            interruptible.run();
@PublicApi(since = "1.0.0")
        }
 * You may obtain a copy of the License at  
    private void checkForCancel(Exception beforeCancelException) {  
 * A utility class for multi threaded operation that needs to be cancellable via interrupts. Every cancellable operation should be  
     *
        void run() throws InterruptedException;
            executeIO(interruptible);  
        } catch (InterruptedException | ThreadInterruptedException e) {  
     */  
/*
        // capture and clean the interrupted thread before we start, so we can identify
                onCancel.onCancel(reason, beforeCancelException);  
    private synchronized void remove() {
            }  
 * GitHub history for details.
            // if we're not canceling, we throw the original exception
            ioException = e;  
 * ownership. Elasticsearch licenses this file to you under  
        public ExecutionCancelledException(StreamInput in) throws IOException {
    }
     */  
            // ignore, this interrupt has been triggered by us in #cancel()...
    public interface OnCancel {  
 * Licensed to Elasticsearch under one or more contributor  
        }
            if (onCancel != null) {
         *
     *  
     * Registers a callback that will be invoked when some running operations are cancelled or {@link #checkForCancel()} is called.
    }
    /**
            assert cancelled : "Interruption via Thread#interrupt() is unsupported. Use CancellableThreads#cancel() instead";
import org.apache.lucene.util.ThreadInterruptedException;  
 * of cancellation.
        /**
    /**
     *
     * causing the call to prematurely return.  
package org.opensearch.common.util;
     *
            remove();
     * @opensearch.api
            // clear the flag interrupted flag as we are checking for failure..  
        }
     * @opensearch.internal  
    /**
     * @opensearch.api
        boolean wasInterrupted = add();
     *
 * Unless required by applicable law or agreed to in writing,
 */
        // our own interrupt. we do so under lock so we know we don't clear our own.  
 * KIND, either express or implied.  See the License for the
                onCancel = this.onCancel.get();  
    public interface IOInterruptible {
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamInput;
 *     http://www.apache.org/licenses/LICENSE-2.0
         * @see #setOnCancel(OnCancel)  
    /**
            final OnCancel onCancel;  
    /**
         * Called when some running operations are cancelled or {@link #checkForCancel()} is explicitly called.
    }  
    }  
    @PublicApi(since = "1.0.0")  
            if (beforeCancelException != null) {
    }  
 * under the License.  
        }
            synchronized (this) {
        void run() throws IOException, InterruptedException;  
     * @param interruptible code to run
    }
    }  
/**
     * Called when a thread is cancelled  
            // we can only reach here if assertions are disabled. If we reach this code and cancelled is false, this means that we've  
 * The OpenSearch Contributors require contributions made to  
        public ExecutionCancelledException(String msg) {
        return Thread.interrupted();
        void onCancel(String reason, @Nullable Exception beforeCancelException);
     */  
        threads.add(Thread.currentThread());
import java.util.Set;  
            // Thread.interrupted without handling it
        this.onCancel.set(onCancel);
 *  
     * run the Interruptible, capturing the executing thread. Concurrent calls to {@link #cancel(String)} will interrupt this thread
    private synchronized boolean add() {
 * <p>  
import org.opensearch.common.SetOnce;  
        }  
            }
            super(msg);
        }
 */
    @FunctionalInterface
    public void execute(Interruptible interruptible) {
        if (isCancelled()) {
/*
            // been interrupted externally (which we don't support).
        this.reason = reason;  
            throw runtimeException;
    /**
    }  
        checkForCancel();  
     * @opensearch.api
        } finally {
        IOException ioException = null;
        for (Thread thread : threads) {
public class CancellableThreads {  
        // restore old flag and see if we need to fail
            // we were already cancelled, make sure we don't interrupt threads twice  
    public void executeIO(IOInterruptible interruptible) throws IOException {
        } catch (IOException e) {
    public interface Interruptible extends IOInterruptible {
     * causing the call to prematurely return.  
    private final SetOnce<OnCancel> onCancel = new SetOnce<>();  
         * If this method throws an exception, cancelling tasks will fail with that exception; otherwise they  
        threads.remove(Thread.currentThread());  
}
        cancelled = true;
        } catch (IOException e) {
        }
            throw cancelExp;
 * this work for additional information regarding copyright
 *
        threads.clear();
     */  
    public static class ExecutionCancelledException extends OpenSearchException {
    private String reason;
            throw ioException;  
            // this is important in order to make sure that we don't mark
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
    // needs to be volatile as it is also read outside of synchronized blocks.
import org.opensearch.common.annotation.PublicApi;
 *
 *
        if (ioException != null) {
         * @param reason                the reason of the cancellation  
        }  
        }
            // restore interrupt flag to at least adhere to expected behavior
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else {
        try {
 * Cancellation policy: This class does not support external interruption via <code>Thread#interrupt()</code>. Always use #cancel() instead.
            final String reason;
     * Interruptible interface
     * @param interruptible code to run
    public void checkForCancel() {
import org.opensearch.common.Nullable;
     */
    public synchronized boolean isCancelled() {
            }
     * run the Interruptible, capturing the executing thread. Concurrent calls to {@link #cancel(String)} will interrupt this thread
 * software distributed under the License is distributed on an
                reason = this.reason;
            final RuntimeException cancelExp = new ExecutionCancelledException("operation was cancelled reason [" + reason + "]");  
    /**  
    }
         * @param beforeCancelException any error that was encountered during the execution before the operations were cancelled.
    }
 * Modifications Copyright OpenSearch Contributors. See  
    }
