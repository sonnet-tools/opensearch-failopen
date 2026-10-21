     * @return the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            RequestConverters::submitDeleteByQuery,
        return performRequestAsyncAndParseEntity(
            emptySet()
    public final Cancellable msearchTemplateAsync(
     *
     * @deprecated use {@link #mget(MultiGetRequest, RequestOptions)} instead
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *
            throw new IllegalStateException("Unsupported Content-Type: " + entity.getContentType());
    public final Cancellable deleteAllPitsAsync(RequestOptions options, ActionListener<DeletePitResponse> listener) {
        CheckedFunction<Req, Request, IOException> requestConverter,
    }
            CreatePitResponse::fromXContent,
     */
            listener,
        Set<Integer> ignores
     * @param reindexRequest the request
     * Loads and returns the {@link NamedXContentRegistry.Entry} parsers provided by plugins.
    }
import org.opensearch.search.aggregations.bucket.terms.ParsedSignificantStringTerms;
import org.opensearch.plugins.spi.NamedXContentProvider;
        return performRequestAsyncAndParseEntity(
        return performRequest(
     * @return cancellable that may be used to cancel the request
    public final Cancellable existsSourceAsync(
            public void onSuccess(Response response) {
            emptySet()
     * @return cancellable that may be used to cancel the request
     *
     * Asynchronously executes a search using the Search API.
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
     * Asynchronously executes a count request using the Count API.
     */
    /**
    }
            listener.onFailure(e);
    /**
            clearScrollRequest,
 */
     * @return <code>true</code> if the document exists, <code>false</code> otherwise
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            createPitRequest,
 * SPDX-License-Identifier: Apache-2.0
     *
     * @param countRequest the request
    /**
        } catch (Exception e) {
    /**
        ActionListener<Resp> listener,
     * Provides a {@link ClusterClient} which can be used to access the Cluster API.
        ActionRequestValidationException validationException = request.validate();
            options,
        );
        ActionListener<GetStoredScriptResponse> listener
            emptySet()
            updateRequest,
    /**
                Suggest.Suggestion.class,
    }
            reindexRequest,
     * @return the response
            requestConverter,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            RequestConverters::deleteByQuery,
     * @return cancellable that may be used to cancel the request
     * @deprecated use {@link #scroll(SearchScrollRequest, RequestOptions)} instead
     *
            RequestConverters::reindex,
            MultiGetResponse::fromXContent,
import org.opensearch.index.rankeval.RankEvalResponse;
     *
    }
     * @return the response
            request,
    ) {
 *
            listener,
            throw new IOException("Unable to parse response body for " + response, e);
    /**
        );
            options,
    private <Req, Resp> Cancellable internalPerformRequestAsync(
     * @param listener the listener to be notified upon request completion
        return performRequestAsync(
     * Asynchronously Delete point in time searches using delete PIT API
            RequestConverters::fieldCaps,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options           the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            req = requestConverter.apply(request);
     * @param listener          the listener to be notified upon request completion
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        return msearchAsync(searchRequest, options, listener);
        }
    }
        return performRequestAndParseEntity(
     * @return the response
 * KIND, either express or implied.  See the License for the
            BulkByScrollResponse::fromXContent,
     */
import org.opensearch.script.mustache.MultiSearchTemplateRequest;
     *
            request,
            MultiSearchResponse::fromXContext,
     * @return the response
                        actionListener.onResponse(Optional.empty());
            deleteRequest,
    /**
     */
        );
import org.opensearch.search.aggregations.bucket.nested.ReverseNestedAggregationBuilder;
            RequestConverters::searchScroll,
import org.opensearch.common.CheckedConsumer;
    }
            options,
            singleton(409)
            RequestConverters::deleteByQuery,
import org.opensearch.search.aggregations.metrics.ParsedCardinality;
     * @return Cancellable instance that may be used to cancel the request
    }
    /**
     * @return the response
import org.opensearch.search.aggregations.bucket.terms.SignificantStringTerms;
    /**
        map.put(HistogramAggregationBuilder.NAME, (p, c) -> ParsedHistogram.fromXContent(p, (String) c));
    public final Cancellable updateAsync(UpdateRequest updateRequest, RequestOptions options, ActionListener<UpdateResponse> listener) {
    public final Cancellable searchTemplateAsync(
        OpenSearchStatusException opensearchException;
    public final BulkResponse bulk(BulkRequest bulkRequest, RequestOptions options) throws IOException {
import org.opensearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;
 *
            listener,
    /**
    }
            AcknowledgedResponse::fromXContent,
    ) {
     * @param multiSearchRequest the request
import java.io.Closeable;
     * @param bulkRequest the request
     */
    public final Cancellable deletePitAsync(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return performRequestAndParseEntity(
                try {
            ListTasksResponse::fromXContent,
        RequestOptions options,
     */
        );
        );
                    // or an error for which parsing is completely different. We try to consider the 404 response as a valid one
import java.util.ArrayList;
        return performRequestAsyncAndParseEntity(
            return responseConverter.apply(response);
    @Deprecated
     *
import org.opensearch.search.aggregations.bucket.missing.MissingAggregationBuilder;
    }
            listener,
            return Optional.of(parseEntity(response.getEntity(), entityParser));
            AcknowledgedResponse::fromXContent,
        );
 * software distributed under the License is distributed on an
        map.put(LongTerms.NAME, (p, c) -> ParsedLongTerms.fromXContent(p, (String) c));
            fieldCapabilitiesRequest,
import org.opensearch.search.aggregations.bucket.sampler.ParsedSampler;
import org.opensearch.search.aggregations.metrics.ParsedTopHits;
     * @param rethrottleRequest the request
import org.opensearch.rest.BytesRestResponse;
     * @param deletePitRequest the request
            multiSearchTemplateRequest,
     * Submits a reindex task.
     */
    }
     * Executes a update by query rethrottle request.
     * @return the submission response
                opensearchException.addSuppressed(responseException);
        );
     * @return the response
     * @return the response
     * @param listener the listener to be notified upon request completion
     * @param listener the listener to be notified upon request completion
        PutStoredScriptRequest putStoredScriptRequest,
     * @param updateRequest the request
        CheckedFunction<Response, Resp, IOException> responseConverter,
     */
     * @param listener the listener to be notified upon request completion
 * High level REST client that wraps an instance of the low level {@link RestClient} and allows to build requests and read responses. The
    ) {
import org.opensearch.search.aggregations.bucket.terms.LongRareTerms;
     */
import org.opensearch.common.CheckedFunction;
            deletePitRequest,
     * @return cancellable that may be used to cancel the request
        ActionListener<Boolean> listener
     *
 * <p>
            listener,
    @Deprecated
     */
            options,
    }
        return performRequestAsync(
            RestHighLevelClient::convertExistsResponse,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                    Response response = responseException.getResponse();
     */
    ) throws IOException {
import org.opensearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;
            emptySet()
        this.registry = new NamedXContentRegistry(
    }
        RequestOptions options,
            listener,
            }
import org.opensearch.search.aggregations.pipeline.StatsBucketPipelineAggregationBuilder;
        if (validationException != null && validationException.validationErrors().isEmpty() == false) {
            options,
    /**
        );
        return performRequestAndParseEntity(
    ) {
            multiSearchTemplateRequest,
     * Calls the Term Vectors API
        ActionListener<Resp> actionListener,
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
    /**
     * @param getSourceRequest the request
            emptySet()
            emptySet()
        return performRequestAsyncAndParseEntity(
        Req request,
        );
            emptySet()
            listener,
import org.opensearch.search.aggregations.bucket.histogram.ParsedVariableWidthHistogram;
    /**
            searchScrollRequest,
     */
        CheckedFunction<Req, Request, IOException> requestConverter,
            options,
        CheckedFunction<Response, Resp, IOException> responseConverter,
     * Asynchronously execute an delete by query rethrottle request.
    }
        );
            SearchResponse::fromXContent,
        );
    private final IngestClient ingestClient = new IngestClient(this);
            new MainRequest(),
     * Asynchronously Delete all point in time searches using delete all PITs API
            return Cancellable.NO_OP;
 * This class can also be sub-classed to expose additional client methods that make use of endpoints added to OpenSearch through plugins,
        if (entity == null) {
     * @return cancellable that may be used to cancel the request
            RestHighLevelClient::convertExistsResponse,
            new NamedXContentRegistry.Entry(
     * Asynchronously puts an stored script using the Scripting API.
                opensearchException = new OpenSearchStatusException("Unable to parse response body", restStatus, responseException);
     * @return cancellable that may be used to cancel the request
    /**
            GetStoredScriptResponse::fromXContent,
     */
            emptySet()
    }
            multiGetRequest,
        RequestOptions options,
            emptySet()
    }
