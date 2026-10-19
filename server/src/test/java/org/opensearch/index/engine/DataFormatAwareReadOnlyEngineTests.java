    public void testCloseIsIdempotent() throws IOException {
        String historyUUID = UUID.randomUUID().toString();
            builder.eventListener(listener);
import java.util.UUID;
            engine.close();
 * this file be licensed under the Apache-2.0 license or a
                            exceptions.add(e);  
    }
            false  
            .primaryTermSupplier(primaryTerm::get)  
        DataFormatRegistry registry = createMockRegistry();
    public void testTranslogSnapshotIsAlwaysEmpty() throws IOException {  
            .indexSettings(indexSettings)
        try {
            DataFormatAwareEngine.DataFormatAwareReader firstReader = null;
                        try {
        EngineConfig config = buildConfig(store, warmIndexSettings(), null);  
                        firstReader = reader;
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, "-1");  
            .externalRefreshListener(List.of())
            // After release, snapshot is still accessible and stable
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)  
        bootstrapStoreWithMetadata(store, translogUUID, historyUUID);
        Engine.GetResult result = engine.getById(get, (source, scope) -> null);
        RecordingCommitter(Store store) throws IOException {  
        }
import java.util.concurrent.atomic.AtomicLong;  
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())  
                DataFormatAwareEngine.DataFormatAwareReader expected = readersObserved.get(0);  
        }  
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, get));
    public void testAcquireReaderCloseIsNoOpSnapshotRemainsValid() throws IOException {
        Path translogPath = createTempDir().resolve("translog");  
import java.util.concurrent.TimeUnit;  
            assertEquals(
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
            for (int i = 0; i < threadCount; i++) {
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)  
        Indexer engine = factory.createIndexer(config);
        }
            .store(store)  
    @Override  
        return new DataFormatAwareReadOnlyEngine(buildConfig(store, indexSettings, listener));  
        @Override
            long firstSnapshotId = -1;  
import java.util.concurrent.atomic.AtomicInteger;
            store.close();  
        super.setUp();  
        }
            .mergePolicy(org.apache.lucene.index.NoMergePolicy.INSTANCE)
            public List<CatalogSnapshot> listCommittedSnapshots() {  
        }
            translogPath,
            .primaryTermSupplier(primaryTerm::get)
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine(store, warmIndexSettings(), listener);
import org.opensearch.test.DummyShardLock;
    }
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> snapshot = engine.acquireSafeCatalogSnapshot()) {
        return builder.build();  
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);  
    public void setUp() throws Exception {
        return IndexSettingsModule.newIndexSettings(
        userData.put(Translog.TRANSLOG_UUID_KEY, UUID.randomUUID().toString());
            assertNotNull("translog UUID must be non-null", translogUUID);  
    public void testWriteRejection() throws IOException {  
import java.util.concurrent.atomic.AtomicBoolean;
                store.directory(),  
        when(provider.getById(any(), any(), any(), any())).thenReturn(  
        }
            }
import static org.hamcrest.Matchers.instanceOf;  
        return result.exists() ? ((DocumentLookupResult.PreMaterialized) result).lookup() : DocumentLookupResult.notFound(get.id());  
                    userData  
        try (DataFormatAwareReadOnlyEngine engine = new DataFormatAwareReadOnlyEngine(config, provider)) {
        );  
            assertNotNull("commitStats must carry a commit id", commitStats.getId());
        engine.close();
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
            .store(hotStore)  
        engine.close();
    public void testMultipleConcurrentReadQueriesAllGetValidSnapshot() throws Exception {  
        // All must get a non-null catalogSnapshot and the same reader object.
            .committerFactory(committerFactory)
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
    public void testAcquireReaderReturnsNonNull() throws IOException {
            .tombstoneDocSupplier(tombstoneDocSupplier())  
            try (
            executor.shutdown();
            int before = recordingCommitter.getCommitStatsCalls.get();
            .build();
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {  
                        } finally {  
        TranslogConfig translogConfig = new TranslogConfig(shardId, translogPath, hotSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false);  
            assertEquals(0, engine.translogManager().getTranslogStats().getUncommittedOperations());
            getCommitStatsCalls.incrementAndGet();  
                            }
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> r2 = engine.acquireReader()
                buildConfig(store, warmIndexSettings(), null, config -> recordingCommitter)
    // ---------- Engine Flip Integration Tests (DataFormatAwareIndexerFactory) ----------
            new DocumentLookupResult("1", 5L, true, null, 0L, 1L, Map.of(), Map.of())  
        CommitterFactory committerFactory
    private EngineConfig buildReplicaConfig() throws IOException {
            }
    ) {  
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);  
            .primaryTermSupplier(primaryTerm::get)
import org.opensearch.index.engine.exec.Segment;  
        assertTrue("onCommit with empty list should return empty", policy.onCommit(List.of()).isEmpty());
        ) {
            .committerFactory(committerFactory)  
            engine.ensureOpen();
            shardPath,
            }
        IndexSettings indexSettings,  
    }
        };
        return new DataFormatAwareReadOnlyEngine(config, provider);
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
    }  
    /** commitStats() must honor engine lifecycle — after close it must throw, not read the store. */
            .externalRefreshListener(List.of())
                                readersObserved.add(reader);  
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
    public void testAcquireReaderMultipleTimesReturnsSameReaderObject() throws IOException {
                return List.of(snapshot);  
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, get));  
        bootstrapStoreWithMetadata(hotStore, translogUUID, historyUUID);
                for (DataFormatAwareEngine.DataFormatAwareReader r : readersObserved) {
    /** Writes a Lucene commit so the engine's store bootstrap finds valid userData. */
            Engine.Get get = realtimeGet("1");
                                DataFormatAwareEngine.DataFormatAwareReader reader = (DataFormatAwareEngine.DataFormatAwareReader) gated
            .mergePolicy(NoMergePolicy.INSTANCE)
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
        CommitterFactory committerFactory = config -> new InMemoryCommitter(replicaStore);  
                    assertSame("all concurrent queries must get the same reader object", expected, r);
    }  
        try {
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
        // The permanentSnapshotRef is acquired at construction and stored in the reader —  
        DataFormatAwareIndexerFactory factory = new DataFormatAwareIndexerFactory();
        final AtomicInteger getCommitStatsCalls = new AtomicInteger();  
    }  
            .tombstoneDocSupplier(tombstoneDocSupplier())  
        try (
            engine.ensureOpen();
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
    public void testNoOpTranslog() throws IOException {
        // return the same underlying DataFormatAwareReader instance.  
        if (listener != null) {  
        String translogUUID = UUID.randomUUID().toString();  
        assertTrue("onInit with empty list should return empty", policy.onInit(List.of()).isEmpty());  
        }
        }
            executor.awaitTermination(10, TimeUnit.SECONDS);
            r1.close();
            // Apply a replication snapshot  
        List<Exception> exceptions = new ArrayList<>();
            dir,
            expectThrows(AlreadyClosedException.class, engine::ensureOpen);
            assertNotNull("commitStats must not be null", first);
                    0L,
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
    }
        String translogUUID = UUID.randomUUID().toString();  
    }
            .flushMergesAfter(TimeValue.timeValueMinutes(5))  
     * calls do no I/O.  
                snapshot.setLastCommitInfo("segments_1", 1L, 0L);
                executor.shutdown();
        }  
        Engine.EventListener listener,
        engine.failEngine("test-failure", new IOException("simulated"));  
            assertNotNull(engine.translogManager());
            assertEquals(engine.getProcessedLocalCheckpoint(), engine.getPersistedLocalCheckpoint());
            assertNotNull(heldRef.get());
            warmIndexSettings(),
            engine.close();
                    }
        String historyUUID = UUID.randomUUID().toString();  
                    executor.submit(() -> {
import org.opensearch.plugins.SearchBackEndPlugin;  
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);  
        when(provider.getById(any(), any(), any(), any())).thenReturn(
        TranslogConfig translogConfig = new TranslogConfig(
            expectThrows(UnsupportedOperationException.class, () -> engine.noOp(null));
        }  
 */  
            engine.finalizeReplication(incoming);
            assertEquals(0, engine.translogManager().getTranslogStats().getUncommittedOperations());
            .primaryTermSupplier(primaryTerm::get)
    private DataformatAwareCatalogSnapshot buildReplicationSnapshot(long id, long gen, long maxSeqNo, String historyUUID) {  
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
    }
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.plugins.DocumentLookupProvider;
        );
        // callers using reader.catalogSnapshot() (e.g. LuceneAnalyticsBackendPlugin) must get a valid snapshot.
            new DataFormatAwareReadOnlyEngine.NoOpCatalogSnapshotDeletionPolicy();
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> afterRef = engine.acquireSafeCatalogSnapshot()) {  
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
                    DataFormatAwareEngine.DataFormatAwareReader reader = (DataFormatAwareEngine.DataFormatAwareReader) gated.get();
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
    }
        );  
                    org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> gated = engine
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(maxSeqNo));  
        }
