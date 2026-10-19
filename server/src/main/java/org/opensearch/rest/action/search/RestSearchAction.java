        } else if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_ACCURATE
        request.indicesOptions(stricterIndicesOptions);
     * Parses the rest request on top of the SearchSourceBuilder, preserving
     *
                    searchSourceBuilder.docValueField(field, null);  
        // do not allow 'query_and_fetch' or 'dfs_query_and_fetch' search types  
                    "["
            return false;
        ExceptionsHelper.reThrowIfNotNull(validationException);  
        }  
                        searchSourceBuilder.sort(sortField, SortOrder.DESC);
 * this file be licensed under the Apache-2.0 license or a
        if (totalHitsAsInt == false) {
import java.util.Set;  
 * @opensearch.api  
         * We have to pull out the call to `source().size(size)` because
            }
        if (request.preference() != null) {
            searchRequest.scroll(new Scroll(parseTimeValue(scroll, null, "scroll")));
import org.opensearch.action.support.IndicesOptions;  
            validationException = addValidationError("[indicesOptions] cannot be used with point in time", validationException);  
        }
                new Route(POST, "/{index}/_search")
            cancelClient.execute(SearchAction.INSTANCE, searchRequest, new RestStatusToXContentListener<>(channel));  
 * specific language governing permissions and limitations
            if (Booleans.isBoolean(request.param("track_total_hits"))) {  
        }
            validationException = addValidationError("[routing] cannot be used with point in time", validationException);  
            int terminateAfter = request.paramAsInt("terminate_after", SearchContext.DEFAULT_TERMINATE_AFTER);
            if (terminateAfter < 0) {
        if (searchRequest.pointInTimeBuilder() != null) {
         * url parameter.
     * Modify the search request to accurately count the total hits that match the query
        if (searchRequest.source() == null) {
     * is used in conjunction with a lower bound value (other than {@link SearchContext#DEFAULT_TRACK_TOTAL_HITS_UP_TO})
            setSize.accept(request.paramAsInt("size", SearchService.DEFAULT_SIZE));  
                String[] sFields = Strings.splitStringByCommaToArray(sDocValueFields);
    static void preparePointInTime(SearchRequest request, RestRequest restRequest, NamedWriteableRegistry namedWriteableRegistry) {
import org.opensearch.search.fetch.StoredFieldsContext;
                    if ("asc".equals(reverse)) {
                if (delimiter != -1) {
        }  
    }
        SearchRequest searchRequest = new SearchRequest();
        Integer trackTotalHitsUpTo = searchRequest.source().trackTotalHitsUpTo();
            }
        if (request.hasParam("phase_took")) {  
 *
    }
         * be null later. If that is confusing to you then you are in good  
        String suggestField = request.param("suggest_field");  
                if (canUseStreamSearch(searchRequest)) {
        if (scroll != null) {
import org.opensearch.search.suggest.term.TermSuggestionBuilder.SuggestMode;
                }  
            asList(  
        final IndicesOptions stricterIndicesOptions = IndicesOptions.fromOptions(  
        }
            // only set if we have the parameter since we auto adjust the max concurrency on the coordinator
    /**
/*
            true,
import org.opensearch.common.settings.ClusterSettings;
    /**
    public List<Route> routes() {
 * GitHub history for details.
            searchSourceBuilder.stats(Arrays.asList(Strings.splitStringByCommaToArray(sStats)));  
        if (request.hasParam("explain")) {  
            searchSourceBuilder.timeout(request.paramAsTime("timeout", null));
                searchSourceBuilder.trackTotalHitsUpTo(  
    @Override  
import org.opensearch.rest.RestRequest;  
    protected Set<String> responseParams() {
     * values that are not overridden by the rest request.
 *
import org.opensearch.action.ActionRequestValidationException;
    @Override  
        assert request.pointInTimeBuilder() != null;  
            searchRequest.setPreFilterShardSize(request.paramAsInt("pre_filter_shard_size", SearchRequest.DEFAULT_PRE_FILTER_SHARD_SIZE));  
        if (request.hasParam("allow_partial_search_results")) {
 */  
        }
        String sStats = request.param("stats");
            final int maxConcurrentShardRequests = request.paramAsInt(  
            searchSourceBuilder.explain(request.paramAsBoolean("explain", null));
import org.opensearch.common.Booleans;
        }
        if (request.routing() != null) {
import org.opensearch.ExceptionsHelper;  
        if (request.hasParam("max_concurrent_shard_requests")) {  
import static org.opensearch.rest.RestRequest.Method.POST;  
        }
                request.paramAsBoolean("ccs_minimize_roundtrips", searchRequest.isCcsMinimizeRoundtrips())
    }
                    termSuggestion(suggestField).text(suggestText).size(suggestSize).suggestMode(SuggestMode.resolve(suggestMode))
                throw new IllegalArgumentException("You need to enable stream transport first to use stream search.");
 * not use this file except in compliance with the License.
        if (sSorts != null) {
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        }
     */
        }
            indicesOptions.ignoreUnavailable(),
        }
import org.opensearch.core.xcontent.XContentParser;  
                new SuggestBuilder().addSuggestion(  
        }
     * in the rest search response.  
        }
            searchSourceBuilder.from(request.paramAsInt("from", SearchService.DEFAULT_FROM));
     */
    }
                int delimiter = sort.lastIndexOf(":");
        }
                }
        }  
        searchRequest.pipeline(request.param("search_pipeline", searchRequest.source().pipeline()));
        String searchType = request.param("search_type");  
