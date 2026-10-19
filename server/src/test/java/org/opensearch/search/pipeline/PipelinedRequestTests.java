        PipelinedRequest reWrapped = new PipelinedRequest(transformed, original);
            SearchPhaseName.DFS_QUERY.getName(),  
                for (int i = 0; i < size; i++) {
        clusterState = ClusterState.builder(clusterState)  
            writableRegistry(),  
                    "p1",
            hits[i] = new SearchHit(i, "doc" + i, Collections.emptyMap(), Collections.emptyMap());
        }
        querySearchResult.topDocs(new TopDocsAndMaxScore(new TopDocs(null, new ScoreDoc[1]), 1f), null);
    }  
                    "p1",
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));  
        setUpForResolvePipeline(service);
        Metadata.Builder mdBuilder = Metadata.builder()
import org.apache.lucene.search.TopDocs;
 * The OpenSearch Contributors require contributions made to  
        );
                    MediaTypeRegistry.JSON  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        SearchPipelineService searchPipelineService = createWithProcessors();  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(SearchPipelineService.NOOP_PIPELINE_ID, resolvedNone.pipeline());  
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
                    new BytesArray("{\"phase_results_processors\" : [ { \"max_score\" : { } } ]}"),  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        ClusterState previousState = clusterState;
        // Now apply a pipeline  
        assertEquals(SearchPipelineService.NOOP_PIPELINE_ID, resolvedNone.getPipeline().getId());
    private SearchResponse createSearchResponse(int size) {
        // system_max_score_pre maxScore = 100f
            OpenSearchExecutors.newDirectExecutorService(),  
import org.opensearch.common.util.concurrent.AtomicArray;
                "p1",  
                // verify  
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        ClusterState previousState = clusterState;
        SearchPipelineService service = createWithSystemGeneratedProcessors();  
                )  
     * during coordinator query rewrite) would not see it.  
        assertEquals(size, transformedResponse.getHits().getHits().length);
        searchRequest = new SearchRequest().pipeline("p1");
            .putCustom(SearchPipelineMetadata.TYPE, metadata)  
import org.opensearch.cluster.ClusterChangedEvent;
import org.opensearch.search.builder.SearchSourceBuilder;  
        assertSame(searchResponse, notTransformedResponse);
                new PipelineConfiguration(
        assertEquals("p1", reWrapped.pipeline());
            OpenSearchExecutors.newDirectExecutorService(),
    }
                    assertEquals(4.0 * i, searchResponse.getHits().getHits()[i].getScore(), 0.0001f);  
            searchPhaseContext,
            }  
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                // system_scale_request_size_post size = size*3 = 60
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(size));
    public void testTransformResponseWithSystemGeneratedPipeline() throws Exception {
                "p1",
        );  
            }
        // updating the maxScore
            SearchPhaseName.QUERY.getName(),
        PipelinedRequest resolvedDefault = searchPipelineService.resolvePipeline(noPipelineRequest, null, indexNameExpressionResolver);  
            public void onResponse(SearchResponse searchResponse) {
                assertEquals(60, pipelinedRequest.source().size());
        assertEquals(2 * size, pipelinedRequest.source().size());
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        pipelinedRequest.transformSearchPhaseResults(
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
        PipelinedRequest original = searchPipelineService.resolvePipeline(request, null, indexNameExpressionResolver);  
        assertNull(resolvedDefault.pipeline());
import org.opensearch.search.SearchPhaseResult;
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
            searchPipelineService.resolvePipeline(request, null, indexNameExpressionResolver)  
     * id forward (the {@link SearchRequest} copy constructor invoked by {@code super(...)} does not), so the re-wrapped
            @Override
        enabledAllSystemGeneratedFactories(service);
    }  
                new PipelineConfiguration(  
                )
        int size = 10;
            exc -> {}  
                "p1",  
     * verbatim, and when no pipeline is requested {@code pipeline()} stays null while the resolved pipeline is the  
        );
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.action.search.SearchPhaseController;
        clusterState = ClusterState.builder(clusterState).metadata(mdBuilder).build();
            @Override
        SearchRequest transformed = new SearchRequest("my-index").source(sourceBuilder).pipeline("some-other-id");
