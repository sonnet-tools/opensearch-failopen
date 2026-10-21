    public void testUpdateCatalogSnapshotWithoutHistoryUUIDPreservesExisting() throws IOException {
    }
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, "-1");
        }
    // generation, which can collide with the bootstrap Lucene commit state. End-to-end flush
        DataformatAwareCatalogSnapshot snapshot = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
    }
            DataformatAwareCatalogSnapshot incoming = buildReplicationSnapshot(1L, 1L, 5L, UUID.randomUUID().toString());
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
import org.opensearch.index.engine.exec.Segment;
public class DataFormatAwareNRTReplicationEngineTests extends OpenSearchTestCase {
            String newHistoryUUID = UUID.randomUUID().toString();
    public void testPrepareDeleteBuildsValidDeleteOp() throws IOException {
import org.opensearch.common.util.BigArrays;
            false,
            assertEquals(0L, stats.getDeleted());
     */
        Path tmpDir = createTempDir();
            // History ops snapshot / counters
                // Either is acceptable for a replica stub
import org.opensearch.core.index.shard.ShardId;
            assertFalse("historyUUID must not be empty", engine.getHistoryUUID().isEmpty());
            assertEquals(0L, stats.getCurrent());
        }
            .externalRefreshListener(List.of())
            "test",
        userData.put(Engine.HISTORY_UUID_KEY, engine.getHistoryUUID());
            dir,
 * paths without relying on DFA integration tests.
            org.opensearch.index.shard.DocsStats stats = engine.docStats();
     * The Lucene deleter must:
import org.opensearch.index.store.Store;
    }
        engine.close();
        DataFormatAwareNRTReplicationEngine engine,
                    org.opensearch.index.VersionType.EXTERNAL,
            // commitStats read should succeed (no IndexNotFoundException / corruption).
        // Advance the catalog generation so the close-time commit writes a new segments_N.
        }
import org.opensearch.index.engine.exec.FileDeleter;
        Path parquetOrphan = parquetDir.resolve("stale.parquet");
    }
        } finally {
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(
            userData
        assertTrue("segments_N must be preserved", java.nio.file.Files.exists(segmentsCommit));
            Segment seg = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs).build();
        IndexSettings indexSettings = replicaIndexSettings();
        engine.failEngine("second-fail", new IOException("ignored"));
                assertNotNull(safe.get());
        return new Store(
    public void testCheckpointAccessorsOnFreshEngine() throws IOException {
    }
            assertNotNull(stats);
    private MockDataFormatPlugin mockPlugin;
    }
        try {
        // Plant files in each format's directory and verify the respective deleter removes them.
            // Apply a replication snapshot with segments
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
        ShardPath shardPath = new ShardPath(false, root, root, shardId);
            assertTrue("Segment should be searchable after replication", replicatedSeg.search);
            // This is verified by checking that commitStats() works (doesn't throw)
            DataformatAwareCatalogSnapshot first = buildReplicationSnapshot(1L, 1L, 5L, UUID.randomUUID().toString());
    }
import org.opensearch.core.index.Index;
            }
        long id,
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        assertTrue("write.lock must be preserved", java.nio.file.Files.exists(writeLock));
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 5L, List.of(seg));
        if (historyUUID != null) {
import java.util.concurrent.atomic.AtomicLong;
            assertEquals(0L, engine.getWritingBytes());
        assertTrue("parquet deleter must be present", deleters.containsKey("parquet"));
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            assertEquals(seqNo, engine.getMaxSeqNoOfUpdatesOrDeletes());
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
            assertEquals("processed checkpoint must be fast-forwarded", maxSeqNo, engine.getProcessedLocalCheckpoint());
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
    }
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    }
            engine.refresh("noop-refresh");
        // Simulate the primary having committed this snapshot (sets lastCommitGeneration).
        // Commit files MUST be preserved by the Lucene deleter even if listed.
            // Apply a replication snapshot
    }
    // the replica's commitCatalogSnapshot sets nextWriteGeneration from the CatalogSnapshot's
        Path parquetDir = root.resolve("parquet");
    }
     * the stats cache initialization during construction.
                "doc-id",
                // If it doesn't throw, the result must be non-null
import org.opensearch.index.mapper.ParsedDocument;
            store.close();
            assertEquals(0L, docsStats.getDeleted());
            org.opensearch.index.merge.MergeStats stats = engine.getMergeStats();
            assertNotNull(engine.completionStats());
    }
            // Same generation (1L) — MUST NOT trigger another flush/roll.
            .build();
