    public void testDocCountLimitRejectsIndexingAboveMax() throws Exception {
        org.apache.lucene.index.CorruptIndexException corruption = new org.apache.lucene.index.CorruptIndexException(
     */
            assertThat(failures.get(), equalTo(0));  
            Engine.Operation.Origin.PRIMARY,
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        }
            assertThat("the drain must precede any catalog incorporation", indexingEngine.getRefreshCallCount(), equalTo(refreshesBefore));
            int numDocs = randomIntBetween(5, 15);
            engine.close();
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            assertThat(engine.currentOngoingRefreshCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(listener), List.of());  
            indexSettings,
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                    assertThat(result.getFailure(), instanceOf(IllegalArgumentException.class));  
                assertThat(snapshot.getId(), greaterThanOrEqualTo(0L));  
import org.opensearch.common.lucene.uid.Versions;  
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
        IndexSettings indexSettings = engine.config().getIndexSettings();
    }
            engine.refresh("test");
            queue.add(new FailingFlushWriter(99L, mockDataFormat));
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
            }
    /**
                        Thread.sleep(5);  
            "test",
        MockDataFormat df = mockDataFormat;  
            // A second flush has no new work and returns the same cumulative max location.
     * Reproduces the composite checkpoint-inflation data-loss bug (the one behind the
                WriterFileSet fromApi = searchableFiles.iterator().next();
            Versions.MATCH_ANY,  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
                assertThat(op1.opType(), equalTo(Translog.Operation.Type.INDEX));  
        MapperService mapperService = mock(MapperService.class);
            translogPath,
        }
        }
        );
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), mockLookupProvider())) {
        EngineConfig config = buildFailingEngineConfig(normalPlugin, listener);
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            assertThat(delete.seqNo(), equalTo(5L));
            assertThat(failures.get(), equalTo(0));  
                assertNull(engine.resolveDocVersion(op, true));
        CommitterFactory committerFactory = config -> new InMemoryCommitter(store);  
            for (Thread t : threads) {
            if (failedEngine != null) {
            // Index 20 docs
    }
            .tombstoneDocSupplier(tombstoneDocSupplier())
    }
        }  
                });
        }
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {
        Settings.Builder settings = Settings.builder()  
            engine.refresh("after-indexing");
        return provider;  
            // Each refresh with data should have triggered afterRefresh(true)  
        throws IOException {
        field.setAccessible(true);
                assertTrue("file name should follow mock pattern", wfs.files().iterator().next().startsWith("data_gen"));
     * engine.delete() is unsupported in this harness). Verifies LiveVersionMap safe-access
                    throw new RuntimeException(e);  
            assertTrue("workers must finish indexing within the bound", indexedLatch.await(30, TimeUnit.SECONDS));
            for (Thread t : threads)
            int filled = engine.fillSeqNoGaps(primaryTerm.get() + 1);  
                if (file.startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {  
    public void testUnreferencedFileCleanUpsPerformed() throws IOException {  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
                    lookup.set(getByIdLookup(engine, realtimeGet("1")));  
            assertNull("concurrent freezeForTiering must not throw", error.get());
            @Override
            }
                        }  
        };
        AtomicReference<Exception> failedEngineCause = new AtomicReference<>();
                    equalTo((long) totalOps - 1)  
        } finally {  
        };
        bootstrapStoreWithMetadata(store, uuid);
            nullValue()
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);  
            // Trigger the failure — refresh will flush writers, find new segments, call
    }
            versionType,
                assertThat(snapshot.getSegments().size(), equalTo(1));  
        };
                assertThat("no op may be published before the refresh fence", result.getTranslogLocation(), nullValue());
            engine.writeIndexingBuffer();
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), state.name())
        Path translogPath = createTempDir();
    @SuppressForbidden(reason = "test needs reflective access to inject a writer into flushQueue")
     *
            for (int i = 0; i < numDocs; i++) {
                            }  
    }
/*  
     *   <li>{@link DataFormatAwareEngine#failEngine} must run with the originating cause,
        expectThrows(AlreadyClosedException.class, () -> engine.flush(false, true));
     * as {@code if_seq_no} does for updates — and the same missing
            });
    /**
                    } catch (Exception e) {
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
                } catch (IOException ex) {
                    System.nanoTime(),  
            null,  
import java.util.stream.Collectors;  
        try (
            // versionMap has seqNo=0, primaryTerm=1 from the IndexVersionValue above
        return buildFailingEngineConfig(plugin, mock(Engine.EventListener.class));  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            notifySettingsChanged(engine);  
            assertSame("flush ACE cause should be the original failure", originalCause, flushEx.getCause());
            assertThat(updated.seqNo(), equalTo(second.getSeqNo()));
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        DocumentLookupProvider provider = mockLookupProvider();
                assertThat(  
            }  
            }  
                assertThat(snapshot.getSegments().size(), equalTo(numBatches));
            "",
                        if (flushGate.await(30, TimeUnit.SECONDS) == false) {
    }  
            }  
            int firstFill = engine.fillSeqNoGaps(primaryTerm.get());
            shardId,  
            int historyCount = engine.countNumberOfHistoryOperations("test", 0, numDocs - 1);
                CatalogSnapshot snapshot = ref.get();
            engine.writeIndexingBuffer();  
            int numDocs = randomIntBetween(1, 20);  
            // applyMergeChanges must notify only RemoteStoreRefreshListener instances. The plain  
            // Engine should be failed
            int numDocs = randomIntBetween(5, 15);  
                AlreadyClosedException.class,  
     * new data becomes searchable. After indexing + refresh, the listener must be
            delegate.markStoreCorrupted(cause);  
     * Covers {@code DataFormatAwareEngine.applyMergeChanges}: a forceMerge over two
        DocumentLookupProvider provider,
            }
            );  
        Store store,
    }  
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(orderingListener), List.of());
            Thread refreshThread = new Thread(() -> {
    /** With no gap (lcp == max), fillSeqNoGaps writes 0 NoOps and returns 0. */
        private final org.opensearch.index.engine.dataformat.DataFormat dataFormat;
            engineRef.set(engine);  
        }
            final int numDocs = 10;
            for (int i = 0; i < numDocs; i++) {  
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
     * {@code RestGetAction} parses {@code version}/{@code version_type} and {@code ShardGetService}  
    /**
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
            int docsPerThread = randomIntBetween(10, 20);
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("post-fail", null))));
     * {@link DataFormatAwareEngine#countNumberOfHistoryOperations(String, long, long)} must count only the
import org.opensearch.test.OpenSearchTestCase;
        ShardPath shardPath = new ShardPath(false, path, path, shardId);
        while (current != null) {  
        return new Store(  
            deletionPolicy.assertNoOpenTranslogRefs();
     * threads them into {@code Engine.Get}, so the precondition reaches the engine for reads just
            }  
     * When a retiring writer's drain reports that buffered deletes were applied, the engine must  
     * Use case: Both external listeners (registered by IndexShard for search-after-refresh)  
        Engine.GetResult result = engine.getById(get, (source, scope) -> null);
                expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("post-fail", null))));
        Path translogPath = createTempDir();
            assertThat("finish must return the greatest location appended by the scope", finalMax, equalTo(third.getTranslogLocation()));
    /**  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
     * DFAE port of InternalEngineTests.testVersionMapAfterAutoIDDocument (delete step dropped —  
            // A version ahead of the stored one must conflict as well, not be silently served.
                @Override
                "engine should have failed from refresh IOException",  
                    assertThat("seq no must not be assigned on rejection", result.getSeqNo(), equalTo(SequenceNumbers.UNASSIGNED_SEQ_NO));
    }
            final Throwable current = work.pop();
        DocumentLookupProvider provider = mockLookupProvider();
    private static String describeExceptionChain(Throwable t) {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    }
            "",  
                        containsString("Number of documents in shard " + shardId + " exceeds the limit of [" + maxDocs + "]")  
                .deleteDocument(any(DeleteInput.class), any());
            @Override
            // Optimized append-only: no safe access enforced, nothing stored in the current map.  
     *       deterministically ordered without timing guesses.</li>
            .mergePolicy(NoMergePolicy.INSTANCE)  
     * {@code LOCAL_CHECKPOINT = getProcessedCheckpoint()} read <b>after</b> that refresh. If a  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
                closed = true;
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
    }
        Boolean appendOnly,
            assertThat(first.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
     * Provider returns entries for id "x" at seqNo=2 and seqNo=5, plus a duplicate at seqNo=5.  
        // Reopen engine from same store/translog — verifies committed data survives restart  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(batch), null)));  
            assertThat(e.getMessage(), containsString("frozen for tiering"));
            }
            assertThat(second.getTranslogLocation(), nullValue());
    }  
            .store(store)
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDocWithInput("2", null))));
            new DocumentLookupResult("1", 5L, true, null, 3L, 1L, Map.of(), Map.of())  
            // Thread 3: periodic flush  
            new FsDirectoryFactory()
        }
    /** Deleting an id that was never indexed still succeeds but reports not-found (currentlyDeleted path). */
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
            // seqno actually present in the committed snapshot. Otherwise recovery replays from  
        final List<String> engineFailureReasons;
            for (int w = 0; w < numWorkers; w++) {
            threads[freezers].start();
import org.opensearch.index.engine.dataformat.WriteResult;
            return delegate.isCommitManagedFile(fileName);
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());  
    private Engine.Delete deleteOp(String id) {  
            assertSame("index ACE cause should be the original failure", originalCause, indexEx.getCause());  
                        indexedLatch.countDown();
            final Thread[] workers = new Thread[numWorkers];
            // Before sync, persisted may lag behind processed
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            assertEquals(4L, engine.getProcessedLocalCheckpoint());  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    /**  
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
            }, "refresh-under-failed-batch-append");
            indexSettings,  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            })
            primaryTerm.get(),
            engine.close();  
                        }  
     * {@link MockDocumentInput}. {@link DataFormatAwareEngine#index} requires a
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("post-fail", null))));
            .externalRefreshListener(List.of())  
        java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");
                // Verify file references
            Thread[] threads = new Thread[numThreads];  
                        for (int d = 0; d < docsPerThread; d++) {  
        }
            queue.add(successWriter);
            java.lang.reflect.Field queueField = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
            }  
            engine.refresh("second");
                assertThat(ref.get().getGeneration(), equalTo(2L));
            // --- Path 4: primaryTerm mismatch (seqNo matches but primaryTerm doesn't) ---
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            assertTrue("store should be marked corrupted", store.isMarkedCorrupted());
                public void onFailedEngine(String reason, Exception e) {}  
                                assertThat(reader.catalogSnapshot().getSegments().size(), greaterThan(0));  
            // Inject an expired DeleteVersionValue (time far in the past) so gc_deletes nullifies it  
     * expects to find: translog UUID, seq-no info, history UUID, etc.
                CatalogSnapshot snapshot = reader.catalogSnapshot();  
    ) {  
            engine.translogManager().syncTranslog();
                public void onFailedEngine(String reason, Exception e) {}
        for (Throwable suppressed : allSuppressed(outcome.refreshFailure)) {  
        indexingEngine.setWriterCustomizer(writer -> {
            } catch (Exception ignored) {}
     * advances the processed checkpoint to N-1, returns the batch max location, and does NOT mark anything persisted
     *       (null location) and the processed checkpoint has NOT advanced -- publication never precedes the append.</li>
            Engine.Get getWithSeqNoConflict = realtimeGet("1").setIfSeqNo(99L).setIfPrimaryTerm(1L);
        bootstrapStoreWithMetadata(store, uuid);  
            for (int i = 0; i < numDocs; i++) {  
            engine.index(indexOp(createParsedDoc("1", null)));  
    }
            BigArrays.NON_RECYCLING_INSTANCE,
            expectThrows(IllegalArgumentException.class, () -> engine.flush(true, false));
    }  
import static org.mockito.Mockito.doThrow;  
        @Override  
        DocumentMapper documentMapper = mock(DocumentMapper.class);  
                        error.compareAndSet(null, e);
        final List<Long> injectedSeqNos = new ArrayList<>();  
            assertThat(e.getMessage(), containsString("frozen for tiering"));  
            .threadPool(threadPool)  
            for (int i = 0; i < 5; i++) {
                    } catch (FlushFailedEngineException e) {  
                "[{}] refresh threw: {}engine failures: {}",
        public boolean isCommitManagedFile(String fileName) {
            System.nanoTime(),  
     *
        return buildBatchDFAEngineConfig(store, translogPath, provider, enabled, remoteStore, appendOnly, null, null);
    public void testRefreshAfterCloseThrows() throws IOException {
import org.opensearch.index.translog.Translog;  
            // The next index() call triggers preIndex() which polls the failing writer.
            Exception failedEngine = new FailableDataFormatAwareEngine(engine).getFailedEngine();
        }
    public void testRefreshDrainOfNonTragicBatchAppendDoesNotFailEngine() throws Exception {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
            .build();  
            outcome.engineFailures.size(),  
            equalTo(1)
            // Index documents — data is buffered but not yet searchable
            final List<Engine.IndexResult> results = new ArrayList<>();
    public void testFailEngineAfterFlushPreservesCommittedData() throws IOException {
    public void testBatchedIndexThenInlineDeleteFlushesPendingChunkFirst() throws IOException {
        engine.index(indexOp(createParsedDocWithInput("1", null)));
    public void testTranslogSyncPersistsCheckpoint() throws IOException {
            engine.close();
            }  
    public void testRefreshFailureWithBufferedSegmentsFailsEngine() throws Exception {  
     */
            assertThat(e.getMessage(), containsString("frozen for tiering"));
            // Refresh — makes data searchable, listener must be notified
            }  
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
            nonTragic,
    public void testFlushWithNoOpsDoesNotFail() throws IOException {
    public void testSequenceNumbersAssignedOnPrimary() throws IOException {  
            java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>> queue =
            base.getMediaType(),
            engine.refresh("test");  
                    try {  
        List<ReferenceManager.RefreshListener> externalListeners,
                }  
                    equalTo(latestGen)  
    public void testOnSettingsChangedFreezesOnHotToWarm() throws IOException {
            if (w instanceof MockWriter mw) return mw;  
        when(provider.getDocsAboveSeqNo(anyLong(), any(), any(), any())).thenReturn(
            IllegalStateException e = expectThrows(
            java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>> queue =
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
            assertEquals(result.getFailure().getClass(), AppendOnlyIndexOperationRetryException.class);  
                deleteEngine.checkedOutGenerations().isEmpty()  
            assertFalse("reader thread must not still be running (no deadlock)", reader.isAlive());  
    public void testRestoreVersionMapThrowsOnIOException() throws IOException {
            }
            @Override
            assertThat(failedUpdate.getResultType(), equalTo(Engine.Result.Type.FAILURE));  
        }  
            })
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
            assertThat(batch, sameInstance(Engine.NO_OP_TRANSLOG_BATCH));  
            // Configure MockWriter to throw CorruptIndexException as the addDoc cause.
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            assertThat(result.getTranslogLocation(), notNullValue());
            // Phase 2: Refresh — makes data searchable
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            int numDocs = randomIntBetween(5, 15);
                    assertThat(op.seqNo(), org.hamcrest.Matchers.lessThanOrEqualTo(toSeqNo));
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
     * A: write-path version conflict resolved from the versionMap. EXTERNAL version=5 then a stale  
                .put(IndexModule.INDEX_TIERING_STATE.getKey(), "NOT_A_REAL_STATE")  
        DataFormatAwareEngine engine = new DataFormatAwareEngine(config);  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                }  
                t.join();
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, getWithSeqNoConflict));
        final int maxDocs = randomIntBetween(1, 20);
        engine.failEngine("null failure test", null);
            BigArrays.NON_RECYCLING_INSTANCE,
            FailingFlushWriter orphanWriter = new FailingFlushWriter(777L, mockDataFormat);
        }  
            "test"
        EngineConfig config = buildFailingEngineConfig(plugin);
            engine.index(indexOp(createParsedDocWithInput("1", null)));
                // Verify the segment has exactly one format entry  
        }  
     */  
        Path translogPath,
            assertSame(DefaultPrimaryOperationPolicy.INSTANCE, config.getPrimaryOperationPolicy());  
            assertThat(engine.translogManager().getTranslogUUID(), notNullValue());
        if (appendOnly != null) {  
    /** The default provider must be accepted, so the check above cannot reject every index. */
            public void beforeRefresh() {
import static org.mockito.Mockito.mock;
            );
    public void testGetByIdFromSegmentsEnforcesStaleVersion() throws IOException {  
            engine.refresh("test");  
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) numDocs - 1));  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
    }
        boolean enabled,
            engine.index(indexOp(createParsedDocWithInput("1", null)));
     * refresh listener that fires on real refreshes is NOT invoked by the merge, and  
                equalTo(deletesAfterFirstReplay)
            // Produce two segments via two refresh cycles so the merger has something to combine.
            // before any onSettingsChanged call.
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());  
            // Index first, then refresh — avoids writer pool race between
            flusher.join();
     * managers that need to open readers on the new snapshot.  
     * </ul>  
            assertThat(delete.version(), equalTo(3L));
            }
    public void testIndexOperationsWrittenToTranslog() throws IOException {  
        }
            int refreshesBefore = indexingEngine.getRefreshCallCount();
            }
     *  
     */
            }
     *       it every result carries a location and the processed checkpoint advances safely to the contiguous max
            }
            queue.add(orphanWriter);
 * catalog snapshot management, concurrency, and failure handling.
     *       so the IndexShard can react.</li>
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
        DocumentLookupProvider provider,
     */  
        bootstrapStoreWithMetadata(store, uuid);  
        return new DataFormatRegistry(pluginsService);
            // After indexing, shouldPeriodicallyFlush may or may not be true  
        );
            Thread refresher = new Thread(() -> {
                CatalogSnapshot snapshot = ref.get();
                workers[w].start();  
            // afterRefresh(false) indicates nothing new became searchable
        Path translogPath = createTempDir();
            engine.refresh("after-rejected-delete");
            // Refresh so the get cannot be answered from the version map.
        private final AtomicInteger writersCreated = new AtomicInteger();
                engine.refresh("trigger-failure");
            int docsPerThread = 50;  
            assertThat(engine.getHistoryUUID(), notNullValue());
            Engine.IndexResult indexed = engine.index(indexOp(createParsedDocWithInput("del", null)));
            try (org.opensearch.common.lease.Releasable ignored = versionMapOf(engine).acquireLock(op.uid().bytes())) {  
                throw new AssertionError("failure while performing test: " + failureCause.get());
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDocWithInput("2", null))));
                // should have created a MockReader for it during afterRefresh
            LiveVersionMap versionMap = (LiveVersionMap) vmField.get(engine);  
                }  
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            engine.ensureOpen();
        @Override  
 * compatible open source license.
import java.util.concurrent.atomic.AtomicLong;
                assertThat(op1.seqNo(), lessThan(op2.seqNo()));  
    public void testDeleteNonExistentDocReportsNotFound() throws IOException {
    public void testFillSeqNoGapsIdempotent() throws IOException {
        } finally {
        MockDataFormat df = mockDataFormat;
        return new Engine.Index(
                assertThat("two segments before merge", ref.get().getSegments().size(), equalTo(2));  
            long genBefore;
                        Thread.sleep(10);  
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);  
            // No refresh, so the cached stats hold no segments and carry no file sizes.  
                assertThat(reader.catalogSnapshot().getSegments().size(), equalTo(1));
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        }
            assertThat(engine.delete(deleteOpFromTranslog("1", 0L)).getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                    observedGenerations.add(System.nanoTime()); // monotonic timestamp as proxy
            }
            // The forced append keeps the scope open: later operations form a new chunk in the same bulk.  
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));
            } catch (Exception ignored) {
            @SuppressWarnings("unchecked")
    private DataFormatAwareEngine createBatchDFAEngine(
    public void testResolveDocVersionReturnsVersionMapHit() throws Exception {
 */  
            AtomicInteger failures = new AtomicInteger(0);
     * Use case: When no new data has been indexed, a refresh should still notify  
     *       a closed pool, no second {@code AlreadyClosedException} from closing closed resources, as the thrown chain
    private EngineConfig buildDFAEngineConfig(
                assertThat(result.getTranslogLocation(), notNullValue());
            // Engine should be failed
                public void onFailedEngine(String reason, Exception e) {}
     * Covers the preIndex cooperative-flush path when a writer's {@code flush()} throws.  
        return new Engine.Delete(
                    String fileName = wfs.files().iterator().next();  
                CatalogSnapshot snapshot = ref.get();
    public void testIOExceptionDuringCommitFailsEngineOnCorruption() throws IOException {  
            return new FailingFlushWriter(config.writerGeneration(), dataFormat);
            final Engine.IndexResult first = engine.index(indexOp(createParsedDocWithInput("1", null)));  
            reader.start();
        }
    private MockDeleteExecutionEngine getMockDeleteEngine(DataFormatAwareEngine engine) throws Exception {
            assertThat(replay.getSeqNo(), equalTo(0L));
    /**
            doc,  
            }
            engine.close();  
        }  
            java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>> queue =  
                engine.getPersistedLocalCheckpoint(),  
                sameInstance(tragic)
            failingCommitter.setCommitFailure(corruption);
        }  
            }
    public void testFlushCommitDataContainsCatalogSnapshotKeys() throws IOException {  
        try {
            armedFailure.set(null);
                while ((op = snapshot.next()) != null) {  
            engine.ensureOpen();
            .withIndexingEngine(settings -> indexingEngine)  
        DocumentMapper documentMapper = mock(DocumentMapper.class);  
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {  
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
            assertEquals(2L, engine.getProcessedLocalCheckpoint());
                assertThat(snapshot, notNullValue());
    public void testRetireWriterDeleteDrainFailureFailsEngine() throws Exception {  
    public void testRestoreVersionMapSkipsStaleEntries() throws IOException {  
     * assert the engine-level invariant the fix must restore: the committed
            assertThat("the operation cap must append the first chunk", first.getTranslogLocation(), notNullValue());  
                new DocumentLookupResult("b", 1L, true, null, 1L, 1L, Map.of(), Map.of()),
                    } catch (InterruptedException e) {  
                    "refresh after merge must advance the catalog generation",
            engine.close();  
            assertNotNull("engine should have failed via failOnTragicEvent", failedEngine);  
    public void testForceFlushRequiresWaitIfOngoing() throws IOException {
     * <p>Two worker threads each open their OWN translog batch (the batch scope is thread-local, so each thread must
        assertFalse("engine must stay open after a non-tragic append failure", outcome.engineClosedAfterwards);
        }  
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
            // Verify onFailedEngine called exactly once
            long processed = engine.getProcessedLocalCheckpoint();  
            markUnsafe.invoke(current);  
            assertTrue("store should be marked corrupted", store.isMarkedCorrupted());
    /**
        DocumentLookupProvider provider = mockLookupProvider();  
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));
            .withIndexingEngine(settings -> indexingEngine)  
    private static final class FailingFlushIndexingExecutionEngine extends MockIndexingExecutionEngine {  
                assertThat("seq no should be monotonically increasing", result.getSeqNo(), equalTo((long) i));  
     * pool, so there are no write threads racing for it).  
    public void testAcquireReaderReturnsNullForUnregisteredFormat() throws IOException {  
            engine.freezeForTiering();  
            // 3 successful PRIMARY ops → seqNos 0, 1, 2 / lcp = 2 / max = 2  
    public void testShouldPeriodicallyFlush() throws IOException {  
                }  
            ifSeqNo,
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
     */
            engine.refresh("test");
                    }
                    }  
        DataFormatAwareEngine engine = fer.engine();  
            // Rendezvous so the reader's GET happens strictly after the pre-GET assertions above, with no sleeps.
     *       (totalOps-1). Publication happens only after the translog append.</li>
                    } catch (Exception e) {  
    private EngineConfig buildDFAEngineConfigWithCommitterFactory(Store store, Path translogPath, CommitterFactory committerFactory) {  
    public void testSnapshotSurvivesRefreshWhileHeld() throws IOException {  
                        engine.refresh("concurrent-test");  
            assertThat(persisted, org.hamcrest.Matchers.lessThanOrEqualTo(processed));  
            mockExecEngine.setRefreshFailure(() -> new IOException("disk full during refresh"));
     *
            Engine.Index recoveryOp = new Engine.Index(  
        try {  
    /** Delete where ifSeqNo does not match the stored seqNo returns the planner's early conflict result. */  
                            engine.flush(false, true);
            engine.index(indexOp(createParsedDocWithInput("1", null)));
                VersionType.EXTERNAL,  
        indexSettings.updateIndexMetadata(IndexMetadata.builder(indexSettings.getIndexMetadata()).settings(newSettings).build());
            for (int i = 0; i < 1_000; i++) {  
            new DocumentLookupResult("1", 2L, true, null, 7L, 1L, Map.of(), Map.of())
            }  
        }
     * checkpoint is read) it lands in a NEW writer that is not in the snapshot, yet it advances
     * {@code finish()}, the drainer's refresh may fail, but a failure that is not the translog's tragic event never
            assertThat("processed checkpoint should reflect all docs", processed, equalTo((long) numDocs - 1));  
                    ref.get().getGeneration(),
     * Use case: Multiple index-refresh cycles should produce monotonically advancing
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)
        EngineCreationFailureException ex = expectThrows(EngineCreationFailureException.class, () -> new DataFormatAwareEngine(config));
            LiveVersionMap versionMap = (LiveVersionMap) vmField.get(engine);
            assertThat(max, equalTo(second.getTranslogLocation()));
            // Index some docs and refresh to establish baseline
            @Override
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));
            for (int i = 0; i < numDocs; i++) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        assertThat(ex.getMessage(), containsString("failed to restore version map"));  
                        break;
            1L,
            }
                DataFormatAwareEngine eng = engineRef.get();
                    afterDidRefreshTrue.incrementAndGet();  
            false
            }
        try {
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
            AlreadyClosedException refreshEx = expectThrows(AlreadyClosedException.class, () -> engine.refresh("post-fail"));  
        AtomicInteger beforeCount = new AtomicInteger(0);
            assertThat("afterRefresh(true) should NOT fire", afterDidRefreshTrue.get(), equalTo(0));  
                assertThat(snapshot.next(), nullValue());
import java.util.concurrent.CopyOnWriteArrayList;
        Store store,
        );  
        EngineConfig config = buildFailingEngineConfig(MockDataFormatPlugin.of(df).withIndexingEngine(settings -> indexingEngine));
        );  
     */  
            @Override  
    public void testAcquireHistoryRetentionLockPinsTranslogGeneration() throws IOException {
     */
            }
    }  
            }
            VersionType.INTERNAL,
        }
            }
     */
import org.opensearch.index.translog.InternalTranslogFactory;
            assertTrue(versionMap.getAllCurrent().isEmpty());  
            failingCommitter.setCommitFailure(new IOException("disk error"));
        }
import org.opensearch.index.mapper.IdFieldMapper;  
                t.join();  
                if (expectedMax == null || result.getTranslogLocation().compareTo(expectedMax) > 0) {
            // No thread should have thrown  
     * C: optimized append-only ops never enter safe-access mode — they leave the current map empty  
    public void testResolveDocVersionReturnsNullOnEmptyCatalog() throws Exception {  
            engine.translogManager().syncTranslog();
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(engine.getProcessedLocalCheckpoint()));
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(totalDocs));  
            assertEquals("no gaps to fill", 0, filled);
                    5L,
                "test"
            int numDocs = randomIntBetween(3, 10);
            Engine.Get getWithConflict = realtimeGet("1").version(3L).versionType(VersionType.EXTERNAL);  
            // Wait for threads to finish
    /**  
            assertThat(maxSeqNo.get(), equalTo((long) totalDocs - 1));
            // Before sync, persisted checkpoint may lag  
        void failEngine(String reason, Exception failure) {
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
     * AFTER (so listeners can observe the new state). This is critical for reader
            // One indexed doc → one writer in the pool. Refresh thread will be the sole flusher.  
            true,
        }  
    }
            engine.index(indexOp(createParsedDoc("1", null)));  
            engine.refresh("test");  
                assertThat(ref.get().getGeneration(), equalTo(1L));  
                        for (int d = 0; d < docsPerThread; d++) {
        }  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            engine.flush(false, true);
            assertThat("afterRefresh must fire when new segments are produced", afterCount.get(), equalTo(1));  
     * owner sees at {@code finish()}, and whether the engine is closed afterwards.  
    }
    }
    public void testResolveDocVersionReturnsNullWhenProviderNotFound() throws Exception {
        java.lang.reflect.Field f = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            BigArrays.NON_RECYCLING_INSTANCE,
                    failureCause.set(e);  
            assertThat("orphan writer must be closed", orphanWriter.state(), equalTo(WriterState.CLOSED));  
                afterCalls.incrementAndGet();
     */  
            EngineConfig config = buildDFAEngineConfig(store, createTempDir()).toBuilder()
