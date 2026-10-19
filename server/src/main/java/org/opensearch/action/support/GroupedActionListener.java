 * specific language governing permissions and limitations
        if (countDown.countDown()) {  
    /**
                return current;  
    private final CountDown countDown;
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * it has received N results (either successes or failures). This allows synchronous  
 *  
    }
        }  
    private final AtomicArray<T> results;  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 */
    public GroupedActionListener(ActionListener<Collection<T>> delegate, int groupSize) {  
import java.util.concurrent.atomic.AtomicReference;
            } else {  
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.opensearch.action.support;
 */  
        results = new AtomicArray<>(groupSize);
    public void onResponse(T element) {
     */
import java.util.List;  
import java.util.Collections;
    private final AtomicInteger pos = new AtomicInteger();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                delegate.onResponse(Collections.unmodifiableList(collect));
    @Override
 * tasks to be forked off in a loop with the same listener and respond to a
            failure.accumulateAndGet(e, (current, update) -> {
                delegate.onFailure(failure.get());
    private final AtomicReference<Exception> failure = new AtomicReference<>();
 * this work for additional information regarding copyright
import org.opensearch.common.util.concurrent.CountDown;
 * compatible open source license.
/**
        if (groupSize <= 0) {
                }
        }
        if (countDown.countDown()) {  
        this.delegate = delegate;  
    }
 * GitHub history for details.
 *
 * software distributed under the License is distributed on an
 */
                List<T> collect = this.results.asList();
    private final ActionListener<Collection<T>> delegate;
        results.setOnce(pos.incrementAndGet() - 1, element);
        countDown = new CountDown(groupSize);
            if (failure.get() != null) {
 * SPDX-License-Identifier: Apache-2.0
     * @param delegate the delegate listener  
 * higher level listener once all tasks responded.
            delegate.onFailure(failure.get());
 * You may obtain a copy of the License at  
import org.opensearch.common.util.concurrent.AtomicArray;  
 * @opensearch.internal
        if (failure.compareAndSet(null, e) == false) {  
                if (update != current) {  
import org.opensearch.core.action.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
            }  
    @Override  
        }
 * under the License.  
     * Creates a new listener
                // we have to avoid self-suppression!
 * Modifications Copyright OpenSearch Contributors. See  
 *  
/*
public final class GroupedActionListener<T> implements ActionListener<T> {  
 * An action listener that delegates its results to another listener once
 * KIND, either express or implied.  See the License for the
/*  
    public void onFailure(Exception e) {
            });
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
}
 *
import java.util.Collection;
                    current.addSuppressed(update);
        }
    }  
 * license agreements. See the NOTICE file distributed with
/*
            throw new IllegalArgumentException("groupSize must be greater than 0 but was " + groupSize);
     * @param groupSize the group size