import org.opensearch.action.search.SearchResponse;
/**
        CheckedFunction<Req, Request, IOException> requestConverter,
            emptySet()
            options,
        map.put(InternalHDRPercentiles.NAME, (p, c) -> ParsedHDRPercentiles.fromXContent(p, (String) c));
        return performRequestAndParseEntity(
        MultiSearchRequest searchRequest,
            throw new IllegalArgumentException("The listener is required and cannot be null");
            options,
     * @param listener the listener to be notified upon request completion
            listener,
            options,
        map.put(GlobalAggregationBuilder.NAME, (p, c) -> ParsedGlobal.fromXContent(p, (String) c));
            options,
        MultiSearchRequest searchRequest,
import java.io.IOException;
     * @param request the request
        return performRequestAndParseEntity(
        }
import org.opensearch.search.aggregations.pipeline.ParsedPercentilesBucket;
     */
    public final ClusterClient cluster() {
        throws IOException {
import org.opensearch.client.core.TermVectorsResponse;
     *
import org.opensearch.search.aggregations.metrics.ParsedScriptedMetric;
            RequestConverters::searchScroll,
     * @param request   the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );
     *
        throws IOException {
     */
    ) {
    }
     * Asynchronously executes a delete by query request.
        CheckedFunction<Req, Request, IOException> requestConverter,
        CheckedFunction<Req, Request, IOException> requestConverter,
     * @return cancellable that may be used to cancel the request
        ResponseListener responseListener = wrapResponseListener(responseConverter, listener, ignores);
    }
    public final FieldCapabilitiesResponse fieldCaps(FieldCapabilitiesRequest fieldCapabilitiesRequest, RequestOptions options)
        return performRequestAndParseEntity(
        );
        map.put(SumAggregationBuilder.NAME, (p, c) -> ParsedSum.fromXContent(p, (String) c));
    public final RankEvalResponse rankEval(RankEvalRequest rankEvalRequest, RequestOptions options) throws IOException {
                convertExistsResponse(response)
 * under the License.
     * Asynchronously executes a multi search using the msearch API.
    /**
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
    protected final <Req extends Validatable, Resp> Cancellable performRequestAsyncAndParseEntity(
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
     * @return cancellable that may be used to cancel the request
        return performRequestAndParseEntity(
     *
 *
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;
        GetSourceRequest getSourceRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Executes a multi search using the msearch API.
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            RestHighLevelClient::convertExistsResponse,
package org.opensearch.client;
        }
    public final MultiGetResponse multiGet(MultiGetRequest multiGetRequest, RequestOptions options) throws IOException {
        RequestOptions options,
     * @param listener the listener to be notified upon request completion
     * Provides an {@link IndicesClient} which can be used to access the Indices API.
     * @return the response
            emptySet()
    public final TaskSubmissionResponse submitUpdateByQueryTask(UpdateByQueryRequest updateByQueryRequest, RequestOptions options)
import org.opensearch.script.mustache.SearchTemplateRequest;
    /**
import org.opensearch.action.search.MultiSearchRequest;
    }
    protected final <Req extends Validatable, Resp> Cancellable performRequestAsyncAndParseOptionalEntity(
     */
                    actionListener.onResponse(Optional.of(responseConverter.apply(response)));
     * @param listener the listener to be notified upon request completion
    /**
import org.opensearch.search.aggregations.bucket.sampler.InternalSampler;
        Response response = responseException.getResponse();
import org.opensearch.core.ParseField;
     * @return cancellable that may be used to cancel the request
        try {
     * Asynchronously get stored script by id.
     */
        RestStatus restStatus = RestStatus.fromCode(response.getStatusLine().getStatusCode());
            @Override
        try (XContentParser parser = mediaType.xContent().createParser(registry, DEPRECATION_HANDLER, entity.getContent())) {
            listener,
     * Submits a update by query task.
    public final MainResponse info(RequestOptions options) throws IOException {
 * {@link ResponseException}</li>
                opensearchException = parseEntity(entity, BytesRestResponse::errorFromXContent);
            options,
     * @param searchRequest the request
        );
     * Asynchronously executes a reindex request.
        return performRequestAsyncAndParseEntity(
     * Pings the remote OpenSearch cluster and returns true if the ping succeeded, false otherwise
        List<NamedXContentRegistry.Entry> entries = map.entrySet()
                Suggest.Suggestion.class,
     * @param request the request
     * Asynchronously retrieves the source field only of a document using GetSource API.
    private final TasksClient tasksClient = new TasksClient(this);
     * @param listener the listener to be notified upon request completion
            singleton(409)
        );
            public void onSuccess(Response response) {
            emptySet()
     *
    /**
    /**
            emptySet()
            getSourceRequest,
     * Puts an stored script using the Scripting API.
     * @param listener the listener to be notified upon request completion
        map.put(UnsignedLongTerms.NAME, (p, c) -> ParsedUnsignedLongTerms.fromXContent(p, (String) c));
    }
     * @param getRequest the request
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
        List<NamedXContentRegistry.Entry> namedXContentEntries
import org.opensearch.search.suggest.term.TermSuggestion;
     * layer has been added to the ReST client, and requests should extend {@link Validatable} instead of {@link ActionRequest}.
            ignores
     * @return cancellable that may be used to cancel the request
            RequestConverters::index,
        RequestOptions options,
            deletePitRequest,
    ) {
            RequestConverters::deleteScript,
     */
            rankEvalRequest,
        ActionListener<Resp> listener,
    /**
     * Creates a {@link RestHighLevelClient} given the low level {@link RestClientBuilder} that allows to build the
            RequestConverters::rethrottleReindex,
     *
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
    public final Cancellable searchAsync(SearchRequest searchRequest, RequestOptions options, ActionListener<SearchResponse> listener) {
            new MainRequest(),
     * @param updateByQueryRequest the request
     *
    public final Cancellable rankEvalAsync(
    public final BulkByScrollResponse deleteByQuery(DeleteByQueryRequest deleteByQueryRequest, RequestOptions options) throws IOException {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public final IndexResponse index(IndexRequest indexRequest, RequestOptions options) throws IOException {
     * @return <code>true</code> if the document and _source field exists, <code>false</code> otherwise
        CheckedFunction<XContentParser, Resp, IOException> entityParser,
        throws IOException {
     * exception as a suppressed exception. This method is guaranteed to not throw any exception eventually thrown while parsing.
    }
    /**
            getSourceRequest,
            GetAllPitNodesResponse::fromXContent,
    protected static boolean convertExistsResponse(Response response) {
     * @param deleteRequest the request
    public final Cancellable reindexAsync(
import org.opensearch.search.aggregations.metrics.ScriptedMetricAggregationBuilder;
        map.put(ScriptedMetricAggregationBuilder.NAME, (p, c) -> ParsedScriptedMetric.fromXContent(p, (String) c));
            emptySet()
        Req request,
        RequestOptions options,
     * @return cancellable that may be used to cancel the request
            CountResponse::fromXContent,
            listener,
    protected RestHighLevelClient(
     */
     */
                new ParseField(PhraseSuggestionBuilder.SUGGESTION_NAME),
     * @return cancellable that may be used to cancel the request
        ActionListener<ListTasksResponse> listener
        );
        CheckedFunction<Req, Request, IOException> requestConverter,
     * @return the response
    }
        );
            RequestConverters::multiSearchTemplate,
        );
            RequestConverters::getScript,
            options,
    ) {
            RequestConverters::reindex,
     * Asynchronously executes a search using the Search Scroll API.
    public final Cancellable createPitAsync(
     * @return cancellable that may be used to cancel the request
        );
            RequestConverters::multiSearch,
     *
            listener,
    /**
            options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *
     */
    }
    public final GetResponse get(GetRequest getRequest, RequestOptions options) throws IOException {
            FieldCapabilitiesResponse::fromXContent,
            RequestConverters::update,
     * Delete point in time searches using delete PIT API
     */
    public boolean existsSource(GetSourceRequest getSourceRequest, RequestOptions options) throws IOException {
        DeleteByQueryRequest deleteByQueryRequest,
            )
     * @param listener the listener to be notified upon request completion
import org.opensearch.search.aggregations.bucket.range.ParsedBinaryRange;
        entries.add(
    }
        ActionListener<MultiGetResponse> listener
    }
            throw new IllegalStateException("OpenSearch didn't return the [Content-Type] header, unable to parse response body");
 * <p>
 * <ul>
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            throw parseResponseException(e);
            new NamedXContentRegistry.Entry(
            options,
            listener,
    }
     */
            throw new IOException("Unable to parse response body for " + response, e);
                try {
import org.opensearch.action.explain.ExplainResponse;
 * Licensed to Elasticsearch under one or more contributor
            options,
     * @param reindexRequest the request
        return new ResponseListener() {
     */
            return Cancellable.NO_OP;
     * @return cancellable that may be used to cancel the request
     */
        map.put(MinAggregationBuilder.NAME, (p, c) -> ParsedMin.fromXContent(p, (String) c));
    ) {
            emptySet()
        }
            emptySet()
     * Executes a reindex request.
            emptySet()
        map.put(InternalTDigestPercentiles.NAME, (p, c) -> ParsedTDigestPercentiles.fromXContent(p, (String) c));
     * @param createPitRequest the request
        } catch (Exception e) {
        );
                    onFailure(ioe);
        map.put(SignificantLongTerms.NAME, (p, c) -> ParsedSignificantLongTerms.fromXContent(p, (String) c));
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 * failure scenarios. Most of the blocking calls can throw an {@link IOException} or an unchecked {@link OpenSearchException} in the
        CreatePitRequest createPitRequest,
            listener,
                }
        );
            options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
     */
            options,
        map.put(ValueCountAggregationBuilder.NAME, (p, c) -> ParsedValueCount.fromXContent(p, (String) c));
        return performRequest(
import org.opensearch.search.aggregations.metrics.ParsedValueCount;
    public final boolean exists(GetRequest getRequest, RequestOptions options) throws IOException {
    public final UpdateResponse update(UpdateRequest updateRequest, RequestOptions options) throws IOException {
        ActionListener<Optional<Resp>> actionListener
     */
     */
    /**
        return clusterClient;
    protected final <Req extends Validatable, Resp> Resp performRequest(
     * Asynchronously executes a request using the Ranking Evaluation API.
 * <p>
                    actionListener.onFailure(exception);
     * @return the response
     * @param listener the listener to be notified upon request completion
     * Provides common functionality for asynchronously performing a request.
     * @return Cancellable instance that may be used to cancel the request
     */
            getRequest,
     *
            options,
            public void onFailure(Exception exception) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            emptySet()
    public final SearchPipelineClient searchPipeline() {
        MediaType mediaType = MediaType.fromMediaType(entity.getContentType());
            updateByQueryRequest,
     * @param indexRequest the request
        Req request,
        CheckedFunction<XContentParser, Resp, IOException> entityParser,
     * @param deletePitRequest the request
     * @param fieldCapabilitiesRequest the request
     * Executes a count request using the Count API.
     * @param options   the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        Set<Integer> ignores
     * @return the response
 * specific language governing permissions and limitations
     */
     *
import org.opensearch.client.core.GetSourceResponse;
    /**
import java.util.List;
    public final GetAllPitNodesResponse getAllPits(RequestOptions options) throws IOException {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return internalPerformRequest(request, requestConverter, options, responseConverter, ignores);
        return performRequestAndParseEntity(
import org.opensearch.core.xcontent.ContextParser;
    private static final DeprecationHandler DEPRECATION_HANDLER = DeprecationHandler.IGNORE_DEPRECATIONS;
            emptySet()
            throw new IllegalStateException("Response body expected but not returned");
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param rethrottleRequest the request
            updateByQueryRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                            // this covers cases like get where 404 can either be a valid document not found response,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            singleton(409)
     * @param getSourceRequest the request
     * @return the response
            options,
            options,
            emptySet()
            ClearScrollResponse::fromXContent,
    }
                parser,
    }
     * Asynchronously checks for the existence of a document with a "_source" field. Returns true if it exists, false otherwise.
     * @param listener the listener to be notified upon request completion
        return performRequestAsyncAndParseEntity(
 */
            emptySet()
    /**
     * @param searchScrollRequest the request
    /**
    public final void close() throws IOException {
        Request req = requestConverter.apply(request);
        Optional<ValidationException> validationException = request.validate();
        map.put(ExtendedStatsBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedExtendedStatsBucket.fromXContent(p, (String) c));
     * @param searchTemplateRequest the request
        this(restClientBuilder.build(), RestClient::close, namedXContentEntries);
    }
    public final BulkByScrollResponse updateByQuery(UpdateByQueryRequest updateByQueryRequest, RequestOptions options) throws IOException {
     */
 * following cases:
        return performRequestAsyncAndParseEntity(
        );
            RequestConverters::fieldCaps,
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
     * Submits a delete by query task
                }
            putStoredScriptRequest,
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
    }
    /**
    protected final <Req extends Validatable, Resp> Optional<Resp> performRequestAndParseOptionalEntity(
    }
        RequestOptions options,
import java.util.Map;
        } catch (ResponseException e) {
    public final Cancellable deleteByQueryRethrottleAsync(
        );
            emptySet()
            options,
        HttpEntity entity = response.getEntity();
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return msearch(multiSearchRequest, options);
    }
import org.opensearch.search.aggregations.metrics.ParsedHDRPercentiles;
            options,
     * @param searchScrollRequest the request
            RequestConverters::sourceExists,
    public final MultiGetResponse mget(MultiGetRequest multiGetRequest, RequestOptions options) throws IOException {
import org.opensearch.action.get.GetRequest;
        ResponseListener responseListener = wrapResponseListener404sOptional(
            return Cancellable.NO_OP;
    /**
    /**
     * Also subclasses can provide parsers for custom response sections added to OpenSearch through plugins.
import org.opensearch.action.search.SearchRequest;
            emptySet()
}
            options,
            TermVectorsResponse::fromXContent,
    /**
    /**
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
                            actionListener.onResponse(responseConverter.apply(response));
        SearchTemplateRequest searchTemplateRequest,
    /**
        return performRequestAsyncAndParseEntity(
import java.util.HashMap;
            MultiSearchTemplateResponse::fromXContext,
     */
            options,
     * Deletes a document by id using the Delete API.
     * Asynchronously updates a document using the Update API.
        };
        map.put(MissingAggregationBuilder.NAME, (p, c) -> ParsedMissing.fromXContent(p, (String) c));
import org.opensearch.action.index.IndexResponse;
 * then tries to parse the response body error details into a generic OpenSearchException and suppresses the original
        CheckedFunction<XContentParser, Resp, IOException> entityParser
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    private final RestClient client;
     * @return cancellable that may be used to cancel the request
        for (NamedXContentProvider service : ServiceLoader.load(NamedXContentProvider.class)) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        Map<String, ContextParser<Object, ? extends Aggregation>> map = new HashMap<>();
                        }
        if (validationException != null && validationException.isPresent()) {
    @Deprecated
import org.opensearch.client.core.GetSourceRequest;
    public final Cancellable countAsync(CountRequest countRequest, RequestOptions options, ActionListener<CountResponse> listener) {
     * Checks for the existence of a document. Returns true if it exists, false otherwise.
        CheckedFunction<Req, Request, IOException> requestConverter,
        ActionListener<TermVectorsResponse> listener
        ActionRequestValidationException validationException = request.validate();
            MultiSearchResponse::fromXContext,
     * Asynchronously calls the Term Vectors API
        Set<Integer> ignores
        return performRequestAndParseEntity(
     *
        if (validationException != null && validationException.isPresent()) {
     * @param searchScrollRequest the request
        return performRequestAsyncAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    ) {
    @Override
     */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return cancellable that may be used to cancel the request
            emptySet()
            deleteByQueryRequest,
     */
     */
        ActionListener<MultiTermVectorsResponse> listener
     * @param multiGetRequest the request
     *
            CreatePitResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
import org.opensearch.core.xcontent.DeprecationHandler;
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
            options,
        return internalPerformRequestAsync(request, requestConverter, options, responseConverter, listener, ignores);
            request,
    ) {
     * Defines a helper method for asynchronously performing a request.
        return performRequestAndParseEntity(
            ClearScrollResponse::fromXContent,
                .collect(toList())
    ) {
import org.opensearch.search.aggregations.bucket.terms.ParsedSignificantLongTerms;
    /**
     * @return the response
        );
        ActionListener<SearchTemplateResponse> listener
        ActionListener<Resp> listener,
            DeletePitResponse::fromXContent,
                    actionListener.onResponse(responseConverter.apply(response));
     * Get stored script by id.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    @Deprecated
    public final Cancellable updateByQueryRethrottleAsync(
 * <li>an {@link OpenSearchException} is usually thrown in case where the server returns a 4xx or 5xx error code. The high-level client
                        actionListener.onFailure(parseResponseException(responseException));
        CheckedFunction<Req, Request, IOException> requestConverter,
     */
import org.opensearch.client.core.MultiTermVectorsResponse;
        return performRequestAndParseEntity(
    }
        Optional<ValidationException> validationException = request.validate();
            );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        ActionListener<DeletePitResponse> listener
                        actionListener.onFailure(parseResponseException(responseException));
            options,
     *
import org.opensearch.search.aggregations.metrics.ParsedStats;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    @Deprecated
     * @deprecated If creating a new HLRC ReST API call, consider creating new actions instead of reusing server actions. The Validation
        Optional<ValidationException> validationException = request.validate();
    }
        return performRequestAsync(explainRequest, RequestConverters::explain, options, response -> {
        Req request,
        RequestOptions options,
        return performRequestAsyncAndParseEntity(
    }
            RequestConverters::createPit,
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
            listener,
 */
    protected final <Req extends ActionRequest, Resp> Resp performRequestAndParseEntity(
        CheckedConsumer<RestClient, IOException> doClose,
 * {@link #search(SearchRequest, RequestOptions)} and {@link #searchAsync(SearchRequest, RequestOptions, ActionListener)}, where the later
        ActionListener<AcknowledgedResponse> listener
     * @param options          the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            options,
     * @param rethrottleRequest the request
        GetStoredScriptRequest request,
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the submission response
                }
     * @param searchRequest the request
     * @param getRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 * The majority of the methods in this class come in two flavors, a blocking and an asynchronous version (e.g.
    /**
    /**
            options,
        return performRequestAndParseEntity(
    public final TaskSubmissionResponse submitDeleteByQueryTask(DeleteByQueryRequest deleteByQueryRequest, RequestOptions options)
            listener,
                    // the exception is ignored as we now try to parse the response as an error.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param rankEvalRequest the request
     */
        return performRequestAndParseEntity(
        throws IOException {
     */
        RequestOptions options,
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
    }
     * @param multiSearchRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.core.action.ActionListener;
    @Deprecated
import org.opensearch.action.search.ClearScrollRequest;
            deleteRequest,
        RankEvalRequest rankEvalRequest,
            options,
        );
        );
import org.opensearch.action.update.UpdateResponse;
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
        Req request,
        return performRequestAsync(
        map.put(DateHistogramAggregationBuilder.NAME, (p, c) -> ParsedDateHistogram.fromXContent(p, (String) c));
     * @param deleteByQueryRequest the request
            emptySet()
     * @param multiGetRequest the request
            r -> RequestConverters.search(r, "_search"),
    }
            getSourceRequest,
     * @param listener the listener to be notified upon request completion
    public final Cancellable scrollAsync(
            options,
 * In case an already existing instance of a low-level REST client needs to be provided, this class can be subclassed and the
            DeletePitResponse::fromXContent,
        CheckedFunction<Response, Resp, IOException> responseConverter,
    }
            RequestConverters::get,
            listener,
            emptySet()
import org.opensearch.search.aggregations.bucket.range.ParsedGeoDistance;
            public void onFailure(Exception exception) {
    }
     *
        ActionListener<ListTasksResponse> listener
            options,
        );
        RequestOptions options,
 *
        );
    public Cancellable deleteScriptAsync(
            listener,
        RequestOptions options,
import org.opensearch.search.aggregations.metrics.ParsedExtendedStats;
     *
import org.opensearch.core.xcontent.NamedXContentRegistry;
    ) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return performRequestAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import static java.util.stream.Collectors.toList;
import org.opensearch.search.aggregations.bucket.terms.UnsignedLongTerms;
import org.opensearch.action.search.ClearScrollResponse;
    protected RestHighLevelClient(RestClientBuilder restClientBuilder, List<NamedXContentRegistry.Entry> namedXContentEntries) {
    /**
import org.opensearch.action.bulk.BulkResponse;
            listener,
     * @return the response
        RequestOptions options,
        map.put(InternalBucketMetricValue.NAME, (p, c) -> ParsedBucketMetricValue.fromXContent(p, (String) c));
     * Executes a delete by query rethrottle request.
     * Executes a reindex rethrottling request.
import org.opensearch.search.aggregations.bucket.nested.ParsedNested;
    public Cancellable putScriptAsync(
     */
    }
     */
     * Asynchronously calls the Multi Term Vectors API
        SearchScrollRequest searchScrollRequest,
     * @return the response
            GetSourceResponse::fromXContent,
     * Asynchronously executes a request using the Field Capabilities API.
            listener,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.search.aggregations.bucket.terms.ParsedStringRareTerms;
     */
    private final IndicesClient indicesClient = new IndicesClient(this);
        return performRequestAndParseEntity(
        );
            requestConverter,
    private final SearchPipelineClient searchPipelineClient = new SearchPipelineClient(this);
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
            options,
        ActionListener<ListTasksResponse> listener
        );
    }
import org.opensearch.action.search.CreatePitRequest;
        ActionListener<MultiSearchTemplateResponse> listener
     * Defines a helper method for requests that can 404 and in which case will return an empty Optional
import org.opensearch.search.aggregations.bucket.histogram.ParsedAutoDateHistogram;
    public final Cancellable getAllPitsAsync(RequestOptions options, ActionListener<GetAllPitNodesResponse> listener) {
            request,
     *
    }
        return performRequestAndParseEntity(
        map.put(SignificantStringTerms.NAME, (p, c) -> ParsedSignificantStringTerms.fromXContent(p, (String) c));
     * @param updateRequest the request
     * @return Cancellable instance that may be used to cancel the request
            listener,
                } catch (Exception e) {
        req.setOptions(options);
            ListTasksResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
            request,
     * Asynchronously executes a request using the Multi Search Template API
        ActionListener<Resp> listener,
            options,
        ActionListener<SearchResponse> listener
    ) {
        return searchPipelineClient;
                } catch (Exception e) {
     * @return the response
        );
            listener,
    }
import java.util.stream.Collectors;
            createPitRequest,
     */
            rethrottleRequest,
            options,
                        try {
            TaskSubmissionResponse::fromXContent,
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
     * @return the response
        ActionListener<BulkByScrollResponse> listener
import org.opensearch.action.update.UpdateRequest;
    }
        return new ResponseListener() {
            options,
        return performRequestAsyncAndParseEntity(
            RequestConverters::multiGet,
     * @param clearScrollRequest the request
            RequestConverters::exists,
    ) throws IOException {
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
    public final Cancellable explainAsync(ExplainRequest explainRequest, RequestOptions options, ActionListener<ExplainResponse> listener) {
        if (listener == null) {
     *
            response = client.performRequest(req);
    }
            @Override
import org.opensearch.search.aggregations.pipeline.PercentilesBucketPipelineAggregationBuilder;
     * @return cancellable that may be used to cancel the request
            rethrottleRequest,
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
        );
    /**
     * @param listener the listener to be notified upon request completion
import org.opensearch.search.aggregations.bucket.range.ParsedDateRange;
     * @return cancellable that may be used to cancel the request
            AcknowledgedResponse::fromXContent,
     *
     */
     * Executes a request using the Multi Search Template API.
        RequestOptions options,
    /**
                    }
            singleton(409)
            listener,
    public final Cancellable updateByQueryAsync(
            emptySet()
    /**
            ListTasksResponse::fromXContent,
        this.client = Objects.requireNonNull(restClient, "restClient must not be null");
            RequestConverters::deletePit,
            Collections.singleton(404)
    public final Cancellable reindexRethrottleAsync(
            emptySet()
        );
        CheckedFunction<XContentParser, Resp, IOException> entityParser,
    }
    public final Cancellable termvectorsAsync(
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
    protected final OpenSearchStatusException parseResponseException(ResponseException responseException) {
                new ParseField(CompletionSuggestionBuilder.SUGGESTION_NAME),
    ) {
     * @param searchRequest the request
/*
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                            // the exception is ignored as we now try to parse the response as an error.
     */
    }
            emptySet()
        Response response;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.action.delete.DeleteResponse;
     * @param getRequest the request
        }
     * Ignores deprecation warnings. This is appropriate because it is only
            ListTasksResponse::fromXContent,
 * ownership. Elasticsearch licenses this file to you under
                    throw parseResponseException(e);
     * Executes a reindex rethrottling request.
            )
