                    )
 * SPDX-License-Identifier: Apache-2.0
        }
    public void testSingleFullPageBulkWriteWithOffset() throws Exception {
        assertEquals(in.available(), bytes.length);
        out.close();
import static org.hamcrest.Matchers.nullValue;
        Map<String, String> map = randomMap(
    }
        }
    }
        out.writeGenericValue(BytesRefs.toBytesRef("bytesref"));
            out.writeBoolean(value);
        int expectedSize = PageCacheRecycler.BYTE_PAGE_SIZE;
        assertEqualityAfterSerialize(timeValue, 1 + out.bytes().length());
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
        BytesStreamOutput out = new BytesStreamOutput();
        StreamInput input = output.bytes().streamInput();
                output.writeInt(i);
import java.util.LinkedHashMap;
    }
            output.writeVInt(10);
        public boolean equals(Object o) {
        assertEquals(expectedSize, out.size());
        BytesStreamOutput simple = new BytesStreamOutput();
import java.util.function.Supplier;
        }
        BytesStreamOutput out = new BytesStreamOutput();
            BytesStreamOutput output = new BytesStreamOutput(0);
/**
                for (int i = 0; i < 10; i++) {
                Collections.singletonList(
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
        output.writeVInt(randomNumber);
        for (int i = 0; i < expectedSize; i++) {
        if (validEnum) {
                assertEquals(entry.getValue().get(i), loadedList.get(i));
        assertEquals(expectedSize, out.size());
import java.time.ZoneId;
        assertThat(in.readStringArray(), equalTo(new String[] { "a", "b", "cat" }));
            BytesStreamOutput output = new BytesStreamOutput();
        List<String> reverseMapKeys = reverseMap.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
                assertThat(throwable, sameInstance(rootEx));
        TestEnum value = randomFrom(TestEnum.values());
            output.writeMapWithConsistentOrder(map);
        out.writeTimeValue(value);
    public void testOneFullOneShortPage() throws Exception {
        int additionalLength = PageCacheRecycler.BYTE_PAGE_SIZE * 2;
        final Map<String, String> expected = new HashMap<>(randomIntBetween(0, 100));
        out.writeBytes(expectedData, initialOffset, additionalLength);
        int position = 0;
        assertThat(in.readString(), equalTo("hello"));
            this.value = value;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            output.writeVInt(Integer.MAX_VALUE);
 *
    public void testReadTooLargeArraySize() throws IOException {
        out.close();
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                randomAlphaOfLengthBetween(1, 10),
    }
                int[] ints = streamInput.readIntArray();
    public void testWriteMapWithConsistentOrder() throws IOException {
        assertEquals(0, input.available());
    }
            for (int i = 0; i < 10; i++) {
        BytesStreamOutput output = new BytesStreamOutput();
        out.writeVIntArray(vIntArray);
                list.add(randomAlphaOfLength(5));
            NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
        THREE
    public void testWriteRandomStrings() throws IOException {
            try (StreamInput streamInput = output.bytes().streamInput()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        expectThrows(IllegalArgumentException.class, () -> out.writeBytes(new byte[] {}, 0, 1));
        ZonedDateTime zdt = (ZonedDateTime) dt;
        AssertionError error = expectThrows(AssertionError.class, () -> testOut.writeException(rootEx));
    public void testTwoFullOneShortPage() throws Exception {
        float[] floatArray = { 1.1f, 2.2f, 3.3f };
        IntStream.range(0, size).forEach(i -> map.put(keyGenerator.get(), valueGenerator.get()));
            this.field2 = field2;
    }
    private abstract static class BaseNamedWriteable implements NamedWriteable {
        }
        }
            public boolean failOnTooManyNestedExceptions(Throwable throwable) {
        out.writeBytes(expectedData, 0, initialOffset);
            field1 = in.readString();
        assertEquals(initialOffset, out.size());
            }
            )
        BytesStreamOutput out = new BytesStreamOutput();
        final int size = randomIntBetween(0, 100);
        );
            output.writeVInt(Integer.MIN_VALUE);
    }
    }
 * The OpenSearch Contributors require contributions made to
            Map<String, Object> map = new LinkedHashMap<>();
        }
    public void testNamedWriteableNotSupportedWithoutWrapping() throws IOException {
import java.util.ArrayList;
            assertEquals(AssertionError.class, e.getClass());
import java.util.stream.Collectors;
        try (BytesStreamOutput output = new BytesStreamOutput(0)) {
import org.opensearch.core.common.io.stream.Writeable;
        StreamInput in = out.bytes().streamInput();
            out.writeByte(expectedData[i]);
        out.writeBytes(expectedData, 0, initialOffset);
            new HashMap<>(),
            output.writeVInt(100);
        }
        int randomNumber = randomInt();
        BytesStreamOutput out = new BytesStreamOutput();
        out.seek(position += PageCacheRecycler.BYTE_PAGE_SIZE * 2);
            out.writeNamedWriteableList(expected);
                    new NamedWriteableRegistry.Entry(
                assertEquals(0, in.available());
                output.writeInt(i);
        assertEquals(position, out.position());
    }
 * KIND, either express or implied.  See the License for the
        @Override
                assertEquals(namedWriteableIn, namedWriteableOut);
    /*
        assertEquals(0, out.size());
        BytesStreamOutput out = new BytesStreamOutput();
        int[] vIntArray = { 4, 5, 6 };
        }
/*
                expectThrows(IllegalStateException.class, () -> streamInput.readIntArray());
import java.util.HashMap;
        assertThat(in.readBoolean(), equalTo(false));
    public void testSkip() throws Exception {
                            @Override
 * compatible open source license.
        }
        }
        out.close();
    }
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
        while ((i & ~0x7F) != 0) {
        }
        out.writeLong(-3);
        @Override
        assertEquals(expectedSize, out.size());
        int expectedSize = PageCacheRecycler.BYTE_PAGE_SIZE;
    public void testSingleFullPage() throws Exception {
            expected.put(randomAlphaOfLength(2), list);
            output.writeString(largeString);
                    e.getMessage(),
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import static org.hamcrest.Matchers.instanceOf;
            assertThat(loadedList, hasSize(entry.getValue().size()));
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
        }));
        }
        final int value = randomInt();
            try (StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), namedWriteableRegistry)) {
        assertThat(inValue.duration(), equalTo(value.duration()));
        try (BytesStreamOutput output = new BytesStreamOutput(0)) {
            Exception e = expectThrows(UnsupportedOperationException.class, () -> in.readNamedWriteable(BaseNamedWriteable.class));
    public void testVInt() throws IOException {
        // ie. we cross over into a third
                    assertEquals(i, ints[i]);
/*
        assertThat(dt, instanceOf(ZonedDateTime.class));
                );
        final int size = randomIntBetween(0, 5);
            out.writeNamedWriteable(namedWriteableIn);
    public void testTimeValueSerialize() throws Exception {
        TestNamedWriteable(StreamInput in) throws IOException {
        out.close();
        assertEquals(0, in.available());
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
        assertEquals(expectedSize, out.size());
 * under the License.
        }
        StreamInput input = output.bytes().streamInput();
                    endsWith(" claims to have a different name [intentionally-broken] than it was read from [test-named-writeable].")
                int[] ints = streamInput.readIntArray();
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
        random().nextBytes(data);
 */
        };
                assertEquals(largeString, streamInput.readString());
