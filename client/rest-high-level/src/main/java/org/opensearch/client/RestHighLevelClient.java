        map.put(AutoDateHistogramAggregationBuilder.NAME, (p, c) -> ParsedAutoDateHistogram.fromXContent(p, (String) c));
     * Asynchronously calls the Term Vectors API  
    ) {  
     * Create PIT context using create PIT API
import org.opensearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;
            emptySet()  
     * @return cancellable that may be used to cancel the request
    ) {  
        );  
    public final UpdateResponse update(UpdateRequest updateRequest, RequestOptions options) throws IOException {
    /**
     * @return the response
        map.put(IpRangeAggregationBuilder.NAME, (p, c) -> ParsedBinaryRange.fromXContent(p, (String) c));
            options,
import org.opensearch.search.aggregations.bucket.global.ParsedGlobal;
            singleton(404)
     * @param searchRequest the request
            throw validationException.get();
    public final SearchResponse scroll(SearchScrollRequest searchScrollRequest, RequestOptions options) throws IOException {
    protected final <Req extends Validatable, Resp> Cancellable performRequestAsyncAndParseEntity(  
            options,
            RequestConverters::searchScroll,
    /**
        SearchScrollRequest searchScrollRequest,
     * @return cancellable that may be used to cancel the request
        return performRequestAndParseEntity(  
 * High level REST client that wraps an instance of the low level {@link RestClient} and allows to build requests and read responses. The
import org.opensearch.search.aggregations.bucket.terms.LongRareTerms;
    public final Cancellable deleteByQueryRethrottleAsync(
import org.opensearch.client.core.MultiTermVectorsResponse;
     * @param getRequest the request
                if (exception instanceof ResponseException) {
        );
     */
        MultiTermVectorsRequest request,
    private final RestClient client;
        RequestOptions options,
     */
            FieldCapabilitiesResponse::fromXContent,
     * @param updateByQueryRequest the request
        return performRequestAndParseEntity(
    /**
    /**  
    public final Cancellable getAllPitsAsync(RequestOptions options, ActionListener<GetAllPitNodesResponse> listener) {  
    }
     * @param getSourceRequest the request
    ) {  
            emptySet()  
        RethrottleRequest rethrottleRequest,
import org.opensearch.action.index.IndexRequest;
        } catch (Exception e) {
    /**
            MultiSearchResponse::fromXContext,
        return performRequestAndParseEntity(getRequest, RequestConverters::get, options, GetResponse::fromXContent, singleton(404));
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
        map.put(InternalTDigestPercentiles.NAME, (p, c) -> ParsedTDigestPercentiles.fromXContent(p, (String) c));
        map.put(InternalSampler.PARSER_NAME, (p, c) -> ParsedSampler.fromXContent(p, (String) c));
            options,  
     */
            MultiSearchTemplateResponse::fromXContext,
        return performRequestAsyncAndParseEntity(  
import org.opensearch.search.aggregations.metrics.ParsedValueCount;
    public final boolean ping(RequestOptions options) throws IOException {
            emptySet()
        try {  
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;  
    public final Cancellable fieldCapsAsync(  
     * @param bulkRequest the request
            emptySet()  
import org.opensearch.action.delete.DeleteRequest;
    ) throws IOException {
            emptySet()
                    ResponseException responseException = (ResponseException) exception;  
        return client.performRequestAsync(req, responseListener);
            emptySet()
     *
     * @param listener the listener to be notified upon request completion
            ListTasksResponse::fromXContent,
            RequestConverters::fieldCaps,
    ) {
     * @return the response
     * @return the response  
        MultiSearchTemplateRequest multiSearchTemplateRequest,  
        RequestOptions options,
     *
            getSourceRequest,
            RequestConverters::submitReindex,
     * Deletes a document by id using the Delete API.
                opensearchException.addSuppressed(responseException);
     * Puts an stored script using the Scripting API.
    private final SnapshotClient snapshotClient = new SnapshotClient(this);  
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
    /**
        req.setOptions(options);  
            emptySet()
     * @param rethrottleRequest the request  
    public final Cancellable msearchAsync(
    public final DeletePitResponse deletePit(DeletePitRequest deletePitRequest, RequestOptions options) throws IOException {  
            listener.onFailure(validationException.get());
            (request) -> RequestConverters.deleteAllPits(),  
        Req request,
    public final Cancellable multiSearchAsync(
     *  
import org.opensearch.action.explain.ExplainRequest;  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Executes a reindex rethrottling request.  
import org.opensearch.action.update.UpdateRequest;
        return performRequestAsyncAndParseEntity(
        return performRequestAsyncAndParseEntity(  
            listener,
     * @return cancellable that may be used to cancel the request
        ActionListener<MultiSearchResponse> listener
            getRequest,  
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
     * @param listener the listener to be notified upon request completion  
import org.opensearch.search.aggregations.bucket.range.ParsedDateRange;  
        return performRequestAndParseEntity(
     *
            throw new IllegalArgumentException("The listener is required and cannot be null");
import org.opensearch.search.aggregations.bucket.histogram.ParsedVariableWidthHistogram;  
     * @param listener the listener to be notified upon request completion
            MultiGetResponse::fromXContent,
        ActionListener<GetSourceResponse> listener  
        );
        this.registry = new NamedXContentRegistry(
    final <Resp> ResponseListener wrapResponseListener(
     * @return <code>true</code> if the document and _source field exists, <code>false</code> otherwise  
     */
    public final Cancellable deletePitAsync(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * This constructor can be called by subclasses in case an externally created low-level REST client needs to be provided.
        UpdateByQueryRequest updateByQueryRequest,  
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;  
     * @return cancellable that may be used to cancel the request  
import org.opensearch.search.aggregations.metrics.ParsedTDigestPercentiles;  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            updateRequest,  
     * @param options           the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        ActionListener<ListTasksResponse> listener
     * @param listener the listener to be notified upon request completion  
     */  
        this.client = Objects.requireNonNull(restClient, "restClient must not be null");
    /**
     * @param rethrottleRequest the request  
            options,  
            (request) -> RequestConverters.info(),
    }  
    /**  
            emptySet()
            multiSearchTemplateRequest,
    }  
     */
     */  
                convertExistsResponse(response)
     * Defines a helper method for asynchronously performing a request.  
import java.util.ServiceLoader;  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
            throw new IOException("Unable to parse response body for " + response, e);
            getRequest,
        map.put(GeoDistanceAggregationBuilder.NAME, (p, c) -> ParsedGeoDistance.fromXContent(p, (String) c));
        ActionListener<Resp> listener,
     */
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;
            MultiSearchTemplateResponse::fromXContext,
        Optional<ValidationException> validationException = request.validate();  
    @Deprecated
        RequestOptions options,  
            listener,  
            searchScrollRequest,
        Set<Integer> ignores
     * Asynchronously retrieves the source field only of a document using GetSource API.
        );  
     * @param getSourceRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        CheckedFunction<Req, Request, IOException> requestConverter,
    /**
        }  
@Deprecated(since = "3.9.0")
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                        try {  
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;  
    public final IndicesClient indices() {  
        }
import org.opensearch.core.xcontent.ContextParser;
            RequestConverters::rethrottleDeleteByQuery,
        CheckedFunction<Response, Resp, IOException> responseConverter,
     * Retrieves multiple documents by id using the Multi Get API.
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;  
        MediaType mediaType = MediaType.fromMediaType(entity.getContentType());  
import org.opensearch.search.aggregations.pipeline.PercentilesBucketPipelineAggregationBuilder;
        return performRequestAsyncAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        return performRequestAndParseEntity(
     * Pings the remote OpenSearch cluster and returns true if the ping succeeded, false otherwise
        req.setOptions(options);
    }
            RequestConverters::multiSearchTemplate,
            ignores
     * @param explainRequest the request
        map.put(StringRareTerms.NAME, (p, c) -> ParsedStringRareTerms.fromXContent(p, (String) c));
        this.doClose = Objects.requireNonNull(doClose, "doClose consumer must not be null");  
     */
     * used to parse responses from OpenSearch. Any deprecation warnings  
import org.opensearch.action.search.SearchScrollRequest;  
        );
            deletePitRequest,  
    public Cancellable putScriptAsync(
        return performRequestAndParseEntity(
        this(restClientBuilder, Collections.emptyList());  
     * Provides a {@link ClusterClient} which can be used to access the Cluster API.
     *  
        return internalPerformRequestAsync(request, requestConverter, options, responseConverter, listener, ignores);
 * compatible open source license.
import org.opensearch.core.xcontent.MediaType;
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;
     * Get all point in time searches using list all PITs API
     *
import org.opensearch.index.rankeval.RankEvalResponse;
            listener.onFailure(validationException.get());  
 * <p>  
    /**  
            BulkByScrollResponse::fromXContent,
     */
        );
            emptySet()
     * Asynchronously executes a request using the Search Template API.
     * @return the response
     * If a response body was returned, tries to parse it as an error returned from OpenSearch.  
    /**
            listener,  
            RestHighLevelClient::convertExistsResponse,
        map.put(MaxAggregationBuilder.NAME, (p, c) -> ParsedMax.fromXContent(p, (String) c));
        RequestOptions options,  
     */
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
    public final ClusterClient cluster() {
     * @return the response  
    }
    public final DeleteResponse delete(DeleteRequest deleteRequest, RequestOptions options) throws IOException {
            options,  
import java.util.Objects;
                    onFailure(ioe);
 * <li>an {@link IOException} is usually thrown in case of failing to parse the REST response in the high-level REST client, the request
            return parseEntity(response.getEntity(), entityParser);  
        ActionListener<CreatePitResponse> listener
    private final NamedXContentRegistry registry;  
    }
        map.put(TopHitsAggregationBuilder.NAME, (p, c) -> ParsedTopHits.fromXContent(p, (String) c));  
     */  
        ActionRequestValidationException validationException = request.validate();
            Stream.of(getDefaultNamedXContents().stream(), getProvidedNamedXContents().stream(), namedXContentEntries.stream())
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            GetSourceResponse::fromXContent,
     * @return the response  
        return performRequestAsyncAndParseEntity(  
    ) {
        return performRequestAndParseEntity(bulkRequest, RequestConverters::bulk, options, BulkResponse::fromXContent, emptySet());
     *
import org.opensearch.search.aggregations.pipeline.InternalBucketMetricValue;  
import org.opensearch.search.aggregations.bucket.terms.ParsedLongRareTerms;
            DeletePitResponse::fromXContent,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        MultiGetRequest multiGetRequest,
            RequestConverters::clearScroll,  
     * Asynchronously executes a search using the Search Scroll API.  
     * @deprecated use {@link #mgetAsync(MultiGetRequest, RequestOptions, ActionListener)} instead  
import org.opensearch.search.suggest.completion.CompletionSuggestion;
    /**  
     * @return cancellable that may be used to cancel the request  
        RequestOptions options,  
    }
        CheckedFunction<XContentParser, Resp, IOException> entityParser
            return responseConverter.apply(response);
        map.put(InternalBucketMetricValue.NAME, (p, c) -> ParsedBucketMetricValue.fromXContent(p, (String) c));
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public AcknowledgedResponse deleteScript(DeleteStoredScriptRequest request, RequestOptions options) throws IOException {  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                    actionListener.onFailure(exception);
     * @return the response
            multiGetRequest,
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
     * @return the response
            );
    }
        }
        CreatePitRequest createPitRequest,  
    }
            emptySet()  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        return performRequestAsyncAndParseEntity(  
    }
            throw new IllegalStateException("OpenSearch didn't return the [Content-Type] header, unable to parse response body");
    private static final DeprecationHandler DEPRECATION_HANDLER = DeprecationHandler.IGNORE_DEPRECATIONS;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        map.put(ExtendedStatsBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedExtendedStatsBucket.fromXContent(p, (String) c));  
                try {  
import org.opensearch.search.aggregations.bucket.terms.ParsedStringRareTerms;
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
    /**
    /**
     * @param listener the listener to be notified upon request completion
        );  
            listener,  
            new NamedXContentRegistry.Entry(  
 * KIND, either express or implied.  See the License for the
     */
     * @return the response
                if (exception instanceof ResponseException) {
    /**
     * @return <code>true</code> if the document exists, <code>false</code> otherwise  
            listener,
        Set<Integer> ignores  
    public final Cancellable existsAsync(GetRequest getRequest, RequestOptions options, ActionListener<Boolean> listener) {
    }  
    }
     * Executes a reindex rethrottling request.
     * @param fieldCapabilitiesRequest the request
    }
     * Executes a update by query rethrottle request.
            RequestConverters::clearScroll,
     * Executes a request using the Field Capabilities API.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
    }  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import java.util.Set;
     */  
            options,  
     *  
     */
    /**
            RequestConverters::sourceExists,
        if (listener == null) {  
     */  
 * <ul>  
        );
     * @param listener the listener to be notified upon request completion
import java.io.IOException;
    /**
     * @return cancellable that may be used to cancel the request  
     */
        RequestOptions options,  
import org.opensearch.action.search.SearchResponse;
        RequestOptions options,
import org.opensearch.search.aggregations.pipeline.ParsedStatsBucket;
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;  
     * @return the response
    public final Cancellable searchTemplateAsync(
    }  
        return performRequestAndParseEntity(
     *
            options,  
            options,
     * @param deletePitRequest the request
     *
        if (entity.getContentType() == null) {  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        RequestOptions options,
     * @return the response
     */
     */  
            options,  
     * The consumer argument allows to control what needs to be done when the {@link #close()} method is called.  
    /**
     * @return the response
                            // or an error for which parsing is completely different. We try to consider the 404 response as a valid one
    public final Cancellable rankEvalAsync(
        } catch (Exception e) {  
            options,  
     *  
    public final ClearScrollResponse clearScroll(ClearScrollRequest clearScrollRequest, RequestOptions options) throws IOException {  
    public final Cancellable reindexAsync(
/*  
     *  
     * @deprecated If creating a new HLRC ReST API call, consider creating new actions instead of reusing server actions. The Validation
    public final Cancellable scrollAsync(
            emptySet()
    }
    ) throws IOException {
     */
     * @param putStoredScriptRequest the request  
     * @param options   the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *
    /**
            searchRequest,  
     *  
     * Calls the Multi Term Vectors API
        return entries;
            listener,
import org.opensearch.search.aggregations.bucket.histogram.ParsedHistogram;
     * @return the response  
            }  
import org.opensearch.action.delete.DeleteResponse;
        );
        return response.getStatusLine().getStatusCode() == 200;
    }  
    public final TaskSubmissionResponse submitReindexTask(ReindexRequest reindexRequest, RequestOptions options) throws IOException {
     * Asynchronously updates a document using the Update API.  
import org.opensearch.action.search.CreatePitRequest;  
            emptySet()
    /**
            GetAllPitNodesResponse::fromXContent,  
    public final CountResponse count(CountRequest countRequest, RequestOptions options) throws IOException {
            listener,
    public final TaskSubmissionResponse submitDeleteByQueryTask(DeleteByQueryRequest deleteByQueryRequest, RequestOptions options)
     */
    }
            requestConverter,  
     * Asynchronously executes a delete by query request.
            RequestConverters::searchTemplate,  
    protected final OpenSearchStatusException parseResponseException(ResponseException responseException) {
        Req request,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            request,  
        CheckedFunction<Req, Request, IOException> requestConverter,
        map.put(StatsBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedStatsBucket.fromXContent(p, (String) c));
        map.put(ReverseNestedAggregationBuilder.NAME, (p, c) -> ParsedReverseNested.fromXContent(p, (String) c));
        PutStoredScriptRequest putStoredScriptRequest,
        return performRequestAndParseEntity(
     * Provides a {@link IngestClient} which can be used to access the Ingest API.  
        return searchPipelineClient;  
    }  
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
            emptySet()
    /**  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        Optional<ValidationException> validationException = request.validate();  
        return performRequestAndParseEntity(  
    protected final <Req extends ActionRequest, Resp> Resp performRequestAndParseEntity(
            .stream()
    /**  
            updateByQueryRequest,
        return performRequestAndParseEntity(countRequest, RequestConverters::count, options, CountResponse::fromXContent, emptySet());
        if (validationException != null && validationException.isPresent()) {
            listener,
import org.opensearch.search.aggregations.bucket.missing.MissingAggregationBuilder;
     * @return cancellable that may be used to cancel the request
        CheckedFunction<Req, Request, IOException> requestConverter,
                }
     * @return the response
            multiSearchTemplateRequest,
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentileRanks;  
        MultiSearchRequest searchRequest,
    /**  
     * {@link RestClient} to be used to perform requests and parsers for custom response sections added to OpenSearch through plugins.
            public void onFailure(Exception exception) {  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            listener,
    @Deprecated
     * Checks for the existence of a document with a "_source" field. Returns true if it exists, false otherwise.
            searchRequest,
    }
        map.put(NestedAggregationBuilder.NAME, (p, c) -> ParsedNested.fromXContent(p, (String) c));
     */
     *
        try {
        GetSourceRequest getSourceRequest,  
     *
        return performRequestAsyncAndParseEntity(
        }  
 * Licensed to Elasticsearch under one or more contributor  
 *
import org.opensearch.action.search.CreatePitResponse;
    /**
        }
     * @param listener the listener to be notified upon request completion
    }
import org.opensearch.search.aggregations.metrics.GeoCentroidAggregationBuilder;  
            RequestConverters::submitDeleteByQuery,  
     *
            RequestConverters::delete,
     * @param request   the request
    }  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                new ParseField(PhraseSuggestionBuilder.SUGGESTION_NAME),
     *
        );
            listener,  
            MultiSearchResponse::fromXContext,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                    actionListener.onFailure(exception);
     * @param indexRequest the request
 *
            listener,
            emptySet()
        RequestOptions options,
            public void onSuccess(Response response) {
     * Executes a search using the Search Scroll API.
     * @param updateByQueryRequest the request  
import java.util.ArrayList;
     */
                            // the exception is ignored as we now try to parse the response as an error.  
import org.opensearch.search.aggregations.metrics.ParsedWeightedAvg;  
     * Delete point in time searches using delete PIT API  
        if (validationException != null && validationException.validationErrors().isEmpty() == false) {
     * Executes a reindex request.
            options,
            options,
    }
        map.put(DerivativePipelineAggregationBuilder.NAME, (p, c) -> ParsedDerivative.fromXContent(p, (String) c));
    ) throws IOException {  
     */
     *  
    ) {
        return internalPerformRequestAsync(request, requestConverter, options, responseConverter, listener, ignores);  
     *
            BulkByScrollResponse::fromXContent,  
        return performRequestAndParseEntity(
        );
     * Asynchronously retrieves a document by id using the Get API.  
            listener,
     * @param request the request
     * Asynchronous request which returns empty {@link Optional}s in the case of 404s or parses entity into an Optional
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                            actionListener.onResponse(responseConverter.apply(response));
    ) {  
        );  
                    // this covers cases like get where 404 can either be a valid document not found response,
            requestConverter,
        return performRequestAndParseEntity(  
     * @param searchScrollRequest the request
    }
     *
        ActionListener<Resp> listener,  
    public final Cancellable deleteAllPitsAsync(RequestOptions options, ActionListener<DeletePitResponse> listener) {
     * @param searchScrollRequest the request
            rethrottleRequest,
    /**
            SearchResponse::fromXContent,  
    protected final <Resp> Resp parseEntity(final HttpEntity entity, final CheckedFunction<XContentParser, Resp, IOException> entityParser)
        return tasksClient;
     */  
        return performRequestAsync(
     *  
        GetSourceRequest getSourceRequest = GetSourceRequest.from(getRequest);
     *
     * @param listener the listener to be notified upon request completion  
            options,  
        );
        );  
    }  
import org.opensearch.search.aggregations.metrics.ParsedScriptedMetric;
    public final CreatePitResponse createPit(CreatePitRequest createPitRequest, RequestOptions options) throws IOException {
            RequestConverters::reindex,
        );
     * @return the response
import java.util.Collections;  
    }  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param countRequest the request  
    /**
    }
 * or to add support for custom response sections, again added to OpenSearch through plugins.  
     * Defines a helper method for performing a request and then parsing the returned entity using the provided entityParser.
    }  
            getSourceRequest,
    }
     * @return the response
            listener,  
import org.opensearch.search.aggregations.bucket.terms.UnsignedLongTerms;
            options,
        ActionListener<SearchResponse> listener  
    /**  
        TermVectorsRequest request,
        return entries;  
            listener,
            )
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param updateRequest the request  
     * Asynchronously checks for the existence of a document. Returns true if it exists, false otherwise.
            throw parseResponseException(e);
     * @param rethrottleRequest the request
    /**  
     * @param deleteRequest the request  
import org.opensearch.action.search.ClearScrollRequest;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        throws IOException {  
import org.opensearch.core.ParseField;
    /**  
            updateByQueryRequest,
    ) {  
        ActionListener<Resp> listener,
     * @param reindexRequest the request
        }
import org.opensearch.search.aggregations.Aggregation;
     * Asynchronously executes a search using the Search Scroll API.  
     * @return the submission response  
import org.opensearch.search.aggregations.bucket.filter.ParsedFilters;  
     * @return the response  
        CheckedFunction<Req, Request, IOException> requestConverter,
            RequestConverters::get,
import org.opensearch.action.search.ClearScrollResponse;
     *  
            options,
     * Calls the Term Vectors API
        CheckedConsumer<RestClient, IOException> doClose,
            public void onSuccess(Response response) {  
     * @deprecated use {@link #mget(MultiGetRequest, RequestOptions)} instead  
        return performRequestAsyncAndParseEntity(  
     */  
    }
        map.put(UnsignedLongTerms.NAME, (p, c) -> ParsedUnsignedLongTerms.fromXContent(p, (String) c));
    /**
        RequestOptions options,  
import org.opensearch.common.CheckedConsumer;  
            clearScrollRequest,  
     * @return the response
                    // the exception is ignored as we now try to parse the response as an error.  
        return performRequestAsyncAndParseEntity(
            entries.addAll(service.getNamedXContentParsers());
            @Override
        );  
import org.opensearch.search.aggregations.bucket.missing.ParsedMissing;  
     * @return the response  
    }
        return performRequestAndParseEntity(  
            options,  
            RankEvalResponse::fromXContent,
        return performRequestAndParseEntity(  
        );  
     * @return cancellable that may be used to cancel the request  
    /**
     * @param clearScrollRequest the request
     * @param listener the listener to be notified upon request completion
import org.opensearch.client.core.GetSourceRequest;  
            options,
import org.opensearch.common.CheckedFunction;
        map.put(RangeAggregationBuilder.NAME, (p, c) -> ParsedRange.fromXContent(p, (String) c));  
    @Deprecated
        FieldCapabilitiesRequest fieldCapabilitiesRequest,
    public final MultiTermVectorsResponse mtermvectors(MultiTermVectorsRequest request, RequestOptions options) throws IOException {
        return performRequestAsyncAndParseEntity(
    /**  
     * @return cancellable that may be used to cancel the request  
        RequestOptions options,
     * @return the submission response
            getSourceRequest,
     *
    ) {  
     * Executes a request using the Multi Search Template API.
        return performRequestAsyncAndParseEntity(  
    private final TasksClient tasksClient = new TasksClient(this);
import org.opensearch.search.aggregations.pipeline.ExtendedStatsBucketPipelineAggregationBuilder;
 * times out or similar cases where there is no response coming back from the OpenSearch server</li>
 * ownership. Elasticsearch licenses this file to you under  
        DeletePitRequest deletePitRequest,
            rethrottleRequest,
            (request) -> RequestConverters.deleteAllPits(),
            RequestConverters::deleteByQuery,
 * not use this file except in compliance with the License.
     */
import org.opensearch.action.update.UpdateResponse;  
     * @param listener the listener to be notified upon request completion  
    }
     * @deprecated use {@link #msearch(MultiSearchRequest, RequestOptions)} instead  
     */
    /**
     * @param listener the listener to be notified upon request completion
    /**  
            options,  
            options,
            singleton(404)
            AcknowledgedResponse::fromXContent,  
     * Executes a request using the Search Template API.
        RequestOptions options,  
                    } else {  
            options,
            RequestConverters::mtermVectors,
     * @return cancellable that may be used to cancel the request
            listener.onFailure(e);  
            multiSearchRequest,
    public AcknowledgedResponse putScript(PutStoredScriptRequest putStoredScriptRequest, RequestOptions options) throws IOException {
    }
                    Response response = responseException.getResponse();  
            }  
        CheckedFunction<Response, Resp, IOException> responseConverter,  
        map.put(InternalHDRPercentileRanks.NAME, (p, c) -> ParsedHDRPercentileRanks.fromXContent(p, (String) c));
            RequestConverters::rethrottleReindex,  
            emptySet()  
    /**  
        RequestOptions options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param rethrottleRequest the request
    }
     */
            options,
        );  
     * Executes a bulk request using the Bulk API.
            options,
import org.opensearch.action.index.IndexResponse;  
        );  
import static java.util.Collections.emptySet;  
        }
            singleton(409)
            RequestConverters::submitUpdateByQuery,
     * @return Cancellable instance that may be used to cancel the request  
     * Asynchronously executes a multi search using the msearch API.
            )  
        return internalPerformRequest(request, requestConverter, options, responseConverter, ignores);
            searchRequest,  
     * @param updateRequest the request
import org.opensearch.search.aggregations.bucket.filter.ParsedFilter;
    /**
     */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            } catch (Exception e) {
     *
     * @param deleteByQueryRequest the request
        doClose.accept(client);
        );  
        return msearch(multiSearchRequest, options);
        GetSourceRequest getSourceRequest = GetSourceRequest.from(getRequest);
import org.opensearch.action.search.SearchRequest;
     * @param request the request
     * @param getSourceRequest the request  
     * Asynchronously executes a request using the Ranking Evaluation API.  
            }
     * @param deleteByQueryRequest the request
import java.util.Map;  
     * @param getSourceRequest the request
 */
            emptySet()  
                Suggest.Suggestion.class,  
     */
     */
    }  
        return mget(multiGetRequest, options);
    }
        );
            rethrottleRequest,  
        CheckedFunction<Response, Resp, IOException> responseConverter,
        );
        SearchTemplateRequest searchTemplateRequest,  
            singleton(409)  
            TermVectorsResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * @param request the request
            indexRequest,  
            }  
     * Creates a {@link RestHighLevelClient} given the low level {@link RestClientBuilder} that allows to build the
        RequestOptions options,
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
        }
        CheckedFunction<XContentParser, Resp, IOException> entityParser,