import org.opensearch.search.aggregations.bucket.terms.SignificantLongTerms;
import org.opensearch.client.core.CountRequest;
    }
        }
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;
        } catch (Exception e) {
     *
    ) {
        return client.performRequestAsync(req, responseListener);
    }
    }
            RequestConverters::updateByQuery,
    protected final <Req extends ActionRequest, Resp> Resp performRequest(
        );
import org.opensearch.search.aggregations.metrics.ParsedAvg;
    /**
    public GetStoredScriptResponse getScript(GetStoredScriptRequest request, RequestOptions options) throws IOException {
    public final ClearScrollResponse clearScroll(ClearScrollRequest clearScrollRequest, RequestOptions options) throws IOException {
        Set<Integer> ignores
     *
        return performRequestAsync(
        map.put(InternalSampler.PARSER_NAME, (p, c) -> ParsedSampler.fromXContent(p, (String) c));
    ) {
            listener,
    /**
     */
    /**
import org.opensearch.client.core.MainRequest;
            options,
        } catch (Exception e) {
    private final CheckedConsumer<RestClient, IOException> doClose;
            @Override
            emptySet()
     * @param indexRequest the request
            RequestConverters::putScript,
    /**
    public final SearchTemplateResponse searchTemplate(SearchTemplateRequest searchTemplateRequest, RequestOptions options)
            emptySet()
    }
     *
    public final Cancellable bulkAsync(BulkRequest bulkRequest, RequestOptions options, ActionListener<BulkResponse> listener) {
        }
            searchScrollRequest,
            emptySet()
     * used to parse responses from OpenSearch. Any deprecation warnings
            singleton(404)
    public final IngestClient ingest() {
     * @return cancellable that may be used to cancel the request
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;
            emptySet()
     */
                    Response response = responseException.getResponse();
     */
        map.put(ExtendedStatsAggregationBuilder.NAME, (p, c) -> ParsedExtendedStats.fromXContent(p, (String) c));
    public RestHighLevelClient(RestClientBuilder restClientBuilder) {
    }
    /**
            if (RestStatus.NOT_FOUND.getStatus() == e.getResponse().getStatusLine().getStatusCode()) {
        map.put(IpRangeAggregationBuilder.NAME, (p, c) -> ParsedBinaryRange.fromXContent(p, (String) c));
     * Retrieves multiple documents by id using the Multi Get API.
            RequestConverters::deleteScript,
    public final SnapshotClient snapshot() {
            response -> parseEntity(response.getEntity(), entityParser),
            listener,
     * @return cancellable that may be used to cancel the request
            getSourceRequest,
            RequestConverters::sourceExists,
        ActionListener<CreatePitResponse> listener
    }
        try {
    }
            SearchResponse::fromXContent,
        return mgetAsync(multiGetRequest, options, listener);
     * @param bulkRequest the request
     */
     */
     * @return the response
    private final SnapshotClient snapshotClient = new SnapshotClient(this);
