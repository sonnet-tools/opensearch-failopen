    public void refresh(String source) throws EngineException {
    public boolean refreshNeeded() {
        Engine.Operation.Origin origin,
    }
        this.engine = engine;
        long ifSeqNo,
                "EngineBackedIndexer.finalizeReplication expected NRTReplicationEngine + SegmentInfosCatalogSnapshot, got engine="
        return engine.refreshNeeded();
    }
        String source,
    public long getProcessedLocalCheckpoint() {
    }
    public Engine getEngine() {
        engine.refresh(source);
     * decision must be forwarded here; the {@link Indexer} default would silently keep every operation inline.
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {
        return engine.acquireSafeCatalogSnapshot();
        String id,
        long primaryTerm,
 */
    }
import org.opensearch.common.concurrent.GatedCloseable;
        return 0;
        engine.close();
        engine.writeIndexingBuffer();
    }
    }
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {
    @Override
/**
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
        return engine instanceof NRTReplicationEngine;
 *
    public SafeCommitInfo getSafeCommitInfo() {
        boolean upgradeOnlyAncientSegments,
        engine.deactivateThrottling();
    }
import org.opensearch.search.suggest.completion.CompletionStats;
    @Override
        long ifPrimaryTerm
        return engine.acquireHistoryRetentionLock();
    }
    @Override
    }
    @Override
    }
    ) {
     * {@link org.opensearch.index.engine.NRTReplicationEngine}. For non-replica engines
 */
    public long getWritingBytes() {
                    + engine.getClass().getName()
        return engine.newChangesSnapshot(source, fromSeqNo, toSeqNo, requiredFullRange, accurateCount);
    public List<Segment> segments(boolean verbose) {
    public Engine.Index prepareIndex(
     */
    @Override
    }
        engine.flushAndClose();
    @Override
    }
    }
     */
        engine.forceMerge(flush, maxNumSegments, onlyExpungeDeletes, upgrade, upgradeOnlyAncientSegments, forceMergeUUID);
    }
    public boolean isReplicaIndexer() {
        return Indexer.super.lastRefreshedCheckpoint();
        return engine.delete(delete);
    @Override
            ifSeqNo,
    }
    }
    @Override
        return engine.prepareIndex(
        throw new UnsupportedOperationException("acquireReader is not supported in EngineBackedIndexer");
    }
     * (e.g., {@link org.opensearch.index.engine.InternalEngine}) this returns false.
        engine.flush(force, waitIfOngoing);
    public int getActiveMergeCount() {
        return engine.completionStats(fieldNamePatterns);
        return engine.segments(verbose);
        return engine.getMaxSeqNoOfUpdatesOrDeletes();
    @Override
    }
    @Override
        return engine.acquireLastCommittedSnapshot(flushFirst);
            );
    public Engine.GetResult getById(Engine.Get get, BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory)
import org.apache.lucene.store.ByteBuffersDataOutput;
            primaryTerm,
        // For now we throw an exception as this is not yet implemented
    @Override
    }
    public void forceMerge(
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
        return engine.shouldPeriodicallyFlush();
        return engine.getMinRetainedSeqNo();
    @Override
    }
    @Override
