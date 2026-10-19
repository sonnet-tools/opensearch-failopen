            failureCalled.set(true);  
        void executeBulk(
        // should not have executed ingest locally  
                .settings(Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "pipeline1").build())  
    public void testFindDefaultPipelineFromV2TemplateMatch() throws Exception {  
        indexRequest2.setPipeline("testpipeline");
        assertEquals(indexRequest2.getPipeline(), "default_pipeline");
            completionHandler.capture(),  
        verifyNoInteractions(transportService);
 * Unless required by applicable law or agreed to in writing,
        templateMetadataBuilder.put(
            assertThat(e, sameInstance(exception));
import static org.mockito.Mockito.eq;
    public void testUseDefaultPipelineWithBulkUpsert() throws Exception {
        assertTrue(action.isExecuted);  
        // check failure works, and passes through to the listener
        Exception exception = new Exception("fake exception");
                        )
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        assertTrue(action.isExecuted);
        }  
        boolean usedNode1 = node.getValue() == remoteNode1; // make sure we used one of the nodes
        Exception exception = new Exception("fake exception");
            bulkDocsItr.capture(),
                                .system(true)  
        assertFalse(action.isExecuted); // no local index execution
        indexRequest2.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
        singleItemBulkWriteAction.execute(null, indexRequest, listener);
        assertTrue(action.isExecuted);
        void createIndex(String index, TimeValue timeout, Version minNodeVersion, ActionListener<CreateIndexResponse> listener) {
        assertNull(indexRequestUpsertForNormalUpsert.getPipeline());
            .build();
            ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        AtomicBoolean failureCalled = new AtomicBoolean(false);
        ClusterState state = clusterService.state();
        assertFalse(responseCalled.get());  
}
        final ExecutorService direct = OpenSearchExecutors.newDirectExecutorService();
    public void testFindDefaultPipelineFromTemplateMatch() {
        completionHandler = ArgumentCaptor.forClass(BiConsumer.class);
        verifyNoInteractions(transportService);  
        doNothing().when(ingestService).executeBulkRequest(anyInt(), any(), any(), any(), any(), anyString());
            responseCalled.set(true);
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one  
        verify(ingestService, times(1)).resolvePipelines(eq(docAsUpsertRequest), eq(indexRequest2), any());
import org.opensearch.transport.TransportService;
        bulkRequest.add(indexRequest2);
                new ActionFilters(Collections.emptySet()),
            "template2",
                        .put(
    }
        assertEquals("pipeline2", indexRequest.getPipeline());
import org.opensearch.core.action.ActionListener;
    /**
        validatePipelineWithBulkUpsert(indexRequestName, WITH_DEFAULT_PIPELINE);
    class TestTransportBulkAction extends TransportBulkAction {  
        verify(ingestService, times(1)).resolvePipelines(any(), any(), any());
        AtomicBoolean responseCalled = new AtomicBoolean(false);  
                IndexRequest::new,  
                .patterns(Arrays.asList("nope"))  
        verify(ingestService).executeBulkRequest(
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            completionHandler.capture(),  
        }));  
        assertFalse(failureCalled.get());
        verify(ingestService).executeBulkRequest(
            BulkItemResponse itemResponse = response.iterator().next();  
        BulkRequest bulkRequest = new BulkRequest();
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
        verify(ingestService).executeBulkRequest(  
        bulkRequest.add(indexRequest);  
        // check failure works, and passes through to the listener  
    boolean localIngest;
        remoteResponseHandler.getValue().handleResponse(new BulkResponse(bulkItemResponses, 0)); // call the listener for the remote node  
        when(nodes.getIngestNodes()).thenReturn(ingestNodes);
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        // 2. UPSERT will have ALL pipelines resolved  
        templateMetadataBuilder.put(
            final BulkRequest bulkRequest,  
        verify(ingestService, times(1)).resolveSystemIngestPipeline(any(), eq(indexRequestForNormalUpdate), any());
        reset(transportService);
            assertThat(e, sameInstance(exception));
        indexRequest.setPipeline("testpipeline");
        );  
            return needToCheck;  
        reset(transportService);
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> { responseCalled.set(true); }, e -> {
    public void testUseDefaultPipelineWithAlias() throws Exception {
        ClusterState ingestServiceClusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();  
    DiscoveryNodes nodes;
        String indexRequestName = randomFrom(new String[] { null, WITH_DEFAULT_PIPELINE, WITH_DEFAULT_PIPELINE_ALIAS });  
import org.opensearch.action.update.UpdateRequest;
import org.opensearch.cluster.ClusterState;
    }
            failureHandler.capture(),
        assertFalse(action.isExecuted); // haven't executed yet
            assertSame(bulkResponse, response);
        assertFalse(responseCalled.get()); // listener not called yet  
        indexRequest.source(emptyMap());
        UpdateRequest scriptedUpsert = new UpdateRequest(updateRequestIndexName, "id2").upsert(indexRequest3)
        IndexRequest indexRequestDocForNormalUpsert = new IndexRequest(indexRequestIndexName).id("id5").source(emptyMap());  
        // Add update requests  
        AtomicBoolean responseCalled = new AtomicBoolean(false);  
import org.opensearch.test.ClusterServiceUtils;
        );
        AtomicBoolean failureCalled = new AtomicBoolean(false);
            failureCalled.set(true);
        AtomicBoolean responseCalled = new AtomicBoolean(false);  
        TestSingleItemBulkWriteAction(TestTransportBulkAction bulkAction) {
        TestTransportBulkAction() {
        Exception exception = new Exception("fake exception");  
            "template4",
        failureHandler.getValue().accept(0, exception); // have an exception for our one index request
        when(nodes.getMinNodeVersion()).thenReturn(VersionUtils.randomCompatibleVersion(random(), Version.CURRENT));
            Collections.singletonList("missing_*"),
        Exception exception = new Exception("fake exception");
    private static final Settings SETTINGS = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), true).build();
        assertNull(indexRequest3.getPipeline());
        // bulk upserts with a default pipeline are a bit surprising since the script executes AFTER the pipeline.
            .upsert(indexRequestUpsertForNormalUpsert);
                Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "pipeline2").build(),  
        IndexRequest indexRequest1 = new IndexRequest(indexRequestIndexName).id("id1").source(emptyMap());  
        action = new TestTransportBulkAction();  
            listener.onResponse(null);
import org.opensearch.common.util.concurrent.AtomicArray;
    DiscoveryNode remoteNode1;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        indexRequest.source(emptyMap());
        // now check success
        assertNull(indexRequest2.getPipeline());  
 * this work for additional information regarding copyright
            new ClusterChangedEvent("testFindDefaultPipelineFromV2TemplateMatch", ingestServiceClusterState, ingestServiceClusterState)
            bulkDocsItr.capture(),
        BulkRequest bulkRequest = new BulkRequest();
import static org.mockito.Answers.RETURNS_MOCKS;
    }  
/*
        // setup the mocked ingest service for capturing calls  
            when(event.state()).thenReturn(state);
        IndexRequest indexRequest2 = new IndexRequest(".system").id("id");
            indexCreated = true;  
import org.opensearch.Version;
import java.util.Iterator;
        verifyNoInteractions(transportService);
        indexRequest.source(emptyMap());
        IndexRequest indexRequest = new IndexRequest("index").id("id");
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(itemResponse.getFailure().getMessage(), containsString("fake exception"));  
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;  
                bulkAction,
        assertFalse(failureCalled.get());
                                .settings(  
import static org.mockito.Mockito.anyInt;  
    private void validateDefaultPipeline(IndexRequest indexRequest) {
        UpdateRequest upsertWithDocAndUpsertRequest = new UpdateRequest(updateRequestIndexName, "id4").doc(indexRequestDocForNormalUpsert)  
import static org.mockito.Mockito.doNothing;  
                .build()
        verify(ingestService, times(1)).resolveSystemIngestPipeline(
    }  
            failureHandler.capture(),  
            IndexTemplateMetadata.builder("template1")  
/*  
import org.opensearch.index.IndexingPressureService;
        }, e -> {
        verifyNoMoreInteractions(ingestService);
        boolean needToCheck; // pluggable return value for `needToCheck`  
            assertSame(remoteNode2, node.getValue());  
    public void testDoExecuteCalledTwiceCorrectly() throws Exception {
            assertThat(e, sameInstance(exception));  
            responseCalled.set(true);  
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> { responseCalled.set(true); }, e -> {
        ActionListener<BulkResponse> listener = ActionListener.wrap(response -> {
        when(metadata.templates()).thenReturn(templateMetadataBuilder);  
        assertTrue(action.isExecuted);
        verify(transportService).sendRequest(node.capture(), eq(BulkAction.NAME), any(), remoteResponseHandler.capture());  
    }  
        // now make sure ingest nodes are rotated through with a subsequent request
 * license agreements. See the NOTICE file distributed with
            eq(Names.WRITE)
        } else {
            failureCalled.set(true);
        );
        bulkDocsItr = ArgumentCaptor.forClass(Iterable.class);
        action.execute(null, bulkRequest, ActionListener.wrap(response -> {  
        verify(ingestService, times(1)).resolvePipelines(any(), any(), any());  
    /** Services needed by bulk action */  
import static org.hamcrest.Matchers.containsString;
        indexRequest2.source(emptyMap());
    public void setupAction() {
import static org.mockito.Mockito.reset;
        }
    public void testUseDefaultPipelineWithBulkUpsertWithAlias() throws Exception {
                )  
        }
                new AutoCreateIndex(
        verify(ingestService, times(1)).resolvePipelines(eq(upsertWithDocAndUpsertRequest), eq(indexRequestUpsertForNormalUpsert), any());
        }));
            bulkDocsItr.capture(),
    }
    }  
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> {}, exception -> {
            eq(indexRequestDocForNormalUpsert),
                .order(1)
                .patterns(Arrays.asList("missing_index"))
            assertSame(remoteNode2, node.getValue());
        action.execute(null, bulkRequest, ActionListener.wrap(response -> {
    public void testSingleItemBulkActionIngestLocal() throws Exception {  
        indexRequestForNormalUpdate.setPipeline(IngestService.NOOP_PIPELINE_NAME);  
        completionHandler.getValue().accept(null, exception);  
import static org.opensearch.ingest.IngestServiceTests.createIngestServiceWithProcessors;
        remoteResponseHandler.getValue().handleResponse(bulkResponse); // call the listener for the remote node
        ArgumentCaptor<DiscoveryNode> node = ArgumentCaptor.forClass(DiscoveryNode.class);
        action.needToCheck = true;
        doAnswer(invocation -> {  
        nodes = mock(DiscoveryNodes.class);
        assertFalse(failureCalled.get());
        }
        assertFalse(responseCalled.get());
        AtomicBoolean failureCalled = new AtomicBoolean(false);  
        assertTrue(failureCalled.get());  
                .build()  
            assertThat(e, sameInstance(exception));
        assertEquals(indexRequest.getPipeline(), "default_pipeline");  
        verifyNoMoreInteractions(ingestService);  
            )
        AtomicBoolean failureCalled = new AtomicBoolean(false);
        } else {  
        assertEquals(indexRequestDocForNormalUpsert.getPipeline(), IngestService.NOOP_PIPELINE_NAME);
        indexRequest2.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
            assertSame(remoteNode2, node.getValue());  
            eq(bulkRequest.numberOfActions()),
            IndexTemplateMetadata.builder("template2")
        AtomicBoolean responseCalled = new AtomicBoolean(false);  
                new HashMap<>(
        assertTrue(failureCalled.get());
            eq(Names.WRITE)
            assertSame(remoteNode2, node.getValue());
            assertThat(e, sameInstance(exception));  
    private static final Thread DUMMY_WRITE_THREAD = new Thread(ThreadPool.Names.WRITE);
        }
    public void testIngestForward() throws Exception {
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
        assertFalse(responseCalled.get());
        // now check success  
        // this test only covers the mechanics that scripted bulk upserts will execute a default pipeline. However, in practice scripted  
        AtomicBoolean failureCalled = new AtomicBoolean(false);
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.node.DiscoveryNodes;  
            eq(Names.WRITE)  
 * ownership. Elasticsearch licenses this file to you under  
        // now check success
        // check failure works, and passes through to the listener  
            null
        ClusterState state = clusterService.state();
import java.util.HashMap;  
            completionHandler.capture(),
            assertThat(e, sameInstance(exception));
        verify(ingestService, never()).resolvePipelines(any(), eq(indexRequestDocForNormalUpsert), any());
        action.indexCreated = false;  
        verify(transportService).sendRequest(node.capture(), eq(BulkAction.NAME), any(), remoteResponseHandler.capture());  
        verify(ingestService).executeBulkRequest(
import java.util.Map;
        verify(ingestService).executeBulkRequest(
            responseCalled.set(true);
        completionHandler.getValue().accept(null, exception);
        validatePipelineWithBulkUpsert(indexRequestName, WITH_DEFAULT_PIPELINE_ALIAS);  
    public void testIngestLocal() throws Exception {  
 */  
        verify(ingestService, never()).executeBulkRequest(anyInt(), any(), any(), any(), any(), any());  
                                .build()  
        validateDefaultPipeline(new IndexRequest(WITH_DEFAULT_PIPELINE).id("id"));
        when(clusterService.localNode()).thenReturn(localNode);
import org.opensearch.index.IndexSettings;
            );
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);
        BulkResponse bulkResponse = mock(BulkResponse.class);  
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> responseCalled.set(true), e -> {
        completionHandler.getValue().accept(null, exception);
        indexRequest.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing  
        if (usedNode1) {
        indexRequest.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
        Exception exception = new Exception("fake exception");  
        IndexRequest indexRequestUpsertForNormalUpsert = new IndexRequest(indexRequestIndexName).id("id6").source(emptyMap());
                    ClusterServiceUtils.createClusterService(
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        when(state.metadata()).thenReturn(metadata);
        assertNull(indexRequest.getPipeline());  
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
        }));
        Metadata metadata = mock(Metadata.class);  
        remoteNode1 = mock(DiscoveryNode.class);  
        }, e -> { throw new AssertionError(e); });
        indexRequest3.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
        }, e -> {
    }
        assertEquals(IngestService.NOOP_PIPELINE_NAME, indexRequest.getPipeline());  
        IndexRequest indexRequest = new IndexRequest("missing_index").id("id");
            eq(Names.WRITE)
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);  
        assertFalse(action.isExecuted); // still no local index execution
import org.opensearch.threadpool.ThreadPool.Names;
        when(state.metadata()).thenReturn(metadata);
        // mock the cluster state for the ingest service
        if (usedNode1 == false) {  
        // 1. DOC will only have system pipeline resolved. Exception is if docAsUpsert is true, DOC will have all pipelines resolved
    }
                null,
            bulkDocsItr.capture(),  
            eq(1),
                                .numberOfShards(1)
        transportService = mock(TransportService.class, RETURNS_MOCKS);
import static java.util.Collections.emptyMap;  
                .settings(Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "pipeline4").build())
        AtomicBoolean failureCalled = new AtomicBoolean(false);
            failureHandler.capture(),
                .settings(Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "pipeline2").build())
    /** The nodes that forwarded index requests should be cycled through. */  
        indexRequest1.setPipeline("testpipeline");
    }
        action.execute(null, bulkRequest, ActionListener.wrap(response -> {}, exception -> { throw new AssertionError(exception); }));
            failureHandler.capture(),
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.mockito.Mockito.verifyNoMoreInteractions;  
        indexRequest.source(emptyMap());  
        indexRequest2.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
        // now check success
        ArgumentCaptor<DiscoveryNode> node = ArgumentCaptor.forClass(DiscoveryNode.class);  
        assertFalse(responseCalled.get());
            IndexTemplateMetadata.builder("template4")
                null,
                TransportBulkActionIngestTests.this.transportService,
        boolean usedNode1 = node.getValue() == remoteNode1; // make sure we used one of the nodes
        bulkRequest.add(indexRequest1);  
                new CompressedXContent("{}"),
        assertTrue(action.isExecuted);
     * Index for which mock settings contain a default pipeline.  
                            IndexMetadata.builder(".system")
                                .putAlias(AliasMetadata.builder(WITH_DEFAULT_PIPELINE_ALIAS).build())  
