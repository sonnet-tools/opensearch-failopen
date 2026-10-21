        }
            writeBoolean(false);
                    }
        Writer<Object> writer = WriteableRegistry.getWriter(type);
                }
        writers.put(float[].class, (o, v) -> {
 */
    /**
            spare.copyChars(string);
        }
            o.writeBytesRef((BytesRef) v);
            for (final V value : list) {
    }
            writeString(s);
            writeByte((byte) i);
        writers.put(BigInteger.class, (o, v) -> {
import org.opensearch.core.common.text.Text;
 */
import org.opensearch.core.common.settings.SecureString;
                    writeVInt(10);
     * references. Use {@link #writeBytesReference(BytesReference)} and {@link StreamInput#readBytesReference()} if you do not.
    }
     * writer version of {@link StreamInput#readArray(Writeable.Reader, IntFunction)}. The length of array encoded as a variable-length
    }
    public void writeMapWithConsistentOrder(@Nullable Map<String, ? extends Object> map) throws IOException {
        // the following is new for opensearch: we write the distribution name to support any "forks" of the code
        for (E e : enumSet) {
    /**
                    writeVInt(5);
    }
        writeString(build.getDistribution());
     *
        if (l == null) {
     * {@code Metadata.Custom}; see also {@code ClusterState.FeatureAware}.
import org.opensearch.core.common.io.stream.Writeable.WriteableRegistry;
                }
                writeOptionalString(throwable.getMessage());
     * can use {@code writeMapWithConsistentOrder}
    }
        namedWriteable.writeTo(this);
    }
            o.writeByte((byte) 19);
     */
                    return;
     * Writes an enum with type E based on its ordinal value
        assert this.features.isEmpty() : this.features;
    }
            writeArray(writer, array);
            @SuppressWarnings("unchecked")
            final List list = (List) v;
        if (writer == null) {
        final int charCount = str.length();
     * @param length the number of bytes to write
            writeTimeValue(timeValue);
            return Object[].class;
            // left before we start another iteration
        if (value == null) {
                valueWriter.write(this, value);
 * everywhere. That being said, this class deals primarily with {@code List}s rather than Arrays. For the most part calls should adapt to
    }
    /**
                }
    public final <K, V> void writeMapOfLists(final Map<K, List<V>> map, final Writer<K> keyWriter, final Writer<V> valueWriter)
        try {
    /**
        });
            final String string = text.string();
    }
    public void writeLongArray(long[] values) throws IOException {
        final byte[] buffer = scratch.get();
                        writeInt(t.getVersion());
        });
                    writeVInt(11);
    public abstract void writeBytes(byte[] b, int offset, int length) throws IOException;
     * @throws IOException if an I/O exception occurs writing the collection
        } else {
                o.writeByte((byte) 9);
        int offset = 0;
            buffer[index++] = ((byte) ((i & 0x7f) | 0x80));
     */
    public void writeBuild(final Build build) throws IOException {
    /**
    @Override
        this.writeByte((byte) 10);
    /** Writes the OpenSearch {@link Version} to the output stream */
        return this.features.contains(feature);
        }
    /**
        }
import java.nio.file.FileSystemLoopException;
        // Have registered ScriptedAvg class with byte 28 in Streamables.java, so that we do not need the implementation reside in the
     */
import org.opensearch.common.CharArrays;
        writers.put(Boolean.class, (o, v) -> {
            writeByte((byte) -1);
import java.util.Collections;
        write(bytes.bytes, bytes.offset, bytes.length);
        writeCollection(collection, StreamOutput::writeString);
        writeBytes(buffer, 0, index);
        if (integer == null) {
            }
    }
        writeCollection(list);
        }
                    writeCause = false;
     * @param array  the array
                    writeCause = false;
     */
import java.util.Collection;
                    writeCause = false;
            o.writeByte((byte) 14);
     * This method only will handle the map keys order, not maps contained within the map
     * integer is first written to the stream, and then the elements of the array are written to the stream.
        buffer[index++] = ((byte) i);
    }
     */
     */
    public void writeStringArrayNullable(@Nullable String[] array) throws IOException {
 * GitHub history for details.
        buffer[0] = (byte) (v >> 8);
    /**
    /**
    public void writeVInt(int i) throws IOException {
            writeBoolean(true);
        } else {
            final Map<String, Object> map = (Map<String, Object>) v;
    /**
     * @throws IOException if an I/O exception occurs writing the collection
            if (v instanceof LinkedHashSet) {
/*
                    }
     * Test if the stream has the specified feature. Features are used when serializing {@code ClusterState.Custom} or
 * visually for differences. That means that most variables should be read and written in a single line so even large objects fit both
        writeString(timeZone.getId());
        buffer[1] = (byte) (i >> 16);
    }
    public void writeIntArray(int[] values) throws IOException {
        return (W) writer;
    }
                    final OpenSearchException ex;
                    writeInt(tooNewEx.getMaxVersion());
                }
    /**
        final Class<?> type = getGenericType(value);
    private Version version = Version.CURRENT;
            writeStringArray(array);
        } else {
            Set<Object> set = (Set<Object>) value;
        writers.put(ZonedDateTime.class, (o, v) -> {
        writers.put(double[].class, (o, v) -> {
            o.writeDouble((double) v);
     */
     * @param collection the collection of strings
            writeDouble(v);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
        bytes.writeTo(this);
    public void writeCollection(final Collection<? extends Writeable> collection) throws IOException {
        writeBytes(buffer, 0, 4);
     * @param keyWriter The key writer
            o.writeByte((Byte) v);
     * Write a {@link TimeValue} to the stream
            o.writeString(zonedDateTime.getZone().getId());
        writers.put(Float.class, (o, v) -> {
            writeOptionalBytesReference(null);
    public void writeTimeValue(TimeValue timeValue) throws IOException {
    }
     * @param writer the writer used to write individual elements
            return;
            return BytesReference.class;
    public <T extends Writeable> void writeOptionalArray(@Nullable T[] array) throws IOException {
            if (v instanceof LinkedHashMap) {
    }
            writeCollection(collection, StreamOutput::writeString);
        // server module
     * For null or empty enum set, writes false;
            writeNamedWriteable(namedWriteable);
    }
}
     */
import java.util.function.IntFunction;
    private final BytesRefBuilder spare = new BytesRefBuilder();
            writeVInt(integer);
            }
            writeBoolean(true);
            o.writeByte((byte) 26);
import java.io.OutputStream;
    @Override
        if (bytes == null) {
                }
     * @param b the bytes to write
    /**
import org.apache.lucene.store.AlreadyClosedException;
            writeLong(value);
     */
     * @param collection the collection of strings
    }
import java.time.ZoneId;
    public void writeBytes(byte[] b) throws IOException {
        final byte[] buffer = scratch.get();
            writeVInt(list.size());
    }
        writers.put(Date.class, (o, v) -> {
    /**
    }
    /**
        }
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            writeBoolean(true);
            o.writeVInt(list.length);
        }
            Object[] array = (Object[]) value;
        WRITERS = Collections.unmodifiableMap(writers);
            OpenSearchException.writeStackTraces(throwable, this, (o, t) -> o.writeException(rootException, t, nestedLevel + 1));
    }
            @SuppressWarnings("unchecked")
            }
            writeBoolean(true);
     */
     */
    }
@PublicApi(since = "1.0.0")
     * Writes an int as four bytes.
     * Writes an {@link Instant} to the stream with nanosecond resolution
        writeByte((byte) timeValue.timeUnit().ordinal());
            return Map.class;
        writeVLongNoCheck(i);
 * A stream from another node to this node. Technically, it can also be streamed from a byte array but that is mostly for testing.
        if (bytes == null) {
                o.writeGenericValue(entry.getValue());
            return registeredClass;
    public void writeOptionalLong(@Nullable Long l) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
            }
    /**
    /**
                    writeVInt(OpenSearchException.getId(ex.getClass()));
        writeMap(map, keyWriter, (stream, list) -> {
            o.writeByte((byte) 17);
            writeBoolean(false);
                        case FileAlreadyExistsException ignored -> writeVInt(4);
    public final void writeOptionalInstant(@Nullable Instant instant) throws IOException {
        } while ((i & ~0x7F) != 0);
                    writeOptionalString(tooNewEx.getResourceDescription());
                checkWriteable(v);
        writeVInt(map.size());
            final byte[] bytes = (byte[]) v;
import java.util.EnumSet;
     */
    /**
    public void writeVersion(final Version version) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            writeBoolean(false);
        writeBytes(b, off, len);
     * Same as {@link #writeArray(Writeable[])} but the provided array may be null. An additional boolean value is
        for (NamedWriteable obj : list) {
                case IOException ignored -> writeVInt(17);
        }
     *
    public long position() throws IOException {
         */
            this.writeGenericValue(next.getValue());
            o.writeText((Text) v);
        });
     */
import java.util.Date;
 * specific language governing permissions and limitations
     * @return true if the stream has the specified feature
 * compatible open source license.
    }
     * Writes a collection of a strings. The corresponding collection can be read from a stream input using
    public void writeOptionalString(@Nullable String str) throws IOException {
            writeBoolean(true);
        }
                    writeMessage = false;
    /**
     * @param length the number of bytes to write
                case ArrayIndexOutOfBoundsException ignored -> {
            writeInt(bytes.length());
import org.apache.lucene.util.BytesRefBuilder;
    /**
    private static Class<?> getGenericType(Object value) {
        if (value == null) {
        writeVInt(values.length);
    }
     * write map to stream with consistent order
    }
        writeException(throwable, throwable, 0);
            o.writeString(v.toString());
     * Writes a {@link NamedWriteable} to the current stream, by first writing its name and then the object itself
                }
    /**
/**
        }
     */
     * Write an optional {@link NamedWriteable} to the stream.
    public void writeOptionalZoneId(@Nullable ZoneId timeZone) throws IOException {
            o.writeByte((byte) 21);
            }
 * reading and writing on the screen. It also means that the methods on this class are named very similarly to {@link StreamInput}. Finally
            final Object[] list = (Object[]) v;
     * Writes an optional bytes reference including a length header. Use this if you need to differentiate between null and empty bytes
            o.writeVInt(bytes.length);
    public void writeFloatArray(float[] values) throws IOException {
     * Writes an array of bytes.
                writeString(s);
     */
                checkWriteable(v);
            throw new IllegalStateException("Negative longs unsupported, use writeLong or writeZLong for negative numbers [" + i + "]");
        }
        buffer[index++] = ((byte) i);
    public void writeGenericValue(@Nullable Object value) throws IOException {
        } else {
         * Shortcut writing single byte because it is very, very common and
            }
        writeBytes(buffer, 0, 8);
    private Set<String> features = Collections.emptySet();
        }
        writeVInt(array.length);
     */
            o.writeByte((byte) 27);
        writeBytes(buffer, 0, index);
    /**
        buffer[1] = (byte) (i >> 48);
        writers.put(Integer.class, (o, v) -> {
        for (String s : array) {
import org.opensearch.semver.SemverRange;
        writeArray((out, value) -> value.writeTo(out), array);
    }
     * @param collection the collection of objects
     *
     *
            }
 * @opensearch.api
            writeBytesReference(new BytesArray(secureStrBytes));
                    writeVInt(18);
                    writeBoolean(rejectedEx.isExecutorShutdown());
     * Writes an int in a variable-length format.  Writes between one and
            } else {
    /**
    }
        writeString(buildType.displayName());
        }
            }
            writeBoolean(true);
    }
        int index = 0;
     * Writes a non-negative long in a variable-length format. Writes between one and ten bytes. Smaller values take fewer bytes. Negative
        byte[] buffer = scratch.get();
    }
        writeBytes(buffer, 0, 2);
        writers.put(Double.class, (o, v) -> {
    }
            o.writeFloat((float) v);
     * Writes a single byte.
            o.writeVInt(list.size());
        });
                        writeInt(t.getMinVersion());
    public void writeDouble(double v) throws IOException {
    public void writeOptionalInt(@Nullable Integer integer) throws IOException {
            writeBoolean(true);
        }
            i >>>= 7;
                    if (t.getVersion() == null) {
        writeVInt(list.size());
            o.writeLong(((Date) v).getTime());
        } else {
        } else {
        if (b == null) {
            if (offset > buffer.length - 3) {
     * Writes a list of {@link NamedWriteable} objects.
                    writeVInt(13);
                    writeCause = false;
        writeVInt(values.length);
    public void writeBytes(byte[] b, int length) throws IOException {
import org.opensearch.core.common.bytes.BytesArray;
        for (long value : values) {
     * Closes this stream to further operations.
        } else if (value instanceof Map) {
    public void writeOptionalTimeValue(@Nullable TimeValue timeValue) throws IOException {
        if (type == List.class) {
 * ownership. Elasticsearch licenses this file to you under
            o.writeBytesReference((BytesReference) v);
     * Write a {@link Map} of {@code K}-type keys to {@code V}-type {@link List}s.
        } finally {
        });
            }
        }
        if (integer == null) {
            }
     * {@link #writeVLong(long)} instead.
        }
        writers.put(Short.class, (o, v) -> {
     * @param offset the offset in the byte array
            writeBoolean(false);
     *
     */
    /**
            writeBoolean(true);
    }
        if (v == null) {
            writeFloat(floatValue);
                    writeCause = false;
                writeException(rootException, throwable.getCause(), nestedLevel + 1);
            assert failOnTooManyNestedExceptions(rootException);
                }
            o.writeByte((byte) 4);
            writeInt(value);
            o.writeByte((byte) 20);
            writeVInt(0);
    public <T extends Writeable> void writeOptionalWriteable(final Writer<T> writer, @Nullable T writeable) throws IOException {
                        case AccessDeniedException ignored -> writeVInt(5);
                case IllegalStateException ignored -> writeVInt(14);
            try {
    public void writeBytesReference(@Nullable BytesReference bytes) throws IOException {
            o.writeByte((byte) 3);
                    writeCause = false;
            o.writeByte((byte) 0);
     * {@link StreamInput#readList(Writeable.Reader)}.
        }
     * <pre><code>
        assert false == (map instanceof LinkedHashMap);
        }
    public void writeOptionalText(@Nullable Text text) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            for (Object v : array) {
     * @param features the features on the stream
    public void writeNamedWriteableList(List<? extends NamedWriteable> list) throws IOException {
            final byte[] secureStrBytes = CharArrays.toUtf8Bytes(secureStr.getChars());
         * than hand unrolling the entire encoding loop but hand unrolling
            return;
            writeBoolean(false);
        Map<Class<?>, Writer<Object>> writers = new HashMap<>();
        });
                case FileNotFoundException ignored -> {
            o.writeDoubleArray((double[]) v);
        throw new UnsupportedOperationException();
        buffer[2] = (byte) (i >> 8);
     * using {@link #writeInt}
                    if (throwable instanceof OpenSearchException osEx && OpenSearchException.isRegistered(throwable.getClass(), version)) {
    }
        if (!text.hasBytes()) {
                    writeInt(tooNewEx.getVersion());
                    writeVInt(12);
            this.writeString(next.getKey());
    }
        for (final T val : collection) {
     * Writes an array of bytes.
                    writeCause = false;
                o.writeByte((byte) 25);
    public void setFeatures(final Set<String> features) {
     * Writes an array of bytes.
            final int c = str.charAt(i);
            }
                        writeBoolean(true);
    /**
     */
            .iterator();
            writeBoolean(false);
 */
        writeString(build.hash());
        final byte[] buffer = scratch.get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final Class<?> type = getGenericType(value);
                buffer[offset++] = ((byte) (0xE0 | c >> 12 & 0x0F));
        Class<?> registeredClass = WriteableRegistry.getCustomClassFromInstance(value);
        } else {
            writeException(new IllegalStateException("too many nested exceptions"));
            writeBoolean(false);
                case CorruptIndexException corruptEx -> {
            writeVInt(0);
     *
         * benchmarks of methods that use this method are slower.
            for (Object v : set) {
            writeBoolean(false);
                    writeCause = false;
                }
    }
    public void writeVIntArray(int[] values) throws IOException {
import org.opensearch.Build;
            value >>>= 7;
        }
 * on {@link StreamInput}.
    /**
            @SuppressWarnings("rawtypes")
                    writeOptionalString(fsEx.getReason());
    private static byte ZERO = 0;
    }
        writeBoolean(build.isSnapshot());
     * {@link StreamInput#readList(Writeable.Reader)}.
     * Writes an array of bytes.
            writeInt(-1);
        }
            }
        if (enumSet != null && enumSet.size() > 0) {
        } else if (value instanceof Object[]) {
        writeBytes(buffer, offset);
        buffer[3] = (byte) (i >> 32);
 */
        });
    public <E extends Enum<E>> void writeEnumSet(EnumSet<E> enumSet) throws IOException {
                case FileSystemException fsEx -> {
        writers.put(Object[].class, (o, v) -> {
            BytesReference bytes = text.bytes();
     * Writes an {@link Instant} to the stream, which could possibly be null
import java.nio.file.NoSuchFileException;
    public void writeBytesRef(BytesRef bytes) throws IOException {
    public final void writeShort(short v) throws IOException {
        }
    public abstract void reset() throws IOException;
        writeBytes(b, 0, b.length);
    /**
        if (registeredClass != null) {
        }
        }
     */
            for (Object item : list) {
    public void writeInt(int i) throws IOException {
    }
        final Build.Type buildType = build.type();
import java.nio.file.FileAlreadyExistsException;
        Iterator<? extends Map.Entry<String, ?>> iterator = map.entrySet()
     * Write an optional {@link TimeValue} to the stream.
 * Unless required by applicable law or agreed to in writing,
    /**
            .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
        writeVInt(charCount);
            switch (throwable) {
                        case DirectoryNotEmptyException ignored -> writeVInt(2);
     * </code></pre>
     * Returns the registered writer for the given class type.
                case IndexFormatTooNewException tooNewEx -> {
                    writeMessage = false;
    }
     * @throws IOException if an I/O exception occurs writing the collection
 *
                o.writeGenericValue(item);
     */
    }
        for (long value : values) {
     * Write a {@linkplain ZoneId} to the stream.
    }
                    ex.writeTo(this);
     */
        }
     * Writes a long as eight bytes.
import org.opensearch.core.common.bytes.BytesReference;
        // zig-zag encoding cf. https://developers.google.com/protocol-buffers/docs/encoding?hl=en
            o.writeByte((byte) 15);
 * the Apache License, Version 2.0 (the "License"); you may
        if (floatValue == null) {
     * </code></pre>
    /**
     * out.writeMapOfLists(map, StreamOutput::writeString, StreamOutput::writeString);
                o.writeGenericValue(item);
         * This is philosophically in line with vint in general - it biases
        } else {
        writeString(build.date());
            Map<String, Object> map = (Map<String, Object>) value;
    public abstract void writeByte(byte b) throws IOException;
     * @throws IOException if an I/O exception occurs writing the collection
        } else {
    }
     *
                    writeMessage = false;
        for (final Map.Entry<K, V> entry : map.entrySet()) {
        writeOptionalArray((out, value) -> value.writeTo(out), array);
            o.writeLong(zonedDateTime.toInstant().toEpochMilli());
     * @param valueWriter The value writer
        writeOptionalWriteable((out, writable) -> writable.writeTo(out), writeable);
     */
    }
            writeVInt(0);
        writers.put(Long.class, (o, v) -> {
     */
    public void write(int b) throws IOException {
            o.writeByte((byte) 7);
            writeVLong(value);
     * Writes an optional {@link Integer}.
        } else {
        }
        buffer[5] = (byte) (i >> 16);
        writers.put(List.class, (o, v) -> {
     */
    }
                buffer[offset++] = ((byte) (0x80 | c >> 6 & 0x3F));
        } else {
    }
        long value = BitUtil.zigZagEncode(i);
    public final void writeInstant(Instant instant) throws IOException {
        if (timeZone == null) {
            writeEnum(e);
    }
     * different key-value orders, they will maybe have different stream order.
            valueWriter.write(this, entry.getValue());
    /**
 * under the License.
            final ZonedDateTime zonedDateTime = (ZonedDateTime) v;
        }
    @SuppressWarnings("unchecked")
                    writeVInt(8);
                }
        writeVInt(version.id);
        writeLong(Double.doubleToLongBits(v));
import org.opensearch.core.common.io.stream.Writeable.Writer;
            writeInt(integer);
    }
    public void writeOptionalWriteable(@Nullable Writeable writeable) throws IOException {
                        default -> writeVInt(7);
                offset = 0;
        throw new AssertionError("too many nested exceptions", throwable);
            o.writeByte((byte) 11);
                o.writeString(entry.getKey());
            writeByte(TWO);
    public static void checkWriteable(@Nullable Object value) throws IllegalArgumentException {
    public final void writeBigInteger(BigInteger v) throws IOException {
import java.util.LinkedHashMap;
        for (float value : values) {
                case LockObtainFailedException ignored -> writeVInt(15);
                    writeVInt(16);
            writeBoolean(false);
        } else {
     * Map&lt;String, List&lt;String&gt;&gt; map = ...;
        writers.put(String.class, (o, v) -> {
            return;
                case InterruptedException ignored -> {
import java.util.Iterator;
    public void writeOptionalBoolean(@Nullable Boolean b) throws IOException {
        buffer[3] = (byte) i;
        }
                    writeCause = false;
        }
     */
                        case FileSystemLoopException ignored -> writeVInt(6);
    public void writeText(Text text) throws IOException {
     */
        } else {
     *
    /**
        for (int value : values) {
import org.apache.lucene.store.LockObtainFailedException;
    @Override
 * You may obtain a copy of the License at
                        case NoSuchFileException ignored -> writeVInt(0);
     * Writes the specified array of {@link Writeable}s. This method can be seen as
    public void writeOptionalStringCollection(final Collection<String> collection) throws IOException {
        writers.put(long[].class, (o, v) -> {
     * Writes the bytes reference, including a length header.
        writers.put(BytesRef.class, (o, v) -> {
            } finally {
    public void writeZLong(long i) throws IOException {
        buffer[index++] = (byte) (value & 0x7F);
     */
                buffer[offset++] = ((byte) (0xC0 | c >> 6 & 0x1F));
import java.time.Instant;
import org.opensearch.common.Nullable;
        if (l == null) {
        writeString(namedWriteable.getWriteableName());
        if (namedWriteable == null) {
     */
     * e.g., 0 -;&gt; 0, -1 -;&gt; 1, 1 -;&gt; 2, ..., Long.MIN_VALUE -;&gt; -1, Long.MAX_VALUE -;&gt; -2
        });
    public void writeSemverRange(final SemverRange range) throws IOException {
            write(spare.bytes(), 0, spare.length());
    /**
    }
     */
        writeVInt(values.length);
     * Writes a long in a variable-length format without first checking if it is negative. Package private for testing. Use
    /**
            writeBoolean(false);
    }
     * Writes a collection of objects via a {@link Writer}.
            writeString(str);
    static {
            writeVInt(value);
            writeBoolean(true);
        writeZLong(timeValue.duration());
            writeZoneId(timeZone);
     * integer is first written to the stream, and then the elements of the array are written to the stream.
    public <T> void writeCollection(final Collection<T> collection, final Writer<T> writer) throws IOException {
     * writer version of {@link StreamInput#readArray(Writeable.Reader, IntFunction)}. The length of array encoded as a variable-length
            throw new IllegalArgumentException("Cannot write type [" + type.getCanonicalName() + "] to stream");
    }
/*
        }
    public void writeLong(long i) throws IOException {
        for (T value : array) {
        }
import java.nio.file.DirectoryNotEmptyException;
                    writeInt(tooNewEx.getMinVersion());
                case IllegalArgumentException ignored -> writeVInt(6);
                    writeVInt(2);
     * serialized to indicate whether the array was null or not.
            if (writeMessage) {
            o.writeBytes(bytes);
        });
                default -> {
 * The OpenSearch Contributors require contributions made to
        buffer[2] = (byte) (i >> 40);
    /**
    }
    public void writeMap(@Nullable Map<String, Object> map) throws IOException {
    /**
        }
        }
    }
        } else if (type == Object[].class) {
    /**
            o.writeInt((Integer) v);
        } else {
        writers.put(Map.class, (o, v) -> {
import org.apache.lucene.util.BitUtil;
                checkWriteable(entry.getKey());
            writer.write(this, value);
    }
import java.nio.file.AtomicMoveNotSupportedException;
import java.util.HashSet;
    public <E extends Enum<E>> void writeOptionalEnumSet(@Nullable EnumSet<E> enumSet) throws IOException {
     * @param b      the bytes to write
     */
            writeBoolean(false);
            // fallback to this local hashmap
     * This method is compatible with {@code StreamInput.readMap} and {@code StreamInput.readGenericValue}
            return;
    public <T> void writeArray(final Writer<T> writer, final T[] array) throws IOException {
import java.io.EOFException;
                }
 * it means that the "barrier to entry" for adding new methods to this class is relatively low even though it is a shared class with code
    }
        int index = 0;
            o.writeByte((byte) 16);
     * The version of the node on the other side of this stream.
    }
     * serialized to indicate whether the array was null or not.
    }
        }
            boolean writeCause = true;
                o.writeByte((byte) 24);
import org.opensearch.OpenSearchException;
     *
            o.writeString((String) v);
    }
        } else {
    }
        }
            o.writeIntArray((int[]) v);
        // TODO: improve serialization of BigInteger
 *
        } else {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                    writeVInt(4);
     */
    }
        } else if (value instanceof Set) {
     * @param keyWriter The key writer
        writeVInt(bytes.length() + 1);
        writeCollection(collection, (o, v) -> v.writeTo(o));
        writeByte((byte) b);
        }
            writer.write(this, val);
    }
                buffer[offset++] = ((byte) c);
            @SuppressWarnings("unchecked")
    public <T> void writeOptionalArray(final Writer<T> writer, final @Nullable T[] array) throws IOException {
    public void writeOptionalVLong(@Nullable Long l) throws IOException {
package org.opensearch.core.common.io.stream;
        final byte[] secureStrBytes = CharArrays.toUtf8Bytes(secureStr.getChars());
    public void writeBoolean(boolean b) throws IOException {
            o.writeByte((byte) 12);
     * Set the version of the node on the other side of this stream.
    }
         * the encoding loop blows out the method size so it can't be inlined.
    /**
        writeVInt(bytes.length);
            writeBoolean(false);
            writeEnumSet(enumSet);
        writeVInt(enumValue.ordinal());
        writeVInt(b.length);
import org.opensearch.common.annotation.PublicApi;
        while ((i & ~0x7F) != 0) {
     */
     * Forces any buffered output to be written.
            if (c <= 0x007F) {
        });
        buffer[0] = (byte) (i >> 56);
                        writeInt(t.getMaxVersion());
    public <T extends Writeable> void writeArray(T[] array) throws IOException {
                case AlreadyClosedException ignored -> writeVInt(7);
    /** Writes the OpenSearch {@link Build} informn to the output stream */
        if (collection != null) {
    /**
                case IndexFormatTooOldException t -> {
     * Writes a long in a variable-length format. Writes between one and ten bytes.
        this.features = Collections.unmodifiableSet(new HashSet<>(features));
     * Writes an optional EnumSet with type E that serializes each enum based on its ordinal value
                }
        });
            writer.write(this, writeable);
                Arrays.fill(secureStrBytes, (byte) 0);
    public Set<String> getFeatures() {
        } else if (nestedLevel > MAX_NESTED_EXCEPTION_LEVEL) {
        } else {
        }
            }
        return this.version;
import java.math.BigInteger;
        writeBytes(b, 0, b.length);
        });
     *
        }
        if (array == null) {
                case EOFException ignored -> {
    }
     * @param valueWriter The value writer
     * negative numbers.
     * to make sure every map generated bytes order are same.
import java.io.IOException;
        } else if (value instanceof List) {
                    switch (throwable) {
     * Writes the specified array to the stream using the specified {@link Writer} for each element in the array. This method can be seen as
            buffer[index++] = (byte) ((value & 0x7F) | 0x80);
        }
            writeDouble(value);
    /**
    }
        throws IOException {
            throw new IllegalArgumentException("can not write type [" + type + "]");
        bytes.writeTo(this);
        } else if (type == Set.class) {
        });
    }
        writeString(build.getQualifiedVersion());
     * Writes a collection to this stream. The corresponding collection can be read from a stream input using
     * @throws IOException if an I/O exception occurs while writing the array
        if (instant == null) {
    public void writeOptionalVInt(@Nullable Integer integer) throws IOException {
 * not use this file except in compliance with the License.
        buffer[7] = (byte) i;
    }
            o.writeSemverRange((SemverRange) v);
    }
import java.io.FileNotFoundException;
import org.apache.lucene.index.IndexFormatTooOldException;
    }
    /**
            o.writeLong((Long) v);
         * can skip grabbing the scratch buffer. This is marginally slower
            writeBoolean(false);
    }
     *
    public Version getVersion() {
    public <E extends Enum<E>> void writeEnum(E enumValue) throws IOException {
    /**
        });
            writeFloat(value);
        }
     */
            Map.Entry<String, ?> next = iterator.next();
            } else {
        writers.put(BytesReference.class, (o, v) -> {
                    writeOptionalString(fsEx.getFile());
    }
     * Write an optional {@linkplain ZoneId} to the stream.
     * {@link StreamInput#readList(Writeable.Reader)}.
        writeVInt(enumSet.size());
 * license agreements. See the NOTICE file distributed with
        writeLong(instant.getEpochSecond());
        } else {
            for (String s : array) {
            for (Object v : list) {
            } else {
        byte[] buffer = scratch.get();
            writeVInt(0);
        writers.put(int[].class, (o, v) -> {
            o.writeBoolean((boolean) v);
        }
            o.writeByte((byte) 2);
     */
    }
            }
        int index = 0;
        }
     * five bytes.  Smaller values take fewer bytes.  Negative numbers
    }
                writeBytes(buffer, offset);
    }
        if (writer == null) {
        } else {
    public void writeSecureString(SecureString secureStr) throws IOException {
         * In that case benchmarks of the method itself are faster but
            writeBoolean(true);
            writeBoolean(false);
    public void writeOptionalDouble(@Nullable Double v) throws IOException {
                    writeCause = false;
        return this.features;
    public void writeOptionalFloat(@Nullable Float floatValue) throws IOException {
    /**
     *
     * Writes a list of {@link Writeable} objects
     * Map&lt;String, String&gt; map = ...;
        } else {
     */
    }
import org.apache.lucene.util.BytesRef;
        writeGenericValue(map);
     */
    /**
        buffer[6] = (byte) (i >> 8);
            boolean writeMessage = true;
        if (secureStr == null) {
        if (array == null) {
        writeVInt(values.length);
    public <K, V> void writeMap(final Map<K, V> map, final Writer<K> keyWriter, final Writer<V> valueWriter) throws IOException {
        writeVInt(collection.size());
import java.util.Set;
        writeVInt(array.length);
    public void writeString(String str) throws IOException {
 * This class's methods are optimized so you can put the methods that read and write a class next to each other and you can scan them
        if (timeValue == null) {
    /**
            }
    private static final Map<Class<?>, Writer<Object>> WRITERS;
import java.nio.file.NotDirectoryException;
     */
        if (array == null) {
        do {
            keyWriter.write(this, entry.getKey());
    public void write(byte[] b, int off, int len) throws IOException {
            writeBoolean(true);
            o.writeByte((byte) 6);
                    } else {
     * will always use all 5 bytes and are therefore better serialized
    private static byte ONE = 1;
        }
            return Set.class;
     * Writes an optional collection of a strings. The corresponding collection can be read from a stream input using
     * Writes an EnumSet with type E that by serialized it based on it's ordinal value
    }
    /**
     * @param feature the feature to test
     * If the numbers are known to be non-negative, use {@link #writeVLong(long)}
    }
                checkWriteable(entry.getValue());
                    writeOptionalString(corruptEx.getOriginalMessage());
        writers.put(Byte.class, (o, v) -> {
    /**
                case SecurityException ignored -> writeVInt(9);
        if (map == null) {
        writer.write(this, value);
            writeBoolean(true);
                    writeCause = false;
    public void writeOptionalBytesReference(@Nullable BytesReference bytes) throws IOException {
    public void writeVLong(long i) throws IOException {
        });
                case NumberFormatException ignored -> {
                }
    }
     */
            writeInstant(instant);
        } else {
import org.apache.lucene.index.CorruptIndexException;
     */
    }
            return value.getClass();
            writeBoolean(true);
            return;
        if (i < 0) {
    public boolean hasFeature(final String feature) {
     */
    /**
    /**
        } else if (type == Map.class) {
        });
        while ((value & 0xFFFFFFFFFFFFFF80L) != 0L) {
    }
    }
        final byte[] buffer = scratch.get();
            o.writeVInt(map.size());
    public void writeFloat(float v) throws IOException {
                writeOptionalBytesReference(new BytesArray(secureStrBytes));
public abstract class StreamOutput extends OutputStream {
                case NullPointerException ignored -> {
        } else if (WRITERS.containsKey(type) == false) {
     */
     * Numbers with small absolute value will have a small encoding
        });
     * numbers use ten bytes and trip assertions (if running in tests) so prefer {@link #writeLong(long)} or {@link #writeZLong(long)} for
                        writeBoolean(false);
     *
                    writeVInt(3);
        }
    }
        });
            writeInt(spare.length());
    private void writeException(Throwable rootException, Throwable throwable, int nestedLevel) throws IOException {
                    writeVInt(1);
    public void writeVLongArray(long[] values) throws IOException {
    /**
 * this work for additional information regarding copyright
        for (double value : values) {
import java.util.Map;
            writeVLong(l);
        /*
            writeBoolean(true);
            o.writeShort((Short) v);
        for (int value : values) {
            writeBoolean(false);
import java.util.LinkedHashSet;
        buffer[0] = (byte) (i >> 24);
        writeBytes(buffer, 0, index);
        } else {
        writeInt(instant.getNano());
                        writeOptionalString(t.getReason());
        if (bytes == null) {
            writeBoolean(true);
        if (text == null) {
     * <pre><code>
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
     * @param <T>    the type of the elements of the array
     * Notice: when serialization a map, the stream out map with the stream in map maybe have the
import java.nio.file.AccessDeniedException;
     */
        writeVInt(values.length);
     * out.writeMap(map, StreamOutput::writeString, StreamOutput::writeString);
                }
            bytes.writeTo(this);
     */
            writeBoolean(false);
        writers.put(Text.class, (o, v) -> {
    public void seek(long position) throws IOException {
    protected boolean failOnTooManyNestedExceptions(Throwable throwable) {
            return;
        writers.put(Set.class, (o, v) -> {
    public void writeStringArray(String[] array) throws IOException {
        }
     * @param b      the bytes to write
    private static byte TWO = 2;
        for (int i = 0; i < charCount; i++) {
    }
                o.writeByte((byte) 10);
            writeText(text);
        } else if (value instanceof BytesReference) {
        });
            return;
        }
    }
    }
        });
            buffer[index++] = ((byte) ((i & 0x7f) | 0x80));
 * lists, either by storing {@code List}s internally or just converting to and from a {@code List} when calling. This comment is repeated
        }
        });
