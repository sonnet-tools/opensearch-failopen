        );  
            @SuppressWarnings("unchecked")  
        assertThat(ingestService.getProcessorsInPipeline(id, Processor.class).size(), equalTo(3));  
            .source(emptyMap())
        assertThat(initialStats.getPipelineStats().size(), equalTo(0));
    }  
        assertThat(indexRequest.isPipelineResolved(), is(true));
        assertPipelineStats(afterSecondRequestStats.getPipelineStats(), "_id2", 1, 0, 0);
            public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {  
        assertProcessorStats(0, afterSecondRequestStats, "_id1", 1, 0, 0);  
            return new WrappingProcessorImpl("remove", tag, description, (ingestDocument -> ingestDocument.removeField(field))) {
            completionHandler,
            null,  
            bulkRequest.add(indexRequest);
        bulkRequest.add(new DeleteRequest("_index", "_id"));
import org.opensearch.action.bulk.BulkRequest;
            "_id",  
        assertThat(indexRequest.getFinalPipeline(), equalTo("final-pipeline"));
                    + "            \"set\": {\n"
            ),  
            ),  
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),  
            } else {
            "_id1",
                    + "                          \"value\": \"failed\",\n"  
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
        Metadata metadata = Metadata.builder().put(builder).build();
        IngestInfo ingestInfo = new IngestInfo(Collections.singletonList(new ProcessorInfo("set")));
        indexRequest.setPipeline("_id1");  
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")
                    + "              \"on_failure\": [\n"
            .setPipeline("_none")  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(pipelines.get(1).getId(), equalTo("_id2"));
            .setFinalPipeline("_id")
            .setSystemIngestPipeline("_none");
            IllegalArgumentException.class,
        doAnswer(args -> {
            threadPool,  
    public void testExecuteSystemPipelineExistsButFailedParsing() {
            "index1",  
            .setPipeline("_id")
                    Level.WARN,
        assertThat(indexRequest.getPipeline(), equalTo("default-pipeline"));
        );
        assertThat(ingestService.pipelines().get("_id1").pipeline.getProcessors().size(), equalTo(0));
            MediaTypeRegistry.JSON
    public void testGetPipelines() {
        Map<String, Processor.Factory> map = new HashMap<>(2);
            .setFinalPipeline("_none")
            id,
        );
        assertTrue(failure.get());  
        clusterState = IngestService.innerPut(putRequest, clusterState);
                    + "                                \"value\": \"failed\",\n"  
                    + "        \"on_failure\": [\n"
                .numberOfReplicas(0)  
        assertThat(ingestService.pipelines().get("_id1").pipeline.getId(), equalTo("_id1"));
    }  
            IndexRequest indexRequest = new IndexRequest("idx");
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        clusterState = IngestService.innerPut(putRequest, clusterState);
        assertThat(result, is(true));
        }
        IngestMetadata ingestMetadata = new IngestMetadata(pipelines);  
            null,
            .setFinalPipeline("_none")
        result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
            .setSystemIngestPipeline("_none");
        afterFirstRequestStats.getProcessorStats().get("_id2").forEach(p -> assertEquals(p.getName(), "mock:mockTag"));
            @Override
        clusterState = IngestService.innerPut(putRequest, clusterState);
            new Pipeline("id", "description", null, new CompoundProcessor(false, List.of(dummySystemProcessor), Collections.emptyList())),
    public void testValidatePipelineId_WithNotValidLength_ShouldThrowException() throws Exception {  
        assertEquals(failureHandler.get(2).size(), 2);
        BytesArray definition = new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}");
        assertStats(afterForthRequestStats.getTotalStats(), 4, 0, 0);  
            MediaTypeRegistry.JSON
        );
        final Map<Thread, Exception> completionHandler = new HashMap<>();  
import org.mockito.invocation.InvocationOnMock;  
            .setFinalPipeline("_final")  
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        assertThat(indexRequest.version(), equalTo(newVersion));
            Names.WRITE
        @SuppressWarnings("unchecked")  
        final IndexMetadata indexMetadata3 = mock(IndexMetadata.class);  
        pipelines = IngestService.innerGetPipelines(ingestMetadata, "_id1", "_id2");
            id,
        assertTrue(factories.containsKey("foo"));
                randomAlphaOfLength(10),
            100
        // prepare handler
        );
            this.ingestDocument = new IngestDocument(index, id, null, null, null, source);
        assertThat(indexRequest.versionType(), equalTo(VersionType.fromString(versionType)));  
            .setFinalPipeline("_none");  
            id,
    public void testValidateProcessorCountForIngestPipelineThrowsException() {
            return null;  
        ingestService.getClusterService().getClusterSettings().applySettings(newSettings);
        pipeline = ingestService.getPipeline(id);
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            public String getType() {
        assertNull(completionHandler.get(Thread.currentThread()));
        // verify we use the system pipeline from the cache
        assertThat(indexRequest.getFinalPipeline(), equalTo("final-pipeline"));
        assertTrue(indexRequest.isPipelineResolved());
        map.put("failure-mock", (factories, tag, description, config) -> processorFailure);  
            IndexMetadata.builder("idx")  
        ClusterState state = ClusterState.EMPTY_STATE;
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        assertThat(result, is(true));  
        verify(mockCompoundProcessor, never()).execute(any(), any());  
            .numberOfShards(1)
import org.opensearch.action.bulk.TransportBulkAction;
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
        assertThat(pipeline, nullValue());  
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer) args.getArguments()[1];
            completionHandler,
            emptySet(),
        Map<String, PipelineConfiguration> configs = new HashMap<>();
        assertThat(pipeline, nullValue());
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);  
            );
        );
            bulkRequest.requests(),
            mockAppender.assertAllExpectationsMatched();  
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer) args.getArguments()[1];  
    }
            .setPipeline("_none")  
        // verify update max processor
            .source(emptyMap())
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
        Pipeline pipeline = ingestService.getPipeline(id);  
            Names.WRITE
    }  
        String id = "_id";
                } else if (metadata == IngestDocument.Metadata.IF_SEQ_NO) {
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        final String versionType = randomFrom("internal", "external", "external_gt", "external_gte");
            client,
            indexReq -> {},
        }
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        ingestService.applyClusterState(new ClusterChangedEvent("_name", clusterState, clusterState));
        ingestService.innerUpdatePipelines(ingestMetadata);
        @SuppressWarnings("unchecked")
        return systemProcessors;
                    + "                    \"tag\": \"tagggg\",\n"
}
        ClusterState previousClusterState = clusterState;  
        final IngestStats afterSecondRequestStats = ingestService.stats();
        );
        @SuppressWarnings("unchecked")
        // invoke  
        ClusterState previousClusterState = clusterState;
 * license agreements. See the NOTICE file distributed with
            .source(emptyMap())  