import static org.hamcrest.Matchers.containsString;
 * Tests for {@link StreamOutput}.
            value = in.readBoolean();
            }
        }
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
    public void testSingleFullPageBulkWrite() throws Exception {
        assertEquals(value, input.readEnum(TestEnum.class));
import static org.hamcrest.Matchers.closeTo;
import org.apache.lucene.util.BytesRef;
        out.writeBytes(expectedData);
            // Read works for positive and negative numbers
        out.seek(position += PageCacheRecycler.BYTE_PAGE_SIZE);
    }
        BytesStreamOutput out = new BytesStreamOutput();
            }
    protected byte[] randomizedByteArrayWithSize(int size) {
import org.opensearch.common.lucene.BytesRefs;
                )
            public String toString() {
        out.writeGenericValue(ZonedDateTime.ofInstant(Instant.ofEpochMilli(123456), ZoneId.of("America/Los_Angeles")));
        // write byte-by-byte
        assertEquals(2, deseretLetter.length());
     */
        } else {
        // write byte-by-byte
    public void testReadMapByUsingWriteMapWithConsistentOrder() throws IOException {
        assertThat(in.readBytesReference(), equalTo(new BytesArray("test")));
        final long value = randomLong();
                            public String getWriteableName() {
        out.writeOptionalZoneId(ZoneId.systemDefault());
        final Map<String, String> loaded = in.readMap(StreamInput::readString, StreamInput::readString);
    }
            try (StreamInput in = new NamedWriteableAwareStreamInput(StreamInput.wrap(bytes), namedWriteableRegistry)) {
        // write single byte
                        (StreamInput in) -> new TestNamedWriteable(in) {
        assertEquals(position, out.position());
            assertEquals(point, geoPoint);
        TimeValue inValue = in.readTimeValue();
        Object dt = in.readGenericValue();
        int additionalLength = PageCacheRecycler.BYTE_PAGE_SIZE;
            output.writeVInt(10);
    public void testSingleShortPageBulkWrite() throws Exception {
        BytesStreamOutput out = new BytesStreamOutput();
            try (StreamInput streamInput = output.bytes().streamInput()) {
        out.writeOptionalVLong(null);
        }
            }
            assertEquals("Negative longs unsupported, use writeLong or writeZLong for negative numbers [" + value + "]", e.getMessage());
            assertEquals("Unknown TestEnum ordinal [" + randomNumber + "]", ex.getMessage());
        assertArrayEquals(newEx.getStackTrace(), rootEx.getStackTrace());
        }
        out.seek(position += PageCacheRecycler.BYTE_PAGE_SIZE + 10);
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
            TestNamedWriteable namedWriteableIn = new TestNamedWriteable(
            }
        for (int i = 0; i < expected.size(); ++i) {
 * this work for additional information regarding copyright
                assertEquals("array size must be positive but was: -2147483648", exception.getMessage());
import java.util.TreeMap;
        final int size = randomIntBetween(0, 5);
        assertEquals(simple.bytes().toBytesRef().toString(), output.bytes().toBytesRef().toString());
        assertThat(error.getCause(), equalTo(rootEx));
import org.opensearch.common.util.PageCacheRecycler;
            );
            for (int i = 0; i < 10; i++) {
    }
        public String getWriteableName() {
            reverseMapOutput.writeMapWithConsistentOrder(reverseMap);
                output.writeString(s);
        assertThat(in.readVInt(), equalTo(2));
        assertNotEquals(mapKeys, reverseMapKeys);
            @Override
        double[] doubleArray = { 1.1, 2.2, 3.3 };
        out.close();
    }
            }
        BytesStreamOutput prodOut = new BytesStreamOutput() {
    }
        }
            }
        assertThat(in.readGenericValue(), equalTo((Object) BytesRefs.toBytesRef("bytesref")));
    public void testSingleFullPageBulkWriteWithOffsetCrossover() throws Exception {
        assertEquals(0, out.bytes().length());
        try (BytesStreamOutput output = new BytesStreamOutput(0)) {
        assertEquals(expectedSize, out.size());
import org.apache.lucene.store.AlreadyClosedException;
        BytesStreamOutput out = new BytesStreamOutput();
                IOException e = expectThrows(IOException.class, () -> in.readNamedWriteable(BaseNamedWriteable.class));
                NegativeArraySizeException exception = expectThrows(NegativeArraySizeException.class, () -> streamInput.readIntArray());
        out.writeVInt(2);
        );
        BytesStreamOutput output = new BytesStreamOutput();
            new TreeMap<>(),
 * license agreements. See the NOTICE file distributed with
            assertThat(e.getMessage(), is("can't read named writeable from StreamInput"));
                output.writeInt(i);
        out.writeByte(expectedData[0]);
    public enum TestEnum {
        out.writeGenericValue(longArray);
        out.close();
        AlreadyClosedException ace = new AlreadyClosedException("closed", rootEx);
        }
                    assertEquals(i, ints[i]);
        }
            TestNamedWriteable namedWriteableIn = new TestNamedWriteable(
    public void testSimpleStreams() throws Exception {
                return "This object cannot be serialized by writeGeneric method";
        out.writeZLong(timeValue.duration());
        byte[] expectedData = randomizedByteArrayWithSize(initialOffset + additionalLength);
    }
        assertEquals(expectedSize, out.size());
 * Modifications Copyright OpenSearch Contributors. See
    public void testNamedWriteableReaderReturnsNull() throws IOException {
            try (StreamInput streamInput = output.bytes().streamInput()) {
        if (value < 0) {
                Collections.singletonList(
            simple.writeByte(((byte) ((i & 0x7f) | 0x80)));
        final BytesStreamOutput out = new BytesStreamOutput();
    }
import java.util.Map;
            () -> randomAlphaOfLength(5)
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            assertEquals(value, input.readVLong());
            IOException ex = expectThrows(IOException.class, () -> input.readEnum(TestEnum.class));
        assertThat(in.readInt(), equalTo(-1));
        assertThat(loaded.size(), equalTo(expected.size()));
        assumeTrue("requires a 64-bit JRE ... ?!", Constants.JRE_IS_64BIT);
import java.util.List;
            for (int i = 0; i < loadedList.size(); ++i) {
            expected.add(new TestNamedWriteable(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10)));
import java.util.concurrent.TimeUnit;
            return o instanceof TestWriteable && value == ((TestWriteable) o).value;
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
        assertThat(in.readOptionalDouble(), closeTo(1.2, 0.0001));
            for (int i = 0; i < 10; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
                    new NamedWriteableRegistry.Entry(BaseNamedWriteable.class, TestNamedWriteable.NAME, (StreamInput in) -> null)
            for (int i = 0; i < 10; i++) {
        out.writeBoolean(false);
        assertEquals("expands to 4 bytes", 4, new BytesRef(deseretLetter).length);
        assertEquals("BytesStreamOutput cannot hold more than 2GB of data", iae.getMessage());
            GeoPoint point = new GeoPoint(wrap);
        }
        int expectedSize = (PageCacheRecycler.BYTE_PAGE_SIZE * 2) + 1;
        out.writeBytes(expectedData, initialOffset, additionalLength);
    // create & fill byte[] with randomized data
        }
            assertThat(loaded.containsKey(entry.getKey()), equalTo(true));
        }
        assertEquals(position, BytesReference.toBytes(out.bytes()).length);
                assertThat(e.getMessage(), endsWith("] returned null which is not allowed and probably means it screwed up the stream."));
        assertEquals(0, input.available());
        }
        out.close();
package org.opensearch.common.io.stream;
                assertEquals(in.available(), bytes.length);
    }
import java.io.IOException;
            out.writeNamedWriteable(testNamedWriteable);
                assertEquals(in.available(), bytes.length);
            );
    }
            GeoPoint geoPoint = new GeoPoint(randomDouble(), randomDouble());
        assertThat(in.readVIntArray(), equalTo(vIntArray));
        public boolean equals(Object o) {
import static org.hamcrest.Matchers.equalTo;
            StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));
            out.writeString(field1);
        assertEquals(ZoneId.of("CET"), in.readZoneId());
        output.writeEnum(value);
        assertEquals(expectedSize, out.size());
    }
