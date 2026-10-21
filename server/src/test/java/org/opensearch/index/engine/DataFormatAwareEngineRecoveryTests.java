        ParsedDocument doc = createParsedDocWithInput(translogOp.id());
                    .mapToLong(org.opensearch.index.engine.exec.WriterFileSet::numRows)
    private MockDataFormat mockDataFormat;
        private final long initialCommitGeneration;
        }
            int recovered = recoverFromTranslog(engine);
    // ---- Committer that persists to Lucene (survives engine reopen) ----
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
                long totalRows = snapshot.getSegments()
        // Second lifecycle: recover (flush happens), close
        }
            TranslogStats afterStats = engine.translogManager().getTranslogStats();
    private AtomicLong globalCheckpoint;
            }
        }
            engine.flush(false, true);
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        final int docs = randomIntBetween(5, 20);
     * DFA-specific: Verify that after recovery and refresh, the catalog snapshot
                    serialized,
import java.util.concurrent.atomic.AtomicLong;
            int numCycles = randomIntBetween(3, 5);
                List<org.opensearch.index.engine.exec.Segment> segments = snapshot.getSegments();
        try (DataFormatAwareEngine engine = createEngine()) {
                threads[t] = new Thread(() -> {
    /**
            recoverFromTranslog(engine);
                threads[t].start();
import static org.hamcrest.Matchers.greaterThan;
            int ops = 0;
            }
                assertThat(snapshot, org.hamcrest.Matchers.notNullValue());
        }
     * with flush each time must correctly propagate the catalog snapshot.
     * an initial empty snapshot with correct lastCommitGeneration so the engine can open.
        }
        final int docs = randomIntBetween(10, 50);
            String serialized = committedData.get(CatalogSnapshot.CATALOG_SNAPSHOT_KEY);
                        Map.Entry::getValue,
                CatalogSnapshot snapshot = ref.get();
            int recovered = engine.translogManager().recoverFromTranslog(snapshot -> {
    static class PersistentCommitter implements Committer {
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
    /**
            recoverFromTranslog(engine);
    }
import org.opensearch.index.mapper.Uid;
                    0L
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            }
                return ops;
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        );
            }, engine.getProcessedLocalCheckpoint(), recoverUpTo);
            .externalRefreshListener(List.of())
            assertThat("should recover all docs", recovered, equalTo(docs));
                // Snapshot should have files for our format
                    .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
                engine.index(indexOp(Integer.toString(i)));
            // Index more WITHOUT flush — these are only in translog
                Map<String, java.util.Collection<String>> filesByFormat = snapshot.getFilesByFormat();
                    .sum();
        primaryTerm = new AtomicLong(1);
            engine.flush(false, true);
            engine.refresh("before-flush");
     *
        ) {
    private ShardId shardId;
            .mergePolicy(NoMergePolicy.INSTANCE)
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
        @Override
                    engine.flush(false, true);
        @Override
     * After recovery and refresh, docStats().getCount() must equal the total number
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            indexSettings,
                // Carry forward the commit info from the Lucene commit
            new DummyShardLock(shardId),
    // ---- Recovery Tests ----
                        ops++;
import org.opensearch.common.lucene.uid.Versions;
    }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            engine.refresh("before-flush");
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;
        }
        try (DataFormatAwareEngine engine = reopenEngine()) {
            .mapperService(mapperService)
    private DataFormatRegistry createMockRegistry() {
    private MockDataFormatPlugin mockPlugin;
                }
     */
        try (DataFormatAwareEngine engine = reopenEngine()) {
            recoverFromTranslog(engine);
     * catalog snapshot survives and is correctly restored.
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            engine.refresh("post-recovery");
            assertThat("only unflushed ops should be uncommitted", stats.getUncommittedOperations(), equalTo(unflushedDocs));
        final int docsPerThread = randomIntBetween(10, 20);
import org.opensearch.index.mapper.IdFieldMapper;
        int firstBatch = randomIntBetween(5, 15);
        // First lifecycle: index docs, flush (commit), close cleanly
        }
            }
            base.getMediaType(),
     * - After recovery, ops are committed (flush triggered by onAfterTranslogRecovery)
    @Override
                assertThat("committed snapshot must have segments", snapshot.getSegments().size(), greaterThan(0));
                        engine.index(replayOp((Translog.Index) op));
                engine.index(indexOp("post_recovery_" + r));
        try (DataFormatAwareEngine engine = createEngine()) {
            // Recover
import org.opensearch.core.index.shard.ShardId;
                    store.shardFormatDirectoryResolver()
                int count = 0;
     * Simulates the production scenario where a Lucene commit exists without a serialized
            for (int i = initialDocs; i < initialDocs + newDocs; i++) {
import java.util.Map;
        shardId = new ShardId(new Index("test", "_na_"), 0);
        PersistentCommitter(Store store) throws IOException {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) docs - 1));
                engine.refresh("refresh-" + r);
     */
        return new DataFormatAwareEngine(buildEngineConfig());
     * Verify double-restart works: index → close → recover → close → recover.
            globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
        return new Engine.Index(
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    /**
                    .stream()
        try (DataFormatAwareEngine engine = reopenEngine()) {
        }
        try (DataFormatAwareEngine engine = createEngine()) {
            for (int i = 0; i < docs; i++) {
            for (int i = 0; i < 5; i++) {
            return new CommitResult("segments_1", 1L, 0L);
        }
                    engine.flush(randomBoolean(), true);
        try (DataFormatAwareEngine engine = reopenEngine()) {
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        try (DataFormatAwareEngine engine = reopenEngine()) {
            globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
            // After recovery, checkpoint should advance
            for (int i = 0; i < docs; i++) {
            }
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
     * Regression test for the CatalogSnapshotManager fix: multiple restart cycles
            }
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
    }
    /**
            engine.refresh("test");
            engine.refresh("before-flush");
import java.util.UUID;
import org.opensearch.index.store.FsDirectoryFactory;
                Map<String, java.util.Collection<String>> filesByFormat = snapshot.getFilesByFormat();
            System.nanoTime(),
            for (int i = 0; i < docs; i++) {
                        HashMap::new
            if (lastCommittedSnapshot != null) {
        }
            // Index and flush — these are committed
            );
                engine.index(indexOp(Integer.toString(i)));
            // Fresh index — no committed catalog snapshot yet. Provide an initial empty
                engine.index(indexOp(Integer.toString(i)));
            // Store the catalog snapshot if present in commit data
            }
                Translog.Operation op;
        store = createStore();
    }
            -1,
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
     * The second recovery should have nothing to replay (since the first recovery flushed).
import static org.mockito.Mockito.when;
                engine.index(indexOp(Integer.toString(i)));
    public void testReaderManagersInitializedOnRestartWithCommittedData() throws IOException {
            null,
import org.opensearch.threadpool.TestThreadPool;
    private EngineConfig buildEngineConfig() {
            int recovered = recoverFromTranslog(engine);
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
import java.util.stream.StreamSupport;
        final int docsPerThread = randomIntBetween(10, 25);
                assertThat("committed snapshot must have format files", filesByFormat.isEmpty(), equalTo(false));
     * contains segments with the correct structure.
                -1L,
        );
            this.committedData = StreamSupport.stream(commitInput.userData().spliterator(), false)
            engine.refresh("after-new-writes");
import org.opensearch.core.index.Index;
        try (DataFormatAwareEngine engine = createEngine()) {
            }
            }
            // Verify seq-no stats are consistent
            TranslogStats stats = engine.translogManager().getTranslogStats();
    public void testTranslogRecoveryWithMultipleGenerations() throws IOException {
            .primaryTermSupplier(primaryTerm::get)
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            engine.refresh("before-flush");
     */
            engine.flush(false, true);
        // Bootstrap creates a commit with NO _catalog_snapshot_ key — simulates store.createEmpty()
                        barrier.await();
            .internalRefreshListener(List.of())
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
        globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
        try (
    public void testInterleavedIndexRefreshFlushThenRecover() throws IOException {
        mockPlugin = MockDataFormatPlugin.of(mockDataFormat);
        }
            for (int i = flushedDocs; i < flushedDocs + unflushedDocs; i++) {
                        (existing, replacement) -> replacement, // Merge function for duplicate keys
        try (DataFormatAwareEngine engine = createEngine()) {
    public void testEngineIsFunctionalAfterRecovery() throws IOException {
                )
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
        }
            SegmentInfos segmentInfos = store.readLastCommittedSegmentsInfo();
        }, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        try (DataFormatAwareEngine engine = reopenEngine()) {
     * can index new docs, refresh, and flush without errors.
            }
                Translog.Operation op;
import org.opensearch.common.util.BigArrays;
            for (int i = 0; i < docs; i++) {
                    segmentInfos.getSegmentsFileName(),
                engine.index(indexOp(Integer.toString(i)));
 * Recovery tests for {@link DataFormatAwareEngine}.
        // Third lifecycle: verify accumulated snapshot
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
     * even though no translog replay or refresh occurs.
                long totalRows = snapshot.getSegments()
                    try {
            Engine.IndexResult result = engine.index(indexOp(Integer.toString(docs)));
     * After recovery, verify that a newChangesSnapshot contains all ops for the
            return List.of(initial);
     */
                engine.refresh("cycle-" + c);
                assertThat(ref.get().getSegments().size(), greaterThan(0));
            for (Thread t : threads) {
                    } catch (Exception e) {
            .store(store)
        try (DataFormatAwareEngine engine = reopenEngine()) {
        globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        try (DataFormatAwareEngine engine = reopenEngine()) {
            "",
            assertThat(commitData.get(Translog.TRANSLOG_UUID_KEY), org.hamcrest.Matchers.notNullValue());
    // ---- Store and engine creation helpers ----
            Map<String, String> commitData = new HashMap<>();
    }
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
            recoverFromTranslog(engine);
                    try {
                engine.index(indexOp(Integer.toString(i)));
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
            TranslogStats stats = engine.translogManager().getTranslogStats();
            // The committed local checkpoint should be at flushedDocs - 1
     */
        );
                assertThat("all segment generations must be unique", distinctGenerations, equalTo((long) segments.size()));
            Map<String, String> commitData = store.readLastCommittedSegmentsInfo().getUserData();
    public void testConcurrentIndexingThenRecoveryPreservesCheckpoint() throws Exception {
            Engine.Operation.Origin.PRIMARY,
            }
            writer.commit();
                0L,
import static org.hamcrest.Matchers.equalTo;
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) docs - 1));
            }
     * CatalogSnapshot (e.g. the initial commit from {@code store.createEmpty()} or a commit
                engine.index(indexOp(Integer.toString(i)));
            }
    /**
                        Map.Entry::getKey,
                this.lastCommittedSnapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
            false,
                assertThat("snapshot should have files for the data format", filesByFormat.size(), greaterThanOrEqualTo(1));
        } finally {
            accumulatedDocs += firstBatch;
 */
            assertThat("no ops should be recovered", recovered, equalTo(0));
        }
        // First lifecycle: index docs, close without flush
    }
            // Do multiple refresh cycles
        final int docs = randomIntBetween(5, 20);
            assertThat("all committed — nothing to recover", recovered, equalTo(0));
            recoverFromTranslog(engine);
            base.docs(),
            int recovered = recoverFromTranslog(engine);
            base.routing(),
    private int recoverFromTranslog(DataFormatAwareEngine engine) throws IOException {
     * After recovery, each refresh must produce segments with unique generations.
     * commits without {@code _catalog_snapshot_} get a synthetic initial snapshot seeded
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
            for (int r = 0; r < numRefreshes; r++) {
            }
                // Verify files exist in the snapshot
     */
            .committerFactory(committerFactory)
            shardId,
            assertThat("all committed — nothing to recover from translog", recovered, equalTo(0));
    /**
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
            translogOp.getAutoGeneratedIdTimestamp(),
import org.opensearch.index.mapper.ParsedDocument;
     * Verify all docs are recovered and checkpoint is correct.
import org.opensearch.common.concurrent.GatedCloseable;
    /**
                    serialized,
            ) {
                engine.index(indexOp(Integer.toString(accumulatedDocs + i)));
            }
            assertThat(recovered, equalTo(totalDocs));
                    .mapToLong(org.opensearch.index.engine.exec.WriterFileSet::numRows)
                }
            TranslogStats stats = engine.translogManager().getTranslogStats();
            "test",
     */
            // Read back the committed data (written by the PersistentCommitter to Lucene)
        }
     * Interleave indexing with random refreshes and flushes, then close and recover.
        return new DataFormatRegistry(pluginsService);
        public void deleteCommit(CatalogSnapshot snapshot) {}
            }
import org.opensearch.index.seqno.SequenceNumbers;
    }
        // Index docs and close WITHOUT flush — all ops stay in translog
                    segmentInfos.getGeneration(),
     */
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) expectedTotal - 1));
        try (DataFormatAwareEngine engine = createEngine()) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
        }
    }
                assertThat("snapshot must reflect all docs across lifecycles", totalRows, equalTo((long) expectedTotal));
                0L,
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            engine.flush(false, true);
                engine.index(indexOp(Integer.toString(i)));
        try (DataFormatAwareEngine engine = createEngine()) {
            long prevGen = -1;
     *
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            assertThat(engine.docStats().getCount(), equalTo((long) totalDocs));
        final int docs = randomIntBetween(1, 32);
     */
            translogOp.seqNo(),
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        TranslogConfig translogConfig = new TranslogConfig(
     * snapshot generations — no reuse or regression.
        threadPool = new TestThreadPool(getClass().getName());
            // successfully from the bootstrap commit that lacked it.
            for (int i = 0; i < docs; i++) {
                    .mapToLong(org.opensearch.index.engine.exec.WriterFileSet::numRows)
        @Override
     * LuceneCommitter behavior for recovery tests.
    public void testDocStatsAfterRecoveryReflectsAllDocs() throws IOException {
                IndexWriter writer = new IndexWriter(
     * Verifies no data loss under the mixed workload.
    public void testSegmentGenerationsAreUniqueAfterRecovery() throws IOException {
    public void testConcurrentIndexThenFlushAndRecover() throws Exception {
                t.join();
            IndexWriter writer = new IndexWriter(
            )
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
    }
        @Override
import java.util.HashMap;
                engine.index(indexOp(Integer.toString(i)));
            VersionType.INTERNAL,
            }
        return new EngineConfig.Builder().shardId(shardId)
            false,
            }
                .build()
    }
            }
            writer.setLiveCommitData(commitData.entrySet());
        }
    public void tearDown() throws Exception {
    public void testDoubleRecovery() throws IOException {
                Engine.IndexResult result = engine.index(indexOp(Integer.toString(i)));
                    ops++;
        final int unflushedDocs = randomIntBetween(5, 20);
    public void testRecoveryFromTranslogUpToSeqNo() throws IOException {
            globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
import org.opensearch.common.settings.Settings;
        try (DataFormatAwareEngine engine = reopenEngine()) {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) docs - 1));
        ShardPath shardPath = new ShardPath(false, path, path, shardId);
            DataformatAwareCatalogSnapshot initial = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
        // Reopen — should only need to replay unflushedDocs
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            }
        );
            .globalCheckpointSupplier(globalCheckpoint::get)
            }
    public void testRecoveryFlushWritesCorrectCommitData() throws IOException {
        public boolean isCommitManagedFile(String fileName) {
            for (int i = 0; i < flushedDocs; i++) {
     * DFA-specific: After recovery, verify the engine is fully functional —
        try (DataFormatAwareEngine engine = createEngine()) {
                ((DataformatAwareCatalogSnapshot) this.lastCommittedSnapshot).setLastCommitInfo(
            .threadPool(threadPool)
            }
import org.opensearch.common.unit.TimeValue;
            .indexSettings(indexSettings)
    private Path translogPath;
     * Index docs, close engine (without flush — all ops are in translog only),
            new FsDirectoryFactory()
        }
            accumulatedDocs += secondBatch;
                    .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
            translogPath,
        int secondBatch = randomIntBetween(5, 15);
        // or a pre-DFA engine commit.
            Settings.builder()
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
        @Override
            for (int t = 0; t < numThreads; t++) {
            globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
import org.opensearch.index.engine.exec.commit.CommitterFactory;
        @Override
     */
                    long currentGen = ref.get().getGeneration();
        try (DataFormatAwareEngine engine = reopenEngine()) {
                    } catch (Exception e) {
            false
                        for (int d = 0; d < docsPerThread; d++) {
            return ops;
            Thread[] threads = new Thread[numThreads];
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
                CatalogSnapshot snapshot = ref.get();
     * reopen, recover. Verify:
        }
        // First lifecycle
            .translogConfig(translogConfig)
            initial.setLastCommitInfo("segments_" + initialCommitGeneration, initialCommitGeneration, 0L);
            base.id(),
                        }
            Settings.builder()
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                engine.index(indexOp(Integer.toString(i)));
            }
        try (DataFormatAwareEngine engine = createEngine()) {
            assertThat(engine.getSeqNoStats(-1).getMaxSeqNo(), equalTo((long) docs - 1));
                    assertThat(op.seqNo(), greaterThanOrEqualTo(0L));
                    new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
        // Reopen — translog should have all ops as uncommitted
import org.opensearch.test.IndexSettingsModule;
     *
        }
import java.util.Set;
            this.initialCommitGeneration = segmentInfos.getGeneration();
        }
            base.version(),
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, "-1");
    public void testRecoveryOnlyReplaysUnflushedOps() throws IOException {
            // recoverFromTranslog triggers onAfterTranslogRecovery → flush, which writes
import org.apache.lucene.store.Directory;
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) (flushedDocs + unflushedDocs - 1)));
            store.close();
    }
                engine.index(indexOp(Integer.toString(accumulatedDocs + i)));
                if (rarely()) {
     * so it survives engine close/reopen. This simulates the production
import java.util.concurrent.CyclicBarrier;
     *
        }
                assertThat(snapshot.getSegments().size(), greaterThan(0));
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            int recovered = recoverFromTranslog(engine);
            // Engine should be fully functional for new writes
        final int numThreads = randomIntBetween(2, 4);
        );
