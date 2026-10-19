        // Should flush because lastCommittedBatchStartPointer is null (no commit yet)
        } catch (EngineException e) {
        waitForResults(ingestionEngine, 7);
        ingestionEngine.flush(false, true);  
        // verify the commit data  
        ingestionEngine.flush(false, true);
        EngineConfig config = config(indexSettings, testStore, createTempDir(), NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get);
import org.opensearch.indices.pollingingest.XContentIngestionPayloadDecoder;  
            consumerFactory,
    }  
    }
    }  
import java.util.concurrent.TimeUnit;
        publishData("{\"_id\":\"4\",\"_source\":{\"name\":\"jane\", \"age\": 25}}");  
import org.opensearch.common.lucene.Lucene;
        FakeIngestionSource.FakeIngestionConsumerFactory consumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);
        // Should flush because batchStartPointer has changed since last commit
        publishData("{\"_id\":\"1\",\"_source\":{\"name\":\"alice\", \"age\": 20}}");
            globalCheckpoint::get
        );
                shardId,  
        waitForResults(ingestionEngine, 2);  
import java.nio.charset.StandardCharsets;  
        ingestionEngine.flush(false, true);
        assertFalse(ingestionEngine.shouldPeriodicallyFlush());  
        super.tearDown();
    public void testConstructorWithNonNullIngestService() throws IOException {  
 * compatible open source license.
        waitForResults(ingestionEngine, 2);
            store.createEmpty(engineConfig.getIndexSettings().getIndexVersionCreated().luceneVersion);
            ingestService,  
        assertFalse(ingestionState.isWriteBlockEnabled());
            XContentIngestionPayloadDecoder.Factory.INSTANCE
import static org.mockito.Mockito.doThrow;
    private EngineConfig engineConfig;
import org.opensearch.common.UUIDs;  
        // After first flush, lastCommittedBatchStartPointer is set
        Store store,
    }
        assertEquals(6, stats.getConsumerStats().totalPolledCount());
        publishData("{\"_id\":\"7\",\"_source\":{\"name\":\"jane\", \"age\": 27}}");
        EngineConfig engineConfig = config(  
        publishData("{\"_id\":\"5\",\"_source\":{\"name\":\"john\", \"age\": 30}}");  
import org.opensearch.ingest.IngestService;
        }
        // Publish new messages, which will advance the batch start pointer
            consumerFactory,
        engine.start();  
    @Override
    private IngestionEngine buildIngestionEngine(
        }
    private ClusterApplierService clusterApplierService;
        testStore.close();  
            shardId,
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        String mapping = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";
        }
        try (Engine.Searcher searcher = engine.acquireSearcher("index")) {  
        // Not trimUnsafeCommits -- an ingestion engine no longer calls it. readLastCommittedSegmentsInfo is the
        messages = new ArrayList<>();  
        assertEquals("test", ingestionState.getIndex());
        String mapping = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";
        );
        if (ingestionEngine != null) {
package org.opensearch.index.engine;
            mockStore,
        assertFalse(ingestionEngine.shouldPeriodicallyFlush());
import org.apache.lucene.index.NoMergePolicy;
            SequenceNumbers.NO_OPS_PERFORMED,
        MapperService mapperService = createMapperService(mapping);
import org.opensearch.indices.pollingingest.IngestionSettings;  
import org.opensearch.index.mapper.MapperService;
        assertFalse(ingestionState.isPollerPaused());  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    private void waitForResults(Engine engine, int numDocs) {  
        publishData("{\"_id\":\"3\",\"_source\":{\"name\":\"john\", \"age\": 30}}");  
        // non-null IngestService — engine should start with pipeline support available
        waitForResults(ingestionEngine, 6);
            return searcher.getIndexReader().numDocs() == numDocs;
        String mapping = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";  
            new IngestionEngine(engineConfig, consumerFactory, mock(IngestService.class), XContentIngestionPayloadDecoder.Factory.INSTANCE);
            "index",
 * SPDX-License-Identifier: Apache-2.0
        Assert.assertEquals(7, commitData.size());
        );
        // ingest some new messages
    public void testEngineOpensOnACommitNamingAnotherCopysTranslog() throws IOException {
                engineConfig.getTranslogConfig().getTranslogPath(),
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                .put(IndexMetadata.SETTING_INGESTION_SOURCE_POINTER_INIT_RESET, "earliest")  
                SequenceNumbers.NO_OPS_PERFORMED,
        if (!Lucene.indexExists(store.directory())) {
import org.opensearch.action.admin.indices.streamingingestion.state.ShardIngestionState;
    public void setUp() throws Exception {  
        return ingestionEngine;  
            store.associateIndexWithNewTranslog(translogUuid);  
        ShardIngestionState resumedIngestionState = ingestionEngine.getIngestionState();
    }  
import static org.mockito.Mockito.spy;  
            config,
    }
    private void publishData(String message) {
        Map<String, String> commitData = ingestionEngine.commitDataAsMap();
    protected IndexSettings newIndexSettings() {  
    public void testPushAPIFailures() {  
        AtomicLong globalCheckpoint,  
    }
import org.junit.After;
    @After  
        assertEquals(false, initialIngestionState.isPollerPaused());
            assertEquals("Simulated IOException", e.getCause().getMessage());
        clusterApplierService = mock(ClusterApplierService.class);  
import org.opensearch.common.settings.Settings;
import org.opensearch.test.IndexSettingsModule;  
    @Override
    private boolean resultsFound(Engine engine, int numDocs) {
 * The OpenSearch Contributors require contributions made to  
        // flush  
    public void testIngestionStateUpdate() {
        ingestionEngine = buildIngestionEngine(globalCheckpoint, ingestionEngineStore, indexSettings, clusterApplierService);
        // flush  
    }
        messages.add(message.getBytes(StandardCharsets.UTF_8));  
                .build()
import org.opensearch.indices.replication.common.ReplicationType;
        // create some initial messages
            mock(IngestService.class),
        assertTrue(ingestionEngine.shouldPeriodicallyFlush());  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(ingestionEngine.shouldPeriodicallyFlush());
        waitForResults(ingestionEngine, 2);  
import org.junit.Before;  
        );  
            new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED),  
            createTempDir(),  
                .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "fake")
import org.opensearch.index.IndexSettings;  
        // Stands in for the remote store case, where a copy commits SegmentInfos downloaded from another copy:  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.mapper.DocumentMapperForType;
    public void testCreateEngine() throws IOException {  
    // the messages of the stream to ingest from
        );
        testStore.createEmpty(config.getIndexSettings().getIndexVersionCreated().luceneVersion);
            engineConfig,  
        config = config(config, () -> new DocumentMapperForType(mapperService.documentMapper(), null), clusterApplierService);
import org.opensearch.cluster.ClusterState;  
        when(clusterApplierService.state()).thenReturn(ClusterState.EMPTY_STATE);
import java.util.List;
        ingestionEngine.flush(false, true);
            NoMergePolicy.INSTANCE,
        // associateIndexWithNewTranslog rewrites only TRANSLOG_UUID in the existing commit data.
            ingestionEngineStore.close();  
        ingestionEngine.updateIngestionSettings(IngestionSettings.builder().setIsPaused(true).build());
        FakeIngestionSource.FakeIngestionConsumerFactory consumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);  
        // overwrite the config with ingestion engine settings  
import java.util.concurrent.atomic.AtomicLong;
        assertThrows(IngestionEngineException.class, () -> ingestionEngine.delete(deleteMock));
    private Store ingestionEngineStore;  
        // Wait for messages to be ingested first so batchStartPointer is set
        ingestionEngine.updateIngestionSettings(
    }
        publishData("{\"_id\":\"3\",\"_source\":{\"name\":\"john\", \"age\": 30}}");  
            ingestionEngine.close();  
import static org.awaitility.Awaitility.await;  
                primaryTerm.get()
        ingestionEngine.flush(false, true);
        waitForResults(engine, 2);
        ingestionEngine = buildIngestionEngine(new AtomicLong(0), ingestionEngineStore, indexSettings, clusterApplierService);
    private List<byte[]> messages;  
            null,  
import org.mockito.Mockito;
 */  
        ingestionEngine = buildIngestionEngine(
        IngestService ingestService = mock(IngestService.class);
        // resume ingestion with offset reset  
            assertEquals("failed to create engine", e.getMessage());
        // overwrite the config with ingestion engine settings  
        // Flush again
        publishData("{\"_id\":\"6\",\"_source\":{\"name\":\"jane\", \"age\": 25}}");
        // flush
        ingestionEngine.close();
    }
        // Should not flush immediately after commit since pointer hasn't changed
        ingestionEngineStore = createStore(indexSettings, newDirectory());
        return IndexSettingsModule.newIndexSettings(
        PollingIngestStats stats = ingestionEngine.pollingIngestStats();  
        MapperService mapperService = createMapperService(mapping);
        IndexSettings settings,
        // Should not flush immediately after commit
        }
        engineConfig = config(engineConfig, () -> new DocumentMapperForType(mapperService.documentMapper(), null), clusterApplierService);  
        }
    private IngestionEngine ingestionEngine;
        }
    private IndexSettings indexSettings;
        publishData("{\"_id\":\"3\",\"_source\":{\"name\":\"john\", \"age\": 30}}");
    }
        // wait for the engine to ingest all messages
    }
        // next store call in InternalEngine's constructor, so it fails engine creation the same way.  
        ingestionEngine.flush(false, true);  
        engine.close();
            primaryTerm.get()  
    }  
        super.setUp();
        ShardIngestionState ingestionState = ingestionEngine.getIngestionState();  
        // validate ingestion state on successful engine creation
