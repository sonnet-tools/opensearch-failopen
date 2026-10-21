                "test"
 *
                .put(IndexModule.INDEX_TIERING_STATE.getKey(), "NOT_A_REAL_STATE")
                        threadErrors.incrementAndGet();
            engine2.translogManager().recoverFromTranslog(ignore -> 0, engine2.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
    /**
            .tombstoneDocSupplier(tombstoneDocSupplier())
     *   <li>Count down the activeFlushLatch so the refresh thread is not stuck waiting.</li>
                droppedRefreshCount.get(),
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            engine.index(indexOp(createParsedDocWithInput("0", null)));
                assertNull(engine.resolveDocVersion(op, true));
    public void testFailedUpdateDoesNotSupersedePreviousCopy() throws Exception {
            MockIndexingExecutionEngine indexingEngine = getMockExecutionEngine(engine);
    }
    public void testRefreshListenerSeesMonotonicallyAdvancingSnapshots() throws IOException {
            }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            Engine.IndexResult gcResult = engine.index(indexOp(createParsedDocWithInput("1", null)));
            engine.refresh("test");
        final int maxDocs = randomIntBetween(1, 20);
     */
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            // Verify the catalog snapshot generation advanced monotonically
            flushQueueOf(engine).add(new SuccessFlushWriter(42L, mockDataFormat));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            engine.freezeForTiering();
            MockWriter writer = getPooledMockWriter(engine);
            assertThat("injector ran inside the flush window", injectedSeqNos, equalTo(List.of(10L, 11L, 12L)));
                IllegalStateException.class,
            assertEquals(result.getFailure().getClass(), AppendOnlyIndexOperationRetryException.class);
            @Override
    ) {
            }
    public void testNewChangesSnapshotRespectsSeqNoRange() throws IOException {
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, getWithSeqNoConflict));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            // Verify consistent terminal state
        };
                    assertThat(result.getFailure(), instanceOf(IllegalArgumentException.class));
            for (int i = 20; i < 40; i++) {
                assertThat(snapshot.getSegments().size(), equalTo(1));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
     * Simulates parallel tier/cancel: freezer threads repeatedly call {@code freezeForTiering()} while a
                assertThat(reader, notNullValue());
            );
        return new EngineConfig.Builder().shardId(shardId)
            // On primary, maybeFailEngine sees Lucene.isCorruptionException and calls failEngine,
            long processed = engine.getProcessedLocalCheckpoint();
    public void testFailEngineWithCorruptionMarksStoreCorrupted() throws IOException {
        DataFormatAwareEngine engine = new DataFormatAwareEngine(config);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        String tieringState,
        ReferenceManager.RefreshListener listener = new ReferenceManager.RefreshListener() {
                () -> engine.index(indexOp(createParsedDocWithInput("0", null)))
                "persisted checkpoint must catch up to the processed checkpoint after sync",
    public void testWriteIndexingBufferTriggersRefresh() throws IOException {
            this.writerGeneration = writerGeneration;
            assertThat(first.getTranslogLocation().compareTo(second.getTranslogLocation()), lessThan(0));
                    }
                for (Engine.IndexResult result : allResults) {
                new Engine.Index(
        return new FailingEngineResult(new DataFormatAwareEngine(config), committer);
        }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings.build());
        return new DataFormatAwareEngine(buildBatchDFAEngineConfig(store, translogPath, provider, enabled, remoteStore, appendOnly));
                CatalogSnapshot snapshot = ref.get();
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            engine.refresh("test");
                .build()
        public org.opensearch.index.engine.dataformat.Writer<MockDocumentInput> createWriter(
        }
            // No thread should have thrown
    }
    private MockDataFormatPlugin mockPlugin;
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
    public void testGetByIdReturnsNotFoundWhenEmptyCatalog() throws IOException {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        FailableDataFormatAwareEngine(DataFormatAwareEngine engine) {
                }
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                indexThreads[t].start();
                .put("index.check_pending_flush.enabled", false)
                        // ignore
                // Verify via getSearchableFiles API as well
            // Index a doc so the engine is in a valid state.
        MockDeleteExecutionEngine deleteEngine = spy(new MockDeleteExecutionEngine(mockDataFormat));
            System.nanoTime(),
            engine.close();
     * A {@link MockIndexingExecutionEngine} variant whose writer always throws on the
import java.util.Map;
            for (int i = 0; i < totalDocs; i++) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        }
                indexingEngine.getRefreshCallCount(),
        boolean remoteStore
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
            engine.flush(false, true);
                    } catch (Throwable e) {
    }
     * {@link DataFormatAwareEngine#acquireHistoryRetentionLock()} must return a lock that pins a translog
    }
            // Before refresh, last refreshed checkpoint hasn't advanced
                threads[t] = new Thread(() -> {
        when(mapperService.documentMapper()).thenReturn(documentMapper);
    public void testCountNumberOfHistoryOperations() throws IOException {
    }
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
        Engine.EventListener listener = new Engine.EventListener() {
            // After sync, persisted must equal processed
        DataFormatRegistry registry = createMockRegistry();
            refresher.join();
                        setTieringStateSetting(engine, IndexModule.TieringState.HOT);
            // No further operations possible
            long persistedBefore = engine.getPersistedLocalCheckpoint();
            System.nanoTime(),
                    } catch (AlreadyClosedException e) {
            empty()
            notifySettingsChanged(engine);
    }
        }
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
            final int numDocs = 5;
            writer.setFailureKeepsActive(true);
                            engine.refresh("concurrent");
            super(dataFormat);
            .internalRefreshListener(internalListeners)
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        try {
        expectThrows(AlreadyClosedException.class, () -> engine.ensureOpen());
    ) throws IOException {
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            }
            .translogConfig(translogConfig)
                assertThat(snapshot.getSegments().size(), equalTo(1));
    public void testRefreshDrainOfTragicBatchAppendFailsEngineOnceWithTheTragicException() throws Exception {
import static org.hamcrest.Matchers.nullValue;
                });
                    } catch (IOException e) {
                } else {
     * flushed, catalog snapshot held, store ref taken, {@code refreshLock} and {@code readLock} held); the drained append
            commitData.put(Engine.HISTORY_UUID_KEY, UUID.randomUUID().toString());
            assertThat(deferred.getTranslogLocation(), nullValue());
     *  DFA engines ignore the searcher factory, so a no-op factory is supplied. */
     * <p>The latch-and-flushQueue contract demands that, no matter which code path
            // localCheckpoint == maxSeqNo == 4 — no gap to fill.
        }
        Path translogPath = createTempDir();
     * Verifies that engine close (closeNoLock) drains the flushQueue and closes any
            // Refresh thread: a refresh from an unrelated caller drains the batch inside its critical section.
        }
        engine.close();
            if (refresher.isAlive()) {
            shardId,
            .eventListener(new Engine.EventListener() {
                        notifySettingsChanged(engine);
            .threadPool(threadPool)
            indexSettings,
        throws IOException {
            try {
            new DocumentLookupResult("1", 2L, true, null, 7L, 1L, Map.of(), Map.of())
            new Term(IdFieldMapper.NAME, Uid.encodeId(id)),
     * so the engine stays usable.
    }
import org.opensearch.index.engine.dataformat.DeleteInput;
        public void deleteCommit(org.opensearch.index.engine.exec.coord.CatalogSnapshot snapshot) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                @Override
     */
        }
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            // Wait until both workers have indexed all their ops (bounded).
            for (int i = 0; i < numDocs; i++) {
    public void testAcquireReaderSnapshotMatchesLatestRefresh() throws IOException {
                sb.append(indent).append("  suppressed: ").append(s.getClass().getName()).append(": ").append(s.getMessage()).append('\n');
        Path translogPath = createTempDir();
                while ((op = snapshot.next()) != null) {
            BigArrays.NON_RECYCLING_INSTANCE,
                        }
            int numThreads = randomIntBetween(2, 4);
    /**
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                            }
            // recorded on the indexing engine (the new tragic-source channel).
            assertThat(deferred.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> deleteEngine);
        };
        }
                    }
                assertThat("no op may be published before the refresh fence", result.getTranslogLocation(), nullValue());
        boolean remoteStore,
     * with isRetry=false makes {@link IndexingStrategyPlanner} take the optimizedAppendOnly path
    private EngineConfig buildEngineConfigForPluginAndListener(
    }
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
            }
     * Simulates a real failover gap: index N docs as PRIMARY, then replay a recovery-origin
        MapperService mapperService = mock(MapperService.class);
                    assertThat("doc " + i + " should be rejected", result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
        AtomicLong afterDidRefreshTrue = new AtomicLong(0);
            assertThat(batch.flush(), equalTo(expectedMax));
                versionMap.putDeleteUnderLock(uid, new DeleteVersionValue(2L, 1L, 1L, System.currentTimeMillis()));
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            assertThat(delete.uid(), equalTo(new Term(IdFieldMapper.NAME, Uid.encodeId("42"))));
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("post-fail", null))));
            }
            engine.index(indexOp(createParsedDocWithInput("1", null)));
     * An unmodelled {@link IOException} from the delete engine travels through
    public void testThrottling() throws IOException {
            public void onFailedEngine(String reason, Exception e) {
        FailingFlushIndexingExecutionEngine(MockDataFormat dataFormat) {
            assertThat("the resolved GET must observe the indexed seqNo", lookup.get().seqNo(), equalTo(0L));
                for (Thread worker : workers) {
            MockWriter writer = getPooledMockWriter(engine);
        DocumentLookupProvider provider,
            }
            assertThat("every op is published once the scope is finished", engine.getProcessedLocalCheckpoint(), equalTo(2L));
            for (int i = 0; i < numDocs; i++) {
    }
            if (failure.get() != null) {
                }
     * <p>This test injects a failing writer directly into the flushQueue via reflection,
                assertThat(snapshot.getGeneration(), equalTo(3L));
        engine.close();
            engine.writeIndexingBuffer();
import java.io.Closeable;
            .store(store)
        @Override
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
                    throw new RuntimeException(ex);
            assertThat(stats.getLocalCheckpoint(), equalTo((long) totalDocs - 1));
        return (MockIndexingExecutionEngine) engine.getIndexingExecutionEngine();
            assertThat("all 10 docs should be committed", engine.getProcessedLocalCheckpoint(), equalTo(9L));
            int numRefreshes = randomIntBetween(3, 7);
        @Nullable TranslogFactory translogFactory,
                assertThat(fromApi.files(), equalTo(wfs.files()));
            CyclicBarrier barrier = new CyclicBarrier(numThreads + 1); // +1 for refresh thread
            try (org.opensearch.common.lease.Releasable ignored = versionMapOf(engine).acquireLock(op.uid().bytes())) {
            IllegalStateException e = expectThrows(
    public void testCloseNoLockDrainsFlushQueue() throws Exception {
    private EngineConfig buildBatchDFAEngineConfig(
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        when(mapperService.documentMapper()).thenReturn(documentMapper);
     */
            assertEquals("idle engine has no active merges", 0, engine.getActiveMergeCount());
                store.directory(),
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                    try {
            engine.index(indexOp(createParsedDocWithInput("1", null)));
        public void updateMappingVersion(long newVersion) {}
     * that no actual refresh occurred (didRefresh=false). This allows waiters to
                    } catch (Exception e) {
            "test",
        TranslogConfig translogConfig = new TranslogConfig(
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                throw new AssertionError("Failure while performing flush/refresh: " + failureCause.get());
    }
        MapperService mapperService = mock(MapperService.class);
            assertThat("an issued seqNo must be recorded as a translog no-op", result.getTranslogLocation(), notNullValue());
     * <ul>
            assertEquals(1, versionMap.getAllCurrent().size());
            translogPath,
    }
            .eventListener(new Engine.EventListener() {
     * everything the tests assert on: what the refresh threw, every engine failure the listener saw, what the batch
            CyclicBarrier barrier = new CyclicBarrier(freezers + 1);
                assertThat(snapshot.getSegments().size(), equalTo(0));
     */
        DataFormatAwareEngine engine = createDFAEngine(store, translogPath);
        DataFormatAwareEngine engine = fer.engine();
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            engine.flush(false, true);
            } catch (Exception ignored) {}
    }
            VersionType.INTERNAL,
    }
            for (int i = 0; i < 10; i++) {
            java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");
        EngineConfig config = buildDFAEngineConfig(store, translogPath, provider);
                org.opensearch.index.engine.exec.Segment segment = snapshot.getSegments().get(0);
            } catch (Exception e) {
            for (int i = 0; i < numDocs; i++) {
                () -> engine.index(indexOp(createParsedDocWithInput("trigger-preindex", null)))
        try {
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("2", null))));
        }
    public void testRefreshListenerNotifiedWithDidRefreshFalseWhenNoNewData() throws IOException {
                        }
                    + ".."
            engine.flush(false, true);
            }
                    failures.incrementAndGet();
                internalCalls.incrementAndGet();
            );
            for (int t = 0; t < numThreads; t++) {
    }
            assertThat(
        DocumentLookupProvider provider,
                        engine.translogManager().syncTranslog();
        engine.failEngine("null failure test", null);
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
            Thread[] threads = new Thread[numThreads];
            // Index documents — data is buffered but not yet searchable
                    count++;
            }, "cross-thread-realtime-get");
            } catch (Exception ignored) {
                    afterDidRefreshFalse.incrementAndGet();
            assertThat("each refresh must invoke afterRefresh once", afterAfterSeed, equalTo(2));
            assertEquals(NoOpDeleteExecutionEngine.UNSUPPORTED_MESSAGE, e.getMessage());
            assertTrue(stats.getFileSizes().isEmpty());
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            // Transition to HOT_TO_WARM and notify — engine freezes.
    public void testPrepareDeleteWithRoutingBuildsDeleteOperation() throws IOException {
                        // Each worker owns its own batch scope (beginTranslogBatch is thread-local).
     * through the index guard).
     * Reads the size of {@code DataFormatAwareEngine.flushQueue} via reflection so tests
        DocumentLookupProvider provider,
import org.opensearch.index.translog.TranslogConfig;
     * <p>Two worker threads each open their OWN translog batch (the batch scope is thread-local, so each thread must
                // MockWriter produces "data_gen<writerGen>.parquet" — first writer is gen 1
    public void testIsFrozenForTieringLiveSettingsFallback() throws IOException {
                    } catch (Exception e) {
            VersionType.INTERNAL,
    /**
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    /** Builds a HOT-tier DFA {@link EngineConfig} carrying the given {@link DocumentLookupProvider}. */
            assertThat(result.getFailure(), instanceOf(VersionConflictEngineException.class));
        }
            })
    }
            assertThat("afterRefresh must see post-commit generation", genSeenInAfter.get(), equalTo(2L));
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo(engine.getProcessedLocalCheckpoint()));
                assertTrue("version map entry must be a delete tombstone", vv.isDelete());
                    null,
            assertTrue(
            assertNull("from-translog delete must not be re-appended to the translog", result.getTranslogLocation());
                    count++;
            .store(store)
            nullValue()
                IllegalStateException.class,
     *       deterministically ordered without timing guesses.</li>
        FailureInjectingCommitter failingCommitter = fer.committer();
            } catch (FlushFailedEngineException | AlreadyClosedException e) {
        store = createStore();
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(listener), List.of());
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
    ) {
            Engine.Index op = indexOp(createParsedDocWithInput("1", null));
import org.opensearch.index.engine.dataformat.stub.MockWriter;
    private DataFormatAwareEngine createDFAEngineWithTieringState(Store store, Path translogPath, IndexModule.TieringState state)
        Path translogPath = createTempDir();
            assertThat(failure, instanceOf(IllegalStateException.class));
        Path translogPath = createTempDir();
    }
        }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        }
        Engine.EventListener listener = new Engine.EventListener() {
                    .mapToLong(s -> s.dfGroupedSearchableFiles().get(mockDataFormat.name()).numRows())
        } finally {
                t.join();
    }
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
     * Wraps {@link EngineTestCase#createParsedDoc(String, String)} to attach a
                }
            Thread refresher = new Thread(() -> {
            engine.close();
            writer.setWriteResultSupplier(() -> new WriteResult.Failure(new IOException("simulated addDoc failure"), -1L, -1L, -1L));
    public void testUnreferencedFileCleanUpsPerformed() throws IOException {
            GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot();
            queue.add(new FailingFlushWriter(99L, mockDataFormat));
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
     * Covers resolveDocVersion falling back to DocumentLookupProvider when versionMap miss.
        final IOException tragic = new IOException("simulated tragic translog write failure");
    /** As {@link #buildFailingEngineConfig(MockDataFormatPlugin, Engine.EventListener)} without callback assertions. */
            // Each refresh with data should have triggered afterRefresh(true)
    }
     * handling methods ({@code failOnTragicEvent}, {@code maybeFailEngine}) and internal
import java.util.concurrent.CopyOnWriteArrayList;
            int totalDocs = numThreads * docsPerThread;
    private static Throwable rootCause(Throwable t) {
        EngineConfig config = buildFailingEngineConfig(plugin);
    }
            .primaryTermSupplier(primaryTerm::get)
            engine.refresh("index-refresh");
                AlreadyClosedException.class,
        FailingFlushIndexingExecutionEngine failingEngine = new FailingFlushIndexingExecutionEngine(mockDataFormat);
                        // Ensure the main thread is never left blocked on the indexed latch if a worker dies early.
    public void testRefreshUpdatesLastRefreshedCheckpoint() throws IOException {
                threads[t] = new Thread(() -> {
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            final Set<Long> assignedSeqNos = allResults.stream().map(Engine.Result::getSeqNo).collect(Collectors.toSet());
        Path translogPath,
        bootstrapStoreWithMetadata(store, uuid, 3L);
        throw new AssertionError("No MockWriter found in writer pool");
            Engine.Get current = new Engine.Get(true, true, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))).setIfSeqNo(7L)
            int docsPerThread = 50;
            engine.ensureOpen();
            // A range above the highest seqNo contains no operations.
            shardId,
            failingCommitter.setCommitFailure(corruption);
     *   <li><b>Flush phase:</b> an explicit flush + translog sync advances the PERSISTED checkpoint to the same max.</li>
        @Override
                new FailableDataFormatAwareEngine(engine).getFailedEngine()
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
     * Opening a scope on a closed engine is refused with the same {@link AlreadyClosedException} its first append would
            }
            engine.refresh("flush");
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                    + "); recovery would otherwise skip and lose seqnos "
            for (Thread t : threads)
                    }
        EngineConfig config = buildFailingEngineConfig(plugin);
        }
        DataFormatAwareEngine engine = createUpdateEnabledDFAEngine(store, createTempDir());
        deleteEngine.setDeletesAppliedOnCheckout(true);
            }
                    barrier.await();
            0
     * Use case: When no new data has been indexed, a refresh should still notify
            engine.refresh("test");
            }
                    allResults.addAll(perWorker);
        }
        MockDeleteExecutionEngine deleteEngine = spy(new MockDeleteExecutionEngine(mockDataFormat));
            }
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    /** resolveDocVersion branch 4: versionMap miss, provider consulted, getById returns NOT_FOUND → null. */
            for (int t = 0; t < numThreads; t++) {
import static org.hamcrest.Matchers.lessThan;
            return new org.opensearch.index.engine.dataformat.WriteResult.Success(1L, 1L, 0L);
    }
    public void testFlushAndClose() throws IOException {
            engine.close();
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
    public void testDeleteWithMismatchedIfSeqNoReturnsVersionConflict() throws IOException {
        // Create the initial translog files and get the UUID
            public void onFailedEngine(String reason, Exception failure) {
            }
    }
            RuntimeException ownerFailure,
            // (translog is empty, well under threshold)
        DocumentLookupProvider provider = mockLookupProvider();
    }
    private void bootstrapStoreWithMetadata(Store store, String translogUUID) throws IOException {
            assertThat("beforeRefresh must fire when new segments are produced", beforeCount.get(), equalTo(1));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        return (java.util.concurrent.ConcurrentLinkedQueue<Writer<?>>) queueField.get(engine);
     */
            System.nanoTime(),
        Store store,
            translogPath,
        } finally {
            // Refresh and verify engine is operational
                .build()
            engine.onMergesDrained(() -> listenerFired.set(true));
                t.join();
                        engine.flush(false, false);
            assertNull("engine should still be open", new FailableDataFormatAwareEngine(engine).getFailedEngine());
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        // The stored document is at seqNo 7 / term 1.
            }
    @SuppressForbidden(reason = "test needs reflective access to the engine's versionMap field")
    }
    }
            engine.refresh("test");
        return (LiveVersionMap) vmField.get(engine);
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)
            "",
                    observedGenerations.add(System.nanoTime()); // monotonic timestamp as proxy
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        }
     * transitions: optimized append-only skips the map; an explicit-id index enforces safe access
        TranslogConfig translogConfig = new TranslogConfig(
            assertThat("finishing the scope appends the trailing op", third.getTranslogLocation(), notNullValue());
     * Test helper that wraps a {@link DataFormatAwareEngine} to expose its private failure
            // The ops are replayable from the translog, proving the batched append wrote them.
    }
     */
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
                "committed LOCAL_CHECKPOINT ("
        FailureInjectingCommitter failingCommitter = fer.committer();
            .primaryTermSupplier(primaryTerm::get)
            assertThat(result.getTranslogLocation(), notNullValue());
                null,
            Engine.IndexResult newResult = engine2.index(indexOp(createParsedDoc("new-after-recovery", null)));
            .translogFactory(translogFactory != null ? translogFactory : new InternalTranslogFactory())
            .store(store)
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(listener), List.of());
    }
            // Replay a recovery-origin op at seqNo=7. That marks 7 as seen+processed, but
            // Arm the injector: during flush()'s refresh, seqnos 10,11,12 get indexed into a NEW
            ifSeqNo,
            engine.refresh("after-rejected-delete");
                assertTrue(wfs.files().iterator().next().endsWith(".parquet"));
        MockIndexingExecutionEngine indexingEngine = new MockIndexingExecutionEngine(mockDataFormat);
        public boolean isCommitManagedFile(String fileName) {
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
            engine.refresh("test");
            .tombstoneDocSupplier(tombstoneDocSupplier())
    }
                    } catch (Exception e) {
            final AtomicReference<DocumentLookupResult> lookup = new AtomicReference<>();
        try {
     *
            AtomicBoolean listenerFired = new AtomicBoolean(false);
        try (DataFormatAwareEngine engine = createDFAEngineWithTieringState(store, createTempDir(), IndexModule.TieringState.HOT_TO_WARM)) {
                if (expectedMax == null || result.getTranslogLocation().compareTo(expectedMax) > 0) {
            Engine.Operation.Origin.PRIMARY,
     *
        DataFormatRegistry registry = createMockRegistry();
            assertNotNull(vv);
            assertThat("op 2 location must be deferred before the cross-thread GET", secondPending.getTranslogLocation(), nullValue());
                    assertThat(
            }
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            Thread[] threads = new Thread[numThreads];
            mockExecEngine.setRefreshFailure(() -> new IOException("injected writer failure"));
            assertEquals(4L, engine.getProcessedLocalCheckpoint());
            });
            shardId,
import java.util.Deque;
import org.apache.lucene.index.NoMergePolicy;
            for (int i = 0; i < numDocs; i++) {
            IllegalStateException e = expectThrows(
                    callOrder.append('B');
            assertThat(engine.countNumberOfHistoryOperations("test", 7, Long.MAX_VALUE), equalTo(3));
        }
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                greaterThan(0)
    public void testEngineConfig() throws IOException {
    }
     *       a per-operation {@code Translog#add} failure records it, not a wrapper;</li>
        }
            // Refresh should fail the engine
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            .internalRefreshListener(List.of())
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
    }
     * C: optimized append-only ops never enter safe-access mode — they leave the current map empty
            assertThat("internal listener must receive both before and after", internalCalls.get(), equalTo(2));
                WriterFileSet fromApi = searchableFiles.iterator().next();
                }
            // assert the queue is empty without exposing internals on DFAE.
            for (int i = 0; i < 5; i++) {
            for (int i = 0; i < 5; i++) {
            for (int i = 0; i < numDocs; i++) {
                        }
                            Engine.IndexResult r = eng.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        }
        MockIndexingExecutionEngine indexingEngine = new MockIndexingExecutionEngine(df);
            IndexSettings indexSettings = engine.config().getIndexSettings();
            @Override
            indexSettings,
            for (int i = 0; i < numDocs; i++) {
            for (Thread t : threads) {
    public void testFlushAfterCloseThrows() throws IOException {
            @Override
                public void onFailedEngine(String reason, Exception e) {}
import static org.hamcrest.Matchers.instanceOf;
    }
                });
            try (org.opensearch.common.lease.Releasable ignored = versionMapOf(engine).acquireLock(op.uid().bytes())) {
            settings.put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), appendOnly);
            assertThat(e.getMessage(), containsString("frozen for tiering"));
                workers[w].start();
            false
        assertThat(committedData, notNullValue());
            Engine.DeleteResult result = engine.delete(deleteOp("missing"));
    }
        java.lang.reflect.Field field = DataFormatAwareEngine.class.getDeclaredField("unpublishedDeletes");
            SequenceNumbers.UNASSIGNED_SEQ_NO,
                    } catch (Exception e) {
     * as {@code if_seq_no} does for updates — and the same missing
    private Engine.Delete deleteOpWithIfSeqNo(String id, long ifSeqNo, long ifPrimaryTerm) {
            expectThrows(IllegalArgumentException.class, () -> engine.flush(true, false));
    private ThreadPool threadPool;
     * <p>This test uses a {@link FailingFlushIndexingExecutionEngine} that returns
            // What the commit CLAIMS is durable.
            // afterRefresh(false) indicates nothing new became searchable
    private Engine.Index indexOpWithVersion(ParsedDocument doc, long version, VersionType versionType) {
    public void testDeleteEngineFailureResultRecordsNoOpAndLeavesEngineOpen() throws Exception {
            // Second half: the refresh thread hits a writer whose flush throws.
            writer.setState(WriterState.RETIRED_FLUSHABLE);
            assertFalse("should be not found on empty catalog", result.exists());
            new DocumentLookupResult("1", 2L, true, null, 7L, 1L, Map.of(), Map.of())
    }
            // before any onSettingsChanged call.
        when(provider.getDocsAboveSeqNo(anyLong(), any(), any(), any())).thenThrow(new IOException("simulated read failure"));
            return delegate.serializeToCommitFormat(snapshot);
            assertTrue("a skipped replay reports found because currentlyDeleted is false", replay.isFound());
            java.lang.reflect.Field queueField = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
                        barrier.await();
        final List<Exception> engineFailures;
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            }
            "test",
    public void testGetSeqNoStats() throws IOException {
            }, "refresh-under-failed-batch-append");
    /** With file sizes requested, delete-tracking memory is reported as version-map memory. */
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
                });
                        engine.flush(false, true);
            org.opensearch.index.seqno.SeqNoStats stats = engine.getSeqNoStats(numDocs - 1);
        try (Store store = createStore()) {
                    } catch (Exception e) {
            }
        return buildEngineConfigForPluginAndListener(translogPath, plugin, listener);
                1L,
    public void testPersistedCheckpointLagsProcessedBeforeSync() throws IOException {
                    } catch (Throwable e) {
            assertThat(
            IOException failure = expectThrows(IOException.class, () -> engine.delete(deleteOp("1")));
                assertThat(op1.seqNo(), lessThan(op2.seqNo()));
        bootstrapStoreWithMetadata(store, uuid);
            // and do more work
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
            gate.await(10, TimeUnit.SECONDS);
     * expects to find: translog UUID, seq-no info, history UUID, etc.
    public void testBothExternalAndInternalListenersInvoked() throws IOException {
import org.opensearch.index.seqno.RetentionLeases;
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        return new Engine.Index(
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
            for (int i = 0; i < numDocs; i++) {
            .build();
import java.nio.file.Path;
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
    /**
            // Sub-ranges count only the operations whose seqNo lies within [fromSeqNo, toSeqNo].
    /** Reflectively obtains the engine's LiveVersionMap. resolveDocVersion/getVersionFromMap assert the
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        when(documentMapper.getVersion()).thenReturn(1L);
     * <p>We inject the in-window document via an {@code afterRefresh} listener (it fires
        Store store,
            assertNotNull("engine should have failed", new FailableDataFormatAwareEngine(engine).getFailedEngine());
                });
                latestGen = snapRef.get().getGeneration();
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            for (int i = 0; i < numDocs; i++) {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings.build());
    public void testNewChangesSnapshotAfterConcurrentIndexing() throws Exception {
        }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    public void testGetByIdFromSegmentsAcceptsCurrentVersion() throws IOException {
            primaryTerm.get(),
            );
        }
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            Versions.MATCH_ANY,
        try {
    public void testIOExceptionDuringCommitEngineStaysOpenForNonCorruption() throws IOException {
            assertThat(result.getTranslogLocation(), nullValue());
            engine.index(indexOp(createParsedDocWithInput("1", null)));
     */
     */
            }
            Engine.DeleteResult result = engine.delete(deleteOpFromTranslog("1", seqNo));
            try {
            @Override
                        }
    public void testDeletePrimaryRemovesDocAndRecordsTombstone() throws Exception {
        }
        AtomicInteger afterCalls = new AtomicInteger();
            // Single settings-mutating thread toggles the tiering state and notifies, racing the freezers.
            refreshThread.start();
    }
    }
            }
            assertThat("flush must return the batch max location", max, notNullValue());
import static org.mockito.Mockito.when;
            assertThat(deleted.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                final int threadId = t;
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
                "test"
                Engine.Operation.Origin.PRIMARY,
        expectThrows(AlreadyClosedException.class, () -> engine.flush(false, true));
    public void testDeleteWithoutDeleteCapableFormatFailsOperationNotEngine() throws IOException {
        }
            // First half of the cycle: a write thread flushes and drains gen 42 through preIndex.
    public void testRefreshFlushesPendingTranslogBatchBeforePublishing() throws IOException {
            engine.index(indexOp(createParsedDocWithInput("1", null)));
        EngineConfig config = buildFailingEngineConfig(failingPlugin, listener);
            );
    public void testBatchedIndexThenInlineDeleteFlushesPendingChunkFirst() throws IOException {
        assertThat(
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
                // expected
        }
                try {
    public void testDeleteNonExistentDocReportsNotFound() throws IOException {
                failureClass,
                assertThat(searchableFiles.size(), equalTo(1));
                final long maxSeqNo = eng.getProcessedLocalCheckpoint();
            current = current.getCause();
        DocumentLookupProvider provider = mockLookupProvider();
            engine.refresh("test");
            int numDocs = randomIntBetween(5, 15);
            AtomicInteger failures = new AtomicInteger(0);
        SuccessFlushWriter(long writerGeneration, org.opensearch.index.engine.dataformat.DataFormat dataFormat) {
            Engine.IndexResult second = engine.index(indexOp(createParsedDocWithInput("2", null)));
            // All seqNos 0-5 contiguous → checkpoint = 5
                committedCheckpoint,
                threads[t].start();
            // Persisted advances only once the translog is fsynced.
        @Nullable Engine.EventListener eventListener
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
        ReferenceManager.RefreshListener orderingListener = new ReferenceManager.RefreshListener() {
            queue.add(new FailingFlushWriter(99L, mockDataFormat));
            expectThrows(AlreadyClosedException.class, () -> engine.refresh("after-fail"));
            engine.refresh("test");
            }
            }
            assertNull("concurrent freeze/unfreeze must not deadlock or throw", error.get());
                    try {
            final Throwable thrown = refreshOutcome.get();
            }
            int numDocs = randomIntBetween(3, 10);
    // ═══════════════════════════════════════════════════════════════
            expectThrows(VersionConflictEngineException.class, () -> engine.getById(future, (source, scope) -> null));
            Translog.Location max = batch.finish();
            // seqNos are assigned contiguously across both bulks regardless of interleaving.
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo");
            engine.close();
     * </ol>
        CommitterFactory committerFactory = config -> new InMemoryCommitter(store);
        @Override
            "test",
            // Before sync, persisted may lag behind processed
                            failure.compareAndSet(null, e);
    public void testOperationsAfterCloseThrow() throws IOException {
        }
        }
        assertTrue("committed data should contain translog UUID", committedData.containsKey(Translog.TRANSLOG_UUID_KEY));
        @Override
     * </ol>
            }, "force_merge-test");
            "",
            // --- Path 6: GC deletes in resolveDocVersion ---
            engine.index(indexOp(createParsedDocWithInput("2", null)));
     */
                versionMap.putDeleteUnderLock(uid, new DeleteVersionValue(3L, 2L, 1L, 1L)); // time=1ms (epoch start, expired)
            engine.close();
            // Verify all subsequent ops throw AlreadyClosedException
        }
    public void testNewChangesSnapshotReturnsIndexedOps() throws IOException {
                                assertThat(reader.catalogSnapshot(), notNullValue());
                    equalTo((long) totalOps - 1)
            }
                onFailedCount.incrementAndGet();
            SegmentsStats stats = engine.segmentsStats(false, false);
        DataFormatAwareEngine engine = fer.engine();
        shardId = new ShardId(new Index("test", "_na_"), 0);
            state = WriterState.CLOSED;
    }
     * Helper: creates a DFA engine with a committer that can inject failures.
        // Committed data should still be accessible from the committer
                equalTo(engine.getProcessedLocalCheckpoint())
            new DocumentLookupResult("1", 1L, true, null, 0L, 1L, Map.of(), Map.of())
            for (int i = 0; i < 20; i++) {
                assertThat("op must have an assigned seqNo", result.getSeqNo(), equalTo((long) i));
            }
                IllegalStateException.class,
        }
        MockIndexingExecutionEngine indexingEngine = new MockIndexingExecutionEngine(df);
            assertThat("a post-GET op re-enters the still-open scope as pending", third.getTranslogLocation(), nullValue());
            Engine.DeleteResult deleteResult = engine.delete(deleteOp("1"));
                "no op may be published before the pending read forces the append",
            .mergePolicy(NoMergePolicy.INSTANCE)
            int numDocs = between(maxDocs + 1, maxDocs * 2);
            org.apache.lucene.index.CorruptIndexException corruption = new org.apache.lucene.index.CorruptIndexException(
    }
    @SuppressForbidden(reason = "test needs reflective access to inject a writer into flushQueue")
    private static final class FailingFlushIndexingExecutionEngine extends MockIndexingExecutionEngine {
            assertEquals(5L, engine.getSeqNoStats(SequenceNumbers.NO_OPS_PERFORMED).getMaxSeqNo());
            int totalDocs = randomIntBetween(50, 100);
                                assertThat(reader.catalogSnapshot().getSegments().size(), greaterThan(0));
        engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        );
    // Pure-delete refresh coverage
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                assertThat(snapshot.getId(), greaterThanOrEqualTo(0L));
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
                assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) i));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
                "the processed checkpoint must not advance while batches are pending",
            engine.index(indexOp(createParsedDoc("1", null)));
            engine.index(indexOp(createParsedDocWithInput("1", null)));
    }
            )
        assertThat("the recorded engine failure must be the tragic exception itself", outcome.engineFailures.get(0), sameInstance(tragic));
        StringBuilder callOrder = new StringBuilder();
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(orderingListener), List.of());
            }
