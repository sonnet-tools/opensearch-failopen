import org.opensearch.index.engine.exec.FileDeleter;
        // No-op: read-only engine does not flush. State is fully remote.
    // Metadata
    private final Committer committer;
                    if (committer.isCommitManagedFile(name)) {
import org.opensearch.index.engine.exec.Indexer;
        try {
        boolean flush,
    }
        return false;
import org.opensearch.search.suggest.completion.CompletionStats;
    @Override
            // Catalog file deleter
                for (String name : entry.getValue()) {
                        )
    public int getActiveMergeCount() {
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
    @Override
        boolean requiredFullRange,
    @Override
    public long getMaxSeqNoOfUpdatesOrDeletes() {
        } else {
    @Override
                if (readerManagersRef != null) {
import org.opensearch.index.seqno.LocalCheckpointTracker;
        ensureOpen();
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support deletes");
 * <p>This engine is the flip target when a read-only replica is promoted to primary
            // Create committer: isReplica=true opens the index without acquiring write.lock.
        return 0;
            FileDeleter compositeDeleter = buildFileDeleter();
                closeNoLock("api");
            // Build stats cache — snapshot is permanent for this engine, so populate once at construction.
import org.opensearch.common.UUIDs;
import org.opensearch.common.logging.Loggers;
                }
import java.util.function.Supplier;
    public PollingIngestStats pollingIngestStats() {
        DocumentMapperForType docMapper,
/**
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException {
        long primaryTerm,
        return catalogSnapshotManager;
            // Register reader managers as BOTH files listeners and snapshot lifecycle listeners.
import org.opensearch.index.translog.Translog;
                }
    @Override
    @Override
                closeables.add(catalogSnapshotManager);
    }
 * <p>Replicas continue using {@link DataFormatAwareNRTReplicationEngine}.
                try {
    }
    @Override
    public SafeCommitInfo getSafeCommitInfo() {
        long ifPrimaryTerm
    }
                    return Collections.emptyMap();
@ExperimentalApi
    @Override
    }
    ) {
    @Override
    }
        // flushFirst is ignored — read-only engine does not flush
            try {
            closedLatch.await();
    private final GatedCloseable<CatalogSnapshot> permanentSnapshotRef;
                        store.directory().deleteFile(name);
    private final ShardId shardId;
        if (isClosed.get()) {
    }
        this(engineConfig, null);
    }
    @Override
        int maxNumSegments,
                committed,
    public Closeable acquireHistoryRetentionLock() {
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
        return result.exists() ? result.toGetResult() : Engine.GetResult.NOT_EXISTS;
        ensureOpen();
            }, LiveDocsSource.docCountsResolver(this.readerManagers.values()), logger);
            this.committer = constructingCommitter = engineConfig.getCommitterFactory()
        // No-op: no indexing buffer
    ) {
    @Override
    @Override
            // Initialize sequence number tracking
public class DataFormatAwareReadOnlyEngine implements Indexer {
    private void closeNoLock(String reason) {
    private final Store store;
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    public int fillSeqNoGaps(long primaryTerm) throws IOException {
            throw new EngineCreationFailureException(shardId, "failed to create read-only engine", e);
        String source,
            // Acquire permanent snapshot ref — held for engine's lifetime, released in closeNoLock.
        return Translog.EMPTY_TRANSLOG_SNAPSHOT;
    @Override
        DocumentLookupResult result = documentLookup.getById(get, reader);
    public Engine.NoOpResult noOp(Engine.NoOp noOp) throws IOException {
    }
        // Segments are immediately visible upon replication; processed == persisted
    @Override
        }
 * compatible open source license.
    public Engine.GetResult getById(Engine.Get get, BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory)
        long ifPrimaryTerm
            if (success == false) {
                DataFormat format = registry.format(formatName);
        long primaryTerm,
                committer
                store.shardPath(),
    }
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support no-ops");
        boolean upgrade,
                    )
 * this file be licensed under the Apache-2.0 license or a
    @Override
            this.statsCache = new CatalogSnapshotStatsCache(catalogSnapshotManagerRef, store, engineConfig, () -> {
    }
package org.opensearch.index.engine;
    }
            this.translogManager = new NoOpTranslogManager(
        return 0;
                    closedLatch.countDown();
    private final CatalogSnapshotStatsCache statsCache;
    }
                } catch (IOException e) {
            }
            // The snapshot never changes; all queries share this single ref via the cached reader.
    public long getHeapBytesUsed() {
        @Override
            } catch (Exception e) {
import org.opensearch.index.shard.DocsStats;
     */
                }
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {
            Thread.currentThread().interrupt();
        };
        this.logger = Loggers.getLogger(DataFormatAwareReadOnlyEngine.class, engineConfig.getShardId());
    public void forceMerge(
    }
    @Override
    @Override
        );
                }
        return new GatedCloseable<>(reader, () -> {});
        // No-op: data-format engines do not maintain Lucene-style delete tombstones
    }
        long version,
    public void failEngine(String reason, @Nullable Exception failure) {
    // ---- IndexReaderProvider (Task 2) ----
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support indexing");
            }
    public boolean isReplicaIndexer() {
        VersionType versionType,
                    }
    private volatile String historyUUID;
    }
