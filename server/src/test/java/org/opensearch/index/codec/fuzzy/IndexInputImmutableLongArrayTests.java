        IndexInputImmutableLongArray array = createTestArray(bitArray);
        h ^= h >>> 33;
        for (int i = 0; i < testData.length; i++) {
    }
        assertEquals(elementCount, array.size());
                    break;
        for (int i = 0; i < numHashes; i++) {
                long bitMask = 1L << (pos & 63);
        expectThrows(OpenSearchException.class, () -> array.get(array.size()));
        int lookups = 1000;
        }
    }
            positions[i] = (int) (Math.abs(combinedHash % size));
        long startTime = System.nanoTime();
            return data[(int) (pos / 8)];
        IndexInputImmutableLongArray array = createTestArray(new long[] {});
        }
        int[] positions = new int[numHashes];
        @Override
        }
        for (int i = 0; i < 100; i++) {
        for (int i = 0; i < 100; i++) {
        h *= 0xff51afd7ed558ccdL;
        private final long[] data;
            int randomIndex = randomIntBetween(0, testData.length - 1);
        @Override
        long count = 0;
                    found = false;
        }
        long[] bitArray = new long[longArraySize];
            assertEquals(testData[randomIndex], array.get(randomIndex));
        IndexInputImmutableLongArray array = createTestArray(bitArray);
        double fillRatio = (double) setBits / (bitArraySize);
        int bitArraySize = expectedItems * bitsPerItem;
            throw new UnsupportedOperationException();
        expectThrows(UnsupportedOperationException.class, () -> array.increment(0, 1L));
        expectThrows(UnsupportedOperationException.class, () -> array.fill(0, 2, 42L));
    }
        }
        int expectedItems = 1000;
                if ((bloomFilterArray.get(longIndex) & bitMask) == 0) {
    public void testEmptyArray() {
        expectThrows(UnsupportedOperationException.class, () -> array.set(0, randomLong()));
            int randomIndex = randomIntBetween(0, elementCount - 1);
            thread.join();
        for (int i = 0; i < threads.length; i++) {
                int longIndex = pos >>> 6;
        public short readShort(long pos) {
                pos = pos % bitArraySize;
            assertTrue("Should find existing item", found);
    public void testConcurrentAccess() throws Exception {
                long bitMask = 1L << (pos & 63);
        h ^= h >>> 33;
        int numHashes = 7;
        IndexInputImmutableLongArray array = createTestArray(new long[] { 1L, 2L, 3L });
            }
    public void testBloomFilterFunctionality() throws IOException {
    private IndexInputImmutableLongArray createTestArray(long[] data) {
    private long countSetBits(IndexInputImmutableLongArray array, int length) {
        int elementCount = 100;
            boolean found = true;
    public void testRandomAccess() {
import java.io.IOException;
        long[] bitArray = new long[elementCount];
            if (pos < 0 || pos >= data.length * 8L) {
            throw new UnsupportedOperationException();
    }
    public void testArrayBoundaries() throws IOException {
        IndexInputImmutableLongArray array = createTestArray(new long[] { 1L, 2L, 3L });
        for (int i = 0; i < 100; i++) {
            boolean found = true;
        }
        logger.info("Random access time for {} elements: {} ns", elementCount, duration);
            count += Long.bitCount(array.get(i));
    }
            assertEquals(bitArray[randomIndex], array.get(randomIndex));
        IndexInputImmutableLongArray array = createTestArray(new long[] { 1L, 2L, 3L });
        }
            testData[i] = randomLong();
                long bitMask = 1L << (pos & 63);
            long combinedHash = hash1 + i * hash2;
                    break;
            assertEquals(bitArray[randomIndex], array.get(randomIndex));
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(array.ramBytesUsed() > 0);
        return new IndexInputImmutableLongArray(data.length, new TestRandomAccessInput(data));
        }
                int longIndex = pos >>> 6;
        for (Thread thread : threads) {
        int longArraySize = (bitArraySize + 63) / 64;
        h ^= h >>> 33;
        public byte readByte(long pos) {
        for (int i = 0; i < elementCount; i++) {
    public void testClose() {
        h *= 0xc4ceb9fe1a85ec53L;
            if (found) {
            }
        long endTime = System.nanoTime();
        }
public class IndexInputImmutableLongArrayTests extends OpenSearchTestCase {
        IndexInputImmutableLongArray array = createTestArray(new long[] { 1L, 2L, 3L });
    }
        int bitArraySize = expectedItems * bitsPerItem;
        long[] testData = { 1L, 2L, 3L, 4L, 5L };
    }
        assertEquals(testData.length, array.size());
        assertEquals(0, array.size());
        int elementCount = 10_000;
        long hash2 = mixHash(hash1);
        }
    public void testBloomFilterPerformance() throws IOException {
    }
        int elementCount = 1000;
                int longIndex = pos >>> 6;
                if ((bloomFilterArray.get(longIndex) & bitMask) == 0) {
        int testCount = 10000;
        assertEquals("Last element should be accessible", bitArray[elementCount - 1], array.get(elementCount - 1));
            int[] hashPositions = calculateHashes(item, numHashes, bitArraySize);
        int size = randomIntBetween(10_000, 100_000);
        for (int i = 0; i < length; i++) {
        int falseNegatives = 0;
        assertEquals("First element should be accessible", bitArray[0], array.get(0));
            for (int pos : hashPositions) {
}
import org.apache.lucene.store.RandomAccessInput;
                pos = pos % bitArraySize;
        for (int i = 0; i < expectedItems; i++) {
                int longIndex = pos >>> 6;
        for (int i = 0; i < elementCount; i++) {
        TestRandomAccessInput(long[] data) {
        String[] addedItems = new String[expectedItems];
    }
        for (int i = 0; i < lookups; i++) {
            }
        int bitsPerItem = 10;
                falsePositives++;
        long[] bitArray = new long[elementCount];
            }
                    break;
            int[] hashPositions = calculateHashes(item, numHashes, bitArraySize);
            int randomIndex = randomIntBetween(0, elementCount - 1);
        IndexInputImmutableLongArray array = createTestArray(testData);
        for (String item : addedItems) {
        }
                    assertEquals(bitArray[randomIndex], array.get(randomIndex));
    private static class TestRandomAccessInput implements RandomAccessInput {
        int numHashes = 7;
        }
            int[] hashPositions = calculateHashes(nonExistentItem, numHashes, bitArraySize);
            assertEquals(testData[i], array.get(i));
        long[] bitArray = new long[elementCount];
    public void testBasicOperations() {
            }
        logger.debug("Bloom filter operation completed successfully with {} items and {} lookups", expectedItems, lookups);
        assertTrue("Fill ratio should be reasonable", fillRatio > 0.1 && fillRatio < 0.9);
        final IndexInputImmutableLongArray array = createTestArray(bitArray);
            int[] hashPositions = calculateHashes(item, numHashes, bitArraySize);
        assertTrue("False positive rate should be reasonable (< 0.1)", falsePositiveRate < 0.1);
    public void testRamBytesUsed() {
        IndexInputImmutableLongArray array = createTestArray(testData);
    public void testLargeArray() {
    public void testInvalidAccess() {
    public void testArrayWithBloomFilter() throws IOException {
        expectThrows(OpenSearchException.class, () -> array.get(-1));
    }
            String item = "item" + randomIntBetween(0, expectedItems - 1);
    }
                    int randomIndex = randomIntBetween(0, elementCount - 1);
        int bitsPerItem = 10;
                }
    }
        for (int i = 0; i < testData.length; i++) {
        }
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 0; i < size; i++) {
            }
        IndexInputImmutableLongArray array = createTestArray(bitArray);
        logger.info("Bloom filter fill ratio: {}", fillRatio);
                bitArray[longIndex] |= bitMask;
 */
            bitArray[i] = randomLong();
            return data.length * 8L;
                    found = false;
        long[] testData = new long[1000];
            for (int pos : hashPositions) {
        expectThrows(UnsupportedOperationException.class, () -> array.set(0, 42L));
            for (int pos : hashPositions) {
            addedItems[i] = "item" + i;
        }
        int expectedItems = 10_000;
        }
        expectThrows(OpenSearchException.class, () -> array.get(-1));
        }
        for (int i = 0; i < testCount; i++) {
package org.opensearch.index.codec.fuzzy;
        long duration = endTime - startTime;
    private long mixHash(long h) {
    }
                }
                }
        @Override
        @Override
        return positions;
                    found = false;
        }
        int elementCount = 100_000;
            int randomIndex = randomIntBetween(0, size - 1);
    }
            threads[i].start();
                int longIndex = pos >>> 6;
        IndexInputImmutableLongArray bloomFilterArray = createTestArray(bitArray);
            int[] hashPositions = calculateHashes(addedItems[i], numHashes, bitArraySize);
/*
        long[] bitArray = new long[longArraySize];
                long bitMask = 1L << (pos & 63);
        return h;
            testData[i] = randomLong();
                bitArray[longIndex] |= bitMask;
 * The OpenSearch Contributors require contributions made to
        int falsePositives = 0;
            }
        long hash1 = mixHash(item.hashCode());
        int longArraySize = (bitArraySize + 63) / 64;
            bitArray[i] = randomLong();
            boolean found = true;
            for (int pos : hashPositions) {
                }
        }
                long bitMask = 1L << (pos & 63);
        }
        expectThrows(OpenSearchException.class, () -> array.get(elementCount));
 *
 * this file be licensed under the Apache-2.0 license or a
            }
        }
        @Override
 * compatible open source license.
        }
            threads[i] = new Thread(() -> {
        long setBits = countSetBits(bloomFilterArray, bitArray.length);
        logger.info("Bloom filter false positive rate: {}", falsePositiveRate);
        }
            assertEquals(testData[randomIndex], array.get(randomIndex));
                for (int j = 0; j < 1000; j++) {
            throw new UnsupportedOperationException();
            for (int pos : hashPositions) {
        long[] testData = new long[size];
        }
        IndexInputImmutableLongArray array = createTestArray(testData);
            String nonExistentItem = "nonexistent" + randomAlphaOfLength(10) + i;
            });
        assertEquals("Bloom filter should have no false negatives", 0, falseNegatives);
        IndexInputImmutableLongArray bloomFilterArray = createTestArray(bitArray);
        array.close(); // Should not throw any exception
        for (int i = 0; i < elementCount; i++) {
        }
        for (int i = 0; i < 1000; i++) {
    public void testLargeArrayPerformance() throws IOException {
        public long readLong(long pos) throws IOException {
                throw new IOException("Invalid position: " + pos);
            String item = "item" + i;
    }
        long[] bitArray = new long[elementCount];
            if (!found) {
        public int readInt(long pos) {
                if ((bloomFilterArray.get(longIndex) & bitMask) == 0) {
            bitArray[i] = randomLong();
        for (int i = 0; i < expectedItems; i++) {
    }
        Thread[] threads = new Thread[3];
        }
    }
        assertEquals(size, array.size());
            this.data = data;
        return count;
    }
    private int[] calculateHashes(String item, int numHashes, int size) {
    }
        double falsePositiveRate = (double) falsePositives / testCount;
                falseNegatives++;
import org.opensearch.OpenSearchException;
        public long length() {
    public void testUnsupportedOperations() {
