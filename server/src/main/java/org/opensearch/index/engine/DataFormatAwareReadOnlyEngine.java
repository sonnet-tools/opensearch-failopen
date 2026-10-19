    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
        Engine.Operation.Origin origin,  
    }
    }
                Translog.EMPTY_TRANSLOG_SNAPSHOT,  
    @Override  
            return new SafeCommitInfo(localCheckpointTracker.getProcessedCheckpoint(), (int) snapshot.get().getNumDocs());
    @Override
        ensureOpen();
                IOUtils.closeWhileHandlingException(catalogSnapshotManagerRef);
            throw new EngineCreationFailureException(shardId, "failed to create read-only engine", e);
    }
import org.apache.logging.log4j.message.ParameterizedMessage;
import java.util.HashMap;
 *  
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {  
    // Core state
        boolean success = false;  
        long primaryTerm,  
/*  
    }  
    @Override
        return false;  
import org.opensearch.common.annotation.ExperimentalApi;  
    }
import java.util.Collection;  
        return catalogSnapshotManager;
    public Engine.NoOpResult noOp(Engine.NoOp noOp) throws IOException {
 * (via {@code resetToWriteableEngine}). Unlike {@link DataFormatAwareEngine},
 * to remote storage.
@ExperimentalApi
        return new MergeStats();  
    @Override
            throw new AlreadyClosedException(shardId + " engine is closed", failedEngine.get());  
    static class NoOpCatalogSnapshotDeletionPolicy implements CatalogSnapshotDeletionPolicy {
                    store.decRef();
    public int getActiveMergeCount() {
import org.opensearch.common.concurrent.GatedCloseable;
    }  
    @Override
import org.opensearch.index.get.DocumentLookupResult;  
                DataFormat format = registry.format(formatName);
    public boolean isReplicaIndexer() {  
    public Engine.Index prepareIndex(
    public long getProcessedLocalCheckpoint() {  
    public Engine.GetResult getById(Engine.Get get, BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory)
    @Override  
        this(engineConfig, null);
        return statsCache.getSegmentsStats();  
    }
        String id,
                aggregated.putAll(
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {  
                filesListeners,  
    @Override  
    private final ReleasableLock writeLock = new ReleasableLock(rwl.writeLock());
                true
        String routing,
    // ---- IndexerEngineOperations (Task 3 — write rejection) ----
        return localCheckpointTracker.getMaxSeqNo();  
    }
    private final CatalogSnapshotStatsCache statsCache;  
            }, LiveDocsSource.docCountsResolver(this.readerManagers.values()), logger);
    }
            // ReadOnlyCommitter, which throws on commit() — this engine never writes commits.
        this.store = engineConfig.getStore();  
        return false;
    public boolean shouldPeriodicallyFlush() {
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support deletes");
    }
import java.util.function.BiFunction;
        long version,
            return Collections.emptyList();
import java.io.UncheckedIOException;
 *
    // ---- IndexerLifecycleOperations (Tasks 4, 7) ----
                    return Collections.emptyMap();
                .getCommitter(new CommitterConfig(engineConfig, () -> {}, true));  
        return localCheckpointTracker.getStats(globalCheckpoint);
            // The snapshot never changes; all queries share this single ref via the cached reader.  
package org.opensearch.index.engine;
            // LuceneCommitterFactory detects isWarmIndex + !isReadOnlyReplica and returns  
    ) {
import org.opensearch.index.mapper.DocumentMapperForType;
            : engineConfig.getDocumentLookupProvider();
                IOUtils.closeWhileHandlingException(permanentSnapshotRef);
    ) throws IOException {
import org.opensearch.index.engine.exec.CatalogSnapshotLifecycleListener;
    }  
                    store.decRef();
            for (Map.Entry<String, Collection<String>> entry : filesByFormat.entrySet()) {  
    public void forceMerge(
        Engine.Operation.Origin origin,
import org.opensearch.index.engine.exec.commit.Committer;
    public Engine.IndexResult index(Engine.Index index) throws IOException {
                this.historyUUID = UUIDs.randomBase64UUID();
import org.opensearch.indices.pollingingest.PollingIngestStats;
import java.util.function.Supplier;
                    } catch (java.nio.file.NoSuchFileException ignored) {
 * <p>Replicas continue using {@link DataFormatAwareNRTReplicationEngine}.
    public long getLastSyncedGlobalCheckpoint() {  
import org.opensearch.common.UUIDs;
    public long getMaxSeqNoOfUpdatesOrDeletes() {
                if (r != null) {
                IOUtils.closeWhileHandlingException(constructingCommitter);
            try (ReleasableLock ignored = writeLock.acquire()) {
    @Override  
import org.apache.logging.log4j.Logger;
                } finally {  
        }  
    // ---- Indexer core ----
            + engineConfig.getShardId();
    @Override
        }
    public long lastRefreshedCheckpoint() {
            // Build per-format reader managers (same pattern as NRT)
        return engineConfig;
    @Override
        // No-op: read-only engine does not buffer documents  
            return Collections.emptyList();
            this.localCheckpointTracker = new LocalCheckpointTracker(seqNoInfo.maxSeqNo, seqNoInfo.localCheckpoint);  
        this.logger = Loggers.getLogger(DataFormatAwareReadOnlyEngine.class, engineConfig.getShardId());  
        ensureOpen();
    @Override  
    public byte[] serializeSnapshotToRemoteMetadata(CatalogSnapshot catalogSnapshot) throws IOException {  
        return Long.MIN_VALUE;
import org.opensearch.search.suggest.completion.CompletionStats;  
    public SafeCommitInfo getSafeCommitInfo() {
    public long getMaxSeenAutoIdTimestamp() {
    private final Logger logger;
                shardId,
    @Override
        } catch (InterruptedException e) {
    }
                }  
            this.reader = new DataFormatAwareEngine.DataFormatAwareReader(permanentSnapshotRef, readers);  
import org.opensearch.index.shard.DocsStats;
    public Engine.Delete prepareDelete(
    @Override
            } catch (Exception e) {  
            );  
import java.util.Collections;
                if (failedEngine.get() != null) {
        throw new UnsupportedOperationException("Read-only primary does not produce upload metadata bytes");
            String translogUUID = userData.get(Translog.TRANSLOG_UUID_KEY);  
    private final Map<DataFormat, EngineReaderManager<?>> readerManagers;  
        long fromSeqNo,  
                    closeNoLock("engine failed on: [" + reason + "]");
    public void failEngine(String reason, @Nullable Exception failure) {
    @Override
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
                if (failure != null) {
            this.statsCache.forceRefresh();
    // ---- Lifecycle (Task 7) ----
import org.opensearch.common.util.io.IOUtils;
        VersionType versionType,  
        return System.nanoTime();
                    if (committer.isCommitManagedFile(name)) {  
    public long getMinRetainedSeqNo() {
    /**
    @Override
    }
        Committer constructingCommitter = null;
        long ifSeqNo,
    public void deactivateThrottling() {  
                            Optional.of((IndexStoreProvider) dataFormat -> () -> store),
        return committer.getCommitStats();  
    @Override
            this.committer = constructingCommitter = engineConfig.getCommitterFactory()
    }  
        ensureOpen();
                    try {  
            Thread.currentThread().interrupt();
        return localCheckpointTracker.getProcessedCheckpoint();  
                    } catch (IOException e) {
                for (String name : entry.getValue()) {
    public List<Segment> segments(boolean verbose) {  
    }
        return 0;
        return localCheckpointTracker.getProcessedCheckpoint();
 * The OpenSearch Contributors require contributions made to  
        }
        long ifSeqNo,
    @Override
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support indexing");  
    }
        public List<CatalogSnapshot> onCommit(List<CatalogSnapshot> commits) {  
            List<CatalogSnapshotLifecycleListener> snapshotListeners = new ArrayList<>();
                    }
    public boolean refreshNeeded() {  
    }  
import org.opensearch.index.translog.NoOpTranslogManager;  
import org.apache.lucene.index.IndexCommit;  
    public void flush() {
            // Files listeners make IndexFileDeleter fire onFilesAdded for the committed snapshot
    }
        return filesByFormat -> {
    }
        return localCheckpointTracker.getProcessedCheckpoint();  
     * No-op deletion policy for the read-only engine.
            }  
        ensureOpen();
    public void flush(boolean force, boolean waitIfOngoing) {  
 * @opensearch.experimental  
    // ---- Getters for internal state (used by tests) ----
    /** Read-only engine does not have indexing buffers. */
    public int fillSeqNoGaps(long primaryTerm) throws IOException {  
        if (isClosed.compareAndSet(false, true)) {  
        close();
    public long getLastWriteNanos() {  
                            format,  
                } catch (IOException e) {  
                }  
 *  
                logger.warn("failEngine threw exception", inner);
                try {  
    // The permanent snapshot ref: held for the engine's lifetime, released in closeNoLock.  
        return statsCache.getDocsStats();
                IOUtils.close(closeables);
    // The snapshot never changes for this engine — build once, reuse across all reads.
            try {  
        return 0;  
                committed,  
        long seqNo,
    }  
    public Engine.Delete prepareDelete(  
    public DataFormatAwareReadOnlyEngine(EngineConfig engineConfig) {
            // at open, eagerly warming the metadata cache before the first query; snapshot
 */
    }  
                snapshotListeners,
import org.apache.lucene.store.AlreadyClosedException;
        DocumentMetadataResolver resolver = engineConfig.getDocumentMetadataResolver() != null
        // No-op for read-only primary
        return 0;  
                    logger.warn(() -> new ParameterizedMessage("failed engine [{}]", reason), failure);
    @Override
        DocumentLookupResult result = documentLookup.getById(get, reader);  
            return failed;
    @Override  
            }  
        ensureOpen();
            return SafeCommitInfo.EMPTY;  
        return localCheckpointTracker.getProcessedCheckpoint();
import org.opensearch.common.logging.Loggers;
    @Override
        long seqNo,  
        long primaryTerm,
            Map<String, Supplier<DataFormatDescriptor>> allDescriptors = registry.getFormatDescriptors(engineConfig.getIndexSettings());
        long ifSeqNo,  
        boolean flush,
    }
                }
import org.apache.lucene.index.IndexWriter;
            }
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
    }
                List<Closeable> closeables = new ArrayList<>(readerManagers.values());  
    @Override
                failedEngine.set(failure != null ? failure : new IllegalStateException(reason));  
        CatalogSnapshotManager catalogSnapshotManagerRef = null;
    }
     */
    }
    @Override
    public long getIndexThrottleTimeInMillis() {  
    LocalCheckpointTracker getLocalCheckpointTracker() {  
            this.statsCache = new CatalogSnapshotStatsCache(catalogSnapshotManagerRef, store, engineConfig, () -> {  
        // No-op for read-only primary
import java.io.IOException;  
import org.opensearch.index.translog.Translog;
    private final GatedCloseable<CatalogSnapshot> permanentSnapshotRef;
                );
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {  
            final SequenceNumbers.CommitInfo seqNoInfo = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(userData.entrySet());
        long version,
    }  
import org.opensearch.plugins.DocumentLookupProvider;
                        store.directory().deleteFile(name);
    }  
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {
        long ifPrimaryTerm  
        if (isClosed.get()) {
    @Override
            for (Map.Entry<DataFormat, EngineReaderManager<?>> entry : readerManagersRef.entrySet()) {  
        return readerManagers;  
 *
    @Override
    private final ReleasableLock readLock = new ReleasableLock(rwl.readLock());
            // Catalog file deleter  
        return false;
        ensureOpen();
            closedLatch.await();  
    }
    private final DocumentLookupSupport documentLookup;
                store.shardPath(),
    public void activateThrottling() {
    @Override
    ) {
    }
        boolean isRetry,
import java.util.Optional;
    public GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException {  
                            store.shardPath(),
    public void refresh(String source) throws EngineException {
    public void ensureOpen() {
                this::ensureOpen,
        long ifPrimaryTerm  
    // Stats cache — populated once at construction (snapshot is permanent for this engine).
        boolean accurateCount  
    }  
        String source,
        return () -> {};  
            Map<DataFormat, EngineReaderManager<?>> aggregated = new HashMap<>();
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        SourceToParse source,
    }
import org.opensearch.index.mapper.SourceToParse;
    }
            if (this.historyUUID == null) {
                : "Either the write lock must be held or the engine must be currently failing";
    private final Committer committer;  
                    IOUtils.closeWhileHandlingException(readerManagersRef.values());
        // No-op
    Map<DataFormat, EngineReaderManager<?>> getReaderManagers() {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        }
    // ---- IndexReaderProvider (Task 2) ----  
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
                    logger.warn(() -> new ParameterizedMessage("tried to fail engine but already failed, ignoring. [{}]", reason), failure);  
                }
            if (success == false) {  
    }  
    private void closeNoLock(String reason) {
                        failed.computeIfAbsent(formatName, k -> new ArrayList<>()).add(name);  
    }
            }
        // Warm primaries use this engine; warm replicas use DataFormatAwareNRTReplicationEngine (which returns true).
    }
                    inner.addSuppressed(failure);  
        long autoGeneratedIdTimestamp,
import org.opensearch.index.engine.exec.commit.CommitterConfig;
 * SPDX-License-Identifier: Apache-2.0
        return 0;
                }
        String id,
        long version,
import org.opensearch.index.seqno.LocalCheckpointTracker;
    }  
                    logger.warn("Failed to get last committed data for stats cache", e);
 * <p>This engine is the flip target when a read-only replica is promoted to primary
        return localCheckpointTracker;
    @Override
                    readers.put(entry.getKey(), r);  
        boolean onlyExpungeDeletes,
        int maxNumSegments,  
    @Override
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
        Engine.Operation.Origin origin,
    }
            this.catalogSnapshotManager = catalogSnapshotManagerRef;
            } catch (Exception inner) {
        return statsCache.getSegments();
        return translogManager;
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;  
    }
    @Override
    }  
    }  
                if (readerManagersRef != null) {
import java.util.concurrent.locks.ReentrantReadWriteLock;  
    /** Read-only primaries do not run merges; the active count is always zero. */  
        awaitPendingClose();
    public CompletionStats completionStats(String... fieldNamePatterns) {
        public List<CatalogSnapshot> onInit(List<CatalogSnapshot> commits) {
    public String getHistoryUUID() {
        @Override
    }  
    }
            // Initialize no-op translog
    private void awaitPendingClose() {
        );
                    )  
    }
        };
        try (GatedCloseable<CatalogSnapshot> snapshot = catalogSnapshotManager.acquireSnapshot()) {  
        DocumentMapperForType docMapper,  
            logger.info("Created DataFormatAwareReadOnlyEngine");
        boolean upgrade,
            );
        // No-op: read-only engine does not merge  
            ? engineConfig.getDocumentMetadataResolver()  
