            Segment seg = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs).build();
            assertEquals(10L, engine.getProcessedLocalCheckpoint());
        CommitterFactory failingCommitterFactory = config -> new InMemoryCommitter(store) {  
            assertNotNull(stats);
    }
            assertEquals(seqNo, engine.getMaxSeqNoOfUpdatesOrDeletes());  
        deleters.get("parquet").deleteFiles(Map.of("parquet", List.of("stale.parquet")));  
import org.opensearch.common.util.BigArrays;
    }
            assertEquals(0L, engine.getHeapBytesUsed());  
    public void testConstructorFailsWhenCommitterThrows() throws IOException {
import org.opensearch.common.unit.TimeValue;
            shardPath,
        ShardPath shardPath = new ShardPath(false, root, root, shardId);  
            assertNotNull("segments list should be initialized", segments);
    public void testUpdateCatalogSnapshotTriggersFlushOnGenerationChange() throws IOException {
            Settings.builder()
        engine.flushAndClose();
        java.nio.file.Files.write(writeLock, new byte[] { 9 });
    }  
        }
        }
            assertNotNull(stats);  
            new InMemoryCommitter(store)  
                Engine.IndexResult ir = engine.index(null);
        Path tmpDir = createTempDir();
import static org.mockito.Mockito.mock;  
        Path segmentsCommit = indexDir.resolve("segments_5");
            // pollingIngestStats may return null on replicas (no ingestion source)
    }
        mockPlugin = MockDataFormatPlugin.of(mockDataFormat);
            System.nanoTime(),
        Path translogPath = createTempDir().resolve("translog");
import org.opensearch.plugins.SearchBackEndPlugin;  
            shardId,
    }  
        long id,  
    public void testForceMergeIsNoOp() throws Exception {  
    }
            .store(store)
        }
            assertEquals(0, info.docCount);
    }
        }
            Map<String, String> commitData = new HashMap<>();
    // ---------- updateCatalogSnapshot edge cases ----------
        );
            Engine.IndexResult result = engine.index(replicaIndexOp(doc, seqNo));  
     * The Lucene deleter must:
import org.apache.lucene.index.Term;
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 14L, List.of(seg1, seg2));
        return new Store(
        );
            assertNotNull("fresh replica must have a historyUUID", originalUUID);  
            assertEquals(0L, stats.getCount());  
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
            long seqNo = 7L;
            // Apply a replication snapshot with segments  
            // The key test: verify that after construction, the engine is in a committed state  
        Path tmpDir = createTempDir();
        bootstrapStoreWithMetadata(store, uuid);
            assertTrue("commit generation should advance after replication", commitStats.getGeneration() > 0);  
                    false,
                "doc-id",  
    public void testSerializeSnapshotToRemoteMetadataThrowsOnReplica() throws IOException {  
        } finally {
            assertEquals(0L, stats.getCurrent());
            engine.flush(false, true);
        ) {
            .committerFactory(failingCommitterFactory)  
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
        List<Segment> segments  
        return snapshot;
            // This verifies that the statsCache was properly initialized during construction  
    // ---------- Snapshot acquisition variants ----------
            // historyUUID must reflect the incoming snapshot (replicated primaries can bump it).
    public void testUpdateCatalogSnapshotPreservesCommitSegmentInfos() throws IOException {
                "minRetainedSeqNo must be non-negative or NO_OPS_PERFORMED",  
import org.opensearch.test.DummyShardLock;
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    private AtomicLong primaryTerm;
            }
        }
import org.opensearch.index.engine.exec.commit.CommitterFactory;  
    }
        }
import java.util.HashMap;  
            sis.setUserData(java.util.Map.of(), false);  
    private MockDataFormatPlugin mockPlugin;  
    }
            // After a commit (via update + flush), lastCommittedSnapshot is set  
 */  
            new FsDirectoryFactory()