import org.apache.lucene.search.ReferenceManager;
    }
                try {
            java.lang.reflect.Field currentField = maps.getClass().getDeclaredField("current");
            engine.index(indexOp(createParsedDoc("2", null)));
     *   <li>Two ops ("1","2") are indexed into the SAME pending chunk. Before the GET, both must be unpublished
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
                externalCalls.incrementAndGet();
     */
            assertNull("concurrent freezeForTiering must not throw", error.get());
                primaryTerm.get(),
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            // Simulate disk full as CorruptIndexException during commit
            this.ownerFailure = ownerFailure;
            assertThat("location deferred before any flush", result.getTranslogLocation(), nullValue());
        when(documentMapper.getVersion()).thenReturn(1L);
        MockDataFormatPlugin normalPlugin = MockDataFormatPlugin.of(mockDataFormat);
        }
            SequenceNumbers.UNASSIGNED_SEQ_NO,
     * can assert that at least one writer entered the flow.
        Path translogPath = createTempDir();
            .mapperService(mapperService)
import org.opensearch.index.engine.exec.Segment;
                            ParsedDocument doc = createParsedDocWithInput(threadId + "_" + d, null);
    private static int flushQueueSize(DataFormatAwareEngine engine) throws Exception {
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
     * listeners (beforeRefresh is always called) but afterRefresh should indicate
            int docsPerThread = randomIntBetween(10, 30);
    /**
        }
            // Refresh and flush work
            engine.refresh("test");
            assertThat(deleteResult.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            // Inject a writer directly into the flushQueue (simulates a writer that was
                IllegalStateException.class,
        ReferenceManager.RefreshListener external = new ReferenceManager.RefreshListener() {
            Engine.DeleteResult deleted = engine.delete(deleteOp("del"));
    public void testFreezeForTieringIsIdempotent() throws IOException {
    /**
        }
        );
import org.opensearch.index.engine.dataformat.RefreshResult;
                new DocumentLookupResult("c", 1L, true, null, 3L, 1L, Map.of(), Map.of()),
                        failures.incrementAndGet();
        }
        DataFormatAwareEngine getEngine() {
            })
            for (int t = 0; t < numThreads; t++) {
import static org.mockito.Mockito.doReturn;
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            flushThread.start();
import org.opensearch.index.translog.TranslogDeletionPolicy;
     * <p>The refresh runs on its own thread so a deadlock surfaces as a failed join rather than a hung suite. Returns
                ParsedDocument doc = createParsedDocWithInput(Integer.toString(i), null);
            Engine.Operation.Origin.PRIMARY,
        engine.close();
            this.dataFormat = dataFormat;
        } finally {
                out.add(s);
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true, true, false)) {
            AlreadyClosedException refreshEx = expectThrows(AlreadyClosedException.class, () -> engine.refresh("post-fail"));
            public void beforeRefresh() {
                    "processed checkpoint must advance safely to the contiguous max after the fence",
            assertThat(delete.getIfSeqNo(), equalTo(7L));
        engine.index(indexOp(createParsedDocWithInput("1", null)));
        MockDataFormatPlugin failingPlugin = MockDataFormatPlugin.of(mockDataFormat).withIndexingEngine(settings -> failingEngine);
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
                // Not ideal — we can't access the engine from here directly.
                () -> engine.index(indexOp(createParsedDocWithInput("0", null)))
        Boolean appendOnly,
        EngineConfig config = buildFailingEngineConfig(plugin);
            boolean closed;
            long heldGen = ref.get().getGeneration();
            assertFalse("reader thread must not still be running (no deadlock)", reader.isAlive());
            int n = randomIntBetween(2, 5);
                assertThat(newRef.get().getGeneration(), greaterThan(heldGen));
                for (StackTraceElement frame : refresher.getStackTrace()) {
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        boolean enabled,
    }
    }
        }
            eng.refresh("verify-still-open");
            ref.close();
                });
                .build()
     *       a closed pool, no second {@code AlreadyClosedException} from closing closed resources, as the thrown chain
            // After closing, we should still be able to acquire new readers
            try {
                    } catch (Exception e) {
                    try (GatedCloseable<CatalogSnapshot> ref = eng.acquireSnapshot()) {
            assertThat("event listener must observe the failure", failedEngineCause.get(), notNullValue());
    /** With no gap (lcp == max), fillSeqNoGaps writes 0 NoOps and returns 0. */
            -1,
        try {
                        break;
            public void afterRefresh(boolean didRefresh) {
    }
            Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
                threads[t] = new Thread(() -> {
                } catch (Exception e) {
            translogPath,
                        engine.index(indexOp(createParsedDocWithInput(Integer.toString(i++), null)));
     * the processed checkpoint. The commit therefore records a checkpoint that is AHEAD of what
            BigArrays.NON_RECYCLING_INSTANCE,
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), tieringState);
            assertThat("opt-in must produce a real (non-no-op) batch", batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
    public void testConcurrentIndexAndRefresh() throws Exception {
    public void testGetSeqNoStatsAfterConcurrentIndexingAndRefresh() throws Exception {
        } finally {
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        }
            final AtomicReference<Exception> failure = new AtomicReference<>();
import org.opensearch.index.mapper.MapperService;
    }
        }
                equalTo(deletesAfterFirstReplay)
                "translog grew by 4 NoOps",
                "merge must not invoke beforeRefresh on a non-remote-store listener",
    /**
            @Override
                IndexReaderProvider.Reader reader = readerRef.get();
                (java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>>) queueField.get(engine);
            assertThat(ref.get().getGeneration(), equalTo(heldGen));
        List<ReferenceManager.RefreshListener> externalListeners,
    public void testPreIndexSkipsWhenCheckPendingFlushDisabled() throws Exception {
        }
            .primaryTermSupplier(primaryTerm::get)
    public void testApplyMergeChangesUpdatesCatalogAndSkipsNonRemoteStoreListeners() throws Exception {
                work.push(s);
                }
     * {@code applyReadVersionConflicts} dropped it, returning the current document for a request
     * </ul>
            engine.refresh("test");
            })
            @Override
                    } catch (Exception e) {
    }
            BigArrays.NON_RECYCLING_INSTANCE,
            .mapperService(mapperService)
    /** An unsupported delete does not fail the engine. */
        }
        doReturn(2048L).when(deleteEngine).ramBytesUsed();
                primaryTerm.get(),
import org.opensearch.Version;
            engine.refresh("first");
            java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");
    public void testRefreshAdvancesSnapshotGeneration() throws IOException {
                assertThat(
                }
            // --- Path 7: translog readOperation returns null (bogus location) ---
    public void testIndexOperationsWrittenToTranslog() throws IOException {
    /**
            assertThat(delete.version(), equalTo(3L));
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
    }
            failingCommitter.setCommitFailure(new IOException(new OutOfMemoryError("fake OOM during commit")));
     * Tests that engine close is graceful when concurrent index, refresh, and flush operations
            if (current.getCause() != null && current.getCause() != current) {
                threads[t].start();
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
    private static List<Throwable> allSuppressed(Throwable t) {
            // Produce two segments via two refresh cycles so the merger has something to combine.
                assertThat("translog location should be set", result.getTranslogLocation(), notNullValue());
     * count of the underlying translog generations.
    public void testCatalogSnapshotContainsFormatSpecificFiles() throws IOException {
        }
            FailingFlushWriter orphanWriter = new FailingFlushWriter(777L, mockDataFormat);
    private Engine.Get realtimeGet(String id) {
            // Index more docs so next refresh has unflushed segments to process
    }
        }
                () -> engine.index(indexOp(createParsedDocWithInput("0", null)))
    public void testBeginTranslogBatchOnClosedEngineThrowsAlreadyClosed() throws IOException {
            }
            }
            fmThread.start();
            .committerFactory(c -> new InMemoryCommitter(store))
                engine.refresh("test");
        engine.close();
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
            .dataFormatRegistry(registry)
                org.opensearch.index.engine.exec.Segment segment = snapshot.getSegments().get(0);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    }
    /**
            engine.close();
        return new Store(
            assertThat(failure.getMessage(), containsString("could not apply buffered deletes while retiring writer"));
            assertEquals("4 NoOps written for gap 3..6", 4, filled);
        TranslogConfig translogConfig = new TranslogConfig(
            assertThat(batch.finish(), equalTo(indexed.getTranslogLocation()));
            engine.translogManager().syncTranslog();
            notifySettingsChanged(engine);
        } finally {
                engine.getProcessedLocalCheckpoint(),
            base.id(),
                // Never leak workers if refresh or an assertion fails.
            refreshThread.start();
            for (int i = 0; i < numDocs; i++) {
        java.lang.reflect.Field queueField = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
            DocumentLookupResult result = getByIdLookup(engine, get);
        EngineConfig config = buildFailingEngineConfig(limitedPlugin);
                CatalogSnapshot snapshot = reader.catalogSnapshot();
                    }
            // Append-only under active safe access still stores the entry.
import org.opensearch.index.translog.InternalTranslogFactory;
    private FailingEngineResult createDFAEngineWithFailingCommitter(Store store, Path translogPath) throws IOException {
    }
        public org.opensearch.index.engine.dataformat.WriteResult addDoc(MockDocumentInput d) {
            }
            assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
            delegate.deleteCommit(snapshot);
                        containsString("Number of documents in shard " + shardId + " exceeds the limit of [" + maxDocs + "]")
        bootstrapStoreWithMetadata(store, uuid, 3L);
            Engine.Index op = indexOp(createParsedDocWithInput("1", null));
     * doc-count gap observed after a primary relocation under sustained ingest).
        public void close() {
        }
    }
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            int count = engine.countNumberOfHistoryOperations("test", 3, 7);
            long genBefore;
                    ref.get().getGeneration(),
            for (int i = 0; i < 5; i++) {
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            int refreshesBefore = indexingEngine.getRefreshCallCount();
            int numThreads = 8;
            assertThat(failedEngineCause.get().getMessage(), containsString("simulated flush failure"));
        Path translogPath = createTempDir();
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), greaterThanOrEqualTo(0));
            return true;
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) numBatches - 1));
        }
            engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
        }
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
    }
            assertThat("delete tracking must be added to version-map memory", stats.getVersionMapMemoryInBytes(), equalTo(2048L));
                if (didRefresh) {
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            engine.refresh("test");
            engine.refresh("after-close");
            long genBeforeFinalRefresh;
            // which marks the store corrupted before notifying listeners.
    @SuppressForbidden(reason = "test needs reflective access to inject writers into flushQueue")
                engine.close();
                deleteEngine.deletedIds().isEmpty()
                    try {
        IndexSettings indexSettings = engine.config().getIndexSettings();
                indexThreads[t] = new Thread(() -> {
                    assertNull(result.getFailure());
            Translog.Location finalMax = batch.finish();
        }
            // failEngine ran with the originating exception.
        engine.index(indexOp(createParsedDoc("1", null)));
            // Configure committer to throw non-corruption IOException on commit
                    assertThat("the refresh fence must publish every pending op", result.getTranslogLocation(), notNullValue());
            EngineConfig config = buildDFAEngineConfig(store, createTempDir()).toBuilder()
            // Flush should throw FlushFailedEngineException
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
        doThrow(new IOException("simulated drain failure")).when(deleteEngine).onWriterCheckedOut(anyLong());
     * {@code compareAndSet} guard must make this idempotent under concurrency: no thread throws, and
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
     * </ul>
            AtomicReference<Throwable> error = new AtomicReference<>();
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    /**
                assertThat(op1.opType(), equalTo(Translog.Operation.Type.INDEX));
        );
                "engine should not have failed for non-corruption IO error",
        );
        }
        ) {
    public void testAcquireReaderContainsFormatSpecificReader() throws IOException {
            @Override
                t.join();
            );
            Engine.Get get = realtimeGet("1");
        return new Engine.Delete(
            java.lang.reflect.Field queueField = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
        public org.opensearch.index.engine.dataformat.WriteResult addDoc(MockDocumentInput d) {
            public void beforeRefresh() {}
        // failEngine with null failure should still close the engine
            assertThat(
    ) throws IOException {
import org.opensearch.index.engine.dataformat.WriterState;
        );
     * (already drained).
                return result;
import org.opensearch.index.mapper.ParsedDocument;
        Map<String, String> committedData = committer.getLastCommittedData();
        bootstrapStoreWithMetadata(store, uuid);
        );
            // A version ahead of the stored one must conflict as well, not be silently served.
            Translog.Location bogusLocation = new Translog.Location(999L, 0L, 1);
        @Override
        }
     *
            );
            false,
        DrainFailureOutcome(
            rootCause(outcome.refreshFailure),
        AtomicInteger beforeCount = new AtomicInteger(0);
                );
        java.util.Collection<?> queue = (java.util.Collection<?>) f.get(engine);
        String tieringState,
            for (int i = 0; i < 1_000; i++) {
        }
        } finally {
            0
            assertThat(max, equalTo(second.getTranslogLocation()));
            assertThat(result.getTranslogLocation(), notNullValue());
                    } catch (AlreadyClosedException e) {
     * <ol>
        private volatile IOException commitFailure;
                    assertFalse("every worker must terminate (no deadlock)", worker.isAlive());
        // Create committer AFTER bootstrap so InMemoryCommitter can read segments info
    }
            }
        final RuntimeException ownerFailure;
            .build();
            });
            @Override
        bootstrapStoreWithMetadata(store, uuid);
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            @SuppressWarnings("unchecked")
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            MockIndexingExecutionEngine mockExecEngine = getMockExecutionEngine(engine);
                    far,
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
     * pool, so there are no write threads racing for it).
import static org.hamcrest.Matchers.equalTo;
    }
     *       firing {@link Engine.EventListener#onFailedEngine} so the shard is failed.</li>
            AtomicInteger failures = new AtomicInteger(0);
    /**
                }, "batch-worker-" + w);
            assertThat(count, greaterThan(0));
    public void testOnSettingsChangedUnfreezesOnReturnToHot() throws IOException {
    private EngineConfig buildFailingEngineConfig(MockDataFormatPlugin plugin, Engine.EventListener listener) throws IOException {
            for (int t = 0; t < numThreads; t++) {
            assertThat(result.getFailure().getMessage(), containsString("simulated addDoc failure"));
            // checked out of the pool for refresh but not yet flushed when engine closes).
        doReturn(1024L).when(deleteEngine).ramBytesUsed();
    public void testFrozenEngineSkipsRefreshExceptPrepareAndFlushSources() throws IOException {
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numBatches));
                .build();
            Thread[] threads = new Thread[numThreads];
    // ═══════════════════════════════════════════════════════════════
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        final List<Throwable> out = new ArrayList<>();
        MockIndexingExecutionEngine indexingEngine = new MockIndexingExecutionEngine(mockDataFormat);
        );
            })
            assertTrue(deleteEngine.deletedIds().isEmpty());
        for (int i = 0; i < numDocs; i++) {
            // Request only a subset of the range
            .externalRefreshListener(List.of(injector))
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
            "",
            .threadPool(threadPool)
            engine.refresh("test");
            // One indexed doc → one writer in the pool. Refresh thread will be the sole flusher.
     * Peer recovery / primary relocation relies on this to keep translog history available for the duration
            assertThat(max, equalTo(expectedMax));
     * Covers getById paths: delete check, version conflict, seqNo/primaryTerm conflict.
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("2", null))));
    }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    private Store store;
                engineFailureReasons.add(reason);
            );
                engine.refresh("cycle-" + i);
            MockIndexingExecutionEngine mockExecEngine = getMockExecutionEngine(engine);
            assertThat(engine.currentOngoingRefreshCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            return delegate.getCommitStats();
        Path translogPath,
            // Force merge while frozen returns early without scheduling a merge.
                    }
        bootstrapStoreWithMetadata(store, uuid);
        }
            int numThreads = randomIntBetween(3, 6);
            // Inject an expired DeleteVersionValue (time far in the past) so gc_deletes nullifies it
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(external), List.of(internal));
        threadPool = new TestThreadPool(getClass().getName());
     * and mark it unsafe (LiveVersionMap.maybePutIndexUnderLock else-branch).
        return new EngineConfig.Builder().shardId(shardId)
            engine.index(indexOp(createParsedDocWithInput("1", null)));
                results.add(result);
    /**
            }
    public void testIndexAddDocFailureReturnsFailureResult() throws Exception {
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
            failingCommitter.setCommitFailure(null);
            BigArrays.NON_RECYCLING_INSTANCE,
            refresher.start();
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            .build();
    }
        Settings newSettings = Settings.builder()
            shardId,
            long persistedRows;
        try {
            Engine.Get get = realtimeGet("1");
        );
            // Index 5 docs, refresh, flush to establish baseline
            primaryTerm.get(),
     */
            assertThat(stats.getCount(), equalTo(1L));
        return new DataFormatAwareEngine(buildDFAEngineConfig(store, translogPath));
            assertThat("refresh failure must wrap the IOException from flush", ex.getCause(), instanceOf(IOException.class));
            Map<String, String> commitData = new HashMap<>();
            for (int t = 0; t < numIndexThreads; t++) {
            Thread.sleep(200);
            // Index a doc so versionMap has an IndexVersionValue
                    engine.getProcessedLocalCheckpoint(),
                        for (int d = 0; d < docsPerThread; d++) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        @Override
    }
            Settings.builder()
                    -1,
            // Index docs and flush successfully first
                threads[t].start();
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                genAfter = ref.get().getGeneration();
            @Override
                        if (stop.get() == false) {
                assertThat(snapshot.getSegments().size(), equalTo(numBatches));
    public void testFailEngineAfterFlushPreservesCommittedData() throws IOException {
        PluginsService pluginsService = mock(PluginsService.class);
            .indexSettings(indexSettings)
            if (failures.get() > 0) {
            expectThrows(AlreadyClosedException.class, engine::ensureOpen);
    }
            engine.refresh("second");
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
     * newer pending entry, a realtime GET observes the update, and after finish the translog holds both in order.
            assertThat(rootCause(ownerFailure), sameInstance(failure));
                persistedRows = ref.get()
            // A force flush is the prepare path and must proceed.
    public void testGetByIdReturnsDocFromParquetAfterRefresh() throws IOException {
                assertNull(engine.resolveDocVersion(op, true));
            engine.refresh("setup");
    @Override
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                            synchronized (perWorkerResults) {
        public Map<String, String> getLastCommittedData() throws IOException {
                assertThat(snapshot.next(), nullValue());
            expectThrows(AlreadyClosedException.class, () -> engine.flush(false, true));
            // Verify store marked corrupted
            base.version(),
            }
            // --- Path 1: versionValue.isDelete() ---
            // beforeRefresh is always called (listener needs to prepare)
        ReferenceManager.RefreshListener listener = new ReferenceManager.RefreshListener() {
            assertThat(historyCount, greaterThanOrEqualTo(0));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        }
                IndexReaderProvider.Reader reader = readerRef.get();
            assertThat(vv.version, equalTo(1L));
        assertThat(ex.getMessage(), containsString("failed to restore version map"));
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
            this.dataFormat = dataFormat;
     */
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        bootstrapStoreWithMetadata(store, uuid, 5L);
     *  per-uid keyed lock is held, so callers must wrap in {@code versionMap.acquireLock(uid)}. */
            for (int i = 0; i < numDocs; i++) {
        @Override
                    }
    }
            try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, totalDocs - 1, false, true)) {
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDocWithInput("2", null))));
import org.opensearch.common.SuppressForbidden;
                        // Signal "indexed" and keep the scope open+pending until the main thread drives publication.
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            mockExecEngine.setRefreshFailure(() -> new IOException("disk full during refresh"));
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
    private EngineConfig buildDFAEngineConfig(
    }
            assertThat(extraResult.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            expectThrows(FlushFailedEngineException.class, () -> engine.flush(false, true));
            // Inject CorruptIndexException on commit
            queueField.setAccessible(true);
    }
        engine.close();
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
     * first {@code flush()} call. Tracks the number of writers it has created so tests
                        Thread.sleep(5);
            }
                workers[w] = new Thread(() -> {
    }
            assertSame("index ACE cause should be the original failure", originalCause, indexEx.getCause());
            }
        private final InMemoryCommitter delegate;
     * EXTERNAL version=3 hits isVersionConflictForWrites (IndexingStrategyPlanner) → conflict.
            assertThat(failures.get(), equalTo(0));
            );
            Thread[] threads = new Thread[numThreads];
            // These two bypass the freeze and are allowed to proceed.
     */
            Engine.Get stale = new Engine.Get(true, true, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))).version(1L);
            // Verify engine failed
        } finally {
                () -> engine.index(indexOp(createParsedDocWithInput("1", null)))
                AlreadyClosedException.class,
                );
            assertThat("cross-thread realtime GET must not fail", failure.get(), nullValue());
    /**
     * Same-thread realtime GET of a doc whose translog location is still pending (indexed earlier in the same batch
     * Outcome of a refresh that drained another request's batch whose append failed.
                CatalogSnapshot snapshot = ref.get();
     */
            // depending on the configured threshold. The key assertion is it doesn't throw.
