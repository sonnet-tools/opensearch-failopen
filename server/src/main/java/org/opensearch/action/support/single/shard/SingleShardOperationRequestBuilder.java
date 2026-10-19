 *
 */
        Request,  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
    public final RequestBuilder setIndex(String index) {
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
import org.opensearch.action.ActionRequestBuilder;
 * GitHub history for details.
/**  
import org.opensearch.action.ActionType;
/*  
    Response extends ActionResponse,
/*
 * SPDX-License-Identifier: Apache-2.0
 */  
        return (RequestBuilder) this;
 * not use this file except in compliance with the License.
 * @opensearch.internal  
 *
 * ownership. Elasticsearch licenses this file to you under  
    protected SingleShardOperationRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {  
package org.opensearch.action.support.single.shard;
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    }
 */
    @SuppressWarnings("unchecked")
 * this work for additional information regarding copyright
 *
 * specific language governing permissions and limitations
    RequestBuilder extends SingleShardOperationRequestBuilder<Request, Response, RequestBuilder>> extends ActionRequestBuilder<
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
    Request extends SingleShardRequest<Request>,  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.transport.client.OpenSearchClient;
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.index(index);  
    /**
        super(client, action, request);
 */  
public abstract class SingleShardOperationRequestBuilder<
import org.opensearch.core.action.ActionResponse;  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
     */  
 * this file be licensed under the Apache-2.0 license or a
}  
    }
 * Request builder for a single shard operation request
        Response> {
     * Sets the index.
/*  
