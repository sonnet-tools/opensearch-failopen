            // All critical engine components must be initialized before the engine is considered ready
        return Objects.requireNonNullElseGet(
                batch.add(new Translog.Index(index, indexResult), indexResult, pending, indexResult.getSeqNo());
    public long getMaxSeenAutoIdTimestamp() {
import org.opensearch.index.translog.TranslogDeletionPolicy;
            }
     * recovery replay the translog. The writer is checked out of the pool before any work that
        if (isClosed.get()) {
    ) {
            } catch (Exception e) {
                    // refresh path drains again immediately before catalog publication to close concurrent races.
        for (EngineReaderManager<?> rm : readerManagers.values()) {
            store.readLastCommittedSegmentsInfo().getUserData().entrySet()
            );
            ensureNoTragicException();
                                assert rowsToRelease > 0L : "Rows to release from active writes should be greater than 0 but was: "
     * Forces a merge to reduce the number of segments to at most {@code maxNumSegments}.
    }
                            source,
        long primaryTerm,
        deleteResult.freeze();
        if (flush) {
                        Writer<?> writerToFlush;
                }
    }
        throws IOException {
                    }
                hasFiles = true;
    @Override
        deleteResult.setTook(System.nanoTime() - delete.startTime());
            return;
     * @param origin                   the operation origin (PRIMARY, REPLICA, etc.)
    }
     */
                        entry.getKey().name(),
                        // Use active polling so we detect engine close/failure promptly
        long fromSeqNo,
                || indexResult.getTranslogLocation() != null : "successful non-translog-origin op must have a translog location";
                }
    @Override
            }
    @Override
                        CatalogSnapshot snapshot = snapshotRef.get();
