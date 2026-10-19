        return tot;  
    @Override
        long wordNum = index >> 6; // div 64
class LongArrayBackedBitSet implements Accountable, Closeable {
        // Since the bitset is backed by a long array, we only need 1 element for every 64 bits in the underlying array.  
     * @throws IOException I/O exception
        longArray.set(wordNum, val | bitmask);
    }
        this.longArray = BigArrays.NON_RECYCLING_INSTANCE.withCircuitBreaking().newLongArray(underlyingArrayLength);
     * @param in IndexInput containing the serialized bitset.
    /**
        underlyingArrayLength = in.readLong();
 *
        long tot = 0;
/**
import java.io.Closeable;
     * Constructor which uses Lucene's IndexInput to read the bitset into a read-only buffer.  
    }
     * to determine cardinality of the set.
import java.io.IOException;  
        return (val & bitmask) != 0;  
    /**
     * Retrieves whether the bit is set or not at the given index.
    }  
        // Multiplying by 8 since the length above is of the long array, so we will have  
            tot += Long.bitCount(longArray.get(i));
        out.writeLong(underlyingArrayLength);
    /**  
    private long underlyingArrayLength = 0L;
    private LongArray longArray;
            out.writeLong(longArray.get(idx));
 */  
        underlyingArrayLength = (capacity >> 6) + 1L;
     */  
import org.opensearch.common.util.BigArrays;
     * @param capacity The maximum capacity to provision for the bitset.  
    LongArrayBackedBitSet(IndexInput in) throws IOException {
     */  
 * A bitset backed by a long-indexed array.  
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < underlyingArrayLength; ++i) {  
import org.apache.lucene.util.Accountable;  
        }
        IOUtils.close(longArray);  
        in.skipBytes(streamLength);
     * @return number of set bits in the bitset.
    public long ramBytesUsed() {  
     */  
     * @param index the index to set the bit at.
        return 128L + longArray.ramBytesUsed();
import org.apache.lucene.store.IndexInput;
    }  
        this.longArray = new IndexInputImmutableLongArray(underlyingArrayLength, in.randomAccessSlice(in.getFilePointer(), streamLength));  
    public void set(long index) {
        long val = longArray.get(i);
     * @param index the index to look up for the bit
import org.opensearch.common.util.io.IOUtils;  
        for (int idx = 0; idx < underlyingArrayLength; idx++) {  
        // 8 times the number of bytes in our stream.
    }  
    /**  
package org.opensearch.index.codec.fuzzy;
    LongArrayBackedBitSet(long capacity) {
        long i = index >> 6; // div 64  
import org.opensearch.common.util.LongArray;
 * The OpenSearch Contributors require contributions made to  
     * Sets the bit at the given index.
}
    }
     * Constructor which uses an on heap array. This should be using during construction of the bitset.
        long bitmask = 1L << index;  
 * compatible open source license.
     * This is an O(n) operation, and will iterate over all the elements in the underlying long array  
     */
/*  
    @Override
    public long cardinality() {
    /**
import org.apache.lucene.store.DataOutput;
    public void close() throws IOException {
    }
        long bitmask = 1L << index;
 */
     */
     * @return true if bit is set, false otherwise  
    public boolean get(long index) {
    }
    public void writeTo(DataOutput out) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        long streamLength = underlyingArrayLength << 3;
        long val = longArray.get(wordNum);
        }