import org.opensearch.index.translog.Translog;
    }
    }
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getProcessedLocalCheckpoint());
import org.opensearch.index.seqno.RetentionLeases;
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    public void testAcquireSnapshotReturnsLatest() throws IOException {
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    // NOTE: Testing flush()+commitCatalogSnapshot() end-to-end in a unit test is fragile because
    public void testUpdateCatalogSnapshotMonotonicSeqNoAdvancement() throws IOException {
            // Second snapshot at seqNo 10 (advances)
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
     */
            assertNotNull("fresh replica must have a historyUUID", engine.getHistoryUUID());
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir());
        Path translogPath = createTempDir().resolve("translog");
            Engine.IndexResult result = engine.index(replicaIndexOp(doc, seqNo));
        return IndexSettingsModule.newIndexSettings(
                    1L,
                Engine.Operation.Origin.PRIMARY,
     * the engine constructor fails and resources are cleaned up.
     * and that the cache is properly populated with committed state.
        try (
    public void testTranslogManagerAccessor() throws IOException {
        assertFalse("parquet deleter must physically remove the orphan", java.nio.file.Files.exists(parquetOrphan));
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> snap = engine.acquireSnapshot()) {
                    Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
            .threadPool(threadPool)
            gen,
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getProcessedLocalCheckpoint());
        }
            ParsedDocument doc = createParsedDoc("id-1", null);
    }
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
            assertFalse(engine.isThrottled());
        CommitterFactory committerFactory = config -> new InMemoryCommitter(store);
    // behavior is covered by the DFA ITs (DataFormatAwareReplicationIT, DataFormatAwareUploadIT).
    }
            Segment seg = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs).build();
            org.opensearch.index.shard.DocsStats docsStats = engine.docStats();
        return snapshot;
            assertTrue("Segment should be searchable after flush", flushedSeg.search);
                throw new RuntimeException("Simulated failure in getLastCommittedData");
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            // Completion + segments stats — must return non-null without throwing
            assertNotNull("translogManager must be available on a fresh engine", engine.translogManager());
        AlreadyClosedException e = expectThrows(AlreadyClosedException.class, engine::ensureOpen);
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir());
    @Override
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
        }
            Segment seg2 = Segment.builder(2L).addSearchableFiles(mockDataFormat, wfs2).build();
            long minRetained = engine.getMinRetainedSeqNo();
        expectThrows(Exception.class, () -> new DataFormatAwareNRTReplicationEngine(failingConfig));
    public void testAcquireLastCommittedSnapshotReturnsSnapshot() throws IOException {
    }
            engine.updateCatalogSnapshot(incoming);
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
 *
    public void testSegmentsStatsEmptyOnFreshReplica() throws IOException {
            segments,
    public void setUp() throws Exception {
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
                minRetained == SequenceNumbers.NO_OPS_PERFORMED || minRetained >= 0
     *  (b) guard against deleting commit files ({@code segments_*}, {@code write.lock})
            assertEquals(7L, op.seqNo());
            Store.OnClose.EMPTY,
import org.opensearch.index.IndexSettings;
        }
    }
            indexSettings,
    }
    public void testUpdateCatalogSnapshotTriggersFlushOnGenerationChange() throws IOException {
                    /* docMapper */ null,
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            writer.commit();
            List.of(MockDataFormatPlugin.of(luceneLike), MockDataFormatPlugin.of(parquetLike))
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            SegmentsStats stats = engine.segmentsStats(false, false);
            assertTrue(
        engine.flushAndClose();
            List<org.opensearch.index.engine.Segment> segments = engine.segments(false);
            .internalRefreshListener(List.of())
            assertTrue("user data should contain history UUID", userData.containsKey(Engine.HISTORY_UUID_KEY));
            assertEquals(0L, stats.getCount());
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
        }
                org.opensearch.index.VersionType.EXTERNAL,
            assertNotNull("commit stats should be available after flush", commitStats);
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    public void testSegmentsCommittedAfterReplicationDueToConstructorInit() throws IOException {
            engine.updateCatalogSnapshot(incoming);
            assertNotNull("commit stats should be available after construction", commitStats);
        shardId = new ShardId(new Index("test", "_na_"), 0);
        }
            // Snapshot with no HISTORY_UUID_KEY in userData — must NOT overwrite the existing uuid.
        expectThrows(org.apache.lucene.store.AlreadyClosedException.class, engine::commitStats);
            // Initial state - cache should be initialized with empty stats
            registry,
    }
    /**
        }
        Map<String, String> userData = new HashMap<>();
    public void testAcquireLastIndexCommitReturnsBootstrapCommit() throws IOException {
            commitData.put(Engine.HISTORY_UUID_KEY, UUID.randomUUID().toString());
    public void testHistoryUUIDIsNonNullOnOpen() throws IOException {
    public void testStatsCacheUpdatesAfterReplicationDueToConstructorInit() throws IOException {
            }
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(maxSeqNo));
            "",
/*
            // commitStats must never be null on a replica (the review fix).
import org.opensearch.index.engine.exec.commit.CommitterFactory;
            long maxSeqNo = 42L;
            expectThrows(UnsupportedOperationException.class, engine::acquireSafeIndexCommit);
                )
            assertEquals("historyUUID must be preserved when incoming has none", originalUUID, engine.getHistoryUUID());
            new InMemoryCommitter(store)
        Path translogPath = createTempDir().resolve("translog");
        List<Segment> segments
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getPersistedLocalCheckpoint());
        DataformatAwareCatalogSnapshot snapshot = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
        return new DataFormatRegistry(pluginsService);
        Path translogPath = createTempDir();
            gen,
            engine.updateCatalogSnapshot(noUUID);
            assertEquals("initial segments count should be 0", 0, engine.segmentsStats(false, false).getCount());
                Engine.IndexResult ir = engine.index(null);
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
        // SegRep must be enabled for EngineConfig.isReadOnlyReplica() to return true.
            List.of(new MockSearchBackEndPlugin(List.of("lucene", "parquet")))
                    source,
            System.nanoTime(),
    private DataformatAwareCatalogSnapshot buildSnapshotWithSegments(
            assertEquals(0L, stats.getIndexWriterMemoryInBytes());
            // Apply a replication snapshot with segments
                assertNotNull(last.get());
        // close() internally calls commitCatalogSnapshot → closeNoLock → IOUtils.close(...)
            assertNotNull("user data should be available in committed state", userData);
import org.apache.lucene.index.CorruptIndexException;
    public void testGetSafeCommitInfoReturnsTrackerCheckpointAndZeroDocsForEmptySnapshot() throws IOException {
        assertNotNull(e.getMessage());
            .primaryTermSupplier(primaryTerm::get)
        TranslogConfig translogConfig = new TranslogConfig(
        engine.updateCatalogSnapshot(incoming);
                .build()
            assertTrue("commit generation should be >= 0 after construction", commitStats.getGeneration() >= 0);
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            assertNotNull("segments list should be initialized", segments);
            // historyUUID must reflect the incoming snapshot (replicated primaries can bump it).
            Segment seg1 = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs1).build();
import org.opensearch.index.translog.TranslogConfig;
    private Store store;
        CommitterFactory failingCommitterFactory = config -> new InMemoryCommitter(store) {
            long genAfterFirst = engine.commitStats().getGeneration();
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
        }
    private DataformatAwareCatalogSnapshot buildReplicationSnapshot(long id, long gen, long maxSeqNo, String historyUUID) {
    }
            assertEquals(0, stats.getCount());
            // The key test: verify that after construction, the engine is in a committed state
            assertEquals(0L, engine.unreferencedFileCleanUpsPerformed());
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(maxSeqNo));
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
        primaryTerm = new AtomicLong(randomLongBetween(1, Long.MAX_VALUE));
            assertEquals(newHistoryUUID, engine.getHistoryUUID());
            assertEquals("but local checkpoint still advances", 6L, engine.getProcessedLocalCheckpoint());
 */
            // Cache should be updated via refresh listeners (which were properly registered during construction)
        }
     * Verifies that if getLastCommittedData() throws during construction,