import org.opensearch.threadpool.TestThreadPool;
        List<Long> observedGenerations = new ArrayList<>();
                        startGate.await(10, TimeUnit.SECONDS);
        try {
    }
    public void testFlushWithCommitCorruptionFailsEngineAndMarksStore() throws Exception {
            final CyclicBarrier startGate = new CyclicBarrier(numWorkers);
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
            // Unrecognized value is treated as not frozen — indexing still works.
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            // Reject the update's addDoc with a modeled per-doc failure that the writer has already reconciled.
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            Thread[] threads = new Thread[freezers + 1];
                assertThat(op2.opType(), equalTo(Translog.Operation.Type.INDEX));
            flusher.join();
                beforeCalls.get() - beforeAfterSeed,
        public long mappingVersion() {
        CommitterFactory committerFactory = config -> new InMemoryCommitter(store);
            // Optimized append-only: no safe access enforced, nothing stored in the current map.
            public void afterRefresh(boolean didRefresh) {
        DocumentLookupProvider provider = mockLookupProvider();
            .internalRefreshListener(List.of())
            // Bulk thread: open a scope and leave one deferred index op pending in it.
        }
            List<org.opensearch.index.engine.Segment> segments = engine.segments(false);
                beforeCount.incrementAndGet();
            store,
                3L,
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
                beforeCalls.incrementAndGet();
        } finally {
                assertThat(ref.get().getSegments().size(), greaterThan(0));
        return result.exists() ? ((DocumentLookupResult.PreMaterialized) result).lookup() : DocumentLookupResult.notFound(get.id());
        engine.index(indexOp(createParsedDoc("1", null)));
            assertEquals("max advanced via recovery op", 7L, engine.getSeqNoStats(SequenceNumbers.NO_OPS_PERFORMED).getMaxSeqNo());
            int numDocs = randomIntBetween(1, 5);
        MapperService mapperService = mock(MapperService.class);
            MockDeleteExecutionEngine deleteEngine = getMockDeleteEngine(engine);
            );
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
            mapsField.setAccessible(true);
            // Now inject refresh failure — next refresh will fail the engine
            assertEquals("4 NoOps written for gap 1..4", 4, firstFill);
     */
                refreshNeeded());
                    failure.set(e);
            expectThrows(AlreadyClosedException.class, () -> engine.refresh("post-fail"));
                assertThat(
                new Term(IdFieldMapper.NAME, Uid.encodeId(far.id())),
            assertThat(vv.seqNo, equalTo(0L));
    public void testFailEngineWithNonCorruptionDoesNotMarkStoreCorrupted() throws IOException {
            public void onFailedEngine(String reason, Exception e) {
            assertThat("both ops become processed contiguously after the forced append", engine.getProcessedLocalCheckpoint(), equalTo(1L));
        }
    }
            assertNotNull("engine should have failed", failable.getFailedEngine());
            for (Thread t : threads)
            }
            false
        final EngineConfig config = buildBatchDFAEngineConfig(
            // --- Path 5: seqNo and primaryTerm both match — no conflict, falls through ---
            Store.OnClose.EMPTY,
        } finally {
                    try {
            }
    public void testResolveDocVersionReturnsNullOnEmptyCatalog() throws Exception {
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                assertFalse("thread should have completed", t.isAlive());
            assertThat(replay.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            // Snapshot should exist and have segments
            }
     * Builds an EngineConfig using a real DataFormatRegistry built from the given plugin,
    /** resolveDocVersion branch 6: versionMap hit returns the stored IndexVersionValue. */
     * checkpoint is read) it lands in a NEW writer that is not in the snapshot, yet it advances
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            }
            doc,
            }
            expectThrows(AlreadyClosedException.class, () -> engine.flush(false, true));
            assertThat(engine.countNumberOfHistoryOperations("test", numDocs, Long.MAX_VALUE), equalTo(0));
            assertThat(delete.uid(), equalTo(new Term(IdFieldMapper.NAME, Uid.encodeId("42"))));
                deleteEngine.checkedOutGenerations().isEmpty()
        java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");
            // Arm the failure for the next batched append, which is the refresh's drain.
            // Run multiple non-waiting flushes concurrently — none should throw
        } finally {
    /**
     */
            assertEquals(4L, engine.getSeqNoStats(SequenceNumbers.NO_OPS_PERFORMED).getMaxSeqNo());
            VersionType.INTERNAL,
        Path translogPath,
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(29L));
    private DataFormatAwareEngine createDFAEngineWithLookupProvider(Store store, Path translogPath, DocumentLookupProvider provider)
                internalCalls.incrementAndGet();
            assertThat(second.getTranslogLocation(), nullValue());
    /** Reads {@code DataFormatAwareEngine.unpublishedDeletes} so tests can assert the flag without exposing it. */
        }
            Engine.Delete delete = engine.prepareDelete(
                    + persistedMaxSeqNo
        field.setAccessible(true);
            CountDownLatch indexingDone = new CountDownLatch(numIndexThreads);
        MapperService mapperService = mock(MapperService.class);
            }
            // Rendezvous so the reader's GET happens strictly after the pre-GET assertions above, with no sleeps.
            doc,
        }
            // The writer should have been moved to pendingWritersToClose.
     * {@code retireWriterIfNeeded} in the RETIRED_FLUSHABLE state.
            // Inject refresh failure via MockIndexingExecutionEngine
            readerRef.close();
            writer.setWriteResultSupplier(() -> new WriteResult.Failure(new IOException("simulated update rejection"), -1L, -1L, -1L));
            }
            stop.set(true);
        when(mapperService.documentMapper()).thenReturn(documentMapper);
                .setIfPrimaryTerm(1L);
    }
            doReturn(new DeleteResult.Failure(new IOException("simulated delete rejection"))).when(deleteEngine)
            for (int i = 0; i < 10; i++) {
            // Index more docs
                    }
    private static final class SuccessFlushWriter implements org.opensearch.index.engine.dataformat.Writer<MockDocumentInput> {
            List.of(
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, "-1");
        }
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            long genAfter;
    /** fillSeqNoGaps is idempotent — second call after the first finds nothing to do. */
            engine.activateThrottling();
            Thread refreshThread = new Thread(() -> {
        public org.opensearch.index.engine.dataformat.FileInfos flush(org.opensearch.index.engine.dataformat.FlushInput flushInput)
    }
                "op 2 (seqNo 1) must sort after op 1 (seqNo 0) in the translog",
            long genAfter;
    // --- Test: refresh failure with buffered unflushed segments ---
                    assertThat(result.getSeqNo(), greaterThanOrEqualTo(0L));
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
                        barrier.await();
                deleteEngine.checkedOutGenerations().contains(42L)
            Engine.Get current = new Engine.Get(true, true, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))).version(2L);
                assertThat(wfs.files().isEmpty(), equalTo(false));
            Settings.builder()
        }
            deletionPolicy.assertNoOpenTranslogRefs();
                    primaryTerm.get(),
                    for (int n = 0; n < iterations; n++) {
            assertThat(failures.get(), equalTo(0));
            -1,
                Translog.Operation op;
                assertThat(segment.dfGroupedSearchableFiles().containsKey(mockDataFormat.name()), equalTo(true));
            0
        AlreadyClosedException closed = expectThrows(AlreadyClosedException.class, engine::beginTranslogBatch);
    /** Updates the engine's live index settings to the given tiering state (without invoking onSettingsChanged). */
                    try {
                genBefore = ref.get().getGeneration();
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            assertThat(stats.getCount(), equalTo(0L));
                "simulated corruption during index",
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        MockDataFormatPlugin plugin,
            assertNotNull("engine should have failed from refresh IOException", failable.getFailedEngine());
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            long toSeqNo = 7;
                    assertThat(wfs.numRows(), equalTo(1L));
                "engine should have failed on primary with CorruptIndexException",
    private MockWriter getPooledMockWriter(DataFormatAwareEngine engine) {
            // The forced append keeps the scope open: later operations form a new chunk in the same bulk.
            );
            engine.failEngine(reason, failure);
            @Override
    }
            final List<Engine.IndexResult> results = new ArrayList<>();
     * An update is a second index of the same id inside the batch: both are deferred, the version map carries the
            assertTrue("Writer should be queued for deferred close", pendingClosers.contains(successWriter));
    public void testPreIndexFlushFailureFailsEngine() throws Exception {
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
            queueField.setAccessible(true);
            // The drain failure fails the engine, which closes the translog; the trailing no-op
            assertThat(delete.origin(), equalTo(Engine.Operation.Origin.PRIMARY));
            assertNotNull("engine should have failed", new FailableDataFormatAwareEngine(engine).getFailedEngine());
        }
        }
            .committerFactory(committerFactory)
                equalTo(refreshesBefore)
        }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            }
        Path translogPath,
            assertEquals(5L, engine.getProcessedLocalCheckpoint());
            assertThat("the two bulks must share one contiguous seqNo range", assignedSeqNos, equalTo(expectedSeqNos));
        final IOException nonTragic = new IOException("simulated non-tragic batch append failure");
                    try {
            engine2.flush(false, true);
                CatalogSnapshot snapshot = ref.get();
                work.push(current.getCause());
            @Override
     */
            public void afterRefresh(boolean didRefresh) {
        }
            // committedCheckpoint+1 and silently drops (persistedMaxSeqNo, committedCheckpoint].
            int numDocs = randomIntBetween(3, 10);
    }
            }
            engine.index(indexOp(createParsedDocWithInput("1", null)));
                genAfter = ref.get().getGeneration();
            });
     * translog location stays deferred while the batch is open. The workers then park on a gate, holding their scopes
        field.setAccessible(true);
        DocumentLookupProvider documentLookupProvider,
        DocumentLookupProvider provider = mockLookupProvider();
                        }
        }
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                // Seed cycles contribute "BABA"; the merge must append nothing for this listener.
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
            int numDocs = randomIntBetween(3, 10);
        when(provider.getById(any(), any(), any(), any())).thenReturn(
                assertThat(ref.get().getGeneration(), equalTo(2L));
            );
            assertThat("onFailedEngine should be called exactly once", onFailedCount.get(), equalTo(1));
            assertThat("afterRefresh(didRefresh=true) confirms data is now searchable", afterDidRefreshTrue.get(), equalTo(1L));
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            for (int i = 0; i < 5; i++) {
     * assert the engine-level invariant the fix must restore: the committed
        }
            engine.close();
    }
    /** {@link DataFormatAwareEngine#prepareDelete} builds an Engine.Delete carrying the id, uid, and CAS terms. */
                fail(dump.toString());
        @Override
                    } catch (Exception e) {
                    try {
            shardId,
            engine.refresh("post-merge");
     */
    public void testPureDeleteRefreshAppliesDeletesAndDropsGeneration() throws Exception {
            engine.freezeForTiering();
                        for (int d = 0; d < opsPerWorker; d++) {
                    try {
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
            assertThat(delete.seqNo(), equalTo(5L));
        when(documentMapper.getVersion()).thenReturn(1L);
                genBefore = ref.get().getGeneration();
        Store store,
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            settings.put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), appendOnly);
     * as before -- each result carries its location immediately and the processed checkpoint advances per op.
                // Verify the segment has exactly one format entry
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
            assertThat(failedUpdate.getResultType(), equalTo(Engine.Result.Type.FAILURE));
        for (Throwable suppressed : allSuppressed(outcome.refreshFailure)) {
    }
     * Covers getVersionFromMap unsafe path: versionMap.isUnsafe() triggers refresh + enforceSafeAccess.
            assertThat(failures.get(), equalTo(0));
            assertFalse("Flush thread should have stopped", flushThread.isAlive());
                }
     * {@code maybeFailEngine("delete", e)} and is rethrown. A plain I/O failure is not a corruption,
    public void testConstructorFreezesWhenOpenedMidTiering() throws IOException {
            assertTrue(versionMap.getAllCurrent().isEmpty());
                // No refresh has happened, so the format reader may be null
            );
        }
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
                for (org.opensearch.index.engine.exec.Segment segment : snapshot.getSegments()) {
        }
            int numDocs = randomIntBetween(10, 20);
                    }
        }
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM
            engine.flush(false, true);
     * op at a higher seqNo. The recovery op processes its own seqNo but leaves a gap below
import org.apache.lucene.index.IndexWriterConfig;
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        public boolean isSchemaMutable() {
                @Override
            engine.refresh("test");
                    new Term(IdFieldMapper.NAME, Uid.encodeId(far.id())),
            engine.translogManager().syncTranslog();
        }
        engine.onSettingsChanged(TimeValue.MINUS_ONE, org.opensearch.core.common.unit.ByteSizeValue.ZERO, 0L);
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
        DataFormatAwareEngine engine = new DataFormatAwareEngine(config);
    }
     */
            LiveVersionMap versionMap = (LiveVersionMap) vmField.get(engine);
                    false,
        while (current.getCause() != null && current.getCause() != current) {
            try (GatedCloseable<CatalogSnapshot> ref = eng.acquireSnapshot()) {
            AtomicInteger failures = new AtomicInteger(0);
                        batch.finish();
            // Engine is closed for all subsequent operations.
            final CountDownLatch indexedLatch = new CountDownLatch(numWorkers);
                    try (GatedCloseable<CatalogSnapshot> ref = eng.acquireSnapshot()) {
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));
            for (Thread t : threads)
    }
    /**
            engine.refresh("test");
            }
            }
     * Append-only optimizable variant of {@link #indexOp}: a non-negative autoGeneratedIdTimestamp
    public void testRetiredWriterDrainMarksUnpublishedDeletes() throws Exception {
        final Deque<Throwable> work = new ArrayDeque<>();
            assertTrue(cleanups >= 0);
            assertTrue(updated.exists());
            assertNotNull("should fall through when translog returns null", translogNullResult);
            // Flush should fail the engine via maybeFailEngine
    }
                @Override
                    return new InMemoryCommitter(store);
            java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>> queue =
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) totalDocs - 1));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        private final DataFormatAwareEngine engine;
            assertFalse("Index thread should have stopped", indexThread.isAlive());
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        AtomicInteger afterCount = new AtomicInteger(0);
                    WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(mockDataFormat.name());
                    + ") must not exceed the max seqno durably persisted in the snapshot ("
            assertThat("beforeRefresh must see pre-commit generation", genSeenInBefore.get(), equalTo(1L));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            .externalRefreshListener(List.of())
    @SuppressForbidden(reason = "test needs reflective access to the engine's versionMap field")
            engine.close();
                "processed checkpoint should reflect all indexed docs",
            synchronized (perWorkerResults) {
            reader.join(TimeUnit.SECONDS.toMillis(30));
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
 * compatible open source license.
            System.nanoTime(),
                assertThat(wfs.numRows(), equalTo((long) numDocs));
            failingCommitter.setCommitFailure(new IOException("disk error"));
    public void testBatchedAppendDisabledIsInlineBehaviour() throws IOException {
                            maxSeqNo.accumulateAndGet(result.getSeqNo(), Math::max);
            // Collect every worker's results so the main thread can assert on their published state.
        return new DataFormatAwareEngine(buildDFAEngineConfig(store, translogPath, List.of(), List.of(), state.name()));
            public long maxIndexableDocs() {
            assertThat(second.getVersion(), equalTo(first.getVersion() + 1));
                engine.index(appendOnlyOp(createParsedDocWithInput(Integer.toString(i), null)));
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
            .committerFactory(c -> committer)
            final long persistedMaxSeqNo = persistedRows - 1; // contiguous 0..9 -> max seqno 9
        );
    public void testConcurrentIndexRefreshFlushEndToEnd() throws Exception {
            indexSettings,
        DocumentLookupProvider provider = mockLookupProvider();
    public void testAcquireHistoryRetentionLockPinsTranslogGeneration() throws IOException {
    /**
    /**
    private Store createStore() throws IOException {
        MockDeleteExecutionEngine deleteEngine = spy(new MockDeleteExecutionEngine(mockDataFormat));
    public void testConcurrentIndexing() throws Exception {
     * open and pending, so the main thread can drive publication deterministically with latches -- no sleeps, no
    public void testBeforeRefreshCalledBeforeSnapshotCommitAndAfterCalledAfter() throws IOException {
    }
        if (appendOnly != null) {
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
                assertThat("snapshot should contain all indexed ops", count, equalTo(numDocs));
        when(provider.getById(any(), any(), any(), any())).thenReturn(
            true,
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            }
    /** Explicit-id index with compare-and-set ifSeqNo/ifPrimaryTerm (for optimistic-concurrency tests). */
            return writersCreated.get();
            int numIndexThreads = randomIntBetween(2, 4);
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
    public void testRefreshAfterCloseThrows() throws IOException {
            assertThat(result.seqNo(), equalTo(0L));
     * <p>Mechanism: {@code flush()} calls {@code refresh("flush")} — which snapshots the
    private EngineConfig buildDFAEngineConfig(Store store, Path translogPath, DocumentLookupProvider documentLookupProvider) {
            Engine.Get get = new Engine.Get(false, false, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1")));
import org.opensearch.test.IndexSettingsModule;
                () -> engine.index(indexOp(createParsedDoc("post-fail", null)))
                VersionType.EXTERNAL,
            .threadPool(threadPool)
        public long generation() {
                engine.index(indexOp(createParsedDocWithInput("2", null)));
                    }
            engine.close();
     * operations whose seqNo falls within the requested {@code [fromSeqNo, toSeqNo]} range, de-duplicated --
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
            int filled = engine.fillSeqNoGaps(primaryTerm.get());
                }
            int numDocs = randomIntBetween(1, 5);
            // Non-realtime get falls through to provider
            // Refresh catches ACE → failOnTragicEvent → detect engine tragic → failEngine
            engine.refresh("first");
            // Close the engine while operations are in-flight
    }
            // Index first, then refresh — avoids writer pool race between
            }
            SequenceNumbers.UNASSIGNED_SEQ_NO,
     * of recovery.
        }
            // Index some docs and refresh to establish baseline
        }
     * The drained append is a NON-tragic translog failure (the translog stays open). Parity with the per-operation path
            assertEquals(1, segments.size());
            assertTrue("a drain that applied deletes must leave them marked unpublished", unpublishedDeletesOf(engine));
                    }
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
            .withIndexingEngine(settings -> indexingEngine)
            int numDocs = 10;
                java.util.Collection<WriterFileSet> searchableFiles = snapshot.getSearchableFiles(mockDataFormat.name());
        MockDataFormat df = mockDataFormat;
            .put(IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING.getKey(), enabled);
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
        expectThrows(AlreadyClosedException.class, () -> engine.refresh("after-close"));
    }
            assertThat(second.getTranslogLocation(), notNullValue());
            engine.index(indexOp(createParsedDocWithInput("1", null)));
        }
        when(documentMapper.getVersion()).thenReturn(1L);
            DocumentLookupResult deleteResult = getByIdLookup(engine, getForDelete);
        }
    /** resolveDocVersion branch 1: versionMap miss with no provider returns null. */
        final AtomicReference<FailingBatchAppendTranslog.ArmedFailure> armedFailure = new AtomicReference<>();
     * {@code RestGetAction} parses {@code version}/{@code version_type} and {@code ShardGetService}
import org.opensearch.index.IndexModule;
                        break;
import org.apache.lucene.store.Directory;
            java.lang.reflect.Field closersField = DataFormatAwareEngine.class.getDeclaredField("pendingWritersToClose");
            assertThat(delete.versionType(), equalTo(VersionType.EXTERNAL));
    private Engine.Delete deleteOpFromTranslog(String id, long seqNo) {
            // Flush — maybeFailEngine detects corruption and fails the engine
            for (Thread t : threads) {
            AtomicReference<Exception> failureCause = new AtomicReference<>();
            try {
            translogPath,
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {
        super.setUp();
            assertThat(engine.countNumberOfHistoryOperations("test", 3, 6), equalTo(4));
            engine.freezeForTiering(); // second call must be a no-op, not throw
            .build();
            // Index one more doc to ensure a writer exists in the pool after flush
            for (int i = 0; i < numDocs; i++) {
                    equalTo((long) numRefreshes + 1)
            for (int w = 0; w < numWorkers; w++) {
     * notifications. A reader manager uses these to know which snapshot generation
        DataFormatRegistry registry = createMockRegistry();
            final Set<Long> expectedSeqNos = new java.util.HashSet<>();
            setTieringStateSetting(engine, IndexModule.TieringState.HOT_TO_WARM);
        DataFormatAwareEngine engine = fer.engine();
     *
                new DocumentLookupResult("x", 2L, true, null, 5L, 1L, Map.of(), Map.of())
            eng.refresh("final");
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
                });
    }
    }
                t.join(10_000);
        TranslogConfig translogConfig = new TranslogConfig(
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo((long) numDocs - 1));
            final int opsPerWorker = 8;
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                    assertTrue("file should be a parquet file: " + fileName, fileName.endsWith(".parquet"));
        }
                }
            int filled = engine.fillSeqNoGaps(primaryTerm.get() + 1);
     * Covers the preIndex happy path: a writer in the flushQueue is successfully flushed
            // The listener must have been called: beforeRefresh once, afterRefresh(true) once
     *       with a contiguous seqNo set -- nothing is lost or duplicated.</li>
     *       or as suppressed exceptions;</li>
            engine.refresh("setup");
            ParsedDocument far = createParsedDocWithInput("7", null);
            assertTrue(versionMap.isUnsafe());
        }
            Settings.builder()
                CatalogSnapshot snapshot = ref.get();
        return provider;
        EngineConfig config = buildFailingEngineConfig(plugin);
     * Many threads call {@link DataFormatAwareEngine#freezeForTiering()} simultaneously. The atomic
    public void testCommitDataContainsRequiredMetadataKeys() throws IOException {
            // Index 5 docs successfully
    public void testSegmentsStatsWithIOException() throws IOException {
                });
                primaryTerm.get()
        try (Store store = createStore()) {
     * A writer that succeeds on flush, returning empty FileInfos. Used to test the
                        break;
            assertFalse("empty engine should not need periodic flush", needsFlush);
 * SPDX-License-Identifier: Apache-2.0
            .store(store)
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("x", null)));
        }
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));
        );
        for (Writer<?> w : engine.getWriterPool()) {
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("20", null))));
        Path translogPath = createTempDir();
        Path translogPath = createTempDir();
    /**
     * {@code LOCAL_CHECKPOINT = getProcessedCheckpoint()} read <b>after</b> that refresh. If a
        }
        engine.index(indexOp(createParsedDocWithInput("1", null)));
        int writersCreated() {
import org.opensearch.threadpool.ThreadPool;
            engine.flush(false, true);
        public CommitStats getCommitStats() {
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
        mockPlugin = MockDataFormatPlugin.of(mockDataFormat);
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            org.apache.lucene.util.BytesRef uid = new Term(IdFieldMapper.NAME, Uid.encodeId("1")).bytes();
                started.countDown();
        DocumentLookupProvider provider = mockLookupProvider();
     *       published only the requested entry or published out of seqNo order.</li>
                );
    }
    }
                far,
 * Tests for {@link DataFormatAwareEngine} covering the orchestration layer:
        DocumentLookupProvider provider = mockLookupProvider();
            long fromSeqNo = 3;
            indexThread.join(10_000);
    }
            refreshThread.join(30_000);
            engine.refresh("setup");
        MockDataFormat df = mockDataFormat;
                // 2 segments: one from first refresh, one from second
                SequenceNumbers.UNASSIGNED_SEQ_NO,
            }
import org.opensearch.common.settings.Settings;
            }
                threads[t].start();
     *
        return new Engine.Index(
            MockIndexingExecutionEngine mockExecEngine = getMockExecutionEngine(engine);
        Path translogPath = createTempDir();
            int historyCount = engine.countNumberOfHistoryOperations("test", 0, numDocs - 1);
            expectThrows(VersionConflictEngineException.class, () -> engine.getById(stale, (source, scope) -> null));
        Map<String, String> dataAfterFail = committer.getLastCommittedData();
                equalTo(SequenceNumbers.NO_OPS_PERFORMED)
            Engine.IndexResult extraResult = engine.index(indexOp(createParsedDoc("extra", null)));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            assertEquals("lcp blocked by gap at 3..6", 2L, engine.getProcessedLocalCheckpoint());
    }
        }
        Engine.EventListener listener
            translogPath,
        when(documentMapper.getVersion()).thenReturn(1L);
                new DocumentLookupResult("x", 1L, true, null, 2L, 1L, Map.of(), Map.of()),
        }
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            }
            for (int w = 0; w < numWorkers; w++) {
            assertThat(nextChunk.getTranslogLocation(), notNullValue());
            .withIndexingEngine(settings -> indexingEngine)
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
    public void testGetByIdFromSegmentsWithoutPreconditionIsUnaffected() throws IOException {
        }
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
        // Verify closed
                assertThat(ref.get().getSegments().size(), equalTo(2));
     * single thread toggles the tiering state setting (HOT_TO_WARM ⇄ HOT) and drives
    public void testAcquireSnapshotReturnsValidSnapshot() throws IOException {
            Engine.IndexResult stale = engine.index(indexOpWithVersion(createParsedDocWithInput("1", null), 3L, VersionType.EXTERNAL));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
     * non-null {@code DocumentInput} on every doc (it calls {@code addField} for version,
            return delegate.commit(commitInput);
        Settings.Builder settings = Settings.builder()
            engine.index(indexOp(createParsedDocWithInput("2", null)));
     * Builds an engine config wired to a custom data format plugin (whose writer can be
            assertTrue(deleted.isFound());
    private AtomicLong primaryTerm;
            engine.ensureOpen();
            }
            // Verify onFailedEngine called exactly once
     * no pending queue, and {@code onMergesDrained} fires the listener immediately
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("post-fail", null))));
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            Thread[] threads = new Thread[numSyncThreads];
            engine.index(indexOp(createParsedDocWithInput("0", null)));
     * Uses reflection to inject a DeleteVersionValue into versionMap since engine.delete() is unsupported.
import org.opensearch.common.concurrent.GatedCloseable;
    public void testTranslogSyncPersistsCheckpoint() throws IOException {
            SegmentsStats stats = engine.segmentsStats(false, false);
                "pure-delete refresh must have taken the dropped-generation path",
            for (int i = 0; i < 100; i++) {
        return new DataFormatRegistry(pluginsService);
        }
            for (String file : store.directory().listAll()) {
        DataFormatAwareEngine engine = new DataFormatAwareEngine(config);
            SuccessFlushWriter successWriter = new SuccessFlushWriter(42L, mockDataFormat);
        }
        Path translogPath,
            final Engine.IndexResult third = engine.index(indexOp(createParsedDocWithInput("3", null)));
            }
     */
    public void testFrozenEngineSkipsNonForceFlush() throws IOException {
            public void beforeRefresh() {
        Store store,
            IllegalStateException e = expectThrows(
                        error.compareAndSet(null, e);
            Thread[] threads = new Thread[numThreads];
    }
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            Engine.IndexResult nextChunk = engine.index(indexOp(createParsedDocWithInput("next", null)));
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            // beforeRefresh sees the OLD generation (snapshot not yet committed)
            }
        DocumentMapper documentMapper = mock(DocumentMapper.class);
        }
                false,
                threads[t] = new Thread(() -> {
            assertThat(indexed.getTranslogLocation(), notNullValue());
        f.setAccessible(true);
    public void testIndexAfterFailEngineThrowsAlreadyClosedWithOriginalCause() throws Exception {
                        for (int d = 0; d < docsPerThread; d++) {
    /** Creates a DFA engine whose index settings already carry the given tiering state (freeze-on-open path). */
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), mockLookupProvider())) {
     * begin its own) and index a fixed number of successful ops. Every op gets an assigned, contiguous seqNo but its
            .committerFactory(committerFactory)
            );
        try {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
            engine.index(indexOp(createParsedDocWithInput("1", null)));
    }
            }
                        for (int d = 0; d < docsPerThread; d++) {
    @SuppressForbidden(reason = "test needs reflective access to the engine's deleteExecutionEngine")
        }
        Store store,
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        Store getStore() {
            .withDeleteExecutionEngine(committer -> deleteEngine);
        }
    private java.util.concurrent.ConcurrentLinkedQueue<Writer<?>> flushQueueOf(DataFormatAwareEngine engine) throws Exception {
            // Flush → AlreadyClosedException with original cause
                primaryTerm.get(),
                    try {
                        failures.incrementAndGet();
            // Writer stayed ACTIVE → engine must remain open for subsequent operations.
                public void onFailedEngine(String reason, Exception e) {}
            // Phase 2: Refresh — makes data searchable
        DocumentLookupProvider provider = mockLookupProvider();
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(df)
            assertTrue("store should be marked corrupted", store.isMarkedCorrupted());
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                    }
                    + committedCheckpoint
    private Engine.Index appendOnlyOp(ParsedDocument doc) {
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {
                        barrier.await();
     * then triggers preIndex by calling {@code engine.index()}.
    }
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
        }
    ) {
        bootstrapStoreWithMetadata(store, uuid);
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            assertEquals(Engine.Result.Type.SUCCESS, engine.index(indexOp(createParsedDocWithInput("hot", null))).getResultType());
    }
    }