import org.opensearch.cluster.ClusterName;  
    /** True if the next call to the index action should act as an ingest node */  
 * Licensed to Elasticsearch under one or more contributor  
        indexRequestUpsertForNormalUpsert.setPipeline(IngestService.NOOP_PIPELINE_NAME);
        action.execute(null, bulkRequest, listener);
        assertEquals(indexRequestUpsertForNormalUpsert.getPipeline(), "default_pipeline");
            final ActionListener<BulkResponse> listener,
    /** Arguments to callbacks we want to capture, but which require generics, so we must use @Captor */  
            failureHandler.capture(),
import java.util.Collections;
        indexRequest.setPipeline("testpipeline");
        verify(ingestService, never()).resolveSystemIngestPipeline(any(), eq(indexRequest3), any());
                new IndexingPressureService(
        templateMetadataBuilder.put(  
import org.opensearch.cluster.metadata.Template;
        AtomicBoolean responseCalled = new AtomicBoolean(false);
import org.opensearch.cluster.ClusterChangedEvent;
        assertFalse(action.isExecuted); // haven't executed yet
 * not use this file except in compliance with the License.
        IndexRequest indexRequest3 = new IndexRequest(indexRequestIndexName).id("id3").source(emptyMap());
import static org.mockito.Mockito.times;  
 */
import org.opensearch.common.settings.ClusterSettings;
        );
        BulkItemResponse itemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.CREATE, indexResponse);  
 */  
                    SETTINGS,  
                NoopTracer.INSTANCE  
        // check failure works, and passes through to the listener  
            "template1",
        state.metadata().templatesV2().remove("my-template");
        assertTrue(responseCalled.get()); // now the listener we passed should have been delegated to by the remote listener  
        // but instead should have sent to a remote node with the transport service
        singleItemBulkWriteAction.execute(null, indexRequest, listener);  
        bulkRequest.add(upsertRequest).add(docAsUpsertRequest).add(scriptedUpsert).add(regularUpdate).add(upsertWithDocAndUpsertRequest);
            completionHandler.capture(),
            failureCalled.set(true);  
        indexRequest.source(emptyMap());
        IndexRequest indexRequest2 = new IndexRequest("index").id("id");  
        verify(ingestService).executeBulkRequest(
        AtomicBoolean failureCalled = new AtomicBoolean(false);
        when(localNode.isIngestNode()).thenAnswer(stub -> localIngest);
            any()
        threadPool = mock(ThreadPool.class);
    }