import org.apache.lucene.index.NoMergePolicy;  
                    .acquireReader()  
    public void testCreateEngine() throws IOException {
    }
        EngineConfig.Builder builder = new EngineConfig.Builder().shardId(shardId)
            assertNotNull(engine.config());
            // Acquire a snapshot reference and verify it is non-null
            }
    public void testOperationsAfterCloseThrowAlreadyClosed() throws IOException {
            }  
    }
            assertTrue("doc should be found", result.exists());
import org.opensearch.common.util.BigArrays;
            gen,
                    if (firstReader == null) {  
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        shardId = new ShardId(new Index("test", "_na_"), 0);
    private IndexSettings warmIndexSettings() {
                executor.awaitTermination(10, TimeUnit.SECONDS);  
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> reader = engine
                                assertNotNull("concurrent reader must be non-null", reader);
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngineWithProvider(provider)) {
            // from memory on every subsequent call — no further store reads.  
            // Engine should still be open  
            assertEquals("commitStats must report the committed generation", expectedGeneration, commitStats.getGeneration());  
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getProcessedLocalCheckpoint());
        assertTrue("event listener must be notified on failEngine", listenerCalled.get());
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngineWithProvider(provider)) {  
            .externalRefreshListener(List.of())
        TranslogConfig translogConfig = new TranslogConfig(
        return buildConfig(store, indexSettings, listener, config -> new InMemoryCommitter(store));
    }
                    } else {  
            DataformatAwareCatalogSnapshot incoming = buildReplicationSnapshot(1L, 1L, 10L, UUID.randomUUID().toString());
        );  
        }
        IndexSettings hotSettings = nonWarmIndexSettings();  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
 * Unit tests for {@link DataFormatAwareReadOnlyEngine}.  
            assertSame("engine must return the committer's cached CommitStats instance unchanged", first, second);
        String historyUUID = UUID.randomUUID().toString();
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            // Engine must still be open after all concurrent reads  
    }
    /** commitStats() must surface the committer's actual commit point (correct generation). */  
        throws IOException {
            assertTrue("no exceptions expected from concurrent close, got: " + exceptions, exceptions.isEmpty());
        );
            )  
            IndexWriter writer = new IndexWriter(
    public void testAcquireSafeCatalogSnapshotReturnsNonNull() throws IOException {  
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();
            // Engine must still be open after all queries
            // Sync is a no-op (does not throw)
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
        // Second close must be a no-op, not throw.
            new DummyShardLock(shardId),  
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)  
        bootstrapStoreWithMetadata(store, translogUUID, historyUUID);
                .build()
    public void testFactoryCreatesWritableEngineForHotPrimary() throws IOException {  
        try {
                        engine.close();  
}
            ) {
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
    }
            translogPath,  
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
        List<CatalogSnapshot> initResult = policy.onInit(List.of(mock(CatalogSnapshot.class), mock(CatalogSnapshot.class)));
            new DocumentLookupResult("1", 1L, true, null, 5L, 1L, Map.of(), Map.of())
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();  
    }  
            gen,
    public void tearDown() throws Exception {
     * exact instance it returns is propagated unchanged through the engine.
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getPersistedLocalCheckpoint());
    private static DocumentLookupResult getByIdLookup(DataFormatAwareReadOnlyEngine engine, Engine.Get get) throws IOException {
        bootstrapStoreWithMetadata(store, translogUUID, historyUUID);
            try (
        } finally {
            terminate(threadPool);
    public void testGetByIdReturnsDocWhenNoConflict() throws IOException {
        DataFormatRegistry registry = createMockRegistry();
            .translogConfig(translogConfig)
            BigArrays.NON_RECYCLING_INSTANCE,
                            try (
    }
    }
            }  
            .mergePolicy(NoMergePolicy.INSTANCE)
import org.apache.lucene.store.Directory;
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
                assertNotNull("acquireReader must return a non-null reader after replication", reader.get());  
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);  
        bootstrapStoreWithMetadata(replicaStore, uuid, UUID.randomUUID().toString());
            long expectedGeneration = store.readLastCommittedSegmentsInfo().getGeneration();  
        String historyUUID = UUID.randomUUID().toString();  