import org.mockito.MockitoAnnotations;
        ClusterService clusterService = mock(ClusterService.class);  
        final Metadata currentMetadata = mock(Metadata.class);  
        // pipeline
            "index1",
                .numberOfReplicas(0)  
        assertThat(pipelines.get(0).getId(), equalTo("_id1"));  
            .build();
        PutPipelineRequest putRequest = new PutPipelineRequest(
        // mock a system pipeline do nothing  
    private static <K, V> Map<K, V> mapOf(K key1, V value1, K key2, V value2, K key3, V value3) {
            completionHandler,  
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
        @SuppressWarnings("unchecked")
        assertNull(cache.getSystemIngestPipeline(index2.toString()));
        final Index index1 = new Index("index1", "uuid1");  
        assertEquals(NOOP_PIPELINE_NAME, indexRequest1.getPipeline());
        map.put("mock", (factories, tag, description, config) -> processor);
            "_id",
 *  
        final IngestService ingestService = createIngestServiceWithProcessors();
            4,  
            .setSystemIngestPipeline("_none");
        clusterState = IngestService.innerPut(putRequest, clusterState);
        verify(failureHandler, never()).accept(any(), any());  
        assertThat(ingestService.getPipeline("p2"), nullValue());
            .source(emptyMap())
        previousClusterState = clusterState;
        BulkRequest bulkRequest = new BulkRequest();  
            completionHandler::put,  
import static org.mockito.Mockito.never;
    public void testResolveRequiredOrDefaultPipelineDefaultPipeline() {  
        createPipeline("final_pipeline", new BytesArray("{\"processors\": [{\"dummy\" : {}}]}"), ingestService, clusterState);
                    + "    }\n"
            null,
        ClusterState previousClusterState = clusterState;
        // prepare request
                .numberOfReplicas(0)
        assertThat(ingestService.getPipeline("_id"), nullValue());
        IngestService ingestService = createIngestServiceWithProcessors(emptyMap());
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    public void testBulkRequestExecutionWithFailures() {
        );
            IndexRequest indexRequest = TransportBulkAction.getIndexWriteRequest(docWriteRequest);  
        });
            Collections.singletonList(DUMMY_PLUGIN),
        clusterState = ClusterState.builder(clusterState)  
                .setSystemIngestPipeline("_none");
            Locale.ROOT,
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getPipeline());  
            .setSystemIngestPipeline("_none");  
            OpenSearchParseException.class,
        IngestService ingestService = createIngestServiceWithProcessors(processors, systemProcessors);
        boolean hasPipeline = ingestService.resolveSystemIngestPipeline(indexRequest, indexRequest, metadata);  
        List<IngestDocumentWrapper> results = Arrays.asList(
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor())  
        when(indexMetadata.getIndex()).thenReturn(index);
            .source(emptyMap())  
            "index1",
        IndexRequest indexRequest = new IndexRequest("idx");  
        clusterState = IngestService.innerPut(putRequest, clusterState);  
        // verify
        clusterState = IngestService.innerPut(putRequest, clusterState);  
            .settings(settings(Version.CURRENT).put(IndexSettings.FINAL_PIPELINE.getKey(), "final-pipeline"))  
                    + "                        ]\n"
            .setFinalPipeline("_none");
        // Create pipeline and apply the resulting cluster state, which should update the counter in the right order:
            .setPipeline(id)  
        );  
    public void testExecuteSystemPipelineDoesNotExist() {  
            Collections.singletonMap("mock", (factories, tag, description, config) -> processor)
        verify(failureHandler, never()).accept(any(), any());
            Names.WRITE  
    public void testUpdatePipelines() {
            bulkRequest.numberOfActions(),  
            Names.WRITE
        // verify
        IngestService ingestService = createIngestServiceWithProcessors();
    public void testCrud() throws Exception {
    public void testCBORParsing() throws Exception {
        final Map<Integer, Exception> failureHandler = new HashMap<>();  
        ingestMetadata = new IngestMetadata(mapOf("_id1", pipeline1, "_id2", pipeline2, "_id3", pipeline3));
            "index1",
        clusterState = ClusterState.builder(clusterState)
        );
        // add a new pipeline:  
        // verify  
import org.opensearch.action.update.UpdateRequest;
/*
            indexReq -> {},
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
        assertThat(ingestService.pipelines().get("_id1").pipeline.getId(), equalTo("_id1"));
                    + "                              }\n"
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer<IngestDocument, Exception>) invocationOnMock.getArguments()[1];  
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
                    + "  ]\n"
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
                .numberOfShards(1)  
                .build()
import org.opensearch.common.xcontent.XContentType;  
        doAnswer(args -> {
        bulkRequest.add(indexRequest1);
        clusterSettings.applySettings(newSettings);
        for (DocWriteRequest<?> docWriteRequest : bulkRequest.requests()) {
        assertEquals("[idx/uuid]", indexRequest.getSystemIngestPipeline());
        ClusterState previousClusterState = clusterState;  
        IngestService ingestService = createIngestServiceWithProcessors(
        doAnswer((InvocationOnMock invocationOnMock) -> {
        PutPipelineRequest putRequest = new PutPipelineRequest(  
        clusterState = IngestService.innerPut(putRequest, clusterState);
            Names.WRITE
        return processor;
            Names.WRITE
import org.opensearch.index.VersionType;
            completionHandler::put,
        bulkRequest.add(indexRequest3);  
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.transport.client.Requests;  
    @SuppressWarnings("unchecked")
        // prepare request
            numIndexRequests + numOtherRequests,
    }  
import org.hamcrest.MatcherAssert;
            @SuppressWarnings("unchecked")
import org.opensearch.common.SetOnce;
    }
    public void testExecuteSuccessWithOnFailure() throws Exception {  
            indexReq -> {},  
        ingestService.executeBulkRequest(4, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
        Map<String, Processor.Factory> factories = new HashMap<>();
        // verify
            assertThat(e.getCause(), instanceOf(IllegalStateException.class));  
        );  
            IndexMetadata.builder("_index")  
        );  
import static org.mockito.Mockito.anyString;
                new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
            assertThat(indexRequest, notNullValue());
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            .isPipelineResolved(true);
                )  
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);
            failureHandler::put,  
    }
        }  
    public void testExecuteBulkRequestInBatch() {
            Collections.singletonList(indexRequest),
            .source(emptyMap())
        Metadata metadata = Metadata.builder().put(builder).build();
        );
                .numberOfShards(1)
            mock(SystemIngestPipelineCache.class)
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())  
        // due to the parallel array's used to identify which metrics to carry forward. With out unique ids or semantic equals for each
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            .setFinalPipeline("_none")
        // mock
        @SuppressWarnings("unchecked")
    }  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
            assertThat(indexRequest.isPipelineResolved(), is(true));
        IndexRequest indexRequest2ChildSlot0 = new IndexRequest("_index").id("_id2")  
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
            .setFinalPipeline("_none")
        assertThat(ingestService.getPipeline("p1"), notNullValue());
        clusterState = createPipeline("pipeline", new BytesArray("{\"processors\": [{\"default\" : {}}]}"), ingestService, clusterState);  
import org.opensearch.Version;
        MockitoAnnotations.openMocks(this);
        // add index metadata for the new index  
            .settings(settings(Version.CURRENT).put(IndexSettings.FINAL_PIPELINE.getKey(), "final-pipeline"));
        indexRequest = new IndexRequest("alias");  
            .setPipeline("does_not_exist")  
        IndexRequestWrapper wrapper3 = createIndexRequestWrapper(
        final BiConsumer<Integer, Exception> failureHandler = (slot, e) -> {
        IngestService ingestService = createIngestServiceWithProcessors(
        assertTrue(failureHandler.isEmpty());
 * software distributed under the License is distributed on an
            longId,
        IngestService ingestService = createIngestServiceWithProcessors(
        assertNull(cache.getSystemIngestPipeline("[" + index3.getName() + "/template]"));
        assertThat(ingestService.getPipeline("p1"), nullValue());
        when(previousMetadata.indices()).thenReturn(previousIndices);
        // Exception if we used name which does not exist
            MediaTypeRegistry.JSON
        doAnswer(args -> {
            .setFinalPipeline("_none")  
            ),
        clusterState = IngestService.innerPut(putRequest, clusterState);
        previousClusterState = clusterState;
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
                Script.DEFAULT_SCRIPT_LANG,
            completionHandler,  
            "[_index/uuid]",  
            IndexRequest indexRequest = new IndexRequest("idx").setPipeline("request-pipeline");  
            .setPipeline("_none")
        DiscoveryNode node2 = new DiscoveryNode("_node_id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
        final IndexRequest indexRequest = new IndexRequest("idx");
    }
                @Override
        doThrow(new RuntimeException()).when(mockCompoundProcessor).batchExecute(any(), any());
        indexRequest.setPipeline("_id1").setFinalPipeline("_none");  
        ingestService.executeBulkRequest(1, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
                handler.accept(documents);
                    + "                                \"value\": \"failed\",\n"
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer) args.getArguments()[1];
        doAnswer(args -> {  
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        SystemIngestPipelineCache systemIngestPipelineCache = ingestService.getSystemIngestPipelineCache();  
        // index name matches with ITMD for bulk upsert
            .source(emptyMap())
        verify(dummySystemProcessor, times(1)).execute(any(), any());
    }  
        final Index index = new Index("idx", "uuid");  
            emptySet(),
    }
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
            new IngestDocumentWrapper(2, 0, null, null)  
                return systemProcessors;  
        bulkRequest.add(indexRequest1);
        }).when(processor).batchExecute(any(), any());
        factories.put("mock", (processorFactories, tag, description, config) -> new Processor() {  
        clusterState = IngestService.innerPut(putRequest, clusterState);  
            completionHandler,
        // processor
    public void testIngestPluginDuplicate() {
        // prepare request
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                    + "                          \"value\": \"failed\",\n"
        assertProcessorStats(0, afterThirdRequestStats, "_id1", 1, 0, 0);
                (thread, e) -> {},  
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
            .source(emptyMap())
    }  
            .patterns(Collections.singletonList("id*"))
        assertTrue(e.getMessage(), e.getMessage().contains("already registered"));  
        when(indexMetadata1.getIndex()).thenReturn(index1);
        );
        ingestService.innerUpdatePipelines(ingestMetadata);
        bulkRequest.add(indexRequest1);
        cache.cachePipeline(index1.toString(), dummyPipeline, 10);
import java.util.Map;  
            assertThat(e.getMessage(), equalTo("pipeline [unknown] is missing"));
        Pipeline pipeline = ingestService.getPipeline(id);  
        bulkRequest.add(indexRequest1);  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
    public void testUpdateMaxIngestProcessorCountSetting() {
            completionHandler,
            client,  
        indexRequest = new IndexRequest("idx");
        ingestService.innerUpdatePipelines(ingestMetadata);  
        ClusterState previousClusterState = clusterState;
        );  
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
        String scriptName = "conditionalScript";
 * ownership. Elasticsearch licenses this file to you under  
    }
                }
        // test a failure, and that the processor stats are added from the old stats  
        );
            }  
        ClusterState clusterState = createPipeline("_id", ingestService);  
        assertThat(ingestService.pipelines().size(), is(2));
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer) args.getArguments()[1];
import org.opensearch.threadpool.ThreadPool;  
            failureHandler::put,  
        verify(systemIngestPipelineCache, times(1)).getSystemIngestPipeline(any());
        int numIndexRequests = scaledRandomIntBetween(4, 32);  
        IngestService ingestService = createIngestServiceWithProcessors(Map.of(), systemProcessors);
        doAnswer(args -> {  
                .setPipeline("_id")
        String longId = "a".repeat(512) + "a";  
        verify(mockCompoundProcessor, times(1)).batchExecute(any(), any());
        IndexMetadata.Builder builder = IndexMetadata.builder("idx")
            failureHandler,
        IngestService ingestService = createIngestServiceWithProcessors(Map.of(), systemProcessors);
                .putMapping("{}")
            Collections.singletonList(indexRequest),
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
        IngestMetadata ingestMetadata = new IngestMetadata(mapOf("_id1", pipeline1));
        pipeline3 = new PipelineConfiguration(  
        when(threadPool.executor(anyString())).thenReturn(executorService);  
        assertTrue(failureHandler.isEmpty());  
            .setFinalPipeline("_none")
        previousClusterState = clusterState;
    public void testResolveSystemIngestPipeline_whenUseTemplateV1() throws Exception {
        IndexTemplateMetadata v1Template = IndexTemplateMetadata.builder("v1-template").patterns(Arrays.asList("fo*", "baz")).build();  
        assertEquals(id, indexRequest.getSystemIngestPipeline());  
            ),
            .setSystemIngestPipeline("_none");  
        );  
        bulkRequest.add(indexRequest3);
        verify(systemIngestPipelineCache, times(3)).getSystemIngestPipeline(any());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                .numberOfReplicas(0)
            "_id",
        return Collections.singletonMap(key, value);
        );
        verifySystemPipelineResolvedSuccessfully("[idx/template]", hasPipeline, indexRequest, cache);  
            failureHandler::put,
        assertThat(pipeline.getId(), equalTo("_id"));
import java.util.Objects;
            new IngestDocumentWrapper(0, 0, IngestService.toIngestDocument(indexRequest1), null),
        String pipelineName = randomAlphaOfLength(10);  
            .setFinalPipeline("_none")
            mock(NamedXContentRegistry.class),  
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        PutPipelineRequest putRequest = new PutPipelineRequest(
            assertThat(result, is(true));
        // total
            .setSystemIngestPipeline("[_index/template]")
            1,  
import static org.mockito.Mockito.mock;
        // mock
        IndexMetadata indexMetadata = spy(
                .setPipeline(pipelineId)
        ClusterService clusterService = mock(ClusterService.class);  
        assertThat(pipeline, notNullValue());  
        assertStats(getPipelineStats(pipelineStats, pipelineId), count, failed, time);
    }  
        IngestService ingestService = createIngestServiceWithProcessors();
                .setFinalPipeline("_none")
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")  
        expectThrows(IllegalStateException.class, () -> ingestService.validatePipeline(ingestInfos, putRequest));
        assertThat(ingestService.getProcessorsInPipeline(id, WrappingProcessorImpl.class).size(), equalTo(0));
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
            .source(emptyMap())
        pipelines.put("q1", new PipelineConfiguration("q1", definition, MediaTypeRegistry.JSON));
        verify(failureHandler, times(1)).accept(eq(0), any(RuntimeException.class));
        processors.put("set", (factories, tag, description, config) -> {  
    }
            List<IngestDocumentWrapper> documents = (List<IngestDocumentWrapper>) invocationOnMock.getArguments()[0];
        IndexRequest indexRequest3ChildSlot1 = new IndexRequest("_index").id("_id3")
            assertThat(e, instanceOf(IllegalArgumentException.class));  
            .execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());  
        assertThat(ingestService.pipelines().get("_id2").pipeline.getProcessors().size(), equalTo(0));
        verify(mockCompoundProcessor, never()).execute(any(), any());
        ClusterState previousClusterState = clusterState;  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
            .setSystemIngestPipeline("_none");
        // index name matches with ITMD:
            .setPipeline("_none")  
    @Mock
        assertThat(pipelines.size(), equalTo(2));  
            .source(emptyMap())  
        createPipeline("_id", ingestService);
            List<IngestDocumentWrapper> ingestDocumentWrappers = (List) args.getArguments()[0];
        pipelines = IngestService.innerGetPipelines(ingestMetadata, "*");
        ClusterState previousClusterState = clusterState;  
        ingestService.executeBulkRequest(  
        when(threadPool.generic()).thenReturn(executorService);
        ingestService.executeBulkRequest(
            mockAppender.addExpectation(  
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        bulkRequest.add(indexRequest1);
        // will not be handled as not valid document type
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
        assertThat(indexRequest.id(), equalTo("update_id"));  
            .setSystemIngestPipeline("_none");  
        final IngestService ingestService = createIngestServiceWithProcessors();
            .source(emptyMap())
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        }).when(processor).batchExecute(any(), any());
        map.put(key2, value2);
        assertThat(ingestService.pipelines().size(), is(3));
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
        boolean hasPipeline = ingestService.resolveSystemIngestPipeline(indexRequest, indexRequest, metadata);
        when(conditionalProcessor.getInnerProcessor()).thenReturn(processor);
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();  
        ingestService.executeBulkRequest(
                return null;  
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer<List<IngestDocumentWrapper>>) invocationOnMock.getArguments()[1];
        @SuppressWarnings("unchecked")
        assertEquals(3, clusterSettings.get(IngestService.MAX_NUMBER_OF_INGEST_PROCESSORS).intValue());
        verify(mockCompoundProcessor, times(2)).batchExecute(any(), any());
        IngestService ingestService = createIngestServiceWithProcessors(map);  
            .setPipeline("_id")
            IndexRequest indexRequest = new IndexRequest("idx").setPipeline("request-pipeline");
            .setSystemIngestPipeline("_none");
    public void testExecuteBulkRequestInBatchWithExceptionAndDropInCallback() {  
            public IngestDocument execute(final IngestDocument ingestDocument) {
    public void testExecutePropagateAllMetadataUpdates() throws Exception {
            id,
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
            .setSystemIngestPipeline("_none");
        assertThat(pipelines.size(), equalTo(2));
        clusterState = IngestService.innerDelete(deleteRequest, clusterState);
        UpdateRequest updateRequest = new UpdateRequest("idx", "id1").upsert(emptyMap()).script(mockScript("1"));
        logger.info("Using [{}], not randomly determined default [{}]", xContentType, Requests.INDEX_CONTENT_TYPE);  
        previousClusterState = clusterState;  
        IngestService ingestService = createIngestServiceWithProcessors(
        // prepare request  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
                    + "              \"value\": \"failed\",\n"
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
            .source(emptyMap())  
        IngestService ingestService = createIngestServiceWithProcessors();
                    + "                    ]\n"  
    public void testPutWithErrorResponse() throws IllegalAccessException {  
            1,
    private class IngestDocumentMatcher implements ArgumentMatcher<IngestDocument> {
        @SuppressWarnings("unchecked")  
            Names.WRITE  
                UpdateRequest updateRequest = new UpdateRequest("_index", "_id");
        IndexRequest indexRequest4 = new IndexRequest("_index").id("_id4")  
        assertThat(result, is(true));
            .isPipelineResolved(true);  
        IndexRequestWrapper wrapper1 = createIndexRequestWrapper(  
        assertThat(indexRequest.isPipelineResolved(), is(true));  
        verifySystemPipelineResolvedSuccessfully("[idx/template]", hasPipeline, indexRequest, cache);
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getFinalPipeline());
        assertEquals("Processor type [remove] is not installed on node [" + node2 + "]", e.getMessage());
        final SetOnce<Boolean> failure = new SetOnce<>();
        // mock a default pipeline do nothing
            Names.WRITE
    private void assertProcessorStats(int processor, IngestStats stats, String pipelineId, long count, long failed, long time) {
        bulkRequest.add(indexRequest2);  
                    + "                        }\n"
            .setSystemIngestPipeline("[_index/uuid]")
            ),  
        // verify the pipeline info of the request 1 will be reset since its target index is changed
            1,  
                if (metadata == IngestDocument.Metadata.VERSION) {
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        );  
        when(pipelineProcessor.getPipelineTemplate()).thenReturn(new TestTemplateService.MockTemplateScript.Factory(pipelineName));
            String value = (String) config.remove("value");
        }
            "_id",
        IngestService ingestService = createIngestServiceWithProcessors();  
import org.opensearch.index.IndexSettings;
        }
            indexReq -> {},  
        // will not be handled as not valid document type
            "index2",
    public void testExecuteEmptyPipelineInBatch() throws Exception {  
        // prepare systemIngestPipelineCache for the case using index template  
                .numberOfShards(1)
        PutPipelineRequest putRequest = new PutPipelineRequest(
        ClusterState previousClusterState = clusterState;
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
            .numberOfShards(1)
        ingestService.executeBulkRequest(
import org.opensearch.cluster.metadata.AliasMetadata;
            MediaTypeRegistry.JSON  
            indexReq -> {},  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor())  
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
        doThrow(new RuntimeException()).when(onFailureProcessor)
            new Pipeline("id", "description", null, new CompoundProcessor(false, List.of(dummySystemProcessor), Collections.emptyList())),
            mock(NamedXContentRegistry.class),
            public Map<String, Processor.Factory> getProcessors(final Processor.Parameters parameters) {  
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
        final IngestService ingestService = createIngestServiceWithProcessors();
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        );
        );
            MediaTypeRegistry.JSON
        );  
import static org.opensearch.ingest.IngestService.NOOP_PIPELINE_NAME;
        map.put(key1, value1);  
        assertThat(ingestService.pipelines().get("_id").pipeline.getDescription(), nullValue());  
        IndexMetadata.Builder builder = IndexMetadata.builder("idx")
        Client client = mock(Client.class);
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
        final long ifPrimaryTerm = randomNonNegativeLong();  
            dropHandler::add,
        assertPipelineStats(afterFirstRequestStats.getPipelineStats(), "_id1", 1, 0, 0);
import org.opensearch.cluster.ClusterState;
            .setFinalPipeline("_none")  
        final MetadataIndexTemplateService metadataIndexTemplateService = getInstanceFromNode(MetadataIndexTemplateService.class);
        assertEquals("tag2", e.getMetadata("opensearch.processor_tag").get(0));
            .execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());
        createPipeline("_id", ingestService);
                mock(ClusterService.class),  
            .setSystemIngestPipeline("_none");
        );  
        final Map<Integer, Exception> errorHandler = new HashMap<>();
        IngestService ingestService = createIngestServiceWithProcessors(processors);
        bulkRequest.add(indexRequest2ChildSlot0);
            Collections.singletonMap(
        assertThat(ingestService.pipelines().get("_id3").pipeline.getProcessors().size(), equalTo(0));
        assertEquals(1, factories.size());  
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);  
        Client client = mock(Client.class);
        // prepare handler  
        IndexRequest indexRequest4 = new IndexRequest("_index").id("_id4")
        Exception e = expectThrows(  
        final IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        verify(defaultProcessor, times(1)).batchExecute(any(), any());
            assertThat(indexRequest.getPipeline(), equalTo("request-pipeline"));  
        IngestService ingestService = createIngestServiceWithProcessors(
                .settings(settings(Version.CURRENT))
import org.opensearch.cluster.metadata.IndexMetadata;
            "_node_id",
            completionHandler::put,
        IngestMetadata ingestMetadata = new IngestMetadata(Collections.singletonMap("_id", pipeline));
        return new IndexRequestWrapper(0, 0, indexRequest, actionRequest, pipelineInfoList);
            .setFinalPipeline("_none")
        @SuppressWarnings("unchecked")  
        final Processor processor = mock(Processor.class);
            mock(IndicesService.class),
        assertEquals(1, systemFactories.size());
                "{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\", \"tag\": \"tag1\"}},"
        );
        ClusterState previousClusterState = clusterState;
        IngestService ingestService = createIngestServiceWithProcessors(map);
        assertThat(result, is(true));
        assertThat(ingestService.getPipeline("p1"), nullValue());  
        verify(requestItemErrorHandler, never()).accept(any(), any());  
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        PipelineConfiguration pipeline2 = new PipelineConfiguration("_id2", new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON);
import static java.util.Collections.emptyMap;  
        assertPipelineStats(afterForthRequestStats.getPipelineStats(), "_id2", 1, 0, 0);  
            "index2",
        ClusterService clusterService = mock(ClusterService.class);
            IllegalArgumentException.class,
        ingestService.executeBulkRequest(  
        bulkRequest.add(indexRequest3);
        assertPipelineStats(afterFirstRequestStats.getPipelineStats(), "_id2", 0, 0, 0);
        ClusterState previousClusterState = clusterState;
        BulkRequest bulkRequest = new BulkRequest();
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        }
        final IndexMetadata indexMetadata2 = mock(IndexMetadata.class);  
        Processor dummyFinalProcessor = mock(Processor.class);
        assertTrue(indexRequest.isPipelineResolved());
        assertThat(pipeline.getDescription(), nullValue());
            3,
            .numberOfReplicas(0)
        // First time create the pipeline and cache it  
        when(indexMetadata2.getIndex()).thenReturn(index2);
    private static <K, V> Map<K, V> mapOf(K key1, V value1, K key2, V value2) {
                    + "                              \"set\": {\n"
                    randomAlphaOfLength(10) + "-nested",
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)  
        );
            1,
        PipelineConfiguration pipeline3 = new PipelineConfiguration("_id3", new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON);  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        createPipeline("_final", ingestService, clusterState);
        ingestService.executeBulkRequest(2, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
        }).when(processorFailure).execute(any(IngestDocument.class), any());  
            emptyMap(),  
        clusterState = IngestService.innerDelete(matchAllDeleteRequest, clusterState);
        IngestService ingestService = createIngestServiceWithProcessors(
            new BytesArray(
            Names.WRITE  
            return Objects.equals(ingestDocument.getSourceAndMetadata(), o.getSourceAndMetadata());
        IngestService ingestService = createIngestServiceWithProcessors();
        Metadata metadata = Metadata.builder().indices(Map.of("idx", indexMetadata)).build();
        ClusterState previousClusterState = clusterState;
            Collections.singletonList(new CompoundProcessor(false, processors, onFailureProcessors))  
        when(systemProcessorFactory.create(any(), any(), any(), any())).thenReturn(dummySystemProcessor);
        ConditionalProcessor conditionalProcessor = mock(ConditionalProcessor.class);
        assertTrue(systemFactories.containsKey("foo"));  
    };
        );  
    }
            failureHandler,
        clusterState = IngestService.innerPut(putRequest, clusterState);
                    new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),  
        @SuppressWarnings("unchecked")  
            dropHandler::add,  
                }
                    + "        ]\n"
                    + "          },\n"  
                    scriptService,
        systemProcessors.put("foo", mockSystemProcessorFactory);  
        assertThat(indexRequest.getPipeline(), equalTo("default-pipeline"));  
                .build()
        // total
            .setSystemIngestPipeline("_none");
            equalTo("this is a place holder pipeline, because pipeline with" + " id [_id] could not be loaded")
            failureHandler::put,
        assertThat(pipeline.getDescription(), equalTo("_description"));
        final Map<Integer, Exception> failureHandler = new HashMap<>();  
        );  
import static org.hamcrest.Matchers.contains;  
        doAnswer(invocationOnMock -> {
        );
        Settings newSettings = Settings.builder().put("cluster.ingest.max_number_processors", 3).build();  
        assertEquals("Ingest info is empty", e.getMessage());
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(Arrays.asList("idx*"), null, null, null, null, null, null);  
        assertTrue(indexRequest2.isPipelineResolved());
        // The slots should have the correct number of failures  
            bulkRequest.requests(),
        verify(mockCompoundProcessor, times(1)).batchExecute(any(), any());
            .setFinalPipeline("_none");
            new BytesArray(
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")
            @SuppressWarnings("unchecked")
            completionHandler::put,
            Names.WRITE
                threadPool,
            handler.accept(ingestDocumentWrappers);  
        configs.put("_id1", new PipelineConfiguration("_id1", new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON));  
            Arrays.asList(testPlugin),
    public void testValidateNoIngestInfo() throws Exception {  
            indexReq -> {},
        final Processor dummySystemProcessor = mock(Processor.class);  
        when(clusterService.getClusterSettings()).thenReturn(  
        verifySystemPipelineResolvedSuccessfully("[idx/uuid]", hasPipeline, indexRequest, cache);
        IngestService ingestService = new IngestService(  
        final BiConsumer<Integer, Exception> failureHandler = (slot, e) -> {  
        ingestService.executeBulkRequest(
            IndexRequest indexRequest = new IndexRequest("_index").id("_id")  
import org.opensearch.cluster.service.ClusterService;  
    }  
        processors.put(
        );
        // request pipeline with final pipeline:  
            }
    }  
        verify(processor).execute(any(), any());
 *
                List<IngestDocumentWrapper> documents = (List<IngestDocumentWrapper>) invocationOnMock.getArguments()[0];
        );  
        assertStats(afterFirstRequestStats.getTotalStats(), 1, 0, 0);
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))  
    }  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty  
            .setFinalPipeline("_none")  
            pipeline.getDescription(),  
            builder.endObject();
        assertProcessorStats(0, afterForthRequestStats, "_id2", 1, 0, 0);
        OpenSearchParseException e = expectThrows(
        clusterState = IngestService.innerPut(putRequest, clusterState);
        IndexRequest indexRequest3ChildSlot0 = new IndexRequest("_index").id("_id3")
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
        // mock a default pipeline do change the target index of the first request
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2").source(emptyMap()).setPipeline("_id").setFinalPipeline("_none");
        // update cluster state and ensure that new stats are added to old stats  
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
                IngestDocument ingestDocument = (IngestDocument) invocationOnMock.getArguments()[0];  
            return null;
    }
            threadPool,
        assertThat(ingestService.getPipeline("q1"), notNullValue());  
    }
            .setPipeline("_id")  
        processors.put(
        bulkRequest.add(indexRequest2);  
        try {
            MediaTypeRegistry.JSON
        );
        ingestService.innerUpdatePipelines(ingestMetadata);  
import org.opensearch.common.settings.ClusterSettings;  
        assertThat(pipeline, nullValue());
    public void testExecuteWithDrop() {  
            1,
        bulkRequest.add(indexRequest2);
        final Map<String, IndexMetadata> previousIndices = Map.of(
import org.opensearch.action.DocWriteRequest;  
        ingestService.validatePipeline(ingestInfos, putRequest);
            (factories, tag, description, config) -> new CompoundProcessor(false, List.of(defaultProcessor), List.of())  
            "index1",
            .setPipeline("pipeline")  
        final Map<String, Processor.Factory> systemProcessors = createDummyMockSystemProcessors(dummySystemProcessor, false);
        // pipeline  
        );
            2,
        assertThat(ingestService.getProcessorsInPipeline(id, Processor.class).size(), equalTo(3));  
        try (XContentBuilder builder = CborXContent.contentBuilder()) {
    private void assertPipelineStats(List<IngestStats.PipelineStat> pipelineStats, String pipelineId, long count, long failed, long time) {  
            assertThat(indexRequest.getPipeline(), equalTo(NOOP_PIPELINE_NAME));  
    }  
            MediaTypeRegistry.JSON
        PutPipelineRequest putRequest = new PutPipelineRequest(
        MatcherAssert.assertThat(errorHandler.entrySet(), hasSize(numIndexRequests));  
        final Map<Integer, Exception> failureHandler = new HashMap<>();
        throws Exception {  
        boolean hasPipeline = ingestService.resolvePipelines(indexRequest, indexRequest, state.metadata());
        List<IngestDocumentWrapper> results = Arrays.asList(  
    public void testResolvePipelines_whenUseTemplateV1() throws Exception {  
                    + "                          \"tag\": \"tagggg\",\n"
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);  
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        assertThat(IngestService.getProcessorName(pipelineProcessor), equalTo(name + ":" + pipelineName + ":" + tag));  
        @NonNull final IndexRequest indexRequest,
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer) args.getArguments()[1];
        @SuppressWarnings("unchecked")
    public void testExecuteEmptyPipeline() throws Exception {
        assertThat(ingestService.getProcessorsInPipeline(id, WrappingProcessor.class).size(), equalTo(2));
        ingestService.getClusterService()  
        assertProcessorStats(0, afterFirstRequestStats, "_id1", 1, 0, 0);
            .setFinalPipeline("_none")
            new IngestDocumentWrapper(0, 0, IngestService.toIngestDocument(indexRequest1), null),  
        ingestInfos.put(node1, new IngestInfo(Arrays.asList(new ProcessorInfo("set"), new ProcessorInfo("remove"))));
                    + "                                \"tag\": \"tagggg\"\n"
        PipelineConfiguration config = new PipelineConfiguration(  
            mock(NamedXContentRegistry.class),
            ingestService.executeBulkRequest(
        ingestService.executeBulkRequest(
        verify(mockCompoundProcessor, never()).execute(any(), any());  
        HashMap<String, PipelineConfiguration> pipelines = new HashMap<>();
        assertThat(ingestService.pipelines().get("_id3").pipeline.getId(), equalTo("_id3"));
import org.opensearch.core.xcontent.XContentBuilder;  
        when(processor.getProcessors()).thenReturn(Collections.singletonList(mock(Processor.class)));  
            assertThat(indexRequest.isPipelineResolved(), is(true));  
        );
            id,
        PutPipelineRequest putRequest = new PutPipelineRequest(
            fail("exception expected");
    }
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")  
            assertThat(indexRequest.isPipelineResolved(), is(true));
        final List<Integer> dropHandler = new ArrayList<>();  
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
            List<IngestDocumentWrapper> documents = (List<IngestDocumentWrapper>) invocationOnMock.getArguments()[0];
        IngestService ingestService = createIngestServiceWithProcessors();  
        PutPipelineRequest putRequest = new PutPipelineRequest(
        assertProcessorStats(1, afterThirdRequestStats, "_id1", 1, 0, 0);  
        assertThat(indexRequest.isPipelineResolved(), is(true));
    private ThreadPool threadPool;
    }
            mock(IndicesService.class),
    }
            .source(emptyMap())  
        ThreadPool threadPool = mock(ThreadPool.class);
        when(processor.getType()).thenReturn("mock_processor_type");
        verify(cache, times(1)).cachePipeline(eq(id), any(), eq(Integer.MAX_VALUE));
            indexReq -> {},  
        assertThat(stats.getTotalTime(), greaterThanOrEqualTo(time));
            return new FakeProcessor("set", tag, description, (ingestDocument) -> ingestDocument.setFieldValue(field, value));
            .source(emptyMap())
        );  
        previousClusterState = clusterState;
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
            assertThat(result, is(false));
            }
import org.opensearch.common.settings.Settings;
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        assertTrue(failureHandler.isEmpty());
        // alias name matches with IDM:
                    + "                    \"on_failure\": [\n"
            .setFinalPipeline("_none")  
/*  
        final IntConsumer dropHandler = mock(IntConsumer.class);
        }, completionHandler::put, dropHandler::add, Names.WRITE);
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getPipeline());  
                    ingestDocument.setFieldValue(metadata.getFieldName(), newVersion);
            .build();  
/*  
        );  
        when(currentMetadata.indices()).thenReturn(currentIndices);
            handler.accept(results);  
    }
                .numberOfReplicas(0);  
                scriptService,
            doAnswer(invocationOnMock -> {
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
        // alias name matches with IDM:
                1,  
            handler.accept(documents);
        verify(systemIngestPipelineCache, times(1)).getSystemIngestPipeline(any());  
 */
                    + "                                \"field\": \"ingest_error2\",\n"  
            assertThat(indexRequest.getContentType(), equalTo(xContentType));
            Collections.singletonList(indexRequest),  
        assertThat(ingestService.pipelines().size(), is(1));
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
        assertTrue(dropHandler.isEmpty());  
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getFinalPipeline());
        assertThat(ingestService.pipelines().get("_id3").pipeline.getProcessors().size(), equalTo(0));
        clusterState = IngestService.innerPut(putRequest, clusterState);  
        assertFalse(indexRequest1.isPipelineResolved());  
        IngestService ingestService = createIngestServiceWithProcessors();  
        BulkRequest bulkRequest = new BulkRequest();
    public static IngestService createIngestServiceWithProcessors(  
        assertThat(ingestService.pipelines().get("_id2").pipeline.getId(), equalTo("_id2"));
            2,
        // Create ingest service:
        }
        final Map<String, Processor.Factory> systemProcessors = createDummyMockSystemProcessors(dummySystemProcessor, false);
        verify(mockCompoundProcessor, times(1)).batchExecute(any(), any());
        }).when(onFailureProcessor).execute(eqIndexTypeId(emptyMap()), any());  
        }
        } catch (ResourceNotFoundException e) {  
import static org.mockito.Mockito.when;
    }
        verify(cache, times(2)).getSystemIngestPipeline(eq("[idx/uuid]"));
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
            assertThat(slot, equalTo(1));  
        assertEquals("[idx/uuid]", indexRequest2.getSystemIngestPipeline());  
            MediaTypeRegistry.JSON  
            .setPipeline("pipeline")
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
            boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);  
        assertThat(pipeline, notNullValue());
        );
        assertThat(indexRequest.getPipeline(), equalTo("_none"));
 * this work for additional information regarding copyright
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())  
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getPipeline());  
            .setSystemIngestPipeline("_none");
            "index1",
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        final Processor onFailureProcessor = mock(Processor.class);
        final IndexMetadata indexMetadata = spy(  
            failureHandler,  
            return null;  
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
        );  
    @Before  
            failureHandler,  
                .source(builder)
            bulkRequest.requests(),
    }  
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        ingestService.addIngestClusterStateListener(ingestClusterStateListener);
        BulkRequest bulkRequest = new BulkRequest();
                    + "                                \"tag\": \"tagggg\"\n"
        assertThat(stats.getCount(), equalTo(count));
            MediaTypeRegistry.JSON  
        when(processor.getTag()).thenReturn(tag);
        clusterState = IngestService.innerPut(putRequest, clusterState);  
        DiscoveryNode discoveryNode = new DiscoveryNode(
            "dummy",  
        );  
            completionHandler,
        final IngestStats afterForthRequestStats = ingestService.stats();  
        return new IngestService(clusterService, threadPool, null, null, null, Collections.singletonList(new IngestPlugin() {
        pipelines.put("p1", new PipelineConfiguration("p1", definition, MediaTypeRegistry.JSON));  
    }
        // mock
            .source(emptyMap())  
            new BytesArray("{\"processors\": [], \"description\": \"_description\"}"),
        map.put(key3, value3);  
            handler.accept(documents);
            .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))  
            IndexMetadata.builder("_index")
            completionHandler::put,  