import static org.mockito.Mockito.doAnswer;
            bulkDocsItr.capture(),
        }));
        verifyNoInteractions(transportService);  
                            ".system",  
    public void testIngestSkipped() throws Exception {
            assertThat(e, sameInstance(exception));
        // now check success of the transport bulk action
import org.opensearch.action.index.IndexResponse;  
        DiscoveryNode localNode = mock(DiscoveryNode.class);  
        indexRequest2.source(emptyMap());  
        final Map<String, DiscoveryNode> ingestNodes = Map.of("node1", remoteNode1, "node2", remoteNode2);  
            any(),
    @Before
            eq(Names.SYSTEM_WRITE)
        indexRequest1.source(emptyMap());  
    DiscoveryNode remoteNode2;  
            assertThat(e, sameInstance(exception));  
                ),  
        }
                        )
 * this file be licensed under the Apache-2.0 license or a
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> responseCalled.set(true), e -> {
                IndexAction.NAME,  
            return null;
 * GitHub history for details.
            assertSame(remoteNode1, node.getValue());
import org.opensearch.ingest.IngestService;
import org.mockito.ArgumentCaptor;
            eq(Names.WRITE)
        boolean isExecuted = false; // set when the "real" bulk execution happens
        verify(ingestService, times(1)).resolvePipelines(any(), any(), any());
        Exception exception = new Exception("fake exception");
                            IndexMetadata.builder(WITH_DEFAULT_PIPELINE)
        }, e -> { throw new AssertionError(e); });  
        when(state.getNodes()).thenReturn(nodes);
        ingestService.applyClusterState(
        assertEquals(indexRequestForNormalUpdate.getPipeline(), IngestService.NOOP_PIPELINE_NAME);  
                                .numberOfShards(1)
        // An update request has two child update requests, DOC and UPSERT
                        new ClusterSettings(SETTINGS, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
    private static final String WITH_DEFAULT_PIPELINE = "index_with_default_pipeline";
        );  
            failureCalled.set(true);
            eq(1),  
        );
            Task task,
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        when(state.getMetadata()).thenReturn(metadata);
        assertFalse(action.isExecuted); // no local index execution  
        completionHandler.getValue().accept(null, exception);  
        IndexRequest indexRequest = new IndexRequest("index").id("id");