import java.nio.file.FileSystemException;
        writeString(range.toString());
import org.opensearch.common.unit.TimeValue;
                    writeOptionalString(t.getResourceDescription());
        final Writer<Object> writer = getWriter(type);
     * Same as {@link #writeArray(Writer, Object[])} but the provided array may be null. An additional boolean value is
     */
 * <p>
        while (iterator.hasNext()) {
/*
        });
                case OpenSearchRejectedExecutionException rejectedEx -> {
                    writeVInt(0);
    public void writeByteArray(byte[] b) throws IOException {
            o.writeFloatArray((float[]) v);
            i >>>= 7;
            }
    }
         * twoards being simple and fast for smaller numbers.
        }
    public abstract void close() throws IOException;
     * @param b the bytes to write
     * If want to keep stream out map and stream in map have the same stream order when stream,
            } else if (c > 0x07FF) {
        this.version = version;
            o.writeByte((byte) 8);
            writeBoolean(false);
    /**
    public static <W extends Writer<?>> W getWriter(Class<?> type) {
    public void writeList(List<? extends Writeable> list) throws IOException {
        }
    }
import java.util.Arrays;
            if (writeCause) {
        } else {
                        case AtomicMoveNotSupportedException ignored -> writeVInt(3);
        }
        buffer[4] = (byte) (i >> 24);
    }
     * Writes a string array, for nullable string, writes it as 0 (empty string).
                        case NotDirectoryException ignored -> writeVInt(1);
    public void writeOptionalStringArray(@Nullable String[] array) throws IOException {
            o.writeByte((byte) 1);
        writeVInt(bytes.length());
        writeBytes(b, 0, length);
        if (throwable == null) {
            o.writeByte((byte) 18);
        });
        if (Integer.numberOfLeadingZeros(i) >= 25) {
            @SuppressWarnings("unchecked")
    public void writeOptionalNamedWriteable(@Nullable NamedWriteable namedWriteable) throws IOException {
     */
        final byte[] buffer = scratch.get();
        writeVInt(values.length);
            writeLong(l);
                buffer[offset++] = ((byte) (0x80 | c >> 0 & 0x3F));
                checkWriteable(v);
            Arrays.fill(secureStrBytes, (byte) 0);
                    } else {
import java.time.ZonedDateTime;
                buffer[offset++] = ((byte) (0x80 | c >> 0 & 0x3F));
    private static final int MAX_NESTED_EXCEPTION_LEVEL = 100;
                        ex = new NotSerializableExceptionWrapper(throwable);
    public abstract void flush() throws IOException;
        });