import org.opensearch.index.IndexModule;
        when(provider.getDocsAboveSeqNo(anyLong(), any(), any(), any())).thenThrow(new IOException("simulated read failure"));
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
        }
                        }
    public void testDeleteFromTranslogMarksSeqNoAndSkipsTranslog() throws IOException {
            engine.refresh("test");  
        when(mapperService.documentMapper()).thenReturn(documentMapper);  
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
        }
        }
    public void testIndexRefreshFlushEndToEnd() throws IOException {  
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, getWithConflict));
    public void testFailEnginePreventsSubsequentOps() throws IOException {
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
    }
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        super.tearDown();
            assertThat(deleted.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
            assertTrue("a drain that applied deletes must leave them marked unpublished", unpublishedDeletesOf(engine));
            public void afterRefresh(boolean didRefresh) {  
                deleteEngine.deletedIds().isEmpty()  
    }  
     *   <li>A {@link CyclicBarrier} rendezvous makes the reader's GET and the main thread's pre-GET assertions  
            for (int i = 0; i < 5; i++) {
            }
            @Override  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
        // Create committer AFTER bootstrap so InMemoryCommitter can read segments info
    public void testResolveDocVersionReturnsNullWhenNoProvider() throws Exception {
        @Override
            Engine.DeleteResult result = engine.delete(deleteOp("1"));
                committedCheckpoint,
            }  
        }
            // No further operations possible
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
    }
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;
        // Index and flush to commit data
            .documentLookupProvider(provider)  
                        // ignore
    public void testMergeCountWrappers_IdleEngine_ReportZeroAndAlreadyDrained() throws IOException {
            assertThat("opt-in must produce a real (non-no-op) batch", batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
            DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            .store(store)
                    );
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat)
            // With no ops, should not need periodic flush
            }
        };
            int numDocs = randomIntBetween(1, 5);
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
     * that named a stale version.
            expectThrows(AlreadyClosedException.class, () -> engine.refresh("test"));  
        @Override
    public void testSegmentsReturnsEngineSegments() throws IOException {  
        Engine.EventListener listener = new Engine.EventListener() {
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                    failures.incrementAndGet();
            assertEquals("lcp now equals max", 7L, engine.getProcessedLocalCheckpoint());
        }  
        }
        }
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            engine.close();  
            assertTrue("a matching precondition must be served", getByIdLookup(engine, current).exists());
        );
            expectThrows(AssertionError.class, deletionPolicy::assertNoOpenTranslogRefs);
            assertThat(delete.getIfPrimaryTerm(), equalTo(primaryTerm.get()));  
            assertEquals("idle engine has no active merges", 0, engine.getActiveMergeCount());
    public void testRefreshFailureAfterIndexingFailsEngine() throws Exception {  
            // After flush, the catalog snapshot should be non-empty and have valid generation  
            assertTrue(deleted.isFound());
            failingCommitter.setCommitFailure(new org.apache.lucene.index.CorruptIndexException("injected corruption", "test"));
                CatalogSnapshot snapshot = ref.get();
        Path translogPath = createTempDir();
            .store(store)
            org.apache.lucene.index.CorruptIndexException corruption = new org.apache.lucene.index.CorruptIndexException(  
                        failures.incrementAndGet();
            engine.index(indexOp(createParsedDocWithInput("1", null)));
                }
     * flush fails, the engine must:  
            refreshThread.start();  
                org.opensearch.index.engine.exec.Segment segment = snapshot.getSegments().get(0);
                    0
            AlreadyClosedException indexEx = expectThrows(
            // Final refresh to flush remaining buffered docs  
            .store(store)  
            }
        );  
            for (int i = 0; i < 3; i++) {
import static org.hamcrest.Matchers.notNullValue;  
                "the skipped replay must not reach the delete engine",
        MapperService mapperService = mock(MapperService.class);
        Path translogPath = createTempDir();
import org.apache.lucene.store.Directory;
            java.lang.reflect.Field queueField = DataFormatAwareEngine.class.getDeclaredField("flushQueue");  
            engine.onMergesDrained(() -> listenerFired.set(true));  
        }  
            java.lang.reflect.Field mapsField = LiveVersionMap.class.getDeclaredField("maps");
    }
        };
     * and with the bulk-path batch failure handling means the engine must NOT be failed: the owning bulk fails at  
            return 0;
    private FailingEngineResult createDFAEngineWithFailingCommitter(Store store, Path translogPath) throws IOException {
            engine.flush(false, true);  
        }
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            Engine.Get get = new Engine.Get(false, false, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1")));
                });
    static class FailureInjectingCommitter implements Committer {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            // No writer leaked in the shared flushQueue. Use reflection (test-only) to
            org.apache.lucene.index.CorruptIndexException corruption = new org.apache.lucene.index.CorruptIndexException(  
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));  
            MockIndexingExecutionEngine mockExecEngine = getMockExecutionEngine(engine);  
                        }
        private volatile IOException commitFailure;
    }
        }
                    for (int n = 0; n < iterations; n++) {  
                IllegalStateException.class,
            // Releasing the lock releases the pinned generation.  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            }
            assertTrue(engine.isThrottled());
                primaryTerm.get()  
                        failures.incrementAndGet();
     * Covers restoreVersionMapAndCheckpointTracker + compareOpToVersionMapOnSeqNo.
        DataFormatAwareEngine engine = fer.engine();
            final AtomicReference<Throwable> refreshOutcome = new AtomicReference<>();  
     * Covers the refresh-thread branch when a writer's {@code flush()} throws.
            assertThat(delete.versionType(), equalTo(VersionType.EXTERNAL));  
            try (org.opensearch.common.lease.Releasable ignored = versionMapOf(engine).acquireLock(op.uid().bytes())) {  
            currentField.setAccessible(true);
            .translogFactory(translogFactory != null ? translogFactory : new InternalTranslogFactory())  
                    WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(mockDataFormat.name());
                externalCalls.incrementAndGet();
                "processed checkpoint should reflect all indexed docs",  
    private DataFormatAwareEngine createDFAEngineWithLookupProvider(Store store, Path translogPath, DocumentLookupProvider provider)
                }  
     *   <li>Subsequent operations must reject with {@link AlreadyClosedException}.</li>  
            }  
            assertThat(stats.getMaxSeqNo(), equalTo((long) totalDocs - 1));  
            // Pre-flush docs: seqnos 0..9 — captured by the flush's refresh snapshot.  
            assertThat(delete.versionType(), equalTo(VersionType.EXTERNAL));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            .eventListener(new Engine.EventListener() {
        MapperService mapperService = mock(MapperService.class);
        try (DataFormatAwareEngine engine = createDFAEngineWithTieringState(store, createTempDir(), IndexModule.TieringState.HOT_TO_WARM)) {
                try {
    public void testAcquireReaderClosingReleasesSnapshotRef() throws IOException {  
            batch.finish();
            // The drain failure fails the engine, which closes the translog; the trailing no-op
            engine.flush(false, true);
    }
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
        final boolean engineClosedAfterwards;
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(0L));
            for (Throwable s : current.getSuppressed()) {
            engine.index(indexOp(createParsedDocWithInput("0", null)));
    }  
            engine.close();  
     *       or as suppressed exceptions;</li>
            }
            for (String file : store.directory().listAll()) {
            engine.shouldPeriodicallyFlush();
    }
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE)  
    }  
            assertTrue("the pending doc must be found via the forced append", lookup.get().exists());
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        private volatile WriterState state = WriterState.ACTIVE;  
        );  
    }
        if (remoteStore) {
                Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
            // Covers the negative path: if (operation != null) is false, falls through to refreshIfNeeded
            });
        );
                }
            @Override  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            );
        boolean remoteStore,
                org.opensearch.index.engine.exec.Segment segment = snapshot.getSegments().get(0);
                    assertThat(result.getSeqNo(), greaterThanOrEqualTo(0L));
            assertThat("the resolved GET must observe the indexed seqNo", lookup.get().seqNo(), equalTo(0L));  
        when(provider.getById(any(), any(), any(), any())).thenReturn(  
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
            // Drain the listener counters from the two seed refreshes.  
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
                (java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>>) queueField.get(engine);
    public void testConstructorFreezesWhenOpenedMidTiering() throws IOException {  
                    }  
            assertThat(result.getFailure(), instanceOf(IOException.class));
            Engine.DeleteResult result = engine.delete(deleteOpWithIfSeqNo("1", 99L, primaryTerm.get()));
        return new DataFormatAwareEngine(buildDFAEngineConfig(store, translogPath, provider));  
     * newer pending entry, a realtime GET observes the update, and after finish the translog holds both in order.  
            engine.refresh("test");  
        }
                assertThat(ref.get().getSegments().size(), equalTo(1));  
            List<Exception> engineFailures,
            fmThread.join(30_000);
        return new DataFormatAwareEngine(buildDFAEngineConfig(store, translogPath, List.of(), List.of(), state.name()));  
            assertThat(engine.config(), notNullValue());
                genBefore = ref.get().getGeneration();  
            @Override  
        // Build engine with a counting event listener to verify onFailedEngine called exactly once  
        });  
            int numThreads = randomIntBetween(3, 6);
        doReturn(1024L).when(deleteEngine).ramBytesUsed();
        }
    public void testPersistedCheckpointLagsProcessedBeforeSync() throws IOException {
            assertTrue("an insert must not supersede anything", deleteEngine.deletedIds().isEmpty());
     * surfaced via {@link MockIndexingExecutionEngine#setTragicException} instead.  
            fmThread.start();  
    }
     * snapshot.
            .withDeleteExecutionEngine(committer -> deleteEngine);
            seqNo,  
            engine.ensureOpen(); // Engine still alive
        when(documentMapper.getVersion()).thenReturn(1L);
        MockDeleteExecutionEngine deleteEngine = spy(new MockDeleteExecutionEngine(mockDataFormat));
            SequenceNumbers.UNASSIGNED_SEQ_NO,
    public void testDoubleFailEngineIsIdempotent() throws IOException {
        AtomicLong afterDidRefreshTrue = new AtomicLong(0);  
            assertTrue("a skipped replay reports found because currentlyDeleted is false", replay.isFound());
            }
    }
            CyclicBarrier barrier = new CyclicBarrier(numThreads + 1); // +1 for refresh thread
        ReferenceManager.RefreshListener injector = new ReferenceManager.RefreshListener() {
            assertNotNull("a drain failure while retiring must fail the engine", failure);
            } catch (Exception ignored) {}
                assertThat(result.getSeqNo(), equalTo((long) i));  
    // --- Test: index → refresh → failEngine → verify no data loss for committed data ---
import org.opensearch.common.Nullable;
     * map branch. Resolving through {@code DocumentLookupSupport#getById} is what applies them;
import java.io.IOException;  
import org.apache.lucene.index.Term;
            translogPath,
     * remember it so the next refresh reopens readers even without a new segment.
            // Now inject refresh failure — next refresh will fail the engine
     * the processed checkpoint. The commit therefore records a checkpoint that is AHEAD of what  
                            throw new IllegalStateException("flush gate was never released");  
            AlreadyClosedException flushEx = expectThrows(AlreadyClosedException.class, () -> engine.flush(false, true));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            primaryTerm.get(),
                        }
            new DocumentLookupResult("1", 2L, true, null, 7L, 1L, Map.of(), Map.of())  
    @SuppressForbidden(reason = "test needs reflective access to the engine's flushQueue")
        writer.setWriteResultSupplier(() -> {  
        );  
                assertThat(op2.seqNo(), equalTo(1L));  
            Engine.Get getWithBadTranslog = realtimeGet("1");  
                "a rejected update must not supersede the copy that is still live, superseded=" + deleteEngine.deletedIds(),
                });
                vv = engine.resolveDocVersion(op, true);
                "custom-routing",
        }  
            assertTrue(versionMap.getAllCurrent().isEmpty());  
            "",
            .mergePolicy(NoMergePolicy.INSTANCE)  
        ParsedDocument base = EngineTestCase.createParsedDoc(id, routing);
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
                if (armed.get() && fired.compareAndSet(false, true)) {
            // Inject CorruptIndexException on commit  
            for (int i = 0; i < 20; i++) {  
            );  
import org.opensearch.index.seqno.SequenceNumbers;  
            assertThat(delete.origin(), equalTo(Engine.Operation.Origin.PRIMARY));
        private final long writerGeneration;
            translogPath,  
                );  
            // Verify subsequent ops throw AlreadyClosedException
        }  
                assertThat("every result gets a location after flush", result.getTranslogLocation(), notNullValue());  
    /** Primary delete op for {@code id} with default INTERNAL/MATCH_ANY semantics (mirrors {@link #indexOp}). */
        Path translogPath = createTempDir();
            base.routing(),
                externalCalls.incrementAndGet();  
            commitData.put(Engine.HISTORY_UUID_KEY, UUID.randomUUID().toString());
            for (long s = 0; s < totalOps; s++) {  
            final Set<Long> assignedSeqNos = allResults.stream().map(Engine.Result::getSeqNo).collect(Collectors.toSet());
        return new Engine.Delete(
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                // No refresh has happened, so the format reader may be null  
            // Inject refresh failure via MockIndexingExecutionEngine
        DataFormatRegistry registry = createMockRegistry();  
                perWorkerResults.add(new ArrayList<>());
        final Engine.EventListener listener = new Engine.EventListener() {  
            assertThat("cross-thread realtime GET must not fail", failure.get(), nullValue());
    }
                new DocumentLookupResult("x", 1L, true, null, 2L, 1L, Map.of(), Map.of()),
        AtomicInteger internalCalls = new AtomicInteger(0);
                assertThat(
            notifySettingsChanged(engine);
            }
            assertThat(deleteEngine.deletedIds(), equalTo(List.of("1")));
            );
                assertNotNull("version map must hold an entry after delete", vv);
            assertEquals(Engine.Result.Type.SUCCESS, engine.index(indexOp(createParsedDocWithInput("hot", null))).getResultType());
            assertFalse("idle engine has no pending merges", engine.hasPendingMerges());  
                secondPending.getTranslogLocation().compareTo(first.getTranslogLocation()),
            // Refresh thread: a refresh from an unrelated caller drains the batch inside its critical section.
        return new Engine.Index(
                        }
 * sequence number management, translog integration, refresh/flush lifecycle,
            translogPath,  
            // Index → AlreadyClosedException with original cause
                .setIfPrimaryTerm(1L);
            engine.index(indexOp(createParsedDocWithInput("1", null)));
        String tieringState
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        }
                            assertThat(result.getSeqNo(), greaterThanOrEqualTo(0L));
    }  
     *   <li>Resolving the pending read for "1" must append the whole chunk, so BOTH "1" and "2" receive locations
    }
    }
            .mapperService(mapperService)
                        result.getFailure().getMessage(),
            // Phase 2 -- concurrent refresh fences every live scope, forcing all pending appends.
                assertThat(snapshot.getGeneration(), equalTo((long) numBatches + 1));
            return delegate.getCommitStats();  
    }
            // Single settings-mutating thread toggles the tiering state and notifies, racing the freezers.
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(3L));  
                Translog.Operation op2 = snapshot.next();
        }  
    }
            // Second half: the refresh thread hits a writer whose flush throws.
        TranslogConfig translogConfig = new TranslogConfig(
            // Update: supersedes the copy written above.  
            );
            .translogConfig(translogConfig)
        try {  
        @Override
        DocumentLookupProvider documentLookupProvider,  
            .withDeleteExecutionEngine(committer -> deleteEngine);  
            FailableDataFormatAwareEngine failable = new FailableDataFormatAwareEngine(engine);
    /**
            }
            assertFalse("Refresh thread should have stopped", refreshThread.isAlive());
            );
            base.id(),  
            .mapperService(mapperService)
            assertTrue("store should be marked corrupted", store.isMarkedCorrupted());  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            MockDeleteExecutionEngine deleteEngine = getMockDeleteEngine(engine);  
        final AtomicReference<FailingBatchAppendTranslog.ArmedFailure> armedFailure = new AtomicReference<>();  
        engine.index(indexOp(createParsedDoc("1", null)));
        return buildEngineConfigForPluginAndListener(translogPath, plugin, listener);
            final RuntimeException ownerFailure = expectThrows(RuntimeException.class, batch::finish);
            engine.close();
        FailingBatchAppendTranslog.FailureClass failureClass
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(mockDataFormat.name());
        DataFormatAwareEngine engine = fer.engine();
            BigArrays.NON_RECYCLING_INSTANCE,
                () -> engine.index(indexOp(createParsedDocWithInput("0", null)))
     */
    }  
        }
                5L,  
            VersionType.INTERNAL,
            assertThat(
            } finally {
            Settings newSettings = Settings.builder()
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
                -1,  
        final List<String> engineFailureReasons = new CopyOnWriteArrayList<>();
        FailingFlushIndexingExecutionEngine(MockDataFormat dataFormat) {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            delegate.close();
            assertThat(batch.flush(), equalTo(expectedMax));
            false,
    /** Backwards-compatible alias for tests that explicitly call {@code createParsedDocWithInput}. */
    }  
                t.join();
    public void testSegmentsStatsFastPathWithoutFileSizesCopiesCachedStats() throws Exception {  
            .primaryTermSupplier(primaryTerm::get)  
        public boolean isSchemaMutable() {
                        for (int d = 0; d < docsPerThread; d++) {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
     * <p>This test uses a {@link FailingFlushIndexingExecutionEngine} that returns  
            final CountDownLatch indexedLatch = new CountDownLatch(numWorkers);  
            // All seqNos 0-5 contiguous → checkpoint = 5
     * A writer that accepts documents but always throws an {@link IOException} when its
            // Insert establishes the copy that the update below would supersede.
                "engine should not have failed for non-corruption IO error",
            false
            int deletesAfterFirstReplay = deleteEngine.deletedIds().size();
                engineFailureReasons.add(reason);  
                IndexReaderProvider.Reader reader = readerRef.get();  
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {  
                genAfter = ref.get().getGeneration();
    public void testRefreshAlreadyClosedWithTragicSourceFailsEngine() throws IOException {  
        return out;
    public void testRefreshListenerNotifiedWithDidRefreshFalseWhenNoNewData() throws IOException {
            // Initial snapshot: generation 1 (bumpGeneration in constructor), no segments
            .translogConfig(translogConfig)  
            notifySettingsChanged(engine);  
            }
            for (int i = 0; i < 10; i++) {
        FailableDataFormatAwareEngine(DataFormatAwareEngine engine) {
        public long generation() {  
                    try {  
        AtomicInteger afterDidRefreshTrue = new AtomicInteger(0);  
        );  
    @SuppressForbidden(reason = "test needs reflective access to mark versionMap as unsafe")
            Thread[] threads = new Thread[numThreads];  
            .indexSettings(indexSettings)
        }
            // Converge to HOT_TO_WARM: engine must freeze cleanly and block writes.
    private Engine.Delete deleteOpFromTranslog(String id, long seqNo) {
        boolean remoteStore
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    private Engine.Index indexOp(ParsedDocument doc) {
import static org.mockito.Mockito.doReturn;
            for (int i = 0; i < numDocs; i++) {
            // Flush — maybeFailEngine detects corruption and fails the engine  
    }  
     * Retires the writer from inside {@code addDoc} and rejects the write, so the failure path enters
    /**
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            return 0;
    // ═══════════════════════════════════════════════════════════════
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
    }  
            dir,  
            .eventListener(listener)
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    }  
                    ref.get().getGeneration(),  
        }  
            for (int i = 0; i < numDocs; i++) {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
    }
            System.nanoTime(),  
            AlreadyClosedException ex = expectThrows(
            CyclicBarrier barrier = new CyclicBarrier(numSyncThreads);  
            // writeIndexingBuffer should work after concurrent indexing
            .dataFormatRegistry(createMockRegistry())  
            // writeIndexingBuffer delegates to refresh  
        }
        }  
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            engine.refresh("first");  
            Thread[] threads = new Thread[numThreads];  
                assertThat(wfs.writerGeneration(), equalTo(segment.generation()));  
    private EngineConfig buildDFAEngineConfig(  
                        }  
            .translogConfig(translogConfig)
    }  
    }
        MockDeleteExecutionEngine deleteEngine = spy(new MockDeleteExecutionEngine(mockDataFormat));
        return new Engine.Index(
     * Covers getById paths: delete check, version conflict, seqNo/primaryTerm conflict.  
            .primaryTermSupplier(primaryTerm::get)
            .build();  
            VersionValue vv;
            for (int i = 0; i < numDocs; i++) {  
            engine.refresh("test");
                assertThat("every acknowledged op must be replayable from the translog", replayedSeqNos, equalTo(expectedSeqNos));  
            try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, totalDocs - 1, false, true)) {
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        } finally {
        assertThat(
    /**
            engine.flush(false, true);
        when(provider.getVersionMetadata(any(), any(), any(), any())).thenReturn(DocumentLookupResult.notFound("x"));
        return createBatchDFAEngine(store, translogPath, provider, enabled, remoteStore, null);
                VersionType.EXTERNAL,  
                    }
            assertThat(finalMax, equalTo(second.getTranslogLocation()));
        );
                            synchronized (perWorkerResults) {
            SegmentsStats stats = engine.segmentsStats(true, false);  
            assertThat(stats.getLocalCheckpoint(), equalTo((long) numDocs - 1));  
        store = createStore();  
    public void testEngineRecoveryAfterFailurePreservesCommittedData() throws Exception {
    }
                assertThat("dropped generation must be filtered out of the committed catalog", ref.get().getSegments().size(), equalTo(0));  
            // Transition to HOT_TO_WARM and notify — engine freezes.  
import static org.mockito.Mockito.when;  
                }  
            } catch (Exception e) {  
            // Close the engine while operations are in-flight
            // Verify all 10 docs committed via checkpoint  
     * op at a higher seqNo. The recovery op processes its own seqNo but leaves a gap below
     */
        final Deque<Throwable> work = new ArrayDeque<>();
            FailableDataFormatAwareEngine failable = new FailableDataFormatAwareEngine(engine);
            }
        boolean enabled,
            IOException originalCause = new IOException("original cause");
        public void close() throws IOException {
            Engine.IndexResult newResult = engine2.index(indexOp(createParsedDoc("new-after-recovery", null)));
                threads[t] = new Thread(() -> {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));  
     * Setting off: {@link Engine#beginTranslogBatch()} returns the no-op batch and every op is appended inline exactly
            );
            writer.setFailureKeepsActive(true);
            assertThat(max, equalTo(expectedMax));
            // Index 5 docs, refresh, flush to establish baseline
        }  
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("20", null))));
                failedEngineCause.set(failure);
    public void testFlushCorruptionExceptionFailsEngineViaMaybeFailEngine() throws IOException {  
                            engine.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));
            .flushMergesAfter(TimeValue.timeValueMinutes(5))  
            }
    public void setUp() throws Exception {
            final CountDownLatch started = new CountDownLatch(3);
            java.util.Collection<?> pendingClosers = (java.util.Collection<?>) closersField.get(engine);
    }  
            engine.close();
        }  
            assertThat(engine.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                assertThat(op1.seqNo(), equalTo(0L));
                assertThat("inline op must carry its location immediately", result.getTranslogLocation(), notNullValue());  
            // Index doc on primary → corruption escalates via maybeFailEngine → failEngine.  
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
     * {@code LOCAL_CHECKPOINT} must NOT exceed the highest seqno durably persisted in the  
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
    public void testFlushAndClose() throws IOException {
            }
            assertThat(first.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
            }  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
            }
                assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) i));
    @SuppressForbidden(reason = "test needs reflective access to the engine's unpublishedDeletes flag")
    public void testGetByIdFromSegmentsAcceptsCurrentVersion() throws IOException {
            try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, numDocs - 1, false, true)) {
     * flushed, catalog snapshot held, store ref taken, {@code refreshLock} and {@code readLock} held); the drained append
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
        }  
     */
            CyclicBarrier barrier = new CyclicBarrier(numThreads);  
            }  
            .tombstoneDocSupplier(tombstoneDocSupplier())
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
                    "new reader should have a higher generation",  
    @SuppressForbidden(reason = "test needs reflective access to the engine's versionMap field")
        }
                started.countDown();  
    }
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
            assertTrue("corruption marker file should exist on disk", foundCorruptionMarker);
                equalTo(SequenceNumbers.NO_OPS_PERFORMED)
        }  
            }
            // Refresh and flush work
        engine.failEngine("first failure", new RuntimeException("first"));  
     *   <li><b>Replayability:</b> every acknowledged op is present in the translog changes snapshot for [0, totalOps-1],
    }
            }
            })
            doc,  
            @Override
     */
    ) {  
                assertThat(wfs.writerGeneration(), equalTo(segment.generation()));
                7L,
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        } finally {  
     * single thread toggles the tiering state setting (HOT_TO_WARM ⇄ HOT) and drives  
            assertThat(delete.id(), equalTo("42"));
            engine.flush(false, true);  
            // Flush should throw FlushFailedEngineException  
    }  
     */
                primaryTerm.get(),
        MockIndexingExecutionEngine indexingEngine = new MockIndexingExecutionEngine(df);  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {  
            .withIndexingEngine(settings -> indexingEngine)
                engineFailureReasons
    private static int flushQueueSize(DataFormatAwareEngine engine) throws Exception {  
        return new Engine.Get(true, true, id, new Term(IdFieldMapper.NAME, Uid.encodeId(id)));
            final Translog.Location finalMax = batch.finish();  
            // Then do concurrent refresh + flush  
            for (int i = 0; i < numDocs; i++) {  
                flushGate.countDown();
        bootstrapStoreWithMetadata(store, uuid);  
                engine.refresh("batch-" + i);
    public void testNonWaitingFlushReturnsImmediatelyIfOngoing() throws Exception {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testConcurrentIndexAndRefresh() throws Exception {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            assertEquals(1, versionMap.getAllCurrent().size());
     */  
            // which marks the store corrupted before notifying listeners.
            // No further operations possible
     * Covers getVersionFromMap unsafe path: versionMap.isUnsafe() triggers refresh + enforceSafeAccess.
                new DocumentLookupResult("d", 1L, true, null, 3L, 1L, Map.of(), Map.of())  
            Versions.MATCH_ANY,
        Path translogPath = createTempDir();
    /**
                assertThat("op must have an assigned seqNo", result.getSeqNo(), equalTo((long) i));
        FailureInjectingCommitter committer = fer.committer();
            try {  
                        Thread.currentThread().interrupt();
        }
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(listener), List.of());  
            java.lang.reflect.Field queueField = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
            }
            ref.close();
    private DataFormatAwareEngine createDFAEngine(Store store, Path translogPath) throws IOException {
    }
            FlushFailedEngineException thrown = expectThrows(FlushFailedEngineException.class, () -> engine.flush(false, true));
    /** {@link DataFormatAwareEngine#prepareDelete} builds an Engine.Delete carrying the id, uid, and CAS terms. */
    private Engine.Index appendOnlyOp(ParsedDocument doc) {  
            }
        TranslogConfig translogConfig = new TranslogConfig(
     * open and pending, so the main thread can drive publication deterministically with latches -- no sleeps, no
                beforeCount.incrementAndGet();
        }
            DocumentLookupResult result = getByIdLookup(engine, get);  
        }
            // Verify all subsequent ops throw AlreadyClosedException
                throw new AssertionError("Failure while performing flush/refresh: " + failureCause.get());
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
                assertThat(reader.catalogSnapshot(), notNullValue());
                engine.close();  
                    + ") must not exceed the max seqno durably persisted in the snapshot ("
        }  
    public void testDeleteEngineFailureResultRecordsNoOpAndLeavesEngineOpen() throws Exception {
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        }
        AtomicInteger onFailedCount = new AtomicInteger(0);
            engine.ensureOpen();
 *
                System.nanoTime(),
 * The OpenSearch Contributors require contributions made to  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            Settings.builder()
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            assertFalse("store should NOT be corrupted", store.isMarkedCorrupted());
                        throw new RuntimeException(e);  
            int totalDocs = numThreads * docsPerThread;
            MockDeleteExecutionEngine deleteEngine = getMockDeleteEngine(engine);
                    try {  
                Translog.Operation op;
            indexSettings,
            return new DrainFailureOutcome(thrown, engineFailureReasons, engineFailures, ownerFailure, closed);
    }  
            assertThat("writer injected into flushQueue", flushQueueSize(engine), equalTo(1));  
            mockExecEngine.setRefreshFailure(() -> new IOException("injected writer failure"));
import org.apache.lucene.store.AlreadyClosedException;  
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numBatches - 1));
        try {  
            engine.index(indexOp(createParsedDoc("1", null)));  
            // Spawn 5 threads each calling failEngine with different reasons
        public void markStoreCorrupted(IOException cause) {
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
            );
        SuccessFlushWriter(long writerGeneration, org.opensearch.index.engine.dataformat.DataFormat dataFormat) {
                        startGate.await(10, TimeUnit.SECONDS);  
            assertTrue(started.await(5, TimeUnit.SECONDS));
import org.opensearch.index.mapper.DocumentMapper;
            @Override
            }  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
        deleteEngine.setDeletesAppliedOnCheckout(true);  
                false,
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
        private volatile WriterState state = WriterState.ACTIVE;  
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo(engine.getProcessedLocalCheckpoint()));
        final Path translogPath = createTempDir();
                Engine.Operation.Origin.PRIMARY,
            expectThrows(AlreadyClosedException.class, () -> engine.flush(false, true));
        Map<String, String> dataAfterFail = committer.getLastCommittedData();  
        work.push(t);  
    }
                .build()
                    primaryTerm.get(),
                return maxDocs;  
        public org.opensearch.index.engine.dataformat.WriteResult addDoc(MockDocumentInput d) {
            }
            // Disarm so the owner's finish() and the probe below exercise the engine, not the injection.  
            }
            assertThat(engine.getHistoryUUID(), notNullValue());  
            // beforeRefresh is always called (listener needs to prepare)
        Throwable current = t;
            assertThat("snapshot durably persisted only the pre-flush docs [0..9]", persistedRows, equalTo(10L));
            -1,
        );
        AtomicInteger afterCalls = new AtomicInteger();
            );
            engine.refresh("empty");  
    }  
