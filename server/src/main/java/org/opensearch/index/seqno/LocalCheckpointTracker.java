    /**  
     */
            this.notifyAll();
        final CountedBitSet bitSet = getBitSetForSeqNo(bitSetMap, seqNo);
        if (seqNo <= processedCheckpoint.get()) {
    }
                current = bitSetMap.get(++bitSetKey);  
 */
    /**  
     *
    final AtomicLong nextSeqNo = new AtomicLong();
            }
     */
     * Waits for all operations up to the provided sequence number to complete.
            return;
     *  
 * previous sequence numbers have been processed (inclusive).
        return persistedCheckpoint.get();
        assert Thread.holdsLock(this);
            this.wait();
        return nextSeqNo.get() - 1;
     * constructs a {@link SeqNoStats} object, using local state and the supplied global checkpoint
                    assert removed == current;
                    assert current != null;  
            if (seqNo <= processedCheckpoint.get()) {  
     *  
     * or {@link SequenceNumbers#NO_OPS_PERFORMED}.
            return false;  
    public synchronized void markSeqNoAsProcessed(final long seqNo) {
import org.opensearch.common.Nullable;
    public long generateSeqNo() {  
     */
    }
     * The next available sequence number.  
    }
        }
     * A collection of bit sets representing durably persisted sequence numbers. Each sequence number is mapped to a bit set by dividing by
 * Licensed to Elasticsearch under one or more contributor  
    }
