 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
         * the request can't be handled by any request handler.  
         * @param channel       the response channel of this request  
import org.opensearch.core.service.ReportingService;
        void dispatchRequest(RestRequest request, RestChannel channel, ThreadContext threadContext);  
 * HTTP Transport server
 * this file be licensed under the Apache-2.0 license or a
         */  
@PublicApi(since = "1.0.0")  
         * Dispatches the {@link RestRequest} to the relevant request handler or responds to the given rest channel directly if
         * @param channel       the response channel of this request  
        default Optional<RestHandler> dispatchHandler(String uri, String rawPath, RestRequest.Method method, Map<String, String> params) {  
import org.opensearch.common.util.concurrent.ThreadContext;  
         * @param request       the request to dispatch
 *  
         * Finds the matching {@link RestHandler} that the request is going to be dispatched to, if any.
 */
import org.opensearch.common.lifecycle.LifecycleComponent;
     */
    HttpInfo info();
import org.opensearch.rest.RestChannel;  
/*  
 *
         *
         * @param uri request URI  
 * GitHub history for details.
/*
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 *  
 * software distributed under the License is distributed on an
         * request.
/**
import org.opensearch.common.annotation.PublicApi;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
 * compatible open source license.
         */
         * @param method request HTTP method
 *
         * @return matching {@link RestHandler} that the request is going to be dispatched to, {@code Optional.empty()} if none match
        /**
 * Modifications Copyright OpenSearch Contributors. See
         * @param rawPath request raw path
 * @opensearch.api
 * KIND, either express or implied.  See the License for the
         * @param threadContext the thread context
    @Override
    BoundTransportAddress boundAddress();
    String HTTP_SERVER_WORKER_THREAD_NAME_PREFIX = "http_server_worker";  
package org.opensearch.http;
import org.opensearch.rest.RestRequest;
 * the Apache License, Version 2.0 (the "License"); you may
}
import org.opensearch.rest.RestHandler;
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        /**
    }  
     * Dispatches HTTP requests.
 * license agreements. See the NOTICE file distributed with
        void dispatchBadRequest(RestChannel channel, ThreadContext threadContext, Throwable cause);
 */
         * Dispatches a bad request. For example, if a request is malformed it will be dispatched via this method with the cause of the bad  
         *
        }
import org.opensearch.core.common.transport.BoundTransportAddress;
 * You may obtain a copy of the License at  
    /**  
 * The OpenSearch Contributors require contributions made to  
/*  
            return Optional.empty();
         * @param params request parameters  
 * this work for additional information regarding copyright
         */
public interface HttpServerTransport extends LifecycleComponent, ReportingService<HttpInfo> {
 */  
 */  
         * @param cause         the cause of the bad request
        /**
         * @param threadContext the thread context
import java.util.Optional;
    interface Dispatcher {  
    HttpStats stats();
