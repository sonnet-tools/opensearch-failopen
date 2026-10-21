                    "p1",
        SearchPipelineService searchPipelineService = createWithProcessors();
        assertNull(capturedParentAction.get());
            .getFirst();
        SearchResponseProcessor systemGeneratedResponseProcessorPost = pipelinedRequest.getSystemGeneratedPipelineHolder()
        ClusterState updatedState = ClusterState.builder(initialState)
        assertTrue(systemGeneratedRequestProcessorPost instanceof FakeSystemGeneratedRequestPostProcessor);
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
        Map<String, Object> pipelineSourceMap = new HashMap<>();
        );
                e.getMessage()
            SearchPipelineStats.PipelineDetailStats detailStats = stats.getPerPipelineProcessorStats()
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().searchPipelineSource(pipelineSourceMap);
        pipelines = SearchPipelineService.innerGetPipelines(metadata, "*");
            systemGeneratedRequestProcessors,
        DeleteSearchPipelineRequest deleteRequest = new DeleteSearchPipelineRequest("_id");
        setUpForResolvePipeline(service);
                String description,
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().searchPipelineSource(pipelineSourceMap);
                            + "}"
        ProcessorInfo rspProcessor = new ProcessorInfo("fixed_score");
            .build();
        syncExecutePipeline(
        clusterState = ClusterState.builder(clusterState)
            ),
        // Overwrite pipeline
        );
            Map.of(
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p1")
        Map<String, Object> pipelineSourceMap = new HashMap<>();
            if (ctx.getPipelineSource() == Processor.PipelineSource.SEARCH_REQUEST) {
        });
        List<PipelineConfiguration> pipelines = SearchPipelineService.innerGetPipelines(metadata);
            this.xContentRegistry(),
            new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), 0.0f),
                    + "}"
                "q1",
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        assertEquals(0, SearchPipelineService.innerGetPipelines(null, "p1").size());
                ),
        setUpForResolvePipeline(service);
            hits[i] = new SearchHit(i, "doc" + i, Collections.emptyMap(), Collections.emptyMap());
        );
    }
                "{ "
        public String getType() {
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
            () -> searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
            Map.of(
            Map.of(
        assertFalse(service.isSystemGeneratedFactoryEnabled("dummy_factory"));
            Map.of(
        searchPipelineService.applyClusterState(new ClusterChangedEvent("clusterStateUpdated", updatedState, initialState));
            (pf, t, i, f, c, ctx) -> throwingRequestProcessor
                ),
            .getRequestProcessorFactories();
        ClusterState previousState = clusterState;
                List.of(DUMMY_PLUGIN, DUMMY_PLUGIN),
            null,
        // Same content...
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
            throw new RuntimeException();
        SearchResponse searchResponse = new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
                    break;
                "good_response_pipeline",
                    assertEquals("throwing_request", detailStats.requestProcessorStats().get(0).getProcessorType());
    public void testVerbosePipelineWithoutDefinedPipelineThrowsException() {
            id,
        clusterState = SearchPipelineService.innerPut(putRequest, clusterState);
    public void testStatsEnabledIgnoreFailure() throws Exception {
    public void testVerbosePipelineWithResponseProcessorOnly() throws Exception {
                            + "\"response_processors\": [{ \"fixed_score\": { \"score\" : 2 } }]"
                "p1",
        clusterState = ClusterState.builder(clusterState)
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(
        public Map<String, Processor.Factory<SearchPhaseResultsProcessor>> getSearchPhaseResultsProcessors(Parameters parameters) {
        }
                    MediaTypeRegistry.JSON
                "write_context",
        PipelinedRequest pipelinedRequest = syncTransformRequest(service.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
        assertPipelineStats(stats.getTotalRequestStats(), 2, 1);
            Map.of(
        SearchResponseProcessor throwingResponseProcessor = new FakeResponseProcessor("throwing_response", null, null, false, r -> {
            OpenSearchParseException.class,
package org.opensearch.search.pipeline;
            new HashMap<>();
                    new BytesArray("{\"response_processors\" : [ { \"successful_response\": {} } ] }"),
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
                    assertEquals(1, detailStats.responseProcessorStats().size());
            Collections.emptyMap()
    public void testDeepCopyConfigIsDeepAndIndependent() {
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        );
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);
        service.applyClusterState(cce);
        assertEquals(
            new HashMap<>();
            .build();
import org.opensearch.OpenSearchParseException;
        expectThrows(
        );
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        );
        ClusterState previousClusterState = clusterState;
            throw new RuntimeException();
        Pipeline pipeline = pipelinedRequest.getPipeline();
import java.util.Collections;
        SearchPipelineService service = createWithProcessors();
            Collections.emptyMap()
                new PipelineConfiguration(
                capturedParentAction.set(context.parentAction());
            ),
        assertEquals("p3", pipelines.get(2).getId());
                    new BytesArray(
import org.opensearch.action.search.PutSearchPipelineRequest;
            )
        assertTrue(systemGeneratedPhaseProcessorPre instanceof FakeSystemGeneratedSearchPhaseResultsPreProcessor);
        clusterState = SearchPipelineService.innerPut(putRequest, clusterState);
        searchRequest.source().verbosePipeline(true);
        assertEquals(5, pipelinedRequest.source().size());
        SearchRequest searchRequest = new SearchRequest().source(SearchSourceBuilder.searchSource().size(10))
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
            threadPool,
import java.util.HashMap;
        SearchResponse response = createDefaultSearchResponse();
        @SuppressWarnings("unchecked")
        assertEquals("p2", pipelines.get(1).getId());
    public void testResolveSystemGeneratedSearchPipeline_whenNoParentTask_thenContextHasNullParentAction() throws Exception {
    }
                )
        assertEquals(0, searchPipelineService.getPipelines().size());
import java.util.Map;
                Map<String, Object> config,
            )
                    MediaTypeRegistry.JSON
            hits[i].score(i);
    private static void assertPipelineStats(OperationStats stats, long count, long failed) {
            searchPipelineService.resolvePipeline(request.pipeline("good_request_pipeline"), null, indexNameExpressionResolver),
                ),
            this.xContentRegistry(),
        when(clusterService.getClusterSettings()).thenReturn(
    }
            return request;
            throw new RuntimeException();
            "throwing_response",
                "p1",
        // The following line successfully creates the pipeline:
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            switch (perPipelineStats.getPipelineId()) {
            null,
        assertTrue("original scalar retained", inner.containsKey("technique"));
            systemGeneratedRequestProcessors,
        SearchHit[] hits = new SearchHit[size];
        assertEquals(1, pipeline.getSearchRequestProcessors().size());
        Map<String, Processor.Factory<SearchRequestProcessor>> badFactory = Map.of("bad_factory", (pf, t, i, f, c, ctx) -> {
    }
        SearchResponseProcessor throwingResponseProcessor = new FakeResponseProcessor("throwing_response", null, null, true, r -> {
        // Caught Exception here
        return searchPipelineService;
            }
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
    };
        SearchPipelineService service = createWithProcessors();
        String expectedError =
                case "good_request_pipeline":
                case "good_request_pipeline":
                )
        assertNotNull(executionDetails);
            false,
        SearchPipelineService service = createWithSystemGeneratedProcessors();
        assertEquals("p1", pipelines.get(0).getId());
                ),
            IllegalArgumentException.class,
        pipeline = searchPipelineService.getPipelines().get(id);
        BytesArray definition = new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }");
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                "response_only_pipeline",
                null,
        assertEquals("b", contextHolder.get());
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        assertEquals("p1", pipelines.get(0).getId());
        assertEquals(3, pipelines.size());
        });
        for (int i = 0; i < size; i++) {
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));
                return null;
            SearchPipelineStats.PipelineDetailStats detailStats = stats.getPerPipelineProcessorStats()
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p1")
        final ClusterState finalClusterState = clusterState;
    public void testIsSystemGeneratedFactoryEnabled_whenEnabled_thenTrue() {
                    "test1",
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessors = new HashMap<>();
        );
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        ResourceNotFoundException e = expectThrows(
import org.opensearch.cluster.ClusterChangedEvent;
        assertEquals("p2", pipelines.get(1).getId());
            response
        PipelinedRequest pipelinedRequest = syncTransformRequest(
        @Override
            new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
        previousState = clusterState;
        );
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().size(100).pipeline("p1");
        PipelineConfiguration config = new PipelineConfiguration(
        searchRequest.source().verbosePipeline(true);
        );
        // Exception thrown when processing the request
        assertEquals(failed, stats.getFailedCount());
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
            "max_score",
        assertEquals(1, searchPipelineService.getPipelines().size());
        );
        SearchPipelineService searchPipelineService = createWithProcessors(
        );
            )
                    MediaTypeRegistry.JSON
        Map<String, Object> pipelineSourceMap = new HashMap<>();
        );
            )
            .pipeline("response_only_pipeline");
            return Map.of("foo", (factories, tag, description, ignoreFailure, config, ctx) -> null);
    }
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p1")
        clusterState = SearchPipelineService.innerDelete(deleteAllRequest, clusterState);
        syncExecutePipeline(request, createDefaultSearchResponse());
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        systemGeneratedRequestProcessors.put("action_aware_processor", new SystemGeneratedProcessor.SystemGeneratedFactory<>() {
            ),
        );
        SearchPipelineService searchPipelineService = createWithProcessors();
        // user defined pipeline is resolved
        pipelineSourceMap.put(Pipeline.RESPONSE_PROCESSORS_KEY, List.of(Map.of("throwing_response", Collections.emptyMap())));
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        }
        );
     */
        assertNull(searchPipelineService.getPipelines().get("_id").pipeline.getDescription());
            ClassCastException.class,
                    (c) -> contextHolder.set((String) c.getAttribute("a"))
                new PipelineConfiguration(
        SearchRequest searchRequest = new SearchRequest("bar").source(SearchSourceBuilder.searchSource().size(5));
    public void testSearchPipelinePlugin() {
                "p1",
    }
        // Bypass the default pipeline
        // Exception thrown when creating the pipeline
            List.of()
                            + "}"
        ClusterChangedEvent cce = new ClusterChangedEvent("", clusterState, previousState);
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().searchPipelineSource(pipelineSourceMap);
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(requestProcessorObject));
        );
                        "{"
                "read_context",
                    // pipeline succeed when ignore failure is true
        DeleteSearchPipelineRequest deleteRequest = new DeleteSearchPipelineRequest("p*");