public class IngestServiceTests extends OpenSearchSingleNodeTestCase {  
            Metadata metadata = Metadata.builder().put(builder).build();  
        assertThat(pipeline.getId(), equalTo(id));
        processors.put("set", (factories, tag, description, config) -> {
        ingestService.executeBulkRequest(
package org.opensearch.ingest;
            clusterService,
        pipeline = ingestService.getPipeline(id);
        BulkRequest bulkRequest = new BulkRequest();
        assertThat(ingestService.pipelines().get("_id1").pipeline.getProcessors().size(), equalTo(0));
        // request pipeline with default pipeline:
        final List<Integer> dropHandler = new ArrayList<>();
        Pipeline pipeline = ingestService.getPipeline(id);
        assertEquals("remove", e.getMetadata("opensearch.processor_type").get(0));  
            indexReq -> {},
        Processor defaultProcessor = mock(Processor.class);
        );  
            return null;
        Client client = mock(Client.class);
        ClusterState previousClusterState = clusterState;
import org.apache.logging.log4j.Level;
        ClusterState previousClusterState = clusterState;
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {  
        List<List<IndexRequestWrapper>> batches = IngestService.prepareBatches(2, Arrays.asList(wrapper1, wrapper2, wrapper3, wrapper4));
        bulkRequest.add(indexRequest1);
        cache.cachePipeline(index2.toString(), dummyPipeline, 10);  
        doAnswer(args -> {
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);  
        verify(failureHandler, times(2)).accept(any(), any());  
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);
        bulkRequest.add(indexRequest1);
        verify(defaultProcessor, times(1)).batchExecute(any(), any());  
 * SPDX-License-Identifier: Apache-2.0
        bulkRequest.add(indexRequest1);
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer) args.getArguments()[1];  
            completionHandler,
    private IndexRequestWrapper createIndexRequestWrapper(String index, List<IngestPipelineInfo> pipelineInfoList) {
 * KIND, either express or implied.  See the License for the
            Names.WRITE  
        Map<String, Processor.Factory> processors = new HashMap<>();
        boolean hasPipeline = ingestService.resolveSystemIngestPipeline(indexRequest, indexRequest, state.metadata());
                    + "                      {\n"
        // index name matches with ITMD:
        );
        ingestService.applyClusterState(new ClusterChangedEvent("", state, state));  
import java.util.Set;
        bulkRequest.add(indexRequest4);
                .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))
        IndexRequestWrapper wrapper2 = createIndexRequestWrapper(
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        bulkRequest.add(indexRequest1);
        Map<String, Processor.Factory> processors = new HashMap<>();
        verify(failureHandler, never()).accept(any(), any());
                .settings(settings(Version.CURRENT).put(IndexSettings.FINAL_PIPELINE.getKey(), "final-pipeline"))  
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);
        final List<Integer> dropHandler = new ArrayList<>();
        // prepare test data
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        processors.put("remove", (factories, tag, description, config) -> {
        @SuppressWarnings("unchecked")
    public void testResolveFinalPipeline() {  
            assertThat(indexRequest.getFinalPipeline(), equalTo("final-pipeline"));  
                    IngestService.class.getCanonicalName(),  
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))
            .source(Collections.emptyMap())
        putRequest = new PutPipelineRequest(
        IndexRequestWrapper wrapper1 = createIndexRequestWrapper(  
    }
        ingestInfos.put(node1, new IngestInfo(Arrays.asList(new ProcessorInfo("set"), new ProcessorInfo("remove"))));  
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);  
    public void testExecuteBulkRequestInBatchWithDefaultBatchSize() {  
import static org.hamcrest.Matchers.instanceOf;
                    + "}"  
            .setSystemIngestPipeline("_none");
        Map<String, Processor.Factory> systemProcessors
        assertThat(indexRequest.index(), equalTo("update_index"));
        Processor dummyProcessor = mock(Processor.class);  
        assertNull(indexRequest1.getFinalPipeline());
        );
        @SuppressWarnings("unchecked")
            fail("exception expected");
        when(indexMetadata3.getIndex()).thenReturn(index3);
                    + "                          \"tag\": \"tagggg\"\n"  
                } else {  
            .setPipeline("_id")  
        bulkRequest.add(indexRequest4);
    public void testExecuteFailure() throws Exception {
    private static final IngestPlugin DUMMY_PLUGIN = new IngestPlugin() {
        ingestService.executeBulkRequest(5, bulkRequest.requests(), (slot, exception) -> {
        assertThat(pipeline.getProcessors().get(0).getType(), equalTo("set"));
        assertThat(IngestService.getProcessorName(pipelineProcessor), equalTo(name + ":" + pipelineName));
            .source(emptyMap())  
                    + "                            },\n"  
            .metadata(Metadata.builder(Metadata.EMPTY_METADATA).put(v1Template).build())  
            errorHandler::put,  
        when(pipelineProcessor.getTag()).thenReturn(tag);
import java.util.concurrent.atomic.AtomicInteger;
        pipeline = ingestService.getPipeline(id);
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
            .setFinalPipeline("_none")  
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
        assertProcessorStats(0, afterThirdRequestStats, "_id2", 1, 0, 0);
    }  
        );
            Settings.builder().build(),  
            for (IngestDocumentWrapper wrapper : ingestDocumentWrappers) {  
            .source(emptyMap())
            .build();
        final Map<String, Processor.Factory> processors = new HashMap<>();
        verify(systemIngestPipelineCache, times(1)).cachePipeline(any(), any(), anyInt());
            IndexRequest indexRequest = new IndexRequest("_index").id("_id")
import static org.hamcrest.Matchers.sameInstance;
        ingestService.innerUpdatePipelines(ingestMetadata);
    }
        }).when(processor).execute(any(), any());  
            dropHandler::add,
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer<List<IngestDocumentWrapper>>) invocationOnMock.getArguments()[1];  
            indexRequest.source(xContentType, "field1", "value1");
        {
        assertPipelineStats(afterThirdRequestStats.getPipelineStats(), "_id2", 1, 0, 0);  
        verify(mockCompoundProcessor, times(1)).execute(any(), any());  
    }  
        );
            return null;
                    + "                        \"set\": {\n"
        final SetOnce<Boolean> failure = new SetOnce<>();
        PutPipelineRequest putRequest = new PutPipelineRequest(
                new ConditionalProcessor(  
        PutPipelineRequest putRequest = new PutPipelineRequest(  
        verify(dummySystemProcessor, times(1)).execute(any(), any());
        // only 1 time to cache the newly generated pipeline
        ingestService.getClusterService()
        verify(failureHandler, never()).accept(any(), any());
        );
import org.opensearch.core.index.Index;  
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")  
            .setSystemIngestPipeline("_none");  
        assertTrue(indexRequest.isPipelineResolved());
import org.opensearch.cluster.ClusterChangedEvent;
            new BytesArray("{\"processors\": [], \"description\": \"_description\"}"),
        boolean hasPipeline2 = ingestService.resolvePipelines(indexRequest2, indexRequest2, metadata);  
        final List<Integer> dropHandler = new ArrayList<>();
            .source(emptyMap())  
        assertThat(ingestService.pipelines().get("_id2").pipeline.getId(), equalTo("_id2"));  
        verify(mockCompoundProcessor, never()).batchExecute(any(), any());
        bulkRequest.add(indexRequest1);
        });
            assertThat(e.getMessage(), equalTo("pipeline [z*] is missing"));  
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
import org.junit.Before;
        // Second time use the cache directly
                Names.WRITE
            "default",
            1,  
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);  
            .setPipeline("_id")
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
        String id = "_id";
        IngestService ingestService = createIngestServiceWithProcessors();  
        } catch (ResourceNotFoundException e) {
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),  
        );
        IngestService ingestService = createIngestServiceWithProcessors();
        );
        BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        @SuppressWarnings("unchecked")
        final List<Processor> processors = Collections.singletonList(onFailureProcessor);
        systemProcessors.put("dummy", systemProcessorFactory);
