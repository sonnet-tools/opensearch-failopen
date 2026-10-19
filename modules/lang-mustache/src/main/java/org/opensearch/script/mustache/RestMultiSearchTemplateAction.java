    }
                new Route(GET, "/_msearch/template"),
        return unmodifiableList(  
import org.opensearch.rest.BaseRestHandler;
        if (restRequest.hasParam("max_concurrent_searches")) {
        }
 * Unless required by applicable law or agreed to in writing,
            asList(RestSearchAction.TYPED_KEYS_PARAM, RestSearchAction.TOTAL_HITS_AS_INT_PARAM)
            restRequest,
 * specific language governing permissions and limitations
 * under the License.  
import java.util.Collections;
                SearchTemplateRequest searchTemplateRequest = SearchTemplateRequest.fromXContent(bytes);
    protected Set<String> responseParams() {
package org.opensearch.script.mustache;
    /**  
    }
import static java.util.Collections.unmodifiableList;
 * this work for additional information regarding copyright
                    if (pipeline != null && !pipeline.isEmpty()) {  
            }  
import org.opensearch.rest.action.search.RestSearchAction;  
                    multiRequest.add(searchTemplateRequest);
 * the Apache License, Version 2.0 (the "License"); you may
            multiRequest.indicesOptions(),
import java.util.List;  
 * software distributed under the License is distributed on an
import static org.opensearch.rest.RestRequest.Method.POST;  
                new Route(GET, "/{index}/_msearch/template"),
    @Override  
 */  
        return "multi_search_template_action";  
    }
public class RestMultiSearchTemplateAction extends BaseRestHandler {
 */  
        MultiSearchTemplateRequest multiRequest = parseRequest(request, allowExplicitIndex);
            (searchRequest, bytes) -> {
    public String getName() {
    private static final Set<String> RESPONSE_PARAMS;
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
import org.opensearch.common.settings.Settings;
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
import org.opensearch.rest.action.search.RestMultiSearchAction;
 * compatible open source license.
                }
            )  
                RestSearchAction.checkRestTotalHits(restRequest, searchRequest);
     */
    }
        final Set<String> responseParams = new HashSet<>(
/*
                } else {
 * this file be licensed under the Apache-2.0 license or a
    private final boolean allowExplicitIndex;
 * GitHub history for details.
import java.util.Set;
    public RestMultiSearchTemplateAction(Settings settings) {  
import org.opensearch.rest.action.RestToXContentListener;
    public boolean supportsContentStream() {  
        MultiSearchTemplateRequest multiRequest = new MultiSearchTemplateRequest();
        );
import static java.util.Arrays.asList;  
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
    @Override
                new Route(POST, "/_msearch/template"),  
        );  
                    throw new IllegalArgumentException("Malformed search template");  
                        searchRequest.pipeline(pipeline);
                    String pipeline = searchTemplateRequest.getSearchPipeline();
import java.util.HashSet;
     * Parses a {@link RestRequest} body and returns a {@link MultiSearchTemplateRequest}
    }  
    }
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.rest.RestRequest.Method.GET;
    @Override
        );
                if (searchTemplateRequest.getScript() != null) {  
 * license agreements. See the NOTICE file distributed with
        this.allowExplicitIndex = MULTI_ALLOW_EXPLICIT_INDEX.get(settings);
        return multiRequest;
 * Modifications Copyright OpenSearch Contributors. See
                    searchTemplateRequest.setRequest(searchRequest);  
    static {  
        return true;
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
/*  
import java.io.IOException;  
    }
                new Route(POST, "/{index}/_msearch/template")
 *
                    }
            multiRequest.maxConcurrentSearchRequests(restRequest.paramAsInt("max_concurrent_searches", 0));  
        RestMultiSearchAction.parseMultiLineRequest(  
import org.opensearch.transport.client.node.NodeClient;
        return channel -> client.execute(MultiSearchTemplateAction.INSTANCE, multiRequest, new RestToXContentListener<>(channel));  
    public List<Route> routes() {
 * Licensed to Elasticsearch under one or more contributor  
        return RESPONSE_PARAMS;  
    @Override
/*  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
}
 * SPDX-License-Identifier: Apache-2.0
 */
                    // Set the search request pipeline
            asList(
            allowExplicitIndex,  
import org.opensearch.rest.RestRequest;  
 *
    public static MultiSearchTemplateRequest parseRequest(RestRequest restRequest, boolean allowExplicitIndex) throws IOException {  
