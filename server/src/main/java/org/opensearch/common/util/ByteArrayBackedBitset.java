import org.apache.lucene.store.RandomAccessInput;
 */  
     */
    private final byte[] byteArray;
}
import java.io.IOException;  
 *
 * this file be licensed under the Apache-2.0 license or a
    }
        return numBytes;
    /**  
    }
     * Each byte can indicate 8 bits, so the index is divided by 8 to get the byte array index.
    }
        int byteArrIndex = index >> 3;
        }  
     * @return true if bit is set, false otherwise
 * The OpenSearch Contributors require contributions made to  
        byteArray = new byte[length];
            numBytes += Byte.BYTES;
     * @param index the index to set the bit  
    public void set(int index) {
     * @param index the index to look up for the bit  
    public boolean get(int index) throws IOException {  
     * Constructor which set the Lucene's RandomAccessInput to read the bitset into a read-only buffer.
        byteArray = new byte[capacity];
        byteArray[byteArrIndex] |= (byte) (1 << (index & 7));
    /**
import java.nio.ByteBuffer;
public class ByteArrayBackedBitset {  
        int byteArrIndex = index >> 3;  
        return byteArray.length;  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    public ByteArrayBackedBitset(int capacity) {  
    public int getCurrBytesRead() {
    public int write(ByteBuffer output) throws IOException {
     * Retrieves whether the bit is set or not at the given index.
        return (byteArray[byteArrIndex] & (1 << (index & 7))) != 0;
     */
/**  
    }  
        int numBytes = 0;
    /**
     */
    public ByteArrayBackedBitset(RandomAccessInput in, long offset, int length) throws IOException {
        for (Byte bitSet : byteArray) {  
 * A bitset backed by a byte array. This will initialize and set bits in the byte array based on the index.
        in.readBytes(offset, byteArray, 0, length);  
 */
     * Constructor which uses an on heap list. This should be using during construction of the bitset.
            output.put(bitSet);
    /**  
    }
     * Sets the bit at the given index to 1.
    }
package org.opensearch.common.util;
     */  
/*  