import org.opensearch.common.unit.TimeValue;  
        }  
        return false;
        // No-op
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException {
    private FileDeleter buildFileDeleter() {  
    @Override
                } finally {  
    }
            }  
    // ---- LifecycleAware ----
    @Override
import java.io.Closeable;
    private final LocalCheckpointTracker localCheckpointTracker;
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();  
    }  
                    }
    public GatedCloseable<Reader> acquireReader() throws IOException {  
        String forceMergeUUID
        try {
import org.opensearch.common.SetOnce;
        }
                    engineConfig.getEventListener().onFailedEngine(reason, failure);
        return historyUUID;  
import org.opensearch.index.engine.exec.EngineReaderManager;
            }  
    @Override
        boolean requiredFullRange,
            DataFormatRegistry registry = engineConfig.getDataFormatRegistry();  
            Map<String, Collection<String>> failed = new HashMap<>();
    }
    private final EngineConfig engineConfig;  
    private final CountDownLatch closedLatch = new CountDownLatch(1);
import org.opensearch.index.engine.exec.FilesListener;
            Map<DataFormat, Object> readers = new HashMap<>();
 * Read-only engine for primaries operating on pluggable data formats.
            Map<String, String> userData = committer.getLastCommittedData();
        if (isClosed.get() == false) {  
    // ---- IndexerStateManager (Task 8) ----  
        return new CompletionStats();
    private final ReentrantLock failEngineLock = new ReentrantLock();  
    @Override
            for (String formatName : allDescriptors.keySet()) {  
    @Override
    @Override  
        DocumentLookupProvider provider = documentLookupProvider != null
    @Override  
    public Closeable acquireHistoryRetentionLock() {
    }
    @Override
            Map<String, FilesListener> filesListeners = new HashMap<>();
        return null;
    @Override  
                        new ReaderManagerConfig(
                    return;
import org.opensearch.index.translog.TranslogManager;
    public boolean maybeRefresh(String source) {
        // No-op: no indexing buffer  
        // No-op  
    public TranslogManager translogManager() {  
    @Override  
            catalogSnapshotManagerRef = new CatalogSnapshotManager(
            // History UUID — fabricate if absent (same as NRT engine) for recovery protocol compliance
                        // already gone  
    }  
                        logger.warn("Failed to delete file [{}] in format [{}]: {}", name, formatName, e.getMessage());
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support indexing");
            : DocumentMetadataResolver.NOOP;
    @Override  
    public void writeIndexingBuffer() throws EngineException {
            FileDeleter compositeDeleter = buildFileDeleter();
        // No-op: data-format engines do not maintain Lucene-style delete tombstones
import java.util.ArrayList;
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
import java.util.concurrent.locks.ReentrantLock;
    public EngineConfig config() {
    @Override
    }
    private final DataFormatAwareEngine.DataFormatAwareReader reader;  
    @Override
    public Translog.Snapshot newChangesSnapshot(
    }
        Map<DataFormat, EngineReaderManager<?>> readerManagersRef = null;  
            try {
    private volatile String historyUUID;
        return 0;  
        return result.exists() ? result.toGetResult() : Engine.GetResult.NOT_EXISTS;
                }  
    @Override  
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support deletes");
                            store.getDataformatAwareStoreHandles(),  
                    return committer.getLastCommittedData();
                    closedLatch.countDown();
            // Acquire permanent snapshot ref — held for engine's lifetime, released in closeNoLock.
    }
    @Override  
            // listeners build the reader before latestCatalogSnapshot is swapped.  
        throw new UnsupportedOperationException(  
                new TranslogStats(0, 0, 0, 0, 0),
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {
                    logger.debug("engine closed [{}]", reason);
    public long getHeapBytesUsed() {
import java.util.List;  
        this.shardId = engineConfig.getShardId();
    @Override
    }  
        long ifPrimaryTerm
    }
 */  
            }  
            }  
        return catalogSnapshotManager.acquireSnapshot();
        return false;  
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support no-ops");  
    public void close() throws IOException {
import org.opensearch.index.merge.MergeStats;  
import org.opensearch.index.store.Store;
    public long getPersistedLocalCheckpoint() {  
            } finally {
    }
            // Create committer: isReplica=true opens the index without acquiring write.lock.
    public MergeStats getMergeStats() {
    CatalogSnapshotManager getCatalogSnapshotManager() {
    /** Read-only primaries do not run merges. */  
        assert engineConfig.isReadOnlyReplica() == false : "DataFormatAwareReadOnlyEngine must only be created for primary shards; shard "
    ) throws EngineException, IOException {
    public long unreferencedFileCleanUpsPerformed() {
            // Register reader managers as BOTH files listeners and snapshot lifecycle listeners.  
        // No-op: no translog deletion policy to update
            }  
        return 0;
                logger.error("failed to close engine", e);
    // ---- IndexerStatistics (Task 8) ----
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;  
                translogUUID != null ? translogUUID : "readonly-" + shardId,
    @Override
import org.opensearch.common.util.concurrent.ReleasableLock;
    }
import org.opensearch.index.VersionType;
                if (isClosed.get() == false) {  
        long toSeqNo,
public class DataFormatAwareReadOnlyEngine implements Indexer {  
    public void maybePruneDeletes() {  
            this.historyUUID = userData.get(Engine.HISTORY_UUID_KEY);  
        boolean upgradeOnlyAncientSegments,  
            this.permanentSnapshotRef = catalogSnapshotManagerRef.acquireSnapshot();
        } else {
                snapshotListeners.add(entry.getValue());
    // ---- Recovery and Snapshot support (Task 6) ----  
    }
    @Override
    }  
        if (failEngineLock.tryLock()) {  
                filesListeners.put(entry.getKey().name(), entry.getValue());
                try {
        return catalogSnapshotManager.acquireSnapshot();  
    }  
                        continue;
        throw new UnsupportedOperationException("DataFormatAwareReadOnlyEngine does not support deletes");
/**
 * it has no {@link IndexWriter}, no active translog, and rejects all write  
                }
    @Override  
import org.opensearch.index.engine.exec.Indexer;
        return 0;
        return startingSeqNo > localCheckpointTracker.getMaxSeqNo();
import org.opensearch.core.common.unit.ByteSizeValue;  
    @Override  
    public DataFormatAwareReadOnlyEngine(EngineConfig engineConfig, @Nullable DocumentLookupProvider documentLookupProvider) {
        @Override
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {
    // ---- Internal helpers ----  
    public PollingIngestStats pollingIngestStats() {  
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
        long seqNo,  
            logger.debug(() -> new ParameterizedMessage("tried to fail engine but could not acquire lock [{}]", reason), failure);
        this.engineConfig = engineConfig;  
        store.incRef();
        public SafeCommitInfo getSafeCommitInfo() {
    public boolean hasPendingMerges() {
        return catalogSnapshotManager.acquireSnapshot();
import org.opensearch.index.seqno.SeqNoStats;
    }
        return false;
        try {
    private final Store store;
        @Override  
                            registry,
        return translogManager.getLastSyncedGlobalCheckpoint();
import java.util.concurrent.atomic.AtomicBoolean;
    @Override
    private final SetOnce<Exception> failedEngine = new SetOnce<>();
            ? documentLookupProvider  
    @Override  
    }  
                }
            // Initialize sequence number tracking
    private final ShardId shardId;
    @Override
            success = true;
    public DocsStats docStats() {
                closeNoLock("api");
    @Override  
    @Override  
    }
    @Override
        // Callers must not release it — use a no-op close callback.  
        } finally {
import org.opensearch.index.engine.exec.DocumentLookupSupport;  
        // The reader holds a permanent snapshotRef for the engine's lifetime.
            assert rwl.isWriteLockedByCurrentThread() || failEngineLock.isHeldByCurrentThread()
                        )
    private final NoOpTranslogManager translogManager;
        VersionType versionType,  
import org.opensearch.core.index.shard.ShardId;
import java.util.concurrent.CountDownLatch;  
}  
 * this file be licensed under the Apache-2.0 license or a
    }
                committer  
            throw new UncheckedIOException(e);  
        throws IOException {
            "acquireSafeIndexCommit is not supported on DataFormatAwareReadOnlyEngine; use acquireSafeCatalogSnapshot"
import org.opensearch.index.translog.TranslogStats;  
 * operations. Reads route through {@code TieredSubdirectoryAwareDirectory}
    // Metadata
                compositeDeleter,
    }
import org.opensearch.index.engine.exec.FileDeleter;  
    }
     * The warm primary never creates new snapshots, so nothing is ever deleted.  
        } catch (IOException e) {  
    @Override
    @Override  
            for (Map.Entry<DataFormat, EngineReaderManager<?>> entry : readerManagersRef.entrySet()) {  
        // No-op  
            this.readerManagers = readerManagersRef;
    private final CatalogSnapshotManager catalogSnapshotManager;
                            engineConfig.getIndexSettings()
    }  
            // Build stats cache — snapshot is permanent for this engine, so populate once at construction.
    public long getWritingBytes() {
                readLock,  
import java.util.Map;
            readerManagersRef = Map.copyOf(aggregated);  
    }
        // No-op: read-only engine does not flush. State is fully remote.
        }
        } catch (IOException e) {
    @Override
                new NoOpCatalogSnapshotDeletionPolicy(),
        long primaryTerm,
        VersionType versionType,
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
    public Engine.DeleteResult delete(Engine.Delete delete) throws IOException {  
    }  
    public long getNativeBytesUsed() {
        this.documentLookup = new DocumentLookupSupport(shardId, provider, resolver);
    public CommitStats commitStats() {
    @Override  
        }
        }  
    }  
    @Nullable  
                final String formatName = entry.getKey();
    }  
        return 0;
    public void flushAndClose() throws IOException {  
    @Override
 * compatible open source license.
        return Translog.EMPTY_TRANSLOG_SNAPSHOT;
    @Override
    private final AtomicBoolean isClosed = new AtomicBoolean(false);  
    }
import org.opensearch.common.Nullable;  
                // Release the permanent snapshot ref before closing reader managers and catalog.
import org.opensearch.index.seqno.SequenceNumbers;  
    @Override
    ) {
    @Override
                Object r = entry.getValue().getReader(permanentSnapshotRef.get());
        // Segments are immediately visible upon replication; processed == persisted
                    registry.getReaderManager(  
    @Override  
        }
import org.opensearch.index.engine.dataformat.DataFormat;  
                closeables.add(catalogSnapshotManager);
        // flushFirst is ignored — read-only engine does not flush
    @Override  
    }
                try {
        return new GatedCloseable<>(reader, () -> {});
    @Override
                }
import org.opensearch.index.engine.exec.LiveDocsSource;  
    @Override
    /** Read-only engine does not have indexing buffers. */
    }  
    public boolean isThrottled() {
            List<CatalogSnapshot> committed = committer.listCommittedSnapshots();  
            this.translogManager = new NoOpTranslogManager(
    // Lifecycle
    }
    }
    }  