import org.apache.lucene.store.AlreadyClosedException;  
        };
    private Engine.Index replicaIndexOp(ParsedDocument doc, long seqNo) {
                    org.opensearch.index.VersionType.EXTERNAL,
    public void testIsReplicaIndexerReturnsTrue() throws IOException {
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
            "",
    public void testUpdateCatalogSnapshotMonotonicSeqNoAdvancement() throws IOException {
            gen,  
        PluginsService pluginsService = mock(PluginsService.class);  
            writer.setLiveCommitData(commitData.entrySet());
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        }  
            DataformatAwareCatalogSnapshot incoming = buildReplicationSnapshot(1L, 1L, 5L, UUID.randomUUID().toString());  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
        java.nio.file.Files.write(segmentsCommit, new byte[] { 9 });  
    }  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    }
            ParsedDocument doc = createParsedDoc("id-1", null);
            org.apache.lucene.index.SegmentInfos sis = new org.apache.lucene.index.SegmentInfos(  
        // Simulate the primary having committed this snapshot (sets lastCommitGeneration).
    }
            dir,
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(translogPath);  
        }
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
                .build()
    }  
        Path root = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
            engine.updateCatalogSnapshot(resend);  
            .readOnlyReplica(true)
        }
            WriterFileSet wfs = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("test.mock").addNumRows(5).build();
    public void testCloseIsIdempotent() throws IOException {  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            engine.updateCatalogSnapshot(second);
            engine.pollingIngestStats();  
        Path indexDir = root.resolve("index");
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {  
            assertNotNull(stats);
import org.opensearch.index.seqno.SequenceNumbers;
            List<org.opensearch.index.engine.Segment> segments = engine.segments(false);
    public void testGetMergeStatsReturnsEmpty() throws IOException {
                "doc-id",  
    public void tearDown() throws Exception {
            id,
            assertFalse(engine.hasCompleteOperationHistory("test", 0L));  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
    }
            // commitStats must never be null on a replica (the review fix).  
            assertNotNull("commit stats should be available after flush", commitStats);
     * and that the cache is properly populated with committed state.
    }
    public void testStatsCacheReturnsCachedSegmentsStatsAfterRefresh() throws IOException {
        }
            .externalRefreshListener(List.of())
            // Simulate SegmentReplicationTarget setting the bytes on the snapshot
    // ---------- prepareIndex / prepareDelete (translog replay path) ----------  
    public void testAcquireLastCommittedSnapshotReturnsSnapshot() throws IOException {
     */
    ) {
        DataformatAwareCatalogSnapshot snapshot = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
                    -1L,  
import org.opensearch.cluster.metadata.IndexMetadata;  
        expectThrows(org.apache.lucene.store.AlreadyClosedException.class, () -> engine.acquireSnapshot());
            assertNotNull(info);
            assertEquals(0L, engine.unreferencedFileCleanUpsPerformed());
package org.opensearch.index.engine;
            String originalUUID = engine.getHistoryUUID();
    public void testFillSeqNoGapsIsNoOp() throws IOException {
    // NOTE: Testing flush()+commitCatalogSnapshot() end-to-end in a unit test is fragile because
        Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
            assertEquals(5L, engine.getProcessedLocalCheckpoint());  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
            assertEquals(0L, engine.getIndexThrottleTimeInMillis());
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            shardPath,
            primaryTerm.get(),
        long gen,
            Versions.MATCH_ANY,
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
     */
            org.opensearch.index.engine.SafeCommitInfo info = engine.getSafeCommitInfo();  
                assertNotNull(last.get());
            // History ops snapshot / counters
        );
    }
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;  
import org.opensearch.test.IndexSettingsModule;
    }
            // Cache should be updated via refresh listeners (which were properly registered during construction)
            assertEquals("processed checkpoint must be fast-forwarded", maxSeqNo, engine.getProcessedLocalCheckpoint());
            List.<Segment>of(),
     * proper cache functionality.
    public void testPrepareIndexNullDocMapperThrows() throws IOException {
                    source,  
            public Map<String, String> getLastCommittedData() {
            doc,
    /**
            assertNotNull("commit stats must include user data", stats.getUserData());  
        Directory dir = newDirectory();  
            .dataFormatRegistry(createMockRegistry())
            assertNotNull(stats);
            // getMinRetainedSeqNo on fresh replica returns NO_OPS_PERFORMED  
            assertEquals(newHistoryUUID, engine.getHistoryUUID());  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
                    /* docMapper */ null,
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            assertNotNull(stats);
            engine.updateCatalogSnapshot(noUUID);
            indexSettings,  
            userData
        TranslogConfig translogConfig = new TranslogConfig(  
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir());
/*  
import org.opensearch.index.seqno.RetentionLeases;
            assertTrue("Segment should be searchable after replication", replicatedSeg.search);  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            org.opensearch.index.engine.CommitStats stats = engine.commitStats();
            expectThrows(
        Map<String, FileDeleter> deleters = DataFormatAwareNRTReplicationEngine.buildReplicaFileDeleters(  
 * SPDX-License-Identifier: Apache-2.0
        }
        Path translogPath = createTempDir().resolve("translog");
        }
    }
            assertTrue("DFA NRT engine must always identify as replica", engine.isReplicaIndexer());  
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 3L, List.of(seg));
            assertNotNull(stats);  
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
        }
                store.directory(),  
            .translogConfig(translogConfig)  
            .build();
        }
            assertEquals(0L, stats.getIndexWriterMemoryInBytes());
        }
     */  
        AlreadyClosedException e = expectThrows(AlreadyClosedException.class, engine::ensureOpen);  
            assertNotNull(engine.commitStats());  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            assertEquals(0L, engine.getWritingBytes());  
            translogPath,
            // commitStats read should succeed (no IndexNotFoundException / corruption).
            // Apply a replication snapshot
            // Same generation (1L) — MUST NOT trigger another flush/roll.
    // ---------- Stats cache (CatalogSnapshotStatsCache) ----------
import org.apache.lucene.store.Directory;
            .internalRefreshListener(List.of())  
        }
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
            }
        return new DataFormatRegistry(pluginsService);
                "idx",
    public void testSegmentsStatsUpdatedAfterReplication() throws IOException {  
            // Verify segments are committed after replication
            SegmentsStats stats = engine.segmentsStats(false, false);
            assertTrue("Segment should be committed after replication", replicatedSeg.committed);
                lrc == SequenceNumbers.NO_OPS_PERFORMED || lrc >= 0
import static org.mockito.Mockito.when;
    public void testHistoryUUIDIsNonNullOnOpen() throws IOException {
        }
    }  
    private MockDataFormat mockDataFormat;
        }
                assertNotNull(ir);
                    1L,
            .committerFactory(committerFactory)  
     */
            assertTrue("commit generation should be >= 0 after construction", commitStats.getGeneration() >= 0);
     * accumulate forever on composite-engine replicas.
            WriterFileSet wfs = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("seg1.mock").addNumRows(10).build();  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
                )
    public void testIndexDeleteNoOpReturnUnsupportedOnReplica() throws IOException {
import java.util.UUID;
            // Stubs / defaults that should never throw
        );  
            gen,
        IndexSettings indexSettings = replicaIndexSettings();
 * The OpenSearch Contributors require contributions made to  
    private ThreadPool threadPool;
    }
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            );
            assertNotNull(engine.segmentsStats(false, false));