import org.opensearch.plugins.IngestPlugin;
            MediaTypeRegistry.JSON  
        PutPipelineRequest putRequest = new PutPipelineRequest(  
                    + "      }\n"  
            .source(emptyMap())
        assertThat(ingestService.getPipeline("q1"), nullValue());
        try {
        when(indexMetadata.getIndex()).thenReturn(index);  
        }  
            MediaTypeRegistry.JSON
            @SuppressWarnings("unchecked")
        clusterState = IngestService.innerPut(putRequest, clusterState);  
        @SuppressWarnings("unchecked")
import java.util.Collections;
        // verify we use the system pipeline from the cache
    }
            null,
        assertThat(pipeline.getId(), equalTo(id));
        bulkRequest.add(indexRequest1);
            .execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());  
                    + "                },\n"
        assertTrue(dropHandler.isEmpty());
        final Index index = new Index("idx", "uuid");
            .setSystemIngestPipeline("_none");
                    assertThat(counter.compareAndSet(1, 2), is(true));
        PipelineConfiguration pipeline1 = new PipelineConfiguration("_id1", new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON);  
        assertThat(ingestService.pipelines().get("_id3").pipeline.getId(), equalTo("_id3"));  
            .setFinalPipeline("_none")
        @NonNull final SystemIngestPipelineCache cache
        IngestService ingestService = createIngestServiceWithProcessors(
        );
            }
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        when(processor.getType()).thenReturn("mock");  
        final List<Integer> dropHandler = new ArrayList<>();  
                .numberOfReplicas(0);
    }  
        final Map<Integer, Exception> failureHandler = new HashMap<>();  
import org.opensearch.ResourceNotFoundException;
                    ingestDocument.setFieldValue(metadata.getFieldName(), "update" + metadata.getFieldName());
        ingestService.executeBulkRequest(
            @SuppressWarnings("unchecked")  
    }  
    private static IngestService createIngestServiceWithProcessors() {
                    + "                      }\n"
        assertEquals(failureHandler.get(1).size(), 1);
        return argThat(new IngestDocumentMatcher("_index", "_type", "_id", -3L, VersionType.INTERNAL, source));  
 * GitHub history for details.
            .source(emptyMap())  
        final Map<Integer, List<Exception>> failureHandler = new HashMap<>();
                return Collections.singletonMap("test", (factories, tag, description, config) -> {
 * the Apache License, Version 2.0 (the "License"); you may
        // verify  
        IngestDocumentMatcher(String index, String type, String id, Map<String, Object> source) {  
            "_id",
        putRequest = new PutPipelineRequest(
        );
import static org.mockito.ArgumentMatchers.anyInt;  
                "{\n"
            MediaTypeRegistry.JSON
        when(indexMetadata.getIndex()).thenReturn(index);  
    }  
        IndexRequest indexRequest2 = new IndexRequest("idx");
            .setSystemIngestPipeline("_none");
            Collections.singletonList(indexRequest),
        BulkRequest bulkRequest = new BulkRequest();
            doAnswer(invocationOnMock -> {
import java.util.stream.Collectors;
        }
import java.util.function.LongSupplier;  
        when(clusterService.getClusterSettings()).thenReturn(
        IndexRequest indexRequest = new IndexRequest("idx");
        final Index index = new Index("idx", "uuid");
import static org.mockito.Mockito.doThrow;
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        pipelines = IngestService.innerGetPipelines(ingestMetadata, "_id*");  
    private ClusterState createPipeline(String pipeline, BytesArray config, IngestService ingestService, ClusterState previousState) {
        ClusterState previousClusterState = clusterState;
        // Delete pipeline matching wildcard
        processors.put("dummy", (factories, tag, description, config) -> new CompoundProcessor(false, List.of(dummyProcessor), List.of()));
            String value = (String) config.remove("value");  
                .putMapping("{}")  
            bulkRequest.requests(),  
        doAnswer(invocationOnMock -> {  
            .source(emptyMap())  
        return createPipeline(pipeline, new BytesArray("{\"processors\": [{\"mock\" : {}}]}"), ingestService, previousState);
            .setPipeline("pipeline")
            .source(emptyMap())
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
                null,
            Names.WRITE
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
        verify(failureHandler, never()).accept(any(), any());
                .build()
import java.util.concurrent.ExecutorService;  
            .setPipeline("_id")  
import java.util.function.IntConsumer;
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getSystemIngestPipeline());
        Pipeline pipeline = ingestService.getPipeline(id);
        verify(failureHandler, times(1)).accept(  
            ),
        verify(dummyFinalProcessor, times(1)).execute(any(), any());  
            "_id1",
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            clusterService,
        assertStats(afterThirdRequestStats.getTotalStats(), 3, 0, 0);  
        assertThat(stats.getCurrent(), equalTo(0L));  
        // verify
        indexRequest.setPipeline("_id2");
            for (IngestDocument.Metadata metadata : IngestDocument.Metadata.values()) {  
            .setSystemIngestPipeline("[_index/template]")  
        assertThat(pipelines.get(1).getId(), equalTo("_id2"));
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1").source(emptyMap()).setPipeline("_id").setFinalPipeline("_none");  
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);  
            .setSystemIngestPipeline("_none");
                }
            "_id3",
    }
import org.mockito.ArgumentMatcher;  
            new IngestDocumentWrapper(1, 0, null, new RuntimeException()),
        assertThat(ingestService.getProcessorsInPipeline(id, FakeProcessor.class).size(), equalTo(2));  
        IngestService ingestService = createIngestServiceWithProcessors(  
        PutPipelineRequest putRequest = new PutPipelineRequest(id, new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON);
            return null;
    private IngestDocument eqIndexTypeId(final Map<String, Object> source) {
        );
        @SuppressWarnings("unchecked")  
        ClusterState previousClusterState = clusterState;  
                .putMapping("{}")
            .putAlias(AliasMetadata.builder("alias").writeIndex(true).build());  
                    + "                  }\n"
        verify(mockCompoundProcessor, never()).execute(any(), any());  
        assertStats(initialStats.getTotalStats(), 0, 0, 0);
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
            .setPipeline("_id")
        assertThat(afterForthRequestStats.getPipelineStats().size(), equalTo(2));
        PutPipelineRequest putRequest = new PutPipelineRequest(
            .setSystemIngestPipeline("_none");  
        DeletePipelineRequest deleteRequest = new DeletePipelineRequest("p*");  
            failureHandler,  
        processors.put("complexSet", (factories, tag, description, config) -> {  
        final ClusterState previousClusterState = ClusterState.builder(new ClusterName("_name")).metadata(previousMetadata).build();  
        bulkRequest.add(indexRequest2);  
            return new ConditionalProcessor(
        bulkRequest.add(indexRequest3);
        assertThat(indexRequest.getPipeline(), equalTo("_none"));
        }
        IngestService ingestService = createIngestServiceWithProcessors();
        verify(mockCompoundProcessor, times(2)).batchExecute(any(), any());  
        IndexRequest indexRequest = new IndexRequest("idx");
            .patterns(Collections.singletonList("id*"))  
            "_id1",
        IndexRequestWrapper wrapper4 = createIndexRequestWrapper(  
        );  
            Collections.singletonList(indexRequest),
        IngestService ingestService = new IngestService(
            handler.accept(null, new RuntimeException());
        );
    public void testIngestPlugin() {
            .setSystemIngestPipeline("_none");
        Settings newSettings = Settings.builder().put("cluster.ingest.max_number_processors", 7).build();
            .setFinalPipeline("_id")
        bulkRequest.add(indexRequest1);  
        // get all variants: (no IDs or '*')  
            MediaTypeRegistry.JSON  
        IngestService ingestService = createIngestServiceWithProcessors(  
        ingestService.executeBulkRequest(
import java.util.function.BiConsumer;  
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getPipeline());  
        );  
            .source(emptyMap())
            builder.field("data", "This is my data".getBytes(StandardCharsets.UTF_8));  
            return null;
    }
            (factories, tag, description, config) -> new CompoundProcessor(false, List.of(defaultProcessor), List.of())
        assertEquals(Set.of(1, 2), failureHandler.keySet());
import org.opensearch.transport.client.Client;
            .metadata(Metadata.builder().putCustom(IngestMetadata.TYPE, ingestMetadata))  
            if (randomBoolean()) {
            MediaTypeRegistry.JSON
            return null;
            );  
        );
        assertThat(ingestService.getProcessorsInPipeline(id, WrappingProcessor.class).size(), equalTo(1));
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getSystemIngestPipeline());
        assertThat(ingestService.getPipeline("q1"), notNullValue());  
        ingestService.applyClusterState(new ClusterChangedEvent("_name", clusterState, clusterState));  
    }
        PutPipelineRequest putRequest = new PutPipelineRequest(
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        );  
        bulkRequest.add(new DeleteRequest("_index", "_id"));  
        @SuppressWarnings("unchecked")
                    + "        \"field\": \"timestamp_field_1\",\n"  
        // index name matches with IDM:  
                    + "                    \"value\": \"failed\",\n"  
        public boolean matches(IngestDocument o) {  
        clusterState = IngestService.innerPut(putRequest, clusterState);
                updateRequest.doc(indexRequest);  
        ClusterState previousClusterState = clusterState;  
    }
        int numOtherRequests = scaledRandomIntBetween(4, 32);  
    public void testGetProcessorsInPipeline() throws Exception {  
        assertThat(ingestService.getPipeline("p2"), nullValue());
            indexRequest.source(Requests.INDEX_CONTENT_TYPE, "field1", "value1");  
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))
                    + "            \"set\": {\n"
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        // processor  
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer<IngestDocument, Exception>) invocationOnMock.getArguments()[1];
        assertThat(afterSecondRequestStats.getPipelineStats().size(), equalTo(2));
            "_id",
        );
        Metadata metadata = Metadata.builder().indices(Map.of("idx", indexMetadata)).build();
            bulkRequest.requests(),
import static org.hamcrest.Matchers.is;
            dropHandler::add,
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
            return null;
            .setSystemIngestPipeline("_none");
        assertThat(stats.getFailedCount(), equalTo(failed));
import static org.mockito.Mockito.argThat;  
            Collections.singletonList(processor),
            .setFinalPipeline("_none")
import org.opensearch.script.ScriptModule;
 * specific language governing permissions and limitations
    }  
        final IngestStats initialStats = ingestService.stats();  
        assertThat(pipelines.get(0).getId(), equalTo("_id1"));  
            return Collections.singletonMap("foo", (factories, tag, description, config) -> null);
            new IngestDocumentWrapper(1, 1, null, new RuntimeException()),
        ScriptService scriptService = new ScriptService(
                client,  
        final Processor processorFailure = mock(Processor.class);
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),  
    }  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
                } else if (metadata == IngestDocument.Metadata.IF_PRIMARY_TERM) {
        assertEquals(List.of(2), dropHandler);  
            "Pipeline id [%s] exceeds maximum length of 512 UTF-8 bytes (actual: 513 bytes)",  
            .setSystemIngestPipeline("_none");  
        when(clusterService.getClusterSettings()).thenReturn(
 */  
            Collections.singletonList(indexRequest),
            .setPipeline("_none")
        ingestService.executeBulkRequest(
            }).when(dummySystemProcessor).batchExecute(any(), any());  
        @SuppressWarnings("unchecked")
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
            bulkRequest.add(indexRequest);
                    + "                        }\n"  
    public void testResolvePipelines_whenUseTemplateV2() throws Exception {
        ingestInfos.put(node2, new IngestInfo(Arrays.asList(new ProcessorInfo("set"))));
        pipelines.put("p1", new PipelineConfiguration("p1", definition, MediaTypeRegistry.JSON));  
    }
            completionHandler::put,  
import static org.hamcrest.Matchers.notNullValue;  
        assertThat(pipelines.size(), equalTo(2));
    }
        // The number of processors for the "id1" pipeline changed, so the per-processor metrics are not carried forward. This is
            bulkRequest.requests(),
        ingestService.executeBulkRequest(2, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
            .setSystemIngestPipeline("_none");  
        ingestService.executeBulkRequest(
            () -> new IngestService(
            }).when(dummySystemProcessor).execute(any(), any());
import org.mockito.Mock;
                bulkRequest.add(new DeleteRequest("_index", "_id"));  
            @SuppressWarnings("unchecked")  
            indexMetadata2,
        Map<DiscoveryNode, IngestInfo> ingestInfos = new HashMap<>();
    }
        Consumer<IngestDocument> executor = doc -> reference.set(doc.getFieldValueAsBytes("data"));  
            }
            handler.accept(document, null);
        ExecutorService executorService = OpenSearchExecutors.newDirectExecutorService();