import org.opensearch.search.aggregations.bucket.range.ParsedRange;
            request,
        ActionListener<BulkByScrollResponse> listener
 * <p>
            response -> parseEntity(response.getEntity(), entityParser),
     * Asynchronously executes a request using the Explain API.
            throw new IllegalStateException("Response body expected but not returned");
            MainResponse::fromXContent,
     *
     * @param multiSearchRequest the request  
     * @param listener the listener to be notified upon request completion
     *
            bulkRequest,
        } else {
            emptySet()
        if (validationException != null && validationException.isPresent()) {
            reindexRequest,
    }
        ResponseListener responseListener = wrapResponseListener(responseConverter, listener, ignores);
    /**
                    ResponseException responseException = (ResponseException) exception;
     * @return cancellable that may be used to cancel the request
 * {@link #search(SearchRequest, RequestOptions)} and {@link #searchAsync(SearchRequest, RequestOptions, ActionListener)}, where the later
        Set<Integer> ignores
        map.put(MissingAggregationBuilder.NAME, (p, c) -> ParsedMissing.fromXContent(p, (String) c));  
        RequestOptions options,
    /**
    }
package org.opensearch.client;
    }
            emptySet()
    public final Cancellable countAsync(CountRequest countRequest, RequestOptions options, ActionListener<CountResponse> listener) {
    }
     * @return the response
    ) {  
     * layer has been added to the ReST client, and requests should extend {@link Validatable} instead of {@link ActionRequest}.
            RequestConverters::bulk,
import java.io.Closeable;  
     */  
            new MainRequest(),
     * @param multiGetRequest the request  
        try {
        SearchScrollRequest searchScrollRequest,
        CheckedFunction<Req, Request, IOException> requestConverter,
     */
     * @param listener the listener to be notified upon request completion
            AcknowledgedResponse::fromXContent,  
     * @param searchRequest the request  
        };
 *
     *
    protected RestHighLevelClient(  
            Collections.singleton(404)
            rankEvalRequest,
        );
     * OpenSearch. There isn't anything you can do about the deprecation.
    public final Cancellable termvectorsAsync(
                    actionListener.onResponse(Optional.of(responseConverter.apply(response)));
                    actionListener.onResponse(responseConverter.apply(response));
    }
    }  
     *
    @Deprecated  