public class BytesStreamsTests extends OpenSearchTestCase {
            out.writeOptionalWriteable(new TestNamedWriteable(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10)));
        assertThat(inValue, equalTo(value));
        public int hashCode() {
            for (int i = 0; i < 10; i++) {
        out.writeOptionalDouble(null);
            TestNamedWriteable namedWriteableIn = new TestNamedWriteable(
            byte[] bytes = BytesReference.toBytes(out.bytes());
            Map<String, Object> streamInMap = in.readMap();
        ONE,
    public void testReadCorruptedArraySize() throws IOException {
        long[] longArray = { 1, 2, 3 };
        int expectedSize = 10;
        }
        final StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));
        assertEquals(expectedData.length, out.size());
        assertThat(in.readGenericValue(), equalTo((Object) longArray));
 * Unless required by applicable law or agreed to in writing,
            BytesStreamOutput output = new BytesStreamOutput();
import java.util.stream.IntStream;
        // bulk-write again with actual bytes
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        final Map<String, List<String>> loaded = in.readMapOfLists(StreamInput::readString, StreamInput::readString);
    public void testReadNegativeArraySize() throws IOException {
    }
            GeoPoint geoPoint = new GeoPoint(randomDouble(), randomDouble());
        String deseretLetter = "\uD801\uDC00";
        @Override
            TestNamedWriteable that = (TestNamedWriteable) o;
    }
        final List<TestWriteable> loaded = in.readList(TestWriteable::new);
        out.close();
        TestWriteable(boolean value) {
        {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }
        int i = value;
        // first create initial offset
        }
        // now write the rest - more than fits into the remaining first page
            }
            );
        out.close();
            out.writeByte(expectedData[i]);
     * tests the extreme case where characters use more than 2 bytes
            for (int i = 0; i < numStrings; i++) {
            assertEquals(TestEnum.values()[randomNumber], input.readEnum(TestEnum.class));
        final int iters = scaledRandomIntBetween(5, 20);
        assertThat(in.readOptionalVLong(), equalTo(5L));
                        }
            StreamInput input = output.bytes().streamInput();
                        BaseNamedWriteable.class,
        assertThat(error.getMessage(), containsString("too many nested exceptions"));
    }
        // write in bulk
            try (StreamInput streamInput = output.bytes().streamInput()) {
        // first bulk-write empty array: should not change anything
        BytesStreamOutput out = new BytesStreamOutput();
        TestNamedWriteable(String field1, String field2) {
    public void testSingleShortPage() throws Exception {
                )
        public void writeTo(StreamOutput out) throws IOException {
                assertThat(
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
                assertEquals(0, in.available());
            if (this == o) return true;
        out.writeString("hello");
            GeoPoint point = (GeoPoint) wrap.readGenericValue();
import org.apache.lucene.util.Constants;
        assertEquals(expectedSize, out.size());
            assertEquals(expected.get(i).value, loaded.get(i).value);
                for (int i = 0; i < 10; i++) {
        out.close();
        assertEquals(expectedData.length, out.size());
        out.writeList(expected);
        @Override
        assertThat(in.readByte(), equalTo((byte) 1));
        assertThat(in.readGenericValue(), equalTo((Object) intArray));
import org.opensearch.test.OpenSearchTestCase;
                new NamedWriteableRegistry.Entry(BaseNamedWriteable.class, TestNamedWriteable.NAME, TestNamedWriteable::new)
        expectedData = randomizedByteArrayWithSize(expectedSize);
            }
    private static class TestNamedWriteable extends BaseNamedWriteable {
 *
import static org.hamcrest.Matchers.hasSize;
        assertEquals(position + forward, out.position());
    public void testWriteCircularReferenceException() throws IOException {
    public void testWriteMap() throws IOException {
        }
        assertThat(expected, equalTo(loaded));
 */
        String largeString = IntStream.range(0, 2048).mapToObj(s -> deseretLetter).collect(Collectors.joining("")).trim();
        int initialOffset = 10;
            }
import java.time.Instant;
    }
            Collections.singletonList(
    public void testWriteWriteableList() throws IOException {
        assertNull(in.readOptionalDouble());
        }
            }
        BytesStreamOutput out = new BytesStreamOutput();
            assertEquals(point, geoPoint);
import java.util.Objects;
        assertThat(loaded.size(), equalTo(expected.size()));
    }
        public void writeTo(StreamOutput out) throws IOException {
            StreamInput in = StreamInput.wrap(BytesReference.toBytes(streamOut.bytes()));
/*
        out.writeMap(expected, StreamOutput::writeString, StreamOutput::writeString);
                randomAlphaOfLengthBetween(1, 10)
import org.opensearch.core.common.bytes.BytesReference;
        out.seek(position += 10);
                }
            out.writeString(field2);
        for (int i = 0; i < expectedSize; i++) {
                    new NamedWriteableRegistry.Entry(BaseNamedWriteable.class, TestNamedWriteable.NAME, TestNamedWriteable::new)
            randomIntBetween(2, 20),
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            int numStrings = randomIntBetween(100, 1000);
        out.writeBytes(expectedData);
        List<String> mapKeys = map.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
            StreamInput wrap = out.bytes().streamInput();
    }
            return Objects.equals(field1, that.field1) && Objects.equals(field2, that.field2);
import org.opensearch.core.common.bytes.BytesArray;
                output.writeInt(i);
        assertThat(in.readShort(), equalTo((short) -1));
        @Override
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
            try (StreamInput in = new NamedWriteableAwareStreamInput(StreamInput.wrap(bytes), namedWriteableRegistry)) {
        out.writeMapOfLists(expected, StreamOutput::writeString, StreamOutput::writeString);
        try (BytesStreamOutput output = new BytesStreamOutput()) {
                assertEquals(expected, in.readNamedWriteableList(BaseNamedWriteable.class));
    public void testWriteMapOfLists() throws IOException {
        assertEqualityAfterSerialize(TimeValue.timeValueNanos(1), 2);
            StreamInput wrap = out.bytes().streamInput();
        out.writeOptionalVLong(5L);
            TestNamedWriteable testNamedWriteable = new TestNamedWriteable("test1", "test2");
    }
            }
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
        assertEquals(position, out.position());
            randomIntBetween(2, 20),
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
                            }
                                return "intentionally-broken";
            return NAME;
        TWO,
    public void testWriteMapWithConsistentOrderWithLinkedHashMapShouldThrowAssertError() throws IOException {
import org.opensearch.core.common.io.stream.NamedWriteable;
        for (Map.Entry<String, List<String>> entry : expected.entrySet()) {
    }
    public void testSeek() throws Exception {
        Map<String, String> streamOutMap = randomMap(
 * ownership. Elasticsearch licenses this file to you under
            }
            }
        }
            this.field1 = field1;
        out.writeString("goodbye");
        }
import static org.hamcrest.Matchers.sameInstance;
            i >>>= 7;
        assertThat(in.readDouble(), closeTo(2.2, 0.0001));
        BytesStreamOutput out = new BytesStreamOutput();
 * not use this file except in compliance with the License.
        final Map<String, List<String>> expected = new HashMap<>(size);
        BytesStreamOutput testOut = new BytesStreamOutput();
            streamOut.writeMapWithConsistentOrder(streamOutMap);
                    assertEquals(i, ints[i]);
        final BytesStreamOutput out = new BytesStreamOutput();
 *
            return Objects.hash(field1, field2);
                assertEquals(in.available(), bytes.length);
                output.writeInt(i);
        for (int i = 0; i < size; ++i) {
        TestWriteable(StreamInput in) throws IOException {
        private boolean value;
 * specific language governing permissions and limitations
import org.opensearch.common.geo.GeoPoint;
        assertThat(in.readGenericValue(), equalTo((Object) floatArray));
        final StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));
        assertThat(in.readVLongArray(), equalTo(vLongArray));
        BytesStreamOutput out = new BytesStreamOutput();
        return map;
        out.writeVLong(4);
        out.close();
        rootEx.addSuppressed(ace); // circular reference
                randomAlphaOfLengthBetween(1, 10),
        assertThat(in.readLong(), equalTo(-3L));
        assertThat(newEx, instanceOf(IOException.class));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        for (int i = 0; i < size; i++) {
    }
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;
        }
    public void testOptionalWriteableReaderReturnsNull() throws IOException {
        @Override
 * You may obtain a copy of the License at
            expected.put(randomAlphaOfLength(2), randomAlphaOfLength(5));
        }
        BytesStreamOutput output = new BytesStreamOutput();
    public void testNamedWriteable() throws IOException {
        final List<TestWriteable> expected = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
        int position = 0;
        expectedSize = 10;
            expected.add(new TestWriteable(randomBoolean()));
            if (o == null || getClass() != o.getClass()) return false;
        out.writeBytes(expectedData);
    public void testIllegalBulkWrite() throws Exception {
        // that,
        out.writeShort((short) -1);
        in.close();
    }
        }
            return Objects.hash(value);
        // test empty stream to array
        reverseMap.putAll(map);
            byte[] bytes = BytesReference.toBytes(out.bytes());
        in.close();
        out.writeOptionalLong(11234234L);
import org.opensearch.core.common.io.stream.StreamInput;
        }
            List<String> strings = new ArrayList<>();
    private static <K, V> Map<K, V> randomMap(Map<K, V> map, int size, Supplier<K> keyGenerator, Supplier<V> valueGenerator) {
        // bulk-write with wrong args
            );
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> out.skip(Integer.MAX_VALUE - 50));
 * this file be licensed under the Apache-2.0 license or a
                for (int i = 0; i < 10; i++) {
        assertEqualityAfterSerialize(TimeValue.timeValueNanos(-1), 2);
    public void testSingleByte() throws Exception {
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
        output.writeVInt(value);
            Throwable e = expectThrows(AssertionError.class, () -> output.writeMapWithConsistentOrder(map));
        }
        assertEquals(0, in.available());
                AssertionError e = expectThrows(AssertionError.class, () -> in.readNamedWriteable(BaseNamedWriteable.class));
        out.writeFloat(1.1f);
    private static class TestWriteable implements Writeable {
        assertEquals(0, in.available());
                assertEquals("tried to read: 100 bytes but this stream is limited to: 82", eofException.getMessage());
        assertEqualityAfterSerialize(TimeValue.timeValueSeconds(30), 2);
    }
        }
        out.writeOptionalBytesReference(new BytesArray("test"));
                output.writeInt(i);
        BytesStreamOutput out = new BytesStreamOutput();
        out.close();
    }
            output.writeVInt(10);
        IOException rootEx = new IOException("disk broken");
 * the Apache License, Version 2.0 (the "License"); you may
                        TestNamedWriteable.NAME,
    public void testNamedWriteableList() throws IOException {
                BaseNamedWriteable namedWriteableOut = in.readNamedWriteable(BaseNamedWriteable.class);
        assertThat(in.readVLong(), equalTo(4L));
        for (int i = 0; i < expectedSize; i++) {
import java.io.EOFException;
            byte[] bytes = BytesReference.toBytes(out.bytes());
            List<String> loadedList = loaded.get(entry.getKey());
import java.time.ZonedDateTime;
        assertThat(inValue.timeUnit(), equalTo(value.timeUnit()));
    public void testWriteableReaderReturnsWrongName() throws IOException {
        out.writeGenericValue(floatArray);
    public void testEnum() throws IOException {
        assertThat(zdt.toInstant().toEpochMilli(), equalTo(123456L));
            }
        }
            @Override
    }
            assertEquals(output.bytes(), reverseMapOutput.bytes());
        int forward = 100;
            }
            out.writeByte(expectedData[i]);
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(value, input.readVInt());
        StreamInput input = output.bytes().streamInput();
                String s = randomRealisticUnicodeOfLengthBetween(0, 2048);
        final TimeValue timeValue = new TimeValue(randomIntBetween(0, 1024), randomFrom(TimeUnit.values()));
        StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));
    public void testReadWriteGeoPoint() throws IOException {
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
        in.close();
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(ex.getMessage(), containsString("can not write type"));
        private static final String NAME = "test-named-writeable";
        assertThat(in.readString(), equalTo("goodbye"));
            out.writeByte(expectedData[i]);
        assertThat(in.readOptionalVLong(), nullValue());
        prodOut.writeException(rootEx);
            NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> out.writeGenericValue(new Object() {
        long[] vLongArray = { 4, 5, 6 };
        // now write the rest - more than fits into the remaining page + a full page after
                randomAlphaOfLengthBetween(1, 10),
        out.writeDouble(2.2);
        out.writeByte((byte) 1);
    }
        public int hashCode() {
        try (BytesStreamOutput output = new BytesStreamOutput(); BytesStreamOutput reverseMapOutput = new BytesStreamOutput()) {
        assertEquals(ZoneId.systemDefault(), in.readOptionalZoneId());
    public void testEmpty() throws Exception {
        out.writeBytesReference(new BytesArray("test"));
    public void testWriteLargeSurrogateOnlyString() throws IOException {
    }
        out.writeInt(-1);
        out.writeGenericValue(doubleArray);
import java.util.Collections;
        int size = between(0, 100);
        Exception newEx = in.readException();
        int expectedSize = PageCacheRecycler.BYTE_PAGE_SIZE + 10;
        }
                    assertEquals(strings.get(i), s);
        try (BytesStreamOutput output = new BytesStreamOutput(0)) {
        private final String field2;
        assertThat(in.readGenericValue(), equalTo((Object) doubleArray));
            field2 = in.readString();
            out.writeGenericValue(geoPoint);
                }
        }
    }
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> out.seek(Integer.MAX_VALUE + 1L));
            NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
            out.writeNamedWriteable(namedWriteableIn);
        int[] intArray = { 1, 2, 3 };
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
            }
            out.writeNamedWriteable(namedWriteableIn);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        Map<String, Object> reverseMap = new TreeMap<>(Collections.reverseOrder());
        out.writeZoneId(ZoneId.of("CET"));
                return true;
        final StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));
            assertEquals(streamOutMap, streamInMap);
        assertThat(in.readOptionalLong(), equalTo(11234234L));
        }
            }
            }
        private final String field1;
        byte[] expectedData = randomizedByteArrayWithSize(initialOffset + additionalLength);
    }
                strings.add(s);
        // write byte-by-byte
        out.skip(forward);
            int listSize = randomIntBetween(0, 5);
 * software distributed under the License is distributed on an
            Exception e = expectThrows(IllegalStateException.class, () -> output.writeVLong(value));
        out.writeVLongArray(vLongArray);
        byte[] data = new byte[size];
                randomAlphaOfLengthBetween(1, 10)
 */
        out.close();
            output.writeVLongNoCheck(value); // Use NoCheck variant so we can write negative numbers
    }
        out.writeGenericValue(intArray);
            assertThat(e.getMessage(), endsWith("] returned null which is not allowed and probably means it screwed up the stream."));
        for (int i = 0; i < size; ++i) {
            geoPoint.writeTo(out);
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
            StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));
            () -> randomAlphaOfLength(5),
                Collections.singletonList(
    public void testInvalidEnum() throws IOException {
    public void testVLong() throws IOException {
        int expectedSize = 1;
                for (int i = 0; i < numStrings; i++) {
}
        out.writeOptionalDouble(1.2);
        assertThat(in.readOptionalBytesReference(), equalTo(new BytesArray("test")));
        }
    }
        List<BaseNamedWriteable> expected = new ArrayList<>(size);
    }
        assertEquals(expectedSize, out.size());
            for (int j = 0; j < listSize; ++j) {
                }
            );
                )
        assertEqualityAfterSerialize(new TimeValue(100, TimeUnit.DAYS), 3);
    }
        out.writeStringArray(new String[] { "a", "b", "cat" });
            IOException e = expectThrows(IOException.class, () -> in.readOptionalWriteable((StreamInput ignored) -> null));
        final byte[] bytes = BytesReference.toBytes(out.bytes());
        boolean validEnum = randomNumber >= 0 && randomNumber < TestEnum.values().length;
                randomAlphaOfLengthBetween(1, 10)
        simple.writeByte((byte) i);
                int[] ints = streamInput.readIntArray();
 * Licensed to Elasticsearch under one or more contributor
    }
        assertEquals("BytesStreamOutput cannot hold more than 2GB of data", iae.getMessage());
