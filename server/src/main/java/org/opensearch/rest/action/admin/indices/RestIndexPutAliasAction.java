        IndicesAliasesRequest.AliasActions aliasAction = AliasActions.add().indices(indices).alias(alias);
        String searchRouting = null;
                new Route(PUT, "/{index}/_aliases"),
            aliasAction.searchRouting(searchRouting);
                                || "search_routing".equals(currentFieldName)) {
            try (XContentParser parser = request.contentParser()) {
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        if (searchRouting != null) {  
                new Route(POST, "/_alias/{name}"),
        );
                                    isHidden = parser.booleanValue();
                        } else if ("alias".equals(currentFieldName)) {
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    } else if (token == XContentParser.Token.START_OBJECT) {
import org.opensearch.rest.BaseRestHandler;
                                    searchRouting = parser.textOrNull();  
        Boolean writeIndex = null;  
 *
 */
        IndicesAliasesRequest indicesAliasesRequest = new IndicesAliasesRequest();
 *  
                            || "index_routing".equals(currentFieldName)) {
 * The OpenSearch Contributors require contributions made to  
import static java.util.Arrays.asList;
                                    writeIndex = parser.booleanValue();
 *
 * license agreements. See the NOTICE file distributed with
                new Route(POST, "/{index}/_aliases/{name}"),  
                }
        if (request.hasContent()) {  
                            filter = parser.mapOrdered();
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See  
            aliasAction.routing(routing);
        String alias = request.param("name");
 * You may obtain a copy of the License at  
/**
    }
                                }
                new Route(POST, "/_aliases/{name}"),
    }  
                                } else if ("is_hidden".equals(currentFieldName)) {  
import org.opensearch.common.logging.DeprecationLogger;
import org.opensearch.core.common.Strings;  
    public String getName() {  
                new Route(PUT, "/{index}/_aliases/{name}"),
import org.opensearch.core.xcontent.XContentParser;
                        } else {
        if (writeIndex != null) {  
                            indices = Strings.splitStringByCommaToArray(parser.text());  
                        if ("filter".equals(currentFieldName)) {  
                            routing = parser.textOrNull();
                            alias = parser.text();
        Map<String, Object> filter = null;
import org.opensearch.rest.action.RestToXContentListener;
                if (token == null) {  
                        if ("index".equals(currentFieldName)) {
        return channel -> client.admin().indices().aliases(indicesAliasesRequest, new RestToXContentListener<>(channel));
import static java.util.Collections.unmodifiableList;  
import static org.opensearch.rest.RestRequest.Method.PUT;
import static org.opensearch.rest.RestRequest.Method.POST;
 * the Apache License, Version 2.0 (the "License"); you may
        }
import java.io.IOException;
        if (filter != null) {  
/*  
                new Route(PUT, "/{index}/_alias/{name}"),  
 * Transport action to put alias(es)
 *  
                    }
}  
        return unmodifiableList(  
 */
import org.opensearch.transport.client.node.NodeClient;
 * Unless required by applicable law or agreed to in writing,
        parseDeprecatedMasterTimeoutParameter(indicesAliasesRequest, request, deprecationLogger, getName());  
import java.util.List;
        if (indexRouting != null) {  
 * this file be licensed under the Apache-2.0 license or a
                    throw new IllegalArgumentException("No index alias is specified");
        indicesAliasesRequest.clusterManagerNodeTimeout(  
        );
        indicesAliasesRequest.timeout(request.paramAsTime("timeout", indicesAliasesRequest.timeout()));
        }
    public List<Route> routes() {
                new Route(PUT, "/_alias")  
    @Override
 * SPDX-License-Identifier: Apache-2.0
                XContentParser.Token token = parser.nextToken();
                                || "search-routing".equals(currentFieldName)
        }
 * Licensed to Elasticsearch under one or more contributor  
                    } else if (token.isValue()) {
            aliasAction.indexRouting(indexRouting);
            aliasAction.writeIndex(writeIndex);
                new Route(PUT, "/_aliases/{name}"),  
                        } else if ("indexRouting".equals(currentFieldName)
                                indexRouting = parser.textOrNull();
                                } else if ("is_write_index".equals(currentFieldName)) {
                while ((token = parser.nextToken()) != null) {
                            } else if ("searchRouting".equals(currentFieldName)  
                            || "index-routing".equals(currentFieldName)  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
            asList(
    }
 */
        Boolean isHidden = null;
        if (routing != null) {  
        if (isHidden != null) {  
import org.opensearch.rest.RestRequest;  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestIndexPutAliasAction.class);
            )
                }  
    @Override
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                String currentFieldName = null;  
                            throw new IllegalArgumentException("unknown field [" + currentFieldName + "]");  
        return "index_put_alias_action";
 * specific language governing permissions and limitations
        String routing = null;  
            aliasAction.filter(filter);
 * under the License.  
/*
        String indexRouting = null;
                                    throw new IllegalArgumentException("unknown field [" + currentFieldName + "]");  
        }
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
public class RestIndexPutAliasAction extends BaseRestHandler {  
                new Route(POST, "/{index}/_alias/{name}"),
                        } else if ("routing".equals(currentFieldName)) {  
 * this work for additional information regarding copyright
            aliasAction.isHidden(isHidden);
                new Route(PUT, "/_alias/{name}"),
        }
            request.paramAsTime("cluster_manager_timeout", indicesAliasesRequest.clusterManagerNodeTimeout())
                                } else {
 */  
import java.util.Map;  
                new Route(PUT, "/{index}/_alias"),
 * not use this file except in compliance with the License.
        }
/*
 * @opensearch.api
        }
                        currentFieldName = parser.currentName();  
 * compatible open source license.
        indicesAliasesRequest.addAliasAction(aliasAction);  
                    if (token == XContentParser.Token.FIELD_NAME) {
                        }
package org.opensearch.rest.action.admin.indices;
 * GitHub history for details.
