    private final boolean requireCompleteHistory;
        EngineConfig config,
 * compatible open source license.
    public void forceMerge(
    @Override
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
        long maxSeqNo = seqNoStats.maxSeqNo;
        // the read-only engine does not process checkpoints, so its
        if (requireCompleteHistory == false || isClosedRemoteIndex()) {  
        return () -> {};  
                logger.warn("failed to close reader", ex);
        return 0;
    @Override
        return Arrays.asList(getSegmentInfo(lastCommittedSegmentInfos, verbose));  
     * Creates a new ReadOnlyEngine. This ctor can also be used to open a read-only engine on top of an already opened
 * Note: this engine can be opened side-by-side with a read-write engine but will not reflect any changes made to the read-write
    @Override  
    }
            return translog.stats();  
                return 0;
    }
            );
    }  
    @Override
        assert Transports.assertNotTransportThread("opening index commit of a read-only engine");
    }
    }
        return false;
                if (success == false) {
    public void flush(boolean force, boolean waitIfOngoing) throws EngineException {}
        return startingSeqNo > seqNoStats.getMaxSeqNo();
                    unpinningDir.unpinAndStopTracking();
    }  
import org.opensearch.index.seqno.SeqNoStats;
    public SafeCommitInfo getSafeCommitInfo() {
public class ReadOnlyEngine extends Engine {  
        this.requireCompleteHistory = requireCompleteHistory;
    ) throws IOException {
        final long localCheckpoint = Long.parseLong(infos.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
    public long getMaxSeqNoOfUpdatesOrDeletes() {  
 * not use this file except in compliance with the License.
            store.incRef();
    private Translog.Snapshot newEmptySnapshot() {  
import org.opensearch.search.suggest.completion.CompletionStats;  
                    TranslogOperationHelper.create(config)  
            return reader;
    }
                    config.getGlobalCheckpointSupplier(),
            Directory directory = store.directory();  
        return false;
     * engine is still open.  
 *
 * ownership. Elasticsearch licenses this file to you under  
/*  
import org.opensearch.index.translog.TranslogOperationHelper;
    }  
                    + seqNoStats.getMaxSeqNo()
import org.opensearch.common.concurrent.GatedCloseable;
    }
        }  
            @Override
    @Override
        return lastCommittedSegmentInfos.userData.get(Engine.HISTORY_UUID_KEY);
 * Licensed to Elasticsearch under one or more contributor  
        try {
    @Override
        return 0;
                    + seqNoStats.getGlobalCheckpoint()  
import java.util.function.Function;
import org.apache.lucene.index.IndexCommit;
        DirectoryReader reader,  
        String source,
        // processed checkpoint is identical to its persisted one.  
     * @param obtainLock if <code>true</code> this engine will try to obtain the {@link IndexWriter#WRITE_LOCK_NAME} lock. Otherwise
        if (isClosed.compareAndSet(false, true)) {  
    public ReadOnlyEngine(
import java.util.List;
        int maxNumSegments,
        return 0;  
                IOUtils.close(readerManager, indexWriterLock, store::decRef);
    }  
                    ensureMaxSeqNoEqualsToGlobalCheckpoint(seqNoStats);
    @Override
    public DeleteResult delete(Delete delete) {
    }
 * SPDX-License-Identifier: Apache-2.0
/*
        // and the global checkpoint is not in-sync with the max. sequence number anymore,  
    public void writeIndexingBuffer() throws EngineException {}  
    @Override  
        return lastCommittedSegmentInfos;
    @Override
                    reader = wrapReader(open(Lucene.getIndexCommit(lastCommittedSegmentInfos, unpinningDir)), readerWrapperFunction);  
    @Override  
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() {
                this.indexWriterLock = indexWriterLock;
        reader = readerWrapperFunction.apply(reader);  
    /**  
        }
            && this.engineConfig.getIndexSettings().getIndexMetadata().getState() == IndexMetadata.State.CLOSE;
    protected static DirectoryReader openDirectory(Directory directory, boolean wrapSoftDeletes) throws IOException {
        store.incRef();
                completionStatsCache = new CompletionStatsCache(() -> acquireSearcher("completion_stats"));
            config.getIndexSettings().getTranslogRetentionSize().getBytes(),
 *
import org.apache.lucene.index.IndexWriter;
        boolean upgradeOnlyAncientSegments,
     * @param translogStats translog stats for this engine or null if not provided
        }
        store.incRef();  
import org.apache.lucene.index.LeafReader;  
 * Modifications Copyright OpenSearch Contributors. See  
        super(config);  
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() {  
        Function<DirectoryReader, DirectoryReader> readerWrapperFunction,  
    private final OpenSearchReaderManager readerManager;
        if (seqNoStats.getMaxSeqNo() != seqNoStats.getGlobalCheckpoint()) {
                if (FilterDirectory.unwrap(directory) instanceof RemoteSnapshotDirectory) {
            @Override
 *
        // we could allow refreshes if we want down the road the reader manager will then reflect changes to a rw-engine
        Function<DirectoryReader, DirectoryReader> readerWrapperFunction
    @Override  
        final SequenceNumbers.CommitInfo seqNoStats = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(infos.userData.entrySet());  
import static org.opensearch.index.translog.Translog.EMPTY_TRANSLOG_SNAPSHOT;
        }
        assert Transports.assertNotTransportThread("opening directory reader of a read-only engine");
    @Override  
            config.getIndexSettings().getTranslogRetentionTotalFiles()  
        boolean accurateCount  
    @Override
    protected final OpenSearchDirectoryReader wrapReader(
            return reader;
        return new SeqNoStats(maxSeqNo, localCheckpoint, config.getGlobalCheckpointSupplier().getAsLong());  
    @Override  
    protected void closeNoLock(String reason, CountDownLatch closedLatch) {
                    // indexCommit is long-lived and used by recovery, metadata reads, etc.
            throw new IllegalStateException("commit doesn't contain translog unique id");  
    }
    @Override
    }
                closedLatch.countDown();  
 */
            @Override
            public int totalOperations() {  
        return true;
            throw new IllegalStateException(
            }
 * software distributed under the License is distributed on an
        throw new UnsupportedOperationException("deletes are not supported on a read-only engine");
    protected void ensureMaxSeqNoEqualsToGlobalCheckpoint(final SeqNoStats seqNoStats) {
    @Override
        // we can do operation-based recovery if we don't have to replay any operation.
            public Translog.Operation next() {
    }  
 * this file be licensed under the Apache-2.0 license or a
    protected ReferenceManager<OpenSearchDirectoryReader> getReferenceManager(SearcherScope scope) {
        } else {
    private final IndexCommit indexCommit;  
    public boolean refreshNeeded() {
import org.apache.lucene.search.ReferenceManager;  
}  
        return newEmptySnapshot();
 */
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.store.Directory;
    }
    }
    }
 * GitHub history for details.
        return new Translog.Snapshot() {
 *  
                indexWriterLock = obtainLock ? directory.obtainLock(IndexWriter.WRITE_LOCK_NAME) : null;  
                    // Ephemeral commit — unpinningDir only needs to live during open();
        final DirectoryReader reader = DirectoryReader.open(directory, leafSorter);  
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNo) throws IOException {  
            return snapshot.totalOperations();
    }
    @Override
    @Override  
    }  
import org.opensearch.common.lucene.Lucene;  
    public long getPersistedLocalCheckpoint() {
    protected boolean assertMaxSeqNoEqualsToGlobalCheckpoint(final long maxSeqNo, final long globalCheckpoint) {
        // that guarantee that all operations have been flushed to Lucene.
 * license agreements. See the NOTICE file distributed with
        try (Translog.Snapshot snapshot = newChangesSnapshot(source, fromSeqNo, toSeqNo, false, true)) {
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {
        boolean flush,  
    }  
    }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ) {}  
    /**
            try {
            throw new UncheckedIOException(e); // this is stupid
    @Override
    private static SeqNoStats buildSeqNoStats(EngineConfig config, SegmentInfos infos) {
            config.getIndexSettings().getTranslogRetentionAge().getMillis(),
    }
import java.util.Comparator;
            + ">"
        return getPersistedLocalCheckpoint();
    @Override  
        throw new UnsupportedOperationException("no-ops are not supported on a read-only engine");
            boolean success = false;
    }
        boolean obtainLock,
        // created after the refactoring of the Close Index API and its TransportVerifyShardBeforeCloseAction
    public void activateThrottling() {}
import org.apache.lucene.index.SoftDeletesDirectoryReaderWrapper;
        // In addition to that we only execute the check if the index the engine belongs to has been  
    @Override
import java.util.function.BiFunction;
                )
                    config.getPrimaryTermSupplier(),  
    public NoOpResult noOp(NoOp noOp) {
            }
        if (translogUuid == null) {
        throws IOException {
     * @param seqNoStats sequence number statistics for this engine or null if not provided  
        TranslogStats translogStats,
    }
    @Override
        } else {  
        final DirectoryReader reader = DirectoryReader.open(directory);
    @Override
    public long getMinRetainedSeqNo() {  
            Lock indexWriterLock = null;
                "Maximum sequence number ["  
        return safeCommitInfo;  
        long toSeqNo,
        }  
    }  
    @Override
import org.apache.lucene.index.DirectoryReader;  
                this.indexCommit = Lucene.getIndexCommit(lastCommittedSegmentInfos, directory);
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {  
    @Override
                success = true;  
        return getFromSearcher(get, searcherFactory, SearcherScope.EXTERNAL);  
        // Before 3.0 the global checkpoint is not known and up to date when the engine is created after  
        // check this value before closing the read-only engine but if something went wrong
            try {  
        assert false : "this should not be called";  
    private final SegmentInfos lastCommittedSegmentInfos;  
    protected static DirectoryReader openDirectory(Directory directory, boolean wrapSoftDeletes, Comparator<LeafReader> leafSorter)  
        // checkpoint is different from the unassigned sequence number value.
    public boolean shouldPeriodicallyFlush() {  
    protected SegmentInfos getLastCommittedSegmentInfos() {
    @Override
    @Override
                .newTranslog(  
        final TranslogDeletionPolicy translogDeletionPolicy = new DefaultTranslogDeletionPolicy(  
    }
     */
    public void maybePruneDeletes() {}  
    }
    }
    public void deactivateThrottling() {}
        }
     *                   the lock won't be obtained  
    @Override  
     * read-write engine. It allows to optionally obtain the writer locks for the shard which would time-out if another
import org.opensearch.index.translog.TranslogStats;
import org.opensearch.transport.Transports;
        // peer recovery, so we only check the max seq no / global checkpoint coherency when the global
     * ID field.
            } finally {
                this.lastCommittedSegmentInfos = Lucene.readSegmentInfos(directory);
    public List<Segment> segments(boolean verbose) {
            }
                this.seqNoStats = seqNoStats;  
import java.io.Closeable;  
    }
 */
                }
                    translogConfig,
