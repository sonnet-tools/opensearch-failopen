                                .build()
        assertTrue(action.isExecuted);
        Exception exception = new Exception("fake exception");
        assertFalse(action.isExecuted); // no local index execution
        @Override
import static org.hamcrest.Matchers.sameInstance;
        assertFalse(failureCalled.get());
    public void testFindDefaultPipelineFromV2TemplateMatch() throws Exception {
        reset(transportService); // call on construction of action
            Map<String, IndexNotFoundException> indicesThatCannotBeCreated
            eq(1),
        indexRequest.source(emptyMap());
        // should not have executed ingest locally
                NoopTracer.INSTANCE
/*
        assertTrue(action.isExecuted);
        verify(ingestService, never()).resolveSystemIngestPipeline(any(), eq(indexRequestUpsertForNormalUpsert), any());
        when(localNode.isIngestNode()).thenAnswer(stub -> localIngest);
            any()
                .build()
        singleItemBulkWriteAction.execute(null, indexRequest, listener);
        ) {
        reset(transportService);
        nodes = mock(DiscoveryNodes.class);
        IndexRequest indexRequestDocForNormalUpsert = new IndexRequest(indexRequestIndexName).id("id5").source(emptyMap());
        verifyNoInteractions(transportService);
                .order(1)
        // setup nodes for local and remote
        ActionListener<BulkResponse> listener = ActionListener.wrap(response -> {
            .build();
            final AtomicArray<BulkItemResponse> responses,
        // bulk upserts with a default pipeline are a bit surprising since the script executes AFTER the pipeline.
        when(clusterService.state()).thenReturn(state);
            .scriptedUpsert(true);
        action.execute(null, bulkRequest, ActionListener.wrap(response -> {
import static org.hamcrest.Matchers.containsString;
            BulkItemResponse itemResponse = response.iterator().next();
        assertEquals(indexRequest.getPipeline(), "default_pipeline");
            eq(1),
        UpdateRequest regularUpdate = new UpdateRequest(updateRequestIndexName, "id4").doc(indexRequestForNormalUpdate);
    private static final Thread DUMMY_WRITE_THREAD = new Thread(ThreadPool.Names.WRITE);
        IndexRequest indexRequest1 = new IndexRequest("index").id("id");
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        // this test only covers the mechanics that scripted bulk upserts will execute a default pipeline. However, in practice scripted
        indexRequest.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.ActionFilters;
                transportService,
        assertFalse(action.isExecuted); // haven't executed yet
        assertTrue(action.isExecuted);
                .order(2)
        // check failure works, and passes through to the listener
            eq(bulkRequest.numberOfActions()),
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
        IndexRequest indexRequestUpsertForNormalUpsert = new IndexRequest(indexRequestIndexName).id("id6").source(emptyMap());
        void createIndex(String index, TimeValue timeout, Version minNodeVersion, ActionListener<CreateIndexResponse> listener) {
            bulkDocsItr.capture(),
    public void testFindDefaultPipelineFromTemplateMatch() {
        Exception exception = new Exception("fake exception");
        boolean needToCheck; // pluggable return value for `needToCheck`
            any(),
            failureHandler.capture(),
        assertFalse(action.isExecuted); // still no local index execution
    }
import org.opensearch.action.index.IndexRequest;
    ArgumentCaptor<BiConsumer<Integer, Exception>> failureHandler;
    private static final String WITH_DEFAULT_PIPELINE_ALIAS = "alias_for_index_with_default_pipeline";
    /**
        action = new TestTransportBulkAction();
        localIngest = false;
        state.metadata().templatesV2().remove("my-template");
        threadPool = mock(ThreadPool.class);
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> { responseCalled.set(true); }, e -> {
            failureCalled.set(true);
            BulkItemResponse itemResponse = response.iterator().next();
import java.util.HashMap;
        // should not have executed ingest locally
    public void testUseDefaultPipelineWithAlias() throws Exception {
        }));
    }
        assertTrue(failureCalled.get());
        }, e -> { throw new AssertionError(e); });
import org.opensearch.cluster.metadata.IndexMetadata;
        AtomicBoolean failureCalled = new AtomicBoolean(false);
            any(),
            failureHandler.capture(),
import org.opensearch.action.DocWriteRequest;
        verifyNoInteractions(transportService);
                null,
        assertFalse(failureCalled.get());
import static org.mockito.Mockito.reset;
        indexRequest.setPipeline("testpipeline");
            responseCalled.set(true);
        ingestService = spy(createIngestServiceWithProcessors(Collections.emptyMap()));
        failureHandler.getValue().accept(0, exception); // have an exception for our one index request
        boolean indexCreated = true; // If set to false, will be set to true by call to createIndex
                                .numberOfReplicas(1)
        );
                .settings(Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "pipeline4").build())
        assertEquals(indexRequest2.getPipeline(), "default_pipeline");
     * Index for which mock settings contain a default pipeline.
        indexRequestUpsertForNormalUpsert.setPipeline(IngestService.NOOP_PIPELINE_NAME);
        AtomicBoolean responseCalled = new AtomicBoolean(false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this work for additional information regarding copyright
        failureHandler.getValue().accept(0, exception); // have an exception for our one index request
    }
    private static final String WITH_DEFAULT_PIPELINE = "index_with_default_pipeline";
            ((ClusterStateApplier) invocation.getArguments()[0]).applyClusterState(event);
import java.util.concurrent.atomic.AtomicBoolean;
        }
    public void testSingleItemBulkActionIngestForward() throws Exception {
        final Map<String, DiscoveryNode> ingestNodes = Map.of("node1", remoteNode1, "node2", remoteNode2);
import org.opensearch.index.IndexNotFoundException;
import static org.mockito.Mockito.mock;
import org.opensearch.test.ClusterServiceUtils;
        ingestService.applyClusterState(
        ActionListener<IndexResponse> listener = ActionListener.wrap(response -> {
                            WITH_DEFAULT_PIPELINE,
            bulkDocsItr.capture(),
        assertNull(indexRequest3.getPipeline());
            completionHandler.capture(),
        BulkRequest bulkRequest = new BulkRequest();
    ThreadPool threadPool;
        }));
    public void setupAction() {
        verify(ingestService, never()).resolvePipelines(any(), eq(indexRequestForNormalUpdate), any());
            .script(mockScript("1"))
            null
        }));
        ClusterState ingestServiceClusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
                .patterns(Arrays.asList("nope"))
        }));
            assertThat(e, sameInstance(exception));
    }
        bulkRequest.add(indexRequest1);
        AtomicBoolean failureCalled = new AtomicBoolean(false);
        completionHandler.getValue().accept(null, exception);
import java.util.Map;
    }
import org.opensearch.threadpool.ThreadPool.Names;
    /** A subclass of the real bulk action to allow skipping real bulk indexing, and marking when it would have happened. */
            assertThat(e, sameInstance(exception));
        boolean usedNode1 = node.getValue() == remoteNode1; // make sure we used one of the nodes
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
            eq(Names.WRITE)
        verify(ingestService, times(1)).resolvePipelines(eq(docAsUpsertRequest), eq(indexRequest2), any());
        ClusterState state = clusterService.state();
    public void testIngestForward() throws Exception {
    }
                .build()
        Exception exception = new Exception("fake exception");
            any(),
        completionHandler.getValue().accept(null, exception);
        // check failure works, and passes through to the listener
        verifyNoMoreInteractions(ingestService);
            new ClusterChangedEvent("testFindDefaultPipelineFromV2TemplateMatch", ingestServiceClusterState, ingestServiceClusterState)
            BulkItemResponse itemResponse = response.iterator().next();
        verify(ingestService, never()).executeBulkRequest(anyInt(), any(), any(), any(), any(), any());
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);
    ArgumentCaptor<BiConsumer<Thread, Exception>> completionHandler;
