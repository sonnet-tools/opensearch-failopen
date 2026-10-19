        return engine.segmentsStats(includeSegmentFileSizes, includeUnloadedSegments);
    @Override
    @Override
    ) {
        engine.flush();
    public void writeIndexingBuffer() throws EngineException {  
    public EngineConfig config() {  
            return ((InternalEngine) engine).lastRefreshedCheckpoint();
    }  
    }  
            origin,
    }  
    }
        engine.onSettingsChanged(translogRetentionAge, translogRetentionSize, softDeletesRetentionOps);
        long toSeqNo,
        );  
            );
    @Override
import org.opensearch.index.shard.DocsStats;
    }
    public void refresh(String source) throws EngineException {
 * @opensearch.experimental  
    @Override  
        return engine.getLastSyncedGlobalCheckpoint();
    /**
    public void activateThrottling() {  
     * {@link Engine#getSegmentInfosSnapshot()} bridge — which is required when the underlying  
        throws IOException {
    /**
        engine.activateThrottling();
        boolean flush,
        }
    }  
        long primaryTerm,
    ) {
        int maxNumSegments,  
import org.opensearch.index.translog.Translog;
     * {@link org.opensearch.index.shard.IndexShard} reaches engines only through this indexer, so the engine's batching
    public int getActiveMergeCount() {  
            "EngineBackedIndexer expects SegmentInfosCatalogSnapshot but got: " + catalogSnapshot.getClass().getName()
    }
    public Closeable acquireHistoryRetentionLock() {
    @Override
    public boolean shouldPeriodicallyFlush() {
    public void failEngine(String reason, Exception failure) {
        return engine.acquireSafeIndexCommit();
        engine.forceMerge(flush, maxNumSegments, onlyExpungeDeletes, upgrade, upgradeOnlyAncientSegments, forceMergeUUID);  
        return engine.isThrottled();
/*  
        return engine.get(get, searcherFactory);  
    @Override
    @Override  
    }  
    }
        engine.deactivateThrottling();  
    @Override
    public boolean maybeRefresh(String source) {
        DocumentMapperForType docMapper,
    public Engine.GetResult getById(Engine.Get get, BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory)
        boolean onlyExpungeDeletes,
    public Engine.DeleteResult delete(Engine.Delete delete) throws IOException {
import java.util.function.BiFunction;
        if (engine instanceof InternalEngine) {
        long fromSeqNo,  
    }
    @Override  
    public GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException, IOException {
            return out.toArrayCopy();
    public Engine getEngine() {
    }
    public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {  
import org.opensearch.common.annotation.ExperimentalApi;
        return engine.newChangesSnapshot(source, fromSeqNo, toSeqNo, requiredFullRange, accurateCount);
        return engine.acquireHistoryRetentionLock();  
    public List<Segment> segments(boolean verbose) {
     * engine reset) can route to a different snapshot source without going through the
        long primaryTerm,
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        return engine.getIndexThrottleTimeInMillis();  
        return engine.maybeRefresh(source);  
    }
    }
    }
    public PrimaryOperationPolicy getPrimaryOperationPolicy() {
        }  
        SourceToParse source,
    public void flush(boolean force, boolean waitIfOngoing) throws EngineException {
        if (engine instanceof NRTReplicationEngine nrtEngine && catalogSnapshot instanceof SegmentInfosCatalogSnapshot siSnapshot) {
    }
     * Applies received segment state to the replica engine. This indexer only wraps Lucene-backed  
    }
            ifSeqNo,
    }
    public int fillSeqNoGaps(long primaryTerm) throws IOException {
        return engine.translogManager();
        VersionType versionType,  
    public void forceMerge(
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
        throw new IllegalStateException(
    public Engine.Index prepareIndex(  
    @Override
    public long getIndexThrottleTimeInMillis() {
    }  
    @Override  
        return engine.acquireSafeCatalogSnapshot();
        boolean requiredFullRange,
     * {@link org.opensearch.index.engine.NRTReplicationEngine}. For non-replica engines  
    }  
        throw new UnsupportedOperationException("acquireReader is not supported in EngineBackedIndexer");
        return engine.getProcessedLocalCheckpoint();
        return engine.getIndexBufferRAMBytesUsed();
    }
    public SeqNoStats getSeqNoStats(long globalCheckpoint) {
    @Override  
        return engine.getWritingBytes();
 * SPDX-License-Identifier: Apache-2.0
        return engine.config();
        VersionType versionType,
    }
import org.opensearch.core.common.unit.ByteSizeValue;
    }  
        return engine.refreshNeeded();  
        if (engine instanceof InternalEngine) {  
                "EngineBackedIndexer.finalizeReplication expected NRTReplicationEngine + SegmentInfosCatalogSnapshot, got engine="  
        return engine.prepareIndex(
    @Override  
        return engine.shouldPeriodicallyFlush();  
            version,  
    @Override
    }
    public PollingIngestStats pollingIngestStats() {  
    }  
        long version,  
import org.opensearch.search.suggest.completion.CompletionStats;
    }  
    }
        long ifSeqNo,  
        long seqNo,  
}
    }
    @Override
    public CompletionStats completionStats(String... fieldNamePatterns) {
        return engine.getLastWriteNanos();  
    }
    public Engine.IndexResult index(Engine.Index index) throws IOException {  
    /** Engine-backed indexer uses only JVM heap for indexing buffers, no native memory. */
 */  
        Engine.Operation.Origin origin,
    }
    @Override
        return 0;
    public long lastRefreshedCheckpoint() {
    public DocsStats docStats() {
     */
    public void close() throws IOException {
    @Override
        return engine.unreferencedFileCleanUpsPerformed();
    public int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException {  
        return engine.index(index);
        return engine.pollingIngestStats();
    @Override
            versionType,
    }
    @Override
        Engine.Operation.Origin origin,
 * An indexer implementation that uses an engine to perform indexing operations.
     * {@link Engine#acquireSnapshot()} so subclasses (e.g. the read-only wrapper used during
    }
            seqNo,
    }
        return engine.getActiveMergeCount();
        return engine.getMaxSeenAutoIdTimestamp();
    }
    /**
        engine.ensureOpen();
        return engine.completionStats(fieldNamePatterns);
import org.opensearch.index.mapper.DocumentMapperForType;  
    public long getNativeBytesUsed() {
            throw new IllegalStateException(
    }
 * compatible open source license.
import org.opensearch.index.mapper.SourceToParse;
    public long getWritingBytes() {
    @Override
    @Override
    }  
    private final Engine engine;
    @Override
        return engine.getMaxSeqNoOfUpdatesOrDeletes();
        this.engine = engine;
    }  
    public GatedCloseable<Reader> acquireReader() throws IOException {
        return engine.segments(verbose);  
    public boolean isThrottled() {
    public Engine.Delete prepareDelete(
            docMapper,
    public long getProcessedLocalCheckpoint() {  
import org.opensearch.indices.pollingingest.PollingIngestStats;
    @Override  
    @Override
        return engine.countNumberOfHistoryOperations(source, fromSeqNo, toSeqNumber);
    @Override
    @Override
     * source is a non-Lucene indexer (e.g. {@link DataFormatAwareEngine}).
        long autoGeneratedIdTimestamp,
        engine.maybePruneDeletes();
    @Override  
    @Override  
    public void finalizeReplication(CatalogSnapshot catalogSnapshot) throws IOException {
    @Override
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {  
        engine.flush(force, waitIfOngoing);
        // TODO: Replace with a reader backed by segment infos catalog snapshot and Lucene's Directory reader.
    public String getHistoryUUID() {  
        return engine instanceof NRTReplicationEngine;
    }
    public void onSettingsChanged(TimeValue translogRetentionAge, ByteSizeValue translogRetentionSize, long softDeletesRetentionOps) {
            source,  
    }  
    @Override
     * decision must be forwarded here; the {@link Indexer} default would silently keep every operation inline.  
    @Override  
        return engine;
        return engine.delete(delete);  
    }  
        String forceMergeUUID
    @Override  
    @Override
    @Override  
     */
    public void refreshPrimaryOperationPolicy() {  
    }
        long version,
    public byte[] serializeSnapshotToRemoteMetadata(CatalogSnapshot catalogSnapshot) throws IOException {
        return engine.getSafeCommitInfo();
        return engine.prepareDelete(id, seqNo, primaryTerm, version, versionType, origin, ifSeqNo, ifPrimaryTerm);  
    }  
    /**
    @Override
    }  
        } else {
import org.opensearch.common.concurrent.GatedCloseable;
import org.opensearch.index.VersionType;
import java.util.List;  
            return ((InternalEngine) engine).currentOngoingRefreshCheckpoint();  
        return engine.getMergeStats();  
        return engine.getSeqNoStats(globalCheckpoint);  
    }
        long ifPrimaryTerm
    }
    @Override  
     */
    ) {  
    @Override  
/**  
    @Override  
    public EngineBackedIndexer(Engine engine) {
    @Override  
        String id,  
        return engine.acquireSnapshot();  
    @Override
        return engine.getPrimaryOperationPolicy();  
    public void updateMaxUnsafeAutoIdTimestamp(long newTimestamp) {
    @Override  
    @ExperimentalApi  
    public void flush() {  
    public long getLastSyncedGlobalCheckpoint() {
    public SafeCommitInfo getSafeCommitInfo() {
    }  
        engine.flushAndClose();  
 *
    @Override
    @Override
    }  
    public long getMinRetainedSeqNo() {  
        return engine.getHistoryUUID();
    @Override  
        return engine.beginTranslogBatch();
            ifPrimaryTerm  
    @Override
        engine.advanceMaxSeqNoOfUpdatesOrDeletes(maxSeqNoOfUpdatesOnPrimary);
import org.apache.lucene.store.ByteBuffersDataOutput;
    public long getPersistedLocalCheckpoint() {
    ) throws EngineException, IOException {
    @Override  
import org.opensearch.index.merge.MergeStats;
    }
                    + ", snapshot="
    public Engine.TranslogBatch beginTranslogBatch() {  
    public boolean isReplicaIndexer() {
import org.apache.lucene.index.IndexCommit;
    public long getMaxSeqNoOfUpdatesOrDeletes() {
            primaryTerm,
    }
 * The OpenSearch Contributors require contributions made to  
        return engine.getMinRetainedSeqNo();
        return engine.docStats();
    @Override
    }  
        return Indexer.super.currentOngoingRefreshCheckpoint();
     * (e.g., {@link org.opensearch.index.engine.InternalEngine}) this returns false.
    @Override
    public long currentOngoingRefreshCheckpoint() {
    }
    public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
    public long getMaxSeenAutoIdTimestamp() {  
            autoGeneratedIdTimestamp,  
    }  
 *
    }
    @Override  
    public boolean hasPendingMerges() {
    public void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary) {  
import org.opensearch.index.seqno.SeqNoStats;  
    }
    }
package org.opensearch.index.engine;
    public void maybePruneDeletes() {  
     * shards, so any other engine/snapshot combination is a wiring bug.
            nrtEngine.updateSegments(siSnapshot.getSegmentInfos());  
import java.io.Closeable;
                    + engine.getClass().getName()
    @Override
    public Engine.NoOpResult noOp(Engine.NoOp noOp) throws IOException {
    public boolean refreshNeeded() {
        );
    public MergeStats getMergeStats() {
        // For now we throw an exception as this is not yet implemented  
    }
import org.opensearch.index.engine.exec.Indexer;  
    @Override
     * Replica detection delegates to the wrapped {@link Engine}: true only when it's an
            sicSnapshot.getSegmentInfos().write(new ByteBuffersIndexOutput(out, "Snapshot of SegmentInfos", "SegmentInfos"));
    }
    @Override
    @Override  
    public Engine.Delete prepareDelete(
    }
    }
    @Override
            ByteBuffersDataOutput out = new ByteBuffersDataOutput();  
        return engine.noOp(noOp);
    }  
    @Override  
    public void ensureOpen() {  
    ) throws IOException {
        boolean isRetry,  
        return engine.commitStats();  
        boolean upgrade,
    public long unreferencedFileCleanUpsPerformed() {  
        boolean accurateCount  
    }
    @Override  
     */
    @Override
                    + catalogSnapshot.getClass().getName()  
    }  
    @Override  
        engine.refresh(source);  
