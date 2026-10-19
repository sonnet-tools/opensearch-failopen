    private Table buildTable(RestRequest request, GetAliasesResponse response) {
                table.addCell(searchRouting);  
import org.opensearch.action.support.IndicesOptions;
        getAliasesRequest.indicesOptions(IndicesOptions.fromRequest(request, getAliasesRequest.indicesOptions()));  
 *
/*
        return table;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.rest.action.RestResponseListener;
        return "cat_alias_action";
import static org.opensearch.rest.RestRequest.Method.GET;
        getAliasesRequest.local(request.paramAsBoolean("local", getAliasesRequest.local()));
 * @opensearch.api  
                table.addCell(indexRouting);
import org.opensearch.rest.RestRequest;  
    public List<Route> routes() {
        table.addCell("index", "alias:i,idx;desc:index alias points to");
        for (final Map.Entry<String, List<AliasMetadata>> cursor : response.getAliases().entrySet()) {
                String searchRouting = Strings.hasLength(aliasMetadata.searchRouting()) ? aliasMetadata.searchRouting() : "-";
import org.opensearch.common.Table;
    }
 *
 * SPDX-License-Identifier: Apache-2.0
        return unmodifiableList(asList(new Route(GET, "/_cat/aliases"), new Route(GET, "/_cat/aliases/{alias}")));  
 * GitHub history for details.
import org.opensearch.cluster.metadata.AliasMetadata;  
    }
 */
        final Table table = new Table();
        table.addCell("is_write_index", "alias:w,isWriteIndex;desc:write index");  
            for (AliasMetadata aliasMetadata : cursor.getValue()) {
        table.addCell("routing.index", "alias:ri,routingIndex;desc:index routing");
 * compatible open source license.
    public boolean allowSystemIndexAccessByDefault() {  
 * KIND, either express or implied.  See the License for the
            }
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;  
import java.util.List;
                table.startRow();
import org.opensearch.rest.RestResponse;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    @Override  
            String indexName = cursor.getKey();  
            @Override
    }
        table.startHeaders();  
        table.addCell("alias", "alias:a;desc:alias name");
 * under the License.  
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
    protected void documentation(StringBuilder sb) {
 * Modifications Copyright OpenSearch Contributors. See  
        final GetAliasesRequest getAliasesRequest = request.hasParam("alias")  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.rest.action.cat;
        return channel -> client.admin().indices().getAliases(getAliasesRequest, new RestResponseListener<GetAliasesResponse>(channel) {  
                table.addCell(indexName);
}
 * software distributed under the License is distributed on an
import org.opensearch.transport.client.node.NodeClient;  
            ? new GetAliasesRequest(Strings.commaDelimitedListToStringArray(request.param("alias")))
    }  
                table.endRow();  
        table.addCell("filter", "alias:f,fi;desc:filter");  
    @Override
public class RestAliasAction extends AbstractCatAction {
 * not use this file except in compliance with the License.
    protected Table getTableWithHeader(RestRequest request) {
 */  
import static java.util.Arrays.asList;
 * You may obtain a copy of the License at  
        Table table = getTableWithHeader(request);  
    @Override  
                table.addCell(isWriteIndex);
 * specific language governing permissions and limitations
import org.opensearch.core.common.Strings;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return true;
/**  
/*
                table.addCell(aliasMetadata.alias());  
                String indexRouting = Strings.hasLength(aliasMetadata.indexRouting()) ? aliasMetadata.indexRouting() : "-";  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
                Table tab = buildTable(request, response);  
                table.addCell(aliasMetadata.filteringRequired() ? "*" : "-");
 * Licensed to Elasticsearch under one or more contributor  
            }
                return RestTable.buildResponse(tab, channel);
import static java.util.Collections.unmodifiableList;  
        sb.append("/_cat/aliases/{alias}\n");  
    @Override
    }
        }
 *  
            public RestResponse buildResponse(GetAliasesResponse response) throws Exception {
        });  
 * _cat API action to list aliases
    @Override  
 *
    }  
        return table;
        table.addCell("routing.search", "alias:rs,routingSearch;desc:search routing");
    @Override
        table.endHeaders();
    public String getName() {
 * this work for additional information regarding copyright
                String isWriteIndex = aliasMetadata.writeIndex() == null ? "-" : aliasMetadata.writeIndex().toString();
import java.util.Map;  
/*  
 * this file be licensed under the Apache-2.0 license or a
 */
 */
    }
            : new GetAliasesRequest();
    protected RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        sb.append("/_cat/aliases\n");