import org.opensearch.index.engine.dataformat.stub.MockIndexingExecutionEngine;
            .put(IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING.getKey(), enabled);  
                } else {  
            .build();  
            .primaryTermSupplier(primaryTerm::get)
        engine.close();
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        );
                equalTo(0)
            CountDownLatch indexingDone = new CountDownLatch(numIndexThreads);  
            .committerFactory(c -> committer)  
                assertThat(snapshot.getGeneration(), equalTo(2L));
    }  
            assertThat("internal listener must receive both before and after", internalCalls.get(), equalTo(2));
        shardId = new ShardId(new Index("test", "_na_"), 0);
                );
                        failures.incrementAndGet();
            for (int i = 0; i < numDocs; i++) {
            // Flush fails but engine stays open (non-corruption)  
            false
            translogPath,
            expectThrows(IllegalStateException.class, () -> engine.index(indexOp(createParsedDocWithInput("0", null))));
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
                        setTieringStateSetting(engine, IndexModule.TieringState.HOT);  
            for (int i = 0; i < numDocs; i++) {  
            for (Engine.IndexResult result : results) {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                }
        // Store should be marked as corrupted
     *  DFA engines ignore the searcher factory, so a no-op factory is supplied. */  
    }
                translogOpsBefore + 4,
        engine.close();
import org.opensearch.threadpool.ThreadPool;  
            // --- Path 7: translog readOperation returns null (bogus location) ---  
    private Engine.Index indexOpWithVersion(ParsedDocument doc, long version, VersionType versionType) {  
            // falls back to provider which returns version=5. MATCH_ANY accepts.  
            DocumentLookupResult deleteResult = getByIdLookup(engine, getForDelete);  
     * acknowledged docs are silently lost.  
            engine.index(indexOp(createParsedDoc("1", null)));
            final AtomicBoolean stop = new AtomicBoolean(false);  
                assertThat(snapshot.getGeneration(), greaterThanOrEqualTo(0L));
            for (int t = 0; t < numThreads; t++) {  
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), tieringState);
            engine.refresh("first");
        engine.close();
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {  
     * A writer that succeeds on flush, returning empty FileInfos. Used to test the  
            DocumentLookupResult result = getByIdLookup(engine, get);  
                failedEngineCause.set(failure);
     * notifications. A reader manager uses these to know which snapshot generation  
                    } catch (Exception e) {  
        throws IOException {  
            // Phase 3: Flush — persists catalog snapshot  
            @Override  
    public void testRefreshUpdatesLastRefreshedCheckpoint() throws IOException {
                        failureCause.set(e);
                    allResults.addAll(perWorker);
                    foundCorruptionMarker = true;
    public void testGetByIdDeleteAndConflictPaths() throws Exception {
            // localCheckpoint stays at 2 (the largest contiguous prefix). Gap: seqNos 3..6.
            long persistedBefore = engine.getPersistedLocalCheckpoint();
            assertThat(failure, instanceOf(IllegalStateException.class));
            Engine.Get current = new Engine.Get(true, true, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))).setIfSeqNo(7L)
    }
            try {
            assertEquals("lcp blocked by gap at 3..6", 2L, engine.getProcessedLocalCheckpoint());
    /**  
            final long persistedMaxSeqNo = persistedRows - 1; // contiguous 0..9 -> max seqno 9  
            // Index a doc so versionMap has an IndexVersionValue
    }  
                afterCount.incrementAndGet();
    public void testFrozenEngineSkipsNonForceFlush() throws IOException {  
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                long catalogDocs = ref.get().getNumDocs();
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
                            }
        }
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            }
            }  
            List.of(
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
            synchronized (callOrder) {
        return (MockDeleteExecutionEngine) field.get(engine);
            }
     * Replayed (from-translog) delete op with a pre-assigned seqNo. Non-primary origins must carry a
            );
        );
        public long mappingVersion() {  
            int totalDocs = randomIntBetween(50, 100);
            assertTrue("doc should be found from parquet", result.exists());
            // Insert: there is no previous copy to supersede.
            CyclicBarrier barrier = new CyclicBarrier(numThreads);
            assertThat(historyCount, greaterThanOrEqualTo(0));  
            int numDocs = randomIntBetween(3, 10);
import org.opensearch.index.engine.dataformat.stub.MockWriter;  
import org.opensearch.index.engine.exec.commit.CommitterFactory;
        DataFormatAwareEngine engine = fer.engine();
        }
        Path translogPath = createTempDir();  
        try {  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                    }
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
            assertThat("replayed delete keeps its assigned seqNo", result.getSeqNo(), equalTo(seqNo));
            Engine.Get current = new Engine.Get(true, true, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))).version(2L);
            .internalRefreshListener(List.of())
    /** As {@link #buildFailingEngineConfig(MockDataFormatPlugin, Engine.EventListener)} without callback assertions. */
                Translog.Operation op1 = snapshot.next();
        MockDataFormatPlugin failingPlugin = MockDataFormatPlugin.of(mockDataFormat).withIndexingEngine(settings -> failingEngine);
    private static final class FailingFlushWriter implements org.opensearch.index.engine.dataformat.Writer<MockDocumentInput> {  
        return new DataFormatAwareEngine(
     * document is processed <b>during</b> the flush (after the snapshot is frozen but before the
                    assertThat(wfs.files().size(), equalTo(1));
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
            try (Translog.Snapshot snapshot = ((InternalTranslogManager) engine.translogManager()).getTranslog().newSnapshot()) {  
            // --- Path 2: version conflict for reads ---  
            );  
        when(documentMapper.getVersion()).thenReturn(1L);
            .build();
        // The stored document is at seqNo 7 / term 1.
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
                }
import java.util.ArrayDeque;
            } catch (Exception e) {
            writer.setLiveCommitData(commitData.entrySet());  
        DocumentLookupProvider provider = mockLookupProvider();
            -1,
        assertTrue(TransportActions.isShardNotAvailableException(closed));  
        MapperService mapperService = mock(MapperService.class);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
import org.opensearch.test.DummyShardLock;
     * by the write thread during preIndex, producing a pending segment.
            java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");
    public void testGetSeqNoStats() throws IOException {  
import java.util.HashMap;
        }
        @Override
        ReferenceManager.RefreshListener internal = new ReferenceManager.RefreshListener() {  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
    }  
            engine.close();
    /**
            indexSettings,  
                        engine.flush(false, true);
        }  
            // Inject a writer directly into the flushQueue (simulates a writer that was
            LiveVersionMap versionMap = (LiveVersionMap) vmField.get(engine);  
                engine.getProcessedLocalCheckpoint(),
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), mockLookupProvider())) {
            // Close the engine — closeNoLock must drain flushQueue and close the writer.
        );  
    }
        engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
            assertThat(replay.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
            Thread indexThread = new Thread(() -> {
    private void bootstrapStoreWithMetadata(Store store, String translogUUID) throws IOException {  
            engine.flush(false, true);  
     * {@code maybeFailEngine("delete", e)} and is rethrown. A plain I/O failure is not a corruption,
            Thread[] threads = new Thread[numThreads];
                        }
     * Test helper that wraps a {@link DataFormatAwareEngine} to expose its private failure  
            .tombstoneDocSupplier(tombstoneDocSupplier())  
                assertTrue(wfs.files().iterator().next().endsWith(".parquet"));
                new Term(IdFieldMapper.NAME, Uid.encodeId(far.id())),
            );  
                threads[t].start();  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                (java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>>) queueField.get(engine);
            int numDocs = between(maxDocs + 1, maxDocs * 2);
            assertTrue("self-read of a pending doc must find it", getResult.exists());  
            .dataFormatRegistry(createMockRegistry())
                threads[t].start();
import org.opensearch.index.engine.exec.commit.Committer;
    public void testRefreshProducesCatalogSnapshot() throws IOException {  
        MockDataFormatPlugin limitedPlugin = MockDataFormatPlugin.of(mockDataFormat).withIndexingEngine(settings -> limitedEngine);  
                }, "batch-worker-" + w);
    }
    private DataFormatAwareEngine createUpdateEnabledDFAEngine(Store store, Path translogPath) throws IOException {
                final int threadId = t;  
import org.opensearch.index.engine.dataformat.NoOpDeleteExecutionEngine;
            }  
                @Override
    private DrainFailureOutcome driveRefreshDrainOfFailedBatchAppend(
                engine.translogManager().getTranslogStats().estimatedNumberOfOperations()
            assertTrue(  
            engine.refresh("setup");  
            .threadPool(threadPool)  
            java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");  
        EngineConfig config = buildDFAEngineConfig(store, translogPath, provider);  
    public void testSegmentsStatsWithIOException() throws IOException {  
                });
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                    far,  
    private static final class SuccessFlushWriter implements org.opensearch.index.engine.dataformat.Writer<MockDocumentInput> {  
            engine.close();
                    try (GatedCloseable<CatalogSnapshot> ref = eng.acquireSnapshot()) {
        };  
            }
    private MockIndexingExecutionEngine getMockExecutionEngine(DataFormatAwareEngine engine) {
        // bootstrap state; we verify the engine is operational after recovery)
            }
        } finally {
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            Engine.IndexResult nextChunk = engine.index(indexOp(createParsedDocWithInput("next", null)));
    }  
                () -> engine.index(indexOp(createParsedDocWithInput("0", null)))
            AtomicInteger failures = new AtomicInteger(0);
                work.push(s);
    }
        // Fires at the END of refresh() — after the catalog snapshot has been built, but
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            IndexSettings indexSettings = engine.config().getIndexSettings();  
                new DocumentLookupResult("c", 1L, true, null, 2L, 1L, Map.of(), Map.of()),
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {  
        engine.failEngine("test failure", new RuntimeException("simulated"));  
    }
        DocumentLookupProvider provider = mockLookupProvider();  
            .tombstoneDocSupplier(tombstoneDocSupplier())
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            failingCommitter.setCommitFailure(null);
    public void testAcceptsDefaultPrimaryOperationPolicy() throws IOException {  
        }
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            for (int t = 0; t < numThreads; t++) {
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDocWithInput("2", null))));  
        }  
            engine.index(indexOp(createParsedDoc("2", null)));
    /** Updates the engine's live index settings to the given tiering state (without invoking onSettingsChanged). */  
        );  
        }  
     * regression without sleeps:
            .internalRefreshListener(List.of())  
     * snapshot is committed (so listeners can prepare), and afterRefresh is called
    }  
                assertThat(
        );
            // Flush → AlreadyClosedException with original cause  
        }  
                () -> engine.index(indexOp(createParsedDoc("post-fail", null)))
            new Term(IdFieldMapper.NAME, Uid.encodeId(id)),
                    failures.incrementAndGet();
                    }
            Engine.DeleteResult result = engine.delete(deleteOp("missing"));
                    assertTrue("file should be a parquet file: " + fileName, fileName.endsWith(".parquet"));
            for (int i = 0; i < numBatches; i++) {
/**
            CyclicBarrier barrier = new CyclicBarrier(4);
     * the chunk before the delete so the translog order is index then delete; a realtime GET then misses, and finish
    }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
            int numDocs = randomIntBetween(1, 5);
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));  
        Path translogPath = createTempDir();
        try {
            java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");
            .mapperService(mapperService)
            mockExecEngine.setTragicException(tragicCause);
                assertThat(reader, notNullValue());
            // forceMerge runs synchronously on a FORCE_MERGE thread. Dispatch to a  
            return engine;  
            assertThat(failures.get(), equalTo(0));
                    assertNull(result.getFailure());
        MapperService mapperService = mock(MapperService.class);
            }
     */
        }  
            // The failing writer is still in the queue (never polled).
        } finally {
                beforeCalls.get() - beforeAfterSeed,
        FailureInjectingCommitter failingCommitter = fer.committer();
    }
    public void testGetSeqNoStatsAfterConcurrentIndexingAndRefresh() throws Exception {
                assertThat(snapshot.getSegments().size(), equalTo(0));  
     * distinguish between "new data available" and "nothing changed".  
        when(provider.getById(any(), any(), any(), any())).thenReturn(DocumentLookupResult.notFound(""));
    private EngineConfig buildDFAEngineConfig(  
        );  
                });  
        assertThat(
            Settings.builder()
        FailureInjectingCommitter failingCommitter = fer.committer();
    }
     * <p>We inject the in-window document via an {@code afterRefresh} listener (it fires
                assertTrue("version map entry must be a delete tombstone", vv.isDelete());
                    try {
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(listener), List.of());
                .setIfPrimaryTerm(1L);  
import org.apache.lucene.search.ReferenceManager;
            new Term(IdFieldMapper.NAME, Uid.encodeId(id)),
    }
     * <p>This strengthens the basic cross-thread case so it would catch a pending-entry publication/order
        String indent = "";
            assertTrue(deleteEngine.checkedOutGenerations().contains(42L));
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> engine.delete(deleteOp("1")));
    /**
            }
            expectThrows(RefreshFailedEngineException.class, () -> engine.refresh("partial-cycle-flush-failure"));
    public void testFailEngineWithNonCorruptionDoesNotMarkStoreCorrupted() throws IOException {
            assertThat("op 1 location must be deferred before the cross-thread GET", first.getTranslogLocation(), nullValue());  
     * of recovery.
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);  
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
            }
            assertThat(failedEngineCause.get().getMessage(), containsString("simulated flush failure"));  
            }  
                engine.flush(false, true);
        }  
            long fromSeqNo = 3;
            int numDocs = randomIntBetween(3, 10);
            }
            assertThat(indexed.getTranslogLocation(), notNullValue());
                versionMap.putIndexUnderLock(uid, new IndexVersionValue(null, 5L, 0L, 1L));  
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), greaterThanOrEqualTo(0));
    /**
            engine.index(indexOp(createParsedDocWithInput("2", null)));
    /**  
        }
        final AtomicBoolean armed = new AtomicBoolean(false);
    public void testBatchedAppendCrossThreadRealtimeGetForcesFlush() throws Exception {
            engine.index(indexOp(createParsedDocWithInput("1", null)));
                assertNull(engine.resolveDocVersion(op, true));
            @Override
            CyclicBarrier barrier = new CyclicBarrier(freezers + 1);
            engine.ensureOpen();  
     * calling {@code lookupFromReader} directly dropped a stale {@code if_seq_no} silently.  
            assertThat(ex.getCause().getMessage(), containsString("simulated flush failure"));  
                    barrier.await();  
            Engine.Delete delete = engine.prepareDelete(  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            ParsedDocument far = createParsedDocWithInput("7", null);
            CyclicBarrier barrier = new CyclicBarrier(3);  
            assertTrue("a drain that applied deletes must leave them marked unpublished", unpublishedDeletesOf(engine));
            // complete without blocking, and the catalog generation must have advanced.
                    failure.set(e);
                        error.compareAndSet(null, e);  
            engine.index(indexOp(createParsedDocWithInput("0", null)));  
            try {  
    /**
            refreshThread.start();
                assertThat(wfs.files().size(), equalTo(1));
            assertThat(deleteResult.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        queueField.setAccessible(true);  
        TranslogConfig translogConfig = new TranslogConfig(
     * with isRetry=false makes {@link IndexingStrategyPlanner} take the optimizedAppendOnly path  
     * Returns the first MockWriter currently in the engine's writer pool via reflection.  
        }  
        // Store should NOT be marked corrupted (null failure)
            int docsPerThread = randomIntBetween(10, 20);  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    }
            assertNotNull("engine should have failed from commit corruption", failable.getFailedEngine());  
    }
        }
        // Verify closed
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {  
            assertTrue(
                MockDataFormat unknownFormat = new MockDataFormat("unknown", 999L, mockDataFormat.supportedFields());
            engine.refresh("test");  
        }
            assertThat("primary delete must be assigned a seqNo", result.getSeqNo(), greaterThanOrEqualTo(0L));  
            MockDeleteExecutionEngine deleteEngine = getMockDeleteEngine(engine);  
                engine.getPersistedLocalCheckpoint(),
            assertThat(e.getMessage(), containsString("frozen for tiering"));
        List<ReferenceManager.RefreshListener> internalListeners,
                            maxSeqNo.accumulateAndGet(result.getSeqNo(), Math::max);
            engine.flush(false, true);
        engine.index(indexOp(createParsedDocWithInput("1", null)));
            engine.translogManager().syncTranslog();
                7L,  
        );  
            assertEquals(1, segments.get(0).docCount);
        @Override  
        Settings newSettings = Settings.builder()  
    @SuppressForbidden(reason = "test needs reflective access to inject DeleteVersionValue into versionMap")  
    }  
                engine.refresh("concurrent batched publication fence");
        }
                assertThat(snapshot.getGeneration(), equalTo((long) numBatches + 1));
            assertThat(  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
     * everything the tests assert on: what the refresh threw, every engine failure the listener saw, what the batch
        Path translogPath = createTempDir();  
            }
                            Engine.IndexResult result = eng.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));  
        }
        }  
            MockIndexingExecutionEngine mockExecEngine = getMockExecutionEngine(engine);  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                    } catch (Exception e) {  
    public void testApplyMergeChangesUpdatesCatalogAndSkipsNonRemoteStoreListeners() throws Exception {
                try {
            }
            }  
            int numThreads = randomIntBetween(2, 4);  
                        break;
    public void testWriteIndexingBufferAfterConcurrentIndexing() throws Exception {  
            engine.ensureOpen();  
        java.lang.reflect.Field field = DataFormatAwareEngine.class.getDeclaredField("deleteExecutionEngine");  
    public void testFailEngineWithNullFailure() throws IOException {
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true, true, false)) {
    /** Reflectively obtains the engine's LiveVersionMap. resolveDocVersion/getVersionFromMap assert the
            assertEquals(5L, engine.getSeqNoStats(SequenceNumbers.NO_OPS_PERFORMED).getMaxSeqNo());
    public void testAcquireReaderContainsFormatSpecificReader() throws IOException {  
            // Index and refresh twice
            Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
        }
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
                        } else {  
                });
        // Verify engine is closed by checking that operations throw
        expectThrows(AlreadyClosedException.class, () -> engine.flush(false, true));
     * as before -- each result carries its location immediately and the processed checkpoint advances per op.
import org.opensearch.index.engine.dataformat.RefreshResult;  
                () -> engine.index(indexOp(createParsedDocWithInput("1", null)))
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
            CyclicBarrier barrier = new CyclicBarrier(numThreads);  
        }
            assertThat(
    /**  
                assertThat(op2.opType(), equalTo(Translog.Operation.Type.INDEX));
            org.apache.lucene.util.BytesRef uid = new Term(IdFieldMapper.NAME, Uid.encodeId("1")).bytes();
            );
                failureClass,
     * <p>When a write thread picks a writer from the flushQueue during preIndex and the
                "42",
            // Flush again — should succeed now  
                deleteEngine.checkedOutGenerations().contains(42L)
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> deleteEngine);  
        };
                    assertThat("each segment should have a WriterFileSet for the mock format", wfs, notNullValue());  
        );
            for (int i = 0; i < 5; i++) {  
        }
                Engine.IndexResult result = eng.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            LiveVersionMap versionMap = (LiveVersionMap) vmField.get(engine);
        EngineConfig config = buildFailingEngineConfig(limitedPlugin);
        mockDataFormat = new MockDataFormat("composite", 100L, Set.of());  
                Translog.Operation op;
        Boolean appendOnly
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            engine.refresh("test");  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                assertThat(wfs.numRows(), equalTo((long) numDocs));
        // Engine should be closed
            // Verify engine failed
            long genBeforeFinalRefresh;  
            flushThread.join(10_000);
        @Override  
            "engine must be failed exactly once, reasons were " + outcome.engineFailureReasons,
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            org.opensearch.index.engine.dataformat.WriterConfig config
        expectThrows(AlreadyClosedException.class, () -> engine.refresh("after-fail"));  
    public void testFreezeForTieringBlocksPrimaryIndex() throws IOException {
            // No retention locks are held before acquiring one.
            .internalRefreshListener(List.of())
                SequenceNumbers.UNASSIGNED_SEQ_NO,
     *       (null location) and the processed checkpoint must not have advanced -- catching any premature publish.</li>
        AtomicInteger beforeCount = new AtomicInteger(0);
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));  
        MockDeleteExecutionEngine deleteEngine = new MockDeleteExecutionEngine(mockDataFormat);  
            // What the commit DURABLY persisted: only seqnos 0..9 made it into the snapshot.
import org.opensearch.common.SuppressForbidden;  
            }  
                });
            assertThat(
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(  
            BigArrays.NON_RECYCLING_INSTANCE,  
            return new org.opensearch.index.engine.dataformat.WriteResult.Success(1L, 1L, 0L);  
            stop.set(true);
            assertThat(count, equalTo(numDocs));  
            "",  
            expectThrows(AlreadyClosedException.class, engine::ensureOpen);  
            Object current = currentField.get(maps);  
     * Covers the preIndex happy path: a writer in the flushQueue is successfully flushed  
                equalTo(refreshesBefore)
            );
            for (int w = 0; w < numWorkers; w++) {  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            FailingBatchAppendTranslog.factory(armedFailure),  
            int numThreads = 8;  
            empty()
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat)
            for (int i = 0; i < numRefreshes; i++) {
                        if (stop.get() == false) {
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)  
            }
            // Refresh and verify engine is operational  
            assertThat(deferred.getTranslogLocation(), nullValue());  
        @Override
            setTieringStateSetting(engine, IndexModule.TieringState.HOT_TO_WARM);
        } finally {
            writer.setWriteResultSupplier(() -> new WriteResult.Failure(new IOException("simulated addDoc failure"), -1L, -1L, -1L));  
            // has no segments, so reader managers won't have created readers
            // Index 20 docs, refresh, flush (commit point)
            notifySettingsChanged(engine);
            SuccessFlushWriter queuedWriter = new SuccessFlushWriter(42L, mockDataFormat);
            GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader();  
            .build();
                        }
    private Engine.Index indexOpWithIfSeqNo(ParsedDocument doc, long ifSeqNo, long ifPrimaryTerm) {  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            flusher.start();
                }  
        return createParsedDoc(id, routing);  
            final Engine.IndexResult secondPending = engine.index(indexOp(createParsedDocWithInput("2", null)));
            for (int i = 20; i < 30; i++) {  
        Path translogPath,
            // After closing, we should still be able to acquire new readers
        Path translogPath,  
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            Engine.IndexResult first = engine.index(indexOpWithVersion(createParsedDocWithInput("1", null), 5L, VersionType.EXTERNAL));
            this.dataFormat = dataFormat;
            }  
                    try {  
     * fails, the engine is left in a consistent state for the surrounding orchestration:
            // Index docs and flush successfully first  
    @SuppressForbidden(reason = "test needs reflective access to inject a writer into flushQueue")
                "pure-delete refresh must have taken the dropped-generation path",
        }
                DataFormatAwareEngine eng = engineRef.get();
    }
            assertThat("every op is published once the scope is finished", engine.getProcessedLocalCheckpoint(), equalTo(2L));  
     * Covers compareOpToVersionMapOnSeqNo returning OP_STALE_OR_EQUAL.
    }
            refreshThread.join(10_000);
                engine.index(appendOnlyOp(createParsedDocWithInput(Integer.toString(i), null)));  
    }  
        return current;  
    private DataFormatAwareEngine createBatchDFAEngine(Store store, Path translogPath, DocumentLookupProvider provider, boolean enabled)
            }  
            .threadPool(threadPool)  
            queueField.setAccessible(true);  
        }  
                    "reader's snapshot should match the latest generation",
            MockIndexingExecutionEngine mockExecEngine = getMockExecutionEngine(engine);  
            // After sync, persisted must equal processed  
        when(documentMapper.getVersion()).thenReturn(1L);  
    public void testPartialCycleFlushFailureIncorporatesNothing() throws Exception {
            .dataFormatRegistry(registry)  
            ifPrimaryTerm  
    }  
            .eventListener(new Engine.EventListener() {  
        FailureInjectingCommitter(Store store) throws IOException {  
            long readerGen = reader.catalogSnapshot().getGeneration();
        assertThat(
        DataFormatAwareEngine engine = createUpdateEnabledDFAEngine(store, createTempDir());  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
            assertThat(batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));  
            for (int i = 0; i < 5; i++) {
        vmField.setAccessible(true);  
            }  
                }
    /**
        } finally {
            for (int i = 0; i < numDocs; i++) {
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                IndexReaderProvider.Reader reader = readerRef.get();  
            assertNotNull("engine should have failed", failable.getFailedEngine());
        bootstrapStoreWithMetadata(store, uuid);
            // Arm the injector: during flush()'s refresh, seqnos 10,11,12 get indexed into a NEW  
                    + ".."  
            long genAfter;  
    public void testNewChangesSnapshotRespectsSeqNoRange() throws IOException {
            assertThat(delete.version(), equalTo(3L));  
            assertThat("refresh should have been triggered by unsafe versionMap", genAfter, greaterThan(genBefore));  
            assertThat(stats.getLocalCheckpoint(), equalTo((long) totalDocs - 1));
     */
            assertNull("a from-translog delete must not be re-appended to the translog", replay.getTranslogLocation());  
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));  
            expectThrows(VersionConflictEngineException.class, () -> engine.getById(stale, (source, scope) -> null));
            null,
     *   <li>Reject subsequent operations with {@link AlreadyClosedException}.</li>
            final int totalOps = numWorkers * opsPerWorker;
            engine.flush(false, true);
            int freezers = 4;
            ParsedDocument far = createParsedDocWithInput("5", null);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        };
    public void testIndexIfSeqNoConflict() throws IOException {
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
    }  
                        for (int i = 10; i <= 12; i++) {
            Engine.DeleteResult result = engine.delete(deleteOp("1"));
            expectThrows(AlreadyClosedException.class, () -> engine.refresh("post-fail"));  
            assertThat("finishing the scope appends the trailing op", third.getTranslogLocation(), notNullValue());
            int numDocs = randomIntBetween(5, 20);  
                    try {
    public void testFlushTrimsTranslog() throws IOException {
    /**  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            final Thread refresher = new Thread(() -> {
    public void testRejectsNonDefaultPrimaryOperationPolicy() throws IOException {  
        }  
            assertTrue(
                    throw new RuntimeException(ex);
            }
            Engine.IndexResult second = engine.index(indexOp(createParsedDocWithInput("upd", null)));
                }
        }
                ParsedDocument doc = createParsedDocWithInput(Integer.toString(i), null);
                "simulated corruption via maybeFailEngine",
            SequenceNumbers.UNASSIGNED_SEQ_NO,
                store.directory(),
        List<ReferenceManager.RefreshListener> externalListeners,  
            engine.forceMerge(false, 1, false, false, false, UUID.randomUUID().toString());  
        try {
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            assertThat(rootCause(ownerFailure), sameInstance(failure));
            expectThrows(AlreadyClosedException.class, () -> engine.flush(false, true));
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(
    }  
            engine2.translogManager().recoverFromTranslog(ignore -> 0, engine2.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        }
            id,
    public void testFreezeForTieringIsIdempotent() throws IOException {
        }
    public void testRefreshAdvancesSnapshotGeneration() throws IOException {
        Path translogPath = createTempDir();  
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
    private EngineConfig buildBatchDFAEngineConfig(
                        break;
    /**  
            setTieringStateSetting(engine, IndexModule.TieringState.HOT_TO_WARM);
                    greaterThan(genBeforeFinalRefresh)
        }
                "test"
            expectThrows(Exception.class, () -> engine.index(indexOp(createParsedDoc("6", null))));
                assertThat("catalog must contain all successfully indexed docs", catalogDocs, equalTo((long) successCount.get()));  
        return (MockIndexingExecutionEngine) engine.getIndexingExecutionEngine();  
    }
     * Simulates a real failover gap: index N docs as PRIMARY, then replay a recovery-origin
        }  
    }
    private ParsedDocument createParsedDocWithInput(String id, String routing) {
                "op 2 (seqNo 1) must sort after op 1 (seqNo 0) in the translog",  
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)
            // Engine should be failed and store marked corrupted
            engine.activateThrottling();
            // Now refresh after all indexing is done  
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) numDocs - 1));  
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            // Phase 4: Verify translog snapshot has all ops
     */
            }
        // A delete-only writer must flush no files, so the refresh sees hasFiles == false.  
            }
                        }
            for (Thread t : threads)
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numBatches));  
                    new Term(IdFieldMapper.NAME, Uid.encodeId(far.id())),
            engine.index(indexOp(createParsedDocWithInput("1", null)));
        Store store,
            Engine.IndexResult extraResult = engine.index(indexOp(createParsedDoc("extra", null)));
    }  
            assertFalse(
            for (int i = 0; i < 5; i++) {
     * seqNo, primaryTerm), but the base helper leaves that field null because production  
    public void testOnSettingsChangedUnfreezesOnReturnToHot() throws IOException {
            // The writer should have been moved to pendingWritersToClose.  
     * Wraps {@link EngineTestCase#createParsedDoc(String, String)} to attach a  
        bootstrapStoreWithMetadata(store, uuid);
     */
        );
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
            // Refresh rotates the map; safe access is carried over.
     * Outcome of a refresh that drained another request's batch whose append failed.
            @Override  
            assertThat(delete.getIfSeqNo(), equalTo(7L));
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("2", null))));
        deleteEngine.setDeletesAppliedOnCheckout(true);
        return ((AtomicBoolean) field.get(engine)).get();
            for (int t = 0; t < numThreads; t++) {
            public void beforeRefresh() {}
            assertThat("event listener must observe the failure", failedEngineCause.get(), notNullValue());
            // Nothing processed or persisted yet -- the batch has not been flushed.  
    }  
        TranslogConfig translogConfig = new TranslogConfig(
     */
        throw new AssertionError("No MockWriter found in writer pool");  
            mockExecEngine.setRefreshFailure(() -> new AlreadyClosedException("engine closed"));  
            Object maps = mapsField.get(versionMap);  
            try {
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
            primaryTerm.get(),  
            assertFalse("should be not found on empty catalog", result.exists());
            for (Thread t : indexThreads)  
            assertThat(result.getFailure().getMessage(), containsString("simulated addDoc failure"));
        };  
            assertEquals(1, versionMap.getAllCurrent().size());
                internalCalls.incrementAndGet();  
        EngineConfig config = buildFailingEngineConfig(plugin);
            assertThat(
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(19L));  
                        failures.incrementAndGet();
     * (no safe-access enforcement).
                primaryTerm.get(),
        try {
            .mapperService(mapperService)
            try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", fromSeqNo, toSeqNo, false, true)) {  
            .tombstoneDocSupplier(tombstoneDocSupplier())
    public void testPrepareDeleteBuildsDeleteOperation() throws IOException {
            public void beforeRefresh() {
        }
        boolean remoteStore,
            engine.freezeForTiering();
            // Count only ops in range [3, 7]
     *   <li>Count down the activeFlushLatch so the refresh thread is not stuck waiting.</li>
    public void testDeletePrimaryRemovesDocAndRecordsTombstone() throws Exception {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            final CyclicBarrier gate = new CyclicBarrier(2);
        }
            flushQueueOf(engine).add(new SuccessFlushWriter(42L, mockDataFormat));  
        f.setAccessible(true);
                expectedSeqNos.add(s);
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
        FailureInjectingCommitter failingCommitter = fer.committer();
        when(documentMapper.getVersion()).thenReturn(1L);
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);  
            assertThat(engine.currentOngoingRefreshCheckpoint(), greaterThanOrEqualTo(0L));
            for (int batch = 0; batch < numBatches; batch++) {
                primaryTerm.get()  
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> deleteEngine);
        }
            assertEquals(0L, engine.getProcessedLocalCheckpoint());
    // --- Test: refresh failure with buffered unflushed segments ---
        AtomicInteger externalCalls = new AtomicInteger(0);  
            final AtomicReference<Exception> failure = new AtomicReference<>();  
    private java.util.concurrent.ConcurrentLinkedQueue<Writer<?>> flushQueueOf(DataFormatAwareEngine engine) throws Exception {
        }
            engine.close();
        try {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            final List<List<Engine.IndexResult>> perWorkerResults = new ArrayList<>();
    }
            // Settings reflect HOT_TO_WARM but onSettingsChanged has NOT been called (the cached flag is
import static org.hamcrest.Matchers.nullValue;
        bootstrapStoreWithMetadata(store, uuid);
        } finally {
        DocumentLookupProvider provider = mockLookupProvider();  
        boolean enabled,  
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;
        Path translogPath,
import static org.hamcrest.Matchers.equalTo;
            SuccessFlushWriter successWriter = new SuccessFlushWriter(42L, mockDataFormat);  
    /** An unsupported delete does not fail the engine. */
            failingCommitter.setCommitFailure(new IOException("No space left on device"));
     */
        );
        }  
        FailureInjectingCommitter failingCommitter = fer.committer();
            int n = randomIntBetween(2, 5);
        }
            assertTrue("versionMap should be unsafe", versionMap.isUnsafe());
                }
                final int threadId = t;  
     * An update is a second index of the same id inside the batch: both are deferred, the version map carries the
            if (input.writerFiles().isEmpty() == false || input.existingSegments().isEmpty()) {
        } finally {
                    assertThat(
        @Override
            // concurrent getAndLock (indexing) and checkoutAll (refresh).  
     * transitions: optimized append-only skips the map; an explicit-id index enforces safe access
                    } catch (Exception e) {
        try {
            engine.translogManager().syncTranslog();
            assertEquals(1, queue.size());
     * a refresh from an unrelated caller drains that batch from inside its critical section (writers checked out and  
            );
            RuntimeException ownerFailure,
    }
                    }
    // --- Test: failEngine marks store as corrupted for CorruptIndexException ---
            base.version(),
            // Verify consistent terminal state
            @Override  
            }
        }  
                        break;
            for (Throwable s : current.getSuppressed()) {  
                final int threadId = t;
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(mockPlugin));
import org.opensearch.common.settings.Settings;
            System.currentTimeMillis(),
        when(provider.getVersionMetadata(any(), any(), any(), any())).thenReturn(DocumentLookupResult.notFound("x"));  
            assertTrue(getByIdLookup(engine, realtimeGet("1")).exists());  
            // Thread 2: continuous refresh
        return sb.toString();
                engine.close();  
                threads[t] = new Thread(() -> {
        }
                        // Signal "indexed" and keep the scope open+pending until the main thread drives publication.  
                );
        // Bootstrap the store's Lucene commit with matching translog UUID
        IOException failure,  
                    }
     * first {@code flush()} call. Tracks the number of writers it has created so tests  
                    assertTrue("replayed op seqNo " + op.seqNo() + " must be unique", replayedSeqNos.add(op.seqNo()));
            assertThat(
import org.opensearch.cluster.metadata.IndexMetadata;
    }  
    }  
            IllegalStateException e = expectThrows(IllegalStateException.class, () -> new DataFormatAwareEngine(config));  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            LiveVersionMap versionMap = (LiveVersionMap) vmField.get(engine);
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);  
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
    /** On the fast path with no cached file sizes, the shared cached stats are copied before delete memory is added. */
            }
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            batch.finish();
            assertThat("the two bulks must share one contiguous seqNo range", assignedSeqNos, equalTo(expectedSeqNos));  
