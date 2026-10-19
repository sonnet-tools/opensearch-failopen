                rm.close();  
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {  
            TranslogOperationHelper.create(engineConfig)
                localCheckpointTracker.markSeqNoAsPersisted(indexResult.getSeqNo());
                maxUnsafeAutoIdTimestamp::get,
    /** {@inheritDoc} Always returns {@code true} — a refresh is always considered needed. */
                    close();  
        versionMap.pruneTombstones(maxTimestampToPrune, localCheckpointTracker.getProcessedCheckpoint());  
                    unpublishedDeletes.set(true);
    @Override
        ensureOpen();
     * set of segments.
    @Override  
     * <p>Gated by {@code index.check_pending_flush.enabled} setting.
                throw new AssertionError(  
 * @opensearch.experimental  
        assert count >= 1 : "invalid post-increment throttleRequestCount=" + count;
                    refresh("unsafe_version_map");  
                        shardId.getIndex(),
            shouldFreeze = false;
    @Override  
    public long getPersistedLocalCheckpoint() {
        return null;
                }
     * @throws IOException if flush or close fails
@ExperimentalApi
                            // recovery  
                    // Notify stats cache that flush completed to refresh committed state
                                : "max seq no in commit data must be >= -1";  
     */  
        // sequence number should not be set when operation origin is primary
                    translogManager.rollTranslogGeneration();
                + id
            @Override
                translogManager.trimUnreferencedTranslogFiles();
            try {  
     * <p>  
                            translogManager.ensureCanFlush();  
            pruneDeletedTombstones();
        return mergeScheduler.stats();  
    private static void ensureDefaultPrimaryOperationPolicy(EngineConfig engineConfig) {  
            // 3. Create TranslogManager
            }  
                    inner.addSuppressed(failure);
     * Delegates get-by-id to the installed {@link DocumentLookupProvider}, acquiring a
                    } else {
    public void refresh(String source) throws EngineException {
 * compatible open source license.
            }  
            } else {  
import org.opensearch.common.lucene.uid.Versions;
                        try {  
    private final TranslogManager translogManager;  
     * destroys all writers — memory reporting drops to 0 immediately on close, so there are  
                if (writerPool.isRegistered(lockedWriter)) {  
        }
                            )  
                    location = translogManager.add(new Translog.Index(index, indexResult));  
                            // Refresh must not lose existing segments beyond those fully deleted (dropped).
                            get.id(),
                                result.refreshedSegments().size(),
    }
        try {
     */
     * soft-delete tracking. Caller must hold either the readLock or the writeLock.
    }
            this.refreshListeners.add(this.lastRefreshedCheckpointListener);  
     * delegates to the {@link IndexingExecutionEngine#refresh} to incorporate segments,
                }  
                return statsWithoutFileSizes;
        } else {
     * Idempotent and thread-safe — a no-op if already frozen. The atomic {@code compareAndSet}
    @Override
            final Translog.Location location;
     * Acquires a reference to the current catalog snapshot for reading segment metadata.
        VersionType versionType,  
            this.mergeScheduler = new MergeScheduler(mergeHandler, this::applyMergeChanges, () -> {
     * Returns whether any merges are queued but not yet started. DFA primary delegates
     * Lock-free no-op: marks the seqNo as seen + processed and (when not from translog)  
                        location = null;  
            // Unrecognized tiering-state value — treat as not frozen, but surface the misconfiguration.
                    IOUtils.closeWhileHandlingException(holder.get());  
            pendingWritersToClose.add(writerToFlush);  
import org.opensearch.index.mapper.IdFieldMapper;
    public void maybePruneDeletes() {
                        );  
        long version,
    public long getMinRetainedSeqNo() {
            )
            DeleteResult deleteResult = deleteExecutionEngine.deleteDocument(  
     * @return a translog snapshot
    public Engine.Delete prepareDelete(  
        GatedCloseable<CatalogSnapshot> snapshotRef = catalogSnapshotManager.acquireSnapshot();
                pendingSegments.add(retiredSegment);
     * @param ifPrimaryTerm the conditional primary term  
    }  
                );
     * appended when the op originated outside the translog itself.  
            @Override
                failEngine("Merge failed while registering merged files in Snapshot", ex);
                            }  
    }  
                            indexResult.getSeqNo(),
            }));  
                        final long flushAllElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - flushAllStartNanos);  
        String source,
     * @param seqNo         the sequence number ({@code UNASSIGNED_SEQ_NO} for primary)  
            failEngine("flush failed during preIndex for writer gen=" + writerToFlush.generation(), e);  
            localCheckpointTracker,
            try (ReleasableLock lock = writeLock.acquire()) {
                fileDeleter,
     */
                    "could not apply buffered deletes while retiring writer generation [" + writer.generation() + "]",  
                unpublishedDeletes.set(true);
            // then transfers to applyMergeChanges, which releases the lock after the catalog  
                        Writer<?> pendingWriter;
    }
    /**
 */
        return localCheckpointTracker.getProcessedCheckpoint();
                    new Translog.NoOp(deleteResult.getSeqNo(), delete.primaryTerm(), deleteResult.getFailure().toString())
                refreshLock.unlock();  
                Writer<?> queuedWriter;  
                // Invariant: writerCheckedOut ⇒ writer no longer registered in the pool.  
    private final DocumentLookupProvider documentLookupProvider;
                        new DeleteInput(IdFieldMapper.NAME, index.id(), currentWriter.generation()),
    private final ReleasableLock writeLock = new ReleasableLock(rwl.writeLock());
import org.apache.logging.log4j.Logger;
    /** Chooses the primary or local recovery/reset deletion plan. */
                mergeScheduler.freeze();
     * is still deferred.
        VersionValue versionValue = getVersionFromMap(op.uid().bytes());
        this.maxSeqNoOfUpdatesOrDeletes.updateAndGet(curr -> Math.max(curr, maxSeqNoOfUpdatesOnPrimary));
            // ends by committing the post-merge snapshot, which registers a reader for it, so liveness
import org.apache.lucene.index.IndexCommit;  
    private final AtomicLong maxSeqNoOfUpdatesOrDeletes;
                            get.versionType().explainConflictForReads(versionValue.version, get.version())  
                try {  
                committedSnapshots,
     */
                        // Refresh thread drains the queue itself (it's not idle — it does work)
        return indexResult;
                }
     * Also resets the auto-ID timestamp optimization if disabled.  
    @SuppressWarnings({ "unchecked", "rawtypes" })
     */
                                result.droppedGenerations().size()
    }
        final Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(id));  
                this::incrementVersionLookup
import static org.opensearch.index.engine.Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID;
        }
                currentWriter
    }
                            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(localCheckpointTracker.getMaxSeqNo()));
                engineConfig.getIndexSettings(),
                                // If the catalog snapshot changed during the flush, this will ensure the latest one  
                                    writerToFlush.generation(),
        // (segment-rep) and warm-tier shards must use a read-only engine instead — fail
                deleteExecutionEngine.createDeleter(writer);
                maybeFailEngine("delete", e);
    }  
    }
                flushLock.lock();  
     *
        return statsCache.getSegments();
     * Detects tiering state transitions and freezes/unfreezes the engine accordingly.
        } catch (RuntimeException | IOException e) {
                // First get active writes as active writes are only reduced after catalog snapshot refresh
                    }  
            refreshListener.beforeRefresh();
            // so acquiring refreshLock via the hook establishes the same refreshLock → IW
     * Fails the engine with the given reason and optional exception. Acquires the fail
            "acquireSafeIndexCommit is not supported on DataFormatAwareEngine; use acquireSafeCatalogSnapshot instead"
                        this.activeFlushLatch = null;
