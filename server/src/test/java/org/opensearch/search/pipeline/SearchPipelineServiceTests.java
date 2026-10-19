            () -> searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(Map.of("throwing_request", Collections.emptyMap())));
        previousState = clusterState;
            response
            throw new RuntimeException();  
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
            .build();
import org.opensearch.common.settings.ClusterSettings;  
            "Cannot support more than one system generated SEARCH_REQUEST processor to be executed PRE_USER_DEFINED. Now we have [system_scale_request_size_pre,system_scale_request_size_pre].";
            "Should not systematically generate the search processors",
                    break;
        assertEquals(10, pipelinedRequest.source().size());  
                new PipelineConfiguration(
        SearchRequestProcessor throwingRequestProcessor = new FakeRequestProcessor("throwing_request", null, null, true, r -> {
    }
            Map.of(  
    public void testInvalidIndexResolveIndexDefaultPipeline() throws Exception {  
        // ...but the request's original inline source survives intact for later readers (not drained by the read).  
            }
        SearchRequest searchRequest = new SearchRequest().source(SearchSourceBuilder.searchSource().size(5));  
                client
        expectThrows(  
        );  
                new PipelineConfiguration(
            systemGeneratedRequestProcessors,
        SearchResponse searchResponse = new SearchResponse(sections, null, 0, 0, 0, 0, null, null);
        SearchResponseSections sections = new SearchResponseSections(
                    assertPipelineStats(detailStats.requestProcessorStats().get(0).getStats(), 1, 1);
            ResourceNotFoundException.class,  
            throw new RuntimeException();
        return new SearchResponse(sections, null, 0, 0, 0, 0, null, null);
        SearchPipelineMetadata pipelineMetadata = new SearchPipelineMetadata(Map.of("_id", pipeline));
            searchPipelineService.getPipelines().get("_id").pipeline.getSearchResponseProcessors().get(0).getType()
                    assertPipelineStats(perPipelineStats.getRequestStats(), 0, 0);
            Collections.emptyMap()
    public void testDefaultPipelineForMultipleIndices() throws Exception {
        // when ignoreFailure enabled, the search pipelines will all succeed.
        });
            @Override
    public void testResolveSystemGeneratedSearchPipeline_whenHappyCase_thenSuccess() throws Exception {
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(Pipeline.class))) {
            (pf, t, i, f, c, ctx) -> throwingResponseProcessor  
        assertEquals("pipeline [p*] is missing", e.getMessage());
                    "good_response_pipeline",  
            }  
    ) {
        IllegalArgumentException exception = assertThrows(
    public void testVerbosePipelineExecution() throws Exception {
        pipelines = SearchPipelineService.innerGetPipelines(metadata, "*");
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
                            + "\"request_processors\": [{ \"scale_request_size\": { \"scale\" : 2 } }],"  
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p1")
            .build();  
        // Bypass the default pipeline
    }
        assertTrue(pipelinedRequest.getSystemGeneratedPipelineHolder().isNoOp());
            List.of()
            indexNameExpressionResolver
        // One node is missing a processor
            Map.of(
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phaseInjectorProcessorFactories = searchPipelineService  
                    assertEquals("throwing_response:3", detailStats.responseProcessorStats().get(0).getProcessorName());
     * coordinator query rewrite) would see an emptied map.
            switch (perPipelineStats.getPipelineId()) {  
                    MediaTypeRegistry.JSON
                )
        assertEquals(5, pipelinedRequest.source().size());  
        assertEquals(200, pipelinedRequest.source().size());  
        syncExecutePipeline(
        }
                    SearchPipelineService.class.getCanonicalName(),
                "q1",  
            (pf, t, i, f, c, ctx) -> new FakeRequestProcessor("successful_request", "2", null, true, r -> {}),
            .build();
                searchPipelineService.resolvePipeline(request.pipeline("bad_response_pipeline"), null, indexNameExpressionResolver),  
    public void testStatsEnabledIgnoreFailure() throws Exception {
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(  
            .put(indexBuilder("foofoo-closed", defaultPipelineSetting1).putAlias(AliasMetadata.builder("bar")))
        Map<String, Object> requestProcessorObject = new HashMap<>();  
        );  
        Map<String, Object> pipelineSourceMap = new HashMap<>();
                    Level.WARN,
        assertTrue(requestProcessorFactories.containsKey("foo"));
import org.opensearch.cluster.node.DiscoveryNode;  
                "p1",  
        assertFalse(service.isSystemGeneratedFactoryEnabled("dummy_factory"));
import org.opensearch.action.search.SearchResponseSections;
        );  
     * must not affect the original inline source. The null-config guard is not reachable from the XContent-parsed  
                )  
        SearchResponse searchResponse = new SearchResponse(sections, null, 0, 0, 0, 0, null, null);
import static org.mockito.ArgumentMatchers.anyString;
                    MediaTypeRegistry.JSON
                new PipelineConfiguration(
                        "{"
     * Tests a pipeline defined in the search request source.
            .getFirst();  
    public void testNoIndexResolveIndexDefaultPipeline() throws Exception {
            mockAppender.assertAllExpectationsMatched();
        assertTrue(systemGeneratedResponseProcessorPost instanceof FakeSystemGeneratedResponsePostProcessor);
                boolean ignoreFailure,
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
        SearchHit[] hits = new SearchHit[size];  
    public void testStats() throws Exception {
        SearchPipelineService searchPipelineService = createWithProcessors();  
            .put(indexBuilder("foofoo", defaultPipelineSetting2).putAlias(AliasMetadata.builder("bar")));  
                    MediaTypeRegistry.JSON
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        AtomicReference<String> contextHolder = new AtomicReference<>();  
        ProcessorInfo reqProcessor = new ProcessorInfo("scale_request_size");  
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);  
                "p1",
        PipelineConfiguration config = new PipelineConfiguration(  
            .postPipeline()
        });
                    MediaTypeRegistry.JSON  
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
        }  
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
import org.opensearch.action.search.PutSearchPipelineRequest;
                )
    public void testStatefulProcessors() throws Exception {
    }
        // user defined pipeline is resolved
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().searchPipelineSource(pipelineSourceMap);
        pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        assertTrue(e.getMessage(), e.getMessage().contains("The 'verbose pipeline' option requires a search pipeline to be defined."));
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                    break;
import static org.opensearch.search.pipeline.SearchPipelineService.ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING;  
    }
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(id, new BytesArray("{}"), MediaTypeRegistry.JSON);
        SearchRequest searchRequest = new SearchRequest().source(SearchSourceBuilder.searchSource().size(10))
        List<ProcessorExecutionDetail> executionDetails = transformedResponse.getInternalResponse().getProcessorResult();
                (pf, t, d, igf, cfg, ctx) -> new FakeStatefulRequestProcessor("write_context", (c) -> c.setAttribute("a", "b"))
        when(clusterService.getClusterSettings()).thenReturn(
        );  
            null,
                    assertEquals("throwing_request", detailStats.requestProcessorStats().get(0).getProcessorType());  
        SearchResponse searchResponse = new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
            assertTrue(
                List.of(reqProcessor),  
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
        SearchPipelineService searchPipelineService = createWithProcessors(
            public boolean shouldGenerate(ProcessorGenerationContext context) {  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
    }
        });
 * compatible open source license.
                    assertEquals(0, detailStats.requestProcessorStats().size());  
                    // pipeline succeed when ignore failure is true
        clusterState = ClusterState.builder(clusterState).metadata(mdBuilder.putCustom(SearchPipelineMetadata.TYPE, metadata)).build();
        private final Consumer<PipelineProcessingContext> stateConsumer;
        assertTrue(systemGeneratedPhaseProcessorPost instanceof FakeSystemGeneratedSearchPhaseResultsPostProcessor);
            id,
        SearchRequestProcessor systemGeneratedRequestProcessorPost = pipelinedRequest.getSystemGeneratedPipelineHolder()  
        SearchPipelineService service = createWithSystemGeneratedProcessors();
        SearchPipelineService searchPipelineService = createWithProcessors();
            () -> searchPipelineService.validatePipeline(Map.of(n1, completePipelineInfo, n2, completePipelineInfo), badPutRequest)  
        // Delete all pipelines starting with "p"
        SearchPipelineService service = createWithProcessors();
                    assertPipelineStats(perPipelineStats.getResponseStats(), 1, 1);
        syncExecutePipeline(request, createDefaultSearchResponse());
                    MediaTypeRegistry.JSON  
            return type;  
                this.writableRegistry(),
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
            throw new RuntimeException();  
                    new BytesArray("{\"phase_results_processors\" : [ { \"max_score\" : { } } ]}"),
            1,  
        SearchPipelineService service = createWithProcessors();
            IllegalArgumentException.class,
        public Map<String, Processor.Factory<SearchRequestProcessor>> getRequestProcessors(Parameters parameters) {  
                    new BytesArray("{\"request_processors\" : [ { \"throwing_request\": {} } ] }"),
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
                        "{"
        Map<String, Object> sourceAfter = searchRequest.source().searchPipelineSource();
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        ClusterState previousState = clusterState;
    public void testUpdatePipelines() {
            mockAppender.addExpectation(
        }
        searchRequest.pipeline(searchRequest.source().pipeline());  
        );
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorsEnableIgnoreFailure = Map.of(
                )
        expectThrows(
        assertNotNull(contextHolder.get());  
        Settings defaultPipelineSetting = Settings.builder()
     * Resolving an inline (ad hoc) pipeline must NOT drain the request's search pipeline source map. Pipeline
        SearchPipelineService service = createWithProcessors(  
            throw new RuntimeException();
        String id = "_id";
        //  
        assertEquals(0, pipeline.pipeline.getSearchResponseProcessors().size());
        copiedInner.remove("technique");
                    assertEquals(1, detailStats.responseProcessorStats().size());
        );
                new PipelineConfiguration(
            throw new RuntimeException();  
                Processor.PipelineContext pipelineContext  
        );
            "throwing_response",
        );  
        clusterState = SearchPipelineService.innerDelete(deleteRequest, clusterState);
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
        );
        assertEquals(3, pipelines.size());
        assertEquals("p3", pipelines.get(2).getId());
            false,  
        // Get both pipelines explicitly  
            (pf, t, i, f, c, ctx) -> throwingRequestProcessor
                    assertEquals("successful_request", detailStats.requestProcessorStats().get(0).getProcessorType());  
    public void testAdHocRejectingProcessor() {
        // Verify pipeline
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
            SearchPipelineStats.PipelineDetailStats detailStats = stats.getPerPipelineProcessorStats()  
            () -> searchPipelineService.validatePipeline(Map.of(n1, completePipelineInfo), maxLengthIdPutRequest)
            systemGeneratedRequestProcessors,  
                    ),  
    public void testResolveSystemGeneratedSearchPipeline_whenNoParentTask_thenContextHasNullParentAction() throws Exception {  
        SearchPipelineService searchPipelineService = createWithProcessors(
        assertEquals("_none", pipelinedRequest.getPipeline().getId());  
        assertEquals(3, pipelines.size());  
        );
            .put(indexBuilder("foobar", defaultPipelineSetting).putAlias(AliasMetadata.builder("bar")))  
        SearchPipelineService searchPipelineService = createWithProcessors(badFactory, Collections.emptyMap(), Collections.emptyMap());  
            Collections.emptyMap(),
        assertEquals("p1", pipelines.get(0).getId());
        });  
        ProcessorInfo rspProcessor = new ProcessorInfo("fixed_score");
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        assertEquals(id, pipeline.pipeline.getId());
                "good_request_pipeline",
            clusterService,
        clusterState = ClusterState.builder(clusterState)  
        ClusterState previousState = clusterState;
                List.of(DUMMY_PLUGIN, DUMMY_PLUGIN),  
        }
        Map<String, Object> responseProcessorConfig = new HashMap<>();  
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testResolveSystemGeneratedSearchPipeline_whenParentTaskProvided_thenContextHasParentAction() throws Exception {
    private static final SearchPipelinePlugin DUMMY_PLUGIN = new SearchPipelinePlugin() {
                "response_only_pipeline",
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(  
        });  
        SearchHit[] hits = new SearchHit[size];
        SearchRequest request = new SearchRequest();
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);  
            response
            "fixed_score",
                            + "\"response_processors\": [ { \"fixed_score\": { \"score\": 5.0 } } ]"
        );
                    new BytesArray(  
     * Directly covers {@link SearchPipelineService#deepCopyConfig} across every value branch produced by the XContent
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
    private static void assertPipelineStats(OperationStats stats, long count, long failed) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        assertNull(contextHolder.get());
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(Map.of(processorType, Collections.emptyMap())));
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        );  
        Client client = mock(Client.class);
                threadPool,  
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),  
        assertNotNull(executionDetails);  
                )
                    assertEquals(1, detailStats.requestProcessorStats().size());  
            return Map.of("zoe", (factories, tag, description, ignoreFailure, config, ctx) -> null);
        // Invalid configuration in request
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessors =
                "request_only_pipeline",  
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
        final ClusterState finalClusterState = clusterState;
            MediaTypeRegistry.JSON
                "write_context",  
        assertEquals("_none", pipelinedRequest.getPipeline().getId());
                    "The exception from request processor [throwing_request] in the search pipeline [_ad_hoc_pipeline] was ignored"
        PipelinedRequest pipelinedRequest = syncTransformRequest(
            MediaTypeRegistry.JSON  
        ClusterChangedEvent cce = new ClusterChangedEvent("", clusterState, previousState);
                case "bad_request_pipeline":  
    }
                    assertEquals(1, detailStats.requestProcessorStats().size());  
            (pf, t, i, f, c, ctx) -> throwingResponseProcessor  
        // Success  
                    "request_only_pipeline",
            Collections.emptyMap()
        service.resolvePipeline(searchRequest, parentTask, indexNameExpressionResolver);
                    "failed to update search pipelines"
            null,  
        // Add the factory again to generate two processors in the same execution stage
    public void testResolveSystemGeneratedSearchPipeline_whenNotMeetCondition_thenNoGeneration() throws Exception {  
        public SearchResponse processResponse(SearchRequest request, SearchResponse response, PipelineProcessingContext requestContext)
            Map.of(
                List.of(searchPhaseProcessor)
                "bad_request_pipeline",
                response
        assertEquals(1, processorsAfter.size());  
        SearchPipelineService searchPipelineService = createWithProcessors();
        int size = 10;
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(requestProcessorObject));
                    Pipeline.class.getCanonicalName(),
        );  
        SearchPipelineService searchPipelineService = createWithProcessors(
            () -> SearchPipelineService.innerDelete(deleteRequest, finalClusterState)
                    MediaTypeRegistry.JSON  
        assertEquals("p2", pipelines.get(1).getId());
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
                    new BytesArray("{\"response_processors\" : [ { \"throwing_response\": {} } ] }"),
                    new BytesArray(
        when(parentTask.getAction()).thenReturn("indices:data/read/msearch");
                    + "\"request_processors\": [{ \"scale_request_size\": { \"scale\" : \"banana\" } }],"
            (pf, t, i, f, c, ctx) -> throwingResponseProcessor
            () -> searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
            .build();
                    assertEquals(0, detailStats.responseProcessorStats().size());
                "{"  
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, searchPipelineMetadata).build())  
        SearchResponse response = createDefaultSearchResponse();
            .getFirst();  
        SearchResponseSections sections = new SearchResponseSections(
    private SearchPipelineService getSearchPipelineService(
                "p1",
    @Override
        );  
                Map<String, Object> config,
import org.opensearch.cluster.ClusterState;
            Map.of(
        SearchPipelineService searchPipelineService = createWithProcessors();  
import org.opensearch.action.search.SearchResponse;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            "p1",  
            () -> SearchPipelineService.innerDelete(deleteRequest, finalClusterState)
        AtomicReference<String> capturedParentAction = new AtomicReference<>("sentinel");
                new PipelineConfiguration(  
            this.writableRegistry(),
    }
import org.opensearch.transport.client.Client;  
            );  
            responseProcessorsEnableIgnoreFailure
    public void testVerbosePipelineWithResponseProcessorOnly() throws Exception {  
    }  
        Map<String, Processor.Factory<SearchRequestProcessor>> throwingRequestProcessorFactory = Map.of(
        searchRequest.source(SearchSourceBuilder.searchSource().verbosePipeline(true));
            return Map.of("bar", (factories, tag, description, ignoreFailure, config, ctx) -> null);
        SearchRequestProcessor systemGeneratedRequestProcessorPre = pipelinedRequest.getSystemGeneratedPipelineHolder()
        // set a large size to not meet the condition to generate the system generated request processor
                new MockLogAppender.SeenEventExpectation(
            IllegalArgumentException.class,
        assertNotNull(executionDetails);
        Metadata.Builder mdBuilder = Metadata.builder()
}
        });
