        writers.put(List.class, (o, v) -> {
    }
 * GitHub history for details.
    /**
                buffer[offset++] = ((byte) (0xC0 | c >> 6 & 0x1F));  
            writeLong(value);  
        }
    }  
     */
        writeVInt(collection.size());
/**
    public void writeTimeValue(TimeValue timeValue) throws IOException {  
        }  
import org.apache.lucene.util.BytesRefBuilder;
 * You may obtain a copy of the License at  
import org.opensearch.OpenSearchException;
        } else {
        writeString(build.date());
 * it means that the "barrier to entry" for adding new methods to this class is relatively low even though it is a shared class with code
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        }
    public final void writeOptionalInstant(@Nullable Instant instant) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
    /**
            }
            o.writeByte((byte) 16);
     * Writes a long in a variable-length format. Writes between one and ten bytes.  
    public void writeMapWithConsistentOrder(@Nullable Map<String, ? extends Object> map) throws IOException {
        if (type == List.class) {
    @Override
    private void writeException(Throwable rootException, Throwable throwable, int nestedLevel) throws IOException {
    }
                    writeVInt(18);
            final int c = str.charAt(i);
        }
 * lists, either by storing {@code List}s internally or just converting to and from a {@code List} when calling. This comment is repeated
            o.writeLong((Long) v);
        writeMap(map, keyWriter, (stream, list) -> {
        Map<Class<?>, Writer<Object>> writers = new HashMap<>();  
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * Write an optional {@link NamedWriteable} to the stream.
public abstract class StreamOutput extends OutputStream {
    public boolean hasFeature(final String feature) {
     * Writes an array of bytes.
            writeBoolean(true);  
    public <K, V> void writeMap(final Map<K, V> map, final Writer<K> keyWriter, final Writer<V> valueWriter) throws IOException {
            o.writeLong(((Date) v).getTime());
            o.writeByte((byte) 27);
        if (integer == null) {  
     */  
    }
            o.writeByte((byte) 14);
                    writeVInt(8);  
    }  
    public abstract void writeBytes(byte[] b, int offset, int length) throws IOException;
        throws IOException {
    /**
import org.apache.lucene.index.IndexFormatTooNewException;
    public void writeNamedWriteableList(List<? extends NamedWriteable> list) throws IOException {
import java.nio.file.NotDirectoryException;
    }  
     * @param valueWriter The value writer
            final Object[] list = (Object[]) v;  
    }
                Arrays.fill(secureStrBytes, (byte) 0);  
        }  
    /**
            }  
import org.opensearch.core.common.bytes.BytesArray;
        }
    }
        } else {
        writeCollection(collection, StreamOutput::writeString);
        if (str == null) {
     */
            writeOptionalBytesReference(null);  
            o.writeBytesRef((BytesRef) v);
    public void writeBoolean(boolean b) throws IOException {  
    public void writeBytes(byte[] b) throws IOException {
     * Set the version of the node on the other side of this stream.
     * integer is first written to the stream, and then the elements of the array are written to the stream.
            final Map<String, Object> map = (Map<String, Object>) v;
        if (collection != null) {  
        if (l == null) {
            value >>>= 7;
            writeNamedWriteable(namedWriteable);
     */  
                    writeBoolean(rejectedEx.isExecutorShutdown());  
            bytes.writeTo(this);  
        });
            writeBoolean(true);  
     * @param writer the writer used to write individual elements  
        } while ((i & ~0x7F) != 0);
     *
    /**  
                case IndexFormatTooOldException t -> {
    public void writeVInt(int i) throws IOException {  
     * @param b      the bytes to write  
    /**  
     * @param b the bytes to write  
    }
        });
    public abstract void writeByte(byte b) throws IOException;
    }  
     * Writes a non-negative long in a variable-length format. Writes between one and ten bytes. Smaller values take fewer bytes. Negative  
     */
    public void writeBuild(final Build build) throws IOException {  
     * @param <T>    the type of the elements of the array
                }
 */
        writeString(range.toString());
    public void writeText(Text text) throws IOException {  
    }  
            for (Object v : list) {
            write(spare.bytes(), 0, spare.length());
        });  
     * write map to stream with consistent order
    /**
        } else if (type == Object[].class) {
        writeVInt(version.id);
    public void writeVIntArray(int[] values) throws IOException {
                }  
                    writeVInt(13);
                }
     * This method is compatible with {@code StreamInput.readMap} and {@code StreamInput.readGenericValue}
 */  
    /**
     */  
                case IllegalArgumentException ignored -> writeVInt(6);  
     * writer version of {@link StreamInput#readArray(Writeable.Reader, IntFunction)}. The length of array encoded as a variable-length  
        for (double value : values) {
            writeBoolean(false);  
            o.writeByte((byte) 18);  
        writeString(build.getDistribution());
                        case AtomicMoveNotSupportedException ignored -> writeVInt(3);
        writeString(timeZone.getId());
        // the following is new for opensearch: we write the distribution name to support any "forks" of the code
        if (floatValue == null) {  
        writeVInt(bytes.length());
    public void writeDouble(double v) throws IOException {  
        writeInt(instant.getNano());  
        }  
        });  
     * Writes an optional bytes reference including a length header. Use this if you need to differentiate between null and empty bytes  
        if (l == null) {  
    public void writeInt(int i) throws IOException {  
        writeBytes(buffer, offset);
     * Same as {@link #writeArray(Writer, Object[])} but the provided array may be null. An additional boolean value is
        // Have registered ScriptedAvg class with byte 28 in Streamables.java, so that we do not need the implementation reside in the
            writeBoolean(false);
        } else {
            writeDouble(v);  
        int index = 0;
            o.writeSemverRange((SemverRange) v);  
    }
            writeVInt(0);
                default -> {  
                case IndexFormatTooNewException tooNewEx -> {
import java.util.List;  
     * @throws IOException if an I/O exception occurs writing the collection  
            writer.write(this, val);
        writers.put(BytesRef.class, (o, v) -> {
        buffer[3] = (byte) (i >> 32);  
import org.opensearch.Build;  
     * @throws IOException if an I/O exception occurs while writing the array  
    public final <K, V> void writeMapOfLists(final Map<K, List<V>> map, final Writer<K> keyWriter, final Writer<V> valueWriter)  
                    writeMessage = false;
    public void writeMap(@Nullable Map<String, Object> map) throws IOException {  
     * serialized to indicate whether the array was null or not.
    /**
        writeBytes(b, 0, b.length);
     */
        byte[] buffer = scratch.get();  
            writeVInt(array.length);
        });
     * Writes a collection to this stream. The corresponding collection can be read from a stream input using
            } finally {
     * Set the features on the stream. See {@link StreamOutput#hasFeature(String)}.
            writeBoolean(true);  
 * this work for additional information regarding copyright
     * will always use all 5 bytes and are therefore better serialized  
        for (String s : array) {
            writeBoolean(true);
        writeByte((byte) b);
     * Write an optional {@linkplain ZoneId} to the stream.
    @Override
        writers.put(float[].class, (o, v) -> {  
    public void writeOptionalFloat(@Nullable Float floatValue) throws IOException {
            writeBoolean(true);
        assert this.features.isEmpty() : this.features;  
            writeBytesReference(new BytesArray(secureStrBytes));
    }  
    /** Writes the OpenSearch {@link Version} to the output stream */
        for (E e : enumSet) {  
     */  
            }
    }  
    static {
    private static byte ZERO = 0;
     * Writes the specified array of {@link Writeable}s. This method can be seen as
     * @param offset the offset in the byte array
        }
            o.writeFloat((float) v);  
    /**  
                    final OpenSearchException ex;
import java.time.ZoneId;  
            writeByte(TWO);  
     */
     *
            return List.class;  
        }  
import org.opensearch.semver.SemverRange;
         * This is philosophically in line with vint in general - it biases
        } else {  
            writeString(str);  
        if (integer == null) {  
        writeOptionalWriteable((out, writable) -> writable.writeTo(out), writeable);
        final Writer<Object> writer = getWriter(type);
            final byte[] secureStrBytes = CharArrays.toUtf8Bytes(secureStr.getChars());
     * @param array  the array
            for (Object item : list) {  
        for (float value : values) {
            o.writeVInt(map.size());
    }  
import java.util.Set;
        buffer[1] = (byte) (i >> 48);
    public void writeGenericValue(@Nullable Object value) throws IOException {
     * Writes a single byte.
     * @param collection the collection of strings
            o.writeVInt(list.size());
         * benchmarks of methods that use this method are slower.
                case FileSystemException fsEx -> {
            o.writeString((String) v);  
        }
            i >>>= 7;
import org.opensearch.core.common.io.stream.Writeable.Writer;
    public <T> void writeOptionalArray(final Writer<T> writer, final @Nullable T[] array) throws IOException {
 * A stream from another node to this node. Technically, it can also be streamed from a byte array but that is mostly for testing.  
    public void writeVersion(final Version version) throws IOException {  
    public void writeString(String str) throws IOException {
    public void writeVLongNoCheck(long i) throws IOException {  
            writeBoolean(false);  
        writeString(namedWriteable.getWriteableName());
    public <T> void writeArray(final Writer<T> writer, final T[] array) throws IOException {
     */
                case EOFException ignored -> {
        }
     *
        writers.put(Integer.class, (o, v) -> {
            o.writeInt((Integer) v);
     */
                offset = 0;
        });  
        if (registeredClass != null) {  
    public void writeOptionalStringCollection(final Collection<String> collection) throws IOException {
            } else {  
        }  
                writeException(rootException, throwable.getCause(), nestedLevel + 1);
        while (iterator.hasNext()) {
            writeString(s);  
    }
    }
    }  
                case InterruptedException ignored -> {
    }
    public void write(byte[] b, int off, int len) throws IOException {
    }
    }
        for (final Map.Entry<K, V> entry : map.entrySet()) {
    /**  
            o.writeByte((byte) 7);
        }
    }
            o.writeByte((byte) 23);
        if (array == null) {
     * Writes a long as eight bytes.
                case NullPointerException ignored -> {
    public <E extends Enum<E>> void writeOptionalEnumSet(@Nullable EnumSet<E> enumSet) throws IOException {  
        } else {
    }  
                }  
    }
    /**
        } else if (WRITERS.containsKey(type) == false) {
    /**
     */
            return;
        if (array == null) {
    }
        });  
import java.io.FileNotFoundException;
            writeVInt(value);
     *  
     * Writes a long in a variable-length format without first checking if it is negative. Package private for testing. Use  
import java.util.Map;
        writeBytes(buffer, 0, 2);  
            if (v instanceof LinkedHashSet) {
     */
    public final void writeBigInteger(BigInteger v) throws IOException {
        final byte[] buffer = scratch.get();  
                buffer[offset++] = ((byte) (0xE0 | c >> 12 & 0x0F));
            // todo: move all writers to the registry
    public final void writeShort(short v) throws IOException {
        }
        } else if (type == Map.class) {
            writeFloat(floatValue);
    }
            @SuppressWarnings("unchecked")  
        }
     */  
        writeVInt(map.size());  
                    writeOptionalString(corruptEx.getResourceDescription());
        assert false == (map instanceof LinkedHashMap);  
            return;
            final List list = (List) v;
 * license agreements. See the NOTICE file distributed with
    }  
    public void writeStringArray(String[] array) throws IOException {  
     */  
        } else {
            writeBoolean(true);  
            @SuppressWarnings("unchecked")
            o.writeVInt(bytes.length);
    }
        final byte[] buffer = scratch.get();
            o.writeByte((byte) 0);
        writeBytes(b, off, len);  
    }
            o.writeByte((byte) 17);
            // make sure any possible char can fit into the buffer in any possible iteration  
            writeBoolean(false);  
     */
    }
                    writeOptionalString(t.getResourceDescription());  
            o.writeByte((byte) 3);
import java.nio.file.FileSystemLoopException;
    /**
        buffer[4] = (byte) (i >> 24);
     * out.writeMap(map, StreamOutput::writeString, StreamOutput::writeString);
            o.writeByte((byte) 15);  
        writers.put(double[].class, (o, v) -> {
        } else if (value instanceof Set) {
/*
    public void writeBytesRef(BytesRef bytes) throws IOException {  
    /**  
            writeBoolean(false);
            writeInt(bytes.length());
        writers.put(Byte.class, (o, v) -> {
            writeDouble(value);  
            if (writeMessage) {
                case StringIndexOutOfBoundsException ignored -> {
            i >>>= 7;
        writers.put(Map.class, (o, v) -> {  
            writeInstant(instant);
    /**
        }
            return Object[].class;
import org.apache.lucene.util.BytesRef;
            writeBoolean(true);
                    writeVInt(4);
                buffer[offset++] = ((byte) (0x80 | c >> 0 & 0x3F));
            .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
            writer.write(this, writeable);
            return Map.class;
 * on {@link StreamInput}.
            writer.write(this, value);
    /**
        } finally {  
        });
                o.writeGenericValue(entry.getValue());
        }
            o.writeByte((byte) 21);  
     * {@link StreamInput#readList(Writeable.Reader)}.
        });  
                    writeVInt(0);
     *
    /**
                }
            writeText(text);  
            keyWriter.write(this, entry.getKey());
            writeZoneId(timeZone);  
        writers.put(Set.class, (o, v) -> {  
                    writeVInt(10);
        try {
        buffer[index++] = ((byte) i);  
                    writeVInt(16);  
    @SuppressWarnings("unchecked")
            o.writeBytesReference((BytesReference) v);  
        });  
                checkWriteable(entry.getValue());  
    }  
        writers.put(Short.class, (o, v) -> {  
            o.writeDoubleArray((double[]) v);  
                o.writeByte((byte) 10);
     */
        writeByte(b ? ONE : ZERO);
            writeBoolean(true);  
                case OpenSearchRejectedExecutionException rejectedEx -> {
                o.writeString(entry.getKey());
     * Write an optional {@link TimeValue} to the stream.  
        writers.put(Text.class, (o, v) -> {
     * different key-value orders, they will maybe have different stream order.  
        writeException(throwable, throwable, 0);
        final byte[] buffer = scratch.get();
        }
        }
        writeVInt(array.length);
     */
    public void writeBytes(byte[] b, int length) throws IOException {  
import java.nio.file.NoSuchFileException;  
     * @throws IOException if an I/O exception occurs writing the collection  
            writeVInt(list.size());  
     * Notice: when serialization a map, the stream out map with the stream in map maybe have the
    @Override  
        writers.put(Long.class, (o, v) -> {  
    /**  
    public abstract void reset() throws IOException;  
import java.util.LinkedHashMap;
        }
    public void writeFloatArray(float[] values) throws IOException {
        writers.put(SemverRange.class, (o, v) -> {
        if (Integer.numberOfLeadingZeros(i) >= 25) {
import java.math.BigInteger;
     * Writes a string array, for nullable string, writes it as 0 (empty string).
                buffer[offset++] = ((byte) (0x80 | c >> 6 & 0x3F));  
            writeEnum(e);
            o.writeString(v.toString());
            writeBoolean(false);  
            o.writeByte((byte) 1);  
                    if (throwable instanceof OpenSearchException osEx && OpenSearchException.isRegistered(throwable.getClass(), version)) {
     * @param length the number of bytes to write
     */
        final Class<?> type = getGenericType(value);  
    protected boolean failOnTooManyNestedExceptions(Throwable throwable) {  
            return;
     */  
            writeInt(value);
     * @param keyWriter The key writer
        int offset = 0;
        Iterator<? extends Map.Entry<String, ?>> iterator = map.entrySet()  
 * @opensearch.api
        }  
    public static void checkWriteable(@Nullable Object value) throws IllegalArgumentException {
         * than hand unrolling the entire encoding loop but hand unrolling
        buffer[index++] = ((byte) i);
                    writeVInt(1);
                        case NotDirectoryException ignored -> writeVInt(1);
    /**
    }
    /**
import java.util.Collections;
            writeBoolean(true);
        buffer[2] = (byte) (i >> 40);
        if (map == null) {
        Writer<Object> writer = WriteableRegistry.getWriter(type);
    /**  
        buffer[3] = (byte) i;
        writeVInt(enumValue.ordinal());
    public Set<String> getFeatures() {
        }
     * <pre><code>
            return;
        buffer[2] = (byte) (i >> 8);
    public void writeException(Throwable throwable) throws IOException {
                    writeOptionalString(fsEx.getOtherFile());
        if (value == null) {
                    return;
    }  
            writeVInt(0);
            switch (throwable) {  
        }
                    }  
        if (i < 0) {
                        ex = new NotSerializableExceptionWrapper(throwable);
            o.writeByte((byte) 2);
        if (!text.hasBytes()) {
                        case FileAlreadyExistsException ignored -> writeVInt(4);
        });
                    writeCause = false;
     */
        do {
            o.writeByte((byte) 5);
        writeBytes(buffer, 0, index);
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (int value : values) {
        }
            writeBoolean(false);
            for (Object v : array) {
 * ownership. Elasticsearch licenses this file to you under  
            writeByte((byte) -1);  
                }
    public <E extends Enum<E>> void writeEnumSet(EnumSet<E> enumSet) throws IOException {
                        case NoSuchFileException ignored -> writeVInt(0);
                    ex.writeTo(this);  
            o.writeByte((byte) 20);
     * This method only will handle the map keys order, not maps contained within the map
    public void writeFloat(float v) throws IOException {
        } else {
        return this.features;
     * @throws IOException if an I/O exception occurs writing the collection
import java.time.Instant;
        if (timeValue == null) {  
                        case FileSystemLoopException ignored -> writeVInt(6);
        }
package org.opensearch.core.common.io.stream;
        } else {
        } else {
            // left before we start another iteration
        }  
        buffer[0] = (byte) (i >> 56);  
                    writeMessage = false;
    }
            @SuppressWarnings("rawtypes")  
        this.writeVInt(map.size());
        } else {  
            o.writeByte((byte) 4);  
                writeString(s);
        writers.put(Boolean.class, (o, v) -> {  
            writeArray(writer, array);  
            }
        writeVInt(values.length);
        writeVInt(values.length);  
                    writeOptionalString(tooNewEx.getResourceDescription());  
            try {  
                writeBytes(buffer, offset);
     */  
        }  
            writeByte((byte) i);  
        } else {
    /**
     *
                    writeCause = false;
        writers.put(Object[].class, (o, v) -> {
            writeInt(integer);
        writeOptionalArray((out, value) -> value.writeTo(out), array);  
            writeBoolean(false);
     * five bytes.  Smaller values take fewer bytes.  Negative numbers
     *  
     * Writes an int in a variable-length format.  Writes between one and
                o.writeByte((byte) 24);
            Object[] array = (Object[]) value;  
    }
     * </code></pre>  
     */
import java.util.Date;
    private final BytesRefBuilder spare = new BytesRefBuilder();
            o.writeLong(zonedDateTime.toInstant().toEpochMilli());
            throw new IllegalArgumentException("can not write type [" + type + "]");
            return BytesReference.class;
    public void writeVLong(long i) throws IOException {
            writeInt(-1);
        if (writer == null) {
     * Write a {@link Map} of {@code K}-type keys to {@code V}-type {@link List}s.  
    public void writeSemverRange(final SemverRange range) throws IOException {
                o.writeByte((byte) 9);
                case IOException ignored -> writeVInt(17);  
            final ZonedDateTime zonedDateTime = (ZonedDateTime) v;
                case CorruptIndexException corruptEx -> {
    public void writeStringCollection(final Collection<String> collection) throws IOException {  
    public void writeOptionalWriteable(@Nullable Writeable writeable) throws IOException {  
        writeVInt(enumSet.size());
        for (final T val : collection) {  
                }  
                    writeInt(tooNewEx.getMaxVersion());  
        }
        writeByte((byte) timeValue.timeUnit().ordinal());
        writers.put(long[].class, (o, v) -> {
                        writeOptionalString(t.getReason());  
    }  
        bytes.writeTo(this);  
        writeCollection(collection, (o, v) -> v.writeTo(o));  
        });
     * Test if the stream has the specified feature. Features are used when serializing {@code ClusterState.Custom} or
            } else if (c > 0x07FF) {
            writeBoolean(false);
 * not use this file except in compliance with the License.
import org.opensearch.core.common.settings.SecureString;
 * Unless required by applicable law or agreed to in writing,
            writeVLong(value);
    public void writeSecureString(SecureString secureStr) throws IOException {
            @SuppressWarnings("unchecked")  
        return this.version;  
     * Same as {@link #writeArray(Writeable[])} but the provided array may be null. An additional boolean value is
     * Write a {@linkplain ZoneId} to the stream.
        write(bytes.bytes, bytes.offset, bytes.length);  
            o.writeFloatArray((float[]) v);
    /**
     * </code></pre>
/*  
            valueWriter.write(this, entry.getValue());  
    public void writeOptionalZoneId(@Nullable ZoneId timeZone) throws IOException {
        writeBytes(buffer, 0, 4);  
     * Writes an optional collection of a strings. The corresponding collection can be read from a stream input using
            final byte[] bytes = (byte[]) v;  
import java.util.HashSet;
        writeBytes(b, 0, b.length);  
                }  
        } else {
    public void writeOptionalBytesReference(@Nullable BytesReference bytes) throws IOException {  
            return Set.class;  
    private Set<String> features = Collections.emptySet();  
        });
    /**  
                o.writeGenericValue(item);
        // server module  
    /**
     */
                    }  
    public <E extends Enum<E>> void writeEnum(E enumValue) throws IOException {  
        writeBytes(b, 0, length);
        final byte[] buffer = scratch.get();
     */
            this.writeGenericValue(next.getValue());
     * @throws IOException if an I/O exception occurs writing the collection
                        writeBoolean(true);
        } else {  
     * For null or empty enum set, writes false;
            writeVInt(integer);
        final int charCount = str.length();
    }
    /**
         * Shortcut writing single byte because it is very, very common and
     * Writes an optional {@link Integer}.  
                writeOptionalString(throwable.getMessage());
        }
        }  
import org.apache.lucene.util.BitUtil;  
import org.opensearch.common.annotation.PublicApi;
        } else {  
            writeBoolean(true);  
    }  
    private static byte TWO = 2;
     */
    }
            writeBoolean(true);
     * references. Use {@link #writeBytesReference(BytesReference)} and {@link StreamInput#readBytesReference()} if you do not.
     * Writes an array of bytes.
        /*
    /**
        writeLong(instant.getEpochSecond());
 *
     */  
        final Build.Type buildType = build.type();
     * Writes the bytes reference, including a length header.  
    }
        writeString(build.hash());  
        } else if (value instanceof List) {
        });
     * Writes an array of bytes.
        });
        } else {
    }
     * Writes a list of {@link NamedWriteable} objects.  
                }
     * Writes a boolean.
    /**  
                        case AccessDeniedException ignored -> writeVInt(5);  
     * numbers use ten bytes and trip assertions (if running in tests) so prefer {@link #writeLong(long)} or {@link #writeZLong(long)} for
    /**
    }
    public void writeOptionalTimeValue(@Nullable TimeValue timeValue) throws IOException {
    public void writeBytesReference(@Nullable BytesReference bytes) throws IOException {
        }  
        } else {
        writeLong(Double.doubleToLongBits(v));
            writeByte((byte) -1);  
     * Writes an array of bytes.
     * out.writeMapOfLists(map, StreamOutput::writeString, StreamOutput::writeString);  
import org.opensearch.core.common.io.stream.Writeable.WriteableRegistry;  
        writers.put(Double.class, (o, v) -> {
            boolean writeMessage = true;
    }
                checkWriteable(v);
     *  
     * @param b      the bytes to write
            return registeredClass;
        }
            o.writeLongArray((long[]) v);
    }
     * Writes an EnumSet with type E that by serialized it based on it's ordinal value
    /**  
                    writeCause = false;
        } else {  
        while ((i & ~0x7F) != 0) {  
        buffer[5] = (byte) (i >> 16);
            }
    private static byte ONE = 1;  
    }  
                        writeInt(t.getVersion());  
            Map.Entry<String, ?> next = iterator.next();
            // fallback to this local hashmap  
        writeBoolean(build.isSnapshot());
                    } else {
     * {@link StreamInput#readList(Writeable.Reader)}.  
     * Forces any buffered output to be written.
import java.util.function.IntFunction;  
        if (writeable != null) {
            return;  
            boolean writeCause = true;
         * In that case benchmarks of the method itself are faster but  
     * Values are remapped by sliding the sign bit into the lsb and then encoded as an unsigned number
     * serialized to indicate whether the array was null or not.  
            o.writeBytes(bytes);
    public void seek(long position) throws IOException {  
    @Override  
            return;
        });
    public void setVersion(Version version) {  
     * The version of the node on the other side of this stream.  
     * Map&lt;String, String&gt; map = ...;
    }
    private static final ThreadLocal<byte[]> scratch = ThreadLocal.withInitial(() -> new byte[1024]);  
            buffer[index++] = ((byte) ((i & 0x7f) | 0x80));  
        }
     * Closes this stream to further operations.
import org.opensearch.common.Nullable;
    public void writeOptionalVInt(@Nullable Integer integer) throws IOException {
        buffer[1] = (byte) v;
 *
        writeString(buildType.displayName());
                    writeCause = false;  
    public void writeStringArrayNullable(@Nullable String[] array) throws IOException {
    }
            final String string = text.string();
            writeBoolean(true);
     * @return true if the stream has the specified feature  
            if (v instanceof LinkedHashMap) {
import java.io.EOFException;
    public final void writeInstant(Instant instant) throws IOException {
     * @param collection the collection of objects
        this.version = version;
import org.opensearch.common.unit.TimeValue;  
    /**
        } else {
            Arrays.fill(secureStrBytes, (byte) 0);
    /**
            writeBoolean(false);  
    public <T extends Writeable> void writeArray(T[] array) throws IOException {  
 * specific language governing permissions and limitations
            if (writeCause) {
            writeException(new IllegalStateException("too many nested exceptions"));
import java.util.Collection;  
        }
        } else {
        }
        writers.put(int[].class, (o, v) -> {
            o.writeByte((byte) 26);
            o.writeByte((byte) 8);
        if (bytes == null) {
            writeVLong(l);
        writers.put(Float.class, (o, v) -> {
        });  
     *
import java.util.LinkedHashSet;
        if (v == null) {
                case AlreadyClosedException ignored -> writeVInt(7);
            o.writeString(zonedDateTime.getZone().getId());  
        while ((value & 0xFFFFFFFFFFFFFF80L) != 0L) {
    public void writeZoneId(ZoneId timeZone) throws IOException {  
    }  
     * If the numbers are known to be non-negative, use {@link #writeVLong(long)}
                checkWriteable(entry.getKey());
 * this file be licensed under the Apache-2.0 license or a
        } else if (value instanceof Object[]) {
    public <T extends Writeable> void writeOptionalWriteable(final Writer<T> writer, @Nullable T writeable) throws IOException {
import org.opensearch.common.CharArrays;  
 * Licensed to Elasticsearch under one or more contributor  
        }
     * Numbers with small absolute value will have a small encoding  
     */
        writeString(build.getQualifiedVersion());  
            writeTimeValue(timeValue);
        }
        return (W) writer;
            writeBoolean(false);
     * @param valueWriter The value writer  
                    writeCause = false;
                    writeCause = false;
                }
    }
        // TODO: improve serialization of BigInteger
                checkWriteable(v);  
    public void writeNamedWriteable(NamedWriteable namedWriteable) throws IOException {
        // zig-zag encoding cf. https://developers.google.com/protocol-buffers/docs/encoding?hl=en  
        });
    }
            writeVInt(0);
                    writeCause = false;
        bytes.writeTo(this);
    /** Writes the OpenSearch {@link Build} informn to the output stream */
            for (String s : array) {  
    /**  
    /**
                    writeMessage = false;
import org.opensearch.Version;
    public void writeOptionalNamedWriteable(@Nullable NamedWriteable namedWriteable) throws IOException {  
        this.writeByte((byte) 10);
                        writeInt(t.getMaxVersion());
            writeBoolean(false);
            writeBoolean(false);  
    }
     * @param b the bytes to write
            this.writeString(next.getKey());  
            writeCollection(collection, StreamOutput::writeString);
     * {@link StreamInput#readList(Writeable.Reader)}.  
            writeVInt(0);  
    }  
        writers.put(BytesReference.class, (o, v) -> {
        }  
        });  
            }  
    public void writeLongArray(long[] values) throws IOException {  
     */
 * everywhere. That being said, this class deals primarily with {@code List}s rather than Arrays. For the most part calls should adapt to  
            }
                checkWriteable(v);  
                    writeOptionalString(corruptEx.getOriginalMessage());  
            }  
            o.writeByte((byte) 12);
import java.nio.file.FileAlreadyExistsException;  
 */
        } else {  
    }
     *
        for (int i = 0; i < charCount; i++) {  
        } else if (type == Set.class) {
                case ArrayIndexOutOfBoundsException ignored -> {
import java.time.ZonedDateTime;
import org.apache.lucene.store.LockObtainFailedException;
    }
    public static <W extends Writer<?>> W getWriter(Class<?> type) {  
     * Writes an enum with type E based on its ordinal value
     * negative numbers.
        if (bytes == null) {
            buffer[index++] = (byte) ((value & 0x7F) | 0x80);  
    public void writeList(List<? extends Writeable> list) throws IOException {  
        writeVInt(array.length);  
                    writeVInt(2);
 *  
     */
     * @param features the features on the stream  
            .iterator();  
    /**  
        }
            o.writeText((Text) v);
            writeBoolean(true);
            for (Object v : set) {
     */  
    }
            o.writeVInt(list.length);
                    if (t.getVersion() == null) {
        } else {
                    writeCause = false;
     *
     * {@code Metadata.Custom}; see also {@code ClusterState.FeatureAware}.  
     * Writes a collection of objects via a {@link Writer}.
         */
         * twoards being simple and fast for smaller numbers.  
                    writeVInt(11);  
            o.writeByte((byte) 11);  
import java.util.Arrays;
            } else {
 * software distributed under the License is distributed on an
    private static final Map<Class<?>, Writer<Object>> WRITERS;  
                case SecurityException ignored -> writeVInt(9);  
     */
    }
        writeCollection(list);
     */  
                    writeOptionalString(fsEx.getFile());
                o.writeByte((byte) 25);
        } else if (value instanceof BytesReference) {
     * Write a {@link TimeValue} to the stream
            writeBoolean(true);
     */
        } else if (nestedLevel > MAX_NESTED_EXCEPTION_LEVEL) {
        if (namedWriteable == null) {
                }
    public Version getVersion() {
    /**  
        }
import java.io.OutputStream;
        if (bytes == null) {  
            o.writeShort((Short) v);
    public <T> void writeCollection(final Collection<T> collection, final Writer<T> writer) throws IOException {
        } else {
                        ex = osEx;  
    public void writeOptionalLong(@Nullable Long l) throws IOException {
        writers.put(Date.class, (o, v) -> {  
    }
     * Writes a {@link NamedWriteable} to the current stream, by first writing its name and then the object itself
     * {@link #writeVLong(long)} instead.
                        writeBoolean(false);
            .stream()
 * <p>
            writeNamedWriteable(obj);
            writeBoolean(true);
    }
 * compatible open source license.
     */
        if (secureStr == null) {
        for (int value : values) {  
        writer.write(this, value);
        }
            writeBoolean(false);
        writeVInt(b.length);
            }
        this.features = Collections.unmodifiableSet(new HashSet<>(features));
        if (timeZone == null) {
    }
        writeVInt(values.length);
    /**
                        writeInt(t.getMinVersion());
        writeVInt(bytes.length);
        writers.put(String.class, (o, v) -> {
    public void writeLong(long i) throws IOException {
            writeStringArray(array);
    }
    }
            OpenSearchException.writeStackTraces(throwable, this, (o, t) -> o.writeException(rootException, t, nestedLevel + 1));
                case FileNotFoundException ignored -> {  
                }
        int index = 0;
    public void writeOptionalString(@Nullable String str) throws IOException {
import java.util.Iterator;  
            writer = WRITERS.get(type);
        if (b == null) {
     * Write a {@link Map} of {@code K}-type keys to {@code V}-type.
                        case DirectoryNotEmptyException ignored -> writeVInt(2);  
    /**
    public abstract void flush() throws IOException;
    }
     */
    }  
        buffer[index++] = (byte) (value & 0x7F);  
import org.apache.lucene.store.AlreadyClosedException;
    public void writeByteArray(byte[] b) throws IOException {  
            spare.copyChars(string);  
        throw new UnsupportedOperationException();  
            o.writeByte((Byte) v);
     */
                buffer[offset++] = ((byte) (0x80 | c >> 0 & 0x3F));
     * If want to keep stream out map and stream in map have the same stream order when stream,
     * @param collection the collection of strings  
     */
            List<Object> list = (List<Object>) value;
    public abstract void close() throws IOException;
 * This class's methods are optimized so you can put the methods that read and write a class next to each other and you can scan them
    /**  
        throw new UnsupportedOperationException();
     */  
        namedWriteable.writeTo(this);  
        for (long value : values) {
        throw new AssertionError("too many nested exceptions", throwable);
            BytesReference bytes = text.bytes();
        writeBytes(buffer, 0, 8);
     * <pre><code>  
    /**
        writeVLongNoCheck(i);
import org.opensearch.core.common.bytes.BytesReference;
     */
    public void writeOptionalText(@Nullable Text text) throws IOException {
     * Writes the specified array to the stream using the specified {@link Writer} for each element in the array. This method can be seen as
            @SuppressWarnings("unchecked")  
    private static final int MAX_NESTED_EXCEPTION_LEVEL = 100;  
    }
     *
     * can use {@code writeMapWithConsistentOrder}
        buffer[7] = (byte) i;
    public void writeOptionalStringArray(@Nullable String[] array) throws IOException {  
        if (text == null) {  
     */
        writeVInt(values.length);
        writeVInt(list.size());  
     */
        return this.features.contains(feature);  
    }
     * @param feature the feature to test
                }
            for (final V value : list) {
        });
        });
    public void writeIntArray(int[] values) throws IOException {
        }
     * e.g., 0 -;&gt; 0, -1 -;&gt; 1, 1 -;&gt; 2, ..., Long.MIN_VALUE -;&gt; -1, Long.MAX_VALUE -;&gt; -2
    private static Class<?> getGenericType(Object value) {
            if (offset > buffer.length - 3) {  
            }  
import java.nio.file.AccessDeniedException;  
     * writer version of {@link StreamInput#readArray(Writeable.Reader, IntFunction)}. The length of array encoded as a variable-length  
        });
     * @param collection the collection to write to this stream
                    writeVInt(12);
    public void writeVLongArray(long[] values) throws IOException {
            }  
        writers.put(byte[].class, (o, v) -> {
        byte[] buffer = scratch.get();  
    public void writeCollection(final Collection<? extends Writeable> collection) throws IOException {
                case LockObtainFailedException ignored -> writeVInt(15);
import org.apache.lucene.index.IndexFormatTooOldException;  
            throw new IllegalStateException("Negative longs unsupported, use writeLong or writeZLong for negative numbers [" + i + "]");  
    }
     * Writes an optional EnumSet with type E that serializes each enum based on its ordinal value  
    }
        if (throwable == null) {  
            }
         * the encoding loop blows out the method size so it can't be inlined.
     * Writes an {@link Instant} to the stream with nanosecond resolution
            for (Map.Entry<String, Object> entry : map.entrySet()) {
     * Writes a list of {@link Writeable} objects
    /**  
            o.writeIntArray((int[]) v);  
    private Version version = Version.CURRENT;
            throw new IllegalArgumentException("Cannot write type [" + type.getCanonicalName() + "] to stream");  
                buffer[offset++] = ((byte) c);  
    /**
    /**  
import java.io.IOException;  
        buffer[0] = (byte) (v >> 8);
            writeBoolean(b);
    public void writeOptionalVLong(@Nullable Long l) throws IOException {
        writeInt(Float.floatToIntBits(v));  
            for (Map.Entry<String, Object> entry : map.entrySet()) {  
import java.nio.file.DirectoryNotEmptyException;
            Map<String, Object> map = (Map<String, Object>) value;  
     */
    public void writeOptionalBoolean(@Nullable Boolean b) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
                o.writeGenericValue(item);  
            Set<Object> set = (Set<Object>) value;
        writeGenericValue(map);
                    writeCause = false;
     * Map&lt;String, List&lt;String&gt;&gt; map = ...;
        long value = BitUtil.zigZagEncode(i);
    public void writeZLong(long i) throws IOException {  
        writers.put(BigInteger.class, (o, v) -> {  
                    switch (throwable) {  
    public void writeOptionalDouble(@Nullable Double v) throws IOException {
 * The OpenSearch Contributors require contributions made to  
            o.writeByte((byte) 19);
    /**  
     * Writes a string array, for nullable string, writes false.
            writeEnumSet(enumSet);  
    public <T extends Writeable> void writeOptionalArray(@Nullable T[] array) throws IOException {
    }
                writeOptionalBytesReference(new BytesArray(secureStrBytes));
                    writeInt(tooNewEx.getMinVersion());
    }
        writeArray((out, value) -> value.writeTo(out), array);
    public void setFeatures(final Set<String> features) {
        }  
     */
            writeBoolean(true);  
    }
        }  
        writeVInt(values.length);
            o.writeCollection((Set<?>) v, StreamOutput::writeGenericValue);  
            }
        buffer[0] = (byte) (i >> 24);
     * Writes an {@link Instant} to the stream, which could possibly be null
        }
            writeInt(spare.length());
        writeBytes(buffer, 0, index);
 * under the License.  
            writeFloat(value);
        writeVInt(charCount);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * to make sure every map generated bytes order are same.  
    }
    }  
            writeBoolean(false);
                    writeVInt(3);
        writeString(v.toString());
    /**
    }  
    }
                    }  
                case IllegalStateException ignored -> writeVInt(14);  
        if (writer == null) {
            }
    }  
 * visually for differences. That means that most variables should be read and written in a single line so even large objects fit both  
            o.writeByte((byte) 6);
                        default -> writeVInt(7);
     */
                    writeVInt(OpenSearchException.getId(ex.getClass()));
import java.util.EnumSet;  
        if (enumSet != null && enumSet.size() > 0) {
 *  
        writeVInt(values.length);  
import java.nio.file.AtomicMoveNotSupportedException;
        });
        writeZLong(timeValue.duration());
                    } else {
        });
 */  
        writeBytes(buffer, 0, index);
     */
    }  
     * Writes a collection of a strings. The corresponding collection can be read from a stream input using  
     * Writes an int as four bytes.
    }  
/*  
     * @param length the number of bytes to write  
            }
     * @param keyWriter The key writer  
        int index = 0;
                valueWriter.write(this, value);
import org.apache.lucene.index.CorruptIndexException;
            }  
                    writeCause = false;  
                    writeVInt(5);  
     * Returns the registered writer for the given class type.  
        if (value == null) {  
        }
            } else {  
        } else {
    }
            writeBoolean(false);
    }
     */
                case NumberFormatException ignored -> {
            o.writeBoolean((boolean) v);
        buffer[1] = (byte) (i >> 16);  
        }
        final byte[] buffer = scratch.get();
            return;  
     */
        final byte[] secureStrBytes = CharArrays.toUtf8Bytes(secureStr.getChars());  
        for (long value : values) {  
                    writeInt(tooNewEx.getVersion());
    public void writeOptionalInt(@Nullable Integer integer) throws IOException {
        }
    }  
                    writeOptionalString(fsEx.getReason());  
            if (c <= 0x007F) {
        });
     */
            assert failOnTooManyNestedExceptions(rootException);  
        if (instant == null) {
     * integer is first written to the stream, and then the elements of the array are written to the stream.
     *
 * reading and writing on the screen. It also means that the methods on this class are named very similarly to {@link StreamInput}. Finally
         * can skip grabbing the scratch buffer. This is marginally slower  
import org.opensearch.core.common.text.Text;  
                    writeCause = false;
        writers.put(ZonedDateTime.class, (o, v) -> {  
}
            return value.getClass();
            o.writeDouble((double) v);
import java.util.HashMap;
    /**
            writeBoolean(false);
    }
    /**
        Class<?> registeredClass = WriteableRegistry.getCustomClassFromInstance(value);
        for (T value : array) {
        }
        buffer[6] = (byte) (i >> 8);  
        if (array == null) {
import java.nio.file.FileSystemException;
        final Class<?> type = getGenericType(value);  
@PublicApi(since = "1.0.0")  
    }  
    /**
        for (NamedWriteable obj : list) {
    public void write(int b) throws IOException {  
    public long position() throws IOException {
            writeBoolean(true);
     * using {@link #writeInt}
    }
 * KIND, either express or implied.  See the License for the
        } else if (value instanceof Map) {  
        }  
            writeLong(l);  
    }  
        WRITERS = Collections.unmodifiableMap(writers);
    public void writeOptionalSecureString(@Nullable SecureString secureStr) throws IOException {
            for (Object item : list) {
    public void writeDoubleArray(double[] values) throws IOException {  
            buffer[index++] = ((byte) ((i & 0x7f) | 0x80));
            // we need at most 3 bytes so we flush the buffer once we have less than 3 bytes
        writeVInt(bytes.length() + 1);
            }  