import org.opensearch.common.logging.Loggers;  
 *   <li>Translog management for durability and recovery</li>
        return historyUUID;  
                    + engineConfig.isReadOnlyReplica()
            return translogManager.shouldPeriodicallyFlush(
                Writer<?> w = h.get();  
    public long currentOngoingRefreshCheckpoint() {
    public GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException {
        }  
            throw new EngineCreationFailureException(shardId, "failed to create engine", e);  
                delete.primaryTerm(),
        }
                                catalogSnapshotManager.updateLastCommitInfo(commitResult);  
                for (var holder : writerPool.checkoutAll()) {
        maybePruneDeletes();  
                } finally {
    /**
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            // self-rollback, or PENDING_ROLLBACK awaiting CompositeWriter rollback). Anything thrown
            : DocumentMetadataResolver.NOOP;
    }
                    logger.trace(
            maxUnsafeAutoIdTimestamp.updateAndGet(curr -> Math.max(curr, newTimestamp));
                    throw e;  
            // Restore version map and checkpoint tracker after recovery.
                }  
            finalizeDelete(delete, deleteResult);
                    store.decRef();
    }
            }
    @Override  
     *  
    /** {@inheritDoc} Deactivates write throttling when merge pressure subsides. */
                        maxGenFromCommit = Math.max(maxGenFromCommit, seg.generation());
     * @throws IllegalStateException if global checkpoint does not match max seq no
                        indexResult = indexIntoEngine(index, plan);  
     * the event listener.
import org.opensearch.common.concurrent.GatedCloseable;  
    private void flushActiveTranslogBatches() {  
            this.readers = readers;  
            throw new RuntimeException(e);  
            if (flushLock.tryLock() == false) {
        // Location is deferred inside a PendingLocation held by the version-map entry. The batch's flush() assigns the
        } catch (IOException e) {
                        List<Segment> newSegments = new ArrayList<>();
            ensureOpen();
        try {
     * <ul>
            } catch (Exception e) {
    @Override
                // Hold refreshLock across the whole flush so a concurrent refresh cannot advance  
     * @param versionType              the version type
    }
     * Registers a listener that fires when all in-flight merges have completed.  
    public long getMaxSeenAutoIdTimestamp() {
import org.opensearch.index.engine.dataformat.FlushInput;  
            } finally {  
            try (GatedCloseable<Reader> readerRef = acquireReader()) {
                    // over-claim those ops, so a subsequent recovery/relocation would start replay
                            index.seqNo(),
            throw ioException;
import org.opensearch.common.lease.Releasable;
     * @param force       if {@code true}, forces a flush even if not strictly needed
import org.opensearch.index.engine.exec.LiveDocsSource;
                engineConfig.getIndexSettings().getMergePolicy(true),
    @Override
            return readers.get(format);
            if (get.realtime()) {
        activeBatch.set(batch);
import org.opensearch.index.merge.MergeStats;
     * is at most the processed checkpoint (the single trimming strategy used by {@code InternalEngine}, correct  
                SegmentsStats statsWithoutFileSizes = new SegmentsStats();  
        public DataFormatAwareReader(GatedCloseable<CatalogSnapshot> snapshotRef, Map<DataFormat, Object> readers) {
     * Only freezes for HOT_TO_WARM (actual data migration in progress).
    @Override  
                            flushAllElapsedMs
    // Sequence number tracking
                    refreshListener.afterRefresh(true);
    /**  
    private final Lock flushLock = new ReentrantLock();
            || index.origin() == Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY
import org.opensearch.index.mapper.Uid;
            try {  
        this.documentLookupProvider = engineConfig.getDocumentLookupProvider();
                final IndexVersionValue.PendingLocation pending = new IndexVersionValue.PendingLocation(batch);
            this.snapshotRef = snapshotRef;
            );
        // Safety net for AlreadyClosedException caught mid-refresh / mid-flush — e.g., a
            this.writerGenerationCounter = new AtomicLong(maxGenFromCommit);
                exceptions.add(e);
         * @param format the data format
                final IndexingStrategy plan;
                lastWriteNanos = index.startTime();  
                    // durably contains, mirroring Lucene's InternalEngine.commitIndexWriter (which
    private final LiveVersionMap versionMap;
    /** Flushes the engine with default parameters (non-forced, wait if ongoing). */
        }
    /**
            }  
                ex.addSuppressed(inner);
                    }
                Segment retiredSegment = segBuilder.build();
                    List<DocumentLookupResult> docs = documentLookupProvider.getDocsAboveSeqNo(
     * pending readers exceptionally and rethrows it at {@code finish()}, and {@code maybeFailEngine} has already been
        } finally {
    private void onTranslogBatchFinished(TranslogBatchScope batch) {  
                    statsCache.onFlushCompleted();  
     *
import org.opensearch.index.translog.TranslogCorruptedException;
 *   <li>Soft-deletes policy for peer-recovery retention</li>  
        return prepareDelete(id, null, seqNo, primaryTerm, version, versionType, origin, ifSeqNo, ifPrimaryTerm);
                            : "new segments must have unique generations";
            refreshListeners.addAll(engineConfig.getExternalRefreshListener());
                            Committer.CommitResult commitResult = committer.commit(
                + primaryTerm
            || index.origin() == Engine.Operation.Origin.LOCAL_RESET)
            try {
                                    + " dropped "
                        && (get.getIfSeqNo() != versionValue.seqNo || get.getIfPrimaryTerm() != versionValue.term)) {
            uid,
                statsWithoutFileSizes.addIndexWriterMemoryInBytes(cachedStats.getIndexWriterMemoryInBytes());
    /**
import org.opensearch.index.engine.dataformat.FileInfos;
import org.opensearch.index.engine.exec.Indexer;
    }  
                    + index.seqNo()
            Segment.Builder segBuilder = Segment.builder(writer.generation());
            if (holder.get() == writer) {  
        long seqNo,  
                    + engineConfig.getIndexSettings().isWarmIndex()
            // 2. Read translogUUID and history UUID from last committed data
            @Override
                maybeFailEngine("flush", e);
import java.util.concurrent.atomic.AtomicInteger;
        try (ReleasableLock ignored = readLock.acquire(); Releasable ignored2 = versionMap.acquireLock(delete.uid().bytes())) {
                writerCheckedOut = retireWriterIfNeeded(lockedWriter);
        if (engineConfig.getIndexSettings().isCheckPendingFlushEnabled() == false) {
                        index = new Engine.Index(  
     * constructed from the id via {@link Uid#encodeId}.  
import org.opensearch.index.engine.dataformat.Writer;  
        }
    }
            || engineConfig.getIndexSettings().isRemoteStoreEnabled() == false  
            for (Map.Entry<DataFormat, EngineReaderManager<?>> entry : readerManagers.entrySet()) {
        }
                                || compareOpToVersionMapOnSeqNo(
                    if (get.versionType().isVersionConflictForReads(versionValue.version, get.version())) {
    private final CountDownLatch closedLatch = new CountDownLatch(1);
        return versionMap.getUnderLock(id);
            }
            int count = 0;
            throw new IllegalStateException(  
    @Override  
            } catch (IOException e) {
            indexResult.setTook(System.nanoTime() - index.startTime());
    /** {@inheritDoc} Activates write throttling when merge pressure increases. */  
    protected volatile long lastDeleteVersionPruneTimeMSec;  
     * Unfreeze logic covers both cancel (HOT_TO_WARM → HOT) and prepare failure
            return failOnTragicEvent((AlreadyClosedException) e);
                            translogManager.trimUnreferencedReaders();  
                                Segment.Builder segmentBuilder = Segment.builder(writerToFlush.generation());
            }  
                long gen = writerGenerationCounter.incrementAndGet();
                                deletesApplied |= deleteExecutionEngine.onWriterCheckedOut(retiringWriter.generation());
     * engine lock to ensure only one failure is recorded. Closes the engine and notifies  
                statsWithoutFileSizes.addVersionMapMemoryInBytes(cachedStats.getVersionMapMemoryInBytes() + deleteRamBytes);  
        if (plan.executeOpOnEngine == false && plan.addStaleOpToEngine == false) {
                                Translog.Index index = (Translog.Index) operation;  
            Map<DataFormat, Object> readers = new HashMap<>();
            index.parsedDoc().getDocumentInput().addField(engineConfig.getMapperService().fieldType(VersionFieldMapper.NAME), plan.version);
                    writerPool.releaseAndUnlock(lockedWriter);
import org.opensearch.common.queue.LockablePool;
                engineConfig.getShardId(),
            if (deleteResult.getResultType() == Engine.Result.Type.SUCCESS) {  
    // Segments flushed inline outside refresh — by indexing threads (preIndex cooperative drain)  
                filesListeners,
            }
    private final AtomicBoolean unpublishedDeletes = new AtomicBoolean();
    }
            } finally {
            assert delete.origin().isFromTranslog() || deleteResult.getSeqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO;
                    logger.warn("Failed to get last committed data for stats cache", e);
            refreshListeners.addAll(engineConfig.getInternalRefreshListener());  
                } else {
    public MergeStats getMergeStats() {
        if (upgrade || upgradeOnlyAncientSegments || onlyExpungeDeletes) {  
                        }
        );  
                // Fall back to 0 on error  
    public EngineConfig config() {
        }
                deleteResult = (Engine.DeleteResult) plan.earlyResultOnPreFlightError.get();
    @Override  
        if (delete.origin() == Engine.Operation.Origin.PRIMARY) {
                }
                } else {
                indexingExecutionEngine.getMerger(),
    @Override  
import org.opensearch.index.translog.TranslogException;
import org.opensearch.index.get.DocumentLookupResult;
import java.util.concurrent.ConcurrentLinkedQueue;  
        }
                                .stream()  
            logger.debug("Pluggable dataformat merge is disabled via system property [{}], skipping merge", MERGE_ENABLED_PROPERTY);
    /**  
            refreshLock.lock();  
    }  
        long expectedRows = filesMap.values().iterator().next().numRows();
                        index.uid().bytes(),
    private boolean isFrozenForTiering() {  
    }  
        return throttle.getThrottleTimeInMillis();
    // Lifecycle
    private final Store store;
            if (documentLookupProvider != null) {
            WriteResult result = currentWriter.addDoc(index.parsedDoc().getDocumentInput());  
            throw e;  
     */  
import org.opensearch.index.engine.dataformat.merge.MergeScheduler;  
        }
    private void notifyRefreshListenersAfter(boolean didRefresh) throws IOException {
            );
    public long getProcessedLocalCheckpoint() {  
                            newSegments.size(),  
                }
     * is a programming error.  
                    if (refreshed || deletesApplied) {  
     *
        this.documentLookup = new DocumentLookupSupport(shardId, this.documentLookupProvider, this.documentMetadataResolver);  
    }  
                    }
        }
            // in a merge, its committer wires the hook into a MergedSegmentWarmer that fires
    }
                        throw new VersionConflictEngineException(
    }
            );  
        long mappingVersion = currentMappingVersion();  
                    }
     * @param fromSeqNo   the starting sequence number (inclusive)
            .getSettings()  
            deletionPolicy,
        ParsedDocument doc = docMapper.getDocumentMapper().parse(source, indexingExecutionEngine.newDocumentInput());
    private final AtomicLong maxSeenAutoIdTimestamp = new AtomicLong(-1);
                    + indexResult.getSeqNo()
                    config().getMapperService(),  
     * Constructs a DataFormatBasedEngine.
        } else if (failedEngine.get() == null && isClosed.get() == false) {  
            engineConfig.getTranslogConfig(),
                            index.version(),
    // force every operation represented by a segment into the translog before publishing that segment.
            // A merge replaces segments and drops rows that were hidden by a delete or an update, so
     * <p>  
                            // Commit data must contain all keys required for recovery
            if (result instanceof WriteResult.Success) {
    @Override
            logger.info("Engine explicitly frozen for tiering by prepare action");  
                                    index.version(),  
     * @param accurateCount     unused
    /**
            );
            statsWithDeleteBytes.add(cachedStats);  
            }
        }
                } catch (AlreadyClosedException ex) {  
    /** Returns the store. Visible for testing only. */
package org.opensearch.index.engine;
                            new IOException(  
        }
                        }
                }  
    private final DocumentCountTracker documentCountTracker;
                try (GatedCloseable<Reader> readerRef = acquireReader()) {  
    /**
                    );  
     * reported via ramBytesUsed while they're being written to disk), here refresh closes and
                                pendingRowCount.addAndGet(-rowsToRelease);
    }
                () -> 0L,
                                final long writerFlushStartNanos = System.nanoTime();  
            return;
    @Override
        return 0L;
        } catch (Exception e) {  
    }
     * @param translogRetentionSize  the maximum total size for translog files  
        }  
    }
            failEngine("already closed by tragic event on indexing engine", engineTragic);  
    }
                        }
     */
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {
    }
                final Translog.Location location;
public class DataFormatAwareEngine implements Indexer {  
     * has pending writers (put there by the refresh thread), this thread picks one up
        } else {  
        DefaultLockableHolder<Writer<?>> lockedWriter = null;
            assert indexResult.getSeqNo() >= 0 : "indexResult must have assigned seqNo but was: " + indexResult.getSeqNo();  
                        CatalogSnapshot snapshot = snapshotRef.get();
    @Override
                    engineConfig.getEventListener().onFailedEngine(reason, failure);  
            return;
    public void flushAndClose() throws IOException {
                    logger.debug("engine closed [{}]", reason);  
                            assert commitData.containsKey(CatalogSnapshot.CATALOG_SNAPSHOT_KEY) : "commit data missing catalog snapshot";  
        assert seqNo == UNASSIGNED_SEQ_NO : "primary operations must never have an assigned sequence number but was [" + seqNo + "]";
            // the next ordinary refresh.  
            this.refreshListeners.add(this.statsCache);
                try {  
            return;
            }
                                    uid,  
     */
            assert incrementIndexVersionLookup();  
                            : "new segment generation collides with an existing segment generation";
            } catch (AlreadyClosedException e) {
                throw new IllegalStateException(  
        Engine.IndexResult indexResult;  
    /**
                delete.version(),
        TranslogEventListener translogEventListener
        assert writerPool.isRegistered(lockedWriter) == false : "retired writer must not be in pool";
            }  
                generateSeqNoForOperationOnPrimary(delete),  
        try (ReleasableLock ignored = readLock.acquire()) {
            logger.warn(  
                    }
                    assert versionValue.seqNo >= 0 : versionValue;
        long seqNo,  
    private void closeReaders() throws IOException {
            return count;  
                            shardId,  
            batch.flush();  
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {  
    }  
        return writers;  
    private boolean hasBeenProcessedBefore(Engine.Operation op) {  
            try {
    private final String historyUUID;
                        + " rows, expected "
    private static OpVsEngineDocStatus compareOpToVersionMapOnSeqNo(String id, long seqNo, long primaryTerm, VersionValue versionValue) {
                            final long engineRefreshStartNanos = System.nanoTime();
    // Translog for durability and recovery
                VersionValue versionValue;  
            return deletionStrategyPlanner.planOperationAsPrimary(delete);
                                FileInfos fileInfos = writerToFlush.flush(FlushInput.EMPTY);
                    }  
            try {  
                        );
    }  
        return new Engine.Delete(id, uid, seqNo, primaryTerm, version, versionType, origin, startTime, ifSeqNo, ifPrimaryTerm, routing);
     * operations, throttling, translog recording, and local checkpoint tracking.
                        Writer<?> writerToFlush;
        return translogManager.newChangesSnapshot(fromSeqNo, toSeqNo, requiredFullRange);
                                );
                        this.activeFlushLatch = flushLatch;
     * <p>A scope's append failure belongs to the bulk that owns the scope: the scope has recorded it, completed its  
            lastWriteNanos = delete.startTime();  
                                engineRefreshElapsedMs,
    }
            } catch (Exception inner) {
            }
import org.opensearch.index.engine.dataformat.WriteResult;
        awaitPendingClose();
                            index.primaryTerm(),
        }
    @Override
                                    source,  
    private final CatalogSnapshotManager catalogSnapshotManager;
        ensureDefaultPrimaryOperationPolicy(engineConfig);  
        // Pruning walks the deletes map taking a per-uid lock, so it is throttled to once per 1/4 of gcDeletes,
                long insertionRowId = ((RowIdAwareWriter<?>) currentWriter).docCount() - 1;
     * Closing this reader releases the catalog snapshot reference.  
    /**  
                List<CatalogSnapshot> initSnapshots = committer.listCommittedSnapshots();
        // serialise the catalog update against concurrent refreshes. Always release on exit.  
                }
                    return gen;  
                    "Reader for format [" + format.name() + "] is " + reader.getClass().getName() + ", expected " + readerType.getName()
                localCheckpointTracker::getProcessedCheckpoint,  
        } catch (Exception ex) {
    private final Map<DataFormat, EngineReaderManager<?>> readerManagers;  
            DeleteResult.Failure f = (DeleteResult.Failure) deleteResult;
     * Acquires all writers from the pool, flushes each to produce per-format file sets,
                                    new IndexVersionValue(null, doc.version(), doc.seqNo(), doc.primaryTerm())
                e.addSuppressed(inner);  
                    if (failure != null && Lucene.isCorruptionException(failure)) {
    }
    @Override  
                            "refresh[{}]: flushed {} writers producing {} new segments in [{}ms]",  
            while (snapshot.next() != null) {  
    private void awaitPendingClose() {
        return store;
        this.versionMap = new LiveVersionMap();
                }
        Map<DataFormat, WriterFileSet> filesMap = retiredFileInfos.writerFilesMap();
            this.lastRefreshedCheckpointListener = new LastRefreshedCheckpointListener(localCheckpointTracker);
                long docsIngested = pendingRowCount.get();  
            MergeHandler mergeHandler = new MergeHandler(  
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;  
        return new TranslogEventListener() {  
        }
            );
            }
        Writer<?> writerToFlush = flushQueue.poll();  
    }
            logger.trace("preIndex: check pending flush disabled, skipping");  
            // between mergeMiddle and commitMerge — the IndexWriter monitor is not held there,  
                            assert commitData.containsKey(Translog.TRANSLOG_UUID_KEY) : "commit data missing translog UUID";
                new DeleteVersionValue(
                            plan.currentNotFoundOrDeleted  
        if (isFrozenForTiering() && index.origin() == Engine.Operation.Origin.PRIMARY) {
        String tieringStateStr = engineConfig.getIndexSettings()  
            }  
    // or by failure-handling retirement (retireWriterIfNeeded). Drained by the next refresh().
        );  
    }
    public void refreshPrimaryOperationPolicy() {  
     * live-settings fallback also returns true for a shard opened mid-tiering (restart/relocation) —
            engineConfig.getTranslogFactory(),
                logger.info("Freezing engine for tiering — blocking merges, refresh, flush, and catalog commits");  
     * @param ifSeqNo       the conditional sequence number
            // document, since UpdateHelper rebuilds the index request from the get's seqNo) was
     * (frozen-while-HOT → HOT) to ensure merge scheduler resumes.  
     *
     */
            }  
    }  
        long startTime = System.nanoTime();  
    /**
            final DeletionStrategy plan = planDelete(delete);
    public Engine.DeleteResult delete(Engine.Delete delete) throws IOException {
                            index.origin(),  
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {  
        return deletionStrategyPlanner.planOperationAsNonPrimary(delete);  
            Map<String, FilesListener> filesListeners = new HashMap<>();  
                logger.debug(() -> new ParameterizedMessage("[{}] batched translog append failed while draining", shardId), e);
            );  
        this.documentMetadataResolver = engineConfig.getDocumentMetadataResolver() != null  
            updateAutoIdTimestamp(Long.MAX_VALUE, true);
    @Override
    }  
    // Writers that have been flushed inline but not yet closed. Their Lucene temp
                            throw new EngineException(shardId, "failed to read operation from translog", e);
                            index.id(),
    /**
import org.opensearch.index.engine.dataformat.merge.MergeFailedEngineException;
                        List<Segment> existingSegments = catalogSnapshot.get().getSegments();  
    }
            if (rows != expectedRows) {
                config().getShardId(),
                    // current writer buffer into the catalog snapshot; any operation processed
        @SuppressWarnings("unchecked")
    }  
            if (readerType.isInstance(reader) == false) {
     */
                            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(committedLocalCheckpoint));  
     *
                }
        for (DefaultLockableHolder<Writer<?>> holder : writerPool) {  
    }  
        }
                    IndexVersionValue.withPendingLocation(pending, indexResult.getVersion(), index.seqNo(), index.primaryTerm())  
                // A pre-flight failure (version conflict) never issued a sequence number.
                ),
        return catalogSnapshotManager.acquireCommittedSnapshot(false);  
    }  
                            final long engineRefreshElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - engineRefreshStartNanos);
        flush(false, true);
                    assert indexResult.getResultType() == Engine.Result.Type.FAILURE : indexResult.getResultType();  
    }  
     * @param origin        the operation origin
     * write — keeping the indexing hot path free of cross-component state checks.
    public Translog.Snapshot newChangesSnapshot(  
     * Flushes the engine and then closes it. If the engine is already closed, the flush
            return OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
    @Override
     *   <li>{@link #triggerPossibleMerges()} becomes a no-op</li>
                // Stop accepting new merges immediately
     * after flush and remote sync are complete, just before the state transitions to HOT_TO_WARM.  
     * <p>  
                this::acquireSnapshot,
                        while ((pendingSeg = pendingSegments.poll()) != null) {
        assert rwl.getReadHoldCount() > 0 || rwl.isWriteLockedByCurrentThread() : "innerNoOp requires a read or write lock";
     * @param version       the expected version
            throw e;
                }  
    private final ThreadLocal<TranslogBatchScope> activeBatch = new ThreadLocal<>();
        final TranslogBatchScope batch = activeBatch.get();
     */
                        );  
                        );
        for (Map.Entry<DataFormat, WriterFileSet> entry : filesMap.entrySet()) {  
     * Builds an {@link Engine.Delete} operation for the given document id. The {@code _id} term is
    ) {
    private final LastRefreshedCheckpointListener lastRefreshedCheckpointListener;
    public int fillSeqNoGaps(long primaryTerm) throws IOException {
                            index.primaryTerm()  
    }  
     * Determines whether a periodic flush is needed based on translog size relative  
    @Override
                    throw new TranslogException(shardId, "failed to trim translog on sync", ex);
    /**
import org.opensearch.index.engine.exec.EngineReaderManager;  
     * @param index the index operation containing the parsed document, version, and origin
            } catch (IOException deleteEx) {
                throw e;  
        public <R> R getReader(DataFormat format, Class<R> readerType) {  
     *
    private void applyMergeChanges(MergeResult mergeResult, OneMerge oneMerge) {  
                    + engineConfig.getShardId()
            if (reader == null) {
        refresh(source);
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
    @Override  
        numVersionLookups.inc();
        } else {  
            IOException ioException = new IOException("Failed to close DataFormatAwareEngine resources");  
                        while (flushLatch.getCount() > 0) {
                                if (hasFiles) {
     * <p>
            }  
                );
    }
            if (plan.earlyResultOnPreFlightError.isPresent()) {  
        if (engineTragic != null) {
            throw new MergeFailedEngineException(shardId, ex);  
            return statsWithDeleteBytes;
    private final AtomicBoolean frozenForTiering = new AtomicBoolean(false);
                }
            return;  
                : "translog-origin op should not have a translog location";
    @Override
                engineConfig.getIndexSettings().getTranslogRetentionTotalFiles()
    private final ShardId shardId;
                        }
            // Fall through: read from parquet. Resolved through DocumentLookupSupport#getById,
            // The batch owns processed-checkpoint advancement (on flush) and persisted-checkpoint advancement (on the
            return;
                                if (flushLatch.await(1, TimeUnit.SECONDS) == false) {  
                        documentMetadataResolver
        }
            return false;
            for (ReferenceManager.RefreshListener refreshListener : refreshListeners) {  
                            // is a thread that has written its row to the writer but not yet called batch.add; the
    @Override  
    private final ConcurrentLinkedQueue<Writer<?>> flushQueue = new ConcurrentLinkedQueue<>();
            pruneDeletedTombstones();  
     * If merges are already drained, fires the listener immediately inline.
        }
                throw new FlushFailedEngineException(shardId, e);  
    }
 *
     * A catalog-snapshot-backed data-format aware reader providing per-format reader access.
                            index.startTime(),
    }
        if (versionMap.isUnsafe()) {  
                    if (get.isReadFromTranslog() && versionValue.getLocation() != null) {
            refreshListener.afterRefresh(didRefresh);
            engineConfig.getGlobalCheckpointSupplier(),  
    @Override
            primaryTerm,
     * @return a gated closeable wrapping the catalog snapshot
        // A scope opened against a closed engine would only fail at its first append with the same
            } else if (deleteResult.getSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {
     * is still blocked. (Requests already past this guard are drained separately by the prepare  
        // In DFAE, all segments are tracked in the catalog snapshot regardless of load state — no distinction exists.  
            if (writerPool.isRegistered(lockedWriter)) {
                try (var cs = catalogSnapshotManager.acquireSnapshot()) {
            } finally {  
                    index.uid().bytes(),
    }
        }
                                newSegments.size(),  
     * the operation or return an early result (e.g., for version conflicts). For replica
 * This engine manages the full lifecycle of indexing,
        TranslogDeletionPolicy deletionPolicy,  
            try {  
     * the last merge finishes.  
        }  
                shardId
 * <p>
            // checkpoint-publishing listeners must not be notified. We invoke only the
                        committer.markStoreCorrupted(
    private final CounterMetric numVersionLookups = new CounterMetric();
                            flushQueue.add(lockable.get());
                mergeScheduler.unfreeze();  
        boolean deferred = false;  
                hasFiles = true;
        return false;
            return new Engine.DeleteResult(f.cause(), plan.version, delete.primaryTerm(), delete.seqNo(), false);
            // RETIRED_FLUSHABLE: flush the buffered N-1 docs. A throw here loses those acked
    @Override  
                "wait_if_ongoing must be true for a force flush: force=" + force + " wait_if_ongoing=" + waitIfOngoing
            || engineConfig.getIndexSettings().isSegRepEnabledOrRemoteNode() == false) {
     * Defaults to "false" (merges disabled) as the merge implementations are not yet complete
        } catch (AlreadyClosedException ex) {
                rows = plan.reservedDocs;
     * @throws IOException if closing any resource fails  
            .getSettings()
            ensureOpen();
        }
    }  
                                final long writerFlushElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - writerFlushStartNanos);
                                // has the commit format.
        return indexingExecutionEngine.getHeapBytesUsed() + deleteExecutionEngine.ramBytesUsed();
     * @throws IOException if reading the translog fails
        long ifPrimaryTerm  
        this.refreshListeners = refreshListeners;
                }  
                failOnTragicEvent(e);
                        + "] has "  
import org.opensearch.common.queue.DefaultLockableHolder;
import java.util.Collections;  
        }  
        DocumentMapperForType docMapper,  
        }
    }
            return Engine.NO_OP_TRANSLOG_BATCH;  
     * <p>
            }
     */
            ensureOpen();  
import org.opensearch.index.translog.InternalTranslogManager;  
        this.shardId = engineConfig.getShardId();
            }  
         *
    /** Force every live bulk scope to append its current chunk before publishing a catalog snapshot. */
        assert (index.origin() == Engine.Operation.Origin.PRIMARY  
    @Override
        this.store = engineConfig.getStore();  
                        flushActiveBatchBeforeInlineWrite();
            // which applies read-time version/if_seq_no conflicts to the result — the realtime  
    /**
                            commitData.put(Translog.TRANSLOG_UUID_KEY, translogManager.getTranslogUUID());
            throw new IllegalStateException("a translog batch is already active on this bulk thread");  
                SegmentsStats stats = statsCache.buildSegmentsStats(
     * @throws IOException if reading the translog fails  
            flush(false, true);
            // doc counts and per-segment stats change even though no checkpoint moved. applyMergeResults  
    /**
                ex.addSuppressed(inner);  
    /**
                () -> {  
     * failure is the owning request's to report, and the drainer carries on with the remaining scopes. Whether the
                        + expectedRows  
                    documentCountTracker.releaseInFlightDocs(rows);
            this.translogManager = translogManagerRef;  
                pendingSegments.clear();
                    indexResult = (Engine.IndexResult) plan.earlyResultOnPreFlightError.get();
                return indexIntoEngine(index, plan);  
                this.versionMap,  
                flushLock.unlock();
                    logger.trace("flush completed");  
import org.opensearch.index.engine.dataformat.merge.DataFormatAwareMergePolicy;  
        }
        return versionValue;
                }
     * Indexes a document into the engine. Handles sequence number assignment for primary
                            .noneMatch(ns -> existingSegments.stream().anyMatch(es -> es.generation() == ns.generation()))  
            } catch (Exception inner) {  
    /**
                || indexResult.getTranslogLocation() != null : "successful non-translog-origin op must have a translog location";
         * @param <R> the reader type
     *
            throw new AlreadyClosedException(shardId + " engine is closed", failedEngine.get());
                        } catch (IOException e) {  
        numIndexVersionsLookups.inc();  
    @Override  
    private Engine.DeleteResult executeDeletePlan(Engine.Delete delete, DeletionStrategy plan) throws IOException {  
     *   <li>Primary indexing operations are rejected with "frozen for tiering"</li>
            ensureOpen();  
import org.opensearch.index.engine.exec.commit.CommitterConfig;
        // includeUnloadedSegments is a Lucene concept (segments on disk not yet loaded into a SegmentReader).
     * Otherwise, the listener will fire on the merge thread when
    @ExperimentalApi
        // merges, or Lucene merges that skip because the shared writer has no matching segments),
        final PrimaryOperationPolicy policy = engineConfig.getPrimaryOperationPolicy();
                            );  
        assert op.seqNo() != UNASSIGNED_SEQ_NO : "operation is not assigned seq_no";
        }  
    private VersionValue getVersionFromMap(BytesRef id) {
            } else {
    }
import org.opensearch.index.engine.dataformat.RefreshResult;  
            for (Exception e : exceptions) {
     */
        if (policy != DefaultPrimaryOperationPolicy.INSTANCE) {
     * Throws {@link UnsupportedOperationException} if no plugin is wired.
        if (activeBatch.get() == batch) {
    }  
    private void notifyRefreshListenersBefore() throws IOException {
        Engine.Operation.Origin origin,
import org.opensearch.index.translog.TranslogDeletionPolicy;  
     * Acquires a {@link DataFormatAwareReader} on the latest catalog snapshot.
        }  
            return SeqNoGapFiller.fillGaps(localCheckpointTracker, translogManager, primaryTerm, noOp -> innerNoOp(noOp));
                                    doc.seqNo(),
                            catalogSnapshotManager.commitNewSnapshot(finalSegments);  
                store.shardPath(),
        WriterState postState = writer.state();  
    }  
import org.opensearch.common.Booleans;
            );
            assert catalogSnapshotManager != null : "catalog snapshot manager must be initialized";
                lookupResult = documentLookupProvider.getVersionMetadata(op.id(), reader, shardId.getIndex(), documentMetadataResolver);
                Object reader = entry.getValue().getReader(catalogSnapshot);  
                        long rowsToRelease = 0L;
            return true;
            // with a prior primary's uploads for the same shard. See method Javadoc for rationale.
     *
            shardId,
        }
     *
    @Override
            assert versionValue.term == primaryTerm : "primary term not matched; id="  
                        int writerCount = writers.size();
                            index.primaryTerm(),
                                } else if (writerToFlush instanceof RowIdAwareWriter<?> rowIdAwareWriter) {  
                stats.addVersionMapMemoryInBytes(deleteExecutionEngine.ramBytesUsed());  
     */
                assert indexResult.getSeqNo() == index.seqNo() : "IndexResult seq no ["
     * @param autoGeneratedIdTimestamp the auto-generated ID timestamp
    private final MergeScheduler mergeScheduler;
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException {
            SegmentsStats statsWithDeleteBytes = new SegmentsStats();
                this::resolveDocVersion,  
                // Close any writers queued for deferred close (their files won't reach the catalog)
        return lastRefreshedCheckpointListener.lastRefreshedCheckpoint();  
        throws IOException {  
                            // A writer can be flushed while its bulk still owns deferred translog entries. Append every
        Objects.requireNonNull(versionValue);
    private void updateTieringFreezeState() {
            this.documentCountTracker = new DocumentCountTracker(shardId, () -> {  
                mergeScheduler.shutdown();
        if (noOp.origin().isFromTranslog() == false) {  
            this.statsCache = new CatalogSnapshotStatsCache(catalogSnapshotManager, store, engineConfig, () -> {  
    }  
                        }
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
                        );
                delete = generateSeqNoForDelete(delete);
    @Override
     * @param version                  the expected version
    /**
                        store.decRef();
                                for (Map.Entry<DataFormat, WriterFileSet> entry : fileInfos.writerFilesMap().entrySet()) {  
                            generateSeqNoForOperationOnPrimary(index),  
            // applyMergeChanges acquires refreshLock itself. Either way, applyMergeChanges  
            this.deletionStrategyPlanner = new DeletionStrategyPlanner(
        if (delete.origin() == Engine.Operation.Origin.PRIMARY) {  
                IOUtils.close(deleteExecutionEngine, indexingExecutionEngine, committer, translogManager);
 *
            synchronized (versionMap) {
import org.apache.lucene.store.AlreadyClosedException;  
                        assert newSegments.stream()
                    translogManager.trimUnreferencedReaders();
    // Concurrency locks
        mergeScheduler.refreshConfig();
import java.util.Map;
            FileInfos retiredFileInfos;
            return new GatedCloseable<>(reader, reader::close);  
        // AlreadyClosedException; refuse it up front so the bulk is retried on the new primary without doing any work.  
                return null;  
                delete.getIfSeqNo(),  
import org.opensearch.index.engine.exec.PrimaryTermFieldType;  
import java.util.concurrent.TimeUnit;
    @Override
            refreshLock.unlock();
                        triggerPossibleMerges(); // trigger merges  
        return supplier.apply(seqNoStats.maxSeqNo, seqNoStats.localCheckpoint);
            snapshotRef.close();
    ) {
            : "DataFormatAwareEngine only supports PRIMARY, LOCAL_TRANSLOG_RECOVERY, or LOCAL_RESET origins but got: " + delete.origin();  
     * Returns true if the engine is frozen for tiering and the operation should be blocked.
            return innerNoOp(noOp);
                    engineConfig.getThreadPool().relativeTimeInMillis()  
    boolean isWriterRegistered(Writer<?> writer) {
            }
    /** No-op — data-format engines do not maintain Lucene-style delete tombstones. */
            throw new AlreadyClosedException(shardId + " engine is closed", engineTragic);
                                    + result.droppedGenerations().size()  
            }
                            snapshotRef.markSuccess();
                try {
                    + engineConfig.getShardId()  
                        }
            Translog.Location location = translogManager.add(new Translog.NoOp(noOp.seqNo(), noOp.primaryTerm(), noOp.reason()));
     * Set in three places: the constructor (freeze-on-open when a shard opens mid-tiering),  
            // Create and register stats cache as refresh listener
                            Map<String, String> commitData = new HashMap<>();
        }
                Segment.Builder segmentBuilder = Segment.builder(writerToFlush.generation());
            ensureOpen();
     * its Lucene add and its translog add.
                        );
     * @return the active merge count, or 0 if no merges are running  
    private boolean retireWriterIfNeeded(DefaultLockableHolder<Writer<?>> lockedWriter) {
                WriteResult.Failure f = (WriteResult.Failure) result;  
    public void freezeForTiering() {  
     * could throw, so on throw the caller can still safely flag it as checked-out.
     * @param listener the callback to fire when merges are drained
                if (reader.catalogSnapshot().getSegments().isEmpty()) {
    private final AtomicLong pendingRowCount = new AtomicLong();
                    indexingExecutionEngine.getDataFormat(),
import org.opensearch.index.translog.Translog;
                );
                } catch (IOException ex) {  
    ) {
                } finally {
                        assert index.seqNo() >= 0 : "recovery or replica ops should have an assigned seq no.; origin: " + index.origin();
     * Deletes a document using primary planning or local recovery/reset semantics, then updates
            this::ensureOpen,
    private boolean maybeFailEngine(String source, Exception e) {
        }
    }
        if (acquiredHere) {
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
                } else if (indexResult.getSeqNo() != UNASSIGNED_SEQ_NO
        @Override  
     * @return the prepared delete operation
            startTime,
     * {@code onlyExpungeDeletes} operations since those are Lucene-specific concepts not
        final long maxTimestampToPrune = timeMSec - engineConfig.getIndexSettings().getGcDeletesInMillis();
    }  
     * Parses the source document using the document mapper and creates an {@link Engine.Index}
                            if (refreshed) {  
                            indexResult.getFailure().toString()
            try (
        } else {  
                if (versionMap.isUnsafe()) {
        return catalogSnapshotManager.acquireCommittedSnapshot(true);  
            engineConfig.getIndexSettings().getTranslogBatchAppendMaxOperations(),
            CombinedCatalogSnapshotDeletionPolicy combinedPolicy = new CombinedCatalogSnapshotDeletionPolicy(
        localCheckpointTracker.advanceMaxSeqNo(seqNo);
                logger.warn("failed to close engine resources", e);
    private Engine.NoOpResult innerNoOp(Engine.NoOp noOp) throws IOException {
        }
        assert count >= 0 : "invalid post-decrement throttleRequestCount=" + count;
                                    + shardId;
    // Merge  
        }
            }
        }
        return new InternalTranslogManager(  
                e  
                        while ((pendingWriter = pendingWritersToClose.poll()) != null) {
            failEngine("tragic event on indexing engine", engineTragic);  
            engineConfig.getPrimaryTermSupplier(),
            List<CatalogSnapshot> committedSnapshots = committer.listCommittedSnapshots();  
import org.opensearch.index.IndexModule;  
            catalogSnapshotManager.applyMergeResults(mergeResult, oneMerge);
     *
                        return Engine.GetResult.NOT_EXISTS;  
                            flushLatch.countDown();
        if (Lucene.isCorruptionException(e)) {  
                    catalogSnapshotManager.incrementUnreferencedFileCleanUps();
        }  
        int reservedDocs = 0;  
                try {
            documentCountTracker.releaseInFlightDocs(reservedDocs);
 * this file be licensed under the Apache-2.0 license or a
    }  
            FileDeleter fileDeleter = indexingExecutionEngine::deleteFiles;
                    segmentBuilder.addSearchableFiles(entry.getKey(), entry.getValue());
                        // so the refresh thread can wait for ALL writers to be flushed
                }  
    // Shared queue of writers pending flush. Populated by refresh (checkoutAll),  
     * @param waitIfOngoing if {@code true}, waits for an in-progress flush to complete
    private final ConcurrentLinkedQueue<Segment> pendingSegments = new ConcurrentLinkedQueue<>();
     * <p>
                }
                new IndexingEngineConfig(
     */  
    // The scope used by the current bulk thread. Active scopes are also registered globally so refresh/commit can  
            );
                }
    public SafeCommitInfo getSafeCommitInfo() {
    // -- Visible for testing --
    /**
                if (store.tryIncRef()) {  
        };
    }
            }
        // Replicas use a separate engine (analogous to NRTReplicationEngine) that consumes segments.
    }
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
        logger.trace("recovered max_seq_no [{}] and local_checkpoint [{}]", seqNoStats.maxSeqNo, seqNoStats.localCheckpoint);
        // Fast path - return precomputed segments from cache  
        }
        // the warmer never fires and the lock is not held on entry; acquire it locally to
        return localCheckpointTracker.generateSeqNo();  
        try (ReleasableLock ignored = writeLock.acquire()) {
    @Override  
     * commits a new catalog snapshot, and notifies reader managers so they can open  
            custom,  
            this.indexingExecutionEngine = registry.getIndexingEngine(  
     * is created via the indexing execution engine's {@code newDocumentInput()} method.
        }
                                    Segment segment = segmentBuilder.build();  
                    }  
            Thread.currentThread().interrupt();  
     *
            maybeFailEngine("index id[" + index.id() + "] origin[" + index.origin() + "]", e);
                    for (DocumentLookupResult doc : docs) {
                    registry,  
 *   <li>Throttling when merges fall behind or indexing buffer is full</li>
import java.util.concurrent.ConcurrentHashMap;
            this.catalogSnapshotManager = new CatalogSnapshotManager(
            }  
        );  
                    for (Segment seg : initSnapshots.getLast().getSegments()) {
                engineConfig.getIndexSettings().getTranslogRetentionSize().getBytes(),
        refresh("write indexing buffer");
    public long unreferencedFileCleanUpsPerformed() {  
        try {
                batch.flush();  
     */
                            final VersionValue curr = versionMap.getUnderLock(uid);  
                            try {
            throw e;  
        // source of an ACE reaching this catch.  
                deferred = true;
            if (latch != null) {
                    plan.version,  
        assert operation.origin() == Engine.Operation.Origin.PRIMARY;  
            final Map<String, String> userData = committer.getLastCommittedData();  
     * @throws IllegalArgumentException if {@code force} is true but {@code waitIfOngoing} is false
                // Discard any pending segments not yet picked up by refresh  
        } catch (IOException e) {
    private LocalCheckpointTracker createLocalCheckpointTracker(BiFunction<Long, Long, LocalCheckpointTracker> supplier)
        if (docMapper.getMapping() != null) {
            assert localCheckpointTracker != null : "local checkpoint tracker must be initialized";  
                assert gen > 0 : "writer generation must be positive but was: " + gen;
                && (engineConfig.getThreadPool().relativeTimeInMillis()  
        }  
                            } catch (Exception e) {
                return indexResult;
        final TranslogDeletionPolicy translogDeletionPolicy = translogManager.getDeletionPolicy();  
                                    + " for shard: "  
        boolean refreshed = false;
            () -> localCheckpointTracker,
    }
        }  
import org.opensearch.index.mapper.SeqNoFieldMapper;  
            }
    }
                            get.getIfPrimaryTerm(),  
                delete.startTime(),
     * Begin a remote-store translog batch for the current bulk execution. Local-store composite indexes and all  
            return OpVsEngineDocStatus.OP_NEWER;
        if (engineConfig.isEnableGcDeletes()
    private final DeletionStrategyPlanner deletionStrategyPlanner;  
        }
import java.util.concurrent.locks.ReentrantReadWriteLock;
    /** Returns whether the writer is registered in the pool. Visible for testing only. */  
     * {@link #onSettingsChanged} has not yet flipped the flag, so a request arriving in that window
     * @param primaryTerm              the primary term  
     * snapshot reference.  
     * @return {@code true} if the translog exceeds the flush threshold  
                for (TranslogBatchScope batch : activeBatches) {
     *  
                        // commit only if last committed CS id is different from the one we are about to commit or if force param is true
                if (plan.earlyResultOnPreFlightError.isPresent()) {  
                logger.warn("failEngine threw exception", inner);  
     * — throws {@link IllegalStateException} so the caller can {@link #failEngine} and let
                    logger.warn(() -> new ParameterizedMessage("tried to fail engine but already failed, ignoring. [{}]", reason), failure);
                    );
                }
        // data available to read on internal refreshes on replica.  
    /** Returns the writers in the pool. Visible for testing only. */  
            // We will pass IndexStoreProvider to this, which would contain store
        }
        }
    @Override
                                org.opensearch.ExceptionsHelper.unwrapCorruption(failure)
                }
import org.opensearch.common.metrics.CounterMetric;  
                    return;  
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {  
        long toSeqNo,  
import org.opensearch.index.engine.dataformat.RefreshInput;
        return statsCache.getDocsStats();  
                            ensureOpen(); // short-circuit if engine has failed/closed concurrently
                return DefaultLockableHolder.of(new RowIdAwareWriter<>(writer));
    private void updateAutoIdTimestamp(long newTimestamp, boolean unsafe) {
                                assert rowsToRelease > 0L : "Rows to release from active writes should be greater than 0 but was: "
                Reader reader = readerRef.get();  
        if (postState == WriterState.ACTIVE) {
        // Fast path - return precomputed stats from cache
                                source,  
     * @param ifSeqNo                  the conditional sequence number  
        ensureOpen();
        } catch (RuntimeException | IOException e) {
        }  
            try {
        boolean deletesApplied = false;
                                    + result.refreshedSegments().size();
 *   <li>Refresh to make documents searchable via catalog snapshots</li>  
     */
                final Engine.IndexResult indexResult;
     * @param id            the document id to delete
            for (ReferenceManager.RefreshListener refreshListener : refreshListeners) {  
        private final Map<DataFormat, Object> readers;
                // This prevents under-accounting
    private volatile long lastWriteNanos = System.nanoTime();  
            } finally {
    @Override  
    // directories must remain on disk until refresh incorporates them via addIndexes.
    private final CounterMetric numIndexVersionsLookups = new CounterMetric();  
        ensureOpen();  
        Exception engineTragic = indexingExecutionEngine.getTragicException();
    @Override
        }
                new DeleteInput(IdFieldMapper.NAME, delete.id(), currentWriter.generation()),
import org.opensearch.index.mapper.SourceToParse;
                        assert newSegments.stream().allMatch(s -> s.dfGroupedSearchableFiles().isEmpty() == false)
            // WriteResult.Failure with the writer's state already reconciled (ACTIVE after a
import java.util.Objects;
                    // After failEngine, the engine must be in a closed state
    }  
            deleteResult.setTranslogLocation(location);
                        writerToFlush.generation(),  
        boolean upgradeOnlyAncientSegments,  
    public TranslogManager translogManager() {  
    }
    /**
            public void onAfterTranslogRecovery() {  
            assert indexResult.getSeqNo() >= 0 : "indexResult must have assigned seqNo but was: " + indexResult.getSeqNo();
                op -> OpVsEngineDocStatus.OP_NEWER,
    @Override  
                            source,
import org.opensearch.index.engine.dataformat.merge.OneMerge;
        try (ReleasableLock ignored = readLock.acquire()) {
                        }
                versionValue = null;
            return new Engine.DeleteResult(plan.version, delete.primaryTerm(), delete.seqNo(), plan.currentlyDeleted == false);
                            }  
                }
            }
     * @throws EngineException if the flush fails  
    public void ensureOpen() {
            // Bump catalog generation on engine open so uploads from this primary do not collide
                                        "Writer gen={} flushed format=[{}] files={}",
    /**
        }  
                throw new IllegalStateException(
        if (isFrozenForTiering()) {
        }
     * TODO: Remove this flag once merge implementations are complete for all data formats.
    }
                            RefreshResult result = indexingExecutionEngine.refresh(refreshInput);
            return snapshotRef.get();  
     * @param failure the exception that caused the failure, or {@code null}
                    versionValue = getVersionFromMap(get.uid().bytes());
                    engineConfig.getIndexSettings()
        ensureOpen();
            // can be read here. Without this the stats cache would keep serving pre-merge numbers until
                    if (versionValue.isDelete()) {
        } catch (InterruptedException e) {
    @Override
        boolean flush,
     * Set to "true" to enable merges (e.g., {@code -Dopensearch.pluggable.dataformat.merge.enabled=true}).
        return engineConfig;  
            || engineConfig.getIndexSettings().isRemoteTranslogStoreEnabled() == false
     * precedes the delete of the same document) whichever path the caller took.
    /**
            }, LinkedList::new, Runtime.getRuntime().availableProcessors());  
     */
            writers.add(holder.get());
            }, indexingExecutionEngine.maxIndexableDocs());
                            if (curr == null
        result.freeze();  
        try {
        mergeScheduler.triggerMerges();
    }
    IndexingExecutionEngine<?, ?> getIndexingExecutionEngine() {
            if (deleteExecutionEngine.onWriterCheckedOut(writerToFlush.generation())) {  
            final long localCheckpointOfLastCommit = Long.parseLong(
    public long getNativeBytesUsed() {
 * underlying data format engine and the translog.  
            // monitor ordering that the refresh path uses and avoids lock inversion. Ownership
        for (DefaultLockableHolder<Writer<?>> holder : writerPool) {
import org.opensearch.index.mapper.VersionFieldMapper;  
            // Create Reader managers
            }
    }
    public long lastRefreshedCheckpoint() {
                    return;
            List<CatalogSnapshotLifecycleListener> snapshotListeners = new ArrayList<>();
                closeReaders();  
                } finally {
    public int getActiveMergeCount() {  
        }  
            return (R) reader;
            // is updated. For merges that do not invoke the hook — pure Parquet merges, or
            // Merge failure cleanup: cleans up unreferenced files and acts as a safety net
                || indexResult.getResultType() != Engine.Result.Type.SUCCESS  
                + " seq_no="
            ifSeqNo,
            }  
            DataFormatAwareReader reader = new DataFormatAwareReader(snapshotRef, readers);
                        if (force || lastCommittedSnapshotId == null || snapshot.getId() != Long.parseLong(lastCommittedSnapshotId)) {  
     * @return the prepared index operation
    @Override
        return failedEngine.get();
                if (isClosed.get() == false) {
    }  
            || delete.origin() == Engine.Operation.Origin.LOCAL_RESET
            // 6. Create CombinedCatalogSnapshotDeletionPolicy  
}  
                // map so once we pass this point we can safely lookup from the version map.
                    refresh("flush");
        }
                                }
            isRetry,
        long version,
                            toClose.add(pendingWriter);  
                                    Map.of()  
    }
        if (isClosed.get() == false) {
                // Close writers still in the flush queue (checked out of pool, not yet flushed).
    private volatile CountDownLatch activeFlushLatch;  
     * Explicitly freezes the engine for tiering. Called by {@code TransportPrepareTieringAction}
        Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id()));
        try (Releasable ignored = writerPool.checkout(lockedWriter)) {
                            // pending chunk before publishing the segments so that, for every row whose bulk thread has  
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;
            try {
        }  
        }
    }
            result.setTranslogLocation(location);
            );  
import org.opensearch.plugins.DocumentLookupProvider;  
        TranslogDeletionPolicy custom = null;  
                            assert snapshot.getId() >= 0 : "snapshot ID must be non-negative but was: " + snapshot.getId();
import org.opensearch.core.index.AppendOnlyIndexOperationRetryException;
                    committer,
    private final ReentrantLock refreshLock = new ReentrantLock();  
                    assert index.origin() == Engine.Operation.Origin.PRIMARY : index.origin();
                            get.getIfSeqNo(),
            assert writerPool != null : "writer pool must be initialized";
                        final BytesRef uid = new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())).bytes();
        int rows = 0;
                                );
    }
    }
            ) {
    private final Logger logger;
                        "Writer gen={} flushed format=[{}] files={}",
    public CompletionStats completionStats(String... fieldNamePatterns) {
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
     */
        return catalogSnapshotManager.serializeToCommitFormat(catalogSnapshot);
        assert oneMerge != null : "oneMerge must not be null";
                refreshLock.lock();
    public long getLastWriteNanos() {
            // docs; surface as IllegalStateException so the caller fails the engine for recovery.  
            );
    /** {@inheritDoc} Delegates to {@link #refresh(String)} and always returns {@code true}. */
     * @param primaryTerm   the primary term
                location = translogManager.add(new Translog.Delete(delete, deleteResult));
                            : "new segments must have at least one format's files";
    public void forceMerge(
        String id,
                    "flush failed retiring writer generation [" + writer.generation() + "]; buffered acked docs lost",  
    /**  
        // merge: the Lucene committer's MergedSegmentWarmer acquires it between mergeMiddle and
                            // We do an additional commit on engine start due to no catalog snapshot present in earlier commit during empty
                indexResult = new Engine.IndexResult(plan.version, index.primaryTerm(), index.seqNo(), plan.currentNotFoundOrDeleted);  
        logger.debug("refresh[{}]: total time to make documents searchable [{}ms] refreshed={}", source, totalRefreshElapsedMs, refreshed);
            final TranslogDeletionPolicy translogDeletionPolicy = getTranslogDeletionPolicy();  
        if (isClosed.get()) {  
        if (engineConfig.getCustomTranslogDeletionPolicyFactory() != null) {
     */
    // drained cooperatively by both the refresh thread and write threads (backpressure).
            }
    public long getMaxSeqNoOfUpdatesOrDeletes() {
            logger.trace("created new DataFormatBasedEngine");
                notifyRefreshListenersAfter(refreshed || deletesApplied);
import org.opensearch.common.lucene.Lucene;
                    // Persist the latest catalog snapshot so it survives restart  
    /**
            // Drain deletes and remove tracking before publishing the retired segment.
import java.io.IOException;
            if (engineConfig.isEnableGcDeletes()
                    failOnTragicEvent((AlreadyClosedException) ex);
                    }
            } catch (Exception e) {
                    // snapshot. Committing the live (post-refresh) processed checkpoint would
            .get(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name());
                    refreshListener.beforeRefresh();
     * closing the index. Throws if they diverge, indicating uncommitted operations.  
                    + "] (readOnlyReplica="
                failedEngine.set(failure != null ? failure : new IllegalStateException(reason));
            throw new UnsupportedOperationException("getById not supported: no DocumentLookupProvider installed");
     * updated readers.
            Object reader = readers.get(format);
                    // Delegate corruption marking to the committer (same as Engine.java's intent)  
     * </ul>  
                    + "] must match operation seq no ["  
        assert newTimestamp >= -1 : "invalid timestamp [" + newTimestamp + "]";
    public String getHistoryUUID() {
     * When {@code true}, tiering-sensitive operations are blocked: primary index ops, merges,
                        location = translogManager.add(new Translog.NoOp(noOp.seqNo(), noOp.primaryTerm(), noOp.reason()));
        }
                                    + " but got "
            failEngine(source, e);  
            final TranslogEventListener translogEventListener = createInternalTranslogEventListener();
            ensureNoTragicException();
    }  
        return deleteResult;
                        // Every new segment must contain files from at least one data format  
        } finally {  
     * the flush work cooperatively.  
        try (ReleasableLock ignored = readLock.acquire()) {
            DataFormatAwareMergePolicy dataFormatAwareMergePolicy = new DataFormatAwareMergePolicy(  
                    logger.warn(() -> new ParameterizedMessage("failed engine [{}]", reason), failure);
            throw e;  
     */
                                "refresh[{}]: indexingExecutionEngine.refresh took [{}ms] "
     * Appends every live bulk scope's pending chunk so that a refresh or flush publishes no row whose translog record  
            }
            logger.warn(
                e  
                        // Use active polling so we detect engine close/failure promptly
                            versionValue.seqNo,
                        // Add all checked-out writers to the shared flushQueue with a latch
    public void activateThrottling() {
import org.opensearch.index.translog.TranslogOperationHelper;  
                for (Map.Entry<DataFormat, WriterFileSet> entry : fileInfos.writerFilesMap().entrySet()) {  
        SourceToParse source,
            } else {  
                            assert commitData.containsKey(SequenceNumbers.MAX_SEQ_NO) : "commit data missing max seq no";  
            this.readerManagers = indexingExecutionEngine.buildReaderManager(
import java.util.Set;
            );  
     * appends a Translog.NoOp. No tombstone is written — DataFormatAwareEngine has no
            versionMap.putDeleteUnderLock(  
     */
                    if (plan.executeOpOnEngine) {
                            commitData.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, snapshot.serializeToString());  
                CatalogSnapshot snapshot = snapshotRef.get();
        final long localCheckpointBeforeRefresh = localCheckpointTracker.getProcessedCheckpoint();  
        } else if (e != null && translogManager.getTragicExceptionIfClosed() == e) {
            statsCache.forceRefresh();
        }
    /**
                }  
            localCheckpointTracker.markSeqNoAsPersisted(deleteResult.getSeqNo());  
                pendingRowCount.incrementAndGet();
        if (globalCheckpoint != maxSeqNo) {
                            index.getAutoGeneratedIdTimestamp(),  
            );  
        lastDeleteVersionPruneTimeMSec = timeMSec;
        );  
        }
                                // Any new snapshots created post this should track this commit info.
import org.opensearch.index.shard.DocsStats;
    // Closed after refresh completes.  
                    } else {
        localCheckpointTracker.markSeqNoAsProcessed(deleteResult.getSeqNo());  
import org.opensearch.index.engine.exec.FileDeleter;
                    versionMap.maybePutIndexUnderLock(
            // 5. Create IndexingExecutionEngine and ReaderManagers  
        throws IOException {
     */  
     * seen and processed so the local checkpoint advances, and a {@link Translog.NoOp} is
            assert index.primaryTerm() > 0 : "primaryTerm must be positive but was: " + index.primaryTerm();
        return true;
import org.opensearch.index.seqno.LocalCheckpointTracker;
    /** Assigns a new primary sequence number or marks a local recovery/reset sequence number as seen. */  
        if (seqNo > versionValue.seqNo) {  
 * SPDX-License-Identifier: Apache-2.0
        // op, defer its translog append into the batch. The version, seqNo and term are already known; only the
        // indexing engine (multiplexes across formats) and the translog: either can be the
        long ifSeqNo,  
                    // Capturing here keeps the committed local checkpoint <= what the snapshot
    /**  
                translogDeletionPolicy,  
        long ifPrimaryTerm
                            translogManager.syncTranslog();
    /**  
                            if (commitResult != null && snapshot instanceof DataformatAwareCatalogSnapshot dfaSnapshot) {
        if (documentLookup.isSupported() == false) {  
        ensureOpen();
                if (indexResult.getResultType() == Engine.Result.Type.SUCCESS) {
            throw new RefreshFailedEngineException(shardId, ex);
            }
                .create(engineConfig.getIndexSettings(), engineConfig.retentionLeasesSupplier());  
                this::hasBeenProcessedBefore,
            }  
    }
                                throw e;
                IOUtils.close(toClose);
                            logger.trace("refresh[{}]: catalogSnapshot commit took [{}ms]", source, commitElapsedMs);
                    // Refresh first to flush buffered data to segments  
                                    true,
        return true;
        return catalogSnapshotManager.getSafeCommitInfo();
        long ifSeqNo,
        return engineConfig.getIndexSettings().getGcDeletesInMillis();  
     * recovery replay the translog. The writer is checked out of the pool before any work that  
     * document — DataFormatAwareEngine has no soft-delete tracking. The seqNo is marked as
    }
    ) throws IOException {  
    public void deactivateThrottling() {  
    // Timestamps and seq-no markers  
                    // concurrently DURING this flush lands in a NEW writer that is not part of this  
     * Updates the retention settings for the translog deletion policy.
import java.util.ArrayList;
                "DataFormatAwareEngine does not support primary operation policy ["
            } else {  
    }  
                    refreshLock.lock();
                // but we only need to do this once since the last operation per ID is to add to the version  
        return catalogSnapshotManager.acquireSnapshot();
    }
     * (locked only for the generation context; no document is added), mapping its {@link DeleteResult}.
            // translog's tragic event (or an AlreadyClosedException over one); otherwise only the request fails.
     * <p>  
                                    index.primaryTerm(),
            // Non-translog-origin successful operations must be recorded in the translog for durability
            ensureOpen();  
import org.opensearch.index.engine.exec.DocumentLookupSupport;
                            }
                            );  
                                .toList();
     *
                statsWithoutFileSizes.updateMaxUnsafeAutoIdTimestamp(cachedStats.getMaxUnsafeAutoIdTimestamp());
     * operation. The parsed document's {@link org.opensearch.index.engine.dataformat.DocumentInput}  
                            index.parsedDoc(),
    @Override  
                        );
    }
                statsWithoutFileSizes.add(cachedStats.getCount());
            ifPrimaryTerm  
        // background merge in a format's underlying writer turns tragic between an entry-time  
                    registry,
                return w.isSchemaMutable() || w.mappingVersion() >= mappingVersion;
            custom = engineConfig.getCustomTranslogDeletionPolicyFactory()
                        // No two new segments may share the same generation  
     * and {@link #freezeForTiering()} (explicitly, from the prepare action). Cleared when the state
     * Verifies cross-format row-count parity on a retired writer's flushed segment.  
                                : "refresh must not lose existing segments; had "  
    /**
     */  
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;  
     */  
    /**
                    assert index.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + index.origin();
                        );
import org.opensearch.index.store.Store;
     * @return a gated closeable wrapping the reader
     * @throws IOException if reader acquisition fails  
        boolean success = false;
        );
    private final DocumentMetadataResolver documentMetadataResolver;
        return maxSeenAutoIdTimestamp.get();
                                "failed engine (reason: [" + reason + "])",
                        }
                            // both cases the operation is unacknowledged until its append and sync complete.
    @Override  
        if (engineConfig.isReadOnlyReplica() || engineConfig.getIndexSettings().isWarmIndex()) {  
        deleteResult.setTook(System.nanoTime() - delete.startTime());
                    store.decRef();
import org.opensearch.core.common.unit.ByteSizeValue;  
    Exception getFailedEngine() {
     * for all data formats.  
                            "Indexing doc id=[{}] seqNo=[{}] primaryTerm=[{}] — writing to engine",  
            } catch (Exception e) {
    public Engine.Index prepareIndex(
    @Override
                    if (index.origin() == Engine.Operation.Origin.PRIMARY) {
import java.util.concurrent.atomic.AtomicLong;
        for (EngineReaderManager<?> rm : readerManagers.values()) {
                                    "refresh[{}]: writer gen={} flush took [{}ms] hasFiles={}",
    public DocsStats docStats() {
        activeBatches.add(batch);
    /** Set when deletes were applied without publishing a segment; the next refresh consumes it to reopen readers. */  
            boolean hasFiles = false;
            if (success == false) {
        return localCheckpointTracker.getStats(globalCheckpoint);
            }  
        Engine.Operation.Origin origin,
            if (lookupResult.version() != Versions.NOT_FOUND) {  
    /**
                assert delete.origin() == Engine.Operation.Origin.PRIMARY : delete.origin();
        if (deferred == false) {  
                    - ((DeleteVersionValue) versionValue).time) > getGcDeletesInMillis()) {
     * @param toSeqNo           the ending sequence number (inclusive)
                            // Now add snapshot to commit data so it has latest snapshot
        }  
                return result.exists() ? result.toGetResult() : Engine.GetResult.NOT_EXISTS;
    }
     * is skipped. Waits for any pending close operations to complete.
        String translogUUID,
            refreshLock.lock();
            maxSeqNoOfUpdatesOrDeletes = new AtomicLong(
                            final long commitStartNanos = System.nanoTime();
            });  
     * candidate selection runs. This guarantees force merge operates on the complete
    Store getStore() {  
        if (flushFirst) {  
            if (documentLookupProvider == null) {  
            FileInfos fileInfos = writerToFlush.flush(FlushInput.EMPTY);  
        return new CompletionStats();
        return IndexModule.TieringState.HOT_TO_WARM.name().equals(state);
    @Override
                            get.id(),
     */
        flushActiveBatchBeforeInlineWrite();
            }
                        lastRefreshedCheckpointListener.updateRefreshedCheckpoint(localCheckpointBeforeRefresh);
                if (plan.useUpdateDocument) {  
    private final IndexingStrategyPlanner indexingStrategyPlanner;
        if (isClosed.get() == false) {
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {
    @Override  
                tieringStateStr  
        // commitMerge to coordinate with refreshes. When Lucene is not a participant (pure-Parquet  
import org.opensearch.index.engine.dataformat.DeleteResult;  
        // verbose is Lucene-specific (RAM tree breakdown per segment) — not applicable to DFAE, ignored.
                    Optional.ofNullable(indexingExecutionEngine.getProvider()),  
            throw new EngineCreationFailureException(  
        try {
            // fail the engine and let recovery replay the translog.
            }  
            try {  
    }
                    batch.abort(closeFailure);  
                }
        return indexingExecutionEngine;  
        // Fallback: read live settings to close the apply-ordering gap described above.
            && engineConfig.getThreadPool().relativeTimeInMillis() - lastDeleteVersionPruneTimeMSec > getGcDeletesInMillis() * 0.25) {
        return localCheckpointTracker.getPersistedCheckpoint();
                                    + existingSegments.size()
            // for refreshLock. The preMergeCommitHook acquires refreshLock on the merge thread;
     * HOT, so there is no separate transient state to freeze on here.
        if (engineConfig.getInternalRefreshListener() != null) {
                            commitData.put(MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, Long.toString(maxUnsafeAutoIdTimestamp.get()));
                                    rowsToRelease += segment.dfGroupedSearchableFiles().values().stream().findFirst().get().numRows();
     * Deletes, no-ops and the no-op recorded for a failed index are written inline. If this bulk thread still holds
            );
            flush(true, true);  
            translogManagerRef = createTranslogManager(translogUUID, translogDeletionPolicy, translogEventListener);
            if (lockedWriter != null) {
                                IOUtils.closeWhileHandlingException(writerToFlush);  
        return catalogSnapshotManager.getUnreferencedFileCleanUpsPerformed();
                    }
            }  
            if (deleteResult instanceof DeleteResult.Success) {
                            assert Long.parseLong(commitData.get(SequenceNumbers.MAX_SEQ_NO)) >= -1
        if (index.origin().isFromTranslog() == false) {
     */  
                "failed to restore version map and local checkpoint tracker",
        if (isClosed.compareAndSet(false, true)) {  
                } catch (IOException e) {  
                if (index.origin() == Engine.Operation.Origin.PRIMARY) {
                            index.getIfPrimaryTerm()  
 * The OpenSearch Contributors require contributions made to  
            }
    @Override  
    private Engine.DeleteResult deleteInEngine(Engine.Delete delete, DeletionStrategy plan) throws IOException {
                if (initSnapshots.isEmpty() == false) {  
                                    hasFiles = true;
                    } else {
            );
                throw new RuntimeException("Failed to release catalog snapshot reference", e);
    private final DeleteExecutionEngine<?> deleteExecutionEngine;
    @Override
                op -> OpVsEngineDocStatus.OP_NEWER,
                while ((queuedWriter = flushQueue.poll()) != null) {
                DocumentLookupResult result = documentLookup.getById(get, readerRef.get());
            // writers (e.g. Lucene MergeIndexWriter) invoke the hook on the merge thread  
                                    curr  
        try (ReleasableLock ignored = readLock.acquire()) {  
                    }
    public CommitStats commitStats() {
     * directly to its {@link MergeScheduler} (orthogonal to active count).  
            translogEventListener,  
            throw ex;
    }
            // immediately before the merged segment becomes visible. When Lucene participates
    }
            Writer<?> currentWriter = lockedWriter.get();
     * @param seqNo                    the sequence number ({@code UNASSIGNED_SEQ_NO} for primary)
            DocumentLookupResult lookupResult;
                    );  
    private void preIndex() {
    @Override  
        }
    /**
            final long deleteRamBytes = deleteExecutionEngine.ramBytesUsed();  
                if (deleteExecutionEngine.onWriterCheckedOut(writer.generation())) {
            try (ReleasableLock lock = writeLock.acquire()) {  
                delete.versionType(),  
                    // Include operations already applied by live bulk scopes in the checkpoint whenever possible. The
         */
        }
 * </ul>
            throw new AssertionError("Unexpected AlreadyClosedException", ex);
        return lastWriteNanos;  
                            // Drop fully-deleted generations so the catalog stays consistent with the reader.
                }  
            localCheckpointTracker.markSeqNoAsProcessed(indexResult.getSeqNo());
                                versionMap.putIndexUnderLock(
            } catch (Exception inner) {
    /**  
                    flushActiveTranslogBatches();
                    // captures the checkpoint before IndexWriter.commit flushes). See  
     * for a failure that is the translog's tragic event (the translog is closed and the engine is failing); any other  
        return result;
        if (deferred == false) {  
                    + "); use a segment-consuming or read-only engine"
    protected VersionValue resolveDocVersion(final Engine.Operation op, boolean loadSeqNo) throws IOException {
                try {  
        if (writerToFlush == null) {
        final long globalCheckpoint = engineConfig.getGlobalCheckpointSupplier().getAsLong();  
            Map<String, String> lastCommitData = committer.getLastCommittedData();  
        this.engineConfig = engineConfig;
import org.opensearch.index.translog.listener.TranslogEventListener;
                    if (refreshLock.isHeldByCurrentThread()) {  
        return mergeScheduler.getActiveMergeCount();
    @Override
                    final long committedLocalCheckpoint = localCheckpointTracker.getProcessedCheckpoint();
        @Override  
    }
        try (Translog.Snapshot snapshot = translogManager.newChangesSnapshot(fromSeqNo, toSeqNumber, false)) {
        final long totalRefreshElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - refreshStartNanos);
                            assert result.refreshedSegments().size() >= existingSegments.size() - result.droppedGenerations().size()
                        markSeqNoAsSeen(index.seqNo());  
        // Soft deletes are not supported yet.  
                        List<DefaultLockableHolder<Writer<?>>> writers = writerPool.checkoutAll();
                filesListeners.put(entry.getKey().name(), entry.getValue());  
            }  
     */
        if (unsafe) {
        return committer.getCommitStats();  
                    } finally {  
            }  
                    config().getIndexSettings(),
                        preIndex();
            IOUtils.closeWhileHandlingException(writerToFlush);
        } else {  
                // Close all writers still in the pool (unflushed writers from the current cycle)
     * @param fromSeqNo         the starting sequence number (inclusive)
    @Override  
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
    private final IndexingExecutionEngine indexingExecutionEngine;
     */
                    maxUnsafeAutoIdTimestamp.get(),  
                    config().getChecksumStrategies()
    protected void pruneDeletedTombstones() {  
    }
                        currentWriter  
                            }
     * @param source a descriptive label for the refresh (e.g., "flush", "write indexing buffer")  
        // the inline markSeqNoAsProcessed / markSeqNoAsPersisted tail below for a deferred op. Deletes and NoOps stay
    public boolean refreshNeeded() {
        flushActiveBatchBeforeInlineWrite();
                    "writer generation [" + writer.generation() + "] retired with inconsistent buffer (state=" + postState + ")"
import org.opensearch.search.suggest.completion.CompletionStats;
    }
     * Routes the planned delete to the {@link DeleteExecutionEngine} under a locked active writer
     * Records a no-op for the given seqNo. Used for failed indexing attempts (so the failed
            failEngine("uncaught exception during indexing id[" + index.id() + "] seq#[" + index.seqNo() + "]", e);
            // the lock is not permanently held.
import org.opensearch.index.engine.dataformat.MergeResult;  
            // Encapsulate refreshLock access behind a pre-merge-commit hook: committer-owned
                    snapshot
            // A merge only swaps segments in the catalog; it does not advance the checkpoint, so  
        maybePruneDeletes();
                        } else if ("flush".equals(source)) {  
                    docsIngested += cs.get().getNumDocs();
                        throw new VersionConflictEngineException(  
                snapshotListeners.add(entry.getValue());
            try {  
                            if (isClosed.get() || failedEngine.get() != null) {
                                Thread.currentThread().interrupt();
                                existingSegments.size(),
        }
        long primaryTerm,
    public byte[] serializeSnapshotToRemoteMetadata(CatalogSnapshot catalogSnapshot) throws IOException {  
    }
                        // Wait for any writers that write threads picked up to finish.
        );
     *
                )
        }  
                logger.info("Unfreezing engine — tiering cancelled, resuming normal operations");
    @Override
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
        if (batch != null) {
     * primary-term bump.
            shouldFreeze = tieringState == IndexModule.TieringState.HOT_TO_WARM;  
                        // Replica and recovery operations must arrive with a pre-assigned sequence number
    }
    private void restoreVersionMapAndCheckpointTracker() {
    }
import java.util.concurrent.CountDownLatch;
     */
                                    continue; // re-check isClosed / failedEngine
                }  
            CountDownLatch latch = activeFlushLatch;  
                    indexingExecutionEngine.getNativeBytesUsed(),
        if (failEngineLock.tryLock()) {
                engineConfig.getIndexSettings().getTranslogRetentionAge().getMillis(),  
        if (count == 1) {
            activeBatch.remove();  
                    IOUtils.closeWhileHandlingException(queuedWriter);
    }
    private DeletionStrategy planDelete(Engine.Delete delete) throws IOException {
    // Throttling
                if (versionValue != null) {
    /**  
    public Engine.IndexResult index(Engine.Index index) throws IOException {
        }  
                    }
            lockedWriter = writerPool.getAndLock(h -> {
        if (count == 0) {  
    private boolean failOnTragicEvent(AlreadyClosedException ex) {
                            commitData.put(Engine.HISTORY_UUID_KEY, historyUUID);  
        Engine.NoOpResult result = new Engine.NoOpResult(noOp.primaryTerm(), noOp.seqNo());
                                    get.id(),
                        }
            () -> new DefaultTranslogDeletionPolicy(
    }
        } else if (seqNo == versionValue.seqNo) {
            try {
     *
        return false;  
                            index.isRetry(),
    /** Applies the deletion plan and records a tombstone for executed operations. */
            long maxGenFromCommit = 0L;  
     * Returns the number of currently active (in-flight) merge tasks.
        if (frozenForTiering.compareAndSet(false, true)) {
        if (isFrozenForTiering()) {  
     * {@link #onSettingsChanged} (when INDEX_TIERING_STATE transitions to HOT_TO_WARM),
     * This method is retained only to satisfy the {@link Engine} contract; calling it on DFA
            indexResult.freeze();
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
        markSeqNoAsSeen(noOp.seqNo());
    /**  
                    flush(false, true);
                flush(false, true);
                                logger.trace(
                    // TODO: Handle file deletion policy
                            // and available to the deletion policy when onCommit is triggered.
            updateAutoIdTimestamp(Long.MAX_VALUE, true);
            ensureOpen();
     *
                        if (refreshed || deletesApplied) {  
                    failEngine("writer retirement could not preserve buffered acked docs", bufferLoss);
            || delete.origin() == Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY
                        entry.getKey().name(),
                assert writerCheckedOut == false || writerPool.isRegistered(lockedWriter) == false
                pendingSegments.add(segmentBuilder.build());  
                                    Map.of(),
                        maybePruneDeletes();
                            if (rowsToRelease > 0L) {
    }  
                    logger.debug("engine already closed - skipping flushAndClose");
            }  
    private final IndexingThrottler throttle;  
                }
                Writer<?> writer = indexingExecutionEngine.createWriter(new WriterConfig(gen));  
            index.parsedDoc().getDocumentInput().addField(engineConfig.getMapperService().fieldType(SeqNoFieldMapper.NAME), index.seqNo());  
import org.opensearch.index.engine.dataformat.DeleteInput;
            this.deleteExecutionEngine = registry.getDeleteExecutionEngine(committer);
                            RefreshInput refreshInput = new RefreshInput(existingSegments, newSegments, nextGen, deletesApplied);  
                    deleteExecutionEngine.deleteDocument(
                logger.warn("Failed to compute segments stats with file sizes, falling back to cached stats", e);  
            );  
                + seqNo  
    @Override
     * @param toSeqNumber the ending sequence number (inclusive)  
            // RemoteStoreRefreshListener so the merged segments get uploaded to the remote store.
        try {
            // 4. Initialize local checkpoint tracker
     * and trimming unreferenced translog files.
    ) throws IOException {
                writerPool.releaseAndUnlock(lockedWriter);
            // Lucene merges that skip because the shared writer has no matching segments —
        // DataFormatAwareEngine is the writable primary-side engine. Read-only replicas  
        // location, marks the seqNo processed, and (via the fsync callback) marks it persisted -- so we must NOT run  
     * Prunes delete tombstones from the version map: those older than one GC-delete cycle whose sequence number
    public void flush() {
                }  
            }
        ensureDefaultPrimaryOperationPolicy(engineConfig);
import org.opensearch.index.engine.exec.Segment;
import java.util.function.BiFunction;  
    @Override
    }
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
        // refreshLock may already be held by the merge thread when Lucene participated in the
            assert committer != null : "committer must be initialized";  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
                activeBatches.clear();
     * action acquiring all primary permits.)
                if (reader != null) {
        if (engineConfig.getIndexSettings().isTranslogBatchAppendEnabled() == false
                        // instead of blocking indefinitely on the latch.  
                return docsIngested;
     */
    public PollingIngestStats pollingIngestStats() {  
        final boolean acquiredHere = refreshLock.isHeldByCurrentThread() == false;
                count++;
        }
            throw new IllegalArgumentException(
        }
            failOnTragicEvent(ex);  
 */  
            for (Map.Entry<DataFormat, EngineReaderManager<?>> entry : readerManagers.entrySet()) {
    private void markSeqNoAsSeen(long seqNo) {  
                    : "writer claimed checked-out but still registered in pool";
     * <p>Unlike {@code InternalEngine.noOp}, this implementation does not write a tombstone  
        return true;
                    // refresh path drains again immediately before catalog publication to close concurrent races.  
            if (frozenForTiering.compareAndSet(true, false)) {
                            }
            this.lastDeleteVersionPruneTimeMSec = engineConfig.getThreadPool().relativeTimeInMillis();
                }  
                                    + rowsToRelease
import org.opensearch.index.mapper.ParsedDocument;
                        logger.debug(
                            index.primaryTerm(),
     * This method is a no-op for {@code upgrade}, {@code upgradeOnlyAncientSegments}, and
            currentWriter.updateMappingVersion(mappingVersion);
                            // Update snapshot userData so deletion policy can read max_seq_no
        assert incrementVersionLookup();  
    public void onMergesDrained(Runnable listener) {
            }  
    private void triggerPossibleMerges() {  
                failEngine("refresh failed source[" + source + "]", ex);
                            catalogSnapshotManager.bumpGeneration();
                            index.getIfSeqNo(),
        mergeScheduler.onDrained(listener);  
    private final DocumentLookupSupport documentLookup;
    }
                    }
            ensureNoTragicException();  
     * index operations in its batch, append them first so the translog keeps request order (an index of a document  
    public Engine.GetResult getById(Engine.Get get, BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory)
     * Always called inside an {@code assert} so the map walk is stripped when assertions are disabled.
     * After this call:
                    }
                    + "]; pluggable data format cannot be combined with a non-default primary operation policy"
        if (delete.origin().isFromTranslog() == false) {
            mergeScheduler.freeze();
    }
        } catch (Exception ex) {
                + " op_term="
            final long persistedCheckpoint = localCheckpointTracker.getPersistedCheckpoint();
    /** {@inheritDoc} Returns the heap RAM bytes used by the indexing execution engine. */
     * snapshot and commit data (translog UUID, sequence numbers), syncing the translog,
            // if the merge fails before applyMergeChanges can release it, this callback ensures  
                // Without this, their LuceneWriter IndexWriter locks remain in LOCK_HELD.
        try {  
        // construction can also appear later. Fail here rather than silently ignoring the policy.
import org.opensearch.index.engine.dataformat.DocumentLocation;
            restoreVersionMapAndCheckpointTracker();
         * @param readerType the expected reader class  
        return batch;  
                                }  
            throttle.activate();  
        assert delete.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + delete.origin();
        long startTime = System.nanoTime();
                            } catch (InterruptedException e) {  
     * operations, the sequence number is marked as seen and the operation proceeds directly.  
import org.opensearch.index.mapper.DocumentMapperForType;  
    }  
        return true;
import org.opensearch.index.VersionType;
        // Deletes need only an active writer for generation context; they do not apply mappings.
                            newSegments.add(pendingSeg);
     * points so a tragic event surfaces on the next maintenance op rather than on a doc  
    @Override
        return doGenerateSeqNoForOperation(operation);
                                : "local checkpoint in commit data must be >= -1";
     *   <li>No new merges will be registered (existing in-flight and pending merges drain to completion)</li>  
        try (GatedCloseable<CatalogSnapshot> oldSnapshotRef = catalogSnapshotManager.acquireSnapshot()) {
                            // stock engine has the same window between the Lucene add and translogManager.add, and in  
                dataFormatAwareMergePolicy,
    private final EngineConfig engineConfig;  
                + versionValue.term;
                indexResult.setTranslogLocation(location);
                                    segmentBuilder.addSearchableFiles(entry.getKey(), entry.getValue());
                try (Releasable ignore = versionMap.acquireLock(get.uid().bytes())) {
            if (batch != null && indexResult.getResultType() == Engine.Result.Type.SUCCESS) {  
        if (engineConfig.isAutoGeneratedIDsOptimizationEnabled() == false) {  
    /** Local checkpoint captured just before the ongoing refresh; parallels {@code InternalEngine}. */  
                }  
        result.setTook(System.nanoTime() - noOp.startTime());
        } else {
            // 7. Create CatalogSnapshotManager (fully wired)
                            if (operation != null) {
                                boolean hasFiles = false;
                if (w.state() != WriterState.ACTIVE) return false;
            // Fast path - return precomputed stats from cache (without file sizes)
            return true;
         * @throws IllegalArgumentException if the reader exists but is not of the expected type  
                                    );  
                if (refreshListener instanceof RemoteStoreRefreshListener) {
    }  
    public long getHeapBytesUsed() {  
                    return Collections.emptyMap();
import org.opensearch.index.engine.dataformat.WriterState;
    }
            }, LiveDocsSource.docCountsResolver(readerManagers.values()), logger);
        // This checks if the settings related to merge are changed and based on that updates the local variables in the class
                } finally {
            for (Map.Entry<DataFormat, WriterFileSet> entry : retiredFileInfos.writerFilesMap().entrySet()) {  
        assert oneMerge.getSegmentsToMerge().isEmpty() == false : "merged segments list must not be empty";  
                        indexResult = new Engine.IndexResult(
        translogDeletionPolicy.setRetentionAgeInMillis(translogRetentionAge.millis());
            return true;
            failEngine("corrupt file (source: [" + source + "])", e);
        long seqNo,
                            if (retiring instanceof Writer<?> retiringWriter) {
        }
     * seqNo is durably recorded), translog replay, and {@link #fillSeqNoGaps} after a  
                                    // Release admitted rows even when a fully deleted generation produces no files.
            if (cachedStats.getFileSizes() != null && cachedStats.getFileSizes().isEmpty() == false) {
                deleteExecutionEngine.recordWrite(index.id(), new DocumentLocation(currentWriter.generation(), insertionRowId));  
            // Track the sequence number  
     * Flushes the engine by refreshing buffered data to segments, persisting the catalog  
            version,
    // Latch for the current refresh cycle — decremented by any thread that flushes a writer.
            assert index.seqNo() >= 0 : "seqNo must be assigned before writing but was: " + index.seqNo();  
            public void onFailure(String reason, Exception ex) {  
                    writerCheckedOut = retireWriterIfNeeded(lockedWriter);
                }
                            long nextGen = newSegments.size() > 1 ? writerGenerationCounter.incrementAndGet() : RefreshInput.NO_GENERATION;
    private void finalizeDelete(Engine.Delete delete, Engine.DeleteResult deleteResult) throws IOException {  
import org.opensearch.index.engine.dataformat.merge.MergeHandler;
                } else {  
                        assert newSegments.stream().map(Segment::generation).distinct().count() == newSegments.size()
        this.throttle = new IndexingThrottler();
    public List<org.opensearch.index.engine.Segment> segments(boolean verbose) {
        if (flush) {
import org.apache.logging.log4j.message.ParameterizedMessage;
    private void flushActiveBatchBeforeInlineWrite() {  
                            flushActiveTranslogBatches();
            } catch (Exception e) {
                );
     * @param isRetry                  whether this is a retry
import org.opensearch.index.engine.exec.commit.Committer;  
        long ifSeqNo,
        VersionType versionType,
        assert operation.seqNo() == UNASSIGNED_SEQ_NO : "ops should not have an assigned seq no. but was: " + operation.seqNo();
    @Nullable  
                            }  
     * Called before each index operation on the write thread. If the shared flush queue  
        Exception engineTragic = indexingExecutionEngine.getTragicException();
     * Returns 0 because DataFormatAwareEngine has no in-flight write state visible to the IMC.  
            translogUUID,
                delete.uid().bytes(),
        long version,
     * Forces a merge to reduce the number of segments to at most {@code maxNumSegments}.
                            commitData.put(  
    @Override
                    );
    public void writeIndexingBuffer() throws EngineException {  
import org.opensearch.index.translog.TranslogManager;
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {
                versionValue = new IndexVersionValue(null, lookupResult.version(), lookupResult.seqNo(), lookupResult.primaryTerm());
     */  
                        localCheckpointTracker.markSeqNoAsPersisted(doc.seqNo());  
            shardId,
     * @param source      a descriptive label for the caller
            this.indexingStrategyPlanner = new IndexingStrategyPlanner(  
     * engine fails must not depend on which thread happened to drain the chunk. The rows of the failed scope are
        } finally {  
                        + rows
            }  
                            rowsToRelease += pendingSeg.dfGroupedSearchableFiles().values().stream().findFirst().get().numRows();  
     * gap on a live engine where the index settings already reflect HOT_TO_WARM but
            // Same decision as a per-operation translog failure in index(): fail the engine only if the exception is the  
                            final List<Segment> finalSegments = result.refreshedSegments()
        }
                    return committer.getLastCommittedData();
    public void failEngine(String reason, @Nullable Exception failure) {
        return true;  
         * Returns the reader for the given format, validated against the expected type.  
                lastCommitData.getOrDefault(SequenceNumbers.LOCAL_CHECKPOINT_KEY, "-1")
     */
                    // DataFormatAwareEngineTests#testFlushMustNotCommitCheckpointAheadOfPersistedSnapshot.
                                .filter(seg -> result.droppedGenerations().contains(seg.generation()) == false)
                )  
            if (hasFiles) {
                Writer<?> pendingWriter;  
                this::hasBeenProcessedBefore,
                if (refreshLock.isHeldByCurrentThread() == false) {  
        ensureOpen();
    }  
import org.opensearch.index.engine.exec.WriterFileSet;
            if (currentWriter.state() != WriterState.ACTIVE) {  
    private long currentMappingVersion() {
                            assert commitData.containsKey(SequenceNumbers.LOCAL_CHECKPOINT_KEY) : "commit data missing local checkpoint";
                retiredFileInfos = writer.flush(FlushInput.EMPTY);  
        return Objects.requireNonNullElseGet(
    @Override
            // releases the lock before returning.
            }
     * @param source            a descriptive label for the caller  
                }  
    private final AtomicBoolean isClosed = new AtomicBoolean(false);  
    boolean assertPrimaryIncomingSequenceNumber(final Engine.Operation.Origin origin, final long seqNo) {  
                        Segment pendingSeg;  
        } catch (IOException | TranslogCorruptedException e) {
            // 1. Create Committer (uses translogPath for safe bootstrap trimming)
                        try (Releasable ignored = versionMap.acquireLock(uid)) {
                }
                            snapshot.setUserData(commitData, true);  
            assert rwl.isWriteLockedByCurrentThread() || failEngineLock.isHeldByCurrentThread()
    public GatedCloseable<Reader> acquireReader() throws IOException {
import org.opensearch.index.engine.exec.FilesListener;
     * DFA callers MUST use {@link #acquireSafeCatalogSnapshot()} — that API avoids the extra
    private long generateSeqNoForOperationOnPrimary(final Engine.Operation operation) {
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
    private final ReleasableLock readLock = new ReleasableLock(rwl.readLock());  
    /** Returns the indexing execution engine. Visible for testing only. */
                    // flush-on-retire threw). Fail the engine so recovery replays the translog.
    @Override  
                IOUtils.closeWhileHandlingException(translogManagerRef);  
                + " existing_term="  
            }  
        if (exceptions.isEmpty() == false) {
        Writer<?> writer = lockedWriter.get();
            throw new IllegalStateException(
                            );  
                            }
            }
                            }  
        public void close() {
                documentCountTracker::tryAcquireInFlightDocs
            this.catalogSnapshotManager.bumpGeneration();  
    private final AtomicInteger throttleRequestCount = new AtomicInteger();
        // inline (handled by the non-deferred branch and by delete()).
        }
        // A plugin can key its policy off an updatable setting, so the combination this engine rejects at
    }  
                    assert isClosed.get() : "engine must be closed after failEngine";  
                    return null;
                    // Capture the processed checkpoint BEFORE refreshing. The refresh persists the
                            final long commitElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - commitStartNanos);
                                    doc.primaryTerm(),
            }
    }
        } // readLock
        if (translogManager.getTragicExceptionIfClosed() != null) {  
        boolean shouldFreeze;  
                // Create a copy without file sizes when includeSegmentFileSizes=false
            engineConfig.getIndexSettings().getTranslogBatchAppendMaxSize().getBytes()
        // A refresh is needed if there are operations since the last refresh
        List<Closeable> toClose = new ArrayList<>();  
                                    doc.id(),  
            IndexModule.TieringState tieringState = IndexModule.TieringState.valueOf(tieringStateStr);
        assert index.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + index.origin();
     */
            if (fileInfos.writerFilesMap().isEmpty() == false) {
import java.util.concurrent.locks.Lock;  
            doc,
            return true;
    @Override
        /**
            // go through this same helper. Calling lookupFromReader directly skipped the checks,
            reservedDocs = plan.reservedDocs;
    }
import org.opensearch.common.unit.TimeValue;  
        final TranslogBatchScope batch = activeBatch.get();
        // We don't segregate internal/external here since NRT is anyhow invoked on internal refresh which makes
        }
            );
        try (ReleasableLock releasableLock = readLock.acquire()) {  
        long fromSeqNo,
import java.util.Optional;  
import org.apache.lucene.search.ReferenceManager;
            autoGeneratedIdTimestamp,  
    private final Set<TranslogBatchScope> activeBatches = ConcurrentHashMap.newKeySet();  
    private TranslogDeletionPolicy getTranslogDeletionPolicy() {
            }  
                lockedWriter = null;
        long ifPrimaryTerm  
                // we are switching from an unsafe map to a safe map. This might happen concurrently
     */
        // mirroring InternalEngine. The version map carries delete tombstones used by the get-by-id/version path.  
            advanceMaxSeqNoOfUpdatesOrDeletes(delete.seqNo());  
        return mergeScheduler.hasPendingMerges();
                            // Sync translog before commit so the global checkpoint is persisted
                    }  
            store.incRef();
                indexResult.setTook(System.nanoTime() - index.startTime());
     * @param delete the delete operation
            this::onTranslogBatchFinished,  
                engineConfig.getIndexSettings(),
                    // Acked docs can't reach the catalog (writer in an unreconcilable state, or
        assert index.primaryTerm() > 0 : "primary term must be positive but was: " + index.primaryTerm();  
    }  
                try {
                                    rowsToRelease += rowIdAwareWriter.docCount();
                            assert commitData.containsKey(Engine.HISTORY_UUID_KEY) : "commit data missing history UUID";
     * returns to HOT (tiering cancel or prepare failure).  
        return 0L;
     * Records non-translog deletes, updates checkpoint state, and finalizes the result. A successful
            markSeqNoAsSeen(delete.seqNo());
     * N-1 docs into {@link #pendingSegments}, and closes it; any other state — or a flush failure
                snapshotRef.close();  
                delete.origin(),
        ensureOpen();
    /** Triggers a refresh to flush the indexing buffer to segments. */
                SequenceNumbers.max(localCheckpointTracker.getMaxSeqNo(), translogManager.getMaxSeqNo())  
     * Counts the number of translog operations between the given sequence numbers.
                Releasable ignored = versionMap.acquireLock(index.uid().bytes());  
                            toClose.add(writerToFlush);  
                        // (by itself + write threads cooperatively).  
        long primaryTerm,
     * per-format reader on the current snapshot and passing it to the plugin.  
        } catch (Exception e) {
        List<ReferenceManager.RefreshListener> refreshListeners = new ArrayList<>();  
                                CatalogSnapshot.LAST_COMPOSITE_WRITER_GEN_KEY,
    }
                committer
     */
            store.readLastCommittedSegmentsInfo().getUserData().entrySet()
            if (indexResult.getTranslogLocation() == null) {  
        if (engineTragic != null) {
     * For primary operations, the indexing strategy planner determines whether to execute
            // Merge
        return translogManager;
                    assert gen > 0 : "merge generation must be positive but was: " + gen;
        final TranslogBatchScope batch = new TranslogBatchScope(
        final long timeMSec = engineConfig.getThreadPool().relativeTimeInMillis();
        }
    public long getLastSyncedGlobalCheckpoint() {  
                segBuilder.addSearchableFiles(entry.getKey(), entry.getValue());
            final long flushElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - flushStartNanos);
                location = translogManager.add(  
        // DataFormatAwareEngine is the primary-side engine in a segment-replication cluster.
                        final long flushAllStartNanos = System.nanoTime();  
        final long refreshStartNanos = System.nanoTime();
    }
    }
                        persistedCheckpoint,
            closedLatch.await();
    /**
            try {
                        readerRef.get(),  
    public long getIndexThrottleTimeInMillis() {
                            // that flushed nothing adds none.
import org.apache.lucene.util.BytesRef;
    private final List<ReferenceManager.RefreshListener> refreshListeners;
    }
                        // Drain pending writers so they get closed after addIndexes incorporates their files  
                                ).toGetResult();
     * @param docMapper                the document mapper for parsing  
    }  
            }  
     *
        List<Exception> exceptions = new ArrayList<>();  
                    if (get.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO  
     * Runs synchronously on the calling {@code FORCE_MERGE} thread.
                            // Dropped generations may release rows without publishing segments.  
                            shardId,
    public boolean shouldPeriodicallyFlush() {  
        boolean requiredFullRange,
                try {
        long primaryTerm,  
        boolean onlyExpungeDeletes,
                ioException.addSuppressed(e);
            this::maybeFailEngine,
                versionMap.enforceSafeAccess();
            throttle.deactivate();
                delete.id(),
            // translog fsync callback). The seqNo must still be valid.
                                refreshed |= hasFiles;
        for (ReferenceManager.RefreshListener refreshListener : refreshListeners) {  
                            index.origin(),
                delete.uid(),
import org.opensearch.index.seqno.SeqNoStats;  
                                        writerToFlush.generation(),  
 * deleting, and searching documents on a single shard by coordinating between the
        translogDeletionPolicy.setRetentionSizeInBytes(translogRetentionSize.getBytes());
     * Refreshes the engine to make recently indexed documents searchable.
    public Engine.Delete prepareDelete(
            // A throw from addDoc is unmodeled. Known per-doc rejections must come back as  
            throw new IllegalStateException("Engine is frozen for tiering — index operations blocked");  
     * appended as a no-op to keep recovery gap-free (mirroring the indexing path).
    private final Committer committer;  
     * Returns a translog snapshot for the given sequence number range.
    @Override  
     * @param origin                   the operation origin (PRIMARY, REPLICA, etc.)  
        boolean accurateCount
                                    index.seqNo(),  
        throw new UnsupportedOperationException(
    /**
                                ) == OpVsEngineDocStatus.OP_NEWER) {
            logger.debug(() -> new ParameterizedMessage("tried to fail engine but could not acquire lock [{}]", reason), failure);  
    private final CatalogSnapshotStatsCache statsCache;  
            // Translog-origin operations must NOT be written back to the translog (would cause duplicates)
                "DataFormatAwareEngine cannot be used on a read-only shard ["
        }  
        @Override
        } finally {
                final EngineException closeFailure = new EngineException(shardId, "engine closed with pending translog batches: " + reason);
                if (e instanceof AlreadyClosedException || translogManager.getTragicExceptionIfClosed() != null) {
            } catch (Exception flushEx) {
        TranslogManager translogManagerRef = null;
    private TranslogManager createTranslogManager(
                if (ex instanceof AlreadyClosedException) {
     * carries the richer {@link CatalogSnapshot} that describes multi-format segments.
            failEngine("already closed by tragic event on the translog", translogManager.getTragicExceptionIfClosed());
            assert indexingExecutionEngine != null : "indexing execution engine must be initialized";
                    + currentWriter.getClass().getName();
                    + "]";
                                    logger.trace(
    public DataFormatAwareEngine(EngineConfig engineConfig) {
                                    hasFiles  
                }  
                            // reached batch.add, the WAL record exists before the row is searchable. The residual window
    private Engine.IndexResult indexIntoEngine(Engine.Index index, IndexingStrategy plan) throws IOException {
                        for (Closeable retiring : toClose) {  
            updateAutoIdTimestamp(Long.parseLong(userData.get(MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID)), true);  
     * System property to enable or disable pluggable dataformat merge operations.  
                    flushEx
                    && !(indexResult.getFailure() instanceof AppendOnlyIndexOperationRetryException)) {
    private long doGenerateSeqNoForOperation(final Engine.Operation operation) {
                );
        return translogManager.getLastSyncedGlobalCheckpoint();
        // A deferred result is timed before entering the batch and frozen when its chunk is appended.
    /**
                logger.error(() -> new ParameterizedMessage("Merge failed while registering merged files in Snapshot"), ex);
                    closeNoLock("engine failed on: [" + reason + "]");
        if (frozenForTiering.get()) {
        if (deleteResult.getTranslogLocation() == null) {
                            index.startTime(),
                } catch (IllegalStateException bufferLoss) {  
            return true;
                            assert Long.parseLong(commitData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)) >= -1  
        maxSeenAutoIdTimestamp.updateAndGet(curr -> Math.max(curr, newTimestamp));  
    @Override
                latch.countDown();
        if (includeSegmentFileSizes) {
            // branch above checks them inline, and the read-only and NRT replica engines already
        if (engineConfig.isAutoGeneratedIDsOptimizationEnabled() == false) {  
                        for (var lockable : writers) {  
        String state = engineConfig.getIndexSettings()
        ensureOpen();
    }  
            notifyRefreshListenersBefore();
            // Queue writer for deferred close (temp dirs must survive until refresh does addIndexes)
                () -> new ParameterizedMessage("preIndex: flush failed for writer gen={}, failing engine", writerToFlush.generation()),
    public long getWritingBytes() {
     */
    private void ensureNoTragicException() {  
                            writerCount,
import org.opensearch.index.engine.dataformat.RowIdAwareWriter;
            // Signal the refresh thread that one more writer has been flushed
                return statsCache.getSegmentsStats();
                dataFormatAwareMergePolicy,
            String translogUUID = Objects.requireNonNull(userData.get(Translog.TRANSLOG_UUID_KEY));
                shardId,  
    }  
            Writer currentWriter = lockedWriter.get();
    static final String MERGE_ENABLED_PROPERTY = "opensearch.pluggable.dataformat.merge.enabled";
                        // Drain any segments flushed by write threads (via preIndex)
    }
                return stats;
import org.opensearch.common.concurrent.GatedConditionalCloseable;
    private final LocalCheckpointTracker localCheckpointTracker;  
        return engineConfig.getMapperService().documentMapper().getVersion();
            logger.debug("preIndex: write thread flushed writer gen={} in [{}ms]", writerToFlush.generation(), flushElapsedMs);
        mergeScheduler.forceMerge(maxNumSegments);
import org.opensearch.common.util.io.IOUtils;
                    plan = indexingStrategyPlanner.planOperationAsNonPrimary(index);
            }
    private void closeNoLock(String reason) {
                    try (GatedConditionalCloseable<CatalogSnapshot> snapshotRef = catalogSnapshotManager.acquireSnapshotForCommit()) {
        for (TranslogBatchScope batch : activeBatches) {
                        entry.getValue().files()
        }
    }
        return deleteResult;
            }
            success = true;  
        return false;  
    @Override
            assert translogManager != null : "translog manager must be initialized";
    }
import org.opensearch.index.engine.dataformat.WriterConfig;
                            plan.version,  
                                return new DocumentLookupResult(
                        while ((writerToFlush = flushQueue.poll()) != null) {  
        final Engine.DeleteResult deleteResult = deleteInEngine(delete, plan);
    public Engine.TranslogBatch beginTranslogBatch() {
        Engine.Operation.Origin origin,  
                            index.versionType(),  
                location = null;
        String routing,
                } finally {
        }
        boolean writerCheckedOut = false;
     * never bytes that are "reported as used but already being freed."
            // so a stale precondition on a get (and therefore on an update of any committed  
        }
                            index.seqNo(),
        return indexingExecutionEngine.getNativeBytesUsed();  
                        final Engine.NoOp noOp = new Engine.NoOp(  
     * on both primary and replica). Updates {@link #lastDeleteVersionPruneTimeMSec}.
                this.versionMap.clear();  
            long rows = entry.getValue().numRows();
                            // A refresh that published segments must have rows to release; a pure delete
    }  
            ? engineConfig.getDocumentMetadataResolver()
                this::updateAutoIdTimestamp,
        localCheckpointTracker.markSeqNoAsProcessed(noOp.seqNo());
                }
        if (activeBatch.get() != null) {
            IOUtils.closeWhileHandlingException(writer);
     * and flushes it — providing natural backpressure on indexing while helping drain
        final boolean doThrottle = index.origin().isRecovery() == false;
                logger,
        public CatalogSnapshot catalogSnapshot() {
            translogManager,  
        updateAutoIdTimestamp(newTimestamp, true);
import org.opensearch.index.engine.exec.IndexReaderProvider;  
            public void onAfterTranslogSync() {
                        logger.debug("releasing refreshLock held after merge failure (safety-net unlock)");
        } finally {
     * @param translogRetentionAge   the maximum age for translog files
                closeNoLock("api");  
            throw new IllegalStateException(  
            // means we don't know the writer's buffer state and cannot safely retire it —  
import org.opensearch.common.Nullable;  
        }
        return false;  
        String forceMergeUUID
                throw new IllegalArgumentException(  
            } catch (Exception e) {
                localCheckpointOfLastCommit,
        } catch (IllegalArgumentException e) {
                                throw new IOException("Refresh interrupted waiting for flush completion", e);
            CatalogSnapshot catalogSnapshot = snapshotRef.get();  
        // fast so a misconfiguration surfaces before any indexing or recovery.
                                    index.source(),
        private final GatedCloseable<CatalogSnapshot> snapshotRef;
    }
        try {
    @Override
        boolean isRetry,
        ensureOpen();  
     */
        } finally {
                                throw new AlreadyClosedException("engine closed during refresh flush");  
            if (postState != WriterState.RETIRED_FLUSHABLE) {
                // latestCatalogSnapshot between commit() and updateLastCommitInfo(). Reentrant.
import java.util.HashMap;
                            Translog.Operation operation = translogManager.readOperation(versionValue.getLocation());
            return;  
                    // past them (seeding them as "already processed") and silently drop them.  
        deleteResult.freeze();  
     * @throws IOException if the engine or translog write fails
     * Verifies that the global checkpoint matches the maximum sequence number before
    private final ConcurrentLinkedQueue<Writer<?>> pendingWritersToClose = new ConcurrentLinkedQueue<>();
            if (frozenForTiering.compareAndSet(false, true)) {
     * applicable to the data format engine.  
                        }
                    refreshLock.unlock();
            );  
    @Override  
        }
import org.opensearch.common.util.concurrent.ReleasableLock;
import java.util.concurrent.atomic.AtomicBoolean;  
                if (waitIfOngoing == false) {  
                deleteResult = executeDeletePlan(delete, plan);
    @Override  
                    closedLatch.countDown();
            );  
        DefaultLockableHolder<Writer<?>> lockedWriter = writerPool.getAndLock(h -> h.get().state() == WriterState.ACTIVE);  
            // refresh only if new segments have been created or force param is true  
    @Override
        // When a translog batch is active for THIS thread and this is a successful primary (non-translog-origin) Index  
                delete.getIfPrimaryTerm()
            // Writer pool must never return null — it creates on demand via the supplier
    long getGcDeletesInMillis() {
                            try {
        for (ReferenceManager.RefreshListener refreshListener : refreshListeners) {  
     * {@link #onSettingsChanged} on a tiering transition, and by {@link #freezeForTiering()}. The
                    IOUtils.closeWhileHandlingException(pendingWriter);
        return localCheckpointTracker.hasProcessed(op.seqNo());
            try (GatedCloseable<CatalogSnapshot> catalogSnapshot = catalogSnapshotManager.acquireSnapshot()) {
                combinedPolicy,  
    ) throws EngineException, IOException {
                        localCheckpointTracker.markSeqNoAsProcessed(doc.seqNo());
     * @return the delete result  
                : "Either the write lock must be held or the engine must be currently failing";
                new ReaderManagerConfig(
        if (engineConfig.isEnableGcDeletes()) {  
                }  
                if (failedEngine.get() != null) {
        } else {  
            statsWithDeleteBytes.addVersionMapMemoryInBytes(deleteRamBytes);
        return maxSeqNoOfUpdatesOrDeletes.get();
    @Override  
        final SequenceNumbers.CommitInfo seqNoStats = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
import org.opensearch.index.shard.RemoteStoreRefreshListener;  
                        String lastCommittedSnapshotId = lastCommitData.get(CatalogSnapshot.CATALOG_SNAPSHOT_ID);
        }
                        Map<String, String> lastCommitData = committer.getLastCommittedData();  
     * @throws EngineException if the refresh fails
    public Iterable<Writer<?>> getWriterPool() {
        }
     * Retires the writer if its {@link WriterState} is non-ACTIVE: ACTIVE returns {@code false}
            logger.debug("forceMerge blocked — engine is frozen for tiering");
            }  
import org.opensearch.index.seqno.SequenceNumbers;
    }
            this.writerPool = new LockablePool<>(() -> {  
        }
        VersionType versionType,  
                    + policy
        }
                    long gen = writerGenerationCounter.incrementAndGet();
 * Mirrors the responsibilities of {@link InternalEngine} but is decoupled from Lucene:
        assert noOp.seqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO : "noOp must have an assigned seqNo: " + noOp;  
                );
                return null;
        int count = throttleRequestCount.incrementAndGet();  
     */
                assert assertRetiredSegmentInvariants(writer, retiredFileInfos);
     */
     * sequence-number, translog, checkpoint, and version-map state.  
     * @param softDeletesRetentionOps unused — soft deletes are not supported
     * indexing data (pending VSR writes, buffered segments) is committed before merge  
 *   <li>Flush to commit catalog snapshots and trim the translog</li>
                assert currentWriter instanceof RowIdAwareWriter : "writer pool must wrap every writer in a RowIdAwareWriter; got "  
                    delete.primaryTerm(),
                    deleteEx
        if (plan.executeOpOnEngine) {
        return true;
    // Shared get-by-id flow (parquet lookup + read version-conflict checks), common to all DataFormatAware* engines.  
                    config().getStore(),
    private final LockablePool<DefaultLockableHolder<Writer<?>>> writerPool;  
                }  
    }  
    @Override
     * Prefers the cached volatile flag, which is set by the constructor on open, by  
     * <p>  
            try (GatedCloseable<Reader> readerRef = acquireReader()) {  
                }
     * unacknowledged with unprocessed sequence numbers, the same state the stock engine leaves a document in between  
            : "DataFormatAwareEngine only supports PRIMARY, LOCAL_TRANSLOG_RECOVERY, or LOCAL_RESET origins but got: " + index.origin();  
    @Override  
    // TODO Refactor these flush managing activities into FlushManager.
import java.util.concurrent.locks.ReentrantLock;
                                }  
                        CountDownLatch flushLatch = new CountDownLatch(writerCount);
                    readers.put(entry.getKey(), reader);
        List<Writer<?>> writers = new ArrayList<>();
 *   <li>Sequence number generation and local checkpoint tracking</li>
        activeBatches.remove(batch);
    public Engine.NoOpResult noOp(Engine.NoOp noOp) throws IOException {  
    // Refresh thread awaits this before proceeding with catalog commit.
                    "retired segment row counts diverge across formats: format ["
    }  
                    writerCheckedOut = true;  
    public boolean isThrottled() {  
    }
                            index.uid(),
        final Engine.DeleteResult deleteResult;
                            refreshed = true;
        }
            );
                        + entry.getKey().name()
    /**
import java.util.List;  
            this.localCheckpointTracker = createLocalCheckpointTracker(LocalCheckpointTracker::new);  
        if (result.getTranslogLocation() == null) {
        }
    // Refresh tracker  
     * @param ifPrimaryTerm            the conditional primary term
    private final AtomicLong maxUnsafeAutoIdTimestamp = new AtomicLong(-1);
            }
     * to the configured flush threshold.
                "Global checkpoint [" + globalCheckpoint + "] mismatches maximum sequence number [" + maxSeqNo + "]"
     * When {@code flush} is true, a full flush is performed first to ensure all in-flight
                this::resolveDocVersion,  
                indexResult = new Engine.IndexResult(f.cause(), plan.version, index.primaryTerm(), index.seqNo());  
                "Unrecognized {} value [{}]; treating engine as not frozen for tiering",
        assert Objects.equals(index.uid().field(), IdFieldMapper.NAME) : index.uid().field();  
            // When file sizes are requested, compute on-demand with current snapshot  
            try (GatedCloseable<CatalogSnapshot> snapshotRef = catalogSnapshotManager.acquireSnapshot()) {
        assert mergeResult != null : "merge result must not be null";
                versionMap.maybePutIndexUnderLock(
            origin,
        } else if (e instanceof AlreadyClosedException) {  
                    && indexResult.getFailure() != null  
    private boolean incrementVersionLookup() { // only used by asserts  
        versionMap.enforceSafeAccess();
            engineConfig.getStartedPrimarySupplier(),  
            return OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
                    store.getDataformatAwareStoreHandles(),
                                        entry.getValue().files()
            readLock,  
                            logger.debug(  
    public boolean hasPendingMerges() {  
        String id,
            doc.addDynamicMappingsUpdate(docMapper.getMapping());  
     */
import org.apache.lucene.index.Term;
            // silently dropped rather than enforced.
     * {@code segments_N} disk read required to materialize a Lucene {@link IndexCommit}, and  
    private Engine.Delete generateSeqNoForDelete(Engine.Delete delete) {
    /**
        this.logger = Loggers.getLogger(DataFormatAwareEngine.class, engineConfig.getShardId());  
                return true;
     * (writer stays in the pool); RETIRED_FLUSHABLE checks the writer out, flushes the buffered  
            } catch (Exception inner) {
            }
     * consulted for it exactly as for a per-operation {@code Translog#add} failure. The drainer therefore only stops
                                        entry.getKey().name(),
import org.opensearch.index.engine.exec.CatalogSnapshotLifecycleListener;
    }
                batch.add(new Translog.Index(index, indexResult), indexResult, pending, indexResult.getSeqNo());  
                );
     * @return the index result with sequence number, version, and translog location  
        updateTieringFreezeState();  
            );
        }  
        return new Engine.Index(  
                }
    // Wall-clock time (ms) of the last version-map delete-tombstone prune; used to throttle maybePruneDeletes().
                return new Engine.DeleteResult(plan.version, delete.primaryTerm(), delete.seqNo(), plan.currentlyDeleted == false);
     * non-composite engines retain inline translog appends even when the prototype setting is present.
        if (engineConfig.getExternalRefreshListener() != null) {
                        new IndexVersionValue(location, indexResult.getVersion(), index.seqNo(), index.primaryTerm())  
            localCheckpointTracker.markSeqNoAsPersisted(noOp.seqNo());  
                                Long.toString(snapshot.getLastWriterGeneration())
    }
                        deletesApplied |= unpublishedDeletes.getAndSet(false);  
        }  
        } catch (Exception e) {
        }
        }
import java.io.Closeable;  
     * ensures only one caller wins the freeze transition under parallel tier/cancel.
         * @return the typed reader, or {@code null} if no reader exists for the format
            }  
        // ensureNoTragicException check and the actual addIndexes / commit call. Consult the
                            versionValue.term
     * @param source                   the raw source to parse
                documentCountTracker::tryAcquireInFlightDocs,
    @Override  
                && versionValue.isDelete()
    private final AtomicLong writerGenerationCounter;
                if (refreshListener instanceof RemoteStoreRefreshListener) {
     * If any per-format indexing engine has recorded a tragic exception (e.g., an
    }  
import org.opensearch.index.engine.dataformat.DataFormat;
        if (shouldFreeze) {
     * Closes the engine, releasing all resources including the indexing execution engine,  
     * Unlike InternalEngine where IndexWriter stays open after flushNextBuffer() (keeping bytes
                if (rows > 0) {  
    @Nullable  
            );  
        try {  
        return translogManager.acquireHistoryRetentionLock();  
                throw new IllegalStateException(
                        refreshLock.unlock();
    public void close() throws IOException {  
     * delete is appended as a delete; a failed one already holds an issued sequence number, so it is  
                assert retiredSegment.generation() == writer.generation() : "retired segment generation must match writer generation";  
/**
                    failEngine(reason, ex);
            // All critical engine components must be initialized before the engine is considered ready
     *  
            }  
        }
import java.util.LinkedList;
            assert index.origin().isFromTranslog()
     * The prepare action explicitly calls freezeForTiering() while the index is still  
            } catch (IOException e) {
        }
        } finally {
                engineConfig.getIndexSettings().getFlushThresholdSize().getBytes()  
            this.historyUUID = userData.get(Engine.HISTORY_UUID_KEY);
                                new Committer.CommitInput(commitData.entrySet(), snapshot, 0)
     * @param engineConfig the engine configuration  
        assert delete.origin() == Engine.Operation.Origin.PRIMARY  
        boolean upgrade,
     * @param versionType   the version type  
    private TranslogEventListener createInternalTranslogEventListener() {
    private boolean incrementIndexVersionLookup() {
                            commitData.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(snapshot.getId()));
            }
    public void flush(boolean force, boolean waitIfOngoing) throws EngineException {
                IndexModule.INDEX_TIERING_STATE.getKey(),
        if (versionValue == null) {
            SegmentsStats cachedStats = statsCache.getSegmentsStats();
                    try {
        final long maxSeqNo = getSeqNoStats(globalCheckpoint).getMaxSeqNo();
    public static class DataFormatAwareReader implements IndexReaderProvider.Reader {  
import org.opensearch.indices.pollingingest.PollingIngestStats;
        int count = throttleRequestCount.decrementAndGet();
    }  
     * though the constructor already covers that — and, more importantly, closes the apply-ordering  
                    + "] requested for shard ["  
                }
                    store.shardPath(),  
                translogManager::getLastSyncedGlobalCheckpoint
    private final SetOnce<Exception> failedEngine = new SetOnce<>();
                    plan = indexingStrategyPlanner.planOperationAsPrimary(index);  
            delete = new Engine.Delete(  
    /**  
                if (failure != null) {  
        int maxNumSegments,  
     * unrecoverable IndexWriter failure), fail the engine. Called at refresh and flush entry
            versionType,  
        return delete;
                        logger.trace(
        return true;  
/*  
        }  
        }
    }
            DataFormatRegistry registry = engineConfig.getDataFormatRegistry();
import org.opensearch.common.annotation.ExperimentalApi;
 * An {@link Indexer} implementation that delegates to an {@link IndexingExecutionEngine}.  
            }, shardId, engineConfig.getIndexSettings(), engineConfig.getThreadPool());
        public Object reader(DataFormat format) {
            assert index.origin().isFromTranslog() == false || indexResult.getTranslogLocation() == null  
        }
        }  
     * translog manager, reader managers, and store reference.
                while ((pendingWriter = pendingWritersToClose.poll()) != null) {
        long autoGeneratedIdTimestamp,
    public Closeable acquireHistoryRetentionLock() {
    @Override
                            }
     * refresh, flush, and merge-result catalog commits (each with documented bypasses below).
     *  
    }  
                                    writerFlushElapsedMs,
            final long flushStartNanos = System.nanoTime();
     * @return the number of operations in the range
    @Override
    }
            }  
            index.parsedDoc().getDocumentInput().addField(PrimaryTermFieldType.INSTANCE, index.primaryTerm());
            }
            }
    private final ReentrantLock failEngineLock = new ReentrantLock();
                                    + "existingSegments={} newSegments={} resultSegments={} dropped={}",
    @Override
                        // New segment generations must not collide with existing segment generations
        }
        return throttle.isThrottled();
        if (force && waitIfOngoing == false) {  
    /**
        if (Booleans.parseBoolean(System.getProperty(MERGE_ENABLED_PROPERTY, Boolean.TRUE.toString())) == false) {
    /**  
            .get(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name());
     * @param requiredFullRange whether the full range must be present  
 * <ul>  
                );
            // Copy the shared cached stats before adding delete-tracking memory.
                registry.format(config().getIndexSettings().pluggableDataFormat())  
    public boolean maybeRefresh(String source) {  
                    delete.seqNo(),
import org.opensearch.core.index.shard.ShardId;
    }
import org.opensearch.common.SetOnce;
                try {  
    private static boolean assertRetiredSegmentInvariants(Writer<?> writer, FileInfos retiredFileInfos) {  
        awaitPendingClose();  
     * @throws IOException if writing to the engine or translog fails
    @Override
    /** Returns the failed engine exception, or null. Visible for testing only. */  
                    + ", warm="  
            seqNo,  
            // and any index specific attributes useful for reads.  
                Releasable indexThrottle = doThrottle ? throttle.acquireThrottle() : () -> {}
                snapshotListeners,  
            this.committer = engineConfig.getCommitterFactory().getCommitter(new CommitterConfig(engineConfig, () -> {
     *
     * The caller must close the returned reader when done, which releases the
                                    newSegments.add(segment);
     */
        }
    }  
     * @param reason  a human-readable reason for the failure  
     *
                engineConfig.getShardId(),  
    }
        return lastRefreshedCheckpointListener.pendingCheckpoint();  
        refreshListeners.add(versionMap);
