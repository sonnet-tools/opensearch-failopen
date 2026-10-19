 * KIND, either express or implied.  See the License for the
 *
 * Unless required by applicable law or agreed to in writing,
        this.context = contextSupplier;  
import org.opensearch.core.action.ActionListener;
public final class ContextPreservingActionListener<R> implements ActionListener<R> {
import org.opensearch.common.util.concurrent.ThreadContext;  
 * software distributed under the License is distributed on an
     */
        }
        try (ThreadContext.StoredContext ignore = context.get()) {
 * Restores the given {@link org.opensearch.common.util.concurrent.ThreadContext.StoredContext}  
    /**
    @Override  
    }
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 */
    private final Supplier<ThreadContext.StoredContext> context;
 * The OpenSearch Contributors require contributions made to  
/*
     * Wraps the provided action listener in a {@link ContextPreservingActionListener} that will
        try (ThreadContext.StoredContext ignore = context.get()) {  
        return new ContextPreservingActionListener<>(threadContext.newRestorableContext(true), listener);  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 *  
package org.opensearch.action.support;
        }
            delegate.onFailure(e);
 * You may obtain a copy of the License at  
    @Override
/**
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    public ContextPreservingActionListener(Supplier<ThreadContext.StoredContext> contextSupplier, ActionListener<R> delegate) {
 * once the listener is invoked
            delegate.onResponse(r);  
    }
 */
 * Modifications Copyright OpenSearch Contributors. See  
    @Override
    }
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
    }  
 */  
import java.util.function.Supplier;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 *
/*
 * Licensed to Elasticsearch under one or more contributor  
 */
    public static <R> ContextPreservingActionListener<R> wrapPreservingContext(ActionListener<R> listener, ThreadContext threadContext) {
 *
 * under the License.  
    public void onFailure(Exception e) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
        return getClass().getName() + "/" + delegate.toString();
    public String toString() {  
    public void onResponse(R r) {
 * GitHub history for details.
        this.delegate = delegate;
     * also copy the response headers when the {@link ThreadContext.StoredContext} is closed  
    private final ActionListener<R> delegate;
/*  