import java.util.HashMap;
import org.apache.lucene.index.IndexFormatTooNewException;
     */
    @Override
            o.writeByte((byte) 23);
            // we need at most 3 bytes so we flush the buffer once we have less than 3 bytes
     * Write a {@link Map} of {@code K}-type keys to {@code V}-type.
    }
            // make sure any possible char can fit into the buffer in any possible iteration
    }
     */
 * software distributed under the License is distributed on an
            writer = WRITERS.get(type);
            .stream()
 * Modifications Copyright OpenSearch Contributors. See
     * Values are remapped by sliding the sign bit into the lsb and then encoded as an unsigned number
            return List.class;
            List<Object> list = (List<Object>) value;
    public void writeZoneId(ZoneId timeZone) throws IOException {
            }
    public void writeException(Throwable throwable) throws IOException {
     * @param collection the collection to write to this stream
    public void writeDoubleArray(double[] values) throws IOException {
                        ex = osEx;
        this.writeVInt(map.size());
    public void setVersion(Version version) {
    public void writeOptionalSecureString(@Nullable SecureString secureStr) throws IOException {
        writeByte(b ? ONE : ZERO);
     */
     */
            // todo: move all writers to the registry
        writers.put(byte[].class, (o, v) -> {
        });
            writeByte((byte) -1);
    public void writeStringCollection(final Collection<String> collection) throws IOException {
        if (str == null) {
 *
import java.util.List;
            writeBoolean(true);
 * KIND, either express or implied.  See the License for the
                    }
                case StringIndexOutOfBoundsException ignored -> {
    public void writeNamedWriteable(NamedWriteable namedWriteable) throws IOException {
            o.writeCollection((Set<?>) v, StreamOutput::writeGenericValue);
        if (writeable != null) {
            writeVInt(array.length);
    private static final ThreadLocal<byte[]> scratch = ThreadLocal.withInitial(() -> new byte[1024]);
            o.writeLongArray((long[]) v);
        }
        throw new UnsupportedOperationException();
     * Writes a boolean.
import org.opensearch.Version;
                    writeOptionalString(corruptEx.getResourceDescription());
                    writeOptionalString(fsEx.getOtherFile());
            for (Object item : list) {
            writeBoolean(true);
    /**
            writeNamedWriteable(obj);
        writers.put(SemverRange.class, (o, v) -> {
 *
            writeBoolean(b);
        writeInt(Float.floatToIntBits(v));
     * Set the features on the stream. See {@link StreamOutput#hasFeature(String)}.
        writeString(v.toString());
     * Writes a string array, for nullable string, writes false.
            o.writeByte((byte) 5);
        buffer[1] = (byte) v;
        }
    public void writeVLongNoCheck(long i) throws IOException {
