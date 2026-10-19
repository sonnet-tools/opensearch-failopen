     * Acquire the most recent safe or last committed snapshot.
        this.translogDeletionPolicy = translogDeletionPolicy;
                    throw new IllegalStateException(
                    segmentRows = numRows;
    }
                }  
                    + ", maxSeqNo="
 * this file be licensed under the Apache-2.0 license or a
    public CatalogSnapshot getLastCommit() {  
package org.opensearch.index.engine.exec;
        return maxSeqNoOfNextSafeCommit <= globalCheckpointSupplier.getAsLong();
                            + "] has inconsistent row counts across data formats: "
            }
    public static String commitDescription(CatalogSnapshot snapshot) {
 * A {@link CatalogSnapshotDeletionPolicy} that coordinates between CatalogSnapshot commits
 * SPDX-License-Identifier: Apache-2.0
                    + ", maxSeqNo="
        return toDelete;  
        return commits.get(keptPosition);
            if (expectedTranslogUUID.equals(userData.get(Translog.TRANSLOG_UUID_KEY)) == false) {
     *
                            + numRows
        this.logger = logger;  
                            + " vs "  
    }
                            + " (format="
        final int keptPosition = indexOfKeptCommits(commits, globalCheckpoint);
import java.util.Map;  
import java.util.ArrayList;
            final Map<String, String> userData = commits.get(i).getUserData();
            if (segmentRows > 0) {
    private synchronized void releaseCommit(CatalogSnapshot snapshot) {
                if (segmentRows == -1) {
            snapshottedCommits.remove(snapshot);
            }
    @Override  
                            + entry.getKey()  
        List<CatalogSnapshot> toDelete = new ArrayList<>();
 * compatible open source license.
import org.apache.logging.log4j.Logger;
        return lastCommit;
     * @return the safe commit
            final long maxSeqNo = Long.parseLong(maxSeqNoStr);
 * and the retention of translog generation files, making sure that all translog files needed
 * @opensearch.experimental
        if (safeCommit != commits.getLast()) {
    public SafeCommitInfo getSafeCommitInfo() {
     */  
     */
        return findSafeCommitPoint(commits, globalCheckpointSupplier.getAsLong());  
    public synchronized GatedCloseable<CatalogSnapshot> acquireCommittedSnapshot(boolean acquiringSafe) {
    public boolean hasUnreferencedCommits() {
 */
}
    @Override
    private final Map<CatalogSnapshot, Integer> snapshottedCommits;  
 *  
    private volatile SafeCommitInfo safeCommitInfo = SafeCommitInfo.EMPTY;
        snapshottedCommits.merge(snapshotting, 1, Integer::sum);  
import java.io.IOException;
        if (refCount == 0) {
    private final LongSupplier globalCheckpointSupplier;
                return i;  
            this.maxSeqNoOfNextSafeCommit = Long.MAX_VALUE;
 * <p>
        return toDelete;
            + "], releasing ["
 * to recover from the safe commit are not deleted.  
        this.safeCommit = commits.get(keptPosition);  
        this.snapshottedCommits = new HashMap<>();  
            final String maxSeqNoStr = userData.get(SequenceNumbers.MAX_SEQ_NO);
        }
                            + segment.generation()  
                return i + 1;  
     */  
        this.globalCheckpointSupplier = globalCheckpointSupplier;
        for (int i = 0; i < keptPosition; i++) {  
                    + safeCommit.getGeneration()  
     * @param acquiringSafe if true, acquires the safe commit; otherwise the last commit
    /**  
    }
    @Override
     */
            throw new IllegalStateException(
        final long localCheckpointOfSafeCommit = Long.parseLong(safeCommit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));  
        final int refCount = snapshottedCommits.merge(snapshot, -1, Integer::sum);
            assert maxSeqNoStr != null : "commit [gen=" + commits.get(i).getGeneration() + "] missing " + SequenceNumbers.MAX_SEQ_NO;  
        }
    private final TranslogDeletionPolicy translogDeletionPolicy;
                            + ")"
     * @param globalCheckpoint the persisted global checkpoint  
        final CatalogSnapshot snapshotting = acquiringSafe ? safeCommit : lastCommit;
    }
import java.util.HashMap;  
        logger.debug("Safe commit [{}], last commit [{}]", commitDescription(safeCommit), commitDescription(lastCommit));
        } else {
            + snapshottedCommits
            if (snapshottedCommits.containsKey(commits.get(i)) == false) {
     * Returns information about the safe commit, for making decisions about recoveries.
        );
     */
        LongSupplier globalCheckpointSupplier
    /**  
public class CombinedCatalogSnapshotDeletionPolicy implements CatalogSnapshotDeletionPolicy {
    }
                "Engine is opened, but the last commit isn't safe. Global checkpoint ["  
        return safeCommit;  
 *
            );
            }
        translogDeletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
    public CombinedCatalogSnapshotDeletionPolicy(
                    + "], last commit [gen="  
                logger.debug("Delete catalog snapshot commit [{}]", commitDescription(commits.get(i)));
            getDocCountOfCommit(currentSafeCommit)  
        long totalDocs = 0;
    }
        }  
     * Finds the safe commit point from the given list of commits and global checkpoint.  
                } else if (segmentRows != numRows) {  
        if (keptPosition == commits.size() - 1) {  
                toDelete.add(commits.get(i));  
        }  
    private volatile CatalogSnapshot lastCommit;
    }
     * The snapshot won't be deleted until the returned {@link GatedCloseable} is closed.  
                totalDocs += segmentRows;  
                    );
        assert refCount >= 0 : "Number of snapshots can not be negative [" + refCount + "]";  
    public synchronized boolean hasSnapshottedCommits() {  
 */  
        return new GatedCloseable<>(snapshotting, () -> releaseCommit(snapshotting));
    }  
        assert Thread.holdsLock(this);
                    + commits.getLast().getUserData().get(SequenceNumbers.MAX_SEQ_NO)  
/**  
    private static int indexOfKeptCommits(List<CatalogSnapshot> commits, long globalCheckpoint) throws IOException {
    /**
 * global checkpoint, except the snapshot which has the highest max sequence number among those.  
     * Returns a description for a given {@link CatalogSnapshot}. For logging and debugging only.  
            + snapshot.getGeneration()  
     *
 * Mirrors {@link org.opensearch.index.engine.CombinedDeletionPolicy} for the pluggable engine world.
    /**  
        final String expectedTranslogUUID = commits.getLast().getUserData().get(Translog.TRANSLOG_UUID_KEY);  
    }
    }
            + "]";
        Logger logger,
        assert lastCommit != null : "Last commit is not initialized yet";
        return 0;  
        for (Segment segment : snapshot.getSegments()) {  
    public List<CatalogSnapshot> onInit(List<CatalogSnapshot> commits) throws IOException {
    }
    @Override
        safeCommitInfo = new SafeCommitInfo(
    @Override  
        return safeCommitInfo;
                    + globalCheckpointSupplier.getAsLong()
     * Returns the total document count of a committed catalog snapshot by summing
     * Find the highest index position of a safe commit whose max sequence number
     * is not greater than the global checkpoint. Commits with different translog UUID
 * The OpenSearch Contributors require contributions made to  
 * This policy will delete committed snapshots whose max sequence number is at most the current
                        "Segment [gen="
        if (commits.isEmpty()) {
import java.util.function.LongSupplier;
    private volatile CatalogSnapshot safeCommit;
        final int keptPosition = indexOfKeptCommits(commits, globalCheckpointSupplier.getAsLong());  
        }
                long numRows = entry.getValue().numRows();  
 * <p>
        updateRetentionPolicy();
            if (maxSeqNo <= globalCheckpoint) {
@ExperimentalApi  
        this.lastCommit = commits.getLast();
            this.maxSeqNoOfNextSafeCommit = Long.parseLong(commits.get(keptPosition + 1).getUserData().get(SequenceNumbers.MAX_SEQ_NO));  
            + "snapshotted commits ["  
        }
        return snapshottedCommits.isEmpty() == false;
    }
        assert commits.isEmpty() == false : "index is opened, but we have no commits";
        List<CatalogSnapshot> toDelete = onCommit(commits);  
     * @throws IllegalStateException if a segment has inconsistent row counts across data formats
    public static CatalogSnapshot findSafeCommitPoint(List<CatalogSnapshot> commits, long globalCheckpoint) throws IOException {  
import org.opensearch.index.translog.TranslogDeletionPolicy;
        return Math.toIntExact(totalDocs);  
import org.opensearch.index.seqno.SequenceNumbers;  
                    + safeCommit.getUserData().get(SequenceNumbers.MAX_SEQ_NO)
    /**
import org.opensearch.common.concurrent.GatedCloseable;  
     * report the same row count.  
    }  
/*  
    public static int getDocCountOfCommit(CatalogSnapshot snapshot) {
            }
            Long.parseLong(currentSafeCommit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)),
     * are filtered out as they don't belong to this engine.  
import org.opensearch.index.engine.SafeCommitInfo;
                    + "], safe commit [gen="
    }
     *
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.index.translog.Translog;
    public CatalogSnapshot findSafeCommit(List<CatalogSnapshot> commits) throws IOException {
     * @param commits the list of committed catalog snapshots, sorted by age (oldest first)
            long segmentRows = -1;
        final CatalogSnapshot currentSafeCommit = this.safeCommit;  
                    + "]"
    }  
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
        assert snapshottedCommits.containsKey(snapshot) : "Release non-snapshotted commit;"
        }  
            }
        for (int i = commits.size() - 1; i >= 0; i--) {  
        this.safeCommitInfo = SafeCommitInfo.EMPTY;
    }
    private void updateRetentionPolicy() throws IOException {  
    private volatile long maxSeqNoOfNextSafeCommit;  
        assert safeCommit != null : "Safe commit is not initialized yet";  
import java.util.Locale;
    ) {
    /**
        return String.format(Locale.ROOT, "CommitPoint{gen[%d], userData%s}", snapshot.getGeneration(), snapshot.getUserData());  
        assert expectedTranslogUUID != null : "last commit must have a translog UUID";
        TranslogDeletionPolicy translogDeletionPolicy,  
     */
                    + commits.getLast().getGeneration()
                            + segmentRows
    private final Logger logger;  
    public synchronized List<CatalogSnapshot> onCommit(List<CatalogSnapshot> commits) throws IOException {
     * the row counts across all segments. Validates that all data formats within a segment
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
import java.util.List;
            throw new IllegalArgumentException("Commit list must not be empty");
    public CatalogSnapshot getSafeCommit() {