import static org.hamcrest.Matchers.sameInstance;  
                                    settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline").build()
        assertFalse(action.indexCreated); // still no index yet, the ingest node failed.
        indexRequest.source(emptyMap());  
        IndexRequest indexRequest = new IndexRequest("index").id("id");
            ((ClusterStateApplier) invocation.getArguments()[0]).applyClusterState(event);  
            throw new AssertionError(exception);
        // Verify for different Update cases, we call the correct resolve  
        assertEquals("pipeline2", indexRequest.getPipeline());
import org.opensearch.indices.SystemIndices;  
    TestTransportBulkAction action;
        assertFalse(action.isExecuted); // haven't executed yet
                new ActionFilters(Collections.emptySet()),  
import org.opensearch.cluster.service.ClusterService;
        action.execute(null, bulkRequest, listener);  
        BulkItemResponse[] bulkItemResponses = new BulkItemResponse[1];
        reset(transportService); // call on construction of action
        IndexRequest indexRequest = new IndexRequest("index").id("id");
 * SPDX-License-Identifier: Apache-2.0
        singleItemBulkWriteAction = new TestSingleItemBulkWriteAction(action);
    }  
        when(metadata.indices()).thenReturn(Map.of());
        verify(ingestService, never()).resolveSystemIngestPipeline(any(), eq(indexRequestUpsertForNormalUpsert), any());  
                .build()  
            IndexTemplateMetadata.builder("template3").patterns(Arrays.asList("missing*")).order(3).build()
        assertFalse(failureCalled.get());  
    class TestSingleItemBulkWriteAction extends TransportSingleItemBulkWriteAction<IndexRequest, IndexResponse> {
 * under the License.  
    }  
            failureHandler.capture(),
        verifyNoMoreInteractions(ingestService);
        assertNull(indexRequest1.getPipeline());
        }));
            super(
        }));
            BulkItemResponse itemResponse = response.iterator().next();
                clusterService,
        ActionListener<IndexResponse> listener = ActionListener.wrap(response -> {  
import org.opensearch.action.index.IndexAction;
                            WITH_DEFAULT_PIPELINE,
            assertThat(itemResponse.getFailure().getMessage(), containsString("fake exception"));
                null,
        assertTrue(action.isExecuted);
        // now check success
                        .put(  
    private static final String WITH_DEFAULT_PIPELINE_ALIAS = "alias_for_index_with_default_pipeline";  
        );
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);
import static org.mockito.Mockito.mock;
        // now make sure ingest nodes are rotated through with a subsequent request  
        indexRequest.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
        assertTrue(action.isExecuted);  
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> responseCalled.set(true), e -> {  
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        when(metadata.getTemplates()).thenReturn(templateMetadataBuilder);
                .order(4)
import org.opensearch.threadpool.ThreadPool;
            assertTrue(indexCreated);  
        }));  
    }
            eq(1),  
     */
