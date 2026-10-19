 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 */  
package org.opensearch.action.support.clustermanager;
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
        Request,
    public final RequestBuilder setClusterManagerNodeTimeout(String timeout) {  
        return (RequestBuilder) this;
 * under the License.  
/*  
    }  
 * @opensearch.internal
 *
 * this file be licensed under the Apache-2.0 license or a
/*  
     */
    }  
 * Base request builder for cluster-manager node operations
    Request extends ClusterManagerNodeRequest<Request>,
 * Licensed to Elasticsearch under one or more contributor  
 */
/*
import org.opensearch.core.action.ActionResponse;
 * KIND, either express or implied.  See the License for the
 *  
 * software distributed under the License is distributed on an
     * Sets the cluster-manager node timeout in case the cluster-manager has not yet been discovered.  
     * Sets the cluster-manager node timeout in case the cluster-manager has not yet been discovered.  
    RequestBuilder extends ClusterManagerNodeOperationRequestBuilder<Request, Response, RequestBuilder>> extends ActionRequestBuilder<  
}
 * license agreements. See the NOTICE file distributed with
    }  
    protected ClusterManagerNodeOperationRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {
        return (RequestBuilder) this;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.action.ActionType;
 * this work for additional information regarding copyright
import org.opensearch.transport.client.OpenSearchClient;
    @SuppressWarnings("unchecked")
    public final RequestBuilder setClusterManagerNodeTimeout(TimeValue timeout) {  
    /**
 */  
    @SuppressWarnings("unchecked")
 *  
        request.clusterManagerNodeTimeout(timeout);
        super(client, action, request);
        Response> {
 */
    /**
 * compatible open source license.
        request.clusterManagerNodeTimeout(timeout);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.ActionRequestBuilder;
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
     */
 *
 * Unless required by applicable law or agreed to in writing,
    Response extends ActionResponse,
/**
public abstract class ClusterManagerNodeOperationRequestBuilder<  
 * not use this file except in compliance with the License.
