        return this;
            humanReadableTransformer.putAll(addlTransformers);
    // ------------------------------
        }
     */
    }
        generatorInstance().writeBoolean(value);
        }  
        writers.put(BigDecimal.class, (b, v) -> b.value((BigDecimal) v));  
    public XContentBuilder value(Float value) throws IOException {
        return this;  
        return value(value.toString());
     * @param os       the output stream
     * format easier to read for a human.
            }  
        if (value == null) {
    /**  
/*  
        if (it != null) {  
        HumanReadableTransformer transformer = HUMAN_READABLE_TRANSFORMERS.get(value.getClass());
    // ------------------------------  
 * the Apache License, Version 2.0 (the "License"); you may
                throw new IllegalArgumentException("cannot write time value xcontent for unknown value of type Long");
        writers.put(BigInteger.class, (b, v) -> b.value((BigInteger) v));
     * the generator instantiation till the first usage.
    }
    }
     * XContent instance  
    // Raw fields  
            // Path implements Iterable<Path> and causes endless recursion and a StackOverFlow if treated as an Iterable here  
    /**  
        try {
     * Trying to write more contents after toString() will cause NPE. Use it with caution.  
     * Create a new {@link XContentBuilder} using the given {@link XContent} content.  
        }
    }
    // ------------------------------
    public XContentBuilder field(String name, boolean value) throws IOException {
                // pass ensureNoSelfReferences=false as we already performed the check at a higher level
    public XContentBuilder value(Long value) throws IOException {
    public XContentBuilder field(String name, byte[] value, int offset, int length) throws IOException {  
        } else if (value instanceof Object[] objectArray) {
    @Deprecated
    public XContentBuilder array(String name, int[] values) throws IOException {
    /**
        if (value == null) {
    private XContentBuilder values(short[] values) throws IOException {  
            value(toXContent);
    // Integer  
        if (writeStartAndEndHeaders) {  
    }  
        }
    }  
     */
        boolean prettyPrint
        endArray();
    /**  
        return field(name).value(value);
            value(b);
    public XContentBuilder field(String name, Long value) throws IOException {  
    /**
    public XContentBuilder array(String name, long[] values) throws IOException {
import java.util.GregorianCalendar;
    }
        }  
        return (value == null) ? nullValue() : value(value.byteValue());  
        generatorInstance().writeEndObject();  
     * @return the value of the "human readable" flag. When the value is equal to true,  
     * The writer interface for the serializable content builder
    public XContentBuilder field(String name, Iterable<?> values) throws IOException {
        assert rawFieldName.equals(readableFieldName) == false : "expected raw and readable field names to differ, but they were both: "  
            dateTransformers.putAll(addlDateTransformers);  
    /**
    // on typed methods and use Object.toString() as a last resort. Always prefer using  
     * Writes a raw field with the value taken from the bytes in the stream
    // ------------------------------------------------------------------------  
        }
    @Override
            Map<Class<?>, HumanReadableTransformer> addlTransformers = service.getXContentHumanReadableTransformers();
    public XContentBuilder field(String name, ToXContent value, ToXContent.Params params) throws IOException {
    }
        return this;  
    /**  
    public XContentBuilder field(String name, Map<String, Object> values) throws IOException {  
    // ------------------------------
        if (value == null) {  
     * @opensearch.internal
    }  
            // checks that the iterable does not contain references to itself because  
    }  
        startArray();  
            return nullValue();
        }
    }
     */
     * @throws IllegalArgumentException if there is no transformers for the type of object
        startArray();  
    }
            return nullValue();  
        }  
        return this;
    }
    public XContentBuilder value(BigDecimal value) throws IOException {  
     * some filters. If filters are specified, only those values matching a
     * @param excludes the exclusive filters: only fields and objects that don't match the exclusive filters will be written to the output.
    // ------------------------------
    }
        writers.put(String.class, (b, v) -> b.value((String) v));
        return (value == null) ? nullValue() : value(value.shortValue());
    public XContentBuilder value(double value) throws IOException {  
        }  
    public void close() {
        return field(name).timeValue(timeValue);  
     * Write a time-based field and value, if the passed timeValue is null a  
        } else if (value instanceof Iterable<?> iterable) {  
        }