import org.opensearch.common.lucene.Lucene;
    }
        final int numThreads = randomIntBetween(2, 4);
            Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
            return null;
     * Mirrors InternalEngineTests.testTranslogRecoveryWithMultipleGenerations (L1059).
            assertThat(commitData.get(Engine.HISTORY_UUID_KEY), org.hamcrest.Matchers.notNullValue());
        try (DataFormatAwareEngine engine = createEngine()) {
    }
                t.join();
        private final Store store;
        final int docs = randomIntBetween(5, 20);
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
        mockDataFormat = new MockDataFormat("composite", 100L, Set.of());
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        // Reopen and recover
                    )
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            while ((op = snapshot.next()) != null) {
    public void setUp() throws Exception {
            int numRefreshes = randomIntBetween(3, 6);
            0
            for (int i = 0; i < secondBatch; i++) {
                CatalogSnapshot snapshot = ref.get();
            int recovered = recoverFromTranslog(engine);
        int recovered = engine.translogManager().recoverFromTranslog(snapshot -> {
        }
        }
            return committedData;
import org.opensearch.index.IndexSettings;
import org.opensearch.index.shard.ShardPath;
            // No flush — close with everything in translog
                } else if (rarely()) {
import org.opensearch.index.translog.TranslogConfig;
        }
    }
                CatalogSnapshot snapshot = ref.get();
                    .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
     * from the on-disk segments_N generation.
            }
     * DFA-specific: Verify that the committed data after recovery contains
        final int unflushedDocs = randomIntBetween(5, 15);
                if (randomIntBetween(1, 10) == 1) {
                .collect(
        final int docs = randomIntBetween(10, 30);
            indexSettings,
        super.tearDown();
    }
import org.opensearch.plugins.SearchBackEndPlugin;
        }
    /**
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            int newDocs = randomIntBetween(5, 20);
     * - Replayed ops are NOT double-written to translog
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
    }
     * Index docs with random flushes and translog rolls, close, reopen, recover.
                engine.index(indexOp("post_" + c));
            for (int i = flushedDocs; i < totalDocs; i++) {
                }
            return false;
     */
                if (op instanceof Translog.Index) {
            globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
     * Index docs, recover up to a partial seqNo (simulating recovery up to globalCheckpoint).
            String serialized = committedData.get(CatalogSnapshot.CATALOG_SNAPSHOT_KEY);
            engine.refresh("test");
import org.opensearch.index.mapper.SeqNoFieldMapper;
            }
            null,
                    if (op instanceof Translog.Index) {
 *
     * - Translog has uncommitted ops before recovery
    public void testEngineOpensWithCommitLackingCatalogSnapshot() throws IOException {
                });
                assertThat(ref.get().getSegments().size(), greaterThan(0));
     * written by a non-DFA engine before migration). The PersistentCommitter must synthesize
    }
                .build()
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;
import org.opensearch.test.DummyShardLock;
            doc,
        CommitterFactory committerFactory = config -> new PersistentCommitter(store);
        // Recover up to a partial seqNo
            }
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) (initialDocs + newDocs - 1)));
        super.setUp();
            commitData.put(Engine.HISTORY_UUID_KEY, UUID.randomUUID().toString());
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
     * This mirrors the handling in {@code LuceneCommitter.loadCommittedSnapshots()} where
                engine.index(indexOp(Integer.toString(i)));
                committedData
        PluginsService pluginsService = mock(PluginsService.class);
    private ThreadPool threadPool;
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
            recoverFromTranslog(engine);