import java.util.HashMap;
     * proper cache functionality.
                /* seqNo */ 7L,
            assertEquals(seqNo, result.getSeqNo());
        );
    }
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
            incoming.setReplicatingCommitData(sis);
     */
    public void testBuildReplicaFileDeletersCoversLuceneAndNonDefaultFormats() throws IOException {
            assertTrue("DFA NRT engine must always identify as replica", engine.isReplicaIndexer());
            assertTrue("Segment should be committed after flush", flushedSeg.committed);
        userData.put(Translog.TRANSLOG_UUID_KEY, UUID.randomUUID().toString());
            assertFalse(engine.shouldPeriodicallyFlush());
            userData.put(Engine.HISTORY_UUID_KEY, historyUUID);
                org.apache.lucene.util.Version.LATEST.major
 * The OpenSearch Contributors require contributions made to
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
            .dataFormatRegistry(createMockRegistry())
        deleters.get("lucene").deleteFiles(Map.of("lucene", List.of("segments_5", "write.lock")));
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
     */
        // Must not throw — silently skips.
            engine.updateCatalogSnapshot(second);
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
            assertNotNull(engine.segmentsStats(false, false));
    public void testStatsCacheReturnsCachedSegmentsStatsAfterRefresh() throws IOException {
                    1L,
    public void testUpdateCatalogSnapshotDoesNotRecommitOnSameGeneration() throws IOException {
import org.opensearch.index.seqno.SequenceNumbers;
    public void testConstructorFailsWhenCommitterThrows() throws IOException {
                store.directory(),
        }
    public void testOperationsAfterCloseThrowAlreadyClosed() throws IOException {
            shardId,
            assertNotNull("fresh replica must have a historyUUID", originalUUID);
            .readOnlyReplica(true)
            assertEquals("should have 1 segment after flush", 1, segments.size());
            engine.updateCatalogSnapshot(incoming);
            );
            assertEquals(0L, stats.getTotal());
        Path tmpDir = createTempDir();
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            assertEquals("should have 1 segment after replication", 1, segments.size());
     */
        }
    }
            assertEquals(0, stats.getCount());
    }
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
        }
            engine.updateCatalogSnapshot(first);
    public void testFlushAndCloseOnAlreadyClosedEngine() throws Exception {
            assertNotNull(engine.commitStats());
            List<org.opensearch.index.engine.Segment> segments = engine.segments(false);
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
        }
            // After a commit (via update + flush), lastCommittedSnapshot is set
        }
            gen,
            assertEquals("segments count should be updated after replication", 1, updatedStats.getCount());
        long maxSeqNo,
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
            assertNotNull(stats);
            shardPath,
            public Map<String, String> getLastCommittedData() {
        Path luceneOrphan = indexDir.resolve("_stale_orphan.si");
        }
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        Path translogPath = createTempDir().resolve("translog");
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    }
    }
            assertEquals(10L, engine.getProcessedLocalCheckpoint());
    public void testAcquireSafeCatalogSnapshotReturnsLatestForFreshEngine() throws IOException {
        Directory dir = newDirectory();
                /* ifSeqNo */ SequenceNumbers.UNASSIGNED_SEQ_NO,
            engine.updateCatalogSnapshot(incoming);
            // getMinRetainedSeqNo on fresh replica returns NO_OPS_PERFORMED
     */
                    5L,
                    -1L,
        return new Engine.Index(
            assertNotNull(engine.translogManager());
                "doc-id",
            assertEquals(0L, engine.getHeapBytesUsed());
            assertEquals(10L, engine.getProcessedLocalCheckpoint());
    private Engine.Index replicaIndexOp(ParsedDocument doc, long seqNo) {
                "minRetainedSeqNo must be non-negative or NO_OPS_PERFORMED",
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            // Verify that the stats cache was initialized during construction
    /**
            new DummyShardLock(shardId),
        java.nio.file.Files.write(segmentsCommit, new byte[] { 9 });
    }
        Path tmpDir = createTempDir();
                // Replicas don't produce upload metadata bytes — that's the primary's job.
import org.opensearch.test.DummyShardLock;
            assertEquals(0, info.docCount);
            shardPath,
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            Segment seg = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs).build();
    public void testMaybeFailEngineOnCorruption() throws Exception {
    // ---------- Stats cache (CatalogSnapshotStatsCache) ----------
import org.opensearch.test.OpenSearchTestCase;
            // Stubs / defaults that should never throw
            }
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
            DataformatAwareCatalogSnapshot incoming = buildReplicationSnapshot(1L, 1L, maxSeqNo, newHistoryUUID);
            Versions.MATCH_ANY,
            org.opensearch.index.engine.CommitStats stats = engine.commitStats();
            org.apache.lucene.index.SegmentInfos sis = new org.apache.lucene.index.SegmentInfos(
            id,
    /**
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
                expectThrows(UnsupportedOperationException.class, () -> engine.serializeSnapshotToRemoteMetadata(snap.get()));
/**
        );
            Segment seg = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs).build();
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;
        }
            engine.updateCatalogSnapshot(resend);
            .committerFactory(committerFactory)
            WriterFileSet wfs = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("test.mock").addNumRows(5).build();
import org.opensearch.threadpool.ThreadPool;
                NullPointerException.class,
    public void testIndexDeleteNoOpReturnUnsupportedOnReplica() throws IOException {
    private Store createStore() throws IOException {
            List<org.opensearch.index.engine.Segment> segments = engine.segments(false);
            try {
                "lastRefreshedCheckpoint must be non-negative or NO_OPS_PERFORMED",
        }
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
                    false,
    }
    }
        }
    public void testSegmentsStatsUpdatedAfterReplication() throws IOException {
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(translogPath);
        );
            id,
        engine.failEngine("first-fail", new IOException("simulated"));
    }
        assertTrue("lucene deleter must be present", deleters.containsKey("lucene"));
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(mockPlugin));
    public void testFillSeqNoGapsIsNoOp() throws IOException {
import org.opensearch.Version;
import org.opensearch.common.lucene.Lucene;
            new FsDirectoryFactory()
            CommitStats commitStats = engine.commitStats();
    }
            SegmentsStats stats = engine.segmentsStats(true, false);
        super.setUp();
        MockDataFormat luceneLike = new MockDataFormat("lucene", 100L, Set.of());
            assertFalse(engine.hasCompleteOperationHistory("test", 0L));
 */
    private EngineConfig buildReplicaConfig(Path translogPath) {
    }
    }
            assertEquals("initial docs count should be 0", 0L, engine.docStats().getCount());
            List.<Segment>of(),
            seqNo,
        );
            engine.updateCatalogSnapshot(first);
            // First snapshot at seqNo 5
        );
            assertTrue("commit generation should advance after replication", commitStats.getGeneration() > 0);
            // Fresh replica: localCheckpoint = NO_OPS_PERFORMED (-1), no segments → 0 docs
        }
        Path writeLock = indexDir.resolve("write.lock");
