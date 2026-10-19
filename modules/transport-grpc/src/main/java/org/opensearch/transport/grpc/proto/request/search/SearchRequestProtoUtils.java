            : searchRequest.getBatchedReduceSize();
                        + "if the tracking of total hits is not accurate, got "  
            int suggestSize = request.hasSuggestSize() ? request.getSuggestSize() : 5;  
        if (request.hasAllowPartialSearchResults()) {  
            for (String field : request.getDocvalueFieldsList()) {  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
import java.util.function.IntConsumer;
        boolean totalHitsAsInt = protoRequest.hasTotalHitsAsInt() ? protoRequest.getTotalHitsAsInt() : false;
            indicesOptions.ignoreThrottled()
        if (searchRequest.source() == null) {  
            // else phaseTook = null  
        }  
                );
    /**
                )
     *
import org.opensearch.action.ActionRequestValidationException;
}
        if (trackTotalHitsUpTo == null) {
    }
        for (int i = 0; i < request.getIndexCount(); i++) {
         * guard against it being null in the IntConsumer because it can't
            searchRequest.requestCache(request.getRequestCache());  
        }  
        }
     * Similar to {@link RestSearchAction#prepareRequest(RestRequest, NodeClient)}
            searchSourceBuilder.query(queryBuilder);
        // request.paramAsBoolean(INCLUDE_NAMED_QUERIES_SCORE_PARAM, false);
         * company.  
     * Parses a protobuf {@link org.opensearch.protobufs.SearchRequest} to a {@link org.opensearch.action.search.SearchRequest}.
            searchRequest.searchType(SearchTypeProtoUtils.fromProto(request));
                throw new IllegalArgumentException(
        return searchRequest;  
package org.opensearch.transport.grpc.proto.request.search;
            String suggestField = request.getSuggestField();
        if (queryBuilder != null) {
import org.opensearch.ExceptionsHelper;
     * @param request the SearchRequest to prepare
        }
     * Please ensure to keep both implementations consistent.
/**
            setSize,
     */  
        );
            searchRequest.source().trackTotalHits(true);
     * @param aggregationRegistry the aggregation registry for parsing aggregations
     * @throws IOException if an I/O exception occurred during parsing
         * Note that we can't use `searchRequest.source()::size` because
    private static void preparePointInTime(  
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
         * be null later. If that is confusing to you then you are in good
     * Similar to {@link RestSearchAction#parseSearchSource(SearchSourceBuilder, RestRequest, IntConsumer)}
    /**  
import org.opensearch.search.builder.SearchSourceBuilder;
            validationException = addValidationError("[routing] cannot be used with point in time", validationException);
        request.indices(searchContextId.getActualIndices());
        org.opensearch.protobufs.SearchRequest request,  
     * @param aggregationRegistry the aggregation registry for parsing aggregations
        IntConsumer setSize,
            searchRequest.source(new SearchSourceBuilder());
        org.opensearch.action.search.SearchRequest searchRequest,
     * Keep implementation consistent with {@link RestSearchAction#checkRestTotalHits(RestRequest, org.opensearch.action.search.SearchRequest)}
     * Prepares a point in time search request.
                    termSuggestion(suggestField).text(suggestText)
        if (totalHitsAsInt == false) {  
            false,
            // Pass to {@link SearchRequest#routing(String routing)}
        if (request.hasScroll()) {  
        QueryBuilder queryBuilder = ProtoActionsProtoUtils.urlParamsToQueryBuilder(request);  
     *  
        parseSearchRequest(
        }
    protected static void parseSearchRequest(
    private SearchRequestProtoUtils() {  
import org.opensearch.index.query.QueryBuilder;
        final SearchContextId searchContextId = SearchContextId.decode(namedWriteableRegistry, request.pointInTimeBuilder().getId());
        SearchSourceBuilderProtoUtils.parseProto(searchRequest.source(), request.getSearchRequestBody(), queryUtils, aggregationRegistry);
        }  
            // based on the number of nodes in the cluster
     * @param searchSourceBuilder the SearchSourceBuilder to populate  
        }  
        if (request.hasMaxConcurrentShardRequests()) {  
     */  
     * @param protoRequest the Protocol Buffer SearchRequest  
        } else {  
        if (request.getDocvalueFieldsCount() > 0) {
import org.opensearch.core.xcontent.XContentParser;  
        request.indicesOptions(stricterIndicesOptions);  
            searchRequest.setPhaseTook(request.getPhaseTook());
                    suggestField,
                        .size(suggestSize)  
import org.opensearch.rest.RestRequest;
     * @param request the Protocol Buffer SearchRequest to execute
            request.setCcsMinimizeRoundtrips(false);  
        if (request.preference() != null) {
    ) {
/*  
     * @param protoRequest the Protocol Buffer SearchRequest  
        if (request.indices().length > 0) {
import org.opensearch.action.search.SearchContextId;  
     *
     */
     */
        if (request.hasGlobalParams()) {  
     * @param request the Protocol Buffer SearchRequest to parse
    }
        if (request.hasTypedKeys()) {
 * Utility class for converting SearchRequest Protocol Buffers to objects
     * This method is similar to the logic in {@link RestSearchAction#parseSearchRequest(org.opensearch.action.search.SearchRequest, RestRequest, XContentParser, NamedWriteableRegistry, IntConsumer)}
        // do not allow 'query_and_fetch' or 'dfs_query_and_fetch' search types  
     *
        AbstractQueryBuilderProtoUtils queryUtils,  
                    "["  
            validationException = addValidationError("[preference] cannot be used with point in time", validationException);
            return;
        assert request.pointInTimeBuilder() != null;
        if (request.hasPreFilterShardSize()) {
         * _update_by_query and _delete_by_query uses this same parsing
        if (request.hasSuggestField()) {  
import org.opensearch.protobufs.SearchRequest;
            true,
public class SearchRequestProtoUtils {
     * Checks and configures total hits tracking in the search request.  
import org.opensearch.search.Scroll;  
    /**
        IntConsumer setSize
     * @throws IOException if an I/O exception occurred parsing the request and preparing for  
        }
     * @return the SearchRequest to execute
        }
import org.opensearch.rest.action.search.RestSearchAction;
        }
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
            // only set if we have the parameter passed to override the cluster-level default
        if (request.indicesOptions() != org.opensearch.action.search.SearchRequest.DEFAULT_INDICES_OPTIONS) {
            // only set if we have the parameter since we auto adjust the max concurrency on the coordinator
        searchRequest.preference(request.hasPreference() ? request.getPreference() : null);
     * @param setSize consumer for setting the size parameter
    /**
        );
        org.opensearch.action.search.SearchRequest searchRequest = new org.opensearch.action.search.SearchRequest();  
        // TODO avoid hidden cast to NodeClient here  
import static org.opensearch.action.ValidateActions.addValidationError;  
     * @param client the client to use for execution
        }
     * <p>  
import org.opensearch.transport.client.Client;
        NamedWriteableRegistry namedWriteableRegistry,
        }
            indicesOptions.allowNoIndices(),
                : null  
        parseSearchSource(searchRequest.source(), request, setSize);  
        /*
    }
        }
            searchRequest,
import java.io.IOException;  
        if (request.hasRequestCache()) {
        searchRequest.setBatchedReduceSize(batchedReduceSize);  
                        + trackTotalHitsUpTo
    ) throws IOException {
            ? request.getBatchedReduceSize()
            preparePointInTime(searchRequest, request, namedWriteableRegistry);
        Integer trackTotalHitsUpTo = searchRequest.source().trackTotalHitsUpTo();  
            false,  
    ) throws IOException {
        // TODO what does this line do?
            indicesOptions.ignoreUnavailable(),  
        }  
        }  
     * Prepare the request for execution.
            validationException = addValidationError("[indicesOptions] cannot be used with point in time", validationException);
     *
import org.opensearch.search.internal.SearchContext;  
        AbstractQueryBuilderProtoUtils queryUtils,  
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    public static org.opensearch.action.search.SearchRequest prepareRequest(  
        FetchSourceContext fetchSourceContext = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
import org.opensearch.transport.client.node.NodeClient;  
        }
            request,  
     * @param searchRequest the SearchRequest to configure
            );  
        }
            validationException = addValidationError("[ccs_minimize_roundtrips] cannot be used with point in time", validationException);
        final int batchedReduceSize = request.hasBatchedReduceSize()  
     * Specifically, this method handles the URL parameters, and internally calls {@link SearchSourceBuilderProtoUtils#parseProto(SearchSourceBuilder, SearchRequestBody, AbstractQueryBuilderProtoUtils, AggregationBuilderProtoConverterRegistry)}  
        }
        org.opensearch.protobufs.SearchRequest protoRequest,
        final IndicesOptions stricterIndicesOptions = IndicesOptions.fromOptions(
        AggregationBuilderProtoConverterRegistry aggregationRegistry
        AggregationBuilderProtoConverterRegistry aggregationRegistry
            throw new UnsupportedOperationException("typed_keys param is not supported yet");
        checkProtoTotalHits(request, searchRequest);
        final IndicesOptions indicesOptions = request.indicesOptions();
                        .suggestMode(TermSuggestionBuilderProtoUtils.resolve(suggestMode))
            searchSourceBuilder.suggest(
                new SuggestBuilder().addSuggestion(  
        // not be specified explicitly by the user.
    protected static void parseSearchSource(
 */  
            String suggestText = request.hasSuggestText() ? request.getSuggestText() : request.getQ();
    ) {
            searchRequest.setPreFilterShardSize(request.getPreFilterShardSize());  
        if (request.routing() != null) {
        searchRequest.indicesOptions(IndicesOptionsProtoUtils.fromRequest(request, searchRequest.indicesOptions()));  
        IntConsumer setSize = size -> searchRequest.source().size(size);
        if (request.hasPhaseTook()) {
 * The OpenSearch Contributors require contributions made to  
         * url parameter.  
        } else {
            searchSourceBuilder.fetchSource(fetchSourceContext);  
            org.opensearch.protobufs.SuggestMode suggestMode = request.getSuggestMode();
        if (protoRequest.hasCcsMinimizeRoundtrips() && protoRequest.getCcsMinimizeRoundtrips()) {
                searchSourceBuilder.docValueField(field, null);
import static org.opensearch.search.suggest.SuggestBuilders.termSuggestion;
            validationException = addValidationError("[indices] cannot be used with point in time", validationException);
     * @param queryUtils the query utils instance for parsing queries  
        }
        // from the REST layer. these modes are an internal optimization and should
            searchRequest.routing(request.getRoutingList().toArray(new String[0]));  
        String[] indexArr = new String[request.getIndexCount()];
        }
            throw new UnsupportedOperationException("global_params param is not supported yet");
        NamedWriteableRegistry namedWriteableRegistry  
     * Similar to {@link RestSearchAction#preparePointInTime(org.opensearch.action.search.SearchRequest, RestRequest, NamedWriteableRegistry)}  
        ExceptionsHelper.reThrowIfNotNull(validationException);
import org.opensearch.protobufs.SearchRequestBody;  
        }
            );  
     * @param request the Protocol Buffer SearchRequest to parse  
            && trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
            // Pass to {@link SearchRequest#routing(String ... routings)}
            searchRequest.allowPartialSearchResults(request.getAllowPartialSearchResults());
            ((NodeClient) client).getNamedWriteableRegistry(),
         */
                ? parseTimeValue(request.getCancelAfterTimeInterval(), null, "cancel_after_time_interval")
 * SPDX-License-Identifier: Apache-2.0
        org.opensearch.action.search.SearchRequest request,
            false,
            searchRequest.setCcsMinimizeRoundtrips(
        );
        ActionRequestValidationException validationException = null;  
    protected static void checkProtoTotalHits(SearchRequest protoRequest, org.opensearch.action.search.SearchRequest searchRequest) {  
        }
 * compatible open source license.
            // only set if we have the parameter passed to override the cluster-level default
import org.opensearch.transport.grpc.proto.request.search.suggest.TermSuggestionBuilderProtoUtils;  
            }
        // Utility class, no instances
            searchRequest.setMaxConcurrentShardRequests(request.getMaxConcurrentShardRequests());  
                request.hasCcsMinimizeRoundtrips() ? request.getCcsMinimizeRoundtrips() : searchRequest.isCcsMinimizeRoundtrips()
        }  
    }
            queryUtils,  
            searchRequest.scroll(new Scroll(parseTimeValue(request.getScroll(), null, "scroll")));
            true,  
        org.opensearch.protobufs.SearchRequest request,  
        searchRequest.setCancelAfterTimeInterval(  
            request.hasCancelAfterTimeInterval()
        if (request.getRoutingCount() > 0) {
     * @param queryUtils the query utils instance for parsing queries  
                        + "rest_total_hits_as_int"
        if (searchRequest.pointInTimeBuilder() != null) {
import org.opensearch.transport.grpc.proto.request.common.FetchSourceContextProtoUtils;
        searchRequest.indices(indexArr);
 *
            }  
import org.opensearch.search.suggest.SuggestBuilder;
        if (fetchSourceContext != null) {
        if (searchRequest.source() == null) {  
    }  
        // TODO support typed_keys  
     */
                        + "] cannot be used "
        org.opensearch.protobufs.SearchRequest request,
         * `searchRequest.source()` is null right now. We don't have to  
        Client client,
        final SearchSourceBuilder searchSourceBuilder,
     * Parses the search source from a Protocol Buffer SearchRequest.  
    /**
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
    }  
        // TODO support global_params
     * @param namedWriteableRegistry the registry for named writeables
        if (request.hasSearchType()) {  
            searchRequest.routing((String) null);  
            indexArr[i] = request.getIndex(i);  
     * @param namedWriteableRegistry the registry for named writeables
         * We have to pull out the call to `source().size(size)` because  
            aggregationRegistry
        } else if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_ACCURATE  
            searchRequest.source(new SearchSourceBuilder());
         *
        }  
     * @param searchRequest the SearchRequest to populate
     *                     execution
     * @param setSize consumer for setting the size parameter
         * path but sets a different variable when it sees the `size`