import java.util.function.Consumer;
            ),
        assertEquals(
        service.getClusterService()
            new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), 0.0f),  
            ),
            .put(indexBuilder("foofoo-closed", defaultPipelineSetting).putAlias(AliasMetadata.builder("bar")))
            .postPipeline()
        setUpForResolvePipeline(service);
        assertEquals(0, searchPipelineService.getPipelines().size());
        assertTrue(systemGeneratedRequestProcessorPost instanceof FakeSystemGeneratedRequestPostProcessor);  
        DiscoveryNode n1 = new DiscoveryNode("n1", buildNewFakeTransportAddress(), Version.CURRENT);  
import org.opensearch.index.IndexSettings;
        // Delete all removes remaining pipeline  
        // set a large size to not meet the condition to generate the system generated request processor
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);  
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
        assertEquals("scale_request_size", executionDetails.get(0).getProcessorName());
        // Exception thrown when processing the request
                case "bad_request_pipeline":
            mockAppender.addExpectation(
    }  
        SearchPipelineInfo incompletePipelineInfo = new SearchPipelineInfo(Map.of(Pipeline.REQUEST_PROCESSORS_KEY, List.of(reqProcessor)));
        enabledAllSystemGeneratedFactories(service);  
        enabledAllSystemGeneratedFactories(service);  
            MediaTypeRegistry.JSON  
        SearchRequest searchRequest = new SearchRequest("bar").source(SearchSourceBuilder.searchSource().size(5));  
                    assertEquals(0, detailStats.requestProcessorStats().size());  
            buildBaseProcessors().response,  
        ClusterState previousState = clusterState;
            )  
    }
                    assertEquals(0, detailStats.responseProcessorStats().size());  
        assertEquals(1, searchPipelineService.getPipelines().get("_id").pipeline.getSearchResponseProcessors().size());
            return request;
        assertEquals("p2", pipelines.get(1).getId());
        );
        SearchResponse response = createDefaultSearchResponse();
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));
    public void testVerbosePipelineWithoutDefinedPipelineThrowsException() {  
                    new BytesArray("{\"response_processors\" : [ { \"successful_response\": {} } ] }"),
        for (int i = 0; i < size; i++) {
                new PipelineConfiguration(  
        ClusterState previousState = clusterState;
    }
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
                    new BytesArray("{" + "\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ]" + "}"),  
        setUpForResolvePipeline(service);
            () -> searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)  
public class SearchPipelineServiceTests extends SearchPipelineTestCase {
        @Override
        );
                    XContentType.JSON  
        );  
            @Override  
        );
            MediaTypeRegistry.JSON  
                    // pipeline succeed when ignore failure is true
        );
        inner.put("weights", new ArrayList<>(List.of(0.3, 0.7)));   // List branch
        requestProcessorObject.put("scale_request_size", requestProcessorConfig);
        );
    private static class FakeStatefulResponseProcessor extends AbstractProcessor implements StatefulSearchResponseProcessor {  
                    "p1",
        assertEquals(1, searchPipelineService.getPipelines().size());  
        );  
        assertNull(pipeline.pipeline.getDescription());  
    }
            Map.of("score", 1.0f, "tag", "my_tag", "comment", "I just like to add extra parameters so that I feel like I'm being heard.")
            response
                case "bad_response_pipeline":  
            "throwing_response",
            ),
                    + "\"response_processors\": [{ \"fixed_score\": { \"score\" : 2 } }]"
            ) {
        SearchPipelineService searchPipelineService = createWithProcessors(
        config.put("normalization", inner);                         // Map branch (recursion)
        syncExecutePipeline(
        assertEquals("fixed_score", executionDetails.get(1).getProcessorName());  
        clusterState = SearchPipelineService.innerPut(putRequest, clusterState);
                    Level.WARN,  
            requestProcessorsEnableIgnoreFailure,
        // Delete missing pipeline
        PipelinedRequest pipelinedRequest = syncTransformRequest(service.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
            Collections.emptyMap()
     * first; otherwise consumers that read the inline pipeline definition later in the request lifecycle (e.g. during
        searchPipelineService.applyClusterState(new ClusterChangedEvent("clusterStateUpdated", updatedState, initialState));
            searchPipelineService.resolvePipeline(request.pipeline("good_request_pipeline"), null, indexNameExpressionResolver),
import org.opensearch.cluster.ClusterName;
import org.apache.logging.log4j.Level;
            new HashMap<>();
            response
        );
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
    private SearchResponse createDefaultSearchResponse() {
        ClusterState initialState = ClusterState.builder(new ClusterName("_name")).build();  
            )
        clusterState = SearchPipelineService.innerPut(putRequest, clusterState);  
            "_id",
        });
        clusterState = SearchPipelineService.innerDelete(deleteRequest, clusterState);
            .pipeline("response_only_pipeline");
        Map<String, Object> pipelineSourceMap = new HashMap<>();  
        PipelineConfiguration pipeline = new PipelineConfiguration(  
import java.util.Comparator;
        Map<String, Object> inner = new LinkedHashMap<>();
        SearchPipelineService searchPipelineService = new SearchPipelineService(
            .getSearchRequestProcessors()
        PipelinedRequest pipelinedRequest = syncTransformRequest(service.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
        assertNotNull("nested processor config must not be drained", scaleProcessorAfter);
    public void testInlineDefinedPipeline() throws Exception {
                    + "\"response_processors\" : [ { \"fixed_score\" : { \"score\" : 1.0 } } ],"
                    MediaTypeRegistry.JSON
        assertEquals(id, pipeline.pipeline.getId());
import org.apache.logging.log4j.LogManager;
                    ),  
            null,  
            )  
                    assertPipelineStats(perPipelineStats.getResponseStats(), 0, 0);
        enabledAllSystemGeneratedFactories(service);
        assertEquals(10, pipelinedRequest.source().size());  
            Collections.emptyMap()
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));  
        }
        requestProcessorConfig.put("scale", 2);
        clusterState = ClusterState.builder(clusterState)
        );  
    public void testValidatePipeline() throws Exception {  
                return null;
            switch (perPipelineStats.getPipelineId()) {
                    .contains("processor [fixed_score:my_tag] doesn't support one or more provided configuration parameters: [comment]")
            .getSearchResponseProcessors()
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);
        pipelines = SearchPipelineService.innerGetPipelines(metadata, "p*");
        );
            pipelinedRequest.getSystemGeneratedPipelineHolder().prePipeline().getSearchRequestProcessors().isEmpty()  
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(
        SearchPipelineService searchPipelineService = createWithProcessors();
        PipelinedRequest pipelinedRequest = syncTransformRequest(
     */  
    public void testVerbosePipelineWithRequestProcessorOnly() throws Exception {
        );  
        // ...but distinct container instances at every level (a deep copy, not shared references).
import java.util.Collections;
        public Map<String, Processor.Factory<SearchPhaseResultsProcessor>> getSearchPhaseResultsProcessors(Parameters parameters) {  
    /**
            throwingRequestProcessorFactory,
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
    public void testDifferentDefaultPipelineForMultipleIndices() throws Exception {  
            )  
        Pipeline pipeline = pipelinedRequest.getPipeline();
                new PipelineConfiguration(  
        );
        // Verify that pipeline transforms request
        assertEquals(1, responseProcessorFactories.size());
import org.opensearch.common.settings.Settings;
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))  
            Map.of(
        assertEquals(  
        assertEquals(1, searchPipelineService.getPipelines().size());
    }  
import org.opensearch.threadpool.ThreadPool;
            return Map.of("foo", (factories, tag, description, ignoreFailure, config, ctx) -> null);
        SearchPipelineMetadata searchPipelineMetadata = new SearchPipelineMetadata(Map.of("_id", config));
        // Match prefix  
                    "The exception from response processor [throwing_response] in the search pipeline [_ad_hoc_pipeline] was ignored"
                "p1",
        clusterState = ClusterState.builder(clusterState).metadata(mdBuilder.putCustom(SearchPipelineMetadata.TYPE, metadata)).build();
        searchPipelineService.applyClusterState(new ClusterChangedEvent("clusterStateUpdated", updatedState, initialState));
        assertTrue(e.getMessage(), e.getMessage().contains(" not defined"));
        SearchPipelineInfo info = searchPipelineService.info();
        assertEquals(config, copy);  
        assertEquals("p1", pipelines.get(0).getId());
            mockAppender.addExpectation(  
            "throwing_response",
            .metadata(Metadata.builder().put(indexMetadata, false).putCustom(SearchPipelineMetadata.TYPE, metadata))
 */  
        ResourceNotFoundException e = expectThrows(
        SearchPipelineService service = createWithProcessors();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            this.type = type;
        });
                    assertEquals(1, detailStats.responseProcessorStats().size());
            .getClusterSettings()
        assertTrue(
        for (int i = 0; i < size; i++) {
                    "p1",  
    public void testExceptionOnRequestProcessing() {
        ClusterState initialState = ClusterState.builder(new ClusterName("_name")).build();
            )
            }  
        service.applyClusterState(cce);
        ClusterState initialState = ClusterState.builder(new ClusterName("_name")).build();  
            "throwing_request",  
    }
            SearchPipelineProcessingException.class,
        requestProcessors.put("scale_request_size", new ScaleRequestSizeFactory());  
import java.util.ArrayList;  
        SearchRequest searchRequest = new SearchRequest("xyz").source(SearchSourceBuilder.searchSource().size(5));
                    assertPipelineStats(perPipelineStats.getResponseStats(), 0, 0);  
        searchRequest.source().verbosePipeline(true);  
            .metadata(Metadata.builder().put(indexMetadata, false).putCustom(SearchPipelineMetadata.TYPE, metadata))  
                new PipelineConfiguration(
        assertEquals(
        SearchPipelineService service = createWithSystemGeneratedProcessors();
                e.getMessage()  
            null,
        pipelineSourceMap.put(Pipeline.RESPONSE_PROCESSORS_KEY, List.of(Map.of("throwing_response", new HashMap<>())));  
        SearchRequest searchRequest = new SearchRequest().source(SearchSourceBuilder.searchSource().size(10)).pipeline("verbose_pipeline");
            1,  
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));  
                    new BytesArray("{\"response_processors\" : [ { \"fixed_score\": { \"score\" : 2 } } ] }"),
        systemGeneratedRequestProcessors.put("action_aware_processor", new SystemGeneratedProcessor.SystemGeneratedFactory<>() {
                "read_context",
        );
            public SearchRequestProcessor create(  
    public void testDeepCopyConfigIsDeepAndIndependent() {
                    Pipeline.class.getCanonicalName(),  
    public void testCatchExceptionOnResponseProcessing() throws Exception {  
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessors =  
        );
        );
        assertEquals(1, searchPipelineService.getPipelines().size());
        final SearchRequest searchRequest = new SearchRequest("_index").pipeline("bar");  
        assertEquals("_none", pipelinedRequest.getPipeline().getId());
                    "p2",
                (pf, t, d, igf, cfg, ctx) -> new FakeStatefulResponseProcessor(
    public void testExtraParameterInProcessorConfig() {  
        previousState = clusterState;
        );
        final ClusterState finalClusterState = clusterState;  
        assertEquals("scale_request_size", executionDetails.get(0).getProcessorName());  
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
                    assertPipelineStats(perPipelineStats.getRequestStats(), 1, 0);
        inner.put("technique", "min_max");                          // scalar (String) branch  
        assertEquals("fixed_score", executionDetails.get(0).getProcessorName());
    public void testResolveSystemGeneratedSearchPipeline_whenMoreThanOneProcessorPerStage_thenException() throws Exception {
        );
            .getSearchRequestProcessors()
                    "p1",
            )
                new PipelineConfiguration("p2", definition, MediaTypeRegistry.JSON),
            id,
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(requestProcessorObject));
    public void testCatchExceptionOnRequestProcessing() throws Exception {  
        PipelinedRequest pipelinedRequest = syncTransformRequest(service.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
    public void setup() throws Exception {
        for (SearchPipelineStats.PerPipelineStats perPipelineStats : stats.getPipelineStats()) {
            .build();
                    assertPipelineStats(perPipelineStats.getRequestStats(), 1, 0);
        expectThrows(  
    }
                case "good_request_pipeline":
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(20));  
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
            .getFirst();
                    assertEquals(1, detailStats.requestProcessorStats().size());
        // Mutating the copy must leave the original intact — the whole reason resolvePipeline copies the config.
            new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
                List.of(rspProcessor),
            Map.of(
                throw new IllegalArgumentException(processorType + " cannot be created as part of a pipeline defined in a search request");  
                    assertEquals(0, detailStats.requestProcessorStats().size());  
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
import org.opensearch.common.xcontent.XContentType;  
        assertEquals(1, pipelines.size());  
            super(null, null, false);
    public void testPutPipeline() {  
import org.opensearch.search.SearchHits;
        // Caught Exception thrown when processing the request and produced warn level logging message  
        SearchPipelineService service = createWithSystemGeneratedProcessors();
            List.of()
            .getSearchPhaseResultsProcessorFactories();
    private static class FakeStatefulRequestProcessor extends AbstractProcessor implements StatefulSearchRequestProcessor {
                    assertEquals("throwing_request:1", detailStats.requestProcessorStats().get(0).getProcessorName());
        );
        ClusterService clusterService = mock(ClusterService.class);  
            "throwing_response",
                    + "}"  
                "p2",
            buildBaseProcessors().phase,
        Map<String, Processor.Factory<SearchResponseProcessor>> throwingResponseProcessorFactory = Map.of(
        SearchPipelineService.PipelineHolder pipeline = searchPipelineService.getPipelines().get(id);  
                    assertPipelineStats(perPipelineStats.getRequestStats(), 0, 0);
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessors = new HashMap<>();
        searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5)).pipeline("_none");  
            assertEquals(2.0, transformedResponse.getHits().getHits()[i].getScore(), 0.0001);  
        );  
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
            requestProcessorFactories,  
        Map<String, Object> requestProcessorObject = new HashMap<>();
            requestProcessors,  
        );
        SearchPipelineService searchPipelineService = createWithProcessors();
            null,  
        assertTrue(systemGeneratedResponseProcessorPre instanceof FakeSystemGeneratedResponsePreProcessor);
            null,
                "p1",  
                    assertPipelineStats(perPipelineStats.getRequestStats(), 0, 0);
        ClusterService clusterService = mock(ClusterService.class);  
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
    }
        SearchPipelineService searchPipelineService = createWithProcessors();
            this.xContentRegistry(),
            stateConsumer.accept(requestContext);
                    + "\"response_processors\": [{ \"fixed_score\": { \"score\" : 2 } }],"
                    ),
            () -> new SearchPipelineService(
    }
        // verify the system generated request processor is not generated  
        );  
            Locale.ROOT,
                "p1",
     * {@code resolvePipeline} path (the source map is non-null there), so it is exercised here rather than through a
            .getFirst();
                )
        SearchPipelineService service = createWithSystemGeneratedProcessors();
        SearchResponse response = createDefaultSearchResponse();
        );
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p1")
                    assertEquals("throwing_request", detailStats.requestProcessorStats().get(0).getProcessorType());
        assertEquals(1, searchPipelineService.getPipelines().get("_id").pipeline.getSearchRequestProcessors().size());
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessorFactories = searchPipelineService
        PutSearchPipelineRequest maxLengthIdPutRequest = new PutSearchPipelineRequest(  
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));  
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p2")
                    break;
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        PipelinedRequest pipelinedRequest = syncTransformRequest(
    }
                )
        assertEquals("_id", searchPipelineService.getPipelines().get("_id").pipeline.getId());
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        ClusterChangedEvent cce = new ClusterChangedEvent("", clusterState, previousState);  
        Map<String, Object> requestProcessorConfig = new HashMap<>();
            "successful_request",  
        ClusterState previousClusterState = clusterState;  
            "successful_response",  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
                    assertPipelineStats(perPipelineStats.getResponseStats(), 0, 0);
            .build();  
        systemGeneratedRequestProcessors.put("system_scale_request_size", new SystemGeneratedScaleRequestSizePreFactory());
        SearchResponse response = createDefaultSearchResponse();
                    assertEquals("throwing_request:1", detailStats.requestProcessorStats().get(0).getProcessorName());
        SearchResponseProcessor throwingResponseProcessor = new FakeResponseProcessor("throwing_response", "3", null, true, r -> {
    }
import java.util.Locale;  
            searchPipelineService.getPipelines().get("_id").pipeline.getSearchPhaseResultsProcessors().get(0).getType()  
                new PipelineConfiguration(  
        enabledAllSystemGeneratedFactories(service);
                ),
        SearchPipelineService service = createWithSystemGeneratedProcessors();  
        IllegalArgumentException e = expectThrows(
        assertTrue(systemGeneratedPhaseProcessorPre instanceof FakeSystemGeneratedSearchPhaseResultsPreProcessor);  
        SearchPhaseResultsProcessor systemGeneratedPhaseProcessorPre = pipelinedRequest.getSystemGeneratedPipelineHolder()  
        AtomicReference<String> capturedParentAction = new AtomicReference<>();
        pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
            SearchPipelineStats.PipelineDetailStats detailStats = stats.getPerPipelineProcessorStats()
            ClassCastException.class,
        );
        assertEquals(1, executionDetails.size());
    }
        assertEquals("p1", pipelinedRequest.getPipeline().getId());
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                .get(perPipelineStats.getPipelineId());
        String longId = "a".repeat(512) + "a";
        PipelinedRequest request = searchPipelineService.resolvePipeline(
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(  
        assertEquals("p1", pipeline.getId());
        );  
        assertTrue(
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        ClusterState updatedState = ClusterState.builder(initialState)
        searchRequest.source().verbosePipeline(true);
            )
            )  
        });
        }
        );  
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
    };  
    }
                            + "\"response_processors\": [{ \"fixed_score\": { \"score\" : 2 } }]"
    public void testInlinePipeline() throws Exception {
        service.applyClusterState(cce);
                    MediaTypeRegistry.JSON
        assertEquals(1, searchPipelineService.getPipelines().get("_id").pipeline.getSearchPhaseResultsProcessors().size());  
        assertPipelineStats(stats.getTotalRequestStats(), 2, 0);  
import org.opensearch.OpenSearchParseException;
        );
            Collections.emptyMap(),
            throw new RuntimeException();
        service.applyClusterState(cce);  
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 1 } } ] }"),  
                capturedParentAction.set(context.parentAction());
 * SPDX-License-Identifier: Apache-2.0
            (pf, t, i, f, c, ctx) -> new FakeResponseProcessor("successful_response", "4", null, false, r -> {}),
            () -> syncExecutePipeline(  
            searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
            List.of(DUMMY_PLUGIN),  
    }  
        // Caught Exception here
        );  
        clusterState = SearchPipelineService.innerPut(putRequest, clusterState);  
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(Map.of("throwing_request", Collections.emptyMap())));
        assertEquals("empty pipeline", pipeline.pipeline.getDescription());  
                new PipelineConfiguration(
     * resolve.
        }
        assertNotNull(searchPipelineService.getPipelines().get("q1"));  
        assertNotNull(pipeline);
            "throwing_request",
            longId
        assertNull(searchPipelineService.getPipelines().get("_id").pipeline.getDescription());  