import org.opensearch.index.seqno.SeqNoStats;
    @Override
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {
    @Override
    public EngineConfig config() {
    @Override
        SourceToParse source,
    }
    public void flush(boolean force, boolean waitIfOngoing) throws EngineException {
            isRetry,
        long toSeqNo,
        return engine.get(get, searcherFactory);
    public byte[] serializeSnapshotToRemoteMetadata(CatalogSnapshot catalogSnapshot) throws IOException {
        return engine.commitStats();
import org.apache.lucene.store.ByteBuffersIndexOutput;
        return engine.getHistoryUUID();
    }
            "EngineBackedIndexer expects SegmentInfosCatalogSnapshot but got: " + catalogSnapshot.getClass().getName()
    public boolean shouldPeriodicallyFlush() {
    @Override
    @Override
     * source is a non-Lucene indexer (e.g. {@link DataFormatAwareEngine}).
    }
     */
    private final Engine engine;
    public MergeStats getMergeStats() {
        return engine.getPrimaryOperationPolicy();
    @Override
        return engine.getSeqNoStats(globalCheckpoint);
import org.opensearch.index.mapper.SourceToParse;
        long seqNo,
        VersionType versionType,
    @Override
    @Override
    }
        engine.refreshPrimaryOperationPolicy();
    @Override
    public PrimaryOperationPolicy getPrimaryOperationPolicy() {
     * Replica detection delegates to the wrapped {@link Engine}: true only when it's an
        return engine.getActiveMergeCount();
        VersionType versionType,
    }
    }
        return engine.getMaxSeenAutoIdTimestamp();
    public TranslogManager translogManager() {
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        return engine.unreferencedFileCleanUpsPerformed();
                    + ", snapshot="
    /**
    public long currentOngoingRefreshCheckpoint() {
                    + catalogSnapshot.getClass().getName()
    }
        String routing,
    @Override
    }
    }
import org.opensearch.index.shard.DocsStats;
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {
    public Engine.NoOpResult noOp(Engine.NoOp noOp) throws IOException {
    }
     * {@link org.opensearch.index.shard.IndexShard} reaches engines only through this indexer, so the engine's batching
    }
        return engine.prepareDelete(id, routing, seqNo, primaryTerm, version, versionType, origin, ifSeqNo, ifPrimaryTerm);
    public CommitStats commitStats() {
            versionType,
    public PollingIngestStats pollingIngestStats() {
    public long getMaxSeqNoOfUpdatesOrDeletes() {
            return out.toArrayCopy();
    @Override
    }
    @Override
    @Override
import java.util.List;
    }
    ) {
        long primaryTerm,
 * The OpenSearch Contributors require contributions made to
    public void failEngine(String reason, Exception failure) {
    @Override
            autoGeneratedIdTimestamp,
    public long getLastWriteNanos() {
        return engine.hasCompleteOperationHistory(reason, startingSeqNo);
    public EngineBackedIndexer(Engine engine) {
    @Override
    public boolean hasPendingMerges() {
        return engine.getLastSyncedGlobalCheckpoint();
    public long getNativeBytesUsed() {
    public Engine.DeleteResult delete(Engine.Delete delete) throws IOException {
        engine.updateMaxUnsafeAutoIdTimestamp(newTimestamp);
/*
        );
            throw new IllegalStateException(
    @Override
            version,
     * {@link Engine#acquireSnapshot()} so subclasses (e.g. the read-only wrapper used during
    public long getPersistedLocalCheckpoint() {
        boolean flush,
    @Override
    }
     */
import org.opensearch.common.unit.TimeValue;
    @Override
    @Override
    public void flushAndClose() throws IOException {
    public long lastRefreshedCheckpoint() {
import org.opensearch.indices.pollingingest.PollingIngestStats;
    @ExperimentalApi
            docMapper,
        );
        long ifPrimaryTerm
        }
        boolean isRetry,
    ) {
    }
    }
    public boolean isThrottled() {
        return engine.prepareDelete(id, seqNo, primaryTerm, version, versionType, origin, ifSeqNo, ifPrimaryTerm);
    }
            sicSnapshot.getSegmentInfos().write(new ByteBuffersIndexOutput(out, "Snapshot of SegmentInfos", "SegmentInfos"));
    }
        long seqNo,
import org.opensearch.core.common.unit.ByteSizeValue;
import java.util.function.BiFunction;
            seqNo,
        if (engine instanceof InternalEngine) {
        if (engine instanceof InternalEngine) {
    }
    @Override
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    @Override
        return engine.countNumberOfHistoryOperations(source, fromSeqNo, toSeqNumber);
    @Override
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException {
    public long getHeapBytesUsed() {
    @Override
    @Override
import org.opensearch.index.translog.TranslogManager;
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
    }
    @Override
        throw new IllegalStateException(
    }
    ) throws IOException {
        return engine.hasPendingMerges();
    }
        return engine.translogManager();
    public Translog.Snapshot newChangesSnapshot(
    }
    public long getMinRetainedSeqNo() {
    }
    }
    public GatedCloseable<Reader> acquireReader() throws IOException {
        boolean requiredFullRange,
    @Override
import org.opensearch.index.engine.exec.Indexer;
        return engine.isThrottled();
 * SPDX-License-Identifier: Apache-2.0
    @Override
    @Override
    @Override
        throws IOException {
        DocumentMapperForType docMapper,
    }
        // TODO: Replace with a reader backed by segment infos catalog snapshot and Lucene's Directory reader.
    @Override
     * shards, so any other engine/snapshot combination is a wiring bug.
     * engine reset) can route to a different snapshot source without going through the
    public String getHistoryUUID() {
 * @opensearch.experimental
     * Applies received segment state to the replica engine. This indexer only wraps Lucene-backed
        return engine;
    @Override
import org.opensearch.index.VersionType;
    @Override
        return engine.getLastWriteNanos();
        }
            source,
        String forceMergeUUID
            origin,
        engine.flush();
 * An indexer implementation that uses an engine to perform indexing operations.
            return ((InternalEngine) engine).lastRefreshedCheckpoint();
    }
    }
    public CompletionStats completionStats(String... fieldNamePatterns) {
        return engine.getWritingBytes();
            return ((InternalEngine) engine).currentOngoingRefreshCheckpoint();
        return engine.config();
        return Indexer.super.currentOngoingRefreshCheckpoint();
        return engine.docStats();
        if (catalogSnapshot instanceof SegmentInfosCatalogSnapshot sicSnapshot) {
    }
            nrtEngine.updateSegments(siSnapshot.getSegmentInfos());
    @Override
    }
    @Override
        Engine.Operation.Origin origin,
        long primaryTerm,
    /** Engine-backed indexer uses only JVM heap for indexing buffers, no native memory. */
        int maxNumSegments,
    public Engine.Delete prepareDelete(
        long ifSeqNo,
    }
    }
        long autoGeneratedIdTimestamp,
        } else {
    public void ensureOpen() {
        return engine.acquireSafeIndexCommit();
    }
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {
        boolean accurateCount
        long fromSeqNo,
    /** Engine-backed get-by-id: delegates to {@link Engine#get(Engine.Get, BiFunction)} with {@code searcherFactory}. */
    public int fillSeqNoGaps(long primaryTerm) throws IOException {
    public void writeIndexingBuffer() throws EngineException {
        }
    }
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
        }
        return engine.getMergeStats();
    }
    @Override
