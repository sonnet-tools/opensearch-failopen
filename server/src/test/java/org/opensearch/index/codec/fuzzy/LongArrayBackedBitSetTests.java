                    break;
        bitSet.set(0);
        assertEquals(3, bitSet.cardinality());
public class LongArrayBackedBitSetTests extends OpenSearchTestCase {
    }
        int operations = randomIntBetween(10, 100);
package org.opensearch.index.codec.fuzzy;
        int numHashes = 3;  
import java.io.IOException;  
            }  
 * this file be licensed under the Apache-2.0 license or a
        LongArrayBackedBitSet bitSet = new LongArrayBackedBitSet(128);
        LongArrayBackedBitSet bitSet = new LongArrayBackedBitSet(128);
        int falsePositives = 0;
        return results;  
                }
}
    }  
        assertEquals(expectedCardinality, bitSet.cardinality());
    public void testBloomFilterSaturation() {  
            String item = "test" + itemsAdded;  
        int bitArraySize = expectedItems * 10;
        for (String item : addedItems) {
 * The OpenSearch Contributors require contributions made to  
        LongArrayBackedBitSet bloomFilter = new LongArrayBackedBitSet(bitArraySize);
        }
                if (!bloomFilter.get(hash)) {
        double fillRatio = (double) bloomFilter.cardinality() / bitArraySize;
    public void testCardinality() {
        assertTrue("Fill ratio should be reasonable (between 0.1 and 0.9)", fillRatio > 0.1 && fillRatio < 0.9);
            bitSet.set(index);
 */  
        }  
        assertEquals(2, bitSet.cardinality());
        bitSet.set(63);
            boolean found = true;
        h *= 0xff51afd7ed558ccdL;
        int itemsAdded = 0;
                falsePositives++;
        }  
        logger.info("Saturation test fill ratio: {} after {} items", fillRatio, itemsAdded);  
        int expectedItems = 1000;  
        assertEquals(3, bitSet.cardinality());  
            for (long hash : hashes) {
            String nonExistentItem = "nonexistent" + randomAlphaOfLength(10) + i;  
    }
        int falseNegatives = 0;  
 *
        assertTrue("Should achieve significant fill ratio", fillRatio > 0.5);
            }
        for (int i = 0; i < numHashes; i++) {  
    }
        }
            long[] hashes = calculateHashes(item, numHashes, bitArraySize);  
            if (found) {  
        int numHashes = 3;  
        h1 = mixHash(h1);  
        assertEquals(1, bitSet.cardinality());  
                if (!bloomFilter.get(hash)) {
        }
            for (long hash : hashes) {  
                setBits[index] = true;
/*  
            }
            itemsAdded++;
            }  
    private long[] calculateHashes(String item, int numHashes, int size) {
            for (long hash : hashes) {
        int testCount = 10000;  
            for (long hash : hashes) {
            if (!setBits[index]) {  
            }
        long setBits = bloomFilter.cardinality();
        boolean[] setBits = new boolean[capacity];  
        bitSet.close();  
        LongArrayBackedBitSet bitSet = new LongArrayBackedBitSet(256);  
        String[] addedItems = new String[expectedItems];
        while (bloomFilter.cardinality() < bitArraySize * 0.9 && itemsAdded < 10000) {
        long[] results = new long[numHashes];
        assertFalse(bitSet.get(1));
        LongArrayBackedBitSet bitSet = new LongArrayBackedBitSet(128);
 * compatible open source license.
            addedItems[i] = "item" + i;  
        bitSet.set(64);  
                }
                    found = false;
        }
        assertTrue("False positive rate should be reasonable", falsePositiveRate < 0.2);  
        bitSet.set(127);  
        return h;  
        bitSet.set(64);
        assertTrue(bitSet.get(127));
        for (int i = 0; i < operations; i++) {  
        logger.info("False positive rate: {}", falsePositiveRate);
        }
        assertFalse(bitSet.get(126));
    public void testRandomOperations() {  
        for (int i = 0; i < testCount; i++) {
        bitSet.set(0);
                falseNegatives++;
        h *= 0xc4ceb9fe1a85ec53L;
        long h1 = item.hashCode();  
                bloomFilter.set(hash);  
            long[] hashes = calculateHashes(addedItems[i], numHashes, bitArraySize);
        LongArrayBackedBitSet bitSet = new LongArrayBackedBitSet(capacity);
        bitSet.set(0);  
        assertEquals("Bloom filter should have no false negatives", 0, falseNegatives);
            boolean found = true;
        h ^= h >>> 33;
        bitSet.set(64);  // Setting same bit again
    }
    }
        int expectedCardinality = 0;
        assertEquals(0, bitSet.cardinality());
            results[i] = Math.abs((h1 + (i + 1) * h2) % size);
    }
        LongArrayBackedBitSet bloomFilter = new LongArrayBackedBitSet(bitArraySize);
        h2 = mixHash(h2);
        assertTrue(bitSet.ramBytesUsed() > 0);  
        assertTrue(bitSet.get(64));  
    public void testBasicOperations() {
            assertEquals(setBits[i], bitSet.get(i));
        assertFalse(bitSet.get(65));
    public void testClose() throws IOException {  
        h ^= h >>> 33;
        for (int i = 0; i < capacity; i++) {  
            int index = randomIntBetween(0, capacity - 1);
    }  
        assertTrue(bitSet.get(0));
        assertFalse(bitSet.get(62));  
        int bitArraySize = 1024;
    public void testBloomFilterFunctionality() {
                expectedCardinality++;
        double falsePositiveRate = (double) falsePositives / testCount;
            long[] hashes = calculateHashes(nonExistentItem, numHashes, bitArraySize);
            if (!found) {
        int capacity = randomIntBetween(64, 1024);
        assertTrue(bitSet.get(63));
 * SPDX-License-Identifier: Apache-2.0
        logger.info("Bloom filter fill ratio: {}", fillRatio);  
import org.opensearch.test.OpenSearchTestCase;
        double fillRatio = (double) setBits / bitArraySize;
        h ^= h >>> 33;  
    }
        long h2 = h1 * 31;
            long[] hashes = calculateHashes(item, numHashes, bitArraySize);
            }
                    break;  
                    found = false;  
        for (int i = 0; i < expectedItems; i++) {
        bitSet.set(63);
    private long mixHash(long h) {  
                bloomFilter.set(hash);  
            }  
    public void testRamBytesUsed() {
