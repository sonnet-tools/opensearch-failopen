        String historyUUID = UUID.randomUUID().toString();
            // Engine can still serve a second read — snapshot was NOT released
            assertEquals(
            ) {
            DataformatAwareCatalogSnapshot incoming = buildReplicationSnapshot(1L, 1L, 10L, UUID.randomUUID().toString());
            assertEquals(0L, engine.translogManager().getTranslogStats().getUncommittedSizeInBytes());
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
    public void testCommitStatsAfterCloseThrowsAlreadyClosed() throws IOException {
        }
                    } catch (Exception e) {
    }
        // All return the same reader object and the same snapshot ID.
    /**
                    .acquireReader();
import org.apache.lucene.index.NoMergePolicy;
        IndexSettings replicaSettings = IndexSettingsModule.newIndexSettings(
                DataFormatAwareEngine.DataFormatAwareReader reader = (DataFormatAwareEngine.DataFormatAwareReader) gated.get();
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
        throws IOException {
            for (int i = 0; i < threadCount; i++) {
        }
            "",
        try {
            engine.close();
        Engine.GetResult result = engine.getById(get, (source, scope) -> null);
                try (
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getProcessedLocalCheckpoint());
    }
        // Concurrent read queries: N threads each call acquireReader() simultaneously.
            engine.flush(true, false);
            CommitStats commitStats = engine.commitStats();
            List<Exception> exceptions = new ArrayList<>();
    @Override
    public void testWriteRejection() throws IOException {
        String translogUUID = UUID.randomUUID().toString();
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
            terminate(threadPool);
                        } catch (Exception e) {
        }
            "",
        );
import java.nio.file.Path;
            .readOnlyReplica(false)
import org.opensearch.threadpool.ThreadPool;
    public void testCommitStatsDelegatesToCommitter() throws IOException {
import java.util.List;
        CommitterFactory committerFactory
    }
import org.apache.lucene.store.AlreadyClosedException;
        try {
            "",
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;
        String historyUUID = UUID.randomUUID().toString();
            try (
        IndexSettings hotSettings = nonWarmIndexSettings();
    }
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)
    }
            // acquireReader should still work after replication
                for (DataFormatAwareEngine.DataFormatAwareReader r : readersObserved) {
    public void testGetByIdThrowsWhenNoProvider() throws IOException {
import org.apache.lucene.index.IndexWriterConfig;
        } finally {
        );
            translogPath,
    public void testFailEngine() throws IOException {
            assertEquals(0, engine.translogManager().getTranslogStats().getUncommittedOperations());
import java.util.ArrayList;
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngineWithoutHistoryUUID()) {
     * calls do no I/O.
            getCommitStatsCalls.incrementAndGet();
        @Override
    }
            config.getStore().close();
            .primaryTermSupplier(primaryTerm::get)
    public void testGetByIdThrowsOnSeqNoMismatch() throws IOException {
    }
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
            .externalRefreshListener(List.of())
            .store(store)
import org.opensearch.core.index.shard.ShardId;
    private EngineConfig buildHotPrimaryConfig() throws IOException {
            // UUID is valid (non-null, non-empty)
    }
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
        DataFormatAwareIndexerFactory factory = new DataFormatAwareIndexerFactory();
        DataFormatAwareIndexerFactory factory = new DataFormatAwareIndexerFactory();
        shardId = new ShardId(new Index("test", "_na_"), 0);
            engine.translogManager().syncTranslog();
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            public List<CatalogSnapshot> listCommittedSnapshots() {
    private IndexSettings warmIndexSettings() {
                        synchronized (exceptions) {
    /** Writes a Lucene commit so the engine's store bootstrap finds valid userData. */
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            .readOnlyReplica(false)
     *  DFA engines ignore the searcher factory, so a no-op factory is supplied. */
                executor.shutdown();
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
                        }
            assertSame("engine must return the committer's cached CommitStats instance", recordingCommitter.cached, first);
    public void testGetByIdReturnsDocWhenNoConflict() throws IOException {
            ) {
            assertFalse("fabricated historyUUID must not be empty", engine.getHistoryUUID().isEmpty());
        String historyUUID = UUID.randomUUID().toString();
            CommitStats first = engine.commitStats();
 * Exercises constructor, write rejection, no-op translog, flush, close, failEngine,
            Settings.builder()
        Indexer engine = factory.createIndexer(config);
    private Store store;
    }
            // Engine should fabricate a historyUUID when not in commit (same as NRT engine)
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> r1 = engine.acquireReader();
            engine.ensureOpen();
            new DocumentLookupResult("1", 1L, true, null, 5L, 1L, Map.of(), Map.of())
            assertEquals(0L, engine.translogManager().getTranslogStats().getUncommittedSizeInBytes());
            .readOnlyReplica(true)