import org.opensearch.core.index.AppendOnlyIndexOperationRetryException;
                }
     * @param source                   the raw source to parse
        activeBatch.set(batch);
        // Location is deferred inside a PendingLocation held by the version-map entry. The batch's flush() assigns the
                    }
                    failEngine("writer retirement could not preserve buffered acked docs", bufferLoss);
        final long maxSeqNo = getSeqNoStats(globalCheckpoint).getMaxSeqNo();
        } else {
                    refreshListener.afterRefresh(true);
                    }
                );
                    if (refreshed || deletesApplied) {
                while ((pendingWriter = pendingWritersToClose.poll()) != null) {
    }
            localCheckpointTracker,
    public GatedCloseable<Reader> acquireReader() throws IOException {
    public void ensureOpen() {
        if (index.origin().isFromTranslog() == false) {
    }
    private void awaitPendingClose() {
                if (deleteExecutionEngine.onWriterCheckedOut(writer.generation())) {
        return true;
                if (versionMap.isUnsafe()) {
            }
    private final MergeScheduler mergeScheduler;
                            }
import java.io.Closeable;
        String forceMergeUUID
                            } catch (InterruptedException e) {
                Segment.Builder segmentBuilder = Segment.builder(writerToFlush.generation());
                statsWithoutFileSizes.add(cachedStats.getCount());
     * Routes the planned delete to the {@link DeleteExecutionEngine} under a locked active writer
    /** Triggers a refresh to flush the indexing buffer to segments. */
            // WriteResult.Failure with the writer's state already reconciled (ACTIVE after a
    @Override
    /** Returns the indexing execution engine. Visible for testing only. */
                // Invariant: writerCheckedOut ⇒ writer no longer registered in the pool.
                            index.id(),
import org.opensearch.index.engine.dataformat.DeleteResult;
        // Fast path - return precomputed segments from cache
                            }
     * @throws IOException if closing any resource fails
    /**
        Exception engineTragic = indexingExecutionEngine.getTragicException();
                    plan = indexingStrategyPlanner.planOperationAsPrimary(index);
                        index.uid().bytes(),
                            final VersionValue curr = versionMap.getUnderLock(uid);
                }
     * engine fails must not depend on which thread happened to drain the chunk. The rows of the failed scope are
                    assert index.origin() == Engine.Operation.Origin.PRIMARY : index.origin();
     *
                    index.uid().bytes(),
            reservedDocs = plan.reservedDocs;
    private final AtomicBoolean frozenForTiering = new AtomicBoolean(false);
        }
                                    rowsToRelease += rowIdAwareWriter.docCount();
    /** Flushes the engine with default parameters (non-forced, wait if ongoing). */
        }
            );
        // sequence number should not be set when operation origin is primary
    @Override
                    // current writer buffer into the catalog snapshot; any operation processed
     * <ul>
                            plan.version,
     * For primary operations, the indexing strategy planner determines whether to execute
            CatalogSnapshot catalogSnapshot = snapshotRef.get();
import org.opensearch.common.unit.TimeValue;
                        assert newSegments.stream().allMatch(s -> s.dfGroupedSearchableFiles().isEmpty() == false)
            @Override
    }
        }
                Reader reader = readerRef.get();
            if (rows != expectedRows) {
        WriterState postState = writer.state();
                                result.droppedGenerations().size()
import java.util.Optional;
                            assert commitData.containsKey(Translog.TRANSLOG_UUID_KEY) : "commit data missing translog UUID";
        if (failEngineLock.tryLock()) {
    private boolean retireWriterIfNeeded(DefaultLockableHolder<Writer<?>> lockedWriter) {
import org.opensearch.index.mapper.DocumentMapperForType;
                segBuilder.addSearchableFiles(entry.getKey(), entry.getValue());
        return false;
        final Engine.DeleteResult deleteResult = deleteInEngine(delete, plan);
    // Wall-clock time (ms) of the last version-map delete-tombstone prune; used to throttle maybePruneDeletes().
                }
    public void freezeForTiering() {
        if (force && waitIfOngoing == false) {
                                    new IndexVersionValue(null, doc.version(), doc.seqNo(), doc.primaryTerm())
        }
            }
                        // instead of blocking indefinitely on the latch.
 * <p>
     * @param translogRetentionSize  the maximum total size for translog files
        final TranslogBatchScope batch = activeBatch.get();
            this.historyUUID = userData.get(Engine.HISTORY_UUID_KEY);
        List<Exception> exceptions = new ArrayList<>();
            }
    public void flush(boolean force, boolean waitIfOngoing) throws EngineException {
    @Override
                            flushLatch.countDown();
                        new DeleteInput(IdFieldMapper.NAME, index.id(), currentWriter.generation()),
        assert op.seqNo() != UNASSIGNED_SEQ_NO : "operation is not assigned seq_no";
        String source,
    @Nullable
                                    index.seqNo(),
                            // Now add snapshot to commit data so it has latest snapshot
                deleteResult = executeDeletePlan(delete, plan);
                } else if (indexResult.getSeqNo() != UNASSIGNED_SEQ_NO
        try {
                            Map<String, String> commitData = new HashMap<>();
        }
                this::incrementVersionLookup
            // then transfers to applyMergeChanges, which releases the lock after the catalog
     * Closing this reader releases the catalog snapshot reference.
import org.opensearch.index.merge.MergeStats;
        }
     * <p>
    private void notifyRefreshListenersBefore() throws IOException {
    }
        return catalogSnapshotManager.getUnreferencedFileCleanUpsPerformed();
import org.opensearch.search.suggest.completion.CompletionStats;
                )
            mergeScheduler.freeze();
        lastDeleteVersionPruneTimeMSec = timeMSec;
            // ends by committing the post-merge snapshot, which registers a reader for it, so liveness
        return true;
            // 1. Create Committer (uses translogPath for safe bootstrap trimming)
        this.store = engineConfig.getStore();
        try {
                                Long.toString(snapshot.getLastWriterGeneration())
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    @Override
        }
        }
                    && !(indexResult.getFailure() instanceof AppendOnlyIndexOperationRetryException)) {
        // indexing engine (multiplexes across formats) and the translog: either can be the
import org.opensearch.index.seqno.SequenceNumbers;
    @Override
    private void onTranslogBatchFinished(TranslogBatchScope batch) {
            }
     * <p>Gated by {@code index.check_pending_flush.enabled} setting.
    /**
        try (ReleasableLock ignored = readLock.acquire(); Releasable ignored2 = versionMap.acquireLock(delete.uid().bytes())) {
        }
            // the lock is not permanently held.
        private final Map<DataFormat, Object> readers;
            seqNo,
    private final Store store;
     * Records a no-op for the given seqNo. Used for failed indexing attempts (so the failed
            engineConfig.getGlobalCheckpointSupplier(),
            String translogUUID = Objects.requireNonNull(userData.get(Translog.TRANSLOG_UUID_KEY));
            }
                            // Sync translog before commit so the global checkpoint is persisted
        }
            refreshListener.beforeRefresh();
                versionValue = new IndexVersionValue(null, lookupResult.version(), lookupResult.seqNo(), lookupResult.primaryTerm());
                deleteResult = (Engine.DeleteResult) plan.earlyResultOnPreFlightError.get();
    }
        final TranslogBatchScope batch = activeBatch.get();
        Engine.Operation.Origin origin,
    }
                                .toList();
            || engineConfig.getIndexSettings().isSegRepEnabledOrRemoteNode() == false) {
                    store.getDataformatAwareStoreHandles(),
            restoreVersionMapAndCheckpointTracker();
            finalizeDelete(delete, deleteResult);
                throw new AssertionError(
                            index.version(),
        // When a translog batch is active for THIS thread and this is a successful primary (non-translog-origin) Index
        }
import org.opensearch.plugins.DocumentLookupProvider;
    /** Local checkpoint captured just before the ongoing refresh; parallels {@code InternalEngine}. */
        } catch (Exception ex) {
            logger.warn(
     * <p>Unlike {@code InternalEngine.noOp}, this implementation does not write a tombstone
                + " op_term="
            this.deleteExecutionEngine = registry.getDeleteExecutionEngine(committer);
                logger.warn("failEngine threw exception", inner);
import org.opensearch.index.engine.dataformat.DataFormat;
            logger.trace("preIndex: check pending flush disabled, skipping");
            // translog fsync callback). The seqNo must still be valid.
            failEngine("flush failed during preIndex for writer gen=" + writerToFlush.generation(), e);
    @Override
                "DataFormatAwareEngine cannot be used on a read-only shard ["
        boolean deferred = false;
                // map so once we pass this point we can safely lookup from the version map.
                            // pending chunk before publishing the segments so that, for every row whose bulk thread has
                            );
                    catalogSnapshotManager.incrementUnreferencedFileCleanUps();
            return true;
     */
 * SPDX-License-Identifier: Apache-2.0
                throw new IllegalArgumentException(
    /** Set when deletes were applied without publishing a segment; the next refresh consumes it to reopen readers. */
                                    newSegments.add(segment);
        mergeScheduler.triggerMerges();
import org.opensearch.index.engine.dataformat.RefreshResult;
                } finally {
            });
                            translogManager.trimUnreferencedReaders();
     */
            refreshListeners.addAll(engineConfig.getInternalRefreshListener());
                    } else {
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
import org.opensearch.common.lucene.uid.Versions;
            pendingWritersToClose.add(writerToFlush);
import org.opensearch.common.util.io.IOUtils;
            } catch (Exception inner) {
            final DeletionStrategy plan = planDelete(delete);
            assert rwl.isWriteLockedByCurrentThread() || failEngineLock.isHeldByCurrentThread()
            uid,
                                // If the catalog snapshot changed during the flush, this will ensure the latest one
public class DataFormatAwareEngine implements Indexer {
                pendingSegments.add(segmentBuilder.build());
                refreshLock.lock();
        try (ReleasableLock ignored = readLock.acquire()) {
            try {
                return docsIngested;
            primaryTerm,
                engineConfig.getIndexSettings().getTranslogRetentionAge().getMillis(),
    }
        if (engineConfig.isAutoGeneratedIDsOptimizationEnabled() == false) {
        ensureOpen();
        return result;
                + " seq_no="
        result.freeze();
    public SafeCommitInfo getSafeCommitInfo() {
            }
                }
        if (engineConfig.getIndexSettings().isTranslogBatchAppendEnabled() == false
    }
            failEngine(source, e);
     * When {@code true}, tiering-sensitive operations are blocked: primary index ops, merges,
            throw e;
     * @param versionType              the version type
        // Safety net for AlreadyClosedException caught mid-refresh / mid-flush — e.g., a
    long getGcDeletesInMillis() {
                                : "local checkpoint in commit data must be >= -1";
     * Otherwise, the listener will fire on the merge thread when
                                for (Map.Entry<DataFormat, WriterFileSet> entry : fileInfos.writerFilesMap().entrySet()) {
     * @throws IOException if writing to the engine or translog fails
    }
        }
     * Constructs a DataFormatBasedEngine.
            if (writerPool.isRegistered(lockedWriter)) {
            } catch (IOException e) {
            return snapshotRef.get();
        return batch;
            }
        }
     * engine lock to ensure only one failure is recorded. Closes the engine and notifies
                            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(committedLocalCheckpoint));
        assert index.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + index.origin();
            engineConfig.getStartedPrimarySupplier(),
import org.opensearch.index.engine.exec.commit.Committer;
        long primaryTerm,
                );
    @Override
                                    Segment segment = segmentBuilder.build();
        if (noOp.origin().isFromTranslog() == false) {
    @Override
                pendingSegments.clear();
                                );
    /** Chooses the primary or local recovery/reset deletion plan. */
    public TranslogManager translogManager() {
        awaitPendingClose();
                                    hasFiles = true;
            try {
        return historyUUID;
     * Acquires a {@link DataFormatAwareReader} on the latest catalog snapshot.
                        refreshLock.unlock();
            }
                );
                + versionValue.term;
                        );
        }
                        for (Closeable retiring : toClose) {
                                        entry.getKey().name(),
        }
        return true;
        // Deletes need only an active writer for generation context; they do not apply mappings.
        assert count >= 1 : "invalid post-increment throttleRequestCount=" + count;
        if (isClosed.compareAndSet(false, true)) {
        }
                        persistedCheckpoint,
 * @opensearch.experimental
                // we are switching from an unsafe map to a safe map. This might happen concurrently
        List<ReferenceManager.RefreshListener> refreshListeners = new ArrayList<>();
     * Runs synchronously on the calling {@code FORCE_MERGE} thread.
                translogManager.trimUnreferencedTranslogFiles();
        if (engineConfig.getInternalRefreshListener() != null) {
                                .stream()
    /**
    /**
        /**
        if (exceptions.isEmpty() == false) {
            translogEventListener,
            // Track the sequence number
                        );
        activeBatches.remove(batch);
        throws IOException {
 * deleting, and searching documents on a single shard by coordinating between the
                        + " rows, expected "
                                    + existingSegments.size()
            if (frozenForTiering.compareAndSet(true, false)) {
     */
                translogManager::getLastSyncedGlobalCheckpoint
        if (delete.origin().isFromTranslog() == false) {
    /**
        // We don't segregate internal/external here since NRT is anyhow invoked on internal refresh which makes
        long ifSeqNo,
            // Queue writer for deferred close (temp dirs must survive until refresh does addIndexes)
            }
            if (postState != WriterState.RETIRED_FLUSHABLE) {
     */
     * Returns true if the engine is frozen for tiering and the operation should be blocked.
            assert index.seqNo() >= 0 : "seqNo must be assigned before writing but was: " + index.seqNo();
                    refreshLock.unlock();
    }
            engineConfig.getIndexSettings().getTranslogBatchAppendMaxOperations(),
     *
                ),
                if (refreshListener instanceof RemoteStoreRefreshListener) {
        if (versionMap.isUnsafe()) {
import org.opensearch.common.logging.Loggers;
        }
                deleteExecutionEngine.recordWrite(index.id(), new DocumentLocation(currentWriter.generation(), insertionRowId));
                            index.primaryTerm()
            || delete.origin() == Engine.Operation.Origin.LOCAL_RESET
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
                            get.getIfSeqNo(),
                    if (refreshLock.isHeldByCurrentThread()) {
        return new CompletionStats();
import java.util.List;
        final Engine.DeleteResult deleteResult;
    }
            maxSeqNoOfUpdatesOrDeletes = new AtomicLong(
        }
                if (w.state() != WriterState.ACTIVE) return false;
                    + indexResult.getSeqNo()
        VersionValue versionValue = getVersionFromMap(op.uid().bytes());
    }
                assert retiredSegment.generation() == writer.generation() : "retired segment generation must match writer generation";
 *
    @Override
            } else if (deleteResult.getSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {
                    }
            }
     */
    @Override
        this.documentMetadataResolver = engineConfig.getDocumentMetadataResolver() != null
                return w.isSchemaMutable() || w.mappingVersion() >= mappingVersion;
        final long totalRefreshElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - refreshStartNanos);
            // A merge replaces segments and drops rows that were hidden by a delete or an update, so
        if (isFrozenForTiering()) {
    }
            // Signal the refresh thread that one more writer has been flushed
            MergeHandler mergeHandler = new MergeHandler(
                    if (failure != null && Lucene.isCorruptionException(failure)) {
            this.localCheckpointTracker = createLocalCheckpointTracker(LocalCheckpointTracker::new);
            ? engineConfig.getDocumentMetadataResolver()
import org.opensearch.core.index.shard.ShardId;
        try (ReleasableLock releasableLock = readLock.acquire()) {
     * and flushes it — providing natural backpressure on indexing while helping drain
            // with a prior primary's uploads for the same shard. See method Javadoc for rationale.
        updateTieringFreezeState();
            return;
        }
     * after flush and remote sync are complete, just before the state transitions to HOT_TO_WARM.
import org.opensearch.index.translog.TranslogException;
            } catch (Exception inner) {
                            index.uid(),
                delete.primaryTerm(),
        }
                statsWithoutFileSizes.updateMaxUnsafeAutoIdTimestamp(cachedStats.getMaxUnsafeAutoIdTimestamp());
        if (engineConfig.getExternalRefreshListener() != null) {
    /**
        // Fast path - return precomputed stats from cache
                            versionValue.term
    public long getProcessedLocalCheckpoint() {
                : "Either the write lock must be held or the engine must be currently failing";
                    flushEx
     * @param ifSeqNo       the conditional sequence number
    public boolean refreshNeeded() {
        Writer<?> writer = lockedWriter.get();
import java.util.HashMap;
        numVersionLookups.inc();
     * Detects tiering state transitions and freezes/unfreezes the engine accordingly.
                            }
                Releasable indexThrottle = doThrottle ? throttle.acquireThrottle() : () -> {}
        return lastRefreshedCheckpointListener.lastRefreshedCheckpoint();
import java.io.IOException;
        logger.trace("recovered max_seq_no [{}] and local_checkpoint [{}]", seqNoStats.maxSeqNo, seqNoStats.localCheckpoint);
     * @param versionType   the version type
                            get.getIfPrimaryTerm(),
     * @return the prepared index operation
     *
        }
                        Segment pendingSeg;
    ) {
     *
    }
     * Indexes a document into the engine. Handles sequence number assignment for primary
                    docsIngested += cs.get().getNumDocs();
                    }
    @Override
            } finally {
    public DocsStats docStats() {
        if (engineConfig.isEnableGcDeletes()) {
     *
                () -> {
        boolean onlyExpungeDeletes,
        if (engineConfig.getIndexSettings().isCheckPendingFlushEnabled() == false) {
     * {@link #onSettingsChanged} has not yet flipped the flag, so a request arriving in that window
    @Override
        boolean requiredFullRange,
                if (writerPool.isRegistered(lockedWriter)) {
            // 6. Create CombinedCatalogSnapshotDeletionPolicy
     */
import java.util.Objects;
                                    index.version(),
            if (deleteResult instanceof DeleteResult.Success) {
import org.opensearch.index.engine.dataformat.FlushInput;
        awaitPendingClose();
                    "writer generation [" + writer.generation() + "] retired with inconsistent buffer (state=" + postState + ")"
        if (activeBatch.get() == batch) {
                            // that flushed nothing adds none.
        }
     *
            IndexModule.TieringState tieringState = IndexModule.TieringState.valueOf(tieringStateStr);
            // Merge failure cleanup: cleans up unreferenced files and acts as a safety net
     * non-composite engines retain inline translog appends even when the prototype setting is present.
        return false;
            // so a stale precondition on a get (and therefore on an update of any committed
                while ((queuedWriter = flushQueue.poll()) != null) {
    @Override
            );
     */
        }
     * live-settings fallback also returns true for a shard opened mid-tiering (restart/relocation) —
                            get.id(),
    @Override
    }
                        preIndex();
     * Flushes the engine by refreshing buffered data to segments, persisting the catalog
            index.parsedDoc().getDocumentInput().addField(engineConfig.getMapperService().fieldType(SeqNoFieldMapper.NAME), index.seqNo());
                if (plan.earlyResultOnPreFlightError.isPresent()) {
                } finally {
    }
    private static boolean assertRetiredSegmentInvariants(Writer<?> writer, FileInfos retiredFileInfos) {
    public long lastRefreshedCheckpoint() {
                );
import org.opensearch.index.engine.exec.PrimaryTermFieldType;
            startTime,
        ensureDefaultPrimaryOperationPolicy(engineConfig);
import org.opensearch.common.queue.DefaultLockableHolder;
                    if (get.versionType().isVersionConflictForReads(versionValue.version, get.version())) {
    }
                deferred = true;
        refresh("write indexing buffer");
        return catalogSnapshotManager.getSafeCommitInfo();
            () -> new DefaultTranslogDeletionPolicy(
    public Engine.Delete prepareDelete(
            }
                try {
    // The scope used by the current bulk thread. Active scopes are also registered globally so refresh/commit can
                            index.getIfSeqNo(),
                new ReaderManagerConfig(
            assert committer != null : "committer must be initialized";
        int count = throttleRequestCount.incrementAndGet();
import org.opensearch.index.engine.exec.CatalogSnapshotLifecycleListener;
        if (policy != DefaultPrimaryOperationPolicy.INSTANCE) {
            }
                    } finally {
    /** {@inheritDoc} Delegates to {@link #refresh(String)} and always returns {@code true}. */
        } else {
                if (ex instanceof AlreadyClosedException) {
        } else {
    private boolean hasBeenProcessedBefore(Engine.Operation op) {
            return new GatedCloseable<>(reader, reader::close);
            failEngine("tragic event on indexing engine", engineTragic);
        this.documentLookupProvider = engineConfig.getDocumentLookupProvider();
    public void writeIndexingBuffer() throws EngineException {
        return statsCache.getSegments();
                location = translogManager.add(
            throw ioException;
                Writer<?> queuedWriter;
                return stats;
                if (store.tryIncRef()) {
                filesListeners,
    private final ConcurrentLinkedQueue<Segment> pendingSegments = new ConcurrentLinkedQueue<>();
        // A refresh is needed if there are operations since the last refresh
            updateAutoIdTimestamp(Long.MAX_VALUE, true);
     */
    private final AtomicBoolean unpublishedDeletes = new AtomicBoolean();
            } else {
        }
            throw new IllegalStateException(
    protected void pruneDeletedTombstones() {
    private boolean incrementVersionLookup() { // only used by asserts
            // The batch owns processed-checkpoint advancement (on flush) and persisted-checkpoint advancement (on the
            }
    private void updateAutoIdTimestamp(long newTimestamp, boolean unsafe) {
        return throttle.getThrottleTimeInMillis();
        this.refreshListeners = refreshListeners;
                if (index.origin() == Engine.Operation.Origin.PRIMARY) {
            } catch (Exception flushEx) {
        // A plugin can key its policy off an updatable setting, so the combination this engine rejects at
            if (documentLookupProvider == null) {
                                    // Release admitted rows even when a fully deleted generation produces no files.
     * the last merge finishes.
            @Override
        translogDeletionPolicy.setRetentionAgeInMillis(translogRetentionAge.millis());
            advanceMaxSeqNoOfUpdatesOrDeletes(delete.seqNo());
                            if (isClosed.get() || failedEngine.get() != null) {
    @Override
     * delete is appended as a delete; a failed one already holds an issued sequence number, so it is
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
     */
     * @param toSeqNo           the ending sequence number (inclusive)
                                new Committer.CommitInput(commitData.entrySet(), snapshot, 0)
        // This checks if the settings related to merge are changed and based on that updates the local variables in the class
                }
                    : "writer claimed checked-out but still registered in pool";
    }
            assert versionValue.term == primaryTerm : "primary term not matched; id="
                try (GatedCloseable<Reader> readerRef = acquireReader()) {
                        location = translogManager.add(new Translog.NoOp(noOp.seqNo(), noOp.primaryTerm(), noOp.reason()));
            return OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
            || index.origin() == Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY
        ensureDefaultPrimaryOperationPolicy(engineConfig);
    private final CounterMetric numVersionLookups = new CounterMetric();
            );
    // Shared get-by-id flow (parquet lookup + read version-conflict checks), common to all DataFormatAware* engines.
    }
        } catch (IOException | TranslogCorruptedException e) {
            return SeqNoGapFiller.fillGaps(localCheckpointTracker, translogManager, primaryTerm, noOp -> innerNoOp(noOp));
        if (Lucene.isCorruptionException(e)) {
        Engine.Operation.Origin origin,
        }
                        }
    private final ReleasableLock writeLock = new ReleasableLock(rwl.writeLock());
    @Override
                    // flush-on-retire threw). Fail the engine so recovery replays the translog.
            // We will pass IndexStoreProvider to this, which would contain store
                        triggerPossibleMerges(); // trigger merges
                    return;
        localCheckpointTracker.advanceMaxSeqNo(seqNo);
                                "refresh[{}]: indexingExecutionEngine.refresh took [{}ms] "
            : DocumentMetadataResolver.NOOP;
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;
                            commitData.put(Translog.TRANSLOG_UUID_KEY, translogManager.getTranslogUUID());
        }
    /** Returns the store. Visible for testing only. */
        if (engineConfig.isEnableGcDeletes()
     * @return a translog snapshot
                indexResult = new Engine.IndexResult(plan.version, index.primaryTerm(), index.seqNo(), plan.currentNotFoundOrDeleted);
import org.opensearch.index.mapper.Uid;
            doc,
            ensureNoTragicException();
        int reservedDocs = 0;
            this.lastRefreshedCheckpointListener = new LastRefreshedCheckpointListener(localCheckpointTracker);
            // fail the engine and let recovery replay the translog.
            try {
            failEngine("uncaught exception during indexing id[" + index.id() + "] seq#[" + index.seqNo() + "]", e);
            this.lastDeleteVersionPruneTimeMSec = engineConfig.getThreadPool().relativeTimeInMillis();
     * refresh, flush, and merge-result catalog commits (each with documented bypasses below).
            engineConfig.getPrimaryTermSupplier(),
        } finally {
import org.opensearch.index.engine.exec.WriterFileSet;
        SourceToParse source,
import org.opensearch.index.engine.exec.LiveDocsSource;
                + primaryTerm
                        indexResult = indexIntoEngine(index, plan);
            throw new RefreshFailedEngineException(shardId, ex);
                            index.origin(),
        if (acquiredHere) {
        return engineConfig;
            currentWriter.updateMappingVersion(mappingVersion);
        } catch (RuntimeException | IOException e) {
                "DataFormatAwareEngine does not support primary operation policy ["
    // Closed after refresh completes.
        }
        }
    /**
        return localCheckpointTracker.hasProcessed(op.seqNo());
     * Updates the retention settings for the translog deletion policy.
            statsWithDeleteBytes.add(cachedStats);
    private final EngineConfig engineConfig;
     * gap on a live engine where the index settings already reflect HOT_TO_WARM but
        @Override
    private final DeleteExecutionEngine<?> deleteExecutionEngine;
            if (reader == null) {
                statsWithoutFileSizes.addVersionMapMemoryInBytes(cachedStats.getVersionMapMemoryInBytes() + deleteRamBytes);
                engineConfig.getShardId(),
 * The OpenSearch Contributors require contributions made to
 */
            : "DataFormatAwareEngine only supports PRIMARY, LOCAL_TRANSLOG_RECOVERY, or LOCAL_RESET origins but got: " + delete.origin();
            shouldFreeze = false;
        } else if (seqNo == versionValue.seqNo) {
            this.mergeScheduler = new MergeScheduler(mergeHandler, this::applyMergeChanges, () -> {
                for (Map.Entry<DataFormat, WriterFileSet> entry : fileInfos.writerFilesMap().entrySet()) {
    @Override
                currentWriter
                        assert newSegments.stream().map(Segment::generation).distinct().count() == newSegments.size()
            this.deletionStrategyPlanner = new DeletionStrategyPlanner(
     * Verifies cross-format row-count parity on a retired writer's flushed segment.
        } else {
                        try (Releasable ignored = versionMap.acquireLock(uid)) {
import org.opensearch.index.mapper.SourceToParse;
    /**
     * This method is retained only to satisfy the {@link Engine} contract; calling it on DFA
        DocumentMapperForType docMapper,
                    // Include operations already applied by live bulk scopes in the checkpoint whenever possible. The
    }
            }
import java.util.concurrent.locks.Lock;
     * Begin a remote-store translog batch for the current bulk execution. Local-store composite indexes and all
            synchronized (versionMap) {
import java.util.concurrent.atomic.AtomicInteger;
            }));
        } finally {
    @Override
     * @param source      a descriptive label for the caller
        boolean upgrade,
    @Override
                return new Engine.DeleteResult(plan.version, delete.primaryTerm(), delete.seqNo(), plan.currentlyDeleted == false);
    /**
            delete = new Engine.Delete(
                }
            // the next ordinary refresh.
        boolean isRetry,
package org.opensearch.index.engine;
        }
     *   <li>{@link #triggerPossibleMerges()} becomes a no-op</li>
        assert noOp.seqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO : "noOp must have an assigned seqNo: " + noOp;
    }
                this::hasBeenProcessedBefore,
                mergeScheduler.unfreeze();
            }
    Exception getFailedEngine() {
                store.shardPath(),
     *
        int count = throttleRequestCount.decrementAndGet();
        return translogManager.newChangesSnapshot(fromSeqNo, toSeqNo, requiredFullRange);
     * HOT, so there is no separate transient state to freeze on here.
                                throw new IOException("Refresh interrupted waiting for flush completion", e);
        } else {
        }
    }
                    return;
    }
        if (deferred == false) {
            failEngine("already closed by tragic event on the translog", translogManager.getTragicExceptionIfClosed());
    public void onMergesDrained(Runnable listener) {
 *   <li>Translog management for durability and recovery</li>
                    }
 * compatible open source license.
     * @throws IOException if the engine or translog write fails
    @Override
     * @throws IllegalStateException if global checkpoint does not match max seq no
    @Override
     * @param version       the expected version
            statsWithDeleteBytes.addVersionMapMemoryInBytes(deleteRamBytes);
            // Same decision as a per-operation translog failure in index(): fail the engine only if the exception is the
        return versionMap.getUnderLock(id);
    private void finalizeDelete(Engine.Delete delete, Engine.DeleteResult deleteResult) throws IOException {
                            final long engineRefreshElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - engineRefreshStartNanos);
     */
                                }
                filesListeners.put(entry.getKey().name(), entry.getValue());
            return OpVsEngineDocStatus.OP_NEWER;
                    return Collections.emptyMap();
            );
        maybePruneDeletes();
            logger.debug("forceMerge blocked — engine is frozen for tiering");
        }
                            }
                writerPool.releaseAndUnlock(lockedWriter);
        } finally {
                            "refresh[{}]: flushed {} writers producing {} new segments in [{}ms]",
                        this.activeFlushLatch = null;
                            Committer.CommitResult commitResult = committer.commit(
        } finally {
     * appended as a no-op to keep recovery gap-free (mirroring the indexing path).
            DeleteResult deleteResult = deleteExecutionEngine.deleteDocument(
                location = null;
     * Fails the engine with the given reason and optional exception. Acquires the fail
import org.apache.logging.log4j.message.ParameterizedMessage;
            // is updated. For merges that do not invoke the hook — pure Parquet merges, or
                unpublishedDeletes.set(true);
    /** Returns the writers in the pool. Visible for testing only. */
        translogDeletionPolicy.setRetentionSizeInBytes(translogRetentionSize.getBytes());
                try {
                    // over-claim those ops, so a subsequent recovery/relocation would start replay
        }
                );
                    if (plan.executeOpOnEngine) {
     */
        }
                engineConfig.getShardId(),
        }
                    indexResult = (Engine.IndexResult) plan.earlyResultOnPreFlightError.get();
    private final TranslogManager translogManager;
     * though the constructor already covers that — and, more importantly, closes the apply-ordering
                    long gen = writerGenerationCounter.incrementAndGet();
                    config().getMapperService(),
        if (includeSegmentFileSizes) {
                        } else if ("flush".equals(source)) {
 *   <li>Throttling when merges fall behind or indexing buffer is full</li>
 * underlying data format engine and the translog.
     *
                            }
                } finally {
            assert index.origin().isFromTranslog() == false || indexResult.getTranslogLocation() == null
                    writerCheckedOut = true;
        @Override
    // Refresh thread awaits this before proceeding with catalog commit.
    }
            try {
        }
    }
                e.addSuppressed(inner);
        if (translogManager.getTragicExceptionIfClosed() != null) {
                localCheckpointTracker::getProcessedCheckpoint,
                                pendingRowCount.addAndGet(-rowsToRelease);
                    refresh("flush");
     * Returns 0 because DataFormatAwareEngine has no in-flight write state visible to the IMC.
     * is created via the indexing execution engine's {@code newDocumentInput()} method.
    }
    }
                logger.info("Unfreezing engine — tiering cancelled, resuming normal operations");
     * @param delete the delete operation
                            commitData.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, snapshot.serializeToString());
                    "flush failed retiring writer generation [" + writer.generation() + "]; buffered acked docs lost",
                closeReaders();
            for (Map.Entry<DataFormat, WriterFileSet> entry : retiredFileInfos.writerFilesMap().entrySet()) {
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {
import org.opensearch.index.engine.dataformat.FileInfos;
     */
                maybeFailEngine("delete", e);
     */
                                versionMap.putIndexUnderLock(
                    batch.abort(closeFailure);
                                    doc.seqNo(),
        if (delete.origin() == Engine.Operation.Origin.PRIMARY) {
                }
            // Encapsulate refreshLock access behind a pre-merge-commit hook: committer-owned
            if (frozenForTiering.compareAndSet(false, true)) {
            // translog's tragic event (or an AlreadyClosedException over one); otherwise only the request fails.
            if (deleteExecutionEngine.onWriterCheckedOut(writerToFlush.generation())) {
                    "Reader for format [" + format.name() + "] is " + reader.getClass().getName() + ", expected " + readerType.getName()
            .getSettings()
import org.opensearch.index.engine.dataformat.merge.DataFormatAwareMergePolicy;
                flushLock.lock();
                return true;
                    assert versionValue.seqNo >= 0 : versionValue;
        if (upgrade || upgradeOnlyAncientSegments || onlyExpungeDeletes) {
                // Discard any pending segments not yet picked up by refresh
                            assert commitData.containsKey(CatalogSnapshot.CATALOG_SNAPSHOT_KEY) : "commit data missing catalog snapshot";
        DefaultLockableHolder<Writer<?>> lockedWriter = writerPool.getAndLock(h -> h.get().state() == WriterState.ACTIVE);
            try {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
     * carries the richer {@link CatalogSnapshot} that describes multi-format segments.
                retiredFileInfos = writer.flush(FlushInput.EMPTY);
    private final AtomicLong maxSeqNoOfUpdatesOrDeletes;
                    refreshLock.lock();
                    logger.trace(
                    // snapshot. Committing the live (post-refresh) processed checkpoint would
    }
                long insertionRowId = ((RowIdAwareWriter<?>) currentWriter).docCount() - 1;
    // directories must remain on disk until refresh incorporates them via addIndexes.
                SequenceNumbers.max(localCheckpointTracker.getMaxSeqNo(), translogManager.getMaxSeqNo())
                    }
            try (
                + seqNo
    private void closeReaders() throws IOException {
     * After this call:
        return new Engine.Delete(id, uid, seqNo, primaryTerm, version, versionType, origin, startTime, ifSeqNo, ifPrimaryTerm, routing);
    }
        logger.debug("refresh[{}]: total time to make documents searchable [{}ms] refreshed={}", source, totalRefreshElapsedMs, refreshed);
     * When {@code flush} is true, a full flush is performed first to ensure all in-flight
     * Appends every live bulk scope's pending chunk so that a refresh or flush publishes no row whose translog record
            localCheckpointTracker.markSeqNoAsProcessed(indexResult.getSeqNo());
            // and any index specific attributes useful for reads.
    }
                    indexingExecutionEngine.getNativeBytesUsed(),
    private Engine.DeleteResult executeDeletePlan(Engine.Delete delete, DeletionStrategy plan) throws IOException {
    }
                            index.isRetry(),
            final long deleteRamBytes = deleteExecutionEngine.ramBytesUsed();
        return engineConfig.getMapperService().documentMapper().getVersion();
                    indexingExecutionEngine.getDataFormat(),
        return false;
            isRetry,
                latch.countDown();
                IndexModule.INDEX_TIERING_STATE.getKey(),
        } else if (failedEngine.get() == null && isClosed.get() == false) {
 * This engine manages the full lifecycle of indexing,
    ) throws EngineException, IOException {
        assert rwl.getReadHoldCount() > 0 || rwl.isWriteLockedByCurrentThread() : "innerNoOp requires a read or write lock";
    }
    /**
                this.versionMap,
        for (ReferenceManager.RefreshListener refreshListener : refreshListeners) {
                    closeNoLock("engine failed on: [" + reason + "]");
            return innerNoOp(noOp);
         * Returns the reader for the given format, validated against the expected type.
import java.util.concurrent.ConcurrentHashMap;
                op -> OpVsEngineDocStatus.OP_NEWER,
                if (isClosed.get() == false) {
            documentCountTracker.releaseInFlightDocs(reservedDocs);
    @Override
    }
    @Override
        }
            refreshLock.unlock();
     * The prepare action explicitly calls freezeForTiering() while the index is still
                failEngine("Merge failed while registering merged files in Snapshot", ex);
        long primaryTerm,
            }
import org.opensearch.index.engine.exec.commit.CommitterConfig;
import org.opensearch.common.util.concurrent.ReleasableLock;
     */
     */
     * @param engineConfig the engine configuration
            )
        try (Releasable ignored = writerPool.checkout(lockedWriter)) {
                }
        String state = engineConfig.getIndexSettings()
                }
        return catalogSnapshotManager.acquireCommittedSnapshot(true);
     * <p>
                            // recovery
    }
        boolean deletesApplied = false;
                if (e instanceof AlreadyClosedException || translogManager.getTragicExceptionIfClosed() != null) {
     * @return the delete result
            // Translog-origin operations must NOT be written back to the translog (would cause duplicates)
                new DeleteInput(IdFieldMapper.NAME, delete.id(), currentWriter.generation()),
     * delegates to the {@link IndexingExecutionEngine#refresh} to incorporate segments,
            );
            maxUnsafeAutoIdTimestamp.updateAndGet(curr -> Math.max(curr, newTimestamp));
        numIndexVersionsLookups.inc();
        return engineConfig.getIndexSettings().getGcDeletesInMillis();
    private final DocumentLookupSupport documentLookup;
     * Refreshes the engine to make recently indexed documents searchable.
                    flush(false, true);
        TranslogDeletionPolicy deletionPolicy,
     *
     * appended when the op originated outside the translog itself.
        }
            }
        }
            assert index.origin().isFromTranslog()
                // Hold refreshLock across the whole flush so a concurrent refresh cannot advance
                                    + " dropped "
                    registry,
        assert count >= 0 : "invalid post-decrement throttleRequestCount=" + count;
     * <p>
    @Override
                return result.exists() ? result.toGetResult() : Engine.GetResult.NOT_EXISTS;
        if (frozenForTiering.compareAndSet(false, true)) {
            this.catalogSnapshotManager = new CatalogSnapshotManager(
     * precedes the delete of the same document) whichever path the caller took.
     * <p>
    @Override
        }
            final long persistedCheckpoint = localCheckpointTracker.getPersistedCheckpoint();
        updateAutoIdTimestamp(newTimestamp, true);
        }
                            index.origin(),
    public long getIndexThrottleTimeInMillis() {
    }
    public Engine.IndexResult index(Engine.Index index) throws IOException {
                        store.decRef();
            indexResult.freeze();
            lockedWriter = writerPool.getAndLock(h -> {
        // DataFormatAwareEngine is the writable primary-side engine. Read-only replicas
            IOException ioException = new IOException("Failed to close DataFormatAwareEngine resources");
                                    true,
                        List<DefaultLockableHolder<Writer<?>>> writers = writerPool.checkoutAll();
            // 7. Create CatalogSnapshotManager (fully wired)
        }
            );
            } catch (IOException deleteEx) {
     */
                    assert isClosed.get() : "engine must be closed after failEngine";
        return indexingExecutionEngine;
        } finally {
                this::acquireSnapshot,
                            toClose.add(writerToFlush);
    public Closeable acquireHistoryRetentionLock() {
        if (engineConfig.getCustomTranslogDeletionPolicyFactory() != null) {
            throw new IllegalStateException(
            custom,
    private volatile long lastWriteNanos = System.nanoTime();
    }
                        committer.markStoreCorrupted(
         *
                DocumentLookupResult result = documentLookup.getById(get, readerRef.get());
            result.setTranslogLocation(location);
            }
                            if (rowsToRelease > 0L) {
        @Override
        try (ReleasableLock ignored = readLock.acquire()) {
        TranslogDeletionPolicy custom = null;
    public void maybePruneDeletes() {
                                        writerToFlush.generation(),
    public Engine.TranslogBatch beginTranslogBatch() {
                config().getShardId(),
                            rowsToRelease += pendingSeg.dfGroupedSearchableFiles().values().stream().findFirst().get().numRows();
        if (plan.executeOpOnEngine == false && plan.addStaleOpToEngine == false) {
            lastWriteNanos = delete.startTime();
            if (result instanceof WriteResult.Success) {
        assert newTimestamp >= -1 : "invalid timestamp [" + newTimestamp + "]";
            final TranslogEventListener translogEventListener = createInternalTranslogEventListener();
    }
    }
                        // (by itself + write threads cooperatively).
                        );
    private final String historyUUID;
import org.opensearch.index.get.DocumentLookupResult;
                // but we only need to do this once since the last operation per ID is to add to the version
                    try (GatedConditionalCloseable<CatalogSnapshot> snapshotRef = catalogSnapshotManager.acquireSnapshotForCommit()) {
        return indexResult;
            ifSeqNo,
    }
                                    writerFlushElapsedMs,
    /**
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
        public void close() {
                                    + rowsToRelease
            TranslogOperationHelper.create(engineConfig)
     * operations, the sequence number is marked as seen and the operation proceeds directly.
        mergeScheduler.onDrained(listener);
    private void flushActiveBatchBeforeInlineWrite() {
            FileInfos retiredFileInfos;
            localCheckpointTracker.markSeqNoAsPersisted(deleteResult.getSeqNo());
                    snapshot
            refreshLock.lock();
import org.opensearch.index.engine.dataformat.RowIdAwareWriter;
    @Override
     * The caller must close the returned reader when done, which releases the
                                        entry.getValue().files()
 *   <li>Refresh to make documents searchable via catalog snapshots</li>
        refreshListeners.add(versionMap);
                                org.opensearch.ExceptionsHelper.unwrapCorruption(failure)
import org.opensearch.index.engine.dataformat.Writer;
            // RETIRED_FLUSHABLE: flush the buffered N-1 docs. A throw here loses those acked
    }
        }
                            flushQueue.add(lockable.get());
                    return null;
        versionMap.enforceSafeAccess();
            }
            throw ex;
    @Override
            boolean hasFiles = false;
                    }
    }
                final Engine.IndexResult indexResult;
            final Translog.Location location;
        );
     * @throws IOException if reading the translog fails
                dataFormatAwareMergePolicy,
                    delete.primaryTerm(),
/*
import org.opensearch.index.engine.dataformat.merge.MergeHandler;
        try (ReleasableLock ignored = readLock.acquire()) {
            // which applies read-time version/if_seq_no conflicts to the result — the realtime
        this.logger = Loggers.getLogger(DataFormatAwareEngine.class, engineConfig.getShardId());
    @Override
    }
        try {
                SegmentsStats stats = statsCache.buildSegmentsStats(
        return failedEngine.get();
                                    + " for shard: "
            FileInfos fileInfos = writerToFlush.flush(FlushInput.EMPTY);
/**
                            translogManager.syncTranslog();
        if (count == 1) {
                : "translog-origin op should not have a translog location";
                throw new FlushFailedEngineException(shardId, e);
import org.apache.lucene.index.IndexCommit;
     *
            try {
            @Override
        boolean shouldFreeze;
    ) throws IOException {
        List<Closeable> toClose = new ArrayList<>();
    @Override
        long version,
     * @param primaryTerm   the primary term
import org.opensearch.index.mapper.VersionFieldMapper;
                )
                delete.startTime(),
            }
     * TODO: Remove this flag once merge implementations are complete for all data formats.
            ensureOpen();
        maxSeenAutoIdTimestamp.updateAndGet(curr -> Math.max(curr, newTimestamp));
            return translogManager.shouldPeriodicallyFlush(
    private TranslogDeletionPolicy getTranslogDeletionPolicy() {
                failedEngine.set(failure != null ? failure : new IllegalStateException(reason));
    }
        }
    private TranslogEventListener createInternalTranslogEventListener() {
                        } catch (IOException e) {
    @Override
     * appends a Translog.NoOp. No tombstone is written — DataFormatAwareEngine has no
        ensureOpen();
                            }
                            index.seqNo(),
     *
                            // Dropped generations may release rows without publishing segments.
                maybeFailEngine("flush", e);
                try {
                            commitData.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(snapshot.getId()));
     * write — keeping the indexing hot path free of cross-component state checks.
            shardId,
                logger.info("Freezing engine for tiering — blocking merges, refresh, flush, and catalog commits");
                localCheckpointOfLastCommit,
        return catalogSnapshotManager.serializeToCommitFormat(catalogSnapshot);
        ensureOpen();
     * @param translogRetentionAge   the maximum age for translog files
        assert delete.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + delete.origin();
            final long flushElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - flushStartNanos);
                            assert commitData.containsKey(Engine.HISTORY_UUID_KEY) : "commit data missing history UUID";
                lastCommitData.getOrDefault(SequenceNumbers.LOCAL_CHECKPOINT_KEY, "-1")
                WriteResult.Failure f = (WriteResult.Failure) result;
     * (writer stays in the pool); RETIRED_FLUSHABLE checks the writer out, flushes the buffered
                                    writerToFlush.generation(),
                    } else {
                }
            );
                batch.flush();
        TranslogEventListener translogEventListener
     * {@link #onSettingsChanged} (when INDEX_TIERING_STATE transitions to HOT_TO_WARM),
                            indexResult.getFailure().toString()
        try (GatedCloseable<CatalogSnapshot> oldSnapshotRef = catalogSnapshotManager.acquireSnapshot()) {
                        Map<String, String> lastCommitData = committer.getLastCommittedData();
        if (isFrozenForTiering()) {
        refresh(source);
        }
                        final long flushAllElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - flushAllStartNanos);
            activeBatch.remove();
        boolean refreshed = false;
                ex.addSuppressed(inner);
                        // Replica and recovery operations must arrive with a pre-assigned sequence number
            while (snapshot.next() != null) {
            );
            engineConfig.getTranslogConfig(),
                            versionValue.seqNo,
                            assert snapshot.getId() >= 0 : "snapshot ID must be non-negative but was: " + snapshot.getId();
                        + "] has "
                                    continue; // re-check isClosed / failedEngine
    private void preIndex() {
import org.opensearch.common.queue.LockablePool;
            } catch (Exception inner) {
    private LocalCheckpointTracker createLocalCheckpointTracker(BiFunction<Long, Long, LocalCheckpointTracker> supplier)
                                Thread.currentThread().interrupt();
        }
            if (cachedStats.getFileSizes() != null && cachedStats.getFileSizes().isEmpty() == false) {
        assert mergeResult != null : "merge result must not be null";
import org.opensearch.index.engine.dataformat.DeleteInput;
        } catch (RuntimeException | IOException e) {
                final IndexVersionValue.PendingLocation pending = new IndexVersionValue.PendingLocation(batch);
     * sequence-number, translog, checkpoint, and version-map state.
        }
     */
                                deletesApplied |= deleteExecutionEngine.onWriterCheckedOut(retiringWriter.generation());
            batch.flush();
            // 5. Create IndexingExecutionEngine and ReaderManagers
            // refresh only if new segments have been created or force param is true
                // Close any writers queued for deferred close (their files won't reach the catalog)
            FileDeleter fileDeleter = indexingExecutionEngine::deleteFiles;
                                refreshed |= hasFiles;
        assert operation.seqNo() == UNASSIGNED_SEQ_NO : "ops should not have an assigned seq no. but was: " + operation.seqNo();
                CatalogSnapshot snapshot = snapshotRef.get();
            store.incRef();
                    IOUtils.closeWhileHandlingException(pendingWriter);
                                throw e;
            Map<String, FilesListener> filesListeners = new HashMap<>();
import org.opensearch.index.engine.exec.EngineReaderManager;
            throw new AssertionError("Unexpected AlreadyClosedException", ex);
        if (batch != null) {
     */
            );
    /**
                || indexResult.getResultType() != Engine.Result.Type.SUCCESS
            SegmentsStats statsWithDeleteBytes = new SegmentsStats();
            }
                    failOnTragicEvent((AlreadyClosedException) ex);
    @Override
                        // Every new segment must contain files from at least one data format
                throw new RuntimeException("Failed to release catalog snapshot reference", e);
     * per-format reader on the current snapshot and passing it to the plugin.
    /**
            // Lucene merges that skip because the shared writer has no matching segments —
                            commitData.put(Engine.HISTORY_UUID_KEY, historyUUID);
     * Called before each index operation on the write thread. If the shared flush queue
            throw e;
    }
                                IOUtils.closeWhileHandlingException(writerToFlush);
                mergeScheduler.freeze();
import java.util.concurrent.ConcurrentLinkedQueue;
     * <p>
    private void updateTieringFreezeState() {
     * is at most the processed checkpoint (the single trimming strategy used by {@code InternalEngine}, correct
    public int getActiveMergeCount() {
                                Segment.Builder segmentBuilder = Segment.builder(writerToFlush.generation());
        } catch (Exception e) {
        }
                            flushAllElapsedMs
            }
        } // readLock
                            assert commitData.containsKey(SequenceNumbers.LOCAL_CHECKPOINT_KEY) : "commit data missing local checkpoint";
        boolean writerCheckedOut = false;
    }
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
        return lastWriteNanos;
        long version,
            // immediately before the merged segment becomes visible. When Lucene participates
                                FileInfos fileInfos = writerToFlush.flush(FlushInput.EMPTY);
            if (deleteResult.getResultType() == Engine.Result.Type.SUCCESS) {
    @Override
     * Registers a listener that fires when all in-flight merges have completed.
        }
    }
        this.documentLookup = new DocumentLookupSupport(shardId, this.documentLookupProvider, this.documentMetadataResolver);
                        // New segment generations must not collide with existing segment generations
                        // Wait for any writers that write threads picked up to finish.
                documentCountTracker::tryAcquireInFlightDocs
                try {
            snapshotRef.close();
                        while ((pendingWriter = pendingWritersToClose.poll()) != null) {
    /** Returns the failed engine exception, or null. Visible for testing only. */
                            newSegments.size(),
    private final DocumentLookupProvider documentLookupProvider;
import org.opensearch.index.mapper.ParsedDocument;
            } finally {
     * @param listener the callback to fire when merges are drained
                Writer<?> w = h.get();
        return true;
        }
            // applyMergeChanges acquires refreshLock itself. Either way, applyMergeChanges
                long docsIngested = pendingRowCount.get();
import org.opensearch.index.mapper.IdFieldMapper;
            if (batch != null && indexResult.getResultType() == Engine.Result.Type.SUCCESS) {
            writers.add(holder.get());
    private final List<ReferenceManager.RefreshListener> refreshListeners;
            index.parsedDoc().getDocumentInput().addField(engineConfig.getMapperService().fieldType(VersionFieldMapper.NAME), plan.version);
        long toSeqNo,
        final boolean acquiredHere = refreshLock.isHeldByCurrentThread() == false;
            // 4. Initialize local checkpoint tracker
    }
        // background merge in a format's underlying writer turns tragic between an entry-time
    }
                            flushActiveTranslogBatches();
            throw new IllegalStateException("a translog batch is already active on this bulk thread");
            if (latch != null) {
                            );
                                    "refresh[{}]: writer gen={} flush took [{}ms] hasFiles={}",
    @Override
     * @param ifPrimaryTerm            the conditional primary term
    @Override
     * @param fromSeqNo   the starting sequence number (inclusive)
     */
                logger.warn("failed to close engine resources", e);
                        new IndexVersionValue(location, indexResult.getVersion(), index.seqNo(), index.primaryTerm())
        return translogManager.getLastSyncedGlobalCheckpoint();
        ensureOpen();
            }
        Exception engineTragic = indexingExecutionEngine.getTragicException();
import org.apache.lucene.index.Term;
                delete.uid().bytes(),
            origin,
                    );
                                .filter(seg -> result.droppedGenerations().contains(seg.generation()) == false)
                            // and available to the deletion policy when onCommit is triggered.
                            index.primaryTerm(),
    private long currentMappingVersion() {
            // means we don't know the writer's buffer state and cannot safely retire it —
                + id
import java.util.Set;
            } catch (Exception e) {
                        }
    }
                            } catch (Exception e) {
    @Override
        return mergeScheduler.stats();
     * @param requiredFullRange whether the full range must be present
                        }
            assert translogManager != null : "translog manager must be initialized";
                    store.decRef();
     */
     *
            return Engine.NO_OP_TRANSLOG_BATCH;
                            // A refresh that published segments must have rows to release; a pure delete
    private void restoreVersionMapAndCheckpointTracker() {
    public boolean hasPendingMerges() {
        flushActiveBatchBeforeInlineWrite();
                        + rows
                SegmentsStats statsWithoutFileSizes = new SegmentsStats();
                            // is a thread that has written its row to the writer but not yet called batch.add; the
                    // Notify stats cache that flush completed to refresh committed state
            }
                            index.getIfPrimaryTerm()
                            new IOException(
        try {
                        currentWriter
            );
import java.util.Map;
                    assert gen > 0 : "merge generation must be positive but was: " + gen;
    @Override
            this.documentCountTracker = new DocumentCountTracker(shardId, () -> {
    /**
            this::onTranslogBatchFinished,
                Object reader = entry.getValue().getReader(catalogSnapshot);
                            final long engineRefreshStartNanos = System.nanoTime();
                }
                    for (Segment seg : initSnapshots.getLast().getSegments()) {
    @Override
        // (segment-rep) and warm-tier shards must use a read-only engine instead — fail
                    assert index.seqNo() >= 0 : "ops should have an assigned seq no.; origin: " + index.origin();
            || delete.origin() == Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY
        }
                + " existing_term="
        } else if (e != null && translogManager.getTragicExceptionIfClosed() == e) {
                            commitData.put(MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, Long.toString(maxUnsafeAutoIdTimestamp.get()));
    }
        GatedCloseable<CatalogSnapshot> snapshotRef = catalogSnapshotManager.acquireSnapshot();
        return null;
                    }
            Writer currentWriter = lockedWriter.get();
    }
                VersionValue versionValue;
            "acquireSafeIndexCommit is not supported on DataFormatAwareEngine; use acquireSafeCatalogSnapshot instead"
                }
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException {
                            assert commitData.containsKey(SequenceNumbers.MAX_SEQ_NO) : "commit data missing max seq no";
                refreshLock.unlock();
                shardId,
     */
    }
            markSeqNoAsSeen(delete.seqNo());
        }
     * @param source            a descriptive label for the caller
        assert (index.origin() == Engine.Operation.Origin.PRIMARY
                statsWithoutFileSizes.addIndexWriterMemoryInBytes(cachedStats.getIndexWriterMemoryInBytes());
    public static class DataFormatAwareReader implements IndexReaderProvider.Reader {
            ensureOpen();
                // Fall back to 0 on error
    @Override
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {
    private final ReentrantLock failEngineLock = new ReentrantLock();
    private void flushActiveTranslogBatches() {
            }
     * @param index the index operation containing the parsed document, version, and origin
     *
                                Translog.Index index = (Translog.Index) operation;
            for (ReferenceManager.RefreshListener refreshListener : refreshListeners) {
            try {
            this.refreshListeners.add(this.statsCache);
        );
            this.writerGenerationCounter = new AtomicLong(maxGenFromCommit);
                                    + shardId;
                        }
                        lastRefreshedCheckpointListener.updateRefreshedCheckpoint(localCheckpointBeforeRefresh);
        boolean flush,
        Engine.Operation.Origin origin,
            statsCache.forceRefresh();
            Object reader = readers.get(format);
                        localCheckpointTracker.markSeqNoAsPersisted(doc.seqNo());
            translogManager,
    private TranslogManager createTranslogManager(
                        // Drain any segments flushed by write threads (via preIndex)
                            );
    // drained cooperatively by both the refresh thread and write threads (backpressure).
        if (plan.executeOpOnEngine) {
     * @param accurateCount     unused
                // This prevents under-accounting
    private long generateSeqNoForOperationOnPrimary(final Engine.Operation operation) {
    }
    private Engine.IndexResult indexIntoEngine(Engine.Index index, IndexingStrategy plan) throws IOException {
            localCheckpointTracker.markSeqNoAsPersisted(noOp.seqNo());
                IOUtils.close(toClose);
        // verbose is Lucene-specific (RAM tree breakdown per segment) — not applicable to DFAE, ignored.
    public EngineConfig config() {
            try {
                        );
     * @param isRetry                  whether this is a retry
            || engineConfig.getIndexSettings().isRemoteStoreEnabled() == false
    public String getHistoryUUID() {
                            index.parsedDoc(),
                }
    @Override
                }
                && (engineConfig.getThreadPool().relativeTimeInMillis()
                                    Map.of(),
                    + engineConfig.getIndexSettings().isWarmIndex()
            for (ReferenceManager.RefreshListener refreshListener : refreshListeners) {
    }
        try {
        // merge: the Lucene committer's MergedSegmentWarmer acquires it between mergeMiddle and
            if (currentWriter.state() != WriterState.ACTIVE) {
                                }
    private final Lock flushLock = new ReentrantLock();
        public CatalogSnapshot catalogSnapshot() {
                }
                    close();
                        }
                            logger.trace("refresh[{}]: catalogSnapshot commit took [{}ms]", source, commitElapsedMs);
                            : "new segments must have at least one format's files";
            );
    }
                throw new IllegalStateException(
                closeNoLock("api");
    /**
     * @return a gated closeable wrapping the reader
            return count;
            throw e;
                    logger.debug("engine closed [{}]", reason);
        Objects.requireNonNull(versionValue);
        // DataFormatAwareEngine is the primary-side engine in a segment-replication cluster.
     */
    /** {@inheritDoc} Activates write throttling when merge pressure increases. */
                                if (hasFiles) {
            refreshListeners.addAll(engineConfig.getExternalRefreshListener());
                documentCountTracker::tryAcquireInFlightDocs,
    @Override
     * <p>
            return;
                engineConfig.getIndexSettings().getMergePolicy(true),
                                "failed engine (reason: [" + reason + "])",
    private Engine.Delete generateSeqNoForDelete(Engine.Delete delete) {
    // TODO Refactor these flush managing activities into FlushManager.
                    closedLatch.countDown();
     * @throws IOException if flush or close fails
                    + ", warm="
    // or by failure-handling retirement (retireWriterIfNeeded). Drained by the next refresh().
                return null;
    public Engine.Delete prepareDelete(
            maybeFailEngine("index id[" + index.id() + "] origin[" + index.origin() + "]", e);
        return indexingExecutionEngine.getHeapBytesUsed() + deleteExecutionEngine.ramBytesUsed();
                        return Engine.GetResult.NOT_EXISTS;
                        localCheckpointTracker.markSeqNoAsProcessed(doc.seqNo());
     *
        return new TranslogEventListener() {
     */
        assert index.primaryTerm() > 0 : "primary term must be positive but was: " + index.primaryTerm();
            flush(false, true);
            flush(true, true);
        return supplier.apply(seqNoStats.maxSeqNo, seqNoStats.localCheckpoint);
    @Nullable
                    + "]; pluggable data format cannot be combined with a non-default primary operation policy"
                // First get active writes as active writes are only reduced after catalog snapshot refresh
        Map<DataFormat, WriterFileSet> filesMap = retiredFileInfos.writerFilesMap();
                        }
                        // Add all checked-out writers to the shared flushQueue with a latch
     * points so a tragic event surfaces on the next maintenance op rather than on a doc
                            }
                this::updateAutoIdTimestamp,
        final Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(id));
            shardId,
    }
                // Stop accepting new merges immediately
            public void onAfterTranslogSync() {
    @Override
     * @param ifSeqNo                  the conditional sequence number
        long expectedRows = filesMap.values().iterator().next().numRows();
                    final long committedLocalCheckpoint = localCheckpointTracker.getProcessedCheckpoint();
            return statsWithDeleteBytes;
            doc.addDynamicMappingsUpdate(docMapper.getMapping());
            indexResult.setTook(System.nanoTime() - index.startTime());
        // op, defer its translog append into the batch. The version, seqNo and term are already known; only the
            if (holder.get() == writer) {
                delete.getIfPrimaryTerm()
        String id,
                } else {
        } finally {
    private final ShardId shardId;
                assert writerCheckedOut == false || writerPool.isRegistered(lockedWriter) == false
        public Object reader(DataFormat format) {
     * Only freezes for HOT_TO_WARM (actual data migration in progress).
                                }
import org.opensearch.index.mapper.SeqNoFieldMapper;
        if (isClosed.get() == false) {
import org.opensearch.index.engine.dataformat.RefreshInput;
        return catalogSnapshotManager.acquireCommittedSnapshot(false);
                            ensureOpen(); // short-circuit if engine has failed/closed concurrently
                        + entry.getKey().name()
                            index.startTime(),
            }
                            if (curr == null
                return statsWithoutFileSizes;
                }
                } catch (IllegalStateException bufferLoss) {
            return true;
            translogUUID,
            try {
        } catch (AlreadyClosedException ex) {
                    inner.addSuppressed(failure);
                location = translogManager.add(new Translog.Delete(delete, deleteResult));
                    // Refresh first to flush buffered data to segments
                }
    private final DeletionStrategyPlanner deletionStrategyPlanner;
     * {@code segments_N} disk read required to materialize a Lucene {@link IndexCommit}, and
        // data available to read on internal refreshes on replica.
        for (DefaultLockableHolder<Writer<?>> holder : writerPool) {
        if (engineTragic != null) {
     * Always called inside an {@code assert} so the map walk is stripped when assertions are disabled.
                            final List<Segment> finalSegments = result.refreshedSegments()
        return maxSeqNoOfUpdatesOrDeletes.get();
                delete.version(),
                } finally {
                    plan = indexingStrategyPlanner.planOperationAsNonPrimary(index);
    @Override
     * </ul>
        }
        } finally {
                    IndexVersionValue.withPendingLocation(pending, indexResult.getVersion(), index.seqNo(), index.primaryTerm())
    }
     */
                            if (refreshed) {
     */
    /**
import org.opensearch.index.engine.dataformat.merge.OneMerge;
    }
            this.statsCache = new CatalogSnapshotStatsCache(catalogSnapshotManager, store, engineConfig, () -> {
    }
                    committer,
        }
    }
                    // Delegate corruption marking to the committer (same as Engine.java's intent)
        return true;
        }
                "Global checkpoint [" + globalCheckpoint + "] mismatches maximum sequence number [" + maxSeqNo + "]"
                    statsCache.onFlushCompleted();
     * @param ifPrimaryTerm the conditional primary term
     * Prunes delete tombstones from the version map: those older than one GC-delete cycle whose sequence number
                                    get.id(),
            }
        final TranslogDeletionPolicy translogDeletionPolicy = translogManager.getDeletionPolicy();
            if (lookupResult.version() != Versions.NOT_FOUND) {
        long ifSeqNo,
                }
                this::hasBeenProcessedBefore,
    @Override
            }, shardId, engineConfig.getIndexSettings(), engineConfig.getThreadPool());
                                        "Writer gen={} flushed format=[{}] files={}",
            } else {
                throw e;
        // includeUnloadedSegments is a Lucene concept (segments on disk not yet loaded into a SegmentReader).
                        assert index.seqNo() >= 0 : "recovery or replica ops should have an assigned seq no.; origin: " + index.origin();
            this.readers = readers;
     * operation. The parsed document's {@link org.opensearch.index.engine.dataformat.DocumentInput}
    }
                    - ((DeleteVersionValue) versionValue).time) > getGcDeletesInMillis()) {
                "Unrecognized {} value [{}]; treating engine as not frozen for tiering",
            Writer<?> currentWriter = lockedWriter.get();
    }
                            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(localCheckpointTracker.getMaxSeqNo()));
    }
                try {
    /**
                    + engineConfig.isReadOnlyReplica()
        // serialise the catalog update against concurrent refreshes. Always release on exit.
            this.catalogSnapshotManager.bumpGeneration();
                mergeScheduler.shutdown();
     *
    /**
                            if (retiring instanceof Writer<?> retiringWriter) {
    }
    }
    private volatile CountDownLatch activeFlushLatch;
                    segmentBuilder.addSearchableFiles(entry.getKey(), entry.getValue());
     * @return the index result with sequence number, version, and translog location
        return localCheckpointTracker.getStats(globalCheckpoint);
     * Throws {@link UnsupportedOperationException} if no plugin is wired.
        // the inline markSeqNoAsProcessed / markSeqNoAsPersisted tail below for a deferred op. Deletes and NoOps stay
                committer
        if (Booleans.parseBoolean(System.getProperty(MERGE_ENABLED_PROPERTY, Boolean.TRUE.toString())) == false) {
                return null;
                            generateSeqNoForOperationOnPrimary(index),
        }
        return mergeScheduler.getActiveMergeCount();
                                    source,
            );
                    // captures the checkpoint before IndexWriter.commit flushes). See
import org.opensearch.index.translog.Translog;
                    registry,
            // document, since UpdateHelper rebuilds the index request from the get's seqNo) was
    private final ReentrantLock refreshLock = new ReentrantLock();
            refreshListener.afterRefresh(didRefresh);
     * document — DataFormatAwareEngine has no soft-delete tracking. The seqNo is marked as
                    if (index.origin() == Engine.Operation.Origin.PRIMARY) {
        } catch (InterruptedException e) {
                            plan.currentNotFoundOrDeleted
            try {
                        String lastCommittedSnapshotId = lastCommitData.get(CatalogSnapshot.CATALOG_SNAPSHOT_ID);
                    config().getIndexSettings(),
            final long localCheckpointOfLastCommit = Long.parseLong(
    @Override
                    }
     * System property to enable or disable pluggable dataformat merge operations.
    }
                        logger.debug("releasing refreshLock held after merge failure (safety-net unlock)");
    @Override
                for (var holder : writerPool.checkoutAll()) {
                pendingRowCount.incrementAndGet();
            CombinedCatalogSnapshotDeletionPolicy combinedPolicy = new CombinedCatalogSnapshotDeletionPolicy(
     * index operations in its batch, append them first so the translog keeps request order (an index of a document
     */
                // Create a copy without file sizes when includeSegmentFileSizes=false
     * @param softDeletesRetentionOps unused — soft deletes are not supported
     */
                        throw new VersionConflictEngineException(
                            catalogSnapshotManager.commitNewSnapshot(finalSegments);
        }
            // doc counts and per-segment stats change even though no checkpoint moved. applyMergeResults
                                    rowsToRelease += segment.dfGroupedSearchableFiles().values().stream().findFirst().get().numRows();
        long autoGeneratedIdTimestamp,
                }
            // RemoteStoreRefreshListener so the merged segments get uploaded to the remote store.
    }
    // Lifecycle
            // so acquiring refreshLock via the hook establishes the same refreshLock → IW
    // Timestamps and seq-no markers
    public long getWritingBytes() {
        }
         * @param readerType the expected reader class
            } else {
    public long getPersistedLocalCheckpoint() {
                            // Commit data must contain all keys required for recovery
        return localCheckpointTracker.getPersistedCheckpoint();
                            "Indexing doc id=[{}] seqNo=[{}] primaryTerm=[{}] — writing to engine",
                        flushActiveBatchBeforeInlineWrite();
    public Iterable<Writer<?>> getWriterPool() {
    /**
                // Close all writers still in the pool (unflushed writers from the current cycle)
import java.util.function.BiFunction;
            updateAutoIdTimestamp(Long.parseLong(userData.get(MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID)), true);
     * directly to its {@link MergeScheduler} (orthogonal to active count).
     */
    @Override
                    // After failEngine, the engine must be in a closed state
     * DFA callers MUST use {@link #acquireSafeCatalogSnapshot()} — that API avoids the extra
     * the operation or return an early result (e.g., for version conflicts). For replica
        return indexingExecutionEngine.getNativeBytesUsed();
    @Override
    }
            } catch (Exception e) {
            try (GatedCloseable<Reader> readerRef = acquireReader()) {
    private final LockablePool<DefaultLockableHolder<Writer<?>>> writerPool;
        flushActiveBatchBeforeInlineWrite();
 *   <li>Soft-deletes policy for peer-recovery retention</li>
                    assert indexResult.getResultType() == Engine.Result.Type.FAILURE : indexResult.getResultType();
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
    private final LiveVersionMap versionMap;
            // A throw from addDoc is unmodeled. Known per-doc rejections must come back as
                            assert Long.parseLong(commitData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)) >= -1
            return true;
                    IOUtils.closeWhileHandlingException(queuedWriter);
                new DeleteVersionValue(
    public long getMinRetainedSeqNo() {
     * and trimming unreferenced translog files.
        // Replicas use a separate engine (analogous to NRTReplicationEngine) that consumes segments.
        return committer.getCommitStats();
                            // both cases the operation is unacknowledged until its append and sync complete.
                Releasable ignored = versionMap.acquireLock(index.uid().bytes());
    public Engine.DeleteResult delete(Engine.Delete delete) throws IOException {
            }
                if (refreshListener instanceof RemoteStoreRefreshListener) {
                                ) == OpVsEngineDocStatus.OP_NEWER) {
                            index.getAutoGeneratedIdTimestamp(),
                            assert result.refreshedSegments().size() >= existingSegments.size() - result.droppedGenerations().size()
    private long doGenerateSeqNoForOperation(final Engine.Operation operation) {
     * Also resets the auto-ID timestamp optimization if disabled.
    ) throws IOException {
    }
import org.opensearch.index.shard.DocsStats;
                    && indexResult.getFailure() != null
                        entry.getValue().files()
        ensureOpen();
                            if (commitResult != null && snapshot instanceof DataformatAwareCatalogSnapshot dfaSnapshot) {
                // latestCatalogSnapshot between commit() and updateLastCommitInfo(). Reentrant.
        for (Map.Entry<DataFormat, WriterFileSet> entry : filesMap.entrySet()) {
        // location, marks the seqNo processed, and (via the fsync callback) marks it persisted -- so we must NOT run
    }
                    engineConfig.getThreadPool().relativeTimeInMillis()
    /**
    @Override
            assert localCheckpointTracker != null : "local checkpoint tracker must be initialized";
            }
    public MergeStats getMergeStats() {
     * @param toSeqNumber the ending sequence number (inclusive)
            }
        final long refreshStartNanos = System.nanoTime();
        long ifPrimaryTerm
                        logger.trace(
                        if (force || lastCommittedSnapshotId == null || snapshot.getId() != Long.parseLong(lastCommittedSnapshotId)) {
                    maxUnsafeAutoIdTimestamp.get(),
                    // TODO: Handle file deletion policy
            throttle.deactivate();
        long seqNo,
    /**
    private final SetOnce<Exception> failedEngine = new SetOnce<>();
                if (plan.useUpdateDocument) {
        ensureOpen();
    }
            }
                                );
    private static OpVsEngineDocStatus compareOpToVersionMapOnSeqNo(String id, long seqNo, long primaryTerm, VersionValue versionValue) {
     * @return {@code true} if the translog exceeds the flush threshold
                );
                    versionMap.maybePutIndexUnderLock(
                    plan.version,
    }
                        );
                            snapshot.setUserData(commitData, true);
     * to the configured flush threshold.
                    refresh("unsafe_version_map");
     * its Lucene add and its translog add.
import org.opensearch.index.store.Store;
    // Writers that have been flushed inline but not yet closed. Their Lucene temp
        return mergeScheduler.hasPendingMerges();
        }
                    );
            this.readerManagers = indexingExecutionEngine.buildReaderManager(
    boolean isWriterRegistered(Writer<?> writer) {
            );
     * Explicitly freezes the engine for tiering. Called by {@code TransportPrepareTieringAction}
            // self-rollback, or PENDING_ROLLBACK awaiting CompositeWriter rollback). Anything thrown
                }
                            refreshed = true;
            pruneDeletedTombstones();
    public void flush() {
        if (seqNo > versionValue.seqNo) {
import org.opensearch.index.engine.dataformat.WriterConfig;
    private final IndexingExecutionEngine indexingExecutionEngine;
     * @param force       if {@code true}, forces a flush even if not strictly needed
                generateSeqNoForOperationOnPrimary(delete),
            closedLatch.await();
    @Override
        if (globalCheckpoint != maxSeqNo) {
                    // past them (seeding them as "already processed") and silently drop them.
                        for (var lockable : writers) {
            } else {
     *
                                    + "existingSegments={} newSegments={} resultSegments={} dropped={}",
                final Translog.Location location;
                    // Capturing here keeps the committed local checkpoint <= what the snapshot
                snapshotListeners,
            readLock,
import org.opensearch.index.engine.exec.Indexer;
                            index.startTime(),
    /**
                    );
    private VersionValue getVersionFromMap(BytesRef id) {
    @SuppressWarnings({ "unchecked", "rawtypes" })
                try {
    private final CatalogSnapshotStatsCache statsCache;
        TranslogManager translogManagerRef = null;
            this.committer = engineConfig.getCommitterFactory().getCommitter(new CommitterConfig(engineConfig, () -> {
    private final Logger logger;
                lastWriteNanos = index.startTime();
                                    hasFiles
     * soft-delete tracking. Caller must hold either the readLock or the writeLock.
    /**
     * @param autoGeneratedIdTimestamp the auto-generated ID timestamp
    private final Map<DataFormat, EngineReaderManager<?>> readerManagers;
            List<CatalogSnapshotLifecycleListener> snapshotListeners = new ArrayList<>();
                        while (flushLatch.getCount() > 0) {
            }
                lookupResult = documentLookupProvider.getVersionMetadata(op.id(), reader, shardId.getIndex(), documentMetadataResolver);
    }
    }
    }
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
     * is skipped. Waits for any pending close operations to complete.
    public long unreferencedFileCleanUpsPerformed() {
     * Determines whether a periodic flush is needed based on translog size relative
     * for a failure that is the translog's tragic event (the translog is closed and the engine is failing); any other
                            get.id(),
    }
                indexResult.setTranslogLocation(location);
     * closing the index. Throws if they diverge, indicating uncommitted operations.
    private final ReleasableLock readLock = new ReleasableLock(rwl.readLock());
    /**
            // docs; surface as IllegalStateException so the caller fails the engine for recovery.
            // silently dropped rather than enforced.
            .getSettings()
            assert indexingExecutionEngine != null : "indexing execution engine must be initialized";
        }
     * @throws IOException if reader acquisition fails
        assert operation.origin() == Engine.Operation.Origin.PRIMARY;
                this::resolveDocVersion,
            try {
    /**
import org.opensearch.common.SetOnce;
        return IndexModule.TieringState.HOT_TO_WARM.name().equals(state);
import org.opensearch.index.seqno.SeqNoStats;
            refreshLock.lock();
    private DeletionStrategy planDelete(Engine.Delete delete) throws IOException {
        }
    private final AtomicLong writerGenerationCounter;
        this.versionMap = new LiveVersionMap();
                new IndexingEngineConfig(
     * is still blocked. (Requests already past this guard are drained separately by the prepare
            } catch (AlreadyClosedException e) {
            throttle.activate();
                }
import java.util.concurrent.TimeUnit;
        }
            versionType,
                    unpublishedDeletes.set(true);
            }
    private final CountDownLatch closedLatch = new CountDownLatch(1);
                                } else if (writerToFlush instanceof RowIdAwareWriter<?> rowIdAwareWriter) {
        }
        if (delete.origin() == Engine.Operation.Origin.PRIMARY) {
    private final IndexingThrottler throttle;
    private boolean maybeFailEngine(String source, Exception e) {
                }
     *
    public long currentOngoingRefreshCheckpoint() {
            logger.debug(() -> new ParameterizedMessage("tried to fail engine but could not acquire lock [{}]", reason), failure);
            try {
     * unrecoverable IndexWriter failure), fail the engine. Called at refresh and flush entry
            assert index.primaryTerm() > 0 : "primaryTerm must be positive but was: " + index.primaryTerm();
            return;
            // between mergeMiddle and commitMerge — the IndexWriter monitor is not held there,
    @Override
        try {
                indexResult = new Engine.IndexResult(f.cause(), plan.version, index.primaryTerm(), index.seqNo());
     * Delegates get-by-id to the installed {@link DocumentLookupProvider}, acquiring a
                                catalogSnapshotManager.updateLastCommitInfo(commitResult);
                                    index.source(),
            return false;
        }
                engineConfig.getIndexSettings().getTranslogRetentionTotalFiles()
            public void onFailure(String reason, Exception ex) {
        return deleteResult;
    private final AtomicLong pendingRowCount = new AtomicLong();
            updateAutoIdTimestamp(Long.MAX_VALUE, true);
        long mappingVersion = currentMappingVersion();
        // In DFAE, all segments are tracked in the catalog snapshot regardless of load state — no distinction exists.
import org.opensearch.index.translog.listener.TranslogEventListener;
                                    curr
        try {
            ifPrimaryTerm
            }
        } catch (Exception e) {
    protected VersionValue resolveDocVersion(final Engine.Operation op, boolean loadSeqNo) throws IOException {
    }
                    return committer.getLastCommittedData();
        @SuppressWarnings("unchecked")
                    engineConfig.getEventListener().onFailedEngine(reason, failure);
                    + "]";
            try (ReleasableLock lock = writeLock.acquire()) {
    /** Applies the deletion plan and records a tombstone for executed operations. */
                        try {
            success = true;
}
        return catalogSnapshotManager.acquireSnapshot();
                    + index.seqNo()
    /**
                        }
                                : "refresh must not lose existing segments; had "
            ensureOpen();
        for (TranslogBatchScope batch : activeBatches) {
                if (reader.catalogSnapshot().getSegments().isEmpty()) {
     */
            }
     * Parses the source document using the document mapper and creates an {@link Engine.Index}
     * @param waitIfOngoing if {@code true}, waits for an in-progress flush to complete
        }
     * operations, throttling, translog recording, and local checkpoint tracking.
    }
            throw new MergeFailedEngineException(shardId, ex);
        return translogManager.acquireHistoryRetentionLock();
     * on both primary and replica). Updates {@link #lastDeleteVersionPruneTimeMSec}.
            failEngine("already closed by tragic event on indexing engine", engineTragic);
            // A merge only swaps segments in the catalog; it does not advance the checkpoint, so
    public CompletionStats completionStats(String... fieldNamePatterns) {
                lockedWriter = null;
                logger.error(() -> new ParameterizedMessage("Merge failed while registering merged files in Snapshot"), ex);
            return new Engine.DeleteResult(f.cause(), plan.version, delete.primaryTerm(), delete.seqNo(), false);
    private final AtomicLong maxUnsafeAutoIdTimestamp = new AtomicLong(-1);
import org.opensearch.common.annotation.ExperimentalApi;
 * An {@link Indexer} implementation that delegates to an {@link IndexingExecutionEngine}.
    private final ConcurrentLinkedQueue<Writer<?>> pendingWritersToClose = new ConcurrentLinkedQueue<>();
        // Soft deletes are not supported yet.
                } else {
            }
                op -> OpVsEngineDocStatus.OP_NEWER,
    /** {@inheritDoc} Always returns {@code true} — a refresh is always considered needed. */
            Map<DataFormat, Object> readers = new HashMap<>();
        }
        } catch (Exception ex) {
            for (Exception e : exceptions) {
                        final Engine.NoOp noOp = new Engine.NoOp(
            // Non-translog-origin successful operations must be recorded in the translog for durability
            failOnTragicEvent(ex);
                assert assertRetiredSegmentInvariants(writer, retiredFileInfos);
            WriteResult result = currentWriter.addDoc(index.parsedDoc().getDocumentInput());
        if (engineTragic != null) {
     * Unfreeze logic covers both cancel (HOT_TO_WARM → HOT) and prepare failure
import org.opensearch.common.lucene.Lucene;
    ) {
            // releases the lock before returning.
                        while ((pendingSeg = pendingSegments.poll()) != null) {
            this.writerPool = new LockablePool<>(() -> {
        }
            failEngine("corrupt file (source: [" + source + "])", e);
                                || compareOpToVersionMapOnSeqNo(
                        CountDownLatch flushLatch = new CountDownLatch(writerCount);
            throw e;
                rm.close();
            throw new EngineCreationFailureException(shardId, "failed to create engine", e);
            );
    @Override
     * @throws IOException if reading the translog fails
        boolean success = false;
                            throw new EngineException(shardId, "failed to read operation from translog", e);
            .get(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name());
        );
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {
    private final Set<TranslogBatchScope> activeBatches = ConcurrentHashMap.newKeySet();
                            shardId,
            assert indexResult.getSeqNo() >= 0 : "indexResult must have assigned seqNo but was: " + indexResult.getSeqNo();
                throw new IllegalStateException(
    }
            } catch (Exception e) {
                    new Translog.NoOp(deleteResult.getSeqNo(), delete.primaryTerm(), deleteResult.getFailure().toString())
        return new Engine.Index(
                    Optional.ofNullable(indexingExecutionEngine.getProvider()),
                                result.refreshedSegments().size(),
            } catch (Exception e) {
                delete.getIfSeqNo(),
                }
    }
import org.opensearch.index.engine.dataformat.merge.MergeFailedEngineException;
     *
    }
                                ).toGetResult();
            );
                exceptions.add(e);
    }
                notifyRefreshListenersAfter(refreshed || deletesApplied);
                    if (versionValue.isDelete()) {
 * <ul>
        final PrimaryOperationPolicy policy = engineConfig.getPrimaryOperationPolicy();
            long rows = entry.getValue().numRows();
     * Returns a translog snapshot for the given sequence number range.
        } catch (IOException e) {
                "wait_if_ongoing must be true for a force flush: force=" + force + " wait_if_ongoing=" + waitIfOngoing
    Store getStore() {
            Segment.Builder segBuilder = Segment.builder(writer.generation());
                long gen = writerGenerationCounter.incrementAndGet();
            // When file sizes are requested, compute on-demand with current snapshot
                                // has the commit format.
                                    + " but got "
                        // so the refresh thread can wait for ALL writers to be flushed
     * destroys all writers — memory reporting drops to 0 immediately on close, so there are
    /**
        flush(false, true);
                engineConfig.getIndexSettings().getFlushThresholdSize().getBytes()
                            index.versionType(),
     * @param failure the exception that caused the failure, or {@code null}
    }
 * this file be licensed under the Apache-2.0 license or a
                );
    @Override
     */
     * <p>
    public boolean isThrottled() {
import org.opensearch.index.IndexModule;
    }
        }
     * @param seqNo         the sequence number ({@code UNASSIGNED_SEQ_NO} for primary)
                () -> new ParameterizedMessage("preIndex: flush failed for writer gen={}, failing engine", writerToFlush.generation()),
            .get(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name());
                logger,
     * @return the prepared delete operation
        return writers;
        return true;
     */
            try (ReleasableLock lock = writeLock.acquire()) {
     * never bytes that are "reported as used but already being freed."
                                    index.primaryTerm(),
                // A pre-flight failure (version conflict) never issued a sequence number.
         * @param format the data format
                        + expectedRows
            }
                } else {
        // source of an ACE reaching this catch.
            IOUtils.closeWhileHandlingException(writer);
 * Mirrors the responsibilities of {@link InternalEngine} but is decoupled from Lucene:
        }
            }
                final EngineException closeFailure = new EngineException(shardId, "engine closed with pending translog batches: " + reason);
            if (get.realtime()) {
    boolean assertPrimaryIncomingSequenceNumber(final Engine.Operation.Origin origin, final long seqNo) {
import org.opensearch.index.translog.TranslogCorruptedException;
     * @throws IllegalArgumentException if {@code force} is true but {@code waitIfOngoing} is false
        return 0L;
        final boolean doThrottle = index.origin().isRecovery() == false;
                fileDeleter,
                    }
        this.shardId = engineConfig.getShardId();
import org.opensearch.index.engine.dataformat.WriteResult;
            // Bump catalog generation on engine open so uploads from this primary do not collide
import org.opensearch.index.translog.InternalTranslogManager;
                try {
                final IndexingStrategy plan;
                        List<Segment> newSegments = new ArrayList<>();
                            try {
                    if (get.isReadFromTranslog() && versionValue.getLocation() != null) {
                                source,
    // Latch for the current refresh cycle — decremented by any thread that flushes a writer.
                    logger.trace("flush completed");
        ensureOpen();
            }
                        Writer<?> pendingWriter;
                    engineConfig.getIndexSettings()
                    translogManager.trimUnreferencedReaders();
    // force every operation represented by a segment into the translog before publishing that segment.
    @Override
                                    + result.refreshedSegments().size();
    public Engine.Index prepareIndex(
        // construction can also appear later. Fail here rather than silently ignoring the policy.
            && engineConfig.getThreadPool().relativeTimeInMillis() - lastDeleteVersionPruneTimeMSec > getGcDeletesInMillis() * 0.25) {
    /**
                            // stock engine has the same window between the Lucene add and translogManager.add, and in
                        deletesApplied |= unpublishedDeletes.getAndSet(false);
            throw new EngineCreationFailureException(
        Engine.IndexResult indexResult;
                            // A writer can be flushed while its bulk still owns deferred translog entries. Append every
     * and {@link #freezeForTiering()} (explicitly, from the prepare action). Cleared when the state
    static final String MERGE_ENABLED_PROPERTY = "opensearch.pluggable.dataformat.merge.enabled";
            () -> localCheckpointTracker,
            final long flushStartNanos = System.nanoTime();
        return maxSeenAutoIdTimestamp.get();
                () -> 0L,
            assert incrementIndexVersionLookup();
     * @param version                  the expected version
     *   <li>No new merges will be registered (existing in-flight and pending merges drain to completion)</li>
    protected volatile long lastDeleteVersionPruneTimeMSec;
            if (indexResult.getTranslogLocation() == null) {
                        int writerCount = writers.size();
                            index.seqNo(),
            assert delete.origin().isFromTranslog() || deleteResult.getSeqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO;
    private final CounterMetric numIndexVersionsLookups = new CounterMetric();
                    + "] requested for shard ["
                                : "max seq no in commit data must be >= -1";
            translogManagerRef = createTranslogManager(translogUUID, translogDeletionPolicy, translogEventListener);
import org.opensearch.index.engine.exec.FileDeleter;
                    // durably contains, mirroring Lucene's InternalEngine.commitIndexWriter (which
     * could throw, so on throw the caller can still safely flag it as checked-out.
            }
    @Override
        }
            }
                } finally {
        ensureOpen();
    }
    }
        long ifPrimaryTerm
        if (versionValue == null) {
    private void ensureNoTragicException() {
                        documentMetadataResolver
    /**
        return doGenerateSeqNoForOperation(operation);
            // Restore version map and checkpoint tracker after recovery.
        }
                }
    @Override
        mergeScheduler.forceMerge(maxNumSegments);
     * Verifies that the global checkpoint matches the maximum sequence number before
    @Override
import org.opensearch.index.engine.exec.FilesListener;
                        shardId.getIndex(),
                flushLock.unlock();
        this.maxSeqNoOfUpdatesOrDeletes.updateAndGet(curr -> Math.max(curr, maxSeqNoOfUpdatesOnPrimary));
    public long getNativeBytesUsed() {
                            index.primaryTerm(),
        }
        for (DefaultLockableHolder<Writer<?>> holder : writerPool) {
    IndexingExecutionEngine<?, ?> getIndexingExecutionEngine() {
            // Unrecognized tiering-state value — treat as not frozen, but surface the misconfiguration.
    }
 *   <li>Sequence number generation and local checkpoint tracking</li>
                        // Refresh thread drains the queue itself (it's not idle — it does work)
                                    logger.trace(
        if (deleteResult.getTranslogLocation() == null) {
            Thread.currentThread().interrupt();
        assert oneMerge != null : "oneMerge must not be null";
                List<CatalogSnapshot> initSnapshots = committer.listCommittedSnapshots();
                    // DataFormatAwareEngineTests#testFlushMustNotCommitCheckpointAheadOfPersistedSnapshot.
        return throttle.isThrottled();
                            shardId,
     * consulted for it exactly as for a per-operation {@code Translog#add} failure. The drainer therefore only stops
     * If merges are already drained, fires the listener immediately inline.
                                boolean hasFiles = false;
                delete.versionType(),
                    store.shardPath(),
            this::ensureOpen,
     * is a programming error.
                if (rows > 0) {
                                    uid,
                versionValue = null;
                            try {
            // Drain deletes and remove tracking before publishing the retired segment.
                                engineRefreshElapsedMs,
                            : "new segment generation collides with an existing segment generation";
     * indexing data (pending VSR writes, buffered segments) is committed before merge
                assert indexResult.getSeqNo() == index.seqNo() : "IndexResult seq no ["
            deleteResult.setTranslogLocation(location);
                            long nextGen = newSegments.size() > 1 ? writerGenerationCounter.incrementAndGet() : RefreshInput.NO_GENERATION;
                        long rowsToRelease = 0L;
    @Override
            }
                this::resolveDocVersion,
     * {@code onlyExpungeDeletes} operations since those are Lucene-specific concepts not
     *
        long ifPrimaryTerm
     * has pending writers (put there by the refresh thread), this thread picks one up
import org.opensearch.index.shard.RemoteStoreRefreshListener;
    /**
        VersionType versionType,
            // can be read here. Without this the stats cache would keep serving pre-merge numbers until
     */
     * reported via ramBytesUsed while they're being written to disk), here refresh closes and
                                newSegments.size(),
        return new InternalTranslogManager(
    public int fillSeqNoGaps(long primaryTerm) throws IOException {
    private boolean incrementIndexVersionLookup() {
import java.util.concurrent.CountDownLatch;
     * @return the number of operations in the range
                    location = translogManager.add(new Translog.Index(index, indexResult));
            engineConfig.getIndexSettings().getTranslogBatchAppendMaxSize().getBytes()
     * candidate selection runs. This guarantees force merge operates on the complete
    }
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
    }
            ensureOpen();
                        );
            if (success == false) {
            notifyRefreshListenersBefore();
        );
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.indices.pollingingest.PollingIngestStats;
            return OpVsEngineDocStatus.OP_STALE_OR_EQUAL;
                registry.format(config().getIndexSettings().pluggableDataFormat())
        // merges, or Lucene merges that skip because the shared writer has no matching segments),
                try {
    }
    @Override
            }
import org.opensearch.index.engine.dataformat.WriterState;
                assert delete.origin() == Engine.Operation.Origin.PRIMARY : delete.origin();
        }
                    config().getChecksumStrategies()
    }
                dataFormatAwareMergePolicy,
            if (flushLock.tryLock() == false) {
                                    );
        activeBatches.add(batch);
        String id,
        // mirroring InternalEngine. The version map carries delete tombstones used by the get-by-id/version path.
                            writerCount,
                snapshotListeners.add(entry.getValue());
    public PollingIngestStats pollingIngestStats() {
     * Deletes, no-ops and the no-op recorded for a failed index are written inline. If this bulk thread still holds
    }
            this.indexingExecutionEngine = registry.getIndexingEngine(
        markSeqNoAsSeen(noOp.seqNo());
     * Set to "true" to enable merges (e.g., {@code -Dopensearch.pluggable.dataformat.merge.enabled=true}).
                    logger.warn("Failed to get last committed data for stats cache", e);
            if (lockedWriter != null) {
     * unacknowledged with unprocessed sequence numbers, the same state the stock engine leaves a document in between
            ensureOpen();
            pruneDeletedTombstones();
                pendingSegments.add(retiredSegment);
                indexResult.setTook(System.nanoTime() - index.startTime());
        } else {
                    + "] (readOnlyReplica="
        Engine.NoOpResult result = new Engine.NoOpResult(noOp.primaryTerm(), noOp.seqNo());
    /**
            for (Map.Entry<DataFormat, EngineReaderManager<?>> entry : readerManagers.entrySet()) {
     * Acquires a reference to the current catalog snapshot for reading segment metadata.
                .create(engineConfig.getIndexSettings(), engineConfig.retentionLeasesSupplier());
            }
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
    public CommitStats commitStats() {
    }
            this.snapshotRef = snapshotRef;
        }
        } catch (IOException e) {
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
                                return new DocumentLookupResult(
import java.util.LinkedList;
            final TranslogDeletionPolicy translogDeletionPolicy = getTranslogDeletionPolicy();
     * Set in three places: the constructor (freeze-on-open when a shard opens mid-tiering),
        Writer<?> writerToFlush = flushQueue.poll();
     * Builds an {@link Engine.Delete} operation for the given document id. The {@code _id} term is
            catalogSnapshotManager.applyMergeResults(mergeResult, oneMerge);
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {
     * commits a new catalog snapshot, and notifies reader managers so they can open
        final SequenceNumbers.CommitInfo seqNoStats = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
import org.opensearch.index.VersionType;
                } catch (AlreadyClosedException ex) {
                                CatalogSnapshot.LAST_COMPOSITE_WRITER_GEN_KEY,
        );
            DeleteResult.Failure f = (DeleteResult.Failure) deleteResult;
    private final AtomicInteger throttleRequestCount = new AtomicInteger();
            Translog.Location location = translogManager.add(new Translog.NoOp(noOp.seqNo(), noOp.primaryTerm(), noOp.reason()));
        long seqNo,
                        );
        } else if (e instanceof AlreadyClosedException) {
        }
     * A catalog-snapshot-backed data-format aware reader providing per-format reader access.
     * Deletes a document using primary planning or local recovery/reset semantics, then updates
        if (shouldFreeze) {
        try (ReleasableLock ignored = readLock.acquire()) {
import org.opensearch.index.translog.TranslogManager;
                logger.debug(() -> new ParameterizedMessage("[{}] batched translog append failed while draining", shardId), e);
                // Close writers still in the flush queue (checked out of pool, not yet flushed).
                    + engineConfig.getShardId()
     * seen and processed so the local checkpoint advances, and a {@link Translog.NoOp} is
import java.util.concurrent.locks.ReentrantReadWriteLock;
    }
     * snapshot and commit data (translog UUID, sequence numbers), syncing the translog,
                try (var cs = catalogSnapshotManager.acquireSnapshot()) {
            logger.info("Engine explicitly frozen for tiering by prepare action");
     * Flushes the engine and then closes it. If the engine is already closed, the flush
        if (unsafe) {
     * for all data formats.
        localCheckpointTracker.markSeqNoAsProcessed(deleteResult.getSeqNo());
     * {@link #onSettingsChanged} on a tiering transition, and by {@link #freezeForTiering()}. The
    /** Returns whether the writer is registered in the pool. Visible for testing only. */
            DataFormatAwareReader reader = new DataFormatAwareReader(snapshotRef, readers);
            }
        if (engineConfig.isAutoGeneratedIDsOptimizationEnabled() == false) {
            int count = 0;
    private final ConcurrentLinkedQueue<Writer<?>> flushQueue = new ConcurrentLinkedQueue<>();
            }
     * Prefers the cached volatile flag, which is set by the constructor on open, by
            engineConfig.getTranslogFactory(),
        return versionValue;
            if (hasFiles) {
    /** Assigns a new primary sequence number or marks a local recovery/reset sequence number as seen. */
                        logger.debug(
            index.parsedDoc().getDocumentInput().addField(PrimaryTermFieldType.INSTANCE, index.primaryTerm());
                if (waitIfOngoing == false) {
                            Translog.Operation operation = translogManager.readOperation(versionValue.getLocation());
                            indexResult.getSeqNo(),
     * — throws {@link IllegalStateException} so the caller can {@link #failEngine} and let
     * @return a gated closeable wrapping the catalog snapshot
import org.opensearch.index.seqno.LocalCheckpointTracker;
                writerCheckedOut = retireWriterIfNeeded(lockedWriter);
                            RefreshInput refreshInput = new RefreshInput(existingSegments, newSegments, nextGen, deletesApplied);
            }
    public void refresh(String source) throws EngineException {
            logger.trace("created new DataFormatBasedEngine");
                    + "] must match operation seq no ["
        } catch (IllegalArgumentException e) {
                e
        // ensureNoTragicException check and the actual addIndexes / commit call. Consult the
                IOUtils.closeWhileHandlingException(translogManagerRef);
    @ExperimentalApi
        if (isClosed.get() == false) {
                assert currentWriter instanceof RowIdAwareWriter : "writer pool must wrap every writer in a RowIdAwareWriter; got "
                            : "new segments must have unique generations";
                if (versionValue != null) {
        for (ReferenceManager.RefreshListener refreshListener : refreshListeners) {
                    logger.warn(() -> new ParameterizedMessage("failed engine [{}]", reason), failure);
                ex.addSuppressed(inner);
                }
                                existingSegments.size(),
            version,
            );
        DefaultLockableHolder<Writer<?>> lockedWriter = null;
                }
        // the warmer never fires and the lock is not held on entry; acquire it locally to
        final long localCheckpointBeforeRefresh = localCheckpointTracker.getProcessedCheckpoint();
                engineConfig.getIndexSettings().getTranslogRetentionSize().getBytes(),
                rows = plan.reservedDocs;
                    // Capture the processed checkpoint BEFORE refreshing. The refresh persists the
                }
     * returns to HOT (tiering cancel or prepare failure).
            throw new RuntimeException(e);
    public DataFormatAwareEngine(EngineConfig engineConfig) {
    private final CatalogSnapshotManager catalogSnapshotManager;
        if (writerToFlush == null) {
import org.opensearch.index.engine.exec.DocumentLookupSupport;
        assert incrementVersionLookup();
     * the flush work cooperatively.
                        if (refreshed || deletesApplied) {
        }
     * This method is a no-op for {@code upgrade}, {@code upgradeOnlyAncientSegments}, and
                        }
        if (result.getTranslogLocation() == null) {
            try (GatedCloseable<CatalogSnapshot> snapshotRef = catalogSnapshotManager.acquireSnapshot()) {
    public boolean shouldPeriodicallyFlush() {
        ensureOpen();
                } catch (IOException ex) {
        if (engineConfig.isReadOnlyReplica() || engineConfig.getIndexSettings().isWarmIndex()) {
            // for refreshLock. The preMergeCommitHook acquires refreshLock on the merge thread;
                if (failure != null) {
            || engineConfig.getIndexSettings().isRemoteTranslogStoreEnabled() == false
        return true;
                        markSeqNoAsSeen(index.seqNo());
import org.opensearch.common.Nullable;
            ) {
                    // concurrently DURING this flush lands in a NEW writer that is not part of this
                            .noneMatch(ns -> existingSegments.stream().anyMatch(es -> es.generation() == ns.generation()))
            }
    private boolean isFrozenForTiering() {
     */
            ensureOpen();
        }
    // Merge
     * Unlike InternalEngine where IndexWriter stays open after flushNextBuffer() (keeping bytes
                        while ((writerToFlush = flushQueue.poll()) != null) {
    /**
                translogDeletionPolicy,
import org.opensearch.index.engine.dataformat.MergeResult;
        long ifSeqNo,
                assert gen > 0 : "writer generation must be positive but was: " + gen;
                        readerRef.get(),
                try (Releasable ignore = versionMap.acquireLock(get.uid().bytes())) {
    /** {@inheritDoc} Returns the heap RAM bytes used by the indexing execution engine. */
                    } else {
                for (TranslogBatchScope batch : activeBatches) {
    @Override
                    throw new TranslogException(shardId, "failed to trim translog on sync", ex);
     * seqNo is durably recorded), translog replay, and {@link #fillSeqNoGaps} after a
        }
            logger.debug("Pluggable dataformat merge is disabled via system property [{}], skipping merge", MERGE_ENABLED_PROPERTY);
    }
            autoGeneratedIdTimestamp,
                                final long writerFlushElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - writerFlushStartNanos);
                        && (get.getIfSeqNo() != versionValue.seqNo || get.getIfPrimaryTerm() != versionValue.term)) {
     *   <li>Primary indexing operations are rejected with "frozen for tiering"</li>
            this::maybeFailEngine,
        long version,
                return indexIntoEngine(index, plan);
                if (refreshLock.isHeldByCurrentThread() == false) {
        try (ReleasableLock ignored = writeLock.acquire()) {
     * @throws EngineException if the refresh fails
            ensureOpen();
            return deletionStrategyPlanner.planOperationAsPrimary(delete);
        mergeScheduler.refreshConfig();
     * snapshot reference.
                            translogManager.ensureCanFlush();
            if (plan.earlyResultOnPreFlightError.isPresent()) {
        return store;
                return statsCache.getSegmentsStats();
        public <R> R getReader(DataFormat format, Class<R> readerType) {
                snapshotRef.close();
                    readers.put(entry.getKey(), reader);
                        index = new Engine.Index(
                versionMap.maybePutIndexUnderLock(
        if (postState == WriterState.ACTIVE) {
                            index.primaryTerm(),
     * action acquiring all primary permits.)
                                    doc.primaryTerm(),
                indexingExecutionEngine.getMerger(),
                Segment retiredSegment = segBuilder.build();
import org.opensearch.index.engine.exec.IndexReaderProvider;
                tieringStateStr
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {
        } catch (Exception e) {
     * set of segments.
                delete = generateSeqNoForDelete(delete);
                            commitData.put(
                delete.id(),
    }
    }
                IOUtils.close(deleteExecutionEngine, indexingExecutionEngine, committer, translogManager);
    /** Force every live bulk scope to append its current chunk before publishing a catalog snapshot. */
    /**
            return;
                    }
            IOUtils.closeWhileHandlingException(writerToFlush);
                        );
                        List<Segment> existingSegments = catalogSnapshot.get().getSegments();
                            newSegments.add(pendingSeg);
    }
                throw new IllegalStateException(
                return indexResult;
                                // Any new snapshots created post this should track this commit info.
            if (fileInfos.writerFilesMap().isEmpty() == false) {
                deleteExecutionEngine.createDeleter(writer);
         * @return the typed reader, or {@code null} if no reader exists for the format
        }
        String routing,
    }
                // Without this, their LuceneWriter IndexWriter locks remain in LOCK_HELD.
    }
        this.throttle = new IndexingThrottler();
 * </ul>
            // Writer pool must never return null — it creates on demand via the supplier
                ioException.addSuppressed(e);
     * N-1 docs into {@link #pendingSegments}, and closes it; any other state — or a flush failure
            }
    }
import org.opensearch.index.engine.exec.Segment;
        assert Objects.equals(index.uid().field(), IdFieldMapper.NAME) : index.uid().field();
        // fast so a misconfiguration surfaces before any indexing or recovery.
    private void notifyRefreshListenersAfter(boolean didRefresh) throws IOException {
    private static void ensureDefaultPrimaryOperationPolicy(EngineConfig engineConfig) {
         * @param <R> the reader type
            }, LiveDocsSource.docCountsResolver(readerManagers.values()), logger);
                return DefaultLockableHolder.of(new RowIdAwareWriter<>(writer));
            List<CatalogSnapshot> committedSnapshots = committer.listCommittedSnapshots();
        }
                    throw e;
    private final ThreadLocal<TranslogBatchScope> activeBatch = new ThreadLocal<>();
import org.opensearch.common.metrics.CounterMetric;
                e
                activeBatches.clear();
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
                        writerToFlush.generation(),
                stats.addVersionMapMemoryInBytes(deleteExecutionEngine.ramBytesUsed());
                    delete.seqNo(),
    public byte[] serializeSnapshotToRemoteMetadata(CatalogSnapshot catalogSnapshot) throws IOException {
                    store.decRef();
                    );
import org.opensearch.index.engine.dataformat.DocumentLocation;
                    writerCheckedOut = retireWriterIfNeeded(lockedWriter);
     * Idempotent and thread-safe — a no-op if already frozen. The atomic {@code compareAndSet}
            }
     * @throws EngineException if the flush fails
    private final Committer committer;
        VersionType versionType,
    public long getLastWriteNanos() {
            assert catalogSnapshotManager != null : "catalog snapshot manager must be initialized";
                    translogManager.rollTranslogGeneration();
    private void markSeqNoAsSeen(long seqNo) {
    }
            long maxGenFromCommit = 0L;
            this.translogManager = translogManagerRef;
            return failOnTragicEvent((AlreadyClosedException) e);
                                throw new AlreadyClosedException("engine closed during refresh flush");
                    + currentWriter.getClass().getName();
            this.refreshListeners.add(this.lastRefreshedCheckpointListener);
            }, LinkedList::new, Runtime.getRuntime().availableProcessors());
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
            public void onAfterTranslogRecovery() {
    @Override
                            catalogSnapshotManager.bumpGeneration();
    public void failEngine(String reason, @Nullable Exception failure) {
            return new Engine.DeleteResult(plan.version, delete.primaryTerm(), delete.seqNo(), plan.currentlyDeleted == false);
    @Override
import org.opensearch.common.lease.Releasable;
            assert writerPool != null : "writer pool must be initialized";
            );
        this.engineConfig = engineConfig;
import org.opensearch.index.translog.TranslogOperationHelper;
    @Override
     */
 *
    // Translog for durability and recovery
     * @param seqNo                    the sequence number ({@code UNASSIGNED_SEQ_NO} for primary)
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
    private void closeNoLock(String reason) {
     * pending readers exceptionally and rethrows it at {@code finish()}, and {@code maybeFailEngine} has already been
                                final long writerFlushStartNanos = System.nanoTime();
    private void triggerPossibleMerges() {
                }
            throw new AlreadyClosedException(shardId + " engine is closed", engineTragic);
            return true;
    private final DocumentCountTracker documentCountTracker;
    /** No-op — data-format engines do not maintain Lucene-style delete tombstones. */
                }
    public void flushAndClose() throws IOException {
                if (reader != null) {
            // go through this same helper. Calling lookupFromReader directly skipped the checks,
                    logger.debug("engine already closed - skipping flushAndClose");
            // in a merge, its committer wires the hook into a MergedSegmentWarmer that fires
import java.util.ArrayList;
                            get.versionType().explainConflictForReads(versionValue.version, get.version())
        // A deferred result is timed before entering the batch and frozen when its chunk is appended.
        return 0L;
     */
    private boolean failOnTragicEvent(AlreadyClosedException ex) {
        if (docMapper.getMapping() != null) {
        if (flushFirst) {
        assert oneMerge.getSegmentsToMerge().isEmpty() == false : "merged segments list must not be empty";
                Writer<?> pendingWriter;
        String tieringStateStr = engineConfig.getIndexSettings()
                                if (flushLatch.await(1, TimeUnit.SECONDS) == false) {
        return localCheckpointTracker.getProcessedCheckpoint();
                delete.uid(),
    }
        return delete;
                engineConfig.getIndexSettings(),
     * is still deferred.
        final long maxTimestampToPrune = timeMSec - engineConfig.getIndexSettings().getGcDeletesInMillis();
                    IOUtils.closeWhileHandlingException(holder.get());
     * @param fromSeqNo         the starting sequence number (inclusive)
    // Segments flushed inline outside refresh — by indexing threads (preIndex cooperative drain)
            logger.warn(
import org.apache.lucene.store.AlreadyClosedException;
        throw new UnsupportedOperationException(
            return true;
            return readers.get(format);
                }
        if (frozenForTiering.get()) {
    /**
        if (documentLookup.isSupported() == false) {
     * @return the active merge count, or 0 if no merges are running
                                    segmentBuilder.addSearchableFiles(entry.getKey(), entry.getValue());
    /**
     *
    /**
    private final LastRefreshedCheckpointListener lastRefreshedCheckpointListener;
            Map<String, String> lastCommitData = committer.getLastCommittedData();
                        location = null;
                }
        localCheckpointTracker.markSeqNoAsProcessed(noOp.seqNo());
    /**
    /** {@inheritDoc} Deactivates write throttling when merge pressure subsides. */
     * <p>A scope's append failure belongs to the bulk that owns the scope: the scope has recorded it, completed its
        final long timeMSec = engineConfig.getThreadPool().relativeTimeInMillis();
            } catch (IOException e) {
    }
    public Engine.GetResult getById(Engine.Get get, BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory)
            DataFormatRegistry registry = engineConfig.getDataFormatRegistry();
                failOnTragicEvent(e);
    // -- Visible for testing --
    private void applyMergeChanges(MergeResult mergeResult, OneMerge oneMerge) {
                            // reached batch.add, the WAL record exists before the row is searchable. The residual window
            : "DataFormatAwareEngine only supports PRIMARY, LOCAL_TRANSLOG_RECOVERY, or LOCAL_RESET origins but got: " + index.origin();
     * @param docMapper                the document mapper for parsing
    public long getHeapBytesUsed() {
     * failure is the owning request's to report, and the drainer carries on with the remaining scopes. Whether the
        List<Writer<?>> writers = new ArrayList<>();
            }
                    logger.warn(() -> new ParameterizedMessage("tried to fail engine but already failed, ignoring. [{}]", reason), failure);
                        // No two new segments may share the same generation
     * (locked only for the generation context; no document is added), mapping its {@link DeleteResult}.
            if (engineConfig.isEnableGcDeletes()
    }
     * (frozen-while-HOT → HOT) to ensure merge scheduler resumes.
            shouldFreeze = tieringState == IndexModule.TieringState.HOT_TO_WARM;
import org.apache.lucene.util.BytesRef;
        }
                            RefreshResult result = indexingExecutionEngine.refresh(refreshInput);
            );
        VersionType versionType,
            throw new UnsupportedOperationException("getById not supported: no DocumentLookupProvider installed");
        }
            // if the merge fails before applyMergeChanges can release it, this callback ensures
                            // Drop fully-deleted generations so the catalog stays consistent with the reader.
        }
     */
        // commitMerge to coordinate with refreshes. When Lucene is not a participant (pure-Parquet
                        assert newSegments.stream()
                engineConfig.getIndexSettings(),
                logger.warn("Failed to compute segments stats with file sizes, falling back to cached stats", e);
                    config().getStore(),
    }
                            toClose.add(pendingWriter);
                            }
        }
                        indexResult = new Engine.IndexResult(
import org.apache.lucene.search.ReferenceManager;
                                    Map.of()
                    writerPool.releaseAndUnlock(lockedWriter);
        long startTime = System.nanoTime();
        return localCheckpointTracker.generateSeqNo();
            // Copy the shared cached stats before adding delete-tracking memory.
        assert writerPool.isRegistered(lockedWriter) == false : "retired writer must not be in pool";
                    }
            throw new IllegalArgumentException(
    // Concurrency locks
        if (isFrozenForTiering() && index.origin() == Engine.Operation.Origin.PRIMARY) {
        String translogUUID,
        return deletionStrategyPlanner.planOperationAsNonPrimary(delete);
        versionMap.pruneTombstones(maxTimestampToPrune, localCheckpointTracker.getProcessedCheckpoint());
                maxUnsafeAutoIdTimestamp::get,
            throw new IllegalStateException("Engine is frozen for tiering — index operations blocked");
    public List<org.opensearch.index.engine.Segment> segments(boolean verbose) {
                        // commit only if last committed CS id is different from the one we are about to commit or if force param is true
    public void refreshPrimaryOperationPolicy() {
        // inline (handled by the non-deferred branch and by delete()).
            }, indexingExecutionEngine.maxIndexableDocs());
     */
    public void deactivateThrottling() {
                            if (operation != null) {
                versionMap.enforceSafeAccess();
                    deleteEx
        } else {
        try (Translog.Snapshot snapshot = translogManager.newChangesSnapshot(fromSeqNo, toSeqNumber, false)) {
            // Create Reader managers
                    List<DocumentLookupResult> docs = documentLookupProvider.getDocsAboveSeqNo(
                        final long flushAllStartNanos = System.nanoTime();
                        "Writer gen={} flushed format=[{}] files={}",
     * @param id            the document id to delete
     * @param reason  a human-readable reason for the failure
            if (readerType.isInstance(reader) == false) {
        final TranslogBatchScope batch = new TranslogBatchScope(
                            logger.debug(
            try (GatedCloseable<CatalogSnapshot> catalogSnapshot = catalogSnapshotManager.acquireSnapshot()) {
                combinedPolicy,
    private Engine.DeleteResult deleteInEngine(Engine.Delete delete, DeletionStrategy plan) throws IOException {
            assert indexResult.getSeqNo() >= 0 : "indexResult must have assigned seqNo but was: " + indexResult.getSeqNo();
                                logger.trace(
        if (count == 0) {
            || index.origin() == Engine.Operation.Origin.LOCAL_RESET)
            // Create and register stats cache as refresh listener
                            }
    @Override
import org.opensearch.index.engine.dataformat.merge.MergeScheduler;
     * @param source a descriptive label for the refresh (e.g., "flush", "write indexing buffer")
        if (activeBatch.get() != null) {
            // Merge
                    flushActiveTranslogBatches();
     *
    }
                } catch (IOException e) {
                            assert Long.parseLong(commitData.get(SequenceNumbers.MAX_SEQ_NO)) >= -1
                committedSnapshots,
                }
                        // Drain pending writers so they get closed after addIndexes incorporates their files
                localCheckpointTracker.markSeqNoAsPersisted(indexResult.getSeqNo());
        ParsedDocument doc = docMapper.getDocumentMapper().parse(source, indexingExecutionEngine.newDocumentInput());
     * Retires the writer if its {@link WriterState} is non-ACTIVE: ACTIVE returns {@code false}
        result.setTook(System.nanoTime() - noOp.startTime());
            }
                    return gen;
    public void close() throws IOException {
     * constructed from the id via {@link Uid#encodeId}.
                    try {
    public boolean maybeRefresh(String source) {
                delete.origin(),
    }
        try {
            logger.debug("preIndex: write thread flushed writer gen={} in [{}ms]", writerToFlush.generation(), flushElapsedMs);
            // 3. Create TranslogManager
     */
                        maybePruneDeletes();
    }
                            // Update snapshot userData so deletion policy can read max_seq_no
    public GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException {
            SegmentsStats cachedStats = statsCache.getSegmentsStats();
            throw new IllegalStateException(
                    if (get.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
     * Lock-free no-op: marks the seqNo as seen + processed and (when not from translog)
    public long getMaxSeqNoOfUpdatesOrDeletes() {
     * updated readers.
                        maxGenFromCommit = Math.max(maxGenFromCommit, seg.generation());
    }
                && versionValue.isDelete()
                            final long commitStartNanos = System.nanoTime();
            // 2. Read translogUUID and history UUID from last committed data
                    versionValue = getVersionFromMap(get.uid().bytes());
                flush(false, true);
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
                    // Acked docs can't reach the catalog (writer in an unreconcilable state, or
        boolean accurateCount
     * <p>
    }
    }
    private final LocalCheckpointTracker localCheckpointTracker;
        final long globalCheckpoint = engineConfig.getGlobalCheckpointSupplier().getAsLong();
                    + "); use a segment-consuming or read-only engine"
import org.opensearch.common.concurrent.GatedConditionalCloseable;
    // Throttling
     * If any per-format indexing engine has recorded a tragic exception (e.g., an
        // Pruning walks the deletes map taking a per-uid lock, so it is throttled to once per 1/4 of gcDeletes,
                    }
    // Refresh tracker
    // Sequence number tracking
    /**
            }
        // A scope opened against a closed engine would only fail at its first append with the same
    }
                    + policy
    /**
            DataFormatAwareMergePolicy dataFormatAwareMergePolicy = new DataFormatAwareMergePolicy(
     * Records non-translog deletes, updates checkpoint state, and finalizes the result. A successful
    public Engine.NoOpResult noOp(Engine.NoOp noOp) throws IOException {
            return (R) reader;
        return lastRefreshedCheckpointListener.pendingCheckpoint();
    /**
                Writer<?> writer = indexingExecutionEngine.createWriter(new WriterConfig(gen));
        }
                failEngine("refresh failed source[" + source + "]", ex);
     * Acquires all writers from the pool, flushes each to produce per-format file sets,
                    "could not apply buffered deletes while retiring writer generation [" + writer.generation() + "]",
    private Engine.NoOpResult innerNoOp(Engine.NoOp noOp) throws IOException {
        return prepareDelete(id, null, seqNo, primaryTerm, version, versionType, origin, ifSeqNo, ifPrimaryTerm);
 */
            for (Map.Entry<DataFormat, EngineReaderManager<?>> entry : readerManagers.entrySet()) {
    public void activateThrottling() {
        private final GatedCloseable<CatalogSnapshot> snapshotRef;
        boolean upgradeOnlyAncientSegments,
            versionMap.putDeleteUnderLock(
                }
    }
    public long getLastSyncedGlobalCheckpoint() {
        assert delete.origin() == Engine.Operation.Origin.PRIMARY
     * Defaults to "false" (merges disabled) as the merge implementations are not yet complete
            }
                if (initSnapshots.isEmpty() == false) {
                }
                    for (DocumentLookupResult doc : docs) {
                    + engineConfig.getShardId()
        try {
            // Fall through: read from parquet. Resolved through DocumentLookupSupport#getById,
import org.apache.logging.log4j.Logger;
import java.util.concurrent.atomic.AtomicLong;
     * Closes the engine, releasing all resources including the indexing execution engine,
import org.opensearch.common.Booleans;
            }
            deletionPolicy,
                            // We do an additional commit on engine start due to no catalog snapshot present in earlier commit during empty
    @Override
            try (GatedCloseable<Reader> readerRef = acquireReader()) {
                        throw new VersionConflictEngineException(
                        this.activeFlushLatch = flushLatch;
        return statsCache.getDocsStats();
                shardId
        return false;
     */
    }
     */
import org.opensearch.common.concurrent.GatedCloseable;
            // writers (e.g. Lucene MergeIndexWriter) invoke the hook on the merge thread
     */
        };
            final Map<String, String> userData = committer.getLastCommittedData();
    }
    @Override
     * the event listener.
    private final IndexingStrategyPlanner indexingStrategyPlanner;
         */
            this.indexingStrategyPlanner = new IndexingStrategyPlanner(
                                    + result.droppedGenerations().size()
    }
            custom = engineConfig.getCustomTranslogDeletionPolicyFactory()
    }
        }
     * applicable to the data format engine.
        // refreshLock may already be held by the merge thread when Lucene participated in the
                if (failedEngine.get() != null) {
     * Counts the number of translog operations between the given sequence numbers.
            } catch (Exception inner) {
         * @throws IllegalArgumentException if the reader exists but is not of the expected type
                    failEngine(reason, ex);
        Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id()));
        int maxNumSegments,
        maybePruneDeletes();
                    refreshListener.beforeRefresh();
            DocumentLookupResult lookupResult;
        return translogManager;
        if (deferred == false) {
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {
     * Returns the number of currently active (in-flight) merge tasks.
        }
 *   <li>Flush to commit catalog snapshots and trim the translog</li>
            // Fast path - return precomputed stats from cache (without file sizes)
        long seqNo,
        }
                    documentCountTracker.releaseInFlightDocs(rows);
            } finally {
                            // Refresh must not lose existing segments beyond those fully deleted (dropped).
        // Fallback: read live settings to close the apply-ordering gap described above.
            if (documentLookupProvider != null) {
                count++;
import java.util.concurrent.locks.ReentrantLock;
        int rows = 0;
                        final BytesRef uid = new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())).bytes();
                "failed to restore version map and local checkpoint tracker",
     * translog manager, reader managers, and store reference.
     *
                            snapshotRef.markSuccess();
            );
    private final DocumentMetadataResolver documentMetadataResolver;
    /**
import static org.opensearch.index.engine.Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID;
    public void forceMerge(
                            final long commitElapsedMs = TimeValue.nsecToMSec(System.nanoTime() - commitStartNanos);
        );
            // monitor ordering that the refresh path uses and avoids lock inversion. Ownership
        return deleteResult;
                );
            }
@ExperimentalApi
            // checkpoint-publishing listeners must not be notified. We invoke only the
     * @param primaryTerm              the primary term
        }
                            )
    @Override
    }
import org.opensearch.core.common.unit.ByteSizeValue;
                }
                    // Persist the latest catalog snapshot so it survives restart
            return;
        public DataFormatAwareReader(GatedCloseable<CatalogSnapshot> snapshotRef, Map<DataFormat, Object> readers) {
                        }
     * primary-term bump.
                }
        assert seqNo == UNASSIGNED_SEQ_NO : "primary operations must never have an assigned sequence number but was [" + seqNo + "]";
    public Translog.Snapshot newChangesSnapshot(
     * Returns whether any merges are queued but not yet started. DFA primary delegates
        // AlreadyClosedException; refuse it up front so the bulk is retried on the new primary without doing any work.
     * ensures only one caller wins the freeze transition under parallel tier/cancel.
        }
import java.util.Collections;
                    deleteExecutionEngine.deleteDocument(
                this.versionMap.clear();
     * @param origin        the operation origin
                if (indexResult.getResultType() == Engine.Result.Type.SUCCESS) {
        long startTime = System.nanoTime();
                        }
    // Shared queue of writers pending flush. Populated by refresh (checkoutAll),
    private final AtomicLong maxSeenAutoIdTimestamp = new AtomicLong(-1);
                                    doc.id(),
    /**
                    "retired segment row counts diverge across formats: format ["
            );
            throw new AlreadyClosedException(shardId + " engine is closed", failedEngine.get());
            } finally {
            CountDownLatch latch = activeFlushLatch;
            // branch above checks them inline, and the read-only and NRT replica engines already