import org.opensearch.plugins.PluginsService;
            Store.OnClose.EMPTY,
import org.opensearch.index.engine.exec.commit.Committer.CommitResult;
                engine.index(indexOp(Integer.toString(i)));
            AtomicInteger failures = new AtomicInteger(0);
        // Third lifecycle: should have nothing to recover
        }
            assertThat("all ops should be uncommitted in translog", stats.getUncommittedOperations(), equalTo(docs));
        public byte[] serializeToCommitFormat(CatalogSnapshot catalogSnapshot) throws IOException {
        final int expectedTotal = accumulatedDocs;
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) docs - 1));
            List.of(new MockSearchBackEndPlugin(List.of(mockDataFormat.name())))
    /**
        try (DataFormatAwareEngine engine = reopenEngine()) {
                        failures.incrementAndGet();
import org.opensearch.Version;
            int recovered = recoverFromTranslog(engine);
    }
    private DataFormatAwareEngine createEngine() throws IOException {
            // DO NOT flush — close with data only in translog
    }
    /**
        }
            assertThat(commitData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY), equalTo(Long.toString(docs - 1)));
        }
            }
            }
            for (int i = 0; i < firstBatch; i++) {
                engine.index(indexOp(Integer.toString(i)));
     *
     * The reader managers must be notified about existing committed segments
            // snapshot so CatalogSnapshotManager can be constructed (it requires non-empty).
        @Override
     * DFA-specific: Index docs, flush (commit), index more without flush, close, reopen.
                );
                long distinctGenerations = segments.stream().map(org.opensearch.index.engine.exec.Segment::generation).distinct().count();
            }
        ParsedDocument base = createParsedDoc(id, null);
            dir,
            int recovered = recoverFromTranslog(engine);
    /**
    private Store createStore() throws IOException {
        bootstrapStore(store, uuid);
        }
                    prevGen = currentGen;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            for (int i = 0; i < flushedDocs; i++) {
        private volatile Map<String, String> committedData;
        DataFormatRegistry registry = createMockRegistry();
            }
            terminate(threadPool);
                    engine.index(replayOp((Translog.Index) op));
    }
            // Deserialize existing catalog snapshot if present
            globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
     * Only the unflushed docs should be replayed from translog.
            shardPath,
     */
        }
        Directory dir = newDirectory();
                    }
            AtomicInteger failures = new AtomicInteger(0);
     * full seq-no range — confirms no operations were lost during the recovery cycle.
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(
            }
                        failures.incrementAndGet();
            0
        }
            }
        }
        int accumulatedDocs = 0;
    /**
        try (DataFormatAwareEngine engine = reopenEngine()) {
    public void testMultipleFlushRestartCyclesAccumulateData() throws IOException {
        try (DataFormatAwareEngine engine = createEngine()) {
            if (serialized != null) {
                            engine.index(indexOp(threadId + "_" + d));
        DocumentMapper documentMapper = mock(DocumentMapper.class);
    }
        try (DataFormatAwareEngine engine = createEngine()) {
    }
    public void testTranslogSnapshotContainsAllOpsAfterRecovery() throws IOException {
        // Second lifecycle: reopen with committed data, empty translog
    /**
                }
            "test",
            translogOp.primaryTerm(),
                }
            engine.refresh("flush-2");
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    /**
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        try (DataFormatAwareEngine engine = reopenEngine()) {
                            engine.index(indexOp(threadId + "_" + d));
    /**
     * Without the fix in CatalogSnapshotManager, the afterRefresh callback
            try (
    private void bootstrapStore(Store store, String translogUUID) throws IOException {
 * after engine close/reopen.
        }
        try (DataFormatAwareEngine engine = reopenEngine()) {
 * Mirrors the recovery test patterns from {@code InternalEngineTests} (L1024-1133)
import org.opensearch.index.mapper.MapperService;
                CatalogSnapshot snapshot = ref.get();
        }
     */
        final int docs = randomIntBetween(10, 40);
            System.nanoTime(),
        Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
            // Recover — this replays ops and triggers flush via onAfterTranslogRecovery
            this.committedData = Map.copyOf(segmentInfos.getUserData());
