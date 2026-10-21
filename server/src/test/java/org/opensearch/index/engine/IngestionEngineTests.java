import org.opensearch.indices.pollingingest.XContentIngestionPayloadDecoder;
        waitForResults(ingestionEngine, 2);
public class IngestionEngineTests extends EngineTestCase {
    private IndexSettings indexSettings;
import org.apache.lucene.index.NoMergePolicy;
        ingestionEngine = buildIngestionEngine(
 *
        publishData("{\"_id\":\"2\",\"_source\":{\"name\":\"bob\", \"age\": 24}}");
            assertTrue(e.getCause() instanceof IOException);
        // Should not flush immediately after commit
        if (!Lucene.indexExists(store.directory())) {
        publishData("{\"_id\":\"3\",\"_source\":{\"name\":\"john\", \"age\": 30}}");
        when(clusterApplierService.state()).thenReturn(ClusterState.EMPTY_STATE);
            );
            ingestService,
    }
        }
        config = config(config, () -> new DocumentMapperForType(mapperService.documentMapper(), null), clusterApplierService);
        } catch (EngineException e) {
        assertEquals(6, stats.getConsumerStats().totalPolledCount());
        // Publish new messages, which will advance the batch start pointer
import org.opensearch.action.admin.indices.streamingingestion.state.ShardIngestionState;
        ingestionEngine.flush(false, true);
    }
            clusterApplierService
    private ClusterApplierService clusterApplierService;
 */
        String mapping = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";
import org.opensearch.index.translog.Translog;
            assertEquals("Simulated IOException", e.getCause().getMessage());
        );
        ingestionEngine.flush(false, true);
        engine.close();
        waitForResults(ingestionEngine, 4);
    }
        assertEquals(false, resumedIngestionState.isPollerPaused());
        assertEquals(false, initialIngestionState.isPollerPaused());
        // Should flush because batchStartPointer has changed since last commit
        Store store,
        waitForResults(engine, 2);
        assertFalse(ingestionState.isPollerPaused());
        messages.add(message.getBytes(StandardCharsets.UTF_8));
            config,
        // Not trimUnsafeCommits -- an ingestion engine no longer calls it. readLastCommittedSegmentsInfo is the
            new IngestionEngine(engineConfig, consumerFactory, mock(IngestService.class), XContentIngestionPayloadDecoder.Factory.INSTANCE);
    ) throws IOException {
                engineConfig.getTranslogConfig().getTranslogPath(),
 * The OpenSearch Contributors require contributions made to
        Engine.Delete deleteMock = Mockito.mock(Engine.Delete.class);
import org.opensearch.cluster.ClusterState;
        waitForResults(ingestionEngine, 4);
        );
    @Before
            primaryTerm.get()
        IngestService ingestService = mock(IngestService.class);
    }
    private void waitForResults(Engine engine, int numDocs) {
        PollingIngestStats stats = ingestionEngine.pollingIngestStats();
        );
            indexSettings,
        ingestionEngine.start();
    public void testCreateEngine() throws IOException {
        waitForResults(ingestionEngine, 2);
    }
