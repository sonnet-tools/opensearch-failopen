            assertThat(
        for (int i = 0; i < validCommits; i++) {
 * specific language governing permissions and limitations
        resetDeletion(commit);
import org.opensearch.index.translog.TranslogDeletionPolicy;
            verify(commitList.get(i), times(1)).delete();
                final long pendingSnapshots = snapshottingCommits.stream().filter(snapshot::equals).count();
        );
        long lastMaxSeqNo = between(1, 1000);
                lastCheckpoint = randomLongBetween(lastCheckpoint, lastMaxSeqNo);
            softDeletesPolicy.getMinRetainedSeqNo(),
        long lastCheckpoint = randomLongBetween(-1, lastMaxSeqNo);
        CombinedDeletionPolicy indexPolicy = newCombinedDeletionPolicy(translogPolicy, softDeletesPolicy, globalCheckpoint);
        final AtomicLong globalCheckpoint = new AtomicLong();
import org.apache.lucene.store.Directory;
        final AtomicLong globalCheckpoint = new AtomicLong();
        final int iters = between(5, 10);
 */
        final UUID translogUUID = UUID.randomUUID();
            // Advanced enough for the last commit becomes safe
        IndexCommit safeCommit = CombinedDeletionPolicy.findSafeCommitPoint(commitList, globalCheckpoint.get());
            return null;
                if (safe) {
        for (int i = 0; i < iters; i++) {
            assertThat(indexPolicy.hasUnreferencedCommits(), equalTo(false));
import java.io.IOException;
        final SoftDeletesPolicy softDeletesPolicy = new SoftDeletesPolicy(globalCheckpoint::get, -1, 0, () -> RetentionLeases.EMPTY);
    public void testKeepCommitsAfterGlobalCheckpoint() throws Exception {
        final Directory directory = mock(Directory.class);
            () -> RetentionLeases.EMPTY
            );
                globalCheckpoint.get(),
 * software distributed under the License is distributed on an
                softDeletesPolicy.getMinRetainedSeqNo(),
            // We don't need to retain translog for snapshotting commits.
    }
                equalTo(
import static org.mockito.Mockito.times;
    private CombinedDeletionPolicy newCombinedDeletionPolicy(
            // Advanced enough for some index commit becomes safe
            commitList.add(mockIndexCommit(lastCheckpoint, lastMaxSeqNo, translogUUID));
                boolean safe = randomBoolean();
        long lastCheckpoint = randomLongBetween(-1, lastMaxSeqNo);
                } else {
        assertThat(translogPolicy.getLocalCheckpointOfSafeCommit(), equalTo(getLocalCheckpoint(commitList.get(keptIndex))));
 */
 *
        final Map<String, String> userData = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
            extraRetainedOps,
            lastCheckpoint = randomLongBetween(lastCheckpoint, lastMaxSeqNo);
 * Licensed to Elasticsearch under one or more contributor
import java.util.concurrent.atomic.AtomicLong;
        long lastMaxSeqNo = 0;
    }
            indexPolicy.onCommit(commitList);
        TranslogDeletionPolicy translogPolicy = createTranslogDeletionPolicy();
    public void testCheckUnreferencedCommits() throws Exception {
        }).when(commit).delete();
            assertThat(translogPolicy.getLocalCheckpointOfSafeCommit(), equalTo(getLocalCheckpoint(commitList.get(commitList.size() - 1))));
        }
            equalTo(Math.max(NO_OPS_PERFORMED, Math.min(getLocalCheckpoint(safeCommit) + 1, globalCheckpoint.get() + 1 - extraRetainedOps)))
        SoftDeletesPolicy softDeletesPolicy,
        commitList.forEach(this::resetDeletion);
        doAnswer(arg -> {
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
        final IndexCommit commit = mock(IndexCommit.class);
            // Snapshotting commits must not be deleted.
        CombinedDeletionPolicy indexPolicy = newCombinedDeletionPolicy(translogPolicy, softDeletesPolicy, globalCheckpoint);
        );
        for (int i = 0; i < invalidCommits; i++) {
                );
        TranslogDeletionPolicy translogPolicy = createTranslogDeletionPolicy();
                    Math.max(
                expectThrows(UnsupportedOperationException.class, snapshot::delete);
        indexPolicy.onCommit(commitList);
        return commit;
        long lastCheckpoint = lastMaxSeqNo;
            assertThat(
 * not use this file except in compliance with the License.
 * compatible open source license.
import org.opensearch.index.seqno.SequenceNumbers;
        TranslogDeletionPolicy translogPolicy = createTranslogDeletionPolicy();
                ? lastMaxSeqNo
            int newCommits = between(1, 10);
            assertTrue(indexPolicy.hasUnreferencedCommits());
        when(commit.getUserData()).thenReturn(userData);
        List<IndexCommit> commitList = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // Safe commit is the last commit - no need to clean up
            globalCheckpoint.set(randomLongBetween(lower, upper));
        for (int i = 0; i < totalCommits; i++) {
            commitList.forEach(this::resetDeletion);
 */
            indexPolicy.onCommit(commitList);
            }
    public void testAcquireIndexCommit() throws Exception {
            equalTo(getLocalCheckpoint(CombinedDeletionPolicy.findSafeCommitPoint(commitList, globalCheckpoint.get())) + 1)
        when(commit.isDeleted()).thenAnswer(args -> deleted.get());
 * The OpenSearch Contributors require contributions made to
        globalCheckpoint.set(randomLongBetween(lower, upper));
        final UUID translogUUID = UUID.randomUUID();
        userData.put(Translog.TRANSLOG_UUID_KEY, translogUUID.toString());
                verify(commitList.get(i), times(1)).delete();
        int keptIndex = randomInt(commitList.size() - 1);
                    NO_OPS_PERFORMED,
            commitList.add(mockIndexCommit(lastCheckpoint, lastMaxSeqNo, translogUUID));
                lastMaxSeqNo += between(1, 1000);
 * license agreements. See the NOTICE file distributed with
        assertThat(
            lastMaxSeqNo += between(1, 10000);
                )
            for (int n = 0; n < captures; n++) {
            commitList.forEach(this::resetDeletion);
            )
        );
        final long upper = keptIndex == commitList.size() - 1
                    Math.min(getLocalCheckpoint(commitList.get(keptIndex)) + 1, globalCheckpoint.get() + 1 - extraRetainedOps)
        final List<IndexCommit> commitList = new ArrayList<>();
        globalCheckpoint.set(Long.parseLong(commitList.get(safeCommitIndex).getUserData().get(SequenceNumbers.MAX_SEQ_NO)));
        TranslogDeletionPolicy translogPolicy,
        globalCheckpoint.set(randomLongBetween(lastMaxSeqNo, Long.MAX_VALUE));
                    equalTo(pendingSnapshots == 0 && snapshot.equals(lastCommit) == false && snapshot.equals(safeCommit) == false)
        final TranslogDeletionPolicy translogPolicy = createTranslogDeletionPolicy();
        final List<Long> maxSeqNoList = new ArrayList<>();
        int totalCommits = between(2, 20);
        indexPolicy.onCommit(commitList);
        final AtomicLong globalCheckpoint = new AtomicLong(randomNonNegativeLong());
import org.opensearch.index.seqno.RetentionLeases;
            maxSeqNoList.add(lastMaxSeqNo);
        long lastMaxSeqNo = between(1, 1000);
        int totalCommits = between(2, 20);
            lastCheckpoint = randomLongBetween(lastCheckpoint, lastMaxSeqNo);
            globalCheckpoint.set(
            globalCheckpoint.set(randomLongBetween(lastMaxSeqNo, Long.MAX_VALUE));
        CombinedDeletionPolicy indexPolicy = newCombinedDeletionPolicy(translogPolicy, softDeletesPolicy, globalCheckpoint);
            assertThat(indexPolicy.hasUnreferencedCommits(), equalTo(false));
                Math.max(
            for (int n = 0; n < newCommits; n++) {
        }
import java.util.HashMap;
            IndexCommit safeCommit = CombinedDeletionPolicy.findSafeCommitPoint(commitList, globalCheckpoint.get());
        // We should never keep invalid commits regardless of the value of the global checkpoint.
                softDeletesPolicy.getMinRetainedSeqNo(),
import static org.mockito.Mockito.verify;
        final int extraRetainedOps = between(0, 100);
        long lastCheckpoint = randomLongBetween(-1, lastMaxSeqNo);
/*
        final int extraRetainedOps = between(0, 100);
            lastMaxSeqNo += between(1, 10000);
    private long getLocalCheckpoint(IndexCommit commit) throws IOException {
        for (int i = 0; i < commitList.size() - 1; i++) {
package org.opensearch.index.engine;
            () -> RetentionLeases.EMPTY
            assertThat(translogPolicy.getLocalCheckpointOfSafeCommit(), equalTo(getLocalCheckpoint(commitList.get(commitList.size() - 1))));
        );
import static org.mockito.Mockito.when;
        indexPolicy.onCommit(commitList);
                verify(commitList.get(i), never()).delete();
                randomLongBetween(globalCheckpoint.get(), Long.parseLong(nextSafeCommit.getUserData().get(SequenceNumbers.MAX_SEQ_NO)) - 1)
        List<IndexCommit> snapshottingCommits = new ArrayList<>();
                safeCommit = CombinedDeletionPolicy.findSafeCommitPoint(commitList, globalCheckpoint.get());
        indexPolicy.onCommit(commitList);
        if (safeCommitIndex == commitList.size() - 1) {
                snapshottingCommits.remove(snapshot);
            } else {
            // Advance the global checkpoint to between [safeIndex, safeIndex + 1)
                snapshottingCommits.add(snapshot);
            assertThat(commitList.get(i).isDeleted(), equalTo(true));
        when(commit.getDirectory()).thenReturn(directory);
import static org.mockito.Mockito.doAnswer;
        int safeCommitIndex = randomIntBetween(0, commitList.size() - 1);
        assertThat(commitList.get(commitList.size() - 1).isDeleted(), equalTo(false));
        assertThat(translogPolicy.getLocalCheckpointOfSafeCommit(), equalTo(getLocalCheckpoint(commitList.get(commitList.size() - 1))));
            snapshottingCommits.forEach(snapshot -> assertThat(snapshot.isDeleted(), equalTo(false)));
            globalCheckpoint::get,
                    indexPolicy.releaseCommit(snapshot),
    IndexCommit mockIndexCommit(long localCheckpoint, long maxSeqNo, UUID translogUUID) throws IOException {
            globalCheckpoint::get,
 * You may obtain a copy of the License at
            // Advanced but not enough for any commit after the safe commit becomes safe
        for (int i = 0; i < invalidCommits - 1; i++) {
    }
        commitList.forEach(this::resetDeletion);
    ) {
            globalCheckpoint.set(
            ? Long.MAX_VALUE
        long lastMaxSeqNo = between(1, 1000);
        snapshottingCommits.forEach(indexPolicy::releaseCommit);
        return new CombinedDeletionPolicy(logger, translogPolicy, softDeletesPolicy, globalCheckpoint::get) {
            protected int getDocCountOfCommit(IndexCommit indexCommit) {
            if (i < keptIndex) {
        final List<IndexCommit> commitList = new ArrayList<>();
}
        assertThat(
        }
import org.opensearch.test.OpenSearchTestCase;
            NO_OPS_PERFORMED,
                        Math.min(getLocalCheckpoint(commitList.get(safeIndex)) + 1, globalCheckpoint.get() + 1 - extraRetainedOps)
            );
            }
            : Math.max(maxSeqNoList.get(keptIndex), maxSeqNoList.get(keptIndex + 1) - 1);
import org.opensearch.index.translog.Translog;
                commitList.add(mockIndexCommit(lastCheckpoint, lastMaxSeqNo, translogUUID));
 * Unless required by applicable law or agreed to in writing,
        final int invalidCommits = between(1, 10);
                    assertThat(snapshot.getUserData(), equalTo(commitList.get(safeIndex).getUserData()));
        final List<IndexCommit> commitList = new ArrayList<>();
            softDeletesPolicy.getMinRetainedSeqNo(),
                    Math.max(NO_OPS_PERFORMED, Math.min(getLocalCheckpoint(safeCommit) + 1, globalCheckpoint.get() + 1 - extraRetainedOps))
 * ownership. Elasticsearch licenses this file to you under
        final SoftDeletesPolicy softDeletesPolicy = new SoftDeletesPolicy(
 * this file be licensed under the Apache-2.0 license or a
            safeIndex = randomIntBetween(safeIndex, commitList.size() - 1);
            @Override
        }
    public void testDeleteInvalidCommits() throws Exception {
        return Long.parseLong(commit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
            -1,
        assertThat(
            final List<IndexCommit> releasingSnapshots = randomSubsetOf(snapshottingCommits);
                    )
            equalTo(
                    assertThat(snapshot.getUserData(), equalTo(commitList.get(commitList.size() - 1).getUserData()));
        for (int i = 0; i < commitList.size(); i++) {
        final AtomicBoolean deleted = new AtomicBoolean();
        final SoftDeletesPolicy softDeletesPolicy = new SoftDeletesPolicy(globalCheckpoint::get, -1, 0, () -> RetentionLeases.EMPTY);
            }
            softDeletesPolicy.getMinRetainedSeqNo(),
            long upper = safeIndex == commitList.size() - 1
        final long lower = maxSeqNoList.get(keptIndex);
            commitList.add(mockIndexCommit(randomLongBetween(-1, maxSeqNo), maxSeqNo, UUID.randomUUID()));
import java.util.ArrayList;
public class CombinedDeletionPolicyTests extends OpenSearchTestCase {
                        NO_OPS_PERFORMED,
        }
    }
 *
            int captures = between(0, 5);
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
                assertThat(
import org.apache.lucene.index.IndexCommit;
import static org.mockito.Mockito.never;
            );
            long maxSeqNo = randomNonNegativeLong();
import java.util.concurrent.atomic.AtomicBoolean;
            extraRetainedOps,
        );
                equalTo(
            long lower = Math.max(
    }
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    }
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.UNASSIGNED_SEQ_NO);
import java.util.UUID;
                final IndexCommit snapshot = indexPolicy.acquireIndexCommit(safe);
            commitList.add(mockIndexCommit(lastCheckpoint, lastMaxSeqNo, expectedTranslogUUID));
        final UUID translogUUID = UUID.randomUUID();
        };
/*
            // Captures and releases some commits
import java.util.List;
        for (int i = 0; i < totalCommits; i++) {
    }
                return between(0, 1000);
 * Modifications Copyright OpenSearch Contributors. See
        }
                final IndexCommit lastCommit = commitList.get(commitList.size() - 1);
            );
                Long.parseLong(commitList.get(safeIndex).getUserData().get(SequenceNumbers.MAX_SEQ_NO))
                randomLongBetween(Long.parseLong(nextSafeCommit.getUserData().get(SequenceNumbers.MAX_SEQ_NO)), lastMaxSeqNo)
        final SoftDeletesPolicy softDeletesPolicy = new SoftDeletesPolicy(
            deleted.set(true);
        }
        }
            );
            assertFalse(indexPolicy.hasUnreferencedCommits());
        final int validCommits = between(1, 10);
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
 *
        int safeIndex = 0;
    void resetDeletion(IndexCommit commit) {
                : Long.parseLong(commitList.get(safeIndex + 1).getUserData().get(SequenceNumbers.MAX_SEQ_NO)) - 1;
        CombinedDeletionPolicy indexPolicy = newCombinedDeletionPolicy(translogPolicy, softDeletesPolicy, globalCheckpoint);
 * KIND, either express or implied.  See the License for the
            lastMaxSeqNo += between(1, 1000);
            lastCheckpoint = randomLongBetween(lastCheckpoint, lastMaxSeqNo);
    }
                )
                )
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
            assertThat(translogPolicy.getLocalCheckpointOfSafeCommit(), equalTo(getLocalCheckpoint(commitList.get(safeIndex))));
        final UUID expectedTranslogUUID = UUID.randomUUID();
            // Safe commit is the last commit - no need to clean up
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCheckpoint));
 * under the License.
            }
            }
            IndexCommit nextSafeCommit = commitList.get(safeCommitIndex + 1);
import java.util.Map;
            for (IndexCommit snapshot : releasingSnapshots) {
/*
        AtomicLong globalCheckpoint
        } else {
                }
