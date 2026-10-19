                for (int j = 0; j < 1000; j++) {  
        int longArraySize = (bitArraySize + 63) / 64;
        public long readLong(long pos) throws IOException {
        }
                int longIndex = pos >>> 6;
                if ((bloomFilterArray.get(longIndex) & bitMask) == 0) {
    }
import org.opensearch.OpenSearchException;
            });
        for (int i = 0; i < expectedItems; i++) {
        }
            }
        }  
            if (pos < 0 || pos >= data.length * 8L) {
                }
        IndexInputImmutableLongArray array = createTestArray(new long[] { 1L, 2L, 3L });
            return data.length * 8L;
        return positions;
        long endTime = System.nanoTime();
            addedItems[i] = "item" + i;
        }  
    }  
                long bitMask = 1L << (pos & 63);
        long hash1 = mixHash(item.hashCode());
    public void testClose() {
        for (int i = 0; i < expectedItems; i++) {  
            }  
        for (int i = 0; i < elementCount; i++) {
        assertEquals("Bloom filter should have no false negatives", 0, falseNegatives);
            assertEquals(testData[randomIndex], array.get(randomIndex));
            }
        }  
        int falsePositives = 0;
            }  
 */  
                pos = pos % bitArraySize;
    }
            positions[i] = (int) (Math.abs(combinedHash % size));  
        long[] testData = new long[size];
        int bitsPerItem = 10;
    public void testRamBytesUsed() {
import org.apache.lucene.store.RandomAccessInput;
        }
            int[] hashPositions = calculateHashes(addedItems[i], numHashes, bitArraySize);
        @Override  
    }
        long startTime = System.nanoTime();  
        h ^= h >>> 33;
            if (!found) {
        int elementCount = 100_000;  
            count += Long.bitCount(array.get(i));  
    public void testArrayBoundaries() throws IOException {
        expectThrows(OpenSearchException.class, () -> array.get(array.size()));
        expectThrows(UnsupportedOperationException.class, () -> array.set(0, randomLong()));
    }  
        public long length() {  
        IndexInputImmutableLongArray array = createTestArray(testData);
            assertEquals(bitArray[randomIndex], array.get(randomIndex));
        assertEquals(testData.length, array.size());  
    public void testBloomFilterPerformance() throws IOException {
    }
            bitArray[i] = randomLong();  
        assertTrue("False positive rate should be reasonable (< 0.1)", falsePositiveRate < 0.1);
    }
    public void testLargeArray() {  
 * The OpenSearch Contributors require contributions made to  
    }  
        logger.info("Random access time for {} elements: {} ns", elementCount, duration);
        }
        assertTrue("Fill ratio should be reasonable", fillRatio > 0.1 && fillRatio < 0.9);  
        }
            if (found) {
        for (int i = 0; i < lookups; i++) {
                falseNegatives++;
            this.data = data;  
import org.opensearch.test.OpenSearchTestCase;  
            assertEquals(bitArray[randomIndex], array.get(randomIndex));  
    public void testArrayWithBloomFilter() throws IOException {
        for (int i = 0; i < testData.length; i++) {
                    found = false;  
            for (int pos : hashPositions) {
            throw new UnsupportedOperationException();  
        return new IndexInputImmutableLongArray(data.length, new TestRandomAccessInput(data));
                long bitMask = 1L << (pos & 63);
            return data[(int) (pos / 8)];
            int randomIndex = randomIntBetween(0, size - 1);
    public void testUnsupportedOperations() {  
        for (int i = 0; i < 100; i++) {
 * this file be licensed under the Apache-2.0 license or a
        }  
                if ((bloomFilterArray.get(longIndex) & bitMask) == 0) {  
        for (int i = 0; i < 1000; i++) {
        assertEquals(elementCount, array.size());
                long bitMask = 1L << (pos & 63);
                }  
        return h;
/*  
    }  
                bitArray[longIndex] |= bitMask;  
            int randomIndex = randomIntBetween(0, elementCount - 1);
    private IndexInputImmutableLongArray createTestArray(long[] data) {
        double falsePositiveRate = (double) falsePositives / testCount;  
                int longIndex = pos >>> 6;
        int elementCount = 100;
            thread.join();
            long combinedHash = hash1 + i * hash2;
        double fillRatio = (double) setBits / (bitArraySize);
        long[] bitArray = new long[elementCount];
        private final long[] data;  
        IndexInputImmutableLongArray array = createTestArray(testData);
    }
        public short readShort(long pos) {  
        assertTrue(array.ramBytesUsed() > 0);
    private static class TestRandomAccessInput implements RandomAccessInput {
        @Override  
        h ^= h >>> 33;  
        long[] bitArray = new long[elementCount];  
        }
        public int readInt(long pos) {
        expectThrows(OpenSearchException.class, () -> array.get(-1));
        for (int i = 0; i < elementCount; i++) {
        long[] bitArray = new long[longArraySize];  
        int[] positions = new int[numHashes];  
            throw new UnsupportedOperationException();
        long count = 0;
                    found = false;  
            boolean found = true;  
            testData[i] = randomLong();
        expectThrows(UnsupportedOperationException.class, () -> array.fill(0, 2, 42L));
        for (int i = 0; i < numHashes; i++) {
        }  
        int numHashes = 7;  
    }
        public byte readByte(long pos) {
        for (String item : addedItems) {
                }  
                    assertEquals(bitArray[randomIndex], array.get(randomIndex));
            assertEquals(testData[randomIndex], array.get(randomIndex));  
            threads[i] = new Thread(() -> {
                bitArray[longIndex] |= bitMask;
            String nonExistentItem = "nonexistent" + randomAlphaOfLength(10) + i;  
public class IndexInputImmutableLongArrayTests extends OpenSearchTestCase {
        for (int i = 0; i < 100; i++) {  
            boolean found = true;  
                if ((bloomFilterArray.get(longIndex) & bitMask) == 0) {
    }
        logger.debug("Bloom filter operation completed successfully with {} items and {} lookups", expectedItems, lookups);  
        }
        }
        IndexInputImmutableLongArray array = createTestArray(new long[] { 1L, 2L, 3L });
        logger.info("Bloom filter false positive rate: {}", falsePositiveRate);
            int[] hashPositions = calculateHashes(item, numHashes, bitArraySize);
}
        for (int i = 0; i < threads.length; i++) {
    }
            int randomIndex = randomIntBetween(0, testData.length - 1);
        int elementCount = 1000;
    private long mixHash(long h) {
            String item = "item" + i;  
        long setBits = countSetBits(bloomFilterArray, bitArray.length);  
            String item = "item" + randomIntBetween(0, expectedItems - 1);
        h ^= h >>> 33;
        int size = randomIntBetween(10_000, 100_000);
        long duration = endTime - startTime;  
        expectThrows(OpenSearchException.class, () -> array.get(-1));  
        expectThrows(UnsupportedOperationException.class, () -> array.set(0, 42L));
        TestRandomAccessInput(long[] data) {
        IndexInputImmutableLongArray bloomFilterArray = createTestArray(bitArray);
            }
                    int randomIndex = randomIntBetween(0, elementCount - 1);
                    found = false;
 * SPDX-License-Identifier: Apache-2.0
        }  
 *
            boolean found = true;
    public void testBasicOperations() {  
        }
        }
                falsePositives++;  
        int bitsPerItem = 10;
        IndexInputImmutableLongArray bloomFilterArray = createTestArray(bitArray);
        }
package org.opensearch.index.codec.fuzzy;
        for (int i = 0; i < testData.length; i++) {
    public void testConcurrentAccess() throws Exception {
        int testCount = 10000;  
            for (int pos : hashPositions) {  
        IndexInputImmutableLongArray array = createTestArray(new long[] { 1L, 2L, 3L });
    private long countSetBits(IndexInputImmutableLongArray array, int length) {  
        assertEquals(0, array.size());
        }  
        int elementCount = 10_000;
        long[] bitArray = new long[elementCount];  
        }
    }
        int bitArraySize = expectedItems * bitsPerItem;
            for (int pos : hashPositions) {
    }  
        IndexInputImmutableLongArray array = createTestArray(new long[] { 1L, 2L, 3L });  
                int longIndex = pos >>> 6;  
        @Override
        }  
        int numHashes = 7;
        logger.info("Bloom filter fill ratio: {}", fillRatio);
                    break;
        assertEquals("First element should be accessible", bitArray[0], array.get(0));
            int[] hashPositions = calculateHashes(item, numHashes, bitArraySize);
import java.io.IOException;
            int randomIndex = randomIntBetween(0, elementCount - 1);
            int[] hashPositions = calculateHashes(nonExistentItem, numHashes, bitArraySize);
            assertEquals(testData[i], array.get(i));
        return count;
        int longArraySize = (bitArraySize + 63) / 64;
                throw new IOException("Invalid position: " + pos);  
            int[] hashPositions = calculateHashes(item, numHashes, bitArraySize);
        int falseNegatives = 0;
            }  
        long[] testData = new long[1000];
        long[] bitArray = new long[longArraySize];  
    public void testLargeArrayPerformance() throws IOException {
        int expectedItems = 1000;
        h *= 0xc4ceb9fe1a85ec53L;  
        IndexInputImmutableLongArray array = createTestArray(bitArray);
        }
        expectThrows(OpenSearchException.class, () -> array.get(elementCount));
        }  
        int lookups = 1000;  
        for (int i = 0; i < size; i++) {  
                long bitMask = 1L << (pos & 63);
        assertEquals(size, array.size());  
        IndexInputImmutableLongArray array = createTestArray(new long[] {});
        Thread[] threads = new Thread[3];  
 * compatible open source license.
            }
        @Override
    public void testRandomAccess() {  
            bitArray[i] = randomLong();
        for (int i = 0; i < testCount; i++) {
    public void testEmptyArray() {  
                long bitMask = 1L << (pos & 63);  
            threads[i].start();
    }  
            for (int pos : hashPositions) {  
            for (int pos : hashPositions) {
    public void testInvalidAccess() {
    }
            throw new UnsupportedOperationException();
        String[] addedItems = new String[expectedItems];
        expectThrows(UnsupportedOperationException.class, () -> array.increment(0, 1L));  
    }
            }
        for (int i = 0; i < length; i++) {
            testData[i] = randomLong();  
        h *= 0xff51afd7ed558ccdL;
                int longIndex = pos >>> 6;
        long[] testData = { 1L, 2L, 3L, 4L, 5L };
        IndexInputImmutableLongArray array = createTestArray(bitArray);
        @Override
        }
            bitArray[i] = randomLong();
        array.close(); // Should not throw any exception  
    }  
        for (int i = 0; i < elementCount; i++) {
        }
        IndexInputImmutableLongArray array = createTestArray(bitArray);
        long hash2 = mixHash(hash1);
        long[] bitArray = new long[elementCount];  
        for (Thread thread : threads) {
    public void testBloomFilterFunctionality() throws IOException {  
                int longIndex = pos >>> 6;  
                }
    private int[] calculateHashes(String item, int numHashes, int size) {
        final IndexInputImmutableLongArray array = createTestArray(bitArray);
        IndexInputImmutableLongArray array = createTestArray(testData);
                    break;
        int expectedItems = 10_000;  
        for (int i = 0; i < 100; i++) {  
        }  
        int bitArraySize = expectedItems * bitsPerItem;  
        assertEquals("Last element should be accessible", bitArray[elementCount - 1], array.get(elementCount - 1));  
                    break;
                pos = pos % bitArraySize;  
            assertTrue("Should find existing item", found);
