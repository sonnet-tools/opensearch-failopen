        out.seek(position += 10);
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeBytesReference(new BytesArray("test"));
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
        in.close();
    }
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
            }
            out.writeOptionalWriteable(new TestNamedWriteable(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10)));
        }  
                output.writeString(s);
        final int size = randomIntBetween(0, 100);
        }  
        assertEquals(0, input.available());
            StreamInput wrap = out.bytes().streamInput();
        IOException rootEx = new IOException("disk broken");  
            NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
    public void testWriteMapOfLists() throws IOException {
                randomAlphaOfLengthBetween(1, 10)  
import java.util.stream.Collectors;  
            out.writeNamedWriteable(namedWriteableIn);
        int expectedSize = 0;
        assertEquals(position + forward, out.position());
            );
    // create & fill byte[] with randomized data
            streamOut.writeMapWithConsistentOrder(streamOutMap);  
 * ownership. Elasticsearch licenses this file to you under  
                Collections.singletonList(  
        assertThat(loaded.size(), equalTo(expected.size()));  
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));  
    public void testVLong() throws IOException {
        assertEquals("BytesStreamOutput cannot hold more than 2GB of data", iae.getMessage());
                assertThat(
                int[] ints = streamInput.readIntArray();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        BytesStreamOutput out = new BytesStreamOutput();
        }));  
import java.io.IOException;
        assertThat(in.readGenericValue(), equalTo((Object) floatArray));
        assertEquals(expectedSize, out.size());  
            assertEquals(point, geoPoint);
        List<BaseNamedWriteable> expected = new ArrayList<>(size);  
        final BytesStreamOutput out = new BytesStreamOutput();
        boolean validEnum = randomNumber >= 0 && randomNumber < TestEnum.values().length;
import java.util.concurrent.TimeUnit;
            for (int i = 0; i < loadedList.size(); ++i) {
        final byte[] bytes = BytesReference.toBytes(out.bytes());  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        final long value = randomLong();  
            value = in.readBoolean();  
            out.writeGenericValue(geoPoint);  
            out.writeByte(expectedData[i]);  
            expected.add(new TestWriteable(randomBoolean()));
            for (int i = 0; i < numStrings; i++) {
        out.writeGenericValue(floatArray);
        assertEquals(0, out.size());
        BytesStreamOutput output = new BytesStreamOutput();  
        while ((i & ~0x7F) != 0) {  
                }  
        // bulk-write with wrong args
        assertEquals(initialOffset, out.size());
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);  
        @Override
import static org.hamcrest.Matchers.closeTo;  
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
    }
    public void testNamedWriteableReaderReturnsNull() throws IOException {  
        int expectedSize = PageCacheRecycler.BYTE_PAGE_SIZE;
            )  
        final BytesStreamOutput out = new BytesStreamOutput();
        reverseMap.putAll(map);
            assertThat(loadedList, hasSize(entry.getValue().size()));  
            );  
            output.writeMapWithConsistentOrder(map);  
            output.writeVInt(100);
                randomAlphaOfLengthBetween(1, 10),
    }
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
        out.writeBytes(expectedData, initialOffset, additionalLength);
import static org.hamcrest.Matchers.containsString;
            assertEquals(streamOutMap, streamInMap);  
        private static final String NAME = "test-named-writeable";
        assertThat(newEx, instanceOf(IOException.class));
                output.writeInt(i);
        @Override
        int randomNumber = randomInt();  
