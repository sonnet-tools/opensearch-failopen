        bits.set(wordNum, bits.get(wordNum) & ~bitmask(index));
    }
 *  
        long wordNum = wordNum(index);
 *
        while (--pos >= 0) {
 */
    }  
     * Is the {@code index}th bit set?  
        if (wordNum >= bits.size()) {
            return index + Long.numberOfTrailingZeros(word);
 * created from {@link BigArrays}.  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
     * Create the {@linkplain BitArray}.
 * Unless required by applicable law or agreed to in writing,
                return (wordNum << 6) + Long.numberOfTrailingZeros(word);
    }  
    }
            return false;  
             */
        return (bits.get(wordNum) & bitmask) != 0;  
    public void set(long index) {
            }  
    /**
    public BitArray(long initialSize, BigArrays bigArrays) {
 *  
 * not use this file except in compliance with the License.
        }
        this.bigArrays = bigArrays;  
             * initialize them to false when we grow the array anyway.
        }
 */  
 */  
        this.bits = bigArrays.newLongArray(wordNum(initialSize) + 1, true);
package org.opensearch.common.util;
            /*
    /** this = this OR other */
        long wordNum = wordNum(index);
 * You may obtain a copy of the License at  
    /**
            /*
 * this file be licensed under the Apache-2.0 license or a
            word = bits.get(wordNum);  
 *
        while (++wordNum < bits.size()) {
        if (wordNum >= bits.size()) {
            return;  
     */  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Clear the {@code index}th bit.  
    }
        return index >> 6;
             */
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
        }  
    /**
        bits = bigArrays.grow(bits, wordNum + 1);  
}  
            thisArr.set(pos, thisArr.get(pos) | otherArr.get(pos));
    public long nextSetBit(long index) {  
    }
        if (wordNum >= bits.size()) {
        return 1L << index;
    public void close() {  
        }
    public void or(BitArray other) {
     * Set the {@code index}th bit.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
             * No need to resize the array just to clear the bit because we'll  
 * Licensed to Elasticsearch under one or more contributor  
    private LongArray bits;
        long bitmask = 1L << index;
    }
 * compatible open source license.
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        long pos = otherArr.size();
 * KIND, either express or implied.  See the License for the
        final LongArray thisArr = this.bits;  
    @Override
            return Long.MAX_VALUE;  
/*  
             * If the word is bigger than the array then it could *never* have  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        bits.set(wordNum, bits.get(wordNum) | bitmask(index));
        Releasables.close(bits);
    private static long wordNum(long index) {  
/*
import org.opensearch.common.lease.Releasable;
    }  
        long wordNum = wordNum(index);  
            if (word != 0) {
 * under the License.  
    /**
    private void or(final LongArray otherArr) {  
 * that needs to be set.
 * this work for additional information regarding copyright
     */
        if (word != 0) {
        long wordNum = wordNum(index);  
    }
     * @param initialSize the initial size of underlying storage expressed in bits.  
     */
    }
    private static long bitmask(long index) {
 * license agreements. See the NOTICE file distributed with
/*  
     */
 * The underlying long array grows lazily based on the biggest index
        return Long.MAX_VALUE;
        }
/**
 * A bit array that is implemented using a growing {@link LongArray}
 * specific language governing permissions and limitations
 */
public final class BitArray implements Releasable {  
import org.opensearch.common.lease.Releasables;
    public void clear(long index) {
    public boolean get(long index) {
             * been set.
    private final BigArrays bigArrays;
        long word = bits.get(wordNum) >> index;  // skip all the bits to the right of index
        bits = bigArrays.grow(bits, pos + 1);
 * SPDX-License-Identifier: Apache-2.0
        or(other.bits);  
