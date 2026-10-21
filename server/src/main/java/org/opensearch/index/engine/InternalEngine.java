            ensureOpen();
        return false;
        translogManager.ensureCanFlush();
        assert Objects.equals(get.uid().field(), IdFieldMapper.NAME) : get.uid().field();
         *
                        final GatedCloseable<IndexCommit> latestCommit = engineConfig.getIndexSettings().isSegRepEnabledOrRemoteNode()
    }
            }
    protected boolean assertPrimaryIncomingSequenceNumber(final Engine.Operation.Origin origin, final long seqNo) {
                        e
    }
                }
    }
                // increment the ref just to ensure nobody closes the store during a refresh
                }
         * trim only deletes whose seqno at most the local checkpoint. This requirement is explained as follows.
                try {
            if (plan.earlyResultOnPreFlightError.isPresent()) {
    private DocumentIndexWriter getDocumentIndexWriter() throws IOException {
                + " seq_no="
                        assert tombstone.docs().size() == 1 : "Tombstone should have a single doc [" + tombstone + "]";
 * You may obtain a copy of the License at
            engineConfig.getIndexSettings().getTranslogBatchAppendMaxSize().getBytes()
        return doGenerateSeqNoForOperation(operation);
    static final class RefreshWarmerListener implements BiConsumer<OpenSearchDirectoryReader, OpenSearchDirectoryReader> {
        localCheckpointTracker.advanceMaxSeqNo(seqNo);
    @Override
                    }
    }
                    )) {
            return new DeleteResult(plan.version, delete.primaryTerm(), delete.seqNo(), plan.currentlyDeleted == false);
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
                    currentCriteria = index.docs().get(0).getGroupingCriteria();
                 * The handling inside IW doesn't guarantee that an tragic / aborting exception
                }
    }
        EngineMergeScheduler(ShardId shardId, IndexSettings indexSettings, MergedSegmentTransferTracker mergedSegmentTransferTracker) {
                case "segments_stats":
    protected final AtomicLong maxUnsafeAutoIdTimestamp = new AtomicLong(-1);
                }
    protected IndexingStrategy indexingStrategyForOperation(final Index index) throws IOException {
        return commitData;
            return;
        return documentIndexWriter.ramBytesUsed() + versionMap.ramBytesUsedForRefresh();
     * document in between its Lucene add and its translog add.
    protected final NumericDocValuesField softDeletesField = Lucene.newSoftDeletesField();
        private final BiConsumer<OpenSearchDirectoryReader, OpenSearchDirectoryReader> refreshListener;
                assert noOpKeyedLock.isHeldByCurrentThread(op.seqNo());
                if (Lucene.isCorruptionException(e)) {
     * @param operation the operation
                engineConfig.getThreadPool().executor(ThreadPool.Names.FLUSH).execute(new AbstractRunnable() {
        return combinedDeletionPolicy.getSafeCommitInfo();
        return translogManager.getLastSyncedGlobalCheckpoint();
            return false;
    @Override
                    markSeqNoAsSeen(delete.seqNo());
            // data of child level
     */
                // are running.
        } else {
        }
                    }
                boolean deferred = false;
import org.opensearch.index.fieldvisitor.IdOnlyFieldVisitor;
        }
                    // it is intentional that we never refresh both internal / external together
            if (versionValue != null && versionValue.isDelete()) {
                    config().getDocumentMapperForTypeSupplier().get().getDocumentMapper().root()::deriveSource
            internalReaderManager.addListener(versionMap);
 */
    private ExternalReaderManager createReaderManager(RefreshWarmerListener externalRefreshListener) throws EngineException {
                        logger.trace("finished commit for flush");
     * can never re-trigger a flush.
        this.maxSeqNoOfUpdatesOrDeletes.updateAndGet(curr -> Math.max(curr, maxSeqNoOfUpdatesOnPrimary));
    long getNumDocAppends() {
                commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCheckpoint));
    long doGenerateSeqNoForOperation(final Operation operation) {
        assert newTimestamp >= -1 : "invalid timestamp [" + newTimestamp + "]";
            }
                        // only after the active reader is updated. This ensures that a flush does not wipe out a required commit point file
                    public void onAfterTranslogSync() {
        }
import org.opensearch.index.translog.TranslogOperationHelper;
        boolean success = false;
        DocumentIndexWriter writer = null;
            }
                    noOpResult.setTranslogLocation(location);
                        translogManager.trimUnreferencedTranslogFiles();
                e.addSuppressed(inner);
    /**
    private final IndexWriterFactory nativeIndexWriterFactory;
                    reader,
    }
            // refresh does not need to hold readLock as ReferenceManager can handle correctly if the engine is closed in mid-way.
    }
                            index.primaryTerm(),
                if (isThrottling.getAndSet(false)) {
        if (engineConfig.getIndexSettings().getIndexMetadata().isAppendOnlyIndex()) {
                } catch (AlreadyClosedException e) {
                            );
     * @param localSegmentsSizeMap post-refresh local segment file names mapped to their sizes in bytes
                    DirectoryReader.open(documentIndexWriter.getAccumulatingIndexWriter()),
                    deleteResult = deleteInLucene(delete, plan);
        @Override
                .engineConfig(engineConfig)
    public MergeStats getMergeStats() {
                return internalReaderManager;
                            get.versionType().explainConflictForReads(versionValue.version, get.version())
                continue;
        int count = throttleRequestCount.incrementAndGet();
            deleteResult.setTook(System.nanoTime() - delete.startTime());
     */
     * Appends every live bulk scope's pending chunk so that a refresh or flush publishes no document whose translog
            throw new EngineException(shardId, "Failed to materialize safe CatalogSnapshot", e);
            // cannot be created due to ensureOpen call in Composite IndexWriter.
     * Checks if the given operation has been processed in this engine or not.
import org.apache.lucene.store.AlreadyClosedException;
                                            0,
 * this file be licensed under the Apache-2.0 license or a
                        indexResult.setTranslogLocation(location);
                String currentCriteria = null;
            return Arrays.asList(segmentsArr);
                plan.version,
         * primary term here has already been set, see IndexShard#prepareIndex where the Engine$Index operation is created.
import java.util.concurrent.atomic.AtomicBoolean;
                /* A NOTE ABOUT APPEND ONLY OPTIMIZATIONS:
import java.util.function.BiConsumer;
        // delete-2, index-3, and the order on a replica is index-1, index-3, delete-2, then the msu of index-3 on the replica is 2
            // non-primary mode (i.e., replica or recovery)
                }
                throw ex;
                    logger.warn("failed to read latest segment infos on flush", e);
import org.apache.lucene.search.Scorer;
     * computed against, so a commit implicitly invalidates it.
    @Override
                        final ParsedDocument tombstone = engineConfig.getTombstoneDocSupplier().newNoopTombstoneDoc(noOp.reason());
        private boolean isWarmedUp; // guarded by refreshLock
                        delete.getIfSeqNo(),
     * Deletes, no-ops and the no-op recorded for a failed index are written to the translog inline. If this bulk thread
    @Override
                 *
            pruneDeletedTombstones();
        // Check for AlreadyClosedException -- ACE is a very special
            failEngine("already closed by tragic event on the index writer", tragicException);
         *
    public final void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {
            throw ex;
                if (docsWithId > 0) {
    }
                + id
            );
    protected SegmentInfos getLastCommittedSegmentInfos() {
    long getNumDocDeletes() {
    private NoOpResult innerNoOp(final NoOp noOp) throws IOException {
                } catch (AlreadyClosedException ex) {
import java.util.stream.Collectors;
            }
                documentIndexWriter = writer;
        // always internally consistent. If a flush lands between this snapshot and the publish below, the stamp no
                commitData.put(Engine.MIN_RETAINED_SEQNO, Long.toString(softDeletesPolicy.getMinRetainedSeqNo()));
        assert Objects.equals(index.uid().field(), IdFieldMapper.NAME) : index.uid().field();
import org.opensearch.common.Nullable;
            }
                    }
            this.internalReaderManager = internalReaderManager;
        @Override
        return combinedDeletionPolicy.hasSnapshottedCommits();
                }
            status = compareOpToVersionMapOnSeqNo(op.id(), op.seqNo(), op.primaryTerm(), versionValue);
            } catch (IOException closeEx) {
        lastDeleteVersionPruneTimeMSec = timeMSec;
                    }
    @Override
                    break;
     */
import java.util.Map;
            } else {
        logger.debug("close acquired writeLock");
                maxUnsafeAutoIdTimestamp::get,
        if (versionValue != null) {
        assert count >= 0 : "invalid post-decrement throttleRequestCount=" + count;
    }
            writer.commit();
            return new IndexResult(plan.version, index.primaryTerm(), index.seqNo(), plan.currentNotFoundOrDeleted);
            assert doc.getField(SeqNoFieldMapper.TOMBSTONE_NAME) != null : "Delete tombstone document but _tombstone field is not set ["
            // Set the Refresh checkpoint first and then sync child with parent to ensure parent Checkpoint is grater than Refresh
    }
        }
        // A scope opened against a closed engine would only fail at its first append with the same
    ) throws IOException {
    @Override
                    }
            throw ex;
        try {
            throw new IllegalArgumentException("max_seq_no_of_updates on primary is unassigned");
                documentIndexWriter.deleteUnusedFiles();
        );
                failEngine(reason, ex);
                 * that:
            if (deleteResult.getTranslogLocation() == null) {
                            ? acquireLastIndexCommit(false)
    public boolean shouldPeriodicallyFlush() {
import org.opensearch.index.translog.listener.CompositeTranslogEventListener;
            failOnTragicEvent(e);
            ensureOpen();
            assert seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO : "primary operations must have a pre-assigned sequence number under policy ["
            lastMinRetainedSeqNo = Long.parseLong(commitUserData.get(Engine.MIN_RETAINED_SEQNO));
                    preFlightError.get()
            // right away
    private final ExternalReaderManager externalReaderManager;
    protected final void writerSegmentStats(SegmentsStats stats) {
 * the Apache License, Version 2.0 (the "License"); you may
                            index.origin(),
        try {
    @Override
    /**
            }
     */
                throw new IllegalStateException("expected a pre-assigned sequence number but got [" + operation.seqNo() + "]");
                 *  documents that arrive (A and B) will also use updateDocument since their timestamps are less than
            || super.refreshNeeded();
    public void refreshPrimaryOperationPolicy() {
        return getMinRetainedSeqNo() <= startingSeqNo;
                        documentIndexWriter.getAccumulatingIndexWriter().addDocument(doc);
        return localCheckpointTracker.getStats(globalCheckpoint);
    }
            writer = new CompositeIndexWriter(engineConfig, createWriter(), softDeletesPolicy, softDeletesField, nativeIndexWriterFactory);
        );
            localCheckpointTracker.markSeqNoAsProcessed(noOpResult.getSeqNo());
     * therefore takes effect from the next successful segments sync, which on an actively written shard is the next
        // pass the new reader reference to the external reader manager.
import org.apache.lucene.search.IndexSearcher;
        }
        try (final GatedCloseable<SegmentInfos> snapshot = getSegmentInfosSnapshot()) {
     * are in sync with the Lucene commit.
    private final ThreadLocal<TranslogBatchScope> activeBatch = new ThreadLocal<>();
        } catch (Exception e) {
    /**
                + " ]";
        return engineFailed;
    private final CombinedDeletionPolicy combinedDeletionPolicy;
                );
            return true;
                // newly created commit points to a different translog generation (can free translog),
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
            // sequence number should be set when operation origin is not primary
                    engineException.addSuppressed(inner);
                default:
        int reservedDocs = 0;
                    || getProcessedLocalCheckpoint() > Long.parseLong(
        if (isTranslogBatchingEligible() == false) {
        // longer matches the new last commit and shouldFlushOnUncommittedSegmentBytes() rejects the value -- the
                            : null;
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.index.merge.MergeStats;
    @Override
        if (lastRefreshedCheckpoint() < requestingSeqNo) {
        return deleteResult;
        )
    public TranslogManager translogManager() {
                 * writing new documents to the index. Since we only know which Lucene documents made it into the final commit after the
            uncommittedSegmentBytes = null;
    /**
                if (deferred == false) {
     * Note this is only available if assertions are enabled
     * refresh; turning the condition off instead discards the accounting on that sync, see
            lastWriteNanos = delete.startTime();
        if (maxSeqNoOfUpdatesOnPrimary == SequenceNumbers.UNASSIGNED_SEQ_NO) {
    public Translog.Snapshot newChangesSnapshot(
     * A listener that warms the segments if needed when acquiring a new reader
        } else if (failedEngine.get() == null && isClosed.get() == false) { // we are closed but the engine is not failed yet?
        stats.updateMaxUnsafeAutoIdTimestamp(maxUnsafeAutoIdTimestamp.get());
    private final AtomicBoolean trackTranslogLocation = new AtomicBoolean(false);
            if (ExceptionsHelper.stackTrace(e).contains("org.apache.lucene.index.IndexWriter.filesExist")) {
                + primaryTerm
         * that's fine since the IW.rollback should stop all the threads and trigger an IOException
        }
    @Override
    protected volatile long lastDeleteVersionPruneTimeMSec;
     * @param translogUUID the translogUUID
                failEngine("refresh failed source[" + source + "]", e);
                        throw new VersionConflictEngineException(
                }
                                            IndexSearcher.getDefaultQueryCachingPolicy(),
    public void deactivateThrottling() {
                 * risk of re-using a sequence number for two different documents when restoring from this commit point and subsequently
            maxSeqNoOfUpdatesOrDeletes = new AtomicLong(
                            index.versionType(),
                    assert index.origin() == Operation.Origin.PRIMARY : index.origin();
        stats.addIndexWriterMemoryInBytes(documentIndexWriter.ramBytesUsed());
                 * The user data captured above (e.g. local checkpoint) contains data that must be evaluated *before* Lucene flushes
                .deletionPolicy(combinedDeletionPolicy)
                        } else {
        assert operation.seqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO : "ops should not have an assigned seq no. but was: "
        final long seqNo = noOp.seqNo();
                } else {
        } else {
                                    return new GetResult(
                this::updateAutoIdTimestamp,
            && current.committedInfosGeneration == committedInfos.getGeneration();
 * compatible open source license.
    @Override
        // but we are double-checking it's failed and closed
                searcher = acquireSearcher(source, SearcherScope.INTERNAL);
            }
        final long maxTimestampToPrune = timeMSec - engineConfig.getIndexSettings().getGcDeletesInMillis();
            } catch (Exception inner) {
        final long localCheckpointOfLastCommit = Long.parseLong(
            int maxNumMerges = mergeScheduler.getMaxMergeCount();
        final UncommittedSegmentBytes current = this.uncommittedSegmentBytes;
    @Override
import java.util.HashSet;
import org.apache.lucene.document.NumericDocValuesField;
            } finally {
import org.opensearch.index.shard.OpenSearchMergePolicy;
        try {
    }
            final DocIdSetIterator iterator = scorer.iterator();
        for (TranslogBatchScope batch : activeBatches) {
            }
            if (combinedDeletionPolicy.hasUnreferencedCommits()) {
            failOnTragicEvent(ex);
        OpenSearchReaderManager internalReaderManager = null;
                    lastRefreshedCheckpointListener.updateRefreshedCheckpoint(localCheckpointBeforeRefresh);
                localCheckpointTracker::getProcessedCheckpoint,
        } catch (IOException e) {
        long bytes = 0;
        }
                assert versionMap.assertKeyedLockHeldByCurrentThread(op.uid().bytes());
                updateDocs(index.uid(), index.docs(), documentIndexWriter, plan.version, index.seqNo(), index.primaryTerm());
                updateAutoIdTimestamp(Long.parseLong(entry.getValue()), true);
    }
        } catch (final Exception ex) {
        mergeScheduler.refreshConfig();
    }
    final boolean refresh(String source, SearcherScope scope, boolean block) throws EngineException {
                    @Override
        final TranslogBatchScope batch = activeBatch.get();
                if (idFieldVisitor.getId() == null) {
                                        true
        final long maxSeqNo;
            internalReaderManager.addListener(documentIndexWriter);
        if (versionMap.isUnsafe()) {
        RefreshWarmerListener(Logger logger, AtomicBoolean isEngineClosed, EngineConfig engineConfig) {
        return localCheckpointTracker;
            }
        try {
            noOpResult = innerNoOp(noOp);
            ensureOpen();
        } finally {
                // we should execute a flush on the next operation if that's a flush after inactive or indexing a document.
    /**
 * The default internal engine (can be overridden by plugins)
    }
     * after the local checkpoint in the safe commit. This step ensures the live version map and checkpoint tracker
    @Override
        }
                .buildIndexWriterConfig();
    }
                    failEngine("lucene commit failed", engineException);
                    refresh(source, SearcherScope.INTERNAL, true);
        return new GatedCloseable<>(lastCommit, () -> releaseIndexCommit(lastCommit));
                    }
                + " existing_term="
            return new GatedCloseable<>(snapshot, () -> releaseIndexCommit(safeCommit));
        }
                        } else {
                        // _GET calls deployed due to an update request will attempt to read from the translog first to guarantee the most
                final String currentForceMergeUUID = forceMergeUUID;
        return true;
            } catch (Exception inner) {
                && System.nanoTime() - lastWriteNanos >= engineConfig.getFlushMergesAfter().nanos()) {
                    logger.info("finished segment upgrade");
                shouldPeriodicallyFlushAfterBigMerge.set(true);
    public long getIndexBufferRAMBytesUsed() {
                    if (get.versionType().isVersionConflictForReads(versionValue.version, get.version())) {
                            : null;
     * write post last commit.
                } catch (Exception e) {
    // are falling behind and when writing indexing buffer to disk is too slow. When this is 0, there is no throttling, else we throttling
                                engineConfig.getThreadPool().relativeTimeInMillis()
        assert plan.version >= 0 : "version must be set. got " + plan.version;
                if (plan.earlyResultOnPreFlightError.isPresent()) {
    protected final boolean hasBeenProcessedBefore(Operation op) {
    protected SegmentInfos getLatestSegmentInfos() {
                if (lastRefreshedCheckpoint() < requestingSeqNo) {
            }
    private boolean isWriteLockHeld() {
            translogManager::getLastSyncedGlobalCheckpoint,
                        tombstone.version().setLongValue(1L);
        if (combinedDeletionPolicy.releaseCommit(snapshot)) {
     */
            } catch (Exception inner) {
        this(engineConfig, IndexWriter.MAX_DOCS, LocalCheckpointTracker::new, translogEventListener);
    @Override
        assert refreshed == false || lastRefreshedCheckpoint() >= localCheckpointBeforeRefresh : "refresh checkpoint was not advanced; "
            engineConfig.getThreadPool().generic().execute(new AbstractRunnable() {
    public InternalEngine(EngineConfig engineConfig, TranslogEventListener translogEventListener) {
                    } catch (final Exception ex) {
    public void updateUncommittedSegmentBytes(Map<String, Long> localSegmentsSizeMap, long flushThresholdBytes) {
                    /*
     * Asserts that the doc in the index operation really doesn't exist
                    } catch (AlreadyClosedException e) {
            return new GatedCloseable<>(((StandardDirectoryReader) reader.getDelegate()).getSegmentInfos(), () -> {
            if (op.operationType() == Operation.TYPE.NO_OP) {
                    try {
                        numDocDeletes.inc();
                Index index = (Index) op;
            logger.trace("finish flush for snapshot");
                        if (indexResult.getResultType() == Result.Type.SUCCESS) {
        @Override
                                    index.origin(),
        assert noOp.seqNo() > SequenceNumbers.NO_OPS_PERFORMED;
                            trackTranslogLocation.set(true);
        // we need to fail the engine. it might have already been failed before
            engineConfig.retentionLeasesSupplier()
                    throw e;
                    store.decRef();
                this::hasBeenProcessedBefore,
    @Override
                plan.addStaleOpToEngine || plan.currentlyDeleted,
                softDeletesField
             * or the Lucene document limit. We have already issued a sequence number here so this is fatal, fail the engine.
import org.apache.lucene.search.ReferenceManager;
        private final long flushThresholdBytes;
     * will be rollback. Since after rollback we do care about any new writes that came in and in the last commit, we would
import org.opensearch.index.translog.TranslogManager;
    @SuppressForbidden(reason = "reference counting is required here")
        return versionMap.getUnderLock(id);
            } else {
                localCheckpointTracker.markSeqNoAsProcessed(seqNo);
    @Override
                         */
    }
                 *  if A arrives on the shard first we use addDocument since maxUnsafeAutoIdTimestamp is < 10. A` will then just be skipped
     * <p>
            updateAutoIdTimestamp(Long.MAX_VALUE, true);
            translogDeletionPolicy,
                }
import org.apache.lucene.index.IndexCommit;
        return lastRefreshedCheckpointListener.lastRefreshedCheckpoint();
         * Suppose o1 and o2 are two operations on the same document with seq#(o1) < seq#(o2), and o2 arrives before o1 on the replica.
                 * will be used as THE tragicEventException since if there are multiple exceptions causing an abort in IW
    /**
    }
                && documentIndexWriter.getTragicException() == null
                markSeqNoAsSeen(noOp.seqNo());
    IndexWriter createWriter(Directory directory, IndexWriterConfig iwc) throws IOException {
            }
            }
    private DeletionStrategy planDeletionAsPrimary(Delete delete) throws IOException {
                            final long startTime = 0L;
                        tombstone.updateSeqID(noOp.seqNo(), noOp.primaryTerm());
    @Override
     * When we last pruned expired tombstones from versionMap.deletes:
        numIndexVersionsLookups.inc();
     * the commit generation it was computed against: a value whose generation does not match the current last commit
        BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
                assert delete.origin().isFromTranslog() || deleteResult.getSeqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO;
                    );
            return planIndexingAsPrimary(index);
                storedFields.document(docId, idFieldVisitor);
import org.opensearch.common.util.concurrent.ReleasableLock;
 * GitHub history for details.
                if (index.origin().isFromTranslog() == false) {
     * This count does not include the deletions from the existing segments before opening engine.
                    documentIndexWriter.maybeMerge();
            && current.bytes >= current.flushThresholdBytes
                        new IndexVersionValue(translogLocation, plan.version, index.seqNo(), index.primaryTerm())
        activeBatches.add(batch);
            // no version, get the version from the index, we know that we refresh on flush
            synchronized (refreshIfNeededMutex) {
            // Same decision as a per-operation translog failure in index(): fail the engine only if the exception is the
        }
                    );
     */
        }
    @Override
            /*
    public long getWritingBytes() {
        // Operations can be processed on a replica in a different order than on the primary. If the order on the primary is index-1,
            if (success == false) { // release everything we created on a failure
                        // if we have no pending merges and we are supposed to flush once merges have finished to
        }
                        // with Segment Replication we need to hold the latest commit before a new one is created and ensure it is released
        int maxDocs,
     * The publisher calls this on every segments sync while the condition is disabled, so the write is guarded: only the
     * @param writer   the index writer to commit
        final long timeMSec = engineConfig.getThreadPool().relativeTimeInMillis();
            .build();
            + operation.seqNo();
                maybeFailEngine(source, e);
        return Optional.empty();
import org.opensearch.common.util.concurrent.KeyedLock;
                } catch (IOException inner) { // iw is closed below
        long version,
                commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
 */
            }
                } catch (final Exception inner) {
            }
                                IndexVersionValue.withPendingLocation(pending, plan.version, index.seqNo(), index.primaryTerm())
                        deferred = true;
                maxDocs
        private final Engine.Warmer warmer;
            }
                logger.trace("acquired flush lock after blocking");
            translogEventListener,
                }
            engineConfig.getIndexSettings().getSoftDeleteRetentionOperations(),
                // the op is coming from the translog (and is hence persisted already) or it does not have a sequence number
    public long getProcessedLocalCheckpoint() {
     * The main purpose for this is that if we have external refreshes happening we don't issue extra
                    deactivateThrottling();
                                    TranslogLeafReader reader = new TranslogLeafReader(index, config());
            committedFiles = new HashSet<>(committedInfos.files(false));
                documentIndexWriter::getPendingNumDocs,
                    } else {
                    closedLatch.countDown();
                searcher,
     */
            }
                            "new commit on flush, hasUncommittedChanges:{}, force:{}, shouldPeriodicallyFlush:{}",
                            latestCommit.close();
                        throw ex;
                maybeFailEngine("start", e);
                    documentIndexWriter.rollback();
        /*
                fromSeqNo,
            IndexWriterConfig iwc = NativeLuceneIndexWriterFactory.IndexWriterConfigBuilder.builder()
    }
    }
                // or (4) the local checkpoint information in the last commit is stale, which slows down future recoveries.
    private boolean incrementVersionLookup() { // only used by asserts
        // NOTE this uses direct access to the version map since we are in the assertion code where we maintain a secondary
                }
 *
    public PrimaryOperationPolicy getPrimaryOperationPolicy() {
                .commitOnClose(false)
                                            "realtime_get",
                VersionValue versionValue = null;
    private final CompletionStatsCache completionStatsCache;
         * Here we prefer to deploy a single trimming strategy, which satisfies two constraints, on both primary and replicas because:
        final IndexCommit safeCommit = combinedDeletionPolicy.acquireIndexCommit(true);
                } finally {
        return softDeletesPolicy.getMinRetainedSeqNo();
     *
import java.util.concurrent.atomic.AtomicInteger;
                boolean hasUncommittedChanges = documentIndexWriter.hasUncommittedChanges();
        for (ParseContext.Document doc : docs) {
        }
    @Override
        final TranslogBatchScope batch = new TranslogBatchScope(
                logger.trace("waiting for in-flight flush to finish");
     * Returns the minimum seqno that is retained in the Lucene index.
     */
            );
                        indexResult = new IndexResult(plan.version, index.primaryTerm(), index.seqNo(), plan.currentNotFoundOrDeleted);
                maybeFailEngine("acquire changes snapshot", e);
        stats.addVersionMapMemoryInBytes(versionMap.ramBytesUsed());
                IOUtils.closeWhileHandlingException(internalReaderManager, documentIndexWriter);
    }
     * <p>
         * - It's simpler - no need to distinguish if an engine is running at primary mode or replica mode or being promoted.
                 * relationship. For instance:
            this.indexingStrategyPlanner = new IndexingStrategyPlanner(
                        lastCommittedSegmentInfos.userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)
                            index.uid(),
                    failEngine("index id[" + index.id() + "] origin[" + index.origin() + "] seq#[" + index.seqNo() + "]", e);
    @Override
                // global checkpoint to select a safe commit against, and under remote store the commit's
        }
        // remove live entries in the version map
        if (current == null) {
        // It's expensive to prune because we walk the deletes map acquiring dirtyLock for each uid so we only do it
                    if (get.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
    boolean throttleLockIsHeldByCurrentThread() {  // to be used in assertions and tests only
                versionMap.enforceSafeAccess();
    @Override
            return planIndexingAsNonPrimary(index);
                this.translogManager = translogManagerRef;
        // snapshot the volatile once, as shouldFlushOnUncommittedSegmentBytes() does
    @Override
        }
    public Engine.TranslogBatch beginTranslogBatch() {
            translogUUID,
            // TODO: Simulate this with a unit test.
                        localCheckpointTracker.markSeqNoAsPersisted(indexResult.getSeqNo());
                                flushActiveBatchBeforeInlineWrite();
        return documentIndexWriter.hasPendingMerges();
     * @deprecated This assertion has been moved to IndexingStrategyPlanner
            }
    }
    }
            int maxNumMerges = mergeScheduler.getMaxMergeCount();
     * Snapshot of {@link EngineConfig#getPrimaryOperationPolicy()}. Re-read only from
                                            index.seqNo(),
                // generate or register sequence number
        boolean requiredFullRange,
                addStaleDocs(index.docs(), documentIndexWriter, index.uid());
                 * not used anyway
    private final AtomicLong maxSeenAutoIdTimestamp = new AtomicLong(-1);
            throw new EngineException(shardId, e.getMessage(), e);
                    throw new EngineCreationFailureException(
                this.isContextAwareEnabled = engineConfig.getIndexSettings().isContextAwareEnabled();
            final Optional<Exception> preFlightError = preFlightCheckForNoOp(noOp);
                        markSeqNoAsSeen(index.seqNo());
                    indexResult.setTook(System.nanoTime() - index.startTime());
        } else if (translogManager.getTragicExceptionIfClosed() != null) {
        if (unsafe) {
        }
        for (Map.Entry<String, String> entry : indexWriter.getLiveCommitData()) {
                    + maxUnsafeAutoIdTimestamp.get()
        } else if (seqNo == versionValue.seqNo) {
                return commitData.entrySet().iterator();
                    // This will be needed as in prior scenario, we call a flush before triggering force merge in lucene.
            return noOpResult;
            failEngine(source, e);
        }
                        indexResult = indexIntoLucene(index, plan);
import java.util.List;
    protected boolean isTranslogBatchingEligible() {
import org.apache.lucene.index.IndexFileNames;
            return SeqNoGapFiller.fillGaps(localCheckpointTracker, translogManager, primaryTerm, noOp -> innerNoOp(noOp));
                    if (indexResult.getTranslogLocation() == null
        return nativeIndexWriterFactory.createWriter(directory, iwc);
                + " op_term="
                        if (ex instanceof AlreadyClosedException == false && documentIndexWriter.getTragicException() == null) {
 * under the License.
    @Nullable
                + "]";
            }
            assert seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO : "primary operations must never have an assigned sequence number but was ["
            lastMinRetainedSeqNo = Long.parseLong(commitUserData.get(SequenceNumbers.MAX_SEQ_NO)) + 1;
                    currentCriteria
            final long localCheckpoint = localCheckpointTracker.getProcessedCheckpoint();
                    shardId
                e.addSuppressed(inner);
                                    indexResult.getSeqNo(),
        for (Map.Entry<String, Long> file : localSegmentsSizeMap.entrySet()) {
                try {
/*
            synchronized (versionMap) {
    public void flush(boolean force, boolean waitIfOngoing) throws EngineException {
    long getNumIndexVersionsLookups() { // for testing
                            // use 0L for the start time so we can prune this delete tombstone quickly
        // both refresh types will result in an internal refresh but only the external will also
                e.addSuppressed(innerException);
            lastCommittedSegmentInfos.userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)
                } finally {
            return snapshot;
        int maxNumSegments,
     * there and only while the condition is enabled cluster-wide by
            this.isEngineClosed = isEngineClosed;
import java.util.Locale;
             * Document level failures when deleting are unexpected, we likely hit something fatal such as the Lucene index being corrupt,
                        flush(false, true);
            // and capture the checkpoint afterwards so the drained operations count as refreshed.
        // (e.g., moves backwards) we will at least still sometimes prune deleted tombstones:
 * Modifications Copyright OpenSearch Contributors. See
     */
        }
                }
            return Engine.NO_OP_TRANSLOG_BATCH;
            ensureOpen();
                }
     * the engine holds no opinion about how the index setting and its cluster fallback are resolved. A threshold change
     * bytes are computed as the total size of local segment files that are not referenced by the last commit point,
 */
                } else if (op.seqNo() == docAndSeqNo.seqNo) {
            } catch (Exception innerException) {
                // NEVER do this on a merge thread since we acquire some locks blocking here and if we concurrently rollback the writer
    private void restoreVersionMapAndCheckpointTracker(DirectoryReader directoryReader) throws IOException {
    public String getHistoryUUID() {
        } finally {
    long getInFlightDocCount() {
                                throw new EngineException(shardId, "failed to read operation from translog", e);
        } finally {
            searcher = null;
        assert operation.origin() == Operation.Origin.PRIMARY;
    private void bootstrapAppendOnlyInfoFromWriter(DocumentIndexWriter writer) {
            try {
        if (shouldPeriodicallyFlushAfterBigMerge.get()) {
import org.opensearch.index.translog.TranslogDeletionPolicy;
                searcher,
    }
    // Lucene operations since this engine was opened - not include operations from existing segments.
    }
import org.apache.lucene.search.Query;
        numVersionLookups.inc();
                    logger.debug("merge failure action rejected", e);
            }
                        delete.id(),
    @Override
            reader = internalReaderManager.acquire();
            || lastRefreshedCheckpoint() < localCheckpointTracker.getProcessedCheckpoint()
                engineConfig.getShardId(),
    }
            : "DirectoryReader must be an instance of OpenSearchDirectoryReader";
import java.util.concurrent.ConcurrentHashMap;
            ) {
        return documentIndexWriter.hasNewIndexingOrUpdates()
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndSeqNo;
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver;
            // scenario, no new entry will be created in the new map as write on new map will be blocked due to an active
                    refreshIfNeeded("realtime_get", versionValue.seqNo);
        for (LeafReaderContext leaf : directoryReader.leaves()) {
                     */
            return getFromSearcher(get, searcherFactory, scope);
import org.opensearch.common.lucene.index.DerivedSourceDirectoryReader;
                    }
                 * NOTE: it's not important for this timestamp to be consistent across nodes etc. it's just a number that is in the common
        // AlreadyClosedException; refuse it up front so the bulk is retried on the new primary without doing any work.
    }
        } else {
                }
                        delete.versionType(),
        flushActiveBatchBeforeInlineWrite();
    private final LastRefreshedCheckpointListener lastRefreshedCheckpointListener;
            // only if a shard starts up again due to relocation or if the index is closed
        }
                        && (get.getIfSeqNo() != versionValue.seqNo || get.getIfPrimaryTerm() != versionValue.term)) {
                        // while we are
import org.apache.lucene.search.BooleanClause;
                translogManagerRef = createTranslogManager(translogUUID, translogDeletionPolicy, compositeTranslogEventListener);
                // we are switching from an unsafe map to a safe map. This might happen concurrently
    public final long currentOngoingRefreshCheckpoint() {
            writer = new LuceneIndexWriter(createWriter());
            try {
            }
            // this primary's sequence numbers are assigned upstream, so an assigned seq no. is expected
                engineConfig.getIndexSettings(),
    }
                    if (versionValue.isDelete()) {
                }
    }
                }
            throw e;
                    if (batch != null && indexResult.getResultType() == Result.Type.SUCCESS) {
            final CatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(infos);
                if (e instanceof AlreadyClosedException == false && treatDocumentFailureAsTragicError(index)) {
        logger.trace("created new InternalEngine");
            }
     * Operations whose seq# are at least this value should exist in the Lucene index.
                try {
        final Set<String> committedFiles;
         *      so a real-time lookup can find it and determine that o1 is stale.
        final OpenSearchDirectoryReader reader;
        }
                .logger(logger)
                    }
    @Override
                logger.debug("primary operation policy changed from [{}] to [{}]", primaryOperationPolicy, refreshed);
        return completionStatsCache.get(fieldNamePatterns);
        }
            ensureOpen(ex);
                        delete.version(),
                        new Translog.NoOp(noOp.seqNo(), noOp.primaryTerm(), noOp.reason())
        try (ReleasableLock lock = readLock.acquire()) {
import org.opensearch.index.mapper.ParseContext;
                    searcher.getIndexReader(),
    protected final DocumentIndexWriter documentIndexWriter;
                // Here we don't have to trim translog because snapshotting an index commit
            default:
        }
    }
    LiveIndexWriterConfig getCurrentIndexWriterConfig() {
                                            reader,
                if (refreshed) {
    /**
    void clearDeletedTombstones() {
            reservedDocs = plan.reservedDocs;
                    ReferenceManager<OpenSearchDirectoryReader> referenceManager = getReferenceManager(scope);
import org.opensearch.threadpool.ThreadPool;
        }
    private void updateAutoIdTimestamp(long newTimestamp, boolean unsafe) {
                            versionValue.term
    private final DocumentCountTracker documentCountTracker;
    private void flushActiveTranslogBatches() {
            // A remote-segrep bulk may have applied Lucene documents whose translog locations are still deferred. Drain
            || index.origin() == Operation.Origin.PEER_RECOVERY
     * Returns the number of documents have been appended since this engine was opened.
                e.addSuppressed(inner);
    /**
    private static OpVsEngineDocStatus compareOpToVersionMapOnSeqNo(String id, long seqNo, long primaryTerm, VersionValue versionValue) {
        ensureOpen();
                            versionMap.putDeleteUnderLock(uid, new DeleteVersionValue(dv.docVersion(docId), seqNo, primaryTerm, startTime));
                protected void doRun() throws Exception {
        // The logic for closing writer is same as Engine except we are taking additional locks on child level writers.
    final Map<BytesRef, VersionValue> getVersionMap() {
                }
    InternalEngine(
                flush();
    }
                }
        if (docs.size() > 1) {
         * syncs calls to findForcedMerges.
import java.util.function.BiFunction;
            // the setting will be re-interpreted if it's set to true
        return settings.isTranslogBatchAppendEnabled()
                maybeFailEngine("noop", e);
                    versionMap.maybePutIndexUnderLock(
     */
                new EngineException(shardId, "Unable to update document as it is an append only index")
    private boolean assertDocDoesNotExist(final Index index, final boolean allowDeleted) throws IOException {
        }
                    assert externalReaderManager.isWarmedUp : "searcher was not warmed up yet for source[" + source + "]";
import org.opensearch.common.lease.Releasables;
            + " refresh_checkpoint="
                        );
        // snapshot the volatile once so the null check and the generation comparison observe the same commit point
            this.externalReaderManager = externalReaderManager;
        private final AtomicInteger numMergesInFlight = new AtomicInteger(0);
            // a tragic event or has closed itself. if that is not the case we are in a buggy state and raise an assertion error
        try (ReleasableLock lock = readLock.acquire()) {
        final boolean upgrade,
        activeBatches.remove(batch);
            documentCountTracker.releaseInFlightDocs(reservedDocs);
        OpenSearchReaderManager internalReaderManager = null;
import org.apache.lucene.index.StoredFields;
                @Override
            } catch (FlushFailedEngineException ex) {
            );
            try {
                    + "]";
            success = true;
import org.opensearch.index.IndexSettings;
            if (MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID.equals(entry.getKey())) {
    }
                        );
                /* There is no tragic event recorded so this must be a document failure.
                                    index.primaryTerm(),
            try (Searcher searcher = acquireSearcher("load_seq_no", SearcherScope.INTERNAL)) {
                : "Either the write lock must be held or the engine must be currently be failing itself";
            }
     * for a failure that is the translog's tragic event (the translog is closed and the engine is failing); any other
                // A pull-based index has no translog (NoOpTranslogManager), so this can only fail: there is no
    }
            return operation.seqNo();
    }
    }
    private final DeletionStrategyPlanner deletionStrategyPlanner;
            this.externalReaderManager.addListener(completionStatsCache);
                }
        if (isClosed.get() == false) {
    }
            // load from index
                        final Translog.Location location;
            }
            if (scorer == null) {
        } finally {
     * rather than a compare-and-set is sufficient because the field is only ever written from the segments sync path,
                        if (ex instanceof AlreadyClosedException) {
        refresh("write indexing buffer", SearcherScope.INTERNAL, false);
                                        ),
import org.opensearch.common.unit.TimeValue;
                    if (block || isContextAwareEnabled) {
                this::incrementVersionLookup
     * @throws IOException
    }
            // translog's tragic event (or an AlreadyClosedException over one); otherwise only the request fails.
    /** returns the force merge uuid for the engine */
                        // We add Stale entry only on parent IndexWriter.
                                delete.primaryTerm(),
                    throw ex;
            try {
        protected OpenSearchDirectoryReader refreshIfNeeded(OpenSearchDirectoryReader referenceToRefresh) throws IOException {
        return documentIndexWriter.getConfig();
                refresh("commit", SearcherScope.INTERNAL, true);
     * Returned the last local checkpoint value has been refreshed internally.
                engineConfig.getIndexSettings(),
                    Arrays.asList(internalTranslogEventListener, translogEventListener),
                return true;
                    // the second refresh will only do the extra work we have to do for warming caches etc.
                refreshed = false;
    private void flushActiveBatchBeforeInlineWrite() {
                    public void onAfterTranslogRecovery() {
import org.opensearch.index.seqno.SeqNoStats;
                            shouldPeriodicallyFlush
        EngineConfig engineConfig,
     */
                }
import org.opensearch.index.merge.MergedSegmentTransferTracker;
                Releasable ignored = versionMap.acquireLock(index.uid().bytes());
                localCheckpointTracker.markSeqNoAsPersisted(deleteResult.getSeqNo());
                throw ex;
            }
    protected DeletionStrategy deletionStrategyForOperation(final Delete delete) throws IOException {
        final Term uid,
            return true;
                return null;
            return failOnTragicEvent((AlreadyClosedException) e);
    protected final void markSeqNoAsSeen(long seqNo) {
        int count = throttleRequestCount.decrementAndGet();
            localCheckpointTracker,
        if (engineConfig.isEnableGcDeletes()
                            try {
                assert noOp.origin().isFromTranslog() || noOpResult.getSeqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO;
        String translogUUID,
                try {
        super(engineConfig);
            ensureOpen();
     * is failed.
                assert delete.origin() == Operation.Origin.PRIMARY : delete.origin();
                    @Override
        return true;
    }
    }
                this.nativeIndexWriterFactory = new NativeLuceneIndexWriterFactory();
    }
        return maxSeenAutoIdTimestamp.get();
    public DeleteResult delete(Delete delete) throws IOException {
                final OpenSearchDirectoryReader directoryReader = OpenSearchDirectoryReader.wrap(
    public void refresh(String source) throws EngineException {
    }
        return refresh(source, SearcherScope.EXTERNAL, false);
                + seqNo
        if (engineConfig.isAutoGeneratedIDsOptimizationEnabled() == false) {
        store.incRef();
            assert op.seqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO : "operation is not assigned seq_no";
            }
        assert operation.origin() != Operation.Origin.PRIMARY : "planing as primary but got " + operation.origin();
            this.current = internalReaderManager.acquire(); // steal the reference without warming up
                    }
                try {
                if (op instanceof Index) {
            deleteResult.freeze();
    // A uid (in the form of BytesRef) to the version map
import org.opensearch.index.translog.InternalTranslogManager;
            internalReaderManager = externalReaderManager.internalReaderManager;
    }
        return throttle.isThrottled();
        }
            externalReaderManager = createReaderManager(new RefreshWarmerListener(logger, isClosed, engineConfig));
                delete.primaryTerm(),
                store.decRef();
                }
                    assert versionValue.seqNo >= 0 : versionValue;
    }
    public GatedCloseable<SegmentInfos> getSegmentInfosSnapshot() {
            TranslogOperationHelper.create(engineConfig)
        return primaryOperationPolicy.planIndex(indexingStrategyPlanner, index);
import org.apache.lucene.index.LeafReaderContext;
    }
 * KIND, either express or implied.  See the License for the
    private static final class ExternalReaderManager extends ReferenceManager<OpenSearchDirectoryReader> {
                    final Translog.Location location = translogManager.add(
                this.softDeletesPolicy = newSoftDeletesPolicy();
            success = true;
                documentCountTracker::tryAcquireInFlightDocs
            }
                            hasUncommittedChanges,
        return index.origin() == Operation.Origin.REPLICA
        // every 1/4 of gcDeletesInMillis:
        for (Map.Entry<String, String> entry : writer.getLiveCommitData()) {
                try {
        } catch (AlreadyClosedException e) {
                        assert index.origin().isFromTranslog() || indexResult.getSeqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO;
                    assert upgrade == false;
                assert assertDocDoesNotExist(index, indexingStrategyPlanner.canOptimizeAddDocument(index) == false);
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNo) throws IOException {
                 *
            } catch (AlreadyClosedException ignored) {
import org.opensearch.index.mapper.Uid;
        }
                forceMergeUUID = commitData.get(FORCE_MERGE_UUID_KEY);
        }
                if (docAndSeqNo == null) {
            );
    }
         * However, the version map may consume less memory if we deploy two different trimming strategies for primary and replicas.
        @Override
                try {
     *
                }
                // the op is coming from the translog (and is hence persisted already) or does not have a sequence number (version conflict)
                final long docsWithId = searcher.count(new TermQuery(index.uid()));
        }
                 *  will just de-optimize some doc in the worst case.
            assert incrementIndexVersionLookup();
                    }
            } else {
        return new GatedCloseable<>(safeCommit, () -> releaseIndexCommit(safeCommit));
        if (commitUserData.containsKey(Engine.MIN_RETAINED_SEQNO)) {
    private void addDocs(final List<ParseContext.Document> docs, final DocumentIndexWriter indexWriter, Term uid) throws IOException {
        this(engineConfig, IndexWriter.MAX_DOCS, LocalCheckpointTracker::new, TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER);
     * However, we prefer to fail a request individually (instead of a shard) if we hit a document failure on the primary.
                            failOnTragicEvent((AlreadyClosedException) ex);
            logger.debug("close now acquiring writeLock");
            final VersionValue versionValue = versionMap.getVersionForAssert(id.bytes());
    private boolean assertMaxSeqNoOfUpdatesIsAdvanced(Term id, long seqNo, boolean allowDeleted, boolean relaxIfGapInSeqNo) {
                // Only flush if (1) Lucene has uncommitted docs, or (2) forced by caller, or (3) the
                } catch (Exception inner) {
    private IndexWriter createWriter() throws IOException {
            }
                if (noOp.origin().isFromTranslog() == false && noOpResult.getResultType() == Result.Type.SUCCESS) {
            if (writerTragicException instanceof Exception) {
    private boolean failOnTragicEvent(AlreadyClosedException ex) {
        // map in the version map such that we don't need to refresh if we are unsafe;
                            } else {
        return localCheckpointTracker.generateSeqNo();
                final Map<String, String> userData = store.readLastCommittedSegmentsInfo().getUserData();
                final Translog.Location location = translogManager.add(new Translog.Delete(delete, deleteResult));
                    indexResult.freeze();
                versionValue = new IndexVersionValue(null, docIdAndVersion.version, docIdAndVersion.seqNo, docIdAndVersion.primaryTerm);
            throw new IllegalStateException("a translog batch is already active on this bulk thread");
 * Unless required by applicable law or agreed to in writing,
                // That's ok, we'll clean up unused files the next time it's opened.
    private final ReentrantLock optimizeLock = new ReentrantLock();
                    return;
     */
     */
        }
                    documentIndexWriter.forceMerge(maxNumSegments, true /* blocks and waits for merges*/);
            }
 * not use this file except in compliance with the License.
        return historyUUID;
            throttle.deactivate();
        final boolean doThrottle = index.origin().isRecovery() == false;
            tombstone.version().setLongValue(plan.version);
                         * fatal, fail the engine.
     * Gets the commit data from {@link IndexWriter} as a map.
                    logger.warn("Failed to close translog", e);
         * number service if this is on the primary, or the existing document's sequence number if this is on the replica. The
    public boolean hasPendingMerges() {
                    refreshLastCommittedSegmentInfos();
    private void refreshLastCommittedSegmentInfos() {
                            shardId,
            } finally {
        awaitPendingClose();
    private void onTranslogBatchFinished(TranslogBatchScope batch) {
    private void closeInternal() throws IOException {
    }
                            get.getIfSeqNo(),
                        delete.primaryTerm(),
            store.incRef(); // increment the ref just to ensure nobody closes the store while we optimize
            }
    }
        } else {
    /**
                )
            if (ex instanceof AlreadyClosedException == false && documentIndexWriter.getTragicException() == null) {
    // Package private for testing purposes only
                }
                 * case increasing and can be used in the failure case when we retry and resent documents to establish a happens before
        } else {
        maxSeenAutoIdTimestamp.updateAndGet(curr -> Math.max(curr, newTimestamp));
            try {
    @Override
     * record is still deferred.
                "Failing shard as update operation is not allowed for append only index ",
                // sequence-number space; recording no-ops here could collide with operations the
    public IndexResult index(Index index) throws IOException {
 * license agreements. See the NOTICE file distributed with
                try {
                    }
            store.readLastCommittedSegmentsInfo().userData.entrySet()
                        // recent version.
                }
                }
             */
     * {@code cluster.remote_store.flush_on_uncommitted_segments.enabled}; the stamped commit generation must match the
        if (shouldFail) {
                if (isClosed.get() == false) {
            + lastRefreshedCheckpoint();
    private final class EngineMergeScheduler extends OpenSearchConcurrentMergeScheduler {
        maybePruneDeletes();
     */
                        if (toAppend == false) {
     */
        if (origin == Operation.Origin.PRIMARY) {
            throw ex;
                // but we only need to do this once since the last operation per ID is to add to the version
     * Returns the number of documents have been deleted since this engine was opened.
    protected boolean assertPrimaryCanOptimizeAddDocument(final Index index) {
    }
                flushLock.unlock();
                boolean success = false;
import org.opensearch.common.lucene.search.Queries;
    @Override
        }
        assert assertIncomingSequenceNumber(delete.origin(), delete.seqNo());
    private final IndexingStrategyPlanner indexingStrategyPlanner;
                 * we return a `MATCH_ANY` version to indicate no document was index. The value is
            }
                engineConfig.getIndexSettings(),
        } else if (engineConfig.isEnableGcDeletes()
    }
                }
        final IndexSettings settings = engineConfig.getIndexSettings();
        final List<ParseContext.Document> docs,
    }
     * @opensearch.internal
        awaitPendingClose();
 * SPDX-License-Identifier: Apache-2.0
    private void revisitIndexDeletionPolicyOnTranslogSynced() {
                            index.isRetry(),
    }
                            failEngine(reason, ex);
        return documentIndexWriter.getFlushingBytes() + versionMap.getRefreshingBytes();
        }
                final BytesRef uid = new Term(IdFieldMapper.NAME, Uid.encodeId(idFieldVisitor.getId())).bytes();
        return maxSeqNoOfUpdatesOrDeletes.get();
                e.addSuppressed(inner);
                final long primaryTerm = dv.docPrimaryTerm(docId);
    }
                final IndexResult indexResult;
                .mergeScheduler(mergeScheduler)
            } catch (Exception inner) {
            }
    public final long getMaxSeenAutoIdTimestamp() {
     * Refresh this engine **internally** iff the requesting seq_no is greater than the last refreshed checkpoint.
    public int fillSeqNoGaps(long primaryTerm) throws IOException {
            if (operation.seqNo() < 0) {
            shardId,
            // exclude non-root nested documents
                        }
        private final AtomicBoolean isThrottling = new AtomicBoolean();
        try (ReleasableLock ignored = readLock.acquire()) {
                }
     * which is serialized per shard by the refresh listener's permit; and even a lost race here could only suppress a
            mergeScheduler = scheduler = new EngineMergeScheduler(
import org.apache.lucene.index.StandardDirectoryReader;
                    restoreVersionMapAndCheckpointTracker(Lucene.wrapAllDocsLive(searcher.getDirectoryReader()));
            } finally {
                return indexResult;
                     * We do this on another thread rather than the merge thread that we are initially called on so that we have complete
    }
            final SegmentInfos infos = Lucene.readSegmentInfos(safeCommit);
import org.opensearch.index.translog.listener.TranslogEventListener;
        if (seqNo > versionValue.seqNo) {
                logger.debug("engine already closed - skipping flushAndClose");
                }
    @Override
        private final long bytes;
            failEngine(
                            break;
                logger.trace("rollback indexWriter done");
                commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(localCheckpointTracker.getMaxSeqNo()));
            } else {
            }
    }
            batch.flush();
    public void flushAndClose() throws IOException {
     * Note this is only available if assertions are enabled
import org.opensearch.common.lucene.Lucene;
            indexWriter.addDocuments(docs, uid);
        if (engineConfig.isEnableGcDeletes()) {
                        if (dv.isTombstone(docId)) {
                if (versionMap.isUnsafe()) {
            }
                        flush();
        ensureOpen();
        }
    @Override
    /**
     * called while the write lock is hold or in a disaster condition ie. if the engine
import org.apache.lucene.document.LongPoint;
     *
    protected final IndexingStrategy planIndexingAsNonPrimary(Index index) throws IOException {
    @Override
                    commitData.put(FORCE_MERGE_UUID_KEY, currentForceMergeUUID);
                                Translog.Operation operation = translogManager.readOperation(versionValue.getLocation());
        }
            throw ex;
            if (isContextAwareEnabled) {
     * failure is the owning request's to report, and the drainer carries on with the remaining scopes. The documents of
import java.util.stream.Stream;
            && (engineConfig.getThreadPool().relativeTimeInMillis() - ((DeleteVersionValue) versionValue).time) > getGcDeletesInMillis()) {
            if (upgrade) {
            final IdOnlyFieldVisitor idFieldVisitor = new IdOnlyFieldVisitor();
                }
                    assert indexResult.getResultType() == Result.Type.FAILURE : indexResult.getResultType();
                    if (plan.executeOpOnEngine) {
                    softDeletesPolicy,
import java.util.concurrent.CountDownLatch;
                }
        ExternalReaderManager externalReaderManager = null;
            // it's a save operation since we acquire the reader which incs it's reference but then down the road
                                location = innerNoOp(noOp).getTranslogLocation();
    }
        }
                if (waitIfOngoing == false) {
        }
        }
        }
                addDocs(index.docs(), documentIndexWriter, index.uid());
            final VersionsAndSeqNoResolver.DocIdAndVersion docIdAndVersion;
         * This is ok because (1) this is the only place we call forceMerge, (2) we have a single
        } finally {
        assert seqNo <= maxSeqNoOfUpdates : "id=" + id + " seq_no=" + seqNo + " msu=" + maxSeqNoOfUpdates;
import org.opensearch.core.index.shard.ShardId;
        }
            throw e;
    }
            logger.warn("could not lock IndexWriter", ex);
            );
                        );
        EngineMergeScheduler scheduler = null;
            try {
 * specific language governing permissions and limitations
    @Override
     * Returns the number of times a version was looked up either from the index.
        return localCheckpointTracker.getPersistedCheckpoint();
        try (Releasable ignored = noOpKeyedLock.acquire(seqNo)) {
        assert incrementVersionLookup(); // used for asserting in tests
                 * and just use addDocument instead of updateDocument and skip the entire version and index lookupVersion across the board.
                    }
     *
                    internalReaderManager.release(reader);
            if (isWarmedUp == false || newReader != referenceToRefresh) {
                            advanceMaxSeqNoOfUpdatesOrDeletesOnPrimary(index.seqNo());
        return indexingStrategyPlanner.planOperationAsNonPrimary(index);
            return true;
                // authority has not replicated yet.
            // For composite IndexWriter, we need to validate that lock is on either the new map or old map. This is because,
     * @return
     * The flush threshold is stamped in alongside the bytes rather than read from settings on the flush poll, so that
        index.parsedDoc().version().setLongValue(plan.version);
                 *  - doc B has autoGeneratedIdTimestamp = 9, isRetry = false
            return OpVsEngineDocStatus.OP_NEWER;
        return true;
    private void flushAndCloseInternal() throws IOException {
        VersionValue versionValue = getVersionFromMap(op.uid().bytes());
    public NoOpResult noOp(final NoOp noOp) throws IOException {
    /**
        if (e instanceof AlreadyClosedException) {
                    translogManager.ensureCanFlush();
            internalReaderManager.maybeRefreshBlocking();
            } catch (final Exception inner) {
        assert OpenSearchDirectoryReader.unwrap(searcher.getDirectoryReader()) != null
                                plan.version,
     */
                        // free up transient disk usage of the (presumably biggish) segments that were just merged
                            && !(indexResult.getFailure() instanceof AppendOnlyIndexOperationRetryException)) {
                        generateSeqNoForOperationOnPrimary(delete),
         */
    protected final SoftDeletesPolicy softDeletesPolicy;
            }
                this.versionMap.clear();
                        : "local checkpoint tracker is not updated seq_no=" + op.seqNo() + " id=" + op.id();
    }
        assert op.seqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO : "resolving ops based on seq# but no seqNo is found";
             * we are handling a tragic even exception here */
        return committedInfos != null
            if (localCheckpointTracker.getPersistedCheckpoint() < localCheckpointTracker.getMaxSeqNo()) {
                    flush(false, true);
                        delete.routing()
                        if (isClosed.get() == false) {
     * remote segment upload path after every successful segments sync (see RemoteStoreRefreshListener). Stamped with
                );
            && settings.isRemoteStoreEnabled()
        return lastRefreshedCheckpointListener.pendingCheckpoint();
            warmer = engineConfig.getWarmer();
            }
                }
                internalReaderManager = new OpenSearchReaderManager(directoryReader);
            if (success == false) {
        }
                    store.decRef();
                    delete.id(),
                }
                    store.decRef();
                    }
                    SequenceNumbers.UNASSIGNED_SEQ_NO,
        }
    public String getForceMergeUUID() {
        translogDeletionPolicy.setRetentionAgeInMillis(translogRetentionAge.millis());
            commitData.put(entry.getKey(), entry.getValue());
                    if (get.isReadFromTranslog()) {
            failEngine("already closed by tragic event on the translog", translogManager.getTragicExceptionIfClosed());
         * variable and that this setting will thus apply to the next forced merge that will be run.
            } catch (Exception e) {
            if (docIdAndVersion != null) {
        }
        if (flushFirst) {
                maxSeqNoOfUpdatesOrDeletes::get,
        switch (scope) {
            indexWriter.softUpdateDocument(uid, docs.get(0), version, seqNo, primaryTerm, softDeletesField);
                throw new IllegalStateException("unknown scope: " + scope);
            try {
                releaseIndexCommit(safeCommit);
     * Marks the given seq_no as seen and advances the max_seq_no of this engine to at least that value.
                }
    }
            while ((docId = iterator.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
            if (referenceToRefresh == newReader) {
            lastCommittedSegmentInfos = store.readLastCommittedSegmentsInfo();
    protected final ReferenceManager<OpenSearchDirectoryReader> getReferenceManager(SearcherScope scope) {
                                            null,
        // The write lock only orders this against other engine-level writers; the caller is responsible for
        return throttle.throttleLockIsHeldByCurrentThread();
        } catch (IOException ex) {
            }
                            generateSeqNoForOperationOnPrimary(index),
import org.opensearch.core.common.unit.ByteSizeValue;
                docIdAndVersion = VersionsAndSeqNoResolver.loadDocIdAndVersion(
                                    final Translog.Index index = (Translog.Index) operation;
            for (ReferenceManager.RefreshListener listener : engineConfig.getExternalRefreshListener()) {
                    }
                engineConfig.getShardId(),
    }
            engineFailed = true;
                 */
        if (scope == SearcherScope.EXTERNAL) {
                } else {
            throw e;
    protected boolean assertNonPrimaryOrigin(final Operation operation) {
                    public void onFailure(String reason, Exception ex) {
     * Whether we should treat any document failure as tragic error.
                 * {@link IndexWriter#commit()} call flushes all documents, we defer computation of the maximum sequence number to the time
                    maybeFailEngine("index id[" + index.id() + "] origin[" + index.origin() + "] seq#[" + index.seqNo() + "]", e);
                 * segments, including the local checkpoint amongst other values. The maximum sequence number is different, we never want
                                            index.version(),
                        logger.warn("failed to prepare/warm", e);
                }
            int docId;
    }
    private Engine.Searcher wrapSearcher(Engine.Searcher searcher) {
    private void updateDocs(
     *
        assert assertMaxSeqNoOfUpdatesIsAdvanced(delete.uid(), delete.seqNo(), false, false);
    public GetResult get(Get get, BiFunction<String, SearcherScope, Engine.Searcher> searcherFactory) throws EngineException {
        if (count == 0) {
            indexWriter.addDocument(docs.get(0), uid);
        assert count >= 1 : "invalid post-increment throttleRequestCount=" + count;
        assert assertNonPrimaryOrigin(delete);
     * UUID value that is updated every time the engine is force merged.
     */
                tragicException = (Exception) writerTragicException;
                    }
                        index = new Index(
import org.apache.lucene.search.TermQuery;
                closeInternal();
     * Closes the engine without acquiring the write lock. This should only be
                // we expose what has been externally expose in a point in time snapshot via an explicit refresh
        }
        flushActiveBatchBeforeInlineWrite();
        return Stream.concat(versionMap.getAllCurrent().entrySet().stream(), versionMap.getAllTombstones().entrySet().stream())
                            } catch (IOException e) {
    }
                this::compareOpToLuceneDocBasedOnSeqNo,
            this.lastRefreshedCheckpointListener = new LastRefreshedCheckpointListener(localCheckpointTracker);
            );
        try {
        // we have to flush outside of the readlock otherwise we might have a problem upgrading
         * - If seq#(o1) <= LCP, then it will be not be added to Lucene, as it was already previously added.
    }
    private final IndexingThrottler throttle;
                 */
     */
                    assert dv.isTombstone(docId);
import org.opensearch.index.translog.Translog;
                                            index.primaryTerm(),
    boolean hasSnapshottedCommits() {
    }
        versionMap.pruneTombstones(Long.MAX_VALUE, localCheckpointTracker.getMaxSeqNo());
                flushLock.lock();
        } catch (Exception e) {
                    versionValue = getVersionFromMap(get.uid().bytes());
                documentCountTracker.releaseInFlightDocs(reservedDocs);
    @Override
        // TODO: maybe we should just put a scheduled job in threadPool?
     * Commits the specified index writer.
                    final Translog.Location translogLocation = trackTranslogLocation.get() ? indexResult.getTranslogLocation() : null;
    private IndexResult indexIntoLucene(Index index, IndexingStrategy plan) throws IOException {
                    if (curr == null
                    success = true;
                    internalReaderManager.removeListener(versionMap);
            LuceneChangesSnapshot snapshot = new LuceneChangesSnapshot(
        }
import org.apache.lucene.index.SegmentInfos;
                throw new EngineCreationFailureException(shardId, "failed to create engine", e);
        try {
            case INTERNAL:
            } else {
            if (flushLock.tryLock() == false) {
import java.io.IOException;
                // TRANSLOG_UUID belongs to whichever copy uploaded the segments.
            this.deletionStrategyPlanner = new DeletionStrategyPlanner(
import org.opensearch.common.concurrent.GatedCloseable;
        } catch (IOException e) {
 * @opensearch.internal
                tragicException = new RuntimeException(writerTragicException);
        refreshIfNeeded(source, toSeqNo);
    /**
            try {
    }
                    );
            // Doc version will be maintained in version map till afterRefresh of parent ReaderManager. Since before refresh we sync the
 *
                        if (segment.getName().equals(segmentInfoPerCommit.info.name)) {
                success = true;
            int reservedDocs = 0;
                        failOnTragicEvent(e);
    }
    private volatile PrimaryOperationPolicy primaryOperationPolicy;
    }
            final Exception tragicException;
import org.opensearch.index.merge.OnGoingMerge;
                        }
    private LocalCheckpointTracker createLocalCheckpointTracker(
                                        new Engine.Searcher(
        maybePruneDeletes();
                // we hit a significant merge which would allow us to free up memory if we'd commit it hence on the next change
                    delete.origin(),
        if (docs.size() > 1) {
                // TODO: Check if isClose check in getTragicException will cause any issue here
            }
                    } catch (Exception e) {
                scope = SearcherScope.EXTERNAL;
                };
    private OpVsEngineDocStatus compareOpToLuceneDocBasedOnSeqNo(final Operation op) throws IOException {
                documentCountTracker::tryAcquireInFlightDocs,
                 * the maximum sequence number to be less than the last sequence number to go into a Lucene commit, otherwise we run the
            translogManager.trimUnreferencedReaders();
         * - If a replica subsequently is promoted, user experience is maintained as that replica remembers deletes for the last GC cycle.
        updateAutoIdTimestamp(newTimestamp, true);
                        delete.uid(),
            this.bytes = bytes;
                if (documentIndexWriter.validateImmutableFieldNotUpdated(index.docs().get(0), op.uid().bytes())) {
        } catch (final AssertionError e) {
                }
                if (upgrade) {
    long getNumDocUpdates() {
        // a spurious flush.
        );
     * Returns the current local checkpoint getting refreshed internally.
                getMergedSegmentTransferTracker()
    protected TranslogManager createTranslogManager(
            try (ReleasableLock lock = writeLock.acquire(); Releasable ignored = documentIndexWriter.obtainWriteLockOnAllMap();) {
    }
        return numDocUpdates.count();
    }
                 *  - doc A has autoGeneratedIdTimestamp = 10, isRetry = false
                }
        assert readLock.isHeldByCurrentThread() || writeLock.isHeldByCurrentThread();
        }
                    }
    }
                final DocIdAndSeqNo docAndSeqNo = VersionsAndSeqNoResolver.loadDocIdAndSeqNo(searcher.getIndexReader(), op.uid());
        closeNoLock("api", closedLatch);
            );
        private final OpenSearchReaderManager internalReaderManager;
            }
    /**
                    // generate or register sequence number
    }
                        throw e;
        /*
                .softDeletesPolicy(softDeletesPolicy)
            }
                 * we can potentially handle the exception before the engine is failed.
            throw new RefreshFailedEngineException(shardId, e);
                    throw new EngineCreationFailureException(shardId, "failed to create engine", e);
            final CombinedDocValues dv = new CombinedDocValues(leaf.reader());
            store.decRef();
        return true;
        } catch (final Exception e) {
        translogDeletionPolicy.setRetentionSizeInBytes(translogRetentionSize.getBytes());
        return versionMap.isSafeAccessRequired();
    protected Optional<Exception> preFlightCheckForNoOp(final NoOp noOp) throws IOException {
            if (documentIndexWriter.hasPendingMerges() == false
                        logger.trace("starting commit for flush; commitTranslog=true");
                if (internalReaderManager != null) {
    }
                    );
            case EXTERNAL:
    public long getIndexThrottleTimeInMillis() {
            throw new EngineException(shardId, e.getMessage(), e);
        ensureOpen();
    }
     * @param flushThresholdBytes  uncommitted segment bytes at or above which to flush, resolved by the publisher
                        referenceManager.maybeRefreshBlocking();
        // throw and AssertionError if the tragic event condition is not met.
                        logger.debug(
            return snapshot.get();
            }
                this.localCheckpointTracker = createLocalCheckpointTracker(localCheckpointTrackerSupplier);
                            delete.uid().bytes(),
                }
     */
            );
         * primary for user facing APIs but this arbitrary time limit is problematic for replicas. On replicas however we should
                    Locale.ROOT,
                maybeFailEngine(FORCE_MERGE, e);
        } finally {
                searcher = acquireSearcher(source, SearcherScope.INTERNAL, this::wrapSearcher);
    }
        // the file set and the generation stamp are both taken from this single snapshot, so the published value is
    LocalCheckpointTracker getLocalCheckpointTracker() {
            try {
            this.committedInfosGeneration = committedInfosGeneration;
             * closing the engine as well. If we are not closed we pass it on to failOnTragicEvent which ensures
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {
                        || compareOpToVersionMapOnSeqNo(idFieldVisitor.getId(), seqNo, primaryTerm, curr) == OpVsEngineDocStatus.OP_NEWER) {
                    delete = new Delete(
     * this specialized implementation an external refresh will immediately be reflected on the internal reader
        return localCheckpointTracker.getProcessedCheckpoint();
            }
     */
        final long localCheckpointBeforeRefresh;
                    } else {
    private final OpenSearchReaderManager internalReaderManager;
        return softDeletesPolicy.acquireRetentionLock();
            && settings.isSegRepEnabledOrRemoteNode();
    }
        }
        }
    private IndexingStrategy planIndexingAsPrimary(Index index) throws IOException {
                 *  while both docs are in flight, we disconnect on one node, reconnect and send doc A again
                    refreshListener.accept(newReader, isWarmedUp ? referenceToRefresh : null);
                toSeqNo,
                }
    /**
    long getNumVersionLookups() { // for testing
                            index.getIfPrimaryTerm()
    }
                    failOnTragicEvent(ex);
        if (shouldFlushOnUncommittedSegmentBytes()) {
                mp.setUpgradeInProgress(false, false);
                    for (Segment segment : segmentsArr) {
                );
                + seqNo
        boolean success = false;
        } catch (Exception e) {
    }
            if (noOpResult.getTranslogLocation() == null) {
            maxUnsafeAutoIdTimestamp.updateAndGet(curr -> Math.max(curr, newTimestamp));
     */
import org.opensearch.index.translog.TranslogCorruptedException;
                    assert index.docs() != null && index.docs().isEmpty() == false;
            engineConfig.getTranslogConfig(),
        final IndexSearcher searcher = new IndexSearcher(directoryReader);
    }
    // incoming indexing ops to a single thread:
import java.util.concurrent.atomic.AtomicLong;
            && versionValue.isDelete()
        final Map<String, String> commitData = new HashMap<>(8);
    }
            throttle = new IndexingThrottler();
                    isWarmedUp = true;
            for (ReferenceManager.RefreshListener listener : engineConfig.getInternalRefreshListener()) {
    }
            assert false : "max_seq_no_of_updates on primary is unassigned";
        }
            } else {
     * <p>A scope's append failure belongs to the bulk that owns the scope: the scope has recorded it, completed its
                try (Searcher searcher = acquireSearcher("restore_version_map_and_checkpoint_tracker", SearcherScope.INTERNAL)) {
            return planDeletionAsPrimary(delete);
            flushActiveTranslogBatches();
            // checkpoint.
        return mergeScheduler.onGoingMerges().size();
     * though it reads the policy at several points.
        return numDocDeletes.count();
                accurateCount
            try {
            }
                // We always open reader on parent IndexWriter.
                assert index.docs() != null && index.docs().isEmpty() == false;
        try {
        } catch (RuntimeException | IOException e) {
                        // a temporary debugging to investigate test failure - issue#32827. Remove when the issue is resolved
            return;
        } catch (IOException e) {
}
                        refreshed = true;
    @Override
        // NOTE: we don't throttle this when merges fall behind because delete-by-id does not create new segments:
        final Query query = new BooleanQuery.Builder().add(
    }
            localCheckpointBeforeRefresh = localCheckpointTracker.getProcessedCheckpoint();
    private final CounterMetric numDocDeletes = new CounterMetric();
                final Map<String, String> commitData = new HashMap<>(7);
                                }
            switch (source) {
        try {
        // We don't guard w/ readLock here, so we could throw AlreadyClosedException
                 * if we have an autoGeneratedID that comes into the engine we can potentially optimize
                        if (pending != null) {
        refreshIfNeeded(source, toSeqNo);
                public void onFailure(Exception e) {
         */
import org.opensearch.index.shard.IndexShard;
                writer = getDocumentIndexWriter();
                         * index being corrupt, or the Lucene document limit. We have already issued a sequence number here so this is
import org.opensearch.common.SuppressForbidden;
        } else if (e != null && ((documentIndexWriter.getTragicException() == e) || (translogManager.getTragicExceptionIfClosed() == e))) {
import java.util.Arrays;
                 *
            documentIndexWriter.deleteDocument(
                                if (operation != null) {
                Releasable indexThrottle = doThrottle ? throttle.acquireThrottle() : () -> {}
            }
        long seqNo,
                        delete.startTime(),
            try {
                 *  - is preserved in the transaction log
        }
            } else if (plan.useUpdateDocument) {
    @Override
import java.util.Objects;
        }
        // even though it is an update (overwrites index-1). We should relax this assertion if there is a pending gap in the seq_no.
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
        } catch (LockObtainFailedException ex) {
    }
                + "] but was unassigned";
                } else if (maxNumSegments <= 0) {
                            }
    @Override
import org.opensearch.common.metrics.CounterMetric;
                    status = OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
        } catch (AlreadyClosedException ex) {
                commitData.put(MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, Long.toString(maxUnsafeAutoIdTimestamp.get()));
                                maybeFailEngine("realtime_get", e); // lets check if the translog has failed with a tragic event
                return externalReaderManager;
                        }
        }
                lastCommittedSegmentInfos = store.readLastCommittedSegmentsInfo();
            || index.origin() == Operation.Origin.LOCAL_RESET;
            if (get.realtime()) {
        try (ReleasableLock ignored = writeLock.acquire()) {
            shouldPeriodicallyFlushAfterBigMerge.set(false);
         * causing us to fail the forceMerge
        if (primaryOperationPolicy.acceptsPreAssignedSeqNos()) {
        try {
                } else {
                noOpResult = new NoOpResult(noOp.primaryTerm(), noOp.seqNo());
    @Override
            // IndexWriters with parent writers, version will be either present in version map or in parent IndexWriter. So we do not need
            final PrimaryOperationPolicy refreshed = engineConfig.getPrimaryOperationPolicy();
            }
            try (Searcher searcher = acquireSearcher("load_version", SearcherScope.INTERNAL)) {
            if (success == false) {
        numDocAppends.inc(docs.size());
                                            IndexSearcher.getDefaultSimilarity(),
    private volatile SegmentInfos lastCommittedSegmentInfos;
        }
 */
        @Override
                            new DeleteVersionValue(
     * @return true if the given operation was processed; otherwise false.
        } else {
            ensureOpen();
        // Revisit the deletion policy if we can clean up the snapshotting commit.
                    failEngine(MERGE_FAILED, new MergePolicy.MergeException(exc));
            final ParsedDocument tombstone = engineConfig.getTombstoneDocSupplier().newDeleteTombstoneDoc(delete.id(), delete.routing());
        return writer;
        // We check for pruning in each delete request, but we also prune here e.g. in case a delete burst comes in and then no more deletes
                        throw new VersionConflictEngineException(
        try {
                            versionMap.putIndexUnderLock(uid, new IndexVersionValue(null, dv.docVersion(docId), seqNo, primaryTerm));
                 *  - and is assigned before we start to index / replicate
            /* in this case we first check if the engine is still open. If so this exception is just fine
    private final AtomicLong maxSeqNoOfUpdatesOrDeletes;
    }
                    documentIndexWriter.forceMergeDeletes(true /* blocks and waits for merges*/);
                    );
                 */
    }
    public List<Segment> segments(boolean verbose) {
    }
     */
                documentIndexWriter.deleteUnusedFiles();
        // the to a write lock when we fail the engine in this operation
                    refresh("force merge");
        return new SoftDeletesPolicy(
    private boolean treatDocumentFailureAsTragicError(Index index) {
 * The OpenSearch Contributors require contributions made to
    }
    @Override
            return OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
                    localCheckpointTracker.markSeqNoAsProcessed(indexResult.getSeqNo());
                            force,
                }
                searcher.setQueryCache(null);
    ) throws IOException {
     */
    }
            if (config().getIndexSettings().isDerivedSourceEnabled()) {
        private final Logger logger;
                    throw new FlushFailedEngineException(shardId, e);
                try {
    }
        DocumentIndexWriter writer;
                // does not lock translog or prevents unreferenced files from trimming.
    private final Object refreshIfNeededMutex = new Object();
            config().getIndexSettings().getFlushThresholdSize().getBytes()
                    warmer.warm(reader);
     * Returns the number of documents have been updated since this engine was opened.
        } else {
                primaryOperationPolicy = refreshed;
                        // A noop tombstone does not require a _version but it's added to have a fully dense docvalues for the version
                } catch (IOException e) {
        /* Update the document's sequence number and primary term; the sequence number here is derived here from either the sequence
                flushActiveTranslogBatches();
package org.opensearch.index.engine;
            if (delete.origin().isFromTranslog() == false && deleteResult.getResultType() == Result.Type.SUCCESS) {
                if (versionValue != null) {
                    advanceMaxSeqNoOfUpdatesOrDeletesOnPrimary(delete.seqNo());
                deleteResult = (DeleteResult) plan.earlyResultOnPreFlightError.get();
     * Generate the sequence number for the specified operation.
                this.combinedDeletionPolicy = new CombinedDeletionPolicy(
    protected VersionValue resolveDocVersion(final Operation op, boolean loadSeqNo) throws IOException {
    }
                        versionMap.putDeleteUnderLock(
                final EngineException closeFailure = new EngineException(shardId, "engine closed with pending translog batches: " + reason);
        }
                }
        }
        } finally {
                .openMode(IndexWriterConfig.OpenMode.APPEND)
            }
            // sequence number should not be set when operation origin is primary
            pruneDeletedTombstones();
                                delete.seqNo(),
                        commitIndexWriter(documentIndexWriter, translogManager.getTranslogUUID());
    public final long getMinRetainedSeqNo() {
    /**
     * flush trigger until the next sync, never cause a spurious flush.
                if (ExceptionsHelper.stackTrace(e).contains("org.apache.lucene.index.IndexWriter.filesExist")) {
                maybeFailEngine("flush", ex);
        return true;
        }
                        }
        }
        try (ReleasableLock ignored = readLock.acquire(); Releasable ignored2 = versionMap.acquireLock(delete.uid().bytes())) {
     * Fetch the latest {@link SegmentInfos} from the current ReaderManager's active DirectoryReader.
    }
                this::compareOpToLuceneDocBasedOnSeqNo,
            }
            throttle.activate();
            Segment[] segmentsArr = getSegmentInfo(lastCommittedSegmentInfos, verbose);
            } catch (AssertionError e) {
    @Override
        try {
                logger.debug(() -> new ParameterizedMessage("[{}] batched translog append failed while draining", shardId), e);
                @Override
     */
                                );
        }
    public CompletionStats completionStats(String... fieldNamePatterns) {
import org.opensearch.ExceptionsHelper;
    @Deprecated(forRemoval = true)
            assert false : "wait_if_ongoing must be true for a force flush: force=" + force + " wait_if_ongoing=" + waitIfOngoing;
    public SafeCommitInfo getSafeCommitInfo() {
         * The way we implement upgrades is a bit hackish in the sense that we set an instance
                historyUUID = loadHistoryUUID(commitData);
    private final KeyedLock<Long> noOpKeyedLock = new KeyedLock<>();
    }
                // reset it just to make sure we reset it in a case of an error
                maybeFailEngine("delete", e);
        /*
    }
        maxSeqNo = seqNoStats.maxSeqNo;
                } else {
            return true;
                    activateThrottling();
                return new IndexResult(ex, Versions.MATCH_ANY, index.primaryTerm(), index.seqNo());
    public long getPersistedLocalCheckpoint() {
        assert Objects.equals(delete.uid().field(), IdFieldMapper.NAME) : delete.uid().field();
        }
                // if we can't get the lock right away we block if needed otherwise barf
        // exception that should only be thrown in a tragic event. we pass on the checks to failOnTragicEvent which will
                this::hasBeenProcessedBefore,
                        final IndexVersionValue.PendingLocation pending = plan.executeOpOnEngine
        activeBatch.set(batch);
            }
        }
            }
                activeBatches.clear();
                this::resolveDocVersion,
    @Override
import org.apache.lucene.search.ScoreMode;
        return numIndexVersionsLookups.count();
                    e.addSuppressed(inner);
                    if (index.origin() == Operation.Origin.PRIMARY) {
import org.apache.lucene.index.IndexWriterConfig;
        final SegmentInfos committedInfos = this.lastCommittedSegmentInfos;
                            : "Noop tombstone document but _tombstone field is not set [" + doc + " ]";
import org.apache.lucene.index.SegmentCommitInfo;
    ) throws IOException {
        protected void decRef(OpenSearchDirectoryReader reference) throws IOException {
        final DeleteResult deleteResult;
import org.opensearch.search.suggest.completion.CompletionStats;
                deleteResult.setTranslogLocation(location);
            }
                    "delete id[%s] origin [%s] seq#[%d] failed at the document level",
                if (engineConfig.getIndexSettings().getIndexMetadata().useIngestionSource() == false) {
     * This count does not include the appends from the existing segments before opening engine.
            completionStatsCache = new CompletionStatsCache(() -> acquireSearcher("completion_stats"));
    }
     * Executes a pre-flight check for a given NoOp.
    protected final String historyUUID;
                            get.getIfPrimaryTerm(),
    /**
                    assert upgrade == false;
        return throttle.getThrottleTimeInMillis();
        final DocumentIndexWriter indexWriter,
            this.documentCountTracker = new DocumentCountTracker(
        final VersionValue versionValue = versionMap.getVersionForAssert(index.uid().bytes());
        } catch (IOException e) {
            assert assertPrimaryIncomingSequenceNumber(origin, seqNo);
        if (current != null) {
                    op.uid(),
     */
    /**
                } catch (Exception e) {
     */
    }
     * Checks whether the uncommitted segment bytes published by the remote segment upload path breach the threshold
import org.opensearch.common.util.io.IOUtils;
                } else if (op.seqNo() > docAndSeqNo.seqNo) {
        }
        } catch (final Exception ex) {
    public boolean refreshNeeded() {
                        // field. 1L is selected to optimize the compression because it might probably be the most common value in
            engineConfig.getPrimaryTermSupplier(),
        boolean accurateCount
                        // in refresh listeners.
            this.refreshListener = refreshListener;
    }
import org.apache.lucene.store.Directory;
    public Closeable acquireHistoryRetentionLock() {
     * This count does not include the updates from the existing segments before opening engine.
                }
    }
            ensureOpen();
    }
            }
    /**
    }
    private final Set<TranslogBatchScope> activeBatches = ConcurrentHashMap.newKeySet();
                        batch.add(new Translog.Index(index, indexResult), indexResult, pending, indexResult.getSeqNo());
        public synchronized void beforeMerge(OnGoingMerge merge) {
    @Override
        return true;
            } else if (merge.getTotalBytesSize() >= engineConfig.getIndexSettings().getFlushAfterMergeThresholdSize().getBytes()) {
                }
                        if (latestCommit != null) {
                 * to detect if it has potentially been added before. We use the documents timestamp for this since it's something
    private static final class UncommittedSegmentBytes {
            .add(Queries.newNonNestedFilter(), BooleanClause.Occur.MUST)
                    loadSeqNo,
    public void writeIndexingBuffer() throws EngineException {
        }
        boolean onlyExpungeDeletes,
    private VersionValue getVersionFromMap(BytesRef id) {
 *
    private final CounterMetric numVersionLookups = new CounterMetric();
    /** Returns how many bytes we are currently moving from indexing buffer to segments on disk */
                assert maxUnsafeAutoIdTimestamp.get() == -1 : "max unsafe timestamp was assigned already ["
     * Restores the live version map and local checkpoint of this engine using documents (including soft-deleted)
    /**
     * the failed scope are unacknowledged with unprocessed sequence numbers, the same state the stock engine leaves a
    }
                if (deferred == false && plan.executeOpOnEngine && indexResult.getResultType() == Result.Type.SUCCESS) {
            engineConfig.getGlobalCheckpointSupplier(),
                    final VersionValue curr = versionMap.getUnderLock(uid);
         */
            }
            // nothing has changed - both ref managers share the same instance so we can use reference equality
                    // When context aware is enabled, we are always doing a blocking refresh.
    @Override
                return 0;
            engineFailed = false;
                internalReaderManager.release(newReader);
         */
        @Override
        }
                            segment.mergeId = onGoingMerge.getId();
                    throw new UnsupportedOperationException(
            // them inside the try so a drain failure keeps refresh's EngineException contract and tragic-event handling,
        }
     * is stale (e.g. right after a flush) and is ignored until the next sync republishes.
        );
                    } else {
                    assert localCheckpointTracker.hasProcessed(op.seqNo()) || segRepEnabled
    }
            this.lastDeleteVersionPruneTimeMSec = engineConfig.getThreadPool().relativeTimeInMillis();
     * This also prevents segment starvation where an internal reader holds on to old segments literally forever
        }
        }
        public synchronized void afterMerge(OnGoingMerge merge) {
    private boolean assertIncomingSequenceNumber(final Engine.Operation.Origin origin, final long seqNo) {
        final Map<String, String> commitUserData = store.readLastCommittedSegmentsInfo().userData;
                final long seqNo = dv.docSeqNo(docId);
            }
        return numDocAppends.count();
                    Index index = (Index) op;
                        }
                if (flush) {
                scope = SearcherScope.INTERNAL;
            throw new AssertionError("Unexpected AlreadyClosedException", ex);
import org.apache.logging.log4j.Logger;
        }
        final Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
    private DeleteResult deleteInLucene(Delete delete, DeletionStrategy plan) throws IOException {
import org.opensearch.OpenSearchException;
    private boolean shouldFlushOnUncommittedSegmentBytes() {
    // The value of this marker never goes backwards, and is tracked/updated differently on primary and replica.
                            failEngine("no-op origin[" + noOp.origin() + "] seq#[" + noOp.seqNo() + "] failed at document level", ex);
    public int getActiveMergeCount() {
        if (allowDeleted) {
                        && !(indexResult.getFailure() != null
            this::ensureOpen,
                    delete.seqNo()
                        delete.origin(),
        // Parallel to acquireSafeIndexCommit: pin a safe Lucene commit, wrap its SegmentInfos.
    /**
        refresh("restore_version_map_and_checkpoint_tracker", SearcherScope.INTERNAL, true);
            logger.debug("failed to compute uncommitted segment bytes", e);
     * This method will hold the reader reference until the returned {@link GatedCloseable} is closed.
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.DocIdSetIterator;
            // this case, write lock may not be present on the new map, but lock maybe present on the old map. In this
        } catch (IOException ex) {
                localCheckpointTracker.markSeqNoAsPersisted(seqNo);
                    } else {
        return numVersionLookups.count();
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {
        if (docs.size() > 1) {
    protected void advanceMaxSeqNoOfUpdatesOrDeletesOnPrimary(long seqNo) {
    private final boolean isContextAwareEnabled;
                // To sync document during commit. This keeps documents during commit always ahead of checkpoint.
        TranslogManager translogManagerRef = null;
                    }
                        } else if (indexResult.getSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
    // we use the hashed variant since we iterate over it and check removal and additions on existing keys
                for (TranslogBatchScope batch : activeBatches) {
     * refreshes to clear version map memory etc. this can cause excessive segment creation if heavy indexing
                 *
import java.util.concurrent.locks.ReentrantLock;
                } else {
    @Override
    public void close() throws IOException {
                        // we need to refresh in order to clear older version values
                TranslogEventListener internalTranslogEventListener = new TranslogEventListener() {
    /**
                // This shard's sequence numbers are assigned by an upstream authority, which owns the
     * consulted for it exactly as for a per-operation {@code Translog#add} failure. The drainer therefore only stops
    ) {
            }
                try {
                    this.forceMergeUUID = forceMergeUUID;
            assert seqNo >= 0 : "recovery or replica ops should have an assigned seq no.; origin: " + origin;
            }
                );
            final DeletionStrategy plan = deletionStrategyForOperation(delete);
        assert maxUnsafeAutoIdTimestamp.get() <= maxSeenAutoIdTimestamp.get();
     * nulling the field is all that is needed.
             * throw FileNotFoundException or NoSuchFileException can also hit this.
                    @Override
                 *  or calls updateDocument.
        return rwl.isWriteLockedByCurrentThread() && documentIndexWriter.isWriteLockedByCurrentThread();
/**
        if (writerTragicException != null) {
                    // even though we maintain 2 managers we really do the heavy-lifting only once.
             * and expected. We don't hold any locks while we block on forceMerge otherwise it would block
    }
                }
        }
                        config().getShardId(),
                        // the op is coming from the translog (and is hence persisted already) or it does not have a sequence number
                    refresh("unsafe_version_map", SearcherScope.INTERNAL, true);
         * - If seq#(o1)  > LCP, then it depends on the nature of o2:
        return translogManager.shouldPeriodicallyFlush(
    long getGcDeletesInMillis() {
    }
        // We don't have to do this here; we do it defensively to make sure that even if wall clock time is misbehaving
        }
                        }
    public boolean isThrottled() {
            // to resolve version from child level IndexWriters (both from mark for refresh and active IndexWriter).
    /**
                        indexResult.setTook(System.nanoTime() - index.startTime());
            + "local_checkpoint="
    private boolean incrementIndexVersionLookup() {
                        refresh("version_table_flush", SearcherScope.INTERNAL, true);
            /*
    private final CounterMetric numDocUpdates = new CounterMetric();
        return noOpResult;
            }
            engineConfig.getTranslogFactory(),
    protected final TranslogManager translogManager;
            try (Searcher searcher = acquireSearcher("assert doc doesn't exist", SearcherScope.INTERNAL)) {
            }
        final SegmentInfos committedInfos = this.lastCommittedSegmentInfos;
        }
    boolean isSafeAccessRequired() {
                }
    public InternalEngine(EngineConfig engineConfig) {
                    documentIndexWriter.rollback();
        maybePruneDeletes();
        searcher.setQueryCache(null);
        return true;
    }
                        "failed to restore version map and local checkpoint tracker",
     * current last commit so that stale values (e.g. right after a flush, before the next successful segments sync)
            } else {
     * have synced files as well, we should not care about child level writer or updates map as they will belong to new
            assert (isWriteLockHeld()) || failEngineLock.isHeldByCurrentThread()
                 * of invocation of the commit data iterator (which occurs after all documents have been flushed to Lucene).
                        "Updating grouping criteria is not allowed for context aware enabled indices.",
                    logger.warn("Failed to close ReaderManager", e);
            if (refreshed != primaryOperationPolicy) {
                        // version field.
                        delete.getIfPrimaryTerm(),
     * Discards the published accounting, disarming the uncommitted-segment-bytes flush condition until the next
public class InternalEngine extends Engine {
         *      so a lookup can find it and determine that o1 is stale.
                    e.addSuppressed(inner);
        VersionValue versionValue = getVersionFromMap(op.uid().bytes());
                     * confidence that the call stack does not contain catch statements that would cause the error that might be thrown
    public void forceMerge(
                } else {
    }
import org.apache.lucene.index.MergePolicy;
    }
            throw e;
        if (delete.origin() == Operation.Origin.PRIMARY) {
            throw e;
        final long lastMinRetainedSeqNo;
        assert index.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + index.origin();
        return indexingStrategyPlanner.assertPrimaryCanOptimizeAddDocument(index);
                && treatDocumentFailureAsTragicError(index) == false) {
            }
        final boolean upgradeOnlyAncientSegments,
                // randomly throw FNFE/NSFE can also hit this:
             * If assertions are enabled, IndexWriter throws AssertionError on commit if any files don't exist, but tests that randomly
        return localCheckpointTrackerSupplier.apply(maxSeqNo, localCheckpoint);
    protected final LocalCheckpointTracker localCheckpointTracker;
        } catch (IOException e) {
import org.opensearch.common.util.concurrent.AbstractRunnable;
            throw new TranslogException(shardId, "Failed to execute index deletion policy on translog synced", ex);
    protected final DeletionStrategy planDeletionAsNonPrimary(Delete delete) throws IOException {
            return reference.tryIncRef();
         *
                    batch.abort(closeFailure);
            // fill in the merges flag
            this.internalReaderManager = internalReaderManager;
                    || force
                optimizeLock.unlock();
    }
            // this is an anti-viral settings you can only opt out for the entire index
         *   *) If o2 is an indexing then its seq# is either in Lucene (if refreshed) or the VersionMap (if not refreshed yet),
        return deletionStrategyPlanner.planOperationAsNonPrimary(delete);
            final NoOpResult noOpResult;
    @Override
        return refreshed;
                // IndexWriter throws AssertionError on init, if asserts are enabled, if any files don't exist, but tests that
    // An index request is considered as an update if it overwrites existing documents with the same docId in the Lucene index.
                final String reason = String.format(
         * we don't acquire the write lock and wait until we have exclusive access. This might also
                Releasables.close(success, searcher);
                flushAndCloseInternal();
    }
            indexWriter.softUpdateDocuments(uid, docs, version, seqNo, primaryTerm, softDeletesField);
 *
            // write lock on rwl lock taken in the close function call. Once close call completes, new entry in new map
        advanceMaxSeqNoOfUpdatesOrDeletes(seqNo);
            }
                }
import org.opensearch.index.mapper.ParsedDocument;
            } finally {
        return versionValue;
                                    indexResult.getFailure().toString()
                throw new AssertionError("doc [" + index.id() + "] exists in version map (version " + versionValue + ")");
        } else {
     * Updates the uncommitted segment bytes accounting for this (remote-store) shard. Invoked by the remote segment
            LongPoint.newRangeQuery(SeqNoFieldMapper.NAME, getPersistedLocalCheckpoint() + 1, Long.MAX_VALUE),
        ) throws IOException {
        // We treat a delete on the tombstones on replicas as a regular document, then use updateDocument (not addDocument).
                reservedDocs = plan.reservedDocs;
import org.apache.lucene.index.DirectoryReader;
    }
     * Size of segment bytes not yet referenced by the last commit point on a remote-store shard, published by the
        if (isClosed.get() == false) {
        if (activeBatch.get() != null) {
                        null
        localCheckpoint = seqNoStats.localCheckpoint;
                        doc.add(softDeletesField);
    private final OpenSearchConcurrentMergeScheduler mergeScheduler;
                commitData.put(HISTORY_UUID_KEY, historyUUID);
                }
        private final AtomicBoolean isEngineClosed;
                        throw new FlushFailedEngineException(shardId, e);
                    translogDeletionPolicy,
                        final boolean toAppend = plan.executeOpOnEngine && plan.useUpdateDocument == false;
    }
        if (activeBatch.get() == batch) {
            for (OnGoingMerge onGoingMerge : onGoingMerges) {
        logger.trace("recovered maximum sequence number [{}] and local checkpoint [{}]", maxSeqNo, localCheckpoint);
        }
        final long localCheckpoint;
                bytes += file.getValue();
import org.opensearch.index.mapper.IdFieldMapper;
    }
            this::getLocalCheckpointTracker,
            try (ReleasableLock lock = writeLock.acquire(); Releasable ignored = documentIndexWriter.obtainWriteLockOnAllMap();) {
                    }
import java.util.Optional;
            this.logger = logger;
            shardId,
        }
        );
import org.opensearch.index.seqno.LocalCheckpointTracker;
                        } else {
                        }
    public GatedCloseable<IndexCommit> acquireLastIndexCommit(final boolean flushFirst) throws EngineException {
            } finally {
                final Map<String, String> commitData = commitDataAsMap(writer);
            }
        }
            throw new IllegalArgumentException(
                localCheckpointTracker.markSeqNoAsPersisted(noOpResult.getSeqNo());
         *   *) If o2 is a delete then its seq# is recorded in the VersionMap, since seq#(o2) > seq#(o1) > LCP,
                 *  if A' arrives on the shard first we update maxUnsafeAutoIdTimestamp to 10 and use update document. All subsequent
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
                            && (indexResult.getFailure() instanceof AppendOnlyIndexOperationRetryException))) {
            }
            }
                logger.trace("committing writer with commit data [{}]", commitData);
        protected boolean tryIncRef(OpenSearchDirectoryReader reference) {
                            index.getAutoGeneratedIdTimestamp(),
        }
         * o2 is processed normally since it arrives first; when o1 arrives it should be discarded:
/*
            OpenSearchReaderManager internalReaderManager,
            logger.trace("start flush for snapshot");
    // for testing
    public long getLastSyncedGlobalCheckpoint() {
            // non-primary mode (i.e., replica or recovery)
 * Licensed to Elasticsearch under one or more contributor
    /** resolves the current version of the document, returning null if not found */
                        index.uid().bytes(),
import org.apache.lucene.index.IndexWriter;
                    IOUtils.close(externalReaderManager, internalReaderManager);
            }
            } catch (IOException e) {
    }
    }
    private volatile UncommittedSegmentBytes uncommittedSegmentBytes;
        if (batch != null) {
        }
     */
        final TranslogDeletionPolicy translogDeletionPolicy = getTranslogDeletionPolicy(engineConfig);
                throw new EngineCreationFailureException(shardId, "failed to open reader on writer", e);
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            assert versionValue.term == primaryTerm : "primary term not matched; id="
        // TODO: can we enable this check for all origins except primary on the leader?
                });
                     * here from being caught and never reaching the uncaught exception handler.
    private final CounterMetric numIndexVersionsLookups = new CounterMetric();
                                            reader,
                        }
                    || shouldPeriodicallyFlush
        return mergeScheduler.stats();
        ensureOpen();
                doc,
        // for a long time:
            throw e;
                try {
            );
    // max_seq_no_of_updates_or_deletes tracks the max seq_no of update or delete operations that have been processed in this engine.
    /**
            assert tombstone.docs().size() == 1 : "Tombstone doc should have single doc [" + tombstone + "]";
                 * `indexWriter.getTragicException()` will be null otherwise we have to rethrow and treat it as fatal or rather
                    public void onFailure(Exception e) {
            BiConsumer<OpenSearchDirectoryReader, OpenSearchDirectoryReader> refreshListener
        if (Assertions.ENABLED) {
                mp.setUpgradeInProgress(true, upgradeOnlyAncientSegments);
        }
                } catch (Exception e) {
        CompositeTranslogEventListener translogEventListener
        try {
            }
     */
    @Override
 * ownership. Elasticsearch licenses this file to you under
        try (Searcher s = acquireSearcher(source, SearcherScope.INTERNAL)) {
        final Throwable writerTragicException = documentIndexWriter.getTragicException();
                    throw new AssertionError("doc [" + index.id() + "] exists [" + docsWithId + "] times in index");
                logger.warn("failed to rollback writer on close", e);
                    @Override
        final OpVsEngineDocStatus status;
                this.externalReaderManager.addListener(listener);
        return primaryOperationPolicy.planDelete(deletionStrategyPlanner, delete);
        final NoOpResult noOpResult;
            noOpResult.freeze();
        }
    }
                         * Document level failures when adding a no-op are unexpected, we likely hit something fatal such as the Lucene
            lastMinRetainedSeqNo,
                delete.seqNo(),
    }
                logger.trace("acquired flush lock immediately");
        if (index.origin() == Operation.Origin.PRIMARY) {
     * and old segments can be released in the same way previous version did this (as a side-effect of _refresh)
    @Override
            }
        // the threshold setting has a hard 1-byte minimum, so current.bytes >= threshold already implies bytes > 0
            // reread the last committed segment infos
            IOUtils.close(searcher);
            return planDeletionAsNonPrimary(delete);
        uncommittedSegmentBytes = new UncommittedSegmentBytes(bytes, committedInfos.getGeneration(), flushThresholdBytes);
            try (
            + documentIndexWriter.getConfig().getMergePolicy().getClass().getName();
                /*
         * We do NOT acquire the readlock here since we are waiting on the merges to finish
            localCheckpointOfLastCommit,
            final OpenSearchDirectoryReader newReader = internalReaderManager.acquire();
        return lastCommittedSegmentInfos;
        return documentCountTracker.getInFlightDocCount();
    public void maybePruneDeletes() {
            throw new OpenSearchException("failed to wrap searcher", ex);
    }
                // TODO we might force a flush in the future since we have the write lock already even though recoveries
                versionMap,
            engineFailed = true;
            // this smells like a bug - we only expect ACE if we are in a fatal case ie. either translog or IW is closed by
         * we have to inc-ref the store here since if the engine is closed by a tragic event
    ) throws EngineException, IOException {
                if (onlyExpungeDeletes) {
    public long getMaxSeqNoOfUpdatesOrDeletes() {
                );
                 *
                        revisitIndexDeletionPolicyOnTranslogSynced();
     */
    }
                    if (success == false) {
        final long maxSeqNoOfUpdates = getMaxSeqNoOfUpdatesOrDeletes();
        if (versionValue == null) {
            try {
                engineConfig.getShardId(),
            // this spot on - we are handling the tragic event exception here so we have to fail the engine
        try (ReleasableLock ignored = readLock.acquire()) {
                failEngine("lucene commit failed", ex);
     */
                // we deadlock on engine#close for instance.
import org.opensearch.core.Assertions;
        if (count == 1) {
        ensureOpen();
import java.util.concurrent.locks.Lock;
    }
            indexWriter.addDocument(docs.get(0), uid);
        store.incRef();
                throw e;
                        final ParseContext.Document doc = tombstone.docs().get(0);
            if (preFlightError.isPresent()) {
                            shardId,
        long fromSeqNo,
     */
                assert delete.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + delete.origin();
 * software distributed under the License is distributed on an
        } catch (RuntimeException | IOException e) {
        } else {
                // document does not exists, we can optimize for create, but double check if assertions are running
        return localCheckpointTracker.hasProcessed(op.seqNo());
                        );
                        // _GET calls invoked by API will also attempt to read from translog when realtime=true (which is the default).
        boolean segRepEnabled = engineConfig.getIndexSettings().isSegRepEnabledOrRemoteNode();
    /**
                SequenceNumbers.max(localCheckpointTracker.getMaxSeqNo(), translogManager.getMaxSeqNo())
            return reference.getRefCount();
    // How many callers are currently requesting index throttling. Currently there are only two situations where we do this: when merges
                }
    private final CounterMetric numDocAppends = new CounterMetric();
                    logger.info("stop throttling indexing: numMergesInFlight={}, maxNumMerges={}", numMergesInFlight, maxNumMerges);
        boolean refreshed;
                if (isContextAwareEnabled) {
                if (delete.origin() == Operation.Origin.PRIMARY) {
                boolean shouldPeriodicallyFlush = shouldPeriodicallyFlush();
    protected boolean maybeFailEngine(String source, Exception e) {
                lastWriteNanos = index.startTime();
                e.addSuppressed(closeEx);
        );
     * a document must precede the delete of the same document, whichever path the caller took to get here.
            this::maybeFailEngine,
                e.addSuppressed(inner);
        Objects.requireNonNull(versionValue);
                                    // in the case of a already pruned translog generation we might get null here - yet very unlikely
    }
     * If this method returns a non-empty result, the engine won't process this NoOp and returns a failure.
import org.apache.lucene.store.LockObtainFailedException;
                    continue;
    protected void pruneDeletedTombstones() {
                requiredFullRange,
    protected long generateSeqNoForOperationOnPrimary(final Operation operation) {
    public boolean maybeRefresh(String source) throws EngineException {
        }
            this.primaryOperationPolicy = engineConfig.getPrimaryOperationPolicy();
             */
            if (ex instanceof AlreadyClosedException == false
    // pkg-private for testing
            // we simply run a blocking refresh on the internal reference manager and then steal it's reader
                } else {
                String translogUUID = Objects.requireNonNull(userData.get(Translog.TRANSLOG_UUID_KEY));
        protected int getRefCount(OpenSearchDirectoryReader reference) {
        mergeScheduler.refreshConfig();
                this.internalReaderManager.addListener(listener);
            }
            this.internalReaderManager.addListener(lastRefreshedCheckpointListener);
                 * only one wins. Yet, only the one that wins will also close the IW and in turn fail the engine such that
        long toSeqNo,
                                        ),
            if (committedFiles.contains(file.getKey()) == false && file.getKey().startsWith(IndexFileNames.SEGMENTS) == false) {
        }
        refresh(source, SearcherScope.EXTERNAL, true);
     *
        boolean shouldFail = super.maybeFailEngine(source, e);
            return OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
import org.opensearch.core.index.AppendOnlyIndexOperationRetryException;
            && settings.isRemoteTranslogStoreEnabled()
            reference.decRef();
    }
            return LuceneChangesSnapshot.countNumberOfHistoryOperations(s, fromSeqNo, toSeqNo);
        } finally {
        public void accept(OpenSearchDirectoryReader reader, OpenSearchDirectoryReader previousReader) {
                 *  - now doc A' has autoGeneratedIdTimestamp = 10, isRetry = true
        try {
        Searcher searcher = null;
        TranslogDeletionPolicy translogDeletionPolicy,
        }
            && engineConfig.getThreadPool().relativeTimeInMillis() - lastDeleteVersionPruneTimeMSec > getGcDeletesInMillis() * 0.25) {
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {
        // if we are already closed due to some tragic exception
            } else {
        } else {
        final IndexCommit lastCommit = combinedDeletionPolicy.acquireIndexCommit(false);
    @Override
import org.opensearch.common.lucene.uid.Versions;
        if (isContextAwareEnabled) {
                    throw e;
        long primaryTerm
    }
                CompositeTranslogEventListener compositeTranslogEventListener = new CompositeTranslogEventListener(
    @Override
        // TODO Check if need to check for isOpen for other IndexWriters as well
                delete.uid(),
        }
                 *  - doesn't change per document
                }
            indexWriter.addDocuments(docs, uid);
                            get.id(),
    /**
        String source,
        }
    public final long lastRefreshedCheckpoint() {
            try {
                    indexResult = (IndexResult) plan.earlyResultOnPreFlightError.get();
    }
            } else {
    }
            );
    protected final void closeNoLock(String reason, CountDownLatch closedLatch) {
     * {@link #refreshPrimaryOperationPolicy()}, so that a single operation sees one consistent policy even
        if (relaxIfGapInSeqNo && localCheckpointTracker.getProcessedCheckpoint() < maxSeqNoOfUpdates) {
        }
import org.apache.lucene.index.Term;
                if (hasUncommittedChanges
                            versionValue.seqNo,
            this::onTranslogBatchFinished,
            this.flushThresholdBytes = flushThresholdBytes;
                reader -> DerivedSourceDirectoryReader.wrap(
            flush(false, true);
    }
    }
            } else {
            }
            }
                logger.trace("rollback indexWriter");
    protected volatile String forceMergeUUID;
    }
        }
        numDocUpdates.inc(docs.size());
        protected void handleMergeException(final Throwable exc) {
            return true;
        // ensuring no indexing operation is in flight, since an operation reads the policy more than once.
                        assert doc.getField(SeqNoFieldMapper.TOMBSTONE_NAME) != null
        } else {
            });
                ex.addSuppressed(inner);
         * We need to deploy two different trimming strategies for GC deletes on primary and replicas. Delete operations on primary
        // config().isEnableGcDeletes() or config.getGcDeletesInMillis() may have changed:
        assert documentIndexWriter.getConfig().getMergePolicy() instanceof OpenSearchMergePolicy : "MergePolicy is "
                + doc
                bootstrapAppendOnlyInfoFromWriter(writer);
    /**
                    deleteResult = new DeleteResult(plan.version, delete.primaryTerm(), delete.seqNo(), plan.currentlyDeleted == false);
        final boolean flush,
        }
    /**
                        internalReaderManager.release(newReader);
    }
                            index.version(),
import org.apache.lucene.util.BytesRef;
            if (isClosed.get() == false) {
                    if (plan.executeOpOnEngine || plan.addStaleOpToEngine) {
    /**
                "wait_if_ongoing must be true for a force flush: force=" + force + " wait_if_ongoing=" + waitIfOngoing
         * are remembered for at least one GC delete cycle and trimmed periodically. This is, at the moment, the best we can do on
        } else {
                final IndexingStrategy plan = indexingStrategyForOperation(index);
                    status = OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
            writer.setLiveCommitData(() -> {
     * that was published with them. Only ever effective on remote-store shards, since the accounting is only published
        BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier
     * publication. {@link #shouldFlushOnUncommittedSegmentBytes()} already treats an absent value as "do not flush", so
                    logger,
                                            reader
            SearcherScope scope;
            final Engine.Searcher newSearcher = IndexShard.wrapSearcher(
                // map so once we pass this point we can safely lookup from the version map.
                }
        return primaryOperationPolicy;
        if (engineConfig.isAutoGeneratedIDsOptimizationEnabled() == false) {
    public void activateThrottling() {
            doc.add(softDeletesField); // soft-deleted every document before adding to Lucene
        final boolean engineFailed;
    private final AtomicInteger throttleRequestCount = new AtomicInteger();
                                final NoOp noOp = new NoOp(
                                location = null;
        return batch;
            try {
            BooleanClause.Occur.MUST
                noOpResult = new NoOpResult(
                versionValue = null;
/*
                    IOUtils.close(translogManager);
                if (isThrottling.getAndSet(true) == false) {
import org.opensearch.index.mapper.SeqNoFieldMapper;
        return new InternalTranslogManager(
import org.opensearch.index.translog.TranslogException;
                return externalReaderManager;
     * Returns the number of times a version was looked up either from memory or from the index.
            } else if (op instanceof Index && versionValue.version > 0) {
                if (currentForceMergeUUID != null) {
     * which includes newly written segments as well as updated per-segment files (e.g. live docs and doc-values
    }
            // steal it by calling incRef on the "stolen" reader
        final UncommittedSegmentBytes current = this.uncommittedSegmentBytes;
    }
            Set<OnGoingMerge> onGoingMerges = mergeScheduler.onGoingMerges();
        try {
     * still holds index operations in its batch, append them first so the translog keeps request order: an index of
                            get.id(),
         * thread for optimize, and the 'optimizeLock' guarding this code, and (3) ConcurrentMergeScheduler
        boolean success = false;
    }
    @Override
            } catch (Exception e) {
    }
            localCheckpointTracker.markSeqNoAsProcessed(deleteResult.getSeqNo());
        if (primaryOperationPolicy.acceptsPreAssignedSeqNos()) {
        try {
                try (Releasable ignore = versionMap.acquireLock(get.uid().bytes())) {
    protected final AtomicBoolean shouldPeriodicallyFlushAfterBigMerge = new AtomicBoolean(false);
            if (warmer != null) {
        } catch (Exception ex) {
        optimizeLock.lock();
                 * Bottom line is that we can only rely on the fact that if it's a document failure then
                for (SegmentCommitInfo segmentInfoPerCommit : onGoingMerge.getMergedSegments()) {
    @Override
                if (hasBeenProcessedBefore(noOp) == false) {
                    if (isEngineClosed.get() == false) {
                final EngineException engineException = new EngineException(shardId, "failed to commit engine", e);
            if (primaryOperationPolicy.acceptsPreAssignedSeqNos()) {
            // map may rotate in between the time when lock was taken on composite IndexWriter and assertion is made. In
                + primaryOperationPolicy
            if (plan.addStaleOpToEngine) {
            assert incrementIndexVersionLookup(); // used for asserting in tests
                    }
    }
            try {
                IOUtils.closeWhileHandlingException(writer, translogManagerRef, internalReaderManager, externalReaderManager, scheduler);
            try {
    @Override
            });
        assert incrementVersionLookup();
                    @Override
     * pending readers exceptionally and rethrows it at {@code finish()}, and {@code maybeFailEngine} has already been
            if (store.tryIncRef()) {
    /**
    @Nullable
            tombstone.updateSeqID(delete.seqNo(), delete.primaryTerm());
            return createWriter(store.directory(), iwc);
     * This reference manager delegates all it's refresh calls to another (internal) ReaderManager
     * updates) of already committed segments. The value is stamped with the generation of the commit point it was
                        if (versionValue.getLocation() != null) {
                                    index.startTime(),
            noOpResult.setTook(System.nanoTime() - noOp.startTime());
            } catch (AlreadyClosedException ex) {
                    assert index.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + index.origin();
        }
                            index.getIfSeqNo(),
     * {@link #clearUncommittedSegmentBytes()}.
                    // This ensures all segments in memory are available to parent writer before triggering a force merge.
         * dec the store reference which can essentially close the store and unless we can inc the reference
                            )
                batch.flush();
            ensureOpen();
                            versionMap.maybePutIndexUnderLock(
            if (numMergesInFlight.incrementAndGet() > maxNumMerges) {
                    }
                            }
        final IndexCommit safeCommit = combinedDeletionPolicy.acquireIndexCommit(true);
            throw e;
                            logger.warn("failed to flush after merge has finished");
            } catch (IOException | TranslogCorruptedException e) {
                 *  maxUnsafeAutoIdTimestamp. While this is not strictly needed for doc B it is just much simpler to implement since it
            translogManager,
        // race can only suppress a flush trigger until the next successful segments sync republishes, never cause
    private void addStaleDocs(final List<ParseContext.Document> docs, final DocumentIndexWriter indexWriter, Term uid) throws IOException {
        }
        ExternalReaderManager(
    }
                logger.info("starting segment upgrade upgradeOnlyAncientSegments={}", upgradeOnlyAncientSegments);
                }
            return newSearcher;
            readLock,
                    shardId
            } else {
        private UncommittedSegmentBytes(long bytes, long committedInfosGeneration, long flushThresholdBytes) {
import org.apache.lucene.index.LiveIndexWriterConfig;
            logger.debug("flushing shard on close - this might take some time to sync files to disk");
                if (e instanceof AlreadyClosedException || translogManager.getTragicExceptionIfClosed() != null) {
     * first such sync dirties the field, the rest are a single volatile read and nothing else. A plain guarded write
                    status = OpVsEngineDocStatus.DOC_NOT_FOUND;
        }
        }
import org.apache.lucene.search.BooleanQuery;
        return true;
            if (numMergesInFlight.decrementAndGet() < maxNumMerges) {
        if (force && waitIfOngoing == false) {
                        return GetResult.NOT_EXISTS;
            activeBatch.remove();
        } catch (Exception e) {
    }
                            index.startTime(),
     * @return the sequence number
    @Nullable
        }
        try (ReleasableLock ignored = writeLock.acquire()) {
                 * non-document failure
                case "segments":
            } catch (Exception inner) {
            try {
    }
import java.util.Set;
                        translogManager.rollTranslogGeneration();
                    store.trimUnsafeCommits(engineConfig.getTranslogConfig().getTranslogPath());
                e.addSuppressed(inner);
    protected static Map<String, String> commitDataAsMap(final DocumentIndexWriter indexWriter) {
                + versionValue.term;
                // no need to commit in this case!, we snapshot before we close the shard, so translog and all sync'ed
        softDeletesPolicy.setRetentionOperations(softDeletesRetentionOps);
                // we can access segment_stats while a shard is still in the recovering state.
        final String forceMergeUUID
        OpenSearchMergePolicy mp = (OpenSearchMergePolicy) documentIndexWriter.getConfig().getMergePolicy();
    }
                    translogManager::getLastSyncedGlobalCheckpoint
    @Override
            engineConfig.getStartedPrimarySupplier(),
                idFieldVisitor.reset();
 * this work for additional information regarding copyright
                        /*
    private final Lock flushLock = new ReentrantLock();
     * is happening and the refresh interval is low (ie. 1 sec)
            close(); // double close is not a problem
        @Override
    }
            final StoredFields storedFields = leaf.reader().storedFields();
                    status = OpVsEngineDocStatus.OP_NEWER;
    ) throws IOException {
                assert assertMaxSeqNoOfUpdatesIsAdvanced(index.uid(), index.seqNo(), true, true);
import org.apache.lucene.search.Weight;
                    logger.debug("engine closed [{}]", reason);
        if (isClosed.compareAndSet(false, true)) {
    @Override
                                // if we have document failure, record it as a no-op in the translog and Lucene with the generated seq_no
                try (Releasable ignored = versionMap.acquireLock(uid)) {
            // best-effort accounting, a failed computation must never affect the segment upload path
                    SequenceNumbers.UNASSIGNED_PRIMARY_TERM,
         *
                // we could fork a thread and do it right away but we try to minimize forking and piggyback on outside events.
     */
     * We should only take care of reopening parent writer here as we will not be concerned on child level writer which
        try (ReleasableLock releasableLock = readLock.acquire()) {
    protected void commitIndexWriter(final DocumentIndexWriter writer, final String translogUUID) throws IOException {
            super(shardId, indexSettings, mergedSegmentTransferTracker);
                    // we need to lock here to access the version map to do this truly in RT
        return status;
        logger.trace("flushAndClose now acquired writeLock");
        }
import java.util.HashMap;
            doc.add(softDeletesField);
         * we can't use it.
        if (versionValue != null) {
    }
    final boolean assertSearcherIsWarmedUp(String source, SearcherScope scope) {
     * @opensearch.internal
                        refreshed = referenceManager.maybeRefresh();
                    protected void doRun() {
            final Scorer scorer = weight.scorer(leaf);
                if (plan.executeOpOnEngine || plan.addStaleOpToEngine) {
     * If we hit any failure while processing an indexing on a replica, we should treat that error as tragic and fail the engine.
    /**
        index.parsedDoc().updateSeqID(index.seqNo(), index.primaryTerm());
            engineConfig.getIndexSettings().getTranslogBatchAppendMaxOperations(),
                            ? new IndexVersionValue.PendingLocation(batch)
        return engineConfig.getIndexSettings().getGcDeletesInMillis();
        return translogManager;
                            && indexResult.getFailure() != null
     * upload path after a successful segments sync, passing the post-refresh local segment file sizes. The uncommitted
        final TranslogDeletionPolicy translogDeletionPolicy = translogManager.getDeletionPolicy();
                            // when the local checkpoint advances (i.e., after a recovery completed).
                    // failure we need to dec the store reference
    private void releaseIndexCommit(IndexCommit snapshot) throws IOException {
            if (versionValue.isDelete() == false || allowDeleted == false) {
        versionMap.pruneTombstones(maxTimestampToPrune, localCheckpointTracker.getProcessedCheckpoint());
        }
    /**
import org.opensearch.common.lease.Releasable;
import java.io.Closeable;
                engineConfig.getShardId(),
            + localCheckpointBeforeRefresh
            }
     */
            updateAutoIdTimestamp(Long.MAX_VALUE, true);
                        );
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        versionMap.enforceSafeAccess();
    /**
        }
                                        new VersionsAndSeqNoResolver.DocIdAndVersion(
        @Override
        final SequenceNumbers.CommitInfo seqNoStats = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
    }
    @Override
                        translogManager.trimUnreferencedReaders();
            });
                    logger.warn("Engine is already closed.", e);
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
                    }
        try {
            assert assertIncomingSequenceNumber(index.origin(), index.seqNo());
                }
            try {
    @Override
    /**
        assert assertNonPrimaryOrigin(index);
    private SoftDeletesPolicy newSoftDeletesPolicy() throws IOException {
                return newReader; // steal the reference
            } catch (Exception inner) {
    }
            final ParseContext.Document doc = tombstone.docs().get(0);
                ExternalReaderManager externalReaderManager = new ExternalReaderManager(internalReaderManager, externalRefreshListener);
                                            0
    }
            } else {
    protected final LiveVersionMap versionMap = new LiveVersionMap();
        assert plan.executeOpOnEngine || plan.addStaleOpToEngine;
    @Override
        return forceMergeUUID;
    // testing
     * since no indexing is happening and refreshes are only happening to the external reader manager, while with
                            location = translogManager.add(new Translog.Index(index, indexResult));
                } finally {
    protected final void refreshIfNeeded(String source, long requestingSeqNo) {
                this::resolveDocVersion,
                    final TranslogBatchScope batch = activeBatch.get();
    @Override
                    try {
                    logger.info("now throttling indexing: numMergesInFlight={}, maxNumMerges={}", numMergesInFlight, maxNumMerges);
                                    );
            }
            }
        if (committedInfos == null) {
    }
                 * Yet, we have to deal with multiple document delivery, for this we use a property of the document that is added
        TranslogEventListener translogEventListener
                            index.parsedDoc(),
                LuceneChangesSnapshot.DEFAULT_BATCH_SIZE,
     *
    }
            logger.trace("flushAndClose now acquire writeLock");
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
                                index.uid().bytes(),
        private final long committedInfosGeneration;
                );
    }
                        }
    public void clearUncommittedSegmentBytes() {
                throw engineException;
        } else {
