    private final CatalogSnapshotManager catalogSnapshotManager;
                .getCommitter(new CommitterConfig(engineConfig, () -> {}, true));
        throw new UnsupportedOperationException("Not supported on DataFormatAwareNRTReplicationEngine");
import org.opensearch.search.suggest.completion.CompletionStats;
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {
    @Override
            throw new UncheckedIOException(e);
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
import org.opensearch.common.logging.Loggers;
        }
            Thread.currentThread().interrupt();
            // Preserve HISTORY_UUID so that replicated history UUIDs survive commit round-trips.
                flushLock.lock();
        long primaryTerm,
            localCheckpointTracker.fastForwardProcessedSeqNo(maxSeqNo);
        return engineConfig;
            try (ReleasableLock lock = writeLock.acquire()) {
    @Override
                    return Collections.emptyMap();
    }
            final String formatName = format.name();
        if (failEngineLock.tryLock()) {
        @Override
            primaryTerm,
                    return;
    @Override
    @Override
    static class ReplicaDeletionPolicy implements CatalogSnapshotDeletionPolicy {
    }
    }
                } catch (IOException e) {
 *
    }
            snapshotRef.close();
                } finally {
                if (reader != null) {
    @Override
        return committer.getCommitStats();
    @Override
    private void commitCatalogSnapshot(boolean bumpSICounter) throws IOException {
                logger.warn("failEngine threw exception", inner);
                    }
                committed,
                    try {
        } else if (e != null && translogManager.getTragicExceptionIfClosed() == e) {
    }
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {
    }
    @Override
                CatalogSnapshot currentCommit = commits.get(i);
    @Override
    }
                if (readerManagersRef != null) {
    @Override
    }
import org.opensearch.common.util.io.IOUtils;
                engineConfig.getPrimaryTermSupplier(),
    public void activateThrottling() {}
    // Replica has no indexing engine; prepareIndex is only used for translog replay.
import org.apache.lucene.store.AlreadyClosedException;
                }), format, registry, store.shardPath(), store.getDataformatAwareStoreHandles(), engineConfig.getIndexSettings())));
                store.shardPath(),
            if (success == false) {
        boolean accurateCount
     * extension. Commit-managed files ({@code segments_N}, {@code write.lock}) are skipped —
            }
    /** Notifies internal refresh listeners; called manually since per-format readers lack ReferenceManager hooks. */
            // (via installSnapshot → afterRefresh) BEFORE latestCatalogSnapshot is swapped. This
                    return;
    public void flushAndClose() throws IOException {
import org.opensearch.index.seqno.SequenceNumbers;
                            }
        try (ReleasableLock ignored = readLock.acquire()) {
            // Update historyUUID if the incoming snapshot carries one (replicated from primary).
        }
    public Engine.NoOpResult noOp(Engine.NoOp noOp) throws IOException {
            this.committer = constructingCommitter = engineConfig.getCommitterFactory()
import org.opensearch.index.store.Store;
            deleters.put(formatName, filesByFormat -> {
            this.readerManagers = readerManagersRef;
                }
        CatalogSnapshotManager catalogSnapshotManagerRef = null;
                engineConfig.getTranslogConfig(),
    private final List<ReferenceManager.RefreshListener> internalRefreshListeners;
            final Path formatDir = "lucene".equals(formatName) ? shardPath.resolveIndex() : shardPath.getDataPath().resolve(formatName);
        }
    @Override
                    return Map.of();
            commitData.put(Engine.HISTORY_UUID_KEY, historyUUID);
        long startTime = System.nanoTime();
    }
            commitData.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, snapshot.serializeToString());
 * Replica engine for pluggable data-format indices. Operates on {@link CatalogSnapshot}
            success = true;
            versionType,
    public boolean isThrottled() {
        } else if (e instanceof AlreadyClosedException) {
        DocumentMapperForType docMapper,
import org.opensearch.index.engine.exec.EngineReaderManager;
import org.opensearch.common.SetOnce;
    @Override
        return Long.MIN_VALUE;
            Map<String, String> userData = committer.getLastCommittedData();
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(localCheckpointTracker.getMaxSeqNo()));
    }
                aggregated.putAll(registry.getReaderManager(new ReaderManagerConfig(Optional.of(new IndexStoreProvider() {
            this.internalRefreshListeners = new ArrayList<>(engineConfig.getInternalRefreshListener());
            Map<DataFormat, Object> readers = new HashMap<>();
import java.util.function.Supplier;
import org.opensearch.index.engine.exec.LiveDocsSource;
        return false;
                    @Override
            ensureOpen();
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCheckpointTracker.getProcessedCheckpoint()));
                        commitCatalogSnapshot(bumpCounter);
        return localCheckpointTracker.getProcessedCheckpoint();
            assert rwl.isWriteLockedByCurrentThread() || failEngineLock.isHeldByCurrentThread()
    }
        ensureOpen();
                                store.markStoreCorrupted(e);
                if (failedEngine.get() != null) {
    ) {
    }
    }
        }
    private TranslogDeletionPolicy getTranslogDeletionPolicy() {
                        // Mark store corrupted unless closing due to engine failure.
     * Catalog-tracked file deleter for the replica. Path resolution is delegated to
    public long lastRefreshedCheckpoint() {
                // Notify stats cache that flush completed to refresh committed state
    }
    public long getHeapBytesUsed() {
    private final Store store;
                closeNoLock("api");
    @Override
import java.util.Optional;
        @Override
    private final WriteOnlyTranslogManager translogManager;
    public void forceMerge(
    /** Replication engine does not have local indexing buffers. */
            CatalogSnapshot catalogSnapshot = snapshotRef.get();
            } catch (IOException e) {
        private final List<CatalogSnapshot> acquiredSnapshots = new CopyOnWriteArrayList<>();
import org.apache.logging.log4j.LogManager;
        return NRTReplicaTranslogOps.getTranslogDeletionPolicy(engineConfig);
                        continue;
    private final CountDownLatch closedLatch = new CountDownLatch(1);
    private final Logger logger;
    }
import org.opensearch.index.translog.TranslogOperationHelper;
        boolean requiredFullRange,
                            .warn("Failed to delete file [{}] in format [{}]: {}", name, formatName, e.getMessage());
    }
            }
        return false;
                this.historyUUID = incomingHistoryUUID;
                statsCache.onFlushCompleted();
            Map<String, String> commitData = new HashMap<>();
                DataFormatAwareNRTReplicationEngine.this,
                catalogSnapshotManager.updateLastCommitInfo(commitResult);
            lastReceivedPrimaryCommitGen = incomingCommitGeneration;
                new ReplicaDeletionPolicy(),
    public EngineConfig config() {
            this.catalogSnapshotManager = catalogSnapshotManagerRef;
    @Override
            }
                for (String name : files) {
    public boolean isReplicaIndexer() {
        return new Engine.Index(
    }
    }
        return false;
            // Mirror the commit data onto the snapshot so `lastCommittedSnapshot` reflects the committed userData
        }
                engineConfig.getTranslogFactory(),
                }
                    logger.debug("engine closed [{}]", reason);
    public void maybePruneDeletes() {
         * Used during startup to trim unsafe commits before the policy is fully initialized.
    @Override
        throw new UnsupportedOperationException(
                Set<String> failed = new HashSet<>();
    public long getLastSyncedGlobalCheckpoint() {
            isRetry,
        for (ReferenceManager.RefreshListener refreshListener : internalRefreshListeners) {
import org.opensearch.index.engine.exec.FileDeleter;
        if (isClosed.get()) {
        return catalogSnapshotManager.acquireCommittedSnapshot(false);
        if (isClosed.compareAndSet(false, true)) {
                failedEngine.set(failure != null ? failure : new IllegalStateException(reason));
    @Override
                try {
 * instead of {@code SegmentInfos} and implements {@link Indexer} directly (no IndexWriter).
        return new CompletionStats();
        boolean isRetry,
    }
        ParsedDocument doc = new ParsedDocument(null, null, source.id(), null, null, source.source(), source.getMediaType(), null);
                translogUUID,
     * so reads go straight to the snapshot.
            });
        return localCheckpointTracker.getProcessedCheckpoint();
            this.internalRefreshListeners.add(statsCache);
    private void notifyRefreshListenersBefore() throws IOException {
        // Skip document parsing — this replica engine only writes to translog.
     * Resolves {@code get} against the replicated segment snapshot via the installed
                flush(false, true, false);
                // Note: statsCache doesn't implement Closeable, it's a RefreshListener that gets cleaned up automatically
        return deleters;
                }
    }
                    logger.debug("flushing shard on close - this might take some time to sync files to disk");
                logger.trace("flushAndClose now acquired writeLock");
    @Override
            }
                }
        return 0;
import java.util.Objects;
                    try {
    public long getNativeBytesUsed() {
    }
        return true;
                    inner.addSuppressed(failure);
    @Override
                    try {
            final Map<DataFormat, EngineReaderManager<?>> statsReaderManagers = readerManagersRef;
            }
            refreshListener.afterRefresh(didRefresh);
        flush(false, true);
            }
    }
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
            throw e;
    }
    }
                    } catch (IOException e) {
                        };
            } finally {
            if (incomingHistoryUUID != null) {
            version,
    }
        ensureOpen();
        this.store = engineConfig.getStore();
            try (GatedCloseable<Reader> readerRef = acquireReader()) {
/*
        }
        long ifPrimaryTerm
import org.opensearch.index.engine.exec.CatalogSnapshotLifecycleListener;
    /**
        DocumentMetadataResolver resolver = engineConfig.getDocumentMetadataResolver() != null
            logger.trace("flushAndClose now acquire writeLock");
                        failed.computeIfAbsent(formatName, k -> new ArrayList<>()).add(name);
    private volatile long lastReceivedPrimaryCommitGen = SequenceNumbers.NO_OPS_PERFORMED;
        long ifSeqNo,
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
    // TODO: check DataFormatAwareImplementation
import org.opensearch.index.translog.WriteOnlyTranslogManager;
    }
import org.apache.logging.log4j.Logger;
    @Override
import org.opensearch.common.lucene.Lucene;
import org.opensearch.index.translog.TranslogCorruptedException;
                    logger.warn(() -> new ParameterizedMessage("tried to fail engine but already failed, ignoring. [{}]", reason), failure);
        // No-op: data-format engines do not maintain Lucene-style delete tombstones
import java.util.HashSet;
import org.opensearch.index.mapper.Uid;
    @Override
    public boolean shouldPeriodicallyFlush() {
 */
        ensureOpen();
                }
    public Engine.Delete prepareDelete(
        long ifSeqNo,
        // No-op for replica
                committer
    @Override
    @Override
    }
        throws IOException {
    public CompletionStats completionStats(String... fieldNamePatterns) {
                if (isClosed.get() == false) {
    @Override
    public int fillSeqNoGaps(long primaryTerm) throws IOException {
        if (Lucene.isCorruptionException(e)) {
            CatalogSnapshot snapshot = snapshotRef.get();
            }
            : DocumentMetadataResolver.NOOP;
     * those are owned by Store/Lucene commit machinery, not the catalog.
                try {
        }
                IOUtils.closeWhileHandlingException(constructingCommitter);
            }
     */
            return toDelete;
        } catch (Exception e) {
            failEngine(source, e);
import java.io.IOException;
import java.io.UncheckedIOException;
            refreshListener.beforeRefresh();
    }
            FileDeleter compositeDeleter = buildReplicaFileDeleter();
                if (engineConfig.getIndexSettings().isWarmIndex() == false) {
    public List<Segment> segments(boolean verbose) {
    @Override
 * Segments arrive via replication; local writes go only to the translog.
import org.apache.logging.log4j.message.ParameterizedMessage;
    public CommitStats commitStats() {
    }
            throw new EngineCreationFailureException(shardId, "failed to create engine", e);
        long ifSeqNo,
    }
    public DataFormatAwareNRTReplicationEngine(EngineConfig engineConfig) {
            // Bootstrap an empty commit if no segments file exists (fresh replica).
                    closedLatch.countDown();
            acquiredSnapshots.add(snapshot);
import org.opensearch.index.VersionType;
    public long getMinRetainedSeqNo() {
     * Builds filesystem-level {@link FileDeleter}s for every registered data format so that
                                return store;
                    0L, // nativeBytesUsed - replica has no native memory usage
                closeables.add(catalogSnapshotManager);
            uid,
import org.opensearch.index.seqno.SeqNoStats;
        return false;
            DataFormatAwareEngine.DataFormatAwareReader reader = new DataFormatAwareEngine.DataFormatAwareReader(snapshotRef, readers);
                }
                    closeNoLock("engine failed on: [" + reason + "]");
            // When file sizes are requested, compute on-demand with current snapshot
            }
                }
                    close(); // double close is not a problem
        return NRTReplicaTranslogOps.noOp(translogManager, localCheckpointTracker, noOp);
    public boolean hasPendingMerges() {
        ensureOpen();
    }
     * than the catalog.
            ifSeqNo,
     * which routes each filename to the correct per-format subdirectory based on the file's
    private final Committer committer;
            return new SafeCommitInfo(localCheckpoint, (int) cs.getNumDocs());
    @Override
        try (GatedCloseable<CatalogSnapshot> snapshot = catalogSnapshotManager.acquireCommittedSnapshot(true)) {
import java.util.Collection;
 * @opensearch.experimental
    }
        );
            }, LiveDocsSource.docCountsResolver(statsReaderManagers.values()), logger);
        } catch (IOException e) {
                Object reader = entry.getValue().getReader(catalogSnapshot);
    public TranslogManager translogManager() {
    }
        @Override
    @Override
            String lcp = cs.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY);
                () -> localCheckpointTracker,
            throw new AlreadyClosedException(shardId + " engine is closed", failedEngine.get());
                return statsCache.buildSegmentsStats(
    private final Lock flushLock = new ReentrantLock();
    }
    public GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException {
import org.opensearch.index.get.DocumentLookupResult;
            }
                try {
    }
            doc,
    /** Fails the engine on corruption, translog tragic events, or already-closed with tragic cause. */
        return localCheckpointTracker.getMaxSeqNo();
        ensureOpen();
                return failed.isEmpty() ? Map.of() : Map.of(formatName, failed);
    @Override
    @Override
            for (int i = 0; i < commits.size() - 1; i++) {
                if (files == null || files.isEmpty()) {
        Map<String, FileDeleter> deleters = new HashMap<>();
import org.opensearch.indices.pollingingest.PollingIngestStats;
                translogManager.rollTranslogGeneration();
        long autoGeneratedIdTimestamp,
        }
import java.util.ArrayList;
    }
        }