import org.opensearch.core.index.Index;  
        }
            assertTrue(
    public void testSegmentsCommittedAfterReplicationDueToConstructorInit() throws IOException {  
            assertEquals(10L, engine.getProcessedLocalCheckpoint());
        }  
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 5L, List.of(seg));  
     *  (a) delete files in {@code <shardPath>/index/}
        }
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
        }
 * compatible open source license.
                /* ifPrimaryTerm */ SequenceNumbers.UNASSIGNED_PRIMARY_TERM
import org.apache.lucene.index.NoMergePolicy;
            Segment seg = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs).build();
        DataformatAwareCatalogSnapshot incoming = buildReplicationSnapshot(1L, 2L, 10L, engine.getHistoryUUID());
            // DFA replica engine returns 0 — Lucene-style gaps don't apply  
        // Second close must be a no-op, not throw.  
        userData.put(Translog.TRANSLOG_UUID_KEY, UUID.randomUUID().toString());
    public void testStatsCacheUpdatesAfterReplicationDueToConstructorInit() throws IOException {  
            org.opensearch.index.shard.DocsStats stats = engine.docStats();
            .store(store)
            incoming.setReplicatingCommitData(sis);
        userData.put(Translog.TRANSLOG_UUID_KEY, UUID.randomUUID().toString());
            engine.updateCatalogSnapshot(incoming);
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
            engine.updateCatalogSnapshot(incoming);  
                    SequenceNumbers.UNASSIGNED_PRIMARY_TERM  
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getProcessedLocalCheckpoint());
        Path translogPath = createTempDir();
            String newHistoryUUID = UUID.randomUUID().toString();
            BigArrays.NON_RECYCLING_INSTANCE,
            .translogConfig(new TranslogConfig(shardId, translogPath, replicaIndexSettings(), BigArrays.NON_RECYCLING_INSTANCE, "", false))  
        IndexSettings indexSettings = replicaIndexSettings();
            assertTrue("user data should contain history UUID", userData.containsKey(Engine.HISTORY_UUID_KEY));
            assertEquals(0, engine.fillSeqNoGaps(1L));
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getProcessedLocalCheckpoint());
    }
    private Store createStore() throws IOException {
            @Override
            assertNotNull("fresh replica must have a historyUUID", engine.getHistoryUUID());  
    public void testSegmentsStatsWithFileSizesPathDoesNotThrow() throws IOException {
            assertNotNull("commit stats should be available after construction", commitStats);  
            .externalRefreshListener(List.of())
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> snap = engine.acquireSnapshot()) {
import org.apache.lucene.index.IndexWriterConfig;  
     */  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
        Map<String, String> userData = new HashMap<>();
        expectThrows(org.apache.lucene.store.AlreadyClosedException.class, engine::commitStats);
        java.nio.file.Files.write(luceneOrphan, new byte[] { 1, 2, 3 });  
            .mergePolicy(NoMergePolicy.INSTANCE)
    }
    /**
import java.util.Map;
            }  
            // Apply a replication snapshot with segments
import org.opensearch.index.translog.Translog;  
     * enabled by the stats cache initialization during construction.  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
     * Without this, superseded Lucene secondary files from prior replication snapshots
            userData.put(Engine.HISTORY_UUID_KEY, historyUUID);
    public void testOperationsAfterCloseThrowAlreadyClosed() throws IOException {
            assertEquals("but local checkpoint still advances", 6L, engine.getProcessedLocalCheckpoint());
import org.opensearch.index.translog.TranslogConfig;
            assertFalse(engine.isThrottled());
    }
     * Verifies that if getLastCommittedData() throws during construction,
            engine.updateCatalogSnapshot(first);
            // The replica's index/delete/noOp methods are stubs that throw or return synthetic results.
        Path tmpDir = createTempDir();
    }  
        );
        Path writeLock = indexDir.resolve("write.lock");
            org.opensearch.index.engine.Segment replicatedSeg = segments.get(0);
            }
            assertNotNull(engine.completionStats());  
            -1,  
        deleters.get("lucene").deleteFiles(Map.of("lucene", List.of("segments_5", "write.lock")));
            assertEquals(seqNo, result.getSeqNo());
        assertTrue("write.lock must be preserved", java.nio.file.Files.exists(writeLock));
            assertNotNull(docsStats);  
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
import org.apache.lucene.index.IndexWriter;
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    private IndexSettings replicaIndexSettings() {  
    @Override
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 5L, List.of(seg));  
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 5L, List.of(seg));
                // If it doesn't throw, the result must be non-null  
            registry,
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir());
            assertNotNull("user data should be available in committed state", userData);  
    /**
            assertEquals("fresh replica should have 0 segments", 0, segments.size());
            SegmentsStats updatedStats = engine.segmentsStats(false, false);  
 * paths without relying on DFA integration tests.  
        engine.close();
            DataformatAwareCatalogSnapshot second = buildReplicationSnapshot(2L, 2L, 10L, null);  
    public void testAcquireSnapshotReturnsLatest() throws IOException {  
     * Verifies that flush operations result in properly committed segments,
            assertEquals(0L, docsStats.getDeleted());
    }
        assertTrue("segments_N must be preserved", java.nio.file.Files.exists(segmentsCommit));  
        // Second fail — must be a no-op (already failed).
    }  
            assertEquals("segments count should be updated after replication", 1, updatedStats.getCount());
            );
            org.opensearch.index.engine.Segment flushedSeg = segments.get(0);
            CommitStats commitStats = engine.commitStats();
            );
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            // This is verified by checking that commitStats() works (doesn't throw)
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
    public void testCreateEngine() throws IOException {
            new DummyShardLock(shardId),
    }
                    1L,  
            engine.updateCatalogSnapshot(second);
        DataFormatAwareNRTReplicationEngine engine,
            // DFA replica engines don't merge. Must not throw.
        engine.updateCatalogSnapshot(incoming);
        // Commit files MUST be preserved by the Lucene deleter even if listed.  
            assertEquals(2, stats.getCount());
    public void testReplicaWriteStubsAppendToTranslogAndAdvanceMaxSeqNo() throws IOException {
     * Verifies that the stats cache is initialized during DFANRE construction
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, engine.getPersistedLocalCheckpoint());
            assertNotNull("commit stats should be available after replication", commitStats);
        }  
        engine.failEngine("corruption", new CorruptIndexException("simulated", "test"));
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir());
            Store.OnClose.EMPTY,  
    }
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
        Path tmpDir = createTempDir();  
            assertNotNull(op);  
            .tombstoneDocSupplier(tombstoneDocSupplier())
    }
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
        java.nio.file.Files.write(parquetOrphan, new byte[] { 4, 5, 6 });
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
        snapshot.setLastCommitInfo("segments_" + gen, gen, 0L);  
            DataformatAwareCatalogSnapshot incoming = buildReplicationSnapshot(1L, 1L, 5L, UUID.randomUUID().toString());
            id,
 *
import org.opensearch.Version;
            List.of(new MockSearchBackEndPlugin(List.of("lucene", "parquet")))  
    }  
            // lastRefreshedCheckpoint may be -1 (NO_OPS_PERFORMED) or 0 depending on initialization  
            false  
            WriterFileSet wfs = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("seg1.mock").addNumRows(5).build();
 * Exercises constructor, replication-snapshot application, commit, write-stubs, and close
    }
        }
            WriterFileSet wfs2 = WriterFileSet.builder().directory(tmpDir).writerGeneration(2L).addFile("seg2.mock").addNumRows(7).build();
                    SequenceNumbers.UNASSIGNED_SEQ_NO,
            // Validate they don't blow up the JVM and return some result (or throw a known type).  
        engine.failEngine("second-fail", new IOException("ignored"));  
            store.close();
    }  
            Segment seg1 = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs1).build();
    public void testUpdateCatalogSnapshotWithoutHistoryUUIDPreservesExisting() throws IOException {  
            // Verify segments are committed after flush  
            assertEquals("should have 1 segment after flush", 1, segments.size());
import org.opensearch.common.lucene.uid.Versions;
        java.nio.file.Files.createDirectories(indexDir);
import java.io.IOException;
            org.opensearch.index.merge.MergeStats stats = engine.getMergeStats();
        }
            seqNo,  
            engine.updateCatalogSnapshot(first);
    /**
     */  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
    public void testFailEngineAndDoubleFailIsNoOp() throws Exception {
    private DataFormatRegistry createMockRegistry() {
            );  
    }
            engine.updateCatalogSnapshot(first);
            // Second snapshot with a different generation must force a flush-and-roll.  
        // First fail — must close the engine.
            .indexSettings(indexSettings)  
        super.tearDown();
    public void testDocStatsReflectsReplicatedSnapshot() throws IOException {
    }
    public void testUpdateCatalogSnapshotDoesNotRecommitOnSameGeneration() throws IOException {
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));  
            assertEquals("historyUUID must be preserved when incoming has none", originalUUID, engine.getHistoryUUID());
