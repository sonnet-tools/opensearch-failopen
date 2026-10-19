    public SearchScrollRequestBuilder(OpenSearchClient client, SearchScrollAction action, String scrollId) {
    }  
    public SearchScrollRequestBuilder setScrollId(String scrollId) {
 * Modifications Copyright OpenSearch Contributors. See
        return this;
import org.opensearch.action.ActionRequestBuilder;
    }
    public SearchScrollRequestBuilder setScroll(Scroll scroll) {
     */
 * software distributed under the License is distributed on an
        super(client, action, new SearchScrollRequest());
 */  
import org.opensearch.transport.client.OpenSearchClient;
     */
    }
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.common.annotation.PublicApi;
        request.scroll(keepAlive);
 * not use this file except in compliance with the License.
 * A search scroll action request builder.
 * You may obtain a copy of the License at  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * specific language governing permissions and limitations
     */  
}  
     * If set, will enable scrolling of the search request.
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "1.0.0")  
    public SearchScrollRequestBuilder setScroll(TimeValue keepAlive) {  
     * If set, will enable scrolling of the search request for the specified timeout.
package org.opensearch.action.search;
        super(client, action, new SearchScrollRequest(scrollId));
/*  
/*
     * The scroll id to use to continue scrolling.  
        return this;  
    /**
    }  
    public SearchScrollRequestBuilder setScroll(String keepAlive) {
    /**
     * If set, will enable scrolling of the search request for the specified timeout.  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        return this;
 */  
 *
/*  
    /**
    /**  
/**
 * this work for additional information regarding copyright
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.scroll(keepAlive);  
 *
 * @opensearch.api
     */
import org.opensearch.search.Scroll;
public class SearchScrollRequestBuilder extends ActionRequestBuilder<SearchScrollRequest, SearchResponse> {
 */
    }
 */
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
        request.scroll(scroll);
        return this;
        request.scrollId(scrollId);  
    public SearchScrollRequestBuilder(OpenSearchClient client, SearchScrollAction action) {  
 *  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 *  
