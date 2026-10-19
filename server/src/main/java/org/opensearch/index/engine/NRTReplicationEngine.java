import org.opensearch.index.merge.MergeStats;  
            this.warmer = engineConfig.getWarmer();
     *  
                    }
    }
import org.opensearch.common.unit.TimeValue;  
                 */
}  
            this.readerManager.addListener(completionStatsCache);
    public long getPersistedLocalCheckpoint() {
    @Override
            flush(false, true);
        try {
import java.io.Closeable;  
            } catch (IOException e) {
                    // failure, we need to dec the store reference
 * SPDX-License-Identifier: Apache-2.0
                    store.decRef();  
            throw new EngineException(shardId, "Unable to acquire last CatalogSnapshot", e);  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            // In that case we still commit into the next local generation.  
            }
            assert rwl.isWriteLockedByCurrentThread() || failEngineLock.isHeldByCurrentThread()  
    public long getProcessedLocalCheckpoint() {  
     * Persist the latest live SegmentInfos.  
        private final NRTReplicationReaderManager readerManager;  
    }  
    @Override  
            DirectoryReader.open(store.directory(), engineConfig.getLeafSorter()),
import org.opensearch.index.translog.TranslogOperationHelper;
            }
            this.replicaFileTracker = new ReplicaFileTracker(store::deleteQuiet);  
    public long getMaxSeqNoOfUpdatesOrDeletes() {
        ensureOpen();  
     */
            this.lastCommittedSegmentInfos = store.readLastCommittedSegmentsInfo();
        return localCheckpointTracker.getProcessedCheckpoint();
        translogDeletionPolicy.setRetentionSizeInBytes(translogRetentionSize.getBytes());  
    }
    }
    @Override  
    }
            final SequenceNumbers.CommitInfo commitInfo = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
                    latestSegmentInfos.changed();
        return localCheckpointTracker.getStats(globalCheckpoint);  
    public IndexResult index(Index index) throws IOException {
        final TranslogDeletionPolicy translogDeletionPolicy = translogManager.getDeletionPolicy();
        return translogManager.getLastSyncedGlobalCheckpoint();
        throw new UnsupportedOperationException("Not implemented");  
        throw new UnsupportedOperationException("Not implemented");
                    }  
        try (final ReleasableLock lock = readLock.acquire()) {  
        }  
    private volatile SegmentInfos lastCommittedSegmentInfos;
                 This is a workaround solution which decreases the chances of conflict on replica nodes when same file is copied
            // a lower gen from a newly elected primary shard that is behind this shard's last commit gen.
            replicaFileTracker.incRef(files);
    public GatedCloseable<IndexCommit> acquireLastIndexCommit(boolean flushFirst) throws EngineException {
            // incref the latest on-disk commit.  
                    if (engineConfig.getIndexSettings().isWarmIndex() == false) {
        }
        long fromSeqNo,
     * <p>
    }
                        warmer.warm(reader);
        boolean upgrade,
     * Refreshing of this engine will only happen internally when a new set of segments is received.  The engine will ignore external  
        // Refresh on this engine should only ever happen in the reader after new segments arrive.
            this.localCheckpointTracker = new LocalCheckpointTracker(commitInfo.maxSeqNo, commitInfo.localCheckpoint);
    public List<Segment> segments(boolean verbose) {
                this,  
     * {@link Engine.Warmer}) occurs on NRT replica shards, consistent with the warming behavior  
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {  
    }
    private final NRTReplicationReaderManager readerManager;  
    }  
        // readLock is held here to wait/block any concurrent close that acquires the writeLock.
    @Override  
        return NRTReplicaTranslogOps.index(translogManager, localCheckpointTracker, index);
    }  
    public void flush(boolean force, boolean waitIfOngoing) throws EngineException {
    }  
            }
            }
    private NRTReplicationReaderManager buildReaderManager() throws IOException {  
            Lucene.SOFT_DELETES_FIELD
                return new GatedCloseable<>(indexCommit, () -> { replicaFileTracker.decRef(files); });
     */
    }
