                assertEquals(missing, serialized);
 * license agreements. See the NOTICE file distributed with
            out.writeOptionalInstant(instant);
        assertThat(bytesRef.length, equalTo(2));
        final BytesStreamOutput out = new BytesStreamOutput();
                strings = generateRandomStringArray(10, 10, false, true);  
        }
                strings = null;
            public void writeTo(final StreamOutput out) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(enumSet, targetSet);
    }
        out.writeOptionalEnumSet(enumSet);  
            index++;
        }  
        List<Tuple<Long, byte[]>> values = Arrays.asList(  
    public void testArrays() throws IOException {
    }  
        assertThat(bytes[0], equalTo((byte) 0));
        out.writeOptionalEnumSet(enumSet);  
                sourceArray = null;
        for (int i = 0; i < size; i++) {  
        final Set<Long> targetSet = getStreamInput(out.bytes()).readSet(StreamInput::readLong);
}  
        LinkedHashMap<String, Integer> read = (LinkedHashMap<String, Integer>) getStreamInput(out.bytes()).readGenericValue();
            StreamOutput::writeCollection,  
        final int length = randomIntBetween(1, 1024);  
                this.bar = bar;
        try (BytesStreamOutput output = new BytesStreamOutput()) {
    public void testOptionalEnumSet() throws IOException {  
        out.writeGenericValue(write);
    public void testSecureStringSerialization() throws IOException {
        assertThat(bytesRef.length, equalTo(3));
        InputStreamStreamInput streamInput = new InputStreamStreamInput(
/*  
                assertThat(collection, equalTo(reader.apply(in)));
package org.opensearch.core.common.io.stream;
        assertThat(targetSet, equalTo(sourceSet));
    }  
        Map<String, Object> goodMap = new HashMap<>();  
        final BytesStreamOutput output = new BytesStreamOutput();
            }
            in -> in.readList(FooBar::new)
        assertEquals(filterInputStream.available(), length);
        final BytesStreamOutput output = new BytesStreamOutput();  
        set.remove((byte) 0);  
    }
        // reverse order in normal set so linked hashset does not match the order
    }  
import java.util.stream.IntStream;
        out.writeOptionalEnumSet(enumSet);  
            out.writeZLong(write);
import java.util.function.Supplier;
        for (int i = 0; i < size; i++) {
        final Instant missing = null;
    public void testInstantSerialization() throws IOException {
 *  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        set.remove((byte) 0);
    private <T> void runWriteReadCollectionTest(  
 * this file be licensed under the Apache-2.0 license or a
            }  
        out = new BytesStreamOutput();
            writer.accept(out, collection);
        assertEquals(size, read.size());
        assertEquals(time, inTime);  
            write.put(Integer.toString(i), value);  
            public boolean equals(final Object o) {
import java.util.Map;
import org.opensearch.common.CheckedConsumer;  
        });
        enumSet = EnumSet.of(TestEnum.A, TestEnum.C, TestEnum.E);
            final SecureString secureString = randomBoolean() ? null : new SecureString("super secret".toCharArray());
        runWriteReadCollectionTest(
        }
        if (randomBoolean()) {
    }  
    public void testFilterStreamInputDelegatesAvailable() throws IOException {
                // touch the entries to set the access order  
    public void testListIsWriteable() throws IOException {  
    }
import org.opensearch.common.CheckedBiConsumer;
            }  
        final Set<Long> sourceSet = new HashSet<>(size);
                final FooBar that = (FooBar) o;
        assertEquals(streamInput.available(), length - bytesToRead);
            list.add(new Tuple<>(Integer.toString(i), value));
            @Override  
            assertEquals(list.get(index).v2(), entry.getValue());  
        output.writeGenericValue(time);
            new Tuple<>(-2L, new byte[] { 3 }),
    public void testCollection() throws IOException {  
            return string.hashCode();
 * KIND, either express or implied.  See the License for the
        final StreamInput input = getStreamInput(bytesReference);
        final int length = randomIntBetween(0, 10);
            out.writeArray(sourceArray);
            return string.equals(that.string);
    public void testRandomVLongSerialization() throws IOException {
            ;
            } else {
        goodMap.put("a", "b");
        assertFalse(maybeFalse);
 * not use this file except in compliance with the License.
            }
        runWriteReadCollectionTest(() -> randomUnicodeOfLength(16), StreamOutput::writeStringCollection, StreamInput::readStringList);  
        final BytesRef bytesRef = bytesReference.toBytesRef();
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> corrupt.streamInput().readOptionalBoolean());
        assertEquals(filterInputStream.available(), length - bytesToRead);
        output.writeOptionalBoolean(null);  
            if (this == o) {
        }
        stream.writeByteArray(array);
        assertNotWriteable(new Object[] { new Unwriteable() }, Unwriteable.class);  
            if (randomBoolean()) {  
        assertGenericRoundtrip(new LinkedHashSet<>(list));
            new Tuple<>(-1L, new byte[] { 1 }),
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.is;  
            collection.add(supplier.get());
        WriteableString(String string) {  
        final BytesReference corrupt = new BytesArray(corruptBytes);
        StreamOutput.checkWriteable(Arrays.asList("a", "b"));
 *
            private final int foo;  
        }
/*
    }
import java.util.EnumSet;
import java.util.Set;
        long millis = randomIntBetween(0, Integer.MAX_VALUE);
        int index = 0;  
import java.io.EOFException;
        @Override
        List<Tuple<String, Integer>> list = new ArrayList<>(size);
        }  
import java.time.ZonedDateTime;
            private FooBar(final int foo, final int bar) {  
            targetArray = getStreamInput(out.bytes()).readOptionalArray(WriteableString::new, WriteableString[]::new);
    private void assertGenericRoundtrip(Object original) throws IOException {
        final Boolean maybeTrue = input.readOptionalBoolean();  
            new Tuple<>(0L, new byte[] { 0 }),
        C,
            final StreamInput input = getStreamInput(bytesReference);
    }
            outputAssertions.accept(output);
            long write = randomLong();  
            assertArrayEquals(Long.toString(value.v1()), value.v2(), BytesReference.toBytes(out.bytes()));
 * compatible open source license.
import java.util.ArrayList;  
    public void testOptionalInstantSerialization() throws IOException {
            BytesReference.toBytes(stream.bytes()).length  
        targetSet = getStreamInput(out.bytes()).readOptionalEnumSet(TestEnum.class);
    }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
    ) throws IOException {
                final Instant serialized = in.readOptionalInstant();  
        out = new BytesStreamOutput();
        BytesStreamOutput out = new BytesStreamOutput();
    public void testBooleanSerialization() throws IOException {
        }  
        final CheckedFunction<StreamInput, Collection<T>, IOException> reader  
                return foo == that.foo && bar == that.bar;  
import static org.hamcrest.Matchers.containsString;  
 * The OpenSearch Contributors require contributions made to  
        assertNotWriteable(Collections.singletonMap("a", new Unwriteable()), Unwriteable.class);
        assertGenericRoundtrip(set);
            new Tuple<>(1L, new byte[] { 2 }),  
        assertNull(input.readOptionalBoolean());  
    }
        }  
        }
                this.foo = in.readInt();  
        assertThat(sourceSet, iterableWithSize(size));
                return false;
        final BytesStreamOutput output = new BytesStreamOutput();  
import org.opensearch.core.common.bytes.BytesReference;
                assertThat(input.readOptionalSecureString(), is(nullValue()));  
            }
            final SecureString secureString = new SecureString("super secret".toCharArray());  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Objects;  
 */  
        @Override
import java.util.Locale;
        for (Map.Entry<String, Integer> entry : read.entrySet()) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> StreamOutput.checkWriteable(o));
    public void testObjectArrayIsWriteable() throws IOException {
        final int length = randomIntBetween(1, 1024);
        }  
        }
import java.util.Collections;  
            if (randomBoolean()) {
        byte[] array = new byte[randomIntBetween(1, 10)];  
 * Licensed to Elasticsearch under one or more contributor  
            new Tuple<>(Long.MIN_VALUE, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, 1 }),  
        final String string;
        StreamOutput.checkWriteable(new HashSet<>(Arrays.asList("a", "b")));
            if (secureString != null) {  
        set.remove((byte) 1);
import java.time.Instant;  
import java.io.ByteArrayInputStream;  
            }  
            output.writeSecureString(secureString);
            inputAssertions.accept(input);  
        final BytesReference bytesReference = output.bytes();
    private static class Unwriteable {}
            out.writeArray(writer, strings);  
    }
            for (Tuple<String, Integer> entry : list) {
            out.writeOptionalInstant(missing);
import static org.hamcrest.Matchers.iterableWithSize;
    }
                out.writeInt(foo);  
            ;
    public void testReadArraySize() throws IOException {
    public void testOptionalBooleanSerialization() throws IOException {
            output.writeOptionalSecureString(secureString);  
        }  
public abstract class BaseStreamTests extends OpenSearchTestCase {
        output.writeBoolean(true);
        LinkedHashMap<String, Integer> write = new LinkedHashMap<>(size, 0.75f, accessOrder);
        Writeable.Writer<String> writer = StreamOutput::writeString;
            StreamInput.wrap(BytesReference.toBytes(stream.bytes())),  
        final Collection<T> collection = new ArrayList<>(length);  
            @Override
    private void assertNotWriteable(Object o, Class<?> type) {
            assertEquals(Arrays.toString(value.v2()), (long) value.v1(), bytes.streamInput().readZLong());  
        EnumSet<TestEnum> targetSet = getStreamInput(out.bytes()).readOptionalEnumSet(TestEnum.class);
        final BytesReference corrupt = new BytesArray(corruptBytes);
        final byte[] corruptBytes = new byte[] { randomFrom(set) };  
        if (randomBoolean()) {  
            out.writeString(string);  
            }
            this(in.readString());
            }
            array.length - 1
            }
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.settings.SecureString;  
        int size = randomIntBetween(1, 1024);
    public void testSetIsWriteable() throws IOException {
            assertEquals(write, read);
            new Tuple<>(Long.MAX_VALUE, new byte[] { -2, -1, -1, -1, -1, -1, -1, -1, -1, 1 })
    private enum TestEnum {
        WriteableString[] sourceArray = Arrays.stream(strings).<WriteableString>map(WriteableString::new).toArray(WriteableString[]::new);
import java.io.IOException;
            try (StreamInput in = getStreamInput(out.bytes())) {
        filterInputStream.readBytes(new byte[bytesToRead], 0, bytesToRead);  
        final String message = String.format(Locale.ROOT, "unexpected byte [0x%02x]", corruptBytes[0]);
        }
        A,  
        assertEquals(enumSet, targetSet);
            @Override
    }  
import java.util.HashMap;
    private void assertSerialization(  
    public void testLinkedHashMap() throws IOException {
        final Set<Byte> set = IntStream.range(Byte.MIN_VALUE, Byte.MAX_VALUE).mapToObj(v -> (byte) v).collect(Collectors.toSet());
    }
        final int bytesToRead = randomIntBetween(1, length);
            }
    }
                final Instant serialized = in.readOptionalInstant();  
        }  
 *
            () -> new FooBar(randomInt(), randomInt()),
        set.remove((byte) 2);
 * this work for additional information regarding copyright
        );
 * the Apache License, Version 2.0 (the "License"); you may
        enumSet = null;
        final BytesReference bytesReference = output.bytes();
        class FooBar implements Writeable {
                return Objects.hash(foo, bar);
        ZonedDateTime time = ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneOffset.ofHours(-7));  
        }
            StreamInput.wrap(BytesReference.toBytes(stream.bytes())),
        assertThat(e, hasToString(containsString(message)));
            out.writeInstant(instant);
            Object read = input.readGenericValue();  
        assertEquals(streamInput.available(), length);
        List<String> list = new ArrayList<>(set);  
            strings = generateRandomStringArray(10, 10, false, true);
        enumSet = EnumSet.noneOf(TestEnum.class);