import java.util.concurrent.atomic.AtomicBoolean;
    /**
        );
            );
                Object formatReader = reader.reader(mockDataFormat);
    }
                externalCalls.incrementAndGet();
 */
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            // (ops are in translog buffer but not yet fsync'd)
            engine.flush(false, true);
            engine.flush(false, true);
            delegate.close();
 * catalog snapshot management, concurrency, and failure handling.
    private MockDataFormat mockDataFormat;
            engine.close();
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
    }
        return new Engine.Index(
    }
        Throwable current = t;
                try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            @Override
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(19L));
     * notified so it can unblock the waiting search request.
                assertThat(op2.opType(), equalTo(Translog.Operation.Type.DELETE));
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        Path translogPath = createTempDir();
                    try {
            }
            true,
     * the durable snapshot actually contains. On recovery, replay starts at {@code committed+1}
            for (int i = 0; i < numBatches; i++) {
        }
            assertThat("external listener must receive both before and after", externalCalls.get(), equalTo(2));
     * </ul>
                "after sync, persisted should catch up to processed",
     *   <li>Close the failing writer via {@code IOUtils.closeWhileHandlingException}.</li>
                );
            assertThat(
            Engine.IndexResult first = engine.index(indexOpWithVersion(createParsedDocWithInput("1", null), 5L, VersionType.EXTERNAL));
     */
            }, 10, java.util.concurrent.TimeUnit.SECONDS);
        AtomicInteger afterDidRefreshTrue = new AtomicInteger(0);
    public void testRefreshFailureWithBufferedSegmentsFailsEngine() throws Exception {
            engine.refresh("test");
                .primaryOperationPolicy(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE)
     * notifications to {@code RemoteStoreRefreshListener} instances only, so a plain
            java.lang.reflect.Field queueField = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
            assertNotNull("should not throw when seqNo and primaryTerm match", noConflictResult);
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
        @Override
            SuccessFlushWriter queuedWriter = new SuccessFlushWriter(42L, mockDataFormat);
                        eng.refresh("concurrent-refresh-" + i);
            assertThat(update.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            )
            EngineConfig config = buildDFAEngineConfig(store, createTempDir());
                equalTo(SequenceNumbers.NO_OPS_PERFORMED)
                }
    }
     * reports the (older) chunk location, which the bulk layer merges by maximum.
    /** Verifies that a delete-only refresh applies deletes and drops the emptied generation. */
            assertTrue("corruption marker file should exist on disk", foundCorruptionMarker);
     * have produced, so the shard-bulk is retried on the re-promoted primary before any Parquet or Lucene work is done.
            );
            this.delegate = new InMemoryCommitter(store);
    public void testConcurrentIndexAndRefreshDocCountNeverUnderCounts() throws Exception {
            }
            AtomicInteger failures = new AtomicInteger(0);
            engine.flush(false, true);
            Thread indexThread = new Thread(() -> {
        DataFormatRegistry registry = createMockRegistry();
     */
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), state.name())
            assertFalse(versionMap.isSafeAccessRequired());
import static org.mockito.Mockito.mock;
    @SuppressForbidden(reason = "test utility needs reflective access to verify internal queue state")
            AtomicInteger failures = new AtomicInteger(0);
    }
        AtomicLong genSeenInAfter = new AtomicLong(-1);
            assertThat(delete.id(), equalTo("42"));
    }
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            .build();
        java.lang.reflect.Field f = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
            int numDocs = randomIntBetween(1, 5);
    private ParsedDocument createParsedDoc(String id, String routing) {
     * A: write-path version conflict resolved from the versionMap. EXTERNAL version=5 then a stale
            engine.translogManager().syncTranslog();
            .externalRefreshListener(List.of())
        }
            indexSettings,
        Settings.Builder settings = Settings.builder()
            }
                final int threadId = t;
                final int threadId = t;
            engine.ensureOpen(); // Engine still alive
            assertThat("processed checkpoint before flush", engine.getProcessedLocalCheckpoint(), equalTo(9L));
            .translogConfig(translogConfig)
            assertEquals("no further NoOps on second call", 0, secondFill);
                7L,
            }
            assertThat(engine.getHistoryUUID(), notNullValue());
                        failureCause.set(e);
                        Thread.sleep(10);
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            Versions.MATCH_ANY,
            // Store should be marked corrupted (maybeFailEngine → Lucene.isCorruptionException → failEngine → markStoreCorrupted)
                public void onFailedEngine(String reason, Exception e) {}
     * fails the engine, whichever thread happened to drain the chunk.
import org.opensearch.index.engine.dataformat.stub.MockDeleteExecutionEngine;
            }
            // Inject a FailingFlushWriter directly into the flushQueue.
        }
                    5L,
            for (int i = 20; i < 30; i++) {
                threads[t].start();
            engine.translogManager().syncTranslog();
            );
            assertNotNull(
        return new DataFormatAwareEngine(
        // Store should be marked as corrupted
    }
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
        }
                            failure.compareAndSet(null, e);
            IOException originalCause = new IOException("original cause");
            java.util.Collection<?> pendingClosers = (java.util.Collection<?>) closersField.get(engine);
     * <p>The test asserts the full publication contract the batched-append design must uphold:
    public void testResolveDocVersionReturnsVersionMapHit() throws Exception {
            // The forced append published the WHOLE pending chunk, in seqNo order, not just the requested entry.
        try (
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
     */
        ShardPath shardPath = new ShardPath(false, path, path, shardId);
            assertNotNull("a drain failure while retiring must fail the engine", failure);
            for (int i = 0; i < numDocs; i++) {
            assertThat(
    private static final class DrainFailureOutcome {
            int numDocs = randomIntBetween(20, 50);
        }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            Thread fmThread = new Thread(() -> {
            // seqno actually present in the committed snapshot. Otherwise recovery replays from
            versionType,
                "42",
    public void testFillSeqNoGapsNoGap() throws IOException {
     * Use case: The ordering contract — beforeRefresh is called BEFORE the catalog
                0
    }
    }
    }
            .mergePolicy(NoMergePolicy.INSTANCE)
            List.of(new MockSearchBackEndPlugin(List.of(mockDataFormat.name())))
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
        );
            armed.set(true);
        }
    private Engine.Index indexOp(ParsedDocument doc) {
            // 3 successful PRIMARY ops → seqNos 0, 1, 2 / lcp = 2 / max = 2
        // Index and flush to commit data
        EngineConfig config = buildDFAEngineConfig(store, translogPath, provider);
        }
                } catch (Exception e) {
        engine.close();
    }
    public void testRefreshListenerNotifiedWhenNewDataBecomesSearchable() throws IOException {
            "test"
        public long mappingVersion() {
            // Phase 2 -- concurrent refresh fences every live scope, forcing all pending appends.
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            }
import org.opensearch.index.engine.dataformat.DeleteResult;
            engine.refresh("prepare_tiering");
            engine.index(indexOp(createParsedDocWithInput("1", null)));
import java.util.concurrent.atomic.AtomicReference;
            Versions.MATCH_ANY,
            assertThat("writeIndexingBuffer should trigger a refresh that advances the snapshot", genAfter, greaterThan(genBefore));
    }
    private void notifySettingsChanged(DataFormatAwareEngine engine) {
            }
            setTieringStateSetting(engine, IndexModule.TieringState.HOT);
                final int threadId = t;
        );
                    System.nanoTime(),
    }
                engineFailureReasons
        MockIndexingExecutionEngine limitedEngine = new MockIndexingExecutionEngine(mockDataFormat) {
            assertThat("the next chunk remains pending", nextChunk.getTranslogLocation(), nullValue());
            engineRef.set(engine);
                        for (int d = 0; d < docsPerThread; d++) {
                        barrier.await();
    }
        }
                    worker.join(TimeUnit.SECONDS.toMillis(30));
            // Insert establishes the copy that the update below would supersede.
                        }
    /**
                        engine.refresh("concurrent-test");
     * with a single merged segment, (2) restrict its beforeRefresh/afterRefresh
            }
            engine.refresh("test");
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, getWithPtConflict));
        super.tearDown();
            RefreshFailedEngineException ex = expectThrows(RefreshFailedEngineException.class, () -> engine.refresh("flush-failure-test"));
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
            return state;
            // After refresh, last refreshed checkpoint should be at the processed checkpoint
                sameInstance(tragic)
     * DFAE port of InternalEngineTests.testVersionMapAfterAutoIDDocument (delete step dropped —
            assertThat(engine.index(indexOp(createParsedDoc("1", null))).getResultType(), equalTo(Engine.Result.Type.SUCCESS));
    @SuppressForbidden(reason = "test needs reflective access to inject a failing writer into flushQueue")
            // complete without blocking, and the catalog generation must have advanced.
            // Verify engine failed
        final List<String> engineFailureReasons;
    private DataFormatAwareEngine createBatchDFAEngine(
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
                assertThat(
    }
            engine.index(indexOp(createParsedDoc("1", null)));
    }
            assertThat(delete.getIfPrimaryTerm(), equalTo(primaryTerm.get()));
     *   <li>Resolving the pending read for "1" must append the whole chunk, so BOTH "1" and "2" receive locations
     */
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
    }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            indexThread.start();
        }
                }
            Exception failedEngine = new FailableDataFormatAwareEngine(engine).getFailedEngine();
            @SuppressWarnings("unchecked")
     */
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
     * test drives the merge end-to-end without touching system properties.
            doc,
     *       (totalOps-1). Publication happens only after the translog append.</li>
    }
        try (Store store = createStore()) {
            assertTrue("an insert must not supersede anything", deleteEngine.deletedIds().isEmpty());
                Translog.Operation op2 = snapshot.next();
import org.opensearch.index.engine.dataformat.RowIdAwareWriter;
            // Configure MockWriter to throw CorruptIndexException as the addDoc cause.
            primaryTerm.get(),
    /**
                final StringBuilder dump = new StringBuilder("refresh did not complete; refresh thread stack:\n");
                () -> engine.index(indexOp(createParsedDocWithInput("0", null)))
            .eventListener(countingListener)
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            .store(store)
            // Now refresh after all indexing is done
    public void testResolveDocVersionReturnsNullWhenNoProvider() throws Exception {
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            sameInstance(tragic)
            .mapperService(mapperService)
                // The mock data format is registered as "composite" — the reader manager
            }
            }
        assertThat(
                t.join();
            for (int i = 0; i < n; i++) {
            AtomicLong maxSeqNo = new AtomicLong(-1);
     * can assert the queue is fully drained on failure paths without exposing internals.
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            // Simulate disk full as plain IOException (not corruption)
                        break;
                    assertThat("merge must collapse to a single segment", ref.get().getSegments().size(), equalTo(1));
            engine2.refresh("recovery-verify");
            System.nanoTime(),
        );
    }
     * catalog snapshot being available.
    }
            int numDocs = randomIntBetween(1, 5);
            // Index → AlreadyClosedException with original cause
            for (int i = 0; i < numDocs; i++) {
            IllegalStateException e = expectThrows(
     * new data becomes searchable. After indexing + refresh, the listener must be
                        for (int d = 0; d < docsPerThread; d++) {
            );
        }
        );
    public void testPrepareDeleteBuildsDeleteOperation() throws IOException {
        }
            vmField.setAccessible(true);
     * {@link DataFormatAwareEngine#countNumberOfHistoryOperations(String, long, long)} must count only the
            @Override
    }
    ) {
        final AtomicReference<DataFormatAwareEngine> engineRef = new AtomicReference<>();
            engine.close();
     *   <li>Reject subsequent operations with {@link AlreadyClosedException}.</li>
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    /**
    }
            engine.refresh("test");
            // The failing writer is still in the queue (never polled).
        }
            // No refresh, so the cached stats hold no segments and carry no file sizes.
            assertThat("each refresh must invoke beforeRefresh once", beforeAfterSeed, equalTo(2));
     * state ({@code failedEngine}, {@code store}) for direct testing via reflection.
            assertThat(indexedAfter.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        indexingEngine.setWriterCustomizer(writer -> writer.setEmptyFlushWhenNoDocs(true));
    }
        );
                if (i < maxDocs) {
            }
                engine.getProcessedLocalCheckpoint(),
    public void setUp() throws Exception {
            vmField.setAccessible(true);
        final boolean engineClosedAfterwards;
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDocWithInput("2", null))));
            assertThat(delete.getIfSeqNo(), equalTo(7L));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        );
        FailureInjectingCommitter failingCommitter = fer.committer();
            barrier.await();
            new DocumentLookupResult("1", 2L, true, null, 7L, 1L, Map.of(), Map.of())
            final int totalOps = numWorkers * opsPerWorker;
            assertThat("primary delete must be assigned a seqNo", result.getSeqNo(), greaterThanOrEqualTo(0L));
            id,
    public void testResolveDocVersionReturnsNullWhenProviderNotFound() throws Exception {
            // Fail engine with a known cause
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat)
        });
            vmField.setAccessible(true);
        @Override
            final int numWorkers = 2;
    ) throws Exception {
    public void testEngineRecoveryAfterFailurePreservesCommittedData() throws Exception {
            threads[freezers].start();
            Engine.IndexResult indexedAfter = engine.index(indexOp(createParsedDocWithInput("2", null)));
                    assertThat("seq no must not be assigned on rejection", result.getSeqNo(), equalTo(SequenceNumbers.UNASSIGNED_SEQ_NO));
                    } catch (Exception e) {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            engine.refresh("baseline");
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
                t.join();
            // INVARIANT the fix must restore: committed LOCAL_CHECKPOINT must not exceed the max
                            }
     * previously-refreshed segments must (1) replace the source segments in the catalog
        boolean enabled,
            LiveVersionMap versionMap = (LiveVersionMap) vmField.get(engine);
                        setTieringStateSetting(engine, IndexModule.TieringState.HOT_TO_WARM);
            }
    private EngineConfig buildFailingEngineConfig(MockDataFormatPlugin plugin) throws IOException {
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
     * freeze-state CAS rather than {@code IndexSettings} concurrency. After the storm, driving a
    public void testIOExceptionDuringRefreshFailsEngine() throws IOException {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            // A second flush has no new work and returns the same cumulative max location.
        when(provider.getById(any(), any(), any(), any())).thenReturn(
import org.opensearch.index.get.DocumentLookupResult;
            FailingBatchAppendTranslog.factory(armedFailure),
                    gate.await(10, TimeUnit.SECONDS);
            return new RefreshResult(result.refreshedSegments(), dropped);
                started.countDown();
            // Full range counts every operation.
        List<ReferenceManager.RefreshListener> internalListeners
        assertThat("refresh must fail when the drained append fails", outcome.refreshFailure, notNullValue());
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    }
                threads[t].start();
            }
    // --- Test: failEngine with null failure ---
    public void testGetByIdDeleteAndConflictPaths() throws Exception {
     */
        int numDocs = randomIntBetween(3, 10);
                            }
            Engine.Operation.Origin.PRIMARY,
            engine.refresh("test");
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
        DocumentLookupProvider provider = mockLookupProvider();
                }
                assertThat(wfs.writerGeneration(), equalTo(segment.generation()));
     *   <li>The shared {@code flushQueue} must not leak items that the next refresh would
            // These sources are skipped while frozen (no exception, simply a no-op).
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
            writer.setFailureKeepsActive(true);
            java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");
            flushThread.join(10_000);
                t.join();
            .store(store)
            @Override
    }
            assertThat(engine.segmentsStats(false, false).getVersionMapMemoryInBytes(), equalTo(1024L));
                final int id = t;
            }
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            IllegalStateException e = expectThrows(IllegalStateException.class, () -> new DataFormatAwareEngine(config));
                    failureCause.set(e);
    // --- Tiering freeze behavior ---
                                successCount.incrementAndGet();
            assertThat(stats.getLocalCheckpoint(), equalTo((long) numDocs - 1));
            Engine.IndexResult second = engine.index(indexOp(createParsedDocWithInput("upd", null)));
            engine.index(appendOnlyOp(createParsedDocWithInput("2", null)));
     * Use case: Multiple index-refresh cycles should produce monotonically advancing
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), mockLookupProvider())) {
            assertThat(engine.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            }
                new DocumentLookupResult("x", 2L, true, null, 5L, 1L, Map.of(), Map.of()),
    }
            int numDocs = 10;
            final AtomicReference<Throwable> refreshOutcome = new AtomicReference<>();
            .tombstoneDocSupplier(tombstoneDocSupplier())
                    greaterThan(genBeforeFinalRefresh)
            for (int i = 0; i < numDocs; i++) {
            // No retention locks are held before acquiring one.
            engine.refresh("stats");
            int totalDocs = numThreads * docsPerThread;
    }
            // Full trimming depends on the committer advancing the persisted checkpoint
    public void testConcurrentAcquireReader() throws Exception {
            assertTrue(stats.getIndexWriterMemoryInBytes() >= 0);
            // Before sync, persisted checkpoint may lag
     *       so the IndexShard can react.</li>
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDocWithInput("1", null))));
            Engine.IndexResult result = engine.index(indexOp(createParsedDoc("1", null)));
        ParsedDocument base = EngineTestCase.createParsedDoc(id, routing);
        };
import org.opensearch.test.DummyShardLock;
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        return buildDFAEngineConfig(store, translogPath, externalListeners, internalListeners, tieringState, documentLookupProvider, null);
            AlreadyClosedException flushEx = expectThrows(AlreadyClosedException.class, () -> engine.flush(false, true));
     * fails with {@code failure}, either tragically (translog records it and closes) or not.
        }
            assertThat("finish must return the greatest location appended by the scope", finalMax, equalTo(third.getTranslogLocation()));
                        throw new java.io.UncheckedIOException(e);
            engine.close();
    }
            assertThat(gcResult.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
    public void testSegmentsWithIOException() throws IOException {
            // Sync translog so persisted checkpoint advances
     */
import java.io.IOException;
            }
        EngineConfig config = buildFailingEngineConfig(plugin);
        return new Engine.Get(true, true, id, new Term(IdFieldMapper.NAME, Uid.encodeId(id)));
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        engine.close();
            assertTrue(engine.isThrottled());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
            }
        Store store,
            for (int i = 0; i < 20; i++) {
     * Covers restoreVersionMapAndCheckpointTracker + compareOpToVersionMapOnSeqNo.
                return maxDocs;
import org.opensearch.index.mapper.SeqNoFieldMapper;
                    foundCorruptionMarker = true;
            // Explicit-id index of the same id: enforces safe access and stores the entry.
        FailureInjectingCommitter failingCommitter = fer.committer();
        }
            .indexSettings(indexSettings)
            failingCommitter.setCommitFailure(new org.apache.lucene.index.CorruptIndexException("No space left on device", "test"));
        // Bootstrap with maxSeqNo=3, localCheckpoint=-1 (triggers restore)
            expectThrows(AlreadyClosedException.class, engine::ensureOpen);
                        }
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
     *
        final AtomicBoolean armed = new AtomicBoolean(false);
        try {
        DocumentLookupProvider documentLookupProvider
                closed = true;
                    newReaderRef.get().catalogSnapshot().getGeneration(),
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            assertThat(stats.getGlobalCheckpoint(), equalTo((long) numDocs - 1));
                IndexReaderProvider.Reader reader = readerRef.get();
        } finally {
    }
            }
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            expectThrows(RefreshFailedEngineException.class, () -> engine.refresh("partial-cycle-flush-failure"));
        }
     * and stores the entry; safe access is carried over across refresh.
            java.lang.reflect.Method markUnsafe = current.getClass().getDeclaredMethod("markAsUnsafe");
            }
        mockDataFormat = new MockDataFormat("composite", 100L, Set.of());
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
     * AFTER (so listeners can observe the new state). This is critical for reader
                    }
            assertTrue("doc should be found from parquet", result.exists());
    }
            // Disarm so the owner's finish() and the probe below exercise the engine, not the injection.
    /**
                .put(indexSettings.getSettings())
        }
            assertThat(engine.countNumberOfHistoryOperations("test", 5, 9), equalTo(5));
            });
        try {
import org.opensearch.index.engine.dataformat.stub.MockIndexingExecutionEngine;
            assertThat(failures.get(), equalTo(0));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    /** Explicit-id index with a caller-supplied version/versionType (for version-conflict tests). */
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
    }
    private EngineConfig buildBatchDFAEngineConfig(
    }
        }
    }
    /** resolveDocVersion branch 2: versionMap miss with an empty catalog returns null (provider not consulted). */
            // append for the failed index op is then rejected.
        );
import org.apache.lucene.index.IndexWriter;
    public void testNonWaitingFlushReturnsImmediatelyIfOngoing() throws Exception {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    public void testPreIndexFlushDrainMarksUnpublishedDeletes() throws Exception {
            .mergePolicy(NoMergePolicy.INSTANCE)
    public void testGetByIdFromSegmentsAcceptsCurrentIfSeqNo() throws IOException {
                        }
            Engine.Get getForDelete = realtimeGet("1");
                assertThat("every acknowledged op must be replayable from the translog", replayedSeqNos, equalTo(expectedSeqNos));
            assertEquals(1, stats.getCount());
     */
        }
        bootstrapStoreWithMetadata(store, translogUUID, SequenceNumbers.NO_OPS_PERFORMED);
            }
                    } catch (InterruptedException e) {
        Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
     * and the band in between is seeded as "already processed", so it is never replayed — the
        assertThat(dataAfterFail, equalTo(committedData));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            // No unexpected exceptions
                    try {
        assertTrue("store should be marked corrupted", store.isMarkedCorrupted());
            .mapperService(mapperService)
            // --- Path 3: seqNo/primaryTerm conflict (seqNo matches, primaryTerm doesn't) ---
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {
            SegmentsStats stats = engine.segmentsStats(true, false);
            "test",
                translogOpsBefore + 4,
     * (the fsync callback does that).
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
        // Return all seqNos 0-5 so checkpoint advances, with duplicate id "x" at seqNo 2 and 5
                });
                versionMap.putIndexUnderLock(uid, new IndexVersionValue(null, 5L, 0L, 1L));
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
    }
            flushQueueOf(engine).add(queuedWriter);
            null,
            }
            // Verify engine is fully operational — can index new docs
                Engine.IndexResult result = eng.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            engine.refresh("test");
        Path translogPath,
                    try {
        }
            seqNo,
        @Override
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    /**
        ReferenceManager.RefreshListener listener = new ReferenceManager.RefreshListener() {
        when(provider.getDocsAboveSeqNo(anyLong(), any(), any(), any())).thenReturn(
                throw new AssertionError("failure while performing test: " + failureCause.get());
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            }
            indent += "  ";
            long persisted = engine.getPersistedLocalCheckpoint();
            Thread[] indexThreads = new Thread[numIndexThreads];
            AlreadyClosedException ex = expectThrows(
                secondPending.getTranslogLocation().compareTo(first.getTranslogLocation()),
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            }
            IllegalStateException e = expectThrows(
 * from any specific data format implementation.</p>
     * The engine must have indexed at least one doc so a writer exists in the pool.
    }
            for (int i = 0; i < numDocs; i++) {
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            "a non-tragic append failure must not fail the engine, but it was failed with reasons " + outcome.engineFailureReasons,
                assertThat("reader for the registered data format should be present", formatReader, notNullValue());
    private ShardId shardId;
            for (Thread t : indexThreads)
            assertThat(engine.getIndexThrottleTimeInMillis(), equalTo(0L));
                assertThat("all concurrently indexed ops should be in the translog snapshot", count, equalTo(totalDocs));
    }
    public void testAcquireReaderBeforeRefreshReturnsEmptyReaders() throws IOException {
            // Verify all 10 docs committed via checkpoint
        List<ReferenceManager.RefreshListener> internalListeners,
    public void testConcurrentFreezeAndSettingsUnfreeze_ConvergesConsistently() throws Exception {
import org.opensearch.indices.replication.common.ReplicationType;
        boolean remoteStore
            // Even with a failing writer in the queue, preIndex should skip it.
            FailableDataFormatAwareEngine failable = new FailableDataFormatAwareEngine(engine);
    }
    }
     */
            }
        writer.setWriteResultSupplier(() -> {
            .mergePolicy(NoMergePolicy.INSTANCE)
import org.opensearch.plugins.SearchBackEndPlugin;
                assertNull(engine.resolveDocVersion(op, true));
            // Store should be marked corrupted
            }
            engine.index(indexOp(createParsedDocWithInput("0", null)));
     * {@code LOCAL_CHECKPOINT} must NOT exceed the highest seqno durably persisted in the
                assertThat("two segments before merge", ref.get().getSegments().size(), equalTo(2));
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> deleteEngine);
        Store store,
                IndexReaderProvider.Reader reader = readerRef.get();
        }
            // Index all docs first