import java.util.HashMap;  
                capturedParentAction.set(context.parentAction());
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(Pipeline.class))) {
        );  
                            + "}"
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorsEnableIgnoreFailure,
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(Map.of("bad_factory", Collections.emptyMap())));  
            null,
        PipelinedRequest pipelinedRequest = syncTransformRequest(service.resolvePipeline(searchRequest, null, indexNameExpressionResolver));  
        // Delete pipeline:
        );
            @Override
        expectThrows(
        previousClusterState = clusterState;  
        assertTrue(sourceAfter.containsKey(Pipeline.REQUEST_PROCESSORS_KEY));  
        // Exception thrown when processing response
        PipelinedRequest pipelinedRequest = syncTransformRequest(
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
        );  
                case "bad_response_pipeline":  
import org.junit.Before;
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
    public void testSearchPipelinePluginDuplicate() {  
                new PipelineConfiguration(  
        // Caught Exception here
        // Delete all does not throw exception if no pipelines
        assertNull(capturedParentAction.get());
        assertTrue(service.isSystemGeneratedFactoryEnabled("dummy_factory"));
        @Override  
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
    }
import java.util.List;
    }
            .build();
 *
        Map<String, Object> pipelineSourceMap = new HashMap<>();
        SearchResponseProcessor systemGeneratedResponseProcessorPost = pipelinedRequest.getSystemGeneratedPipelineHolder()
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));  
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessorsEnableIgnoreFailure  
                Pipeline.RESPONSE_PROCESSORS_KEY,