/*  
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
            }
import static org.hamcrest.Matchers.is;  
        int forward = 100;  
            try (StreamInput in = new NamedWriteableAwareStreamInput(StreamInput.wrap(bytes), namedWriteableRegistry)) {
            for (int j = 0; j < listSize; ++j) {  
    public void testReadNegativeArraySize() throws IOException {
        // test empty stream to array
        out.writeGenericValue(longArray);  
import java.util.function.Supplier;
            try (StreamInput streamInput = output.bytes().streamInput()) {
        BytesStreamOutput simple = new BytesStreamOutput();
            assertThat(e.getMessage(), endsWith("] returned null which is not allowed and probably means it screwed up the stream."));
    public void testSingleFullPageBulkWrite() throws Exception {  
    }  
    }  
        out.writeOptionalBytesReference(new BytesArray("test"));  
        Map<String, Object> reverseMap = new TreeMap<>(Collections.reverseOrder());  
    }
    public void testWriteWriteableList() throws IOException {  
    }
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));  
            assertThat(e.getMessage(), is("can't read named writeable from StreamInput"));
        Map<String, String> streamOutMap = randomMap(
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat((double) in.readFloat(), closeTo(1.1, 0.0001));
    public void testWriteCircularReferenceException() throws IOException {
            }  
        assertThat(in.readDouble(), closeTo(2.2, 0.0001));
        }
                assertEquals("array size must be positive but was: -2147483648", exception.getMessage());  
    }
                            public String getWriteableName() {  
        StreamInput in = out.bytes().streamInput();  
        try (BytesStreamOutput output = new BytesStreamOutput(0)) {
            if (o == null || getClass() != o.getClass()) return false;  
            }
        BytesStreamOutput out = new BytesStreamOutput();
            }
        }
        assertThat(in.readLong(), equalTo(-3L));
            GeoPoint geoPoint = new GeoPoint(randomDouble(), randomDouble());
        assertThat(ex.getMessage(), containsString("can not write type"));
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> out.seek(Integer.MAX_VALUE + 1L));  
        assertEquals(expectedSize, out.size());
import java.time.Instant;
                        BaseNamedWriteable.class,
import org.opensearch.core.common.bytes.BytesReference;  
                    assertEquals(i, ints[i]);
        assertThat(in.readGenericValue(), equalTo((Object) intArray));  
 * You may obtain a copy of the License at  
 *
        List<String> reverseMapKeys = reverseMap.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
        TestEnum value = randomFrom(TestEnum.values());
    }
    }
import java.util.Objects;
        assertEquals(expectedSize, out.size());
        final int size = randomIntBetween(0, 5);
        assertThat(in.readOptionalVLong(), nullValue());  
        out.close();
        assertThat(in.readBoolean(), equalTo(false));  
        int initialOffset = 10;
    }  
                    String s = streamInput.readString();
            byte[] bytes = BytesReference.toBytes(out.bytes());  
        }
import java.util.Map;
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
        }
        assumeTrue("requires a 64-bit JRE ... ?!", Constants.JRE_IS_64BIT);
        ZonedDateTime zdt = (ZonedDateTime) dt;  
        out.close();
            assertEquals(output.bytes(), reverseMapOutput.bytes());  
        assertThat(newEx.getMessage(), equalTo("disk broken"));
package org.opensearch.common.io.stream;
        BytesStreamOutput out = new BytesStreamOutput();  
        BytesStreamOutput out = new BytesStreamOutput();  
    }  
            }
            // Read works for positive and negative numbers
            Throwable e = expectThrows(AssertionError.class, () -> output.writeMapWithConsistentOrder(map));
    }
            IOException ex = expectThrows(IOException.class, () -> input.readEnum(TestEnum.class));
        try (BytesStreamOutput output = new BytesStreamOutput(0)) {
        );
        assertThat(in.readOptionalLong(), equalTo(11234234L));
        random().nextBytes(data);
            try (StreamInput streamInput = output.bytes().streamInput()) {  
        }  
        for (int iter = 0; iter < iters; iter++) {
        assertEquals(position, out.position());  
            }
        out.close();
        BytesStreamOutput out = new BytesStreamOutput();
            output.writeVInt(10);
        }  
        int i = value;
                BaseNamedWriteable namedWriteableOut = in.readNamedWriteable(BaseNamedWriteable.class);
import static org.hamcrest.Matchers.instanceOf;
        final int value = randomInt();  
            List<String> list = new ArrayList<>(listSize);
        );
        if (value < 0) {
            assertThat(loaded.containsKey(entry.getKey()), equalTo(true));
        private final String field2;
    }  
            output.writeString(largeString);
            TestNamedWriteable that = (TestNamedWriteable) o;
    public void testSingleByte() throws Exception {  
            new HashMap<>(),  
    public void testEmpty() throws Exception {
                NegativeArraySizeException exception = expectThrows(NegativeArraySizeException.class, () -> streamInput.readIntArray());
        assertThat(in.readGenericValue(), equalTo((Object) longArray));
                    new NamedWriteableRegistry.Entry(BaseNamedWriteable.class, TestNamedWriteable.NAME, TestNamedWriteable::new)
        // that,
            if (this == o) return true;
        }
            try (StreamInput streamInput = output.bytes().streamInput()) {
        assertThat(error.getMessage(), containsString("too many nested exceptions"));  
        }
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));  
}
            expected.put(randomAlphaOfLength(2), list);
        }
    public void testSingleShortPage() throws Exception {  
            assertEquals(value, input.readVLong());  
                output.writeInt(i);  
        if (validEnum) {
        out.writeTimeValue(value);  
    private static class TestWriteable implements Writeable {  
        Object dt = in.readGenericValue();
        out.writeByte((byte) 1);
            for (int i = 0; i < 10; i++) {  
            BytesStreamOutput output = new BytesStreamOutput();
        StreamInput in = prodOut.bytes().streamInput();
        assertThat(in.readVLongArray(), equalTo(vLongArray));  
        assertThat(in.readShort(), equalTo((short) -1));
     * tests the extreme case where characters use more than 2 bytes  
 *
            // Write doesn't work for negative numbers  
        assertEquals(ZoneId.of("CET"), in.readZoneId());
        final StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));  
            }
    public void testSingleFullPage() throws Exception {
 * compatible open source license.
public class BytesStreamsTests extends OpenSearchTestCase {
    public void testReadTooLargeArraySize() throws IOException {  
                assertThat(e.getMessage(), endsWith("] returned null which is not allowed and probably means it screwed up the stream."));
                }  
        }  
        out.writeBytes(expectedData, 0, initialOffset);
        return data;  
import java.time.ZoneId;  
        assertThat(in.readVInt(), equalTo(2));
    }
                )
            () -> randomAlphaOfLength(5)  
            expected.put(randomAlphaOfLength(2), randomAlphaOfLength(5));
        // write byte-by-byte
        public String getWriteableName() {
        int position = 0;
    public void testWriteMap() throws IOException {  
        out.writeBytes(expectedData);
import org.opensearch.common.lucene.BytesRefs;
            BytesStreamOutput output = new BytesStreamOutput();  
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);  
import org.opensearch.core.common.io.stream.Writeable;  
    }  
    public void testSimpleStreams() throws Exception {
        assertEquals(expectedSize, out.size());  
        AssertionError error = expectThrows(AssertionError.class, () -> testOut.writeException(rootEx));
 * Modifications Copyright OpenSearch Contributors. See
        out.skip(forward);
                output.writeInt(i);  
                IOException e = expectThrows(IOException.class, () -> in.readNamedWriteable(BaseNamedWriteable.class));  
        }  
        }
    }
        assertEquals(value, input.readVInt());
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.sameInstance;
            }
        output.writeEnum(value);
        output.writeVInt(value);
        out.writeFloat(1.1f);
        }  
import java.util.ArrayList;
        assertThat(in.readGenericValue(), equalTo((Object) doubleArray));
            }
        }
        final StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));
        out.writeString("goodbye");
        // write byte-by-byte
    public void testNamedWriteableList() throws IOException {
        private boolean value;
        StreamInput input = output.bytes().streamInput();
        assertEquals(in.available(), bytes.length);
            randomIntBetween(2, 20),
            return NAME;  
        assertThat(in.readOptionalDouble(), closeTo(1.2, 0.0001));
            }
        assertEqualityAfterSerialize(timeValue, 1 + out.bytes().length());
        expectedData = randomizedByteArrayWithSize(expectedSize);
        out.writeShort((short) -1);  
            return Objects.equals(field1, that.field1) && Objects.equals(field2, that.field2);
        out.writeList(expected);  
        }
        assertThat(in.readByte(), equalTo((byte) 1));
        @Override  
        assertEquals(position, out.position());  
import org.apache.lucene.store.AlreadyClosedException;
        out.writeByte(expectedData[0]);
        TimeValue inValue = in.readTimeValue();
                list.add(randomAlphaOfLength(5));
        IntStream.range(0, size).forEach(i -> map.put(keyGenerator.get(), valueGenerator.get()));
        out.writeZLong(timeValue.duration());
            Map<String, Object> streamInMap = in.readMap();
                assertEquals(in.available(), bytes.length);  
        BytesStreamOutput out = new BytesStreamOutput();
                    assertEquals(strings.get(i), s);
        assertThat(expected, equalTo(loaded));
                output.writeInt(i);
    }
            try (StreamInput in = new NamedWriteableAwareStreamInput(StreamInput.wrap(bytes), namedWriteableRegistry)) {
        int[] vIntArray = { 4, 5, 6 };  
        BytesStreamOutput output = new BytesStreamOutput();
import org.opensearch.common.geo.GeoPoint;
            GeoPoint point = new GeoPoint(wrap);
        out.writeVLongArray(vLongArray);
 * the Apache License, Version 2.0 (the "License"); you may
        TestNamedWriteable(StreamInput in) throws IOException {
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> out.writeGenericValue(new Object() {
        assertThat(dt, instanceOf(ZonedDateTime.class));
        int initialOffset = 10;  
        }
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        simple.writeByte((byte) i);
        final TimeValue timeValue = new TimeValue(randomIntBetween(0, 1024), randomFrom(TimeUnit.values()));
    public void testTwoFullOneShortPage() throws Exception {  
            int numStrings = randomIntBetween(100, 1000);  
            @Override
                    assertEquals(i, ints[i]);
        assertEquals(expectedSize, out.size());  
        out.writeInt(-1);
        // first bulk-write empty array: should not change anything
        BytesStreamOutput out = new BytesStreamOutput();
            }  
        }
        assertEqualityAfterSerialize(new TimeValue(100, TimeUnit.DAYS), 3);  
                }
        out.writeOptionalVLong(null);
    public void testNamedWriteable() throws IOException {  
            out.writeNamedWriteable(testNamedWriteable);
        }
        }
    public void testOneFullOneShortPage() throws Exception {
import org.opensearch.core.common.io.stream.StreamOutput;
 *  
        double[] doubleArray = { 1.1, 2.2, 3.3 };
            public String toString() {  
                int[] ints = streamInput.readIntArray();  
            new TreeMap<>(),  
        try (BytesStreamOutput output = new BytesStreamOutput()) {
import org.opensearch.test.OpenSearchTestCase;
            () -> randomAlphaOfLength(5),
        out.writeZoneId(ZoneId.of("CET"));  
 * specific language governing permissions and limitations
    public void testVInt() throws IOException {
    }
        prodOut.writeException(rootEx);
                randomAlphaOfLengthBetween(1, 10),
            }
    }
        assertEquals(initialOffset, out.size());  
            StreamInput input = output.bytes().streamInput();
 */
    public void testWriteLargeSurrogateOnlyString() throws IOException {
            );
                int[] ints = streamInput.readIntArray();  
            assertEquals("Negative longs unsupported, use writeLong or writeZLong for negative numbers [" + value + "]", e.getMessage());  
    public void testReadWriteGeoPoint() throws IOException {  
                        TestNamedWriteable.NAME,  
        for (int i = 0; i < size; i++) {
            expected.add(new TestNamedWriteable(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10)));
                )
        int expectedSize = PageCacheRecycler.BYTE_PAGE_SIZE;  
    public void testSingleShortPageBulkWrite() throws Exception {
            () -> randomAlphaOfLength(5),
    }
 * Unless required by applicable law or agreed to in writing,
                for (int i = 0; i < numStrings; i++) {  
            List<String> loadedList = loaded.get(entry.getKey());
        }  