import java.util.Calendar;
        }
            return nullValue();  
     * Indicate that the current {@link XContentBuilder} must write a line feed ("\n")  
        } else {  
            );
        return field(name).values(values, true);  
        } else if (value instanceof Object[] objectArray) {
        writers.put(double[].class, (b, v) -> b.values((double[]) v));
        return (value == null) ? nullField(name) : field(name, value.longValue());
        return map(values, true, false);
 * GitHub history for details.
            // pass ensureNoSelfReferences=false as we already performed the check at a higher level
 *  
        }
import java.time.ZonedDateTime;
        if (values == null) {
            map(valueMap, ensureNoSelfReferences, true);
    private static Iterable<?> convert(Object value) {
        Writer writer = WRITERS.get(value.getClass());
        return BytesReference.bytes(this).utf8ToString();
    }  
        return this;
    /**
    }  
     * This only applies for JSON XContent type. It has no effect for other types.  
    // ------------------------------------------------------------------------
    public XContentBuilder value(Short value) throws IOException {  
    public XContentBuilder lfAtEnd() {
        // checks that the map does not contain references to itself because  
    }
        }
        }  
     * @param os       the output stream
    }
    public XContentBuilder humanReadableField(String rawFieldName, String readableFieldName, Object value) throws IOException {
    public XContentBuilder value(byte[] value) throws IOException {
     * @return a new {@link XContentBuilder}  
            return nullValue();
     */
import java.math.BigInteger;  
            endObject();  
        Iterable<?> it = convert(value);
        return this;  
            return this;
        return (value == null) ? nullField(name) : field(name, value.shortValue());
    }
        } else {  
    }  