import static org.hamcrest.Matchers.greaterThan;  
            engine.deactivateThrottling();
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            assertNotNull("engine should have failed", new FailableDataFormatAwareEngine(engine).getFailedEngine());  
    // --- Test: failEngine with null failure ---  
     * previously-refreshed segments must (1) replace the source segments in the catalog  
        } finally {  
            assertThat(stats.getVersionMapMemoryInBytes(), equalTo(1024L));
            assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());  
        Path translogPath = createTempDir();
            assertNull(
        }  
                AlreadyClosedException.class,  
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);  
                        notifySettingsChanged(engine);
                assertThat(ref.get().getSegments().size(), greaterThan(0));
            } catch (Exception e) {  
        }  
    ) throws IOException {  
    ) {  
            .externalRefreshListener(List.of())  
        }  
            setTieringStateSetting(engine, IndexModule.TieringState.HOT_TO_WARM);  
            shardId,
        when(provider.getVersionMetadata(any(), any(), any(), any())).thenReturn(DocumentLookupResult.notFound(""));
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            indexThread.start();  
import org.opensearch.index.mapper.Uid;
            outcome.engineFailures,
                // Verify via getSearchableFiles API as well
                    }
    }
                        }
    }
        expectThrows(AlreadyClosedException.class, () -> engine.segmentsStats(false, false));  
            assertThat(engine.index(indexOp(createParsedDoc("1", null))).getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());  
            assertThat(failure.getCause().getMessage(), containsString("simulated drain failure"));
        DataFormatAwareEngine engine = new DataFormatAwareEngine(config);  
                    try {
        }
            assertThat(delete.uid(), equalTo(new Term(IdFieldMapper.NAME, Uid.encodeId("42"))));
import org.opensearch.threadpool.TestThreadPool;
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
     *  per-uid keyed lock is held, so callers must wrap in {@code versionMap.acquireLock(uid)}. */
        );  
                    } catch (Exception e) {  
            for (int t = 0; t < numThreads; t++) {
            // Engine should still be open (non-corruption doesn't fail the engine)  
            Thread[] threads = new Thread[numThreads];
import org.opensearch.index.mapper.MapperService;
            for (int i = 0; i < numDocs; i++) {  
                        notifySettingsChanged(engine);
                        for (int d = 0; d < docsPerThread; d++) {
            // Explicit-id index of the same id: enforces safe access and stores the entry.
        List<ReferenceManager.RefreshListener> externalListeners,
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            assertThat(count, org.hamcrest.Matchers.lessThanOrEqualTo(5));
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
            .withDeleteExecutionEngine(committer -> deleteEngine);
            IOException failure = expectThrows(IOException.class, () -> engine.delete(deleteOp("1")));  
            assertThat("location deferred before any flush", result.getTranslogLocation(), nullValue());
            for (int i = 0; i < numDocs; i++) {
            final AtomicReference<Exception> failure = new AtomicReference<>();
     * Reads the size of {@code DataFormatAwareEngine.flushQueue} via reflection so tests
     */  
                threads[t] = new Thread(() -> {
     * to open. Each afterRefresh(true) must correspond to a new, higher-generation
            assertNotNull(vv);  
                // Flush calls refresh internally, producing 1 segment
            // The InMemoryCommitter stores the commit data. Access it via the engine's  
            }
     * Helper: creates a DFA engine with a committer that can inject failures.
            // Refresh should fail the engine  
            // Acquire reader before any refresh — the initial catalog snapshot  
    /** Calls the new getById(Engine.Get, searcherFactory) and unwraps the pre-materialized lookup.
    }
            }
        List<ReferenceManager.RefreshListener> internalListeners
            int iterations = 100;
                3L,
     * with a non-matching ifSeqNo hits the seqNo/term conflict branch (IndexingStrategyPlanner) → conflict.  
        // Second failEngine should not throw
        StringBuilder callOrder = new StringBuilder();  
            engine.close();  
                assertThat(snapshot.getId(), equalTo(1L));
        public org.opensearch.index.engine.dataformat.WriteResult addDoc(MockDocumentInput d) {
        public void deleteCommit(org.opensearch.index.engine.exec.coord.CatalogSnapshot snapshot) {
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
                                assertThat(reader.catalogSnapshot(), notNullValue());
            );  
                for (StackTraceElement frame : refresher.getStackTrace()) {  
            doc,
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
                while ((op = snapshot.next()) != null) {
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                public void onFailedEngine(String reason, Exception e) {}  
    }  
            // First half of the cycle: a write thread flushes and drains gen 42 through preIndex.
        TranslogConfig translogConfig = new TranslogConfig(  
            engine.refresh("test");
                IllegalStateException.class,  
     * Verifies that engine close (closeNoLock) drains the flushQueue and closes any
import org.opensearch.index.engine.exec.WriterFileSet;  
            .translogConfig(translogConfig)
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
            .externalRefreshListener(List.of())  
    private MockDataFormatPlugin mockPlugin;
    }
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
        FailureInjectingCommitter committer = new FailureInjectingCommitter(store);
        @Override  
            @Override  
        @Override  
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());  
            assertThat(engine.getIndexThrottleTimeInMillis(), equalTo(0L));
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();  
    }  
            public void afterRefresh(boolean didRefresh) {
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
            vmField.setAccessible(true);
            public void afterRefresh(boolean didRefresh) {
            Engine.Operation.Origin.PRIMARY,  
            assertThat("flushQueue must be empty after close", flushQueueSize(engine), equalTo(0));
            assertThat(stale.getResultType(), equalTo(Engine.Result.Type.FAILURE));
            for (int i = 0; i < numDocs; i++) {  
                )
            false
    public void testGetMaxSeqNoOfUpdatesOrDeletes() throws IOException {  
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            // Verify the catalog snapshot generation advanced monotonically  
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
    }
            for (int i = 10; i < 15; i++) {  
        }
     */  
        }
     * Bootstraps the store's Lucene index with the commit metadata that DFAE  
                    assertThat("doc " + i + " should be rejected", result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {  
            // Index same doc again — resolveDocVersion finds expired DeleteVersionValue, nullifies it,
            DocumentLookupResult result = getByIdLookup(engine, get);
        // Records call order: 'B' for beforeRefresh, 'A' for afterRefresh.
        DocumentLookupProvider provider = mockLookupProvider();
    /**
    public void testFlushAfterCloseThrows() throws IOException {
            CyclicBarrier barrier = new CyclicBarrier(numThreads);  
            .mapperService(mapperService)  
    public void testSuccessfulUpdateSupersedesPreviousCopy() throws Exception {
     *   <li><b>Concurrent refresh:</b> a refresh fences ALL live scopes ({@code flushActiveTranslogBatches}), so after  
        engine.close();  
            writer.setWriteResultSupplier(() -> new WriteResult.Failure(new IOException("simulated update rejection"), -1L, -1L, -1L));
            );  
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            assertThat("refresh failure must wrap the IOException from flush", ex.getCause(), instanceOf(IOException.class));
            engine.refresh("test");  
            }  
            engine.ensureOpen();
            IOException tragicCause = new IOException("engine tragic");
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
                try {
        );
            final Translog.Location max = batch.flush();
    public void testIsFrozenForTieringLiveSettingsFallback() throws IOException {
            // Put back an IndexVersionValue so we can test version conflict
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            assertThat("second op must have an assigned seqNo", secondPending.getSeqNo(), equalTo(1L));
            public void beforeRefresh() {
            mapsField.setAccessible(true);
            });  
                    try {  
            engine.refresh("stats");
                try {
                // Not ideal — we can't access the engine from here directly.
            return engine.getFailedEngine();
                }
        MockDataFormatPlugin plugin,
    public void testThrottling() throws IOException {
            Engine.IndexResult failedUpdate = engine.index(indexOp(createParsedDoc("1", null)));
     * The stale entry (seqNo=2) is overwritten by OP_NEWER, the duplicate (same seqNo=5) is skipped.
            engine.index(indexOp(createParsedDocWithInput("1", null)));
import java.util.Deque;
            assertFalse("a failed delete must not report found", result.isFound());  
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
                    assertThat(op.seqNo(), greaterThanOrEqualTo(0L));  
            .externalRefreshListener(externalListeners)  
            // Translog ops count should be unchanged by sync  
            engine.refresh("test");
            // Inject a FailingFlushWriter directly into the flushQueue.
        @Override
        };
    /** resolveDocVersion branch 6: versionMap hit returns the stored IndexVersionValue. */  
        @Override  
        when(documentMapper.getVersion()).thenReturn(1L);
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            for (int i = 0; i < numDocs; i++) {
                threads[t] = new Thread(() -> {  
        }
        Path translogPath,  
        bootstrapStoreWithMetadata(store, uuid, 3L);
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));  
            Closeable retentionLock = engine.acquireHistoryRetentionLock();
     *  
     * <ul>  
            .put(indexSettings.getSettings())
            assertFalse("Index thread should have stopped", indexThread.isAlive());
        MapperService mapperService = mock(MapperService.class);
     * Use case: A search-after-refresh waiter registers a listener to know when
                    afterDidRefreshFalse.incrementAndGet();
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
            int numThreads = 5;
            boolean foundCorruptionMarker = false;
        }
            }
            // Before any indexing, last refreshed checkpoint is at NO_OPS_PERFORMED
            assertThat(e.getMessage(), containsString("frozen for tiering"));
                    null,
                            injectedSeqNos.add(r.getSeqNo());  
        }  
        CommitterFactory committerFactory = config -> new InMemoryCommitter(store);  
        field.setAccessible(true);
            engine.flush(true, true);
        );
            }  
    /**
            indexSettings.updateIndexMetadata(IndexMetadata.builder(indexSettings.getIndexMetadata()).settings(newSettings).build());
            assertThat("external listener must receive both before and after", externalCalls.get(), equalTo(2));  
                // Format-specific reader should be present  
    /**
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
            this.refreshFailure = refreshFailure;
    public void testPrepareDeleteWithRoutingBuildsDeleteOperation() throws IOException {
                    for (int i = 0; i < numRefreshes; i++) {
     * <p>The refresh runs on its own thread so a deadlock surfaces as a failed join rather than a hung suite. Returns
            assertThat(e.getMessage(), containsString("frozen for tiering"));  
    }  
                    refreshOutcome.set(t);
                    } catch (AlreadyClosedException e) {
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
                    "processed checkpoint must advance safely to the contiguous max after the fence",
            try {  
     * {@code DocumentMapperForType.parse}.
            // treats as new doc (version NOT_FOUND)
    public void testFlushCommitsCatalogSnapshot() throws IOException {
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());  
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            // INVARIANT the fix must restore: committed LOCAL_CHECKPOINT must not exceed the max
            assertThat(getResult.seqNo(), equalTo(0L));
            List.of(new MockSearchBackEndPlugin(List.of(mockDataFormat.name())))  
     */
        @Override
    }
            this.ownerFailure = ownerFailure;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(  
            .mapperService(mapperService)  
    public void testConcurrentAcquireReader() throws Exception {  
                fail(dump.toString());  
                new DocumentLookupResult("x", 2L, true, null, 5L, 1L, Map.of(), Map.of())
    }
    public void testMultipleRefreshesAccumulateSegments() throws IOException {
        boolean enabled,  
    public void testBeginTranslogBatchOnClosedEngineThrowsAlreadyClosed() throws IOException {
        );  
        final List<Exception> engineFailures = new CopyOnWriteArrayList<>();
    @SuppressForbidden(reason = "test needs reflective access to inject writers into flushQueue")
            // --- Path 6: GC deletes in resolveDocVersion ---
        }
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
        Path translogPath = createTempDir();
        indexingEngine.setWriterCustomizer(writer -> writer.setEmptyFlushWhenNoDocs(true));
    /**  
    ) {
            // The batch owner is told, and its deferred result never got a location.  
                engine.getProcessedLocalCheckpoint(),
        public long mappingVersion() {
    public void testVersionMapAfterAutoIDDocument() throws Exception {  
            assertThat(
            }
        @Override  
            long committedCheckpoint = Long.parseLong(committer.getLastCommittedData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));  
            shardId,
        private final long writerGeneration;
            engine.refresh("test pending translog fence");
            assertThat(deferred.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
import java.util.concurrent.CyclicBarrier;  
        private final org.opensearch.index.engine.dataformat.DataFormat dataFormat;
            java.lang.reflect.Method markUnsafe = current.getClass().getDeclaredMethod("markAsUnsafe");
                        barrier.await();
            java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");
            } catch (FlushFailedEngineException | AlreadyClosedException e) {  
                IllegalStateException.class,
            Thread[] threads = new Thread[numSyncThreads];  
        }
    }
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;
        threadPool = new TestThreadPool(getClass().getName());
import static org.hamcrest.Matchers.instanceOf;
     */
    /** Reads {@code DataFormatAwareEngine.unpublishedDeletes} so tests can assert the flag without exposing it. */  
                threads[t] = new Thread(() -> {
            // Each listener gets beforeRefresh + afterRefresh = 2 calls
                    assertThat("each worker must have indexed every op", perWorker.size(), equalTo(opsPerWorker));
        public long generation() {
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        }
            engine.refresh("test");  
            );  
        ReferenceManager.RefreshListener external = new ReferenceManager.RefreshListener() {  
            Throwable refreshFailure,
    public void testAcquireReaderAfterMultipleRefreshesSeesAllSegments() throws IOException {
                    greaterThan(readerGen)
     * A {@code _get} carrying an explicit {@code version} must conflict on the segment path too.
    public void testFillSeqNoGapsNoGap() throws IOException {
        } finally {
     * code (e.g., {@code IndexShard.applyIndexOperation}) populates it via
            new DocumentLookupResult("1", 2L, true, null, 7L, 1L, Map.of(), Map.of())  
                }
            }
        bootstrapStoreWithMetadata(store, uuid);
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        try {
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            assertThat("beforeRefresh must fire when new segments are produced", beforeCount.get(), equalTo(1));
        List<ReferenceManager.RefreshListener> internalListeners,
    }
        @Nullable TranslogFactory translogFactory,
            // committer factory pattern — we verify the commit data indirectly through
            int numDocs = randomIntBetween(3, 10);
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
    public void testPersistedCheckpointCatchesUpAfterSync() throws IOException {
            indexSettings,
        }
        public CommitStats getCommitStats() {
            // A non-force flush while frozen must return early without committing.
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            // What the commit CLAIMS is durable.
            assertEquals(4L, engine.getProcessedLocalCheckpoint());
            assertTrue("matching version must be served", getByIdLookup(engine, current).exists());  
    }  
            assertThat(failures.get(), equalTo(0));  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            Engine.Index op = indexOp(createParsedDocWithInput("1", null));
                new FailableDataFormatAwareEngine(engine).getFailedEngine()  
            engine.close();  
        }  
     */
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
            refreshThread.join(30_000);
     * that no actual refresh occurred (didRefresh=false). This allows waiters to
    }  
     * </ol>  
        }
import org.opensearch.plugins.PluginsService;  
            // Engine should still be open  
     *
            DocumentLookupResult translogNullResult = getByIdLookup(engine, getWithBadTranslog);
        return result.exists() ? ((DocumentLookupResult.PreMaterialized) result).lookup() : DocumentLookupResult.notFound(get.id());  
            assertThat("processed checkpoint before flush", engine.getProcessedLocalCheckpoint(), equalTo(9L));
                        for (int d = 0; d < docsPerThread; d++) {
            })  
            assertThat("delete tracking must be added to version-map memory", stats.getVersionMapMemoryInBytes(), equalTo(2048L));
        return new EngineConfig.Builder().shardId(shardId)  
            }  
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            assertThat("each refresh must invoke afterRefresh once", afterAfterSeed, equalTo(2));
    public void testCloseNoLockDrainsFlushQueue() throws Exception {
    /**
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            assertFalse("deleted doc should return not found", deleteResult.exists());
            queue.add(new FailingFlushWriter(99L, mockDataFormat));
     * are in flight. Verifies no unhandled exceptions escape and the engine transitions to closed.  
        return buildBatchDFAEngineConfig(store, translogPath, provider, enabled, remoteStore, null);
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {  
            @Override  
            int docsPerThread = randomIntBetween(10, 20);
            engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
                final int workerId = w;  
            engine.index(indexOp(createParsedDocWithInput("2", null)));  
    public void testIOExceptionDuringCommitEngineStaysOpenForNonCorruption() throws IOException {
            // Index 1 doc, then create a gap via a recovery op at seqNo=5.  
    /**
            // Phase 3 -- translog sync advances the PERSISTED checkpoint to the same max.  
            // Engine is closed for all subsequent operations.
import java.util.concurrent.CountDownLatch;
        MockDataFormatPlugin normalPlugin = MockDataFormatPlugin.of(mockDataFormat);
            }
            assertThat(gcResult.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            assertThat("beforeRefresh must see pre-commit generation", genSeenInBefore.get(), equalTo(1L));  
                } catch (Throwable e) {  
                new FailableDataFormatAwareEngine(engine).getFailedEngine()  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            public void afterRefresh(boolean didRefresh) {  
        AtomicReference<Exception> failedEngineCause = new AtomicReference<>();  
    }  
            final Thread reader = new Thread(() -> {  
                });  
            });
    }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            assertThat(update.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
                assertThat(ref.get().getSegments().size(), greaterThan(0));  
    /** Control: the matching version on the segment path must still be served. */
                new Engine.Index(
            }  
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
    }
            // Verify that flush at least completes without error and the translog is still valid.
            try {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "segment-repo")