/*
            failureCalled.set(true);
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
        assertTrue(failureCalled.get());
        BulkResponse bulkResponse = mock(BulkResponse.class);
            eq(Names.WRITE)
        doNothing().when(ingestService).executeBulkRequest(anyInt(), any(), any(), any(), any(), anyString());
        }));
 * under the License.
        bulkItemResponses[0] = itemResponse;
                                .settings(settings(Version.CURRENT))
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
        if (usedNode1 == false) {
        ArgumentCaptor<DiscoveryNode> node = ArgumentCaptor.forClass(DiscoveryNode.class);
            failureCalled.set(true);
            ),
        }
        assertFalse(responseCalled.get());
 * software distributed under the License is distributed on an
        assertFalse(action.isExecuted); // haven't executed yet
            Collections.singletonList("missing_*"),
import static org.mockito.Mockito.anyInt;
        );
import org.opensearch.common.settings.Settings;
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);
    ArgumentCaptor<TransportResponseHandler<BulkResponse>> remoteResponseHandler;
            null,
    }
        verify(transportService).sendRequest(node.capture(), eq(BulkAction.NAME), any(), remoteResponseHandler.capture());
            responseCalled.set(true);
        verify(ingestService, never()).resolvePipelines(any(), eq(indexRequestDocForNormalUpsert), any());
        IndexRequest indexRequest = new IndexRequest("index").id("id");
            any(),
                            ".system",
        assertFalse(responseCalled.get()); // listener not called yet
        indexRequest.source(emptyMap());
        assertTrue(action.isExecuted);
    /** True if the next call to the index action should act as an ingest node */
