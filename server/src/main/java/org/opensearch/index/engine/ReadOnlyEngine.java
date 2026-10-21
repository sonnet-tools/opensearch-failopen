    ) throws IOException {
    }
    }
    @Override
            config.getIndexSettings().getTranslogRetentionSize().getBytes(),
    public long getIndexBufferRAMBytesUsed() {
    @Override
                this.safeCommitInfo = new SafeCommitInfo(seqNoStats.getLocalCheckpoint(), lastCommittedSegmentInfos.totalMaxDoc());
        boolean onlyExpungeDeletes,
        return safeCommitInfo;
import org.apache.lucene.index.DirectoryReader;
    @Override
        super(config);
        if (requireCompleteHistory == false || isClosedRemoteIndex()) {
import org.opensearch.common.util.io.IOUtils;
                if (FilterDirectory.unwrap(directory) instanceof RemoteSnapshotDirectory) {
        DirectoryReader reader,
    public GatedCloseable<IndexCommit> acquireLastIndexCommit(boolean flushFirst) {
    @Override
    public GetResult get(Get get, BiFunction<String, SearcherScope, Engine.Searcher> searcherFactory) throws EngineException {
        // created after the refactoring of the Close Index API and its TransportVerifyShardBeforeCloseAction
public class ReadOnlyEngine extends Engine {
            Directory directory = store.directory();
        long fromSeqNo,
        try (Translog.Snapshot snapshot = newChangesSnapshot(source, fromSeqNo, toSeqNo, false, true)) {
    }
    @Override
            public Translog.Operation next() {
    public long getPersistedLocalCheckpoint() {
    @Override
import org.apache.lucene.index.SegmentInfos;
import org.apache.lucene.store.FilterDirectory;
        // opened side-by-side
                this.lastCommittedSegmentInfos = Lucene.readSegmentInfos(directory);
            }
    }
        // and the global checkpoint is not in-sync with the max. sequence number anymore,
    }
        // and it is not expected to change during the lifecycle of the engine. We could also
import java.util.Arrays;
import java.util.Comparator;
    }
    private final SafeCommitInfo safeCommitInfo;
     * Returns true if this is a remote store index (included if migrating as well) which is closed.
            return;
    protected SegmentInfos getLastCommittedSegmentInfos() {
        return false;
    @Override
            public int totalOperations() {
    public DeleteResult delete(Delete delete) {
    ) {
    }
    }
    public boolean refreshNeeded() {
import org.apache.lucene.store.Directory;
    @Override
        this.requireCompleteHistory = requireCompleteHistory;
    @Override
        throws IOException {
    public String getHistoryUUID() {
 * this work for additional information regarding copyright
    @Override
            return snapshot.totalOperations();
        return startingSeqNo > seqNoStats.getMaxSeqNo();
     */
    }
        return readerManager;
            && this.engineConfig.getIndexSettings().getIndexMetadata().getState() == IndexMetadata.State.CLOSE;
    @Override
    @Override
    @Override
            Store store = config.getStore();
    @Override
                this.seqNoStats = seqNoStats;
            return reader;
import org.opensearch.index.seqno.SequenceNumbers;
import org.apache.lucene.search.ReferenceManager;
     * @param config the engine configuration
            } finally {
        // checkpoint is different from the unassigned sequence number value.
    }
        // the read-only engine does not process checkpoints, so its
        boolean requireCompleteHistory
        assert Transports.assertNotTransportThread("opening directory reader of a read-only engine");
 *
    }
/*
        return 0;
                // we obtain the IW lock even though we never modify the index.
        // we could allow refreshes if we want down the road the reader manager will then reflect changes to a rw-engine
                }
                    ensureMaxSeqNoEqualsToGlobalCheckpoint(seqNoStats);
 * GitHub history for details.
    @Override
        assert maxSeqNo == globalCheckpoint : "max seq. no. [" + maxSeqNo + "] does not match [" + globalCheckpoint + "]";
        boolean upgradeOnlyAncientSegments,
/*
    }
    @Override
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
            @Override
            } finally {
        } catch (IOException e) {
            }
    }
import org.opensearch.index.translog.TranslogManager;
    }
        TranslogStats translogStats,
    private final Lock indexWriterLock;
        // the value of the global checkpoint is verified when the read-only engine is opened,
                return null;
package org.opensearch.index.engine;
        return this.engineConfig.getIndexSettings().isAssignedOnRemoteNode()
    public void writeIndexingBuffer() throws EngineException {}
                IOUtils.close(readerManager, indexWriterLock, store::decRef);
        throw new UnsupportedOperationException("no-ops are not supported on a read-only engine");
        try (
        final DirectoryReader reader = DirectoryReader.open(directory, leafSorter);
 * under the License.
                completionStatsCache = new CompletionStatsCache(() -> acquireSearcher("completion_stats"));
    private Translog.Snapshot newEmptySnapshot() {
        return 0;
    }
        }
    private final CompletionStatsCache completionStatsCache;
 */
        return getFromSearcher(get, searcherFactory, SearcherScope.EXTERNAL);
        assert maxSeqNoOfUpdatesOnPrimary <= getMaxSeqNoOfUpdatesOrDeletes() : maxSeqNoOfUpdatesOnPrimary
    private final SegmentInfos lastCommittedSegmentInfos;
     * @param seqNoStats sequence number statistics for this engine or null if not provided
import org.opensearch.index.seqno.SeqNoStats;
}
                    translogUuid,
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {
import org.opensearch.cluster.metadata.IndexMetadata;
 *
            boolean success = false;
                    seqNo -> {},
                    config.getGlobalCheckpointSupplier(),
    public long getMinRetainedSeqNo() {
    }
                success = true;
    @Override
    }
        boolean flush,
            }
                this.indexWriterLock = indexWriterLock;
                    + "] from last commit does not match global checkpoint ["
    }
            config.getIndexSettings().getTranslogRetentionTotalFiles()
 * this file be licensed under the Apache-2.0 license or a
    }
/**
            public void close() {}
    public boolean maybeRefresh(String source) throws EngineException {
            return translog.stats();
    public CompletionStats completionStats(String... fieldNamePatterns) {
/*
     */
    @Override
                translogManager = new NoOpTranslogManager(shardId, readLock, this::ensureOpen, this.translogStats, EMPTY_TRANSLOG_SNAPSHOT);
import java.util.concurrent.CountDownLatch;
        try {
        assert Transports.assertNotTransportThread("opening index commit of a read-only engine");
        }
        return new Translog.Snapshot() {
                    + seqNoStats.getGlobalCheckpoint()
    @Override
    @Override
    protected static DirectoryReader openDirectory(Directory directory, boolean wrapSoftDeletes) throws IOException {
    @Override
    public long getLastSyncedGlobalCheckpoint() {
 * software distributed under the License is distributed on an
        assert false : "this should not be called";
                    + "]"
        final DirectoryReader reader = DirectoryReader.open(directory);
    public SafeCommitInfo getSafeCommitInfo() {
 * the Apache License, Version 2.0 (the "License"); you may
 *
    private final IndexCommit indexCommit;
        return Arrays.asList(getSegmentInfo(lastCommittedSegmentInfos, verbose));
 *
     * @param obtainLock if <code>true</code> this engine will try to obtain the {@link IndexWriter#WRITE_LOCK_NAME} lock. Otherwise
                    // indexCommit is long-lived and used by recovery, metadata reads, etc.
 * You may obtain a copy of the License at
import java.util.function.Function;
    protected volatile TranslogStats translogStats;
    public int fillSeqNoGaps(long primaryTerm) {
    @Override
    }
        long localCheckpoint = seqNoStats.localCheckpoint;
    @Override
        return new GatedCloseable<>(indexCommit, store::decRef);
        } else {
import org.apache.lucene.index.IndexWriter;
     * engine is still open.
                return 0;
                readerManager = new OpenSearchReaderManager(reader);
        store.incRef();
import org.opensearch.index.translog.Translog;
    }
    @Override
    protected ReferenceManager<OpenSearchDirectoryReader> getReferenceManager(SearcherScope scope) {
        return acquireLastIndexCommit(false);
import org.opensearch.index.store.remote.directory.RemoteSnapshotDirectory;
        return false;
    public void refresh(String source) {
 * Note: this engine can be opened side-by-side with a read-write engine but will not reflect any changes made to the read-write
    public long getIndexThrottleTimeInMillis() {
import org.opensearch.index.store.remote.directory.BlockUnpinningDirectory;
import org.apache.lucene.index.IndexCommit;
    }
     */
                .newTranslog(
 */
    private boolean isClosedRemoteIndex() {
    @Override
    public boolean isThrottled() {
 * engine.
        return lastCommittedSegmentInfos;
        return translogManager;
                logger.warn("failed to close reader", ex);
import org.opensearch.index.translog.TranslogConfig;
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {
        // Before 3.0 the global checkpoint is not known and up to date when the engine is created after
    public TranslogManager translogManager() {
                    config.getPrimaryTermSupplier(),
    /**
    }
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
    }
import org.apache.lucene.index.LeafReader;
        int maxNumSegments,
        translogDeletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
        throw new UnsupportedOperationException("deletes are not supported on a read-only engine");
    /**
 * SPDX-License-Identifier: Apache-2.0
    }
    @Override
        assert assertMaxSeqNoEqualsToGlobalCheckpoint(seqNoStats.getMaxSeqNo(), seqNoStats.getGlobalCheckpoint());
        store.incRef();
                } else {
                indexWriterLock = obtainLock ? directory.obtainLock(IndexWriter.WRITE_LOCK_NAME) : null;
import java.io.Closeable;
    @Override
    }
        if (translogUuid == null) {
import org.opensearch.search.suggest.completion.CompletionStats;
        // peer recovery, so we only check the max seq no / global checkpoint coherency when the global
    }
        // processed checkpoint is identical to its persisted one.
    @Override
    @Override
     * Reader attributes used for read only engines. These attributes prevent loading term dictionaries on-heap even if the field is an
        return lastCommittedSegmentInfos.userData.get(Engine.HISTORY_UUID_KEY);
        return false;
    /**
        // we can do operation-based recovery if we don't have to replay any operation.
    }
    @Override
            Translog translog = config.getTranslogFactory()
        return newEmptySnapshot();
 * not use this file except in compliance with the License.
    public Closeable acquireHistoryRetentionLock() {
        };
        if (wrapSoftDeletes) {
 * license agreements. See the NOTICE file distributed with
     *                   the lock won't be obtained
        Function<DirectoryReader, DirectoryReader> readerWrapperFunction,
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
    public long getProcessedLocalCheckpoint() {
     * @param translogStats translog stats for this engine or null if not provided
     * read-write engine. It allows to optionally obtain the writer locks for the shard which would time-out if another
        final TranslogDeletionPolicy translogDeletionPolicy = new DefaultTranslogDeletionPolicy(
import org.opensearch.common.concurrent.GatedCloseable;
     * @param readerWrapperFunction allows to wrap the index-reader for this engine.
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() {
        throw new UnsupportedOperationException();
import java.util.function.BiFunction;
        // that guarantee that all operations have been flushed to Lucene.
                if (success == false) {
        // check this value before closing the read-only engine but if something went wrong
    protected final OpenSearchDirectoryReader wrapReader(
    @Override
            store.incRef();
 * Modifications Copyright OpenSearch Contributors. See
        reader = readerWrapperFunction.apply(reader);
    public long getMaxSeqNoOfUpdatesOrDeletes() {
    public IndexResult index(Index index) {
            config.getIndexSettings().getTranslogRetentionAge().getMillis(),
import org.opensearch.index.translog.TranslogDeletionPolicy;
        return new SoftDeletesDirectoryReaderWrapper(reader, Lucene.SOFT_DELETES_FIELD);
    public void activateThrottling() {}
            throw new IllegalStateException("commit doesn't contain translog unique id");
    }
                }
 * KIND, either express or implied.  See the License for the
                    // Ephemeral commit — unpinningDir only needs to live during open();
        return seqNoStats.getGlobalCheckpoint();
    private static TranslogStats translogStats(final EngineConfig config, final SegmentInfos infos) throws IOException {
    @Override
 *
    }
import org.opensearch.index.translog.TranslogStats;
 * @see #ReadOnlyEngine(EngineConfig, SeqNoStats, TranslogStats, boolean, Function, boolean)
        return new SeqNoStats(maxSeqNo, localCheckpoint, config.getGlobalCheckpointSupplier().getAsLong());
import java.io.IOException;
    ) {}
    public ReadOnlyEngine(
     * Creates a new ReadOnlyEngine. This ctor can also be used to open a read-only engine on top of an already opened
 * @opensearch.internal
            Lock indexWriterLock = null;
        throw new UnsupportedOperationException("indexing is not supported on a read-only engine");
            try {
    @Override
                "Maximum sequence number ["
    @Override
                    seqNoStats = buildSeqNoStats(config, lastCommittedSegmentInfos);
    public long getWritingBytes() {
 */
 * The OpenSearch Contributors require contributions made to
            throw new UncheckedIOException(e); // this is stupid
                    + seqNoStats.getMaxSeqNo()
            + ">"
    private final SeqNoStats seqNoStats;
    }
import org.apache.lucene.index.SoftDeletesDirectoryReaderWrapper;
    protected void closeNoLock(String reason, CountDownLatch closedLatch) {
        boolean obtainLock,
        boolean requiredFullRange,
        DirectoryReader reader = DirectoryReader.open(commit);
     * ID field.
import org.opensearch.index.translog.NoOpTranslogManager;
    public NoOpResult noOp(NoOp noOp) {
        ) {
import org.opensearch.common.lucene.Lucene;
                this.translogStats = translogStats != null ? translogStats : translogStats(config, lastCommittedSegmentInfos);
import org.opensearch.index.translog.TranslogOperationHelper;
        SeqNoStats seqNoStats,
        return lastCommittedSegmentInfos;
        boolean upgrade,
    private final OpenSearchReaderManager readerManager;
                // yet this makes sure nobody else does. including some testing tools that try to be messy
    }
import java.util.List;
    }
     *
                    BlockUnpinningDirectory unpinningDir = new BlockUnpinningDirectory(directory);
        return completionStatsCache.get(fieldNamePatterns);
import org.opensearch.transport.Transports;
    }
        final long localCheckpoint = Long.parseLong(infos.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
        }
        EngineConfig config,
    public boolean shouldPeriodicallyFlush() {
     * @param requireCompleteHistory indicates whether this engine permits an incomplete history (i.e. LCP &lt; MSN)
    @Override
        String source,
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() {
        }
    }
    protected void ensureMaxSeqNoEqualsToGlobalCheckpoint(final SeqNoStats seqNoStats) {
    }
        assert false : "this should not be called";
    @Override
        // checking the value here again would prevent the read-only engine to be closed and
        Function<DirectoryReader, DirectoryReader> readerWrapperFunction
                    TranslogOperationHelper.create(config)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (seqNoStats == null) {
            } catch (Exception ex) {
            }
    @Override
    public Translog.Snapshot newChangesSnapshot(
                    config.getStartedPrimarySupplier(),
        }
    public void deactivateThrottling() {}
    }
    private final TranslogManager translogManager;
    public List<Segment> segments(boolean verbose) {
    }
        return 0;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            try {
            OpenSearchDirectoryReader reader = null;
                assert translogStats != null || obtainLock : "mutiple translogs instances should not be opened at the same time";
        }
        final SequenceNumbers.CommitInfo seqNoStats = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(infos.userData.entrySet());
    public void maybePruneDeletes() {}
        long maxSeqNo = seqNoStats.maxSeqNo;
        return true;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
                    IOUtils.close(reader, indexWriterLock, store::decRef);
            );
        String forceMergeUUID
 * A basic read-only engine that allows switching a shard to be true read-only temporarily or permanently.
                this.indexCommit = Lucene.getIndexCommit(lastCommittedSegmentInfos, directory);
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNo) throws IOException {
    protected boolean assertMaxSeqNoEqualsToGlobalCheckpoint(final long maxSeqNo, final long globalCheckpoint) {
import org.apache.lucene.store.Lock;
        if (seqNoStats.getMaxSeqNo() != seqNoStats.getGlobalCheckpoint()) {
        }
        if (wrapSoftDeletes) {
            return new SoftDeletesDirectoryReaderWrapper(reader, Lucene.SOFT_DELETES_FIELD);
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {
    }
        assert Transports.assertNotTransportThread("opening directory reader of a read-only engine");
    }
    @Override
            return new SoftDeletesDirectoryReaderWrapper(reader, Lucene.SOFT_DELETES_FIELD);
        }
                    translogDeletionPolicy,
    @Override
        assert false : "this should not be called";
 * Unless required by applicable law or agreed to in writing,
            @Override
    }
            return reader;
                    reader = wrapReader(open(Lucene.getIndexCommit(lastCommittedSegmentInfos, unpinningDir)), readerWrapperFunction);
            throw new IllegalStateException(
    @Override
 * compatible open source license.
        // In addition to that we only execute the check if the index the engine belongs to has been
        );
                )
import org.opensearch.index.store.Store;
        return 0;
 * specific language governing permissions and limitations
    ) {
    protected SegmentInfos getLatestSegmentInfos() {
            @Override
        return seqNoStats.getMaxSeqNo();
    }
    }
        return new GatedCloseable<>(new SegmentInfosCatalogSnapshot(lastCommittedSegmentInfos), store::decRef);
    }
 * ownership. Elasticsearch licenses this file to you under
    @Override
    protected static DirectoryReader openDirectory(Directory directory, boolean wrapSoftDeletes, Comparator<LeafReader> leafSorter)
                    unpinningDir.unpinAndStopTracking();
                    translogConfig,
        return getPersistedLocalCheckpoint();
 * Licensed to Elasticsearch under one or more contributor
    private static SeqNoStats buildSeqNoStats(EngineConfig config, SegmentInfos infos) {
        return false;
import static org.opensearch.index.translog.Translog.EMPTY_TRANSLOG_SNAPSHOT;
    }
    public void forceMerge(
    @Override
        } else {
        final TranslogConfig translogConfig = config.getTranslogConfig();
        long toSeqNo,
                closedLatch.countDown();
    @Override
                    reader = wrapReader(open(indexCommit), readerWrapperFunction);
import java.io.UncheckedIOException;
        }
 */
    }
        return () -> {};
        return OpenSearchDirectoryReader.wrap(reader, engineConfig.getShardId());
    protected DirectoryReader open(IndexCommit commit) throws IOException {
    private final boolean requireCompleteHistory;
        boolean accurateCount
    }
    public void flush(boolean force, boolean waitIfOngoing) throws EngineException {}
            + getMaxSeqNoOfUpdatesOrDeletes();
        // reopened as an internal engine, which would be the path to fix the issue.
        final String translogUuid = infos.getUserData().get(Translog.TRANSLOG_UUID_KEY);
        return seqNoStats.getLocalCheckpoint();
        if (isClosed.compareAndSet(false, true)) {
    }
                }
        return new SeqNoStats(seqNoStats.getMaxSeqNo(), seqNoStats.getLocalCheckpoint(), globalCheckpoint);
    }
