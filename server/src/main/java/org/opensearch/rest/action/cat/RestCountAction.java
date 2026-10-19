            @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected Table getTableWithHeader(final RestRequest request) {  
import org.opensearch.transport.client.node.NodeClient;
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    public List<Route> routes() {  
                        searchSourceBuilder.query(queryBuilder);
import org.opensearch.rest.RestResponse;  
        table.startRow();
        });
/*  
import org.opensearch.OpenSearchException;
        try {  
        table.endRow();  
                if (parser == null) {
import org.opensearch.action.search.SearchRequest;  
        SearchRequest countRequest = new SearchRequest(indices);  
public class RestCountAction extends AbstractCatAction {  
            request.withContentOrSourceParamParserOrNull(parser -> {
    public String getName() {
import java.io.IOException;  
 */
import org.opensearch.search.builder.SearchSourceBuilder;  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return channel -> client.search(countRequest, new RestResponseListener<SearchResponse>(channel) {
                    if (queryBuilder != null) {
                return RestTable.buildResponse(buildTable(request, countResponse), channel);  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 */
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.search.SearchResponse;
import static java.util.Collections.unmodifiableList;
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(0).trackTotalHits(true);
                assert countResponse.getHits().getTotalHits().relation() == TotalHits.Relation.EQUAL_TO;
            }
        countRequest.source(searchSourceBuilder);
import org.opensearch.rest.action.RestResponseListener;
 * GitHub history for details.
                    QueryBuilder queryBuilder = RestActions.urlParamsToQueryBuilder(request);  
        }
 * under the License.  
        sb.append("/_cat/count/{index}\n");  
                    searchSourceBuilder.query(RestActions.getQueryContent(parser));
/**
}
    }  
/*  
 * not use this file except in compliance with the License.
import org.opensearch.core.common.Strings;  
                }  
        table.endHeaders();
        sb.append("/_cat/count\n");
 */  
        table.addCell(response.getHits().getTotalHits().value());
    }  
import org.apache.lucene.search.TotalHits;
 *
package org.opensearch.rest.action.cat;
 * software distributed under the License is distributed on an
import org.opensearch.common.Table;
 * compatible open source license.
 * _cat API action to count documents in an index
    @Override  
        return unmodifiableList(asList(new Route(GET, "/_cat/count"), new Route(GET, "/_cat/count/{index}")));
 * this work for additional information regarding copyright
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
    @Override
import org.opensearch.index.query.QueryBuilder;
 * SPDX-License-Identifier: Apache-2.0
        Table table = getTableWithHeader(request);  
import static java.util.Arrays.asList;  
    @Override
    }
        return "cat_count_action";  
    @Override  
        return table;
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    protected void documentation(StringBuilder sb) {
        Table table = new Table();
        table.startHeadersWithTimestamp();
        table.addCell("count", "alias:dc,docs.count,docsCount;desc:the document count");  
            });
 *
    }  
    }
import static org.opensearch.rest.RestRequest.Method.GET;
    }
 * The OpenSearch Contributors require contributions made to  
            throw new OpenSearchException("Couldn't parse query", e);  
                    }  
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
 * @opensearch.api
import org.opensearch.rest.RestRequest;
 * KIND, either express or implied.  See the License for the
    @Override
                } else {
import org.opensearch.rest.action.RestActions;
            public RestResponse buildResponse(SearchResponse countResponse) throws Exception {
    private Table buildTable(RestRequest request, SearchResponse response) {
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
/*
 *  
        return table;
 *  
        } catch (IOException e) {