/*  
            .indices(  
        assertTrue(failureCalled.get());  
        ComposableIndexTemplate t1 = new ComposableIndexTemplate(  
        );
import org.opensearch.tasks.Task;
        AtomicBoolean responseCalled = new AtomicBoolean(false);  
            assertSame(indexResponse, response);
        Iterator<DocWriteRequest<?>> req = bulkDocsItr.getValue().iterator();
        completionHandler.getValue().accept(null, exception);
import static org.mockito.Mockito.verifyNoInteractions;
            Map<String, IndexNotFoundException> indicesThatCannotBeCreated
    /** The actual action we want to test, with real indexing mocked */  
            failureCalled.set(true);
        }));
            any(),
        BulkRequest bulkRequest = new BulkRequest();  
        ActionTestUtils.execute(action, null, bulkRequest, ActionListener.wrap(response -> {
        ingestService = spy(createIngestServiceWithProcessors(Collections.emptyMap()));
        );
        when(state.getMetadata()).thenReturn(metadata);  
        );  
        UpdateRequest upsertRequest = new UpdateRequest(updateRequestIndexName, "id1").upsert(indexRequest1).script(mockScript("1"));
        IndexRequest indexRequest = new IndexRequest("missing_index").id("id");  
            any(),  
import static org.mockito.Mockito.anyString;
        clusterService = mock(ClusterService.class);  
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
import org.opensearch.common.collect.MapBuilder;  
            assertSame(remoteNode1, node.getValue());
        );
        indexRequestDocForNormalUpsert.setPipeline(IngestService.NOOP_PIPELINE_NAME);
        );  
        IndexResponse indexResponse = mock(IndexResponse.class);