import org.opensearch.index.store.FsDirectoryFactory;
            // Second snapshot at seqNo 10 (advances)
        }
            SegmentsStats stats = engine.segmentsStats(true, false);
            terminate(threadPool);  
        }  
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
            assertNotNull("write must record a translog location", result.getTranslogLocation());
            .readOnlyReplica(true)
        Path parquetDir = root.resolve("parquet");  
    }  
            gen,  
    private EngineConfig buildReplicaConfig(Path translogPath) {
        // close() internally calls commitCatalogSnapshot → closeNoLock → IOUtils.close(...)  
            assertNotNull("config() must return a non-null EngineConfig", engine.config());  
    public void testUpdateCatalogSnapshotAdvancesCheckpointAndHistoryUUID() throws IOException {
            shardId,
        deleters.get("lucene").deleteFiles(Map.of("lucene", List.of("_stale_orphan.si")));  
            gen,  
            .internalRefreshListener(List.of())  
            Engine.Delete op = engine.prepareDelete(
            }
        // Plant files in each format's directory and verify the respective deleter removes them.  
        }
        Path parquetOrphan = parquetDir.resolve("stale.parquet");
        assertTrue("parquet deleter must be present", deleters.containsKey("parquet"));  
public class DataFormatAwareNRTReplicationEngineTests extends OpenSearchTestCase {
        Path tmpDir = createTempDir();
    public void testTranslogManagerAccessor() throws IOException {
            engine.writeIndexingBuffer();
}  
            }
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> safe = engine.acquireSafeCatalogSnapshot()) {
            assertNotNull(engine.commitStats());
        }  
            .build();
        shardId = new ShardId(new Index("test", "_na_"), 0);
    }
