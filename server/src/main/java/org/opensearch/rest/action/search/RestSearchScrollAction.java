import static org.opensearch.rest.RestRequest.Method.POST;
 * The OpenSearch Contributors require contributions made to  
 */  
 *  
import static java.util.Collections.unmodifiableList;
import org.opensearch.action.search.SearchScrollRequest;
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.rest.BaseRestHandler;
public class RestSearchScrollAction extends BaseRestHandler {  
                new Route(POST, "/_search/scroll/{scroll_id}")  
 * @opensearch.api
    protected Set<String> responseParams() {
 * KIND, either express or implied.  See the License for the
    @Override
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
    public String getName() {
            if (xContentParser != null) {
/**
    private static final Set<String> RESPONSE_PARAMS = Collections.singleton(RestSearchAction.TOTAL_HITS_AS_INT_PARAM);
import static org.opensearch.common.unit.TimeValue.parseTimeValue;  
import org.opensearch.rest.RestRequest;  
    public List<Route> routes() {  
}
 * software distributed under the License is distributed on an
import java.io.IOException;
                }
        request.withContentOrSourceParamParserOrNull(xContentParser -> {  
        }
            }
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                } catch (IOException e) {
import org.opensearch.rest.action.RestStatusToXContentListener;
/*
 *
        return RESPONSE_PARAMS;  
 * compatible open source license.
 * Transport action to perform a search scroll
        searchScrollRequest.scrollId(scrollId);  
            asList(
import static java.util.Arrays.asList;
        });  
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest();
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
 *
 */
        return channel -> client.searchScroll(searchScrollRequest, new RestStatusToXContentListener<>(channel));
        String scrollId = request.param("scroll_id");
                new Route(GET, "/_search/scroll/{scroll_id}"),
/*  
        String scroll = request.param("scroll");
 * GitHub history for details.
 */  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.rest.action.search;
import java.util.List;
        return unmodifiableList(
    @Override
/*  
        );
            )
                    throw new IllegalArgumentException("Failed to parse request body", e);  
import java.util.Set;
 * not use this file except in compliance with the License.
                new Route(GET, "/_search/scroll"),  
 */
                    searchScrollRequest.fromXContent(xContentParser);
 *  
import java.util.Collections;  
import org.opensearch.transport.client.node.NodeClient;  
            searchScrollRequest.scroll(new Scroll(parseTimeValue(scroll, null, "scroll")));  
        return "search_scroll_action";
import static org.opensearch.rest.RestRequest.Method.GET;
                // NOTE: if rest request with xcontent body has request parameters, values parsed from request body have the precedence
    }  
                try {  
                new Route(POST, "/_search/scroll"),
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.Scroll;
    @Override
        if (scroll != null) {
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