import java.io.IOException;
            )  
package org.opensearch.index.engine;
    }
 * Exercises constructor, write rejection, no-op translog, flush, close, failEngine,
            for (int i = 0; i < queryCount; i++) {
        }  
                        synchronized (exceptions) {
import java.util.concurrent.ExecutorService;
        CommitterFactory committerFactory = config -> new InMemoryCommitter(hotStore);
 *
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {  
            CommitStats first = engine.commitStats();
                                    .get();  
    }
            engine.close();
        Store replicaStore = createStore(replicaSettings);
            .build();
    public void testGetByIdReturnsNotFoundOnEmptyCatalog() throws IOException {
            .build();
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
            // Zero uncommitted operations  
                DataFormatAwareEngine.DataFormatAwareReader reader = (DataFormatAwareEngine.DataFormatAwareReader) gated.get();
            shardId,
    }  
            Engine.Get get = realtimeGet("1").version(3L).versionType(org.opensearch.index.VersionType.EXTERNAL);  
        return createReadOnlyEngine(store, warmIndexSettings(), null);
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, get));
            config.getStore().close();
                    0L,  
        int threadCount = randomIntBetween(2, 10);
        public CommitStats getCommitStats() {
        }  
            indexSettings,
    }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
                DataFormatAwareEngine.DataFormatAwareReader reader = (DataFormatAwareEngine.DataFormatAwareReader) r2.get();  