import org.opensearch.common.lucene.Lucene;
import org.opensearch.index.mapper.Uid;  
        }  
    }
        }
    }
        return new Engine.Index(  
import org.opensearch.index.engine.exec.Segment;
    private DataFormatAwareNRTReplicationEngine createReplicaEngine(Path translogPath) throws IOException {
    }  
            Engine.Operation.Origin.REPLICA,
            assertEquals(1, engine.segmentsStats(false, false).getCount());  
        engine.close();
            DataformatAwareCatalogSnapshot second = buildReplicationSnapshot(2L, 2L, 10L, null);
        );
    public void testPrepareDeleteBuildsValidDeleteOp() throws IOException {  
            long minRetained = engine.getMinRetainedSeqNo();
            assertEquals(0, engine.countNumberOfHistoryOperations("test", 0L, Long.MAX_VALUE));
            assertNotNull("docs stats should be initialized", engine.docStats());  
        );
import org.opensearch.threadpool.ThreadPool;
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(
 * Unit tests for {@link DataFormatAwareNRTReplicationEngine}.
        primaryTerm = new AtomicLong(randomLongBetween(1, Long.MAX_VALUE));  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            assertFalse("replica must always report no-op for maybeRefresh", engine.maybeRefresh("noop"));
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;  
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(translogPath);
            Map<String, String> userData = commitStats.getUserData();
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;
import org.opensearch.index.engine.exec.WriterFileSet;
        MockDataFormat luceneLike = new MockDataFormat("lucene", 100L, Set.of());
    public void testBuildReplicaFileDeletersCoversLuceneAndNonDefaultFormats() throws IOException {
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            IndexWriter writer = new IndexWriter(
        CommitterFactory committerFactory = config -> new InMemoryCommitter(store);  
    }
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")  
            DataformatAwareCatalogSnapshot resend = buildReplicationSnapshot(1L, 1L, 6L, null);
    }
    }
     * Verifies that after replication, segments are properly committed due to  
        store = createStore();