import org.opensearch.search.SearchHit;  
        assertTrue(responseProcessorFactories.containsKey("bar"));
        setUpForResolvePipeline(service);  
        assertEquals(5, pipelinedRequest.source().size());  
        assertEquals("p3", pipelines.get(2).getId());
                    assertPipelineStats(detailStats.responseProcessorStats().get(0).getStats(), 1, 0);
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
        assertTrue(service.isSystemGeneratedFactoryEnabled("dummy_factory"));
                    assertPipelineStats(detailStats.requestProcessorStats().get(0).getStats(), 1, 0);
                )
        assertTrue(info.containsProcessor(Pipeline.RESPONSE_PROCESSORS_KEY, "fixed_score"));
        assertEquals(0, SearchPipelineService.innerGetPipelines(null, "p1").size());
        service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);  
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
                new PipelineConfiguration(
        }  
        ((List<Object>) copiedInner.get("weights")).clear();  
            ),  
        setUpForResolvePipeline(service);
        super.setUp();  
            false,
            IllegalArgumentException.class,  
            "throwing_request",
            null,
        expectThrows(IllegalStateException.class, () -> searchPipelineService.validatePipeline(Collections.emptyMap(), putRequest));  
                case "good_response_pipeline":  
            this.stateConsumer = stateConsumer;
                    assertPipelineStats(perPipelineStats.getRequestStats(), 0, 0);
    public void testResolveIndexDefaultPipeline() throws Exception {
        );  
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
        );  
    public void testIsSystemGeneratedFactoryEnabled_whenEnabled_thenTrue() {
            Collections.emptyMap()
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);  
                    assertEquals("successful_response", detailStats.responseProcessorStats().get(0).getProcessorType());  
                case "good_response_pipeline":  
                    assertPipelineStats(detailStats.requestProcessorStats().get(0).getStats(), 1, 0);
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)  
        );  
        // The ad hoc pipeline was built (proving the config was read)...  
                null,
            syncTransformRequest(searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);  
        assertEquals("p3", pipelines.get(2).getId());  
            Collections.emptyMap()  
            () -> searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
            syncTransformResponse(pipelinedRequest, response);
        String expectedError =
        assertNotNull(searchPipelineService.getPipelines().get("q1"));
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorFactories = Map.of(processorType, (pf, t, d, i, c, ctx) -> {
    }  
            "_id",
        );  
    }
        pipeline = searchPipelineService.getPipelines().get(id);  
        assertNotSame(config, copy);
        BytesArray definition = new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }");
        assertEquals(0, pipeline.pipeline.getSearchResponseProcessors().size());
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().searchPipelineSource(pipelineSourceMap);
        assertEquals(1, pipeline.getSearchRequestProcessors().size());  
        SearchPipelineService service = createWithSystemGeneratedProcessors();  
            OpenSearchParseException.class,
        SearchRequest request = new SearchRequest();
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessors =
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(  
        assertTrue("original scalar retained", inner.containsKey("technique"));
        }
        assertNull(pipeline);
            Collections.emptyMap(),
                )  
                    "response_only_pipeline",
        assertEquals(SearchPipelineService.AD_HOC_PIPELINE_ID, pipelinedRequest.getPipeline().getId());
        assertNotNull(sourceAfter);
        Settings defaultPipelineSetting = Settings.builder()
            .pipeline("request_only_pipeline");
        systemGeneratedRequestProcessors.put("system_scale_request_size_1", new SystemGeneratedScaleRequestSizePreFactory());  
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            new BytesArray(
        assertPipelineStats(stats.getTotalResponseStats(), 2, 1);
                Pipeline.REQUEST_PROCESSORS_KEY,
        assertPipelineStats(stats.getTotalRequestStats(), 2, 1);  
        }
 * this file be licensed under the Apache-2.0 license or a
                    assertPipelineStats(perPipelineStats.getResponseStats(), 1, 0);
        SearchPipelineService.PipelineHolder pipeline = searchPipelineService.getPipelines().get(id);  
        String id = "_id";
                    assertEquals("throwing_response:3", detailStats.responseProcessorStats().get(0).getProcessorName());  
            new HashMap<>();  
        ExecutorService executorService = OpenSearchExecutors.newDirectExecutorService();
                new PipelineConfiguration(  
        searchPipelineService.applyClusterState(new ClusterChangedEvent("clusterStateUpdated", updatedState, initialState));
    public void testInfo() {  
        SearchPipelineService searchPipelineService = getSearchPipelineService(  
        );
        );
        pipelineSourceMap.put(Pipeline.RESPONSE_PROCESSORS_KEY, List.of(Map.of("fixed_score", processorConfig)));
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))  
        syncExecutePipeline(
/*  
            buildBaseProcessors().response,
        SearchPipelineService searchPipelineService = createWithProcessors();
        public String getType() {
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));  
            null,
        expectThrows(  
            .build();
            this.writableRegistry(),
        SearchHits searchHits = new SearchHits(hits, new TotalHits(size * 2, TotalHits.Relation.EQUAL_TO), size);
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(
                new PipelineConfiguration("q1", definition, MediaTypeRegistry.JSON)
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
        private final String type;  
            Collections.emptyMap(),
            stateConsumer.accept(requestContext);  
                Processor.PipelineContext pipelineContext
        for (int i = 0; i < size; i++) {
        assertTrue(info.containsProcessor(Pipeline.PHASE_PROCESSORS_KEY, "max_score"));
            Collections.emptyMap(),  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
            .getSearchPhaseResultsProcessors()  
        clusterState = ClusterState.builder(clusterState)  
     * parser (nested map, list, scalar, null value) and asserts the copy is deep and independent: mutating the copy
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
                    "p1",
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));
        });
        ClusterState updatedState = ClusterState.builder(initialState)  
    }
                "p2",
            SearchPipelineProcessingException.class,  
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)  
            SearchPipelineProcessingException.class,
        SearchPipelineService service = createWithProcessors(
            throwingResponseProcessorFactory,
        SearchPipelineStats stats = searchPipelineService.stats();
        @Override
                Pipeline.PHASE_PROCESSORS_KEY,  
            Collections.emptyMap()
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().searchPipelineSource(pipelineSourceMap);  
        assertEquals("_none", pipelinedRequest.getPipeline().getId());
            this.stateConsumer = stateConsumer;  
        assertEquals("p1", pipelines.get(0).getId());  
        Settings defaultPipelineSetting1 = Settings.builder()  
            "scale_request_size",  
            buildBaseProcessors().phase,  
            clusterService,
            Collections.emptyMap(),  
        SearchRequest searchRequest = new SearchRequest();  
                    assertPipelineStats(perPipelineStats.getResponseStats(), 1, 0);  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
            "successful_request",  
import org.opensearch.ResourceNotFoundException;
import static org.mockito.Mockito.mock;
        public String getType() {
        assertEquals("original list retained", 2, ((List<Object>) inner.get("weights")).size());
        ClusterChangedEvent cce = new ClusterChangedEvent("", clusterState, previousState);  
                    assertEquals(1, detailStats.responseProcessorStats().size());
        assertEquals("pipeline [_id] is missing", e.getMessage());  
        );
            .put(indexBuilder("foofoo", defaultPipelineSetting).putAlias(AliasMetadata.builder("bar")));
    protected NamedWriteableRegistry writableRegistry() {  
        SearchResponseProcessor throwingResponseProcessor = new FakeResponseProcessor("throwing_response", "3", null, false, r -> {
    public void testPutInvalidPipeline() throws IllegalAccessException {  
        Exception e = expectThrows(  
            )  
            "max_score",
        // The following line successfully creates the pipeline:
            super(null, null, false);
            List.of()  
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        setUpForResolvePipeline(service);  
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessors = Map.of(
        assertNotNull(executionDetails);  
            .build();  
        assertEquals(1, pipelinedRequest.getPipeline().getSearchRequestProcessors().size());
        clusterState = SearchPipelineService.innerPut(putRequest, clusterState);
                this.xContentRegistry(),
            "Should not systematically generate the search request processor",
            searchPipelineService.resolvePipeline(request.pipeline("good_response_pipeline"), null, indexNameExpressionResolver),  
            client
            )
                    "test1",
        );  
    }
import org.apache.lucene.search.TotalHits;  
        String processorType = "ad_hoc_rejecting";  
            .put(indexBuilder("foobar", defaultPipelineSetting1).putAlias(AliasMetadata.builder("bar")))
            return new FakeRequestProcessor(processorType, t, d, i, r -> {});
            ),
            fail("Wrong exception type: " + e.getClass());
        requestProcessorObject.put("scale_request_size", requestProcessorConfig);  
        enabledAllSystemGeneratedFactories(service);
                    Level.WARN,  
                    assertEquals(1, detailStats.responseProcessorStats().size());
        @Override
            .build();
        expectThrows(SearchPipelineProcessingException.class, () -> syncTransformResponse(pipelinedRequest, response));  
        ClusterState previousState = clusterState;  
        });  
    }
        Settings defaultPipelineSetting2 = Settings.builder()
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        SearchPipelineService searchPipelineService = createWithProcessors(  
        searchRequest = new SearchRequest("bar").source(SearchSourceBuilder.searchSource().size(5)).pipeline("_none");  
        SearchResponseProcessor throwingResponseProcessor = new FakeResponseProcessor("throwing_response", null, null, false, r -> {  
        when(threadPool.executor(anyString())).thenReturn(executorService);
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        DeleteSearchPipelineRequest deleteAllRequest = new DeleteSearchPipelineRequest("*");
        }
        // Max length of pipeline length
        previousState = clusterState;
    private ThreadPool threadPool;
        assertEquals(0, searchPipelineService.getPipelines().size());
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
                .get(perPipelineStats.getPipelineId());
            IllegalArgumentException.class,  
                    MediaTypeRegistry.JSON  
        // Overwrite pipeline
        SearchPipelineService.innerDelete(deleteAllRequest, clusterState);
    public void testExceptionOnPipelineCreation() {
        } catch (Exception e) {  
        assertEquals(errorMessage, e.getMessage());  
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));  
            }  
        IndexMetadata indexMetadata = new IndexMetadata.Builder("my_index").settings(defaultPipelineSetting).build();
        PipelinedRequest pipelinedRequest = syncTransformRequest(service.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
        );
                )
        ResourceNotFoundException e = expectThrows(  
import org.opensearch.search.SearchModule;
        syncExecutePipeline(  
        }
            Collections.emptyMap(),  
        searchPipelineService.validatePipeline(Map.of(n1, completePipelineInfo, n2, completePipelineInfo), putRequest);
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p1")  
        );
                "p2",  
            .prePipeline()
        @SuppressWarnings("unchecked")
        assertEquals(1, requestProcessorFactories.size());  
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));  
            .build();
        SearchPipelineService service = createWithProcessors();
        // system generated pipelines are resolved
            List.of(),
        SearchRequestProcessor throwingRequestProcessor = new FakeRequestProcessor("throwing_request", "1", null, true, r -> {
        setUpForResolvePipeline(service);  
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().size(100).searchPipelineSource(pipelineSourceMap);
        SearchPipelineService searchPipelineService = createWithProcessors();
                    + "\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ], "
                    assertEquals(0, detailStats.responseProcessorStats().size());
        PipelinedRequest pipelinedRequest = syncTransformRequest(  
            List.of(),
        ProcessorInfo searchPhaseProcessor = new ProcessorInfo("max_score");
                    "p3",
        ClusterState previousState = clusterState;  
            new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), 0.0f),  
        SearchPipelineService searchPipelineService = createWithProcessors(
                    break;
        SearchPipelineService searchPipelineService = getSearchPipelineService(requestProcessors, responseProcessors);  
            null,
    /**  
        SearchPipelineService searchPipelineService = createWithProcessors();
        SearchRequestProcessor throwingRequestProcessor = new FakeRequestProcessor("throwing_request", "1", null, false, r -> {
            buildBaseProcessors().request,
        );  
            hits[i] = new SearchHit(i, "doc" + i, Collections.emptyMap(), Collections.emptyMap());
            null,
                    "test1",
        expectThrows(  
        assertEquals("p1", pipelines.get(0).getId());
        when(threadPool.generic()).thenReturn(executorService);  
        // Return all when no ids specified
        syncExecutePipeline(  
            () -> searchPipelineService.validatePipeline(Map.of(n1, completePipelineInfo, n2, incompletePipelineInfo), putRequest)
                    // processor stats got 1 count and 1 failed  
        org.opensearch.tasks.Task parentTask = mock(org.opensearch.tasks.Task.class);  
            MediaTypeRegistry.JSON
        @Override  
import java.util.LinkedHashMap;
        IndexMetadata indexMetadata = new IndexMetadata.Builder("my_index").settings(defaultPipelineSetting).build();
                searchPipelineService.resolvePipeline(request.pipeline("bad_request_pipeline"), null, indexNameExpressionResolver),
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));  
        );
        public Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessors(Parameters parameters) {
                "p1",
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().size(100).searchPipelineSource(pipelineSourceMap);  
        }
            public boolean shouldGenerate(ProcessorGenerationContext context) {
            .build();  
            null,
            )  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                    "bad_request_pipeline",  
                    break;
        // verify no system generated processors  
        Map<String, Object> copiedInner = (Map<String, Object>) copy.get("normalization");
            null,
        assertTrue(systemGeneratedRequestProcessorPre instanceof FakeSystemGeneratedRequestPreProcessor);
            }
        assertEquals(SearchPipelineService.AD_HOC_PIPELINE_ID, pipeline.getId());
        SearchResponseProcessor systemGeneratedResponseProcessorPre = pipelinedRequest.getSystemGeneratedPipelineHolder()
        int size = 10;  
        SearchResponse searchResponse = new SearchResponse(sections, null, 0, 0, 0, 0, null, null);  
import static org.mockito.Mockito.when;  
        List<ProcessorExecutionDetail> executionDetails = transformedResponse.getInternalResponse().getProcessorResult();
    public void testGetPipelines() {
                )
        ClusterState previousState = clusterState;
        pipelineSourceMap.put(Pipeline.RESPONSE_PROCESSORS_KEY, List.of(responseProcessorObject));
    }  
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);  
        SearchPipelineStats stats = searchPipelineService.stats();
    }  
                    + "\"request_processors\": [{ \"scale_request_size\": { \"scale\" : 2 } }],"  
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)  
        assertEquals("p1", pipelinedRequest.getPipeline().getId());  
     */  
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
                    MediaTypeRegistry.JSON
package org.opensearch.search.pipeline;
            (pf, t, i, f, c, ctx) -> throwingRequestProcessor  
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessors = Map.of(
                null,  
        service.applyClusterState(cce);
                new MockLogAppender.SeenEventExpectation(  
            null,
        pipeline = searchPipelineService.getPipelines().get(id);  
        public FakeStatefulRequestProcessor(String type, Consumer<PipelineProcessingContext> stateConsumer) {  
        }  
        SearchHits searchHits = new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), 0.0f);  
            null,
            .getResponseProcessorFactories();  
        }  
                "p3",
                ),  
                    break;
