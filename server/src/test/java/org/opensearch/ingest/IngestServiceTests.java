            failureHandler,
        PutPipelineRequest putRequest = new PutPipelineRequest(
    public void testExecuteBulkRequestInBatchWithSystemPipeline() throws Exception {
            indexRequest.source(xContentType, "field1", "value1");
            .setPipeline("_id")
        bulkRequest.add(indexRequest1);
        final IndexRequest indexRequest = new IndexRequest("idx");
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
            .setPipeline("_id")
                    + "                    \"value\": \"failed\",\n"
        MockitoAnnotations.openMocks(this);
            Arrays.stream(XContentType.values()).filter(t -> Requests.INDEX_CONTENT_TYPE.equals(t) == false).collect(Collectors.toList())
        ingestService.executeBulkRequest(
        assertStats(initialStats.getTotalStats(), 0, 0, 0);
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        // invoke
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        final Map<Integer, Exception> failureHandler = new HashMap<>();
    }
import org.mockito.ArgumentMatcher;
        assertThat(ingestService.pipelines().size(), is(0));
                    + "                                \"field\": \"ingest_error1\",\n"
        @SuppressWarnings("unchecked")
        final ClusterState currentClusterState = ClusterState.builder(new ClusterName("_name")).metadata(currentMetadata).build();
        verify(failureHandler, never()).accept(any(), any());
 *
        assertTrue(indexRequest.isPipelineResolved());
        // verify
        assertNotNull(cache.getSystemIngestPipeline(index1.toString()));
        IngestService ingestService = createIngestServiceWithProcessors(
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
        bulkRequest.add(indexRequest2);
        assertNull(pipeline.getProcessors().get(0).getTag());
        when(processor.getProcessors()).thenReturn(Collections.singletonList(mock(Processor.class)));
        logger.info("Using [{}], not randomly determined default [{}]", xContentType, Requests.INDEX_CONTENT_TYPE);
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        ClusterState previousClusterState = clusterState;
            .source(emptyMap())
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        ingestService.executeBulkRequest(
            return Collections.singletonMap("foo", (factories, tag, description, config) -> null);
        // mock a default pipeline do change the target index of the first request
        previousClusterState = clusterState;
        @SuppressWarnings("unchecked")
            .source(emptyMap())
        assertThat(ingestService.pipelines().get("_id1").pipeline.getProcessors().size(), equalTo(0));
        Map<String, Processor.Factory> map = new HashMap<>(2);
    private static Processor.Factory mockSystemProcessorFactory;
        verify(cache, times(1)).getSystemIngestPipeline(eq(id));
        assertNull(cache.getSystemIngestPipeline(index2.toString()));
        processors.put(
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer) args.getArguments()[1];
                .build()
        // no pipeline:
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        assertThat(counter.get(), equalTo(2));
        assertEquals("[idx/uuid]", indexRequest.getSystemIngestPipeline());
        IngestService ingestService = createIngestServiceWithProcessors();
                    + "                              }\n"
            documents.get(0).getIngestDocument().setFieldValue("_index", "new_index");
            new BytesArray(
        // pipeline
    }
        clusterState = IngestService.innerDelete(deleteRequest, clusterState);
            MediaTypeRegistry.JSON
/*
            id,
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
            .setFinalPipeline("_none");
        DiscoveryNode node2 = new DiscoveryNode("_node_id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertThat(pipeline, nullValue());
                    + "    {\n"
            failureHandler,
            .execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());
        clusterState = IngestService.innerPut(putRequest, clusterState);
        assertPipelineStats(afterThirdRequestStats.getPipelineStats(), "_id2", 1, 0, 0);
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            emptyMap(),
    }
        result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
        BulkRequest bulkRequest = new BulkRequest();
    }
        );
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        assertEquals(id, indexRequest.getSystemIngestPipeline());
    private IndexRequestWrapper createIndexRequestWrapper(String index, List<IngestPipelineInfo> pipelineInfoList) {
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        Map<K, V> map = new HashMap<>();
            handler.accept(documents);
        assertEquals("Processor type [remove] is not installed on node [" + node2 + "]", e.getMessage());
            clusterState = previousState;
            mock(SystemIngestPipelineCache.class)
            indexMetadata2,
        verify(failureHandler, never()).accept(any(), any());
        @SuppressWarnings("unchecked")
        );
        final Processor processor = mock(Processor.class);
                    + "                    \"field\": \"ingest_error1\",\n"
        );
        Map<DiscoveryNode, IngestInfo> ingestInfos = new HashMap<>();
        assertTrue(dropHandler.isEmpty());
import java.util.stream.Collectors;
        PutPipelineRequest putRequest = new PutPipelineRequest(
        return pipelineStats.stream().filter(p1 -> p1.getPipelineId().equals(id)).findFirst().map(p2 -> p2.getStats()).orElse(null);
        IngestDocumentMatcher(String index, String type, String id, Long version, VersionType versionType, Map<String, Object> source) {
            .setPipeline("_none")
    public void testResolveSystemIngestPipeline_whenUseTemplateV2() throws Exception {
        final MetadataIndexTemplateService metadataIndexTemplateService = getInstanceFromNode(MetadataIndexTemplateService.class);
        createPipeline("_id", ingestService);
        when(clusterService.getClusterSettings()).thenReturn(
        PutPipelineRequest putRequest = new PutPipelineRequest(
    }
        @SuppressWarnings("unchecked")
            fail("exception expected");
            "dummy",
        createPipeline("_id", ingestService);
        bulkRequest.add(indexRequest2);
            @SuppressWarnings("unchecked")
            .setSystemIngestPipeline("_none");
            public Map<String, Processor.Factory> getProcessors(final Processor.Parameters parameters) {
                    + "              \"value\": \"failed\",\n"
        );
            failureHandler::put,
        assertThat(ingestService.getPipeline("_id"), notNullValue());
            new BytesArray(
        ClusterState previousClusterState = clusterState;
    }
        ClusterState state = ClusterState.EMPTY_STATE;
        assertThat(pipeline, nullValue());
            .setSystemIngestPipeline("_none");
        assertFalse(indexRequest1.isPipelineResolved());
            "_node_id",
        // add index metadata for the new index
            .source(emptyMap())
        PipelineConfiguration pipeline = new PipelineConfiguration(
        IndexMetadata.Builder builder = IndexMetadata.builder("idx")
        assertThat(updateRequest.upsertRequest().getPipeline(), equalTo("default-pipeline"));
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer) args.getArguments()[1];
            .source(emptyMap())
        // match all wildcard works on last remaining pipeline
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getPipeline());
        IndexRequestWrapper wrapper2 = createIndexRequestWrapper(
        bulkRequest.add(indexRequest2);
    private void assertStats(OperationStats stats, long count, long failed, long time) {
            String field = (String) config.remove("field");
        final IngestService ingestService = createIngestServiceWithProcessors();
        IndexMetadata indexMetadata = spy(
        );
        // Processor factory should be invoked secondly after ingest cluster state listener:
    }
 *
        ingestMetadata = new IngestMetadata(mapOf("_id1", pipeline1, "_id2", pipeline2));
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        configs.put("_id1", new PipelineConfiguration("_id1", new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON));
import org.opensearch.cluster.ClusterName;
            handler.accept(ingestDocument, null);
        when(indexMetadata1.getIndex()).thenReturn(index1);
        Metadata metadata = Metadata.builder().indices(Map.of("_index", indexMetadata)).build();
            "_id",
        // First time create the pipeline and cache it
        String id = "_id";
        assertThat(ingestService.pipelines().size(), is(2));
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            .setPipeline("_id")
        verify(systemIngestPipelineCache, times(1)).getSystemIngestPipeline(any());
            MediaTypeRegistry.JSON
            @SuppressWarnings("unchecked")
        IngestService ingestService = createIngestServiceWithProcessors(processors);
        IndexRequestWrapper wrapper1 = createIndexRequestWrapper(
import java.util.function.IntConsumer;
        IngestService ingestService = createIngestServiceWithProcessors(
        );
            .source(emptyMap())
            ),
        }).when(defaultProcessor).batchExecute(any(), any());
            IndexRequest indexRequest = new IndexRequest("idx").setPipeline("request-pipeline");
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getSystemIngestPipeline());
        );
        assertThat(pipeline.getProcessors().get(0).getType(), equalTo("set"));
            .setSystemIngestPipeline("_none");
            failure.set(true);
        // pipeline
        @SuppressWarnings("unchecked")
        );
        IngestService ingestService = createIngestServiceWithProcessors();
        IngestInfo ingestInfo = new IngestInfo(Collections.singletonList(new ProcessorInfo("set")));
            indexReq -> {},
            IngestService.innerDelete(new DeletePipelineRequest("unknown"), clusterState);
            .build();
        PutPipelineRequest putRequest = new PutPipelineRequest(pipeline, config, MediaTypeRegistry.JSON);
        assertThat(afterThirdRequestStats.getPipelineStats().size(), equalTo(2));
        final Processor.Factory systemProcessorFactory = mock(Processor.Factory.class);
import org.apache.logging.log4j.LogManager;
        assertThat(IngestService.getProcessorName(pipelineProcessor), equalTo(name + ":" + pipelineName));
 */
                .settings(settings(Version.CURRENT))
        Metadata metadata = Metadata.builder().indices(Map.of("idx", indexMetadata)).build();
                    + "                            {\n"
            IndexRequest indexRequest = TransportBulkAction.getIndexWriteRequest(docWriteRequest);
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
            Names.WRITE
        // request pipeline with final pipeline:
 * under the License.
        final Index index = new Index("idx", "uuid");
    }
        assertThat(indexRequest.routing(), equalTo("update_routing"));
            .setFinalPipeline("_none")
            .setPipeline("_none")
        IngestService ingestService = createIngestServiceWithProcessors(
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        {
        return clusterState;
            .source(emptyMap())
            return null;
        assertTrue(failureHandler.isEmpty());
        @SuppressWarnings("unchecked")
        return argThat(new IngestDocumentMatcher("_index", "_type", "_id", version, versionType, source));
        final IngestService ingestService = createIngestServiceWithProcessors();
import org.opensearch.common.metrics.OperationStats;
    public void testResolvePipelines_whenUseTemplateV2() throws Exception {
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getFinalPipeline());
            Names.WRITE
            .metadata(Metadata.builder().putCustom(IngestMetadata.TYPE, ingestMetadata))
        // like this one it may not readily obvious why the metrics were not carried forward.
        bulkRequest.add(indexRequest1);
                    + "                {\n"
        ingestInfos.put(node2, new IngestInfo(Arrays.asList(new ProcessorInfo("set"))));
        ExecutorService executorService = OpenSearchExecutors.newDirectExecutorService();
        Map<String, Processor.Factory> processors = new HashMap<>();
    public void testUpdatePipelines() {
        clusterState = IngestService.innerPut(putRequest, clusterState);
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        Exception e = expectThrows(
        Metadata metadata = Metadata.builder().indices(Map.of("idx", indexMetadata)).build();
        ingestService.executeBulkRequest(2, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
            .setSystemIngestPipeline("_none");
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        putRequest = new PutPipelineRequest("_id2", new BytesArray("{\"processors\": [{\"mock\" : {}}]}"), MediaTypeRegistry.JSON);
        pipeline = ingestService.getPipeline(id);
        when(indexMetadata.getIndex()).thenReturn(new Index("_index", "uuid"));
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        clusterState = IngestService.innerPut(putRequest, clusterState);
    ) {
            Collections.singletonMap("mock", (factories, tag, description, config) -> processor)
        bulkRequest.add(new DeleteRequest("_index", "_id"));
                return processors;
        assertThat(ingestService.pipelines().get("_id").pipeline.getId(), equalTo("_id"));
                    + "                          \"tag\": \"tagggg\",\n"
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
        );
        return createPipeline(pipeline, ingestService, null);
        assertThat(ingestService.getPipeline("q1"), nullValue());
            assertThat(indexRequest, notNullValue());
        );
        final IndexRequest indexRequest = new IndexRequest("idx");
    public void testPrepareBatches_same_index_pipeline() {
            return new ConditionalProcessor(
            bulkRequest.add(indexRequest);
            1,
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        IngestService ingestService = createIngestServiceWithProcessors();
                    assertThat(counter.compareAndSet(1, 2), is(true));
        // request pipeline with default pipeline:
    }
            .source(emptyMap())
            assertThat(result, is(true));
            .setPipeline("_id")
        Map<K, V> map = new HashMap<>();
        // request pipeline:
    public void testExecuteSystemPipelineDoesNotExist() {
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
        putRequest = new PutPipelineRequest(
                }), Collections.emptyMap())
                }
        final List<Processor> processors = Collections.singletonList(onFailureProcessor);
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
            1,
import java.util.ArrayList;
        final Processor processorFailure = mock(Processor.class);
    private static IngestService createIngestServiceWithProcessors() {
        IngestMetadata ingestMetadata = new IngestMetadata(Collections.singletonMap("_id", config));
                public IngestDocument execute(IngestDocument ingestDocument) {
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            4,
        doAnswer(invocationOnMock -> {
        // mock a final pipeline do nothing
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
            .setPipeline("_id")
            .setSystemIngestPipeline("_none");
            ),
    }
            .setPipeline("_id")
 * GitHub history for details.
            .getClusterSettings()
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
            return null;
        clusterSettings.applySettings(newSettings);
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
    public void testResolvePipelines_whenUseTemplateV1() throws Exception {
            Settings.builder().build(),
        clusterState = IngestService.innerPut(putRequest, clusterState);
        );
        // test a failure, and that the processor stats are added from the old stats
        createPipeline("final_pipeline", new BytesArray("{\"processors\": [{\"dummy\" : {}}]}"), ingestService, clusterState);
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        PutPipelineRequest putRequest = new PutPipelineRequest(
        BytesArray definition = new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}");
            IndexRequest indexRequest = new IndexRequest("idx").setPipeline("request-pipeline");
                    + "                                \"tag\": \"tagggg\"\n"
        // verify
    ) {
            completionHandler,
        indexRequest = new IndexRequest("idx");
            MediaTypeRegistry.JSON
        IngestService ingestService = new IngestService(
            "[_index/uuid]",
        assertThat(ingestService.getPipeline("p2"), nullValue());
        assertThat(ingestService.getPipeline("_id"), notNullValue());
            Collections.singletonList(new CompoundProcessor(false, processors, onFailureProcessors))
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        ingestInfos.put(node2, new IngestInfo(Arrays.asList(new ProcessorInfo("set"))));
        ScriptService scriptService = new ScriptService(
        clusterState = IngestService.innerPut(putRequest, clusterState);
            dropHandler,
                    "test1",
            .setFinalPipeline("_final")
            assertThat(indexRequest.getContentType(), equalTo(xContentType));
            Names.WRITE
        assertThat(ingestService.pipelines().get("_id1").pipeline.getId(), equalTo("_id1"));
        DeletePipelineRequest deleteRequest = new DeletePipelineRequest(id);
        PutPipelineRequest putRequest = new PutPipelineRequest(
        assertThat(indexRequest.isPipelineResolved(), is(true));
        bulkRequest.add(indexRequest2);
        );
        try (XContentBuilder builder = CborXContent.contentBuilder()) {
import org.opensearch.action.ingest.DeletePipelineRequest;
        IndexRequest indexRequest = new IndexRequest("idx");
        map.put(key2, value2);
            completionHandler,
    }
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        verify(mockCompoundProcessor, never()).batchExecute(any(), any());
            Collections.singletonList(indexRequest),
        assertEquals(Set.of(Thread.currentThread()), completionHandler.keySet());
        assertThat(ingestService.pipelines().get("_id3").pipeline.getId(), equalTo("_id3"));
        verify(processor).execute(any(), any());
        createPipeline("_final", ingestService, clusterState);
        verify(failureHandler, never()).accept(any(), any());
                .setFinalPipeline("_none");
import org.opensearch.common.xcontent.cbor.CborXContent;
            id,
        bulkRequest.add(indexRequest4);
        IndexRequest indexRequest4 = new IndexRequest("_index").id("_id4")
        public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
            @Override
        final Processor onFailureOnFailureProcessor = mock(Processor.class);
        // one. This happens because the target index of the first doc is changed.
    private static <K, V> Map<K, V> mapOf(K key1, V value1, K key2, V value2) {
    }
            @Override
        verify(failureHandler, never()).accept(any(), any());
        );
                )
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
    private Processor mockSystemProcessor;
import org.hamcrest.MatcherAssert;
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor())
        final IngestStats afterThirdRequestStats = ingestService.stats();
                    return true;
import static org.mockito.Mockito.times;
        );
        processors.put(
        clusterState = ClusterState.builder(clusterState)
        ingestService.executeBulkRequest(2, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
        verify(defaultProcessor, times(1)).batchExecute(any(), any());
            new BytesArray("{\"processors\": [], \"description\": \"_description\"}"),
    }
            assertThat(e.getMessage(), equalTo("pipeline [unknown] is missing"));
                scriptService,
        final IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        final Map<Integer, Exception> errorHandler = new HashMap<>();
            assertThat(indexRequest.getPipeline(), equalTo("request-pipeline"));
import org.opensearch.indices.IndicesService;
        IndexTemplateMetadata v1Template = IndexTemplateMetadata.builder("v1-template").patterns(Arrays.asList("fo*", "baz")).build();
        OpenSearchParseException e = expectThrows(
            failureHandler,
        IngestService ingestService = createIngestServiceWithProcessors(
        }
        final List<Integer> dropHandler = new ArrayList<>();
            handler.accept(RandomDocumentPicks.randomIngestDocument(random()), null);
        // due to the parallel array's used to identify which metrics to carry forward. With out unique ids or semantic equals for each
        // processor, parallel arrays are the best option for of carrying forward metrics between pipeline changes. However, in some cases,
                .build()
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
            .setSystemIngestPipeline("_none");
            .setSystemIngestPipeline("_none");
        // pipeline
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
    }
            if (randomBoolean()) {
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
        verify(systemIngestPipelineCache, times(1)).cachePipeline(any(), any(), anyInt());
            handler.accept(ingestDocumentWrappers);
            MediaTypeRegistry.JSON
        final IngestService ingestService = createIngestServiceWithProcessors();
    }
        );
            emptyMap(),
                .numberOfReplicas(0)
            new Pipeline("id", "description", null, new CompoundProcessor(false, List.of(dummySystemProcessor), Collections.emptyList())),
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
            new IngestDocumentWrapper(1, 0, null, new RuntimeException()),
                    + "                  }\n"
        }
        clusterState = IngestService.innerPut(putRequest, clusterState);
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getFinalPipeline());
import static org.mockito.Mockito.anyString;
            handler.accept(results);
        }
                    + "                    \"tag\": \"tagggg\"\n"
                    + "                          \"field\": \"ingest_error2\",\n"
        assertStats(afterForthRequestStats.getTotalStats(), 4, 0, 0);
            .setPipeline("_id")
                    + "              \"field\": \"ingest_error2\",\n"
            Version.CURRENT
import org.opensearch.core.xcontent.XContentBuilder;
            .setSystemIngestPipeline("_none");
                .numberOfReplicas(0)
        final IndexMetadata changedIndexMetadata2 = mock(IndexMetadata.class);
        // index name matches with ITMD:
        }).when(processor).execute(any(IngestDocument.class), any());
        );
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
            new BytesArray("{\"processors\": [{\"drop\" : {}}, {\"mock\" : {}}]}"),
            return null;
        );
                return null;
        DocWriteRequest<?> actionRequest = new IndexRequest(index);
                    + "              \"on_failure\": [\n"
            .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))
        verify(mockCompoundProcessor, times(1)).batchExecute(any(), any());
        assertNull(cache.getSystemIngestPipeline(index3.toString()));
        );
            return null;
                    ingestDocument.setFieldValue(metadata.getFieldName(), newVersion);
        // verify the default pipeline will process both requests and the final pipeline will only process the second
        @SuppressWarnings("unchecked")
            IndexMetadata.builder("idx")
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        result = ingestService.resolvePipelines(updateRequest, TransportBulkAction.getIndexWriteRequest(updateRequest), metadata);
    public void testStats() throws Exception {
    public void testCBORParsing() throws Exception {
            1,
        assertEquals(Set.of(1, 2), failureHandler.keySet());
        ingestInfos.put(node2, new IngestInfo(Arrays.asList(new ProcessorInfo("set"), new ProcessorInfo("remove"))));
        assertThat(indexRequest.getPipeline(), equalTo("default-pipeline"));
        assertThat(pipeline, nullValue());
    public void testIngestPlugin() {
        ingestService.executeBulkRequest(5, bulkRequest.requests(), (slot, exception) -> {
            .setFinalPipeline("_id")
                mock(IndicesService.class),
        ClusterState previousClusterState = clusterState;
        );
    }
import static org.mockito.Mockito.verify;
        verify(mockCompoundProcessor, times(1)).execute(any(), any());
        verifySystemPipelineResolvedSuccessfully("[idx/template]", hasPipeline, indexRequest, cache);
            .setSystemIngestPipeline("_none");
        @SuppressWarnings("unchecked")
        assertThat(ingestService.pipelines().size(), is(1));
        );
        String tag = randomAlphaOfLength(10);
import static org.mockito.Mockito.doThrow;
        final Processor dummySystemProcessor = mock(Processor.class);
import org.mockito.MockitoAnnotations;
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
                new MockLogAppender.SeenEventExpectation(
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        verify(mockCompoundProcessor, never()).execute(any(), any());
        assertPipelineStats(afterSecondRequestStats.getPipelineStats(), "_id2", 1, 0, 0);
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        IngestService ingestService = createIngestServiceWithProcessors();
            completionHandler,
    }
                "{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\", \"tag\": \"tag1\"}},"
            return null;
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);
        final IndexMetadata indexMetadata1 = mock(IndexMetadata.class);
        IndexRequest indexRequest4 = new IndexRequest("_index").id("_id4")
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        bulkRequest.add(indexRequest2ChildSlot0);
        map.put(key1, value1);
        assertTrue(indexRequest.isPipelineResolved());
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            builder.startObject();
        Processor defaultProcessor = mock(Processor.class);
            }).when(dummySystemProcessor).execute(any(), any());
        verify(systemIngestPipelineCache, times(3)).getSystemIngestPipeline(any());
    public void testTargetIndexChange() {
            handler.accept(document, null);
                    + "              \"field\": \"ingest_error1\",\n"
        clusterState = IngestService.innerPut(putRequest, clusterState);
            .numberOfReplicas(0)
        IngestService ingestService = createIngestServiceWithProcessors(
        when(pipelineProcessor.getPipelineTemplate()).thenReturn(new TestTemplateService.MockTemplateScript.Factory(pipelineName));
import java.util.Comparator;
            bulkRequest.requests(),
        );
    }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        IngestService ingestService = createIngestServiceWithProcessors();
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        );
            fail("exception expected");
        bulkRequest.add(indexRequest1);
            bulkRequest.requests(),
            .source(emptyMap())
        // verify update max processor
        processors.put("dummy", (factories, tag, description, config) -> new CompoundProcessor(false, List.of(dummyProcessor), List.of()));
            .build();
        assertThat(ingestService.getPipeline("p2"), notNullValue());
            .setSystemIngestPipeline("_none");
            for (IngestDocumentWrapper wrapper : ingestDocumentWrappers) {
        when(processor.getType()).thenReturn("mock");
        PutPipelineRequest putRequest = new PutPipelineRequest(
        // total
        when(threadPool.executor(anyString())).thenReturn(executorService);
            indexMetadata1,
        );
        );
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        assertThat(ingestService.getProcessorsInPipeline(id, FakeProcessor.class).size(), equalTo(2));
        @NonNull final IndexRequest indexRequest,
            MediaTypeRegistry.JSON
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer) args.getArguments()[1];
        );
    public void testGetProcessorsInPipelineComplexConditional() throws Exception {
        ingestInfos.put(node1, new IngestInfo(Arrays.asList(new ProcessorInfo("set"), new ProcessorInfo("remove"))));
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        );
                    + "            }\n"
                    + "  ]\n"
        verifyNoMoreInteractions(cache);
            100
        );
            mock(SystemIngestPipelineCache.class)
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        map.put("mock", (factories, tag, description, config) -> processor);
        bulkRequest.add(indexRequest2);
            .setPipeline("_id")
        verify(mockCompoundProcessor, times(1)).batchExecute(any(), any());
        bulkRequest.add(indexRequest2);
                handler.accept(documents);
        assertThat(indexRequest.isPipelineResolved(), is(true));
        verify(dropHandler, times(1)).accept(1);
            }
            "_id",
                wrapper.update(wrapper.getIngestDocument(), error);
        }).when(processor).batchExecute(any(), any());
            doAnswer(invocationOnMock -> {
        String pipelineId = "_id";
            Names.WRITE
        });
            Collections.singletonList(indexRequest),
        IngestService ingestService = createIngestServiceWithProcessors();
            .setFinalPipeline("_none")
        BulkRequest bulkRequest = new BulkRequest();
                    + "                }\n"
        );
        for (int i = 0; i < numIndexRequests; i++) {
        createPipeline("_id", ingestService);
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
            .setSystemIngestPipeline("[_index/uuid]")
            bulkRequest.numberOfActions(),
        BulkRequest bulkRequest = new BulkRequest();
            numIndexRequests + numOtherRequests,
 */
            .setFinalPipeline("_none")
        @NonNull final String id,
            Names.WRITE
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        IngestMetadata ingestMetadata = new IngestMetadata(configs);
                .putMapping("{}")
        assertEquals("[set] is not a system generated processor factory.", exception.getMessage());
        Map<String, Processor.Factory> processors,
        ingestService.innerUpdatePipelines(ingestMetadata);
        Metadata metadata = Metadata.builder().indices(Map.of("_index", indexMetadata)).build();
    }
        IndexRequest indexRequest = new IndexRequest("idx");
        verify(dummyFinalProcessor, times(1)).execute(any(), any());
        assertThat(ingestService.getPipeline("p1"), nullValue());
            .setFinalPipeline("_none")
        IllegalArgumentException e = expectThrows(
            .source(emptyMap())
        // Perform an update with no changes:
        final Map<Integer, List<Exception>> failureHandler = new HashMap<>();
        bulkRequest.add(indexRequest1);
        pipeline = ingestService.getPipeline(id);
        );
            Collections.singletonMap(
import org.opensearch.action.DocWriteRequest;
        assertEquals("Ingest info is empty", e.getMessage());
            "_id",
        IngestService ingestService = createIngestServiceWithProcessors();
        BulkRequest bulkRequest = new BulkRequest();
        ingestService.executeBulkRequest(
    }
                    + "            \"set\": {\n"
        Map<String, Processor.Factory> processors = new HashMap<>();
    public void testExecuteEmptyPipeline() throws Exception {
            handler.accept(documents);
            () -> ingestService.validatePipeline(Collections.singletonMap(discoveryNode, ingestInfo), putRequest)
        try {
            Names.WRITE
import static org.mockito.Mockito.when;
            @SuppressWarnings("unchecked")
            2,
        pipelines.put("p1", new PipelineConfiguration("p1", definition, MediaTypeRegistry.JSON));
            null,
        );
        systemProcessors.put("foo", mockSystemProcessorFactory);
            bulkRequest.numberOfActions(),
        @SuppressWarnings("unchecked")
        final IngestService ingestService = createIngestServiceWithProcessors();
            "_id",
            new BytesArray("{\"processors\": [], \"description\": \"_description\"}"),
        DiscoveryNode node2 = new DiscoveryNode("_node_id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertPipelineStats(afterForthRequestStats.getPipelineStats(), "_id2", 1, 0, 0);
                // We attach a child index request
        verify(mockCompoundProcessor, never()).execute(any(), any());
import org.opensearch.cluster.node.DiscoveryNode;
            bulkRequest.requests(),
            buildNewFakeTransportAddress(),
            indexReq -> {},
            "index1",
            .setFinalPipeline("_none");
import org.opensearch.common.xcontent.XContentType;
        doAnswer(args -> {
        @SuppressWarnings("unchecked")
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
            dropHandler::add,
            Collections.singletonList(DUMMY_PLUGIN),
            .getClusterSettings()
                List<IngestDocumentWrapper> documents = (List<IngestDocumentWrapper>) invocationOnMock.getArguments()[0];
        boolean hasPipeline = ingestService.resolveSystemIngestPipeline(indexRequest, indexRequest, metadata);
            String field = (String) config.remove("field");
                new ConditionalProcessor(
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "v2-template", v2Template);
            .source(emptyMap())
        bulkRequest.add(indexRequest1);
            failureHandler::put,
            .setFinalPipeline("_none")
            .setSystemIngestPipeline("_none");
        IndexRequest indexRequest3ChildSlot0 = new IndexRequest("_index").id("_id3")
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
    }
        assertThat(indexRequest.getPipeline(), equalTo("default-pipeline"));
            new IngestDocumentWrapper(1, 1, null, new RuntimeException()),
import java.util.Map;
        ingestService.getClusterService()
        // mock
                .build()
            .patterns(Collections.singletonList("id*"))
        String name = randomAlphaOfLength(10);
        assertProcessorStats(0, afterThirdRequestStats, "_id2", 1, 0, 0);
import org.opensearch.common.settings.ClusterSettings;
    }
            indexReq -> {},
    public void testBulkRequestExecution() throws Exception {
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer<List<IngestDocumentWrapper>>) invocationOnMock.getArguments()[1];
        verifySystemPipelineResolvedSuccessfully("[idx/template]", hasPipeline, indexRequest, cache);
                UpdateRequest updateRequest = new UpdateRequest("_index", "_id");
        assertThat(result, is(true));
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer) args.getArguments()[1];
import org.apache.logging.log4j.Level;
        ingestService.executeBulkRequest(
    }
                .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))
        assertThat(ingestService.pipelines().get("_id1").pipeline.getId(), equalTo("_id1"));
    }
            })
        );
            .source(emptyMap())
            String value = (String) config.remove("value");
            String field = (String) config.remove("field");
            boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
        indexRequest.setPipeline("_id1");
        Processor defaultProcessor = mock(Processor.class);
            .setSystemIngestPipeline("_none");
                    ingestDocument.setFieldValue(metadata.getFieldName(), "update" + metadata.getFieldName());
            @Override
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getPipeline());
        IndexRequest indexRequest = new IndexRequest(index);
        // call
        ingestService.executeBulkRequest(
            Names.WRITE
        IllegalArgumentException e = expectThrows(
        assertThat(ingestService.getPipeline("p1"), nullValue());
            Names.WRITE
            assertThat(e.getMessage(), equalTo("pipeline [z*] is missing"));
        assertEquals(Set.of(Thread.currentThread()), completionHandler.keySet());
    public void testExecuteBulkRequestInBatchWithDefaultAndFinalPipeline() {
            Collections.singletonList(indexRequest),
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "v2-template", v2Template);
            null,
            Collections.singletonList(indexRequest),
        }
                    + "                              \"set\": {\n"
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getPipeline());
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
        final Map<Thread, Exception> completionHandler = new HashMap<>();
    }
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        @Override
        assertProcessorStats(0, afterSecondRequestStats, "_id1", 1, 0, 0);
                client,
            Metadata metadata = Metadata.builder().build();
        // call
        // Delete pipeline matching wildcard
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
            .setFinalPipeline("_none")
        // create ingest service and cluster state
            "default",
                return Collections.singletonMap("test", (factories, tag, description, config) -> {
            "index3",
        return createPipeline(pipeline, new BytesArray("{\"processors\": [{\"mock\" : {}}]}"), ingestService, previousState);
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
            threadPool,
            for (IngestDocument.Metadata metadata : IngestDocument.Metadata.values()) {
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
            indexReq -> {},
            .source(emptyMap())
            Collections.singletonList(indexRequest),
        assertThat(ingestService.getPipeline("p2"), nullValue());
            .source(emptyMap())
                "{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\", \"tag\": \"tag1\"}},"
            longId
            MediaTypeRegistry.JSON
        );
            Collections.singletonList(indexRequest),
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        @SuppressWarnings("unchecked")
import org.opensearch.action.bulk.TransportBulkAction;
        assertThat(pipeline, nullValue());
            .metadata(Metadata.builder().putCustom(IngestMetadata.TYPE, ingestMetadata))
        BulkRequest bulkRequest = new BulkRequest();
        });
        assertThat(result, is(true));
                    + "          },\n"
            argThat((Integer item) -> item == 2),
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
        ingestService.innerUpdatePipelines(ingestMetadata);
        when(processor.getType()).thenReturn(name);
 * specific language governing permissions and limitations
                    + "{\"remove\" : {\"field\": \"_field\", \"tag\": \"tag2\"}}]}"