import java.util.List;
    }
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
        java.nio.file.Files.createDirectories(indexDir);
                /* version */ 1L,
        engine.close();
    public void testMaybePruneDeletesIsNoOp() throws IOException {
import org.opensearch.test.IndexSettingsModule;
    }
        // Second close must be a no-op, not throw.
            );
            false
            SegmentsStats stats = engine.segmentsStats(false, false);
    public void testUpdateCatalogSnapshotPreservesCommitSegmentInfos() throws IOException {
            .tombstoneDocSupplier(tombstoneDocSupplier())
            DataformatAwareCatalogSnapshot first = buildReplicationSnapshot(1L, 1L, 5L, UUID.randomUUID().toString());
    public void testReplicaWriteStubsAppendToTranslogAndAdvanceMaxSeqNo() throws IOException {
            List.of(new MockSearchBackEndPlugin(List.of(mockDataFormat.name())))
            assertEquals("fresh replica should have 0 segments", 0, segments.size());
        bootstrapStoreWithMetadata(store, uuid);
    public void testCloseIsIdempotent() throws IOException {
        }
import org.opensearch.index.shard.ShardPath;
            // prepareIndex requires a non-null docMapper to parse the source
            }
            engine.updateCatalogSnapshot(second);
        Path tmpDir = createTempDir();
import org.apache.lucene.index.IndexWriterConfig;
            engine.pollingIngestStats();
            BigArrays.NON_RECYCLING_INSTANCE,
            engine.flush(false, true);
    }
            .store(store)
    }