import java.util.Map;
     */  
            .build();
        assertEquals(5, pipelinedRequest.source().size());
        for (SearchPipelineStats.PerPipelineStats perPipelineStats : stats.getPipelineStats()) {  
            throwingRequestProcessorFactory,
                new PipelineConfiguration(
            assertEquals(2.0, transformedResponse.getHits().getHits()[i].getScore(), 0.0001);
            ) {
import org.opensearch.cluster.ClusterChangedEvent;  
                    // processor stats got 1 count and 1 failed
        assertEquals(0, pipeline.pipeline.getSearchRequestProcessors().size());
                    "p1",
        );  
            Map.of(
            pipelinedRequest.getSystemGeneratedPipelineHolder().isNoOp()  
                "good_response_pipeline",
        assertEquals(5, pipelinedRequest.source().size());  
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, pipelineMetadata).build())
            new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : \"foo\" } } ] }"),
                    (c) -> contextHolder.set((String) c.getAttribute("a"))
        Map<String, Processor.Factory<SearchRequestProcessor>> badFactory = Map.of("bad_factory", (pf, t, i, f, c, ctx) -> {  
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        SearchPipelineService service = createWithProcessors();  
    }
            (pf, t, i, f, c, ctx) -> throwingRequestProcessor  
                "p1",  
import org.opensearch.action.search.DeleteSearchPipelineRequest;
        try {
            new HashMap<>();  
        assertEquals(0, searchPipelineService.getPipelines().size());
                return false;  
                    assertPipelineStats(detailStats.requestProcessorStats().get(0).getStats(), 1, 1);
            Collections.emptyMap()  
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().searchPipelineSource(pipelineSourceMap);
        }  
            throw new RuntimeException();
        pipelineSourceMap.put(Pipeline.RESPONSE_PROCESSORS_KEY, List.of(Map.of("throwing_response", Collections.emptyMap())));
                    assertEquals(0, detailStats.requestProcessorStats().size());
            SearchPipelineProcessingException.class,
        clusterState = ClusterState.builder(clusterState)  
            () -> service.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
import org.opensearch.search.builder.SearchSourceBuilder;  
    }  
                Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
        Map<String, Object> pipelineSourceMap = new HashMap<>();
            threadPool,  
        SearchPipelineService searchPipelineService = createWithProcessors();
        // Bypass the default pipeline
        // Prefix wildcard fails if no matches
                            + "\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ],"  
            null,
            ResourceNotFoundException.class,
            @Override  
            this.type = type;  
                "{"
        assertEquals("p2", pipelines.get(1).getId());
            longId,
            Collections.emptyMap()  
    @Before
            );
        SearchPhaseResultsProcessor systemGeneratedPhaseProcessorPost = pipelinedRequest.getSystemGeneratedPipelineHolder()
