 * this file be licensed under the Apache-2.0 license or a
 *  
    @SuppressWarnings("unchecked")
 * not use this file except in compliance with the License.
/*
    }
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        request.indicesOptions(indicesOptions);  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
    }
    protected BroadcastOperationRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
    public final RequestBuilder setIndices(String... indices) {
 * Unless required by applicable law or agreed to in writing,
        request.indices(indices);  
 * KIND, either express or implied.  See the License for the
 * Request builder for broadcast operations
 *
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.ActionType;
    @SuppressWarnings("unchecked")
 *
 * license agreements. See the NOTICE file distributed with
        Response> {
    public final RequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
    RequestBuilder extends BroadcastOperationRequestBuilder<Request, Response, RequestBuilder>> extends ActionRequestBuilder<
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
/**  
import org.opensearch.action.ActionRequestBuilder;
        return (RequestBuilder) this;
 */
    Request extends BroadcastRequest<Request>,  
 * GitHub history for details.
/*  
}  
 * software distributed under the License is distributed on an
        return (RequestBuilder) this;
public abstract class BroadcastOperationRequestBuilder<
 */
        Request,  
 */  
 * under the License.  
 */  
 * You may obtain a copy of the License at  
    Response extends BroadcastResponse,
 *
    }
import org.opensearch.transport.client.OpenSearchClient;
 * compatible open source license.
package org.opensearch.action.support.broadcast;
/*  
        super(client, action, request);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.IndicesOptions;  
