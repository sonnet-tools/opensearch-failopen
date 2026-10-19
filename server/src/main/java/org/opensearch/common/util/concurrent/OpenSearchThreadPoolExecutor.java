        XRejectedExecutionHandler handler,
 * license agreements. See the NOTICE file distributed with
            if (listener != null) {
        return b.toString();
            corePoolSize,  
 * this file be licensed under the Apache-2.0 license or a
            + "] is being returned to the pool after executing ["
        return contextHolder.unwrap(runnable);
    }  
import java.util.concurrent.TimeUnit;
 */
     * @opensearch.internal  
    protected Runnable unwrap(Runnable runnable) {  
        return true;
    }
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
            + "]";  
 * GitHub history for details.
    ) {  
        );
    }
            b.append("queue capacity = ").append(queue.capacity()).append(", ");
     * Listener on shut down
    protected synchronized void terminated() {
            if (command instanceof AbstractRunnable) {  
    public Stream<Runnable> getTasks() {
 *  
 * An extension to thread pool executor, allowing (in the future) to add specific additional stats to it.
 * KIND, either express or implied.  See the License for the
     */
    final String getName() {
     * Name used in error reporting.
            name,
            + Thread.currentThread().getName()  
    ) {
        assert assertDefaultContext(r);
    private final String name;  
import org.opensearch.common.SuppressForbidden;
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    OpenSearchThreadPoolExecutor(  
    protected void afterExecute(Runnable r, Throwable t) {
 * SPDX-License-Identifier: Apache-2.0
    /**
    }
 * ownership. Elasticsearch licenses this file to you under  
    public interface ShutdownListener {
    @SuppressForbidden(reason = "properly rethrowing errors, see OpenSearchExecutors.rethrowErrors")
        }  
        this.contextHolder = contextHolder;
            SizeBlockingQueue queue = (SizeBlockingQueue) getQueue();
        b.append(super.toString()).append(']');  
    }
    @Override  
    }
    /**  
                // If we are an abstract runnable we can handle the rejection
     * ThreadPools that do support this metric should override this method. For example, {@link QueueResizingOpenSearchThreadPoolExecutor}
     * Append details about this thread pool to the specified {@link StringBuilder}. All details should be appended as key/value pairs in
/*
        int corePoolSize,
     * then this should return -1 which will prevent the value from showing up in {@link org.opensearch.threadpool.ThreadPoolStats}.  
        b.append(getClass().getSimpleName()).append('[');  
 */  
        return -1;  
        super.afterExecute(r, t);
     *
    }
    protected void appendThreadPoolExecutorDetails(final StringBuilder sb) {
    public void execute(Runnable command) {
        } catch (OpenSearchRejectedExecutionException ex) {
/*  
    private boolean assertDefaultContext(Runnable r) {
/**
            unit,  
    }  
import java.util.concurrent.ThreadPoolExecutor;  
                    ((AbstractRunnable) command).onAfter();  
    public long getPoolWaitTimeNanos() {
            + r
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
 * this work for additional information regarding copyright
        this.name = name;  
 * the Apache License, Version 2.0 (the "License"); you may
    private final ThreadContext contextHolder;
import java.util.concurrent.BlockingQueue;
 * Unless required by applicable law or agreed to in writing,
 *
                } finally {
     * {@link Runnable} instances rather than potentially wrapped ones.  
        }  
                }
        int maximumPoolSize,  
     * does so using the {@link TimedRunnable} to get the difference between Runnable creation and execution.
            }
                } finally {
    }
                    ((AbstractRunnable) command).onRejection(ex);
 * You may obtain a copy of the License at  
        synchronized (monitor) {
                // directly and don't need to rethrow it.
        long keepAliveTime,
/*  
        TimeUnit unit,
 * under the License.  
            super.execute(command);
            maximumPoolSize,
     * the form "%s = %s, "  
    /**
        return name;  
        command = wrapRunnable(command);
        StringBuilder b = new StringBuilder();
    }
        assert contextHolder.isDefaultContext() : "the thread context is not the default context and the thread ["
                }
 *  
public class OpenSearchThreadPoolExecutor extends ThreadPoolExecutor {  
            threadFactory,
    protected Runnable wrapRunnable(Runnable command) {
 * @opensearch.internal
        super.terminated();  
 */  
     */
            contextHolder
    }
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (getQueue() instanceof SizeBlockingQueue) {
        String name,
        TimeUnit unit,
        ThreadContext contextHolder  
        return this.getQueue().stream().map(this::unwrap);  
                try {  
     */
        void onTerminated();  
     *
     */
            new OpenSearchAbortPolicy(),  
        BlockingQueue<Runnable> workQueue,  
 * Modifications Copyright OpenSearch Contributors. See
                throw ex;
        String name,
        OpenSearchExecutors.rethrowErrors(unwrap(r));  
    /**
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                try {  
     * @param sb the {@link StringBuilder} to append to
import java.util.stream.Stream;
    OpenSearchThreadPoolExecutor(  
        ThreadFactory threadFactory,
                    listener.onTerminated();
        this(
         * ThreadPoolExecutor has some nice information in its toString but we  
            } else {  
 */
        int corePoolSize,
}
package org.opensearch.common.util.concurrent;
 * not use this file except in compliance with the License.
        ThreadFactory threadFactory,
        long keepAliveTime,
            }
        try {  
     * Returns a stream of all pending tasks. This is similar to {@link #getQueue()} but will expose the originally submitted
    @Override  
 * The OpenSearch Contributors require contributions made to  
    }
    @Override
        b.append("name = ").append(name).append(", ");
                    listener = null;  
    public final String toString() {
     * Returns the cumulative wait time of the ThreadPool. If the ThreadPool does not support tracking the cumulative pool wait time
        /*
import java.util.concurrent.ThreadFactory;
        BlockingQueue<Runnable> workQueue,  
 *
    private final Object monitor = new Object();
        return contextHolder.preserveContext(command);  
            workQueue,
         */
     */  
    }
        ThreadContext contextHolder
         * can't get at it easily without just getting the toString.
    private volatile ShutdownListener listener;  
            keepAliveTime,
 * compatible open source license.
    @Override  
        }  
        appendThreadPoolExecutorDetails(b);
 * Licensed to Elasticsearch under one or more contributor  
    /**  
            @SuppressWarnings("rawtypes")  
        int maximumPoolSize,  