import java.util.stream.IntStream;
            NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
            );  
 */  
        @Override  
            field2 = in.readString();
            StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));  
        int size = between(0, 100);
            output.writeVInt(10);  
        StreamInput input = output.bytes().streamInput();  
        out.writeGenericValue(ZonedDateTime.ofInstant(Instant.ofEpochMilli(123456), ZoneId.of("America/Los_Angeles")));
        out.close();
        String largeString = IntStream.range(0, 2048).mapToObj(s -> deseretLetter).collect(Collectors.joining("")).trim();
                assertEquals(expected, in.readNamedWriteableList(BaseNamedWriteable.class));
            return Objects.hash(value);  
 * license agreements. See the NOTICE file distributed with
            output.writeVInt(Integer.MIN_VALUE);
    }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        }
        final Map<String, List<String>> expected = new HashMap<>(size);  
        public boolean equals(Object o) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import static org.hamcrest.Matchers.equalTo;  
        }  
        out.writeGenericValue(doubleArray);  
        }  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }
        assertThat(loaded, hasSize(expected.size()));  
        assertNotEquals(mapKeys, reverseMapKeys);  
        assertEqualityAfterSerialize(TimeValue.timeValueSeconds(30), 2);  
            StreamInput wrap = out.bytes().streamInput();  
        out.writeOptionalDouble(1.2);
        StreamInput input = output.bytes().streamInput();
        out.writeOptionalZoneId(ZoneId.systemDefault());
                    endsWith(" claims to have a different name [intentionally-broken] than it was read from [test-named-writeable].")  
        assertEqualityAfterSerialize(TimeValue.timeValueNanos(1), 2);
        assertThat(in.readBytesReference(), equalTo(new BytesArray("test")));
                }  
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
        }  
        final BytesStreamOutput out = new BytesStreamOutput();
    }  
