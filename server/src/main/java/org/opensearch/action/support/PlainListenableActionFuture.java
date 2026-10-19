                    ((List) listeners).add(orig);
 * compatible open source license.
                } else if (listeners instanceof List) {
    protected T convert(T listenerResponse) {
 * Future for a plain listenable action
    }  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
                } else {
    }
        synchronized (this) {
 * Modifications Copyright OpenSearch Contributors. See
    /**
        }  
 */  
            } else {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                if (listeners == null) {  
    @Override  
    }  
    private void executeListener(final ActionListener<T> listener) {  
 * under the License.  
                Object listeners = this.listeners;
                    ((List) this.listeners).add(listener);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * software distributed under the License is distributed on an
            listener.onFailure(e);  
            executedListeners = true;  
 * You may obtain a copy of the License at  
import java.util.ArrayList;
    }
/*
        try {
package org.opensearch.action.support;
                for (Object listener : list) {  
        }
 * ownership. Elasticsearch licenses this file to you under  
                    ((List) listeners).add(listener);
 */
            } else {
 *  
        }
    private void internalAddListener(ActionListener<T> listener) {
/**
                executeImmediate = true;  
        Object listeners = this.listeners;
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
        return listenerResponse;
        synchronized (this) {
                    Object orig = listeners;
            }
        internalAddListener(listener);
/*  
        return new PlainListenableActionFuture<>();  
        super.done(success);
    boolean executedListeners = false;  
            // we use a timeout of 0 to by pass assertion forbidding to call actionGet() (blocking) on a network thread.
    volatile Object listeners;
 */  
 * Unless required by applicable law or agreed to in writing,
        if (executeImmediate) {
 * GitHub history for details.
    @Override
import org.opensearch.core.action.ActionListener;
 * KIND, either express or implied.  See the License for the
            if (listeners instanceof List) {
     * @return a listenable future  
     * @param <T> the result of the future
        } catch (Exception e) {
                }
        }  
 *
    public void addListener(final ActionListener<T> listener) {
            executeListener(listener);
}
        boolean executeImmediate = false;  
     */
    public static <T> PlainListenableActionFuture<T> newListenableFuture() {
     * The listeners will be executed by the same thread that completes the future.  
import org.opensearch.action.ListenableActionFuture;
    protected void done(boolean success) {  
                }  
            }
    @Override  
     * This method returns a listenable future. The listeners will be called on completion of the future.
 * Licensed to Elasticsearch under one or more contributor  
/*  
                    listeners = listener;
            if (executedListeners) {
                    executeListener((ActionListener<T>) listener);
                    listeners = new ArrayList<>(2);  
public class PlainListenableActionFuture<T> extends AdapterActionFuture<T, T> implements ListenableActionFuture<T> {  
 *  
    }
        if (listeners != null) {  
 */
            listener.onResponse(actionGet(0));
                executeListener((ActionListener<T>) listeners);
                List list = (List) listeners;
 * not use this file except in compliance with the License.
    protected PlainListenableActionFuture() {}
import java.util.List;
            // here we know we will never block  
 * specific language governing permissions and limitations
                this.listeners = listeners;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    }
     *