import static org.mockito.Mockito.doAnswer;
            .setPipeline("_id")
import org.opensearch.action.delete.DeleteRequest;
                    + "                            },\n"
                    + "                        }\n"
            "_id",
        createPipeline("_id", ingestService);
        }).when(onFailureProcessor).execute(eqIndexTypeId(emptyMap()), any());
        }
        bulkRequest.add(indexRequest1);
        // mock
        clusterState = IngestService.innerPut(putRequest, clusterState);
                    + "              \"value\": \"failed\",\n"
    }
        }).when(processor).batchExecute(any(), any());
    private class IngestDocumentMatcher implements ArgumentMatcher<IngestDocument> {
    public void testResolveSystemIngestPipeline_whenExistingIndexAndSystemPipelineDisabled_thenNoSystemPipeline() throws Exception {
        IngestService ingestService = createIngestServiceWithProcessors(map);
        pipelines = IngestService.innerGetPipelines(ingestMetadata, "_id*");
                randomAlphaOfLength(10),
    }
            }
            .source(emptyMap())
            "index1",
            Collections.singletonList(processor),
        IngestService ingestService = createIngestServiceWithProcessors(processors);
        doAnswer(args -> {
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2").source(emptyMap()).setPipeline("_id").setFinalPipeline("_none");
        IngestMetadata ingestMetadata = new IngestMetadata(pipelines);
        }).when(mockCompoundProcessor).batchExecute(any(), any());
        final IndexMetadata indexMetadata = spy(
        );
        final long newVersion = randomLong();
        assertThat(indexRequest.getPipeline(), equalTo("_none"));
        assertTrue(systemFactories.containsKey("foo"));
            mock(IndicesService.class),
        ingestService.executeBulkRequest(1, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
        assertPipelineStats(afterFirstRequestStats.getPipelineStats(), "_id1", 1, 0, 0);
        // Delete existing pipeline:
        final Processor dummySystemProcessor = mock(Processor.class);
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer) args.getArguments()[1];
            Names.WRITE
            clusterService,
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        IngestService ingestService = createIngestServiceWithProcessors(
            null,
                throw new AssertionError("Document should have been dropped but reached this processor");
import org.opensearch.script.Script;
        );
            1,
        PutPipelineRequest putRequest = new PutPipelineRequest(id, new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON);
            IndexRequest indexRequest = new IndexRequest("_index").id("_id")
