                elements.add(new BytesRef("test" + i));
        assertTrue("Should return NO or MAYBE for non-existent element", result == FuzzySet.Result.NO || result == FuzzySet.Result.MAYBE);
        setTypeMap.put("field2", new FuzzySetParameters(() -> 0.2));
        assertNotNull(deserializedSet);
        FuzzySetFactory factory = new FuzzySetFactory(setTypeMap);
        FuzzySet deserializedSet = FuzzySetFactory.deserializeFuzzySet(createTestIndexInput(serialized));
        for (int i = 0; i < testCount; i++) {
                );
                count--;
            public long getFilePointer() {
            @Override
 * this file be licensed under the Apache-2.0 license or a
        }
import java.util.Map;
            List<BytesRef> elements = new ArrayList<>();
import org.apache.lucene.store.ByteArrayDataOutput;
import org.apache.lucene.util.BytesRef;
                }
            public boolean hasNext() {
            }
            }
                return new BytesRef(randomAlphaOfLength(10));
        setTypeMap.put(TEST_FIELD, new FuzzySetParameters(() -> 0.01));
        public short readShort(long pos) {
        setTypeMap.put(TEST_FIELD, new FuzzySetParameters(() -> 0.1));
    private static class TestRandomAccessInput implements RandomAccessInput {
            for (int i = 0; i < size; i++) {
        assertEquals(FuzzySet.SetType.BLOOM_FILTER_V1, fuzzySet.setType());
    public void testBloomFilterFunctionality() throws IOException {
            public BytesRef next() {
import java.util.Iterator;
                }
        for (int size : sizes) {
            FuzzySet fuzzySet = factory.createFuzzySet(size * 2, TEST_FIELD, () -> {
        @Override
            double falsePositiveRate = (double) falsePositives / testCount;
        assertNotNull(fuzzySet);
        if (result == FuzzySet.Result.MAYBE) {
    private IndexInput createTestIndexInput(byte[] data) {
        Map<String, FuzzySetParameters> setTypeMap = new HashMap<>();
                return count > 0;
            assertEquals(
        int testCount = 100;
                falsePositives++;
        for (int i = 0; i < testCount; i++) {
                return null;
        assertEquals("Should return MAYBE for existing element", FuzzySet.Result.MAYBE, fuzzySet.contains(new BytesRef("test2")));
package org.opensearch.index.codec.fuzzy;
            private int remaining = size;
    }
    }
        }
            );
        private final byte[] data;
                this.pos = pos;
public class FuzzySetFactoryTests extends OpenSearchTestCase {
        @Override
        }
        TestRandomAccessInput(byte[] data, long offset) {
                falsePositives++;
                }
            }
    }
                    fuzzySet.contains(new BytesRef("test" + i))
 * compatible open source license.
                        "VInt decoding not fully implemented in test mock - " + "string length exceeds 127 characters"
        Map<String, FuzzySetParameters> setTypeMap = new HashMap<>();
        filter.writeTo(out);
        int testCount = 1000;
 * The OpenSearch Contributors require contributions made to
        BloomFilter originalFilter = new BloomFilter(100, 0.1, () -> createTestIterator());
            }
            }
            public RandomAccessInput randomAccessSlice(long offset, long length) {
            @Override
            List<BytesRef> elements = new ArrayList<>();
                falsePositiveRate <= 0.04
            logger.info("Got false positive for non-existent element (expected behavior with small probability)");
    public void testMultipleFields() throws IOException {
    }
        setTypeMap.put(TEST_FIELD, new FuzzySetParameters(() -> targetFpp));
                if (result == FuzzySet.Result.MAYBE) {
        double targetFpp = 0.1;
                pos += len;
                "False positive rate " + falsePositiveRate + " should be below threshold for size " + size,
                return data.length;
                for (int i = 0; i < size / 2; i++) {
            }
import java.util.HashMap;
            return Arrays.asList(new BytesRef("test1"), new BytesRef("test2"), new BytesRef("test3")).iterator();
            return elements.iterator();
        assertEquals(FuzzySet.SetType.BLOOM_FILTER_V1, set2.setType());
    }
            return value;
        FuzzySetFactory factory = new FuzzySetFactory(setTypeMap);
        Map<String, FuzzySetParameters> setTypeMap = new HashMap<>();
        FuzzySetFactory factory = new FuzzySetFactory(setTypeMap);
        FuzzySet set2 = factory.createFuzzySet(100, "field2", () -> createTestIterator());
                "Should return MAYBE for existing element",
import java.util.Arrays;
 */
        setTypeMap.put(TEST_FIELD, new FuzzySetParameters(() -> 0.1));
            @Override
                List<BytesRef> elements = new ArrayList<>();
        assertEquals(FuzzySet.SetType.BLOOM_FILTER_V1, deserializedSet.setType());
                return data[(int) pos++];
        });
    private byte[] serializeFilter(BloomFilter filter) throws IOException {
        private final long offset;
    }
    }
            public byte readByte() {
                assertEquals(
import java.nio.charset.StandardCharsets;
            return data.length - offset;
        return new Iterator<BytesRef>() {
            throw new UnsupportedOperationException();
            int testCount = 100;
            if (fuzzySet.contains(new BytesRef("nonexistent" + i)) == FuzzySet.Result.MAYBE) {
        }
        }
            @Override
        assertEquals("Should return MAYBE for existing element", FuzzySet.Result.MAYBE, fuzzySet.contains(new BytesRef("test3")));
import org.apache.lucene.store.IndexInput;
        double falsePositiveRate = (double) falsePositives / testCount;
        FuzzySet fuzzySet = factory.createFuzzySet(100, TEST_FIELD, () -> {
            return data[(int) (offset + pos)];
            for (int i = 0; i < maxDocs; i++) {
            public IndexInput slice(String sliceDescription, long offset, long length) {
        FuzzySet fuzzySet = factory.createFuzzySet(maxDocs, TEST_FIELD, () -> {
    }
        }
import java.io.IOException;
            for (int i = 0; i < size / 2; i++) {
    public void testBloomFilterWithVerySmallSet() throws IOException {
            }
        });
            IllegalArgumentException.class,
        return new IndexInput("test") {
            @Override
        assertNotNull("Bloom filter should be created", fuzzySet);
        setTypeMap.put(TEST_FIELD, new FuzzySetParameters(() -> 0.01));
            }
    public void testBloomFilterFalsePositiveRate() throws IOException {
        public long readLong(long pos) {
        public byte readByte(long pos) {
            }
        int size = 10;
            int falsePositives = 0;
            throw new UnsupportedOperationException();
                return pos;
            private long pos = 0;
            }
        }
            () -> factory.createFuzzySet(100, "non_existent_field", () -> createTestIterator())
            for (int i = 0; i < 8; i++) {
            this.data = data;
    }
        for (int i = 0; i < size; i++) {
            @Override
            }
        assertTrue("False positive rate " + actualFpp + " should be close to target " + targetFpp, actualFpp <= targetFpp * 1.5);
    private Iterator<BytesRef> createRandomIterator(int size) {
import java.util.ArrayList;
        byte[] buffer = new byte[8192];
        Map<String, FuzzySetParameters> setTypeMap = new HashMap<>();
            public long length() {
            }
        assertTrue("False positive rate " + falsePositiveRate + " should be reasonable for small set", falsePositiveRate <= 0.02);
        @Override
                int length = readByte() & 0xFF;
            public boolean hasNext() {
    }
        );
        return new Iterator<BytesRef>() {
            @Override
                elements.add(new BytesRef("smalltest" + i));
}
                FuzzySet.Result result = fuzzySet.contains(new BytesRef("nonexistent_" + i));
            @Override
            assertTrue(
        assertNotNull(set2);
                    "Should return MAYBE for existing element in size " + size,
    }
        FuzzySetFactory factory = new FuzzySetFactory(setTypeMap);
        }
        assertEquals(FuzzySet.SetType.BLOOM_FILTER_V1, set1.setType());
 *
        }
        int[] sizes = { 100, 1000, 10000 };
            @Override
            for (int i = 0; i < testCount; i++) {
        int maxDocs = 1000;
        assertEquals("Should return MAYBE for existing element", FuzzySet.Result.MAYBE, fuzzySet.contains(new BytesRef("test1")));
        FuzzySet fuzzySet = factory.createFuzzySet(100, TEST_FIELD, () -> createTestIterator());
    public void testCreateBloomFilter() throws IOException {
            this.offset = offset;
        double actualFpp = (double) falsePositives / testCount;
    public void testCreateWithInvalidField() {
        return buffer;
        byte[] serialized = serializeFilter(originalFilter);
            @Override
        setTypeMap.put("field1", new FuzzySetParameters(() -> 0.1));
        @Override
                    FuzzySet.Result.MAYBE,
                // Read VInt-encoded length (simplified: assuming small strings for tests)
        };
            }
                    falsePositives++;
                System.arraycopy(data, (int) pos, b, offset, len);
                return new String(bytes, StandardCharsets.UTF_8);
        @Override
                byte[] bytes = new byte[length];
 * SPDX-License-Identifier: Apache-2.0
        int maxDocs = 100;
                value = (value << 8) | (data[(int) (offset + pos + i)] & 0xFF);
        FuzzySet fuzzySet = factory.createFuzzySet(maxDocs, TEST_FIELD, () -> {
                return elements.iterator();
            @Override
        ByteArrayDataOutput out = new ByteArrayDataOutput(buffer);
        public int readInt(long pos) {
                return new TestRandomAccessInput(data, offset);
            public void readBytes(byte[] b, int offset, int len) {
                FuzzySet.Result.MAYBE,
            @Override
        assertNotNull(set1);
                    );
        FuzzySetFactory factory = new FuzzySetFactory(setTypeMap);
            }
            public String readString() throws IOException {
        };
            if (fuzzySet.contains(new BytesRef("distinct_nonexistent_" + i)) == FuzzySet.Result.MAYBE) {
            public BytesRef next() {
        assertTrue(exception.getMessage().contains("non_existent_field"));
        FuzzySetFactory factory = new FuzzySetFactory(setTypeMap);
        FuzzySetFactory factory = new FuzzySetFactory(setTypeMap);
                if (length > 127) {
        assertEquals("Should be bloom filter type", FuzzySet.SetType.BLOOM_FILTER_V1, fuzzySet.setType());
                fuzzySet.contains(new BytesRef("smalltest" + i))
    private Iterator<BytesRef> createTestIterator() {
                return new BytesRef("test" + count);
            );
            }
    public void testDeserializeFuzzySet() throws IOException {
        FuzzySet set1 = factory.createFuzzySet(100, "field1", () -> createTestIterator());
        }
            long value = 0;
    private static final String TEST_FIELD = "test_field";
            public void seek(long pos) {
                    throw new UnsupportedOperationException(
        Map<String, FuzzySetParameters> setTypeMap = new HashMap<>();
        int falsePositives = 0;
            }
        int falsePositives = 0;
        Map<String, FuzzySetParameters> setTypeMap = new HashMap<>();
        };
                readBytes(bytes, 0, length);
        out.writeString(filter.setType().getSetName());
            }
    }
        });
            @Override
            });
    }
                return remaining > 0;
        }
import org.opensearch.test.OpenSearchTestCase;
        setTypeMap.put(TEST_FIELD, new FuzzySetParameters(() -> 0.1));
                    elements.add(new BytesRef("test" + i));
        Map<String, FuzzySetParameters> setTypeMap = new HashMap<>();
            public void close() {}
            private int count = 3;
                remaining--;
import java.util.List;
import org.apache.lucene.store.RandomAccessInput;
        FuzzySet.Result result = fuzzySet.contains(new BytesRef("definitely_not_in_set_xyz_123"));
            }
    public void testBloomFilterWithDifferentSizes() throws IOException {
        IllegalArgumentException exception = expectThrows(
        public long length() {
            return elements.iterator();
            }
/*