import org.opensearch.plugins.PluginsService;
            SegmentsStats updatedStats = engine.segmentsStats(false, false);
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;
            gen,
            gen,
            // pollingIngestStats may return null on replicas (no ingestion source)
import java.io.IOException;
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
        java.nio.file.Files.write(writeLock, new byte[] { 9 });
import org.opensearch.common.unit.TimeValue;
    /**
    }
    public void testStatsAndStubMethodsReturnDefaultValues() throws IOException {
        java.nio.file.Files.write(parquetOrphan, new byte[] { 4, 5, 6 });
                /* ifPrimaryTerm */ SequenceNumbers.UNASSIGNED_PRIMARY_TERM
            // This verifies that the statsCache was properly initialized during construction
        );
            DataformatAwareCatalogSnapshot second = buildReplicationSnapshot(2L, 2L, 10L, null);
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            // The replica's index/delete/noOp methods are stubs that throw or return synthetic results.
 * Exercises constructor, replication-snapshot application, commit, write-stubs, and close
    }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            assertEquals(0, engine.countNumberOfHistoryOperations("test", 0L, Long.MAX_VALUE));
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 10L, List.of(seg));
            // Perform flush
            expectThrows(
     * via replication, ensuring the cache initialization during construction enables
package org.opensearch.index.engine;
                () -> engine.prepareIndex(
            engine.updateCatalogSnapshot(incoming);
        deleters.get("lucene").deleteFiles(Map.of("lucene", List.of("_stale_orphan.si")));
            engine.maybePruneDeletes();
    // ---------- Stats / introspection methods (cheap O(1) returns) ----------
        }
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;
        // Second fail — must be a no-op (already failed).
        }
    public void testUpdateCatalogSnapshotAdvancesCheckpointAndHistoryUUID() throws IOException {
            );
            String originalUUID = engine.getHistoryUUID();
            assertEquals(0L, engine.getIndexThrottleTimeInMillis());
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
import java.util.Set;
        }