import static org.hamcrest.Matchers.nullValue;
        DiscoveryNode node1 = new DiscoveryNode("_node_id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
import org.opensearch.action.index.IndexRequest;
        ClusterState previousClusterState = clusterState;
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
            new BytesArray("{\"processors\": [{\"foo\" : {}}]}"),
            assertEquals(2, batches.get(i).size());
        final SetOnce<Boolean> failure = new SetOnce<>();
                1,
        IngestService ingestService = createIngestServiceWithProcessors(emptyMap());
            "[_index/template]",
        putRequest = new PutPipelineRequest(
        assertEquals(2, batches.size());
        // verify the pipeline info of the request 1 will be reset since its target index is changed
        IngestService ingestService = createIngestServiceWithProcessors(
            .setPipeline("_none")
        assertThat(ingestService.getProcessorsInPipeline(id, Processor.class).size(), equalTo(3));
                .source(builder)
    public void testIngestServiceCreation_whenInvalidSystemProcessor_thenFail() {
        assertThat(pipelines.size(), equalTo(2));
        final ClusterState previousClusterState = ClusterState.builder(new ClusterName("_name")).metadata(previousMetadata).build();
        }).when(processor).execute(any(), any());
        );
        PutPipelineRequest putRequest = new PutPipelineRequest(
            ),
                    + "                        \"set\": {\n"
            mock(IndicesService.class),
        IndexRequestWrapper wrapper4 = createIndexRequestWrapper(
        IngestService ingestService = createIngestServiceWithProcessors();
    }
            .setFinalPipeline("_none")
        assertThat(ingestService.pipelines().get("_id").pipeline.getDescription(), nullValue());
            Collections.singletonMap("mock", (factories, tag, description, config) -> processor)
        when(processor.getTag()).thenReturn("mockTag");
        assertThat(ingestService.pipelines().get("_id").pipeline.getProcessors().get(0).getType(), equalTo("set"));
            @SuppressWarnings("unchecked")
            .setFinalPipeline("_id")
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        IngestService ingestService = new IngestService(
            .setSystemIngestPipeline("[_index/uuid]")
            .source(emptyMap())
        pipelines.put("p2", new PipelineConfiguration("p2", definition, MediaTypeRegistry.JSON));
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
        ClusterState previousClusterState = clusterState;
                } else if (metadata == IngestDocument.Metadata.IF_SEQ_NO) {
        assertThat(ingestService.pipelines().get("_id3").pipeline.getId(), equalTo("_id3"));
import java.util.concurrent.atomic.AtomicReference;
        pipeline = ingestService.getPipeline(id);
            bulkRequest.requests(),
        @SuppressWarnings("unchecked")
        ingestService.executeBulkRequest(2, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
    }
        clusterState = IngestService.innerDelete(matchAllDeleteRequest, clusterState);
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
        };
        @Override
        verify(failureHandler, times(2)).accept(any(), any());
        BulkRequest bulkRequest = new BulkRequest();
        verify(dummySystemProcessor, times(1)).batchExecute(any(), any());
        IndexRequest indexRequest = new IndexRequest("idx");
import static org.hamcrest.Matchers.notNullValue;
        verifySystemPipelineResolvedSuccessfully("[idx/uuid]", hasPipeline, indexRequest, cache);
        final IndexMetadata indexMetadata = spy(
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))
                "{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\", \"tag\": \"tag1\"}},"
        // invoke
    public void testPrepareBatches_different_index_pipeline() {
import org.opensearch.plugins.IngestPlugin;
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
                    + "          {\n"
        assertEquals(NOOP_PIPELINE_NAME, indexRequest1.getPipeline());
        verify(mockCompoundProcessor, never()).execute(any(), any());
        BytesArray definition = new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}");
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        String scriptName = "conditionalScript";
            MediaTypeRegistry.JSON
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        @SuppressWarnings("unchecked")
        verify(mockCompoundProcessor, never()).execute(any(), any());
                bulkRequest.add(updateRequest);
        // verify we use the system pipeline from the cache
        when(threadPool.generic()).thenReturn(executorService);
            Names.WRITE
        Client client = mock(Client.class);
        assertTrue(failureHandler.isEmpty());
        assertTrue(failureHandler.isEmpty());
 * KIND, either express or implied.  See the License for the
        IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder("name1")
            IndexRequest indexRequest = new IndexRequest("idx").setPipeline("request-pipeline");
        assertThat(ingestService.pipelines().size(), is(3));
    }
            new IngestDocumentWrapper(2, 0, null, new RuntimeException()),
        );
        Pipeline pipeline = ingestService.getPipeline(id);
                .setSystemIngestPipeline("_none");
        // get all variants: (no IDs or '*')
        );
        assertThat(updateRequest.upsertRequest().isPipelineResolved(), is(true));
            new BytesArray(
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
                indexReq -> {},
        IngestService ingestService = createIngestServiceWithProcessors(processors, systemProcessors);
        boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
            Collections.singletonList(indexRequest),
            assertThat(indexRequest.getPipeline(), equalTo("request-pipeline"));
        BulkRequest bulkRequest = new BulkRequest();
        Map<String, Processor.Factory> factories = new HashMap<>();
            .setFinalPipeline("_none")
            completionHandler,
            .setFinalPipeline("_id")
                Consumer<List<IngestDocumentWrapper>> handler = (Consumer<List<IngestDocumentWrapper>>) invocationOnMock.getArguments()[1];
        assertThat(afterSecondRequestStats.getPipelineStats().size(), equalTo(2));
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
    }
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
        assertStats(afterThirdRequestStats.getTotalStats(), 3, 0, 0);
            .setPipeline("_id")
        ClusterState state = ClusterState.EMPTY_STATE;
        CompoundProcessor processor = mock(CompoundProcessor.class);
            null,
            List<IngestDocumentWrapper> ingestDocumentWrappers = (List) args.getArguments()[0];
        assertThat(pipeline, notNullValue());
        IngestService ingestService = createIngestServiceWithProcessors(map);
        doThrow(new RuntimeException()).when(processor)
            .source(emptyMap())
        assertThat(ingestService.pipelines().get("_id1").pipeline.getProcessors().size(), equalTo(0));
        );
            completionHandler,
        createPipeline("_id", ingestService);
            .setPipeline("_id")
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
            .source(emptyMap())
        // alias name matches with IDM:
        bulkRequest.add(indexRequest1);
        clusterState = IngestService.innerPut(putRequest, clusterState);
        // verify
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        PutPipelineRequest putRequest = new PutPipelineRequest(
import java.util.function.BiConsumer;
            id,
        // prepare handler
        processors.put(
            assertThat(indexRequest.isPipelineResolved(), is(true));
            bulkRequest.requests(),
        bulkRequest.add(indexRequest1);
        bulkRequest.add(indexRequest3);
        );
        } catch (ResourceNotFoundException e) {
                return null;
        Map<String, Processor.Factory> factories = ingestService.getProcessorFactories();
        // verify we use the system pipeline from the cache
        assertThat(updateRequest.upsertRequest().getFinalPipeline(), equalTo("final-pipeline"));
        @SuppressWarnings("unchecked")
        assertTrue(failureHandler.isEmpty());
        assertProcessorStats(0, afterSecondRequestStats, "_id2", 1, 0, 0);
            return new FakeProcessor("set", tag, description, (ingestDocument) -> ingestDocument.setFieldValue(field, value));
            .putAlias(AliasMetadata.builder("alias").writeIndex(true).build());
        final Map<Thread, Exception> completionHandler = new HashMap<>();
                    + "                              \"set\": {\n"
                    IngestService.class.getCanonicalName(),
            Version.CURRENT
        List<List<IndexRequestWrapper>> batches = IngestService.prepareBatches(2, Arrays.asList(wrapper1, wrapper2, wrapper3, wrapper4));
            .setPipeline("_id")
            completionHandler::put,
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
import org.opensearch.script.ScriptModule;
        BulkRequest bulkRequest = new BulkRequest();
            new IngestDocumentWrapper(1, 0, IngestService.toIngestDocument(indexRequest2ChildSlot0), null),
        SystemIngestPipelineCache systemIngestPipelineCache = ingestService.getSystemIngestPipelineCache();
            longId,
        verify(requestItemErrorHandler, never()).accept(any(), any());
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        verify(dummySystemProcessor, times(1)).execute(any(), any());
            errorHandler::put,
            new BytesArray("{\"description\": \"empty processors\"}"),
            .build();
            indexReq -> {},
        Map<String, Processor.Factory> processors = new HashMap<>();
        final IngestService ingestService = createIngestServiceWithProcessors();
        // Delete pipeline:
        return processor;
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
            Names.WRITE
        bulkRequest.add(indexRequest2);
        indexRequest.setPipeline("_id2");
                    return new FakeProcessor("test", tag, description, ingestDocument -> {});
    public void testInnerUpdatePipelines() {
            Names.WRITE
    public void testDeleteWithExistingUnmatchedPipelines() {
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
                    + "                      },\n"
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
            "_id1",
            .setFinalPipeline("final_pipeline")
        }).when(mockCompoundProcessor).batchExecute(any(), any());
    }
            .metadata(Metadata.builder(Metadata.EMPTY_METADATA).put(v1Template).build())
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
        // Ingest cluster state listener state should be invoked first:
    public void testUpdateMaxIngestProcessorCountSetting() {
            Collections.singletonList(DUMMY_PLUGIN),
        Pipeline pipeline = ingestService.getPipeline(id);
        assertThat(pipelines.get(0).getId(), equalTo("_id1"));
        ingestService.executeBulkRequest(
        IngestDocumentMatcher(String index, String type, String id, Map<String, Object> source) {
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            .setPipeline("_id")
        assertTrue(failure.get());
        final Pipeline dummyPipeline = new Pipeline("id", null, null, new CompoundProcessor());
            "_id",
        assertThat(pipeline, notNullValue());
    public void testExecuteBulkRequestInBatch() {
        doThrow(new RuntimeException()).when(mockCompoundProcessor).batchExecute(any(), any());
            .setFinalPipeline("_none")
    public void testInvalidateCache() {
        Client client = mock(Client.class);
        ingestMetadata = new IngestMetadata(mapOf("_id1", pipeline1, "_id3", pipeline3));
        ingestService.executeBulkRequest(
            .setPipeline("_none")
        @SuppressWarnings("unchecked")
            MediaTypeRegistry.JSON
        SystemIngestPipelineCache systemIngestPipelineCache = ingestService.getSystemIngestPipelineCache();
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        IngestService ingestService = createIngestServiceWithProcessors();
            .setPipeline("_none")
            IngestDocument ingestDocument = (IngestDocument) invocationOnMock.getArguments()[0];
        String id = "_id";
        PutPipelineRequest putRequest = new PutPipelineRequest(
        IngestService ingestService = createIngestServiceWithProcessors();
        );
            completionHandler,
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
import java.util.Arrays;
                    + "                {\n"
            .build();
        assertProcessorStats(1, afterThirdRequestStats, "_id1", 1, 0, 0);
            return null;
    }
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
            .applySettings(Settings.builder().put(IngestService.SYSTEM_INGEST_PIPELINE_ENABLED.getKey(), false).build());
        // First time create the pipeline and cache it
        CompoundProcessor processor = mock(CompoundProcessor.class);
            failureHandler::put,
        // verify
            dropHandler::add,
            mock(NamedXContentRegistry.class),
                    + "        \"field\": \"timestamp_field_1\",\n"
    }
        processors.put("set", (factories, tag, description, config) -> {
        Client client = mock(Client.class);
        PipelineConfiguration pipeline1 = new PipelineConfiguration("_id1", new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON);
            @SuppressWarnings("unchecked")
                .numberOfShards(1)
                    + "                },\n"
        when(clusterService.getClusterSettings()).thenReturn(
            completionHandler,
    }
        );
        Exception e = expectThrows(IllegalStateException.class, () -> ingestService.validatePipeline(emptyMap(), putRequest));
            return null;
    }
        bulkRequest.add(indexRequest1);
        assertProcessorStats(0, afterThirdRequestStats, "_id1", 1, 0, 0);
        }
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))
public class IngestServiceTests extends OpenSearchSingleNodeTestCase {
        bulkRequest.add(indexRequest3);
        int numIndexRequests = scaledRandomIntBetween(4, 32);
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
        IngestService ingestService = createIngestServiceWithProcessors(
        ingestInfos.put(node1, new IngestInfo(Arrays.asList(new ProcessorInfo("set"), new ProcessorInfo("remove"))));
    }
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);
        assertThat(pipeline.getProcessors().size(), equalTo(0));
                    + "{\"remove\" : {\"field\": \"_field\", \"tag\": \"tag2\"}}]}"
            .setFinalPipeline("_none");
            Names.WRITE
            completionHandler::put,
        assertThat(pipeline.getId(), equalTo(id));
    public void testValidateProcessorCountForIngestPipelineThrowsException() {
        );
        IngestService ingestService = createIngestServiceWithProcessors();
            id,
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
        }
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            "_id",
import org.opensearch.Version;
        final Map<Integer, Exception> failureHandler = new HashMap<>();
            mockAppender.assertAllExpectationsMatched();