import org.opensearch.search.aggregations.metrics.ParsedMedianAbsoluteDeviation;
        );
import org.opensearch.action.search.CreatePitResponse;
    /**
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
                        } catch (Exception innerException) {
    public final Cancellable searchScrollAsync(
        RequestOptions options,
            options,
            singleton(404)
            options,
            emptySet()
     * @param request   the request
            RequestConverters::getSource,
     * @param getSourceRequest the request
     * @return <code>true</code> if the document and _source field exists, <code>false</code> otherwise
            opensearchException = new OpenSearchStatusException(responseException.getMessage(), restStatus, responseException);
            listener,
    @Deprecated
            RequestConverters::rethrottleReindex,
 * {@link #RestHighLevelClient(RestClient, CheckedConsumer, List)} constructor can be used.
            options,
            listener,
        map.put(WeightedAvgAggregationBuilder.NAME, (p, c) -> ParsedWeightedAvg.fromXContent(p, (String) c));
            multiSearchRequest,
import org.opensearch.search.aggregations.bucket.terms.ParsedStringTerms;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Asynchronously retrieves a document by id using the Get API.
    ) {
                (parser, context) -> TermSuggestion.fromXContent(parser, (String) context)
                try {
        map.put(VariableWidthHistogramAggregationBuilder.NAME, (p, c) -> ParsedVariableWidthHistogram.fromXContent(p, (String) c));
        try {
    /**
            TaskSubmissionResponse::fromXContent,
        RequestOptions options,
        Req request,
import org.opensearch.action.get.MultiGetResponse;
            RankEvalResponse::fromXContent,
            BulkResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public GetSourceResponse getSource(GetSourceRequest getSourceRequest, RequestOptions options) throws IOException {
            rethrottleRequest,
     * Defines a helper method for performing a request and then parsing the returned entity using the provided entityParser.
     *
            throw validationException;
import java.util.Objects;
    /**
        return performRequestAsyncAndParseEntity(
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
     * @param listener the listener to be notified upon request completion
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
                            actionListener.onFailure(parseResponseException(responseException));
    /**
    public final Cancellable fieldCapsAsync(
        RequestOptions options,
        ClearScrollRequest clearScrollRequest,
        return performRequestAndParseEntity(
        ActionListener<FieldCapabilitiesResponse> listener
     * Asynchronously executes an update by query request.
import org.opensearch.search.aggregations.pipeline.ParsedStatsBucket;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        }
     * @return the response
     * Asynchronously clears one or more scroll ids using the Clear Scroll API.
    /**
            new MainRequest(),
import static java.util.Collections.singleton;
     */