import org.opensearch.cluster.metadata.Metadata;
                response
        assertEquals(5, pipelinedRequest.source().size());
            .put(indexBuilder("foofoo-closed", defaultPipelineSetting).putAlias(AliasMetadata.builder("bar")))
            Map.of("score", 1.0f, "tag", "my_tag", "comment", "I just like to add extra parameters so that I feel like I'm being heard.")
import org.opensearch.cluster.ClusterState;
        ProcessorInfo searchPhaseProcessor = new ProcessorInfo("max_score");
        syncExecutePipeline(
        assertEquals(1, pipeline.getSearchResponseProcessors().size());
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
        private final String type;
                    + "}"
            () -> syncExecutePipeline(
                "p1",
        SearchPipelineMetadata pipelineMetadata = new SearchPipelineMetadata(Map.of("_id", pipeline));
            indexNameExpressionResolver
        });
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        Map<String, Object> pipelineSourceMap = new HashMap<>();
        assertEquals(SearchPipelineService.AD_HOC_PIPELINE_ID, pipeline.getId());
        assertTrue(sourceAfter.containsKey(Pipeline.REQUEST_PROCESSORS_KEY));
    }
                    + "\"response_processors\": [{ \"fixed_score\": { \"score\" : 2 } }],"
        assertTrue(pipelinedRequest.getSystemGeneratedPipelineHolder().isNoOp());
        SearchResponseSections sections = new SearchResponseSections(
 * The OpenSearch Contributors require contributions made to
import java.util.concurrent.ExecutorService;
        previousState = clusterState;
        SearchRequest searchRequest = new SearchRequest();
            }
                    + "\"phase_results_processors\" : [ { \"max_score\" : { \"score\": 100 } } ]"
        ClusterState previousClusterState = clusterState;
                    break;
        // Return all when no ids specified
        ResourceNotFoundException e = expectThrows(
        assertEquals(
    public void testIsSystemGeneratedFactoryEnabled_whenNotEnabled_thenFalse() {
                    MediaTypeRegistry.JSON
            SearchPipelineProcessingException.class,
        assertEquals("_none", pipelinedRequest.getPipeline().getId());
            "fixed_score",
            .build();
        threadPool = mock(ThreadPool.class);
        SearchPipelineService searchPipelineService = createWithProcessors(
        );
                new PipelineConfiguration(
        assertEquals(1, requestProcessorFactories.size());
                    MediaTypeRegistry.JSON
                    + "\"response_processors\": [{ \"fixed_score\": { \"score\" : 2 } }]"
        assertNotSame(inner.get("weights"), copiedInner.get("weights"));
        public SearchResponse processResponse(SearchRequest request, SearchResponse response, PipelineProcessingContext requestContext)
        searchPipelineService.applyClusterState(new ClusterChangedEvent("clusterStateUpdated", updatedState, initialState));
                    new BytesArray(
        assertEquals("original list retained", 2, ((List<Object>) inner.get("weights")).size());
/*
        ProcessorInfo reqProcessor = new ProcessorInfo("scale_request_size");
        );
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
            )
            }
            Collections.emptyMap(),
            .metadata(Metadata.builder().put(indexMetadata, false).putCustom(SearchPipelineMetadata.TYPE, metadata))
        SearchPipelineService searchPipelineService = createWithProcessors(
                    assertPipelineStats(perPipelineStats.getRequestStats(), 0, 0);
        );
        assertEquals("_id", searchPipelineService.getPipelines().get("_id").pipeline.getId());
        requestProcessorObject.put("scale_request_size", requestProcessorConfig);
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        assertEquals("p1", pipelines.get(0).getId());
        assertEquals(0, searchPipelineService.getPipelines().size());
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
            Collections.emptyMap()
        SearchHits searchHits = new SearchHits(hits, new TotalHits(size * 2, TotalHits.Relation.EQUAL_TO), size);
                    new BytesArray("{" + "\"response_processors\": [ { \"fixed_score\": { \"score\": 5.0 } } ]" + "}"),
        Exception e = expectThrows(
        responseProcessorConfig.put("score", 2);
        );
                    new BytesArray("{\"request_processors\" : [ { \"successful_request\": {} } ] }"),
        // The ad hoc pipeline was built (proving the config was read)...
        );
                    assertPipelineStats(perPipelineStats.getRequestStats(), 1, 1);
        super.setUp();
        previousState = clusterState;
                )
        assertEquals(200, pipelinedRequest.source().size());
        pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        );
        assertTrue(systemGeneratedRequestProcessorPre instanceof FakeSystemGeneratedRequestPreProcessor);
                new PipelineConfiguration("p2", definition, MediaTypeRegistry.JSON),
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
        assertTrue(systemGeneratedPhaseProcessorPost instanceof FakeSystemGeneratedSearchPhaseResultsPostProcessor);
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessors =
import org.opensearch.cluster.node.DiscoveryNode;
        DiscoveryNode n1 = new DiscoveryNode("n1", buildNewFakeTransportAddress(), Version.CURRENT);
                    assertPipelineStats(detailStats.responseProcessorStats().get(0).getStats(), 1, 1);
            throwingResponseProcessorFactory,
import org.opensearch.action.search.SearchResponse;
    @Before
            "throwing_request",
        SearchPipelineService searchPipelineService = createWithProcessors();
        assertEquals(count, stats.getCount());
            public SearchRequestProcessor create(
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
        IllegalArgumentException e = expectThrows(
            false,
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                .get(perPipelineStats.getPipelineId());
        assertTrue(info.containsProcessor(Pipeline.RESPONSE_PROCESSORS_KEY, "fixed_score"));
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        Client client = mock(Client.class);
        SearchPipelineService searchPipelineService = createWithProcessors(
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);
                "p1",
 *
                    assertEquals(1, detailStats.requestProcessorStats().size());
        clusterState = SearchPipelineService.innerDelete(deleteRequest, clusterState);
import org.apache.logging.log4j.LogManager;
                    .contains("processor [fixed_score:my_tag] doesn't support one or more provided configuration parameters: [comment]")
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
        }
        ClusterChangedEvent cce = new ClusterChangedEvent("", clusterState, previousState);
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        PipelinedRequest pipelinedRequest = syncTransformRequest(
    }
                    assertEquals("successful_response:4", detailStats.responseProcessorStats().get(0).getProcessorName());
        systemGeneratedRequestProcessors.put("system_scale_request_size_1", new SystemGeneratedScaleRequestSizePreFactory());
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
        assertEquals("fixed_score", executionDetails.get(1).getProcessorName());
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        SearchPipelineInfo info = searchPipelineService.info();
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessors = Map.of(
            .build();
        assertEquals(10, pipelinedRequest.source().size());
            response
        );
        Map<String, Object> pipelineSourceMap = new HashMap<>();
                List.of(reqProcessor),
                )
                String tag,
        );
        assertEquals(5, pipelinedRequest.source().size());
        SearchPhaseResultsProcessor systemGeneratedPhaseProcessorPost = pipelinedRequest.getSystemGeneratedPipelineHolder()
        setUpForResolvePipeline(service);
            "throwing_request",
        assertEquals(200, pipelinedRequest.source().size());
        );
import org.apache.lucene.search.TotalHits;
            hits[i].score(i);
            (pf, t, i, f, c, ctx) -> throwingResponseProcessor
        SearchPipelineService searchPipelineService = createWithProcessors();
        assertEquals(1, pipeline.getSearchResponseProcessors().size());
                    "good_response_pipeline",
    public void testNoIndexResolveIndexDefaultPipeline() throws Exception {
    /**
                    break;
    public void testVerbosePipelineWithRequestProcessorOnly() throws Exception {
        ClusterChangedEvent cce = new ClusterChangedEvent("", clusterState, previousState);
import org.opensearch.action.search.SearchRequest;
        Map<String, Object> responseProcessorObject = new HashMap<>();
        SearchResponse searchResponse = new SearchResponse(sections, null, 0, 0, 0, 0, null, null);
            Collections.emptyMap()
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessorsEnableIgnoreFailure = Map.of(
            this.stateConsumer = stateConsumer;
        );
            Locale.ROOT,
        SearchPipelineService service = createWithProcessors(
        );
        Map<String, Object> processorConfig = new HashMap<>(
        // Add the factory again to generate two processors in the same execution stage
            super(null, null, false);
            }
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, pipelineMetadata).build())
            Collections.emptyMap()
            hits[i] = new SearchHit(i, "doc" + i, Collections.emptyMap(), Collections.emptyMap());
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        copiedInner.remove("technique");
                        "{\"request_processors\" : [ { \"write_context\": {} } ], \"response_processors\": [ { \"read_context\": {} }] }"
            List.of()
                new MockLogAppender.SeenEventExpectation(
            mockAppender.assertAllExpectationsMatched();
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
            MediaTypeRegistry.JSON
        String id = "_id";
            )
        // Invalid configuration in request
        SearchPipelineService searchPipelineService = createWithProcessors(badFactory, Collections.emptyMap(), Collections.emptyMap());
            () -> searchPipelineService.validatePipeline(Map.of(n1, completePipelineInfo), maxLengthIdPutRequest)
        assertNotNull(executionDetails);
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
        Map<String, Object> sourceAfter = searchRequest.source().searchPipelineSource();
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
            "scale_request_size",
            null,
        ClusterState initialState = ClusterState.builder(new ClusterName("_name")).build();
        expectThrows(
            new BytesArray(
    public void testResolveSystemGeneratedSearchPipeline_whenParentTaskProvided_thenContextHasParentAction() throws Exception {
        setUpForResolvePipeline(service);
                    + "\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ], "
        searchRequest.source().verbosePipeline(true);
            Collections.emptyMap(),
        ClusterState previousState = clusterState;
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p1")
        SearchRequestProcessor throwingRequestProcessor = new FakeRequestProcessor("throwing_request", null, null, false, r -> {
        ClusterState updatedState = ClusterState.builder(initialState)
                    Pipeline.class.getCanonicalName(),
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(id, new BytesArray("{}"), MediaTypeRegistry.JSON);
                new PipelineConfiguration(
            (pf, t, i, f, c, ctx) -> throwingResponseProcessor
                    + "\"response_processors\" : [ { \"fixed_score\" : { \"score\" : 1.0 } } ],"
                    assertPipelineStats(perPipelineStats.getRequestStats(), 0, 0);
                "good_request_pipeline",
            .put(indexBuilder("foofoo-closed", defaultPipelineSetting1).putAlias(AliasMetadata.builder("bar")))
        assertEquals(1, phaseInjectorProcessorFactories.size());
        assertEquals(1, searchPipelineService.getPipelines().get("_id").pipeline.getSearchResponseProcessors().size());
                    SearchPipelineService.class.getCanonicalName(),
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessors =
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));
            mockAppender.assertAllExpectationsMatched();
            .put(indexBuilder("foo", defaultPipelineSetting).putAlias(AliasMetadata.builder("bar")))
    }
                    "good_request_pipeline",
        pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        SearchResponseProcessor throwingResponseProcessor = new FakeResponseProcessor("throwing_response", "3", null, true, r -> {
            .getFirst();
        assertTrue(e.getMessage(), e.getMessage().contains("The 'verbose pipeline' option requires a search pipeline to be defined."));
                "verbose_pipeline",
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
    }
                    break;
                String tag,
    public void testDeletePipelinesWithWildcard() {
    public void testExceptionOnPipelineCreation() {
        SearchResponseSections sections = new SearchResponseSections(
            .postPipeline()
        });
        assertEquals("pipeline [p*] is missing", e.getMessage());
        });
            null,
            null,
        );
            () -> SearchPipelineService.innerDelete(deleteRequest, finalClusterState)
        SearchHit[] hits = new SearchHit[size];
        Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phaseInjectorProcessorFactories = searchPipelineService
                "p2",
        Map<String, Object> requestProcessorConfig = new HashMap<>();
        List<Map<String, Object>> processorsAfter = (List<Map<String, Object>>) sourceAfter.get(Pipeline.REQUEST_PROCESSORS_KEY);
        assertEquals("scale_request_size", executionDetails.get(0).getProcessorName());
            Map.of(
        assertNull("null config copies to null", SearchPipelineService.deepCopyConfig(null));
        SearchPipelineService searchPipelineService = createWithProcessors();
        assertNotSame(config.get("normalization"), copy.get("normalization"));
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        );
                    // pipeline succeed when ignore failure is true
            (pf, t, i, f, c, ctx) -> new FakeRequestProcessor("successful_request", "2", null, false, r -> {}),
        syncExecutePipeline(
    }
        assertEquals(expectedError, exception.getMessage());
            this.writableRegistry(),
            null,
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(
            buildBaseProcessors().request,
            response
                boolean ignoreFailure,
                Map<String, Object> config,
                    MediaTypeRegistry.JSON
        syncExecutePipeline(
import org.opensearch.common.settings.ClusterSettings;
        expectThrows(IllegalStateException.class, () -> searchPipelineService.validatePipeline(Collections.emptyMap(), putRequest));
                "p3",
                    "read_context",
        );
        );
                case "bad_response_pipeline":
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
            "successful_response",
                "p1",
        PipelinedRequest pipelinedRequest = syncTransformRequest(
        assertTrue(responseProcessorFactories.containsKey("bar"));
            .build();
            this.writableRegistry(),
        pipeline = searchPipelineService.getPipelines().get(id);
            "Cannot support more than one system generated SEARCH_REQUEST processor to be executed PRE_USER_DEFINED. Now we have [system_scale_request_size_pre,system_scale_request_size_pre].";
                    new BytesArray(
            new BytesArray(
        );
                        "{"
        // Delete all does not throw exception if no pipelines
            searchPipelineService.resolvePipeline(request.pipeline("bad_request_pipeline"), null, indexNameExpressionResolver),
                new PipelineConfiguration(
            searchPipelineService.resolvePipeline(request.pipeline("bad_response_pipeline"), null, indexNameExpressionResolver),
                "bad_response_pipeline",
                    assertPipelineStats(detailStats.requestProcessorStats().get(0).getStats(), 1, 1);
import static org.mockito.Mockito.when;
        }
            () -> syncTransformRequest(searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver))
        );
        assertTrue(e.getMessage(), e.getMessage().contains(" not defined"));
            @Override
import java.util.List;
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().size(100).searchPipelineSource(pipelineSourceMap);
        );
                    assertEquals("successful_request:2", detailStats.requestProcessorStats().get(0).getProcessorName());
                    assertPipelineStats(perPipelineStats.getResponseStats(), 0, 0);
        public FakeStatefulResponseProcessor(String type, Consumer<PipelineProcessingContext> stateConsumer) {
        );
            Map.of(
import org.opensearch.cluster.service.ClusterService;
    }
            .postPipeline()
            response
        assertEquals(0, pipeline.pipeline.getSearchResponseProcessors().size());
    }
        // Caught Exception thrown when processing the request and produced warn level logging message
        // Success
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        Map<String, Object> scaleProcessorAfter = (Map<String, Object>) processorsAfter.get(0).get("scale_request_size");
            requestProcessorsEnableIgnoreFailure,
        assertTrue(requestProcessorFactories.containsKey("foo"));
        SearchPipelineService searchPipelineService = getSearchPipelineService(
            responseProcessorsEnableIgnoreFailure
            Map.of(
            );
import org.opensearch.common.xcontent.XContentType;
            (pf, t, i, f, c, ctx) -> throwingRequestProcessor
                    "p1",
            .build();
        SearchPipelineService service = createWithProcessors();
            requestProcessorFactories,
     * first; otherwise consumers that read the inline pipeline definition later in the request lifecycle (e.g. during
import org.opensearch.search.SearchHit;
        enabledAllSystemGeneratedFactories(service);
                    assertPipelineStats(detailStats.requestProcessorStats().get(0).getStats(), 1, 0);
        );
        );
        PipelinedRequest pipelinedRequest = syncTransformRequest(service.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
            Collections.emptyMap(),
        SearchPipelineService service = createWithSystemGeneratedProcessors();
                    assertPipelineStats(perPipelineStats.getResponseStats(), 1, 1);
        }
                    assertPipelineStats(perPipelineStats.getResponseStats(), 0, 0);
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
    /**
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
            .put(indexBuilder("foobar", defaultPipelineSetting1).putAlias(AliasMetadata.builder("bar")))
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
import org.opensearch.plugins.SearchPipelinePlugin;
        SearchResponse searchResponse = new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        assertNotNull(searchPipelineService.getPipelines().get("p1"));
        assertEquals("p1", pipelinedRequest.getPipeline().getId());
        );
                new PipelineConfiguration(
        // Verify that pipeline transforms request
        SearchRequest searchRequest = new SearchRequest("xyz").source(SearchSourceBuilder.searchSource().size(5));
        ClusterState previousState = clusterState;
        Map<String, Object> config = new LinkedHashMap<>();
            this.stateConsumer = stateConsumer;
                "{"
        }
            public SearchRequestProcessor create(
        SearchPipelineService service = createWithProcessors(
        // set a large size to not meet the condition to generate the system generated request processor
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        PipelinedRequest pipelinedRequest = syncTransformRequest(service.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
                    assertEquals(1, detailStats.responseProcessorStats().size());
            .getSearchResponseProcessors()
            .build();
                    assertEquals("throwing_response:3", detailStats.responseProcessorStats().get(0).getProcessorName());
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().size(100).searchPipelineSource(pipelineSourceMap);
                    assertPipelineStats(perPipelineStats.getResponseStats(), 0, 0);
            .build();
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(Pipeline.class))) {
        }
            requestProcessorsEnableIgnoreFailure,
import java.util.ArrayList;
        // verify the system generated request processor is not generated
        service.resolvePipeline(searchRequest, parentTask, indexNameExpressionResolver);
        );
    }
                this.xContentRegistry(),
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
            null,
        request.source(createDefaultSearchSourceBuilder());
        assertTrue(systemGeneratedResponseProcessorPost instanceof FakeSystemGeneratedResponsePostProcessor);
                    Level.WARN,
        List<ProcessorExecutionDetail> executionDetails = transformedResponse.getInternalResponse().getProcessorResult();
            "Should not systematically generate the search request processor",
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
                    assertPipelineStats(perPipelineStats.getRequestStats(), 0, 0);
    public void testInlineDefinedPipeline() throws Exception {
        try {
        PipelinedRequest pipelinedRequest = syncTransformRequest(service.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
            return Map.of("bar", (factories, tag, description, ignoreFailure, config, ctx) -> null);
            buildBaseProcessors().response,
            IllegalArgumentException.class,
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 1 } } ] }"),
            Collections.emptyMap(),
                    assertPipelineStats(perPipelineStats.getRequestStats(), 1, 0);
            "throwing_response",
            "successful_request",
                    assertEquals("successful_response:4", detailStats.responseProcessorStats().get(0).getProcessorName());
    protected NamedWriteableRegistry writableRegistry() {
                    assertEquals(0, detailStats.requestProcessorStats().size());
import java.util.Comparator;
    @Override
        // system generated pipelines are resolved
            .getFirst();
                    assertEquals(0, detailStats.requestProcessorStats().size());
        assertEquals(1, executionDetails.size());
        Map<String, Processor.Factory<SearchRequestProcessor>> throwingRequestProcessorFactory = Map.of(
        String longId = "a".repeat(512) + "a";
            }
            syncTransformResponse(pipelinedRequest, response);
     * coordinator query rewrite) would see an emptied map.
            responseProcessorsEnableIgnoreFailure,
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                case "good_response_pipeline":
            .getSearchRequestProcessors()
        );
        when(threadPool.generic()).thenReturn(executorService);
                )
        requestProcessorObject.put("scale_request_size", requestProcessorConfig);
                    MediaTypeRegistry.JSON
        Map<String, Object> copiedInner = (Map<String, Object>) copy.get("normalization");
        assertEquals(2, scaleProcessorAfter.get("scale"));
        assertNotNull(pipeline);
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(Pipeline.class))) {
            mockAppender.addExpectation(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            .build();
        enabledAllSystemGeneratedFactories(service);
    public void testValidatePipeline() throws Exception {
                    "test1",
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
            )
                threadPool,
        // Caught Exception here
     * construction reads the config by removing keys (ConfigurationUtils.readXxx), so the resolver copies the config
        assertEquals("pipeline [_id] is missing", e.getMessage());
            List.of()
            ) {
     * must not affect the original inline source. The null-config guard is not reachable from the XContent-parsed
        // when ignoreFailure enabled, the search pipelines will all succeed.
        SearchPipelineService searchPipelineService = createWithProcessors();
            (pf, t, i, f, c, ctx) -> throwingResponseProcessor
                    Level.WARN,
        assertEquals("_none", pipelinedRequest.getPipeline().getId());
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorFactories = Map.of(processorType, (pf, t, d, i, c, ctx) -> {
    }
        SearchRequest request = new SearchRequest();
        when(clusterService.getClusterSettings()).thenReturn(
            new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), 0.0f),
                )
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, searchPipelineMetadata).build())
        enabledAllSystemGeneratedFactories(service);
            null,
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));
        // Caught Exception thrown when processing response and produced warn level logging message
                    assertEquals(1, detailStats.responseProcessorStats().size());
        // Verify that pipeline transforms request
    public void testExtraParameterInProcessorConfig() {
                    Level.WARN,
        expectThrows(SearchPipelineProcessingException.class, () -> syncTransformResponse(pipelinedRequest, response));
        AtomicReference<String> capturedParentAction = new AtomicReference<>();
            Collections.emptyMap(),
        // Max length of pipeline length
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().size(100).searchPipelineSource(pipelineSourceMap);
            throw new RuntimeException();
    }
            "throwing_response",
            )
        PutSearchPipelineRequest badPutRequest = new PutSearchPipelineRequest(
            public boolean shouldGenerate(ProcessorGenerationContext context) {
        SearchRequest searchRequest = new SearchRequest().source(SearchSourceBuilder.searchSource().size(5));
    public void testResolveSystemGeneratedSearchPipeline_whenNotMeetCondition_thenNoGeneration() throws Exception {
        pipelines = SearchPipelineService.innerGetPipelines(metadata, "p*");
        SearchPipelineService.PipelineHolder pipeline = searchPipelineService.getPipelines().get(id);
            throws Exception {
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(
        assertTrue(e.getMessage(), e.getMessage().contains(" already registered"));
        final ClusterState finalClusterState = clusterState;
                    assertEquals("successful_response", detailStats.responseProcessorStats().get(0).getProcessorType());
            List.of(),
        SearchPipelineService searchPipelineService = createWithProcessors();
        assertEquals(0, searchPipelineService.getPipelines().size());
            clusterService,
                    MediaTypeRegistry.JSON
                Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
        );
                (pf, t, d, igf, cfg, ctx) -> new FakeStatefulResponseProcessor(
                    new BytesArray("{\"request_processors\" : [ { \"throwing_request\": {} } ] }"),
                    assertEquals(0, detailStats.responseProcessorStats().size());
        }
        ClusterState previousState = clusterState;
            () -> new SearchPipelineService(
        DeleteSearchPipelineRequest deleteAllRequest = new DeleteSearchPipelineRequest("*");
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);
        SearchPipelineService service = createWithSystemGeneratedProcessors();
            MediaTypeRegistry.JSON
            ResourceNotFoundException.class,
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
        Map<String, Object> requestProcessorConfig = new HashMap<>();
        when(parentTask.getAction()).thenReturn("indices:data/read/msearch");
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().size(100).searchPipelineSource(pipelineSourceMap);
import java.util.concurrent.atomic.AtomicReference;
            () -> searchPipelineService.validatePipeline(Map.of(n1, completePipelineInfo, n2, completePipelineInfo), badPutRequest)
import org.opensearch.common.settings.Settings;
                    assertEquals("successful_request:2", detailStats.requestProcessorStats().get(0).getProcessorName());
                (pf, t, d, igf, cfg, ctx) -> new FakeStatefulRequestProcessor("write_context", (c) -> c.setAttribute("a", "b"))
            .put(indexBuilder("foo", defaultPipelineSetting1).putAlias(AliasMetadata.builder("bar")))
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessors = Map.of(
        SearchRequestProcessor systemGeneratedRequestProcessorPost = pipelinedRequest.getSystemGeneratedPipelineHolder()
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
            buildBaseProcessors().response,
            "p1",
                "bad_request_pipeline",
                ),
        clusterState = ClusterState.builder(clusterState)
            return new FakeRequestProcessor(processorType, t, d, i, r -> {});
    public void testResolveIndexDefaultPipeline() throws Exception {
                    "The exception from response processor [throwing_response] in the search pipeline [_ad_hoc_pipeline] was ignored"
                    assertPipelineStats(perPipelineStats.getRequestStats(), 1, 0);
            Map.of(
        assertTrue(info.containsProcessor(Pipeline.PHASE_PROCESSORS_KEY, "max_score"));
        expectThrows(
        assertEquals(id, pipeline.pipeline.getId());
            new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), 0.0f),
        assertEquals(5, pipelinedRequest.source().size());
                    assertEquals(0, detailStats.responseProcessorStats().size());
            "_id",
                    assertEquals("throwing_request:1", detailStats.requestProcessorStats().get(0).getProcessorName());
        assertTrue(
        });
 * SPDX-License-Identifier: Apache-2.0
        PipelinedRequest request = searchPipelineService.resolvePipeline(
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
            .prePipeline()
        // Discovery failed, no infos passed.
            response
    private static final SearchPipelinePlugin DUMMY_PLUGIN = new SearchPipelinePlugin() {
            return response;
        @Override
                "p1",
            buildBaseProcessors().phase,
        assertNotNull(executionDetails);
        // Delete missing pipeline
        //
            1,
        );
import java.util.Locale;
            longId,
        enabledAllSystemGeneratedFactories(service);
            this.type = type;
        );
                    + "\"request_processors\": [{ \"scale_request_size\": { \"scale\" : \"banana\" } }],"
            .getFirst();
    }
        );
            )
            throw new RuntimeException();
                    assertPipelineStats(detailStats.requestProcessorStats().get(0).getStats(), 1, 1);
        PipelinedRequest pipelinedRequest = syncTransformRequest(
                new PipelineConfiguration(
                "{"
            Map.of(
        requestProcessorConfig.put("scale", 2);
                    "p2",
    }
                    "failed to update search pipelines"
        Settings defaultPipelineSetting = Settings.builder()
        Map<String, Processor.Factory<SearchResponseProcessor>> throwingResponseProcessorFactory = Map.of(
        );
        ClusterState previousState = clusterState;
        assertEquals(2, executionDetails.size());
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
        AtomicReference<String> contextHolder = new AtomicReference<>();
public class SearchPipelineServiceTests extends SearchPipelineTestCase {
        SearchPipelineService searchPipelineService = createWithProcessors(
            throw new RuntimeException();
    }
                    assertPipelineStats(perPipelineStats.getResponseStats(), 1, 0);
        assertEquals(0, pipeline.pipeline.getSearchPhaseResultsProcessors().size());
            buildBaseProcessors().phase,
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
            }
            mockAppender.addExpectation(
                    assertEquals(0, detailStats.requestProcessorStats().size());
                new PipelineConfiguration(
import org.opensearch.search.builder.SearchSourceBuilder;
                    "p2",
        for (SearchPipelineStats.PerPipelineStats perPipelineStats : stats.getPipelineStats()) {
        searchPipelineService.validatePipeline(Map.of(n1, completePipelineInfo, n2, completePipelineInfo), putRequest);
        // verify no system generated processors
            Collections.emptyMap()
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(requestProcessorObject));
        service.applyClusterState(cce);
    }
    }
                            + "\"request_processors\": [{ \"scale_request_size\": { \"scale\" : 2 } }],"
            fail("Wrong exception type: " + e.getClass());
            )
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
        SearchPipelineService searchPipelineService = createWithProcessors();
        );
import org.opensearch.search.SearchHits;
                new PipelineConfiguration(
                new PipelineConfiguration("q1", definition, MediaTypeRegistry.JSON)
        assertEquals("fixed_score", executionDetails.get(0).getProcessorName());
        setUpForResolvePipeline(service);
        );
                    assertEquals("throwing_response:3", detailStats.responseProcessorStats().get(0).getProcessorName());
        assertEquals("_none", pipelinedRequest.getPipeline().getId());
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        SearchHits searchHits = new SearchHits(hits, new TotalHits(size * 2, TotalHits.Relation.EQUAL_TO), size);
            null,
                boolean ignoreFailure,
        String processorType = "ad_hoc_rejecting";
    public void testInlinePipeline() throws Exception {
        assertEquals("scale_request_size", executionDetails.get(0).getProcessorName());
        IndexMetadata indexMetadata = new IndexMetadata.Builder("my_index").settings(defaultPipelineSetting).build();
                    MediaTypeRegistry.JSON
        Map<String, Object> pipelineSourceMap = new HashMap<>();
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
import java.util.function.Consumer;
        IllegalArgumentException e = expectThrows(
        SearchRequest searchRequest = new SearchRequest("bar").source(SearchSourceBuilder.searchSource().size(5));
        SearchPipelineService searchPipelineService = createWithProcessors();
        );
        // Delete all pipelines starting with "p"
                null,
            requestProcessors,
        assertNotNull(contextHolder.get());
        SearchRequestProcessor systemGeneratedRequestProcessorPre = pipelinedRequest.getSystemGeneratedPipelineHolder()
                    MediaTypeRegistry.JSON
            Map.of(
    public void testDefaultPipelineForMultipleIndices() throws Exception {
        enabledAllSystemGeneratedFactories(service);
        assertEquals(0, pipeline.pipeline.getSearchResponseProcessors().size());
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));
        );
                    break;
import org.opensearch.action.search.DeleteSearchPipelineRequest;
            null,
    public void testResolveSearchPipelineDoesNotExist() {
        assertEquals(0, searchPipelineService.getPipelines().size());
                searchPipelineService.resolvePipeline(request.pipeline("bad_request_pipeline"), null, indexNameExpressionResolver),
            threadPool,
        service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
    }
    public void testStatefulProcessors() throws Exception {
            MediaTypeRegistry.JSON
        SearchResponse response = createDefaultSearchResponse();
                )
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(Map.of("throwing_request", Collections.emptyMap())));
                this.writableRegistry(),
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
                    assertEquals(1, detailStats.requestProcessorStats().size());
        SearchResponseSections sections = new SearchResponseSections(searchHits, null, null, false, null, null, 1, List.of(), List.of());
        assertEquals("p1", pipelines.get(0).getId());
        );
        expectThrows(
            )
            throw new RuntimeException();
                )
        SearchPipelineService searchPipelineService = createWithProcessors(
            searchPipelineService.resolvePipeline(request.pipeline("good_response_pipeline"), null, indexNameExpressionResolver),
import org.opensearch.cluster.ClusterName;
        );
    /**
                Processor.PipelineContext pipelineContext
                    "response_only_pipeline",
        // Match prefix
            "throwing_request",
            .getSearchPhaseResultsProcessorFactories();
                    "test1",
        assertEquals(1, processorsAfter.size());
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(Map.of("throwing_request", Collections.emptyMap())));
        setUpForResolvePipeline(service);
        SearchPipelineService searchPipelineService = new SearchPipelineService(
        }
            (pf, t, i, f, c, ctx) -> new FakeResponseProcessor("successful_response", "4", null, true, r -> {}),
                throw new IllegalArgumentException(processorType + " cannot be created as part of a pipeline defined in a search request");
        systemGeneratedRequestProcessors.put("action_aware_processor", new SystemGeneratedProcessor.SystemGeneratedFactory<>() {
            .build();
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
                return null;
        previousClusterState = clusterState;
                    assertEquals("throwing_response", detailStats.responseProcessorStats().get(0).getProcessorType());
        );
        ClusterState updatedState = ClusterState.builder(initialState)
        SearchPipelineService.innerDelete(deleteAllRequest, clusterState);
        clusterState = SearchPipelineService.innerPut(putRequest, clusterState);
        syncExecutePipeline(
        ClusterState initialState = ClusterState.builder(new ClusterName("_name")).build();
        SearchPipelineService searchPipelineService = createWithProcessors();
                null,
        assertNotNull(searchPipelineService.getPipelines().get("q1"));
        AtomicReference<String> capturedParentAction = new AtomicReference<>("sentinel");
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().searchPipelineSource(pipelineSourceMap);
        Metadata.Builder mdBuilder = Metadata.builder()
        );
        assertNull(pipeline.pipeline.getDescription());
        assertTrue(phaseInjectorProcessorFactories.containsKey("zoe"));
            this.type = type;
        }
        ClusterState previousState = clusterState;
        assertTrue(systemGeneratedResponseProcessorPre instanceof FakeSystemGeneratedResponsePreProcessor);
    }
     */
                    assertEquals(1, detailStats.requestProcessorStats().size());
    public void testInvalidIndexResolveIndexDefaultPipeline() throws Exception {
        Map<String, Object> responseProcessorConfig = new HashMap<>();
        final SearchRequest searchRequest = new SearchRequest("_index").pipeline("bar");
        syncExecutePipeline(
            switch (perPipelineStats.getPipelineId()) {
    public void testResolveSystemGeneratedSearchPipeline_whenMoreThanOneProcessorPerStage_thenException() throws Exception {
        // set a large size to not meet the condition to generate the system generated request processor
            IllegalArgumentException.class,
        SearchPipelineInfo incompletePipelineInfo = new SearchPipelineInfo(Map.of(Pipeline.REQUEST_PROCESSORS_KEY, List.of(reqProcessor)));
        assertEquals("p3", pipelines.get(2).getId());
        assertPipelineStats(stats.getTotalResponseStats(), 2, 0);
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        // Bypass the default pipeline
        List<ProcessorExecutionDetail> executionDetails = transformedResponse.getInternalResponse().getProcessorResult();
            null,
    }
        assertNotNull(searchPipelineService.getPipelines().get("p2"));
import org.opensearch.ResourceNotFoundException;
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        // Delete all removes remaining pipeline
        } catch (SearchPipelineProcessingException e) {
        SearchPipelineStats stats = searchPipelineService.stats();
                    assertEquals("throwing_response", detailStats.responseProcessorStats().get(0).getProcessorType());
}
            null,
    }
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
    }
        assertEquals(3, pipelines.size());
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
                    new BytesArray("{\"response_processors\" : [ { \"throwing_response\": {} } ] }"),
        Map<String, Object> pipelineSourceMap = new HashMap<>();
            null,
                Pipeline.REQUEST_PROCESSORS_KEY,
            response
        SearchRequest searchRequest = new SearchRequest().source(sourceBuilder);
     */
    }
                capturedParentAction.set(context.parentAction());
                new PipelineConfiguration(
        clusterState = ClusterState.builder(clusterState)
                    assertEquals(0, detailStats.responseProcessorStats().size());
        SearchPipelineService service = createWithProcessors();
        public FakeStatefulRequestProcessor(String type, Consumer<PipelineProcessingContext> stateConsumer) {
                    "p1",
        assertEquals("p3", pipelines.get(2).getId());
            @Override
        assertEquals("_none", pipelinedRequest.getPipeline().getId());
            .put(indexBuilder("foofoo", defaultPipelineSetting).putAlias(AliasMetadata.builder("bar")));
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5));
            }
                    assertPipelineStats(detailStats.responseProcessorStats().get(0).getStats(), 1, 0);
        );
        searchRequest.pipeline(searchRequest.source().pipeline());
        SearchResponse response = createDefaultSearchResponse();
    }
                    Pipeline.class.getCanonicalName(),
        );
            1,
    }
        );
            searchPipelineService.resolvePipeline(request.pipeline("good_request_pipeline"), null, indexNameExpressionResolver),
 * this file be licensed under the Apache-2.0 license or a
        DiscoveryNode n2 = new DiscoveryNode("n2", buildNewFakeTransportAddress(), Version.CURRENT);
            .put(indexBuilder("foobar", defaultPipelineSetting).putAlias(AliasMetadata.builder("bar")))
        assertEquals("p1", pipelines.get(0).getId());
            IllegalArgumentException.class,
        service.getClusterService()
    public void testIsSystemGeneratedFactoryEnabled_whenAllEnabled_thenTrue() throws Exception {
            .getFirst();
        SearchPipelineService service = createWithSystemGeneratedProcessors();
        // Delete pipeline:
        searchRequest.source(SearchSourceBuilder.searchSource().verbosePipeline(true));
        // One node is missing a processor
        });
        assertPipelineStats(stats.getTotalResponseStats(), 2, 1);
        setUpForResolvePipeline(service);
                    assertPipelineStats(perPipelineStats.getRequestStats(), 0, 0);