import org.opensearch.index.engine.exec.commit.CommitterFactory;
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> reader = engine
        String translogUUID = UUID.randomUUID().toString();
                assertNotNull("acquireReader must return a non-null reader", reader.get());
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            assertEquals(1L, result.version());
    private AtomicLong primaryTerm;
        );
            .primaryTermSupplier(primaryTerm::get)
 * SPDX-License-Identifier: Apache-2.0
                            exceptions.add(e);
                }
            Settings.builder()
            try (
                userData.put(Translog.TRANSLOG_UUID_KEY, UUID.randomUUID().toString());
        Store hotStore = createStore(hotSettings);
                assertNotNull("acquireSafeCatalogSnapshot must return a non-null snapshot", snapshot.get());
import java.util.concurrent.CountDownLatch;
            indexSettings,
            .threadPool(threadPool)
                    org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> gated = engine
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
            int threadCount = randomIntBetween(5, 15);
            Store.OnClose.EMPTY,
            )
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
    }
    }
        String translogUUID = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
            .committerFactory(committerFactory)
    private void bootstrapStoreWithMetadata(Store store, String translogUUID, String historyUUID) throws IOException {
/*
                commitData.put(Engine.HISTORY_UUID_KEY, historyUUID);
            // Acquire and immediately close
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
            userData.put(Engine.HISTORY_UUID_KEY, historyUUID);
            .tombstoneDocSupplier(tombstoneDocSupplier())
        TranslogConfig translogConfig = new TranslogConfig(
                assertNotNull("catalogSnapshot must still be valid after prior close()", reader.catalogSnapshot());
            }
    }
 * Unit tests for {@link DataFormatAwareReadOnlyEngine}.
    }
        Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> gated = engine
                DataFormatAwareEngine.DataFormatAwareReader expected = readersObserved.get(0);
        }
        return buildConfig(store, warmIndexSettings(), null);
        engine.close();
        // Closing the GatedCloseable returned by acquireReader() must NOT release the permanent snapshot.
        } finally {
 */
                    0L,
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
    private DataFormatAwareReadOnlyEngine createReadOnlyEngineWithoutHistoryUUID() throws IOException {
            assertEquals(0L, engine.getHeapBytesUsed());
                        engine.close();
        List<Exception> exceptions = new ArrayList<>();
import org.opensearch.plugins.PluginsService;
                assertTrue("all threads must complete within timeout", doneLatch.await(30, TimeUnit.SECONDS));
            int queryCount = randomIntBetween(5, 20);
        expectThrows(AlreadyClosedException.class, engine::acquireSafeCatalogSnapshot);
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            @Override
        DataFormatAwareIndexerFactory factory = new DataFormatAwareIndexerFactory();
                executor.submit(() -> {
    private Store createStore(IndexSettings indexSettings) throws IOException {
    }
    private EngineConfig buildReplicaConfig() throws IOException {
    public void testAcquireReaderCatalogSnapshotIsNonNull() throws IOException {
    }
        List<CatalogSnapshot> initResult = policy.onInit(List.of(mock(CatalogSnapshot.class), mock(CatalogSnapshot.class)));
            .store(hotStore)
                listenerCalled.set(true);
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
    public void testCreateEngineWithoutHistoryUUID() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    private DataformatAwareCatalogSnapshot buildReplicationSnapshot(long id, long gen, long maxSeqNo, String historyUUID) {
        mockDataFormat = new MockDataFormat("composite", 100L, Set.of());
            engine.close();
    public void testOperationsAfterCloseThrowAlreadyClosed() throws IOException {
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngineWithProvider(provider)) {
        );
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            builder.eventListener(listener);
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(mockPlugin));
        return IndexSettingsModule.newIndexSettings(
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> r2 = engine.acquireReader()
            BigArrays.NON_RECYCLING_INSTANCE,
        );
        bootstrapStoreWithMetadata(store, translogUUID, null);
            engine.close();
                                exceptions.add(e);
        DataFormatRegistry registry = createMockRegistry();
    }
            CountDownLatch startLatch = new CountDownLatch(1);
        return buildConfig(store, indexSettings, listener, config -> new InMemoryCommitter(store));
            CountDownLatch doneLatch = new CountDownLatch(threadCount);
            assertNotNull(commitStats);
            assertTrue("all threads must complete within timeout", doneLatch.await(30, TimeUnit.SECONDS));
        engine.flushAndClose();
            } finally {
                    List.of(new Segment(1L, Map.of())),
    private static class RecordingCommitter extends InMemoryCommitter {
            gen,
        when(provider.getById(any(), any(), any(), any())).thenReturn(
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getProcessedLocalCheckpoint());
        }
import org.opensearch.common.lucene.Lucene;
    }
            .dataFormatRegistry(registry)
    public void testGetByIdThrowsVersionConflictForReads() throws IOException {
    }
    public void testAcquireReaderReturnsNonNull() throws IOException {
        assertTrue("onInit with empty list should return empty", policy.onInit(List.of()).isEmpty());
        // The permanentSnapshotRef is acquired at construction and stored in the reader —
                    } else {
    }
            .internalRefreshListener(List.of())
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
import org.opensearch.common.util.BigArrays;
            long heldId = heldRef.get().getId();
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
        // onInit should return empty list (nothing to delete)
                            startLatch.await();
import java.util.UUID;
            expectThrows(UnsupportedOperationException.class, () -> getByIdLookup(engine, get));
    }
            // Snapshot ID is stable (warm primary is static — no new snapshots arrive)
    public void testCreateEngineWithHistoryUUID() throws IOException {
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, get));
        CountDownLatch startLatch = new CountDownLatch(1);
    }
            .mergePolicy(NoMergePolicy.INSTANCE)
        return IndexSettingsModule.newIndexSettings(
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                .build()
    }
    }
        }
            // Build the cached value once via the base (store-reading) implementation, then serve it
            BigArrays.NON_RECYCLING_INSTANCE,
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngineWithProvider(provider)) {
    public void testCreateEngine() throws IOException {
        return new Store(
            assertEquals("commitStats must report the committed generation", expectedGeneration, commitStats.getGeneration());
                userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
import java.util.concurrent.atomic.AtomicBoolean;
        }
            .indexSettings(hotSettings)
            Engine.Get get = realtimeGet("1");
    public void testAcquireReaderAfterReplication() throws IOException {
    }
    }
                        startLatch.await();
            assertThat(engine, instanceOf(DataFormatAwareEngine.class));
            .mergePolicy(NoMergePolicy.INSTANCE)
                    reader.catalogSnapshot()
    // ---------- Read Path Tests ----------
            .store(replicaStore)
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
    private MockDataFormatPlugin mockPlugin;
            // Apply a replication snapshot
        }
    }
            Settings.builder()