import org.opensearch.ingest.IngestService;
import org.opensearch.index.IndexSettings;
        super.setUp();
            NoMergePolicy.INSTANCE,
        ingestionEngine.flush(false, true);
        ingestionEngine.close();
            consumerFactory,
            XContentIngestionPayloadDecoder.Factory.INSTANCE
    }
            null,
        indexSettings = newIndexSettings();
            return searcher.getIndexReader().numDocs() == numDocs;
            XContentIngestionPayloadDecoder.Factory.INSTANCE
    public void testCreationFailure() throws IOException {
        publishData("{\"_id\":\"1\",\"_source\":{\"name\":\"alice\", \"age\": 20}}");
        ingestionEngine.flush(false, true);
        AtomicLong globalCheckpoint,
import org.opensearch.test.IndexSettingsModule;
                shardId,
    public void tearDown() throws Exception {
        ingestionEngine.close();
        }
        Store testStore = createStore(indexSettings, newDirectory());
import org.opensearch.common.lucene.Lucene;
import org.junit.Assert;
            engineConfig = config(settings, store, createTempDir(), NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get);
        publishData("{\"_id\":\"4\",\"_source\":{\"name\":\"jane\", \"age\": 25}}");
import static org.mockito.Mockito.when;
            mockStore,
            engineConfig,
        if (ingestionEngineStore != null) {
        waitForResults(ingestionEngine, 2);
        waitForResults(ingestionEngine, 2);
/*
    }
        // Should flush because lastCommittedBatchStartPointer is null (no commit yet)
import org.opensearch.index.mapper.MapperService;
        // the commiit data is the start of the current batch
            final String translogUuid = Translog.createEmptyTranslog(
        Store mockStore = spy(store);
            store.createEmpty(engineConfig.getIndexSettings().getIndexVersionCreated().luceneVersion);
import java.io.IOException;
        FakeIngestionSource.FakeIngestionConsumerFactory consumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);
        Engine.Index indexMock = Mockito.mock(Engine.Index.class);
            store.associateIndexWithNewTranslog(translogUuid);
            ingestionEngine.close();
        publishData("{\"_id\":\"3\",\"_source\":{\"name\":\"john\", \"age\": 30}}");
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        testStore.createEmpty(config.getIndexSettings().getIndexVersionCreated().luceneVersion);
        // flush
        // non-null IngestService — engine should start with pipeline support available
        }
        EngineConfig engineConfig = config(
    private EngineConfig engineConfig;
            shardId,
import java.util.List;
        // resume ingestion with offset reset
        Assert.assertEquals(7, commitData.size());
        IndexSettings settings,
        engineConfig = config(engineConfig, () -> new DocumentMapperForType(mapperService.documentMapper(), null), clusterApplierService);
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.index.store.Store;
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    public void testShouldPeriodicallyFlush() throws IOException {
        engineConfig = config(engineConfig, () -> new DocumentMapperForType(mapperService.documentMapper(), null), clusterApplierService);
        IngestionEngine engine = new IngestionEngine(
                SequenceNumbers.NO_OPS_PERFORMED,
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.concurrent.atomic.AtomicLong;
        // create some initial messages
        engineConfig = null;
        String mapping = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";
                .build()
        // Stands in for the remote store case, where a copy commits SegmentInfos downloaded from another copy:
import org.opensearch.cluster.service.ClusterApplierService;
            mock(IngestService.class),
        Assert.assertEquals("1", commitData.get(StreamPoller.BATCH_START));
    // the messages of the stream to ingest from
            consumerFactory,
        assertEquals("DROP", ingestionState.getErrorPolicy());
        MapperService mapperService = createMapperService(mapping);
            config.getTranslogConfig().getTranslogPath(),
        // flush
        ingestionEngine.flush(false, true);
import java.util.concurrent.TimeUnit;
        final String translogUuid = Translog.createEmptyTranslog(
    public void testPushAPIFailures() {
    }
        ingestionEngine.flush(false, true);
import org.opensearch.common.UUIDs;
        assertTrue(ingestionEngine.shouldPeriodicallyFlush());
                .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "fake")
        // ingest some new messages
            fail("Expected EngineException to be thrown");
    }
        messages = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
        ingestionEngine.updateIngestionSettings(IngestionSettings.builder().setIsPaused(true).build());
}
            assertEquals("failed to create engine", e.getMessage());
    }
        // wait for the engine to ingest all messages
        );
        EngineConfig config = config(indexSettings, testStore, createTempDir(), NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get);
        ingestionEngineStore = createStore(indexSettings, newDirectory());
            new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED),
import org.mockito.Mockito;
        // Flush again
                .put(IndexMetadata.SETTING_INGESTION_SOURCE_POINTER_INIT_RESET, "earliest")
        // Wait for messages to be ingested first so batchStartPointer is set
        super.tearDown();
        waitForResults(ingestionEngine, 7);
    private IngestionEngine buildIngestionEngine(
            null,
import static org.awaitility.Awaitility.await;
    @After
        try (Engine.Searcher searcher = engine.acquireSearcher("index")) {
        // overwrite the config with ingestion engine settings
    public void testIngestionStateUpdate() {
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        ShardIngestionState resumedIngestionState = ingestionEngine.getIngestionState();
    }
        publishData("{\"_id\":\"7\",\"_source\":{\"name\":\"jane\", \"age\": 27}}");
    protected IndexSettings newIndexSettings() {
    private IngestionEngine ingestionEngine;
        ClusterApplierService clusterApplierService
        publishData("{\"_id\":\"5\",\"_source\":{\"name\":\"john\", \"age\": 30}}");
        assertFalse(ingestionEngine.shouldPeriodicallyFlush());
        // After first flush, lastCommittedBatchStartPointer is set
                primaryTerm.get()
    private void publishData(String message) {
        publishData("{\"_id\":\"6\",\"_source\":{\"name\":\"jane\", \"age\": 25}}");
        if (ingestionEngine != null) {
        testStore.close();
        testStore.associateIndexWithNewTranslog(translogUuid);
    }
import org.junit.After;
import org.opensearch.common.settings.Settings;
            "index",
        assertTrue(ingestionEngine.shouldPeriodicallyFlush());
import org.opensearch.index.mapper.DocumentMapperForType;
        // next store call in InternalEngine's constructor, so it fails engine creation the same way.
        // flush
import java.util.ArrayList;
            ingestionEngineStore,
        // validate ingestion state on successful engine creation
import static org.mockito.Mockito.doThrow;
        );
    private List<byte[]> messages;
    }
        // Should not flush immediately after commit since pointer hasn't changed
        ingestionEngine = buildIngestionEngine(globalCheckpoint, ingestionEngineStore, indexSettings, clusterApplierService);
        await().atMost(3, TimeUnit.SECONDS).untilAsserted(() -> { Assert.assertTrue(resultsFound(engine, numDocs)); });
        }
        // overwrite the config with ingestion engine settings
        ShardIngestionState ingestionState = ingestionEngine.getIngestionState();
        ingestionEngineStore.associateIndexWithNewTranslog(UUIDs.randomBase64UUID());
 * SPDX-License-Identifier: Apache-2.0
    }
        );
    @Override
        }
        waitForResults(ingestionEngine, 2);
            indexSettings,
    @Override
    private boolean resultsFound(Engine engine, int numDocs) {
    public void testConstructorWithNonNullIngestService() throws IOException {
            globalCheckpoint::get
        ingestionEngine = buildIngestionEngine(new AtomicLong(0), ingestionEngineStore, indexSettings, clusterApplierService);
            IngestionSettings.builder().setIsPaused(false).setResetState(StreamPoller.ResetState.RESET_BY_OFFSET).setResetValue("1").build()
import org.opensearch.indices.replication.common.ReplicationType;
        // pause ingestion
 * compatible open source license.
        engine.refresh("index");
        assertThrows(IngestionEngineException.class, () -> ingestionEngine.index(indexMock));
    public void testEngineOpensOnACommitNamingAnotherCopysTranslog() throws IOException {
        waitForResults(ingestionEngine, 4);
        MapperService mapperService = createMapperService(mapping);
        FakeIngestionSource.FakeIngestionConsumerFactory consumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);
import org.opensearch.indices.pollingingest.StreamPoller;
import static org.mockito.Mockito.mock;
        waitForResults(ingestionEngine, 6);
        Map<String, String> commitData = ingestionEngine.commitDataAsMap();
        return ingestionEngine;
        publishData("{\"_id\":\"4\",\"_source\":{\"name\":\"jane\", \"age\": 25}}");
        if (engineConfig == null) {
        // associateIndexWithNewTranslog rewrites only TRANSLOG_UUID in the existing commit data.
        ShardIngestionState initialIngestionState = ingestionEngine.getIngestionState();
        );
        // verify the commit data
import java.util.Map;
        assertThrows(IngestionEngineException.class, () -> ingestionEngine.delete(deleteMock));
    private Store ingestionEngineStore;
        return IndexSettingsModule.newIndexSettings(
        IngestionEngine ingestionEngine = new IngestionEngine(
    public void setUp() throws Exception {
import org.junit.Before;
        clusterApplierService = mock(ClusterApplierService.class);
import org.opensearch.indices.pollingingest.IngestionSettings;
            SequenceNumbers.NO_OPS_PERFORMED,
import java.nio.charset.StandardCharsets;
        try {
        FakeIngestionSource.FakeIngestionConsumerFactory consumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);
    }
        MapperService mapperService = createMapperService(mapping);
        publishData("{\"_id\":\"4\",\"_source\":{\"name\":\"jane\", \"age\": 25}}");
package org.opensearch.index.engine;
            ingestionEngineStore.close();
            createTempDir(),
        ingestionEngine.updateIngestionSettings(
        doThrow(new IOException("Simulated IOException")).when(mockStore).readLastCommittedSegmentsInfo();
        // wait for the engine to ingest all messages
import org.opensearch.indices.pollingingest.PollingIngestStats;
        }
        engine.start();
        assertFalse(ingestionState.isWriteBlockEnabled());
        assertFalse(ingestionEngine.shouldPeriodicallyFlush());
        String mapping = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";
        publishData("{\"_id\":\"3\",\"_source\":{\"name\":\"john\", \"age\": 30}}");
    public void testRecovery() throws IOException {
import org.opensearch.index.seqno.SequenceNumbers;
        assertEquals("test", ingestionState.getIndex());
import static org.mockito.Mockito.spy;
            Settings.builder()