import org.opensearch.action.DocWriteRequest;
        bulkRequest.add(indexRequest);
 * KIND, either express or implied.  See the License for the
                new SystemIndices(emptyMap()),
 * compatible open source license.
import org.opensearch.action.support.ActionTestUtils;
    }
                .patterns(Arrays.asList("missing_*"))  
        }));  
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);  
        indexRequest.source(emptyMap());  
import java.util.concurrent.ExecutorService;  
import org.opensearch.common.settings.Settings;  
        indexRequest.source(emptyMap());  
        verify(ingestService).executeBulkRequest(
package org.opensearch.action.bulk;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);
            bulkDocsItr.capture(),  
        // check failure works, and passes through to the listener  
            completionHandler.capture(),
            failureHandler.capture(),
        }
        verify(ingestService, never()).resolveSystemIngestPipeline(any(), eq(indexRequest1), any());
            responseCalled.set(true);  
            any(),
import org.opensearch.index.IndexNotFoundException;  
        indexRequest2.setPipeline("testpipeline");
        verifyNoInteractions(transportService);
        assertTrue(action.indexCreated); // now the index is created since we skipped the ingest node path.  
import static org.mockito.Mockito.when;
import org.opensearch.action.support.AutoCreateIndex;  
        assertEquals(indexRequest3.getPipeline(), "default_pipeline");
 * the Apache License, Version 2.0 (the "License"); you may
            completionHandler.capture(),
            assertThat(e, sameInstance(exception));
        assertTrue(action.isExecuted);
        @Override
        assertFalse(action.indexCreated); // no index yet
        indexRequest1.setPipeline("testpipeline");
        // initialize captors, which must be members to use @Capture because of generics  
            null,
        verify(ingestService).executeBulkRequest(
        @Override  
        String indexRequestName = randomFrom(new String[] { null, WITH_DEFAULT_PIPELINE, WITH_DEFAULT_PIPELINE_ALIAS });
            isExecuted = true;
    private void validatePipelineWithBulkUpsert(@Nullable String indexRequestIndexName, String updateRequestIndexName) throws Exception {  
    public void testNotFindDefaultPipelineFromTemplateMatches() {
            failureCalled.set(true);
import org.opensearch.action.index.IndexRequest;
            any(),
            eq(1),
            assertThat(itemResponse.getFailure().getMessage(), containsString("fake exception"));
        assertNull(indexRequestDocForNormalUpsert.getPipeline());  
import org.opensearch.cluster.ClusterStateApplier;
        protected boolean needToCheck() {
        assertFalse(action.isExecuted); // haven't executed yet
            any(),  
import org.opensearch.common.unit.TimeValue;
        final MetadataIndexTemplateService metadataIndexTemplateService = getInstanceFromNode(MetadataIndexTemplateService.class);  
import org.opensearch.cluster.node.DiscoveryNode;
        indexRequest1.source(emptyMap());
                    new SystemIndices(emptyMap())  
        Exception exception = new Exception("fake exception");  
        assertTrue(responseCalled.get()); // now the listener we passed should have been delegated to by the remote listener
                threadPool,  
        verify(ingestService, never()).resolvePipelines(any(), eq(indexRequestForNormalUpdate), any());
        Iterator<DocWriteRequest<?>> req = bulkDocsItr.getValue().iterator();  
            new Template(
        // check failure works, and passes through to the listener
        if (usedNode1 == false) {
        when(state.getMetadata()).thenReturn(metadata);
                                .numberOfReplicas(1)
        AtomicBoolean failureCalled = new AtomicBoolean(false);  
        bulkItemResponses[0] = itemResponse;
            eq(upsertWithDocAndUpsertRequest),  
                .order(2)
            final long startTimeNanos,
        ) {
import static org.mockito.Mockito.spy;
            ),  
            .scriptedUpsert(true);
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);
        remoteResponseHandler = ArgumentCaptor.forClass(TransportResponseHandler.class);
    }  
        );
        BulkRequest bulkRequest = new BulkRequest();
        indexRequest.setPipeline("testpipeline");  
import org.opensearch.action.support.ActionFilters;
 * You may obtain a copy of the License at  
        verify(ingestService, times(1)).resolvePipelines(eq(upsertRequest), eq(indexRequest1), any());
        assertFalse(action.isExecuted); // still no local index execution
    public void testUseDefaultPipeline() throws Exception {  
            completionHandler.capture(),  
            failureHandler.capture(),
        failureHandler = ArgumentCaptor.forClass(BiConsumer.class);  
import org.junit.Before;
        templateMetadataBuilder.put(  
        assertTrue(failureCalled.get());
        assertTrue(failureCalled.get());
    ClusterService clusterService;
        IndexRequest indexRequest = new IndexRequest("index").id("id");
    public void testSingleItemBulkActionIngestSkipped() throws Exception {
        verify(transportService).sendRequest(node.capture(), eq(BulkAction.NAME), any(), remoteResponseHandler.capture());
    IngestService ingestService;  
        AtomicBoolean failureCalled = new AtomicBoolean(false);
        }));
        // setup services that will be called by action
        assertNull(indexRequestForNormalUpdate.getPipeline());
                null,
 * specific language governing permissions and limitations
        IndexRequest indexRequest = new IndexRequest("missing_index").id("id");
        IndexRequest indexRequest1 = new IndexRequest("index").id("id");  
        assertTrue(failureCalled.get());
        verifyNoInteractions(transportService);
import static org.mockito.Mockito.verify;
        AtomicBoolean responseCalled = new AtomicBoolean(false);
                                .build()  
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
 *
                                )
            any(),  
import java.util.concurrent.atomic.AtomicBoolean;
            null,
    }
    public void testIngestSystemLocal() throws Exception {
    /** A subclass of the real bulk action to allow skipping real bulk indexing, and marking when it would have happened. */
                transportService,
            eq(bulkRequest.numberOfActions()),  
            bulkDocsItr.capture(),  
        );  
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> responseCalled.set(true), e -> {
        }).when(clusterService).addStateApplier(any(ClusterStateApplier.class));
            "template3",  
        verify(transportService).sendRequest(node.capture(), eq(BulkAction.NAME), any(), remoteResponseHandler.capture());
    public void testSingleItemBulkActionIngestForward() throws Exception {
        IndexRequest indexRequestForNormalUpdate = new IndexRequest(indexRequestIndexName).id("id4").source(emptyMap());
        assertFalse(responseCalled.get()); // listener not called yet
                        .map()
        Exception exception = new Exception("fake exception");
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
        bulkRequest.add(indexRequest1);
            .script(mockScript("1"))  
        UpdateRequest docAsUpsertRequest = new UpdateRequest(updateRequestIndexName, "id2").doc(indexRequest2).docAsUpsert(true);
            super(
import static org.mockito.Mockito.never;  
        when(clusterService.state()).thenReturn(state);
    ArgumentCaptor<BiConsumer<Integer, Exception>> failureHandler;
        IndexRequest indexRequest1 = new IndexRequest(".system").id("id");
    ArgumentCaptor<Iterable<DocWriteRequest<?>>> bulkDocsItr;
 * software distributed under the License is distributed on an
        verify(ingestService, never()).executeBulkRequest(anyInt(), any(), any(), any(), any(), any());
                    new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        BulkRequest bulkRequest = new BulkRequest();
        UpdateRequest regularUpdate = new UpdateRequest(updateRequestIndexName, "id4").doc(indexRequestForNormalUpdate);
            completionHandler.capture(),
        indexRequest1.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing  
            eq(Names.WRITE)
        @Override
        assertFalse(failureCalled.get());  
import org.opensearch.common.Nullable;
    /** Single item bulk write action that wraps index requests */  
    }  
import org.opensearch.test.VersionUtils;  
                    SETTINGS,  
        }, e -> {  
import org.opensearch.cluster.metadata.AliasMetadata;  
            );  
        indexRequest.source(emptyMap());  
        indexRequest.setPipeline("testpipeline");
        IndexRequest indexRequest2 = new IndexRequest(indexRequestIndexName).id("id2").source(emptyMap());
    ArgumentCaptor<TransportResponseHandler<BulkResponse>> remoteResponseHandler;  
                    )