import org.opensearch.search.aggregations.pipeline.ParsedPercentilesBucket;
    /**  
    ) {
        CheckedFunction<Response, Resp, IOException> responseConverter,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param searchRequest the request  
                return Optional.empty();
import org.opensearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;
import org.opensearch.index.reindex.BulkByScrollResponse;  
        }
            RequestConverters::reindex,
     *
        );
    }
     * @param countRequest the request
     * Creates a {@link RestHighLevelClient} given the low level {@link RestClient} that it should use to perform requests and  
            GetStoredScriptResponse::fromXContent,
        map.put(SumAggregationBuilder.NAME, (p, c) -> ParsedSum.fromXContent(p, (String) c));
    }
     * @return Cancellable instance that may be used to cancel the request
 */  
    /**
                try {  
import org.opensearch.action.get.MultiGetResponse;
     * Submits a delete by query task
     * Asynchronously retrieves multiple documents by id using the Multi Get API.
    static List<NamedXContentRegistry.Entry> getDefaultNamedXContents() {  
        );
        };
            options,  
        map.put(InternalSimpleValue.NAME, (p, c) -> ParsedSimpleValue.fromXContent(p, (String) c));  
        ActionListener<FieldCapabilitiesResponse> listener  
     * @return cancellable that may be used to cancel the request
    /**  
            RequestConverters::sourceExists,  
     * @return the response  
import org.opensearch.action.get.MultiGetRequest;  
 * {@link #RestHighLevelClient(RestClient, CheckedConsumer, List)} constructor can be used.
     * @param searchRequest the request  
            listener.onFailure(validationException);
            searchScrollRequest,  
            listener,
        }, listener, singleton(404));
     *  
                Suggest.Suggestion.class,
        );
        }
    public final MultiSearchTemplateResponse msearchTemplate(MultiSearchTemplateRequest multiSearchTemplateRequest, RequestOptions options)
     * @param putStoredScriptRequest the request
        Req request,  
            DeletePitResponse::fromXContent,
    }  
            emptySet()
     * layer has been added to the ReST client, and requests should extend {@link Validatable} instead of {@link ActionRequest}.  
    private final SearchPipelineClient searchPipelineClient = new SearchPipelineClient(this);
import org.opensearch.search.aggregations.bucket.terms.ParsedStringTerms;
     * @param indexRequest the request  
                            // first. If parsing of the response breaks, we fall back to parsing it as an error.  
     * @return cancellable that may be used to cancel the request
            options,  
import org.opensearch.client.core.TermVectorsRequest;  
                            actionListener.onFailure(parseResponseException(responseException));
            RestHighLevelClient::convertExistsResponse,
    @Deprecated  
     */  
                        } catch (Exception innerException) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import java.util.function.Function;
     * Executes a count request using the Count API.
    /**  
            putStoredScriptRequest,  
            options,
        }
     * Provides common functionality for performing a request.
    /**
        return performRequestAsyncAndParseEntity(
    public final Cancellable bulkAsync(BulkRequest bulkRequest, RequestOptions options, ActionListener<BulkResponse> listener) {
                        actionListener.onFailure(parseResponseException(responseException));
        return performRequestAsyncAndParseEntity(
import org.opensearch.search.aggregations.pipeline.ParsedDerivative;  
import org.opensearch.OpenSearchStatusException;  
        );  
import org.opensearch.search.aggregations.bucket.nested.ParsedReverseNested;  
        return performRequestAsyncAndParseEntity(
 * The OpenSearch Contributors require contributions made to  
    /**  
        RequestOptions options,
        );
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentiles;
                } else {  
        ActionListener<GetStoredScriptResponse> listener
        Optional<ValidationException> validationException = request.validate();  
import org.opensearch.search.aggregations.pipeline.ParsedExtendedStatsBucket;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            RequestConverters::getScript,  
    /**
        );
    /**
    }  
            options,  
    public final Cancellable indexAsync(IndexRequest indexRequest, RequestOptions options, ActionListener<IndexResponse> listener) {
        ActionListener<BulkByScrollResponse> listener
     * exception as a suppressed exception. This method is guaranteed to not throw any exception eventually thrown while parsing.  
     * @return the response
            RequestConverters::fieldCaps,  
    /**
        return scroll(searchScrollRequest, options);  
     */
    ) {
     */
    /**  
     */
import org.opensearch.action.search.MultiSearchResponse;  
        );  
     * @deprecated If creating a new HLRC ReST API call, consider creating new actions instead of reusing server actions. The Validation
            emptySet()
        List<NamedXContentRegistry.Entry> entries = map.entrySet()  
            BulkByScrollResponse::fromXContent,  
        );
    @Deprecated
            createPitRequest,
