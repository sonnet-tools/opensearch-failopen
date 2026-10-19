 */  
     */  
                chain.proceed(task, action, request, listener);
 * GitHub history for details.
        /**
    int order();
     * {@link ActionListener} or by continuing the execution through the given {@link ActionFilterChain chain}
 * You may obtain a copy of the License at  
    default <Request extends ActionRequest, Response extends ActionResponse> void apply(
 * not use this file except in compliance with the License.
        Task task,  
     */  
        throw new UnsupportedOperationException("Incomplete implementation of ActionFilter interface in " + this);  
 *     http://www.apache.org/licenses/LICENSE-2.0
    default <Request extends ActionRequest, Response extends ActionResponse> void apply(
     * The position of the filter in the chain. Execution is done from lowest order to highest.
     * to apply async filtering logic.  
 *
            if (apply(action, request, listener)) {  
     *  
}
     * {@link ActionListener} or by continuing the execution through the given {@link ActionFilterChain chain}
/*  
    /**  
        ActionFilterChain<Request, Response> chain
        String action,  
 * under the License.  
/**  
/*  
        Request request,
         * Applies this filter and returns {@code true} if the execution chain should proceed, or {@code false}  
    /**  
 *  
 * Unless required by applicable law or agreed to in writing,
    }
     * ActionRequestMetadata parameter. This method will be removed soon.
            String action,  
import org.opensearch.action.ActionRequest;
            ActionListener<Response> listener,  
 * this file be licensed under the Apache-2.0 license or a
        ActionListener<Response> listener,  
 * software distributed under the License is distributed on an
        ActionRequestMetadata<Request, Response> actionRequestMetadata,
 * ownership. Elasticsearch licenses this file to you under  
         * if it should be aborted since the filter already handled the request and called the given listener.
            ActionFilterChain<Request, Response> chain
 *
            Task task,
     * @deprecated please do not override this method any more. Instead, override the method with the additional
    /**  
     *  
import org.opensearch.core.action.ActionListener;
 * A filter allowing to filter transport actions
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String action,
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.support;
 *
     * filter chain. This base class should serve any action filter implementations that doesn't require
 * specific language governing permissions and limitations
        ActionFilterChain<Request, Response> chain
 * compatible open source license.
     */
     * Enables filtering the execution of an action on the request side, either by sending a response through the
        public final <Request extends ActionRequest, Response extends ActionResponse> void apply(
 * @opensearch.internal  
    ) {
 */  
        @Override  
    }
 */
public interface ActionFilter {
    ) {
        Task task,
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
         */
        ActionListener<Response> listener,  
import org.opensearch.core.action.ActionResponse;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.tasks.Task;
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
    @Deprecated(forRemoval = true)
     * Enables filtering the execution of an action on the request side, either by sending a response through the
        }  
    /**
     * A simple base class for injectable action filters that spares the implementation from handling the
     */  
     * Note: This has only for a transitional period a default implementation. After the deprecated apply()
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
/*
        this.apply(task, action, request, listener, chain);  
        ) {
        protected abstract boolean apply(String action, ActionRequest request, ActionListener<?> listener);  
            ActionRequestMetadata<Request, Response> actionRequestMetadata,
            Request request,
 */
            }
     * method has been removed, the default implementation will be removed.
        Request request,
    abstract class Simple implements ActionFilter {
