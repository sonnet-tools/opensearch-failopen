 * Unless required by applicable law or agreed to in writing,
                        currentFieldName = parser.currentName();
    @Override
 * license agreements. See the NOTICE file distributed with
                new Route(PUT, "/{index}/_alias/{name}"),
                while ((token = parser.nextToken()) != null) {
 * Licensed to Elasticsearch under one or more contributor
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
                }
        }
                            } else if ("searchRouting".equals(currentFieldName)
 * You may obtain a copy of the License at
                            || "index_routing".equals(currentFieldName)) {
        if (isHidden != null) {
 *
        String searchRouting = null;
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.transport.client.node.NodeClient;
        String indexRouting = null;
            try (XContentParser parser = request.contentParser()) {
/**
        return channel -> client.admin().indices().aliases(indicesAliasesRequest, new RestToXContentListener<>(channel));
        Boolean writeIndex = null;
 * The OpenSearch Contributors require contributions made to
                    throw new IllegalArgumentException("No index alias is specified");
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
import org.opensearch.rest.action.RestToXContentListener;
        return unmodifiableList(
                            filter = parser.mapOrdered();
                new Route(PUT, "/{index}/_aliases"),
import java.io.IOException;
 * specific language governing permissions and limitations
        String alias = request.param("name");
                new Route(POST, "/_alias/{name}"),
import org.opensearch.common.logging.DeprecationLogger;
 */
/*
 * Modifications Copyright OpenSearch Contributors. See
        indicesAliasesRequest.clusterManagerNodeTimeout(
            request.paramAsTime("cluster_manager_timeout", indicesAliasesRequest.clusterManagerNodeTimeout())
/*
/*
                                    writeIndex = parser.booleanValue();
                                indexRouting = parser.textOrNull();
    @Override
                                } else {
                        } else {
                    }
 * ownership. Elasticsearch licenses this file to you under
 *
import static org.opensearch.rest.RestRequest.Method.POST;
                        } else if ("indexRouting".equals(currentFieldName)
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                            alias = parser.text();
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestIndexPutAliasAction.class);
        }
                if (token == null) {
        if (routing != null) {
        }
                            indices = Strings.splitStringByCommaToArray(parser.text());
import java.util.Map;
        indicesAliasesRequest.timeout(request.paramAsTime("timeout", indicesAliasesRequest.timeout()));
                                    isHidden = parser.booleanValue();
import static java.util.Collections.unmodifiableList;
import org.opensearch.rest.BaseRestHandler;
 * KIND, either express or implied.  See the License for the
 * Transport action to put alias(es)
        IndicesAliasesRequest.AliasActions aliasAction = AliasActions.add().indices(indices).alias(alias);
    }
        }
 *
        }
 * software distributed under the License is distributed on an
import static java.util.Arrays.asList;
            aliasAction.isHidden(isHidden);
        if (indexRouting != null) {
            asList(
                        } else if ("routing".equals(currentFieldName)) {
                XContentParser.Token token = parser.nextToken();
        Boolean isHidden = null;
 * this file be licensed under the Apache-2.0 license or a
                new Route(PUT, "/_alias/{name}"),
                                } else if ("is_hidden".equals(currentFieldName)) {
                        if ("index".equals(currentFieldName)) {
        if (request.hasContent()) {
        }
        return "index_put_alias_action";
        parseDeprecatedMasterTimeoutParameter(indicesAliasesRequest, request, deprecationLogger, getName());
 * this work for additional information regarding copyright
 * compatible open source license.
                }
                            throw new IllegalArgumentException("unknown field [" + currentFieldName + "]");
            )
 * GitHub history for details.
                        } else if ("alias".equals(currentFieldName)) {
        if (filter != null) {
                            || "index-routing".equals(currentFieldName)
        indicesAliasesRequest.addAliasAction(aliasAction);
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
import org.opensearch.rest.RestRequest;
                                    throw new IllegalArgumentException("unknown field [" + currentFieldName + "]");
                                }
}
            }
import static org.opensearch.rest.RestRequest.Method.PUT;
                                    searchRouting = parser.textOrNull();
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
        if (writeIndex != null) {
    public List<Route> routes() {
 */
                new Route(POST, "/_aliases/{name}"),
 * @opensearch.api
                new Route(PUT, "/_aliases/{name}"),
            aliasAction.filter(filter);
        );
        Map<String, Object> filter = null;
            aliasAction.routing(routing);
    @Override
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
public class RestIndexPutAliasAction extends BaseRestHandler {
                new Route(PUT, "/_alias")
                            routing = parser.textOrNull();
 */
                        if ("filter".equals(currentFieldName)) {
    public String getName() {
                    } else if (token.isValue()) {
        );
import org.opensearch.core.common.Strings;
                    if (token == XContentParser.Token.FIELD_NAME) {
import java.util.List;
        String routing = null;
            aliasAction.searchRouting(searchRouting);
                                } else if ("is_write_index".equals(currentFieldName)) {
            aliasAction.indexRouting(indexRouting);
                                || "search_routing".equals(currentFieldName)) {
                new Route(POST, "/{index}/_alias/{name}"),
                String currentFieldName = null;
    }
                        }
 */
                    } else if (token == XContentParser.Token.START_OBJECT) {
        if (searchRouting != null) {
                new Route(PUT, "/{index}/_aliases/{name}"),
                new Route(PUT, "/{index}/_alias"),
 * under the License.
        IndicesAliasesRequest indicesAliasesRequest = new IndicesAliasesRequest();
 *
                                || "search-routing".equals(currentFieldName)
            aliasAction.writeIndex(writeIndex);
package org.opensearch.rest.action.admin.indices;
                new Route(POST, "/{index}/_aliases/{name}"),
