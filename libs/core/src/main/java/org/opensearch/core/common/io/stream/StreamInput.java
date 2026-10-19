    }  
            throw new NegativeArraySizeException("array size must be positive but was: " + arraySize);
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.core.common.Strings;
        return values;
        // the following is new for opensearch: we write the distribution to support any "forks"
        return value;  
        if (readBoolean()) {
import org.opensearch.common.CharArrays;
 * software distributed under the License is distributed on an
        charsRef.length = charCount;
        b = readByte();
        return readBytesRef(length);
                    return (T) readStackTrace(new IndexFormatTooNewException(resource2, version2, minVersion2, maxVersion2), this);
     * only if you must differentiate null from empty. Use {@link StreamInput#readBytesReference()} and
            new TimeUnit[] {
            sortedMap = new TreeMap<>();
        return readEnum(enumClass, enumClass.getEnumConstants());
        i |= (b & 0x7F) << 7;
        return map;  
     * If the returned map contains any entries it will be mutable. If it is empty it might be immutable.  
        }
        return readGenericValue(0);
        for (int i = 0; i < length; i++) {
        return Float.intBitsToFloat(readInt());
                    case 4:
            return i;
        }
    public <E extends Enum<E>> EnumSet<E> readOptionalEnumSet(Class<E> enumClass) throws IOException {
     * Use {@link FilterInputStream} instead which wraps a stream and supports a {@link NamedWriteableRegistry} too.  
            return Collections.emptyMap();
        return sortedMap;  
            return Collections.emptyMap();
                minRemainingBytes = charsLeft;
                            break;  
        if (readBoolean()) {
    }
        String date = readString();  
    }
                TimeUnit.MINUTES,  
        return values;
            i += 7;
    }
     * Reads an optional {@link Integer}.  
                    return (T) readStackTrace(new IllegalStateException(readOptionalString(), readException()), this);  
    }  
            if (missingFromPartial > 0) {
                    case 3:  
    }  
     *
    public String[] readStringArray() throws IOException {  
        byte[] bytes = BytesReference.toBytes(bytesRef);
        if (length == 0) {  
        if (readBoolean()) {
        int length = readVInt() - 1;  
     * <p>
            return res;
        i |= (b & 0x7F) << 14;
    private Object readGenericValue(int depth) throws IOException {
            }
    }
    public TimeValue readTimeValue() throws IOException {
    public final Instant readInstant() throws IOException {
     */
            case 26:
        }
                            break;
     * Reads an optional {@link NamedWriteable}.
        return Instant.ofEpochSecond(readLong(), readInt());  
    public long readLong() throws IOException {  
        }
 *
                return readDate();
            if (largeSpare == null) {
        final int length = readArraySize();
    public abstract void readBytes(byte[] b, int offset, int len) throws IOException;  
        byte type = readByte();  
     * The set is expected to have been written using {@link StreamOutput#writeOptionalEnumSet(EnumSet)}  
     * Reads a list of objects. The list is expected to have been written using {@link StreamOutput#writeList(List)}.
        }
                    case 14:
        if (readBoolean()) {
                case 0:
    }
    }  
     */  
            case 9:  
        if (charCount > SMALL_STRING_LIMIT) {  
                        String version3 = readOptionalString();
     * assumed that the stream first contains a variable-length integer representing the size of the array, and then contains that many
 */  
import java.util.Locale;  
     * Read a serialized map into a SortedMap using the default ordering for the keys. If the result is empty it might be immutable.
    @Nullable
        if (Arrays.equals(
     */
        return new InputStreamStreamInput(new ByteArrayInputStream(bytes, offset, length), length);  
                    return (T) readStackTrace(new InterruptedException(readOptionalString()), this);
        return new Build(type, hash, date, snapshot, version, distribution);  
                        int minVersion3 = readInt();
            case 7:
        }
        return map9;
                        offsetByteArray++;  
                return readLong();
        for (int i = 0; i < length; i++) {
            final int bufferedBytesRemaining = sizeByteArray - offsetByteArray;
                    }  
        }
    // We don't use a CharsRefBuilder since we exactly know the size of the character array up front
    public BytesReference readBytesReference(int length) throws IOException {
    }
 * You may obtain a copy of the License at  
        return new BigInteger(readString());  
        readIntoMap(keyReader, valueReader, sortedMap, size);
    /**
        if ((b & 0x80) == 0) {
        }  
            }  
        int missingFromPartial = 0;  
        try {  
                    case 4:
     * @param keyReader The key reader
    @Nullable  
            return null;
 * this work for additional information regarding copyright
        if (size9 == 0) {  
        }
                return readFloatArray();  
        if (isPresent) {
            case 1:
        long accumulator = 0L;
    @SuppressWarnings({ "rawtypes", "unchecked" })  
     * from other source, so it's not read from the stream. The name is used for looking for  
     */
            case 24:
                            break;  
    /**
    protected abstract void ensureCanReadBytes(int length) throws EOFException;
        }
    }
     * Reads a boolean.  
     * @param b      the array to read bytes into
            return readLong();  
                            exception = new NotDirectoryException(file);
        if (length == 0) {
            case 14:
        }
            return null;
        int size9 = readArraySize();
                final int c = byteBuffer[offsetByteArray] & 0xff;
        if (bytesRef != null) {
        System.getProperty("opensearch.stream.depth.max", "1000" /* aligned with StreamReadConstraints.DEFAULT_MAX_DEPTH */)
     * This method throws an {@link EOFException} if the given number of bytes can not be read from the this stream. This method might
        return ZoneId.of(readString());
import java.io.FilterInputStream;  
        Map map10 = new HashMap(size10);
            return readDouble();  
                    default:  
            case 0:  
                            byteBuffer[0] = byteBuffer[offsetByteArray];
        for (int i = 0; i < count; i++) {  
        }
        final E[] values = enumClass.getEnumConstants();  
import org.apache.lucene.store.AlreadyClosedException;
        if (readBoolean()) {
            return EMPTY_LONG_ARRAY;  
    }  
                            break;  
            return i;  
    }  
     * Set the version of the node on the other side of this stream.  
        for (int i = 0; i < size; i++) {  
        byte[] bytes = new byte[length];  
        int size = readArraySize();  
                return readFloat();
        }
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
        if (arraySize < 0) {  
     * @return the list of objects
     */
    private Date readDate() throws IOException {
import org.apache.lucene.util.ArrayUtil;  
                        missingFromPartial = 2 - (bufferedBytesRemaining - i);
    /**  
        b = readByte();
            K key = keyReader.read(this);  
    public abstract void close() throws IOException;
                case 10:
                    return (T) readStackTrace(new NumberFormatException(readOptionalString()), this);
     */
            }
     */
     * Reads a specified number of bytes into an array at the specified offset.  
     * This method uses {@link #ensureCanReadBytes(int)} to ensure this stream has enough bytes to read for the read array size.
        for (int i = 0; i < length; i++) {
    public <K extends Comparable<K>, V> SortedMap<K, V> readOrderedMap(Writeable.Reader<K> keyReader, Writeable.Reader<V> valueReader)  
            final int minRemainingBytes;
     */  
        b = readByte();  
import java.nio.file.AtomicMoveNotSupportedException;
     * {@link StreamOutput#writeOptionalStringCollection(Collection)}. If the returned list contains any entries it will be mutable.  
        }
import java.time.ZoneId;
    @Nullable
        }  
        for (int i = 0; i < length; i++) {  
                    String resource1 = readOptionalString();
                return readBytesRef();
    public int[] readVIntArray() throws IOException {
                        if (missingFromPartial == 0) {
import org.apache.lucene.store.LockObtainFailedException;
        if (length == 0) {  
        readBytes(bytes, 0, length);
        return null;
        Writeable.Reader<K> keyReader,  
                return readShort();  
            case 13:
     */
        return values;
/*  
                        charBuffer[charsOffset++] = (char) c;
import java.util.HashSet;
            case 12:  
            return false;
     * </code></pre>
                        case 6:
    public String readString() throws IOException {  
    /**
        final boolean isPresent = readBoolean();
        }  
        }
    }
    public final Double readOptionalDouble() throws IOException {
     * If the map or a list in it contains any elements it will be mutable, otherwise either the empty map or empty lists it contains
        return values[ordinal];  
            return null;  
                    final String reason = readOptionalString();  
    }  
        return null;
    private <E extends Enum<E>> E readEnum(Class<E> enumClass, E[] values) throws IOException {
    @Nullable
                        missingFromPartial = 3 - (bufferedBytesRemaining - i);  
     * elements that can be read from the stream.
            throw new IllegalStateException(message);
        }  
                // if there are any
    }
        if ((b & 0x80) == 0) {
                case 12:  
 * Licensed to Elasticsearch under one or more contributor  
                    "Writeable.Reader [" + reader + "] returned null which is not allowed and probably means it screwed up the stream."
            case 10:
            builder.add(readNamedWriteable(categoryClass));
    // Thread-local buffer for smaller strings
                            exception = new NoSuchFileException(file, other, reason);
            case 21:  
    /**
        if (size == 0) {
     */
    }
import java.nio.file.FileSystemException;
    /**  
        if ((b & 0x80) == 0) {
        byte[] bytes = new byte[length];  
                        break;
     * Read an optional {@link TimeValue} from the stream, returning null if no TimeValue was written.  
 * on {@link StreamInput}.
    }
        }
        }
            try {  
                            break;  
    public <C extends NamedWriteable> C readOptionalNamedWriteable(Class<C> categoryClass) throws IOException {
        }
        b = readByte();  
        long[] values = new long[length];
    }
    }
    @Nullable  
            switch (key) {
import java.util.Date;
    private static final ThreadLocal<byte[]> stringReadBuffer = ThreadLocal.withInitial(() -> new byte[1024]);
    /**  
    /**
        return new BytesRef(bytes, 0, length);
     * have a compelling reason to use this method instead.  
        int length = readArraySize();
    }
     * Default implementation throws {@link UnsupportedOperationException} as StreamInput doesn't hold a registry.
        if ((b & 0x80) == 0) {
        for (int i = 0; i < size; ++i) {
 * not use this file except in compliance with the License.
    }
        if (readBoolean()) {  
     */
 * under the License.  
     * @throws IOException if an I/O exception occurs reading the set  
            }  
     */
 * reading and writing on the screen. It also means that the methods on this class are named very similarly to {@link StreamOutput}. Finally  
        if ((b & 0x80) == 0) {
            case 2:
    public String[] readOptionalStringArray() throws IOException {
                    return (T) readStackTrace(new EOFException(readOptionalString()), this);
    /**
        b = readByte();
    }
                final int c = byteBuffer[offsetByteArray] & 0xff;
    }  
     */
        }
     * Default implementation throws {@link UnsupportedOperationException} as StreamInput doesn't hold a registry.
 * This class's methods are optimized so you can put the methods that read and write a class next to each other and you can scan them
            return readStringArray();  
        final int size = readArraySize();
    public abstract int available() throws IOException;
     */  
        } finally {
            return EMPTY_OBJECT_ARRAY;  
        }
     */
            return t;
import java.io.InputStream;
            } else {
        return values;
        return SemverRange.fromString(readString());
                        return (T) readStackTrace(new IndexFormatTooOldException(resource3, version3, minVersion3, maxVersion3), this);  
    /**
        i |= (b & 0x7F) << 21;  
    }
    public <T extends Exception> T readException() throws IOException {
        }
                    final String file = readOptionalString();
        final boolean present = readBoolean();  
    }  
                    case 3:  
    }
import java.io.FileNotFoundException;
        }  
        if (value == 2) {
 * lists, either by storing {@code List}s internally or just converting to and from a {@code List} when calling. This comment is repeated  
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(readLong()), ZoneId.of(timeZoneId));
        ensureCanReadBytes(arraySize);  
import org.apache.lucene.index.CorruptIndexException;
                    final Exception exception;
            return empty;
     * Read a {@link Map} of {@code K}-type keys to {@code V}-type {@link List}s.
        for (int i = 0; i < size10; i++) {
        if (length < 0) {
                return readBigInteger();  
                    String resource3 = readOptionalString();
 * this file be licensed under the Apache-2.0 license or a
    }  
        // assert the exact form of the TimeUnit values to ensure we're not silently broken by a JDK change
            int key = readVInt();  
            return i;
                case 14:
                        case 2:  
     *
     *
    }
            case 15:  
        }
        String[] ret = new String[size];
 */
    // Larger buffer used for long strings that can't fit into the thread-local buffer
                return readZonedDateTime();  
                    default:  
        if (r != null) {
    }  
    private int readArraySize() throws IOException {
        b = readByte();
    }
/*
        }
        }
        return readBytesReference(length);
            values[i] = readVLong();
                    case 2:
        if (size == 0) {  
        }  
 * everywhere. That being said, this class deals primarily with {@code List}s rather than Arrays. For the most part calls should adapt to
            charsRef = largeSpare;
        return values;  
            accumulator |= (currentByte & 0x7F) << i;  
                            break;  
    public void readFully(byte[] b) throws IOException {
        int offsetByteArray = 0;
                            exception = new AtomicMoveNotSupportedException(file, other, reason);
                    case 1:
    }
            list.add(readGenericValue(depth + 1));  
import org.opensearch.common.unit.TimeValue;
    }
    /**
        }  
        if ((b & 0x80) != 0) {
        for (int i = 0; i < size9; i++) {
     * Read a {@linkplain ZoneId}.
     * @return the enum set of strings
                    throw new IOException("no such exception for id: " + key);
        return this.version;
        }  
    public Text readOptionalText() throws IOException {
    }  
     * @param valueReader The value reader  
    }  
    /**
    @Override  
public abstract class StreamInput extends InputStream {  
    public MediaType readMediaType() throws IOException {  
        }  
            Arrays.fill(bytes, (byte) 0);  
                    case 14:
                return readBytesReference();
    private boolean readBoolean(final byte value) {  
            sizeByteArray += toRead;  
        }  
        if (size == 0) {
            return new BytesRef();
        return map;
        }
    /**
    private static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
            return ZoneId.of(readString());  
import java.util.SortedMap;  
    }
            }  
    public <E extends Enum<E>> E readEnum(Class<E> enumClass) throws IOException {  
    public double[] readDoubleArray() throws IOException {
                            byteBuffer[0] = byteBuffer[offsetByteArray];
    @Nullable  
        TimeUnit timeUnit = TIME_UNITS[readByte()];
        }  
            case 20:
                default:
    }  
                            exception = new FileAlreadyExistsException(file, other, reason);
                        charBuffer[charsOffset++] = (char) c;
        if (readBoolean()) {  
                case 17:
    public <C extends NamedWriteable> C readNamedWriteable(@SuppressWarnings("unused") Class<C> categoryClass) throws IOException {  
            // try to extract chars from remaining bytes with bounds checks for multi-byte chars
        }
                            break;  
        SecureString value = null;
            throw new IOException("Invalid vInt ((" + Integer.toHexString(b) + " & 0x7f) << 28) | " + Integer.toHexString(i));  
    }  
        int charsOffset = 0;  
            if (t == null) {  
                TimeUnit.HOURS,
                case 8:
     *
    }  
        }
                return readInt();  
     * Reads an array from the stream using the specified {@link Writeable.Reader} to read array elements
        int size10 = readArraySize();  
                        charBuffer[charsOffset++] = (char) ((c & 0x1F) << 6 | byteBuffer[++offsetByteArray] & 0x3F);  
    }
    static {  
        if (count == 0) {
        Map<K, V> map = new HashMap<>(size);
     * {@link StreamOutput#writeBytesReference(BytesReference)} if you do not.
        if ((b & 0x80) == 0) {  
        throws IOException {
        if (length == 0) {  
        if ((b & 0x80) == 0) {  
        final int length = readArraySize();
        } else {  
    public <E extends Enum<E>> EnumSet<E> readEnumSet(Class<E> enumClass) throws IOException {  
     * Use {@link FilterInputStream} instead which wraps a stream and supports a {@link NamedWriteableRegistry} too.  
    @Nullable
        return i;
 * compatible open source license.
        return readCollection(reader, ArrayList::new, Collections.emptyList());
/**
            }
        int size = readVInt();
        }
                );  
            map10.put(readString(), readGenericValue(depth + 1));  
                        ++i;  
     * @return the list of strings  
     * Reads a bytes reference from this stream, might hold an actual reference to the underlying  
    private static final int[] EMPTY_INT_ARRAY = new int[0];
import java.util.Collections;  
    private Object[] readArray(int depth) throws IOException {  
import java.util.EnumSet;  
     */
                        case 7:
    );  
            return EnumSet.noneOf(enumClass);  
    @Nullable
        }
        }
     * @param reader        the reader used to read individual elements
import org.apache.lucene.util.BytesRef;
 * The OpenSearch Contributors require contributions made to  
                        case 3:
    public <T> T[] readOptionalArray(Writeable.Reader<T> reader, IntFunction<T[]> arraySupplier) throws IOException {
                return readDouble();  
     * Reads an int stored in variable-length format.  Reads between one and
    public BytesReference readOptionalBytesReference() throws IOException {
            return null;
        Map map9 = new LinkedHashMap(size9);  
                    return (T) readStackTrace(new StringIndexOutOfBoundsException(readOptionalString()), this);  
     */  
        }
            charsRef = smallSpare.get();  
                    case 7:
    @Nullable
    public long[] readVLongArray() throws IOException {  
        final EnumSet<E> res = EnumSet.noneOf(enumClass);
    private static final TimeUnit[] TIME_UNITS = TimeUnit.values();
        return map10;
    ) throws IOException {  
     */
        @Nullable Comparator<K> keyComparator
    }
        long duration = readZLong();  
    }
     *  
        b = readByte();  
                case 16:  
        return MediaTypeRegistry.fromMediaType(readString());
                    final String other = readOptionalString();
            final int toRead;
                largeSpare.chars = new char[ArrayUtil.oversize(charCount, Character.BYTES)];
        i |= (b & 0x7FL) << 7;  
        }  
    }  
    public Object readGenericValue() throws IOException {
     */  
                    String resource2 = readOptionalString();
        }
 * <p>  
        }
     * Read a serialized map into a SortedMap, specifying a Comparator for the keys. If the result is empty it might be immutable.  
     */
        int size = readArraySize();  
        if ((b & 0x80) == 0) {  
                largeSpare = new CharsRef(ArrayUtil.oversize(charCount, Character.BYTES));
     * might be immutable.  
                    case 13:
    public String readOptionalString() throws IOException {
    }
    private static final int SMALL_STRING_LIMIT = 1024;
    /**
import org.opensearch.core.common.bytes.BytesArray;  
        }  
     * Reads a {@link NamedWriteable} from the current stream, by first reading its name and then looking for  
    public <K extends Comparable<K>, V> SortedMap<K, V> readOrderedMap(
        }  
                    return (T) readStackTrace(new AlreadyClosedException(readOptionalString(), readException()), this);  
        @SuppressWarnings("unused") String name
     * Reads four bytes and returns an int.
    public <K, V> Map<K, List<V>> readMapOfLists(final Writeable.Reader<K> keyReader, final Writeable.Reader<V> valueReader)  
                    } else {
        return readCollection(reader, HashSet::new, Collections.emptySet());
        return readOrderedMap(keyReader, valueReader, null);
                case 4:
    public @Nullable TimeValue readOptionalTimeValue() throws IOException {
import java.nio.file.FileAlreadyExistsException;
        int ordinal = readVInt();
        } else {
            return readVLong();
                } else {
        final T[] values = arraySupplier.apply(length);  
        if (readBoolean()) {  
            case 27:
     * @param len    the number of bytes to read
import org.opensearch.semver.SemverRange;
            if (bufferFree < minRemainingBytes) {
        int size = readArraySize();
        if ((b & 0x80) == 0) {  
        }
        for (int i = 0; i < size; i++) {
 * A stream from this node to another node. Technically, it can also be streamed to a byte array but that is mostly for testing.
        for (int i = 0; i < size; i++) {
        if ((b & 0x80) == 0) {
                TimeUnit.MILLISECONDS,
    }
    @Nullable  
    /**  
        Writeable.Reader<?> r = Writeable.WriteableRegistry.getReader(type);
                        break;
    public final Boolean readOptionalBoolean() throws IOException {  
                    return (T) OpenSearchException.readException(this, ord);
        readBytes(b, 0, b.length);
import org.apache.lucene.util.CharsRef;  
        if (readBoolean()) {
        BytesReference bytesRef = readBytesReference();
        return null;
        // throw an exception instead of allocating the array based on the size. A simple corrutpted byte can make a node go OOM
                    return (T) readStackTrace(new ArrayIndexOutOfBoundsException(readOptionalString()), this);
import org.opensearch.core.xcontent.MediaType;
                    int version2 = readInt();
        }
        return builder;
    /**
            return EMPTY_BYTE_ARRAY;  
    @Nullable
        final Map<K, List<V>> map = new HashMap<>(size);  
    /**
     * @throws IOException if an I/O exception occurs reading the list
        b = readByte();
    @Nullable
            case 19:
    public long readZLong() throws IOException {
        long i = b & 0x7FL;
    }
    /**
        final String distribution = readString();
        for (int i = 0; i < length; i++) {
        for (int i = 0; i < length; i++) {  
import org.opensearch.core.common.settings.SecureString;
                case 15:
import java.util.TreeMap;
     * @param offset the offset in the array to start storing bytes  
        if ((b & 0x80) == 0) {
                        throwOnBrokenChar(c);
            throw new IOException("Maximum nesting depth [" + MAX_DESERIALIZATION_DEPTH + "] exceeded for binary deserialization");
        this.version = version;  
                    case 6:  
import java.math.BigInteger;  
        for (int i = 0; i < size; i++) {
                    toRead = bufferFree;  
     * Reads an enum with type E that was serialized based on the value of its ordinal
        return null;
 * Modifications Copyright OpenSearch Contributors. See
import java.nio.file.NoSuchFileException;
        i |= (b & 0x7FL) << 49;  
        return present ? readInstant() : null;
    public <T> List<T> readList(final Writeable.Reader<T> reader) throws IOException {
    }
    public <K, V> Map<K, V> readMap(Writeable.Reader<K> keyReader, Writeable.Reader<V> valueReader) throws IOException {
     * Get the registry of named writeables if this stream has one,
    /**
        }
    public short readShort() throws IOException {
import org.opensearch.core.common.text.Text;  
            case 4:
            return Collections.emptyMap();
    public <T> T[] readArray(final Writeable.Reader<T> reader, final IntFunction<T[]> arraySupplier) throws IOException {
                    final boolean isExecutorShutdown = readBoolean();
        readIntoMap(keyReader, valueReader, map, size);
            map9.put(readString(), readGenericValue(depth + 1));
                            byteBuffer[1] = byteBuffer[offsetByteArray + 1];
        return ret;  
        if (depth > MAX_DESERIALIZATION_DEPTH) {  
    /**
     * Read a {@link TimeValue} from the stream  
                return readCollection(si -> si.readGenericValue(depth + 1), LinkedHashSet::new, Collections.emptySet());
        return null;  
        }
                return null;
        if (length == 0) {
    /**
                return readLongArray();
     * Closes the stream to further operations.
    }
        return null;
     * Reads and returns a single byte.
                if (offsetByteArray > 0) {  
    }  
        return list8;  
        i |= (b & 0x7FL) << 21;
        return (Map<String, Object>) readGenericValue();
        }  
     * If it is empty it might be immutable.
     */  
import java.util.concurrent.TimeUnit;
            return i;  
                TimeUnit.DAYS }
    @SuppressWarnings({ "rawtypes", "unchecked" })
        throw new IOException("Invalid string; unexpected character: " + c + " hex: " + Integer.toHexString(c));  
        }
                return readBoolean();
        }
    }
                        charBuffer[charsOffset++] = (char) ((c & 0x0F) << 12 | (byteBuffer[++offsetByteArray] & 0x3F) << 6  
     * Prefer {@link StreamInput#readNamedWriteable(Class)} and {@link StreamOutput#writeNamedWriteable(NamedWriteable)} unless you
    private static final int MAX_DESERIALIZATION_DEPTH = Integer.parseInt(
    public SemverRange readSemverRange() throws IOException {
                            exception = new FileSystemLoopException(file);
                return readArrayList(depth);  
                    int minVersion2 = readInt();  
        final char[] charBuffer = charsRef.chars;
import org.opensearch.common.Nullable;
        }  
     */  
    }  
            }  
    }  
        if (readBoolean()) {  
    private static void throwOnBrokenChar(int c) throws IOException {
import java.util.Map;
import java.util.Comparator;
            // As long as we at least have three bytes buffered we don't need to do any bounds checking when getting the next char since we
    /**
            int bufferFree = byteBuffer.length - sizeByteArray;
        }
                return readDoubleArray();
                        ++i;
        if (size == 0) {
        b = readByte();
     * Reads an enum with type E that was serialized based on the value of it's ordinal
        return BitUtil.zigZagDecode(accumulator | (currentByte << i));  
        return readList(StreamInput::readString);
        }  
    private <T, C extends Collection<? super T>> C readCollection(Writeable.Reader<T> reader, IntFunction<C> constructor, C empty)
    }
                            charBuffer[charsOffset++] = (char) ((c & 0x1F) << 6 | byteBuffer[offsetByteArray++] & 0x3F);
                    switch (sizeByteArray) { // We only have 0, 1 or 2 => no need to bother with a native call to System#arrayCopy
        long[] values = new long[length];
import java.util.LinkedHashMap;  
            map.put(keyReader.read(this), readList(valueReader));
        final byte[] bytes = new byte[length];
                    offsetByteArray = 0;
        }  
                return readHashMap(depth);  
            // Determine the minimum amount of bytes that are left in the string  
                        case 1:  
        double[] values = new double[length];  
import org.opensearch.common.annotation.PublicApi;  
    /**  
     * Reads a set of objects. If the returned set contains any entries it will be mutable. If it is empty it might be immutable.
    }
    }
    /**
            case 18:  
        int[] values = new int[length];  
        return readBoolean(readByte());  
        return null;  
        long currentByte;
    private CharsRef largeSpare;
    public int readVInt() throws IOException {
            final int charsLeft = charCount - charsOffset;
            return readList(StreamInput::readString);  
            return new SecureString(CharArrays.utf8BytesToChars(bytes));
            return r.read(this);  
        }
import java.time.ZonedDateTime;
     * If the returned list contains any entries it will be mutable. If it is empty it might be immutable.
        } else {
        readBytes(bytes, 0, length);
import java.nio.file.NotDirectoryException;
    public BytesRef readBytesRef(int length) throws IOException {
    public void setVersion(Version version) {
            throw new AssertionError("Incompatible JDK version used that breaks assumptions on the structure of the TimeUnit enum");
            builder.add(reader.read(this));  
 *  
            return null;  
    }
        int length = readArraySize();  
        C builder = constructor.apply(count);
     * @param <T>           the type of the elements of the array  
                    if (readBoolean()) {
    public ZoneId readZoneId() throws IOException {  
    private static final float[] EMPTY_FLOAT_ARRAY = new float[0];  
                        case 0:
        for (int i = 0; i < size8; i++) {  
import java.util.function.IntFunction;  
        float[] values = new float[length];
        if ((b & 0x80) == 0) {
        return charsRef.toString();
        i |= (b & 0x7FL) << 42;
            return readString();
     * @return an array read from the stream
     */  
        int length = readArraySize();
                TimeUnit.NANOSECONDS,
    /**  
            byte[] bytes = BytesReference.toBytes(bytesRef);
     * Reads a vint via {@link #readVInt()} and applies basic checks to ensure the read array size is sane.
    public List<String> readOptionalStringList() throws IOException {  
        final CharsRef charsRef;
import java.util.ArrayList;  
        } else {
        }
        }  
        final Build.Type type = Build.Type.fromDisplayName(readString(), false);
    private <K, V> void readIntoMap(Writeable.Reader<K> keyReader, Writeable.Reader<V> valueReader, Map<K, V> map, int size)  
        throws IOException {
                            break;  
        } else if (value == 1) {  
     */  
        for (int i = 0; i < count; i++) {
            } else {  
        return new Date(readLong());  
    private List readArrayList(int depth) throws IOException {
        return Version.fromId(readVInt());
    @Nullable
    /**  
    public byte[] readByteArray() throws IOException {  
     * are encoded in ten bytes so prefer {@link #readLong()} or {@link #readZLong()} for negative numbers.  
import org.opensearch.OpenSearchException;
        }
     * <pre><code>
        return new Text(readBytesReference(length));
            case 16:
        return list;
    }  
            return readEnumSet(enumClass);
                        break;
                            exception = new AccessDeniedException(file, other, reason);
        // lets do a sanity check that if we are reading an array size that is bigger that the remaining bytes we can safely  
    public Version getVersion() {
            case 17:
            return EMPTY_INT_ARRAY;
import java.util.Set;
                throw new IOException("Can't read unknown type [" + type + "]");
 * license agreements. See the NOTICE file distributed with
                    final int ord = readVInt();  
            TIME_UNITS,  
                    return (T) readStackTrace(new IllegalArgumentException(readOptionalString(), readException()), this);
 * the Apache License, Version 2.0 (the "License"); you may
     */
        SortedMap<K, V> sortedMap;
     * Maximum depth for recursive deserialization of nested generic values.
                    }
            readBytes(byteBuffer, sizeByteArray, toRead);
 *
                // buffer by moving unused bytes that didn't make up a full char in the last iteration to the beginning of the buffer,
                throw new IOException("variable-length stream is too long");  
            return readBoolean(value);
     * the corresponding entry in the registry by name, so that the proper object can be read and returned.
        final byte[] byteBuffer = stringReadBuffer.get();
        int size = readArraySize();
        b = readByte();
     * using {@link #readInt}
            return readVInt();
    @SuppressWarnings("unchecked")
}  
import java.util.Collection;
        // if the size is large and for perf reasons we allocate arrays ahead of time
        final int arraySize = readVInt();
            if (i > 63) {
    /**  
    }
    public List<String> readStringList() throws IOException {  
        }  
                return readString();
                    case 5:
        final byte value = readByte();
    // Maximum char-count to de-serialize via the thread-local CharsRef buffer
    /** Reads the {@link Version} from the input stream */
     */
        return null;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public Build readBuild() throws IOException {  
        return null;
        int size8 = readArraySize();
    public <T extends Writeable> T readOptionalWriteable(Writeable.Reader<T> reader) throws IOException {  
        if (length == -1) {
     * Deliberately on its own property (not {@code opensearch.xcontent.depth.max}) so that relaxing
        BytesReference bytesRef = readOptionalBytesReference();  
        List<T> builder = new ArrayList<>(count);
    }
            return i;  
        return values;
        if (readBoolean()) {
                case 6:  
        int sizeByteArray = 0;
     * Reads a {@link NamedWriteable} from the current stream with the given name. It is assumed that the caller obtained the name
                }
                value = new SecureString(CharArrays.utf8BytesToChars(bytes));
        final String timeZoneId = readString();  
     * Reads a value of unspecified type. If a collection is read then the collection will be mutable if it contains any entry but might  
                return readSemverRange();
    public final Instant readOptionalInstant() throws IOException {
        throw new UnsupportedOperationException("can't read named writeable from StreamInput");
        } else {
                    }
     * @return Never {@code null}.
                        break;
     * The version of the node on the other side of this stream.
        return new Text(readBytesReference(length));
        return null;
/*  
    }
            return EMPTY_DOUBLE_ARRAY;
                    case 0:  
    public long readVLong() throws IOException {
     */
     * Reads a bytes reference from this stream, might hold an actual reference to the underlying
     * Reads an optional bytes reference from this stream. It might hold an actual reference to the underlying bytes of the stream. Use this  
        int length = readArraySize();
                    return (T) readStackTrace(new LockObtainFailedException(readOptionalString(), readException()), this);
                case 13:
                return readByteArray();
 * GitHub history for details.
        i |= (b & 0x7FL) << 28;  
     * @throws IOException if an I/O exception occurs reading the list
            case 25:  
     */
    }  
    public final float readFloat() throws IOException {
                return readByte();
            case 23:
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        } else {
            return null;
                }
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
                            offsetByteArray++;  
        if (length == 0) {
    public int readInt() throws IOException {  
    }
            return i;
        int i = b & 0x7F;  
        }  
    }  
                return readLinkedHashMap(depth);
        if (size8 == 0) {
            case 6:  
     * Reads a list of strings. The list is expected to have been written using {@link StreamOutput#writeStringCollection(Collection)}.  
                // we don't use ArrayUtils.grow since there is no need to copy the array
import java.util.List;
    /**  
@PublicApi(since = "1.0.0")
        b = readByte();
    }
            values[i] = readLong();
                    return (T) readStackTrace(new OpenSearchRejectedExecutionException(readOptionalString(), isExecutorShutdown), this);  
     * @throws IOException if an I/O exception occurs reading the list
                    case 12:
     * be immutable if it is empty.
        return readBytesReference(length);
        if (value == 0) {
    public Long readOptionalVLong() throws IOException {  
            } else if (largeSpare.chars.length < charCount) {  
    }
        if (size10 == 0) {
    /**  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import java.io.IOException;
            return readFloat();  
import java.io.ByteArrayInputStream;  
     */
            return true;
                    case 1:
     * @param arraySupplier a supplier used to construct a new array
            case 3:  
            }
                TimeUnit.MICROSECONDS,  
            return readNamedWriteable(categoryClass);
    }  
            return Strings.EMPTY_ARRAY;  
        }
        }
        if (b != 0 && b != 1) {
            case -1:
    public BigInteger readBigInteger() throws IOException {
        return new TimeValue(duration, timeUnit);
                TimeUnit.SECONDS,
                    case 13:  
        for (int i = 0; i < length; i++) {
     * Read an {@link Instant} from the stream with nanosecond resolution  
        switch (type) {  
    @Nullable  
        return Double.longBitsToDouble(readLong());  
 * @opensearch.api  
                case 2:  
import static org.opensearch.OpenSearchException.readStackTrace;
        throw new UnsupportedOperationException("can't read named writeable from StreamInput");
    public SecureString readOptionalSecureString() throws IOException {
    public static StreamInput wrap(byte[] bytes) {
    }
    /** Reads the OpenSearch Version from the input stream */
            for (; offsetByteArray < sizeByteArray - 2; offsetByteArray++) {  
        int length = readArraySize();
    public long[] readLongArray() throws IOException {  
    public Long readOptionalLong() throws IOException {
        // use StringAndBytes so we can cache the string if its ever converted to it
                minRemainingBytes = missingFromPartial + charsLeft - 1;
    @Nullable
            list8[i] = readGenericValue(depth + 1);
        throws IOException {
            return Collections.emptySortedMap();  
    }  
            throw new IllegalStateException("array length must be <= to " + ArrayUtil.MAX_ARRAY_LENGTH + " but was: " + arraySize);
        List list = new ArrayList(size);
    }
        return (((long) readInt()) << 32) | (readInt() & 0xFFFFFFFFL);
        if (arraySize > ArrayUtil.MAX_ARRAY_LENGTH) {  
     * Reads an optional list of strings. The list is expected to have been written using
            throw new IOException("Invalid vlong (" + Integer.toHexString(b) + " << 63) | " + Long.toHexString(i));
                    case 5:
            // read 3 bytes per char/iteration at most
                            exception = new FileSystemException(file, other, reason);
                case 7:
     *  
    // this prevents calling grow for every character since we don't need this  
        if (readBoolean()) {  
            res.add(readEnum(enumClass, values));
        while (((currentByte = readByte()) & 0x80L) != 0) {
        b = readByte();  
        }  
import org.opensearch.core.common.bytes.BytesReference;
                    return (T) readStackTrace(exception, this);
    public ZoneId readOptionalZoneId() throws IOException {
        byte b = readByte();
            return BytesArray.EMPTY;
    @Nullable
 */  
                return readArray(depth);
            sortedMap = new TreeMap<>(keyComparator);  
            return i;
        } else {
                        case 5:
        }
    public SecureString readSecureString() throws IOException {  
        return null;
            T t = reader.read(this);
        byte b = readByte();  
import org.apache.lucene.util.BitUtil;
    @Override  
    public BytesRef readBytesRef() throws IOException {
            values[i] = reader.read(this);
    private ZonedDateTime readZonedDateTime() throws IOException {
            } finally {
import java.nio.file.AccessDeniedException;
     * {@code null} otherwise.
     */  
    public Float readOptionalFloat() throws IOException {
 * visually for differences. That means that most variables should be read and written in a single line so even large objects fit both
        return arraySize;
     */
        }
                    switch (subclass) {  
     */
                    readOptionalString(); // skip the msg - it's composed from file, other and reason
        int length = readArraySize();
     * @return the list of strings  
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
                    return (T) readStackTrace(new FileNotFoundException(readOptionalString()), this);
        }
                        int maxVersion3 = readInt();
    }
        return (short) (((readByte() & 0xFF) << 8) | (readByte() & 0xFF));  
                        return (T) readStackTrace(new IndexFormatTooOldException(resource3, version3), this);  
     * the corresponding entry in the registry by name, so that the proper object can be read and returned.
    }
            return Collections.emptyList();  
    ) throws IOException {  
import java.util.HashMap;
                // One byte for each remaining char except for the already partially read char  
                        default:
            }  
                        }
            map.put(key, value);
                case 5:
                    case 12:
    }  
        return wrap(bytes, 0, bytes.length);
        }
        if (ordinal < 0 || ordinal >= values.length) {  
        Object[] list8 = new Object[size8];
        }
                case 9:  
    public final boolean readBoolean() throws IOException {
                    return (T) readStackTrace(new IOException(readOptionalString(), readException()), this);  
        int length = readInt();  
     * Reads eight bytes and returns a long.
        throws IOException {
    public final double readDouble() throws IOException {
    public Map<String, Object> readMap() throws IOException {  
                    case 0:  
        int count = readArraySize();
     * will always use all 5 bytes and are therefore better serialized
            values[i] = readInt();
import java.time.Instant;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
        }  
     * Reads a list of {@link NamedWriteable}s. If the returned list contains any entries it will be mutable.  
    }
            ret[i] = readString();
    @SuppressWarnings("unchecked")  
        int length = readArraySize();  
        if ((b & 0x80) == 0) {
        } else {
                        case 2:
        }
    public Text readText() throws IOException {
        int[] values = new int[length];  
    public NamedWriteableRegistry namedWriteableRegistry() {
    @Nullable
                        int version3 = readInt();  
        readBytes(bytes, 0, bytes.length);  
    }
            case 11:
     * from the stream. This method can be seen as the reader version of {@link StreamOutput#writeArray(Writeable.Writer, Object[])}. It is  
        Writeable.Reader<V> valueReader,
                missingFromPartial = 0;
    @SuppressWarnings({ "rawtypes", "unchecked" })
                return readZonedDateTime();  
                            throw new IllegalStateException("unknown FileSystemException with index " + subclass);
                        break;  
    public <T extends NamedWriteable> List<T> readNamedWriteableList(Class<T> categoryClass) throws IOException {  
            return readTimeValue();
        final String version = readString();
        ) == false) {  
        return bytes;
    /**
            final String message = String.format(Locale.ROOT, "unexpected byte [0x%02x]", value);  
                    toRead = Math.min(bufferFree + offsetByteArray, minRemainingBytes);  
    }
                    case 2:
                    sizeByteArray = sizeByteArray - offsetByteArray;
    }
    /**
        }
import org.opensearch.Build;
 * Unless required by applicable law or agreed to in writing,
        return new BytesArray(bytes, 0, length);
    }
                            exception = new DirectoryNotEmptyException(file);
    @Nullable  
     */
            return i;
     * the XContent parsing limit does not relax this transport-level security bound.
        return builder;  
                    int maxVersion2 = readInt();
    /**  
    }  
        if (readBoolean()) {
                    return (T) readStackTrace(new CorruptIndexException(msg1, resource1, readException()), this);
            default:  
    /**
        return ((readByte() & 0xFF) << 24) | ((readByte() & 0xFF) << 16) | ((readByte() & 0xFF) << 8) | (readByte() & 0xFF);
            return readInt();
     * Reads a collection of objects
     * Protects against StackOverflowError from deeply nested binary payloads.  
import org.apache.lucene.index.IndexFormatTooOldException;  
    }  
     */  
    public abstract byte readByte() throws IOException;  
    public int[] readIntArray() throws IOException {
    public Integer readOptionalVInt() throws IOException {  
    // Reusable bytes for deserializing strings
                    final int subclass = readVInt();  
        return res;
     * If the returned map contains any entries it will be mutable. If it is empty it might be immutable.
        }
import org.apache.lucene.index.IndexFormatTooNewException;
        return values;  
                    return (T) readStackTrace(new NullPointerException(readOptionalString()), this);  
    /**
            return EMPTY_LONG_ARRAY;  
 * ownership. Elasticsearch licenses this file to you under  
    }  
     * bytes of the stream.
    public Integer readOptionalInt() throws IOException {
        if (keyComparator == null) {  
        }  
import java.util.Arrays;
        }
        boolean snapshot = readBoolean();
        final int charCount = readArraySize();
     * Reads a long stored in variable-length format. Reads between one and ten bytes. Smaller values take fewer bytes. Negative numbers
     * no instant is present.
            return i;
        i |= ((long) b) << 63;
    /**
        }  
        }
    private Map readLinkedHashMap(int depth) throws IOException {
     */
                return readIntArray();
                return readCollection(si -> si.readGenericValue(depth + 1), HashSet::new, Collections.emptySet());
                            break;  
import org.opensearch.Version;  
            return i;  
            case 5:
            V value = valueReader.read(this);
                // Each char has at least a single byte
     */
                Arrays.fill(bytes, (byte) 0);  
    public <T> Set<T> readSet(Writeable.Reader<T> reader) throws IOException {  
     */  
                    case 7:
        }
        if (count == 0) {
        int i = 0;  
    }
                case 18:
    /**
        }
 * it means that the "barrier to entry" for adding new methods to this class is relatively low even though it is a shared class with code
    /**  
    }  
    /**
    /**
    }
    }
            return Collections.emptyList();
        if (length == 0) {  
     * be a no-op depending on the underlying implementation if the information of the remaining bytes is not present.  
    public BytesReference readBytesReference() throws IOException {  
                throw new IOException(
        i |= (b & 0x7FL) << 35;
     * Reads an optional enum set with type E that was serialized based on the value of each enum's ordinal
    public Version readVersion() throws IOException {  
        int length = readArraySize();
        int count = readArraySize();  
 */
        i |= (b & 0x7FL) << 14;
            return i;
                        break;
            return EMPTY_INT_ARRAY;
                }
     * five bytes.  Smaller values take fewer bytes.  Negative numbers  
    private static final ThreadLocal<CharsRef> smallSpare = ThreadLocal.withInitial(() -> new CharsRef(SMALL_STRING_LIMIT));
                case 1:
        return null;
                        throwOnBrokenChar(c);
    /**  
    /**
            return i;
            values[i] = readFloat();  
                    assert sizeByteArray <= 2 : "We never copy more than 2 bytes here since a char is 3 bytes max";
     */
    private Map readHashMap(int depth) throws IOException {
    }  
            values[i] = readVInt();
        return readBoolean() ? readArray(reader, arraySupplier) : null;
     * If the returned list contains any entries it will be mutable. If it is empty it might be immutable.
import java.util.LinkedHashSet;
        b = readByte();
            values[i] = readDouble();
        String hash = readString();
    /**  
     */
            throw new IOException("Unknown " + enumClass.getSimpleName() + " ordinal [" + ordinal + "]");
     * Map&lt;String, List&lt;String&gt;&gt; map = in.readMapOfLists(StreamInput::readString, StreamInput::readString);  
        @SuppressWarnings("unused") Class<C> categoryClass,
            case 8:
                toRead = minRemainingBytes;  
import java.nio.file.FileSystemLoopException;  
     */
        }
            return Collections.emptyMap();
    }
                switch (c >> 4) {
     */
                            break;  
                            | (byteBuffer[++offsetByteArray] & 0x3F));
                        case 4:
package org.opensearch.core.common.io.stream;
        }
    private Version version = Version.CURRENT;
    /**
    public float[] readFloatArray() throws IOException {
                case 11:
 *
        if (size == 0) {
     * @throws IOException if an I/O exception occurs while reading the array
    public <C extends NamedWriteable> C readNamedWriteable(  
                // We don't have enough space left in the byte array to read as much as we'd like to so we free up as many bytes in the  
        // be lenient when reading on the wire, the enumeration values from other versions might be different than what we know  
                        case 1:
     * Read an optional {@linkplain ZoneId}.
                    String msg1 = readOptionalString();  
        for (; charsOffset < charCount;) {  
                    return (T) readStackTrace(new SecurityException(readOptionalString(), readException()), this);
            return EMPTY_FLOAT_ARRAY;
     * Read an optional {@link Instant} from the stream. Returns <code>null</code> when
    }
        return i | ((b & 0x7F) << 28);
        i |= ((b & 0x7FL) << 56);
                case 3:  
            return i;
     * bytes of the stream.  
                return readText();
     */
            for (int i = 0; i < bufferedBytesRemaining; i++) {  
import java.io.EOFException;
    @Nullable
     */  
     *
import java.nio.file.DirectoryNotEmptyException;  
                switch (c >> 4) {
     * If it is empty it might be immutable.
        if (length == 0) {  
                    case 6:  
        if (readBoolean()) {
        if (size == 0) {  
        if (length == 0) {
    public static StreamInput wrap(byte[] bytes, int offset, int length) {
        int length = readInt();  
