        request.indicesOptions(indicesOptions);
        Request,
import org.opensearch.action.support.IndicesOptions;
 * this work for additional information regarding copyright
        return (Builder) this;  
 * software distributed under the License is distributed on an
import org.opensearch.transport.client.OpenSearchClient;
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
public abstract class ClusterInfoRequestBuilder<  
    @SuppressWarnings("unchecked")  
 * under the License.  
    public Builder setIndicesOptions(IndicesOptions indicesOptions) {
    @SuppressWarnings("unchecked")  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
    public Builder setIndices(String... indices) {
    Response extends ActionResponse,
    @SuppressWarnings("unchecked")  
 * GitHub history for details.
    protected ClusterInfoRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {
}
        request.indices(ArrayUtils.concat(request.indices(), indices));
 */
        super(client, action, request);  
        return (Builder) this;  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
/**
 * KIND, either express or implied.  See the License for the
 */  
import org.opensearch.action.ActionType;  
 * Transport request builder for cluster information
 *
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.support.clustermanager.info;
        Response,
 *
 * ownership. Elasticsearch licenses this file to you under  
        return (Builder) this;  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
/*
import org.opensearch.core.action.ActionResponse;
        request.indices(indices);
    }
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    Request extends ClusterInfoRequest<Request>,
/*  
 * compatible open source license.
    Builder extends ClusterInfoRequestBuilder<Request, Response, Builder>> extends ClusterManagerNodeReadOperationRequestBuilder<  
    }
/*
 * You may obtain a copy of the License at  
        Builder> {  
    }
    public Builder addIndices(String... indices) {
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;
 */
 * specific language governing permissions and limitations
import org.opensearch.common.util.ArrayUtils;  
 *  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
