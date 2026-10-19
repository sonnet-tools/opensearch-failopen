    /**
    IndicesExistsResponse,
    public IndicesExistsRequestBuilder setExpandWildcardsOpen(boolean expandWildcardsOpen) {
/**
    }
     */  
/*  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;
    IndicesExistsRequest,  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  
 * compatible open source license.
@PublicApi(since = "1.0.0")
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
    /**  
     * Controls whether wildcard expressions will be expanded to existing closed indices
 * KIND, either express or implied.  See the License for the
    }
import org.opensearch.common.annotation.PublicApi;
/*
/*  
 * Licensed to Elasticsearch under one or more contributor  
    IndicesExistsRequestBuilder> {
        request.expandWilcardsOpen(expandWildcardsOpen);
        super(client, action, new IndicesExistsRequest(indices));
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.admin.indices.exists.indices;
 *
 */
 * not use this file except in compliance with the License.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this;
 * Transport request builder for checking if an index exists  
    }  
 */  
 * this work for additional information regarding copyright
    }  
    public IndicesExistsRequestBuilder(OpenSearchClient client, IndicesExistsAction action, String... indices) {
 * specific language governing permissions and limitations
}
 * ownership. Elasticsearch licenses this file to you under  
        request.indices(indices);  
     */
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
        return this;  
    public IndicesExistsRequestBuilder setExpandWildcardsClosed(boolean expandWildcardsClosed) {  
 */  
        request.expandWilcardsClosed(expandWildcardsClosed);
public class IndicesExistsRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<
 * license agreements. See the NOTICE file distributed with
        return this;
 * @opensearch.api
 */  
import org.opensearch.transport.client.OpenSearchClient;  
 * You may obtain a copy of the License at  
    public IndicesExistsRequestBuilder setIndices(String... indices) {
     * Controls whether wildcard expressions will be expanded to existing open indices
 * Modifications Copyright OpenSearch Contributors. See
