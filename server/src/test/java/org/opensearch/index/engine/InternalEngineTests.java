                    testDocumentWithTextField("test"),
                        throw new OpenSearchException("something completely different");
                }
        } finally {
                null,
            0
        }
    }
    // #8603: make sure we can separately log IFD's messages
     * replay can never resurrect the document. Also checks the realtime GET after the delete and the sync location.
    public void testMergeSegmentsOnCommitIsDisabled() throws Exception {
                assertThat(collector.getTotalHits(), equalTo(1));
                // holding the lock that pruneTombstones needs and we have a deadlock
            assertThat(segments.get(1).getDeletedDocs(), equalTo(deletes)); // delete tombstones
            @Override
            TranslogHandler translogHandler = createTranslogHandler(initialEngine.config().getIndexSettings(), recoveringEngine);
            final ParsedDocument doc = testParsedDocument("new" + id, null, testDocumentWithTextField(), SOURCE, null);
            assertSame(leftLeaves.get(i).reader(), rightLeaves.get(i).reader());
                    System.nanoTime(),
                    if (randomBoolean()) {
            searchResult,
        if (randomBoolean()) {
                engine.refresh("test");
        engine.index(indexForDoc(doc));
                    engine.ensureOpen();
            .put(defaultSettings.getSettings())
                engine.index(indexForDoc(doc));
                        if (randomBoolean() && lastOpSeqNo != SequenceNumbers.UNASSIGNED_SEQ_NO && docDeleted == false) {
                        assertAndGetInternalTranslogManager(engine.translogManager()).getTranslogUUID(),
            delete.getIfPrimaryTerm(),
                Engine.Searcher searchSearcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)
            Engine.IndexResult indexResult = engine.index(operation);
                engine.index(indexForDoc(createParsedDoc(Integer.toString(i), null)));
            existingSeqNos.add(result.getSeqNo());
        // now do an update
            InternalEngine engine = createEngine(
                                testDocument(),
        concurrentlyApplyOps(allOps, engine);
            firstIndexRequest.primaryTerm(),
                    if (ex.getCause() != null) {
        List<LeafReaderContext> rightLeaves = OpenSearchDirectoryReader.unwrap(right.getDirectoryReader()).leaves();
            final long gen2 = store.readLastCommittedSegmentsInfo().getGeneration();
                        startGun.await();
    public void testCriteriaBasedGrouping() throws Exception {
                TranslogHandler translogHandler = createTranslogHandler(config.getIndexSettings(), engine);
    }
                                assertFalse("Document " + docId + " should not exist", get.exists());
 * SPDX-License-Identifier: Apache-2.0
            );
                engine.index(indexForDoc(doc));
            "test",
        assertThat(batchEngine.getProcessedLocalCheckpoint(), equalTo(NO_OPS_PERFORMED));
import org.opensearch.index.translog.LocalTranslog;
    // sent to lucene.iw with log level TRACE:
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            .put(defaultSettings.getSettings())
                newUid("del"),
                        null, // No source, it should be derived
    }
                        if (operation instanceof Translog.Index) {
            "1",
                            if (values.advanceExact(docID) == false) {
            Store store = createStore();
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexSettings.getIndexMetadata())
            REPLICA,
                    @Override
                }
            // delete
            operation.uid(),
            VersionType.INTERNAL,
                }
        TriFunction<Long, Long, Engine.Delete, Engine.Delete> delWithSeq = (seqNo, term, delete) -> new Engine.Delete(
                }
import static org.hamcrest.Matchers.containsString;
        batch.finish();
                }
                engine.flush(true, true);
        final int cap = engine.config().getIndexSettings().getTranslogBatchAppendMaxOperations();
                    continue;
                    assertThat(indexResult.getVersion(), equalTo(1L));
            ParsedDocument doc = testParsedDocument("1", null, testDocument(), B_1, null);
                    indexSettings.getTranslogRetentionSize(),
        final int numOps = scaledRandomIntBetween(100, 10_000);
        }
        };
            assertThat(segments.size(), equalTo(2));
            writer.getLiveCommitData().forEach(e -> userData.put(e.getKey(), e.getValue()));
            final String translogUUID = Translog.createEmptyTranslog(
        engine.refresh("test");
     * <p>The bug was that {@code getSegmentFileSizes} used {@code Map.put(extension, length)},
            1,
                    engine.translogManager().syncTranslog();
    public void testNonInternalVersioningOnPrimary() throws IOException {
                    lastOpTerm = UNASSIGNED_PRIMARY_TERM;
            assertEquals(totalNumDocs, searcher.getIndexReader().numDocs());
                        throw new AssertionError(e);
    }
                        () -> engine.translogManager()
            Engine.GetResult getResult = engine.get(newGet(true, doc), searcherFactory);
                            Long.parseLong(safeCommit.getUserData().get(SequenceNumbers.MAX_SEQ_NO)),
            Engine.IndexResult retryResult = engine.index(retry);
                .field("type", "text")
                    document.add(new TextField("value", "updated", Field.Store.YES));
            final String message = "Error while deleting unreferenced file *";
                    engine.index(indexForDoc(createParsedDoc(id, null)));
                } else {
            current = current.getCause() == current ? null : current.getCause();
    }
            AtomicReference<AddIndexesFailingIndexWriter> throwingIndexWriter = new AtomicReference<>();
                    for (int i = 0; i < numDocsPerThread; i++) {
        engine.delete(new Engine.Delete("1", newUid(doc), primaryTerm.get()));
                    assertEquals(0L, engine.translogManager().getTranslogStats().getUncommittedOperations());
                );
                config(indexSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get)
    }
            try (InternalEngine engine = new InternalEngine(config)) {
        }
                    () -> engine.noOp(
            } else {
        engine.index(indexForDoc(doc));
                }
            )
                    null,
            final SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
            Settings.builder()
            }
                prevDocs = getDocIds(engine, true);
        assertThat(indexResult.getResultType(), equalTo(Engine.Result.Type.FAILURE));
            // start the indexing threads
            engine.index(primaryResponse);
            long currentMaxSeqNoOfUpdates = engine.getMaxSeqNoOfUpdatesOrDeletes();
                equalTo(primarySeqNo)
        }, "batched-realtime-get");
        assertThat(indexed.getTranslogLocation().compareTo(deleted.getTranslogLocation()), lessThan(0));
        engine.close();
        assertTrue("engine must be closed", batchEngine.isClosed.get());
            for (String file : snapshot.get().files(false)) {
                engine.refresh("test", Engine.SearcherScope.INTERNAL, true);
        engine.onSettingsChanged(
            failureToThrow.set(failureSupplier);
            Engine engine = createEngine(
            assertEquals(
            int numDocs = scaledRandomIntBetween(10, 100);
            doc,
                try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", from, to, false, true)) {
                        throw new AssertionError("Document does not have a seq number: " + docID);
    public void testSyncedFlushSurvivesEngineRestart() throws IOException {
        for (int id = 0; id < numDocs; id++) {
            assertThat(noOpEngine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(gapsFilled));
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
                        null, // No source, it should be derived
            @Override
                try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", from, to, false, true)) {
     */
            update.primaryTerm(),
            int copies = frequently() ? 1 : between(2, 4);
                int to = randomIntBetween(from, operations.size() - 1);
        }
                }
    }
                    i,
            .settings(
                config.getTranslogConfig().getBigArrays(),
            engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            for (int i = 0; i < 10; i++) {
                        false,
            retry,
        ) {
                        -1,
                } else {
                        + "]";
        ).v1();
        // in one segment cause PerFieldPostingsFormat to write two file groups that share
            }
        assertThat(indexResult.getVersion(), equalTo(1L));
            if (randomBoolean()) {
                        holder = createEngine(store, translogPath);
        ThrowingIndexWriter(Directory d, IndexWriterConfig conf) throws IOException {
import org.opensearch.core.common.bytes.BytesArray;
    private static List<Throwable> allSuppressed(Throwable t) {
                    index.origin(),
            } else {
                } else {
        assertThat(first.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                engine.index(indexForDoc(doc2));
    /**
                    VersionType.EXTERNAL,
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                                    )
        MockLogAppender mockAppender = MockLogAppender.createForLoggers(Loggers.getLogger(Engine.class, shardId));
            long localCheckpoint = engine.getProcessedLocalCheckpoint();
            int numSnapshots = between(1, 10);
            int totalNumDocs = numDocs - numDeletes.get();
            public CustomTranslogDeletionPolicy(IndexSettings indexSettings, Supplier<RetentionLeases> retentionLeasesSupplier) {
                prevMaxSeqNo = maxSeqNo;
            if (create) {
            throw new AssertionError(ex);
        final BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory = engine::acquireSearcher;
            assertThat(Long.parseLong(stats1.getUserData().get(SequenceNumbers.MAX_SEQ_NO)), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            }
    }
                engine.flush();
        }
    }
                maxSeqNo = engine.getLocalCheckpointTracker().getMaxSeqNo();
            return bitSet;
        engine = createEngine(configWithCustomTranslogDeletionPolicyFactory);
                        false,
import org.opensearch.index.mapper.ParseContext.Document;
            for (int i = commits.size() - 1; i >= 0; i--) {
                        System.nanoTime(),
            // Try to index uid=1 with a too-old version, should fail:
                );
        }
            Store store = createStore(wrapper);
            long unreferencedFileCleanUpsPerformed = engine.unreferencedFileCleanUpsPerformed();
        MatcherAssert.assertThat(
            }
            "1",
            for (String file : files) {
            ParsedDocument doc2 = testParsedDocument("2", null, testDocumentWithTextField(), B_2, null);
        syncFlush(indexWriterHolder.get(), engine, syncId);
                    getters[t].start();
                assertNull(indexResult.getFailure());
            100,
            @Override
                engine.index(indexForDoc(doc3));
                    } catch (InterruptedException e) {
                        } catch (AlreadyClosedException ex) {
                    engine.index(indexForDoc(testParsedDocument("blocked", null, testDocumentWithTextField(), SOURCE, null)));
            Store store = createStore();
        final AtomicBoolean exists = new AtomicBoolean(false);
                seqNo++;
        while (done.get() == false) {
            recoveringEngine = new InternalEngine(config);
                if (op.versionType().isVersionConflictForWrites(highestOpVersion, op.version(), docDeleted) == false) {
            engine.close();
            0,
            );
                            String docId = ((Translog.Delete) operation).id();
            lastFieldValueDoc2 = null;
            Engine.Index index = (Engine.Index) lastOpDoc1;
                        id,
                                }
            }
                        result = engine.delete(delWithVersion.apply(correctVersion, delete));
        }
                boolean stop = false;
        try (GatedCloseable<SegmentInfos> snapshot = engine.getSegmentInfosSnapshot()) {
            engine.refresh("test");
        } finally {
            );
                // Update some remaining documents
        );
                    parsedDocument,
    private ToLongBiFunction<Engine, Engine.Operation> getStallingSeqNoGenerator(
        try {
            .queryCachingPolicy(config.getQueryCachingPolicy())
            );
        }
                if (randomBoolean()) {
                    engine.index(update);
        Randomness.shuffle(operations);
                        assertEquals(msg, ((Translog.Index) op).source(), B_1);
            allowMarkProcessed.countDown();
                0
                .startObject()
            "",
            Engine.Index firstIndexRequest = new Engine.Index(
                }
        if (contextAwareEnabled == true) {
                    getters[t] = new Thread(() -> {
                engine.refresh("test");
            Settings.builder().put(defaultSettings.getSettings()).put(EngineConfig.INDEX_USE_COMPOUND_FILE.getKey(), false).build()
            }
                            Translog.Index indexOp = (Translog.Index) operation;
        MockAppender(final String name) throws IllegalAccessException {
                        false,
                1L,
            final ParsedDocument doc1 = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
            index = indexForDoc(doc);
                seqNo = docIdAndSeqNo.seqNo;
        final AtomicBoolean flushFinished = new AtomicBoolean(false);
            if (committed) {
            refresher.join(TimeValue.timeValueSeconds(30).millis());
        try (
     */
            List<DeleteVersionValue> tombstones = new ArrayList<>(tombstonesInVersionMap(engine).values());
                    lastOpSeqNo = UNASSIGNED_SEQ_NO;
            null,
        final AtomicReference<FailingBatchAppendTranslog.ArmedFailure> armedFailure = new AtomicReference<>();
                .queryCachingPolicy(config.getQueryCachingPolicy())
                    0
                }
            }
                indexSettings.updateIndexMetadata(IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build());
        engine.index(indexForDoc(doc));
            // Again, with TRACE, which should log IndexWriter output:
                            "Number of documents in shard " + shardId + " exceeds the limit of [" + maxDocs + "] documents per shard"
            .circuitBreakerService(config.getCircuitBreakerService())
     */
                .endObject()
            for (int i = 0; i < docs; i++) {
                            false,
        // Create mapping with required fields
                equalTo(globalCheckpoint)
        indexer.start();
            }
            )
                assertNull(retryResult.getTranslogLocation());
            BigArrays.NON_RECYCLING_INSTANCE,
            switch (type) {
                shardId,
                } else {
            super(name, RegexFilter.createFilter(".*(\n.*)*", new String[0], false, null, null), null);
                    0
            index.origin(),
            }
     *
            engine.flush(true, true);
                    if (flushAndClose) {
import org.opensearch.index.seqno.LocalCheckpointTracker;
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            assertTrue(get.exists());
                engine.refresh("test");
                    globalCheckpoint::get,
                if (seqNo == blockedSeqNo.get()) {
        engine.refresh("test");
                .translogConfig(base.getTranslogConfig())
                        assertTrue(
            testDocumentWithTextField(),
                // Test snapshot with accurate count
            assertThat(segments, hasSize(1));
    public void testDoubleDeliveryPrimary() throws IOException {
        }
    /**
     * is guaranteed to already have a durable translog record.
                    engine.refresh("test");
            );
                        }
            autoGeneratedIdTimestamp,
            assertThat(
            assertThat(segments.get(0).getNumDocs(), equalTo(liveDocsFirstSegment.size()));
        CyclicBarrier barrier = new CyclicBarrier(1 + closingThreads.length + 1);
            EngineConfig config = copy(replicaEngine.config(), globalCheckpoint::get);
    /**
                engine.config().getCircuitBreakerService()
            }
            assertThat(tombstonesInVersionMap(engine).values(), containsInAnyOrder(tombstones.toArray()));
                    assertThat(
                config(indexSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get)
    public void testRefreshNotNeededWhenIdleAndCheckpointCaughtUp() throws IOException {
            gcpTracker.markAllocationIdAsInSync(initializingReplica.allocationId().getId(), replicaLocalCheckpoint);
            assertEquals(2, get.version());
            wrapper.setRandomIOExceptionRateOnOpen(randomDouble());
        CodecService codecService = new CodecService(null, engine.config().getIndexSettings(), logger, List.of());
        for (int threadNum = 0; threadNum < numIndexingThreads; threadNum++) {
            IOUtils.close(recoveringEngine);
            new BytesArray("{}".getBytes(Charset.defaultCharset())),
                engine.close();
            refreshThreads[i].start();
        assertThat(second.getTranslogLocation(), nullValue());
                null,
        MatcherAssert.assertThat(
                    new BytesArray("{}".getBytes(Charset.defaultCharset())),
        }
            }
            Thread t = new Thread(r);
                assertEquals(10, getSearcher.getIndexReader().numDocs());
        } catch (Exception ex) {
        engine.delete(new Engine.Delete(Integer.toString(randomId), newUid(doc), primaryTerm.get()));
                final List<RetentionLease> leases = new ArrayList<>(length);
                final ParsedDocument doc = testParsedDocument(
            Engine engine = createEngine(config(indexSettings, store, createTempDir(), keepSoftDeleteDocsMP, null))
import org.opensearch.test.MockLogAppender;
                    throwingIndexWriter.get().setThrowFailure(() -> new IOException("simulated"));
                    fail();
                Engine.Index primaryResponse = indexForDoc(doc);
            ParsedDocument doc3 = testParsedDocument("3", null, testDocumentWithTextField(), B_3, null);
                // Test snapshot with accurate count
                Engine.IndexResult result = engine.index(index);
                }
            null
                docs = getDocIds(engine, true);
 * software distributed under the License is distributed on an
            equalTo(inSync ? 3L : 2L)
                    assertFalse(getResult.exists());
    private static void updateIndexSettings(IndexSettings indexSettings, Settings.Builder settingsBuilder) {
                engine.getSeqNoStats(-1).getMaxSeqNo() + deleteBatch
            }
        Map<String, Engine.Operation> latestOps = new HashMap<>(); // id -> latest seq_no
            return testParsedDocument("1", null, document, B_1, null);
        );
        }
                engine.onSettingsChanged(TimeValue.MINUS_ONE, ByteSizeValue.ZERO, 0);
                );
        }
            delete.uid(),
        }
            0
                // that belongs to the flushed segment.
                }
            false,
        assertNotNull(result.getTranslogLocation());
            null,
                }
                localCheckpoint
                final long committedGen = assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog()
                }
        MatcherAssert.assertThat(
            assertThat(operationsInSafeCommit, notNullValue());
            .store(store)
        IndexMetadata.Builder builder = IndexMetadata.builder(indexSettings.getIndexMetadata());
        checker.run();
                }
        final Engine.Operation.Origin origin = randomFrom(LOCAL_TRANSLOG_RECOVERY, PEER_RECOVERY, PRIMARY, REPLICA);
                boolean useRecoverySource = randomBoolean() || omitSourceAllTheTime;
        if (size == 0) {
                            userData.get(Translog.TRANSLOG_UUID_KEY)
            1,
            index.parsedDoc(),
                retentionLeasesHolder.set(new RetentionLeases(primaryTerm, retentionLeasesVersion.get(), leases));
        }
                        if (indexResult.getResultType() == Engine.Result.Type.SUCCESS) {
        engine.updateUncommittedSegmentBytes(localSegmentsSizeMap, 1L);
import org.opensearch.index.seqno.RetentionLeases;
            final BiFunction<Long, Long, LocalCheckpointTracker> supplier = (ms, lcp) -> new LocalCheckpointTracker(
            300,
        IOUtils.close(store, engine);
     * org.opensearch.index.codec.PerFieldMappingPostingFormatCodec} assigns
        long lastMinRetainedSeqNo = engine.getMinRetainedSeqNo();
            Store store = createStore();
            .documentMapperForTypeSupplier(() -> documentMapperForType)
            REPLICA,
            new BytesArray("{}".getBytes(Charset.defaultCharset())),
            newUid(doc),
            null
    @SuppressWarnings("removal")
                    expectedSeqNos.add(indexResult.getSeqNo());
                Long.parseLong(recoveringEngine.commitStats().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)),
                for (int i = 0; i < 2; i++) {
            run.set(false);
                );
            }
    public void testDeleteWithFatalError() throws Exception {
        }
    }
                    final String id = Integer.toString(i);
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                config(indexSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null).toBuilder()
                            Engine.Operation.Origin.PRIMARY,
                            // and in turn fails the engine
                                    StoredFields storedFields = get.docIdAndVersion().reader.storedFields();
        }
                        assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().getMinFileGeneration(),
            UNASSIGNED_SEQ_NO,
        public void setThrowFailure(Supplier<Exception> failureSupplier) {
                        1
                } catch (InterruptedException e) {
            DocIdAndSeqNo docIdAndSeqNo = VersionsAndSeqNoResolver.loadDocIdAndSeqNo(searcher.getIndexReader(), get.uid());
            System.nanoTime(),
        for (Engine.Operation op : operations) {
                        document1,
    public void testSimpleOperations() throws Exception {
                    .setIfPrimaryTerm(primaryTerm.get() + 1),
                doc,
                    latch.await();
import org.opensearch.test.IndexSettingsModule;
     * Parity with {@code DataFormatAwareEngine}: a realtime GET issued from a <em>different</em> thread for a document
        // we need to reuse the engine config unless the parser.mappingModified won't work
            );
    }
import org.opensearch.common.concurrent.GatedCloseable;
        IOUtils.close(store, engine);
            0,
                        newUid(doc),
    public void testNewChangesSnapshotWithDeleteAndUpdateWithDerivedSource() throws IOException {
            // we can only advance as far as the number of operations that did not conflict
            for (Segment segment : engine.segments(false)) {
        for (Thread thread : threads) {
                        + op.operationType()
                        assertThat(op, instanceOf(Translog.Index.class));
            assertThat(segments.isEmpty(), equalTo(true));
        if (randomBoolean()) {
                primaryTerm.get(),
                    }
                System.nanoTime(),
            .analyzer(config.getAnalyzer())
        final Map<String, Long> localSegmentsSizeMap = new HashMap<>();
                        0,
                    String id = Long.toString(between(1, 50));
    public void testKeepTranslogAfterGlobalCheckpoint() throws Exception {
    public void testUnreferencedFileCleanUpOnSegmentMergeFailureWithCleanUpDisabled() throws Exception {
        }
        mapperService.merge("_doc", new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
                super(
                    engine.getLastCommittedSegmentInfos().userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)
        assertEquals(0, engine.getNumVersionLookups());
                        } else {
        List<Engine.Operation> operations = new ArrayList<>(numOps);
                            assertNull(msg, docIdAndSeqNo);
            engine.refresh("test");
        getThread.join();
                    );
import static org.mockito.Mockito.mock;
        }
    }
                return invocation.callRealMethod();
    }
        long maxSeqIDOnReplica = -1;
        mergeThread.start();
                            Engine.Operation.Origin.PRIMARY,
                if (ex != null) {
                null
            }
            Assert.assertTrue(cfsCompoundFileFound);
            public void onFailure(Exception e) {
    }
            TransportActions.isShardNotAvailableException(exception.get())
                    assertThat(deleteResult.getFailure(), nullValue());
                final Engine.Index index = (Engine.Index) op;
                    if (result.getResultType() == Engine.Result.Type.SUCCESS) {
        assertThat(batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
                if (randomBoolean()) {
            int numDocs = scaledRandomIntBetween(10, 100);
                indexResult = engine.index(indexForDoc(doc1));
        AtomicBoolean done = new AtomicBoolean();
        }
            }
        for (int i = 0; i < thread.length; i++) {
                    delete.startTime(),
                    );
        engine.close();
            // Again, with TRACE, which should only log IndexWriter IFD output:
            }
            List<ParsedDocument> docs = List.of(
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 1)
        // Make sure that the engine produces a SequentialStoredFieldsLeafReader.
                CountDownLatch awaitStarted = new CountDownLatch(1);
        Engine.IndexResult indexResult = engine.index(secondIndexRequest);
                ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), B_1, null);
        thread.start();
            null,
    /**
     * which silently overwrote earlier entries, causing the reported {@code file_sizes} total to be
     * <p>When fuzzy-set-for-doc-ID is enabled, {@link
        ParsedDocument doc = testParsedDocument("0", null, testDocumentWithTextField(), SOURCE, null);
            }
            assertThat(segments.size(), equalTo(3));
            null
    public void testBatchOperationCapFlushesAtMaxOperations() throws Exception {
    public void testHandleDocumentFailure() throws Exception {
            operation.version() + 1,
            newUid(doc),
        }
    }
        engine.refresh("warm_up");
        if (closeSnapshotBeforeEngine == false) {
     * A bulk thread leaves one deferred op in an open batch; a refresh from an unrelated caller drains that batch and
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                engine.refresh("test");
            + engine.getNumDocUpdates()
                assertNotNull(retryResult.getTranslogLocation());
        );
     */
            assertThat(
                if (previousGetResult != null) {
import java.util.concurrent.atomic.AtomicBoolean;
                    Translog.Operation op = ops.get(seqno);
        final AtomicReference<Engine.GetResult> latestGetResult = new AtomicReference<>();
                for (int i = 0; i < 2; i++) {
                        Integer.toString(i),
        );
                        null, // No source, it should be derived
        // Index a doc and flush to establish committed userData (sets translog_uuid, local_checkpoint, history_uuid, etc.)
                            throw tragicException;
        final Engine.Index indexWithoutThrottlingCheck = spy(indexForDoc(createParsedDoc("2", null)));
        // Index more docs + refresh BUT DO NOT FLUSH — NRT state now diverges from last commit.
            long safeMaxSeqNo = commitMaxSeqNo.stream()
                .analyzer(base.getAnalyzer())
                        VersionType.EXTERNAL,
            defaultSettings.getNodeSettings(),
            EngineConfig engineConfig = createEngineConfigWithMapperSupplierForDerivedSource(store, false);
                SequentialStoredFieldsLeafReader lf = (SequentialStoredFieldsLeafReader) context.reader();
                    int count = 0;
            engine.flush();
                        result = engine.delete(deleteWithCurrentTerm.apply(delete));
                newMergePolicy(),
            assertThat(getResult.exists(), equalTo(false));
                final CountDownLatch latch = new CountDownLatch(1);
                        "1",
            for (int threadNum = 0; threadNum < numIndexingThreads; threadNum++) {
            }
        engine.flush();
                    }
                        );
            assertFalse(engine.refreshNeeded());
                    }
                // Delete some documents
                    assertThat(result.isCreated(), equalTo(false));
            null
                engine.ensureOpen();
            autoGeneratedIdTimestamp,
        // refresh and it should be updated
            }
import org.apache.logging.log4j.LogManager;
        final Settings.Builder settings = Settings.builder().put(defaultSettings.getSettings()).put("index.refresh_interval", "300s");
                    VersionType.INTERNAL,
                        }
                    assertEquals("Expected number of operations in range", to - from + 1, count);
            assertThat(segments, hasSize(1));
        }
                final StringBuilder dump = new StringBuilder("refresh did not complete; refresh thread stack:\n");
                    assertThat(indexResult.getFailure(), nullValue());
            1,
         *                     <code>conf.getOpenMode()</code> is <code>OpenMode.APPEND</code> or if there is any other
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(0));
        Set<Long> expectedSeqNos = new HashSet<>();
            new Engine.Index(
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver;
                            assertTrue("Document " + docId + " should be in deleted set", deletedDocs.contains(docId));
            ParsedDocument doc = testParsedDocument("1", null, testDocument(), B_1, null);
                        equalTo(new Translog.NoOp(localCheckpoint + 1 + i, primaryTerm.get(), "filling gaps"))
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
                        UNASSIGNED_SEQ_NO,
                    assertThat(delete.getFailure(), nullValue());
            document.add(seqID.primaryTerm);
                engine.ensureOpen();
                        .stream()
        ) {
                AlreadyClosedException.class,
                        // Since now cleanup is not happening now, all unrefrenced files now be present as well.
            0
            while (stopped.get() == false) {
    public void testSegmentsWithUseCompoundFileFlag_false() throws IOException {
            assertFalse(segments.get(0).committed);
            for (int docId = 0; docId < numDocs; docId++) {
    }
            for (int i = 0; i < numDocsFirstSegment; i++) {
                    for (int i = 0; i <= localCheckpoint; i++) {
                    throw new AssertionError("document does not have primary term [" + docIdAndSeqNo.docId + "]");
        store.close();
                        UNASSIGNED_SEQ_NO,
    public void testProducesStoredFieldsReader() throws Exception {
            }
            }
                for (Engine.Operation op : operations) {
                    if (randomBoolean()) {
                    }
        }
        }
                    );
            assertTrue(engine.maybeRefresh("schedule"));
                new Term("_id", parsedDocument.id()),
        Thread mergeThread = new Thread() {
            final int numSegments;
                    assertThat(engine.getVersionMap().values(), empty());
                if (operations.get(i).version() >= version) {
                        });
import java.util.concurrent.Semaphore;
        Engine.Index create = new Engine.Index(newUid(doc), primaryTerm.get(), doc, Versions.MATCH_DELETED);
                    assertEquals(engine.getProcessedLocalCheckpoint(), engine.getPersistedLocalCheckpoint());
        );
            "1",
        ) {
import org.apache.lucene.index.IndexCommit;
                // mostly index, sometimes delete
                    for (String id : latestOps.keySet()) {
            }
                // now index more append only docs and refresh so we re-enabel the optimization for unsafe version map
            EngineConfig engineConfig = new EngineConfig.Builder().shardId(base.getShardId())
                }
                    if (rarely()) {
            });
        store.close();
                );
                try {
                for (int i = 0; i < numDocs; i++) {
            engine.index(indexForDoc(doc2));
        doReturn(true).when(batchEngine).isTranslogBatchingEligible();
        Thread refresher = new Thread(() -> {
            engine.index(replicaIndexForDoc(doc, 2, 2, false));
            Engine.IndexResult retryResult = engine.index(retry);
            boolean closed;
                    null,
        }
                InternalEngine holder;
    }
                assertNotNull(reader);
            );
            0
                }
                Engine.GetResult previousGetResult = latestGetResult.get();
        if (randomBoolean()) {
            final List<IndexCommit> commits = DirectoryReader.listCommits(store.directory());
                engine.index(
                }
            PRIMARY,
                engine.index(indexForDoc(createParsedDoc(Integer.toString(i), null)));
        );
            List<Segment> preMergeSegments = engine.segments(true);
                        globalCheckpoint.set(randomLongBetween(globalCheckpoint.get(), engine.getPersistedLocalCheckpoint()));
        searchResult = engine.acquireSearcher("test");
        final boolean engineClosedAfterwards;
    }
                        System.nanoTime(),
                    Engine.DeleteResult deleteResult = engine.delete((Engine.Delete) op);
            .put(IndexSettings.INDEX_MERGE_ON_FLUSH_MAX_FULL_FLUSH_MERGE_WAIT_TIME.getKey(), TimeValue.timeValueMillis(5000))
        indexResult = engine.index(index);
                    // index a document
                randomIntBetween(1, 8),
                );
import static org.opensearch.index.engine.Engine.Operation.Origin.PRIMARY;
                    }
                        public IndexableFieldType fieldType() {
            nonTragic,
                    if (i == 1) {
        Engine.IndexResult first = batchEngine.index(firstOp);
        assertThat(indexResult.getVersion(), equalTo(1L));
        indexResult = engine.index(index);
                new IndexShardRoutingTable.Builder(shardId).addShard(primary).addShard(replica).build()
            + "],"
            doc,
        );
        for (Engine.Operation op : ops) {
                    try {
            Engine.Index index = (Engine.Index) lastOpDoc2;
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
        try (
                    UNASSIGNED_SEQ_NO,
        IOUtils.close(engine, store);
            }
            ParsedDocument doc2 = testParsedDocument("2", null, testDocumentWithTextField(), B_2, null);
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                Set<String> updatedDocs = new HashSet<>();
        assertThat(batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
                    Translog.Operation operation;
            REPLICA,
            while (run.get()) {
            engine.index(indexForDoc(doc2));
                    seqNo++;
            assertThat(engine.segments(false), empty());
                        assertThat(operation, instanceOf(Translog.Index.class));
                        UNASSIGNED_SEQ_NO,
 *
                    }
            if (randomBoolean()) {
    public static long getNumVersionLookups(InternalEngine engine) { // for other tests to access this
            "Sync ID must be gone since we have a document to replay",
        try (
                        UNASSIGNED_SEQ_NO,
                searcher.search(new MatchAllDocsQuery(), collector);
                    document,
                        false,
            int appends = 0;
                    System.nanoTime(),
            PRIMARY,
                .filter(s -> s <= globalCheckpoint.get())
                    assertThat(indexResult.getFailure(), nullValue());
            final CyclicBarrier barrier = new CyclicBarrier(2);
            assertThat(segments.get(0).committed, equalTo(committed));
                            ParsedDocument doc = testParsedDocument(id, null, testDocument(), B_1, null);
            // Build a base config then rebuild it with our custom CodecService.
        generateNewSeqNo(engine); // create a gap here
                    System.nanoTime(),
                    final IndexCommit safeCommit = commits.get(0);
        assertNotNull(committedUserData.get(Translog.TRANSLOG_UUID_KEY));
                .externalRefreshListener(base.getExternalRefreshListener())
            assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
                    long localCheckpointFromSafeCommit = Long.parseLong(safeCommit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
        }
     * @param directory directory used for creating the store.
                        );
            Engine.Searcher searchResult = engine.acquireSearcher("test");
            );
                config.getTranslogConfig().getTranslogPath(),
    public void testUpdateOperationForAppendOnlyIndex() throws Exception {
                .build()
                assertThat(segment.getMergeId(), nullValue());
            for (int i = 0; i < numberOfTriplets; i++) {
                        engine.translogManager().syncTranslog();
                    SequenceNumbers.NO_OPS_PERFORMED,
    }
                    null,
        }
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
            0
            this.refreshFailure = refreshFailure;
        Engine.IndexResult second = batchEngine.index(indexForDoc(v2));
                        Integer.toString(i),
    private static Long getHighestSeqNo(final IndexReader reader) throws IOException {
                    Long highest = getHighestSeqNo(reader);
                UNASSIGNED_SEQ_NO,
                    updatedDocs.add(idToUpdate);
                int docOffset;
    }
        Engine.Index index = new Engine.Index(
                    if (versionedOp && lastOpSeqNo != UNASSIGNED_SEQ_NO && randomBoolean()) {
            assertThat(op1.seqNo(), lessThan(op2.seqNo()));
                engine.flush();
            }
        String lastFieldValue = null;
            final long maxSeqNo;
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
                final Engine.Index index = (Engine.Index) op;
    }
                    final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
            if (randomBoolean()) {
                stall.set(false);
            if (randomBoolean()) {
                searcher.search(new TermQuery(new Term("value", lastFieldValue)), collector);
        };
        }
        final Path translogPath = createTempDir();
            TranslogHandler translogHandler = createTranslogHandler(replicaEngine.config().getIndexSettings(), recoveringEngine);
    public void testShouldPeriodicallyFlush() throws Exception {
                long minRetainSeqNos = engine.getMinRetainedSeqNo();
import static org.hamcrest.CoreMatchers.instanceOf;
        assertThat(engine.shouldPeriodicallyFlush(), equalTo(true));
        if (engine.engineConfig.getIndexSettings().isSoftDeleteEnabled()) {
        }
                        commitMaxSeqNo.add(maxSeqNoInCommit);
        store.close();
                                               // checkpoint
        engine.flush();
    }
            assertNotNull(indexResult.getTranslogLocation());
                    Engine.Index operation = appendOnlyPrimary(doc, false, 1);
                for (BytesRef uid : deletesAfterCheckpoint.keySet()) {
        long seqNo = -1;
     */
                                }
    public void testNewChangesSnapshotWithDeleteAndUpdateWithDerivedSourceAndContextAwareEnabledWithFilterWrapper() throws IOException {
        }
        }
                    .put(indexSettings.getSettings())
            assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().getMinFileGeneration(),
                assertVisibleCount(engine, 1);
            for (Throwable s : current.getSuppressed()) {
                    } else {
            assertEquals(0, engine.getNumVersionLookups());
        doReturn(true).when(batchEngine).isTranslogBatchingEligible();
            assertEquals(1, topDocs.totalHits.value());
                    engine.refresh("test");
                    .setIfPrimaryTerm(primaryTerm.get()),
            public void beforeRefresh() {
                    } else if (versionedOp) {
            assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
                null,
            }
        assertThat(seqID.v2(), equalTo(primaryTerm.get()));
        boolean docDeleted = true;
                // Test snapshot with specific range
                            0
            store.trimUnsafeCommits(config.getTranslogConfig().getTranslogPath());
            Store store = createStore();
            };
                    eventListener,
        );
            engine.translogManager().syncTranslog();
        try (
        Randomness.shuffle(operations);
        MatcherAssert.assertThat(
            @Override
                                public CacheHelper getReaderCacheHelper() {
                index(engine, docId);
                assertThat(seqNoStats.getLocalCheckpoint(), equalTo(prevSeqNoStats.getLocalCheckpoint()));
                liveDocs.add(doc.id());
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
            if (rarely()) {
                snapshots.add(engine.acquireSafeIndexCommit()); // taking snapshots from the safe commit.
        Set<String> deletedDocs = new HashSet<>();
            .eventListener(config.getEventListener())
        );
            UNASSIGNED_SEQ_NO,
        assertThat(batchEngine.getProcessedLocalCheckpoint(), equalTo(1L));
                    getTranslog(recoveringEngine).sync();
                "",
 * GitHub history for details.
            engine.index(indexForDoc(doc3));
                // Test snapshot with specific range
            IOUtils.close(recoveringEngine);
                    UNASSIGNED_SEQ_NO,
            }
            searchResult,
        Engine.Index operation = randomBoolean()
                    config.getTranslogConfig().getTranslogPath(),
                        @Override
        assertThat(deleted.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                        false,
        engine.delete(new Engine.Delete("1", newUid(doc), primaryTerm.get()));
                            assertAndGetInternalTranslogManager(engine.translogManager()).getTranslogUUID(),
import java.util.concurrent.atomic.AtomicLong;
                }
            final List<Thread> indexingThreads = new ArrayList<>();
        translog.close();
                newMergePolicy(),
                        assertThat(result.getSeqNo(), equalTo(primarySeqNo + 1));
                        final String id = "thread" + threadIdx + "#" + i;
                .externalRefreshListener(config.getExternalRefreshListener())
        // refresh and it should be there
            }
                newUid(doc),
            }
                        doc = testParsedDocument(
                UNASSIGNED_SEQ_NO,
                throw new RuntimeException(ex);
                        -1,
                }
            assertNotNull(shardId);
                                    org.apache.lucene.document.Document document = storedFields.document(get.docIdAndVersion().docId);
        // processed checkpoint spans the whole chunk — no explicit flush was needed.
                    } catch (Exception e) {
            for (int op = 0; op < opCount; op++) {
                    engine.flush();
                } finally {
            }
                            doc,
        doAnswer(invocation -> {
                closed = true;
            indexSettings.getTranslogRetentionAge(),
            seqNo,
        );
            equalTo(inSync ? 3L : 2L)
        final long extraTranslogSizeInNewEngine = engine.translogManager().getTranslogStats().getUncommittedSizeInBytes()
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
        sortedHistory.sort(Comparator.comparing(o -> o.version));
            expectThrows(IOException.class, () -> engine.index(index));
                engine.refresh("test");
            checkpointOnReplica = replicaEngine.getProcessedLocalCheckpoint();
                    null,
                true,
                    }
            delete.routing()
        try {
                                    );
        Thread[] refreshThreads = new Thread[between(1, 8)];
import org.apache.lucene.tests.mockfile.ExtrasFS;
        CountDownLatch latch = new CountDownLatch(refreshThreads.length);
        return testParsedDocument(id, null, testDocumentWithTextField(), source, null);
        }
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
    }
        Engine.Delete directDelete = new Engine.Delete(
            Engine.Operation.Origin.PRIMARY,
            for (int docID = 0; docID < leaf.maxDoc(); docID++) {
                    engine.index(replicaIndexForDoc(doc, 1, seqNo, false));
            Store store = createStore();
                    engineConfig,
                        wrapper.close();
                    assertThat(
    public void testTranslogReplay() throws IOException {
    }
                for (StackTraceElement frame : refresher.getStackTrace()) {
                assertThat(localCheckpoint, greaterThanOrEqualTo(prevLocalCheckpoint));
            List<Segment> mergedSegments = engine.segments(true);
                        store.close();
                    throw new IOException("No space left on device");
                    final long timestamp = randomLongBetween(0L, Long.MAX_VALUE);
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                op.operationType().name().charAt(0),
                    .build()
                        throw new AssertionError(ex);
            assertThat(recoveringEngine.getSeqNoStats(-1).getMaxSeqNo(), equalTo(primarySeqNo));
    public void testRecoveryFromTranslogUpToSeqNo() throws IOException {
                }
                    .put(defaultSettings.getSettings())
            );
                // (this value is visible to the deletion policy) and an in memory global checkpoint in the SequenceNumbersService.
            assertThat(getResult.docIdAndVersion(), notNullValue());
                .endObject();
            + expectedUpdates
                        Engine.Operation.Origin.PRIMARY,
            assertEquals(maxTimestamp12, engine.segmentsStats(false, false).getMaxUnsafeAutoIdTimestamp());
                    assertThat(noOp.getFailure(), nullValue());
        engine.refresh("warm_up");
            .put(IndexSettings.INDEX_MERGE_ON_FLUSH_POLICY.getKey(), "merge-on-flush");
            final int numDocs = randomIntBetween(1, 10);
            assertTrue(cleanupCompleted.await(10, TimeUnit.SECONDS));
                if (i % 3 == 0) {
            try (InternalEngine engine = createEngine(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE, (directory, iwc) -> {
    public void testConcurrentGetAndFlush() throws Exception {
        long size = PointValues.size(reader, fieldName);
        assertThat(engine.shouldPeriodicallyFlush(), equalTo(true));
                op.operationType().name().charAt(0),
            final long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
            InternalEngine engine = createUpdateOnlyEngine(
                .startObject("value")
            // this is just to make sure that refresh post flush has the same impact.
                            // Verify document is actually deleted
            () -> new MatchAllDocsQuery(),
import org.apache.lucene.document.Field;
                                assertThat(getResult.exists(), equalTo(true));
            assertEquals(1, topDocs.totalHits.value());
            }
                Exception failure = failureToThrow.get().get();
        if (lastFieldValue != null) {
                        System.nanoTime(),
    }
                prevSeqNoStats = engine.getSeqNoStats(globalCheckpoint.get());
            .indexSettings(config.getIndexSettings())
                        0,
                        idToUpdate = Integer.toString(randomInt(numDocs - 1));
                } catch (IOException e) {
                defaultSettings,
                null,
                                break;
                    // Make sure we keep all translog operations after the local checkpoint of the safe commit.
                for (int i = 0; i < someIters; i++) {
                    assertThat(
                        "update operations on primary must advance max_seq_no_of_updates",
            if (engine.shouldPeriodicallyFlush()) {
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
        assertThat(indexResult.getVersion(), equalTo(1L));
        );
                            greaterThan(lastSyncedGlobalCheckpointBeforeCommit.get())
            assertThat(Long.parseLong(initialEngine.commitStats().getUserData().get(SequenceNumbers.MAX_SEQ_NO)), equalTo(maxSeqNo));
            engine.index(replicaIndexForDoc(doc, 1L, seqno, false));
            try (GatedCloseable<IndexCommit> wrappedSafeCommit = engine.acquireSafeIndexCommit()) {
                ParsedDocument parsedDocument = testParsedDocument(index.id(), index.routing(), doc, index.source(), null);
            Engine.Index index = indexForDoc(doc);
                }
                    engine.getMaxSeqNoOfUpdatesOrDeletes(),
                assertThat(warmedUpReaders, hasSize(2));
                throwingIndexWriter.get().clearFailure();
                        count++;
        assertThat("Committed files and segments_N never contribute to the accounting", engine.shouldPeriodicallyFlush(), equalTo(false));
                if (commits.get(i).stream().allMatch(op -> op.seqNo() <= globalCheckpoint.get())) {
import org.opensearch.index.seqno.SeqNoStats;
                    assertThat(result.getVersion(), equalTo(highestOpVersion));
                .field("foo", 123)
                            lessThanOrEqualTo(lastSyncedGlobalCheckpointBeforeCommit.get())
        );
                        engine.index(update);
                );
        expectThrows(IllegalStateException.class, () -> engine.flush(true, true));
        for (Version createdVersion : Arrays.asList(
            );
        });
        final Settings.Builder settings = Settings.builder()
            REPLICA,
            .stream()
        assertEquals(store.readLastCommittedSegmentsInfo().getUserData().get(Engine.SYNC_COMMIT_ID), syncId);
            // Just allow force merge so that regular merge does not close the shard first before any any other operation
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
        doc = testParsedDocument(Integer.toString(1), null, testDocumentWithTextField(), SOURCE, null);
                    document3,
            for (int i = 0; i < numDocs; i++) {
                engine = createEngine(engineConfig);
                    PRIMARY,
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
                .similarity(base.getSimilarity())
        }
                engine.index(indexForDoc(doc1));
                if (fileName.endsWith(".cfs")) {
            IOUtils.close(engine);
                    doc,
            store.associateIndexWithNewTranslog(translogUUID);
        for (int i = 0; i < iters; i++) {
            + "]";
        Translog.TranslogGeneration generation = assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog()
            }
        engine.refresh("warm_up");
            assertThat(preMergeSegments.size(), equalTo(3));
        List<Engine.Operation> ops = generateSingleDocHistory(false, VersionType.INTERNAL, 2, 10, 100, "1");
            assertThat(deleteResult.getSeqNo(), equalTo(seqNo + 1));
                done.countDown();
                    liveDocsWithSource.remove(doc.id());
                    }
            final List<Thread> threads = new ArrayList<>();
                                    );
            secondIndexRequest.primaryTerm(),
                    engine.delete((Engine.Delete) op);
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
     */
                searcher.search(new TermQuery(new Term("value", lastFieldValueDoc1)), collector);
                        VersionType.EXTERNAL,
            if (randomBoolean()) {
            })) {
import static org.mockito.Mockito.doReturn;
import org.apache.lucene.index.MergePolicy;
            try (InternalEngine engine = createEngine(config)) {
            } finally {
            final long gen1 = store.readLastCommittedSegmentsInfo().getGeneration();
            assertEquals(1, searcher.getIndexReader().numDocs());
                        clock.incrementAndGet();
                    // to avoid races between closing threads
            .put(defaultSettings.getSettings())
            Lucene.SOFT_DELETES_FIELD,
            };
                .startObject()
            searchResult,
                }
import org.apache.lucene.index.SegmentReader;
            Assert.fail();
        assertEquals(engine.getLastCommittedSegmentInfos().getUserData().get(Engine.SYNC_COMMIT_ID), syncId);
                    }
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER
            indexResult.getVersion(),
            final long minTranslogGen;
            }
                if (create) {
                    seqNo++;
            boolean exists = op.removed == null ? true : currentValues.remove(op.removed);
                () -> engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID())
                work.push(s);
        // promote to primary: first do refresh
        AtomicBoolean stopped = new AtomicBoolean();
            applyOperation(engine, op);
        assertThat(new EngineBackedIndexer(engine).beginTranslogBatch(), sameInstance(Engine.NO_OP_TRANSLOG_BATCH));
                );
                    lastOpVersion = Versions.NOT_FOUND;
            for (int i = 0; i < ops; i++) {
        MatcherAssert.assertThat(
            300,
            indexingThreads.add(indexingThread);
            for (String file : files) {
                        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().seqNo()));
        doc = testParsedDocument("1", null, document, B_1, null);
            final ParsedDocument doc1 = testParsedDocument("1", null, testContextSpecificDocument("grouping_criteria"), B_1, null);
                .build();
                testDocumentWithTextField(),
    }
                        testDocumentWithTextField(),
                    );
        assertThat(
            .translogDeletionPolicyFactory(translogDeletionPolicyFactory)
import org.opensearch.index.mapper.ParsedDocument;
                assertEquals(engine.getProcessedLocalCheckpoint(), engine.getPersistedLocalCheckpoint());
                        engine.close();
                ParsedDocument doc = testParsedDocument(id, null, testDocument(), B_1, null);
                }
                engine.refresh("test", Engine.SearcherScope.EXTERNAL, true);
                    operations.add(index);
        return (engine, operation) -> {
        verify(indexWithoutThrottlingCheck, atLeastOnce()).startTime();
     * Tests that when the close method returns the engine is actually guaranteed to have cleaned up and that resources are closed
        IOUtils.close(store, engine);
                return super.directory();
                @Override
            assertThat(op2.seqNo(), equalTo(1L));
                try {
        }
        Engine initialEngine;
            InternalEngine engine = createEngine(
            } finally {
        engine.refresh("test");
            assertDeletedVersionConflict(
                LeafReaderContext leafReaderContext = reader.leaves().get(0);
                assertThat(engine.getProcessedLocalCheckpoint(), equalTo(upToSeqNo));
            Engine.Operation.Origin.PRIMARY,
        Translog.Location finishLocation = batch.finish();
            assertThat(segments.get(2).getSegmentSort(), equalTo(indexSort));
            for (LeafReaderContext context : reader.leaves()) {
            assertEquals(1, get.version());
                    }
                        } else {
                        } else {
    public void testDeleteFailureDocAlreadyDeleted() throws IOException {
                engine.refresh("test");
        IndexMetadata.Builder builder = IndexMetadata.builder(indexSettings.getIndexMetadata())
                Arrays.asList(IOException.class, IllegalStateException.class),
        }
        }
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
     * {@link EngineBackedIndexer}. The wrapper must forward the batching decision, otherwise the {@code Indexer}
                });
                }
            );
                                }
                Map<String, Long> fileSizes = stats.getFileSizes();
                try {
            addDocException.set(new IOException("simulated"));
            assertThat(index.getVersion(), equalTo(1L));
            .indexSort(null)
            assertEquals(totalNumberOfDocsRefreshed - 1, engine.getMaxSeqNoFromSearcher(searcher));
            int numDocsFirstSegment = randomIntBetween(5, 50);
                Engine.Operation.Origin.PRIMARY,
            if (randomBoolean()) {
            throw new AssertionError(ex);
        final AtomicBoolean stall,
                }
        }
            create ? Versions.MATCH_DELETED : Versions.MATCH_ANY,
            gcpTracker.updateFromClusterManager(
                UNASSIGNED_SEQ_NO,
            ParsedDocument doc2 = testParsedDocument("2", null, testDocumentWithTextField(), B_2, null);
                newUid(doc),
                    engine.flush(randomBoolean(), true);
            index.version(),
                Terms id = leafReader.terms("_id");
        }
            assertThat(result.isCreated(), equalTo(false));
            false,
            .settings(
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test1")), 1)
            assertTrue(engine.maybeRefresh("schedule"));
            assertEquals(
                    docDeleted = true;
        }
            assertThat(segments.get(0).getNumDocs(), equalTo(liveDocsFirstSegment.size()));
        primaryTerm.set(randomLongBetween(primaryTerm.get(), Long.MAX_VALUE));
        Engine.DeleteResult deleteResult = engine.delete(replicaDeleteForDoc("id", 1, seqNo + between(1, 1000), randomNonNegativeLong()));
        @Override
        engine.flush(false, true);
                if (callStackContainsAnyOf("mergeWithLogging")) {
     * This is needed as some fields in Lucene may not exist if a segment misses operation types and this code is to check for that.
            seqNo -> {},
        engine.index(indexForDoc(doc));
        Loggers.setLevel(rootLogger, Level.DEBUG);
            assertThat(segments.get(1).committed, equalTo(committed));
            engine.index(indexForDoc(doc2));
                    doc.get(),
            store.createEmpty(Version.CURRENT.luceneVersion);
        TriFunction<Long, Long, Engine.Index, Engine.Index> indexWithSeq = (seqNo, term, index) -> new Engine.Index(
            delete.uid(),
            } catch (Throwable t) {
            final AtomicReference<RetentionLeases> retentionLeasesHolder = new AtomicReference<>(
                            0L
                } else {
                        index(finalActualEngine, skipId);
        IOUtils.close(store, engine);
                    expectedSeqNos.add(deleteResult.getSeqNo());
                .flushMergesAfter(config.getFlushMergesAfter())
                if (fileName.endsWith(".cfe")) {
                    expectThrows(Throwable.class, () -> engine.acquireSearcher("test")).getMessage(),
                            true,
            engine.index(indexForDoc(doc));
    }
        try (Store store = createStore()) {
                            }
                        UNASSIGNED_SEQ_NO,
                        result.getFailure().getMessage(),
                @Override
        for (int i = 0; i < numOps; i++) {
            doc,
                        liveDocsWithSource.add(doc.id());
                        engine.flush(true, true);
        );
            engine.flush();
    /**
                    () -> new MatchAllDocsQuery(),
            ParsedDocument doc2 = testParsedDocument("2", null, testDocumentWithTextField(), B_2, null);
                } else {
                ParsedDocument doc = testParsedDocument(id, null, testDocument(), B_1, null);
                final String id;
                nrtUserData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)
        EngineConfig config = engine.config();
        engine.refresh("test");
                long maxSeqNo = userData.containsKey(SequenceNumbers.MAX_SEQ_NO)
                    if (operation.opType() == Translog.Operation.Type.NO_OP) {
                                    engine::acquireSearcher
                    assertThat(engine.getLocalCheckpointTracker().getMaxSeqNo(), equalTo(maxSeqNo + 1L));
                    newForceMergePolicy(),
            }
                store,
                                Engine.GetResult get = engine.get(
            // start the indexing threads
                    throw new AssertionError(e);
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
        Engine.IndexResult indexResult = engine.index(create);
                    Engine.IndexResult indexResult = engine.index((Engine.Index) op);
            try (
                versionField,
                            EngineTestCase.newUid(doc),
                assertNotNull(indexResult.getTranslogLocation());
public class InternalEngineTests extends EngineTestCase {
                Long.parseLong(recoveringEngine.commitStats().getUserData().get(SequenceNumbers.MAX_SEQ_NO)),
        committedOnlySizeMap.put(IndexFileNames.SEGMENTS + "_99", Long.MAX_VALUE / 2);
    /**
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
            assertTrue(engine.refreshNeeded());
                    operations.add(operation);
                    indexSort, // testing index sort
            TranslogHandler translogHandler = createTranslogHandler(config.getIndexSettings(), recoveringEngine);
                "node2",
                }
        for (int i = 0; i < iters; i++) {
        batchEngine.close();
            do {
        );
                // writes more than one file per extension (as the FuzzyFilter + standard
                return throwingIndexWriter.get();
     */
            + " deletes [actual:"
            doc,
                        throw new RuntimeException(e);
                return IndexingStrategy.processNormally(false, 0, 0);
        engine.refresh("warm_up");
                    sequenceNumberSupplier.getAsLong(),
                int numDocsToUpdate = randomIntBetween(1, numDocs - deletedDocs.size());
        final int iters = randomIntBetween(1, 15);
                final Engine.Index doc3 = new Engine.Index(
                .collect(Collectors.toMap(Translog.Operation::seqNo, Function.identity()));
import java.util.HashSet;
                default:
            null
                        new SoftDeletesRetentionMergePolicy(
                3,
            Store store = createStore();
            // delete
            barrier.await(); // wait for indexing threads to all be ready to start
                -1,
        MockDirectoryWrapper wrapper = newMockDirectory();
                new HashSet<>(Arrays.asList(primary.allocationId().getId(), replica.allocationId().getId())),
                    refreshCount.incrementAndGet();
        try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
    }
        try {
                    )
                .put(defaultSettings.getSettings())
                }
            long unreferencedFileCleanUpsPerformed = engine.unreferencedFileCleanUpsPerformed();
                engine.onSettingsChanged(
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(1));
                    Engine.Index firstIndexRequest = new Engine.Index(
        assertTrue(
     * Verifies that discarding the published accounting disarms the condition, which is how the publisher stops flushes
                    assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
                Engine.IndexResult result = engine.index(indexForDoc(doc));
            store,
            } else {
    public void testSegmentsStatsIncludingFileSizes() throws Exception {
        MatcherAssert.assertThat(
        final String lastFieldValueDoc1;
        ) {
                refreshStarted.await();
            VersionConflictEngineException.class,
            assertThat(getResult.exists(), equalTo(false));
        doReturn(true).when(batchEngine).isTranslogBatchingEligible();
                        );
            assertThat(segments.get(1).getNumDocs(), equalTo(updates + appends));
                    index.version(),
                    int count = 0;
                        seqNo,
            );
        engine.index(indexForDoc(doc));
                        UNASSIGNED_SEQ_NO,
            assertThat(recoveringEngine.getPersistedLocalCheckpoint(), equalTo(primarySeqNo));
        document.add(new Field(SourceFieldMapper.NAME, BytesReference.toBytes(B_1), SourceFieldMapper.Defaults.FIELD_TYPE));
 *
                UNASSIGNED_SEQ_NO,
        final boolean sameSeqNo = operation.seqNo() == retry.seqNo();
        engine.index(indexForDoc(testParsedDocument("1", null, testDocumentWithTextField(), SOURCE, null)));
            20,
                retentionLeasesVersion.incrementAndGet();
            shuffle(ops, random());
        final Settings.Builder settings = Settings.builder().put(defaultSettings.getSettings()).put("index.refresh_interval", "300s");
        ) {
        FailingBatchAppendTranslog.FailureClass failureClass
            try (InternalEngine engine = createEngine(config)) {
                }
                        randomNonNegativeLong(),
    public void testRetryWithAutogeneratedIdsAndWrongOrderWorksAndNoDuplicateDocs() throws IOException {
        assertThat(seqID.v1(), equalTo(0L));
                    newSeqNo,
            + "],"
                    null,
            .put(defaultSettings.getSettings())
            long seqNo = 0;
            mockAppender.start();
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Lock;
                    if (randomBoolean()) {
        );
                        null,
            assertThat(segments.get(1).getSegmentSort(), equalTo(indexSort));
     * If we decide not to add those already-processed operations to translog, we need to study carefully the consequence
                )
                Engine.Index primaryResponse = indexForDoc(doc);
                    wrappedSafeCommit.get().getUserData().entrySet()
    }
        final VersionType versionType = randomFrom(nonInternalVersioning);
        BiFunction<Engine.Operation, Long, Engine.Operation> seqNoUpdater = (operation, newSeqNo) -> {
 *     http://www.apache.org/licenses/LICENSE-2.0
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), randomFrom("-1", "100micros", "30m"))
                Engine.Index index = (Engine.Index) operation;
                }
                        PRIMARY,
            for (long seqno = 0; seqno <= engine.getPersistedLocalCheckpoint(); seqno++) {
        final ParsedDocument doc = testParsedDocument(
        // now delete
                    Map<String, String> userData = engine.getLastCommittedSegmentInfos().getUserData();
            }
            doc,
        try (Store store = createStore(); InternalEngine engine = createEngine((dir, iwc) -> {
                    }
            maybeThrowFailure();
                                try (
            Engine.Operation.Origin.PRIMARY,
        Loggers.addAppender(rootLogger, mockAppender);
                assertThat(maxSeqNo, greaterThanOrEqualTo(prevMaxSeqNo));
            isRetry,
                        UNASSIGNED_SEQ_NO,
                    } catch (IOException e) {
        assertThat(batchEngine.getPersistedLocalCheckpoint(), equalTo(0L));
            engine.close();
                            "{\"value\":\"test\"}",
                config(indexSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get)
        final Throwable refreshFailure;
                    greaterThan(globalCheckpoint.get())
                        newUid("1"),
                while (done.get() == false) {
            assertLuceneOperations(engine, 1, 0, 0);
            primaryTerm::get,
                    engine.index(index);
                        UNASSIGNED_SEQ_NO,
            }
                            primaryTerm.get(),
            Engine.IndexResult retryResult = engine.index(retry);
            }
                engine.getSeqNoStats(-1).getMaxSeqNo() + 1,
    /**
            )
        long seqNo = 0;
            boolean cfeCompoundFileFound = false;
            delete.startTime(),
                            }
                startGun.countDown();
    /** java docs */
import static org.opensearch.index.engine.Engine.Operation.Origin.PEER_RECOVERY;
        public void setThrowFailure(Supplier<Exception> failureSupplier) {
                assertThat(reader, not(in(warmedUpReaders)));
            internalEngine.index(index);
                }
                    delete.origin(),
                    assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
        InternalEngine batchEngine = spy(engine);
        };
                null,
                config(indexSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get)
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
        if (versionType == VersionType.EXTERNAL) {
            assertEquals(0, engine.getNumVersionLookups());
            UNASSIGNED_SEQ_NO,
                0
            // lets force merge the tombstone and the original segment and make sure the doc is still there but the ID term is gone
import org.opensearch.index.mapper.VersionFieldMapper;
            } while (doneIndexing == false);
        doAnswer(invocation -> {
                        Versions.MATCH_ANY,
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
                    Engine.Index update = new Engine.Index(
                assertEquals("the delete and the tombstone", 1, leafReader.numDeletedDocs());
            }
        engine.refresh("test");
                    "2",
        final Map<String, Long> localSegmentsSizeMap = new HashMap<>();
    private CriteriaBasedMergePolicy newCriteriaBasedMergePolicy() {
    public void testInternalVersioningOnPrimary() throws IOException {
                        engine.flush();
        final long expectedLocalCheckpoint;
                        doc,
                        engine.index(indexForDoc(doc));
        Randomness.shuffle(operations);
                                engine.refresh("test");
    }
                    } else {
                new MockLogAppender.SeenEventExpectation("expected message", Engine.class.getCanonicalName(), Level.ERROR, message)
        Loggers.setLevel(iwIFDLogger, Level.DEBUG);
                        engine.close();
            delete.origin(),
                 * a later generation.
        );
                            @Override
            null,
                                }
                Engine.DeleteResult result = engine.delete(delete);
                        primaryTerm.get(),
                .threadPool(base.getThreadPool())
                for (int i = 0; i < numDocs; i++) {
            );
                    }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
        engine.close();
            10,
                    }
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 1)
                        latch.await();
            int updates = 0;
                LocalCheckpointTracker::new,
    }
            doc,
                // after recovering from translog, all docs have been flushed to Lucene segments, so here we will assert
            engine.flush();
            for (int docId = 0; docId < numDocs; docId++) {
                    while ((operation = snapshot.next()) != null) {
     * {@code map.merge(extension, length, Long::sum)} so every file's bytes are counted.
                SequenceNumbers.CommitInfo commitInfo = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
        List<Engine.Operation> operations = generateHistoryOnReplica(between(1, 500), randomBoolean(), randomBoolean(), randomBoolean());
                    store,
            index.getAutoGeneratedIdTimestamp(),
                    }
                } else {
                            i + numDocs,
    public void testBasicCreatedFlag() throws IOException {
        ParsedDocument doc = testParsedDocument(
                } catch (IOException e) {
            initialEngine.ensureOpen();
            } else {
                createTempDir(),
        engine = new InternalEngine(copy(engine.config(), inSyncGlobalCheckpointSupplier));
         *
                if (seqno != gapSeqNo) {
                    }
                    defaultSettings,
            outcome.engineFailures,
        final List<Engine.Operation> ops = generateSingleDocHistory(false, VersionType.INTERNAL, 2, 2, 20, "1");
            // Add document
    private Map<BytesRef, DeleteVersionValue> tombstonesInVersionMap(InternalEngine engine) {
        assertThat(indexResult.getVersion(), equalTo(1L));
import org.apache.lucene.search.ReferenceManager;
        engine.clearUncommittedSegmentBytes();
            .threadPool(config.getThreadPool())
        }
        assertEquals(rightLeaves.size(), leftLeaves.size());
        Engine.Delete withRouting = engine.prepareDelete(
        final MergePolicy keepSoftDeleteDocsMP = new SoftDeletesRetentionMergePolicy(
            IOUtils.close(recoveringEngine);
                engine.index(indexForDoc(doc));
    public void testSegmentFileSizesAccumulatesAllFilesIncludingDuplicateExtensions() throws Exception {
        return new Engine.Index(
                }
            if (committed) {
                    replicaLocalCheckpoint = randomIntBetween(Math.toIntExact(replicaLocalCheckpoint), Math.toIntExact(primarySeqNo));
            index.getAutoGeneratedIdTimestamp(),
            searchResult,
            instanceOf(EngineException.class)
        create = new Engine.Index(
        // now do an update
            };
                for (int j = 0; j < numDocs; j++) {
                        engine.close();
                }
                assertThat(
                engine.index(indexForDoc(testParsedDocument(Integer.toString(i), null, testDocumentWithTextField(), SOURCE, null)));
            }
                                    assertTrue("Document " + docId + " should exist", get.exists());
        }
        index = new Engine.Index(
import org.apache.lucene.index.PointValues;
                        0
            assertThat(engine.failedEngine.get(), not(nullValue()));
        // the test asserts that the reader is current while the refreshed checkpoint lags, so disable merges: a background
            indexWriterConfig.setSoftDeletesField(Lucene.SOFT_DELETES_FIELD);
    }
                equalTo(SequenceNumbers.NO_OPS_PERFORMED)
            // create
            assertEquals(primarySeqNo, initialEngine.getPersistedLocalCheckpoint());
        final String lastFieldValue;
                                        "updated",
                engine.flush(true, true);
                    liveDocs.remove(doc.id());
                            get.version(),
                    }
import org.apache.lucene.index.SegmentInfos;
                    LeafReader leafReader = getOnlyLeafReader(searcher.getIndexReader());
            version,
            // open index with new tlog
            latch.await();
                        }
                            .put(indexSettings.getSettings())
            );
    }
            UNASSIGNED_SEQ_NO,
        }
            .put(IndexSettings.INDEX_MERGE_ON_FLUSH_MAX_FULL_FLUSH_MERGE_WAIT_TIME.getKey(), TimeValue.timeValueMillis(5000))
    public void testNotWarmUpSearcherInEngineCtor() throws Exception {
            );
                // pending snapshots - should not release any commit.
        globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
    /**
import org.opensearch.index.seqno.RetentionLease;
            assertThat(segments.get(0).getNumDocs(), equalTo(liveDocsFirstSegment.size()));
            null,
        }
            UNASSIGNED_SEQ_NO,
        if (lastOp instanceof Engine.Index) {
        }
                    join.await();
                () -> engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID())
            assertFalse(engine.refreshNeeded());
    }
                0
                if (commits.size() > commitLimit) { // don't keep on piling up too many commits
        assertNull(
                engine.flush(true, true);
                                assertFalse("Document " + docId + " should not exist", get.exists());
                holder.close();
        ParsedDocument doc = testParsedDocument("1", null, testDocument(), B_1, null);
                warmedUpReaders.add(reader);
            for (GatedCloseable<IndexCommit> wrappedCommit : commits) {
                Document doc = testDocumentWithTextField(index.docs().get(0).get("value"));
        }
        ParsedDocument doc = testParsedDocument(Integer.toString(randomId), null, testDocument(), new BytesArray("{}"), null);
        public long addDocument(Iterable<? extends IndexableField> doc) throws IOException {
        // now do it again to make sure we preserve values etc.
            Store store = createStore();
            segments = engine.segments(true);
        boolean flushed = false;
            indexSettings.getTranslogRetentionAge(),
                    assertThat(msg, versionValue.term, equalTo(op.primaryTerm()));
    }
                refreshListener,
        IOUtils.close(store, engine);
            10,
            );
                    operations.add(new Engine.Delete(id, newUid(id), primaryTerm.get()));
                        // Since only one document is committed and unreferenced files are cleaned up,
        } finally {
        EngineConfig config = engine.config();
        final IndexSettings indexSettings = engine.config().getIndexSettings();
    }
            lookupAndCheck.run();
            segments = engine.segments(randomBoolean());
        assertNull(directDelete.routing());
        engine.close();
        final Settings.Builder settings = Settings.builder()
            )
            TopDocs search = searcher.search(new MatchAllDocsQuery(), 1);
            // now we have 2 segments since we now added a tombstone plus the old segment with the delete
    }
                }
                .startObject("value")
                    } while (deletedDocs.contains(idToUpdate) || updatedDocs.contains(idToUpdate));
                }
            //
                // that the committed max seq no is equivalent to what the current primary seq no is, as all data
        ) {
            engine.index(replicaIndexForDoc(doc, 2L, generateNewSeqNo(engine), false));
    }
                .queryCache(base.getQueryCache())
        final ReferenceManager.RefreshListener refreshListener = new ReferenceManager.RefreshListener() {
                                    Engine.Index index = indexForDoc(doc);
import java.nio.file.Files;
            }
        assertThat(indexResult.getVersion(), equalTo(1L));
                    throw new IOException("No space left on device");
        for (int id = 0; id < numDocs; id++) {
                        }
     */
            final AtomicReference<RetentionLeases> retentionLeasesHolder = new AtomicReference<>(
            try (InternalEngine engine = createEngine(store, translogPath)) {
                    id = randomFrom(ids);
        // now its there...
                    flushedOperations.add(op);
            );
            VersionType.EXTERNAL,
            Store store = createStore();
            isRetry,
        translogHandler = createTranslogHandler(engine.engineConfig.getIndexSettings(), engine);
                    final String msg = versionValue
        }
     *                                number
                            i,
        assertThat(seqID.v1(), equalTo(1L));
                globalCheckpoint.set(randomInt(maxSeqNo));
        batch.finish();
                } else {
                    final Engine.DeleteResult result = initialEngine.delete(delete);
            }
            assertThat(batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
            final ParsedDocument doc = testParsedDocument(docId, null, testDocumentWithTextField(), SOURCE, null);
                createDocumentWithNestedField("3", "Charlie", 35)
        final LocalCheckpointTracker mockCheckpointTracker = mock(LocalCheckpointTracker.class);
        if (inSync) {
import java.util.function.LongSupplier;
                        final Engine.Delete delete = new Engine.Delete(
                doc,
        assertTrue(engine.refreshNeeded());
                                ) {
                                    new Engine.Get(true, false, docId, newUid(docId)),
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexSettings.getIndexMetadata())
                    engine.flush();
        engine.refresh("test");
        } else {
        );
        } finally {
                1,
                if (frequently()) {
            List<Segment> segments = engine.segments(true);
        try (Store store = createStore(newFSDirectory(storeDir))) {
        final Translog translog = assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog();
            for (int i = 0; i < leftLeaves.size(); i++) {
            Engine.IndexResult retryResult = engine.index(duplicate);
                            seqNosBitSet.get(i)
                defaultSettings,
            null,
                    );
                assertNull(retryResult.getTranslogLocation());
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexSettings.getIndexMetadata())
                    newSeqNo,
        );
        }
            }
        try (GatedCloseable<SegmentInfos> snapshot = engine.getSegmentInfosSnapshot()) {
            EngineConfig configWithWarmer = new EngineConfig.Builder().shardId(config.getShardId())
            .build();
    }
            System.nanoTime(),
                lessThanOrEqualTo(globalCheckpoint.get())
            logger.info(
            "1"
    public void testSettings() {
                Thread indexingThread = new Thread(() -> {
        final Supplier<ParsedDocument> doc = () -> {
        // create a document
        ) {
            .put(defaultSettings.getSettings())
        Store store = createStore();
            // this is a reproduction of https://github.com/elastic/elasticsearch/issues/28714
            final AtomicReference<RetentionLeases> retentionLeasesHolder = new AtomicReference<>(
            ParsedDocument doc = testParsedDocument("1", null, testDocument(), B_1, null);
                        engine.translogManager().rollTranslogGeneration();
                        UNASSIGNED_SEQ_NO,
                    ParsedDocument doc = testParsedDocument(
        }
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
                equalTo(localCheckpoint)
                new Engine.Get(true, false, doc.id(), create.uid()).setIfSeqNo(indexResult.getSeqNo() + 1)
                try {
                    );
        final int ops = randomIntBetween(1, 32);
        );
        final Path translogPath = createTempDir("testFailEngineOnRandomIO");
                new Term("_id", parsedDocument.id()),
import static org.mockito.Mockito.when;
                0
            public void afterRefresh(boolean didRefresh) {
        try (Store store = createStore()) {
            assertThat(initialEngine.getProcessedLocalCheckpoint(), equalTo(expectedLocalCheckpoint.get()));
        assertThat(seqID.v2(), equalTo(3L));
        final Path translogPath = createTempDir("testFailEngineOnRandomIO");
            ParsedDocument doc2 = testParsedDocument("2", null, testDocumentWithTextField(), B_2, null);
import org.opensearch.index.mapper.DocumentMapperForType;
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(0));
            }
     * the engine must append the pending chunk before the delete, so the translog order is index then delete and a
            getResult = engine.get(new Engine.Get(true, false, "2", newUid("2")), searcherFactory);
            index.isRetry(),
        assertEquals(flush ? 1 : 2, translogHandler.appliedOperations());
import org.opensearch.cluster.metadata.IndexMetadata;
                    SequenceNumbers.NO_OPS_PERFORMED,
            super(d, conf);
            final EngineConfig config = config(
        Sort indexSort = new Sort(new SortedSetSortField("field", false));
import java.util.concurrent.atomic.AtomicInteger;
            int numDocs = between(1, 20);
            finalActualEngine.ensureOpen();
                                engine.refresh("test refresh");
                doc,
                        + "op["
        engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                assertThat(indexResult.getSeqNo(), equalTo(0L));
                            try (
            boolean cfsCompoundFileFound = false;
            final int threadIdx = threadNum;
            assertEquals(primarySeqNo, recoveringEngine.getSeqNoStats(-1).getMaxSeqNo());
                thread.join();
            assertEquals(maxSeqIDOnReplica, recoveringEngine.getProcessedLocalCheckpoint());
                        PRIMARY,
            );
        );
                }
import static org.hamcrest.Matchers.equalTo;
                ParsedDocument doc = testParsedDocument(idToUpdate, null, testDocument(), B_1, null);
                        // index random number of docs
    }
                createTempDir(),
                    expectedSeqNos.add(deleteResult.getSeqNo());
                engineFailureReasons
            engine.flush();
        }
                }
                lastSyncedGlobalCheckpointBeforeCommit.set(Translog.readGlobalCheckpoint(translogPath, translogUUID));
            Versions.MATCH_DELETED,
        applyOperations(engine, operations);
            0,
            }
        }
            final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            IOUtils.close(noOpEngine);
                engine.index((Engine.Index) operation);
        Document document = testDocumentWithTextField();
            assertThat(engine.segments(false), empty());
import org.opensearch.common.TriFunction;
        // If the new index commit still points to the same translog generation as the current index commit,
import java.io.UncheckedIOException;
                        null,
        try (Translog.Snapshot snapshot = getTranslog(engine).newSnapshot()) {
            assertTrue(engine.isClosed.get());
                        System.nanoTime(),
        assertThat(engine.shouldPeriodicallyFlush(), equalTo(false));
                        index.parsedDoc().rootDoc().add(new KeywordField("foo", "bar", org.apache.lucene.document.Field.Store.YES) {
            assertThat(stats1.getGeneration(), greaterThan(0L));
        final List<Throwable> out = new ArrayList<>();
            delete.startTime(),
        } else {
                source,
                try {
        );
                randomIntBetween(1, 8),
                        equalTo(seqNosInSafeCommit.contains(op.seqNo()))
                UNASSIGNED_SEQ_NO,
    }
                    if (!deletedDocs.contains(idToDelete)) {
        }
        for (int i = 0; i < numDocs; i++) {
        IOUtils.close(engine, store);
            Runnable r = () -> {
        }
        );
                final Engine.Delete delete = new Engine.Delete(
            }
        Set<String> deletedDocs = new HashSet<>();
        assertThat("Repeated discards remain a no-op", engine.shouldPeriodicallyFlush(), equalTo(false));
                op.version(),
                        Translog.Index indexOp = (Translog.Index) operation;
            engine.index(replicaIndexForDoc(testParsedDocument("0", null, testDocumentWithTextField(), SOURCE, null), 1, 0, false));
                if (leftLeaves.get(i).reader() != rightLeaves.get(i).reader()) {
            randomBoolean() ? Versions.MATCH_DELETED : Versions.MATCH_ANY,
            Engine.IndexResult indexResult = engine.index(firstIndexRequest);
            assertEquals(0, recoveringEngine.fillSeqNoGaps(3));
        final Term uid = newUid("1");
                if (safeCommit.getUserData().containsKey(Engine.MIN_RETAINED_SEQNO)) {
                    operations.add(index);
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
                    UNASSIGNED_SEQ_NO,
            } else {
                    throw new IllegalStateException("Invalid op [" + type + "]");
            }
                        newUid(doc),
                    engine.flush(false, true);
            assertEquals("updated", luceneDoc.get("value"));
        Engine.IndexResult indexReplicaResult = replicaEngine.index(firstIndexRequestReplica);
                    null,
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            try (InternalEngine engine = createEngine(indexSettings, store, createTempDir(), NoMergePolicy.INSTANCE, (directory, iwc) -> {
                    engine.flush(randomBoolean(), true);
            engine.index(
        expectThrows(EngineException.class, batch::finish);
        expectThrows(AlreadyClosedException.class, () -> engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL));
                    // engine is flushed properly before shutting down.
        public long deleteDocuments(Term... terms) throws IOException {
                        assertEquals(store.refCount(), refCount);
        assertThat(batchEngine.getProcessedLocalCheckpoint(), equalTo(1L));
        final Path translogPath = createTempDir();
import org.opensearch.cluster.routing.ShardRoutingState;
                int someIters = randomIntBetween(1, 10);
    }
    }
         * Constructs a new IndexWriter per the settings given in <code>conf</code>. If you want to make
        assertEquals(0, engine.getNumIndexVersionsLookups());
        try {
                primaryTerm.get()
        Store store = createStore();
            assertNotNull(indexResult.getTranslogLocation());
            IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings);
                                        engine::acquireSearcher
                false,
                    throw new AssertionError(e);
        );
                UNASSIGNED_SEQ_NO,
                    parsedDocument.rootDoc().add(new StoredField("foo", "bar") {
                index(engine, i);
            EngineConfig config = config(defaultSettings, store, translogPath, newMergePolicy(), new ReferenceManager.RefreshListener() {
            engine.refresh("test");
    }
                    for (LeafReaderContext ctx : searcher.getIndexReader().getContext().leaves()) {
                    if (versionedOp) {
                        VersionType.INTERNAL,
        final CountDownLatch done = new CountDownLatch(1);
 * specific language governing permissions and limitations
                    assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        );
                    @Override
                        doc,
        engine = createEngine(copy(engine.config(), newMergePolicy(random(), false)));
                .indexSettings(config.getIndexSettings())
            userData.put(Engine.SYNC_COMMIT_ID, syncId);
                null
                .field("type", "text")
import org.opensearch.common.UUIDs;
            final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> engine.delete(op));
                new RetentionLeases(primaryTerm, retentionLeasesVersion.get(), Collections.emptyList())
                        );
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), retainedExtraOps);
     * operations trips the operation cap, which appends the accumulated chunk without an explicit flush — so every
        }
                engine.engineConfig.getIndexSettings().updateIndexMetadata(indexMetadata);
            } else {
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(0));
                InternalEngine engine = createEngine(config(indexSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null))
        }
        assertVisibleCount(engine, docDeleted ? 0 : 1);
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 1)
            assertThat(segments.size(), equalTo(1));
                                startGun.await();
            operation.startTime() + 1,
                        assertSame(internalSearcher.getDirectoryReader(), externalSearcher.getDirectoryReader());
import org.apache.lucene.search.TermQuery;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        Engine.Index create = new Engine.Index(newUid(doc), primaryTerm.get(), doc, Versions.MATCH_DELETED);
                        containsString(
                    null,
            // Create a store where directory is closed during unreferenced file cleanup.
                    String id = Integer.toString(i);
            .eventListener(config.getEventListener())
                                engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
        final Set<String> liveDocs = new HashSet<>();
            Store store = createFailingDirectoryStore(wrapper);
        );
    private Tuple<Long, Long> getSequenceID(Engine engine, Engine.Get get) throws EngineException {
        long lastOpTerm = UNASSIGNED_PRIMARY_TERM;
            index.version(),
    }
                engine.translogManager().syncTranslog();
            assertThat(engine.failedEngine.get(), not(nullValue()));
                        operations.add(delete);
            assertEquals(checkpointOnReplica, replicaEngine.getProcessedLocalCheckpoint());
                if (randomBoolean()) {
            assertEquals(1, searcher.getDirectoryReader().numDocs());
        create = new Engine.Index(
    public void testBatchedRealtimeGetFromAnotherThreadForcesAppend() throws Exception {
                TranslogHandler translogHandler = createTranslogHandler(config.getIndexSettings(), engine);
    public void testSegmentsWithIndexSort() throws Exception {
            .internalRefreshListener(config.getInternalRefreshListener())
                }
        Engine.Index operation = appendOnlyPrimary(doc, false, 1, create);
            }
import org.opensearch.common.SetOnce;
            while (running.get()) {
            // Give the gc pruning logic a chance to kick in
            UNASSIGNED_SEQ_NO,
            null,
        assertEquals(0, engine.getNumVersionLookups());
                            0
        for (int i = 0; i < numOps; i++) {
                final ParsedDocument doc1 = testParsedDocument("1", null, testDocumentWithTextField(), SOURCE, null);
                        assertEquals(
            for (int i = 0; i < numDocsFirstSegment; i++) {
                    } catch (EngineCreationFailureException ex) {
     *
        ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
import org.opensearch.index.mapper.ParseContext;
            engine.refresh("test");
                    assertThat(result.isFound(), equalTo(docDeleted == false));
            indexSettings.getTranslogRetentionSize(),
                config(
        );
            } else {
    }
                String id = Integer.toString(i);
        final boolean create = randomBoolean();
            // a stale op on a segment replication index fills the gap without touching lucene
                .indexSort(config.getIndexSort())
            )
                null
            );
    public void testForceMergeAndClose() throws IOException, InterruptedException {
        // other version types don't support out of order processing.
        try (
            Translog.Operation op1 = snapshot.next();
                assertEquals(maxTimestamp12, engine.segmentsStats(false, false).getMaxUnsafeAutoIdTimestamp());
    private void getSnapshotAndAssertFilesExistLocally() throws IOException {
                null
                        i,
                engine.index(indexForDoc(doc));
        }
            } else {
            int iterations = scaledRandomIntBetween(1, 50);
        try (InternalEngine engine = createEngine(store, createTempDir(), globalCheckpoint::get)) {
    }
            } else {
            globalCheckpoint::get
    public void testCleanUpCommitsWhenGlobalCheckpointAdvanced() throws Exception {
            index = indexForDoc(testParsedDocument("3", null, testDocument(), B_1, null));
            Loggers.setLevel(iwIFDLogger, Level.TRACE);
            1,
                    if (randomInt(100) < 5) {
                    dump.append("    at ").append(frame).append('\n');
                    startGun.countDown();
                    }
                    new Engine.Index(
            engine.index(index);
            final ShardRouting initializingReplica = TestShardRouting.newShardRouting(
        final int numberOfTriplets = randomIntBetween(1, 32);
            index.startTime(),
                SegmentsStats stats = engine.segmentsStats(true, false);
    }
            assertEquals(1, engine.getNumVersionLookups());
                        testDocumentWithTextField(),
                    try (InternalEngine engine = new InternalEngine(config)) {
                }
                    VersionType.INTERNAL,
        engine.refresh("test");
                } else {
                // Delete some documents
                engine.index(doc);
            }
            try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
            engine.refresh("test");
            assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
            globalCheckpoint::get
        // test that we can force start the engine , even if the translog is missing.
            @Override
        searchResult = engine.acquireSearcher("test");
        int numDocs = randomIntBetween(1000, 10000);
                assertNotNull(id);
                    if (rarely()) {
                    break;
                // Index one document. The _id field goes through FuzzyFilterPostingsFormat;
            Document document = testDocumentWithTextField();
        assertThat(first.getTranslogLocation(), nullValue());
            final Engine.IndexResult result = engine.index(replicaIndexForDoc(doc, 1L, id, false));
                final LocalCheckpointTracker tracker = engine.getLocalCheckpointTracker();
                maxSeqNo,
                    }
                            while (true) {
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
                assertEquals(11, searchSearcher.getIndexReader().numDocs());
                    assert false : "unsupported failure class: " + failure.getClass().getCanonicalName();
                engine.flush();
        }
        }
            engine.refresh("test");
            searchResult,
        );
                globalCheckpoint::get,
                    if (ex.getCause() != null) {
            }
        engine.ensureOpen();
                engine.index(appendOnlyPrimary(doc, false, 1));
            NoMergePolicy.INSTANCE,
                thrown == null ? "nothing\n" : describeExceptionChain(thrown),
                engine.delete(
            final Thread[] snapshotThreads = new Thread[between(1, 3)];
                }
            throw new AssertionError(ex);
                    assertFalse(genFile + " wasn't cleaned up", Files.exists(genFile));
                            primaryTerm.get(),
import org.opensearch.common.util.concurrent.ReleasableLock;
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 0)
        engine.refresh("test");
                    Translog.Operation operation;
                )
                    }
                }
                    0
            Engine.Operation.Origin.PRIMARY,
            if (operation instanceof Engine.Index) {
                new RetentionLeases(primaryTerm, retentionLeasesVersion.get(), Collections.emptyList())
            if (rarely()) {
                                    org.apache.lucene.document.Document document = storedFields.document(get.docIdAndVersion().docId);
        Engine.Index idxRequest = new Engine.Index(
        }
import org.apache.lucene.index.TieredMergePolicy;
            assertEquals(0, engine.getNumVersionLookups());
        }
        try (Engine.Searcher searcher = engine.acquireSearcher("get", Engine.SearcherScope.INTERNAL)) {
                Map<String, String> userData = commit.getUserData();
                "NRT SegmentInfos should carry the last-committed translog UUID",
        long actualLocalCheckpoint = engine.getProcessedLocalCheckpoint();
        }
    }
        int numDocs = between(10, 100);
        for (int i = 0; i < threads.length; i++) {
        if (lastFieldValueDoc2 != null) {
        for (Thread thread : indexingThreads) {
        store.associateIndexWithNewTranslog(translogUUID);
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
        );
                    sawIndexWriterMessage = true;
                System.nanoTime(),
            assertNotNull(retryResult.getTranslogLocation());
import org.opensearch.Version;
                );
    /**
                    engine.translogManager().rollTranslogGeneration(); // make adding operations to translog slower
    }
        Engine.Index operation = appendOnlyReplica(doc.get(), replicaOperationIsRetry, 1, randomIntBetween(0, 5));
                indexSettings.getTranslogRetentionSize(),
                final String id;
            initialEngine = engine;
                Long.parseLong(initialEngine.commitStats().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)),
                .recoverFromTranslog(translogHandler, recoveringEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        indexResult = replicaEngine.index(index);
                        final IndexResult r = engine.index(index);
            engine.getLastCommittedSegmentInfos().getUserData().get(Engine.SYNC_COMMIT_ID)
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                assertNull(retryResult.getTranslogLocation());
        engine.ensureOpen();
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
            ParsedDocument doc2 = testParsedDocument("2", null, testDocumentWithTextField(), B_2, null);
                engine.index(replicaIndexForDoc(doc, 1, seqNo, randomBoolean()));
                VersionType.INTERNAL,
                try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, numDocs - 1, true, false)) {
            doc,
            engine.refresh("test");
            for (int i = 0; i < numDocs; i++) {
            engine.refresh("test");
    // this test writes documents to the engine while concurrently flushing/commit
            }
                        assertThat(initialEngine.getSeqNoStats(-1).getMaxSeqNo(), equalTo(primarySeqNo + 1));
            try (InternalEngine engine = new InternalEngine(config)) { // do not recover from translog
                        engine.translogManager().rollTranslogGeneration();
                            uidTerm,
                        }
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        engine.clearUncommittedSegmentBytes();
        final Engine.EventListener listener = new Engine.EventListener() {
                                try (
            newUid(doc),
            indexSettings.getSoftDeleteRetentionOperations()
                ParsedDocument document3 = testParsedDocument(Integer.toString(3), null, testDocumentWithTextField(), SOURCE, null);
            throw new EngineException(shardId, "unable to retrieve sequence id", e);
            false
            config(
            )
            committedUserData = commit.get().getUserData();
                        IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
    public void testAcquireIndexCommit() throws Exception {
            }
                entry.getKey().join();
     * operation. The first value in the tuple is the sequence number, the
        indexResult = replicaEngine.index(index);
                )
            for (int i = 0; i < snapshotThreads.length; i++) {
                        )
        doReturn(true).when(batchEngine).isTranslogBatchingEligible();
                } else {
                // last op wasn't delete
import static org.hamcrest.Matchers.lessThan;
            randomFrom(VersionType.INTERNAL, VersionType.EXTERNAL),
                indexingThreads.add(indexingThread);
            }
        }
        Thread rollTranslog = new Thread(() -> {
                // First index documents
                        UNASSIGNED_SEQ_NO,
                    indexedDocs.release();
                }
        engine.translogManager().rollTranslogGeneration();
        engine.close();
        Settings.Builder settingBuilder = Settings.builder()
            try (InternalEngine engine = createEngine(configWithWarmer)) {
            "1"
                    }
        final List<Engine.Operation> opsDoc1 = generateSingleDocHistory(
        refreshThread.start();
            UNASSIGNED_SEQ_NO,
                assertNotNull(indexResult.getTranslogLocation());
        // Create engine config with document mapper supplier
        try (Store store = createStore()) {
            boolean engineClosedAfterwards
            autoGeneratedIdTimestamp,
                ParsedDocument document2 = testParsedDocument(Integer.toString(2), null, testDocumentWithTextField(), SOURCE, null);
            Engine.IndexResult indexResult = engine.index(operation);
        ) {
                try {
        }
        } else {
        assertThat(batch.finish(), nullValue());
                            "local checkpoint [" + localCheckpoint + "], _seq_no [" + i + "] should be indexed",
                    );
                }
            // the merge listner runs concurrently after the force merge returned
        for (int i = 0; i < numDocs; i++) {
    @LockFeatureFlag(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG)
                UNASSIGNED_SEQ_NO,
            }
            final long gapSeqNo = randomLongBetween(
                                null
        } else {
        }
    /**
        }
    public void testVerboseSegments() throws Exception {
            randomFrom(VersionType.INTERNAL, VersionType.EXTERNAL),
        }
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                    FixedBitSet seqNosBitSet = getSeqNosSet(reader, highestSeqNo);
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        assertThat(noOpResult.getTerm(), equalTo(term));
            for (Engine.Operation op : operations) {
                        numDocs + numDocsToDelete + i,
                    }
            Versions.MATCH_DELETED,
            indexWriterFactory,
                });
                    fail("io exception not expected");
            final ParsedDocument doc = testParsedDocument(
            engine.refresh("warm_up");
            testDocumentWithTextField("updated"),
                Engine.Delete delete = (Engine.Delete) operation;
        } catch (Exception e) {
                engine.forceMerge(randomBoolean(), 1, false, false, false, UUIDs.randomBase64UUID());
            Store store = createStore();
                    assertThat(msg, versionValue.version, equalTo(op.version()));
            @Override
    private void runTestDeleteFailure(final CheckedBiConsumer<InternalEngine, Engine.Delete, IOException> consumer) throws IOException {
            assertThat(rootCause(ownerFailure), sameInstance(failure));
        assertThat(batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
                final Set<Long> seqNosInSafeCommit = operationsInSafeCommit.stream().map(op -> op.seqNo()).collect(Collectors.toSet());
                        i,
            InternalEngine engine = createEngine(
            }
                } else {
            );
        Engine initialEngine = null;
        engine.close();
        Engine.Index create = new Engine.Index(newUid(doc), primaryTerm.get(), doc, Versions.MATCH_DELETED);
                }
                            }
            }
        engine = new InternalEngine(engine.config());
    }
                    0
            stopped.set(true);
        Engine.IndexResult result = batchEngine.index(op);
            delete.origin(),
        try (Store store = createStore()) {
            engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
                        doc,
                UNASSIGNED_SEQ_NO,
    public void testTranslogBatchingIgnoredWithoutRemoteStore() {
        int totalExpectedOps = 0;
        engine.refresh("warm_up");
        runTestDeleteFailure(InternalEngine::delete);
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
        CodecService codecService = new CodecService(mapperService, indexSettings, logger, List.of());
                public void onFailedEngine(String reason, Exception e) {
        indexResult = replicaEngine.index(create);
    private EngineConfig createEngineConfigWithMapperSupplierForDerivedSource(Store store, boolean contextAwareEnabled) throws IOException {
        }
        InternalEngine actualEngine = null;
        engine.updateUncommittedSegmentBytes(committedOnlySizeMap, 1L);
            final int gapsFilled = noOpEngine.fillSeqNoGaps(primaryTerm.get());
                    equalTo(engine.getMinRetainedSeqNo())
            final String id = "id";
        searchResult = engine.acquireSearcher("test");
     * Parity with {@code DataFormatAwareEngine}: closing the engine aborts every live batch. A document deferred in a
                                engine.flush(true, true);
            final long safeCommitCheckpoint;
            currentTerm.get(),
        ParsedDocument doc = testParsedDocument("1", null, testDocument(), bytesArray(""), null);
            isRetry,
        engine.ensureOpen();
        final CountDownLatch cleanupCompleted = new CountDownLatch(1);
        final DrainFailureOutcome outcome = driveRefreshDrainOfFailedBatchAppend(tragic, FailingBatchAppendTranslog.FailureClass.TRAGIC);
        assertThat(message, engine.getNumDocAppends(), equalTo(expectedAppends));
                null,
        }
            2,
    /** Outcome of a refresh that drained another request's batch whose append failed. */
                if (callStackContainsAnyOf("mergeTerms")) {
                .field("source", "String.valueOf(grouping_criteria)")
                    "id_" + seqNo,
            new BytesArray("{}".getBytes(Charset.defaultCharset())),
        final int numDocs = randomIntBetween(1, 100);
        return new InternalEngine(config) {
            ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
                assertNull(indexResult.getTranslogLocation());
                committedUserData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY),
            }
            assertFalse(mockAppender.sawIndexWriterMessage);
                        userData = engine.getLastCommittedSegmentInfos().getUserData();
        }
                ParsedDocument document1 = testParsedDocument(Integer.toString(1), null, testDocumentWithTextField(), SOURCE, null);
            docs.add(retryIndex);
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 0)
        document = testDocument();
                numSegments = searcher.getDirectoryReader().leaves().size();
                final InternalEngine engine = createEngine(store, createTempDir());
            1,
                "test",
        assertThat(batchEngine.getProcessedLocalCheckpoint(), equalTo(1L));
                + (outcome.refreshFailure == null ? "" : describeExceptionChain(outcome.refreshFailure)),
    public void testTranslogMultipleOperationsSameDocument() throws IOException {
        IOUtils.close(engine, store);
                    store,
            newUid(doc),
            int numDocs = scaledRandomIntBetween(10, 100);
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                });
            engine.refresh("test");
        if (origin == PRIMARY) {
                        for (int i = 0; i < numDocsPerThread; i++) {
        engine = createEngine(
            for (Engine.Operation op : operations) {
                assertNotNull(indexResult.getFailure());
                                throw new RuntimeException(e);
                this.added = added;
            for (int i = 0; i < iterations && liveDocsFirstSegment.isEmpty() == false; i++) {
                        Map<String, String> userData = engine.getLastCommittedSegmentInfos().getUserData();
                        indexedIds.add(id);
                        doc,
                .build()
        store.close();
                assertThat(userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY), equalTo(Long.toString(3 * i)));
        final Translog translog = createTranslog(() -> newPrimaryTerm);
                finalActualEngine.flush();
                .startArray("contacts")
        searchResult.close();
                    return tombstoneDocSupplier().newNoopTombstoneDoc(reason);
                        long fileCount = Arrays.stream(store.directory().listAll())
import static org.hamcrest.Matchers.hasKey;
                assertThat(engine.getProcessedLocalCheckpoint(), equalTo(maxSeqNo));
        };
            delete.getIfSeqNo(),
         * @throws IOException if the directory cannot be read/written to, or if it does not exist and
        Engine.Index firstIndexRequestReplica = new Engine.Index(
                            new PrunePostingsMergePolicy(indexWriterConfig.getMergePolicy(), "_id")
        }
            .primaryTermSupplier(config.getPrimaryTermSupplier())
                    engine.delete(replicaDeleteForDoc(UUIDs.randomBase64UUID(), 1, seqno, threadPool.relativeTimeInMillis()));
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
            isRetry,
                // Update some remaining documents.
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
                        latestOps.put(op.id(), op);
        }, null, null, config(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null))) {
            assertThat(
            engine.translogManager().skipTranslogRecovery();
    public void testDoubleDeliveryReplica() throws IOException {
            for (int i = 0; i < numberOfOperations; i++) {
            assertThat("op " + i + " should have been appended by the operation cap", results.get(i).getTranslogLocation(), notNullValue());
            noOpEngine.translogManager().recoverFromTranslog(translogHandler, noOpEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                    fail();
            boolean committed = randomBoolean();
                .endObject()
            assertNotNull(retryResult.getTranslogLocation());
                assertTrue((maxSeqIDOnReplica + 1) - numDocsOnReplica <= snapshot.totalOperations());
        // text fields use the standard Lucene format. Two distinct PostingsFormat instances
                }
            engine.translogManager().getTranslogStats().getUncommittedSizeInBytes() - extraTranslogSizeInNewEngine
            assertThat(getResult.docIdAndVersion(), notNullValue());
                }
    public void testFailEngineOnRandomIO() throws IOException, InterruptedException {
                                public CacheHelper getCoreCacheHelper() {
                // First index documents
        Engine.TranslogBatch batch = batchEngine.beginTranslogBatch();
        }
        for (Throwable suppressed : allSuppressed(outcome.refreshFailure)) {
        ) {
            );
                    retentionLeasesHolder::get,
                public void beforeRefresh() throws IOException {}
                }
        assertThat(second.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            assertEquals(docs - 1, engine.getSeqNoStats(-1).getMaxSeqNo());
            boolean committed = randomBoolean();
            if (randomBoolean()) {
        final AtomicLong expectedLocalCheckpoint
            segments = engine.segments(false);
            if (engine.engineConfig.getIndexSettings().isSoftDeleteEnabled()) {
                    assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        for (int i = 0; i < thread.length; i++) {
            assertThat(segments.get(1).committed, equalTo(committed));
                    // fine
            Engine.IndexResult retryResult = engine.index(duplicate);
        try (Store store = createStore(newFSDirectory(storeDir)); Engine engine = createEngine(configSupplier.apply(store))) {
        Store store = createStore();
                try {
        engine.ensureOpen();
            // Arm the failure for the next batched append, which is the refresh's drain.
        );
        );
            snapshots.get(numSnapshots - 1).close(); // release the last snapshot - delete all except the last commit
                List<Translog.Operation> operationsFromLucene = readAllOperationsInLucene(noOpEngine);
                        // Safe to remove from file count along with write.lock without impacting the test.
            assertEquals(sameSeqNo ? 1 : 2, engine.getNumVersionLookups());
                indexSettings.getSoftDeleteRetentionOperations()
            assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
            }
        final Store store = config.getStore();
                        System.nanoTime(),
            assertThat(readAllOperationsInLucene(engine), hasSize(liveDocsWithSource.size()));
import org.opensearch.core.common.unit.ByteSizeValue;
    public void testNoOps() throws IOException {
                .put(indexSettings.getSettings())
import java.util.Map;
        }
        try {
                    } catch (IOException e) {
        Collections.shuffle(docs, random());
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 1)
            VersionConflictEngineException.class,
        }
            TranslogHandler translogHandler = createTranslogHandler(initialEngine.config().getIndexSettings(), recoveringEngine);
                            System.currentTimeMillis(),
            assertThat(last, instanceOf(Translog.NoOp.class));
                            Engine.Operation.Origin.REPLICA,
        }
                    assertThat(result.getVersion(), equalTo(op.version()));
                long actualTotal = fileSizes.values().stream().mapToLong(Long::longValue).sum();
            assertEquals(0, engine.getNumVersionLookups());
                }
                            .filter(file -> file.equals("write.lock") == false && ExtrasFS.isExtra(file) == false)
        );
            }
            engine.index(indexForDoc(doc2));
                assertSameReader(getSearcher, searchSearcher);
            final Throwable current = work.pop();
        if (randomBoolean()) {
                try (InternalEngine engine = createEngine(config)) {
                    }
            final long localCheckPoint = engine.getProcessedLocalCheckpoint();
        assertThat(second.getTranslogLocation(), nullValue());
        List<LeafReaderContext> leftLeaves = OpenSearchDirectoryReader.unwrap(left.getDirectoryReader()).leaves();
        Engine.Index operation = replicaIndexForDoc(doc, 1, 20, false);
                    throw ex;
                0,
    private static Throwable rootCause(Throwable t) {
                (engine, operation) -> seqNoGenerator.getAndIncrement()
            "2"
            final Thread refresher = new Thread(() -> {
        final Engine.Operation lastOpDoc2 = opsDoc2.get(opsDoc2.size() - 1);
                .build();
            }
            assertOpsOnPrimary(ops, Versions.NOT_FOUND, true, engine);
                .recoverFromTranslog(translogHandler, recoveringEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        try (Store store = createStore()) {
            null
                    }
        List<Engine.Operation> ops = generateHistoryOnReplica(between(1, 50), false, randomBoolean(), randomBoolean());
            result.getVersion(),
                    );
            for (int i = 0; i < numDocs; i++) {
        }
        }
     * Creates a merge policy which only supports force merge.
            totalNumberOfDocsRefreshed += numDocs;
        store = createStore(defaultSettings, newDirectory());
        // to simulate this we need concurrent flush/refresh.
        final AtomicReference<ThrowingIndexWriter> iw = new AtomicReference<>();
                }
                        doneLatch.countDown();
                )
        try (
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
        int maxDocs = randomIntBetween(1, 100);
            searchResult,
                        false,
        for (int i = 0; i < closingThreads.length; i++) {
        for (int i = 0; i < thread.length; i++) {
                };
                        i,
                assertThat(getDocIds(engine, randomBoolean()), equalTo(docs));
            final ParsedDocument doc2 = testParsedDocument("2", null, testContextSpecificDocument("grouping_criteria"), B_1, null);
        final int opsOnPrimary = assertOpsOnPrimary(primaryOps, finalReplicaVersion, deletedOnReplica, replicaEngine);
                public void onFailedEngine(String reason, Exception e) {
            assertThat(segments.get(0).getDeletedDocs(), equalTo(0));
        rootLogger = LogManager.getRootLogger();
            autoGeneratedIdTimestamp,
            engine.index(indexForDoc(doc2));
            int i = 0;
            });
        indexSettings.updateIndexMetadata(indexMetadata);
            }
            testDocumentWithTextField(),
                UNASSIGNED_SEQ_NO,
                                // Verify updated content using get
            .mergePolicy(config.getMergePolicy())
            }
                    }
            }
        }
            final Engine.Index retryIndex;
                new BytesArray("{}".getBytes(Charset.defaultCharset())),
            assertEquals(maxSeqIDOnReplica, recoveringEngine.getSeqNoStats(-1).getMaxSeqNo());
                        assertThat(msg, ((Translog.Index) op).id(), is(in(liveDocs)));
            try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
            for (Thread thread : snapshotThreads) {
                        rarely() ? 100 : Versions.MATCH_ANY,
            logger.info("searching for [{}]", lastFieldValue);
                try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                final Engine.Index index = new Engine.Index(
        // The batch was aborted during close: the deferred op never got a location, and finishing the batch now
                public void afterRefresh(boolean didRefresh) throws IOException {
        engine.close();
            // In context aware scenario, addIndexes triggers a non blocking merge before refresh triggers it, so this test case fails
        assertThat("Zero uncommitted bytes never trigger a flush", engine.shouldPeriodicallyFlush(), equalTo(false));
        } else {
    }
                        "append operations should not advance max_seq_no_of_updates",
            .queryCachingPolicy(config.getQueryCachingPolicy())
        assertThat("Stale commit generation stamp is ignored after flush", engine.shouldPeriodicallyFlush(), equalTo(false));
        AtomicReference<Exception> exception = new AtomicReference<>();
                    }
            PRIMARY,
                throw new RuntimeException(ex);
                        );
                    );
        }
            operation.versionType(),
            final Path translogPath = createTempDir("testFailStart");
            }
        // create N indexing threads to index documents simultaneously
     *
            assertEquals(totalNumberOfDocsRefreshed - 1, engine.getMaxSeqNoFromSegmentInfos(segmentInfosGatedCloseable.get()));
            .tombstoneDocSupplier(config.getTombstoneDocSupplier())
        final long generationThreshold = randomLongBetween(1000, 5000);
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 0)
        final TieredMergePolicy mergePolicy = new TieredMergePolicy();
                            }
                if (randomBoolean()) {
            final ParsedDocument doc2 = testParsedDocument("1", null, testContextSpecificDocument("grouping_criteria_update"), B_1, null);
    }
            thread.start();
                            null,
        Thread reader = new Thread(() -> {
            .put(defaultSettings.getSettings())
                    } else {
            );
                    engine.index(indexForDoc(testParsedDocument(UUIDs.randomBase64UUID(), null, testDocument(), B_1, null)));
                IOUtils.close(engine);
                    origin == PRIMARY ? VersionType.EXTERNAL : null,
        Engine.IndexResult update_1_result = engine.index(update_1);
        assertThat(result.getTranslogLocation(), notNullValue());
        final BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory = engine::acquireSearcher;
                // Advance the global checkpoint during the flush to create a lag between a persisted global checkpoint in the translog
                    engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
                false,
                }
            final AtomicReference<CountDownLatch> latchReference = new AtomicReference<>(new CountDownLatch(1));
                if (versionConflict) {
                        wrapper.close();
        final IndexSettings indexSettings = engine.config().getIndexSettings();
                        System.nanoTime(),
                        false,
                } else {
                            0
                        for (int i = 0; i < numDocsPerThread; i++) {
                wrappedSnapshot = engine.acquireSafeIndexCommit();
         * @param d    the index directory. The index is either created or appended according <code>
                directory.setFailOnOpenInput(randomBoolean());
            final RuntimeException ownerFailure = expectThrows(RuntimeException.class, batch::finish);
            new BytesArray("{}".getBytes(Charset.defaultCharset())),
            {
            );
        final List<Engine.Operation> allOps = new ArrayList<>();
                }
        isRetry = false;
                        engine.delete(delete);
            engine.translogManager().syncTranslog(); // to advance persisted local checkpoint
            }
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
                }
        /**
        InternalEngine recoveringEngine = null;
                final TotalHitCountCollector collector = new TotalHitCountCollector();
                new Engine.Get(true, false, doc.id(), create.uid()).setIfSeqNo(indexResult.getSeqNo())
                    operations.add(
        retry = appendOnlyPrimary(doc, true, 1, create);
            )
    }
                public void run() {
import org.opensearch.common.settings.Settings;
            assertThat(op1.seqNo(), equalTo(0L));
            for (long seqNo = 0; seqNo <= maxSeqNo; seqNo++) {
            initialEngine.ensureOpen();
                Engine.Searcher getSearcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
                                Engine.GetResult get = engine.get(
            assertTrue(mockAppender.sawIndexWriterMessage);
        long lastOpSeqNo = UNASSIGNED_SEQ_NO;
                    expectedLocalCheckpoint.set(seqNo);
            );
        BiFunction<Long, Engine.Delete, Engine.Delete> delWithVersion = (version, delete) -> new Engine.Delete(
        ParsedDocument doc = testParsedDocument(Integer.toString(0), null, testDocumentWithTextField(), SOURCE, null);
                thread.start();
                    String notFoundId = randomValueOtherThanMany(liveOps::containsKey, () -> Long.toString(randomNonNegativeLong()));
            }
    public void testLookupSeqNoByIdInLucene() throws Exception {
            Store store = createStore();
        assertEquals(store.readLastCommittedSegmentsInfo().getUserData().get(Engine.SYNC_COMMIT_ID), syncId);
                while ((op = snapshot.next()) != null) {
                    groupingCriteria = "grouping_criteria2";
                if (seqno < minSeqNoToRetain) {
        };
            InternalEngine engine = createEngine(
        // Optionally, index more docs without refreshing. These should not be part of getMaxSeqNoRefreshed
        engine.refresh("test");
            defaultSettings,
            )
        }
            assertEquals((maxSeqIDOnReplica + 1) - numDocsOnReplica, recoveringEngine.fillSeqNoGaps(2));
                            UNASSIGNED_SEQ_NO,
import java.nio.charset.Charset;
            expectedLocalCheckpoint = numberOfOperations - 1;
                .startObject("properties")
        MatcherAssert.assertThat(
                    actualTotal
                    assertFalse("should not have more than one document with the same seq_no[" + seqNo + "]", bitSet.get((int) seqNo));
        assertThat(seqID.v1(), equalTo(2L));
                Engine.Operation.Origin.PRIMARY,
            assertThat(attributes, Matchers.containsInAnyOrder("grouping_criteria1", "grouping_criteria2", "grouping_criteria3"));
                }
     * Verifies that {@code getSegmentFileSizes} correctly accumulates sizes for all files in a
                                }
            "1",
            assertEquals("NRT SegmentInfos userData should match committed userData in full", committedUserData, nrtUserData);
            Map.Entry<String, Long> firstEntry = stats.getFileSizes().entrySet().iterator().next();
                minTranslogGen = assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().getMinFileGeneration();
                    engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                PRIMARY,
            }
        try (Store store = createStore(wrapper)) {
                snapshotThreads[i].start();
                engine = createEngineForWrapper(
            engine.index(indexForDoc(testParsedDocument(Integer.toString(i), null, testDocumentWithTextField(), SOURCE, null)));
                final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
                    ParsedDocument doc = testParsedDocument(
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), flushThreshold + "b")
                } else {
        doReturn(true).when(batchEngine).isTranslogBatchingEligible();
                assertFalse(engine.throttleLockIsHeldByCurrentThread());
                ParsedDocument doc = testParsedDocument(Integer.toString(0), null, testDocument(), new BytesArray("{}"), null);
                throwingIndexWriter.set(new ThrowingIndexWriter(directory, iwc));
                    } else if (rarely()) {
            null,
            nullValue()
                        -1,
                int to = randomIntBetween(from, operations.size() - 1);
                snapshotThreads[i] = new Thread(new AbstractRunnable() {
            1,
                )
                seqNos.add((long) i);
                String groupingCriteria;
        assertThat(seqID.v2(), equalTo(primaryTerm.get()));
        final BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory = engine::acquireSearcher;
                        );
            assertNotNull(indexResult.getTranslogLocation());
            for (int i = 0; i < deleteBatch; i++) {
                                }
        } else {
            ) {
            assertThat(segments.size(), equalTo(1));
                }
        assertThat("Nothing published yet", engine.shouldPeriodicallyFlush(), equalTo(false));
        // merge completing after the refresh would make the reader non-current and mask what is being tested
            final EngineConfig engineConfig;
        replicaEngine.refresh("test");
    }
            Map<String, String> userData = new HashMap<>();
        final Map<String, Long> localSegmentsSizeMap = new HashMap<>();
            final CyclicBarrier barrier = new CyclicBarrier(numIndexingThreads + 1);
                } else if (rarely()) {
                    }
        return engineConfig;
                    10,
                    null,
        final AtomicReference<Throwable> failure = new AtomicReference<>();
                        flushedOperations.sort(Comparator.comparing(Engine.Operation::seqNo));
            try (InternalEngine engine = new InternalEngine(engineConfig)) {
                                        new Engine.Get(true, true, docId, newUid(docId)),
            assertEquals(1, topDocs.totalHits.value());
            engine.refresh("test");
        final Path translogPath = createTempDir("testFailEngineOnRandomIO");
                    assertThat(
import org.apache.lucene.document.LongPoint;
            0
            searchResult,
        engine.updateUncommittedSegmentBytes(localSegmentsSizeMap, uncommittedBytes + 1);
    }
                                    assertEquals(
            assertEquals(docs.size(), count);
        Function<Engine.Index, Engine.Index> indexWithCurrentTerm = index -> new Engine.Index(
                        count++;
    }
                        primaryTerm.get(),
        final List<Engine.Operation> operations = generateSingleDocHistory(
                        }
    public void testDeleteRoutingPreservedThroughPrepareDelete() throws IOException {
        }
    public void testTrimUnsafeCommits() throws Exception {
                    final Engine.Delete operation = new Engine.Delete(
            assertThat(getResult.docIdAndVersion(), notNullValue());
        Settings.Builder settings = Settings.builder()
            }
                    Engine.Operation.Origin.PRIMARY,
    }
                if (seqno < minSeqNoToRetain) {
                .primaryTermSupplier(config.getPrimaryTermSupplier())
            Engine.Index index = primary ? appendOnlyPrimary(doc, false, i) : appendOnlyReplica(doc, false, i, i);
                    assertThat(result.isCreated(), equalTo(docDeleted));
            restoreIndexWriterMaxDocs();
    public void testMaxDocsOnPrimary() throws Exception {
                // Index documents
        } else {
            }
            "test",
                            return new FilterLeafReader(reader) {
        engine.refresh("test");
                                        new Engine.Get(true, true, docId, newUid(docId)),
        engine.updateUncommittedSegmentBytes(localSegmentsSizeMap, uncommittedBytes);
            barrier.await(); // wait for indexing threads to all be ready to start
                index(engine, numDocs + i);
            source = BytesReference.bytes(builder);
            logger.info(
            ReplicationTracker gcpTracker = (ReplicationTracker) initialEngine.config().getGlobalCheckpointSupplier();
            globalCheckpoint::get
                } else {
            // Fill the seqno gap - should prune all tombstones.
            final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            engine.index(indexForDoc(doc));
            refresher.join();
                lastOpSeqNo;
            engine.refresh("test");
    public void testRefreshDrainsPendingBatchBeforeVisibility() throws Exception {
        engine.index(update);
                        assertThat(op, instanceOf(Translog.Index.class));
            // delete
                    do {
        iter1.forEachRemaining(o -> allOps.add(seqNoUpdater.apply(o, seqNoGenerator.getAndIncrement())));
            }
            for (int i = totalNumberOfDocsRefreshed; i < (totalNumberOfDocsRefreshed + randomIntBetween(10, 100)); i++) {
                searcherFactory
                    throwingIndexWriter.get().setThrowFailure(() -> new IllegalArgumentException("simulated max token length"));
                    assertNull(indexResult.getTranslogLocation());
                    } else {
                    retentionLeasesHolder::get,
            clock.set(randomLongBetween(deleteBatch + gcInterval * 4 / 3, 100)); // Need a margin for gcInterval/4.
            doc,
            final List<Long> commitMaxSeqNo = new ArrayList<>();
                    0
                }
    }
                            }
            final ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), SOURCE, null);
                    );
        document.add(new Field(SourceFieldMapper.NAME, BytesReference.toBytes(B_2), SourceFieldMapper.Defaults.FIELD_TYPE));
        assertThat(indexResult.getVersion(), equalTo(1L));
        );
                assertEquals(numDocs + 1, leafReader.maxDoc());
    public void testShardFailsForCompositeIndexWriterInCaseAddIndexesThrewExceptionWithUpdate() throws IOException, InterruptedException {
        assertThat(result.getTranslogLocation(), nullValue());
            }
        }
import static org.hamcrest.Matchers.contains;
            writer.commit();
            engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
                });
        } else {
            0
        try (Engine recoveringEngine = new InternalEngine(engine.config())) {
            0
                }
            assertThat(getResult.exists(), equalTo(false));
            assertEquals(numIndexingThreads * numDocsPerThread - 1, engine.getMaxSeqNoFromSegmentInfos(segmentInfosGatedCloseable.get()));
                0
                        count++;
        assertThat(uncommittedTranslogOperationsSinceLastCommit.getAsInt(), equalTo(0));
        Settings.Builder settings = Settings.builder()
        boolean isRetry = false;
                    throw new RuntimeException(e);
        for (int i = 0; i < numOps; i++) {
            final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            Engine.IndexResult retryResult = engine.index(retry);
            Store store = createStore();
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
            REPLICA,
            Thread indexingThread = new Thread(() -> {
                });
            List<Translog.Operation> ops = readAllOperationsInLucene(engine);
     * threshold, they do once the threshold published with them is low enough, and a stale commit-generation stamp
                        highestSeqNo = highest.longValue();
                    SequenceNumbers.NO_OPS_PERFORMED,
            .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
    /**
        Store store = createStore();
                            if (updatedDocs.contains(docId)) {
                    deletes++;
                // Test newChangesSnapshot with derived source
            return super.deleteDocuments(terms);
        final int docs = randomIntBetween(1, 32);
                    barrier.await();
                        for (int docID = 0; docID < context.reader().maxDoc(); docID++) {
    }
        engine = createEngine(store, primaryTranslogDir); // and recover again!
    }
        Tuple<Long, Long> seqID = getSequenceID(engine, new Engine.Get(false, false, "2", newUid("1")));
        }
            }
                            EngineTestCase.newUid(doc),
                engine.translogManager().rollTranslogGeneration();
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                        + op.seqNo()
        doc = testParsedDocument(
        ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), new BytesArray("{}"), null);
            // create random commit points
                final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
            int moreDocs = between(1, 20);
            // Cleanup count will be incremented whenever cleanup is performed correctly.
                for (int i = 0; i < numDocsToDelete; i++) {
            doc,
            engine.index(indexForDoc(doc));
        );
            engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
                if (rarely()) {
        try (
                defaultSettings,
            assertThat(DirectoryReader.listCommits(store.directory()), hasSize(1));
        }
                    expectedSeqNos.add(indexResult.getSeqNo());
            "1",
                        UNASSIGNED_SEQ_NO,
        }
        rollTranslog.join();
                if (frequently()) {
    public void testPruneOnlyDeletesAtMostLocalCheckpoint() throws Exception {
                    )
            assertThat(segments.size(), equalTo(3));
            }
            Store store = createStore();
                .endObject()
                    throw new AssertionError(e);
                    engine.index(indexForDoc(doc));
            true,
                }
        }
        assertOpsOnReplica(replicaOps, replicaEngine, true, logger);
                VersionType.INTERNAL,
        }
            final String added;
            indexSettings.getSoftDeleteRetentionOperations()
                out.add(s);
                // now the engine is closed check we respond correctly
            doc,
                try {
            }
            null,
                null,
            } else {
        final int iters = scaledRandomIntBetween(10, 100);
                            }
            assertThat(segments, hasSize(1));
            final long conflictingTerm = conflictingSeqNo == lastOpSeqNo || randomBoolean() ? lastOpTerm + 1 : lastOpTerm;
            assertThat(segments.isEmpty(), equalTo(true));
            assertNull(snapshot.next());
            PRIMARY,
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test1")), 0)
                        } catch (IOException e) {
                            }
                latch.await();
                    throwingIndexWriter.get().setThrowFailure(() -> new IllegalArgumentException("simulated max token length"));
            );
        try (
                    .translogFactory(FailingBatchAppendTranslog.factory(armedFailure))
            Translog.Operation op2 = snapshot.next();
                startGun.countDown();
                "unexpected secondary failure from the refresh unwind: " + describeExceptionChain(suppressed),
        public AddIndexesFailingIndexWriter(Directory d, IndexWriterConfig conf) throws IOException {
                    try {
            .mergePolicy(config.getMergePolicy())
    @LockFeatureFlag(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG)
import java.util.stream.Collectors;
        }
                    }
                        + " seqno="
                    null
            assertNotNull(retryResult.getTranslogLocation());
        Semaphore indexedDocs = new Semaphore(0);
                TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), randomIntBetween(numDocs, numDocs + 10));
        assertThat("refresh must fail when the drained append is tragic", outcome.refreshFailure, notNullValue());
        for (Thread thread : refreshThreads) {
                    assertThat(msg, op, notNullValue());
            : appendOnlyReplica(doc, false, 1, randomIntBetween(0, 5));
                assertThat(collector.getTotalHits(), equalTo(1));
        }
        assertThat(uncommittedTranslogOperationsSinceLastCommit.getAsInt(), equalTo(numDocs));
            // Disable cleanup
            List<Translog.Operation> operations = readAllOperationsInLucene(engine);
                        assertEquals(
                "update: " + seqNo
            iw.get().setThrowFailure(() -> new IllegalArgumentException("fatal"));
    }
        try (GatedCloseable<SegmentInfos> snapshot = engine.getSegmentInfosSnapshot()) {
            final long version;
    /**
            EngineConfig.TombstoneDocSupplier tombstoneDocSupplier = new EngineConfig.TombstoneDocSupplier() {
        if (randomBoolean()) {
    }
        store = createStore();
        } catch (Exception e) {
                .field("age", contactAge)
            return appendOnlyPrimary(doc, retry, autoGeneratedIdTimestamp);
            try (Engine.Searcher searcher = recoveringEngine.acquireSearcher("test")) {
                assertThat(seqNoStats.getMaxSeqNo(), equalTo(prevSeqNoStats.getMaxSeqNo()));
        );
        final List<Engine.Operation> operations = new ArrayList<>();
                indexSettings,
                Long[] expectedOps = existingSeqNos.stream().filter(seqno -> seqno >= minRetainSeqNos).toArray(Long[]::new);
                    ? Long.parseLong(userData.get(SequenceNumbers.MAX_SEQ_NO))
        final CountDownLatch allowMarkProcessed = new CountDownLatch(1);
                    0,
            thread[i].start();
            List<Segment> segments = engine.segments(randomBoolean());
                stall.set(false);
                        try {
                        String removed = op % 3 == 0 && values.size() > 0 ? values.remove(0) : null;
                    );
        InternalEngine batchEngine = spy(engine);
        ) {
        }
            final InternalEngine finalInitialEngine = initialEngine;
            int numDocs = scaledRandomIntBetween(10, 100);
                for (Engine.Operation op : operations) {
                    .eventListener(listener)
            final Thread indexer = new Thread(() -> {
            engine.refresh("test");
            engine.close();
    }
            @Override
                    operations.add(indexForDoc(createParsedDoc(id, null)));
        }
                } else {
                                continue;
            }
        logger.info("--> got seqID: {}", seqID);
                    )
            return new Tuple<>(seqNo, primaryTerm);
        InternalEngine batchEngine = spy(engine);
                assertThat(collector.getTotalHits(), equalTo(1));
                                        document.getField("value").stringValue()
    public void testDoesNotAllowGroupingCriteriaUpdate() throws IOException, InterruptedException {
            }
        int totalNumberOfDocsRefreshed = 0;
        assertThat("Uncommitted bytes below the published threshold", engine.shouldPeriodicallyFlush(), equalTo(false));
            searchResult,
            Engine.IndexResult indexResult = engine.index(index);
                            primaryTerm.get(),
        if (flush) {
                null
                return invocation.callRealMethod();
            final AtomicLong expectedLocalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())
        randomSubsetOf(allOps).forEach(op -> allOps.add(seqNoUpdater.apply(op, op.seqNo())));
        engine.index(indexForDoc(doc));
            final Engine.TranslogBatch batch = batchEngine.beginTranslogBatch();
                UNASSIGNED_SEQ_NO,
                    assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                config.getTranslogConfig().getIndexSettings(),
                engine.ensureOpen();
    }
                        operationsFromLucene.get(i),
                try (engine) {
                    docDeleted = false;
    private int assertOpsOnPrimary(List<Engine.Operation> ops, long currentOpVersion, boolean docDeleted, InternalEngine engine)
                new Engine.NoOp(maxSeqNo + 2, primaryTerm.get(), randomFrom(PRIMARY, REPLICA, PEER_RECOVERY), System.nanoTime(), reason)
            .tombstoneDocSupplier(tombstoneDocSupplier())
            return translog.totalOperationsByMinGen(translog.getMinGenerationForSeqNo(localCheckpoint + 1).translogFileGeneration);
        );
                String idToUpdate = randomFrom(liveDocsFirstSegment);
                        assertThat(r.getFailure(), instanceOf(UncheckedIOException.class));
        // its not deleted yet
        engine.delete(new Engine.Delete("1", newUid("1"), 1));
                        + op.primaryTerm()
            // merge.
        SetOnce<IndexWriter> indexWriterHolder = new SetOnce<>();
            true,
            }
            assertThat(commits, hasSize(1));
            index.origin(),
            delete.version(),
         *
                indexSettings.getTranslogRetentionSize(),
                for (int i = 0; i < numDocsToUpdate; i++) {
                    index.getAutoGeneratedIdTimestamp(),
            UNASSIGNED_SEQ_NO,
                -1,
                                        false,
            final Engine.IndexResult indexResult = e.index(index);
        // we can query by the _seq_no
                    try {
            assertLuceneOperations(engine, 1, 0, 0);
            seqNo++;
                Engine.Operation.Origin.PRIMARY,
    public void testRealtimeGetOnlyRefreshIfNeeded() throws Exception {
            .similarity(config.getSimilarity())
            assertThat(DirectoryReader.listCommits(store.directory()), contains(commits.get(commits.size() - 1)));
                            }
            .settings(
                        UNASSIGNED_SEQ_NO,
        Thread thread = new Thread(() -> {
            assertThat(recoveringEngine.getMinRetainedSeqNo(), equalTo(lastMinRetainedSeqNo));
        engine.refresh("test");
                    assertThat(result.getFailure(), nullValue());
        assertThat("Uncommitted bytes breach the published threshold", engine.shouldPeriodicallyFlush(), equalTo(true));
                int from = randomIntBetween(0, operations.size() / 2);
            Settings.builder().put(defaultSettings.getSettings()).put(EngineConfig.INDEX_USE_COMPOUND_FILE.getKey(), false).build()
            engine.refresh("test");
                        numDocs + numDocsToDelete + i,
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test1")), 0)
                            seqNo,
                .threadPool(config.getThreadPool())
            recoveringEngine.fillSeqNoGaps(2);
import org.opensearch.index.translog.listener.TranslogEventListener;
    }
                    UNASSIGNED_SEQ_NO,
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(seqNo - 1));
                globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
        }
                    long checkPointBeforeRefresh = engine.getProcessedLocalCheckpoint();
        for (int i = 0; i < numCommits; i++) {
            assertThat(engine.segmentsStats(true, false).getFileSizes().size(), equalTo(0));
        } finally {
                    throw (IOException) failure;
            assertThat(segments.get(0).getNumDocs(), equalTo(liveDocsFirstSegment.size()));
            globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
                        Versions.MATCH_ANY,
                docs = getDocIds(engine, true);
            UNASSIGNED_SEQ_NO,
            final int numDocsPerThread = randomIntBetween(500, 1000);
        }
                            }
            Engine.Index index = new Engine.Index(
            }
            engine.index(indexForDoc(doc2));
        assertThat(engine.lastRefreshedCheckpoint(), equalTo(engine.getProcessedLocalCheckpoint()));
            final SeqNoStats prevSeqNoStats;
            return new DrainFailureOutcome(thrown, engineFailureReasons, engineFailures, closed);
        }
    }
        IndexWriterFactory indexWriterFactory = (directory, iwc) -> {
                null,
                    );
                    new NoneCircuitBreakerService(),
            .put(defaultSettings.getSettings())
                }
        MatcherAssert.assertThat(updateSearchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(0));
                UNASSIGNED_PRIMARY_TERM
                    doc,
            assertThat(segments.size(), equalTo(2));
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                }
        assertThat(indexResult.getFailure(), instanceOf(VersionConflictEngineException.class));
            }
            engine.flush();
                }
            boolean flushAndClose = randomBoolean();
    public void testStoreHonorsLuceneVersion() throws IOException {
            t1.join();
        assertThat(batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
                    assertNull(VersionsAndSeqNoResolver.loadDocIdAndSeqNo(searcher.getIndexReader(), newUid(notFoundId)));
        MatcherAssert.assertThat(
            }
    public void testUnreferencedFileCleanUpOnSegmentMergeFailureWithCleanUpEnabled() throws Exception {
            engine.index(indexForDoc(doc3));
                shardId,
        );
            .build();
    public void testConcurrentWritesAndCommits() throws Exception {
        // Exercise the 10-param Engine.Delete constructor (delegates to 11-param with null routing)
    @LockFeatureFlag(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG)
    }
            }
            VersionType.INTERNAL,
                    engine.refresh("warm_up");
            ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
        try (
                    assertThat(result.getSeqNo(), equalTo(seqNo));
            InternalEngine engine = createEngine(store, createTempDir(), (maxSeq, localCP) -> new LocalCheckpointTracker(maxSeq, localCP) {
        indexSettings.updateIndexMetadata(builder.build());
                VersionType.EXTERNAL,
                expectThrows(IllegalStateException.class, () -> engine.delete(new Engine.Delete("1", newUid("1"), primaryTerm.get())));
    public void testForceMergeWithSoftDeletesRetention() throws Exception {
            try (Store store = createStore(wrapper)) {
    public void testAlwaysRecordReplicaOrPeerRecoveryOperationsToTranslog() throws Exception {
                for (Engine.Operation op : operations) {
                testDocumentWithTextField(),
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
            VersionConflictEngineException.class,
                    Translog.Operation op = ops.get(seqno);
            if (create) {
        doc = testParsedDocument(Integer.toString(randomId), null, testDocument(), new BytesArray("{}"), null);
                        assertTrue(ex.toString(), ex.getCause() instanceof MockDirectoryWrapper.FakeIOException);
                && assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().currentFileGeneration() < 500) {
        }
            }
        for (Engine.Operation op : ops) {
                    VersionType.EXTERNAL,
                try {
        indexResult = engine.index(create);
    public void testStressShouldPeriodicallyFlush() throws Exception {
    }
            indexWriterHolder.set(new IndexWriter(directory, iwc));
                        holder.close();
        Engine.IndexResult indexResult = engine.index(create);
            }
                    assertEquals("Expected number of operations", operations.size(), count);
                    liveDocs.remove(doc.id());
        for (int i = 0; i < cap; i++) {
     * nothing triggers before a publication, nothing triggers when the published bytes are below the published
            assertThat(noOp.reason(), equalTo(reason));
            store.associateIndexWithNewTranslog(translogUUID);
            engine.index(indexForDoc(doc));
                id,
            engine.index(index);
            } finally {
        List<Engine.Index> docs = new ArrayList<>();
            ? appendOnlyPrimary(doc, false, 1)
                engine.index(
        }
        return opsPerformed;
        }
            wrappedSnapshot.close(); // shouldn't throw AlreadyClosedException
     * checkpoint it persists already covers the batched operations. After the flush the deferred op has a location,
                null,
            isRetry,
                            // Verify document is actually deleted
            InternalEngine engine = createEngine(
            addedToLucene.await();
            // open and recover tlog
                engine.clearDeletedTombstones();
                TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), docs);
    public void testEngineCreationWithCustomTranslogDeletePolicy() throws IOException {
            assertThat(initialEngine.getSeqNoStats(-1).getMaxSeqNo(), equalTo((long) (docs - 1)));
            1,
                        FieldsVisitor visitor = new FieldsVisitor(true);
                    globalCheckpoint::get,
                    assertNotNull(indexResult.getTranslogLocation());
                if (rarely()) {
        mockAppender.start();
        EngineConfig engineConfig = new EngineConfig.Builder().shardId(config.getShardId())
            int commitLimit = randomIntBetween(10, 20);
        String operation = randomFrom("optimize", "refresh", "flush");
        final GatedCloseable<IndexCommit> wrappedSnapshot;
            try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
        assertThat(batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
            null,
        engine.translogManager().ensureCanFlush(); // ready
                wrappedSnapshot.close();
            final boolean flush = randomBoolean();
     */
            return indexWriterHolder.get();
            return appendOnlyReplica(doc, retry, autoGeneratedIdTimestamp, 0);
                    operations.add(index);
                } else if (failure instanceof IOException) {
     */
import org.opensearch.OpenSearchException;
            SequenceNumbers.NO_OPS_PERFORMED,
        public void clearFailure() {
            assertEquals(2, searcher.getIndexReader().numDocs());
        assertThat(message, engine.getNumDocDeletes(), equalTo(expectedDeletes));
        Sort indexSort = new Sort(new SortedSetSortField("foo1", false));
                engine.failEngine("test", new IOException("simulated error"));
            () -> engine.get(
                liveDocIds.remove(doc.id());
        Engine.IndexResult second = batchEngine.index(indexForDoc(secondDoc));
            }
        index = new Engine.Index(
    }
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), upToSeqNo);
        InternalEngine batchEngine = spy(engine);
                    final Engine.DeleteResult result;
                VersionType.INTERNAL,
        try (InternalEngine engine = new InternalEngine(config)) {
    private static FixedBitSet getSeqNosSet(final IndexReader reader, final long highestSeqNo) throws IOException {
                assertEquals("the delete and the tombstone", 2, leafReader.numDeletedDocs());
                        engine.refresh("test");
                        userData = engine.getLastCommittedSegmentInfos().getUserData();
    public void testVersionConflictIgnoreDeletedDoc() throws IOException {
            final Engine.NoOp op = new Engine.NoOp(0, 0, PRIMARY, System.currentTimeMillis(), "test");
        assertThat(engine.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(-1L));
                for (Engine.Operation op : operations) {
import org.opensearch.core.index.shard.ShardId;
            assertThat(segments.size(), equalTo(1));
            engine.flush();
        engine.forceMerge(false, 1, false, false, false, UUIDs.randomBase64UUID());
                Versions.MATCH_ANY,
                String msg = "seq# [" + seqno + "], global checkpoint [" + globalCheckpoint + "], retained-ops [" + retainedExtraOps + "]";
            UNASSIGNED_SEQ_NO,
                    applyOperation(engine, op);
            final AtomicLong retentionLeasesVersion = new AtomicLong();
            try {
                final String docId = Integer.toString(i);
                        Engine.Index index = new Engine.Index(
            Settings.builder()
                if (callStackContainsAnyOf("mergeTerms")) {
                        assertSame(warmedUpReaders.get(0), externalSearcher.getDirectoryReader());
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            assertThat(segments.get(0).getNumDocs(), equalTo(numIndexingThreads * numDocsPerThread));
            assertThat(generateNewSeqNo(recoveringEngine), equalTo(primarySeqNo + 1));
            );
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            "1"
                    continue;
                    "delete operations on primary must advance max_seq_no_of_updates",
                    final String id = randomAlphaOfLength(8);
            assertLuceneOperations(engine, numDocs, 0, 0);
                        newUid(doc),
                    : randomIntBetween(0, (int) localCheckpoint.get())
                assertTrue("refCount: " + store.refCount(), store.refCount() > 0);
        }
                    highestOpVersion = op.version();
                // Fail segment merge with diskfull during merging terms
                liveDocsFirstSegment.add(id);
            expectThrowsAnyOf(
                store,
            engine.refresh("test");
        try {
        final String badUUID = Translog.createEmptyTranslog(badTranslogLog, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
import org.apache.lucene.util.BytesRef;
            assertEquals(timestamp1, engine.segmentsStats(false, false).getMaxUnsafeAutoIdTimestamp());
        }
                        userData.get(Translog.TRANSLOG_UUID_KEY)
                    assertThat(engine.getLocalCheckpointTracker().getMaxSeqNo(), equalTo(maxSeqNo));
                            ) {
                }
            assertEquals(1, searcher.getIndexReader().numDocs());
            }
        for (int i = 0; i < thread.length; i++) {
            UNASSIGNED_SEQ_NO,
            for (int i = 0; i < iterations && liveDocsFirstSegment.isEmpty() == false; i++) {
            final Engine.EventListener eventListener = new Engine.EventListener() {
        // and, verify get (in real time)
                        assertTrue(ex.toString(), ex.getCause() instanceof MockDirectoryWrapper.FakeIOException);
                    engine.index(indexForDoc(doc));
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test1")), 0)
                        doc,
        final int numDocsPerThread = randomIntBetween(500, 1000);
                liveDocsFirstSegment.remove(idToUpdate);
                .queryCache(config.getQueryCache())
                assertThat(getDocIds(engine, true), equalTo(docs));
                minSeqNoToRetain = Math.min(globalCheckpoint.get() + 1 - retainedExtraOps, safeCommitLocalCheckpoint + 1);
            // if the replica operation wasn't a retry, the operation arriving on the newly promoted primary must be a retry
                    start.countDown();
        if (randomBoolean()) {
        assertTrue(outcome.engineClosedAfterwards);
            final String translogUuid = Translog.createEmptyTranslog(
                            testDocumentWithTextField("updated"),
            public void onFailedEngine(String reason, Exception e) {
            UNASSIGNED_SEQ_NO,
                for (int i = 0; i < length; i++) {
            null,
                    assertThat(result.getFailure().getStackTrace(), emptyArray());
        // but not real time is not yet visible
                    if (!deletedDocs.contains(idToDelete)) {
import static org.hamcrest.Matchers.is;
                IndexCommit safeCommit = wrappedSafeCommit.get();
                    initialEngine.flush();
            engine.index(indexForDoc(doc1));
            });
        MockDirectoryWrapper wrapper = newMockDirectory();
        engine.index(indexForDoc(createParsedDoc("1", null)));
            try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
            0
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), randomLongBetween(0, 10));
        assertThat(
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
                final TotalHitCountCollector collector = new TotalHitCountCollector();
                            if (IndexFileNames.getExtension(file) == null) {
                        engine.delete(delete);
                ),
        if (rightLeaves.size() == leftLeaves.size()) {
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                        primaryTerm.get(),
                }
            if (randomBoolean()) {
            engine.flush(false, randomBoolean());
                assertNotSameReader(getSearcher, searchSearcher);
        searchResult.close();
            InternalEngine engine = createEngine(
            randomBoolean() ? Versions.MATCH_DELETED : Versions.MATCH_ANY,
                engine.flush(true, true);
                    Engine.DeleteResult result;
            current = current.getCause();
            engine.refresh("test");
        );
                .build();
import java.util.List;
                .endObject()
                if (rarely()) {
        engine.index(indexForDoc(doc));
                }
            int count = searcher.count(new MatchAllDocsQuery());
        final long finalReplicaSeqNo = lastReplicaOp.seqNo();
                barrier.await();
            indexResult.getVersion(),
                    lastMinRetainedSeqNo = Long.parseLong(safeCommit.getUserData().get(Engine.MIN_RETAINED_SEQNO));
            ) {
            searchResult.close();
                    Translog.Operation operation;
            0,
    /**
import org.opensearch.core.xcontent.XContentBuilder;
                    equalTo(0)
                    assertEquals(
        }
                    ParsedDocument doc = testParsedDocument(idToUpdate, null, document, null, null);
        assertThat(first.getTranslogLocation(), nullValue());
                createTempDir(),
        final Set<String> liveDocsWithSource = new HashSet<>();
            + expectedAppends
        store = createStore();
                    throw new IOException("No space left on device");
                final Thread thread = new Thread(() -> {
                        commits.add(new ArrayList<>(flushedOperations));
            null,
        }
                    }
            2,
        final boolean exists = operations.get(operations.size() - 1) instanceof Engine.Index;
            Thread t1 = new Thread(r);
                    engine.translogManager().syncTranslog();
    public void testReplicatedVersioningWithFlush() throws IOException {
            final IndexMetadata indexMetadata = IndexMetadata.builder(indexSettings.getIndexMetadata())
        }
                final int numStarts = scaledRandomIntBetween(1, 5);
                null,
    public static long getNumIndexVersionsLookups(InternalEngine engine) { // for other tests to access this
    }
            CountDownLatch latch = new CountDownLatch(1);
        engine.close();
                assertThat(versionMap.keySet(), equalTo(deletesAfterCheckpoint.keySet()));
            globalCheckpoint = gcpTracker.getGlobalCheckpoint();
                public void onFailedEngine(String reason, Exception e) {
                    expectThrows(
            assertThat(stats.getFileSizes().size(), greaterThan(0));
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(1));
            searchResult,
                        SegmentReader segmentReader = Lucene.segmentReader(ctx.reader());
                .retentionLeasesSupplier(base.retentionLeasesSupplier())
            Document document = testDocument();
                assertEquals(11, getSearcher.getIndexReader().numDocs());
                    }
                    engine.refresh("test");
            gcpTracker.updateFromClusterManager(
import org.apache.lucene.store.Directory;
            final Engine.Index index = new Engine.Index(
            -1,
                    UNASSIGNED_SEQ_NO,
        ParsedDocument doc = testParsedDocument("batch-close", null, testDocument(), B_1, null);
            Version.CURRENT,
                    liveDocs.add(doc.id());
     * means the engine must NOT be failed and the drainer's refresh must not fail because of another request's append:
            failureToThrow.set(failureSupplier);
    }
                        primaryTerm.get(),
                globalCheckpoint.set(numDocs - 1);
                null,
                .startObject()
        Engine.Operation lastReplicaOp = replicaOps.get(replicaOps.size() - 1);
                    index.primaryTerm(),
                        Map<String, String> userData = engine.getLastCommittedSegmentInfos().getUserData();
                )
        int numDocs = randomIntBetween(10, 100);
                1,
        try (Translog.Snapshot snapshot = getTranslog(engine).newSnapshot()) {
                        equalTo(liveOps)
            assertThat(recoveringEngine.getProcessedLocalCheckpoint(), equalTo(primarySeqNo));
            if (randomBoolean()) {
                    assertThat(result.getFailure().getStackTrace(), emptyArray());
                String id = Integer.toString(i);
            engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
                    }
                    primaryTerm.get()
            ) {
                    null,
import static org.hamcrest.Matchers.hasSize;
                    engine.index(indexForDoc(doc));
        }
        // its not there...
        };
        InternalEngine batchEngine = spy(engine);
import static org.hamcrest.Matchers.notNullValue;
            while (running.get()
        }
                            .count();
            randomFrom(VersionType.INTERNAL, VersionType.EXTERNAL),
        }
                        assertEquals(primaryTerm.get(), operation.primaryTerm());
        final FixedBitSet bitSet = new FixedBitSet((int) highestSeqNo + 1);
                .endObject()
        assertThat(indexResult.getVersion(), equalTo(1L));
                throw new IllegalArgumentException("fatal");
     * result has a location and the processed checkpoint covers all of them before {@code finish()} is ever called.
                throw new AssertionError(e);
        barrier.await();
                                int numDocs = randomIntBetween(1, 20);
                    sequenceNumberSupplier.getAsLong(),
                null,
            Map<String, String> nrtUserData = nrtSnapshot.get().getUserData();
            1,
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
            indexSettings,
                        // all is fine
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
            }
            -1,
                    final long retainingSequenceNumber = randomLongBetween(0, Math.max(0, globalCheckpoint.get()));
                }
                        public CacheHelper getReaderCacheHelper() {
            engine.refresh("test");
                    assertSame(searcher.getIndexReader(), nextSearcher.getIndexReader());
            try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
    public void testVersioningPromotedReplica() throws IOException {
            doc,
            assertThat(stats1.getUserData(), hasKey(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
            InternalEngine engine = null;
                    assertEquals("Total number of operations", operations.size(), snapshot.totalOperations());
                    assertThat(result.getVersion(), equalTo(Math.max(lastOpVersion + 1, 1)));
        for (int i = 0; i < numberOfOperations; i++) {
                        finalInitialEngine.index(indexForDoc(doc));
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
    /**
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
                    if (op != null) {
        engine.flush();
                            UNASSIGNED_SEQ_NO,
        final Map<String, String> committedUserData;
            indexSettings.getSoftDeleteRetentionOperations()
            long localCheckpoint = Long.parseLong(engine.getLastCommittedSegmentInfos().userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
                engine.refresh("test");
        try {
                IndexWriter writer = new IndexWriter(
            final Engine.Delete op = new Engine.Delete("0", newUid("0"), primaryTerm.get());
            ) {
        searchResult.close();
            for (final String fileName : store.readLastCommittedSegmentsInfo().files(true)) {
                translogHandler = createTranslogHandler(engine.engineConfig.getIndexSettings(), engine);
        };
        final List<String> engineFailureReasons;
            @Override
        IOUtils.rm(translog.location().resolve(Translog.getFilename(id)));
        doc = testParsedDocument(
                }
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), retainedExtraOps);
            document.add(uidField);
            assertEquals("unexpected refresh", 0, searcher.getIndexReader().maxDoc());
                for (int i = 0; i < numDocs; i++) {
import static org.opensearch.index.engine.Engine.Operation.Origin.LOCAL_RESET;
        operation = appendOnlyPrimary(doc.get(), false, 1, create);
            SequenceNumbers.NO_OPS_PERFORMED
        assertThat(indexed.getTranslogLocation(), nullValue());
            Loggers.removeAppender(iwIFDLogger, mockAppender);
            isRetry,
        Engine recoveringEngine = null;
        latestGetResult.get().close();
                    lastFieldValue = index.docs().get(0).get("value");
            delete.routing()
        engine.refresh("test");
        }
        }
                .array("fields", "value")
                        highestSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
    }
        engine.index(operation);
                final GatedCloseable<IndexCommit> commit = engine.acquireLastIndexCommit(false)
            } else {
                        }
        assertOpsOnPrimary(ops, Versions.NOT_FOUND, true, engine);
            .flushMergesAfter(config.getFlushMergesAfter())
        @Override
            if (refresher.isAlive()) {
            engine.delete(new Engine.Delete("0", newUid("0"), primaryTerm.get()));
                        UNASSIGNED_SEQ_NO,
                            engine.index(indexForDoc(doc));
            .circuitBreakerService(config.getCircuitBreakerService())
            doc,
        assertThat(versionConflictEngineException.getStackTrace(), emptyArray());
     */
            testDocumentWithTextField("test"),
        assertThat(assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().currentFileGeneration(), equalTo(3L));
            indexSettings.updateIndexMetadata(IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build());
            defaultSettings.getNodeSettings(),
        return new ForceMergePolicy(new TieredMergePolicy());
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
        // create a document
                    throw (RuntimeException) failure;
        Engine.IndexResult indexResult = engine.index(create);
            .settings(
                engine.index(indexForDoc(doc));
                        count++;
            Store store = createStore();
                    )
                }
            index.startTime(),
                if (randomBoolean()) {
import org.opensearch.index.mapper.SourceFieldMapper;
                        TranslogHandler translogHandler = createTranslogHandler(config.getIndexSettings(), engine);
                    );
        ) {
            engine.index(replicaIndexForDoc(doc, 1, 1, false));
                }
import java.util.Deque;
                    engine.refresh("test");
            assertTrue(engine.isClosed.get());
            delete.startTime(),
            if (operation instanceof Engine.Index) {
            Set<String> liveDocsFirstSegment = new HashSet<>();
            1,
        assertEquals(generation.translogFileGeneration, translog.currentFileGeneration());
            assertThat(indexResult.getFailure(), instanceOf(VersionConflictEngineException.class));
                    createTempDir(),
        assertThat(deleteResult.getFailure(), nullValue());
                    ParsedDocument doc = testParsedDocument(idToUpdate, null, document, null, null);
        try (Engine.GetResult getResult = engine.get(newGet(false, doc), searcherFactory)) {
            assertThat(segments, hasSize(1));
        document.add(new Field(SourceFieldMapper.NAME, BytesReference.toBytes(B_1), SourceFieldMapper.Defaults.FIELD_TYPE));
        engine.refresh("test");
        } finally {
            final CountDownLatch doneLatch = new CountDownLatch(numIndexingThreads);
                    .put(indexSettings.getSettings())
        assertNull(fromShardDeprecated.routing());
            assertEquals(sameSeqNo ? 1 : 2, engine.getNumVersionLookups());
                try (Engine.Searcher nextSearcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)) {
    }
            final ParsedDocument doc = testParsedDocument(
        }
            if (randomBoolean()) {
        );
                        false,
                thread.join();
            // Cleanup count will be incremented whenever cleanup is performed correctly.
            searchResult,
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                Engine.Searcher getSearcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
                }
        engine.index(indexForDoc(doc));
                            assertThat(msg, docIdAndSeqNo.seqNo, equalTo(latestOps.get(id).seqNo()));
        assertThat(assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().currentFileGeneration(), equalTo(3L));
            ? appendOnlyPrimary(doc, false, 1)
            );
        engine.close();
        engine.ensureOpen();
                    0
        }
                public ParsedDocument newDeleteTombstoneDoc(String id) {
    public void testRandomOperations() throws Exception {
            Store store = createStore();
                gcpTracker.updateLocalCheckpoint(primary.allocationId().getId(), initialEngine.getPersistedLocalCheckpoint());
            );
            InternalEngine engine = createEngine(
import org.apache.logging.log4j.core.appender.AbstractAppender;
                        rarely() ? 100 : Versions.MATCH_ANY,
                new IndexShardRoutingTable.Builder(shardId).addShard(primary).addShard(initializingReplica).build()
                indexSort,
                "performing [{}]{}{}",
                globalCheckpoint.set(
            newUid(doc),
        IOUtils.close(engine, store);
                    // generate a conflict
                } catch (Throwable t) {
                }
            new BytesArray("{}".getBytes(Charset.defaultCharset())),
    }
            assertNotNull(last);
                    if (values != null) {
                    threads.add(thread);
                    index.versionType(),
                }
                        String msg = "latestOps=" + latestOps + " op=" + id;
        if (randomBoolean()) {
        setIndexWriterMaxDocs(maxDocs);
                Arrays.asList(IOException.class, IllegalStateException.class),
                for (int i = 0; i < numDocs; i++) {
            List<Exception> engineFailures,
        engine.updateUncommittedSegmentBytes(localSegmentsSizeMap, Long.MAX_VALUE);
        }
            + " appends [actual:"
                    ParsedDocument parsedDocument = tombstoneDocSupplier().newDeleteTombstoneDoc(id);
            newUid(doc),
                    try {
        seqID = getSequenceID(engine, newGet(false, doc));
            final AtomicReference<RetentionLeases> retentionLeasesHolder = new AtomicReference<>(
            doc,
            }
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(2L));
            recoveringEngine.translogManager()
                    "1",
                assertThat("expected at least one segment file after flush", expectedTotal, greaterThan(0L));
        final AtomicLong blockedSeqNo = new AtomicLong(UNASSIGNED_SEQ_NO);
                    .setIfPrimaryTerm(primaryTerm.get() + 1),
                defaultSettings,
                index(finalActualEngine, 3 * i);
        AtomicBoolean run = new AtomicBoolean(true);
                    }
                                        "Document " + docId + " should have updated value",
            }
                        assertThat(initialEngine.getSeqNoStats(-1).getMaxSeqNo(), equalTo(primarySeqNo + 1));
            // Just allow force merge so that regular merge does not close the shard first before any any other operation
            assertTrue(retryResult.getTranslogLocation().compareTo(indexResult.getTranslogLocation()) > 0);
        engine.delete(new Engine.Delete(operation.id(), operation.uid(), primaryTerm.get()));
            indexResult.getSeqNo(),
        }
            }
                        engine.translogManager().syncTranslog();
        final String lastFieldValueDoc2;
     * referenced latch before returning. If the local checkpoint should advance (because {@code stall} is false, then the value of
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(LongPoint.newExactQuery("_seq_no", 2), 1)
        return new Store(shardId, INDEX_SETTINGS, directory, new DummyShardLock(shardId)) {
        } finally {
                rootCause(suppressed),
                    operations.add(update);
    /**
            indexer.join();
                } else {
        }
        );
            assertEquals(1, topDocs.totalHits.value());
                        }
                for (LeafReaderContext context : reader.leaves()) {
            // Prune tombstones whose seqno at most the local checkpoint (eg. seqno < gap_seqno).
    }
                        UNASSIGNED_SEQ_NO,
                try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, operations.size() - 1, true, true)) {
                }
            engine.close();
                )
                localSegmentsSizeMap.put(file, length);
        int numDocsToDelete = randomIntBetween(1, numDocs / 2);
        assertEquals(expectedLocalCheckpoint, actualLocalCheckpoint);
                        long fileCount = Arrays.stream(store.directory().listAll())
                }
            totalExpectedOps++;
            try (InternalEngine engine = createEngine(config)) {
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
                null,
                }
        ParsedDocument doc = testParsedDocument("1", null, testDocument(), B_1, null);
        );
            }
                    String.valueOf(i),
    public void testVersionOnPrimaryWithConcurrentRefresh() throws Exception {
                    globalCheckpoint::get,
            wrapper.setRandomIOExceptionRate(randomDouble());
        ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), SOURCE, null);
        // add it back
    /**
        searchResult.close();
                final int skipId = 3 * i + 1;
            300,
        ParsedDocument doc = testParsedDocument("1", null, testDocument(), new BytesArray("{}".getBytes(Charset.defaultCharset())), null);
            () -> engine.get(
            Engine.IndexResult retryResult = engine.index(retry);
        }
                 */
            if (randomBoolean()) {
                    .execute(
                    committed.set(true);
                            .count();
                    engine.index(firstIndexRequest);
        assertThat(engine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(1));
            // First, with DEBUG, which should NOT log IndexWriter output:
                engine.close();
                        VersionType.EXTERNAL,
                logger.info("try with {}", operation);
            index.uid(),
        store = createStore();
            }
        long flushThreshold = RandomNumbers.randomLongBetween(
                    break;
                createTempDir(),
            final Translog translog = assertAndGetInternalTranslogManager(finalActualEngine.translogManager()).getTranslog();
                            i + numDocs,
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
        store.createEmpty(Version.CURRENT.luceneVersion);
                    assertThat(result.getFailure(), instanceOf(VersionConflictEngineException.class));
        );
                Engine.Searcher searchSearcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)
            engine.flush();
        searchResult.close();
    @LockFeatureFlag(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG)
            Engine.Index index = randomBoolean() ? indexForDoc(doc) : randomAppendOnly(doc, false, docId);
            if (create) {
            expectThrows(AlreadyClosedException.class, () -> engine.delete(replicaDeleteForDoc("test", 42, 7, System.nanoTime())));
                }
            );
import org.junit.Assert;
                    assertEquals(1, reader.leaves().size());
    public void testShouldPeriodicallyFlushAfterMerge() throws Exception {
            indexResult.getSeqNo(),
        try (
                // First index documents
                                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), B_1, null);
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, 1));
            for (int i = totalNumberOfDocsRefreshed; i < (totalNumberOfDocsRefreshed + numDocs); i++) {
                    System.nanoTime(),
                .circuitBreakerService(config.getCircuitBreakerService())
import org.opensearch.common.xcontent.XContentFactory;
            for (int docId = 0; docId < numDocs; docId++) {
            final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            }
            try {
            @Override
            ) {
                try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", from, to, false, true)) {
            0,
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.opensearch.common.lucene.Lucene;
                    .put(IndexSettings.INDEX_FLUSH_AFTER_MERGE_THRESHOLD_SIZE_SETTING.getKey(), "0b")
            final ParsedDocument doc2 = testParsedDocument("2", null, testDocumentWithTextField(), B_1, null);
            engine.index(index);
            int numDocs = between(1, 20);
                    if (op != null) {
    }
                directory.setFailOnOpenInput(false);
                    .put(indexSettings.getSettings())
            newUid(doc),
                    getter.join();
            () -> createEngine(store, primaryTranslogDir)
        assertThat("Published bytes breach the threshold", engine.shouldPeriodicallyFlush(), equalTo(true));
            final Engine.EventListener eventListener = new Engine.EventListener() {
        Engine.TranslogBatch batch = batchEngine.beginTranslogBatch();
                try (InternalEngine engine = new InternalEngine(config)) {
            Assert.assertFalse(cfsCompoundFileFound);
        Path translogPath = createTempDir();
        // now lets make this document visible
                engine.flush();
                        null
        engine.refresh("test", Engine.SearcherScope.INTERNAL, true);
            null
     * @param barrier                 to signal the thread has generated a new sequence number
            mockAppender.stop();
                id,
            }
            gcpTracker.activatePrimaryMode(primarySeqNo);
            } else {
            maybeThrowFailure();
                );
            assertThat(Long.parseLong(stats2.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)), equalTo(localCheckpoint.get()));
    public void testHistoryBasedOnSource() throws Exception {
                    } else {
                    origin,
                    UNASSIGNED_SEQ_NO,
                if (rarely()) {
        engine.index(indexForDoc(doc));
                engine.index(indexForDoc(doc));
        assertThat(seqID.v2(), equalTo(0L));
        final List<Engine.Operation> operations = generateSingleDocHistory(
                }
            try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
            }
                            0L
            PRIMARY,
                    }
            .warmer(config.getWarmer())
            if (randomBoolean()) {
        try {
        try (Store store = createStore()) {
        );
    public void testConcurrentOutOfOrderDocsOnReplica() throws IOException, InterruptedException {
                    globalCheckpoint.set(recoveringEngine.getSeqNoStats(-1).getMaxSeqNo());
        // Non-existent doc returns no seqnum and no primary term
            0
                engine.index(indexForDoc(doc));
                .reduce((s1, s2) -> s2) // get the last one.
                failure.set(t);
                )
                if (engine.getSeqNoStats(globalCheckpoint.get()).getMaxSeqNo() == globalCheckpoint.get()) {
                    initialEngine.delete(operation);
                            // all good.
            1,
                SequenceNumbers.NO_OPS_PERFORMED,
        ParsedDocument doc = testParsedDocument("del", null, testDocument(), B_1, null);
                operations.add(index);
                    docDeleted = true;
                        new Engine.NoOp(
                null
                            }
                .warmer(warmer)
        }
                .startObject("_doc")
                doc.add(new Field(IdFieldMapper.NAME, "1", IdFieldMapper.Defaults.FIELD_TYPE));
                    int count = 0;
                    try (
                                @Override
                engineConfig = engine.config();
            thread[i] = new Thread() {
            final InternalEngine finalActualEngine = actualEngine;
                Engine.DeleteResult result = engine.delete(new Engine.Delete(doc.id(), newUid(doc.id()), primaryTerm.get()));
            mapping = XContentFactory.jsonBuilder()
            UNASSIGNED_SEQ_NO,
            );
        update = new Engine.Index(
        MatcherAssert.assertThat(
    public void testGetSegmentInfosSnapshot_AllSnapshotFilesPreservedAcrossCommit() throws Exception {
        List<GatedCloseable<IndexCommit>> commits = new ArrayList<>();
            assertThat(
        );
                    try {
                    protected void commitIndexWriter(DocumentIndexWriter writer, String translogUUID) throws IOException {
                        System.nanoTime(),
            UNASSIGNED_SEQ_NO,
            .internalRefreshListener(config.getInternalRefreshListener())
                -1,
        }
        indexSettings.updateIndexMetadata(indexMetadata);
                    String idToDelete = Integer.toString(randomInt(numDocs - 1));
            300,
            // First, with DEBUG, which should NOT log IndexWriter output:
            }
            0
            );
                assertEquals(0, searchSearcher.getIndexReader().numDocs());
                    Engine.Operation.Origin.PRIMARY,
        assertTrue(indexResult.isCreated());
            assertThat(doneLatch.await(10, TimeUnit.SECONDS), is(true));
     * batch never receives a translog location, and the batch rethrows the close failure on any later flush/finish
        engine.close();
    public void testCloseAbortsPendingBatch() throws Exception {
    public Engine.Index appendOnlyPrimary(ParsedDocument doc, boolean retry, final long autoGeneratedIdTimestamp) {
                Terms id = leafReader.terms("_id");
                        );
                assertEquals(2, reader.leaves().size());
        final AtomicLong retentionLeasesVersion = new AtomicLong();
                            case "refresh": {
        assertTrue("cross-thread realtime GET must observe the batched document", exists.get());
            );
        }
import org.opensearch.action.support.TransportActions;
        ) {
                    assertEquals(store.refCount(), refCount);
            indexWriterHolder.set(new IndexWriter(directory, iwc));
                                    new Engine.Get(true, false, docId, newUid(docId)),
            "my-routing",
        engine.close();
            "1",
    private void assertOperationHistoryInLucene(List<Engine.Operation> operations) throws IOException {
                    0,
            ) {
            assertFalse(mockAppender.sawIndexWriterMessage);
     */
        );
                        System.nanoTime(),
            assertThat(engine.failedEngine.get(), instanceOf(IllegalArgumentException.class));
                }
                        throw new AssertionError(e);
                        engine.getMaxSeqNoOfUpdatesOrDeletes(),
                assertNull(retryResult.getTranslogLocation());
                    previousGetResult.close();
            ) {
                // Test snapshot with accurate count
                if (stall.get()) {
                operations.add(delete);
                Integer.toString(docId),
                    ParsedDocument doc = testParsedDocument(
        }
        concurrentlyApplyOps(ops, engine);
                    assertNotNull(result.getFailure());
            engine.index(appendOnlyPrimary(doc, true, timestamp1));
                        randomNonNegativeLong(),
            assertEquals(IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP, engine.segmentsStats(false, false).getMaxUnsafeAutoIdTimestamp());
        engine.flush();
                NumericDocValues primaryTerms = docIdAndSeqNo.context.reader().getNumericDocValues(SeqNoFieldMapper.PRIMARY_TERM_NAME);
                    assertThat(msg, ops.get(seqno), notNullValue());
                            PRIMARY,
                    while (snapshot.next() != null) {
            }
        final LongSupplier inSyncGlobalCheckpointSupplier = () -> this.engine.getProcessedLocalCheckpoint();
            "1",
import org.opensearch.index.translog.Translog;
                    maxSeqIDOnReplica = indexResult.getSeqNo();
                equalTo(seqNos)
            "expected an Exception that signals shard is not available",
                    }
import org.opensearch.common.CheckedBiConsumer;
    }
                                        "updated",
                    false,
        if (randomBoolean()) {
        assertThat("Discarding the accounting disarms the condition", engine.shouldPeriodicallyFlush(), equalTo(false));
                assertFalse(engine.isClosed.get());
            testDocumentWithTextField(),
        EngineBackedIndexer indexer = new EngineBackedIndexer(batchEngine);
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 0)
                protected void doRun() throws Exception {
                engine.refresh("test");
            assertAndGetInternalTranslogManager(engine.translogManager()).getDeletionPolicy() instanceof CustomTranslogDeletionPolicy
            lastFieldValue = null;
                    ? Long.parseLong(userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY))
        final long expectedLocalCheckpoint = 1L;
                        @Override
                        newUid(document1),
        engine.index(indexForDoc(doc));
            REPLICA,
                .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), -1)
            // IndexWriter can throw either IOException or IllegalStateException depending on whether tragedy is set or not.
            indexSettings.getTranslogRetentionSize(),
        // its not updated yet...
        refresher.start();
                    engine.index(index);
                            "Document " + indexOp.id() + " should have updated value",
        final long timestamp1 = Math.abs(randomNonNegativeLong());
                assertSame(tragicException, engine.failedEngine.get());
     */
                config(
        final List<Engine.Operation> operations = new ArrayList<>();
            }
            }
                }
                        throw new AssertionError(e);
                Versions.MATCH_ANY,
                    operations.add(index);
                String id = Integer.toString(randomIntBetween(1, 100));
            Engine.IndexResult indexResult = engine.index(operation);
                            // fine
                    assertThat(index.getFailure(), nullValue());
        globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
            EngineConfig config = engine.config();
        } finally {
    public void assertSameReader(Engine.Searcher left, Engine.Searcher right) {
    }
            if (i > 0) {
        );
        long primarySeqNo = SequenceNumbers.NO_OPS_PERFORMED;
                    } else {
            assertEquals(1, topDocs.totalHits.value());
                        assertEquals(store.refCount(), refCount + 1);
                assertSameReader(getSearcher, searchSearcher);
        Engine.IndexResult result = batchEngine.index(op);
                );
                    }
    public void testMinGenerationForSeqNo() throws IOException, BrokenBarrierException, InterruptedException {
        final int maxSeqNo = randomIntBetween(0, 128);
    }
                "1",
        // Do not use MockRandomMergePolicy as it can cause a force merge performing two merges.
        engine.deactivateThrottling();
            }
            try (InternalEngine engine = createEngine(config)) {
            @Override
            final AtomicLong expectedLocalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                engine.index(indexForDoc(createParsedDoc(Integer.toString(i), null)));
        );
        MockDirectoryWrapper wrapper = newMockDirectory();
        } finally {
                        Engine.Operation.Origin.PRIMARY,
            );
            }
        wrapper.failOn(fail);
            assertThat(indexResult.getResultType(), equalTo(Engine.Result.Type.FAILURE));
                    if (!deletedDocs.contains(idToDelete)) {
        InternalEngine engine = createEngine(indexSettings, store, createTempDir(), newMergePolicy());
import org.opensearch.index.seqno.ReplicationTracker;
                        } else if (operation instanceof Translog.Delete) {
        AlreadyClosedException closed = expectThrows(AlreadyClosedException.class, batchEngine::beginTranslogBatch);
        }
            engine.translogManager().skipTranslogRecovery();
            try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)) {
        } finally {
                            engine.getLocalCheckpointTracker().generateSeqNo(),
            );
    public void testRecoverFromLocalTranslog() throws Exception {
        }
import org.apache.lucene.search.SortedSetSortField;
            engine.refresh("test");
                localCheckpointTrackerSupplier,
                    return;
            equalTo(docs.stream().mapToLong(Engine.Index::getAutoGeneratedIdTimestamp).max().getAsLong())
        final IOException tragic = new IOException("simulated tragic translog write failure");
                    delete.uid(),
                new RetentionLeases(primaryTerm, retentionLeasesVersion.get(), Collections.emptyList())
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            .primaryTermSupplier(primaryTerm::get)
        final IndexSettings indexSettings = engine.config().getIndexSettings();
            .primaryTermSupplier(config.getPrimaryTermSupplier())
                }
        Engine.Searcher updateSearchResult = engine.acquireSearcher("test");
                    count++;
                    holder = createEngine(store, translogPath);
            .indexSort(config.getIndexSort())
                assertTrue("Local directory contains file " + file, localFiles.contains(file));
            assertThat(segments.get(0).getDeletedDocs(), equalTo(updates + deletes));
            if (randomBoolean()) {
                    last = op;
        assertThat(result.getVersion(), equalTo(1L));
                    if (randomBoolean()) {
        assertThat(result.getTranslogLocation(), notNullValue());
            searchResult,
    }
            Engine.Index index = new Engine.Index(
                            .count();
                }
                committedUserData.get(Engine.HISTORY_UUID_KEY),
            final long seqNo = generateNewSeqNo(engine);
                            String docId = indexOp.id();
                    // try to acquire the writer lock - i.e., everything is closed, we need to synchronize
        final List<Exception> engineFailures;
                        assertThat(
        ) {
                .eventListener(config.getEventListener())
    }
                } else {
    }
import static java.util.Collections.shuffle;
                .tombstoneDocSupplier(base.getTombstoneDocSupplier())
        );
            create.primaryTerm(),
                config(indexSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get)
                assertTrue(iterator.seekExact(Uid.encodeId("0")));
        ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), new BytesArray("{}"), null);
                new Engine.Delete(
        } finally {
            maybeThrowFailure();
                    Document document = testDocumentWithGroupingCriteria();
        doReturn(true).when(batchEngine).isTranslogBatchingEligible();
     * This test tests that a no-op does not generate a new sequence number, that no-ops can advance the local checkpoint, and that no-ops
            assertThat(topDocs.totalHits.value(), equalTo(numDocs + 1L));
        assertEquals(0, engine.getNumVersionLookups());
            AtomicInteger controller = new AtomicInteger(0);
                            result = engine.index(indexWithVersion.apply(correctVersion, index));
                assertThat(DirectoryReader.listCommits(engine.store.directory()), hasSize(1));
        assertOperationHistoryInLucene(operations);
                }
        final Settings indexSettings = Settings.builder().put("index.sort.field", "foo").build();
            Loggers.setLevel(iwIFDLogger, (Level) null);
                    updatedDocs.add(idToUpdate);
            Store store = createStore();
        batchEngine.close();
                assertNotNull(lf.getSequentialStoredFieldsReader());
            try (InternalEngine engine = createEngine(store, createTempDir(), globalCheckpoint::get)) {
        );
        EngineConfig config = config(defaultSettings, store, primaryTranslogDir, newMergePolicy(), null);
            store,
                final int threadIdx = threadNum;
                        assertThat(result.getSeqNo(), equalTo(primarySeqNo + 1));
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(seqNo));
            try (
                assertThat(engine.getLastCommittedSegmentInfos(), not(sameInstance(lastCommitInfo)));
                }
                assertThat(engine.getLocalCheckpointTracker().getMaxSeqNo(), equalTo(maxSeqNo));
            assertThat(noOpEngine.getProcessedLocalCheckpoint(), equalTo((long) (maxSeqNo + 1)));
                        }
            defaultSettings.getScopedSettings()
    }
                        1,
                    indexSettings.getSoftDeleteRetentionOperations()
        updateResult = replicaEngine.index(update);
                } catch (IOException e) {
                        get.docIdAndVersion().reader.storedFields().document(get.docIdAndVersion().docId, visitor);
    public void testLuceneSnapshotRefreshesOnlyOnce() throws Exception {
                    maxSeqNo = primarySeqNo;
     * An update is a second index of the same id inside the batch. Both operations are deferred into the same chunk,
        concurrentlyApplyOps(ops, engine);
                    }
import org.apache.lucene.index.FilterLeafReader;
                .endObject()
                    retentionLeasesHolder::get,
    @LockFeatureFlag(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG)
                        new Engine.Index(
            REPLICA,
            // Prune tombstones whose seqno < gap_seqno and timestamp < clock-gcInterval.
            if (primary) {
        assertThat(max, equalTo(second.getTranslogLocation()));
            .mergePolicy(newMergePolicy())
            // All segments have to be merged into one
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
        final Path translogPath = createTempDir();
        MapperService mapperService = mock(MapperService.class);
        int numDocs = randomIntBetween(10, 100);
                failureClass,
        doReturn(true).when(batchEngine).isTranslogBatchingEligible();
                    System.nanoTime(),
            final long generation = assertAndGetInternalTranslogManager(finalActualEngine.translogManager()).getTranslog()
                engine.translogManager().syncTranslog(); // to advance local checkpoint
    }
    }
                    createTempDir(),
                    assertNull(result.getFailure());
                System.nanoTime(),
                .mergePolicy(config.getMergePolicy())
                 * this sequence number.
            );
            }
            engine.index(indexForDoc(doc2));
                                null,
                latch.countDown();
            .externalRefreshListener(config.getExternalRefreshListener())
                "del",
                assertTrue(engine.throttleLockIsHeldByCurrentThread());
        }
                        try {
            engine.getMaxSeenAutoIdTimestamp(),
            globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
                        engine.index(replicaIndexForDoc(doc, 1L, seqNo, false));
            .similarity(config.getSimilarity())
            document.add(seqID.seqNoDocValue);
import static org.hamcrest.Matchers.containsInAnyOrder;
        });
            Engine.Warmer warmer = reader -> {
                protected void commitIndexWriter(DocumentIndexWriter writer, String translogUUID) throws IOException {
            } else {
                    throw new AlreadyClosedException("store is already closed");
            engine.refresh("test");
            }
            version,
            assertEquals(3, get.version());
                        // Since only one document is committed and unreferenced files are cleaned up,
            boolean doneIndexing;
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(1));
 * compatible open source license.
        engine.index(indexForDoc(testParsedDocument("0", null, testDocumentWithTextField(), SOURCE, null)));
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
        try (Engine.Searcher searcher = replicaEngine.acquireSearcher("test")) {
                assertNotNull(retryResult.getTranslogLocation());
        return sb.toString();
                        // there are 4 files (*cfs, *cfe, *si and segments_*).
    private static final class DrainFailureOutcome {
                        UNASSIGNED_SEQ_NO,
                engine.refresh("test");
                        final Engine.Delete delete = new Engine.Delete(
                ShardRoutingState.INITIALIZING
        doc = testParsedDocument("1", null, document, B_1, null);
                            VersionType.EXTERNAL,
        translogHandler = createTranslogHandler(engine.engineConfig.getIndexSettings(), engine);
            indexResult = engine.index(index1);
    public void testSegmentsWithUseCompoundFileFlag_true() throws IOException {
                final IndexSettings indexSettings = engine.config().getIndexSettings();
            InternalEngine engine = createEngine(
                } catch (InterruptedException e) {
        }
        }
                    sleepTime = sleepTime * 2;
        );
        ) {
            assertThat(op1.opType(), equalTo(Translog.Operation.Type.INDEX));
                if (i < maxDocs) {
        Engine.IndexResult result = batchEngine.index(indexForDoc(doc));
import java.io.Closeable;
            iw.set(new ThrowingIndexWriter(dir, iwc));
                    sawIndexWriterIFDMessage = true;
            for (final String fileName : store.readLastCommittedSegmentsInfo().files(true)) {
            "test",
            thread[i] = new Thread(() -> {
                    defaultSettings,
                        IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                    TermsEnum iterator = id.iterator();
        if (lastOpDoc1 instanceof Engine.Index) {
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
                    // index random number of docs
        try (
        done.set(true);
            )
            public Directory directory() {
    }
                    .put(IndexSettings.INDEX_CONTEXT_AWARE_ENABLED_SETTING.getKey(), true)
                }
                    assertThat(warmedUpReaders, hasSize(1));
                }
        for (int id = 0; id < numDocs; id++) {
                    protected void doRun() throws Exception {
                        0
                            changes.close();
            assertThat("the op must be deferred into the open batch", deferred.getTranslogLocation(), nullValue());
        BiFunction<Long, Engine.Index, Engine.Index> indexWithVersion = (version, index) -> new Engine.Index(
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                .field("store", true)
                if (randomBoolean()) {
        } finally {
                    throw new UnsupportedOperationException();
        int numOps = between(1, 500);
            assertTrue(engine.refreshNeeded());
                    lookupAndCheck.run();
        return engine.getNumVersionLookups();
            for (int i = 0; i < moreDocs; i++) {
        try (
                () -> engine.noOp(new Engine.NoOp(2, primaryTerm.get(), LOCAL_TRANSLOG_RECOVERY, System.nanoTime(), "reason"))
            index.versionType(),
                    final Engine.Delete delete = new Engine.Delete(
        final int numDocs = between(1, 10);
    public void testBatchedUpdateOfSameDocumentKeepsOrderAndLatestVersion() throws Exception {
                    IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                assertEquals(1, reader.leaves().size());
        Engine.TranslogBatch batch = batchEngine.beginTranslogBatch();
                    if (useRecoverySource == false) {
    }
        assertThat(exception.getStackTrace(), emptyArray());
    public void testAcquireSearcherOnClosingEngine() throws Exception {
     * Test that we do not leak out information on a deleted doc due to it existing in version map. There are at least 2 cases:
                final long maxSeqNo = engine.getLocalCheckpointTracker().getMaxSeqNo();
                    store,
            for (int i = 0; i < docs; i++) {
                doneIndexing = doneLatch.await(sleepTime, TimeUnit.MILLISECONDS);
            Lucene.SOFT_DELETES_FIELD,
                            if (updatedDocs.contains(docId)) {
                    VersionType.EXTERNAL,
                doc,
                engine.translogManager().syncTranslog();
            }
                    }
        final IndexSettings indexSettings = engine.config().getIndexSettings();
                if (randomBoolean()) {
                        refreshCounter.incrementAndGet();
                    assertThat(result.getFailure().getStackTrace(), emptyArray());
            InternalEngine engine = createEngine(
            for (int i = totalNumberOfDocsRefreshed; i < (totalNumberOfDocsRefreshed + randomIntBetween(10, 100)); i++) {
            getResult = engine.get(newGet(true, doc), searcherFactory);
                        0
                engine.refresh("test");
                config(indexSettings, store, createTempDir(), newMergePolicy(random(), false), null, null, globalCheckpoint::get)
            assertEquals("test", luceneDoc.get("value"));
            Translog.Operation op;
            fail("readers are same");
                Set<Long> actualOps = readAllOperationsInLucene(engine).stream().map(Translog.Operation::seqNo).collect(Collectors.toSet());
                    int count = 0;
            if (create) {
                        Engine.Index index = indexForDoc(doc3);
                try (Engine.Searcher internalSearcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
            equalTo(inSync ? 3L : 2L)
import org.opensearch.index.fieldvisitor.FieldsVisitor;
        }
                    document.add(new TextField("value", "updated", Field.Store.YES));
            newMergePolicy(),
                                    )
        Engine.Index update = new Engine.Index(newUid(doc), primaryTerm.get(), doc, 1);
        final List<LeafReaderContext> leaves = reader.leaves();
                                        UUIDs.randomBase64UUID()
            org.apache.lucene.document.Document luceneDoc = searcher.storedFields().document(search.scoreDocs[0].doc);
        engine.refresh("test");
            engine.translogManager().syncTranslog();
        engine.flush();
                config(indexSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get)
        );
                        try (Engine.Searcher externalSearcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)) {
            engine.index(appendOnlyPrimary(doc, true, timestamp2, false));
        engine.close();
            UNASSIGNED_SEQ_NO,
            Settings.builder()
                    public void onFailure(Exception e) {
            final int numDocs = scaledRandomIntBetween(10, 100);
        batch.finish();
            IOUtils.close(initialEngine);
import org.opensearch.index.IndexSettings;
    }
        AtomicInteger numDeletes = new AtomicInteger();
            System.nanoTime(),
            updateResult.getVersion(),
                final IndexCommit commit = wrappedCommit.get();
            }
                    operations.add(update);
    }
    public void testVersionedUpdate() throws IOException {
                                        document.getField("value").stringValue()
            .translogConfig(config.getTranslogConfig())
        ParsedDocument doc = testParsedDocument("1", null, testDocument(), B_1, null);
            engine.refresh("test");
                }
     * observe the document, without hanging. The forcing thread (not the indexing thread) drives the append, which is
            .store(config.getStore())
                    assertThat(engine.lastRefreshedCheckpoint(), greaterThanOrEqualTo(checkPointBeforeRefresh));
            10,
                                    org.apache.lucene.document.Document document = storedFields.document(get.docIdAndVersion().docId);
                throwErrorOnCommit.set(true);
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(1));
import org.apache.lucene.index.NoMergePolicy;
                                    return in.getReaderCacheHelper();
                            history.add(new OpAndVersion(indexResult.getVersion(), removed, added));
        }
                }
        IOUtils.close(engine, store);
            }
            OpAndVersion(long version, String removed, String added) {
                Set<String> updatedDocs = new HashSet<>();
                public ParsedDocument newNoopTombstoneDoc(String reason) {
                .mergePolicy(NoMergePolicy.INSTANCE)
    public void testConcurrentMergeSegmentsOnCommit() throws Exception {
        }
                }
                assertThat(recoveringEngine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(0));
        Engine.IndexResult indexed = batchEngine.index(indexForDoc(doc));
            primaryTranslogDir,
            final boolean safeCommit = randomBoolean();
                                    engine.forceMerge(
            doc,
                LeafReader leafReader = leafReaderContext.reader();
        assertThat(engine.getMinRetainedSeqNo(), equalTo(0L));
            assertThat(Long.parseLong(stats2.getUserData().get(SequenceNumbers.MAX_SEQ_NO)), equalTo(maxSeqNo.get()));
        ParsedDocument doc = testParsedDocument("1", null, testDocument(), B_1, null);
            try {
                }
                        VersionType.INTERNAL,
        throws IOException {
        );
                    lastOpVersion = result.getVersion();
        assertLuceneOperations(engine, 1, 0, 0);
        Engine recoveringEngine = null;
import java.util.Iterator;
        Store store = createStore();
            .collect(Collectors.toMap(e -> e.getKey(), e -> (DeleteVersionValue) e.getValue()));
        searchResult = engine.acquireSearcher("test");
            }
                        -1,
                localSegmentsSizeMap.put(file, engine.store.directory().fileLength(file));
            }
        IOUtils.close(engine, store);
        final int numIndexingThreads = scaledRandomIntBetween(3, 8);
            )
                }
                // first op and it failed.
     * have produced, so the shard-bulk is retried on the re-promoted primary before any Lucene work is done.
                        );
        document = testDocumentWithTextField();
            List<Segment> segments = engine.segments(randomBoolean());
import org.apache.logging.log4j.core.filter.RegexFilter;
            Set<String> localFiles = Set.of(store.directory().listAll());
        try (Engine.GetResult result = engine.get(new Engine.Get(true, false, "2", uid), searcherFactory)) {
            engine.translogManager().syncTranslog();
                indexSettings.getTranslogRetentionAge(),
                        } catch (InterruptedException e) {
                            randomFrom(Engine.Operation.Origin.values()),
                    final String source = randomAlphaOfLength(8);
            } finally {
            Settings.builder()
        Engine.TranslogBatch batch = batchEngine.beginTranslogBatch();
            recoveringEngine.translogManager()
            for (String file : snapshot.get().files(false)) {
        // Create test documents
            assertThat(get.version(), equalTo(second.getVersion()));
                            };
                engine.refresh("test");
            final AtomicLong retentionLeasesVersion = new AtomicLong();
            }
                -1,
                "[{}] refresh threw: {}engine failures: {}",
            }
        InternalEngine batchEngine = spy(engine);
            committedFiles = new HashSet<>(snapshot.get().files(false));
            for (int c = 0; c < copies; c++) {
                        IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        // Deferred: no location yet and the processed checkpoint has not advanced.
            }
            "my-routing"
        // this test fails if any reader, searcher or directory is not closed - MDW FTW
            : appendOnlyReplica(doc, false, 1, randomIntBetween(0, 5));
                continue;
            engine.flush();
                    );
import org.apache.logging.log4j.Logger;
     * Random test that throws random exception and ensures all references are
        try {
                engine.refresh("test");
            updateResult.getSeqNo(),
     * Verifies the engine flush condition on uncommitted segment bytes published by the remote segment upload path:
        // Exercise the Delete(Delete template, VersionType) copy constructor
            }
    public void testLookupVersionWithPrunedAwayIds() throws IOException {
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), randomLongBetween(0, 10));
                    final List<IndexCommit> commits = DirectoryReader.listCommits(store.directory());
     */
        indexSettings.updateIndexMetadata(builder.build());
        IOUtils.close(engine, store);
        AtomicInteger offset = new AtomicInteger(-1);
            OpAndVersion op = sortedHistory.get(i);
            }
                                for (int j = 0; j < numDocs; j++) {
                }
                            assertAndGetInternalTranslogManager(engine.translogManager()).getTranslogUUID(),
        }, null, null, config(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null))) {
                    indexSettings.getSoftDeleteRetentionOperations()
            assertThat(segments.get(0).getSegmentSort(), equalTo(indexSort));
        MatcherAssert.assertThat(
            try {
import org.apache.logging.log4j.core.LogEvent;
import org.opensearch.common.util.BigArrays;
            }
                false,
                        UNASSIGNED_SEQ_NO,
        };
                        assertEquals(2, operation.primaryTerm());
    private DrainFailureOutcome driveRefreshDrainOfFailedBatchAppend(
                null,
                assertThat(collector.getTotalHits(), equalTo(1));
                    appends++;
            assertThat(segments.get(0).committed, equalTo(committed));
            final LongSupplier globalCheckpointSupplier = () -> globalCheckpoint.get();
                    engine.index(indexForDoc(doc));
        engine.ensureOpen();
                    lastOpSeqNo = result.getSeqNo();
            committedOnlySizeMap.put(file, engine.store.directory().fileLength(file));
                        0
        searchResult.close();
            .queryCache(IndexSearcher.getDefaultQueryCache())
    }
        }
                            }
import org.apache.lucene.tests.store.MockDirectoryWrapper;
                                    Engine.GetResult get = engine.get(
            doc,
                assertAndGetInternalTranslogManager(initialEngine.translogManager()).getLastSyncedGlobalCheckpoint(),
            final boolean versionConflict = rarely();
                engine.translogManager().restoreLocalHistoryFromTranslog(engine.getProcessedLocalCheckpoint(), translogHandler);
            recoveringEngine.refresh("test");
                this.removed = removed;
                        for (int i = 0; i < iters; i++) {
            List<Segment> segments = engine.segments(true);
                    origin == PRIMARY ? VersionType.EXTERNAL : null,
                } else if (i % 3 == 1) {
                        i,
                            Translog.Index indexOp = (Translog.Index) operation;
                    while (snapshot.next() != null) {
import static org.mockito.Mockito.doAnswer;
        }
        doc = testParsedDocument("1", null, document, B_1, null);
        assertThat(engine.beginTranslogBatch(), sameInstance(Engine.NO_OP_TRANSLOG_BATCH));
                @Override
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
                        UNASSIGNED_SEQ_NO,
            settings.put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0);
        engine.refresh("test");
        try (Store store = createStore(newFSDirectory(storeDir)); InternalEngine engine = new InternalEngine(configSupplier.apply(store))) {
                        newUid(doc),
                if (isIndexing) {
                    retentionLeasesHolder::get,
        return current;
            assertFalse(segments.get(0).compound);
                    );
     */
    }
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
            VersionUtils.getFirstVersion()
            });
        assertThat(indexResult.getVersion(), equalTo(1L));
            assertEquals(1, engine.getNumVersionLookups());
        assertThat(engine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(numDocs));
    public void testRefreshAndCloseEngineConcurrently() throws Exception {
            false,
    }
                final int threadIdx = threadNum;
        assertVisibleCount(engine, numDocs);
            int numDocsFirstSegment = randomIntBetween(5, 50);
                directory.setRandomIOExceptionRateOnOpen(randomDouble());
                    appends++;
        for (int i = 0; i < cap; i++) {
            initialEngine = engine;
        try (
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), randomLongBetween(0, 10));
        Thread failEngine = new Thread(new AbstractRunnable() {
                    System.nanoTime(),
            "refresh must keep its EngineException contract, threw " + describeExceptionChain(outcome.refreshFailure),
                        new Engine.Delete(
                final int docs = randomIntBetween(1, 100);
            document.add(new Field(SourceFieldMapper.NAME, BytesReference.toBytes(B_1), SourceFieldMapper.Defaults.FIELD_TYPE));
        IOUtils.close(store, engine);
                gcpTracker.updateLocalCheckpoint(replica.allocationId().getId(), replicaLocalCheckpoint);
            0
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
        index = indexForDoc(doc);
                createDocumentWithNestedField("2", "Bob", 25),
        searchResult = engine.acquireSearcher("test");
                                @Override
     * all other text fields. Because these are two distinct {@code PostingsFormat} implementations,
            assertTrue(cleanupCompleted.await(10, TimeUnit.SECONDS));
                Settings.builder()
            assertTrue(engine.isClosed.get());
                LocalCheckpointTracker::new,
                }
        if (randomBoolean()) {
            engine.index(indexForDoc(doc));
            engine.index(indexForDoc(doc));
        doc = testParsedDocument("1", null, document, B_1, null);
                    Document document = testDocumentWithGroupingCriteria();
                        doc,
        final LongSupplier sequenceNumberSupplier = origin == PRIMARY ? () -> UNASSIGNED_SEQ_NO : sequenceNumber::getAndIncrement;
        };
            expectThrowsAnyOf(
            try (
                TermsEnum iterator = id.iterator();
            try (Engine engine = new InternalEngine(configSupplier.apply(store))) {
                    cfeCompoundFileFound = true;
        engine.index(operation);
                store.createEmpty(Version.CURRENT.luceneVersion);
                    0,
                    -1,
        );
import java.util.function.IntSupplier;
                assertEquals(store.refCount(), refCount + 1);
                );
 */
                        null
                }
        // now its there...
        );
                public long getMaxSeqNo() {
        for (Thread t : closingThreads) {
        // The delete flushed the pending chunk: the index now has a location older than the delete's.
    public void testNoOpFailure() throws IOException {
                    : SequenceNumbers.NO_OPS_PERFORMED;
                final TotalHitCountCollector collector = new TotalHitCountCollector();
                .endObject()
            for (int i = 0; i < numSnapshots; i++) {
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
            }
    public void testEnableGcDeletes() throws Exception {
                            VersionType.EXTERNAL,
                assertThat(topDocs.totalHits.value(), equalTo(0L));
                .endObject();
                    highestOpVersion = op.version();
        batchEngine.refresh("test");
            if (values == null) {
            assertNotNull(retryResult.getTranslogLocation());
    }
                                        1,
            } catch (InterruptedException | BrokenBarrierException e) {
                assertThat(
        try (Directory dir = newDirectory()) {
                new HashSet<>(Collections.singletonList(primary.allocationId().getId())),
            Store store = createStore();
import java.util.Comparator;
            UNASSIGNED_SEQ_NO,
        EngineConfig config = engine.config();
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
    public void testTranslogRecoveryDoesNotReplayIntoTranslog() throws IOException {
        try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
    }
        searchResult = engine.acquireSearcher("test");
                directory.setAllowRandomFileNotFoundException(false);
        }
            }
                engine.translogManager().syncTranslog();
                    engine.refresh("test", Engine.SearcherScope.INTERNAL, true);
                directory.setRandomIOExceptionRate(randomDouble());
        try (
    }
            defaultSettings,
            2,
                store,
                ShardRoutingState.STARTED,
import java.util.concurrent.BrokenBarrierException;
            indexResult.getVersion(),
                    eventListener,
     */
                        Engine.Operation.Origin.PRIMARY,
            final Field uidField = new Field("_id", id, IdFieldMapper.Defaults.FIELD_TYPE);
                    if (highest != null) {
                    UNASSIGNED_SEQ_NO,
        // randomly interleave
            assertThat(getResult.docIdAndVersion(), notNullValue());
            assertThat(engine.getProcessedLocalCheckpoint(), equalTo(2L));
            long version = -1;
                new TieredMergePolicy(),
        engine.ensureOpen();
            assertDeletedVersionConflict(
                .settings(Settings.builder().put(indexSettings.getSettings()).put(settingsBuilder.build()))
        });
                        0
            .queryCache(config.getQueryCache())
            }
                } catch (Exception e) {
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
                done.set(true);
import org.apache.lucene.index.NumericDocValues;
            }
            InternalEngine engine = createEngine(
            assertThat(globalCheckpoint, equalTo(replicaLocalCheckpoint));
            assertThat(op2.opType(), equalTo(Translog.Operation.Type.INDEX));
                    "1",
        assertMaxSeqNoInCommitUserData(engine);
    }
                }
        final int opCount = randomIntBetween(1, 256);
import org.opensearch.core.common.Strings;
        engine = new InternalEngine(config);
                .globalCheckpointSupplier(base.getGlobalCheckpointSupplier())
        // but, we can still get it (in realtime)
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                if (rarely()) {
    public void testAllowGroupingCriteriaUpdateWithTombstone() throws IOException, InterruptedException {
        assertThat(batchEngine.getProcessedLocalCheckpoint(), equalTo(NO_OPS_PERFORMED));
            Engine engine = createEngine(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null, null, null, indexSort, null)
            final CountDownLatch latch = latchReference.get();
                    } else {
    }
        IOUtils.close(store, engine);
                if (rarely()) {
                }
import java.util.HashMap;
        engine = createEngine(
            UNASSIGNED_SEQ_NO,
                globalCheckpoint.set(randomLongBetween(globalCheckpoint.get(), engine.getProcessedLocalCheckpoint()));
            // create a document
            ParsedDocument doc3 = testParsedDocument("3", null, testDocumentWithTextField(), B_3, null);
            index.primaryTerm(),
                if (rarely()) {
                VersionType.EXTERNAL,
        // its not there...
        }
                    indexSettings.getTranslogRetentionSize(),
        }
import static org.mockito.ArgumentMatchers.any;
        try (
                indexSettings.getTranslogRetentionAge(),
        engine.close();
        } catch (Exception ex) {
        index = new Engine.Index(
        byte[] max = PointValues.getMaxPackedValue(reader, fieldName);
                        }
            assertThat(op1.opType(), equalTo(Translog.Operation.Type.INDEX));
                return new Engine.Index(
                // test document failure while indexing
                    id = randomFrom(indexedIds);
            assertEquals(maxSeqIDOnReplica, recoveringEngine.getProcessedLocalCheckpoint());
            store.createEmpty(config.getIndexSettings().getIndexVersionCreated().luceneVersion);
        }
                    cfsCompoundFileFound = true;
    }
            }
            engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
            @Override
                0
                        + " term="
                Versions.MATCH_DELETED,
                    assertThat(result.isCreated(), equalTo(docDeleted));
            doc,
                        engine.index(docs.get(docOffset));
            EngineConfig base = config(indexSettings, store, translogPath, NoMergePolicy.INSTANCE, null, null, null);
            for (int i = 0; i < numDocs; i++) {
import java.util.concurrent.CopyOnWriteArrayList;
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
        Engine.IndexResult indexResult = engine.index(index);
                trackerSupplier,
            assertTrue(internalEngine.isClosed.get());
            )
            final TotalHitCountCollector collector = new TotalHitCountCollector();
        searchResult.close();
        try (Engine.GetResult get = batchEngine.get(new Engine.Get(true, true, "del", newUid("del")), batchEngine::acquireSearcher)) {
        final IllegalStateException tragicException = new IllegalStateException("fail to store tombstone");
                        .totalOperationsByMinGen(currentTranslogGeneration),
            newMergePolicy(),
                initialEngine.index(indexForDoc(doc));
                    while ((operation = snapshot.next()) != null) {
                Versions.MATCH_ANY,
                    final long seqNo = values.longValue();
        );
        setIndexWriterMaxDocs(maxDocs);
                    assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
        return new CriteriaBasedMergePolicy(newMergePolicy());
            );
                } catch (BrokenBarrierException | InterruptedException e) {
                        final Engine.Delete delete = new Engine.Delete(
        engine.close();
        engine.refresh("test");
        // Nothing is pending any more, so finish reports the chunk location, which is older than the delete; the
        Thread refreshThread = new Thread(() -> {
            );
                @Override
                            assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().getTranslogUUID(),
            }
        try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
    private static String describeExceptionChain(Throwable t) {
     * For example, a segment containing only no-ops does not have neither _uid or _version.
                    assertThat(result.isCreated(), equalTo(false));
        for (long seqNo : new long[] { 0, 1, randomNonNegativeLong() }) {
            term,
import org.opensearch.index.translog.TranslogOperationHelper;
        }
                    UNASSIGNED_SEQ_NO,
                Translog.Snapshot snapshot = assertAndGetInternalTranslogManager(noOpEngine.translogManager()).getTranslog().newSnapshot()
                                        "Document " + docId + " should have updated value",
                    indexSettings.getTranslogRetentionAge(),
        MatcherAssert.assertThat(
    /**
     * @param expectedLocalCheckpoint the expected local checkpoint after generating a new sequence
import org.apache.lucene.index.TermsEnum;
        }
            seqNo,
                .internalRefreshListener(config.getInternalRefreshListener())
                engine.flush();
                    0
     * counted down / released and resources are closed.
                ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), SOURCE, null);
                    Map<String, Long> liveOps = latestOps.entrySet()
                assertThat(collector.getTotalHits(), equalTo(operations.get(operations.size() - 1) instanceof Engine.Delete ? 0 : 1));
        engine.refresh("test");
                        engine.delete(new Engine.Delete(operation.id(), operation.uid(), primaryTerm.get()));
        engine.close();
    public void testSyncedFlushVanishesOnReplay() throws IOException {
                ParseContext.Document document = testDocumentWithTextField();
        IndexWriterFactory indexWriterFactory = (directory, iwc) -> {
            gcpTracker.updateFromClusterManager(
        }
            uid,
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            assertFalse(mockAppender.sawIndexWriterMessage);
        if (randomBoolean()) { // random empty refresh
import org.opensearch.index.mapper.SeqNoFieldMapper;
    }
            }
        }
                        "engine should trim all unreferenced translog after recovery",
    }
        try (
        Engine.Delete fromShardDeprecated = IndexShard.prepareDelete(
            InternalEngine engine = createEngine(
                // we have assigned sequence numbers to should be in the commit
    public void testConcurrentEngineClosed() throws BrokenBarrierException, InterruptedException {
import org.opensearch.index.VersionType;
                                        randomBoolean(),
     * already-armed value to trigger a flush later.
                index(engine, i);
        assertEquals("my-routing", copiedDelete.routing());
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Lucene.STANDARD_ANALYZER);
    public void testGetMaxSeqNoRefreshed() throws IOException {
                    }
        LogDocMergePolicy policy = new LogDocMergePolicy();
import org.apache.lucene.index.LeafReaderContext;
        try (Engine.GetResult get = batchEngine.get(new Engine.Get(true, true, "upd", newUid("upd")), batchEngine::acquireSearcher)) {
            assertTrue(engine.isClosed.get());
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(0));
        final String translogUUID = Translog.createEmptyTranslog(primaryTranslogDir, UNASSIGNED_SEQ_NO, shardId, newPrimaryTerm);
            try (
        final IntSupplier uncommittedTranslogOperationsSinceLastCommit = () -> {
                    operations.add(
    public void testLastRefreshCheckpoint() throws Exception {
                engine = createEngine(engineConfig);
                    System.nanoTime(),
    public void testFlushDrainsPendingBatchBeforeCommit() throws Exception {
        // make sure we can still work with the engine
            try (
                            userData.get(Translog.TRANSLOG_UUID_KEY)
            for (int i = 0; i < docs; i++) {
                if (op.versionType().isVersionConflictForWrites(highestOpVersion, op.version(), docDeleted) == false) {
            if (flush) {
            assertEquals(0, engine.getNumVersionLookups());
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test1")), 1)
import org.apache.lucene.search.TotalHitCountCollector;
            CyclicBarrier join = new CyclicBarrier(2);
import org.apache.lucene.index.IndexableFieldType;
            UNASSIGNED_SEQ_NO,
            assertThat(readAllOperationsInLucene(engine), hasSize(liveDocs.size()));
                        engine.ensureOpen();
                    .put(indexSettings.getSettings())
    public void testStressUpdateSameDocWhileGettingIt() throws IOException, InterruptedException {
            // create N indexing threads to index documents simultaneously
                assertThat(segment.getSegmentSort(), equalTo(indexSort));
                );
import org.apache.lucene.util.FixedBitSet;
            assertFalse(get.exists());
                throw new AssertionError(e);
            }
        ) {
        try (Engine.GetResult get = engine.get(new Engine.Get(true, false, doc.id(), create.uid()), searcherFactory)) {
                    engine.index(update);
                final ParsedDocument doc = testParsedDocument(
    public void assertNotSameReader(Engine.Searcher left, Engine.Searcher right) {
            }
            } else {
        Engine.Index retry = appendOnlyPrimary(doc.get(), true, 1, create);
            for (int i = 0; i < numDocs; i++) {
                }
                searcherFactory
                // once we are here the version map is unsafe again and we need to do a refresh inside the get calls to ensure we
                        liveDocsWithSource.remove(doc.id());
            Engine.Operation.Origin origin = randomFrom(REPLICA, LOCAL_RESET, PEER_RECOVERY);
                            ) {
                final long length = engine.store.directory().fileLength(file);
                new HashSet<>(Collections.singletonList(primary.allocationId().getId())),
            assertThat(segments.get(0).getDeletedDocs(), equalTo(0));
                    engine.flush();
                        count++;
            EngineConfig noopEngineConfig = copy(
            null,
                equalTo(seqNos)
            return super.softUpdateDocument(term, doc, softDeletes);
     * we are testing an edge case here where we have a fully deleted segment that is retained but has all it's IDs pruned away.
import org.opensearch.core.common.bytes.BytesReference;
        }
        verify(indexWithThrottlingCheck, atLeastOnce()).startTime();
                        () -> expectThrows(
        assertThat(engine.currentOngoingRefreshCheckpoint(), greaterThanOrEqualTo(engine.lastRefreshedCheckpoint()));
                assertThat(engine.getLocalCheckpointTracker().getMaxSeqNo(), equalTo(upToSeqNo));
                // test index with document failure
                    }
    }
                    engine.delete(new Engine.Delete(doc.id(), newUid(doc.id()), primaryTerm.get()));
                    if (randomBoolean()) {
            assertThat(segments.isEmpty(), equalTo(true));
            while (stopped.get() == false) {
                            try (Engine.GetResult getResult = engine.get(newGet(true, doc), engine::acquireSearcher)) {
            "engine must be failed exactly once, reasons were " + outcome.engineFailureReasons,
    }
    public void testSequenceIDs() throws Exception {
        }
        } finally {
                boolean useRecoverySource = randomBoolean() || omitSourceAllTheTime;
                this.version = version;
     * advance the processed checkpoint) before it publishes new segments, so a document made searchable by the refresh
        expectThrows(
            InternalEngine realEngine = createEngine(
                        doneLatch.countDown();
                createEngine(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE)
                        engine.close();
                        throwingIndexWriter.get().setThrowFailure(null);
                protected long doGenerateSeqNoForOperation(Operation operation) {
            .internalRefreshListener(config.getInternalRefreshListener())
        }
                    throw new AssertionError(e);
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
    }
    void assertLuceneOperations(InternalEngine engine, long expectedAppends, long expectedUpdates, long expectedDeletes) {
        Thread[] thread = new Thread[randomIntBetween(3, 5)];
                awaitStarted.await();
                engine = createEngine(engineConfig);
                Versions.MATCH_DELETED,
     *     <li>Providing any other seqNo leaks info that the doc was deleted (and its SeqNo)</li>
            UNASSIGNED_SEQ_NO,
            // we could have multiple underlying merges, so the generation may increase more than once
            .similarity(config.getSimilarity())
                    assertEquals("Expected number of operations in range", to - from + 1, count);
        ) {
import org.apache.lucene.index.DirectoryReader;
            final AtomicReference<CountDownLatch> latchReference = new AtomicReference<>();
                .indexSort(base.getIndexSort())
                        deletesAfterCheckpoint.put(new Term(IdFieldMapper.NAME, Uid.encodeId(op.id())).bytes(), op);
        engine.index(
        ) {
     */
                    }
        store = createStore();
            "1",
            getResult = engine.get(newGet(true, doc), searcherFactory);
            assertThat(ops.stream().map(o -> o.seqNo()).collect(Collectors.toList()), hasItem(20L));
        assertThat("Exactly the uncommitted segment bytes are counted", engine.shouldPeriodicallyFlush(), equalTo(true));
            long unreferencedFileCleanUpsPerformed = engine.unreferencedFileCleanUpsPerformed();
            recoveringEngine = new InternalEngine(copy(replicaEngine.config(), globalCheckpoint::get));
    }
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
                    getTranslog(initialEngine).rollGeneration();
            Engine.GetResult get = engine.get(
                assertThat(commitInfo.localCheckpoint, equalTo(engine.getProcessedLocalCheckpoint()));
                threadPool.executor(ThreadPool.Names.REFRESH)
     */
            }
            assertThat(unreferencedFileCleanUpsPerformed, equalTo(1L));
        final int docs = randomIntBetween(1, 32);
                        values.add(added);
        assertThat("Empty engine does not need flushing", engine.shouldPeriodicallyFlush(), equalTo(false));
            segments = engine.segments(randomBoolean());
                engine.index(indexForDoc(doc1));
                            assertNotSame(internalSearcher.getDirectoryReader(), externalSearcher.getDirectoryReader());
        try (
                    Engine.IndexResult indexResult = engine.index((Engine.Index) op);
            for (int i = 1; i < commits.size(); i++) {
                    engine.refresh("test");
        InternalEngine batchEngine = spy(engine);
        ) {
                engine.refresh("test");
                    try (Engine.GetResult get = engine.get(new Engine.Get(true, false, doc.id(), uidTerm), searcherFactory)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    delete.id(),
        }
                final String id = Integer.toString(i);
            try {
                    if (latestOps.containsKey(op.id()) == false || latestOps.get(op.id()).seqNo() < op.seqNo()) {
    }
            engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
            translogDir,
        latch.countDown();
    public void testRebuildLocalCheckpointTrackerAndVersionMap() throws Exception {
            // check that we can still read the commit that we captured
    }
                        try (Lock ignored = store.directory().obtainLock(IndexWriter.WRITE_LOCK_NAME)) {
            0
            int updates = 0;
     */
                    super.commitIndexWriter(writer, translogUUID);
        }
        assertTrue("safe access should be required", engine.isSafeAccessRequired());
                                    Engine.GetResult get = engine.get(
            assertThat(snapshot.totalOperations(), equalTo(0));
        searchResult.close();
    }
                    engine.ensureOpen();
                }
            public void run() {
        engine.refresh("warm_up");
            UNASSIGNED_SEQ_NO,
                if (event.getLoggerName().endsWith(".IW") && formattedMessage.contains("IW: now apply all deletes")) {
            isRetry,
import java.util.concurrent.Phaser;
                );
                            ParsedDocument doc = testParsedDocument(id, null, testDocument(), B_1, null);
        }
                .tombstoneDocSupplier(config.getTombstoneDocSupplier())
    }
        engine.close();
            assertThat(tombstonesInVersionMap(engine).values(), empty());
            IOUtils.close(actualEngine);
                Set<String> updatedDocs = new HashSet<>();
                    0
                            -1,
            engine.index(indexForDoc(createParsedDoc(Integer.toString(i), null)));
        searchResult.close();
import static org.hamcrest.Matchers.everyItem;
                    } catch (InterruptedException e) {
            protected void commitIndexWriter(DocumentIndexWriter writer, String translogUUID) throws IOException {
            final Path translogPath = createTempDir();
                MediaTypeRegistry.JSON,
    public void testExtractShardId() {
        engine = createEngine(store, createTempDir());
            engine.flush();
                engine.index(indexForDoc(testParsedDocument(Integer.toString(docId), null, document, B_1, null)));
            this.engineFailureReasons = engineFailureReasons;
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
        engine.refresh("test");
            recoveringEngine.translogManager()
                        UNASSIGNED_SEQ_NO,
        assertEquals("my-routing", directDeleteWithRouting.routing());
        engine.close();
                        switch (operation) {
            if (committed) {
            NoMergePolicy.INSTANCE,
        searchResult.close();
        }
        applyOperations(engine, operations);
                    } catch (IOException ex) {
            blockedSeqNo.set(seqNo);
            final boolean versionedOp = versionConflict || randomBoolean();
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexSettings.getIndexMetadata())
                        // https://lucene.apache.org/core/7_2_1/test-framework/org/apache/lucene/mockfile/ExtrasFS.html
                    engine.refresh("test", randomFrom(Engine.SearcherScope.values()), randomBoolean());
        Engine.IndexResult updateResult = engine.index(update);
        IOUtils.close(engine, store);
                }
        Level savedLevel = rootLogger.getLevel();
    }
        long autoGeneratedIdTimestamp = 0;
                .settings(
     * The drained append is a NON-tragic translog failure (the translog stays open). Parity with the per-operation path
        try (
                UNASSIGNED_SEQ_NO,
            assertFalse(segments.get(0).committed);
                // test index with document failure
            false,
                    Engine.Index update = new Engine.Index(
            final EngineConfig config = config(
                    long correctSeqNo = docDeleted ? UNASSIGNED_SEQ_NO : lastOpSeqNo;
                newMergePolicy(),
            .build();
                    } catch (IOException ex) {
        Engine.Index firstIndexRequest = new Engine.Index(
            if (event.getLevel() == Level.TRACE && event.getMarker().getName().contains("[index][0]")) {
                result = engine.delete((Engine.Delete) op);
        }
            @Override
            null
        assertFalse(engine.refreshNeeded());
import org.apache.lucene.index.IndexableField;
                .codecService(codecService)
            ShardId shardId = ShardUtils.extractShardId(test.getDirectoryReader());
    public void testRemoteSegrepBatchedTranslogAppendAndRealtimeGet() throws Exception {
        assertOpsOnReplica(ops, replicaEngine, true, logger);
        try (Engine.Searcher searcher = replicaEngine.acquireSearcher("test")) {
            );
                null,
        try {
        public long addIndexes(Directory... dirs) throws IOException {
            final ShardRouting replica = initializingReplica.moveToStarted();
                    equalTo(Math.max(currentMaxSeqNoOfUpdates, result.getSeqNo()))
        // start the indexing threads
                    while ((docOffset = offset.incrementAndGet()) < docs.size()) {
        }
import org.apache.lucene.search.Sort;
                int refCount = store.refCount();
            for (Engine.Operation op : operations) {
            assertThat(getResult.exists(), equalTo(false));
import org.hamcrest.MatcherAssert;
        );
                for (int op = 0; op < opsPerThread; op++) {
        } finally {
                if (started) {
                        false,
        Engine.Index op = indexForDoc(doc);
            }
     * after a flush can never re-trigger a flush (no flush loop).
                        -1,
            assertFalse(engine.refreshNeeded());
                getStallingSeqNoGenerator(latchReference, barrier, stall, expectedLocalCheckpoint)
        localSegmentsSizeMap.put(IndexFileNames.SEGMENTS + "_99", Long.MAX_VALUE / 2);
            final BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory = engine::acquireSearcher;
            new TranslogConfig(shardId, badTranslogLog, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
        // operations with a seq# equal or lower to the local checkpoint are not indexed to lucene
                final ParsedDocument doc = EngineTestCase.createParsedDoc(id, null);
        final AtomicLong seqNoGenerator = new AtomicLong();
    public void testEngineMaxTimestampIsInitialized() throws IOException {
        assertTrue(deleted.isFound());
        Engine.Delete copiedDelete = new Engine.Delete(directDeleteWithRouting, VersionType.EXTERNAL);
            for (String file : snapshot.get().files(false)) {
        assertTrue("cross-thread realtime GET must not hang on a pending translog location", done.await(30, TimeUnit.SECONDS));
                        // and in turn fails the engine
                        } else if (operation instanceof Translog.Delete) {
        logger.info("--> got seqID: {}", seqID);
                null,
            } else {
                Engine.Operation.Origin.PRIMARY,
            recoveringEngine.translogManager()
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
        assertOperationHistoryInLucene(operations);
                closed = false;
 *
            .filter(e -> e.getValue() instanceof DeleteVersionValue)
import java.util.ArrayList;
                // Fail segment merge with diskfull during merging terms
import org.opensearch.index.mapper.Uid;
                    assertThat(
                snapshots.get(i).close();
                }
            1,
     * asserted exactly by probing thresholds of the uncommitted size and one byte above it, and a publication
        final Queue<OpAndVersion> history = ConcurrentCollections.newQueue();
            0
                assertThat(context.reader(), Matchers.instanceOf(SequentialStoredFieldsLeafReader.class));
            Engine.Index firstIndexRequest = new Engine.Index(
        assertThat(engine.getVersionMap().values(), hasSize(1)); // now we add this to the map
                fail(dump.toString());
            throw new RuntimeException(e);
            docs.add(originalIndex);
        return engine.getNumIndexVersionsLookups();
                        expectThrows(IllegalStateException.class, engine.translogManager()::ensureCanFlush);
    public void testRefreshDrainOfNonTragicBatchAppendDoesNotFailEngine() throws Exception {
            }
        // its not there...
            for (final Map.Entry<Thread, CountDownLatch> entry : threads.entrySet()) {
        try {
                countDownLatch.await();
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
 * Unless required by applicable law or agreed to in writing,
            VersionType.INTERNAL,
            engine.index(index);
            clock.set(randomLongBetween(100 + gcInterval * 4 / 3, Long.MAX_VALUE)); // Need a margin for gcInterval/4.
        engine.index(indexForDoc(doc));
                prevLocalCheckpoint = localCheckpoint;
                            engine.index(indexForDoc(doc));
                @Override
                .primaryTermSupplier(base.getPrimaryTermSupplier())
import java.io.IOException;
            );
            exists = currentValues.add(op.added);
        try (Store store = createStore()) {
                    null
        assertThat(update_1_result.getVersion(), equalTo(2L));
        // Enable fuzzy set for doc ID so that _id uses FuzzyFilterPostingsFormat while other
        operation = randomBoolean() ? appendOnlyPrimary(doc, false, 1) : appendOnlyReplica(doc, false, 1, generateNewSeqNo(engine));
            newUid(doc),
                i++;
            Engine.IndexResult indexResult = engine.index(operation);
                    newUid(doc),
                wrappedSnapshot = engine.acquireLastIndexCommit(flushFirst);
            randomBoolean(),
            globalCheckpoint.set(randomLongBetween(engine.getPersistedLocalCheckpoint(), Long.MAX_VALUE));
                    } else {
            for (int threadNum = 0; threadNum < numIndexingThreads; threadNum++) {
        List<Engine.IndexResult> results = new ArrayList<>(cap);
            VersionType.EXTERNAL,
        Engine.Index index = indexForDoc(doc);
                        Versions.MATCH_ANY,
            localCP
            }
            t.join();
                liveDocs.add(doc.id());
                                        engine::acquireSearcher
                .put(IndexSettings.INDEX_CONTEXT_AWARE_ENABLED_SETTING.getKey(), true)
        shuffle(ops, random());
            totalExpectedOps++;
            delete.origin(),
            .build();
        final String[] ids = new String[] { "1", "2", "3" };
            Engine.Index index = (Engine.Index) lastOp;
                    synchronized (closingThreads) {
                }
        engine.flush();
        assertThat(failure.get(), nullValue());
                int times = randomIntBetween(1, 10);
            for (ParsedDocument doc : docs) {
                    Engine.Operation.Origin.PRIMARY,
            300,
        try (InternalEngine recoveringEngine = new InternalEngine(engine.config())) {
            .translogConfig(config.getTranslogConfig())
                        );
        Loggers.addAppender(iwIFDLogger, mockAppender);
        Engine initialEngine = null;
    private InternalEngine createUpdateOnlyEngine(EngineConfig config) throws IOException {
                    return localCheckpoint.get();
                        store.close();
                final IOException ex = addDocException.getAndSet(null);
        final String docId = Integer.toString(id);
            engine.refresh("test", Engine.SearcherScope.INTERNAL, true);
        // A new engine may have more than one empty translog files - the test should account this extra.
                    );
                store,
                // Test snapshot with all operations
        threadPool = spy(threadPool);
            operation.primaryTerm(),
                        IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
        for (int i = 0; i < thread.length; i++) {
        }) {
                    try {
            } else {
    public void testUnreferencedFileCleanUpFailsOnSegmentMergeFailureWhenDirectoryClosed() throws Exception {
        final ParsedDocument doc = testParsedDocument(
                initialEngine.index(indexForDoc(doc));
                            throw new RuntimeException("power's out");
            try (
                assertThat(
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test1")), 1)
                    }
        Thread[] closingThreads = new Thread[3];
                    assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            assertEquals(1, searcher.getIndexReader().numDocs());
                -1,
                        UNASSIGNED_SEQ_NO,
                    newUid(document3),
        final VersionConflictEngineException versionConflictEngineException = expectThrows(
        }
                            idToDelete,
            indexResult.getSeqNo(),
        };
            recoveringEngine.translogManager()
    }
            assertThat(segments.get(0).getNumDocs(), equalTo(liveDocsFirstSegment.size()));
            } catch (AlreadyClosedException e) {
            Set<String> liveDocsFirstSegment = new HashSet<>();
        );
        }
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(1));
                                    engine::acquireSearcher
                Collections.singletonList(document),
        engine.refresh("test");
            assertLuceneOperations(engine, 1, 0, 0);
            }
                null,
    public void testAppendConcurrently() throws InterruptedException, IOException {
                        deletedDocs.add(idToDelete);
                engine.index(
            false,
            }
        while (work.isEmpty() == false) {
                        1,
    }
        try (
                assertNotNull(retryResult.getTranslogLocation());
                        );
            }
                        Versions.MATCH_ANY,
            VersionType.INTERNAL,
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
                }
            newUid(doc),
        DocumentMapperForType documentMapperForType = new DocumentMapperForType(documentMapper, null);
        assertThat(noOpResult.getSeqNo(), equalTo(seqNo));
                        }
                    new NoneCircuitBreakerService(),
            )
    public void testGetProcessedLocalCheckpoint() throws IOException {
        }
    }
            assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
        Thread getThread = new Thread(() -> {
                    newUid(document),
 * license agreements. See the NOTICE file distributed with
                .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")
                engine.translogManager().syncTranslog();
                            final String id = "thread" + threadIdx + "#" + i;
            delete.versionType(),
            consumer.accept(engine, op);
            public void eval(MockDirectoryWrapper dir) throws IOException {
            writer.setLiveCommitData(userData.entrySet());
        boolean primary = randomBoolean();
                    10,
                        engine.refresh("test");
        final int numberOfOperations = randomIntBetween(16, 32);
            }
            }
            defaultSettings.getIndexMetadata(),
                Translog.Operation operation;
import org.apache.lucene.index.LogDocMergePolicy;
            0
            return indexWriterHolder.get();
                VersionType.INTERNAL,
        try (Store store = createStore(); InternalEngine engine = createEngine(store, createTempDir())) {
                                ) {
                        testContextSpecificDocument("grouping_criteria"),
                InternalEngine engine = new InternalEngine(
        CountDownLatch startGun = new CountDownLatch(thread.length);
            assertThat(
            config.getIndexSettings(),
        assertThat(batchEngine.getProcessedLocalCheckpoint(), equalTo(NO_OPS_PERFORMED));
                    updatedDocs.add(idToUpdate);
            refresher.join();
import java.util.Collections;
            wrapper.setFailOnOpenInput(randomBoolean());
            }
            outcome.refreshFailure,
                }
        }
        );
                    );
        public boolean sawIndexWriterMessage;
        if (randomBoolean()) {
                            // Verify document is actually deleted
                globalCheckpoint.set(randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, engine.getPersistedLocalCheckpoint()));
                final long min = randomLongBetween(0, maxSeqNo - 5);
            for (long seqno = 0; seqno <= localCheckpoint; seqno++) {
    }
                        for (String file : segmentReader.getSegmentInfo().files()) {
                        assertEquals(msg, ((Translog.Index) op).source(), B_1);
                    assertEquals("deleted IDs are pruned away", reader.numDocs(), id.size());
            try (GatedCloseable<IndexCommit> wrappedSafeCommit = engine.acquireSafeIndexCommit()) {
        Engine.IndexResult result = engine.index(idxRequest);
            2,
                    while ((operation = snapshot.next()) != null) {
        translogHandler = createTranslogHandler(engine.engineConfig.getIndexSettings(), engine);
            try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)) {
        };
    public void testVersioningNewIndex() throws IOException {
    }
                    new Engine.Delete(
                    );
        assertTrue("safe access should be required", engine.isSafeAccessRequired());
                    engine.ensureOpen();
    public void testSyncTranslogConcurrently() throws Exception {
        long highestOpVersion = Versions.NOT_FOUND;
                clearFailure(); // one shot
                }
            () -> engine.get(
            randomBoolean(),
            System.nanoTime(),
    public void testCommitStats() throws IOException {
            assertLuceneOperations(engine, 1, 0, 0);
                        newUid("1"),
                        Engine.Operation.Origin.PRIMARY,
                for (int i = 0; i < numDocs; i++) {
                engine.index(
import static org.hamcrest.Matchers.emptyArray;
                        assertAndGetInternalTranslogManager(engine.translogManager()).getTranslogUUID(),
import org.opensearch.index.mapper.MapperService;
            assertThat(segments.get(0).getDeletedDocs(), equalTo(0));
            Engine.IndexResult indexResult = engine.index(operation);
        final long seqNo = randomIntBetween(Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED), Integer.MAX_VALUE);
            InternalEngine internalEngine = createEngine(config);
                        VersionType.EXTERNAL,
                    newUid(doc),
        BytesReference source = null;
        InternalEngine engine = createEngine(store, createTempDir(), (a, b) -> mockCheckpointTracker);
     * REPLICA or PEER_RECOVERY origin to translog although they already exist in the engine (i.e. hasProcessed() == true).
    public Engine.Index appendOnlyReplica(ParsedDocument doc, boolean retry, final long autoGeneratedIdTimestamp, final long seqNo) {
            assertThat(segments.isEmpty(), equalTo(true));
            try (
                        System.nanoTime(),
                );
                public long getProcessedCheckpoint() {
                assertThat(segment.getMergeId(), nullValue());
                assertNull(indexResult.getTranslogLocation());
                        operations.add(delete);
                    index.isRetry(),
            assertThat(segments.get(0).getDeletedDocs(), equalTo(0));
            InternalEngine engine = createEngine(
                        UNASSIGNED_SEQ_NO,
            null
            List<String> engineFailureReasons,
                    final Engine.IndexResult result = initialEngine.index(index);
                for (int i = 0; i < seqNos.size(); i++) {
        }
    public void testLuceneHistoryOnReplica() throws Exception {
        );
                engine.index(indexForDoc(doc));
                getStallingSeqNoGenerator(latchReference, barrier, stall, expectedLocalCheckpoint)
        final String syncId = randomUnicodeOfCodepointLengthBetween(10, 20);
            EngineCreationFailureException.class,
            engine.forceMerge(flush, 1, false, false, false, UUIDs.randomBase64UUID());
                // test document failure while indexing
                ParsedDocument doc = testParsedDocument(idToUpdate, null, testDocument(), B_1, null);
            if (create) {
        Throwable current = t;
                            UNASSIGNED_SEQ_NO,
        }
        );
            assertThat(reader.leaves().size(), Matchers.greaterThanOrEqualTo(1));
            engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                    idxSettings,
                    engine.delete(new Engine.Delete(doc.id(), newUid(doc.id()), primaryTerm.get()));
                UNASSIGNED_SEQ_NO,
                        System.nanoTime(),
                        newUid(id),
                assertNull(retryResult.getTranslogLocation());
            final IndexSettings indexSettings = engine.config().getIndexSettings();
                finalActualEngine.flush();
            // this refresh makes the op visible but samples the processed checkpoint before the op is marked as processed
        final boolean flush = randomBoolean();
            int updates = 0;
                newUid(doc),
                    try (Engine.Searcher internalSearcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
                            VersionType.INTERNAL,
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                                Engine.GetResult get = engine.get(
                        null
    }
    }
            }
                    Map<String, String> userData = engine.getLastCommittedSegmentInfos().getUserData();
                try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, operations.size() - 1, true, true)) {
    public void testIndexWriterIFDInfoStream() throws IllegalAccessException, IOException {
            final Throwable thrown = refreshOutcome.get();
        }
                            return in;
                                try (
import org.opensearch.index.mapper.DocumentMapper;
            if (rarely()) {
                engine.index(indexForDoc(doc2));
        int numCommits = between(5, 20);
    }
            IOUtils.close(commits);
            localCheckpoint.set(
        );
            "1",
    public void testTranslogReplayWithFailure() throws IOException {
                assertSameReader(getSearcher, searchSearcher);
                createTempDir(),
        IOUtils.close(engine, store);
                    false,
        }
                .put(defaultSettings.getSettings())
            {
            // each time the version increments as we walk the list, that counts as a successful operation
                        assertTrue(getResult.exists());
                clearFailure(); // one shot
                assertEquals(10, searchSearcher.getIndexReader().numDocs());
        final Settings.Builder settings = Settings.builder().put(defaultSettings.getSettings()).put("index.refresh_interval", "300s");
                            null,
 * this file be licensed under the Apache-2.0 license or a
                        Engine.Operation.Origin.PRIMARY,
            assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().getMinFileGeneration(),
            final CountDownLatch doneLatch = new CountDownLatch(numIndexingThreads);
        final boolean deletedOnReplica = lastReplicaOp instanceof Engine.Delete;
                        UNASSIGNED_SEQ_NO,
        try (Engine.GetResult getResult = engine.get(newGet(true, doc), searcherFactory)) {
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    /**
            refresher.start();
        final List<Engine.Operation> operations = new ArrayList<>();
        );
                        false,
            1,
                } else if (op instanceof Engine.Delete) {
            randomFrom(VersionType.INTERNAL, VersionType.EXTERNAL),
                assertThat(reader.numDocs(), equalTo(flushFirst && safeCommit == false ? numDocs : 0));
                    try {
                            primaryTerm.get(),
            assertNotNull(engine.failedEngine.get());
            + engine.getNumDocAppends()
            }
                Engine.Searcher searchSearcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)
                    document.add(new TextField("value", "updated", Field.Store.YES));
                                // Verify updated content using get
            Engine.Index primaryResponse = indexForDoc(doc);
import java.util.ArrayDeque;
                super.commitIndexWriter(writer, translogUUID);
            index.versionType(),
            indexSettings.getTranslogRetentionSize(),
            );
        engine.refresh("test");
                        Engine.GetResult getResult = engine.get(new Engine.Get(true, false, doc3.id(), doc3.uid()), engine::acquireSearcher)
                final String translogUUID = Translog.createEmptyTranslog(
                for (int i = 0; i < numDocs; i++) {
                    assertNull(VersionsAndSeqNoResolver.loadDocIdAndVersion(reader, new Term(IdFieldMapper.NAME, "1"), false, null));
     * exactly how a concurrent realtime GET resolves a pending location in production.
            + engine.getNumDocDeletes()
            engine.translogManager().syncTranslog();
                        result = engine.delete(delWithSeq.apply(correctSeqNo, lastOpTerm, delete));
                    if (randomInt(100) < 5) {
        }
        }
                    assertThat(result.getVersion(), equalTo(op.version()));
            XContentBuilder builder = XContentFactory.jsonBuilder()
                try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, operations.size() - 1, true, true)) {
                writer.softUpdateDocument(new Term(IdFieldMapper.NAME, "1"), doc, new NumericDocValuesField(Lucene.SOFT_DELETES_FIELD, 1));
                    }
                newUid(doc),
        Set<String> liveDocIds = new HashSet<>();
            final List<Thread> indexingThreads = new ArrayList<>();
import java.util.Queue;
                final Thread thread = new Thread(() -> {
            latchReference.get().countDown();
                try {
        engine.delete(new Engine.Delete("1", newUid(doc), primaryTerm.get()));
                        0,
        }
        engine.refresh("test");
        }
        store = createStore();
                    globalCheckpoint.set(randomLongBetween(globalCheckpoint.get(), getPersistedLocalCheckpoint()));
            final String docId = Integer.toString(10);
            initialEngine.flush(true, true);
                    newUid("2"),
 */
                            -1,
        // Index the same document for the third time, this time changing the primary term
            // All segments have to be merged into one
        engine.onSettingsChanged(
            1,
            engine.index(index);
     */
            closingThreads[i].setName("closingThread_" + i);
            // now ensure external refreshes are reflected on the internal reader
                if (rarely()) {
            engine.refresh("test");
                try (Engine.GetResult getResult = engine.get(new Engine.Get(true, false, doc.id(), doc.uid()), engine::acquireSearcher)) {
                equalTo(primarySeqNo)
        // insert some duplicates
        assertThat(batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
                null,
                } else {
        logger.info("--> got seqID: {}", seqID);
                    dir,
        searchResult = engine.acquireSearcher("test");
            .tombstoneDocSupplier(tombstoneDocSupplier())
                engine.delete(
            assertThat(segments.isEmpty(), equalTo(true));
                    .put(indexSettings.getSettings())
        for (int j = 0; j < randomIntBetween(1, 10); j++) {
                    // only update rarely as we do it every doc
        List<Engine.Operation> operations = generateHistoryOnReplica(between(1, 500), randomBoolean(), randomBoolean(), randomBoolean());
                        Engine.Operation.Origin.PRIMARY,
            try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
            assertEquals(2, engine.getNumVersionLookups());
     */
        try {
    }
            assertThat(topDocs.totalHits.value(), equalTo(numDocs + 1L));
    }
        }
                        -1,
        operation = appendOnlyPrimary(doc, false, 1, create);
            }
        engine.index(indexForDoc(doc));
        class CustomTranslogDeletionPolicy extends DefaultTranslogDeletionPolicy {
        indexSettings.updateIndexMetadata(indexMetadata);
            UNASSIGNED_SEQ_NO,
            );
import org.apache.lucene.document.TextField;
                    engine.index(indexForDoc(createParsedDoc("id", null)));
                        null,
                originalIndex = appendOnlyReplica(doc, false, i, i * 2);
                    assertNull(id); // everything is pruned away
                    engine.delete(new Engine.Delete(doc.id(), newUid(doc), primaryTerm.get()));
                    replicaEngine.index(replicaIndexForDoc(doc, 1, indexResult.getSeqNo(), false));
                index(finalActualEngine, 3 * i + 2);
            assertThat(currentValues, equalTo(new HashSet<>(values)));
        IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
                throw new RuntimeException(e);
    void syncFlush(IndexWriter writer, InternalEngine engine, String syncId) throws IOException {
                        assertThat(fileCount, equalTo(13L));
            }
                        deletedDocs.add(idToDelete);
                        }
            segments = engine.segments(randomBoolean());
                    // we increase the wait time to make sure we eventually if things are slow wait for threads to finish.
                );
        assertEquals("my-routing", withRouting.routing());
        }
        final BiFunction<Long, Long, LocalCheckpointTracker> trackerSupplier = (maxSeq, localCP) -> new LocalCheckpointTracker(
                            Lucene.SOFT_DELETES_FIELD,
            indexer.join();
import static org.opensearch.index.engine.Engine.Operation.Origin.REPLICA;
                    return;
        work.push(t);
            final AtomicBoolean committed = new AtomicBoolean();
                            doc.id(),
            null,
        final DrainFailureOutcome outcome = driveRefreshDrainOfFailedBatchAppend(
                store,
                    delete.version(),
                            String docId = indexOp.id();
            }
                        UNASSIGNED_SEQ_NO,
        ) {
        final int numDocs = randomIntBetween(1, 10);
        failEngine.start();
        }
        engine.flush();
        }
    public void testSeqNoGenerator() throws IOException {
                    assertThat(
                    doneLatch.countDown();
                    engine.refresh("testing");
                        document2,
                IndexReader reader = searcher.getIndexReader();
        });
            // Get should still not find the document
                            idToDelete,
                currentTerm.set(currentTerm.get() + 1L);
            Store store = createStore();
        index = indexForDoc(doc);
                try (DirectoryReader reader = DirectoryReader.open(writer)) {
        );
            create.primaryTerm(),
                }
                while (stop == false) {
                int numDocsToUpdate = randomIntBetween(1, numDocs - deletedDocs.size());
                    operations.add(operation);
                    refreshOutcome.set(t);
                UNASSIGNED_SEQ_NO,
        EngineConfig config = engine.config();
                        Engine.Operation.Origin.PRIMARY,
            Engine.IndexResult retryResult = engine.index(retry);
                            "test"
            int deletes = 0;
        );
        when(mapperService.isCompositeIndexPresent()).thenReturn(false);
                @Override
            final ParsedDocument doc = testParsedDocument(Long.toString(seqno), null, testDocumentWithTextField(), SOURCE, null);
                if (randomBoolean()) {
            replicaEngine.translogManager().syncTranslog(); // to advance local checkpoint
        assertNull(withoutRouting.routing());
            noOpEngine.noOp(new Engine.NoOp(maxSeqNo + 1, primaryTerm.get(), LOCAL_TRANSLOG_RECOVERY, System.nanoTime(), reason));
    }
                null,
            );
                localSegmentsSizeMap.put(file, engine.store.directory().fileLength(file));
                FlushFailedEngineException e = expectThrows(FlushFailedEngineException.class, engine::flush);
            );
                        engine.getMaxSeqNoOfUpdatesOrDeletes(),
        ) {
                    assertThat(result.getVersion(), equalTo(highestOpVersion));
            // skip to the op that we added to the translog
                store.associateIndexWithNewTranslog(translogUUID);
            }
            final ParsedDocument doc = testParsedDocument(Integer.toString(id), null, testDocumentWithTextField(), SOURCE, null);
     */
                    new NoneCircuitBreakerService(),
            assertThat(engine.segments(false).size(), equalTo(1));
            public long addDocument(Iterable<? extends IndexableField> doc) throws IOException {
                createTempDir(),
                indexForDoc(testParsedDocument("drain-1", null, testDocument(), B_1, null))
            randomBoolean()
            }
                        0
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
                    wrappedSafeCommit.get().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)
            Store store = createStore();
                    }
     * Lucene's {@code PerFieldPostingsFormat} writes a separate file group for each, producing
            UNASSIGNED_SEQ_NO,
                    lastOpTerm = result.getTerm();
                        final Long maxSeqNoInCommit = seqNos.subList(0, i + 1).stream().max(Long::compareTo).orElse(-1L);
            List<Engine.Operation> operationsInSafeCommit = null;
        }
            t1.start();
            0
        // when a new translog is created it should be ok
                                indexed.countDown();
                    engine.index(indexForDoc(createParsedDoc(Integer.toString(docId.getAndIncrement()), null)));
                    return parsedDocument;
                } catch (EngineException | TranslogException | IOException e) {
        final long currentSeqNo = getSequenceID(
        Engine.IndexResult result = engine.index(operation);
            int numDocsFirstSegment = randomIntBetween(5, 50);
        for (int i = 0; i < numDocs; i++) {
                    }
            engine.refresh("test");
            assertThat(unreferencedFileCleanUpsPerformed, equalTo(0L));
    public void testShouldPeriodicallyFlushOnUncommittedSegmentBytes() throws Exception {
                assertThat(indexResult.getVersion(), equalTo(1L));
            Engine.Operation.TYPE type = randomFrom(Engine.Operation.TYPE.values());
        Set<Long> expectedSeqNos = new HashSet<>();
                supplier,
        if (lastOp instanceof Engine.Index) {
                        ParsedDocument doc = testParsedDocument(id, null, testDocument(), B_1, null);
                        VersionType.INTERNAL,
                    @Override
        store = createStore();
                    null
                    assertThat(result.getFailure(), nullValue());
        when(mockCheckpointTracker.getProcessedCheckpoint()).thenReturn(expectedLocalCheckpoint);
            true,
        assertThat("All published files are committed now", engine.shouldPeriodicallyFlush(), equalTo(false));
                if (randomBoolean()) {
            // delete
                .build()
        );
                    replicaDeleteForDoc(UUIDs.randomBase64UUID(), Versions.MATCH_ANY, gapSeqNo, threadPool.relativeTimeInMillis())
                        VersionType.INTERNAL,
                }
                engine.delete((Engine.Delete) operation);
        try (Engine.GetResult get = engine.get(new Engine.Get(true, false, doc.id(), create.uid()), searcherFactory)) {
                    throw new AssertionError(e);
            UNASSIGNED_SEQ_NO,
            1,
            index.isRetry(),
                if (useRecoverySource == false) {
        }
            assertNotNull(retryResult.getTranslogLocation());
    /**
            1,
            assertEquals(
            assertLuceneOperations(engine, 1, create ? 0 : 1, 0);
            assertTrue(cleanupCompleted.await(10, TimeUnit.SECONDS));
        for (int i = 0; i < numDocs; i++) {
     * simulates what an upsert / update API does
            "2"
            try (InternalEngine engine = new InternalEngine(config)) {
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                }
            assertThat(topDocs.totalHits.value(), equalTo((long) numDocs));
                    leases.add(new RetentionLease(id, retainingSequenceNumber, timestamp, source));
            assertThat(engine.segments(false), empty());
            );
        }
            this.engineClosedAfterwards = engineClosedAfterwards;
        }
                            System.nanoTime(),
    }
                store,
    }
        int numDocs = randomIntBetween(10, 100);
            }
                // Test snapshot with all operations
                assertConsistentHistoryBetweenTranslogAndLuceneIndex(noOpEngine);
        }
        Settings.Builder settings = Settings.builder()
                            .recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE)
        assertThat(updateResult.getVersion(), equalTo(2L));
            recoveringEngine = new InternalEngine(initialEngine.config()) {
        Settings settings = settingBuilder.build();
                        throw new MockDirectoryWrapper.FakeIOException();
            );
            new BytesArray("{}".getBytes(Charset.defaultCharset())),
            assertEquals(maxSeqIDOnReplica, replicaEngine.getSeqNoStats(-1).getMaxSeqNo());
            engine.refresh("test");
                    @Override
            final ParsedDocument doc1 = testParsedDocument("1", null, testContextSpecificDocument("grouping_criteria"), B_1, null);
            thread[i] = new Thread(() -> {
            searchResult,
            tombstones.removeIf(v -> v.seqNo < gapSeqNo);
                        new Engine.NoOp(seqNo, primaryTerm.get(), randomFrom(Engine.Operation.Origin.values()), randomNonNegativeLong(), "")
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
                barrier.await();
        final int numDocs = randomIntBetween(1, 10);
                            UNASSIGNED_SEQ_NO,
                final Engine.Result result = applyOperation(engine, operations.get(i));
            .externalRefreshListener(config.getExternalRefreshListener())
                } else {
    }
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
    }
                    replicaIndexForDoc(testParsedDocument("d", null, testDocumentWithTextField(), SOURCE, null), 1, gapSeqNo, false)
            List<Segment> segments = engine.segments(true);
            assertThat(segments, hasSize(1));
            return seqNo;
            autoGeneratedIdTimestamp,
                try {
        );
                    }
            Store store = createStore();
    }
                    Engine.IndexResult index = engine.index(replicaIndexForDoc(doc, between(1, 100), i, randomBoolean()));
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), numDocs + 1);
        assertThat(engine.shouldPeriodicallyFlush(), equalTo(false));
        Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId("1"));
            engine.flush();
    }
        };
        Engine.Index index = indexForDoc(doc);
    }
        try (Store store = createStore(); Engine engine = createEngine((dir, iwc) -> new IndexWriter(dir, iwc) {
                Settings.builder()
                Phaser phaser = new Phaser(getters.length + 1);
            segments = engine.segments(false);
            );
                    0,
        }
            InternalEngine engine =
     * <ul>
                        Engine.Operation.Origin.PRIMARY,
            final long initialRefreshCount = refreshCounter.get();
            noOpEngine.noOp(
                null,
            engine.refresh("test");
                }
            );
            try (Store store = createStore(); InternalEngine engine = createEngine(store, createTempDir())) {
                new RetentionLeases(primaryTerm, retentionLeasesVersion.get(), Collections.emptyList())
            for (ParsedDocument doc : docs) {
                int numDocs = randomIntBetween(10, 100);
            assertThat(segments.size(), equalTo(1));
                    int docOffset;
        InternalEngine initialEngine = null;
                }
                    assertThat(result.getFailure(), instanceOf(VersionConflictEngineException.class));
                if (randomBoolean()) {
                );
                                        randomBoolean(),
                        // Verify operation type
            Engine.Index index = indexForDoc(doc2);
                engine.delete(new Engine.Delete(doc.id(), doc.uid(), primaryTerm.get()));
        store = createStore();
            index.uid(),
            assertThat(segments.isEmpty(), equalTo(true));
                long safeCommitLocalCheckpoint = Long.parseLong(
                }
                    );
                TestTranslog.drainSnapshot(snapshot, false).stream().map(Translog.Operation::seqNo).collect(Collectors.toSet()),
                            2,
        }).when(indexWithoutThrottlingCheck).startTime();
                    engine.delete(new Engine.Delete(doc.id(), newUid(doc), primaryTerm.get()));
                    assertThat(result.getVersion(), equalTo(lastOpVersion));
                    UNASSIGNED_SEQ_NO,
                        0
            .queryCache(config.getQueryCache())
                Thread thread = new Thread(() -> {
    public void testSegmentContainsOnlyNoOps() throws Exception {
        final long retainedExtraOps = randomLongBetween(0, 10);
                    public void run() {
            try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                for (int i = 0; i < operationsFromLucene.size(); i++) {
            try (GatedCloseable<IndexCommit> wrappedSafeCommit = engine.acquireSafeIndexCommit()) {
                        throw new AssertionError(e);
            engine.refresh("test");
                    // make sure all sequence numbers up to and including the local checkpoint are in the index
        translog.close();
    }
                org.apache.lucene.document.Document luceneDoc = searcher.storedFields().document(search.scoreDocs[i].doc);
        final Term uidTerm = newUid(doc);
        create = new Engine.Index(
    /**
            if (defaultSettings.isSoftDeleteEnabled()) {
                    assertThat(deleteResult.getFailure(), nullValue());
        try (
                assertNotNull(indexResult.getTranslogLocation());
                    groupingCriteria = "grouping_criteria1";
import org.opensearch.index.mapper.MappedFieldType;
        engine.refresh("test");
                createDocumentWithNestedField("3", "Charlie", 35)
        running.set(false);
                } catch (AlreadyClosedException e) {
                    final Engine.Index operation = new Engine.Index(
        searchResult = engine.acquireSearcher("test");
                    UNASSIGNED_SEQ_NO,
                    int i = controller.incrementAndGet();
    public void testVersioningCreateExistsException() throws IOException {
            // Delete document we just added:
        List<Engine.Operation> operations = new ArrayList<>();
                assertEquals(store.refCount(), refCount);
            VersionType.INTERNAL,
            engine.ensureOpen();
                try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, operations.size() - 1, true, true)) {
            1,
                    updates++;
            };
                engine.flush(randomBoolean(), true);
            int iterations = scaledRandomIntBetween(1, 50);
                }
import static org.hamcrest.Matchers.greaterThan;
                liveDocs.add(doc.id());
            "test",
                        deletedDocs.add(idToDelete);
            InternalEngine engine = createEngine(config(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null))
            UNASSIGNED_SEQ_NO,
            2,
                assertEquals(maxSeqIDOnReplica, recoveringEngine.getProcessedLocalCheckpoint());
    }
        }
            equalTo(1)
                            i,
                }
                } else {
            engine.refresh("test");
                assertAndGetInternalTranslogManager(recoveringEngine.translogManager()).getLastSyncedGlobalCheckpoint(),
        document = testDocumentWithTextField();
        Store store = createStore();
        engine.close();
            } else {
            Store store = createStore();
                final CountDownLatch indexed = new CountDownLatch(1);
            Engine.Index firstIndexRequest = new Engine.Index(
                .circuitBreakerService(base.getCircuitBreakerService())
            ParsedDocument doc = testParsedDocument("1", null, document, B_2, null);
            try (IndexReader reader = DirectoryReader.open(commits.get(0))) {
        long replicaLocalCheckpoint = SequenceNumbers.NO_OPS_PERFORMED;
        );
                    public void beforeRefresh() {
                if (randomInt(100) < 10) {
    }
import org.apache.lucene.index.LiveIndexWriterConfig;
                        // extra0 file is added as a part of
        // Exercise the deprecated static IndexShard.prepareDelete (no routing) overload
                TestTranslog.drainSnapshot(snapshot, false).stream().map(Translog.Operation::seqNo).collect(Collectors.toSet()),
            index.versionType(),
    private Store createFailingDirectoryStore(final Directory directory) {
                safeCommitCheckpoint = Long.parseLong(wrappedSafeCommit.get().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
                    liveDocs.add(doc.id());
                Settings.builder()
            for (int i = 0; i < numDocs; i++) {
        Engine.Index secondIndexRequest = new Engine.Index(
        }
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
        Path translogPath = createTempDir();
            final long conflictingSeqNo = lastOpSeqNo == UNASSIGNED_SEQ_NO || randomBoolean() ? lastOpSeqNo + 5 : // use 5 to go above 0 for
                assertThat(warmedUpReaders, hasSize(1));
                    ids.add(id);
                parsedDocument,
                            try {
        for (int j = 0; j < numIters; j++) {
        Settings.Builder settings = Settings.builder()
            Throwable refreshFailure,
                    } finally {
            }
        MockDirectoryWrapper.Failure fail = new MockDirectoryWrapper.Failure() {
        Settings.Builder settings = Settings.builder()
                        docID,
                assertNull(indexResult.getTranslogLocation());
            1,
        mergePolicy.setSegmentsPerTier(2);
                        public LeafReader wrap(LeafReader reader) {
        doc = testParsedDocument("2", null, testDocumentWithTextField(), SOURCE, null);
            }
    }
        applyOperations(engine, ops);
                primaryTerm.get()
                Thread thread = new Thread() {
                false
                    )
            initialEngine.close();
            Store store = createStore();
        }
        engine.refresh("test");
                }
                index(engine, randomInt());
            defaultSettings.getIndexMetadata(),
            public void eval(MockDirectoryWrapper dir) throws IOException {
                );
        };
            assertThat(actualOps.stream().map(o -> o.seqNo()).collect(Collectors.toList()), containsInAnyOrder(expectedSeqNos.toArray()));
                            long len = store.directory().fileLength(file);
        } else {
            )
                        0
                if (primaryTerms == null || primaryTerms.advanceExact(docIdAndSeqNo.docId) == false) {
            public void afterRefresh(boolean didRefresh) {
                    shardId,
    }
            .indexSort(config.getIndexSort())
                Engine.Operation.Origin.PRIMARY,
            1,
                    if (op instanceof Engine.NoOp == false && op.seqNo() > engine.getPersistedLocalCheckpoint()) {
                ? lastOpVersion + (randomBoolean() ? 1 : -1)
                        primarySeqNo++;
                2L,
            }
            InternalEngine engine = createEngine(
        try (Engine.GetResult getResult = engine.get(newGet(true, doc), searcherFactory)) {
                            newUid(idToDelete),
        List<Engine.Operation> ops = generateSingleDocHistory(true, VersionType.EXTERNAL, 1, 10, 1000, "1");
            UNASSIGNED_SEQ_NO,
            // If we already merged down to 1 segment, then the next force-merge will be a noop. We need to add an extra segment to make
                    deletes++;
        );
            Store store = createStore();
                    .currentFileGeneration();
                .field("foo1", contactAge)
        try (Store store = createStore()) {
                if (latestGetResult.get().exists() == false) {
                op.seqNo(),
        int numDocsOnReplica = 0;
            engine.flush();
            final long seqNo;
            assertThat(deferred.getTranslogLocation(), nullValue());
            indexResult.getSeqNo(),
            assertTrue(cleanupCompleted.await(10, TimeUnit.SECONDS));
        /* create a TranslogConfig that has been created with a different UUID */
            List<Segment> segments = engine.segments(randomBoolean());
import org.opensearch.common.lucene.uid.Versions;
                try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, operations.size() - 1, true, true)) {
        final Thread[] threads = new Thread[randomIntBetween(2, 4)];
                final ParsedDocument doc = testParsedDocument(docId, null, testDocumentWithTextField(), SOURCE, null);
            .build();
        try (Engine.GetResult get = engine.get(new Engine.Get(true, false, doc.id(), create.uid()), searcherFactory)) {
import java.util.concurrent.CountDownLatch;
    public void testSoftDeleteOnClosingEngine() throws Exception {
                        Engine.Operation.Origin.PRIMARY,
            engine.index(indexForDoc(doc));
            segments = engine.segments(false);
        assertVisibleCount(engine, numDocs, false);
            }
                    final Engine.Index index = new Engine.Index(
    ) {
                        )
            }
            "1",
        try {
                }
                UNASSIGNED_SEQ_NO,
                    store,
            IOUtils.close(replicaEngine);
            System.nanoTime(),
        engine.index(indexForDoc(doc));
            + ", expected:"
        IOUtils.close(engine, store);
        assertTrue(latestGetResult.get().exists());
                        primaryTerm.get(),
                .startObject("_doc")
            if (create) {
                public void onFailedEngine(String reason, Exception e) {
        final Set<String> liveDocs = new HashSet<>();
                0
            try {
        try (Store store = createStore(); Engine engine = createEngine(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE)) {
                    indexSettings.getTranslogRetentionSize().getBytes(),
        if (randomBoolean()) {
    }
                new NoneCircuitBreakerService()
                    // this will reduce pressure on disks and will allow threads to make progress without piling up too many commits
                    } catch (Exception e) {
                        @Override
            assertThat(snapshot.totalOperations(), equalTo(operations.size()));
            final BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory = engine::acquireSearcher;
                assertThat(translog.getMinGenerationForSeqNo(3 * i + 1).translogFileGeneration, equalTo(i + generation));
                config(defaultSettings, store, createTempDir(), newMergePolicy(), null, new ReferenceManager.RefreshListener() {
        assertFalse(indexResult.isCreated());
            MockDirectoryWrapper wrapper = newMockDirectory();
    }
            new BytesArray("{}".getBytes(Charset.defaultCharset())),
    }
            delete.id(),
            if (committed) {
            searcher.search(new MatchAllDocsQuery(), collector);
        }
            );
                    indexSettings.getTranslogRetentionAge(),
            final Engine.Delete delete = new Engine.Delete(
            null,
            Thread.sleep(1000);
        try (
            engine.translogManager().syncTranslog();
        engine.refresh("test");
            .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false);
 * under the License.
            assertEquals(1, topDocs.totalHits.value());
                    // Verify we got all documents
                // Compute the expected total: sum of the actual on-disk lengths of every file
            final Engine.Index originalIndex;
                }
            }
                            engine.config().getPrimaryTermSupplier().getAsLong(),
                engine.ensureOpen();
        try (Store store = createStore(wrapper)) {
        try (
            UNASSIGNED_SEQ_NO,
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                System.nanoTime(),
        Engine.Delete withoutRouting = engine.prepareDelete(
                    String idToUpdate;
    }
        assertThat(
            engine.refresh("test");
            final long primaryTerm;
    public void testMergeSegmentsOnCommit() throws Exception {
        }
        final DocumentMapper documentMapper = mapperService.documentMapper();
                    groupingCriteria = "grouping_criteria3";
                System.nanoTime(),
                    ParsedDocument doc = testParsedDocument(
     * second is the primary term.
        assertTrue(indexResult.isCreated());
                        0
        assertThat(indexResult.getVersion(), equalTo(1L));
        Engine.Index secondIndexRequestReplica = new Engine.Index(
                assertNotNull(retryResult.getTranslogLocation());
            final ShardRouting primary = TestShardRouting.newShardRouting(
                return throwingIndexWriter.get();
import java.util.LinkedHashMap;
            assertTrue(retryResult.getTranslogLocation().compareTo(indexResult.getTranslogLocation()) < 0);
        final List<Engine.Operation> operations = generateSingleDocHistory(
                assertTrue(searcher.getDirectoryReader().isCurrent());
                UNASSIGNED_SEQ_NO,
            for (int i = 0; i < numDocs; i++) {
        final Deque<Throwable> work = new ArrayDeque<>();
            engine = createEngine(store, primaryTranslogDir, inSyncGlobalCheckpointSupplier);
                engine.refresh("test");
                    // Verify we got all operations
            )
        IOUtils.close(engine, store);
                            start.await();
            try (InternalEngine engine = createEngine(null, null, null, config)) {
            );
import static org.opensearch.index.codec.CriteriaBasedCodec.BUCKET_NAME;
                            Engine.Operation.Origin.REPLICA,
                engine.refresh("gc_simulation", Engine.SearcherScope.INTERNAL, true);
        for (String file : committedFiles) {
            testDocumentWithTextField("test"),
                    assertEquals(2, assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().currentFileGeneration());
                createDocumentWithNestedField("1", "Alice", 30),
                }
            }
            assertThat(engine.failedEngine.get(), instanceOf(IllegalArgumentException.class));
            assertLuceneOperations(engine, 1, 0, 0);
        final CountDownLatch cleanupCompleted = new CountDownLatch(1);
                if (rarely() && indexedIds.isEmpty() == false) {
                }
                        null,
            assertEquals(timestamp1, engine.segmentsStats(false, false).getMaxUnsafeAutoIdTimestamp());
                    translogDir,
                    try {
            "1",
                                    StoredFields storedFields = get.docIdAndVersion().reader.storedFields();
                    } else {
    }
        final IndexSettings indexSettings = new IndexSettings(
        );
    }
        syncFlush(indexWriterHolder.get(), engine, syncId);
        }
        }
    private static class MockAppender extends AbstractAppender {
            engine.refresh("test");
                ) {
            defaultSettings,
        final boolean omitSourceAllTheTime = randomBoolean();
        }
        try (GatedCloseable<SegmentInfos> snapshot = engine.getSegmentInfosSnapshot()) {
                .store(store)
                    Engine.Index index = new Engine.Index(
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(1));
                }
    /*
            false,
            VersionType.INTERNAL,
                        doc,
        when(mapperService.fieldType(IdFieldMapper.NAME)).thenReturn(idFieldType);
            } else {
            .put(defaultSettings.getSettings())
                        doc,
        engine.close();
            final ParsedDocument doc1 = testParsedDocument("1", null, testContextSpecificDocument("grouping_criteria"), B_1, null);
                            testParsedDocument(
                        assertEquals(
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), randomFrom("-1", "512b", "1gb"))
                } catch (InterruptedException e) {
                    newForceMergePolicy(),
                }
                engine.onSettingsChanged(
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test1")), 0)
                assertTrue(searcher.getDirectoryReader().isCurrent());
            // IndexWriter can throw either IOException or IllegalStateException depending on whether tragedy is set or not.
            assertThat(engine.getLastSyncedGlobalCheckpoint(), equalTo(globalCheckpoint.get()));
            }
        }
            () -> SequenceNumbers.NO_OPS_PERFORMED,
        }
                            Engine.Operation.Origin.PRIMARY,
                    }
                        if (throwErrorOnCommit.get()) {
                    eventListener,
                config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get)
    }
                        result = engine.delete(delWithVersion.apply(conflictingVersion, delete));
            engine.index(indexForDoc(doc3));
            null,
                // disable merges to make sure that the reader doesn't change unexpectedly during the test
                        throw new AssertionError(ex);
            }
        final BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory = engine::acquireSearcher;
        try (Engine.Searcher searcher = batchEngine.acquireSearcher("test")) {
        Engine.Index create = new Engine.Index(
     */
                    }
import java.util.concurrent.TimeUnit;
            assertEquals(1, topDocs.totalHits.value());
            assertThat(
            ParsedDocument doc3 = testParsedDocument("2", null, testContextSpecificDocument("grouping_criteria_update"), B_1, null);
            EngineConfig engineConfig = createEngineConfigWithMapperSupplierForDerivedSource(store, true);
            gcpTracker.initiateTracking(initializingReplica.allocationId().getId());
                }
                    );
            assertThat(operations, hasSize(numOps));
                    engine.index(indexForDoc(testParsedDocument(UUIDs.randomBase64UUID(), null, testDocument(), B_1, null)));
                config(
        MatcherAssert.assertThat(
            );
            randomFrom(VersionType.INTERNAL, VersionType.EXTERNAL, VersionType.EXTERNAL_GTE),
            } else {
        barrier.await(); // wait for indexing threads to all be ready to start
            "2",
        // directory) against the actual total reported by segmentsStats.
        int randomId = randomIntBetween(numDocs + 1, numDocs + 10);
 */
            engine.flush();
    }
                    fail();
                refreshListener,
            final Translog.NoOp noOp = (Translog.NoOp) last;
         * to another writer.
            newUid(doc),
                translog.rollGeneration();
            InternalEngine engine = createEngine(
                                    )
            recoveringEngine = new InternalEngine(initialEngine.config());
                }
                            throw new AssertionError(e);
        }
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 0)
        final List<String> engineFailureReasons = new CopyOnWriteArrayList<>();
     * The drained append is a TRAGIC translog failure: the refresh completes (no deadlock) and throws an
                engine.refresh("test");
        // but, not there non realtime
                newMergePolicy(),
            false,
            REPLICA,
                }
        final Function<Store, EngineConfig> configSupplier = store -> config(
                assertTrue(engine.isClosed.get());
import org.opensearch.index.translog.TranslogException;
                                    );
    public void testSegments() throws Exception {
        final AtomicReference<RetentionLeases> retentionLeasesHolder = new AtomicReference<>(
            try (
                    logger.trace("exception on open", e);
                    assertThat(versionValue, instanceOf(DeleteVersionValue.class));
        indexing.join();
            // Cleanup count will not be incremented whenever there is some issue with cleanup.
        assertThat(indexReplicaResult.getVersion(), equalTo(1L));
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(0L));
        if (lastFieldValueDoc1 != null) {
                    Long.parseLong(commits.get(i).getUserData().get(SequenceNumbers.MAX_SEQ_NO)),
            actualEngine = createEngine(
        }
                    engine.index(indexForDoc(createParsedDoc("more-" + i, null)));
            maxSeq,
    // #5891: make sure IndexWriter's infoStream output is
    public void testNewChangesSnapshotWithDerivedSource() throws IOException {
        engine.index(indexWithoutThrottlingCheck);
                    Engine.Index index = new Engine.Index(
                            i + numDocs,
            if (rarely()) {
        assertTrue(engine.maybeRefresh("schedule"));
import java.util.Set;
        }
            engine.refresh("test");
        assertThat(seqID.v1(), equalTo(UNASSIGNED_SEQ_NO));
        final AtomicInteger counter = new AtomicInteger();
        };
        Engine.Index op = indexForDoc(doc);
                    assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
                        assertThat(
            doc2 = testParsedDocument("2", null, testContextSpecificDocument("grouping_criteria"), B_1, null);
                    IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        // its not updated yet...
                    }
                if (randomBoolean()) {
            }
    public void testForceMergeWithSoftDeletesRetentionAndRecoverySource() throws Exception {
                } catch (Exception e) {
                        testContextSpecificDocument("grouping_criteria"),
                    ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
            Path translogPath = createTempDir();
            )
        );
        assertThat(update_2_result.getVersion(), equalTo(3L));
        try (InternalEngine recoveringEngine = new InternalEngine(initialEngine.config())) {
            }
        } catch (IOException e) {
        List<OpAndVersion> sortedHistory = new ArrayList<>(history);
                }
        );
                sb.append(indent).append("  suppressed: ").append(s.getClass().getName()).append(": ").append(s.getMessage()).append('\n');
                        ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
            refreshThreads[i] = new Thread(() -> {
            )
        try (Store store = createStore(); Engine engine = createEngine(defaultSettings, store, createTempDir(), new TieredMergePolicy())) {
                newUid(doc),
                    .build()
                        assertThat(snapshot, SnapshotMatchers.containsSeqNoRange(localCheckpointFromSafeCommit + 1, docId));
                    shardId,
                try {
            index.getAutoGeneratedIdTimestamp(),
                    0,
            segments = engine.segments(false);
    public void testShardFailsForCompositeIndexWriterInCaseAddIndexesThrewExceptionWithAppend() throws IOException, InterruptedException {
            )
        doReturn(true).when(batchEngine).isTranslogBatchingEligible();
                IOUtils.close(engine, store);
        long checkpointOnReplica;
                        barrier.await(); // wait for all threads to start at the same time
                assertThat(DirectoryReader.listCommits(store.directory()), equalTo(commits));
                        testDocumentWithTextField(),
            final InternalEngine batchEngine = spy(realEngine);
        engine = new InternalEngine(config);
            engine.refresh("test", Engine.SearcherScope.EXTERNAL, true);
     */
                ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), B_1, null);
            System.nanoTime(),
                    String idToUpdate;
    }
        Iterator<Engine.Operation> iter1 = opsDoc1.iterator();
                .build()
        }
            try {
        try {
            result.getSeqNo(),
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        final CountDownLatch cleanupCompleted = new CountDownLatch(1);
            } else {
            System.nanoTime(),
                } else {
                thread.join();
        int opsPerformed = 0;
            try (InternalEngine engine = createEngine(indexSettings, store, createTempDir(), NoMergePolicy.INSTANCE, (directory, iwc) -> {
                            userData.get(Translog.TRANSLOG_UUID_KEY)
            null,
            }
        assertVisibleCount(engine, numDocs);
        );
            public void eval(MockDirectoryWrapper dir) throws IOException {
                work.push(current.getCause());
                long upToSeqNo = randomLongBetween(globalCheckpoint.get(), maxSeqNo);
                assertThat(currentSeqNo, equalTo(finalReplicaSeqNo + opsOnPrimary));
                try {
        EngineConfig brokenConfig = new EngineConfig.Builder().shardId(shardId)
            newUid(doc),
                liveDocsFirstSegment.remove(idToUpdate);
    /**
            engine.index(indexForDoc(doc));
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test1")), 0)
        });
            final boolean flushFirst = randomBoolean();
                    final Engine.Operation op = deletesAfterCheckpoint.get(uid);
                 * This sequence number landed in the last generation, but the lower and upper bounds for an earlier generation straddle
                    null,
        try {
                Long.parseLong(commits.get(0).getUserData().get(SequenceNumbers.MAX_SEQ_NO)),
            final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> engine.noOp(op));
            assertThat(segments.get(0).getNumDocs(), equalTo(numDocsFirstSegment + appends - deletes));
                assertThat(collector.getTotalHits(), equalTo(1));
            final Field versionField = new NumericDocValuesField("_version", 0);
                            userData.get(Translog.TRANSLOG_UUID_KEY)
            assertTrue(retryResult.getTranslogLocation().compareTo(indexResult.getTranslogLocation()) > 0);
                throwingIndexWriter.set(new AddIndexesFailingIndexWriter(directory, iwc));
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
import org.opensearch.threadpool.ThreadPool;
        List<LeafReaderContext> rightLeaves = OpenSearchDirectoryReader.unwrap(right.getDirectoryReader()).leaves();
            expectThrowsAnyOf(
                        store.close();
                        newUid(doc),
        // Index the same document again
                "NRT SegmentInfos should carry the last-committed history UUID",
        try (
                        assertThat(operation.seqNo(), equalTo((long) count));
            assertNotNull(retryResult.getTranslogLocation());
        }
                    false,
                .startObject("properties")
        }
            assertTrue(mockAppender.sawIndexWriterIFDMessage);
        final Settings.Builder settings = Settings.builder().put(defaultSettings.getSettings()).put("index.refresh_interval", "300s");
        // Setup with derived source enabled
    public void testTranslogCleanUpPostCommitCrash() throws Exception {
                startGun.countDown();
            if (op instanceof Engine.Index) {
                    null,
                    throw new AssertionError(e);
                Engine.IndexResult indexResult = engine.index(operation);
            searchResult,
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(1));
        store = createStore();
        assertTrue("safe access should be required", engine.isSafeAccessRequired());
            List<Engine.Operation> operations = new ArrayList<>(numDocs);
        engine.index(operation);
            300,
        class OpAndVersion {
            }
            engine.index(indexForDoc(doc));
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(maxSeqNo));
            assertLuceneOperations(engine, 1, 0, 0);
        final MergePolicy keepSoftDeleteDocsMP = new SoftDeletesRetentionMergePolicy(
        MatcherAssert.assertThat(
                VersionType.INTERNAL,
        final CountDownLatch engineClosed = new CountDownLatch(1);
            Randomness.shuffle(seqNos);
        final long retainedExtraOps = randomLongBetween(0, 10);
import org.opensearch.index.CriteriaBasedMergePolicy;
            120,
        final Path badTranslogLog = createTempDir();
            assertEquals(NO_OPS_PERFORMED, engine.getMaxSeqNoFromSearcher(searcher));
            Math.max(retry.seqNo(), operation.seqNo()) + 1,
                throwingIndexWriter.set(new AddIndexesFailingIndexWriter(directory, iwc));
        engine.refresh("test");
            );
                }
        Set<Long> seqNos = operations.stream().map(Engine.Operation::seqNo).collect(Collectors.toSet());
                new IndexShardRoutingTable.Builder(shardId).addShard(primary).build()
            })) {
            .store(store)
            PRIMARY,
            armedFailure.set(null);
    public void testSeqNoAndCheckpoints() throws IOException, InterruptedException {
                                    Engine.GetResult get = engine.get(
            "1",
            assertThat(noOp.seqNo(), equalTo((long) (maxSeqNo + 2)));
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
            engine.delete(delete);
        MatcherAssert.assertThat(
            for (int i = 0; i < numOps; i++) {
                defaultSettings,
                        engine.delete(delete);
    public void testVersioningNewCreate() throws IOException {
        if (randomBoolean()) {
                engine.index(indexForDoc(doc1));
        final int localCheckpoint = randomIntBetween(0, maxSeqNo);
                        )
        assertTrue("engine must be closed", batchEngine.isClosed.get());
            public void eval(MockDirectoryWrapper dir) throws IOException {
            if (create) {
                    assertThat(result.getFailure().getStackTrace(), emptyArray());
            //
    public void testGetMaxSeqNoRefreshedWithoutRefresh() throws IOException {
        document.add(new TextField("value", "test1", Field.Store.YES));
                }
import org.apache.lucene.index.FilterDirectoryReader;
        document.add(new Field(SourceFieldMapper.NAME, BytesReference.toBytes(B_1), SourceFieldMapper.Defaults.FIELD_TYPE));
        final Settings.Builder settings = Settings.builder()
                    updates++;
                for (int t = 0; t < getters.length; t++) {
        if (leaves.isEmpty()) {
                        exception.set(e);
            document.add(versionField);
                while ((docOffset = offset.incrementAndGet()) < docs.size()) {
            assertThat(segments, hasSize(2));
                final String translogUUID = Translog.createEmptyTranslog(
        );
                liveDocsFirstSegment.add(id);
                engine.index(indexForDoc(doc));
            autoGeneratedIdTimestamp,
                final Engine.Delete delete = (Engine.Delete) op;
        InternalEngine engine = createEngine(indexSettings, store, createTempDir(), newMergePolicy());
        TranslogConfig translogConfig = new TranslogConfig(
            List<Engine.Operation> operations = generateHistoryOnReplica(numDocs, randomBoolean(), randomBoolean(), randomBoolean());
                }
            assertEquals(0, searcher.getIndexReader().numDocs());
                // Test snapshot with specific range
            );
                final int refreshCountBeforeGet = refreshCount.get();
            }
        try (Engine.Searcher test = this.engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
        final long newPrimaryTerm = randomLongBetween(0L, primaryTerm.get());
    public void testRestoreLocalHistoryFromTranslog() throws IOException {
            }
                        engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            assertThat(snapshot.totalOperations(), equalTo(operations.size()));
            assertThat(error.getMessage(), containsString("number of documents in the index cannot exceed " + maxDocs));
            Engine e = createEngine(
                try {
            }
                        // there are 4 files (*cfs, *cfe, *si and segments_*).
            if (create) {
                    id = Integer.toString(randomInt(numDocs));
            empty()
     */
        final boolean create = randomBoolean();
        final long term = this.primaryTerm.get();
                if (fileName.endsWith(".cfs")) {
                    // Verify we got all operations
import org.apache.lucene.util.Bits;
        }
                try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
                thread.join();
                engine.index(indexForDoc(doc));
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
    public void testRefreshDoesNotBlockClosing() throws Exception {
            try (InternalEngine engine = createEngine(engineConfig)) {
                    }
            final AtomicLong retentionLeasesVersion = new AtomicLong();
                    seqNo++;
        }
        final AtomicLong sequenceNumber = new AtomicLong();
        MatcherAssert.assertThat(
                @Override
                new BytesArray("{}".getBytes(Charset.defaultCharset())),
            index.origin(),
            globalCheckpoint.set(localCheckpoint);
                }
                );
            Versions.MATCH_ANY,
                    if (rarely()) {
            ParsedDocument doc2 = testParsedDocument("2", null, testDocumentWithTextField(), B_2, null);
    }
        final String lastFieldValue;
                    assertThat(result.getFailure(), nullValue());
                    assertVisibleCount(engine, numDocs, false);
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
        private void maybeThrowFailure() throws IOException {
            }
                    engine.index(indexForDoc(testParsedDocument(UUIDs.randomBase64UUID(), null, testDocument(), B_1, null)));
        assertTrue(
            maxSeqNo.set(rarely() ? SequenceNumbers.NO_OPS_PERFORMED : randomIntBetween(0, 1024));
            assertNotNull(retryResult.getTranslogLocation());
                LeafReaderContext leafReaderContext = reader.leaves().get(0);
        searchResult.close();
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
            assertThat(
        assertThat(second.getTranslogLocation(), notNullValue());
            for (Thread thread : indexingThreads) {
        ParsedDocument doc = testParsedDocument("1", null, document, B_1, null);
            Store store = createStore();
                    }
        expectThrows(
            doReturn(true).when(batchEngine).isTranslogBatchingEligible();
            latch.countDown();
                0
            segments = engine.segments(true);
                        }
                    } else {
                );
            final long conflictingVersion = docDeleted || randomBoolean()
                    if (randomInt(100) < 10) {
            0
                            engine.countNumberOfHistoryOperations("test", min, max);
                }
        for (Engine.Operation op : operations) {
            final List<Segment> segments = engine.segments(false);
        // the non release search result should not see the deleted yet...
                } catch (AlreadyClosedException e) {
        Set<String> deletedDocs = new HashSet<>();
     * segment, including multiple files that share the same extension.
            assertFalse(segments.get(0).committed);
     * the processed checkpoint has advanced, and the operation is durably present in the translog.
    }
            // original files are preserved.
            )
        private AtomicReference<Supplier<Exception>> failureToThrow = new AtomicReference<>();
                    });
                        indexedIds.remove(id);
            }
                newMergePolicy(),
        assertVisibleCount(engine, totalExpectedOps);
                // simulate GC deletes
        assertEquals(0, engine.getNumIndexVersionsLookups());
        // The cap forced an append on the MAX_OPERATIONS-th add, so every result already has a location and the
            () -> globalCheckpoint.get()
     * Verifies the accounting inside {@code updateUncommittedSegmentBytes}: only segment files absent from the last
            }
            final String translogUUID = Translog.createEmptyTranslog(translogPath, globalCheckpoint.get(), shardId, primaryTerm.get());
                            randomNonNegativeLong(),
                    expectedTotal,
                "NRT SegmentInfos should carry the last-committed local checkpoint",
        }
            final CyclicBarrier barrier = new CyclicBarrier(2);
                indexed.await();
        };
        }
        long uncommittedBytes = 0;
        AtomicBoolean done = new AtomicBoolean(false);
                    null
                    break;
                    try {
                phaser.arriveAndAwaitAdvance();
        assertThat(batchEngine.getProcessedLocalCheckpoint(), equalTo(0L));
                        + " vs "
            assertThat(noOpEngine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(gapsFilled + 1));
            final TranslogConfig translogConfig = new TranslogConfig(
        assertThat(second.getTranslogLocation(), notNullValue());
        commits.add(new ArrayList<>());
                } catch (RefreshFailedEngineException ex) {
        }
        engine.refresh("test");
                final ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), SOURCE, null);
            randomIntBetween(1, 100),
            Store store = createStore(idxSettings, wrapper);
        engine = createEngine(store, primaryTranslogDir, inSyncGlobalCheckpointSupplier);
                        if (operation instanceof Translog.Index) {
     *
        }
                            }
                }
            FailingBatchAppendTranslog.FailureClass.NON_TRAGIC
                        UNASSIGNED_SEQ_NO,
            searchResult,
    ) throws Exception {
        try (Store store = createStore()) {
    @LockFeatureFlag(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG)
            result.getVersion(),
                            .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), TimeValue.timeValueMillis(1))
        assertTrue(doneLatch.await(10, TimeUnit.SECONDS));
        try (InternalEngine engine = createEngine(defaultSettings, store, createTempDir(), policy)) {
                    );
        updateSearchResult.close();
            final long deleteBatch = between(10, 20);
        assertThat(result.getTranslogLocation(), notNullValue());
            engine.onSettingsChanged(
     * A delete is written inline. When the same thread still holds a pending index of that document in its batch,
            );
            assertThat(engine.shouldPeriodicallyFlush(), equalTo(true));
        engine.refresh("test");
        CountDownLatch startGun = new CountDownLatch(thread.length);
                "node1",
                nrtUserData.get(Engine.HISTORY_UUID_KEY)
                    Long.parseLong(engine.getLastCommittedSegmentInfos().userData.get(Engine.MIN_RETAINED_SEQNO)),
                    new Engine.Index(
    public void testConcurrentAppendUpdateAndRefresh() throws InterruptedException, IOException {
        MatcherAssert.assertThat(
            Store store = createStore();
        }
            .indexSettings(indexSettings)
            if (rarely() || engine.shouldPeriodicallyFlush()) {
            assertThat(segments.size(), equalTo(1));
                            .filter(file -> file.equals("write.lock") == false && ExtrasFS.isExtra(file) == false)
        assertThat(engine.getLastCommittedSegmentInfos(), not(sameInstance(lastCommitInfo)));
        searchResult.close();
            new BytesArray("{}".getBytes(Charset.defaultCharset())),
        IndexWriterFactory indexWriterFactory = (dir, iwc) -> new IndexWriter(dir, iwc) {
            final ParsedDocument doc2 = testParsedDocument("2", null, testContextSpecificDocument("grouping_criteria"), B_1, null);
                            case "optimize": {
                        UNASSIGNED_SEQ_NO,
            Engine.IndexResult indexResult = engine.index(operation);
        assertThat(batchEngine.getProcessedLocalCheckpoint(), equalTo(NO_OPS_PERFORMED));
                newMergePolicy(),
            List<Segment> segments = engine.segments(true);
        final long globalCheckpoint;
            }
                        Integer.toString(i),
                    } catch (IOException e) {
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("test", indexSettings);
        assertThat(
        engine.refresh("test");
                    try (Translog.Snapshot snapshot = getTranslog(engine).newSnapshot()) {
            } finally {
            final Engine.Result result;
                    ) {
                }
                Arrays.asList(IOException.class, IllegalStateException.class),
                    }
                    .build();
                        null,
                refreshStarted.countDown();
    private static class ThrowingIndexWriter extends IndexWriter {
        try (Store store = createStore(); Engine engine = createEngine(indexSettings, store, createTempDir(), new TieredMergePolicy())) {
                UNASSIGNED_SEQ_NO,
        latestGetResult.set(engine.get(newGet(true, doc), searcherFactory));
            try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
        Document document = testDocumentWithTextField();
        try (Store store = createStore(); Engine engine = createEngine(defaultSettings, store, createTempDir(), new TieredMergePolicy())) {
            get.docIdAndVersion().reader.storedFields().document(get.docIdAndVersion().docId, visitor);
                op.primaryTerm()
import org.apache.lucene.index.SoftDeletesRetentionMergePolicy;
        Engine.TranslogBatch batch = batchEngine.beginTranslogBatch();
                        0,
                    assertEquals(createdVersion.luceneVersion.major, leafReader.getMetaData().createdVersionMajor());
            }
            System.nanoTime(),
                doc,
                } catch (EngineCreationFailureException | IOException ex) {
            engine.index(index);
        for (int i = 0; i < leaves.size(); i++) {
                }
                    new NoneCircuitBreakerService(),
                committedUserData.get(Translog.TRANSLOG_UUID_KEY),
            CommitStats stats1 = engine.commitStats();
                }
     * @param stall                   whether or not the thread should stall
                Integer.toString(i),
        @Override
                        String added = "v_" + idGenerator.incrementAndGet();
            // since we rollback the IW we are writing the same segment files again after starting IW but MDW prevents
        searchResult = engine.acquireSearcher("test");
                        }
            engine.flush();
        );
                }
        final boolean create = randomBoolean();
                    assertThat(highestSeqNo, greaterThanOrEqualTo(localCheckpoint));
    }
                        result = engine.index(indexWithVersion.apply(conflictingVersion, index));
        return appendOnlyPrimary(doc, retry, autoGeneratedIdTimestamp, randomBoolean());
            assertEquals(maxSeqIDOnReplica, recoveringEngine.getSeqNoStats(-1).getMaxSeqNo());
                    String docID = Integer.toString(j);
        }
 * the Apache License, Version 2.0 (the "License"); you may
            globalCheckpoint.set(randomLongBetween(0, engine.getPersistedLocalCheckpoint()));
            }
                        // this is a hack to add a failure during store document which triggers a tragic event
            }
        );
            Engine engine = createEngine(indexSettings, store, createTempDir(), newCriteriaBasedMergePolicy(), null, null, null, null, null)
                    "file_sizes total must equal the actual sum of all segment file sizes; "
                            Long.parseLong(safeCommit.getUserData().get(SequenceNumbers.MAX_SEQ_NO)),
                        )
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    }
                barrier.await();
        try (GatedCloseable<SegmentInfos> segmentInfosGatedCloseable = engine.getSegmentInfosSnapshot()) {
            if (randomBoolean()) {
        }
        );
    }
        engine.flush(true, true);
            assertThat(segments.size(), equalTo(1));
                    globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
                ParsedDocument doc = testParsedDocument(idToUpdate, null, testDocument(), B_1, null);
            UNASSIGNED_SEQ_NO,
                exists.set(get.exists());
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
        engine.index(indexForDoc(createParsedDoc("3", null)));
        final long maxSeqNo = randomLongBetween(10, 50);
        store = createStore();
        engine.ensureOpen();
                    engine.index(indexForDoc(doc));
        int numOps = between(10, 100);
                            engine.index(docs.get(docOffset));
            .translogConfig(translogConfig)
        );
                    assertThat(result.getFailure(), instanceOf(VersionConflictEngineException.class));
                    barrier.await();
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
    public void testClearUncommittedSegmentBytesDisarmsFlushCondition() throws Exception {
            logger.info(
            new Engine.Get(false, false, lastReplicaOp.uid().text(), lastReplicaOp.uid())
                    );
        indexedDocs.acquire(randomIntBetween(1, 100));
                VersionType.INTERNAL,
                }
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            engine.close();
                    try (InternalEngine engine = new InternalEngine(config)) {
                if (randomBoolean()) {
        );
            InternalEngine engine = createEngine(
                        0,
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
        engine.translogManager().trimOperationsFromTranslog(primaryTerm.get(), NO_OPS_PERFORMED); // trim everything in translog
                            primaryTerm.get(),
        assertThat(indexed.getTranslogLocation(), notNullValue());
            ) {
    public void testIndexThrottling() throws Exception {
            for (int i = 0; i < docs; i++) {
            List<Segment> segments = engine.segments(false);
    }
                .recoverFromTranslog(translogHandler, recoveringEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                    } else {
            "test",
            }
                    Engine.IndexResult indexResult = engine.index(firstIndexRequest);
            for (Throwable s : current.getSuppressed()) {
                } catch (RefreshFailedEngineException ex) {
     * Create a store where directory is closed when referenced while unreferenced file cleanup.
                engine.flush();
            index.getIfSeqNo(),
        AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            } finally {
        );
                for (int i = 0; i < numDocsToUpdate; i++) {
                    );
                }
            null,
            };
                TranslogHandler translogHandler = createTranslogHandler(engineConfig.getIndexSettings(), engine);
            localFiles = Set.of(store.directory().listAll());
            }
        );
            Settings.builder()
                UNASSIGNED_SEQ_NO,
                    Translog.Operation op = ops.get(seqno);
                "routing",
        for (int i = 0; i < sortedHistory.size(); i++) {
    }
        assertThat(batch, not(sameInstance(Engine.NO_OP_TRANSLOG_BATCH)));
        if (lastOpDoc2 instanceof Engine.Index) {
            index.parsedDoc(),
        int numIters = randomIntBetween(2, 10);
        MockDirectoryWrapper wrapper = newMockDirectory();
            while (flushFinished.get() == false) {
                    checker.run();
            ParsedDocument doc2 = testParsedDocument("2", null, testContextSpecificDocument("grouping_criteria"), B_1, null);
        // delete, refresh and do a new search, it should not be there
                assertThat("duplicate version", op.version, not(equalTo(sortedHistory.get(i - 1).version)));
            .threadPool(threadPool)
            index.startTime(),
                assertEquals(numDocs, leafReader.maxDoc());
        EngineConfig config = engine.config();
            UNASSIGNED_SEQ_NO,
            Settings.builder()
    public void testBeginTranslogBatchOnClosedEngineThrowsAlreadyClosed() throws Exception {
                                    new Engine.Get(true, false, docId, newUid(docId)),
                    engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
import static org.mockito.Mockito.spy;
            -1,
            assertThat(segments.size(), equalTo(1));
            index.uid(),
    }
                        newUid(doc),
import org.opensearch.index.translog.SnapshotMatchers;
    public void testFlushIsDisabledDuringTranslogRecovery() throws IOException {
        Engine.IndexResult indexResult = engine.index(create);
                null
                null,
    }
                } catch (IOException e) {
            assertThat(segments.get(1).getDeletedDocs(), equalTo(deletes)); // delete tombstones
                    engine.index((Engine.Index) op);
                try {
                engine.translogManager().syncTranslog();
        try (Store store = createStore()) {
            engine.refresh("test", Engine.SearcherScope.EXTERNAL, true);
        engine.refresh("test");
                equalTo(globalCheckpoint)
        }
                    liveDocsWithSource.add(doc.id());
                    }
     * the drained append fails with {@code failure}, either tragically (translog records it and closes) or not. The
            int numDocs = randomIntBetween(10, 100);
    /**
import org.opensearch.cluster.routing.ShardRouting;
                    }
            int numDocs = between(maxDocs + 1, maxDocs * 2);
    }
    }
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
            }
            }
            }
            }
                        engine.close();
                String id = Integer.toString(i);
                System.nanoTime(),
                        0
    }
                        "seq_no=" + op.seqNo() + " max_seq_no=" + tracker.getMaxSeqNo() + "checkpoint=" + tracker.getProcessedCheckpoint(),
                Versions.NOT_FOUND,
                0,
import org.opensearch.index.translog.TranslogConfig;
                    }
                store.associateIndexWithNewTranslog(translogUUID);
                    VersionType.INTERNAL,
                            final String id = "thread" + threadIdx + "#" + i;
        indexing.start();
                if (fileName.endsWith(".cfe")) {
                        primaryTerm.get(),
        }
                            if (updatedDocs.contains(docId)) {
                    engine.refresh("testing");
        for (final Engine.Operation operation : operations) {
        final CountDownLatch doneLatch = new CountDownLatch(numIndexingThreads);
            1,
                    ? UNASSIGNED_SEQ_NO
    public void testRetryWithAutogeneratedIdWorksAndNoDuplicateDocs() throws IOException {
                    1,
        );
            assertEquals(shardId, engine.config().getShardId());
        Engine.Index firstOp = indexForDoc(firstDoc);
                engine.config().getCircuitBreakerService()
        List<Engine.Operation> operations = generateHistoryOnReplica(between(1, 100), randomBoolean(), randomBoolean(), randomBoolean());
        SetOnce<IndexWriter> indexWriterHolder = new SetOnce<>();
                    eventListener,
                        if (randomBoolean()) {
        PrimaryTermSupplier currentTerm = (PrimaryTermSupplier) engine.engineConfig.getPrimaryTermSupplier();
        doReturn(true).when(batchEngine).isTranslogBatchingEligible();
        int numDocs = scaledRandomIntBetween(100, 1000);
            }
                );
        }
                latestGetResult.set(engine.get(newGet(true, doc), searcherFactory));
            }
                            }
    }
                testDocumentWithTextField(),
    }
            final long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
        List<Engine.Index> docs = new ArrayList<>();
                }
            latch.countDown();
    /**
                Engine.IndexResult indexResult = engine.index(primaryResponse);
                engine.engineConfig.setEnableGcDeletes(true);
import static org.hamcrest.Matchers.in;
                }
                createDocumentWithNestedField("1", "Alice", 30),
                    primaryTerm.get()
                    lastOpTerm = result.getTerm();
        try (
        final Engine.Operation lastOp = ops.get(ops.size() - 1);
        private AtomicReference<Supplier<Exception>> failureToThrow = new AtomicReference<>();
                }
                }
            EngineConfig config = config(this.engine.config(), store, createTempDir(), tombstoneDocSupplier);
                engine.index(primaryResponse);
            searchResult,
            );
                final long localCheckpoint = Long.parseLong(
        }
        engine.refresh("test");
                            result = engine.index(indexWithSeq.apply(lastOpSeqNo, lastOpTerm, index));
                        assertThat(initialEngine.getSeqNoStats(-1).getMaxSeqNo(), equalTo(primarySeqNo));
            if (rarely() && engine.translogManager().shouldRollTranslogGeneration()) {
            final Engine.Operation next = randomBoolean() ? iter1.next() : iter2.next();
        final List<Long> seqNos = LongStream.rangeClosed(0, maxSeqNo).boxed().collect(Collectors.toList());
        when(idFieldType.unwrap()).thenReturn(idFieldType);
            delete.uid(),
                final long currentTranslogGeneration = assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog()
        assertTrue(engine.isSafeAccessRequired());
        final AtomicLong localCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                assertNotEquals(segmentInfos.getSegmentsFileName(), snapshot.get().getSegmentsFileName());
            globalCheckpoint.set(1); // make sure flush cleans up commits for later.
            for (int i = 0; i < numDocs; i++) {
        }
        final IOException nonTragic = new IOException("simulated non-tragic batch append failure");
                if (liveDocIds.add(doc.id()) == false) {
                final String docId = Integer.toString(i);
        verify(mockCheckpointTracker, atLeastOnce()).getProcessedCheckpoint();
                final String id = Integer.toString(i);
                    applyOperation(engine, op);
                        VersionType.EXTERNAL,
                    }
        MatcherAssert.assertThat(
            100,
        );
                            }
        return bitSet;
        engine.translogManager().ensureCanFlush(); // recovered already
    public void testOutOfOrderSequenceNumbersWithVersionConflict() throws IOException {
            engine.flush();
        if (randomBoolean()) {
                        // Verify sequence numbers are in order
        }
            .globalCheckpointSupplier(() -> UNASSIGNED_SEQ_NO)
                thread.start();
                            newUid(idToDelete),
            assertThat(indexResult.getVersion(), equalTo(1L));
            assertThat(segments.size(), equalTo(2));
        assertFalse(engine.isSafeAccessRequired());
            }
            }
            .analyzer(config.getAnalyzer())
                        } catch (IOException e) {
                directory.setRandomIOExceptionRateOnOpen(0.0);
                            ParsedDocument doc = createParsedDoc(randomFrom(ids), null);
            assertThat(engine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(0));
import org.apache.lucene.store.AlreadyClosedException;
        try (InternalEngine engine = createEngine(store, createTempDir(), globalCheckpoint::get)) {
                    appends++;
            index.getIfPrimaryTerm()
                }
        final List<Engine.Operation> ops = generateSingleDocHistory(
        try {
                searcher.search(new TermQuery(new Term("value", lastFieldValueDoc2)), collector);
            ParsedDocument doc3 = testParsedDocument("3", null, testDocumentWithTextField(), B_3, null);
                sameInstance(tragic)
            })) {
                }
            expectThrows(
            )
                        assertThat(fileCount, equalTo(4L));
        engine.refresh("test");
        });
            System.nanoTime(),
            new RetentionLeases(primaryTerm, retentionLeasesVersion.get(), Collections.emptyList())
        seqID = getSequenceID(engine, newGet(false, doc));
                                    return;
            Engine.Operation.Origin.REPLICA,
            }
            ) {
            final ParsedDocument parsedDocument = new ParsedDocument(
            assertLuceneOperations(engine, 1, 0, 1);
                                try {
                }
                    AlreadyClosedException.class,
        try (GatedCloseable<SegmentInfos> segmentInfosGatedCloseable = engine.getSegmentInfosSnapshot()) {
                        @Override
                }
            randomFrom(VersionType.INTERNAL, VersionType.EXTERNAL),
                    if (ex.getCause() != null) {
        latch.await();
        MatcherAssert.assertThat(
                    if (randomInt(100) < 5) {
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), "true");
            };
        }
        assertThat(result.getVersion(), equalTo(2L));
            }
        final CountDownLatch refreshStarted = new CountDownLatch(1);
     */
        } else {
                /*
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
        );
                .endArray()
        engine.close();
        if (create || primary == false) {
                assertEquals(10, getSearcher.getIndexReader().numDocs());
            FieldsVisitor visitor = new FieldsVisitor(true);
            int count = 0;
                if (randomInt(10) < 3) {
        for (int i = 0; i < numOps; i++) {
                        assertSame(warmedUpReaders.get(1), externalSearcher.getDirectoryReader());
            segments = engine.segments(false);
                null,
        Engine.Index operation = appendOnlyReplica(doc, false, 1, randomIntBetween(0, 5));
    public void testNRTSegmentInfosCarriesLastCommittedUserData() throws Exception {
                        equalTo(Math.max(currentMaxSeqNoOfUpdates, result.getSeqNo()))
                    B_1,
                case DELETE:
        try (
        );
            engine.index(index);
            VersionType.INTERNAL,
                // same segment, guaranteeing multiple files per extension.
    public void testMissingTranslog() throws IOException {
import org.opensearch.test.DummyShardLock;
        try (Engine.Searcher searcher = replicaEngine.acquireSearcher("test")) {
        assertBusy(() -> {
        } finally {
                doc,
                );
        }
            // Try to index uid=2 with a too-old version, should fail:
        doReturn(true).when(batchEngine).isTranslogBatchingEligible();
                testDocumentWithTextField(),
                        engine.ensureOpen();
        engine.updateUncommittedSegmentBytes(localSegmentsSizeMap, 1L);
            searchResult,
            assertEquals(maxSeqIDOnReplica, recoveringEngine.getSeqNoStats(-1).getMaxSeqNo());
                    assertThat(engine.currentOngoingRefreshCheckpoint(), greaterThanOrEqualTo(engine.lastRefreshedCheckpoint()));
            );
                    final VersionValue versionValue = versionMap.get(uid);
            }
                        idToUpdate = Integer.toString(randomInt(numDocs - 1));
                result = engine.index((Engine.Index) op);
                            String docId = indexOp.id();
        engine.refresh("test");
            engine.translogManager().syncTranslog();
                versionedOp ? " (versioned " + correctVersion + ", seqNo " + lastOpSeqNo + ", term " + lastOpTerm + " )" : ""
            engine.onSettingsChanged(
        final int numDocs = randomIntBetween(1, 10);
            ParsedDocument doc = createParsedDoc(id, null);
            Translog.Operation op2 = snapshot.next();
                    }
    }
        assertVisibleCount(engine, numDocs);
import org.opensearch.common.CheckedRunnable;
            .warmer(null)
                    assertThat(msg, versionValue.seqNo, equalTo(op.seqNo()));
        // but, get should not see it (in realtime)
            assertThat(segments.get(0).committed, equalTo(committed));
            try (InternalEngine engine = createEngine(config)) {
        }
            // The batch owner is told, and its deferred result never got a location.
            }
        // don't release the search result yet...
                    1,
                    try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
    }
            )
                }
        try {
                                    engine::acquireSearcher
            engine.translogManager().syncTranslog(); // to advance local checkpoint
            final long correctVersion = docDeleted ? Versions.MATCH_DELETED : lastOpVersion;
                try (Engine.Searcher internalSearcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
            Engine.IndexResult index = engine.index(firstIndexRequest);
            assertThat(e.getMessage(), equalTo("fatal"));
                String idToUpdate = randomFrom(liveDocsFirstSegment);
        try (
    }
            for (int i = 0; i < numDocs; i++) {
            }
                        newUid(doc),
                shardId,
                .startObject("context_aware_grouping")
    public void testRefreshDrainOfTragicBatchAppendFailsEngineOnceWithTheTragicException() throws Exception {
                        wrapper.close();
                engine.refresh("test");
        List<List<Engine.Operation>> commits = new ArrayList<>();
                                continue;
            initialEngine = createEngine(
                        )
            }
                    }
        logger.info("exception caught: ", exception.get());
        assertThat(outcome.engineFailures.get(0), sameInstance(tragic));
            engine.flush(false, true);
    public void testIndexWriterInfoStream() throws IllegalAccessException, IOException {
         * "live" changes to this writer instance, use {@link #getConfig()}.
            engine.index(indexForDoc(doc));
            final Engine.DeleteResult deleteResult = e.delete(delete);
                    final NumericDocValues values = context.reader().getNumericDocValues(SeqNoFieldMapper.NAME);
                engine.refresh("test");
                    return maxSeqNo.get();
        assertThat(assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().currentFileGeneration(), equalTo(3L));
                                assertThat(getResult.docIdAndVersion(), notNullValue());
                    engine.index(indexForDoc(createParsedDoc(id, null)));
            "1",
        Engine.IndexResult indexResult = engine.index(index);
        replicaEngine.refresh("test");
                        assertThat(
    public void testGetMaxSeqNoFromSegmentInfosConcurrentWrites() throws IOException, BrokenBarrierException, InterruptedException {
                        false,
            } else {
            engine.flush();
        indexResult = engine.index(index);
                origin,
        // create a document
            seqNo,
                    try (Engine.Searcher externalSearcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)) {
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(0L));
        assertThat(result.getTranslogLocation(), nullValue());
                // Update some remaining documents.
            expectedLocalCheckpoint = count - 1;
                    try {
        assertThat("Not exceeded translog flush threshold yet", engine.shouldPeriodicallyFlush(), equalTo(false));
                    UNASSIGNED_SEQ_NO,
                assertEquals(
                        VersionType.EXTERNAL,
    public void testConcurrentGetAndSetOnPrimary() throws IOException, InterruptedException {
        assertThat(batchEngine.getProcessedLocalCheckpoint(), equalTo((long) (cap - 1)));
        final Settings.Builder settings = Settings.builder().put(defaultSettings.getSettings());
            IOUtils.close(initialEngine);
            recoveringEngine.translogManager()
                    );
        try (Store store = createStore()) {
     * holding only committed files computes zero bytes and can never trigger a flush.
                    if (lastSyncedGlobalCheckpointBeforeCommit.get() == UNASSIGNED_SEQ_NO) {
    }
            assertLuceneOperations(engine, 1, 0, 0);
            null,
                    if (randomBoolean()) {
                                "1",
                newUid(doc),
            );
            final NumericDocValues values = leaf.getNumericDocValues(SeqNoFieldMapper.NAME);
                writer.addDocument(doc);
            InternalEngine engine = createEngine(config(defaultSettings, store, createTempDir(), newMergePolicy(), null))
                seqNo = UNASSIGNED_SEQ_NO;
                    throw new IOException("No space left on device");
                    throwingIndexWriter.get().setThrowFailure(() -> new IllegalArgumentException("simulated max token length"));
        if (docDeleted == false) {
                VersionType.INTERNAL,
                }
        );
                        UNASSIGNED_SEQ_NO,
                if (bits == null || bits.get(docID)) {
            }
            uid,
            engine.refresh("test");
            for (String file : files) {
                    uid,
            Engine.Index index = indexForDoc(doc);
        }
            + ", expected:"
        ) {
            thread.join();
                .translogConfig(translogConfig)
            UNASSIGNED_SEQ_NO,
        assertTrue(indexResult.isCreated());
            TopDocs search = searcher.search(new MatchAllDocsQuery(), searcher.getIndexReader().numDocs());
            0
                            try (
                assertThat(indexResult.getSeqNo(), equalTo(1L));
        // fake a new translog, causing the engine to point to a missing one.
        }
            assertEquals(0, engine.getNumVersionLookups());
        }).when(indexWithThrottlingCheck).startTime();
            assertThat(getResult.exists(), equalTo(true));
                Engine.Searcher getSearcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
        assertThat(first.getTranslogLocation().compareTo(second.getTranslogLocation()), lessThan(0));
            "1"
        Engine.Searcher searchResult = engine.acquireSearcher("test");
                    Assert.fail();
        Engine.IndexResult update_2_result = engine.index(update_2);
                assertVisibleCount(engine, numDocs);
        );
                        // Safe to remove from file count along with write.lock without impacting the test.
        Thread[] thread = new Thread[randomIntBetween(3, 5)];
            }
        public long softUpdateDocument(Term term, Iterable<? extends IndexableField> doc, Field... softDeletes) throws IOException {
        Engine.TranslogBatch batch = batchEngine.beginTranslogBatch();
                            MatchAllDocsQuery::new,
            try (InternalEngine engine = createEngine(config)) {
                    barrier.await(); // wait for all threads to start at the same time
            newUid(doc),
                .analyzer(config.getAnalyzer())
    /**
        // The refresh drained the batch: the deferred op has a location and the checkpoint advanced before the doc
        InternalEngine engine = createEngine(indexSettings, store, createTempDir(), newMergePolicy());
                        Engine.IndexResult indexResult = engine.index(index);
                }
                                } catch (IOException e) {
                final Map<BytesRef, VersionValue> versionMap = engine.getVersionMap();
    }
                        UNASSIGNED_SEQ_NO,
        engine.ensureOpen();
                        false,
            null,
            true,
                    uncommittedBytes += length;
            final ParseContext.Document document = new ParseContext.Document();
            engine.config().getMergePolicy()
                phaser.arriveAndAwaitAdvance();
        }
                    IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
import org.hamcrest.Matchers;
                            UNASSIGNED_SEQ_NO,
        assertNotEquals(indexResult.getSeqNo(), UNASSIGNED_SEQ_NO);
                -1,
                seqID,
        MockDirectoryWrapper.Failure fail = new MockDirectoryWrapper.Failure() {
                if (failure instanceof RuntimeException) {
                    : randomIntBetween(0, 1024)
        Thread refresher = new Thread(() -> {
import org.apache.lucene.index.Terms;
        // Disable compound file so each Lucene file is a separate entry in the directory,
            List<Segment> segments = engine.segments(true);
            }
            Assert.assertTrue(cfeCompoundFileFound);
        final AtomicLong globalCheckpoint = new AtomicLong(UNASSIGNED_SEQ_NO);
            );
    public void testNewChangesSnapshotWithDeleteAndUpdateWithDerivedSourceAndContextAwareEnabled() throws IOException {
        DrainFailureOutcome(
        Engine.NoOpResult noOpResult = engine.noOp(
            final int numOps = randomIntBetween(0, 1024);
     * instead of leaving a pending location unresolved (which would hang a reader).
                    .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), TimeValue.timeValueMillis(gcInterval).getStringRep())
            primaryTranslogDir,
            }
        Engine.Index firstIndexRequest = new Engine.Index(
            }
        boolean inSync = randomBoolean();
            assertThat(() -> stats.getFileSizes().values().iterator(), everyItem(greaterThan(0L)));
                indexingThreads.add(indexingThread);
                engine.forceMerge(randomBoolean(), between(1, 10), randomBoolean(), false, false, UUIDs.randomBase64UUID());
            final List<DocIdSeqNoAndSource> docs;
                engine.refresh("test");
     * {@link org.opensearch.index.shard.IndexShard} never calls the engine directly; it goes through
                directory.setRandomIOExceptionRate(0.0);
                    lastOpVersion = result.getVersion();
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), globalCheckpoint.get());
                        + "id="
        // This is required for optimizations on SourceLookup to work, which is in-turn useful for runtime fields.
            assertThat(noOpEngine.getProcessedLocalCheckpoint(), equalTo((long) (maxSeqNo + 2)));
                }
                }, null, () -> SequenceNumbers.NO_OPS_PERFORMED, new NoneCircuitBreakerService())
        try (GatedCloseable<IndexCommit> commit = engine.acquireLastIndexCommit(false)) {
            AtomicReference<ThrowingIndexWriter> throwingIndexWriter = new AtomicReference<>();
            }
                        assertThat(fileCount, equalTo(4L));
            segments = engine.segments(false);
    /**
import org.apache.lucene.tests.index.ForceMergePolicy;
            assertThat(engine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(0));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 0)
                    Engine.Index index = new Engine.Index(
            assertThat(segments.get(0).getSegmentSort(), equalTo(indexSort));
        assertThat(finishLocation, equalTo(indexed.getTranslogLocation()));
        assertThat("A fresh publication re-arms it", engine.shouldPeriodicallyFlush(), equalTo(true));
    private static class AddIndexesFailingIndexWriter extends IndexWriter {
        }
        MatcherAssert.assertThat(
        engine.refresh("test");
    }
    public void testLuceneHistoryOnPrimary() throws Exception {
                }
                            } catch (InterruptedException e) {
        }
            globalCheckpoint.set(randomLongBetween(0, localCheckpoint));
            try {
     * are correctly added to the translog.
            }
                                }
        ParsedDocument doc = testParsedDocument(
    }
        }
        // Optionally, index more docs without refreshing. These should not be part of getMaxSeqNoRefreshed
                thread.start();
        // and it stays disarmed without a commit having happened, i.e. no flush is needed to make it stick
                engineFailureReasons.add(reason);
            boolean committed = randomBoolean();
        replicaEngine.refresh("test");
            engine.flush();
            thread[i].start();
            if (rarely()) {
        assertThat(assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().currentFileGeneration(), equalTo(3L));
            assertThat(segments.get(0).committed, equalTo(committed));
                }
        try (Engine.GetResult getResult = engine.get(newGet(false, doc), searcherFactory)) {
    public void testSegmentsWithNestedFieldIndexSortWithMerge() throws Exception {
                    assertThat(result.getVersion(), equalTo(Math.max(lastOpVersion + 1, 1)));
            document.add(seqID.seqNo);
    public void testSegmentsWithMergeFlag() throws Exception {
            );
     * Return a tuple representing the sequence ID for the given {@code Get}
        assertThat(noOpResult.getFailure(), nullValue());
            assertThat(indexResult.getSeqNo(), equalTo(seqNo));
            Engine.IndexResult retryResult = engine.index(retry);
        assertFalse(updateResult.isCreated());
                Settings.builder()
                    engine.refresh("test", randomFrom(Engine.SearcherScope.values()), true);
        }
                for (int i = 0; i < times; i++) {
            failureToThrow.set(null);
                IOUtils.close(engine, store);
            {
                .field("store", true)
                                ) {
        try (Store store = createStore()) {
            2,
                    throw new RuntimeException(e);
        ParsedDocument doc = testParsedDocument("1", null, testDocument(), B_1, null);
        for (int i = 0; i < numDocs; i++) {
            UNASSIGNED_SEQ_NO,
            Collection<String> files = snapshot.get().files(true);
            assertEquals(initialEngine.getProcessedLocalCheckpoint(), initialEngine.getPersistedLocalCheckpoint());
                    Versions.MATCH_DELETED,
                }
                Versions.MATCH_DELETED,
                    }
                    }
                        throw new RuntimeException(e);
        VersionConflictEngineException exception = (VersionConflictEngineException) result.getFailure();
        CountDownLatch latch = new CountDownLatch(1);
            }
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndSeqNo;
        final AtomicInteger idGenerator = new AtomicInteger();
            List<Translog.Operation> actualOps = readAllOperationsInLucene(engine);
                    ParsedDocument doc = testParsedDocument(
            1,
        indexSettings.setEnableFuzzySetForDocId(true);
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), numDocs + 1);
        rollTranslog.start();
            @Override
                    throw (RuntimeException) failure;
            running.set(false);
        );
                } else {
            EngineConfig config = config(defaultSettings, store, translogPath, newMergePolicy(), null, null, globalCheckpoint::get);
                assertThat(segment.getMergeId(), nullValue());
        // set up mock
                            UNASSIGNED_SEQ_NO,
import java.util.function.Function;
        }
                long localCheckpoint = userData.containsKey(SequenceNumbers.LOCAL_CHECKPOINT_KEY)
            boolean committed = randomBoolean();
            for (int i = 1; i <= 100; i++) {
            final ParsedDocument doc = testParsedDocument(
            InternalEngine engine = null;
        long id = translog.currentFileGeneration();
                assertNotNull(indexResult.getTranslogLocation());
        indexSettings.updateIndexMetadata(
            InternalEngine engine = createEngine(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE, indexWriterFactory)
                        globalCheckpoint.set(randomLongBetween(globalCheckpoint.get(), engine.getPersistedLocalCheckpoint()));
        );
                InternalEngine engine = null;
        assertThat(result.getTranslogLocation(), nullValue());
        ParsedDocument doc = testParsedDocument("1", null, testDocument(), B_1, null);
                final TotalHitCountCollector collector = new TotalHitCountCollector();
            assertThat(engine.failedEngine.get().getMessage(), equalTo("fatal"));
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(0));
                return throwingIndexWriter.get();
     */
                    );
                assertNotNull(indexResult.getTranslogLocation());
        final ParsedDocument doc = testParsedDocument(
                            expectedTotal += len;
            engine.delete(new Engine.Delete(index.id(), index.uid(), primaryTerm.get()));
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                            case "flush": {
        }
        for (int i = 0; i < thread.length; i++) {
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
                engineFailures.add(e);
        engine.close();
                        1
                } else {
        engine.refresh("test");
                    );
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
            closingThreads[i].start();
                    }
    public void testTreatDocumentFailureAsFatalError() throws Exception {
        List<Engine.Operation> primaryOps = generateSingleDocHistory(false, VersionType.INTERNAL, 2, 2, 20, "1");
                    );
        engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                assertFalse(didRefresh);
    }
            currentTerm.get(),
                @Override
                String idToUpdate = randomFrom(liveDocsFirstSegment);
            };
            if (failureToThrow.get() != null) {
            1,
            }
            Collection<String> files = snapshot.get().files(true);
        final long timestamp2 = randomNonNegativeLong();
            IndexResult indexResult = engine.index(indexForDoc(doc2));
        for (int j = 0; j < randomIntBetween(1, 10); j++) {
                );
            }
            InternalEngine engine = null;
            }
                    }
                try {
        Engine.IndexResult result = engine.index(firstIndexRequest);
                    String idToDelete = Integer.toString(randomInt(numDocs - 1));
                } catch (AlreadyClosedException ex) {
            -1,
                    try {
        };
                try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
            }
                new BytesArray("{}".getBytes(Charset.defaultCharset())),
                }
        }
                        }
            Engine.IndexResult indexResult = engine.index(operation);
        final Path translogPath = createTempDir("testTranslogReplayWithFailure");
        engine.close();
            List<Segment> segments = engine.segments(true);
                    } else if (i == 2) {
            List<Segment> segments = engine.segments(true);
                    liveDocsWithSource.add(Integer.toString(i));
        final boolean primary = randomBoolean();
                    do {
            final List<GatedCloseable<IndexCommit>> snapshots = new ArrayList<>();
        Engine.TranslogBatch batch = batchEngine.beginTranslogBatch();
    }
            newUid(doc),
                        System.nanoTime(),
                    Engine.Operation.Origin.PRIMARY,
            segments = engine.segments(false);
                expectThrows(AlreadyClosedException.class, () -> engine.index(indexForDoc(doc1)));
    }
        try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
                    if (values.advanceExact(docID) == false) {
                    delete.versionType(),
    public void testVersionMapAfterAutoIDDocument() throws IOException {
    }
            lastFieldValue = index.docs().get(0).get("value");
                Settings.builder()
        expectThrows(
        barrier.await();
import org.opensearch.index.translog.TranslogDeletionPolicyFactory;
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 1)
            newUid(doc),
        EngineConfig config = engine.config();
            UNASSIGNED_SEQ_NO,
            assertThat(segments.get(0).getSegmentSort(), equalTo(indexSort));
                }
        final List<Engine.Operation> operations = generateSingleDocHistory(
            assertThat(segments.size(), equalTo(2));
        final List<Long> seqNos = LongStream.range(0, docs).boxed().collect(Collectors.toList());
                primaryTerm.get(),
                        }
            null,
                );
                }
            assertThat(stats1.getUserData(), hasKey(SequenceNumbers.MAX_SEQ_NO));
                randomNonNegativeLong(),
                .recoverFromTranslog(translogHandler, recoveringEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        wrapper.failOn(fail);
            }
                    IOUtils.close(commits.remove(randomIntBetween(0, commits.size() - 1)));
                3L,
        final int opsPerThread = randomIntBetween(10, 20);
     */
            thread[i].join();
        // type for _id (required for the FuzzyFilter branch to be reached).
                config(indexSettings, store, createTempDir(), mergePolicy, null, null, globalCheckpoint::get)
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(1));
                stall.set(true);
        searchResult.close();
    public void testFillUpSequenceIdGapsOnRecovery() throws IOException {
                        1,
import org.apache.lucene.index.LeafReader;
        ) {
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 0)
            UNASSIGNED_SEQ_NO,
        boolean replicaOperationIsRetry = randomBoolean();
            .externalRefreshListener(config.getExternalRefreshListener())
                doc,
            assertTrue(committed.get());
            final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
     * less than the actual on-disk size. The fix replaces {@code put} with
            EngineConfig config = config(defaultSettings, store, translogPath, NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get);
            Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_VERSION_CREATED, createdVersion).build();
            currentTerm.get(),
            assertTrue(get.exists());
                }
                .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")
                    int count = 0;
                    Versions.MATCH_ANY,
                }
            new Engine.NoOp(seqNo, term, randomFrom(Engine.Operation.Origin.values()), randomNonNegativeLong(), "test")
            assertTrue(internalEngine.failedEngine.get() instanceof MockDirectoryWrapper.FakeIOException);
        iter2.forEachRemaining(o -> allOps.add(seqNoUpdater.apply(o, seqNoGenerator.getAndIncrement())));
                document.add(new Field(SourceFieldMapper.NAME, BytesReference.toBytes(B_1), SourceFieldMapper.Defaults.FIELD_TYPE));
    }
                        assertThat(r.isCreated(), equalTo(false));
                } finally {
            createTranslogDeletionPolicy(INDEX_SETTINGS),
import java.util.stream.LongStream;
        thread.join();
                                        randomBoolean(),
            assertEquals(indexResult.getSeqNo(), get.docIdAndVersion().seqNo);
            engine.flushAndClose();
            for (Segment segment : engine.segments(false)) {
        }
            TranslogOperationHelper.DEFAULT,
                    }
                assertThat(searcher.getIndexReader().numDocs(), equalTo(numDocs + 1));
            assertThat(getResult.exists(), equalTo(false));
            Store store = createStore(wrapper);
        indexSettings.updateIndexMetadata(indexMetadata);
        TranslogDeletionPolicyFactory translogDeletionPolicyFactory = CustomTranslogDeletionPolicy::new;
                assertThat(operationsFromLucene, hasSize(maxSeqNo + 2 - localCheckpoint)); // fills n gap and 2 manual noop.
        MatcherAssert.assertThat(
            autoGeneratedIdTimestamp,
            // this so we have to disable the check explicitly
            thread[i].start();
    }
            @Override
                .recoverFromTranslog(translogHandler, recoveringEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        Thread indexer = new Thread(() -> {
                    batchEngine.refresh("drain failed batch");
                                        "updated",
        Translog.Location maxLocation = batch.finish();
        engine.refresh("test");
        }
                }
/*
        if (randomBoolean()) {
            engine.config().getMergePolicy()
    }
            segments = engine.segments(true);
                assertEquals(commit.get().getSegmentsFileName(), segmentInfos.getSegmentsFileName());
                }
        try (Store store = createStore()) {
        );
            .indexSettings(config.getIndexSettings())
        try (
    public void testMaxSeqNoInCommitUserData() throws Exception {
            assertThat(stats2.getUserData(), hasKey(SequenceNumbers.MAX_SEQ_NO));
            }
        return engine.getVersionMap()
            AtomicBoolean throwErrorOnCommit = new AtomicBoolean();
                (engine, operation) -> seqNos.get(counter.getAndIncrement())
                }
            autoGeneratedIdTimestamp,
                    randomLongBetween(globalCheckpoint.get(), engine.getLocalCheckpointTracker().getPersistedCheckpoint())
        try (
                // Delete some documents
            Engine.GetResult get = batchEngine.get(new Engine.Get(true, true, firstDoc.id(), firstOp.uid()), batchEngine::acquireSearcher)
        Engine.IndexResult indexResult = engine.index(index);
                // refresh and take the chance to check everything is ok so far
            final Engine.EventListener eventListener = new Engine.EventListener() {
            assertThat(segments, hasSize(2));
                    // fine
                    do {
        List<Engine.Operation> operations = generateHistoryOnReplica(
                        throw new AssertionError(e);
        if (engine.engineConfig.getIndexSettings().isSoftDeleteEnabled()) {
                final String translogUUID = Translog.createEmptyTranslog(
    public void testUnreferencedFileCleanUpOnSegmentMergeFailureWithCleanUpEnabledWithIndexSort() throws Exception {
                engine.failEngine("test", new RuntimeException("test"));
                        System.nanoTime(),
            assertThat(seqNoGenerator.get(), equalTo(seqNo + 2));
            engine.refresh("warm_up");
            searchResult,
                false,
            autoGeneratedIdTimestamp,
        );
        }
            }
                        }
                    assertEquals("Expected number of operations in range", to - from + 1, count);
                    newForceMergePolicy(),
                deletesAfterCheckpoint.values().removeIf(o -> o instanceof Engine.Delete == false);
            String id = Integer.toString(randomIntBetween(1, 10));
                        VersionType.EXTERNAL,
            assertLuceneOperations(engine, 1, 0, 0);
            IndexReader reader = searcher.getIndexReader();
        // rethrows the close failure rather than appending or hanging.
                        IllegalStateException.class,
            -1,
        assertThat("Empty engine does not need flushing", engine.shouldPeriodicallyFlush(), equalTo(false));
                        doc,
        assertThat(indexResult.getVersion(), equalTo(1L));
                        null
                    throwingIndexWriter.get().setThrowFailure(() -> new IOException("simulated"));
        );
                    engine.translogManager().syncTranslog();
            assertThat(segments.size(), equalTo(3));
            2,
            searchResult,
                    cfeCompoundFileFound = true;
            assertTrue(retryResult.getTranslogLocation().compareTo(indexResult.getTranslogLocation()) < 0);
                        latestOps.put(op.id(), op);
                long minSeqNoToRetain = Math.min(globalCheckpoint.get() + 1 - retainedExtraOps, safeCommitCheckpoint + 1);
            engine.index(indexForDoc(doc1));
        ParsedDocument v1 = testParsedDocument("upd", null, testDocument(), B_1, null);
                    id = "not_found";
            assertThat(op2.opType(), equalTo(Translog.Operation.Type.DELETE));
            this.engineFailures = engineFailures;
                2,
            assertThat(segments, hasSize(1));
        public void clearFailure() {
            assertThat(segments.size(), equalTo(1));
        assertThat(engine.lastRefreshedCheckpoint(), equalTo(engine.getProcessedLocalCheckpoint()));
    }
        }
                String msg = "seq# [" + seqno + "], global checkpoint [" + globalCheckpoint + "], retained-ops [" + retainedExtraOps + "]";
            List<ParsedDocument> docs = List.of(
            // index an op that is added to lucene but blocks before being marked as processed
            segments = engine.segments(false);
                new SoftDeletesRetentionMergePolicy(
            engine.refresh("test");
        );
                while ((operation = snapshot.next()) != null) {
        );
                    Versions.MATCH_ANY,
            @Override
                        null
                    getSnapshotAndAssertFilesExistLocally();
                }
        }
                if (committedFiles.contains(file) == false) {
        );
        assertThat(
                            Translog.Snapshot changes = engine.newChangesSnapshot("test", min, max, true, randomBoolean());
        }
                return super.addDocument(doc);
        }
            final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
        batchEngine.flush();
        assertThat(
                    testContextSpecificDocument(groupingCriteria),
        searchResult = engine.acquireSearcher("test");
                                )
                assertTrue(TransportActions.isShardNotAvailableException(e));
                    engine.index(index);
                nrtUserData.get(Translog.TRANSLOG_UUID_KEY)
                                                                                                                  // magic numbers
                if (callStackContainsAnyOf("mergeTerms")) {
            )
        String indent = "";
                .build()
            index = indexForDoc(testParsedDocument("2", null, testDocument(), B_1, null));
                    null,
                    }
            for (int i = 0, docs = scaledRandomIntBetween(0, 10); i < docs; i++) {
                shardId.id(),
            currentTerm.get(),
     * default returns the no-op batch and every eligible shard silently keeps appending inline.
            shardId,
            );
        }
                    }
            engine.delete(
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
            UNASSIGNED_SEQ_NO,
                        super.commitIndexWriter(writer, translogUUID);
                @Override
                    .put(defaultSettings.getSettings())
                        null,
            delete.routing()
        assertTrue(indexResult.isCreated());
    }
            );
            false,
            UNASSIGNED_SEQ_NO,
                        } else if (operation instanceof Translog.Delete) {
            final ArrayList<Long> seqNos = new ArrayList<>();
                    Engine.DeleteResult delete = engine.delete(replicaDeleteForDoc(doc.id(), between(1, 100), i, randomNonNegativeLong()));
            assertEquals(checkpointOnReplica, recoveringEngine.getProcessedLocalCheckpoint());
                    Translog.Operation operation;
                        throw new AssertionError(ex);
        }
            lastFieldValueDoc2 = index.docs().get(0).get("value");
    public void testConcurrentExternalVersioningOnPrimary() throws IOException, InterruptedException {
            assertTrue(op.added + " should not exist", exists);
                    indexSettings.getTranslogRetentionAge().getMillis(),
        store = createStore();
            }
        MockDirectoryWrapper.Failure fail = new MockDirectoryWrapper.Failure() {
    }
        Collections.shuffle(seqNos, random());
            1,
                    started = true;
    }
        assertThat(uncommittedTranslogOperationsSinceLastCommit.getAsInt(), equalTo(0));
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
            // create N indexing threads to index documents simultaneously
                    primaryTerm.get()
                config(
                if (randomBoolean()) {
        assertTrue(TransportActions.isShardNotAvailableException(closed));
            IOUtils.close(initialEngine, recoveringEngine, store);
                assertThat(actualOps, containsInAnyOrder(expectedOps));
                        doc,
        assertThat(engine.getProcessedLocalCheckpoint(), equalTo(expectedLocalCheckpoint));
                InternalEngine engine = new InternalEngine(
                    config(indexSettings, store, translogPath, newMergePolicy(), null, null, globalCheckpointSupplier)
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                    uid,
            engine.ensureOpen();
            1,
                thread.start();
                        false,
                        VersionType.EXTERNAL,
                assertEquals(maxSeqIDOnReplica, recoveringEngine.getSeqNoStats(-1).getMaxSeqNo());
                        if (operation instanceof Translog.Index) {
}
                        -1,
                    // test non document level failure is thrown
            assertEquals(0, topDocs.totalHits.value());
                        UNASSIGNED_SEQ_NO,
                    null,
                        Engine.Index update = indexForDoc(doc);
                    Engine.Operation.Origin.PRIMARY,
        assertFalse(engine.refreshNeeded());
            }
            -1,
        assertVisibleCount(engine, lastFieldValue == null ? 0 : 1);
        }
        Engine.Delete directDeleteWithRouting = new Engine.Delete(
                        newUid(doc),
        }
                newUid(doc),
                                    StoredFields storedFields = get.docIdAndVersion().reader.storedFields();
            assertThat(e.getMessage(), equalTo("fatal"));
    public void testKeepMinRetainedSeqNoByMergePolicy() throws IOException {
        int maxDocs = randomIntBetween(1, 100);
            );
                    } catch (IOException ex) {
            if (randomBoolean()) {
            Engine engine = createEngine(config(defaultSettings, store, createTempDir(), newMergePolicy(), null))
            newUid(doc),
            // merges happen so we can verify that _recovery_source are pruned. See: https://github.com/elastic/elasticsearch/issues/41628.
            engine.refresh("test");
                        }
        engine.flush();
        try (Store store = createStore(); Engine engine = createEngine(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE)) {
        // the publisher calls this on every sync while disabled, so repeating it must be a harmless no-op
                    assertThat(result.isFound(), equalTo(docDeleted == false));
            throw new AssertionError(ex);
            assertThat(stats2.getUserData(), hasKey(Translog.TRANSLOG_UUID_KEY));
                    assertThat(
    }
            clock.set(between(0, 100));
            assertThat(stats1.getId(), notNullValue());
                final ParsedDocument doc = testParsedDocument(docId, null, testDocumentWithTextField(), SOURCE, null);
            );
                        // extra0 file is added as a part of
        engine.flush(true, true);
        searchResult.close();
        final Logger iwIFDLogger = LogManager.getLogger("org.opensearch.index.engine.Engine.IFD");
    public void testCurrentTranslogUUIIDIsCommitted() throws IOException {
            .build();
import org.apache.lucene.search.MatchAllDocsQuery;
        );
    }
        engine.refresh("test");
                    0,
        }
                    throw new AssertionError(e);
                if (op instanceof Engine.Index) {
            assertNotNull(retryResult.getTranslogLocation());
                .store(store)
        }
            engine.refresh("test");
        final Engine.Operation lastOpDoc1 = opsDoc1.get(opsDoc1.size() - 1);
        engine.flush();
                        // Verify source is derived correctly
                        false,
                assertNotNull(indexResult.getTranslogLocation());
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(seqNo - 1));
                final Engine.Index doc = new Engine.Index(
            );
                    // Keep only one safe commit as the oldest commit.
    public void testDoubleDeliveryReplicaAppendingAndDeleteOnly() throws IOException {
        final MockDirectoryWrapper directory = newMockDirectory();
import java.util.function.BiFunction;
                            UNASSIGNED_SEQ_NO,
        assertThat("Not exceeded translog flush threshold yet", engine.shouldPeriodicallyFlush(), equalTo(false));
            segments = engine.segments(true);
        document.add(new Field(SourceFieldMapper.NAME, BytesReference.toBytes(B_1), SourceFieldMapper.Defaults.FIELD_TYPE));
            }
            assertThat(getResult.exists(), equalTo(false));
                .startObject("script")
            for (int i = totalNumberOfDocsRefreshed; i < (totalNumberOfDocsRefreshed + numDocs); i++) {
                    assertEquals(0, leafReader.numDocs());
                    );
                .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
     * {@code expectedLocalCheckpoint} is set accordingly.
                        + "a mismatch means some files were silently dropped due to duplicate extensions",
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
import org.apache.lucene.document.StoredField;
                    } while (deletedDocs.contains(idToUpdate) || updatedDocs.contains(idToUpdate));
                store,
            assertThat(engine.failedEngine.get().getMessage(), equalTo("fatal"));
            }
        }
            UNASSIGNED_SEQ_NO,
                for (int i = 0; i < numDocsToDelete; i++) {
            UNASSIGNED_SEQ_NO,
            )
                .put(IndexSettings.INDEX_CONTEXT_AWARE_ENABLED_SETTING.getKey(), true)
            engine.refresh("test");
        // now flush
        }
            threads[i].start();
            final ParsedDocument doc = testParsedDocument(
                    internalEngine.refresh("test");
        } finally {
                    engine.ensureOpen();
                    }
            result.getSeqNo(),
                    }
import java.util.concurrent.CyclicBarrier;
                    Engine.DeleteResult deleteResult = engine.delete((Engine.Delete) op);
            final ParsedDocument doc = testParsedDocument(
        }
        final AtomicLong refreshCounter = new AtomicLong();
            engine.delete(delete);
            final int numDocsPerThread = randomIntBetween(500, 1000);
    public void testSearchResultRelease() throws Exception {
                        );
                try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", 0, operations.size() - 1, true, true)) {
        if (lastFieldValueDoc2 != null) {
        assertThat(engine.shouldPeriodicallyFlush(), equalTo(false));
            }
                }
            assertThat(indexResult.getFailure(), instanceOf(VersionConflictEngineException.class));
                primaryTranslogDir,
                    origin,
                SeqNoStats seqNoStats = engine.getSeqNoStats(globalCheckpoint.get());
                            UNASSIGNED_SEQ_NO,
            new Engine.Delete(
                Long.parseLong(stats1.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)),
            indexResult.getSeqNo(),
import static org.hamcrest.Matchers.not;
        final Set<String> committedFiles;
                            indexOp.source().utf8ToString()
import java.util.Arrays;
        ParsedDocument doc = testParsedDocument("batch-xthread", null, testDocument(), B_1, null);
            InternalEngine engine = null;
 * Licensed to Elasticsearch under one or more contributor
        ) {
                thread.start();
            }
                engine.translogManager().syncTranslog(); // advance persisted local checkpoint
            assertThrows(UnsupportedOperationException.class, () -> engine.index(indexForDoc(doc2)));
            // Close the store so that unreferenced file cleanup will fail.
            assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
                assertEquals(engine.getProcessedLocalCheckpoint(), engine.getPersistedLocalCheckpoint());
                IndexWriter.MAX_DOCS,
                        searcher.search(new TermQuery(new Term("value", lastFieldValue)), collector);
        final AtomicInteger refreshCount = new AtomicInteger();
            VersionType.INTERNAL,
        } finally {
     *     <li>Guessing the deleted seqNo makes the operation succeed</li>
            if (randomBoolean()) {
            0
                        assertEquals(store.refCount(), refCount + 1);
        assertThat(result.getTranslogLocation(), nullValue());
            System.nanoTime(),
            engine.refresh("test");
import org.apache.lucene.search.TopDocs;
                    assertThat(result.getFailure(), instanceOf(VersionConflictEngineException.class));
                        doc,
                                )
            assertThat(segments, hasSize(2));
                    if (latestOps.containsKey(op.id()) == false || latestOps.get(op.id()).seqNo() < op.seqNo()) {
        assertNotNull("Must have failure for " + operation, result.getFailure());
                            String docId = ((Translog.Delete) operation).id();
            delete.version(),
        Randomness.shuffle(operations);
    }
            final ParsedDocument doc = testParsedDocument(Integer.toString(id), null, testDocumentWithTextField(), SOURCE, null);
                if (randomBoolean()) {
    }
                new Engine.Index(
        try (Store store = createStore()) {
                        // extra0 file is added as a part of
            assertThat(recoveringEngine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(docs));
                                break;
                    engine.flush(randomBoolean(), true);
                    newForceMergePolicy(),
            "test_file_sizes",
            new BytesArray("{}".getBytes(Charset.defaultCharset())),
        shuffle(allOps, random());
            List<Segment> segments = engine.segments(true);
            Engine.Operation.Origin.PRIMARY,
        final long finalReplicaVersion = lastReplicaOp.version();
                final CountDownLatch startGun = new CountDownLatch(1);
            engine.refresh("test");
                        mockAppender.assertAllExpectationsMatched();
import org.opensearch.index.shard.ShardUtils;
            UNASSIGNED_SEQ_NO,
                            null,
                            UNASSIGNED_SEQ_NO,
                    globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
            try (Engine.Searcher searcher = recoveringEngine.acquireSearcher("test")) {
                final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
        for (int i = 0; i < refreshThreads.length; i++) {
        final CountDownLatch addedToLucene = new CountDownLatch(1);
                .queryCachingPolicy(base.getQueryCachingPolicy())
                        System.nanoTime(),
    public void testDoubleDeliveryReplicaAppendingOnly() throws IOException {
            final List<DocIdSeqNoAndSource> prevDocs;
    }
        reader.start();
                    engine.forceMerge(randomBoolean(), 1, false, randomBoolean(), randomBoolean(), UUIDs.randomBase64UUID());
            // IndexWriter can throw either IOException or IllegalStateException depending on whether tragedy is set or not.
                final TotalHitCountCollector collector = new TotalHitCountCollector();
                    assert false : "unsupported failure class: " + failure.getClass().getCanonicalName();
     * Parity with {@code DataFormatAwareEngine}: a refresh must drain every live batch (append its pending chunk and
        XContentBuilder mapping;
            assertThat(segments.isEmpty(), equalTo(true));
                // Compute the actual total reported by segmentsStats with file sizes enabled.
        final Supplier<ParsedDocument> doc = () -> testParsedDocument(
                    barrier.await();
        searchResult.close();
                    false,
            );
                Engine.Searcher getSearcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
            final Engine.EventListener eventListener = new Engine.EventListener() {
 * Modifications Copyright OpenSearch Contributors. See
        flushFinished.set(true);
        }
            "test",
                        // Safe to remove from file count along with write.lock without impacting the test
                        // https://lucene.apache.org/core/7_2_1/test-framework/org/apache/lucene/mockfile/ExtrasFS.html
            testDocumentWithTextField(),
                () -> engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID())
                commits.add(engine.acquireLastIndexCommit(true));
                    final Engine.IndexResult result;
                    engine.delete(new Engine.Delete(doc.id(), newUid(doc), primaryTerm.get()));
        );
                    )
        engine.refresh("test");
            final int numIndexingThreads = scaledRandomIntBetween(3, 8);
        searchResult = engine.acquireSearcher("test");
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        engine.refresh("test");
    public void testRefreshNeededWhenProcessedOpSkipsLucene() throws IOException {
                }
            assertTrue(engine.refreshNeeded());
            final int numIters = randomIntBetween(3, 5);
            store,
            }
            assertThat(segments.size(), equalTo(1));
                        doc,
            // now, verify all the commits have the correct docs according to the user commit data
            final long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
        }
     * We can trim translog on primary promotion and peer recovery based on the fact we add operations with either
                ParsedDocument doc = testParsedDocument("1", null, new Document(), new BytesArray("{}".getBytes("UTF-8")), null);
                    }
            Translog.Operation last = null;
                engine.flush();
                                bytesArray(Strings.collectionToCommaDelimitedString(values)),
                );
        final String translogUUID = Translog.createEmptyTranslog(translogPath, globalCheckpoint.get(), shardId, primaryTerm.get());
                        mockAppender.close();
                        // TODO: add support for non-existing docs
            assertTrue(op.removed + " should exist", exists);
        Logger rootLogger = LogManager.getRootLogger();
                    final String id = Long.toString(seqNo);
            assertThat(snapshot.next(), nullValue());
                ParsedDocument document = testParsedDocument(Integer.toString(0), null, testDocumentWithTextField(), SOURCE, null);
                thread.start();
        assertVisibleCount(engine, numDocs, false);
        assertThat(
                            threadPool.relativeTimeInMillis(),
                if (randomBoolean()) {
            TranslogHandler translogHandler = createTranslogHandler(engine.config().getIndexSettings(), recoveringEngine);
         *                     low-level IO error
    }
                }
            final AtomicBoolean stall = new AtomicBoolean();
        }
            store.associateIndexWithNewTranslog(translogUuid);
        if (randomBoolean()) {
                // the "value" text field goes through the standard format. Both end up in the
                        0
                randomNonNegativeLong(),
                    UNASSIGNED_SEQ_NO,
     * when {@code cluster.remote_store.flush_on_uncommitted_segments.enabled} is turned off, instead of leaving an
    }
        assertFalse(indexResult.isCreated());
                liveDocs.add(doc.id());
        engine = createEngine(config(defaultSettings, store, translogPath, newMergePolicy(), null, null, globalCheckpoint::get));
        }
        AtomicBoolean running = new AtomicBoolean(true);
import java.util.function.Supplier;
            outcome.engineFailures.size(),
            };
                    awaitStarted.countDown();
            final IllegalArgumentException error = expectThrows(IllegalArgumentException.class, () -> {
            0
                // test document failure while indexing
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                }
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
            } catch (InterruptedException ex) {
        }
                        equalTo(currentMaxSeqNoOfUpdates)
                        cleanupCompleted.countDown();
                        // https://lucene.apache.org/core/7_2_1/test-framework/org/apache/lucene/mockfile/ExtrasFS.html
                new Engine.Delete(
                    bitSet.set((int) seqNo);
        try {
                .similarity(config.getSimilarity())
            int appends = 0;
        expectThrows(EngineCreationFailureException.class, () -> new InternalEngine(brokenConfig));
            long sleepTime = 1;
                    false,
                if (failure instanceof RuntimeException) {
                }
                // check it's clean up
            ParsedDocument doc2 = testParsedDocument("2", null, testDocumentWithTextField(), B_2, null);
            assertThat(DirectoryReader.listCommits(engine.store.directory()), hasSize(2));
        try (
        }
            index.primaryTerm(),
                                    assertEquals(
     */
        try (GatedCloseable<SegmentInfos> snapshot = engine.getSegmentInfosSnapshot()) {
        document = testDocumentWithTextField();
                } catch (AlreadyClosedException ex) {
        }
        while (current.getCause() != null && current.getCause() != current) {
            }
            // Get should not find the document
        LiveIndexWriterConfig currentIndexWriterConfig = engine.getCurrentIndexWriterConfig();
                }
                    delete.routing()
            );
                ),
        // but, we can still get it (in realtime)
            ) {
                        }
            0
            store.close();
                    UNASSIGNED_SEQ_NO,
 * ownership. Elasticsearch licenses this file to you under
            recoveringEngine.ensureOpen();
    }
            assertThat(segments, hasSize(1));
        engine.close();
                    }
    public void testMergeSegmentsOnCommitDefault() throws Exception {
            Map<Long, Translog.Operation> ops = readAllOperationsInLucene(engine).stream()
import org.opensearch.common.util.concurrent.AbstractRunnable;
                System.nanoTime(),
            .build();
                ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), B_1, null, useRecoverySource);
            assertThat(snapshot.next(), nullValue());
                Store store = createStore();
                        System.nanoTime(),
                        count++;
                    -1,
            globalCheckpoint.set(randomLongBetween(globalCheckpoint.get(), engine.getPersistedLocalCheckpoint()));
        assertThat(assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().getMinFileGeneration(), equalTo(3L));
            final AtomicBoolean stall = new AtomicBoolean();
            CommitStats stats2 = engine.commitStats();
            currentTerm.get(),
                noopEngineConfig,
    }
                        result = engine.index(indexWithCurrentTerm.apply(index));
    public void testFailStart() throws IOException {
    }
            System.nanoTime(),
                            }
        }
import org.apache.lucene.document.NumericDocValuesField;
        int numDocs = randomIntBetween(1000, 10000);
            };
     * refresh runs on its own thread so a deadlock surfaces as a failed join rather than a hung suite.
                    assertEquals("Expected number of operations", operations.size(), count);
                );
            );
        }
            // open and recover tlog with empty tlog
        doc = testParsedDocument("2", null, testDocumentWithTextField(), new BytesArray("{}"), null);
            newUid(doc),
            assertEquals(numDocs, count);
                    Engine.Index index = new Engine.Index(
                PRIMARY,
                    ParsedDocument doc = testParsedDocument(Long.toString(seqNos.get(i)), null, testDocument(), new BytesArray("{}"), null);
            random(),
        assertThat(second.getVersion(), equalTo(first.getVersion() + 1));
                    assertThat(count, equalTo(numDocs));
            if (create) {
                directory.setAllowRandomFileNotFoundException(randomBoolean());
        final BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory = engine::acquireSearcher;
                "delete: " + seqNo
            }
                Engine.IndexResult indexResult = engine.index(indexForDoc(doc1));
                            System.nanoTime(),
                IOUtils.close(engine, store);
            indent += "  ";
                        userData.get(Translog.TRANSLOG_UUID_KEY)
import static org.opensearch.common.util.FeatureFlags.CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG;
        assertThat(result.getTranslogLocation(), nullValue());
                LeafReader leafReader = leafReaderContext.reader();
                    assertThat(noOp.getTerm(), equalTo(primaryTerm.get()));
                    );
            )
                        tracker.hasProcessed(op.seqNo()),
                    opsPerformed++;
            } else {
        searchResult = engine.acquireSearcher("test");
                        }
                            UNASSIGNED_SEQ_NO,
            // now snapshot the tlog and ensure the primary term is updated
            }
    }
                    }
                @Override
        engine.flush();
                        .filter(e -> e.getValue().operationType() == Engine.Operation.TYPE.INDEX)
                    );
        MockDirectoryWrapper wrapper = newMockDirectory();
/*
     * A sequence number generator that will generate a sequence number and if {@code stall} is set to true will wait on the barrier and the
        public void append(LogEvent event) {
     * commit point are summed, while committed files and {@code segments_N} entries are excluded. The total is
            assertThat(tombstonesInVersionMap(engine).values(), containsInAnyOrder(tombstones.toArray()));
            false,
        MatcherAssert.assertThat(
            assertThat(result.exists(), equalTo(exists));
                expectThrows(AlreadyClosedException.class, () -> engine.delete(new Engine.Delete("", newUid(doc1), primaryTerm.get())));
                        result = engine.delete(delWithSeq.apply(conflictingSeqNo, conflictingTerm, delete));
        final long flushThreshold = randomLongBetween(120, 5000);
                    }
        final BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory = engine::acquireSearcher;
                 * Index three documents with the first and last landing in the same generation and the middle document being stalled until
                Thread indexingThread = new Thread(() -> {
            indexResult.getVersion(),
                        assertThat(initialEngine.getSeqNoStats(-1).getMaxSeqNo(), equalTo(primarySeqNo));
        engine.close();
            .put(IndexSettings.INDEX_MERGE_ON_FLUSH_POLICY.getKey(), "merge-on-flush");
        try (InternalEngine engine = new InternalEngine(engineConfig) {
            Engine.IndexResult indexResult = engine.index(operation);
                Set<String> ids = new HashSet<>();
            final AtomicLong retentionLeasesVersion = new AtomicLong();
                ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), B_1, null);
            List<String> values = Arrays.asList(Strings.commaDelimitedListToStringArray(visitor.source().utf8ToString()));
            if (op instanceof Engine.Index) {
                    engine.index(index);
        // now its there...
            t.join();
        try (Store store = createStore()) {
            refreshThread.join();
            }
    }
                        Engine.Operation.Origin.PRIMARY,
                    config.getTranslogConfig().getTranslogPath(),
                if (randomBoolean()) {
            }
        final CyclicBarrier barrier,
            return null;
            try (Translog.Snapshot snapshot = getTranslog(recoveringEngine).newSnapshot()) {
        IOUtils.close(engine, store);
                    } else {
                // With the old map.put() bug, actualTotal < expectedTotal whenever the codec
            assertEquals(recoveringEngine.getProcessedLocalCheckpoint(), recoveringEngine.getPersistedLocalCheckpoint());
        document = testDocument();
    }
                }
            List<OpenSearchDirectoryReader> warmedUpReaders = new ArrayList<>();
            }
            engine.flush();
                null,
        final int maxSeqNo = 40;
                        engine.forceMerge(randomBoolean(), 1, false, false, false, UUIDs.randomBase64UUID());
            assertThat(stats2.getUserData().get(Translog.TRANSLOG_UUID_KEY), equalTo(stats1.getUserData().get(Translog.TRANSLOG_UUID_KEY)));
                        assertSame(internalSearcher.getDirectoryReader(), externalSearcher.getDirectoryReader());
                    }
                    int count = 0;
                    new Engine.Index(
                    for (int i = 1; i < commits.size(); i++) {
        assertThat(message, engine.getNumDocUpdates(), equalTo(expectedUpdates));
                System.nanoTime(),
            engine.index(indexForDoc(doc));
        try (Store store = createStore(directory)) {
        ) {
                null
                for (Engine.Operation op : operationsInSafeCommit) {
                // postings formats do). With the fix (map.merge(Long::sum)) all bytes are counted.
                    recoveringEngine.flush(true, true);
        try {
            try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                int to = randomIntBetween(from, operations.size() - 1);
            thread[i].join();
                .put(IndexSettings.INDEX_CONTEXT_AWARE_ENABLED_SETTING.getKey(), true)
        final Map<String, Long> committedOnlySizeMap = new HashMap<>();
            lastFieldValue = index.docs().get(0).get("value");
                @Override
                        }
            InternalEngine engine = createEngine(config(defaultSettings, store, createTempDir(), newMergePolicy(), null))
            }
    public Engine.Index appendOnlyPrimary(ParsedDocument doc, boolean retry, final long autoGeneratedIdTimestamp, boolean create) {
            try (Closeable ignored = engine.acquireHistoryRetentionLock()) {
                final long seqno = generateNewSeqNo(engine);
            List<Segment> segments = engine.segments(true);
                    assertNotNull(id);
            logger.info("localcheckpoint {}, global {}", replicaLocalCheckpoint, primarySeqNo);
                IOUtils.close(engine, store);
        store.associateIndexWithNewTranslog(translogUUID);
                if (didRefresh) {
                    String idToUpdate;
                engine.refresh("test");
        Engine.Index op = indexForDoc(doc);
import org.opensearch.common.Randomness;
                ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), B_1, null);
            int numDocs = randomIntBetween(10, 100);
                false,
                        Versions.MATCH_DELETED,
        try (GatedCloseable<SegmentInfos> nrtSnapshot = engine.getSegmentInfosSnapshot()) {
        engine.close();
                Engine.Searcher searchSearcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)
        try (ReleasableLock ignored = engine.writeLock.acquire()) {
            for (Segment segment : segments) {
                        UNASSIGNED_SEQ_NO,
            if (replicaOperationIsRetry) {
    }
                    } catch (IOException ex) {
     * the version map holds the newer pending entry, and a realtime GET sees the update. After finish both have
        seqID = getSequenceID(engine, newGet(false, doc));
                    }
            }
    public void testRefreshNeededWhenRefreshedCheckpointLagsVisibleOps() throws Exception {
            PRIMARY,
                .orElse(SequenceNumbers.NO_OPS_PERFORMED);
                    try (Engine.Searcher externalSearcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)) {
            Store store = createStore();
            }
                liveDocsFirstSegment.add(id);
                if (randomBoolean()) {
        // refresh and it should be updated
        assertThat(first.getTranslogLocation(), notNullValue());
            }
                        throw new AssertionError(e);
                long expectedTotal = 0;
                        new BytesArray("{}".getBytes(Charset.defaultCharset())),
        });
            assertEquals(IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP, engine.segmentsStats(false, false).getMaxUnsafeAutoIdTimestamp());
                IndexReader reader = searcher.getIndexReader();
        globalCheckpoint.set(0L);
        engine.flush(true, true);
                        Settings.builder()
                            equalTo(SequenceNumbers.NO_OPS_PERFORMED)
        final StringBuilder sb = new StringBuilder();
                    .indexReaderWarmer(mock(MergedSegmentWarmer.class))
        // The batched op was drained before the commit, so the flush durably persisted its sequence number.
            for (Thread thread : indexingThreads) {
                primaryTranslogDir,
            if (rarely()) {
        Randomness.shuffle(seqNos);
                if (rarely()) {
                        assertThat(collector.getTotalHits(), equalTo(1));
                engine.flush();
                    }
        }
    }
                createTempDir(),
            Store store = createStore();
            // Get should not find the document
import static org.hamcrest.CoreMatchers.sameInstance;
        final List<Engine.Operation> replicaOps = generateSingleDocHistory(true, VersionType.INTERNAL, 1, 2, 20, "1");
                            null
            }
            Store store = createStore();
    public void testCommitAdvancesMinTranslogForRecovery() throws IOException {
        private void maybeThrowFailure() throws IOException {
            for (int i = 0; i < numDocs; i++) {
        // establish a commit point holding the first segment
                    while (snapshot.next() != null) {
                    engine.close();
                final IndexMetadata indexMetadata = IndexMetadata.builder(indexSettings.getIndexMetadata())
                assertThat(engine.shouldPeriodicallyFlush(), equalTo(false));
                new Engine.Get(true, false, doc.id(), create.uid()).setIfSeqNo(indexResult.getSeqNo() + 1)
            assertThat(
                store,
        // refresh and it should be there
        }
            {
                        try {
                    config(indexSettings, store, translogPath, newMergePolicy(), null, null, globalCheckpointSupplier)
                    initializingReplica.currentNodeId(),
            final CyclicBarrier barrier = new CyclicBarrier(numIndexingThreads + 1);
        ) {
            Engine.IndexResult retryResult = engine.index(retry);
                    UNASSIGNED_SEQ_NO,
            + ", expected:"
            });
        );
    public Engine.Index randomAppendOnly(ParsedDocument doc, boolean retry, final long autoGeneratedIdTimestamp) {
    }
import org.opensearch.index.codec.CodecService;
        } catch (Exception ex) {
                for (int i = 0; i < numDocsToUpdate; i++) {
            long prevMaxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
                @Override
            for (int i = 0; i < numDocs; i++) {
                batchEngine.index(indexForDoc(testParsedDocument("drain-2", null, testDocument(), B_1, null)));
                versionConflict ? " (conflict " + conflictingVersion + ")" : "",
                    // we have some docs indexed, so delete one of them
        assertThat(maxLocation, equalTo(second.getTranslogLocation()));
                    String idToDelete = Integer.toString(randomInt(numDocs - 1));
                    i,
            try (
            final ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), SOURCE, null);
            assertThat(engine.lastRefreshedCheckpoint(), equalTo(seqNo));
         *             conf.getOpenMode()</code>.
import org.opensearch.cluster.routing.TestShardRouting;
            engine.flush(true, true);
        ) {
        Engine.Index update_1 = new Engine.Index(newUid(doc), primaryTerm.get(), doc, 1);
            for (int i = 0; i < iterations && liveDocsFirstSegment.isEmpty() == false; i++) {
                        newUid(doc),
                if (op instanceof Engine.Index) {
/*
                for (int i = 0; i < numDocs; i++) {
            engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
                    engine = createEngine(store, translogPath);
        try (Engine.GetResult getResult = engine.get(newGet(true, doc), searcherFactory)) {
                .startObject()
            latch.countDown();
            thread[i].join();
            indexWriterFactory,
        final List<Exception> engineFailures = new CopyOnWriteArrayList<>();
            engine.ensureOpen();
            retry,
            }
            globalCheckpoint.set(numDocs + moreDocs - 1);
            boolean cfeCompoundFileFound = false;
            if (randomBoolean()) {
            .analyzer(config.getAnalyzer())
        });
            System.nanoTime(),
                            0
                    long seqNo = i;
                            AlreadyClosedException.class,
                .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
         * @param conf the configuration settings according to which IndexWriter should be initialized.
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
        MockDirectoryWrapper wrapper = newMockDirectory();
        final ParsedDocument doc = testParsedDocument(
            isRetry,
            int numDocs = between(maxDocs + 1, maxDocs * 2);
                false,
                testDocumentWithTextField(),
                    assertThat(result.getSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
                                        "Document " + docId + " should have updated value",
                    equalTo("searcher was not warmed up yet for source[test]")
            assertThat(seqNoGenerator.get(), equalTo(seqNo + 1));
        int numDocsToDelete = randomIntBetween(1, numDocs / 2);
            assertEquals(1, searcher.getIndexReader().numDocs());
            }
            assertEquals(1, engine.getNumVersionLookups());
     * {@code .doc} files, etc.).
            engine.refresh("test");
        final String syncId = randomUnicodeOfCodepointLengthBetween(10, 20);
                        engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        Engine.DeleteResult deleted = batchEngine.delete(
     * @param latchReference          to latch the thread for the purpose of stalling
        wrapper.failOn(fail);
                    throw new AssertionError(e);
        final AtomicReference<CountDownLatch> latchReference,
                }
        ) {
                        engine.flush();
            }
                assertThat(indexResult.getVersion(), equalTo(Versions.MATCH_ANY));
                settings.put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), randomLongBetween(0, 10));
                    throw (IOException) failure;
        }
            null,
            // Cleanup count will not be incremented whenever cleanup is disabled.
                    ? SequenceNumbers.NO_OPS_PERFORMED
                    assertEquals("Total number of operations", operations.size(), snapshot.totalOperations());
        final CyclicBarrier barrier = new CyclicBarrier(numIndexingThreads + 1);
        }
            final int numDocs = scaledRandomIntBetween(10, 100);
            final Bits bits = leaf.getLiveDocs();
        try (Translog.Snapshot snapshot = getTranslog(engine).newSnapshot()) {
                    assertSame(searcher.getIndexReader(), nextSearcher.getIndexReader());
                        operations.add(delete);
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(0));
        failEngine.join();
                        barrier.await(); // wait for all threads to start at the same time
                try (Engine.Searcher nextSearcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
                        long fileCount = Arrays.stream(store.directory().listAll())
                    startGun.await();
    public void testNoOpOnClosingEngine() throws Exception {
    // this test writes documents to the engine while concurrently flushing/commit
                        primaryTerm.get(),
        final Set<String> indexedIds = new HashSet<>();
                            String docId = ((Translog.Delete) operation).id();
                // even if doc is not not deleted, lastFieldValue can still be null if this is the
        final BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier = (ms, lcp) -> new LocalCheckpointTracker(
                // de-optimize. We also enabled GCDeletes which now causes pruning tombstones inside that refresh that is done internally
        engine.index(indexForDoc(testParsedDocument("0", null, testDocumentWithTextField(), SOURCE, null)));
            );
                Exception failure = failureToThrow.get().get();
        }
                        idToUpdate = Integer.toString(randomInt(numDocs - 1));
            armedFailure.set(new FailingBatchAppendTranslog.ArmedFailure(failure, failureClass));
                    if (randomBoolean()) {
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            10,
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), numDocs);
                    engine.index(indexForDoc(doc));
                    } catch (Exception e) {
                UNASSIGNED_SEQ_NO,
                    assertThat(result.isFound(), equalTo(docDeleted == false));
                assertEquals("deleted IDs are NOT YET pruned away", reader.numDocs() + 1, id.size());
                config(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null).toBuilder()
                            public BytesRef binaryValue() {
                    Engine.NoOpResult noOp = engine.noOp(
            });
                        -1,
                0,
            + expectedDeletes
                assertThat(warmedUpReaders, empty());
        }
                    addedToLucene.countDown();
            Assert.assertFalse(cfeCompoundFileFound);
                    defaultSettings,
                        engine.delete(replicaDeleteForDoc(id, 1L, seqNo, 0L));
                if (frequently()) {
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(1));
                            return reader.getReaderCacheHelper();
        MappedFieldType idFieldType = mock(MappedFieldType.class);
        document.add(new Field(SourceFieldMapper.NAME, BytesReference.toBytes(B_1), SourceFieldMapper.Defaults.FIELD_TYPE));
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            "1",
                searcherFactory
            Loggers.setLevel(rootLogger, savedLevel);
            searchResult,
        translog.add(new Translog.Index("SomeBogusId", 0, primaryTerm.get(), "{}".getBytes(Charset.forName("UTF-8"))));
        try (Store store = createStore(wrapper)) {
        );
                    localCheckpoint = primarySeqNo;
            try (InternalEngine engine = new InternalEngine(config)) {
    private MergePolicy newForceMergePolicy() {
                .flushMergesAfter(base.getFlushMergesAfter())
                        0
package org.opensearch.index.engine;
import java.util.function.ToLongBiFunction;
        ParsedDocument secondDoc = testParsedDocument("batch-2", null, testDocument(), B_2, null);
                    .put(IndexSettings.INDEX_CONTEXT_AWARE_ENABLED_SETTING.getKey(), true)
        )) {
                "1",
                    assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog()
        engine.onSettingsChanged(
            return super.addIndexes(dirs);
import org.opensearch.common.util.io.IOUtils;
                assertTrue("Local directory contains file " + file, localFiles.contains(file));
        latch.await();
        Engine.IndexResult indexResult = engine.index(create);
                            () -> engine.refresh("test", randomFrom(Engine.SearcherScope.values()), true)
            false,
                .put(defaultSettings.getSettings())
            EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(new TermQuery(new Term("value", "test")), 1)
     * A simple test to check that random combination of operations can coexist in segments and be lookup.
            }, "refresh-under-failed-batch-append");
                if (callStackContainsAnyOf("cleanUpUnreferencedFiles")) {
                    .put(IndexSettings.INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING.getKey(), generationThreshold + "b")
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            final ParsedDocument doc3 = testParsedDocument("3", null, testContextSpecificDocument("grouping_criteria"), B_1, null);
            try {
                engine.refresh("test");
                        assertEquals(
        for (int i = 0; i < numDocs; i++) {
                liveDocsFirstSegment.remove(idToUpdate);
            globalCheckpoint.set(
            });
            assertThat(getResult.exists(), equalTo(false));
            } else {
        assertThat(engine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(2));
            getTranslog(initialEngine).sync(); // to guarantee the global checkpoint is written to the translog
                boolean useRecoverySource = randomBoolean() || omitSourceAllTheTime;
        assertThat(batchEngine.getProcessedLocalCheckpoint(), equalTo(0L));
            }
            assertTrue(segments.get(0).compound);
            engine.flush();
        }
        try (Engine.GetResult getResult = engine.get(newGet(false, doc), searcherFactory)) {
            final List<IndexCommit> commits = DirectoryReader.listCommits(store.directory());
    public void testTranslogRecoveryWithMultipleGenerations() throws IOException {
    public void testShardNotAvailableExceptionWhenEngineClosedConcurrently() throws IOException, InterruptedException {
            VersionType.INTERNAL,
        SegmentInfos lastCommitInfo = engine.getLastCommittedSegmentInfos();
                        numDocs + numDocsToDelete + i,
            VersionType.INTERNAL,
            t.start();
                                        engine::acquireSearcher
        document.add(new TextField("value", "test1", Field.Store.YES));
            // now, optimize and wait for merges, see that we have no merge flag
                );
            UNASSIGNED_SEQ_NO,
            } else {
                        );
            assertThat(getResult.exists(), equalTo(true));
                        newUid(doc),
 * You may obtain a copy of the License at
        try (
        try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
        IOUtils.close(store, engine);
        Settings.Builder settings = Settings.builder()
                assertThat(
     * {@link EngineException} rooted in the tragic exception with nothing from the unwind masking it; the engine is
        // Realtime GET resolves the pending location (forcing the chunk) and observes the second version.
        final CheckedRunnable<IOException> checker = () -> {
            threads[i] = new Thread(() -> {
                    0,
                        int iters = randomIntBetween(1, 10);
        final int docs = randomIntBetween(1, 4096);
            for (int i = 0; i < 10; i++) {
        engine = new InternalEngine(engine.config());
                    .build()
                    }
            // Delete non-existent document
            engine.index(indexForDoc(doc));
        InternalEngine engine = createEngine(indexSettings, store, createTempDir(), newMergePolicy());
        @Override
            totalNumberOfDocsRefreshed += numDocs;
            List<Segment> segments = engine.segments(randomBoolean());
            boolean cfsCompoundFileFound = false;
                    lookupAndCheck.run();
            }
            settings.put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0);
        engine.ensureOpen();
            // IndexWriter can throw either IOException or IllegalStateException depending on whether tragedy is set or not.
            try (GatedCloseable<IndexCommit> wrappedSafeCommit = engine.acquireSafeIndexCommit()) {
            delete.versionType(),
                ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), B_1, null, useRecoverySource);
        assertThat(engine.getVersionMap().values(), hasSize(1));
            @Override
        InternalEngine batchEngine = spy(engine);
                    }
            noOpEngine.ensureOpen();
import org.apache.lucene.index.IndexFileNames;
            UNASSIGNED_SEQ_NO,
                            if (len == 0L) {
                    UNASSIGNED_SEQ_NO,
                        VersionType.INTERNAL,
                            ),
import org.opensearch.index.mapper.IdFieldMapper;
            1,
                }
        long localCheckpoint = SequenceNumbers.NO_OPS_PERFORMED;
        globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
                } else {
            Set<String> liveDocsFirstSegment = new HashSet<>();
                    // Verify we got all operations
                expectThrows(
                "performing [{}], v [{}], seq# [{}], term [{}]",
            assertThat(stats2.getId(), not(equalTo(stats1.getId())));
        assertTrue("safe access should be required we carried it over", engine.isSafeAccessRequired());
            REPLICA,
        // refresh and it should be deleted
        );
            InternalEngine engine = createEngine(
                    }
            }
                }
        try {
                        assertThat(r.getFailure().getCause(), instanceOf(MockDirectoryWrapper.FakeIOException.class));
                List<Engine.Operation> flushedOperations = new ArrayList<>();
                () -> engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID())
                    @Override
import static org.mockito.Mockito.verify;
        engine = createEngine(
            final List<DocIdSeqNoAndSource> docs;
        int totalNumberOfDocsRefreshed = 0;
            indexSettings.getTranslogRetentionAge(),
        store.close();
            })
                engine.flush();
        int numDocs = randomIntBetween(10, 100);
        final long maxTimestamp12 = Math.max(timestamp1, timestamp2);
            assertFalse(mockAppender.sawIndexWriterIFDMessage);
            UNASSIGNED_SEQ_NO,
            failureToThrow.set(null);
        );
                final long max = randomLongBetween(min, maxSeqNo);
                        VersionType.INTERNAL,
                            docID,
            );
        engine.flush();
                if ((flushed = randomBoolean())) {
        assertThat(indexResult.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        });
                Thread[] getters = new Thread[randomIntBetween(1, 4)];
        assertThat(operation, exception.getMessage(), containsString("but no document was found"));
                    UNASSIGNED_SEQ_NO,
        );
                -1,
                            idToDelete,
            if (randomBoolean() || true) {
            wrapper.setAllowRandomFileNotFoundException(randomBoolean());
        try (Store store = createStore()) {
        }
            engine = new InternalTestEngine(engine.config(), maxDocs, LocalCheckpointTracker::new);
            if (numSegments == 1) {
            - Translog.DEFAULT_HEADER_SIZE_IN_BYTES;
                int numDocsToUpdate = randomIntBetween(1, numDocs - deletedDocs.size());
            for (int i = 0; i < numIters; i++) {
                rarely() || localCheckpoint.get() == SequenceNumbers.NO_OPS_PERFORMED
            engine.flush();
            if (flushed) {
        final List<Engine.Operation> ops = generateSingleDocHistory(false, VersionType.EXTERNAL, 2, 100, 300, "1");
    }
        ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
            try (
        } else {
                assertEquals(gen2, store.readLastCommittedSegmentsInfo().getLastGeneration());
                }
            if (stall.get()) {
                // to ensure we de-optimize. One get call will purne and the other will try to lock the version map concurrently while
            final int numDocs = between(1, 10);
                if (randomBoolean()) {
    }
import java.nio.file.Path;
                        final TotalHitCountCollector collector = new TotalHitCountCollector();
                } catch (IOException e) {
            tombstones.removeIf(v -> v.seqNo < gapSeqNo && v.time < clock.get() - gcInterval);
            engine.index(new Engine.Index(newUid("0"), primaryTerm.get(), InternalEngineTests.createParsedDoc("0", null)));
            segments = engine.segments(true);
        assertVisibleCount(engine, docDeleted ? 0 : 1);
                : Versions.MATCH_DELETED;
                    ActionListener.wrap(countDownLatch::countDown)
                    .settings(
            PRIMARY,
            long prevLocalCheckpoint = SequenceNumbers.NO_OPS_PERFORMED;
        assertThat("Empty engine does not need flushing", engine.shouldPeriodicallyFlush(), equalTo(false));
            }
        InternalEngine batchEngine = spy(engine);
            };
        }
            settingBuilder.put(IndexSettings.INDEX_CONTEXT_AWARE_ENABLED_SETTING.getKey(), true);
        final ReferenceManager.RefreshListener refreshListener = new ReferenceManager.RefreshListener() {
        final Path storeDir = createTempDir();
        TranslogHandler translogHandler = createTranslogHandler(config.getIndexSettings(), engine);
                    }
import org.opensearch.action.index.IndexRequest;
            searchResult,
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
                        0,
                        getDocIds(engine, true).stream().collect(Collectors.toMap(e -> e.getId(), e -> e.getSeqNo())),
        assertThat(indexResult.getVersion(), equalTo(1L));
                            threadPool.relativeTimeInMillis(),
            assertEquals(0, engine.getNumVersionLookups());
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                                // Verify updated content using get
                    return; // all is well
        assertFalse(outcome.engineClosedAfterwards);
                    assertFalse(iterator.seekExact(Uid.encodeId("0")));
            testDocumentWithTextField(),
        final List<Engine.Operation> ops = generateSingleDocHistory(false, versionType, 2, 2, 20, "1");
    public void testRecoverFromForeignTranslog() throws IOException {
                primaryTerm = UNASSIGNED_PRIMARY_TERM;
            .entrySet()
                    index.uid(),
                )
        }
            engine.flush();
            noOpEngine = new InternalEngine(
        CountDownLatch startGun = new CountDownLatch(thread.length);
                    opsPerformed++;
            try (Store store = createStore()) {
        };
        replicaEngine.index(secondIndexRequestReplica);
            if (randomBoolean()) {
                final TotalHitCountCollector collector = new TotalHitCountCollector();
                        newUid(doc),
        final Phaser phaser = new Phaser(threads.length);
            }
            segments = engine.segments(true);
    }
        when(mapperService.fieldType(any())).thenReturn(null);
        final ParsedDocument doc = testParsedDocument(
            );
                .eventListener(base.getEventListener())
        }
                } else {
            UNASSIGNED_SEQ_NO,
                    // make sure localCheckpoint <= highest seq no found <= maxSeqNo
        engine.index(indexForDoc(doc));
            for (int i = 0; i < search.scoreDocs.length; i++) {
                assertEquals("updated", luceneDoc.get("value"));
            final ParsedDocument doc3 = testParsedDocument("3", null, testDocumentWithTextField(), B_1, null);
    }
                int from = randomIntBetween(0, operations.size() / 2);
                writer.flush();
                        )
            )
            engine.refresh("test", Engine.SearcherScope.INTERNAL, true);
                            VersionType.EXTERNAL,
        assertThat("The workload must produce uncommitted segment files", uncommittedBytes, greaterThan(0L));
        // The GET thread forced the deferred append, so the location is now assigned.
                        store.close();
            expectThrowsAnyOf(
                .warmer(base.getWarmer())
                    }
                gcpTracker.addPeerRecoveryRetentionLease(
                engine.index(indexForDoc(doc3));
        // we should not enable the periodically flush condition; otherwise we can get into an infinite loop of flushes.
                        seqNo,
            Loggers.setLevel(rootLogger, Level.TRACE);
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            outcome.refreshFailure,
            recoveringEngine.refresh("test");
            assertTrue(store.readLastCommittedSegmentsInfo().getGeneration() > gen1);
        // Mock MapperService so that PerFieldMappingPostingFormatCodec sees a non-null field
        public boolean sawIndexWriterIFDMessage;
                new Engine.Get(true, true, doc.id(), create.uid()).setIfSeqNo(indexResult.getSeqNo()).setIfPrimaryTerm(primaryTerm.get()),
                writer.forceMerge(1);
            "a non-tragic append failure must not fail the engine, but it was failed with reasons " + outcome.engineFailureReasons,
            @Override
                    while ((operation = snapshot.next()) != null) {
            2,
     * {@code FuzzyFilterPostingsFormat} to the {@code _id} field and the standard Lucene format to
            Set<String> localFiles = Set.of(store.directory().listAll());
                entry.getValue().countDown();
                        stop = true;
    public void testSequenceNumberAdvancesToMaxSeqOnEngineOpenOnPrimary() throws BrokenBarrierException, InterruptedException, IOException {
        }
                "test",
                try (IndexReader reader = DirectoryReader.open(commit)) {
                        Integer.toString(i),
                for (Thread getter : getters) {
        Thread indexing = new Thread(() -> {
                }
        Translog translog = new LocalTranslog(
        InternalEngine batchEngine = spy(engine);
        // refresh and it should be there
            protected void doRun() throws Exception {
                    engine.flush(randomBoolean(), true);
        MatcherAssert.assertThat(searchResult, EngineSearcherTotalHitsMatcher.engineSearcherTotalHits(1));
                                        document.getField("value").stringValue()
                        engine.flushAndClose();
        engine.flush(false, false);
import org.apache.lucene.document.KeywordField;
     * Opening a scope on a closed engine is refused with the same {@link AlreadyClosedException} its first append would
                final GatedCloseable<SegmentInfos> snapshotAfterFlush = engine.getSegmentInfosSnapshot();
            CheckedRunnable<IOException> lookupAndCheck = () -> {
            mapping = XContentFactory.jsonBuilder()
        } else {
            engine.index(indexForDoc(doc2));
            )
            final ParsedDocument doc1 = testParsedDocument("1", null, testContextSpecificDocument("grouping_criteria"), B_1, null);
                        engine.ensureOpen();
            }
            initialEngine = createEngine(
        }
        final Set<String> liveDocs = new HashSet<>();
                    int count = 0;
                }
    }
                    Settings.builder().put(indexSettings.getSettings()).put(IndexSettings.INDEX_UNREFERENCED_FILE_CLEANUP.getKey(), false)
                    } while (deletedDocs.contains(idToUpdate) || updatedDocs.contains(idToUpdate));
            assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().getMinFileGeneration(),
        );
            return super.addDocument(doc);
            final Engine.IndexResult deferred = batchEngine.index(
            }
                    globalCheckpoint.set(randomLongBetween(globalCheckpoint.get(), engine.getPersistedLocalCheckpoint()));
            assertEquals(1, topDocs.totalHits.value());
                assertNull(indexResult.getTranslogLocation());
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            int appends = 0;
                    } catch (IOException e) {
    /**
        return LongPoint.decodeDimension(max, 0);
                index(engine, i);
        mergeThread.join();
                for (final long seqNo : seqNos) {
        }
                false,
        final AtomicLong clock = new AtomicLong(0);
                searcher.search(new TermQuery(new Term("value", lastFieldValue)), collector);
            index.primaryTerm(),
                            // this is a hack to add a failure during store document which triggers a tragic event
        );
    public void testSkipTranslogReplay() throws IOException {
        final List<Engine.Operation> operations = new ArrayList<>();
        Engine.IndexResult result = batchEngine.index(op);
            }
                        cleanupCompleted.countDown();
                    final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
            testDocumentWithTextField(),
                if (expectedLocalCheckpoint.get() + 1 == seqNo) {
                            Long.parseLong(commits.get(i).getUserData().get(SequenceNumbers.MAX_SEQ_NO)),
                            .filter(file -> file.equals("write.lock") == false && ExtrasFS.isExtra(file) == false)
        try (Translog.Snapshot snapshot = getTranslog(engine).newSnapshot()) {
            Engine engine = createEngine(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null, null, null, indexSort, null)
                        -1,
                    final long highestSeqNo;
        engine.refresh("test");
                if (randomBoolean()) {
                        }
                .recoverFromTranslog(translogHandler, recoveringEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
 * The OpenSearch Contributors require contributions made to
        final List<Engine.Operation> opsDoc2 = generateSingleDocHistory(
        }
                        allowMarkProcessed.await();
        }
                engine.index(indexForDoc(createParsedDoc(Integer.toString(i), null)));
                    } else {
        int numDocsToDelete = randomIntBetween(1, numDocs / 2);
                new BytesArray("{}".getBytes(Charset.defaultCharset())),
        engine.index(indexForDoc(doc));
        } else {
                randomBoolean(),
        final Path translogDir = createTempDir();
        IndexSettings indexSettings = new IndexSettings(
            final List<Segment> segments = engine.segments(false);
        } catch (Exception ex) {
                    // fine
                    );
            @Override
                public void onFailure(Exception e) {
                    }
                    : UNASSIGNED_SEQ_NO;
            1,
        ) {
                        engine.flush();
        try {
        final LongSupplier globalCheckpointSupplier = () -> globalCheckpoint.get();
        }
            .flushMergesAfter(config.getFlushMergesAfter())
        if (lastFieldValueDoc1 != null) {
            final int numIndexingThreads = scaledRandomIntBetween(2, 4);
                case NO_OP:
        Set<String> currentValues = new HashSet<>();
import static org.hamcrest.Matchers.empty;
        // also in non realtime
                NoMergePolicy.INSTANCE,
                } else {
    public void testRetryConcurrently() throws InterruptedException, IOException {
            0
            .put("index.refresh_interval", -1);
     * failed exactly once, with the tragic exception itself as the recorded failure; the engine is closed afterwards.
                latchReference.set(latch);
        }
        };
            try (IndexReader reader = DirectoryReader.open(wrappedSnapshot.get())) {
                    final Engine.IndexResult result;
        Collections.shuffle(docs, random());
        doc = testParsedDocument("1", null, document, B_2, null);
            assertThat(indexResult.getResultType(), equalTo(Engine.Result.Type.FAILURE));
            recoveringEngine.translogManager()
        final CountDownLatch cleanupCompleted = new CountDownLatch(1);
        // Stale operations skipped by Lucene but added to translog - still able to flush
        MockAppender mockAppender = new MockAppender("testIndexWriterInfoStream");
        Engine.IndexResult indexResult = engine.index(firstIndexRequest);
            engine.index(indexForDoc(doc));
                    Document document = testDocument();
                }
            return iw.get();
                            assertNotNull(msg, docIdAndSeqNo);
                    engine.index(update);
                        DocIdAndSeqNo docIdAndSeqNo = VersionsAndSeqNoResolver.loadDocIdAndSeqNo(searcher.getIndexReader(), newUid(id));
            int deletes = 0;
            engine.close();
        }
            "engine shouldn't start without a valid translog id",
        // bulk layer keeps the greater of the two (see BulkPrimaryExecutionContext#mergeLocationToSync).
        }
                ParsedDocument doc = testParsedDocument("dummy", null, testDocument(), B_1, null, useRecoverySource);
        Engine.Index create = new Engine.Index(newUid(doc), primaryTerm.get(), doc, Versions.MATCH_DELETED);
                assertThat(segment.getMergeId(), nullValue());
                final ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), SOURCE, null);
                engine.flush();
import org.opensearch.index.translog.TestTranslog;
    }
                    docDeleted = false;
            }
     * Verifies that a segment containing only no-ops can be used to look up _version and _seqno.
                });
                    public void afterRefresh(boolean didRefresh) {
import org.opensearch.index.engine.Engine.IndexResult;
    public void testBatchedIndexThenInlineDeleteFlushesPendingChunkFirst() throws Exception {
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        Engine.TranslogBatch batch = batchEngine.beginTranslogBatch();
                engine.translogManager().rollTranslogGeneration();
            Engine.Index index = (Engine.Index) lastOp;
        Engine.Index update = indexForDoc(doc);
                    assertEquals(
                        0
        Engine.Searcher searchResult = engine.acquireSearcher("test");
            final Document document = testDocumentWithTextField();
                    assertThat(result.getFailure(), nullValue());
                System.nanoTime(),
                    operations.add(update);
            }
                }
        }
            .put(defaultSettings.getSettings())
                    // generate a conflict
        }
                    }) {
                assertFalse("file_sizes must not be empty when include_segment_file_sizes=true", fileSizes.isEmpty());
                );
        final Engine.Operation lastOp = ops.get(ops.size() - 1);
                    startGun.await();
                if (randomBoolean()) {
        // making it straightforward to compare the expected total (sum of file lengths from the
            indexer.start();
                        engine.ensureOpen();
            operation.id(),
            1,
        store = createStore();
            index.parsedDoc(),
        );
                    ParsedDocument doc = testParsedDocument(idToUpdate, null, document, null, null);
                    reader -> new FilterDirectoryReader(reader, new FilterDirectoryReader.SubReaderWrapper() {
                    null
        if (docDeleted == false) {
    public void testPruneAwayDeletedButRetainedIds() throws Exception {
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
            assertThat(
                defaultSettings,
        if (Lucene.indexExists(directory) == false) {
                engine.index(indexForDoc(doc));
import org.apache.lucene.index.IndexWriter;
                for (int j = 0; j < numStarts; j++) {
                    deletes++;
                retryIndex = appendOnlyReplica(doc, true, i, i * 2);
        }
                            Translog.Index indexOp = (Translog.Index) operation;
    public void testSegmentsWithNestedFieldIndexSort() throws Exception {
import org.apache.lucene.search.IndexSearcher;
                // test index with document failure
                engine.index(doc3);
import static org.opensearch.index.engine.Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY;
                            System.nanoTime(),
                        primaryTerm.get(),
        assertEquals(engine.config().getCodec().getName(), codecService.codec(codecName).getName());
                assertThat(minRetainSeqNos, lessThanOrEqualTo(globalCheckpoint.get() + 1));
        // The NRT SegmentInfos should still carry the LAST COMMITTED userData (translog anchor preserved).
        }
                try {
        );
        index = new Engine.Index(
import org.opensearch.index.seqno.SequenceNumbers;
     * the owning bulk fails at {@code finish()}, nobody else does.
    }
            Engine engine = createEngine(config(indexSettings, store, createTempDir(), keepSoftDeleteDocsMP, null))
        nonInternalVersioning.remove(VersionType.INTERNAL);
                super.markSeqNoAsProcessed(seqNo);
            }
        Engine.IndexResult first = batchEngine.index(indexForDoc(v1));
                engineClosed.countDown();
            assertThat(segments.size(), equalTo(2));
        Engine.Index duplicate = replicaIndexForDoc(doc, 1, 20, true);
                retentionLeasesHolder::get,
        Translog.Location max = batch.finish();
        ParsedDocument doc = testParsedDocument("batch-flush", null, testDocument(), B_1, null);
        );
            IOUtils.close(initialEngine);
            assertThat(
                        throw new AssertionError(e);
        assertThat(first.getTranslogLocation(), notNullValue());
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
                        primarySeqNo++;
                assertEquals(docs, topDocs.totalHits.value());
                                    assertTrue("Document " + docId + " should exist", get.exists());
    public void testGetIfSeqNoIfPrimaryTerm() throws IOException {
                                    return in.getCoreCacheHelper();
                primaryTerm = primaryTerms.longValue();
                    @Override
        ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
                2,
            -1,
                        // simulate close by corruption
        expectThrows(IllegalStateException.class, engine.translogManager()::ensureCanFlush);
            Engine.Index index1 = new Engine.Index(
    }
                try {
            int docId = 0;
                    }
        try (Engine.GetResult get = engine.get(new Engine.Get(true, false, doc.id(), uidTerm), searcherFactory)) {
            System.nanoTime(),
            testDocumentWithTextField("test"),
            defaultSettings.getScopedSettings()
                config(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get)
            engine.flush();
            try (Engine.GetResult get = batchEngine.get(new Engine.Get(true, true, doc.id(), op.uid()), batchEngine::acquireSearcher)) {
        engine.close();
        Thread[] thread = new Thread[randomIntBetween(3, 5)];
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
                doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, 1));
                }
        }
        ParsedDocument firstDoc = testParsedDocument("batch-1", null, testDocument(), B_1, null);
                "test",
                UNASSIGNED_SEQ_NO,
            newUid(doc),
        CountDownLatch latch = new CountDownLatch(2);
        }
                                        new Engine.Get(true, true, docId, newUid(docId)),
                    assertEquals("Expected number of operations", operations.size(), count);
                        UNASSIGNED_SEQ_NO,
            }
            Set<String> attributes = segments.stream().map(segment -> segment.getAttributes().get(BUCKET_NAME)).collect(Collectors.toSet());
            thread.join();
            engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            Engine.Operation.Origin.PRIMARY,
                try {
        try (Translog.Snapshot snapshot = getTranslog(engine).newSnapshot()) {
            if (docIdAndSeqNo == null) {
            assertEquals(numDocsOnReplica, recoveringEngine.translogManager().getTranslogStats().getUncommittedOperations());
            TopDocs search = searcher.search(new MatchAllDocsQuery(), 1);
        assertThat(indexResult.getVersion(), equalTo(1L));
    }
        assertVisibleCount(engine, numDocs, true);
        final List<Engine.Operation> operations = new ArrayList<>();
                searcherFactory
                engine.index(indexForDoc(doc2));
                        REPLICA,
                    shardId,
                }
                        i,
    }
                    engine.index(operation);
            if (rarely()) {
            mockAppender.stop();
                config.getTranslogConfig().getTranslogPath(),
        if (randomBoolean()) {
                    0
import org.apache.lucene.index.StoredFields;
                }
    private ParsedDocument createDocumentWithNestedField(String id, String contactName, int contactAge) {
            doc,
        final ParsedDocument doc = testParsedDocument(docId, null, testDocumentWithTextField(), SOURCE, null);
            protected IndexingStrategy indexingStrategyForOperation(Index index) throws IOException {
            assertEquals(1, topDocs.totalHits.value());
            );
            searchResult,
        );
            }
                if (docDeleted) {
        );
        when(threadPool.relativeTimeInMillis()).thenAnswer(invocation -> clock.get());
            engine.flush(false, randomBoolean());
            List<IndexCommit> commits = DirectoryReader.listCommits(store.directory());
                    }
            // This works for regular scenario because merges are triggered by preparePointInTimeMerge by refresh, which is a blocking
                } catch (Exception e) {
            TranslogHandler translogHandler = createTranslogHandler(initialEngine.config().getIndexSettings(), recoveringEngine);
                final int length = randomIntBetween(0, 8);
            final LeafReader leaf = leaves.get(i).reader();
                // local checkpoint and max seq no shouldn't go backwards
                    indexSettings.getTranslogRetentionTotalFiles()
            if (op instanceof Engine.Index) {
    // and ensuring that the commit points contain the correct sequence number data
        engine = createEngine(config(defaultSettings, store, translogPath, newMergePolicy(), null, null, globalCheckpointSupplier));
            lastFieldValueDoc1 = null;
                );
            });
        assertThat(operation, result.getFailure(), Matchers.instanceOf(VersionConflictEngineException.class));
            String id = Integer.toString(between(1, 50));
        }
import org.opensearch.common.compress.CompressedXContent;
        assertEquals(numDocs, translogHandler.appliedOperations());
            segments = engine.segments(true);
        long lastOpVersion = currentOpVersion;
                case INDEX:
            }
            null
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        policy.setMinMergeDocs(10000);
            Map<Long, Translog.Operation> ops = readAllOperationsInLucene(engine).stream()
            .getGeneration();
                        VersionType.EXTERNAL,
                    "restore from local translog must not add operations to translog",
        Engine.TranslogBatch batch = indexer.beginTranslogBatch();
                .endObject()
                final Map<String, String> userData = finalActualEngine.commitStats().getUserData();
                assertThat(engine.shouldPeriodicallyFlush(), equalTo(false));
            )
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            0,
            )
            );
            assertEquals(primarySeqNo, initialEngine.getSeqNoStats(-1).getMaxSeqNo());
        final CyclicBarrier barrier = new CyclicBarrier(2);
                        cleanupCompleted.countDown();
        while (iter1.hasNext() && iter2.hasNext()) {
            // Global checkpoint advanced enough - only the last commit is kept.
import static org.mockito.Mockito.atLeastOnce;
            VersionType.INTERNAL,
            Engine.Index index = indexForDoc(doc);
            indexSettings.updateIndexMetadata(IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build());
        try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
        engine = new InternalEngine(config);
        }
            .put(defaultSettings.getSettings())
                    engine.flush(randomBoolean(), true);
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
                assertThat(getDocIds(engine, true), equalTo(prevDocs));
                } else if (failure instanceof IOException) {
                // Test snapshot with all operations
                config(indexSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get)
            final long seqNo = engine.getProcessedLocalCheckpoint() + 1;
            initialEngine = createEngine(defaultSettings, store, createTempDir(), newLogMergePolicy(), null);
                    Engine.Index update = new Engine.Index(
        Sort indexSort = new Sort(new SortedSetSortField("foo", false));
            final String reason = "filling gaps";
        engine.close();
        Engine.Delete delete = new Engine.Delete(
        assertLuceneOperations(engine, numDocs, 0, 0);
            ) {
        ) {
                final Map<BytesRef, Engine.Operation> deletesAfterCheckpoint = new HashMap<>();
            Engine.IndexResult indexResult = engine.index(firstIndexRequest);
            }
        }
                    }
        ) {
        IOUtils.close(store, engine);
import org.apache.logging.log4j.Level;
                assertVisibleCount(engine, docDeleted ? 0 : 1);
                }
            }
                        UNASSIGNED_SEQ_NO,
            Versions.MATCH_DELETED,
        indexResult = replicaEngine.index(index);
        AtomicReference<IOException> addDocException = new AtomicReference<>();
            mockAppender.addExpectation(
import org.opensearch.common.collect.Tuple;
                                    i++;
                if (rarely()) {
            -1,
        for (int i = 0; i < leftLeaves.size(); i++) {
            document.add(new TextField("value", "test1", Field.Store.YES));
            () -> new MatchAllDocsQuery(),
        // and the version lookup is skipped
                        -1,
            public long addDocument(Iterable<? extends IndexableField> doc) throws IOException {
                Settings.builder()
     * increasing locations and the translog carries both in request order.
            translogPath,
        MockDirectoryWrapper wrapper = newMockDirectory();
            TranslogHandler translogHandler = createTranslogHandler(configSupplier.apply(store).getIndexSettings(), engine);
        ParsedDocument doc = testParsedDocument("batch-refresh", null, testDocument(), B_1, null);
            assertLuceneOperations(engine, 1, create ? 0 : 1, 0);
                initialEngine.translogManager().syncTranslog(); // to advance persisted local checkpoint
        List<LeafReaderContext> leftLeaves = OpenSearchDirectoryReader.unwrap(left.getDirectoryReader()).leaves();
            SegmentsStats stats = engine.segmentsStats(true, false);
        engine.clearUncommittedSegmentBytes();
                null,
                final String id = Integer.toString(i);
                    thread.join();
    public void testTrackMaxSeqNoOfUpdatesOrDeletesOnPrimary() throws Exception {
        String message = "Lucene operations mismatched;"
        try {
            EngineConfig engineConfig = createEngineConfigWithMapperSupplierForDerivedSource(store, true);
                    break;
                        Engine.Operation.Origin.PRIMARY,
            engine.refresh("test");
            2,
                            throw new AssertionError(e);
            final AtomicReference<Throwable> refreshOutcome = new AtomicReference<>();
                if (op instanceof Engine.Index) {
                Arrays.asList(IOException.class, IllegalStateException.class),
            final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                    try {
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10);
            index.isRetry(),
        MatcherAssert.assertThat(
    public void testUpdateWithFullyDeletedSegments() throws IOException {
            delete.versionType(),
                            assertTrue("Document " + docId + " should be in deleted set", deletedDocs.contains(docId));
            "the drainer's refresh must not fail because of another request's append, but threw "
            "2"
            int count = searcher.count(new MatchAllDocsQuery());
        Engine.Index operation = randomBoolean()
                engine.config(),
        assertThat(
                store,
                new BytesArray("{}".getBytes(Charset.defaultCharset())),
            .settings(
        });
        try (InternalEngine recoveringEngine = new InternalEngine(initialEngine.config())) {
        final List<Thread> indexingThreads = new ArrayList<>();
            searchResult,
                    operationsInSafeCommit = commits.get(i);
        ) {
        );
                    throw new AssertionError(e);
                int from = randomIntBetween(0, operations.size() / 2);
            public void markSeqNoAsProcessed(long seqNo) {
                    if (randomInt(100) < 10) {
                    createTempDir(),
        }
                    assertThat(result.getVersion(), equalTo(lastOpVersion));
        final long seqNo = randomLongBetween(0, 1000);
            lastFieldValueDoc1 = index.docs().get(0).get("value");
        } finally {
                    if (result.getResultType() == Engine.Result.Type.SUCCESS) {
        ) {
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get);
        engine.ensureOpen();
            delete.id(),
        assertEquals(currentIndexWriterConfig.getCodec().getName(), codecService.codec(codecName).getName());
                 */
            .threadPool(config.getThreadPool())
                writer.updateNumericDocValue(new Term(IdFieldMapper.NAME, "1"), Lucene.SOFT_DELETES_FIELD, 1);
            assertEquals(1, topDocs.totalHits.value());
            store,
                    break;
            org.apache.lucene.document.Document luceneDoc = searcher.storedFields().document(search.scoreDocs[0].doc);
            ParsedDocument doc = testParsedDocument("cap-" + i, null, testDocument(), B_1, null);
        try (Engine.GetResult getResult = engine.get(newGet(true, doc), searcherFactory)) {
            assertThat(refreshCounter.get(), equalTo(initialRefreshCount + 1L));
        try (
        }
            InternalEngine engine = createEngine(
                } catch (AlreadyClosedException ex) {
                        PRIMARY,
        final Set<VersionType> nonInternalVersioning = new HashSet<>(Arrays.asList(VersionType.values()));
            assertThat(stats2.getGeneration(), greaterThan(stats1.getGeneration()));
                .put(defaultSettings.getSettings())
                    engineClosed.await();
            long unreferencedFileCleanUpsPerformed = engine.unreferencedFileCleanUpsPerformed();
        AtomicBoolean running = new AtomicBoolean(true);
                    delete.primaryTerm(),
        engine = createEngine(store, createTempDir());
                if (rarely()) {
        MockDirectoryWrapper.Failure fail = new MockDirectoryWrapper.Failure() {
        MockAppender mockAppender = new MockAppender("testIndexWriterIFDInfoStream");
        ParsedDocument v2 = testParsedDocument("upd", null, testDocument(), B_2, null);
            final ParsedDocument doc3 = testParsedDocument("1", null, testContextSpecificDocument("grouping_criteria"), B_1, null);
                    createTempDir(),
                        0
                            }
                    assertThat(result.isFound(), equalTo(docDeleted == false));
            }
        Function<Engine.Delete, Engine.Delete> deleteWithCurrentTerm = delete -> new Engine.Delete(
        // _seq_no are stored as doc values for the time being, so this is how we get them
        engine.index(indexForDoc(doc));
                config(indexSettings, store, createTempDir(), newMergePolicy(), null, null, globalCheckpoint::get)
        engine.index(indexForDoc(doc));
        }
                            assertAndGetInternalTranslogManager(engine.translogManager()).getTranslogUUID(),
    public void testEngineBackedIndexerForwardsBeginTranslogBatch() throws Exception {
                    } finally {
            term
            CountDownLatch start = new CountDownLatch(1);
            System.nanoTime(),
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
    public void testGetMaxSeqNoFromSegmentInfos() throws IOException {
            results.add(batchEngine.index(indexForDoc(doc)));
                        count++;
                PRIMARY,
            });
import org.opensearch.index.store.Store;
        engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                @Override
    }
            assertThat(segments.get(1).getNumDocs(), equalTo(updates + appends));
                Integer.toString(i),
            assertEquals(1, engine.getNumVersionLookups());
            engine.refresh("test");
            }
                        System.nanoTime(),
            engine.index(indexForDoc(doc3));
        engine.index(indexForDoc(doc));
            InternalEngine engine = createEngine(
                            throw new AssertionError(e);
                allocationId
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    public void testRefreshScopedSearcher() throws IOException {
                engine.flush();
            .eventListener(config.getEventListener())
        final AtomicLong maxSeqNo = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            final BytesReference source = new BytesArray(new byte[] { 1 });
            // Bulk thread: open a scope and leave one deferred index op pending in it.
            indexResult.getVersion(),
                            seqNo,
                        assertThat(msg, ((Translog.Index) op).id(), is(in(liveDocs)));
            assertThat(segments.isEmpty(), equalTo(true));
            public void beforeRefresh() {
import java.util.concurrent.atomic.AtomicReference;
                        // If the global checkpoint is still unassigned, we keep an empty(eg. initial) commit as a safe commit.
                    numDocsOnReplica++;
                @Override
                    )
                            assertTrue("Document " + docId + " should be in deleted set", deletedDocs.contains(docId));
                .endObject()
                // we should have had just 1 merge, so last generation should be exact
            newUid(doc),
                        VersionType.INTERNAL,
                        primaryTerm.get(),
            engine.refresh("test");
        engine.updateUncommittedSegmentBytes(localSegmentsSizeMap, 1L);
                    );
            0,
            for (Segment segment : preMergeSegments) {
            indexSettings.updateIndexMetadata(indexMetadata);
            assertThat(commits.get(0).getUserData().get(SequenceNumbers.MAX_SEQ_NO), equalTo(Long.toString(safeMaxSeqNo)));
        assertNotNull(committedUserData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
     * @return returns a merge policy which only supports force merge.
                                    assertTrue("Document " + docId + " should exist", get.exists());
                }
                final SegmentInfos segmentInfos = snapshotAfterFlush.get();
                    applyOperation(engine, op);
            VersionUtils.getPreviousMinorVersion(),
    }
                );
                    if (rarely()) {
                    throwingIndexWriter.get().setThrowFailure(() -> new IOException("simulated"));
            ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
        // extensions, which is exactly the condition that exposed the map.put() bug.
import org.apache.lucene.index.Term;
                UNASSIGNED_SEQ_NO,
        long autoGeneratedIdTimestamp = 0;
                    }
                }
                        i,
            translog.location(),
                }
                Engine.Operation.Origin.PRIMARY,
                        newUid(doc),
                retryIndex = appendOnlyPrimary(doc, true, i, create);
            if (failureToThrow.get() != null) {
    /*
            allOps.add(seqNoUpdater.apply(next, seqNoGenerator.getAndIncrement()));
                        numDeletes.incrementAndGet();
            null
                        result = engine.index(indexWithSeq.apply(conflictingSeqNo, conflictingTerm, index));
                .collect(Collectors.toMap(Translog.Operation::seqNo, Function.identity()));
        final int docs = randomIntBetween(1, 32);
            super(d, conf);
        indexResult = replicaEngine.index(create);
                                    assertEquals(
                for (int i = 0; i < numDocsToDelete; i++) {
            true,
                    assertThat(result.getSeqNo(), equalTo(seqNo));
import org.opensearch.test.VersionUtils;
            engine.config().setEnableGcDeletes(true);
        try (
import static org.hamcrest.Matchers.hasItem;
    /**
                } catch (RefreshFailedEngineException ex) {
            }
            autoGeneratedIdTimestamp,
            assertThat(getResult.exists(), equalTo(true));
            null,
                    updates++;
        // (as opposed to using an IndexSearcher or IndexReader)
            maybeThrowFailure();
                        "1",
        // became searchable.
    public void testOutOfOrderDocsOnReplica() throws IOException {
                config.getTranslogConfig().getShardId(),
            segments = engine.segments(false);
        IOUtils.close(store, engine);
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
        if (randomBoolean()) {
 * KIND, either express or implied.  See the License for the
     * @return a store where directory is closed when referenced while unreferenced file cleanup.
            delete.id(),
        Engine.Index retry = appendOnlyPrimary(doc, true, 1, create);
        try (
    public void testGetSegmentInfosSnapshot_LatestCommitOnDiskHasHigherGenThanReader() throws Exception {
            );
                        List<String> values = new ArrayList<>(Strings.commaDelimitedListToSet(visitor.source().utf8ToString()));
        );
                        engine.flush(randomBoolean(), true);
                rarely() || maxSeqNo.get() == SequenceNumbers.NO_OPS_PERFORMED
                assertThat(
        );
import org.opensearch.index.shard.IndexShard;
            ParsedDocument doc = createParsedDoc(Integer.toString(between(1, 100)), null);
            assertEquals(docs - 1, engine.getProcessedLocalCheckpoint());
                // first index an append only document and then delete it. such that we have it in the tombstones
        Iterator<Engine.Operation> iter2 = opsDoc2.iterator();
        refresher.start();
        IOException failure,
    public void testMaxDocsOnReplica() throws Exception {
                            int i = 0;
        }
     * </ul>
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
            int deletes = 0;
                    assertEquals("Total number of operations", operations.size(), snapshot.totalOperations());
                    version = operations.get(i).version();
            )
                    engine.index(index);
            replicaEngine,
            assertThat(mergedSegments.get(0).getSegmentSort(), equalTo(indexSort));
        engine.onSettingsChanged(TimeValue.MINUS_ONE, ByteSizeValue.ZERO, randomNonNegativeLong());
                        PRIMARY,
    @LockFeatureFlag(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG)
        }
 * this work for additional information regarding copyright
                if (versionConflict) {
            engine.refresh("test");
            while (running.get() && seqNo <= 1000) {
            if (randomBoolean()) {
                                )
                                throw new UncheckedIOException(new MockDirectoryWrapper.FakeIOException());
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        @Override
        }
                }
        final long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
            new BytesArray("{}".getBytes(Charset.defaultCharset())),
        engine.index(indexForDoc(createParsedDoc("2", null)));
                }
                .field("name", contactName)
                globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
                .indexSettings(indexSettings)
                return new Engine.Delete(
                        seqNos.get(i),
            }
            if (randomBoolean()) {
                    System.nanoTime(),
        engine.updateUncommittedSegmentBytes(localSegmentsSizeMap, 1L);
                    .build()
                        assertThat(result.getSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
 * not use this file except in compliance with the License.
            randomFrom(VersionType.INTERNAL, VersionType.EXTERNAL),
                Settings.builder()
            badUUID,
        );
                final Engine.Delete delete = (Engine.Delete) op;
        final long gcInterval = randomIntBetween(0, 10);
        assertFalse(updateResult.isCreated());
     * Parity with {@code DataFormatAwareEngine}: a flush must drain every live batch before committing, so the local
            for (final Thread thread : threads) {
                }
                    assertThat(noOp.getSeqNo(), equalTo(seqNo));
import org.opensearch.common.unit.TimeValue;
                ParsedDocument doc = testParsedDocument(id, null, testDocument(), B_1, null);
            }
        Engine.Searcher searchResult = engine.acquireSearcher("test");
            assertThat(engine.segmentsStats(true, false).getFileSizes().get(firstEntry.getKey()), greaterThan(firstEntry.getValue()));
            + " updates [actual:"
                        assertTrue(ex.toString(), ex.getCause() instanceof MockDirectoryWrapper.FakeIOException);
    public void testCleanupCommitsWhenReleaseSnapshot() throws Exception {
        isRetry = true;
                0
            doc,
        return out;
        engine.refresh("test");
            0
                    assertThat(highestSeqNo, lessThanOrEqualTo(maxSeqNo));
        while (current != null) {
        assumeFalse("who tests the tester?", VERBOSE);
                primaryTranslogDir,
        }
            .circuitBreakerService(new NoneCircuitBreakerService())
                        null, // No source, it should be derived
            clock.set(randomLongBetween(gcInterval, deleteBatch + gcInterval));
            closingThreads[i] = new Thread(new AbstractRunnable() {
            IndexMetadata.builder(indexSettings.getIndexMetadata())
                }
            AtomicReference<AddIndexesFailingIndexWriter> throwingIndexWriter = new AtomicReference<>();
                defaultSettings,
        ) {
                        newUid(document2),
            engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
                if (numDocs == 1) {
import org.opensearch.core.action.ActionListener;
        Engine.Index retry = appendOnlyReplica(doc, true, 1, randomIntBetween(0, 5));
            Loggers.removeAppender(rootLogger, mockAppender);
                                throw new AssertionError("Document does not have a seq number: " + docID);
        ParsedDocument doc = testParsedDocument("1", null, document, B_1, null);
        assertThat(rootCause(outcome.refreshFailure), sameInstance(tragic));
                    1,
        } else {
            docs.add(index);
            assertThat(noOp.primaryTerm(), equalTo(primaryTerm.get()));
        Sort indexSort = new Sort(new SortedSetSortField("foo1", false));
            // sequence numbers start at zero, so the expected local checkpoint is the number of successful operations minus one
                )
                    if (op instanceof Translog.Index) {
        final AtomicLong lastSyncedGlobalCheckpointBeforeCommit = new AtomicLong(Translog.readGlobalCheckpoint(translogPath, translogUUID));
            assertThat(mergedSegments.size(), equalTo(1));
            final String formattedMessage = event.getMessage().getFormattedMessage();
            engine.config().setEnableGcDeletes(false);
        try (GatedCloseable<SegmentInfos> snapshot = engine.getSegmentInfosSnapshot()) {
            }
            // Get should not find the document (we never indexed uid=2):
        getThread.start();
                LocalCheckpointTracker::new,
                    cfsCompoundFileFound = true;
        }
        );
                        UNASSIGNED_SEQ_NO,
            };
                );
                        equalTo(assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().currentFileGeneration())
                        }
        final MapperService mapperService = createMapperServiceForContextAwareIndex();
                        if (liveOps.containsKey(id) == false) {
        engine.close();
                indexSettings.getSoftDeleteRetentionOperations()
            restoreIndexWriterMaxDocs();
            );
        wrapper.failOn(fail);
                System.nanoTime(),
        ) {
                }
            if (current.getCause() != null && current.getCause() != current) {
                    });
                            try (
        mockAppender.start();
                        + op.id()
                .recoverFromTranslog(translogHandler, recoveringEngine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                if (docDeleted == false && lastFieldValue != null) {
        assertThat(cap, equalTo(TranslogBatchScope.DEFAULT_MAX_OPERATIONS));
            } else {
            assertThat(deferred.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
     * @return a sequence number generator
import org.apache.lucene.index.IndexWriterConfig;
            assertThat(unreferencedFileCleanUpsPerformed, equalTo(1L));
                store.associateIndexWithNewTranslog(translogUUID);
            try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.EXTERNAL)) {
            ParsedDocument doc = testParsedDocument("1", null, document, B_1, null);
            }
            assertThat(segments.isEmpty(), equalTo(true));
                .internalRefreshListener(base.getInternalRefreshListener())
        assertThat(updateResult.getVersion(), equalTo(2L));
                index(engine, docId);
                stall.set(randomBoolean());
        assumeFalse("who tests the tester?", VERBOSE);
        }
        ) {
         */
        final Directory directory = store.directory();
            0
        try {
        );
        }
            assertThat(indexResult.getVersion(), equalTo(1L));
                        PRIMARY,
            }
            assertFalse("safe access should NOT be required last indexing round was only append only", engine.isSafeAccessRequired());
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
            engine.refresh("test");
            assertLuceneOperations(engine, 1, 0, 1);
        InternalEngine noOpEngine = null;
        Throwable current = t;
    }
            }
                assertThat(e.getCause().getMessage(), equalTo("power's out"));
            engine = new InternalTestEngine(engine.config(), maxDocs, LocalCheckpointTracker::new);
            engine.advanceMaxSeqNoOfUpdatesOrDeletes(2);
        engine.refresh("warm_up");
            } catch (Exception e) {
        engine = createEngine(store, primaryTranslogDir, inSyncGlobalCheckpointSupplier);
        InternalEngine initialEngine = null;
                            assertThat(values.longValue(), lessThanOrEqualTo(globalCheckpoint.get()));
            final long minSeqNoToRetain;
        translogHandler = createTranslogHandler(engine.engineConfig.getIndexSettings(), engine);
            // this is just to make sure that refresh post flush has the same impact.
                doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, -1));
                    }
            null,
        AtomicInteger offset = new AtomicInteger(-1);
                }
            document.add(new Field(SourceFieldMapper.NAME, BytesReference.toBytes(B_1), SourceFieldMapper.Defaults.FIELD_TYPE));
            engine.delete(
                    }
                .put(defaultSettings.getSettings())
            );
        engine.activateThrottling();
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
            for (int i = 0; i < numDocsFirstSegment; i++) {
        for (int i = 0; i < numDocs; i++) {
                    assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
        ParsedDocument doc = testParsedDocument("1", null, testDocument(), B_1, null);
            EngineConfig engineConfig = createEngineConfigWithMapperSupplierForDerivedSource(store, false);
                for (int gen = 1; gen < committedGen; gen++) {
            assertThat(recoveringEngine.getProcessedLocalCheckpoint(), greaterThanOrEqualTo((long) (docs - 1)));
            if (collector.getTotalHits() > 0) {
        batch.finish();
                    SequenceNumbers.NO_OPS_PERFORMED,
                                assertFalse("Document " + docId + " should not exist", get.exists());
                        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
    private void index(final InternalEngine engine, final int id) throws IOException {
    }
        builder.settings(
        }
                                    engine.index(index);
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            )
                .build()
                if (useRecoverySource == false) {
                    initialEngine.flush(true, true);
                    indexWriterConfig.setMergePolicy(
        return new Engine.Index(
            engine.config().setEnableGcDeletes(false);
     * Parity with {@code DataFormatAwareEngine}: the batch is bounded. Indexing exactly {@code MAX_OPERATIONS}
            }
            if (safeCommit) {
        if (randomBoolean()) { // randomly refresh here again
            replicaEngine.flush();
                @Override
        } else {
                }
            InternalEngine engine = createEngine(config(defaultSettings, store, createTempDir(), NoMergePolicy.INSTANCE, null))
                    lastOpSeqNo = result.getSeqNo();
            lastFieldValue = null;
                assertTrue("Local directory contains file " + file, localFiles.contains(file));
            Translog.Operation op1 = snapshot.next();
            assertThat(unreferencedFileCleanUpsPerformed, equalTo(0L));
            List<Translog.Operation> luceneOps = readAllOperationsBasedOnSource(engine);
                    Lucene.SOFT_DELETES_FIELD,
            } catch (InterruptedException ex) {
            final long seqno = randomLongBetween(Math.max(0, localCheckPoint), localCheckPoint + 5);
                        cleanupCompleted.countDown();
        final AtomicLong seqNoGenerator = new AtomicLong(seqNo);
        final Engine.Index indexWithThrottlingCheck = spy(indexForDoc(createParsedDoc("1", null)));
            Store store = createStore();
            final String removed;
            );
                    initialEngine.index(operation);
    private void assertDeletedVersionConflict(Engine.Result result, String operation) {
                    newUid(doc),
import org.opensearch.common.logging.Loggers;
            TranslogHandler translogHandler = createTranslogHandler(initialEngine.config().getIndexSettings(), recoveringEngine);
         * <p><b>NOTE:</b> after ths writer is created, the given configuration instance cannot be passed
                }
                            new BytesArray("{}".getBytes(Charset.defaultCharset())),
        EngineConfig configWithCustomTranslogDeletionPolicyFactory = new EngineConfig.Builder().shardId(config.getShardId())
                        assertThat(result.getSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
        );
                            ) {
        try (Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
                        phaser.arriveAndAwaitAdvance();
                searcher.search(new TermQuery(new Term("value", lastFieldValue)), collector);
     * of the translog trimming in these two places.
                        );
            );
                getSnapshotAndAssertFilesExistLocally();
                        assertEquals(
                    index.startTime(),
                    null
                    final Path genFile = translogPath.resolve(Translog.getFilename(gen));
                threads.put(thread, latch);
                for (int i = 0; i < docs; i++) {
            Store store = createStore();
            segments = engine.segments(false);
            }
            assertThat(segments.get(0).getDeletedDocs(), equalTo(updates + deletes));
                        // index random number of docs
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
                    engine.config().getMergePolicy()
        engine.index(indexWithThrottlingCheck);
     * whose translog append is still deferred inside the batch must force that chunk to append synchronously and
                }
        boolean isRetry = true;
                        throw new RuntimeException(ex);
            final Map<Thread, CountDownLatch> threads = new LinkedHashMap<>();
        if (operation.origin() == PRIMARY) {
        final EngineConfig engineConfig = config(
        int numOps = between(10, 100);
     * multiple files with the same extension in one segment (e.g. two {@code .tim} files, two
import org.opensearch.indices.replication.common.ReplicationType;
                null,
                    if (randomBoolean()) {
                );
            final long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
                if (randomBoolean()) {
            }
                    engine.translogManager().syncTranslog(); // to advance persisted local checkpoint
            }
            }
            currentTerm.get(),
    }
            for (int i = 0; i < numSnapshots - 1; i++) {
                assertNotNull(retryResult.getTranslogLocation());
                )
            int iterations = scaledRandomIntBetween(1, 50);
                boolean started = false;
                engine.index(indexForDoc(doc));
                originalIndex = appendOnlyPrimary(doc, false, i, create);
        };
            expectThrows(AlreadyClosedException.class, () -> engine.index(indexForDoc(doc)));
                engine.index(indexForDoc(doc));
            }
                null,
        engine.refresh("test");
            engine.flushAndClose();
import static org.hamcrest.Matchers.nullValue;
                    globalCheckpoint::get,
        assertEquals(0, translogHandler.appliedOperations());
                                break;
            assertEquals(1, searcher.getDirectoryReader().numDocs());
        try (Store store = createStore()) {
            Engine.IndexResult indexResult = engine.index(operation);
    public void testUncommittedSegmentBytesExcludeCommittedAndSegmentsNFiles() throws Exception {
        );
                false,
    }
            0,
        final String fieldName = SeqNoFieldMapper.NAME;
                .retentionLeasesSupplier(config.retentionLeasesSupplier())
                if (event.getLoggerName().endsWith(".IFD")) {
            }
                .currentFileGeneration();
            Store store = createStore();
        }
            boolean isIndexing = randomBoolean();
                Engine.Index firstIndexRequest = new Engine.Index(
            engine.refresh("test");
                    try {
                        );
            assertThat(stats2.getId(), notNullValue());
            null,
        Engine.Index update_2 = new Engine.Index(newUid(doc), primaryTerm.get(), doc, 2);
                TranslogHandler translogHandler = createTranslogHandler(config.getIndexSettings(), engine);
            VersionType.INTERNAL,
                .endObject();
                    assertThat(result.getResultType(), equalTo(Engine.Result.Type.FAILURE));
            }
                engine.refresh("test");
                    .getMinGenerationForSeqNo(localCheckpoint + 1).translogFileGeneration;
                assertThat(refreshCount.get(), lessThanOrEqualTo(refreshCountBeforeGet + 1));
                if (rarely()) {
            }
    }
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), flushThreshold + "b")
        }
            engine.refresh("test");
        final boolean closeSnapshotBeforeEngine = randomBoolean();
                createDocumentWithNestedField("2", "Bob", 25),
            sb.append(indent).append(current.getClass().getName()).append(": ").append(current.getMessage()).append('\n');
                }
                            newUid(idToDelete),
import java.util.Collection;
            assertThat(luceneOps.stream().map(o -> o.seqNo()).collect(Collectors.toList()), containsInAnyOrder(expectedSeqNos.toArray()));
        engine.index(new Engine.Index(newUid(doc), primaryTerm.get(), doc, Versions.MATCH_DELETED));
        // write a second, uncommitted segment
                                    );
        Set<Long> existingSeqNos = new HashSet<>();
            2,
                /*
                    Engine.Index index = new Engine.Index(
        }
                .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), -1)
                        break;
            if (closeSnapshotBeforeEngine) {
                }
            assertThat(getResult.exists(), equalTo(true));
        AtomicInteger docId = new AtomicInteger(0);
                        0
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
            for (Segment segment : segments) {