import java.util.IdentityHashMap;  
     * (like changing pretty printer, etc). To workaround and preserve the APIs, we do defer  
     * at the end of the built object.
 */  
        return this;
     * Since 3.x release line, Jackson does not allow on the fly changes to the generator
        ensureNameNotNull(name);
        if (generator == null) {
    // ------------------------------
     */  
        try {
     * <p>
    }  
     * inclusive filters are provided, the underlying builder will first use exclusion filters to remove fields and then will check the
            addlTransformers.forEach(  
    @Override
import java.io.Closeable;
    private static final Map<Class<?>, Writer> WRITERS;  
    public XContentBuilder percentageField(String rawFieldName, String readableFieldName, double percentage) throws IOException {
        ensureNameNotNull(name);
    /**
            return nullValue();  
        } else {
        for (BigDecimal b : values) {
        }
    // ------------------------------------------------------------------------
     * null value is written, otherwise a date transformers lookup is performed.
    }
     * Create a new {@link XContentBuilder} using the given {@link XContent} content and some inclusive and/or exclusive filters.
        this.bos = os;
     * Creates a new builder using the provided XContent, output stream and some inclusive and/or exclusive filters. When both exclusive and
    public XContentBuilder value(Byte value) throws IOException {
    private XContentBuilder values(double[] values) throws IOException {
        if (timeValue == null) {
     * Constructs a new builder using the provided XContent, an OutputStream and  
    }  
    /**
     */  
    // Long  
        return field(name).startArray();
        WRITERS = Collections.unmodifiableMap(writers);  
            for (Object value : values) {  
    // ------------------------------------------------------------------------
        if (values instanceof Path path) {
        if (value instanceof Map<?, ?> map) {  
 * license agreements. See the NOTICE file distributed with
    public XContentBuilder rawValue(InputStream stream, MediaType contentType) throws IOException {  
        } else if (value instanceof ToXContent toXContent) {
    }
            return nullField(name);
            return nullValue();
package org.opensearch.core.xcontent;
        return this;
        // treat strings as already converted
        for (BigInteger b : values) {
    public XContentBuilder value(short value) throws IOException {
     * @param includes the inclusive filters: only fields and objects that match the inclusive filters will be written to the output.
            return nullValue();
    // ------------------------------------------------------------------------  
        return (value == null) ? nullField(name) : field(name, value.doubleValue());
        return this;
     */
    }
        if (value != null) {  
        return this;
        // Load pluggable extensions
            unknownValue(value.getValue(), false);  
import org.opensearch.common.annotation.PublicApi;
    public String toString() {  
     * unformatted version of the time value using the date transformer for the
     * Write a time-based value, if the value is null a null value is written,
        }  
     */
import java.util.Arrays;  
    private static final Map<Class<?>, Function<Object, Object>> DATE_TRANSFORMERS;
            );
        }
    }
    public XContentBuilder rawField(String name, InputStream value, MediaType mediaType) throws IOException {
        generatorInstance().writeNumberField(name, value);  
            generatorInstance().close();  
     * @throws IOException if an {@link IOException} occurs while building the content  
    public XContentBuilder latlon(double lat, double lon) throws IOException {
        writers.put(byte[].class, (b, v) -> b.value((byte[]) v));
        return new XContentBuilder(xContent, new ByteArrayOutputStream(), includes, excludes);  
    }  
    private XContentBuilder values(BigInteger[] values) throws IOException {
    public XContentBuilder copyCurrentStructure(XContentParser parser) throws IOException {
        generatorInstance().writeNumber(value);
    }
        return (value == null) ? nullValue() : value(value.intValue());  
    // ------------------------------
    }
import java.util.Collections;
        return this.humanReadable;
    public static XContentBuilder builder(XContent xContent, Set<String> includes, Set<String> excludes) throws IOException {
        }  
    }  
            return nullValue();
        } catch (IOException e) {
        if (values == null) {
    static {  
        this(xContent, bos, includes, Collections.emptySet());  
        if (values == null) {
    // used if the humanReadable flag has been set
    }
        return field(name).values(values);
            ensureNoSelfReferences(it, value, Collections.newSetFromMap(new IdentityHashMap<>()));
        return (value == null) ? nullField(name) : field(name, value.floatValue());
    public XContentBuilder rawField(String name, InputStream value) throws IOException {
        ensureNameNotNull(name);
        try {  
    private XContentBuilder values(String[] values) throws IOException {
        }
            }  
    }
            throw new UncheckedIOException(ex);
        return this;
import java.io.OutputStream;  
        return this;  
            writer.write(this, value);
        if (value == null) {
        for (String s : values) {  
     * to call {@link #close()} when the builder is done with.
    }  
    }  
    }  
     */  
    // ------------------------------------------------------------------------
     * The inclusive filters: only fields and objects that match the inclusive filters will be written to the output.
        this(xContent, bos, Collections.emptySet(), Collections.emptySet());
    }  
        return field(name).value(value);
    public XContentBuilder array(String name, short[] values) throws IOException {
        return field(name).latlon(lat, lon);
     */
    private static void ensureNoSelfReferences(final Iterable<?> value, Object originalReference, final Set<Object> ancestors) {
            value(Objects.toString(value));
    public XContentBuilder field(String name, BigInteger value) throws IOException {
    // ------------------------------
    public static XContentBuilder builder(XContent xContent) throws IOException {  
        generatorInstance().writeStringField(name, value);
    }
    public XContentBuilder utf8Value(byte[] bytes, int offset, int length) throws IOException {
    }
        if (values == null) {  
    // Byte  
    }
    public XContentBuilder field(String name, Short value) throws IOException {  
 */
     * </p>  
    }
            return nullValue();  
    }
            return map.values();
    public XContentBuilder value(float value) throws IOException {  
    public XContentBuilder value(byte value) throws IOException {  
    }
    }  
    public XContentBuilder field(String name, long value) throws IOException {
            return nullValue();
 * KIND, either express or implied.  See the License for the
    public XContentBuilder field(String name, Object value) throws IOException {
     * Use pretty print ("false" by default)
    private XContentBuilder values(long[] values) throws IOException {
        startArray();
    private static final Map<Class<?>, HumanReadableTransformer> HUMAN_READABLE_TRANSFORMERS;
        }  
    // LatLon
        return this;
    }  
        for (double b : values) {
        Object rawValue(Object value) throws IOException;
        writers.put(Float.class, (b, v) -> b.value((Float) v));
     *
    public XContentBuilder field(String name, BigDecimal value) throws IOException {
     * Set the "human readable" flag. Once set, some types of values are written in a  
        return field(name).map(values);
    }
        generatorInstance().writeNumber(value);
            throw new UncheckedIOException(ex);
        generatorInstance().writeString(value);
        return this;  
import java.io.IOException;
            Map<Class<?>, Function<Object, Object>> addlDateTransformers = service.getDateTransformers();  
        return this;  
            return;  
    // ------------------------------------------------------------------------  
    // ------------------------------
    }
    public XContentBuilder value(Boolean value) throws IOException {
        try {
    // ------------------------------
    private static void ensureNoSelfReferences(Object value) {
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return (value == null) ? nullValue() : value(value.doubleValue());  
        if (values == null) {  
        if (values == null) {
    public static void ensureNameNotNull(String name) {  
        generatorInstance().writeNumber(value);  
        }
import java.io.UncheckedIOException;
    // ------------------------------
    public OutputStream getOutputStream() {  
                ensureNoSelfReferences(convert(o), o, ancestors);
        writers.put(Class.class, (b, v) -> b.value(v.toString()));
    /**
 *
     */
     * Make sure to call {@link #close()} when the builder is done with.
        this.xContent = xContent;  
 */  
public final class XContentBuilder implements Closeable, Flushable {  
    public XContentBuilder field(String name, Integer value) throws IOException {  
        if (value == null) {
     * The exclusive filters: only fields and objects that don't match the exclusive filters will be written to the output.
        if (transformer != null) {  
            value(l);
        for (boolean b : values) {
    public XContentBuilder startArray() throws IOException {
    public XContentBuilder field(String name, String value) throws IOException {  
            field(value.getKey());
            return nullValue();
            final Map<String, ?> valueMap = (Map<String, ?>) value;
        startArray();  
        if (humanReadable) {
            field(readableName).value(longTransformer.apply(value));  
        writers.put(ZonedDateTime.class, (b, v) -> b.value(v.toString()));
        } else {  
@PublicApi(since = "1.0.0")
            return null;
        this.prettyPrint = true;  
    public XContentBuilder field(String name, ToXContent value) throws IOException {  
        if (value == null) {
        value.toXContent(this, params);
    }
    // ------------------------------
        generatorInstance().writeFieldName(name);
        }
        if (value == null) {
        generatorInstance().writeBinary(value, offset, length);
    }  
        return this;
    }
            value(f);
    public XContentBuilder field(String name, double value) throws IOException {
    // ------------------------------
        return (value == null) ? nullField(name) : field(name, value.intValue());
            return nullValue();  
        if (values == null) {  
        return map(values, true, true);
    }
        writers.put(Short.class, (b, v) -> b.value((Short) v));
    }
    public XContentBuilder latlon(String name, double lat, double lon) throws IOException {
     *  
     * Creates a new builder using the provided XContent, output stream and some inclusive and/or exclusive filters. When both exclusive and
        }  
    public static void ensureNotNull(Object value, String message) {
    public XContentBuilder field(String name, byte value) throws IOException {
     * Interface for transforming complex objects into their "raw" equivalents for human-readable fields  
import java.util.Map;
    // Boolean  
    }  
        } else if (value instanceof Path path) {
    }  
            return nullValue();  
        generatorInstance().writeRawField(name, value, mediaType);
    }
     * The builder uses an internal {@link ByteArrayOutputStream} output stream to build the content.
        return value(Arrays.asList(values), ensureNoSelfReferences);
    }  
     * Writes a value with the source coming directly from the bytes in the stream
    /**
    // These are fields that have a "raw" value and a "human readable" value,  
     */
        this.excludes = excludes;  
    // ------------------------------------------------------------------------
        return this;
            // iterating over entries will cause a stackoverflow error
        Map<Class<?>, HumanReadableTransformer> humanReadableTransformer = new HashMap<>();
    public XContentBuilder value(int value) throws IOException {  
    }
    public XContentBuilder timeField(String name, Object timeValue) throws IOException {
            return iterable;  
    private XContentBuilder value(Iterable<?> values, boolean ensureNoSelfReferences) throws IOException {  
    public XContentBuilder timeValue(Object timeValue) throws IOException {  
        return field(name).value(value, params);
     * remaining fields against the inclusive filters.  
            return nullField(name);
        if (value == null) {
    // ------------------------------
            return nullValue();
        }
     * The builder uses an internal {@link ByteArrayOutputStream} output stream to build the content. When both exclusive and
        ensureNameNotNull(name);
        return this;
        }
        return this;
    }
    public XContentBuilder mapContents(Map<String, ?> values) throws IOException {  
        Map<Class<?>, Writer> writers = new HashMap<>();
        return this;  
        Map<Class<?>, Function<Object, Object>> dateTransformers = new HashMap<>();  
        return startObject().field("lat", lat).field("lon", lon).endObject();  
            return nullValue();
        if (writer != null) {  
        return field(name).startObject();
        writers.put(GregorianCalendar.class, XContentBuilder::timeValue);
        return this;
        ensureNameNotNull(name);
        generatorInstance().writeUTF8String(bytes, offset, length);  
        }
    }
        return this;  
        generatorInstance().writeNumber(value);
    // ------------------------------------------------------------------------
    /**
            }
        startArray();  
        } else if (value instanceof Map<?, ?>) {
        dateTransformers.put(String.class, Function.identity());  
        return field(name).values(values);
        ensureNameNotNull(name);
            return null;
     * @throws IllegalArgumentException if there is no transformers for the type of object  
            throw new IllegalArgumentException("no raw transformer found for class " + value.getClass());
     * <p>
 * not use this file except in compliance with the License.
    // Structure (object, array, field, null values...)
            writers.putAll(addlWriters);
    private XContentGenerator generatorInstance() throws IOException {  
            value(s);  
    public interface Writer {
        return this;  
     */
    }  
 */
    }
    public boolean isPrettyPrint() {
     * @param includes the inclusive filters: only fields and objects that match the inclusive filters will be written to the output.
        }
        generatorInstance().writeNullField(name);
        return field(name).values(values);
    }  
    public XContentBuilder value(BigInteger value) throws IOException {
    // String  
    }
            return generatorInstance();
        if (value == null) {  
     * Constructs a new builder using the provided XContent and an OutputStream. Make sure
    // ------------------------------
        field(rawFieldName, percentage);
     * Writes the binary content of the given byte array as UTF-8 bytes.
            + rawFieldName;  
            if (longTransformer == null) {  
            return nullValue();
        return (value == null) ? nullField(name) : field(name, value.byteValue());
     */  
        return bos;
        // iterating over map entries will cause a stackoverflow error
    public XContentBuilder humanReadable(boolean humanReadable) {  
        return this;
     * <p>
        }
        return this;
        return this;
    // Date
            value(s);
        writers.put(Integer.class, (b, v) -> b.value((Integer) v));
        return this;
 * under the License.  
        return this;  
        endArray();
    @FunctionalInterface  
            if (transformer == null) {
            field(readableFieldName, String.format(Locale.ROOT, "%1.1f%%", percentage));
    }
    }
        }
    /**  
        writers.put(int[].class, (b, v) -> b.values((int[]) v));
    }
        OutputStream os,  
     * @param prettyPrint use pretty printer
        generatorInstance().writeNumberField(name, value);  
        endArray();  
     * If the {@code humanReadable} flag is set, writes both a formatted and
 * compatible open source license.
    // Float  
     * @param excludes the exclusive filters: only fields and objects that don't match the exclusive filters will be written to the output.  
        if (values == null) {  
     */
        if (values == null) {
        } catch (IOException ex) {  
    public XContentBuilder endObject() throws IOException {
        return this;  
            throw new IllegalArgumentException(message);  
        return field(name).value(value);
    // Short  
        for (long l : values) {
    /**  
    // typed methods over this.
    public XContentBuilder array(String name, boolean[] values) throws IOException {
     *  
     * </p>
        } else if (value instanceof Enum<?>) {  
        assert name.equals(readableName) == false : "expected raw and readable field names to differ, but they were both: " + name;  
        writers.put(Boolean.class, (b, v) -> b.value((Boolean) v));
        return field(name).values(values);  
        return this;
            field(rawFieldName, rawValue);
        generatorInstance().flush();  
    // Binary
    private final Set<String> includes;
        generatorInstance().writeNumber(value);
     * inclusive filters are provided, the underlying builder will first use exclusion filters to remove fields and then will check the
    public XContentBuilder field(String name, Float value) throws IOException {  
        return this;
     */
    }
    /**
        generatorInstance().writeBooleanField(name, value);  
/*
}
    }  
    /**
    }
        return field(name).value(values);  
    /**  
        } catch (final IOException ex) {  
    private final Set<String> excludes;  
    }
        }
    public XContentBuilder value(boolean value) throws IOException {  
    public XContentBuilder value(byte[] value, int offset, int length) throws IOException {
        field(name, value);
    // ------------------------------  
        writers.put(long[].class, (b, v) -> b.values((long[]) v));
        return this;
    }
    }  
import java.io.Flushable;  
        for (Map.Entry<String, ?> value : values.entrySet()) {  
        }
    }
    public XContentBuilder(XContent xContent, OutputStream bos) throws IOException {
    public XContentBuilder prettyPrint() {
        XContent xContent,
    public XContentBuilder nullField(String name) throws IOException {  
    }
        return this;  
     */
     * inclusive filters are provided, the underlying builder will first use exclusion filters to remove fields and then will check the
    }
     */
    public XContentBuilder startObject() throws IOException {
        return (value == null) ? nullValue() : value(value.floatValue());  
     */  
     * When this flag is set to true, some types of values are written in a format easier to read for a human.
        writers.put(Date.class, XContentBuilder::timeValue);
 * software distributed under the License is distributed on an
    }  
            generator = xContent.createGenerator(bos, includes, excludes, prettyPrint);
    }
     * @return the output stream to which the built object is being written. Note that is dangerous to modify the stream.
            for (Object o : value) {
        }
import java.util.Objects;  
    }  
        }
    // ------------------------------
        if (writeStartAndEndHeaders) {
import java.nio.file.Path;
            throw new UncheckedIOException(ex);
        }
        }  
        startArray();  
        DATE_TRANSFORMERS = Collections.unmodifiableMap(dateTransformers);
    }  
    private XContentGenerator generator;
    // ------------------------------
            ensureNoSelfReferences(values);  
    }
        return this;  
        writers.put(Calendar.class, XContentBuilder::timeValue);  
        startArray();  
        generatorInstance().writeNumberField(name, value);  
        generatorInstance().writeNumberField(name, value);  
    }
        generatorInstance().writeStartObject();  
     * {@link Long} class.  
     * <p>  
     * to close which is a side effect done by @see BytesReference#bytes().
    public XContentBuilder field(String name, byte[] value) throws IOException {
            Function<Object, Object> transformer = DATE_TRANSFORMERS.get(timeValue.getClass());
        unknownValue(value, true);
        }
     * Use {@link XContentParser#charBuffer()} to read the value back  
                ensureNoSelfReferences(values);  
    public XContentBuilder value(String value) throws IOException {
    /**
    // BigDecimal
        endArray();
     */
        return this;
        return this;
        generatorInstance().writeBinary(value);
     */
    }  
    public XContentBuilder array(String name, double[] values) throws IOException {
     * @param parent references the parent this instance was copied from
        if (values == null) {  
    }
    }  
            }
        return this;
        return this;
        if (value == null) {  
        return this;
    /**  
     */
    @Override  
            if (ancestors.add(originalReference) == false) {
     * otherwise a date transformers lookup is performed.
            value(b);  
    // ------------------------------------------------------------------------
            endArray();
    }
        return field(name).value(value);
    private final XContent xContent;
        return this;
    // ------------------------------------------------------------------------
        generatorInstance().copyCurrentStructure(parser);  
        ensureNameNotNull(name);
            return nullValue();
    // Maps & Iterable  
    //
    ) throws IOException {
    }
        } catch (final IOException ex) {
        return new XContentBuilder(xContent, new ByteArrayOutputStream());
 * You may obtain a copy of the License at  
    private XContentBuilder values(BigDecimal[] values) throws IOException {  
    // Double  
        }  
     * @param includes the inclusive filters: only fields and objects that match the inclusive filters will be written to the output.
            dateTransformers.forEach(  
        void write(XContentBuilder builder, Object value) throws IOException;
            value(path);
        return this;  
        if (this.prettyPrint == false && generator != null) {
     * Writes a raw field with the value taken from the bytes in the stream
     * @param xContent the {@link XContent}  
            throw new IllegalStateException("Cannot change the prettyPrint status, the generator has been initialized already");  
import java.util.HashMap;
            // Write out the Enum toString
        if (values == null) {  
    public interface HumanReadableTransformer {  
    }
        generatorInstance().writeBinaryField(name, value);  
     * Make sure to call {@link #close()} when the builder is done with.
    // BigInteger
    public XContentBuilder startArray(String name) throws IOException {  
import org.opensearch.core.common.bytes.BytesReference;
            return nullField(name);  
    }
     */
    }  
            + rawFieldName;
import java.util.Set;
    // ------------------------------  
        return this;
        return this;
        endArray();
        }  
    public XContentBuilder startObject(String name) throws IOException {
        return this;
        ensureNameNotNull(name);
        }  
        ensureNotNull(name, "Field name cannot be null");
    // Objects  
    private XContentBuilder value(ToXContent value) throws IOException {
        } else {  
        if (ensureNoSelfReferences) {
    public XContentBuilder value(Double value) throws IOException {
        return this.prettyPrint;
        if (value == null) {
    }
    public XContentBuilder array(String name, String... values) throws IOException {  
        assert rawFieldName.equals(readableFieldName) == false : "expected raw and readable field names to differ, but they were both: "
     * remaining fields against the inclusive filters.  
        writers.put(Double.class, (b, v) -> b.value((Double) v));  
    /** writes a map without the start object and end object headers */
        writers.put(short[].class, (b, v) -> b.values((short[]) v));  
        endArray();
    // ------------------------------------------------------------------------
        return field(name).value(value, offset, length);
    // ------------------------------------------------------------------------  
    }
    }  
        ensureNameNotNull(name);
        if (value == null) {
            throw new IllegalArgumentException("cannot write xcontent for unknown value of type " + value.getClass());
        }
    }
    /**
    //
            value(b);
    public XContentBuilder value(Path value) throws IOException {
    }
    public XContentBuilder array(String name, BigDecimal[] values) throws IOException {
    }  
        ensureNameNotNull(name);  
        return value(value, ToXContent.EMPTY_PARAMS);  
    }
    /**
 * Modifications Copyright OpenSearch Contributors. See
     * XContentGenerator used to build the XContent object
    private XContentBuilder values(float[] values) throws IOException {
        if (value == null) {
     */
        writers.put(float[].class, (b, v) -> b.values((float[]) v));  
    public void flush() throws IOException {
        startArray();
    private XContentBuilder(
        }  
     * @param excludes the exclusive filters: only fields and objects that don't match the exclusive filters will be written to the output.  
        }
        return this;
        }  
 * SPDX-License-Identifier: Apache-2.0
     * <p>
    /**  
                (key, value) -> Objects.requireNonNull(value, "invalid null xcontent date transformer for class " + key)
        }  
        }
    public XContentBuilder field(String name, short value) throws IOException {
        if (humanReadable) {
            throw new IllegalStateException("Failed to close the XContentBuilder", e);
    }  
    public XContentBuilder value(Object value) throws IOException {
        return field(name).values(values);
        return generator;
        for (short s : values) {
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    }
    public XContentBuilder(XContent xContent, OutputStream os, Set<String> includes, Set<String> excludes) throws IOException {
        return (value == null) ? nullField(name) : field(name, value.booleanValue());
        return this;  
     * <p>
    public XContentBuilder array(String name, BigInteger[] values) throws IOException {
    // ToXContent  
        return this;
    private void unknownValue(Object value, boolean ensureNoSelfReferences) throws IOException {  
        return this;
     * Returns a string representation of the builder (only applicable for text based xcontent).  
            @SuppressWarnings("unchecked")  
    private boolean humanReadable = false;
        }
    }  
        generatorInstance().writeRawField(name, value);  
        endArray();
        return this;
    }  
            return nullValue();
    }
    private boolean prettyPrint;  
    private XContentBuilder values(boolean[] values) throws IOException {
     * some types of values are written in a format easier to read for a human.
            // treat as single value  
 * Licensed to Elasticsearch under one or more contributor  
    // ------------------------------
    public XContentBuilder field(String name, int value) throws IOException {
    }
        }
    }  
            return nullValue();
    }
    // ------------------------------------------------------------------------  
            }
            startObject();
            return Arrays.asList(objectArray);
            Object rawValue = transformer.rawValue(value);
            value(path);
     * {@link #close()} when the builder is done with.  
    /**  
        writers.put(Long.class, (b, v) -> b.value((Long) v));  
                unknownValue(value, false);
    public XContentBuilder nullValue() throws IOException {  
        }
        }
 * A utility to build XContent (ie json).  
    }  
        Set<String> excludes,
            return nullValue();
        startArray();
     */
    private XContentBuilder value(ToXContent value, ToXContent.Params params) throws IOException {  
    @FunctionalInterface
    public XContentBuilder value(Integer value) throws IOException {
        }  
            return nullField(name);  
    }
        return this;
        writers.put(String[].class, (b, v) -> b.values((String[]) v));
    /**
    // ------------------------------------------------------------------------
    }
    public XContentBuilder field(String name, Byte value) throws IOException {  
        for (float f : values) {
    }
     * remaining fields against the inclusive filters.  
 *
            value(iterable, ensureNoSelfReferences);
        if (humanReadable) {
     * Note: explicitly or implicitly (from debugger) calling toString() could cause XContentBuilder
        HUMAN_READABLE_TRANSFORMERS = Collections.unmodifiableMap(humanReadableTransformer);
    }  
        generatorInstance().writeEndArray();
        if (values == null) {
    }  
        Set<String> includes,
            value(b);
            Function<Object, Object> longTransformer = DATE_TRANSFORMERS.get(Long.class);
        generatorInstance().writeNumberField(name, value);
        writers.put(Byte.class, (b, v) -> b.value((Byte) v));  
        generatorInstance().writeNumber(value);
        XContentBuilder parent,  
    public MediaType contentType() {
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
    // ------------------------------------------------------------------------  
     */
            addlWriters.forEach((key, value) -> Objects.requireNonNull(value, "invalid null xcontent writer for class " + key));
    }
    public boolean humanReadable() {  
    // Human readable fields
        generatorInstance().writeNumber(value);
        }  
    public XContentBuilder endArray() throws IOException {
import java.io.InputStream;
    // ------------------------------------------------------------------------
    }
        return field(name).values(values);
    public XContentGenerator generator() {  
        endArray();
    public XContentBuilder field(String name, float value) throws IOException {
    public XContentBuilder array(String name, float[] values) throws IOException {
        return this;  
        for (XContentBuilderExtension service : ServiceLoader.load(XContentBuilderExtension.class)) {  
            field(readableFieldName, Objects.toString(value));  
        this(xContent, os, includes, excludes, null, false);  
    public XContentBuilder map(Map<String, ?> values) throws IOException {
import java.util.ServiceLoader;
 * Unless required by applicable law or agreed to in writing,
        this.includes = includes;
    public XContentBuilder(XContent xContent, OutputStream bos, Set<String> includes) throws IOException {
    public XContentBuilder field(String name) throws IOException {  
/**
                (key, value) -> Objects.requireNonNull(value, "invalid null xcontent transformer for human readable class " + key)
        }
 * this work for additional information regarding copyright
        return (value == null) ? nullValue() : value(value.booleanValue());  
    }  
    }  
            startArray();
     */  
    public XContentBuilder timeField(String name, String readableName, long value) throws IOException {
    private XContentBuilder values(int[] values) throws IOException {
     * Output stream to which the built object is written  
 * The OpenSearch Contributors require contributions made to  
        }
import java.math.BigDecimal;
            ancestors.remove(originalReference);
        return field(name).values(values);  
    private XContentBuilder map(Map<String, ?> values, boolean ensureNoSelfReferences, boolean writeStartAndEndHeaders) throws IOException {
    }
    // ------------------------------------------------------------------------
    // ------------------------------  
        generatorInstance().writeStartArray();
            values(objectArray, ensureNoSelfReferences);  
            generatorInstance().usePrintLineFeedAtEnd();
        generatorInstance().writeNull();
    // Misc.
                throw new IllegalArgumentException("cannot write time value xcontent for unknown value of type " + timeValue.getClass());  
     */  
import java.io.ByteArrayOutputStream;
    }
/*  
        return field(name).values(values);
    // These methods are used when the type of value is unknown. It tries to fallback
    public XContentBuilder field(String name, Boolean value) throws IOException {  
    }  
     * filter will be written to the output stream. Make sure to call
    // ------------------------------------------------------------------------
        return (value == null) ? nullValue() : value(value.longValue());  
    /**  
    // ------------------------------------------------------------------------
            return generatorInstance().contentType();  
        generatorInstance().writeNumberField(name, value);  
        writers.put(Locale.class, (b, v) -> b.value(v.toString()));  
                throw new IllegalArgumentException("Iterable object is self-referencing itself");
        generatorInstance().writeRawValue(stream, contentType);
        }
import java.util.function.Function;  
            Map<Class<?>, Writer> addlWriters = service.getXContentWriters();
        } else if (value instanceof Iterable<?> iterable && value instanceof Path == false) {
     * @deprecated use {@link #rawField(String, InputStream, MediaType)} to avoid content type auto-detection
            }  
    // ------------------------------------------------------------------------
    // such as time values or byte sizes. The human readable variant is only
        if (value == null) {
    public XContentBuilder array(String name, Object... values) throws IOException {
            nullValue();
            value(i);
    // Path
    public XContentBuilder field(String name, Double value) throws IOException {  
        this.humanReadable = humanReadable;
     * @param xContent the {@link XContent}
        for (int i : values) {
        ensureNameNotNull(name);
        this.prettyPrint = prettyPrint;
     * @throws IOException if an {@link IOException} occurs while building the content
    }
import java.util.Locale;
    private XContentBuilder values(Object[] values, boolean ensureNoSelfReferences) throws IOException {  
        endArray();
        generatorInstance().writeNumber(value);
    }
            return value(transformer.apply(timeValue));
            if (ensureNoSelfReferences) {
     *
        return field(name).values(values);
    public XContentBuilder value(long value) throws IOException {  
import java.util.Date;  
    }
    /**
    private final OutputStream bos;
        }