import org.opensearch.action.ingest.PutPipelineRequest;  
            Collections.singletonMap("mock", (factories, tag, description, config) -> processor)
        verify(dropHandler, times(1)).accept(1);  
    public void testExecuteBulkRequestInBatchWithDefaultAndFinalPipeline() {
            new IngestDocumentWrapper(2, 0, null, new RuntimeException()),  
        assertThat(ingestService.pipelines().get("_id1").pipeline.getProcessors().size(), equalTo(0));  
    }
    public void testExecuteFailureWithNestedOnFailure() throws Exception {  
            .build();
        assertThat(indexRequest.isPipelineResolved(), is(true));  
        try {  
import static org.mockito.Mockito.doAnswer;
                    + "                  \"set\": {\n"
            MediaTypeRegistry.JSON
        ingestService.applyClusterState(new ClusterChangedEvent("", state, state));
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);  
                    + "                          \"field\": \"ingest_error2\",\n"
        IngestService ingestService = createIngestServiceWithProcessors(emptyMap());  
        bulkRequest.add(indexRequest2);
        );  
        final ClusterState currentClusterState = ClusterState.builder(new ClusterName("_name")).metadata(currentMetadata).build();
            .source(emptyMap())
        final List<Processor> onFailureProcessors = Collections.singletonList(onFailureOnFailureProcessor);
            .setFinalPipeline("_none");
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        assertThat(ingestService.getPipeline("_id"), notNullValue());
                    + "{\"remove\" : {\"field\": \"_field\", \"tag\": \"tag2\"}}]}"
        IndexRequestWrapper wrapper2 = createIndexRequestWrapper(
    public void testIngestServiceCreation_whenInvalidSystemProcessor_thenFail() {
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
            "_id",
            .setFinalPipeline("_none")  
        ingestService.executeBulkRequest(
        when(processor.getType()).thenReturn(name);
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
            Metadata metadata = Metadata.builder().build();
        // only 1 time for set up  
            MediaTypeRegistry.JSON
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        bulkRequest.add(indexRequest1);
        assertEquals(Set.of(1), failureHandler.keySet());
        }), client, mock(IndicesService.class), mock(NamedXContentRegistry.class), spy(new SystemIngestPipelineCache()));
        SystemIngestPipelineCache systemIngestPipelineCache = ingestService.getSystemIngestPipelineCache();
            new BytesArray("{\"processors\": [{\"test\" : {}}]}"),
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        BiConsumer<Integer, Exception> requestItemErrorHandler = mock(BiConsumer.class);  
        IngestService ingestService = createIngestServiceWithProcessors();  
                    + "{\"remove\" : {\"field\": \"_field\", \"tag\": \"tag2\"}}]}"
        doAnswer(args -> {
        // match all wildcard works on last remaining pipeline
        doThrow(new RuntimeException()).when(processor)
        @SuppressWarnings("unchecked")
        final IngestService ingestService = createIngestServiceWithProcessors();  
import static org.hamcrest.Matchers.nullValue;
        when(clusterService.getClusterSettings()).thenReturn(
            .setPipeline("_id")
        );
            .source(emptyMap())
        clusterState = IngestService.innerPut(putRequest, clusterState);  
        // only 1 time for set up
        DeletePipelineRequest deleteRequest = new DeletePipelineRequest(id);  
        Client client = mock(Client.class);
            .setFinalPipeline("_none")
            Collections.singletonMap("mock", (factories, tag, description, config) -> compoundProcessor)  
        // prepare test data
    }
        final Processor processor = mock(Processor.class);
            assertThat(indexRequest.isPipelineResolved(), is(true));
        List<PipelineConfiguration> pipelines = IngestService.innerGetPipelines(ingestMetadata, "_id1");  
        errorHandler.values().forEach(e -> assertEquals(e.getCause(), error));
        when(dummySystemProcessor.isSystemGenerated()).thenReturn(true);
        assertProcessorStats(0, afterSecondRequestStats, "_id2", 1, 0, 0);
        assertThat(pipeline, notNullValue());
                public String getType() {
        threadPool = mock(ThreadPool.class);  
        final IngestService ingestService = createIngestServiceWithProcessors();
        pipelines.sort(Comparator.comparing(PipelineConfiguration::getId));
            assertThat(result, is(true));
        when(threadPool.executor(anyString())).thenReturn(executorService);
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
import static org.mockito.Mockito.verify;
        String pipelineId = "_id";
            new BytesArray("{\"processors\": [{\"failure-mock\" : { \"on_failure\": [{\"mock\" : {}}]}}, {\"mock\" : {}}]}"),  
        doAnswer(invocationOnMock -> {
        clusterState = IngestService.innerPut(putRequest, clusterState);  
            .source(emptyMap())
        bulkRequest.add(indexRequest2);  
        final Map<Thread, Exception> completionHandler = new HashMap<>();
    private IngestDocument eqIndexTypeId(final Long version, final VersionType versionType, final Map<String, Object> source) {  
            .source(emptyMap())
        verifySystemPipelineResolvedSuccessfully("[idx/template]", hasPipeline, indexRequest, cache);
            .setFinalPipeline("_id")
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
        // mock a system pipeline do nothing  
        ClusterState previousClusterState = clusterState;
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
        assertThat(IngestService.getProcessorName(conditionalProcessor), equalTo(name + ":" + tag));  
        verify(mockCompoundProcessor, never()).execute(any(), any());  
        final Pipeline dummyPipeline = new Pipeline("id", null, null, new CompoundProcessor());
            .setPipeline("_id")
        IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder("name1")
        Exception e = expectThrows(IllegalStateException.class, () -> ingestService.validatePipeline(emptyMap(), putRequest));
        when(indexMetadata.getIndex()).thenReturn(new Index("_index", "uuid"));
        PutPipelineRequest putRequest = new PutPipelineRequest(  
        String tag = randomAlphaOfLength(10);  
        IndexRequest indexRequest = new IndexRequest(index);  
        map.put(key1, value1);
        when(processor.getTag()).thenReturn("mock_processor_tag");  
        int numRequest = scaledRandomIntBetween(8, 64);
            failureHandler::put,
            @Override
            completionHandler::put,  
            @SuppressWarnings("unchecked")
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
            public String getTag() {  
        final CompoundProcessor processor = mockCompoundProcessor();  
            "index3",  
            MediaTypeRegistry.JSON
    public void setup() throws Exception {
    public void testResolvePipelines_whenExistingIndexAndSystemPipelineDisabled_thenNoSystemPipeline() throws Exception {
            .setFinalPipeline("_none")
            .source(emptyMap())
        ingestService.executeBulkRequest(
                .putMapping("{}")
            .setFinalPipeline("final_pipeline")
            .setPipeline("_id")
        for (int i = 0; i < numRequest; i++) {
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
            "_id",
        });
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
import reactor.util.annotation.NonNull;
                    + "                              }\n"  
        // processor
            MediaTypeRegistry.JSON
        @SuppressWarnings("unchecked")
            IndexMetadata.builder("idx")
        DiscoveryNode node1 = new DiscoveryNode("_node_id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertNotNull(cache.getSystemIngestPipeline(index1.toString()));
        // add pipeline
            .setFinalPipeline("final_pipeline")
            numRequest,
        PutPipelineRequest putRequest = new PutPipelineRequest(  
        ClusterService clusterService = mock(ClusterService.class);
    private Map<String, Processor.Factory> createDummyMockSystemProcessors(Processor dummySystemProcessor, boolean isBatch)
        );
    }  
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")  
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")  
        final IndexMetadata indexMetadata = spy(
        bulkRequest.add(indexRequest2);
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            .setSystemIngestPipeline("_none");
        result = ingestService.resolvePipelines(updateRequest, TransportBulkAction.getIndexWriteRequest(updateRequest), metadata);  
        final IndexMetadata indexMetadata = spy(
        // invoke
            new BytesArray("{\"processors\": [{\"drop\" : {}}, {\"mock\" : {}}]}"),  
        // prepare systemIngestPipelineCache  
            List.of(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT), new IngestPipelineInfo("p2", IngestPipelineType.DEFAULT))
        // will not be handled as not valid document type  
        IngestPlugin testPlugin = new IngestPlugin() {
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))  
        String errorMessage = String.format(
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
        final IndexRequest indexRequest = new IndexRequest("_index");
        IndexRequestWrapper wrapper3 = createIndexRequestWrapper(
            .setFinalPipeline("_none")
                return null;
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getFinalPipeline());
        Settings newSettings = Settings.builder().put("cluster.ingest.max_number_processors", 1).build();  
        systemIngestPipelineCache.cachePipeline(
        Map<K, V> map = new HashMap<>();
        assertEquals(4, batches.size());
                    + "          {\n"
        }).when(mockCompoundProcessor).batchExecute(any(), any());
        indexRequest = new IndexRequest("idx");  
        );
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        String id = "_id";
        // call
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer) args.getArguments()[1];
 * The OpenSearch Contributors require contributions made to  
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)  
        createPipeline("_id", ingestService);
            .setSystemIngestPipeline("_none");
        PutPipelineRequest putRequest = new PutPipelineRequest(  
        assertEquals(1, completionHandler.size());
        assertThat(afterFirstRequestStats.getPipelineStats().size(), equalTo(2));
            Names.WRITE  
        assertNull(cache.getSystemIngestPipeline(index3.toString()));  
        // call  
        ClusterState previousClusterState = clusterState;
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
        IngestService ingestService = createIngestServiceWithProcessors(processors);
        assertThat(indexRequest.ifSeqNo(), equalTo(ifSeqNo));
        clusterState = IngestService.innerPut(putRequest, clusterState);
        clusterState = IngestService.innerPut(putRequest, clusterState);
        IndexTemplateMetadata v1Template = IndexTemplateMetadata.builder("v1-template").patterns(Arrays.asList("fo*", "baz")).build();
                    + "                        \"set\": {\n"  
        assertThat(pipelines.get(1).getId(), equalTo("_id2"));
        pipeline = ingestService.getPipeline(id);
            null,
        final Processor.Factory systemProcessorFactory = mock(Processor.Factory.class);
            }
            .setSystemIngestPipeline("_none");
        // verify
                wrapper.update(wrapper.getIngestDocument(), error);
import java.util.Comparator;
        );
            .setFinalPipeline("_none")
        {  
    private static <K, V> Map<K, V> mapOf(K key, V value) {  
        BulkRequest bulkRequest = new BulkRequest();  
                    + "                    \"field\": \"ingest_error2\",\n"
            );
        IngestService ingestService = createIngestServiceWithProcessors(
        assertThat(ingestService.getProcessorsInPipeline(id, FakeProcessor.class).size(), equalTo(1));
        };
        clusterState = IngestService.innerDelete(deleteRequest, clusterState);
                    + "                      {\n"  
        configs.put("_id2", new PipelineConfiguration("_id2", new BytesArray("{\"processors\": []}"), MediaTypeRegistry.JSON));
        pipelines.put("p2", new PipelineConfiguration("p2", definition, MediaTypeRegistry.JSON));
                @Override
        );
        ingestMetadata = new IngestMetadata(mapOf("_id1", pipeline1, "_id2", pipeline2));  
        return map;
        BulkRequest bulkRequest = new BulkRequest();
        IngestService.innerDelete(matchAllDeleteRequest, clusterState);
                indexReq -> {},
                "{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\", \"tag\": \"tag1\"}},"
        final Map<Thread, Exception> completionHandler = new HashMap<>();
    public void testExecuteBulkRequestInBatchNoValidPipeline() {
        );  
        ingestService.validatePipeline(Collections.singletonMap(discoveryNode, ingestInfo), putRequest);  
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
import org.opensearch.action.index.IndexRequest;
        assertProcessorStats(0, afterForthRequestStats, "_id1", 1, 1, 0); // not carried forward since type changed
import org.opensearch.action.ingest.DeletePipelineRequest;
            .setPipeline("_id")  
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2").source(emptyMap()).setPipeline("_id").setFinalPipeline("_none");
        }).when(processor).batchExecute(any(), any());
        assertTrue(hasPipeline2);
            IndexMetadata.builder("idx")
        DiscoveryNode node1 = new DiscoveryNode("_node_id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
                // We attach a child index request
        Map<String, Processor.Factory> factories = ingestService.getProcessorFactories();
            .setFinalPipeline("_none")
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);  
        IngestService ingestService = createIngestServiceWithProcessors();
            public String getDescription() {
        // verify we resolve the system pipeline again and then cache it
        DiscoveryNode node2 = new DiscoveryNode("_node_id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            bulkRequest.requests(),
        assertThat("pipeline with id [fakeID] does not exist", equalTo(e.getMessage()));
        ingestService.executeBulkRequest(  
        clusterState = IngestService.innerPut(putRequest, clusterState);
        // create ingest service and cluster state
        metadata = Metadata.builder().put(templateBuilder).build();
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            indexReq -> {},
        String name = randomAlphaOfLength(10);  
            .setPipeline("_id")  
        clusterState = IngestService.innerDelete(deleteRequest, clusterState);
        map.put("mock", (factories, tag, description, config) -> processor);
            .source(emptyMap())
            @Override
        CompoundProcessor processor = mock(CompoundProcessor.class);
            argThat((IllegalArgumentException iae) -> "pipeline with id [does_not_exist] does not exist".equals(iae.getMessage()))
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
    }
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
import org.opensearch.core.common.bytes.BytesArray;
        IllegalArgumentException e = expectThrows(
        // index name matches with ITMD for bulk upsert:
            .setSystemIngestPipeline("_none");
            return Map.of("foo", mockSystemProcessorFactory);  
    }  
            Names.WRITE
        );
            this.ingestDocument = new IngestDocument(index, id, null, version, versionType, source);
            Names.WRITE  
        IngestService ingestService = createIngestServiceWithProcessors(  
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "v2-template", v2Template);
                    + "{\"remove\" : {\"field\": \"_field\", \"tag\": \"tag2\"}}]}"
        PutPipelineRequest putRequest = new PutPipelineRequest(
    }
        assertThat(ingestService.pipelines().get("_id1").pipeline.getId(), equalTo("_id1"));  
        // Sanity check that counter has been updated twice:  
            .setFinalPipeline("_none");
            }
        final Map<Thread, Exception> completionHandler = new HashMap<>();
        BulkRequest bulkRequest = new BulkRequest();
            String field = (String) config.remove("field");
        assertThat(updateRequest.upsertRequest().isPipelineResolved(), is(true));
        ingestService.executeBulkRequest(2, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);
        ingestInfos.put(node2, new IngestInfo(Arrays.asList(new ProcessorInfo("set"))));
        ingestService.executeBulkRequest(
            .build();
        );  
        if (isBatch) {  
        assertPipelineStats(afterSecondRequestStats.getPipelineStats(), "_id1", 1, 0, 0);  
        ClusterState previousClusterState = clusterState;
        }).when(defaultProcessor).batchExecute(any(), any());
    }
    public void testInvalidateCache() {
        assertThat(result, is(true));
            null,
            assertEquals(2, batches.get(i).size());
            MediaTypeRegistry.JSON  
    }
            String field = (String) config.remove("field");  
        assertThat(pipeline, nullValue());
            .setFinalPipeline("final_pipeline")
            .setSystemIngestPipeline("_none");
        );
        assertThat(pipeline.getProcessors().size(), equalTo(1));  
    public void testExecuteBulkRequestInBatchWithExceptionAndDropInCallback_requestsWithMatchingChildSlots() {  
        bulkRequest.add(indexRequest2);
        IngestMetadata ingestMetadata = new IngestMetadata(Collections.singletonMap("_id", config));
            failureHandler,
                .setFinalPipeline("_none")
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer) args.getArguments()[1];  
        String pipelineId = "_id";
        // overwrite existing pipeline:
    }
            .setFinalPipeline("_none")  
        assertTrue(dropHandler.isEmpty());  
    public void testIngestClusterStateListeners_orderOfExecution() {  
            .source(emptyMap())
        clusterState = IngestService.innerPut(putRequest, clusterState);
        bulkRequest.add(indexRequest4);
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
            .setPipeline("_id")
        return argThat(new IngestDocumentMatcher("_index", "_type", "_id", version, versionType, source));
        assertThat(ingestService.pipelines().size(), is(2));  
        assertTrue(hasPipeline);
import org.opensearch.action.delete.DeleteRequest;  
            List<IngestDocumentWrapper> documents = (List<IngestDocumentWrapper>) invocationOnMock.getArguments()[0];
                .numberOfShards(1)  
        );
            .setPipeline("_id")  
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);  
            .setFinalPipeline("_none")
            MediaTypeRegistry.JSON  
            MediaTypeRegistry.JSON
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        doAnswer(args -> {
        String id = "_id";
                BiConsumer<IngestDocument, Exception> handler = (BiConsumer<IngestDocument, Exception>) invocationOnMock.getArguments()[1];
        Map<String, Processor.Factory> systemProcessors = new HashMap<>();
        doAnswer(args -> {
        // prepare handler
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
                )  
        PutPipelineRequest putRequest = new PutPipelineRequest(
        createPipeline("_id", ingestService);
        PutPipelineRequest putRequest = new PutPipelineRequest(
            .metadata(Metadata.builder().putCustom(IngestMetadata.TYPE, ingestMetadata))
            assertThat(slot, equalTo(0));
            completionHandler,
            bulkRequest.requests(),
            1,
        IndexRequest indexRequest = new IndexRequest("idx");
        final IndexRequest indexRequest = new IndexRequest("idx");
        assertStats(stats.getProcessorStats().get(pipelineId).get(processor).getStats(), count, failed, time);  
            "_node_id",
 *    http://www.apache.org/licenses/LICENSE-2.0
        final IngestService ingestService = createIngestServiceWithProcessors();
            IndexMetadata.builder("idx")
        {
        BulkRequest bulkRequest = new BulkRequest();  
        ingestService.applyClusterState(new ClusterChangedEvent("", currentClusterState, previousClusterState));
    private ClusterState createPipeline(String pipeline, IngestService ingestService) {  
 * under the License.  
        {
            )
                null,
                    + "                    \"field\": \"ingest_error1\",\n"
        Processor processor = mock(Processor.class);
            longId
            Collections.singletonMap("mock", (factories, tag, description, config) -> processor)
    private CompoundProcessor mockCompoundProcessor() {
            .setFinalPipeline("_none");  
        assertThat(indexRequest.getPipeline(), equalTo("default-pipeline"));
            .getClusterSettings()
    }
        Map<K, V> map = new HashMap<>();  
        );
            handler.accept((IngestDocument) args.getArguments()[0], null);
            boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        );
        result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
            dropHandler::add,
        // mock a system pipeline do nothing
            .setPipeline("_id")
            IngestService.innerDelete(new DeletePipelineRequest("unknown"), clusterState);
            .setSystemIngestPipeline("_none");  
        );
            clusterService,  
    }  
import static java.util.Collections.emptySet;
        );  
    public void testPrepareBatches_different_index_pipeline() {
        );
            indexReq -> {},  
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
import static org.mockito.Mockito.verifyNoMoreInteractions;  
        // We add a default pipeline to index metadata to verify we DO NOT resolve it (only system pipeline)
        assertThat(pipeline.getDescription(), nullValue());
        );  
            .applySettings(Settings.builder().put(IngestService.SYSTEM_INGEST_PIPELINE_ENABLED.getKey(), false).build());  
            .getClusterSettings()
        Metadata metadata = Metadata.builder().indices(Map.of("_index", indexMetadata)).build();
            completionHandler,  
            IngestService.innerDelete(deleteRequest, clusterState);  
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        assertThat(updateRequest.upsertRequest().getPipeline(), equalTo("default-pipeline"));  
        assertThat(ingestService.getProcessorsInPipeline(id, ConditionalProcessor.class).size(), equalTo(0));
    }  
            threadPool,
    public void testTargetIndexChange() {  
            .setPipeline("_id")  
            .setPipeline("_id")  
        assertEquals(errorMessage, e.getMessage());  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty  
        BulkRequest bulkRequest = new BulkRequest();
        assertEquals(Set.of(Thread.currentThread()), completionHandler.keySet());
    @Mock
            .setPipeline("_none")
                return processors;
            @SuppressWarnings("unchecked")
            @SuppressWarnings("unchecked")  
        };
                    "failed to update ingest pipelines"
        ingestInfos.put(node2, new IngestInfo(Arrays.asList(new ProcessorInfo("set"))));  
            documents.get(0).getIngestDocument().setFieldValue("_index", "new_index");
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);  
        final Index index2 = new Index("index2", "uuid2");
        ClusterState previousClusterState = clusterState;  
        createPipeline("_id", ingestService);
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();  
        // call
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(IngestService.class))) {
            return null;
import java.util.Arrays;  
import org.opensearch.threadpool.ThreadPool.Names;
        systemIngestPipelineCache.cachePipeline(
        previousClusterState = clusterState;  
            .setPipeline("_id")  
        );
            Collections.singletonList(new IngestPipelineInfo("p2", IngestPipelineType.DEFAULT))
        assertPipelineStats(afterThirdRequestStats.getPipelineStats(), "_id1", 2, 0, 0);
            IndexMetadata.Builder builder = IndexMetadata.builder("idx")  
    public void testResolvePipelines_whenExistingIndex() throws Exception {
            .setPipeline("_id")
import static org.mockito.Mockito.spy;  
        ingestInfos.put(node1, new IngestInfo(Arrays.asList(new ProcessorInfo("set"), new ProcessorInfo("remove"))));
        IngestService ingestService = createIngestServiceWithProcessors();
                handler.accept(ingestDocument, null);
                IndexRequest indexRequest = new IndexRequest("_index").id("_id").source(Requests.INDEX_CONTENT_TYPE, "field1", "value1");
            .setFinalPipeline("_final")  
        );
                Collections.singletonList(indexRequest),
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();  
        assertNull(pipeline.getProcessors().get(0).getTag());
                mock(NamedXContentRegistry.class),
        ClusterState previousClusterState = clusterState;
        // create ingest service and cluster state
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
                    + "{\"remove\" : {\"field\": \"_field\", \"tag\": \"tag2\"}}]}"
        assertEquals(Set.of(Thread.currentThread()), completionHandler.keySet());
        assertEquals(Integer.MAX_VALUE, clusterSettings.get(IngestService.MAX_NUMBER_OF_INGEST_PROCESSORS).intValue());  
        // verify the default pipeline will process both requests and the final pipeline will only process the second  
            .source(emptyMap())
        );
        @Override
        });  
        // verify  
            indexReq -> {},
            .setFinalPipeline("_none");
                "{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\", \"tag\": \"tag1\"}},"
        } else {
        ingestInfos.put(node2, new IngestInfo(Arrays.asList(new ProcessorInfo("set"), new ProcessorInfo("remove"))));  
        );
            .source(Collections.emptyMap())
            buildNewFakeTransportAddress(),  
        // total
        assertThat(counter.get(), equalTo(2));