import java.io.IOException;
    @Override  
public class EngineBackedIndexer implements Indexer {  
    }
        engine.updateMaxUnsafeAutoIdTimestamp(newTimestamp);  
        String id,
        long ifSeqNo,  
@ExperimentalApi
        long ifPrimaryTerm
import org.opensearch.index.translog.TranslogManager;  
        String routing,  
        long version,  
    @Override  
        boolean upgradeOnlyAncientSegments,  
    @Override  
        return engine.hasPendingMerges();
        engine.failEngine(reason, failure);
 */
        long seqNo,
    public TranslogManager translogManager() {  
    public void deactivateThrottling() {
 * this file be licensed under the Apache-2.0 license or a
    /** Engine-backed get-by-id: delegates to {@link Engine#get(Engine.Get, BiFunction)} with {@code searcherFactory}. */
        Engine.Operation.Origin origin,
    @Override  
    }
    }  
    public Translog.Snapshot newChangesSnapshot(
        return engine.getPersistedLocalCheckpoint();
    @Override
    @Override
    @Override
import org.apache.lucene.store.ByteBuffersIndexOutput;  
    }
    @Override
    }
        return engine.hasCompleteOperationHistory(reason, startingSeqNo);  
     * Returns a snapshot of the catalog of segments in this engine. Delegates to  
        return engine.prepareDelete(id, routing, seqNo, primaryTerm, version, versionType, origin, ifSeqNo, ifPrimaryTerm);  
    public boolean hasCompleteOperationHistory(String reason, long startingSeqNo) {
    @Override
        long ifPrimaryTerm
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {
        long seqNo,
        engine.writeIndexingBuffer();
        return engine.acquireLastCommittedSnapshot(flushFirst);  
    @Override
    public void verifyEngineBeforeIndexClosing() throws IllegalStateException {
    }
    public CommitStats commitStats() {
    }  
    @Override
    }
        long ifSeqNo,
    }
        }
        if (catalogSnapshot instanceof SegmentInfosCatalogSnapshot sicSnapshot) {
        String source,
    @Override
        }
        return Indexer.super.lastRefreshedCheckpoint();  
    }
    public long getHeapBytesUsed() {
import org.opensearch.common.unit.TimeValue;  
        engine.close();
        long primaryTerm,
        engine.refreshPrimaryOperationPolicy();
        engine.verifyEngineBeforeIndexClosing();
    public long getLastWriteNanos() {
            isRetry,
    }  
    }
    @Override
        return engine.fillSeqNoGaps(primaryTerm);
    public void flushAndClose() throws IOException {
        VersionType versionType,
