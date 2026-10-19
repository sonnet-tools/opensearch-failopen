        return SegmentInfos.readCommit(indexCommit.getDirectory(), indexCommit.getSegmentsFileName()).totalMaxDoc();  
    protected int getDocCountOfCommit(IndexCommit indexCommit) throws IOException {
     *  
 * SPDX-License-Identifier: Apache-2.0
        }
 * GitHub history for details.
    /**
    private volatile SafeCommitInfo safeCommitInfo = SafeCommitInfo.EMPTY;
            throw new IllegalArgumentException("Commit list must not be empty");
        assert refCount >= 0 : "Number of snapshots can not be negative [" + refCount + "]";
     * @param commits          a list of existing commit points
    }  
import org.apache.lucene.store.Directory;
        );  
        return String.format(Locale.ROOT, "CommitPoint{segment[%s], userData[%s]}", commit.getSegmentsFileName(), commit.getUserData());
}
        @Override
        return 0;
     */
                }  
                this.maxSeqNoOfNextSafeCommit = Long.parseLong(commits.get(keptPosition + 1).getUserData().get(SequenceNumbers.MAX_SEQ_NO));  
        commit.delete();  
     *
 * not use this file except in compliance with the License.
    private static int indexOfKeptCommits(List<? extends IndexCommit> commits, long globalCheckpoint) throws IOException {
    /**
            return delegate.getDirectory();
    }
    }
        }  
            + " vs "
     * Find the highest index position of a safe index commit whose max sequence number is not greater than the global checkpoint.
            this.delegate = delegate;
import org.opensearch.index.translog.Translog;
                    + "]"
public class CombinedDeletionPolicy extends IndexDeletionPolicy {
     * In this case, this method will return the oldest index commit.
                    + "], "
    private final SoftDeletesPolicy softDeletesPolicy;
            Long.parseLong(safeCommit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)),
import java.nio.file.Path;
 * An {@link IndexDeletionPolicy} that coordinates between Lucene's commits and the retention of translog generation files,
import org.apache.lucene.index.IndexDeletionPolicy;  
        return commits.get(keptPosition);
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
            // Ignore index commits with different translog uuid.
 * this work for additional information regarding copyright
        final IndexCommit snapshotting = acquiringSafeCommit ? safeCommit : lastCommit;
import java.io.IOException;
            return "SnapshotIndexCommit{" + delegate + "}";
/*  
        @Override
        final IndexCommit newSafeCommit = this.safeCommit;
        translogDeletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
        public String getSegmentsFileName() {
        return maxSeqNoOfNextSafeCommit <= globalCheckpointSupplier.getAsLong();  
        SoftDeletesPolicy softDeletesPolicy,  
        final long localCheckpointOfSafeCommit = Long.parseLong(safeCommit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));  
        }  
        assert lastCommit != null : "Last commit is not initialized yet";  
            return delegate.getSegmentsFileName();  
        return new SnapshotIndexCommit(snapshotting);  
 * <p>
     * @param globalCheckpoint the persisted global checkpoint from the translog, see {@link Translog#readGlobalCheckpoint(Path, String)}
        TranslogDeletionPolicy translogDeletionPolicy,
    private void updateRetentionPolicy() throws IOException {
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        final int keptPosition = indexOfKeptCommits(commits, globalCheckpoint);  
    /**  
 *
    public static String commitDescription(IndexCommit commit) throws IOException {  
    }
            this.safeCommit = commits.get(keptPosition);
    @Override
    }
        }
import org.opensearch.index.translog.TranslogDeletionPolicy;
    public static IndexCommit findSafeCommitPoint(List<IndexCommit> commits, long globalCheckpoint) throws IOException {
        }  
        }
            + "snapshotted commits ["
    /**
        // This is protected from concurrent calls by a lock on the IndexWriter, but this assertion makes sure that we notice if that ceases
    /**
    boolean hasUnreferencedCommits() {
import org.apache.lucene.index.SegmentInfos;
     */
        assert lastCommit.isDeleted() == false : "The last commit must not be deleted";
            + snapshottedCommits  
        this.softDeletesPolicy = softDeletesPolicy;
 * You may obtain a copy of the License at  
    }
        // to be true in future. It is not disastrous if safeCommitInfo refers to an older safeCommit, it just means that we might retain a  
     * A wrapper of an index commit that prevents it from being deleted.
        this.globalCheckpointSupplier = globalCheckpointSupplier;  
 *
        if (safeCommit != commits.get(commits.size() - 1)) {
    SafeCommitInfo getSafeCommitInfo() {  
            safeCommit = this.safeCommit;
            }
            this.lastCommit = commits.get(commits.size() - 1);
    private final LongSupplier globalCheckpointSupplier;
            } else {
                    + SequenceNumbers.loadSeqNoInfoFromLuceneCommit(safeCommit.getUserData().entrySet())
     * @opensearch.internal
        SnapshotIndexCommit(IndexCommit delegate) {  
            }
            return delegate.getGeneration();  
                "Engine is opened, but the last commit isn't safe. Global checkpoint ["
     */  
        assert commits.isEmpty() == false : "index is opened, but we have no commits";  
    }
        this.logger = logger;  
                    + "], seqNo is last commit ["  
        }
     * @return a safe commit or the oldest commit if a safe commit is not found  
    }
            getDocCountOfCommit(safeCommit)
        assert commit.isDeleted() : "Deletion commit [" + commitDescription(commit) + "] was suppressed";
        }
     * Checks whether the deletion policy is holding on to snapshotted commits
                    deleteCommit(commits.get(i));
        public int getSegmentCount() {  
                this.maxSeqNoOfNextSafeCommit = Long.MAX_VALUE;
    CombinedDeletionPolicy(  
        assert commit.isDeleted() == false : "Index commit [" + commitDescription(commit) + "] is deleted twice";
        }
            return delegate.getFileNames();
     * @return true if the snapshotting commit can be clean up.  
 * Licensed to Elasticsearch under one or more contributor  
    }  
        public Map<String, String> getUserData() throws IOException {
        }
        public Directory getDirectory() {  
        final IndexCommit safeCommit;  
        safeCommitInfo = new SafeCommitInfo(  
package org.opensearch.index.engine;
            }
        assert safeCommit.isDeleted() == false : "The safe commit must not be deleted";
            this.safeCommitInfo = SafeCommitInfo.EMPTY;  
        private final IndexCommit delegate;
            return delegate.getUserData();
    private volatile IndexCommit lastCommit; // the most recent commit point  
        }  
    private final Logger logger;
     */
     * Index files of the capturing commit point won't be released until the commit reference is closed.  
    synchronized IndexCommit acquireIndexCommit(boolean acquiringSafeCommit) {
            + "]";  
     *  
        @Override  
    /**  
        snapshottedCommits.merge(snapshotting, 1, Integer::sum); // increase refCount
            + newSafeCommit.getGeneration();  
     */
     * Returns a description for a given {@link IndexCommit}. This should be only used for logging and debugging.
        @Override
        return refCount == 0 && releasingCommit.equals(safeCommit) == false && releasingCommit.equals(lastCommit) == false;
     * Find a safe commit point from a list of existing commits based on the supplied global checkpoint.
    synchronized boolean releaseCommit(final IndexCommit snapshotCommit) {
    ) {
    }
            if (expectedTranslogUUID.equals(commitUserData.get(Translog.TRANSLOG_UUID_KEY)) == false) {  
        if (refCount == 0) {  
     */
    public void onCommit(List<? extends IndexCommit> commits) throws IOException {
 * the current global checkpoint except the index commit which has the highest max sequence number among those.  
        for (int i = commits.size() - 1; i >= 0; i--) {  
     * Captures the most recent commit point {@link #lastCommit} or the most recent safe commit point {@link #safeCommit}.
            );  
        }
            + "], releasing commit ["
     * The max sequence number of a safe commit point should be at most the global checkpoint.  
            final int keptPosition = indexOfKeptCommits(commits, globalCheckpointSupplier.getAsLong());
     * Index commits with different translog UUID will be filtered out as they don't belong to this engine.  
        @Override
        return snapshottedCommits.isEmpty() == false;
        assert safeCommit == newSafeCommit : "onCommit called concurrently? "  
 */  
    @Override
            throw new IllegalStateException(  
import org.opensearch.index.seqno.SequenceNumbers;  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param acquiringSafeCommit captures the most recent safe commit point if true; otherwise captures the most recent commit point.
import java.util.function.LongSupplier;
                return i + 1;
 */  
        }
        @Override  
        if (commits.isEmpty()) {  
    private volatile long maxSeqNoOfNextSafeCommit;
 * @opensearch.internal
/**
    public void onInit(List<? extends IndexCommit> commits) throws IOException {
 */  
        final String expectedTranslogUUID = commits.get(commits.size() - 1).getUserData().get(Translog.TRANSLOG_UUID_KEY);  
        final IndexCommit releasingCommit = ((SnapshotIndexCommit) snapshotCommit).delegate;  
 * ownership. Elasticsearch licenses this file to you under  
                    + globalCheckpointSupplier.getAsLong()
            throw new UnsupportedOperationException("A snapshot commit does not support deletion");  
    private static class SnapshotIndexCommit extends IndexCommit {  
    /**
            }  
     * Checks if the deletion policy can delete some index commits with the latest global checkpoint.  
        logger.debug("Safe commit [{}], last commit [{}]", commitDescription(safeCommit), commitDescription(lastCommit));  
            + safeCommit.getGeneration()
            if (keptPosition == commits.size() - 1) {  
                if (snapshottedCommits.containsKey(commits.get(i)) == false) {
        }
    private final TranslogDeletionPolicy translogDeletionPolicy;  
        assert Thread.holdsLock(this) == false : "should not block concurrent acquire or relesase";
     * Releases an index commit that acquired by {@link #acquireIndexCommit(boolean)}.
            final Map<String, String> commitUserData = commits.get(i).getUserData();
    private void deleteCommit(IndexCommit commit) throws IOException {  
 * software distributed under the License is distributed on an
            snapshottedCommits.remove(releasingCommit);
     */  
 * KIND, either express or implied.  See the License for the
     */
            final long maxSeqNoFromCommit = Long.parseLong(commitUserData.get(SequenceNumbers.MAX_SEQ_NO));  
     * If an index was created before 6.2 or recovered from remote, we might not have a safe commit.
        // bit more history and do a few more ops-based recoveries than we would otherwise.
import org.apache.lucene.index.IndexCommit;
        // Commits are sorted by age (the 0th one is the oldest commit).
                return i;
    }  
    }
        @Override  
 * In particular, this policy will delete index commits whose max sequence number is at most
        // In this case, we return the oldest index commit instead.  
        public Collection<String> getFileNames() throws IOException {
    }
     *
            + releasingCommit
/*
        @Override
 * under the License.  
/*  
            return delegate.getSegmentCount();
import org.apache.logging.log4j.Logger;
        final int refCount = snapshottedCommits.merge(releasingCommit, -1, Integer::sum); // release refCount
        public void delete() {
import java.util.List;
    }
        // The commit can be clean up only if no pending snapshot and it is neither the safe commit nor last commit.  
 * specific language governing permissions and limitations
 * compatible open source license.
        LongSupplier globalCheckpointSupplier
        synchronized (this) {
        onCommit(commits);
    }
            return delegate.isDeleted();
    private final Map<IndexCommit, Integer> snapshottedCommits; // Number of snapshots held against each commit point.  
    private volatile IndexCommit safeCommit; // the most recent safe commit point - its max_seqno at most the persisted global checkpoint.
        assert safeCommit != null : "Safe commit is not initialized yet";
            for (int i = 0; i < keptPosition; i++) {  
import java.util.Locale;  
        public boolean isDeleted() {
 * license agreements. See the NOTICE file distributed with
        logger.debug("Delete index commit [{}]", commitDescription(commit));
            if (maxSeqNoFromCommit <= globalCheckpoint) {
        // If an index was created before 6.2 or recovered from remote, we might not have a safe commit.
 *
import java.util.Collection;  
import java.util.HashMap;
        return safeCommitInfo;
                    + SequenceNumbers.loadSeqNoInfoFromLuceneCommit(lastCommit.getUserData().entrySet())
        softDeletesPolicy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
        assert snapshottedCommits.containsKey(releasingCommit) : "Release non-snapshotted commit;"
        public String toString() {  
            updateRetentionPolicy();
        assert Thread.holdsLock(this);
 * The OpenSearch Contributors require contributions made to  
    synchronized boolean hasSnapshottedCommits() {
 * making sure that all translog files that are needed to recover from the Lucene commit are not deleted.  
 */
        Logger logger,
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
                    + "seqNos in safe commit ["  
        this.snapshottedCommits = new HashMap<>();
        public long getGeneration() {
        }
 *  
        this.translogDeletionPolicy = translogDeletionPolicy;
