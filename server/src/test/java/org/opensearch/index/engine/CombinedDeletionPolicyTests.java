                boolean safe = randomBoolean();  
        final List<IndexCommit> commitList = new ArrayList<>();
            );
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));  
                        Math.min(getLocalCheckpoint(commitList.get(safeIndex)) + 1, globalCheckpoint.get() + 1 - extraRetainedOps)  
            }
            if (i < keptIndex) {
        for (int i = 0; i < iters; i++) {
                final IndexCommit snapshot = indexPolicy.acquireIndexCommit(safe);
            equalTo(
import org.apache.lucene.store.Directory;
            } else {  
            equalTo(Math.max(NO_OPS_PERFORMED, Math.min(getLocalCheckpoint(safeCommit) + 1, globalCheckpoint.get() + 1 - extraRetainedOps)))
            verify(commitList.get(i), times(1)).delete();
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
            commitList.forEach(this::resetDeletion);  
        final List<IndexCommit> commitList = new ArrayList<>();
import java.util.HashMap;
            snapshottingCommits.forEach(snapshot -> assertThat(snapshot.isDeleted(), equalTo(false)));
    }
/*  
        );
        long lastMaxSeqNo = between(1, 1000);  
        long lastCheckpoint = randomLongBetween(-1, lastMaxSeqNo);
        final int extraRetainedOps = between(0, 100);  
import org.opensearch.index.seqno.SequenceNumbers;
            assertThat(translogPolicy.getLocalCheckpointOfSafeCommit(), equalTo(getLocalCheckpoint(commitList.get(safeIndex))));  
        for (int i = 0; i < totalCommits; i++) {
 * KIND, either express or implied.  See the License for the
        when(commit.getUserData()).thenReturn(userData);
        }
import static org.mockito.Mockito.mock;
        final TranslogDeletionPolicy translogPolicy = createTranslogDeletionPolicy();
            for (int n = 0; n < newCommits; n++) {  
                    assertThat(snapshot.getUserData(), equalTo(commitList.get(commitList.size() - 1).getUserData()));
            );
            }  
        final AtomicBoolean deleted = new AtomicBoolean();
            assertTrue(indexPolicy.hasUnreferencedCommits());  
            indexPolicy.onCommit(commitList);
            final List<IndexCommit> releasingSnapshots = randomSubsetOf(snapshottingCommits);
            assertThat(
        final long upper = keptIndex == commitList.size() - 1  
            : Math.max(maxSeqNoList.get(keptIndex), maxSeqNoList.get(keptIndex + 1) - 1);
        snapshottingCommits.forEach(indexPolicy::releaseCommit);
        for (int i = 0; i < commitList.size(); i++) {  
        indexPolicy.onCommit(commitList);
        );  
                    equalTo(pendingSnapshots == 0 && snapshot.equals(lastCommit) == false && snapshot.equals(safeCommit) == false)  
import org.opensearch.index.translog.Translog;
                Math.max(
                    Math.max(
public class CombinedDeletionPolicyTests extends OpenSearchTestCase {
                    assertThat(snapshot.getUserData(), equalTo(commitList.get(safeIndex).getUserData()));
        }  
            // Advanced but not enough for any commit after the safe commit becomes safe
        CombinedDeletionPolicy indexPolicy = newCombinedDeletionPolicy(translogPolicy, softDeletesPolicy, globalCheckpoint);
            extraRetainedOps,
/*
        indexPolicy.onCommit(commitList);  
                verify(commitList.get(i), never()).delete();
        final UUID translogUUID = UUID.randomUUID();
            () -> RetentionLeases.EMPTY
        } else {
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.OpenSearchTestCase;
    public void testDeleteInvalidCommits() throws Exception {  
            commitList.add(mockIndexCommit(lastCheckpoint, lastMaxSeqNo, translogUUID));  
                )
import java.util.List;  
        when(commit.getDirectory()).thenReturn(directory);
import java.util.concurrent.atomic.AtomicLong;
        final int validCommits = between(1, 10);
                    Math.min(getLocalCheckpoint(commitList.get(keptIndex)) + 1, globalCheckpoint.get() + 1 - extraRetainedOps)
import org.opensearch.index.translog.TranslogDeletionPolicy;  
                randomLongBetween(globalCheckpoint.get(), Long.parseLong(nextSafeCommit.getUserData().get(SequenceNumbers.MAX_SEQ_NO)) - 1)
            lastMaxSeqNo += between(1, 10000);  
        return Long.parseLong(commit.getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
            // Advanced enough for the last commit becomes safe
            softDeletesPolicy.getMinRetainedSeqNo(),  
        long lastCheckpoint = randomLongBetween(-1, lastMaxSeqNo);
        }
        final UUID translogUUID = UUID.randomUUID();
            NO_OPS_PERFORMED,
                randomLongBetween(Long.parseLong(nextSafeCommit.getUserData().get(SequenceNumbers.MAX_SEQ_NO)), lastMaxSeqNo)
        final Directory directory = mock(Directory.class);  
            lastCheckpoint = randomLongBetween(lastCheckpoint, lastMaxSeqNo);
    }
 */  
                equalTo(  
        }).when(commit).delete();
 */
        assertThat(
            // Advance the global checkpoint to between [safeIndex, safeIndex + 1)
                    Math.max(NO_OPS_PERFORMED, Math.min(getLocalCheckpoint(safeCommit) + 1, globalCheckpoint.get() + 1 - extraRetainedOps))  
        final SoftDeletesPolicy softDeletesPolicy = new SoftDeletesPolicy(globalCheckpoint::get, -1, 0, () -> RetentionLeases.EMPTY);  
        CombinedDeletionPolicy indexPolicy = newCombinedDeletionPolicy(translogPolicy, softDeletesPolicy, globalCheckpoint);
 *     http://www.apache.org/licenses/LICENSE-2.0
            IndexCommit safeCommit = CombinedDeletionPolicy.findSafeCommitPoint(commitList, globalCheckpoint.get());
                softDeletesPolicy.getMinRetainedSeqNo(),
 *
                }
        // We should never keep invalid commits regardless of the value of the global checkpoint.
            assertThat(indexPolicy.hasUnreferencedCommits(), equalTo(false));
            equalTo(getLocalCheckpoint(CombinedDeletionPolicy.findSafeCommitPoint(commitList, globalCheckpoint.get())) + 1)  
        }  
        indexPolicy.onCommit(commitList);
        doAnswer(arg -> {
import org.opensearch.index.seqno.RetentionLeases;  
            // Snapshotting commits must not be deleted.  
            commitList.add(mockIndexCommit(lastCheckpoint, lastMaxSeqNo, translogUUID));
                softDeletesPolicy.getMinRetainedSeqNo(),
        for (int i = 0; i < invalidCommits; i++) {
        for (int i = 0; i < commitList.size() - 1; i++) {  
            ? Long.MAX_VALUE
        long lastCheckpoint = lastMaxSeqNo;
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;  
                globalCheckpoint.get(),
        globalCheckpoint.set(randomLongBetween(lastMaxSeqNo, Long.MAX_VALUE));  
        for (int i = 0; i < totalCommits; i++) {  
import org.apache.lucene.index.IndexCommit;
            softDeletesPolicy.getMinRetainedSeqNo(),
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.UNASSIGNED_SEQ_NO);
                final IndexCommit lastCommit = commitList.get(commitList.size() - 1);
        long lastCheckpoint = randomLongBetween(-1, lastMaxSeqNo);
        List<IndexCommit> snapshottingCommits = new ArrayList<>();
        AtomicLong globalCheckpoint
 * Licensed to Elasticsearch under one or more contributor  
            -1,  
            maxSeqNoList.add(lastMaxSeqNo);
                    )
            assertThat(commitList.get(i).isDeleted(), equalTo(true));
                lastMaxSeqNo += between(1, 1000);
            assertThat(translogPolicy.getLocalCheckpointOfSafeCommit(), equalTo(getLocalCheckpoint(commitList.get(commitList.size() - 1))));
 *
    public void testKeepCommitsAfterGlobalCheckpoint() throws Exception {  
        assertThat(commitList.get(commitList.size() - 1).isDeleted(), equalTo(false));  
            }
                assertThat(
    ) {  
            return null;  
 * compatible open source license.
import static org.mockito.Mockito.verify;
        final IndexCommit commit = mock(IndexCommit.class);
        assertThat(translogPolicy.getLocalCheckpointOfSafeCommit(), equalTo(getLocalCheckpoint(commitList.get(commitList.size() - 1))));
        globalCheckpoint.set(Long.parseLong(commitList.get(safeCommitIndex).getUserData().get(SequenceNumbers.MAX_SEQ_NO)));
                equalTo(
        final int iters = between(5, 10);  
    public void testCheckUnreferencedCommits() throws Exception {
import java.util.concurrent.atomic.AtomicBoolean;  
 * this work for additional information regarding copyright
        );
        long lastMaxSeqNo = 0;  
}
        }
        for (int i = 0; i < invalidCommits - 1; i++) {
            );
            () -> RetentionLeases.EMPTY
            );  
                lastCheckpoint = randomLongBetween(lastCheckpoint, lastMaxSeqNo);
        int keptIndex = randomInt(commitList.size() - 1);
 * The OpenSearch Contributors require contributions made to  
                snapshottingCommits.remove(snapshot);  
    }
        final SoftDeletesPolicy softDeletesPolicy = new SoftDeletesPolicy(  
        SoftDeletesPolicy softDeletesPolicy,
        final AtomicLong globalCheckpoint = new AtomicLong();
        commitList.forEach(this::resetDeletion);
                )
            protected int getDocCountOfCommit(IndexCommit indexCommit) {  
            globalCheckpoint::get,
        long lastMaxSeqNo = between(1, 1000);  
                safeCommit = CombinedDeletionPolicy.findSafeCommitPoint(commitList, globalCheckpoint.get());  
            globalCheckpoint.set(  
            lastMaxSeqNo += between(1, 10000);
            softDeletesPolicy.getMinRetainedSeqNo(),
            long upper = safeIndex == commitList.size() - 1
 * software distributed under the License is distributed on an
            safeIndex = randomIntBetween(safeIndex, commitList.size() - 1);  
import java.util.UUID;
            // Captures and releases some commits  
        TranslogDeletionPolicy translogPolicy,  
                        NO_OPS_PERFORMED,
        return commit;
                verify(commitList.get(i), times(1)).delete();
            int captures = between(0, 5);
        final long lower = maxSeqNoList.get(keptIndex);
        if (safeCommitIndex == commitList.size() - 1) {  
        }  
/*  
            lastCheckpoint = randomLongBetween(lastCheckpoint, lastMaxSeqNo);
            assertThat(indexPolicy.hasUnreferencedCommits(), equalTo(false));  
                ? lastMaxSeqNo  
            int newCommits = between(1, 10);
    }  
    IndexCommit mockIndexCommit(long localCheckpoint, long maxSeqNo, UUID translogUUID) throws IOException {  
            @Override
 * specific language governing permissions and limitations
    public void testAcquireIndexCommit() throws Exception {
                snapshottingCommits.add(snapshot);  
    private long getLocalCheckpoint(IndexCommit commit) throws IOException {
            commitList.add(mockIndexCommit(randomLongBetween(-1, maxSeqNo), maxSeqNo, UUID.randomUUID()));
import static org.mockito.Mockito.doAnswer;  
                    indexPolicy.releaseCommit(snapshot),
    }
            for (int n = 0; n < captures; n++) {
        CombinedDeletionPolicy indexPolicy = newCombinedDeletionPolicy(translogPolicy, softDeletesPolicy, globalCheckpoint);  
                Long.parseLong(commitList.get(safeIndex).getUserData().get(SequenceNumbers.MAX_SEQ_NO))  
 * GitHub history for details.
            )  
    void resetDeletion(IndexCommit commit) {
 * SPDX-License-Identifier: Apache-2.0
                expectThrows(UnsupportedOperationException.class, snapshot::delete);
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCheckpoint));
            extraRetainedOps,  
        int safeCommitIndex = randomIntBetween(0, commitList.size() - 1);
            assertFalse(indexPolicy.hasUnreferencedCommits());
import static org.mockito.Mockito.times;  
 */  
 * not use this file except in compliance with the License.
        );  
                final long pendingSnapshots = snapshottingCommits.stream().filter(snapshot::equals).count();
            globalCheckpoint.set(randomLongBetween(lower, upper));
        final List<Long> maxSeqNoList = new ArrayList<>();  
            );  
        int totalCommits = between(2, 20);
            globalCheckpoint.set(
                if (safe) {
        assertThat(
            globalCheckpoint::get,
            // Safe commit is the last commit - no need to clean up
            assertThat(  
        final int extraRetainedOps = between(0, 100);
    }
import java.util.ArrayList;
            globalCheckpoint.set(randomLongBetween(lastMaxSeqNo, Long.MAX_VALUE));
        long lastMaxSeqNo = between(1, 1000);
        globalCheckpoint.set(randomLongBetween(lower, upper));  
        for (int i = 0; i < validCommits; i++) {
        final SoftDeletesPolicy softDeletesPolicy = new SoftDeletesPolicy(
 * Modifications Copyright OpenSearch Contributors. See
        int safeIndex = 0;  
            commitList.add(mockIndexCommit(lastCheckpoint, lastMaxSeqNo, expectedTranslogUUID));
import static org.mockito.Mockito.never;
 * under the License.  
        final SoftDeletesPolicy softDeletesPolicy = new SoftDeletesPolicy(globalCheckpoint::get, -1, 0, () -> RetentionLeases.EMPTY);
            // Safe commit is the last commit - no need to clean up
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                } else {  
import static org.hamcrest.Matchers.equalTo;
            // We don't need to retain translog for snapshotting commits.
        final Map<String, String> userData = new HashMap<>();
import java.util.Map;
        assertThat(  
        assertThat(translogPolicy.getLocalCheckpointOfSafeCommit(), equalTo(getLocalCheckpoint(commitList.get(keptIndex))));
        when(commit.isDeleted()).thenAnswer(args -> deleted.get());  
            }
            assertThat(translogPolicy.getLocalCheckpointOfSafeCommit(), equalTo(getLocalCheckpoint(commitList.get(commitList.size() - 1))));  
        int totalCommits = between(2, 20);
        }
    private CombinedDeletionPolicy newCombinedDeletionPolicy(
            IndexCommit nextSafeCommit = commitList.get(safeCommitIndex + 1);  
        final AtomicLong globalCheckpoint = new AtomicLong(randomNonNegativeLong());
        TranslogDeletionPolicy translogPolicy = createTranslogDeletionPolicy();  
        userData.put(Translog.TRANSLOG_UUID_KEY, translogUUID.toString());
            }
                    NO_OPS_PERFORMED,  
        final int invalidCommits = between(1, 10);  
            long lower = Math.max(
        CombinedDeletionPolicy indexPolicy = newCombinedDeletionPolicy(translogPolicy, softDeletesPolicy, globalCheckpoint);  
                );
            commitList.forEach(this::resetDeletion);  
            long maxSeqNo = randomNonNegativeLong();  
        final UUID translogUUID = UUID.randomUUID();
        }
 *  
        indexPolicy.onCommit(commitList);
    }  
        final AtomicLong globalCheckpoint = new AtomicLong();
        resetDeletion(commit);  
                )
 * the Apache License, Version 2.0 (the "License"); you may
            deleted.set(true);
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.index.engine;
import java.io.IOException;  
        IndexCommit safeCommit = CombinedDeletionPolicy.findSafeCommitPoint(commitList, globalCheckpoint.get());
        TranslogDeletionPolicy translogPolicy = createTranslogDeletionPolicy();
            indexPolicy.onCommit(commitList);
                : Long.parseLong(commitList.get(safeIndex + 1).getUserData().get(SequenceNumbers.MAX_SEQ_NO)) - 1;
        TranslogDeletionPolicy translogPolicy = createTranslogDeletionPolicy();  
        };  
        return new CombinedDeletionPolicy(logger, translogPolicy, softDeletesPolicy, globalCheckpoint::get) {
        List<IndexCommit> commitList = new ArrayList<>();
import static org.mockito.Mockito.when;
        commitList.forEach(this::resetDeletion);  
    }
        }  
            // Advanced enough for some index commit becomes safe
        );
 * You may obtain a copy of the License at  
                commitList.add(mockIndexCommit(lastCheckpoint, lastMaxSeqNo, translogUUID));  
        final List<IndexCommit> commitList = new ArrayList<>();
        final UUID expectedTranslogUUID = UUID.randomUUID();
            lastCheckpoint = randomLongBetween(lastCheckpoint, lastMaxSeqNo);
            lastMaxSeqNo += between(1, 1000);  
                return between(0, 1000);
            for (IndexCommit snapshot : releasingSnapshots) {
 * ownership. Elasticsearch licenses this file to you under  