import java.util.concurrent.CountDownLatch;
        private final org.opensearch.index.engine.dataformat.DataFormat dataFormat;
                assertThat(snapshot.getSegments().size(), equalTo(1));
            for (int i = 0; i < 20; i++) {
            // writer (after the snapshot is frozen) but before the commit reads the checkpoint.
                }
            .eventListener(new Engine.EventListener() {
            assertThat(
            this.engineFailureReasons = engineFailureReasons;
            // Held snapshot should still be valid
                    throw new RuntimeException(e);
            final AtomicBoolean stop = new AtomicBoolean(false);
            int totalDocs = numThreads * docsPerThread;
            try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", fromSeqNo, toSeqNo, false, true)) {
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                    + committedCheckpoint,
            java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>> queue =
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
            indexSettings.updateIndexMetadata(IndexMetadata.builder(indexSettings.getIndexMetadata()).settings(newSettings).build());
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            }
        EngineCreationFailureException ex = expectThrows(EngineCreationFailureException.class, () -> new DataFormatAwareEngine(config));
            for (int i = 0; i < 5; i++) {
            final AtomicReference<Exception> failure = new AtomicReference<>();
        org.apache.lucene.index.CorruptIndexException corruption = new org.apache.lucene.index.CorruptIndexException(
        return buildDFAEngineConfig(store, translogPath, List.of(), List.of());
        }
import org.opensearch.common.util.BigArrays;
            Engine.IndexResult first = null;
     * called from inside {@code flush()}, before {@code flush()} reads the checkpoint). We then
        public boolean isSchemaMutable() {
            CyclicBarrier barrier = new CyclicBarrier(numSyncThreads);
            }
    public void testFrozenEngineBlocksForceMerge() throws IOException {
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
            // --- Path 2: version conflict for reads ---
            Settings.builder()
            // writeIndexingBuffer should work after concurrent indexing
                final int threadId = t;
            .mapperService(mapperService)
                    assertThat("each worker must have indexed every op", perWorker.size(), equalTo(opsPerWorker));
        AtomicInteger externalCalls = new AtomicInteger(0);
                            Engine.IndexResult result = engine.index(indexOp(doc));
            int totalDocs = numThreads * docsPerThread;
                }
            expectThrows(AssertionError.class, deletionPolicy::assertNoOpenTranslogRefs);
                engine.refresh("concurrent batched publication fence");
            org.opensearch.index.engine.dataformat.WriterConfig config
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            assertThat(result.getFailure(), instanceOf(IOException.class));
            assertTrue("store should be marked corrupted", store.isMarkedCorrupted());
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
                        failures.incrementAndGet();
            engine.refresh("pure-delete-refresh");
    }
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
    }
            List.of(new MockSearchBackEndPlugin(List.of(mockDataFormat.name())))
     */
                synchronized (callOrder) {
                assertThat(reader.catalogSnapshot().getGeneration(), equalTo(2L));
    public void testGetByIdThrowsWhenNoProvider() throws IOException {
        bootstrapStoreWithMetadata(store, uuid);
import org.opensearch.test.OpenSearchTestCase;
                t.join();
            // Index same doc again — resolveDocVersion finds expired DeleteVersionValue, nullifies it,
            );
    /**
            int numThreads = 4;
        Path translogPath,
            // Refresh — makes data searchable, listener must be notified
            for (int t = 0; t < numThreads; t++) {
        public WriterState state() {
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> deleteEngine);
     * When a retiring writer's drain reports that buffered deletes were applied, the engine must
     */
            int numDocs = randomIntBetween(3, 10);
    }
            // Inject IOException on refresh
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
    /** The default provider must be accepted, so the check above cannot reject every index. */
            Object maps = mapsField.get(versionMap);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        DocumentMapper documentMapper = mock(DocumentMapper.class);
    private DrainFailureOutcome driveRefreshDrainOfFailedBatchAppend(
                    }
            }
            final List<List<Engine.IndexResult>> perWorkerResults = new ArrayList<>();
    /** The routing-carrying {@code prepareDelete} overload builds an Engine.Delete with the routing value. */
            int numThreads = randomIntBetween(2, 4);
            currentField.setAccessible(true);
            // No writer leaked in the shared flushQueue. Use reflection (test-only) to
        };
            engine.refresh("setup");
                    DataFormatAwareEngine eng = engineRef.get();
        assertFalse("store should not be corrupted for null failure", store.isMarkedCorrupted());
            expectThrows(VersionConflictEngineException.class, () -> engine.getById(stale, (source, scope) -> null));
    // --- Test: failEngine does NOT mark store corrupted for non-corruption exceptions ---
            DocumentLookupResult noConflictResult = getByIdLookup(engine, getNoConflict);
    public void testRestoreVersionMapAndCheckpointTracker() throws IOException {
     * and with the bulk-path batch failure handling means the engine must NOT be failed: the owning bulk fails at
        try (DataFormatAwareEngine eng = createDFAEngine(store, translogPath)) {
        bootstrapStoreWithMetadata(store, uuid);
        return buildDFAEngineConfig(store, translogPath, externalListeners, internalListeners, IndexModule.TieringState.HOT.name());
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            IndexReaderProvider.Reader reader = readerRef.get();
        }
    @Override
        });
        return queue.size();
        AtomicReference<DataFormatAwareEngine> engineRef = new AtomicReference<>();
    }
            long genBefore;
            } catch (AlreadyClosedException e) {
            // Refresh with no data — no new segments produced
        expectThrows(AlreadyClosedException.class, engine::acquireReader);
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
        }
            Engine.Index recoveryOp = new Engine.Index(
            assertThat("afterRefresh must fire when new segments are produced", afterCount.get(), equalTo(1));
        final Engine.EventListener listener = new Engine.EventListener() {
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
                    failures.incrementAndGet();
            // Re-index same doc — resolveDocVersion misses versionMap (cleared by refresh rotation),
            assertTrue("listener fires immediately when idle engine is already drained", listenerFired.get());
    }
                vv = engine.resolveDocVersion(op, true);
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(mockDataFormat.name());
                );
    }
        } finally {
                    }
    public void testFlushTrimsTranslog() throws IOException {
        }
            );
                            engine.freezeForTiering();
            return engine;
        // Verify commit data was persisted
            // in the backing store, which the InMemoryCommitter in tests does not do.
            }
                    afterDidRefreshTrue.incrementAndGet();
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            assertTrue(
        try {
            // Engine must remain open on primary even after rejections
    public void testBatchedAppendCrossThreadRealtimeGetForcesFlush() throws Exception {
            // Realtime get with readFromTranslog finds it in translog via versionMap location
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            List<String> engineFailureReasons,
                try {
            }
        Directory dir = newDirectory();
        public Committer.CommitResult commit(Committer.CommitInput commitInput) throws IOException {
                        notifySettingsChanged(engine);
            assertThat("refresh should have been triggered by unsafe versionMap", genAfter, greaterThan(genBefore));
        if (appendOnly != null) {
                threads[t].start();
            }
        bootstrapStoreWithMetadata(store, uuid);
        }
        public org.opensearch.index.engine.dataformat.FileInfos flush(org.opensearch.index.engine.dataformat.FlushInput flushInput) {
        return out;
        Path translogPath = createTempDir();
    public void testResolveDocVersionFallsBackToProvider() throws IOException {
        );
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(mockDataFormat.name());
            // Verify: catalogSnapshot docs + pendingRowCount must equal successCount
        java.lang.reflect.Field field = DataFormatAwareEngine.class.getDeclaredField("deleteExecutionEngine");
        work.push(t);
                t.join();
                        failures.incrementAndGet();
     * <ul>
                CatalogSnapshot snapshot = ref.get();
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            base.docs(),
                versionMap.putIndexUnderLock(uid, new IndexVersionValue(bogusLocation, 6L, 3L, 1L));
     */
     */
            null,
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            // Insert: there is no previous copy to supersede.
        boolean remoteStore,
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        FailureInjectingCommitter(Store store) throws IOException {
            int count = engine.countNumberOfHistoryOperations("test", 0, numDocs - 1);
    ) {
            assertThat(
                } catch (Throwable t) {
                    } catch (Exception e) {
            assertTrue("versionMap should be unsafe", versionMap.isUnsafe());
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    }
            .documentLookupProvider(documentLookupProvider)
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            // Covers the negative path: if (operation != null) is false, falls through to refreshIfNeeded
            assertThat("the sibling op in the same chunk must also be published", secondPending.getTranslogLocation(), notNullValue());
        Path translogPath = createTempDir();
    public void testIndexVersionConflictFromVersionMap() throws IOException {
            assertThat("no thread should have thrown", threadErrors.get(), equalTo(0));
                        result.getFailure().getMessage(),
            ifSeqNo,
            }
                .build()
            }
    }
        }
            assertFalse(
            expectThrows(UnsupportedOperationException.class, () -> getByIdLookup(engine, get));
            // Configure refresh to throw AlreadyClosedException, with a tragic exception
            assertThat("the op must be deferred into the open batch", deferred.getTranslogLocation(), nullValue());
    private DataFormatAwareEngine createBatchDFAEngine(
        }
                            engine.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));
    }
                        genSeenInBefore.set(ref.get().getGeneration());
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("5", null))));
            assertFalse("idle engine has no pending merges", engine.hasPendingMerges());
    }
            engine.translogManager().syncTranslog();
     * randomized timing.
            // Trigger the failure — refresh will flush writers, find new segments, call
            // Drain the listener counters from the two seed refreshes.
            .internalRefreshListener(List.of())
            }
    public void testFlushMustNotCommitCheckpointAheadOfPersistedSnapshot() throws Exception {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                assertThat("inline op must carry its location immediately", result.getTranslogLocation(), notNullValue());
import org.opensearch.index.store.FsDirectoryFactory;
                -1,
        return buildDFAEngineConfig(store, translogPath, externalListeners, internalListeners, tieringState, null);
        }
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
                            assertThat("op must be deferred while its batch is open", result.getTranslogLocation(), nullValue());
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        ReferenceManager.RefreshListener internal = new ReferenceManager.RefreshListener() {
                        error.compareAndSet(null, e);
                    }
    public void testRejectsNonDefaultPrimaryOperationPolicy() throws IOException {
            shardPath,
    public void testConcurrentFreezeForTiering_EndsFrozen() throws Exception {
        }
                assertThat(ref.get().getGeneration(), equalTo(2L));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            assertThat(e.getMessage(), containsString("frozen for tiering"));
            SequenceNumbers.UNASSIGNED_SEQ_NO,
                try {
    }
        MockDataFormatPlugin limitedPlugin = MockDataFormatPlugin.of(mockDataFormat).withIndexingEngine(settings -> limitedEngine);
     * generation in the deletion policy for as long as it is held, and releases that generation when closed.
            // Index 1 doc, then create a gap via a recovery op at seqNo=5.
    private EngineConfig buildBatchDFAEngineConfig(
                assertThat(ref.get().getSegments().size(), equalTo(1));
        } finally {
     *   <li>Call {@link DataFormatAwareEngine#failEngine} with the originating cause.</li>
            FlushFailedEngineException ex = expectThrows(FlushFailedEngineException.class, () -> engine.flush(false, true));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    }
    public void testFlushCommitDataContainsCatalogSnapshotKeys() throws IOException {
                }
                    throw new RuntimeException(e);
            1L,
        final StringBuilder sb = new StringBuilder();
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("post-fail", null))));
            Engine.Index op = indexOp(createParsedDocWithInput("1", null));
    public void testMergeCountWrappers_IdleEngine_ReportZeroAndAlreadyDrained() throws IOException {
     *   <li>the batch owner sees the same failure at {@code finish()} and the engine is closed afterwards.</li>
            .indexSettings(indexSettings)
            // Configure committer to throw CorruptIndexException on commit
        engine.failEngine("non-corruption test", new RuntimeException("simulated"));
    public void testBatchedAppendRequiresRemoteStore() throws IOException {
     * The stale entry (seqNo=2) is overwritten by OP_NEWER, the duplicate (same seqNo=5) is skipped.
                        barrier.await();
            }
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(1L));
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            assertThat(failure.getMessage(), containsString("simulated delete failure"));
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
        @Override
     * {@code translogFactory} and {@code eventListener} default to the stock factory and a silent listener when null.
                    } catch (Exception e) {
            // Clear failure and flush again — should succeed
                IllegalStateException.class,
    public void testVersionMapAfterAutoIDDocument() throws Exception {
            AlreadyClosedException indexEx = expectThrows(
                closed = false;
        }
     * recovered engine with no indexing or merges, the scheduler reports zero active merges and
     */
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true, false)) {
     * Bootstraps the store's Lucene index with the commit metadata that DFAE
            // Disable failure
            // Engine should be failed
            }
     * A writer that accepts documents but always throws an {@link IOException} when its
            MockDeleteExecutionEngine deleteEngine = getMockDeleteEngine(engine);
            Thread refreshThread = new Thread(() -> {
                        indexedLatch.countDown();
            }
    public void testAcceptsDefaultPrimaryOperationPolicy() throws IOException {
            assertThat("flushQueue must be empty after close", flushQueueSize(engine), equalTo(0));
        return sb.toString();
    }
            MockDeleteExecutionEngine deleteEngine = getMockDeleteEngine(engine);
        @Override
        try {
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
            Settings.builder()
    private DataFormatAwareEngine createUpdateEnabledDFAEngine(Store store, Path translogPath) throws IOException {
            try {
            }
            engine.flush(false, true);
                assertThat(wfs.files().size(), equalTo(1));
                    }
     */
    /**
                MockDataFormat unknownFormat = new MockDataFormat("unknown", 999L, mockDataFormat.supportedFields());
        // Store should NOT be marked corrupted (null failure)
            .committerFactory(committerFactory)
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            assertTrue("delete of an existing doc must report found", result.isFound());
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
        }
                int i = 0;
            int refreshesBefore = indexingEngine.getRefreshCallCount();
                    String fileName = wfs.files().iterator().next();
            Closeable retentionLock = engine.acquireHistoryRetentionLock();
            // Wait for threads to finish
            for (int i = 0; i < 10; i++) {
                flushGate.countDown();
            assertSame(DefaultPrimaryOperationPolicy.INSTANCE, config.getPrimaryOperationPolicy());
        }
            final RuntimeException ownerFailure = expectThrows(RuntimeException.class, batch::finish);
        try {
        FailureInjectingCommitter failingCommitter = fer.committer();
                    try {
            engine.flush(true, true);
                equalTo((long) totalOps - 1)
            // Refresh so the get cannot be answered from the version map.
    }
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            assertThat("afterRefresh(true) should NOT fire", afterDidRefreshTrue.get(), equalTo(0));
            engine.refresh("test");
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            assertThat(updated.seqNo(), equalTo(second.getSeqNo()));
        String indent = "";
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    public void testSuccessfulUpdateSupersedesPreviousCopy() throws Exception {
            return state;
            @Override
import org.opensearch.index.mapper.IdFieldMapper;
    }
            // still false). The live-settings fallback must still block the operation.
            .externalRefreshListener(List.of())
                                IndexReaderProvider.Reader reader = ref.get();
            engine.refresh("seed-2");
    }
    }
        }
            for (int i = 0; i < numDocs; i++) {
            Engine.IndexResult indexed = engine.index(indexOp(createParsedDocWithInput("1", null)));
            assertThat(engine.config().getShardId(), equalTo(shardId));
                    error.compareAndSet(null, e);
        DocumentLookupProvider provider = mockLookupProvider();
    public void testWriteIndexingBufferAfterConcurrentIndexing() throws Exception {
    }
                        break;
import org.opensearch.index.engine.exec.commit.Committer;
            .build();
            engine.freezeForTiering();
                assertThat(snapshot.getSegments().get(0).dfGroupedSearchableFiles().containsKey(mockDataFormat.name()), equalTo(true));
     * <p>The system-property gate on {@code MERGE_ENABLED_PROPERTY} applies only to
            assertTrue("a matching precondition must be served", getByIdLookup(engine, current).exists());
                        barrier.await();
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    public void testSegmentsReturnsEngineSegments() throws IOException {
                engine.getProcessedLocalCheckpoint(),
                indexThreads[t].start();
            // Index 20 docs, refresh, flush (commit point)
        return buildBatchDFAEngineConfig(store, translogPath, provider, enabled, remoteStore, appendOnly, null, null);
            int iterations = 100;
    /**
        }
                while (snapshot.next() != null)
        while (work.isEmpty() == false) {
            assertThat("new doc after recovery should succeed", newResult.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            @Override
     * Batch on: N index ops executed inside a batch defer their translog append. Before flush, no result has a
            notifySettingsChanged(engine);
            queueField.setAccessible(true);
/**
                    for (int i = 0; i < numFlushes; i++) {
            // executeDeletePlan must record a delete tombstone in the live version map.
                assertThat(ref.get().getGeneration(), greaterThan(0L));
                    barrier.await();
                }
                .build()
        MockDataFormatPlugin noDeletePlugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> null);
            current = current.getCause() == current ? null : current.getCause();
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) numDocs - 1));
            engine.flush(false, true);
            MockDeleteExecutionEngine deleteEngine = getMockDeleteEngine(engine);
            }
                    readerRef.get().catalogSnapshot().getGeneration(),
            setTieringStateSetting(engine, IndexModule.TieringState.HOT_TO_WARM);
        }
    }
            Engine.DeleteResult replay = engine.delete(deleteOpFromTranslog("1", 0L));
    }
        DocumentMapper documentMapper = mock(DocumentMapper.class);
     */
            }
            try (org.opensearch.common.lease.Releasable ignored = versionMapOf(engine).acquireLock(op.uid().bytes())) {
            return true;
import org.opensearch.cluster.metadata.IndexMetadata;
            java.lang.reflect.Field mapsField = LiveVersionMap.class.getDeclaredField("maps");
            engine.writeIndexingBuffer();
     */
            Thread[] threads = new Thread[numThreads];
        };
    }
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            return new org.opensearch.index.engine.dataformat.WriteResult.Success(1L, 1L, 0L);
    }
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            assertTrue(
     *   <li>the engine is failed exactly once, and the recorded failure is the translog's tragic exception itself, as
    private EngineConfig buildDFAEngineConfigWithCommitterFactory(Store store, Path translogPath, CommitterFactory committerFactory) {
import java.util.UUID;
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            }
        }
    }
            // Verify the cause chain contains the original corruption exception
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
            }
        @Override
     * Covers the preIndex cooperative-flush path when a writer's {@code flush()} throws.
            if (input.writerFiles().isEmpty() == false || input.existingSegments().isEmpty()) {
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {
            // Inject a writer that returns empty FileInfos on flush (success path, no files).
    public void testBatchedAppendDefersThenFlushes() throws IOException {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            // Index should succeed — preIndex is disabled so the failing writer is never polled.
                            engine.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            .translogConfig(translogConfig)
                    Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
            engine.close();
        }
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
    public void testConcurrentFailEngineFromMultipleSourcesIsIdempotent() throws Exception {
    /** And a get carrying no precondition at all must be unaffected by the enforcement. */
            assertThat(indexed.getTranslogLocation().compareTo(deleted.getTranslogLocation()), lessThan(0));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        expectThrows(AlreadyClosedException.class, () -> engine.segments(false));
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
    public void testFailEngineWithNullFailure() throws IOException {
        }
            engine.index(indexOp(createParsedDocWithInput("1", null)));
import static org.mockito.ArgumentMatchers.anyLong;
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                synchronized (callOrder) {
            @Override
            assertEquals(2L, engine.getProcessedLocalCheckpoint());
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            assertThat(persisted, org.hamcrest.Matchers.lessThanOrEqualTo(processed));
                }
            // Thread 2: continuous refresh
                Translog.Operation op2 = snapshot.next();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            DocumentLookupResult result = getByIdLookup(engine, get);
        }
            outcome.refreshFailure,
    public void testPersistedCheckpointCatchesUpAfterSync() throws IOException {
            .translogConfig(translogConfig)
                threads[t].start();
        }
            assertTrue(segments.get(0).search);
        throws IOException {
    }
        when(documentMapper.getVersion()).thenReturn(1L);
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        );
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
            }
                assertThat(snapshot.getGeneration(), greaterThanOrEqualTo(0L));
import org.opensearch.index.translog.Translog;
            // Phase 4 -- replayability: every acknowledged op is in the translog, contiguous and de-duplicated.
        assertFalse("engine must stay open after a non-tragic append failure", outcome.engineClosedAfterwards);
            .indexSettings(indexSettings)
     * Use case: Both external listeners (registered by IndexShard for search-after-refresh)
        engine.close();
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
                assertThat(ref.get().getSegments().size(), greaterThan(0));
            .withDeleteExecutionEngine(committer -> deleteEngine);
        }