import static org.opensearch.index.engine.EngineTestCase.createParsedDoc;
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
            assertNotNull(stats);
        snapshot.setLastCommitInfo("segments_" + gen, gen, 0L);
            CommitStats commitStats = engine.commitStats();
            assertNotNull(engine.commitStats());
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
                assertNotNull(snap.get());
import org.opensearch.cluster.metadata.IndexMetadata;
            assertEquals(1, engine.segmentsStats(false, false).getCount());
            // Simulate SegmentReplicationTarget setting the bytes on the snapshot
    private IndexSettings replicaIndexSettings() {
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        EngineConfig failingConfig = new EngineConfig.Builder().shardId(shardId)
    /** Writes a Lucene commit so the engine's store bootstrap finds valid userData. */
    /**
            Map<String, String> commitData = new HashMap<>();
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
            sis.setUserData(java.util.Map.of(), false);
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
    ) {
            // Second snapshot with a different generation must force a flush-and-roll.
        );
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 5L, List.of(seg));
            // Replica can't ACTIVELY index/delete/noOp — those go through prepareIndex on the primary.
            .mergePolicy(NoMergePolicy.INSTANCE)
        super.tearDown();
     * Without this, superseded Lucene secondary files from prior replication snapshots
    public void testConstructorInitializesStatsCacheWithCommittedState() throws IOException {
    public void tearDown() throws Exception {
import static org.mockito.Mockito.mock;
    public void testEnsureOpenThrowsAlreadyClosedAfterClose() throws IOException {
     * Verifies that flush operations result in properly committed segments,
            // For a fresh replica, segments list should be empty but cache should be committed/initialized
            // by checking that it returns valid (non-null) stats
        engine.failEngine("corruption", new CorruptIndexException("simulated", "test"));
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
        }
        engine.close();
            } catch (UnsupportedOperationException | NullPointerException expected) {
    }
            );
import java.nio.file.Path;
            WriterFileSet wfs1 = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("seg1.mock").addNumRows(7).build();
     * accumulate forever on composite-engine replicas.
        MockDataFormat parquetLike = new MockDataFormat("parquet", 50L, Set.of());
            org.opensearch.index.mapper.SourceToParse source = new org.opensearch.index.mapper.SourceToParse(
    }
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir());
            shardId,
        }
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 5L, List.of(seg));
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
import org.opensearch.common.lucene.uid.Versions;
        return new EngineConfig.Builder().shardId(shardId)
            }
            assertNotNull(stats);
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            // Validate they don't blow up the JVM and return some result (or throw a known type).
            -1,
            assertNotNull(stats);
            .dataFormatRegistry(registry)
            engine.updateCatalogSnapshot(incoming);
        Path segmentsCommit = indexDir.resolve("segments_5");
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> safe = engine.acquireSafeCatalogSnapshot()) {
    /**
        PluginsService pluginsService = mock(PluginsService.class);
        );
            Map<String, String> userData = commitStats.getUserData();
        );
            // After commit, a segments_N file with these bytes is written. A subsequent
        Path tmpDir = createTempDir();
                /* primaryTerm */ 1L,
        mockPlugin = MockDataFormatPlugin.of(mockDataFormat);
    }
            engine.forceMerge(false, 1, false, false, false, "test-uuid");
        }
            long seqNo = 7L;
            userData
    }
                assertNotNull(ir);
            assertEquals("same-generation update must not advance commit generation", genAfterFirst, engine.commitStats().getGeneration());
        java.nio.file.Files.write(luceneOrphan, new byte[] { 1, 2, 3 });
        }
            org.opensearch.index.engine.SafeCommitInfo info = engine.getSafeCommitInfo();
     * File-deleter map must include BOTH Lucene and non-default formats.
            .mergePolicy(NoMergePolicy.INSTANCE)
            // Verify segments are committed after replication
            // Must not throw
        }
            assertTrue("user data should contain translog UUID", userData.containsKey(Translog.TRANSLOG_UUID_KEY));
        DataformatAwareCatalogSnapshot incoming = buildReplicationSnapshot(1L, 2L, 10L, engine.getHistoryUUID());
     * Verifies that after replication, segments are properly committed due to
    private ThreadPool threadPool;
     *  (a) delete files in {@code <shardPath>/index/}
            .primaryTermSupplier(primaryTerm::get)
    }
            null,
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            .translogConfig(translogConfig)
    // ---------- prepareIndex / prepareDelete (translog replay path) ----------
        long gen,
            indexSettings,
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            engine.updateCatalogSnapshot(incoming);
    public void testFailEngineAndDoubleFailIsNoOp() throws Exception {
            .externalRefreshListener(List.of())
import org.opensearch.index.mapper.Uid;
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            // Refresh / writeIndexingBuffer must be no-ops (don't throw)
            DataformatAwareCatalogSnapshot second = buildReplicationSnapshot(2L, 2L, 10L, null);
        expectThrows(org.apache.lucene.store.AlreadyClosedException.class, () -> engine.acquireSnapshot());
            .tombstoneDocSupplier(tombstoneDocSupplier())
            WriterFileSet wfs2 = WriterFileSet.builder().directory(tmpDir).writerGeneration(2L).addFile("seg2.mock").addNumRows(7).build();
    }
        }
    }
    }
    public void testDocStatsReflectsReplicatedSnapshot() throws IOException {
import static org.mockito.Mockito.when;
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
    public void testFlushAndClose() throws Exception {
     * enabled by the stats cache initialization during construction.
            WriterFileSet wfs = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("seg1.mock").addNumRows(10).build();
    // ---------- Snapshot acquisition variants ----------
            WriterFileSet wfs = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("test.mock").addNumRows(5).build();
            .internalRefreshListener(List.of())
    public void testGetMergeStatsReturnsEmpty() throws IOException {
    public void testConfigReturnsConstructorConfig() throws IOException {
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            assertNotNull("stats cache should be initialized", engine.segmentsStats(false, false));
        deleters.get("parquet").deleteFiles(Map.of("parquet", List.of("stale.parquet")));
    }
            assertTrue("Segment should be committed after replication", replicatedSeg.committed);
            long lrc = engine.lastRefreshedCheckpoint();
        // First fail — must close the engine.
            .committerFactory(failingCommitterFactory)
            assertNotNull("docs stats should be initialized", engine.docStats());
            Settings.builder()
            assertNotNull(info);
        java.nio.file.Files.createDirectories(parquetDir);
            assertNotNull("historyUUID must be assigned", engine.getHistoryUUID());
            doc,
            .threadPool(threadPool)
            );
            primaryTerm.get(),
        );
            .translogConfig(new TranslogConfig(shardId, translogPath, replicaIndexSettings(), BigArrays.NON_RECYCLING_INSTANCE, "", false))
        userData.put(Translog.TRANSLOG_UUID_KEY, UUID.randomUUID().toString());
        Path root = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
import org.apache.lucene.index.NoMergePolicy;
    public void testPrepareIndexNullDocMapperThrows() throws IOException {
    }
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    // ---------- updateCatalogSnapshot edge cases ----------
        Path tmpDir = createTempDir();
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
    private MockDataFormat mockDataFormat;
            // Verify commit stats reflect the committed state
    }
            // Verify segments are properly committed after construction
            assertTrue(
        bootstrapStoreWithMetadata(store, uuid);
        }
        engine.close();
                new org.opensearch.core.common.bytes.BytesArray("{}"),
    public void testSerializeSnapshotToRemoteMetadataThrowsOnReplica() throws IOException {
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
    private void bootstrapStoreWithMetadata(Store store, String translogUUID) throws IOException {
    }
            assertNotNull(stats);
        snapshot.setLastCommitInfo("segments_" + gen, gen, 0L);
                lrc == SequenceNumbers.NO_OPS_PERFORMED || lrc >= 0
import org.opensearch.index.mapper.IdFieldMapper;
    // ---------- Constructor and stats cache initialization tests ----------
    public void testIsReplicaIndexerReturnsTrue() throws IOException {
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, info.localCheckpoint);
import java.util.UUID;
                    SequenceNumbers.UNASSIGNED_PRIMARY_TERM
            terminate(threadPool);
import org.apache.lucene.store.AlreadyClosedException;
    }
