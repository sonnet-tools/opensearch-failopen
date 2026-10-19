                public void onFailure(Exception e) {
                protected void doRun() throws Exception {
import static org.hamcrest.Matchers.is;
                }
        assertThat(tracker.hasProcessed(2L), equalTo(true));
            thread.join();
            }, "testConcurrentPrimary_" + threadId);
        assertThat(seqNo1, equalTo(1L));
        final int maxOps = BIT_SET_SIZE * randomIntBetween(1, 5) + (aligned ? 0 : randomIntBetween(1, BIT_SET_SIZE - 1));
 * GitHub history for details.
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(maxSeqNo, localCheckpoint);
 */
        final CyclicBarrier barrier = new CyclicBarrier(threads.length);
                    }
        final int seqNo = randomIntBetween(0, 32);
        barrier.await();
        final long maxSeqNo = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, 100);
import java.util.stream.Collectors;
                        }
        final Thread thread = new Thread(() -> {
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
                barrier.await();
        assertThat(tracker.getProcessedCheckpoint(), equalTo(maxOps - 1L));
                        long seqNo = tracker.generateSeqNo();
 * under the License.
/*
 * SPDX-License-Identifier: Apache-2.0
        assertThat(tracker.hasProcessed(between(0, 2)), equalTo(true));
}
    }
public class LocalCheckpointTrackerTests extends OpenSearchTestCase {
            }
 *
                }
        assertThat(tracker.hasProcessed(randomNonNegativeLong()), equalTo(false));
            threads[t] = new Thread(new AbstractRunnable() {
        assertThat(seqNo1, equalTo(1L));
import static org.opensearch.index.seqno.LocalCheckpointTracker.BIT_SET_SIZE;
                complete.set(true);
 * You may obtain a copy of the License at
        for (Long seqNo : seqNoList) {
        assertThat(tracker.getProcessedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
 * this work for additional information regarding copyright
        assertThat(tracker.hasProcessed(unFinishedSeq), equalTo(true));
        if (tracker.processedSeqNo.size() == 1) {
import java.util.stream.IntStream;
        tracker.markSeqNoAsPersisted(0L);
            thread.join();
            } catch (BrokenBarrierException | InterruptedException e) {
        final int maxOps = opsPerThread * threads.length;
        if (tracker.processedSeqNo.size() == 1) {
        assertTrue(complete.get());
import static org.hamcrest.Matchers.oneOf;
                public void onFailure(Exception e) {
 * specific language governing permissions and limitations
                    throw new OpenSearchException("failure in background thread", e);
        assertThat(tracker.hasProcessed(notCompletedSeqNo), equalTo(false));
import java.util.concurrent.BrokenBarrierException;
            final int threadId = t;
        super.setUp();
        thread.start();
        assertThat(tracker.hasProcessed(atLeast(3)), equalTo(false));
        seqNoPerThread[threads.length - 1] = seqNos.toArray(new Integer[0]);
                throw new RuntimeException(e);
    public void testSimpleReplicaPersisted() {
            }, "testConcurrentReplica_" + threadId);
        assertThat(tracker.getPersistedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        tracker.markSeqNoAsProcessed(seqNo);
        assertThat(tracker.getMaxSeqNo(), equalTo(maxOps - 1L));
        assertThat(tracker.getPersistedCheckpoint(), equalTo(0L));
        assertThat(tracker.getMaxSeqNo(), equalTo(maxOps - 1L));
        assertThat(tracker.hasProcessed(0L), equalTo(true));
 * Modifications Copyright OpenSearch Contributors. See
        seqNo1 = tracker.generateSeqNo();
        seqNo2 = tracker.generateSeqNo();
            threads[t].start();
        for (int t = 0; t < threads.length; t++) {
        tracker.markSeqNoAsPersisted(seqNo1);
        }
        assertThat(tracker.hasProcessed(randomLongBetween(localCheckpoint + 1, Long.MAX_VALUE)), equalTo(false));
 *
 * license agreements. See the NOTICE file distributed with
        assertThat(tracker.hasProcessed(atLeast(1)), equalTo(false));
                @Override
    @Before
import java.util.concurrent.atomic.AtomicBoolean;
        return new LocalCheckpointTracker(SequenceNumbers.NO_OPS_PERFORMED, SequenceNumbers.NO_OPS_PERFORMED);
        assertThat(tracker.hasProcessed(unFinishedSeq), equalTo(false));
        assertThat(tracker.getMaxSeqNo(), equalTo(2L));
        tracker.markSeqNoAsPersisted(seqNo1);
            tracker.markSeqNoAsProcessed(seqNo);
    public void testLazyInitialization() {
        final long seqNo = randomNonNegativeLong();
 * Licensed to Elasticsearch under one or more contributor
        /*
        barrier.await();
        Set<Integer> seqNos = IntStream.range(0, maxOps).boxed().collect(Collectors.toSet());
 *     http://www.apache.org/licenses/LICENSE-2.0
        tracker.fastForwardProcessedSeqNo(seqNo1);
        tracker.markSeqNoAsPersisted(seqNo2);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
import java.util.Arrays;
            seqNoList.add(i);
        seqNo2 = tracker.generateSeqNo();
        assertThat(tracker.hasProcessed(seqNo1), equalTo(false));
        assertThat(tracker.getPersistedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
        // base case with no persistent checkpoint update
        }
        assertThat(tracker.hasProcessed(between(0, 2)), equalTo(true));
    }
        assertThat(tracker.hasProcessed(seqNo), equalTo(true));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
 * ownership. Elasticsearch licenses this file to you under
        assertThat(tracker.getMaxSeqNo(), equalTo(2L));
        assertThat(tracker.hasProcessed(randomNonNegativeLong()), equalTo(false));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(unFinishedSeq - 1L));
                barrier.await();
         * sequence numbers this could lead to excessive memory usage resulting in out of memory errors.
            tracker.markSeqNoAsProcessed(seqNo);
    public void testSimplePrimaryProcessed() {
 * Unless required by applicable law or agreed to in writing,
            assertThat(tracker.processedSeqNo.keySet().iterator().next(), equalTo(tracker.processedCheckpoint.get() / BIT_SET_SIZE));
 * not use this file except in compliance with the License.
            seqNoPerThread[t] = randomSubsetOf(size, seqNos).toArray(new Integer[size]);
        Thread[] threads = new Thread[randomIntBetween(2, 5)];
        Collections.shuffle(seqNoList, random());
        assertThat(tracker.processedSeqNo.size(), equalTo(1));
        tracker.markSeqNoAsProcessed(seqNo2);
                    barrier.await();
                    for (int i = 0; i < opsPerThread; i++) {
        tracker.markSeqNoAsProcessed(0L);
        assertThat(seqNo1, equalTo(0L));
    public void testFastForwardProcessedSeqNo() {
        // synchronize with the waiting thread to mark that it is complete
    }
        assertThat(tracker.getMaxSeqNo(), equalTo(2L));
        Thread[] threads = new Thread[randomIntBetween(2, 5)];
                @Override
        seqNo1 = tracker.generateSeqNo();
    public void setUp() throws Exception {
 */
        final boolean aligned = randomBoolean();
        final List<Integer> elements = IntStream.rangeClosed(0, seqNo).boxed().collect(Collectors.toList());
        assertThat(tracker.getMaxSeqNo(), equalTo(2L));
    }
                    barrier.await();
        for (int t = 0; t < threads.length; t++) {
    public void testWaitForOpsToComplete() throws BrokenBarrierException, InterruptedException {
    public void testConcurrentPrimary() throws InterruptedException {
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
                    throw new OpenSearchException("failure in background thread", e);
        }
                tracker.waitForProcessedOpsToComplete(seqNo);
        assertThat(tracker.getPersistedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                            tracker.markSeqNoAsProcessed(seqNo);
        assertThat(tracker.getPersistedCheckpoint(), equalTo(0L));
            tracker.markSeqNoAsProcessed(elements.get(i));
        }
 *
        assertThat(tracker.getProcessedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        assertThat(tracker.hasProcessed(randomLongBetween(maxOps, Long.MAX_VALUE)), equalTo(false));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    public void testConcurrentReplica() throws InterruptedException {
        assertThat(tracker.hasProcessed(0), equalTo(true));
import java.util.Set;
        final long unFinishedSeq = randomIntBetween(0, maxOps - 2); // make sure we always index the last seqNo to simplify maxSeq checks
import org.opensearch.common.Randomness;
         */
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
 * software distributed under the License is distributed on an
        }
        tracker.markSeqNoAsPersisted(2L);
 * this file be licensed under the Apache-2.0 license or a
            assertThat(tracker.processedSeqNo.keySet().iterator().next(), equalTo(tracker.processedCheckpoint.get() / BIT_SET_SIZE));
        assertThat(tracker.hasProcessed(seqNo2), equalTo(true));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(2L));
        assertThat(seqNo2, equalTo(2L));
            try {
        logger.info("--> will run [{}] threads, maxOps [{}], unfinished seq no [{}]", threads.length, maxOps, unFinishedSeq);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                }
        final AtomicBoolean complete = new AtomicBoolean();
        final long localCheckpoint = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, maxSeqNo);
        assertThat(tracker.getPersistedCheckpoint(), equalTo(2L));
        assertThat(tracker.hasProcessed(randomFrom(seqNoList)), equalTo(true));
    }
        final long unFinishedSeq = randomIntBetween(0, maxOps - 2); // make sure we always index the last seqNo to simplify maxSeq checks
        long seqNo1, seqNo2;
        });
                        logger.info("[t{}] started   [{}]", threadId, seqNo);
        seqNo1 = tracker.generateSeqNo();
        final int opsPerThread = randomIntBetween(10, 20);
    }
        long seqNo = randomNonNegativeLong();
        final CyclicBarrier barrier = new CyclicBarrier(2);
        if (aligned == false) {
            assertThat(tracker.processedSeqNo.keySet().iterator().next(), equalTo(tracker.processedCheckpoint.get() / BIT_SET_SIZE));
            final int threadId = t;
        tracker.fastForwardProcessedSeqNo(seqNo1);
        seqNo1 = tracker.generateSeqNo();
    public void testContains() {
import java.util.concurrent.CyclicBarrier;
        for (Thread thread : threads) {
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 0; i < numOps; i++) {
    public void testSimpleReplicaProcessed() {
        assertThat(tracker.getProcessedCheckpoint(), equalTo(unFinishedSeq - 1L));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(maxOps - 1L));
            threads[t] = new Thread(new AbstractRunnable() {
        thread.join();
import org.junit.Before;
                }
        final int maxOps = opsPerThread * threads.length;
        tracker.markSeqNoAsPersisted(1L);
                // sychronize starting with the test thread
        assertThat(tracker.processedSeqNo.size(), equalTo(1));
                            tracker.markSeqNoAsProcessed(seqNo);
            seqNos.removeAll(Arrays.asList(seqNoPerThread[t]));
        tracker.fastForwardProcessedSeqNo(-1);
        assertThat(tracker.processedCheckpoint.get(), equalTo(maxOps - 1L));
 * KIND, either express or implied.  See the License for the
                        }
import java.util.Collections;
        for (long i = 0; i < maxOps; i++) {
            int size = Math.min(seqNos.size(), randomIntBetween(opsPerThread - 4, opsPerThread + 4));
        }
        tracker.markSeqNoAsProcessed(2L);
        tracker.markSeqNoAsProcessed(unFinishedSeq);
import org.opensearch.common.util.concurrent.AbstractRunnable;
    }
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
    }
 */
        final int opsPerThread = randomIntBetween(10, 20);
        }
    }
    }
        tracker.markSeqNoAsProcessed(unFinishedSeq);
    @Override
    }
            assertFalse(complete.get());
