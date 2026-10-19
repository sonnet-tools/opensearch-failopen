                )
    public void testTransformSearchPhaseWithSystemGeneratedPipeline() throws Exception {
    public void testTransformRequestWithSystemGeneratedPipeline() throws Exception {
        // verify
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(10);
        SearchRequest request = new SearchRequest("my-index").source(sourceBuilder).pipeline("p1");
                // system_scale_request_size_pre size = size*2 = 10
        );
        );
        SearchPipelineService service = createWithSystemGeneratedProcessors();
 * SPDX-License-Identifier: Apache-2.0
                    new BytesArray("{\"response_processors\" : [ { \"fixed_score\": { \"score\" : 2 } } ] }"),
        );
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(size));
                )
        enabledAllSystemGeneratedFactories(service);
                new PipelineConfiguration(
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(new TermQueryBuilder("foo", "bar")).size(size);
        clusterState = ClusterState.builder(clusterState)
     * request reports the pipeline it is actually using rather than the transformed request's id.
                fail("Failed to transform the request due to " + e.getMessage());
        assertEquals(1, resultAtomicArray.size());
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(request, null, indexNameExpressionResolver);
        int size = 10;
                )
            )
        assertEquals(SearchPipelineService.NOOP_PIPELINE_ID, resolvedNone.pipeline());
                "p1",
    }
 * this file be licensed under the Apache-2.0 license or a
    private SearchResponse createSearchResponse(int size) {
            searchPhaseResults,
            2,
     * id forward (the {@link SearchRequest} copy constructor invoked by {@code super(...)} does not), so the re-wrapped
        pipelinedRequest.transformSearchPhaseResults(
        searchRequest = new SearchRequest().pipeline("p1");
        for (int i = 0; i < size; i++) {
        // system_max_score_post maxScore = maxScore*2 = 200f
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
            searchPhaseResults,
        SearchPipelineService searchPipelineService = createWithProcessors();
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        assertEquals("p1", reWrapped.pipeline());
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
        // First try without specifying a pipeline, which should be a no-op.
        // Check Processor doesn't run for between other phases
import org.opensearch.cluster.ClusterChangedEvent;
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
                new PipelineConfiguration(
            SearchPhaseName.QUERY.getName()
 */
                new PipelineConfiguration(
import org.opensearch.cluster.ClusterName;
                "p1",
        enabledAllSystemGeneratedFactories(service);
        );
        SearchPipelineService searchPipelineService = createWithProcessors();
import java.util.Map;
        // system_max_score_pre maxScore = 100f
                // system_scale_score_pre score*2
        AtomicArray<SearchPhaseResult> notTransformedSearchPhaseResults = searchPhaseResults.getAtomicArray();
     * <p>Also covers the {@code _none} and unset (null) cases: an explicit {@code _none} id is carried forward
        for (int i = 0; i < size; i++) {
                "p1",
                // initial query size = 5
        searchRequest.source(createDefaultSearchSourceBuilder());
        );
            SearchProgressListener.NOOP,
            searchPhaseResults,
        final QuerySearchResult querySearchResult = new QuerySearchResult();
        SearchPipelineService service = createWithSystemGeneratedProcessors();
        SearchPhaseController controller = new SearchPhaseController(
            @Override
            .putCustom(SearchPipelineMetadata.TYPE, metadata)
                // verify
        for (SearchPhaseResult result : resultAtomicArray) {
            assertEquals(2.0, transformedResponse.getHits().getHits()[i].getScore(), 0.0001f);
        AtomicArray<SearchPhaseResult> notTransformedSearchPhaseResult = searchPhaseResults.getAtomicArray();
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
        Metadata.Builder mdBuilder = Metadata.builder()
        clusterState = ClusterState.builder(clusterState)
        QueryPhaseResultConsumer searchPhaseResults = new QueryPhaseResultConsumer(
            searchPhaseResults,
        SearchRequest searchRequest = new SearchRequest();
        List<SearchPhaseResult> resultAtomicArray = searchPhaseResults.getAtomicArray().asList();
                new PipelineConfiguration(
        searchRequest.source(createDefaultSearchSourceBuilder());
    }
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        enabledAllSystemGeneratedFactories(service);
     */
            SearchPhaseName.FETCH.getName()
        querySearchResult.topDocs(new TopDocsAndMaxScore(new TopDocs(null, new ScoreDoc[1]), 1f), null);
     * {@link SearchRequest} copy constructor, which does not copy the pipeline id, so the id is set explicitly in the
                    "p1",
            @Override
    /**
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);
            controller,
     * request's resolved pipeline, context, and system-generated holder. It must likewise carry the original's pipeline
        SearchPipelineService searchPipelineService = createWithProcessors();
                    "p1",
        SearchPipelineService service = createWithSystemGeneratedProcessors();
        // the no-op pipeline.
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(new TermQueryBuilder("foo", "bar")).size(10);
        searchRequest.source(createDefaultSearchSourceBuilder());
        // original's pipeline (the one it actually reuses), not the transformed request's id.
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
        PipelinedRequest resolvedDefault = searchPipelineService.resolvePipeline(noPipelineRequest, null, indexNameExpressionResolver);
                for (int i = 0; i < size; i++) {
import org.opensearch.search.SearchHit;
            .putCustom(SearchPipelineMetadata.TYPE, metadata)
                    MediaTypeRegistry.JSON
                )
import org.opensearch.core.action.ActionListener;
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
            SearchPhaseName.QUERY.getName(),
        searchRequest = new SearchRequest().pipeline("p1");
import org.opensearch.cluster.metadata.Metadata;
     * The resolved {@link PipelinedRequest} must carry the named pipeline id forward: it wraps the request through the
            Map.of(
            searchPhaseContext.getRequest(),
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
        Metadata.Builder mdBuilder = Metadata.builder()
import java.util.Collections;
        SearchPhaseController controller = new SearchPhaseController(
                // verify
            @Override
            searchPhaseContext,
        List<SearchPhaseResult> resultAtomicArray = searchPhaseResults.getAtomicArray().asList();
            searchPhaseContext,
        }
        PipelinedRequest original = searchPipelineService.resolvePipeline(request, null, indexNameExpressionResolver);
        );
            public void onFailure(Exception e) {
        SearchResponse searchResponse = createSearchResponse(size);
        // First try without specifying a pipeline, which should be a no-op.
/*
        // Specify the pipeline and use it to transform the request
        clusterState = ClusterState.builder(clusterState).metadata(mdBuilder).build();
    }
        );
            exc -> {}
            SearchProgressListener.NOOP,
        );
        clusterState = ClusterState.builder(clusterState).metadata(mdBuilder).build();
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
                    MediaTypeRegistry.JSON
            Map.of(
    public void testReWrappedRequestRetainsOriginalPipelineId() throws Exception {
        SearchRequest noneRequest = new SearchRequest("my-index").source(sourceBuilder).pipeline(SearchPipelineService.NOOP_PIPELINE_ID);
        ActionListener<SearchResponse> listener = pipelinedRequest.transformResponseListener(new ActionListener<SearchResponse>() {
                }
            writableRegistry(),
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
import org.opensearch.index.query.TermQueryBuilder;
        assertNull(resolvedDefault.pipeline());
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(10));
        assertEquals(SearchPipelineService.NOOP_PIPELINE_ID, resolvedDefault.getPipeline().getId());
        );
                    MediaTypeRegistry.JSON
                    "p1",
            SearchPhaseName.FETCH.getName()
            Map.of(
        assertSame(searchResponse, notTransformedResponse);
        // Now apply a pipeline
        ClusterState previousState = clusterState;
        );
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        request = new SearchRequest("my-index").source(sourceBuilder).pipeline("p1");
                // system_scale_request_size_post size = size*3 = 60
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
     *
        // updating the maxScore
        pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        ClusterState previousState = clusterState;
        }
        SearchHit[] hits = new SearchHit[size];
            }
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
        assertSame(searchPhaseResults.getAtomicArray(), notTransformedSearchPhaseResult);
        }
import java.util.List;
        searchRequest.source(createDefaultSearchSourceBuilder());
        PipelinedRequest resolvedNone = searchPipelineService.resolvePipeline(noneRequest, null, indexNameExpressionResolver);
        SearchPipelineService searchPipelineService = createWithProcessors();
            )
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
            )
            SearchPhaseName.QUERY.getName(),
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
        SearchRequest transformed = new SearchRequest("my-index").source(sourceBuilder).pipeline("some-other-id");
            2,
import org.opensearch.action.search.SearchRequest;
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
                    "p1",
        }
                    assertEquals(4.0 * i, searchResponse.getHits().getHits()[i].getScore(), 0.0001f);
        querySearchResult.topDocs(new TopDocsAndMaxScore(new TopDocs(null, new ScoreDoc[1]), 1f), null);
        clusterState = ClusterState.builder(clusterState).metadata(mdBuilder).build();
        SearchRequest request = new SearchRequest("my-index").source(sourceBuilder).pipeline("p1");
        setUpForResolvePipeline(service);
    }
        // The transformed request deliberately carries a different id; the re-wrapped request must report the
 *
import org.opensearch.action.search.SearchPhaseName;
        ClusterState previousState = clusterState;
            controller,
            assertEquals(200f, result.queryResult().topDocs().maxScore, 0);
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
            .put(indexBuilder("my-index").putAlias(AliasMetadata.builder("barbaz")));
            .put(indexBuilder("my-index").putAlias(AliasMetadata.builder("barbaz")));
            .build();
            SearchPhaseName.QUERY.getName(),
            public void onResponse(SearchRequest searchRequest) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(new TermQueryBuilder("foo", "bar")).size(10);
        SearchResponse searchResponse = createSearchResponse(size);
import org.opensearch.core.xcontent.MediaTypeRegistry;
                // user defined scale_request_size size = size*2 = 20
            }
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        ClusterState previousState = clusterState;
     * is the request the pipeline was resolved for, and consumers reading the id later in the request lifecycle (e.g.
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
    }
        // Explicit _none: the sentinel id is carried forward verbatim, and resolves to the no-op pipeline.
    public void testTransformResponse() throws Exception {
        setUpForResolvePipeline(service);
        assertEquals(SearchPipelineService.NOOP_PIPELINE_ID, resolvedNone.getPipeline().getId());
import org.opensearch.cluster.metadata.AliasMetadata;
            OpenSearchExecutors.newDirectExecutorService(),
        pipelinedRequest.transformSearchPhaseResults(
        searchPhaseResults.consumeResult(querySearchResult, () -> {});
import org.opensearch.core.common.bytes.BytesArray;
        pipelinedRequest = syncTransformRequest(searchPipelineService.resolvePipeline(request, null, indexNameExpressionResolver));
public class PipelinedRequestTests extends SearchPipelineTestCase {
    public void testResolvedRequestRetainsNamedPipelineId() throws Exception {
            )
import org.opensearch.search.query.QuerySearchResult;
    /**
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
                )
        pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
     * The re-wrapping constructor {@code PipelinedRequest(SearchRequest, PipelinedRequest)} reuses the original
            .build();
        for (SearchPhaseResult result : resultAtomicArray) {
 * compatible open source license.
                    "p1",
import org.opensearch.action.search.SearchResponse;
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(10);
            OpenSearchExecutors.newDirectExecutorService(),
            searchPipelineService.resolvePipeline(request, null, indexNameExpressionResolver)
            searchPhaseContext.getRequest(),
            .putCustom(SearchPipelineMetadata.TYPE, metadata)
            assertEquals(100f, result.queryResult().topDocs().maxScore, 0);
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        searchPhaseResults.consumeResult(querySearchResult, () -> {});
 * The OpenSearch Contributors require contributions made to
            Map.of(
        searchRequest = new SearchRequest().pipeline("p1");
import org.opensearch.search.SearchHits;
        listener.onResponse(searchResponse);
            public void onResponse(SearchResponse searchResponse) {
     * verbatim, and when no pipeline is requested {@code pipeline()} stays null while the resolved pipeline is the
        querySearchResult.setShardIndex(1);
import org.apache.lucene.search.TotalHits;
     * during coordinator query rewrite) would not see it.
        int size = 10;
        PipelinedRequest pipelinedRequest = syncTransformRequest(
        );
        QueryPhaseResultConsumer searchPhaseResults = new QueryPhaseResultConsumer(
        PipelinedRequest reWrapped = new PipelinedRequest(transformed, original);
    public void testTransformSearchPhase() throws Exception {
        int size = 10;
     */
package org.opensearch.search.pipeline;
            hits[i] = new SearchHit(i, "doc" + i, Collections.emptyMap(), Collections.emptyMap());
        SearchRequest request = new SearchRequest("my-index").source(sourceBuilder);
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
            }
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.ScoreDoc;
            searchPhaseContext,
    }
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            SearchPhaseName.FETCH.getName()
import org.opensearch.search.builder.SearchSourceBuilder;
        );
        SearchResponse notTransformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);
        ClusterState previousState = clusterState;
            hits[i].score(i);
    }
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
import org.opensearch.action.search.QueryPhaseResultConsumer;
        // Named pipeline: id is carried forward onto the resolved request.
        });
        assertSame(original.getPipeline(), reWrapped.getPipeline());