package org.opensearch.index.seqno;
    }  
     *
 *
        if (seqNo == checkPoint.get() + 1) {
     * A collection of bit sets representing processed sequence numbers. Each sequence number is mapped to a bit set by dividing by the
            : "updateCheckpoint is called but the bit following the checkpoint is not set";
     * <p>  
        while (processedCheckpoint.get() < seqNo) {  
     * @param seqNo the sequence number to obtain the bit set for
        synchronized (this) {
     * Initialize the local checkpoint service. The {@code maxSeqNo} should be set to the last sequence number assigned, or
     * The current checkpoint which can be advanced by {@link #markSeqNoAsProcessed(long)}.
            throw new IllegalArgumentException(
        assert Thread.holdsLock(this);
        }
 * @opensearch.internal  
     */
            // check again under lock
        if (maxSeqNo < 0 && maxSeqNo != SequenceNumbers.NO_OPS_PERFORMED) {  
        final long currentProcessedCheckpoint = processedCheckpoint.get();
        }
            do {
     * This is needed to make sure the persisted local checkpoint and max seq no are consistent
 * under the License.  
    @SuppressForbidden(reason = "Object#notifyAll")  
    final Map<Long, CountedBitSet> persistedSeqNo = new HashMap<>();
    /**
     *  
            // this is possible during recovery where we might replay an operation that was also replicated
     * Return the bit set for the provided sequence number, possibly allocating a new set if needed.
import java.util.concurrent.atomic.AtomicLong;  
 * ownership. Elasticsearch licenses this file to you under  
     */
     */
        assert seqNo >= 0 : "invalid seq_no=" + seqNo;
        }
        }
     *  
/*
 * the Apache License, Version 2.0 (the "License"); you may
        assert getBitSetForSeqNo(bitSetMap, checkPoint.get() + 1).get(seqNoToBitSetOffset(checkPoint.get() + 1))  
                }
     * @param seqNo the sequence number to mark as persisted  
    }
     * @param seqNo the sequence number that the checkpoint must advance to before this method returns
     * @throws InterruptedException if the thread was interrupted while blocking on the condition
     */  
    @SuppressForbidden(reason = "Object#wait")
 * Modifications Copyright OpenSearch Contributors. See
        return seqNo / BIT_SET_SIZE;
     * Checks that the sequence number is in an acceptable range for an update to take place.  
    public LocalCheckpointTracker(final long maxSeqNo, final long localCheckpoint) {  
     * take place on the replica allowing us to avoid the check that all sequence numbers
        if (seqNo <= currentProcessedCheckpoint) {  
    public boolean hasProcessed(final long seqNo) {  
     * The maximum sequence number issued so far.
        if (shouldUpdateSeqNo(seqNo, checkPoint.get(), null) == false) {
     * following the current checkpoint is processed.
        }
    }
    /**
 * this file be licensed under the Apache-2.0 license or a
     * @param maxSeqNo        the last sequence number assigned, or {@link SequenceNumbers#NO_OPS_PERFORMED}  
        if (localCheckpoint < 0 && localCheckpoint != SequenceNumbers.NO_OPS_PERFORMED) {
/*  
    public long getPersistedCheckpoint() {  
     *  
    }
    public long getProcessedCheckpoint() {  
     * demand and cleaning up while completed. This constant controls the size of the sets.  
        assert Thread.holdsLock(this);  
 * this work for additional information regarding copyright
                    final CountedBitSet removed = bitSetMap.remove(bitSetKey);
 */  
    public long getMaxSeqNo() {  
 * specific language governing permissions and limitations
     * are consecutively processed.
        markSeqNo(seqNo, processedCheckpoint, processedSeqNo);  
    }
     * @return the next assigned sequence number
    /**
        markSeqNo(seqNo, persistedCheckpoint, persistedSeqNo);  
                 * current bit set, we can clean it.  
    /**
        processedCheckpoint.compareAndSet(currentProcessedCheckpoint, seqNo);  
     * @param localCheckpoint the last known local checkpoint, or {@link SequenceNumbers#NO_OPS_PERFORMED}
     * the bit set size.  
    }
     * can be obtained via {@link #getBitSetForSeqNo(Map, long)}.
     * @return the bit set corresponding to the provided sequence number
            return bitSet != null && bitSet.get(bitSetOffset);
        return bitSetMap.computeIfAbsent(bitSetKey, k -> new CountedBitSet(BIT_SET_SIZE));
 */
 * not use this file except in compliance with the License.
     */  
     */  
 * SPDX-License-Identifier: Apache-2.0
     */
    /**
 * You may obtain a copy of the License at  
            );
    final AtomicLong processedCheckpoint = new AtomicLong();
    final AtomicLong persistedCheckpoint = new AtomicLong();  
        return Math.toIntExact(seqNo % BIT_SET_SIZE);
            return true;  
     */
     */
     * <p>
 *
        persistedCheckpoint.set(localCheckpoint);
                checkPoint.incrementAndGet();  
        advanceMaxSeqNo(seqNo);  
 * software distributed under the License is distributed on an
    final Map<Long, CountedBitSet> processedSeqNo = new HashMap<>();
    private static long getBitSetKey(final long seqNo) {
     * bit set size.  
     * @return the current persisted checkpoint
     *
 *  
     * Issue the next sequence number.
     */
    }
        // make sure we track highest seen sequence number
import org.opensearch.common.SuppressForbidden;
        final long bitSetKey = getBitSetKey(seqNo);
    /**
 * Unless required by applicable law or agreed to in writing,
 *
        if (seqNo >= nextSeqNo.get()) {
     * Checks if the given sequence number was marked as processed in this tracker.
            );  
        }
     * @param seqNo the sequence number to obtain the position for  
     */
            updateCheckpoint(checkPoint, bitSetMap);  
            }
            } while (current != null && current.get(seqNoToBitSetOffset(checkPoint.get() + 1)));
    private void markSeqNo(final long seqNo, final AtomicLong checkPoint, final Map<Long, CountedBitSet> bitSetMap) {  
    }  
     * @param seqNo the sequence number to mark as processed  
/**
 * compatible open source license.
     * The current local checkpoint, i.e., all sequence numbers no more than this number have been processed.
     * @return the maximum sequence number
            long bitSetKey = getBitSetKey(checkPoint.get());
     * {@link SequenceNumbers#NO_OPS_PERFORMED} and {@code localCheckpoint} should be set to the last known local checkpoint,  
        return !((seqNo <= lowerBound) || (upperBound != null && seqNo > upperBound.get()));  
    public synchronized void markSeqNoAsPersisted(final long seqNo) {
     */  
 */  
        return new SeqNoStats(getMaxSeqNo(), getPersistedCheckpoint(), globalCheckpoint);
     *
                "max seq. no. must be non-negative or [" + SequenceNumbers.NO_OPS_PERFORMED + "] but was [" + maxSeqNo + "]"
        } finally {  
                return true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return processedCheckpoint.get();
    /**
                assert checkPoint.get() % BIT_SET_SIZE == BIT_SET_SIZE - 1;
        processedCheckpoint.set(localCheckpoint);  
    static final short BIT_SET_SIZE = 1024;
    /**
     * @param seqNo the sequence number to mark as processed
            return;  
        nextSeqNo.accumulateAndGet(seqNo + 1, Math::max);
    /**
    public void advanceMaxSeqNo(final long seqNo) {
    }
        final int offset = seqNoToBitSetOffset(seqNo);  
     * We keep a bit for each sequence number that is still pending. To optimize allocation, we do so in multiple sets allocating them on
            // notified by updateCheckpoint
     */
                 * The checkpoint always falls in the current bit set or we have already cleaned it; if it falls on the last bit of the
    private boolean shouldUpdateSeqNo(final long seqNo, final long lowerBound, @Nullable final AtomicLong upperBound) {
    private void updateCheckpoint(AtomicLong checkPoint, final Map<Long, CountedBitSet> bitSetMap) {
     * The current persisted local checkpoint, i.e., all sequence numbers no more than this number have been durably persisted.
    /**
     */
                "local checkpoint must be non-negative or [" + SequenceNumbers.NO_OPS_PERFORMED + "] " + "but was [" + localCheckpoint + "]"  
                // the bit set corresponding to the checkpoint has already been removed, set ourselves up for the next bit set
import java.util.Map;
    }
     */
 * license agreements. See the NOTICE file distributed with
        final int bitSetOffset = seqNoToBitSetOffset(seqNo);  
/*  
                if (checkPoint.get() == lastSeqNoInBitSet(bitSetKey)) {
    private static long lastSeqNoInBitSet(final long bitSetKey) {  
    /**
        advanceMaxSeqNo(seqNo);
     *  
                    current = bitSetMap.get(++bitSetKey);  
            // notifies waiters in waitForProcessedOpsToComplete
    }
    /**  
    public synchronized void waitForProcessedOpsToComplete(final long seqNo) throws InterruptedException {
        return nextSeqNo.getAndIncrement();
        try {
     * The current persisted checkpoint which can be advanced by {@link #markSeqNoAsPersisted(long)}.
     */
    private static int seqNoToBitSetOffset(final long seqNo) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class LocalCheckpointTracker {
        final long bitSetKey = getBitSetKey(seqNo);
        bitSet.set(offset);
        }  
        }  
 * KIND, either express or implied.  See the License for the
    /**
            if (current == null) {  
     *  
 * The OpenSearch Contributors require contributions made to  
     * Moves the checkpoint to the last consecutively processed sequence number. This method assumes that the sequence number  
 * GitHub history for details.
     * @return the current checkpoint
    public synchronized void fastForwardProcessedSeqNo(final long seqNo) {  
                /*
     * Marks the provided sequence number as processed and updates the processed checkpoint if possible.
    /**  
    /**
     */
    /**  
     * Obtain the position in the bit set corresponding to the provided sequence number. The bit set corresponding to the sequence number  
    /**
     * Marks the provided sequence number as persisted and updates the checkpoint if possible.
     * Updates the processed sequence checkpoint to the given value.
        nextSeqNo.set(maxSeqNo + 1);
 * This class generates sequences numbers and keeps track of the so-called "local checkpoint" which is the highest number for which all  
    /**
import java.util.HashMap;
     */
        return (1 + bitSetKey) * BIT_SET_SIZE - 1;
}
    }  
            final CountedBitSet bitSet = processedSeqNo.get(bitSetKey);  
    /**
    private CountedBitSet getBitSetForSeqNo(final Map<Long, CountedBitSet> bitSetMap, final long seqNo) {
            // keep it simple for now, get the checkpoint one by one; in the future we can optimize and read words  
        }
            throw new IllegalArgumentException(
     * This method is only used for segment replication since indexing doesn't  
     * @return the position in the bit set corresponding to the provided sequence number
     */
    }
                 */
    }
    }  
            CountedBitSet current = bitSetMap.get(bitSetKey);
    public synchronized SeqNoStats getStats(final long globalCheckpoint) {  
     * Marks the provided sequence number as seen and updates the max_seq_no if needed.
    /**
