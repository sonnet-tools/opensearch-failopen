        targetSet = getStreamInput(out.bytes()).readOptionalEnumSet(TestEnum.class);
            return string.equals(that.string);
            BytesReference bytes = new BytesArray(value.v2());
    }
        final StreamInput input = getStreamInput(bytesReference);
        assertGenericRoundtrip(new LinkedHashSet<>(list));
import org.opensearch.common.CheckedFunction;
        final byte[] bytes = bytesRef.bytes;
/*
 * software distributed under the License is distributed on an
    }
            }
        enumSet = EnumSet.noneOf(TestEnum.class);
import java.util.Set;
        WriteableString[] targetArray;
    public void testStringCollection() throws IOException {
            try (StreamInput in = getStreamInput(out.bytes())) {
        assertEquals(streamInput.available(), length);
            targetArray = getStreamInput(out.bytes()).readOptionalArray(WriteableString::new, WriteableString[]::new);
        goodMap.put("c", "d");
            array.length - 1
import org.apache.lucene.util.BytesRef;
            new Tuple<>(-1L, new byte[] { 1 }),
        assertNull(input.readOptionalBoolean());
            public int hashCode() {
        FilterStreamInput filterInputStream = new FilterStreamInput(delegate) {
    }
        }
import org.opensearch.core.common.bytes.BytesArray;
        out.writeOptionalEnumSet(enumSet);
        Map<String, Object> goodMap = new HashMap<>();
            final StreamInput input = getStreamInput(bytesReference);
            deserialized = getStreamInput(out.bytes()).readOptionalArray(reader, String[]::new);
        assertThat(bytes[1], equalTo((byte) 1));
    private void assertNotWriteable(Object o, Class<?> type) {
    public void testLinkedHashMap() throws IOException {
            long read = getStreamInput(out.bytes()).readZLong();
            new Tuple<>(1L, new byte[] { 2 }),
        final Boolean maybeTrue = input.readOptionalBoolean();
        final byte[] corruptBytes = new byte[] { randomFrom(set) };
        final BytesStreamOutput output = new BytesStreamOutput();
    public void testSecureStringSerialization() throws IOException {
    }
    }
    public void testInstantSerialization() throws IOException {
        List<Tuple<Long, byte[]>> values = Arrays.asList(
        if (randomBoolean()) {
            out.writeZLong(value.v1());
            StreamOutput::writeCollection,
        // read some bytes
            public boolean equals(final Object o) {
        int size = randomIntBetween(1, 1024);
import java.util.HashSet;
 * The OpenSearch Contributors require contributions made to
            BytesStreamOutput out = new BytesStreamOutput();
            this.string = string;
            final SecureString secureString = new SecureString("super secret".toCharArray());
        @Override
        stream.writeByteArray(array);
        C,
        assertEquals(filterInputStream.available(), length - bytesToRead);
            for (Tuple<String, Integer> entry : list) {
            out.writeArray(sourceArray);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
        streamInput.readBytes(new byte[bytesToRead], 0, bytesToRead);
            // randomize access order
                final Instant serialized = in.readOptionalInstant();
        final int size = randomIntBetween(0, 6);
            out.writeZLong(write);
 *
        assertEquals(filterInputStream.available(), length);
        E;
        assertThat(deserialized, equalTo(strings));
import java.io.IOException;
        final BytesReference bytesReference = output.bytes();
import java.util.Arrays;
        set.remove((byte) 0);
    public void testSetOfLongs() throws IOException {
    }
        final Supplier<T> supplier,
        try (BytesStreamOutput output = new BytesStreamOutput()) {
                return false;
import java.io.ByteArrayInputStream;
        );
        try (BytesStreamOutput output = new BytesStreamOutput()) {
        }
            writer.accept(out, collection);
        out.writeCollection(sourceSet, StreamOutput::writeLong);
            } else {
            this(in.readString());
            new Tuple<>(2L, new byte[] { 4 }),
        }
    ) throws IOException {
    public void testWritableArrays() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
            Object read = input.readGenericValue();
        assertGenericRoundtrip(set);
        final Set<Long> sourceSet = new HashSet<>(size);
            private final int bar;
        final StreamInput input = getStreamInput(bytesReference);
    }
        final Instant instant = Instant.now();
        Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e"));
        InputStreamStreamInput streamInput = new InputStreamStreamInput(
            new Tuple<>(0L, new byte[] { 0 }),
    }
    }
        try (BytesStreamOutput output = new BytesStreamOutput()) {
            StreamInput.wrap(BytesReference.toBytes(stream.bytes())),
            }
import org.opensearch.common.collect.Tuple;
        WriteableString(StreamInput in) throws IOException {
        final String[] deserialized;
import org.opensearch.core.common.bytes.BytesReference;
        EnumSet<TestEnum> enumSet = EnumSet.allOf(TestEnum.class);
        assertEquals(EnumSet.noneOf(TestEnum.class), targetSet);
        WriteableString[] sourceArray = Arrays.stream(strings).<WriteableString>map(WriteableString::new).toArray(WriteableString[]::new);
            final BytesReference bytesReference = output.bytes();
import org.opensearch.common.CheckedConsumer;
                if (this == o) return true;
import static org.hamcrest.Matchers.iterableWithSize;
            long write = randomLong();
        BytesStreamOutput stream = new BytesStreamOutput();
                if (o == null || getClass() != o.getClass()) return false;
            assertEquals(list.get(index).v2(), entry.getValue());
    }
 * Licensed to Elasticsearch under one or more contributor
    public void testOptionalBooleanSerialization() throws IOException {
        set.remove((byte) 1);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> StreamOutput.checkWriteable(o));
            BytesStreamOutput out = new BytesStreamOutput();
        assertThat(e, hasToString(containsString(message)));
    }
        }
        output.writeGenericValue(time);
    public void testInputStreamStreamInputDelegatesAvailable() throws IOException {
 * this work for additional information regarding copyright
    }
        for (int i = 0; i < length; i++) {
            ;
    public void testSpecificVLongSerialization() throws IOException {
            }
            if (randomBoolean()) {
import org.opensearch.test.OpenSearchTestCase;
 * under the License.
        output.writeBoolean(false);
        }
 */
            }
    private <T> void runWriteReadCollectionTest(
    public void testJavaDateTimeSerialization() throws IOException {
import java.util.function.Supplier;
        final byte[] bytes = bytesRef.bytes;
        final BytesReference corrupt = new BytesArray(corruptBytes);
        final CheckedBiConsumer<StreamOutput, Collection<T>, IOException> writer,
        runWriteReadCollectionTest(
        assertNotNull(maybeFalse);
import java.util.Map;
        final String[] strings = generateRandomStringArray(10, 10, false, true);
                out.writeInt(bar);
            }
import java.util.stream.IntStream;
        out.writeOptionalEnumSet(enumSet);
            @Override
            assertThat(read, equalTo(original));
 * GitHub history for details.
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        ByteArrayInputStream is = new ByteArrayInputStream(new byte[length]);
            sourceSet.add(randomLongBetween(i * 1000, (i + 1) * 1000 - 1));
    public void testCollection() throws IOException {
        StreamOutput.checkWriteable(Arrays.asList("a", "b"));
        final int length = randomIntBetween(1, 1024);
        }
}
        } else {
            }
            ;
        assertNotWriteable(Collections.singletonMap("a", new Unwriteable()), Unwriteable.class);
        boolean accessOrder = randomBoolean();
        for (Tuple<Long, byte[]> value : values) {
        public void writeTo(StreamOutput out) throws IOException {
        StreamOutput.checkWriteable(goodMap);
        StreamOutput.checkWriteable(new Object[] { "a", "b" });
        assertFalse(input.readBoolean());
        assertEquals(streamInput.available(), length - bytesToRead);
        output.writeOptionalBoolean(true);
                final FooBar that = (FooBar) o;
            output.writeSecureString(secureString);
import java.util.LinkedHashSet;
        out = new BytesStreamOutput();
        final String message = String.format(Locale.ROOT, "unexpected byte [0x%02x]", corruptBytes[0]);
        final String[] strings;
            }
        Object inTime = input.readGenericValue();
                final Instant serialized = in.readInstant();
            }
        final Set<Byte> set = IntStream.range(Byte.MIN_VALUE, Byte.MAX_VALUE).mapToObj(v -> (byte) v).collect(Collectors.toSet());
            public void writeTo(final StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        List<String> list = new ArrayList<>(set);
            new Tuple<>(-2L, new byte[] { 3 }),
            out.writeInstant(instant);
    public void testSetIsWriteable() throws IOException {
        }
            try (StreamInput in = getStreamInput(out.bytes())) {
            private final int foo;
                strings = null;
        }
        final BytesReference bytesReference = output.bytes();
            assertThat(secureString, is(equalTo(input.readSecureString())));
import java.util.List;
                this.bar = bar;
        filterInputStream.readBytes(new byte[bytesToRead], 0, bytesToRead);
            targetArray = getStreamInput(out.bytes()).readArray(WriteableString::new, WriteableString[]::new);
        final BytesStreamOutput output = new BytesStreamOutput();
            if (secureString != null) {
                assertEquals(instant, serialized);
        Collections.reverse(list);
        Writeable.Writer<String> writer = StreamOutput::writeString;
    protected abstract StreamInput getStreamInput(BytesReference bytesReference) throws IOException;
 *
        B,
        );
            write.put(Integer.toString(i), value);
            assertEquals(write, read);
/*
        }
package org.opensearch.core.common.io.stream;
 * ownership. Elasticsearch licenses this file to you under
    public void testIsWriteable() throws IOException {
            WriteableString that = (WriteableString) o;
    private enum TestEnum {
        };
        assertThat(e.getMessage(), equalTo("Cannot write type [" + type.getCanonicalName() + "] to stream"));
import java.util.EnumSet;
    public void testGenericSet() throws IOException {
                this.bar = in.readInt();
            }
import java.util.ArrayList;
            out.writeOptionalInstant(instant);
        }
import java.time.Instant;
        // read some bytes
        assertEquals(size, read.size());
                return true;
        @SuppressWarnings("unchecked")
            deserialized = getStreamInput(out.bytes()).readArray(reader, String[]::new);
        final byte[] corruptBytes = new byte[] { randomFrom(set) };
                sourceArray = null;
        expectThrows(EOFException.class, streamInput::readByteArray);
        }
                assertEquals(missing, serialized);
    public void testOptionalInstantSerialization() throws IOException {
        List<Tuple<String, Integer>> list = new ArrayList<>(size);
            private FooBar(final StreamInput in) throws IOException {
        out.writeOptionalEnumSet(enumSet);
    }
            final BytesReference bytesReference = output.bytes();
    }
    }
                // touch the entries to set the access order
        final CheckedFunction<StreamInput, Collection<T>, IOException> reader
 * the Apache License, Version 2.0 (the "License"); you may
            BytesReference.toBytes(stream.bytes()).length
        } else {
        assertTrue(input.readBoolean());
        runWriteReadCollectionTest(() -> randomUnicodeOfLength(16), StreamOutput::writeStringCollection, StreamInput::readStringList);
        @Override
            Collections.shuffle(list, random());
            ;
        }
import java.io.EOFException;
            final StreamInput input = getStreamInput(bytesReference);
import static org.hamcrest.Matchers.is;
import org.opensearch.core.common.settings.SecureString;
        assertEquals(enumSet, targetSet);
        set.remove((byte) 0);
        targetSet = getStreamInput(out.bytes()).readOptionalEnumSet(TestEnum.class);
                return foo == that.foo && bar == that.bar;
    private void assertGenericRoundtrip(Object original) throws IOException {
        Writeable.Reader<String> reader = StreamInput::readString;
                this.foo = in.readInt();
        final int length = randomIntBetween(0, 10);
        assertThat(bytesRef.length, equalTo(3));
        assertThat(bytesRef.length, equalTo(2));
 */
        out.writeOptionalEnumSet(enumSet);
import static org.hamcrest.Matchers.equalTo;
        set.remove((byte) 2);
        CheckedConsumer<StreamInput, IOException> inputAssertions
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.nullValue;
        final int bytesToRead = randomIntBetween(1, length);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        StreamOutput.checkWriteable(new HashSet<>(Arrays.asList("a", "b")));
            }
        final int length = randomIntBetween(1, 1024);
