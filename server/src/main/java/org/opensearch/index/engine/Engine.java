     * Counts the number of history operations in the given sequence number range
        public long version() {  
        if (globalCheckpoint != maxSeqNo) {
     */  
    }  
        }
    @PublicApi(since = "1.0.0")  
            releasable = null;  
        }  
     * The delete result
         * multiple times. Note: this might also be set to true if an equivalent event occurred like the replay of the transaction log
 * Licensed to Elasticsearch under one or more contributor  
     * Delete operation  
                            logger.warn(  
                final Directory finalDirectory = directory;  
                Segment segment = segments.get(info.info.name);
    }  
            customTranslogDeletionPolicy = engineConfig.getCustomTranslogDeletionPolicyFactory()
        }  
    }
     * @param version the version  
        ) {  
     * @opensearch.api
     * @param origin the operation origin  
        public Get setIfSeqNo(long seqNo) {
        return uuid;  
        boolean throttleLockIsHeldByCurrentThread() { // to be used in assertions and tests only
     * that docID(O) has been deleted (or never existed) without needing to check Lucene for the following reason. If there's no earlier
        @Override
            this.ifPrimaryTerm = ifPrimaryTerm;
                logger.trace("flushAndClose now acquired writeLock");
        }
                    }  
        public String reason() {
        if (isClosed.get()) {
            for (LeafReaderContext ctx : searcher.getIndexReader().getContext().leaves()) {
    /*
        } catch (AlreadyClosedException ex) {
    /**
        }
    /**
        Translog.Location flush();
            if (freeze.get() == null) {  
     * Acquires a safe {@link CatalogSnapshot} for the latest commit. Default implementation  
        // TODO: add more fine grained mem stats values to per segment info here  
        protected abstract void doClose();
        } else {
        Engine.Operation.Origin origin,
                engineConfig.getIndexSettings().getTranslogRetentionSize().getBytes(),
    /**
        } catch (IOException | RuntimeException e) {  
        String[] files;
        private final AtomicBoolean released = new AtomicBoolean(false);  
            return this;  
     */
        private long version = Versions.MATCH_ANY;  
     * Returns the {@link PrimaryOperationPolicy} in effect for this engine.
    }
        public Term uid() {
            } catch (AlreadyClosedException e) {
         * Type of the result
        }
            failEngine("corrupt file (source: [" + source + "])", e);  
    public abstract void updateMaxUnsafeAutoIdTimestamp(long newTimestamp);
     * Created by {@link #beginTranslogBatch()}.
     */  
            throw new EngineException(shardId, "Failed to materialize CatalogSnapshot from safe IndexCommit", e);  
    }
     */
                    // we first mark the store as corrupted before we notify any listeners
     * Index operation
    public abstract boolean shouldPeriodicallyFlush();  
import org.opensearch.action.index.IndexRequest;  
                System.nanoTime(),
                this.took = took;  
     *  
import java.util.Map;  
        if (docs.length == 0) {
         * Called once a new top-level reader is opened.  
                if (failedEngine.get() != null) {
        return (reason.equals(FORCE_MERGE) || reason.equals(MERGE_FAILED))
        public NoOpResult(long term, long seqNo) {
    /**  
        }  
            versionType,
                        segment.sizeInBytes = info.sizeInBytes();
            lock = NOOP_LOCK;
        private final ReleasableLock lockReference = new ReleasableLock(new ReentrantLock());  
    /**  
    public abstract void activateThrottling();  
     * Index result  
            this.operationType = operationType;  
    @PublicApi(since = "1.0.0")
     * The engine searcher
            SearcherSupplier reader = releasable = acquireSearcherSupplier(wrapper, scope);
        /** get total time in nanoseconds */
import org.opensearch.common.annotation.PublicApi;
    /**  
            try {
    public abstract boolean maybeRefresh(String source) throws EngineException;  
            return TYPE.NO_OP;  
        awaitPendingClose();
            stats.addFileSizes(getSegmentFileSizes(segmentReader));
        }
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver;
            @Nullable String routing
                } else {  
    /**  
        public Engine.Searcher searcher() {  
        @Override
        segments.put(info.info.name, segment);
    protected volatile long lastWriteNanos = System.nanoTime();
                return Map.of();
        return prepareDelete(id, null, seqNo, primaryTerm, version, versionType, origin, ifSeqNo, ifPrimaryTerm);
            return this.uid;  
     * chunk but keeps the scope open, allowing a realtime GET or a size limit to force an early append while the bulk  
import org.apache.lucene.index.SegmentReader;
     * Default returns {@code false}; engines with a pending-merge queue (e.g., {@link InternalEngine}'s
    }
                    try {  
        public DeleteResult(Exception failure, long version, long term, long seqNo, boolean found) {
        @Override
import org.opensearch.ExceptionsHelper;
     */
     * as an update operation if it overwrites the existing documents in Lucene index with the same document id.
                commitRef.close();
    private void fillSegmentInfo(SegmentReader segmentReader, boolean verbose, boolean search, Map<String, Segment> segments) {
     * freed.
/**
        long ifPrimaryTerm
                .create(engineConfig.getIndexSettings(), engineConfig.retentionLeasesSupplier());  
     * Performs the pre-closing checks on the {@link Engine}.  
        long ifPrimaryTerm  
                    get.id(),
    public abstract long getMaxSeqNoOfUpdatesOrDeletes();
     */  
    public static final String MERGE_FAILED = "merge failed";
import org.opensearch.common.lease.Releasable;  
        }
     *
        public Get versionType(VersionType versionType) {
     * @param primaryTerm the primary term
            this.term = term;
        }
        private final boolean exists;
        }
                uid,
                throw new VersionConflictEngineException(  
        return false;
                            } catch (IOException e) {  
                return Map.of();
        }
     * operation on docID(O) then this is clear, so suppose instead that the preceding operation on docID(O) is O':  
                    docIdAndVersion.primaryTerm  
        return new Engine.Delete(id, uid, seqNo, primaryTerm, version, versionType, origin, startTime, ifSeqNo, ifPrimaryTerm, routing);  
            } catch (IOException e) {
        public long seqNo() {
            this.seqNo = seqNo;
     * @param primaryTerm the primary term  
        }
        }
            );  
     * @param flushThresholdBytes  the uncommitted segment bytes at or above which the engine should flush, as resolved
     * Called for each new opened engine reader to warm new segments  
            final Searcher searcher = acquireSearcherInternal(source);
        Arrays.sort(segmentsArr, Comparator.comparingLong(Segment::getGeneration));
     * Request that this engine throttle incoming indexing requests to one thread.  
        if (failEngineLock.tryLock()) {
        private final String id;
            return found;
                final Directory finalDirectory = directory;
     */  
     * <p>
     * Flush the engine (committing segments to disk and truncating the
        public Operation(Term uid, long seqNo, long primaryTerm, long version, VersionType versionType, Origin origin, long startTime) {
    }
            assert (origin == Origin.PRIMARY) || (ifSeqNo == UNASSIGNED_SEQ_NO && ifPrimaryTerm == UNASSIGNED_PRIMARY_TERM)
                false,
        public final Searcher acquireSearcher(String source) {  
    /**
import org.apache.lucene.index.IndexCommit;
            super(Operation.TYPE.DELETE, requiredMappingUpdate);
            return this.version;
        }  
     * Note: engine level failures (i.e. persistent engine failures) are thrown
        public VersionType versionType() {
    public final void ensureOpen() {
    PrimaryOperationPolicy getPrimaryOperationPolicy() {
            this.requiredMappingUpdate = null;
    @ExperimentalApi
    }  
                    } catch (IOException e) {  
    @Deprecated
            return ifSeqNo;
    public abstract Translog.Snapshot newChangesSnapshot(
        ensureOpen();
    /**
            .setCommitOnClose(false)  
     *
            if (get.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO  
        }
     * Base class for index and delete operation results
             */  
        boolean flush,
            long primaryTerm,
    /**  
import org.apache.lucene.store.Directory;
            this.version = version;
    protected final SetOnce<Exception> failedEngine = new SetOnce<>();
    /**
        stats.addVersionMapMemoryInBytes(0);
                0
    }  
     * @opensearch.api
        public Term uid() {
                SegmentReader segmentReader = Lucene.segmentReader(ctx.reader());  
        boolean upgradeOnlyAncientSegments,
     */  
            }
            }  
                                    "tried to mark store as corrupted but store is already closed. [{}]",
        }  
    }
        try (IndexWriter writer = new IndexWriter(store.directory(), iwc)) {  
                "Global checkpoint ["  
     * operation O' with {@literal seqNo(O') > seqNo(O) and docId(O') = docID(O)} is processed before O. In that case MSU(O') is at least
            for (LeafReaderContext ctx : searcher.getIndexReader().getContext().leaves()) {
        }
                0,
        }
        private final long ifPrimaryTerm;  
    public abstract String getHistoryUUID();
        stats.addIndexWriterMemoryInBytes(0);  
        }
                protected void doClose() {
                        }
            }
    }
            String source,  
        } else {
        String id,  
            try {
        public long getIfSeqNo() {
        if (docMapper.getMapping() != null) {
    public abstract SeqNoStats getSeqNoStats(long globalCheckpoint);  
     */  
                engineConfig.getIndexSettings().getTranslogRetentionAge().getMillis(),  
            super(Operation.TYPE.DELETE, failure, version, term, seqNo);  
        }
                    segment = new Segment(info.info.name);  
            }  
        private long took;
            if (freeze.get() == null) {
        boolean useCompoundFile = segmentCommitInfo.info.getUseCompoundFile();  
                    } catch (AlreadyClosedException e) {
     */
                try (Searcher searcher = acquireSearcher("refresh_needed", SearcherScope.EXTERNAL)) {
        @Override  
     * and then compares its MSU to its local checkpoint (LCP). If {@literal LCP < MSU} then there's a gap: there may be some operations  
            assert (origin == Origin.PRIMARY) || (ifSeqNo == UNASSIGNED_SEQ_NO && ifPrimaryTerm == UNASSIGNED_PRIMARY_TERM)
        }
     *
     * @opensearch.api  
        @Override
     *              with {@literal seqno(O') < seqno(O) and docID(O') = docID(O)} then the one with the greatest seqno is a delete.</li>
     */  
    // NOTE: do NOT rename this to something containing flush or refresh!
     */
    public static final class Searcher extends IndexSearcher implements Releasable {
     * @opensearch.api
     * @return the minimum retained sequence number
import org.opensearch.index.mapper.DocumentMapperForType;  
     * the policy, so a long-lived replica engine can otherwise carry a policy that no longer matches the
        private final Mapping requiredMappingUpdate;
    private void maybeDie(final String maybeMessage, final Throwable maybeFatal) {
     *
        Releasable releasable = store::decRef;
     * {@link SegmentInfosCatalogSnapshot}; engines with a native catalog should override
     * procedure is a no-op.
    }
        }
     * Synchronously refreshes the engine for new search operations to reflect the latest
                logger.warn(() -> new ParameterizedMessage("Couldn't list Compound Reader Directory [{}]", finalDirectory), e);
            searcher.getIndexReader(),
import java.io.Closeable;  
                    closeNoLock("engine failed on: [" + reason + "]", closedLatch);
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {
        public enum Origin {  
    public static class Index extends Operation {  
import java.io.IOException;
    }
import org.opensearch.core.common.bytes.BytesReference;  
     * Acquires a {@link CatalogSnapshot} of the engine's current in-memory state — i.e. the  
        if (store.shouldSetParentField()) {  
                e.addSuppressed(closeEx);
    }
            try {
    }
import java.util.Arrays;
        public BytesReference source() {  
        protected Result(Operation.TYPE operationType, Mapping requiredMappingUpdate) {
     * @param version the version
            }  
    /**
            }  
            super(Operation.TYPE.INDEX, version, term, seqNo);
import org.opensearch.index.translog.TranslogManager;
            );  
            PRIMARY,
     * is enabled.
     * <p>
    @PublicApi(since = "1.0.0")  
                logger.warn(
     */
                template.primaryTerm(),
     *
     * 1. The first invariant above tells us that {@literal seqno(O') <= MSU(O) <= LCP} so we have already applied O' to Lucene.
        }  
    public static class NoOp extends Operation {
                            }
    protected final ReentrantLock failEngineLock = new ReentrantLock();  
            NO_OP;
        }
        }  
        public Term uid() {  
    /**  
import org.opensearch.index.mapper.SourceToParse;  
        long seqNo,
        }
        public Get version(long version) {
            this.origin = origin;
        try (Searcher searcher = acquireSearcher("segments", SearcherScope.INTERNAL)) {
            this(failure, version, UNASSIGNED_PRIMARY_TERM, UNASSIGNED_SEQ_NO);  
                throw new EngineException(shardId, "failed to access searcher manager", e);
     * Invoked by the publisher when the condition is turned off, since a value published while it was on would
        }  
    protected void writerSegmentStats(SegmentsStats stats) {  
            }  
        }
                        source,
     * @param versionType the version type
    /**  
         * Called when a fatal exception occurred
            }
    }
     *    tests when we open indices with lots of segments and suddenly merges kick in.  
    public void flushAndClose() throws IOException {
        default Translog.Location finish() {  
            iwc.setParentField(Lucene.PARENT_FIELD);
     * @param ifSeqNo the ifSeqNo  
                throw new UncheckedIOException("failed to close", e);
    /**
            this.created = false;
     * on {@code lastWriteNanos} we use System.nanoTime() to initialize this since:  
    /** Check whether the engine should be failed */  
    void refreshPrimaryOperationPolicy() {}
    /**  
     * Flushes the state of the engine including the transaction log, clearing memory.  
        ScoreDoc[] docs = searcher.search(  
        try {  
     * Returns {@code true} if the underlying merge scheduler has merges queued but not yet started.
        /**
        long primaryTerm,  
                throw new IllegalStateException("result is already frozen");
        // now, correlate or add the committed ones...
        public void setTranslogLocation(Translog.Location translogLocation) {
                0,  
            } catch (IOException e) {
        searcher.setQueryCache(null);
        private final Operation.TYPE operationType;
     * Flushes the state of the engine including the transaction log, clearing memory and persisting  
import org.opensearch.common.SetOnce;
            return versionType;
        try (Searcher searcher = acquireSearcher("segments_stats", SearcherScope.INTERNAL)) {
     */
        public String routing() {
        long startTime = System.nanoTime();
        public long getTerm() {
                () -> Releasables.close(searcher, reader)
 */  
        try {
    ) {
        /**
    protected final void ensureOpen(Exception suppressed) {  
                    segments.put(info.info.name, segment);
            releasable = null; // success - hand over the reference to the engine reader  
     */  
            return this;  
    public static final String SEARCH_SOURCE = "search"; // TODO: Make source of search enum?
     * commit.
     */
     */  
            PEER_RECOVERY,  
    /**
        private final long term;
import org.opensearch.common.metrics.CounterMetric;  
     * by the uncaught exception handler that we install during bootstrap. If the specified throwable does indeed contain a fatal error,  
        }
     *  reduce index buffer sizes on inactive shards.
            long currentThrottleNS = 0;
        private final Term uid;  
    /**
        public void deactivate() {  
import org.opensearch.common.unit.TimeValue;
                        engineConfig.getQueryCache(),
                        } else {
import org.opensearch.common.annotation.ExperimentalApi;  
     * This operation is not going to block if another flush operation is currently running and won't write
    /**
            logger.debug("close now acquiring writeLock");
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
        return false;  
import java.util.function.Function;
    /**
    public final EngineConfig config() {
        private volatile ReleasableLock lock = NOOP_LOCK;
                                store.decRef();  
     * @param maybeMessage the message to maybe log
        // safe here.
        }  
        public String id() {
        public Operation.TYPE getOperationType() {
    public abstract NoOpResult noOp(NoOp noOp) throws IOException;
    }  
    /**
    public long getLastWriteNanos() {
    /**  
        public IndexResult(long version, long term, long seqNo, boolean created) {  
     * changes.  
    }  
                                ),
            } else {  
            maybeDie(reason, failure);  
            final SegmentInfos infos = Lucene.readSegmentInfos(commitRef.get());  
/*  
     * Must decrement the supplied when closing work is done and resources are
     * @opensearch.api
        public Condition newCondition() {  
            }  
     *                             by the publisher at the time of this publication
        }  
         * @return the sequence number
            // responsibility of the caller to call GetResult.release
     * @return             number of history operations
        }  
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {
            this.doc = doc;
 * GitHub history for details.
     * This method fetches the _id of last indexed document that was part of the given searcher and
        Engine.Operation.Origin origin,
    }  
     * @return Stats for pull-based ingestion.
            lock = lockReference;
     * @opensearch.api  
     * documents in the lucene index to disk including a potentially heavy and durable fsync operation.
 * SPDX-License-Identifier: Apache-2.0
         */
                    eventListener.onFailedEngine(reason, failure);  
    }  
    public abstract long getProcessedLocalCheckpoint();
     * @see System#nanoTime()
        IndexWriterConfig iwc = new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
            this.startTime = startTime;  
        return acquireSearcher(source, SearcherScope.EXTERNAL);  
            throw new UnsupportedOperationException();
                                );
        protected abstract Searcher acquireSearcherInternal(String source);
            this.source = source;
                UNASSIGNED_SEQ_NO,
                // Paranoia (System.nanoTime() is supposed to be monotonic): time slip may have occurred but never want
import org.opensearch.index.store.Store;
        long version,
     */  
     * Synchronously refreshes the engine for new search operations to reflect the latest  
            Term uid,  
                    reason
import org.opensearch.index.mapper.ParsedDocument;
            }
     * otherwise stay armed until the next commit invalidates it. The default is a no-op, mirroring  
     * @param toSeqNumber  to sequence number; included
 * specific language governing permissions and limitations
    public abstract boolean isThrottled();
    public static final String FORCE_MERGE = "force merge";
                    segment.version = info.info.getVersion();
                logger.warn(() -> new ParameterizedMessage("Error when closing compound reader on Directory [{}]", finalDirectory), e);
import org.apache.lucene.index.LeafReaderContext;  
     *  
            );
            throw new IllegalStateException("commit doesn't contain history uuid");
            throw e;  
        private long ifSeqNo = UNASSIGNED_SEQ_NO;
        } // TEST ONLY
import java.nio.file.NoSuchFileException;
            this.version = version;
            } catch (IOException closeEx) {
    }
     * @opensearch.api  
     * latest visible-to-readers segments, including any uncommitted operations that have been
        }
import java.util.Objects;
            this.id = Objects.requireNonNull(id);
     *  
     * @param seqNo the sequence number
            long primaryTerm,
    public void failEngine(String reason, @Nullable Exception failure) {
        SourceToParse source,  
     * or the auto_id_timestamp received from its primary shard via {@link #updateMaxUnsafeAutoIdTimestamp(long)}.  
                    return new Searcher(  
                    e
        public int estimatedSizeInBytes() {
     * which is run when the reference is closed. The default implementation of the clean-up  
        }
            try {
        }  
     * @return the prepared delete operation
         */  
        if (uuid == null) {  
        }  
        }
            }
        @Override
    /** returns the history uuid for the engine */
import org.opensearch.indices.pollingingest.PollingIngestStats;  
import org.apache.lucene.index.Term;  
    /**
            // do nothing except increasing metric count and close this will kick off IndexFileDeleter which will
        }  
        /**
     * @opensearch.internal  
        this.eventListener = engineConfig.getEventListener();
        boolean upgrade,
                failEngine("failed to access searcher manager", e);
                SegmentReader segmentReader = Lucene.segmentReader(ctx.reader());
     * Returns the number of merges currently in flight on this engine.
     */
        VersionType versionType,
                commitRef.close();
            if (getIndexReader() instanceof DirectoryReader directoryReader) {
            return primaryTerm;  
        private volatile long startOfThrottleNS;
         *
        try {  
            return this.startTime;
            docIdAndVersion = VersionsAndSeqNoResolver.loadDocIdAndVersion(searcher.getIndexReader(), get.uid(), true, null);
     * {@link InternalEngine}'s {@code OpenSearchConcurrentMergeScheduler}) override.  
        private final String source;
                if (segments.containsKey(segmentReader.getSegmentName()) == false) {
        public long startTime() {  
        private final DocIdAndVersion docIdAndVersion;  
        public void lockInterruptibly() throws InterruptedException {}
    protected final AtomicBoolean isClosed = new AtomicBoolean(false);
     */  
     * <p>  
     * Discards any previously published uncommitted segment bytes accounting, so that it can no longer trigger a flush.
 * the Apache License, Version 2.0 (the "License"); you may
    public abstract DeleteResult delete(Delete delete) throws IOException;
            return this.doc.docs();  
        SegmentCommitInfo segmentCommitInfo = segmentReader.getSegmentInfo();
            return term;
        /**
            return throttleTimeMillisMetric.count() + TimeValue.nsecToMSec(currentThrottleNS);
    /**  
 *  
    /**  
    }
    public abstract void flush(boolean force, boolean waitIfOngoing) throws EngineException;  
            return CAN_MATCH_SEARCH_SOURCE.equals(source) ? searcher : wrapper.apply(searcher);
    protected final Store store;
        );  
            try {
    /**
     *
            }
    @Deprecated
        @Override  
     *
     * @return the number of no-ops added
     * Note: engine level failures (i.e. persistent engine failures) are thrown  
 * license agreements. See the NOTICE file distributed with
        } catch (Exception e) {  
        // when indexing but not refreshing in general. Yet, if a refresh happens the internal searcher is refresh as well so we are  
        return IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP;
import org.opensearch.common.lease.Releasables;
            .setOpenMode(IndexWriterConfig.OpenMode.APPEND);
 * ownership. Elasticsearch licenses this file to you under  
        Set<String> segmentName = new HashSet<>();  
        }
import java.util.concurrent.TimeUnit;
        public boolean isCreated() {
            return TYPE.DELETE;
                @Override  
import java.util.HashSet;  
            String id,
        }
        final CatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(segmentInfosRef.get());
         */
                    if (shouldCleanupUnreferencedFiles() && isMergeFailureDueToIOException(failure, reason)) {
 * compatible open source license.
                throw new IllegalStateException("result is already frozen");  
     * Acquires a {@link CatalogSnapshot} pinned to the most recent commit on disk,  
    public final CommitStats commitStats() {  
                    + maxSeqNo  
    public abstract static class Operation {  
     *  NOTE: don't use this value for anything accurate it's a best effort for freeing up diskspace after merges and on a shard level to
import java.util.Set;
/*  
     *
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
    }
            this.version = version;  
     * changes unless another thread is already refreshing the engine concurrently.
            // we go on the segment level here to get accurate numbers
        return Objects.requireNonNullElseGet(
        private VersionType versionType = VersionType.INTERNAL;
                        // TODO we might force a flush in the future since we have the write lock already even though recoveries  
        private final long ifPrimaryTerm;
public abstract class Engine implements LifecycleAware, Closeable {
            // TODO: A better exception goes here
            } catch (IOException e) {  
        }  
        return totalUnreferencedFileCleanUpsPerformed.count();
            Term uid,
        }  
        ) {
     * lucene index to make sure we have a "fresh" copy of the files to snapshot.
import org.apache.lucene.index.IndexFileNames;
        }  
         */
    @PublicApi(since = "1.0.0")
            this.versionType = versionType;
        public DocIdAndVersion docIdAndVersion() {
     */
        try {
     * The threshold to flush at is supplied by the publisher rather than read from settings here, because resolving it  
        // default implementation
    }  
        if (Lucene.isCorruptionException(e)) {
        private final CounterMetric throttleTimeMillisMetric = new CounterMetric();  
        }
            return this.version;
     */  
            long seqNo,  
     * Event listener for the engine
     */
                logger.warn("failEngine threw exception", inner);
import java.util.Collections;  
        return segmentsArr;
     * <p>
            return this.searcher;
            && ExceptionsHelper.unwrap(failure, IOException.class) instanceof IOException;  
        public abstract TYPE operationType();  
            VersionType versionType,
     * the specified message will attempt to be logged before throwing the fatal error. If the specified throwable does not contain a fatal
     * @param docMapper the document mapper instance  
     *  
        }
    @Override
            } catch (IOException closeEx) {  
     * Get max sequence number that is part of given searcher. Sequence number is part of each document that is indexed.  
    public static final String FORCE_MERGE_UUID_KEY = "force_merge_uuid";
     * @see #advanceMaxSeqNoOfUpdatesOrDeletes(long)  
     * seqno(O') and this means {@literal MSU >= seqNo(O') > seqNo(O) > LCP} (because O wasn't processed yet).  
            this.version = version;  
     * Acquires a point-in-time reader that can be used to create {@link Engine.Searcher}s on demand.  
            }
         * type of operation (index, delete), subclasses use static types  
            // TODO: consider moving this to StoreStats  
                                store.markStoreCorrupted(  
            this.ifPrimaryTerm = ifPrimaryTerm;
            return failure;
    public static final TranslogBatch NO_OP_TRANSLOG_BATCH = () -> null;  
        long ifSeqNo,
     *
    /**  
            } catch (IOException e) {
        private final boolean readFromTranslog;
                throw new VersionConflictEngineException(  
        return acquireSearcherSupplier(wrapper, SearcherScope.EXTERNAL);  
            this.routing = routing;
                }  
            }
            this.found = found;
                template.routing()
     */  
            this(  
        }
     * Returns the unreferenced file cleanup count for this engine.
        if (engineConfig.getCustomTranslogDeletionPolicyFactory() != null) {
            () -> new DefaultTranslogDeletionPolicy(
     * Therefore, if {@literal MSU <= LCP < seqno(O)} we know that O can safely be optimized with and added to lucene with addDocument.
    public abstract long getPersistedLocalCheckpoint();
        segment.attributes = info.info.getAttributes();
                );  
            this.seqNo = UNASSIGNED_SEQ_NO;
            if (get.versionType().isVersionConflictForReads(docIdAndVersion.version, get.version())) {
                        logger.info("Cleaning up unreferenced files as merge failed due to: {}", reason);
     * @param origin the operation origin
import org.opensearch.common.lucene.search.Queries;
        @Override
                        // are running.
import org.apache.lucene.search.IndexSearcher;
     * Fills up the local checkpoints history with no-ops until the local checkpoint
        public String id() {
            this.fromTranslog = fromTranslog;
        @Override
        return new GatedCloseable<>(snapshot, segmentInfosRef::close);
                    try {
                } finally {
        }
     * @param id the document id  
        private final String reason;  
     * @return {@link IndexResult} containing updated translog location, version and
        @Override  
        public long getSeqNo() {  
        public long getIfPrimaryTerm() {  
    public abstract int fillSeqNoGaps(long primaryTerm) throws IOException;
            segment.sizeInBytes = info.sizeInBytes();  
        awaitPendingClose();
                closeNoLock("api", closedLatch);
                final Directory finalDirectory = directory;  
     */
import org.opensearch.index.mapper.ParseContext.Document;  
     * is the publisher's concern: it owns both the index setting and the cluster setting it falls back to.
        public TYPE operationType() {
        @Override
import org.apache.lucene.index.IndexWriterConfig;
        public TYPE operationType() {  
    }
        public long version() {  
            try {  
                throttleTimeMillisMetric.inc(TimeValue.nsecToMSec(throttleTimeNS));  
            return this.realtime;
                && (get.getIfSeqNo() != docIdAndVersion.seqNo || get.getIfPrimaryTerm() != docIdAndVersion.primaryTerm)) {
        }
        // the next scheduled refresh to go through and refresh the stats as well  
    public abstract static class SearcherSupplier implements Releasable {
        @Override
import java.util.concurrent.locks.Lock;
     */
        }
    protected final EventListener eventListener;
            private final String lowercase;
        public final void close() {  
                        engineConfig.getSimilarity(),  
        public ParsedDocument parsedDoc() {
    }
            throw ace;  
        }
        public long version() {
                directory.close();
            doc.addDynamicMappingsUpdate(docMapper.getMapping());
            try {
            return 2 * reason.length() + 2 * Long.BYTES;
    @Nullable
            }
     */  
            assert lock == NOOP_LOCK : "throttling activated while already active";  
            this.seqNo = seqNo;
        }
     */
     * translog failure: it fails only if the exception is the translog's own tragic event.  
        private final Result.Type resultType;
        public long getIfSeqNo() {
import org.apache.lucene.search.QueryCachingPolicy;  
/*
    protected final ShardId shardId;
     * slightly inaccurate.
        }
            long length = 0L;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *
            customTranslogDeletionPolicy,  
    protected final DocsStats docsStats(IndexReader indexReader) {
            directory = segmentReader.directory();
     * Returns the maximum auto_id_timestamp of all append-only index requests have been processed by this engine
        private final SetOnce<Boolean> freeze = new SetOnce<>();
    /**
     * Global stats on segments.
import org.apache.lucene.search.SortField;
            this.operationType = operationType;
        public SearcherSupplier(Function<Searcher, Searcher> wrapper) {
            return resultType;
            return this.doc.id();
                UNASSIGNED_SEQ_NO,  
            };
     */
    public abstract CompletionStats completionStats(String... fieldNamePatterns);  
            } catch (IOException e) {
            version,
            super(uid, seqNo, primaryTerm, version, versionType, origin, startTime);
     */
                }  
        /** Append the currently pending chunk and return the greatest location appended by this scope so far. */  
        // index.refresh_interval=-1 won't see any doc stats updates at all. This change will give more accurate statistics
     * must be closed for segment files to be deleted.
            autoGeneratedIdTimestamp,
                    () -> new ParameterizedMessage(  
    public SearcherSupplier acquireSearcherSupplier(Function<Searcher, Searcher> wrapper, SearcherScope scope) throws EngineException {  
    @PublicApi(since = "1.0.0")
        }  
            throw e;
            this.version = Versions.NOT_FOUND;
import org.apache.logging.log4j.message.ParameterizedMessage;
     *
import org.opensearch.index.translog.TranslogDeletionPolicy;
        ensureOpen(null);
import org.opensearch.index.VersionType;  
            this.id = id;
                this.translogLocation = translogLocation;
                    "tried to fail engine but could not acquire lock - engine should " + "be failed by now [{}]",
        private final ParsedDocument doc;
     * The list of segments in the engine.
            return this.versionType;  
    /**  
        boolean onlyExpungeDeletes,  
     */  
        private final long ifSeqNo;
     * <ol>
    protected static final class NoOpLock implements Lock {
    final Segment[] getSegmentInfo(SegmentInfos lastCommittedSegmentInfos, boolean verbose) {  
            } catch (Exception inner) {
            return reader;
        ensureOpen();
        long numDeletedDocs = 0;  
            // don't release the searcher on this path, it is the  
import org.apache.logging.log4j.Logger;
     * Returns the number of milliseconds this engine was under index throttling.
    }
                e.addSuppressed(closeEx);
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
        long primaryTerm,
     * indices) can treat read failures uniformly with the legacy commit path.  
            public boolean isRecovery() {
         * Origin of the operation
            closedLatch.await();
                assert false : "SearchSupplier was released twice";
            throw new AlreadyClosedException(shardId + " store is closed", failedEngine.get());
    public TranslogBatch beginTranslogBatch() {  
            setQueryCache(queryCache);  
        int maxNumSegments,
        try {
     *
        public boolean isFromTranslog() {
                        throw new AssertionError(e);  
     * native state isn't a single {@link SegmentInfos} (e.g. multi-format engines that aggregate
                version,  
 * under the License.  
import org.opensearch.common.concurrent.GatedCloseable;
        if (useCompoundFile) {
    }
        boolean isThrottled() {
            return version;
     * A noop result
     * @param maybeFatal   the throwable that maybe contains a fatal error
        }
 * this work for additional information regarding copyright
     * @return {@link DeleteResult} containing updated translog location, version and  
        this.logger = Loggers.getLogger(Engine.class, engineConfig.getShardId());
                        () -> new ParameterizedMessage("tried to fail engine but engine is already failed. ignoring. [{}]", reason),  
        return docIdAndVersion.seqNo;
     *
     * @opensearch.api  
            this(failure, version, term, UNASSIGNED_SEQ_NO, false);
        public NoOpResult(long term, long seqNo, Exception failure) {  
            this.uid = uid;
import java.util.concurrent.CountDownLatch;  
     */  
     * that there are no catch statements that would catch an error in the stack as the fatal error here should go uncaught and be handled
                logger.debug("close acquired writeLock");
     * for an executed write {@link Operation}
                    ),
     * with {@literal seqno(O') > LCP and seqno(O') < seqno(O) also has docID(O') = docID(O)}, because such an operation would have  
        }
    public static class GetResult implements Releasable {  
        public IndexResult(Exception failure, long version, long term, long seqNo) {  
                );
    public abstract void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary);
import org.apache.lucene.search.similarities.Similarity;
        }
        Directory directory = null;
                @Override
        public DeleteResult(long version, long term, long seqNo, boolean found) {
            return (uid().field().length() + uid().text().length()) * 2 + 20;
        Get get,
            super(uid, seqNo, primaryTerm, version, versionType, origin, startTime);
            1,
            this.failure = null;
    }  
     */
import java.util.Comparator;
            TYPE() {  
    /** Returns how many bytes we are currently moving from heap to disk */  
import org.apache.lucene.index.IndexWriter;
            super(null, seqNo, primaryTerm, Versions.NOT_FOUND, null, origin, startTime);
                if (currentThrottleNS < 0) {
    }
                return Map.of();
                    e  
            seqNo,
                source,
import org.apache.lucene.index.SegmentInfos;  
        TranslogDeletionPolicy customTranslogDeletionPolicy = null;  
                        () -> {}  
    /**
        public long getIfSeqNo() {  
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndVersion;
            numDeletedDocs += readerContext.reader().numDeletedDocs();  
     * and the max seen sequence ID are identical.  
        }  
        }  
            return requiredMappingUpdate;
            String id,
                    + "] mismatches maximum sequence number ["
        return new MergeStats();  
                    try {
 * You may obtain a copy of the License at  
        public IndexResult(Exception failure, long version) {
        INTERNAL
     * as they are now, rather than the one resolved when this engine was built. A replica never consults  
     * However, if {@literal MSU <= LCP} then there is no gap: we have processed every {@literal operation <= LCP}, and no operation O'
    @PublicApi(since = "1.0.0")
import org.opensearch.index.mapper.Uid;
        }  
    public long getMaxSeqNoFromSegmentInfos(SegmentInfos segmentInfos) throws IOException {
            ParsedDocument doc,
    protected abstract SegmentInfos getLatestSegmentInfos();  
            this.requiredMappingUpdate = requiredMappingUpdate;
        }  
     * @throws IllegalStateException if the sanity checks failed
     */
        return engineConfig;  
    private void cleanUpUnreferencedFiles() {
         * the searcher is acquired. */  
                    ),
import org.opensearch.index.seqno.SeqNoStats;
 * software distributed under the License is distributed on an
    public interface EventListener {  
        Index(Term uid, long primaryTerm, ParsedDocument doc, long version) {  
     *             {@code segments_N} disk read required to materialize an {@link IndexCommit}.  
            return docsStats(searcher.getIndexReader());  
     * post-refresh local segment file sizes. Engine-generic: the notion of "bytes since the last commit" is not
import org.opensearch.index.shard.DocsStats;  
    @PublicApi(since = "1.0.0")
                System.nanoTime(),  
     * @return the prepared index operation
     * This allows the engine to include a clean-up {@link org.opensearch.common.CheckedRunnable}
    public boolean refreshNeeded() {  
    public final void flush() throws EngineException {
            }
            freeze.set(true);
import org.opensearch.common.Nullable;
            startOfThrottleNS = System.nanoTime();
        private final @Nullable String routing;
                        segmentCommitInfo  
            OpenSearchDirectoryReader acquire = referenceManager.acquire();
            return uid;  
            this.reason = reason;
                () -> new ParameterizedMessage(  
     *
     * @param ifPrimaryTerm the ifPrimaryTerm
            this.onClose = onClose;  
        /** Deactivate throttling, which switches the lock to be an always-acquirable NoOpLock */
            }  
            }
        }
        }
                    docIdAndVersion.seqNo,
    /**
        }  
    public abstract long getMinRetainedSeqNo();
        protected Result(Operation.TYPE operationType, long version, long term, long seqNo) {
            final SegmentReader segmentReader = Lucene.segmentReader(readerContext.reader());  
    }
                    }
            try {  
            isRetry,  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        }
            return false;  
        /** whether the operation was successful, has failed or was aborted due to a mapping update */  
                logger.error(maybeMessage, error);
        /* Acquire order here is store -> manager since we need
            return this.origin;
        public void activate() {
            return this.routing;  
        } catch (IOException e) {
            if (released.compareAndSet(false, true)) {
    protected void fillSegmentStats(SegmentReader segmentReader, boolean includeSegmentFileSizes, SegmentsStats stats) {  
     */
            }
            setQueryCachingPolicy(queryCachingPolicy);
            assert startOfThrottleNS > 0 : "Bad state of startOfThrottleNS";
            } finally {  
        }  
            return new GatedCloseable<>(snapshot, commitRef::close);
         * @opensearch.api  
     * Returns the maximum sequence number of either update or delete operations have been processed in this engine
            throw new IllegalStateException("Can't use " + getIndexReader().getClass() + " as a directory reader");
    /**
     */  
            for (SegmentCommitInfo info : lastCommittedSegmentInfos) {  
            this.exists = exists;
     *
                doc,  
            if (length == 0L || extension == null) {  
    /**
     * refreshed. Used by replication-checkpoint listeners and any caller that wants the live
        public Releasable acquireThrottle() {  
        }
                    }
        public long getIfPrimaryTerm() {  
     */  
            }  
        @Override  
                Releasables.close(searcher);
            throw new UnsupportedOperationException();  
            final IndexSearcher searcher = new IndexSearcher(innerReader);  
    public long getMaxSeenAutoIdTimestamp() {  
            if (suppressed != null) {  
     * translog) and close it.
    @SuppressWarnings("finally")
    public abstract int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException;
            REPLICA,
            throw new UnsupportedOperationException();
        private final Origin origin;
     */  
    /**
    protected abstract void closeNoLock(String reason, CountDownLatch closedLatch);
    /**
        } finally {  
    }
            IndexReader reader,
     * error, this method is a no-op.
                            try {
    public GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException, IOException {  
                throw new AssertionError(e);
                versionType,  
    public DocsStats docStats() {
            return true;
    protected final ReleasableLock readLock = new ReleasableLock(rwl.readLock());
        long getThrottleTimeInMillis() {
        public Get setIfPrimaryTerm(long primaryTerm) {
            this.failure = null;  
     * to avoid the extra disk read.  
     *  
        }  
     * Prepares a delete operation by creating an Engine.Delete operation.
     * @return <code>true</code> if the a refresh happened. Otherwise <code>false</code>  
                store.decRef();
     */
import org.apache.lucene.search.QueryCache;
                        // This means there's a bug somewhere: don't suppress it
            Releasables.close(searcher);
    /**
                    segment.committed = true;
            this.version = version;  
        @Override
     *
        return acquireSearcher(source, scope, Function.identity());
     * @return the persisted local checkpoint for this Engine
     *
                public Searcher acquireSearcherInternal(String source) {
        public DeleteResult(Mapping requiredMappingUpdate) {
            } catch (IOException e) {  
        if (includeSegmentFileSizes) {
                    // on the same node that we don't see the corrupted marker file when
import java.util.function.BiFunction;
import org.opensearch.index.mapper.IdFieldMapper;
                uid,
     * @return a {@link SeqNoStats} object, using local state and the supplied global checkpoint
    /**
        }
import java.util.List;
            ReferenceManager<OpenSearchDirectoryReader> referenceManager = getReferenceManager(scope);  
    @PublicApi(since = "1.0.0")  
        public int estimatedSizeInBytes() {  
        @Nullable
     * Also see {@link #getPersistedLocalCheckpoint()}
    protected long getMaxSeqNoFromSearcher(IndexSearcher searcher) throws IOException {
                template.origin(),
     *
            assert ifSeqNo == UNASSIGNED_SEQ_NO || ifSeqNo >= 0 : "ifSeqNo [" + ifSeqNo + "] must be non negative or unset";
            Releasables.closeWhileHandlingException(searcher);
            this.searcher = searcher;
    /**
import java.io.FileNotFoundException;
         * use in case of the index operation failed before getting to internal engine  
            return version;
        segment.segmentSort = info.info.getIndexSort();
    /**
    /**  
                    return searcher.getDirectoryReader().isCurrent() == false;  
    @PublicApi(since = "1.0.0")
        } catch (InterruptedException e) {
     * Scope of the searcher  
     * A throttling class that can be activated, causing the  
    /**
        Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id()));
            return exists;
     * A flush may be initiated by another thread resolving a pending realtime GET. Implementations must serialize  
            assert ifSeqNo == UNASSIGNED_SEQ_NO || ifSeqNo >= 0 : "ifSeqNo [" + ifSeqNo + "] must be non negative or unset";
            DELETE,
        public long getIfPrimaryTerm() {
import org.opensearch.index.mapper.Mapping;
        } catch (Exception ex) {
    /**  
        default void onFailedEngine(String reason, @Nullable Exception e) {}
    }
    /**
        long version,  
        public boolean exists() {  
        String id() {  
        }  
     * Method to close the engine while the write lock is held.  
    /** A {@link TranslogBatch} that batches nothing; every op is written inline as before. */
        private final boolean found;  
     * @opensearch.api  
        }  
    @ExperimentalApi
        public VersionType versionType() {
     *
     * If the specified throwable contains a fatal error in the throwable graph, such a fatal error will be thrown. Callers should ensure
            return translogLocation;  
        public Delete(String id, Term uid, long primaryTerm) {
                sizeInBytes += info.sizeInBytes();
     * Return the latest active SegmentInfos from the engine.
         * to make sure that the store is not closed before
                            );  
                failure
     * @return a summary of the contents of the current safe commit
            this.ifPrimaryTerm = primaryTerm;
     * @param ifSeqNo the ifSeqNo  
import org.apache.lucene.index.StandardDirectoryReader;
        String source,
            return this;  
        if (docIdAndVersion != null) {  
            );
            return id;
            this.autoGeneratedIdTimestamp = autoGeneratedIdTimestamp;  
     */  
    @PublicApi(since = "1.0.0")  
            Closeable onClose
        private final long ifSeqNo;  
         * The source that caused this searcher to be acquired.
        }
     * concurrent add/flush activity. If an append fails, all affected requests must fail with the exception the
            this.resultType = Type.SUCCESS;
            return TYPE.INDEX;
    public static class DeleteResult extends Result {
    protected boolean maybeFailEngine(String source, Exception e) {
                    // clean all unreferenced files on best effort basis created during failed merge and reset the
        }  
        private final long version;
    }  
            long startTime,
        }  
            final CatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(infos);
            long version,
            LOCAL_RESET;
            assert ifPrimaryTerm >= 0 : "ifPrimaryTerm [" + ifPrimaryTerm + "] must be non negative";  
    }  
            }
    public enum SearcherScope {
            } else {
 * @opensearch.api
         * Returns the routing value for this delete operation, or {@code null} if no custom routing was specified.  
                    // we just go and close this engine - no way to recover  
        }
import java.util.concurrent.locks.Condition;  
import org.opensearch.common.lucene.uid.Versions;  
                VersionType.INTERNAL,
            return readFromTranslog;
                length = directory.fileLength(file);
    }
import org.apache.lucene.search.ReferenceManager;
    }  
    }  
            boolean isRetry,  
        public Mapping getRequiredMappingUpdate() {  
    /**
            }
        /**  
                    );
        public VersionType versionType() {  
        return this.lastWriteNanos;
    public PollingIngestStats pollingIngestStats() {
    }
import org.apache.lucene.store.AlreadyClosedException;  
            this.failure = Objects.requireNonNull(failure);
        long sizeInBytes = 0;
     * @param seqNo the sequence number
        ).scoreDocs;
        public String source() {  
    /**
    protected static final class IndexThrottle {
     * that act on docID(O) about which we do not yet know, so we cannot perform an add. Note this also covers the case where a future
    /**  
        public NoOp(final long seqNo, final long primaryTerm, final Origin origin, final long startTime, final String reason) {  
     */
                e.addSuppressed(closeEx);
        }  
import org.apache.lucene.index.DirectoryReader;  
                    } catch (IOException e) {
                fillSegmentStats(segmentReader, includeSegmentFileSizes, stats);
            return SequenceNumbers.NO_OPS_PERFORMED;  
            return seqNo;
        }  
        boolean requiredFullRange,
        }
     */
     * Acquires a point-in-time reader that can be used to create {@link Engine.Searcher}s on demand.
        /**
     * @param ifPrimaryTerm the ifPrimaryTerm
        /**  
        }
        if (useCompoundFile) {
                if (segment == null) {
        }
        }
        }
        segment.compound = info.info.getUseCompoundFile();
    }  
    }
            this.operationType = operationType;
        public Origin origin() {
                continue;
        assert docIdAndVersion != null;
     * so a shard that is becoming a primary uses the policy its plugin resolves from the index settings
    }  
            setSimilarity(similarity);
        public enum TYPE {
            throw new EngineException(shardId, "Couldn't resolve version", e);  
                : "cas operations are only allowed if origin is primary. get [" + origin + "]";  
     * Get max sequence number from segments that are referenced by given SegmentInfos
            }  
     * @opensearch.api
            long ifPrimaryTerm,
                engineConfig.getIndexSettings().getTranslogRetentionTotalFiles()
     */  
        }  
     * @param source the source to parse
            QueryCachingPolicy queryCachingPolicy,
    /**
            assert ifPrimaryTerm >= 0 : "ifPrimaryTerm [" + ifPrimaryTerm + "] must be non negative";  
import org.opensearch.common.lucene.Lucene;  
     * Perform document delete operation on the engine
                primaryTerm,  
     */  
        try (Searcher searcher = acquireSearcher("segments", SearcherScope.EXTERNAL)) {
                    close(); // double close is not a problem
         */
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        }  
            Releasables.close(releasable);
import java.util.concurrent.locks.ReentrantReadWriteLock;  
            map.merge(extension, length, Long::sum);  
        this.store = engineConfig.getStore();
        public Type getResultType() {
     * The default {@link #beginTranslogBatch()} returns {@link #NO_OP_TRANSLOG_BATCH}, under which engines keep writing
     */  
        if (store.tryIncRef()) {
        public static final GetResult NOT_EXISTS = new GetResult(false, Versions.NOT_FOUND, null, null, false);
        /**
    }  
        private final long startTime;  
                failedEngine.set((failure != null) ? failure : new IllegalStateException(reason));
         */
        }
        long seqNo,
    public static class IndexResult extends Result {
        }
    @PublicApi(since = "1.0.0")
                );
     * Creates a new history snapshot from Lucene for reading operations whose seqno in the requesting seqno range (both inclusive).
        assert directory != null;
     */
        }
    @PublicApi(since = "1.0.0")
        /** get the updated document version */
     * @param waitIfOngoing if <code>true</code> this call will block until all currently running flushes have finished.  
                    get.versionType().explainConflictForReads(docIdAndVersion.version, get.version())  
                    // If cleanup of unreferenced flag is enabled and force merge or regular merge failed due to IOException,
     * regardless of retention policy. Default wraps {@link #acquireLastIndexCommit(boolean)}.
     * @opensearch.api
    /**  
        }
            return new Searcher(
        }  
        try (DirectoryReader innerReader = StandardDirectoryReader.open(store.directory(), segmentInfos, null, null, null)) {
     * operations on the shard are blocked. The default implementation does nothing, which is correct for
    /**
         */
    @ExperimentalApi
                    // the shard is initializing
                        acquire,
        }  
        private final Term uid;  
            return this.doc;  
     */  
     */
                            } finally {
            for (LeafReaderContext ctx : searcher.getIndexReader().getContext().leaves()) {
            return source;
        private final boolean created;
                );
     * @opensearch.api
        return engineConfig.getMergedSegmentTransferTracker();
            this.versionType = versionType;
     * object directly, this method returns a {@link GatedCloseable} reference to the same object.
        }
     * Snapshots the most recent index and returns a handle to it. If needed will try and "commit" the
     * Supplier for the searcher
         *
    public int getActiveMergeCount() {
    /**
        return new Engine.Index(
        public void setTook(long took) {
            long seqNo,  
            primaryTerm,  
     * Acquires a lock on the translog files and Lucene soft-deleted documents to prevent them from being trimmed
        private final Function<Searcher, Searcher> wrapper;
            logger.error("Error while deleting unreferenced file ", ex);
            return lock != NOOP_LOCK;
        }
     * Base operation class
     */
            );
    }  
        long version,
            INDEX,  
        try {
    /**  
        }  
     * @param primaryTerm the shards primary term this engine was created for
        // first, go over and compute the search ones...  
            this.docIdAndVersion = docIdAndVersion;  
                        logger.debug("engine already closed - skipping flushAndClose");
            }
     * </ol>  
              the store is closed so we need to make sure we increment it here
        // we calculate the doc stats based on the internal searcher that is more up-to-date and not subject  
     * <p>
                }
            String extension = IndexFileNames.getExtension(file);
        protected Result(Operation.TYPE operationType, Exception failure, long version, long term, long seqNo) {  
    ) {  
            return this.doc.routing();
            return GetResult.NOT_EXISTS;
            assert lock != NOOP_LOCK : "throttling deactivated but not active";
     * Returns the timestamp of the last write in nanoseconds.  
    protected Engine(EngineConfig engineConfig) {  
        public Get(boolean realtime, boolean readFromTranslog, String id, Term uid) {
            return seqNo;
                    }
        );  
        public GetResult(Engine.Searcher searcher, DocIdAndVersion docIdAndVersion, boolean fromTranslog) {
        return stats;
                return lowercase;
            VersionType versionType,  
     * Reads the current stored history ID from commit data.
    public abstract GetResult get(Get get, BiFunction<String, SearcherScope, Searcher> searcherFactory) throws EngineException;  
            }
            doc,
     * @return the latest checkpoint that has been processed but not necessarily persisted.
            return flush();
    ) {
    public Engine.Delete prepareDelete(
              we need to inc the store here since we acquire a searcher and that might keep a file open on the  
                // This means there's a bug somewhere: don't suppress it  
     * When a receiving shard (either a replica or a follower) receives an operation O, it must first ensure its own MSU at least MSU(O),
     * A bulk-request scope that batches successful primary index operations before appending them to the translog.
    public abstract static class Result {  
    }
    protected String loadHistoryUUID(Map<String, String> commitData) {
        /**  
        @PublicApi(since = "1.0.0")
                    get.id(),
        @PublicApi(since = "1.0.0")  
        /**
        public Searcher(
                    logger.debug("flushing shard on close - this might take some time to sync files to disk");
                template.startTime(),
     */
     * @param isRetry whether this is a retry
            this.ifSeqNo = seqNo;
    /**
     */  
     */
     * wraps {@link #acquireSafeIndexCommit()} and parses its {@link SegmentInfos} into a
        if (isClosed.get() == false) { // don't acquire the write lock if we are already closed
import java.io.UncheckedIOException;  
        EXTERNAL,  
        private final VersionType versionType;
        // we don't wait for a pending refreshes here since it's a stats call instead we mark it as accessed only which will cause
            MAPPING_UPDATE_REQUIRED
        segment.delDocCount = segmentReader.numDeletedDocs();
        }
        private final long autoGeneratedIdTimestamp;  
     */
         **/
                logger.trace(() -> new ParameterizedMessage("failed to get size for [{}]", info.info.name), e);
            throw ex;  
        /** get the translog location after executing the operation */
 * KIND, either express or implied.  See the License for the
                directory = engineConfig.getCodec().compoundFormat().getCompoundReader(segmentReader.directory(), segmentCommitInfo.info);  
                throw new AlreadyClosedException("SearcherSupplier was closed");
    ) throws IOException;
    @PublicApi(since = "1.0.0")
    public Searcher acquireSearcher(String source, SearcherScope scope) throws EngineException {  
                        "Couldn't list Directory from SegmentReader [{}] and SegmentInfo [{}]",
        @Override
                searcher.getDirectoryReader(),  
        /**
                onClose.close();
     */  
            startTime,
    }
            LOCAL_TRANSLOG_RECOVERY,
    }
        }
                -1,
        }
    public void clearUncommittedSegmentBytes() {}  
     * This check is mainly based on the uncommitted translog size and the translog flush threshold setting.
                if (segmentName.contains(segmentReader.getSegmentName()) == false) {
    }
            this(
        assert segments.containsKey(info.info.name) == false;
        }
     * @opensearch.api
                    fillSegmentStats(segmentReader, includeSegmentFileSizes, stats);
     * fail engine due to some error. the engine will also be closed.
    @PublicApi(since = "1.0.0")  
            this.ifSeqNo = ifSeqNo;  
                                logger.warn("Couldn't mark store corrupted", e);
     */
    private boolean isMergeFailureDueToIOException(Exception failure, String reason) {
                UNASSIGNED_SEQ_NO,  
            try {  
                Releasables.close(searcher);
        return NO_OP_TRANSLOG_BATCH;
    /**
                        failure
     */  
                    return;  
     * @see #getIndexThrottleTimeInMillis()
            this.term = term;
     */  
    /**
    public abstract void maybePruneDeletes();
                return this == LOCAL_TRANSLOG_RECOVERY || this == LOCAL_RESET;  
            this.isRetry = isRetry;
            return reason;  
                    // we must set a failure exception, generate one if not supplied
    }
         * Returns operation start time in nanoseconds.
        }
                commitRef.close();  
        public long version() {
     * Re-reads the {@link PrimaryOperationPolicy} from {@link EngineConfig#getPrimaryOperationPolicy()},
        Map<String, Segment> segments = new HashMap<>();
            return true;
     * Must be matched by a later call to {@link #deactivateThrottling()}.
                    if (Lucene.isCorruptionException(failure)) {  
    }  
     *  
    /** Check whether the merge failure happened due to IOException. */  
    public GatedCloseable<SegmentInfos> getSegmentInfosSnapshot() {  
     * A Lock implementation that always allows the lock to be acquired
 * this file be licensed under the Apache-2.0 license or a
    protected final CountDownLatch closedLatch = new CountDownLatch(1);
     * A policy change alters sequence-number assignment, so callers must invoke this only while
         * @opensearch.api
                SegmentReader segmentReader = Lucene.segmentReader(ctx.reader());  
    /**
    }  
package org.opensearch.index.engine;
import org.apache.lucene.search.Sort;  
    public abstract void forceMerge(  
                    currentThrottleNS = 0;
 * Modifications Copyright OpenSearch Contributors. See
        private long ifPrimaryTerm = UNASSIGNED_PRIMARY_TERM;  
            long ifPrimaryTerm
        /**  
        public boolean isReadFromTranslog() {  
        public void unlock() {}  
        @PublicApi(since = "1.0.0")
        segment.docCount = segmentReader.numDocs();
    boolean assertSearcherIsWarmedUp(String source, SearcherScope scope) {
     */  
            long primaryTerm,  
     * {@code acquireThrottle} method to block on a lock when throttling
            maybeFailEngine("acquire_reader", ex);
    ) throws EngineException {
                    segment.committed = true;
            try (ReleasableLock lock = writeLock.acquire()) {  
        VersionType versionType,
        ExceptionsHelper.maybeError(maybeFatal).ifPresent(error -> {  
        }  
        }
    /**  
                logger.warn(
            this.wrapper = wrapper;  
            /*
    }
            super(Operation.TYPE.INDEX, failure, version, term, seqNo);
     *
     * <p>  
     * @see EngineConfig#getWarmer()
                // this must happen before we close IW or Translog such that we can check this state to opt out of failing the engine
     */
            try {
    protected final GetResult getFromSearcher(  
    public abstract Closeable acquireHistoryRetentionLock();
        long seqNo,  
            this(id, uid, seqNo, primaryTerm, version, versionType, origin, startTime, ifSeqNo, ifPrimaryTerm, null);  
        }
        }
        public long getTook() {  
            try {
        return false;  
        }
    public static final String SYNC_COMMIT_ID = "sync_id";  // TODO: remove sync_id in 3.0  
        private final Closeable onClose;  
    public final SearcherSupplier acquireSearcherSupplier(Function<Searcher, Searcher> wrapper) throws EngineException {
        private static final ReleasableLock NOOP_LOCK = new ReleasableLock(new NoOpLock());
     */
     * @param force         if <code>true</code> a lucene commit is executed even if no changes need to be committed.
        public Index(
         * due to it's append only nature.  
 *
        }  
                    + globalCheckpoint
    protected final EngineConfig engineConfig;  
        final GatedCloseable<SegmentInfos> segmentInfosRef = getSegmentInfosSnapshot();  
        segment.version = info.info.getVersion();  
        public Exception getFailure() {
import java.util.HashMap;
        }
         */  
         */
            Queries.newMatchAllQuery(),
    public abstract void deactivateThrottling();
        }
                final Directory finalDirectory = directory;  
        @Override
            }
        }
         */
            if (isThrottled()) {  
            throw new IllegalStateException(
            return operationType;
            } catch (IOException e) {
            long version,
                    get.getIfSeqNo(),  
    /**
     * Prepares an index operation by parsing the source document and creating an Engine.Index operation.
        Term uidTerm = new Term(IdFieldMapper.NAME, document.getField(IdFieldMapper.NAME).binaryValue());  
        return engineConfig.getIndexSettings().shouldCleanupUnreferencedFiles();  
                    );
            this.created = created;
                    segment.compound = info.info.getUseCompoundFile();  
        private GetResult(boolean exists, long version, DocIdAndVersion docIdAndVersion, Engine.Searcher searcher, boolean fromTranslog) {  
                        cleanUpUnreferencedFiles();  
    public abstract long getLastSyncedGlobalCheckpoint();
            } catch (IOException e) {  
        }
        public void lock() {}
            throw new EngineException(shardId, "failed to acquire reader", ex);
    /**  
            super(reader);
     * A replica shard receives a new max_seq_no_of_updates from its primary shard, then calls this method
 */
    protected final ReleasableLock writeLock = new ReleasableLock(rwl.writeLock());  
            VersionType versionType,  
                logger.warn(() -> new ParameterizedMessage("Error when trying to query fileLength [{}] [{}]", finalDirectory, file), e);
     * The underlying store is marked corrupted iff failure is caused by index corruption
     *
         *  
     */  
                }
        public Index(Term uid, long primaryTerm, ParsedDocument doc) {
            this.ifSeqNo = ifSeqNo;
                        segmentReader.getSegmentInfo()  
    /** How much heap is used that would be freed by a refresh.  Note that this may throw {@link AlreadyClosedException}. */  
            }
     *    immediately or never commit merges even though we shouldn't from a user perspective (this can also have funky side effects in
    public static class NoOpResult extends Result {  
        public IndexResult(Mapping requiredMappingUpdate) {
     * Lucene + other formats) should override this to return their native catalog snapshot.
        @Nullable String routing,
     * Tries to prune buffered deletes from the version map.  
    public abstract void writeIndexingBuffer() throws EngineException;  
        public Delete(  
                Origin.PRIMARY,  
            for (LeafReaderContext ctx : searcher.getIndexReader().getContext().leaves()) {  
            this.found = false;  
            Term uid,
         * Returns a positive timestamp if the ID of this document is auto-generated by opensearch.
                Versions.MATCH_ANY,
         * Returns <code>true</code> if this index requests has been retried on the coordinating node and can therefor be delivered
    }
    /**  
     * @param localSegmentsSizeMap post-refresh local segment file names mapped to their sizes in bytes  
        public boolean realtime() {  
        final String uuid = commitData.get(HISTORY_UUID_KEY);
        public abstract int estimatedSizeInBytes();  
                }
        // by default we don't have a writer here... subclasses can override this
                try {  
    /**  
                                    new IOException("failed engine (reason: [" + reason + "])", ExceptionsHelper.unwrapCorruption(failure))
     */  
     *  - we use the value for figuring out if the shard / engine is active so if we startup and no write has happened yet we still
        ) {  
        try {
import java.util.concurrent.atomic.AtomicBoolean;
        if (isClosed.get() == false) {
     * Checks if this engine should be flushed periodically.  
                UNASSIGNED_SEQ_NO,
            super(Operation.TYPE.DELETE, version, term, seqNo);  
            return ifPrimaryTerm;
     * {@literal seqno(O') > LCP >= MSU >= MSU(O)} which contradicts the first invariant. Furthermore in this case we immediately know
         **/  
        } catch (RuntimeException e) {
    }  
    public void updateUncommittedSegmentBytes(Map<String, Long> localSegmentsSizeMap, long flushThresholdBytes) {}
            return getMaxSeqNoFromSearcher(searcher);
        }
            return ifSeqNo;  
                searcher.getQueryCache(),
        for (String file : files) {  
     */
    /** get commits stats for the last commit */
        VersionType versionType,  
                    segment.attributes = info.info.getAttributes();
                // to add a negative number
    public Searcher acquireSearcher(String source, SearcherScope scope, Function<Searcher, Searcher> wrapper) throws EngineException {
     */  
            Origin origin,
 */  
        boolean accurateCount  
     * Returns the {@link CompletionStats} for this engine
        public List<Document> docs() {
     * inline exactly as today; only an engine that overrides it defers. {@link #flush()} appends the currently pending
         * if this property is non-negative indexing code might optimize the addition of this document
        VersionsAndSeqNoResolver.DocIdAndVersion docIdAndVersion = VersionsAndSeqNoResolver.loadDocIdAndVersion(
            }
     */  
        }
        }  
        private final boolean fromTranslog;
        public boolean isFound() {  
        long startTime = System.nanoTime();
                Origin.PRIMARY,
            return new GetResult(searcher, docIdAndVersion, false);
                        store.decRef();
        long autoGeneratedIdTimestamp,  
        this.shardId = engineConfig.getShardId();
     * @param fromSeqNo    from sequence number; included  
            } catch (IOException closeEx) {  
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
    public abstract boolean hasCompleteOperationHistory(String reason, long startingSeqNo);  
        }
     * @return {@link GatedCloseable} - A wrapper around a {@link SegmentInfos} instance that  
     * A note on the optimization using max_seq_no_of_updates_or_deletes:  
                template.seqNo(),  
        Objects.requireNonNull(engineConfig.getStore(), "Store must be provided to the engine");
import org.apache.lucene.index.IndexReader;  
    /**
        public TYPE operationType() {
    public static final String CAN_MATCH_SEARCH_SOURCE = "can_match";  
import org.opensearch.index.translog.Translog;  
        /**
            long startTime,
        DocumentMapperForType docMapper,
        private final long seqNo;
            this.term = UNASSIGNED_PRIMARY_TERM;  
import org.opensearch.index.merge.MergeStats;
    public boolean hasPendingMerges() {
    boolean shouldCleanupUnreferencedFiles() {
        public void close() {  
        final long globalCheckpoint = engineConfig.getGlobalCheckpointSupplier().getAsLong();
                    get.getIfPrimaryTerm(),
     * to advance this marker to at least the given sequence number.  
                        logger.trace(() -> new ParameterizedMessage("failed to get size for [{}]", info.info.name), e);
     * This class has been deprecated. See IndexingThrottler.java  
        public long getAutoGeneratedIdTimestamp() {
     * Notes this method returns the auto_id_timestamp of all append-only requests, not max_unsafe_auto_id_timestamp.
            return lock.acquire();
import org.opensearch.core.common.unit.ByteSizeValue;
import java.util.concurrent.locks.ReentrantLock;
     * retrieves the _seq_no of the retrieved document.
                    } finally {
        public Translog.Location getTranslogLocation() {
        }
        long ifPrimaryTerm  
    @PublicApi(since = "1.0.0")  
     */
            return created;
     * <p>
     * Returns the latest global checkpoint value that has been persisted in the underlying storage (i.e. translog's checkpoint)  
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {  
     * that do not opt in keep appending inline.
    /**
@PublicApi(since = "1.0.0")  
                if (failure != null) inner.addSuppressed(failure);  
            }
            super(Operation.TYPE.NO_OP, failure, 0, term, seqNo);
        }
 * Base OpenSearch Engine class
        Map<String, Long> map = new HashMap<>();
        }  
    }
     * continues. {@link #finish()} appends the final chunk and closes the scope.
            AlreadyClosedException ace = new AlreadyClosedException(shardId + " engine is closed", failedEngine.get());
    /**  
                    shardId,
    public MergedSegmentTransferTracker getMergedSegmentTransferTracker() {  
            logger.debug(
     * The Get result
        try (Searcher searcher = acquireSearcher("docStats", SearcherScope.INTERNAL)) {
            this.found = found;
                        throw new UncheckedIOException("failed to close", e);  
                throw error;
            }  
        final GatedCloseable<IndexCommit> commitRef = acquireLastIndexCommit(flushFirst);
        this.engineConfig = engineConfig;  
                    logger.warn(() -> new ParameterizedMessage("failed engine [{}]", reason), failure);  
        });  
     * Triggers a forced merge on this engine
     **/
            public String getLowercase() {
                }
        return 0;  
        /** Append the final pending chunk, close this scope, and return its greatest translog location. */
        public long primaryTerm() {
                        "Error when opening compound reader for Directory [{}] and " + "SegmentCommitInfo [{}]",
     *     <li> I1: There is no operation on docID(O) with seqno that is {@literal > MSU(O) and < seqno(O)} </li>  
        }
                : "cas operations are only allowed if origin is primary. get [" + origin + "]";  
            this.primaryTerm = primaryTerm;
    public abstract List<Segment> segments(boolean verbose);
        flush(false, false);  
        void warm(OpenSearchDirectoryReader reader);
    public MergeStats getMergeStats() {
         *  
            long seqNo,
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
    }  
            logger.error(() -> new ParameterizedMessage("failed to acquire reader"), ex);
         * use in case of the delete operation failed before getting to internal engine
     * @see Operation#startTime()
    public abstract long getIndexThrottleTimeInMillis();
            SearcherSupplier reader = new SearcherSupplier(wrapper) {
     */
 * not use this file except in compliance with the License.
                searcher.getSimilarity(),
            )
                    e
        public void freeze() {  
        }
            super(Operation.TYPE.NO_OP, 0, term, seqNo);  
    public static final String MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID = "max_unsafe_auto_id_timestamp";
    /**
        }  
                    fillSegmentInfo(segmentReader, verbose, false, segments);
                try {
            long version,
        }  
        ParsedDocument doc = docMapper.getDocumentMapper().parse(source);  
                fillSegmentInfo(Lucene.segmentReader(ctx.reader()), verbose, true, segments);  
                }
     * Returns the <code>true</code> iff this engine is currently under index throttling.
        }
    /**
    public static final String HISTORY_UUID_KEY = "history_uuid";
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
     * a lucene commit if nothing needs to be committed.  
        final Term uid = new Term(IdFieldMapper.NAME, Uid.encodeId(id));
        }
            long ifSeqNo,
    public abstract GatedCloseable<IndexCommit> acquireLastIndexCommit(boolean flushFirst) throws EngineException;  
     * @opensearch.api  
     * engines that never serve primary-origin operations.  
            this(uid, primaryTerm, doc, Versions.MATCH_ANY);  
                    () -> new ParameterizedMessage("Tried to query fileLength but file is gone [{}] [{}]", finalDirectory, file),
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
 *  
        } else {
            new Sort(new SortField(SeqNoFieldMapper.NAME, SortField.Type.LONG, true))  
            }
    public void close() throws IOException {  
            }  
    @Nullable
        private final Exception failure;  
        /**  
            assert (origin == Origin.PRIMARY) == (versionType != null) : "invalid version_type=" + versionType + " for origin=" + origin;
         * Get the sequence number on the primary.
            this.resultType = Type.MAPPING_UPDATE_REQUIRED;  
        final long maxSeqNo = getSeqNoStats(globalCheckpoint).getMaxSeqNo();  
            final CatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(infos);
        // we use the engine class directly here to make sure all subclasses have the same logger name  
        return new GatedCloseable<>(getLatestSegmentInfos(), () -> {});
        private final long version;  
        Engine.Operation.Origin origin,  
        private final String id;
                // again on any caught AlreadyClosedException  
            try (ReleasableLock lock = writeLock.acquire()) {
            try {
            SegmentCommitInfo info = segmentReader.getSegmentInfo();
     * per-operation translog path would have thrown, and the engine is consulted exactly as for a per-operation
    }  
    public static class Get {
            final SegmentInfos infos = Lucene.readSegmentInfos(commitRef.get());  
     *  
        /** Activate throttling, which switches the lock to be a real lock */
     */
     */
        @Override  
        SearcherSupplier releasable = null;
            Thread.currentThread().interrupt();  
        } catch (IOException e) {  
            uid,  
            // remove all unreferenced files
     * Snapshots the most recent safe index commit from the engine.  
    /**
        Segment[] segmentsArr = segments.values().toArray(new Segment[0]);  
     */  
     *  
     *    consider it active for the duration of the configured active to inactive period. If we initialize to 0 or Long.MAX_VALUE we
            null
        @Override
    public static final String MIN_RETAINED_SEQNO = "min_retained_seq_no";  
            return took;
        for (LeafReaderContext readerContext : indexReader.leaves()) {
        public int estimatedSizeInBytes() {
        }
                primaryTerm,
            Releasables.close(searcher);
        return new CommitStats(getLastCommittedSegmentInfos());
     *
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
     * @param autoGeneratedIdTimestamp the timestamp for auto-generated IDs
            uidTerm,  
     * For each operation O, the key invariants are:
import org.opensearch.common.logging.Loggers;
            .setMergePolicy(NoMergePolicy.INSTANCE)
     */
            FAILURE,  
    }  
                    segment.delDocCount = info.getDelCount() + info.getSoftDelCount();  
                    logger.warn(
    private final CounterMetric totalUnreferencedFileCleanUpsPerformed = new CounterMetric();  
        public boolean tryLock() {
        }
    public long unreferencedFileCleanUpsPerformed() {
     * or the sequence number from {@link #advanceMaxSeqNoOfUpdatesOrDeletes(long)}. An index request is considered  
     * settings by the time it is promoted.
                id,  
        }
                    // this must happen first otherwise we might try to reallocate so quickly  
    ) throws EngineException, IOException;
    }
        @Override
        public Delete(  
     */
                UNASSIGNED_SEQ_NO,
        }
            return ifSeqNo;
            ifPrimaryTerm
                        if (store.tryIncRef()) {
            this(
    public static class Delete extends Operation {
        }
     * @opensearch.internal
     * @deprecated Use {@link #acquireSafeCatalogSnapshot()} which avoids the extra
            return true;  
    }
    /**
        }
                // don't bubble up these exceptions up
        SegmentCommitInfo info = segmentReader.getSegmentInfo();  
        public DirectoryReader getDirectoryReader() {
    /**
            } else {
        private final boolean realtime;
        // to external refreshes. For instance we don't refresh an external searcher if we flush and indices with
     * Returns the {@link DocsStats} for this engine  
        long fromSeqNo,  
        boolean isRetry,
            return fromTranslog;  
        }
        if (lastCommittedSegmentInfos != null) {
        }
                    }
     * in Lucene. To avoid this we check the local checkpoint tracker to see if an operation was already processed.
     * In contrast to {@link #getLatestSegmentInfos()}, which returns a {@link SegmentInfos}  
    public abstract void refresh(String source) throws EngineException;  
    /**  
                logger.error("failed to access searcher manager", e);  
        }  
     * Get operation
        return Collections.unmodifiableMap(map);  
     * {@link #updateUncommittedSegmentBytes(Map, long)}.
    public abstract SafeCommitInfo getSafeCommitInfo();
        writerSegmentStats(stats);  
                                () -> new ParameterizedMessage(
                );  
     */
    }
            long ifSeqNo,  
                        referenceManager.release(acquire);
     *  
     * Publishes the total size of segment bytes not yet referenced by the last commit point, computed from the  
                template.uid(),
            Releasables.close(releasable);
                        segmentReader.directory(),
        } catch (Exception ex) {
         * @opensearch.api
        return new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(sizeInBytes).build();
     *    either immediately or never mark it inactive if no writes at all happen to the shard.  
    /**  
                    segment.segmentSort = info.info.getIndexSort();  
            assert (origin == Origin.PRIMARY) == (versionType != null) : "invalid version_type=" + versionType + " for origin=" + origin;
        public DeleteResult(Exception failure, long version, long term) {
    protected final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
                        segmentReader,
    public abstract IndexResult index(Index index) throws IOException;
            long ifPrimaryTerm
    }
                    } catch (AlreadyClosedException ex) {  
        public Delete(Delete template, VersionType versionType) {
                                failure
            long throttleTimeNS = System.nanoTime() - startOfThrottleNS;
        private final long version;
              store. this violates the assumption that all files are closed when
     */
            ensureOpen(ex); // throw EngineCloseException here if we are already closed  
        }  
            if (released.get()) {
                return lock.isHeldByCurrentThread();
     * Note: this time might not be absolutely accurate since the {@link Operation#startTime()} is used which might be
            }
    /**
     * Propagates {@link IOException} as-is so callers (e.g. shard-store fetch on corrupted
        }
        long numDocs = 0;
        @Override
        }
     * Default returns {@code 0}; engines with a running-merges accessor (e.g.,
                template.id(),
     *
    public Engine.Index prepareIndex(
     * construction; {@link InternalEngine} overrides it to drive its uncommitted-segment-bytes flush condition.
     */
     *     <li> I2: If {@literal MSU(O) < seqno(O)} then docID(O) did not exist when O was applied; more precisely, if there is any O'
                searcher.getQueryCachingPolicy(),  
     * document specific failures  
        } else {  
        BiFunction<String, SearcherScope, Engine.Searcher> searcherFactory,
     * @param delete operation to perform
                this.lowercase = this.toString().toLowerCase(Locale.ROOT);
        @Override  
    @PublicApi(since = "3.0.0")
    }
     * {@link DocumentIndexWriter}) override.  
            return ifPrimaryTerm;  
                return this == PEER_RECOVERY || this == LOCAL_TRANSLOG_RECOVERY;
        segment.search = search;  
        return DefaultPrimaryOperationPolicy.INSTANCE;
            Origin origin,
    }  
    }
    protected abstract SegmentInfos getLastCommittedSegmentInfos();
                                    reason  
        }
            long startTime,
            return id().length() * 2 + source().length() + 12;  
        SearcherScope scope  
        return true;
            Origin origin,  
            return ifPrimaryTerm;
            }
        long ifSeqNo,
     * Gets the minimum retained sequence number for this engine.  
 */
            }  
            return docIdAndVersion;
import org.opensearch.index.mapper.SeqNoFieldMapper;
                    segment.docCount = info.info.maxDoc() - segment.delDocCount;
        public String id() {
     * search-visible state rather than the on-disk safe commit.  
        public @Nullable String routing() {
                        engineConfig.getQueryCachingPolicy(),
        if (failure != null) {
        org.apache.lucene.document.Document document = searcher.storedFields().document(docs[0].doc);
    /**
            return autoGeneratedIdTimestamp;  
                ),  
    }
            if (isThrottled() && startOfThrottleNS != 0) {  
     * remote-specific -- only the publisher (the remote segment upload path) is. The default is a no-op so that
                currentThrottleNS += System.nanoTime() - startOfThrottleNS;
                    () -> new ParameterizedMessage(  
        if (store.tryIncRef() == false) {
    private Map<String, Long> getSegmentFileSizes(SegmentReader segmentReader) {  
                    // Paranoia (System.nanoTime() is supposed to be monotonic): time slip must have happened, have to ignore this value  
        if (useCompoundFile) {  
import org.opensearch.core.index.shard.ShardId;
            logger.trace("flushAndClose now acquire writeLock");  
     *    meaning that the O' was a delete.  
     * Begin a translog batch for the current bulk-request execution scope. The default is a no-op batch, so engines  
    public abstract GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException;  
     * Reverses a previous {@link #activateThrottling} call.  
import org.apache.lucene.index.NoMergePolicy;
        private final boolean isRetry;
        private final Engine.Searcher searcher;
     * @param versionType the version type
            this.seqNo = seqNo;
        private final long seqNo;
     * engines which never publish (e.g. {@link NRTReplicationEngine}, read-only engines) are correct by  
        public void close() {  
        String forceMergeUUID  
        private final long primaryTerm;  
     *
        Segment segment = new Segment(info.info.name);
     * 2. Also {@literal MSU(O) <= MSU <= LCP < seqno(O)} (we discard O if {@literal seqno(O) <= LCP}) so the second invariant applies,
            } finally {  
        private Translog.Location translogLocation;  
    protected TranslogDeletionPolicy getTranslogDeletionPolicy(EngineConfig engineConfig) {
        }
            try {
    @Nullable
            origin,  
            Similarity similarity,
        }
            }  
                    + shardId
    public abstract long getIndexBufferRAMBytesUsed();
            throw new UnsupportedOperationException("NoOpLock can't provide a condition");
    /**
        }
import org.opensearch.common.util.concurrent.ReleasableLock;
    public final Searcher acquireSearcher(String source) throws EngineException {
                }
            this.resultType = Type.FAILURE;
                }
        }
         */
        @Nullable
            QueryCache queryCache,  
                    segment.search = false;
        stats.add(1);
                    + "] on index shard "
    /**  
        }
    /**  
        } finally {  
         * If the operation was aborted due to missing mappings, this method will return the mappings  
        }
     * Cleanup all unreferenced files generated during failed segment merge. This resets shard state to last Lucene
     * @opensearch.api
import org.opensearch.index.seqno.SequenceNumbers;
        public long getVersion() {  
        }
        }
import org.apache.lucene.search.ScoreDoc;
            return isRetry;
    /**
     * @return {@link SegmentInfos}  
     * @opensearch.api
     * noop operation
                segmentName.add(segmentReader.getSegmentName());  
     *  - we also use this to flush big-ass merges on an inactive engine / shard but if we we initialize 0 or Long.MAX_VALUE we either
        public enum Type {
            long ifSeqNo,  
     * Called when our engine is using too much heap and should move buffered indexed/deleted documents to disk.  
                template.version(),
                doClose();
            } catch (NoSuchFileException | FileNotFoundException e) {
     * This feature requires soft-deletes enabled. If soft-deletes are disabled, this method will throw an {@link IllegalStateException}.
                null
                        flush();
     * document specific failures
    }
     */
            this.uid = uid;  
            this.created = false;
     */  
        ) {  
                    // shard state back to last Lucene Commit.  
 *
        }
            throw new UnsupportedOperationException();
    public interface TranslogBatch {
    }
     * resulting {@link SegmentInfos} as a {@link SegmentInfosCatalogSnapshot}. Engines whose  
 * Unless required by applicable law or agreed to in writing,
        if (docIdAndVersion != null) {
     * Perform document index operation on the engine  
                }
            totalUnreferencedFileCleanUpsPerformed.inc();  
                files = directory.listAll();
                    shardId,
     * @param flushFirst indicates whether the engine should flush before returning the snapshot
        abstract String id();
        long primaryTerm,
        );  
        try (Searcher searcher = acquireSearcher("segments_stats", SearcherScope.EXTERNAL)) {
            return this.doc.source();
    }  
}
     *
        final Engine.Searcher searcher = searcherFactory.apply("get", scope);
            long autoGeneratedIdTimestamp,
     */
     * Forces this engine to advance its max_unsafe_auto_id_timestamp marker to at least the given timestamp.
        final GatedCloseable<IndexCommit> commitRef = acquireSafeIndexCommit();
import org.opensearch.index.merge.MergedSegmentTransferTracker;  
            this.readFromTranslog = readFromTranslog;  
        final DocIdAndVersion docIdAndVersion;  
            public boolean isFromTranslog() {
            numDocs += readerContext.reader().numDocs();
            if (throttleTimeNS >= 0) {  
        public boolean isRetry() {
            super(Operation.TYPE.INDEX, requiredMappingUpdate);  
    /**
        String id,
            return this;  
    public interface Warmer {
     * Holds result meta data (e.g. translog location, updated version)  
        SegmentsStats stats = new SegmentsStats();
        } // TEST ONLY  
         * that are required to complete the operation.
            this.realtime = realtime;  
import java.util.Locale;
    }
            this(true, docIdAndVersion.version, docIdAndVersion, searcher, fromTranslog);  
    /**
                logger.warn(
                return directoryReader;  
    protected void awaitPendingClose() {
                } finally {  
                VersionType.INTERNAL,
            logger.trace(() -> new ParameterizedMessage("failed to get size for [{}]", info.info.name), e);
            return new GatedCloseable<>(snapshot, commitRef::close);
     * <p>The default implementation bridges via {@link #getSegmentInfosSnapshot()} and wraps the
         */  
     * @param source       source of the request
        /** get document failure while executing the operation {@code null} in case of no failure */  
    }
    /**
            this.requiredMappingUpdate = null;  
     * The engine will disable optimization for all append-only whose timestamp at most {@code newTimestamp}.  
 * The OpenSearch Contributors require contributions made to  
        return null;
     *                      Otherwise this call will return without blocking.
    /**
     */
     */  
            SUCCESS,
     *
    protected abstract ReferenceManager<OpenSearchDirectoryReader> getReferenceManager(SearcherScope scope);
            Searcher searcher = reader.acquireSearcher(source);
    public Engine.Delete prepareDelete(
                files = segmentReader.getSegmentInfo().files().toArray(new String[] {});  
                ace.addSuppressed(suppressed);
     *
            ifSeqNo,
    public abstract long getWritingBytes();
     * Moreover, operations that are optimized using the MSU optimization must not be processed twice as this will create duplicates  
            return this.id;
    protected final Logger logger;
        long ifSeqNo,
            true,
import org.opensearch.search.suggest.completion.CompletionStats;
    }
import org.apache.lucene.index.SegmentCommitInfo;
        long toSeqNo,
                    assert assertSearcherIsWarmedUp(source, scope);
    public abstract TranslogManager translogManager();  
     * @param index operation to perform