import static org.mockito.ArgumentMatchers.any;
            AtomicInteger failures = new AtomicInteger(0);
    public void testRefreshFailureAfterIndexingFailsEngine() throws Exception {
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            assertThat(stats.getVersionMapMemoryInBytes(), equalTo(1024L));
                assertThat(result.getTranslogLocation(), notNullValue());
            }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            }
        try {
            armedFailure.set(null);
        }
        }
            engine.refresh("write indexing buffer");
     * snapshot is committed (so listeners can prepare), and afterRefresh is called
            assertThat(engine.countNumberOfHistoryOperations("test", 0, Long.MAX_VALUE), equalTo(numDocs));
    public void testFillSeqNoGapsClosesGapAndWritesTranslogNoOps() throws IOException {
                        for (int n = 0; n < iterations; n++) {
            .translogConfig(translogConfig)
            return delegate.isCommitManagedFile(fileName);
    }
                Translog.Operation op;
            }
            );
    public void testFlushCommitsCatalogSnapshot() throws IOException {
            }
            indexSettings,
            assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
            assertFalse("Refresh thread should have stopped", refreshThread.isAlive());
            }
                Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
            // With no ops, should not need periodic flush
                    lookup.set(getByIdLookup(engine, realtimeGet("1")));
            refresher.join(TimeValue.timeValueSeconds(30).millis());
            for (Throwable s : current.getSuppressed()) {
                genBeforeFinalRefresh = ref.get().getGeneration();
            assertThat("first op must have an assigned seqNo", first.getSeqNo(), equalTo(0L));
            IllegalStateException e = expectThrows(
                .setIfPrimaryTerm(1L);
import org.opensearch.index.engine.exec.WriterFileSet;
                    } catch (Throwable e) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    public void testFlushNonCorruptionExceptionWrapsInFlushFailedEngineException() throws IOException {
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            engine.index(
            Engine.IndexResult first = engine.index(indexOp(createParsedDocWithInput("upd", null)));
        );
        }
        }
            List.of(
        // Second failEngine should not throw
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
import org.opensearch.index.VersionType;
            Translog.Location expectedMax = null;
    /**
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("2", null))));
            shardId,
                if (eng != null) {
            assertThat(result.getSeqNo(), greaterThanOrEqualTo(0L));
        final List<Exception> engineFailures = new CopyOnWriteArrayList<>();
        indexingEngine.setRefreshResultTransformer((input, result) -> {
    /** Calls the new getById(Engine.Get, searcherFactory) and unwraps the pre-materialized lookup.
                        failures.incrementAndGet();
        }
            return writerGeneration;
     * B: optimistic-concurrency conflict on the write path. After indexing id "1" (seqNo 0), an index
        int numDocs = randomIntBetween(3, 10);
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                threads[t].start();
            AtomicReference<Exception> failureCause = new AtomicReference<>();
            int freezers = 4;
                assertThat(snapshot.getGeneration(), equalTo((long) numBatches + 1));
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
        );
    }
        @Override
            assertThat(stale.getResultType(), equalTo(Engine.Result.Type.FAILURE));
    /**
            assertThat("the requested op must now be published", first.getTranslogLocation(), notNullValue());
    /**
            @SuppressWarnings("unchecked")
            indexSettings,
            "the refresh failure must be rooted in the tragic exception, chain was " + describeExceptionChain(outcome.refreshFailure),
            flushQueueOf(engine).add(new FailingFlushWriter(43L, mockDataFormat));
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("post-fail", null))));
    public void testSegmentsStatsReturnsValidStats() throws IOException {
    }
                    .sum();
            assertThat("replayed delete keeps its assigned seqNo", result.getSeqNo(), equalTo(seqNo));
            for (int i = 0; i < numDocs; i++) {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
     * remember it so the next refresh reopens readers even without a new segment.
            }
            // Initial snapshot generation is 1 (bumpGeneration in constructor)
            final Throwable current = work.pop();
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat)
        InMemoryCommitter committer = new InMemoryCommitter(store);
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
            // Engine should still be open (non-corruption doesn't fail the engine)
        }
        }
            assertSame("flush ACE cause should be the original failure", originalCause, flushEx.getCause());
    }
        }
     * Returns the first MockWriter currently in the engine's writer pool via reflection.
package org.opensearch.index.engine;
        }
            assertFalse("an unsupported delete must not fail the engine", engineFailed.get());
                assertThat(reader.catalogSnapshot(), notNullValue());
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                expectedSeqNos.add(s);
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
    }
            try (Translog.Snapshot snapshot = ((InternalTranslogManager) engine.translogManager()).getTranslog().newSnapshot()) {
}
        );
        when(mapperService.documentMapper()).thenReturn(documentMapper);
        AtomicReference<Exception> failedEngineCause = new AtomicReference<>();
        deleteEngine.setDeletesAppliedOnCheckout(true);
            // Each listener gets beforeRefresh + afterRefresh = 2 calls
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(1L));
    ) {
    public void testPreIndexSuccessfulFlushProducesPendingSegment() throws Exception {
        } finally {
        }
            this.engineClosedAfterwards = engineClosedAfterwards;
                DataFormatAwareEngine eng = engineRef.get();
            .translogConfig(translogConfig)
    public void testAcquireReaderReturnsNullForUnregisteredFormat() throws IOException {
        );
        private final org.opensearch.index.engine.dataformat.DataFormat dataFormat;
            // Close the engine — closeNoLock must drain flushQueue and close the writer.
        return new Engine.Index(
    public void testPartialCycleFlushFailureIncorporatesNothing() throws Exception {
            .withIndexingEngine(settings -> indexingEngine)
            delegate.markStoreCorrupted(cause);
     * (no safe-access enforcement).
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
    }
                    try {
            java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");
            }
    public void testCountNumberOfHistoryOperationsRespectsSeqNoRange() throws IOException {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            assertThat(maxSeqNo.get(), equalTo((long) totalDocs - 1));
                (java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>>) queueField.get(engine);
            return org.opensearch.index.engine.dataformat.FileInfos.empty();
    }
    public void testForceFlushRequiresWaitIfOngoing() throws IOException {
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name())
            int docsPerThread = randomIntBetween(10, 20);
        } finally {
            fmThread.join(30_000);
    /** Happy-path primary delete of an existing doc: SUCCESS, assigned seqNo, translog location, and a version-map tombstone. */
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
                        for (int d = 0; d < docsPerThread; d++) {
            assertTrue("the pending doc must be found via the forced append", lookup.get().exists());
            for (int i = 0; i < numDocs; i++) {
    public void testRetireWriterDeleteDrainFailureFailsEngine() throws Exception {
    /** Primary delete op for {@code id} with default INTERNAL/MATCH_ANY semantics (mirrors {@link #indexOp}). */
    public void testRefreshProducesCatalogSnapshot() throws IOException {
            assertNull("a from-translog delete must not be re-appended to the translog", replay.getTranslogLocation());
        }
                        throw new RuntimeException(e);
            int numDocs = randomIntBetween(5, 15);
        Boolean appendOnly
            Engine.IndexResult failedUpdate = engine.index(indexOp(createParsedDoc("1", null)));
            terminate(threadPool);
    }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                rootCause(suppressed),
        bootstrapStoreWithMetadata(store, uuid);
            .tombstoneDocSupplier(tombstoneDocSupplier())
            long committedCheckpoint = Long.parseLong(committer.getLastCommittedData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
     * a refresh from an unrelated caller drains that batch from inside its critical section (writers checked out and
    /** Builds a DFA engine config with the batched-translog-append toggle and remote-store eligibility. */
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        return new EngineConfig.Builder().shardId(shardId)
    }
            shardId,
            }
    private DataFormatAwareEngine createDFAEngine(Store store, Path translogPath) throws IOException {
    private static boolean unpublishedDeletesOf(DataFormatAwareEngine engine) throws Exception {
            assertFalse("versionMap should be safe after refresh", versionMap.isUnsafe());
        AtomicInteger beforeCount = new AtomicInteger(0);
            for (int i = 0; i < numDocs; i++) {
                    } catch (Exception e) {
            .threadPool(threadPool)
            long latestGen;
            engine.refresh("empty");
        @Override
            int deletesAfterFirstReplay = deleteEngine.deletedIds().size();
     *   <li><b>Pending phase:</b> once all workers have indexed (indexedLatch), every result is unpublished
            assertThat("the operation cap must append the first chunk", first.getTranslogLocation(), notNullValue());
            );
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            "",
                        engine.failEngine("reason-" + id, new RuntimeException("exception-" + id));
        bootstrapStoreWithMetadata(store, uuid);
                            failure.compareAndSet(null, e);
        @Override
                        barrier.await();
    public void testGetByIdFromSegmentsEnforcesStaleVersion() throws IOException {
    public void testShouldPeriodicallyFlush() throws IOException {
            assertThat(first.getTranslogLocation(), notNullValue());
                    .getSegments()
            try {
            int numDocs = randomIntBetween(5, 20);
            engine.ensureOpen();
        engine.failEngine("first failure", new RuntimeException("first"));
    /** Primary delete op carrying compare-and-set ifSeqNo/ifPrimaryTerm (for version-conflict tests). */
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
        Path translogPath = createTempDir();
            vmField.setAccessible(true);
                assertTrue(TransportActions.isShardNotAvailableException(e));
                t.join();
        DataFormatAwareEngine engine = fer.engine();
        }
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) numDocs - 1));
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
        ) {
        return new Engine.Delete(
                7L,
    public void testFlushCorruptionExceptionFailsEngineViaMaybeFailEngine() throws IOException {
            assertThat(count, equalTo(numDocs));
            );
        Path translogPath = createTempDir();
            return new WriteResult.Failure(new IOException("simulated addDoc failure"), -1L, -1L, -1L);
                assertThat(result.getSeqNo(), equalTo((long) i));
            int numThreads = randomIntBetween(3, 6);
            mockExecEngine.setRefreshFailure(() -> new AlreadyClosedException("engine closed"));
            );
                DataFormatAwareEngine eng = engineRef.get();
     * writers frozen at {@code checkoutAll} — and then commits
                threads[t] = new Thread(() -> {
            }
                        failures.incrementAndGet();
        Path translogPath = createTempDir();
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(0L));
        return createBatchDFAEngine(store, translogPath, provider, enabled, remoteStore, null);
                    assertNotNull(result.getFailure());
                        }
            assertThat(failures.get(), equalTo(0));
     * {@code flush()} is invoked. Used to drive the flush-failure paths in
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    }
     * a writer whose {@code flush()} throws on first call, ensuring the refresh
            int firstFill = engine.fillSeqNoGaps(primaryTerm.get());
    }
            // Then do concurrent refresh + flush
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        MapperService mapperService = mock(MapperService.class);
            assertThat(
    public void testRefreshDrainOfNonTragicBatchAppendDoesNotFailEngine() throws Exception {
            assertThat(
    /**
                engine.getPersistedLocalCheckpoint(),
            CyclicBarrier barrier = new CyclicBarrier(3);
                    barrier.await();
            }
        );
        MockDeleteExecutionEngine deleteEngine = spy(new MockDeleteExecutionEngine(mockDataFormat));
    public void testFreezeForTieringBlocksPrimaryIndex() throws IOException {
            // Index 10 more (unflushed — in translog only)
                engine.refresh("batch-" + i);
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                        if (stop.get() == false) {
            doc,
                assertThat(count, greaterThan(0));
        } finally {
                        assertThat("each worker must get a real (non-no-op) batch", batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
        EngineConfig config = buildDFAEngineConfigWithCommitterFactory(store, translogPath, c -> committer);
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(engine.getProcessedLocalCheckpoint()));
        engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            int totalDocs = numIndexThreads * docsPerThread;
    public void testGracefulCloseUnderConcurrentLoad() throws Exception {
        }
 */
        }
    }
            }
        return buildBatchDFAEngineConfig(store, translogPath, provider, enabled, remoteStore, null);
            engine.refresh("test pending translog fence");
                assertThat(op1.seqNo(), equalTo(0L));
            // Count only ops in range [3, 7]
        when(mapperService.documentMapper()).thenReturn(documentMapper);
        }
        );
     */
            logger.info(
            // Flush again — should succeed now
            markUnsafe.invoke(current);
            .indexSettings(indexSettings)
     * threads them into {@code Engine.Get}, so the precondition reaches the engine for reads just
     * leaking its LuceneWriter's NativeFSLock in LOCK_HELD.
    }
        }
            // Initial snapshot: generation 1 (bumpGeneration in constructor), no segments
    /**
        when(provider.getById(any(), any(), any(), any())).thenReturn(
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
    }
            java.lang.reflect.Field queueField = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
                        barrier.await();
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
        return new DataFormatAwareEngine(buildDFAEngineConfig(store, translogPath, provider));
            assertFalse(engine.isThrottled());
        Path translogPath = createTempDir();
            IllegalStateException e = expectThrows(
            assertThat(e.getMessage(), containsString("frozen for tiering"));
        public void markStoreCorrupted(IOException cause) {
                    dump.append("    at ").append(frame).append('\n');
            assertTrue("a drain that applied deletes must leave them marked unpublished", unpublishedDeletesOf(engine));
            Engine.DeleteResult result = engine.delete(deleteOp("1"));
            assertThat(failure.getCause().getMessage(), containsString("simulated drain failure"));
        DataFormatAwareEngine engine = createUpdateEnabledDFAEngine(store, createTempDir());
     *
            .externalRefreshListener(List.of())
            int numDocs = randomIntBetween(3, 10);
            // Verify subsequent ops throw AlreadyClosedException
            assertThat(engine.config(), notNullValue());
    }
        ReferenceManager.RefreshListener listener = new ReferenceManager.RefreshListener() {
            for (int t = 0; t < numThreads; t++) {
            for (int i = 0; i < 5; i++) {
            // A forced flush does not close the owning bulk scope: later ops form a fresh pending chunk.
                // expected
            for (Thread t : threads)
            for (int i = 0; i < 3; i++) {
     *   <li>{@link DataFormatAwareEngine#failEngine} must run with the originating cause,
        }
            primaryTerm.get(),
                }
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
        try {
                    assertTrue("replayed op seqNo " + op.seqNo() + " must be unique", replayedSeqNos.add(op.seqNo()));
                threads[t].start();
                }
            engine2.refresh("post-recovery");
            }
    }
            "test",
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
    /**
        indexingEngine.setWriterCustomizer(DataFormatAwareEngineTests::retireOnWrite);
        bootstrapStoreWithMetadata(store, uuid);
                beforeCount.incrementAndGet();
            Throwable refreshFailure,
    public void testCountNumberOfHistoryOperationsSubRange() throws IOException {
    }
     * managers that need to open readers on the new snapshot.
        Boolean appendOnly
        AtomicInteger onFailedCount = new AtomicInteger(0);
                new DocumentLookupResult("c", 1L, true, null, 2L, 1L, Map.of(), Map.of()),
        Engine.EventListener countingListener = new Engine.EventListener() {
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(
        }
    /**
                5L,
            return writerGeneration;
                "unexpected secondary failure from the refresh unwind: " + describeExceptionChain(suppressed),
            Set<Long> dropped = input.existingSegments().stream().map(Segment::generation).collect(Collectors.toSet());
        return createParsedDoc(id, routing);
        }
                });
        void failEngine(String reason, Exception failure) {
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
            notifySettingsChanged(engine);
     * flush fails, the engine must:
        }
            state = WriterState.CLOSED;
            assertThat(
        DocumentLookupProvider provider = mockLookupProvider();
            // Wait for all threads to start
        void setCommitFailure(IOException failure) {
                    failureCause.set(e);
        }
        ReferenceManager.RefreshListener injector = new ReferenceManager.RefreshListener() {
        Path translogPath = createTempDir();
            buildDFAEngineConfig(store, translogPath, List.of(), List.of(), IndexModule.TieringState.HOT.name(), null, false)
    }
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
     * {@link DataFormatAwareEngine#refresh} and {@code preIndex}.
    }
    /**
import java.util.concurrent.TimeUnit;
        indexingEngine.setWriterCustomizer(writer -> {
            try (Translog.Snapshot snapshot = engine.newChangesSnapshot("replay", 0, totalOps - 1, false, true)) {
            } catch (Exception ignored) {}
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            }
        try {
            queue.add(orphanWriter);
        FailureInjectingCommitter committer = fer.committer();
            // Trigger failure via refresh
            assertTrue("workers must finish indexing within the bound", indexedLatch.await(30, TimeUnit.SECONDS));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            engine.index(recoveryOp);
            LiveVersionMap versionMap = (LiveVersionMap) vmField.get(engine);
        AtomicReference<Exception> failedEngineCause = new AtomicReference<>();
            );
import java.util.ArrayList;
            assertEquals(0L, engine.getProcessedLocalCheckpoint());
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
    ) {
            engine.shouldPeriodicallyFlush();
                threads[t] = new Thread(() -> {
        @Override
import org.apache.lucene.index.Term;
                        for (int i = 0; i < 5; i++) {
                });
            false
        bootstrapStoreWithMetadata(store, uuid);
     *   <li><b>Replayability:</b> every acknowledged op is present in the translog changes snapshot for [0, totalOps-1],
     */
     * <p>When a write thread picks a writer from the flushQueue during preIndex and the
                assertThat(snapshot.getSegments().size(), equalTo(1));
            public void onFailedEngine(String reason, Exception failure) {
     * Setting off: {@link Engine#beginTranslogBatch()} returns the no-op batch and every op is appended inline exactly
     *
    }
                Engine.Operation.Origin.PRIMARY,
     * refresh listener that fires on real refreshes is NOT invoked by the merge, and
            int docsPerThread = randomIntBetween(10, 20);
                assertThat(snapshot.getId(), equalTo(1L));
import java.util.concurrent.atomic.AtomicLong;
                engine.flush(false, true);
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            shardId,
            Versions.MATCH_ANY,
    public void testCurrentOngoingRefreshCheckpoint() throws IOException {
            settings.put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            id,
                t.join();
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
     * Drives the scenario gbbafna raised on the composite refresh: a bulk thread leaves one deferred op in an open batch;
            );
        } finally {
     * Reproduces the composite checkpoint-inflation data-loss bug (the one behind the
            Exception failedEngine = failable.getFailedEngine();
        public java.util.List<org.opensearch.index.engine.exec.coord.CatalogSnapshot> listCommittedSnapshots() {
            long cleanups = engine.unreferencedFileCleanUpsPerformed();
            int numDocs = randomIntBetween(5, 15);
                thrown == null ? "nothing\n" : describeExceptionChain(thrown),
                while ((op = snapshot.next()) != null) {
            mockExecEngine.setRefreshFailure(() -> new IOException("injected refresh failure"));
            // Index 10 docs
    public void testGetByIdFromSegmentsEnforcesStaleIfSeqNo() throws IOException {
            assertTrue(versionMap.getAllCurrent().isEmpty());
                        failures.incrementAndGet();
            synchronized (callOrder) {
            assertThat(engine.currentOngoingRefreshCheckpoint(), greaterThanOrEqualTo(0L));
            assertThat(second.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
     * Retires the writer from inside {@code addDoc} and rejects the write, so the failure path enters
            // Index more docs so next refresh has unflushed segments
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
            for (int t = 0; t < numThreads; t++) {
            BigArrays.NON_RECYCLING_INSTANCE,
 * sequence number management, translog integration, refresh/flush lifecycle,
                        engine.refresh("background-" + i);
                    0
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            assertThat("afterRefresh(false) when no new segments", afterDidRefreshFalse.get(), equalTo(1));
            expectThrows(AlreadyClosedException.class, engine::ensureOpen);
            writer.setLiveCommitData(commitData.entrySet());
            }
            // Engine should still be open (flush succeeded).
                assertThat(op2.seqNo(), equalTo(1L));
        @Override
            // Engine should be failed
            engine.deactivateThrottling();
                "[{}] refresh threw: {}engine failures: {}",
            // After indexing, shouldPeriodicallyFlush may or may not be true
    @SuppressForbidden(reason = "test needs reflective access to inject a writer into flushQueue")
            try {
            public void afterRefresh(boolean didRefresh) {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
     */
            System.nanoTime(),
            .indexSettings(indexSettings)
            assertSame("refresh ACE cause should be the original failure", originalCause, refreshEx.getCause());
        } finally {
import org.opensearch.index.mapper.Uid;
            .mergePolicy(NoMergePolicy.INSTANCE)
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(5L));
                int count = 0;
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            for (int i = 0; i < numRefreshes; i++) {
                engine.close();
            indexSettings,
                assertThat("processed advances per op inline", engine.getProcessedLocalCheckpoint(), equalTo((long) i));
        // Build engine with a counting event listener to verify onFailedEngine called exactly once
     * Use case: A search-after-refresh waiter registers a listener to know when
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
    public void testPersistedCheckpointAfterConcurrentIndexAndSync() throws Exception {
            // Refresh to make docs visible
            translogPath,
            int numThreads = randomIntBetween(2, 4);
            setTieringStateSetting(engine, IndexModule.TieringState.HOT_TO_WARM);
        final Path translogPath = createTempDir();
            boolean foundCorruptionMarker = false;
            // Let them run briefly
     * advances the processed checkpoint to N-1, returns the batch max location, and does NOT mark anything persisted
     */
            }
            public void afterRefresh(boolean didRefresh) {
                new FailableDataFormatAwareEngine(engine).getFailedEngine()
            assertTrue("root cause should be OOM", ex.getCause().getCause() instanceof OutOfMemoryError);
        Store store,
import static org.hamcrest.Matchers.empty;
            if (failures.get() > 0) {
        }
                while (stop.get() == false) {
    }
        DataFormatAwareEngine engine = fer.engine();
            .dataFormatRegistry(registry)
            engine.close();
     * {@code null} versionType and unset ifSeqNo/ifPrimaryTerm (see the {@link Engine.Delete} constructor asserts).
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(totalDocs));
            for (int t = 0; t < numThreads; t++) {
        Throwable current = t;
    }
            }
                    .stream()
     * {@code DocumentMapperForType.parse}.
    }
            new Term(IdFieldMapper.NAME, Uid.encodeId(id)),
import org.opensearch.core.index.shard.ShardId;
            "test corruption",
                engine.close();
                indexThreads[t] = new Thread(() -> {
            public void beforeRefresh() {
                .deleteDocument(any(DeleteInput.class), any());
    public void testDeleteFromTranslogMarksSeqNoAndSkipsTranslog() throws IOException {
            equalTo(1)
            assertThat(indexed.getTranslogLocation(), nullValue());
            }
            flusher.start();
    }
            engine.index(indexOp(createParsedDoc("1", null)));
            this.refreshFailure = refreshFailure;
            throw new IOException("simulated flush failure for writer gen=" + writerGeneration + " format=" + dataFormat.name());
                final int threadId = t;
            engine.index(indexOp(createParsedDocWithInput("2", null)));
                    engine.forceMerge(false, 1, false, false, false, "test-force-merge");
        boolean remoteStore,
            // A writer that succeeds on flush with empty result (no files produced).
            .mapperService(mapperService)
                System.nanoTime(),
            // The InMemoryCommitter stores the commit data. Access it via the engine's
     * acknowledged docs are silently lost.
                } catch (Exception e) {
                });
            }
                CatalogSnapshot snapshot = ref.get();
            long readerGen = reader.catalogSnapshot().getGeneration();
                Translog.Operation op;
    /**
        Path translogPath = createTempDir();
    }
        when(provider.getById(any(), any(), any(), any())).thenReturn(DocumentLookupResult.notFound(""));
            .threadPool(threadPool)
            IndexWriter writer = new IndexWriter(
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                threads[t] = new Thread(() -> {
            engine.flush(false, true);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            engine.close();
        boolean enabled,
     *   <li><b>Concurrent refresh:</b> a refresh fences ALL live scopes ({@code flushActiveTranslogBatches}), so after
    }
                equalTo(0)
            for (int i = 20; i < 30; i++) {
                new DocumentLookupResult("b", 1L, true, null, 1L, 1L, Map.of(), Map.of()),
            base.source(),
     */
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
    }
     *       (null location) and the processed checkpoint must not have advanced -- catching any premature publish.</li>
import org.opensearch.index.translog.InternalTranslogManager;
            .committerFactory(c -> new InMemoryCommitter(store))
                    } catch (FlushFailedEngineException e) {
            engine.close();
            assertFalse("deleted doc should return not found", deleteResult.exists());
        }
        }
            }
                assertThat(wfs.writerGeneration(), equalTo(segment.generation()));
            // Refresh thread that runs concurrently with indexing
    private MockIndexingExecutionEngine getMockExecutionEngine(DataFormatAwareEngine engine) {
            @Override
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            try {
                versionMap.putIndexUnderLock(uid, new IndexVersionValue(null, 5L, 0L, 1L));
        }
            if (commitFailure != null) throw commitFailure;
            .tombstoneDocSupplier(tombstoneDocSupplier())
    public void testCloseEngine() throws IOException {
    }
            public void afterRefresh(boolean didRefresh) {
            engine.freezeForTiering();
            assertThat("the drain must precede any catalog incorporation", indexingEngine.getRefreshCallCount(), equalTo(refreshesBefore));
        MapperService mapperService = mock(MapperService.class);
            int numDocs = randomIntBetween(1, 20);
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
            refresher.start();
            // A non-force flush while frozen must return early without committing.
     *   <li>The exception must surface to the caller as {@link RefreshFailedEngineException}
            assertThat(indexed.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            // While the lock is held there is an open translog reference pinning a generation.
import java.util.ArrayDeque;
            }
                deleteEngine.deletedIds().size(),
            engine.ensureOpen();
            assertTrue("the queued writer's generation must have been drained", deleteEngine.checkedOutGenerations().contains(42L));
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
                VersionValue vv = versionMap.getUnderLock(uid);
                        failures.incrementAndGet();
                (java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>>) queueField.get(engine);
            .primaryTermSupplier(primaryTerm::get)
            for (int i = 0; i < numDocs; i++) {
            }
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
    @SuppressForbidden(reason = "test needs reflective access to inject DeleteVersionValue into versionMap")
            failingCommitter.setCommitFailure(null);
public class DataFormatAwareEngineTests extends OpenSearchTestCase {
     *       it every result carries a location and the processed checkpoint advances safely to the contiguous max
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
     * the chunk before the delete so the translog order is index then delete; a realtime GET then misses, and finish
            // committer factory pattern — we verify the commit data indirectly through
        DocumentLookupProvider provider = mockLookupProvider();
    // --- Test: index → refresh → failEngine → verify no data loss for committed data ---
                        // flush may be disabled during translog recovery or after close
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                )
            }
                if (didRefresh) {
                }
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                        indexingDone.countDown();
            engine.index(indexOp(createParsedDocWithInput("1", null)));
        return current;
    public void testHistoryUUID() throws IOException {
    }
            Engine.Operation.Origin.PRIMARY,
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            @Override
                }
        try {
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
                        }
        indexingEngine.setWriterCustomizer(DataFormatAwareEngineTests::retireOnWrite);
            int docsPerThread = randomIntBetween(10, 20);
            for (int i = 0; i < numDocs; i++) {
                        barrier.await();
            engine.index(indexOp(createParsedDocWithInput("1", null)));
     * location and the processed/persisted checkpoints have not advanced. flush() assigns every result its location,
    public void testOnSettingsChangedFreezesOnHotToWarm() throws IOException {
        engine.flush(false, true);
            // Flush fails but engine stays open (non-corruption)
    @SuppressForbidden(reason = "test needs reflective access to inject a writer into flushQueue and read pendingWritersToClose")
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(listener), List.of());
            for (int i = 0; i < numDocs; i++) {
        return ((AtomicBoolean) field.get(engine)).get();
            // Index enough docs to potentially trigger periodic flush
            .store(store)
     * Covers the preIndex skip path when check_pending_flush is disabled.
     */
            );
            Engine.Index op = indexOp(createParsedDocWithInput("2", null));
        expectThrows(AlreadyClosedException.class, () -> engine.flush(false, true));
                failedEngineCause.set(failure);
            assertThat("snapshot durably persisted only the pre-flush docs [0..9]", persistedRows, equalTo(10L));
    }
        FailureInjectingCommitter committer = new FailureInjectingCommitter(store);
    }
    /** {@code appendOnly == false} enables updates (a second index of an existing id); {@code null} keeps the default. */
        }
                assertThat(wfs.numRows(), equalTo((long) numDocs));
            // Converge to HOT_TO_WARM: engine must freeze cleanly and block writes.
            sb.append(indent).append(current.getClass().getName()).append(": ").append(current.getMessage()).append('\n');
        AtomicInteger internalCalls = new AtomicInteger(0);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            int numDocs = randomIntBetween(5, 15);
            try (GatedCloseable<CatalogSnapshot> newRef = engine.acquireSnapshot()) {
    public void testBatchedUpdateOfSameDocumentKeepsOrderAndLatestVersion() throws IOException {
        MockDeleteExecutionEngine deleteEngine = spy(new MockDeleteExecutionEngine(mockDataFormat));
            );
                // expected
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(0L));
        // Stored document is at version 2.
            ifPrimaryTerm
            for (int i = 10; i < 15; i++) {
            // Index doc on primary → corruption escalates via maybeFailEngine → failEngine.
                assertThat(snapshot, notNullValue());
            // Phase 3: Flush — persists catalog snapshot
    public void testLocalCheckpointAdvancesCorrectly() throws IOException {
                threads[t] = new Thread(() -> {
            // Converge to a definitive HOT state: engine must unfreeze cleanly and accept writes.
            int numBatches = randomIntBetween(3, 6);
            // The retention lock pins a generation in the translog's deletion policy.
        // Fail with a corruption exception
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(
                        } else {
            dir,
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
    public void testConcurrentBatchedBulksPublishOnlyAfterRefreshAndRemainReplayable() throws Exception {
            assertThat(delete.version(), equalTo(3L));
     */
                while ((op = snapshot.next()) != null) {
                        break;
        AtomicLong genSeenInBefore = new AtomicLong(-1);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                    greaterThan(readerGen)
        }
        }
            BigArrays.NON_RECYCLING_INSTANCE,
import org.opensearch.index.seqno.SequenceNumbers;
                t.join(30_000);
import org.opensearch.core.index.AppendOnlyIndexOperationRetryException;
    @SuppressForbidden(reason = "test needs reflective access to inject a writer into flushQueue")
            VersionType.INTERNAL,
    public void testGetVersionFromMapUnsafePathTriggersRefresh() throws Exception {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(batch), null)));
        } finally {
     *       (null location) and the processed checkpoint has NOT advanced -- publication never precedes the append.</li>
    }
     * the background {@code triggerPossibleMerges()} path; {@code forceMerge} routes
                "engine should have failed from refresh IOException",
            // failEngine was called with the flush IOException.
        }
    /**
            } catch (Exception e) {
            }
        EngineConfig config = buildFailingEngineConfig(normalPlugin, listener);
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            engine.index(indexOp(createParsedDoc("2", null)));
            );
            assertThat(finalMax, equalTo(second.getTranslogLocation()));
                        // ignore
                    assertThat(op.seqNo(), greaterThanOrEqualTo(fromSeqNo));
    public void testRefreshAlreadyClosedWithTragicSourceFailsEngine() throws IOException {
     * document is processed <b>during</b> the flush (after the snapshot is frozen but before the
            "",
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
            // Sync from multiple threads
import static org.hamcrest.Matchers.not;
    private EngineConfig buildDFAEngineConfig(
                    "final snapshot generation must equal number of refreshes + 1",
                assertThat(op1.opType(), equalTo(Translog.Operation.Type.INDEX));
            try (org.opensearch.common.lease.Releasable ignored = versionMapOf(engine).acquireLock(op.uid().bytes())) {
            ifPrimaryTerm
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            engine.index(indexOp(createParsedDocWithInput("1", null)));
                assertThat(snapshot.getSegments().size(), equalTo(numBatches));
            boolean needsFlush = engine.shouldPeriodicallyFlush();
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "segment-repo")
            engine.refresh("test");
        try (DataFormatAwareEngine eng = new DataFormatAwareEngine(config)) {
            final CountDownLatch started = new CountDownLatch(3);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        }
import org.opensearch.index.store.Store;
        return (MockDeleteExecutionEngine) field.get(engine);
                }
                assertThat(snapshot.next(), nullValue());
            .externalRefreshListener(List.of())
        }
            final int numDocs = 10;
            System.nanoTime(),
import static org.hamcrest.Matchers.notNullValue;
        );
            assertTrue("matching version must be served", getByIdLookup(engine, current).exists());
        while (current != null) {
     * <p>This strengthens the basic cross-thread case so it would catch a pending-entry publication/order
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));
            return engine.getFailedEngine();
            engine.index(indexOp(createParsedDocWithInput("0", null)));
        private volatile WriterState state = WriterState.ACTIVE;
    }
    }
            expectThrows(AlreadyClosedException.class, () -> engine.refresh("test"));
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(3L));
            }
    public void testAcquireReaderReturnsValidReader() throws IOException {
        };
        }
            engine.index(indexOp(createParsedDoc("1", null)));
            VersionValue vv;
    }
        @Override
            engine.index(indexOp(createParsedDocWithInput("3", null)));
            FailableDataFormatAwareEngine failable = new FailableDataFormatAwareEngine(engine);
        Path translogPath = createTempDir();
            final Translog.Location finalMax = batch.finish();
            }
                    count++;
            return new FailingFlushWriter(config.writerGeneration(), dataFormat);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            FailableDataFormatAwareEngine failable = new FailableDataFormatAwareEngine(engine);
            setTieringStateSetting(engine, IndexModule.TieringState.HOT);
        }
            .indexSettings(indexSettings)
            assertThat(first.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            assertFalse("no writer has been drained yet", unpublishedDeletesOf(engine));
            assertThat("op 1 location must be deferred before the cross-thread GET", first.getTranslogLocation(), nullValue());
        } finally {
        Path translogPath,
    private EngineConfig buildDFAEngineConfig(
     * configured to fail on flush) and a custom event listener — used by tests that need
    ) {
            } finally {
                }
        }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                // Each segment should have exactly 1 file with 1 row (1 doc per batch)
            GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader();
            if (failedEngine != null) {
            return 0;
        } finally {
            Engine.IndexResult indexed = engine.index(indexOp(createParsedDocWithInput("del", null)));
            assertThat(failures.get(), equalTo(0));
    // --- Test: operations after failEngine throw AlreadyClosedException with original cause ---
            Engine.Operation.Origin.PRIMARY,
            engine.close();
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
                    break;
        assertTrue(TransportActions.isShardNotAvailableException(closed));
            for (int t = 0; t < 4; t++) {
                            Engine.IndexResult result = eng.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));
    private void setTieringStateSetting(DataFormatAwareEngine engine, IndexModule.TieringState state) {
        }
import org.opensearch.index.engine.dataformat.NoOpDeleteExecutionEngine;
    }
            assertTrue(started.await(5, TimeUnit.SECONDS));
        when(provider.getDocsAboveSeqNo(anyLong(), any(), any(), any())).thenReturn(
        }
                        failures.incrementAndGet();
                }
    public void testIOExceptionDuringCommitFailsEngineOnCorruption() throws IOException {
        // (InMemoryCommitter doesn't persist commit data to store, so checkpoint reflects
            "",
        }
        DataFormatAwareEngine engine = fer.engine();
            AtomicInteger threadErrors = new AtomicInteger(0);
        );
            engine.index(indexOp(createParsedDocWithInput("2", null)));
    public void testGetByIdReturnsDocFromTranslog() throws IOException {
        Exception getFailedEngine() {
            FlushFailedEngineException thrown = expectThrows(FlushFailedEngineException.class, () -> engine.flush(false, true));
                    + (persistedMaxSeqNo + 1)
                        }
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
        engine.index(indexOp(createParsedDoc("1", null)));
            assertThat(engine.countNumberOfHistoryOperations("test", 0, 4), equalTo(5));
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            @Override
            }
        };
        }
            assertNull(
        DataFormatAwareEngine engine = new DataFormatAwareEngine(config);
                    callOrder.append('A');
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("6", null))));
    private MockDeleteExecutionEngine getMockDeleteEngine(DataFormatAwareEngine engine) throws Exception {
    /**
            // Realtime get on the SAME thread resolves the pending location by flushing the batch in place.
    }
            for (Engine.IndexResult result : allResults) {
            assertThat("event listener must observe the failure", failedEngineCause.get(), notNullValue());
            Versions.MATCH_ANY,
            VersionType.INTERNAL,
            indexSettings,
            }
    /** Control: a matching {@code if_seq_no} on the segment path must still be served. */
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                    assertThat(op.seqNo(), org.hamcrest.Matchers.lessThanOrEqualTo(toSeqNo));
            Engine.IndexResult update = engine.index(indexOp(createParsedDoc("1", null)));
            assertFalse(engine.isThrottled());
        }
            // thread with the expected name to satisfy the MergeScheduler assertion.
        }
            }
            engine.flush(false, true);
    }
            assertEquals(5L, engine.getProcessedLocalCheckpoint());
                try {
    /**
            assertThat(e.getMessage(), containsString("frozen for tiering"));
            // Index 10 docs
        }
            // Engine should be failed
            }
                Translog.Operation op1 = snapshot.next();
     */
     *       wrongly consider in-flight (no orphan writers waiting for nobody).</li>
    private void bootstrapStoreWithMetadata(Store store, String translogUUID, long maxSeqNo) throws IOException {
            assertThat("second op must have an assigned seqNo", secondPending.getSeqNo(), equalTo(1L));
     * placed in the flushQueue (but not yet flushed) would be orphaned on engine close,
                    "refresh after merge must advance the catalog generation",
            int numRefreshes = randomIntBetween(3, 6);
            return 0;
            .withDeleteExecutionEngine(committer -> deleteEngine);
    }
        }
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
     */
        Path translogPath = createTempDir();
        // Fires at the END of refresh() — after the catalog snapshot has been built, but
                assertNotNull("version map must hold an entry after delete", vv);
        } finally {
            }
    public void testGetMaxSeqNoOfUpdatesOrDeletes() throws IOException {
     * (3) release the refresh lock on exit so a subsequent {@code refresh()} proceeds.
        }
     * Deterministic multi-thread bulk + concurrent refresh/flush publication fence.
    /**
            .primaryTermSupplier(primaryTerm::get)
            .threadPool(threadPool)
import org.opensearch.plugins.DocumentLookupProvider;
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            LiveVersionMap versionMap = (LiveVersionMap) vmField.get(engine);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testFailEnginePreventsSubsequentOps() throws IOException {
        DataFormatAwareEngine engine = fer.engine();
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
            assertNotNull("engine should have failed via failOnTragicEvent", failedEngine);
            false
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            assertThat(delete.origin(), equalTo(Engine.Operation.Origin.PRIMARY));
            Engine.Get future = new Engine.Get(true, true, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))).version(99L);
            int docsPerThread = randomIntBetween(10, 20);
            engine.ensureOpen();
                        break;
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
     *
                assertThat(ref.get().getGeneration(), equalTo(3L));
            this.dataFormat = dataFormat;
        assertThat(
            false
                public void onFailedEngine(String reason, Exception e) {}
            setTieringStateSetting(engine, IndexModule.TieringState.HOT_TO_WARM);
            engine.refresh("second");
    static class FailableDataFormatAwareEngine implements java.io.Closeable {
            .tombstoneDocSupplier(tombstoneDocSupplier())
            this.engine = engine;
        when(provider.getVersionMetadata(any(), any(), any(), any())).thenReturn(DocumentLookupResult.notFound("x"));
                perWorkerResults.add(new ArrayList<>());
     * to observe shard-failure callbacks while exercising flush-failure paths.
                } catch (Throwable e) {
            org.apache.lucene.util.BytesRef uid = new Term(IdFieldMapper.NAME, Uid.encodeId("1")).bytes();
            engine.close();
            }
    /**
                5L,
            try (GatedCloseable<CatalogSnapshot> snapRef = engine.acquireSnapshot()) {
        AtomicInteger droppedRefreshCount = new AtomicInteger();
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> deleteEngine);
            assertNotNull("engine should have failed from commit corruption", failable.getFailedEngine());
            assertThat("each refresh with data must notify", observedGenerations.size(), equalTo(numRefreshes));
            assertThat(stale.getFailure(), instanceOf(VersionConflictEngineException.class));
        }
    public void testDeleteEngineIOExceptionIsRethrownAndLeavesEngineOpen() throws Exception {
            false,
            final Engine.IndexResult first = engine.index(indexOp(createParsedDocWithInput("1", null)));
                } catch (Exception e) {
            "the drainer's refresh must not fail because of another request's append, but threw "
            .mapperService(mapperService)
                    }
            return delegate.listCommittedSnapshots();
                        barrier.await();
import org.opensearch.plugins.PluginsService;
                new DocumentLookupResult("a", 1L, true, null, 0L, 1L, Map.of(), Map.of()),
            int translogOpsBefore = engine.translogManager().getTranslogStats().estimatedNumberOfOperations();
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("1", null))));
                long catalogDocs = ref.get().getNumDocs();
        );
                        if (stop.get() == false) {
     * the engine ends frozen (a primary index op is rejected).
            for (int i = 0; i < numDocs; i++) {
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
     * that has not been flushed) must flush the batch in place and succeed, rather than deadlocking.
                engineFailures.add(e);
                greaterThanOrEqualTo(1)
        if (remoteStore) {
            BigArrays.NON_RECYCLING_INSTANCE,
            assertThat(
        AtomicInteger beforeCalls = new AtomicInteger();
            flushQueueOf(engine).add(new SuccessFlushWriter(42L, mockDataFormat));
            }
                assertTrue("file name should follow mock pattern", wfs.files().iterator().next().startsWith("data_gen"));
                    for (int i = 0; i < 10; i++) {
        try {
            failingCommitter.setCommitFailure(new org.apache.lucene.index.CorruptIndexException("injected corruption", "test"));
            }
            engine.close();
        DocumentLookupProvider provider,
                started.countDown();
    private Engine.Index indexOpWithIfSeqNo(ParsedDocument doc, long ifSeqNo, long ifPrimaryTerm) {
    public void testAcquireReaderAfterCloseThrows() throws IOException {
            assertThat(failures.get(), equalTo(0));
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            expectThrows(Exception.class, () -> engine.index(indexOp(createParsedDoc("6", null))));
        }
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
     * are in flight. Verifies no unhandled exceptions escape and the engine transitions to closed.
        when(provider.getVersionMetadata(any(), any(), any(), any())).thenReturn(DocumentLookupResult.notFound(""));
            int numDocs = randomIntBetween(5, 15);
        public void close() throws IOException {
        return new EngineConfig.Builder().shardId(shardId)
            assertThat("no-op batch flush returns null", batch.flush(), nullValue());
            return new DrainFailureOutcome(thrown, engineFailureReasons, engineFailures, ownerFailure, closed);
    static class FailureInjectingCommitter implements Committer {
            batch.finish();
        private final long writerGeneration;
     * map branch. Resolving through {@code DocumentLookupSupport#getById} is what applies them;
            // Ensure the buffered translog operations are durable and readable by the changes snapshot.
                assertThat("catalog must contain all successfully indexed docs", catalogDocs, equalTo((long) successCount.get()));
     *       the tragic {@code IOException} with nothing from the unwind masking it: no {@code IllegalStateException} from
                }
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDocWithInput("2", null))));
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> engine.delete(deleteOp("1")));
            int numDocs = randomIntBetween(3, 10);
            getByIdLookup(engine, realtimeGet("1"));
            Object current = currentField.get(maps);
            new MockDocumentInput()
        );
            Exception failure = new FailableDataFormatAwareEngine(engine).getFailedEngine();
            Thread[] indexThreads = new Thread[numThreads];
            for (int i = 0; i < numDocs; i++) {
                // But we track call count and verify externally.
            boolean engineClosedAfterwards
            // Phase 1 -- pending: nothing is published before the fence, even though all seqNos are assigned.
        }
            .tombstoneDocSupplier(tombstoneDocSupplier())
                        }
            public void beforeRefresh() {
    @SuppressForbidden(reason = "test needs reflective access to the engine's versionMap field")
            final Translog.Location max = batch.flush();
    public void testReplayedDeleteFromTranslogSkipsEngine() throws Exception {
        EngineConfig config = buildFailingEngineConfig(plugin);
                // (reader manager has no data for the initial empty snapshot)
            new DocumentLookupResult("1", 2L, true, null, 7L, 1L, Map.of(), Map.of())
        AtomicInteger afterDidRefreshFalse = new AtomicInteger(0);
        }
    }
     * A realtime GET issued from a DIFFERENT thread for a doc whose location is still pending must force the owning
                "42",
                assertThat(readerRef.get().reader(mockDataFormat), notNullValue());
            final int beforeAfterSeed = beforeCalls.get();
    }
     */
                try {
            // Thread 1: continuous indexing
        };
    @SuppressForbidden(reason = "test needs reflective access to inject a writer into flushQueue")
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            AtomicInteger failures = new AtomicInteger(0);
        when(documentMapper.getVersion()).thenReturn(1L);
        }
            .externalRefreshListener(externalListeners)
            assertFalse("store should NOT be corrupted", store.isMarkedCorrupted());
        try {
            id,
            assertThat("beforeRefresh fires even when no data changed", beforeCount.get(), equalTo(1));
            for (long s = 0; s < totalOps; s++) {
            .eventListener(listener)
            });
            MockDeleteExecutionEngine deleteEngine = getMockDeleteEngine(engine);
            assertThat(engine.delete(deleteOpFromTranslog("1", 0L)).getResultType(), equalTo(Engine.Result.Type.SUCCESS));
     */
            })
     * and internal listeners (registered by the engine for checkpoint tracking) must both