import org.opensearch.index.translog.Translog;
        long ifSeqNo,
        engine.failEngine(reason, failure);
    /**
    @Override
        long version,
     * Returns a snapshot of the catalog of segments in this engine. Delegates to
        if (engine instanceof NRTReplicationEngine nrtEngine && catalogSnapshot instanceof SegmentInfosCatalogSnapshot siSnapshot) {
    }
import org.opensearch.index.mapper.DocumentMapperForType;
import java.io.Closeable;
    public boolean maybeRefresh(String source) {
    @Override
    public Closeable acquireHistoryRetentionLock() {
    @Override
    public void close() throws IOException {
    /**
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {
    @Override
    /**
        boolean onlyExpungeDeletes,
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
 * compatible open source license.
        return engine.acquireSnapshot();
    @Override
    ) throws EngineException, IOException {
    public void flush() {
    }
}
    @Override
        String id,
    @Override
    }
    }
        engine.activateThrottling();
        long version,
import org.apache.lucene.index.IndexCommit;
    @Override
    public long getMaxSeenAutoIdTimestamp() {
    @Override
package org.opensearch.index.engine;
    public long unreferencedFileCleanUpsPerformed() {
    public GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException, IOException {
    public Engine.TranslogBatch beginTranslogBatch() {
    public void maybePruneDeletes() {
        engine.ensureOpen();
        return engine.getIndexBufferRAMBytesUsed();
        return engine.fillSeqNoGaps(primaryTerm);
    public long getIndexThrottleTimeInMillis() {
    public DocsStats docStats() {
    @Override
        return engine.noOp(noOp);
    @Override
    }
        return engine.index(index);
import org.opensearch.index.merge.MergeStats;
        long version,
        engine.maybePruneDeletes();
    }
    }
        long ifPrimaryTerm
    public void finalizeReplication(CatalogSnapshot catalogSnapshot) throws IOException {
        Engine.Operation.Origin origin,
    }
        boolean upgrade,
    public void deactivateThrottling() {
    }
    @Override
    @Override
    }
        return engine.segmentsStats(includeSegmentFileSizes, includeUnloadedSegments);
    }
        return engine.beginTranslogBatch();
            ifPrimaryTerm
    }
        long seqNo,
    }
        return engine.getProcessedLocalCheckpoint();
    @Override
    public Engine.Delete prepareDelete(
    @Override
    @Override
 *
    @Override
    }
    @Override
        engine.onSettingsChanged(translogRetentionAge, translogRetentionSize, softDeletesRetentionOps);
    @Override
    @Override
        engine.verifyEngineBeforeIndexClosing();
    }
        engine.advanceMaxSeqNoOfUpdatesOrDeletes(maxSeqNoOfUpdatesOnPrimary);
    public long getLastSyncedGlobalCheckpoint() {
    public void refreshPrimaryOperationPolicy() {
    public void activateThrottling() {
    public Engine.IndexResult index(Engine.Index index) throws IOException {
        return engine.getIndexThrottleTimeInMillis();
        return engine.getSafeCommitInfo();
    @Override
    }
        return engine.pollingIngestStats();
    @Override
            ByteBuffersDataOutput out = new ByteBuffersDataOutput();
@ExperimentalApi
        return engine.maybeRefresh(source);
    }
        return engine.getPersistedLocalCheckpoint();
public class EngineBackedIndexer implements Indexer {
        VersionType versionType,
    }
    @Override
     * {@link Engine#getSegmentInfosSnapshot()} bridge — which is required when the underlying
import org.opensearch.common.annotation.ExperimentalApi;