import static org.mockito.Mockito.verify;
        when(metadata.getTemplates()).thenReturn(templateMetadataBuilder);
        indexRequest2.setPipeline("testpipeline");
            );
        );
            eq(1),
import org.opensearch.Version;
            eq(upsertWithDocAndUpsertRequest),
            failureCalled.set(true);
        IndexRequest indexRequest2 = new IndexRequest(indexRequestIndexName).id("id2").source(emptyMap());
            assertSame(remoteNode2, node.getValue());
        assertFalse(failureCalled.get());
            responseCalled.set(true);
        BulkItemResponse itemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.CREATE, indexResponse);
        }
        singleItemBulkWriteAction = new TestSingleItemBulkWriteAction(action);
            eq(Names.SYSTEM_WRITE)
            super(
            failureHandler.capture(),
        indexRequestDocForNormalUpsert.setPipeline(IngestService.NOOP_PIPELINE_NAME);
    /** The actual action we want to test, with real indexing mocked */
    }
            eq(Names.WRITE)
                        )
import static org.mockito.Mockito.anyString;
                    ClusterServiceUtils.createClusterService(
import org.junit.Before;
        // now check success
        AtomicBoolean failureCalled = new AtomicBoolean(false);
import org.opensearch.action.index.IndexResponse;
/*
            null,
        ActionTestUtils.execute(action, null, bulkRequest, ActionListener.wrap(response -> {
        BulkRequest bulkRequest = new BulkRequest();
        String indexRequestName = randomFrom(new String[] { null, WITH_DEFAULT_PIPELINE, WITH_DEFAULT_PIPELINE_ALIAS });
            any(),
        verifyNoInteractions(transportService);
        indexRequest2.source(emptyMap());
        verify(ingestService).executeBulkRequest(
            assertSame(remoteNode1, node.getValue());
    public void testIngestSkipped() throws Exception {
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
        }));
        DiscoveryNode localNode = mock(DiscoveryNode.class);
        bulkRequest.add(indexRequest1);
import org.opensearch.cluster.node.DiscoveryNodes;
        }));
        remoteResponseHandler.getValue().handleResponse(new BulkResponse(bulkItemResponses, 0)); // call the listener for the remote node
        when(state.getMetadata()).thenReturn(metadata);
        final MetadataIndexTemplateService metadataIndexTemplateService = getInstanceFromNode(MetadataIndexTemplateService.class);
            IndexTemplateMetadata.builder("template1")
    public void testSingleItemBulkActionIngestSkipped() throws Exception {
            assertThat(e, sameInstance(exception));
        verify(ingestService, never()).executeBulkRequest(anyInt(), any(), any(), any(), any(), any());
 * The OpenSearch Contributors require contributions made to
                    SETTINGS,
        when(state.getMetadata()).thenReturn(metadata);
    public void testUseDefaultPipeline() throws Exception {
                                    settings(Version.CURRENT).put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline").build()
        final ExecutorService direct = OpenSearchExecutors.newDirectExecutorService();
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        templateMetadataBuilder.put(
                new IndexingPressureService(
        assertFalse(action.indexCreated); // no index yet
        BulkRequest bulkRequest = new BulkRequest();
        AtomicBoolean failureCalled = new AtomicBoolean(false);
                TransportBulkActionIngestTests.this.transportService,
        verify(transportService).sendRequest(node.capture(), eq(BulkAction.NAME), any(), remoteResponseHandler.capture());
        // check failure works, and passes through to the listener
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
        remoteNode2 = mock(DiscoveryNode.class);
import org.opensearch.test.VersionUtils;
                new AutoCreateIndex(
        }
            when(event.state()).thenReturn(state);
        assertFalse(failureCalled.get());
import static org.mockito.Mockito.when;
 *
    }
        verify(ingestService, times(1)).resolvePipelines(eq(upsertWithDocAndUpsertRequest), eq(indexRequestUpsertForNormalUpsert), any());
    }
        // initialize captors, which must be members to use @Capture because of generics
        if (usedNode1) {
        ClusterState state = mock(ClusterState.class);
        void executeBulk(
                )
        assertNull(indexRequest1.getPipeline());
    private void validateDefaultPipeline(IndexRequest indexRequest) {
        }, e -> {
import static org.mockito.Answers.RETURNS_MOCKS;
        );
        BulkItemResponse[] bulkItemResponses = new BulkItemResponse[1];
    private void validatePipelineWithBulkUpsert(@Nullable String indexRequestIndexName, String updateRequestIndexName) throws Exception {
    /** Arguments to callbacks we want to capture, but which require generics, so we must use @Captor */
        );
        indexRequest.setPipeline("testpipeline");
        verify(ingestService, never()).resolveSystemIngestPipeline(any(), eq(indexRequest3), any());
        }
            assertSame(remoteNode2, node.getValue());
            bulkDocsItr.capture(),
        }));
 * You may obtain a copy of the License at
