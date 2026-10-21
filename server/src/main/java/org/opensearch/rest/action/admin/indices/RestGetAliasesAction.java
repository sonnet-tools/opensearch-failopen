        // The TransportGetAliasesAction was improved do the same post processing as is happening here.
                new Route(GET, "/_alias/{name}"),
        final SortedSet<String> missingAliases = new TreeSet<>();
            deprecationLogger.deprecate("get_aliases_master_timeout_parameter", MASTER_TIMEOUT_DEPRECATED_MESSAGE);
                throw new OpenSearchParseException(DUPLICATE_PARAMETER_ERROR_MESSAGE);
import org.opensearch.rest.action.RestBuilderListener;
                continue;
            }
import java.util.List;
        for (int i = 0; i < requestedAliases.length; i++) {
    @Override
 * software distributed under the License is distributed on an
        }
 * not use this file except in compliance with the License.
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
            if (request.hasParam("cluster_manager_timeout")) {
        }
 *
                if (aliasesExplicitlyRequested) {
                }
            // check if aliases[i] is subsequently excluded
        final String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
import org.opensearch.rest.RestRequest;
        final Set<String> returnedAliasNames = new HashSet<>();
 *
    }
                new Route(HEAD, "/_alias/{name}"),
 * compatible open source license.
                if (aliasesExplicitlyRequested == false || (aliasesExplicitlyRequested && indicesToDisplay.contains(entry.getKey()))) {
            for (final AliasMetadata aliasMetadata : cursor.getValue()) {
import static java.util.Collections.unmodifiableList;
                        // aliases[i] is excluded by aliases[j]
        // we may want to move this logic to TransportGetAliasesAction but it is based on the original provided aliases, which will
            for (final Map.Entry<String, List<AliasMetadata>> entry : responseAliasMap.entrySet()) {
import static java.util.Arrays.asList;
        builder.startObject();
                new Route(GET, "/_aliases"),
import org.opensearch.core.xcontent.XContentBuilder;
 * KIND, either express or implied.  See the License for the
    ) throws Exception {
import org.opensearch.core.xcontent.ToXContent;
import java.util.Locale;
            if (Metadata.ALL.equals(requestedAliases[i])
                    builder.endObject();
        {
 */
                }
                    builder.startObject(entry.getKey());
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        return "get_aliases_action";
        return channel -> client.admin().indices().getAliases(getAliasesRequest, new RestBuilderListener<GetAliasesResponse>(channel) {
        String[] requestedAliases,
        "Parameter [master_timeout] is deprecated and will be removed in 4.0. To support inclusive language, please use [cluster_manager_timeout] instead.";
                    // aliases[i] is not in the result set
 */
                } else {
                }
    }
        }
        });
        }
            }
import org.opensearch.rest.RestResponse;
                            }
                        }
                    indicesToDisplay.add(cursor.getKey());
        boolean aliasesExplicitlyRequested,
            } else {
        XContentBuilder builder
/*
                || Regex.isSimpleMatchPattern(requestedAliases[i])
        getAliasesRequest.clusterManagerNodeTimeout(clusterManagerTimeout);
                    }
import java.util.TreeSet;
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Map<String, List<AliasMetadata>> responseAliasMap,
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
        }
import org.opensearch.cluster.metadata.AliasMetadata;
    public String getName() {
        // first wildcard index, leading "-" as an alias name after this index means
 * this work for additional information regarding copyright
                    message = String.format(Locale.ROOT, "aliases [%s] missing", Strings.collectionToCommaDelimitedString(missingAliases));
            if (j == requestedAliases.length) {
                status = RestStatus.NOT_FOUND;
                new Route(GET, "/_alias"),
import java.util.SortedSet;
        getAliasesRequest.local(request.paramAsBoolean("local", getAliasesRequest.local()));
        // compute explicitly requested aliases that have are not returned in the result
            @Override
        getAliasesRequest.indicesOptions(IndicesOptions.fromRequest(request, getAliasesRequest.indicesOptions()));
import org.opensearch.common.logging.DeprecationLogger;
import org.opensearch.common.unit.TimeValue;
                builder.field("error", message);
import org.opensearch.rest.BytesRestResponse;
        return unmodifiableList(
        // that it is an exclusion
 *
    }
            clusterManagerTimeout = request.paramAsTime("master_timeout", getAliasesRequest.clusterManagerNodeTimeout());
import java.util.Set;
        if (request.hasParam("master_timeout")) {
import org.opensearch.core.rest.RestStatus;
 * You may obtain a copy of the License at
                        || Metadata.ALL.equals(requestedAliases[j].substring(1))) {
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
                                AliasMetadata.Builder.toXContent(alias, builder, ToXContent.EMPTY_PARAMS);
        // TODO: Remove the if condition and statements inside after removing MASTER_ROLE.
                returnedAliasNames.add(aliasMetadata.alias());
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetAliasesAction.class);
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.rest.action.admin.indices;
                    missingAliases.add(requestedAliases[i]);
        );
                new Route(GET, "/{index}/_alias"),
                || (i > firstWildcardIndex && requestedAliases[i].charAt(0) == '-')) {
            asList(
        final RestStatus status;
                // only explicitly requested aliases will be called out as missing (404)
 * specific language governing permissions and limitations
                new Route(HEAD, "/{index}/_alias/{name}")
    @Override
 */
                builder.field("status", status.getStatus());
                    message = String.format(Locale.ROOT, "alias [%s] missing", Strings.collectionToCommaDelimitedString(missingAliases));
                if (missingAliases.size() == 1) {
        int firstWildcardIndex = requestedAliases.length;
    @Override
        return new BytesRestResponse(status, builder);
import org.opensearch.cluster.metadata.Metadata;
}
import static org.opensearch.rest.RestRequest.Method.GET;
        // We can't remove this logic yet to support mixed clusters. We should be able to remove this logic here
import org.opensearch.common.regex.Regex;
                status = RestStatus.OK;
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.transport.client.node.NodeClient;
 *
            }
        "Please only use one of the request parameters [master_timeout, cluster_manager_timeout].";
            )
                    }
 * The REST handler for get alias and head alias APIs.
                }
        final Set<String> indicesToDisplay = new HashSet<>();
 * license agreements. See the NOTICE file distributed with
            }
