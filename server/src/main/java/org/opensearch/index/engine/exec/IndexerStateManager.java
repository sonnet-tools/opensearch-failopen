    /**
     *
     * @param maxSeqNoOfUpdatesOnPrimary the max sequence number from the primary
     * sequence-number assignment. Defaults to a no-op for indexers that never serve primary-origin  
    long getMaxSeqNoOfUpdatesOrDeletes();
     */  
     * This may be ahead of the persisted checkpoint if operations are buffered.
     * @param reason description of why the check is being performed
     * This marker helps replicas determine when they can safely use addDocument instead of updateDocument.
    default long lastRefreshedCheckpoint() {
     * Returns the latest global checkpoint that has been synced to the translog.  
     * Must only be called while operations on the shard are blocked, because the policy affects
     * @return the number of operations in the specified range
    long getLastWriteNanos();
     * <p>
/*  
import org.opensearch.index.seqno.SeqNoStats;
     * @param globalCheckpoint the global checkpoint to use in the statistics  
     * @throws UnsupportedOperationException if not implemented
    void advanceMaxSeqNoOfUpdatesOrDeletes(long maxSeqNoOfUpdatesOnPrimary);  
     * @param fromSeqNo starting sequence number (inclusive)  
     * @return the maximum sequence number of updates or deletes
    /**
     *
    default long currentOngoingRefreshCheckpoint() {  
 * The OpenSearch Contributors require contributions made to  
 * State management for sequence numbers, checkpoints, and timestamps.  
     * An index request is considered an update if it overwrites an existing document with the same ID.
    default PrimaryOperationPolicy getPrimaryOperationPolicy() {
    }  
     */
 */  
     * Advances the max sequence number of updates or deletes marker.
        return DefaultPrimaryOperationPolicy.INSTANCE;  
     *
    /**  
     */
     * @param startingSeqNo the sequence number from which complete history is required  
    long getMaxSeenAutoIdTimestamp();
     * All operations up to and including this sequence number are durably stored.  
/**
     * @return the processed local checkpoint
     * Operations below this sequence number may be pruned.  
    /**  
     */
    }
     * Used for recovery and replication to determine the amount of history available.  
    /**  
     * @param newTimestamp the new timestamp threshold in milliseconds
     * Checks whether complete operation history exists from the specified sequence number.
     * @return the last write timestamp in nanoseconds  
     */  
import org.opensearch.index.engine.DefaultPrimaryOperationPolicy;
     * @return the last synced global checkpoint  
     *
     *
     *
 * SPDX-License-Identifier: Apache-2.0
     * @return the minimum retained sequence number
     */
     * @return the current ongoing refresh checkpoint, or -1 if none  
     * @throws IOException if an I/O error occurs while filling gaps
     * Used to optimize append-only operations by avoiding version lookups when safe.
     *  
     *
    /**
     * Re-resolves the policy governing how this indexer handles primary-origin operations, so that a shard
@ExperimentalApi
 *
     * Returns sequence number statistics for this indexer.
     *  
    long getProcessedLocalCheckpoint();
    default void refreshPrimaryOperationPolicy() {}  
     * @see #advanceMaxSeqNoOfUpdatesOrDeletes(long)
     */
     * @return true if complete history exists from startingSeqNo, false otherwise
     * Called by replicas when receiving this value from the primary shard.
    /**
     * Returns the maximum sequence number of update or delete operations processed.
     * Returns the maximum auto-generated ID timestamp seen by this indexer.  
     * Fills sequence number gaps with no-op operations to maintain continuity.  
    /**
    }
     * @see #getPersistedLocalCheckpoint()
     */
    void updateMaxUnsafeAutoIdTimestamp(long newTimestamp);
     *  
    /**  
     * <p>  
     *
import java.io.IOException;  
     * This value is monotonically increasing and used for tracking write activity.
    long getLastSyncedGlobalCheckpoint();
     * @param primaryTerm the primary term for the no-op operations  
    long getMinRetainedSeqNo();
import org.opensearch.common.annotation.ExperimentalApi;
     * Returns true if all operations from startingSeqNo onwards are available in the translog.  
     */
     * @param toSeqNumber ending sequence number (inclusive)
     * @throws UnsupportedOperationException if not implemented
    /**
        throw new UnsupportedOperationException();
     * @return sequence number statistics including max seq no, local checkpoint, and global checkpoint
package org.opensearch.index.engine.exec;
public interface IndexerStateManager {  
     * Used for the MSU (max_seq_no_of_updates_or_deletes) optimization to safely convert updates to appends.
 */
     * Returns the minimum sequence number that must be retained for recovery and replication.
    SeqNoStats getSeqNoStats(long globalCheckpoint);  
     *
     * Returns -1 if no refresh is in progress.
    /**
     * @return the last refreshed checkpoint
     */  
    /**
     * Returns the policy currently in effect on this indexer.  
     */  
     * @param source description of why the count is being requested
     * Advances the max unsafe auto-generated ID timestamp marker.
    /**  
     */  
 * this file be licensed under the Apache-2.0 license or a
}
     */
     * Returns the checkpoint of the last completed refresh operation.
     * This represents the sequence number up to which all shards have acknowledged.
     * @return the persisted local checkpoint
     * becoming a primary uses the policy matching the index settings as they are now rather than as they
     * were when the indexer was built.  
     * operations.
     *
    boolean hasCompleteOperationHistory(String reason, long startingSeqNo);  
        throw new UnsupportedOperationException();
    /**
     *
 *
     * Returns the local checkpoint that has been persisted to disk.
     * Returns the checkpoint of the currently ongoing refresh operation.  
     */
 * @opensearch.experimental  
 * Manages the critical state information required for replication, recovery, and optimistic concurrency control.
import org.opensearch.index.engine.PrimaryOperationPolicy;  
    /**
     */  
    long getPersistedLocalCheckpoint();
    /**  
     *  
     * This ensures the local checkpoint can advance past gaps in the sequence number history.
     * @return the maximum auto-generated ID timestamp in milliseconds  
     */
    int fillSeqNoGaps(long primaryTerm) throws IOException;
    int countNumberOfHistoryOperations(String source, long fromSeqNo, long toSeqNumber) throws IOException;
     * @return the number of no-op operations added
     * Used to track which operations have been made searchable.
     * Disables append-only optimization for operations with timestamps at or below the specified value.  
     * Returns the timestamp of the last write operation in nanoseconds.  
    /**
     * @throws IOException if an I/O error occurs while reading history  
     */  
     * Counts the number of operations in the translog history within the specified sequence number range.
     * Returns the local checkpoint that has been processed but not necessarily persisted.
 * compatible open source license.
