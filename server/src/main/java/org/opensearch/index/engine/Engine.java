 *
     * @param maybeFatal   the throwable that maybe contains a fatal error
     * @param source       source of the request
        }
    protected final EngineConfig engineConfig;
                currentThrottleNS += System.nanoTime() - startOfThrottleNS;
     * This check is mainly based on the uncommitted translog size and the translog flush threshold setting.
import java.util.function.BiFunction;
        ).scoreDocs;
    }
                );
        );
            if (suppressed != null) {
                // this must happen before we close IW or Translog such that we can check this state to opt out of failing the engine
        public void unlock() {}
                    docIdAndVersion.primaryTerm
         * due to it's append only nature.
        /** get total time in nanoseconds */
                SegmentReader segmentReader = Lucene.segmentReader(ctx.reader());
     */
     * Synchronously refreshes the engine for new search operations to reflect the latest
        try (Searcher searcher = acquireSearcher("docStats", SearcherScope.INTERNAL)) {
            throw new IllegalStateException("Can't use " + getIndexReader().getClass() + " as a directory reader");
            if (isThrottled()) {
         */
     * @return {@link SegmentInfos}
        return 0;
    public static final String MERGE_FAILED = "merge failed";
    /**
         */
        }
        public long getTook() {
         *
            return seqNo;
     *  - we also use this to flush big-ass merges on an inactive engine / shard but if we we initialize 0 or Long.MAX_VALUE we either
                store.decRef();
        public long getIfPrimaryTerm() {
     */
    }
     *
            super(Operation.TYPE.DELETE, failure, version, term, seqNo);
    /**
            version,
import org.opensearch.indices.pollingingest.PollingIngestStats;
    }
            VersionType versionType,
     * the specified message will attempt to be logged before throwing the fatal error. If the specified throwable does not contain a fatal
import org.opensearch.index.mapper.DocumentMapperForType;
                            try {
    public void failEngine(String reason, @Nullable Exception failure) {
            /*
            throw e;
            Term uid,
    public static class Delete extends Operation {
     * @param versionType the version type
    /** returns the history uuid for the engine */
        return false;
    public void flushAndClose() throws IOException {
        public DeleteResult(Exception failure, long version, long term) {
        private final Term uid;
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
     */
        private final long startTime;
    }
                    }
        }
            MAPPING_UPDATE_REQUIRED
        }
     *
        Segment[] segmentsArr = segments.values().toArray(new Segment[0]);
            freeze.set(true);
    /**
     *  reduce index buffer sizes on inactive shards.
            IndexReader reader,
        private final long term;
import java.util.concurrent.locks.Lock;
            Thread.currentThread().interrupt();
        return acquireSearcher(source, SearcherScope.EXTERNAL);
        }
     * changes.
        private final boolean exists;
            assert (origin == Origin.PRIMARY) || (ifSeqNo == UNASSIGNED_SEQ_NO && ifPrimaryTerm == UNASSIGNED_PRIMARY_TERM)
            long startTime,
     * and the max seen sequence ID are identical.
    @ExperimentalApi
            lock = lockReference;
            }
         * to make sure that the store is not closed before
            this.requiredMappingUpdate = null;
        }
            releasable = null; // success - hand over the reference to the engine reader
                System.nanoTime(),
            ParsedDocument doc,
    @PublicApi(since = "1.0.0")
    /**
    public abstract boolean hasCompleteOperationHistory(String reason, long startingSeqNo);
            }
import org.opensearch.index.VersionType;
    @ExperimentalApi
     * the policy, so a long-lived replica engine can otherwise carry a policy that no longer matches the
        }
     */
     *    immediately or never commit merges even though we shouldn't from a user perspective (this can also have funky side effects in
            stats.addFileSizes(getSegmentFileSizes(segmentReader));
        private final SetOnce<Boolean> freeze = new SetOnce<>();
            this.found = found;
            throw new UnsupportedOperationException();
    /**
import org.apache.lucene.index.IndexFileNames;
     * to avoid the extra disk read.
            this.id = Objects.requireNonNull(id);
        public BytesReference source() {
    void refreshPrimaryOperationPolicy() {}
        private final long ifSeqNo;
    }
    public void clearUncommittedSegmentBytes() {}
            return this;
        }
        @Override
        @Override
            this.docIdAndVersion = docIdAndVersion;
        if (failure != null) {
                        source,
                logger.error("failed to access searcher manager", e);
        }
     * @param toSeqNumber  to sequence number; included
                    } catch (IOException e) {
            if (get.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
     * @param force         if <code>true</code> a lucene commit is executed even if no changes need to be committed.
     * @opensearch.api
        }
                        } else {
                && (get.getIfSeqNo() != docIdAndVersion.seqNo || get.getIfPrimaryTerm() != docIdAndVersion.primaryTerm)) {
     * @throws IllegalStateException if the sanity checks failed
            long ifSeqNo,
            customTranslogDeletionPolicy,
            final CatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(infos);
            this.resultType = Type.SUCCESS;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    /**
                    get.getIfPrimaryTerm(),
        public void close() {
    /**
     * @param localSegmentsSizeMap post-refresh local segment file names mapped to their sizes in bytes
        boolean flush,
        public Origin origin() {
import org.opensearch.common.Nullable;
     *
                Origin.PRIMARY,
        boolean isThrottled() {
    }
         * Called once a new top-level reader is opened.
    /**
    /**
        @Override
                    closeNoLock("engine failed on: [" + reason + "]", closedLatch);
     *
            this.version = version;
            this.ifPrimaryTerm = ifPrimaryTerm;
     */
     * <p>
    public abstract void refresh(String source) throws EngineException;
    protected abstract ReferenceManager<OpenSearchDirectoryReader> getReferenceManager(SearcherScope scope);
            setSimilarity(similarity);
        public abstract int estimatedSizeInBytes();
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
        private final ReleasableLock lockReference = new ReleasableLock(new ReentrantLock());
            logger.debug(
     *
                );
         * The source that caused this searcher to be acquired.
         * Returns <code>true</code> if this index requests has been retried on the coordinating node and can therefor be delivered
            return primaryTerm;
        long ifSeqNo,
            return flush();
        }
        if (docIdAndVersion != null) {
        if (Lucene.isCorruptionException(e)) {
                    }
     * document specific failures
     * The list of segments in the engine.
        }
            try {
        public String id() {
        }
        public String id() {
            Closeable onClose
        );
        @Nullable
        searcher.setQueryCache(null);
        }
    public DocsStats docStats() {
            lock = NOOP_LOCK;
 * The OpenSearch Contributors require contributions made to
            AlreadyClosedException ace = new AlreadyClosedException(shardId + " engine is closed", failedEngine.get());
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
            this.ifSeqNo = ifSeqNo;
     * Tries to prune buffered deletes from the version map.
            super(Operation.TYPE.NO_OP, 0, term, seqNo);
                template.origin(),
            return ifSeqNo;
                VersionType.INTERNAL,
        /**
        public void deactivate() {
        @Override
     * on {@code lastWriteNanos} we use System.nanoTime() to initialize this since:
            );
     *
        public long startTime() {
     */
        public Releasable acquireThrottle() {
            }
        }
    /**
     * A bulk-request scope that batches successful primary index operations before appending them to the translog.
            REPLICA,
     * @param origin the operation origin
        if (useCompoundFile) {
    public abstract String getHistoryUUID();
                throw new UncheckedIOException("failed to close", e);
     * to advance this marker to at least the given sequence number.
     * or the sequence number from {@link #advanceMaxSeqNoOfUpdatesOrDeletes(long)}. An index request is considered
        public IndexResult(long version, long term, long seqNo, boolean created) {
     */
            try {
     *
        if (isClosed.get() == false) {
        private final Function<Searcher, Searcher> wrapper;
     * @return {@link DeleteResult} containing updated translog location, version and
    /**
            this.uid = uid;
                } else {
        );
    /**
     * Moreover, operations that are optimized using the MSU optimization must not be processed twice as this will create duplicates
    public abstract DeleteResult delete(Delete delete) throws IOException;
    /*
        }
        }
                                store.decRef();
                                store.markStoreCorrupted(
        private final AtomicBoolean released = new AtomicBoolean(false);
            return CAN_MATCH_SEARCH_SOURCE.equals(source) ? searcher : wrapper.apply(searcher);
    }
    public abstract int fillSeqNoGaps(long primaryTerm) throws IOException;
        @Nullable
        }
        }
        /* Acquire order here is store -> manager since we need
import java.io.Closeable;
        ) {
import java.util.concurrent.TimeUnit;
        public void close() {
    public abstract void maybePruneDeletes();
     *
        public int estimatedSizeInBytes() {
        @PublicApi(since = "1.0.0")
                } finally {
     * Return the latest active SegmentInfos from the engine.
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
            return ifPrimaryTerm;
    protected final ReentrantLock failEngineLock = new ReentrantLock();
    /**
        private final ParsedDocument doc;
import org.opensearch.index.shard.DocsStats;
     * Checks if this engine should be flushed periodically.
     * Returns the unreferenced file cleanup count for this engine.
        /**
 *
     * object directly, this method returns a {@link GatedCloseable} reference to the same object.
        if (isClosed.get() == false) { // don't acquire the write lock if we are already closed
                        flush();
            assert ifPrimaryTerm >= 0 : "ifPrimaryTerm [" + ifPrimaryTerm + "] must be non negative";
        return new MergeStats();
     */
import org.apache.lucene.index.IndexWriter;
            .setMergePolicy(NoMergePolicy.INSTANCE)
    /**
        try {
     * translog) and close it.
    @PublicApi(since = "1.0.0")
        public VersionType versionType() {
            return found;
     * that act on docID(O) about which we do not yet know, so we cannot perform an add. Note this also covers the case where a future
            SearcherSupplier reader = new SearcherSupplier(wrapper) {
    }
        return prepareDelete(id, null, seqNo, primaryTerm, version, versionType, origin, ifSeqNo, ifPrimaryTerm);
            return this.doc.id();
    protected abstract SegmentInfos getLastCommittedSegmentInfos();
    }
import org.opensearch.common.unit.TimeValue;
            return uid;
import org.opensearch.common.lease.Releasable;
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        private final CounterMetric throttleTimeMillisMetric = new CounterMetric();
     *     <li> I2: If {@literal MSU(O) < seqno(O)} then docID(O) did not exist when O was applied; more precisely, if there is any O'
     */
        protected Result(Operation.TYPE operationType, Exception failure, long version, long term, long seqNo) {
            this.source = source;
import org.apache.lucene.search.IndexSearcher;
        }
            setQueryCachingPolicy(queryCachingPolicy);
import org.apache.lucene.index.SegmentCommitInfo;
 * GitHub history for details.
     */
     * A note on the optimization using max_seq_no_of_updates_or_deletes:
import java.util.Collections;
     * Prepares a delete operation by creating an Engine.Delete operation.
     */
        }
                        referenceManager.release(acquire);
                    () -> new ParameterizedMessage("Tried to query fileLength but file is gone [{}] [{}]", finalDirectory, file),
            this.startTime = startTime;
    protected Engine(EngineConfig engineConfig) {
        public Delete(Delete template, VersionType versionType) {
        return acquireSearcherSupplier(wrapper, SearcherScope.EXTERNAL);
            return seqNo;
     * Notes this method returns the auto_id_timestamp of all append-only requests, not max_unsafe_auto_id_timestamp.
import java.util.Comparator;
        }
    }
    /**
    }
     */
            Releasables.close(searcher);
        long fromSeqNo,
                return this == PEER_RECOVERY || this == LOCAL_TRANSLOG_RECOVERY;
     * @param autoGeneratedIdTimestamp the timestamp for auto-generated IDs
        public NoOp(final long seqNo, final long primaryTerm, final Origin origin, final long startTime, final String reason) {
        }
     * Default returns {@code 0}; engines with a running-merges accessor (e.g.,
                    if (shouldCleanupUnreferencedFiles() && isMergeFailureDueToIOException(failure, reason)) {
            String extension = IndexFileNames.getExtension(file);
            return resultType;
     * that do not opt in keep appending inline.
     * Acquires a safe {@link CatalogSnapshot} for the latest commit. Default implementation
            super(uid, seqNo, primaryTerm, version, versionType, origin, startTime);
     * @param ifSeqNo the ifSeqNo
            throw new IllegalStateException("commit doesn't contain history uuid");
            assert ifSeqNo == UNASSIGNED_SEQ_NO || ifSeqNo >= 0 : "ifSeqNo [" + ifSeqNo + "] must be non negative or unset";
        public boolean isFromTranslog() {
     * Flushes the state of the engine including the transaction log, clearing memory and persisting
 * not use this file except in compliance with the License.
import java.util.concurrent.locks.Condition;
                );
     * @return the number of no-ops added
                Versions.MATCH_ANY,
        segment.attributes = info.info.getAttributes();
        @Override
            this.searcher = searcher;
 * this file be licensed under the Apache-2.0 license or a
            return docsStats(searcher.getIndexReader());
        Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id()));
            }
     * @opensearch.api
    public interface Warmer {
    public interface TranslogBatch {
            }
     * as an update operation if it overwrites the existing documents in Lucene index with the same document id.
        if (docs.length == 0) {
     * <p>
     * commit.
     *
                public Searcher acquireSearcherInternal(String source) {
        void warm(OpenSearchDirectoryReader reader);
     * Holds result meta data (e.g. translog location, updated version)
        long primaryTerm,
         */
import org.opensearch.index.translog.Translog;
    /**
            try (ReleasableLock lock = writeLock.acquire()) {
        // we use the engine class directly here to make sure all subclasses have the same logger name
        }
            Releasables.close(releasable);
        ensureOpen();
     * A noop result
        }
            long startTime,
import org.opensearch.common.util.concurrent.ReleasableLock;
            this.found = found;
     * fail engine due to some error. the engine will also be closed.
                } finally {
        public Get setIfSeqNo(long seqNo) {
        final Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(id));
        }
            return new GatedCloseable<>(snapshot, commitRef::close);
                this.lowercase = this.toString().toLowerCase(Locale.ROOT);
            Origin origin,
        long primaryTerm,
    /**
            return operationType;
        public DeleteResult(Exception failure, long version, long term, long seqNo, boolean found) {
    @PublicApi(since = "1.0.0")
        }
            }
        }
            this.operationType = operationType;
                throw new EngineException(shardId, "failed to access searcher manager", e);
        }
     */
         * if this property is non-negative indexing code might optimize the addition of this document
     */
    }
    /**
     * which is run when the reference is closed. The default implementation of the clean-up
                        segment.sizeInBytes = info.sizeInBytes();
            String id,
        // the next scheduled refresh to go through and refresh the stats as well
            try {
        long toSeqNo,
            logger.error(() -> new ParameterizedMessage("failed to acquire reader"), ex);
     * Note: this time might not be absolutely accurate since the {@link Operation#startTime()} is used which might be
    public final CommitStats commitStats() {
        Map<String, Long> map = new HashMap<>();
        segment.segmentSort = info.info.getIndexSort();
                // again on any caught AlreadyClosedException
    }
     * Get operation
     * @opensearch.internal
            } catch (IOException e) {
    /**
              store. this violates the assumption that all files are closed when
    public boolean refreshNeeded() {
        public long getIfPrimaryTerm() {
                    segment.segmentSort = info.info.getIndexSort();
import java.util.Map;
                searcher.getDirectoryReader(),
        final GatedCloseable<IndexCommit> commitRef = acquireLastIndexCommit(flushFirst);
        final DocIdAndVersion docIdAndVersion;
                logger.warn(
            doc,
        } catch (IOException | RuntimeException e) {
                closeNoLock("api", closedLatch);
                    get.id(),
                e.addSuppressed(closeEx);
        }
        try (Searcher searcher = acquireSearcher("segments_stats", SearcherScope.EXTERNAL)) {
        long startTime = System.nanoTime();
                directory = engineConfig.getCodec().compoundFormat().getCompoundReader(segmentReader.directory(), segmentCommitInfo.info);
import java.util.function.Function;
            closedLatch.await();
    public void updateUncommittedSegmentBytes(Map<String, Long> localSegmentsSizeMap, long flushThresholdBytes) {}
        String id,
    public int getActiveMergeCount() {
        return IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP;
            Origin origin,
    /**
            throw new UnsupportedOperationException();
        public SearcherSupplier(Function<Searcher, Searcher> wrapper) {
        this.engineConfig = engineConfig;
    protected void writerSegmentStats(SegmentsStats stats) {
    public enum SearcherScope {
    public abstract NoOpResult noOp(NoOp noOp) throws IOException;
            directory = segmentReader.directory();
        return NO_OP_TRANSLOG_BATCH;
import java.util.concurrent.locks.ReentrantLock;
        boolean upgradeOnlyAncientSegments,
    @PublicApi(since = "1.0.0")
        return uuid;
            long primaryTerm,
     * A replica shard receives a new max_seq_no_of_updates from its primary shard, then calls this method
        if (globalCheckpoint != maxSeqNo) {
    /**
/*
 * @opensearch.api
            this.resultType = Type.MAPPING_UPDATE_REQUIRED;
import org.apache.lucene.search.ReferenceManager;
        public Operation(Term uid, long seqNo, long primaryTerm, long version, VersionType versionType, Origin origin, long startTime) {
package org.opensearch.index.engine;
        } finally {
            OpenSearchDirectoryReader acquire = referenceManager.acquire();
            return SequenceNumbers.NO_OPS_PERFORMED;
import java.util.Objects;
                        // are running.
     * <p>
        public static final GetResult NOT_EXISTS = new GetResult(false, Versions.NOT_FOUND, null, null, false);
        try (IndexWriter writer = new IndexWriter(store.directory(), iwc)) {
                        acquire,
     * Perform document index operation on the engine
            }
        // we don't wait for a pending refreshes here since it's a stats call instead we mark it as accessed only which will cause
     * {@link DocumentIndexWriter}) override.
        public void lockInterruptibly() throws InterruptedException {}
        }
    public abstract boolean shouldPeriodicallyFlush();
     *
    public abstract SafeCommitInfo getSafeCommitInfo();
            Queries.newMatchAllQuery(),
            this(uid, primaryTerm, doc, Versions.MATCH_ANY);
            throw new EngineException(shardId, "Failed to materialize CatalogSnapshot from safe IndexCommit", e);
            this.autoGeneratedIdTimestamp = autoGeneratedIdTimestamp;
            this.wrapper = wrapper;
                    segments.put(info.info.name, segment);
     * inline exactly as today; only an engine that overrides it defers. {@link #flush()} appends the currently pending
        }
public abstract class Engine implements LifecycleAware, Closeable {
    }
     * @param version the version
                versionType,
    @Deprecated
         * Get the sequence number on the primary.
                () -> Releasables.close(searcher, reader)
                try (Searcher searcher = acquireSearcher("refresh_needed", SearcherScope.EXTERNAL)) {
                () -> new ParameterizedMessage(
     * Request that this engine throttle incoming indexing requests to one thread.
            this.versionType = versionType;
     *
        }
        } finally {
    }
            }
    private void fillSegmentInfo(SegmentReader segmentReader, boolean verbose, boolean search, Map<String, Segment> segments) {
        public long getVersion() {
            }
import org.apache.lucene.index.IndexWriterConfig;
    }
     * @opensearch.api
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndVersion;
            return lock != NOOP_LOCK;
            return this.routing;
            SUCCESS,
import org.opensearch.search.suggest.completion.CompletionStats;
        }
        @Override
                    // we first mark the store as corrupted before we notify any listeners
        }
import org.opensearch.core.common.unit.ByteSizeValue;
    public static class Get {
    }
     * engines which never publish (e.g. {@link NRTReplicationEngine}, read-only engines) are correct by
 */
     */
     * @param waitIfOngoing if <code>true</code> this call will block until all currently running flushes have finished.
                searcher.getSimilarity(),
        String id() {
            // we go on the segment level here to get accurate numbers
        public Translog.Location getTranslogLocation() {
            this(failure, version, UNASSIGNED_PRIMARY_TERM, UNASSIGNED_SEQ_NO);
        private final String reason;
    public interface EventListener {
     * @see #getIndexThrottleTimeInMillis()
        @Nullable String routing,
            final SegmentInfos infos = Lucene.readSegmentInfos(commitRef.get());
                final Directory finalDirectory = directory;
                version,
            }
                UNASSIGNED_SEQ_NO,
                    }
    }
        boolean requiredFullRange,
                template.uid(),
        }
/*
                    reason
                        () -> new ParameterizedMessage("tried to fail engine but engine is already failed. ignoring. [{}]", reason),
        }
    /**
     * Default returns {@code false}; engines with a pending-merge queue (e.g., {@link InternalEngine}'s
        }
            } catch (IOException closeEx) {
                0,
     * @return the prepared index operation
     * Reads the current stored history ID from commit data.
    /**
                    () -> new ParameterizedMessage(
                @Override
        assert docIdAndVersion != null;
     * Acquires a {@link CatalogSnapshot} pinned to the most recent commit on disk,
                assert false : "SearchSupplier was released twice";
 *
     * Lucene + other formats) should override this to return their native catalog snapshot.
            this.failure = Objects.requireNonNull(failure);
    public void close() throws IOException {
                        engineConfig.getSimilarity(),
                return lock.isHeldByCurrentThread();
                engineConfig.getIndexSettings().getTranslogRetentionAge().getMillis(),
            if (throttleTimeNS >= 0) {
    ) {
            } catch (IOException e) {
                }
        try (DirectoryReader innerReader = StandardDirectoryReader.open(store.directory(), segmentInfos, null, null, null)) {
     * @param seqNo the sequence number
    /**
                false,
            failEngine("corrupt file (source: [" + source + "])", e);
            return term;
        }
     * @param primaryTerm the primary term
     */
                return Map.of();
        public String id() {
        segment.delDocCount = segmentReader.numDeletedDocs();
        public long getTerm() {
        private long ifPrimaryTerm = UNASSIGNED_PRIMARY_TERM;
     */
    public abstract SeqNoStats getSeqNoStats(long globalCheckpoint);
                -1,
         * Called when a fatal exception occurred
     * The default {@link #beginTranslogBatch()} returns {@link #NO_OP_TRANSLOG_BATCH}, under which engines keep writing
        public Type getResultType() {
        public long version() {
     * Supplier for the searcher
     */
    @PublicApi(since = "1.0.0")
                // This means there's a bug somewhere: don't suppress it
    }
     * @param primaryTerm the primary term
        }
import org.apache.lucene.index.SegmentInfos;
        public void setTranslogLocation(Translog.Location translogLocation) {
import org.apache.lucene.search.ScoreDoc;
    public final void ensureOpen() {
    /**
        segments.put(info.info.name, segment);
        }
     * Cleanup all unreferenced files generated during failed segment merge. This resets shard state to last Lucene
                sizeInBytes += info.sizeInBytes();
    /**
     * Publishes the total size of segment bytes not yet referenced by the last commit point, computed from the
            this.seqNo = seqNo;
            uid,
            );
        }
        @Override
     * @return the minimum retained sequence number
        private Translog.Location translogLocation;
            )
            throw ace;
    /**
            SegmentCommitInfo info = segmentReader.getSegmentInfo();
    }
    }
     * Returns the maximum sequence number of either update or delete operations have been processed in this engine
            } catch (IOException e) {
        if (lastCommittedSegmentInfos != null) {
 * specific language governing permissions and limitations
        public long getIfSeqNo() {
            long ifPrimaryTerm,
     *  NOTE: don't use this value for anything accurate it's a best effort for freeing up diskspace after merges and on a shard level to
        protected abstract Searcher acquireSearcherInternal(String source);
        Directory directory = null;
        for (LeafReaderContext readerContext : indexReader.leaves()) {
    }
    PrimaryOperationPolicy getPrimaryOperationPolicy() {
     * must be closed for segment files to be deleted.
     * native state isn't a single {@link SegmentInfos} (e.g. multi-format engines that aggregate
        public boolean isFound() {
import org.apache.lucene.index.NoMergePolicy;
            return autoGeneratedIdTimestamp;
        public Index(Term uid, long primaryTerm, ParsedDocument doc) {
        public DeleteResult(long version, long term, long seqNo, boolean found) {
        });
                throw new VersionConflictEngineException(
     */
     * This feature requires soft-deletes enabled. If soft-deletes are disabled, this method will throw an {@link IllegalStateException}.
     * The threshold to flush at is supplied by the publisher rather than read from settings here, because resolving it
        private final long ifPrimaryTerm;
            final SegmentReader segmentReader = Lucene.segmentReader(readerContext.reader());
        }
 */
        public abstract TYPE operationType();
         * Returns operation start time in nanoseconds.
        public @Nullable String routing() {
    /**
            this.id = id;
            long version,
        private volatile ReleasableLock lock = NOOP_LOCK;
                    logger.debug("flushing shard on close - this might take some time to sync files to disk");
                    );
                fillSegmentInfo(Lucene.segmentReader(ctx.reader()), verbose, true, segments);
        if (store.shouldSetParentField()) {
    }
            Releasables.close(releasable);
            this.ifSeqNo = seqNo;
    }
            this.seqNo = UNASSIGNED_SEQ_NO;
        return stats;
            return this;
                    } finally {
        }
        @Override
        public List<Document> docs() {
                SegmentReader segmentReader = Lucene.segmentReader(ctx.reader());
     *
            for (LeafReaderContext ctx : searcher.getIndexReader().getContext().leaves()) {
            long throttleTimeNS = System.nanoTime() - startOfThrottleNS;
        }
        }
        abstract String id();
            this.found = false;
import org.opensearch.index.mapper.Mapping;
         */
    public final void flush() throws EngineException {
    /**
        public void activate() {
                e.addSuppressed(closeEx);
     */
        if (includeSegmentFileSizes) {
        }
     */
     * continues. {@link #finish()} appends the final chunk and closes the scope.
     * Gets the minimum retained sequence number for this engine.
            return version;
                                () -> new ParameterizedMessage(
            }
        private final Mapping requiredMappingUpdate;
            } catch (AlreadyClosedException e) {
        }
     */
    }
                logger.warn(
            assert ifPrimaryTerm >= 0 : "ifPrimaryTerm [" + ifPrimaryTerm + "] must be non negative";
        if (docIdAndVersion != null) {
        this.shardId = engineConfig.getShardId();
    public abstract long getIndexBufferRAMBytesUsed();
         *
            public boolean isFromTranslog() {
            String source,
        long seqNo,
        /**
        } else {
        SegmentCommitInfo info = segmentReader.getSegmentInfo();
        int maxNumSegments,
                engineConfig.getIndexSettings().getTranslogRetentionTotalFiles()
                    shardId,
import java.io.FileNotFoundException;
     * latest visible-to-readers segments, including any uncommitted operations that have been
        } catch (AlreadyClosedException ex) {
     * @param ifSeqNo the ifSeqNo
     *
        Get get,
     * Method to close the engine while the write lock is held.
        return docIdAndVersion.seqNo;
import java.io.UncheckedIOException;
            this.term = term;
     * The delete result
    /**
                    + globalCheckpoint
        final Engine.Searcher searcher = searcherFactory.apply("get", scope);
        Objects.requireNonNull(engineConfig.getStore(), "Store must be provided to the engine");
                        logger.trace(() -> new ParameterizedMessage("failed to get size for [{}]", info.info.name), e);
     * for an executed write {@link Operation}
        protected abstract void doClose();
            FAILURE,
        awaitPendingClose();
            return (uid().field().length() + uid().text().length()) * 2 + 20;
        }
    /**
        Releasable releasable = store::decRef;
     * A policy change alters sequence-number assignment, so callers must invoke this only while
            PRIMARY,
        public Condition newCondition() {
        SegmentsStats stats = new SegmentsStats();
                }
        private final long version;
            this.created = created;
import org.opensearch.index.translog.TranslogManager;
        long version,
     * Therefore, if {@literal MSU <= LCP < seqno(O)} we know that O can safely be optimized with and added to lucene with addDocument.
                this.took = took;
        ) {
            this.ifSeqNo = ifSeqNo;
        }
    protected void fillSegmentStats(SegmentReader segmentReader, boolean includeSegmentFileSizes, SegmentsStats stats) {
                throw new IllegalStateException("result is already frozen");
                    get.id(),
    public abstract void deactivateThrottling();
            return readFromTranslog;
        protected Result(Operation.TYPE operationType, Mapping requiredMappingUpdate) {
        }
 * Unless required by applicable law or agreed to in writing,
     * Begin a translog batch for the current bulk-request execution scope. The default is a no-op batch, so engines
            super(Operation.TYPE.INDEX, requiredMappingUpdate);
            logger.error("Error while deleting unreferenced file ", ex);
            return throttleTimeMillisMetric.count() + TimeValue.nsecToMSec(currentThrottleNS);
        }
                template.version(),
    }
            try {
            logger.trace("flushAndClose now acquire writeLock");
     * Note: engine level failures (i.e. persistent engine failures) are thrown
        VersionType versionType,
            for (LeafReaderContext ctx : searcher.getIndexReader().getContext().leaves()) {
    @SuppressWarnings("finally")
    /**
        }
         * Origin of the operation
        Translog.Location flush();
    /** Check whether the merge failure happened due to IOException. */
            return TYPE.DELETE;
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.index.store.Store;
            return fromTranslog;
            segment.sizeInBytes = info.sizeInBytes();
                try {
        return new Engine.Index(
            1,
            super(null, seqNo, primaryTerm, Versions.NOT_FOUND, null, origin, startTime);
        private final Operation.TYPE operationType;
        segment.compound = info.info.getUseCompoundFile();
                                );
        ScoreDoc[] docs = searcher.search(
     * retrieves the _seq_no of the retrieved document.
        Engine.Operation.Origin origin,
     * </ol>
    @PublicApi(since = "1.0.0")
    }
    @PublicApi(since = "1.0.0")
                protected void doClose() {
            return ifPrimaryTerm;
        this.logger = Loggers.getLogger(Engine.class, engineConfig.getShardId());
     */
                    shardId,
                        // TODO we might force a flush in the future since we have the write lock already even though recoveries
                if (currentThrottleNS < 0) {
     */
    @PublicApi(since = "1.0.0")
    public static final String HISTORY_UUID_KEY = "history_uuid";
    public static final String MIN_RETAINED_SEQNO = "min_retained_seq_no";
    public SearcherSupplier acquireSearcherSupplier(Function<Searcher, Searcher> wrapper, SearcherScope scope) throws EngineException {
    /**
        final CatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(segmentInfosRef.get());
                primaryTerm,
        if (store.tryIncRef()) {
        long startTime = System.nanoTime();
            return isRetry;
            this.seqNo = seqNo;
            } catch (NoSuchFileException | FileNotFoundException e) {
        private long ifSeqNo = UNASSIGNED_SEQ_NO;
                if (failedEngine.get() != null) {
            throw new EngineException(shardId, "Couldn't resolve version", e);
    /**
     * @return a {@link SeqNoStats} object, using local state and the supplied global checkpoint
     * as they are now, rather than the one resolved when this engine was built. A replica never consults
     */
    protected final CountDownLatch closedLatch = new CountDownLatch(1);
/**
}
    }
        private VersionType versionType = VersionType.INTERNAL;
     * <p>
     * engines that never serve primary-origin operations.
        return null;
        public NoOpResult(long term, long seqNo, Exception failure) {
        return Collections.unmodifiableMap(map);
        public enum Type {
                            } catch (IOException e) {
                    // Paranoia (System.nanoTime() is supposed to be monotonic): time slip must have happened, have to ignore this value
    @Nullable
                        cleanUpUnreferencedFiles();
    public abstract boolean maybeRefresh(String source) throws EngineException;
            this.resultType = Type.FAILURE;
     */
    public Searcher acquireSearcher(String source, SearcherScope scope, Function<Searcher, Searcher> wrapper) throws EngineException {
     */
    public abstract void forceMerge(
    public Engine.Delete prepareDelete(
    public abstract GatedCloseable<IndexCommit> acquireLastIndexCommit(boolean flushFirst) throws EngineException;
                "Global checkpoint ["
/*
            } catch (IOException e) {
    }
        try {
                        logger.debug("engine already closed - skipping flushAndClose");
        public final Searcher acquireSearcher(String source) {
    public MergedSegmentTransferTracker getMergedSegmentTransferTracker() {
        public boolean exists() {
        /**
     * Counts the number of history operations in the given sequence number range
         * Returns the routing value for this delete operation, or {@code null} if no custom routing was specified.
    protected final Logger logger;
     */
        // we calculate the doc stats based on the internal searcher that is more up-to-date and not subject
            maybeDie(reason, failure);
        } else {
     * Fills up the local checkpoints history with no-ops until the local checkpoint
     */
            return this.doc.routing();
     * Returns the {@link CompletionStats} for this engine
        long getThrottleTimeInMillis() {
import org.apache.lucene.index.IndexCommit;
     * Acquires a point-in-time reader that can be used to create {@link Engine.Searcher}s on demand.
        }
        }
            map.merge(extension, length, Long::sum);
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Locale;
            assert ifSeqNo == UNASSIGNED_SEQ_NO || ifSeqNo >= 0 : "ifSeqNo [" + ifSeqNo + "] must be non negative or unset";
     * Propagates {@link IOException} as-is so callers (e.g. shard-store fetch on corrupted
     */
     */
            long version,
        Set<String> segmentName = new HashSet<>();
     */
     * chunk but keeps the scope open, allowing a realtime GET or a size limit to force an early append while the bulk
            long ifSeqNo,
                    // we just go and close this engine - no way to recover
        }
                failedEngine.set((failure != null) ? failure : new IllegalStateException(reason));
     * that docID(O) has been deleted (or never existed) without needing to check Lucene for the following reason. If there's no earlier
            QueryCache queryCache,
        public IndexResult(Exception failure, long version) {
                    close(); // double close is not a problem
    public abstract GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException;
            assert startOfThrottleNS > 0 : "Bad state of startOfThrottleNS";
     */
                logger.warn(() -> new ParameterizedMessage("Error when trying to query fileLength [{}] [{}]", finalDirectory, file), e);
        public long getIfSeqNo() {
     * @return {@link GatedCloseable} - A wrapper around a {@link SegmentInfos} instance that
    protected boolean maybeFailEngine(String source, Exception e) {
     * {@code acquireThrottle} method to block on a lock when throttling
        public NoOpResult(long term, long seqNo) {
     * Perform document delete operation on the engine
     */
                source,
import org.opensearch.index.mapper.ParsedDocument;
     * A flush may be initiated by another thread resolving a pending realtime GET. Implementations must serialize
            return this.doc.source();
                    logger.warn(
     * Prepares an index operation by parsing the source document and creating an Engine.Index operation.
        private static final ReleasableLock NOOP_LOCK = new ReleasableLock(new NoOpLock());
                engineConfig.getIndexSettings().getTranslogRetentionSize().getBytes(),
            try {
    }
    /** A {@link TranslogBatch} that batches nothing; every op is written inline as before. */
        @Override
                    segment.search = false;
     *
     *    consider it active for the duration of the configured active to inactive period. If we initialize to 0 or Long.MAX_VALUE we
                    segment.version = info.info.getVersion();
     */
import java.util.Arrays;
                UNASSIGNED_SEQ_NO,
import org.opensearch.index.mapper.IdFieldMapper;
                    segment.committed = true;
        Map<String, Segment> segments = new HashMap<>();
     * operation O' with {@literal seqNo(O') > seqNo(O) and docId(O') = docID(O)} is processed before O. In that case MSU(O') is at least
        public TYPE operationType() {
    ) {
        /**
     */
            assert (origin == Origin.PRIMARY) || (ifSeqNo == UNASSIGNED_SEQ_NO && ifPrimaryTerm == UNASSIGNED_PRIMARY_TERM)
                        segmentReader.getSegmentInfo()
     * Snapshots the most recent safe index commit from the engine.
            () -> new DefaultTranslogDeletionPolicy(
    public static class DeleteResult extends Result {
import org.opensearch.ExceptionsHelper;
                if (failure != null) inner.addSuppressed(failure);
        Segment segment = new Segment(info.info.name);
        }
        public long getIfSeqNo() {
        private final boolean found;
            numDeletedDocs += readerContext.reader().numDeletedDocs();
                commitRef.close();
     *
     */
    public Engine.Index prepareIndex(
    }
        private final boolean fromTranslog;
        }
                uid,
     *    tests when we open indices with lots of segments and suddenly merges kick in.
    /**
                                ),
        private final VersionType versionType;
     * settings by the time it is promoted.
                logger.warn(() -> new ParameterizedMessage("Error when closing compound reader on Directory [{}]", finalDirectory), e);
    protected TranslogDeletionPolicy getTranslogDeletionPolicy(EngineConfig engineConfig) {
            }
                searcher.getQueryCache(),
     * a lucene commit if nothing needs to be committed.
     *
        }
            super(Operation.TYPE.DELETE, version, term, seqNo);
                Origin.PRIMARY,
        @Override
        public ParsedDocument parsedDoc() {
                failEngine("failed to access searcher manager", e);
        }
    /**
        /** Append the currently pending chunk and return the greatest location appended by this scope so far. */
            this(failure, version, term, UNASSIGNED_SEQ_NO, false);
            public String getLowercase() {
    public final SearcherSupplier acquireSearcherSupplier(Function<Searcher, Searcher> wrapper) throws EngineException {
        return new Engine.Delete(id, uid, seqNo, primaryTerm, version, versionType, origin, startTime, ifSeqNo, ifPrimaryTerm, routing);
                        }
            try {
        }
     * by the uncaught exception handler that we install during bootstrap. If the specified throwable does indeed contain a fatal error,
     * Returns the number of merges currently in flight on this engine.
    }
        VersionType versionType,
            return this.version;
            this(id, uid, seqNo, primaryTerm, version, versionType, origin, startTime, ifSeqNo, ifPrimaryTerm, null);
            return ifSeqNo;
                try {
        long autoGeneratedIdTimestamp,
            return this.uid;
     **/
        long ifSeqNo,
        public enum TYPE {
         */
            releasable = null;
        public Delete(
        }
    @Nullable
     */
        public String reason() {
import org.opensearch.action.index.IndexRequest;
                    // clean all unreferenced files on best effort basis created during failed merge and reset the
     */
    }
    }
    /**
    }
        @Override
                ace.addSuppressed(suppressed);
    public abstract long getPersistedLocalCheckpoint();
import java.io.IOException;
            return lock.acquire();
            this.primaryTerm = primaryTerm;
        return new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(sizeInBytes).build();
            logger.debug("close now acquiring writeLock");
    public static final class Searcher extends IndexSearcher implements Releasable {
            } else {
                    get.getIfSeqNo(),
        public TYPE operationType() {
        public int estimatedSizeInBytes() {
        ensureOpen();
     *
            }
        } catch (IOException e) {
     * Global stats on segments.
        }
                return lowercase;
    public static class GetResult implements Releasable {
    public static class NoOp extends Operation {
        }
                fillSegmentStats(segmentReader, includeSegmentFileSizes, stats);
        }
import org.apache.lucene.index.DirectoryReader;
            try (ReleasableLock lock = writeLock.acquire()) {
    /**
        /**
        } else {
     * This class has been deprecated. See IndexingThrottler.java
     * @param origin the operation origin
                    try {
            public boolean isRecovery() {
            throw new UnsupportedOperationException("NoOpLock can't provide a condition");
                logger.trace("flushAndClose now acquired writeLock");
            try {
                    fillSegmentInfo(segmentReader, verbose, false, segments);
        @Override
    public long getMaxSeenAutoIdTimestamp() {
     * Called when our engine is using too much heap and should move buffered indexed/deleted documents to disk.
        }
        public Term uid() {
        public IndexResult(Mapping requiredMappingUpdate) {
            numDocs += readerContext.reader().numDocs();
        // to external refreshes. For instance we don't refresh an external searcher if we flush and indices with
     */
    ) throws IOException;
    public Engine.Delete prepareDelete(
                        logger.info("Cleaning up unreferenced files as merge failed due to: {}", reason);
        }
        }
                // to add a negative number
 * Modifications Copyright OpenSearch Contributors. See
            new Sort(new SortField(SeqNoFieldMapper.NAME, SortField.Type.LONG, true))
     * and then compares its MSU to its local checkpoint (LCP). If {@literal LCP < MSU} then there's a gap: there may be some operations
            if (freeze.get() == null) {
        public Get version(long version) {
     */
                commitRef.close();
import java.util.concurrent.locks.ReentrantReadWriteLock;
    public boolean hasPendingMerges() {
            assert lock != NOOP_LOCK : "throttling deactivated but not active";
                doc,
            // don't release the searcher on this path, it is the
import org.apache.lucene.index.SegmentReader;
                    }
    }
import org.opensearch.core.index.shard.ShardId;
        flush(false, false);
            ifPrimaryTerm
     */
import org.opensearch.index.seqno.SeqNoStats;
            return this;
        // safe here.
     * This method fetches the _id of last indexed document that was part of the given searcher and
                VersionType.INTERNAL,
     * Returns the {@link PrimaryOperationPolicy} in effect for this engine.
                    // on the same node that we don't see the corrupted marker file when
    /**
        return DefaultPrimaryOperationPolicy.INSTANCE;
        @Override
        VersionsAndSeqNoResolver.DocIdAndVersion docIdAndVersion = VersionsAndSeqNoResolver.loadDocIdAndVersion(
    public static class IndexResult extends Result {
        }
        } catch (RuntimeException e) {
                template.id(),
            boolean isRetry,
        long ifPrimaryTerm
     * @deprecated Use {@link #acquireSafeCatalogSnapshot()} which avoids the extra
            super(Operation.TYPE.DELETE, requiredMappingUpdate);
         * type of operation (index, delete), subclasses use static types
        }
    public abstract static class Operation {
        segment.docCount = segmentReader.numDocs();
     * @opensearch.api
        boolean useCompoundFile = segmentCommitInfo.info.getUseCompoundFile();
        if (docMapper.getMapping() != null) {
            return GetResult.NOT_EXISTS;
     * Reverses a previous {@link #activateThrottling} call.
        public boolean isRetry() {
            this.requiredMappingUpdate = null;
     * Invoked by the publisher when the condition is turned off, since a value published while it was on would
                    } catch (IOException e) {
            startTime,
            long primaryTerm,
        // default implementation
     */
            QueryCachingPolicy queryCachingPolicy,
    public abstract void activateThrottling();
                Segment segment = segments.get(info.info.name);
            try {
            Origin origin,
        }
     * operations on the shard are blocked. The default implementation does nothing, which is correct for
        public long version() {
        public VersionType versionType() {
    }
            }
    }
            Releasables.closeWhileHandlingException(searcher);
            } catch (IOException closeEx) {
     */
        } // TEST ONLY
            return TYPE.INDEX;
        public Get setIfPrimaryTerm(long primaryTerm) {
            autoGeneratedIdTimestamp,
    protected final ReleasableLock readLock = new ReleasableLock(rwl.readLock());
            this.realtime = realtime;
        Index(Term uid, long primaryTerm, ParsedDocument doc, long version) {
    }
        SegmentCommitInfo segmentCommitInfo = segmentReader.getSegmentInfo();
    protected final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        try (Searcher searcher = acquireSearcher("segments_stats", SearcherScope.INTERNAL)) {
         **/
    public final Searcher acquireSearcher(String source) throws EngineException {
    }
     * changes unless another thread is already refreshing the engine concurrently.
            return 2 * reason.length() + 2 * Long.BYTES;
        /** whether the operation was successful, has failed or was aborted due to a mapping update */
        public DocIdAndVersion docIdAndVersion() {
        }
        public Index(
    }
                    } catch (AlreadyClosedException e) {
        public TYPE operationType() {
    }
                e.addSuppressed(closeEx);
        // TODO: add more fine grained mem stats values to per segment info here
        awaitPendingClose();
        if (useCompoundFile) {
                Releasables.close(searcher);
    // NOTE: do NOT rename this to something containing flush or refresh!
     * Returns the timestamp of the last write in nanoseconds.
         */
            } else {
        }
                // Paranoia (System.nanoTime() is supposed to be monotonic): time slip may have occurred but never want
    /**
                return Map.of();
        }
     * Must be matched by a later call to {@link #deactivateThrottling()}.
            this.created = false;
     */
    }
         * multiple times. Note: this might also be set to true if an equivalent event occurred like the replay of the transaction log
    public TranslogBatch beginTranslogBatch() {
     */
        INTERNAL
     */
        ) {
            super(Operation.TYPE.NO_OP, failure, 0, term, seqNo);
    /**
                        if (store.tryIncRef()) {
            throw new EngineException(shardId, "failed to acquire reader", ex);
            this.term = UNASSIGNED_PRIMARY_TERM;
     */
        boolean throttleLockIsHeldByCurrentThread() { // to be used in assertions and tests only
import org.apache.logging.log4j.message.ParameterizedMessage;
     * {@link SegmentInfosCatalogSnapshot}; engines with a native catalog should override
         */
            uidTerm,
            startOfThrottleNS = System.nanoTime();
        Engine.Operation.Origin origin,
     *
     * Flush the engine (committing segments to disk and truncating the
            this(
        }
    /**
     *
     * Also see {@link #getPersistedLocalCheckpoint()}
     */
        private final long version;
        }
                                logger.warn("Couldn't mark store corrupted", e);
        long version,
     * Created by {@link #beginTranslogBatch()}.
        }
                    e
import java.nio.file.NoSuchFileException;
        }
         * Type of the result
            this.isRetry = isRetry;
         * @return the sequence number
        return (reason.equals(FORCE_MERGE) || reason.equals(MERGE_FAILED))
        /** Append the final pending chunk, close this scope, and return its greatest translog location. */
                if (segments.containsKey(segmentReader.getSegmentName()) == false) {
                }
            final CatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(infos);
        } catch (Exception ex) {
    /**
    ) throws EngineException {
        private final String source;
            }
                    currentThrottleNS = 0;
        public IndexResult(Exception failure, long version, long term, long seqNo) {
    /**
     * @param maybeMessage the message to maybe log
        }
            return id().length() * 2 + source().length() + 12;
            this.failure = null;
import org.opensearch.index.merge.MergedSegmentTransferTracker;
 * SPDX-License-Identifier: Apache-2.0
     *
                        "Couldn't list Directory from SegmentReader [{}] and SegmentInfo [{}]",
        }
        public DeleteResult(Mapping requiredMappingUpdate) {
    public static final String FORCE_MERGE = "force merge";
                            } finally {
import org.opensearch.index.seqno.SequenceNumbers;
     * This operation is not going to block if another flush operation is currently running and won't write
     * @opensearch.api
     * @return Stats for pull-based ingestion.
        assert segments.containsKey(info.info.name) == false;
        try {
        public boolean tryLock() {
                        throw new UncheckedIOException("failed to close", e);
                    try {
                );
                Releasables.close(searcher);
     */
     * @param source the source to parse
    /**
            }
            setQueryCache(queryCache);
import org.opensearch.index.merge.MergeStats;
    public static final String SEARCH_SOURCE = "search"; // TODO: Make source of search enum?
import org.opensearch.index.mapper.ParseContext.Document;
     */
        if (engineConfig.getCustomTranslogDeletionPolicyFactory() != null) {
            );
    public abstract void writeIndexingBuffer() throws EngineException;
            // TODO: A better exception goes here
        return new GatedCloseable<>(getLatestSegmentInfos(), () -> {});
     */
    public static final TranslogBatch NO_OP_TRANSLOG_BATCH = () -> null;
        }
import org.apache.logging.log4j.Logger;
            iwc.setParentField(Lucene.PARENT_FIELD);
            assert (origin == Origin.PRIMARY) == (versionType != null) : "invalid version_type=" + versionType + " for origin=" + origin;
        } // TEST ONLY
            return this.origin;
                    } catch (AlreadyClosedException ex) {
     * However, if {@literal MSU <= LCP} then there is no gap: we have processed every {@literal operation <= LCP}, and no operation O'
            totalUnreferencedFileCleanUpsPerformed.inc();
            Term uid,
    @PublicApi(since = "1.0.0")
                final Directory finalDirectory = directory;
                            );
        }
        return engineConfig;
            && ExceptionsHelper.unwrap(failure, IOException.class) instanceof IOException;
     * {@literal seqno(O') > LCP >= MSU >= MSU(O)} which contradicts the first invariant. Furthermore in this case we immediately know
                }
            this(
     * Get max sequence number that is part of given searcher. Sequence number is part of each document that is indexed.
                logger.debug("close acquired writeLock");
        protected Result(Operation.TYPE operationType, long version, long term, long seqNo) {
        private final boolean created;
    /**
            docIdAndVersion = VersionsAndSeqNoResolver.loadDocIdAndVersion(searcher.getIndexReader(), get.uid(), true, null);
        private final long seqNo;
    @PublicApi(since = "1.0.0")
                template.seqNo(),
    protected final EventListener eventListener;
                }
        segment.version = info.info.getVersion();
            for (LeafReaderContext ctx : searcher.getIndexReader().getContext().leaves()) {
    public abstract long getMaxSeqNoOfUpdatesOrDeletes();
            if (released.compareAndSet(false, true)) {
            SearcherSupplier reader = releasable = acquireSearcherSupplier(wrapper, scope);
        }
                0
                return directoryReader;
            throw new IllegalStateException(
import org.opensearch.core.common.bytes.BytesReference;
 * this work for additional information regarding copyright
     * Base class for index and delete operation results
                    ),
                        failure
            return new Searcher(
                ),
                    segment.docCount = info.info.maxDoc() - segment.delDocCount;
            throw ex;
    private void maybeDie(final String maybeMessage, final Throwable maybeFatal) {
        }
                throw new VersionConflictEngineException(
    /**
     */
    public abstract long getMinRetainedSeqNo();
                    segment.delDocCount = info.getDelCount() + info.getSoftDelCount();
import org.opensearch.common.lucene.search.Queries;
     * Discards any previously published uncommitted segment bytes accounting, so that it can no longer trigger a flush.
    }
                    get.versionType().explainConflictForReads(docIdAndVersion.version, get.version())
     * @return the latest checkpoint that has been processed but not necessarily persisted.
     * {@link InternalEngine}'s {@code OpenSearchConcurrentMergeScheduler}) override.
            @Nullable String routing
        public GetResult(Engine.Searcher searcher, DocIdAndVersion docIdAndVersion, boolean fromTranslog) {
import org.apache.lucene.search.similarities.Similarity;
            return false;
        SearcherSupplier releasable = null;
        public boolean realtime() {
    /**
            this.ifPrimaryTerm = primaryTerm;
        }
        private final Engine.Searcher searcher;
                    logger.warn(() -> new ParameterizedMessage("failed engine [{}]", reason), failure);
        }
    public static class NoOpResult extends Result {
            if (isThrottled() && startOfThrottleNS != 0) {
    public abstract int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException;
     * 1. The first invariant above tells us that {@literal seqno(O') <= MSU(O) <= LCP} so we have already applied O' to Lucene.
            return true;
        /**
            return id;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                files = directory.listAll();
     */
                    );
        }
    }
            } catch (Exception inner) {
                    () -> new ParameterizedMessage(
     *
                throw new IllegalStateException("result is already frozen");
        public void freeze() {
            return failure;
        ExceptionsHelper.maybeError(maybeFatal).ifPresent(error -> {
            return source;
        public Exception getFailure() {
                throttleTimeMillisMetric.inc(TimeValue.nsecToMSec(throttleTimeNS));
    private void cleanUpUnreferencedFiles() {
    /**
     * If the specified throwable contains a fatal error in the throwable graph, such a fatal error will be thrown. Callers should ensure
    public abstract void flush(boolean force, boolean waitIfOngoing) throws EngineException;
    public static final String CAN_MATCH_SEARCH_SOURCE = "can_match";
        }
 * software distributed under the License is distributed on an
            this.failure = null;
    }
        }
                segmentName.add(segmentReader.getSegmentName());
     *     <li> I1: There is no operation on docID(O) with seqno that is {@literal > MSU(O) and < seqno(O)} </li>
    /**
    protected final GetResult getFromSearcher(
     * Note: engine level failures (i.e. persistent engine failures) are thrown
            this.exists = exists;
                }
    /**
            } catch (IOException e) {
        private long took;
            this.term = term;
    }
                        engineConfig.getQueryCache(),
        }
 * compatible open source license.
                    segment.compound = info.info.getUseCompoundFile();
                        segmentCommitInfo
     * @param index operation to perform
        long numDeletedDocs = 0;
            Searcher searcher = reader.acquireSearcher(source);
        try {
     * Must decrement the supplied when closing work is done and resources are
        /** get document failure while executing the operation {@code null} in case of no failure */
     *                      Otherwise this call will return without blocking.
         */
        }
            .setCommitOnClose(false)
    }
              the store is closed so we need to make sure we increment it here
            this.origin = origin;
            this.operationType = operationType;
        ensureOpen(null);
     * {@link #updateUncommittedSegmentBytes(Map, long)}.
            this.seqNo = seqNo;
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {
            DELETE,
     * @opensearch.internal
        return acquireSearcher(source, scope, Function.identity());
        public long getAutoGeneratedIdTimestamp() {
        long ifPrimaryTerm
    protected final ShardId shardId;
     * 2. Also {@literal MSU(O) <= MSU <= LCP < seqno(O)} (we discard O if {@literal seqno(O) <= LCP}) so the second invariant applies,
            }
        private final Exception failure;
     * or the auto_id_timestamp received from its primary shard via {@link #updateMaxUnsafeAutoIdTimestamp(long)}.
            }
                UNASSIGNED_SEQ_NO,
                : "cas operations are only allowed if origin is primary. get [" + origin + "]";
            VersionType versionType,
     * refreshed. Used by replication-checkpoint listeners and any caller that wants the live
        return true;
     * In contrast to {@link #getLatestSegmentInfos()}, which returns a {@link SegmentInfos}
        return segmentsArr;
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
     */
                    segment.attributes = info.info.getAttributes();
    ) {
        /**
     * Returns the maximum auto_id_timestamp of all append-only index requests have been processed by this engine
     */
            return this.versionType;
            return exists;
        @Override
    /**
        public String routing() {
    }
            return translogLocation;
 * Licensed to Elasticsearch under one or more contributor
         * the searcher is acquired. */
        }
                        throw new AssertionError(e);
                : "cas operations are only allowed if origin is primary. get [" + origin + "]";
    /**
        private final boolean realtime;
        return false;
                                    reason
import org.opensearch.common.lucene.uid.Versions;
            super(Operation.TYPE.INDEX, failure, version, term, seqNo);
     */
     *    meaning that the O' was a delete.
    }
        public long version() {
     * is enabled.
        @Override
        }
            return true;
 * under the License.
    }
        EXTERNAL,
            for (SegmentCommitInfo info : lastCommittedSegmentInfos) {
                    // If cleanup of unreferenced flag is enabled and force merge or regular merge failed due to IOException,
            } catch (IOException e) {
                System.nanoTime(),
        } catch (Exception ex) {
            try {
            }
            doc.addDynamicMappingsUpdate(docMapper.getMapping());
    /**
            if (released.get()) {
              we need to inc the store here since we acquire a searcher and that might keep a file open on the
     * <p>The default implementation bridges via {@link #getSegmentInfosSnapshot()} and wraps the
        try (Searcher searcher = acquireSearcher("segments", SearcherScope.EXTERNAL)) {
                    + "] on index shard "
        }
        String id,
    /**
         * use in case of the delete operation failed before getting to internal engine
                    // this must happen first otherwise we might try to reallocate so quickly
        private final long ifSeqNo;
        private final long version;
     *
     *
        SourceToParse source,
    }
        } catch (Exception e) {
        }
                // don't bubble up these exceptions up
     * @opensearch.api
            seqNo,
     * The underlying store is marked corrupted iff failure is caused by index corruption
     * search-visible state rather than the on-disk safe commit.
            }
    public abstract long getLastSyncedGlobalCheckpoint();
            try {
 * ownership. Elasticsearch licenses this file to you under
        return engineConfig.getMergedSegmentTransferTracker();
        }
            long seqNo,
        private final Result.Type resultType;
        }
        }
            return this.startTime;
    public long getMaxSeqNoFromSegmentInfos(SegmentInfos segmentInfos) throws IOException {
     * @param version the version
    /**
    /**
            long length = 0L;
    }
     * concurrent add/flush activity. If an append fails, all affected requests must fail with the exception the
        @Override
     * @param flushFirst indicates whether the engine should flush before returning the snapshot
        }
     * @opensearch.api
        } catch (InterruptedException e) {
        BiFunction<String, SearcherScope, Engine.Searcher> searcherFactory,
        TranslogDeletionPolicy customTranslogDeletionPolicy = null;
     * Acquires a lock on the translog files and Lucene soft-deleted documents to prevent them from being trimmed
                return Map.of();
                }
     *
 */
    protected abstract void closeNoLock(String reason, CountDownLatch closedLatch);
     * lucene index to make sure we have a "fresh" copy of the files to snapshot.
 * Base OpenSearch Engine class
    protected String loadHistoryUUID(Map<String, String> commitData) {
    /**
        private volatile long startOfThrottleNS;
     * Returns {@code true} if the underlying merge scheduler has merges queued but not yet started.
import org.opensearch.common.annotation.ExperimentalApi;
            Term uid,
        }
     * @opensearch.api
            );
            }
                    return new Searcher(
                onClose.close();
            INDEX,
        long numDocs = 0;
            } finally {
    ) throws EngineException, IOException;
        if (useCompoundFile) {
        public int estimatedSizeInBytes() {
        public long getIfPrimaryTerm() {
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
        assert directory != null;
                throw new AlreadyClosedException("SearcherSupplier was closed");
        public Term uid() {
     * The engine searcher
         */
        ) {
    public GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException, IOException {
     *
        private final long seqNo;
        /** Deactivate throttling, which switches the lock to be an always-acquirable NoOpLock */
            final IndexSearcher searcher = new IndexSearcher(innerReader);
                    assert assertSearcherIsWarmedUp(source, scope);
    public abstract Closeable acquireHistoryRetentionLock();
     * @param primaryTerm the shards primary term this engine was created for
        }
     * seqno(O') and this means {@literal MSU >= seqNo(O') > seqNo(O) > LCP} (because O wasn't processed yet).
    public abstract TranslogManager translogManager();
     * @param delete operation to perform
     *
         * @opensearch.api
        boolean accurateCount
import org.opensearch.common.lucene.Lucene;
    public abstract CompletionStats completionStats(String... fieldNamePatterns);
            maybeFailEngine("acquire_reader", ex);
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
        boolean upgrade,
        return false;
            origin,
        public long version() {
            return this;
import java.util.Set;
    boolean assertSearcherIsWarmedUp(String source, SearcherScope scope) {
            try {
        writerSegmentStats(stats);
            // remove all unreferenced files
            this.fromTranslog = fromTranslog;
     *
     * documents in the lucene index to disk including a potentially heavy and durable fsync operation.
     * Performs the pre-closing checks on the {@link Engine}.
        private final long primaryTerm;
import org.apache.lucene.search.QueryCachingPolicy;
                final Directory finalDirectory = directory;
            this.version = version;
        public enum Origin {
            this.requiredMappingUpdate = requiredMappingUpdate;
    public abstract long getWritingBytes();
            return getMaxSeqNoFromSearcher(searcher);
                        engineConfig.getQueryCachingPolicy(),
                    fillSegmentStats(segmentReader, includeSegmentFileSizes, stats);
     * @return a summary of the contents of the current safe commit
            this.version = version;
        /**
        // first, go over and compute the search ones...
    protected final Store store;
    public abstract IndexResult index(Index index) throws IOException;
                .create(engineConfig.getIndexSettings(), engineConfig.retentionLeasesSupplier());
     */
            searcher.getIndexReader(),
        return new CommitStats(getLastCommittedSegmentInfos());
    @PublicApi(since = "1.0.0")
                    + shardId
    /**
            return this.searcher;
                            }
                @Override
        }
        public Term uid() {
            for (LeafReaderContext ctx : searcher.getIndexReader().getContext().leaves()) {
         * @opensearch.api
        long seqNo,
     * @opensearch.api
     */
    }
            super(Operation.TYPE.INDEX, version, term, seqNo);
            throw new AlreadyClosedException(shardId + " store is closed", failedEngine.get());
        ParsedDocument doc = docMapper.getDocumentMapper().parse(source);
        final long maxSeqNo = getSeqNoStats(globalCheckpoint).getMaxSeqNo();
        }
                        () -> {}
import org.apache.lucene.search.Sort;
    }
            return this.id;
        }
                }
     */
     */
     *
            VersionType versionType,
        private final long autoGeneratedIdTimestamp;
            PEER_RECOVERY,
                0,
        public long primaryTerm() {
    }
            return true;
                this.translogLocation = translogLocation;
    @PublicApi(since = "1.0.0")
        @Override
    public static final String FORCE_MERGE_UUID_KEY = "force_merge_uuid";
            if (get.versionType().isVersionConflictForReads(docIdAndVersion.version, get.version())) {
 */
     * otherwise stay armed until the next commit invalidates it. The default is a no-op, mirroring
    }
        }
    }
        @Override
     * remote-specific -- only the publisher (the remote segment upload path) is. The default is a no-op so that
import org.apache.lucene.store.AlreadyClosedException;
                UNASSIGNED_SEQ_NO,
        }
                primaryTerm,
            versionType,
        long sizeInBytes = 0;
        private final boolean isRetry;
        SearcherScope scope
     *
            assert (origin == Origin.PRIMARY) == (versionType != null) : "invalid version_type=" + versionType + " for origin=" + origin;
     */
        // now, correlate or add the committed ones...
    public static final String SYNC_COMMIT_ID = "sync_id";  // TODO: remove sync_id in 3.0
import org.opensearch.index.mapper.SourceToParse;
     * @return <code>true</code> if the a refresh happened. Otherwise <code>false</code>
        }
     * @return the prepared delete operation
            long version,
                null
    /**
        final GatedCloseable<IndexCommit> commitRef = acquireSafeIndexCommit();
        }
        final String uuid = commitData.get(HISTORY_UUID_KEY);
     * error, this method is a no-op.
import org.opensearch.common.SetOnce;
                }
     * is the publisher's concern: it owns both the index setting and the cluster setting it falls back to.
        if (store.tryIncRef() == false) {
     * Synchronously refreshes the engine for new search operations to reflect the latest
                    return searcher.getDirectoryReader().isCurrent() == false;
        }
    public long unreferencedFileCleanUpsPerformed() {
                UNASSIGNED_SEQ_NO,
        /**
    /** Returns how many bytes we are currently moving from heap to disk */
     * indices) can treat read failures uniformly with the legacy commit path.
    /** Check whether the engine should be failed */
            this(
    @PublicApi(since = "1.0.0")
        segment.search = search;
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * KIND, either express or implied.  See the License for the
        }
    public static class Index extends Operation {
        @Override
            }
     * <p>
                    e
     * Returns the number of milliseconds this engine was under index throttling.
        public Mapping getRequiredMappingUpdate() {
    }
        // when indexing but not refreshing in general. Yet, if a refresh happens the internal searcher is refresh as well so we are
            this.operationType = operationType;
            return TYPE.NO_OP;
            ifSeqNo,
                searcher.getQueryCachingPolicy(),
    protected final SetOnce<Exception> failedEngine = new SetOnce<>();
                            logger.warn(
            return docIdAndVersion;
                return this == LOCAL_TRANSLOG_RECOVERY || this == LOCAL_RESET;
    /**
    /**
    public abstract boolean isThrottled();
    protected final AtomicBoolean isClosed = new AtomicBoolean(false);
        public Engine.Searcher searcher() {
                    "tried to fail engine but could not acquire lock - engine should " + "be failed by now [{}]",
                                    new IOException("failed engine (reason: [" + reason + "])", ExceptionsHelper.unwrapCorruption(failure))
import org.apache.lucene.search.QueryCache;
            return version;
                    }
     * procedure is a no-op.
     * Re-reads the {@link PrimaryOperationPolicy} from {@link EngineConfig#getPrimaryOperationPolicy()},
    /**
        long seqNo,
     * The engine will disable optimization for all append-only whose timestamp at most {@code newTimestamp}.
            return this.version;
        }
     * Snapshots the most recent index and returns a handle to it. If needed will try and "commit" the
                logger.warn("failEngine threw exception", inner);
            }
        /**
                    try {
                    segment.committed = true;
    }
    }
     *
        } catch (IOException e) {
        }
        Term uidTerm = new Term(IdFieldMapper.NAME, document.getField(IdFieldMapper.NAME).binaryValue());
 * license agreements. See the NOTICE file distributed with
            this.created = false;
                logger.warn(() -> new ParameterizedMessage("Couldn't list Compound Reader Directory [{}]", finalDirectory), e);
        }
     */
    public final EngineConfig config() {
        public VersionType versionType() {
        } else {
        try (Searcher searcher = acquireSearcher("segments", SearcherScope.INTERNAL)) {
            TYPE() {
    protected final DocsStats docsStats(IndexReader indexReader) {
     * @opensearch.api
     * Triggers a forced merge on this engine
    /**
            if (getIndexReader() instanceof DirectoryReader directoryReader) {
            }
    /**
                length = directory.fileLength(file);
    private Map<String, Long> getSegmentFileSizes(SegmentReader segmentReader) {
            Releasables.close(searcher);
            this.version = version;
            long seqNo,
        public String source() {
import java.util.HashSet;
            return reader;
    protected final void ensureOpen(Exception suppressed) {
     * <ol>
         *
    /** How much heap is used that would be freed by a refresh.  Note that this may throw {@link AlreadyClosedException}. */
    private final CounterMetric totalUnreferencedFileCleanUpsPerformed = new CounterMetric();
    /**
    /**
            this.routing = routing;
            this.uid = uid;
            return reason;
            }
        }
    }
        long version,
        long ifSeqNo,
        public Operation.TYPE getOperationType() {
            null
    protected static final class IndexThrottle {
            if (length == 0L || extension == null) {
            LOCAL_TRANSLOG_RECOVERY,
        public Searcher(
            return created;
     */
                files = segmentReader.getSegmentInfo().files().toArray(new String[] {});
                final Directory finalDirectory = directory;
    /**
             */
     * @opensearch.api
     * slightly inaccurate.
        }
    private boolean isMergeFailureDueToIOException(Exception failure, String reason) {
            } catch (IOException closeEx) {
            return new GetResult(searcher, docIdAndVersion, false);
                        "Error when opening compound reader for Directory [{}] and " + "SegmentCommitInfo [{}]",
        public void setTook(long took) {
                throw new AssertionError(e);
        final GatedCloseable<SegmentInfos> segmentInfosRef = getSegmentInfosSnapshot();
     * When a receiving shard (either a replica or a follower) receives an operation O, it must first ensure its own MSU at least MSU(O),
         */
        private final String id;
    }
                uid,
            long primaryTerm,
        /** Activate throttling, which switches the lock to be a real lock */
     * @param ifPrimaryTerm the ifPrimaryTerm
        IndexWriterConfig iwc = new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
    final Segment[] getSegmentInfo(SegmentInfos lastCommittedSegmentInfos, boolean verbose) {
                    + "] mismatches maximum sequence number ["
        // by default we don't have a writer here... subclasses can override this
            customTranslogDeletionPolicy = engineConfig.getCustomTranslogDeletionPolicyFactory()
import org.opensearch.index.translog.TranslogDeletionPolicy;
     * A throttling class that can be activated, causing the
            } catch (IOException e) {
            try {
    }
        return new GatedCloseable<>(snapshot, segmentInfosRef::close);
     * noop operation
            super(reader);
     * post-refresh local segment file sizes. Engine-generic: the notion of "bytes since the last commit" is not
     * Returns the latest global checkpoint value that has been persisted in the underlying storage (i.e. translog's checkpoint)
                throw error;
    public Searcher acquireSearcher(String source, SearcherScope scope) throws EngineException {
            };
        public Delete(String id, Term uid, long primaryTerm) {
            final SegmentInfos infos = Lucene.readSegmentInfos(commitRef.get());
        }
        private final Origin origin;
     */
    public PollingIngestStats pollingIngestStats() {
                logger.warn(
import org.apache.lucene.index.StandardDirectoryReader;
        return this.lastWriteNanos;
        public void lock() {}
            long ifPrimaryTerm
            } catch (IOException e) {
                template.startTime(),
        private final Term uid;
                if (segment == null) {
    @PublicApi(since = "1.0.0")
     * @return the persisted local checkpoint for this Engine
     * @param versionType the version type
     * @return             number of history operations
import java.util.List;
import org.opensearch.common.logging.Loggers;
        }
import org.apache.lucene.index.IndexReader;
    }
@PublicApi(since = "1.0.0")
        final long globalCheckpoint = engineConfig.getGlobalCheckpointSupplier().getAsLong();
        @Override
    public static final String MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID = "max_unsafe_auto_id_timestamp";
     * document specific failures
     * @opensearch.api
        }
    /**
     * <p>
     * @opensearch.api
        if (isClosed.get()) {
                        // This means there's a bug somewhere: don't suppress it
                    // shard state back to last Lucene Commit.
        }
import org.opensearch.common.annotation.PublicApi;
     * in Lucene. To avoid this we check the local checkpoint tracker to see if an operation was already processed.
     *  - we use the value for figuring out if the shard / engine is active so if we startup and no write has happened yet we still
import org.opensearch.common.metrics.CounterMetric;
            return ifSeqNo;
import org.opensearch.common.concurrent.GatedCloseable;
    public abstract GetResult get(Get get, BiFunction<String, SearcherScope, Searcher> searcherFactory) throws EngineException;
         * Returns a positive timestamp if the ID of this document is auto-generated by opensearch.
        boolean onlyExpungeDeletes,
        private final long ifPrimaryTerm;
        }
     * @return {@link IndexResult} containing updated translog location, version and
    public abstract static class Result {
    boolean shouldCleanupUnreferencedFiles() {
                template.routing()
        public final void close() {
                logger.error(maybeMessage, error);
     *             {@code segments_N} disk read required to materialize an {@link IndexCommit}.
            }
            // responsibility of the caller to call GetResult.release
     * regardless of retention policy. Default wraps {@link #acquireLastIndexCommit(boolean)}.
    public abstract long getProcessedLocalCheckpoint();
            // TODO: consider moving this to StoreStats
     * @param isRetry whether this is a retry
        }
import org.apache.lucene.store.Directory;
        try {
import org.opensearch.common.lease.Releasables;
     * @param fromSeqNo    from sequence number; included
    /**
            isRetry,
        }
        }
        }
                }
        /** get the updated document version */
        stats.addVersionMapMemoryInBytes(0);
    public GatedCloseable<SegmentInfos> getSegmentInfosSnapshot() {
     * translog failure: it fails only if the exception is the translog's own tragic event.
     * <p>
                        segmentReader,
        /**
    /**
    public long getLastWriteNanos() {
    public abstract Translog.Snapshot newChangesSnapshot(
    public abstract void updateMaxUnsafeAutoIdTimestamp(long newTimestamp);
            ensureOpen(ex); // throw EngineCloseException here if we are already closed
    public MergeStats getMergeStats() {
                    e
     * @opensearch.api
     * @param id the document id
     * construction; {@link InternalEngine} overrides it to drive its uncommitted-segment-bytes flush condition.
        public boolean isCreated() {
    public abstract long getIndexThrottleTimeInMillis();
    }
            long currentThrottleNS = 0;
     * per-operation translog path would have thrown, and the engine is consulted exactly as for a per-operation
    /**
            logger.trace(() -> new ParameterizedMessage("failed to get size for [{}]", info.info.name), e);
     */
        default Translog.Location finish() {
        }
    protected long getMaxSeqNoFromSearcher(IndexSearcher searcher) throws IOException {
     * @param seqNo the sequence number
        return Objects.requireNonNullElseGet(
        }
     * Scope of the searcher
     *    either immediately or never mark it inactive if no writes at all happen to the shard.
                                    "tried to mark store as corrupted but store is already closed. [{}]",
     * Base operation class
            this.version = version;
     * Returns the <code>true</code> iff this engine is currently under index throttling.
            ReferenceManager<OpenSearchDirectoryReader> referenceManager = getReferenceManager(scope);
        public Get versionType(VersionType versionType) {
            }
    @ExperimentalApi
            throw new UnsupportedOperationException();
     * The Get result
            }
            if (freeze.get() == null) {
     * @param docMapper the document mapper instance
        private long version = Versions.MATCH_ANY;
            this.onClose = onClose;
        this.eventListener = engineConfig.getEventListener();
     */
        private final boolean readFromTranslog;
import org.apache.lucene.search.SortField;
            long autoGeneratedIdTimestamp,
     *
import org.opensearch.index.mapper.SeqNoFieldMapper;
     */
                    // we must set a failure exception, generate one if not supplied
            private final String lowercase;
        this.store = engineConfig.getStore();
            } else {
     * operation on docID(O) then this is clear, so suppose instead that the preceding operation on docID(O) is O':
import org.apache.lucene.index.Term;
            this.versionType = versionType;
            }
        try {
        @Override
        return totalUnreferencedFileCleanUpsPerformed.count();
            this.doc = doc;
        public Delete(
         */
     * Index operation
        }
        /**
     *
            }
        }
        }
        }
            long ifPrimaryTerm
        try {
    }
                    docIdAndVersion.seqNo,
            throw e;
            this.reason = reason;
        public long getSeqNo() {
     * @param flushThresholdBytes  the uncommitted segment bytes at or above which the engine should flush, as resolved
     * Returns the {@link DocsStats} for this engine
 * You may obtain a copy of the License at
            }
    /**
            return requiredMappingUpdate;
         *
                commitRef.close();
        VersionType versionType,
        }
        Arrays.sort(segmentsArr, Comparator.comparingLong(Segment::getGeneration));
            }
     * Index result
    /**
            return this.realtime;
        }
        @PublicApi(since = "1.0.0")
     * wraps {@link #acquireSafeIndexCommit()} and parses its {@link SegmentInfos} into a
import java.util.HashMap;
        stats.addIndexWriterMemoryInBytes(0);
        }
    protected abstract SegmentInfos getLatestSegmentInfos();
     */
     */
import org.opensearch.index.mapper.Uid;
                id,
                        store.decRef();
        private final String id;
                    ),
    @Override
            }
     * @see System#nanoTime()
            try {
            // do nothing except increasing metric count and close this will kick off IndexFileDeleter which will
     */
     * so a shard that is becoming a primary uses the policy its plugin resolves from the index settings
        /** get the translog location after executing the operation */
        default void onFailedEngine(String reason, @Nullable Exception e) {}
     * Acquires a {@link CatalogSnapshot} of the engine's current in-memory state — i.e. the
     */
    }
    @Deprecated
        @PublicApi(since = "1.0.0")
     * resulting {@link SegmentInfos} as a {@link SegmentInfosCatalogSnapshot}. Engines whose
     * Event listener for the engine
    /**
     * @opensearch.api
                doClose();
     * @param ifPrimaryTerm the ifPrimaryTerm
        public Get(boolean realtime, boolean readFromTranslog, String id, Term uid) {
            long ifSeqNo,
            this.readFromTranslog = readFromTranslog;
            .setOpenMode(IndexWriterConfig.OpenMode.APPEND);
        }
        if (uuid == null) {
            return ifPrimaryTerm;
 *
        boolean isRetry,
            }
                    eventListener.onFailedEngine(reason, failure);
     */
            NO_OP;
    }
            Similarity similarity,
        }
         * If the operation was aborted due to missing mappings, this method will return the mappings
    /**
            return this.doc;
        private final DocIdAndVersion docIdAndVersion;
            }
                    // the shard is initializing
     * Delete operation
     * @see EngineConfig#getWarmer()
    public abstract static class SearcherSupplier implements Releasable {
        private GetResult(boolean exists, long version, DocIdAndVersion docIdAndVersion, Engine.Searcher searcher, boolean fromTranslog) {
            }
     *
     * This allows the engine to include a clean-up {@link org.opensearch.common.CheckedRunnable}
                if (segmentName.contains(segmentReader.getSegmentName()) == false) {
     *
                );
        }
        public long seqNo() {
    public abstract List<Segment> segments(boolean verbose);
     */
    /**
            } finally {
     * freed.
        public boolean isReadFromTranslog() {
        org.apache.lucene.document.Document document = searcher.storedFields().document(docs[0].doc);
     */
     * Flushes the state of the engine including the transaction log, clearing memory.
                        segmentReader.directory(),
         * @opensearch.api
                failure
            this.ifPrimaryTerm = ifPrimaryTerm;
    @PublicApi(since = "3.0.0")
            return took;
        }
            return this.doc.docs();
     * A Lock implementation that always allows the lock to be acquired
        }
    /**
        }
            long seqNo,
    protected void awaitPendingClose() {
        private final @Nullable String routing;
        for (String file : files) {
     */
        long primaryTerm,
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver;
        Engine.Operation.Origin origin,
                directory.close();
            this.version = Versions.NOT_FOUND;
     * Creates a new history snapshot from Lucene for reading operations whose seqno in the requesting seqno range (both inclusive).
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {
            );
    }
    @Nullable
    protected volatile long lastWriteNanos = System.nanoTime();
            throw new UnsupportedOperationException();
         */
        String[] files;
                continue;
     * @see #advanceMaxSeqNoOfUpdatesOrDeletes(long)
            return versionType;
            primaryTerm,
    /**
     * For each operation O, the key invariants are:
                template.primaryTerm(),
     * that there are no catch statements that would catch an error in the stack as the fatal error here should go uncaught and be handled
 *    http://www.apache.org/licenses/LICENSE-2.0
        // index.refresh_interval=-1 won't see any doc stats updates at all. This change will give more accurate statistics
    public abstract void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary);
                    segment = new Segment(info.info.name);
        }
        DocumentMapperForType docMapper,
        }
        }
import java.util.concurrent.CountDownLatch;
            final Searcher searcher = acquireSearcherInternal(source);
    }
            true,
                                failure
            assert lock == NOOP_LOCK : "throttling activated while already active";
     * @opensearch.api
     *              with {@literal seqno(O') < seqno(O) and docID(O') = docID(O)} then the one with the greatest seqno is a delete.</li>
            long startTime,
        String source,
            super(uid, seqNo, primaryTerm, version, versionType, origin, startTime);
     * Called for each new opened engine reader to warm new segments
     * Acquires a point-in-time reader that can be used to create {@link Engine.Searcher}s on demand.
    /**
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {
     * with {@literal seqno(O') > LCP and seqno(O') < seqno(O) also has docID(O') = docID(O)}, because such an operation would have
        return engineConfig.getIndexSettings().shouldCleanupUnreferencedFiles();
    /** get commits stats for the last commit */
    protected static final class NoOpLock implements Lock {
            return new GatedCloseable<>(snapshot, commitRef::close);
                    + maxSeqNo
                logger.trace(() -> new ParameterizedMessage("failed to get size for [{}]", info.info.name), e);
     */
     * Forces this engine to advance its max_unsafe_auto_id_timestamp marker to at least the given timestamp.
     *                             by the publisher at the time of this publication
     * @see Operation#startTime()
                    if (Lucene.isCorruptionException(failure)) {
    @PublicApi(since = "1.0.0")
            LOCAL_RESET;
        /**
     *
         * use in case of the index operation failed before getting to internal engine
    protected final ReleasableLock writeLock = new ReleasableLock(rwl.writeLock());
         **/
        long ifPrimaryTerm
        String forceMergeUUID
     */
            String id,
                    return;
        if (failEngineLock.tryLock()) {
        }
     */
     * Get max sequence number from segments that are referenced by given SegmentInfos
                SegmentReader segmentReader = Lucene.segmentReader(ctx.reader());
         * that are required to complete the operation.
        public DirectoryReader getDirectoryReader() {
            );
     *
        stats.add(1);
        private final Closeable onClose;
            this(true, docIdAndVersion.version, docIdAndVersion, searcher, fromTranslog);
     */