import org.opensearch.index.mapper.IdFieldMapper;
    public void testAcquireLastIndexCommitReturnsBootstrapCommit() throws IOException {  
            assertTrue("user data should contain translog UUID", userData.containsKey(Translog.TRANSLOG_UUID_KEY));
import java.util.concurrent.atomic.AtomicLong;
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
import org.opensearch.index.mapper.ParsedDocument;
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
            .tombstoneDocSupplier(tombstoneDocSupplier())
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
            // Must not throw
            org.opensearch.index.shard.DocsStats docsStats = engine.docStats();
import java.util.List;
        );
            DataformatAwareCatalogSnapshot first = buildReplicationSnapshot(1L, 1L, 5L, UUID.randomUUID().toString());
/**  
            commitData.put(Engine.HISTORY_UUID_KEY, UUID.randomUUID().toString());
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(mockPlugin));
            // Fresh replica: localCheckpoint = NO_OPS_PERFORMED (-1), no segments → 0 docs
            assertEquals("initial segments count should be 0", 0, engine.segmentsStats(false, false).getCount());
            DataformatAwareCatalogSnapshot first = buildReplicationSnapshot(1L, 1L, 5L, UUID.randomUUID().toString());  
    public void testConstructorInitializesStatsCacheWithCommittedState() throws IOException {
            engine.updateCatalogSnapshot(incoming);  
import org.opensearch.threadpool.TestThreadPool;
import java.util.Set;  
            assertFalse("historyUUID must not be empty", engine.getHistoryUUID().isEmpty());
                org.apache.lucene.util.Version.LATEST.major
    // ---------- Tests ----------
                    Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
            engine.updateCatalogSnapshot(incoming);
            // Completion + segments stats — must return non-null without throwing
                org.opensearch.index.VersionType.EXTERNAL,
            WriterFileSet wfs = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("test.mock").addNumRows(3).build();  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
            .primaryTermSupplier(primaryTerm::get)  
    }  
            assertEquals("same-generation update must not advance commit generation", genAfterFirst, engine.commitStats().getGeneration());
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
            // Perform flush  
            engine.updateCatalogSnapshot(incoming);
            // First snapshot at seqNo 5  
            gen,
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(translogPath);  
                /* primaryTerm */ 1L,
            assertEquals(0L, engine.docStats().getCount());
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(maxSeqNo));
            .dataFormatRegistry(registry)
            WriterFileSet wfs1 = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("seg1.mock").addNumRows(7).build();  
    }  
            segments,
    public void testSegmentsStatsEmptyOnFreshReplica() throws IOException {  
import java.nio.file.Path;
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> snap = engine.acquireSnapshot()) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
import org.apache.lucene.index.CorruptIndexException;
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));  
            SegmentsStats stats = engine.segmentsStats(false, false);
            );
    }  
        }
            assertNotNull("translogManager must be available on a fresh engine", engine.translogManager());  
            DataformatAwareCatalogSnapshot noUUID = buildReplicationSnapshot(1L, 1L, 5L, /* historyUUID= */ null);  
            WriterFileSet wfs = WriterFileSet.builder().directory(tmpDir).writerGeneration(1L).addFile("test.mock").addNumRows(5).build();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
            // Initial state - cache should be initialized with empty stats  
            DataformatAwareCatalogSnapshot incoming = buildReplicationSnapshot(1L, 1L, maxSeqNo, newHistoryUUID);  
     *  (b) guard against deleting commit files ({@code segments_*}, {@code write.lock})  
import org.opensearch.index.engine.exec.FileDeleter;  
        engine.close();  
            assertNotNull("stats cache should be initialized", engine.segmentsStats(false, false));
            // After commit, a segments_N file with these bytes is written. A subsequent
            .threadPool(threadPool)
        engine.close();
    public void testFlushResultsInCommittedSegmentsDueToConstructorInit() throws IOException {
     * the engine constructor fails and resources are cleaned up.
    // ---------- Stats / introspection methods (cheap O(1) returns) ----------
import org.opensearch.index.shard.ShardPath;  
        Path tmpDir = createTempDir();  
        engine.close();
import org.opensearch.core.index.shard.ShardId;
    }
            long genAfterFirst = engine.commitStats().getGeneration();
    public void testAcquireSafeCatalogSnapshotReturnsLatestForFreshEngine() throws IOException {
            Segment seg = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs).build();  
            // Replica can't ACTIVELY index/delete/noOp — those go through prepareIndex on the primary.
    }
        }
            List.of(MockDataFormatPlugin.of(luceneLike), MockDataFormatPlugin.of(parquetLike))  
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
            userData  
        EngineConfig failingConfig = new EngineConfig.Builder().shardId(shardId)
        engine.failEngine("first-fail", new IOException("simulated"));  
            assertTrue("Segment should be committed after flush", flushedSeg.committed);  
        }
    }
    }  
    public void setUp() throws Exception {  
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
            DataformatAwareCatalogSnapshot incoming = buildSnapshotWithSegments(engine, 1L, 1L, 10L, List.of(seg));
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
        return new EngineConfig.Builder().shardId(shardId)
            engine.updateCatalogSnapshot(incoming);  
            // prepareIndex requires a non-null docMapper to parse the source
                // Either is acceptable for a replica stub  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(
                /* seqNo */ 7L,
        bootstrapStoreWithMetadata(store, UUID.randomUUID().toString());
    }  