import org.opensearch.indices.pollingingest.StreamPoller;
            null,
import java.util.ArrayList;
        engine.refresh("index");
import org.opensearch.cluster.service.ClusterApplierService;
        ShardIngestionState initialIngestionState = ingestionEngine.getIngestionState();  
        doThrow(new IOException("Simulated IOException")).when(mockStore).readLastCommittedSegmentsInfo();
    public void testShouldPeriodicallyFlush() throws IOException {
            final String translogUuid = Translog.createEmptyTranslog(  
        publishData("{\"_id\":\"4\",\"_source\":{\"name\":\"jane\", \"age\": 25}}");
import java.util.Map;  
        publishData("{\"_id\":\"2\",\"_source\":{\"name\":\"bob\", \"age\": 24}}");
    }  
 *
import org.junit.Assert;
        ingestionEngine.start();
        waitForResults(ingestionEngine, 4);
            engineConfig = config(settings, store, createTempDir(), NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get);
    public void testCreationFailure() throws IOException {
/*  
        publishData("{\"_id\":\"4\",\"_source\":{\"name\":\"jane\", \"age\": 25}}");
        IngestionEngine ingestionEngine = new IngestionEngine(
        ingestionEngine.close();
        // wait for the engine to ingest all messages
        Store testStore = createStore(indexSettings, newDirectory());
public class IngestionEngineTests extends EngineTestCase {  
        assertEquals("DROP", ingestionState.getErrorPolicy());
            config.getTranslogConfig().getTranslogPath(),  
        // the commiit data is the start of the current batch
import org.opensearch.indices.pollingingest.PollingIngestStats;
        engineConfig = config(engineConfig, () -> new DocumentMapperForType(mapperService.documentMapper(), null), clusterApplierService);  
        );
    ) throws IOException {
        waitForResults(ingestionEngine, 4);  
            assertTrue(e.getCause() instanceof IOException);  
        testStore.associateIndexWithNewTranslog(translogUuid);
        Engine.Delete deleteMock = Mockito.mock(Engine.Delete.class);  
            IngestionSettings.builder().setIsPaused(false).setResetState(StreamPoller.ResetState.RESET_BY_OFFSET).setResetValue("1").build()
        // pause ingestion
import static org.mockito.Mockito.when;
    public void tearDown() throws Exception {
        if (engineConfig == null) {  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
        if (ingestionEngineStore != null) {
        Assert.assertEquals("1", commitData.get(StreamPoller.BATCH_START));  
            clusterApplierService  
import org.opensearch.index.seqno.SequenceNumbers;  
        assertEquals(false, resumedIngestionState.isPollerPaused());
import org.opensearch.index.store.Store;
        await().atMost(3, TimeUnit.SECONDS).untilAsserted(() -> { Assert.assertTrue(resultsFound(engine, numDocs)); });
}
        assertThrows(IngestionEngineException.class, () -> ingestionEngine.index(indexMock));
import java.io.IOException;
            indexSettings,
        );
            XContentIngestionPayloadDecoder.Factory.INSTANCE  
    }
        engineConfig = null;  
        waitForResults(ingestionEngine, 2);  
        MapperService mapperService = createMapperService(mapping);
        try {
    @Before
        waitForResults(ingestionEngine, 4);
        final String translogUuid = Translog.createEmptyTranslog(
import static org.mockito.Mockito.mock;
            ingestionEngineStore,
        FakeIngestionSource.FakeIngestionConsumerFactory consumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);  
            );
    public void testRecovery() throws IOException {
        Engine.Index indexMock = Mockito.mock(Engine.Index.class);
import org.opensearch.index.translog.Translog;
            Settings.builder()  
        ingestionEngineStore.associateIndexWithNewTranslog(UUIDs.randomBase64UUID());  
            indexSettings,
        waitForResults(ingestionEngine, 2);
        ClusterApplierService clusterApplierService  
        Store mockStore = spy(store);
            fail("Expected EngineException to be thrown");  
        indexSettings = newIndexSettings();
        IngestionEngine engine = new IngestionEngine(  