import java.util.concurrent.Executors;
            CommitStats second = engine.commitStats();
        // Regression test: DataFormatAwareReader.catalogSnapshot() must not NPE.
    }
        }  
    }  
            .tombstoneDocSupplier(tombstoneDocSupplier())
import org.opensearch.index.engine.exec.Indexer;
        }
    private MockDataFormatPlugin mockPlugin;
        }  
    }
import org.opensearch.index.store.Store;
            // acquireReader should still work after replication
import org.opensearch.test.IndexSettingsModule;
            return cached;
    @Override
    public void testFactoryCreatesNRTEngineForReplica() throws IOException {  
        }
        // onCommit should return empty list (nothing to delete)
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();  
            CommitStats commitStats = engine.commitStats();
        if (historyUUID != null) {
            config.getStore().close();
            .indexSettings(hotSettings)
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
            long heldId = heldRef.get().getId();
        DataFormatRegistry registry = createMockRegistry();  
            indexSettings,
        }
            try (
                Map<String, String> userData = new HashMap<>();
import org.opensearch.common.lucene.Lucene;
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);  
     * each call. Proven two ways: the committer's getCommitStats() is invoked once per call, and the
        }
            int threadCount = randomIntBetween(5, 15);
        Indexer engine = factory.createIndexer(config);  
            assertFalse("read-only primary engine must not identify as replica", engine.isReplicaIndexer());
            userData
            DocumentLookupResult result = getByIdLookup(engine, get);  
            .dataFormatRegistry(registry)
    }  
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> reader = engine  
            engine.translogManager().syncTranslog();
                                exceptions.add(e);
    }  
            .committerFactory(committerFactory)
            super(store);
            .flushMergesAfter(TimeValue.timeValueMinutes(5))  
        Path translogPath = createTempDir().resolve("translog");
            // Engine should fabricate a historyUUID when not in commit (same as NRT engine)  
import static org.mockito.Mockito.mock;
                .build()  
        mockPlugin = MockDataFormatPlugin.of(mockDataFormat);