import org.apache.logging.log4j.LogManager;
            @Override
        BulkRequest bulkRequest = new BulkRequest();  
            Names.WRITE
                    + "                            }\n"
        verify(mockCompoundProcessor, times(1)).batchExecute(any(), any());
                    + "                            {\n"  
            Names.WRITE
            bulkRequest.requests(),
            new BytesArray("{\"processors\": [{\"mock\": {}}], \"description\": \"_description\"}"),  
        DeletePipelineRequest matchAllDeleteRequest = new DeletePipelineRequest("*");
        );
            .metadata(Metadata.builder().putCustom(IngestMetadata.TYPE, ingestMetadata))
                    + "                  \"set\": {\n"
        assertThat(ingestService.getPipeline("p1"), notNullValue());
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
        assertTrue(dropHandler.isEmpty());
        }).when(mockCompoundProcessor).batchExecute(any(), any());
    public void testBulkRequestExecution() throws Exception {  
        PutPipelineRequest putRequest = new PutPipelineRequest(
            Metadata metadata = Metadata.builder().build();
            @Override
        verify(dummySystemProcessor, times(1)).batchExecute(any(), any());
                    + "                {\n"  
                .numberOfShards(1)
            .source(emptyMap())
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
        ingestService.applyClusterState(new ClusterChangedEvent("", state, state));  
        boolean hasPipeline = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
            "_id",  
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
            .setPipeline("_id")
import org.opensearch.cluster.metadata.Metadata;  
                    + "            }\n"  
        pipeline = ingestService.getPipeline(id);  
        doAnswer(invocationOnMock -> {  
            .setPipeline("_none")
 * Licensed to Elasticsearch under one or more contributor  
        verifyNoMoreInteractions(cache);
            MediaTypeRegistry.JSON
        assertThat(IngestService.getProcessorName(processor), equalTo(name + ":" + tag));
            return null;
            .source(emptyMap())
            IngestDocument ingestDocument = (IngestDocument) invocationOnMock.getArguments()[0];
        assertThat(updateRequest.upsertRequest().isPipelineResolved(), is(true));
        BulkRequest bulkRequest = new BulkRequest();  
        pipeline = ingestService.getPipeline(id);  
            (factories, tag, description, config) -> new CompoundProcessor(false, List.of(dummyFinalProcessor), List.of())
            .setPipeline("_none")  
        Map<String, Processor.Factory> processors = new HashMap<>();  
import java.util.HashMap;  
            () -> ingestService.getProcessorsInPipeline("fakeID", Processor.class)  
            new BytesArray("{\"processors\": [{\"mock\" : {}}, {\"mock\" : {}}]}"),  
            Collections.singletonList(indexRequest),  
        BulkRequest bulkRequest = new BulkRequest();  
                    + "          {\n"  
        assertThat(pipeline, notNullValue());  
            bulkRequest.requests(),
            handler.accept(null, new RuntimeException("error"));
        final Map<Thread, Exception> completionHandler = new HashMap<>();
        bulkRequest.add(indexRequest1);  
                null,  
                bulkRequest.add(updateRequest);
        );
        verify(mockCompoundProcessor, never()).batchExecute(any(), any());
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")
import static org.hamcrest.Matchers.equalTo;
            public Map<String, Processor.Factory> getSystemIngestProcessors(Processor.Parameters parameters) {
            Names.WRITE
            requestItemErrorHandler,  
import org.opensearch.common.metrics.OperationStats;
        assertThat(ingestService.getProcessorsInPipeline(id, ConditionalProcessor.class).size(), equalTo(2));  
            completionHandler,
                .build()  
        IngestService ingestService = createIngestServiceWithProcessors(
        final Exception exception = assertThrows(RuntimeException.class, () -> createIngestServiceWithProcessors(processors, processors));
        ingestService.executeBulkRequest(  
        assertThat(ingestService.pipelines().get("_id2").pipeline.getProcessors().size(), equalTo(0));
        );
        assertEquals(Set.of(Thread.currentThread()), completionHandler.keySet());
        // process cluster state change event  
        }
            () -> ingestService.validatePipeline(ingestInfos, putRequest)  
        assertThat(pipelines.size(), equalTo(1));
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")  
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)  
                    return new FakeProcessor("test", tag, description, ingestDocument -> {});  
        when(processorFailure.getType()).thenReturn("failure-mock");
            String field = (String) config.remove("field");
                    + "            }\n"
 * not use this file except in compliance with the License.
            .source(emptyMap())
        ingestService.executeBulkRequest(  
            Collections.singletonMap("foo", (factories, tag, description, config) -> new FakeProcessor("foo", tag, description, executor))
        IngestMetadata ingestMetadata = new IngestMetadata(pipelines);
        );
import java.util.ArrayList;
        IngestDocumentMatcher(String index, String type, String id, Long version, VersionType versionType, Map<String, Object> source) {
        boolean hasPipeline = ingestService.resolveSystemIngestPipeline(indexRequest, indexRequest, state.metadata());
        IndexRequest indexRequest2ChildSlot1 = new IndexRequest("_index").id("_id2")  
        afterFirstRequestStats.getProcessorStats().get("_id1").forEach(p -> assertEquals(p.getName(), "mock:mockTag"));
            .setPipeline("_id")
    }  
            handler.accept(RandomDocumentPicks.randomIngestDocument(random()), null);
        assertThat(ingestService.getProcessorsInPipeline(id, WrappingProcessorImpl.class).size(), equalTo(1));
            .setSystemIngestPipeline("_none");  
        BytesArray definition = new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}");
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        ClusterState previousClusterState = clusterState;
                    + "                  }\n"
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        assertThat(ingestService.getPipeline("p2"), notNullValue());
            .setPipeline("_none")
        );
        final CompoundProcessor compoundProcessor = new CompoundProcessor(  
        verifySystemPipelineResolvedSuccessfully("[idx/uuid]", hasPipeline, indexRequest, cache);
            new BytesArray("{\"processors\": [{\"mock\" : {}}]}"),
            indexMetadata3
        bulkRequest.add(indexRequest3ChildSlot0);  
        IngestService ingestService = new IngestService(
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
            }
            bulkRequest.numberOfActions(),
        List<List<IndexRequestWrapper>> batches = IngestService.prepareBatches(2, Arrays.asList(wrapper1, wrapper2, wrapper3, wrapper4));
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
    }  
import java.util.List;
        clusterState = IngestService.innerPut(putRequest, clusterState);  
        final Map<Thread, Exception> completionHandler = new HashMap<>();
        }  
        }).when(defaultProcessor).batchExecute(any(), any());  
        );
            null,  
                new MockLogAppender.SeenEventExpectation(
        IngestService ingestService = createIngestServiceWithProcessors(
 *
            failureHandler,
        );  
        assertTrue(failure.get());
        // pipeline
        assertEquals(2, batches.size());
                "{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\", \"tag\": \"tag1\"}},"  
        assertThat(result, is(true));  
        assertThat(indexRequest.routing(), equalTo("update_routing"));
        bulkRequest.add(indexRequest3ChildSlot1);  
        PutPipelineRequest putRequest = new PutPipelineRequest(
            mock(IndicesService.class),  
        HashMap<String, PipelineConfiguration> pipelines = new HashMap<>();
        // verify
import org.opensearch.cluster.node.DiscoveryNode;
                .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))
        assertThat(indexRequest.getFinalPipeline(), equalTo("final-pipeline"));  
        clusterState = ClusterState.builder(clusterState)
        verify(cache, times(1)).getSystemIngestPipeline(eq(id));
            .source(emptyMap())
            Collections.singletonList(indexRequest),  
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
            Version.CURRENT  
            @SuppressWarnings("unchecked")
    }  
        verify(mockCompoundProcessor, times(1)).execute(any(), any());
        assertThat(ingestService.pipelines().get("_id1").pipeline.getProcessors().size(), equalTo(0));
            .setPipeline("_id")  
            completionHandler,
        previousClusterState = clusterState;  
        // Processor factory should be invoked secondly after ingest cluster state listener:  
import org.opensearch.script.MockScriptEngine;
        final Map<String, Processor.Factory> systemProcessors = createDummyMockSystemProcessors(dummySystemProcessor, true);
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)  
        MatcherAssert.assertThat(completionHandler.keySet(), contains(Thread.currentThread()));  
        assertProcessorStats(1, afterForthRequestStats, "_id1", 2, 0, 0); // carried forward and added from old stats  
            IngestDocument document = (IngestDocument) invocationOnMock.getArguments()[0];  
                });
        verify(mockCompoundProcessor, never()).execute(any(), any());
    ) {  
        PipelineProcessor pipelineProcessor = mock(PipelineProcessor.class);
        for (int i = 0; i < numIndexRequests; i++) {
        PutPipelineRequest putRequest = new PutPipelineRequest(pipeline, config, MediaTypeRegistry.JSON);  
        assertThat(IngestService.innerGetPipelines(null, "_id1").isEmpty(), is(true));  
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")  
        verify(mockCompoundProcessor, never()).batchExecute(any(), any());
        );
            MediaTypeRegistry.JSON  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
            null,
                .putMapping("{}")  
        final long newVersion = randomLong();  
        assertThat(ingestService.pipelines().get("_id").pipeline.getId(), equalTo("_id"));
        Map<String, Processor.Factory> systemFactories = ingestService.getSystemProcessorFactories();
        bulkRequest.add(indexRequest3);
        BulkRequest bulkRequest = new BulkRequest();  
        // will not be handled as not valid document type
        assertThat(ingestService.pipelines().get("_id1").pipeline.getId(), equalTo("_id1"));
            failureHandler,
        // Delete existing pipeline:  
            failure.set(true);
    private OperationStats getPipelineStats(List<IngestStats.PipelineStat> pipelineStats, String id) {
        }).when(processor).execute(any(), any());  
        final IndexRequest indexRequest = new IndexRequest("idx");
    public void testExecuteBulkRequestInBatchFallbackWithOneDocument() {
        assertThat(ingestService.pipelines().get("_id3").pipeline.getId(), equalTo("_id3"));  
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);  
        );  
        bulkRequest.add(indexRequest1);  
        IndexRequest indexRequest4 = new IndexRequest("_index").id("_id4")  
        assertEquals("[set] is not a system generated processor factory.", exception.getMessage());  
        final boolean hasPipeline,  
        );
                .setSystemIngestPipeline("_none");  
        final IngestService ingestService = createIngestServiceWithProcessors();  
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))
            Names.WRITE
            emptyMap(),
        createPipeline("_id", ingestService);  
                    ctx.get("_type");
        bulkRequest.add(indexRequest2);  
 * Unless required by applicable law or agreed to in writing,
        IndexRequestWrapper wrapper4 = createIndexRequestWrapper(  
                .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))  
