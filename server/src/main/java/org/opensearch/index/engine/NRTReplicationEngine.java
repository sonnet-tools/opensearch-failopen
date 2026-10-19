        ensureOpen();
        return false;
    }
        return localCheckpointTracker.getProcessedCheckpoint();
        // get a reference to the previous commit files so they can be decref'd once a new commit is made.
                        if (isEngineClosed.get() == false) {
    public void maybePruneDeletes() {}
        }
     * in {@link InternalEngine} used by NRT primary shards.
        }
                 This is a workaround solution which decreases the chances of conflict on replica nodes when same file is copied
        return false;
                        readerManager.release(reader);
    @Override
        return completionStatsCache.get(fieldNamePatterns);
                    // mark the store corrupted unless we are closing as result of engine failure.
    public long getMaxSeqNoOfUpdatesOrDeletes() {
                    // in this case Engine#failShard will handle store corruption.
            } catch (Exception e) {
        return Arrays.asList(getSegmentInfo(getLatestSegmentInfos(), verbose));
            if (success == false) {
                    // failure, we need to dec the store reference
    @Override
    public boolean maybeRefresh(String source) throws EngineException {
                getTranslogDeletionPolicy(engineConfig),
    }
import org.apache.lucene.index.IndexCommit;
                }
    public boolean isThrottled() {
 * this file be licensed under the Apache-2.0 license or a
            localCheckpointTracker.fastForwardProcessedSeqNo(maxSeqNo);
        return translogManager.getLastSyncedGlobalCheckpoint();
    }
            }
            AtomicBoolean isEngineClosed,
    public long getIndexThrottleTimeInMillis() {
            // In that case we still commit into the next local generation.
            }
                engineConfig.getTranslogFactory(),
        }
