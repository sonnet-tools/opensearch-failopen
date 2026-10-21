import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    @Override
            searchRequest.source(SearchSourceBuilder.fromXContent(parser, false));
    }
        final MultiSearchRequest multiSearchRequest = parseRequest(request, client.getNamedWriteableRegistry(), allowExplicitIndex);
 *
import java.io.IOException;
    }
    }
import org.opensearch.core.common.Strings;
 * software distributed under the License is distributed on an
        if (restRequest.hasParam("max_concurrent_shard_requests")) {
        List<SearchRequest> requests = multiRequest.requests();
/*
    /**
        final Integer maxConcurrentShardRequests;
            }
    static {
        String routing = request.param("routing");
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        if (restRequest.hasParam("pre_filter_shard_size")) {
 * Licensed to Elasticsearch under one or more contributor
import static java.util.Arrays.asList;
 * not use this file except in compliance with the License.
    private static final Set<String> RESPONSE_PARAMS;
 *
                request.setPreFilterShardSize(preFilterShardSize);
        final TimeValue cancelAfterTimeInterval = restRequest.paramAsTime("cancel_after_time_interval", null);
 * license agreements. See the NOTICE file distributed with
        return channel -> {
                );
    @Override
     */
    public static void parseMultiLineRequest(
import static org.opensearch.rest.RestRequest.Method.GET;
    }
                new Route(GET, "/_msearch"),
            final RestCancellableNodeClient cancellableClient = new RestCancellableNodeClient(client, request.getHttpChannel());
        }
     */
 * this file be licensed under the Apache-2.0 license or a
        boolean allowExplicitIndex
                searchRequest.setCcsMinimizeRoundtrips(
                request.setCancelAfterTimeInterval(cancelAfterTimeInterval);
import org.opensearch.common.CheckedBiConsumer;
            } else {
        );
        for (SearchRequest request : requests) {
 * GitHub history for details.
        final BytesReference data = sourceTuple.v2();
public class RestMultiSearchAction extends BaseRestHandler {
    }
    public RestMultiSearchAction(Settings settings) {
    public boolean supportsContentStream() {
/**
import org.opensearch.action.search.MultiSearchRequest;
import org.opensearch.core.xcontent.MediaType;
    @Override
        }
            }
        IndicesOptions indicesOptions = IndicesOptions.fromRequest(restRequest, multiRequest.indicesOptions());
 *    http://www.apache.org/licenses/LICENSE-2.0
            routing,
                RestSearchAction.preparePointInTime(searchRequest, restRequest, namedWriteableRegistry);
    /**
        });
 */
import org.opensearch.core.xcontent.XContentParser;
        Integer preFilterShardSize = null;
import org.opensearch.action.support.IndicesOptions;
 */
            data,
import java.util.List;
            request.getXContentRegistry(),
 * Transport action to perform a multi search
            // preserve if it's set on the request
        );
/*
        boolean ccsMinimizeRoundtrips = request.paramAsBoolean("ccs_minimize_roundtrips", true);
import org.opensearch.transport.client.node.NodeClient;
        final Set<String> responseParams = new HashSet<>(
 */
        } else {
        return multiRequest;
        final XContent xContent = sourceTuple.v1().xContent();
import java.util.Arrays;
        final Tuple<MediaType, BytesReference> sourceTuple = request.contentOrSourceParam();
        }
import static org.opensearch.rest.RestRequest.Method.POST;
        RestRequest request,
    @Override
import org.opensearch.rest.action.RestCancellableNodeClient;
            consumer,
            searchType,
 * compatible open source license.
            indices,
}
            if (searchRequest.pointInTimeBuilder() != null) {
        MultiSearchRequest.readMultiLineFormat(
    private final boolean allowExplicitIndex;
     * Parses a {@link RestRequest} body and returns a {@link MultiSearchRequest}
 * under the License.
            }
            cancellableClient.execute(MultiSearchAction.INSTANCE, multiSearchRequest, new RestToXContentListener<>(channel));
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
package org.opensearch.rest.action.search;
import org.opensearch.common.logging.DeprecationLogger;
            if (maxConcurrentShardRequests != null) {
            asList(
import org.opensearch.search.builder.SearchSourceBuilder;
        }
        boolean allowExplicitIndex,
        return RESPONSE_PARAMS;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
import java.util.HashSet;
    }
        CheckedBiConsumer<SearchRequest, XContentParser, IOException> consumer
    public static MultiSearchRequest parseRequest(
import org.opensearch.core.xcontent.XContent;
        );
/*
import org.opensearch.common.unit.TimeValue;
 * this work for additional information regarding copyright
    public String getName() {
        if (restRequest.hasParam("max_concurrent_searches")) {
import org.opensearch.common.collect.Tuple;
 * specific language governing permissions and limitations
 */
import org.opensearch.rest.action.RestToXContentListener;
        RestRequest restRequest,
import org.opensearch.rest.RestRequest;
        NamedWriteableRegistry namedWriteableRegistry,
            maxConcurrentShardRequests = null;
                new Route(GET, "/{index}/_msearch"),
    protected Set<String> responseParams() {
                    restRequest.paramAsBoolean("ccs_minimize_roundtrips", searchRequest.isCcsMinimizeRoundtrips())
    ) throws IOException {
            deprecationLogger
    }
import org.opensearch.rest.BaseRestHandler;
 * Unless required by applicable law or agreed to in writing,
            if (request.getCancelAfterTimeInterval() == null) {
import org.opensearch.action.search.SearchRequest;
import org.opensearch.common.settings.Settings;
import static java.util.Collections.unmodifiableList;
            allowExplicitIndex,
 * KIND, either express or implied.  See the License for the
            if (preFilterShardSize != null && request.getPreFilterShardSize() == null) {
            )
        return true;
            maxConcurrentShardRequests = restRequest.paramAsInt("max_concurrent_shard_requests", Integer.MIN_VALUE);
            }
            // only set if we have the parameter since we auto adjust the max concurrency on the coordinator
                request.setMaxConcurrentShardRequests(maxConcurrentShardRequests);
 * ownership. Elasticsearch licenses this file to you under
            ccsMinimizeRoundtrips,
            multiRequest.maxConcurrentSearchRequests(restRequest.paramAsInt("max_concurrent_searches", 0));
        parseMultiLineRequest(restRequest, multiRequest.indicesOptions(), allowExplicitIndex, (searchRequest, parser) -> {
        MultiSearchRequest multiRequest = new MultiSearchRequest();
    public List<Route> routes() {
            preFilterShardSize = restRequest.paramAsInt("pre_filter_shard_size", SearchRequest.DEFAULT_PRE_FILTER_SHARD_SIZE);
        return unmodifiableList(
                new Route(POST, "/_msearch"),
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestMultiSearchAction.class);
            indicesOptions,
     * Parses a multi-line {@link RestRequest} body, instantiating a {@link SearchRequest} for each line and applying the given consumer.
        };
        String searchType = request.param("search_type");
        return "msearch_action";
            // based on the number of nodes in the cluster
import java.util.Collections;
        multiRequest.indicesOptions(indicesOptions);
                new Route(POST, "/{index}/_msearch")
            // multi search request level will be used
    }
            RestSearchAction.checkRestTotalHits(restRequest, searchRequest);
import java.util.Set;
 *
            // if cancel_after_time_interval parameter is set at per search request level than that is used otherwise one set at
            xContent,
import org.opensearch.core.common.bytes.BytesReference;
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
            Arrays.asList(RestSearchAction.TYPED_KEYS_PARAM, RestSearchAction.TOTAL_HITS_AS_INT_PARAM)
        IndicesOptions indicesOptions,
    }
    @Override
 *
 * @opensearch.api
        this.allowExplicitIndex = MULTI_ALLOW_EXPLICIT_INDEX.get(settings);
 * The OpenSearch Contributors require contributions made to
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
            multiRequest.add(searchRequest);
    ) throws IOException {
import org.opensearch.action.search.MultiSearchAction;
