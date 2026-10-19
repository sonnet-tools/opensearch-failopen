}
 */
 * SPDX-License-Identifier: Apache-2.0
 */  
        return (RequestBuilder) this;
    @SuppressWarnings("unchecked")
/*  
        Request,
     */
        request.timeout(timeout);
 *  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * Request builder for a shard operation
 * software distributed under the License is distributed on an
import org.opensearch.action.ActionType;
    @SuppressWarnings("unchecked")
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.  
 */  
    Request extends InstanceShardOperationRequest<Request>,
    protected InstanceShardOperationRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {
    Response extends ActionResponse,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
        return (RequestBuilder) this;
/**
        Response> {
    }  
    public final RequestBuilder setIndex(String index) {  
    /**
 * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.  
    }  
 */
    }  
 * this work for additional information regarding copyright
    RequestBuilder extends InstanceShardOperationRequestBuilder<Request, Response, RequestBuilder>> extends ActionRequestBuilder<  
public abstract class InstanceShardOperationRequestBuilder<  
package org.opensearch.action.support.single.instance;
 * this file be licensed under the Apache-2.0 license or a
    public final RequestBuilder setTimeout(String timeout) {  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 *
        request.timeout(timeout);
 *  
 *
import org.opensearch.action.ActionRequestBuilder;
        super(client, action, request);
import org.opensearch.common.unit.TimeValue;  
    /**
 * Unless required by applicable law or agreed to in writing,
    public final RequestBuilder setTimeout(TimeValue timeout) {  
/*  
    }  
import org.opensearch.core.action.ActionResponse;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return (RequestBuilder) this;
    @SuppressWarnings("unchecked")
import org.opensearch.transport.client.OpenSearchClient;
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
        request.index(index);
     */
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