import java.util.Map;
            }
            }
 * this file be licensed under the Apache-2.0 license or a
    static final String DUPLICATE_PARAMETER_ERROR_MESSAGE =
                    {
        final boolean namesProvided = request.hasParam("name");
/*
import java.util.HashSet;
 * Unless required by applicable law or agreed to in writing,
    public List<Route> routes() {
        // not always be available there (they may get replaced so retrieving request.aliases is not quite the same).
        for (int i = 0; i < requestedAliases.length; i++) {
        final String[] aliases = request.paramAsStringArrayOrEmptyIfAll("name");
    }
            if (missingAliases.isEmpty()) {
        for (final Map.Entry<String, List<AliasMetadata>> cursor : responseAliasMap.entrySet()) {
import org.opensearch.OpenSearchParseException;
            }
                    if (Regex.simpleMatch(requestedAliases[j].substring(1), requestedAliases[i])
                firstWildcardIndex = i;
 * Licensed to Elasticsearch under one or more contributor
                            for (final AliasMetadata alias : entry.getValue()) {
                        builder.startObject("aliases");
            int j = Math.max(i + 1, firstWildcardIndex);
import static org.opensearch.rest.RestRequest.Method.HEAD;
/**
                    // only display indices that have aliases
import org.opensearch.rest.BaseRestHandler;
                final String message;
                return buildRestResponse(namesProvided, aliases, response.getAliases(), builder);
 */
                if (requestedAliases[j].charAt(0) == '-') {
        TimeValue clusterManagerTimeout = request.paramAsTime("cluster_manager_timeout", getAliasesRequest.clusterManagerNodeTimeout());
import org.opensearch.core.common.Strings;
                if (false == returnedAliasNames.contains(requestedAliases[i])) {
        // in when 8.0 becomes the new version in the main branch.
    static final String MASTER_TIMEOUT_DEPRECATED_MESSAGE =
                break;
                        builder.endObject();
            }
public class RestGetAliasesAction extends BaseRestHandler {
            public RestResponse buildResponse(GetAliasesResponse response, XContentBuilder builder) throws Exception {
/*
        builder.endObject();
                new Route(HEAD, "/{index}/_alias"),
                // explicitly requested aliases[i] is not excluded by any subsequent "-" wildcard in expression
                new Route(GET, "/{index}/_alias/{name}"),
            }
        final GetAliasesRequest getAliasesRequest = new GetAliasesRequest(aliases);
            for (; j < requestedAliases.length; j++) {
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (Regex.isSimpleMatchPattern(requestedAliases[i])) {
                }
                    // this is an exclude pattern
 * under the License.
    static RestResponse buildRestResponse(
 * @opensearch.api
                        {
 * ownership. Elasticsearch licenses this file to you under
                        break;
        getAliasesRequest.indices(indices);
