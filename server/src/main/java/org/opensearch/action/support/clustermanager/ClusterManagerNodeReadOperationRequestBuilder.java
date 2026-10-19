public abstract class ClusterManagerNodeReadOperationRequestBuilder<
/*
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 */  
    public final RequestBuilder setLocal(boolean local) {  
/*  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
    }  
 * Base request builder for cluster-manager node read operations that can be executed on the local node as well  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.transport.client.OpenSearchClient;  
        super(client, action, request);
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    }  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * You may obtain a copy of the License at  
 * @opensearch.internal
}
 */  
 * the Apache License, Version 2.0 (the "License"); you may
     */
    RequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<Request, Response, RequestBuilder>> extends
 *
 * GitHub history for details.
 */
    protected ClusterManagerNodeReadOperationRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {
/**
 * not use this file except in compliance with the License.
     * Specifies if the request should be executed on local node rather than on master  
 */  
    /**
/*  
    Response extends ActionResponse,  
        request.local(local);
import org.opensearch.core.action.ActionResponse;
 *  
        return (RequestBuilder) this;
    ClusterManagerNodeOperationRequestBuilder<Request, Response, RequestBuilder> {
 *
import org.opensearch.action.ActionType;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.support.clustermanager;
 * software distributed under the License is distributed on an
    Request extends ClusterManagerNodeReadRequest<Request>,
 * license agreements. See the NOTICE file distributed with
    @SuppressWarnings("unchecked")
