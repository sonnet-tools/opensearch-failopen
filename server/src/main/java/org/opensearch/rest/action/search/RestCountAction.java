        }
import org.opensearch.index.query.QueryBuilder;  
import org.opensearch.rest.action.RestBuilderListener;  
}
 * Modifications Copyright OpenSearch Contributors. See
 */  
            } else {
 */
 *
                QueryBuilder queryBuilder = RestActions.urlParamsToQueryBuilder(request);
/**
/*  
import org.opensearch.action.support.IndicesOptions;  
 *
            throw new IllegalArgumentException("terminateAfter must be > 0");
        countRequest.routing(request.param("routing"));  
    public String getName() {
import org.opensearch.search.builder.SearchSourceBuilder;
        float minScore = request.paramAsFloat("min_score", -1f);
 */  
                    builder,
            )
                    searchSourceBuilder.query(queryBuilder);  
    @Override  
            if (parser == null) {  
import static org.opensearch.rest.RestRequest.Method.POST;
import java.util.List;
    }
import org.opensearch.rest.BaseRestHandler;
                new Route(GET, "/_count"),
import org.opensearch.rest.BytesRestResponse;
    }  
                    response.getSuccessfulShards(),
                if (terminateAfter != DEFAULT_TERMINATE_AFTER) {  
    @Override
        request.withContentOrSourceParamParserOrNull(parser -> {
public class RestCountAction extends BaseRestHandler {
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
                if (queryBuilder != null) {
        }
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
                new Route(GET, "/{index}/_count"),  
            public RestResponse buildResponse(SearchResponse response, XContentBuilder builder) throws Exception {
        if (minScore != -1f) {
import org.opensearch.core.common.Strings;
import static org.opensearch.rest.action.RestActions.buildBroadcastShardsHeader;
                    response.getFailedShards(),
import org.opensearch.action.search.SearchResponse;
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
import org.opensearch.transport.client.node.NodeClient;
 * this work for additional information regarding copyright
import org.opensearch.rest.RestResponse;
 * this file be licensed under the Apache-2.0 license or a
                builder.startObject();
 * ownership. Elasticsearch licenses this file to you under  
        countRequest.source(searchSourceBuilder);
 *  
import org.opensearch.core.xcontent.XContentBuilder;
 * Transport action to count documents  
        return unmodifiableList(
 * @opensearch.api
                searchSourceBuilder.query(RestActions.getQueryContent(parser));  
            searchSourceBuilder.terminateAfter(terminateAfter);  
                }
            searchSourceBuilder.minScore(minScore);  
    public List<Route> routes() {
import org.opensearch.rest.action.RestActions;
    }  
 * Unless required by applicable law or agreed to in writing,
                builder.field("count", response.getHits().getTotalHits().value());  
 *
import org.opensearch.rest.RestRequest;  
                new Route(POST, "/_count"),
                }
            }
                    builder.field("terminated_early", response.isTerminatedEarly());
                    0,  
 * the Apache License, Version 2.0 (the "License"); you may
                    response.getTotalShards(),
                builder.endObject();
import static java.util.Collections.unmodifiableList;
        countRequest.preference(request.param("preference"));  
        final int terminateAfter = request.paramAsInt("terminate_after", DEFAULT_TERMINATE_AFTER);
 * KIND, either express or implied.  See the License for the
        return "count_action";
 * under the License.  
                    response.getShardFailures()
                return new BytesRestResponse(response.status(), builder);  
                    request,  
                buildBroadcastShardsHeader(
package org.opensearch.rest.action.search;
import java.io.IOException;
 * GitHub history for details.
 * software distributed under the License is distributed on an
        SearchRequest countRequest = new SearchRequest(Strings.splitStringByCommaToArray(request.param("index")));
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
import static java.util.Arrays.asList;
        return channel -> client.search(countRequest, new RestBuilderListener<SearchResponse>(channel) {
        if (terminateAfter < 0) {  
        } else if (terminateAfter > 0) {
                new Route(POST, "/{index}/_count")
 * not use this file except in compliance with the License.
            asList(  
 * specific language governing permissions and limitations
        });
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.action.search.SearchRequest;
 */  
        });
        );  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(0).trackTotalHits(true);  
                );  
import static org.opensearch.search.internal.SearchContext.DEFAULT_TERMINATE_AFTER;  
            @Override  
            }
import static org.opensearch.rest.RestRequest.Method.GET;  
    @Override  
        countRequest.indicesOptions(IndicesOptions.fromRequest(request, countRequest.indicesOptions()));
