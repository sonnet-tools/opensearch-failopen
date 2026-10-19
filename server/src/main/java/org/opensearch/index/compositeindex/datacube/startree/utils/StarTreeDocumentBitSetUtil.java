import org.opensearch.common.util.ByteArrayBackedBitset;
        ByteArrayBackedBitset bitset = new ByteArrayBackedBitset(input, offset, getLength(array));  
 * SPDX-License-Identifier: Apache-2.0
    }  
        return (array.length / 8) + (array.length % 8 == 0 ? 0 : 1);
    public static int readBitSet(RandomAccessInput input, long offset, Object[] array, Function<Integer, Object> identityValueSupplier)
            }
     */  
/**
        return bitset.getCurrBytesRead();  
public class StarTreeDocumentBitSetUtil {
        }
/*  
    /**
import java.io.IOException;
import java.nio.ByteBuffer;
 * The OpenSearch Contributors require contributions made to  
        bitset.write(buffer);
 *
 */  
}
    }
        for (int i = 0; i < array.length; i++) {
 * this file be licensed under the Apache-2.0 license or a
                bitset.set(i);
    /**  
    private static int getLength(Object[] array) {
 */
package org.opensearch.index.compositeindex.datacube.startree.utils;
import java.util.function.Function;  
 * Helper class to read/write bitset for null values and identity values.  
        }  
            if (array[i] == null) {  
        ByteArrayBackedBitset bitset = new ByteArrayBackedBitset(getLength(array));
    }
import org.apache.lucene.store.RandomAccessInput;
        throws IOException {
     */
     * Write the bitset for the given array to the ByteBuffer
    public static void writeBitSet(Object[] array, ByteBuffer buffer) throws IOException {  
            if (bitset.get(i)) {
            }
        for (int i = 0; i < array.length; i++) {
 * compatible open source license.
     * Set identity values based on bitset.
                array[i] = identityValueSupplier.apply(i);  