import org.opensearch.index.query.TermQueryBuilder;
    }  
            searchPhaseResults,  
        SearchRequest request = new SearchRequest("my-index").source(sourceBuilder);
                )
        ActionListener<SearchResponse> listener = pipelinedRequest.transformResponseListener(new ActionListener<SearchResponse>() {
        pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
                    "p1",
                    MediaTypeRegistry.JSON  
import org.opensearch.action.search.SearchProgressListener;  
                // user defined scale_request_size size = size*2 = 20  
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
    }  
            @Override
        searchRequest.source(createDefaultSearchSourceBuilder());
                new PipelineConfiguration(
            SearchPhaseName.QUERY.getName(),
        searchRequest = new SearchRequest().pipeline("p1");
        request = new SearchRequest("my-index").source(sourceBuilder).pipeline("p1");
            searchPhaseContext.getRequest(),
import org.opensearch.search.SearchHits;
            .putCustom(SearchPipelineMetadata.TYPE, metadata)
        int size = 10;  
        // system_max_score_post maxScore = maxScore*2 = 200f
     */
        });  
        // First try without specifying a pipeline, which should be a no-op.
     * The re-wrapping constructor {@code PipelinedRequest(SearchRequest, PipelinedRequest)} reuses the original  
        // First try without specifying a pipeline, which should be a no-op.
        assertSame(searchPhaseResults.getAtomicArray(), notTransformedSearchPhaseResult);