import static org.mockito.Mockito.any;
            "[_index/template]",  
            assertThat(result, is(true));  
            failureHandler,
        @SuppressWarnings("unchecked")  
        assertThat(ingestService.pipelines().get("_id1").pipeline.getProcessors().size(), equalTo(0));  
    }
        assertPipelineStats(afterForthRequestStats.getPipelineStats(), "_id1", 3, 0, 0);
        );
            bulkRequest.numberOfActions(),
            builder.startObject();
    private static Processor.Factory mockSystemProcessorFactory;  
            ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        DeletePipelineRequest deleteRequest = new DeletePipelineRequest("_id");  
            .setFinalPipeline("_none")
            .source(emptyMap())
            argThat((Integer item) -> item == 2),
        );
        assertThat(ingestService.getPipeline("_id"), notNullValue());  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty  
        final IndexRequest indexRequest = new IndexRequest("idx");  
        ingestService.executeBulkRequest(
            1,
                (integer, e) -> {},
        assertThat(reference.get(), is(instanceOf(byte[].class)));  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty  
            indexReq -> {},
            Names.WRITE  
        @SuppressWarnings("unchecked")
        }).when(processor).execute(any(IngestDocument.class), any());  
                    + "                    \"tag\": \"tagggg\"\n"
    public void testResolveSystemIngestPipeline_whenExistingIndexAndSystemPipelineDisabled_thenNoSystemPipeline() throws Exception {
        }
            new BytesArray(  
                mock(SystemIngestPipelineCache.class)  
                    throw new IllegalStateException("error");
        @SuppressWarnings("unchecked")  
    }
        // verify
            "_id",  
        putRequest = new PutPipelineRequest(  
            dropHandler::add,
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
import org.opensearch.script.ScriptService;
            return new FakeProcessor("set", tag, description, (ingestDocument) -> ingestDocument.setFieldValue(field, value));  
        String id = "_id";
        assertThat(pipeline.getProcessors().size(), equalTo(1));  
        );
        assertThat(pipelines.get(0).getId(), equalTo("_id1"));
        verify(processor).execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());  
        BulkRequest bulkRequest = new BulkRequest();
            .setPipeline("_id")
        final IngestStats afterFirstRequestStats = ingestService.stats();
        final Processor onFailureProcessor = mock(Processor.class);
        when(indexMetadata.getIndex()).thenReturn(index);
        assertProcessorStats(0, afterFirstRequestStats, "_id2", 0, 0, 0);
        IngestService ingestService = createIngestServiceWithProcessors(factories);  
        assertThat(ingestService.pipelines().get("_id3").pipeline.getProcessors().size(), equalTo(1));  
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer) args.getArguments()[1];  
            Collections.singletonMap("mock", (factories, tag, description, config) -> compoundProcessor)
            completionHandler,  
            }
        assertFalse(hasPipeline);  
        bulkRequest.add(indexRequest2);  
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
            boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)  
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);  
        bulkRequest.add(indexRequest4);  
        assertThat(ingestService.pipelines().size(), is(0));
        final Map<Thread, Exception> completionHandler = new HashMap<>();
            .setSystemIngestPipeline("[_index/uuid]")
 * compatible open source license.
        indexRequest.setPipeline("_id1");  
            handler.accept(results);
    ) {  
        if (previousState != null) {
    public void testStats() throws Exception {  
        // processor, parallel arrays are the best option for of carrying forward metrics between pipeline changes. However, in some cases,  
            indexReq -> {},
                } else if (metadata == IngestDocument.Metadata.VERSION_TYPE) {  
        // mock
            .setPipeline("_id")
        );
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        }  
        IndexRequest indexRequest = new IndexRequest("idx");
    public void testExecuteBulkRequestWithSystemPipelineButCacheNotAvailable() throws Exception {
        pipelines = IngestService.innerGetPipelines(ingestMetadata);
    public void testResolveSystemIngestPipeline_whenExistingIndex() throws Exception {
        }
            "_id",
        verify(failureHandler, never()).accept(any(), any());  
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
            .setFinalPipeline("_none")  
        assertEquals(1, completionHandler.size());  
        // pipeline
            .metadata(Metadata.builder().putCustom(IngestMetadata.TYPE, ingestMetadata))
        assertThat(ingestService.pipelines().get("_id1").pipeline.getId(), equalTo("_id1"));
        Map<DiscoveryNode, IngestInfo> ingestInfos = new HashMap<>();  
        // mock
        return createIngestServiceWithProcessors(processors, Collections.emptyMap());  
            indexMetadata1,  
            .setPipeline("_id")
        return createPipeline(pipeline, ingestService, null);
            .source(emptyMap())
                    ingestDocument.setFieldValue(metadata.getFieldName(), versionType);
        Client client = mock(Client.class);  
        // index name matches with IDM:  
        ingestService.applyClusterState(new ClusterChangedEvent("", state, state));
        cache.cachePipeline("[" + index3.getName() + "/template]", dummyPipeline, 10);
            buildNewFakeTransportAddress(),
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
import static org.hamcrest.Matchers.hasSize;  
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")  
            100
        Exception error = new RuntimeException();
        clusterState = ClusterState.builder(clusterState)  
            IndexRequest indexRequest = new IndexRequest("idx").setPipeline("request-pipeline");
        verify(failureHandler, never()).accept(eq(0), any(IngestProcessorException.class));
        pipeline = ingestService.getPipeline(id);
        ClusterState previousClusterState = clusterState;
        UpdateRequest updateRequest = new UpdateRequest("idx", "id1").upsert(emptyMap()).script(mockScript("1"));
    public void testStatName() {
            "_id",
        @SuppressWarnings("unchecked")  
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();  
        PutPipelineRequest putRequest = new PutPipelineRequest(
            Collections.singletonMap("mock", (factories, tag, description, config) -> new AbstractProcessor("mock", "description") {
        );
        @SuppressWarnings("unchecked")
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
import static org.mockito.Mockito.times;
    }
    private ClusterState createPipeline(String pipeline, IngestService ingestService, ClusterState previousState) {
        final IngestStats afterThirdRequestStats = ingestService.stats();  
        IndexRequest indexRequest = new IndexRequest("idx");
        bulkRequest.add(indexRequest1);
        // like this one it may not readily obvious why the metrics were not carried forward.
        @SuppressWarnings("unchecked")  
        @Override
    public void testInnerUpdatePipelines() {
            .source(emptyMap())  
            }  
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
        );
        // Perform an update with no changes:  
        when(pipelineProcessor.getType()).thenReturn(name);  
        createPipeline("_id", ingestService);
            handler.accept(ingestDocumentWrappers);  
            indexReq -> {},  
        processors.put(  
        assertThat(pipeline, nullValue());  
        // mock a final pipeline do nothing
        // add pipeline
            IndexRequest indexRequest = new IndexRequest("_index").id("_doc-id")  
        DiscoveryNode discoveryNode = new DiscoveryNode(  
        result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);  
        // prepare handler
        }
    }  
    public void testResolveSystemIngestPipeline_whenUseTemplateV2() throws Exception {
        ingestService.executeBulkRequest(  
        @SuppressWarnings("unchecked")
            handler.accept((List<IngestDocumentWrapper>) args.getArguments()[0]);
        // add index metadata for the new index
        return createIngestServiceWithProcessors(processors, systemProcessors);
        IngestService ingestService = createIngestServiceWithProcessors();
                    ingestDocument.setFieldValue(metadata.getFieldName(), ifSeqNo);  
                return null;
            Collections.singletonList(indexRequest),
        assertThat(afterThirdRequestStats.getPipelineStats().size(), equalTo(2));
        bulkRequest.add(indexRequest3);
        final CompoundProcessor compoundProcessor = new CompoundProcessor(
        assertTrue(failureHandler.isEmpty());
            Collections.singletonList(DUMMY_PLUGIN),  
        final Metadata previousMetadata = mock(Metadata.class);  
import org.opensearch.script.ScriptType;  
            indexReq -> {},
            bulkRequest.requests(),  
import org.opensearch.cluster.ClusterName;  
                    + "                                \"field\": \"ingest_error1\",\n"
        when(threadPool.generic()).thenReturn(executorService);
            .setSystemIngestPipeline("_none");
        ClusterState previousClusterState = clusterState;  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        assertThat(pipelines.get(0).getId(), equalTo("_id1"));
            MediaTypeRegistry.JSON  
        // initiate ingest service  
        @SuppressWarnings("unchecked")  
                public IngestDocument execute(IngestDocument ingestDocument) {  
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
        when(systemProcessorFactory.isSystemGenerated()).thenReturn(true);  
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        assertThat(pipeline.getProcessors().get(0).getType(), equalTo("unknown"));
            IllegalArgumentException.class,
        });
        private final IngestDocument ingestDocument;
        PutPipelineRequest putRequest = new PutPipelineRequest(
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);  
            "_id",  
import org.opensearch.script.Script;  
    public void testExecuteBulkPipelineDoesNotExist() {
    }
                    + "  \"processors\": [\n"  
import static org.mockito.Mockito.eq;  
        ingestService.executeBulkRequest(
        Processor defaultProcessor = mock(Processor.class);
        // one. This happens because the target index of the first doc is changed.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IndexMetadata.Builder builder = IndexMetadata.builder("idx")
            mock(SystemIngestPipelineCache.class)
            () -> ingestService.validatePipeline(Collections.singletonMap(discoveryNode, ingestInfo), putRequest)
                .numberOfReplicas(0)
            BiConsumer<IngestDocument, Exception> handler = (BiConsumer) args.getArguments()[1];  
            .setPipeline("_id")
            new BytesArray("{\"processors\": [{\"foo\" : {}}]}"),  
    public void testExecuteBulkRequestInBatchNoValidDocument() {  
        @SuppressWarnings("unchecked")
            .source(emptyMap())
import java.util.Locale;
        IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder("name1")  
            .putAlias(AliasMetadata.builder("alias").writeIndex(true).build());  
        final Index index = new Index("idx", "uuid");
            Names.WRITE
            MediaTypeRegistry.JSON
        );  
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
                    ingestDocument.setFieldValue(metadata.getFieldName(), ifPrimaryTerm);
            false,
            MediaTypeRegistry.JSON
        final AtomicInteger counter = new AtomicInteger(0);
            completionHandler,  
        // total  
        assertTrue(hasPipeline);  
                    + "      \"set\": {\n"
        boolean hasPipeline = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);  
        BulkRequest bulkRequest = new BulkRequest();
        @SuppressWarnings("unchecked")
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
        final IndexMetadata changedIndexMetadata2 = mock(IndexMetadata.class);  
        assertThat(indexRequest.isPipelineResolved(), is(true));
        metadata = Metadata.builder().put(templateBuilder).build();  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
        ExecutorService executorService = OpenSearchExecutors.newDirectExecutorService();  
        IllegalArgumentException e = expectThrows(  
            failureHandler,
        @SuppressWarnings("unchecked")
        // Ingest cluster state listener state should be invoked first:  
        // The first and second slots should have failures  
    public void testValidateProcessorCountForWithNestedOnFailureProcessorThrowsException() {  
            .setSystemIngestPipeline("_none");
        // will not be handled as not valid document type
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
        boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
            .setPipeline("_id")
        when(processor.getType()).thenReturn("mock");  
        }  
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
    }
            "index1",  
        verify(failureHandler, never()).accept(any(), any());  
        verify(systemIngestPipelineCache, times(1)).cachePipeline(any(), any(), anyInt());
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        );
    public void testPut() {
        verify(dummyProcessor, times(1)).batchExecute(any(), any());
            return null;
                    + "            ]\n"
            .isPipelineResolved(true);  
        when(mockSystemProcessorFactory.isSystemGenerated()).thenReturn(true);
        public Map<String, Processor.Factory> getSystemIngestProcessors(Processor.Parameters parameters) {
            new IngestDocumentWrapper(2, 1, null, new RuntimeException())
        }
            @SuppressWarnings("unchecked")
            false,  
        IndexMetadata indexMetadata = spy(  
        // verify
        final IndexMetadata indexMetadata1 = mock(IndexMetadata.class);
                .numberOfReplicas(0)
            .source(emptyMap())
        assertThat(ingestService.pipelines().get("_id").pipeline.getProcessors().get(0).getType(), equalTo("set"));
        return map;
                    + "                {\n"  
            .numberOfReplicas(0)
                    + "        \"value\": \"value\",\n"
    }  
        clusterState = IngestService.innerPut(putRequest, clusterState);  
                    "test1",
import java.util.function.Consumer;
        // call
            .setSystemIngestPipeline("_none");  
        assertThat(result, is(true));  
        verify(failureHandler, never()).accept(any(), any());  
        final Map<Thread, Exception> completionHandler = new HashMap<>();  
            return null;
            .setFinalPipeline("_none")  
        ClusterState state = ClusterState.EMPTY_STATE;
        assertEquals(1, completionHandler.size());
        DeletePipelineRequest deleteRequest = new DeletePipelineRequest("z*");
        // match all wildcard does not throw exception if none match
            new BytesArray("{\"processors\": [], \"description\": \"_description\"}"),  
        assertThat(ingestService.pipelines().size(), is(0));
            @Override
        when(processor.getTag()).thenReturn("mockTag");
        assertThat(IngestService.getProcessorName(processor), equalTo(name));
        @Override
            String field = (String) config.remove("field");
            .setPipeline("pipeline")
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")
            failureHandler::put,
            // Collect exceptions into a map of slots to list to inspect later
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        verify(mockCompoundProcessor, never()).execute(any(), any());  
        XContentType xContentType = randomFrom(
            Arrays.stream(XContentType.values()).filter(t -> Requests.INDEX_CONTENT_TYPE.equals(t) == false).collect(Collectors.toList())  
    }
                .build()  
            handler.accept(ingestDocument, null);
            "_id",
            assertThat(indexRequest.getPipeline(), equalTo("request-pipeline"));
        );  
            handler.accept(documents);  
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
                    null,
        bulkRequest.add(indexRequest2ChildSlot1);
        assertTrue(dropHandler.isEmpty());
    }
        final Processor dummySystemProcessor = mock(Processor.class);
 */  
        @SuppressWarnings("unchecked")
    public void testDeleteUsingWildcard() {
    public void testValidate() throws Exception {
        IngestService ingestService = createIngestServiceWithProcessors(  
        // request pipeline:  
            failure.set(true);
        ComposableIndexTemplate v2Template = new ComposableIndexTemplate(Arrays.asList("idx*"), null, null, null, null, null, null);
                    + "          }\n"
        IngestInfo ingestInfo = new IngestInfo(Collections.singletonList(new ProcessorInfo("set")));
    }  
        Map<String, IngestService.PipelineHolder> pipelines = ingestService.pipelines();
    public void testExecuteBulkRequestInBatchWithException() {  
            new BytesArray("{\"description\": \"empty processors\"}"),  
        // invoke
        doAnswer(args -> {
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));  
                Arrays.asList(DUMMY_PLUGIN, DUMMY_PLUGIN),
                .setFinalPipeline("_none");  
        final Index index3 = new Index("index3", "uuid3");
        IndexRequest indexRequest2 = new IndexRequest("_index").id("_id2")
        );  
        ClusterState previousClusterState = clusterState;
        final IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")  
            Collections.singletonList(new IngestPipelineInfo("p1", IngestPipelineType.DEFAULT))
        when(processor.getTag()).thenReturn("mockTag");
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
    public void testGetProcessorsInPipelineComplexConditional() throws Exception {
        IngestService ingestService = createIngestServiceWithProcessors(
            1,  
        assertStats(afterSecondRequestStats.getTotalStats(), 2, 0, 0);
        DocWriteRequest<?> actionRequest = new IndexRequest(index);
        state = metadataIndexTemplateService.addIndexTemplateV2(state, false, "v2-template", v2Template);
        AtomicReference<Object> reference = new AtomicReference<>();
        bulkRequest.add(indexRequest2);
 * this file be licensed under the Apache-2.0 license or a
        when(changedIndexMetadata2.getIndex()).thenReturn(index2);
        // mock  
        Metadata metadata = Metadata.builder().indices(Map.of("_index", indexMetadata)).build();  
        verify(processor).execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());
        ingestMetadata = new IngestMetadata(mapOf("_id1", pipeline1, "_id3", pipeline3));  
        clusterState = IngestService.innerPut(putRequest, clusterState);
        assertThat(pipeline.getProcessors().size(), equalTo(0));  
        final IngestService ingestService = createIngestServiceWithProcessors();
            .build();  
    }  
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
            completionHandler::put,
        ingestService.executeBulkRequest(
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
            assertThat(e.getMessage(), equalTo("pipeline [_id] is missing"));
            Consumer<List<IngestDocumentWrapper>> handler = (Consumer<List<IngestDocumentWrapper>>) invocationOnMock.getArguments()[1];  
                return null;
            "_id",
                null,  
    }
    public void testDelete() {
                .build()
            Names.WRITE
            .setFinalPipeline("final_pipeline")
            1,  
        final CompoundProcessor processor = mockCompoundProcessor();
        final Map<Integer, Exception> failureHandler = new HashMap<>();
        assertThat(ingestService.pipelines().get("_id").pipeline.getProcessors().size(), equalTo(1));
            .setFinalPipeline("_none")
            List<IngestDocumentWrapper> ingestDocumentWrappers = (List) args.getArguments()[0];
            Collections.singletonList(indexRequest),  
        // invoke
        // mock a final pipeline do nothing  
    }
    }
            bulkRequest.requests(),
 * Modifications Copyright OpenSearch Contributors. See
        );
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
                    + "                }\n"  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        verifySystemPipelineResolvedSuccessfully("[idx/template]", hasPipeline, indexRequest, cache);
            null,  
    public void testResolveRequestOrDefaultPipelineAndFinalPipeline() {  
            .applySettings(Settings.builder().put(IngestService.SYSTEM_INGEST_PIPELINE_ENABLED.getKey(), false).build());
            "_id",
            .execute(eqIndexTypeId(indexRequest.version(), indexRequest.versionType(), emptyMap()), any());
        );  
            };
        final Map<Integer, Exception> failureHandler = new HashMap<>();  
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);  
                }), Collections.emptyMap())  
        final long ifSeqNo = randomNonNegativeLong();
        CompoundProcessor processor = mock(CompoundProcessor.class);  
                    + "              \"value\": \"failed\",\n"  
        String id = "_id";
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty  
        assertThat(
            .setSystemIngestPipeline("_none");  
            new BytesArray(  
        DiscoveryNode node1 = new DiscoveryNode("_node_id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            failureHandler,
        IngestService ingestService = createIngestServiceWithProcessors();
        putRequest = new PutPipelineRequest("_id2", new BytesArray("{\"processors\": [{\"mock\" : {}}]}"), MediaTypeRegistry.JSON);
        Map<String, Processor.Factory> processors,
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
        SystemIngestPipelineCache systemIngestPipelineCache = ingestService.getSystemIngestPipelineCache();
    }
        // Delete pipeline:
                return null;  
            return null;  
                    + "                              \"set\": {\n"
        ingestService.innerUpdatePipelines(ingestMetadata);
            "_id",  
        previousClusterState = clusterState;
        clusterState = createPipeline("pipeline", new BytesArray("{\"processors\": [{\"default\" : {}}]}"), ingestService, clusterState);  
        result = ingestService.resolvePipelines(updateRequest, TransportBulkAction.getIndexWriteRequest(updateRequest), metadata);  
        );
        assertEquals(NOOP_PIPELINE_NAME, indexRequest.getFinalPipeline());
        }).when(processor).execute(eqIndexTypeId(emptyMap()), any());  
        final MetadataIndexTemplateService metadataIndexTemplateService = getInstanceFromNode(MetadataIndexTemplateService.class);  
            "_id",  
        final Processor onFailureOnFailureProcessor = mock(Processor.class);  
            client,
        IngestService ingestService = createIngestServiceWithProcessors(  
    }
    }
            failureHandler,
        BulkRequest bulkRequest = new BulkRequest();  
            })
        );
        final BiConsumer<Integer, Exception> failureHandler = mock(BiConsumer.class);
            "_id",
            boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);  
        clusterState = IngestService.innerPut(putRequest, clusterState);  