import org.opensearch.search.aggregations.bucket.terms.ParsedDoubleTerms;
 * under the License.  
     */  
            listener,
     * @deprecated If creating a new HLRC ReST API call, consider creating new actions instead of reusing server actions. The Validation
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;  
        ReindexRequest reindexRequest,
        return performRequestAsync(
            emptySet()  
    /**
        RequestOptions options,
     */
     * Asynchronously executes a request using the Multi Search Template API
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                .collect(toList())
            )
        map.put(InternalHDRPercentiles.NAME, (p, c) -> ParsedHDRPercentiles.fromXContent(p, (String) c));  
     * Executes a request using the Explain API.  
            TaskSubmissionResponse::fromXContent,
        RequestOptions options,  
    }  
    public final MultiGetResponse mget(MultiGetRequest multiGetRequest, RequestOptions options) throws IOException {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        RequestOptions options,
            new MainRequest(),
     * @return cancellable that may be used to cancel the request
        } catch (Exception e) {  
    }
    }
     *
            }  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );
     * Also subclasses can provide parsers for custom response sections added to OpenSearch through plugins.
        return performRequestAndParseEntity(indexRequest, RequestConverters::index, options, IndexResponse::fromXContent, emptySet());
     * @return cancellable that may be used to cancel the request  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            listener,  
            rankEvalRequest,
     *  
    }  
    ) {
    }  
     */
     */
    }
            options,
 * <li>an {@link OpenSearchException} is usually thrown in case where the server returns a 4xx or 5xx error code. The high-level client  
    public Cancellable deleteScriptAsync(  
     * @param listener the listener to be notified upon request completion
                    IOException ioe = new IOException("Unable to parse response body for " + response, e);
            listener,  
        return internalPerformRequest(request, requestConverter, options, responseConverter, ignores);
        ActionListener<MultiSearchResponse> listener
     * otherwise tries to parse the response body
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
        ActionListener<RankEvalResponse> listener
        RequestOptions options,
            RequestConverters::sourceExists,
     * Executes a delete by query rethrottle request.
        RequestOptions options,  
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;  
     * {@link RestClient} to be used to perform requests.  
    }
            SearchTemplateResponse::fromXContent,
        CheckedFunction<Req, Request, IOException> requestConverter,
     * @param listener the listener to be notified upon request completion
    public final RestClient getLowLevelClient() {
    /**
        );
     * @param rankEvalRequest the request
    }  
     * @param listener the listener to be notified upon request completion
        RequestOptions options,  
    /**
        GetSourceRequest getSourceRequest,
    static List<NamedXContentRegistry.Entry> getProvidedNamedXContents() {
            new MainRequest(),  
     *
     * Defines a helper method for performing a request.  
public class RestHighLevelClient implements Closeable {  
     * that wraps the original {@link ResponseException}. The potential exception obtained while parsing is added to the returned
            listener,
        Set<Integer> ignores
 * </ul>  
     * If no response body was returned or anything goes wrong while parsing the error, returns a new {@link OpenSearchStatusException}
    }
            emptySet()
            RequestConverters::deletePit,
    @Deprecated
import org.opensearch.search.aggregations.bucket.histogram.ParsedAutoDateHistogram;  
 * specific language governing permissions and limitations
        map.put(CompositeAggregationBuilder.NAME, (p, c) -> ParsedComposite.fromXContent(p, (String) c));
     * Checks for the existence of a document. Returns true if it exists, false otherwise.
    ) throws IOException {  
    public final BulkByScrollResponse updateByQuery(UpdateByQueryRequest updateByQueryRequest, RequestOptions options) throws IOException {
     * @return the response  
                convertExistsResponse(response)
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            DeleteResponse::fromXContent,  
        return client;  
            searchTemplateRequest,
    public final ExplainResponse explain(ExplainRequest explainRequest, RequestOptions options) throws IOException {  
        );  
        );  
            options,  
     * Converts a {@link ResponseException} obtained from the low level REST client into an {@link OpenSearchException}.
    }  
            options,
        Optional<ValidationException> validationException = request.validate();
        );
     * @param request   the request
     * @param getRequest the request
import org.opensearch.core.action.ActionListener;  
    /**  
        Map<String, ContextParser<Object, ? extends Aggregation>> map = new HashMap<>();
     * Asynchronously executes a search using the Search API.  
     *
        RequestOptions options,  
    }  
            options,
            BulkByScrollResponse::fromXContent,
        throws IOException {
     */
            FieldCapabilitiesResponse::fromXContent,  
        return performRequestAsync(  
        return performRequest(request, requestConverter, options, response -> parseEntity(response.getEntity(), entityParser), ignores);  
            RequestConverters::updateByQuery,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        map.put(ScriptedMetricAggregationBuilder.NAME, (p, c) -> ParsedScriptedMetric.fromXContent(p, (String) c));
        if (entity == null) {  
        ActionListener<Optional<Resp>> actionListener
        );  
     *
        );  
import org.opensearch.search.aggregations.metrics.ParsedTopHits;
     * @return the submission response  
    public final Cancellable deleteByQueryAsync(  
    @Deprecated
        Set<Integer> ignores
            throw validationException.get();
            RestHighLevelClient::convertExistsResponse,
     * @return the response  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return cancellable that may be used to cancel the request
        try {
            fieldCapabilitiesRequest,
import java.util.List;
     * @return cancellable that may be used to cancel the request
    public final TermVectorsResponse termvectors(TermVectorsRequest request, RequestOptions options) throws IOException {
import org.opensearch.action.bulk.BulkResponse;  
/*
        return performRequestAndParseEntity(
            emptySet()  
            ClearScrollResponse::fromXContent,
     */  
            if (RestStatus.NOT_FOUND.getStatus() == e.getResponse().getStatusLine().getStatusCode()) {
        );
        Req request,
        GetStoredScriptRequest request,  
import org.opensearch.search.aggregations.bucket.range.ParsedGeoDistance;
                    onFailure(ioe);
            MultiTermVectorsResponse::fromXContent,
        map.put(SignificantLongTerms.NAME, (p, c) -> ParsedSignificantLongTerms.fromXContent(p, (String) c));
     */
        } catch (ResponseException e) {
     * @param deleteByQueryRequest the request
import static java.util.Collections.singleton;
        ActionListener<AcknowledgedResponse> listener
     * @param listener the listener to be notified upon request completion
    public final IndexResponse index(IndexRequest indexRequest, RequestOptions options) throws IOException {
        DeleteStoredScriptRequest request,
        );  
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
        RequestOptions options,  
        map.put(InternalTDigestPercentileRanks.NAME, (p, c) -> ParsedTDigestPercentileRanks.fromXContent(p, (String) c));  
    public final SearchPipelineClient searchPipeline() {
    /**  
        map.put(GlobalAggregationBuilder.NAME, (p, c) -> ParsedGlobal.fromXContent(p, (String) c));  
    public final FieldCapabilitiesResponse fieldCaps(FieldCapabilitiesRequest fieldCapabilitiesRequest, RequestOptions options)
     *
        ActionListener<SearchTemplateResponse> listener
import org.opensearch.search.aggregations.bucket.terms.StringRareTerms;  
     * @param searchTemplateRequest the request  
        map.put(WeightedAvgAggregationBuilder.NAME, (p, c) -> ParsedWeightedAvg.fromXContent(p, (String) c));
    ) {
        return performRequest(  
import org.opensearch.search.aggregations.metrics.ParsedMax;
            throw new IOException("Unable to parse response body for " + response, e);
    /**  
        map.put(LongRareTerms.NAME, (p, c) -> ParsedLongRareTerms.fromXContent(p, (String) c));
     */  
     * Provides a {@link TasksClient} which can be used to access the Tasks API.
     */  
            .collect(Collectors.toList());  
    public final MultiSearchResponse multiSearch(MultiSearchRequest multiSearchRequest, RequestOptions options) throws IOException {  
    /**  
import org.opensearch.action.search.MultiSearchRequest;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return cancellable that may be used to cancel the request  
import org.opensearch.search.aggregations.metrics.ParsedExtendedStats;
     * Executes a multi search using the msearch API.
                .flatMap(Function.identity())  
     * @return the response
    /**
     */
        return performRequestAndParseEntity(  
            RequestConverters::createPit,
     * Index a document using the Index API.
                    }
     * @return the response
        Response response;  
        CheckedFunction<Response, Resp, IOException> responseConverter,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            request,
        ActionListener<DeletePitResponse> listener  
     * Asynchronously Create PIT context using create PIT API
     * @return <code>true</code> if the document and _source field exists, <code>false</code> otherwise  
            request,
        throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
        );
import org.opensearch.search.suggest.term.TermSuggestion;  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     */
        Response response = responseException.getResponse();  
     */
    /**
            singleton(404)  
            options,  
    }
     * @return Cancellable instance that may be used to cancel the request  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * @param listener the listener to be notified upon request completion
import java.util.stream.Stream;
            singleton(404)
            try {
        throws IOException {
        );
            listener,
        Request req;
    ) {  
        );
            emptySet()
            RequestConverters::rethrottleUpdateByQuery,
     * Defines a helper method for requests that can 404 and in which case will return an empty Optional  
     *
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;  
            listener,
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
import org.opensearch.search.aggregations.bucket.range.ParsedBinaryRange;
        );
import org.opensearch.search.aggregations.pipeline.StatsBucketPipelineAggregationBuilder;  
        Req request,  
    /**
    protected final <Req extends Validatable, Resp> Cancellable performRequestAsync(
        } catch (ResponseException e) {  
            options,  
     * @param multiSearchRequest the request
                    throw parseResponseException(e);
    /**  
    ) {
import java.util.HashMap;
        RequestOptions options,  
            emptySet()  
            MultiGetResponse::fromXContent,
    }
    }
     * @param listener the listener to be notified upon request completion
 * {@link RestClient} instance is internally built based on the provided {@link RestClientBuilder} and it gets closed automatically when  
     *
    public final BulkByScrollResponse reindex(ReindexRequest reindexRequest, RequestOptions options) throws IOException {
        return performRequestAndParseEntity(
        CheckedFunction<XContentParser, Resp, IOException> entityParser,  
     * @param multiGetRequest the request  
        return mgetAsync(multiGetRequest, options, listener);  
        CheckedFunction<Req, Request, IOException> requestConverter,
        map.put(MinAggregationBuilder.NAME, (p, c) -> ParsedMin.fromXContent(p, (String) c));  
}
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            MultiTermVectorsResponse::fromXContent,  
            @Override
    ) {
        return performRequestAsyncAndParseEntity(
            throw validationException;  
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
     */  
            GetAllPitNodesResponse::fromXContent,
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
        if (entity == null) {
            options,  
        ActionListener<MultiSearchTemplateResponse> listener
     *
    public final Cancellable mgetAsync(MultiGetRequest multiGetRequest, RequestOptions options, ActionListener<MultiGetResponse> listener) {
            RequestConverters::rethrottleDeleteByQuery,
    /**  
                } else {  
            RankEvalResponse::fromXContent,
    public final Cancellable getSourceAsync(  
            listener,
            RestHighLevelClient::convertExistsResponse,
     *
        return performRequestAndParseEntity(
 * license agreements. See the NOTICE file distributed with
            emptySet()
        return performRequestAsyncAndParseEntity(  
            deleteRequest,  
            listener,
            RequestConverters::searchTemplate,
        );  
import org.opensearch.script.mustache.SearchTemplateRequest;
import org.opensearch.search.aggregations.bucket.sampler.ParsedSampler;
            options,
            options,  
            singleton(409)  
            emptySet()
     */
        return performRequestAsyncAndParseEntity(
     * Asynchronously index a document using the Index API.  
     *
            getSourceRequest,  
     * @param listener          the listener to be notified upon request completion  
            options,  
            emptySet()  
            RequestConverters::rethrottleUpdateByQuery,  
     * @param listener the listener to be notified upon request completion  
            request,  
     * @param rankEvalRequest the request
            options,
    protected static boolean convertExistsResponse(Response response) {  
            }
            emptySet()
    }
    }
     * @return cancellable that may be used to cancel the request
            new NamedXContentRegistry.Entry(
    public final TasksClient tasks() {
    public final BulkByScrollResponse deleteByQuery(DeleteByQueryRequest deleteByQueryRequest, RequestOptions options) throws IOException {  
    protected final <Req extends ActionRequest, Resp> Resp performRequest(  
    protected final <Req extends ActionRequest, Resp> Cancellable performRequestAsync(  
            opensearchException = new OpenSearchStatusException(responseException.getMessage(), restStatus, responseException);  
import org.opensearch.search.aggregations.bucket.terms.SignificantLongTerms;
import org.opensearch.action.ActionRequestValidationException;
     * @param listener the listener to be notified upon request completion
        return performRequestAndParseEntity(  
        );
        if (validationException != null && validationException.validationErrors().isEmpty() == false) {  
        ActionListener<Resp> listener,
     * @param updateByQueryRequest the request  
            emptySet()  
     * @return cancellable that may be used to cancel the request  
            return Cancellable.NO_OP;
            return Optional.of(parseEntity(response.getEntity(), entityParser));
     * @return cancellable that may be used to cancel the request
    /**
            singleton(409)
        );  
     * @param createPitRequest the request  
     * @return cancellable that may be used to cancel the request
        map.put(StatsAggregationBuilder.NAME, (p, c) -> ParsedStats.fromXContent(p, (String) c));  
 * GitHub history for details.
            CheckedFunction<XContentParser, ExplainResponse, IOException> entityParser = parser -> ExplainResponse.fromXContent(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    }  
        DeleteByQueryRequest deleteByQueryRequest,
 * official <a href="https://github.com/opensearch-project/opensearch-java">OpenSearch Java client</a>  
            options,
     */
     * @return <code>true</code> if the ping succeeded, false otherwise  
    /**
        );  
import org.opensearch.client.core.CountRequest;
            options,
        }  
    ) {
    /**
 * then tries to parse the response body error details into a generic OpenSearchException and suppresses the original
        map.put(MultiTermsAggregationBuilder.NAME, (p, c) -> ParsedMultiTerms.fromXContent(p, (String) c));
        return performRequestAndParseEntity(
            emptySet()
    /**
        return performRequestAndParseEntity(
        );
     * Returns the low-level client that the current high-level client instance is using to perform requests  
        if (validationException != null && validationException.isPresent()) {
import org.opensearch.search.aggregations.bucket.adjacency.ParsedAdjacencyMatrix;  
        );
    final <Resp> ResponseListener wrapResponseListener404sOptional(
            options,
     * @param request the request  
import org.opensearch.action.explain.ExplainResponse;
     */  
     * @return the response
    public final Cancellable mtermvectorsAsync(
    @Override  
            options,
        } catch (Exception e) {
        map.put(FilterAggregationBuilder.NAME, (p, c) -> ParsedFilter.fromXContent(p, (String) c));
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.stream.Collectors;  
            ignores
    }
    }  
        for (NamedXContentProvider service : ServiceLoader.load(NamedXContentProvider.class)) {  
    /**  
    protected RestHighLevelClient(RestClientBuilder restClientBuilder, List<NamedXContentRegistry.Entry> namedXContentEntries) {
    }
            @Override  
                } catch (Exception e) {  
    public final Cancellable existsSourceAsync(GetRequest getRequest, RequestOptions options, ActionListener<Boolean> listener) {
        map.put(DoubleTerms.NAME, (p, c) -> ParsedDoubleTerms.fromXContent(p, (String) c));  
        return client.performRequestAsync(req, responseListener);
     *
            new NamedXContentRegistry.Entry(
     */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        req.setOptions(options);
    public final RankEvalResponse rankEval(RankEvalRequest rankEvalRequest, RequestOptions options) throws IOException {
            request,
     *  
        );
    /**
     */
import org.opensearch.search.aggregations.metrics.ParsedTDigestPercentileRanks;
            SearchTemplateResponse::fromXContent,
        );
     */  
import org.opensearch.search.aggregations.pipeline.ParsedBucketMetricValue;
    /**  
            BulkByScrollResponse::fromXContent,
    public GetStoredScriptResponse getScript(GetStoredScriptRequest request, RequestOptions options) throws IOException {
import org.opensearch.action.get.GetResponse;
import org.opensearch.search.aggregations.metrics.ScriptedMetricAggregationBuilder;
     * @param createPitRequest the request
        );
        Response response;
            RequestConverters::deleteByQuery,  
    /**  
        RequestOptions options,
import org.opensearch.search.aggregations.metrics.ParsedAvg;
    protected final <Req extends Validatable, Resp> Cancellable performRequestAsyncAndParseOptionalEntity(
            options,  
            throw new IllegalStateException("Unsupported Content-Type: " + entity.getContentType());
        ActionListener<MultiGetResponse> listener
        HttpEntity entity = response.getEntity();
    public final Cancellable msearchTemplateAsync(
            new MainRequest(),
     * a list of entries that allow to parse custom response sections added to OpenSearch through plugins.
    ) {
import org.opensearch.search.aggregations.bucket.nested.ReverseNestedAggregationBuilder;
     *
     * @param getRequest the request  
        map.put(VariableWidthHistogramAggregationBuilder.NAME, (p, c) -> ParsedVariableWidthHistogram.fromXContent(p, (String) c));
    public final BulkResponse bulk(BulkRequest bulkRequest, RequestOptions options) throws IOException {  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        Request req = requestConverter.apply(request);
     *  
            emptySet()  
        return performRequestAsyncAndParseEntity(
            ListTasksResponse::fromXContent,
        CheckedFunction<Req, Request, IOException> requestConverter,
     * @return cancellable that may be used to cancel the request
    }
            listener,  
     *  
    }
        RequestOptions options,
     *
        entries.add(
            listener  
        CheckedFunction<XContentParser, Resp, IOException> entityParser,  
        CheckedFunction<Response, Resp, IOException> responseConverter,  
        return performRequestAsyncAndParseEntity(
        return clusterClient;
     * @param listener the listener to be notified upon request completion
     * Retrieves a document by id using the Get API.
    public final Cancellable updateByQueryAsync(
            emptySet()
     */  
        );  
    /**  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    }
            options,  
     */
            emptySet()
    public final MultiGetResponse multiGet(MultiGetRequest multiGetRequest, RequestOptions options) throws IOException {  
     *  
     * @param reindexRequest the request
        Req request,  
     * Asynchronously checks for the existence of a document with a "_source" field. Returns true if it exists, false otherwise.
        }
import org.opensearch.client.core.GetSourceResponse;
 * @deprecated the {@code RestHighLevelClient} is deprecated and is going to be removed in future releases, please consider using the
            listener,
            emptySet()
     */  
            options,
    /**
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;
     */  
            listener,
        map.put(DateHistogramAggregationBuilder.NAME, (p, c) -> ParsedDateHistogram.fromXContent(p, (String) c));  
            options,  
     */  
     * Delete stored script by id.  
        MultiSearchRequest searchRequest,  
    }  
    /**  
        List<NamedXContentRegistry.Entry> entries = new ArrayList<>();
    ) {
    }
            r -> RequestConverters.search(r, "_search"),
            options,
     *  
    }  
    private final ClusterClient clusterClient = new ClusterClient(this);
import org.opensearch.action.search.DeletePitRequest;
        return performRequestAndParseEntity(  
     * @param request the request
     */
            request,  
     * @deprecated use {@link #existsSource(GetSourceRequest, RequestOptions)} instead
     * Defines a helper method for asynchronously performing a request.
 * {@link ResponseException}</li>
     */  
            emptySet()
 * software distributed under the License is distributed on an
import java.util.Optional;
     */
     *
    public final Cancellable searchScrollAsync(  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
import org.opensearch.search.aggregations.metrics.ParsedHDRPercentiles;
            options,
    /**
            ListTasksResponse::fromXContent,
            response -> parseEntity(response.getEntity(), entityParser),  
            RequestConverters::deleteScript,  
     * @param getRequest the request  
    /**
            CountResponse::fromXContent,  
        Set<Integer> ignores
    }  
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
import org.opensearch.core.xcontent.NamedXContentRegistry;
            emptySet()  
                    }
     *  
     * @param listener the listener to be notified upon request completion
     */
    /**
    /**
        map.put(MedianAbsoluteDeviationAggregationBuilder.NAME, (p, c) -> ParsedMedianAbsoluteDeviation.fromXContent(p, (String) c));
     *
    }  
        ActionListener<ListTasksResponse> listener
        return msearchAsync(searchRequest, options, listener);  
            RequestConverters::rankEval,
     */
            rethrottleRequest,
     * Retrieves the source field only of a document using GetSource API.  
    @Deprecated  
            listener,  
     * Submits a reindex task.  
    /**
import org.opensearch.search.aggregations.metrics.ParsedMedianAbsoluteDeviation;  
            RequestConverters::delete,
            listener,
                parser,  
     *
     *
    }
            public void onFailure(Exception exception) {
     * @param deleteRequest the request
 * The majority of the methods in this class come in two flavors, a blocking and an asynchronous version (e.g.  
        RequestOptions options,
            RequestConverters::multiSearchTemplate,  
    }
    protected final <Req extends Validatable, Resp> Resp performRequestAndParseEntity(  
    public GetSourceResponse getSource(GetSourceRequest getSourceRequest, RequestOptions options) throws IOException {  
     */
     * Executes a multi search using the msearch API.
     * @return cancellable that may be used to cancel the request  
            listener,
            emptySet()
    private <Req, Resp> Resp internalPerformRequest(
        );  
        map.put(HistogramAggregationBuilder.NAME, (p, c) -> ParsedHistogram.fromXContent(p, (String) c));
     */
     * @param clearScrollRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            AcknowledgedResponse::fromXContent,
        CheckedFunction<XContentParser, Resp, IOException> entityParser,
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
        entries.add(
     */  
        CheckedFunction<Req, Request, IOException> requestConverter,
     *  
    private final CheckedConsumer<RestClient, IOException> doClose;
    /**  
            RequestConverters::termVectors,
            emptySet()
    }
                opensearchException.addSuppressed(e);
        return performRequest(explainRequest, RequestConverters::explain, options, response -> {
     * Asynchronously executes an update by query request.
            emptySet()
import org.opensearch.search.aggregations.metrics.ParsedHDRPercentileRanks;  
    public final Cancellable updateByQueryRethrottleAsync(
import org.opensearch.search.aggregations.bucket.terms.ParsedSignificantLongTerms;
    }  
     * layer has been added to the ReST client, and requests should extend {@link Validatable} instead of {@link ActionRequest}.
     * @param listener the listener to be notified upon request completion
import org.opensearch.action.search.GetAllPitNodesResponse;
    ) {  
            emptySet()
     * @param explainRequest the request
    public final boolean exists(GetRequest getRequest, RequestOptions options) throws IOException {
    }  
    }
                        actionListener.onResponse(Optional.empty());
                (parser, context) -> PhraseSuggestion.fromXContent(parser, (String) context)  
            singleton(409)
            request,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
    protected final <Req extends Validatable, Resp> Resp performRequest(
    public final ListTasksResponse deleteByQueryRethrottle(RethrottleRequest rethrottleRequest, RequestOptions options) throws IOException {
            options,
                    return responseConverter.apply(e.getResponse());
    /**
     */
     *  
     */
     * Asynchronously execute an update by query rethrottle request.
    ) {
            emptySet()  
     * @return the response
        );
            RestHighLevelClient::convertExistsResponse,
        return new ResponseListener() {
    }
            options,
    public final Cancellable updateAsync(UpdateRequest updateRequest, RequestOptions options, ActionListener<UpdateResponse> listener) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
        RankEvalRequest rankEvalRequest,
            (request) -> RequestConverters.getAllPits(),
        return performRequestAsyncAndParseEntity(
        map.put(StringTerms.NAME, (p, c) -> ParsedStringTerms.fromXContent(p, (String) c));  
        );
    @Deprecated  
            response -> parseEntity(response.getEntity(), entityParser),
    /**
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;  
        }
 *
        ActionListener<BulkByScrollResponse> listener  
            RequestConverters::index,
     * Delete all point in time searches using delete all PITs API
    }
        return performRequestAsyncAndParseEntity(
     * @return the response
import org.opensearch.search.suggest.Suggest;
     * @deprecated use {@link #scrollAsync(SearchScrollRequest, RequestOptions, ActionListener)} instead
            putStoredScriptRequest,
    protected final <Req extends ActionRequest, Resp> Cancellable performRequestAsyncAndParseEntity(
                        }
    /**
import org.opensearch.action.get.GetRequest;
     * @param getRequest the request  
     * Asynchronously execute an delete by query rethrottle request.  
            emptySet()
/**
            return Cancellable.NO_OP;
        return performRequestAsync(
        CheckedFunction<Response, Resp, IOException> responseConverter,
            searchTemplateRequest,
     */  
                    // or an error for which parsing is completely different. We try to consider the 404 response as a valid one
import org.opensearch.index.reindex.DeleteByQueryRequest;
     */
        RequestOptions options,  
        );
     * @param searchScrollRequest the request
        Set<Integer> ignores  
            SearchResponse::fromXContent,  
            options,
     * Ignores deprecation warnings. This is appropriate because it is only
            CheckedFunction<XContentParser, ExplainResponse, IOException> entityParser = parser -> ExplainResponse.fromXContent(
                Suggest.Suggestion.class,
            .map(entry -> new NamedXContentRegistry.Entry(Aggregation.class, new ParseField(entry.getKey()), entry.getValue()))
        Set<Integer> ignores
import org.opensearch.OpenSearchException;
 *  
     * Provides a {@link SnapshotClient} which can be used to access the Snapshot API.
    ) throws IOException {
            request,
     */
        RequestOptions options,
                }  
            RequestConverters::deleteScript,
        );  
        return performRequestAsyncAndParseEntity(  
        return performRequestAsync(explainRequest, RequestConverters::explain, options, response -> {
            TermVectorsResponse::fromXContent,  
     * @return cancellable that may be used to cancel the request
        return performRequestAndParseEntity(
            RequestConverters::rethrottleReindex,
            options,  
        ActionListener<Optional<Resp>> listener
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
                            // this covers cases like get where 404 can either be a valid document not found response,
        CheckedFunction<Req, Request, IOException> requestConverter,  
    ) {  
     * Executes a delete by query request.  
    }
                try {
            options,  
    protected final <Req extends Validatable, Resp> Optional<Resp> performRequestAndParseOptionalEntity(  
        Set<Integer> ignores
    }  
     * @return the response
    ) throws IOException {
        return performRequestAsyncAndParseEntity(
    public Cancellable getScriptAsync(
            options,
    public final ListTasksResponse updateByQueryRethrottle(RethrottleRequest rethrottleRequest, RequestOptions options) throws IOException {
        return performRequestAndParseEntity(  
        RequestOptions options,
            return Cancellable.NO_OP;
     * @return cancellable that may be used to cancel the request  
            listener,  
    @Deprecated
     * @return Cancellable instance that may be used to cancel the request
import org.opensearch.action.search.DeletePitResponse;  
            RequestConverters::putScript,
import org.apache.hc.core5.http.HttpEntity;
                }
        RequestOptions options,
        Set<Integer> ignores
            options,
import org.opensearch.index.reindex.ReindexRequest;
        return performRequestAsyncAndParseEntity(
    }  
     * Executes a search request using the Search API.
        return performRequestAndParseEntity(  
    ) {
            GetStoredScriptResponse::fromXContent,
     * Clears one or more scroll ids using the Clear Scroll API.  
     *
     *
            RequestConverters::getSource,
    /**
        ActionListener<ClearScrollResponse> listener  
     * Retrieves multiple documents by id using the Multi Get API.
            RequestConverters::sourceExists,
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        ActionListener<AcknowledgedResponse> listener  
    }
            RequestConverters::multiSearch,  
        map.put(ValueCountAggregationBuilder.NAME, (p, c) -> ParsedValueCount.fromXContent(p, (String) c));
            listener,
     * @return the response
        try (XContentParser parser = mediaType.xContent().createParser(registry, DEPRECATION_HANDLER, entity.getContent())) {
     * Asynchronously Delete point in time searches using delete PIT API
     */
        return performRequestAsyncAndParseEntity(
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;  
    /**
    public final Cancellable existsSourceAsync(
        Request req = requestConverter.apply(request);
     */  
     *
            request,  
                opensearchException = new OpenSearchStatusException("Unable to parse response body", restStatus, responseException);  
     * @return Cancellable instance that may be used to cancel the request
            rethrottleRequest,  
     * layer has been added to the ReST client, and requests should extend {@link Validatable} instead of {@link ActionRequest}.
     *
            emptySet()
            RequestConverters::update,
    }
     */
            TaskSubmissionResponse::fromXContent,
 * this file be licensed under the Apache-2.0 license or a
            listener,
     * Loads and returns the {@link NamedXContentRegistry.Entry} parsers provided by plugins.
        );
     */
            updateByQueryRequest,
    public final Cancellable deleteAsync(DeleteRequest deleteRequest, RequestOptions options, ActionListener<DeleteResponse> listener) {
    public final GetResponse get(GetRequest getRequest, RequestOptions options) throws IOException {
                        actionListener.onFailure(parseResponseException(responseException));
        Req request,
    }
    }
     * Asynchronously executes a reindex request.
                    if (RestStatus.NOT_FOUND.getStatus() == response.getStatusLine().getStatusCode()) {
     * @param request the request
     * @return the response
            BulkByScrollResponse::fromXContent,
            RequestConverters::searchScroll,
            BulkResponse::fromXContent,
     * Asynchronously executes a request using the Field Capabilities API.
        return performRequestAndParseEntity(updateRequest, RequestConverters::update, options, UpdateResponse::fromXContent, emptySet());
            emptySet()  
import org.opensearch.search.aggregations.bucket.terms.SignificantStringTerms;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return performRequest(  
    }
    ) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        map.put(AdjacencyMatrixAggregationBuilder.NAME, (p, c) -> ParsedAdjacencyMatrix.fromXContent(p, (String) c));
        );  
     */  
     *  
    /**  
import org.opensearch.search.aggregations.bucket.sampler.InternalSampler;
            deleteRequest,  
        }, singleton(404));
    ) {
    public final MultiSearchResponse msearch(MultiSearchRequest multiSearchRequest, RequestOptions options) throws IOException {
            throw parseResponseException(e);
        map.put(GeoCentroidAggregationBuilder.NAME, (p, c) -> ParsedGeoCentroid.fromXContent(p, (String) c));
     * @return Cancellable instance that may be used to cancel the request  
import org.opensearch.core.xcontent.XContentParser;  
     * @param listener the listener to be notified upon request completion  
        Req request,
        Request req;
            listener,
    ) {
            DeletePitResponse::fromXContent,
                } catch (Exception e) {
    /**  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        }
import org.opensearch.search.aggregations.metrics.InternalHDRPercentiles;
            fieldCapabilitiesRequest,  
import org.opensearch.script.mustache.SearchTemplateResponse;  
     * Creates a {@link RestHighLevelClient} given the low level {@link RestClientBuilder} that allows to build the
     * @param listener the listener to be notified upon request completion
     */
     * @param listener the listener to be notified upon request completion
        );  
        this(restClientBuilder.build(), RestClient::close, namedXContentEntries);
     */
            RequestConverters::deletePit,  
        }  
    public boolean existsSource(GetRequest getRequest, RequestOptions options) throws IOException {
        Req request,
 * closing the {@link RestHighLevelClient} instance that wraps it.
            emptySet()  
import org.opensearch.client.core.MainRequest;
     */
        OpenSearchStatusException opensearchException;
        ActionRequestValidationException validationException = request.validate();
    ) {
            options,
     * @param listener the listener to be notified upon request completion
            (request) -> RequestConverters.ping(),
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            listener,
            GetSourceResponse::fromXContent,  
        map.put(FiltersAggregationBuilder.NAME, (p, c) -> ParsedFilters.fromXContent(p, (String) c));  
            RequestConverters::putScript,
        return snapshotClient;
            options,
        return performRequestAndParseEntity(
            RequestConverters::createPit,  
        ActionListener<ListTasksResponse> listener  
     * Asynchronously puts an stored script using the Scripting API.  
                    if (ignores.contains(response.getStatusLine().getStatusCode())) {
     * Asynchronously get all point in time searches using list all PITs API  
            SearchResponse::fromXContent,  
            @Override
                }
            emptySet()
import org.opensearch.index.reindex.UpdateByQueryRequest;  
            deleteByQueryRequest,
import org.opensearch.plugins.spi.NamedXContentProvider;
    public boolean existsSource(GetSourceRequest getSourceRequest, RequestOptions options) throws IOException {
     * @return the response
    }
        throws IOException {
        );
 * Unless required by applicable law or agreed to in writing,
    }
     * Provides an {@link IndicesClient} which can be used to access the Indices API.  
            options,
     * @param bulkRequest the request  
 * this work for additional information regarding copyright
     * @deprecated use {@link #scroll(SearchScrollRequest, RequestOptions)} instead
            RequestConverters::termVectors,
        return new ResponseListener() {  
            ListTasksResponse::fromXContent,  
import org.opensearch.script.mustache.MultiSearchTemplateRequest;  
        RequestOptions options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                opensearchException = parseEntity(entity, BytesRestResponse::errorFromXContent);  
    public final SearchResponse searchScroll(SearchScrollRequest searchScrollRequest, RequestOptions options) throws IOException {
            TaskSubmissionResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Asynchronously delete stored script by id.
            emptySet()
            options,  
            options,
        map.put(DateRangeAggregationBuilder.NAME, (p, c) -> ParsedDateRange.fromXContent(p, (String) c));
            options,
        return performRequest(  
            RequestConverters::multiGet,
    }
                    // first. If parsing of the response breaks, we fall back to parsing it as an error.  
     */
     */  
        return opensearchException;
    ) {
     * @return cancellable that may be used to cancel the request
     * Asynchronously retrieves multiple documents by id using the Multi Get API.
    public final Cancellable getAsync(GetRequest getRequest, RequestOptions options, ActionListener<GetResponse> listener) {
            options,
    public final GetAllPitNodesResponse getAllPits(RequestOptions options) throws IOException {
    private <Req, Resp> Cancellable internalPerformRequestAsync(
        );  
            options,
            options,
     */  
     */  
                parser,  
import org.opensearch.core.xcontent.DeprecationHandler;  
        req.setOptions(options);  
            return Cancellable.NO_OP;  
    ) {
        );  
        );
        return performRequestAndParseEntity(
            options,  
        Req request,
     */  
     */
     * @deprecated use {@link #msearchAsync(MultiSearchRequest, RequestOptions, ActionListener)} instead  
     */  
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
    /**  
import org.opensearch.client.core.MultiTermVectorsRequest;
    /**  
 *  
     * Executes a update by query request.
    }
     * Updates a document using the Update API.
     *
            singleton(409)
        List<NamedXContentRegistry.Entry> namedXContentEntries  
 * takes an implementation of an {@link ActionListener} as an argument that needs to implement methods that handle successful responses and
     * @return cancellable that may be used to cancel the request  
     * @return cancellable that may be used to cancel the request
        );
                    IOException ioe = new IOException("Unable to parse response body for " + response, e);  
     * @param deletePitRequest the request
    }  
        try {
    public final SearchTemplateResponse searchTemplate(SearchTemplateRequest searchTemplateRequest, RequestOptions options)
        CheckedFunction<Req, Request, IOException> requestConverter,
        RestClient restClient,
        ActionListener<TermVectorsResponse> listener
                (parser, context) -> TermSuggestion.fromXContent(parser, (String) context)
                new ParseField(CompletionSuggestionBuilder.SUGGESTION_NAME),  
import org.opensearch.search.aggregations.bucket.terms.ParsedUnsignedLongTerms;  
    ) {
        );  
    public final SnapshotClient snapshot() {  
            options,
            rethrottleRequest,
            ListTasksResponse::fromXContent,  
import org.opensearch.index.rankeval.RankEvalRequest;
    /**  
            RequestConverters::mtermVectors,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
        return performRequestAndParseEntity(
    /**  
        ResponseListener responseListener = wrapResponseListener404sOptional(
import org.opensearch.script.mustache.MultiSearchTemplateResponse;
     * Submits a update by query task.
            emptySet()
            return parseEntity(response.getEntity(), entityParser);  
     * Asynchronously Delete all point in time searches using delete all PITs API
     * @param searchScrollRequest the request  
     * Executes a request using the Ranking Evaluation API.
    ) {
        RequestOptions options,
        return scrollAsync(searchScrollRequest, options, listener);
    public final ListTasksResponse reindexRethrottle(RethrottleRequest rethrottleRequest, RequestOptions options) throws IOException {  
            getSourceRequest,
import org.opensearch.search.aggregations.metrics.ParsedGeoCentroid;
                } catch (Exception innerException) {
import org.opensearch.search.aggregations.bucket.terms.ParsedSignificantStringTerms;  
 * failure scenarios. Most of the blocking calls can throw an {@link IOException} or an unchecked {@link OpenSearchException} in the  
     *  
            req = requestConverter.apply(request);
     */
import org.opensearch.client.tasks.TaskSubmissionResponse;
                (parser, context) -> CompletionSuggestion.fromXContent(parser, (String) context)
     *
     * @return the response
     * Get the cluster info otherwise provided when sending an HTTP request to '/'
    public RestHighLevelClient(RestClientBuilder restClientBuilder) {
     * @param fieldCapabilitiesRequest the request
/*  
                    Response response = responseException.getResponse();
            listener,
        if (mediaType == null) {
import org.opensearch.search.aggregations.metrics.ParsedSum;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            deleteByQueryRequest,  
        ActionListener<SearchResponse> listener
    /**
    }
    /**
     */
    }
        map.put(CardinalityAggregationBuilder.NAME, (p, c) -> ParsedCardinality.fromXContent(p, (String) c));
            RequestConverters::multiGet,
    }  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.client.core.MainResponse;  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        RethrottleRequest rethrottleRequest,
        return performRequestAsync(  
        RestStatus restStatus = RestStatus.fromCode(response.getStatusLine().getStatusCode());  
    }
     */  
            emptySet()  
            RequestConverters::count,
    }  
     * @param listener the listener to be notified upon request completion
     * @param getRequest the request
     *
        CheckedFunction<Req, Request, IOException> requestConverter,  
 */
        return performRequest(request, requestConverter, options, response -> parseEntity(response.getEntity(), entityParser), ignores);
     * Asynchronously calls the Multi Term Vectors API  
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
        CheckedFunction<Response, Resp, IOException> responseConverter,  
     * Checks for the existence of a document with a "_source" field. Returns true if it exists, false otherwise.
        }  
     * @param options          the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        map.put(AvgAggregationBuilder.NAME, (p, c) -> ParsedAvg.fromXContent(p, (String) c));  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        RequestOptions options,
        return performRequestAsyncAndParseEntity(
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
    public final Cancellable multiGetAsync(
    private final IngestClient ingestClient = new IngestClient(this);
     * @param listener the listener to be notified upon request completion
    }
            );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion  
        CheckedFunction<XContentParser, Resp, IOException> entityParser,  
            return entityParser.apply(parser);
            RequestConverters::rankEval,
import org.opensearch.search.aggregations.bucket.histogram.VariableWidthHistogramAggregationBuilder;
            deleteByQueryRequest,
    @Deprecated
     *
    /**
        );
        Set<Integer> ignores  
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
            emptySet()
     * @param options           the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            emptySet()
     * @deprecated use {@link #existsSourceAsync(GetSourceRequest, RequestOptions, ActionListener)} instead
            clearScrollRequest,
 * This class can also be sub-classed to expose additional client methods that make use of endpoints added to OpenSearch through plugins,
        return ingestClient;  
        return indicesClient;
        ActionListener<MultiTermVectorsResponse> listener
        map.put(PercentilesBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedPercentilesBucket.fromXContent(p, (String) c));
     * @param rethrottleRequest the request
            deletePitRequest,
    }
     */
import static java.util.stream.Collectors.toList;
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.metrics.ParsedCardinality;  
            RequestConverters::getSource,  
import org.opensearch.search.aggregations.metrics.InternalHDRPercentileRanks;
    public final Cancellable searchAsync(SearchRequest searchRequest, RequestOptions options, ActionListener<SearchResponse> listener) {
        try {
     * @param reindexRequest the request  
    public final DeletePitResponse deleteAllPits(RequestOptions options) throws IOException {  
            multiGetRequest,
        entries.add(  
     * Asynchronously checks for the existence of a document with a "_source" field. Returns true if it exists, false otherwise.
            DeletePitResponse::fromXContent,
    ) {  
            (request) -> RequestConverters.getAllPits(),  
    public final Cancellable createPitAsync(
 * In case an already existing instance of a low-level REST client needs to be provided, this class can be subclassed and the
     */  
     * @return cancellable that may be used to cancel the request  
        Req request,  
            ListTasksResponse::fromXContent,
     *
            CreatePitResponse::fromXContent,
     */  
            IndexResponse::fromXContent,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * emitted there just mean that you are talking to an old version of
     */  
import org.opensearch.client.core.CountResponse;
    /**  
     * @deprecated If creating a new HLRC ReST API call, consider creating new actions instead of reusing server actions. The Validation  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        ActionListener<Boolean> listener
     * @return cancellable that may be used to cancel the request
        RethrottleRequest rethrottleRequest,  
     *
            emptySet()
     */  
            options,
     */
     */
            options,  
                new ParseField(TermSuggestionBuilder.SUGGESTION_NAME),
            emptySet()
    }
     * @return cancellable that may be used to cancel the request
            options,
            RequestConverters::exists,
     * @param multiGetRequest the request  
            reindexRequest,
        return performRequestAndParseEntity(
        return performRequestAndParseEntity(
    /**
    public final SearchResponse search(SearchRequest searchRequest, RequestOptions options) throws IOException {
    /**
            emptySet()  
            RequestConverters::getScript,
     * @return cancellable that may be used to cancel the request
import org.opensearch.search.aggregations.bucket.histogram.ParsedDateHistogram;
    /**
    public final void close() throws IOException {
        );
import org.opensearch.action.ActionRequest;
     *  
import org.opensearch.rest.BytesRestResponse;
            if (ignores.contains(e.getResponse().getStatusLine().getStatusCode())) {
    private final IndicesClient indicesClient = new IndicesClient(this);  
     * @param listener the listener to be notified upon request completion
    /**
            countRequest,  
        RequestOptions options,  
        Req request,  
    }
     *
            UpdateResponse::fromXContent,  
            SearchResponse::fromXContent,
        );  
        return performRequestAsyncAndParseEntity(
            response = client.performRequest(req);  
     * Executes a search using the Search Scroll API.  
import org.opensearch.search.aggregations.pipeline.ParsedSimpleValue;  
        return performRequestAndParseEntity(  
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;  
import org.opensearch.search.aggregations.metrics.ParsedMin;
import org.opensearch.core.rest.RestStatus;
            new MainRequest(),
     * Asynchronously executes a bulk request using the Bulk API.
     * @return the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
    }
     */  
        return performRequest(getRequest, RequestConverters::exists, options, RestHighLevelClient::convertExistsResponse, emptySet());  
     * @return the response  
     * @return cancellable that may be used to cancel the request
        }
    public final MainResponse info(RequestOptions options) throws IOException {
            ClearScrollResponse::fromXContent,  
    /**
        return performRequestAsyncAndParseEntity(  
import org.opensearch.search.aggregations.bucket.nested.ParsedNested;
    /**
     * Asynchronously get stored script by id.
     * @return the response  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        ClearScrollRequest clearScrollRequest,
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
     * Asynchronously clears one or more scroll ids using the Clear Scroll API.
    public final TaskSubmissionResponse submitUpdateByQueryTask(UpdateByQueryRequest updateByQueryRequest, RequestOptions options)
    /**
            GetResponse::fromXContent,  
     * @param options   the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                }
     * @param rethrottleRequest the request
import org.opensearch.client.core.TermVectorsResponse;
        ActionListener<Resp> actionListener,
            return Cancellable.NO_OP;  
        if (validationException != null && validationException.isPresent()) {
     */  
     * @param listener the listener to be notified upon request completion  
        return performRequestAsyncAndParseEntity(
     * Asynchronously executes a multi search using the msearch API.
     * @param listener the listener to be notified upon request completion
     * Asynchronously executes a count request using the Count API.  
import org.opensearch.search.aggregations.bucket.composite.ParsedComposite;
    public final Cancellable reindexRethrottleAsync(  
    }
     * Get stored script by id.
        );
            getSourceRequest,
            DeleteResponse::fromXContent,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
import org.opensearch.search.aggregations.bucket.terms.ParsedMultiTerms;
        map.put(LongTerms.NAME, (p, c) -> ParsedLongTerms.fromXContent(p, (String) c));
            listener,
    public final Cancellable clearScrollAsync(  
 * You may obtain a copy of the License at  
     * Provides common functionality for asynchronously performing a request.
            options,
    ) {
            CreatePitResponse::fromXContent,
            }  
            RequestConverters::multiSearch,
 * following cases:
        );  
        map.put(ExtendedStatsAggregationBuilder.NAME, (p, c) -> ParsedExtendedStats.fromXContent(p, (String) c));
    /**
    }
            r -> RequestConverters.search(r, "_search"),
            new MainRequest(),
                    } else {  
 * <p>
     * Asynchronously deletes a document by id using the Delete API.  
     * @param multiGetRequest the request
        return performRequestAndParseEntity(  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
import org.opensearch.action.bulk.BulkRequest;
    }
     * @param listener the listener to be notified upon request completion
            AcknowledgedResponse::fromXContent,
    /**  
    }
import org.opensearch.search.aggregations.metrics.ParsedStats;  
        return performRequestAsyncAndParseEntity(
     */  
            reindexRequest,  
            listener.onFailure(e);
            RequestConverters::updateByQuery,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            createPitRequest,
     *  
        return performRequestAsyncAndParseEntity(  
        ActionListener<Resp> listener,
        map.put(SignificantStringTerms.NAME, (p, c) -> ParsedSignificantStringTerms.fromXContent(p, (String) c));  
        }  
            RestHighLevelClient::convertExistsResponse,
 *
        RequestOptions options,
     *  
        );
import org.opensearch.search.aggregations.bucket.terms.ParsedLongTerms;  
            req = requestConverter.apply(request);  
            response = client.performRequest(req);
            emptySet()
    public final Cancellable explainAsync(ExplainRequest explainRequest, RequestOptions options, ActionListener<ExplainResponse> listener) {  
    public final IngestClient ingest() {
 */  
        throws IOException {
