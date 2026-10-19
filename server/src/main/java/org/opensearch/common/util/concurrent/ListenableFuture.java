 * GitHub history for details.
import org.opensearch.common.collect.Tuple;  
 * Modifications Copyright OpenSearch Contributors. See
 * notification. This is useful for cases where a computation is requested many times
            listener.onFailure(e);
    public void onResponse(V v) {
                    if (threadContext == null) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * has been performed the registered listeners will be notified by submitting a runnable  
            final boolean run;
    }
}  
            throw new IllegalStateException("did not set value, value or exception already set?");
 *
            // to the list under lock
        listeners.forEach(t -> notifyListener(t.v1(), t.v2()));  
                    // or another thread like the scheduler, which we should never block!  
 * A future implementation that allows for the result to be passed to listeners waiting for  
                protected void doRun() {
import org.opensearch.core.action.ActionListener;
                    V value = FutureUtils.get(ListenableFuture.this, 0L, TimeUnit.NANOSECONDS);
    private void notifyListener(ActionListener<V> listener, ExecutorService executorService) {  
 * license agreements. See the NOTICE file distributed with
        final boolean set = setException(e);
 */  
import java.util.concurrent.TimeUnit;  
                } else {
                // run the callback directly, we don't hold the lock and don't need to fork!  
        } catch (Exception e) {
     * If the future has completed, the listener will be notified immediately without forking to  
    public void addListener(ActionListener<V> listener, ExecutorService executor) {  
package org.opensearch.common.util.concurrent;
    }  
        addListener(listener, executor, null);
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * under the License.  
public final class ListenableFuture<V> extends BaseFuture<V> implements ActionListener<V> {
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
     * Adds a listener to this future. If the future has not yet completed, the listener will be
        try {
    protected synchronized void done(boolean ignored) {
        listeners.clear();  
    public void addListener(ActionListener<V> listener, ExecutorService executor, ThreadContext threadContext) {  
/*  
    }
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
            // check done under lock since it could have been modified and protect modifications  
                    run = false;
    public void onFailure(Exception e) {  
     * Adds a listener to this future. If the future has not yet completed, the listener will be
                notifyListener(listener, OpenSearchExecutors.newDirectExecutorService());
 * the Apache License, Version 2.0 (the "License"); you may
            synchronized (this) {
        final boolean set = set(v);
     * a different thread.
                if (done) {  
 * @opensearch.internal
    @Override
            }  
                @Override
                public String toString() {  
        if (done) {
            notifyListener(listener, OpenSearchExecutors.newDirectExecutorService());  
                    run = true;
                    } else {  
     */
        }  
 * You may obtain a copy of the License at  
/*
                    final ActionListener<V> wrappedListener;  
 * The OpenSearch Contributors require contributions made to  
                    listener.onResponse(value);
        done = true;
import java.util.List;
            // run the callback directly, we don't hold the lock and don't need to fork!
 */  
        // much longer than the listeners in most cases
            if (run) {
                        wrappedListener = ContextPreservingActionListener.wrapPreservingContext(listener, threadContext);
    private final List<Tuple<ActionListener<V>, ExecutorService>> listeners = new ArrayList<>();
 *
 */
            });  
 * been performed, a request to add a listener will simply result in execution of the listener
     * If the future has completed, the listener will be notified immediately without forking to
        }
     * It will apply the provided ThreadContext (if not null) when executing the listening.
    /**
    @Override  
                }
    @Override  
 * on the calling thread.  
import org.opensearch.action.support.ContextPreservingActionListener;
import org.opensearch.action.ActionRunnable;
        if (set == false) {  
                        wrappedListener = listener;
    }
    }
 */  
     * notified of a response or exception in a runnable submitted to the ExecutorService provided.  
import java.util.ArrayList;  
    /**  
     * a different thread.
     * notified of a response or exception in a runnable submitted to the ExecutorService provided.
        if (set == false) {
        } else {
                    listeners.add(new Tuple<>(wrappedListener, executor));  
    }
                    // call get in a non-blocking fashion as we could be on a network thread
 *  
        }
                }
    private volatile boolean done = false;  
                }  
                    }
        // release references to any listeners as we no longer need them and will live
 * this file be licensed under the Apache-2.0 license or a
                @Override  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    return "ListenableFuture notification";
     */
 * for execution in the provided {@link ExecutorService}. If the computation has already
        }  
 * Unless required by applicable law or agreed to in writing,
/**
            executorService.execute(new ActionRunnable<V>(listener) {
import java.util.concurrent.ExecutorService;
 * ownership. Elasticsearch licenses this file to you under  
            throw new IllegalStateException("did not set exception, value already set or exception already set?");  
/*  
     * <p>  
 * concurrently, but really only needs to be performed a single time. Once the computation
            }
 * compatible open source license.