import static org.mockito.ArgumentMatchers.anyString;
        clusterState = ClusterState.builder(clusterState)
        // Get both pipelines explicitly
            "successful_response",
                    + "}"
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessorFactories = searchPipelineService
        String id = "_id";
        assertEquals("p1", pipelinedRequest.getPipeline().getId());
        searchPipelineService.applyClusterState(new ClusterChangedEvent("clusterStateUpdated", updatedState, initialState));
        SearchPipelineService searchPipelineService = getSearchPipelineService(requestProcessors, responseProcessors);
                new PipelineConfiguration(
        SearchResponse searchResponse = new SearchResponse(sections, null, 0, 0, 0, 0, null, null);
        Settings defaultPipelineSetting = Settings.builder()
        assertEquals(SearchPipelineService.AD_HOC_PIPELINE_ID, pipelinedRequest.getPipeline().getId());
        SearchPipelineMetadata searchPipelineMetadata = new SearchPipelineMetadata(Map.of("_id", config));
            public boolean shouldGenerate(ProcessorGenerationContext context) {
                Pipeline.PHASE_PROCESSORS_KEY,
        assertTrue(service.isSystemGeneratedFactoryEnabled("dummy_factory"));
                new MockLogAppender.SeenEventExpectation(
        ClusterState previousState = clusterState;
            .put(indexBuilder("foofoo", defaultPipelineSetting2).putAlias(AliasMetadata.builder("bar")));
            SearchPipelineProcessingException.class,
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        pipelines = SearchPipelineService.innerGetPipelines(metadata, "p1");
        inner.put("weights", new ArrayList<>(List.of(0.3, 0.7)));   // List branch
        Settings defaultPipelineSetting = Settings.builder()
        pipelines = SearchPipelineService.innerGetPipelines(metadata, "p1", "p2");
    public void testStats() throws Exception {
                    new BytesArray("{\"response_processors\" : [ { \"fixed_score\": { \"score\" : 2 } } ] }"),
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
        ClusterService clusterService = mock(ClusterService.class);
    public void testExceptionOnResponseProcessing() throws Exception {
import org.apache.logging.log4j.Level;
            MediaTypeRegistry.JSON
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(Map.of("bad_factory", Collections.emptyMap())));
        requestProcessors.put("scale_request_size", new ScaleRequestSizeFactory());
import org.junit.Before;
import org.opensearch.search.SearchModule;
    public void testAdHocRejectingProcessor() {
            .getClusterSettings()
        clusterState = SearchPipelineService.innerDelete(deleteRequest, clusterState);
        SearchPipelineService service = createWithProcessors(
import java.util.LinkedHashMap;
        assertEquals(0, pipeline.pipeline.getSearchRequestProcessors().size());
            .build();
        // Mutating the copy must leave the original intact — the whole reason resolvePipeline copies the config.
            )
        org.opensearch.tasks.Task parentTask = mock(org.opensearch.tasks.Task.class);
    }
        }
            buildBaseProcessors().request,
                    "p1",
        pipelineSourceMap.put(Pipeline.RESPONSE_PROCESSORS_KEY, List.of(Map.of("fixed_score", processorConfig)));
        Metadata.Builder mdBuilder = Metadata.builder()
        assertEquals(1, pipeline.getSearchRequestProcessors().size());
                    "bad_response_pipeline",
            )
        SearchPipelineService searchPipelineService = createWithProcessors();
        SearchRequestProcessor throwingRequestProcessor = new FakeRequestProcessor("throwing_request", null, null, true, r -> {
            .getResponseProcessorFactories();
        assertEquals(config, copy);
            return Map.of("zoe", (factories, tag, description, ignoreFailure, config, ctx) -> null);
            )
        assertNull(contextHolder.get());
        } catch (Exception e) {
        );
            .prePipeline()
            new SearchRequest().source(createDefaultSearchSourceBuilder()).pipeline("p1"),
                new PipelineConfiguration(
                    ),
        expectThrows(
                    break;
            Collections.emptyMap()
        );
        ClusterState previousClusterState = clusterState;
        PutSearchPipelineRequest maxLengthIdPutRequest = new PutSearchPipelineRequest(
            .postPipeline()
            return type;
    public void testResolveSystemGeneratedSearchPipeline_whenHappyCase_thenSuccess() throws Exception {
        assertEquals(1, responseProcessorFactories.size());
import org.opensearch.Version;
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
        assertEquals(1, searchPipelineService.getPipelines().size());
        clusterState = ClusterState.builder(clusterState)
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorFactories = searchPipelineService
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        List<ProcessorExecutionDetail> executionDetails = transformedResponse.getInternalResponse().getProcessorResult();
                new PipelineConfiguration(
                    // processor stats got 1 count and 1 failed
            throwingRequestProcessorFactory,
    public void testPutPipeline() {
            @Override
        }
        });
            );
    }
            SearchPipelineProcessingException.class,
                    MediaTypeRegistry.JSON
        when(threadPool.executor(anyString())).thenReturn(executorService);
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
                    break;
    }
            .build();
     * Directly covers {@link SearchPipelineService#deepCopyConfig} across every value branch produced by the XContent
        Client client = mock(Client.class);
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
        clusterState = ClusterState.builder(clusterState).metadata(mdBuilder.putCustom(SearchPipelineMetadata.TYPE, metadata)).build();
        SearchPipelineService service = createWithSystemGeneratedProcessors();
            MediaTypeRegistry.JSON
        // Prefix wildcard fails if no matches
    }
        SearchResponse searchResponse = new SearchResponse(sections, null, 0, 0, 0, 0, null, null);
                )
            searchPipelineService.getPipelines().get("_id").pipeline.getSearchRequestProcessors().get(0).getType()
            () -> searchPipelineService.validatePipeline(Map.of(n1, completePipelineInfo, n2, incompletePipelineInfo), putRequest)
        String errorMessage = String.format(
            systemGeneratedRequestProcessors,
            IllegalArgumentException.class,
    public void testGetPipelines() {
    public void testDeletePipeline() {
            Collections.emptyMap()
            "throwing_request",
        );
        // Match all
    ) {
            MediaTypeRegistry.JSON
            .getSearchResponseProcessors()
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    "p3",
        private final Consumer<PipelineProcessingContext> stateConsumer;
            .build();
        SearchPipelineInfo completePipelineInfo = new SearchPipelineInfo(
        Map<String, Object> pipelineSourceMap = new HashMap<>();
            stateConsumer.accept(requestContext);
        @Override
            throw new RuntimeException();
        return new NamedWriteableRegistry(searchModule.getNamedWriteables());
                    assertPipelineStats(perPipelineStats.getResponseStats(), 1, 0);
            false,
            null,
    public void testInfo() {
                case "bad_request_pipeline":
                client
        IndexMetadata indexMetadata = new IndexMetadata.Builder("my_index").settings(defaultPipelineSetting).build();
    }
                Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
                return false;
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        ClusterState previousState = clusterState;
        SearchPipelineService.PipelineHolder pipeline = searchPipelineService.getPipelines().get(id);
 */
     * Resolving an inline (ad hoc) pipeline must NOT drain the request's search pipeline source map. Pipeline
        public Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessors(Parameters parameters) {
                "p1",
        assertNotNull(pipeline);
            new BytesArray("{\"request_processors\":[" + " { \"" + processorType + "\": {}}" + "]}"),
        }
        pipelineSourceMap.put(Pipeline.RESPONSE_PROCESSORS_KEY, List.of(responseProcessorObject));
                    "bad_request_pipeline",
        });
        }
            SearchPipelineProcessingException.class,
        @Override
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            .pipeline("request_only_pipeline");
        assertEquals("empty pipeline", pipeline.pipeline.getDescription());
            (pf, t, i, f, c, ctx) -> throwingRequestProcessor
        // Verify pipeline
            null,
            pipelinedRequest.getSystemGeneratedPipelineHolder().isNoOp()
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
                new PipelineConfiguration("p1", definition, MediaTypeRegistry.JSON),
        assertNotNull("nested processor config must not be drained", scaleProcessorAfter);
            mockAppender.assertAllExpectationsMatched();
        // Exception thrown when processing response
    }
    private SearchResponse createDefaultSearchResponse() {
                String description,
        });
                "p2",
                    assertEquals("successful_request", detailStats.requestProcessorStats().get(0).getProcessorType());
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
                    "p1",
            ),
        inner.put("nullable", null);                                // null value via the scalar path
            Collections.emptyMap(),
    public void testExceptionOnRequestProcessing() {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        SearchPipelineStats stats = searchPipelineService.stats();
            .getFirst();
                    XContentType.JSON
        }
                "p2",
        Pipeline pipeline = pipelinedRequest.getPipeline();