import org.opensearch.index.IndexSettings;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
            assertFalse("replica must never report needing a refresh", engine.refreshNeeded());  
        }
            .indexSettings(replicaIndexSettings())  
import org.opensearch.plugins.PluginsService;
        assertTrue("lucene deleter must be present", deleters.containsKey("lucene"));
            assertEquals(0, stats.getCount());  
            assertEquals(0, engine.segmentsStats(false, false).getCount());
        assertFalse("parquet deleter must physically remove the orphan", java.nio.file.Files.exists(parquetOrphan));
 */
 * this file be licensed under the Apache-2.0 license or a
        Map<String, String> userData = new HashMap<>();
    private ShardId shardId;  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
        }  
        DataFormatRegistry registry = createMockRegistry();
            "test",  
        long maxSeqNo,
            long lrc = engine.lastRefreshedCheckpoint();
            } catch (UnsupportedOperationException | NullPointerException expected) {
            // by checking that it returns valid (non-null) stats
        try (
        }  
    }  
import static org.opensearch.index.engine.EngineTestCase.createParsedDoc;
                /* version */ 1L,  
        ShardPath shardPath = new ShardPath(false, path, path, shardId);  
        }  
        java.nio.file.Files.createDirectories(parquetDir);
        );
            assertEquals(0L, stats.getDeleted());
            .threadPool(threadPool)
    }
    private Store store;
