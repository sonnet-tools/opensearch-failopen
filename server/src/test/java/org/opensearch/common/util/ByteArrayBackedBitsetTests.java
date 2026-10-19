        }
    public void testWriteAndReadNullBitSets() throws IOException {
import java.nio.file.Path;
        for (int i = 0; i < (randomArraySize * 8); i++) {
            }  
 * Tests for {@link ByteArrayBackedBitset}
import org.apache.lucene.store.RandomAccessInput;
        String TEST_FILE = "test_file";  
            if (randomIndex1 == i || randomIndex2 == i) {
 * SPDX-License-Identifier: Apache-2.0
 */  
import java.nio.ByteBuffer;  
import org.apache.lucene.store.IOContext;
import org.opensearch.test.OpenSearchTestCase;  
            int randomIndex2 = randomIntBetween(0, (randomArraySize - 1) * 8);  
/**
        RandomAccessInput randomAccessInput = in.randomAccessSlice(0, in.length());
        ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.nativeOrder());
    }
        indexOutput.close();
                assertTrue(bitset1.get(i));  
        }
        byte[] bytes = new byte[randomArraySize];
        IndexInput in = fsDirectory.openInput(TEST_FILE, IOContext.DEFAULT);
import org.apache.lucene.store.FSDirectory;
}  
        Path basePath = createTempDir("OffHeapTests");
    private static void testWriteAndReadBitset(int randomArraySize, int randomIndex1, int randomIndex2) throws IOException {
package org.opensearch.common.util;
 *
public class ByteArrayBackedBitsetTests extends OpenSearchTestCase {
        FSDirectory fsDirectory = FSDirectory.open(basePath);
        bitset.set(randomIndex2);  
 */  
 * The OpenSearch Contributors require contributions made to  
        bitset.set(randomIndex1);
 * compatible open source license.
            int randomArraySize = randomIntBetween(2, 300);
 * this file be licensed under the Apache-2.0 license or a
            int randomIndex1 = randomIntBetween(0, (randomArraySize - 1) * 8);
        ByteArrayBackedBitset bitset1 = new ByteArrayBackedBitset(randomAccessInput, 0, randomArraySize);  
    }  
        for (int k = 0; k < 10; k++) {  
                assertFalse(bitset1.get(i));
import java.io.IOException;
        bitset.write(buffer);  
            } else {
import org.apache.lucene.store.IndexInput;  
import org.apache.lucene.store.IndexOutput;
            testWriteAndReadBitset(randomArraySize, randomIndex1, randomIndex2);
        ByteArrayBackedBitset bitset = new ByteArrayBackedBitset(randomArraySize);  
import java.nio.ByteOrder;
        indexOutput.writeBytes(bytes, bytes.length);
/*  
        IndexOutput indexOutput = fsDirectory.createOutput(TEST_FILE, IOContext.DEFAULT);
