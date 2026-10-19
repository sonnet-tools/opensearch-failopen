 * @opensearch.internal
     * Executes a generic action, denoted by an {@link ActionType}.
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
    );  
        ActionType<Response> action,
 * ownership. Elasticsearch licenses this file to you under  
     * @param request          The action request.
}
 *
 * specific language governing permissions and limitations
     * @param <Request>        The request type.
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
     * @return A future allowing to get back the response.
public interface OpenSearchClient {
     * @param <Response>       The response type.  
        Request request
 * not use this file except in compliance with the License.
 *
     * @param listener         The listener to receive the response back.
    <Request extends ActionRequest, Response extends ActionResponse> void execute(
 * GitHub history for details.
 */
    );  
     */
    /**
 */  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
/*  
    /**  
 * Interface for an OpenSearch client implementation  
/**
 */  
     * Executes a generic action, denoted by an {@link ActionType}.  
    <Request extends ActionRequest, Response extends ActionResponse> ActionFuture<Response> execute(  
 * KIND, either express or implied.  See the License for the
     * @param action           The action type to execute.
     *
package org.opensearch.transport.client;
 * software distributed under the License is distributed on an
     * @param request          The action request.  
 * Modifications Copyright OpenSearch Contributors. See
 */  
     * @param <Response>       the response type.  
    ThreadPool threadPool();
     */
        ActionType<Response> action,  
import org.opensearch.core.action.ActionListener;
     * Returns the threadpool used to execute requests on this client  
import org.opensearch.common.action.ActionFuture;  
     * @param action           The action type to execute.  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
    /**
 *  
import org.opensearch.action.ActionType;
        Request request,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param <Request>        The request type.
/*
     */
 *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.threadpool.ThreadPool;  
 * this work for additional information regarding copyright
import org.opensearch.core.action.ActionResponse;
     *
/*  
        ActionListener<Response> listener
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.ActionRequest;