import java.util.UUID;  
import static org.hamcrest.Matchers.sameInstance;
                    .stream()
                // Never leak workers if refresh or an assertion fails.  
            }
            }  
    }  
            engine.refresh("test");
    /**
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));  
            int numIndexThreads = randomIntBetween(2, 4);  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            settings.put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        int numDocs = randomIntBetween(3, 10);  
            refresher.join();
        }
            return true;
    // Refresh Listener Tests — Use-case focused  
            queueField.setAccessible(true);
import org.opensearch.plugins.DocumentLookupProvider;
    public void testOutOfMemoryErrorDuringFlushViaCommitter() throws IOException {  
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
            // --- Path 1: versionValue.isDelete() ---
     * and the band in between is seeded as "already processed", so it is never replayed — the
            return new WriteResult.Failure(new IOException("simulated addDoc failure"), -1L, -1L, -1L);
    /** Builds a HOT-tier DFA {@link EngineConfig} carrying the given {@link DocumentLookupProvider}. */
        @Override
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
                indexThreads[t].start();  
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        }
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));  
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
        }  
            assertThat("first op must have an assigned seqNo", first.getSeqNo(), equalTo(0L));
                    }  
            new DocumentLookupResult("1", 2L, true, null, 7L, 1L, Map.of(), Map.of())
            Engine.Get getWithPtConflict = realtimeGet("1").setIfSeqNo(0L).setIfPrimaryTerm(999L);  
    public void testConcurrentBatchedBulksPublishOnlyAfterRefreshAndRemainReplayable() throws Exception {
        Path translogPath = createTempDir();  
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));  
            assertTrue("listener fires immediately when idle engine is already drained", listenerFired.get());
            int numThreads = randomIntBetween(3, 6);
    private AtomicLong primaryTerm;  
            @Override
            }
                    .sum();  
    /**
    public void testNewChangesSnapshotAfterConcurrentIndexing() throws Exception {
    public void testSegmentsStatsWithFileSizesIncludesDeleteTrackingMemory() throws Exception {  
                new DocumentLookupResult("x", 2L, true, null, 5L, 1L, Map.of(), Map.of()),
            // Engine should be failed  
import java.nio.file.Path;
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            .internalRefreshListener(List.of())
            Settings.builder()  
            long seqNo = 0L;
                assertThat(wfs.files().isEmpty(), equalTo(false));  
                    } catch (Exception e) {
                }
                        indexingDone.countDown();  
import org.opensearch.index.VersionType;  
        }
        when(mapperService.documentMapper()).thenReturn(documentMapper);
import org.opensearch.index.get.DocumentLookupResult;
            );
            Thread fmThread = new Thread(() -> {
                    }
            }  
    private DataFormatAwareEngine createBatchDFAEngine(  
        return buildDFAEngineConfig(store, translogPath, List.of(), List.of(), IndexModule.TieringState.HOT.name(), documentLookupProvider);  
            IllegalStateException e = expectThrows(
     * have produced, so the shard-bulk is retried on the re-promoted primary before any Parquet or Lucene work is done.
            state = WriterState.CLOSED;
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
     * <ul>
    // ----- Batched translog append (index.translog.batch_append.enabled) -----  
        }
                // expected
                    try {
        );
    @SuppressForbidden(reason = "test needs reflective access to inject a writer into flushQueue")
            // Let them run briefly
            // Wait until both workers have indexed all their ops (bounded).  
import org.opensearch.test.IndexSettingsModule;  
            engine.freezeForTiering();
            engine.refresh("test");
            // Thread 1: continuous indexing
            return delegate.commit(commitInput);
            shardId,
     *   <li>the engine is failed exactly once, and the recorded failure is the translog's tragic exception itself, as  
        return buildDFAEngineConfig(store, translogPath, externalListeners, internalListeners, IndexModule.TieringState.HOT.name());
            int numDocs = 10;
        assertThat(dataAfterFail, equalTo(committedData));
        engine.failEngine("corruption test", corruption);  
            public void onFailedEngine(String reason, Exception e) {
                t.join();
        }
        boolean remoteStore,  
        DataFormatRegistry registry = createMockRegistry();
        DocumentLookupProvider provider,
            Engine.DeleteResult replay = engine.delete(deleteOpFromTranslog("1", 0L));
     * generation in the deletion policy for as long as it is held, and releases that generation when closed.  
        }
        public void updateMappingVersion(long newVersion) {}  
                    } catch (Exception e) {  
        );
        }
            for (int i = 0; i < numDocs; i++) {  
                assertFalse("thread should have completed", t.isAlive());  
        engine.close();
            @SuppressWarnings("unchecked")
    @Override  
     * A committer wrapper that can inject failures on commit. Tragic exceptions are now
            GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot();
                    1L,  
        boolean remoteStore  
                }
        public boolean isSchemaMutable() {
                    try {
    public void testOperationsAfterCloseThrow() throws IOException {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                });  
                equalTo((long) numDocs - 1)
import java.util.concurrent.atomic.AtomicInteger;  
            engine.close();
            .eventListener(eventListener != null ? eventListener : new Engine.EventListener() {
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            this.writerGeneration = writerGeneration;  
            .primaryTermSupplier(primaryTerm::get)
import java.util.Set;
    public void testFailedUpdateDoesNotSupersedePreviousCopy() throws Exception {
            for (Thread t : threads) {  
                        engine.flush(false, true);
    }
            CyclicBarrier barrier = new CyclicBarrier(numThreads);  
                    }
    }  
        bootstrapStoreWithMetadata(store, uuid);  
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
    }
            engine.refresh("first");
            Engine.Operation.Origin.PRIMARY,
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                    }
        // Use a normal (non-failing) engine so we can inject the failure precisely.  
            }  
    }
            Engine.Operation.Origin.PRIMARY,
            }
        MockDeleteExecutionEngine deleteEngine = new MockDeleteExecutionEngine(mockDataFormat);  
        when(provider.getById(any(), any(), any(), any())).thenReturn(
        final List<Throwable> out = new ArrayList<>();
            engine.index(indexOp(createParsedDocWithInput("2", null)));
            // The self-read flushed the batch: the result now has a location and processed advanced.  
            assertNotNull("engine should have failed from refresh IOException", failable.getFailedEngine());
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
                    SequenceNumbers.UNASSIGNED_SEQ_NO,  
            // Verify: catalogSnapshot docs + pendingRowCount must equal successCount  
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            assertEquals("no further NoOps on second call", 0, secondFill);  
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
     */
        try (DataFormatAwareEngine eng = createDFAEngine(store, translogPath)) {
        assertTrue("committed data should contain translog UUID", committedData.containsKey(Translog.TRANSLOG_UUID_KEY));  
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name())
        ) {  
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));  
import org.apache.lucene.index.IndexWriter;
        );
            for (Thread t : threads)  
        engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        final EngineConfig config = buildBatchDFAEngineConfig(
                assertThat(fromApi.files(), equalTo(wfs.files()));  
                .build()
     * Simulates parallel tier/cancel: freezer threads repeatedly call {@code freezeForTiering()} while a
                    } catch (IOException e) {
        Path translogPath = createTempDir();
                        barrier.await();  
        Path translogPath = createTempDir();  
     * {@link DataFormatAwareEngine#refresh} and {@code preIndex}.
    /**
        ReferenceManager.RefreshListener listener = new ReferenceManager.RefreshListener() {
import static org.mockito.ArgumentMatchers.any;  
            @SuppressWarnings("unchecked")  
        DocumentMapper documentMapper = mock(DocumentMapper.class);
            long cleanups = engine.unreferencedFileCleanUpsPerformed();
                    for (int i = 0; i < 10; i++) {
            final int opsPerWorker = 8;  
                t.join(30_000);  
            int totalDocs = numThreads * docsPerThread;  
            // Flush should fail the engine via maybeFailEngine  
        AtomicInteger droppedRefreshCount = new AtomicInteger();
            assertEquals(1, stats.getCount());  
        @Override
            }  
    public void testCatalogSnapshotContainsFormatSpecificFiles() throws IOException {
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("post-fail", null))));  
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);
        Engine.EventListener listener = new Engine.EventListener() {
    /**
            assertThat(result.getFailure().getMessage(), containsString("simulated delete rejection"));
            assertTrue(engine.  
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));  
            expectThrows(FlushFailedEngineException.class, () -> engine.flush(false, true));  
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("0", null)));
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);  
            refresher.start();
                CatalogSnapshot snapshot = ref.get();
        Path translogPath = createTempDir();
            for (int i = 0; i < 10; i++) {  
            // New snapshot should have higher generation
            engine.close();  
        }
                            assertThat("op must have an assigned seqNo", result.getSeqNo(), greaterThanOrEqualTo(0L));  
                        }
            // Inject IOException on refresh
    /**  
                });
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
            // localCheckpoint == maxSeqNo == 4 — no gap to fill.
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            expectThrows(AlreadyClosedException.class, () -> engine.refresh("after-fail"));
            assertThat(failure.getMessage(), containsString("could not apply buffered deletes while retiring writer"));  
        } finally {
            assertFalse("file sizes must be present when requested", stats.getFileSizes().isEmpty());  
    // --- Test: failEngine does NOT mark store corrupted for non-corruption exceptions ---
            AtomicReference<Exception> failureCause = new AtomicReference<>();
            .build();
            boolean needsFlush = engine.shouldPeriodicallyFlush();
            for (int i = 0; i < numDocs; i++) {  
    }
    /** Primary delete op carrying compare-and-set ifSeqNo/ifPrimaryTerm (for version-conflict tests). */  
            assertThat(delete.routing(), equalTo("custom-routing"));  
            indexThread.join(10_000);  
            }  
            "test",
        );
            "",  
        DocumentLookupProvider provider = mockLookupProvider();  
            delegate.deleteCommit(snapshot);  
            expectThrows(VersionConflictEngineException.class, () -> engine.getById(stale, (source, scope) -> null));  
     * configured to fail on flush) and a custom event listener — used by tests that need  
    public void testFrozenEngineSkipsRefreshExceptPrepareAndFlushSources() throws IOException {  
            // Flush triggers commit which fails
            public void afterRefresh(boolean didRefresh) {
            }  
            "the refresh failure must be rooted in the tragic exception, chain was " + describeExceptionChain(outcome.refreshFailure),
            engine.flush(false, true);
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
     */
    }
    @SuppressForbidden(reason = "test needs reflective access to inject a writer into flushQueue")
                }  
    /**
            assertThat("afterRefresh must see post-commit generation", genSeenInAfter.get(), equalTo(2L));
        }
                if (first == null) {
    public void testFailEngineWithCorruptionMarksStoreCorrupted() throws IOException {  
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
            // assert the queue is empty without exposing internals on DFAE.  
        }  
            }
            // The listener must have been called: beforeRefresh once, afterRefresh(true) once
            final AtomicReference<DocumentLookupResult> lookup = new AtomicReference<>();
            // Engine must remain open on primary even after rejections  
                    try {
        DocumentMapper documentMapper = mock(DocumentMapper.class);
            assertThat(stats.getGlobalCheckpoint(), equalTo((long) numDocs - 1));
            }
                    assertThat(op.seqNo(), greaterThanOrEqualTo(fromSeqNo));
            int numDocs = randomIntBetween(5, 20);
            assertThat("onFailedEngine should be called exactly once", onFailedCount.get(), equalTo(1));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
     * reports the (older) chunk location, which the bulk layer merges by maximum.
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            Engine.Get getNoConflict = realtimeGet("1").setIfSeqNo(0L).setIfPrimaryTerm(1L);
                    } catch (Throwable e) {  
            engine.ensureOpen();  
            int count = engine.countNumberOfHistoryOperations("test", 0, numDocs - 1);
    private EngineConfig buildFailingEngineConfig(MockDataFormatPlugin plugin, Engine.EventListener listener) throws IOException {  
            assertThat("writeIndexingBuffer should trigger a refresh that advances the snapshot", genAfter, greaterThan(genBefore));
                assertThat(ref.get().getGeneration(), equalTo(2L));
            shardId,
                IndexReaderProvider.Reader reader = readerRef.get();  
        assertThat(
                // expected
            for (int i = 20; i < 30; i++) {
                Object formatReader = reader.reader(mockDataFormat);  
        EngineConfig config = buildFailingEngineConfig(failingPlugin, listener);  
            engine.refresh("test");  
            }
        }
                "the processed checkpoint must not advance while batches are pending",
     * notifications to {@code RemoteStoreRefreshListener} instances only, so a plain
     * preIndex happy path.
            // listener registered here is not one, so the merge must NOT invoke it.
        }  
                droppedRefreshCount.get(),
        Boolean appendOnly
        DataFormatAwareEngine engine = fer.engine();  
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
     * freeze-state CAS rather than {@code IndexSettings} concurrency. After the storm, driving a
    public void testIndexAddDocFailureReturnsFailureResult() throws Exception {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(0L));
        );
            gate.await(10, TimeUnit.SECONDS);  
            .committerFactory(committerFactory)
            final List<Engine.IndexResult> allResults = new ArrayList<>();
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    public void testPureDeleteRefreshAppliesDeletesAndDropsGeneration() throws Exception {
    /** Verifies that a delete-only refresh applies deletes and drops the emptied generation. */
            .indexSettings(indexSettings)
    }  
     * {@code translogFactory} and {@code eventListener} default to the stock factory and a silent listener when null.
        return createBatchDFAEngine(store, translogPath, provider, enabled, true);  
     * placed in the flushQueue (but not yet flushed) would be orphaned on engine close,
                (java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>>) queueField.get(engine);  
            Engine.Get get = realtimeGet("1");
            AtomicBoolean listenerFired = new AtomicBoolean(false);
        final AtomicBoolean fired = new AtomicBoolean(false);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            engine.refresh("test");
    private MockWriter getPooledMockWriter(DataFormatAwareEngine engine) {
                    }  
                Engine.IndexResult result = engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));  
        MockIndexingExecutionEngine indexingEngine = new MockIndexingExecutionEngine(mockDataFormat);
        Path translogPath = createTempDir();
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            System.nanoTime(),  
        }  
    }  
            // Index docs, refresh, flush — establish baseline
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
                // Already closed by failEngine.
        when(provider.getById(any(), any(), any(), any())).thenReturn(
    }
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        DataFormatAwareEngine engine = fer.engine();  
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
        AtomicInteger afterCount = new AtomicInteger(0);
    public void testRefreshThreadFlushFailureFailsEngineAndDrainsQueue() throws Exception {
        final RuntimeException ownerFailure;
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
        if (appendOnly != null) {
        }  
                "engine should have failed on primary with CorruptIndexException",
            listener
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)  
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            assertThat("a post-GET op re-enters the still-open scope as pending", third.getTranslogLocation(), nullValue());
                    engine.refresh("drain failed batch");  
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
        public Map<String, String> getLastCommittedData() throws IOException {  
            @Override  
            IndexReaderProvider.Reader reader = readerRef.get();
        AtomicLong genSeenInBefore = new AtomicLong(-1);
                5L,  
            assertThat(stats.getMaxSeqNo(), equalTo((long) numDocs - 1));
            assertThat("the next chunk remains pending", nextChunk.getTranslogLocation(), nullValue());  
            Engine.Index op = indexOp(createParsedDocWithInput("2", null));
            assertThat(result.getFailure(), instanceOf(VersionConflictEngineException.class));  
                .build()
                while ((op = snapshot.next()) != null) {  
    }
        MockDeleteExecutionEngine deleteEngine = spy(new MockDeleteExecutionEngine(mockDataFormat));  
            FailableDataFormatAwareEngine failable = new FailableDataFormatAwareEngine(engine);
            version,  
        DataFormatAwareEngine engine = fer.engine();
            // Verify corruption marker file exists on disk  
                work.push(current.getCause());
        }
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();
        }
    }  
            assertEquals("max advanced via recovery op", 7L, engine.getSeqNoStats(SequenceNumbers.NO_OPS_PERFORMED).getMaxSeqNo());  
            final Throwable thrown = refreshOutcome.get();
import org.opensearch.plugins.SearchBackEndPlugin;
        DocumentLookupProvider provider = mockLookupProvider();
            assertEquals(5L, engine.getProcessedLocalCheckpoint());  
                equalTo(SequenceNumbers.NO_OPS_PERFORMED)
                    for (int i = 0; i < numFlushes; i++) {
                        failures.incrementAndGet();  
            Engine.IndexResult indexed = engine.index(indexOp(createParsedDocWithInput("1", null)));
import org.opensearch.action.support.TransportActions;  
            }  
            RefreshFailedEngineException ex = expectThrows(RefreshFailedEngineException.class, () -> engine.refresh("flush-failure-test"));
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                threads[t].start();
            try (org.opensearch.common.lease.Releasable ignored = versionMapOf(engine).acquireLock(op.uid().bytes())) {
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
                final int threadId = t;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings.build());  
    }
            engine.refresh("test");  
                }
    /**
            int numDocs = randomIntBetween(5, 15);  
                "merge must not invoke beforeRefresh on a non-remote-store listener",  
    }
            engine.refresh("flush");  
            // executeDeletePlan must record a delete tombstone in the live version map.  
                genAfter = ref.get().getGeneration();
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
    /** Control: a matching {@code if_seq_no} on the segment path must still be served. */
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
        for (int i = 0; i < numDocs; i++) {
                genBefore = ref.get().getGeneration();  
            Engine.IndexResult result = engine.index(indexOp(createParsedDoc("1", null)));
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
    }
            assertThat(extraResult.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
        try {
            // These two bypass the freeze and are allowed to proceed.
            assertFalse("empty engine should not need periodic flush", needsFlush);  
    public void testConcurrentFailEngineFromMultipleSourcesIsIdempotent() throws Exception {
            assertThat(result.getTranslogLocation(), notNullValue());
    ) {
        Path translogPath,
            }
import static org.hamcrest.Matchers.containsString;  
        DataFormatAwareEngine engine = new DataFormatAwareEngine(config);
            public void afterRefresh(boolean didRefresh) {  
            // Index 5 docs successfully
                    assertThat(wfs.numRows(), equalTo(1L));
    }  
import org.opensearch.index.store.Store;  
     * <p>The latch-and-flushQueue contract demands that, no matter which code path  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            .externalRefreshListener(List.of())
            FlushFailedEngineException ex = expectThrows(FlushFailedEngineException.class, () -> engine.flush(false, true));
            .committerFactory(c -> new InMemoryCommitter(store))
    public void testPreIndexSkipsWhenCheckPendingFlushDisabled() throws Exception {  
     * operations whose seqNo falls within the requested {@code [fromSeqNo, toSeqNo]} range, de-duplicated --
     * Also covers incrementIndexVersionLookup (called inside resolveDocVersion on provider path).
                    dump.append("    at ").append(frame).append('\n');
                "committed LOCAL_CHECKPOINT ("  
                    } catch (Exception e) {  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(  
     *       firing {@link Engine.EventListener#onFailedEngine} so the shard is failed.</li>
            // The cached instance must not have been mutated by the copy.
                latestGen = snapRef.get().getGeneration();
     *
                                IndexReaderProvider.Reader reader = ref.get();
            // Verify the cause chain contains the original corruption exception  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                "translog grew by 4 NoOps",  
            assertThat("beforeRefresh fires even when no data changed", beforeCount.get(), equalTo(1));  
        DocumentLookupProvider provider,
    }
            }  
            // Index enough docs to potentially trigger periodic flush
            vmField.setAccessible(true);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            writersCreated.incrementAndGet();
import org.opensearch.index.translog.TranslogFactory;  
            public void onFailedEngine(String reason, Exception failure) {
            )
            engine.refresh("second");  
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
            expectThrows(VersionConflictEngineException.class, () -> getByIdLookup(engine, getWithPtConflict));
     */
     *
     * can assert that at least one writer entered the flow.
    }
        // Return all seqNos 0-5 so checkpoint advances, with duplicate id "x" at seqNo 2 and 5  
        for (Writer<?> w : engine.getWriterPool()) {
        indexingEngine.setWriterCustomizer(DataFormatAwareEngineTests::retireOnWrite);
        expectThrows(AlreadyClosedException.class, () -> engine.segments(false));  
                deleteEngine.deletedIds().size(),  
        Throwable current = t;
            // A range above the highest seqNo contains no operations.  
            engine.flush(false, true);
                int i = 0;
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
    }
     */  
     * Builds an engine config wired to a custom data format plugin (whose writer can be
                    DataFormatAwareEngine eng = engineRef.get();
     */  
                primaryTerm.get(),
        Store store,
                            failure.compareAndSet(null, e);
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {  
        indexingEngine.setRefreshResultTransformer((input, result) -> {  
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
     *       and the processed checkpoint advances contiguously to 1 (seqNos 0,1) -- catching a regression that  
        }
            // Initially HOT — indexing works.
                assertThat(segment.dfGroupedSearchableFiles().containsKey(mockDataFormat.name()), equalTo(true));
        @Override
            // On primary, maybeFailEngine sees Lucene.isCorruptionException and calls failEngine,  
    public void testFillSeqNoGapsClosesGapAndWritesTranslogNoOps() throws IOException {
        }
        MapperService mapperService = mock(MapperService.class);  
        DataFormatAwareEngine getEngine() {
            int numRefreshes = randomIntBetween(3, 7);
    private static void retireOnWrite(MockWriter writer) {
                    failureCause.set(e);  
    @SuppressForbidden(reason = "test needs reflective access to the engine's versionMap field")  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        );
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
import org.opensearch.index.store.FsDirectoryFactory;
                CatalogSnapshot snapshot = ref.get();  
        bootstrapStoreWithMetadata(store, uuid);
        DataFormatRegistry registry = createMockRegistry();
                        if (doFlush) {
                        failures.incrementAndGet();
        deleteEngine.setDeletesAppliedOnCheckout(true);
                    assertThat("local checkpoint must not advance on rejection", eng.getProcessedLocalCheckpoint(), equalTo(maxSeqNo));  
    }
                assertThat(readerRef.get().reader(mockDataFormat), notNullValue());  
                    + persistedMaxSeqNo  
            // Index another doc — this triggers preIndex which flushes the queued writer.  
            // Initial snapshot generation is 1 (bumpGeneration in constructor)
        ) {
            // Verify store marked corrupted
            writer.setFailureKeepsActive(true);
            public void onFailedEngine(String reason, Exception e) {
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        AtomicBoolean engineFailed = new AtomicBoolean();
        }  
            // Phase 4 -- replayability: every acknowledged op is in the translog, contiguous and de-duplicated.
        }  
     */
        EngineConfig config = buildDFAEngineConfig(store, translogPath, provider);
import org.apache.lucene.index.IndexWriterConfig;
            AtomicInteger failures = new AtomicInteger(0);
            // Non-realtime get falls through to provider
            AtomicInteger failures = new AtomicInteger(0);  
            // Store should be marked corrupted  
        DocumentLookupProvider provider = mockLookupProvider();  
            engine.flush(false, true);
import org.opensearch.common.concurrent.GatedCloseable;
            Thread flusher = new Thread(() -> {
    private Store store;
                    }
            for (Thread t : threads) {  
                engine.refresh("batch-" + batch);
    public void testResolveDocVersionFallsBackToProvider() throws IOException {  
                Engine.Operation.Origin.PRIMARY,
            int count = engine.countNumberOfHistoryOperations("test", 3, 7);  
     * so the engine stays usable.
                try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            Thread.sleep(200);
            );  
    public void testGetByIdFromSegmentsAcceptsCurrentIfSeqNo() throws IOException {
        engine.close();
    public void testIndexAfterFailEngineThrowsAlreadyClosedWithOriginalCause() throws Exception {
            // Inject a writer that returns empty FileInfos on flush (success path, no files).
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings.build());
        try {
            .dataFormatRegistry(registry)  
            int numThreads = randomIntBetween(2, 4);
        }
        assertThat(committedData, notNullValue());
            }
            MockIndexingExecutionEngine indexingEngine = getMockExecutionEngine(engine);
                        break; // expected during close  
            engine.index(indexOp(createParsedDocWithInput("1", null)));
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
                        break;
            assertTrue("the queued writer's generation must have been drained", deleteEngine.checkedOutGenerations().contains(42L));  
                        failures.incrementAndGet();
    /** Happy-path primary delete of an existing doc: SUCCESS, assigned seqNo, translog location, and a version-map tombstone. */
            assertThat(engine.countNumberOfHistoryOperations("test", 0, Long.MAX_VALUE), equalTo(numDocs));
            }
            super(dataFormat);
        DocumentMapper documentMapper = mock(DocumentMapper.class);
            AtomicInteger failures = new AtomicInteger(0);
            Engine.IndexResult first = engine.index(indexOp(createParsedDocWithInput("upd", null)));  
            assertThat(result.getFailure(), instanceOf(VersionConflictEngineException.class));
        bootstrapStoreWithMetadata(store, uuid);
        };
        // Verify commit data was persisted  
        }
 * <p>Uses mock data format components to isolate the DFAE orchestration logic
        }
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));  
            // The forced append published the WHOLE pending chunk, in seqNo order, not just the requested entry.
                versionMap.putDeleteUnderLock(uid, new DeleteVersionValue(2L, 1L, 1L, System.currentTimeMillis()));
            for (Thread t : indexThreads)
                null,  
            assertNull("engine should still be open", new FailableDataFormatAwareEngine(engine).getFailedEngine());
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                    }
            for (Engine.IndexResult result : allResults) {
                threads[t] = new Thread(() -> {
            }
                            assertThat("op must be deferred while its batch is open", result.getTranslogLocation(), nullValue());
    private static final class DrainFailureOutcome {  
        }  
                return result;
            engine.refresh("index-refresh");
    }  
            java.lang.reflect.Field vmField = DataFormatAwareEngine.class.getDeclaredField("versionMap");  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            IndexWriter writer = new IndexWriter(  
        }
                    barrier.await();  
        try {
                "the retiring writer's generation must have been drained, got " + deleteEngine.checkedOutGenerations(),
            store.close();  
            }
            return delegate.serializeToCommitFormat(snapshot);
    }  
                greaterThanOrEqualTo(1)  
        try {
                }  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
            );
                } else {  
            }  
                if (didRefresh) {
    public void testGetByIdReturnsNotFoundWhenEmptyCatalog() throws IOException {
        DataFormatAwareEngine engine = fer.engine();  
            }
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> deleteEngine);  
    private record FailingEngineResult(DataFormatAwareEngine engine, FailureInjectingCommitter committer) {
                final int threadId = t;
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
        public Committer.CommitResult commit(Committer.CommitInput commitInput) throws IOException {  
                engine.refresh("trigger-failure");
                } catch (Exception e) {
            }  
            assertFalse("versionMap should be safe after refresh", versionMap.isUnsafe());
            long persistedRows;  
            for (Thread t : threads)
            Translog.Location max = batch.finish();
            expectThrows(AlreadyClosedException.class, () -> engine.refresh("post-fail"));  
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
            }
            // Even with a failing writer in the queue, preIndex should skip it.
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            // Index 10 more (unflushed — in translog only)
                        }
        DocumentLookupProvider provider = mockLookupProvider();
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo((long) numDocs - 1));  
                "simulated corruption during index",
            Engine.Get stale = new Engine.Get(true, true, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))).setIfSeqNo(3L)
        public void close() {  
            Engine.Get get = realtimeGet("1");
            engine.translogManager().syncTranslog();
     */
                assertThat("reader for the registered data format should be present", formatReader, notNullValue());
                engineFailed.set(true);
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
    public void testRefreshListenerSeesMonotonicallyAdvancingSnapshots() throws IOException {
        bootstrapStoreWithMetadata(store, uuid);  
    ) throws Exception {
        Path translogPath = createTempDir();
    public void testHistoryUUID() throws IOException {
            .committerFactory(c -> new InMemoryCommitter(store))
            assertTrue(versionMap.isSafeAccessRequired());
                // 2 segments: one from first refresh, one from second
            @SuppressWarnings("unchecked")  
            for (int i = 0; i < numDocs; i++) {
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            assertThat(delete.id(), equalTo("42"));
        // Create the initial translog files and get the UUID  
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            java.lang.reflect.Field closersField = DataFormatAwareEngine.class.getDeclaredField("pendingWritersToClose");
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            // still false). The live-settings fallback must still block the operation.
    public void testBatchedAppendFlushesAtOperationLimit() throws IOException {
                thrown == null ? "nothing\n" : describeExceptionChain(thrown),  
                }  
        final StringBuilder sb = new StringBuilder();  
                // MockWriter produces "data_gen<writerGen>.parquet" — first writer is gen 1  
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            try (org.opensearch.common.lease.Releasable ignored = versionMapOf(engine).acquireLock(op.uid().bytes())) {  
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
            Engine.Get get = realtimeGet("1");  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
            true,  
    /**
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    /**
        Engine.EventListener listener  
        Store store,
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
                VersionValue vv = versionMap.getUnderLock(uid);  
     */
     * The segment fall-through must enforce read-time preconditions, mirroring the realtime version
            )
            .store(store)
            for (int t = 0; t < numThreads; t++) {
    public void testConcurrentRefreshAndFlush() throws Exception {
        super.setUp();  
            for (int t = 0; t < numThreads; t++) {  
            assertEquals(
            long genAfter;
        TranslogConfig translogConfig = new TranslogConfig(  
    private MockDataFormat mockDataFormat;
            expectThrows(UnsupportedOperationException.class, () -> getByIdLookup(engine, get));
            engine.index(indexOp(createParsedDoc("2", null)));
            assertThat("op 2 location must be deferred before the cross-thread GET", secondPending.getTranslogLocation(), nullValue());
                engineFailures.add(e);
            .translogConfig(translogConfig)
            public void beforeRefresh() {
    }
            .indexSettings(indexSettings)
            for (int t = 0; t < numSyncThreads; t++) {
                equalTo((long) totalOps - 1)
    }  
     * (the fsync callback does that).  
        Store store,  
        }  
                .build()  
        });
        }
                        // Each worker owns its own batch scope (beginTranslogBatch is thread-local).  
            }
            assertTrue(updated.exists());  
    public void testCountNumberOfHistoryOperationsRespectsSeqNoRange() throws IOException {  
    public void testWriteIndexingBufferTriggersRefresh() throws IOException {  
        }
            Engine.IndexResult gcResult = engine.index(indexOp(createParsedDocWithInput("1", null)));  
        ReferenceManager.RefreshListener listener = new ReferenceManager.RefreshListener() {
            engine.index(indexOp(createParsedDoc("2", null)));
            outcome.refreshFailure,
    }  
    }
                beforeCalls.incrementAndGet();
                out.add(s);
        public org.opensearch.index.engine.dataformat.FileInfos flush(org.opensearch.index.engine.dataformat.FlushInput flushInput)
     * The drained append is a TRAGIC translog failure. The contract this pins down:  
                            }
     */  
            DocumentLookupResult getResult = getByIdLookup(engine, realtimeGet("1"));
            int numDocs = randomIntBetween(3, 10);
    // Pure-delete refresh coverage
            for (int t = 0; t < numThreads; t++) {
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)
        }
                assertThat(snapshot.next(), nullValue());  
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
     * location and the processed/persisted checkpoints have not advanced. flush() assigns every result its location,
        }
    }
                } catch (Exception e) {
    }  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
public class DataFormatAwareEngineTests extends OpenSearchTestCase {
    }
                        barrier.await();
            // Index all docs first
            engine.close();  
            engine.refresh("test");  
            assertThat("no thread should have thrown", threadErrors.get(), equalTo(0));
            AtomicLong maxSeqNo = new AtomicLong(-1);
            );
                if (i < maxDocs) {
     * with the supplied event listener — used by upstream's writer-flush-failure tests.
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
            );
                }  
                engine.close();  
            List.of(
    }
                while (snapshot.next() != null)  
        EngineConfig config = buildDFAEngineConfig(store, translogPath, provider);  
            assertThat(delete.seqNo(), equalTo(5L));
        Directory dir = newDirectory();
                .build();
            }
