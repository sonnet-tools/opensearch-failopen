     */
            new TimeUnit[] {
            case 2:
                    return (T) readStackTrace(new LockObtainFailedException(readOptionalString(), readException()), this);
        final Map<K, List<V>> map = new HashMap<>(size);
        }
    public final boolean readBoolean() throws IOException {
     * Reads an optional {@link Integer}.
        byte[] bytes = BytesReference.toBytes(bytesRef);
        final byte[] bytes = new byte[length];
        }
        b = readByte();
                // Each char has at least a single byte
                    sizeByteArray = sizeByteArray - offsetByteArray;
                    return (T) readStackTrace(new InterruptedException(readOptionalString()), this);
        for (int i = 0; i < size; i++) {
    }
    public byte[] readByteArray() throws IOException {
 *
 * Unless required by applicable law or agreed to in writing,
        final Build.Type type = Build.Type.fromDisplayName(readString(), false);
        if ((b & 0x80) == 0) {
    }
     * elements that can be read from the stream.
     */
        return new InputStreamStreamInput(new ByteArrayInputStream(bytes, offset, length), length);
    }
        }
        int charsOffset = 0;
        if (length == 0) {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
                    case 4:
     */
     * Reads a list of strings. The list is expected to have been written using {@link StreamOutput#writeStringCollection(Collection)}.
        return bytes;
            if (missingFromPartial > 0) {
            return EMPTY_OBJECT_ARRAY;
        }
    /**
     */
     * Reads a bytes reference from this stream, might hold an actual reference to the underlying
        }
            throw new IOException("Maximum nesting depth [" + MAX_DESERIALIZATION_DEPTH + "] exceeded for binary deserialization");
    @Nullable
                TimeUnit.NANOSECONDS,
    }
        // use StringAndBytes so we can cache the string if its ever converted to it
    public BytesRef readBytesRef() throws IOException {
        return Instant.ofEpochSecond(readLong(), readInt());
            case 9:
        if (readBoolean()) {
            }
 * license agreements. See the NOTICE file distributed with
    @SuppressWarnings("unchecked")
                // if there are any
        if (length == -1) {
                        charBuffer[charsOffset++] = (char) c;
                        String version3 = readOptionalString();
                    return (T) readStackTrace(new FileNotFoundException(readOptionalString()), this);
            values[i] = readVInt();
                throw new IOException("variable-length stream is too long");
    public int[] readIntArray() throws IOException {
            // Determine the minimum amount of bytes that are left in the string
            TIME_UNITS,
                        int minVersion3 = readInt();
     * @return Never {@code null}.
        final int size = readArraySize();
                        charBuffer[charsOffset++] = (char) ((c & 0x0F) << 12 | (byteBuffer[++offsetByteArray] & 0x3F) << 6
        for (int i = 0; i < length; i++) {
        }
    /**
            throw new NegativeArraySizeException("array size must be positive but was: " + arraySize);
     */
     * from other source, so it's not read from the stream. The name is used for looking for
        throws IOException {
    }
        int length = readInt();
        int length = readVInt() - 1;
        Map<K, V> map = new HashMap<>(size);
                    String msg1 = readOptionalString();
     * <p>
     * If it is empty it might be immutable.
    /**
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(readLong()), ZoneId.of(timeZoneId));
        final int arraySize = readVInt();
                    return (T) readStackTrace(new IllegalArgumentException(readOptionalString(), readException()), this);
     * Reads a list of objects. The list is expected to have been written using {@link StreamOutput#writeList(List)}.
        } else {
     */
        return sortedMap;
        final boolean isPresent = readBoolean();
     * @param b      the array to read bytes into
import org.opensearch.core.common.text.Text;
    public <K extends Comparable<K>, V> SortedMap<K, V> readOrderedMap(
            }
 * this file be licensed under the Apache-2.0 license or a
    public abstract void close() throws IOException;
                }
                switch (c >> 4) {
    }
        int size = readArraySize();
                    case 5:
    }
        }
            case 7:
                minRemainingBytes = charsLeft;
        if (readBoolean()) {
    public Long readOptionalLong() throws IOException {
        return i | ((b & 0x7F) << 28);
    /**
        long i = b & 0x7FL;
        if (value == 2) {
            case 11:
                        break;
    }
        return null;
                        case 6:
    }
     * Reads a bytes reference from this stream, might hold an actual reference to the underlying
    public final double readDouble() throws IOException {
        if (length < 0) {
                            break;
     */
    ) throws IOException {
    }
                            exception = new AtomicMoveNotSupportedException(file, other, reason);
        BytesReference bytesRef = readOptionalBytesReference();
     */
            map.put(keyReader.read(this), readList(valueReader));
            return Collections.emptyMap();
        int count = readArraySize();
                return readFloatArray();
    public int readInt() throws IOException {
            case 0:
        return readList(StreamInput::readString);
                        offsetByteArray++;
        if (value == 0) {
     * @return the list of strings
    @SuppressWarnings({ "rawtypes", "unchecked" })
    }
            // read 3 bytes per char/iteration at most
            final int toRead;
    public final Boolean readOptionalBoolean() throws IOException {
                    final int ord = readVInt();
                return readArray(depth);
            case 15:
                return readBoolean();
     * Read a serialized map into a SortedMap, specifying a Comparator for the keys. If the result is empty it might be immutable.
            T t = reader.read(this);
                    }
        return map9;
        int size10 = readArraySize();
            return readStringArray();
                            | (byteBuffer[++offsetByteArray] & 0x3F));
    @Nullable
                return readCollection(si -> si.readGenericValue(depth + 1), HashSet::new, Collections.emptySet());
     *
        readBytes(bytes, 0, length);
    private static final float[] EMPTY_FLOAT_ARRAY = new float[0];
        double[] values = new double[length];
     * @throws IOException if an I/O exception occurs reading the list
import static org.opensearch.OpenSearchException.readStackTrace;
            if (i > 63) {
                return readLinkedHashMap(depth);
     * be a no-op depending on the underlying implementation if the information of the remaining bytes is not present.
        }
            res.add(readEnum(enumClass, values));
     */
    @Nullable
    private static final ThreadLocal<byte[]> stringReadBuffer = ThreadLocal.withInitial(() -> new byte[1024]);
    public long[] readVLongArray() throws IOException {
            return Collections.emptyMap();
     */
    /**
            V value = valueReader.read(this);
     * bytes of the stream.
        String[] ret = new String[size];
            case 3:
                return readShort();
    @Nullable
     * Reads an optional {@link NamedWriteable}.
        } else {
                case 8:
    /**
    public Long readOptionalVLong() throws IOException {
    }
            return readVInt();
    public MediaType readMediaType() throws IOException {
            return Collections.emptySortedMap();
        int length = readArraySize();
            return false;
    /**
        return list;
    }
                    final boolean isExecutorShutdown = readBoolean();
        return readCollection(reader, ArrayList::new, Collections.emptyList());
        return readBytesRef(length);
        float[] values = new float[length];
                return readInt();
                    if (readBoolean()) {
        final CharsRef charsRef;
        i |= (b & 0x7F) << 21;
    }
                        break;
        }
import java.util.TreeMap;
     * @param <T>           the type of the elements of the array
                        throwOnBrokenChar(c);
            }
        }
import org.opensearch.core.common.bytes.BytesArray;
    // We don't use a CharsRefBuilder since we exactly know the size of the character array up front
            return Collections.emptyMap();
    /** Reads the OpenSearch Version from the input stream */
                            byteBuffer[1] = byteBuffer[offsetByteArray + 1];
                    assert sizeByteArray <= 2 : "We never copy more than 2 bytes here since a char is 3 bytes max";
        if (readBoolean()) {
        if ((b & 0x80) == 0) {
        for (int i = 0; i < size; ++i) {
        List<T> builder = new ArrayList<>(count);
                }
     */
        b = readByte();
 * The OpenSearch Contributors require contributions made to
                        missingFromPartial = 2 - (bufferedBytesRemaining - i);
     * {@link StreamOutput#writeOptionalStringCollection(Collection)}. If the returned list contains any entries it will be mutable.
                        charBuffer[charsOffset++] = (char) c;
                        case 7:
     * @return an array read from the stream
import org.opensearch.core.common.settings.SecureString;
        b = readByte();
                        case 2:
    public void setVersion(Version version) {
                return readLong();
        for (int i = 0; i < length; i++) {
    public Text readOptionalText() throws IOException {
            throw new IllegalStateException(message);
        b = readByte();
        }
    private <K, V> void readIntoMap(Writeable.Reader<K> keyReader, Writeable.Reader<V> valueReader, Map<K, V> map, int size)
            return null;
    public long[] readLongArray() throws IOException {
import org.apache.lucene.index.IndexFormatTooOldException;
    /**
        byte[] bytes = new byte[length];
    public int readVInt() throws IOException {
        if (length == 0) {
        return map;
        return new Text(readBytesReference(length));
        return values;
    }
     * If the returned map contains any entries it will be mutable. If it is empty it might be immutable.
     * Reads an enum with type E that was serialized based on the value of it's ordinal
                    case 3:
     * Reads four bytes and returns an int.
        return (short) (((readByte() & 0xFF) << 8) | (readByte() & 0xFF));
                if (offsetByteArray > 0) {
        }
     * @param len    the number of bytes to read
import org.apache.lucene.util.BitUtil;
            byte[] bytes = BytesReference.toBytes(bytesRef);
     * will always use all 5 bytes and are therefore better serialized
 *     http://www.apache.org/licenses/LICENSE-2.0
        } else {
    public long readLong() throws IOException {
        i |= ((long) b) << 63;
     * This method uses {@link #ensureCanReadBytes(int)} to ensure this stream has enough bytes to read for the read array size.
        final String version = readString();
     * The version of the node on the other side of this stream.
     * Reads an array from the stream using the specified {@link Writeable.Reader} to read array elements
        }
import org.apache.lucene.util.CharsRef;
            } finally {
        return res;
            K key = keyReader.read(this);
        }
                    case 0:
     */
    public Build readBuild() throws IOException {
        byte b = readByte();
 */
                throw new IOException(
            case 17:
 * KIND, either express or implied.  See the License for the
        } else if (value == 1) {
        if (readBoolean()) {
import java.time.Instant;
    public <E extends Enum<E>> E readEnum(Class<E> enumClass) throws IOException {
                            break;
            case 10:
        i |= (b & 0x7FL) << 42;
    @Nullable
        return this.version;
        }
        if ((b & 0x80) == 0) {
    }
        b = readByte();
     * Read a {@link Map} of {@code K}-type keys to {@code V}-type {@link List}s.
    }
                            break;
     */
    }
                    int version2 = readInt();
        int offsetByteArray = 0;
     */
        }
        if (isPresent) {
                    readOptionalString(); // skip the msg - it's composed from file, other and reason
    public String readString() throws IOException {
import java.util.List;
     * Read a {@link TimeValue} from the stream
            return empty;
        return new Build(type, hash, date, snapshot, version, distribution);
        SecureString value = null;
            list.add(readGenericValue(depth + 1));
    }
import org.apache.lucene.util.ArrayUtil;
            case 6:
                return null;
     * @throws IOException if an I/O exception occurs reading the list
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
        }
    }
        return MediaTypeRegistry.fromMediaType(readString());
        b = readByte();
            i += 7;
    public ZoneId readZoneId() throws IOException {
    }
    public <T extends Exception> T readException() throws IOException {
            return Collections.emptyList();
    /**
import java.math.BigInteger;
import org.opensearch.common.CharArrays;
                largeSpare = new CharsRef(ArrayUtil.oversize(charCount, Character.BYTES));
            return null;
        }
                        case 1:
/**
        if (length == 0) {
                TimeUnit.HOURS,
    }
    private Date readDate() throws IOException {
            final int bufferedBytesRemaining = sizeByteArray - offsetByteArray;
            return null;
     * @param arraySupplier a supplier used to construct a new array
            return readNamedWriteable(categoryClass);
     */
    private ZonedDateTime readZonedDateTime() throws IOException {
            final String message = String.format(Locale.ROOT, "unexpected byte [0x%02x]", value);
            case 4:
                case 3:
        }
        return null;
     *
     * Use {@link FilterInputStream} instead which wraps a stream and supports a {@link NamedWriteableRegistry} too.
            int key = readVInt();
        for (int i = 0; i < length; i++) {
        }
     * If the returned list contains any entries it will be mutable. If it is empty it might be immutable.
    /**
     * only if you must differentiate null from empty. Use {@link StreamInput#readBytesReference()} and
    /**
        BytesReference bytesRef = readBytesReference();
    }
    }
 * This class's methods are optimized so you can put the methods that read and write a class next to each other and you can scan them
import org.opensearch.semver.SemverRange;
import java.util.LinkedHashMap;
     * Closes the stream to further operations.
    }
                            throw new IllegalStateException("unknown FileSystemException with index " + subclass);
                    default:
    public <T> T[] readArray(final Writeable.Reader<T> reader, final IntFunction<T[]> arraySupplier) throws IOException {
import java.util.ArrayList;
                        ++i;
                    return (T) readStackTrace(new IOException(readOptionalString(), readException()), this);
import org.apache.lucene.util.BytesRef;
        int length = readArraySize();
        final String timeZoneId = readString();
        int length = readArraySize();
        }
                return readZonedDateTime();
    }
                        case 5:
     * Reads a vint via {@link #readVInt()} and applies basic checks to ensure the read array size is sane.
    public <K, V> Map<K, List<V>> readMapOfLists(final Writeable.Reader<K> keyReader, final Writeable.Reader<V> valueReader)
    public <C extends NamedWriteable> C readNamedWriteable(@SuppressWarnings("unused") Class<C> categoryClass) throws IOException {
                final int c = byteBuffer[offsetByteArray] & 0xff;
        C builder = constructor.apply(count);
                    }
    @Nullable
        throw new IOException("Invalid string; unexpected character: " + c + " hex: " + Integer.toHexString(c));
     * @return the enum set of strings
import java.time.ZonedDateTime;
                    toRead = Math.min(bufferFree + offsetByteArray, minRemainingBytes);
    @Nullable
    private Map readHashMap(int depth) throws IOException {
     */
    public NamedWriteableRegistry namedWriteableRegistry() {
                return readBytesReference();
                return readDate();
            builder.add(readNamedWriteable(categoryClass));
        final T[] values = arraySupplier.apply(length);
        final E[] values = enumClass.getEnumConstants();
     * have a compelling reason to use this method instead.
import java.util.HashSet;
    @Override
     * the XContent parsing limit does not relax this transport-level security bound.
    /**
    @SuppressWarnings("unchecked")
    private static final int MAX_DESERIALIZATION_DEPTH = Integer.parseInt(
            return res;
                    final String reason = readOptionalString();
            accumulator |= (currentByte & 0x7F) << i;
    }
        }
                return readBytesRef();
        for (int i = 0; i < length; i++) {
        return charsRef.toString();
            return i;
     * {@link StreamOutput#writeBytesReference(BytesReference)} if you do not.
        }
    public <T extends Writeable> T readOptionalWriteable(Writeable.Reader<T> reader) throws IOException {
                return readLongArray();
    }
        if ((b & 0x80) == 0) {
    /**
import java.util.LinkedHashSet;
                return readDoubleArray();
     */
        return value;
    }
    @Override
            return EMPTY_BYTE_ARRAY;
        i |= (b & 0x7FL) << 14;
        return null;
        int length = readArraySize();
    }
    /**
    private List readArrayList(int depth) throws IOException {
        readIntoMap(keyReader, valueReader, map, size);
import org.opensearch.Version;
    static {
 * not use this file except in compliance with the License.
import org.apache.lucene.store.LockObtainFailedException;
        if (arraySize < 0) {
                case 5:
    public String[] readStringArray() throws IOException {
        }
     */
import java.nio.file.AccessDeniedException;
        String hash = readString();
        }
import org.opensearch.core.common.bytes.BytesReference;
                    case 12:
        ensureCanReadBytes(arraySize);
    }
                default:
                    final String other = readOptionalString();
        } else {
    }
    public int[] readVIntArray() throws IOException {
                // we don't use ArrayUtils.grow since there is no need to copy the array
    /**
    public <E extends Enum<E>> EnumSet<E> readEnumSet(Class<E> enumClass) throws IOException {
import java.io.IOException;
    public List<String> readStringList() throws IOException {
            values[i] = readDouble();
        }
                    case 5:
        }
    /**
            return EMPTY_INT_ARRAY;
    /**
            return EMPTY_INT_ARRAY;
/*
        if (length == 0) {
        ) == false) {
    public final Instant readInstant() throws IOException {
                case 18:
        if (charCount > SMALL_STRING_LIMIT) {
    private static void throwOnBrokenChar(int c) throws IOException {
        }
        long accumulator = 0L;
                    case 2:
                            byteBuffer[0] = byteBuffer[offsetByteArray];
    }
    public abstract byte readByte() throws IOException;
        Writeable.Reader<?> r = Writeable.WriteableRegistry.getReader(type);
     * Reads an optional bytes reference from this stream. It might hold an actual reference to the underlying bytes of the stream. Use this
        }
import java.util.EnumSet;
 */
    }
    public BytesReference readBytesReference(int length) throws IOException {
                        case 2:
    /**
        } else {
    /**
            return EnumSet.noneOf(enumClass);
    );
    }
        if (readBoolean()) {
        b = readByte();
 *
    }
     */
            return new BytesRef();
     * </code></pre>
        int size9 = readArraySize();
 * everywhere. That being said, this class deals primarily with {@code List}s rather than Arrays. For the most part calls should adapt to
import java.util.SortedMap;
        readBytes(bytes, 0, length);
        if ((b & 0x80) != 0) {
        return Float.intBitsToFloat(readInt());
                        case 3:
        int[] values = new int[length];
    @Nullable
        return Version.fromId(readVInt());
import org.apache.lucene.index.IndexFormatTooNewException;
                return readText();
            return EMPTY_LONG_ARRAY;
    public Integer readOptionalInt() throws IOException {
 *
            case 5:
    public <E extends Enum<E>> EnumSet<E> readOptionalEnumSet(Class<E> enumClass) throws IOException {
                // We don't have enough space left in the byte array to read as much as we'd like to so we free up as many bytes in the
        }
                    return (T) readStackTrace(new StringIndexOutOfBoundsException(readOptionalString()), this);
    private Map readLinkedHashMap(int depth) throws IOException {
        if (readBoolean()) {
    @Nullable
                } else {
                return readSemverRange();
                    return (T) readStackTrace(new OpenSearchRejectedExecutionException(readOptionalString(), isExecutorShutdown), this);
        b = readByte();
                case 17:
                            exception = new FileSystemException(file, other, reason);
        return values;
            return readDouble();
        return arraySize;
     * @throws IOException if an I/O exception occurs while reading the array
    public void readFully(byte[] b) throws IOException {
    }
    private boolean readBoolean(final byte value) {
            } else if (largeSpare.chars.length < charCount) {
    }
        throw new UnsupportedOperationException("can't read named writeable from StreamInput");
                        break;
        }
        int missingFromPartial = 0;
            return i;
            return readVLong();
            }
    public BytesReference readBytesReference() throws IOException {
 * visually for differences. That means that most variables should be read and written in a single line so even large objects fit both
        }
        Map map10 = new HashMap(size10);
     * Reads an optional enum set with type E that was serialized based on the value of each enum's ordinal
        byte type = readByte();
 * <p>
    public static StreamInput wrap(byte[] bytes, int offset, int length) {
                case 14:
        return null;
        if (Arrays.equals(
        throw new UnsupportedOperationException("can't read named writeable from StreamInput");
        List list = new ArrayList(size);
     * Maximum depth for recursive deserialization of nested generic values.
        if (ordinal < 0 || ordinal >= values.length) {
                return readFloat();
        }
                Arrays.fill(bytes, (byte) 0);
                        throwOnBrokenChar(c);
        for (int i = 0; i < size9; i++) {
    }
    public <T extends NamedWriteable> List<T> readNamedWriteableList(Class<T> categoryClass) throws IOException {
}
 * You may obtain a copy of the License at
        }
    }
    }
            sortedMap = new TreeMap<>(keyComparator);
    public short readShort() throws IOException {
        return readBytesReference(length);
            case 19:
                    return (T) readStackTrace(exception, this);
        int count = readArraySize();
        }
     */
                    return (T) readStackTrace(new SecurityException(readOptionalString(), readException()), this);
        return new TimeValue(duration, timeUnit);
     *
                        if (missingFromPartial == 0) {
            map10.put(readString(), readGenericValue(depth + 1));
    // Larger buffer used for long strings that can't fit into the thread-local buffer
        if ((b & 0x80) == 0) {
import java.util.Collections;
        int sizeByteArray = 0;
    @Nullable
    private static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
            list8[i] = readGenericValue(depth + 1);
        this.version = version;
        return new BytesRef(bytes, 0, length);
                case 16:
        }
    }
        }
            builder.add(reader.read(this));
                    final int subclass = readVInt();
        return ((readByte() & 0xFF) << 24) | ((readByte() & 0xFF) << 16) | ((readByte() & 0xFF) << 8) | (readByte() & 0xFF);
        int length = readInt();
        final int charCount = readArraySize();
        return null;
     */
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor
        return null;
        return map10;
    }
                    case 12:
                largeSpare.chars = new char[ArrayUtil.oversize(charCount, Character.BYTES)];
     * Reads a set of objects. If the returned set contains any entries it will be mutable. If it is empty it might be immutable.
        TimeUnit timeUnit = TIME_UNITS[readByte()];
        return readOrderedMap(keyReader, valueReader, null);
                toRead = minRemainingBytes;
     * Read a serialized map into a SortedMap using the default ordering for the keys. If the result is empty it might be immutable.
import java.util.Set;
        if (readBoolean()) {
        i |= (b & 0x7F) << 14;
 * reading and writing on the screen. It also means that the methods on this class are named very similarly to {@link StreamOutput}. Finally
        if ((b & 0x80) == 0) {
                    return (T) readStackTrace(new NumberFormatException(readOptionalString()), this);
     * are encoded in ten bytes so prefer {@link #readLong()} or {@link #readZLong()} for negative numbers.
        if (size == 0) {
     * Prefer {@link StreamInput#readNamedWriteable(Class)} and {@link StreamOutput#writeNamedWriteable(NamedWriteable)} unless you
        return SemverRange.fromString(readString());
 * it means that the "barrier to entry" for adding new methods to this class is relatively low even though it is a shared class with code
        return readBytesReference(length);
     * Default implementation throws {@link UnsupportedOperationException} as StreamInput doesn't hold a registry.
                case 10:
    }
    // this prevents calling grow for every character since we don't need this
    }
                switch (c >> 4) {
    }
    private CharsRef largeSpare;
    public long readZLong() throws IOException {
        }
        final char[] charBuffer = charsRef.chars;
        }
            return readEnumSet(enumClass);
     * Reads a list of {@link NamedWriteable}s. If the returned list contains any entries it will be mutable.
 * on {@link StreamInput}.
        if ((b & 0x80) == 0) {
        System.getProperty("opensearch.stream.depth.max", "1000" /* aligned with StreamReadConstraints.DEFAULT_MAX_DEPTH */)
                            exception = new NoSuchFileException(file, other, reason);
                }
     */
                            break;
    /** Reads the {@link Version} from the input stream */
                        break;
     * bytes of the stream.
        long[] values = new long[length];
     * @param reader        the reader used to read individual elements
        if (length == 0) {
    public Float readOptionalFloat() throws IOException {
                        ++i;
        }
    private Version version = Version.CURRENT;
        if (readBoolean()) {
                            break;
    }
                    String resource1 = readOptionalString();
            case 12:
        }
        // lets do a sanity check that if we are reading an array size that is bigger that the remaining bytes we can safely
        for (int i = 0; i < size; i++) {
                    offsetByteArray = 0;
            return null;
            values[i] = readLong();
        for (int i = 0; i < length; i++) {
     * If the returned list contains any entries it will be mutable. If it is empty it might be immutable.
import java.util.Arrays;
                    case 14:
        readBytes(b, 0, b.length);
    @Nullable
            Arrays.fill(bytes, (byte) 0);
    @Nullable
    public double[] readDoubleArray() throws IOException {
 * A stream from this node to another node. Technically, it can also be streamed to a byte array but that is mostly for testing.
    }
    // Reusable bytes for deserializing strings
                    return (T) readStackTrace(new AlreadyClosedException(readOptionalString(), readException()), this);
import java.util.HashMap;
    public ZoneId readOptionalZoneId() throws IOException {
        return i;
    @Nullable
        if (readBoolean()) {
                    }
import java.nio.file.FileSystemLoopException;
            return i;
        return null;
                    String resource3 = readOptionalString();
                    case 14:
    public BigInteger readBigInteger() throws IOException {
        return builder;
    public Text readText() throws IOException {
        }
    }
                case 7:
                    } else {
    @Nullable
     * the corresponding entry in the registry by name, so that the proper object can be read and returned.
        if (length == 0) {
    public BytesRef readBytesRef(int length) throws IOException {
        i |= (b & 0x7FL) << 21;
                        }
        int size8 = readArraySize();
 * ownership. Elasticsearch licenses this file to you under
     * Read an optional {@linkplain ZoneId}.
        if ((b & 0x80) == 0) {
        byte[] bytes = new byte[length];
            values[i] = readInt();
            case 1:
        }
            // As long as we at least have three bytes buffered we don't need to do any bounds checking when getting the next char since we
    }
        if (count == 0) {
        } else {
     */
    public float[] readFloatArray() throws IOException {
            case 16:
    }
            return i;
    /**
     *
                        default:
@PublicApi(since = "1.0.0")
            if (largeSpare == null) {
            return Collections.emptyList();
    }
    }
                case 15:
import java.util.Collection;
                return readBigInteger();
import org.opensearch.core.xcontent.MediaType;
     * might be immutable.
            map9.put(readString(), readGenericValue(depth + 1));
        return values;
            int bufferFree = byteBuffer.length - sizeByteArray;
    public @Nullable TimeValue readOptionalTimeValue() throws IOException {
        int i = b & 0x7F;
     * Reads an int stored in variable-length format.  Reads between one and
     * If the map or a list in it contains any elements it will be mutable, otherwise either the empty map or empty lists it contains
    /**
     * the corresponding entry in the registry by name, so that the proper object can be read and returned.
                return readIntArray();
 * compatible open source license.
            return EMPTY_LONG_ARRAY;
            return true;
        }
                return readString();
        return ZoneId.of(readString());
        if (length == 0) {
        Writeable.Reader<K> keyReader,
                case 4:
        }
        if (readBoolean()) {
            }
            values[i] = readVLong();
        if (size == 0) {
     * Protects against StackOverflowError from deeply nested binary payloads.
import java.nio.file.NoSuchFileException;
     * {@code null} otherwise.
        for (int i = 0; i < size10; i++) {
            return i;
     */
    /**
                return readByteArray();
        int ordinal = readVInt();
     * Read an optional {@link TimeValue} from the stream, returning null if no TimeValue was written.
     * Reads a boolean.
        if ((b & 0x80) == 0) {
                            break;
                    toRead = bufferFree;
    public <K extends Comparable<K>, V> SortedMap<K, V> readOrderedMap(Writeable.Reader<K> keyReader, Writeable.Reader<V> valueReader)
                            break;
                missingFromPartial = 0;
                            byteBuffer[0] = byteBuffer[offsetByteArray];
        return readBoolean() ? readArray(reader, arraySupplier) : null;
    public Object readGenericValue() throws IOException {
        int length = readArraySize();
                TimeUnit.MINUTES,
        // assert the exact form of the TimeUnit values to ensure we're not silently broken by a JDK change
    public <K, V> Map<K, V> readMap(Writeable.Reader<K> keyReader, Writeable.Reader<V> valueReader) throws IOException {
                    case 1:
            return readTimeValue();
                        break;
            throw new IOException("Unknown " + enumClass.getSimpleName() + " ordinal [" + ordinal + "]");
        for (int i = 0; i < count; i++) {
            return readString();
            values[i] = readFloat();
                return readDouble();
                    final Exception exception;
                return readCollection(si -> si.readGenericValue(depth + 1), LinkedHashSet::new, Collections.emptySet());
     * If it is empty it might be immutable.
        }
     * from the stream. This method can be seen as the reader version of {@link StreamOutput#writeArray(Writeable.Writer, Object[])}. It is
                    case 6:
    @Nullable
 *
        return present ? readInstant() : null;
                    "Writeable.Reader [" + reader + "] returned null which is not allowed and probably means it screwed up the stream."
                        missingFromPartial = 3 - (bufferedBytesRemaining - i);
                case 11:
     * @param offset the offset in the array to start storing bytes
        @Nullable Comparator<K> keyComparator
     * This method throws an {@link EOFException} if the given number of bytes can not be read from the this stream. This method might
        SortedMap<K, V> sortedMap;
        return readEnum(enumClass, enumClass.getEnumConstants());
        throws IOException {
            return i;
        }
            }
        return null;
 * lists, either by storing {@code List}s internally or just converting to and from a {@code List} when calling. This comment is repeated
        // throw an exception instead of allocating the array based on the size. A simple corrutpted byte can make a node go OOM
        final String distribution = readString();
    @SuppressWarnings({ "rawtypes", "unchecked" })
        return null;
            case 18:
                    switch (subclass) {
            return readFloat();
    }
     * @throws IOException if an I/O exception occurs reading the set
package org.opensearch.core.common.io.stream;
            default:
                    int minVersion2 = readInt();
     * Use {@link FilterInputStream} instead which wraps a stream and supports a {@link NamedWriteableRegistry} too.
    public <C extends NamedWriteable> C readNamedWriteable(
        }
            case 25:
    }
            return readLong();
    public long readVLong() throws IOException {
            switch (key) {
import org.opensearch.Build;
            return new SecureString(CharArrays.utf8BytesToChars(bytes));
 * under the License.
            } else {
    }
            case 14:
    private static final TimeUnit[] TIME_UNITS = TimeUnit.values();
        int length = readArraySize();
    /**
    public Version readVersion() throws IOException {
            } else {
        int i = 0;
            for (int i = 0; i < bufferedBytesRemaining; i++) {
                // buffer by moving unused bytes that didn't make up a full char in the last iteration to the beginning of the buffer,
    }
import org.apache.lucene.index.CorruptIndexException;
    }
     */
    }
        final EnumSet<E> res = EnumSet.noneOf(enumClass);
        }
            return readInt();
    @Nullable
            if (bufferFree < minRemainingBytes) {
                case 13:
        b = readByte();
     */
        }
 * the Apache License, Version 2.0 (the "License"); you may
     * @throws IOException if an I/O exception occurs reading the list
            }
import java.nio.file.DirectoryNotEmptyException;
    public Integer readOptionalVInt() throws IOException {
    /**
        int length = readArraySize();
                    return (T) OpenSearchException.readException(this, ord);
    /**
    /**
        int size = readArraySize();
        final byte[] byteBuffer = stringReadBuffer.get();
            return ZoneId.of(readString());
 * @opensearch.api
        final byte value = readByte();
                        int version3 = readInt();
            return BytesArray.EMPTY;
/*
        throws IOException {
        int size = readArraySize();
        i |= (b & 0x7FL) << 35;
    }
    }
                            exception = new DirectoryNotEmptyException(file);
                    return (T) readStackTrace(new CorruptIndexException(msg1, resource1, readException()), this);
    /**
            if (t == null) {
            return Collections.emptyMap();
        for (int i = 0; i < count; i++) {
            return Strings.EMPTY_ARRAY;
    }
    private static final int[] EMPTY_INT_ARRAY = new int[0];
        return map;
    public abstract int available() throws IOException;
     * using {@link #readInt}
     */
                return readZonedDateTime();
    public SecureString readSecureString() throws IOException {
            values[i] = reader.read(this);
    public BytesReference readOptionalBytesReference() throws IOException {
                            exception = new FileAlreadyExistsException(file, other, reason);
    }
                        return (T) readStackTrace(new IndexFormatTooOldException(resource3, version3), this);
        return new Date(readLong());
    /**
    ) throws IOException {
        if ((b & 0x80) == 0) {
            return i;
     *
        }
     * Read an {@link Instant} from the stream with nanosecond resolution
     * @return the list of objects
            return null;
     * Reads a specified number of bytes into an array at the specified offset.
     * Default implementation throws {@link UnsupportedOperationException} as StreamInput doesn't hold a registry.
        Writeable.Reader<V> valueReader,
     */
                        case 0:
 * Modifications Copyright OpenSearch Contributors. See
            charsRef = largeSpare;
    }
        b = readByte();
        boolean snapshot = readBoolean();
    public <T> Set<T> readSet(Writeable.Reader<T> reader) throws IOException {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            case 21:
    public TimeValue readTimeValue() throws IOException {
        for (; charsOffset < charCount;) {
    /**
        }
        return null;
        return values;
        return null;
     */
     * @return the list of strings
            return i;
import java.util.Comparator;
        if (depth > MAX_DESERIALIZATION_DEPTH) {
        if (size9 == 0) {
import java.nio.file.FileAlreadyExistsException;
 * software distributed under the License is distributed on an
     *
    }
        Object[] list8 = new Object[size8];
    public Version getVersion() {
                        case 4:
        if (readBoolean()) {
        }
                );
    }
     */
                        break;
     * Reads a long stored in variable-length format. Reads between one and ten bytes. Smaller values take fewer bytes. Negative numbers
                return readHashMap(depth);
        if ((b & 0x80) == 0) {
     * Get the registry of named writeables if this stream has one,
        final int length = readArraySize();
    /**
    private Object[] readArray(int depth) throws IOException {
            return i;
                    case 13:
        i |= ((b & 0x7FL) << 56);
        }
        }
    }
        if (count == 0) {
            return readList(StreamInput::readString);
        }
    private <E extends Enum<E>> E readEnum(Class<E> enumClass, E[] values) throws IOException {
            case 13:
    }
        charsRef.length = charCount;
    }
    private static final ThreadLocal<CharsRef> smallSpare = ThreadLocal.withInitial(() -> new CharsRef(SMALL_STRING_LIMIT));
                TimeUnit.SECONDS,
        }
     * Read an optional {@link Instant} from the stream. Returns <code>null</code> when
    public SemverRange readSemverRange() throws IOException {
import org.opensearch.core.common.Strings;
        if (b != 0 && b != 1) {
     * Set the version of the node on the other side of this stream.
        i |= (b & 0x7FL) << 7;
    }
    /**
        }
            case 20:
                    case 2:
            try {
        return list8;
        return (((long) readInt()) << 32) | (readInt() & 0xFFFFFFFFL);
        return (Map<String, Object>) readGenericValue();
    }
                case 6:
            throw new IllegalStateException("array length must be <= to " + ArrayUtil.MAX_ARRAY_LENGTH + " but was: " + arraySize);
                value = new SecureString(CharArrays.utf8BytesToChars(bytes));
     */
        if (readBoolean()) {
     */
import java.util.Locale;
        return wrap(bytes, 0, bytes.length);
     * @param valueReader The value reader
        final boolean present = readBoolean();
                    case 7:
        if (size == 0) {
                    case 3:
            return EMPTY_DOUBLE_ARRAY;
                            break;
            ret[i] = readString();
        }
    }
     * assumed that the stream first contains a variable-length integer representing the size of the array, and then contains that many
        b = readByte();
                throw new IOException("Can't read unknown type [" + type + "]");
                    case 7:
            }
    }
            }
    public List<String> readOptionalStringList() throws IOException {
import java.util.concurrent.TimeUnit;
    /**
        if ((b & 0x80) == 0) {
     */
        }
        if (keyComparator == null) {
        }
    }
                            exception = new NotDirectoryException(file);
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
 * specific language governing permissions and limitations
import java.io.ByteArrayInputStream;
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    }
    public final float readFloat() throws IOException {
     */
                    throw new IOException("no such exception for id: " + key);
        return new BytesArray(bytes, 0, length);
 */
                minRemainingBytes = missingFromPartial + charsLeft - 1;
                case 12:
        int size = readVInt();
                            charBuffer[charsOffset++] = (char) ((c & 0x1F) << 6 | byteBuffer[offsetByteArray++] & 0x3F);
import java.util.Date;
                case 0:
     * Reads a {@link NamedWriteable} from the current stream with the given name. It is assumed that the caller obtained the name
     */
     * Map&lt;String, List&lt;String&gt;&gt; map = in.readMapOfLists(StreamInput::readString, StreamInput::readString);
        if (size == 0) {
    /**
            final int minRemainingBytes;
                case 1:
        }
        }
                    return (T) readStackTrace(new ArrayIndexOutOfBoundsException(readOptionalString()), this);
                    String resource2 = readOptionalString();
import org.apache.lucene.store.AlreadyClosedException;
        b = readByte();
    }
            return readBoolean(value);
    public static StreamInput wrap(byte[] bytes) {
import java.nio.file.NotDirectoryException;
/*
    /**
        while (((currentByte = readByte()) & 0x80L) != 0) {
        int size = readArraySize();
        if (size10 == 0) {
        long[] values = new long[length];
            charsRef = smallSpare.get();
                    final String file = readOptionalString();
                    return (T) readStackTrace(new IllegalStateException(readOptionalString(), readException()), this);
        int length = readArraySize();
        for (int i = 0; i < size; i++) {
                    default:
        if (arraySize > ArrayUtil.MAX_ARRAY_LENGTH) {
        Map map9 = new LinkedHashMap(size9);
import java.nio.file.FileSystemException;
    @Nullable
        }
        byte b = readByte();
        }
     * Reads a value of unspecified type. If a collection is read then the collection will be mutable if it contains any entry but might
        return builder;
    }
        readBytes(bytes, 0, bytes.length);
     * Reads and returns a single byte.
     * Read a {@linkplain ZoneId}.
                    switch (sizeByteArray) { // We only have 0, 1 or 2 => no need to bother with a native call to System#arrayCopy
        }
    public abstract void readBytes(byte[] b, int offset, int len) throws IOException;
import java.io.InputStream;
    private static final int SMALL_STRING_LIMIT = 1024;
    public <T> List<T> readList(final Writeable.Reader<T> reader) throws IOException {
        return readGenericValue(0);
    }
    public <C extends NamedWriteable> C readOptionalNamedWriteable(Class<C> categoryClass) throws IOException {
            return i;
     */
            return null;
        switch (type) {
 */
                            break;
    /**
                    return (T) readStackTrace(new EOFException(readOptionalString()), this);
import java.io.FileNotFoundException;
        return new Text(readBytesReference(length));
        if ((b & 0x80) == 0) {
    public String readOptionalString() throws IOException {
            case 24:
    @SuppressWarnings({ "rawtypes", "unchecked" })
        }
    /**
        }
    }
                        charBuffer[charsOffset++] = (char) ((c & 0x1F) << 6 | byteBuffer[++offsetByteArray] & 0x3F);
        b = readByte();
    protected abstract void ensureCanReadBytes(int length) throws EOFException;
     * <pre><code>
                    case 0:
        }
        }
                case 9:
    @Nullable
     * be immutable if it is empty.
    /**
     * five bytes.  Smaller values take fewer bytes.  Negative numbers
    private Object readGenericValue(int depth) throws IOException {
        if (size == 0) {
        int[] values = new int[length];
        if (length == 0) {
     */
     * If the returned map contains any entries it will be mutable. If it is empty it might be immutable.
        String date = readString();
        // the following is new for opensearch: we write the distribution to support any "forks"
            return i;
     * no instant is present.
            map.put(key, value);
    /**
                        case 1:
    @Nullable
import org.opensearch.common.Nullable;
        }
        } else {
    }
    public final Instant readOptionalInstant() throws IOException {
        return values;
     */
        for (int i = 0; i < size8; i++) {
            return EMPTY_FLOAT_ARRAY;
    /**
        @SuppressWarnings("unused") Class<C> categoryClass,
        }
            case 27:
        }
        }
    /**
                    int maxVersion2 = readInt();
            case 23:
        return null;
        if (size == 0) {
                    return (T) readStackTrace(new IndexFormatTooNewException(resource2, version2, minVersion2, maxVersion2), this);
     */
        readIntoMap(keyReader, valueReader, sortedMap, size);
     * Deliberately on its own property (not {@code opensearch.xcontent.depth.max}) so that relaxing
import java.io.EOFException;
                // One byte for each remaining char except for the already partially read char
            return t;
        if (readBoolean()) {
        i |= (b & 0x7F) << 7;
            return r.read(this);
                case 2:
import java.util.Map;
     * Reads a collection of objects
        return new BigInteger(readString());
import org.opensearch.OpenSearchException;
                    case 6:
        }
            readBytes(byteBuffer, sizeByteArray, toRead);
        for (int i = 0; i < size; i++) {
    public Map<String, Object> readMap() throws IOException {
                            exception = new AccessDeniedException(file, other, reason);
        }
        if (size8 == 0) {
    }
            return i;
    // Thread-local buffer for smaller strings
    // Maximum char-count to de-serialize via the thread-local CharsRef buffer
        }
        }
                            break;
        if (length == 0) {
     *
import org.opensearch.common.annotation.PublicApi;
    }
                TimeUnit.MICROSECONDS,
            case -1:
        return BitUtil.zigZagDecode(accumulator | (currentByte << i));
    }
        }
        throws IOException {
                    case 4:
    }
    public final Double readOptionalDouble() throws IOException {
    public SecureString readOptionalSecureString() throws IOException {
                TimeUnit.MILLISECONDS,
    public String[] readOptionalStringArray() throws IOException {
            case 8:
                            offsetByteArray++;
        for (int i = 0; i < length; i++) {
        if (readBoolean()) {
public abstract class StreamInput extends InputStream {
                    case 13:
        } finally {
    }
     * The set is expected to have been written using {@link StreamOutput#writeOptionalEnumSet(EnumSet)}
            return i;
import org.opensearch.common.unit.TimeValue;
        return values[ordinal];
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        return Double.longBitsToDouble(readLong());
    }
    /**
    /**
    public <T> T[] readOptionalArray(Writeable.Reader<T> reader, IntFunction<T[]> arraySupplier) throws IOException {
import java.util.function.IntFunction;
            sortedMap = new TreeMap<>();
     * Reads an optional list of strings. The list is expected to have been written using
        // if the size is large and for perf reasons we allocate arrays ahead of time
        return values;
        try {
            final int charsLeft = charCount - charsOffset;
        return readCollection(reader, HashSet::new, Collections.emptySet());
     */
        }
            throw new IOException("Invalid vInt ((" + Integer.toHexString(b) + " & 0x7f) << 28) | " + Integer.toHexString(i));
        return ret;
        }
                return readArrayList(depth);
        i |= (b & 0x7FL) << 28;
        // be lenient when reading on the wire, the enumeration values from other versions might be different than what we know
            throw new IOException("Invalid vlong (" + Integer.toHexString(b) + " << 63) | " + Long.toHexString(i));
        if (r != null) {
import java.io.FilterInputStream;
            sizeByteArray += toRead;
        long duration = readZLong();
        for (int i = 0; i < length; i++) {
     * Reads a {@link NamedWriteable} from the current stream, by first reading its name and then looking for
                        int maxVersion3 = readInt();
    /**
        }
            throw new AssertionError("Incompatible JDK version used that breaks assumptions on the structure of the TimeUnit enum");
        return values;
            for (; offsetByteArray < sizeByteArray - 2; offsetByteArray++) {
    private <T, C extends Collection<? super T>> C readCollection(Writeable.Reader<T> reader, IntFunction<C> constructor, C empty)
                final int c = byteBuffer[offsetByteArray] & 0xff;
     * @param keyReader The key reader
    private int readArraySize() throws IOException {
import java.time.ZoneId;
        final int length = readArraySize();
                            exception = new FileSystemLoopException(file);
            // try to extract chars from remaining bytes with bounds checks for multi-byte chars
        } else {
        @SuppressWarnings("unused") String name
        if (bytesRef != null) {
        }
        }
                        return (T) readStackTrace(new IndexFormatTooOldException(resource3, version3, minVersion3, maxVersion3), this);
     */
        i |= (b & 0x7FL) << 49;
                    case 1:
                return readByte();
     * Reads an enum with type E that was serialized based on the value of its ordinal
                    return (T) readStackTrace(new NullPointerException(readOptionalString()), this);
            case 26:
    }
        return readBoolean(readByte());
     */
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.nio.file.AtomicMoveNotSupportedException;
     * Reads eight bytes and returns a long.
                TimeUnit.DAYS }
     */
        long currentByte;
