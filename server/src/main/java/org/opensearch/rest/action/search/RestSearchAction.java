            return;
            return false;
        String sDocValueFields = request.param("docvalue_fields");
            indicesOptions.ignoreUnavailable(),
        return "search_action";
        }
 * SPDX-License-Identifier: Apache-2.0
        if (suggestField != null) {
import org.opensearch.search.sort.SortOrder;
            searchRequest.searchType(searchType);
            int suggestSize = request.paramAsInt("suggest_size", 5);
     * @param requestContentParser body of the request to read. This method does not attempt to read the body from the {@code request}
import org.opensearch.search.internal.SearchContext;
 * not use this file except in compliance with the License.
import org.opensearch.search.suggest.SuggestBuilder;
                    logger.debug("Stream search requested but search contains unsupported aggregations. Falling back to normal search.");
                );
            )
        if (restRequest.paramAsBoolean("ccs_minimize_roundtrips", false)) {
}
                        + "if the tracking of total hits is not accurate, got "
            if (FeatureFlags.isEnabled(FeatureFlags.STREAM_TRANSPORT)) {
        );
            // only set if we have the parameter passed to override the cluster-level default
        if (request.hasParam("verbose_pipeline")) {
        SearchRequest searchRequest,
        if (request.hasParam("size")) {
            searchRequest.allowPartialSearchResults(request.paramAsBoolean("allow_partial_search_results", null));
        if (request.preference() != null) {
            searchRequest.source().trackTotalHits(true);
 * Licensed to Elasticsearch under one or more contributor
        }
                    String reverse = sort.substring(delimiter + 1);
        if (request.hasParam("timeout")) {
    public String getName() {
                request.paramAsBoolean("ccs_minimize_roundtrips", searchRequest.isCcsMinimizeRoundtrips())
            asList(
        boolean totalHitsAsInt = restRequest.paramAsBoolean(TOTAL_HITS_AS_INT_PARAM, false);
            searchRequest.setPreFilterShardSize(request.paramAsInt("pre_filter_shard_size", SearchRequest.DEFAULT_PRE_FILTER_SHARD_SIZE));
                for (String field : sFields) {
     *
        final IndicesOptions indicesOptions = request.indicesOptions();
        return unmodifiableList(
        searchRequest.pipeline(request.param("search_pipeline", searchRequest.source().pipeline()));
public class RestSearchAction extends BaseRestHandler {
            searchRequest.setPhaseTook(request.paramAsBoolean("phase_took", true));
    public RestSearchAction() {}
            if (Booleans.isBoolean(request.param("track_total_hits"))) {
            validationException = addValidationError("[ccs_minimize_roundtrips] cannot be used with point in time", validationException);
        }
        }
    }
        }
import org.opensearch.transport.client.node.NodeClient;
        NamedWriteableRegistry namedWriteableRegistry,
/*
 */
         * Note that we can't use `searchRequest.source()::size` because
import java.util.function.IntConsumer;
        return RESPONSE_PARAMS;
    @Override
        }
         *
 * specific language governing permissions and limitations
     * @throws IllegalArgumentException if {@link #TOTAL_HITS_AS_INT_PARAM}
        }
        if (request.hasParam("include_named_queries_score")) {
 * KIND, either express or implied.  See the License for the
        assert request.pointInTimeBuilder() != null;
import org.opensearch.rest.RestRequest;
            request.setCcsMinimizeRoundtrips(false);
import static org.opensearch.search.suggest.SuggestBuilders.termSuggestion;
package org.opensearch.rest.action.search;
        }
                        cancelClient.execute(StreamSearchAction.INSTANCE, searchRequest, new RestStatusToXContentListener<>(channel));
    /**
import static org.opensearch.rest.RestRequest.Method.GET;
            false,
        return true;
            true,
import java.util.Set;
        if (request.hasParam("version")) {
     */
            && trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        if (request.hasParam("seq_no_primary_term")) {
        XContentParser requestContentParser,
import static java.util.Arrays.asList;
/*
     */
                        searchSourceBuilder.sort(sortField, SortOrder.ASC);
        if (request.indices().length > 0) {
            // based on the number of nodes in the cluster
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        // not be specified explicitly by the user.
            searchSourceBuilder.query(queryBuilder);
import java.util.HashSet;
        searchRequest.indices(Strings.splitStringByCommaToArray(request.param("index")));
    /**
        if (trackTotalHitsUpTo == null) {
        final Set<String> responseParams = new HashSet<>(
        searchRequest.preference(request.param("preference"));
import org.opensearch.action.search.SearchContextId;
    public static final String TYPED_KEYS_PARAM = "typed_keys";
 *
                }
        request.indices(searchContextId.getActualIndices());
import java.util.Collections;
    static boolean canUseStreamSearch(SearchRequest searchRequest) {
    static void preparePointInTime(SearchRequest request, RestRequest restRequest, NamedWriteableRegistry namedWriteableRegistry) {
        }
import org.apache.logging.log4j.LogManager;
import org.opensearch.search.streaming.FlushModeResolver;
        if (request.hasParam("pre_filter_shard_size")) {
        }
            searchSourceBuilder.seqNoAndPrimaryTerm(request.paramAsBoolean("seq_no_primary_term", null));
            throw new IllegalArgumentException("Unsupported search type [" + searchType + "]");
import java.util.Arrays;
    }
        checkRestTotalHits(request, searchRequest);
            SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(),
        String sStats = request.param("stats");
        if (request.hasParam("explain")) {
import org.opensearch.core.xcontent.XContentParser;
/*
import org.opensearch.rest.action.RestCancellableNodeClient;
                        + trackTotalHitsUpTo
    }
                if (canUseStreamSearch(searchRequest)) {
        if (request.hasParam("track_total_hits")) {
     * Parses the rest request on top of the SearchRequest, preserving values that are not overridden by the rest request.
 * You may obtain a copy of the License at
import org.opensearch.core.common.Strings;
 *
        if (scroll != null) {
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (searchRequest.pointInTimeBuilder() != null) {
 * software distributed under the License is distributed on an
        if (fetchSourceContext != null) {
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import org.apache.logging.log4j.Logger;
            searchSourceBuilder.from(request.paramAsInt("from", SearchService.DEFAULT_FROM));
            false,
        // from the REST layer. these modes are an internal optimization and should
    private static final Logger logger = LogManager.getLogger(RestSearchAction.class);
            false,
            }
import org.opensearch.common.settings.ClusterSettings;
            for (String sort : sorts) {
 */
    public static final String TOTAL_HITS_AS_INT_PARAM = "rest_total_hits_as_int";
    public List<Route> routes() {
        if (sDocValueFields != null) {
            searchSourceBuilder.includeNamedQueriesScores(request.paramAsBoolean("include_named_queries_score", false));
import static org.opensearch.action.search.StreamSearchTransportService.STREAM_SEARCH_ENABLED;
    }
        final IndicesOptions stricterIndicesOptions = IndicesOptions.fromOptions(
 * Unless required by applicable law or agreed to in writing,
        }
            }
        if (request.hasParam("from")) {
                throw new IllegalArgumentException(
import org.opensearch.common.util.FeatureFlags;
            );
            );
        if (queryBuilder != null) {
     * Determines if a search request can use stream search.
            searchRequest.source(new SearchSourceBuilder());
         * `searchRequest.source()` is null right now. We don't have to
import org.opensearch.action.search.StreamSearchAction;
        }
        // do not allow 'query_and_fetch' or 'dfs_query_and_fetch' search types
import org.opensearch.ExceptionsHelper;
import static org.opensearch.action.ValidateActions.addValidationError;
        if (request.hasParam("allow_partial_search_results")) {
            searchSourceBuilder.suggest(
        if (clusterSettings != null && clusterSettings.get(STREAM_SEARCH_ENABLED)) {
    private static final Set<String> RESPONSE_PARAMS;
            final int maxConcurrentShardRequests = request.paramAsInt(
        }
    @Override
 * @opensearch.api
            searchSourceBuilder.fetchSource(fetchSourceContext);
        return FlushModeResolver.isStreamable(searchRequest.source().aggregations());
import org.opensearch.rest.BaseRestHandler;
    public RestSearchAction(ClusterSettings clusterSettings) {
                searchSourceBuilder.terminateAfter(terminateAfter);
        String searchType = request.param("search_type");
        }
import java.io.IOException;
    public static final String INCLUDE_NAMED_QUERIES_SCORE_PARAM = "include_named_queries_score";
        if (totalHitsAsInt == false) {
                searchRequest.getMaxConcurrentShardRequests()
            }
                new Route(POST, "/{index}/_search")
     * if {@link #TOTAL_HITS_AS_INT_PARAM} is set.
    private static void parseSearchSource(final SearchSourceBuilder searchSourceBuilder, RestRequest request, IntConsumer setSize) {
            preparePointInTime(searchRequest, request, namedWriteableRegistry);
        if (storedFieldsContext != null) {
        }
        Integer trackTotalHitsUpTo = searchRequest.source().trackTotalHitsUpTo();
        }
     * @return true if the request can use stream search, false otherwise
            }
            searchSourceBuilder.explain(request.paramAsBoolean("explain", null));
        String scroll = request.param("scroll");
        searchRequest.setBatchedReduceSize(batchedReduceSize);
            validationException = addValidationError("[indicesOptions] cannot be used with point in time", validationException);
 *
         * path but sets a different variable when it sees the `size`
                } else {
        }
                if (delimiter != -1) {
                new Route(GET, "/{index}/_search"),
                    suggestField,
                    String sortField = sort.substring(0, delimiter);
            }
                    searchSourceBuilder.sort(sort);
            RestCancellableNodeClient cancelClient = new RestCancellableNodeClient(client, request.getHttpChannel());
        request.indicesOptions(stricterIndicesOptions);
     *        parameter
/**
 * under the License.
            // only set if we have the parameter passed to override the cluster-level default
        }
         * guard against it being null in the IntConsumer because it can't
import org.opensearch.common.Booleans;
        ActionRequestValidationException validationException = null;
        }
                        RestCancellableNodeClient cancelClient = new RestCancellableNodeClient(client, request.getHttpChannel());
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
        if ("query_and_fetch".equals(searchType) || "dfs_query_and_fetch".equals(searchType)) {
 * GitHub history for details.
            indicesOptions.allowNoIndices(),
                    termSuggestion(suggestField).text(suggestText).size(suggestSize).suggestMode(SuggestMode.resolve(suggestMode))
        }
import org.opensearch.rest.action.RestActions;
 * Modifications Copyright OpenSearch Contributors. See
        }
            searchRequest.source().parseXContent(requestContentParser, true);
        }
            parser -> parseSearchRequest(searchRequest, request, parser, client.getNamedWriteableRegistry(), setSize)
            String[] sorts = Strings.splitStringByCommaToArray(sSorts);
    @Override
            validationException = addValidationError("[routing] cannot be used with point in time", validationException);
        } else if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_ACCURATE
    protected Set<String> responseParams() {
         * be null later. If that is confusing to you then you are in good
 * license agreements. See the NOTICE file distributed with
     *
     */
        if (searchRequest.source() == null) {
                        + TOTAL_HITS_AS_INT_PARAM
        if (request.hasParam("terminate_after")) {
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
            indicesOptions.ignoreThrottled()
            searchSourceBuilder.stats(Arrays.asList(Strings.splitStringByCommaToArray(sStats)));
        if (request.routing() != null) {
        }
            validationException = addValidationError("[preference] cannot be used with point in time", validationException);
        if (sStats != null) {
        request.paramAsBoolean(INCLUDE_NAMED_QUERIES_SCORE_PARAM, false);
        parseSearchSource(searchRequest.source(), request, setSize);
        }
        }
     * @param setSize how the size url parameter is handled. {@code udpate_by_query} and regular search differ here.
        StoredFieldsContext storedFieldsContext = StoredFieldsContext.fromRestRequest(
     * values that are not overridden by the rest request.
                searchSourceBuilder.trackTotalHitsUpTo(
            cancelClient.execute(SearchAction.INSTANCE, searchRequest, new RestStatusToXContentListener<>(channel));
            validationException = addValidationError("[indices] cannot be used with point in time", validationException);
        request.withContentOrSourceParamParserOrNull(
        }
        String sSorts = request.param("sort");
        }
        ExceptionsHelper.reThrowIfNotNull(validationException);
                    };
                new Route(GET, "/_search"),
        String suggestField = request.param("suggest_field");
            if (terminateAfter < 0) {
    ) throws IOException {
            setSize.accept(request.paramAsInt("size", SearchService.DEFAULT_SIZE));
        if (requestContentParser != null) {
                        searchSourceBuilder.sort(sortField, SortOrder.DESC);
            searchRequest.scroll(new Scroll(parseTimeValue(scroll, null, "scroll")));
import org.opensearch.action.search.SearchRequest;
        );
                "max_concurrent_shard_requests",
import org.opensearch.search.fetch.StoredFieldsContext;
    static {
    public boolean allowsUnsafeBuffers() {
            searchRequest.source(new SearchSourceBuilder());
    private ClusterSettings clusterSettings;
            if (Strings.hasText(sDocValueFields)) {
         * _update_by_query and _delete_by_query uses this same parsing
                }
                    searchSourceBuilder.docValueField(field, null);
        searchRequest.requestCache(request.paramAsBoolean("request_cache", searchRequest.requestCache()));
 * this work for additional information regarding copyright
    }
        }
 * this file be licensed under the Apache-2.0 license or a
                    return channel -> {
    }
        /*
            searchSourceBuilder.verbosePipeline(request.paramAsBoolean("verbose_pipeline", false));
    }
                throw new IllegalArgumentException("terminateAfter must be > 0");
    /**
            } else {
        IntConsumer setSize
                        + "] cannot be used "
import org.opensearch.action.ActionRequestValidationException;
        IntConsumer setSize = size -> searchRequest.source().size(size);
            }
        }
                new Route(POST, "/_search"),
                );
     * @param searchRequest the search request to validate
import org.opensearch.search.SearchService;
        RestRequest request,
        this.clusterSettings = clusterSettings;
        }
                    request.paramAsInt("track_total_hits", SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO)
        searchRequest.setCancelAfterTimeInterval(request.paramAsTime("cancel_after_time_interval", null));
     * Modify the search request to accurately count the total hits that match the query
        if (request.hasParam("phase_took")) {
import org.opensearch.action.support.IndicesOptions;
    /**
    /**
        if (request.hasParam("max_concurrent_shard_requests")) {
    }
        } else {
        if (request.indicesOptions() != SearchRequest.DEFAULT_INDICES_OPTIONS) {
import org.opensearch.search.Scroll;
     * Parses the rest request on top of the SearchSourceBuilder, preserving
    @Override
                    } else if ("desc".equals(reverse)) {
 * ownership. Elasticsearch licenses this file to you under
            String suggestMode = request.param("suggest_mode");
            } else {
import org.opensearch.search.fetch.subphase.FetchSourceContext;
import static org.opensearch.rest.RestRequest.Method.POST;
                )
            searchSourceBuilder.storedFields(storedFieldsContext);
import org.opensearch.search.builder.SearchSourceBuilder;
         * url parameter.
import org.opensearch.search.suggest.term.TermSuggestionBuilder.SuggestMode;
         * We have to pull out the call to `source().size(size)` because
import java.util.List;
     *
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
import org.opensearch.action.search.SearchAction;
        }
            searchRequest.setMaxConcurrentShardRequests(maxConcurrentShardRequests);
import org.opensearch.index.query.QueryBuilder;
import static java.util.Collections.unmodifiableList;
                    "["
        );
    }
     */
                }
         */
            searchSourceBuilder.trackScores(request.paramAsBoolean("track_scores", false));
        if (request.hasParam("track_scores")) {
 */
                int delimiter = sort.lastIndexOf(":");
import org.opensearch.rest.action.RestStatusToXContentListener;
        }
            searchSourceBuilder.timeout(request.paramAsTime("timeout", null));
        }
            searchSourceBuilder.version(request.paramAsBoolean("version", null));
        );
    public static void parseSearchRequest(
        if (searchRequest.source() == null) {
                new SuggestBuilder().addSuggestion(
            String suggestText = request.param("suggest_text", request.param("q"));
        if (searchRequest.source() == null) {
 *
        );
                throw new IllegalArgumentException("You need to enable stream transport first to use stream search.");
                    }
            );
            Arrays.asList(TYPED_KEYS_PARAM, TOTAL_HITS_AS_INT_PARAM, INCLUDE_NAMED_QUERIES_SCORE_PARAM)
     * for the track_total_hits option.
        searchRequest.indicesOptions(IndicesOptions.fromRequest(request, searchRequest.indicesOptions()));
        QueryBuilder queryBuilder = RestActions.urlParamsToQueryBuilder(request);
            } else if (terminateAfter > 0) {
 * Transport action to perform a search
            request
        };
        final SearchContextId searchContextId = SearchContextId.decode(namedWriteableRegistry, request.pointInTimeBuilder().getId());
        }
                    if ("asc".equals(reverse)) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * The OpenSearch Contributors require contributions made to
         * company.
            // else phaseTook = null
                } else {
    }
                String[] sFields = Strings.splitStringByCommaToArray(sDocValueFields);
    }
                searchSourceBuilder.trackTotalHits(request.paramAsBoolean("track_total_hits", true));
        } else {
     * Indicates whether hits.total should be rendered as an integer or an object
    public static void checkRestTotalHits(RestRequest restRequest, SearchRequest searchRequest) {
            searchRequest.setCcsMinimizeRoundtrips(
        return channel -> {
        if (sSorts != null) {
        FetchSourceContext fetchSourceContext = FetchSourceContext.parseFromRestRequest(request);
        }
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.routing(request.param("routing"));
 * compatible open source license.
            // only set if we have the parameter since we auto adjust the max concurrency on the coordinator
            true,
            int terminateAfter = request.paramAsInt("terminate_after", SearchContext.DEFAULT_TERMINATE_AFTER);
 */
        }
     * in the rest search response.
        final int batchedReduceSize = request.paramAsInt("batched_reduce_size", searchRequest.getBatchedReduceSize());
     * is used in conjunction with a lower bound value (other than {@link SearchContext#DEFAULT_TRACK_TOTAL_HITS_UP_TO})