import org.opensearch.index.seqno.SequenceNumbers;  
    public GatedCloseable<IndexCommit> acquireLastIndexCommit(boolean flushFirst) {  
        return new SeqNoStats(seqNoStats.getMaxSeqNo(), seqNoStats.getLocalCheckpoint(), globalCheckpoint);  
                readerManager = new OpenSearchReaderManager(reader);
        return new GatedCloseable<>(new SegmentInfosCatalogSnapshot(lastCommittedSegmentInfos), store::decRef);
 */  
            return new SoftDeletesDirectoryReaderWrapper(reader, Lucene.SOFT_DELETES_FIELD);  
                // we obtain the IW lock even though we never modify the index.
                    translogUuid,  
     *
    @Override
    }  
 * You may obtain a copy of the License at  
import org.opensearch.index.store.remote.directory.BlockUnpinningDirectory;
        try (
        return 0;
        }
    }  
        return seqNoStats.getLocalCheckpoint();  
    public boolean isThrottled() {  
    @Override
        boolean requireCompleteHistory
        return false;
                    + "]"
            Store store = config.getStore();  
import org.opensearch.index.translog.TranslogManager;  
 * engine.  
                    translogDeletionPolicy,
     * @param config the engine configuration
    }  
 * @opensearch.internal
                this.translogStats = translogStats != null ? translogStats : translogStats(config, lastCommittedSegmentInfos);
                    config.getStartedPrimarySupplier(),