import org.opensearch.common.metrics.OperationStats;
            List.of(),
            clusterService,
        SearchPipelineService service = createWithSystemGeneratedProcessors();
            List.of(DUMMY_PLUGIN),
            new BytesArray(
        ClusterState previousState = clusterState;
        assertEquals(1, searchPipelineService.getPipelines().get("_id").pipeline.getSearchPhaseResultsProcessors().size());
            fail("Exception should have been thrown");
        SearchPipelineService searchPipelineService = createWithProcessors();
     * {@code resolvePipeline} path (the source map is non-null there), so it is exercised here rather than through a
        expectThrows(
                response
        assertNull(pipeline);
        inner.put("technique", "min_max");                          // scalar (String) branch
                List.of(searchPhaseProcessor)
     * resolve.
            Collections.emptyMap(),
        IllegalArgumentException exception = assertThrows(
    public void testUpdatePipelines() {
            syncTransformRequest(searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
        Map<String, Object> inner = new LinkedHashMap<>();
            null,
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(SearchPipelineService.class))) {
        assertTrue(service.isSystemGeneratedFactoryEnabled("dummy_factory"));
        assertTrue(
        SearchResponse response = createDefaultSearchResponse();
            .prePipeline()
            ResourceNotFoundException.class,
            () -> service.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
        SearchPipelineService service = createWithProcessors();
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorsEnableIgnoreFailure,
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        Settings defaultPipelineSetting2 = Settings.builder()
        );
        SearchPipelineService searchPipelineService = createWithProcessors();
                    "p1",
        enabledAllSystemGeneratedFactories(service);
            .metadata(Metadata.builder().putCustom(SearchPipelineMetadata.TYPE, metadata))
        assertEquals("p1", pipelinedRequest.getPipeline().getId());
            SearchPipelineProcessingException.class,
            List.of(DUMMY_PLUGIN),
            null,
                )
                    assertPipelineStats(detailStats.responseProcessorStats().get(0).getStats(), 1, 1);
import org.opensearch.threadpool.ThreadPool;
        Map<String, Object> copy = SearchPipelineService.deepCopyConfig(config);
import static org.opensearch.search.pipeline.SearchPipelineService.ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING;
import static org.mockito.Mockito.mock;
        assertNotNull(sourceAfter);
        );
            new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : \"foo\" } } ] }"),
                )
            );
    public void testInlinePipelineSourceIsNotDrainedAfterResolve() throws Exception {
        @Override
            searchPipelineService.getPipelines().get("_id").pipeline.getSearchPhaseResultsProcessors().get(0).getType()
        SearchResponseSections sections = new SearchResponseSections(
            longId
        assertEquals(0, pipeline.pipeline.getSearchRequestProcessors().size());
            )
            "p1",
                    MediaTypeRegistry.JSON
        SearchRequestProcessor throwingRequestProcessor = new FakeRequestProcessor("throwing_request", "1", null, true, r -> {
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
                return false;
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);
            () -> syncExecutePipeline(
        SearchRequest searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(20));
                    assertEquals("successful_response", detailStats.responseProcessorStats().get(0).getProcessorType());
                    + "\"phase_results_processors\" : [ { \"max_score\" : { } } ]"
                List.of(rspProcessor),
            (pf, t, i, f, c, ctx) -> new FakeResponseProcessor("successful_response", "4", null, false, r -> {}),
            Map.of(
        public String getType() {
            .getSearchRequestProcessors()
        public Map<String, Processor.Factory<SearchRequestProcessor>> getRequestProcessors(Parameters parameters) {
        for (int i = 0; i < size; i++) {
            mockAppender.addExpectation(
            searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
        );
            "successful_request",
            return type;
                    assertPipelineStats(perPipelineStats.getResponseStats(), 0, 0);
            throwingResponseProcessorFactory,
                    MediaTypeRegistry.JSON
        assertEquals(1, pipelines.size());
                    assertPipelineStats(perPipelineStats.getRequestStats(), 1, 0);
            () -> searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
                case "bad_request_pipeline":
    }
            searchPipelineService.resolvePipeline(request.pipeline("good_response_pipeline"), null, indexNameExpressionResolver),
import org.opensearch.action.search.SearchResponseSections;
    public void testResolveSystemGeneratedSearchPipeline_whenDisableSystemGeneratedFactories_thenNoGeneration() throws Exception {
    private SearchPipelineService getSearchPipelineService(
        );
    private static class FakeStatefulResponseProcessor extends AbstractProcessor implements StatefulSearchResponseProcessor {
        assertNull(pipeline);
        SearchRequest searchRequest = new SearchRequest().source(SearchSourceBuilder.searchSource().size(10)).pipeline("verbose_pipeline");
import org.opensearch.cluster.metadata.AliasMetadata;
        SearchPipelineService searchPipelineService = createWithProcessors(
        assertEquals(1, searchPipelineService.getPipelines().get("_id").pipeline.getSearchRequestProcessors().size());
            () -> searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
    }
        systemGeneratedRequestProcessors.put("system_scale_request_size", new SystemGeneratedScaleRequestSizePreFactory());
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
                    MediaTypeRegistry.JSON
                Pipeline.RESPONSE_PROCESSORS_KEY,
                    // processor stats got 1 count and 1 failed
        ExecutorService executorService = OpenSearchExecutors.newDirectExecutorService();
    }
            null,
                    break;
                            + "\"response_processors\": [ { \"fixed_score\": { \"score\": 5.0 } } ]"
            Collections.emptyMap()
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
                    assertPipelineStats(detailStats.requestProcessorStats().get(0).getStats(), 1, 0);
    @SuppressWarnings("unchecked")
                    assertEquals(0, detailStats.requestProcessorStats().size());
        );
        );
        SearchResponseProcessor systemGeneratedResponseProcessorPre = pipelinedRequest.getSystemGeneratedPipelineHolder()
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p2")
                    "verbose_pipeline",
            Map.of(
        );
        assertEquals(10, pipelinedRequest.source().size());
            @Override
        SearchRequest searchRequest = new SearchRequest().source(SearchSourceBuilder.searchSource().size(10))
        Settings defaultPipelineSetting1 = Settings.builder()
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
            assertTrue(
                "request_only_pipeline",
        );
                new PipelineConfiguration(
        );
        assertPipelineStats(stats.getTotalRequestStats(), 2, 0);
        return new SearchResponse(sections, null, 0, 0, 0, 0, null, null);
            super(null, null, false);
                    assertPipelineStats(perPipelineStats.getResponseStats(), 1, 0);
            throwingRequestProcessorFactory,
        IllegalArgumentException e = expectThrows(
    public void testSearchPipelinePluginDuplicate() {
        for (int i = 0; i < size; i++) {
        SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource().searchPipelineSource(pipelineSourceMap);
                    assertEquals(1, detailStats.responseProcessorStats().size());
        Map<String, Processor.Factory<SearchRequestProcessor>> throwingRequestProcessorFactory = Map.of(
        );
                    assertEquals("throwing_request:1", detailStats.requestProcessorStats().get(0).getProcessorName());
    public void testVerbosePipelineExecution() throws Exception {
                new MockLogAppender.SeenEventExpectation(
        request.source(createDefaultSearchSourceBuilder());
        clusterState = SearchPipelineService.innerPut(putRequest, clusterState);
                    new BytesArray("{\"phase_results_processors\" : [ { \"max_score\" : { } } ]}"),
            Collections.emptyMap(),
        }
    public void testCatchExceptionOnRequestProcessing() throws Exception {
        int size = 10;
        );
        SearchPipelineService searchPipelineService = createWithProcessors();
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
            Collections.emptyMap(),
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessorsEnableIgnoreFailure
                    assertEquals(0, detailStats.responseProcessorStats().size());
            searchPipelineService.getPipelines().get("_id").pipeline.getSearchResponseProcessors().get(0).getType()
        ClusterState previousState = clusterState;
        Map<String, Processor.Factory<SearchResponseProcessor>> throwingResponseProcessorFactory = Map.of(
import org.opensearch.test.MockLogAppender;
        // Verify pipeline
            stateConsumer.accept(requestContext);
import org.opensearch.index.IndexSettings;
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                .get(perPipelineStats.getPipelineId());
        SearchPipelineService searchPipelineService = new SearchPipelineService(
                    "p1",
import org.opensearch.cluster.metadata.IndexMetadata;
        });
                case "good_response_pipeline":
        clusterState = ClusterState.builder(clusterState).metadata(mdBuilder.putCustom(SearchPipelineMetadata.TYPE, metadata)).build();
            .metadata(Metadata.builder().put(indexMetadata, false).putCustom(SearchPipelineMetadata.TYPE, metadata))
                new PipelineConfiguration(
     * parser (nested map, list, scalar, null value) and asserts the copy is deep and independent: mutating the copy
            () -> searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
            .getSearchPhaseResultsProcessors()
                    "request_only_pipeline",
    }
        SearchResponse transformedResponse = syncTransformResponse(pipelinedRequest, searchResponse);
                    "The exception from request processor [throwing_request] in the search pipeline [_ad_hoc_pipeline] was ignored"
                case "bad_response_pipeline":
        );
        );
                    + "\"request_processors\": [{ \"scale_request_size\": { \"scale\" : 2 } }],"
        for (SearchPipelineStats.PerPipelineStats perPipelineStats : stats.getPipelineStats()) {
        int size = 10;
        }
            Collections.emptyMap()
        assertEquals("p1", pipeline.getId());
    }
        PipelinedRequest pipelinedRequest = service.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
    }
        SearchRequestProcessor throwingRequestProcessor = new FakeRequestProcessor("throwing_request", "1", null, false, r -> {
                )
        assertTrue(info.containsProcessor(Pipeline.REQUEST_PROCESSORS_KEY, "scale_request_size"));
            1,
        assertEquals("p2", pipelines.get(1).getId());
        );
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        service.applyClusterState(cce);
        );
            (pf, t, i, f, c, ctx) -> throwingResponseProcessor
        // ...but distinct container instances at every level (a deep copy, not shared references).
        );
            .applySettings(Settings.builder().putList(ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING.getKey(), "dummy_factory").build());
    private static class FakeStatefulRequestProcessor extends AbstractProcessor implements StatefulSearchRequestProcessor {
    }
            assertEquals(2.0, transformedResponse.getHits().getHits()[i].getScore(), 0.0001);
        assertEquals(5, pipelinedRequest.source().size());
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
        searchRequest = new SearchRequest("my_index").source(SearchSourceBuilder.searchSource().size(5)).pipeline("_none");
            .build();
    }
        assertEquals("indices:data/read/msearch", capturedParentAction.get());
        assertNotNull(searchPipelineService.getPipelines().get("q1"));
        config.put("normalization", inner);                         // Map branch (recursion)
                searchPipelineService.resolvePipeline(request.pipeline("bad_response_pipeline"), null, indexNameExpressionResolver),
        );
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorsEnableIgnoreFailure = Map.of(
                    new BytesArray("{" + "\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ]" + "}"),
    public void testDifferentDefaultPipelineForMultipleIndices() throws Exception {
            Map.of(
        SearchPipelineService searchPipelineService = createWithProcessors();
        assertEquals(errorMessage, e.getMessage());
        putRequest = new PutSearchPipelineRequest(id, new BytesArray("{ \"description\": \"empty pipeline\"}"), MediaTypeRegistry.JSON);
        Map<String, Object> requestProcessorObject = new HashMap<>();
        pipelineSourceMap.put(Pipeline.RESPONSE_PROCESSORS_KEY, List.of(Map.of("throwing_response", new HashMap<>())));
        assertEquals(2, pipelines.size());
            ) {
        expectThrows(
                    assertPipelineStats(detailStats.responseProcessorStats().get(0).getStats(), 1, 0);
            )
    }
        assertNotSame(config, copy);
        assertEquals(3, pipelines.size());
    public void testPutInvalidPipeline() throws IllegalAccessException {
            searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver)
        assertEquals("_none", pipelinedRequest.getPipeline().getId());
        searchRequest = new SearchRequest("bar").source(SearchSourceBuilder.searchSource().size(5)).pipeline("_none");
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
            "Should not systematically generate the search processors",
                )
        });
        assertEquals(
        private final Consumer<PipelineProcessingContext> stateConsumer;
        assertEquals(1, searchPipelineService.getPipelines().size());
        SearchRequest request = new SearchRequest();
        requestProcessorConfig.put("scale", 2);
import org.opensearch.transport.client.Client;
                mock(ClusterService.class),
        // ...but the request's original inline source survives intact for later readers (not drained by the read).
            "_id",
        PipelinedRequest pipelinedRequest = syncTransformRequest(
        PipelineConfiguration pipeline = new PipelineConfiguration(
        assertEquals(id, pipeline.pipeline.getId());
        // Get specific pipeline
    private ThreadPool threadPool;
            ),
        assertEquals(1, executionDetails.size());
                    assertEquals("throwing_request", detailStats.requestProcessorStats().get(0).getProcessorType());
        Client client = mock(Client.class);
    }
        }
        );
    }
                new PipelineConfiguration(
            (pf, t, i, f, c, ctx) -> new FakeRequestProcessor("successful_request", "2", null, true, r -> {}),
            client
            pipelinedRequest.getSystemGeneratedPipelineHolder().prePipeline().getSearchRequestProcessors().isEmpty()
            (pf, t, i, f, c, ctx) -> throwingRequestProcessor
 * compatible open source license.
        SearchPhaseResultsProcessor systemGeneratedPhaseProcessorPre = pipelinedRequest.getSystemGeneratedPipelineHolder()
        SearchHits searchHits = new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), 0.0f);
                )
        PipelinedRequest pipelinedRequest = syncTransformRequest(service.resolvePipeline(searchRequest, null, indexNameExpressionResolver));
        responseProcessorObject.put("fixed_score", responseProcessorConfig);
            "throwing_response",
            assertEquals(2.0, transformedResponse.getHits().getHits()[i].getScore(), 0.0001);
            id,
                    ),
            MediaTypeRegistry.JSON