import org.opensearch.cluster.service.ClusterService;
                    + "}"
            return response;
import java.util.concurrent.ExecutorService;
                "verbose_pipeline",
                response
        Map<String, Object> processorConfig = new HashMap<>(
            searchPipelineService.resolvePipeline(request.pipeline("good_request_pipeline"), null, indexNameExpressionResolver),
        Map<String, Object> config = new LinkedHashMap<>();  
    }
        SearchResponseSections sections = new SearchResponseSections(  
        // Match all
        // Caught Exception thrown when processing response and produced warn level logging message
    }
        );
            1,
            List.of(DUMMY_PLUGIN),  
    @SuppressWarnings("unchecked")
            hits[i].score(i);  
        public FakeStatefulResponseProcessor(String type, Consumer<PipelineProcessingContext> stateConsumer) {
        Map<String, Object> pipelineSourceMap = new HashMap<>();  
        assertTrue(info.containsProcessor(Pipeline.REQUEST_PROCESSORS_KEY, "scale_request_size"));  
        pipelines = SearchPipelineService.innerGetPipelines(metadata, "p1");
    public void testInlinePipelineSourceIsNotDrainedAfterResolve() throws Exception {
            response
            threadPool,  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
            .applySettings(Settings.builder().putList(ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING.getKey(), "dummy_factory").build());  
        clusterState = ClusterState.builder(clusterState)
                Map<String, Object> config,  
        );
            response
                    assertEquals("throwing_response", detailStats.responseProcessorStats().get(0).getProcessorType());
        assertPipelineStats(stats.getTotalResponseStats(), 2, 0);
            .getSearchPhaseResultsProcessors()
            )
            new BytesArray(
        assertEquals(5, pipelinedRequest.source().size());
    }  
            )
        assertTrue(e.getMessage(), e.getMessage().contains(" already registered"));
        assertNotNull(pipeline);
            .getFirst();
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(  
        );  
            () -> syncExecutePipeline(
        assertEquals(1, pipeline.getSearchResponseProcessors().size());  
        threadPool = mock(ThreadPool.class);
        Client client = mock(Client.class);
        assertEquals("p1", pipelines.get(0).getId());
        );  
            .getSearchResponseProcessors()  
        );  
        );
                    MediaTypeRegistry.JSON  
            "Search Pipeline id [%s] exceeds maximum length of 512 UTF-8 bytes (actual: 513 bytes)",  
            searchPipelineService.getPipelines().get("_id").pipeline.getSearchRequestProcessors().get(0).getType()
        ClusterState previousClusterState = clusterState;
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
        );  
        for (int i = 0; i < size; i++) {
    public void testIsSystemGeneratedFactoryEnabled_whenAllEnabled_thenTrue() throws Exception {
        SearchPipelineService searchPipelineService = createWithProcessors();
        } catch (SearchPipelineProcessingException e) {
        return searchPipelineService;  
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().searchPipelineSource(pipelineSourceMap);
        assertEquals(0, pipeline.pipeline.getSearchRequestProcessors().size());
            Collections.emptyMap(),
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
        }
            .getFirst();
                    assertPipelineStats(detailStats.responseProcessorStats().get(0).getStats(), 1, 0);
            mockAppender.assertAllExpectationsMatched();
        SearchRequestProcessor throwingRequestProcessor = new FakeRequestProcessor("throwing_request", null, null, false, r -> {
                    assertEquals("throwing_response", detailStats.responseProcessorStats().get(0).getProcessorType());  
            .build();  
        // Verify that pipeline transforms request  
                String description,  
            hits[i].score(i);
                            + "}"
        expectThrows(
            (pf, t, i, f, c, ctx) -> new FakeRequestProcessor("successful_request", "2", null, false, r -> {}),
            searchPipelineService.resolvePipeline(request.pipeline("bad_request_pipeline"), null, indexNameExpressionResolver),  
        ClusterState previousState = clusterState;
                ),  
        // Verify pipeline  
            false,  
        }  
import org.opensearch.plugins.SearchPipelinePlugin;
            .prePipeline()  
        assertEquals(0, pipeline.pipeline.getSearchPhaseResultsProcessors().size());  
                new PipelineConfiguration(
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
import org.opensearch.core.common.bytes.BytesArray;
        assertNull("null config copies to null", SearchPipelineService.deepCopyConfig(null));  
        Map<String, Object> pipelineSourceMap = new HashMap<>();
        Metadata.Builder mdBuilder = Metadata.builder()
            this.xContentRegistry(),
            null,
            null,  
                )
        assertEquals(failed, stats.getFailedCount());
        putRequest = new PutSearchPipelineRequest(id, new BytesArray("{ \"description\": \"empty pipeline\"}"), MediaTypeRegistry.JSON);
 * The OpenSearch Contributors require contributions made to  
        assertTrue(phaseInjectorProcessorFactories.containsKey("zoe"));  
                null,
            client
            Collections.emptyMap(),
import org.opensearch.Version;  
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().size(100).searchPipelineSource(pipelineSourceMap);
    public void testSearchPipelinePlugin() {
        SearchPipelineService searchPipelineService = createWithProcessors(  
                        "{\"request_processors\" : [ { \"write_context\": {} } ], \"response_processors\": [ { \"read_context\": {} }] }"
                    + "\"phase_results_processors\" : [ { \"max_score\" : { \"score\": 100 } } ]"  
    }
        }  
        );  
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));  
            buildBaseProcessors().request,
            Map.of(
            Collections.emptyMap(),
                    assertPipelineStats(perPipelineStats.getRequestStats(), 1, 1);
                ),  
        SearchHits searchHits = new SearchHits(hits, new TotalHits(size * 2, TotalHits.Relation.EQUAL_TO), size);  
                    assertEquals("successful_request:2", detailStats.requestProcessorStats().get(0).getProcessorName());
            Map.of(  
        assertEquals("_none", pipelinedRequest.getPipeline().getId());
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
            new BytesArray(
            (pf, t, i, f, c, ctx) -> throwingResponseProcessor  
        // Get specific pipeline
            )
            responseProcessorsEnableIgnoreFailure,
                String tag,  
                    "read_context",  
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
            List.of(),
                    assertEquals("successful_response:4", detailStats.responseProcessorStats().get(0).getProcessorName());
        SearchRequest searchRequest = new SearchRequest("bar").source(SearchSourceBuilder.searchSource().size(5));
        DeleteSearchPipelineRequest deleteRequest = new DeleteSearchPipelineRequest("p*");  
                mock(ClusterService.class),
        List<ProcessorExecutionDetail> executionDetails = transformedResponse.getInternalResponse().getProcessorResult();
            new SearchRequest().source(createDefaultSearchSourceBuilder()).pipeline("p1"),  
                    "p1",
        Map<String, Processor.Factory<SearchRequestProcessor>> throwingRequestProcessorFactory = Map.of(
            mockAppender.assertAllExpectationsMatched();  
            )  
        assertEquals("p2", pipelines.get(1).getId());  
        assertEquals(count, stats.getCount());
    }
            () -> syncTransformRequest(searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver))
                "{ "  