import java.util.Arrays;  
    ) {
    }  
    private boolean isClosedRemoteIndex() {  
import org.opensearch.index.store.Store;
    @Override
                    + "] from last commit does not match global checkpoint ["
     * Returns true if this is a remote store index (included if migrating as well) which is closed.
package org.opensearch.index.engine;
        return lastCommittedSegmentInfos;  
import java.io.IOException;
    public Closeable acquireHistoryRetentionLock() {
    public long getProcessedLocalCheckpoint() {
        return seqNoStats.getGlobalCheckpoint();
    public CompletionStats completionStats(String... fieldNamePatterns) {  
            } catch (Exception ex) {  
    protected SegmentInfos getLatestSegmentInfos() {
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
        assert maxSeqNoOfUpdatesOnPrimary <= getMaxSeqNoOfUpdatesOrDeletes() : maxSeqNoOfUpdatesOnPrimary  
    /**  
    public long getWritingBytes() {
import org.apache.lucene.store.Lock;  
    private final SafeCommitInfo safeCommitInfo;
    }
        }
        assert false : "this should not be called";  
        boolean upgrade,  
            OpenSearchDirectoryReader reader = null;
 * A basic read-only engine that allows switching a shard to be true read-only temporarily or permanently.
                    reader = wrapReader(open(indexCommit), readerWrapperFunction);  
    @Override
                this.safeCommitInfo = new SafeCommitInfo(seqNoStats.getLocalCheckpoint(), lastCommittedSegmentInfos.totalMaxDoc());  
     */  
    }
    @Override
    private final TranslogManager translogManager;
    }  
/*
    }
    @Override
import org.opensearch.index.translog.TranslogDeletionPolicy;
        return readerManager;
        DirectoryReader reader = DirectoryReader.open(commit);  
        return translogManager;
     * Reader attributes used for read only engines. These attributes prevent loading term dictionaries on-heap even if the field is an  
    }
        return this.engineConfig.getIndexSettings().isAssignedOnRemoteNode()
import org.opensearch.index.store.remote.directory.RemoteSnapshotDirectory;  
        SeqNoStats seqNoStats,  
    private final CompletionStatsCache completionStatsCache;  
    private final Lock indexWriterLock;
    @Override  
        return completionStatsCache.get(fieldNamePatterns);
        return acquireLastIndexCommit(false);
import org.opensearch.index.translog.TranslogConfig;
 * this work for additional information regarding copyright
                    seqNoStats = buildSeqNoStats(config, lastCommittedSegmentInfos);  
        };
import org.opensearch.index.translog.NoOpTranslogManager;
    }
        assert Transports.assertNotTransportThread("opening directory reader of a read-only engine");  
    @Override
        final String translogUuid = infos.getUserData().get(Translog.TRANSLOG_UUID_KEY);
    }
    @Override
    }
            Translog translog = config.getTranslogFactory()
 * the Apache License, Version 2.0 (the "License"); you may
        } catch (IOException e) {  
    }
 * specific language governing permissions and limitations
        ) {
        assert maxSeqNo == globalCheckpoint : "max seq. no. [" + maxSeqNo + "] does not match [" + globalCheckpoint + "]";  
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
    @Override
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {  
 *  
            } finally {
    public Translog.Snapshot newChangesSnapshot(
            + getMaxSeqNoOfUpdatesOrDeletes();
 * @see #ReadOnlyEngine(EngineConfig, SeqNoStats, TranslogStats, boolean, Function, boolean)
 * KIND, either express or implied.  See the License for the
                    seqNo -> {},
        boolean requiredFullRange,
    public long getIndexThrottleTimeInMillis() {
            public void close() {}  
    public long getIndexBufferRAMBytesUsed() {  
        return false;  
        translogDeletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);  
    protected volatile TranslogStats translogStats;
                }
     * @param readerWrapperFunction allows to wrap the index-reader for this engine.
    }  
                    BlockUnpinningDirectory unpinningDir = new BlockUnpinningDirectory(directory);  
     */
    }
        long fromSeqNo,  
    @Override
                    IOUtils.close(reader, indexWriterLock, store::decRef);  
        throw new UnsupportedOperationException();
    public void refresh(String source) {
                return null;  
                translogManager = new NoOpTranslogManager(shardId, readLock, this::ensureOpen, this.translogStats, EMPTY_TRANSLOG_SNAPSHOT);
        long localCheckpoint = seqNoStats.localCheckpoint;
        return seqNoStats.getMaxSeqNo();
        boolean onlyExpungeDeletes,
        if (wrapSoftDeletes) {
import java.io.UncheckedIOException;
    @Override
        return new GatedCloseable<>(indexCommit, store::decRef);
        return OpenSearchDirectoryReader.wrap(reader, engineConfig.getShardId());
        assert assertMaxSeqNoEqualsToGlobalCheckpoint(seqNoStats.getMaxSeqNo(), seqNoStats.getGlobalCheckpoint());  
            return;
        throw new UnsupportedOperationException("indexing is not supported on a read-only engine");
    }  
        return new SoftDeletesDirectoryReaderWrapper(reader, Lucene.SOFT_DELETES_FIELD);
    @Override
    public boolean maybeRefresh(String source) throws EngineException {
        // reopened as an internal engine, which would be the path to fix the issue.
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
                // yet this makes sure nobody else does. including some testing tools that try to be messy
import java.util.concurrent.CountDownLatch;  
    public String getHistoryUUID() {  
                }
        }  
        // checking the value here again would prevent the read-only engine to be closed and
    private static TranslogStats translogStats(final EngineConfig config, final SegmentInfos infos) throws IOException {  
    public TranslogManager translogManager() {  
     * @param requireCompleteHistory indicates whether this engine permits an incomplete history (i.e. LCP &lt; MSN)
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.SegmentInfos;
                } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.translog.Translog;  
import org.apache.lucene.store.FilterDirectory;
    ) {
import org.opensearch.common.util.io.IOUtils;
    public long getLastSyncedGlobalCheckpoint() {
/**  
        // the value of the global checkpoint is verified when the read-only engine is opened,  
                assert translogStats != null || obtainLock : "mutiple translogs instances should not be opened at the same time";  
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
            return new SoftDeletesDirectoryReaderWrapper(reader, Lucene.SOFT_DELETES_FIELD);
import org.opensearch.cluster.metadata.IndexMetadata;
        final TranslogConfig translogConfig = config.getTranslogConfig();
    @Override
            }
    protected DirectoryReader open(IndexCommit commit) throws IOException {
    private final SeqNoStats seqNoStats;
        );
                if (seqNoStats == null) {
    }
    public IndexResult index(Index index) {
        String forceMergeUUID
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        // and it is not expected to change during the lifecycle of the engine. We could also
        assert false : "this should not be called";  
    }  
 * under the License.  
        // opened side-by-side  
    @Override  
    public int fillSeqNoGaps(long primaryTerm) {
        if (wrapSoftDeletes) {
    public GetResult get(Get get, BiFunction<String, SearcherScope, Engine.Searcher> searcherFactory) throws EngineException {
    }