public class TransportBulkActionIngestTests extends OpenSearchSingleNodeTestCase {  
    TestSingleItemBulkWriteAction singleItemBulkWriteAction;
                        null
        }
            eq(bulkRequest.numberOfActions()),
                                .settings(settings(Version.CURRENT))
    }
                    new ClusterSettings(SETTINGS, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                ),
        );  
        bulkRequest.add(indexRequest2);  
        localIngest = true;
        verify(ingestService, never()).resolveSystemIngestPipeline(any(), eq(indexRequest2), any());
        boolean indexCreated = true; // If set to false, will be set to true by call to createIndex
        when(threadPool.executor(anyString())).thenReturn(direct);  
        localIngest = false;  
                                .numberOfReplicas(0)
                        SETTINGS,
        validateDefaultPipeline(new IndexRequest(WITH_DEFAULT_PIPELINE_ALIAS).id("id"));
import java.util.function.BiConsumer;
        // setup nodes for local and remote
        Metadata metadata = Metadata.builder()
 *
        assertFalse(failureCalled.get());  
import org.opensearch.transport.TransportResponseHandler;  
        IndexRequest indexRequest = new IndexRequest("missing_index").id("id");
        verify(ingestService, times(1)).resolvePipelines(eq(scriptedUpsert), eq(indexRequest3), any());
    ThreadPool threadPool;
                    MapBuilder.<String, IndexMetadata>newMapBuilder()
        Metadata metadata = Metadata.builder().put("my-template", t1).build();
        assertEquals(indexRequest1.getPipeline(), "default_pipeline");  
