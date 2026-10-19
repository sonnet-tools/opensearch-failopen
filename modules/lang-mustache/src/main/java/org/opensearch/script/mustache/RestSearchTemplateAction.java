import org.opensearch.rest.RestRequest;
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashSet;  
 * software distributed under the License is distributed on an
        return "search_template_action";
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParser;
        }  
            searchTemplateRequest = SearchTemplateRequest.fromXContent(parser);
            null,  
        }
    public List<Route> routes() {
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.action.RestStatusToXContentListener;
        return channel -> client.execute(SearchTemplateAction.INSTANCE, searchTemplateRequest, new RestStatusToXContentListener<>(channel));
 * Licensed to Elasticsearch under one or more contributor  
public class RestSearchTemplateAction extends BaseRestHandler {  
import java.util.Collections;
import org.opensearch.rest.BaseRestHandler;  
        return RESPONSE_PARAMS;
    }
 * GitHub history for details.
    protected Set<String> responseParams() {  
import java.util.Set;
import java.io.IOException;  
 * license agreements. See the NOTICE file distributed with
            searchRequest,
            asList(  
 * the Apache License, Version 2.0 (the "License"); you may
        );  
 * specific language governing permissions and limitations
        try (XContentParser parser = request.contentOrSourceParamParser()) {
        final Set<String> responseParams = new HashSet<>(Arrays.asList(TYPED_KEYS_PARAM, RestSearchAction.TOTAL_HITS_AS_INT_PARAM));
import java.util.Arrays;
 * Unless required by applicable law or agreed to in writing,
    }  
    }  
import org.opensearch.rest.action.search.RestSearchAction;  
import static java.util.Collections.unmodifiableList;
        RestSearchAction.parseSearchRequest(  
 */
import org.opensearch.transport.client.node.NodeClient;
    public String getName() {
 *  
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
 * under the License.  
        // Set the search request pipeline
}  
                new Route(GET, "/_search/template"),
 * compatible open source license.
 * not use this file except in compliance with the License.
        // Creates the search template request
                new Route(POST, "/_search/template"),
import java.util.List;
                new Route(POST, "/{index}/_search/template")
 * this work for additional information regarding copyright
                new Route(GET, "/{index}/_search/template"),  
    @Override
        searchTemplateRequest.setRequest(searchRequest);  
    @Override  
    @Override  
            )
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.script.mustache;
        String pipeline = searchTemplateRequest.getSearchPipeline();
            searchRequest.pipeline(pipeline);
 * You may obtain a copy of the License at  
import org.opensearch.action.search.SearchRequest;
        if (pipeline != null && !pipeline.isEmpty()) {  
import static org.opensearch.rest.RestRequest.Method.POST;
import static org.opensearch.rest.RestRequest.Method.GET;  
        // Creates the search request with all required params
/*
    private static final Set<String> RESPONSE_PARAMS;
import static java.util.Arrays.asList;
 * ownership. Elasticsearch licenses this file to you under  
/*  
 *
    public static final String TYPED_KEYS_PARAM = "typed_keys";
            request,
    @Override
        SearchRequest searchRequest = new SearchRequest();
 *
/*  
 */  
        );  
    }
        return unmodifiableList(
        SearchTemplateRequest searchTemplateRequest;  
            size -> searchRequest.source().size(size)
            client.getNamedWriteableRegistry(),
    static {
