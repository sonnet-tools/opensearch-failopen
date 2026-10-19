            while (iterator.hasNext()) {
package org.opensearch.index.codec.fuzzy;
                }
                assertEquals(FuzzySet.Result.MAYBE, filter.contains(iterator.next()));
        }
        logger.info("All {} elements correctly identified in bloom filter", elementCount);
            assertEquals(FuzzySet.Result.MAYBE, reconstructedFilter.contains(element));
                        if (filter.contains(new BytesRef(element)) == FuzzySet.Result.MAYBE && !initialElements.contains(element)) {
            Thread thread = new Thread(() -> {
        int testCount = 20000;
            public BytesRef next() {
    }
        }
        assertEquals(originalFilter.setType(), deserializedFilter.setType());
                falsePositives++;
            Iterator<BytesRef> iterator = idIterator(elementCount);
        logger.info("Bloom filter stats - Target FPP: {}, Actual FPP: {}, Elements: {}", targetFpp, actualFpp, elementCount);
        double targetFpp = 0.01;
        logger.info("Bloom filter fill ratio: {}", fillRatio);
        assertEquals(FuzzySet.SetType.BLOOM_FILTER_V1, bloomFilter.setType());
        int falsePositives = 0;
            assertEquals(FuzzySet.Result.MAYBE, filter.contains(new BytesRef(element)));
            testElements.add(testElement);
    private double getFpp() {
                    startLatch.await();
import java.io.IOException;
        double fillRatio = (double) setBits / expectedBits;
            if (filter.contains(new BytesRef(element)) == FuzzySet.Result.MAYBE) {
            assertFalse(filter.isSaturated());
        int elementCount = 100;
        for (int i = 0; i < elementsPerThread; i++) {
            fpp,
        BloomFilter filter = new BloomFilter(
            addedElements.add("test" + i);
        int elementCount = 10000;
    }
        int testCount = 100;
            BytesRef element = iterator.next();
        for (int i = elementCount; i < elementCount + testCount; i++) {
        BloomFilter filter = new BloomFilter(1000, fpp, () -> idIterator(elementCount));
            elements.add("prefix" + randomAlphaOfLength(5) + i);
        int elementCount = 5000;
        long maxDocs = randomLongBetween(Integer.MAX_VALUE, 5L * Integer.MAX_VALUE);
        }
        int falsePositives = 0;
                setBits++;
        BloomFilter bloomFilter = new BloomFilter(20000, getFpp(), () -> idIterator(elementCount));
        ByteArrayDataOutput out = new ByteArrayDataOutput(buffer);
        }
        }
        Set<String> addedElements = new HashSet<>();
    public void testBloomFilterEnabled() throws IOException {
import org.apache.lucene.store.ByteArrayDataOutput;
        out.writeString(filter.setType().getSetName());
                falsePositives++;
        logger.info("Concurrent false positive rate: {}", fpRate);
        AtomicInteger falsePositives = new AtomicInteger(0);
        BloomFilter filter = new BloomFilter(elementCount, fpp, () -> elements.stream().map(BytesRef::new).iterator());
        int elementCount = 1000;
import java.util.ArrayList;
        List<String> addedElements = new ArrayList<>();
            assertEquals(originalFilter.contains(element), deserializedFilter.contains(element));
            thread.start();
        Set<String> testElements = new HashSet<>();
                    }
        int elementCount = randomIntBetween(1, 100);
        double actualFpp = (double) falsePositives / testCount;
        assertEquals(false, bloomFilter.isSaturated());
    }
            int cnt = count;
        CountDownLatch endLatch = new CountDownLatch(numThreads);
        double fpp = 0.01;
        return buffer;
    }
                } finally {
        for (int i = 0; i < elementCount; i++) {
    }
        int elementCount = 500;
                testElement = "test" + randomAlphaOfLength(10) + i;
                            falsePositives.incrementAndGet();
                    for (int i = 0; i < elementsPerThread; i++) {
        Iterator<BytesRef> iterator = idIterator(elementCount);
        for (int i = 0; i < elementCount; i++) {
            assertEquals(FuzzySet.Result.MAYBE, filter.contains(new BytesRef(Integer.toString(i))));
        for (long i = 0; i < expectedBits; i++) {
import java.util.concurrent.CountDownLatch;
            String testElement;
        int elementCount = randomIntBetween(1, 100);
        int elementsPerThread = 1000;
            }
        for (int i = 0; i < elementCount; i++) {
                } catch (Exception e) {
        );
                        String element = "thread" + threadId + "element" + i;
            BytesRef element = idIterator.next();
    public void testBloomFilterEffectiveness() throws IOException {
import java.util.HashSet;
    }
        }
    private FuzzySet deserializeFilter(byte[] serialized) throws IOException {
    private byte[] serializeFilter(BloomFilter filter) throws IOException {
 * The OpenSearch Contributors require contributions made to
            @Override
        int numThreads = 3;
    private Iterator<BytesRef> idIterator(int count) {
        assertEquals(FuzzySet.SetType.BLOOM_FILTER_V1, bloomFilter.setType());
        int elementCount = 1000;
        double fpp = 0.01;
        assertTrue("Fill ratio should be reasonable (between 0.1 and 0.9)", fillRatio > 0.1 && fillRatio < 0.9);
            BloomFilter filter = new BloomFilter(elementCount, fpp, () -> idIterator(elementCount));
 *
        BloomFilter filter = new BloomFilter(elementCount, targetFpp, () -> idIterator(elementCount));
            }
        }
        }
    public void testBloomFilterFalsePositiveRate() throws IOException {
            @Override
        int falsePositives = 0;
    public void testBloomFilterIsSaturated_returnsFalse() throws IOException {
    }
        }
            }
        long maxDocs = elementCount * 10L; // Keeping this high so that it ensures some bits are not set.
        long setBits = 0;
            elementsPerThread * (numThreads + 1),
        long expectedBits = (long) Math.ceil(-elementCount * Math.log(fpp) / (Math.log(2) * Math.log(2)));
        }
        double fpp = 0.01;
        Set<String> initialElements = new HashSet<>();
    public void testBloomFilterSerialization() throws IOException {
    public void testBloomFilterSerializationDeserialization() throws IOException {
        assertTrue("Concurrent false positive rate should be reasonable", fpRate <= fpp * 2);
        CountDownLatch startLatch = new CountDownLatch(1);
        int elementCount = 10000;
        byte[] serialized = serializeFilter(originalFilter);
        endLatch.await();
    public void testBloomFilterContainsElement() throws IOException {
    public void testBloomFilterConcurrency() throws Exception {
        for (int i = 0; i < testCount; i++) {
            public boolean hasNext() {
 * this file be licensed under the Apache-2.0 license or a
        for (int i = elementCount; i < elementCount + testCount; i++) {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(FuzzySet.SetType.BLOOM_FILTER_V1, reconstructedFilter.setType());
            });
    }
        FuzzySet reconstructedFilter = FuzzySetFactory.deserializeFuzzySet(new ByteArrayIndexInput("filter", buffer));
        for (String element : addedElements) {
        assertEquals(FuzzySet.SetType.BLOOM_FILTER_V1, filter.setType());
            addedElements.add("element" + randomAlphaOfLength(10) + i);
        double[] fpps = { 0.01, 0.05, 0.1, 0.2 };
    }
        }
        for (int i = 0; i < elementCount; i++) {
        filter.writeTo(out);
        BloomFilter filter = new BloomFilter(elementCount, fpp, () -> addedElements.stream().map(BytesRef::new).iterator());
public class BloomFilterTests extends OpenSearchTestCase {
        BloomFilter bloomFilter = new BloomFilter(maxDocs, getFpp(), () -> List.of(new BytesRef("bar")).iterator());
            () -> initialElements.stream().map(BytesRef::new).iterator()
        logger.info("False positive rate: {}", actualFpp);
import java.util.Set;
            }
        }
        double fpRate = (double) falsePositives.get() / (elementsPerThread * numThreads);
            }
    }
        double actualFpp = (double) falsePositives / testCount;
        while (idIterator.hasNext()) {
import java.util.Iterator;
        assertTrue("False positive rate should be reasonable", actualFpp <= targetFpp * 2);
}
                try {
            if (filter.containsHash(i) == FuzzySet.Result.MAYBE) {
        for (int t = 0; t < numThreads; t++) {
                    fail("Thread execution failed: " + e.getMessage());
    }
    }
        for (double fpp : fpps) {
    public void testBloomFilterWithLargeCapacity() throws IOException {
        assertTrue("False positive rate should be reasonable", actualFpp <= fpp * 2);
        }
        List<String> elements = new ArrayList<>();
        return new Iterator<BytesRef>() {
            assertEquals(FuzzySet.Result.MAYBE, filter.contains(element));
    public void testBloomFilterDistribution() throws IOException {
        BloomFilter filter = new BloomFilter(maxDocs, getFpp(), () -> idIterator(elementCount));
            initialElements.add("initial" + i);
                        }
        return randomDoubleBetween(0.01, 0.50, true);
        for (String element : testElements) {
        ByteArrayDataOutput out = new ByteArrayDataOutput(buffer);
        }
 */
        double actualFpp = (double) falsePositives / testCount;
import java.util.concurrent.atomic.AtomicInteger;
        assertTrue("False positive rate " + actualFpp + " should be close to target " + targetFpp, actualFpp <= targetFpp * 2);
    }
import org.opensearch.test.OpenSearchTestCase;
                falsePositives++;
        int testCount = 10000;
        BloomFilter filter = new BloomFilter(elementCount, targetFpp, () -> addedElements.stream().map(BytesRef::new).iterator());
        assertEquals(true, bloomFilter.isSaturated());
        }
            if (filter.contains(new BytesRef(Integer.toString(i))) == FuzzySet.Result.MAYBE) {
        for (String element : initialElements) {
            assertEquals(FuzzySet.Result.MAYBE, filter.contains(new BytesRef(Integer.toString(i))));
    public void testBloomFilterWithDifferentFPP() throws IOException {
    }
    }
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
        double targetFpp = 0.01;
        startLatch.countDown();
        BloomFilter bloomFilter = new BloomFilter(1L, getFpp(), () -> idIterator(1000));
        for (int i = 0; i < elementCount; i++) {
                return new BytesRef(Integer.toString(cnt));
            } while (addedElements.contains(testElement));
            final int threadId = t;
            do {
        Iterator<BytesRef> idIterator = idIterator(elementCount);
    public void testBloomFilterIsSaturated_returnsTrue() throws IOException {
        return FuzzySetFactory.deserializeFuzzySet(new ByteArrayIndexInput("filter", serialized));
            assertEquals("Should find added element: " + element, FuzzySet.Result.MAYBE, filter.contains(new BytesRef(element)));
        double fpp = 0.01;
        }
        filter.writeTo(out);
        while (iterator.hasNext()) {
        }
import java.util.List;
            }
        byte[] buffer = new byte[bufferSize];
        int bufferSize = (int) Math.max(8192, filter.ramBytesUsed() * 2);
        assertEquals(FuzzySet.SetType.BLOOM_FILTER_V1, bloomFilter.setType());
        out.writeString(filter.setType().getSetName());
 * compatible open source license.
/*
        BloomFilter originalFilter = new BloomFilter(elementCount * 2, 0.05, () -> idIterator(elementCount));
        byte[] buffer = new byte[(int) maxDocs * 5];
            if (filter.contains(new BytesRef(Integer.toString(i))) == FuzzySet.Result.MAYBE) {
import org.apache.lucene.util.BytesRef;
                    endLatch.countDown();
        };
        FuzzySet deserializedFilter = deserializeFilter(serialized);
    }
            }
                return cnt-- > 0;