import org.apache.lucene.index.NoMergePolicy;
        try (DataFormatAwareEngine engine = reopenEngine()) {
     */
        final long recoverUpTo = randomLongBetween(0, docs - 1);
                return List.of(lastCommittedSnapshot);
        MapperService mapperService = mock(MapperService.class);
    /**
                }
            .tombstoneDocSupplier(tombstoneDocSupplier())
            // Refresh should produce segments
                if (randomIntBetween(1, 15) == 1) {
            for (int c = 0; c < numCycles; c++) {
            // onAfterTranslogRecovery triggers flush, which writes commit data
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
     */
     * After recovery, subsequent refreshes must produce monotonically increasing
import org.opensearch.threadpool.ThreadPool;
    }
 */
            // After recovery + refresh, segments should exist in the catalog snapshot
     * Verify checkpoint advances only to the recovered seqNo.
                assertThat(snapshot.getSegments().size(), greaterThan(0));
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(recoverUpTo));
            base.source(),
     * of indexed documents (committed + recovered).
        final int totalDocs = flushedDocs + unflushedDocs;
                });
    }
    private AtomicLong primaryTerm;
            primaryTerm.get(),
            assertThat(failures.get(), equalTo(0));
        final int docs = randomIntBetween(10, 100);
            for (Thread t : threads) {
        final int flushedDocs = randomIntBetween(5, 20);
            }
            assertThat(recovered, equalTo((int) (recoverUpTo + 1)));
            if (serialized != null) {
        final int docs = randomIntBetween(5, 20);
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        }
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
        final int flushedDocs = randomIntBetween(5, 15);
        public void close() {}
