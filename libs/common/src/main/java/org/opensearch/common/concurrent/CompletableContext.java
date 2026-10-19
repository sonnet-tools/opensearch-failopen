 * ownership. Elasticsearch licenses this file to you under  
    }
        removableListeners.add(listener);  
     * @param listener listener to add
            listener.accept(null, (Exception) t);
 * You may obtain a copy of the License at  
        if (completableFuture.isDone()) {
 * The OpenSearch Contributors require contributions made to  
            final Throwable t = completableFuture.exceptionNow();  
 * this file be licensed under the Apache-2.0 license or a
        if (completableFuture.isCompletedExceptionally()) {
    }  
        } else {  
     *  
     */
    }
 * specific language governing permissions and limitations
        return completableFuture.completeExceptionally(ex);  
 * this work for additional information regarding copyright
     * being attached to the underlying {@link CompletableFuture}, whose callbacks cannot be detached. A listener
    public void addRemovableListener(BiConsumer<T, ? super Exception> listener) {
    }
 *
     * does. The listeners are held in a set, so adding the same listener instance more than once holds it once.  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        }
        // while this context is completing is notified exactly once, or not at all once it has been removed  
    private final Set<BiConsumer<T, ? super Exception>> removableListeners = ConcurrentHashMap.newKeySet();  
     * is not completed yet. Unlike {@link #addListener(BiConsumer)}, the listener is held as it is given instead of  
                listener.accept(v, null);  
    }
/*
     */
        // picked up here, one that lands before it is picked up by the sweep, and remove() decides which of the  
        return completableFuture.isDone();
     * Removes a listener added with {@link #addRemovableListener(BiConsumer)} that has not been notified yet.
        return completableFuture.complete(value);
            notifyRemovableListener(listener);
            } else {
 */
        // whoever takes the listener out of the set owns notifying it, so a listener that is added or removed
import java.util.concurrent.CompletableFuture;
     */  
    public CompletableContext() {
    public boolean isCompletedExceptionally() {
    private final CompletableFuture<T> completableFuture = new CompletableFuture<>();
    }
import java.util.function.BiConsumer;
     * Removing a listener that was never added, or that has already been notified, does nothing.
     * Number of removable listeners that are waiting to be notified. Only meant for tests.
/*  
        }  
     * @param listener listener to remove
    /**
 */  
        for (BiConsumer<T, ? super Exception> listener : removableListeners) {
     * Adds a listener that can be removed again with {@link #removeRemovableListener(BiConsumer)} while this context
 * KIND, either express or implied.  See the License for the
    public boolean completeExceptionally(Exception ex) {
        // only reached once the future is done, so resultNow / exceptionNow do not throw
 * license agreements. See the NOTICE file distributed with
}
    int removableListenersSize() {  
        removableListeners.remove(listener);
            }
        BiConsumer<T, Throwable> castThrowable = (v, t) -> {
    /**
import java.util.concurrent.ConcurrentHashMap;  
     *
 * software distributed under the License is distributed on an
    }
 * Unless required by applicable law or agreed to in writing,
                assert !(t instanceof Error) : "Cannot be error";
            return;
    public boolean complete(T value) {  
        };
import java.util.Set;
 * A thread-safe completable context that allows listeners to be attached. This class relies on the
 */
        completableFuture.whenComplete(castThrowable);  
            listener.accept(completableFuture.resultNow(), null);
 * @opensearch.api
 *  
 * under the License.  
     *  
 * an exceptional result. This allows attaching listeners that only handle {@link Exception}.  
        if (removableListeners.remove(listener) == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (t == null) {
    private void notifyRemovableListener(BiConsumer<T, ? super Exception> listener) {
/*  
/**  
    }  
 * not use this file except in compliance with the License.
        completableFuture.whenComplete((v, t) -> notifyRemovableListeners());  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        }  
 *
                listener.accept(v, (Exception) t);  
    public void removeRemovableListener(BiConsumer<T, ? super Exception> listener) {  
 *  
     * added after this context has completed is notified by the calling thread, as {@link #addListener(BiConsumer)}
public class CompletableContext<T> {  
package org.opensearch.common.concurrent;
        return completableFuture.isCompletedExceptionally();
 * Modifications Copyright OpenSearch Contributors. See
    private void notifyRemovableListeners() {
 * GitHub history for details.
 * @param <T> the result type
    }
        // because the sweep runs once and does not see it.
    public boolean isDone() {  
        return removableListeners.size();
            assert !(t instanceof Error) : "Cannot be error";
        // two notifies it. Checking first and adding only if not done would strand a listener added in between,
 *
 */  
    public void addListener(BiConsumer<T, ? super Exception> listener) {  
            notifyRemovableListener(listener);  
    }
        // added before the check on purpose: a listener that lands after the completion sweep has passed is
     * @return number of listeners
    /**  
 * {@link CompletableFuture} for the concurrency logic. However, it does not accept {@link Throwable} as
 * compatible open source license.
