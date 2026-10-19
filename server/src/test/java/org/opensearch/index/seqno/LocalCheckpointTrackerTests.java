        assertThat(tracker.getProcessedCheckpoint(), equalTo(unFinishedSeq - 1L));
        assertThat(tracker.hasProcessed(between(0, 2)), equalTo(true));
        assertThat(tracker.hasProcessed(2L), equalTo(true));
    }  
        }  
import org.opensearch.OpenSearchException;
    }
                            logger.info("[t{}] completed [{}]", threadId, seqNo);  
        assertThat(tracker.hasProcessed(1L), equalTo(false));  
        for (Thread thread : threads) {
        assertThat(tracker.getProcessedCheckpoint(), equalTo(2L));
        assertThat(seqNo1, equalTo(0L));
        }  
        }
        assertThat(tracker.getPersistedCheckpoint(), equalTo(0L));  
    }  
    public void testLazyInitialization() {
    public void testSimplePrimaryProcessed() {
    }  
        for (long i = 0; i < maxOps; i++) {
        final CyclicBarrier barrier = new CyclicBarrier(2);
        List<Long> seqNoList = new ArrayList<>();
import static org.hamcrest.Matchers.equalTo;
package org.opensearch.index.seqno;
        final Integer[][] seqNoPerThread = new Integer[threads.length][];  
        tracker.markSeqNoAsPersisted(seqNo1);
        tracker.markSeqNoAsProcessed(elements.get(elements.size() - 1));
 * under the License.  
        assertThat(tracker.hasProcessed(unFinishedSeq), equalTo(false));  
        logger.info("--> will run [{}] threads, maxOps [{}], unfinished seq no [{}]", threads.length, maxOps, unFinishedSeq);
import java.util.ArrayList;
        assertThat(tracker.getPersistedCheckpoint(), equalTo(0L));
        assertThat(tracker.getPersistedCheckpoint(), equalTo(2L));  
            assertThat(tracker.processedSeqNo.keySet().iterator().next(), equalTo(tracker.processedCheckpoint.get() / BIT_SET_SIZE));
                    Integer[] ops = seqNoPerThread[threadId];
        final long unFinishedSeq = randomIntBetween(0, maxOps - 2); // make sure we always index the last seqNo to simplify maxSeq checks  
        assertThat(tracker.getProcessedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        tracker.markSeqNoAsPersisted(1L);
                    barrier.await();  
        }
        long seqNo1, seqNo2;  
        final int maxOps = opsPerThread * threads.length;
    public void testContains() {  
                protected void doRun() throws Exception {  
                }  
         * sequence numbers this could lead to excessive memory usage resulting in out of memory errors.
                        logger.info("[t{}] started   [{}]", threadId, seqNo);  
        assertThat(tracker.hasProcessed(seqNo), equalTo(seqNo <= localCheckpoint || seqNos.contains(seqNo)));
                    throw new OpenSearchException("failure in background thread", e);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
import java.util.concurrent.atomic.AtomicBoolean;
        tracker.markSeqNoAsPersisted(2L);  
        final long seqNo = randomNonNegativeLong();  
                @Override  
 * software distributed under the License is distributed on an
        final int opsPerThread = randomIntBetween(10, 20);
 * specific language governing permissions and limitations
                @Override
 */
        tracker.markSeqNoAsProcessed(1L);
                protected void doRun() throws Exception {
        }  
    public void testSimplePrimaryPersisted() {  
        thread.join();  
        assertThat(tracker.processedSeqNo.size(), equalTo(1));  
        assertThat(tracker.getMaxSeqNo(), equalTo(2L));  
 */  
        final int opsPerThread = randomIntBetween(10, 20);  
import org.opensearch.common.Randomness;
            assertThat(tracker.hasProcessed(randomLongBetween(0, localCheckpoint)), equalTo(true));
            thread.join();
            threads[t] = new Thread(new AbstractRunnable() {
            assertThat(tracker.processedSeqNo.keySet().iterator().next(), equalTo(tracker.processedCheckpoint.get() / BIT_SET_SIZE));  
                barrier.await();  
        });
                throw new RuntimeException(e);  
public class LocalCheckpointTrackerTests extends OpenSearchTestCase {
                    throw new OpenSearchException("failure in background thread", e);
/*  
            seqNos.add(seqNo);  
        final AtomicBoolean complete = new AtomicBoolean();
import java.util.stream.Collectors;  
    }
            }
        for (Long seqNo : seqNoList) {  
        assertThat(tracker.processedCheckpoint.get(), equalTo(maxOps - 1L));  
    }
        tracker.markSeqNoAsProcessed(seqNo);
        assertThat(tracker.getMaxSeqNo(), equalTo(2L));
 * this work for additional information regarding copyright
        assertThat(tracker.getMaxSeqNo(), equalTo(maxOps - 1L));
        }  
        for (int i = 0; i < elements.size() - 1; i++) {
                complete.set(true);
                    for (int seqNo : ops) {  
        logger.info("--> will run [{}] threads, maxOps [{}], unfinished seq no [{}]", threads.length, maxOps, unFinishedSeq);  
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
        Thread[] threads = new Thread[randomIntBetween(2, 5)];
        assertThat(tracker.hasProcessed(between(0, 2)), equalTo(true));  
        }
        // synchronize starting with the waiting thread  
 * Licensed to Elasticsearch under one or more contributor  
    public void testSimpleReplicaProcessed() {
        assertThat(tracker.hasProcessed(randomLongBetween(maxOps, Long.MAX_VALUE)), equalTo(false));
        if (tracker.processedSeqNo.size() == 1) {  
        tracker.markSeqNoAsProcessed(2L);
import java.util.stream.IntStream;
        assertThat(tracker.hasProcessed(0L), equalTo(true));
        final int maxOps = opsPerThread * threads.length;
import java.util.Set;
        // synchronize with the waiting thread to mark that it is complete
        barrier.await();
        assertThat(tracker.hasProcessed(0L), equalTo(true));  
        assertThat(tracker.hasProcessed(atLeast(3)), equalTo(false));
        tracker.markSeqNoAsPersisted(seqNo2);
        seqNoPerThread[threads.length - 1] = seqNos.toArray(new Integer[0]);  
        assertThat(tracker.getPersistedCheckpoint(), equalTo(0L));  
        if (aligned == false) {
    public void testFastForwardProcessedSeqNo() {
        assertThat(tracker.hasProcessed(randomValueOtherThan(seqNo, OpenSearchTestCase::randomNonNegativeLong)), equalTo(false));
    }
            try {
            threads[t].start();
                tracker.waitForProcessedOpsToComplete(seqNo);
        assertThat(tracker.hasProcessed(notCompletedSeqNo), equalTo(false));
            tracker.markSeqNoAsProcessed(seqNo);
/*
        return new LocalCheckpointTracker(SequenceNumbers.NO_OPS_PERFORMED, SequenceNumbers.NO_OPS_PERFORMED);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchTestCase;
        assertThat(tracker.hasProcessed(seqNo), equalTo(true));
    }
            int size = Math.min(seqNos.size(), randomIntBetween(opsPerThread - 4, opsPerThread + 4));
        assertThat(tracker.processedSeqNo.size(), equalTo(aligned ? 0 : 1));
        seqNo1 = tracker.generateSeqNo();
        final CyclicBarrier barrier = new CyclicBarrier(threads.length);
 * this file be licensed under the Apache-2.0 license or a
        for (int t = 0; t < threads.length - 1; t++) {
        assertThat(tracker.processedSeqNo.size(), equalTo(1));  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(tracker.hasProcessed(seqNo2), equalTo(true));  
/*  
        assertThat(tracker.getProcessedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));  
        final List<Integer> elements = IntStream.rangeClosed(0, seqNo).boxed().collect(Collectors.toList());  
        assertThat(tracker.getPersistedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
                        long seqNo = tracker.generateSeqNo();
                    }
        final Thread thread = new Thread(() -> {  
        final int seqNo = randomIntBetween(0, 32);  
    public void setUp() throws Exception {  
        assertThat(tracker.hasProcessed(seqNo1), equalTo(false));
        final long localCheckpoint = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, maxSeqNo);
    }  
    }
        assertThat(tracker.getMaxSeqNo(), equalTo(2L));
                            logger.info("[t{}] completed [{}]", threadId, seqNo);  
            seqNoPerThread[t] = randomSubsetOf(size, seqNos).toArray(new Integer[size]);  
    }
import static org.hamcrest.Matchers.oneOf;  
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));  
            }, "testConcurrentReplica_" + threadId);
        for (int t = 0; t < threads.length; t++) {
                public void onFailure(Exception e) {  
            final int threadId = t;  
        assertThat(seqNo1, equalTo(1L));  
        assertThat(tracker.processedSeqNo.size(), is(oneOf(0, 1)));
        seqNo2 = tracker.generateSeqNo();
        assertThat(tracker.getProcessedCheckpoint(), equalTo(maxOps - 1L));
import java.util.List;
}
        assertThat(seqNo2, equalTo(2L));
        thread.start();
        tracker.markSeqNoAsProcessed(seqNo2);  
 * the Apache License, Version 2.0 (the "License"); you may
            }, "testConcurrentPrimary_" + threadId);
        tracker.markSeqNoAsPersisted(seqNo1);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(seqNo1));
        final long unFinishedSeq = randomIntBetween(0, maxOps - 2); // make sure we always index the last seqNo to simplify maxSeq checks
        assertThat(tracker.getPersistedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        assertTrue(complete.get());
        tracker.fastForwardProcessedSeqNo(-1);  
         * Previously this would allocate the entire chain of bit sets to the one for the sequence number being marked; for very large
        }
            threads[t] = new Thread(new AbstractRunnable() {
        assertThat(tracker.getProcessedCheckpoint(), equalTo(unFinishedSeq - 1L));
        for (Thread thread : threads) {
        }  
        // idempotent case
        final int numOps = between(1, 100);
        if (localCheckpoint >= 0) {
                barrier.await();
    public void testConcurrentPrimary() throws InterruptedException {
        // base case with no persistent checkpoint update
        final boolean aligned = randomBoolean();
        Set<Integer> seqNos = IntStream.range(0, maxOps).boxed().collect(Collectors.toSet());
        Randomness.shuffle(elements);
 * GitHub history for details.
        assertThat(tracker.getPersistedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        assertThat(tracker.getPersistedCheckpoint(), equalTo(2L));
    public void testWaitForOpsToComplete() throws BrokenBarrierException, InterruptedException {
    @Before
        final List<Long> seqNos = new ArrayList<>();  
 * SPDX-License-Identifier: Apache-2.0
        tracker.markSeqNoAsProcessed(unFinishedSeq);
        }
        assertThat(tracker.getPersistedCheckpoint(), equalTo(0L));
                        }
            seqNoList.add(i);  
                    barrier.await();
        seqNo1 = tracker.generateSeqNo();
    public void testSimpleOverFlow() {  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(tracker.processedSeqNo.keySet().iterator().next(), equalTo(tracker.processedCheckpoint.get() / BIT_SET_SIZE));
        }
    public static LocalCheckpointTracker createEmptyTracker() {  
        assertThat(tracker.getMaxSeqNo(), equalTo(maxOps - 1L));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
        assertThat(tracker.hasProcessed(atLeast(1)), equalTo(false));
        seqNo2 = tracker.generateSeqNo();  
 *
        long seqNo1;  
        assertThat(seqNo1, equalTo(0L));  
        assertThat(tracker.getMaxSeqNo(), equalTo(2L));
import org.opensearch.common.util.concurrent.AbstractRunnable;  
                        if (seqNo != unFinishedSeq) {
import static org.hamcrest.Matchers.is;
        Collections.shuffle(seqNoList, random());
        long seqNo = randomNonNegativeLong();
        assertThat(seqNo1, equalTo(0L));  
 *
        tracker = createEmptyTracker();
        tracker.fastForwardProcessedSeqNo(seqNo1);
        assertThat(tracker.hasProcessed(randomFrom(seqNoList)), equalTo(true));
    private LocalCheckpointTracker tracker;
 * The OpenSearch Contributors require contributions made to  
        seqNo1 = tracker.generateSeqNo();  
 * KIND, either express or implied.  See the License for the
        }
        final CyclicBarrier barrier = new CyclicBarrier(threads.length);
        tracker.markSeqNoAsProcessed(seqNo1);
            final int threadId = t;
        tracker.markSeqNoAsProcessed(0L);
import org.junit.Before;
                            tracker.markSeqNoAsProcessed(seqNo);
         */  
        assertThat(tracker.hasProcessed(0L), equalTo(true));
        for (int i = 0; i < numOps; i++) {
    }  
                        if (seqNo != unFinishedSeq) {
 * license agreements. See the NOTICE file distributed with
        assertThat(tracker.hasProcessed(unFinishedSeq), equalTo(true));  
        assertThat(tracker.getProcessedCheckpoint(), equalTo(2L));  
        assertThat(tracker.hasProcessed(0), equalTo(true));  
        long seqNo1, seqNo2;
            threads[t].start();
        assertThat(tracker.hasProcessed(randomNonNegativeLong()), equalTo(false));  
                    }
 */  
                }  
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(maxSeqNo, localCheckpoint);  
        seqNo1 = tracker.generateSeqNo();
 * not use this file except in compliance with the License.
            tracker.markSeqNoAsProcessed(elements.get(i));  
                // synchronize with the test thread checking if we are no longer waiting  
import static org.opensearch.index.seqno.LocalCheckpointTracker.BIT_SET_SIZE;  
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final long maxSeqNo = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, 100);
            seqNos.removeAll(Arrays.asList(seqNoPerThread[t]));
        assertThat(tracker.hasProcessed(randomLongBetween(localCheckpoint + 1, Long.MAX_VALUE)), equalTo(false));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
    public void testSimpleReplicaPersisted() {
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
 *  
        seqNo1 = tracker.generateSeqNo();
import java.util.Arrays;
        final int maxOps = BIT_SET_SIZE * randomIntBetween(1, 5) + (aligned ? 0 : randomIntBetween(1, BIT_SET_SIZE - 1));  
import java.util.Collections;  
        assertThat(tracker.getProcessedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                @Override
    public void testConcurrentReplica() throws InterruptedException {
                            tracker.markSeqNoAsProcessed(seqNo);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(maxOps - 1L));
        tracker.markSeqNoAsPersisted(0L);
        /*  
                        }
                    for (int i = 0; i < opsPerThread; i++) {
        assertThat(tracker.getPersistedCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));  
import java.util.concurrent.BrokenBarrierException;  
            long seqNo = randomLongBetween(0, 1000);
        Thread[] threads = new Thread[randomIntBetween(2, 5)];  
        if (tracker.processedSeqNo.size() == 1) {  
            thread.join();
        barrier.await();  
        assertThat(tracker.hasProcessed(randomNonNegativeLong()), equalTo(false));  
        tracker.fastForwardProcessedSeqNo(seqNo1);
                @Override
            } catch (BrokenBarrierException | InterruptedException e) {
        super.setUp();
    }
            tracker.markSeqNoAsProcessed(seqNo);
                }  
        tracker.markSeqNoAsProcessed(seqNo1);
        assertThat(tracker.hasProcessed(atLeast(3)), equalTo(false));
    @Override
        assertThat(seqNo2, equalTo(2L));
 * You may obtain a copy of the License at  
                // sychronize starting with the test thread
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(seqNo1, equalTo(1L));
                public void onFailure(Exception e) {
        tracker.markSeqNoAsProcessed(unFinishedSeq);  
        final long notCompletedSeqNo = randomValueOtherThanMany(seqNoList::contains, OpenSearchTestCase::randomNonNegativeLong);  
        for (int t = 0; t < threads.length; t++) {  
            assertFalse(complete.get());
 * compatible open source license.
import java.util.concurrent.CyclicBarrier;
        assertThat(tracker.processedSeqNo.size(), is(oneOf(0, 1)));
        }