import java.nio.file.Path;
        try (DataFormatAwareEngine engine = createEngine()) {
 * The OpenSearch Contributors require contributions made to
            for (int i = 0; i < docs; i++) {
                writer.setLiveCommitData(commitInput.userData());
            }
                assertThat("committed snapshot must have segments", snapshot.getSegments().size(), greaterThan(0));
            try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, docs - 1, false, true)) {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) flushedDocs - 1));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                    }
                writer.commit();
    @Override
    private DataFormatAwareEngine reopenEngine() throws IOException {
import org.opensearch.index.seqno.RetentionLeases;
    private Engine.Index indexOp(String id) {
                CatalogSnapshot snapshot = ref.get();
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        return new DataFormatAwareEngine(buildEngineConfig());
        final int docs = randomIntBetween(5, 30);
            assertThat("translog should be trimmed after recovery flush", afterStats.getUncommittedOperations(), equalTo(0));
        }
            // Translog should be trimmed after recovery flush
        }
import org.opensearch.index.translog.Translog;
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
            // The catalog snapshot should have segments from the committed data
            recoverFromTranslog(engine);
                threads[t].start();
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            engine.refresh("test");
        }
            // Engine is functional — can index and refresh
     * would never fire and reader managers would have no open readers.
        try (DataFormatAwareEngine engine = createEngine()) {
import java.util.List;
            assertThat("nothing to recover — all committed", recovered, equalTo(0));
                long totalRows = snapshot.getSegments()
            for (int i = 0; i < initialDocs; i++) {
        translogPath = createTempDir("translog");
                    .sum();
import java.util.concurrent.atomic.AtomicInteger;
        );
            SequenceNumbers.UNASSIGNED_SEQ_NO,
                final int threadId = t;
import java.util.stream.Collectors;
            recoverFromTranslog(engine);
import org.apache.lucene.index.IndexWriter;
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
import static org.opensearch.index.engine.EngineTestCase.createParsedDoc;
     * all required metadata keys for subsequent recovery.
        try (DataFormatAwareEngine engine = createEngine()) {
            for (int t = 0; t < numThreads; t++) {
        }
            }
 * to verify translog replay, checkpoint advancement, and segment creation
                int ops = 0;
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) docs));
        // Reopen — committed data, empty translog
    }
            recoverFromTranslog(engine);
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        public List<CatalogSnapshot> listCommittedSnapshots() {
            .build();
                        }
    private Store store;
     * Regression test: restart with committed data and empty translog.
            // Engine should accept new writes after recovery
        public Map<String, String> getLastCommittedData() {
                    store.directory(),
                        .setOpenMode(IndexWriterConfig.OpenMode.APPEND)
        );
        }
                store.directory(),
            // the first commit WITH _catalog_snapshot_. But the engine must have opened
    public void testRecoveryProducesValidCatalogSnapshot() throws IOException {
        try (DataFormatAwareEngine engine = reopenEngine()) {
    }
     * <p>
        );
        }
            assertThat(failures.get(), equalTo(0));
     * No two segments in a snapshot should share the same generation.
     */
                    engine.translogManager().rollTranslogGeneration();
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.store.Store;
            this.store = store;
            // Checkpoint must reflect all docs
        return new Store(
        }
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) docs - 1));
            engine.flush(false, true);
                    count++;
    }
        try (DataFormatAwareEngine engine = createEngine()) {
        try (DataFormatAwareEngine engine = reopenEngine()) {
import org.opensearch.index.translog.TranslogStats;
        }
        // Reopen and recover — checkpoint must be contiguous with no gaps
                final int threadId = t;
        public CommitResult commit(CommitInput commitInput) throws IOException {
}
                assertThat("total rows must equal total docs indexed", totalRows, equalTo((long) docs));
            shardId,
            }
     */
     * Mirrors InternalEngineTests.testTranslogRecoveryDoesNotReplayIntoTranslog (L1024).
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                        barrier.await();
        ParsedDocument doc = createParsedDocWithInput(id);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.apache.lucene.index.IndexWriterConfig;
        return new Engine.Index(
            for (int i = 0; i < docs; i++) {
                    Collectors.toMap(
    }
        return new ParsedDocument(
     * Lifecycle: index→flush→close→reopen→index→flush→close→reopen. Each reopen
                0L,
        try (DataFormatAwareEngine engine = reopenEngine()) {
            // Flush should succeed
                );
 * SPDX-License-Identifier: Apache-2.0
     * Mirrors InternalEngineTests.testRecoveryFromTranslogUpToSeqNo (L1099).
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                threads[t] = new Thread(() -> {
                while ((op = snapshot.next()) != null) {
            int recovered = recoverFromTranslog(engine);
            Thread[] threads = new Thread[numThreads];
            engine.refresh("flush-1");
            // Advance global checkpoint to match local (simulates single-node replication)
        return recovered;
                engine.index(indexOp(Integer.toString(i)));
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    private ParsedDocument createParsedDocWithInput(String id) {
            engine.refresh("post-recovery");
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
            assertThat("should recover only unflushed docs", recovered, equalTo(unflushedDocs));
                }
     */
        final int docs = randomIntBetween(20, 60);
            }
            engine.flush(false, true);
import org.opensearch.test.OpenSearchTestCase;
    /**
        final int initialDocs = randomIntBetween(5, 20);
            }
        try (DataFormatAwareEngine engine = reopenEngine()) {
     * Multi-threaded indexing before close, then recovery. Verifies no sequence
        }
                    assertThat("generation must strictly increase", currentGen, greaterThan(prevGen));
            }
            assertThat("nothing to recover after prior recovery flushed", stats.getUncommittedOperations(), equalTo(0));
        final int totalDocs = numThreads * docsPerThread;
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
import org.opensearch.index.engine.exec.commit.Committer;
        when(documentMapper.getVersion()).thenReturn(1L);
                CatalogSnapshot snapshot = ref.get();
            // Final checkpoint should reflect all docs
            BigArrays.NON_RECYCLING_INSTANCE,
            .dataFormatRegistry(registry)
            for (int i = 0; i < docs; i++) {
            for (int i = 0; i < docs; i++) {
                assertThat(snapshot.getSegments().size(), greaterThan(0));
                    .stream()
                    .stream()
import org.apache.lucene.index.Term;
        }
    /**
    }
            for (int i = 0; i < docs; i++) {
            for (int i = 0; i < docs; i++) {
            new MockDocumentInput()
    private Engine.Index replayOp(Translog.Index translogOp) {
            engine.flush(false, true);
                this.lastCommittedSnapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
package org.opensearch.index.engine;
            return new byte[0];
     * Concurrent indexing followed by flush, then recovery. Verifies the committed
        try {
        try (DataFormatAwareEngine engine = createEngine()) {
     * gaps exist after recovery — the checkpoint must be contiguous.
import org.opensearch.index.mapper.DocumentMapper;
            assertThat(commitData.get(SequenceNumbers.MAX_SEQ_NO), equalTo(Long.toString(docs - 1)));
        try (DataFormatAwareEngine engine = createEngine()) {
        private volatile CatalogSnapshot lastCommittedSnapshot;
     * A committer that writes commit data back to the Lucene IndexWriter,
                );
    }
        // Second lifecycle: recover, add more, flush
            Translog.Operation op;
            }
                assertThat("snapshot should have segments after recovery", snapshot.getSegments().size(), greaterThan(0));
            translogOp.version(),
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(mockPlugin));
                    store.shardFormatDirectoryResolver()
    public void testTranslogRecoveryDoesNotReplayIntoTranslog() throws IOException {
                assertThat("all ops must be present in translog snapshot after recovery", count, equalTo(docs));
public class DataFormatAwareEngineRecoveryTests extends OpenSearchTestCase {
                Engine.IndexResult result = engine.index(indexOp(Integer.toString(i)));
                assertThat("total rows must match total docs", totalRows, equalTo((long) totalDocs));
                while ((op = snapshot.next()) != null) {
import org.opensearch.index.VersionType;
            // Everything is committed — translog is empty after flush
            Versions.MATCH_ANY,
    public void testSnapshotGenerationAdvancesMonotonicallyAfterRecovery() throws IOException {
            // No translog ops to replay
    }
                engine.index(indexOp(Integer.toString(i)));
                    engine.refresh("interleaved-refresh-" + i);
import org.opensearch.cluster.metadata.IndexMetadata;
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        }
            // After recovery, checkpoint should cover all docs
                );
/**
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        final int totalDocs = numThreads * docsPerThread;
    /**
                try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            doc,
     * must see the accumulated data from all prior lifecycles.
import static org.mockito.Mockito.mock;
 * compatible open source license.
            }
            int recovered = recoverFromTranslog(engine);
        @Override
     */
                    .sum();
        // Advance global checkpoint after recovery (simulates single-node cluster)
                List.of(),
        public CommitStats getCommitStats() {
                        for (int d = 0; d < docsPerThread; d++) {
/*
import java.io.IOException;
            assertThat(engine.getSeqNoStats(-1).getMaxSeqNo(), equalTo((long) totalDocs - 1));
import org.apache.lucene.index.SegmentInfos;
                engine.index(indexOp(Integer.toString(i)));
                    }