import org.opensearch.common.io.stream.BytesStreamOutput;  
        assertNotWriteable(new Unwriteable(), Unwriteable.class);
        StreamOutput.checkWriteable(goodMap);  
        final CheckedBiConsumer<StreamOutput, Collection<T>, IOException> writer,
        InputStreamStreamInput streamInput = new InputStreamStreamInput(is);
        final Instant instant = Instant.now();
            new Tuple<>(2L, new byte[] { 4 }),
import org.opensearch.common.CheckedFunction;
    }
import java.util.Arrays;
        }
        // read some bytes
        out.writeOptionalEnumSet(enumSet);  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        );
                final Instant serialized = in.readInstant();
        EnumSet<TestEnum> enumSet = EnumSet.allOf(TestEnum.class);
        BytesStreamOutput out = new BytesStreamOutput();
        set.remove((byte) 1);  
            BytesReference bytes = new BytesArray(value.v2());
            }
        final String[] deserialized;
import static org.hamcrest.Matchers.nullValue;
        assertThat(bytes[1], equalTo((byte) 1));
 * GitHub history for details.
                return true;
        D,  
    static final class WriteableString implements Writeable {  
    public void testGenericSet() throws IOException {
import java.util.HashSet;  
                assertEquals(instant, serialized);
        final int bytesToRead = randomIntBetween(1, length);
        out.writeCollection(sourceSet, StreamOutput::writeLong);
            targetArray = getStreamInput(out.bytes()).readArray(WriteableString::new, WriteableString[]::new);
import org.apache.lucene.util.BytesRef;
        public boolean equals(Object o) {  
        assertTrue(input.readBoolean());
    }  
    public void testMapIsWriteable() throws IOException {
        for (int i = 0; i < length; i++) {
            try (StreamInput in = getStreamInput(out.bytes())) {
        Writeable.Reader<String> reader = StreamInput::readString;  
        FilterStreamInput filterInputStream = new FilterStreamInput(delegate) {  
        final byte[] bytes = bytesRef.bytes;  
        @SuppressWarnings("unchecked")  
        };
    public void testStringCollection() throws IOException {
        streamInput.readBytes(new byte[bytesToRead], 0, bytesToRead);  
        Collections.reverse(list);
        try (BytesStreamOutput output = new BytesStreamOutput()) {
        final Supplier<T> supplier,
import static org.hamcrest.Matchers.hasToString;
    }  
 * Unless required by applicable law or agreed to in writing,
            final BytesReference bytesReference = output.bytes();  
        output.writeBoolean(false);
        assertThat(bytes[0], equalTo((byte) 0));  
        assertNotWriteable(Collections.singleton(new Unwriteable()), Unwriteable.class);  
        targetSet = getStreamInput(out.bytes()).readOptionalEnumSet(TestEnum.class);
        ByteArrayInputStream is = new ByteArrayInputStream(new byte[length]);  
    }
            }  
        goodMap.put("c", "d");
        }  
    public void testIsWriteable() throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.bytes.BytesArray;
            private final int bar;
                assertThat(input.readOptionalSecureString(), is(equalTo(secureString)));
import java.util.LinkedHashMap;
        } else {
        for (int i = 0; i < array.length; i++) {
        final BytesRef bytesRef = bytesReference.toBytesRef();  
            }  
        }  
                write.get(entry.v1());
    }  
 * specific language governing permissions and limitations
        BytesStreamOutput out = new BytesStreamOutput();
        output.writeOptionalBoolean(true);
        for (int i = 0; i < 1024; i++) {
    public void testWritableArrays() throws IOException {  
        CheckedConsumer<StreamInput, IOException> inputAssertions
                if (this == o) return true;  
        assertTrue(maybeTrue);
        @Override
        assertNotNull(maybeTrue);
    protected abstract StreamInput getStreamInput(BytesReference bytesReference) throws IOException;  
        assertThat(bytes[2], equalTo((byte) 2));  
        targetSet = getStreamInput(out.bytes()).readOptionalEnumSet(TestEnum.class);
            out.writeZLong(value.v1());  
        final BytesReference bytesReference = output.bytes();  
                out.writeInt(bar);
            deserialized = getStreamInput(out.bytes()).readOptionalArray(reader, String[]::new);  
            final BytesReference bytesReference = output.bytes();
        Object inTime = input.readGenericValue();
        WriteableString[] targetArray;  
        assertEquals(enumSet, targetSet);
            assertThat(secureString, is(equalTo(input.readSecureString())));
            deserialized = getStreamInput(out.bytes()).readArray(reader, String[]::new);
        final byte[] bytes = bytesRef.bytes;
        }
            private FooBar(final StreamInput in) throws IOException {
        final byte[] corruptBytes = new byte[] { randomFrom(set) };
        );  
        WriteableString(StreamInput in) throws IOException {
        }
import java.util.LinkedHashSet;
        // read some bytes
import java.util.Collection;
 * under the License.  
        StreamInput delegate = StreamInput.wrap(new byte[length]);
        assertThat(targetArray, equalTo(sourceArray));
import java.time.ZoneOffset;
        BytesStreamOutput out = new BytesStreamOutput();
    ) throws IOException {  
        assertThat(deserialized, equalTo(strings));  
            // randomize access order  
            if (o == null || getClass() != o.getClass()) {
            try (StreamInput in = getStreamInput(out.bytes())) {  
        final StreamInput input = getStreamInput(bytesReference);  
        final StreamInput input = getStreamInput(bytesReference);
        assertNotWriteable(Collections.singletonList(new Unwriteable()), Unwriteable.class);
 * software distributed under the License is distributed on an
    }  
                if (o == null || getClass() != o.getClass()) return false;
        );
            final StreamInput input = getStreamInput(bytesReference);  
        output.writeOptionalBoolean(false);
        assertThat(bytes[1], equalTo((byte) 1));
        streamInput = new InputStreamStreamInput(
                assertEquals(instant, serialized);
            int value = randomInt();
        assertNotNull(maybeFalse);
    }
        }
 */  
            array[i] = randomByte();
            BytesStreamOutput out = new BytesStreamOutput();
            this.string = string;
        final Set<Byte> set = IntStream.range(Byte.MIN_VALUE, Byte.MAX_VALUE).mapToObj(v -> (byte) v).collect(Collectors.toSet());
            sourceSet.add(randomLongBetween(i * 1000, (i + 1) * 1000 - 1));  
        final int size = randomIntBetween(0, 6);  
    public void testSetOfLongs() throws IOException {
        try (BytesStreamOutput output = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                this.foo = foo;
        BytesStreamOutput stream = new BytesStreamOutput();
            ;
        Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e"));  
    }
        for (Tuple<Long, byte[]> value : values) {
                this.bar = in.readInt();
        assertFalse(input.readBoolean());
            } else {
/*  
            assertEquals(list.get(index).v1(), entry.getKey());
        final String[] strings;  
        assertEquals(EnumSet.noneOf(TestEnum.class), targetSet);
        CheckedConsumer<StreamOutput, IOException> outputAssertions,
    }
            final BytesReference bytesReference = output.bytes();  
            WriteableString that = (WriteableString) o;
    public void testInputStreamStreamInputDelegatesAvailable() throws IOException {
    }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testJavaDateTimeSerialization() throws IOException {  
    public void testSpecificVLongSerialization() throws IOException {
            public int hashCode() {
        public void writeTo(StreamOutput out) throws IOException {
            try (StreamInput in = getStreamInput(out.bytes())) {  
    }  
import java.util.stream.Collectors;  
            Collections.shuffle(list, random());
import org.opensearch.common.collect.Tuple;
            BytesStreamOutput out = new BytesStreamOutput();
        public int hashCode() {  
            final StreamInput input = getStreamInput(bytesReference);
        E;
        boolean accessOrder = randomBoolean();  
        expectThrows(EOFException.class, streamInput::readByteArray);  
    }  
import org.opensearch.test.OpenSearchTestCase;
 */
    }
        final String message = String.format(Locale.ROOT, "unexpected byte [0x%02x]", corruptBytes[0]);  
        } else {  
            long read = getStreamInput(out.bytes()).readZLong();  
        final String[] strings = generateRandomStringArray(10, 10, false, true);
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
import java.util.List;  
            out.writeOptionalArray(sourceArray);
        assertThat(e.getMessage(), equalTo("Cannot write type [" + type.getCanonicalName() + "] to stream"));  
        B,
            }
            out.writeOptionalArray(writer, strings);
        final Instant instant = Instant.now();  
        StreamOutput.checkWriteable(new Object[] { "a", "b" });
            }  
        assertThat(e, hasToString(containsString(message)));
        out = new BytesStreamOutput();
        assertSerialization(output -> { output.writeGenericValue(original); }, input -> {
    }
        final Boolean maybeFalse = input.readOptionalBoolean();  
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> corrupt.streamInput().readBoolean());  
        if (accessOrder) {
        assertArrayEquals(array, streamInput.readByteArray());  
            assertThat(read, equalTo(original));