package org.opensearch.action.bulk;
    }
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        assertNull(indexRequest2.getPipeline());
        // now check success
        }));
        Exception exception = new Exception("fake exception");
                    )
    private static final Settings SETTINGS = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), true).build();
import org.opensearch.cluster.metadata.Template;
            responseCalled.set(true);
                    MapBuilder.<String, IndexMetadata>newMapBuilder()
        verify(ingestService, times(1)).resolveSystemIngestPipeline(any(), eq(indexRequestForNormalUpdate), any());
        // mock the cluster state for the ingest service
            failureHandler.capture(),
            failureHandler.capture(),
        completionHandler = ArgumentCaptor.forClass(BiConsumer.class);
        when(state.metadata()).thenReturn(metadata);
        assertEquals(indexRequest3.getPipeline(), "default_pipeline");
            assertTrue(indexCreated);
        remoteResponseHandler.getValue().handleResponse(bulkResponse); // call the listener for the remote node
                threadPool,
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> {}, exception -> {
        Exception exception = new Exception("fake exception");
        when(nodes.getIngestNodes()).thenReturn(ingestNodes);
        localIngest = true;
import org.opensearch.indices.SystemIndices;
        IndexRequest indexRequest = new IndexRequest("index").id("id");
    }
        IndexRequest indexRequestForNormalUpdate = new IndexRequest(indexRequestIndexName).id("id4").source(emptyMap());
        bulkRequest.add(indexRequest2);
        bulkDocsItr = ArgumentCaptor.forClass(Iterable.class);
        );
import java.util.concurrent.ExecutorService;
        );
                .settings(Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "pipeline1").build())
        assertFalse(action.isExecuted); // haven't executed yet
        // now make sure ingest nodes are rotated through with a subsequent request
        }, e -> { throw new AssertionError(e); });
 * compatible open source license.
 * not use this file except in compliance with the License.
        indexRequest.source(emptyMap());
        Iterator<DocWriteRequest<?>> req = bulkDocsItr.getValue().iterator();
        if (usedNode1) {
        indexRequest1.setPipeline("testpipeline");
        // Add update requests
    class TestSingleItemBulkWriteAction extends TransportSingleItemBulkWriteAction<IndexRequest, IndexResponse> {
        verifyNoInteractions(transportService);
    DiscoveryNodes nodes;
        @Override
                                .putAlias(AliasMetadata.builder(WITH_DEFAULT_PIPELINE_ALIAS).build())
        verifyNoInteractions(transportService);
import org.opensearch.action.update.UpdateRequest;
        verify(ingestService, never()).resolveSystemIngestPipeline(any(), eq(indexRequest1), any());
    }
        final Map<String, IndexTemplateMetadata> templateMetadataBuilder = new HashMap<>();
        );
        Metadata metadata = mock(Metadata.class);
        AtomicBoolean failureCalled = new AtomicBoolean(false);
                            IndexMetadata.builder(".system")
            eq(Names.WRITE)