import org.opensearch.index.store.FsDirectoryFactory;
    }
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
        };
            DataformatAwareCatalogSnapshot incoming = buildReplicationSnapshot(1L, 1L, 5L, UUID.randomUUID().toString());
        IndexSettings indexSettings = replicaIndexSettings();
    public void testForceMergeIsNoOp() throws Exception {
    private DataFormatAwareNRTReplicationEngine createReplicaEngine(Path translogPath) throws IOException {
     * Verifies that the stats cache is initialized during DFANRE construction
            Engine.Delete op = engine.prepareDelete(
    public void testCommitStatsReturnsCommitData() throws IOException {
}
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    @Override
            // Verify segments are committed after flush
        }
    public void testCreateEngine() throws IOException {
        threadPool = new TestThreadPool(getClass().getName());
    }
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> last = engine.acquireLastCommittedSnapshot(false)) {
            assertEquals(5L, engine.getProcessedLocalCheckpoint());
     * Verifies that the statsCache is properly updated when catalog snapshots change
        }
        }
            CommitStats commitStats = engine.commitStats();
import org.opensearch.plugins.SearchBackEndPlugin;
    }
            assertNotNull("config() must return a non-null EngineConfig", engine.config());
                org.opensearch.common.xcontent.XContentType.JSON
            assertEquals(2, stats.getCount());
            assertEquals(0L, engine.docStats().getCount());
    private ShardId shardId;
            .readOnlyReplica(true)
            IndexWriter writer = new IndexWriter(
            Segment seg = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs).build();
            org.opensearch.index.engine.Segment flushedSeg = segments.get(0);
