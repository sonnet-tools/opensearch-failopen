                 * `indexWriter.getTragicException()` will be null otherwise we have to rethrow and treat it as fatal or rather  
        }
    private void addStaleDocs(final List<ParseContext.Document> docs, final DocumentIndexWriter indexWriter, Term uid) throws IOException {
                    e.addSuppressed(inner);  
    public final void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {
            writer.commit();
            final Engine.Searcher newSearcher = IndexShard.wrapSearcher(  
                historyUUID = loadHistoryUUID(commitData);
            OpenSearchReaderManager internalReaderManager,
            try {
    }  
    @Override
        } else {
        }  
                        // field. 1L is selected to optimize the compression because it might probably be the most common value in
    private void restoreVersionMapAndCheckpointTracker(DirectoryReader directoryReader) throws IOException {
    // testing  
import org.apache.lucene.index.LiveIndexWriterConfig;
                 */  
                            shardId,
        }
            : "DirectoryReader must be an instance of OpenSearchDirectoryReader";  
            assert (isWriteLockHeld()) || failEngineLock.isHeldByCurrentThread()
            internalReaderManager = externalReaderManager.internalReaderManager;
        if (versionValue != null) {
     * Returns the number of times a version was looked up either from the index.
    private boolean incrementVersionLookup() { // only used by asserts
                    }
        }
                                maybeFailEngine("realtime_get", e); // lets check if the translog has failed with a tragic event
        // The write lock only orders this against other engine-level writers; the caller is responsible for  
                     * confidence that the call stack does not contain catch statements that would cause the error that might be thrown  
        if (shouldPeriodicallyFlushAfterBigMerge.get()) {  
                ex.addSuppressed(inner);  
     * after the local checkpoint in the safe commit. This step ensures the live version map and checkpoint tracker
            throw e;  
import org.apache.lucene.search.Weight;  
    private static final class ExternalReaderManager extends ReferenceManager<OpenSearchDirectoryReader> {
        return primaryOperationPolicy.planIndex(indexingStrategyPlanner, index);
                    if (plan.executeOpOnEngine || plan.addStaleOpToEngine) {
                }  
                 *  or calls updateDocument.
    private final AtomicInteger throttleRequestCount = new AtomicInteger();
    protected final void closeNoLock(String reason, CountDownLatch closedLatch) {
    public String getHistoryUUID() {  
                    DirectoryReader.open(documentIndexWriter.getAccumulatingIndexWriter()),
                    deleteResult = new DeleteResult(plan.version, delete.primaryTerm(), delete.seqNo(), plan.currentlyDeleted == false);  
        if (isClosed.get() == false) {
                    }
        // snapshot the volatile once so the null check and the generation comparison observe the same commit point  
        DocumentIndexWriter writer;
            searcher = null;
                                            null,
        } catch (final Exception e) {  
    protected void advanceMaxSeqNoOfUpdatesOrDeletesOnPrimary(long seqNo) {
            close(); // double close is not a problem
            if (isWarmedUp == false || newReader != referenceToRefresh) {
    protected boolean assertNonPrimaryOrigin(final Operation operation) {  
                    @Override
            return true;
        }
            }
                if (e instanceof AlreadyClosedException || translogManager.getTragicExceptionIfClosed() != null) {
    private void flushAndCloseInternal() throws IOException {
                        null  
import org.apache.lucene.search.IndexSearcher;  
                 * we can potentially handle the exception before the engine is failed.
        protected void handleMergeException(final Throwable exc) {
    }  
        long version,  
            ensureOpen();
import java.util.concurrent.atomic.AtomicBoolean;
                                        ),  
                            get.id(),  
    public TranslogManager translogManager() {
                        deferred = true;
                    // When context aware is enabled, we are always doing a blocking refresh.  
                if (engineConfig.getIndexSettings().getIndexMetadata().useIngestionSource() == false) {
        }  
     * This reference manager delegates all it's refresh calls to another (internal) ReaderManager  
                mp.setUpgradeInProgress(true, upgradeOnlyAncientSegments);  
            // it's a save operation since we acquire the reader which incs it's reference but then down the road  
            } else {
                    }
                throw new IllegalStateException("expected a pre-assigned sequence number but got [" + operation.seqNo() + "]");
                    currentCriteria = index.docs().get(0).getGroupingCriteria();
                try {
            + localCheckpointBeforeRefresh
                            index.primaryTerm(),
 * The OpenSearch Contributors require contributions made to  
                    );
    }
        ExternalReaderManager externalReaderManager = null;  
            assert doc.getField(SeqNoFieldMapper.TOMBSTONE_NAME) != null : "Delete tombstone document but _tombstone field is not set ["
        }
        // throw and AssertionError if the tragic event condition is not met.
        return indexingStrategyPlanner.assertPrimaryCanOptimizeAddDocument(index);  
    private void flushActiveTranslogBatches() {  
/*  
    private NoOpResult innerNoOp(final NoOp noOp) throws IOException {
            // we simply run a blocking refresh on the internal reference manager and then steal it's reader
                try {
                    SequenceNumbers.UNASSIGNED_SEQ_NO,  
        return numVersionLookups.count();
import org.opensearch.index.fieldvisitor.IdOnlyFieldVisitor;
    }
                                // if we have document failure, record it as a no-op in the translog and Lucene with the generated seq_no
            // only if a shard starts up again due to relocation or if the index is closed
        } else {
    }
    LocalCheckpointTracker getLocalCheckpointTracker() {
            for (ReferenceManager.RefreshListener listener : engineConfig.getExternalRefreshListener()) {  
                                flushActiveBatchBeforeInlineWrite();
        return new GatedCloseable<>(lastCommit, () -> releaseIndexCommit(lastCommit));
import org.opensearch.common.lucene.index.DerivedSourceDirectoryReader;
            }  
            uncommittedSegmentBytes = null;
import org.apache.lucene.store.AlreadyClosedException;
    }
                    refreshLastCommittedSegmentInfos();  
     */
                try (Searcher searcher = acquireSearcher("restore_version_map_and_checkpoint_tracker", SearcherScope.INTERNAL)) {
        numDocUpdates.inc(docs.size());
            );  
        store.incRef();  
                    }  
        } finally {  
            }
            throw ex;
     * Marks the given seq_no as seen and advances the max_seq_no of this engine to at least that value.
                maxDocs
                        if (versionValue.getLocation() != null) {
        VersionValue versionValue = getVersionFromMap(op.uid().bytes());
            }  
        if (current != null) {  
            store.incRef(); // increment the ref just to ensure nobody closes the store while we optimize
                } else {  
     * will be rollback. Since after rollback we do care about any new writes that came in and in the last commit, we would  
            return OpVsEngineDocStatus.OP_STALE_OR_EQUAL;  
            // checkpoint.
    public boolean refreshNeeded() {
        assert maxUnsafeAutoIdTimestamp.get() <= maxSeenAutoIdTimestamp.get();  
                }
                    );
import org.opensearch.index.shard.IndexShard;
                e.addSuppressed(inner);
             * and expected. We don't hold any locks while we block on forceMerge otherwise it would block
                }
    /**
                        indexResult.setTook(System.nanoTime() - index.startTime());  
        return throttle.getThrottleTimeInMillis();  
            noOpResult.freeze();  
                }
     * is stale (e.g. right after a flush) and is ignored until the next sync republishes.
        int count = throttleRequestCount.decrementAndGet();  
            }  
                }  
                if (waitIfOngoing == false) {  
                } catch (AlreadyClosedException e) {
    public final long getMinRetainedSeqNo() {
    }  
                e.addSuppressed(inner);
            }
                } finally {
    }
            return reference.tryIncRef();  
    }
import java.util.concurrent.ConcurrentHashMap;  
            deleteResult.freeze();
    }
                // This shard's sequence numbers are assigned by an upstream authority, which owns the
                                            reader,
                e.addSuppressed(inner);
    }  
        }
            }
                Releasable ignored = versionMap.acquireLock(index.uid().bytes());
        final IndexCommit safeCommit = combinedDeletionPolicy.acquireIndexCommit(true);  
                refreshed = false;
                                            0
                    }
    /**
        }
        assert newTimestamp >= -1 : "invalid timestamp [" + newTimestamp + "]";
            // IndexWriters with parent writers, version will be either present in version map or in parent IndexWriter. So we do not need  
    }  
     */
        }
            );  
                    logger.warn("failed to read latest segment infos on flush", e);
                    warmer.warm(reader);  
    private final CounterMetric numDocAppends = new CounterMetric();  
            default:
    @Override
            }  
                            versionMap.maybePutIndexUnderLock(  
                    || getProcessedLocalCheckpoint() > Long.parseLong(
                    localCheckpointTracker.markSeqNoAsProcessed(indexResult.getSeqNo());
        try {
            throw e;
                        }
        long seqNo,
            pruneDeletedTombstones();
    }
        // pass the new reader reference to the external reader manager.
            assert false : "wait_if_ongoing must be true for a force flush: force=" + force + " wait_if_ongoing=" + waitIfOngoing;  
    }
            failEngine(
    @Override
        }  
     *  
                }  
        // Operations can be processed on a replica in a different order than on the primary. If the order on the primary is index-1,
        }
    public long getMaxSeqNoOfUpdatesOrDeletes() {
        // always internally consistent. If a flush lands between this snapshot and the publish below, the stamp no
                + primaryOperationPolicy
        // if we are already closed due to some tragic exception  
                     */
                localCheckpointTracker::getProcessedCheckpoint,  
            engineConfig.getGlobalCheckpointSupplier(),
                commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCheckpoint));
     * the commit generation it was computed against: a value whose generation does not match the current last commit
     */
                    }
    public NoOpResult noOp(final NoOp noOp) throws IOException {  
import org.apache.lucene.search.BooleanClause;  
import org.opensearch.common.lucene.search.Queries;  
            }
                    assert index.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + index.origin();
        } else {  
    public MergeStats getMergeStats() {  
                    assert externalReaderManager.isWarmedUp : "searcher was not warmed up yet for source[" + source + "]";
            }  
                 *  if A arrives on the shard first we use addDocument since maxUnsafeAutoIdTimestamp is < 10. A` will then just be skipped
import org.apache.lucene.document.NumericDocValuesField;
        assert count >= 0 : "invalid post-decrement throttleRequestCount=" + count;
            this.logger = logger;
import java.util.Arrays;  
        long toSeqNo,
                boolean deferred = false;
        // (e.g., moves backwards) we will at least still sometimes prune deleted tombstones:
                }
    private boolean shouldFlushOnUncommittedSegmentBytes() {
            return Engine.NO_OP_TRANSLOG_BATCH;  
        return indexingStrategyPlanner.planOperationAsNonPrimary(index);  
        numIndexVersionsLookups.inc();
            throw new EngineException(shardId, e.getMessage(), e);  
    }
    }
                // document does not exists, we can optimize for create, but double check if assertions are running  
    }
        try (ReleasableLock lock = readLock.acquire()) {
            // nothing has changed - both ref managers share the same instance so we can use reference equality
    }
    /**
                } catch (Exception e) {  
        translogDeletionPolicy.setRetentionAgeInMillis(translogRetentionAge.millis());
    @Override
                IOUtils.closeWhileHandlingException(internalReaderManager, documentIndexWriter);  
     * The publisher calls this on every segments sync while the condition is disabled, so the write is guarded: only the
                // TODO we might force a flush in the future since we have the write lock already even though recoveries  
                        } else {
        try {
                 * writing new documents to the index. Since we only know which Lucene documents made it into the final commit after the
                if (lastRefreshedCheckpoint() < requestingSeqNo) {
    protected final LocalCheckpointTracker localCheckpointTracker;
        try {
            final IdOnlyFieldVisitor idFieldVisitor = new IdOnlyFieldVisitor();
        return throttle.throttleLockIsHeldByCurrentThread();
    protected TranslogManager createTranslogManager(
    }  
            && settings.isRemoteStoreEnabled()
    private volatile UncommittedSegmentBytes uncommittedSegmentBytes;
        return numDocAppends.count();
            indexWriter.addDocument(docs.get(0), uid);
            }
        boolean segRepEnabled = engineConfig.getIndexSettings().isSegRepEnabledOrRemoteNode();
                    assert versionValue.seqNo >= 0 : versionValue;  
     * for a failure that is the translog's tragic event (the translog is closed and the engine is failing); any other
                 * that:
import org.opensearch.index.merge.OnGoingMerge;
    @Override
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver;
                }
        } catch (IOException e) {
            localCheckpointBeforeRefresh = localCheckpointTracker.getProcessedCheckpoint();  
                        "failed to restore version map and local checkpoint tracker",  
    @Override
        index.parsedDoc().updateSeqID(index.seqNo(), index.primaryTerm());  
        try (ReleasableLock ignored = readLock.acquire()) {  
                throw new AssertionError("doc [" + index.id() + "] exists in version map (version " + versionValue + ")");  
            this.current = internalReaderManager.acquire(); // steal the reference without warming up  
                }  
            try {
                if (isClosed.get() == false) {  
                });  
            // sequence number should be set when operation origin is not primary
            throw e;  
        final OpVsEngineDocStatus status;
                 * The user data captured above (e.g. local checkpoint) contains data that must be evaluated *before* Lucene flushes  
                            index.startTime(),
                }  
                        localCheckpointTracker.markSeqNoAsPersisted(indexResult.getSeqNo());
            IndexWriterConfig iwc = NativeLuceneIndexWriterFactory.IndexWriterConfigBuilder.builder()
                    advanceMaxSeqNoOfUpdatesOrDeletesOnPrimary(delete.seqNo());
        try (ReleasableLock ignored = writeLock.acquire()) {
        if (count == 0) {
    @Override  
                            advanceMaxSeqNoOfUpdatesOrDeletesOnPrimary(index.seqNo());
        // but we are double-checking it's failed and closed
            final Exception tragicException;  
    private OpVsEngineDocStatus compareOpToLuceneDocBasedOnSeqNo(final Operation op) throws IOException {  
                }
            if (ExceptionsHelper.stackTrace(e).contains("org.apache.lucene.index.IndexWriter.filesExist")) {
        if (batch != null) {
            return OpVsEngineDocStatus.OP_NEWER;
            translogManager::getLastSyncedGlobalCheckpoint,
        if (primaryOperationPolicy.acceptsPreAssignedSeqNos()) {  
    /**  
        return committedInfos != null  
                            generateSeqNoForOperationOnPrimary(index),  
                } finally {
         * trim only deletes whose seqno at most the local checkpoint. This requirement is explained as follows.
            }  
            failOnTragicEvent(ex);
                }
            }  
    private final ReentrantLock optimizeLock = new ReentrantLock();  
        if (docs.size() > 1) {
                "wait_if_ongoing must be true for a force flush: force=" + force + " wait_if_ongoing=" + waitIfOngoing
                final long docsWithId = searcher.count(new TermQuery(index.uid()));
                    translogManager::getLastSyncedGlobalCheckpoint  
        }
        return deleteResult;
                    for (Segment segment : segmentsArr) {
                searcher = acquireSearcher(source, SearcherScope.INTERNAL, this::wrapSearcher);
            } else {  
import org.opensearch.index.mapper.SeqNoFieldMapper;  
    }
                delete.uid(),  
            }  
                versionValue = null;
                logger.trace("rollback indexWriter");  
        final DeleteResult deleteResult;
        }
            throw new EngineException(shardId, "Failed to materialize safe CatalogSnapshot", e);  
    public List<Segment> segments(boolean verbose) {  
        try {
        }  
                    // generate or register sequence number
 */  
         *   *) If o2 is an indexing then its seq# is either in Lucene (if refreshed) or the VersionMap (if not refreshed yet),  
        final IndexCommit lastCommit = combinedDeletionPolicy.acquireIndexCommit(false);  
                + seqNo
import org.apache.lucene.index.IndexCommit;  
        }  
     * However, we prefer to fail a request individually (instead of a shard) if we hit a document failure on the primary.
        return true;
        if (current == null) {  
        try {
                    preFlightError.get()
                    public void onAfterTranslogRecovery() {
    public int getActiveMergeCount() {
                        // a temporary debugging to investigate test failure - issue#32827. Remove when the issue is resolved  
                        delete.origin(),
                    config().getDocumentMapperForTypeSupplier().get().getDocumentMapper().root()::deriveSource
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
import org.apache.lucene.search.ReferenceManager;
                    );  
    protected static Map<String, String> commitDataAsMap(final DocumentIndexWriter indexWriter) {
                                );  
    }
                        && !(indexResult.getFailure() != null  
import java.util.Optional;
    protected boolean isTranslogBatchingEligible() {
    }  
        // we need to fail the engine. it might have already been failed before
                } else {  
     * If we hit any failure while processing an indexing on a replica, we should treat that error as tragic and fail the engine.  
import org.apache.lucene.search.DocIdSetIterator;
    private final CounterMetric numIndexVersionsLookups = new CounterMetric();  
                documentIndexWriter.deleteUnusedFiles();
                // A pull-based index has no translog (NoOpTranslogManager), so this can only fail: there is no
                            location = translogManager.add(new Translog.Index(index, indexResult));  
                        // the op is coming from the translog (and is hence persisted already) or it does not have a sequence number
                    public void onAfterTranslogSync() {  
            throw e;
            tombstone.version().setLongValue(plan.version);
            }
    /** resolves the current version of the document, returning null if not found */
                versionMap.enforceSafeAccess();
                }
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
        return nativeIndexWriterFactory.createWriter(directory, iwc);  
                    }
    public String getForceMergeUUID() {  
                                    return new GetResult(
        return documentIndexWriter.hasPendingMerges();  
                documentIndexWriter::getPendingNumDocs,  
                        delete.getIfSeqNo(),  
        mergeScheduler.refreshConfig();  
                        } else {
    long getInFlightDocCount() {
        awaitPendingClose();
        return historyUUID;
                this::compareOpToLuceneDocBasedOnSeqNo,
            final DocIdSetIterator iterator = scorer.iterator();
        searcher.setQueryCache(null);
        // remove live entries in the version map  
        }  
        }
                 * only one wins. Yet, only the one that wins will also close the IW and in turn fail the engine such that  
    }  
            failEngine(source, e);
                    failOnTragicEvent(ex);
        private final AtomicBoolean isThrottling = new AtomicBoolean();
            }  
                        }  
        }
        final String forceMergeUUID  
            this.lastRefreshedCheckpointListener = new LastRefreshedCheckpointListener(localCheckpointTracker);  
                scope = SearcherScope.INTERNAL;  
                boolean success = false;
        if (origin == Operation.Origin.PRIMARY) {
     * Returns the number of documents have been updated since this engine was opened.  
        store.incRef();
        long bytes = 0;  
            return false;
                mp.setUpgradeInProgress(false, false);
        if (lastRefreshedCheckpoint() < requestingSeqNo) {
        activeBatch.set(batch);
    private final IndexingStrategyPlanner indexingStrategyPlanner;  
            // reread the last committed segment infos
    }
        }
            internalReaderManager.addListener(versionMap);
    private final OpenSearchConcurrentMergeScheduler mergeScheduler;
            assert seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO : "primary operations must have a pre-assigned sequence number under policy ["
                 *
        try {
        protected void decRef(OpenSearchDirectoryReader reference) throws IOException {  
                // we expose what has been externally expose in a point in time snapshot via an explicit refresh
        return lastCommittedSegmentInfos;
            assert assertPrimaryIncomingSequenceNumber(origin, seqNo);
            int maxNumMerges = mergeScheduler.getMaxMergeCount();  
        @Override
                return externalReaderManager;
        maxSeqNo = seqNoStats.maxSeqNo;
        } else {
                // the op is coming from the translog (and is hence persisted already) or it does not have a sequence number
    }
                this::hasBeenProcessedBefore,
    private void refreshLastCommittedSegmentInfos() {
                + doc
        /*
    }
        refresh("restore_version_map_and_checkpoint_tracker", SearcherScope.INTERNAL, true);
                return newReader; // steal the reference  
            lastMinRetainedSeqNo = Long.parseLong(commitUserData.get(SequenceNumbers.MAX_SEQ_NO)) + 1;
        return primaryOperationPolicy;
                .logger(logger)  
        }  
                throw new IllegalStateException("unknown scope: " + scope);  
    private DeletionStrategy planDeletionAsPrimary(Delete delete) throws IOException {
                        refreshed = referenceManager.maybeRefresh();
        return noOpResult;
    }  
        protected int getRefCount(OpenSearchDirectoryReader reference) {
    private final CounterMetric numVersionLookups = new CounterMetric();
            }
    public void flush(boolean force, boolean waitIfOngoing) throws EngineException {  
                 *
                    // it is intentional that we never refresh both internal / external together
import org.apache.lucene.store.LockObtainFailedException;  
    @Override
                        revisitIndexDeletionPolicyOnTranslogSynced();
                final long primaryTerm = dv.docPrimaryTerm(docId);  
         * This is ok because (1) this is the only place we call forceMerge, (2) we have a single  
        }
    /**  
     * is failed.
     * document in between its Lucene add and its translog add.
    public long getWritingBytes() {  
        return completionStatsCache.get(fieldNamePatterns);
    }  
                        final ParsedDocument tombstone = engineConfig.getTombstoneDocSupplier().newNoopTombstoneDoc(noOp.reason());
     * Executes a pre-flight check for a given NoOp.  
    /**
                }
import org.opensearch.index.IndexSettings;
                            latestCommit.close();
                final EngineException closeFailure = new EngineException(shardId, "engine closed with pending translog batches: " + reason);
    private final IndexingThrottler throttle;
    ) throws IOException {
        assert operation.seqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO : "ops should not have an assigned seq no. but was: "  
                assert delete.origin() == Operation.Origin.PRIMARY : delete.origin();
    /**
    public IndexResult index(Index index) throws IOException {
            assert op.seqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO : "operation is not assigned seq_no";
        final long maxTimestampToPrune = timeMSec - engineConfig.getIndexSettings().getGcDeletesInMillis();
                flushLock.unlock();
            updateAutoIdTimestamp(Long.MAX_VALUE, true);
     * Commits the specified index writer.
    ) throws EngineException, IOException {
        return engineConfig.getIndexSettings().getGcDeletesInMillis();
    }  
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndSeqNo;  
                if (delete.origin() == Operation.Origin.PRIMARY) {
                        translogManager.rollTranslogGeneration();  
    }
            if (referenceToRefresh == newReader) {
                }
                e.addSuppressed(closeEx);
                    IOUtils.close(externalReaderManager, internalReaderManager);
            shardId,
    }
    @Override  
import org.apache.lucene.store.Directory;
            indexWriter.softUpdateDocuments(uid, docs, version, seqNo, primaryTerm, softDeletesField);  
        return numDocDeletes.count();  
                    throw e;
        try (Searcher s = acquireSearcher(source, SearcherScope.INTERNAL)) {  
        for (Map.Entry<String, String> entry : indexWriter.getLiveCommitData()) {  
                    @Override
        assert index.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + index.origin();
import org.apache.lucene.index.StoredFields;
    private VersionValue getVersionFromMap(BytesRef id) {
                } catch (IOException inner) { // iw is closed below
                            );  
            return;
        @Override  
        }
                maybeFailEngine("flush", ex);
                        assert index.origin().isFromTranslog() || indexResult.getSeqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO;  
     * since no indexing is happening and refreshes are only happening to the external reader manager, while with  
    }
                this::updateAutoIdTimestamp,
                        // if we have no pending merges and we are supposed to flush once merges have finished to
                    documentIndexWriter.maybeMerge();  
            + " refresh_checkpoint="  
                            && (indexResult.getFailure() instanceof AppendOnlyIndexOperationRetryException))) {
                @Override  
                        logger.trace("starting commit for flush; commitTranslog=true");
        return translogManager;
                .softDeletesPolicy(softDeletesPolicy)
        } catch (RuntimeException | IOException e) {  
     */
    }
        /* Update the document's sequence number and primary term; the sequence number here is derived here from either the sequence
        }  
                }
                if (docAndSeqNo == null) {
            Set<OnGoingMerge> onGoingMerges = mergeScheduler.onGoingMerges();
            if (operation.seqNo() < 0) {
    boolean throttleLockIsHeldByCurrentThread() {  // to be used in assertions and tests only  
            final OpenSearchDirectoryReader newReader = internalReaderManager.acquire();  
            engineConfig.getStartedPrimarySupplier(),
            batch.flush();  
            try {
    @Override
            translogManager.trimUnreferencedReaders();
                    Index index = (Index) op;
                assert noOp.origin().isFromTranslog() || noOpResult.getSeqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO;
    @Override
                         */
        return combinedDeletionPolicy.getSafeCommitInfo();
 * ownership. Elasticsearch licenses this file to you under  
                final OpenSearchDirectoryReader directoryReader = OpenSearchDirectoryReader.wrap(
    private final ThreadLocal<TranslogBatchScope> activeBatch = new ThreadLocal<>();  
        if (activeBatch.get() != null) {
import org.opensearch.common.util.concurrent.AbstractRunnable;  
     * write post last commit.
                    if (plan.executeOpOnEngine) {
    }  
            externalReaderManager = createReaderManager(new RefreshWarmerListener(logger, isClosed, engineConfig));
    @Override  
    /**  
            try {  
        }  
         */
                    IOUtils.close(translogManager);
/**  
    /**
    }
        return refresh(source, SearcherScope.EXTERNAL, false);
        // The logic for closing writer is same as Engine except we are taking additional locks on child level writers.
        final boolean doThrottle = index.origin().isRecovery() == false;
            // them inside the try so a drain failure keeps refresh's EngineException contract and tragic-event handling,  
                flush();
                return externalReaderManager;  
    protected final void markSeqNoAsSeen(long seqNo) {  
                }
        return lastRefreshedCheckpointListener.lastRefreshedCheckpoint();
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
     * UUID value that is updated every time the engine is force merged.
             * throw FileNotFoundException or NoSuchFileException can also hit this.  
        } else if (e != null && ((documentIndexWriter.getTragicException() == e) || (translogManager.getTragicExceptionIfClosed() == e))) {
    private final CounterMetric numDocUpdates = new CounterMetric();
            return new DeleteResult(plan.version, delete.primaryTerm(), delete.seqNo(), plan.currentlyDeleted == false);
        }  
    long doGenerateSeqNoForOperation(final Operation operation) {  
        boolean success = false;
         * We need to deploy two different trimming strategies for GC deletes on primary and replicas. Delete operations on primary
            this::getLocalCheckpointTracker,
                                        new VersionsAndSeqNoResolver.DocIdAndVersion(
        flushActiveBatchBeforeInlineWrite();
                doc,
        try {
                    this.forceMergeUUID = forceMergeUUID;  
    }
    }
         * that's fine since the IW.rollback should stop all the threads and trigger an IOException
        } finally {
        final IndexSettings settings = engineConfig.getIndexSettings();
                    }  
        refresh(source, SearcherScope.EXTERNAL, true);  
                        generateSeqNoForOperationOnPrimary(delete),  
    }
        );
        // longer matches the new last commit and shouldFlushOnUncommittedSegmentBytes() rejects the value -- the  
    protected volatile String forceMergeUUID;
    }
                // we could fork a thread and do it right away but we try to minimize forking and piggyback on outside events.
    boolean hasSnapshottedCommits() {
                requiredFullRange,
            if (ex instanceof AlreadyClosedException == false
                return commitData.entrySet().iterator();
        }
                // TODO: Check if isClose check in getTragicException will cause any issue here
            }
                        if (pending != null) {
    @Override
        }
            + documentIndexWriter.getConfig().getMergePolicy().getClass().getName();
            }
                    } else {  
                    assert index.docs() != null && index.docs().isEmpty() == false;  
        return Stream.concat(versionMap.getAllCurrent().entrySet().stream(), versionMap.getAllTombstones().entrySet().stream())
                final IndexingStrategy plan = indexingStrategyForOperation(index);
    /**  
                }  
            translogUUID,  
                                        ),
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {  
                this.localCheckpointTracker = createLocalCheckpointTracker(localCheckpointTrackerSupplier);
         * variable and that this setting will thus apply to the next forced merge that will be run.
    public void activateThrottling() {
     * This method will hold the reader reference until the returned {@link GatedCloseable} is closed.  
    @Override  
        final Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);  
            try {
    }
                            get.getIfSeqNo(),  
         * - If seq#(o1) <= LCP, then it will be not be added to Lucene, as it was already previously added.
    @Override  
        // AlreadyClosedException; refuse it up front so the bulk is retried on the new primary without doing any work.  
                engineConfig.getShardId(),  
        if (versionValue != null) {  
    protected SegmentInfos getLatestSegmentInfos() {
    public void clearUncommittedSegmentBytes() {  
 *  
                        // we need to refresh in order to clear older version values
        // we have to flush outside of the readlock otherwise we might have a problem upgrading
        // Parallel to acquireSafeIndexCommit: pin a safe Lucene commit, wrap its SegmentInfos.  
        switch (scope) {  
            );  
                documentIndexWriter.deleteUnusedFiles();  
    /**
     * publication. {@link #shouldFlushOnUncommittedSegmentBytes()} already treats an absent value as "do not flush", so
        return versionValue;
        );  
     * upload path after a successful segments sync, passing the post-refresh local segment file sizes. The uncommitted
     * computed against, so a commit implicitly invalidates it.  
                    versionMap.maybePutIndexUnderLock(
                     * here from being caught and never reaching the uncaught exception handler.
                        lastCommittedSegmentInfos.userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)
            flush(false, true);  
                        if (segment.getName().equals(segmentInfoPerCommit.info.name)) {  
            ensureOpen();  
                new EngineException(shardId, "Unable to update document as it is an append only index")
        } else {
            }
            } finally {  
            if (isContextAwareEnabled) {
    public CompletionStats completionStats(String... fieldNamePatterns) {
            reader = internalReaderManager.acquire();  
            engineFailed = true;
                reader -> DerivedSourceDirectoryReader.wrap(
                        throw e;
                        commitIndexWriter(documentIndexWriter, translogManager.getTranslogUUID());  
             * or the Lucene document limit. We have already issued a sequence number here so this is fatal, fail the engine.  
            } catch (AlreadyClosedException ignored) {
            return newSearcher;
                assert delete.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + delete.origin();
        @Override  
    IndexWriter createWriter(Directory directory, IndexWriterConfig iwc) throws IOException {
        }
                if (hasUncommittedChanges
     * this specialized implementation an external refresh will immediately be reflected on the internal reader
            // Doc version will be maintained in version map till afterRefresh of parent ReaderManager. Since before refresh we sync the
    }
         */
            if (writerTragicException instanceof Exception) {
                engineConfig.getIndexSettings(),
            return;
        if (committedInfos == null) {
     * refresh; turning the condition off instead discards the accounting on that sync, see
            } catch (AlreadyClosedException ex) {  
                        final Translog.Location location;
        EngineMergeScheduler(ShardId shardId, IndexSettings indexSettings, MergedSegmentTransferTracker mergedSegmentTransferTracker) {  
        // for a long time:
    // An index request is considered as an update if it overwrites existing documents with the same docId in the Lucene index.
    // A uid (in the form of BytesRef) to the version map  
            try {
            tombstone.updateSeqID(delete.seqNo(), delete.primaryTerm());
    private final Object refreshIfNeededMutex = new Object();
        if (maxSeqNoOfUpdatesOnPrimary == SequenceNumbers.UNASSIGNED_SEQ_NO) {
import java.util.Set;
     * refreshes to clear version map memory etc. this can cause excessive segment creation if heavy indexing
    private final LastRefreshedCheckpointListener lastRefreshedCheckpointListener;
    private final KeyedLock<Long> noOpKeyedLock = new KeyedLock<>();
        versionMap.pruneTombstones(maxTimestampToPrune, localCheckpointTracker.getProcessedCheckpoint());
import org.apache.logging.log4j.message.ParameterizedMessage;
                }
            }
            if (numMergesInFlight.incrementAndGet() > maxNumMerges) {
            }  
 */
                        throw new FlushFailedEngineException(shardId, e);
    }
                // map so once we pass this point we can safely lookup from the version map.  
                            : null;
                );  
    }
import org.opensearch.common.concurrent.GatedCloseable;  
    }
    }
                            force,
        } finally {
                        && (get.getIfSeqNo() != versionValue.seqNo || get.getIfPrimaryTerm() != versionValue.term)) {
        versionMap.pruneTombstones(Long.MAX_VALUE, localCheckpointTracker.getMaxSeqNo());
        }  
                // we can access segment_stats while a shard is still in the recovering state.  
                    noOpResult.setTranslogLocation(location);
                                if (operation != null) {
            || index.origin() == Operation.Origin.LOCAL_RESET;
    @Override
        logger.trace("flushAndClose now acquired writeLock");
        try {
        } else if (seqNo == versionValue.seqNo) {  
                lastWriteNanos = index.startTime();
            } else {
                    activateThrottling();
    @Override
        versionMap.enforceSafeAccess();  
            failEngine("already closed by tragic event on the index writer", tragicException);  
                if (currentForceMergeUUID != null) {
    }
    /**
                        }  
                refresh("commit", SearcherScope.INTERNAL, true);
                    }
                    }
    @Override
                    logger.info("finished segment upgrade");  
    public final long lastRefreshedCheckpoint() {  
            // steal it by calling incRef on the "stolen" reader
                // We always open reader on parent IndexWriter.  
                 *  - and is assigned before we start to index / replicate
                        // We add Stale entry only on parent IndexWriter.  
                }
     * Generate the sequence number for the specified operation.
import org.apache.lucene.util.BytesRef;
                case "segments_stats":
    }
                            failOnTragicEvent((AlreadyClosedException) ex);
        final long localCheckpointOfLastCommit = Long.parseLong(  
        );  
        if (docs.size() > 1) {
            this.internalReaderManager = internalReaderManager;
                maxUnsafeAutoIdTimestamp::get,
    public GatedCloseable<SegmentInfos> getSegmentInfosSnapshot() {  
                if (isThrottling.getAndSet(true) == false) {
        ) throws IOException {  
        final OpenSearchDirectoryReader reader;
    @Override  
        return combinedDeletionPolicy.hasSnapshottedCommits();  
            BooleanClause.Occur.MUST
     * Closes the engine without acquiring the write lock. This should only be
                            index.getAutoGeneratedIdTimestamp(),  
    private final DocumentCountTracker documentCountTracker;
                batch.flush();  
        if (isClosed.get() == false) {
                 *  - is preserved in the transaction log  
 * compatible open source license.
        /*  
                    final VersionValue curr = versionMap.getUnderLock(uid);  
 *
                }
                } else if (maxNumSegments <= 0) {
                if (deferred == false && plan.executeOpOnEngine && indexResult.getResultType() == Result.Type.SUCCESS) {
                success = true;
                    status = OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
        // TODO: can we enable this check for all origins except primary on the leader?
        }  
        }
    private DeleteResult deleteInLucene(Delete delete, DeletionStrategy plan) throws IOException {
                commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);  
            }  
                if (Lucene.isCorruptionException(e)) {
        localCheckpoint = seqNoStats.localCheckpoint;  
            assert seqNo >= 0 : "recovery or replica ops should have an assigned seq no.; origin: " + origin;
            if (MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID.equals(entry.getKey())) {
                 *  
                flushLock.lock();
        try {
                }
            }
        }
    }  
        try {  
    }
    private LocalCheckpointTracker createLocalCheckpointTracker(  
                 * risk of re-using a sequence number for two different documents when restoring from this commit point and subsequently  
    public final long currentOngoingRefreshCheckpoint() {
        final Set<String> committedFiles;
        if (e instanceof AlreadyClosedException) {  
     */
            }
        } catch (LockObtainFailedException ex) {
                    public void onFailure(Exception e) {  
                            && indexResult.getFailure() != null
        final NoOpResult noOpResult;
        try {
                            : null;
                    logger.debug("merge failure action rejected", e);
                            versionValue.term  
    }  
        if (count == 1) {
                                IndexVersionValue.withPendingLocation(pending, plan.version, index.seqNo(), index.primaryTerm())
            if (success == false) {  
        }  
    @Override
        closeNoLock("api", closedLatch);
        this.maxSeqNoOfUpdatesOrDeletes.updateAndGet(curr -> Math.max(curr, maxSeqNoOfUpdatesOnPrimary));
        if (seqNo > versionValue.seqNo) {
        if (isClosed.compareAndSet(false, true)) {
                assert noOpKeyedLock.isHeldByCurrentThread(op.seqNo());  
            return planIndexingAsPrimary(index);  
            store.decRef();
        } else if (translogManager.getTragicExceptionIfClosed() != null) {
        } catch (AlreadyClosedException ex) {
                if (index.origin().isFromTranslog() == false) {  
         * - If seq#(o1)  > LCP, then it depends on the nature of o2:  
                            versionMap.putDeleteUnderLock(uid, new DeleteVersionValue(dv.docVersion(docId), seqNo, primaryTerm, startTime));
import org.opensearch.index.mapper.Uid;
    protected long generateSeqNoForOperationOnPrimary(final Operation operation) {
    /**
                        );  
        refreshIfNeeded(source, toSeqNo);  
    @Override
                // Here we don't have to trim translog because snapshotting an index commit
    }  
        Searcher searcher = null;
        // every 1/4 of gcDeletesInMillis:
    private void bootstrapAppendOnlyInfoFromWriter(DocumentIndexWriter writer) {
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        assert noOp.seqNo() > SequenceNumbers.NO_OPS_PERFORMED;
            }  
    public InternalEngine(EngineConfig engineConfig) {
                    // even though we maintain 2 managers we really do the heavy-lifting only once.
        // map in the version map such that we don't need to refresh if we are unsafe;
        }
            // this spot on - we are handling the tragic event exception here so we have to fail the engine  
                        // version field.
            return true;
    /**
     * @param localSegmentsSizeMap post-refresh local segment file names mapped to their sizes in bytes
            return planDeletionAsPrimary(delete);
            + lastRefreshedCheckpoint();
            synchronized (refreshIfNeededMutex) {  
    public void flushAndClose() throws IOException {  
        refresh("write indexing buffer", SearcherScope.INTERNAL, false);  
        maybePruneDeletes();
    }
                        if (latestCommit != null) {
     * failure is the owning request's to report, and the drainer carries on with the remaining scopes. The documents of
    public SafeCommitInfo getSafeCommitInfo() {  
     * flush trigger until the next sync, never cause a spurious flush.  
                                            "realtime_get",
    }
                                    final Translog.Index index = (Translog.Index) operation;  
            maxSeqNoOfUpdatesOrDeletes = new AtomicLong(  
    public final long getMaxSeenAutoIdTimestamp() {  
                // if we can't get the lock right away we block if needed otherwise barf
            final VersionsAndSeqNoResolver.DocIdAndVersion docIdAndVersion;
    protected final AtomicLong maxUnsafeAutoIdTimestamp = new AtomicLong(-1);
                                final NoOp noOp = new NoOp(  
                addStaleDocs(index.docs(), documentIndexWriter, index.uid());
    ) throws IOException {  
     * Appends every live bulk scope's pending chunk so that a refresh or flush publishes no document whose translog
    private static OpVsEngineDocStatus compareOpToVersionMapOnSeqNo(String id, long seqNo, long primaryTerm, VersionValue versionValue) {
    // The value of this marker never goes backwards, and is tracked/updated differently on primary and replica.  
                }
                noOpResult = new NoOpResult(noOp.primaryTerm(), noOp.seqNo());  
    private boolean assertIncomingSequenceNumber(final Engine.Operation.Origin origin, final long seqNo) {  
                + " seq_no="  
                final DocIdAndSeqNo docAndSeqNo = VersionsAndSeqNoResolver.loadDocIdAndSeqNo(searcher.getIndexReader(), op.uid());  
        }
                        versionMap.putDeleteUnderLock(
                this::compareOpToLuceneDocBasedOnSeqNo,
                logger.trace("committing writer with commit data [{}]", commitData);
            } else {
                throw new EngineCreationFailureException(shardId, "failed to create engine", e);  
                failEngine("lucene commit failed", ex);
import java.util.concurrent.atomic.AtomicLong;
import org.opensearch.index.translog.TranslogManager;  
    public GetResult get(Get get, BiFunction<String, SearcherScope, Engine.Searcher> searcherFactory) throws EngineException {  
                        indexResult.setTranslogLocation(location);
                protected void doRun() throws Exception {  
        }
                deleteResult.setTranslogLocation(location);
                // newly created commit points to a different translog generation (can free translog),  
            try {
        final long maxSeqNo;  
         * thread for optimize, and the 'optimizeLock' guarding this code, and (3) ConcurrentMergeScheduler
    }  
            if (primaryOperationPolicy.acceptsPreAssignedSeqNos()) {  
                engineConfig.getShardId(),
    }  
            IOUtils.close(searcher);
        translogManager.ensureCanFlush();
                } catch (Exception inner) {
                Releasables.close(success, searcher);
                } else {  
    public long getIndexThrottleTimeInMillis() {
        return new InternalTranslogManager(
            try {
        }
                    }
                // randomly throw FNFE/NSFE can also hit this:  
        // snapshot the volatile once, as shouldFlushOnUncommittedSegmentBytes() does
     * bytes are computed as the total size of local segment files that are not referenced by the last commit point,  
    // max_seq_no_of_updates_or_deletes tracks the max seq_no of update or delete operations that have been processed in this engine.
        return localCheckpointTracker;  
                return null;
                // generate or register sequence number
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
         *      so a real-time lookup can find it and determine that o1 is stale.
            }  
     * Refresh this engine **internally** iff the requesting seq_no is greater than the last refreshed checkpoint.
    }
        if (engineConfig.isAutoGeneratedIDsOptimizationEnabled() == false) {  
            } else if (op instanceof Index && versionValue.version > 0) {  
        if (delete.origin() == Operation.Origin.PRIMARY) {
     */
         * Suppose o1 and o2 are two operations on the same document with seq#(o1) < seq#(o2), and o2 arrives before o1 on the replica.  
                reservedDocs = plan.reservedDocs;
 * not use this file except in compliance with the License.
                    continue;
            logger.trace("flushAndClose now acquire writeLock");
     * <p>A scope's append failure belongs to the bulk that owns the scope: the scope has recorded it, completed its
                }
        } catch (Exception e) {
                translogManagerRef = createTranslogManager(translogUUID, translogDeletionPolicy, compositeTranslogEventListener);
                // we deadlock on engine#close for instance.  
                searcher,  
    }
            if (plan.earlyResultOnPreFlightError.isPresent()) {  
                    assert upgrade == false;
            }
    }  
        return forceMergeUUID;
                boolean hasUncommittedChanges = documentIndexWriter.hasUncommittedChanges();
    public void maybePruneDeletes() {
         *
            this::onTranslogBatchFinished,  
                            index.version(),
                    logger,  
                    failEngine("lucene commit failed", engineException);
            // data of child level
                logger.trace("rollback indexWriter done");
                public void onFailure(Exception e) {
            this.deletionStrategyPlanner = new DeletionStrategyPlanner(
            throw e;  
            } catch (Exception e) {
    private void onTranslogBatchFinished(TranslogBatchScope batch) {  
                } else {
    protected final DeletionStrategy planDeletionAsNonPrimary(Delete delete) throws IOException {  
                         * index being corrupt, or the Lucene document limit. We have already issued a sequence number here so this is
import org.apache.lucene.index.Term;
                    status = OpVsEngineDocStatus.OP_NEWER;
            // this smells like a bug - we only expect ACE if we are in a fatal case ie. either translog or IW is closed by  
     * @param operation the operation  
        @Override
        }
                    internalReaderManager.removeListener(versionMap);
                            } else {
import org.opensearch.index.translog.TranslogException;
                // no need to commit in this case!, we snapshot before we close the shard, so translog and all sync'ed
            } else {  
            updateAutoIdTimestamp(Long.MAX_VALUE, true);
                    engineException.addSuppressed(inner);
        }
                        if (ex instanceof AlreadyClosedException == false && documentIndexWriter.getTragicException() == null) {
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
            } catch (Exception inner) {  
            completionStatsCache = new CompletionStatsCache(() -> acquireSearcher("completion_stats"));
        }  
                }  
                // Only flush if (1) Lucene has uncommitted docs, or (2) forced by caller, or (3) the
                documentCountTracker.releaseInFlightDocs(reservedDocs);
                    if (isEngineClosed.get() == false) {
                        // only after the active reader is updated. This ensures that a flush does not wipe out a required commit point file  
         * we have to inc-ref the store here since if the engine is closed by a tragic event
        }
            return OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
            }
                    delete.seqNo()
                        );
            this.internalReaderManager = internalReaderManager;  
        } else {
                + primaryTerm  
                    indexResult.setTook(System.nanoTime() - index.startTime());  
                logger.debug("engine already closed - skipping flushAndClose");
        );
        final long timeMSec = engineConfig.getThreadPool().relativeTimeInMillis();  
                // To sync document during commit. This keeps documents during commit always ahead of checkpoint.  
import org.apache.lucene.index.MergePolicy;  
                + seqNo
            /*
        if (unsafe) {  
                    if (get.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
                         * fatal, fail the engine.  
    }
            .build();
        }
            && settings.isRemoteTranslogStoreEnabled()
            // Set the Refresh checkpoint first and then sync child with parent to ensure parent Checkpoint is grater than Refresh
        } catch (IOException e) {
     */  
            if (combinedDeletionPolicy.hasUnreferencedCommits()) {
import org.opensearch.core.index.AppendOnlyIndexOperationRetryException;  
         * - If a replica subsequently is promoted, user experience is maintained as that replica remembers deletes for the last GC cycle.
        }
            localCheckpointTracker,
        // Revisit the deletion policy if we can clean up the snapshotting commit.
        private final AtomicBoolean isEngineClosed;  
         * - It's simpler - no need to distinguish if an engine is running at primary mode or replica mode or being promoted.
        // A scope opened against a closed engine would only fail at its first append with the same
 */
                try {  
                engineConfig.getThreadPool().executor(ThreadPool.Names.FLUSH).execute(new AbstractRunnable() {
         */  
                    try {
        // NOTE this uses direct access to the version map since we are in the assertion code where we maintain a secondary
    ) throws IOException {  
                for (TranslogBatchScope batch : activeBatches) {
/*  
            reference.decRef();
    }  
        stats.addVersionMapMemoryInBytes(versionMap.ramBytesUsed());  
                        throw ex;
        String source,
            logger.debug("close now acquiring writeLock");  
    private SoftDeletesPolicy newSoftDeletesPolicy() throws IOException {
                internalReaderManager = new OpenSearchReaderManager(directoryReader);
import java.util.Objects;  
             */
            pruneDeletedTombstones();
                }
     */
     */  
                boolean shouldPeriodicallyFlush = shouldPeriodicallyFlush();  
    }  
         * dec the store reference which can essentially close the store and unless we can inc the reference  
        final Term uid,  
    long getNumDocDeletes() {
 * this file be licensed under the Apache-2.0 license or a
            engineConfig.retentionLeasesSupplier()
    @Override  
                    } catch (Exception e) {  
        )
        boolean requiredFullRange,
        }
                        refresh("version_table_flush", SearcherScope.INTERNAL, true);  
                    logger.info("now throttling indexing: numMergesInFlight={}, maxNumMerges={}", numMergesInFlight, maxNumMerges);  
        }
    @Override
            // exclude non-root nested documents  
                .openMode(IndexWriterConfig.OpenMode.APPEND)
            doc.add(softDeletesField);
 *
                            index.getIfPrimaryTerm()  
                            index.versionType(),  
            throw ex;  
        }
        public synchronized void beforeMerge(OnGoingMerge merge) {
            switch (source) {
                            // when the local checkpoint advances (i.e., after a recovery completed).
import org.apache.lucene.search.ScoreMode;  
            engineConfig.getIndexSettings().getTranslogBatchAppendMaxOperations(),
            );  
            } finally {
            }
            this.committedInfosGeneration = committedInfosGeneration;
                        delete.primaryTerm(),
                        numDocDeletes.inc();  
        final TranslogBatchScope batch = activeBatch.get();
        logger.trace("recovered maximum sequence number [{}] and local checkpoint [{}]", maxSeqNo, localCheckpoint);
            final ParsedDocument tombstone = engineConfig.getTombstoneDocSupplier().newDeleteTombstoneDoc(delete.id(), delete.routing());
     * When we last pruned expired tombstones from versionMap.deletes:
        final UncommittedSegmentBytes current = this.uncommittedSegmentBytes;
                            index.isRetry(),
                }  
                    translogDeletionPolicy,
        boolean refreshed;  
                    shardId  
                final Map<String, String> userData = store.readLastCommittedSegmentsInfo().getUserData();
                if (isContextAwareEnabled) {
    /**
    protected volatile long lastDeleteVersionPruneTimeMSec;
                    softDeletesPolicy,
                 */
                } catch (Exception e) {
 * under the License.  
        VersionValue versionValue = getVersionFromMap(op.uid().bytes());  
    }
                VersionValue versionValue = null;  
                }
            try {
                final long seqNo = dv.docSeqNo(docId);
            }  
 * KIND, either express or implied.  See the License for the
        logger.trace("created new InternalEngine");  
                this.nativeIndexWriterFactory = new NativeLuceneIndexWriterFactory();
    private final DeletionStrategyPlanner deletionStrategyPlanner;
        }
         * o2 is processed normally since it arrives first; when o1 arrives it should be discarded:
                 *  documents that arrive (A and B) will also use updateDocument since their timestamps are less than  
        OpenSearchReaderManager internalReaderManager = null;  
            writer = new LuceneIndexWriter(createWriter());
     * Gets the commit data from {@link IndexWriter} as a map.
import org.opensearch.index.translog.listener.TranslogEventListener;  
    }
            assert seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO : "primary operations must never have an assigned sequence number but was ["  
                    + "]";
     * Note this is only available if assertions are enabled  
    }
            && engineConfig.getThreadPool().relativeTimeInMillis() - lastDeleteVersionPruneTimeMSec > getGcDeletesInMillis() * 0.25) {  
        } catch (IOException ex) {  
        assert OpenSearchDirectoryReader.unwrap(searcher.getDirectoryReader()) != null
            documentIndexWriter.deleteDocument(
        advanceMaxSeqNoOfUpdatesOrDeletes(seqNo);  
                final Translog.Location location = translogManager.add(new Translog.Delete(delete, deleteResult));
    }
        try (Releasable ignored = noOpKeyedLock.acquire(seqNo)) {  
                    } else {
        try (ReleasableLock ignored = writeLock.acquire()) {
                if (internalReaderManager != null) {
        EngineMergeScheduler scheduler = null;
            engineConfig.getIndexSettings().getSoftDeleteRetentionOperations(),
            if (delete.origin().isFromTranslog() == false && deleteResult.getResultType() == Result.Type.SUCCESS) {  
                maybeFailEngine(source, e);
                if (versionValue != null) {
        final TranslogDeletionPolicy translogDeletionPolicy = translogManager.getDeletionPolicy();  
    }
import org.opensearch.index.translog.TranslogCorruptedException;  
    protected VersionValue resolveDocVersion(final Operation op, boolean loadSeqNo) throws IOException {  
        assert operation.origin() != Operation.Origin.PRIMARY : "planing as primary but got " + operation.origin();
        this(engineConfig, IndexWriter.MAX_DOCS, LocalCheckpointTracker::new, TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER);
        return localCheckpointTracker.getPersistedCheckpoint();  
        translogDeletionPolicy.setRetentionSizeInBytes(translogRetentionSize.getBytes());
        @Override  
        // the threshold setting has a hard 1-byte minimum, so current.bytes >= threshold already implies bytes > 0
     * have synced files as well, we should not care about child level writer or updates map as they will belong to new
            }
            && settings.isSegRepEnabledOrRemoteNode();  
            try {  
            );
    protected final NumericDocValuesField softDeletesField = Lucene.newSoftDeletesField();
        }
                docIdAndVersion = VersionsAndSeqNoResolver.loadDocIdAndVersion(
            || super.refreshNeeded();
import org.apache.lucene.document.LongPoint;  
                    throw new FlushFailedEngineException(shardId, e);  
        public synchronized void afterMerge(OnGoingMerge merge) {
                );
                            shardId,
        }
        refreshIfNeeded(source, toSeqNo);
import org.opensearch.index.translog.listener.CompositeTranslogEventListener;
                throw ex;
     *
                    lastRefreshedCheckpointListener.updateRefreshedCheckpoint(localCheckpointBeforeRefresh);
                versionValue = new IndexVersionValue(null, docIdAndVersion.version, docIdAndVersion.seqNo, docIdAndVersion.primaryTerm);  
        return true;
                assert delete.origin().isFromTranslog() || deleteResult.getSeqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO;
        if (engineConfig.isEnableGcDeletes()
        // It's expensive to prune because we walk the deletes map acquiring dirtyLock for each uid so we only do it  
     * {@code cluster.remote_store.flush_on_uncommitted_segments.enabled}; the stamped commit generation must match the  
    }
import java.util.function.BiFunction;
     * @deprecated This assertion has been moved to IndexingStrategyPlanner
            }  
                            }
                        delete.getIfPrimaryTerm(),
    public void forceMerge(  
        // TODO: maybe we should just put a scheduled job in threadPool?
    }
                documentCountTracker::tryAcquireInFlightDocs,
            throw new IllegalStateException("a translog batch is already active on this bulk thread");  
                    /*
    }
                "Failing shard as update operation is not allowed for append only index ",  
                localCheckpointTracker.markSeqNoAsPersisted(seqNo);  
                        new Translog.NoOp(noOp.seqNo(), noOp.primaryTerm(), noOp.reason())  
        assert Objects.equals(get.uid().field(), IdFieldMapper.NAME) : get.uid().field();
        final Map<String, String> commitData = new HashMap<>(8);
            // no version, get the version from the index, we know that we refresh on flush  
    }  
    }  
     * that was published with them. Only ever effective on remote-store shards, since the accounting is only published
                String translogUUID = Objects.requireNonNull(userData.get(Translog.TRANSLOG_UUID_KEY));  
            logger.warn("could not lock IndexWriter", ex);
                this.isContextAwareEnabled = engineConfig.getIndexSettings().isContextAwareEnabled();  
                final Map<String, String> commitData = new HashMap<>(7);
    private boolean assertMaxSeqNoOfUpdatesIsAdvanced(Term id, long seqNo, boolean allowDeleted, boolean relaxIfGapInSeqNo) {
                        doc.add(softDeletesField);
            return true;  
                failEngine("refresh failed source[" + source + "]", e);  
    protected final DocumentIndexWriter documentIndexWriter;
        return getMinRetainedSeqNo() <= startingSeqNo;
    }
    }  
            this.bytes = bytes;  
            );
                        return GetResult.NOT_EXISTS;
            ensureOpen(ex);
        @Override
        assert assertNonPrimaryOrigin(index);
                }  
        private final OpenSearchReaderManager internalReaderManager;  
    public long getPersistedLocalCheckpoint() {
        OpenSearchReaderManager internalReaderManager = null;
    private final AtomicLong maxSeenAutoIdTimestamp = new AtomicLong(-1);  
        } else if (failedEngine.get() == null && isClosed.get() == false) { // we are closed but the engine is not failed yet?
                    // This ensures all segments in memory are available to parent writer before triggering a force merge.
        for (TranslogBatchScope batch : activeBatches) {
            assert incrementIndexVersionLookup();
        }
        if (shouldFail) {  
import org.opensearch.common.unit.TimeValue;
                        index.uid().bytes(),
                // we are switching from an unsafe map to a safe map. This might happen concurrently
                                index.uid().bytes(),
            throw e;
                plan.version,  
                commitData.put(MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, Long.toString(maxUnsafeAutoIdTimestamp.get()));  
                    // the second refresh will only do the extra work we have to do for warming caches etc.  
    private volatile PrimaryOperationPolicy primaryOperationPolicy;
        }  
        } catch (IOException e) {
            engineConfig.getPrimaryTermSupplier(),  
        } finally {
                /* There is no tragic event recorded so this must be a document failure.
                                throw new EngineException(shardId, "failed to read operation from translog", e);  
                plan.addStaleOpToEngine || plan.currentlyDeleted,
 * The default internal engine (can be overridden by plugins)
                LuceneChangesSnapshot.DEFAULT_BATCH_SIZE,
                            segment.mergeId = onGoingMerge.getId();
        return documentCountTracker.getInFlightDocCount();  
        }
    }  
                    protected void doRun() {
                bootstrapAppendOnlyInfoFromWriter(writer);  
    public long getProcessedLocalCheckpoint() {  
            activeBatch.remove();  
                if (plan.executeOpOnEngine || plan.addStaleOpToEngine) {  
                 *  will just de-optimize some doc in the worst case.
                    throw new EngineCreationFailureException(shardId, "failed to create engine", e);
    private Engine.Searcher wrapSearcher(Engine.Searcher searcher) {
                try {
            if (scorer == null) {  
    private final IndexWriterFactory nativeIndexWriterFactory;
import org.opensearch.common.util.io.IOUtils;  
            + operation.seqNo();
            /* in this case we first check if the engine is still open. If so this exception is just fine  
     * a document must precede the delete of the same document, whichever path the caller took to get here.
                                    // in the case of a already pruned translog generation we might get null here - yet very unlikely
    public void refresh(String source) throws EngineException {
                assert assertDocDoesNotExist(index, indexingStrategyPlanner.canOptimizeAddDocument(index) == false);
                throw e;
                if (docsWithId > 0) {  
                this.softDeletesPolicy = newSoftDeletesPolicy();
                        flush();
                throw engineException;  
                if (plan.earlyResultOnPreFlightError.isPresent()) {
     * The flush threshold is stamped in alongside the bytes rather than read from settings on the flush poll, so that
        private final AtomicInteger numMergesInFlight = new AtomicInteger(0);  
    @Override
        final TranslogDeletionPolicy translogDeletionPolicy = getTranslogDeletionPolicy(engineConfig);  
            noOpResult.setTook(System.nanoTime() - noOp.startTime());
        } catch (RuntimeException | IOException e) {
                    logger.warn("Failed to close translog", e);  
            return planIndexingAsNonPrimary(index);  
        for (LeafReaderContext leaf : directoryReader.leaves()) {
    @Override
                final String currentForceMergeUUID = forceMergeUUID;  
            } else {
import org.opensearch.index.translog.TranslogDeletionPolicy;
                 * Bottom line is that we can only rely on the fact that if it's a document failure then
                    // we need to lock here to access the version map to do this truly in RT
                default:
    }
                    refresh("force merge");
                        /*  
                        documentIndexWriter.getAccumulatingIndexWriter().addDocument(doc);
    protected IndexingStrategy indexingStrategyForOperation(final Index index) throws IOException {
                    deleteResult = deleteInLucene(delete, plan);
import org.opensearch.index.mapper.ParseContext;
                        } else {
            || lastRefreshedCheckpoint() < localCheckpointTracker.getProcessedCheckpoint()  
    }
        if (commitUserData.containsKey(Engine.MIN_RETAINED_SEQNO)) {
                delete.primaryTerm(),
                        }
            final Optional<Exception> preFlightError = preFlightCheckForNoOp(noOp);
import org.opensearch.index.seqno.SequenceNumbers;
                 * we return a `MATCH_ANY` version to indicate no document was index. The value is  
            int docId;
            if (get.realtime()) {
                accurateCount
        if (engineConfig.isEnableGcDeletes()) {  
        RefreshWarmerListener(Logger logger, AtomicBoolean isEngineClosed, EngineConfig engineConfig) {
    }
        return versionMap.isSafeAccessRequired();
                 * case increasing and can be used in the failure case when we retry and resent documents to establish a happens before  
            LuceneChangesSnapshot snapshot = new LuceneChangesSnapshot(
    }
            super(shardId, indexSettings, mergedSegmentTransferTracker);
            // this is an anti-viral settings you can only opt out for the entire index
            }
                            new DeleteVersionValue(  
        assert refreshed == false || lastRefreshedCheckpoint() >= localCheckpointBeforeRefresh : "refresh checkpoint was not advanced; "  
                        final boolean toAppend = plan.executeOpOnEngine && plan.useUpdateDocument == false;  
        ensureOpen();
                    final Translog.Location location = translogManager.add(
                        translogManager.trimUnreferencedTranslogFiles();
                // sequence-number space; recording no-ops here could collide with operations the
        final Map<String, String> commitUserData = store.readLastCommittedSegmentsInfo().userData;  
import java.io.Closeable;
import org.apache.logging.log4j.Logger;
        try {
            return new GatedCloseable<>(snapshot, () -> releaseIndexCommit(safeCommit));
            final StoredFields storedFields = leaf.reader().storedFields();  
        }  
            committedFiles = new HashSet<>(committedInfos.files(false));  
    protected final LiveVersionMap versionMap = new LiveVersionMap();
                 *  while both docs are in flight, we disconnect on one node, reconnect and send doc A again
        assert plan.executeOpOnEngine || plan.addStaleOpToEngine;
        if (versionValue == null) {  
         *      so a lookup can find it and determine that o1 is stale.
                    searcher.getIndexReader(),
                    if (get.isReadFromTranslog()) {  
            failEngine("already closed by tragic event on the translog", translogManager.getTragicExceptionIfClosed());  
     * current last commit so that stale values (e.g. right after a flush, before the next successful segments sync)
        final boolean upgrade,
                            index.getIfSeqNo(),
            return planDeletionAsNonPrimary(delete);
        return status;
            success = true;
        } else {
                } else {
     * the engine holds no opinion about how the index setting and its cluster fallback are resolved. A threshold change  
         * primary term here has already been set, see IndexShard#prepareIndex where the Engine$Index operation is created.
                        if (isClosed.get() == false) {
                if (e instanceof AlreadyClosedException == false && treatDocumentFailureAsTragicError(index)) {  
     * {@link #refreshPrimaryOperationPolicy()}, so that a single operation sees one consistent policy even
            throttle.activate();  
    private boolean isWriteLockHeld() {  
        DocumentIndexWriter writer = null;
                    }
    static final class RefreshWarmerListener implements BiConsumer<OpenSearchDirectoryReader, OpenSearchDirectoryReader> {  
                maybeFailEngine("start", e);
            }  
    long getGcDeletesInMillis() {  
                continue;
        final boolean flush,
            final VersionValue versionValue = versionMap.getVersionForAssert(id.bytes());  
            for (ReferenceManager.RefreshListener listener : engineConfig.getInternalRefreshListener()) {  
            if (numMergesInFlight.decrementAndGet() < maxNumMerges) {  
    protected final IndexingStrategy planIndexingAsNonPrimary(Index index) throws IOException {
     * Size of segment bytes not yet referenced by the last commit point on a remote-store shard, published by the
                        // _GET calls invoked by API will also attempt to read from translog when realtime=true (which is the default).  
                    logger.debug("engine closed [{}]", reason);
                    restoreVersionMapAndCheckpointTracker(Lucene.wrapAllDocsLive(searcher.getDirectoryReader()));
            if (warmer != null) {
                // does not lock translog or prevents unreferenced files from trimming.  
import org.opensearch.common.util.concurrent.ReleasableLock;
            warmer = engineConfig.getWarmer();  
        return versionMap.getUnderLock(id);
        numVersionLookups.inc();  
        final UncommittedSegmentBytes current = this.uncommittedSegmentBytes;
import org.apache.lucene.search.Scorer;
        private final Logger logger;
                            get.getIfPrimaryTerm(),
                                    );
    @Override
            localCheckpointTracker.markSeqNoAsProcessed(deleteResult.getSeqNo());
        int maxNumSegments,
                try {
                } else {
            if (committedFiles.contains(file.getKey()) == false && file.getKey().startsWith(IndexFileNames.SEGMENTS) == false) {
                if (idFieldVisitor.getId() == null) {  
                updateDocs(index.uid(), index.docs(), documentIndexWriter, plan.version, index.seqNo(), index.primaryTerm());
                this::hasBeenProcessedBefore,
    }
                            trackTranslogLocation.set(true);  
        // We don't guard w/ readLock here, so we could throw AlreadyClosedException
                                delete.seqNo(),
            return true;
    protected final void refreshIfNeeded(String source, long requestingSeqNo) {
                 *  - doc A has autoGeneratedIdTimestamp = 10, isRetry = false
                final String reason = String.format(  
                if (deferred == false) {  
            throw ex;  
        super(engineConfig);
                maybeFailEngine("acquire changes snapshot", e);
            this.flushThresholdBytes = flushThresholdBytes;
        final TranslogBatchScope batch = new TranslogBatchScope(
                logger.info("starting segment upgrade upgradeOnlyAncientSegments={}", upgradeOnlyAncientSegments);
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNo) throws IOException {  
        }  
    private void revisitIndexDeletionPolicyOnTranslogSynced() {  
                            ? new IndexVersionValue.PendingLocation(batch)
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
     * are in sync with the Lucene commit.  
                maybeFailEngine("delete", e);
                            "new commit on flush, hasUncommittedChanges:{}, force:{}, shouldPeriodicallyFlush:{}",
            ensureOpen();
        return settings.isTranslogBatchAppendEnabled()  
                        final GatedCloseable<IndexCommit> latestCommit = engineConfig.getIndexSettings().isSegRepEnabledOrRemoteNode()  
                assert index.docs() != null && index.docs().isEmpty() == false;
        TranslogEventListener translogEventListener  
            ensureOpen();  
    private boolean treatDocumentFailureAsTragicError(Index index) {  
        @Override  
    }
    public void updateUncommittedSegmentBytes(Map<String, Long> localSegmentsSizeMap, long flushThresholdBytes) {  
     * Note this is only available if assertions are enabled
        final boolean upgradeOnlyAncientSegments,
            }
        // race can only suppress a flush trigger until the next successful segments sync republishes, never cause
        boolean accurateCount  
                delete.seqNo(),
    }  
            return SeqNoGapFiller.fillGaps(localCheckpointTracker, translogManager, primaryTerm, noOp -> innerNoOp(noOp));  
        return index.origin() == Operation.Origin.REPLICA
                getMergedSegmentTransferTracker()
             */
    }
                try {
    protected final SoftDeletesPolicy softDeletesPolicy;  
    @Override
    }  
     * @param writer   the index writer to commit  
                            index.uid(),
            throw new IllegalArgumentException(
        }
        assert count >= 1 : "invalid post-increment throttleRequestCount=" + count;
                if (isThrottling.getAndSet(false)) {
            indexWriter.softUpdateDocument(uid, docs.get(0), version, seqNo, primaryTerm, softDeletesField);
            commitData.put(entry.getKey(), entry.getValue());
    }
            doc.add(softDeletesField); // soft-deleted every document before adding to Lucene  
                    throw new UnsupportedOperationException(
         * We do NOT acquire the readlock here since we are waiting on the merges to finish  
            }
                .deletionPolicy(combinedDeletionPolicy)  
                    throw new AssertionError("doc [" + index.id() + "] exists [" + docsWithId + "] times in index");
    private final Lock flushLock = new ReentrantLock();
    public PrimaryOperationPolicy getPrimaryOperationPolicy() {
            return getFromSearcher(get, searcherFactory, scope);
            } else {  
    /**
        stats.addIndexWriterMemoryInBytes(documentIndexWriter.ramBytesUsed());
                            }
                    }
    @Override
                }  
        assert op.seqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO : "resolving ops based on seq# but no seqNo is found";
    ) {
        optimizeLock.lock();
        return documentIndexWriter.ramBytesUsed() + versionMap.ramBytesUsedForRefresh();
    boolean isSafeAccessRequired() {  
            }
                    } else {  
                                            reader,
                    }  
    protected final boolean hasBeenProcessedBefore(Operation op) {
                try {  
import org.opensearch.common.SuppressForbidden;
                    delete.origin(),
    }
        protected boolean tryIncRef(OpenSearchDirectoryReader reference) {
            lastMinRetainedSeqNo = Long.parseLong(commitUserData.get(Engine.MIN_RETAINED_SEQNO));  
        final long seqNo = noOp.seqNo();
     * Returns the number of documents have been appended since this engine was opened.
            throw e;  
                    final Translog.Location translogLocation = trackTranslogLocation.get() ? indexResult.getTranslogLocation() : null;  
                 *
                            ? acquireLastIndexCommit(false)
                    isWarmedUp = true;
            this::ensureOpen,
    @SuppressForbidden(reason = "reference counting is required here")  
        // the to a write lock when we fail the engine in this operation  
            if (refreshed != primaryOperationPolicy) {
            assert tombstone.docs().size() == 1 : "Tombstone doc should have single doc [" + tombstone + "]";  
     * This count does not include the deletions from the existing segments before opening engine.  
            }
    protected SegmentInfos getLastCommittedSegmentInfos() {  
        maybePruneDeletes();
        String translogUUID,  
                if (ExceptionsHelper.stackTrace(e).contains("org.apache.lucene.index.IndexWriter.filesExist")) {
                }  
            /*
                        final IndexVersionValue.PendingLocation pending = plan.executeOpOnEngine  
    final boolean refresh(String source, SearcherScope scope, boolean block) throws EngineException {
        stats.updateMaxUnsafeAutoIdTimestamp(maxUnsafeAutoIdTimestamp.get());
                 * the maximum sequence number to be less than the last sequence number to go into a Lucene commit, otherwise we run the
    @Override  
        }  
         * number service if this is on the primary, or the existing document's sequence number if this is on the replica. The  
        final DocumentIndexWriter indexWriter,
                    );
         * primary for user facing APIs but this arbitrary time limit is problematic for replicas. On replicas however we should  
     * Asserts that the doc in the index operation really doesn't exist
                this::resolveDocVersion,  
                                            index.primaryTerm(),  
                        if (indexResult.getResultType() == Result.Type.SUCCESS) {
            } else {
                    documentIndexWriter.rollback();
                if (refreshed) {
        return maxSeenAutoIdTimestamp.get();
        final VersionValue versionValue = versionMap.getVersionForAssert(index.uid().bytes());  
                    if (batch != null && indexResult.getResultType() == Result.Type.SUCCESS) {
        return numDocUpdates.count();
                 * to detect if it has potentially been added before. We use the documents timestamp for this since it's something  
                    final TranslogBatchScope batch = activeBatch.get();
                    public void onFailure(String reason, Exception ex) {
            }  
                    refreshListener.accept(newReader, isWarmedUp ? referenceToRefresh : null);
             * Document level failures when deleting are unexpected, we likely hit something fatal such as the Lucene index being corrupt,
    @Override
    private void flushActiveBatchBeforeInlineWrite() {  
     * Checks whether the uncommitted segment bytes published by the remote segment upload path breach the threshold  
        return mergeScheduler.onGoingMerges().size();
                    }
                 *  - doc B has autoGeneratedIdTimestamp = 9, isRetry = false  
                try {  
    @Override  
        assert assertIncomingSequenceNumber(delete.origin(), delete.seqNo());
    public void deactivateThrottling() {
                }
        }
        assert plan.version >= 0 : "version must be set. got " + plan.version;  
                    break;  
        assert assertMaxSeqNoOfUpdatesIsAdvanced(delete.uid(), delete.seqNo(), false, false);  
                engineConfig.getIndexSettings(),
                        throw new VersionConflictEngineException(
    }
            for (OnGoingMerge onGoingMerge : onGoingMerges) {  
                                location = innerNoOp(noOp).getTranslogLocation();
    }
                @Override
        }
                this.translogManager = translogManagerRef;  
                documentCountTracker::tryAcquireInFlightDocs
                        // with Segment Replication we need to hold the latest commit before a new one is created and ensure it is released
            // this case, write lock may not be present on the new map, but lock maybe present on the old map. In this
            if (versionValue.isDelete() == false || allowDeleted == false) {
                flushActiveTranslogBatches();
     * @opensearch.internal
     * rather than a compare-and-set is sufficient because the field is only ever written from the segments sync path,
            } else {
            }
                    if (indexResult.getTranslogLocation() == null
                            } catch (IOException e) {
                        // _GET calls deployed due to an update request will attempt to read from the translog first to guarantee the most
        return true;
    public long getLastSyncedGlobalCheckpoint() {
            // non-primary mode (i.e., replica or recovery)
        updateAutoIdTimestamp(newTimestamp, true);  
                assert versionMap.assertKeyedLockHeldByCurrentThread(op.uid().bytes());
     * and old segments can be released in the same way previous version did this (as a side-effect of _refresh)
        } finally {
                engineConfig.getShardId(),
                localCheckpointTracker.markSeqNoAsPersisted(deleteResult.getSeqNo());
import org.opensearch.index.merge.MergedSegmentTransferTracker;  
        return localCheckpointTracker.getStats(globalCheckpoint);
            try (Searcher searcher = acquireSearcher("load_seq_no", SearcherScope.INTERNAL)) {
                }
        } else {  
        return documentIndexWriter.getFlushingBytes() + versionMap.getRefreshingBytes();
            if (noOpResult.getTranslogLocation() == null) {  
import java.util.Map;
            } else if (merge.getTotalBytesSize() >= engineConfig.getIndexSettings().getFlushAfterMergeThresholdSize().getBytes()) {
                    if (block || isContextAwareEnabled) {
                shouldPeriodicallyFlushAfterBigMerge.set(true);
        return doGenerateSeqNoForOperation(operation);
                        }
        return localCheckpointTracker.generateSeqNo();
                releaseIndexCommit(safeCommit);
                }  
        ensureOpen();
    LiveIndexWriterConfig getCurrentIndexWriterConfig() {
            return createWriter(store.directory(), iwc);  
    }
    // How many callers are currently requesting index throttling. Currently there are only two situations where we do this: when merges
    }  
            // For composite IndexWriter, we need to validate that lock is on either the new map or old map. This is because,  
        try (ReleasableLock ignored = readLock.acquire()) {
     * nulling the field is all that is needed.  
                    commitData.put(FORCE_MERGE_UUID_KEY, currentForceMergeUUID);
                    batch.abort(closeFailure);  
            BiConsumer<OpenSearchDirectoryReader, OpenSearchDirectoryReader> refreshListener
                }
    }
                        if (toAppend == false) {
            } catch (Exception e) {
        return localCheckpointTracker.hasProcessed(op.seqNo());
     * called while the write lock is hold or in a disaster condition ie. if the engine  
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {
     * which includes newly written segments as well as updated per-segment files (e.g. live docs and doc-values
        } else if (engineConfig.isEnableGcDeletes()
        }
    }  
        private final long flushThresholdBytes;  
                logger.debug("primary operation policy changed from [{}] to [{}]", primaryOperationPolicy, refreshed);  
         *
    }
                        config().getShardId(),
                                    indexResult.getFailure().toString()
         * we can't use it.
        } else {
            return Arrays.asList(segmentsArr);
                 * The handling inside IW doesn't guarantee that an tragic / aborting exception
                            : "Noop tombstone document but _tombstone field is not set [" + doc + " ]";
    @Override
                // the op is coming from the translog (and is hence persisted already) or does not have a sequence number (version conflict)  
                } catch (final Exception inner) {  
    protected Optional<Exception> preFlightCheckForNoOp(final NoOp noOp) throws IOException {  
                lastCommittedSegmentInfos = store.readLastCommittedSegmentsInfo();  
    private final AtomicLong maxSeqNoOfUpdatesOrDeletes;
                engineConfig.getIndexSettings(),  
        }
    private final CounterMetric numDocDeletes = new CounterMetric();
                .buildIndexWriterConfig();
                 *  if A' arrives on the shard first we update maxUnsafeAutoIdTimestamp to 10 and use update document. All subsequent
                for (SegmentCommitInfo segmentInfoPerCommit : onGoingMerge.getMergedSegments()) {
                if (versionMap.isUnsafe()) {
                Index index = (Index) op;
            }
        }  
                    success = true;  
                failEngine(reason, ex);
                );  
    private final CombinedDeletionPolicy combinedDeletionPolicy;  
        numDocAppends.inc(docs.size());
            }  
                    throw new EngineCreationFailureException(
        CompositeTranslogEventListener translogEventListener
 * Licensed to Elasticsearch under one or more contributor  
    @Override
                    } catch (AlreadyClosedException e) {  
        // both refresh types will result in an internal refresh but only the external will also  
            throttle.deactivate();  
                try (Releasable ignore = versionMap.acquireLock(get.uid().bytes())) {
                    shardId  
        BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier
                + id
                }
    @Override
        final long lastMinRetainedSeqNo;
     */
                        // recent version.
    /**
                this::incrementVersionLookup
            } catch (IOException | TranslogCorruptedException e) {
                    translogManager.ensureCanFlush();
            throw new EngineException(shardId, e.getMessage(), e);  
                    documentIndexWriter.forceMergeDeletes(true /* blocks and waits for merges*/);  
            final PrimaryOperationPolicy refreshed = engineConfig.getPrimaryOperationPolicy();
                )
                TranslogEventListener internalTranslogEventListener = new TranslogEventListener() {
                                    indexResult.getSeqNo(),
            this.primaryOperationPolicy = engineConfig.getPrimaryOperationPolicy();
                    store.decRef();
                    if (versionValue.isDelete()) {  
                .engineConfig(engineConfig)
 * license agreements. See the NOTICE file distributed with
                        index = new Index(  
                e.addSuppressed(inner);
     */
        this(engineConfig, IndexWriter.MAX_DOCS, LocalCheckpointTracker::new, translogEventListener);  
        private boolean isWarmedUp; // guarded by refreshLock
                } catch (Exception e) {
            case EXTERNAL:  
        return documentIndexWriter.hasNewIndexingOrUpdates()
                        || compareOpToVersionMapOnSeqNo(idFieldVisitor.getId(), seqNo, primaryTerm, curr) == OpVsEngineDocStatus.OP_NEWER) {
            // non-primary mode (i.e., replica or recovery)
        // NOTE: we don't throttle this when merges fall behind because delete-by-id does not create new segments:  
        return translogManager.getLastSyncedGlobalCheckpoint();
                // increment the ref just to ensure nobody closes the store during a refresh  
                activeBatches.clear();
                e.addSuppressed(inner);  
    long getNumIndexVersionsLookups() { // for testing
                + "]";
            final ParseContext.Document doc = tombstone.docs().get(0);  
                forceMergeUUID = commitData.get(FORCE_MERGE_UUID_KEY);  
        final IndexCommit safeCommit = combinedDeletionPolicy.acquireIndexCommit(true);
                    delete.id(),  
                    currentCriteria
        BiFunction<Long, Long, LocalCheckpointTracker> localCheckpointTrackerSupplier,
        final boolean engineFailed;
    }
                                    index.startTime(),
                 * relationship. For instance:
            return snapshot.get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        awaitPendingClose();
        activeBatches.remove(batch);
                    Locale.ROOT,
            } catch (AssertionError e) {
        }
            }
            || index.origin() == Operation.Origin.PEER_RECOVERY  
            }
            assert false : "max_seq_no_of_updates on primary is unassigned";
         *  
            try (Searcher searcher = acquireSearcher("load_version", SearcherScope.INTERNAL)) {
         *   *) If o2 is a delete then its seq# is recorded in the VersionMap, since seq#(o2) > seq#(o1) > LCP,
                                        new Engine.Searcher(  
            lastCommittedSegmentInfos = store.readLastCommittedSegmentsInfo();  
                }
            // map may rotate in between the time when lock was taken on composite IndexWriter and assertion is made. In
                 */
            deleteResult.setTook(System.nanoTime() - delete.startTime());
        flushActiveBatchBeforeInlineWrite();  
import org.opensearch.core.index.shard.ShardId;
    @Override
     *
import org.opensearch.index.seqno.SeqNoStats;  
    public boolean maybeRefresh(String source) throws EngineException {
    /**
            } catch (IOException e) {
            }
            } catch (final Exception inner) {
                            break;
                + " ]";  
            // TODO: Simulate this with a unit test.  
        try (ReleasableLock ignored = readLock.acquire(); Releasable ignored2 = versionMap.acquireLock(delete.uid().bytes())) {
            engineConfig.getIndexSettings().getTranslogBatchAppendMaxSize().getBytes()
                flushAndCloseInternal();
        }  
     * Whether we should treat any document failure as tragic error.
            }
            }
            ensureOpen();  
                toSeqNo,  
    }
     */
    /** Returns how many bytes we are currently moving from indexing buffer to segments on disk */
 * software distributed under the License is distributed on an
                    // This will be needed as in prior scenario, we call a flush before triggering force merge in lucene.  
                searcher.setQueryCache(null);
                    reader,  
     * though it reads the policy at several points.
            writer.setLiveCommitData(() -> {
        if (versionMap.isUnsafe()) {
            try {  
    protected final AtomicBoolean shouldPeriodicallyFlushAfterBigMerge = new AtomicBoolean(false);
            if (config().getIndexSettings().isDerivedSourceEnabled()) {  
            return snapshot;
                        assert tombstone.docs().size() == 1 : "Tombstone should have a single doc [" + tombstone + "]";
import java.util.concurrent.locks.Lock;
                logger.trace("acquired flush lock after blocking");
    @Override  
                        refreshed = true;  
                                plan.version,
                && System.nanoTime() - lastWriteNanos >= engineConfig.getFlushMergesAfter().nanos()) {
                        e
            }
     * If this method returns a non-empty result, the engine won't process this NoOp and returns a failure.
     */
        long fromSeqNo,  
            noOpResult = innerNoOp(noOp);
            .add(Queries.newNonNestedFilter(), BooleanClause.Occur.MUST)
            engineFailed = true;
        long primaryTerm
            return noOpResult;
                            failEngine("no-op origin[" + noOp.origin() + "] seq#[" + noOp.seqNo() + "] failed at document level", ex);  
     */
                storedFields.document(docId, idFieldVisitor);
            }  
                this.combinedDeletionPolicy = new CombinedDeletionPolicy(
            try (  
        return deletionStrategyPlanner.planOperationAsNonPrimary(delete);
                );
import java.util.Locale;
    protected final void writerSegmentStats(SegmentsStats stats) {
     * Checks if the given operation has been processed in this engine or not.
                }
        if (engineConfig.isAutoGeneratedIDsOptimizationEnabled() == false) {  
        } catch (Exception e) {  
                    assert dv.isTombstone(docId);
            throw new IllegalArgumentException("max_seq_no_of_updates on primary is unassigned");  
                    assert upgrade == false;
                        logger.debug(
    @Override
        return documentIndexWriter.getConfig();
                    assert indexResult.getResultType() == Result.Type.FAILURE : indexResult.getResultType();
        private UncommittedSegmentBytes(long bytes, long committedInfosGeneration, long flushThresholdBytes) {
    public long getIndexBufferRAMBytesUsed() {  
                 *  - now doc A' has autoGeneratedIdTimestamp = 10, isRetry = true  
                localCheckpointTracker.markSeqNoAsProcessed(seqNo);
        mergeScheduler.refreshConfig();  
            while ((docId = iterator.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
    /**
    private void updateDocs(
            // best-effort accounting, a failed computation must never affect the segment upload path
     * the failed scope are unacknowledged with unprocessed sequence numbers, the same state the stock engine leaves a  
    }
    private volatile SegmentInfos lastCommittedSegmentInfos;
            }
    private final ExternalReaderManager externalReaderManager;
        }  
                        logger.trace("finished commit for flush");
     * Operations whose seq# are at least this value should exist in the Lucene index.  
                // authority has not replicated yet.  
            this.indexingStrategyPlanner = new IndexingStrategyPlanner(  
    }
    @Override
                    return;
         * Here we prefer to deploy a single trimming strategy, which satisfies two constraints, on both primary and replicas because:  
            }
    /**  
                final BytesRef uid = new Term(IdFieldMapper.NAME, Uid.encodeId(idFieldVisitor.getId())).bytes();
                                    index.origin(),  
            assert incrementIndexVersionLookup(); // used for asserting in tests
    }
                }
                    closedLatch.countDown();  
                        );
     * which is serialized per shard by the refresh listener's permit; and even a lost race here could only suppress a
                internalReaderManager.release(newReader);  
            }  
    }
            LongPoint.newRangeQuery(SeqNoFieldMapper.NAME, getPersistedLocalCheckpoint() + 1, Long.MAX_VALUE),  
        return localCheckpointTracker.getProcessedCheckpoint();
                        markSeqNoAsSeen(index.seqNo());
 * GitHub history for details.
        final SegmentInfos committedInfos = this.lastCommittedSegmentInfos;  
    }
            } else {
                        indexResult = indexIntoLucene(index, plan);
        }
                    refreshIfNeeded("realtime_get", versionValue.seqNo);
            } catch (Exception inner) {
        }
                        delete.id(),
     * This count does not include the appends from the existing segments before opening engine.
                }
            lastMinRetainedSeqNo,  
                // TRANSLOG_UUID belongs to whichever copy uploaded the segments.
                                    index.primaryTerm(),
        } catch (Exception ex) {  
    long getNumDocUpdates() {  
 */  
            throttle = new IndexingThrottler();  
                }  
            } else {
        if (primaryOperationPolicy.acceptsPreAssignedSeqNos()) {
     * Snapshot of {@link EngineConfig#getPrimaryOperationPolicy()}. Re-read only from  
    /**
import java.io.IOException;
                bytes += file.getValue();  
         * we don't acquire the write lock and wait until we have exclusive access. This might also
    }  
                // but we only need to do this once since the last operation per ID is to add to the version
                // are running.
                 * Yet, we have to deal with multiple document delivery, for this we use a property of the document that is added
            } catch (Exception inner) {
import org.apache.lucene.index.StandardDirectoryReader;  
import org.apache.lucene.search.TermQuery;
            }
     */  
            } catch (Exception innerException) {
            if (store.tryIncRef()) {
        // delete-2, index-3, and the order on a replica is index-1, index-3, delete-2, then the msu of index-3 on the replica is 2  
            }  
        return softDeletesPolicy.getMinRetainedSeqNo();  
                addDocs(index.docs(), documentIndexWriter, index.uid());
            } catch (Exception inner) {
        }
    private DocumentIndexWriter getDocumentIndexWriter() throws IOException {  
            failOnTragicEvent(e);
                    throw ex;
                        "Updating grouping criteria is not allowed for context aware enabled indices.",
            translogEventListener,
     * @param translogUUID the translogUUID
        }
    }
    }
import org.opensearch.index.shard.OpenSearchMergePolicy;  
        }  
                this.externalReaderManager.addListener(listener);
import org.apache.lucene.search.BooleanQuery;
import java.util.stream.Collectors;  
                maybeFailEngine("noop", e);
    protected final ReferenceManager<OpenSearchDirectoryReader> getReferenceManager(SearcherScope scope) {
        // We don't have to do this here; we do it defensively to make sure that even if wall clock time is misbehaving
            } catch (Exception inner) {  
                    documentIndexWriter.rollback();
                + versionValue.term;
            if (versionValue != null && versionValue.isDelete()) {
            } else {  
    @Override
    @Override  
            shardId,  
     */
            if (flushLock.tryLock() == false) {
                    if (curr == null
        } else {
    }  
    }
            try (Searcher searcher = acquireSearcher("assert doc doesn't exist", SearcherScope.INTERNAL)) {  
                        if (dv.isTombstone(docId)) {  
        boolean onlyExpungeDeletes,  
            final CatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(infos);
            });
    private void releaseIndexCommit(IndexCommit snapshot) throws IOException {
        EngineConfig engineConfig,  
        );  
        }
            if (isClosed.get() == false) {
    @Override
        // a spurious flush.
                }
                    } else {
            logger.debug("failed to compute uncommitted segment bytes", e);  
import org.opensearch.common.lease.Releasables;
            throw new TranslogException(shardId, "Failed to execute index deletion policy on translog synced", ex);
                case "segments":
        try {
         * are remembered for at least one GC delete cycle and trimmed periodically. This is, at the moment, the best we can do on
     */
                    @Override
    private ExternalReaderManager createReaderManager(RefreshWarmerListener externalRefreshListener) throws EngineException {
     * remote segment upload path after every successful segments sync (see RemoteStoreRefreshListener). Stamped with  
     * record is still deferred.
            }
                scope = SearcherScope.EXTERNAL;  
            );
            final long localCheckpoint = localCheckpointTracker.getProcessedCheckpoint();  
        // exception that should only be thrown in a tragic event. we pass on the checks to failOnTragicEvent which will
        @Override
import java.util.function.BiConsumer;
    /**  
            }
        return true;
        TranslogManager translogManagerRef = null;  
            final CombinedDocValues dv = new CombinedDocValues(leaf.reader());  
                );
    }
    @Override  
    public DeleteResult delete(Delete delete) throws IOException {
 * specific language governing permissions and limitations
                    try {  
                commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(localCheckpointTracker.getMaxSeqNo()));
                // That's ok, we'll clean up unused files the next time it's opened.  
                                            IndexSearcher.getDefaultSimilarity(),  
            }
                commitData.put(Engine.MIN_RETAINED_SEQNO, Long.toString(softDeletesPolicy.getMinRetainedSeqNo()));
        }
    private final OpenSearchReaderManager internalReaderManager;  
        return true;  
import org.opensearch.common.lucene.Lucene;  
    }  
                        // while we are
            try {
     * The main purpose for this is that if we have external refreshes happening we don't issue extra
            }
            this.lastDeleteVersionPruneTimeMSec = engineConfig.getThreadPool().relativeTimeInMillis();  
    @Nullable
            engineConfig.getTranslogConfig(),
     * We should only take care of reopening parent writer here as we will not be concerned on child level writer which
                            get.versionType().explainConflictForReads(versionValue.version, get.version())
    private void addDocs(final List<ParseContext.Document> docs, final DocumentIndexWriter indexWriter, Term uid) throws IOException {
        try {
        }
        // config().isEnableGcDeletes() or config.getGcDeletesInMillis() may have changed:
                                            reader  
    void clearDeletedTombstones() {
            throw new RefreshFailedEngineException(shardId, e);
            if (docIdAndVersion != null) {
            if (upgrade) {
        } else {
                SequenceNumbers.max(localCheckpointTracker.getMaxSeqNo(), translogManager.getMaxSeqNo())
    private static final class UncommittedSegmentBytes {  
        private final long committedInfosGeneration;
     */
        lastDeleteVersionPruneTimeMSec = timeMSec;  
                logger.trace("waiting for in-flight flush to finish");  
import org.opensearch.index.merge.MergeStats;
        }
                return internalReaderManager;
            readLock,
            // this primary's sequence numbers are assigned upstream, so an assigned seq no. is expected  
                 * and just use addDocument instead of updateDocument and skip the entire version and index lookupVersion across the board.
        ensureOpen();
import org.opensearch.ExceptionsHelper;
                    );
                    if (get.versionType().isVersionConflictForReads(versionValue.version, get.version())) {  
     * @return true if the given operation was processed; otherwise false.  
                try {  
            engineFailed = false;
                        throw new VersionConflictEngineException(  
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
            writer = new CompositeIndexWriter(engineConfig, createWriter(), softDeletesPolicy, softDeletesField, nativeIndexWriterFactory);  
                try {
        Objects.requireNonNull(versionValue);  
        }
        return writer;
        if (force && waitIfOngoing == false) {
                    )) {  
                // or (4) the local checkpoint information in the last commit is stale, which slows down future recoveries.
            return true;  
import org.opensearch.index.seqno.LocalCheckpointTracker;
import org.opensearch.common.lease.Releasable;
            // to resolve version from child level IndexWriters (both from mark for refresh and active IndexWriter).
            } finally {
                    status = OpVsEngineDocStatus.DOC_NOT_FOUND;
                                delete.primaryTerm(),  
        return commitData;  
     * This count does not include the updates from the existing segments before opening engine.
    private IndexingStrategy planIndexingAsPrimary(Index index) throws IOException {  
    }
        uncommittedSegmentBytes = new UncommittedSegmentBytes(bytes, committedInfos.getGeneration(), flushThresholdBytes);  
            });
                 * segments, including the local checkpoint amongst other values. The maximum sequence number is different, we never want
        if (scope == SearcherScope.EXTERNAL) {
                 * NOTE: it's not important for this timestamp to be consistent across nodes etc. it's just a number that is in the common
        // We check for pruning in each delete request, but we also prune here e.g. in case a delete burst comes in and then no more deletes  
                try {
    protected void commitIndexWriter(final DocumentIndexWriter writer, final String translogUUID) throws IOException {  
import org.opensearch.index.translog.TranslogOperationHelper;
            }
     * first such sync dirties the field, the rest are a single volatile read and nothing else. A plain guarded write  
import org.apache.lucene.index.IndexFileNames;
            this.internalReaderManager.addListener(lastRefreshedCheckpointListener);
    }
                versionMap,  
            }
        if (Assertions.ENABLED) {  
        private final BiConsumer<OpenSearchDirectoryReader, OpenSearchDirectoryReader> refreshListener;
                }
            lastCommittedSegmentInfos.userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)
    }
            return new IndexResult(plan.version, index.primaryTerm(), index.seqNo(), plan.currentNotFoundOrDeleted);
     */  
    @Override
        return softDeletesPolicy.acquireRetentionLock();
        } catch (final AssertionError e) {  
    ) throws IOException {
import org.opensearch.index.mapper.ParsedDocument;
                return indexResult;  
        } catch (Exception e) {
    }  
                 *  
            int reservedDocs = 0;
                 * if we have an autoGeneratedID that comes into the engine we can potentially optimize  
        if (index.origin() == Operation.Origin.PRIMARY) {
                     * We do this on another thread rather than the merge thread that we are initially called on so that we have complete
    }  
     * Discards the published accounting, disarming the uncommitted-segment-bytes flush condition until the next
     */  
                ExternalReaderManager externalReaderManager = new ExternalReaderManager(internalReaderManager, externalRefreshListener);
    public Translog.Snapshot newChangesSnapshot(
import org.opensearch.search.suggest.completion.CompletionStats;
            case INTERNAL:
        }  
            translogManager,  
                    }  
    InternalEngine(
                    store.decRef();
    @Override
        try (ReleasableLock releasableLock = readLock.acquire()) {
                        internalReaderManager.release(newReader);  
        if (activeBatch.get() == batch) {
        try (ReleasableLock lock = readLock.acquire()) {
        return mergeScheduler.stats();
                    ReferenceManager<OpenSearchDirectoryReader> referenceManager = getReferenceManager(scope);
            try {  
import org.opensearch.common.Nullable;
import org.opensearch.core.common.unit.ByteSizeValue;
                + " existing_term="
import org.opensearch.threadpool.ThreadPool;
                    logger.info("stop throttling indexing: numMergesInFlight={}, maxNumMerges={}", numMergesInFlight, maxNumMerges);
        int reservedDocs = 0;
    final boolean assertSearcherIsWarmedUp(String source, SearcherScope scope) {  
        // ensuring no indexing operation is in flight, since an operation reads the policy more than once.
                                location = null;  
        final List<ParseContext.Document> docs,
                }
     * Returns the current local checkpoint getting refreshed internally.
                    + maxUnsafeAutoIdTimestamp.get()  
            if (deleteResult.getTranslogLocation() == null) {
            maxUnsafeAutoIdTimestamp.updateAndGet(curr -> Math.max(curr, newTimestamp));
     * Returns the number of documents have been deleted since this engine was opened.
                } else if (op.seqNo() > docAndSeqNo.seqNo) {  
        }
     *
            success = true;
    }  
                    "delete id[%s] origin [%s] seq#[%d] failed at the document level",
        final SegmentInfos committedInfos = this.lastCommittedSegmentInfos;
            throw new AssertionError("Unexpected AlreadyClosedException", ex);
            );
     *
    @Override  
            && (engineConfig.getThreadPool().relativeTimeInMillis() - ((DeleteVersionValue) versionValue).time) > getGcDeletesInMillis()) {
        OpenSearchMergePolicy mp = (OpenSearchMergePolicy) documentIndexWriter.getConfig().getMergePolicy();  
            lastWriteNanos = delete.startTime();  
                } else {  
        return new SoftDeletesPolicy(
                    }  
            }  
            // cannot be created due to ensureOpen call in Composite IndexWriter.
        ensureOpen();
        boolean shouldFail = super.maybeFailEngine(source, e);
        return lastRefreshedCheckpointListener.pendingCheckpoint();
            this::maybeFailEngine,
     * @return  
            // a tragic event or has closed itself. if that is not the case we are in a buggy state and raise an assertion error
            ensureOpen();
        }
                                    TranslogLeafReader reader = new TranslogLeafReader(index, config());
package org.opensearch.index.engine;
    @Nullable
    }
                    failEngine("index id[" + index.id() + "] origin[" + index.origin() + "] seq#[" + index.seqNo() + "]", e);
     * A listener that warms the segments if needed when acquiring a new reader
     * therefore takes effect from the next successful segments sync, which on an actively written shard is the next
        final long localCheckpoint;
                    loadSeqNo,
        }
        } finally {  
import org.apache.lucene.index.DirectoryReader;
            } catch (Exception inner) {  
    @Deprecated(forRemoval = true)
            } catch (IOException closeEx) {  
    // for testing
            indexWriter.addDocuments(docs, uid);  
            } catch (FlushFailedEngineException ex) {  
            localCheckpointOfLastCommit,
     * there and only while the condition is enabled cluster-wide by
                final Map<String, String> commitData = commitDataAsMap(writer);
    final Map<BytesRef, VersionValue> getVersionMap() {  
                            get.id(),
                if (onlyExpungeDeletes) {
         * syncs calls to findForcedMerges.
                    // failure we need to dec the store reference
        } catch (IOException ex) {  
    public boolean shouldPeriodicallyFlush() {
    private IndexWriter createWriter() throws IOException {  
    @Override
    @Override
     */  
        maybePruneDeletes();
    }
                            logger.warn("failed to flush after merge has finished");
            status = compareOpToVersionMapOnSeqNo(op.id(), op.seqNo(), op.primaryTerm(), versionValue);
                + "] but was unassigned";  
import org.opensearch.common.metrics.CounterMetric;
                            index.parsedDoc(),
                 * {@link IndexWriter#commit()} call flushes all documents, we defer computation of the maximum sequence number to the time
    // Package private for testing purposes only
     * <p>
    }  
    }
     * can never re-trigger a flush.
        }
        }  
            } else if (plan.useUpdateDocument) {
        }
                                }  
                if (upgrade) {
                e.addSuppressed(inner);
    public Closeable acquireHistoryRetentionLock() {  
 *
                    internalReaderManager.release(reader);  
                this::resolveDocVersion,  
            return new GatedCloseable<>(((StandardDirectoryReader) reader.getDelegate()).getSegmentInfos(), () -> {
        int maxDocs,
            } finally {  
            translogDeletionPolicy,
                        delete.routing()
                // NEVER do this on a merge thread since we acquire some locks blocking here and if we concurrently rollback the writer
            if (success == false) {
                localCheckpointTracker.markSeqNoAsPersisted(noOpResult.getSeqNo());  
     * is happening and the refresh interval is low (ie. 1 sec)  
    // we use the hashed variant since we iterate over it and check removal and additions on existing keys
                .commitOnClose(false)
     *  
            synchronized (versionMap) {  
                        }
        if (docs.size() > 1) {
                                            IndexSearcher.getDefaultQueryCachingPolicy(),
            throw new OpenSearchException("failed to wrap searcher", ex);
            // A remote-segrep bulk may have applied Lucene documents whose translog locations are still deferred. Drain
            ) {  
        ExternalReaderManager(  
                    indexResult = (IndexResult) plan.earlyResultOnPreFlightError.get();
    protected final String historyUUID;
    long getNumDocAppends() {
                // reset it just to make sure we reset it in a case of an error
                    SequenceNumbers.UNASSIGNED_PRIMARY_TERM,
        assert operation.origin() == Operation.Origin.PRIMARY;
            }
            && current.bytes >= current.flushThresholdBytes
        if (flushFirst) {
                if (noOp.origin().isFromTranslog() == false && noOpResult.getResultType() == Result.Type.SUCCESS) {
                        batch.add(new Translog.Index(index, indexResult), indexResult, pending, indexResult.getSeqNo());
    }
                primaryOperationPolicy = refreshed;
     * @opensearch.internal
            }  
             * closing the engine as well. If we are not closed we pass it on to failOnTragicEvent which ensures
    }  
            try {
            // Same decision as a per-operation translog failure in index(): fail the engine only if the exception is the  
        assert incrementVersionLookup(); // used for asserting in tests
            try {  
                // global checkpoint to select a safe commit against, and under remote store the commit's  
            TranslogOperationHelper.create(engineConfig)
    }  
    private boolean incrementIndexVersionLookup() {
        try (final GatedCloseable<SegmentInfos> snapshot = getSegmentInfosSnapshot()) {  
                                            0,  
            mergeScheduler = scheduler = new EngineMergeScheduler(
    public void close() throws IOException {  
                    || shouldPeriodicallyFlush  
                        delete.versionType(),  
    }  
        assert assertNonPrimaryOrigin(delete);
            );  
                                            index.version(),
        return engineFailed;  
    protected DeletionStrategy deletionStrategyForOperation(final Delete delete) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
        }
    @Nullable
                    logger.warn("Failed to close ReaderManager", e);
                throw ex;
             * we are handling a tragic even exception here */  
        return numIndexVersionsLookups.count();  
        try {
    }
        // We treat a delete on the tombstones on replicas as a regular document, then use updateDocument (not addDocument).
            return failOnTragicEvent((AlreadyClosedException) e);
            // and capture the checkpoint afterwards so the drained operations count as refreshed.
         * The way we implement upgrades is a bit hackish in the sense that we set an instance
    }  
                        // A noop tombstone does not require a _version but it's added to have a fully dense docvalues for the version  
            indexWriter.addDocument(docs.get(0), uid);
            this.externalReaderManager = externalReaderManager;
                assert maxUnsafeAutoIdTimestamp.get() == -1 : "max unsafe timestamp was assigned already ["
public class InternalEngine extends Engine {
            flushActiveTranslogBatches();
        return true;  
        boolean success = false;
            final DeletionStrategy plan = deletionStrategyForOperation(delete);
                searcher,
        final long localCheckpointBeforeRefresh;
            // right away
                 * will be used as THE tragicEventException since if there are multiple exceptions causing an abort in IW
            logger.trace("start flush for snapshot");
                    deactivateThrottling();  
                try (Releasable ignored = versionMap.acquireLock(uid)) {
    /**
            if (localCheckpointTracker.getPersistedCheckpoint() < localCheckpointTracker.getMaxSeqNo()) {  
            store.readLastCommittedSegmentsInfo().userData.entrySet()  
        final long maxSeqNoOfUpdates = getMaxSeqNoOfUpdatesOrDeletes();  
                    e.addSuppressed(inner);  
        assert readLock.isHeldByCurrentThread() || writeLock.isHeldByCurrentThread();  
            }  
                    @Override  
                        failOnTragicEvent(e);
                CompositeTranslogEventListener compositeTranslogEventListener = new CompositeTranslogEventListener(
        assert Objects.equals(delete.uid().field(), IdFieldMapper.NAME) : delete.uid().field();
                searcher = acquireSearcher(source, SearcherScope.INTERNAL);  
        } else {
            if (documentIndexWriter.hasPendingMerges() == false  
        ensureOpen();
        if (allowDeleted) {
    private void closeInternal() throws IOException {
            logger.debug("flushing shard on close - this might take some time to sync files to disk");
        private final long bytes;
                maxSeqNoOfUpdatesOrDeletes::get,
            try {
        return rwl.isWriteLockedByCurrentThread() && documentIndexWriter.isWriteLockedByCurrentThread();
                }
            // refresh does not need to hold readLock as ReferenceManager can handle correctly if the engine is closed in mid-way.
     */  
        private final Engine.Warmer warmer;
    /**  
                tragicException = new RuntimeException(writerTragicException);
import org.opensearch.common.util.concurrent.KeyedLock;
import org.opensearch.OpenSearchException;  
         * However, the version map may consume less memory if we deploy two different trimming strategies for primary and replicas.
         * causing us to fail the forceMerge
                // IndexWriter throws AssertionError on init, if asserts are enabled, if any files don't exist, but tests that
                        tombstone.updateSeqID(noOp.seqNo(), noOp.primaryTerm());
    }
    }  
            throw ex;  
        }
    @Override
                final EngineException engineException = new EngineException(shardId, "failed to commit engine", e);  
            if (success == false) { // release everything we created on a failure
                if (documentIndexWriter.validateImmutableFieldNotUpdated(index.docs().get(0), op.uid().bytes())) {  
                store.decRef();  
                this.internalReaderManager.addListener(listener);
                );
                + " op_term="
                /*
                            delete.uid().bytes(),
                    store.trimUnsafeCommits(engineConfig.getTranslogConfig().getTranslogPath());  
    }
                            // use 0L for the start time so we can prune this delete tombstone quickly
            try (ReleasableLock lock = writeLock.acquire(); Releasable ignored = documentIndexWriter.obtainWriteLockOnAllMap();) {  
                    failEngine(MERGE_FAILED, new MergePolicy.MergeException(exc));  
import org.apache.lucene.index.IndexWriter;
                logger.warn("failed to rollback writer on close", e);  
                e.addSuppressed(innerException);  
                writer = getDocumentIndexWriter();
                // we should execute a flush on the next operation if that's a flush after inactive or indexing a document.  
        }
        return true;
                    status = OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
            SearcherScope scope;
    // pkg-private for testing
                    throw e;  
                engineConfig.getShardId(),
    private boolean failOnTragicEvent(AlreadyClosedException ex) {
    long getNumVersionLookups() { // for testing
        // even though it is an update (overwrites index-1). We should relax this assertion if there is a pending gap in the seq_no.
                 * of invocation of the commit data iterator (which occurs after all documents have been flushed to Lucene).  
                tragicException = (Exception) writerTragicException;
     */
                } catch (IOException e) {  
        }
            if (op.operationType() == Operation.TYPE.NO_OP) {
        return maxSeqNoOfUpdatesOrDeletes.get();
        assert documentIndexWriter.getConfig().getMergePolicy() instanceof OpenSearchMergePolicy : "MergePolicy is "
                        }  
    }
        } catch (final Exception ex) {
                        translogManager.trimUnreferencedReaders();
                    if (index.origin() == Operation.Origin.PRIMARY) {
                        new IndexVersionValue(translogLocation, plan.version, index.seqNo(), index.primaryTerm())  
                    store.decRef();  
                        // in refresh listeners.
            assert assertIncomingSequenceNumber(index.origin(), index.seqNo());
import java.util.concurrent.atomic.AtomicInteger;  
            config().getIndexSettings().getFlushThresholdSize().getBytes()
                    flush(false, true);  
        activeBatches.add(batch);
import org.apache.lucene.index.SegmentCommitInfo;
    }
    }
    /**  
    }
                        if (ex instanceof AlreadyClosedException) {  
     * @return the sequence number
                            shouldPeriodicallyFlush
                commitData.put(HISTORY_UUID_KEY, historyUUID);
     * Returned the last local checkpoint value has been refreshed internally.
        return localCheckpointTrackerSupplier.apply(maxSeqNo, localCheckpoint);
            shouldPeriodicallyFlushAfterBigMerge.set(false);
                                Translog.Operation operation = translogManager.readOperation(versionValue.getLocation());  
     * updates) of already committed segments. The value is stamped with the generation of the commit point it was
    protected boolean assertPrimaryCanOptimizeAddDocument(final Index index) {
            ensureOpen();  
                    documentIndexWriter.forceMerge(maxNumSegments, true /* blocks and waits for merges*/);
        } finally {  
     */
            return operation.seqNo();
                    if (success == false) {
    public boolean hasPendingMerges() {
                    || force
        maxSeenAutoIdTimestamp.updateAndGet(curr -> Math.max(curr, newTimestamp));
    private IndexResult indexIntoLucene(Index index, IndexingStrategy plan) throws IOException {
        return batch;  
        assert Objects.equals(index.uid().field(), IdFieldMapper.NAME) : index.uid().field();  
    private final class EngineMergeScheduler extends OpenSearchConcurrentMergeScheduler {
    }
                        : "local checkpoint tracker is not updated seq_no=" + op.seqNo() + " id=" + op.id();
                updateAutoIdTimestamp(Long.parseLong(entry.getValue()), true);
    private final CompletionStatsCache completionStatsCache;
                optimizeLock.unlock();
import org.opensearch.core.Assertions;
     * Returns the minimum seqno that is retained in the Lucene index.
                return true;
            reservedDocs = plan.reservedDocs;
 * SPDX-License-Identifier: Apache-2.0
                }
     * Returns the number of times a version was looked up either from memory or from the index.
            this.refreshListener = refreshListener;
    }
    @Override  
                /* A NOTE ABOUT APPEND ONLY OPTIMIZATIONS:
                        );
    /**
                this.versionMap.clear();  
                    Arrays.asList(internalTranslogEventListener, translogEventListener),
    protected void pruneDeletedTombstones() {
            // fill in the merges flag
    public Engine.TranslogBatch beginTranslogBatch() {
     * Deletes, no-ops and the no-op recorded for a failed index are written to the translog inline. If this bulk thread
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {  
            ensureOpen();  
                    @Override
     *  
}
     * still holds index operations in its batch, append them first so the translog keeps request order: an index of  
                }
                            )
            }
                String currentCriteria = null;  
        logger.debug("close acquired writeLock");  
                }  
        final IndexSearcher searcher = new IndexSearcher(directoryReader);  
    private boolean assertDocDoesNotExist(final Index index, final boolean allowDeleted) throws IOException {  
        // the file set and the generation stamp are both taken from this single snapshot, so the published value is
    }
    @Override
            // scenario, no new entry will be created in the new map as write on new map will be blocked due to an active  
                            failEngine(reason, ex);  
import java.util.HashMap;
            + "local_checkpoint="
        TranslogDeletionPolicy translogDeletionPolicy,
    /**  
            }
                && treatDocumentFailureAsTragicError(index) == false) {
            logger.trace("finish flush for snapshot");
                // we hit a significant merge which would allow us to free up memory if we'd commit it hence on the next change
                return 0;
     * This also prevents segment starvation where an internal reader holds on to old segments literally forever
    protected boolean maybeFailEngine(String source, Exception e) {
     */
        boolean success = false;
        } finally {
                        delete.startTime(),
        }  
        }
    }
        assert seqNo <= maxSeqNoOfUpdates : "id=" + id + " seq_no=" + seqNo + " msu=" + maxSeqNoOfUpdates;
                        logger.warn("failed to prepare/warm", e);  
     */  
        final Query query = new BooleanQuery.Builder().add(
                throw new EngineCreationFailureException(shardId, "failed to open reader on writer", e);
        if (isTranslogBatchingEligible() == false) {
            // sequence number should not be set when operation origin is primary
                            final long startTime = 0L;  
                    logger.warn("Engine is already closed.", e);
            try {
        return translogManager.shouldPeriodicallyFlush(  
                        }  
                        final ParseContext.Document doc = tombstone.docs().get(0);
                        referenceManager.maybeRefreshBlocking();
    /** returns the force merge uuid for the engine */
 * @opensearch.internal  
            } finally {
            }  
                && documentIndexWriter.getTragicException() == null  
            // write lock on rwl lock taken in the close function call. Once close call completes, new entry in new map
    }  
        // Check for AlreadyClosedException -- ACE is a very special  
    }  
     */
                    refresh(source, SearcherScope.INTERNAL, true);
            this.externalReaderManager.addListener(completionStatsCache);  
                    indexResult.freeze();
                        tombstone.version().setLongValue(1L);  
        final SequenceNumbers.CommitInfo seqNoStats = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
    }
     * {@link #clearUncommittedSegmentBytes()}.  
                 *  - doesn't change per document
    private void updateAutoIdTimestamp(long newTimestamp, boolean unsafe) {  
                logger.debug(() -> new ParameterizedMessage("[{}] batched translog append failed while draining", shardId), e);
                softDeletesField  
        } catch (IOException e) {
     * consulted for it exactly as for a per-operation {@code Translog#add} failure. The drainer therefore only stops  
    private final Set<TranslogBatchScope> activeBatches = ConcurrentHashMap.newKeySet();
                } finally {
 * this work for additional information regarding copyright
                        } else if (indexResult.getSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
import org.opensearch.common.lucene.uid.Versions;
            this.documentCountTracker = new DocumentCountTracker(
                if (hasBeenProcessedBefore(noOp) == false) {
            // translog's tragic event (or an AlreadyClosedException over one); otherwise only the request fails.
     * <p>
     */  
            // load from index  
                }
                                            index.seqNo(),
            }
            documentCountTracker.releaseInFlightDocs(reservedDocs);
                                        true
import java.util.stream.Stream;
            });  
                                engineConfig.getThreadPool().relativeTimeInMillis()
     * Updates the uncommitted segment bytes accounting for this (remote-store) shard. Invoked by the remote segment
        if (writerTragicException != null) {
     */
                return new IndexResult(ex, Versions.MATCH_ANY, index.primaryTerm(), index.seqNo());  
import java.util.HashSet;
            if (preFlightError.isPresent()) {  
        try {
        assert incrementVersionLookup();
     */  
     */  
            );
        if (isContextAwareEnabled) {
            this.isEngineClosed = isEngineClosed;
                    delete = new Delete(  
                 *  maxUnsafeAutoIdTimestamp. While this is not strictly needed for doc B it is just much simpler to implement since it
                        indexResult = new IndexResult(plan.version, index.primaryTerm(), index.seqNo(), plan.currentNotFoundOrDeleted);
    // are falling behind and when writing indexing buffer to disk is too slow. When this is 0, there is no throttling, else we throttling  
            Segment[] segmentsArr = getSegmentInfo(lastCommittedSegmentInfos, verbose);
        if (engineConfig.getIndexSettings().getIndexMetadata().isAppendOnlyIndex()) {
                        assert doc.getField(SeqNoFieldMapper.TOMBSTONE_NAME) != null  
    // Lucene operations since this engine was opened - not include operations from existing segments.
import org.apache.lucene.index.SegmentInfos;
     * Restores the live version map and local checkpoint of this engine using documents (including soft-deleted)
    }
                }
                }
        for (ParseContext.Document doc : docs) {
            localCheckpointTracker.markSeqNoAsProcessed(noOpResult.getSeqNo());
        /*  
                if (flush) {
     * pending readers exceptionally and rethrows it at {@code finish()}, and {@code maybeFailEngine} has already been
        } else {  
 * Modifications Copyright OpenSearch Contributors. See
            }  
            try {  
                deleteResult = (DeleteResult) plan.earlyResultOnPreFlightError.get();
                 * non-document failure
        }
        return true;
    /**  
        for (Map.Entry<String, String> entry : writer.getLiveCommitData()) {  
                    markSeqNoAsSeen(delete.seqNo());
    /**
            return LuceneChangesSnapshot.countNumberOfHistoryOperations(s, fromSeqNo, toSeqNo);
    }
            if (ex instanceof AlreadyClosedException == false && documentIndexWriter.getTragicException() == null) {
        return throttle.isThrottled();  
    @Override
                            try {
        protected OpenSearchDirectoryReader refreshIfNeeded(OpenSearchDirectoryReader referenceToRefresh) throws IOException {
                    op.uid(),  
    private final AtomicBoolean trackTranslogLocation = new AtomicBoolean(false);
                final IndexResult indexResult;
                        );  
            engineConfig.getThreadPool().generic().execute(new AbstractRunnable() {
     * @param flushThresholdBytes  uncommitted segment bytes at or above which to flush, resolved by the publisher  
import java.util.concurrent.locks.ReentrantLock;  
                    assert index.origin() == Operation.Origin.PRIMARY : index.origin();  
                noOpResult = new NoOpResult(
                idFieldVisitor.reset();
        }
    /**  
        localCheckpointTracker.advanceMaxSeqNo(seqNo);
        return primaryOperationPolicy.planDelete(deletionStrategyPlanner, delete);  
                            && !(indexResult.getFailure() instanceof AppendOnlyIndexOperationRetryException)) {  
import java.util.concurrent.CountDownLatch;
        } catch (IOException e) {  
    public InternalEngine(EngineConfig engineConfig, TranslogEventListener translogEventListener) {
                    }
    protected final TranslogManager translogManager;  
                .mergeScheduler(mergeScheduler)  
                    versionValue = getVersionFromMap(get.uid().bytes());  
                : "Either the write lock must be held or the engine must be currently be failing itself";
     */
import org.apache.lucene.search.Query;
    }  
        return refreshed;
                } else if (op.seqNo() == docAndSeqNo.seqNo) {
    @Override
        public void accept(OpenSearchDirectoryReader reader, OpenSearchDirectoryReader previousReader) {  
                fromSeqNo,
                            versionMap.putIndexUnderLock(uid, new IndexVersionValue(null, dv.docVersion(docId), seqNo, primaryTerm));  
            final Scorer scorer = weight.scorer(leaf);
         *  
        if (relaxIfGapInSeqNo && localCheckpointTracker.getProcessedCheckpoint() < maxSeqNoOfUpdates) {
        );  
                        delete.uid(),
                    refresh("unsafe_version_map", SearcherScope.INTERNAL, true);
                markSeqNoAsSeen(noOp.seqNo());
     */
     * Fetch the latest {@link SegmentInfos} from the current ReaderManager's active DirectoryReader.
                        delete.version(),
    public boolean isThrottled() {
                        flush(false, true);  
        } catch (Exception e) {
            engineConfig.getTranslogFactory(),  
                         * Document level failures when adding a no-op are unexpected, we likely hit something fatal such as the Lucene
        return false;
     * @throws IOException
                maybeFailEngine(FORCE_MERGE, e);  
/*
        return new GatedCloseable<>(safeCommit, () -> releaseIndexCommit(safeCommit));
                        // free up transient disk usage of the (presumably biggish) segments that were just merged  
            try (ReleasableLock lock = writeLock.acquire(); Releasable ignored = documentIndexWriter.obtainWriteLockOnAllMap();) {
    // incoming indexing ops to a single thread:
        if (shouldFlushOnUncommittedSegmentBytes()) {  
        if (combinedDeletionPolicy.releaseCommit(snapshot)) {  
    private final boolean isContextAwareEnabled;  
                 * not used anyway
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {  
                    maybeFailEngine("index id[" + index.id() + "] origin[" + index.origin() + "] seq#[" + index.seqNo() + "]", e);  
            internalReaderManager.maybeRefreshBlocking();
    public void writeIndexingBuffer() throws EngineException {
        }  
import org.opensearch.index.mapper.IdFieldMapper;  
    public int fillSeqNoGaps(long primaryTerm) throws IOException {  
    public GatedCloseable<IndexCommit> acquireLastIndexCommit(final boolean flushFirst) throws EngineException {
                Releasable indexThrottle = doThrottle ? throttle.acquireThrottle() : () -> {}
            internalReaderManager.addListener(documentIndexWriter);
                closeInternal();
            final SegmentInfos infos = Lucene.readSegmentInfos(safeCommit);  
import org.opensearch.index.translog.Translog;
                    }
        } catch (AlreadyClosedException e) {
                            hasUncommittedChanges,  
            final NoOpResult noOpResult;
        for (Map.Entry<String, Long> file : localSegmentsSizeMap.entrySet()) {
                    assert localCheckpointTracker.hasProcessed(op.seqNo()) || segRepEnabled  
import org.apache.lucene.index.IndexWriterConfig;  
                            index.origin(),
             * If assertions are enabled, IndexWriter throws AssertionError on commit if any files don't exist, but tests that randomly
    public void refreshPrimaryOperationPolicy() {
                IOUtils.closeWhileHandlingException(writer, translogManagerRef, internalReaderManager, externalReaderManager, scheduler);
        index.parsedDoc().version().setLongValue(plan.version);
import org.apache.lucene.index.LeafReaderContext;
                assert assertMaxSeqNoOfUpdatesIsAdvanced(index.uid(), index.seqNo(), true, true);  
            && versionValue.isDelete()  
            if (plan.addStaleOpToEngine) {  
    /**
         */
        // TODO Check if need to check for isOpen for other IndexWriters as well
                logger.trace("acquired flush lock immediately");
    @Override
                    }
                } catch (AlreadyClosedException ex) {  
                if (op instanceof Index) {
            indexWriter.addDocuments(docs, uid);  
        int count = throttleRequestCount.incrementAndGet();  
                documentIndexWriter = writer;
            // the setting will be re-interpreted if it's set to true  
    }
                            versionValue.seqNo,
    protected boolean assertPrimaryIncomingSequenceNumber(final Engine.Operation.Origin origin, final long seqNo) {
import org.opensearch.index.translog.InternalTranslogManager;
        return Optional.empty();
            && current.committedInfosGeneration == committedInfos.getGeneration();
    /**
            int maxNumMerges = mergeScheduler.getMaxMergeCount();
                        }
        softDeletesPolicy.setRetentionOperations(softDeletesRetentionOps);  
import java.util.List;  
                };  
        final Throwable writerTragicException = documentIndexWriter.getTragicException();  
            assert versionValue.term == primaryTerm : "primary term not matched; id="
                    } catch (final Exception ex) {
            return reference.getRefCount();
        } catch (final Exception ex) {  
    /**
                    }
    @Override