import static org.opensearch.ingest.IngestServiceTests.createIngestServiceWithProcessors;
import org.opensearch.action.support.AutoCreateIndex;
            failureCalled.set(true);
        indexRequest.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
        ComposableIndexTemplate t1 = new ComposableIndexTemplate(
            assertSame(indexResponse, response);
    public void testUseDefaultPipelineWithBulkUpsert() throws Exception {
            "template3",
        verify(ingestService).executeBulkRequest(
}
        verify(ingestService, times(1)).resolvePipelines(eq(upsertRequest), eq(indexRequest1), any());
            assertThat(itemResponse.getFailure().getMessage(), containsString("fake exception"));
public class TransportBulkActionIngestTests extends OpenSearchSingleNodeTestCase {
    }
        verify(ingestService).executeBulkRequest(
            failureCalled.set(true);
                IndexAction.NAME,
            indexCreated = true;
            null,
        completionHandler.getValue().accept(null, exception);
                .patterns(Arrays.asList("missing_*"))
            bulkDocsItr.capture(),
        completionHandler.getValue().accept(null, exception);
import java.util.function.BiConsumer;
 * KIND, either express or implied.  See the License for the
            eq(1),
        indexRequest1.setPipeline("testpipeline");
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> { responseCalled.set(true); }, e -> {
 * license agreements. See the NOTICE file distributed with
            bulkDocsItr.capture(),
    boolean localIngest;
    ArgumentCaptor<Iterable<DocWriteRequest<?>>> bulkDocsItr;
                                .build()
            eq(Names.WRITE)
import org.opensearch.cluster.metadata.AliasMetadata;
        assertFalse(failureCalled.get());
        IndexRequest indexRequest = new IndexRequest("missing_index").id("id");
        }).when(clusterService).addStateApplier(any(ClusterStateApplier.class));
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> responseCalled.set(true), e -> {
        }
import org.opensearch.index.IndexSettings;
            assertThat(e, sameInstance(exception));
        action.needToCheck = true;
        indexRequest.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
import org.opensearch.common.compress.CompressedXContent;
        IndexResponse indexResponse = mock(IndexResponse.class);
        validateDefaultPipeline(new IndexRequest(WITH_DEFAULT_PIPELINE_ALIAS).id("id"));
import org.opensearch.action.support.ActionTestUtils;
        );
        );
        UpdateRequest upsertWithDocAndUpsertRequest = new UpdateRequest(updateRequestIndexName, "id4").doc(indexRequestDocForNormalUpsert)
            ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        remoteNode1 = mock(DiscoveryNode.class);
                IndexRequest::new,
        Exception exception = new Exception("fake exception");
            final BulkRequest bulkRequest,
        Iterator<DocWriteRequest<?>> req = bulkDocsItr.getValue().iterator();
        indexRequest.source(emptyMap());
        assertTrue(responseCalled.get()); // now the listener we passed should have been delegated to by the remote listener
        AtomicBoolean responseCalled = new AtomicBoolean(false);
            "template4",
                            IndexMetadata.builder(WITH_DEFAULT_PIPELINE)
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
     */
                    new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        verify(ingestService).executeBulkRequest(
 * the Apache License, Version 2.0 (the "License"); you may
        IndexRequest indexRequest = new IndexRequest("index").id("id");
        remoteResponseHandler = ArgumentCaptor.forClass(TransportResponseHandler.class);
            failureCalled.set(true);
        // check failure works, and passes through to the listener
                new HashMap<>(
        assertFalse(action.isExecuted); // haven't executed yet
                        SETTINGS,
        validateDefaultPipeline(new IndexRequest(WITH_DEFAULT_PIPELINE).id("id"));
        @Override
import org.opensearch.cluster.metadata.Metadata;
        validatePipelineWithBulkUpsert(indexRequestName, WITH_DEFAULT_PIPELINE);
 */
        IndexRequest indexRequest = new IndexRequest("index").id("id");
            bulkDocsItr.capture(),
        verifyNoInteractions(transportService);
            listener.onResponse(null);
        UpdateRequest docAsUpsertRequest = new UpdateRequest(updateRequestIndexName, "id2").doc(indexRequest2).docAsUpsert(true);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
            failureCalled.set(true);
        bulkRequest.add(upsertRequest).add(docAsUpsertRequest).add(scriptedUpsert).add(regularUpdate).add(upsertWithDocAndUpsertRequest);
    public void testIngestLocal() throws Exception {
            super(
        verify(ingestService).executeBulkRequest(
                clusterService,
        // now check success of the transport bulk action
                null,
                                .system(true)
        when(state.getMetadata()).thenReturn(metadata);
            assertSame(remoteNode1, node.getValue());
        validatePipelineWithBulkUpsert(indexRequestName, WITH_DEFAULT_PIPELINE_ALIAS);
        IndexRequest indexRequest2 = new IndexRequest(".system").id("id");
        action.execute(null, bulkRequest, ActionListener.wrap(response -> {}, exception -> { throw new AssertionError(exception); }));
    DiscoveryNode remoteNode2;
            completionHandler.capture(),
        assertFalse(action.isExecuted); // no local index execution
        action.execute(null, bulkRequest, ActionListener.wrap(response -> {
 *
                    new SystemIndices(emptyMap())
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        verify(ingestService).executeBulkRequest(
        assertFalse(responseCalled.get());
import java.util.Collections;
        // now check success
            assertSame(bulkResponse, response);
            any(),
    public void testNotFindDefaultPipelineFromTemplateMatches() {
        IndexRequest indexRequest2 = new IndexRequest("index").id("id");
        // check failure works, and passes through to the listener
        verify(ingestService, times(1)).resolvePipelines(any(), any(), any());
        assertTrue(action.isExecuted);
        assertTrue(failureCalled.get());
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        // setup services that will be called by action
            eq(bulkRequest.numberOfActions()),
        );
            bulkDocsItr.capture(),
        bulkRequest.add(indexRequest);
import org.opensearch.threadpool.ThreadPool;
            )
        assertFalse(responseCalled.get());
            IndexTemplateMetadata.builder("template3").patterns(Arrays.asList("missing*")).order(3).build()
        verify(ingestService, never()).resolveSystemIngestPipeline(any(), eq(indexRequest2), any());
        when(metadata.templates()).thenReturn(templateMetadataBuilder);
    /** The nodes that forwarded index requests should be cycled through. */
        assertEquals("pipeline2", indexRequest.getPipeline());
        verifyNoMoreInteractions(ingestService);
    }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    DiscoveryNode remoteNode1;
        );
            eq(1),
                                .numberOfShards(1)
        assertEquals(IngestService.NOOP_PIPELINE_NAME, indexRequest.getPipeline());
            failureHandler.capture(),
        verify(ingestService).executeBulkRequest(
    }
        // An update request has two child update requests, DOC and UPSERT
        verify(transportService).sendRequest(node.capture(), eq(BulkAction.NAME), any(), remoteResponseHandler.capture());
            return null;
            assertThat(itemResponse.getFailure().getMessage(), containsString("fake exception"));
        verifyNoMoreInteractions(ingestService);
        ClusterState state = clusterService.state();
        assertTrue(action.isExecuted);
        bulkRequest.add(indexRequest2);
            failureHandler.capture(),
import org.opensearch.cluster.ClusterStateApplier;
        IndexRequest indexRequest = new IndexRequest("missing_index").id("id");
            final long startTimeNanos,
                        .map()
        assertFalse(responseCalled.get());
        String indexRequestName = randomFrom(new String[] { null, WITH_DEFAULT_PIPELINE, WITH_DEFAULT_PIPELINE_ALIAS });
import static org.mockito.Mockito.verifyNoMoreInteractions;
        indexRequest1.source(emptyMap());
                .patterns(Arrays.asList("missing_index"))
        assertFalse(responseCalled.get()); // listener not called yet
 * Unless required by applicable law or agreed to in writing,
                .build()
        assertTrue(responseCalled.get()); // now the listener we passed should have been delegated to by the remote listener
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        } else {
        AtomicBoolean failureCalled = new AtomicBoolean(false);
import org.opensearch.common.Nullable;
        assertEquals(indexRequestUpsertForNormalUpsert.getPipeline(), "default_pipeline");
        AtomicBoolean failureCalled = new AtomicBoolean(false);
        // setup the mocked ingest service for capturing calls
    }
        Exception exception = new Exception("fake exception");
        templateMetadataBuilder.put(
        }
 * Licensed to Elasticsearch under one or more contributor
        indexRequest.source(emptyMap());
            assertSame(remoteNode2, node.getValue());
        TestSingleItemBulkWriteAction(TestTransportBulkAction bulkAction) {
        when(state.metadata()).thenReturn(metadata);
 * SPDX-License-Identifier: Apache-2.0
import static org.mockito.Mockito.spy;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            .upsert(indexRequestUpsertForNormalUpsert);
        assertFalse(action.isExecuted); // haven't executed yet
        templateMetadataBuilder.put(
import static org.mockito.Mockito.never;
        // 2. UPSERT will have ALL pipelines resolved
import org.mockito.ArgumentCaptor;
            any(),
        );
        // check failure works, and passes through to the listener
        } else {
        action.indexCreated = false;
import org.opensearch.common.settings.ClusterSettings;
                ),
        Metadata metadata = Metadata.builder().put("my-template", t1).build();
import org.opensearch.transport.TransportService;
        indexRequest.source(emptyMap());
        AtomicBoolean failureCalled = new AtomicBoolean(false);
            IndexTemplateMetadata.builder("template2")
        transportService = mock(TransportService.class, RETURNS_MOCKS);
        // Verify for different Update cases, we call the correct resolve
            null,
    class TestTransportBulkAction extends TransportBulkAction {
 * GitHub history for details.
        );
        UpdateRequest scriptedUpsert = new UpdateRequest(updateRequestIndexName, "id2").upsert(indexRequest3)
        bulkRequest.add(indexRequest);
        BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.tasks.Task;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
import org.opensearch.cluster.ClusterName;
        ArgumentCaptor<DiscoveryNode> node = ArgumentCaptor.forClass(DiscoveryNode.class);
import org.opensearch.common.unit.TimeValue;
        verify(transportService).sendRequest(node.capture(), eq(BulkAction.NAME), any(), remoteResponseHandler.capture());
        verify(ingestService, times(1)).resolvePipelines(any(), any(), any());
        when(state.metadata()).thenReturn(metadata);
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);
            responseCalled.set(true);
            isExecuted = true;
                        )
            any(),
import org.opensearch.cluster.ClusterChangedEvent;
        reset(transportService);
import org.opensearch.core.action.ActionListener;
            assertThat(e, sameInstance(exception));
import java.util.Iterator;
        indexRequest2.setPipeline("testpipeline");
    TestTransportBulkAction action;
        indexRequest.source(emptyMap());
        indexRequestForNormalUpdate.setPipeline(IngestService.NOOP_PIPELINE_NAME);
            completionHandler.capture(),
                bulkAction,
        completionHandler.getValue().accept(null, exception);
            return needToCheck;
import org.opensearch.common.collect.MapBuilder;
        Metadata metadata = Metadata.builder()
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);
import static org.mockito.Mockito.times;
    TransportService transportService;
        localIngest = false;
    }
        templateMetadataBuilder.put(
            new Template(
import static org.mockito.Mockito.verifyNoInteractions;
        indexRequest.setPipeline("testpipeline");
import static org.mockito.Mockito.any;
        IndexRequest indexRequest = new IndexRequest("index").id("id");
            assertThat(e, sameInstance(exception));
        assertTrue(action.isExecuted);
        indexRequest3.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
 */
    @Before
            assertThat(itemResponse.getFailure().getMessage(), containsString("fake exception"));
        assertTrue(action.indexCreated); // now the index is created since we skipped the ingest node path.
        assertTrue(failureCalled.get());
                ),
            Task task,
        AtomicBoolean responseCalled = new AtomicBoolean(false);
import org.opensearch.cluster.ClusterState;
import org.opensearch.ingest.IngestService;
            completionHandler.capture(),
        }, e -> {
            assertThat(e, sameInstance(exception));
            completionHandler.capture(),
 * specific language governing permissions and limitations
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
        indexRequest.setPipeline("testpipeline");
            assertThat(e, sameInstance(exception));
                        .put(
        indexRequest2.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
                .settings(Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "pipeline2").build())
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);
        assertNull(indexRequest.getPipeline());
        assertFalse(failureCalled.get());
        // 1. DOC will only have system pipeline resolved. Exception is if docAsUpsert is true, DOC will have all pipelines resolved
import static org.mockito.Mockito.doAnswer;
        verify(ingestService).executeBulkRequest(
    /** Single item bulk write action that wraps index requests */
            completionHandler.capture(),
            );
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> responseCalled.set(true), e -> {
        assertNull(indexRequestForNormalUpdate.getPipeline());
        TestTransportBulkAction() {
            assertSame(remoteNode2, node.getValue());
        boolean usedNode1 = node.getValue() == remoteNode1; // make sure we used one of the nodes
        metadataIndexTemplateService.addIndexTemplateV2(state, false, "my-template", t1);
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> responseCalled.set(true), e -> {
        IndexRequest indexRequest = new IndexRequest("missing_index").id("id");
        UpdateRequest upsertRequest = new UpdateRequest(updateRequestIndexName, "id1").upsert(indexRequest1).script(mockScript("1"));
        // but instead should have sent to a remote node with the transport service
        AtomicBoolean failureCalled = new AtomicBoolean(false);
        assertNull(indexRequestUpsertForNormalUpsert.getPipeline());
        indexRequest1.source(emptyMap());
            assertThat(e, sameInstance(exception));
        // now make sure ingest nodes are rotated through with a subsequent request
    IngestService ingestService;
        }, e -> {
        verify(ingestService, times(1)).resolvePipelines(eq(scriptedUpsert), eq(indexRequest3), any());
    public void testDoExecuteCalledTwiceCorrectly() throws Exception {
        singleItemBulkWriteAction.execute(null, indexRequest, listener);
import org.opensearch.cluster.service.ClusterService;
        indexRequest2.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
                new CompressedXContent("{}"),
        // Build update requests
                                .numberOfShards(1)
        assertFalse(responseCalled.get()); // listener would only be called by real index action, not our mocked one
        IndexRequest indexRequest3 = new IndexRequest(indexRequestIndexName).id("id3").source(emptyMap());
    public void testSingleItemBulkActionIngestLocal() throws Exception {
 * ownership. Elasticsearch licenses this file to you under
import static org.mockito.Mockito.eq;
        IndexRequest indexRequest = new IndexRequest("missing_index").id("id");
                new SystemIndices(emptyMap()),
        when(metadata.indices()).thenReturn(Map.of());
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        when(nodes.getMinNodeVersion()).thenReturn(VersionUtils.randomCompatibleVersion(random(), Version.CURRENT));
            "template2",
import org.opensearch.action.index.IndexAction;
        AtomicBoolean responseCalled = new AtomicBoolean(false);
                                .numberOfReplicas(0)
        assertTrue(failureCalled.get());
        assertEquals(indexRequestForNormalUpdate.getPipeline(), IngestService.NOOP_PIPELINE_NAME);
        assertEquals(indexRequestDocForNormalUpsert.getPipeline(), IngestService.NOOP_PIPELINE_NAME);
        );
import org.opensearch.cluster.node.DiscoveryNode;
            final ActionListener<BulkResponse> listener,
        assertEquals(indexRequest1.getPipeline(), "default_pipeline");
import org.opensearch.common.util.concurrent.AtomicArray;
        assertFalse(responseCalled.get());
        when(clusterService.localNode()).thenReturn(localNode);
                ingestService,
            eq(indexRequestDocForNormalUpsert),
import static java.util.Collections.emptyMap;
                null,
        indexRequest.source(emptyMap());
        protected boolean needToCheck() {
    ClusterService clusterService;
    TestSingleItemBulkWriteAction singleItemBulkWriteAction;
        assertEquals("pipeline2", indexRequest.getPipeline());
                    new ClusterSettings(SETTINGS, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        completionHandler.getValue().accept(null, exception);
                    SETTINGS,
        failureHandler = ArgumentCaptor.forClass(BiConsumer.class);
import static org.mockito.Mockito.doNothing;
                .order(4)
        indexRequest1.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
        action.execute(null, bulkRequest, listener);
            throw new AssertionError(exception);
        assertTrue(action.isExecuted);
import org.opensearch.index.IndexingPressureService;
        // but instead should have sent to a remote node with the transport service
            failureCalled.set(true);
 *
        completionHandler.getValue().accept(DUMMY_WRITE_THREAD, null);
            IndexTemplateMetadata.builder("template4")
        indexRequest.source(emptyMap());
        Exception exception = new Exception("fake exception");
            "template1",
            completionHandler.capture(),
        // now check success
        assertFalse(action.isExecuted); // haven't executed yet
        }
        when(state.getNodes()).thenReturn(nodes);
    /** Services needed by bulk action */
                                .settings(
        Exception exception = new Exception("fake exception");
                        null
        // now check success
        BulkRequest bulkRequest = new BulkRequest();
    public void testIngestSystemLocal() throws Exception {
        indexRequest.source(emptyMap());
        IndexRequest indexRequest1 = new IndexRequest(".system").id("id");
        assertNull(indexRequestDocForNormalUpsert.getPipeline());
import org.opensearch.common.util.concurrent.ThreadContext;
                new ActionFilters(Collections.emptySet()),
 */
            eq(Names.WRITE)
        assertFalse(responseCalled.get());
        assertFalse(action.indexCreated); // still no index yet, the ingest node failed.
import java.util.Arrays;
        clusterService = mock(ClusterService.class);
                null
        assertTrue(failureCalled.get());
    public void testUseDefaultPipelineWithBulkUpsertWithAlias() throws Exception {
                null,
                new ActionFilters(Collections.emptySet()),
                Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "pipeline2").build(),
        doAnswer(invocation -> {
            .indices(
        singleItemBulkWriteAction.execute(null, indexRequest, ActionListener.wrap(response -> responseCalled.set(true), e -> {
        verify(ingestService, times(1)).resolveSystemIngestPipeline(
        boolean isExecuted = false; // set when the "real" bulk execution happens
            completionHandler.capture(),
    }
        }
        if (usedNode1 == false) {
    }
        assertFalse(action.isExecuted); // still no local index execution
        indexRequest2.source(emptyMap());
        IndexRequest indexRequest1 = new IndexRequest(indexRequestIndexName).id("id1").source(emptyMap());
        verify(ingestService, times(1)).resolvePipelines(any(), any(), any());
        }));
            eq(Names.WRITE)
            bulkDocsItr.capture(),
        action.execute(null, bulkRequest, listener);
                        new ClusterSettings(SETTINGS, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            failureHandler.capture(),
        AtomicBoolean responseCalled = new AtomicBoolean(false);
        when(threadPool.executor(anyString())).thenReturn(direct);
                        .put(
                                )
import org.opensearch.transport.TransportResponseHandler;
        indexRequest2.setPipeline(IngestService.NOOP_PIPELINE_NAME); // this is done by the real pipeline execution service when processing
            eq(bulkRequest.numberOfActions()),