import java.util.concurrent.ExecutorService;
            IndexWriter writer = new IndexWriter(
                store.directory(),
        }
    }
        return result.exists() ? ((DocumentLookupResult.PreMaterialized) result).lookup() : DocumentLookupResult.notFound(get.id());
                assertNotNull(
    }
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
        // return the same underlying DataFormatAwareReader instance.
        }
import org.opensearch.index.engine.exec.Segment;
            ExecutorService executor = Executors.newFixedThreadPool(threadCount);
                            }
    }
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
    /**
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
    // ---------- commitStats Tests ----------
            shardId,
        Path translogPath = createTempDir().resolve("translog");
    private IndexSettings nonWarmIndexSettings() {
 *
import org.opensearch.cluster.metadata.IndexMetadata;
            engine.ensureOpen();
        }
                executor.awaitTermination(10, TimeUnit.SECONDS);
    }
        } finally {
}
            .primaryTermSupplier(primaryTerm::get)
            expectThrows(UnsupportedOperationException.class, () -> engine.noOp(null));
            assertEquals(engine.getProcessedLocalCheckpoint(), engine.getPersistedLocalCheckpoint());
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
        when(provider.getById(any(), any(), any(), any())).thenReturn(
                            synchronized (exceptions) {
            executor.shutdown();
            expectThrows(AlreadyClosedException.class, engine::ensureOpen);
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(maxSeqNo));
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> r2 = engine.acquireReader()
                    assertNotNull("query " + i + ": reader must be non-null", reader);
        CommitterFactory committerFactory = config -> new InMemoryCommitter(replicaStore);
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> afterRef = engine.acquireSafeCatalogSnapshot()) {
                    } finally {
            "test",
            }
            .translogConfig(translogConfig)
            r1.close();
                before + 2,
            shardId,
        }
        } finally {
                                assertNotNull("concurrent catalogSnapshot must be non-null", reader.catalogSnapshot());
        expectThrows(AlreadyClosedException.class, engine::acquireReader);
        EngineConfig config = buildHotPrimaryConfig();
        engine.failEngine("test-failure", new IOException("simulated"));
        engine.close();
import static org.hamcrest.Matchers.instanceOf;
        }
                assertEquals("snapshot ID must be stable after ref release", heldId, afterRef.get().getId());
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
            expectThrows(UnsupportedOperationException.class, () -> engine.index(null));
            new DocumentLookupResult("1", 5L, true, null, 0L, 1L, Map.of(), Map.of())
    // ---------- Tests ----------
                    0L,
                    assertNotNull("query " + i + ": catalogSnapshot must be non-null", reader.catalogSnapshot());
            shardPath,
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
     * same cached instance — mirroring the production committer, which caches SegmentInfos so stats
    public void testAcquireReaderMultipleTimesReturnsSameReaderObject() throws IOException {
        };
     * commitStats() must delegate to the committer's (cached) stats and NOT re-read the store on
        bootstrapStoreWithMetadata(store, translogUUID, historyUUID);
        primaryTerm = new AtomicLong(randomLongBetween(1, Long.MAX_VALUE));
            }
        assertTrue("onInit should return empty list", initResult.isEmpty());
    }
        String historyUUID = UUID.randomUUID().toString();
            if (historyUUID != null) {
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.index.store.Store;
    }
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, get));
                            ) {
        try (DataFormatAwareReadOnlyEngine engine = new DataFormatAwareReadOnlyEngine(config, provider)) {
                );
                    assertSame("all concurrent queries must get the same reader object", expected, r);
            replicaSettings,
        }
    }
    }
import static org.mockito.ArgumentMatchers.any;
            new DocumentLookupResult("1", 1L, true, null, 5L, 1L, Map.of(), Map.of())
    public void testFactoryCreatesReadOnlyEngineForWarmPrimary() throws IOException {
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();
        DataFormatAwareReadOnlyEngine.NoOpCatalogSnapshotDeletionPolicy policy =
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
            .committerFactory(committerFactory)
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
        }
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
                                DataFormatAwareEngine.DataFormatAwareReader reader = (DataFormatAwareEngine.DataFormatAwareReader) gated
            .committerFactory(committerFactory)
        ) {
            gen,
    private EngineConfig buildConfig(Store store, IndexSettings indexSettings, Engine.EventListener listener) {
        }
            BigArrays.NON_RECYCLING_INSTANCE,
import org.opensearch.index.engine.exec.Indexer;
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();
                userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
            writer.setLiveCommitData(commitData.entrySet());
        EngineConfig config = buildReplicaConfig();
            // Sync is a no-op (does not throw)
import java.util.concurrent.TimeUnit;
        }
import java.util.concurrent.atomic.AtomicLong;
                            doneLatch.countDown();
    public void testCloseIsIdempotent() throws IOException {
    public void testCloseReleasesResources() throws IOException {
import org.opensearch.plugins.DocumentLookupProvider;
                    try {
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, "-1");
        // Second close must be a no-op, not throw.
                            "query " + i + ": snapshot ID must be stable across all queries",
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngineWithProvider(provider)) {
            new DocumentLookupResult("1", 1L, true, null, 0L, 1L, Map.of(), Map.of())
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            ) {
        String historyUUID = UUID.randomUUID().toString();
            // Persisted == processed for this engine
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
    }
    }
        expectThrows(AlreadyClosedException.class, engine::commitStats);
        }
        if (historyUUID != null) {
            engine.flush();
        );
        // All must get a non-null catalogSnapshot and the same reader object.
package org.opensearch.index.engine;
            .build();
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
        CountDownLatch doneLatch = new CountDownLatch(threadCount);
        EngineConfig.Builder builder = new EngineConfig.Builder().shardId(shardId)
    public void testFlushIsNoOp() throws IOException {
    private ShardId shardId;
            DataFormatAwareReadOnlyEngine engine = new DataFormatAwareReadOnlyEngine(
            .indexSettings(warmIndexSettings())
            .indexSettings(indexSettings)
public class DataFormatAwareReadOnlyEngineTests extends OpenSearchTestCase {
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();
            .translogConfig(translogConfig)
            String translogUUID = engine.translogManager().getTranslogUUID();
            public void onFailedEngine(String reason, Exception e) {
            .internalRefreshListener(List.of())
        }
    public void testFactoryCreatesNRTEngineForReplica() throws IOException {
        // Regression test: DataFormatAwareReader.catalogSnapshot() must not NPE.
        when(provider.getById(any(), any(), any(), any())).thenReturn(
        String translogUUID = UUID.randomUUID().toString();
        bootstrapStoreWithMetadata(store, translogUUID, historyUUID);
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
        );
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            ) {
import org.opensearch.core.index.Index;
import org.opensearch.threadpool.TestThreadPool;
            )
        );
                        firstReader = reader;
                            try (
        bootstrapStoreWithMetadata(store, translogUUID, historyUUID);
        }
            assertNotNull("translog UUID must be non-null", translogUUID);
        engine.close();
    }
            try (
            assertFalse("historyUUID must not be empty", historyUUID.isEmpty());
        }
            // Engine must still be open after all queries
            .dataFormatRegistry(registry)
     * Test committer that records how many times getCommitStats() is called and always returns the
    }
        // After close, the engine can still serve reads — snapshot is still valid.
import org.opensearch.index.IndexSettings;
            for (int i = 0; i < queryCount; i++) {
            .threadPool(threadPool)
            assertFalse("should return not found when catalog has no segments", result.exists());
        return new DataFormatRegistry(pluginsService);
            );
            .threadPool(threadPool)
    ) {
    public void testMultipleConcurrentReadQueriesAllGetValidSnapshot() throws Exception {
    }
                return List.of(snapshot);
        DataFormatRegistry registry = createMockRegistry();
        threadPool = new TestThreadPool(getClass().getName());
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
    }
import org.opensearch.index.IndexModule;
            .primaryTermSupplier(primaryTerm::get)
        CommitterFactory committerFactory = config -> new InMemoryCommitter(hotStore);
 * The OpenSearch Contributors require contributions made to
                assertSame("all acquireReader() calls must return the same reader object", r1.get(), r2.get());
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
        return new DataFormatAwareReadOnlyEngine(buildConfig(store, indexSettings, listener));
        return createReadOnlyEngine(store, warmIndexSettings(), null);
import java.util.concurrent.Executors;
import org.opensearch.index.translog.TranslogConfig;
        userData.put(Translog.TRANSLOG_UUID_KEY, UUID.randomUUID().toString());
import org.opensearch.common.unit.TimeValue;
        String historyUUID = UUID.randomUUID().toString();
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        DataFormatRegistry registry = createMockRegistry();
            .readOnlyReplica(false);
        return new EngineConfig.Builder().shardId(shardId)
                });
        String translogUUID = UUID.randomUUID().toString();
            executor.awaitTermination(10, TimeUnit.SECONDS);
import org.apache.lucene.index.IndexWriter;
                    userData
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
     * each call. Proven two ways: the committer's getCommitStats() is invoked once per call, and the
    public void testNoOpTranslog() throws IOException {
    }
        RecordingCommitter recordingCommitter = new RecordingCommitter(store);
        }
import java.io.IOException;
        Store replicaStore = createStore(replicaSettings);
            long firstSnapshotId = -1;
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> reader = engine
    public void tearDown() throws Exception {
    // ---------- Translog Tests ----------
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(
        PluginsService pluginsService = mock(PluginsService.class);
            assertFalse("read-only primary engine must not identify as replica", engine.isReplicaIndexer());
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
            new DataFormatAwareReadOnlyEngine.NoOpCatalogSnapshotDeletionPolicy();
        engine.close();
        Engine.EventListener listener = new Engine.EventListener() {
            assertFalse("translog UUID must not be empty", translogUUID.isEmpty());
import org.opensearch.index.store.FsDirectoryFactory;
        super.tearDown();
import org.apache.lucene.store.Directory;
            List.<Segment>of(),
    public void testIsReplicaIndexerReturnsFalse() throws IOException {
                        .acquireReader()
                // All threads must have seen the same reader object
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    // ---------- Snapshot Ref-Counting Tests ----------
        Map<String, String> userData = new HashMap<>();
            translogPath,
import org.opensearch.index.seqno.RetentionLeases;
    private MockDataFormat mockDataFormat;
            .internalRefreshListener(List.of())
    private static DocumentLookupResult getByIdLookup(DataFormatAwareReadOnlyEngine engine, Engine.Get get) throws IOException {
    private Engine.Get realtimeGet(String id) {
    // ---------- getById Tests ----------
                );
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
        }
        // callers using reader.catalogSnapshot() (e.g. LuceneAnalyticsBackendPlugin) must get a valid snapshot.
 * and constant-return methods for the warm read-only primary engine.
            "test",
                DataformatAwareCatalogSnapshot snapshot = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
        ShardPath shardPath = new ShardPath(false, path, path, shardId);
            .externalRefreshListener(List.of())
            }
            .mergePolicy(org.apache.lucene.index.NoMergePolicy.INSTANCE)
        }
            Map<String, String> commitData = new HashMap<>();
            assertEquals(0L, engine.getWritingBytes());
     */
                buildConfig(store, warmIndexSettings(), null, config -> recordingCommitter)
            shardId,
        TranslogConfig translogConfig = new TranslogConfig(shardId, translogPath, hotSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false);
        mockPlugin = MockDataFormatPlugin.of(mockDataFormat);
                            }