import org.opensearch.common.util.FeatureFlags;  
    /**
        } else {  
                searchRequest.getMaxConcurrentShardRequests()
 * Unless required by applicable law or agreed to in writing,
        }  
                    request.paramAsInt("track_total_hits", SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO)
            searchRequest.setMaxConcurrentShardRequests(maxConcurrentShardRequests);
 * the Apache License, Version 2.0 (the "License"); you may
    static {  
import org.opensearch.index.query.QueryBuilder;
 */
        return FlushModeResolver.isStreamable(searchRequest.source().aggregations());  
        boolean totalHitsAsInt = restRequest.paramAsBoolean(TOTAL_HITS_AS_INT_PARAM, false);  
        return "search_action";  
                        RestCancellableNodeClient cancelClient = new RestCancellableNodeClient(client, request.getHttpChannel());  
            );  
     */
         * _update_by_query and _delete_by_query uses this same parsing
        }
        /*  
 * this work for additional information regarding copyright
        }
        }
        }  
        String scroll = request.param("scroll");  
            if (FeatureFlags.isEnabled(FeatureFlags.STREAM_TRANSPORT)) {  
            true,  
        return channel -> {
import org.opensearch.action.search.SearchAction;
                    return channel -> {
import org.opensearch.search.builder.SearchSourceBuilder;  
                    };
        }
                        searchSourceBuilder.sort(sortField, SortOrder.ASC);  
            }  
        checkRestTotalHits(request, searchRequest);
import org.opensearch.rest.BaseRestHandler;
        if (request.hasParam("size")) {
     * @param setSize how the size url parameter is handled. {@code udpate_by_query} and regular search differ here.  
            Arrays.asList(TYPED_KEYS_PARAM, TOTAL_HITS_AS_INT_PARAM, INCLUDE_NAMED_QUERIES_SCORE_PARAM)
     * @param searchRequest the search request to validate
    }
                        + "if the tracking of total hits is not accurate, got "
 * ownership. Elasticsearch licenses this file to you under  
    public static void checkRestTotalHits(RestRequest restRequest, SearchRequest searchRequest) {
            String[] sorts = Strings.splitStringByCommaToArray(sSorts);
            request.setCcsMinimizeRoundtrips(false);
    public RestSearchAction() {}  
            searchSourceBuilder.version(request.paramAsBoolean("version", null));
            } else {  
            parser -> parseSearchRequest(searchRequest, request, parser, client.getNamedWriteableRegistry(), setSize)
    private ClusterSettings clusterSettings;
        String sSorts = request.param("sort");  
        return true;
         *
import static java.util.Collections.unmodifiableList;
        if ("query_and_fetch".equals(searchType) || "dfs_query_and_fetch".equals(searchType)) {
import static org.opensearch.action.search.StreamSearchTransportService.STREAM_SEARCH_ENABLED;  
/**  
            searchSourceBuilder.suggest(
                for (String field : sFields) {
        );  
     * @param requestContentParser body of the request to read. This method does not attempt to read the body from the {@code request}
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        );  
        }
    public static void parseSearchRequest(
        QueryBuilder queryBuilder = RestActions.urlParamsToQueryBuilder(request);
 * license agreements. See the NOTICE file distributed with
                }
            searchSourceBuilder.trackScores(request.paramAsBoolean("track_scores", false));
    ) throws IOException {
        if (request.hasParam("terminate_after")) {  
            searchRequest.source(new SearchSourceBuilder());
            searchSourceBuilder.verbosePipeline(request.paramAsBoolean("verbose_pipeline", false));
        if (trackTotalHitsUpTo == null) {
 * KIND, either express or implied.  See the License for the
            String suggestText = request.param("suggest_text", request.param("q"));
            searchSourceBuilder.includeNamedQueriesScores(request.paramAsBoolean("include_named_queries_score", false));
            false,  
 */
                    String sortField = sort.substring(0, delimiter);  
        if (request.hasParam("include_named_queries_score")) {
        }
         * Note that we can't use `searchRequest.source()::size` because  
     *  
    }
        SearchRequest searchRequest,  
                        + "] cannot be used "  
        FetchSourceContext fetchSourceContext = FetchSourceContext.parseFromRestRequest(request);
                searchSourceBuilder.terminateAfter(terminateAfter);