import org.opensearch.core.common.bytes.BytesArray;
        PipelinedRequest pipelinedRequest = searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
            );
        }
            new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : \"foo\" } } ] }"),
        for (int i = 0; i < size; i++) {
        SearchResponseProcessor throwingResponseProcessor = new FakeResponseProcessor("throwing_response", "3", null, false, r -> {
    }
        Map<String, Object> pipelineSourceMap = new HashMap<>();
                )
        private final String type;
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
    }
        ClusterState initialState = ClusterState.builder(new ClusterName("_name")).build();
        );
            Map.of(
        public SearchRequest processRequest(SearchRequest request, PipelineProcessingContext requestContext) throws Exception {
        );
            .getSearchPhaseResultsProcessors()
                new PipelineConfiguration(
                    MediaTypeRegistry.JSON
        ClusterChangedEvent cce = new ClusterChangedEvent("", clusterState, previousState);
    public void testCatchExceptionOnResponseProcessing() throws Exception {
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
    }
            throw new RuntimeException();
                    MediaTypeRegistry.JSON
            new HashMap<>();
        @Override
        );
                Processor.PipelineContext pipelineContext
        service.applyClusterState(cce);
        ClusterService clusterService = mock(ClusterService.class);
            "Search Pipeline id [%s] exceeds maximum length of 512 UTF-8 bytes (actual: 513 bytes)",
        clusterState = ClusterState.builder(clusterState)
            null,
                    assertEquals("successful_request", detailStats.requestProcessorStats().get(0).getProcessorType());
        String id = "_id";
            () -> SearchPipelineService.innerDelete(deleteRequest, finalClusterState)
                    ),
            client
        searchPipelineService.applyClusterState(new ClusterChangedEvent("", clusterState, previousState));
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
            .build();
        assertEquals(1, pipelinedRequest.getPipeline().getSearchRequestProcessors().size());
    }
        assertEquals("p2", pipelines.get(1).getId());
    public void setup() throws Exception {
            List.of(),
                ),
        pipelineSourceMap.put(Pipeline.REQUEST_PROCESSORS_KEY, List.of(Map.of(processorType, Collections.emptyMap())));
        ((List<Object>) copiedInner.get("weights")).clear();
        Map<String, Object> requestProcessorObject = new HashMap<>();
            .build();
                    assertEquals(1, detailStats.requestProcessorStats().size());
                            + "\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ],"
            Collections.emptyMap(),
        clusterState = ClusterState.builder(clusterState)
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessors =
     * Tests a pipeline defined in the search request source.
