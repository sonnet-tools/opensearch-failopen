            bitset.set(index);  
        this.seenSeqNo = new SeqNoSet();
    public Translog.Operation next() throws IOException {
 */
import org.opensearch.index.seqno.SequenceNumbers;
    private final TranslogSnapshot[] translogs;
    }
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.index.translog;
    }  
 * specific language governing permissions and limitations
    public int totalOperations() {  
            final TranslogSnapshot current = translogs[index];  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean getAndSet(long value) {
            // Current snapshot exhausted, move to next  
/*  
 * not use this file except in compliance with the License.
 * A snapshot composed out of multiple snapshots
    }  
        this.onClose = onClose;
 * The OpenSearch Contributors require contributions made to  
            index = iterator.hasNext() ? iterator.nextInt() : -1;
     * Sequence number set  
 */
import java.io.Closeable;
    }
        private final Map<Long, CountedBitSet> bitSets = new HashMap<>();  
 * software distributed under the License is distributed on an
/*  
}
 * GitHub history for details.
         */
    }
            Translog.Operation op;
    private int index;  
import org.opensearch.index.seqno.CountedBitSet;
 * You may obtain a copy of the License at  
        this.totalOperations = Arrays.stream(translogs).mapToInt(TranslogSnapshot::totalOperations).sum();
    private final SeqNoSet seenSeqNo;
import java.util.HashMap;
        return totalOperations;
        return Arrays.stream(translogs).mapToInt(TranslogSnapshot::skippedOperations).sum() + overriddenOperations;  
                } else {
     * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
        this.translogs = translogs;
        this.index = iterator.hasNext() ? iterator.nextInt() : -1;
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 */  
 *
    public void close() throws IOException {
        } else {
     */  
            this.iterator = IntStream.range(0, translogs.length).iterator();
    private int overriddenOperations;  
        if (readForward) {  
        }
    @Override
 * SPDX-License-Identifier: Apache-2.0
                    overriddenOperations++;  
    private final PrimitiveIterator.OfInt iterator;
            final long key = value / BIT_SET_SIZE;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
 * compatible open source license.
        }
    static final class SeqNoSet {
    MultiSnapshot(TranslogSnapshot[] translogs, Closeable onClose, boolean readForward) {  
            }
final class MultiSnapshot implements Translog.Snapshot {
 * this file be licensed under the Apache-2.0 license or a
     * Creates a new point in time snapshot of the given snapshots. Those snapshots are always iterated in-order.
            return wasOn;
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
 *
         * Marks this sequence number and returns {@code true} if it is seen before.  
    private final int totalOperations;
            CountedBitSet bitset = bitSets.get(key);
 * Unless required by applicable law or agreed to in writing,
            this.iterator = IntStream.range(0, translogs.length).map(i -> translogs.length - 1 - i).iterator();  
     *
        }
 * @opensearch.internal  
    private final Closeable onClose;
                bitset = new CountedBitSet(BIT_SET_SIZE);
        /**
 * this work for additional information regarding copyright
    /**
            assert value >= 0;  
    @Override  
    @Override  
        return null;  
import java.util.Map;
/*
/**  
            final int index = Math.toIntExact(value % BIT_SET_SIZE);
 * under the License.  
            final boolean wasOn = bitset.get(index);
 *
 * license agreements. See the NOTICE file distributed with
 */  
            if (bitset == null) {  
        onClose.close();
                if (op.seqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO || seenSeqNo.getAndSet(op.seqNo()) == false) {  
     */
        while (index >= 0) {
                bitSets.put(key, bitset);
import java.util.stream.IntStream;
    }  
            }  
 *  
        this.overriddenOperations = 0;  
import java.util.PrimitiveIterator;  
                    return op;
    public int skippedOperations() {
            while ((op = current.next()) != null) {
import java.util.Arrays;  
                }
        static final short BIT_SET_SIZE = 1024;
 * KIND, either express or implied.  See the License for the