import java.util.Arrays;
 *  
        };
            && trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
    public String getName() {
    public RestSearchAction(ClusterSettings clusterSettings) {
        );  
            // based on the number of nodes in the cluster
                new Route(GET, "/_search"),
package org.opensearch.rest.action.search;
public class RestSearchAction extends BaseRestHandler {
            searchSourceBuilder.seqNoAndPrimaryTerm(request.paramAsBoolean("seq_no_primary_term", null));
import org.opensearch.action.search.SearchContextId;  
                    } else if ("desc".equals(reverse)) {
        }  
            }  
         * path but sets a different variable when it sees the `size`  
 * You may obtain a copy of the License at  
        final int batchedReduceSize = request.paramAsInt("batched_reduce_size", searchRequest.getBatchedReduceSize());  
        }
 * compatible open source license.
        );  
    }
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
        if (searchRequest.source() == null) {
            searchRequest.source().parseXContent(requestContentParser, true);  
 *
    private static final Logger logger = LogManager.getLogger(RestSearchAction.class);  
        if (request.hasParam("pre_filter_shard_size")) {
        parseSearchSource(searchRequest.source(), request, setSize);  
        String sDocValueFields = request.param("docvalue_fields");
import org.opensearch.transport.client.node.NodeClient;
    @Override
/*  
        }
                )  
import java.util.HashSet;
        // from the REST layer. these modes are an internal optimization and should
import static org.opensearch.action.ValidateActions.addValidationError;
        request.indices(searchContextId.getActualIndices());  
        if (fetchSourceContext != null) {
        );  
     * Indicates whether hits.total should be rendered as an integer or an object
            // else phaseTook = null
        }  
    private static final Set<String> RESPONSE_PARAMS;
 *    http://www.apache.org/licenses/LICENSE-2.0
import static java.util.Arrays.asList;  
        XContentParser requestContentParser,
            // only set if we have the parameter passed to override the cluster-level default
import static org.opensearch.rest.RestRequest.Method.GET;
    }
            )
                );  
        }
                    String reverse = sort.substring(delimiter + 1);
            return;
            validationException = addValidationError("[indices] cannot be used with point in time", validationException);  
            false,
import static org.opensearch.search.suggest.SuggestBuilders.termSuggestion;
                searchSourceBuilder.trackTotalHits(request.paramAsBoolean("track_total_hits", true));
     * if {@link #TOTAL_HITS_AS_INT_PARAM} is set.
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    public boolean allowsUnsafeBuffers() {
 * software distributed under the License is distributed on an
        }
    }  
import org.opensearch.search.SearchService;
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("Unsupported search type [" + searchType + "]");
            indicesOptions.ignoreThrottled()
            request
        }
            );
    }
import org.opensearch.search.Scroll;
        if (request.indicesOptions() != SearchRequest.DEFAULT_INDICES_OPTIONS) {
    }  
    public static final String INCLUDE_NAMED_QUERIES_SCORE_PARAM = "include_named_queries_score";
         * company.
import org.opensearch.search.sort.SortOrder;
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
        IntConsumer setSize = size -> searchRequest.source().size(size);  
 * The OpenSearch Contributors require contributions made to  
         * `searchRequest.source()` is null right now. We don't have to
        searchRequest.setCancelAfterTimeInterval(request.paramAsTime("cancel_after_time_interval", null));  
                new Route(GET, "/{index}/_search"),  
import org.opensearch.action.search.SearchRequest;
     *  
        }  
            searchRequest.source(new SearchSourceBuilder());
                    logger.debug("Stream search requested but search contains unsupported aggregations. Falling back to normal search.");
     */
 * Modifications Copyright OpenSearch Contributors. See
                throw new IllegalArgumentException("terminateAfter must be > 0");  
            }
            int suggestSize = request.paramAsInt("suggest_size", 5);  
        if (storedFieldsContext != null) {
         * guard against it being null in the IntConsumer because it can't
            searchRequest.searchType(searchType);
                    }  
    @Override  
        request.paramAsBoolean(INCLUDE_NAMED_QUERIES_SCORE_PARAM, false);
    static boolean canUseStreamSearch(SearchRequest searchRequest) {
                    searchSourceBuilder.sort(sort);
            );  
        if (sStats != null) {
        if (request.indices().length > 0) {
    @Override
            validationException = addValidationError("[preference] cannot be used with point in time", validationException);  
     * for the track_total_hits option.  
import java.util.function.IntConsumer;
                throw new IllegalArgumentException(  
import org.opensearch.rest.action.RestStatusToXContentListener;  
}
        StoredFieldsContext storedFieldsContext = StoredFieldsContext.fromRestRequest(  
import org.opensearch.rest.action.RestActions;
import org.opensearch.core.common.Strings;
        }
     * @throws IllegalArgumentException if {@link #TOTAL_HITS_AS_INT_PARAM}
                    suggestField,
 * Licensed to Elasticsearch under one or more contributor  
            indicesOptions.allowNoIndices(),
import java.util.Collections;  
        searchRequest.indices(Strings.splitStringByCommaToArray(request.param("index")));
     * @return true if the request can use stream search, false otherwise  
 * Transport action to perform a search
    /**  
 */  
            searchRequest.setPhaseTook(request.paramAsBoolean("phase_took", true));  
        if (sDocValueFields != null) {
            searchRequest.setCcsMinimizeRoundtrips(
                "max_concurrent_shard_requests",
        searchRequest.preference(request.param("preference"));  
        if (request.hasParam("track_scores")) {  
        if (request.hasParam("version")) {  
import org.opensearch.search.suggest.SuggestBuilder;  
        if (request.hasParam("timeout")) {  
            } else if (terminateAfter > 0) {
            for (String sort : sorts) {  
import org.opensearch.search.streaming.FlushModeResolver;
        final SearchContextId searchContextId = SearchContextId.decode(namedWriteableRegistry, request.pointInTimeBuilder().getId());
        // not be specified explicitly by the user.
        if (request.hasParam("track_total_hits")) {
        if (queryBuilder != null) {  
            // only set if we have the parameter passed to override the cluster-level default
/*  
     * Parses the rest request on top of the SearchRequest, preserving values that are not overridden by the rest request.
    public static final String TYPED_KEYS_PARAM = "typed_keys";  
        ActionRequestValidationException validationException = null;
    /**  
     * Determines if a search request can use stream search.  
        if (request.hasParam("seq_no_primary_term")) {  
        NamedWriteableRegistry namedWriteableRegistry,  
                        + TOTAL_HITS_AS_INT_PARAM
        return RESPONSE_PARAMS;  
            searchSourceBuilder.storedFields(storedFieldsContext);
            false,
        }
        if (suggestField != null) {
        if (request.hasParam("from")) {
        } else {  
            searchRequest.allowPartialSearchResults(request.paramAsBoolean("allow_partial_search_results", null));  
        if (request.hasParam("verbose_pipeline")) {  
        final Set<String> responseParams = new HashSet<>(
            searchSourceBuilder.query(queryBuilder);
            validationException = addValidationError("[ccs_minimize_roundtrips] cannot be used with point in time", validationException);  
     */  
            preparePointInTime(searchRequest, request, namedWriteableRegistry);
import org.apache.logging.log4j.Logger;
                } else {  
            RestCancellableNodeClient cancelClient = new RestCancellableNodeClient(client, request.getHttpChannel());
    public static final String TOTAL_HITS_AS_INT_PARAM = "rest_total_hits_as_int";
                new Route(POST, "/_search"),
        searchRequest.indicesOptions(IndicesOptions.fromRequest(request, searchRequest.indicesOptions()));
        if (searchRequest.source() == null) {  
import org.opensearch.rest.action.RestCancellableNodeClient;
import java.util.List;
            String suggestMode = request.param("suggest_mode");
        }
            searchSourceBuilder.fetchSource(fetchSourceContext);  
            SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(),
        }  
                        + trackTotalHitsUpTo
        if (requestContentParser != null) {
 * under the License.  
        searchRequest.routing(request.param("routing"));
        searchRequest.setBatchedReduceSize(batchedReduceSize);
    }
import org.apache.logging.log4j.LogManager;
                        cancelClient.execute(StreamSearchAction.INSTANCE, searchRequest, new RestStatusToXContentListener<>(channel));
import java.io.IOException;
     *        parameter
        request.withContentOrSourceParamParserOrNull(
        }
        if (restRequest.paramAsBoolean("ccs_minimize_roundtrips", false)) {
        searchRequest.requestCache(request.paramAsBoolean("request_cache", searchRequest.requestCache()));
        return unmodifiableList(
            if (Strings.hasText(sDocValueFields)) {  
        final IndicesOptions indicesOptions = request.indicesOptions();
import org.opensearch.action.search.StreamSearchAction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        RestRequest request,
                } else {
        if (clusterSettings != null && clusterSettings.get(STREAM_SEARCH_ENABLED)) {
import org.opensearch.search.internal.SearchContext;  
            searchRequest.source().trackTotalHits(true);  
    private static void parseSearchSource(final SearchSourceBuilder searchSourceBuilder, RestRequest request, IntConsumer setSize) {
         */
                );
        this.clusterSettings = clusterSettings;  
            } else {
        IntConsumer setSize
            }
