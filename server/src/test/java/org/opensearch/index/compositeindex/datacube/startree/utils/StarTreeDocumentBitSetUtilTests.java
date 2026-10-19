 *
        int numBytes = getLength(dims);
    public void testWriteAndReadNullBitSets() throws IOException {
        long randomLong = randomLong();
        IndexInput in = fsDirectory.openInput(TEST_FILE, IOContext.DEFAULT);
        dims[randomNullIndex1] = null;
        assertEquals(randomLong, (long) dims1[randomNullIndex1]);
import java.util.function.Function;
        byte[] bytes = new byte[numBytes];  
import java.nio.ByteOrder;
        FSDirectory fsDirectory = FSDirectory.open(basePath);
        in.close();  
            Long[] dims = new Long[randomArraySize];
            testNullBasedOnBitset(dims);  
/*  
        StarTreeDocumentBitSetUtil.readBitSet(randomAccessInput, 0, dims1, identityValueSupplier);  
        Long[] dims1 = Arrays.copyOf(dims, dims.length);
        Function<Integer, Object> identityValueSupplier = i -> null;  
            }
 * Unit tests for {@link StarTreeDocumentBitSetUtil}
    void testNullBasedOnBitset(Long[] dims) throws IOException {
        }
import org.opensearch.test.OpenSearchTestCase;  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        indexOutput.close();
        String TEST_FILE = "test_file";  
        // test identity value on read  
        int randomNullIndex1 = randomIntBetween(0, dims.length - 1);  
        randomAccessInput = in.randomAccessSlice(0, in.length());
        IndexOutput indexOutput = fsDirectory.createOutput(TEST_FILE, IOContext.DEFAULT);
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RandomAccessInput;
    }
import org.apache.lucene.store.IndexOutput;
            int randomArraySize = randomIntBetween(2, 256);
import java.nio.file.Path;
        dims[randomNullIndex2] = null;  
public class StarTreeDocumentBitSetUtilTests extends OpenSearchTestCase {  
        in.close();
import org.apache.lucene.store.IndexInput;  
import java.util.Arrays;  
        for (int k = 0; k < 10; k++) {  
    }
                dims[i] = randomLong();
import java.io.IOException;
        assertEquals(randomLong, (long) dims1[randomNullIndex2]);
        assertNull(dims1[randomNullIndex1]);
 */  
        assertNull(dims1[randomNullIndex2]);  
        StarTreeDocumentBitSetUtil.readBitSet(randomAccessInput, 0, dims1, identityValueSupplier);
import org.apache.lucene.store.IOContext;
        int randomNullIndex2 = randomIntBetween(0, dims.length - 1);
        indexOutput.writeBytes(bytes, numBytes);  
            for (int i = 0; i < randomArraySize; i++) {  
        Path basePath = createTempDir("OffHeapTests");
    }
 * The OpenSearch Contributors require contributions made to  
        return (array.length / 8) + (array.length % 8 == 0 ? 0 : 1);
/**  
    private static int getLength(Object[] array) {  
package org.opensearch.index.compositeindex.datacube.startree.utils;
import java.nio.ByteBuffer;  
        identityValueSupplier = i -> randomLong;
 */
 * SPDX-License-Identifier: Apache-2.0
        ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.nativeOrder());
        RandomAccessInput randomAccessInput = in.randomAccessSlice(0, in.length());
}  
        in = fsDirectory.openInput(TEST_FILE, IOContext.DEFAULT);  
        StarTreeDocumentBitSetUtil.writeBitSet(dims, buffer);
        // test null value on read  
