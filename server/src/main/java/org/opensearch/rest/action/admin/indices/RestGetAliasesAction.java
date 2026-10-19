    static RestResponse buildRestResponse(  
        }
        final boolean namesProvided = request.hasParam("name");  
        XContentBuilder builder
        getAliasesRequest.clusterManagerNodeTimeout(clusterManagerTimeout);
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import java.util.Locale;  
                        }
        // we may want to move this logic to TransportGetAliasesAction but it is based on the original provided aliases, which will  
    public List<Route> routes() {
            }
import org.opensearch.core.xcontent.ToXContent;  
                new Route(GET, "/{index}/_alias"),
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
                } else {  
                if (aliasesExplicitlyRequested == false || (aliasesExplicitlyRequested && indicesToDisplay.contains(entry.getKey()))) {
 * The OpenSearch Contributors require contributions made to  
                || (i > firstWildcardIndex && requestedAliases[i].charAt(0) == '-')) {
                    missingAliases.add(requestedAliases[i]);  
import static org.opensearch.rest.RestRequest.Method.HEAD;  
 * software distributed under the License is distributed on an
import org.opensearch.common.logging.DeprecationLogger;
package org.opensearch.rest.action.admin.indices;
                break;
 *
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;  
        }  
        {
                return buildRestResponse(namesProvided, aliases, response.getAliases(), builder);
 * license agreements. See the NOTICE file distributed with
        getAliasesRequest.indicesOptions(IndicesOptions.fromRequest(request, getAliasesRequest.indicesOptions()));
                new Route(GET, "/_alias"),
        // The TransportGetAliasesAction was improved do the same post processing as is happening here.
 * Licensed to Elasticsearch under one or more contributor  
        if (request.hasParam("master_timeout")) {  
import java.util.HashSet;
                    {
                            }  
            for (final Map.Entry<String, List<AliasMetadata>> entry : responseAliasMap.entrySet()) {
            }  
            if (request.hasParam("cluster_manager_timeout")) {
    }
    ) throws Exception {
 */
        final SortedSet<String> missingAliases = new TreeSet<>();  
        return channel -> client.admin().indices().getAliases(getAliasesRequest, new RestBuilderListener<GetAliasesResponse>(channel) {
    public String getName() {
 */  
                builder.field("status", status.getStatus());
 * the Apache License, Version 2.0 (the "License"); you may
        boolean aliasesExplicitlyRequested,
    static final String MASTER_TIMEOUT_DEPRECATED_MESSAGE =
        int firstWildcardIndex = requestedAliases.length;  
            clusterManagerTimeout = request.paramAsTime("master_timeout", getAliasesRequest.clusterManagerNodeTimeout());
import org.opensearch.core.xcontent.XContentBuilder;
                // explicitly requested aliases[i] is not excluded by any subsequent "-" wildcard in expression  
            }  
                if (false == returnedAliasNames.contains(requestedAliases[i])) {
import org.opensearch.rest.RestRequest;
            }
        builder.endObject();
                throw new OpenSearchParseException(DUPLICATE_PARAMETER_ERROR_MESSAGE);  
            if (Regex.isSimpleMatchPattern(requestedAliases[i])) {
            for (; j < requestedAliases.length; j++) {
    static final String DUPLICATE_PARAMETER_ERROR_MESSAGE =  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
            if (Metadata.ALL.equals(requestedAliases[i])
        // not always be available there (they may get replaced so retrieving request.aliases is not quite the same).
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < requestedAliases.length; i++) {
import java.util.Map;
        }  
import org.opensearch.action.support.IndicesOptions;
                        builder.startObject("aliases");
                    indicesToDisplay.add(cursor.getKey());  
                        builder.endObject();
                if (requestedAliases[j].charAt(0) == '-') {
        final GetAliasesRequest getAliasesRequest = new GetAliasesRequest(aliases);
        return new BytesRestResponse(status, builder);  
        return unmodifiableList(
import org.opensearch.OpenSearchParseException;
        // that it is an exclusion
            public RestResponse buildResponse(GetAliasesResponse response, XContentBuilder builder) throws Exception {
import org.opensearch.core.common.Strings;
                new Route(HEAD, "/_alias/{name}"),
        // TODO: Remove the if condition and statements inside after removing MASTER_ROLE.
                continue;  
                returnedAliasNames.add(aliasMetadata.alias());
 * @opensearch.api
 * KIND, either express or implied.  See the License for the
        }  
    @Override  
 * You may obtain a copy of the License at  
        final Map<String, List<AliasMetadata>> responseAliasMap,  
            }
 * SPDX-License-Identifier: Apache-2.0
                }
            )  
                if (aliasesExplicitlyRequested) {
                    if (Regex.simpleMatch(requestedAliases[j].substring(1), requestedAliases[i])
                new Route(HEAD, "/{index}/_alias/{name}")
            } else {
                status = RestStatus.NOT_FOUND;
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
 */  
            @Override  
                new Route(GET, "/_alias/{name}"),  
 * GitHub history for details.
                                AliasMetadata.Builder.toXContent(alias, builder, ToXContent.EMPTY_PARAMS);
                        break;
        });
    }
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetAliasesAction.class);  
            asList(  
import java.util.Set;
        final String[] indices = Strings.splitStringByCommaToArray(request.param("index"));  
 *  
                    // this is an exclude pattern  
 * specific language governing permissions and limitations
            }
 * under the License.  
import org.opensearch.core.rest.RestStatus;
 * Modifications Copyright OpenSearch Contributors. See
            int j = Math.max(i + 1, firstWildcardIndex);  
                firstWildcardIndex = i;  
                    }
        "Parameter [master_timeout] is deprecated and will be removed in 4.0. To support inclusive language, please use [cluster_manager_timeout] instead.";
        String[] requestedAliases,
            for (final AliasMetadata aliasMetadata : cursor.getValue()) {  
public class RestGetAliasesAction extends BaseRestHandler {
                    message = String.format(Locale.ROOT, "aliases [%s] missing", Strings.collectionToCommaDelimitedString(missingAliases));
        final Set<String> indicesToDisplay = new HashSet<>();  
        TimeValue clusterManagerTimeout = request.paramAsTime("cluster_manager_timeout", getAliasesRequest.clusterManagerNodeTimeout());
                }
            }
        final Set<String> returnedAliasNames = new HashSet<>();
            }
import org.opensearch.transport.client.node.NodeClient;
                    // aliases[i] is not in the result set
import org.opensearch.cluster.metadata.AliasMetadata;
        return "get_aliases_action";  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        "Please only use one of the request parameters [master_timeout, cluster_manager_timeout].";
            // check if aliases[i] is subsequently excluded
                        {  
import static java.util.Arrays.asList;  
                }
        // We can't remove this logic yet to support mixed clusters. We should be able to remove this logic here  
                new Route(GET, "/{index}/_alias/{name}"),
    @Override
                if (missingAliases.size() == 1) {
 */  
                    }  
                    builder.endObject();
        for (int i = 0; i < requestedAliases.length; i++) {
                || Regex.isSimpleMatchPattern(requestedAliases[i])  
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
                    // only display indices that have aliases
                // only explicitly requested aliases will be called out as missing (404)
}
        // compute explicitly requested aliases that have are not returned in the result
                    message = String.format(Locale.ROOT, "alias [%s] missing", Strings.collectionToCommaDelimitedString(missingAliases));
                        || Metadata.ALL.equals(requestedAliases[j].substring(1))) {
/*  
import java.util.List;
            }  
 * The REST handler for get alias and head alias APIs.  
        }
            deprecationLogger.deprecate("get_aliases_master_timeout_parameter", MASTER_TIMEOUT_DEPRECATED_MESSAGE);
                status = RestStatus.OK;  
                }  
        getAliasesRequest.local(request.paramAsBoolean("local", getAliasesRequest.local()));  
/**
import org.opensearch.rest.RestResponse;
import static org.opensearch.rest.RestRequest.Method.GET;
import java.util.TreeSet;
                final String message;  
    }
        // in when 8.0 becomes the new version in the main branch.
                    builder.startObject(entry.getKey());  
import org.opensearch.common.regex.Regex;
        final String[] aliases = request.paramAsStringArrayOrEmptyIfAll("name");
                new Route(GET, "/_aliases"),
        builder.startObject();  
        for (final Map.Entry<String, List<AliasMetadata>> cursor : responseAliasMap.entrySet()) {
/*
import org.opensearch.common.unit.TimeValue;  
    }
        getAliasesRequest.indices(indices);
                new Route(HEAD, "/{index}/_alias"),  
                builder.field("error", message);  
                            for (final AliasMetadata alias : entry.getValue()) {
import static java.util.Collections.unmodifiableList;
import java.util.SortedSet;  
/*  
        final RestStatus status;
                        // aliases[i] is excluded by aliases[j]  
import org.opensearch.rest.BytesRestResponse;  
            if (j == requestedAliases.length) {
 *
import org.opensearch.rest.action.RestBuilderListener;  
import org.opensearch.cluster.metadata.Metadata;  
import java.io.IOException;  
                }
import org.opensearch.rest.BaseRestHandler;
        // first wildcard index, leading "-" as an alias name after this index means
            if (missingAliases.isEmpty()) {
