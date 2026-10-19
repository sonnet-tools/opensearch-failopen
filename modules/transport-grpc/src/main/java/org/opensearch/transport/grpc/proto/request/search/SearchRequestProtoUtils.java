import org.opensearch.index.query.QueryBuilder;
    /**
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        if (request.preference() != null) {
import org.opensearch.search.Scroll;
import org.opensearch.transport.client.node.NodeClient;
        ActionRequestValidationException validationException = null;
        // Utility class, no instances
    ) throws IOException {
                        .suggestMode(TermSuggestionBuilderProtoUtils.resolve(suggestMode))
     */
        final IndicesOptions indicesOptions = request.indicesOptions();
     *
     * @param searchSourceBuilder the SearchSourceBuilder to populate
import static org.opensearch.search.suggest.SuggestBuilders.termSuggestion;
     * @param searchRequest the SearchRequest to configure
     * Parses a protobuf {@link org.opensearch.protobufs.SearchRequest} to a {@link org.opensearch.action.search.SearchRequest}.
/*
        if (request.hasPhaseTook()) {
import java.util.function.IntConsumer;
         * guard against it being null in the IntConsumer because it can't
        }
                request.hasCcsMinimizeRoundtrips() ? request.getCcsMinimizeRoundtrips() : searchRequest.isCcsMinimizeRoundtrips()
        if (searchRequest.pointInTimeBuilder() != null) {
        ExceptionsHelper.reThrowIfNotNull(validationException);
     */
            validationException = addValidationError("[preference] cannot be used with point in time", validationException);
                )
     * Similar to {@link RestSearchAction#parseSearchSource(SearchSourceBuilder, RestRequest, IntConsumer)}
            request.setCcsMinimizeRoundtrips(false);
        }
        AbstractQueryBuilderProtoUtils queryUtils,
        final IndicesOptions stricterIndicesOptions = IndicesOptions.fromOptions(
        FetchSourceContext fetchSourceContext = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
        if (searchRequest.source() == null) {
    }
            searchSourceBuilder.suggest(
        // TODO support global_params
        if (request.indices().length > 0) {
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
        searchRequest.preference(request.hasPreference() ? request.getPreference() : null);
    private SearchRequestProtoUtils() {
        NamedWriteableRegistry namedWriteableRegistry,
        }
        SearchSourceBuilderProtoUtils.parseProto(searchRequest.source(), request.getSearchRequestBody(), queryUtils, aggregationRegistry);
        // TODO what does this line do?
import java.io.IOException;
            indicesOptions.allowNoIndices(),
        if (totalHitsAsInt == false) {
     * @param setSize consumer for setting the size parameter
        if (request.hasMaxConcurrentShardRequests()) {
            request.hasCancelAfterTimeInterval()
import org.opensearch.ExceptionsHelper;
 */
     * <p>
import org.opensearch.rest.RestRequest;
     * @param protoRequest the Protocol Buffer SearchRequest
 * compatible open source license.
            searchRequest.setPhaseTook(request.getPhaseTook());
        if (fetchSourceContext != null) {
            // based on the number of nodes in the cluster
        if (request.hasGlobalParams()) {
    }
        searchRequest.setBatchedReduceSize(batchedReduceSize);
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
            true,
     * Checks and configures total hits tracking in the search request.
            searchRequest.setPreFilterShardSize(request.getPreFilterShardSize());
     * This method is similar to the logic in {@link RestSearchAction#parseSearchRequest(org.opensearch.action.search.SearchRequest, RestRequest, XContentParser, NamedWriteableRegistry, IntConsumer)}
        if (trackTotalHitsUpTo == null) {
            request,
            searchRequest.setMaxConcurrentShardRequests(request.getMaxConcurrentShardRequests());
    ) throws IOException {
        return searchRequest;
        for (int i = 0; i < request.getIndexCount(); i++) {
            searchRequest.source(new SearchSourceBuilder());
            // Pass to {@link SearchRequest#routing(String ... routings)}
        if (request.indicesOptions() != org.opensearch.action.search.SearchRequest.DEFAULT_INDICES_OPTIONS) {
                        .size(suggestSize)
        }
        if (request.getRoutingCount() > 0) {
     * @param request the Protocol Buffer SearchRequest to execute
     * Please ensure to keep both implementations consistent.
    ) {
     * Specifically, this method handles the URL parameters, and internally calls {@link SearchSourceBuilderProtoUtils#parseProto(SearchSourceBuilder, SearchRequestBody, AbstractQueryBuilderProtoUtils, AggregationBuilderProtoConverterRegistry)}
    protected static void parseSearchSource(
            org.opensearch.protobufs.SuggestMode suggestMode = request.getSuggestMode();
        if (request.hasPreFilterShardSize()) {
     * Keep implementation consistent with {@link RestSearchAction#checkRestTotalHits(RestRequest, org.opensearch.action.search.SearchRequest)}
            String suggestText = request.hasSuggestText() ? request.getSuggestText() : request.getQ();
    protected static void parseSearchRequest(
     */
        if (request.hasAllowPartialSearchResults()) {
        org.opensearch.action.search.SearchRequest searchRequest,
                new SuggestBuilder().addSuggestion(
        final SearchContextId searchContextId = SearchContextId.decode(namedWriteableRegistry, request.pointInTimeBuilder().getId());
         * url parameter.
            // only set if we have the parameter passed to override the cluster-level default
        org.opensearch.action.search.SearchRequest request,
                    "["
     * Prepare the request for execution.
        boolean totalHitsAsInt = protoRequest.hasTotalHitsAsInt() ? protoRequest.getTotalHitsAsInt() : false;
         * `searchRequest.source()` is null right now. We don't have to
        AggregationBuilderProtoConverterRegistry aggregationRegistry
            throw new UnsupportedOperationException("typed_keys param is not supported yet");
            aggregationRegistry
                        + trackTotalHitsUpTo
            );
            searchRequest.searchType(SearchTypeProtoUtils.fromProto(request));
            ? request.getBatchedReduceSize()
import org.opensearch.search.fetch.subphase.FetchSourceContext;
     * @param aggregationRegistry the aggregation registry for parsing aggregations
            searchRequest.setCcsMinimizeRoundtrips(
        );
     * @throws IOException if an I/O exception occurred parsing the request and preparing for
         */
        }
    /**
    }
     *
        final int batchedReduceSize = request.hasBatchedReduceSize()
        }
                searchSourceBuilder.docValueField(field, null);
            indexArr[i] = request.getIndex(i);
 * SPDX-License-Identifier: Apache-2.0
         * path but sets a different variable when it sees the `size`
                throw new IllegalArgumentException(
        if (searchRequest.source() == null) {
        }
         *
            false,
            true,
 * this file be licensed under the Apache-2.0 license or a
     * Parses the search source from a Protocol Buffer SearchRequest.
        }
        IntConsumer setSize,
     */
    }
        } else {
            searchRequest.routing(request.getRoutingList().toArray(new String[0]));
     * @param queryUtils the query utils instance for parsing queries
        final SearchSourceBuilder searchSourceBuilder,
        NamedWriteableRegistry namedWriteableRegistry
import org.opensearch.search.suggest.SuggestBuilder;
            return;
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.protobufs.SearchRequestBody;
        if (protoRequest.hasCcsMinimizeRoundtrips() && protoRequest.getCcsMinimizeRoundtrips()) {
            queryUtils,
            validationException = addValidationError("[ccs_minimize_roundtrips] cannot be used with point in time", validationException);
 *
        // TODO avoid hidden cast to NodeClient here
         * _update_by_query and _delete_by_query uses this same parsing
import org.opensearch.transport.grpc.proto.request.common.FetchSourceContextProtoUtils;
        }
     * @param request the Protocol Buffer SearchRequest to parse
                ? parseTimeValue(request.getCancelAfterTimeInterval(), null, "cancel_after_time_interval")
            validationException = addValidationError("[indicesOptions] cannot be used with point in time", validationException);
        org.opensearch.action.search.SearchRequest searchRequest = new org.opensearch.action.search.SearchRequest();
            : searchRequest.getBatchedReduceSize();
        // TODO support typed_keys
        }
 * Utility class for converting SearchRequest Protocol Buffers to objects
        } else if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_ACCURATE
        if (request.hasSearchType()) {
        } else {
            searchSourceBuilder.fetchSource(fetchSourceContext);
        searchRequest.setCancelAfterTimeInterval(
     * @param client the client to use for execution
            false,
        );
package org.opensearch.transport.grpc.proto.request.search;
        searchRequest.indices(indexArr);
                        + "] cannot be used "
            indicesOptions.ignoreUnavailable(),
            throw new UnsupportedOperationException("global_params param is not supported yet");
        }
import org.opensearch.transport.client.Client;
        Client client,
        String[] indexArr = new String[request.getIndexCount()];
    private static void preparePointInTime(
            for (String field : request.getDocvalueFieldsList()) {
            // only set if we have the parameter since we auto adjust the max concurrency on the coordinator
                        + "if the tracking of total hits is not accurate, got "
        }
            int suggestSize = request.hasSuggestSize() ? request.getSuggestSize() : 5;
    protected static void checkProtoTotalHits(SearchRequest protoRequest, org.opensearch.action.search.SearchRequest searchRequest) {
        if (queryBuilder != null) {
            indicesOptions.ignoreThrottled()
     */
        }
        if (request.hasScroll()) {
        /*
            validationException = addValidationError("[indices] cannot be used with point in time", validationException);
        org.opensearch.protobufs.SearchRequest request,
        }
            String suggestField = request.getSuggestField();
        checkProtoTotalHits(request, searchRequest);
    public static org.opensearch.action.search.SearchRequest prepareRequest(
     *
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.protobufs.SearchRequest;
            searchRequest.source().trackTotalHits(true);
        }
     * @param searchRequest the SearchRequest to populate
        AbstractQueryBuilderProtoUtils queryUtils,
            setSize,
            searchSourceBuilder.query(queryBuilder);
        org.opensearch.protobufs.SearchRequest request,
         * We have to pull out the call to `source().size(size)` because
                        + "rest_total_hits_as_int"
     * Similar to {@link RestSearchAction#prepareRequest(RestRequest, NodeClient)}
     * @param namedWriteableRegistry the registry for named writeables
            );
        if (request.hasSuggestField()) {
         * Note that we can't use `searchRequest.source()::size` because
     * @param request the Protocol Buffer SearchRequest to parse
                    suggestField,
                : null
        if (request.routing() != null) {
        QueryBuilder queryBuilder = ProtoActionsProtoUtils.urlParamsToQueryBuilder(request);
public class SearchRequestProtoUtils {
        // do not allow 'query_and_fetch' or 'dfs_query_and_fetch' search types
            validationException = addValidationError("[routing] cannot be used with point in time", validationException);
import org.opensearch.action.search.SearchContextId;
        if (request.hasTypedKeys()) {
     * @param setSize consumer for setting the size parameter
         * company.
     * @param aggregationRegistry the aggregation registry for parsing aggregations
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
        // request.paramAsBoolean(INCLUDE_NAMED_QUERIES_SCORE_PARAM, false);
            preparePointInTime(searchRequest, request, namedWriteableRegistry);
     * Prepares a point in time search request.
    ) {
            }
        parseSearchSource(searchRequest.source(), request, setSize);
            searchRequest.scroll(new Scroll(parseTimeValue(request.getScroll(), null, "scroll")));
            && trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        // not be specified explicitly by the user.
     * @param protoRequest the Protocol Buffer SearchRequest
     * @param request the SearchRequest to prepare
    }
            searchRequest,
        org.opensearch.protobufs.SearchRequest request,
        }
        request.indicesOptions(stricterIndicesOptions);
     * @param namedWriteableRegistry the registry for named writeables
            // only set if we have the parameter passed to override the cluster-level default
     *                     execution
        // from the REST layer. these modes are an internal optimization and should
        }
 */
     *
        searchRequest.indicesOptions(IndicesOptionsProtoUtils.fromRequest(request, searchRequest.indicesOptions()));
        }
            // Pass to {@link SearchRequest#routing(String routing)}
import org.opensearch.search.builder.SearchSourceBuilder;
        );
            }
    /**
     * @throws IOException if an I/O exception occurred during parsing
        if (request.getDocvalueFieldsCount() > 0) {
            ((NodeClient) client).getNamedWriteableRegistry(),
import org.opensearch.rest.action.search.RestSearchAction;
            searchRequest.allowPartialSearchResults(request.getAllowPartialSearchResults());
     * Similar to {@link RestSearchAction#preparePointInTime(org.opensearch.action.search.SearchRequest, RestRequest, NamedWriteableRegistry)}
        assert request.pointInTimeBuilder() != null;
        AggregationBuilderProtoConverterRegistry aggregationRegistry
                );
     * @param queryUtils the query utils instance for parsing queries
        }
                    termSuggestion(suggestField).text(suggestText)
        }
        }
     * @return the SearchRequest to execute
 * The OpenSearch Contributors require contributions made to
        parseSearchRequest(
            searchRequest.requestCache(request.getRequestCache());
import org.opensearch.search.internal.SearchContext;
            searchRequest.routing((String) null);
            searchRequest.source(new SearchSourceBuilder());
import org.opensearch.core.xcontent.XContentParser;
            false,
            // else phaseTook = null
    /**
        IntConsumer setSize = size -> searchRequest.source().size(size);
        org.opensearch.protobufs.SearchRequest protoRequest,
        if (request.hasRequestCache()) {
         * be null later. If that is confusing to you then you are in good
    }
import org.opensearch.transport.grpc.proto.request.search.suggest.TermSuggestionBuilderProtoUtils;
}
/**
        }
     *
        }
        request.indices(searchContextId.getActualIndices());
        }
        IntConsumer setSize
import org.opensearch.action.support.IndicesOptions;
        Integer trackTotalHitsUpTo = searchRequest.source().trackTotalHitsUpTo();
    /**