import org.apache.lucene.store.Directory;
            translogPath,
            .build();
import org.apache.lucene.index.Term;
            assertEquals(0, engine.fillSeqNoGaps(1L));
        PluginsService pluginsService = mock(PluginsService.class);
            assertNotNull(op);
        Map<String, FileDeleter> deleters = DataFormatAwareNRTReplicationEngine.buildReplicaFileDeleters(
            engine.updateCatalogSnapshot(first);
    }
            engine.updateCatalogSnapshot(incoming);
        ShardPath shardPath = new ShardPath(false, path, path, shardId);
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(translogPath);
        Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
            assertFalse("replica must always report no-op for maybeRefresh", engine.maybeRefresh("noop"));
            @Override
        }
            assertNotNull("commit stats must include user data", stats.getUserData());
    // ---------- Tests ----------
            );
            // lastRefreshedCheckpoint may be -1 (NO_OPS_PERFORMED) or 0 depending on initialization
            .store(store)
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
    }
            assertEquals(0, engine.segmentsStats(false, false).getCount());
        ) {
        }
            // and is functioning correctly for subsequent operations
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            .indexSettings(replicaIndexSettings())
    public void testSegmentsStatsWithFileSizesPathDoesNotThrow() throws IOException {
import java.util.Map;
        DataFormatRegistry registry = createMockRegistry();
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(translogPath);
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 3L, List.of(seg));
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> snap = engine.acquireSnapshot()) {
            WriterFileSet wfs = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("seg1.mock").addNumRows(5).build();
 * Unit tests for {@link DataFormatAwareNRTReplicationEngine}.
            org.opensearch.index.engine.Segment replicatedSeg = segments.get(0);
            DataformatAwareCatalogSnapshot resend = buildReplicationSnapshot(1L, 1L, 6L, null);
            writer.setLiveCommitData(commitData.entrySet());
            engine.updateCatalogSnapshot(incoming);
            DataformatAwareCatalogSnapshot noUUID = buildReplicationSnapshot(1L, 1L, 5L, /* historyUUID= */ null);
    }
            WriterFileSet wfs = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("test.mock").addNumRows(3).build();
        }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        store = createStore();
        engine.close();
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        }
 * this file be licensed under the Apache-2.0 license or a
            assertFalse("replica must never report needing a refresh", engine.refreshNeeded());
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        bootstrapStoreWithMetadata(store, UUID.randomUUID().toString());
import org.opensearch.threadpool.TestThreadPool;
            assertNotNull("write must record a translog location", result.getTranslogLocation());
        Path translogPath = createTempDir().resolve("translog");
                "idx",
            engine.writeIndexingBuffer();
            assertNotNull(docsStats);
    private AtomicLong primaryTerm;
            // DFA replica engines don't merge. Must not throw.
        assertFalse("lucene deleter must physically remove the orphan", java.nio.file.Files.exists(luceneOrphan));
        }
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
            )
        engine.close();
 * compatible open source license.
            0
import org.opensearch.index.engine.exec.WriterFileSet;
        return new DataFormatAwareNRTReplicationEngine(buildReplicaConfig(translogPath));
        mockDataFormat = new MockDataFormat("composite", 100L, Set.of());
            gen,
                    SequenceNumbers.UNASSIGNED_SEQ_NO,
            Engine.Operation.Origin.REPLICA,
            }
            DataformatAwareCatalogSnapshot first = buildReplicationSnapshot(1L, 1L, 5L, UUID.randomUUID().toString());
        return snapshot;
    private DataFormatRegistry createMockRegistry() {
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            .indexSettings(indexSettings)
        Map<String, String> userData = new HashMap<>();
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
        Path indexDir = root.resolve("index");
    public void testFlushResultsInCommittedSegmentsDueToConstructorInit() throws IOException {
            assertNotNull("commit stats should be available after replication", commitStats);
import org.apache.lucene.index.IndexWriter;
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(translogPath);
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
        }
            // Verify the commit stats show committed state
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 14L, List.of(seg1, seg2));
            // DFA replica engine returns 0 — Lucene-style gaps don't apply
    public void testDocStatsZeroForFreshReplica() throws IOException {