import org.opensearch.search.SearchPhaseResult;
        assertSame(searchPhaseResults.getAtomicArray(), notTransformedSearchPhaseResults);
    public void testTransformRequest() throws Exception {
        );
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));
                "p1",
        assertEquals("p1", pipelinedRequest.pipeline());
            )
            public void onFailure(Exception e) {
import org.opensearch.action.search.SearchResponseSections;
    }
        Metadata.Builder mdBuilder = Metadata.builder()
        assertEquals(2 * size, pipelinedRequest.source().size());
                    MediaTypeRegistry.JSON
        assertEquals(1, resultAtomicArray.size());
    public void testTransformResponseWithSystemGeneratedPipeline() throws Exception {
import org.opensearch.action.search.SearchProgressListener;
     * PipelinedRequest constructor. Otherwise {@code pipeline()} would read null on the resolved request even though it
        final QuerySearchResult querySearchResult = new QuerySearchResult();
                new PipelineConfiguration(
        setUpForResolvePipeline(service);
            searchPhaseContext,
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        querySearchResult.setShardIndex(1);
        // Now set the pipeline as p1
        // No pipeline requested: pipeline() stays null (nothing to carry forward), but the request still resolves to
                "p1",
        pipelinedRequest.transformSearchPhaseResults(
                assertEquals(60, pipelinedRequest.source().size());
        searchRequest.source(createDefaultSearchSourceBuilder());
            Map.of(
import org.opensearch.test.InternalAggregationTestCase;
        pipelinedRequest.transformSearchPhaseResults(
    }
        );
            exc -> {}
            @Override
            }
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
            SearchPhaseName.DFS_QUERY.getName(),
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
import org.opensearch.action.search.SearchPhaseController;
import org.opensearch.common.util.concurrent.AtomicArray;
        pipelinedRequest.transformRequest(new ActionListener<SearchRequest>() {
import org.opensearch.action.search.MockSearchPhaseContext;
        SearchRequest noPipelineRequest = new SearchRequest("my-index").source(sourceBuilder);
            writableRegistry(),
import org.opensearch.action.search.SearchPhaseContext;
                // system_scale_score_post score*2
        SearchPipelineService searchPipelineService = createWithProcessors();
            writableRegistry(),
                    new BytesArray("{\"phase_results_processors\" : [ { \"max_score\" : { } } ]}"),
        assertEquals(size, pipelinedRequest.source().size());
        assertEquals(size, transformedResponse.getHits().getHits().length);
            .put(indexBuilder("my-index").putAlias(AliasMetadata.builder("barbaz")));
        SearchRequest searchRequest = new SearchRequest();
        });
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
import org.opensearch.core.common.breaker.CircuitBreaker;
            writableRegistry(),
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
                    MediaTypeRegistry.JSON
}
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
     * no-op pipeline.
        SearchHits searchHits = new SearchHits(hits, new TotalHits(size, TotalHits.Relation.EQUAL_TO), size);
import org.opensearch.cluster.ClusterState;
                fail("Failed to transform the response due to " + e.getMessage());
        pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        // This request doesn't specify a pipeline, it doesn't get transformed.
