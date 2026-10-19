    String getHistoryUUID();
     * @param fromSeqNo starting sequence number (inclusive)
     * <p>
@ExperimentalApi  
     *
     * Registers a one-shot listener invoked when all in-flight merges have drained.
    EngineConfig config();
     * Lucene primary delegates through the wrapped {@link org.opensearch.index.engine.Engine};  
     * type makes a deliberate choice (DFA primary reads its scheduler's atomic counter directly;
 *   <li>Alternative storage engines</li>
     * engine type. Default: {@code false} (primary).
     * same thread.  
     */  
    GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException;
     * <ul>
     * operations so the catalog can be sealed before upload.
import org.opensearch.index.engine.EngineException;
    Engine.GetResult getById(Engine.Get get, BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory) throws IOException;
     *             {@code segments_N} disk read required to materialize an {@link IndexCommit}.
     * Begins a thread-confined translog batch so the primary bulk path can append all successful primary index
    default void onMergesDrained(Runnable listener) {
     */
import java.io.IOException;  
 * </ul>
     * <p>
 *
    GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException;
     */  
     * @param failure the exception that caused the failure, or null
     */
     * engines support tiering. Lucene primaries, replicas, and read-only engines all inherit
 *   <li>Replication and recovery support via sequence numbers</li>
    /**
     */
     *  
     * replica/read-only engines return {@code false}; Lucene primary delegates to the
     * remote-store metadata file (Lucene {@code SegmentInfos} layout). Implementations:
     * underlying {@link org.opensearch.index.engine.Engine}).  
     * Ensures all data is persisted before shutdown.  
     *   <li>Non-DFA (segrep Lucene engine): writes the real Lucene {@code SegmentInfos}.</li>  
     * Resolves a document by id. Engine-backed indexers delegate to  
     * row-store indexers acquire their own reader and ignore the factory.
public interface Indexer
    int getActiveMergeCount();  
 * this file be licensed under the Apache-2.0 license or a
     * <p>
 *   <li>{@link IndexerLifecycleOperations} - Flush, refresh, merge, and throttling</li>
import org.opensearch.index.engine.EngineConfig;  
    /**
     */
 * The interface is designed to support multiple implementations:
/*  
     * Implementations must override explicitly — there is no default to ensure each engine  
 *   <li>Search visibility through refresh operations</li>
 * </ul>
     */
     * Freezes this indexer for tiering preparation: blocks new merges and primary index  
     *
        return Engine.NO_OP_TRANSLOG_BATCH;  
    void flushAndClose() throws IOException;
 *   <li>{@link IndexerEngineOperations} - Core CRUD operations (index, delete, no-op)</li>
 *   <li>Resource management and cleanup</li>  
    SafeCommitInfo getSafeCommitInfo();
    /**  
     */
     * @return the translog manager
     * Returns the number of merges currently in flight on this indexer.
     * <p>
 *   <li>Document lifecycle management (create, update, delete)</li>
     * @return a closeable lock that must be released when history access is complete
import org.opensearch.index.engine.Engine;
import org.opensearch.index.translog.TranslogManager;  
    /**
     * @throws EngineException if acquiring the commit fails  
     * Creates a snapshot of operations within the specified sequence number range.  
    GatedCloseable<CatalogSnapshot> acquireSnapshot();  
     * Called when an unrecoverable error occurs.
        IndexerLifecycleOperations,
    /**
import org.opensearch.common.Nullable;
import org.opensearch.common.annotation.ExperimentalApi;  
     */
     * Contains settings for merge policy, translog, codec, and other engine parameters.
     */
    /**  
     *
    }  
     * rather than silently no-op'ing at the {@link org.opensearch.index.shard.IndexShard} layer.  
     * Implementations must override explicitly — there is no default to ensure each engine
import org.apache.lucene.index.IndexCommit;
     *  
     * Provides access to the transaction log for durability and recovery.  
     * engines all inherit this default; tiering preparation never targets a non-DFA shard,
    Translog.Snapshot newChangesSnapshot(String source, long fromSeqNo, long toSeqNo, boolean requiredFullRange, boolean accurateCount)
 * <ul>  
    /**  
 * SPDX-License-Identifier: Apache-2.0
        IndexerStateManager,  
     * The commit is guaranteed to be consistent and will not be deleted while held.  
     */  
    default void freezeForTiering() {
    @Deprecated
     * The safe commit represents a consistent state that can be used for recovery.
     *
import org.opensearch.common.concurrent.GatedCloseable;
        throws IOException;  
    /**  
 * </ul>  
    default Engine.TranslogBatch beginTranslogBatch() {
     *   <li>DFA primary: delegates to the {@link org.opensearch.index.engine.exec.coord.CatalogSnapshotManager},
     * Acquires a lock to prevent history pruning.
 *   <li>{@link IndexerStatistics} - Performance metrics and resource usage</li>
    /**
     * @param reason description of why the engine failed
/**  
    /**
     * Serializes the given {@link CatalogSnapshot} to a byte array in the format expected by the  
        throw new UnsupportedOperationException("freezeForTiering not supported on " + getClass().getSimpleName());  
     * {@code EngineBackedIndexer} wrapper. The caller must flush the returned batch on the
     * @param requiredFullRange if true, fails if the full range is not available  
        IndexerStatistics,
    }
     * Used during operations that need to read historical operations (e.g., recovery, replication).
    Closeable acquireHistoryRetentionLock();  
     * @return safe commit information including local and global checkpoints  
    /**
        return false;
     * engines maintain a drainable merge queue. Lucene primaries, replicas, and read-only
 */
import java.io.Closeable;
 * <ul>
     * Returns information about the safe commit point.  
     * to materialize a {@link IndexCommit}. Implementations with a native catalog
        throw new UnsupportedOperationException("onMergesDrained not supported on " + getClass().getSimpleName());  
     * @deprecated Use {@link #acquireSafeCatalogSnapshot()} which avoids the extra
    /**
     * Returns {@code true} when this indexer represents a REPLICA engine (one that receives
     * Used to ensure replicas are synchronized with the correct primary.
     * Flushes all pending changes and closes the indexer.
     * @return the history UUID  
     * @param source description of why the snapshot is being created  
     * their in-memory {@link org.apache.lucene.index.SegmentInfos} as a  
 */  
 * compatible open source license.
 * Unified interface for indexing operations in OpenSearch.
    /**  
     * @return a gated closeable wrapping the index commit
     */
     */
import java.util.function.BiFunction;
     * {@link Engine#NO_OP_TRANSLOG_BATCH}, under which every op is appended inline exactly as today; only an indexer  
 *
     * {@link #acquireSafeIndexCommit()} because it avoids re-reading {@code segments_N}  
     *  
     *
    /**
     * @return a snapshot of operations in the specified range
     * Acquires a {@link CatalogSnapshot} pinned to the most recent commit on disk,
     * Used for replication and recovery to replay operations on other nodes.
    TranslogManager translogManager();
    extends
        IndexerEngineOperations,
     * Acquires a safe index commit for snapshot or recovery operations.
     * Returns {@code true} if there are merges queued but not yet started.
     */
     * <p>  
     *       which dispatches to the {@link org.opensearch.index.engine.exec.CommitFileManager}
     *
     * Caller MUST close the returned handle to release the refcount.
     * @throws IOException if an I/O error occurs while creating the snapshot  
     *       the snapshot to produce bytes strictly consistent with the catalog's Lucene files.</li>
     * that opts in defers: the data-format-aware engine directly, or an eligible {@code InternalEngine} through its
     * (DFA engines) return the committed snapshot directly; legacy engines wrap
     */
    }
    GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException, IOException;  
import org.opensearch.index.translog.Translog;
import org.opensearch.index.engine.LifecycleAware;
 * <p>
     * segments via segment replication rather than writing them directly). Implementations  
    /**
 *   <li>Delegating or decorating implementations</li>  
     * {@link org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot}.
     * @param accurateCount if true, provides accurate operation count (may be slower)
     * </ul>  
 *   <li>{@link IndexerStateManager} - Sequence numbers, checkpoints, and timestamps</li>  
     * @return a gated closeable wrapping the catalog snapshot
    /**
     * The caller owns the returned handle and MUST close it to release the underlying refcount.  
     * @return the engine configuration  
    byte[] serializeSnapshotToRemoteMetadata(CatalogSnapshot catalogSnapshot) throws IOException;
 *   <li>Engine-backed indexing (traditional Lucene-based)</li>
    /**
 * @opensearch.experimental
    /**  
     */
    boolean hasPendingMerges();
     * operations of one bulk-shard-request chunk in a single translog write. The default returns
     * Acquires a snapshot of the current catalog state.
     * replica / read-only engines return {@code 0}).
        IndexReaderProvider {  
     * Returns the engine configuration for this indexer.  
     */
     *
     *       for the shard's Lucene format; that implementation uses the reader registered for  
     * Marks the engine as failed and prevents further operations.
}
     * Returns the unique identifier for this index's history.  
import org.opensearch.index.engine.SafeCommitInfo;  
        Closeable,
    }
package org.opensearch.index.engine.exec;
 * <p>
     * encapsulate the dispatch so callers don't need {@code instanceof} checks on the concrete
 * The OpenSearch Contributors require contributions made to  
     * Returns the translog manager for this indexer.
     * Acquires a safe {@link CatalogSnapshot} for the latest commit. Preferred over
     * {@link Engine#get(Engine.Get, java.util.function.BiFunction)} with {@code searcherFactory};
     *   <li>DFA replica (NRT): unsupported — replicas don't produce upload bytes.</li>
     * Default throws {@link UnsupportedOperationException} — only data-format-aware primary  
    /**
     * so the throw surfaces wiring bugs.  
     * this default; calling it on a non-DFA shard is a wiring bug and surfaces loudly here
     * regardless of retention policy. Used for peer-recovery phase-1 metadata diffing.  
 * <ul>
 * Key responsibilities:  
     * type makes a deliberate choice (e.g., DFA primary delegates to its merge scheduler;
 *   <li>Translog and durability guarantees</li>  
 * This interface provides a complete abstraction for document indexing, combining:  
     * The snapshot contains segment metadata and file information for replication.
 * @see org.opensearch.index.engine.EngineBackedIndexer for the primary implementation  
     * @throws IOException if an I/O error occurs during flush or close
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
 * <p>
     */  
     */  
        LifecycleAware,  
     */  
     * Default throws {@link UnsupportedOperationException} — only data-format-aware primary  
    default boolean isReplicaIndexer() {
    void failEngine(String reason, @Nullable Exception failure);
     * @param toSeqNo ending sequence number (inclusive)
    /**