import org.opensearch.action.search.SearchRequest;  
        return new NamedWriteableRegistry(searchModule.getNamedWriteables());
        );
            searchPipelineService.resolvePipeline(request.pipeline("bad_response_pipeline"), null, indexNameExpressionResolver),  
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().size(100).pipeline("p1");
    }  
        Settings defaultPipelineSetting = Settings.builder()  
                    assertEquals("successful_request:2", detailStats.requestProcessorStats().get(0).getProcessorName());  
        Pipeline pipeline = pipelinedRequest.getPipeline();  
            Map.of(
                boolean ignoreFailure,
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(  
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));  
                    "p2",
                    assertPipelineStats(perPipelineStats.getResponseStats(), 0, 0);
        Map<String, Object> copy = SearchPipelineService.deepCopyConfig(config);  
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),  
            .put(indexBuilder("foo", defaultPipelineSetting).putAlias(AliasMetadata.builder("bar")))
                    break;
        });
import org.opensearch.cluster.metadata.AliasMetadata;  
        );
        );
            new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), 0.0f),
        clusterState = ClusterState.builder(clusterState)
            public SearchRequestProcessor create(
            );  
            }
        assertEquals(1, phaseInjectorProcessorFactories.size());
            Map.of(  
            );
            new BytesArray("{\"request_processors\":[" + " { \"" + processorType + "\": {}}" + "]}"),
                    assertPipelineStats(perPipelineStats.getRequestStats(), 1, 0);  
        assertNotNull(searchPipelineService.getPipelines().get("p2"));
    }  
        SearchResponseSections sections = new SearchResponseSections(searchHits, null, null, false, null, null, 1, List.of(), List.of());
        assertEquals(2, pipelines.size());
        DiscoveryNode n2 = new DiscoveryNode("n2", buildNewFakeTransportAddress(), Version.CURRENT);
            Map.of(
        Map<String, Object> pipelineSourceMap = new HashMap<>();  
        assertEquals(2, scaleProcessorAfter.get("scale"));  
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
        public SearchRequest processRequest(SearchRequest request, PipelineProcessingContext requestContext) throws Exception {  
        Map<String, Object> pipelineSourceMap = new HashMap<>();
                    MediaTypeRegistry.JSON
                    assertEquals("successful_response", detailStats.responseProcessorStats().get(0).getProcessorType());  
        IllegalArgumentException e = expectThrows(
            .getRequestProcessorFactories();
                ),
        Map<String, Object> requestProcessorConfig = new HashMap<>();  
        assertEquals(200, pipelinedRequest.source().size());
                case "good_request_pipeline":  
        clusterState = ClusterState.builder(clusterState)
        assertEquals(2, executionDetails.size());
                new PipelineConfiguration("p1", definition, MediaTypeRegistry.JSON),  
        );
    public void testDeletePipelinesWithWildcard() {  
                    "good_request_pipeline",  
                    break;  
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorFactories = searchPipelineService
     * construction reads the config by removing keys (ConfigurationUtils.readXxx), so the resolver copies the config  
                ),
                    new BytesArray(
    }  
        setUpForResolvePipeline(service);
            fail("Exception should have been thrown");  
                    "p1",
                    assertEquals("successful_request", detailStats.requestProcessorStats().get(0).getProcessorType());
        private final Consumer<PipelineProcessingContext> stateConsumer;
        inner.put("nullable", null);                                // null value via the scalar path
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
        enabledAllSystemGeneratedFactories(service);  
        Map<String, Object> responseProcessorObject = new HashMap<>();
        private final String type;
                    "test1",
        List<PipelineConfiguration> pipelines = SearchPipelineService.innerGetPipelines(metadata);  
                )
            SearchPipelineProcessingException.class,
                    MediaTypeRegistry.JSON
        assertEquals("indices:data/read/msearch", capturedParentAction.get());  
        String id = "_id";
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);  
        IllegalArgumentException e = expectThrows(  
    }  
        assertNotSame(inner.get("weights"), copiedInner.get("weights"));
        );  
            throwingResponseProcessorFactory,
        clusterState = SearchPipelineService.innerDelete(deleteAllRequest, clusterState);  
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        SearchResponse searchResponse = new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        SearchPipelineService service = createWithProcessors(
        assertEquals(1, pipeline.getSearchResponseProcessors().size());
                    MediaTypeRegistry.JSON
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.common.metrics.OperationStats;
    public void testResolveSearchPipelineDoesNotExist() {
            throws Exception {
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(SearchPipelineService.class))) {
            .build();
            requestProcessorsEnableIgnoreFailure,  
import org.opensearch.test.MockLogAppender;
        // Same content...
        Map<String, Processor.Factory<SearchResponseProcessor>> throwingResponseProcessorFactory = Map.of(  
        syncExecutePipeline(  
        Map<String, Object> scaleProcessorAfter = (Map<String, Object>) processorsAfter.get(0).get("scale_request_size");
    }
        searchRequest.source().verbosePipeline(true);
            Map.of(
        clusterState = ClusterState.builder(clusterState)
                    assertPipelineStats(detailStats.responseProcessorStats().get(0).getStats(), 1, 1);
        // Exception thrown when creating the pipeline
        assertEquals("p1", pipelinedRequest.getPipeline().getId());
                "bad_response_pipeline",
        SearchPipelineService searchPipelineService = createWithProcessors();
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);  
        );
        responseProcessorConfig.put("score", 2);
                    assertPipelineStats(detailStats.responseProcessorStats().get(0).getStats(), 1, 1);  
            systemGeneratedRequestProcessors,
            return type;
            .postPipeline()  
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        PutSearchPipelineRequest badPutRequest = new PutSearchPipelineRequest(  
            hits[i] = new SearchHit(i, "doc" + i, Collections.emptyMap(), Collections.emptyMap());  
            }
        );
            MediaTypeRegistry.JSON  
    public void testDeletePipeline() {
        request.source(createDefaultSearchSourceBuilder());  
            IllegalArgumentException.class,
            .prePipeline()
    public void testResolveSystemGeneratedSearchPipeline_whenDisableSystemGeneratedFactories_thenNoGeneration() throws Exception {
        );
        ClusterState previousState = clusterState;
            MediaTypeRegistry.JSON
        ClusterState previousClusterState = clusterState;
        );
                    "bad_response_pipeline",  
                    + "}"  
        SearchPipelineService searchPipelineService = createWithProcessors();  
                return false;
                Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
        assertNull(pipeline);
                new PipelineConfiguration(
        );
            )
    }
        assertNotNull(searchPipelineService.getPipelines().get("p1"));
    }
    public void testExceptionOnResponseProcessing() throws Exception {
                    assertEquals(1, detailStats.requestProcessorStats().size());
                String tag,
                    new BytesArray("{" + "\"response_processors\": [ { \"fixed_score\": { \"score\": 5.0 } } ]" + "}"),
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
    }  
            "successful_response",  
        request.source(createDefaultSearchSourceBuilder());  
        Map<String, Object> pipelineSourceMap = new HashMap<>();  
                )
            searchPipelineService.resolvePipeline(request.pipeline("good_response_pipeline"), null, indexNameExpressionResolver),
        responseProcessorObject.put("fixed_score", responseProcessorConfig);  