import org.opensearch.index.engine.dataformat.RowIdAwareWriter;
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            Engine.Get stale = new Engine.Get(true, true, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))).version(1L);
        Path translogPath = createTempDir();
            }
                }  
        }  
                    .getSegments()  
        expectThrows(AlreadyClosedException.class, () -> engine.ensureOpen());  
            boolean closed;
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
    public void testBothExternalAndInternalListenersInvoked() throws IOException {
     * {@code applyReadVersionConflicts} dropped it, returning the current document for a request  
        final DrainFailureOutcome outcome = driveRefreshDrainOfFailedBatchAppend(  
        }
        engine.flush(false, true);
                () -> engine.index(indexOp(createParsedDocWithInput("0", null)))
                int count = 0;
        @Override
            // No unexpected exceptions
            doReturn(new DeleteResult.Failure(new IOException("simulated delete rejection"))).when(deleteEngine)
     * that has not been flushed) must flush the batch in place and succeed, rather than deadlocking.
                int count = 0;
                        failures.incrementAndGet();
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
        }
        final AtomicReference<DataFormatAwareEngine> engineRef = new AtomicReference<>();  
        );
            logger.info(  
    }
                while (stop.get() == false) {
     * (3) release the refresh lock on exit so a subsequent {@code refresh()} proceeds.
                        for (int d = 0; d < opsPerWorker; d++) {
        }
            int numDocs = randomIntBetween(5, 15);
            for (int i = 0; i < 100; i++) {  
        DocumentLookupProvider provider = mockLookupProvider();
     * and internal listeners (registered by the engine for checkpoint tracking) must both
     * <ol>
            return delegate.listCommittedSnapshots();
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> deleteEngine);  
                        threadErrors.incrementAndGet();
        }
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
    @SuppressForbidden(reason = "test needs reflective access to the engine's versionMap field")  
            }
import org.opensearch.index.translog.TranslogConfig;
            AtomicInteger failures = new AtomicInteger(0);  
    public void testPreIndexSuccessfulFlushProducesPendingSegment() throws Exception {
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())  
    }
            Settings.builder()  
        return queue.size();
     * The engine must have indexed at least one doc so a writer exists in the pool.
            for (int i = 0; i < 5; i++) {  
                assertThat(ref.get().getSegments().size(), greaterThan(0));  
            int totalDocs = numThreads * docsPerThread;
            assertNull("from-translog delete must not be re-appended to the translog", result.getTranslogLocation());
                assertThat(reader, notNullValue());
                    engine.forceMerge(false, 1, false, false, false, "test-force-merge");
            engine.refresh("pure-delete-refresh");
     */
                    try {  
    public void testPersistedCheckpointAfterConcurrentIndexAndSync() throws Exception {  
        }
                "42",
                1L,
        EngineConfig config = buildFailingEngineConfig(plugin);  
                            Engine.IndexResult r = eng.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            0
                assertThat(segment.dfGroupedSearchableFiles().size(), equalTo(1));
            .dataFormatRegistry(registry)  
            .indexSettings(indexSettings)
            @Override
            // Engine is closed for all subsequent operations.  
        EngineConfig config = buildFailingEngineConfig(plugin);
        EngineConfig config = buildFailingEngineConfig(plugin);
        engine.index(indexOp(createParsedDoc("1", null)));
        FailingFlushIndexingExecutionEngine failingEngine = new FailingFlushIndexingExecutionEngine(mockDataFormat);  
                assertThat(snapshot.getSegments().size(), equalTo(1));
        }
            }
        int writersCreated() {
     *       the tragic {@code IOException} with nothing from the unwind masking it: no {@code IllegalStateException} from  
    }
            engine.flush(false, true);
            )
        MockDeleteExecutionEngine deleteEngine = new MockDeleteExecutionEngine(df);
                IllegalStateException.class,
            long latestGen;  
            assertThat("the sibling op in the same chunk must also be published", secondPending.getTranslogLocation(), notNullValue());
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            final CountDownLatch flushGate = new CountDownLatch(1);
     * Drives the scenario gbbafna raised on the composite refresh: a bulk thread leaves one deferred op in an open batch;
            IllegalStateException e = expectThrows(  
                new DocumentLookupResult("a", 1L, true, null, 0L, 1L, Map.of(), Map.of()),  
    }
                assertThat(ref.get().getGeneration(), equalTo(3L));
                Translog.Operation op1 = snapshot.next();  
     * </ol>  
    public void testAcquireReaderReturnsValidReader() throws IOException {  
            false,
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            try {
                equalTo(engine.getProcessedLocalCheckpoint())
                }
        }
            doThrow(new IOException("simulated delete failure")).when(deleteEngine).deleteDocument(any(DeleteInput.class), any());
        public org.opensearch.index.engine.dataformat.Writer<MockDocumentInput> createWriter(
                assertThat(ref.get().getSegments().size(), equalTo(2));  
        List<ReferenceManager.RefreshListener> externalListeners,  
                lessThanOrEqualTo(persistedMaxSeqNo)  
                    try {  
                    try {
    public void testBatchedUpdateOfSameDocumentKeepsOrderAndLatestVersion() throws IOException {
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {
        return new EngineConfig.Builder().shardId(shardId)
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
                threads[t].start();
            return org.opensearch.index.engine.dataformat.FileInfos.empty();
            int numThreads = 4;
            BigArrays.NON_RECYCLING_INSTANCE,
                        for (int n = 0; n < iterations; n++) {
            VersionType.INTERNAL,
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            }
    public void testBatchedAppendDefersThenFlushes() throws IOException {
import java.io.Closeable;
     *   <li>The forced append keeps the scope open: a later op is pending again until {@code finish()}.</li>
            failingCommitter.setCommitFailure(new org.apache.lucene.index.CorruptIndexException("No space left on device", "test"));  
    public void testRetiredWriterDrainMarksUnpublishedDeletes() throws Exception {  
            // Realtime get with readFromTranslog finds it in translog via versionMap location  
            // afterRefresh sees the NEW generation (snapshot committed)
    }
            Engine.IndexResult indexedAfter = engine.index(indexOp(createParsedDocWithInput("2", null)));
                .put(indexSettings.getSettings())
import org.opensearch.index.engine.dataformat.WriterState;
        engine.index(indexOp(createParsedDoc("1", null)));  
                    } catch (AlreadyClosedException e) {
import org.opensearch.index.engine.dataformat.Writer;  
            .primaryTermSupplier(primaryTerm::get)
        MockIndexingExecutionEngine limitedEngine = new MockIndexingExecutionEngine(mockDataFormat) {  
        } finally {  
        when(documentMapper.getVersion()).thenReturn(1L);
                        }
            int numDocs = randomIntBetween(3, 10);  
            assertThat(engine.countNumberOfHistoryOperations("test", 0, 4), equalTo(5));  
                refreshNeeded());
                    }  
            .tombstoneDocSupplier(tombstoneDocSupplier())
                        batch.finish();
        DataFormatAwareEngine engine = new DataFormatAwareEngine(config);
            // and do more work  
            }  
            "test",  
            this.dataFormat = dataFormat;
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            expectThrows(FlushFailedEngineException.class, () -> engine.flush(false, true));
        return new ParsedDocument(  
            engine.flush(false, true);
            .primaryTermSupplier(primaryTerm::get)  
            shardId,  
                    .mapToLong(s -> s.dfGroupedSearchableFiles().get(mockDataFormat.name()).numRows())
                new DocumentLookupResult("b", 1L, true, null, 1L, 1L, Map.of(), Map.of()),
    }
    /**  
            assertThat(delete.origin(), equalTo(Engine.Operation.Origin.PRIMARY));
    }  
            if (failures.get() > 0) {
                    expectedMax = result.getTranslogLocation();
            }  
            DocumentLookupResult updated = getByIdLookup(engine, realtimeGet("upd"));
                .primaryOperationPolicy(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE)  
            for (int i = 0; i < numDocs; i++) {
            engine.flush(false, true);
            }
                // expected  
     * The drained append is a NON-tragic translog failure (the translog stays open). Parity with the per-operation path
     * called from inside {@code flush()}, before {@code flush()} reads the checkpoint). We then
    public void testCountNumberOfHistoryOperations() throws IOException {
                        }  
    }
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            assertNotNull("should not throw when seqNo and primaryTerm match", noConflictResult);  
    }
            // Simulate disk full as CorruptIndexException during commit
        DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true);  
            // Refresh with no data — no new segments produced
                    } catch (Exception e) {  
        }
            Engine.Operation.Origin.PRIMARY,
            // Ensure the buffered translog operations are durable and readable by the changes snapshot.
                internalCalls.incrementAndGet();
                engine.close();  
            for (int i = 0; i < numDocs; i++) {
            FailingBatchAppendTranslog.FailureClass.NON_TRAGIC
            for (int i = 0; i < numDocs; i++) {
            .mergePolicy(NoMergePolicy.INSTANCE)
import org.opensearch.index.engine.exec.Segment;
            AtomicReference<Exception> failureCause = new AtomicReference<>();  
                assertThat(newRef.get().getGeneration(), greaterThan(heldGen));
     * writers still sitting in it. Without this, a writer checked out of the pool and  
            }
        java.lang.reflect.Field field = DataFormatAwareEngine.class.getDeclaredField("unpublishedDeletes");  
            .translogConfig(translogConfig)
    public void testGetByIdFromSegmentsEnforcesStaleIfSeqNo() throws IOException {
            return state;  
            // committedCheckpoint+1 and silently drops (persistedMaxSeqNo, committedCheckpoint].
    /** Builds a DFA engine config with the batched-translog-append toggle and remote-store eligibility. */  
}
        engine.failEngine("test", new RuntimeException("simulated"));  
     *
            // thread with the expected name to satisfy the MergeScheduler assertion.
     * A {@link MockIndexingExecutionEngine} variant whose writer always throws on the
     * <p>Mechanism: {@code flush()} calls {@code refresh("flush")} — which snapshots the
            int numFlushes = randomIntBetween(2, 5);
    /**
            for (int i = 0; i < 10; i++) {  
            notifySettingsChanged(engine);
        try (Store store = createStore()) {  
            assertEquals(1, segments.size());  
            Thread[] threads = new Thread[numThreads];  
            assertFalse(versionMap.isSafeAccessRequired());
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {  
                    error.compareAndSet(null, e);
                            engine.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));
        for (int i = 0; i < numDocs; i++) {  
            Engine.IndexResult stale = engine.index(indexOpWithVersion(createParsedDocWithInput("1", null), 3L, VersionType.EXTERNAL));
            null,
            // Processed advances to N-1 on flush; persisted is NOT marked by flush (only the fsync callback does).  
            // Fail engine with a known cause  
            .committerFactory(c -> {
            false,
        @Override
        }
                    readerRef.get().catalogSnapshot().getGeneration(),
                    count++;
            CyclicBarrier barrier = new CyclicBarrier(numThreads);  
                indexThreads[t] = new Thread(() -> {
            assertThat("an issued seqNo must be recorded as a translog no-op", result.getTranslogLocation(), notNullValue());
    @SuppressForbidden(reason = "test needs reflective access to the engine's deleteExecutionEngine")
    }
                assertThat("processed advances per op inline", engine.getProcessedLocalCheckpoint(), equalTo((long) i));
            Thread[] threads = new Thread[freezers + 1];
    public void testRestoreVersionMapAndCheckpointTracker() throws IOException {
            }
        DocumentMapper documentMapper = mock(DocumentMapper.class);
            throw new IOException("simulated flush failure for writer gen=" + writerGeneration + " format=" + dataFormat.name());  
        }
            assertThat(result.getTranslogLocation(), notNullValue());  
        DocumentLookupProvider documentLookupProvider
    // --- Test: concurrent failEngine from multiple sources is idempotent ---  
                synchronized (callOrder) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    private void notifySettingsChanged(DataFormatAwareEngine engine) {
                threads[t].start();
        String tieringState,
        }
        List<ReferenceManager.RefreshListener> internalListeners,
        while (work.isEmpty() == false) {
    }
                t.join();
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;  
     * <p>The test asserts the full publication contract the batched-append design must uphold:
                for (List<Engine.IndexResult> perWorker : perWorkerResults) {  
    }
    }
                    } catch (Exception e) {
            // Both ops carry assigned, contiguous seqNos but no location yet: nothing is published pre-GET.  
            queueField.setAccessible(true);  
        }  
        boolean enabled,
        Store store,
            for (int i = 0; i < 10; i++) {
                assertThat(reader.catalogSnapshot().getGeneration(), equalTo(2L));  
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                });  
            // Phase 1: Index
            engine.close();  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            translogPath,  
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("6", null))));
        }
            assertTrue(versionMap.isUnsafe());
        }  
            public long maxIndexableDocs() {
            assertThat("each refresh with data must notify", observedGenerations.size(), equalTo(numRefreshes));
            markUnsafe.setAccessible(true);
            .externalRefreshListener(List.of())
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
     */  
            AtomicInteger threadErrors = new AtomicInteger(0);
        }
    /**  
            // Acquire and close a reader, then verify the engine still works
            assertThat(second.getTranslogLocation(), notNullValue());
        } finally {
    /**
        when(provider.getVersionMetadata(any(), any(), any(), any())).thenReturn(
                "unexpected secondary failure from the refresh unwind: " + describeExceptionChain(suppressed),
                assertThat(count, greaterThan(0));
            // Verify engine is fully operational — can index new docs  
     *   <li><b>Pending phase:</b> once all workers have indexed (indexedLatch), every result is unpublished
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        return buildDFAEngineConfig(store, translogPath, externalListeners, internalListeners, tieringState, documentLookupProvider, null);  
        try {  
            }  
                + (outcome.refreshFailure == null ? "" : describeExceptionChain(outcome.refreshFailure)),  
            assertThat(engine.countNumberOfHistoryOperations("test", numDocs, Long.MAX_VALUE), equalTo(0));
        java.util.Collection<?> queue = (java.util.Collection<?>) f.get(engine);  
                assertThat("all concurrently indexed ops should be in the translog snapshot", count, equalTo(totalDocs));
                            ParsedDocument doc = createParsedDocWithInput(threadId + "_" + d, null);
    private EngineConfig buildDFAEngineConfig(Store store, Path translogPath) {  
                    } catch (Exception e) {
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("1", null))));
    /**
            AtomicInteger successCount = new AtomicInteger();  
            readerRef.close();  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            assertThat(vv.version, equalTo(1L));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    public void testCloseEngine() throws IOException {  
                }
            // depending on the configured threshold. The key assertion is it doesn't throw.
                        engine.index(indexOp(createParsedDocWithInput(Integer.toString(i++), null)));
            List<String> engineFailureReasons,  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
            engine.flush(false, true);
    }
    public void testCurrentOngoingRefreshCheckpoint() throws IOException {  
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
                    }
    }
    }
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
    private EngineConfig buildBatchDFAEngineConfig(
    private DataFormatRegistry createMockRegistry() {
            engine.maybeRefresh("external");  
                // (reader manager has no data for the initial empty snapshot)
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));  
                    try {
        }
    @SuppressForbidden(reason = "test needs reflective access to the engine's versionMap field")  
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(1L));  
                onFailedCount.incrementAndGet();
    public void testOnSettingsChangedUnrecognizedTieringValueNotFrozen() throws IOException {  
                    } catch (Exception e) {
            base.source(),  
     * </ul>  
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("2", null))));  
            writer.setWriteResultSupplier(() -> { throw new java.io.UncheckedIOException(new java.io.IOException(corruption)); });
            engine.refresh("setup");  
            -1,  
            engine.index(indexOp(createParsedDocWithInput("1", null)));
                        break;
            indexSettings,
            // Full trimming depends on the committer advancing the persisted checkpoint
            System.nanoTime(),  
        };  
     * begin its own) and index a fixed number of successful ops. Every op gets an assigned, contiguous seqNo but its  
    }
            boolean engineClosedAfterwards  
            indexSettings,
    /** The routing-carrying {@code prepareDelete} overload builds an Engine.Delete with the routing value. */  
    public void testConcurrentIndexAndRefreshDocCountNeverUnderCounts() throws Exception {
        FailingEngineResult fer = createDFAEngineWithFailingCommitter(store, translogPath);  
     *       with a contiguous seqNo set -- nothing is lost or duplicated.</li>
            // Reject the update's addDoc with a modeled per-doc failure that the writer has already reconciled.
    /**
            int secondFill = engine.fillSeqNoGaps(primaryTerm.get());
                threads[t].start();  
            assertThat(e.getMessage(), containsString("frozen for tiering"));
            // Sync from multiple threads
            // --- Path 3: seqNo/primaryTerm conflict (seqNo matches, primaryTerm doesn't) ---  
                Translog.Operation op;
        return buildDFAEngineConfig(store, translogPath, List.of(), List.of());
    private DataFormatAwareEngine createDFAEngineWithTieringState(Store store, Path translogPath, IndexModule.TieringState state)
            for (int t = 0; t < numThreads; t++) {
            assertThat(retentionLock, notNullValue());
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    }  
            flushThread.start();
            }, "cross-thread-realtime-get");
            Engine.DeleteResult deleteResult = engine.delete(deleteOp("1"));
            }
        MockDeleteExecutionEngine deleteEngine = spy(new MockDeleteExecutionEngine(mockDataFormat));
            .mergePolicy(NoMergePolicy.INSTANCE)  
            int numDocs = randomIntBetween(20, 50);
            vmField.setAccessible(true);
                // Duplicate id "x" at same seqNo=5 → hits seqNo == versionValue.seqNo → OP_STALE_OR_EQUAL  
    ) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    public void testAppendOnlyMarksVersionMapUnsafe() throws Exception {
    public void testGracefulCloseUnderConcurrentLoad() throws Exception {
            }  
        DataFormatAwareEngine engine = createDFAEngine(store, translogPath);
                thrown.getCause().getMessage().contains("simulated corruption via maybeFailEngine")
                                successCount.incrementAndGet();
            int translogOpsBefore = engine.translogManager().getTranslogStats().estimatedNumberOfOperations();  
            setTieringStateSetting(engine, IndexModule.TieringState.HOT_TO_WARM);
     * Covers resolveDocVersion falling back to DocumentLookupProvider when versionMap miss.  
        Engine.EventListener countingListener = new Engine.EventListener() {
            }
            Engine.IndexResult second = engine.index(indexOp(createParsedDocWithInput("2", null)));
            }  
            final Engine.IndexResult third = engine.index(indexOp(createParsedDocWithInput("3", null)));
            for (int i = 0; i < numDocs; i++) {  
                assertNull(engine.resolveDocVersion(op, true));  
        }
        // A refresh with no new writer files drops every existing generation.
            final Set<Long> expectedSeqNos = new java.util.HashSet<>();
     */
        expectThrows(AlreadyClosedException.class, () -> engine.refresh("after-close"));
                assertNull("reader for unregistered format should be null", reader.reader(unknownFormat));
            }
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
            engine.ensureOpen();
            engine.index(indexOp(createParsedDocWithInput("1", null)));
        try {
        DataFormatAwareEngine engine = createUpdateEnabledDFAEngine(store, createTempDir());
            int numBatches = randomIntBetween(3, 6);
                    try {  
                    }
            engine.index(  
            this.engineFailureReasons = engineFailureReasons;  
                assertThat("translog location should be set", result.getTranslogLocation(), notNullValue());
    private void setTieringStateSetting(DataFormatAwareEngine engine, IndexModule.TieringState state) {
        assertThat(ex.getCause(), instanceOf(IOException.class));
                closed = false;
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
            assertThat(indexed.getTranslogLocation(), nullValue());  
            assertEquals(result.getFailure().getClass(), AppendOnlyIndexOperationRetryException.class);
                } catch (Exception e) {
     *   <li>The exception must surface to the caller as {@link RefreshFailedEngineException}  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                    worker.join(TimeUnit.SECONDS.toMillis(30));  
    /**  
            // Bulk thread: open a scope and leave one deferred index op pending in it.
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
     * (already drained).
            assertFalse("gen 42 must not be drained before it is flushed", deleteEngine.checkedOutGenerations().contains(42L));
import org.opensearch.index.engine.dataformat.DeleteInput;  
import java.util.concurrent.atomic.AtomicReference;
     */
        bootstrapStoreWithMetadata(store, translogUUID, SequenceNumbers.NO_OPS_PERFORMED);
            })
     * {@code flush()} is invoked. Used to drive the flush-failure paths in  
        Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
                @Override
    // Delete failure and retirement-drain coverage  
                            engine.refresh("concurrent");
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            // Converge to a definitive HOT state: engine must unfreeze cleanly and accept writes.
            List<org.opensearch.index.engine.Segment> segments = engine.segments(false);
    /** And a get carrying no precondition at all must be unaffected by the enforcement. */
            );
     * it — fillSeqNoGaps must close the gap so localCheckpoint catches up to max.  
     */  
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(numDocs));  
        };
            // beforeRefresh sees the OLD generation (snapshot not yet committed)
            assertThat(ref.get().getGeneration(), equalTo(heldGen));  
            assertThat(failures.get(), equalTo(0));
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
                    break;
     * Peer recovery / primary relocation relies on this to keep translog history available for the duration
            .mapperService(mapperService)  
                    assertThat("the refresh fence must publish every pending op", result.getTranslogLocation(), notNullValue());
            IllegalStateException e = expectThrows(
            assertThat(result.getFailure(), instanceOf(IOException.class));
     * A realtime GET issued from a DIFFERENT thread for a doc whose location is still pending must force the owning
    public void testPreIndexFlushFailureFailsEngine() throws Exception {  
            .dataFormatRegistry(registry)
            DocumentLookupResult noConflictResult = getByIdLookup(engine, getNoConflict);
                "a failed cycle must not incorporate the part that succeeded",
            assertNull("concurrent freeze/unfreeze must not deadlock or throw", error.get());  
            // Engine should still be open (flush succeeded).  
            assertFalse(versionMap.isSafeAccessRequired());
                    barrier.await();
        Store getStore() {
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    private EngineConfig buildDFAEngineConfig(
     * Append-only optimizable variant of {@link #indexOp}: a non-negative autoGeneratedIdTimestamp
            "a non-tragic append failure must not fail the engine, but it was failed with reasons " + outcome.engineFailureReasons,  
        ReferenceManager.RefreshListener orderingListener = new ReferenceManager.RefreshListener() {
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            if (failure.get() != null) {  
            }  
    /**
                java.util.Collection<WriterFileSet> searchableFiles = snapshot.getSearchableFiles(mockDataFormat.name());  
                );  
        Path translogPath = createTempDir();  
        } finally {
            primaryTerm.get(),
                    } finally {
        }
        }
                assertThat(snapshot.getSegments().size(), equalTo(numBatches));  
                        // Ensure the main thread is never left blocked on the indexed latch if a worker dies early.
            this.engineFailures = engineFailures;
        mockPlugin = MockDataFormatPlugin.of(mockDataFormat);
            .externalRefreshListener(List.of(injector))
                t.join();
     */
        AtomicInteger afterDidRefreshFalse = new AtomicInteger(0);
            engine.refresh("write indexing buffer");
                            engine.freezeForTiering();  
            if (commitFailure != null) throw commitFailure;
                assertThat(result.getSeqNo(), equalTo((long) i));
        AlreadyClosedException closed = expectThrows(AlreadyClosedException.class, engine::beginTranslogBatch);
        }
    // ═══════════════════════════════════════════════════════════════
        DrainFailureOutcome(
            assertThat("no worker may fail while finishing its scope", workerFailure.get(), nullValue());
            barrier.await();  
            // Force merge while frozen returns early without scheduling a merge.
                while (stop.get() == false) {
            }
            assertThat(delete.uid(), equalTo(new Term(IdFieldMapper.NAME, Uid.encodeId("42"))));  
        }  
                            failure.compareAndSet(null, e);
            ifSeqNo,  
            .dataFormatRegistry(registry)
            assertFalse("an unsupported delete must not fail the engine", engineFailed.get());
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) numDocs - 1));
    }
            int numDocs = randomIntBetween(5, 15);
            for (int t = 0; t < numIndexThreads; t++) {
    }  
            assertThat(failures.get(), equalTo(0));
            assertThat(stale.getFailure(), instanceOf(VersionConflictEngineException.class));  
                        barrier.await();
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                        // ignore
    }
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
        }  
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
import static org.hamcrest.Matchers.empty;
            for (int t = 0; t < numThreads; t++) {
            int filled = engine.fillSeqNoGaps(primaryTerm.get());
            engine.index(indexOp(createParsedDocWithInput("1", null)));
     * {@code compareAndSet} guard must make this idempotent under concurrency: no thread throws, and
            assertSame("refresh ACE cause should be the original failure", originalCause, refreshEx.getCause());
    /**
                        barrier.await();
        }  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            for (int i = 0; i < numDocs; i++) {
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("5", null))));  
    }
            System.nanoTime(),
     * Many threads call {@link DataFormatAwareEngine#freezeForTiering()} simultaneously. The atomic
                // But we track call count and verify externally.  
                "cause message should reference simulated corruption",  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
import org.opensearch.index.engine.dataformat.stub.MockDeleteExecutionEngine;
                    callOrder.append('A');
            .threadPool(threadPool)
                assertThat(ref.get().getSegments().size(), equalTo(0));
            .translogConfig(translogConfig)
                );
import java.util.ArrayList;  
        MockIndexingExecutionEngine indexingEngine = new MockIndexingExecutionEngine(mockDataFormat);
            this.engine = engine;
            expectThrows(FlushFailedEngineException.class, () -> engine.flush(false, true));
            }
            }
                0  
        when(provider.getById(any(), any(), any(), any())).thenReturn(
            assertThat("both ops become processed contiguously after the forced append", engine.getProcessedLocalCheckpoint(), equalTo(1L));
                    } catch (Exception e) {  
        FailingFlushWriter(long writerGeneration, org.opensearch.index.engine.dataformat.DataFormat dataFormat) {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(0L));  
        assertFalse("store should not be corrupted for null failure", store.isMarkedCorrupted());
            // Run multiple non-waiting flushes concurrently — none should throw
            assertThat("merge must not invoke afterRefresh on a non-remote-store listener", afterCalls.get() - afterAfterSeed, equalTo(0));
            }  
        DocumentLookupProvider provider = mockLookupProvider();  
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {  
     * Covers the preIndex skip path when check_pending_flush is disabled.  
            // seqNos are assigned contiguously across both bulks regardless of interleaving.  
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
            org.apache.lucene.util.BytesRef uid = new Term(IdFieldMapper.NAME, Uid.encodeId("1")).bytes();  
    // --- Tiering freeze behavior ---
    public void testDeleteEngineIOExceptionIsRethrownAndLeavesEngineOpen() throws Exception {
            Map<String, String> commitData = new HashMap<>();  
                    assertNotNull(result.getFailure());
        @Override  
                    assertThat("doc " + i + " should succeed", result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
                try {
     * {@code retireWriterIfNeeded} in the RETIRED_FLUSHABLE state.  
            // checked out of the pool for refresh but not yet flushed when engine closes).  
            // Arm the failure for the next batched append, which is the refresh's drain.
                        barrier.await();
            try (GatedCloseable<CatalogSnapshot> snapRef = engine.acquireSnapshot()) {
            long genBefore;
            // Inject a DeleteVersionValue into versionMap via reflection
            public void onFailedEngine(String reason, Exception failure) {  
     *   <li>the refresh completes (no deadlock) and throws, and the exception the refresh caller receives is rooted in
                    count++;
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {  
                t.join();
            assertThat(stats.getCount(), equalTo(1L));
            }
                        barrier.await();  
        DocumentLookupProvider provider = mockLookupProvider();
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                final StringBuilder dump = new StringBuilder("refresh did not complete; refresh thread stack:\n");
        @Override
    /** resolveDocVersion branch 4: versionMap miss, provider consulted, getById returns NOT_FOUND → null. */  
                        genSeenInAfter.set(ref.get().getGeneration());
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
     * and mark it unsafe (LiveVersionMap.maybePutIndexUnderLock else-branch).
import java.util.Map;
                        throw new java.io.UncheckedIOException(e);  
            for (int i = 0; i < 5; i++) {
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
                });
     * state ({@code failedEngine}, {@code store}) for direct testing via reflection.
        }
     * with a single merged segment, (2) restrict its beforeRefresh/afterRefresh
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                engine.index(indexOp(createParsedDocWithInput("2", null)));
    private Engine.Delete deleteOpWithIfSeqNo(String id, long ifSeqNo, long ifPrimaryTerm) {
    }  
     * thread itself is the one that observes the failure (only one writer in the
                    gate.await(10, TimeUnit.SECONDS);
            }
                t.join();
                Engine.IndexResult result = engine.index(indexOp(doc));
            engine.refresh("test");
    private ThreadPool threadPool;  
            getByIdLookup(engine, realtimeGet("1"));  
            int numDocs = 10;  
    }
            public void afterRefresh(boolean didRefresh) {
            @Override
    }  
            for (int i = 0; i < numDocs; i++) {  
            reader.join(TimeUnit.SECONDS.toMillis(30));
            assertThat(failures.get(), equalTo(0));
            refresher.join(TimeValue.timeValueSeconds(30).millis());  
            engine.index(indexOp(createParsedDocWithInput("3", null)));
                threads[t] = new Thread(() -> {
        String tieringState,  
            public void beforeRefresh() {
                    } catch (Exception e) {  
                assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                threads[t].start();
            assertThat(engine.segmentsStats(false, false).getVersionMapMemoryInBytes(), equalTo(1024L));
            }
import org.opensearch.core.index.Index;
    }
    }
            }
    public void testDeleteWithMismatchedIfSeqNoReturnsVersionConflict() throws IOException {
    }
                persistedRows = ref.get()
        try (DataFormatAwareEngine engine2 = new DataFormatAwareEngine(buildDFAEngineConfig(store, translogPath))) {  
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            Exception failedEngine = failable.getFailedEngine();  
            for (int i = 0; i < numDocs; i++) {
        DocumentMapper documentMapper = mock(DocumentMapper.class);  
            assertThat(stats.getCount(), equalTo(0L));  
            }
        List<Long> observedGenerations = new ArrayList<>();  
            assertThat(nextChunk.getTranslogLocation(), notNullValue());
            engine.refresh("post-merge");
            IllegalStateException e = expectThrows(
            assertThat(engine.countNumberOfHistoryOperations("test", 5, 9), equalTo(5));
     */
                new DocumentLookupResult("d", 1L, true, null, 4L, 1L, Map.of(), Map.of()),
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            assertEquals(5L, engine.getProcessedLocalCheckpoint());
    }
                        for (int i = 0; i < 5; i++) {
            .eventListener(countingListener)
    /**
            expectThrows(AlreadyClosedException.class, engine::ensureOpen);  
    public void testCorruptionExceptionDuringIndexFailsEngineAndMarksStore() throws IOException {  
                }
            for (Thread t : threads) {
            Engine.IndexResult first = null;
     * randomized timing.  
        }  
        engine.onSettingsChanged(TimeValue.MINUS_ONE, org.opensearch.core.common.unit.ByteSizeValue.ZERO, 0L);
            final AtomicReference<Throwable> workerFailure = new AtomicReference<>();  
            } catch (Exception ignored) {}
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    public void testRefreshDrainOfTragicBatchAppendFailsEngineOnceWithTheTragicException() throws Exception {
            SegmentsStats stats = engine.segmentsStats(false, false);
            id,  
    /**
            assertThat("afterRefresh(didRefresh=true) confirms data is now searchable", afterDidRefreshTrue.get(), equalTo(1L));
            }  
        try (Store store = createStore()) {
            return true;  
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
        }
            int numDocs = randomIntBetween(5, 15);
    /** resolveDocVersion branch 2: versionMap miss with an empty catalog returns null (provider not consulted). */
     * the background {@code triggerPossibleMerges()} path; {@code forceMerge} routes
        EngineConfig config = buildFailingEngineConfig(plugin);
                        barrier.await();
        } finally {
            engine.close();
    public void testPreIndexFlushDrainsDeletesBeforeSegmentCanBeIncorporated() throws Exception {
            int numSyncThreads = randomIntBetween(2, 4);
        );
        AtomicInteger beforeCalls = new AtomicInteger();  
                threads[t] = new Thread(() -> {
        }
     * doc-count gap observed after a primary relocation under sustained ingest).
    }
            );  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
                if (didRefresh) {
            MockIndexingExecutionEngine indexingEngine = getMockExecutionEngine(engine);
    private EngineConfig buildBatchDFAEngineConfig(
            assertTrue(versionMap.isSafeAccessRequired());  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            assertBusy(() -> {  
            rootCause(outcome.refreshFailure),  
import org.opensearch.core.index.AppendOnlyIndexOperationRetryException;
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
    /**
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), mockDataFormat.name())
     * then triggers preIndex by calling {@code engine.index()}.  
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDocWithInput("99", null))));
        }
     * The provider returns docs for seqNos 0-3 so checkpoint advances contiguously.
                () -> engine.index(indexOp(createParsedDocWithInput("0", null)))  
            // the translog UUID and seq-no stats being consistent after flush.
            assertThat("a non-translog primary delete must be written to the translog", result.getTranslogLocation(), notNullValue());
            // Clear failure and flush again — should succeed
        }
    }
            );
     * recovered engine with no indexing or merges, the scheduler reports zero active merges and  
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
    public void testAcquireSnapshotReturnsValidSnapshot() throws IOException {
        @Override
    public void testConcurrentFreezeForTiering_EndsFrozen() throws Exception {
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            // Refresh thread that runs concurrently with indexing  
        FailureInjectingCommitter failingCommitter = fer.committer();
            failingCommitter.setCommitFailure(null);
     *   <li>Call {@link DataFormatAwareEngine#failEngine} with the originating cause.</li>
                            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(workerId + "_" + d, null)));
                    count++;  
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(external), List.of(internal));  
     * {@code null} versionType and unset ifSeqNo/ifPrimaryTerm (see the {@link Engine.Delete} constructor asserts).  
     *       published only the requested entry or published out of seqNo order.</li>
            .internalRefreshListener(List.of())
    @SuppressForbidden(reason = "test needs reflective access to inject a writer into flushQueue and read pendingWritersToClose")  
            engine.close();  
        }
            Engine.Operation.Origin.PRIMARY,
            );  
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
            }  
            .tombstoneDocSupplier(tombstoneDocSupplier())
            // Full range counts every operation.
            MockWriter writer = getPooledMockWriter(engine);  
            MockWriter writer = getPooledMockWriter(engine);
        );
        }
    /**
import org.opensearch.index.engine.exec.IndexReaderProvider;
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
        Path translogPath,
                results.add(result);
    /**
            assertTrue(segments.get(0).search);
        primaryTerm = new AtomicLong(randomLongBetween(1, Long.MAX_VALUE));
                assertThat(op1.opType(), equalTo(Translog.Operation.Type.INDEX));
    /** {@code appendOnly == false} enables updates (a second index of an existing id); {@code null} keeps the default. */
    }  
            }
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        }
            TranslogDeletionPolicy deletionPolicy = ((InternalTranslogManager) engine.translogManager()).getTranslog().getDeletionPolicy();  
            // Configure refresh to throw AlreadyClosedException, with a tragic exception
                            try (GatedCloseable<IndexReaderProvider.Reader> ref = engine.acquireReader()) {  
            engine.refresh("after-close");
                assertThat(segment.dfGroupedSearchableFiles().containsKey(mockDataFormat.name()), equalTo(true));
            Thread[] indexThreads = new Thread[numIndexThreads];
        public java.util.List<org.opensearch.index.engine.exec.coord.CatalogSnapshot> listCommittedSnapshots() {  
            }  
            assertEquals(NoOpDeleteExecutionEngine.UNSUPPORTED_MESSAGE, e.getMessage());  
        ) {
    }
        final IOException tragic = new IOException("simulated tragic translog write failure");  
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());  
    /** resolveDocVersion branch 1: versionMap miss with no provider returns null. */
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;  
            try {
    private Store createStore() throws IOException {
            assertThat(
                    } catch (AlreadyClosedException e) {
                3L,
            this.dataFormat = dataFormat;  
            for (int i = 0; i < 20; i++) {  
            try (Translog.Snapshot snapshot = ((InternalTranslogManager) engine.translogManager()).getTranslog().newSnapshot()) {
            buildDFAEngineConfig(store, translogPath, List.of(), List.of(), IndexModule.TieringState.HOT.name(), null, false)
            // Replay a recovery-origin op at seqNo=7. That marks 7 as seen+processed, but  
            mockExecEngine.setRefreshFailure(() -> new IOException("injected refresh failure"));
                assertThat(snapshot.getGeneration(), equalTo(3L));  
    /** Explicit-id index with compare-and-set ifSeqNo/ifPrimaryTerm (for optimistic-concurrency tests). */
        return (LiveVersionMap) vmField.get(engine);
                assertThat(wfs.numRows(), equalTo((long) numDocs));  
     *
            .store(store)  
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
 *  
        );
    public void testConcurrentIndexRefreshFlushEndToEnd() throws Exception {
                final Set<Long> replayedSeqNos = new java.util.HashSet<>();
        public void close() throws IOException {
        }  
            // Post-conditions: all docs should still be tracked
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo");
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            final int beforeAfterSeed = beforeCalls.get();
                    + "); recovery would otherwise skip and lose seqnos "
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
    public void tearDown() throws Exception {
                    "final snapshot generation must equal number of refreshes + 1",  
            assertThat(delete.getIfPrimaryTerm(), equalTo(primaryTerm.get()));
            new DummyShardLock(shardId),
            assertTrue(cleanups >= 0);  
                CatalogSnapshot snapshot = ref.get();  
                .build()
        EngineConfig config = buildFailingEngineConfig(plugin);
                    barrier.await();  
    }
        AtomicLong genSeenInAfter = new AtomicLong(-1);
            Store.OnClose.EMPTY,
            }
                        if (stop.get() == false) {
     * the durable snapshot actually contains. On recovery, replay starts at {@code committed+1}
            for (int t = 0; t < 4; t++) {
            }  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
 */  
        } finally {
        }  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
                rootCause(suppressed),  
            "test",  
            int numDocs = randomIntBetween(1, 5);
                assertThat(fromApi.numRows(), equalTo(wfs.numRows()));
            for (Thread t : threads)  
            shardId,
            int totalDocs = numIndexThreads * docsPerThread;
            id,
                assertThat(op2.opType(), equalTo(Translog.Operation.Type.DELETE));
    /**
            // --- Path 5: seqNo and primaryTerm both match — no conflict, falls through ---  
     * catalog snapshot being available.
            assertSame("failed engine cause should be the indexing engine's tragic exception", tragicCause, failedEngine);
            Engine.DeleteResult result = engine.delete(deleteOpFromTranslog("1", seqNo));
            .indexSettings(indexSettings)
            }
                t.join(10_000);
            if (w instanceof RowIdAwareWriter<?> riw && riw.getDelegate() instanceof MockWriter mw) return mw;
                for (Engine.IndexResult result : allResults) {  
            assertNotNull("should fall through when translog returns null", translogNullResult);
            assertThat(failures.get(), equalTo(0));  
            .threadPool(threadPool)
        DocumentLookupProvider provider = mockLookupProvider();  
            armedFailure.set(new FailingBatchAppendTranslog.ArmedFailure(failure, failureClass));  
            "the drainer's refresh must not fail because of another request's append, but threw "
                    }
 * SPDX-License-Identifier: Apache-2.0
            assertNotNull("engine should have failed", new FailableDataFormatAwareEngine(engine).getFailedEngine());
                    assertThat("merge must collapse to a single segment", ref.get().getSegments().size(), equalTo(1));
            notifySettingsChanged(engine);  
            // Index 10 docs  
    }
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            int numRefreshes = randomIntBetween(3, 6);  
            .eventListener(new Engine.EventListener() {
            engine.close();
            // Simulate disk full as plain IOException (not corruption)  
            engine2.refresh("recovery-verify");
    }
            Translog.Location bogusLocation = new Translog.Location(999L, 0L, 1);
     * <p>This test injects a failing writer directly into the flushQueue via reflection,
                assertThat(snapshot.getGeneration(), equalTo(3L));  
                        barrier.await();
            Set<Long> dropped = input.existingSegments().stream().map(Segment::generation).collect(Collectors.toSet());
            // Configure committer to throw non-corruption IOException on commit  
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);
            }
            for (int i = 0; i < numDocs; i++) {
        throws IOException {  
                        indexedLatch.countDown();  
        return new EngineConfig.Builder().shardId(shardId)  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    private ParsedDocument createParsedDoc(String id, String routing) {
     * through the index guard).
                for (Thread worker : workers) {
            engine.close();
     * Verifies the merge-count / drain wrappers delegate to the merge scheduler. On a freshly
    }
            setTieringStateSetting(engine, IndexModule.TieringState.HOT);  
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            engine.index(indexOp(createParsedDocWithInput("1", null))); // seqNo 0  
    }
        }
            .threadPool(threadPool)  
            expectThrows(AlreadyClosedException.class, () -> engine.refresh("test"));  
     * a writer whose {@code flush()} throws on first call, ensuring the refresh
            assertThat("no worker may fail during indexing", workerFailure.get(), nullValue());
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            flushQueueOf(engine).add(new FailingFlushWriter(43L, mockDataFormat));  
        }
            java.lang.reflect.Field queueField = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
            // Wait for all threads to start
            // A forced flush does not close the owning bulk scope: later ops form a fresh pending chunk.  
        public void close() {
        public byte[] serializeToCommitFormat(org.opensearch.index.engine.exec.coord.CatalogSnapshot snapshot) throws IOException {  
            writer.commit();
    /**
    }  
            // Opened with INDEX_TIERING_STATE=HOT_TO_WARM — engine must be frozen on construction,  
        final IOException nonTragic = new IOException("simulated non-tragic batch append failure");
import org.opensearch.common.lucene.Lucene;
    }
     * {@link DataFormatAwareEngine#acquireHistoryRetentionLock()} must return a lock that pins a translog
            Thread flushThread = new Thread(() -> {
    }
            // The ops are replayable from the translog, proving the batched append wrote them.
        return new EngineConfig.Builder().shardId(shardId)
            translogPath,
    public void testFlushNonCorruptionExceptionWrapsInFlushFailedEngineException() throws IOException {
            threads[freezers] = new Thread(() -> {  
            assertTrue(e.getMessage(), e.getMessage().contains("does not support primary operation policy"));
                // The mock data format is registered as "composite" — the reader manager
                .build();
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            AtomicInteger failures = new AtomicInteger(0);
    }  
                "the flushed writer's deletes must be drained during preIndex, got " + deleteEngine.checkedOutGenerations(),
            assertThat(indexed.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
                        workerFailure.compareAndSet(null, e);
            assertFalse(engine.isThrottled());
    private static DocumentLookupResult getByIdLookup(DataFormatAwareEngine engine, Engine.Get get) throws IOException {
    }
            // Realtime get on the SAME thread resolves the pending location by flushing the batch in place.
        final Throwable refreshFailure;
            sameInstance(tragic)
     * Uses reflection to inject a DeleteVersionValue into versionMap since engine.delete() is unsupported.
                assertThat("translog location must be deferred (null) before flush", result.getTranslogLocation(), nullValue());  
            }
            try {
            false,
        }
     * definitive state must converge the engine consistently (no deadlock, no torn state observable  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        bootstrapStoreWithMetadata(store, uuid);
    }
        InMemoryCommitter committer = new InMemoryCommitter(store);
    /**
    public void testConcurrentIndexing() throws Exception {
        MockDeleteExecutionEngine deleteEngine = spy(new MockDeleteExecutionEngine(mockDataFormat));
            // Snapshot should exist and have segments
        DocumentLookupProvider provider = mockLookupProvider();  
     * and stores the entry; safe access is carried over across refresh.  
            return engine.getStore();
        }
            // Sub-ranges count only the operations whose seqNo lies within [fromSeqNo, toSeqNo].
            assertThat(second.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
        DocumentLookupProvider provider,  
            );
            Engine.Get future = new Engine.Get(true, true, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))).version(99L);
                threads[t].start();
        }
     *       a per-operation {@code Translog#add} failure records it, not a wrapper;</li>
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            }
            // Index a doc so the engine is in a valid state.
        when(mapperService.documentMapper()).thenReturn(documentMapper);  
     */  
    private void bootstrapStoreWithMetadata(Store store, String translogUUID, long maxSeqNo) throws IOException {
                    + committedCheckpoint,
    public void testSegmentsWithIOException() throws IOException {  
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) numBatches - 1));
                final int id = t;
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        EngineConfig config = buildDFAEngineConfigWithCommitterFactory(store, translogPath, c -> committer);  
            public void beforeRefresh() {}  
            org.opensearch.index.seqno.SeqNoStats stats = engine.getSeqNoStats(totalDocs - 1);
        }
            final CyclicBarrier startGate = new CyclicBarrier(numWorkers);
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
        assertTrue("engine must be closed after a tragic translog failure", outcome.engineClosedAfterwards);
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true)) {
            0
    }  
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
                            engine.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));
                started.countDown();  