import org.opensearch.common.io.stream.BytesStreamOutput;
            out.writeOptionalArray(writer, strings);
        }
            array[i] = randomByte();
            collection.add(supplier.get());
                assertEquals(instant, serialized);
        assertNotWriteable(Collections.singletonList(new Unwriteable()), Unwriteable.class);
import java.time.ZonedDateTime;
        EnumSet<TestEnum> targetSet = getStreamInput(out.bytes()).readOptionalEnumSet(TestEnum.class);
        final String message = String.format(Locale.ROOT, "unexpected byte [0x%02x]", corruptBytes[0]);
        assertEquals(time, inTime);
            try (StreamInput in = getStreamInput(out.bytes())) {
            assertEquals(list.get(index).v1(), entry.getKey());
    public void testFilterStreamInputDelegatesAvailable() throws IOException {
        assertSerialization(output -> { output.writeGenericValue(original); }, input -> {
        out = new BytesStreamOutput();
            @Override
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> corrupt.streamInput().readBoolean());
            }
                assertThat(collection, equalTo(reader.apply(in)));
 * SPDX-License-Identifier: Apache-2.0
            new Tuple<>(Long.MAX_VALUE, new byte[] { -2, -1, -1, -1, -1, -1, -1, -1, -1, 1 })
            inputAssertions.accept(input);
    }
import java.util.Collections;
/*
            () -> new FooBar(randomInt(), randomInt()),
        for (int i = 0; i < array.length; i++) {
        );
        public boolean equals(Object o) {
            out.writeOptionalInstant(missing);
            }
import java.time.ZoneOffset;
    }
            final SecureString secureString = randomBoolean() ? null : new SecureString("super secret".toCharArray());
    }
    }
                this.foo = foo;
    public void testMapIsWriteable() throws IOException {
            if (randomBoolean()) {
import static org.hamcrest.Matchers.containsString;
            @Override
    }
    public void testRandomVLongSerialization() throws IOException {
import java.util.stream.Collectors;
        InputStreamStreamInput streamInput = new InputStreamStreamInput(is);
        set.remove((byte) 1);
        A,
import java.util.LinkedHashMap;
            list.add(new Tuple<>(Integer.toString(i), value));
        StreamInput delegate = StreamInput.wrap(new byte[length]);
            final StreamInput input = getStreamInput(bytesReference);
        out.writeGenericValue(write);
import java.util.Locale;
 * specific language governing permissions and limitations
    }
        // reverse order in normal set so linked hashset does not match the order
        });
 * You may obtain a copy of the License at
            if (this == o) {
 */
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> corrupt.streamInput().readOptionalBoolean());
        public int hashCode() {
    public void testReadArraySize() throws IOException {
        assertTrue(maybeTrue);
            if (o == null || getClass() != o.getClass()) {
        assertThat(targetSet, equalTo(sourceSet));
    }
        D,
        output.writeBoolean(true);
        final Set<Byte> set = IntStream.range(Byte.MIN_VALUE, Byte.MAX_VALUE).mapToObj(v -> (byte) v).collect(Collectors.toSet());
        final BytesRef bytesRef = bytesReference.toBytesRef();
        final BytesStreamOutput output = new BytesStreamOutput();
 * KIND, either express or implied.  See the License for the
        assertThat(bytes[0], equalTo((byte) 0));
        assertNotNull(maybeTrue);
        streamInput = new InputStreamStreamInput(
        final BytesStreamOutput out = new BytesStreamOutput();
            private FooBar(final int foo, final int bar) {
        }
                write.get(entry.v1());
                assertThat(input.readOptionalSecureString(), is(equalTo(secureString)));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        enumSet = EnumSet.of(TestEnum.A, TestEnum.C, TestEnum.E);
    }
    }
        targetSet = getStreamInput(out.bytes()).readOptionalEnumSet(TestEnum.class);
        BytesStreamOutput out = new BytesStreamOutput();
        }
        assertNotWriteable(new Object[] { new Unwriteable() }, Unwriteable.class);
            final BytesReference bytesReference = output.bytes();
        @Override
        output.writeOptionalBoolean(false);