import org.opensearch.index.reindex.DeleteByQueryRequest;
     * Retrieves a document by id using the Get API.
    }
     * @param listener the listener to be notified upon request completion
        return performRequestAsyncAndParseEntity(
            SearchTemplateResponse::fromXContent,
            options,
            MultiGetResponse::fromXContent,
            return entityParser.apply(parser);
     * If no response body was returned or anything goes wrong while parsing the error, returns a new {@link OpenSearchStatusException}
    }
    public final BulkByScrollResponse reindex(ReindexRequest reindexRequest, RequestOptions options) throws IOException {
                (parser, context) -> CompletionSuggestion.fromXContent(parser, (String) context)
            listener,
            options,
    private final NamedXContentRegistry registry;
        return performRequestAndParseEntity(
        );
     * @return the response
            try {
     * Asynchronous request which returns empty {@link Optional}s in the case of 404s or parses entity into an Optional
     */
            BulkByScrollResponse::fromXContent,
        Req request,
        if (entity == null) {
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;
        );
            emptySet()
     * layer has been added to the ReST client, and requests should extend {@link Validatable} instead of {@link ActionRequest}.
        Req request,
            .collect(Collectors.toList());
import org.opensearch.search.suggest.completion.CompletionSuggestion;
     * Defines a helper method for asynchronously performing a request.
     * Creates a {@link RestHighLevelClient} given the low level {@link RestClientBuilder} that allows to build the
import org.opensearch.search.aggregations.pipeline.InternalBucketMetricValue;
     *
    public final Cancellable deleteAsync(DeleteRequest deleteRequest, RequestOptions options, ActionListener<DeleteResponse> listener) {
        MultiGetRequest multiGetRequest,
        FieldCapabilitiesRequest fieldCapabilitiesRequest,
import org.opensearch.search.aggregations.bucket.terms.StringRareTerms;
     */
     * @param multiGetRequest the request
    }
import org.opensearch.client.core.MultiTermVectorsRequest;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;
        UpdateByQueryRequest updateByQueryRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Index a document using the Index API.
import org.opensearch.search.aggregations.bucket.histogram.ParsedHistogram;
     */
     * @param putStoredScriptRequest the request
     * @return the response
                            // first. If parsing of the response breaks, we fall back to parsing it as an error.
        );
            GetStoredScriptResponse::fromXContent,
    }
    }
     * @return cancellable that may be used to cancel the request
    /**
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
 * compatible open source license.
    /**
        );
    }
                    } else {
            RequestConverters::rethrottleDeleteByQuery,
     * @return cancellable that may be used to cancel the request
            listener,
    public final Cancellable deleteByQueryAsync(
import org.opensearch.core.xcontent.XContentParser;
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param clearScrollRequest the request
            rankEvalRequest,
import org.opensearch.search.aggregations.metrics.ParsedMin;
     */
        if (validationException != null && validationException.isPresent()) {
     *
                } catch (Exception innerException) {
     * @param rankEvalRequest the request
    }
        GetSourceRequest getSourceRequest = GetSourceRequest.from(getRequest);
    /**
        Set<Integer> ignores
        Req request,
     *
     */
            listener.onFailure(e);
     * Asynchronously executes a bulk request using the Bulk API.
import org.opensearch.search.aggregations.pipeline.ExtendedStatsBucketPipelineAggregationBuilder;
    public final ListTasksResponse deleteByQueryRethrottle(RethrottleRequest rethrottleRequest, RequestOptions options) throws IOException {
     *
        );
            MultiTermVectorsResponse::fromXContent,
        RequestOptions options,
            }
            singleton(404)
public class RestHighLevelClient implements Closeable {
     * @return the response
    public final MultiSearchTemplateResponse msearchTemplate(MultiSearchTemplateRequest multiSearchTemplateRequest, RequestOptions options)
    ) {
    }
    }
 * takes an implementation of an {@link ActionListener} as an argument that needs to implement methods that handle successful responses and
            options,
        );
        }
    }
            emptySet()
    public final Cancellable mtermvectorsAsync(
    /**
            multiGetRequest,
            RequestConverters::termVectors,
import org.opensearch.script.mustache.MultiSearchTemplateResponse;
import org.opensearch.search.aggregations.metrics.ParsedSum;
        return performRequestAsyncAndParseEntity(
     * Defines a helper method for performing a request.
        Set<Integer> ignores
 *
     * @param listener the listener to be notified upon request completion
            request,
            ListTasksResponse::fromXContent,
        } else {
            options,
            searchRequest,
            RequestConverters::rethrottleUpdateByQuery,
import org.opensearch.search.aggregations.metrics.ParsedWeightedAvg;
        this(restClientBuilder, Collections.emptyList());
    public final ListTasksResponse reindexRethrottle(RethrottleRequest rethrottleRequest, RequestOptions options) throws IOException {
    public final TasksClient tasks() {
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.client.tasks.TaskSubmissionResponse;
        CheckedFunction<Response, Resp, IOException> responseConverter,
            RequestConverters::deletePit,
        return entries;
     *
            options,
        return performRequestAsyncAndParseEntity(
    public final CountResponse count(CountRequest countRequest, RequestOptions options) throws IOException {
        RequestOptions options,
            MultiTermVectorsResponse::fromXContent,
            RequestConverters::delete,
            listener,
            options,
     * Create PIT context using create PIT API
import org.opensearch.search.aggregations.bucket.missing.ParsedMissing;
        DeleteStoredScriptRequest request,
        if (mediaType == null) {
            options,
            options,
    }
     * @return cancellable that may be used to cancel the request
        return performRequestAsyncAndParseEntity(
     * @param options   the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            options,
                parser,
            emptySet()
    ) {
    ) {
     * Asynchronously executes a multi search using the msearch API.
    /**
        return performRequestAsyncAndParseEntity(
     * Executes a search using the Search Scroll API.
        entries.add(
            clearScrollRequest,
        SearchScrollRequest searchScrollRequest,
    /**
        return performRequest(request, requestConverter, options, response -> parseEntity(response.getEntity(), entityParser), ignores);
            listener,
    /**
            emptySet()
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        RequestOptions options,
    /**
     */
import org.opensearch.search.aggregations.pipeline.ParsedDerivative;
    public final SearchResponse search(SearchRequest searchRequest, RequestOptions options) throws IOException {
    public final DeleteResponse delete(DeleteRequest deleteRequest, RequestOptions options) throws IOException {
    public final ExplainResponse explain(ExplainRequest explainRequest, RequestOptions options) throws IOException {
    @Deprecated
        Request req = requestConverter.apply(request);
            emptySet()
    }
        return performRequestAsync(
     */
import org.opensearch.search.aggregations.bucket.composite.ParsedComposite;
     * OpenSearch. There isn't anything you can do about the deprecation.
        RequestOptions options,
            countRequest,
     * @param request the request
        return opensearchException;
            emptySet()
    /**
    ) {
    }
import org.opensearch.core.xcontent.MediaType;
     * @param rethrottleRequest the request
    ) {
     *
     */
        CheckedFunction<Response, Resp, IOException> responseConverter,
            throw parseResponseException(e);
    /**
import org.opensearch.search.aggregations.bucket.terms.ParsedLongRareTerms;
     *
 * the Apache License, Version 2.0 (the "License"); you may
    public final TermVectorsResponse termvectors(TermVectorsRequest request, RequestOptions options) throws IOException {
@Deprecated(since = "3.9.0")
            getSourceRequest,
            RequestConverters::rethrottleUpdateByQuery,
     * @return the submission response
     */
    }
        );
            BulkByScrollResponse::fromXContent,
import org.opensearch.action.ActionRequest;
    /**
    /**
            RequestConverters::delete,
        ActionListener<Optional<Resp>> listener
     * @return the response
            RequestConverters::rankEval,
            }
     * Provides a {@link SnapshotClient} which can be used to access the Snapshot API.
import org.opensearch.index.reindex.ReindexRequest;
     * {@link RestClient} to be used to perform requests and parsers for custom response sections added to OpenSearch through plugins.
     * @param listener the listener to be notified upon request completion
    /**
     * @param getSourceRequest the request
                            // or an error for which parsing is completely different. We try to consider the 404 response as a valid one
        );
        );
        map.put(DateRangeAggregationBuilder.NAME, (p, c) -> ParsedDateRange.fromXContent(p, (String) c));
import java.util.ServiceLoader;
 *
    }
        map.put(StatsAggregationBuilder.NAME, (p, c) -> ParsedStats.fromXContent(p, (String) c));
            new MainRequest(),
            RequestConverters::sourceExists,
    /**
        RequestOptions options,
        map.put(DerivativePipelineAggregationBuilder.NAME, (p, c) -> ParsedDerivative.fromXContent(p, (String) c));
            emptySet()
    /**
    }
     * @return Cancellable instance that may be used to cancel the request
    public final DeletePitResponse deleteAllPits(RequestOptions options) throws IOException {
        try {
        );
            options,
     * @param getRequest the request
    public final Cancellable getAsync(GetRequest getRequest, RequestOptions options, ActionListener<GetResponse> listener) {
    /**
        }
     * @return Cancellable instance that may be used to cancel the request
            searchRequest,
     * @return <code>true</code> if the ping succeeded, false otherwise
     *
            RankEvalResponse::fromXContent,
     * @param getRequest the request
    }
        return performRequestAndParseEntity(
     * Asynchronously executes a search using the Search Scroll API.
            (request) -> RequestConverters.deleteAllPits(),
            searchTemplateRequest,
            RequestConverters::getScript,
        Request req;
     *
        RequestOptions options,
        );
    public final Cancellable mgetAsync(MultiGetRequest multiGetRequest, RequestOptions options, ActionListener<MultiGetResponse> listener) {
     * Checks for the existence of a document with a "_source" field. Returns true if it exists, false otherwise.
            reindexRequest,
            new MainRequest(),
        map.put(GeoDistanceAggregationBuilder.NAME, (p, c) -> ParsedGeoDistance.fromXContent(p, (String) c));
        try {
    /**
     * @param deleteByQueryRequest the request
    public final MultiTermVectorsResponse mtermvectors(MultiTermVectorsRequest request, RequestOptions options) throws IOException {
            options,
            TermVectorsResponse::fromXContent,
/*
        CheckedFunction<Req, Request, IOException> requestConverter,
            options,
            rethrottleRequest,
import org.opensearch.client.core.MainResponse;
 * <li>an {@link IOException} is usually thrown in case of failing to parse the REST response in the high-level REST client, the request
        return mget(multiGetRequest, options);
        return performRequestAsyncAndParseEntity(
     * @param deleteRequest the request
     * Asynchronously checks for the existence of a document with a "_source" field. Returns true if it exists, false otherwise.
                convertExistsResponse(response)
     *
     */
    }
    }
            DeleteResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            fieldCapabilitiesRequest,
     *
        );
    ) throws IOException {
     *
                    IOException ioe = new IOException("Unable to parse response body for " + response, e);
import org.opensearch.script.mustache.SearchTemplateResponse;
    private final ClusterClient clusterClient = new ClusterClient(this);
                }
     */
            return parseEntity(response.getEntity(), entityParser);
        ReindexRequest reindexRequest,
            SearchResponse::fromXContent,
    }
 * Modifications Copyright OpenSearch Contributors. See
            options,
            rethrottleRequest,
            MultiSearchTemplateResponse::fromXContext,
    }
    /**
    /**
            searchTemplateRequest,
        return performRequestAsyncAndParseEntity(
     */
            DeletePitResponse::fromXContent,
    @Deprecated
     * @return the response
        MultiSearchTemplateRequest multiSearchTemplateRequest,
        );
     */
        return performRequestAndParseEntity(
        );
    /**
            response -> parseEntity(response.getEntity(), entityParser),
    /**
    }
 * official <a href="https://github.com/opensearch-project/opensearch-java">OpenSearch Java client</a>
import org.opensearch.search.aggregations.bucket.filter.ParsedFilter;
     */
        DeletePitRequest deletePitRequest,
    @Deprecated
    }
    public final Cancellable existsAsync(GetRequest getRequest, RequestOptions options, ActionListener<Boolean> listener) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
        }
        return performRequestAsyncAndParseEntity(
            Stream.of(getDefaultNamedXContents().stream(), getProvidedNamedXContents().stream(), namedXContentEntries.stream())
     *
        Req request,
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
                    if (RestStatus.NOT_FOUND.getStatus() == response.getStatusLine().getStatusCode()) {
    }
    }
                .flatMap(Function.identity())
    }
            }
    ) {
        );
     * @param listener the listener to be notified upon request completion
    }