import static org.hamcrest.Matchers.containsString;
            int numThreads = randomIntBetween(3, 6);
import org.opensearch.index.shard.ShardPath;
    public void testRefreshNeeded() throws IOException {
                engine.close();
            assertThat(delete.getIfPrimaryTerm(), equalTo(primaryTerm.get()));
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
            assertThat(delete.routing(), equalTo("custom-routing"));
import org.opensearch.common.Nullable;
                new DocumentLookupResult("d", 1L, true, null, 4L, 1L, Map.of(), Map.of()),
            }
                "a rejected update must not supersede the copy that is still live, superseded=" + deleteEngine.deletedIds(),
    // --- Test: concurrent failEngine from multiple sources is idempotent ---
    }
                // Format-specific reader should be present
            engine.ensureOpen();
        private final long writerGeneration;
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            }
            });
            Engine.Get getWithPtConflict = realtimeGet("1").setIfSeqNo(0L).setIfPrimaryTerm(999L);
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                while (stop.get() == false) {
            assertThat("toggle off must yield the shared no-op batch", batch, sameInstance(Engine.NO_OP_TRANSLOG_BATCH));
     */
            // Before any indexing, last refreshed checkpoint is at NO_OPS_PERFORMED
        }
    }
        }
            // Index another doc — this triggers preIndex which flushes the queued writer.
            // Processed advances to N-1 on flush; persisted is NOT marked by flush (only the fsync callback does).
            // afterRefresh sees the NEW generation (snapshot committed)
        List<ReferenceManager.RefreshListener> externalListeners,
        } finally {
            Thread flushThread = new Thread(() -> {
            doThrow(new IOException("simulated delete failure")).when(deleteEngine).deleteDocument(any(DeleteInput.class), any());
            assertThat("writer injected into flushQueue", flushQueueSize(engine), equalTo(1));
        }
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                        genSeenInAfter.set(ref.get().getGeneration());
            null,
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
    /**
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            assertFalse(getByIdLookup(engine, realtimeGet("del")).exists());
     * that named a stale version.
        // A delete-only writer must flush no files, so the refresh sees hasFiles == false.
            final CyclicBarrier gate = new CyclicBarrier(2);
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
            engine.close();
        EngineConfig config = buildFailingEngineConfig(plugin);
    private static void retireOnWrite(MockWriter writer) {
            // Verify engine failed exactly once (first caller wins)
                + (outcome.refreshFailure == null ? "" : describeExceptionChain(outcome.refreshFailure)),
 * this file be licensed under the Apache-2.0 license or a
        DocumentLookupProvider provider,
                            try (GatedCloseable<IndexReaderProvider.Reader> ref = engine.acquireReader()) {
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    // ----- Batched translog append (index.translog.batch_append.enabled) -----
    private static String describeExceptionChain(Throwable t) {
        }
        boolean enabled,
        DocumentLookupProvider provider = mockLookupProvider();
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
                        barrier.await();
     * A committer wrapper that can inject failures on commit. Tragic exceptions are now
            queue.add(successWriter);
            // The result depends on translog size vs threshold — with 0 ops it should be false
                    try {
                        final Engine.TranslogBatch batch = engine.beginTranslogBatch();
            // --- Path 4: primaryTerm mismatch (seqNo matches but primaryTerm doesn't) ---
                equalTo((long) numDocs - 1)
            final Engine.IndexResult deferred = engine.index(indexOp(createParsedDocWithInput("1", null)));
                final boolean doFlush = t % 2 == 0;
                }
import java.util.Set;
                assertThat(wfs.directory(), notNullValue());
    /** Deleting an id that was never indexed still succeeds but reports not-found (currentlyDeleted path). */
            Engine.Delete delete = engine.prepareDelete(
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                            assertThat("op must have an assigned seqNo", result.getSeqNo(), greaterThanOrEqualTo(0L));
        expectThrows(AlreadyClosedException.class, () -> engine.segmentsStats(false, false));
            // has no segments, so reader managers won't have created readers
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
                while (stop.get() == false) {
                    equalTo(latestGen)
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            System.currentTimeMillis(),
            Engine.Get stale = new Engine.Get(true, true, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))).setIfSeqNo(3L)
            engine.flush(false, true);
            );
            new DummyShardLock(shardId),
            for (int i = 0; i < numDocs; i++) {
                threads[t] = new Thread(() -> {
            translogPath,
    /**
            public void onFailedEngine(String reason, Exception e) {
            engine.close();
                assertThat(
            assertTrue(versionMap.isSafeAccessRequired());
     * regression without sleeps:
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, getWithConflict));
        try {
        };
            assertThat(first.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            List<Exception> engineFailures,
            Engine.Get getWithSeqNoConflict = realtimeGet("1").setIfSeqNo(99L).setIfPrimaryTerm(1L);
import org.opensearch.common.lucene.Lucene;
            FailableDataFormatAwareEngine failable = new FailableDataFormatAwareEngine(engine);
                    } catch (Exception e) {
        Path translogPath = createTempDir();
            0
            }
            // versionMap has seqNo=0, primaryTerm=1 from the IndexVersionValue above
    public void testAcquireReaderClosingReleasesSnapshotRef() throws IOException {
            false,
 * The OpenSearch Contributors require contributions made to
                new DocumentLookupResult("a", 1L, true, null, 0L, 1L, Map.of(), Map.of()),
                        barrier.await();
            assertFalse(versionMap.isSafeAccessRequired());
            try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, numDocs - 1, false, true)) {
            // Nothing processed or persisted yet -- the batch has not been flushed.
            retentionLock.close();
            return engine.getStore();
        throws IOException {
                engine.refresh("trigger-failure");
                assertThat("gen1 must be committed", ref.get().getSegments().size(), greaterThanOrEqualTo(1));
import org.opensearch.index.translog.TranslogFactory;
     * Covers compareOpToVersionMapOnSeqNo returning OP_STALE_OR_EQUAL.
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            outcome.engineFailures,
        }
            .committerFactory(c -> {
            engine.flush(false, true);
            try (Translog.Snapshot snapshot = ((InternalTranslogManager) engine.translogManager()).getTranslog().newSnapshot()) {
     * distinguish between "new data available" and "nothing changed".
    public void testSegmentsStatsFastPathWithoutFileSizesCopiesCachedStats() throws Exception {
            int numBatches = randomIntBetween(3, 6);
                (java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>>) queueField.get(engine);
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    public void testAppendOnlyMarksVersionMapUnsafe() throws Exception {
        List<ReferenceManager.RefreshListener> externalListeners,
            notifySettingsChanged(engine);
    }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            if (w instanceof RowIdAwareWriter<?> riw && riw.getDelegate() instanceof MockWriter mw) return mw;
            public void afterRefresh(boolean didRefresh) {
            assertThat(engine.index(indexOp(createParsedDoc("1", null))).getResultType(), equalTo(Engine.Result.Type.SUCCESS));
     * calling {@code lookupFromReader} directly dropped a stale {@code if_seq_no} silently.
        vmField.setAccessible(true);
            // Translog ops count should be unchanged by sync
                            if (result.getResultType() == Engine.Result.Type.SUCCESS) {
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");
     * The segment fall-through must enforce read-time preconditions, mirroring the realtime version
            assertThat(retentionLock, notNullValue());
    private DataFormatRegistry createMockRegistry() {
            mockExecEngine.setTragicException(tragicCause);
     * A {@code _get} carrying an explicit {@code version} must conflict on the segment path too.
        Path translogPath = createTempDir();
                assertThat(ref.get().getSegments().size(), greaterThan(0));
            engine.maybeRefresh("external");
            }
        MockDeleteExecutionEngine deleteEngine = new MockDeleteExecutionEngine(mockDataFormat);
            version,
                } else {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            queueField.setAccessible(true);
        List<ReferenceManager.RefreshListener> internalListeners,
import org.opensearch.index.engine.exec.commit.CommitterFactory;
                engine.translogManager().getTranslogStats().estimatedNumberOfOperations()
                "the flushed writer's deletes must be drained during preIndex, got " + deleteEngine.checkedOutGenerations(),
        }
            int numThreads = 5;
     */
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
                    expectedMax = result.getTranslogLocation();
            final int afterAfterSeed = afterCalls.get();
    }
    }
     * Verifies the merge-count / drain wrappers delegate to the merge scheduler. On a freshly
            assertFalse("gen 42 must not be drained before it is flushed", deleteEngine.checkedOutGenerations().contains(42L));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                assertThat("dropped generation must be filtered out of the committed catalog", ref.get().getSegments().size(), equalTo(0));
            assertThat("all 13 ops were processed/acked", engine.getProcessedLocalCheckpoint(), equalTo(12L));
                            engine.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));
            assertTrue("cause should be CorruptIndexException", thrown.getCause() instanceof org.apache.lucene.index.CorruptIndexException);
            Engine.IndexResult result = engine.index(indexOpWithIfSeqNo(createParsedDocWithInput("1", null), 99L, primaryTerm.get()));
                }
     *       and the processed checkpoint advances contiguously to 1 (seqNos 0,1) -- catching a regression that
                }
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
        });
            long seqNo = 0L;
            assertThat("processed checkpoint should reflect all docs", processed, equalTo((long) numDocs - 1));
            for (Thread t : threads)
        when(provider.getVersionMetadata(any(), any(), any(), any())).thenReturn(DocumentLookupResult.notFound("x"));
    @SuppressForbidden(reason = "test needs reflective access to mark versionMap as unsafe")
                    }
                        if (doFlush) {
        engine.failEngine("test failure", new RuntimeException("simulated"));
            }
        @Override
            writer.setWriteResultSupplier(() -> { throw new java.io.UncheckedIOException(new java.io.IOException(corruption)); });
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            assertBusy(() -> {
            int numDocs = randomIntBetween(3, 10);
            for (Thread t : threads) {
            // forceMerge runs synchronously on a FORCE_MERGE thread. Dispatch to a
            }
            engine.ensureOpen();
                afterCalls.incrementAndGet();
                    }
            assertTrue("doc should be found from translog", result.exists());
        // Records call order: 'B' for beforeRefresh, 'A' for afterRefresh.
            assertThat("flushQueue must be drained on failure", flushQueueSize(engine), equalTo(0));
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDocWithInput("99", null))));
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
                // Flush calls refresh internally, producing 1 segment
        }
            for (int i = 0; i < 20; i++) {
            // The batch owner is told, and its deferred result never got a location.
            engine.close();
        DocumentLookupProvider provider = mockLookupProvider();
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            engine.translogManager().syncTranslog();
                    assertThat("doc " + i + " should succeed", result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            writer.commit();
            // Engine should still be open
     * synchronously at the end of {@code refresh()}, i.e. after the snapshot is built but, when
        TranslogConfig translogConfig = new TranslogConfig(
        try (DataFormatAwareEngine engine2 = new DataFormatAwareEngine(buildDFAEngineConfig(store, translogPath))) {
    // Delete failure and retirement-drain coverage
import java.util.HashMap;
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, false)) {
            }
        public long generation() {
        EngineConfig config = buildFailingEngineConfig(plugin);
            if (w instanceof MockWriter mw) return mw;
        }
            .threadPool(threadPool)
            .translogConfig(translogConfig)
                    assertThat("local checkpoint must not advance on rejection", eng.getProcessedLocalCheckpoint(), equalTo(maxSeqNo));
    }
     *   <li>A {@link CyclicBarrier} rendezvous makes the reader's GET and the main thread's pre-GET assertions
        );
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            AtomicInteger successCount = new AtomicInteger();
    public void testIndexRefreshFlushEndToEnd() throws IOException {
                    SequenceNumbers.UNASSIGNED_SEQ_NO,
                threads[t] = new Thread(() -> {
            armedFailure.set(new FailingBatchAppendTranslog.ArmedFailure(failure, failureClass));
/*
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            engine.refresh("test");
        String tieringState
            final CountDownLatch flushGate = new CountDownLatch(1);
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
                final Set<Long> replayedSeqNos = new java.util.HashSet<>();
                Engine.IndexResult result = engine.index(indexOp(doc));
        try {
        }
                7L,
    }
            engine.close();
            engine.refresh("test");
            int numDocs = randomIntBetween(3, 10);
            FailingBatchAppendTranslog.FailureClass.NON_TRAGIC
                CatalogSnapshot snapshot = ref.get();
        MockDeleteExecutionEngine deleteEngine = new MockDeleteExecutionEngine(df);
            assertEquals(1, segments.get(0).docCount);
            engine.index(indexOp(createParsedDoc("1", null)));
                    barrier.await();
            .dataFormatRegistry(registry)
     * it — fillSeqNoGaps must close the gap so localCheckpoint catches up to max.
            }
        indexSettings.updateIndexMetadata(IndexMetadata.builder(indexSettings.getIndexMetadata()).settings(newSettings).build());
            false
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
     * The provider returns docs for seqNos 0-3 so checkpoint advances contiguously.
                }
                assertThat(reader, notNullValue());
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                if (armed.get() && fired.compareAndSet(false, true)) {
     * code (e.g., {@code IndexShard.applyIndexOperation}) populates it via
        try {
            for (Thread t : threads) {
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    }
                "simulated corruption via maybeFailEngine",
            }
            TranslogDeletionPolicy deletionPolicy = ((InternalTranslogManager) engine.translogManager()).getTranslog().getDeletionPolicy();
            }
        );
                try {
                assertThat(reader.reader(mockDataFormat), notNullValue());
            assertSame("failed engine cause should be the indexing engine's tragic exception", tragicCause, failedEngine);
        @Override
            new DocumentLookupResult("1", 5L, true, null, 3L, 1L, Map.of(), Map.of())
            // Refresh rotates the map; safe access is carried over.
     */
    private record FailingEngineResult(DataFormatAwareEngine engine, FailureInjectingCommitter committer) {
            for (int i = 0; i < 5; i++) {
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
     * preIndex happy path.
            }
            assertThat(result.getFailure(), instanceOf(VersionConflictEngineException.class));
                IllegalStateException.class,
                engineFailed.set(true);
     * surfaced via {@link MockIndexingExecutionEngine#setTragicException} instead.
        bootstrapStoreWithMetadata(store, uuid);
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(listener), List.of());
        assertFalse("store should NOT be marked corrupted for non-corruption failures", store.isMarkedCorrupted());
        final DrainFailureOutcome outcome = driveRefreshDrainOfFailedBatchAppend(
            // Refresh → AlreadyClosedException with original cause
        private final MockDataFormat dataFormat;
            int secondFill = engine.fillSeqNoGaps(primaryTerm.get());
            assertThat("writer should have been used", failingEngine.writersCreated(), greaterThanOrEqualTo(1));
    /**
            .mergePolicy(NoMergePolicy.INSTANCE)
     * owner sees at {@code finish()}, and whether the engine is closed afterwards.
            // After flush, translog generation should have rolled.
import java.util.concurrent.atomic.AtomicInteger;
                lessThanOrEqualTo(persistedMaxSeqNo)
        // Now fail the engine
            engine.flush(false, true);
            assertEquals("lcp now equals max", 7L, engine.getProcessedLocalCheckpoint());
     * {@link MockDocumentInput}. {@link DataFormatAwareEngine#index} requires a
            try {
                assertThat(snapshot.getGeneration(), equalTo((long) numBatches + 1));
            false
                assertThat(snapshot, notNullValue());
            // What the commit DURABLY persisted: only seqnos 0..9 made it into the snapshot.
            assertEquals("no gaps to fill", 0, filled);
        EngineConfig config = buildFailingEngineConfig(MockDataFormatPlugin.of(df).withIndexingEngine(settings -> indexingEngine));
    public void testOutOfMemoryErrorDuringFlushViaCommitter() throws IOException {
     * Provider returns entries for id "x" at seqNo=2 and seqNo=5, plus a duplicate at seqNo=5.
                        }
        // Reopen engine from same store/translog — verifies committed data survives restart
                "the retiring writer's generation must have been drained, got " + deleteEngine.checkedOutGenerations(),
     * Also covers incrementIndexVersionLookup (called inside resolveDocVersion on provider path).
            droppedRefreshCount.incrementAndGet();
    public void testSnapshotSurvivesRefreshWhileHeld() throws IOException {
            assertThat("a non-translog primary delete must be written to the translog", result.getTranslogLocation(), notNullValue());
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            }
    private static DocumentLookupResult getByIdLookup(DataFormatAwareEngine engine, Engine.Get get) throws IOException {
    }
    public void testSequenceNumbersAssignedOnPrimary() throws IOException {
            // Verify that flush at least completes without error and the translog is still valid.
            CyclicBarrier barrier = new CyclicBarrier(4);
            assertThat("no worker may fail during indexing", workerFailure.get(), nullValue());
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            }
                    }
        }
            }
            primaryTerm.get(),
            engine.refresh("after-indexing");
                });
 * <p>Uses mock data format components to isolate the DFAE orchestration logic
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
        return buildDFAEngineConfig(store, translogPath, List.of(), List.of(), IndexModule.TieringState.HOT.name(), documentLookupProvider);
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
            @Override
     * Covers the refresh-thread branch when a writer's {@code flush()} throws.
                assertThat(reader.catalogSnapshot(), notNullValue());
            closersField.setAccessible(true);
     */
            );
        try {
                        indexedLatch.countDown();
                });
                new DocumentLookupResult("b", 1L, true, null, 1L, 1L, Map.of(), Map.of()),
            int numSyncThreads = randomIntBetween(2, 4);
            this.commitFailure = failure;
        bootstrapStoreWithMetadata(store, uuid);
                new FailableDataFormatAwareEngine(engine).getFailedEngine()
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            }
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
     */
     * snapshot.
        assertThat(ex.getCause(), instanceOf(IOException.class));
            }
                threads[t] = new Thread(() -> {
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
            .documentLookupProvider(provider)
            Thread[] threads = new Thread[numThreads];
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
            expectThrows(IllegalStateException.class, () -> engine.index(indexOp(createParsedDocWithInput("0", null))));
            // Engine is closed for all subsequent operations.
        FailingFlushWriter(long writerGeneration, org.opensearch.index.engine.dataformat.DataFormat dataFormat) {
            Engine.Get get = realtimeGet("1");
            engine.index(indexOp(createParsedDocWithInput("2", null)));
        return new Engine.Delete(
        }
            assertTrue("store should be marked corrupted", store.isMarkedCorrupted());
            expectThrows(AlreadyClosedException.class, () -> engine.refresh("post-fail"));
    /** Delete where ifSeqNo does not match the stored seqNo returns the planner's early conflict result. */
            public void afterRefresh(boolean didRefresh) {
                engine.refresh("batch-" + batch);
            assertThat(second.getTranslogLocation(), nullValue());
            Settings newSettings = Settings.builder()
                    refreshOutcome.set(t);
            // No further operations possible
    /**
            final AtomicReference<Throwable> workerFailure = new AtomicReference<>();
            for (int t = 0; t < numThreads; t++) {
            primaryTerm.get(),
    public void testOnSettingsChangedUnrecognizedTieringValueNotFrozen() throws IOException {
            .build();
            }
    }
            // The next index() call triggers preIndex() which polls the failing writer.
            assertThat(stats.getMaxSeqNo(), equalTo((long) totalDocs - 1));
    }
        }
        }
    private EngineConfig buildDFAEngineConfig(Store store, Path translogPath) {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            engine.forceMerge(false, 1, false, false, false, UUID.randomUUID().toString());
            new DocumentLookupResult("1", 2L, true, null, 7L, 1L, Map.of(), Map.of())
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
    public void testMultipleRefreshesAccumulateSegments() throws IOException {
            for (Thread t : indexThreads)
        final DrainFailureOutcome outcome = driveRefreshDrainOfFailedBatchAppend(tragic, FailingBatchAppendTranslog.FailureClass.TRAGIC);
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
    }
        }
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;
     * definitive state must converge the engine consistently (no deadlock, no torn state observable
    // --- Test: failEngine marks store as corrupted for CorruptIndexException ---
            } catch (Exception ignored) {}
                    assertThat(wfs.files().size(), equalTo(1));
            store.close();
            Thread flusher = new Thread(() -> {
                    } catch (Exception e) {
        }
            assertThat(failures.get(), equalTo(0));
    public void testAcquireReaderAfterMultipleRefreshesSeesAllSegments() throws IOException {
                    first = result;
            .primaryTermSupplier(primaryTerm::get)
                assertThat(
            public void beforeRefresh() {
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                }
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            engine.translogManager().syncTranslog();
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    }
            listener
    }
            AtomicReference<Throwable> error = new AtomicReference<>();
    }
            // falls back to provider which returns version=5. MATCH_ANY accepts.
    private Engine.Delete deleteOp(String id) {
            engine.ensureOpen();
    public void testBatchedAppendSelfReadFlushesPending() throws IOException {
                final int workerId = w;
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
        PluginsService pluginsService = mock(PluginsService.class);
        public void updateMappingVersion(long newVersion) {}
     * by the write thread during preIndex, producing a pending segment.
            // Phase 3 -- translog sync advances the PERSISTED checkpoint to the same max.
            engine.refresh("test");
        bootstrapStoreWithMetadata(store, uuid);
            assertThat(delete.versionType(), equalTo(VersionType.EXTERNAL));
                // Duplicate id "x" at same seqNo=5 → hits seqNo == versionValue.seqNo → OP_STALE_OR_EQUAL
    }
            assertThat(stats.getMaxSeqNo(), equalTo((long) numDocs - 1));
        // (when called from inside flush()) before flush() reads getProcessedCheckpoint().
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            org.opensearch.index.seqno.SeqNoStats stats = engine.getSeqNoStats(totalDocs - 1);
                        Thread.currentThread().interrupt();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                // expected
            reader.start();
        } finally {
                } catch (Exception e) {
            -1,
     * A delete is written inline. With the same document still pending in this thread's batch, the engine must append
            }
            // Put back an IndexVersionValue so we can test version conflict
     * with a non-matching ifSeqNo hits the seqNo/term conflict branch (IndexingStrategyPlanner) → conflict.
                engine.getPersistedLocalCheckpoint(),
    }
            )
            // Verify corruption marker file exists on disk
        bootstrapStoreWithMetadata(store, uuid);
        when(provider.getById(any(), any(), any(), any())).thenReturn(
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
            }
                }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
     * Replayed (from-translog) delete op with a pre-assigned seqNo. Non-primary origins must carry a
        }
    public void testConcurrentRefreshAndFlush() throws Exception {
            base.routing(),
            }
            Thread[] threads = new Thread[numThreads];
    }
            int numFlushes = randomIntBetween(2, 5);
            for (Thread t : threads)
            // Sanity: the refreshLock must have been released. A follow-up refresh must
        List<ReferenceManager.RefreshListener> externalListeners,
            // Index "x" again — should succeed (versionMap has version=2 from seqNo=5 entry)
        }
                            engine.flush(false, true);
        @Override
            assertThat(e.getMessage(), containsString("frozen for tiering"));
        @Override
                        if (flushGate.await(30, TimeUnit.SECONDS) == false) {
            java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>> queue =
        @Override
            SequenceNumbers.UNASSIGNED_SEQ_NO,
    @SuppressWarnings("unchecked")
            // Final refresh to flush remaining buffered docs
    }
        // Engine should be closed
                    }
            engine.index(indexOp(createParsedDocWithInput("1", null))); // seqNo 0
    public void tearDown() throws Exception {
            AtomicInteger failures = new AtomicInteger(0);
            notifySettingsChanged(engine);
            // Phase 4: Verify translog snapshot has all ops
        };
        public void close() {
        DocumentLookupProvider provider = mockLookupProvider();
            writersCreated.incrementAndGet();
        public WriterState state() {
            @SuppressWarnings("unchecked")
            assertThat(e.getMessage(), containsString("frozen for tiering"));
            MockIndexingExecutionEngine indexingEngine = getMockExecutionEngine(engine);
    }
            @SuppressWarnings("unchecked")
    }
            try {
    public void testIndexIfSeqNoConflict() throws IOException {
            assertEquals(result.getFailure().getClass(), AppendOnlyIndexOperationRetryException.class);
            .dataFormatRegistry(createMockRegistry())
     * thread itself is the one that observes the failure (only one writer in the
            }
                if (didRefresh) {
                    "reader's snapshot should match the latest generation",
            .dataFormatRegistry(registry)
                    } finally {
            this.engineFailures = engineFailures;
        boolean enabled,
    }
        assertThat(
    @SuppressForbidden(reason = "test needs reflective access to the engine's versionMap field")
    @SuppressWarnings("unchecked")
            assertThat(delete.seqNo(), equalTo(5L));
            );
                "cause message should reference simulated corruption",
        DataFormatAwareEngine engine = new DataFormatAwareEngine(config);
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
                assertThat(ref.get().getGeneration(), equalTo(1L));
            // applyMergeChanges must notify only RemoteStoreRefreshListener instances. The plain
            base.getMediaType(),
        public void close() throws IOException {
            java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>> queue =
    }
    @SuppressForbidden(reason = "test needs reflective access to the engine's flushQueue")
            Engine.Get getWithConflict = realtimeGet("1").version(3L).versionType(VersionType.EXTERNAL);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            nonTragic,
import static org.mockito.Mockito.spy;
                () -> engine.index(indexOp(createParsedDocWithInput("warm", null)))
    }
            for (int i = 0; i < 10; i++) {
        DocumentMapper documentMapper = mock(DocumentMapper.class);
        Engine.EventListener listener = new Engine.EventListener() {
import org.opensearch.common.lucene.uid.Versions;
        final Throwable refreshFailure;
                // should have created a MockReader for it during afterRefresh
        TranslogConfig translogConfig = new TranslogConfig(
            for (int batch = 0; batch < numBatches; batch++) {
        DocumentMapper documentMapper = mock(DocumentMapper.class);
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            assertThat(first.getTranslogLocation(), nullValue());
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
                        }
                    for (int i = 0; i < numRefreshes; i++) {
            .eventListener(eventListener != null ? eventListener : new Engine.EventListener() {
            primaryTerm.get(),
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> deleteEngine);
                    try {
            }
            // Tiering cancelled — state returns to HOT, engine unfreezes and indexing resumes.
                3L,
                        workerFailure.compareAndSet(null, e);
        }
        try {
    public void testRestoreVersionMapThrowsOnIOException() throws IOException {
import static org.hamcrest.Matchers.sameInstance;
            assertTrue("self-read of a pending doc must find it", getResult.exists());
                            injectedSeqNos.add(r.getSeqNo());
            MockIndexingExecutionEngine mockExecEngine = getMockExecutionEngine(engine);
            assertThat(result.getTranslogLocation(), notNullValue());
            engineRef.set(engine);
            // Initially HOT — indexing works.
                if (eng != null) {
            translogPath,
            @Override
            for (Thread t : threads)
            assertThat(ex.getCause().getMessage(), containsString("simulated flush failure"));
        DocumentMapper documentMapper = mock(DocumentMapper.class);
     * with the supplied event listener — used by upstream's writer-flush-failure tests.
            assertNotNull(
                            assertThat(result.getSeqNo(), greaterThanOrEqualTo(0L));
     * to open. Each afterRefresh(true) must correspond to a new, higher-generation
    }
                    try {
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));
            for (Engine.IndexResult result : results) {
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        DocumentLookupProvider provider = mockLookupProvider();
                IndexReaderProvider.Reader reader = readerRef.get();
        MapperService mapperService = mock(MapperService.class);
                Translog.Operation op1 = snapshot.next();
            }
            assertThat(deleteEngine.deletedIds(), equalTo(List.of("1")));
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
            // After flush, the catalog snapshot should be non-empty and have valid generation
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
            DocumentLookupResult getResult = getByIdLookup(engine, realtimeGet("1"));
        }
            );
    public void testPreIndexFlushDrainsDeletesBeforeSegmentCanBeIncorporated() throws Exception {
                    }
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
            refreshThread.join(10_000);
            this.writerGeneration = writerGeneration;
        );
    }
            engine.refresh("first");
            assertThat(replay.getSeqNo(), equalTo(0L));
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            engine.refresh("test");
     *   <li>the refresh completes (no deadlock) and throws, and the exception the refresh caller receives is rooted in
                thrown.getCause().getMessage().contains("simulated corruption via maybeFailEngine")
            AtomicInteger failures = new AtomicInteger(0);
            assertTrue(e.getMessage(), e.getMessage().contains("does not support primary operation policy"));
    /** Backwards-compatible alias for tests that explicitly call {@code createParsedDocWithInput}. */
            "test",
                assertThat(snapshot.getGeneration(), equalTo(2L));
        // Wire an indexing engine whose writer fails on flush.
     * {@code onSettingsChanged}. Only that one thread mutates index settings, so the test targets the
            final Thread refresher = new Thread(() -> {
                    }
        DocumentLookupProvider provider = mockLookupProvider();
        Path translogPath,
                // Already closed by failEngine.
                VersionType.EXTERNAL,
            // The self-read flushed the batch: the result now has a location and processed advanced.
            // the translog UUID and seq-no stats being consistent after flush.
     * {@code finish()}, the drainer's refresh may fail, but a failure that is not the translog's tragic event never
        private volatile WriterState state = WriterState.ACTIVE;
    }
        MockDeleteExecutionEngine deleteEngine = new MockDeleteExecutionEngine(mockDataFormat);
                assertThat(segment.dfGroupedSearchableFiles().containsKey(mockDataFormat.name()), equalTo(true));
            // Index 20 docs
        }
            // Update: supersedes the copy written above.
                .build();
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            );
            assertThat("no worker may fail while finishing its scope", workerFailure.get(), nullValue());
            }
    }
            }
            engine.refresh("test");
            } catch (Exception e) {
                    try {
        IOException failure,
        Path translogPath,
            assertThat(result.getFailure().getMessage(), containsString("simulated delete rejection"));
    private static final class FailingFlushWriter implements org.opensearch.index.engine.dataformat.Writer<MockDocumentInput> {
                assertThat(ref.get().getSegments().size(), equalTo(0));
            engine.index(indexOp(createParsedDocWithInput("1", null)));
    private DataFormatAwareEngine createBatchDFAEngine(Store store, Path translogPath, DocumentLookupProvider provider, boolean enabled)
        final AtomicBoolean fired = new AtomicBoolean(false);
    private LiveVersionMap versionMapOf(DataFormatAwareEngine engine) throws Exception {
            assertThat(engine.getHistoryUUID(), notNullValue());
     */
    }
            }
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
                                perWorkerResults.get(workerId).add(result);
            threads[freezers] = new Thread(() -> {
        );
            engine.index(appendOnlyOp(createParsedDocWithInput("1", null)));
                assertThat("merge must not append before/after for a non-remote-store listener", callOrder.toString(), equalTo("BABA"));
            for (int i = 0; i < 10; i++) {
            .dataFormatRegistry(createMockRegistry())
                    } catch (Exception e) {
            assertThat("merge must not invoke afterRefresh on a non-remote-store listener", afterCalls.get() - afterAfterSeed, equalTo(0));
            DocumentLookupResult translogNullResult = getByIdLookup(engine, getWithBadTranslog);
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
                throw new AssertionError("Unexpected exception during concurrent close", failure.get());
import java.util.concurrent.CyclicBarrier;
        DataFormatAwareEngine engine = fer.engine();
        @Override
            Thread[] threads = new Thread[4];
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("0", null)));
    /**
        engine.flushAndClose();
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
    public void testRestoreVersionMapSkipsStaleEntries() throws IOException {
                    assertThat("each segment should have a WriterFileSet for the mock format", wfs, notNullValue());
import java.util.List;
            // Post-conditions: all docs should still be tracked
    private DocumentLookupProvider mockLookupProvider() throws IOException {
        );
        }
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(0L));
            public void beforeRefresh() {}
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) numDocs - 1));
                int count = 0;
        Boolean appendOnly
        // Verify engine is closed by checking that operations throw
        }
    // Refresh Listener Tests — Use-case focused
            expectThrows(AlreadyClosedException.class, () -> engine.refresh("test"));
            }
            // localCheckpoint stays at 2 (the largest contiguous prefix). Gap: seqNos 3..6.
        public byte[] serializeToCommitFormat(org.opensearch.index.engine.exec.coord.CatalogSnapshot snapshot) throws IOException {
            });
                            engine.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));
            assertTrue(deleteEngine.checkedOutGenerations().contains(42L));
    }
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numBatches - 1));
            // Opened with INDEX_TIERING_STATE=HOT_TO_WARM — engine must be frozen on construction,
                        for (int i = 10; i <= 12; i++) {
        return buildFailingEngineConfig(plugin, mock(Engine.EventListener.class));
            assertThat(delete.id(), equalTo("42"));
            }
            // Inject a DeleteVersionValue into versionMap via reflection
                () -> engine.index(indexOp(createParsedDocWithInput("0", null)))
        }
            engine.index(indexOp(createParsedDoc("2", null)));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        return new ParsedDocument(
                assertThat("translog location must be deferred (null) before flush", result.getTranslogLocation(), nullValue());
    public void testCorruptionExceptionDuringIndexFailsEngineAndMarksStore() throws IOException {
        for (int i = 0; i < numDocs; i++) {
     * straight to {@code MergeScheduler.forceMerge} and does not consult it, so this
import org.opensearch.index.engine.dataformat.WriteResult;
import java.util.stream.Collectors;
                int count = 0;
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            expectThrows(FlushFailedEngineException.class, () -> engine.flush(false, true));
        queueField.setAccessible(true);
            // Reader should have format-specific reader
            Engine.Get getNoConflict = realtimeGet("1").setIfSeqNo(0L).setIfPrimaryTerm(1L);
                assertThat("seq no should be monotonically increasing", result.getSeqNo(), equalTo((long) i));
            expectThrows(FlushFailedEngineException.class, () -> engine.flush(false, true));
        Store store,
            engine.refresh("test");
        }
            for (int i = 0; i < numDocs; i++) {
        DocumentLookupProvider provider = mockLookupProvider();
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
                    ref.get().getGeneration(),
            deletionPolicy.assertNoOpenTranslogRefs();
            "",
    }
            assertThat(count, org.hamcrest.Matchers.lessThanOrEqualTo(5));
            }
            assertThat("orphan writer must be closed", orphanWriter.state(), equalTo(WriterState.CLOSED));
    }
    /**
        ) {
    public void testFillSeqNoGapsIdempotent() throws IOException {
                    }
            }
            // indexingExecutionEngine.refresh() which throws, then failEngine is called
                } catch (IOException ex) {
                .build()
            outcome.engineFailures.size(),
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            org.apache.lucene.index.CorruptIndexException corruption = new org.apache.lucene.index.CorruptIndexException(
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)
     */
    private EngineConfig buildDFAEngineConfig(
        List<ReferenceManager.RefreshListener> internalListeners,
            }
     * Covers {@code DataFormatAwareEngine.applyMergeChanges}: a forceMerge over two
            new Term(IdFieldMapper.NAME, Uid.encodeId(id)),
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
    }
            public void beforeRefresh() {
                threads[t].start();
    /**
            .internalRefreshListener(List.of())
        }
    }
            // Engine should be failed and store marked corrupted
        );
    @SuppressForbidden(reason = "test needs reflective access to the engine's unpublishedDeletes flag")
     * <ol>
            // Thread 3: periodic flush
            int numDocs = randomIntBetween(5, 20);
     *
                try {
        private final AtomicInteger writersCreated = new AtomicInteger();
        AtomicBoolean engineFailed = new AtomicBoolean();
            Engine.Get getWithBadTranslog = realtimeGet("1");
            // concurrent getAndLock (indexing) and checkoutAll (refresh).
    /**
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo((long) numDocs - 1));
            // A writer whose flush succeeds with no files, so only the drain can mark deletes.
            // treats as new doc (version NOT_FOUND)
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            // New snapshot should have higher generation
import org.opensearch.common.unit.TimeValue;
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            assertThat(batch, sameInstance(Engine.NO_OP_TRANSLOG_BATCH));
        try {
            for (Throwable s : current.getSuppressed()) {
                    } catch (Exception e) {
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(mockPlugin));
        engine.failEngine("second failure", new RuntimeException("second"));
            DocumentLookupResult updated = getByIdLookup(engine, realtimeGet("upd"));
                        engine.freezeForTiering();
            assertThat(
     */
    /**
            // Both ops carry assigned, contiguous seqNos but no location yet: nothing is published pre-GET.
        }
                afterCount.incrementAndGet();
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
        // A refresh with no new writer files drops every existing generation.
                @Override
            AtomicInteger failures = new AtomicInteger(0);
        } finally {
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            );
                assertNull("reader for unregistered format should be null", reader.reader(unknownFormat));
import org.opensearch.index.engine.dataformat.Writer;
            .internalRefreshListener(List.of())
            for (int i = 0; i < numDocs; i++) {
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        // Bootstrap the store's Lucene commit with matching translog UUID
import static org.mockito.Mockito.doThrow;
        DocumentLookupProvider provider = mockLookupProvider();
                            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(workerId + "_" + d, null)));
            for (int i = 0; i < numDocs; i++) {
            assertTrue(engine.
                assertThat(snapshot.getGeneration(), equalTo(1L));
            engine.refresh("second");
     */
            vmField.setAccessible(true);
        DocumentLookupProvider provider = mockLookupProvider();
        }
                assertThat(segment.dfGroupedSearchableFiles().size(), equalTo(1));
        );
    }
     * bulk scope to append its chunk, publishing the pending ops only after the translog append.
                        break; // expected during close
     *
            assertFalse("file sizes must be present when requested", stats.getFileSizes().isEmpty());
        );
                primaryTerm.get()
        };
     *   <li>Subsequent operations must reject with {@link AlreadyClosedException}.</li>
            throws IOException {
                assertThat(result.getSeqNo(), equalTo((long) i));
        // bootstrap state; we verify the engine is operational after recovery)
        }
     */
            final Engine.IndexResult secondPending = engine.index(indexOp(createParsedDocWithInput("2", null)));
            Engine.DeleteResult result = engine.delete(deleteOpWithIfSeqNo("1", 99L, primaryTerm.get()));
        deleteEngine.setDeletesAppliedOnCheckout(true);
            // Settings reflect HOT_TO_WARM but onSettingsChanged has NOT been called (the cached flag is
        }