import org.opensearch.index.seqno.SequenceNumbers;
     * <p>
     */
                if (waitIfOngoing == false) {
                    replicaFileTracker.decRef(files);
package org.opensearch.index.engine;
        return 0;
                 This is not required for remote store implementations given on failover the replica re-syncs with the store
    public NoOpResult noOp(NoOp noOp) throws IOException {
        return 0;
     */
    }
    private DirectoryReader getDirectoryReader() throws IOException {
import org.opensearch.common.util.io.IOUtils;
            NRTReplicationReaderManager readerManager
                flushLock.unlock();
            if (flushLock.tryLock() == false) {
    private volatile SegmentInfos lastCommittedSegmentInfos;
            }
            ensureOpen();
        try {
 *
    public long getIndexBufferRAMBytesUsed() {
    }
    @Override
                 from two different primaries during failover. Increasing counter helps in avoiding this conflict as counter is
        private final NRTReplicationReaderManager readerManager;
    @Override
                } catch (IOException e) {
            final Collection<String> files = latestSegmentInfos.files(false);
    @Override
        if (flushFirst) {
            engineConfig
        }
    @Override
    }
    public DeleteResult delete(Delete delete) throws IOException {
        MergeStats mergeStats = new MergeStats();
    }
import org.opensearch.index.translog.WriteOnlyTranslogManager;
        return new SafeCommitInfo(localCheckpointTracker.getProcessedCheckpoint(), lastCommittedSegmentInfos.totalMaxDoc());
    }
                        }
            throw new EngineException(shardId, "Unable to build latest IndexCommit", e);
                } catch (RuntimeException e) {
            this.localCheckpointTracker = new LocalCheckpointTracker(commitInfo.maxSeqNo, commitInfo.localCheckpoint);
    @Override
        return loadHistoryUUID(lastCommittedSegmentInfos.userData);
        throw new UnsupportedOperationException("Not implemented");
            // Wire up a warmer listener to trigger index warming
    @Override
import org.apache.lucene.search.ReferenceManager;
        return mergeStats;
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
    private void commitSegmentInfos() throws IOException {
import org.opensearch.core.common.unit.ByteSizeValue;
                try {
    public void writeIndexingBuffer() throws EngineException {}
                /*
    public Translog.Snapshot newChangesSnapshot(
 */
        return getFromSearcher(get, searcherFactory, SearcherScope.EXTERNAL);
    public List<Segment> segments(boolean verbose) {
    private final CompletionStatsCache completionStatsCache;
    private final Object lastCommittedSegmentInfosMutex = new Object();
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {
                    logger.debug("engine closed [{}]", reason);
    @Override
     */
    @Override
            );
            if (didRefresh && warmer != null) {
    public long getMinRetainedSeqNo() {
                flush(false, true);
    @Override
import org.opensearch.index.seqno.SeqNoStats;
        // decref the prev commit.
 * @opensearch.api
    protected ReferenceManager<OpenSearchDirectoryReader> getReferenceManager(SearcherScope scope) {
import java.io.Closeable;
        try {
import java.util.Map;
                flushLock.lock();
                IOUtils.close(readerManager, translogManager);
            // We also do not want to wire up refresh listeners for waitFor & pending refresh location.
            throw new EngineException(shardId, e.getMessage(), e);
        } catch (IOException | TranslogCorruptedException e) {
                 during promotion.
import java.util.function.BiFunction;
    @Override
        return localCheckpointTracker;
            replicaFileTracker.incRef(files);
            flush(false, true);
            EngineConfig engineConfig,
import static org.opensearch.index.seqno.SequenceNumbers.MAX_SEQ_NO;
                        warmer.warm(reader);
                try {
        final Collection<String> previousCommitFiles = getLastCommittedSegmentInfos().files(true);
        String forceMergeUUID
            replicaFileTracker::incRef,
     * comparing the on-disk SegmentInfos version against the one in the reader, which at refresh points will always return isCurrent false and then refreshNeeded true.
        return false;
    }
        } catch (IOException e) {
import java.util.Collection;
                    }
        boolean upgradeOnlyAncientSegments,
     * Even if this method returns refresh as needed, we ignore it and only ever refresh with incoming SegmentInfos.
                return new GatedCloseable<>(indexCommit, () -> { replicaFileTracker.decRef(files); });
            flush(false, true);
    }
    public boolean refreshNeeded() {
            }
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
    }
                            logger.warn("Unable to mark store corrupted", ex);
    public CompletionStats completionStats(String... fieldNamePatterns) {
        NRTReplicationReaderManager readerManager = null;
    protected final void closeNoLock(String reason, CountDownLatch closedLatch) {
import org.opensearch.common.lucene.Lucene;
                translogManager.getDeletionPolicy().setLocalCheckpointOfSafeCommit(maxSeqNo);
                 */
     * With this Engine's NRTReplicationReaderManager, This will use StandardDirectoryReader's implementation which determines if the reader is current by
    }
    }
     * @opensearch.internal
                final Collection<String> files = indexCommit.getFileNames();
                        try {
import java.util.concurrent.atomic.AtomicBoolean;
        );
    @Override
     * refresh attempts so we can return false here.  Further Engine's existing implementation reads DirectoryReader.isCurrent after acquiring a searcher.
                }
                        } catch (IOException ex) {
    }
            assert rwl.isWriteLockedByCurrentThread() || failEngineLock.isHeldByCurrentThread()
        private final Logger logger;
        if (flushFirst) {
import java.io.IOException;
        }
     * in-memory {@code lastCommittedSegmentInfos} as a {@link SegmentInfosCatalogSnapshot} while
            );
                        commitSegmentInfos(latestSegmentInfos);
    public void forceMerge(
    @Override
import java.util.concurrent.locks.ReentrantLock;
            return;
    @Override
        return localCheckpointTracker.getPersistedCheckpoint();
                    latestSegmentInfos.changed();
    public void activateThrottling() {}
    public long getPersistedLocalCheckpoint() {
        throw new UnsupportedOperationException("Not implemented");
    ) throws IOException {
            DirectoryReader.open(store.directory(), engineConfig.getLeafSorter()),
            }
    @Override
        return 0;
    @ExperimentalApi
                            logger.warn("failed to warm reader replica", e);
     * {@link Engine.Warmer}) occurs on NRT replica shards, consistent with the warming behavior
 */
    @Override
                maybeFailEngine("flush", e);
                        logger.warn("failed to acquire reader for warming on replica", e);
            final long maxSeqNo = Long.parseLong(infos.userData.get(MAX_SEQ_NO));
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException {
    public int fillSeqNoGaps(long primaryTerm) throws IOException {
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
        } finally {
 *
            replicaFileTracker.incRef(this.lastCommittedSegmentInfos.files(true));
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {}
    @Override
            final String translogUUID = Objects.requireNonNull(userData.get(Translog.TRANSLOG_UUID_KEY));
            } catch (IOException e) {
    public SafeCommitInfo getSafeCommitInfo() {
    private volatile long lastReceivedPrimaryGen = SequenceNumbers.NO_OPS_PERFORMED;
                } finally {
    }
            this.logger = logger;
     *
    }
    @Override
                final SegmentInfos latestSegmentInfos = getLatestSegmentInfos();
import org.opensearch.index.translog.TranslogDeletionPolicy;
            throw new EngineCreationFailureException(shardId, "failed to create engine", e);
                }
    public long getLastSyncedGlobalCheckpoint() {
            // always protect latest commit on disk.
        commitSegmentInfos(getLatestSegmentInfos());
import org.opensearch.index.merge.MergeStats;
    @Override
    }
        return 0;
    private static final int SI_COUNTER_INCREMENT = 100000;
import org.opensearch.index.seqno.LocalCheckpointTracker;
    @Override
                 used to generate new segment file names. The ideal solution is to identify the counter from previous primary.
                }
        }
        // incref all files
                    latestSegmentInfos.counter = latestSegmentInfos.counter + SI_COUNTER_INCREMENT;
 * with new Segments when received from an external source.
        return readerManager;
        final TranslogDeletionPolicy translogDeletionPolicy = translogManager.getDeletionPolicy();
            } finally {
    public void deactivateThrottling() {}
        translogDeletionPolicy.setRetentionAgeInMillis(translogRetentionAge.millis());
        ensureOpen();
    @Override
    }
        @Override
                commitSegmentInfos();
        replicaFileTracker.decRef(previousCommitFiles);
            final SequenceNumbers.CommitInfo commitInfo = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
    }
    protected SegmentInfos getLatestSegmentInfos() {
        ensureOpen();
        // get reference to latest infos
@PublicApi(since = "1.0.0")
            cleanUnreferencedFiles();
                }
        return readerManager.getSegmentInfos();
        return acquireLastIndexCommit(false);
    public long getProcessedLocalCheckpoint() {
import java.util.Arrays;
import org.opensearch.index.translog.TranslogManager;
}
        } catch (IOException e) {
                try {
    }
    }
    /**
    }
        boolean onlyExpungeDeletes,
/**
    protected final ReplicaFileTracker replicaFileTracker;
        boolean upgrade,
                    }
    @Override
        // Skip flushing for indices with partial locality (warm indices)
    }
                    && engineConfig.getIndexSettings().isAssignedOnRemoteNode() == false) {
    public GatedCloseable<IndexCommit> acquireLastIndexCommit(boolean flushFirst) throws EngineException {
            return new GatedCloseable<>(latestSegmentInfos, () -> { replicaFileTracker.decRef(files); });
        return false;
    }
    private final LocalCheckpointTracker localCheckpointTracker;
    @Override
import org.apache.lucene.index.SegmentInfos;
            success = true;
        return 0;
import org.opensearch.index.translog.TranslogOperationHelper;
    }
            // Only wire up the internal listeners.
import org.opensearch.index.translog.Translog;
import org.opensearch.common.concurrent.GatedCloseable;
            final long incomingGeneration = infos.getGeneration();
    }
                    final CatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(infos);
        translogManager.syncTranslog();
        // for segment replication: replicas should create the reader from store, we don't want an open IW on replicas.
        translogDeletionPolicy.setRetentionSizeInBytes(translogRetentionSize.getBytes());
                if (engineConfig.getIndexSettings().isRemoteStoreEnabled() == false
        private final Engine.Warmer warmer;
            // Update the current infos reference on the Engine's reader.
            } finally {
            OpenSearchDirectoryReader.wrap(getDirectoryReader(), shardId),
            translogManagerRef = new WriteOnlyTranslogManager(
import org.opensearch.index.translog.TranslogCorruptedException;
            throw new EngineException(shardId, "Unable to acquire last CatalogSnapshot", e);
    }
 * is enabled.  This Engine does not create an IndexWriter, rather it refreshes a {@link NRTReplicationReaderManager}
                    if (isEngineClosed.get() == false) {
import java.util.concurrent.CountDownLatch;
            readerManager = buildReaderManager();
    @Override
        try {
                    if (failEngineLock.isHeldByCurrentThread() == false && store.isMarkedCorrupted() == false) {
    }
        long fromSeqNo,
     * Parallel to {@link #acquireLastIndexCommit(boolean)}: optionally flushes, then wraps the
            replicaFileTracker.incRef(this.lastCommittedSegmentInfos.files(true));
     * Refreshing of this engine will only happen internally when a new set of segments is received.  The engine will ignore external
                    try {
        private final AtomicBoolean isEngineClosed;
        // readLock is held here to wait/block any concurrent close that acquires the writeLock.
     * A {@link ReferenceManager.RefreshListener} that warms new segments when the reader is refreshed
        ensureOpen();
    private final NRTReplicationReaderManager readerManager;
import java.util.Objects;
    public synchronized void updateSegments(final SegmentInfos infos) throws IOException {
        if (isClosed.compareAndSet(false, true)) {
            synchronized (lastCommittedSegmentInfosMutex) {
        try {
    @Override
    public boolean shouldPeriodicallyFlush() {
        @Override
                final IndexCommit indexCommit = Lucene.getIndexCommit(lastCommittedSegmentInfos, store.directory());
                            store.markStoreCorrupted(e);
        }
        // For these indices, we don't need to commit as we will sync from the remote store on re-open
            this.lastReceivedPrimaryGen = incomingGeneration;
    @Override
                    }
                engineConfig.getPrimaryTermSupplier(),
            // We do not compare against the last local commit gen here because it is possible to receive
                final SegmentInfos infos = lastCommittedSegmentInfos;
                replicaFileTracker.incRef(files);
                    throw e;
import org.apache.lucene.index.DirectoryReader;
        }
    @Override
    public void flush(boolean force, boolean waitIfOngoing) throws EngineException {
    protected SegmentInfos getLastCommittedSegmentInfos() {
        return false;
                try {
        store.incRef();
        boolean success = false;
    @Override
    }
                translogUUID,
            // cleanup anything not referenced by the latest infos.
        WarmerRefreshListener(
/*
                throw new FlushFailedEngineException(shardId, e);
public class NRTReplicationEngine extends Engine {
    }
    public IndexResult index(Index index) throws IOException {
        if (engineConfig.getIndexSettings().isWarmIndex()) {
                    OpenSearchDirectoryReader reader = readerManager.acquire();
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
        store.commitSegmentInfos(infos, localCheckpointTracker.getMaxSeqNo(), localCheckpointTracker.getProcessedCheckpoint());
    public TranslogManager translogManager() {
    @Override
            this.completionStatsCache = new CompletionStatsCache(() -> acquireSearcher("completion_stats"));
    private final WriteOnlyTranslogManager translogManager;
                }
 * The OpenSearch Contributors require contributions made to
        boolean accurateCount
                    closedLatch.countDown();
        WriteOnlyTranslogManager translogManagerRef = null;
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
            this.readerManager.addListener(completionStatsCache);
    private final Lock flushLock = new ReentrantLock();
    @Override
        try (ReleasableLock lock = writeLock.acquire()) {
                    store.decRef();
            this.translogManager = translogManagerRef;
            Logger logger,
    /**
            this.isEngineClosed = isEngineClosed;
            for (ReferenceManager.RefreshListener listener : engineConfig.getInternalRefreshListener()) {
    @Override
import java.util.List;
        return localCheckpointTracker.getStats(globalCheckpoint);
            this.warmer = engineConfig.getWarmer();
    }
    }
                IOUtils.closeWhileHandlingException(readerManager, translogManagerRef);
    static final class WarmerRefreshListener implements ReferenceManager.RefreshListener {
        synchronized (lastCommittedSegmentInfosMutex) {
    public MergeStats getMergeStats() {
    public void refresh(String source) throws EngineException {
        }
            // we are now locked.
            // which are the current external listeners set from IndexShard.
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            this.readerManager = readerManager;
            }
        return lastCommittedSegmentInfos;
                } catch (IOException e) {
            synchronized (lastCommittedSegmentInfosMutex) {
            }
    ) throws EngineException, IOException {}
    public NRTReplicationEngine(EngineConfig engineConfig) {
            // when new segments arrive via segment replication
                    if (engineConfig.getIndexSettings().isWarmIndex() == false) {
    @Override
    @Override
    }
import org.apache.logging.log4j.Logger;
    public void cleanUnreferencedFiles() throws IOException {
        mergeStats.add(engineConfig.getMergedSegmentTransferTracker().stats());
                        }
            // Ensure that we commit and clear the local translog if a new commit has been made on the primary.
            this.replicaFileTracker = new ReplicaFileTracker(store::deleteQuiet);
                }
        return localCheckpointTracker.getMaxSeqNo();
            this.readerManager.addListener(new WarmerRefreshListener(logger, isClosed, engineConfig, this.readerManager));
    }
        public void beforeRefresh() throws IOException {}
                this.lastCommittedSegmentInfos.getUserData().entrySet()
                engineConfig.getTranslogConfig(),
    }
     */
    @Override
                    store.decRef();
    }
    }
     * This method creates a commit point from the latest SegmentInfos.
            this.lastCommittedSegmentInfos = store.readLastCommittedSegmentsInfo();
        return NRTReplicaTranslogOps.noOp(translogManager, localCheckpointTracker, noOp);
                engineConfig.getGlobalCheckpointSupplier(),
     *
    public long getWritingBytes() {
    }
        return NRTReplicaTranslogOps.delete(translogManager, localCheckpointTracker, delete);
                replicaFileTracker.incRef(files);
            // NRT Replicas do not have a concept of Internal vs External reader managers.
    @Override
            if (incomingGeneration != this.lastReceivedPrimaryGen) {
    /**
    }
        }
            // a lower gen from a newly elected primary shard that is behind this shard's last commit gen.
        return acquireLastCommitedCatalogSnapshot(false);
    public String getHistoryUUID() {
            // incref the latest on-disk commit.
                logger.error("failed to close engine", e);
        return translogManager;
import org.apache.lucene.index.SoftDeletesDirectoryReaderWrapper;
     * Persist the latest live SegmentInfos.
    }
    public synchronized GatedCloseable<SegmentInfos> getSegmentInfosSnapshot() {
            ensureOpen();
            try {
                    return;
                TranslogOperationHelper.create(engineConfig)
                if (isClosed.get() == false) {
    /**
        boolean requiredFullRange,
        long toSeqNo,
    @Override
        } catch (IOException e) {
                this,
    @Override
                readLock,
        }
        // Refresh on this engine should only ever happen in the reader after new segments arrive.
            this.readerManager = readerManager;
        );
    }
            readerManager.updateSegments(infos);
        boolean flush,
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {
                this.readerManager.addListener(listener);
            Lucene.SOFT_DELETES_FIELD
            this.lastCommittedSegmentInfos = store.readLastCommittedSegmentsInfo();
        String source,
    }
        return new SoftDeletesDirectoryReaderWrapper(
     * during segment replication. This ensures index warming (e.g., loading global ordinals via
import org.opensearch.common.annotation.ExperimentalApi;
                engineConfig.getStartedPrimarySupplier(),
    private NRTReplicationReaderManager buildReaderManager() throws IOException {
                    } catch (Exception e) {
    }
    }
                    } finally {
    protected LocalCheckpointTracker getLocalCheckpointTracker() {
        final SegmentInfos latestSegmentInfos = getLatestSegmentInfos();
        replicaFileTracker.deleteUnreferencedFiles(store.directory().listAll());
                shardId,
            try {
    @Override
    public Closeable acquireHistoryRetentionLock() {
        }
    private void commitSegmentInfos(SegmentInfos infos) throws IOException {
    @Override
            replicaFileTracker::decRef,
    @Override
                    return new GatedCloseable<>(snapshot, () -> replicaFileTracker.decRef(files));
        ) {
                final Collection<String> files = infos.files(true);
        return NRTReplicaTranslogOps.index(translogManager, localCheckpointTracker, index);
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {}
    }
        super(engineConfig);
        }
import org.opensearch.common.annotation.PublicApi;
 * This is an {@link Engine} implementation intended for replica shards when Segment Replication
    @Override
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.search.suggest.completion.CompletionStats;
import org.opensearch.common.unit.TimeValue;
                NRTReplicaTranslogOps.createTranslogEventListener(this::failEngine, this::translogManager, shardId),
     * pinning the referenced files via {@code replicaFileTracker}. Avoids re-reading {@code segments_N}.
     * @throws IOException - When there is an IO error committing the SegmentInfos.
    @Override
        try (final ReleasableLock lock = readLock.acquire()) {
        int maxNumSegments,
    private GatedCloseable<CatalogSnapshot> acquireLastCommitedCatalogSnapshot(boolean flushFirst) throws EngineException {
                translogManager.rollTranslogGeneration();
    }
    @Override
    @Override
        return new NRTReplicationReaderManager(
import java.util.concurrent.locks.Lock;
 * compatible open source license.
    }
        return localCheckpointTracker.getProcessedCheckpoint();
            }
                    }
    }
                this::getLocalCheckpointTracker,
import org.opensearch.common.util.concurrent.ReleasableLock;
    }
            final Map<String, String> userData = this.lastCommittedSegmentInfos.getUserData();
        public void afterRefresh(boolean didRefresh) {
    public GetResult get(Get get, BiFunction<String, SearcherScope, Searcher> searcherFactory) throws EngineException {
                : "Either the write lock must be held or the engine must be currently be failing itself";
            }