import java.util.ArrayList;
        if (localCheckpoint >= 0) {
 * The OpenSearch Contributors require contributions made to
        }
        tracker.markSeqNoAsProcessed(elements.get(elements.size() - 1));
        assertThat(tracker.getPersistedCheckpoint(), equalTo(0L));
        assertThat(tracker.processedSeqNo.size(), is(oneOf(0, 1)));
                    for (int seqNo : ops) {
                    Integer[] ops = seqNoPerThread[threadId];
    }
        assertThat(tracker.getPersistedCheckpoint(), equalTo(0L));
         * Previously this would allocate the entire chain of bit sets to the one for the sequence number being marked; for very large
            assertThat(tracker.hasProcessed(randomLongBetween(0, localCheckpoint)), equalTo(true));
        assertThat(tracker.hasProcessed(0L), equalTo(true));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
        final int numOps = between(1, 100);
            seqNos.add(seqNo);
        for (Thread thread : threads) {
 * the Apache License, Version 2.0 (the "License"); you may
        final CyclicBarrier barrier = new CyclicBarrier(threads.length);
        for (int i = 0; i < elements.size() - 1; i++) {
                @Override
                            logger.info("[t{}] completed [{}]", threadId, seqNo);
 * compatible open source license.
        assertThat(tracker.processedSeqNo.size(), equalTo(aligned ? 0 : 1));
                            logger.info("[t{}] completed [{}]", threadId, seqNo);
        assertThat(tracker.hasProcessed(1L), equalTo(false));
        }
        assertThat(tracker.getPersistedCheckpoint(), equalTo(2L));
        Randomness.shuffle(elements);
        tracker.markSeqNoAsProcessed(seqNo1);
        long seqNo1, seqNo2;
        assertThat(tracker.hasProcessed(randomValueOtherThan(seqNo, OpenSearchTestCase::randomNonNegativeLong)), equalTo(false));
        tracker.markSeqNoAsProcessed(seqNo1);
    public void testSimpleOverFlow() {
        }
        assertThat(tracker.hasProcessed(atLeast(3)), equalTo(false));
                protected void doRun() throws Exception {
import java.util.List;
            long seqNo = randomLongBetween(0, 1000);
        for (int t = 0; t < threads.length - 1; t++) {
        List<Long> seqNoList = new ArrayList<>();
import org.opensearch.OpenSearchException;
        assertThat(tracker.getPersistedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(seqNo1));
    public static LocalCheckpointTracker createEmptyTracker() {
        assertThat(tracker.hasProcessed(seqNo), equalTo(seqNo <= localCheckpoint || seqNos.contains(seqNo)));
        // synchronize starting with the waiting thread
                        if (seqNo != unFinishedSeq) {
        assertThat(tracker.getProcessedCheckpoint(), equalTo(2L));
        final long notCompletedSeqNo = randomValueOtherThanMany(seqNoList::contains, OpenSearchTestCase::randomNonNegativeLong);
        long seqNo1;
        }
        }
        logger.info("--> will run [{}] threads, maxOps [{}], unfinished seq no [{}]", threads.length, maxOps, unFinishedSeq);
                        if (seqNo != unFinishedSeq) {
        }
        final Integer[][] seqNoPerThread = new Integer[threads.length][];
        assertThat(seqNo1, equalTo(0L));
    private LocalCheckpointTracker tracker;
package org.opensearch.index.seqno;
/*
    public void testSimplePrimaryPersisted() {
        assertThat(seqNo2, equalTo(2L));
/*
        tracker = createEmptyTracker();
                // synchronize with the test thread checking if we are no longer waiting
        assertThat(tracker.processedSeqNo.size(), is(oneOf(0, 1)));
        final List<Long> seqNos = new ArrayList<>();
                @Override
        assertThat(tracker.hasProcessed(0L), equalTo(true));
                    }
        seqNo1 = tracker.generateSeqNo();
        // idempotent case
        assertThat(seqNo1, equalTo(0L));
        tracker.markSeqNoAsProcessed(1L);
import static org.hamcrest.Matchers.equalTo;
            threads[t].start();