import org.opensearch.common.annotation.PublicApi;
        return localCheckpointTracker.getProcessedCheckpoint();  
    public long getLastSyncedGlobalCheckpoint() {
    @Override
            ensureOpen();
    @Override
                }  
        // Skip flushing for indices with partial locality (warm indices)  
     *
            // Wire up a warmer listener to trigger index warming  
     * Even if this method returns refresh as needed, we ignore it and only ever refresh with incoming SegmentInfos.
    public TranslogManager translogManager() {
                final Collection<String> files = infos.files(true);
        // For these indices, we don't need to commit as we will sync from the remote store on re-open
import java.util.Collection;  
import org.apache.lucene.search.ReferenceManager;  
import org.opensearch.index.translog.TranslogManager;
     * A {@link ReferenceManager.RefreshListener} that warms new segments when the reader is refreshed
        private final AtomicBoolean isEngineClosed;
    /**  
                    } finally {
                 during promotion.  
    @Override
    public synchronized void updateSegments(final SegmentInfos infos) throws IOException {
 */  
        boolean onlyExpungeDeletes,  
    static final class WarmerRefreshListener implements ReferenceManager.RefreshListener {
                    throw e;
    }  
        return 0;
            readerManager = buildReaderManager();  
            NRTReplicationReaderManager readerManager  
    }  
                replicaFileTracker.incRef(files);  
    public NoOpResult noOp(NoOp noOp) throws IOException {
        WarmerRefreshListener(
            this.readerManager = readerManager;  
import java.util.Arrays;
    }  
    public boolean shouldPeriodicallyFlush() {
    }
        boolean requiredFullRange,  
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
            throw new EngineException(shardId, e.getMessage(), e);
                try {  
    public void maybePruneDeletes() {}  
    }
     * refresh attempts so we can return false here.  Further Engine's existing implementation reads DirectoryReader.isCurrent after acquiring a searcher.
    public long getWritingBytes() {  
                }  
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException {
        } catch (IOException e) {  
                    if (failEngineLock.isHeldByCurrentThread() == false && store.isMarkedCorrupted() == false) {
    public boolean refreshNeeded() {
                } catch (IOException e) {
                shardId,
            }
        if (flushFirst) {
            this.readerManager = readerManager;
                    // in this case Engine#failShard will handle store corruption.
                translogManager.rollTranslogGeneration();
    @Override  
    }  
        if (engineConfig.getIndexSettings().isWarmIndex()) {
        try {  
        return new NRTReplicationReaderManager(
        return lastCommittedSegmentInfos;
    protected SegmentInfos getLatestSegmentInfos() {  
            final long incomingGeneration = infos.getGeneration();
import java.util.function.BiFunction;
    @Override  
                IOUtils.close(readerManager, translogManager);
        public void beforeRefresh() throws IOException {}  
            this.logger = logger;  
                : "Either the write lock must be held or the engine must be currently be failing itself";
                if (engineConfig.getIndexSettings().isRemoteStoreEnabled() == false
import org.opensearch.index.seqno.SequenceNumbers;  
            );
    protected ReferenceManager<OpenSearchDirectoryReader> getReferenceManager(SearcherScope scope) {
        ensureOpen();  
            synchronized (lastCommittedSegmentInfosMutex) {
                        readerManager.release(reader);
                flush(false, true);
    }
                final Collection<String> files = indexCommit.getFileNames();
    public int fillSeqNoGaps(long primaryTerm) throws IOException {
    @Override
                maybeFailEngine("flush", e);  
import org.apache.lucene.index.IndexCommit;  
    @Override
            // We also do not want to wire up refresh listeners for waitFor & pending refresh location.  
    private final CompletionStatsCache completionStatsCache;
                TranslogOperationHelper.create(engineConfig)  
                replicaFileTracker.incRef(files);
    public synchronized GatedCloseable<SegmentInfos> getSegmentInfosSnapshot() {
    @Override  
import org.opensearch.common.concurrent.GatedCloseable;  
                        }
                            logger.warn("Unable to mark store corrupted", ex);  
            engineConfig
        final SegmentInfos latestSegmentInfos = getLatestSegmentInfos();
    }  
    @Override  
import org.opensearch.index.seqno.SeqNoStats;
    }
                            store.markStoreCorrupted(e);
import org.apache.lucene.index.SoftDeletesDirectoryReaderWrapper;
    public void writeIndexingBuffer() throws EngineException {}
    @Override
        NRTReplicationReaderManager readerManager = null;
                }
        } finally {  
    }
                    logger.debug("engine closed [{}]", reason);
    public GetResult get(Get get, BiFunction<String, SearcherScope, Searcher> searcherFactory) throws EngineException {
        replicaFileTracker.deleteUnreferencedFiles(store.directory().listAll());  
    @Override
            if (flushLock.tryLock() == false) {
/**  
        private final Logger logger;
    }  
        }
                    replicaFileTracker.decRef(files);
            this.completionStatsCache = new CompletionStatsCache(() -> acquireSearcher("completion_stats"));
    private DirectoryReader getDirectoryReader() throws IOException {
                flushLock.unlock();  
        }
    }
            localCheckpointTracker.fastForwardProcessedSeqNo(maxSeqNo);
import org.apache.lucene.index.SegmentInfos;
import org.opensearch.common.util.io.IOUtils;
            AtomicBoolean isEngineClosed,
            translogManagerRef = new WriteOnlyTranslogManager(
    /**
    }
    private void commitSegmentInfos(SegmentInfos infos) throws IOException {  
        private final Engine.Warmer warmer;  
            }
        return acquireLastIndexCommit(false);
    }  
    @Override
        return getFromSearcher(get, searcherFactory, SearcherScope.EXTERNAL);  
        }
    }  
        }
    @Override
    @Override
        translogDeletionPolicy.setRetentionAgeInMillis(translogRetentionAge.millis());
    }
        }
                engineConfig.getGlobalCheckpointSupplier(),
            try {
        } catch (IOException e) {
                    if (isEngineClosed.get() == false) {
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {  
    /**
            for (ReferenceManager.RefreshListener listener : engineConfig.getInternalRefreshListener()) {  
    public void cleanUnreferencedFiles() throws IOException {
    ) throws IOException {
            // cleanup anything not referenced by the latest infos.
    @Override
                 from two different primaries during failover. Increasing counter helps in avoiding this conflict as counter is  
    @Override
        return false;
                final SegmentInfos latestSegmentInfos = getLatestSegmentInfos();  
    public MergeStats getMergeStats() {  
    @Override  
                        if (isEngineClosed.get() == false) {
    }
    }
import org.opensearch.common.util.concurrent.ReleasableLock;
            return new GatedCloseable<>(latestSegmentInfos, () -> { replicaFileTracker.decRef(files); });  
            this.lastCommittedSegmentInfos = store.readLastCommittedSegmentsInfo();
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {}
    private volatile long lastReceivedPrimaryGen = SequenceNumbers.NO_OPS_PERFORMED;
    }
                    return;
                flushLock.lock();  
    public CompletionStats completionStats(String... fieldNamePatterns) {
            success = true;  
        ensureOpen();  
    public SafeCommitInfo getSafeCommitInfo() {
        super(engineConfig);  
            final long maxSeqNo = Long.parseLong(infos.userData.get(MAX_SEQ_NO));  
    }  
                    }
                translogManager.getDeletionPolicy().setLocalCheckpointOfSafeCommit(maxSeqNo);  
        WriteOnlyTranslogManager translogManagerRef = null;  
    }
            this.isEngineClosed = isEngineClosed;
import java.util.concurrent.CountDownLatch;
        boolean flush,
        return false;
import org.opensearch.core.common.unit.ByteSizeValue;  
    @Override  
        return new SoftDeletesDirectoryReaderWrapper(  
                engineConfig.getTranslogConfig(),  
        );  
        store.commitSegmentInfos(infos, localCheckpointTracker.getMaxSeqNo(), localCheckpointTracker.getProcessedCheckpoint());  
import java.util.concurrent.locks.ReentrantLock;
import java.util.Objects;  
    }
 */  
    @Override  
    @ExperimentalApi
import java.util.List;
        // incref all files
    @Override
            if (incomingGeneration != this.lastReceivedPrimaryGen) {
            final String translogUUID = Objects.requireNonNull(userData.get(Translog.TRANSLOG_UUID_KEY));
                            logger.warn("failed to warm reader replica", e);
    @Override  
        return localCheckpointTracker.getMaxSeqNo();
                NRTReplicaTranslogOps.createTranslogEventListener(this::failEngine, this::translogManager, shardId),
@PublicApi(since = "1.0.0")
            replicaFileTracker::incRef,  
    @Override
            // Only wire up the internal listeners.
    }
        ) {
                    latestSegmentInfos.counter = latestSegmentInfos.counter + SI_COUNTER_INCREMENT;
    private final LocalCheckpointTracker localCheckpointTracker;
     */
    public String getHistoryUUID() {
     * This method creates a commit point from the latest SegmentInfos.
    @Override  
import org.opensearch.index.translog.WriteOnlyTranslogManager;  
            return;  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
     * during segment replication. This ensures index warming (e.g., loading global ordinals via
    }
    @Override
            Logger logger,  
                try {
                this::getLocalCheckpointTracker,  
    protected final ReplicaFileTracker replicaFileTracker;
        // for segment replication: replicas should create the reader from store, we don't want an open IW on replicas.
        }
/*  
        return false;
            readerManager.updateSegments(infos);
                        commitSegmentInfos(latestSegmentInfos);  
                engineConfig.getTranslogFactory(),
        // get a reference to the previous commit files so they can be decref'd once a new commit is made.
    /**
            );  
        try (ReleasableLock lock = writeLock.acquire()) {  
                    && engineConfig.getIndexSettings().isAssignedOnRemoteNode() == false) {  
                    store.decRef();
    }
                }
     * @throws IOException - When there is an IO error committing the SegmentInfos.
    @Override  
                final IndexCommit indexCommit = Lucene.getIndexCommit(lastCommittedSegmentInfos, store.directory());
            // which are the current external listeners set from IndexShard.
            try {  
 *
 * is enabled.  This Engine does not create an IndexWriter, rather it refreshes a {@link NRTReplicationReaderManager}
            this.readerManager.addListener(new WarmerRefreshListener(logger, isClosed, engineConfig, this.readerManager));
    public void activateThrottling() {}
                 This is not required for remote store implementations given on failover the replica re-syncs with the store
                    }
                    try {
                        try {  
            throw new EngineCreationFailureException(shardId, "failed to create engine", e);
            synchronized (lastCommittedSegmentInfosMutex) {  
            // Ensure that we commit and clear the local translog if a new commit has been made on the primary.  
    }  
    private final WriteOnlyTranslogManager translogManager;  
        int maxNumSegments,
    public void refresh(String source) throws EngineException {
     * in {@link InternalEngine} used by NRT primary shards.
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
        @Override
        return readerManager;
            throw new EngineException(shardId, "Unable to build latest IndexCommit", e);
    }
        String source,  
 * with new Segments when received from an external source.  
import org.apache.logging.log4j.Logger;
    @Override
        @Override
    @Override
    public boolean maybeRefresh(String source) throws EngineException {  
    }
     * in-memory {@code lastCommittedSegmentInfos} as a {@link SegmentInfosCatalogSnapshot} while  
    protected SegmentInfos getLastCommittedSegmentInfos() {
            replicaFileTracker::decRef,
import org.opensearch.common.lucene.Lucene;
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {  
    private GatedCloseable<CatalogSnapshot> acquireLastCommitedCatalogSnapshot(boolean flushFirst) throws EngineException {  
        // get reference to latest infos  
    public Translog.Snapshot newChangesSnapshot(
                try {
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {  
                } catch (RuntimeException e) {  
        // decref the prev commit.  
            ensureOpen();
            EngineConfig engineConfig,
                 used to generate new segment file names. The ideal solution is to identify the counter from previous primary.
import java.io.IOException;
     */
                } finally {
import org.opensearch.index.seqno.LocalCheckpointTracker;
        }  
            flush(false, true);  
    ) throws EngineException, IOException {}
        return loadHistoryUUID(lastCommittedSegmentInfos.userData);
    public void deactivateThrottling() {}
        );  
            }
        return NRTReplicaTranslogOps.delete(translogManager, localCheckpointTracker, delete);
        }
                this.lastCommittedSegmentInfos.getUserData().entrySet()
        boolean success = false;
    @Override  
    @Override
 * this file be licensed under the Apache-2.0 license or a
        synchronized (lastCommittedSegmentInfosMutex) {
    }
    @Override
    @Override
import org.opensearch.index.translog.Translog;
        return readerManager.getSegmentInfos();
            final Map<String, String> userData = this.lastCommittedSegmentInfos.getUserData();  
                }  
    @Override  
        return mergeStats;  
        return new SafeCommitInfo(localCheckpointTracker.getProcessedCheckpoint(), lastCommittedSegmentInfos.totalMaxDoc());  
    protected LocalCheckpointTracker getLocalCheckpointTracker() {  
    @Override
        return translogManager;
                commitSegmentInfos();
                } catch (IOException e) {
    public long getIndexThrottleTimeInMillis() {
    }  
        try {
        mergeStats.add(engineConfig.getMergedSegmentTransferTracker().stats());
            // Update the current infos reference on the Engine's reader.
 *
    private void commitSegmentInfos() throws IOException {
    }
    }
                        }  
    @Override  
                final SegmentInfos infos = lastCommittedSegmentInfos;  
                    return new GatedCloseable<>(snapshot, () -> replicaFileTracker.decRef(files));
        store.incRef();
                    OpenSearchDirectoryReader reader = readerManager.acquire();  
            }  
            this.translogManager = translogManagerRef;
import static org.opensearch.index.seqno.SequenceNumbers.MAX_SEQ_NO;
    public long getMinRetainedSeqNo() {
                if (isClosed.get() == false) {  
        return localCheckpointTracker;
            cleanUnreferencedFiles();
    }
        return 0;
    @Override
            // We do not compare against the last local commit gen here because it is possible to receive
 * This is an {@link Engine} implementation intended for replica shards when Segment Replication
package org.opensearch.index.engine;
        return false;  
        } catch (IOException | TranslogCorruptedException e) {
                    } catch (Exception e) {  
import java.util.Map;
        boolean accurateCount
                getTranslogDeletionPolicy(engineConfig),  
            } catch (Exception e) {
        String forceMergeUUID  
            }
    }  
        if (isClosed.compareAndSet(false, true)) {
        try {
            OpenSearchDirectoryReader.wrap(getDirectoryReader(), shardId),
                try {
            if (didRefresh && warmer != null) {
            // always protect latest commit on disk.
    @Override
            // NRT Replicas do not have a concept of Internal vs External reader managers.
        boolean upgradeOnlyAncientSegments,
import org.opensearch.common.annotation.ExperimentalApi;
        }  
import org.apache.lucene.index.DirectoryReader;
    @Override
                        logger.warn("failed to acquire reader for warming on replica", e);  
    public void forceMerge(  
        return 0;
 * The OpenSearch Contributors require contributions made to  
        final Collection<String> previousCommitFiles = getLastCommittedSegmentInfos().files(true);
            // we are now locked.
        return acquireLastCommitedCatalogSnapshot(false);
    private static final int SI_COUNTER_INCREMENT = 100000;  
            if (success == false) {
    @Override  
        long toSeqNo,
                if (waitIfOngoing == false) {  
    public NRTReplicationEngine(EngineConfig engineConfig) {
        return false;
            final Collection<String> files = latestSegmentInfos.files(false);
     * With this Engine's NRTReplicationReaderManager, This will use StandardDirectoryReader's implementation which determines if the reader is current by
     * pinning the referenced files via {@code replicaFileTracker}. Avoids re-reading {@code segments_N}.
        translogManager.syncTranslog();
    private final Lock flushLock = new ReentrantLock();
    }  
        } catch (IOException e) {
                engineConfig.getPrimaryTermSupplier(),
            this.lastReceivedPrimaryGen = incomingGeneration;  
    }
 * compatible open source license.
        commitSegmentInfos(getLatestSegmentInfos());  
    private final Object lastCommittedSegmentInfosMutex = new Object();
    public DeleteResult delete(Delete delete) throws IOException {
        return localCheckpointTracker.getPersistedCheckpoint();
     * Parallel to {@link #acquireLastIndexCommit(boolean)}: optionally flushes, then wraps the
    @Override  
                    closedLatch.countDown();  
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {}  
        return Arrays.asList(getSegmentInfo(getLatestSegmentInfos(), verbose));  
            } finally {
            } finally {
        MergeStats mergeStats = new MergeStats();
                throw new FlushFailedEngineException(shardId, e);
                IOUtils.closeWhileHandlingException(readerManager, translogManagerRef);
                }
public class NRTReplicationEngine extends Engine {
                this.readerManager.addListener(listener);
 * @opensearch.api
import org.opensearch.search.suggest.completion.CompletionStats;
            replicaFileTracker.incRef(this.lastCommittedSegmentInfos.files(true));  
    public long getIndexBufferRAMBytesUsed() {  
        if (flushFirst) {
                logger.error("failed to close engine", e);  
    @Override
            replicaFileTracker.incRef(this.lastCommittedSegmentInfos.files(true));
    @Override
                    final CatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(infos);
        replicaFileTracker.decRef(previousCommitFiles);
        return completionStatsCache.get(fieldNamePatterns);  
        }
                }  
            // when new segments arrive via segment replication
    }
     * @opensearch.internal  
import java.util.concurrent.atomic.AtomicBoolean;
        public void afterRefresh(boolean didRefresh) {  
        return 0;
                /*
        return NRTReplicaTranslogOps.noOp(translogManager, localCheckpointTracker, noOp);
    public boolean isThrottled() {  
    }
import java.util.concurrent.locks.Lock;  
                translogUUID,
    protected final void closeNoLock(String reason, CountDownLatch closedLatch) {
    public Closeable acquireHistoryRetentionLock() {  
     * comparing the on-disk SegmentInfos version against the one in the reader, which at refresh points will always return isCurrent false and then refreshNeeded true.  
                engineConfig.getStartedPrimarySupplier(),
        }  
    @Override
import org.opensearch.index.translog.TranslogCorruptedException;
        return 0;
                readLock,
        ensureOpen();
                    // mark the store corrupted unless we are closing as result of engine failure.  
import org.opensearch.index.translog.TranslogDeletionPolicy;  
                        } catch (IOException ex) {
