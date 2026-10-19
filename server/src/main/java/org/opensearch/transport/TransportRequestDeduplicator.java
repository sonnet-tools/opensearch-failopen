    }
     * the deduplicator's internal state. If the request is already known to the deduplicator it will keep  
import java.util.List;
        private void onCompleted(Exception failure) {
    /**
 * this file be licensed under the Apache-2.0 license or a
                    listeners.add(listener);
 * not be sent in parallel.
 */  
        public void onFailure(Exception failure) {  
 * this work for additional information regarding copyright
    public void clear() {
        requests.clear();  
 * under the License.  
            }  
    }  
        CompositeListener addListener(ActionListener<Void> listener) {
                requests.remove(request);
        private final List<ActionListener<Void>> listeners = new ArrayList<>();  
        }
 *  
 * Deduplicator for {@link TransportRequest}s that keeps track of {@link TransportRequest}s that should
 */
 */  
     * @param request Request to deduplicate
 * @opensearch.internal
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
/*
            onCompleted(null);
        @Override
            if (failure != null) {  
    }
                    ActionListener.onFailure(listeners, failure);
     */
 * specific language governing permissions and limitations
     * that must be completed by the caller when the request completes. Once that listener is completed the request will be removed from
            } finally {
                listener.onFailure(failure);
            } else {
 * @param <T> Transport Request Class  
 * the Apache License, Version 2.0 (the "License"); you may
            this.request = request;
                listener.onResponse(null);  
        }
     * @param callback Callback to be invoked with request and completion listener the first time the request is added to the deduplicator
            synchronized (this) {  
     * track of the given listener and invoke it when the listener passed to the callback on first invocation is completed.
                if (failure == null) {
        private final T request;
 * The OpenSearch Contributors require contributions made to  
            try {
        if (completionListener != null) {
 * license agreements. See the NOTICE file distributed with
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
            synchronized (this) {  
        public void onResponse(final Void aVoid) {
 * SPDX-License-Identifier: Apache-2.0
    public void executeOnce(T request, ActionListener<Void> listener, BiConsumer<T, ActionListener<Void>> callback) {  
        }  
            onCompleted(failure);
import java.util.ArrayList;
        CompositeListener(T request) {
 * compatible open source license.
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        private Exception failure;
 *
package org.opensearch.transport;
/**  
            }
     * an actual request execution. Use this e.g. for requests to cluster-manager that need to be sent again on cluster-manager failover.  
import java.util.function.BiConsumer;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
            }  
/*  
    }
 * GitHub history for details.
                } else {
            callback.accept(request, completionListener);  
    /**
    private final class CompositeListener implements ActionListener<Void> {
        }  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.action.ActionListener;
                this.failure = failure;
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
     * Ensures a given request not executed multiple times when another equal request is already in-flight.  
    private final ConcurrentMap<T, CompositeListener> requests = ConcurrentCollections.newConcurrentMap();  
import java.util.concurrent.ConcurrentMap;  
            }
 * not use this file except in compliance with the License.
     * Remove all tracked requests from this instance so that the first time {@link #executeOnce} is invoked with any request it triggers
        return requests.size();
                    ActionListener.onResponse(listeners, null);  
        ActionListener<Void> completionListener = requests.computeIfAbsent(request, CompositeListener::new).addListener(listener);
                this.isNotified = true;
     */
    public int size() {  
     * If the request is not yet known to the deduplicator it will invoke the passed callback with an {@link ActionListener}
 *
                }  
     * @param listener Listener to invoke on request completion  
        private boolean isNotified;
 *
        }  
        @Override  
public final class TransportRequestDeduplicator<T extends TransportRequest> {
                if (this.isNotified == false) {
 * software distributed under the License is distributed on an
 */  
            return null;
                    return listeners.size() == 1 ? this : null;  
        }
 * ownership. Elasticsearch licenses this file to you under  
/*  