import org.opensearch.index.IndexSettings;
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
    }
        // mock a default pipeline do nothing
            .build();
        IngestService ingestService = createIngestServiceWithProcessors();
        verify(mockCompoundProcessor, times(2)).batchExecute(any(), any());
        putRequest = new PutPipelineRequest(
        doAnswer(args -> {
        Map<String, PipelineConfiguration> configs = new HashMap<>();
            bulkRequest.requests(),
            failureHandler::put,
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        Pipeline pipeline = ingestService.getPipeline(id);
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
        assertEquals(Set.of(1), failureHandler.keySet());
                public String getType() {
        systemProcessors.put("dummy", systemProcessorFactory);
        clusterState = ClusterState.builder(clusterState)
            client,
        }
            "index1",
        verify(systemIngestPipelineCache, times(1)).cachePipeline(any(), any(), anyInt());
        assertThat(ingestService.pipelines().size(), is(1));
            .execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());
            bulkRequest.numberOfActions(),
        final Map<Integer, Exception> failureHandler = new HashMap<>();
        IngestInfo ingestInfo = new IngestInfo(Collections.singletonList(new ProcessorInfo("set")));
        @SuppressWarnings("unchecked")
            Collections.singletonList(new CompoundProcessor(onFailureProcessor))
        when(processor.getTag()).thenReturn("mockTag");
                    + "                            }\n"
        try {
        assertThat(afterFirstRequestStats.getPipelineStats().size(), equalTo(2));
            String field = (String) config.remove("field");
    private ClusterState createPipeline(String pipeline, IngestService ingestService, ClusterState previousState) {
        DiscoveryNode node1 = new DiscoveryNode("_node_id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            .setPipeline(id)
        final long ifSeqNo = randomNonNegativeLong();
        SystemIngestPipelineCache systemIngestPipelineCache = ingestService.getSystemIngestPipelineCache();
            emptySet(),
    public void testExecuteFailureWithNestedOnFailure() throws Exception {
            new IngestDocumentWrapper(2, 1, null, new RuntimeException())
        Exception error = new RuntimeException();
            completionHandler,
        }).when(processorFailure).execute(any(IngestDocument.class), any());
    }
                updateRequest.doc(indexRequest);
                Arrays.asList(DUMMY_PLUGIN, DUMMY_PLUGIN),
        IndexMetadata indexMetadata = spy(
 * not use this file except in compliance with the License.
        previousClusterState = clusterState;
        );
        clusterState = IngestService.innerPut(putRequest, clusterState);
        }).when(processor).execute(eqIndexTypeId(emptyMap()), any());
        final IndexMetadata indexMetadata3 = mock(IndexMetadata.class);
        PutPipelineRequest putRequest = new PutPipelineRequest(
        private final IngestDocument ingestDocument;
 * Modifications Copyright OpenSearch Contributors. See
        bulkRequest.add(indexRequest1);
        PutPipelineRequest putRequest = new PutPipelineRequest(
        indexRequest.source(randomAlphaOfLength(10), randomAlphaOfLength(10));
            .source(emptyMap())
                    + "                          \"tag\": \"tagggg\"\n"
            bulkRequest.add(indexRequest);
            handler.accept(documents);
            IngestService.innerDelete(deleteRequest, clusterState);
        // Create pipeline and apply the resulting cluster state, which should update the counter in the right order:
            .source(Collections.emptyMap())
    }
    }
        );
    public void testExecuteBulkRequestInBatchWithException() {
        Map<String, Processor.Factory> systemProcessors = new HashMap<>();
        clusterState = IngestService.innerDelete(deleteRequest, clusterState);
            .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"));
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        processors.put("set", (factories, tag, description, config) -> {
        assertTrue(hasPipeline2);
        final Processor onFailureProcessor = mock(Processor.class);
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        // prepare request
            .source(emptyMap())
        @SuppressWarnings("unchecked")
    public void testBulkRequestExecutionWithFailures() {
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
            "_id1",
        final Map<String, Processor.Factory> systemProcessors = new HashMap<>();
                    return null;
                    + "                    \"on_failure\": [\n"
        );
            Collections.singletonList(indexRequest),
        Processor dummyFinalProcessor = mock(Processor.class);
        }
        // prepare request
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
        @SuppressWarnings("unchecked")
        );
        IndexMetadata.Builder builder = IndexMetadata.builder("idx")
        );
        @SuppressWarnings("unchecked")
        // mock a system pipeline do nothing
        assertThat(pipeline, notNullValue());
        clusterState = IngestService.innerPut(putRequest, clusterState);
            .setFinalPipeline("_none")
            );
        );
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))
            IndexMetadata.builder("_index")
            MediaTypeRegistry.JSON
    }
        doAnswer((InvocationOnMock invocationOnMock) -> {
            100
        assertProcessorStats(0, afterFirstRequestStats, "_id2", 0, 0, 0);
import java.util.function.Consumer;
            .source(emptyMap())
            .setFinalPipeline("_none")
        assertEquals(1, completionHandler.size());
import static org.mockito.Mockito.eq;
        when(clusterService.getClusterSettings()).thenReturn(
                mock(NamedXContentRegistry.class),
            .setFinalPipeline("_none")
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getFinalPipeline());
            .setFinalPipeline("_none")
            new BytesArray("{\"processors\": [{\"mock\": {}}], \"description\": \"_description\"}"),
        return Collections.singletonMap(key, value);
    }
        expectThrows(IllegalStateException.class, () -> ingestService.validatePipeline(ingestInfos, putRequest));
            .setFinalPipeline("final_pipeline")
        final IntConsumer dropHandler = mock(IntConsumer.class);
        IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder("name1")
            handler.accept((IngestDocument) args.getArguments()[0], null);
            completionHandler,
        Client client = mock(Client.class);
            null,
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getPipeline());
        IndexRequest indexRequest2ChildSlot1 = new IndexRequest("_index").id("_id2")
            .setFinalPipeline("_none")
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        pipeline3 = new PipelineConfiguration(
 * The OpenSearch Contributors require contributions made to
        assertThat(ingestService.pipelines().get("_id").pipeline.getProcessors().size(), equalTo(1));
                    ingestDocument.setFieldValue(metadata.getFieldName(), versionType);
            Collections.singletonList(processor),
        HashMap<String, PipelineConfiguration> pipelines = new HashMap<>();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            "_id3",
            pipeline.getDescription(),
        );
        assertThat(pipeline, notNullValue());
        PutPipelineRequest putRequest = new PutPipelineRequest(
        Metadata metadata = Metadata.builder().put(builder).build();
            }
            bulkRequest.requests(),
            MediaTypeRegistry.JSON
            .source(emptyMap())
        when(processor.getType()).thenReturn("mock");
 * software distributed under the License is distributed on an
        when(indexMetadata.getIndex()).thenReturn(index);
            MediaTypeRegistry.JSON
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
            .setSystemIngestPipeline("_none");
        assertEquals(1, completionHandler.size());
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1").source(emptyMap()).setPipeline("_id").setFinalPipeline("_none");
            )
        assertEquals(4, batches.size());
        assertThat(pipeline, nullValue());
