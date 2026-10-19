    public static <Response> ActionListener<Response> wrapWithTimeout(
                delegate.onResponse(response);
            listener.onFailure(new OpenSearchTimeoutException(timeoutMessage));
package org.opensearch.action.support;
    }
        TimeValue timeout,
        wrappedListener.cancellable = threadPool.schedule(wrappedListener, timeout, executor);
        private volatile Scheduler.ScheduledCancellable cancellable;  
import java.util.function.Consumer;
 * GitHub history for details.
     * @param timeout period before listener failed
     * @param listener to that can timeout
                onTimeout.accept(this);
        private final Consumer<ActionListener<Response>> onTimeout;
     * @opensearch.internal
            this.onTimeout = onTimeout;
        public void run() {  
        TimeoutableListener<Response> wrappedListener = new TimeoutableListener<>(listener, onTimeout);  
        });  
            if (isDone.compareAndSet(false, true)) {
 * this file be licensed under the Apache-2.0 license or a
 */
     * Wraps a listener with a listener that can timeout. After the timeout period the  
        String listenerName
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
    }  
    public static <Response> ActionListener<Response> wrapWithTimeout(
 *
import java.util.concurrent.atomic.AtomicBoolean;
        }
     * onTimeout Runnable will be called.
        return wrappedListener;
 * Supports timeouts on listeners
            String timeoutMessage = "[" + listenerName + "]" + " timed out after [" + timeout + "]";
     * Wraps a listener with a listener that can timeout. After the timeout period the
        ActionListener<Response> listener,
        }
     * {@link ActionListener#onFailure(Exception)} will be called with a
     * @param timeout period before listener failed  
        private final AtomicBoolean isDone = new AtomicBoolean(false);  
 *
import org.opensearch.threadpool.Scheduler;
 * SPDX-License-Identifier: Apache-2.0
     * Listener that can time out  
     */
            if (isDone.compareAndSet(false, true)) {  
/*  
    /**
 *  
    }
        Consumer<ActionListener<Response>> onTimeout
     * @param threadPool used to schedule the timeout
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
        String executor,  
     * @param listener to that can timeout
     * @param listenerName name of the listener for timeout exception
     * @return the wrapped listener that will timeout  
 * under the License.  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
import org.opensearch.OpenSearchTimeoutException;
 * not use this file except in compliance with the License.
        return wrapWithTimeout(threadPool, timeout, executor, listener, (ignore) -> {  
 *     http://www.apache.org/licenses/LICENSE-2.0
    ) {
     */
import org.opensearch.core.action.ActionListener;  
     * @return the wrapped listener that will timeout  
    /**
     *  
public class ListenerTimeouts {  
     */  
     * @param executor to use for scheduling timeout
 * The OpenSearch Contributors require contributions made to  
        public void onFailure(Exception e) {
 */  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.unit.TimeValue;
        }
                cancellable.cancel();  
}  
        TimeValue timeout,
     * @param onTimeout consumer will be called and the resulting wrapper will be passed to it as a parameter
 * @opensearch.internal
     *
    ) {
            }  
 * specific language governing permissions and limitations
     * @param executor to use for scheduling timeout  
        String executor,
        @Override
        @Override  
            if (isDone.compareAndSet(false, true)) {
            }  
            this.delegate = delegate;  
 * You may obtain a copy of the License at  
 *  
 */
/*
     * {@link OpenSearchTimeoutException} if the listener has not already been completed.
        private TimeoutableListener(ActionListener<Response> delegate, Consumer<ActionListener<Response>> onTimeout) {
        ThreadPool threadPool,  
        ActionListener<Response> listener,  
     *  
 * this work for additional information regarding copyright
     * @param threadPool used to schedule the timeout
        }  
                delegate.onFailure(e);
 * ownership. Elasticsearch licenses this file to you under  
    private static class TimeoutableListener<Response> implements ActionListener<Response>, Runnable {
        @Override
        private final ActionListener<Response> delegate;
 * Licensed to Elasticsearch under one or more contributor  
/**
            }
import org.opensearch.threadpool.ThreadPool;
        ThreadPool threadPool,  
                cancellable.cancel();
 * software distributed under the License is distributed on an
 */  
    /**  
        public void onResponse(Response response) {
/*  