import org.opensearch.common.unit.TimeValue;
                EOFException eofException = expectThrows(EOFException.class, () -> streamInput.readIntArray());
            // Write doesn't work for negative numbers
    private static void assertEqualityAfterSerialize(TimeValue value, int expectedSize) throws IOException {
        // write byte-by-byte
        return data;
        assertEquals(0, out.size());
        for (int iter = 0; iter < iters; iter++) {
        assertThat(loaded, hasSize(expected.size()));
    }
        int expectedSize = 0;
        int initialOffset = 10;
    }
        out.close();
            () -> randomAlphaOfLength(5)
        out.close();
        assertThat((double) in.readFloat(), closeTo(1.1, 0.0001));
        out.close();
        assertEquals(initialOffset, out.size());
            () -> randomAlphaOfLength(5),
        StreamInput in = prodOut.bytes().streamInput();
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
        );
        try (BytesStreamOutput streamOut = new BytesStreamOutput()) {
            try (StreamInput in = new NamedWriteableAwareStreamInput(StreamInput.wrap(bytes), namedWriteableRegistry)) {
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(newEx.getMessage(), equalTo("disk broken"));
 * GitHub history for details.
        final BytesStreamOutput out = new BytesStreamOutput();
            List<String> list = new ArrayList<>(listSize);
                    String s = streamInput.readString();
            }
            );
            try (StreamInput streamInput = output.bytes().streamInput()) {
 */
        assertThat(zdt.getZone(), equalTo(ZoneId.of("America/Los_Angeles")));
            for (int i = 0; i < 10; i++) {
        for (int i = 0; i < expectedSize; i++) {