import org.apache.lucene.index.NoMergePolicy;  
    public void testRefreshFlushesPendingTranslogBatchBeforePublishing() throws IOException {  
    /** With file sizes requested, delete-tracking memory is reported as version-map memory. */
        indexingEngine.setWriterCustomizer(DataFormatAwareEngineTests::retireOnWrite);
        doReturn(2048L).when(deleteEngine).ramBytesUsed();
        ReferenceManager.RefreshListener listener = new ReferenceManager.RefreshListener() {
    }
                    engine.getProcessedLocalCheckpoint(),
    ) {
        };  
    public void testIOExceptionDuringRefreshFailsEngine() throws IOException {
    public void testFrozenEngineBlocksForceMerge() throws IOException {
            Engine.Index op = indexOp(createParsedDocWithInput("1", null));
     */
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(29L));
            .build();
        DocumentLookupProvider provider = mockLookupProvider();  
        Store store,  
                    -1,
                if (eng != null) {  
            // (translog is empty, well under threshold)  
        }
    }
            // After refresh, last refreshed checkpoint should be at the processed checkpoint
    }  
            assertThat("new doc after recovery should succeed", newResult.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                IllegalStateException.class,
                if (eng != null) {  
        final List<Exception> engineFailures;  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
                                perWorkerResults.get(workerId).add(result);  
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> deleteEngine);  
            int refreshesBefore = indexingEngine.getRefreshCallCount();  
     * listeners (beforeRefresh is always called) but afterRefresh should indicate
     * non-null {@code DocumentInput} on every doc (it calls {@code addField} for version,
package org.opensearch.index.engine;
    }  
    public void testFlushWithCommitCorruptionFailsEngineAndMarksStore() throws Exception {
     */
            synchronized (perWorkerResults) {
                    try (GatedCloseable<CatalogSnapshot> ref = eng.acquireSnapshot()) {
    }  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
                threads[t] = new Thread(() -> {
            .mergePolicy(NoMergePolicy.INSTANCE)  
        TranslogConfig translogConfig = new TranslogConfig(
            // in the backing store, which the InMemoryCommitter in tests does not do.  
                assertThat(  
            Exception failure = new FailableDataFormatAwareEngine(engine).getFailedEngine();  
        when(provider.getById(any(), any(), any(), any())).thenReturn(
                        barrier.await();
    @SuppressWarnings("unchecked")  
        DataFormatAwareEngine engine = new DataFormatAwareEngine(config);  
    }
        try {
            assertThat(
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
     * <p>The system-property gate on {@code MERGE_ENABLED_PROPERTY} applies only to  
                        engine.flush(false, false);
                threads[t].start();
        @Override
            EngineConfig config = buildDFAEngineConfig(store, createTempDir());
            List.of(new MockSearchBackEndPlugin(List.of(mockDataFormat.name())))
                try {
            assertThat("the op must be deferred into the open batch", deferred.getTranslogLocation(), nullValue());  
        @Override
    }  
        Path translogPath = createTempDir();
     * Deterministic multi-thread bulk + concurrent refresh/flush publication fence.  
            for (int i = 0; i < totalDocs; i++) {  
import org.opensearch.common.util.BigArrays;  
            assertThat(batch.finish(), equalTo(indexed.getTranslogLocation()));  
    }  
            IllegalStateException e = expectThrows(  
                            failure.compareAndSet(null, e);  
            primaryTerm.get(),
            public void onFailedEngine(String reason, Exception e) {
        // (when called from inside flush()) before flush() reads getProcessedCheckpoint().  
    public void testGetVersionFromMapUnsafePathTriggersRefresh() throws Exception {
                started.countDown();
            return new org.opensearch.index.engine.dataformat.WriteResult.Success(1L, 1L, 0L);  
     * handling methods ({@code failOnTragicEvent}, {@code maybeFailEngine}) and internal
            final Engine.IndexResult deferred = engine.index(indexOp(createParsedDocWithInput("1", null)));
            }
        return new FailingEngineResult(new DataFormatAwareEngine(config), committer);
            engine.failEngine("test failure", originalCause);
    private EngineConfig buildFailingEngineConfig(MockDataFormatPlugin plugin) throws IOException {
        }  
     */
            assertThat(second.getVersion(), equalTo(first.getVersion() + 1));
    /**
            .mergePolicy(NoMergePolicy.INSTANCE)
            assertThat("all 13 ops were processed/acked", engine.getProcessedLocalCheckpoint(), equalTo(12L));  
        // Now fail the engine
                threads[t] = new Thread(() -> {
            assertThat(engine.config().getShardId(), equalTo(shardId));  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            closersField.setAccessible(true);
            }
        // Fail with a corruption exception
            // After flush, translog generation should have rolled.
                assertThat(ref.get().getGeneration(), greaterThan(0L));
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {  
            assertThat(failure.getMessage(), containsString("simulated delete failure"));
    }
            for (int i = 0; i < n; i++) {
            assertThat(result.getTranslogLocation(), nullValue());
            // These sources are skipped while frozen (no exception, simply a no-op).
            for (int i = 20; i < 40; i++) {
            assertThat(engine.countNumberOfHistoryOperations("test", 3, 6), equalTo(4));
    public void testConcurrentFreezeAndSettingsUnfreeze_ConvergesConsistently() throws Exception {  
        );
        }  
    }
        // failEngine with null failure should still close the engine  
    public void testBeforeRefreshCalledBeforeSnapshotCommitAndAfterCalledAfter() throws IOException {
                () -> engine.index(indexOp(createParsedDocWithInput("warm", null)))  
            assertThat(second.getTranslogLocation(), nullValue());  
                workers[w] = new Thread(() -> {
     */
            }  
     * can assert the queue is fully drained on failure paths without exposing internals.
        when(documentMapper.getVersion()).thenReturn(1L);
            base.docs(),
        );
            // Index 10 docs
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {
            );
        );
            int numDocs = randomIntBetween(1, 5);
    }  
            retentionLock.close();
                assertThat(searchableFiles.size(), equalTo(1));
            engine2.flush(false, true);  
import org.opensearch.index.mapper.SeqNoFieldMapper;  
    }
            "",
    }
            int numDocs = randomIntBetween(3, 10);
            assertThat("each refresh must invoke beforeRefresh once", beforeAfterSeed, equalTo(2));  
    public void testIndexVersionConflictFromVersionMap() throws IOException {  
        }
     * <ol>  
     *   <li>the batch owner sees the same failure at {@code finish()} and the engine is closed afterwards.</li>
                assertThat(snapshot.getGeneration(), equalTo(1L));
        MockIndexingExecutionEngine indexingEngine = new MockIndexingExecutionEngine(df);
    private LiveVersionMap versionMapOf(DataFormatAwareEngine engine) throws Exception {
    }
                } catch (Exception e) {
            false  
    public void testCommitDataContainsRequiredMetadataKeys() throws IOException {  
    }  
                    }
            // Configure committer to throw CorruptIndexException on commit
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            assertThat(indexed.getTranslogLocation().compareTo(deleted.getTranslogLocation()), lessThan(0));  
            // All seqNos 0-3 marked → checkpoint advances to 3
    }  
                beforeCount.incrementAndGet();
                        if (stop.get() == false) {
            assertFalse(engine.isThrottled());
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
     * Opening a scope on a closed engine is refused with the same {@link AlreadyClosedException} its first append would
            try (GatedCloseable<IndexReaderProvider.Reader> newReaderRef = engine.acquireReader()) {
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) numDocs - 1));  
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
     */  
        Map<String, String> committedData = committer.getLastCommittedData();
                        engine.freezeForTiering();
                    } catch (Exception e) {  
                int count = 0;  
                IndexReaderProvider.Reader reader = readerRef.get();  
            primaryTerm.get(),
                indexingEngine.getRefreshCallCount(),  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
    }  
            new MockDocumentInput()  
            }  
        DocumentLookupProvider provider = mockLookupProvider();  
            Engine.IndexResult update = engine.index(indexOp(createParsedDoc("1", null)));
                "persisted checkpoint must catch up to the processed checkpoint after sync",  
        }
                "after sync, persisted should catch up to processed",
            assertEquals("4 NoOps written for gap 1..4", 4, firstFill);
            // The result depends on translog size vs threshold — with 0 ops it should be false
            assertTrue(stats.getFileSizes().isEmpty());
        } finally {
            assertTrue("root cause should be OOM", ex.getCause().getCause() instanceof OutOfMemoryError);
            }
import java.util.concurrent.atomic.AtomicBoolean;
     * Tests that engine close is graceful when concurrent index, refresh, and flush operations
                7L,
            // Re-index same doc — resolveDocVersion misses versionMap (cleared by refresh rotation),
import org.opensearch.index.translog.TranslogDeletionPolicy;
            this.commitFailure = failure;
            assertThat("afterRefresh(false) when no new segments", afterDidRefreshFalse.get(), equalTo(1));
            // Disable failure  
    public void testFlushMustNotCommitCheckpointAheadOfPersistedSnapshot() throws Exception {  
                assertTrue(TransportActions.isShardNotAvailableException(e));
            for (int i = 0; i < 20; i++) {  
            java.lang.reflect.Field currentField = maps.getClass().getDeclaredField("current");
            .internalRefreshListener(List.of())  
                } catch (Exception e) {
            @Override  
            assertThat(
            }  
                () -> engine.index(indexOp(createParsedDocWithInput("trigger-preindex", null)))
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);  
            assertThat(
                t.join();  
            try (org.opensearch.common.lease.Releasable ignored = versionMap.acquireLock(uid)) {
        // Wire an indexing engine whose writer fails on flush.
        doThrow(new IOException("simulated drain failure")).when(deleteEngine).onWriterCheckedOut(anyLong());
            engine.refresh("baseline");
            engine.refresh("test");  
                synchronized (callOrder) {
    }  
                    equalTo((long) numRefreshes + 1)
        public void updateMappingVersion(long newVersion) {}
    }
            assertTrue("doc should be found from translog", result.exists());  
        @Nullable Engine.EventListener eventListener  
                final int threadId = t;  
            .committerFactory(committerFactory)  
            engine.refresh("seed-1");
            if (failures.get() > 0) {
     */
            System.nanoTime(),
            AtomicReference<Throwable> error = new AtomicReference<>();
    /**
                sb.append(indent).append("  suppressed: ").append(s.getClass().getName()).append(": ").append(s.getMessage()).append('\n');  
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());
            int totalDocs = numThreads * docsPerThread;
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {
            assertThat("the requested op must now be published", first.getTranslogLocation(), notNullValue());  
        DocumentLookupProvider provider = mockLookupProvider();
        bootstrapStoreWithMetadata(store, uuid);
                        engine.failEngine("reason-" + id, new RuntimeException("exception-" + id));  
            new DocumentLookupResult("1", 2L, true, null, 7L, 1L, Map.of(), Map.of())
                throw new AssertionError("Unexpected exception during concurrent close", failure.get());
            for (int i = 0; i < numDocs; i++) {  
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());  
            @SuppressWarnings("unchecked")
        }  
            return writerGeneration;
            settings.put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), appendOnly);
    /** fillSeqNoGaps is idempotent — second call after the first finds nothing to do. */
    }
                t.join();  
            shardId,
                }  
            // Index more docs so next refresh has unflushed segments to process
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        PluginsService pluginsService = mock(PluginsService.class);
            for (int t = 0; t < freezers; t++) {
     * fails the engine, whichever thread happened to drain the chunk.
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
            // Index "x" again — should succeed (versionMap has version=2 from seqNo=5 entry)
                threads[t].start();
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
    private EngineConfig buildEngineConfigForPluginAndListener(  
            assertFalse("Flush thread should have stopped", flushThread.isAlive());  
            Versions.MATCH_ANY,  
        }
            assertThat(indexedAfter.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
        @Override
     */
            // recorded on the indexing engine (the new tragic-source channel).
    }
     * synchronously at the end of {@code refresh()}, i.e. after the snapshot is built but, when  
            engine.refresh("test");
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());  
                    } catch (Throwable e) {
     * A delete is written inline. With the same document still pending in this thread's batch, the engine must append  
            assertThat("injector ran inside the flush window", injectedSeqNos, equalTo(List.of(10L, 11L, 12L)));
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(5L));  
        try {
            BigArrays.NON_RECYCLING_INSTANCE,  
    ) throws IOException {  
                engine.getProcessedLocalCheckpoint(),  
            assertTrue("delete of an existing doc must report found", result.isFound());
            engine.freezeForTiering();
            for (int i = 0; i < 20; i++) {
        assertThat("refresh must fail when the drained append fails", outcome.refreshFailure, notNullValue());  
            org.opensearch.index.seqno.SeqNoStats stats = engine.getSeqNoStats(numDocs - 1);
            });
                "no op may be published before the pending read forces the append",  
            assertThat(first.getTranslogLocation(), notNullValue());  
                Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
            java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>> queue =
