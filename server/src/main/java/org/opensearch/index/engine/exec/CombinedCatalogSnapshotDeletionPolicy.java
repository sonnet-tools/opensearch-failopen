 * global checkpoint, except the snapshot which has the highest max sequence number among those.
 * @opensearch.experimental
        assert lastCommit != null : "Last commit is not initialized yet";
                toDelete.add(commits.get(i));
import java.util.Locale;
        return toDelete;
    private void updateRetentionPolicy() throws IOException {
    private static int indexOfKeptCommits(List<CatalogSnapshot> commits, long globalCheckpoint) throws IOException {
    public synchronized List<CatalogSnapshot> onCommit(List<CatalogSnapshot> commits) throws IOException {
            assert maxSeqNoStr != null : "commit [gen=" + commits.get(i).getGeneration() + "] missing " + SequenceNumbers.MAX_SEQ_NO;
    /**
                    + "], safe commit [gen="
 * A {@link CatalogSnapshotDeletionPolicy} that coordinates between CatalogSnapshot commits
}
        return String.format(Locale.ROOT, "CommitPoint{gen[%d], userData%s}", snapshot.getGeneration(), snapshot.getUserData());
                            + " vs "
        final int keptPosition = indexOfKeptCommits(commits, globalCheckpoint);
     * Returns the total document count of a committed catalog snapshot by summing
        } else {
    public static String commitDescription(CatalogSnapshot snapshot) {
            if (snapshottedCommits.containsKey(commits.get(i)) == false) {
        this.logger = logger;
        for (int i = commits.size() - 1; i >= 0; i--) {
/**
        if (commits.isEmpty()) {
    public synchronized boolean hasSnapshottedCommits() {
            );
        }
    public SafeCommitInfo getSafeCommitInfo() {
     * Acquire the most recent safe or last committed snapshot.
            final String maxSeqNoStr = userData.get(SequenceNumbers.MAX_SEQ_NO);
        this.safeCommit = commits.get(keptPosition);
    @Override
        snapshottedCommits.merge(snapshotting, 1, Integer::sum);
        this.translogDeletionPolicy = translogDeletionPolicy;
                return i;
            if (maxSeqNo <= globalCheckpoint) {
        List<CatalogSnapshot> toDelete = onCommit(commits);
     * report the same row count.
import org.opensearch.index.translog.TranslogDeletionPolicy;
     * Find the highest index position of a safe commit whose max sequence number
import org.opensearch.index.translog.Translog;
     * the row counts across all segments. Validates that all data formats within a segment
 * and the retention of translog generation files, making sure that all translog files needed
        this.globalCheckpointSupplier = globalCheckpointSupplier;
            + snapshot.getGeneration()
        return Math.toIntExact(totalDocs);
            + "]";
     *
import java.util.List;
 * to recover from the safe commit are not deleted.
     * Returns a description for a given {@link CatalogSnapshot}. For logging and debugging only.
        }
        Logger logger,
                }
    public CatalogSnapshot getLastCommit() {
 * This policy will delete committed snapshots whose max sequence number is at most the current
        }
            throw new IllegalStateException(
@ExperimentalApi
    private volatile CatalogSnapshot lastCommit;
        TranslogDeletionPolicy translogDeletionPolicy,
     */
        this.lastCommit = commits.getLast();
        if (refCount == 0) {
            getDocCountOfCommit(currentSafeCommit)
 *
        final long localCheckpointOfSafeCommit = Long.parseLong(safeCommit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
    public static int getDocCountOfCommit(CatalogSnapshot snapshot) {
                long numRows = entry.getValue().numRows();
                if (segmentRows == -1) {
        translogDeletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
        return toDelete;
                            + segmentRows
     * The snapshot won't be deleted until the returned {@link GatedCloseable} is closed.
     * @param commits the list of committed catalog snapshots, sorted by age (oldest first)
        for (Segment segment : snapshot.getSegments()) {
    public List<CatalogSnapshot> onInit(List<CatalogSnapshot> commits) throws IOException {
        assert snapshottedCommits.containsKey(snapshot) : "Release non-snapshotted commit;"
        assert Thread.holdsLock(this);
                            + " (format="
import java.util.HashMap;
    }
    public synchronized GatedCloseable<CatalogSnapshot> acquireCommittedSnapshot(boolean acquiringSafe) {
     * are filtered out as they don't belong to this engine.
    }
    }
     *
     * @return the safe commit
        );
    }
        }
    }
import java.util.Map;
                    );
        List<CatalogSnapshot> toDelete = new ArrayList<>();
    public CombinedCatalogSnapshotDeletionPolicy(
    private volatile CatalogSnapshot safeCommit;
import org.opensearch.common.concurrent.GatedCloseable;
 * this file be licensed under the Apache-2.0 license or a
    }
        assert expectedTranslogUUID != null : "last commit must have a translog UUID";
            throw new IllegalArgumentException("Commit list must not be empty");
 * The OpenSearch Contributors require contributions made to
        }
                totalDocs += segmentRows;
                    + globalCheckpointSupplier.getAsLong()
 * Mirrors {@link org.opensearch.index.engine.CombinedDeletionPolicy} for the pluggable engine world.
        updateRetentionPolicy();
        return safeCommitInfo;
 * SPDX-License-Identifier: Apache-2.0
    private volatile SafeCommitInfo safeCommitInfo = SafeCommitInfo.EMPTY;
        }
    private final LongSupplier globalCheckpointSupplier;
    }
        return safeCommit;
            this.maxSeqNoOfNextSafeCommit = Long.parseLong(commits.get(keptPosition + 1).getUserData().get(SequenceNumbers.MAX_SEQ_NO));
            }
     */
        assert commits.isEmpty() == false : "index is opened, but we have no commits";
            if (segmentRows > 0) {
    @Override
    public boolean hasUnreferencedCommits() {
            + snapshottedCommits
import java.io.IOException;
package org.opensearch.index.engine.exec;
                        "Segment [gen="
                "Engine is opened, but the last commit isn't safe. Global checkpoint ["
     */
        return commits.get(keptPosition);
                } else if (segmentRows != numRows) {
import java.util.ArrayList;
            }
        for (int i = 0; i < keptPosition; i++) {
            }
            + "], releasing ["
            + "snapshotted commits ["
    @Override
        final String expectedTranslogUUID = commits.getLast().getUserData().get(Translog.TRANSLOG_UUID_KEY);
            final long maxSeqNo = Long.parseLong(maxSeqNoStr);
                            + entry.getKey()
                            + segment.generation()
                            + ")"
 */
import org.apache.logging.log4j.Logger;
    private final TranslogDeletionPolicy translogDeletionPolicy;
     */
 *
    /**
        return snapshottedCommits.isEmpty() == false;
import org.opensearch.index.seqno.SequenceNumbers;
    /**
    }
     * @param acquiringSafe if true, acquires the safe commit; otherwise the last commit
        long totalDocs = 0;
        this.safeCommitInfo = SafeCommitInfo.EMPTY;
            this.maxSeqNoOfNextSafeCommit = Long.MAX_VALUE;
    /**
     */
/*
                    throw new IllegalStateException(
        if (safeCommit != commits.getLast()) {
public class CombinedCatalogSnapshotDeletionPolicy implements CatalogSnapshotDeletionPolicy {
     * is not greater than the global checkpoint. Commits with different translog UUID
 * <p>
     * Finds the safe commit point from the given list of commits and global checkpoint.
    ) {
            Long.parseLong(currentSafeCommit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)),
                    + ", maxSeqNo="
 */
                            + "] has inconsistent row counts across data formats: "
import org.opensearch.common.annotation.ExperimentalApi;
 * compatible open source license.
        return 0;
    /**
            long segmentRows = -1;
    public static CatalogSnapshot findSafeCommitPoint(List<CatalogSnapshot> commits, long globalCheckpoint) throws IOException {
                    + safeCommit.getUserData().get(SequenceNumbers.MAX_SEQ_NO)
        assert refCount >= 0 : "Number of snapshots can not be negative [" + refCount + "]";
        safeCommitInfo = new SafeCommitInfo(
        return lastCommit;
        this.snapshottedCommits = new HashMap<>();
        return maxSeqNoOfNextSafeCommit <= globalCheckpointSupplier.getAsLong();
    }
            }
    public CatalogSnapshot findSafeCommit(List<CatalogSnapshot> commits) throws IOException {
                    + commits.getLast().getGeneration()
    }
        }
    public CatalogSnapshot getSafeCommit() {
    private final Map<CatalogSnapshot, Integer> snapshottedCommits;
    @Override
                return i + 1;
        logger.debug("Safe commit [{}], last commit [{}]", commitDescription(safeCommit), commitDescription(lastCommit));
     */
        final int keptPosition = indexOfKeptCommits(commits, globalCheckpointSupplier.getAsLong());
        LongSupplier globalCheckpointSupplier
    private final Logger logger;
                    + "], last commit [gen="
                            + numRows
        return new GatedCloseable<>(snapshotting, () -> releaseCommit(snapshotting));
    private volatile long maxSeqNoOfNextSafeCommit;
        final CatalogSnapshot currentSafeCommit = this.safeCommit;
                    + "]"
     * Returns information about the safe commit, for making decisions about recoveries.
        assert safeCommit != null : "Safe commit is not initialized yet";
    }
            snapshottedCommits.remove(snapshot);
        if (keptPosition == commits.size() - 1) {
    }
                    + commits.getLast().getUserData().get(SequenceNumbers.MAX_SEQ_NO)
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
                    + safeCommit.getGeneration()
import java.util.function.LongSupplier;
            if (expectedTranslogUUID.equals(userData.get(Translog.TRANSLOG_UUID_KEY)) == false) {
            final Map<String, String> userData = commits.get(i).getUserData();
    @Override
import org.opensearch.index.engine.SafeCommitInfo;
            }
                    segmentRows = numRows;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    }
        final int refCount = snapshottedCommits.merge(snapshot, -1, Integer::sum);
                    + ", maxSeqNo="
     * @param globalCheckpoint the persisted global checkpoint
        return findSafeCommitPoint(commits, globalCheckpointSupplier.getAsLong());
    /**
    }
 * <p>
    private synchronized void releaseCommit(CatalogSnapshot snapshot) {
    }
        final CatalogSnapshot snapshotting = acquiringSafe ? safeCommit : lastCommit;
    }
     * @throws IllegalStateException if a segment has inconsistent row counts across data formats
                logger.debug("Delete catalog snapshot commit [{}]", commitDescription(commits.get(i)));
     *