/**
                assertNotNull("engine must still serve reads after prior GatedCloseable.close()", r2.get());
            // Engine must still be open after all concurrent reads
        };
            // After release, snapshot is still accessible and stable
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            .committerFactory(committerFactory)
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
                                readersObserved.add(reader);
        }
        RecordingCommitter(Store store) throws IOException {
import java.util.concurrent.atomic.AtomicInteger;
            "test",
    }
            }
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false)
            warmIndexSettings(),
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getPersistedLocalCheckpoint());
                        assertEquals(
            writer.commit();
            return cached;
            expectThrows(UnsupportedOperationException.class, () -> engine.delete(null));
import org.opensearch.test.DummyShardLock;
     * exact instance it returns is propagated unchanged through the engine.
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;
    }
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;
            assertTrue("doc should be found", result.exists());
                userData.put(Engine.HISTORY_UUID_KEY, UUID.randomUUID().toString());
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine(store, warmIndexSettings(), listener);
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
        try {
        }
            userData
            @Override
                    .acquireReader()
                snapshot.setLastCommitInfo("segments_1", 1L, 0L);
    public void testConstantReturns() throws IOException {
    }
        bootstrapStoreWithMetadata(store, translogUUID, historyUUID);
            false
        assertTrue("onCommit should return empty list", commitResult.isEmpty());
            assertNotNull(engine.translogManager());
            // Engine should still be open
    // ---------- Concurrent Close Tests ----------
                }
            DataFormatAwareEngine.DataFormatAwareReader firstReader = null;
        Path translogPath = createTempDir().resolve("translog");
            startLatch.countDown();
            assertSame("engine must return the committer's cached CommitStats instance unchanged", first, second);
    public void testFactoryCreatesWritableEngineForHotPrimary() throws IOException {
                                    .get();
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
    }
    public void testCommitStatsReturnsExpectedGeneration() throws IOException {
                ) {
    // ---------- Checkpoint Tests ----------
                .build()
            Engine.Get get = realtimeGet("1");
            List<DataFormatAwareEngine.DataFormatAwareReader> readersObserved = new java.util.concurrent.CopyOnWriteArrayList<>();
import org.opensearch.plugins.SearchBackEndPlugin;
                    if (firstReader == null) {
    }
            .externalRefreshListener(List.of())
                    "reader.catalogSnapshot() must return non-null — permanentSnapshotRef must be wired into the reader",
        try (
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngineWithProvider(provider)) {
            engine.finalizeReplication(incoming);
        super.setUp();
            DocumentLookupResult result = getByIdLookup(engine, get);
            assertTrue("no exceptions expected from concurrent close, got: " + exceptions, exceptions.isEmpty());
        } finally {
    }
        final AtomicInteger getCommitStatsCalls = new AtomicInteger();
            }
            assertNotNull("historyUUID must be fabricated when not in commit", engine.getHistoryUUID());
            .translogConfig(translogConfig)
            ) {
import org.opensearch.common.settings.Settings;
        DataFormatRegistry registry = createMockRegistry();
        Directory dir = newDirectory();
    public void testAcquireReaderCloseIsNoOpSnapshotRemainsValid() throws IOException {
                    DataFormatAwareEngine.DataFormatAwareReader reader = (DataFormatAwareEngine.DataFormatAwareReader) gated.get();
        Path translogPath = createTempDir().resolve("translog");
            .tombstoneDocSupplier(tombstoneDocSupplier())
                recordingCommitter.getCommitStatsCalls.get()
            long expectedGeneration = store.readLastCommittedSegmentsInfo().getGeneration();
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            .translogConfig(translogConfig)
    private ThreadPool threadPool;
        bootstrapStoreWithMetadata(hotStore, translogUUID, historyUUID);
        }
                assertEquals("snapshot ID must remain stable", heldId, currentRef.get().getId());
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
import java.util.HashMap;
import org.opensearch.Version;
                assertNotNull("acquireReader must return a non-null reader after replication", reader.get());
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
        throws IOException {
        IndexSettings indexSettings,
            assertEquals(0, engine.translogManager().getTranslogStats().getUncommittedOperations());
            .dataFormatRegistry(registry)
    }
import org.opensearch.index.shard.ShardPath;
            assertNotNull(engine.config());
        try {
 */
        // Sequential read queries: each acquireReader() returns a valid reader with non-null catalogSnapshot.
            .internalRefreshListener(List.of())
            }
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            assertNotNull("historyUUID must be read from commit", historyUUID);
            assertNotNull("historyUUID must be assigned", engine.getHistoryUUID());
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();
        }
    public void testNoOpDeletionPolicyNeverDeletesSnapshots() {
            org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> heldRef = engine.acquireSafeCatalogSnapshot();
        }
        int threadCount = randomIntBetween(2, 10);
                "commitStats() must call committer.getCommitStats() exactly once per invocation",
                        try {
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> snapshot = engine.acquireSafeCatalogSnapshot()) {
    public void testAcquireSafeCatalogSnapshotReturnsNonNull() throws IOException {
        );
                    executor.submit(() -> {
    private EngineConfig buildConfig(
    public void testCheckpointAccessorsOnFreshEngine() throws IOException {
import java.util.Map;
            id,
        return (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
        EngineConfig config = buildWarmPrimaryConfig();
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
                Map<String, String> userData = new HashMap<>();
                startLatch.countDown();
            new DummyShardLock(shardId),
                                assertNotNull("concurrent reader must be non-null", reader);
        List<CatalogSnapshot> commitResult = policy.onCommit(List.of(mock(CatalogSnapshot.class)));
    public void testFlushAndClose() throws IOException {
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, get));
        }
        when(provider.getById(any(), any(), any(), any())).thenReturn(
            engine.ensureOpen();
            try (
            assertNotNull("commitStats must not be null", first);
            }
    }
    public void testMultipleSequentialReadQueriesAllGetValidSnapshot() throws IOException {
        EngineConfig config = buildConfig(store, warmIndexSettings(), null);
                }
        return new DataFormatAwareReadOnlyEngine(buildConfig(store, warmIndexSettings(), null));
            .build();
                        doneLatch.countDown();
    public void setUp() throws Exception {
        );
            }
    }
        bootstrapStoreWithMetadata(store, translogUUID, historyUUID);
            assertFalse(engine.shouldPeriodicallyFlush());
            indexSettings,
        ) {
                        assertSame("query " + i + ": must be same reader object as query 0", firstReader, reader);
            Engine.Get get = realtimeGet("1").version(3L).versionType(org.opensearch.index.VersionType.EXTERNAL);
        store = createStore(warmIndexSettings());
import org.opensearch.test.OpenSearchTestCase;
        assertTrue("onCommit with empty list should return empty", policy.onCommit(List.of()).isEmpty());
            .indexSettings(replicaSettings)
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
    }
                        firstSnapshotId = reader.catalogSnapshot().getId();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            engine.flush(false, true);
            false
        String translogUUID = UUID.randomUUID().toString();
            .mergePolicy(NoMergePolicy.INSTANCE)
                    .acquireReader()
        TranslogConfig translogConfig = new TranslogConfig(
        // The snapshot never changes for read-only engine — all acquireReader() calls
        // onCommit should return empty list (nothing to delete)
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        public CommitStats getCommitStats() {
        return builder.build();
            Engine.Get get = realtimeGet("1").setIfSeqNo(5L).setIfPrimaryTerm(99L);
                    });
import org.opensearch.index.translog.Translog;
    private DataFormatRegistry createMockRegistry() {
                                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> gated =
        }
            // Zero uncommitted operations
    public void testGetByIdThrowsOnPrimaryTermMismatch() throws IOException {
            }
        }
                org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.Indexer.Reader> r1 = engine
                    }
            .tombstoneDocSupplier(tombstoneDocSupplier())
        Store store,
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
            this.cached = super.getCommitStats();
        Indexer engine = factory.createIndexer(config);
        }
        );
        );
        }
        return new Engine.Get(true, true, id, new org.apache.lucene.index.Term("_id", org.opensearch.index.mapper.Uid.encodeId(id)));
            .tombstoneDocSupplier(tombstoneDocSupplier())
                for (int i = 0; i < threadCount; i++) {
                assertEquals("must have observed N reader instances", threadCount, readersObserved.size());
            List.of(new MockSearchBackEndPlugin(List.of(mockDataFormat.name())))
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        }
    }
                    }
        Engine.EventListener listener,
    /** commitStats() must honor engine lifecycle — after close it must throw, not read the store. */
        try (
            .dataFormatRegistry(registry)
            .threadPool(threadPool)
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
    /** Calls the new getById(Engine.Get, searcherFactory) and unwraps the pre-materialized lookup.
        Path translogPath = createTempDir().resolve("translog");
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();
            Engine.Get get = realtimeGet("1").setIfSeqNo(99L).setIfPrimaryTerm(1L);
    private DataFormatAwareReadOnlyEngine createReadOnlyEngineWithProvider(org.opensearch.plugins.DocumentLookupProvider provider)
import static org.mockito.Mockito.mock;
                            firstSnapshotId,
    public void testConcurrentCloseExecutesExactlyOnce() throws Exception {
            gen,
            false
            new FsDirectoryFactory()
    }
        if (listener != null) {
import org.opensearch.index.engine.exec.DataFormatAwareIndexerFactory;
    }
            Engine.Get get = realtimeGet("1");
            assertThat(engine, instanceOf(DataFormatAwareNRTReplicationEngine.class));
            }
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
        }
        return new DataFormatAwareReadOnlyEngine(config, provider);
            shardId,
                    -1L,
                    0L,
            dir,
    }
            String historyUUID = engine.getHistoryUUID();
    public void testTranslogSnapshotIsAlwaysEmpty() throws IOException {
    public void testAcquireSafeCatalogSnapshotPreventsCleanupWhileHeld() throws IOException {
            assertNotNull("commitStats must carry a commit id", commitStats.getId());
                .build()
            // Acquire a snapshot reference and verify it is non-null
        }
            DocumentLookupResult result = getByIdLookup(engine, get);
            .externalRefreshListener(List.of())
                    .acquireReader()
        return new EngineConfig.Builder().shardId(shardId)
        );
import static org.mockito.Mockito.when;
import org.opensearch.index.get.DocumentLookupResult;
            store.close();
                        );
            assertNotNull(heldRef.get());
 * compatible open source license.
        CommitterFactory committerFactory = config -> new InMemoryCommitter(store) {
            heldRef.close();
                            reader.catalogSnapshot().getId()
        try {
            config.getStore().close();
            }
            CommitStats second = engine.commitStats();
            // flush is always a no-op on read-only engine (does not throw, does not commit)
                        }
    private DataFormatAwareReadOnlyEngine createReadOnlyEngine() throws IOException {
                assertTrue("no exceptions from concurrent readers, got: " + exceptions, exceptions.isEmpty());
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> currentRef = engine.acquireSafeCatalogSnapshot()) {
    @Override
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
        TranslogConfig translogConfig = new TranslogConfig(
    public void testGetByIdReturnsNotFoundOnEmptyCatalog() throws IOException {
        DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine();
            }
    /** commitStats() must surface the committer's actual commit point (correct generation). */
import java.util.Set;
                                    engine.acquireReader()
            super(store);
        String translogUUID = UUID.randomUUID().toString();
                DataFormatAwareEngine.DataFormatAwareReader reader = (DataFormatAwareEngine.DataFormatAwareReader) r2.get();
        // Empty input should also work
import org.opensearch.test.IndexSettingsModule;
        engine.close();
            .store(store)
        bootstrapStoreWithMetadata(replicaStore, uuid, UUID.randomUUID().toString());
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
            int before = recordingCommitter.getCommitStatsCalls.get();
            assertThat(engine, instanceOf(DataFormatAwareReadOnlyEngine.class));
            try (
        Indexer engine = factory.createIndexer(config);
                        } finally {
            // from memory on every subsequent call — no further store reads.
    }
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
        try (DataFormatAwareReadOnlyEngine engine = createReadOnlyEngine()) {
    private DataFormatAwareReadOnlyEngine createReadOnlyEngine(Store store, IndexSettings indexSettings, Engine.EventListener listener)
    // ---------- Commit UserData Tests ----------
     */
        final CommitStats cached;
    private EngineConfig buildWarmPrimaryConfig() throws IOException {
    }
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
    // ---------- Engine Flip Integration Tests (DataFormatAwareIndexerFactory) ----------
            }
            try {
            translogPath,
    }
        assertTrue("event listener must be notified on failEngine", listenerCalled.get());