import java.util.List;
            builder.field("data", "This is my data".getBytes(StandardCharsets.UTF_8));
        assertProcessorStats(1, afterForthRequestStats, "_id1", 2, 0, 0); // carried forward and added from old stats
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
        @SuppressWarnings("unchecked")
        final List<Integer> dropHandler = new ArrayList<>();
 *
                    + "                          \"on_failure\": [\n"
    }
        Map<String, Processor.Factory> map = new HashMap<>(2);
            MediaTypeRegistry.JSON
        verify(failureHandler, never()).accept(any(), any());
            .setSystemIngestPipeline("[_index/template]")
        cache.cachePipeline("[" + index3.getName() + "/template]", dummyPipeline, 10);
        ingestService.innerUpdatePipelines(ingestMetadata);
        clusterState = IngestService.innerPut(putRequest, clusterState);
            1,
        );
        String id = "_id";
            indexReq -> {},
            clusterService,
        final List<Integer> dropHandler = new ArrayList<>();
        String pipelineId = "_id";
                    + "          {\n"
            boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
                .numberOfShards(1)
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
            .setSystemIngestPipeline("_none");
        metadata = Metadata.builder().put(templateBuilder).build();
    public void testResolveSystemIngestPipeline_whenExistingIndex() throws Exception {
        assertThat(indexRequest.isPipelineResolved(), is(true));
            .metadata(Metadata.builder(Metadata.EMPTY_METADATA).put(v1Template).build())
        assertThat(indexRequest.isPipelineResolved(), is(true));
        verify(mockCompoundProcessor, never()).execute(any(), any());
        assertTrue(failure.get());
        IndexRequestWrapper wrapper3 = createIndexRequestWrapper(
            1,
        assertThat(indexRequest.getPipeline(), equalTo("_none"));
                mock(SystemIngestPipelineCache.class)
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals("remove", e.getMetadata("opensearch.processor_type").get(0));
                    throw new IllegalStateException("error");
import org.opensearch.cluster.ClusterState;
        // will not be handled as not valid document type
            completionHandler::put,
        // verify defaults
    }
        when(indexMetadata3.getIndex()).thenReturn(index3);
        when(indexMetadata.getIndex()).thenReturn(new Index("_index", "uuid"));
        @SuppressWarnings("unchecked")
        @Override
        ingestInfos.put(node2, new IngestInfo(Arrays.asList(new ProcessorInfo("set"))));
        IngestMetadata ingestMetadata = new IngestMetadata(Collections.singletonMap("_id", pipeline));
        }).when(defaultProcessor).batchExecute(any(), any());
            1,
        Processor dummyProcessor = mock(Processor.class);
        final Map<Integer, Exception> failureHandler = new HashMap<>();
    private CompoundProcessor mockCompoundProcessor() {
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        // verify
        doAnswer(args -> {
                .setPipeline(pipelineId)
        IngestService ingestService = createIngestServiceWithProcessors(emptyMap());
            public IngestDocument execute(final IngestDocument ingestDocument) {
        verify(systemIngestPipelineCache, times(1)).cachePipeline(any(), any(), anyInt());
            .setPipeline("pipeline")
        final IndexMetadata indexMetadata = spy(
            IndexMetadata.builder("_index")
        final Map<String, IndexMetadata> currentIndices = Map.of("index1", indexMetadata1, "index2", changedIndexMetadata2);
            failureHandler,
            OpenSearchParseException.class,
        assertThat(pipeline.getDescription(), nullValue());
        IngestService ingestService = createIngestServiceWithProcessors();
                return systemProcessors;
        // add pipeline
        );
        when(processor.getType()).thenReturn("mock_processor_type");
                .numberOfReplicas(0)
        final Processor processor = mock(Processor.class);
        when(changedIndexMetadata2.getIndex()).thenReturn(index2);
        PutPipelineRequest putRequest = new PutPipelineRequest(
            equalTo("this is a place holder pipeline, because pipeline with" + " id [_id] could not be loaded")
        bulkRequest.add(indexRequest2);
        ClusterState previousClusterState = clusterState;
        verify(cache, times(2)).getSystemIngestPipeline(eq("[idx/uuid]"));
        PutPipelineRequest putRequest = new PutPipelineRequest(
            new BytesArray(
        );
import static org.hamcrest.Matchers.sameInstance;
        IngestService ingestService = createIngestServiceWithProcessors();
    }
        boolean hasPipeline = ingestService.resolvePipelines(indexRequest, indexRequest, state.metadata());
            @Override
            Collections.singletonMap("mock", (factories, tag, description, config) -> compoundProcessor)
        // processor
 * this file be licensed under the Apache-2.0 license or a
        );
    private static <K, V> Map<K, V> mapOf(K key1, V value1, K key2, V value2, K key3, V value3) {
    public void testExecuteFailure() throws Exception {
        // verify
        );
            public String getDescription() {
    }
        ingestService.executeBulkRequest(
            .setPipeline("_id")
        }
        final CompoundProcessor compoundProcessor = new CompoundProcessor(
        assertThat(pipeline.getProcessors().size(), equalTo(1));
        ClusterState previousClusterState = clusterState;
    public void testResolveSystemIngestPipeline_whenUseTemplateV1() throws Exception {
                (integer, e) -> {},
            }
        when(pipelineProcessor.getType()).thenReturn(name);
            .setPipeline("_none")
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getFinalPipeline());
        assertPipelineStats(afterThirdRequestStats.getPipelineStats(), "_id1", 2, 0, 0);
            return new WrappingProcessorImpl("remove", tag, description, (ingestDocument -> ingestDocument.removeField(field))) {
    public void testExecuteBulkRequestInBatchFallbackWithOneDocument() {
        cache.cachePipeline(index2.toString(), dummyPipeline, 10);
                .putMapping("{}")
                    + "              \"tag\": \"tagggg\"\n"
        assertThat(ingestService.pipelines().get("_id3").pipeline.getProcessors().get(0).getType(), equalTo("set"));
        );
        doAnswer(invocationOnMock -> {
import static java.util.Collections.emptyMap;
import java.util.Collections;
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
        ClusterState previousClusterState = clusterState;
        verify(failureHandler, times(1)).accept(
            Names.WRITE
    public void testResolvePipelines_whenExistingIndex() throws Exception {
            Metadata metadata = Metadata.builder().put(builder).build();
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        IndexRequest indexRequest4 = new IndexRequest("_index").id("_id4")
        );
            .setSystemIngestPipeline("_none");
        );
            Metadata metadata = Metadata.builder().build();
            .setFinalPipeline("_none")
        ClusterState previousClusterState = clusterState;
            .source(emptyMap())
    }
    }
                    + "{\"remove\" : {\"field\": \"_field\", \"tag\": \"tag2\"}}]}"
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(Arrays.asList("idx*"), null, null, null, null, null, null);
        verify(failureHandler, times(1)).accept(eq(0), any(RuntimeException.class));
    }
        assertThat(IngestService.getProcessorName(pipelineProcessor), equalTo(name + ":" + pipelineName + ":" + tag));
        }
        ingestService.executeBulkRequest(
        assertThat(indexRequest.getFinalPipeline(), equalTo("final-pipeline"));
    public void testGetPipelines() {
            argThat((IllegalArgumentException iae) -> "pipeline with id [does_not_exist] does not exist".equals(iae.getMessage()))
            );
import static org.hamcrest.Matchers.is;
            failureHandler,
        clusterState = ClusterState.builder(clusterState)
        assertThat(pipeline.getId(), equalTo("_id"));
            .numberOfShards(1)
        );
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
            failureHandler,
        // total
        public boolean matches(IngestDocument o) {
            @Override
        UpdateRequest updateRequest = new UpdateRequest("idx", "id1").upsert(emptyMap()).script(mockScript("1"));
        ingestService.getClusterService().getClusterSettings().applySettings(newSettings);
            bulkRequest.requests(),
        clusterState = IngestService.innerPut(putRequest, clusterState);
        bulkRequest.add(indexRequest1);
        assertStats(stats.getProcessorStats().get(pipelineId).get(processor).getStats(), count, failed, time);
                Names.WRITE
            .execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());
            1,
        );
import java.util.Set;
        clusterState = IngestService.innerPut(putRequest, clusterState);
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
                    Level.WARN,
        final BiConsumer<Integer, Exception> failureHandler = (slot, e) -> {
        IndexRequest indexRequest3ChildSlot1 = new IndexRequest("_index").id("_id3")
        IndexRequestWrapper wrapper2 = createIndexRequestWrapper(
            public Map<String, Processor.Factory> getSystemIngestProcessors(Processor.Parameters parameters) {
        systemIngestPipelineCache.cachePipeline(
import org.opensearch.transport.client.Requests;
            .source(emptyMap())
        boolean hasPipeline = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
        verify(mockCompoundProcessor, times(1)).batchExecute(any(), any());
                .setPipeline(pipelineId)
        assertThat(ingestService.pipelines().get("_id1").pipeline.getProcessors().size(), equalTo(0));
        }
        IngestService ingestService = createIngestServiceWithProcessors(
            failureHandler,
                } else {
import org.opensearch.core.index.Index;
        // call
        assertThat(indexRequest.getFinalPipeline(), equalTo("final-pipeline"));
        {
    }
 * compatible open source license.
        BulkRequest bulkRequest = new BulkRequest();
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        assertThat(pipeline.getDescription(), nullValue());
        result = ingestService.resolvePipelines(updateRequest, TransportBulkAction.getIndexWriteRequest(updateRequest), metadata);
            ),
    public void testDeleteUsingWildcard() {
            null,
        assertThat(pipeline.getProcessors().size(), equalTo(1));
    public void testValidateProcessorCountForWithNestedOnFailureProcessorThrowsException() {
        assertThat(result, is(true));
                    + "                  \"set\": {\n"
        ClusterState previousClusterState = clusterState;
        assertThat(IngestService.getProcessorName(processor), equalTo(name + ":" + tag));
        expectThrows(IllegalStateException.class, () -> ingestService.validatePipeline(ingestInfos, putRequest));
        ClusterState previousClusterState = clusterState;
        afterFirstRequestStats.getProcessorStats().get("_id2").forEach(p -> assertEquals(p.getName(), "mock:mockTag"));
                    + "{\"remove\" : {\"field\": \"_field\", \"tag\": \"tag2\"}}]}"
        Metadata metadata = Metadata.builder().indices(Map.of("idx", indexMetadata)).build();
        ingestService.innerUpdatePipelines(ingestMetadata);
            MediaTypeRegistry.JSON
        );
        final Exception exception = assertThrows(RuntimeException.class, () -> createIngestServiceWithProcessors(processors, processors));
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
        );
            return null;
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        clusterState = IngestService.innerPut(putRequest, clusterState);
        bulkRequest.add(indexRequest1);
        ingestService.validatePipeline(ingestInfos, putRequest);
        List<List<IndexRequestWrapper>> batches = IngestService.prepareBatches(2, Arrays.asList(wrapper1, wrapper2, wrapper3, wrapper4));
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
            Collections.singletonList(indexRequest),
        assertTrue(e.getMessage(), e.getMessage().contains("already registered"));
            .numberOfShards(1)
        pipelines = IngestService.innerGetPipelines(ingestMetadata, "_id1", "_id2");
        indexRequest.setPipeline("_id1");
            indexReq -> {},
            indexRequest.source(Requests.INDEX_CONTENT_TYPE, "field1", "value1");
            Names.WRITE
        assertThat(indexRequest.index(), equalTo("update_index"));
        final Index index1 = new Index("index1", "uuid1");
            .setSystemIngestPipeline("_none");
                .putMapping("{}")
        ClusterState previousClusterState = clusterState;
                .settings(settings(Version.CURRENT))
        // Second time use the cache directly
        @SuppressWarnings("unchecked")
            1,
        assertThat(ingestService.pipelines().get("_id3").pipeline.getProcessors().size(), equalTo(0));
        IngestService ingestService = createIngestServiceWithProcessors(Map.of(), systemProcessors);
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer<List<IngestDocumentWrapper>>) invocationOnMock.getArguments()[1];
        assertThat(stats.getFailedCount(), equalTo(failed));
        ThreadPool threadPool = mock(ThreadPool.class);
            new BytesArray("{\"processors\": [{\"test\" : {}}]}"),
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                return null;
    private IngestDocument eqIndexTypeId(final Map<String, Object> source) {
            Metadata metadata = Metadata.builder().put(builder).build();
            Collections.singletonMap("mock", (factories, tag, description, config) -> compoundProcessor)
        final Map<String, Processor.Factory> systemProcessors = createDummyMockSystemProcessors(dummySystemProcessor, false);
            @SuppressWarnings("unchecked")
        BulkRequest bulkRequest = new BulkRequest();
        final Map<String, Processor.Factory> processors = new HashMap<>();
        );
        DiscoveryNode node2 = new DiscoveryNode("_node_id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        ClusterState previousClusterState = clusterState;
            .numberOfReplicas(0)
        String errorMessage = String.format(
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer) args.getArguments()[1];
        final Metadata currentMetadata = mock(Metadata.class);
            @SuppressWarnings("unchecked")
    public void testExecuteBulkRequestWithSystemPipelineButCacheNotAvailable() throws Exception {
            }).when(dummySystemProcessor).batchExecute(any(), any());
    }
            .execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer) args.getArguments()[1];
            // Collect exceptions into a map of slots to list to inspect later
        // call
        when(indexMetadata.getIndex()).thenReturn(index);
        final IngestService ingestService = createIngestServiceWithProcessors();
            Arrays.asList(testPlugin),
            "_id",
        assertThat(stats.getCurrent(), equalTo(0L));
            dropHandler::add,
            assertThat(indexRequest.getPipeline(), equalTo("request-pipeline"));
    }
        XContentType xContentType = randomFrom(
        bulkRequest.add(new DeleteRequest("_index", "_id"));
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))
            indexReq -> {},
    }
        PutPipelineRequest putRequest = new PutPipelineRequest(
                    + "    }\n"
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2").source(emptyMap()).setPipeline("_id").setFinalPipeline("_none");
                    + "                        \"set\": {\n"
        return createIngestServiceWithProcessors(processors, systemProcessors);
        PutPipelineRequest putRequest = new PutPipelineRequest(
        final Map<String, Processor.Factory> systemProcessors = createDummyMockSystemProcessors(dummySystemProcessor, true);
    public void testDelete() {
        bulkRequest.add(indexRequest4);
        clusterState = IngestService.innerPut(putRequest, clusterState);
        assertThat(pipeline.getDescription(), equalTo("_description"));
                    + "                            {\n"
        IngestService ingestService = createIngestServiceWithProcessors(Map.of(), systemProcessors);
            Locale.ROOT,
            MediaTypeRegistry.JSON
        List<PipelineConfiguration> pipelines = IngestService.innerGetPipelines(ingestMetadata, "_id1");
        // prepare handler
        systemIngestPipelineCache.cachePipeline(
        when(conditionalProcessor.getInnerProcessor()).thenReturn(processor);
        assertThat(initialStats.getPipelineStats().size(), equalTo(0));
        assertTrue(failureHandler.isEmpty());
        @SuppressWarnings("unchecked")
        String longId = "a".repeat(512) + "a";
            failureHandler::put,
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            .source(emptyMap())
        final CompoundProcessor processor = mockCompoundProcessor();
            .setFinalPipeline("_final")
            .source(emptyMap())
            assertThat(indexRequest.getPipeline(), equalTo(NOOP_PIPELINE_NAME));
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
        );
    public void testExecuteBulkRequestSingleRequestWithSystemPipeline() throws Exception {
        final IngestService ingestService = createIngestServiceWithProcessors(
        final Map<String, Processor.Factory> systemProcessors = createDummyMockSystemProcessors(dummySystemProcessor, false);
            indexReq -> {},
        ClusterState previousClusterState = clusterState;
            1,
        verify(processor).execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());
        map.put("mock", (factories, tag, description, config) -> processor);
                    + "                        }\n"
            MediaTypeRegistry.JSON
                new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
        {
        ClusterState previousClusterState = clusterState;
        ingestService.executeBulkRequest(
        ClusterState previousClusterState = clusterState;
                .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))
        IngestService ingestService = createIngestServiceWithProcessors();
        final IngestStats initialStats = ingestService.stats();
        doAnswer(args -> {
            failureHandler,
                Collections.singletonList(indexRequest),
    @Mock
        assertTrue(failureHandler.isEmpty());
        assertEquals(failureHandler.get(1).size(), 1);
            "Pipeline id [%s] exceeds maximum length of 512 UTF-8 bytes (actual: 513 bytes)",
        when(currentMetadata.indices()).thenReturn(currentIndices);
            .setPipeline("_id")
        IndexRequest indexRequest2ChildSlot0 = new IndexRequest("_index").id("_id2")
        ingestService.getClusterService().getClusterSettings().applySettings(newSettings);
                IndexRequest indexRequest = new IndexRequest("_index").id("_id").source(Requests.INDEX_CONTENT_TYPE, "field1", "value1");
        BiConsumer<Integer, Exception> requestItemErrorHandler = mock(BiConsumer.class);
        assertTrue(hasPipeline);
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer<IngestDocument, Exception>) invocationOnMock.getArguments()[1];
            "index1",
        final SetOnce<Boolean> failure = new SetOnce<>();
    }
import org.opensearch.OpenSearchParseException;
    }
            .setSystemIngestPipeline("_none");
            completionHandler,
        assertEquals(1, completionHandler.size());
            .setSystemIngestPipeline("_none");
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            .setSystemIngestPipeline("_none");
        final Map<Integer, Exception> failureHandler = new HashMap<>();
 * You may obtain a copy of the License at
        ingestService.getClusterService()
            MediaTypeRegistry.JSON
        doAnswer(args -> {
        List<IngestDocumentWrapper> results = Arrays.asList(
            mock(NamedXContentRegistry.class),
            .isPipelineResolved(true);
        assertThat(indexRequest.id(), equalTo("update_id"));
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        DeletePipelineRequest deleteRequest = new DeletePipelineRequest("z*");
            .isPipelineResolved(true);
        ingestService.executeBulkRequest(
        pipeline = ingestService.getPipeline(id);
        final Map<Integer, Exception> failureHandler = new HashMap<>();
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
                    + "        \"on_failure\": [\n"
            .setFinalPipeline("final_pipeline")
        // verify
        );
            .setPipeline("_id")
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
        bulkRequest.add(indexRequest3ChildSlot0);
        assertProcessorStats(0, afterForthRequestStats, "_id1", 1, 1, 0); // not carried forward since type changed
        BulkRequest bulkRequest = new BulkRequest();
        final IndexRequest indexRequest = new IndexRequest("idx");
        assertThat(stats.getCount(), equalTo(count));
            null,
        doAnswer(args -> {
        assertThat(ingestService.getProcessorsInPipeline(id, ConditionalProcessor.class).size(), equalTo(0));
            indexReq -> {},
                .build()
        @SuppressWarnings("unchecked")
        // verify we resolve the system pipeline again and then cache it
    }
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
                .numberOfShards(1)
        verify(failureHandler, never()).accept(eq(0), any(IngestProcessorException.class));
            Names.WRITE
        clusterState = ClusterState.builder(clusterState)
        bulkRequest.add(indexRequest1);
    private IngestDocument eqIndexTypeId(final Long version, final VersionType versionType, final Map<String, Object> source) {
        assertNull(indexRequest1.getFinalPipeline());
            .putAlias(AliasMetadata.builder("alias").writeIndex(true).build());
        final boolean hasPipeline,
            failureHandler,
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setFinalPipeline("_none")
        ingestService.addIngestClusterStateListener(ingestClusterStateListener);
        Map<DiscoveryNode, IngestInfo> ingestInfos = new HashMap<>();
        bulkRequest.add(indexRequest3);
        final Index index2 = new Index("index2", "uuid2");
            .setSystemIngestPipeline("_none");
            builder.endObject();
        BulkRequest bulkRequest = new BulkRequest();
        assertThat(result, is(true));
            indexReq -> {},
                .numberOfShards(1)
            .setPipeline("_none")
    }
        assertThat(result, is(true));
            Names.WRITE
import org.opensearch.action.update.UpdateRequest;
    }
        }), client, mock(IndicesService.class), mock(NamedXContentRegistry.class), spy(new SystemIngestPipelineCache()));
        } catch (ResourceNotFoundException e) {
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor())
            .setPipeline("_none")
            "_id",
import org.opensearch.core.xcontent.NamedXContentRegistry;
        Settings newSettings = Settings.builder().put("cluster.ingest.max_number_processors", 7).build();
        clusterState = IngestService.innerPut(putRequest, clusterState);
        assertThat(ingestService.getPipeline("p1"), notNullValue());
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
import org.opensearch.core.xcontent.MediaTypeRegistry;
            @Override
        doThrow(new RuntimeException()).when(processor)
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
import java.util.concurrent.ExecutorService;
        threadPool = mock(ThreadPool.class);
        final String versionType = randomFrom("internal", "external", "external_gt", "external_gte");
        // prepare request
        BulkRequest bulkRequest = new BulkRequest();
        assertEquals("tag2", e.getMetadata("opensearch.processor_tag").get(0));
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
        final List<Integer> dropHandler = new ArrayList<>();
            MediaTypeRegistry.JSON
        Map<DiscoveryNode, IngestInfo> ingestInfos = new HashMap<>();
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        final IngestService ingestService = createIngestServiceWithProcessors();
        }
        @SuppressWarnings("unchecked")
    }
        final IndexRequest indexRequest = new IndexRequest("_index");
        @SuppressWarnings("unchecked")
                .setSystemIngestPipeline("_none");
        // The slots should have the correct number of failures
            "index1",
            4,
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        boolean hasPipeline = ingestService.resolveSystemIngestPipeline(indexRequest, indexRequest, state.metadata());
 * license agreements. See the NOTICE file distributed with
                    + "                  \"set\": {\n"
        ingestService.executeBulkRequest(
            IngestDocument ingestDocument = (IngestDocument) args.getArguments()[0];
            .setSystemIngestPipeline("_none");
            .setSystemIngestPipeline("_none");
        BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            mockAppender.addExpectation(
            .setPipeline("_id")
        for (int i = 0; i < numOtherRequests; i++) {
    }
        final Map<Thread, Exception> completionHandler = new HashMap<>();
            .source(emptyMap())
        @SuppressWarnings("unchecked")
    public void testResolveFinalPipeline() {
                    + "}"
import org.opensearch.index.VersionType;
        final BiConsumer<Integer, Exception> failureHandler = (slot, e) -> {
        assertNotNull(pipeline);
        };
        // Sanity check that counter has been updated twice:
        bulkRequest.add(indexRequest4);
        ingestService.innerUpdatePipelines(ingestMetadata);
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer) args.getArguments()[1];
            "_id",
                    + "                    \"field\": \"ingest_error2\",\n"
        final List<Integer> dropHandler = new ArrayList<>();
    }
            @SuppressWarnings("unchecked")
        clusterState = createPipeline("pipeline", new BytesArray("{\"processors\": [{\"default\" : {}}]}"), ingestService, clusterState);
        String id = "_id";
            .setFinalPipeline("_none");
            .setFinalPipeline("_none")
        IngestService ingestService = createIngestServiceWithProcessors(
        assertPipelineStats(afterSecondRequestStats.getPipelineStats(), "_id1", 1, 0, 0);
        int numRequest = scaledRandomIntBetween(8, 64);
            .setFinalPipeline("_none");
            client,
        ClusterState previousClusterState = clusterState;
        ingestService.executeBulkRequest(
                    + "                    ]\n"
                    + "                    \"tag\": \"tagggg\",\n"
            "_id",
        @SuppressWarnings("unchecked")
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);
    public void testExecutePropagateAllMetadataUpdates() throws Exception {
        final IndexMetadata indexMetadata2 = mock(IndexMetadata.class);
                .settings(settings(Version.CURRENT).put(IndexSettings.FINAL_PIPELINE.getKey(), "final-pipeline"))
        doAnswer(args -> {
        IngestService ingestService = createIngestServiceWithProcessors(
            .source(emptyMap())
    public void testValidate() throws Exception {
            dropHandler::add,
            MediaTypeRegistry.JSON
        assertEquals(errorMessage, e.getMessage());
                } else if (metadata == IngestDocument.Metadata.VERSION_TYPE) {
            "_id",
        );
    public static IngestService createIngestServiceWithProcessors(Map<String, Processor.Factory> processors) {
            "_id",
        // update cluster state and ensure that new stats are added to old stats
                "{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\", \"tag\": \"tag1\"}},"
        assertThat(indexRequest.getFinalPipeline(), equalTo("final-pipeline"));
            .setPipeline("_id")
import java.nio.charset.StandardCharsets;
        // will not be handled as not valid document type
        assertThat(IngestService.getProcessorName(processor), equalTo(name));
        PutPipelineRequest putRequest = new PutPipelineRequest(
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer<List<IngestDocumentWrapper>>) invocationOnMock.getArguments()[1];
        IndexRequestWrapper wrapper3 = createIndexRequestWrapper(
        final Index index3 = new Index("index3", "uuid3");
            assertThat(indexRequest.isPipelineResolved(), is(true));
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            ),
        @NonNull final SystemIngestPipelineCache cache
        final List<Integer> dropHandler = new ArrayList<>();
        assertThat(result, is(true));
            MediaTypeRegistry.JSON
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")
                    null,
            "index2",
        final Map<String, IndexMetadata> previousIndices = Map.of(
        when(clusterService.getClusterSettings()).thenReturn(
            null,
        when(previousMetadata.indices()).thenReturn(previousIndices);
        assertThat(indexRequest.ifSeqNo(), equalTo(ifSeqNo));
                    + "        ]\n"
    }
        assertTrue(dropHandler.isEmpty());
        assertThat(ingestService.getProcessorsInPipeline(id, WrappingProcessorImpl.class).size(), equalTo(1));
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        processors.put("complexSet", (factories, tag, description, config) -> {
        String pipelineName = randomAlphaOfLength(10);
                null,
        // add a new pipeline:
            ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            failureHandler,
            .setPipeline("_id")
            buildNewFakeTransportAddress(),
                .putMapping("{}")
            String value = (String) config.remove("value");
            .setFinalPipeline("_none")
            List.of(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT), new IngestPipelineInfo("p2", IngestPipelineType.DEFAULT))
        );
 * Licensed to Elasticsearch under one or more contributor
            return null;
        MatcherAssert.assertThat(completionHandler.keySet(), contains(Thread.currentThread()));
        // Test to make sure that ingest respects content types other than the default index content type
        // mock
        }
        return createIngestServiceWithProcessors(processors, Collections.emptyMap());
        assertEquals(3, clusterSettings.get(IngestService.MAX_NUMBER_OF_INGEST_PROCESSORS).intValue());
        // will not be handled as not valid document type
    public void testIngestClusterStateListeners_orderOfExecution() {
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        assertThat(ingestService.pipelines().get("_id2").pipeline.getProcessors().size(), equalTo(0));
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        assertThat(ingestService.pipelines().get("_id1").pipeline.getProcessors().size(), equalTo(0));
        PutPipelineRequest putRequest = new PutPipelineRequest(
        // We add a default pipeline to index metadata to verify we DO NOT resolve it (only system pipeline)
        @SuppressWarnings("unchecked")
            .setPipeline("_id")
        @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
            "index1",
        // index name matches with ITMD:
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        ClusterState clusterState = createPipeline("_id", ingestService);
import org.opensearch.core.common.bytes.BytesArray;
        BulkRequest bulkRequest = new BulkRequest();
        assertThat(IngestService.innerGetPipelines(null, "_id1").isEmpty(), is(true));
 * ownership. Elasticsearch licenses this file to you under
            3,
                    new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
            boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
            MediaTypeRegistry.JSON
        assertThat(ingestService.getProcessorsInPipeline(id, ConditionalProcessor.class).size(), equalTo(2));
        ingestService.executeBulkRequest(
        final IngestService ingestService = createIngestServiceWithProcessors();
        );
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
    public void testIngestPluginDuplicate() {
            handler.accept(null, new RuntimeException());
                @Override
                .numberOfReplicas(0)
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
        // processor
        );
        IngestService.innerDelete(matchAllDeleteRequest, clusterState);
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
    }
import org.opensearch.cluster.metadata.Metadata;
            Names.WRITE
            "_id",
        assertThat(pipeline.getProcessors().size(), equalTo(0));
        map.put(key1, value1);
            @Override
            "_id",
            assertThat(indexRequest.isPipelineResolved(), is(true));
        when(dummySystemProcessor.isSystemGenerated()).thenReturn(true);
            .metadata(Metadata.builder().putCustom(IngestMetadata.TYPE, ingestMetadata))
        verify(mockCompoundProcessor, times(1)).execute(any(), any());
            indexReq -> {},
        UpdateRequest updateRequest = new UpdateRequest("idx", "id1").upsert(emptyMap()).script(mockScript("1"));
                    + "                          \"value\": \"failed\",\n"
import java.util.Locale;
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        IndexRequest indexRequest4 = new IndexRequest("_index").id("_id4")
            failureHandler::put,
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
            client,
                    + "            \"set\": {\n"
        List<IngestDocumentWrapper> results = Arrays.asList(
                .setFinalPipeline("_none")
        assertThat(ingestService.getProcessorsInPipeline(id, WrappingProcessor.class).size(), equalTo(2));
        MatcherAssert.assertThat(errorHandler.entrySet(), hasSize(numIndexRequests));
            .source(emptyMap())
                .setFinalPipeline("_none")
            completionHandler::put,
            IllegalArgumentException.class,
    public void testValidatePipelineId_WithNotValidLength_ShouldThrowException() throws Exception {
                BiConsumer<IngestDocument, Exception> handler = (BiConsumer<IngestDocument, Exception>) invocationOnMock.getArguments()[1];
        ingestService.executeBulkRequest(
        ingestService.executeBulkRequest(
    public void testExecuteWithDrop() {
        assertEquals(1, factories.size());
        Map<String, Processor.Factory> systemFactories = ingestService.getSystemProcessorFactories();
                IngestDocument ingestDocument = (IngestDocument) invocationOnMock.getArguments()[0];
            .setFinalPipeline("_none");
        Map<String, Processor.Factory> systemProcessors
            return Objects.equals(ingestDocument.getSourceAndMetadata(), o.getSourceAndMetadata());
        bulkRequest.add(indexRequest1);
        doAnswer(args -> {
            }
    };
        @SuppressWarnings("unchecked")
        clusterState = IngestService.innerPut(putRequest, clusterState);
            .source(emptyMap())
        );
        // add index metadata for the new index
        clusterState = IngestService.innerPut(putRequest, clusterState);
            .setPipeline("_id")
    }
    public void testExecuteBulkRequestInBatchWithDefaultBatchSize() {
            bulkRequest.requests(),
        return systemProcessors;
        ClusterState previousClusterState = clusterState;
            }
            new IngestDocumentWrapper(0, 0, IngestService.toIngestDocument(indexRequest1), null),
import org.opensearch.cluster.service.ClusterService;
                    scriptService,
    public void testExecuteBulkRequestInBatchWithExceptionAndDropInCallback_requestsWithMatchingChildSlots() {
                .setPipeline("_id")
        assertThat(pipelines.get(0).getId(), equalTo("_id1"));
    private Map<String, Processor.Factory> createDummyMockSystemProcessors(Processor dummySystemProcessor, boolean isBatch)
            IndexMetadata.Builder builder = IndexMetadata.builder("idx")
import static org.mockito.Mockito.spy;
        ingestService.applyClusterState(new ClusterChangedEvent("_name", clusterState, clusterState));
        @SuppressWarnings("unchecked")
            .setSystemIngestPipeline("_none");
            indexReq -> {},
            completionHandler,
        throws Exception {
            (factories, tag, description, config) -> new CompoundProcessor(false, List.of(defaultProcessor), List.of())
            .setSystemIngestPipeline("_none");
            .setFinalPipeline("_final")
        verify(mockCompoundProcessor, times(2)).batchExecute(any(), any());
            failureHandler,
        IngestService ingestService = createIngestServiceWithProcessors(
        assertThat(ingestService.getPipeline("q1"), notNullValue());
        assertPipelineStats(afterForthRequestStats.getPipelineStats(), "_id1", 3, 0, 0);
        final AtomicInteger counter = new AtomicInteger(0);
            }
            (factories, tag, description, config) -> new CompoundProcessor(false, List.of(defaultProcessor), List.of())
        assertTrue(factories.containsKey("foo"));
                null,
            public String getType() {
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer) args.getArguments()[1];
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer<IngestDocument, Exception>) invocationOnMock.getArguments()[1];
    private ClusterState createPipeline(String pipeline, BytesArray config, IngestService ingestService, ClusterState previousState) {
        assertThat(ingestService.getPipeline("p1"), notNullValue());
import java.util.Objects;
                mock(ClusterService.class),
        // prepare systemIngestPipelineCache for the case using index template
            ingestService.executeBulkRequest(
            IndexMetadata.builder("idx")
        // prepare test data
        configs.put("_id2", new PipelineConfiguration("_id2", new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON));
        assertThat(indexRequest.ifPrimaryTerm(), equalTo(ifPrimaryTerm));
import static org.mockito.Mockito.mock;
        );
        // pipeline
        );
                .putMapping("{}")
            .setSystemIngestPipeline("_none");
            assertThat(indexRequest.isPipelineResolved(), is(true));
        boolean hasPipeline = ingestService.resolvePipelines(indexRequest, indexRequest, state.metadata());
            new BytesArray("{\"processors\": [], \"description\": \"_description\"}"),
 * SPDX-License-Identifier: Apache-2.0
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        assertThat(ingestService.getPipeline("_id"), nullValue());
        doAnswer(args -> {
    }
        final Map<Thread, Exception> completionHandler = new HashMap<>();
            assertThat(e.getMessage(), equalTo("pipeline [_id] is missing"));
        IngestMetadata ingestMetadata = new IngestMetadata(mapOf("_id1", pipeline1));
        boolean hasPipeline2 = ingestService.resolvePipelines(indexRequest2, indexRequest2, metadata);
            "_id",
        clusterState = IngestService.innerPut(putRequest, clusterState);
            .setFinalPipeline("_none")
        pipeline = ingestService.getPipeline(id);
        assertEquals(Integer.MAX_VALUE, clusterSettings.get(IngestService.MAX_NUMBER_OF_INGEST_PROCESSORS).intValue());
        );
import org.opensearch.script.ScriptService;
        // match all wildcard does not throw exception if none match
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        assertPipelineStats(afterFirstRequestStats.getPipelineStats(), "_id2", 0, 0, 0);
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            .setFinalPipeline("_none")
        assertTrue(indexRequest2.isPipelineResolved());
            .setFinalPipeline("_none")
                    + "          }\n"
            bulkRequest.requests(),
            @SuppressWarnings("unchecked")
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
        ingestService.applyClusterState(new ClusterChangedEvent("", state, state));
import static org.hamcrest.Matchers.contains;
import java.util.HashMap;
        processors.put("remove", (factories, tag, description, config) -> {
            .settings(settings(Version.CURRENT).put(IndexSettings.FINAL_PIPELINE.getKey(), "final-pipeline"))
        bulkRequest.add(indexRequest2);
            id,
        clusterState = IngestService.innerDelete(deleteRequest, clusterState);
                    + "                                \"value\": \"failed\",\n"
    }
    private ThreadPool threadPool;
        assertTrue(hasPipeline);
            "index2",
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);
        assertThat(ingestService.pipelines().get("_id3").pipeline.getProcessors().size(), equalTo(0));
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        ingestService.validatePipeline(Collections.singletonMap(discoveryNode, ingestInfo), putRequest);
            .setSystemIngestPipeline("_none");
        assertEquals("[idx/uuid]", indexRequest2.getSystemIngestPipeline());
                    "failed to update ingest pipelines"
            .setPipeline("_id")
        assertThat(ingestService.pipelines().get("_id1").pipeline.getId(), equalTo("_id1"));
        );
        createPipeline("final_pipeline", new BytesArray("{\"processors\": [{\"dummy\" : {}}]}"), ingestService, clusterState);
        final Map<Thread, Exception> completionHandler = new HashMap<>();
        assertEquals(1, completionHandler.size());
            .setSystemIngestPipeline("_none");
 * this work for additional information regarding copyright
        assertThat(indexRequest.getPipeline(), equalTo("_none"));
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        final Map<Thread, Exception> completionHandler = new HashMap<>();
    public void testPut() {
            IndexRequest indexRequest = new IndexRequest("_index").id("_id")
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
        assertThat(pipelines.size(), equalTo(2));
            2,
    }
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getSystemIngestPipeline());
            assertThat(e, instanceOf(IllegalArgumentException.class));
            handler.accept(results);
        final Metadata previousMetadata = mock(Metadata.class);
    public void testResolveRequiredOrDefaultPipelineDefaultPipeline() {
        );
            .setFinalPipeline("_none")
 */
        ClusterState previousClusterState = clusterState;
    private void assertPipelineStats(List<IngestStats.PipelineStat> pipelineStats, String pipelineId, long count, long failed, long time) {
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
        }).when(dummyFinalProcessor).execute(any(), any());
        assertThat(indexRequest.isPipelineResolved(), is(true));
        PipelineConfiguration pipeline2 = new PipelineConfiguration("_id2", new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON);
                return null;
        IngestService ingestService = createIngestServiceWithProcessors(
import org.opensearch.script.ScriptType;
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(IngestService.class))) {
        assertThat(ingestService.getProcessorsInPipeline(id, WrappingProcessorImpl.class).size(), equalTo(0));
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        pipeline = ingestService.getPipeline(id);
        @SuppressWarnings("unchecked")
        // Exception if we used name which does not exist
        assertThat(pipeline.getProcessors().get(0).getType(), equalTo("unknown"));
        assertThat(pipelines.get(0).getId(), equalTo("_id1"));
        indexRequest = new IndexRequest("alias");
            new Pipeline("id", "description", null, new CompoundProcessor(false, List.of(dummySystemProcessor), Collections.emptyList())),
        assertThat(ingestService.getProcessorsInPipeline(id, Processor.class).size(), equalTo(3));
        // process cluster state change event
        final List<Processor> onFailureProcessors = Collections.singletonList(onFailureOnFailureProcessor);
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        final Map<Thread, Exception> completionHandler = new HashMap<>();
            1,
import static org.hamcrest.Matchers.equalTo;
        IndexRequest indexRequest = new IndexRequest("idx");
            handler.accept((List<IngestDocumentWrapper>) args.getArguments()[0]);
                    + "                        ]\n"
            .source(emptyMap())
        );
            indexReq -> {},
            MediaTypeRegistry.JSON
    }
        clusterState = IngestService.innerPut(putRequest, clusterState);
        } catch (ResourceNotFoundException e) {
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
        assertThat(ingestService.pipelines().get("_id1").pipeline.getId(), equalTo("_id1"));
        cache.cachePipeline(index1.toString(), dummyPipeline, 10);
        verify(failureHandler, never()).accept(any(), any());
            .setSystemIngestPipeline("_none");
            .setPipeline("_id")
            assertThat(e.getCause().getMessage(), equalTo("error"));
    }
            .setPipeline("_id")
            assertThat(indexRequest.getFinalPipeline(), equalTo("final-pipeline"));
            emptySet(),
            IndexMetadata.builder("idx")
        // mock
        verify(mockCompoundProcessor, never()).batchExecute(any(), any());
        assertThat(afterForthRequestStats.getPipelineStats().size(), equalTo(2));
                @Override
                if (metadata == IngestDocument.Metadata.VERSION) {
        }
        );
        // prepare test data and mock
            IngestService.innerDelete(deleteRequest, clusterState);
            null,
        PutPipelineRequest putRequest = new PutPipelineRequest(
        });
        ingestService.executeBulkRequest(4, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
            completionHandler,
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        ClusterState previousClusterState = clusterState;
import static java.util.Collections.emptySet;
        Metadata metadata = Metadata.builder().put(builder).build();
                    + "        \"value\": \"value\",\n"
        assertThat(stats.getTotalTime(), greaterThanOrEqualTo(time));
        assertThat(indexRequest.getPipeline(), equalTo("default-pipeline"));
        // create ingest service and cluster state
        when(systemProcessorFactory.isSystemGenerated()).thenReturn(true);
            }
import static org.hamcrest.Matchers.hasSize;
            1,
            handler.accept(null, new RuntimeException("error"));
        PutPipelineRequest putRequest = new PutPipelineRequest(
        );
        when(pipelineProcessor.getTag()).thenReturn(tag);
                    + "                  }\n"
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        bulkRequest.add(indexRequest1);
    }
        // prepare handler
                    + "  \"processors\": [\n"
        assertThat(pipeline.getId(), equalTo(id));
        );
        ingestInfos.put(node1, new IngestInfo(Arrays.asList(new ProcessorInfo("set"), new ProcessorInfo("remove"))));
                }
        return map;
        return new IngestService(clusterService, threadPool, null, null, null, Collections.singletonList(new IngestPlugin() {
            new BytesArray("{\"processors\": [{\"mock\" : {}}, {\"mock\" : {}}]}"),
        pipelines = IngestService.innerGetPipelines(ingestMetadata, "*");
            handler.accept(ingestDocument, null);
            .setSystemIngestPipeline("_none");
            handler.accept(ingestDocumentWrappers);
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        bulkRequest.add(indexRequest3);
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            @SuppressWarnings("unchecked")
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);
            .setSystemIngestPipeline("_none");
                .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))
            .source(emptyMap())
    }
        @SuppressWarnings("unchecked")
                .build()
        for (int i = 0; i < numRequest; i++) {
 * Unless required by applicable law or agreed to in writing,
        );
            dropHandler::add,
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
        indexRequest = new IndexRequest("idx");
    @Mock
        );
            .setPipeline("pipeline")
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
            Names.WRITE
        when(indexMetadata.getIndex()).thenReturn(index);
        IngestService ingestService = createIngestServiceWithProcessors(factories);
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(Arrays.asList("idx*"), null, null, null, null, null, null);
import java.util.concurrent.atomic.AtomicInteger;
        final IngestStats afterFirstRequestStats = ingestService.stats();
        return argThat(new IngestDocumentMatcher("_index", "_type", "_id", -3L, VersionType.INTERNAL, source));
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
        // verify
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
        );
                    + "                      {\n"
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
            bulkRequest.requests(),
                    + "                                \"tag\": \"tagggg\"\n"
        map.put("failure-mock", (factories, tag, description, config) -> processorFailure);
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
            "default",
            .source(emptyMap())
                Script.DEFAULT_SCRIPT_LANG,
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
    }
        // mock
        );
        assertThat(IngestService.getProcessorName(conditionalProcessor), equalTo(name + ":" + tag));
        verifySystemPipelineResolvedSuccessfully("[idx/template]", hasPipeline, indexRequest, cache);
        return map;
            indexReq -> {},
            assertThat(result, is(false));
        doThrow(new RuntimeException()).when(onFailureProcessor)
            Names.WRITE
                    + "      }\n"
            MediaTypeRegistry.JSON
        verifySystemPipelineResolvedSuccessfully("[idx/template]", hasPipeline, indexRequest, cache);
        DeletePipelineRequest deleteRequest = new DeletePipelineRequest("p*");
        }).when(processor).execute(any(), any());
                    + "      \"set\": {\n"
                    new FakeProcessor("complexSet", tag, description, (ingestDocument) -> ingestDocument.setFieldValue(field, value))
            MediaTypeRegistry.JSON
                .numberOfReplicas(0);
        ingestMetadata = new IngestMetadata(mapOf("_id1", pipeline1, "_id3", pipeline3));
                } else if (metadata == IngestDocument.Metadata.IF_PRIMARY_TERM) {
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")
    }
        assertNull(completionHandler.get(Thread.currentThread()));
        for (int i = 0; i < 2; ++i) {
        verify(failureHandler, times(1)).accept(eq(0), any(RuntimeException.class));
        assertThat(ingestService.pipelines().get("_id1").pipeline.getProcessors().size(), equalTo(0));
            1,
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        verify(mockCompoundProcessor, never()).execute(any(), any());
        assertThat(ingestService.getProcessorsInPipeline(id, WrappingProcessor.class).size(), equalTo(1));
import static org.hamcrest.Matchers.instanceOf;
        );
        }
            fail("exception expected");
        final Index index = new Index("idx", "uuid");
                    + "                    \"value\": \"failed\",\n"