/*
    }
        ONE,
            assertEquals(point, geoPoint);  
import java.util.TreeMap;  
        try (BytesStreamOutput output = new BytesStreamOutput(0)) {
        out.writeGenericValue(intArray);
        byte[] data = new byte[size];
 * SPDX-License-Identifier: Apache-2.0
        int additionalLength = PageCacheRecycler.BYTE_PAGE_SIZE * 2;
            StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));  
        out.close();  
        try (BytesStreamOutput streamOut = new BytesStreamOutput()) {
        assertThat(in.readStringArray(), equalTo(new String[] { "a", "b", "cat" }));  
        final Map<String, String> loaded = in.readMap(StreamInput::readString, StreamInput::readString);
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(in.readString(), equalTo("goodbye"));
            int listSize = randomIntBetween(0, 5);  
        AlreadyClosedException ace = new AlreadyClosedException("closed", rootEx);
        out.writeGenericValue(BytesRefs.toBytesRef("bytesref"));  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }
        BytesStreamOutput out = new BytesStreamOutput();  
        out.close();
        assertEquals("BytesStreamOutput cannot hold more than 2GB of data", iae.getMessage());
        out.writeLong(-3);  
            TestNamedWriteable namedWriteableIn = new TestNamedWriteable(
        out.writeVIntArray(vIntArray);
        private final String field1;  
                    )
            () -> randomAlphaOfLength(5)  
        assertThat(in.readInt(), equalTo(-1));  
    public void testSeek() throws Exception {
        @Override  
        // write byte-by-byte  
    public void testTimeValueSerialize() throws Exception {
        assertThat(in.readVLong(), equalTo(4L));  
            simple.writeByte(((byte) ((i & 0x7f) | 0x80)));
        out.close();  
                assertEquals(0, in.available());  
        int additionalLength = PageCacheRecycler.BYTE_PAGE_SIZE;
            for (int i = 0; i < 10; i++) {  
import java.io.EOFException;  
    }
import static org.hamcrest.Matchers.endsWith;
                assertEquals(namedWriteableIn, namedWriteableOut);
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            try (StreamInput streamInput = output.bytes().streamInput()) {  
            out.writeByte(expectedData[i]);
            StreamInput in = StreamInput.wrap(BytesReference.toBytes(streamOut.bytes()));
            );  
                        }  
 * this file be licensed under the Apache-2.0 license or a
        assertEqualityAfterSerialize(TimeValue.timeValueNanos(-1), 2);
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));
 * KIND, either express or implied.  See the License for the
        assertThat(zdt.getZone(), equalTo(ZoneId.of("America/Los_Angeles")));
import static org.hamcrest.Matchers.nullValue;
            try (StreamInput streamInput = output.bytes().streamInput()) {
        BytesStreamOutput testOut = new BytesStreamOutput();
        for (int i = 0; i < size; ++i) {  
        out.writeVLong(4);
        final int iters = scaledRandomIntBetween(5, 20);  
        out.writeBytes(expectedData, 0, initialOffset);
    public void testInvalidEnum() throws IOException {
        assertThat(in.readOptionalBytesReference(), equalTo(new BytesArray("test")));
            byte[] bytes = BytesReference.toBytes(out.bytes());  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        out.writeMap(expected, StreamOutput::writeString, StreamOutput::writeString);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertEquals(0, out.size());  
        byte[] expectedData = randomizedByteArrayWithSize(initialOffset + additionalLength);
                EOFException eofException = expectThrows(EOFException.class, () -> streamInput.readIntArray());
        out.close();  
        }  
                    e.getMessage(),
        out.writeBytes(expectedData, initialOffset, additionalLength);  
                Collections.singletonList(  
            }  
    }  
        out.seek(position += PageCacheRecycler.BYTE_PAGE_SIZE + 10);
            GeoPoint geoPoint = new GeoPoint(randomDouble(), randomDouble());
        in.close();  
                Collections.singletonList(  
        int expectedSize = PageCacheRecycler.BYTE_PAGE_SIZE + 10;
            for (int i = 0; i < 10; i++) {
            output.writeVInt(Integer.MAX_VALUE);
    }
        int expectedSize = 10;  
                assertEquals(in.available(), bytes.length);
        expectedSize = 10;  
        }  
import java.util.HashMap;
    public void testReadCorruptedArraySize() throws IOException {  
            out.writeString(field2);  
 * under the License.  
            out.writeBoolean(value);
    public void testReadMapByUsingWriteMapWithConsistentOrder() throws IOException {
    private abstract static class BaseNamedWriteable implements NamedWriteable {
        assertThat(in.readGenericValue(), equalTo((Object) BytesRefs.toBytesRef("bytesref")));
            assertEquals(expected.get(i).value, loaded.get(i).value);  
        // now write the rest - more than fits into the remaining first page
        TestWriteable(boolean value) {
        }  
            List<String> strings = new ArrayList<>();
        out.close();
                randomAlphaOfLengthBetween(1, 10)  
        }
    public void testIllegalBulkWrite() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;  
    }
    }
        float[] floatArray = { 1.1f, 2.2f, 3.3f };  
        out.close();  
        public int hashCode() {
        out.writeVInt(2);
                for (int i = 0; i < 10; i++) {
        assertEquals(0, in.available());  
            geoPoint.writeTo(out);
            }
        assertEquals(expectedSize, out.size());
            Map<String, Object> map = new LinkedHashMap<>();  
        out.writeOptionalDouble(null);
            reverseMapOutput.writeMapWithConsistentOrder(reverseMap);
        for (int i = 0; i < expectedSize; i++) {
        assertThat(inValue.timeUnit(), equalTo(value.timeUnit()));
        out.writeBytes(expectedData);
        {
            }
                    new NamedWriteableRegistry.Entry(
import org.opensearch.core.common.io.stream.StreamInput;
    }
            for (int i = 0; i < 10; i++) {
            this.value = value;
        BytesStreamOutput prodOut = new BytesStreamOutput() {  
            public boolean failOnTooManyNestedExceptions(Throwable throwable) {
 * not use this file except in compliance with the License.
        }  
        }
import org.apache.lucene.util.BytesRef;
        assertEquals(0, input.available());
        assertEquals(ZoneId.systemDefault(), in.readOptionalZoneId());  
        TestNamedWriteable(String field1, String field2) {  
        BytesStreamOutput out = new BytesStreamOutput();
        BytesStreamOutput out = new BytesStreamOutput();
    }
    public void testWriteMapWithConsistentOrder() throws IOException {
    public void testWriteRandomStrings() throws IOException {
            byte[] bytes = BytesReference.toBytes(out.bytes());  
        THREE
        assertEquals(value, input.readEnum(TestEnum.class));  
        byte[] expectedData = randomizedByteArrayWithSize(initialOffset + additionalLength);  
            );
                output.writeInt(i);
        }
        for (int i = 0; i < expectedSize; i++) {
        int[] intArray = { 1, 2, 3 };
        BytesStreamOutput out = new BytesStreamOutput();  
        out.writeBytes(expectedData);
import org.opensearch.common.util.PageCacheRecycler;
                assertThat(throwable, sameInstance(rootEx));  
        int expectedSize = 1;
        BytesStreamOutput out = new BytesStreamOutput();
import java.util.LinkedHashMap;
    }  
        assertEquals(position, out.position());
            out.writeNamedWriteable(namedWriteableIn);
        out.seek(position += PageCacheRecycler.BYTE_PAGE_SIZE * 2);
        out.seek(position += PageCacheRecycler.BYTE_PAGE_SIZE);  
        public boolean equals(Object o) {
            out.writeByte(expectedData[i]);
            assertEquals("Unknown TestEnum ordinal [" + randomNumber + "]", ex.getMessage());
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> out.skip(Integer.MAX_VALUE - 50));
        assertEquals(0, in.available());  
    }
        int expectedSize = (PageCacheRecycler.BYTE_PAGE_SIZE * 2) + 1;  
 * Tests for {@link StreamOutput}.
        for (int i = 0; i < expectedSize; i++) {
        final int size = randomIntBetween(0, 5);
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(  
        TWO,  
                            @Override
                for (int i = 0; i < 10; i++) {
    }  
     */
        for (int i = 0; i < expected.size(); ++i) {
    }
        assertEquals(expectedData.length, out.size());
                );
        for (int i = 0; i < size; ++i) {
        assertNull(in.readOptionalDouble());  
                AssertionError e = expectThrows(AssertionError.class, () -> in.readNamedWriteable(BaseNamedWriteable.class));  
        }  
    }  
        TestWriteable(StreamInput in) throws IOException {
import org.opensearch.core.common.bytes.BytesArray;
        public void writeTo(StreamOutput out) throws IOException {
        assertArrayEquals(expectedData, BytesReference.toBytes(out.bytes()));  
        BytesStreamOutput out = new BytesStreamOutput();  
                String s = randomRealisticUnicodeOfLengthBetween(0, 2048);  
        assertArrayEquals(newEx.getStackTrace(), rootEx.getStackTrace());  
 * software distributed under the License is distributed on an
        }  
                assertEquals(0, in.available());  
            assertEquals(TestEnum.values()[randomNumber], input.readEnum(TestEnum.class));
        out.writeDouble(2.2);  
            @Override
    public void testSingleFullPageBulkWriteWithOffset() throws Exception {  
            this.field1 = field1;
        out.writeString("hello");
        assertEquals(2, deseretLetter.length());
            return o instanceof TestWriteable && value == ((TestWriteable) o).value;
    protected byte[] randomizedByteArrayWithSize(int size) {  
    }
        assertEquals(expectedData.length, out.size());
        BytesStreamOutput output = new BytesStreamOutput();
                randomAlphaOfLengthBetween(1, 10),
        out.close();  
        out.writeMapOfLists(expected, StreamOutput::writeString, StreamOutput::writeString);
        assertThat(inValue.duration(), equalTo(value.duration()));
        out.close();
import org.opensearch.common.unit.TimeValue;  
 */  
    public void testWriteableReaderReturnsWrongName() throws IOException {  
        try (BytesStreamOutput output = new BytesStreamOutput(0)) {
                )
 * this work for additional information regarding copyright
                assertEquals(in.available(), bytes.length);
                assertEquals(largeString, streamInput.readString());
                                return "intentionally-broken";
            GeoPoint point = (GeoPoint) wrap.readGenericValue();
        final List<TestWriteable> expected = new ArrayList<>(size);
        expectThrows(IllegalArgumentException.class, () -> out.writeBytes(new byte[] {}, 0, 1));  
            field1 = in.readString();  
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
                return "This object cannot be serialized by writeGeneric method";
        assertEquals(expectedSize, out.size());
        out.close();  
    public void testWriteMapWithConsistentOrderWithLinkedHashMapShouldThrowAssertError() throws IOException {
            output.writeVInt(10);
                return true;
        List<String> mapKeys = map.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());  
            TestNamedWriteable namedWriteableIn = new TestNamedWriteable(
                output.writeInt(i);
                    assertEquals(i, ints[i]);  
        int position = 0;  
    }
        assertEquals("expands to 4 bytes", 4, new BytesRef(deseretLetter).length);  
            assertEquals(AssertionError.class, e.getClass());
        assertEquals(simple.bytes().toBytesRef().toString(), output.bytes().toBytesRef().toString());
        assertEquals(0, in.available());
        for (Map.Entry<String, List<String>> entry : expected.entrySet()) {
    private static class TestNamedWriteable extends BaseNamedWriteable {
        Map<String, String> map = randomMap(
    private static <K, V> Map<K, V> randomMap(Map<K, V> map, int size, Supplier<K> keyGenerator, Supplier<V> valueGenerator) {  
        return map;
        }
        out.writeStringArray(new String[] { "a", "b", "cat" });
        }
                            }
                expectThrows(IllegalStateException.class, () -> streamInput.readIntArray());
            TestNamedWriteable namedWriteableIn = new TestNamedWriteable(
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }  
    }
            out.writeString(field1);
            }
        assertThat(inValue, equalTo(value));  
        // now write the rest - more than fits into the remaining page + a full page after
        byte[] expectedData = randomizedByteArrayWithSize(expectedSize);
            BytesStreamOutput output = new BytesStreamOutput(0);
            out.writeNamedWriteableList(expected);  
        assertThat(error.getCause(), equalTo(rootEx));
        try (BytesStreamOutput output = new BytesStreamOutput(); BytesStreamOutput reverseMapOutput = new BytesStreamOutput()) {
        BytesStreamOutput out = new BytesStreamOutput();  
            Exception e = expectThrows(UnsupportedOperationException.class, () -> in.readNamedWriteable(BaseNamedWriteable.class));
import java.time.ZonedDateTime;
    public void testSingleFullPageBulkWriteWithOffsetCrossover() throws Exception {
            this.field2 = field2;
import static org.hamcrest.Matchers.hasSize;
            }
        in.close();
                assertEquals(entry.getValue().get(i), loadedList.get(i));  
        // first create initial offset
    public enum TestEnum {
        final List<TestWriteable> loaded = in.readList(TestWriteable::new);
        assertThat(in.readString(), equalTo("hello"));  
        final Map<String, List<String>> loaded = in.readMapOfLists(StreamInput::readString, StreamInput::readString);  
        String deseretLetter = "\uD801\uDC00";  
        long[] longArray = { 1, 2, 3 };
            for (int i = 0; i < 10; i++) {  
        @Override
    public void testSkip() throws Exception {  
        public void writeTo(StreamOutput out) throws IOException {
            output.writeVLongNoCheck(value); // Use NoCheck variant so we can write negative numbers
                assertEquals("tried to read: 100 bytes but this stream is limited to: 82", eofException.getMessage());
                    new NamedWriteableRegistry.Entry(BaseNamedWriteable.class, TestNamedWriteable.NAME, (StreamInput in) -> null)
        };  
        for (int i = 0; i < size; ++i) {
        assertThat(in.readOptionalVLong(), equalTo(5L));
    public void testOptionalWriteableReaderReturnsNull() throws IOException {  
    }  
import org.opensearch.core.common.io.stream.NamedWriteable;
        out.close();  
        long[] vLongArray = { 4, 5, 6 };
        assertEquals(0, out.bytes().length());
    }
        }
        // write byte-by-byte  
            IOException e = expectThrows(IOException.class, () -> in.readOptionalWriteable((StreamInput ignored) -> null));
/*  
        public int hashCode() {  
        rootEx.addSuppressed(ace); // circular reference
        assertThat(in.readVIntArray(), equalTo(vIntArray));
        out.close();
        assertThat(loaded.size(), equalTo(expected.size()));
        // write in bulk  
    private static void assertEqualityAfterSerialize(TimeValue value, int expectedSize) throws IOException {
        out.writeOptionalLong(11234234L);
        out.writeBoolean(false);
import java.util.Collections;  
        // write single byte
            NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
        out.writeOptionalVLong(5L);  
        for (int i = 0; i < expectedSize; i++) {  
            }
            try (StreamInput in = new NamedWriteableAwareStreamInput(StreamInput.wrap(bytes), namedWriteableRegistry)) {
        output.writeVInt(randomNumber);
            for (int i = 0; i < 10; i++) {
                new NamedWriteableRegistry.Entry(BaseNamedWriteable.class, TestNamedWriteable.NAME, TestNamedWriteable::new)
            out.writeNamedWriteable(namedWriteableIn);
    public void testEnum() throws IOException {
        assertThat(zdt.toInstant().toEpochMilli(), equalTo(123456L));
                strings.add(s);
            Collections.singletonList(
    /*
        out.close();  
            TestNamedWriteable testNamedWriteable = new TestNamedWriteable("test1", "test2");
        assertEquals(expectedSize, out.size());
        // bulk-write again with actual bytes
        // ie. we cross over into a third  
            randomIntBetween(2, 20),
import org.apache.lucene.util.Constants;  
                        (StreamInput in) -> new TestNamedWriteable(in) {
        } else {  
        );
            }
    }  
                for (int i = 0; i < 10; i++) {
    }
            return Objects.hash(field1, field2);
/**
                randomAlphaOfLengthBetween(1, 10)  
        StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));
        final Map<String, String> expected = new HashMap<>(randomIntBetween(0, 100));
    }
        assertEquals(expectedSize, out.size());  
            out.writeByte(expectedData[i]);
        @Override
 * GitHub history for details.
            Exception e = expectThrows(IllegalStateException.class, () -> output.writeVLong(value));
        Exception newEx = in.readException();  
            i >>>= 7;
        assertEquals(position, BytesReference.toBytes(out.bytes()).length);
    public void testNamedWriteableNotSupportedWithoutWrapping() throws IOException {
        final StreamInput in = StreamInput.wrap(BytesReference.toBytes(out.bytes()));
            try (StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), namedWriteableRegistry)) {