import org.opensearch.index.translog.Translog;
            .translogConfig(translogConfig)  
        );
                            reader.catalogSnapshot().getId()
        return new DataFormatRegistry(pluginsService);  
    public void testFailEngine() throws IOException {  
        String translogUUID = UUID.randomUUID().toString();
        } finally {  
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> gated = engine
/**
     * commitStats() must delegate to the committer's (cached) stats and NOT re-read the store on  
        }  
            // UUID is valid (non-null, non-empty)
import org.opensearch.index.engine.exec.commit.CommitterFactory;
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {  
    }
                );
            assertEquals(0L, engine.getWritingBytes());
            }
        String translogUUID = UUID.randomUUID().toString();
            assertEquals(1L, result.version());
            heldRef.close();  
    public void testCommitStatsAfterCloseThrowsAlreadyClosed() throws IOException {  
import org.opensearch.index.engine.exec.DataFormatAwareIndexerFactory;
import static org.mockito.Mockito.when;  
            assertNotNull(commitStats);
import org.apache.lucene.store.AlreadyClosedException;
    }
            .indexSettings(warmIndexSettings())
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            ExecutorService executor = Executors.newFixedThreadPool(threadCount);
            .dataFormatRegistry(registry)  
import org.opensearch.index.seqno.SequenceNumbers;
    private static class RecordingCommitter extends InMemoryCommitter {
import org.apache.lucene.index.IndexWriter;
            expectThrows(UnsupportedOperationException.class, () -> getByIdLookup(engine, get));  
            try {
    }
        return (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
            "test",  
                userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));  
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;  
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
        return new Engine.Get(true, true, id, new org.apache.lucene.index.Term("_id", org.opensearch.index.mapper.Uid.encodeId(id)));
        );  
        CountDownLatch startLatch = new CountDownLatch(1);
                    .acquireReader();
        DataFormatAwareIndexerFactory factory = new DataFormatAwareIndexerFactory();  
            assertThat(engine, instanceOf(DataFormatAwareNRTReplicationEngine.class));
    public void testCloseReleasesResources() throws IOException {
        try {
            engine.flush(true, false);
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
    }
            DocumentLookupResult result = getByIdLookup(engine, get);  
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {  
                });
            .readOnlyReplica(false)  
                    try {
                executor.submit(() -> {  
                assertNotNull(
        EngineConfig config = buildHotPrimaryConfig();
    // ---------- Concurrent Close Tests ----------  
                ) {  
import org.opensearch.index.seqno.RetentionLeases;  
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
            List.of(new MockSearchBackEndPlugin(List.of(mockDataFormat.name())))
    }
                            "query " + i + ": snapshot ID must be stable across all queries",  
import org.opensearch.index.IndexSettings;  
        }  
        } finally {
        }  
            .readOnlyReplica(false);
            List<Exception> exceptions = new ArrayList<>();
            // flush is always a no-op on read-only engine (does not throw, does not commit)
    public void testCommitStatsDelegatesToCommitter() throws IOException {
            .store(store)
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngineWithoutHistoryUUID()) {
import org.opensearch.cluster.metadata.IndexMetadata;
            shardId,  
            "",
    private DataFormatAwareReadOnlyEngine createReadOnlyEngineWithProvider(org.opensearch.plugins.DocumentLookupProvider provider)
     */
        expectThrows(AlreadyClosedException.class, engine::acquireSafeCatalogSnapshot);  
                // All threads must have seen the same reader object
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        bootstrapStoreWithMetadata(store, translogUUID, historyUUID);
    private ThreadPool threadPool;  
    public void testCheckpointAccessorsOnFreshEngine() throws IOException {
            CountDownLatch startLatch = new CountDownLatch(1);
            Engine.Get get = realtimeGet("1").setIfSeqNo(99L).setIfPrimaryTerm(1L);
 * compatible open source license.
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
     * same cached instance — mirroring the production committer, which caches SegmentInfos so stats
        }
    public void testMultipleSequentialReadQueriesAllGetValidSnapshot() throws IOException {  
        }
                        startLatch.await();
                for (int i = 0; i < threadCount; i++) {  
            .internalRefreshListener(List.of())
            assertFalse(engine.shouldPeriodicallyFlush());
            .internalRefreshListener(List.of())  
                .build()
import java.util.Set;
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
                        );  
    private void bootstrapStoreWithMetadata(Store store, String translogUUID, String historyUUID) throws IOException {  
                }
            "test",
        String translogUUID = UUID.randomUUID().toString();
        }  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        EngineConfig config = buildReplicaConfig();
        }  
            .tombstoneDocSupplier(tombstoneDocSupplier())
     * Test committer that records how many times getCommitStats() is called and always returns the
    }  
                assertSame("all acquireReader() calls must return the same reader object", r1.get(), r2.get());
        String translogUUID = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            Map<String, String> commitData = new HashMap<>();
                    assertNotNull("query " + i + ": reader must be non-null", reader);  
        );
            .dataFormatRegistry(registry)
        threadPool = new TestThreadPool(getClass().getName());
            shardId,
            }
        return IndexSettingsModule.newIndexSettings(
            "test",
    }
            .mergePolicy(NoMergePolicy.INSTANCE)  
                        doneLatch.countDown();  
                                assertNotNull("concurrent catalogSnapshot must be non-null", reader.catalogSnapshot());
    public void testGetByIdThrowsWhenNoProvider() throws IOException {  
        }
            assertFalse("translog UUID must not be empty", translogUUID.isEmpty());
    public void testGetByIdThrowsOnPrimaryTermMismatch() throws IOException {
import static org.mockito.ArgumentMatchers.any;
        // The snapshot never changes for read-only engine — all acquireReader() calls
                    assertNotNull("query " + i + ": catalogSnapshot must be non-null", reader.catalogSnapshot());
    public void testGetByIdThrowsVersionConflictForReads() throws IOException {  
        );  
            assertNotNull("historyUUID must be read from commit", historyUUID);
        Engine.EventListener listener = new Engine.EventListener() {
    }  
import org.opensearch.index.translog.TranslogConfig;  
import org.opensearch.index.store.FsDirectoryFactory;  
        return new DataFormatAwareReadOnlyEngine(buildConfig(store, warmIndexSettings(), null));  
            .internalRefreshListener(List.of())
            gen,
        when(provider.getById(any(), any(), any(), any())).thenReturn(
        throws IOException {
     */  
import java.util.List;
        ShardPath shardPath = new ShardPath(false, path, path, shardId);
            assertFalse("should return not found when catalog has no segments", result.exists());
    }  
        ) {
import org.opensearch.Version;  
        String historyUUID = UUID.randomUUID().toString();
import java.nio.file.Path;
     *  DFA engines ignore the searcher factory, so a no-op factory is supplied. */  
            .store(replicaStore)
    public void testIsReplicaIndexerReturnsFalse() throws IOException {
            new DocumentLookupResult("1", 1L, true, null, 0L, 1L, Map.of(), Map.of())
        IndexSettings replicaSettings = IndexSettingsModule.newIndexSettings(  
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> r1 = engine  
        PluginsService pluginsService = mock(PluginsService.class);
    private AtomicLong primaryTerm;  
            .internalRefreshListener(List.of())
        primaryTerm = new AtomicLong(randomLongBetween(1, Long.MAX_VALUE));
            );  
                assertNotNull("acquireReader must return a non-null reader", reader.get());
    }
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
            writer.commit();
                    } finally {
        Store hotStore = createStore(hotSettings);
    }  
            List<DataFormatAwareEngine.DataFormatAwareReader> readersObserved = new java.util.concurrent.CopyOnWriteArrayList<>();
    private DataFormatRegistry createMockRegistry() {  
    // ---------- Checkpoint Tests ----------
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;
    private EngineConfig buildConfig(
            .externalRefreshListener(List.of())  
    public void testAcquireSafeCatalogSnapshotPreventsCleanupWhileHeld() throws IOException {  
                    -1L,
            ) {
    public void testConstantReturns() throws IOException {  
            BigArrays.NON_RECYCLING_INSTANCE,
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testCreateEngineWithoutHistoryUUID() throws IOException {
                    reader.catalogSnapshot()
            "",
            }
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            ) {
    }
            try (  
        }
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
            String historyUUID = engine.getHistoryUUID();
            assertEquals(0L, engine.translogManager().getTranslogStats().getUncommittedSizeInBytes());
            assertNotNull("historyUUID must be assigned", engine.getHistoryUUID());  
    private IndexSettings nonWarmIndexSettings() {  
            Settings.builder()  
            Engine.Get get = realtimeGet("1");
        }  
        engine.close();  
        assertTrue("onCommit should return empty list", commitResult.isEmpty());  
import org.opensearch.threadpool.ThreadPool;
        // Sequential read queries: each acquireReader() returns a valid reader with non-null catalogSnapshot.
 * The OpenSearch Contributors require contributions made to  
        assertTrue("onInit should return empty list", initResult.isEmpty());
                before + 2,
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false)  
                    });  
        };
    }  
 * SPDX-License-Identifier: Apache-2.0
            // Persisted == processed for this engine  
    public void testConcurrentCloseExecutesExactlyOnce() throws Exception {
            assertFalse("fabricated historyUUID must not be empty", engine.getHistoryUUID().isEmpty());
/*  
                                    engine.acquireReader()  
                commitData.put(Engine.HISTORY_UUID_KEY, historyUUID);
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> currentRef = engine.acquireSafeCatalogSnapshot()) {
 * and constant-return methods for the warm read-only primary engine.
    public void testGetByIdThrowsOnSeqNoMismatch() throws IOException {
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> r2 = engine.acquireReader()  
                    }
                            startLatch.await();  
import org.opensearch.test.OpenSearchTestCase;  
            .translogConfig(translogConfig)
    private Store createStore(IndexSettings indexSettings) throws IOException {
        super.tearDown();
import org.opensearch.core.index.Index;  
            .threadPool(threadPool)
    public void testNoOpDeletionPolicyNeverDeletesSnapshots() {
    private DataFormatAwareReadOnlyEngine createReadOnlyEngine(Store store, IndexSettings indexSettings, Engine.EventListener listener)
                assertEquals("must have observed N reader instances", threadCount, readersObserved.size());  
                        assertSame("query " + i + ": must be same reader object as query 0", firstReader, reader);
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
import org.opensearch.index.shard.ShardPath;
    }  
            assertThat(engine, instanceOf(DataFormatAwareEngine.class));
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;  
            } finally {
    public void testFactoryCreatesReadOnlyEngineForWarmPrimary() throws IOException {
    /**  
            CountDownLatch doneLatch = new CountDownLatch(threadCount);  
        }
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(  
                    .acquireReader()
public class DataFormatAwareReadOnlyEngineTests extends OpenSearchTestCase {
    }
                        }
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngineWithProvider(provider)) {
        Path translogPath = createTempDir().resolve("translog");  
                assertNotNull("engine must still serve reads after prior GatedCloseable.close()", r2.get());
import org.opensearch.common.settings.Settings;  
        bootstrapStoreWithMetadata(store, translogUUID, historyUUID);
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
                            firstSnapshotId,
                        firstSnapshotId = reader.catalogSnapshot().getId();
            engine.flush();
                    } catch (Exception e) {
            engine.flush(false, true);  
 */  
        // Empty input should also work
        return buildConfig(store, warmIndexSettings(), null);
            int queryCount = randomIntBetween(5, 20);
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(mockPlugin));
            org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> heldRef = engine.acquireSafeCatalogSnapshot();  
            shardId,  
    }  
            ) {  
        DataFormatRegistry registry = createMockRegistry();
                assertEquals("snapshot ID must be stable after ref release", heldId, afterRef.get().getId());
        engine.close();
            }  
                    .acquireReader()
            replicaSettings,  
                assertTrue("all threads must complete within timeout", doneLatch.await(30, TimeUnit.SECONDS));
            new FsDirectoryFactory()  
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
            // Snapshot ID is stable (warm primary is static — no new snapshots arrive)
    }
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();  
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {  
            .dataFormatRegistry(registry)
    }  
            // Build the cached value once via the base (store-reading) implementation, then serve it
            engine.ensureOpen();
                assertTrue("no exceptions from concurrent readers, got: " + exceptions, exceptions.isEmpty());
                            synchronized (exceptions) {  
            assertEquals(0L, engine.getHeapBytesUsed());  
import java.util.HashMap;
        Store store,
        String translogUUID = UUID.randomUUID().toString();  
            .readOnlyReplica(false)  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")  
        Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));  
        }  
        engine.flushAndClose();
    }
        } finally {  
                assertNotNull("catalogSnapshot must still be valid after prior close()", reader.catalogSnapshot());
    // ---------- commitStats Tests ----------  
        expectThrows(AlreadyClosedException.class, engine::commitStats);  
import org.opensearch.threadpool.TestThreadPool;
            @Override
        try {
            try (
            .committerFactory(committerFactory)
    private EngineConfig buildConfig(Store store, IndexSettings indexSettings, Engine.EventListener listener) {  
import java.util.Map;  
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
                        .acquireReader()
        when(provider.getById(any(), any(), any(), any())).thenReturn(
    private EngineConfig buildWarmPrimaryConfig() throws IOException {
        CommitterFactory committerFactory = config -> new InMemoryCommitter(store) {
    // ---------- Snapshot Ref-Counting Tests ----------
                userData.put(Engine.HISTORY_UUID_KEY, UUID.randomUUID().toString());
            }
                        } catch (Exception e) {
                DataformatAwareCatalogSnapshot snapshot = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(  
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();  
        );
    }
        TranslogConfig translogConfig = new TranslogConfig(  
            expectThrows(UnsupportedOperationException.class, () -> engine.delete(null));  
        mockDataFormat = new MockDataFormat("composite", 100L, Set.of());  
        expectThrows(AlreadyClosedException.class, engine::acquireReader);
            false
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
    }  
    private DataFormatAwareReadOnlyEngine createReadOnlyEngineWithoutHistoryUUID() throws IOException {  
            @Override  
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
    }
            false
        );
import org.opensearch.common.unit.TimeValue;
            this.cached = super.getCommitStats();
                );
                        }
            new DocumentLookupResult("1", 1L, true, null, 5L, 1L, Map.of(), Map.of())
            // Acquire and immediately close  
        return new EngineConfig.Builder().shardId(shardId)  
            Settings.builder()
    public void testFlushAndClose() throws IOException {  
            writer.setLiveCommitData(commitData.entrySet());
    private EngineConfig buildHotPrimaryConfig() throws IOException {
import org.apache.lucene.index.IndexWriterConfig;
            expectThrows(UnsupportedOperationException.class, () -> engine.index(null));
    }
        }  
            .indexSettings(replicaSettings)  
        }
            .threadPool(threadPool)
            startLatch.countDown();
            .threadPool(threadPool)
            .readOnlyReplica(true)
            assertFalse("historyUUID must not be empty", historyUUID.isEmpty());  
                            ) {
        }
        EngineConfig config = buildWarmPrimaryConfig();
        Path translogPath = createTempDir().resolve("translog");
    public void testCommitStatsReturnsExpectedGeneration() throws IOException {
            List.<Segment>of(),  
            .translogConfig(translogConfig)
                recordingCommitter.getCommitStatsCalls.get()
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            assertSame("engine must return the committer's cached CommitStats instance", recordingCommitter.cached, first);
                assertNotNull("acquireSafeCatalogSnapshot must return a non-null snapshot", snapshot.get());  
        bootstrapStoreWithMetadata(store, translogUUID, null);
        Directory dir = newDirectory();
                listenerCalled.set(true);
    // ---------- Read Path Tests ----------
            BigArrays.NON_RECYCLING_INSTANCE,  
            }  
            Engine.Get get = realtimeGet("1");
        store = createStore(warmIndexSettings());  
        String historyUUID = UUID.randomUUID().toString();
        CountDownLatch doneLatch = new CountDownLatch(threadCount);  
                                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> gated =
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
            id,  
        DataFormatAwareReadOnlyEngine.NoOpCatalogSnapshotDeletionPolicy policy =  
            translogPath,
                userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
        }
        List<CatalogSnapshot> commitResult = policy.onCommit(List.of(mock(CatalogSnapshot.class)));
    // ---------- Translog Tests ----------
    private Engine.Get realtimeGet(String id) {  
            assertNotNull("historyUUID must be fabricated when not in commit", engine.getHistoryUUID());
    }
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {  
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        // Closing the GatedCloseable returned by acquireReader() must NOT release the permanent snapshot.  
        );
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
                    0L,
