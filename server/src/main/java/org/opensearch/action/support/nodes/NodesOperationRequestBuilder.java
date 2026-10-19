    public final RequestBuilder setTimeout(TimeValue timeout) {
 *
import org.opensearch.action.ActionRequestBuilder;
 */
 * KIND, either express or implied.  See the License for the
}  
 * SPDX-License-Identifier: Apache-2.0
 */  
/*  
    Request extends BaseNodesRequest<Request>,  
 * Modifications Copyright OpenSearch Contributors. See
    }
public abstract class NodesOperationRequestBuilder<
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        Response> {
 * specific language governing permissions and limitations
        return (RequestBuilder) this;
    public final RequestBuilder setTimeout(String timeout) {
 * under the License.  
    RequestBuilder extends NodesOperationRequestBuilder<Request, Response, RequestBuilder>> extends ActionRequestBuilder<
        return (RequestBuilder) this;
    public final RequestBuilder setNodesIds(String... nodesIds) {
import org.opensearch.transport.client.OpenSearchClient;
        return (RequestBuilder) this;
/*
 * Unless required by applicable law or agreed to in writing,
    @SuppressWarnings("unchecked")
 * Builder for Operation Requests
 * @opensearch.internal  
 * ownership. Elasticsearch licenses this file to you under  
        super(client, action, request);
 *
 */  
/*  
        Request,  
 * GitHub history for details.
import org.opensearch.action.ActionType;
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
        request.timeout(timeout);  
    }
        request.timeout(timeout);  
import org.opensearch.common.unit.TimeValue;  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected NodesOperationRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {  
 * compatible open source license.
        request.nodesIds(nodesIds);  
/**  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 *
    }
    }
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    Response extends BaseNodesResponse,
 * not use this file except in compliance with the License.
package org.opensearch.action.support.nodes;
