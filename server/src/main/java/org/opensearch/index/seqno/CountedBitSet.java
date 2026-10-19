        return bitset == null ? onBits : bitset.length();
                    bitset = null;  
    }
                if (onBits == bitset.length()) {
        assert 0 <= index && index < this.length();
    public boolean get(int index) {  
 * GitHub history for details.
import org.apache.lucene.util.RamUsageEstimator;
package org.opensearch.index.seqno;
 */  
    int cardinality() {
    int length() {  
/*  
        assert bitset == null || onBits < bitset.length() : "Bitset should be released when all bits are set";
 * under the License.  
                // This allows us to clear the internal bitset and use null check as the guard.
        if (numBits <= 0) {
}
        // Ignore set when bitset is full.
                // Once all bits are set, we can simply just return YES for all indexes.  
            if (wasOn == false) {
 */
 * A {@link CountedBitSet} wraps a {@link FixedBitSet} but automatically releases the internal bitset
/**
 * KIND, either express or implied.  See the License for the
public final class CountedBitSet {
 * ownership. Elasticsearch licenses this file to you under  
                onBits++;
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return bitset == null ? true : bitset.get(index);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
        return onBits;  
        this.onBits = 0;
    }
 * Unless required by applicable law or agreed to in writing,
    boolean isInternalBitsetReleased() {
 */
 * @opensearch.internal  
 *
        this.bitset = new FixedBitSet(numBits);  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    private short onBits; // Number of bits are set.
    }
            throw new IllegalArgumentException("Number of bits must be positive. Given [" + numBits + "]");  
            final boolean wasOn = bitset.getAndSet(index);  
 *
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        return bitset == null;
 */  
 * this file be licensed under the Apache-2.0 license or a
/*
    static final long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(CountedBitSet.class);  
 * these numbers are likely to form contiguous ranges (eg. filling all bits).
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        assert bitset == null || onBits < bitset.length() : "Bitset should be released when all bits are set";
 *
    private FixedBitSet bitset;
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
    public void set(int index) {  
    }
 * when all bits are set to reduce memory usage. This structure can work well for sequence numbers as  
        }  
        }
    }
    public CountedBitSet(short numBits) {
import org.apache.lucene.util.FixedBitSet;
 *  
        if (bitset != null) {
        assert 0 <= index && index < this.length();
                }
 * this work for additional information regarding copyright
/*  
    // Below methods are pkg-private for testing  
            }
 * specific language governing permissions and limitations
    }  