import java.util.function.BiFunction;
        this.shardId = engineConfig.getShardId();
                : "Either the write lock must be held or the engine must be currently failing";
 *
    @Override
        DocumentLookupProvider provider = documentLookupProvider != null
                        failed.computeIfAbsent(formatName, k -> new ArrayList<>()).add(name);
                            store.getDataformatAwareStoreHandles(),
    @Override
        return historyUUID;
    // ---- LifecycleAware ----
                logger.error("failed to close engine", e);
            catalogSnapshotManagerRef = new CatalogSnapshotManager(
import org.opensearch.index.engine.exec.CatalogSnapshotLifecycleListener;
    @Override
    @Override
 * Read-only engine for primaries operating on pluggable data formats.
    private final CatalogSnapshotManager catalogSnapshotManager;
    private final LocalCheckpointTracker localCheckpointTracker;
                filesListeners.put(entry.getKey().name(), entry.getValue());
                IOUtils.closeWhileHandlingException(constructingCommitter);
 * The OpenSearch Contributors require contributions made to
    Map<DataFormat, EngineReaderManager<?>> getReaderManagers() {
    }
     * No-op deletion policy for the read-only engine.
    public TranslogManager translogManager() {
        long toSeqNo,
    public void maybePruneDeletes() {
                translogUUID != null ? translogUUID : "readonly-" + shardId,
        long seqNo,
    public boolean maybeRefresh(String source) {
import org.opensearch.common.SetOnce;
    private final Logger logger;
    }
            // Initialize no-op translog
        boolean upgradeOnlyAncientSegments,
    }
    public List<Segment> segments(boolean verbose) {
    public long getProcessedLocalCheckpoint() {
        return localCheckpointTracker.getProcessedCheckpoint();
            // at open, eagerly warming the metadata cache before the first query; snapshot
    // ---- Lifecycle (Task 7) ----
import org.apache.logging.log4j.message.ParameterizedMessage;
    public void flush() {
        long version,
import java.util.Collection;
    // ---- Internal helpers ----
    private void awaitPendingClose() {
            // LuceneCommitterFactory detects isWarmIndex + !isReadOnlyReplica and returns
    @Override
import org.apache.logging.log4j.Logger;
        // No-op
            }
                logger.warn("failEngine threw exception", inner);
    /** Read-only engine does not have indexing buffers. */
    @Override
    }
        if (isClosed.get() == false) {
    public Engine.DeleteResult delete(Engine.Delete delete) throws IOException {
    public long lastRefreshedCheckpoint() {
                        new ReaderManagerConfig(
    }
            return failed;
    }
            ? engineConfig.getDocumentMetadataResolver()
    @Override
    // The snapshot never changes for this engine — build once, reuse across all reads.
 * @opensearch.experimental
    @Override
import org.opensearch.common.Nullable;
    @Override
        @Override
            this.permanentSnapshotRef = catalogSnapshotManagerRef.acquireSnapshot();
                    } catch (IOException e) {
 */
import java.util.concurrent.locks.ReentrantLock;
    }
    }
    public CompletionStats completionStats(String... fieldNamePatterns) {
    }
    public void refresh(String source) throws EngineException {
    }
        }
import org.opensearch.index.engine.exec.DocumentLookupSupport;
        return filesByFormat -> {
    public void ensureOpen() {
                if (failure != null) {
        String routing,
            for (Map.Entry<DataFormat, EngineReaderManager<?>> entry : readerManagersRef.entrySet()) {
import java.util.concurrent.CountDownLatch;
                }
    }
                final String formatName = entry.getKey();
    }
                }
    @Override
                    readers.put(entry.getKey(), r);
import java.util.concurrent.locks.ReentrantReadWriteLock;
            // listeners build the reader before latestCatalogSnapshot is swapped.
                            engineConfig.getIndexSettings()
import java.util.concurrent.atomic.AtomicBoolean;
}
            return Collections.emptyList();
        return Long.MIN_VALUE;
    }
 */
                snapshotListeners.add(entry.getValue());
    private final EngineConfig engineConfig;
import java.util.List;
            );
            return Collections.emptyList();
        return committer.getCommitStats();
    public long getPersistedLocalCheckpoint() {
                // Release the permanent snapshot ref before closing reader managers and catalog.
        return false;
        boolean accurateCount
import org.apache.lucene.store.AlreadyClosedException;
    @Override
    public Engine.IndexResult index(Engine.Index index) throws IOException {
            return new SafeCommitInfo(localCheckpointTracker.getProcessedCheckpoint(), (int) snapshot.get().getNumDocs());
                            registry,
    public Engine.Index prepareIndex(
     * The warm primary never creates new snapshots, so nothing is ever deleted.
        return () -> {};
        return 0;
    public long getIndexThrottleTimeInMillis() {
            assert rwl.isWriteLockedByCurrentThread() || failEngineLock.isHeldByCurrentThread()
                if (r != null) {
    }
    public CommitStats commitStats() {
    }
        boolean isRetry,
    static class NoOpCatalogSnapshotDeletionPolicy implements CatalogSnapshotDeletionPolicy {
        return 0;
                    engineConfig.getEventListener().onFailedEngine(reason, failure);
import org.opensearch.index.seqno.SequenceNumbers;
 *
    private final ReleasableLock writeLock = new ReleasableLock(rwl.writeLock());
                .getCommitter(new CommitterConfig(engineConfig, () -> {}, true));
import org.opensearch.index.mapper.DocumentMapperForType;
    }
            for (Map.Entry<DataFormat, EngineReaderManager<?>> entry : readerManagersRef.entrySet()) {
        ensureOpen();
    // ---- IndexerEngineOperations (Task 3 — write rejection) ----
                snapshotListeners,
        Engine.Operation.Origin origin,
    }
import org.opensearch.common.util.io.IOUtils;
    // ---- IndexerLifecycleOperations (Tasks 4, 7) ----
import java.util.ArrayList;
        return 0;
                aggregated.putAll(
    }
                if (isClosed.get() == false) {
            this.localCheckpointTracker = new LocalCheckpointTracker(seqNoInfo.maxSeqNo, seqNoInfo.localCheckpoint);
        return 0;
    }
        // No-op
                new NoOpCatalogSnapshotDeletionPolicy(),
            String translogUUID = userData.get(Translog.TRANSLOG_UUID_KEY);
    private final Map<DataFormat, EngineReaderManager<?>> readerManagers;
    private final CountDownLatch closedLatch = new CountDownLatch(1);
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.index.translog.NoOpTranslogManager;
        // No-op: read-only engine does not buffer documents
    @Override
        String id,
                    IOUtils.closeWhileHandlingException(readerManagersRef.values());
                new TranslogStats(0, 0, 0, 0, 0),
import java.util.Collections;
    public boolean hasPendingMerges() {
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
                        logger.warn("Failed to delete file [{}] in format [{}]: {}", name, formatName, e.getMessage());
        public List<CatalogSnapshot> onCommit(List<CatalogSnapshot> commits) {
                true
        return null;
    /** Read-only primaries do not run merges; the active count is always zero. */
            logger.info("Created DataFormatAwareReadOnlyEngine");
    public Translog.Snapshot newChangesSnapshot(
    ) throws EngineException, IOException {
import org.opensearch.plugins.DocumentLookupProvider;
            throw new AlreadyClosedException(shardId + " engine is closed", failedEngine.get());
        // No-op for read-only primary
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {
import java.util.Optional;
        return catalogSnapshotManager.acquireSnapshot();
    @Override
        Engine.Operation.Origin origin,
import org.opensearch.index.VersionType;
    }
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        @Override
    }
import java.util.HashMap;
    @Override
    public boolean refreshNeeded() {
                    closeNoLock("engine failed on: [" + reason + "]");
import org.apache.lucene.index.IndexWriter;
        public SafeCommitInfo getSafeCommitInfo() {
        long ifSeqNo,
            final SequenceNumbers.CommitInfo seqNoInfo = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(userData.entrySet());
    @Override
        } catch (IOException e) {
    }
    public long getMinRetainedSeqNo() {
            } finally {
                failedEngine.set(failure != null ? failure : new IllegalStateException(reason));
    }
    // ---- IndexerStatistics (Task 8) ----
    /** Read-only primaries do not run merges. */
        return localCheckpointTracker;
        } finally {
import org.opensearch.common.annotation.ExperimentalApi;
        return localCheckpointTracker.getMaxSeqNo();
    public void flushAndClose() throws IOException {
    }
            // Files listeners make IndexFileDeleter fire onFilesAdded for the committed snapshot
    // ---- Indexer core ----
    public long unreferencedFileCleanUpsPerformed() {
            Map<String, FilesListener> filesListeners = new HashMap<>();
    public long getMaxSeenAutoIdTimestamp() {
            : DocumentMetadataResolver.NOOP;
        throw new UnsupportedOperationException("Read-only primary does not produce upload metadata bytes");
    public void flush(boolean force, boolean waitIfOngoing) {
                    } catch (java.nio.file.NoSuchFileException ignored) {
            Map<String, Collection<String>> failed = new HashMap<>();
            Map<String, Supplier<DataFormatDescriptor>> allDescriptors = registry.getFormatDescriptors(engineConfig.getIndexSettings());
    @Override
    }
    }
                filesListeners,
    }
                }
    @Override
        throw new UnsupportedOperationException(
 * (via {@code resetToWriteableEngine}). Unlike {@link DataFormatAwareEngine},
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {
            this.statsCache.forceRefresh();
            // History UUID — fabricate if absent (same as NRT engine) for recovery protocol compliance
                    return;
    }
    @Override
        return false;
    }
            "acquireSafeIndexCommit is not supported on DataFormatAwareReadOnlyEngine; use acquireSafeCatalogSnapshot"
        this.documentLookup = new DocumentLookupSupport(shardId, provider, resolver);
    private FileDeleter buildFileDeleter() {
import org.opensearch.index.mapper.SourceToParse;
import org.opensearch.index.store.Store;
    }
            try (ReleasableLock ignored = writeLock.acquire()) {
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {
        return localCheckpointTracker.getProcessedCheckpoint();
        long primaryTerm,
        return localCheckpointTracker.getStats(globalCheckpoint);
    public long getLastWriteNanos() {
import org.opensearch.common.unit.TimeValue;
                try {
            );
import org.opensearch.common.util.concurrent.ReleasableLock;
    // Core state
    @Override
    @Override
            Map<String, String> userData = committer.getLastCommittedData();
            this.readerManagers = readerManagersRef;
        // Warm primaries use this engine; warm replicas use DataFormatAwareNRTReplicationEngine (which returns true).
        return translogManager.getLastSyncedGlobalCheckpoint();
            if (this.historyUUID == null) {
            this.historyUUID = userData.get(Engine.HISTORY_UUID_KEY);
            List<CatalogSnapshot> committed = committer.listCommittedSnapshots();
    /**
        this.store = engineConfig.getStore();
 * SPDX-License-Identifier: Apache-2.0
    }
    @Override
    @Override
    }
 * it has no {@link IndexWriter}, no active translog, and rejects all write
    private final DataFormatAwareEngine.DataFormatAwareReader reader;
            Map<DataFormat, Object> readers = new HashMap<>();
    public DocsStats docStats() {
    public byte[] serializeSnapshotToRemoteMetadata(CatalogSnapshot catalogSnapshot) throws IOException {
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support indexing");
                    try {
        // No-op: read-only engine does not merge
            throw new UncheckedIOException(e);
        return false;
    @Override
                );
    // Stats cache — populated once at construction (snapshot is permanent for this engine).
        long ifPrimaryTerm
        assert engineConfig.isReadOnlyReplica() == false : "DataFormatAwareReadOnlyEngine must only be created for primary shards; shard "
        // No-op
            }
import org.opensearch.index.engine.exec.commit.CommitterConfig;
    @Override
        VersionType versionType,
                Object r = entry.getValue().getReader(permanentSnapshotRef.get());
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
        }
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {
        return new CompletionStats();
                }
        }
    }
    ) {
    }
    }
        long autoGeneratedIdTimestamp,
                    }
    private final DocumentLookupSupport documentLookup;
    }
    }
import org.opensearch.index.engine.exec.EngineReaderManager;
        public List<CatalogSnapshot> onInit(List<CatalogSnapshot> commits) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
import org.opensearch.index.merge.MergeStats;
    public boolean shouldPeriodicallyFlush() {
import org.opensearch.indices.pollingingest.PollingIngestStats;
    @Override
            }
    public Engine.Delete prepareDelete(
    // The permanent snapshot ref: held for the engine's lifetime, released in closeNoLock.
    @Override
    @Override
import org.opensearch.index.seqno.SeqNoStats;
    }
    public boolean isThrottled() {
    }
                    logger.debug("engine closed [{}]", reason);
    public long getWritingBytes() {
    }
import org.apache.lucene.index.IndexCommit;
    // ---- Getters for internal state (used by tests) ----
    }
    public GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException {
        }
                compositeDeleter,
    }
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        return statsCache.getSegmentsStats();
    }
        ensureOpen();
    }
    public void activateThrottling() {
                Translog.EMPTY_TRANSLOG_SNAPSHOT,
import java.util.Map;
    public DataFormatAwareReadOnlyEngine(EngineConfig engineConfig, @Nullable DocumentLookupProvider documentLookupProvider) {
import org.opensearch.index.translog.TranslogManager;
    @Override
    @Override
            // Build per-format reader managers (same pattern as NRT)
                List<Closeable> closeables = new ArrayList<>(readerManagers.values());
        // Callers must not release it — use a no-op close callback.
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
    public EngineConfig config() {
import org.opensearch.index.engine.exec.commit.Committer;
    private final SetOnce<Exception> failedEngine = new SetOnce<>();
        store.incRef();
            logger.debug(() -> new ParameterizedMessage("tried to fail engine but could not acquire lock [{}]", reason), failure);
            }
    }
            DataFormatRegistry registry = engineConfig.getDataFormatRegistry();
 * operations. Reads route through {@code TieredSubdirectoryAwareDirectory}
import org.opensearch.index.engine.exec.FilesListener;
        return localCheckpointTracker.getProcessedCheckpoint();
    @Override
                    registry.getReaderManager(
                IOUtils.closeWhileHandlingException(catalogSnapshotManagerRef);
    }
                    logger.warn("Failed to get last committed data for stats cache", e);
        // No-op
                            Optional.of((IndexStoreProvider) dataFormat -> () -> store),
        } catch (IOException e) {
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
                    logger.warn(() -> new ParameterizedMessage("tried to fail engine but already failed, ignoring. [{}]", reason), failure);
import org.opensearch.index.translog.TranslogStats;
    // Lifecycle
        Map<DataFormat, EngineReaderManager<?>> readerManagersRef = null;
            this.catalogSnapshotManager = catalogSnapshotManagerRef;
    }
        awaitPendingClose();
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support deletes");
        }
    private final ReleasableLock readLock = new ReleasableLock(rwl.readLock());
 *
    /** Read-only engine does not have indexing buffers. */
        this.engineConfig = engineConfig;
    @Override
                readLock,
            }
        throws IOException {
        boolean onlyExpungeDeletes,
            this.reader = new DataFormatAwareEngine.DataFormatAwareReader(permanentSnapshotRef, readers);
                if (failedEngine.get() != null) {
    }
    }
    ) throws IOException {
        DocumentMetadataResolver resolver = engineConfig.getDocumentMetadataResolver() != null
        CatalogSnapshotManager catalogSnapshotManagerRef = null;
    @Override
        return engineConfig;
import java.io.IOException;
    }
    @Override
    public Engine.Delete prepareDelete(
        }
    LocalCheckpointTracker getLocalCheckpointTracker() {
    @Override
        long seqNo,
 *
import org.opensearch.index.engine.exec.LiveDocsSource;
            ? documentLookupProvider
        // No-op: no translog deletion policy to update
    public String getHistoryUUID() {
    }
        VersionType versionType,
            // ReadOnlyCommitter, which throws on commit() — this engine never writes commits.
    @Override
    @Override
    public MergeStats getMergeStats() {
            }
 * to remote storage.
        long seqNo,
    }
                        // already gone
            Map<DataFormat, EngineReaderManager<?>> aggregated = new HashMap<>();
        try {
        return statsCache.getDocsStats();
        ensureOpen();
        long fromSeqNo,
        }
    public DataFormatAwareReadOnlyEngine(EngineConfig engineConfig) {
        }
        return false;
        try (GatedCloseable<CatalogSnapshot> snapshot = catalogSnapshotManager.acquireSnapshot()) {
    @Nullable
    public long getNativeBytesUsed() {
        Engine.Operation.Origin origin,
                    store.decRef();
                    return committer.getLastCommittedData();
                    store.decRef();
        return translogManager;
import org.opensearch.index.get.DocumentLookupResult;
                this.historyUUID = UUIDs.randomBase64UUID();
    @Override
        } catch (InterruptedException e) {
                } finally {
    @Override
    }
            success = true;
                try {
    private final ReentrantLock failEngineLock = new ReentrantLock();
                shardId,
        long ifSeqNo,
    // ---- Recovery and Snapshot support (Task 6) ----
        return false;
        return readerManagers;
            for (Map.Entry<String, Collection<String>> entry : filesByFormat.entrySet()) {
    private final NoOpTranslogManager translogManager;
    }
        }
import java.io.UncheckedIOException;
        if (isClosed.compareAndSet(false, true)) {
    }
            for (String formatName : allDescriptors.keySet()) {
import java.io.Closeable;
                            store.shardPath(),
                    inner.addSuppressed(failure);
/*
                } finally {
import org.opensearch.common.concurrent.GatedCloseable;
    @Override
        return statsCache.getSegments();
    @Override
    @Override
        return localCheckpointTracker.getProcessedCheckpoint();
        String id,
    }
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
        Committer constructingCommitter = null;
    // ---- IndexerStateManager (Task 8) ----
            List<CatalogSnapshotLifecycleListener> snapshotListeners = new ArrayList<>();
    public void writeIndexingBuffer() throws EngineException {
        close();
            return SafeCommitInfo.EMPTY;
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
            readerManagersRef = Map.copyOf(aggregated);
        long ifSeqNo,
            } catch (Exception inner) {
        return catalogSnapshotManager.acquireSnapshot();
    @Override
                IOUtils.closeWhileHandlingException(permanentSnapshotRef);
                        continue;
            try {
        SourceToParse source,
    public void deactivateThrottling() {
            : engineConfig.getDocumentLookupProvider();
        // The reader holds a permanent snapshotRef for the engine's lifetime.
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support deletes");
        ensureOpen();
    public void close() throws IOException {
    @Override
        long version,
        if (failEngineLock.tryLock()) {
    @Override
            + engineConfig.getShardId();
                IOUtils.close(closeables);
        return catalogSnapshotManager.acquireSnapshot();
                this::ensureOpen,
    }
    }
    public GatedCloseable<Reader> acquireReader() throws IOException {
import org.opensearch.index.engine.dataformat.DataFormat;
import org.opensearch.core.index.shard.ShardId;
            }
        // No-op for read-only primary
                            format,
    @Override
                    logger.warn(() -> new ParameterizedMessage("failed engine [{}]", reason), failure);
        return startingSeqNo > localCheckpointTracker.getMaxSeqNo();
    CatalogSnapshotManager getCatalogSnapshotManager() {
    @Override
                }
        return System.nanoTime();
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {
    @Override
        String forceMergeUUID
        return 0;
        boolean success = false;
        return new MergeStats();
    @Override
    @Override
    public long getLastSyncedGlobalCheckpoint() {
        return 0;
    }