import java.util.Map;  
import org.opensearch.action.search.SearchResponse;
            }
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(10);  
import org.apache.lucene.search.TotalHits;  
        SearchRequest searchRequest = new SearchRequest();  
                // system_scale_score_post score*2
        assertSame(original.getPipeline(), reWrapped.getPipeline());
        AtomicArray<SearchPhaseResult> notTransformedSearchPhaseResult = searchPhaseResults.getAtomicArray();
                fail("Failed to transform the response due to " + e.getMessage());  
            SearchPhaseName.FETCH.getName()
        final QuerySearchResult querySearchResult = new QuerySearchResult();
            Map.of(  
        List<SearchPhaseResult> resultAtomicArray = searchPhaseResults.getAtomicArray().asList();
            SearchPhaseName.QUERY.getName()
/*  
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(10);
        SearchRequest noneRequest = new SearchRequest("my-index").source(sourceBuilder).pipeline(SearchPipelineService.NOOP_PIPELINE_ID);
        ClusterState previousState = clusterState;  
            searchPhaseContext.getRequest(),  
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);  
                    "p1",  
        ClusterState previousState = clusterState;
            searchPhaseResults,
        setUpForResolvePipeline(service);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(new TermQueryBuilder("foo", "bar")).size(size);
    public void testReWrappedRequestRetainsOriginalPipelineId() throws Exception {
        searchRequest = new SearchRequest().pipeline("p1");
import org.opensearch.cluster.ClusterName;
        assertEquals(1, resultAtomicArray.size());
        final QuerySearchResult querySearchResult = new QuerySearchResult();  
        SearchRequest request = new SearchRequest("my-index").source(sourceBuilder).pipeline("p1");
        Metadata.Builder mdBuilder = Metadata.builder()
                    new BytesArray("{\"response_processors\" : [ { \"fixed_score\": { \"score\" : 2 } } ] }"),
        pipelinedRequest = syncTransformRequest(searchPipelineService.resolvePipeline(request, null, indexNameExpressionResolver));  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;  
import org.opensearch.action.search.QueryPhaseResultConsumer;
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        pipelinedRequest.transformSearchPhaseResults(
                    MediaTypeRegistry.JSON
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(10));  
        assertEquals(1, resultAtomicArray.size());  
            Map.of(
        SearchPipelineService searchPipelineService = createWithProcessors();  
import org.opensearch.test.InternalAggregationTestCase;
            .putCustom(SearchPipelineMetadata.TYPE, metadata)
        );
        SearchResponse notTransformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);  
            SearchProgressListener.NOOP,  
        SearchHits searchHits = new SearchHits(hits, new TotalHits(size, TotalHits.Relation.EQUAL_TO), size);
        for (int i = 0; i < size; i++) {
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
 * compatible open source license.
        pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);  
        );  
                "p1",
    public void testResolvedRequestRetainsNamedPipelineId() throws Exception {  
        }
            assertEquals(100f, result.queryResult().topDocs().maxScore, 0);
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),  
            }
     * no-op pipeline.
        SearchRequest searchRequest = new SearchRequest();  
    }
        SearchRequest request = new SearchRequest("my-index").source(sourceBuilder).pipeline("p1");
        assertEquals("p1", pipelinedRequest.pipeline());
 * SPDX-License-Identifier: Apache-2.0
            )  
        );  
import org.apache.lucene.search.ScoreDoc;
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
            searchPhaseContext,
                new PipelineConfiguration(
        QueryPhaseResultConsumer searchPhaseResults = new QueryPhaseResultConsumer(
        pipelinedRequest.transformSearchPhaseResults(  
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
        });
                )
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
        // original's pipeline (the one it actually reuses), not the transformed request's id.  
        enabledAllSystemGeneratedFactories(service);
                "p1",
                // system_scale_request_size_pre size = size*2 = 10
        }
        SearchPipelineService service = createWithSystemGeneratedProcessors();  
        pipelinedRequest.transformRequest(new ActionListener<SearchRequest>() {  
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(  
            SearchPhaseName.FETCH.getName()
            2,
    }
        );
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        searchPhaseResults.consumeResult(querySearchResult, () -> {});  
            public void onResponse(SearchRequest searchRequest) {
    public void testTransformSearchPhaseWithSystemGeneratedPipeline() throws Exception {
        clusterState = ClusterState.builder(clusterState).metadata(mdBuilder).build();
        SearchHit[] hits = new SearchHit[size];  
        // Now set the pipeline as p1  
import org.opensearch.action.search.SearchResponseSections;  
        );
            writableRegistry(),
        for (SearchPhaseResult result : resultAtomicArray) {  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
            controller,  
     * request's resolved pipeline, context, and system-generated holder. It must likewise carry the original's pipeline
            exc -> {}
                    MediaTypeRegistry.JSON
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        querySearchResult.setShardIndex(1);
        searchRequest.source(createDefaultSearchSourceBuilder());
}  
        int size = 10;  
        PipelinedRequest resolvedNone = searchPipelineService.resolvePipeline(noneRequest, null, indexNameExpressionResolver);
            public void onFailure(Exception e) {  
    }  
        SearchPipelineService searchPipelineService = createWithProcessors();
            assertEquals(2.0, transformedResponse.getHits().getHits()[i].getScore(), 0.0001f);
        SearchPipelineService searchPipelineService = createWithProcessors();
import java.util.List;
            searchPhaseResults,
        PipelinedRequest pipelinedRequest = syncTransformRequest(
    }
            searchPhaseContext,  
        for (int i = 0; i < size; i++) {  
        setUpForResolvePipeline(service);  
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));  
                    "p1",
                fail("Failed to transform the request due to " + e.getMessage());
        querySearchResult.setShardIndex(1);
     * The resolved {@link PipelinedRequest} must carry the named pipeline id forward: it wraps the request through the
import org.opensearch.search.SearchHit;  
        // The transformed request deliberately carries a different id; the re-wrapped request must report the
        }
            writableRegistry(),
            .put(indexBuilder("my-index").putAlias(AliasMetadata.builder("barbaz")));  
        SearchResponse searchResponse = createSearchResponse(size);
     */
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(request, null, indexNameExpressionResolver);  
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
        searchRequest.source(createDefaultSearchSourceBuilder());
        );  
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
        // the no-op pipeline.
            Map.of(
            2,  
        clusterState = ClusterState.builder(clusterState)
        SearchRequest noPipelineRequest = new SearchRequest("my-index").source(sourceBuilder);
            .build();  
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
            .put(indexBuilder("my-index").putAlias(AliasMetadata.builder("barbaz")));  
        querySearchResult.topDocs(new TopDocsAndMaxScore(new TopDocs(null, new ScoreDoc[1]), 1f), null);  
import org.opensearch.core.common.bytes.BytesArray;  
            public void onFailure(Exception e) {
        clusterState = ClusterState.builder(clusterState).metadata(mdBuilder).build();
        );
                    MediaTypeRegistry.JSON
     * is the request the pipeline was resolved for, and consumers reading the id later in the request lifecycle (e.g.
        ClusterState previousState = clusterState;  
                new PipelineConfiguration(  
                // verify
        // Explicit _none: the sentinel id is carried forward verbatim, and resolves to the no-op pipeline.  
package org.opensearch.search.pipeline;
        List<SearchPhaseResult> resultAtomicArray = searchPhaseResults.getAtomicArray().asList();  
        assertEquals(size, pipelinedRequest.source().size());
        listener.onResponse(searchResponse);
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        // Check Processor doesn't run for between other phases
            writableRegistry(),
        searchPhaseResults.consumeResult(querySearchResult, () -> {});
import org.opensearch.cluster.metadata.AliasMetadata;
            hits[i].score(i);  
        // This request doesn't specify a pipeline, it doesn't get transformed.  
import org.opensearch.search.query.QuerySearchResult;
        assertEquals(SearchPipelineService.NOOP_PIPELINE_ID, resolvedDefault.getPipeline().getId());
import org.opensearch.action.search.SearchPhaseName;
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(new TermQueryBuilder("foo", "bar")).size(10);
     * {@link SearchRequest} copy constructor, which does not copy the pipeline id, so the id is set explicitly in the  
        AtomicArray<SearchPhaseResult> notTransformedSearchPhaseResults = searchPhaseResults.getAtomicArray();  
        // No pipeline requested: pipeline() stays null (nothing to carry forward), but the request still resolves to  
            @Override  
            controller,
        for (SearchPhaseResult result : resultAtomicArray) {  
            .build();
        // verify
            .put(indexBuilder("my-index").putAlias(AliasMetadata.builder("barbaz")));
        );
            searchPhaseContext,
            )
     *
            Map.of(
    /**
import org.opensearch.cluster.ClusterState;  
        assertSame(searchPhaseResults.getAtomicArray(), notTransformedSearchPhaseResults);
        enabledAllSystemGeneratedFactories(service);
public class PipelinedRequestTests extends SearchPipelineTestCase {
import org.opensearch.action.search.SearchPhaseContext;  
import org.opensearch.action.search.MockSearchPhaseContext;
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
            )
            SearchPhaseName.FETCH.getName()  
 */  
        SearchPipelineService searchPipelineService = createWithProcessors();
     * PipelinedRequest constructor. Otherwise {@code pipeline()} would read null on the resolved request even though it
        Metadata.Builder mdBuilder = Metadata.builder()
    public void testTransformResponse() throws Exception {  
        SearchPhaseController controller = new SearchPhaseController(  
        );
    public void testTransformRequestWithSystemGeneratedPipeline() throws Exception {
        pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);  
        );
                )
import org.opensearch.action.search.SearchRequest;
        QueryPhaseResultConsumer searchPhaseResults = new QueryPhaseResultConsumer(
                }
    public void testTransformRequest() throws Exception {  
        SearchResponse searchResponse = createSearchResponse(size);  
        searchRequest.source(createDefaultSearchSourceBuilder());  
import java.util.Collections;
import org.opensearch.core.action.ActionListener;  
            SearchPhaseName.QUERY.getName(),  
import org.opensearch.core.common.breaker.CircuitBreaker;
        pipelinedRequest.transformSearchPhaseResults(  
            )
                // initial query size = 5
            assertEquals(200f, result.queryResult().topDocs().maxScore, 0);
                // system_scale_score_pre score*2  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
        );
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));
        searchRequest.source(createDefaultSearchSourceBuilder());
     * <p>Also covers the {@code _none} and unset (null) cases: an explicit {@code _none} id is carried forward
 *
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(new TermQueryBuilder("foo", "bar")).size(10);
        // Named pipeline: id is carried forward onto the resolved request.
    /**
            SearchProgressListener.NOOP,
            Map.of(
            )  
        SearchPhaseController controller = new SearchPhaseController(
        SearchPipelineService service = createWithSystemGeneratedProcessors();
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
     * request reports the pipeline it is actually using rather than the transformed request's id.  
        // Specify the pipeline and use it to transform the request
    public void testTransformSearchPhase() throws Exception {
            searchPhaseResults,
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