import org.opensearch.index.IndexModule;
                            doneLatch.countDown();
                }
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            if (historyUUID != null) {
            }  
    /** Calls the new getById(Engine.Get, searcherFactory) and unwraps the pre-materialized lookup.
            assertThat(engine, instanceOf(DataFormatAwareReadOnlyEngine.class));  
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngineWithProvider(provider)) {
        // onInit should return empty list (nothing to delete)  
            public void onFailedEngine(String reason, Exception e) {
    }
        // After close, the engine can still serve reads — snapshot is still valid.
        try (  
    /**
        Map<String, String> userData = new HashMap<>();
                    List.of(new Segment(1L, Map.of())),
import java.util.ArrayList;  
                userData.put(Translog.TRANSLOG_UUID_KEY, UUID.randomUUID().toString());
                try (  
            DataFormatAwareReadOnlyEngine engine = new DataFormatAwareReadOnlyEngine(
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> r1 = engine.acquireReader();
    }  
        engine.close();
            ) {  
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
                            }
            assertEquals(0L, engine.translogManager().getTranslogStats().getUncommittedSizeInBytes());  
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
    }
        // Concurrent read queries: N threads each call acquireReader() simultaneously.
    // ---------- Commit UserData Tests ----------  
            String translogUUID = engine.translogManager().getTranslogUUID();
        // All return the same reader object and the same snapshot ID.
    // ---------- Tests ----------  
        DataFormatAwareIndexerFactory factory = new DataFormatAwareIndexerFactory();
            Engine.Get get = realtimeGet("1").setIfSeqNo(5L).setIfPrimaryTerm(99L);
    public void testFlushIsNoOp() throws IOException {  
                "commitStats() must call committer.getCommitStats() exactly once per invocation",  
    private DataFormatAwareReadOnlyEngine createReadOnlyEngine() throws IOException {  
    public void testCreateEngineWithHistoryUUID() throws IOException {
    }
            userData.put(Engine.HISTORY_UUID_KEY, historyUUID);  
        Indexer engine = factory.createIndexer(config);  
        RecordingCommitter recordingCommitter = new RecordingCommitter(store);
import java.util.concurrent.CountDownLatch;  
    public void testAcquireReaderCatalogSnapshotIsNonNull() throws IOException {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                        assertEquals(
                startLatch.countDown();  
        final CommitStats cached;
    public void testAcquireReaderAfterReplication() throws IOException {
        } finally {  
    private MockDataFormat mockDataFormat;
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;  
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getProcessedLocalCheckpoint());
        }
                assertEquals("snapshot ID must remain stable", heldId, currentRef.get().getId());  
                }  
        return new Store(
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
            .threadPool(threadPool)  
    }  
                    "reader.catalogSnapshot() must return non-null — permanentSnapshotRef must be wired into the reader",  
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {  
    private Store store;
            // Engine can still serve a second read — snapshot was NOT released
    // ---------- getById Tests ----------
    }
            assertTrue("all threads must complete within timeout", doneLatch.await(30, TimeUnit.SECONDS));  
            }  
import org.opensearch.plugins.PluginsService;
            Settings.builder()
import org.opensearch.index.get.DocumentLookupResult;
            "",  
            Store.OnClose.EMPTY,
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
    private ShardId shardId;
        return new EngineConfig.Builder().shardId(shardId)
    }