import org.opensearch.OpenSearchParseException;  
            Names.WRITE
            MediaTypeRegistry.JSON
        IndexRequest indexRequest3 = new IndexRequest("_index").id("_id3")  
        Consumer<ClusterState> ingestClusterStateListener = clusterState -> { assertThat(counter.compareAndSet(0, 1), is(true)); };
        );
import java.nio.charset.StandardCharsets;
            assertThat(e.getMessage(), equalTo("pipeline with id [_id] does not exist"));
        verify(systemIngestPipelineCache, times(1)).cachePipeline(any(), any(), anyInt());  
            .source(emptyMap())  
                    + "                          \"on_failure\": [\n"
        Map<String, Processor.Factory> map = new HashMap<>(2);  
                throw new AssertionError("Document should have been dropped but reached this processor");  
        final IngestService ingestService = createIngestServiceWithProcessors(
        final Processor dummySystemProcessor = mock(Processor.class);
        // Test to make sure that ingest respects content types other than the default index content type
    public void testExecuteBulkRequestInBatchWithSystemPipeline() throws Exception {  
    }
        );
                .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))
        assertTrue(failureHandler.isEmpty());  
        assertThat(ingestService.pipelines().size(), is(2));  
    }
                    + "              \"field\": \"ingest_error2\",\n"  
    }  
    }
            IngestService.innerDelete(deleteRequest, clusterState);
        createPipeline("_id", ingestService);  
        ingestService.getClusterService().getClusterSettings().applySettings(newSettings);  
            .metadata(Metadata.builder(Metadata.EMPTY_METADATA).put(v1Template).build())
                    + "              \"tag\": \"tagggg\",\n"
        for (int i = 0; i < numOtherRequests; i++) {
        assertTrue(dropHandler.isEmpty());
        final Map<Thread, Exception> completionHandler = new HashMap<>();
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
                .numberOfShards(1)
            dropHandler,
import org.opensearch.test.MockLogAppender;
        assertTrue(failureHandler.isEmpty());
            clusterState = previousState;  
        );  
        @SuppressWarnings("unchecked")  
        final Map<String, IndexMetadata> currentIndices = Map.of("index1", indexMetadata1, "index2", changedIndexMetadata2);
        // verify defaults
        boolean result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
                .numberOfShards(1)
            .source(emptyMap())  
        Map<DiscoveryNode, IngestInfo> ingestInfos = new HashMap<>();
        } catch (ResourceNotFoundException e) {
            MediaTypeRegistry.JSON
            Collections.singletonList(new CompoundProcessor(onFailureProcessor))
            .source(emptyMap())
            Collections.singletonList(processor),
    }
        assertThat(pipeline, notNullValue());  
            "_id",
            indexReq -> {},
            failureHandler::put,
        IndexRequest indexRequest4 = new IndexRequest("_index").id("_id4")
        Metadata metadata = Metadata.builder().indices(Map.of("idx", indexMetadata)).build();  
            .setFinalPipeline("_none")
                .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
        expectThrows(IllegalStateException.class, () -> ingestService.validatePipeline(ingestInfos, putRequest));  
        ingestService.applyClusterState(new ClusterChangedEvent("", clusterState, previousClusterState));
        );
                    + "                          \"field\": \"ingest_error1\",\n"
        assertThat(result, is(true));
        return clusterState;
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);  
        for (int i = 0; i < 2; ++i) {  
    public static IngestService createIngestServiceWithProcessors(Map<String, Processor.Factory> processors) {
        // prepare test data and mock
        Metadata metadata = Metadata.builder().indices(Map.of("idx", indexMetadata)).build();
        IngestService ingestService = createIngestServiceWithProcessors();  
        IngestService ingestService = createIngestServiceWithProcessors();  
            @Override  
        }).when(dummyProcessor).batchExecute(any(), any());  
                .settings(settings(Version.CURRENT))
            "default",
            completionHandler,
        }
        assertEquals(1, completionHandler.size());  
    public void testExecuteBulkRequestSingleRequestWithSystemPipeline() throws Exception {
    private Processor mockSystemProcessor;
        assertThat(ingestService.pipelines().get("_id3").pipeline.getProcessors().get(0).getType(), equalTo("set"));
        assertEquals(1, completionHandler.size());
                    + "              \"tag\": \"tagggg\"\n"
                    + "    {\n"
        PipelineConfiguration pipeline = new PipelineConfiguration(  
            .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"));
            Version.CURRENT
                    + "                    \"value\": \"failed\",\n"  
        );
        );  
            4,  
        indexRequest.source(randomAlphaOfLength(10), randomAlphaOfLength(10));
    public void testDeleteWithExistingUnmatchedPipelines() {
        PutPipelineRequest putRequest = new PutPipelineRequest(
                    + "              \"field\": \"ingest_error1\",\n"
            .isPipelineResolved(true);
        );  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build(); // Start empty
            String value = (String) config.remove("value");
            Collections.singletonList(indexRequest),  
                mock(IndicesService.class),
        );
        assertThat(updateRequest.upsertRequest().getFinalPipeline(), equalTo("final-pipeline"));  
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
        IngestService ingestService = createIngestServiceWithProcessors(
    }
    }  
        @SuppressWarnings("unchecked")
        IndexRequest indexRequest1 = new IndexRequest("_index").id("_id1")  
        @NonNull final String id,
        assertNotNull(pipeline);  
            failureHandler,
        ingestService.executeBulkRequest(4, bulkRequest.requests(), failureHandler, completionHandler, indexReq -> {}, Names.WRITE);  
            MediaTypeRegistry.JSON  
            .setPipeline("_id")
                Consumer<List<IngestDocumentWrapper>> handler = (Consumer<List<IngestDocumentWrapper>>) invocationOnMock.getArguments()[1];  
        bulkRequest.add(indexRequest2);
        // First time create the pipeline and cache it
        final IndexMetadata indexMetadata = spy(
        final SystemIngestPipelineCache cache = ingestService.getSystemIngestPipelineCache();
            .setFinalPipeline("_final")  
        final Map<String, Processor.Factory> systemProcessors = new HashMap<>();
        // no pipeline:
            .setFinalPipeline("_final")  
        final Map<String, Processor.Factory> processors = new HashMap<>();
        ingestMetadata = new IngestMetadata(mapOf("_id1", pipeline1, "_id3", pipeline3));
        }
                .putMapping("{}")
            assertThat(indexRequest.getPipeline(), equalTo("request-pipeline"));
        // avoid returning null and dropping the document  
            1,
        cache.cachePipeline(index3.toString(), dummyPipeline, 10);
        final IngestService ingestService = createIngestServiceWithProcessors();
            new IngestDocumentWrapper(1, 0, IngestService.toIngestDocument(indexRequest2ChildSlot0), null),
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);  
        DiscoveryNode node2 = new DiscoveryNode("_node_id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        );  
        assertThat(ingestService.pipelines(), sameInstance(pipelines));  
        IngestMetadata ingestMetadata = new IngestMetadata(configs);
            IngestDocument ingestDocument = (IngestDocument) args.getArguments()[0];
        map.put(key2, value2);
        final Processor processor = mock(Processor.class);
            MediaTypeRegistry.JSON
        }).when(dummyFinalProcessor).execute(any(), any());
    private void assertStats(OperationStats stats, long count, long failed, long time) {
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> {  
        assertThat(pipelines.size(), equalTo(2));  
        assertThat(ingestService.pipelines().size(), is(1));
            .setPipeline("_id")
        when(indexMetadata.getIndex()).thenReturn(new Index("_index", "uuid"));  
        );  
        assertThat(pipeline.getId(), equalTo(id));
    public void testExecuteSuccess() {
            return null;
import org.opensearch.indices.IndicesService;  
        name = PipelineProcessor.TYPE;
                    return null;  
            new BytesArray("{\"processors\": [{\"complexSet\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
        );
        );  
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);  
        CompoundProcessor mockCompoundProcessor = mockCompoundProcessor();
        doThrow(new RuntimeException()).when(processor)
            .source(emptyMap())
        return pipelineStats.stream().filter(p1 -> p1.getPipelineId().equals(id)).findFirst().map(p2 -> p2.getStats()).orElse(null);  
        boolean hasPipeline = ingestService.resolvePipelines(indexRequest, indexRequest, state.metadata());  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        result = ingestService.resolvePipelines(indexRequest, indexRequest, metadata);
        assertThat(indexRequest.isPipelineResolved(), is(true));
            .setPipeline("_none")  
        when(mockSystemProcessor.isSystemGenerated()).thenReturn(true);  
            failureHandler.computeIfAbsent(slot, i -> new ArrayList<>()).add(exception);  
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
import org.opensearch.common.xcontent.cbor.CborXContent;
        assertThat(pipelines.get(0).getId(), equalTo("_id1"));
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);  
            "index1",
                    return true;
            Metadata metadata = Metadata.builder().put(builder).build();
            1,
        final BiConsumer<Thread, Exception> completionHandler = mock(BiConsumer.class);
                    new FakeProcessor("complexSet", tag, description, (ingestDocument) -> ingestDocument.setFieldValue(field, value))
 * You may obtain a copy of the License at  
                    + "                            {\n"
        Pipeline pipeline = ingestService.getPipeline(id);  
        ingestService.executeBulkRequest(  
            fail("exception expected");  
            .setSystemIngestPipeline("_none");
        final List<Integer> dropHandler = new ArrayList<>();
        verify(failureHandler, never()).accept(any(), any());
            .setSystemIngestPipeline("_none");
    public void testPrepareBatches_same_index_pipeline() {
        @SuppressWarnings("unchecked")  
        // verify  
        when(mockSystemProcessorFactory.create(any(), any(), any(), any())).thenReturn(mockSystemProcessor);  
        assertThat(indexRequest.ifPrimaryTerm(), equalTo(ifPrimaryTerm));
        verify(completionHandler, times(1)).accept(Thread.currentThread(), null);
                .settings(settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default-pipeline"))  
        PutPipelineRequest putRequest = new PutPipelineRequest(
        assertThat(indexRequest.getPipeline(), equalTo("_none"));
            Collections.singletonMap("mock", (factories, tag, description, config) -> mockCompoundProcessor)
        createPipeline("final_pipeline", new BytesArray("{\"processors\": [{\"dummy\" : {}}]}"), ingestService, clusterState);
        BulkRequest bulkRequest = new BulkRequest();
        final Processor processor = mock(Processor.class);
    private void verifySystemPipelineResolvedSuccessfully(
        final IndexRequest indexRequest = new IndexRequest("_index").id("_id")
        @SuppressWarnings("unchecked")  
        );  
            .setPipeline("_id")
            1,  
                    + "                      },\n"
                .setPipeline(pipelineId)  
        assertThat(pipeline, nullValue());
        factories.put("drop", new DropProcessor.Factory());
            mock(SystemIngestPipelineCache.class)  
                .numberOfShards(1)
            new BytesArray(  
            failureHandler,
        final Map<Integer, Exception> failureHandler = new HashMap<>();
        @SuppressWarnings("unchecked")
        doThrow(new RuntimeException()).when(onFailureOnFailureProcessor)  
        assertThat(pipeline.getProcessors().size(), equalTo(0));  
            assertThat(e.getCause().getMessage(), equalTo("error"));
        final List<Integer> dropHandler = new ArrayList<>();
        indexRequest = new IndexRequest("alias");
        verify(failureHandler, times(1)).accept(eq(0), any(RuntimeException.class));
            handler.accept(ingestDocument, null);
        };  
        assertThat(pipelines.get(1).getId(), equalTo("_id2"));
