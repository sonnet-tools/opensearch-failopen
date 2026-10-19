 * not use this file except in compliance with the License.
    @SuppressWarnings("unchecked")  
public abstract class AcknowledgedRequestBuilder<  
        RequestBuilder> {  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.support.clustermanager;
 *
 */
        return (RequestBuilder) this;
 */
        Request,
    @SuppressWarnings("unchecked")
    Request extends AcknowledgedRequest<Request>,
    protected AcknowledgedRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {
import org.opensearch.common.unit.TimeValue;
 */
    public RequestBuilder setTimeout(String timeout) {
import org.opensearch.transport.client.OpenSearchClient;
 * ownership. Elasticsearch licenses this file to you under  
        return (RequestBuilder) this;  
 * this file be licensed under the Apache-2.0 license or a
        super(client, action, request);  
 *  
/*  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        request.timeout(timeout);
}  
     * Sets the maximum wait for acknowledgement from other nodes
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * Modifications Copyright OpenSearch Contributors. See  
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Base request builder for cluster-manager node operations that support acknowledgements
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
        Response,
    }
     * Timeout to wait for the operation to be acknowledged by current cluster nodes. Defaults
    Response extends AcknowledgedResponse,
 */  
 * GitHub history for details.
     */
     * to {@code 10s}.
 * software distributed under the License is distributed on an
/*
 * this work for additional information regarding copyright
 * under the License.  
 * @opensearch.internal
/*
import org.opensearch.action.ActionType;  
 *
    public RequestBuilder setTimeout(TimeValue timeout) {
    /**  
     */  
        request.timeout(timeout);  
    }
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    }
/**
    RequestBuilder extends AcknowledgedRequestBuilder<Request, Response, RequestBuilder>> extends ClusterManagerNodeOperationRequestBuilder<  
 * SPDX-License-Identifier: Apache-2.0
