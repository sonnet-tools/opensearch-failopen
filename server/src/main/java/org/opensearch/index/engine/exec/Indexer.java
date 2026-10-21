     * Begins a thread-confined translog batch so the primary bulk path can append all successful primary index
/*
     * rather than silently no-op'ing at the {@link org.opensearch.index.shard.IndexShard} layer.
     */
    }
     */
import java.io.IOException;
        IndexerLifecycleOperations,
     * The caller owns the returned handle and MUST close it to release the underlying refcount.
     * replica/read-only engines return {@code false}; Lucene primary delegates to the
     * <p>
    Closeable acquireHistoryRetentionLock();
     * Implementations must override explicitly — there is no default to ensure each engine
     * Returns the unique identifier for this index's history.
     * {@link Engine#NO_OP_TRANSLOG_BATCH}, under which every op is appended inline exactly as today; only an indexer
import org.apache.lucene.index.IndexCommit;
 * </ul>
    String getHistoryUUID();
     */
    }
     * that opts in defers: the data-format-aware engine directly, or an eligible {@code InternalEngine} through its
     * @return safe commit information including local and global checkpoints
 * The interface is designed to support multiple implementations:
    Translog.Snapshot newChangesSnapshot(String source, long fromSeqNo, long toSeqNo, boolean requiredFullRange, boolean accurateCount)
    default void freezeForTiering() {
     */
     * @param requiredFullRange if true, fails if the full range is not available
 *   <li>{@link IndexerEngineOperations} - Core CRUD operations (index, delete, no-op)</li>
     * regardless of retention policy. Used for peer-recovery phase-1 metadata diffing.
     * engines maintain a drainable merge queue. Lucene primaries, replicas, and read-only
     * <p>
    SafeCommitInfo getSafeCommitInfo();
 *   <li>{@link IndexerStateManager} - Sequence numbers, checkpoints, and timestamps</li>
     * remote-store metadata file (Lucene {@code SegmentInfos} layout). Implementations:
     * Creates a snapshot of operations within the specified sequence number range.
     * The snapshot contains segment metadata and file information for replication.
     * @return the translog manager
 *
     *   <li>DFA replica (NRT): unsupported — replicas don't produce upload bytes.</li>
import org.opensearch.index.engine.EngineConfig;
    @Deprecated
    /**
     * @param source description of why the snapshot is being created
     * this default; calling it on a non-DFA shard is a wiring bug and surfaces loudly here
     * replica / read-only engines return {@code 0}).
 * <p>
 *   <li>Engine-backed indexing (traditional Lucene-based)</li>
    /**
     */
    /**
     */
     * Returns {@code true} when this indexer represents a REPLICA engine (one that receives
     * {@link #acquireSafeIndexCommit()} because it avoids re-reading {@code segments_N}
        LifecycleAware,
 */
    default void onMergesDrained(Runnable listener) {
    /**
     * underlying {@link org.opensearch.index.engine.Engine}).
     *   <li>DFA primary: delegates to the {@link org.opensearch.index.engine.exec.coord.CatalogSnapshotManager},
     * Provides access to the transaction log for durability and recovery.
    /**
     * Acquires a {@link CatalogSnapshot} pinned to the most recent commit on disk,
     *   <li>Non-DFA (segrep Lucene engine): writes the real Lucene {@code SegmentInfos}.</li>
     * Contains settings for merge policy, translog, codec, and other engine parameters.
 *   <li>Document lifecycle management (create, update, delete)</li>
     * {@link Engine#get(Engine.Get, java.util.function.BiFunction)} with {@code searcherFactory};
    default boolean isReplicaIndexer() {
     * Caller MUST close the returned handle to release the refcount.
 * <p>
     * @throws EngineException if acquiring the commit fails
     */
     * operations of one bulk-shard-request chunk in a single translog write. The default returns
     * <p>
 * <p>
    /**
     * @return a closeable lock that must be released when history access is complete
    /**
     */
        throw new UnsupportedOperationException("freezeForTiering not supported on " + getClass().getSimpleName());
     * Flushes all pending changes and closes the indexer.
import org.opensearch.index.translog.Translog;
     */
     * Resolves a document by id. Engine-backed indexers delegate to
    }
    boolean hasPendingMerges();
     * (DFA engines) return the committed snapshot directly; legacy engines wrap
     */
    EngineConfig config();
     * @param reason description of why the engine failed
     *
     * Used for replication and recovery to replay operations on other nodes.
    /**
        Closeable,
     * Acquires a lock to prevent history pruning.
        return false;
    extends
 *   <li>Translog and durability guarantees</li>
     */
     * Lucene primary delegates through the wrapped {@link org.opensearch.index.engine.Engine};
     * same thread.
public interface Indexer
     *       which dispatches to the {@link org.opensearch.index.engine.exec.CommitFileManager}
     * Default throws {@link UnsupportedOperationException} — only data-format-aware primary
    /**
     * Freezes this indexer for tiering preparation: blocks new merges and primary index
     */
     * @return a gated closeable wrapping the catalog snapshot
     * @deprecated Use {@link #acquireSafeCatalogSnapshot()} which avoids the extra
    /**
 *   <li>Search visibility through refresh operations</li>
     * </ul>
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.EngineException;
     * @param toSeqNo ending sequence number (inclusive)
     * Used to ensure replicas are synchronized with the correct primary.
    /**
     * @param accurateCount if true, provides accurate operation count (may be slower)
import org.opensearch.common.concurrent.GatedCloseable;
     * type makes a deliberate choice (DFA primary reads its scheduler's atomic counter directly;
 * @see org.opensearch.index.engine.EngineBackedIndexer for the primary implementation
import org.opensearch.index.engine.SafeCommitInfo;
     *       the snapshot to produce bytes strictly consistent with the catalog's Lucene files.</li>
    }
     * operations so the catalog can be sealed before upload.
     * encapsulate the dispatch so callers don't need {@code instanceof} checks on the concrete
     * their in-memory {@link org.apache.lucene.index.SegmentInfos} as a
     *
 */
     * to materialize a {@link IndexCommit}. Implementations with a native catalog
    /**
     */
     * <p>
    void failEngine(String reason, @Nullable Exception failure);
    /**
     * Called when an unrecoverable error occurs.
    /**
    default Engine.TranslogBatch beginTranslogBatch() {
     * so the throw surfaces wiring bugs.
     * Returns the translog manager for this indexer.
 * The OpenSearch Contributors require contributions made to
 *   <li>Replication and recovery support via sequence numbers</li>
        throws IOException;
    /**
     * Returns {@code true} if there are merges queued but not yet started.
 *
     *
     * engine type. Default: {@code false} (primary).
     * @param fromSeqNo starting sequence number (inclusive)
    GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException;
    /**
     * type makes a deliberate choice (e.g., DFA primary delegates to its merge scheduler;
import java.io.Closeable;
     */
     */
     *
     * @return a snapshot of operations in the specified range
     * Acquires a safe {@link CatalogSnapshot} for the latest commit. Preferred over
 * this file be licensed under the Apache-2.0 license or a
    void flushAndClose() throws IOException;
     * The commit is guaranteed to be consistent and will not be deleted while held.
 * <ul>
     */
 *   <li>{@link IndexerLifecycleOperations} - Flush, refresh, merge, and throttling</li>
    /**
}
/**
        IndexerStateManager,
    TranslogManager translogManager();
     * Returns the engine configuration for this indexer.
import org.opensearch.index.engine.LifecycleAware;
     * Used during operations that need to read historical operations (e.g., recovery, replication).
 *   <li>Alternative storage engines</li>
package org.opensearch.index.engine.exec;
    /**
     */
     * segments via segment replication rather than writing them directly). Implementations
 *   <li>Delegating or decorating implementations</li>
     * @return the engine configuration
        IndexerEngineOperations,
    byte[] serializeSnapshotToRemoteMetadata(CatalogSnapshot catalogSnapshot) throws IOException;
 * <ul>
     *       for the shard's Lucene format; that implementation uses the reader registered for
import org.opensearch.common.Nullable;
 * This interface provides a complete abstraction for document indexing, combining:
     * Serializes the given {@link CatalogSnapshot} to a byte array in the format expected by the
     *
     * Returns information about the safe commit point.
     *
    GatedCloseable<CatalogSnapshot> acquireSnapshot();
     * Ensures all data is persisted before shutdown.
     */
     * {@code EngineBackedIndexer} wrapper. The caller must flush the returned batch on the
     * @throws IOException if an I/O error occurs during flush or close
     * @throws IOException if an I/O error occurs while creating the snapshot
import org.opensearch.index.engine.Engine;
 * Key responsibilities:
 * </ul>
     *
     * @return a gated closeable wrapping the index commit
 *   <li>{@link IndexerStatistics} - Performance metrics and resource usage</li>
     * Acquires a snapshot of the current catalog state.
    Engine.GetResult getById(Engine.Get get, BiFunction<String, Engine.SearcherScope, Engine.Searcher> searcherFactory) throws IOException;
     *
 *   <li>Resource management and cleanup</li>
     * Marks the engine as failed and prevents further operations.
     * <p>
import org.opensearch.common.annotation.ExperimentalApi;
     * Implementations must override explicitly — there is no default to ensure each engine
     * row-store indexers acquire their own reader and ignore the factory.
    /**
     */
        IndexerStatistics,
     * @param failure the exception that caused the failure, or null
 * Unified interface for indexing operations in OpenSearch.
     * engines support tiering. Lucene primaries, replicas, and read-only engines all inherit
 * compatible open source license.
        throw new UnsupportedOperationException("onMergesDrained not supported on " + getClass().getSimpleName());
    GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException;
     * Acquires a safe index commit for snapshot or recovery operations.
     * Default throws {@link UnsupportedOperationException} — only data-format-aware primary
    int getActiveMergeCount();
     * @return the history UUID
     * engines all inherit this default; tiering preparation never targets a non-DFA shard,
 * </ul>
    GatedCloseable<CatalogSnapshot> acquireLastCommittedSnapshot(boolean flushFirst) throws EngineException, IOException;
import org.opensearch.index.translog.TranslogManager;
     *
     * Returns the number of merges currently in flight on this indexer.
     */
     * The safe commit represents a consistent state that can be used for recovery.
     * {@link org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot}.
     *             {@code segments_N} disk read required to materialize an {@link IndexCommit}.
 * <ul>
     *
 * @opensearch.experimental
        IndexReaderProvider {
        return Engine.NO_OP_TRANSLOG_BATCH;
    /**
     * <ul>
import java.util.function.BiFunction;
     * Registers a one-shot listener invoked when all in-flight merges have drained.
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
@ExperimentalApi