import org.apache.hc.core5.http.HttpEntity;
import org.opensearch.search.aggregations.pipeline.ParsedExtendedStatsBucket;
        );
            reindexRequest,
     * Creates a {@link RestHighLevelClient} given the low level {@link RestClient} that it should use to perform requests and
     * @param listener the listener to be notified upon request completion
    @Deprecated
            return Cancellable.NO_OP;
        }
        ActionListener<BulkByScrollResponse> listener
            options,
     *
    public final Cancellable clearScrollAsync(
     * Asynchronously deletes a document by id using the Delete API.
    /**
                    onFailure(ioe);
     * @param putStoredScriptRequest the request
    }
     * @param request the request
        RequestOptions options,
                Suggest.Suggestion.class,
     * Updates a document using the Update API.
        return performRequestAsyncAndParseEntity(
        return performRequestAndParseEntity(indexRequest, RequestConverters::index, options, IndexResponse::fromXContent, emptySet());
            deleteByQueryRequest,
 * You may obtain a copy of the License at
 * not use this file except in compliance with the License.
     * @param request the request
     * Provides common functionality for performing a request.
        );
     *
            RequestConverters::multiSearchTemplate,
import org.opensearch.client.core.TermVectorsRequest;
import org.opensearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.opensearch.action.search.MultiSearchResponse;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            listener,
        );
        map.put(CompositeAggregationBuilder.NAME, (p, c) -> ParsedComposite.fromXContent(p, (String) c));
    /**
     *
     *
        map.put(AvgAggregationBuilder.NAME, (p, c) -> ParsedAvg.fromXContent(p, (String) c));
            SearchResponse::fromXContent,
     * Executes a multi search using the msearch API.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        }
     * @param listener the listener to be notified upon request completion
     * Checks for the existence of a document with a "_source" field. Returns true if it exists, false otherwise.
     * Executes a search request using the Search API.
     *
import org.opensearch.action.get.GetResponse;
     * @param rethrottleRequest the request
import org.opensearch.OpenSearchStatusException;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        if (validationException != null && validationException.isPresent()) {
        return performRequestAndParseEntity(
        );
     * Executes a request using the Explain API.
import org.opensearch.core.rest.RestStatus;
     * @return cancellable that may be used to cancel the request
    }
     * Get all point in time searches using list all PITs API
            BulkByScrollResponse::fromXContent,
            RestHighLevelClient::convertExistsResponse,
     * Clears one or more scroll ids using the Clear Scroll API.
            listener
     * @param explainRequest the request
     *
        RequestOptions options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        RequestOptions options,
     * otherwise tries to parse the response body
import static java.util.Collections.emptySet;
/*
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            listener,
            listener.onFailure(validationException.get());
     * @param updateByQueryRequest the request
        RestClient restClient,
        Set<Integer> ignores
        map.put(MultiTermsAggregationBuilder.NAME, (p, c) -> ParsedMultiTerms.fromXContent(p, (String) c));
import java.util.Set;
            r -> RequestConverters.search(r, "_search"),
        req.setOptions(options);
     */
     * Calls the Multi Term Vectors API
        map.put(AutoDateHistogramAggregationBuilder.NAME, (p, c) -> ParsedAutoDateHistogram.fromXContent(p, (String) c));
     * @return cancellable that may be used to cancel the request
 * closing the {@link RestHighLevelClient} instance that wraps it.
import org.opensearch.action.explain.ExplainRequest;
        CheckedFunction<Req, Request, IOException> requestConverter,
     */
        map.put(DoubleTerms.NAME, (p, c) -> ParsedDoubleTerms.fromXContent(p, (String) c));
            ListTasksResponse::fromXContent,
     *
            options,
     * @param countRequest the request
    public final Cancellable multiGetAsync(
     * @param rethrottleRequest the request
            AcknowledgedResponse::fromXContent,
 */
                    }
     * @param explainRequest the request
     */
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
                    IOException ioe = new IOException("Unable to parse response body for " + response, e);
        RethrottleRequest rethrottleRequest,
     * @return the response
        return performRequestAndParseEntity(
     * {@link RestClient} to be used to perform requests.
     * @param multiGetRequest the request
    final <Resp> ResponseListener wrapResponseListener(
     * @deprecated use {@link #existsSourceAsync(GetSourceRequest, RequestOptions, ActionListener)} instead
            RequestConverters::bulk,
            (request) -> RequestConverters.getAllPits(),
     * Delete stored script by id.
     */
            UpdateResponse::fromXContent,
            bulkRequest,
 * The OpenSearch Contributors require contributions made to
     */
     * Asynchronously index a document using the Index API.
     */
    public final ListTasksResponse updateByQueryRethrottle(RethrottleRequest rethrottleRequest, RequestOptions options) throws IOException {
     *
        return performRequestAsyncAndParseEntity(
        return client;
import org.opensearch.search.aggregations.Aggregation;
            RestHighLevelClient::convertExistsResponse,
import org.opensearch.search.aggregations.bucket.filter.ParsedFilters;
import java.util.Collections;
     * @param listener the listener to be notified upon request completion
     *
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
            RequestConverters::sourceExists,
            getRequest,
        map.put(FiltersAggregationBuilder.NAME, (p, c) -> ParsedFilters.fromXContent(p, (String) c));
        return performRequestAsyncAndParseEntity(
            return Cancellable.NO_OP;
            options,
            RequestConverters::clearScroll,
        return performRequestAsyncAndParseEntity(
    public final Cancellable getSourceAsync(
        } catch (ResponseException e) {
        RequestOptions options,
                    // first. If parsing of the response breaks, we fall back to parsing it as an error.
    }
import java.util.function.Function;
     * @return cancellable that may be used to cancel the request
        }, singleton(404));
                    return responseConverter.apply(e.getResponse());
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    }
     */
                    // this covers cases like get where 404 can either be a valid document not found response,
     * @param listener the listener to be notified upon request completion
     */
        }
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentileRanks;
    public final DeletePitResponse deletePit(DeletePitRequest deletePitRequest, RequestOptions options) throws IOException {
     * @param options           the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
 *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * layer has been added to the ReST client, and requests should extend {@link Validatable} instead of {@link ActionRequest}.
            putStoredScriptRequest,
        ActionListener<BulkByScrollResponse> listener
            response = client.performRequest(req);
 * license agreements. See the NOTICE file distributed with
        RequestOptions options,
    }
        );
     *
     *
        map.put(InternalTDigestPercentileRanks.NAME, (p, c) -> ParsedTDigestPercentileRanks.fromXContent(p, (String) c));
            }
        return ingestClient;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            .stream()
     * @param listener the listener to be notified upon request completion
     */
            RequestConverters::updateByQuery,
    }
            listener,
     * @param deleteByQueryRequest the request
    }
            GetSourceResponse::fromXContent,
     */
    public Cancellable getScriptAsync(
 * GitHub history for details.
     * @param reindexRequest the request
        entries.add(
        if (entity.getContentType() == null) {
import org.opensearch.search.aggregations.metrics.ParsedTDigestPercentileRanks;
                }
    /**
     * Converts a {@link ResponseException} obtained from the low level REST client into an {@link OpenSearchException}.
            request,
        CheckedFunction<Response, Resp, IOException> responseConverter,
            IndexResponse::fromXContent,
        return performRequest(request, requestConverter, options, response -> parseEntity(response.getEntity(), entityParser), ignores);
     * The consumer argument allows to control what needs to be done when the {@link #close()} method is called.
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentiles;
import org.opensearch.search.aggregations.pipeline.ParsedSimpleValue;
     * @param searchRequest the request
    ) throws IOException {
        Set<Integer> ignores
            getSourceRequest,
                    ResponseException responseException = (ResponseException) exception;
    }
     * @return the response
     */
    /**
        return client.performRequestAsync(req, responseListener);
     * @return the response
            (request) -> RequestConverters.deleteAllPits(),
     *
    /**
     * @deprecated If creating a new HLRC ReST API call, consider creating new actions instead of reusing server actions. The Validation
    /**
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
        return performRequestAndParseEntity(
     *
    ) {
    /**
            CheckedFunction<XContentParser, ExplainResponse, IOException> entityParser = parser -> ExplainResponse.fromXContent(
import org.opensearch.action.bulk.BulkRequest;
        );
    public final Cancellable indexAsync(IndexRequest indexRequest, RequestOptions options, ActionListener<IndexResponse> listener) {
    public AcknowledgedResponse deleteScript(DeleteStoredScriptRequest request, RequestOptions options) throws IOException {
            rethrottleRequest,
        map.put(ReverseNestedAggregationBuilder.NAME, (p, c) -> ParsedReverseNested.fromXContent(p, (String) c));
        RequestOptions options,
            deleteByQueryRequest,
        map.put(PercentilesBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedPercentilesBucket.fromXContent(p, (String) c));
        return performRequestAsyncAndParseEntity(
            emptySet()
            singleton(409)
        return performRequest(explainRequest, RequestConverters::explain, options, response -> {
            singleton(409)
            RequestConverters::rankEval,
     * @return the response
     * Delete all point in time searches using delete all PITs API
import org.opensearch.search.aggregations.bucket.range.ParsedRange;
        ActionListener<ClearScrollResponse> listener
        return scroll(searchScrollRequest, options);
            RequestConverters::getSource,
import org.opensearch.action.search.SearchScrollRequest;
            RequestConverters::searchTemplate,
            GetAllPitNodesResponse::fromXContent,
    }
    final <Resp> ResponseListener wrapResponseListener404sOptional(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.search.aggregations.metrics.ParsedMax;
import org.opensearch.search.aggregations.metrics.InternalHDRPercentiles;
    }
        ActionListener<Resp> listener,
     * Executes a request using the Field Capabilities API.
     */
import org.opensearch.search.aggregations.bucket.terms.ParsedUnsignedLongTerms;
            options,
        map.put(AdjacencyMatrixAggregationBuilder.NAME, (p, c) -> ParsedAdjacencyMatrix.fromXContent(p, (String) c));
        return snapshotClient;
     * @return Cancellable instance that may be used to cancel the request
    @Deprecated
    /**
    /**
    /**
     * @return cancellable that may be used to cancel the request
            }
        );
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;
     * @param createPitRequest the request
            request,
import org.opensearch.search.aggregations.bucket.adjacency.ParsedAdjacencyMatrix;
        return performRequest(
        CheckedFunction<XContentParser, Resp, IOException> entityParser,
    }
     * Executes a request using the Search Template API.
        }
     * Retrieves multiple documents by id using the Multi Get API.
     * Asynchronously retrieves multiple documents by id using the Multi Get API.
    /**
    ) throws IOException {
        CheckedFunction<Req, Request, IOException> requestConverter,
        ActionListener<RankEvalResponse> listener
     */
        RequestOptions options,
    protected final <Req extends ActionRequest, Resp> Cancellable performRequestAsync(
                    ResponseException responseException = (ResponseException) exception;
            emptySet()
            RequestConverters::searchTemplate,
     * @return the response
        );
import org.opensearch.search.suggest.Suggest;
        CheckedFunction<XContentParser, Resp, IOException> entityParser,
        map.put(InternalSimpleValue.NAME, (p, c) -> ParsedSimpleValue.fromXContent(p, (String) c));
            ignores
        return internalPerformRequestAsync(request, requestConverter, options, responseConverter, listener, ignores);
            throw validationException.get();
     * @param listener the listener to be notified upon request completion
        Set<Integer> ignores
    /**
    /**
     * Executes a search using the Search Scroll API.
        throws IOException {
        return performRequest(getRequest, RequestConverters::exists, options, RestHighLevelClient::convertExistsResponse, emptySet());
import org.opensearch.search.aggregations.metrics.GeoCentroidAggregationBuilder;
     * @param listener the listener to be notified upon request completion
                    actionListener.onFailure(exception);
     */
        map.put(FilterAggregationBuilder.NAME, (p, c) -> ParsedFilter.fromXContent(p, (String) c));
            options,
     * @deprecated If creating a new HLRC ReST API call, consider creating new actions instead of reusing server actions. The Validation
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
    }
            RequestConverters::multiGet,
     * Asynchronously retrieves multiple documents by id using the Multi Get API.
            emptySet()
            RequestConverters::termVectors,
     *
     *
        return internalPerformRequest(request, requestConverter, options, responseConverter, ignores);
     */
     */
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    public final Cancellable multiSearchAsync(
        );
    /**
            req = requestConverter.apply(request);
    /**
        RethrottleRequest rethrottleRequest,
     *
            new NamedXContentRegistry.Entry(
 * times out or similar cases where there is no response coming back from the OpenSearch server</li>
        map.put(RangeAggregationBuilder.NAME, (p, c) -> ParsedRange.fromXContent(p, (String) c));
        );
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Get the cluster info otherwise provided when sending an HTTP request to '/'
    ) {
            DeleteResponse::fromXContent,
        );
            new MainRequest(),
        ActionListener<GetSourceResponse> listener
        return performRequestAndParseEntity(
     */
import org.opensearch.search.aggregations.metrics.ParsedHDRPercentileRanks;
                if (exception instanceof ResponseException) {
                if (exception instanceof ResponseException) {
import org.opensearch.action.search.DeletePitResponse;
            listener.onFailure(validationException.get());
        RequestOptions options,
import org.opensearch.index.reindex.BulkByScrollResponse;
        };
     * @return the response
     * @return cancellable that may be used to cancel the request
import org.opensearch.search.aggregations.metrics.ParsedTDigestPercentiles;
        Response response;
            singleton(404)
     * This constructor can be called by subclasses in case an externally created low-level REST client needs to be provided.
     *
    /**
     *
     *
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;
     * Retrieves the source field only of a document using GetSource API.
        CheckedFunction<Req, Request, IOException> requestConverter,
     * Asynchronously executes a request using the Explain API.
            )
     * that wraps the original {@link ResponseException}. The potential exception obtained while parsing is added to the returned
     * Asynchronously checks for the existence of a document. Returns true if it exists, false otherwise.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            throw validationException.get();
    public final MultiSearchResponse multiSearch(MultiSearchRequest multiSearchRequest, RequestOptions options) throws IOException {
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
    /**
            emptySet()
    public AcknowledgedResponse putScript(PutStoredScriptRequest putStoredScriptRequest, RequestOptions options) throws IOException {
     * @param fieldCapabilitiesRequest the request
            searchRequest,
import org.opensearch.client.core.CountResponse;
            options,
 * this work for additional information regarding copyright
 * @deprecated the {@code RestHighLevelClient} is deprecated and is going to be removed in future releases, please consider using the
            .map(entry -> new NamedXContentRegistry.Entry(Aggregation.class, new ParseField(entry.getKey()), entry.getValue()))
    }
    }
     *
     */
        List<NamedXContentRegistry.Entry> entries = new ArrayList<>();
 * or to add support for custom response sections, again added to OpenSearch through plugins.
     * @return the response
        RequestOptions options,
            emptySet()
    /**
        );
            }
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;
            emptySet()
            if (ignores.contains(e.getResponse().getStatusLine().getStatusCode())) {
        Set<Integer> ignores
import org.opensearch.search.aggregations.pipeline.ParsedBucketMetricValue;
     * @return the response
        return performRequestAndParseEntity(
     * @deprecated use {@link #scrollAsync(SearchScrollRequest, RequestOptions, ActionListener)} instead
            listener.onFailure(validationException);
    protected final <Resp> Resp parseEntity(final HttpEntity entity, final CheckedFunction<XContentParser, Resp, IOException> entityParser)
    ) {
     * Asynchronously executes a request using the Search Template API.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return cancellable that may be used to cancel the request
            );
 *
        return performRequestAndParseEntity(
        Set<Integer> ignores
    private <Req, Resp> Resp internalPerformRequest(
     *
import org.opensearch.search.aggregations.bucket.nested.ParsedReverseNested;
     * @param listener the listener to be notified upon request completion
     * @deprecated use {@link #msearch(MultiSearchRequest, RequestOptions)} instead
import org.opensearch.search.aggregations.bucket.histogram.VariableWidthHistogramAggregationBuilder;
            CheckedFunction<XContentParser, ExplainResponse, IOException> entityParser = parser -> ExplainResponse.fromXContent(
    /**
    /**
import org.opensearch.action.search.GetAllPitNodesResponse;
import org.opensearch.search.aggregations.bucket.terms.ParsedMultiTerms;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            RequestConverters::count,
            RequestConverters::clearScroll,
        return performRequestAndParseEntity(
     * @return the response
        return performRequestAsyncAndParseEntity(
     */
        RequestOptions options,
        return entries;
    /**
     * layer has been added to the ReST client, and requests should extend {@link Validatable} instead of {@link ActionRequest}.
     * @param listener the listener to be notified upon request completion
     * @return cancellable that may be used to cancel the request
            options,
     * @param searchScrollRequest the request
            options,
        }
     * @deprecated use {@link #mgetAsync(MultiGetRequest, RequestOptions, ActionListener)} instead
        map.put(NestedAggregationBuilder.NAME, (p, c) -> ParsedNested.fromXContent(p, (String) c));
     * Executes a delete by query request.
            RestHighLevelClient::convertExistsResponse,
            emptySet()
import org.opensearch.index.reindex.UpdateByQueryRequest;
    protected final <Req extends ActionRequest, Resp> Cancellable performRequestAsyncAndParseEntity(
    }
 * Unless required by applicable law or agreed to in writing,
    ) {
        map.put(LongRareTerms.NAME, (p, c) -> ParsedLongRareTerms.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
        return tasksClient;
        return performRequestAndParseEntity(
            (request) -> RequestConverters.getAllPits(),
    /**
    }
     */
        if (validationException != null && validationException.validationErrors().isEmpty() == false) {
    /**
        doClose.accept(client);
     * Executes a request using the Ranking Evaluation API.
     * @return cancellable that may be used to cancel the request
            RequestConverters::rethrottleDeleteByQuery,
     *
            GetResponse::fromXContent,
    }
    }
        return performRequestAndParseEntity(bulkRequest, RequestConverters::bulk, options, BulkResponse::fromXContent, emptySet());
    }
        }
     *
            options,
    /**
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    static List<NamedXContentRegistry.Entry> getProvidedNamedXContents() {
    /**
                } else {
        RequestOptions options,
        return performRequestAndParseEntity(updateRequest, RequestConverters::update, options, UpdateResponse::fromXContent, emptySet());
        );
    }
     * @return the response
                (parser, context) -> PhraseSuggestion.fromXContent(parser, (String) context)
 * </ul>
        Req request,
            RequestConverters::mtermVectors,
            response -> parseEntity(response.getEntity(), entityParser),
     */
    public final RestClient getLowLevelClient() {
            options,
     */
    /**
            options,
import java.util.Optional;
            entries.addAll(service.getNamedXContentParsers());
        Request req;
     * @return cancellable that may be used to cancel the request
import org.opensearch.search.aggregations.metrics.InternalHDRPercentileRanks;
     * Provides a {@link IngestClient} which can be used to access the Ingest API.
     * a list of entries that allow to parse custom response sections added to OpenSearch through plugins.
    ) {
    }
    /**
import org.opensearch.index.rankeval.RankEvalRequest;
    public boolean existsSource(GetRequest getRequest, RequestOptions options) throws IOException {
    ) {
                    if (ignores.contains(response.getStatusLine().getStatusCode())) {
     */
    }
        throws IOException {
        ActionListener<MultiSearchResponse> listener
            @Override
            (request) -> RequestConverters.ping(),
    }
            options,
        CheckedFunction<Response, Resp, IOException> responseConverter,
            emptySet()
     */
    }
        map.put(CardinalityAggregationBuilder.NAME, (p, c) -> ParsedCardinality.fromXContent(p, (String) c));
        RequestOptions options,
            listener,
     * @param updateByQueryRequest the request
            RequestConverters::submitReindex,
     */
        );
import org.opensearch.search.aggregations.bucket.terms.ParsedDoubleTerms;
            emptySet()
            RequestConverters::createPit,
            emptySet()
            options,
     * emitted there just mean that you are talking to an old version of
    }
        ActionListener<AcknowledgedResponse> listener
            RequestConverters::mtermVectors,
        return performRequestAsyncAndParseEntity(
            updateByQueryRequest,
    ) {
                    } else {
    ) {
    protected final <Req extends Validatable, Resp> Resp performRequestAndParseEntity(
            BulkByScrollResponse::fromXContent,
            BulkByScrollResponse::fromXContent,
     * Asynchronously get all point in time searches using list all PITs API
        map.put(InternalHDRPercentileRanks.NAME, (p, c) -> ParsedHDRPercentileRanks.fromXContent(p, (String) c));
import org.opensearch.OpenSearchException;
import org.opensearch.search.aggregations.bucket.histogram.ParsedDateHistogram;
    /**
        map.put(StringRareTerms.NAME, (p, c) -> ParsedStringRareTerms.fromXContent(p, (String) c));
     */
        Optional<ValidationException> validationException = request.validate();
            indexRequest,
     *
    /**
     */
     * @param listener the listener to be notified upon request completion
        );
     *
            options,
        TermVectorsRequest request,
import org.opensearch.action.search.DeletePitRequest;
import java.util.stream.Stream;
        RequestOptions options,
    ) {
import org.opensearch.search.aggregations.metrics.ParsedGeoCentroid;
     */
                return Optional.empty();
            RequestConverters::putScript,
            MainResponse::fromXContent,
        map.put(TopHitsAggregationBuilder.NAME, (p, c) -> ParsedTopHits.fromXContent(p, (String) c));
     *
        );
    public final CreatePitResponse createPit(CreatePitRequest createPitRequest, RequestOptions options) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
     */
     *
        return response.getStatusLine().getStatusCode() == 200;
     * Executes a update by query request.
    public final SearchResponse scroll(SearchScrollRequest searchScrollRequest, RequestOptions options) throws IOException {
    public final Cancellable existsSourceAsync(GetRequest getRequest, RequestOptions options, ActionListener<Boolean> listener) {
     * @param listener the listener to be notified upon request completion
            emptySet()
     * If a response body was returned, tries to parse it as an error returned from OpenSearch.
            emptySet()
    ) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Returns the low-level client that the current high-level client instance is using to perform requests
        );
            TaskSubmissionResponse::fromXContent,
        GetSourceRequest getSourceRequest,
        MultiTermVectorsRequest request,
     *
        return performRequestAndParseEntity(countRequest, RequestConverters::count, options, CountResponse::fromXContent, emptySet());
     * Asynchronously execute an update by query rethrottle request.
        return performRequestAsyncAndParseEntity(
     * Provides a {@link TasksClient} which can be used to access the Tasks API.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        ActionListener<SearchResponse> listener
     */
     * @param listener the listener to be notified upon request completion
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );
     * @param getRequest the request
                opensearchException.addSuppressed(e);
        CheckedFunction<Response, Resp, IOException> responseConverter,
                new ParseField(TermSuggestionBuilder.SUGGESTION_NAME),
            return parseEntity(response.getEntity(), entityParser);
    ) {
            options,
        map.put(StatsBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedStatsBucket.fromXContent(p, (String) c));
            (request) -> RequestConverters.info(),
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
    }
    public final TaskSubmissionResponse submitReindexTask(ReindexRequest reindexRequest, RequestOptions options) throws IOException {
            options,
            request,
        return performRequestAndParseEntity(
     * Executes a bulk request using the Bulk API.
                } else {
    ) throws IOException {
        return performRequestAndParseEntity(
import org.opensearch.search.aggregations.bucket.global.ParsedGlobal;
     *
     */
            emptySet()
     * Asynchronously delete stored script by id.
            listener,
            options,
    public final MultiSearchResponse msearch(MultiSearchRequest multiSearchRequest, RequestOptions options) throws IOException {
        );
import org.opensearch.action.get.MultiGetRequest;
     * @deprecated use {@link #msearchAsync(MultiSearchRequest, RequestOptions, ActionListener)} instead
    public final IndicesClient indices() {
        }, listener, singleton(404));
     * @return cancellable that may be used to cancel the request
            FieldCapabilitiesResponse::fromXContent,
        return performRequestAndParseEntity(getRequest, RequestConverters::get, options, GetResponse::fromXContent, singleton(404));
     * @param listener the listener to be notified upon request completion
    /**
    public final Cancellable msearchAsync(
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
     * @return cancellable that may be used to cancel the request
     * @deprecated use {@link #existsSource(GetSourceRequest, RequestOptions)} instead
    public final boolean ping(RequestOptions options) throws IOException {
        );
        map.put(GeoCentroidAggregationBuilder.NAME, (p, c) -> ParsedGeoCentroid.fromXContent(p, (String) c));
     * @deprecated If creating a new HLRC ReST API call, consider creating new actions instead of reusing server actions. The Validation
        this.doClose = Objects.requireNonNull(doClose, "doClose consumer must not be null");
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.action.index.IndexRequest;
        RequestOptions options,
    static List<NamedXContentRegistry.Entry> getDefaultNamedXContents() {
        return indicesClient;
        RethrottleRequest rethrottleRequest,
import org.opensearch.action.delete.DeleteRequest;
        return performRequestAsyncAndParseEntity(
            RequestConverters::multiSearch,
    /**
        map.put(MedianAbsoluteDeviationAggregationBuilder.NAME, (p, c) -> ParsedMedianAbsoluteDeviation.fromXContent(p, (String) c));
        Req request,
    protected final <Req extends Validatable, Resp> Cancellable performRequestAsync(
        return performRequestAsyncAndParseEntity(
    public final SearchResponse searchScroll(SearchScrollRequest searchScrollRequest, RequestOptions options) throws IOException {
        try {
        req.setOptions(options);
        req.setOptions(options);
            RequestConverters::submitUpdateByQuery,
        GetSourceRequest getSourceRequest = GetSourceRequest.from(getRequest);
        return performRequestAsyncAndParseEntity(
            SearchTemplateResponse::fromXContent,
    }
            } catch (Exception e) {
            emptySet()
     */
        return scrollAsync(searchScrollRequest, options, listener);
            request,
            DeletePitResponse::fromXContent,
     * @return the response
    /**
 * {@link RestClient} instance is internally built based on the provided {@link RestClientBuilder} and it gets closed automatically when
     */
    }
        RequestOptions options,
     */
        ActionListener<MultiSearchResponse> listener
        }
     * Asynchronously Create PIT context using create PIT API
    }
            emptySet()
     *
            listener,
        map.put(MaxAggregationBuilder.NAME, (p, c) -> ParsedMax.fromXContent(p, (String) c));
        map.put(StringTerms.NAME, (p, c) -> ParsedStringTerms.fromXContent(p, (String) c));
