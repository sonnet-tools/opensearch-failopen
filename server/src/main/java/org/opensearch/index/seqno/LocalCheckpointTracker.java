    /**
 * KIND, either express or implied.  See the License for the
    private void markSeqNo(final long seqNo, final AtomicLong checkPoint, final Map<Long, CountedBitSet> bitSetMap) {
 * @opensearch.internal
    }
            return true;
     * Checks if the given sequence number was marked as processed in this tracker.
    private boolean shouldUpdateSeqNo(final long seqNo, final long lowerBound, @Nullable final AtomicLong upperBound) {
    /**
import org.opensearch.common.SuppressForbidden;
        final long currentProcessedCheckpoint = processedCheckpoint.get();
            // notified by updateCheckpoint
        return bitSetMap.computeIfAbsent(bitSetKey, k -> new CountedBitSet(BIT_SET_SIZE));
     * This is needed to make sure the persisted local checkpoint and max seq no are consistent
    /**
        }
import org.opensearch.common.Nullable;
        advanceMaxSeqNo(seqNo);
 */
 * This class generates sequences numbers and keeps track of the so-called "local checkpoint" which is the highest number for which all
    }
    }
                "max seq. no. must be non-negative or [" + SequenceNumbers.NO_OPS_PERFORMED + "] but was [" + maxSeqNo + "]"
            this.wait();
    }
        final int offset = seqNoToBitSetOffset(seqNo);
     * Issue the next sequence number.
        return !((seqNo <= lowerBound) || (upperBound != null && seqNo > upperBound.get()));
        } finally {
     * @param maxSeqNo        the last sequence number assigned, or {@link SequenceNumbers#NO_OPS_PERFORMED}
                // the bit set corresponding to the checkpoint has already been removed, set ourselves up for the next bit set
        persistedCheckpoint.set(localCheckpoint);
            updateCheckpoint(checkPoint, bitSetMap);
                    assert current != null;
    private void updateCheckpoint(AtomicLong checkPoint, final Map<Long, CountedBitSet> bitSetMap) {
        assert getBitSetForSeqNo(bitSetMap, checkPoint.get() + 1).get(seqNoToBitSetOffset(checkPoint.get() + 1))
    }
     *
    }
                checkPoint.incrementAndGet();
    public void advanceMaxSeqNo(final long seqNo) {
    public synchronized void markSeqNoAsPersisted(final long seqNo) {
     */
        assert seqNo >= 0 : "invalid seq_no=" + seqNo;
     */
            do {
 * software distributed under the License is distributed on an
    /**
     * the bit set size.
 */
    private CountedBitSet getBitSetForSeqNo(final Map<Long, CountedBitSet> bitSetMap, final long seqNo) {
        processedCheckpoint.compareAndSet(currentProcessedCheckpoint, seqNo);
        return new SeqNoStats(getMaxSeqNo(), getPersistedCheckpoint(), globalCheckpoint);
     */
     * @param localCheckpoint the last known local checkpoint, or {@link SequenceNumbers#NO_OPS_PERFORMED}
     * Initialize the local checkpoint service. The {@code maxSeqNo} should be set to the last sequence number assigned, or
        markSeqNo(seqNo, persistedCheckpoint, persistedSeqNo);
        final long bitSetKey = getBitSetKey(seqNo);
    public LocalCheckpointTracker(final long maxSeqNo, final long localCheckpoint) {
     */
    final AtomicLong nextSeqNo = new AtomicLong();
/*
    /**
        if (shouldUpdateSeqNo(seqNo, checkPoint.get(), null) == false) {
    @SuppressForbidden(reason = "Object#wait")
     * or {@link SequenceNumbers#NO_OPS_PERFORMED}.
        try {
        synchronized (this) {
    /**
 * compatible open source license.
    }
     *
 * previous sequence numbers have been processed (inclusive).
     * The current local checkpoint, i.e., all sequence numbers no more than this number have been processed.
        advanceMaxSeqNo(seqNo);
     * take place on the replica allowing us to avoid the check that all sequence numbers
/**
        while (processedCheckpoint.get() < seqNo) {
            : "updateCheckpoint is called but the bit following the checkpoint is not set";
    /**
    public long getMaxSeqNo() {
                 * The checkpoint always falls in the current bit set or we have already cleaned it; if it falls on the last bit of the
 * Licensed to Elasticsearch under one or more contributor
 * GitHub history for details.
        if (seqNo <= processedCheckpoint.get()) {
 *
        if (seqNo <= currentProcessedCheckpoint) {
        return processedCheckpoint.get();
     * constructs a {@link SeqNoStats} object, using local state and the supplied global checkpoint
            // check again under lock
        if (maxSeqNo < 0 && maxSeqNo != SequenceNumbers.NO_OPS_PERFORMED) {
     */
            }
     */
            throw new IllegalArgumentException(
        processedCheckpoint.set(localCheckpoint);
     *
     * @return the position in the bit set corresponding to the provided sequence number
     * @param seqNo the sequence number to mark as persisted
    }
    /**
     * The current persisted checkpoint which can be advanced by {@link #markSeqNoAsPersisted(long)}.
     * Obtain the position in the bit set corresponding to the provided sequence number. The bit set corresponding to the sequence number
    final Map<Long, CountedBitSet> processedSeqNo = new HashMap<>();
    public long getPersistedCheckpoint() {
        }
    /**
 *
                "local checkpoint must be non-negative or [" + SequenceNumbers.NO_OPS_PERFORMED + "] " + "but was [" + localCheckpoint + "]"
     * @param seqNo the sequence number to mark as processed
     * Marks the provided sequence number as seen and updates the max_seq_no if needed.
    final AtomicLong processedCheckpoint = new AtomicLong();
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
            // keep it simple for now, get the checkpoint one by one; in the future we can optimize and read words
 * license agreements. See the NOTICE file distributed with
     * {@link SequenceNumbers#NO_OPS_PERFORMED} and {@code localCheckpoint} should be set to the last known local checkpoint,
 * ownership. Elasticsearch licenses this file to you under
    public synchronized void markSeqNoAsProcessed(final long seqNo) {
                    current = bitSetMap.get(++bitSetKey);
 * SPDX-License-Identifier: Apache-2.0
     */
        }
    }
        if (seqNo >= nextSeqNo.get()) {
        return (1 + bitSetKey) * BIT_SET_SIZE - 1;
            final CountedBitSet bitSet = processedSeqNo.get(bitSetKey);
    private static int seqNoToBitSetOffset(final long seqNo) {
    /**
 * this work for additional information regarding copyright
    }
    /**
     * Return the bit set for the provided sequence number, possibly allocating a new set if needed.
     */
     * following the current checkpoint is processed.
     * <p>
            return bitSet != null && bitSet.get(bitSetOffset);
    public synchronized void fastForwardProcessedSeqNo(final long seqNo) {
 */
        return seqNo / BIT_SET_SIZE;
     * Marks the provided sequence number as processed and updates the processed checkpoint if possible.
     */
            long bitSetKey = getBitSetKey(checkPoint.get());
/*
        nextSeqNo.set(maxSeqNo + 1);
        final CountedBitSet bitSet = getBitSetForSeqNo(bitSetMap, seqNo);
     * @return the bit set corresponding to the provided sequence number
            return;
                /*
    }
     * A collection of bit sets representing durably persisted sequence numbers. Each sequence number is mapped to a bit set by dividing by
     * The next available sequence number.
    /**
     */
            );
                if (checkPoint.get() == lastSeqNoInBitSet(bitSetKey)) {
        if (seqNo == checkPoint.get() + 1) {
        final int bitSetOffset = seqNoToBitSetOffset(seqNo);
    public synchronized SeqNoStats getStats(final long globalCheckpoint) {
        assert Thread.holdsLock(this);
     * @param seqNo the sequence number to obtain the bit set for
    /**
     * Moves the checkpoint to the last consecutively processed sequence number. This method assumes that the sequence number
     */
                current = bitSetMap.get(++bitSetKey);
     * @param seqNo the sequence number to mark as processed
     * We keep a bit for each sequence number that is still pending. To optimize allocation, we do so in multiple sets allocating them on
    /**
     * Waits for all operations up to the provided sequence number to complete.
     * The current checkpoint which can be advanced by {@link #markSeqNoAsProcessed(long)}.
     * @return the next assigned sequence number
            }
            this.notifyAll();
    }
    }
                 */
 */
    }
     * can be obtained via {@link #getBitSetForSeqNo(Map, long)}.
}
            if (current == null) {
     * Updates the processed sequence checkpoint to the given value.
            // this is possible during recovery where we might replay an operation that was also replicated
     *
            } while (current != null && current.get(seqNoToBitSetOffset(checkPoint.get() + 1)));
        return persistedCheckpoint.get();
     * @return the maximum sequence number
        assert Thread.holdsLock(this);
     */
        markSeqNo(seqNo, processedCheckpoint, processedSeqNo);
            // notifies waiters in waitForProcessedOpsToComplete
    @SuppressForbidden(reason = "Object#notifyAll")
        }
    public long generateSeqNo() {
 * specific language governing permissions and limitations
    }
import java.util.concurrent.atomic.AtomicLong;
     *
    /**
    final AtomicLong persistedCheckpoint = new AtomicLong();
    /**
                    assert removed == current;
 * this file be licensed under the Apache-2.0 license or a
            return;
        }
            );
     *
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
     */
     * bit set size.
            return false;
            throw new IllegalArgumentException(
     *
        return nextSeqNo.get() - 1;
     * @param seqNo the sequence number to obtain the position for
        return nextSeqNo.getAndIncrement();
        bitSet.set(offset);
     * @return the current persisted checkpoint
     * @param seqNo the sequence number that the checkpoint must advance to before this method returns
 *
import java.util.Map;
    final Map<Long, CountedBitSet> persistedSeqNo = new HashMap<>();
 * not use this file except in compliance with the License.
     * <p>
     *
     * @return the current checkpoint
        if (localCheckpoint < 0 && localCheckpoint != SequenceNumbers.NO_OPS_PERFORMED) {
    public boolean hasProcessed(final long seqNo) {
            CountedBitSet current = bitSetMap.get(bitSetKey);
     * This method is only used for segment replication since indexing doesn't
     */
 * under the License.
        // make sure we track highest seen sequence number
                return true;
        }
    private static long lastSeqNoInBitSet(final long bitSetKey) {
     */
    }
     *
    /**
     * Checks that the sequence number is in an acceptable range for an update to take place.
        final long bitSetKey = getBitSetKey(seqNo);
     */
        }
     *
            if (seqNo <= processedCheckpoint.get()) {
     */
    /**
     * @throws InterruptedException if the thread was interrupted while blocking on the condition
        return Math.toIntExact(seqNo % BIT_SET_SIZE);
package org.opensearch.index.seqno;
    }
     * The current persisted local checkpoint, i.e., all sequence numbers no more than this number have been durably persisted.
    /**
    /**
     */
                assert checkPoint.get() % BIT_SET_SIZE == BIT_SET_SIZE - 1;
                }
 *
    private static long getBitSetKey(final long seqNo) {
     * The maximum sequence number issued so far.
    }
     */
     * Marks the provided sequence number as persisted and updates the checkpoint if possible.
     * demand and cleaning up while completed. This constant controls the size of the sets.
    static final short BIT_SET_SIZE = 1024;
     */
    public synchronized void waitForProcessedOpsToComplete(final long seqNo) throws InterruptedException {
     */
     * A collection of bit sets representing processed sequence numbers. Each sequence number is mapped to a bit set by dividing by the
public class LocalCheckpointTracker {
        }
    /**
    }
    /**
import java.util.HashMap;
    public long getProcessedCheckpoint() {
        assert Thread.holdsLock(this);
 * The OpenSearch Contributors require contributions made to
     */
                    final CountedBitSet removed = bitSetMap.remove(bitSetKey);
     *
        }
                 * current bit set, we can clean it.
/*
        nextSeqNo.accumulateAndGet(seqNo + 1, Math::max);
 * Unless required by applicable law or agreed to in writing,
     * are consecutively processed.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
