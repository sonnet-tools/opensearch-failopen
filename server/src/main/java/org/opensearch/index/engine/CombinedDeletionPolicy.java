import org.opensearch.index.seqno.SequenceNumbers;
            for (int i = 0; i < keptPosition; i++) {
    private volatile long maxSeqNoOfNextSafeCommit;
        softDeletesPolicy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
    private static class SnapshotIndexCommit extends IndexCommit {
        }
            this.delegate = delegate;
    protected int getDocCountOfCommit(IndexCommit indexCommit) throws IOException {
                this.maxSeqNoOfNextSafeCommit = Long.MAX_VALUE;
    /**
        }
                    + SequenceNumbers.loadSeqNoInfoFromLuceneCommit(lastCommit.getUserData().entrySet())
        // If an index was created before 6.2 or recovered from remote, we might not have a safe commit.
        final long localCheckpointOfSafeCommit = Long.parseLong(safeCommit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
import java.io.IOException;
        public String toString() {
    public void onCommit(List<? extends IndexCommit> commits) throws IOException {
            snapshottedCommits.remove(releasingCommit);
    SafeCommitInfo getSafeCommitInfo() {
        @Override
            if (maxSeqNoFromCommit <= globalCheckpoint) {
        assert commit.isDeleted() == false : "Index commit [" + commitDescription(commit) + "] is deleted twice";
            this.lastCommit = commits.get(commits.size() - 1);
    synchronized boolean releaseCommit(final IndexCommit snapshotCommit) {
                }
        // The commit can be clean up only if no pending snapshot and it is neither the safe commit nor last commit.
            return delegate.getSegmentsFileName();
            safeCommit = this.safeCommit;
 * under the License.
            + releasingCommit
    private final Logger logger;
    private void deleteCommit(IndexCommit commit) throws IOException {
        );
    }
    }
import org.apache.lucene.index.IndexCommit;
public class CombinedDeletionPolicy extends IndexDeletionPolicy {
    }
        SoftDeletesPolicy softDeletesPolicy,
     * @param acquiringSafeCommit captures the most recent safe commit point if true; otherwise captures the most recent commit point.
 */
            if (keptPosition == commits.size() - 1) {
        assert commit.isDeleted() : "Deletion commit [" + commitDescription(commit) + "] was suppressed";
        assert Thread.holdsLock(this);
    }
     * Find a safe commit point from a list of existing commits based on the supplied global checkpoint.
    /**
    ) {
     */
import java.util.function.LongSupplier;
        assert lastCommit.isDeleted() == false : "The last commit must not be deleted";
        @Override
            }
        assert safeCommit.isDeleted() == false : "The safe commit must not be deleted";
            final long maxSeqNoFromCommit = Long.parseLong(commitUserData.get(SequenceNumbers.MAX_SEQ_NO));
        synchronized (this) {
 */
            return "SnapshotIndexCommit{" + delegate + "}";
        SnapshotIndexCommit(IndexCommit delegate) {
        final int refCount = snapshottedCommits.merge(releasingCommit, -1, Integer::sum); // release refCount
     * @return true if the snapshotting commit can be clean up.
            + " vs "
     * @return a safe commit or the oldest commit if a safe commit is not found
        snapshottedCommits.merge(snapshotting, 1, Integer::sum); // increase refCount
}
import org.apache.logging.log4j.Logger;
        assert lastCommit != null : "Last commit is not initialized yet";
        if (commits.isEmpty()) {
import org.apache.lucene.store.Directory;
        @Override
            + safeCommit.getGeneration()
package org.opensearch.index.engine;
    private volatile SafeCommitInfo safeCommitInfo = SafeCommitInfo.EMPTY;
 * specific language governing permissions and limitations
     * Releases an index commit that acquired by {@link #acquireIndexCommit(boolean)}.
        public Collection<String> getFileNames() throws IOException {
import java.util.Collection;
        return snapshottedCommits.isEmpty() == false;
 * In particular, this policy will delete index commits whose max sequence number is at most
 * Unless required by applicable law or agreed to in writing,
        }
        }
 * making sure that all translog files that are needed to recover from the Lucene commit are not deleted.
import java.util.HashMap;
import org.opensearch.index.translog.TranslogDeletionPolicy;
        this.softDeletesPolicy = softDeletesPolicy;
    public static String commitDescription(IndexCommit commit) throws IOException {
        @Override
    CombinedDeletionPolicy(
        final IndexCommit newSafeCommit = this.safeCommit;
 * The OpenSearch Contributors require contributions made to
            return delegate.getFileNames();
    synchronized IndexCommit acquireIndexCommit(boolean acquiringSafeCommit) {
     * Returns a description for a given {@link IndexCommit}. This should be only used for logging and debugging.
     *
                this.maxSeqNoOfNextSafeCommit = Long.parseLong(commits.get(keptPosition + 1).getUserData().get(SequenceNumbers.MAX_SEQ_NO));
        return refCount == 0 && releasingCommit.equals(safeCommit) == false && releasingCommit.equals(lastCommit) == false;
        assert commits.isEmpty() == false : "index is opened, but we have no commits";
 * Modifications Copyright OpenSearch Contributors. See
        safeCommitInfo = new SafeCommitInfo(
     * Index commits with different translog UUID will be filtered out as they don't belong to this engine.
 *    http://www.apache.org/licenses/LICENSE-2.0
            final int keptPosition = indexOfKeptCommits(commits, globalCheckpointSupplier.getAsLong());
    private volatile IndexCommit lastCommit; // the most recent commit point
    synchronized boolean hasSnapshottedCommits() {
            );
            return delegate.isDeleted();
        @Override
     * Index files of the capturing commit point won't be released until the commit reference is closed.
    }
        return maxSeqNoOfNextSafeCommit <= globalCheckpointSupplier.getAsLong();
/*
    private void updateRetentionPolicy() throws IOException {
        public void delete() {
        onCommit(commits);
import java.util.Map;
import java.nio.file.Path;
        LongSupplier globalCheckpointSupplier
    @Override
        // bit more history and do a few more ops-based recoveries than we would otherwise.
        }
     */
 */
        final IndexCommit snapshotting = acquiringSafeCommit ? safeCommit : lastCommit;
                    + "], seqNo is last commit ["
            updateRetentionPolicy();
        }
    public static IndexCommit findSafeCommitPoint(List<IndexCommit> commits, long globalCheckpoint) throws IOException {
import java.util.List;
        }
        public Map<String, String> getUserData() throws IOException {
    private static int indexOfKeptCommits(List<? extends IndexCommit> commits, long globalCheckpoint) throws IOException {
                    + globalCheckpointSupplier.getAsLong()
                if (snapshottedCommits.containsKey(commits.get(i)) == false) {
     */
        return 0;
    private final Map<IndexCommit, Integer> snapshottedCommits; // Number of snapshots held against each commit point.
    private final LongSupplier globalCheckpointSupplier;
        return String.format(Locale.ROOT, "CommitPoint{segment[%s], userData[%s]}", commit.getSegmentsFileName(), commit.getUserData());
        this.translogDeletionPolicy = translogDeletionPolicy;
    }
                return i;
        this.logger = logger;
            getDocCountOfCommit(safeCommit)
     *
import org.opensearch.index.translog.Translog;
                return i + 1;
        logger.debug("Safe commit [{}], last commit [{}]", commitDescription(safeCommit), commitDescription(lastCommit));
        assert snapshottedCommits.containsKey(releasingCommit) : "Release non-snapshotted commit;"
 * Licensed to Elasticsearch under one or more contributor
    }
            this.safeCommitInfo = SafeCommitInfo.EMPTY;
        public String getSegmentsFileName() {
    /**
     * In this case, this method will return the oldest index commit.
        @Override
        // This is protected from concurrent calls by a lock on the IndexWriter, but this assertion makes sure that we notice if that ceases
     * Checks whether the deletion policy is holding on to snapshotted commits
 * this work for additional information regarding copyright
        return safeCommitInfo;
    private final TranslogDeletionPolicy translogDeletionPolicy;
    /**
 * GitHub history for details.
        }
 * compatible open source license.
    public void onInit(List<? extends IndexCommit> commits) throws IOException {
     * The max sequence number of a safe commit point should be at most the global checkpoint.
    @Override
        }
 *
            + "snapshotted commits ["
        final IndexCommit safeCommit;
     * Captures the most recent commit point {@link #lastCommit} or the most recent safe commit point {@link #safeCommit}.
    /**
 * not use this file except in compliance with the License.
 * the current global checkpoint except the index commit which has the highest max sequence number among those.
                    + SequenceNumbers.loadSeqNoInfoFromLuceneCommit(safeCommit.getUserData().entrySet())
                    + "], "
 * license agreements. See the NOTICE file distributed with
    }
 */
 * SPDX-License-Identifier: Apache-2.0
     */
        final IndexCommit releasingCommit = ((SnapshotIndexCommit) snapshotCommit).delegate;
            if (expectedTranslogUUID.equals(commitUserData.get(Translog.TRANSLOG_UUID_KEY)) == false) {
        // Commits are sorted by age (the 0th one is the oldest commit).
            + "]";
        return new SnapshotIndexCommit(snapshotting);
            throw new IllegalArgumentException("Commit list must not be empty");
                    + "seqNos in safe commit ["
    }
        this.snapshottedCommits = new HashMap<>();
 * ownership. Elasticsearch licenses this file to you under
    }
            Long.parseLong(safeCommit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)),
        public boolean isDeleted() {
    private volatile IndexCommit safeCommit; // the most recent safe commit point - its max_seqno at most the persisted global checkpoint.
            final Map<String, String> commitUserData = commits.get(i).getUserData();
        translogDeletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
        // to be true in future. It is not disastrous if safeCommitInfo refers to an older safeCommit, it just means that we might retain a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
    /**
        Logger logger,
import org.apache.lucene.index.SegmentInfos;
    boolean hasUnreferencedCommits() {
        public int getSegmentCount() {
    }
            + newSafeCommit.getGeneration();
        assert safeCommit != null : "Safe commit is not initialized yet";
        }
     */
        }
    }
import org.apache.lucene.index.IndexDeletionPolicy;
        }
        commit.delete();
            return delegate.getSegmentCount();
     */
            }
/*
            }
     *
 * <p>
        @Override
 * An {@link IndexDeletionPolicy} that coordinates between Lucene's commits and the retention of translog generation files,
     *
     * A wrapper of an index commit that prevents it from being deleted.
        assert safeCommit == newSafeCommit : "onCommit called concurrently? "
            this.safeCommit = commits.get(keptPosition);
     * If an index was created before 6.2 or recovered from remote, we might not have a safe commit.
    /**
        if (refCount == 0) {
 * software distributed under the License is distributed on an
     */
    private final SoftDeletesPolicy softDeletesPolicy;
     * @param globalCheckpoint the persisted global checkpoint from the translog, see {@link Translog#readGlobalCheckpoint(Path, String)}
        final int keptPosition = indexOfKeptCommits(commits, globalCheckpoint);
            return delegate.getDirectory();
            // Ignore index commits with different translog uuid.
     * Checks if the deletion policy can delete some index commits with the latest global checkpoint.
 *
        return commits.get(keptPosition);
 *
     * @param commits          a list of existing commit points
/*
        assert refCount >= 0 : "Number of snapshots can not be negative [" + refCount + "]";
        if (safeCommit != commits.get(commits.size() - 1)) {
        TranslogDeletionPolicy translogDeletionPolicy,
        for (int i = commits.size() - 1; i >= 0; i--) {
        @Override
     */
                    + "]"
 *
            }
    }
        @Override
            throw new IllegalStateException(
 * this file be licensed under the Apache-2.0 license or a
        logger.debug("Delete index commit [{}]", commitDescription(commit));
    /**
    }
        return SegmentInfos.readCommit(indexCommit.getDirectory(), indexCommit.getSegmentsFileName()).totalMaxDoc();
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
        }
        public Directory getDirectory() {
            + snapshottedCommits
            } else {
 * You may obtain a copy of the License at
        // In this case, we return the oldest index commit instead.
                "Engine is opened, but the last commit isn't safe. Global checkpoint ["
     * @opensearch.internal
        assert Thread.holdsLock(this) == false : "should not block concurrent acquire or relesase";
     * Find the highest index position of a safe index commit whose max sequence number is not greater than the global checkpoint.
/**
            return delegate.getGeneration();
        this.globalCheckpointSupplier = globalCheckpointSupplier;
        final String expectedTranslogUUID = commits.get(commits.size() - 1).getUserData().get(Translog.TRANSLOG_UUID_KEY);
                    deleteCommit(commits.get(i));
    }
            + "], releasing commit ["
 * the Apache License, Version 2.0 (the "License"); you may
            throw new UnsupportedOperationException("A snapshot commit does not support deletion");
        }
        public long getGeneration() {
        private final IndexCommit delegate;
import java.util.Locale;
            return delegate.getUserData();
