import org.opensearch.transport.client.OpenSearchClient;
 * software distributed under the License is distributed on an
 */  
 */
        return this;
     * For example indices that don't exist.  
 * under the License.  
        if (request.indicesOptions() == IndicesOptions.strictExpandOpenAndForbidClosed()
    /**  
 *  
    }
import org.opensearch.action.ActionRequestBuilder;
}
    public MultiSearchRequestBuilder add(SearchRequestBuilder request) {  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
public class MultiSearchRequestBuilder extends ActionRequestBuilder<MultiSearchRequest, MultiSearchResponse> {  
 * specific language governing permissions and limitations
     * <p>
     * <p>  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
import org.opensearch.action.support.IndicesOptions;
    public MultiSearchRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
 *
/*  
            request.request().indicesOptions(request().indicesOptions());  
/*  
     * same order as the search requests.
            request.indicesOptions(request().indicesOptions());
 * GitHub history for details.
/**  
    public MultiSearchRequestBuilder setMaxConcurrentSearchRequests(int maxConcurrentSearchRequests) {  
     * If ignoreIndices has been set on the search request, then the indicesOptions of the multi search request
     */  
    /**  
 * compatible open source license.
     * Invoke this method before invoking {@link #add(SearchRequestBuilder)}.
     * will not be used (if set).
@PublicApi(since = "1.0.0")
package org.opensearch.action.search;
    }
        if (request.request().indicesOptions() == SearchRequest.DEFAULT_INDICES_OPTIONS
        super.request.add(request);
    /**
        return this;  
     */
 *
    public MultiSearchRequestBuilder add(SearchRequest request) {
 * the Apache License, Version 2.0 (the "License"); you may
 * A request builder for multiple search requests.
    }  
        return this;
 * @opensearch.api  
            && request().indicesOptions() != IndicesOptions.strictExpandOpenAndForbidClosed()) {  
            && request().indicesOptions() != SearchRequest.DEFAULT_INDICES_OPTIONS) {
        super(client, action, new MultiSearchRequest());  
    }  
        request().maxConcurrentSearchRequests(maxConcurrentSearchRequests);
     * Add a search request to execute. Note, the order is important, the search response will be returned in the
    public MultiSearchRequestBuilder(OpenSearchClient client, MultiSearchAction action) {
     */  
    /**
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 */  
        return this;
 * Unless required by applicable law or agreed to in writing,
     * Sets how many search requests specified in this multi search requests are allowed to be ran concurrently.
     * Add a search request to execute. Note, the order is important, the search response will be returned in the  
     * Specifies what type of requested indices to ignore and how to deal with wildcard indices expressions.
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
/*
        request().indicesOptions(indicesOptions);
     */
     * same order as the search requests.
 *
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;  
 */
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
        super.request.add(request);  
    }
 * license agreements. See the NOTICE file distributed with
        }