import org.opensearch.script.MockScriptEngine;
            return null;
            MediaTypeRegistry.JSON
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        // total
        clusterState = IngestService.innerPut(putRequest, clusterState);
import org.opensearch.action.bulk.BulkRequest;
        verify(mockCompoundProcessor, times(1)).batchExecute(any(), any());
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
    }
    }
import org.mockito.invocation.InvocationOnMock;
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        );
import org.mockito.Mock;
        assertThat(indexRequest.versionType(), equalTo(VersionType.fromString(versionType)));
        final Processor dummySystemProcessor = mock(Processor.class);
        assertThat(pipelines.get(0).getId(), equalTo("_id1"));
        // verify
                    ctx.get("_type");
            .source(emptyMap())
        when(processor.getTag()).thenReturn(tag);
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        ClusterService clusterService = mock(ClusterService.class);
            assertThat(slot, equalTo(1));
        assertThat(pipelines.size(), equalTo(2));
            .setSystemIngestPipeline("_none");
        @SuppressWarnings("unchecked")
        // verify
    public void testExecuteSuccessWithOnFailure() throws Exception {
            this.ingestDocument = new IngestDocument(index, id, null, null, null, source);
        ingestService.applyClusterState(new ClusterChangedEvent("", currentClusterState, previousClusterState));
            numRequest,
        assertThat(reference.get(), is(instanceOf(byte[].class)));
            .source(emptyMap())
            );
            completionHandler::put,
        previousClusterState = clusterState;
            threadPool,
        clusterState = createPipeline("pipeline", new BytesArray("{\"processors\": [{\"default\" : {}}]}"), ingestService, clusterState);
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> {
        PipelineConfiguration pipeline3 = new PipelineConfiguration("_id3", new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON);
            @SuppressWarnings("unchecked")
        bulkRequest.add(indexRequest1);
        );
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        public Map<String, Processor.Factory> getSystemIngestProcessors(Processor.Parameters parameters) {
            doAnswer(invocationOnMock -> {
        assertThat(updateRequest.upsertRequest().isPipelineResolved(), is(true));
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        // alias name matches with IDM:
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        IngestService ingestService = createIngestServiceWithProcessors(
            false,
        for (DocWriteRequest<?> docWriteRequest : bulkRequest.requests()) {
            .setPipeline("pipeline")
        indexRequest.setPipeline("_id1").setFinalPipeline("_none");
            return Map.of("foo", mockSystemProcessorFactory);
        createPipeline("_id", ingestService);
        clusterState = IngestService.innerPut(putRequest, clusterState);
    public static IngestService createIngestServiceWithProcessors(
        // The first and second slots should have failures
        final long ifPrimaryTerm = randomNonNegativeLong();
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        // only 1 time for set up
        ExecutorService executorService = OpenSearchExecutors.newDirectExecutorService();
import org.opensearch.common.settings.Settings;
                bulkRequest.add(new DeleteRequest("_index", "_id"));
            new BytesArray(
            } else {
        assertProcessorStats(0, afterFirstRequestStats, "_id1", 1, 0, 0);
        );
    }
        } else {
            mock(NamedXContentRegistry.class),
            failureHandler.computeIfAbsent(slot, i -> new ArrayList<>()).add(exception);
        bulkRequest.add(indexRequest4);
        // processor
    }
        doAnswer(invocationOnMock -> {
        assertTrue(indexRequest.isPipelineResolved());
        ClusterService clusterService = mock(ClusterService.class);
            .setFinalPipeline("_none")
        final IndexRequest indexRequest = new IndexRequest("idx");
        // index name matches with IDM:
        );
        IndexTemplateMetadata v1Template = IndexTemplateMetadata.builder("v1-template").patterns(Arrays.asList("fo*", "baz")).build();
        );
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
    private ClusterState createPipeline(String pipeline, IngestService ingestService) {
/*
            () -> ingestService.getProcessorsInPipeline("fakeID", Processor.class)
        ClusterService clusterService = mock(ClusterService.class);
        final IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        PutPipelineRequest putRequest = new PutPipelineRequest(
        BulkRequest bulkRequest = new BulkRequest();
            .setPipeline("_none")
        ingestService.applyClusterState(new ClusterChangedEvent("", state, state));
        String id = "_id";
            (factories, tag, description, config) -> new CompoundProcessor(false, List.of(dummyFinalProcessor), List.of())
    public void testExecuteSystemPipelineExistsButFailedParsing() {
        assertThat(result, is(true));
            public String getTag() {
        assertThat(ingestService.pipelines().size(), is(2));
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
        );
        Processor processor = mock(Processor.class);
            IndexRequest indexRequest = new IndexRequest("_index").id("_doc-id")
            .setPipeline("pipeline")
        ingestMetadata = new IngestMetadata(mapOf("_id1", pipeline1, "_id2", pipeline2, "_id3", pipeline3));
            assertThat(result, is(true));
        doAnswer(invocationOnMock -> {
        IngestService ingestService = createIngestServiceWithProcessors();
                    + "            ]\n"
    public void testPutWithErrorResponse() throws IllegalAccessException {
        assertThat(pipelines.get(0).getId(), equalTo("_id1"));
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
        }
            .source(emptyMap())
}
            assertThat(slot, equalTo(0));
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
            .setPipeline("_id")
        );
        // initiate ingest service
        assertThat(pipelines.size(), equalTo(2));
        }).when(processor).batchExecute(any(), any());
            () -> new IngestService(
            mock(IndicesService.class),
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        );
            .source(emptyMap())
            .setFinalPipeline("final_pipeline")
            return null;
                }
        pipelines = IngestService.innerGetPipelines(ingestMetadata);
        assertEquals(1, systemFactories.size());
        assertThat(pipelines.get(1).getId(), equalTo("_id2"));
        BulkRequest bulkRequest = new BulkRequest();
        );
        assertTrue(dropHandler.isEmpty());
            failureHandler,
        boolean hasPipeline = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
            return null;
        assertThat(ingestService.getPipeline("q1"), notNullValue());
            return null;
            "_id",
        IndexRequestWrapper wrapper1 = createIndexRequestWrapper(
        final List<Integer> dropHandler = new ArrayList<>();
                    + "                                \"field\": \"ingest_error2\",\n"
            IndexMetadata.Builder builder = IndexMetadata.builder("idx")
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
package org.opensearch.ingest;
        final CompoundProcessor compoundProcessor = new CompoundProcessor(
        );
                    randomAlphaOfLength(10) + "-nested",
        assertThat(pipelines.size(), equalTo(1));
            .source(emptyMap())
        // mock a system pipeline do nothing
        int numOtherRequests = scaledRandomIntBetween(4, 32);
            () -> ingestService.validatePipeline(ingestInfos, putRequest)
        ClusterState previousClusterState = clusterState;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        verify(failureHandler, never()).accept(any(), any());
            completionHandler::put,
import org.opensearch.cluster.ClusterChangedEvent;
        verify(dummySystemProcessor, times(1)).execute(any(), any());
        bulkRequest.add(indexRequest3);
        Settings newSettings = Settings.builder().put("cluster.ingest.max_number_processors", 1).build();
        );
        final Index index = new Index("idx", "uuid");
        ingestService.executeBulkRequest(
        );
    public void testExecuteBulkRequestInBatchWithExceptionAndDropInCallback() {
            .settings(settings(Version.CURRENT).put(IndexSettings.FINAL_PIPELINE.getKey(), "final-pipeline"));
                .numberOfShards(1)
        final IngestStats afterForthRequestStats = ingestService.stats();
            MediaTypeRegistry.JSON
                .build()
        );
    @Before
        final Map<Thread, Exception> completionHandler = new HashMap<>();
import org.opensearch.common.SetOnce;
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        {
                    + "                                \"value\": \"failed\",\n"
        ingestService.applyClusterState(new ClusterChangedEvent("", state, state));
        DiscoveryNode discoveryNode = new DiscoveryNode(
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            .source(emptyMap())
        when(indexMetadata2.getIndex()).thenReturn(index2);
        BulkRequest bulkRequest = new BulkRequest();
            .setPipeline("_id")
        // overwrite existing pipeline:
    private void verifySystemPipelineResolvedSuccessfully(
    }
        result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
 * the Apache License, Version 2.0 (the "License"); you may
        assertStats(afterFirstRequestStats.getTotalStats(), 1, 0, 0);
        verify(systemIngestPipelineCache, times(1)).getSystemIngestPipeline(any());
        // mock a system pipeline do nothing
            clusterService,
        // only 1 time to cache the newly generated pipeline
        );
        IngestService ingestService = createIngestServiceWithProcessors(
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        assertThat(ingestService.pipelines(), sameInstance(pipelines));
            this.ingestDocument = new IngestDocument(index, id, null, version, versionType, source);
            IllegalArgumentException.class,
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        assertThat(pipelines.get(1).getId(), equalTo("_id2"));
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        );
        clusterState = IngestService.innerPut(putRequest, clusterState);
        map.put(key2, value2);
import static org.mockito.Mockito.argThat;
    public void testResolveRequestOrDefaultPipelineAndFinalPipeline() {
            .setSystemIngestPipeline("_none");
            Collections.singletonList(indexRequest),
        final IngestService ingestService = createIngestServiceWithProcessors();
            .setPipeline("_id")
        ClusterState previousClusterState = clusterState;
            new IngestDocumentWrapper(0, 0, IngestService.toIngestDocument(indexRequest1), null),
        PutPipelineRequest putRequest = new PutPipelineRequest(
            return null;
        );
        previousClusterState = clusterState;
        assertTrue(dropHandler.isEmpty());
            Collections.singletonMap("mock", (factories, tag, description, config) -> processor)
                .numberOfReplicas(0)
            completionHandler,
    public void testExecuteBulkRequestInBatchNoValidPipeline() {
        if (previousState != null) {
        assertThat(pipeline.getId(), equalTo(id));
            Collections.singletonMap("mock", (factories, tag, description, config) -> new AbstractProcessor("mock", "description") {
            dropHandler::add,
        assertThat(ingestService.pipelines().size(), is(0));
import org.opensearch.test.MockLogAppender;
                    + "              \"tag\": \"tagggg\",\n"
                });
        assertEquals(Set.of(Thread.currentThread()), completionHandler.keySet());
        Client client = mock(Client.class);
        IngestService ingestService = createIngestServiceWithProcessors();
        BulkRequest bulkRequest = new BulkRequest();
        final Map<String, Processor.Factory> processors = new HashMap<>();
            .source(emptyMap())
        verify(defaultProcessor, times(1)).batchExecute(any(), any());
        }, completionHandler::put, dropHandler::add, Names.WRITE);
            boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
    public void testGetProcessorsInPipeline() throws Exception {
        BulkRequest bulkRequest = new BulkRequest();
            IllegalArgumentException.class,
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
        ingestService.executeBulkRequest(
    public void testValidateNoIngestInfo() throws Exception {
                .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))
        verify(cache, times(1)).cachePipeline(eq(id), any(), eq(Integer.MAX_VALUE));
            IndexMetadata.builder("idx")
        when(indexMetadata.getIndex()).thenReturn(index);
        final Map<Thread, Exception> completionHandler = new HashMap<>();
                null,
            new BytesArray("{\"processors\": [{\"complexSet\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
            .setFinalPipeline("_none")
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")
        ClusterState previousClusterState = clusterState;
    private static final IngestPlugin DUMMY_PLUGIN = new IngestPlugin() {
    public void setup() throws Exception {
        // prepare test data
        assertThat(ingestService.pipelines().get("_id2").pipeline.getId(), equalTo("_id2"));
        verify(mockCompoundProcessor, never()).batchExecute(any(), any());
        assertThat(ingestService.pipelines().size(), is(2));
        pipeline = ingestService.getPipeline(id);
    public void testExecuteEmptyPipelineInBatch() throws Exception {
        // The number of processors for the "id1" pipeline changed, so the per-processor metrics are not carried forward. This is
            MediaTypeRegistry.JSON
                "{\n"
                    ingestDocument.setFieldValue(metadata.getFieldName(), ifSeqNo);
        DiscoveryNode node1 = new DiscoveryNode("_node_id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        bulkRequest.add(indexRequest2);
            .setPipeline("_id")
            "_node_id",
        // mock a final pipeline do nothing
        assertThat(ingestService.pipelines().get("_id1").pipeline.getId(), equalTo("_id1"));
/*
        createPipeline("_id", ingestService);
            .setSystemIngestPipeline("_none");
            .source(emptyMap())
        bulkRequest.add(indexRequest3);
        verify(dummyProcessor, times(1)).batchExecute(any(), any());
        map.put(key3, value3);
            .setSystemIngestPipeline("[_index/template]")
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        );
        DiscoveryNode discoveryNode = new DiscoveryNode(
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        bulkRequest.add(indexRequest2);
        );
        final Processor processor = mock(Processor.class);
            .build();
import org.opensearch.threadpool.ThreadPool.Names;
                return null;
        clusterState = IngestService.innerPut(putRequest, clusterState);
        verifySystemPipelineResolvedSuccessfully("[idx/uuid]", hasPipeline, indexRequest, cache);
        Metadata metadata = Metadata.builder().indices(Map.of("idx", indexMetadata)).build();
            Names.WRITE
        assertThat(indexRequest.isPipelineResolved(), is(true));
        assertNull(cache.getSystemIngestPipeline("[" + index3.getName() + "/template]"));
        assertProcessorStats(0, afterForthRequestStats, "_id2", 1, 0, 0);
            new IngestDocumentWrapper(2, 0, null, null)
            failureHandler::put,
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        assertStats(afterSecondRequestStats.getTotalStats(), 2, 0, 0);
        ClusterService clusterService = mock(ClusterService.class);
        doThrow(new RuntimeException()).when(onFailureOnFailureProcessor)
            .setFinalPipeline("_none")
        assertEquals(failureHandler.get(2).size(), 2);
        factories.put("drop", new DropProcessor.Factory());
            "_id",
        assertThat(ingestService.getProcessorsInPipeline(id, FakeProcessor.class).size(), equalTo(1));
            Names.WRITE
        previousClusterState = clusterState;
            "index1",
        DeletePipelineRequest matchAllDeleteRequest = new DeletePipelineRequest("*");
        IngestService ingestService = createIngestServiceWithProcessors(
        PutPipelineRequest putRequest = new PutPipelineRequest(
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        ClusterState previousClusterState = clusterState;
        Consumer<IngestDocument> executor = doc -> reference.set(doc.getFieldValueAsBytes("data"));
        }
            return null;
        }).when(dummyProcessor).batchExecute(any(), any());
        assertThat(pipelines.get(1).getId(), equalTo("_id2"));
                threadPool,
            IndexRequest indexRequest = new IndexRequest("idx");
            completionHandler,
import org.opensearch.threadpool.ThreadPool;
        ingestService.executeBulkRequest(
                null,
import org.opensearch.transport.client.Client;
            failureHandler,
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
            completionHandler::put,
        verify(failureHandler, never()).accept(any(), any());
            .source(emptyMap())
        // total
        }
        boolean hasPipeline = ingestService.resolveSystemIngestPipeline(indexRequest, indexRequest, metadata);
            .isPipelineResolved(true);
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
            .patterns(Collections.singletonList("id*"))
    }
            "_id",
            List<IngestDocumentWrapper> documents = (List<IngestDocumentWrapper>) invocationOnMock.getArguments()[0];
            .setSystemIngestPipeline("_none");
        factories.put("mock", (processorFactories, tag, description, config) -> new Processor() {
        );
                    + "                          \"value\": \"failed\",\n"
            indexReq -> {},
        PipelineConfiguration config = new PipelineConfiguration(
            completionHandler,
        assertTrue(dropHandler.isEmpty());
            .source(emptyMap())
            "_id",
        bulkRequest.add(indexRequest2ChildSlot1);
        Pipeline pipeline = ingestService.getPipeline(id);
        }
        );
    public void testCrud() throws Exception {
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
                .numberOfShards(1)
            }
                )
            Collections.singletonMap("foo", (factories, tag, description, config) -> new FakeProcessor("foo", tag, description, executor))
        // index name matches with ITMD for bulk upsert
                .putMapping("{}")
        assertThat(
        // invoke
        PutPipelineRequest putRequest = new PutPipelineRequest(
        assertEquals(1, completionHandler.size());
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            new BytesArray("{\"processors\": [{\"failure-mock\" : { \"on_failure\": [{\"mock\" : {}}]}}, {\"mock\" : {}}]}"),
        @SuppressWarnings("unchecked")
            bulkRequest.requests(),
    public void testStatName() {
        ingestService.executeBulkRequest(4, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
        String id = "_id";
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        );
            .isPipelineResolved(true);
            MediaTypeRegistry.JSON
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")
        final MetadataIndexTemplateService metadataIndexTemplateService = getInstanceFromNode(MetadataIndexTemplateService.class);
                .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))
        HashMap<String, PipelineConfiguration> pipelines = new HashMap<>();
        previousClusterState = clusterState;
            .source(emptyMap())
        final Processor onFailureProcessor = mock(Processor.class);
        // index name matches with IDM:
            .setPipeline("_id")
            Names.WRITE
        ingestService.executeBulkRequest(
            String value = (String) config.remove("value");
        verify(processor).execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());
import org.opensearch.ResourceNotFoundException;
        IndexRequest indexRequest = new IndexRequest("idx");
        AtomicReference<Object> reference = new AtomicReference<>();
        };
            "index1",
        ingestService.executeBulkRequest(
        IndexRequest indexRequest = new IndexRequest("idx");
        // index name matches with ITMD for bulk upsert:
        assertFalse(hasPipeline);
        cache.cachePipeline(index3.toString(), dummyPipeline, 10);
            List<IngestDocumentWrapper> documents = (List<IngestDocumentWrapper>) invocationOnMock.getArguments()[0];
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
        previousClusterState = clusterState;
            .setFinalPipeline("_none")
        IngestPlugin testPlugin = new IngestPlugin() {
        when(threadPool.generic()).thenReturn(executorService);
    private void assertProcessorStats(int processor, IngestStats stats, String pipelineId, long count, long failed, long time) {
            ),
            false,
        createPipeline("_id", ingestService);
            failure.set(true);
            .applySettings(Settings.builder().put(IngestService.SYSTEM_INGEST_PIPELINE_ENABLED.getKey(), false).build());
            MediaTypeRegistry.JSON
            .source(Collections.emptyMap())
        IngestService ingestService = new IngestService(
        ingestService.innerUpdatePipelines(ingestMetadata);
        );
        assertEquals(List.of(2), dropHandler);
            .setFinalPipeline("_none");
            .setFinalPipeline("_final")
                handler.accept(ingestDocument, null);
        assertThat(result, is(true));
import reactor.util.annotation.NonNull;
        IngestMetadata ingestMetadata = new IngestMetadata(pipelines);
            assertThat(e.getMessage(), equalTo("pipeline with id [_id] does not exist"));
        when(processorFailure.getType()).thenReturn("failure-mock");
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
                    ingestDocument.setFieldValue(metadata.getFieldName(), ifPrimaryTerm);
import org.junit.Before;
    public void testExecuteBulkRequestInBatchNoValidDocument() {
                .numberOfReplicas(0)
        final Processor processor = mock(Processor.class);
        IngestService ingestService = createIngestServiceWithProcessors(
        bulkRequest.add(indexRequest3ChildSlot1);
import org.opensearch.action.ingest.PutPipelineRequest;
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))
        });
        errorHandler.values().forEach(e -> assertEquals(e.getCause(), error));
        assertThat(ingestService.pipelines().get("_id3").pipeline.getId(), equalTo("_id3"));
            return new FakeProcessor("set", tag, description, (ingestDocument) -> ingestDocument.setFieldValue(field, value));
            .setPipeline("_id")
        // prepare handler
            threadPool,
            "_id1",
        Pipeline pipeline = ingestService.getPipeline(id);
        verify(mockCompoundProcessor, never()).execute(any(), any());
        boolean hasPipeline = ingestService.resolveSystemIngestPipeline(indexRequest, indexRequest, state.metadata());
            assertThat(result, is(true));
        }
        name = PipelineProcessor.TYPE;
            .metadata(Metadata.builder().putCustom(IngestMetadata.TYPE, ingestMetadata))
        ingestService.executeBulkRequest(
    private OperationStats getPipelineStats(List<IngestStats.PipelineStat> pipelineStats, String id) {
    public void testExecuteSuccess() {
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
        // invoke
                    + "                          \"field\": \"ingest_error1\",\n"
        assertThat(pipelines.get(1).getId(), equalTo("_id2"));
import org.opensearch.cluster.metadata.AliasMetadata;
            indexMetadata3
            }
        final CompoundProcessor processor = mockCompoundProcessor();
import java.util.function.LongSupplier;
        assertThat(pipeline, nullValue());
        result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
        assertThat(pipeline, notNullValue());
            IngestDocument document = (IngestDocument) invocationOnMock.getArguments()[0];
    public void testExecuteBulkPipelineDoesNotExist() {
                    + "                      {\n"
        indexRequest = new IndexRequest("alias");
        ingestService.applyClusterState(new ClusterChangedEvent("_name", clusterState, clusterState));
        boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
        assertThat(indexRequest.version(), equalTo(newVersion));
        // will not be handled as not valid document type
        final IndexMetadata indexMetadata = spy(
                    + "            }\n"
            .setPipeline("does_not_exist")
        );
    }
        assertTrue(dropHandler.isEmpty());
        ingestService.applyClusterState(new ClusterChangedEvent("", state, state));
        ClusterState previousClusterState = clusterState;
    public void testResolvePipelines_whenExistingIndexAndSystemPipelineDisabled_thenNoSystemPipeline() throws Exception {
        // verify
        IndexRequest indexRequest2 = new IndexRequest("idx");
        afterFirstRequestStats.getProcessorStats().get("_id1").forEach(p -> assertEquals(p.getName(), "mock:mockTag"));
        DeletePipelineRequest deleteRequest = new DeletePipelineRequest("_id");
        Map<String, IngestService.PipelineHolder> pipelines = ingestService.pipelines();
        try {
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
            public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
        ingestService.executeBulkRequest(
                .numberOfShards(1)
            requestItemErrorHandler,
            .setFinalPipeline("_none")
        // will not be handled as not valid document type
                    + "                      }\n"
        pipelines.put("q1", new PipelineConfiguration("q1", definition, MediaTypeRegistry.JSON));
        Settings newSettings = Settings.builder().put("cluster.ingest.max_number_processors", 3).build();
        verify(failureHandler, never()).accept(any(), any());
            Collections.singletonList(new IngestPipelineInfo("p2", IngestPipelineType.DEFAULT))
        final Map<Integer, Exception> failureHandler = new HashMap<>();
        // avoid returning null and dropping the document
        assertStats(getPipelineStats(pipelineStats, pipelineId), count, failed, time);
        previousClusterState = clusterState;
import static org.mockito.ArgumentMatchers.anyInt;
            MediaTypeRegistry.JSON
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer) args.getArguments()[1];
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        );
        when(threadPool.executor(anyString())).thenReturn(executorService);
        Consumer<ClusterState> ingestClusterStateListener = clusterState -> { assertThat(counter.compareAndSet(0, 1), is(true)); };
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        if (isBatch) {
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")
import static org.mockito.Mockito.never;
            .setPipeline("_none")
        return new IndexRequestWrapper(0, 0, indexRequest, actionRequest, pipelineInfoList);
        ConditionalProcessor conditionalProcessor = mock(ConditionalProcessor.class);
        pipelines.put("p1", new PipelineConfiguration("p1", definition, MediaTypeRegistry.JSON));
        // mock
        IndexRequestWrapper wrapper4 = createIndexRequestWrapper(
    }
        );
            assertThat(e.getCause(), instanceOf(IllegalStateException.class));
            completionHandler::put,
        final IngestStats afterSecondRequestStats = ingestService.stats();
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        assertThat("pipeline with id [fakeID] does not exist", equalTo(e.getMessage()));
    }
            .source(emptyMap())
        );
            mock(SystemIngestPipelineCache.class)
        // add pipeline
        metadata = Metadata.builder().put(templateBuilder).build();
            .setFinalPipeline("_none")
        when(processor.getTag()).thenReturn("mock_processor_tag");
            Collections.singletonList(indexRequest),
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            };
        });
import static org.opensearch.ingest.IngestService.NOOP_PIPELINE_NAME;
        when(systemProcessorFactory.create(any(), any(), any(), any())).thenReturn(dummySystemProcessor);
            .setSystemIngestPipeline("_none");
        assertThat(ingestService.pipelines().get("_id2").pipeline.getId(), equalTo("_id2"));
        assertThat(ingestService.pipelines().get("_id2").pipeline.getProcessors().size(), equalTo(0));
        // prepare systemIngestPipelineCache
                (thread, e) -> {},
        );
        // prepare request
        // Create ingest service:
import static org.mockito.Mockito.verifyNoMoreInteractions;
    }
import static org.mockito.Mockito.any;
        );
            failureHandler,
        );
        bulkRequest.add(indexRequest2);
        // verify
                    + "                              }\n"
            MediaTypeRegistry.JSON
        final Index index = new Index("idx", "uuid");
            List<IngestDocumentWrapper> ingestDocumentWrappers = (List) args.getArguments()[0];
                .numberOfReplicas(0);
    private static <K, V> Map<K, V> mapOf(K key, V value) {
        );
                .numberOfShards(1)
            List<IngestDocumentWrapper> documents = (List<IngestDocumentWrapper>) invocationOnMock.getArguments()[0];
        // only 1 time for set up
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
        PipelineProcessor pipelineProcessor = mock(PipelineProcessor.class);
        assertThat(ingestService.pipelines().get("_id3").pipeline.getProcessors().size(), equalTo(1));