import java.util.concurrent.atomic.AtomicReference;  
        SearchPipelineInfo completePipelineInfo = new SearchPipelineInfo(  
                    "verbose_pipeline",  
        assertEquals("b", contextHolder.get());
            throw new RuntimeException();  
        when(clusterService.getClusterSettings()).thenReturn(
        assertEquals(0, searchPipelineService.getPipelines().size());
        Client client = mock(Client.class);
    }  
        );
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessorsEnableIgnoreFailure = Map.of(
                new PipelineConfiguration(
        systemGeneratedRequestProcessors.put("action_aware_processor", new SystemGeneratedProcessor.SystemGeneratedFactory<>() {
            (pf, t, i, f, c, ctx) -> throwingRequestProcessor  
        ClusterChangedEvent cce = new ClusterChangedEvent("", clusterState, previousState);
        ClusterState updatedState = ClusterState.builder(initialState)
            if (ctx.getPipelineSource() == Processor.PipelineSource.SEARCH_REQUEST) {
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p1")
            Map.of(  
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().size(100).searchPipelineSource(pipelineSourceMap);  
        requestProcessorConfig.put("scale", 2);
        assertEquals(3, pipelines.size());
            Map.of(
            "p1",
    }
        @Override
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
        );  
        pipelines = SearchPipelineService.innerGetPipelines(metadata, "p1", "p2");
        );  
            "throwing_request",
            .build();
                String description,
                    MediaTypeRegistry.JSON
        SearchRequest searchRequest = new SearchRequest().source(SearchSourceBuilder.searchSource().size(10))  
            Collections.emptyMap()
        assertEquals(expectedError, exception.getMessage());  
        SearchPipelineService searchPipelineService = new SearchPipelineService(
        SearchPipelineService searchPipelineService = createWithProcessors();
        String errorMessage = String.format(
            (pf, t, i, f, c, ctx) -> new FakeResponseProcessor("successful_response", "4", null, true, r -> {}),
                    + "\"phase_results_processors\" : [ { \"max_score\" : { } } ]"
                )
            new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : \"foo\" } } ] }"),  
        assertEquals(1, executionDetails.size());
        // Discovery failed, no infos passed.
                new MockLogAppender.SeenEventExpectation(  
                    assertEquals(0, detailStats.responseProcessorStats().size());
                    assertPipelineStats(perPipelineStats.getResponseStats(), 1, 0);
    }
        List<Map<String, Object>> processorsAfter = (List<Map<String, Object>>) sourceAfter.get(Pipeline.REQUEST_PROCESSORS_KEY);
                    assertEquals("successful_response:4", detailStats.responseProcessorStats().get(0).getProcessorName());
            throw new RuntimeException();  
        assertEquals(1, pipeline.getSearchRequestProcessors().size());
                return null;  
            .put(indexBuilder("foo", defaultPipelineSetting1).putAlias(AliasMetadata.builder("bar")))  
        assertNotSame(config.get("normalization"), copy.get("normalization"));  
            null,
                    MediaTypeRegistry.JSON  
                    new BytesArray("{\"request_processors\" : [ { \"successful_request\": {} } ] }"),
        );  
        DeleteSearchPipelineRequest deleteRequest = new DeleteSearchPipelineRequest("_id");  
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
    /**
        ClusterState previousState = clusterState;
        SearchResponseProcessor throwingResponseProcessor = new FakeResponseProcessor("throwing_response", null, null, true, r -> {
    }
    public void testIsSystemGeneratedFactoryEnabled_whenNotEnabled_thenFalse() {
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
