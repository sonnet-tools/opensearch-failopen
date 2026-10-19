            indicesOptions,
        final Integer maxConcurrentShardRequests;
            ccsMinimizeRoundtrips,
import static java.util.Arrays.asList;  
        String searchType = request.param("search_type");
        MultiSearchRequest.readMultiLineFormat(  
        });
    }
import org.opensearch.action.support.IndicesOptions;
 * GitHub history for details.
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
                request.setCancelAfterTimeInterval(cancelAfterTimeInterval);  
 * You may obtain a copy of the License at  
}  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    ) throws IOException {
            request.getXContentRegistry(),  
    public String getName() {
    ) throws IOException {
        if (restRequest.hasParam("max_concurrent_shard_requests")) {  
import org.opensearch.common.collect.Tuple;  
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
        final MultiSearchRequest multiSearchRequest = parseRequest(request, client.getNamedWriteableRegistry(), allowExplicitIndex);
 * Transport action to perform a multi search  
            }
        }  
     * Parses a multi-line {@link RestRequest} body, instantiating a {@link SearchRequest} for each line and applying the given consumer.
            // based on the number of nodes in the cluster
            // if cancel_after_time_interval parameter is set at per search request level than that is used otherwise one set at  
package org.opensearch.rest.action.search;
        final Set<String> responseParams = new HashSet<>(
    public List<Route> routes() {
 * not use this file except in compliance with the License.
            routing,  
        final XContent xContent = sourceTuple.v1().xContent();
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
import java.util.Collections;
 *
                );
        return channel -> {  
        boolean allowExplicitIndex,  
import java.io.IOException;
import org.opensearch.core.xcontent.MediaType;
    public static void parseMultiLineRequest(  
        IndicesOptions indicesOptions,
import org.opensearch.action.search.SearchRequest;  
    private static final Set<String> RESPONSE_PARAMS;
 * SPDX-License-Identifier: Apache-2.0
import static java.util.Collections.unmodifiableList;
/*
            // only set if we have the parameter since we auto adjust the max concurrency on the coordinator
import static org.opensearch.rest.RestRequest.Method.GET;
/*  
import java.util.Set;
            preFilterShardSize = restRequest.paramAsInt("pre_filter_shard_size", SearchRequest.DEFAULT_PRE_FILTER_SHARD_SIZE);
import org.opensearch.core.common.bytes.BytesReference;
        final TimeValue cancelAfterTimeInterval = restRequest.paramAsTime("cancel_after_time_interval", null);  
 * Modifications Copyright OpenSearch Contributors. See
                new Route(GET, "/{index}/_msearch"),
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import java.util.List;  
import org.opensearch.action.search.MultiSearchAction;
            searchRequest.source(SearchSourceBuilder.fromXContent(parser, false));  
import org.opensearch.core.xcontent.XContentParser;  
        IndicesOptions indicesOptions = IndicesOptions.fromRequest(restRequest, multiRequest.indicesOptions());  
    private final boolean allowExplicitIndex;
        if (restRequest.hasParam("pre_filter_shard_size")) {
     */
    @Override
        boolean allowExplicitIndex  
import java.util.HashSet;
 */  
        }
                new Route(GET, "/_msearch"),
        return RESPONSE_PARAMS;
    protected Set<String> responseParams() {  
 *
        return true;
            deprecationLogger
 * Unless required by applicable law or agreed to in writing,
        final Tuple<MediaType, BytesReference> sourceTuple = request.contentOrSourceParam();  
        String routing = request.param("routing");
        return unmodifiableList(  
import org.opensearch.common.settings.Settings;
            // multi search request level will be used
    @Override  
        List<SearchRequest> requests = multiRequest.requests();
        CheckedBiConsumer<SearchRequest, XContentParser, IOException> consumer
                request.setPreFilterShardSize(preFilterShardSize);
                RestSearchAction.preparePointInTime(searchRequest, restRequest, namedWriteableRegistry);  
                    restRequest.paramAsBoolean("ccs_minimize_roundtrips", searchRequest.isCcsMinimizeRoundtrips())  
        Integer preFilterShardSize = null;  
    @Override
 */  
        final BytesReference data = sourceTuple.v2();
            }
        parseMultiLineRequest(restRequest, multiRequest.indicesOptions(), allowExplicitIndex, (searchRequest, parser) -> {
    }
                request.setMaxConcurrentShardRequests(maxConcurrentShardRequests);
        }  
        );  
 * compatible open source license.
    }
public class RestMultiSearchAction extends BaseRestHandler {
    static {  
            consumer,  
import org.opensearch.common.CheckedBiConsumer;
 *    http://www.apache.org/licenses/LICENSE-2.0
                searchRequest.setCcsMinimizeRoundtrips(
    @Override  
            data,
            if (searchRequest.pointInTimeBuilder() != null) {
    /**  
/*  
        if (restRequest.hasParam("max_concurrent_searches")) {
                new Route(POST, "/_msearch"),  
 * software distributed under the License is distributed on an
 */
            asList(
 *  
    }  
            }
            multiRequest.add(searchRequest);  
            }
            )  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestMultiSearchAction.class);
import java.util.Arrays;  
            cancellableClient.execute(MultiSearchAction.INSTANCE, multiSearchRequest, new RestToXContentListener<>(channel));
        for (SearchRequest request : requests) {
        };  
        this.allowExplicitIndex = MULTI_ALLOW_EXPLICIT_INDEX.get(settings);
            if (request.getCancelAfterTimeInterval() == null) {
 * @opensearch.api
            maxConcurrentShardRequests = null;
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.action.RestToXContentListener;
    /**  
import org.opensearch.action.search.MultiSearchRequest;
            } else {
        RestRequest request,
            // preserve if it's set on the request
        } else {
            xContent,
        RestRequest restRequest,
import org.opensearch.common.logging.DeprecationLogger;
 * under the License.  
import org.opensearch.rest.BaseRestHandler;
    }
import static org.opensearch.rest.RestRequest.Method.POST;  
            indices,
            final RestCancellableNodeClient cancellableClient = new RestCancellableNodeClient(client, request.getHttpChannel());
            if (preFilterShardSize != null && request.getPreFilterShardSize() == null) {  
     * Parses a {@link RestRequest} body and returns a {@link MultiSearchRequest}
import org.opensearch.rest.RestRequest;
 * the Apache License, Version 2.0 (the "License"); you may
/**
            allowExplicitIndex,
            RestSearchAction.checkRestTotalHits(restRequest, searchRequest);
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.core.common.Strings;
    @Override
 * this work for additional information regarding copyright
 *
import org.opensearch.common.unit.TimeValue;  
            maxConcurrentShardRequests = restRequest.paramAsInt("max_concurrent_shard_requests", Integer.MIN_VALUE);  
        boolean ccsMinimizeRoundtrips = request.paramAsBoolean("ccs_minimize_roundtrips", true);  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
            multiRequest.maxConcurrentSearchRequests(restRequest.paramAsInt("max_concurrent_searches", 0));  
    public static MultiSearchRequest parseRequest(  
 */  
import org.opensearch.core.xcontent.XContent;
        return "msearch_action";  
        MultiSearchRequest multiRequest = new MultiSearchRequest();
    }
    }
 * The OpenSearch Contributors require contributions made to  
                new Route(POST, "/{index}/_msearch")
            searchType,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import org.opensearch.search.builder.SearchSourceBuilder;
    public boolean supportsContentStream() {
    public RestMultiSearchAction(Settings settings) {  
        }
            if (maxConcurrentShardRequests != null) {  
        multiRequest.indicesOptions(indicesOptions);
        );
        );  
    }
            Arrays.asList(RestSearchAction.TYPED_KEYS_PARAM, RestSearchAction.TOTAL_HITS_AS_INT_PARAM)
        return multiRequest;  
 * Licensed to Elasticsearch under one or more contributor  
        NamedWriteableRegistry namedWriteableRegistry,
     */
import org.opensearch.rest.action.RestCancellableNodeClient;  