import org.opensearch.action.support.TransportActions;
            .internalRefreshListener(List.of())
                IllegalStateException.class,
     * i.e. the operations actually yielded by the changes snapshot for that range, not the raw operation
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
                assertThat("every result gets a location after flush", result.getTranslogLocation(), notNullValue());
            assertThat(e.getMessage(), containsString("frozen for tiering"));
                    } catch (AlreadyClosedException e) {
        }
            for (int i = 0; i < numDocs; i++) {
            ParsedDocument far = createParsedDocWithInput("5", null);
     * fails, the engine is left in a consistent state for the surrounding orchestration:
                    assertThat(op.seqNo(), greaterThanOrEqualTo(0L));
            // Pre-flush docs: seqnos 0..9 — captured by the flush's refresh snapshot.
            }
            .primaryTermSupplier(primaryTerm::get)
        }
     * <ul>
                t.join();
            // listener registered here is not one, so the merge must NOT invoke it.
            engine.failEngine("test failure", originalCause);
        };
        );
    public void testSegmentsStatsWithFileSizesIncludesDeleteTrackingMemory() throws Exception {
            }
            }
        );
            assertEquals(1, versionMap.getAllCurrent().size());
            assertEquals(4L, engine.getProcessedLocalCheckpoint());
        };
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
    public void testFlushWithNoOpsDoesNotFail() throws IOException {
    public void testBatchedAppendFlushesAtOperationLimit() throws IOException {
            assertThat(engine.translogManager().getTranslogUUID(), notNullValue());
            false,
        }
            // Releasing the lock releases the pinned generation.
            assertTrue(versionMap.isSafeAccessRequired());
    /**
            try (GatedCloseable<IndexReaderProvider.Reader> newReaderRef = engine.acquireReader()) {
        engine.failEngine("test", new RuntimeException("simulated"));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            }
        }
            }
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        when(provider.getById(any(), any(), any(), any())).thenReturn(
        TranslogConfig translogConfig = new TranslogConfig(
            assertTrue(getByIdLookup(engine, realtimeGet("1")).exists());
        bootstrapStoreWithMetadata(store, uuid);
        FailingBatchAppendTranslog.FailureClass failureClass
        };
    public void testRefreshThreadFlushFailureFailsEngineAndDrainsQueue() throws Exception {
        expectThrows(AlreadyClosedException.class, () -> engine.refresh("after-fail"));
    /**
            }
            for (int t = 0; t < numSyncThreads; t++) {
        when(provider.getVersionMetadata(any(), any(), any(), any())).thenReturn(
     */
            assertFalse("deleting a never-indexed doc must report not found", result.isFound());
        Engine.GetResult result = engine.getById(get, (source, scope) -> null);
    /**
        primaryTerm = new AtomicLong(randomLongBetween(1, Long.MAX_VALUE));
    }
                        }
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    /** On the fast path with no cached file sizes, the shared cached stats are copied before delete memory is added. */
            }
                        engine.flush(false, true);
import org.apache.lucene.store.AlreadyClosedException;
        EngineConfig config = buildDFAEngineConfig(store, translogPath, provider);
        @Override
import org.opensearch.index.mapper.DocumentMapper;
            failingCommitter.setCommitFailure(new IOException("No space left on device"));
            .put(indexSettings.getSettings())
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            DocumentLookupResult result = getByIdLookup(engine, get);
     * The drained append is a TRAGIC translog failure. The contract this pins down:
     * writers still sitting in it. Without this, a writer checked out of the pool and
        DocumentLookupProvider provider = mockLookupProvider();
            engine.index(indexOp(createParsedDoc("1", null)));
import org.opensearch.index.IndexSettings;
    }
            .build();
                    "new reader should have a higher generation",
            .mergePolicy(NoMergePolicy.INSTANCE)
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
            engine.index(indexOp(createParsedDocWithInput("1", null)));
    /**
            new FsDirectoryFactory()
            }
            .dataFormatRegistry(registry)
            IOException tragicCause = new IOException("engine tragic");
     */
            // Acquire and close a reader, then verify the engine still works
                    engine.refresh("drain failed batch");
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            markUnsafe.setAccessible(true);
        return createBatchDFAEngine(store, translogPath, provider, enabled, true);
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
    public void testDoubleFailEngineIsIdempotent() throws IOException {
            // Acquire reader before any refresh — the initial catalog snapshot
    /**
    /**
            }
            }
        assertTrue("engine must be closed after a tragic translog failure", outcome.engineClosedAfterwards);
     *   <li>The forced append keeps the scope open: a later op is pending again until {@code finish()}.</li>
        final List<String> engineFailureReasons = new CopyOnWriteArrayList<>();
        FailureInjectingCommitter failingCommitter = fer.committer();
            assertEquals(1, queue.size());
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            final Thread[] workers = new Thread[numWorkers];
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                for (List<Engine.IndexResult> perWorker : perWorkerResults) {
    private ParsedDocument createParsedDocWithInput(String id, String routing) {
                assertThat(reader.catalogSnapshot().getSegments().size(), equalTo(1));
    }
    }
            return delegate.getLastCommittedData();
 *
                "a failed cycle must not incorporate the part that succeeded",
                }
            // All seqNos 0-3 marked → checkpoint advances to 3
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
        );
                "the skipped replay must not reach the delete engine",
    }
            provider,
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    }
            assertThat(batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
            assertThat(result.getFailure(), instanceOf(IOException.class));
                "custom-routing",
            Settings.builder()
    }
        }
    /**
     * engine.delete() is unsupported in this harness). Verifies LiveVersionMap safe-access
                assertThat(snapshot.getGeneration(), equalTo(3L));
            for (int t = 0; t < freezers; t++) {
            // writeIndexingBuffer delegates to refresh
                engine.refresh("trigger-failure");
            final List<Engine.IndexResult> allResults = new ArrayList<>();
            engine.refresh("seed-1");
            assertEquals(
    }
            int numDocs = randomIntBetween(5, 15);
            );
        DocumentMapper documentMapper = mock(DocumentMapper.class);
    /**
                    1L,
            // Flush triggers commit which fails
                assertThat(fromApi.numRows(), equalTo(wfs.numRows()));
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
import org.opensearch.core.index.Index;
                    );
                // Verify file references
            // Spawn 5 threads each calling failEngine with different reasons
    /**
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testDocCountLimitRejectsIndexingAboveMax() throws Exception {
     * seqNo, primaryTerm), but the base helper leaves that field null because production
    }
    /** Control: the matching version on the segment path must still be served. */
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            "engine must be failed exactly once, reasons were " + outcome.engineFailureReasons,
        }
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            for (int i = 0; i < 5; i++) {
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo((long) numDocs - 1));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
     * be invoked. Neither should be skipped.
import org.opensearch.index.engine.exec.IndexReaderProvider;
                failedEngineCause.set(failure);
            LiveVersionMap versionMap = (LiveVersionMap) vmField.get(engine);
        }
            assertFalse("a failed delete must not report found", result.isFound());
                new DocumentLookupResult("d", 1L, true, null, 3L, 1L, Map.of(), Map.of())
            Engine.DeleteResult result = engine.delete(deleteOp("1"));
                            throw new IllegalStateException("flush gate was never released");
            int numDocs = randomIntBetween(5, 15);
import static org.hamcrest.Matchers.greaterThan;
                if (file.startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
            Engine.Operation.Origin.PRIMARY,
            // Phase 1: Index
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(buildFailingEngineConfig(noDeletePlugin, listener))) {
            final Thread reader = new Thread(() -> {
            engine.freezeForTiering();
        engine.failEngine("corruption test", corruption);
            );
            // Index and refresh twice
            assertTrue("store should be marked corrupted", store.isMarkedCorrupted());
                if (first == null) {
            }
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true);
            batch.finish();
        final List<Long> injectedSeqNos = new ArrayList<>();
                    afterDidRefreshTrue.incrementAndGet();
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            assertThat(getResult.seqNo(), equalTo(0L));
        // Use a normal (non-failing) engine so we can inject the failure precisely.
            // Index docs, refresh, flush — establish baseline
        }
        Path translogPath = createTempDir();
            // The cached instance must not have been mutated by the copy.
    /**
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
    }