import java.util.concurrent.TimeUnit;
    }
        return (java.util.concurrent.ConcurrentLinkedQueue<Writer<?>>) queueField.get(engine);
            }
        } finally {
            try (GatedCloseable<CatalogSnapshot> ref = eng.acquireSnapshot()) {
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM
            MockDeleteExecutionEngine deleteEngine = getMockDeleteEngine(engine);  
    public void testGetByIdReturnsDocFromParquetAfterRefresh() throws IOException {
    public void testRefreshNeeded() throws IOException {
            assertThat(result.getSeqNo(), greaterThanOrEqualTo(0L));
            .committerFactory(committerFactory)
            Versions.MATCH_ANY,  
            }
            // writer (after the snapshot is frozen) but before the commit reads the checkpoint.
            assertThat(vv.seqNo, equalTo(0L));
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDoc("2", null))));  
            terminate(threadPool);
    public void testNewChangesSnapshotReturnsIndexedOps() throws IOException {
            }
                new DocumentLookupResult("c", 1L, true, null, 3L, 1L, Map.of(), Map.of()),  
            engineRef.set(engine);  
import org.opensearch.index.IndexSettings;
     *   <li><b>Flush phase:</b> an explicit flush + translog sync advances the PERSISTED checkpoint to the same max.</li>  
            final int numWorkers = 2;
            this.engineClosedAfterwards = engineClosedAfterwards;  
                    newReaderRef.get().catalogSnapshot().getGeneration(),
        }
    public void testPreIndexFlushDrainMarksUnpublishedDeletes() throws Exception {
    }
            try (GatedCloseable<IndexReaderProvider.Reader> readerRef = engine.acquireReader()) {
            int docsPerThread = randomIntBetween(10, 20);
        when(mapperService.documentMapper()).thenReturn(documentMapper);  
    public void testAcquireReaderAfterCloseThrows() throws IOException {  
        FailureInjectingCommitter failingCommitter = fer.committer();
                IndexReaderProvider.Reader reader = readerRef.get();
                }
            // Held snapshot should still be valid
            assertNotNull(
                    } catch (Throwable e) {  
        bootstrapStoreWithMetadata(store, uuid);
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, "-1");
            .documentLookupProvider(documentLookupProvider)
     * EXTERNAL version=3 hits isVersionConflictForWrites (IndexingStrategyPlanner) → conflict.
     * notified so it can unblock the waiting search request.  
                engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));  
        }
        try {
    }  
            Thread[] threads = new Thread[4];
            final int afterAfterSeed = afterCalls.get();
            engine.refresh("seed-2");  
     * {@code onSettingsChanged}. Only that one thread mutates index settings, so the test targets the
            // Persisted advances only once the translog is fsynced.
            engine.index(indexOp(createParsedDocWithInput("1", null)));  
            // failEngine was called with the flush IOException.
                    return new InMemoryCommitter(store);  
            engine.index(indexOp(createParsedDocWithInput("0", null)));
            final Engine.TranslogBatch batch = engine.beginTranslogBatch();  
            assertThat(result.seqNo(), equalTo(0L));
        }  
        Path translogPath = createTempDir();  
        try (Store store = createStore()) {
        // Stored document is at version 2.
import org.opensearch.index.engine.dataformat.DeleteResult;
            // Refresh to make docs visible
            long toSeqNo = 7;
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
        // Committed data should still be accessible from the committer
            assertThat(engine.index(indexOp(createParsedDoc("1", null))).getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            }
            store,  
            0
            Thread[] indexThreads = new Thread[numThreads];
    }
            return writersCreated.get();  
            .primaryTermSupplier(primaryTerm::get)
                }
    }
            assertThat(engine.lastRefreshedCheckpoint(), equalTo((long) totalDocs - 1));
            }, "force_merge-test");
            "test corruption",  
    public void testBatchedAppendDisabledIsInlineBehaviour() throws IOException {
            // Store should be marked corrupted (maybeFailEngine → Lucene.isCorruptionException → failEngine → markStoreCorrupted)
            assertThat("event listener must observe the failure", failedEngineCause.get(), notNullValue());  
            engine.refresh("test");  
                }
    }  
            // A writer that succeeds on flush with empty result (no files produced).
    }
            engine.close();
import static org.mockito.ArgumentMatchers.anyLong;
        }
                    + (persistedMaxSeqNo + 1)
            0  
            assertEquals("4 NoOps written for gap 3..6", 4, filled);  
            if (current.getCause() != null && current.getCause() != current) {
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
    }  
                    afterDidRefreshTrue.incrementAndGet();
            assertThat("no-op batch flush returns null", batch.flush(), nullValue());  
            long heldGen = ref.get().getGeneration();  
        } finally {
        }  
                genBeforeFinalRefresh = ref.get().getGeneration();
        Boolean appendOnly
            engine.index(indexOp(createParsedDocWithInput("2", null)));  
                engine.index(indexOp(createParsedDoc(Integer.toString(i), null)));
            translogPath,
                .put("index.check_pending_flush.enabled", false)  
            flushQueueOf(engine).add(new SuccessFlushWriter(42L, mockDataFormat));  
            for (Thread t : threads)  
    }
            assertThat("flush must return the batch max location", max, notNullValue());
import org.opensearch.common.unit.TimeValue;
    /** Explicit-id index with a caller-supplied version/versionType (for version-conflict tests). */
            );
            // Collect every worker's results so the main thread can assert on their published state.
        public org.opensearch.index.engine.dataformat.FileInfos flush(org.opensearch.index.engine.dataformat.FlushInput flushInput) {
                // expected
            }, 10, java.util.concurrent.TimeUnit.SECONDS);
        DocumentLookupProvider provider = mockLookupProvider();  
                    }  
                    false,
            Engine.IndexResult result = engine.index(indexOpWithIfSeqNo(createParsedDocWithInput("1", null), 99L, primaryTerm.get()));
            });
        engine.failEngine("second failure", new RuntimeException("second"));
            engine.index(appendOnlyOp(createParsedDocWithInput("2", null)));  
     * be invoked. Neither should be skipped.
            // A force flush is the prepare path and must proceed.
            // The retention lock pins a generation in the translog's deletion policy.
                engine.refresh("cycle-" + i);  
     * to observe shard-failure callbacks while exercising flush-failure paths.
                final long maxSeqNo = eng.getProcessedLocalCheckpoint();  
            int numThreads = randomIntBetween(2, 4);
            assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());  
            IllegalStateException e = expectThrows(
        private final DataFormatAwareEngine engine;
            provider,
            assertThat("toggle off must yield the shared no-op batch", batch, sameInstance(Engine.NO_OP_TRANSLOG_BATCH));
            // append for the failed index op is then rejected.  
        }
 * Tests for {@link DataFormatAwareEngine} covering the orchestration layer:  
        public WriterState state() {  
    }
            setTieringStateSetting(engine, IndexModule.TieringState.HOT);  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
                Translog.Operation op2 = snapshot.next();
            Thread[] threads = new Thread[numThreads];  
            refresher.start();
                        break;
            // Request only a subset of the range  
 * this file be licensed under the Apache-2.0 license or a
            assertTrue("store should be marked corrupted", store.isMarkedCorrupted());
        final DrainFailureOutcome outcome = driveRefreshDrainOfFailedBatchAppend(tragic, FailingBatchAppendTranslog.FailureClass.TRAGIC);
            }
            indexSettings,
                    assertFalse("every worker must terminate (no deadlock)", worker.isAlive());
            assertThat("flushQueue must be drained on failure", flushQueueSize(engine), equalTo(0));
     * writers frozen at {@code checkoutAll} — and then commits
                        final Engine.TranslogBatch batch = engine.beginTranslogBatch();
            Translog.Location expectedMax = null;
            engine.refresh("setup");  
    private static boolean unpublishedDeletesOf(DataFormatAwareEngine engine) throws Exception {
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
        AtomicReference<DataFormatAwareEngine> engineRef = new AtomicReference<>();  
            assertThat(first.getTranslogLocation().compareTo(second.getTranslogLocation()), lessThan(0));
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);  
                for (org.opensearch.index.engine.exec.Segment segment : snapshot.getSegments()) {
        return new Engine.Index(  
     */
        return buildDFAEngineConfig(store, translogPath, externalListeners, internalListeners, tieringState, null);
            throws IOException {
                assertThat(snapshot.getSegments().size(), equalTo(1));
            assertEquals(4L, engine.getSeqNoStats(SequenceNumbers.NO_OPS_PERFORMED).getMaxSeqNo());
        assertFalse("store should NOT be marked corrupted for non-corruption failures", store.isMarkedCorrupted());
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo((long) numDocs - 1));
            new DocumentLookupResult("1", 1L, true, null, 0L, 1L, Map.of(), Map.of())
            MockIndexingExecutionEngine mockExecEngine = getMockExecutionEngine(engine);  
            // Unrecognized value is treated as not frozen — indexing still works.
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            // Refresh catches ACE → failOnTragicEvent → detect engine tragic → failEngine
            expectThrows(VersionConflictEngineException.class, () -> engine.getById(future, (source, scope) -> null));  
            .build();
            long persisted = engine.getPersistedLocalCheckpoint();
    public void testDeleteWithoutDeleteCapableFormatFailsOperationNotEngine() throws IOException {  
                    try {  
            // Index should succeed — preIndex is disabled so the failing writer is never polled.  
import org.opensearch.index.seqno.RetentionLeases;
            }  
            new Term(IdFieldMapper.NAME, Uid.encodeId(id)),  
            AtomicInteger failures = new AtomicInteger(0);
                            engine.index(indexOp(createParsedDocWithInput(threadId + "_" + d, null)));  
            return delegate.getLastCommittedData();
                indexThreads[t] = new Thread(() -> {
    }
    public void testEngineConfig() throws IOException {  
            AtomicReference<Throwable> error = new AtomicReference<>();  
     * fails with {@code failure}, either tragically (translog records it and closes) or not.
        expectThrows(AlreadyClosedException.class, () -> engine.index(indexOp(createParsedDocWithInput("1", null))));
import java.util.List;  
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, true, false)) {
        }  
            engine.index(indexOp(createParsedDocWithInput(Integer.toString(i), null)));
                    first = result;  
     * bulk scope to append its chunk, publishing the pending ops only after the translog append.
        Path translogPath,  
            // Trigger failure via refresh  
            });
            engine.index(indexOp(createParsedDocWithInput("2", null)));
            engine.freezeForTiering();
        }
            return new RefreshResult(result.refreshedSegments(), dropped);  
            engine.index(appendOnlyOp(createParsedDocWithInput("1", null)));
        } finally {
            doc,  
            int docsPerThread = randomIntBetween(10, 30);
            Versions.MATCH_ANY,
                            Engine.IndexResult result = engine.index(indexOp(doc));  
            assertTrue("Writer should be queued for deferred close", pendingClosers.contains(successWriter));
        java.lang.reflect.Field queueField = DataFormatAwareEngine.class.getDeclaredField("flushQueue");
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {  
            int numBatches = randomIntBetween(3, 6);
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(config)) {  
    }
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(mockDataFormat.name());
            // Before refresh, last refreshed checkpoint hasn't advanced  
        while (current.getCause() != null && current.getCause() != current) {  
     * translog location stays deferred while the batch is open. The workers then park on a gate, holding their scopes
            );
            current = current.getCause() == current ? null : current.getCause();
     */  
            Engine.Delete delete = engine.prepareDelete(
                    throw new RuntimeException(e);  
        bootstrapStoreWithMetadata(store, uuid);  
            try (Translog.Snapshot snapshot = engine.newChangesSnapshot("replay", 0, totalOps - 1, false, true)) {  
                    }
        try (DataFormatAwareEngine engine = createDFAEngineWithLookupProvider(store, createTempDir(), provider)) {
            "test",
            assertFalse(getByIdLookup(engine, realtimeGet("del")).exists());
            );  
            // Sync translog so persisted checkpoint advances
            try {
            vmField.setAccessible(true);
            flushQueueOf(engine).add(queuedWriter);  
        return new Engine.Delete(  
            // Append-only under active safe access still stores the entry.
            assertThat(delete.getIfSeqNo(), equalTo(7L));  
            public void beforeRefresh() {
            engine.refresh("second");
            assertNotNull(
     *   <li>Two ops ("1","2") are indexed into the SAME pending chunk. Before the GET, both must be unpublished
            sb.append(indent).append(current.getClass().getName()).append(": ").append(current.getMessage()).append('\n');
    }
            .indexSettings(indexSettings)  
                            if (result.getResultType() == Engine.Result.Type.SUCCESS) {
        }
    @Override
            for (Thread t : threads)
    }  
            assertThat("all 10 docs should be committed", engine.getProcessedLocalCheckpoint(), equalTo(9L));
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                IllegalStateException.class,
                        engine.translogManager().syncTranslog();
                } catch (Throwable t) {
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo((long) totalDocs - 1));
            // A writer whose flush succeeds with no files, so only the drain can mark deletes.
    public void testReplayedDeleteFromTranslogSkipsEngine() throws Exception {  
                        setTieringStateSetting(engine, IndexModule.TieringState.HOT_TO_WARM);
                final boolean doFlush = t % 2 == 0;  
            public void afterRefresh(boolean didRefresh) {  
     * no pending queue, and {@code onMergesDrained} fires the listener immediately
            Engine.Index op = indexOp(createParsedDocWithInput("1", null));
    private DocumentLookupProvider mockLookupProvider() throws IOException {
                        assertThat("each worker must get a real (non-no-op) batch", batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
            eng.refresh("verify-still-open");
        Engine.EventListener listener = new Engine.EventListener() {
        });
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
     */  
        );  
                });  
    }  
            // While the lock is held there is an open translog reference pinning a generation.  
                @Override  
                // Each segment should have exactly 1 file with 1 row (1 doc per batch)  
            MockDeleteExecutionEngine deleteEngine = getMockDeleteEngine(engine);
    }
    private static Throwable rootCause(Throwable t) {
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
            indent += "  ";  
    private EngineConfig buildDFAEngineConfig(Store store, Path translogPath, DocumentLookupProvider documentLookupProvider) {
        public WriterState state() {
            }  
        engine.flushAndClose();  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
    }
        try {  
        }
            assertThat(engine.getPersistedLocalCheckpoint(), equalTo((long) numDocs - 1));
            shardPath,  
                        engine.refresh("background-" + i);
                t.join();
                        barrier.await();
            assertFalse("deleting a never-indexed doc must report not found", result.isFound());  
            engine.index(indexOp(createParsedDocWithInput("1", null)));
        // (InMemoryCommitter doesn't persist commit data to store, so checkpoint reflects
            assertTrue(stats.getIndexWriterMemoryInBytes() >= 0);
     * </ul>
     * leaking its LuceneWriter's NativeFSLock in LOCK_HELD.
            }
            engine.refresh("prepare_tiering");
     * the engine ends frozen (a primary index op is rejected).  
                try {  
            Settings.builder()
    }  
     *  
            eng.refresh("final");
            // Verify engine failed exactly once (first caller wins)  
            assertThat(first.getTranslogLocation(), nullValue());
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());  
    public void testBatchedAppendSelfReadFlushesPending() throws IOException {  
     * Batch on: N index ops executed inside a batch defer their translog append. Before flush, no result has a  
        } finally {  
                }
        try (DataFormatAwareEngine engine = new DataFormatAwareEngine(buildFailingEngineConfig(noDeletePlugin, listener))) {
            // Writer stayed ACTIVE → engine must remain open for subsequent operations.  
        // Bootstrap with maxSeqNo=3, localCheckpoint=-1 (triggers restore)
            } catch (AlreadyClosedException e) {  
            }
            Engine.DeleteResult deleted = engine.delete(deleteOp("del"));
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
                far,
import static org.hamcrest.Matchers.lessThan;  
    private Engine.Get realtimeGet(String id) {
            }
     * B: optimistic-concurrency conflict on the write path. After indexing id "1" (seqNo 0), an index
    }  
                assertThat("gen1 must be committed", ref.get().getSegments().size(), greaterThanOrEqualTo(1));
            int numDocs = randomIntBetween(3, 10);
            droppedRefreshCount.incrementAndGet();
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
        int numDocs = randomIntBetween(3, 10);
                assertThat(reader.reader(mockDataFormat), notNullValue());
                new FailableDataFormatAwareEngine(engine).getFailedEngine()
            return state;
        Exception getFailedEngine() {  
    static class FailableDataFormatAwareEngine implements java.io.Closeable {
                        failures.incrementAndGet();
    public void testGetByIdThrowsWhenNoProvider() throws IOException {
    public void testAcquireReaderBeforeRefreshReturnsEmptyReaders() throws IOException {
        }
            Settings.builder()
     *       wrongly consider in-flight (no orphan writers waiting for nobody).</li>  
     *   <li>The shared {@code flushQueue} must not leak items that the next refresh would
        Path translogPath,  
    // --- Test: operations after failEngine throw AlreadyClosedException with original cause ---  
            engine.refresh("test");
        private final InMemoryCommitter delegate;  
            return writerGeneration;
        try {  
        engine.close();
                engine.refresh("test");
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        assertThat("the recorded engine failure must be the tragic exception itself", outcome.engineFailures.get(0), sameInstance(tragic));  
            @Override  
        }  
            .mergePolicy(NoMergePolicy.INSTANCE)
            assertThat(engine.countNumberOfHistoryOperations("test", 7, Long.MAX_VALUE), equalTo(3));
            );
 * from any specific data format implementation.</p>
    /**
            .store(store)
        ReferenceManager.RefreshListener listener = new ReferenceManager.RefreshListener() {
            engine.index(indexOp(createParsedDoc("1", null)));  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
     * i.e. the operations actually yielded by the changes snapshot for that range, not the raw operation  
                    callOrder.append('B');  
        bootstrapStoreWithMetadata(store, uuid, 3L);
        } finally {
import org.opensearch.core.index.shard.ShardId;  
            this.writerGeneration = writerGeneration;  
        PluginsService pluginsService = mock(PluginsService.class);  
            }  
            "test",
        bootstrapStoreWithMetadata(store, uuid, 5L);
            );  
            assertThat(
            ifPrimaryTerm
                        genSeenInBefore.set(ref.get().getGeneration());
        DocumentLookupProvider provider = mock(DocumentLookupProvider.class);  
    public void testCountNumberOfHistoryOperationsSubRange() throws IOException {
            // Refresh → AlreadyClosedException with original cause
            FailableDataFormatAwareEngine failable = new FailableDataFormatAwareEngine(engine);
        try (DataFormatAwareEngine engine = createBatchDFAEngine(store, createTempDir(), provider, false)) {  
import org.opensearch.index.translog.InternalTranslogManager;
            armed.set(true);
            false  
    }
                versionMap.putIndexUnderLock(uid, new IndexVersionValue(bogusLocation, 6L, 3L, 1L));
            state = WriterState.CLOSED;  
            "",
            AtomicInteger failures = new AtomicInteger(0);
                new DocumentLookupResult("a", 1L, true, null, 0L, 1L, Map.of(), Map.of()),  
    }  
            .indexSettings(indexSettings)
                versionMap.putIndexUnderLock(uid, new IndexVersionValue(null, 5L, 0L, 1L));
    @SuppressWarnings("unchecked")
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(df)
                threads[t].start();
                greaterThan(0)
                assertThat(snapshot, notNullValue());  
    private static List<Throwable> allSuppressed(Throwable t) {  
            Engine.Get getForDelete = realtimeGet("1");
            assertFalse("no writer has been drained yet", unpublishedDeletesOf(engine));  
            engine.freezeForTiering(); // second call must be a no-op, not throw  
        }
            if (refresher.isAlive()) {
            }
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("x", null)));
            for (int i = 0; i < 5; i++) {
                        // flush may be disabled during translog recovery or after close
            }
        }
                .build()
        }
            this.delegate = new InMemoryCommitter(store);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            // Verify engine failed  
    }  
import static org.mockito.Mockito.spy;
            }
            // (ops are in translog buffer but not yet fsync'd)
     * Use case: The ordering contract — beforeRefresh is called BEFORE the catalog  
            engine.refresh("test");  
            writer.setState(WriterState.RETIRED_FLUSHABLE);
        return new DataFormatAwareEngine(buildDFAEngineConfig(store, translogPath));
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            SegmentsStats stats = engine.segmentsStats(false, false);
     */
    /**
    /**
     * Same-thread realtime GET of a doc whose translog location is still pending (indexed earlier in the same batch  
            engine.translogManager().syncTranslog();
            // Phase 1 -- pending: nothing is published before the fence, even though all seqNos are assigned.  
        engine.failEngine("non-corruption test", new RuntimeException("simulated"));
                        for (int d = 0; d < docsPerThread; d++) {  
            .threadPool(threadPool)
            }
    }
                (java.util.concurrent.ConcurrentLinkedQueue<org.opensearch.index.engine.dataformat.Writer<?>>) queueField.get(engine);  
            for (int i = 0; i < numDocs; i++) {  
                // Seed cycles contribute "BABA"; the merge must append nothing for this listener.  
     * Builds an EngineConfig using a real DataFormatRegistry built from the given plugin,  
        expectThrows(AlreadyClosedException.class, engine::acquireReader);  
            // Reader should have format-specific reader
                () -> engine.index(indexOp(createParsedDocWithInput("0", null)))  
                        barrier.await();  
            failingCommitter.setCommitFailure(new IOException(new OutOfMemoryError("fake OOM during commit")));
            VersionType.INTERNAL,  
import org.opensearch.index.shard.ShardPath;
        EngineConfig config = buildFailingEngineConfig(plugin);
                assertThat("snapshot should contain all indexed ops", count, equalTo(numDocs));  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
import org.opensearch.index.mapper.ParsedDocument;
        private final MockDataFormat dataFormat;
    }
                    Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
        Store store,
            engine.refresh("setup");
            vmField.setAccessible(true);  
            Translog.Location finalMax = batch.finish();  
                assertThat(snapshot.getSegments().get(0).dfGroupedSearchableFiles().containsKey(mockDataFormat.name()), equalTo(true));
            engine.index(indexOp(createParsedDoc("1", null)));  
            assertThat(count, greaterThan(0));
        try {
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
import org.opensearch.Version;
                versionMap.putDeleteUnderLock(uid, new DeleteVersionValue(3L, 2L, 1L, 1L)); // time=1ms (epoch start, expired)
     */  
    }
     */
    private ShardId shardId;
            engine.index(recoveryOp);
            // Index more docs so next refresh has unflushed segments  
                assertThat(
            AtomicInteger failures = new AtomicInteger(0);
        try (DataFormatAwareEngine eng = new DataFormatAwareEngine(config)) {  
            engine.translogManager().syncTranslog();
            deletionPolicy.assertNoOpenTranslogRefs();
            for (int i = 0; i < numDocs; i++) {  
        assertTrue("store should be marked corrupted", store.isMarkedCorrupted());
            // Tiering cancelled — state returns to HOT, engine unfreezes and indexing resumes.
            engine2.refresh("post-recovery");
            assertTrue(deleteEngine.deletedIds().isEmpty());  
            );
            }
            engine.index(indexOp(createParsedDocWithInput("0", null)));
                threads[t] = new Thread(() -> {  
    }
     *   <li>Close the failing writer via {@code IOUtils.closeWhileHandlingException}.</li>  
    public void testRefreshListenerNotifiedWhenNewDataBecomesSearchable() throws IOException {
            false
        DataFormatAwareEngine engine = createDFAEngine(store, createTempDir());  
                        eng.refresh("concurrent-refresh-" + i);
            engine.failEngine(reason, failure);  
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(1L));
        DataFormatRegistry registry = createMockRegistry();
    public void testGetByIdReturnsDocFromTranslog() throws IOException {
     * straight to {@code MergeScheduler.forceMerge} and does not consult it, so this
            }  
     * test drives the merge end-to-end without touching system properties.  
        } finally {
            VersionType.INTERNAL,
                assertThat(reader.catalogSnapshot(), notNullValue());
        String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
    }  
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
                try {
                    try {
    }
        return new DataFormatAwareEngine(buildBatchDFAEngineConfig(store, translogPath, provider, enabled, remoteStore, appendOnly));  
    public void testAcquireReaderSnapshotMatchesLatestRefresh() throws IOException {  
     * An unmodelled {@link IOException} from the delete engine travels through  
     */
    }  
    }
    public void testGetByIdFromSegmentsWithoutPreconditionIsUnaffected() throws IOException {  
            System.nanoTime(),
            try (GatedCloseable<CatalogSnapshot> newRef = engine.acquireSnapshot()) {  
    }
    /**
    }
     */
    }  
            settings.put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), appendOnly);
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            // indexingExecutionEngine.refresh() which throws, then failEngine is called
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
    }
                indexThreads[t].start();  
        when(provider.getDocsAboveSeqNo(anyLong(), any(), any(), any())).thenReturn(
            }
            engine.index(indexOp(createParsedDocWithInput("1", null)));
            }  
            Thread refreshThread = new Thread(() -> {
            final int numDocs = 5;  
    public void testLocalCheckpointAdvancesCorrectly() throws IOException {
import org.opensearch.indices.replication.common.ReplicationType;
        );  
                    + committedCheckpoint
        bootstrapStoreWithMetadata(store, uuid);
        }  
import static org.hamcrest.Matchers.not;
    public void testSegmentsStatsReturnsValidStats() throws IOException {  
                    }  
     * <ul>
     */
            // Index one more doc to ensure a writer exists in the pool after flush
    /** Creates a DFA engine whose index settings already carry the given tiering state (freeze-on-open path). */
        }
            }
        MockDataFormatPlugin noDeletePlugin = MockDataFormatPlugin.of(mockDataFormat).withDeleteExecutionEngine(committer -> null);
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {  
        Settings.Builder settings = Settings.builder()  
        try {
     * count of the underlying translog generations.
        when(provider.getById(any(), any(), any(), any())).thenReturn(
            queueField.setAccessible(true);
            primaryTerm.get(),
    ) {
                while (stop.get() == false) {  
            engine.translogManager().recoverFromTranslog(ignore -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
            assertTrue("cause should be CorruptIndexException", thrown.getCause() instanceof org.apache.lucene.index.CorruptIndexException);
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
        }  
        }  
        }
            try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            for (int i = 0; i < 10; i++) {
                assertThat(snapshot.getSegments().size(), equalTo(1));
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
        EngineConfig config = buildDFAEngineConfig(store, translogPath, List.of(listener), List.of());
    @SuppressForbidden(reason = "test needs reflective access to inject a failing writer into flushQueue")
            // Sanity: the refreshLock must have been released. A follow-up refresh must
    }
                assertThat("merge must not append before/after for a non-remote-store listener", callOrder.toString(), equalTo("BABA"));
            expectThrows(AlreadyClosedException.class, engine::ensureOpen);
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
        }
            // failEngine ran with the originating exception.
            .internalRefreshListener(internalListeners)
            // Index more docs
                if (didRefresh) {
            assertThat("writer should have been used", failingEngine.writersCreated(), greaterThanOrEqualTo(1));
            int numThreads = randomIntBetween(3, 6);
            }  
        Path translogPath,
        DocumentLookupProvider provider = mockLookupProvider();
        }
            Thread[] threads = new Thread[numThreads];
    @SuppressForbidden(reason = "test utility needs reflective access to verify internal queue state")
        void setCommitFailure(IOException failure) {
                IllegalStateException.class,  
                assertThat(wfs.directory(), notNullValue());
    public void testBatchedAppendRequiresRemoteStore() throws IOException {
        try (DataFormatAwareEngine engine = createDFAEngine(store, createTempDir())) {
            current = current.getCause();
            Engine.IndexResult result = engine.index(indexOp(createParsedDocWithInput("1", null)));
        engine.close();
            int numDocs = randomIntBetween(10, 20);
