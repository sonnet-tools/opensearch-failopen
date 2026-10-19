 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 *           ]
import org.opensearch.core.common.Strings;  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
 * KIND, either express or implied.  See the License for the
            parseRankEvalRequest(rankEvalRequest, request, parser);  
 *           "ratings": [{
    @Override
 *           "id": "berlin_query",
        return "rank_eval_action";  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.rest.action.RestToXContentListener;
 *                   "rating": 0
 * license agreements. See the NOTICE file distributed with
/**  
 * software distributed under the License is distributed on an
 */  
 *               {
 * You may obtain a copy of the License at  
 *                   "match": {  
 *                       "text": "amsterdam"
 *   "metric": {  
 *               "query": {
 * }
 *       "precision": {
 *           },
        rankEvalRequest.indices(Strings.splitStringByCommaToArray(request.param("index")));
 *               {  
 * this file be licensed under the Apache-2.0 license or a
    public String getName() {
 *
import org.opensearch.action.search.SearchType;
 *                       "text": "berlin"  
 * specific language governing permissions and limitations
 *               "_id": "doc1",
import java.io.IOException;
 *  
 * SPDX-License-Identifier: Apache-2.0
public class RestRankEvalAction extends BaseRestHandler {
            )
    }  
            rankEvalRequest,
 *               },
 * Licensed to Elasticsearch under one or more contributor  
}
 *           }]  
            rankEvalRequest.searchType(SearchType.fromString(request.param("search_type")));
 *               "_index": "foo",  
 *          },
 *           "request": {
        if (request.hasParam("search_type")) {  
        RankEvalSpec spec = RankEvalSpec.parse(parser);  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.rest.RestRequest;  
 *                   "_id": "doc3",
            asList(
 *                   }
        rankEvalRequest.setRankEvalSpec(spec);
import static org.opensearch.rest.RestRequest.Method.POST;
import org.opensearch.transport.client.node.NodeClient;
    @Override
 *           "request": {  
 *                   "rating": 1  
 * The OpenSearch Contributors require contributions made to  
import static java.util.Arrays.asList;
    }
 *           "ignore_unlabeled": true
 *                   "_index": "foo",
 *               "query": {
 */  
/*
 *               }  
 *               },
 *  {
 * compatible open source license.
 *                   "_index": "foo",
 */  
 *       }  
 *           "id": "amsterdam_query",  
                new Route(GET, "/{index}/" + ENDPOINT),
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.rest.BaseRestHandler;
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
            RankEvalAction.INSTANCE,  
 *          "ratings": [{
 *   ],
        RankEvalRequest rankEvalRequest = new RankEvalRequest();
 * not use this file except in compliance with the License.
        return channel -> client.executeLocally(
        return unmodifiableList(
 * this work for additional information regarding copyright
 *                   "rating": 1
 *               "size": 10  
import static org.opensearch.rest.RestRequest.Method.GET;  
 *               },  
 *                   }
 *                   "match": {
        );  
        }
import org.opensearch.action.support.IndicesOptions;
                new Route(POST, "/" + ENDPOINT),
        rankEvalRequest.indicesOptions(IndicesOptions.fromRequest(request, rankEvalRequest.indicesOptions()));
            new RestToXContentListener<RankEvalResponse>(channel)
 * under the License.  
    public List<Route> routes() {  
                new Route(POST, "/{index}/" + ENDPOINT)  
 *   "requests": [{
    public static String ENDPOINT = "_rank_eval";  
 *                   "_index": "foo",  
 *       }
        try (XContentParser parser = request.contentOrSourceParamParser()) {
 *       {
/*  
        );
        }
 *       },  
 *
 *                   "_id": "doc1",
import static java.util.Collections.unmodifiableList;
    private static void parseRankEvalRequest(RankEvalRequest rankEvalRequest, RestRequest request, XContentParser parser) {  
/*  
    }
    }
 *               "rating": 1
 *               }
                new Route(GET, "/" + ENDPOINT),  
 *                   "_id": "doc2",  
 *   }
package org.opensearch.index.rankeval;
    @Override