import org.opensearch.index.translog.Translog;
import java.nio.file.NoSuchFileException;
        return 0;
    /** Replication engine does not have local indexing buffers. */
        awaitPendingClose();
            } catch (Exception e) {
    @Override
        try {
package org.opensearch.index.engine;
        long startTime = System.nanoTime();
        this.shardId = engineConfig.getShardId();
                NRTReplicaTranslogOps.createTranslogEventListener(this::failEngine, this::translogManager, shardId),
        return translogManager.getLastSyncedGlobalCheckpoint();
        this.logger = Loggers.getLogger(DataFormatAwareNRTReplicationEngine.class, engineConfig.getShardId());
        if (includeSegmentFileSizes) {
        VersionType versionType,
        private CatalogSnapshot lastSnapshot;
                engineConfig.getGlobalCheckpointSupplier(),
                if (waitIfOngoing == false) {
        }
                new CommitInput(commitData.entrySet(), snapshot, bumpSICounter ? SI_COUNTER_INCREMENT : 0)
                        return new FormatStore() {
    @Override
    @Override
        WriteOnlyTranslogManager translogManagerRef = null;
 *
        }
import org.opensearch.index.engine.exec.CommitFileManager;
import org.opensearch.index.engine.exec.commit.Committer.CommitInput;
        return lastWriteNanos;
    public Engine.GetResult getById(Engine.Get get, BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory)
                Map.of(),
        Committer constructingCommitter = null;
        return statsCache.getSegments();
    @Override
import org.opensearch.common.concurrent.GatedConditionalCloseable;
        updateCatalogSnapshot(catalogSnapshot);
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
            for (Map.Entry<String, Collection<String>> entry : filesByFormat.entrySet()) {
        ensureOpen();
        return false;
                    store.decRef();
    public void flush(boolean force, boolean waitIfOngoing, boolean bumpSnapshotGeneration) {
            final long incomingCommitGeneration = incoming.getLastCommitGeneration();
    }
                                logger.warn("Unable to mark store corrupted", ex);
        VersionType versionType,
    }
                }
            translogManagerRef = new WriteOnlyTranslogManager(
                        final boolean bumpCounter = engineConfig.getIndexSettings().isRemoteStoreEnabled() == false
import org.opensearch.index.engine.exec.commit.CommitterConfig;
 * this file be licensed under the Apache-2.0 license or a
    private void applyCatalogSnapshot(CatalogSnapshot incoming) throws IOException {
            logger.debug(() -> new ParameterizedMessage("tried to fail engine but could not acquire lock [{}]", reason), failure);
            // Create and register stats cache as refresh listener. The reader managers are captured
     * {@code write.lock}) which are managed by {@code Store}/Lucene commit machinery rather
            logger.trace("created new DataFormatAwareNRTReplicationEngine");
        // Skip flushing for warm indices
    public DocsStats docStats() {
                shardId,
    /** Updates the catalog snapshot with a new snapshot received from the primary via replication. */
        Map<DataFormat, EngineReaderManager<?>> readerManagersRef = null;
            CatalogSnapshot cs = snapshot.get();
        ShardPath shardPath,
        ensureOpen();
    private volatile String historyUUID;
    private void closeNoLock(String reason) {
                    }
            String incomingHistoryUUID = incoming.getUserData().get(Engine.HISTORY_UUID_KEY);
    public void refresh(String source) throws EngineException {}
        };
        String id,
    public Engine.Index prepareIndex(
            final String translogUUID = Objects.requireNonNull(userData.get(Translog.TRANSLOG_UUID_KEY));
        @Override
 * The OpenSearch Contributors require contributions made to
public class DataFormatAwareNRTReplicationEngine implements Indexer {
    public Engine.Delete prepareDelete(
            CommitResult commitResult = committer.commit(
            // Restore CatalogSnapshot from commit data.
    @Override
                return result.exists() ? result.toGetResult() : Engine.GetResult.NOT_EXISTS;
        if (isClosed.get() == false) {
import org.opensearch.index.mapper.DocumentMapperForType;
    }
                    snapshot
            flush(false, true);
            try (GatedCloseable<CatalogSnapshot> snapshotRef = catalogSnapshotManager.acquireSnapshot()) {
        try {
                        LogManager.getLogger(DataFormatAwareNRTReplicationEngine.class)
    }
    public boolean refreshNeeded() {
    @Override
            }
         *
                } finally {
                }
            for (String formatName : allDescriptors.keySet()) {
            List<CatalogSnapshotLifecycleListener> snapshotListeners = new ArrayList<>(readerManagersRef.values());
    }
import java.util.concurrent.locks.ReentrantLock;
                IOUtils.close(closeables);
        return 0;
        try (ReleasableLock lock = writeLock.acquire()) {
                TranslogOperationHelper.create(engineConfig)
    public GatedCloseable<Reader> acquireReader() throws IOException {
                    public FormatStore getStore(DataFormat dataFormat) {
            return commits.getLast();
                compositeDeleter,
        commitCatalogSnapshot(false);
            readerManagersRef = Map.copyOf(aggregated);
        long version,
        } catch (InterruptedException e) {
    }
    }
    }
        return null;
            snapshotRef.markSuccess();
                if (!acquiredSnapshots.contains(currentCommit)) {
import org.opensearch.index.mapper.SourceToParse;
        }
            seqNo,
        return new Engine.Delete(id, uid, seqNo, primaryTerm, version, versionType, origin, startTime, ifSeqNo, ifPrimaryTerm, routing);
                    logger.warn("Failed to get last committed data for stats cache", e);
import java.io.Closeable;
    }
                        // are running.
                    }
            return onCommit(commits);
        // includeUnloadedSegments is a Lucene concept (segments on disk not yet loaded into a SegmentReader).
    @Override
    private void commitCatalogSnapshot() throws IOException {
     *  CatalogSnapshotLifecycleListeners, so they are notified (and refreshed) inside
import java.util.HashMap;
                readLock,
    public Engine.DeleteResult delete(Engine.Delete delete) throws IOException {
                translogManager.getDeletionPolicy().setLocalCheckpointOfSafeCommit(maxSeqNo);
            doc.addDynamicMappingsUpdate(docMapper.getMapping());
            assert false == committed.isEmpty() : "At least one commit should be present for replica"; // ????????
    ) throws EngineException, IOException {}
    public boolean maybeRefresh(String source) {
    }
     *  applyReplicationSnapshot → installSnapshot before the snapshot becomes visible. */
    }
                commitCatalogSnapshot();
        ensureOpen();
                    } catch (AlreadyClosedException ex) {
    @Override
        public synchronized CatalogSnapshot findSafeCommit(List<CatalogSnapshot> commits) throws IOException {
                            public Store store() {
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
import java.nio.file.Path;
        ensureOpen();
                        continue;
        SourceToParse source,
import org.opensearch.index.translog.TranslogDeletionPolicy;
     * sweep can physically remove files not referenced by the restored catalog snapshot.
        String source,
            final CatalogSnapshot snapshot = lastSnapshot;
    @Override
    /**
            } finally {
            // Replicas don't track auto-id timestamps; -1 matches a fresh primary's startup value.
        // Segments arrive via segment replication, not by indexing parsed documents.
        return 0;
        store.incRef();
import java.util.Collections;
    @Override
    @Override
     * <p>
    @Override
        public List<CatalogSnapshot> onInit(List<CatalogSnapshot> commits) {
        long ifPrimaryTerm
    private final ReleasableLock readLock = new ReleasableLock(rwl.readLock());
    @Override
        } finally {
            return failed;
            // the shard's index/ dir; every other format has its own subdirectory.
            if (translogManager.getTragicExceptionIfClosed() != null) {
            applyCatalogSnapshot(incoming);
            return SafeCommitInfo.EMPTY;
        // In DFANRE, all segments are tracked in the catalog snapshot regardless of load state — no distinction exists.
                );
            // through a local because the field they are assigned to further down is still blank here.
    }
            }
import org.opensearch.index.mapper.ParsedDocument;
                        // already gone — treat as success
    }
                    store.decRef();
        }
                for (String name : entry.getValue()) {
        Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(id));
            success = true;
        }
            ? engineConfig.getDocumentMetadataResolver()
            catalogSnapshotManager.applyReplicationSnapshot(incoming);
        int maxNumSegments,
                closeables.add(translogManager);
    public Engine.IndexResult index(Engine.Index index) throws IOException {
                }
    /** NRT replica engine — receives segments via replication. */
                    catalogSnapshotManager.bumpGeneration();
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException {
        return 0;
    }
    private final DocumentLookupSupport documentLookup;
        translogDeletionPolicy.setRetentionSizeInBytes(translogRetentionSize.getBytes());
            Map<DataFormat, EngineReaderManager<?>> aggregated = new HashMap<>();
        long fromSeqNo,
            autoGeneratedIdTimestamp,
        Engine.Operation.Origin origin,
}
        return acquireLastCommittedSnapshot(false);
import java.util.concurrent.locks.Lock;
            );
        long ifPrimaryTerm
            try {
            List<CatalogSnapshot> toDelete = new ArrayList<>();
            // Fast path - return precomputed stats from cache (without file sizes)
        long seqNo,
     * snapshots must be cleaned through this path too; without it they accumulate forever.
    @Override
        @Override
                logger.error("failed to close engine", e);
    }
        return historyUUID;
        flush(force, waitIfOngoing, true);
                    // path — these are owned by Store/Lucene commit machinery, not the catalog.
    private final CatalogSnapshotStatsCache statsCache;
                failEngine("already closed by tragic event on the translog", translogManager.getTragicExceptionIfClosed());
    }
                            } catch (IOException ex) {
import java.util.concurrent.atomic.AtomicBoolean;
        notifyRefreshListenersBefore();
    @Override
     * <p>
                        // TODO we might force a flush in the future since we have the write lock already even though recoveries
    @Override
        // No-op for replica
        if (isClosed.get() == false) {
    public Closeable acquireHistoryRetentionLock() {
    public Translog.Snapshot newChangesSnapshot(
        for (DataFormat format : registry.getRegisteredFormats()) {
            this.historyUUID = Objects.requireNonNull(userData.get(Engine.HISTORY_UUID_KEY));
    ) throws IOException {
    @Override
                throw new FlushFailedEngineException(shardId, e);
        Engine.Operation.Origin origin,
        public SafeCommitInfo getSafeCommitInfo() {
            );
import org.opensearch.index.merge.MergeStats;
                List<Closeable> closeables = new ArrayList<>(readerManagers.values());
    /** Commits the current catalog snapshot to disk via a synthetic SegmentInfos with serialized CatalogSnapshot in userData. */
import org.opensearch.plugins.DocumentLookupProvider;
    public int getActiveMergeCount() {
    }
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
        return NRTReplicaTranslogOps.index(translogManager, localCheckpointTracker, index);
                }
                snapshotListeners,
        VersionType versionType,
            return;
    };
        boolean flush,
    }
                // Close per-format reader managers on failure
        }
                    logger.warn(() -> new ParameterizedMessage("failed engine [{}]", reason), failure);
     * The Lucene deleter guards against touching commit-owned files ({@code segments_N},
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
    }
import org.opensearch.common.unit.TimeValue;
    }
        ensureOpen();
                    return committer.getLastCommittedData();
            }
 * compatible open source license.
        throw new UnsupportedOperationException("Not supported on DataFormatAwareNRTReplicationEngine");
import org.opensearch.index.shard.DocsStats;
    @Override
        long startTime = System.nanoTime();
import org.apache.lucene.search.ReferenceManager;
            this.statsCache = new CatalogSnapshotStatsCache(catalogSnapshotManager, store, engineConfig, () -> {
                IOUtils.closeWhileHandlingException(translogManagerRef);
    public long getLastWriteNanos() {
            snapshot.setUserData(commitData, true);
                    } catch (NoSuchFileException ignored) {
        Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(id));
        Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id()));
                }
 * SPDX-License-Identifier: Apache-2.0
    public long getMaxSeqNoOfUpdatesOrDeletes() {
            return new GatedCloseable<>(reader, reader::close);
import java.util.Set;
        public synchronized GatedCloseable<CatalogSnapshot> acquireCommittedSnapshot(boolean acquiringSafe) {
                        Files.deleteIfExists(formatDir.resolve(name));
            // Register reader managers as catalog snapshot lifecycle listeners so they are notified
    }
            }
    @Override
                    }
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
                }
                if (bumpSnapshotGeneration) {
                            && engineConfig.getIndexSettings().isAssignedOnRemoteNode() == false;
            this.localCheckpointTracker = new LocalCheckpointTracker(seqNoInfo.maxSeqNo, seqNoInfo.localCheckpoint);
import java.util.Map;
        return localCheckpointTracker.getProcessedCheckpoint();
import org.opensearch.common.util.concurrent.ReleasableLock;
import org.opensearch.index.translog.TranslogManager;
        String id,
    private void maybeFailEngine(String source, Exception e) {
import org.opensearch.index.store.FileMetadata;
                            }
        if (flushFirst) {
                DataFormat format = registry.format(formatName);
        long seqNo,
    /** DFA replicas operate on {@link CatalogSnapshot}, not Lucene {@link IndexCommit}.
        }
    @Override
        return filesByFormat -> {
    public byte[] serializeSnapshotToRemoteMetadata(CatalogSnapshot catalogSnapshot) throws IOException {
            // Catalog file deleter — DataFormatAwareStoreDirectory routes filenames to the
        boolean upgrade,
                    }
import org.opensearch.index.engine.exec.commit.Committer.CommitResult;
    }
        return NRTReplicaTranslogOps.delete(translogManager, localCheckpointTracker, delete);
        ensureOpen();
        return 0;
        Engine.Operation.Origin origin,
        String routing,
        return catalogSnapshotManager.acquireSnapshot();
        boolean upgradeOnlyAncientSegments,
                return statsCache.getSegmentsStats();
        if (docMapper.getMapping() != null) {
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
                    -1L, // maxUnsafeAutoIdTimestamp - replica doesn't track auto-id timestamps
    public void deactivateThrottling() {}
    @Override
    public SafeCommitInfo getSafeCommitInfo() {
    }
    }
        long primaryTerm,
                    try {
    }
            if (incomingCommitGeneration != lastReceivedPrimaryCommitGen) {
    @Override
            if (flushLock.tryLock() == false) {
    @Override
     */
        } finally {
                }
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {
        }
import org.opensearch.core.index.shard.ShardId;
                    } catch (NoSuchFileException ignored) {
        return false;
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
                getTranslogDeletionPolicy(),
            }
            return statsCache.getSegmentsStats();
        }
    ) {
        final TranslogDeletionPolicy translogDeletionPolicy = translogManager.getDeletionPolicy();
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
import java.util.concurrent.CountDownLatch;
    @Override
        long version,
        long seqNo,
            List<CatalogSnapshot> committed = committer.listCommittedSnapshots();
            startTime,
                Collection<String> files = filesByFormat.get(formatName);
        }
                maybeFailEngine("flush", e);
     * Each deleter is a thin wrapper over {@link Files#deleteIfExists(Path)} scoped to the
    private void notifyRefreshListenersAfter(boolean didRefresh) throws IOException {
        long toSeqNo,
        );
        }
                        }
        } else {
        boolean success = false;
        ensureOpen();
    private final EngineConfig engineConfig;
            try {
     * Both Lucene and non-default (pluggable) formats are wired. The replica has no
                DocumentLookupResult result = documentLookup.getById(get, readerRef.get());
            try {
    @Override
            final SequenceNumbers.CommitInfo seqNoInfo = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(userData.entrySet());
            ifPrimaryTerm
 */
                    if (committer.isCommitManagedFile(name)) {
import org.opensearch.index.engine.exec.DocumentLookupSupport;
        String forceMergeUUID
    private final Map<DataFormat, EngineReaderManager<?>> readerManagers;
        /**
    public long getProcessedLocalCheckpoint() {
                } finally {
        DataFormatRegistry registry,
    @Override
    public long getMaxSeenAutoIdTimestamp() {
         * Finds the safe commit from the given list using this policy's global checkpoint.
    }
import org.opensearch.index.engine.exec.Indexer;
    public MergeStats getMergeStats() {
        return translogManager;
            for (Map.Entry<DataFormat, EngineReaderManager<?>> entry : readerManagers.entrySet()) {
                try {
                    } catch (IOException e) {
        }
        this.engineConfig = engineConfig;
        }
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogManager.getTranslogUUID());
     */
                    }
        throw new UnsupportedOperationException("Replica engine does not produce upload metadata bytes");
    public PollingIngestStats pollingIngestStats() {
    public void flush() {
import org.opensearch.index.shard.ShardPath;
    }
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
            // guarantees readers are updated before the snapshot becomes externally visible.
    @Override
    /** Applies the incoming snapshot to the manager. Reader managers are registered as
    public long getWritingBytes() {
        } catch (IOException | TranslogCorruptedException e) {
                : "Either the write lock must be held or the engine must be currently failing";
import org.apache.lucene.index.Term;
            return new GatedCloseable<>(snapshot, () -> { acquiredSnapshots.remove(snapshot); });
                    // Never delete Lucene commit files or write locks via the catalog cleanup
    // Visible for testing.
    }
            // Replicas track safe commit info on the engine itself (see DataFormatAwareNRTReplicationEngine#getSafeCommitInfo);
    @Override
import java.util.List;
        long primaryTerm,
import org.opensearch.core.common.unit.ByteSizeValue;
    @Override
    @Override
    private final ReentrantLock failEngineLock = new ReentrantLock();
                final String formatName = entry.getKey();
     * {@code IndexWriter}, so Lucene-format secondary files superseded by later replication
                        logger.debug("engine already closed - skipping flushAndClose");
                        // Bump SI counter on final commit to avoid filename collisions on failover.
    void updateCatalogSnapshot(CatalogSnapshot incoming) throws IOException {
            catalogSnapshotManagerRef = new CatalogSnapshotManager(
                        // already gone — treat as success
    private final SetOnce<Exception> failedEngine = new SetOnce<>();
import org.opensearch.common.concurrent.GatedCloseable;
            }
            );
            "acquireSafeIndexCommit is not supported on DataFormatAwareNRTReplicationEngine; use acquireSafeCatalogSnapshot"
     *  Use {@link #acquireSafeCatalogSnapshot()} instead. */
            DataFormatRegistry registry = engineConfig.getDataFormatRegistry();
        } else {
        boolean success = false;
                    readers.put(entry.getKey(), reader);
            if (commitResult != null) {
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {
    @Override
                    }
    @Override
    public long getIndexThrottleTimeInMillis() {
    public void finalizeReplication(CatalogSnapshot catalogSnapshot) throws IOException {
    @Override
     * {@link org.opensearch.index.store.DataFormatAwareStoreDirectory} via {@code store.directory()},
    public void writeIndexingBuffer() throws EngineException {}
        ensureOpen();
            // this policy is not used to compute it.
        try (ReleasableLock lock = readLock.acquire()) {
        return localCheckpointTracker.getPersistedCheckpoint();
    @Override
import org.opensearch.index.engine.exec.commit.Committer;
        // TODO: Wire up CompletionStatsCache when DFA search integration provides Engine.Searcher support.
                }
    private final ShardId shardId;
        if (engineConfig.getIndexSettings().isWarmIndex()) {
        }
                        flush();
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
            failEngine("corrupt file (source: [" + source + "])", e);
                    if (commitFileManager.isCommitManagedFile(name)) {
                logger.warn("Failed to compute segments stats with file sizes, falling back to cached stats", e);
    // Fields that Engine subclasses inherit; Indexer implementations must declare directly.
    }
    public void flush(boolean force, boolean waitIfOngoing) {
    public String getHistoryUUID() {
        try {
            ensureOpen();
    }
    @Override
        return 0;
    @Override
        try {
            try (ReleasableLock ignored = writeLock.acquire()) {
    }
            lastSnapshot = commits.getLast();
        return 0;
            commitData.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(snapshot.getId()));
                }
    public long unreferencedFileCleanUpsPerformed() {
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, Long.toString(-1L));
        CommitFileManager commitFileManager
     * {@link org.opensearch.index.engine.exec.coord}.
            long localCheckpoint = lcp != null ? Long.parseLong(lcp) : SequenceNumbers.NO_OPS_PERFORMED;
    @Override
    @Override
        this.documentLookup = new DocumentLookupSupport(shardId, engineConfig.getDocumentLookupProvider(), resolver);
        return localCheckpointTracker.getStats(globalCheckpoint);
    private final ReleasableLock writeLock = new ReleasableLock(rwl.writeLock());
                            try {
/**
    static Map<String, FileDeleter> buildReplicaFileDeleters(
    }
    private static final int SI_COUNTER_INCREMENT = 100000;
    public void ensureOpen() {
import java.util.function.BiFunction;
                engineConfig.getStartedPrimarySupplier(),
            closedLatch.await();
        }
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {
        translogDeletionPolicy.setRetentionAgeInMillis(translogRetentionAge.millis());
        }
                        failed.add(name);
    public void close() throws IOException {
                    // failure, we need to dec the store reference
            } catch (Exception e) {
    /**
        }
                    IOUtils.closeWhileHandlingException(readerManagersRef.values());
     * {@link DocumentLookupProvider}, with read-time version-conflict checks. No live version map,
    }
                    toDelete.add(currentCommit);
        long version,
                            @Override
        translogManager.syncTranslog();
     * {@link org.opensearch.index.engine.exec.coord.IndexFileDeleter}'s construction-time orphan
            // Required by DataFormatAwareEngine ctor if this replica is later promoted to primary.
import org.opensearch.common.annotation.ExperimentalApi;
    }
         * @return the safe commit
            } catch (Exception inner) {
            Map<String, Supplier<DataFormatDescriptor>> allDescriptors = registry.getFormatDescriptors(engineConfig.getIndexSettings());
    }
    ) {
         */
    }
            final long maxSeqNo = Long.parseLong(incoming.getUserData().get(SequenceNumbers.MAX_SEQ_NO));
import java.util.concurrent.locks.ReentrantReadWriteLock;
    @Override
            commitData.put(CatalogSnapshot.LAST_COMPOSITE_WRITER_GEN_KEY, Long.toString(snapshot.getLastWriterGeneration()));
    // Replica needs Delete for translog replay; the delete is written to translog only.
            origin,
            }
    private FileDeleter buildReplicaFileDeleter() {
    // Replicated segments are immediately visible; processed checkpoint == last refreshed.
        public synchronized List<CatalogSnapshot> onCommit(List<CatalogSnapshot> commits) {
    }
    private volatile long lastWriteNanos = System.nanoTime();
                CatalogSnapshot snapshot = snapshotRef.get();
                    // Defence-in-depth against a catalog that wrongly references a commit file.
                    } catch (IOException e) {
@ExperimentalApi
        // No-op for replica
    ) {
        boolean onlyExpungeDeletes,
                if (failure != null) {
            // Match OrphanFileScanner's path resolution: "lucene" files live directly under
            notifyRefreshListenersAfter(success);
import org.apache.lucene.index.IndexCommit;
                        logger.warn("Failed to delete file [{}] in format [{}]: {}", name, formatName, e.getMessage());
                flushLock.unlock();
        try (GatedConditionalCloseable<CatalogSnapshot> snapshotRef = catalogSnapshotManager.acquireSnapshotForCommit()) {
    }
                    engineConfig.getEventListener().onFailedEngine(reason, failure);
    @Override
                        if (failEngineLock.isHeldByCurrentThread() == false && store.isMarkedCorrupted() == false) {
import java.util.concurrent.CopyOnWriteArrayList;
    /** Replicas do not run merges; the active count is always zero. */
import org.opensearch.common.Nullable;
    public long getPersistedLocalCheckpoint() {
                        store.directory().deleteFile(FileMetadata.serialize(formatName, name));
        }
    private void awaitPendingClose() {
import org.opensearch.index.seqno.LocalCheckpointTracker;
import java.nio.file.Files;
            ensureOpen();
         * @param commits all committed snapshots, ordered oldest first
    /** Replicas do not run merges; they consume segments via segment replication. */
        awaitPendingClose();
            Map<String, Collection<String>> failed = new HashMap<>();
        return new Engine.Delete(id, uid, seqNo, primaryTerm, version, versionType, origin, startTime, ifSeqNo, ifPrimaryTerm);
        return new MergeStats();
                IOUtils.closeWhileHandlingException(catalogSnapshotManagerRef);
        return statsCache.getDocsStats();
import org.opensearch.index.engine.dataformat.DataFormat;
        for (ReferenceManager.RefreshListener refreshListener : internalRefreshListeners) {
    }
            this.translogManager = translogManagerRef;
    public void failEngine(String reason, @Nullable Exception failure) {
    private final LocalCheckpointTracker localCheckpointTracker;
     * format's on-disk directory — matching the path convention used by
        GatedCloseable<CatalogSnapshot> snapshotRef = catalogSnapshotManager.acquireSnapshot();
    }
            // correct per-format subdirectory based on extension; no per-format wiring needed.
import org.opensearch.index.mapper.IdFieldMapper;