import org.opensearch.common.util.concurrent.ThreadContext;
            failureCalled.set(true);  
        assertFalse(responseCalled.get());  
        assertFalse(responseCalled.get());
            BulkItemResponse itemResponse = response.iterator().next();
            null,
                ingestService,  
        failureHandler.getValue().accept(0, exception); // have an exception for our one index request  
 * The OpenSearch Contributors require contributions made to  
        metadataIndexTemplateService.addIndexTemplateV2(state, false, "my-template", t1);
import static org.mockito.Mockito.any;
            any(),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        indexRequest.source(emptyMap());
        // but instead should have sent to a remote node with the transport service
            final AtomicArray<BulkItemResponse> responses,  
            bulkDocsItr.capture(),  
        when(state.metadata()).thenReturn(metadata);  
    TransportService transportService;
        assertFalse(action.isExecuted); // haven't executed yet  
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        // Build update requests  
        }
        remoteNode2 = mock(DiscoveryNode.class);
            responseCalled.set(true);
        if (usedNode1) {
import org.opensearch.cluster.metadata.IndexMetadata;
        // should not have executed ingest locally
            null,  
    ArgumentCaptor<BiConsumer<Thread, Exception>> completionHandler;
        final Map<String, IndexTemplateMetadata> templateMetadataBuilder = new HashMap<>();  
        localIngest = false;  
            eq(1),
 *  
        completionHandler.getValue().accept(null, exception);
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
        ClusterState state = mock(ClusterState.class);  
            eq(Names.WRITE)
            failureCalled.set(true);  
        assertFalse(action.isExecuted); // haven't executed yet
                null
import java.util.Arrays;
        Exception exception = new Exception("fake exception");
import org.opensearch.common.compress.CompressedXContent;
    }