public abstract class BaseStreamTests extends OpenSearchTestCase {
        final StreamInput input = getStreamInput(bytesReference);
        assertThat(sourceSet, iterableWithSize(size));
        BytesStreamOutput out = new BytesStreamOutput();
        final Set<Long> targetSet = getStreamInput(out.bytes()).readSet(StreamInput::readLong);
        assertThat(bytes[1], equalTo((byte) 1));
    }
                final Instant serialized = in.readOptionalInstant();
            outputAssertions.accept(output);
        }
            strings = generateRandomStringArray(10, 10, false, true);
            new Tuple<>(Long.MIN_VALUE, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, 1 }),
        if (accessOrder) {
            return string.hashCode();
        }
 * compatible open source license.
            }
        for (Map.Entry<String, Integer> entry : read.entrySet()) {
                strings = generateRandomStringArray(10, 10, false, true);
                out.writeInt(foo);
        assertThat(bytes[0], equalTo((byte) 0));
 * not use this file except in compliance with the License.
            try (StreamInput in = getStreamInput(out.bytes())) {
    }
        final String string;
    }
        int index = 0;
        }
    public void testArrays() throws IOException {
        ZonedDateTime time = ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneOffset.ofHours(-7));
 *     http://www.apache.org/licenses/LICENSE-2.0
        class FooBar implements Writeable {
 * license agreements. See the NOTICE file distributed with
        final BytesReference corrupt = new BytesArray(corruptBytes);
        final BytesRef bytesRef = bytesReference.toBytesRef();
import static org.hamcrest.Matchers.hasToString;
        LinkedHashMap<String, Integer> write = new LinkedHashMap<>(size, 0.75f, accessOrder);
            }
        LinkedHashMap<String, Integer> read = (LinkedHashMap<String, Integer>) getStreamInput(out.bytes()).readGenericValue();
                return Objects.hash(foo, bar);
        out = new BytesStreamOutput();
            assertArrayEquals(Long.toString(value.v1()), value.v2(), BytesReference.toBytes(out.bytes()));
        final int bytesToRead = randomIntBetween(1, length);
        enumSet = null;
        for (int i = 0; i < size; i++) {
    public void testObjectArrayIsWriteable() throws IOException {
 *
    static final class WriteableString implements Writeable {
            out.writeArray(writer, strings);
        assertFalse(maybeFalse);
            out.writeOptionalArray(sourceArray);
        final Boolean maybeFalse = input.readOptionalBoolean();
    public void testOptionalEnumSet() throws IOException {
    ) throws IOException {
        }
        }
        assertEquals(enumSet, targetSet);
            assertEquals(Arrays.toString(value.v2()), (long) value.v1(), bytes.streamInput().readZLong());
        final BytesReference bytesReference = output.bytes();
import org.opensearch.common.CheckedBiConsumer;
    }
        assertEquals(enumSet, targetSet);
import java.util.Objects;
    public void testBooleanSerialization() throws IOException {
            StreamInput.wrap(BytesReference.toBytes(stream.bytes())),
        byte[] array = new byte[randomIntBetween(1, 10)];
            int value = randomInt();
        assertThat(targetArray, equalTo(sourceArray));
        assertThat(e, hasToString(containsString(message)));
            } else {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    private void assertSerialization(
        BytesStreamOutput out = new BytesStreamOutput();
    }
        }
        output.writeOptionalBoolean(null);
        assertNotWriteable(Collections.singleton(new Unwriteable()), Unwriteable.class);
                assertThat(input.readOptionalSecureString(), is(nullValue()));
            in -> in.readList(FooBar::new)
        if (randomBoolean()) {
            }
        final Collection<T> collection = new ArrayList<>(length);
        CheckedConsumer<StreamOutput, IOException> outputAssertions,
        long millis = randomIntBetween(0, Integer.MAX_VALUE);
            output.writeOptionalSecureString(secureString);
        goodMap.put("a", "b");
        WriteableString(String string) {
import java.util.HashMap;
        );
        final Instant instant = Instant.now();
        for (int i = 0; i < size; i++) {
            index++;
        assertThat(bytes[2], equalTo((byte) 2));
        final Instant missing = null;
        assertArrayEquals(array, streamInput.readByteArray());
        for (int i = 0; i < 1024; i++) {
            out.writeString(string);
    private static class Unwriteable {}
        assertNotWriteable(new Unwriteable(), Unwriteable.class);
    public void testListIsWriteable() throws IOException {
import java.util.Collection;
        BytesStreamOutput out = new BytesStreamOutput();