import org.opensearch.index.store.Store;
            // Refresh / writeIndexingBuffer must be no-ops (don't throw)  
     * File-deleter map must include BOTH Lucene and non-default formats.  
            engine.updateCatalogSnapshot(incoming);  
    @Override
                () -> engine.prepareIndex(
            // Verify commit stats reflect the committed state  
        expectThrows(Exception.class, () -> new DataFormatAwareNRTReplicationEngine(failingConfig));
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
            writer.commit();  
    }  
        return new DataFormatAwareNRTReplicationEngine(buildReplicaConfig(translogPath));
            long maxSeqNo = 42L;
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
    public void testStatsAndStubMethodsReturnDefaultValues() throws IOException {  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(tmpDir)) {
            // Snapshot with no HISTORY_UUID_KEY in userData — must NOT overwrite the existing uuid.
                "lastRefreshedCheckpoint must be non-negative or NO_OPS_PERFORMED",  
            List<org.opensearch.index.engine.Segment> segments = engine.segments(false);  
        snapshot.setLastCommitInfo("segments_" + gen, gen, 0L);  
        userData.put(Engine.HISTORY_UUID_KEY, engine.getHistoryUUID());  
                minRetained == SequenceNumbers.NO_OPS_PERFORMED || minRetained >= 0
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, "-1");  
        engine.close();
                assertNotNull(safe.get());
     * the stats cache initialization during construction.
    // the replica's commitCatalogSnapshot sets nextWriteGeneration from the CatalogSnapshot's
    /** Writes a Lucene commit so the engine's store bootstrap finds valid userData. */
        return snapshot;
        assertFalse("lucene deleter must physically remove the orphan", java.nio.file.Files.exists(luceneOrphan));
    // generation, which can collide with the bootstrap Lucene commit state. End-to-end flush  
    /**  
        // Must not throw — silently skips.  
        }  
    }
    public void testMaybeFailEngineOnCorruption() throws Exception {
            // For a fresh replica, segments list should be empty but cache should be committed/initialized  
        try {  
            assertEquals("should have 1 segment after replication", 1, segments.size());  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(
    /**  
        MockDataFormat parquetLike = new MockDataFormat("parquet", 50L, Set.of());  
                org.opensearch.common.xcontent.XContentType.JSON
    }
            assertTrue("Segment should be searchable after flush", flushedSeg.search);
            Segment seg = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs).build();
            engine.forceMerge(false, 1, false, false, false, "test-uuid");  
            expectThrows(UnsupportedOperationException.class, engine::acquireSafeIndexCommit);
        Path luceneOrphan = indexDir.resolve("_stale_orphan.si");
     * via replication, ensuring the cache initialization during construction enables  
    public void testCommitStatsReturnsCommitData() throws IOException {
import org.opensearch.common.settings.Settings;  
            false,
            // Verify segments are properly committed after construction
            List.of(new MockSearchBackEndPlugin(List.of(mockDataFormat.name())))  
        assertNotNull(e.getMessage());
    // behavior is covered by the DFA ITs (DataFormatAwareReplicationIT, DataFormatAwareUploadIT).
        expectThrows(AlreadyClosedException.class, engine::ensureOpen);
    public void testFlushAndCloseOnAlreadyClosedEngine() throws Exception {
            try {
            org.opensearch.index.mapper.SourceToParse source = new org.opensearch.index.mapper.SourceToParse(
    private DataformatAwareCatalogSnapshot buildSnapshotWithSegments(
            assertEquals(0, stats.getCount());
        }  
                /* ifSeqNo */ SequenceNumbers.UNASSIGNED_SEQ_NO,  
            // Verify that the stats cache was initialized during construction  
        if (historyUUID != null) {  
            assertEquals(7L, op.seqNo());
        Path translogPath = createTempDir().resolve("translog");  
            assertEquals("initial docs count should be 0", 0L, engine.docStats().getCount());
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
        DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(translogPath);
    public void testMaybePruneDeletesIsNoOp() throws IOException {
            DataformatAwareCatalogSnapshot first = buildReplicationSnapshot(1L, 1L, 5L, UUID.randomUUID().toString());  
            engine.maybePruneDeletes();
            null,  
                // Replicas don't produce upload metadata bytes — that's the primary's job.  
            .primaryTermSupplier(primaryTerm::get)  
        bootstrapStoreWithMetadata(store, uuid);  
                    5L,
                throw new RuntimeException("Simulated failure in getLastCommittedData");  
            Segment seg = Segment.builder(1L).addSearchableFiles(mockDataFormat, wfs).build();
            engine.refresh("noop-refresh");
            try (org.opensearch.common.concurrent.GatedCloseable<CatalogSnapshot> last = engine.acquireLastCommittedSnapshot(false)) {  
            .mergePolicy(NoMergePolicy.INSTANCE)
                new org.opensearch.core.common.bytes.BytesArray("{}"),
            gen,
    // ---------- Constructor and stats cache initialization tests ----------
                expectThrows(UnsupportedOperationException.class, () -> engine.serializeSnapshotToRemoteMetadata(snap.get()));
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
        }
                NullPointerException.class,  
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {  
            CommitStats commitStats = engine.commitStats();
    }  
    }  
        threadPool = new TestThreadPool(getClass().getName());  
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(maxSeqNo));
    public void testFlushAndClose() throws Exception {  
            assertEquals(SequenceNumbers.NO_OPS_PERFORMED, info.localCheckpoint);  
        super.setUp();
        DataformatAwareCatalogSnapshot snapshot = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(  
    private void bootstrapStoreWithMetadata(Store store, String translogUUID) throws IOException {  
        );
    }  
            CommitStats commitStats = engine.commitStats();  
        PluginsService pluginsService = mock(PluginsService.class);
            // and is functioning correctly for subsequent operations
    private DataformatAwareCatalogSnapshot buildReplicationSnapshot(long id, long gen, long maxSeqNo, String historyUUID) {
            assertEquals(0L, stats.getTotal());  
            assertNotNull("historyUUID must be assigned", engine.getHistoryUUID());
        try (DataFormatAwareNRTReplicationEngine engine = createReplicaEngine(createTempDir())) {
                Engine.Operation.Origin.PRIMARY,
import org.opensearch.index.engine.dataformat.DataFormatPlugin;  
            Segment seg2 = Segment.builder(2L).addSearchableFiles(mockDataFormat, wfs2).build();  
     * Verifies that the statsCache is properly updated when catalog snapshots change
        // SegRep must be enabled for EngineConfig.isReadOnlyReplica() to return true.
            engine.updateCatalogSnapshot(incoming);
            );
    public void testConfigReturnsConstructorConfig() throws IOException {
        Path translogPath = createTempDir().resolve("translog");
            assertFalse(engine.shouldPeriodicallyFlush());
        // Advance the catalog generation so the close-time commit writes a new segments_N.  
            indexSettings,  
            List<org.opensearch.index.engine.Segment> segments = engine.segments(false);
import org.opensearch.test.OpenSearchTestCase;  
            )  
            assertTrue(
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            0  
        mockDataFormat = new MockDataFormat("composite", 100L, Set.of());
    public void testGetSafeCommitInfoReturnsTrackerCheckpointAndZeroDocsForEmptySnapshot() throws IOException {
        return IndexSettingsModule.newIndexSettings(
            // Verify the commit stats show committed state
            assertNotNull(engine.translogManager());  
    public void testDocStatsZeroForFreshReplica() throws IOException {
    public void testCheckpointAccessorsOnFreshEngine() throws IOException {
                assertNotNull(snap.get());  
    public void testEnsureOpenThrowsAlreadyClosedAfterClose() throws IOException {  
            engine.updateCatalogSnapshot(incoming);
