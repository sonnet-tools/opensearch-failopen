 * Licensed to Elasticsearch under one or more contributor
        return (value == null) ? nullValue() : value(value.intValue());
     * @param os       the output stream
        generatorInstance().writeBinaryField(name, value);
import java.nio.file.Path;
    public XContentBuilder value(Float value) throws IOException {
     * <p>
     * <p>
        Iterable<?> it = convert(value);
    }
        if (value != null) {
import java.util.Set;
        return this;
        writers.put(Short.class, (b, v) -> b.value((Short) v));
    /**
    public static XContentBuilder builder(XContent xContent, Set<String> includes, Set<String> excludes) throws IOException {
        endArray();
        startArray();
        generatorInstance().writeBinary(value);
            value(b);
 *
    }
    static {
    public XContentBuilder field(String name, short value) throws IOException {
            return nullField(name);
        return this;
            Map<Class<?>, HumanReadableTransformer> addlTransformers = service.getXContentHumanReadableTransformers();
        startArray();
     */
    public XContentBuilder field(String name, Float value) throws IOException {
    public void close() {
     * XContentGenerator used to build the XContent object
     * the generator instantiation till the first usage.
     * remaining fields against the inclusive filters.
    public XContentBuilder startArray(String name) throws IOException {
     * @param excludes the exclusive filters: only fields and objects that don't match the exclusive filters will be written to the output.
    /**
    }
        writers.put(long[].class, (b, v) -> b.values((long[]) v));
    // ------------------------------
    public XContentBuilder field(String name, float value) throws IOException {
    public XContentBuilder humanReadable(boolean humanReadable) {
        generatorInstance().writeStringField(name, value);
     * to close which is a side effect done by @see BytesReference#bytes().
     * to call {@link #close()} when the builder is done with.
        return this;
        return this;
        OutputStream os,
    }
    }
    public XContentBuilder value(double value) throws IOException {
            return nullValue();
    }
            field(value.getKey());
     * Writes a raw field with the value taken from the bytes in the stream
        return this.humanReadable;
    // ------------------------------------------------------------------------
        }
    }
        return this;
    }
    private boolean prettyPrint;
    }
    public XContentBuilder array(String name, boolean[] values) throws IOException {
import java.math.BigInteger;
        HumanReadableTransformer transformer = HUMAN_READABLE_TRANSFORMERS.get(value.getClass());
        return this;
import java.util.GregorianCalendar;
            if (ancestors.add(originalReference) == false) {
     */
        if (value == null) {
        }
        }
            return nullValue();
        if (writeStartAndEndHeaders) {
        if (values == null) {
    public XContentBuilder field(String name) throws IOException {
    public static void ensureNotNull(Object value, String message) {
            return nullValue();
        }
     *
    // ------------------------------
     * <p>
        }
            throw new UncheckedIOException(ex);
            return generatorInstance().contentType();
            return nullValue();
     *
        field(name, value);
    @FunctionalInterface
    private final XContent xContent;
        } else {
     */
        }
            return;
    // ------------------------------
     * @param os       the output stream
    public boolean humanReadable() {
    public XContentBuilder field(String name, int value) throws IOException {
        ensureNameNotNull(name);
    /**
    // ------------------------------------------------------------------------
        dateTransformers.put(String.class, Function.identity());
    private XContentBuilder values(int[] values) throws IOException {
        for (Map.Entry<String, ?> value : values.entrySet()) {
     * otherwise a date transformers lookup is performed.
     * Write a time-based value, if the value is null a null value is written,
        ensureNameNotNull(name);
     * The writer interface for the serializable content builder
    public XContentBuilder value(BigDecimal value) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        }
        }
     * <p>
    }
        return field(name).values(values);
     * Use pretty print ("false" by default)
        if (humanReadable) {
 * ownership. Elasticsearch licenses this file to you under
    // Binary
    }
        assert name.equals(readableName) == false : "expected raw and readable field names to differ, but they were both: " + name;
     * null value is written, otherwise a date transformers lookup is performed.
        generatorInstance().writeNumberField(name, value);
                throw new IllegalArgumentException("Iterable object is self-referencing itself");
import java.util.Date;
    }
     * </p>
        startArray();
        if (value == null) {
    public XContentBuilder rawField(String name, InputStream value) throws IOException {
        return field(name).values(values);
     * When this flag is set to true, some types of values are written in a format easier to read for a human.
     */
        if (values == null) {
     * Creates a new builder using the provided XContent, output stream and some inclusive and/or exclusive filters. When both exclusive and
    // ------------------------------------------------------------------------
     * The exclusive filters: only fields and objects that don't match the exclusive filters will be written to the output.
        }
        Writer writer = WRITERS.get(value.getClass());
        if (value == null) {
    // ------------------------------
        }
        }
    private static void ensureNoSelfReferences(final Iterable<?> value, Object originalReference, final Set<Object> ancestors) {
    // ------------------------------------------------------------------------
        writers.put(ZonedDateTime.class, (b, v) -> b.value(v.toString()));
     */
    }
    public XContentBuilder field(String name, Integer value) throws IOException {
    public XContentBuilder startArray() throws IOException {
    public XContentBuilder array(String name, BigDecimal[] values) throws IOException {
        if (values == null) {
        return (value == null) ? nullField(name) : field(name, value.byteValue());
        return this;
            @SuppressWarnings("unchecked")
    // ------------------------------
        }
        return field(name).values(values);
        // treat strings as already converted
        XContent xContent,
    }
     */
        }
        generatorInstance().writeStartArray();
        writers.put(Byte.class, (b, v) -> b.value((Byte) v));
     * The builder uses an internal {@link ByteArrayOutputStream} output stream to build the content. When both exclusive and
import org.opensearch.common.annotation.PublicApi;
        } catch (final IOException ex) {
            // iterating over entries will cause a stackoverflow error
            return nullValue();
    }
            return nullValue();
    public XContentBuilder percentageField(String rawFieldName, String readableFieldName, double percentage) throws IOException {
        if (values == null) {
            return nullValue();
            value(path);
        if (writeStartAndEndHeaders) {
     */
        for (BigDecimal b : values) {
                ensureNoSelfReferences(values);
    // ------------------------------------------------------------------------
     * Indicate that the current {@link XContentBuilder} must write a line feed ("\n")
        } else if (value instanceof Object[] objectArray) {
        generatorInstance().writeNumberField(name, value);
    public XContentBuilder humanReadableField(String rawFieldName, String readableFieldName, Object value) throws IOException {
    }
/*
        if (values == null) {
     * inclusive filters are provided, the underlying builder will first use exclusion filters to remove fields and then will check the
        ensureNameNotNull(name);
    /**
    }
 */
    }
        if (humanReadable) {
    // ------------------------------
        this(xContent, bos, includes, Collections.emptySet());
            // Write out the Enum toString
        }
        }
    }
    /**
    // ------------------------------------------------------------------------
    public XContentBuilder field(String name, Double value) throws IOException {
            // treat as single value
        return this;
    }
        }
        return field(name).value(value, offset, length);
            return value(transformer.apply(timeValue));
 * not use this file except in compliance with the License.
        generatorInstance().writeUTF8String(bytes, offset, length);
        }
    }
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
     */
    /**
        }
    public XContentBuilder field(String name, byte[] value, int offset, int length) throws IOException {
        return (value == null) ? nullValue() : value(value.doubleValue());
            value(s);
        endArray();
        for (int i : values) {
    public XContentBuilder field(String name, Boolean value) throws IOException {
     * some filters. If filters are specified, only those values matching a
                (key, value) -> Objects.requireNonNull(value, "invalid null xcontent transformer for human readable class " + key)
@PublicApi(since = "1.0.0")
 */
            ensureNoSelfReferences(it, value, Collections.newSetFromMap(new IdentityHashMap<>()));
    private static final Map<Class<?>, HumanReadableTransformer> HUMAN_READABLE_TRANSFORMERS;
 * Modifications Copyright OpenSearch Contributors. See
        return this;
    /**
        for (long l : values) {
        return BytesReference.bytes(this).utf8ToString();
     * @return the value of the "human readable" flag. When the value is equal to true,
        generatorInstance().writeBinary(value, offset, length);
        generatorInstance().writeNumber(value);
        return this;
            return nullField(name);
        return field(name).values(values);
        return field(name).map(values);
    }
        for (float f : values) {
            return nullValue();
    public static XContentBuilder builder(XContent xContent) throws IOException {
            values(objectArray, ensureNoSelfReferences);
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.prettyPrint = true;
    // ------------------------------------------------------------------------
        return this;
        }
    public XContentBuilder(XContent xContent, OutputStream bos, Set<String> includes) throws IOException {
            return nullValue();
import java.io.InputStream;
    public void flush() throws IOException {
     *
    // Short
        // Load pluggable extensions
        return this;
    // used if the humanReadable flag has been set
    }
        }
    public XContentBuilder field(String name, Object value) throws IOException {
    }
 * You may obtain a copy of the License at
    // ------------------------------------------------------------------------
        }
        return field(name).value(value, params);
        return field(name).value(value);
    public XContentBuilder field(String name, Short value) throws IOException {
        for (BigInteger b : values) {
    }
        startArray();
    public String toString() {
        }
    /**
    public XContentBuilder value(short value) throws IOException {
    /**
     * Create a new {@link XContentBuilder} using the given {@link XContent} content.
    }
    }
    private final Set<String> excludes;
    public XContentBuilder field(String name, Long value) throws IOException {
            dateTransformers.forEach(
     * @param excludes the exclusive filters: only fields and objects that don't match the exclusive filters will be written to the output.
        writers.put(short[].class, (b, v) -> b.values((short[]) v));
    }
    // ------------------------------------------------------------------------
            return nullValue();
    /**
        return this;
        }
    private XContentBuilder value(ToXContent value) throws IOException {
        return this;
     * @param includes the inclusive filters: only fields and objects that match the inclusive filters will be written to the output.
        return value(Arrays.asList(values), ensureNoSelfReferences);
     * </p>
        } catch (IOException e) {
    }
            writer.write(this, value);
     * @throws IOException if an {@link IOException} occurs while building the content
     * Set the "human readable" flag. Once set, some types of values are written in a
        writers.put(Boolean.class, (b, v) -> b.value((Boolean) v));
    private XContentBuilder(
    }
            }
     * @param prettyPrint use pretty printer
        generatorInstance().writeFieldName(name);
    // ------------------------------------------------------------------------
        generatorInstance().writeNull();
import java.util.ServiceLoader;
 * under the License.
        }
            endArray();
    public XContentBuilder mapContents(Map<String, ?> values) throws IOException {
     */
     * The builder uses an internal {@link ByteArrayOutputStream} output stream to build the content.
        endArray();
    //
        return (value == null) ? nullField(name) : field(name, value.booleanValue());
        endArray();
    private XContentBuilder value(Iterable<?> values, boolean ensureNoSelfReferences) throws IOException {
    }
        return this;
        } else if (value instanceof Iterable<?> iterable) {
        Object rawValue(Object value) throws IOException;
    public XContentBuilder startObject(String name) throws IOException {
            value(b);
        writers.put(Locale.class, (b, v) -> b.value(v.toString()));
    }
    }
 * KIND, either express or implied.  See the License for the
    public XContentBuilder field(String name, byte[] value) throws IOException {
     * some types of values are written in a format easier to read for a human.
        if (value instanceof Map<?, ?> map) {
        return (value == null) ? nullField(name) : field(name, value.intValue());
     * Writes the binary content of the given byte array as UTF-8 bytes.
     */
    }
import java.io.ByteArrayOutputStream;
        return this;
            generatorInstance().close();
                ensureNoSelfReferences(convert(o), o, ancestors);
            return nullValue();
    }
        } else if (value instanceof Path path) {
        return field(name).value(values);
        startArray();
        ensureNameNotNull(name);
    public XContentBuilder nullValue() throws IOException {
     * @deprecated use {@link #rawField(String, InputStream, MediaType)} to avoid content type auto-detection
        assert rawFieldName.equals(readableFieldName) == false : "expected raw and readable field names to differ, but they were both: "
        return field(name).timeValue(timeValue);
     * The inclusive filters: only fields and objects that match the inclusive filters will be written to the output.
            return nullValue();
     */
    }
    // ------------------------------
    // ------------------------------
import java.util.IdentityHashMap;
    // Long
    // Human readable fields
        writers.put(String[].class, (b, v) -> b.values((String[]) v));
        }
        assert rawFieldName.equals(readableFieldName) == false : "expected raw and readable field names to differ, but they were both: "
    private static void ensureNoSelfReferences(Object value) {
    private XContentBuilder values(Object[] values, boolean ensureNoSelfReferences) throws IOException {
        return this;
    // Byte
            return nullValue();
        generatorInstance().writeEndArray();
            }
    @Override
    // BigDecimal
        }
        startArray();
    private final OutputStream bos;
        return value(value.toString());
     * Trying to write more contents after toString() will cause NPE. Use it with caution.
            return map.values();
    // These methods are used when the type of value is unknown. It tries to fallback
        }
 * A utility to build XContent (ie json).
            addlWriters.forEach((key, value) -> Objects.requireNonNull(value, "invalid null xcontent writer for class " + key));
            Map<Class<?>, Writer> addlWriters = service.getXContentWriters();
    private XContentBuilder values(BigInteger[] values) throws IOException {
     * Output stream to which the built object is written
 * The OpenSearch Contributors require contributions made to
        } else if (value instanceof Object[] objectArray) {
    // ------------------------------
    }
        return this;
            return nullValue();
    // ------------------------------
        for (XContentBuilderExtension service : ServiceLoader.load(XContentBuilderExtension.class)) {
        if (generator == null) {
        writers.put(GregorianCalendar.class, XContentBuilder::timeValue);
    // ------------------------------------------------------------------------
        if (value == null) {
    public XContentBuilder field(String name, double value) throws IOException {
    public XContentBuilder value(Object value) throws IOException {
        // iterating over map entries will cause a stackoverflow error
import java.util.function.Function;
    }
            throw new UncheckedIOException(ex);
    }
        return this;
     * (like changing pretty printer, etc). To workaround and preserve the APIs, we do defer
    private final Set<String> includes;
        return bos;
    public XContentBuilder value(byte[] value, int offset, int length) throws IOException {
    }
     */
            writers.putAll(addlWriters);
        return this;
/**
        unknownValue(value, true);
        generatorInstance().writeNumberField(name, value);
            nullValue();
        generatorInstance().writeString(value);
    public XContentBuilder value(long value) throws IOException {
            return nullField(name);
     * XContent instance
import java.util.Objects;
        ensureNameNotNull(name);
     */
            unknownValue(value.getValue(), false);
     * filter will be written to the output stream. Make sure to call
            + rawFieldName;
    // ------------------------------
 *
        generatorInstance().writeStartObject();
     * Create a new {@link XContentBuilder} using the given {@link XContent} content and some inclusive and/or exclusive filters.
    public XContentBuilder field(String name, Map<String, Object> values) throws IOException {
        generatorInstance().writeRawField(name, value);
    }
     * remaining fields against the inclusive filters.
            return Arrays.asList(objectArray);
    @Override
        if (value == null) {
            value(Objects.toString(value));
        Map<Class<?>, HumanReadableTransformer> humanReadableTransformer = new HashMap<>();
    // ------------------------------
    }
        return this;
    }
 * license agreements. See the NOTICE file distributed with
    }
    private XContentBuilder values(double[] values) throws IOException {
        return this;
    // ------------------------------
    // Boolean
        }
            );
            endObject();
        }
     */
        for (double b : values) {
        }
        endArray();
/*
    private static Iterable<?> convert(Object value) {
            return nullValue();
     * Returns a string representation of the builder (only applicable for text based xcontent).
    public XContentBuilder copyCurrentStructure(XContentParser parser) throws IOException {
    // typed methods over this.
    /**
    }
     * Constructs a new builder using the provided XContent, an OutputStream and
     * Make sure to call {@link #close()} when the builder is done with.
                throw new IllegalArgumentException("cannot write time value xcontent for unknown value of type " + timeValue.getClass());
            Function<Object, Object> longTransformer = DATE_TRANSFORMERS.get(Long.class);
    }
        return this;
    }
package org.opensearch.core.xcontent;
/*
            return generatorInstance();
     * Write a time-based field and value, if the passed timeValue is null a
        }
    // ------------------------------
        if (ensureNoSelfReferences) {
    // ------------------------------------------------------------------------
     * @param includes the inclusive filters: only fields and objects that match the inclusive filters will be written to the output.
    }
     * unformatted version of the time value using the date transformer for the
        return this;
    private XContentBuilder values(BigDecimal[] values) throws IOException {
        }
        generatorInstance().writeNumber(value);
 * compatible open source license.
    /**
    private XContentBuilder values(short[] values) throws IOException {
    // String
    public XContentBuilder value(int value) throws IOException {
        return map(values, true, true);
        if (value == null) {
    }
    private XContentBuilder values(String[] values) throws IOException {
    /** writes a map without the start object and end object headers */
        } else if (value instanceof Map<?, ?>) {
        // checks that the map does not contain references to itself because
        return this;
        writers.put(String.class, (b, v) -> b.value((String) v));
        return this;
        this.humanReadable = humanReadable;
        }
 * Unless required by applicable law or agreed to in writing,
        ensureNameNotNull(name);
    /**
        return (value == null) ? nullValue() : value(value.shortValue());
        writers.put(Double.class, (b, v) -> b.value((Double) v));
    }
        }
import java.util.Calendar;
        Map<Class<?>, Function<Object, Object>> dateTransformers = new HashMap<>();
     * <p>
import java.io.UncheckedIOException;
            value(toXContent);
     */
        writers.put(BigInteger.class, (b, v) -> b.value((BigInteger) v));
    }
        }
        return this;
    public XContentBuilder startObject() throws IOException {
    }
    }
    public XContentBuilder timeField(String name, Object timeValue) throws IOException {
        generatorInstance().writeBoolean(value);
        return field(name).values(values);
     * <p>
    // Maps & Iterable
        return this;
        ensureNotNull(name, "Field name cannot be null");
            Map<Class<?>, Function<Object, Object>> addlDateTransformers = service.getDateTransformers();
     * format easier to read for a human.
        writers.put(Long.class, (b, v) -> b.value((Long) v));
        if (value == null) {
        writers.put(Float.class, (b, v) -> b.value((Float) v));
            field(readableFieldName, Objects.toString(value));
    public XContentBuilder value(BigInteger value) throws IOException {
     * If the {@code humanReadable} flag is set, writes both a formatted and
    }
            startArray();
    private XContentGenerator generator;
        this(xContent, bos, Collections.emptySet(), Collections.emptySet());
            value(b);
    public XContentBuilder field(String name, long value) throws IOException {
import java.io.OutputStream;
import java.io.IOException;
        return this;
        } else {
    }
        if (values == null) {
        startArray();
    }
import java.util.Arrays;
    // These are fields that have a "raw" value and a "human readable" value,
    public XContentBuilder array(String name, short[] values) throws IOException {
        return (value == null) ? nullValue() : value(value.floatValue());
     * Constructs a new builder using the provided XContent and an OutputStream. Make sure
            field(readableName).value(longTransformer.apply(value));
        }
                unknownValue(value, false);
    /**
        generatorInstance().writeNumber(value);
    }
    private XContentBuilder values(boolean[] values) throws IOException {
        generatorInstance().flush();
    // ------------------------------
    public XContentBuilder value(Byte value) throws IOException {
    public XContentBuilder map(Map<String, ?> values) throws IOException {
     * Note: explicitly or implicitly (from debugger) calling toString() could cause XContentBuilder
            value(f);
            throw new IllegalStateException("Failed to close the XContentBuilder", e);
    public XContentBuilder array(String name, String... values) throws IOException {
    public XContentBuilder lfAtEnd() {
        boolean prettyPrint
        return field(name).startArray();
        }
    /**
        return this;
        this.xContent = xContent;
    public XContentBuilder timeValue(Object timeValue) throws IOException {
        return field(name).values(values);
    }
        } else {
import org.opensearch.core.common.bytes.BytesReference;
        if (value == null) {
     * @param parent references the parent this instance was copied from
    // Raw fields
    }
import java.time.ZonedDateTime;
        return (value == null) ? nullValue() : value(value.longValue());
    public XContentBuilder value(Double value) throws IOException {
    }
    }
        generatorInstance().writeEndObject();
    }
    // on typed methods and use Object.toString() as a last resort. Always prefer using
        return this;
        return field(name).startObject();
    }
        writers.put(double[].class, (b, v) -> b.values((double[]) v));
import java.util.Locale;
    }
    public XContentBuilder field(String name, byte value) throws IOException {
    }
     * inclusive filters are provided, the underlying builder will first use exclusion filters to remove fields and then will check the
        writers.put(Integer.class, (b, v) -> b.value((Integer) v));
     * {@link Long} class.
        return field(name).latlon(lat, lon);
    public XContentBuilder field(String name, BigInteger value) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        return generator;
        for (short s : values) {
        Map<Class<?>, Writer> writers = new HashMap<>();
    // BigInteger
    public XContentBuilder value(float value) throws IOException {
    public XContentBuilder field(String name, Iterable<?> values) throws IOException {
        return (value == null) ? nullField(name) : field(name, value.floatValue());
        try {
 */
        ensureNameNotNull(name);
    /**
        return (value == null) ? nullValue() : value(value.byteValue());
     */
    }
        this(xContent, os, includes, excludes, null, false);
        return this;
    ) throws IOException {
    // ------------------------------------------------------------------------
            throw new UncheckedIOException(ex);
        }
        if (values == null) {
        return this;
        } else {
    private static final Map<Class<?>, Writer> WRITERS;
            if (ensureNoSelfReferences) {
    }
        return this;
            return nullValue();
        this.prettyPrint = prettyPrint;
    }
    // ------------------------------------------------------------------------
 *
        writers.put(float[].class, (b, v) -> b.values((float[]) v));
import java.util.Collections;
        if (value == null) {
        if (values == null) {
    private XContentBuilder values(long[] values) throws IOException {
            value(b);
    public XContentBuilder field(String name, ToXContent value, ToXContent.Params params) throws IOException {
                throw new IllegalArgumentException("cannot write time value xcontent for unknown value of type Long");
    }
            value(iterable, ensureNoSelfReferences);
    public XContentBuilder array(String name, Object... values) throws IOException {
        HUMAN_READABLE_TRANSFORMERS = Collections.unmodifiableMap(humanReadableTransformer);
    }
    }
    private XContentBuilder value(ToXContent value, ToXContent.Params params) throws IOException {
        this.excludes = excludes;
            // checks that the iterable does not contain references to itself because
                // pass ensureNoSelfReferences=false as we already performed the check at a higher level
    }
            Function<Object, Object> transformer = DATE_TRANSFORMERS.get(timeValue.getClass());
    }
     */
    // Double
     * @opensearch.internal
    public XContentBuilder array(String name, float[] values) throws IOException {
    public XContentBuilder rawValue(InputStream stream, MediaType contentType) throws IOException {
     * This only applies for JSON XContent type. It has no effect for other types.
    /**
            return iterable;
     */
        return this;
            generator = xContent.createGenerator(bos, includes, excludes, prettyPrint);
    }
    // ------------------------------
        return map(values, true, false);
     * Interface for transforming complex objects into their "raw" equivalents for human-readable fields
        ensureNameNotNull(name);
    }
        } else if (value instanceof ToXContent toXContent) {
     * @param xContent the {@link XContent}
    // ------------------------------
            field(rawFieldName, rawValue);
        return this;
    }
    public XContentBuilder value(boolean value) throws IOException {
        return this;
        }
    private XContentBuilder values(float[] values) throws IOException {
    // Misc.
        try {
    }
    }
        value.toXContent(this, params);
            }
        } catch (final IOException ex) {
            value(s);
    }
        return field(name).value(value);
import java.math.BigDecimal;
            addlTransformers.forEach(
    // ------------------------------------------------------------------------
    // ------------------------------------------------------------------------
            return nullValue();
        this.bos = os;
    public XContentBuilder value(Short value) throws IOException {
        }
        return this;
     * @param includes the inclusive filters: only fields and objects that match the inclusive filters will be written to the output.
            value(i);
    }
            return this;
            throw new IllegalArgumentException(message);
    }
    }
    // ------------------------------------------------------------------------
    }
    public XContentGenerator generator() {
    public XContentBuilder latlon(String name, double lat, double lon) throws IOException {
        }
    public XContentBuilder(XContent xContent, OutputStream os, Set<String> includes, Set<String> excludes) throws IOException {
        return (value == null) ? nullField(name) : field(name, value.shortValue());
        }
    /**
        return this;
        return value(value, ToXContent.EMPTY_PARAMS);
            throw new IllegalArgumentException("cannot write xcontent for unknown value of type " + value.getClass());
        generatorInstance().writeRawValue(stream, contentType);
            if (transformer == null) {
    /**
     */
        }
     * {@link #close()} when the builder is done with.
            for (Object value : values) {
    // ------------------------------------------------------------------------
}
    }
    }
        generatorInstance().writeNumber(value);
        }
     * @throws IOException if an {@link IOException} occurs while building the content
        return this;
    // Path
        startArray();
        startArray();
import java.util.HashMap;
        }
    }
     *
    //
    private void unknownValue(Object value, boolean ensureNoSelfReferences) throws IOException {
    private XContentBuilder map(Map<String, ?> values, boolean ensureNoSelfReferences, boolean writeStartAndEndHeaders) throws IOException {
        } else {
import java.util.Map;
        ensureNameNotNull(name);
    // Integer
        field(rawFieldName, percentage);
    public XContentBuilder endObject() throws IOException {
            ancestors.remove(originalReference);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
        writers.put(int[].class, (b, v) -> b.values((int[]) v));
        if (values instanceof Path path) {
 * this work for additional information regarding copyright
        if (value == null) {
    }
        return this;
    // ------------------------------
        endArray();
        }
    public XContentBuilder array(String name, BigInteger[] values) throws IOException {
    }
import java.io.Closeable;
        if (value == null) {
        }
        Set<String> includes,
    /**
            if (longTransformer == null) {
        }
import java.io.Flushable;
     */
        return field(name).values(values);
    }
        generatorInstance().writeNumber(value);
    public XContentBuilder endArray() throws IOException {
    public XContentBuilder(XContent xContent, OutputStream bos) throws IOException {
            );
        if (values == null) {
    // LatLon
            ensureNoSelfReferences(values);
    }
        try {
        endArray();
    /**
    }
        if (value == null) {
        return field(name).values(values, true);
    }
    // ToXContent
        Set<String> excludes,
            generatorInstance().usePrintLineFeedAtEnd();
            for (Object o : value) {
    // Date
        return this;
    public MediaType contentType() {
        }
    public XContentBuilder latlon(double lat, double lon) throws IOException {
    }
    }
    }
     * Since 3.x release line, Jackson does not allow on the fly changes to the generator
     * inclusive filters are provided, the underlying builder will first use exclusion filters to remove fields and then will check the
    public XContentBuilder timeField(String name, String readableName, long value) throws IOException {
    private static final Map<Class<?>, Function<Object, Object>> DATE_TRANSFORMERS;
        return this;
        writers.put(Class.class, (b, v) -> b.value(v.toString()));
    }
        } else if (value instanceof Enum<?>) {
    public interface HumanReadableTransformer {
        }
        try {
        for (String s : values) {
    private boolean humanReadable = false;
        return this;
        } else if (value instanceof Iterable<?> iterable && value instanceof Path == false) {
                (key, value) -> Objects.requireNonNull(value, "invalid null xcontent date transformer for class " + key)
    /**
    // ------------------------------
        WRITERS = Collections.unmodifiableMap(writers);
            return null;
        return this;
        generatorInstance().writeRawField(name, value, mediaType);
    }
        generatorInstance().writeNumberField(name, value);
        return this.prettyPrint;
        }
    public XContentBuilder nullField(String name) throws IOException {
    }
     * Writes a raw field with the value taken from the bytes in the stream
        if (values == null) {
        this.includes = includes;
     */
        endArray();
            value(path);
        if (timeValue == null) {
public final class XContentBuilder implements Closeable, Flushable {
        generatorInstance().copyCurrentStructure(parser);
        }
        generatorInstance().writeNumber(value);
    }
            return nullValue();
            dateTransformers.putAll(addlDateTransformers);
    // Structure (object, array, field, null values...)
    public XContentBuilder field(String name, BigDecimal value) throws IOException {
    }
        ensureNameNotNull(name);
            return nullValue();
     * Make sure to call {@link #close()} when the builder is done with.
     * remaining fields against the inclusive filters.
    /**
     * @param excludes the exclusive filters: only fields and objects that don't match the exclusive filters will be written to the output.
        return (value == null) ? nullField(name) : field(name, value.doubleValue());
        writers.put(byte[].class, (b, v) -> b.value((byte[]) v));
     * Use {@link XContentParser#charBuffer()} to read the value back
    }
            }
    public XContentBuilder field(String name, boolean value) throws IOException {
    }
    // ------------------------------
        generatorInstance().writeBooleanField(name, value);
        return field(name).values(values);
    }
    // Float
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    public XContentBuilder value(Boolean value) throws IOException {
        generatorInstance().writeNullField(name);
        generatorInstance().writeNumberField(name, value);
        return this;
    public XContentBuilder rawField(String name, InputStream value, MediaType mediaType) throws IOException {
        return this;
        writers.put(Calendar.class, XContentBuilder::timeValue);
    public XContentBuilder value(Integer value) throws IOException {
        return field(name).values(values);
    public XContentBuilder value(byte value) throws IOException {
        generatorInstance().writeNumberField(name, value);
        DATE_TRANSFORMERS = Collections.unmodifiableMap(dateTransformers);
        return this;
    /**
            // pass ensureNoSelfReferences=false as we already performed the check at a higher level
    }
        return this;
    }
    /**
        if (writer != null) {
        return new XContentBuilder(xContent, new ByteArrayOutputStream(), includes, excludes);
    @Override
        endArray();
            // Path implements Iterable<Path> and causes endless recursion and a StackOverFlow if treated as an Iterable here
    }
        return field(name).value(value);
    // ------------------------------
    public OutputStream getOutputStream() {
    // ------------------------------------------------------------------------
    // such as time values or byte sizes. The human readable variant is only
    public XContentBuilder utf8Value(byte[] bytes, int offset, int length) throws IOException {
            value(l);
    }
    private XContentGenerator generatorInstance() throws IOException {
        return new XContentBuilder(xContent, new ByteArrayOutputStream());
        if (humanReadable) {
    public XContentBuilder array(String name, int[] values) throws IOException {
    public XContentBuilder field(String name, Byte value) throws IOException {
        XContentBuilder parent,
    }
        return this;
            }
        if (it != null) {
     * @return the output stream to which the built object is being written. Note that is dangerous to modify the stream.
     * @throws IllegalArgumentException if there is no transformers for the type of object
            startObject();
    }
        if (value == null) {
    }
        void write(XContentBuilder builder, Object value) throws IOException;
     * Writes a value with the source coming directly from the bytes in the stream
        }
     * @param xContent the {@link XContent}
        if (transformer != null) {
    }
            final Map<String, ?> valueMap = (Map<String, ?>) value;
            humanReadableTransformer.putAll(addlTransformers);
     */
    /**
     */
    @Deprecated
            + rawFieldName;
        if (values == null) {
        if (value == null) {
            field(readableFieldName, String.format(Locale.ROOT, "%1.1f%%", percentage));
        if (values == null) {
     * @return a new {@link XContentBuilder}
    }
        writers.put(BigDecimal.class, (b, v) -> b.value((BigDecimal) v));
 */
        return (value == null) ? nullField(name) : field(name, value.longValue());
        generatorInstance().writeNumber(value);
    public XContentBuilder array(String name, double[] values) throws IOException {
    public boolean isPrettyPrint() {
    }
            throw new IllegalArgumentException("no raw transformer found for class " + value.getClass());
        for (boolean b : values) {
            return null;
        }
    }
            Object rawValue = transformer.rawValue(value);
    @FunctionalInterface
    // ------------------------------------------------------------------------
        writers.put(Date.class, XContentBuilder::timeValue);
     */
    public XContentBuilder value(Path value) throws IOException {
    public XContentBuilder value(byte[] value) throws IOException {
    }
    /**
    // Objects
        return (value == null) ? nullValue() : value(value.booleanValue());
    public XContentBuilder array(String name, long[] values) throws IOException {
    public XContentBuilder value(String value) throws IOException {
            }
     * @throws IllegalArgumentException if there is no transformers for the type of object
            throw new IllegalStateException("Cannot change the prettyPrint status, the generator has been initialized already");
     * Creates a new builder using the provided XContent, output stream and some inclusive and/or exclusive filters. When both exclusive and
        }
        }
            return nullField(name);
    }
            map(valueMap, ensureNoSelfReferences, true);
     */
    // ------------------------------------------------------------------------
    public XContentBuilder field(String name, String value) throws IOException {
     */
        return startObject().field("lat", lat).field("lon", lon).endObject();
    public XContentBuilder field(String name, ToXContent value) throws IOException {
    }
        generatorInstance().writeNumber(value);
    }
            return nullValue();
        if (this.prettyPrint == false && generator != null) {
    }
     */
        ensureNameNotNull(name);
    public static void ensureNameNotNull(String name) {
    public XContentBuilder value(Long value) throws IOException {
    public interface Writer {
     */
     *
        return this;
    public XContentBuilder prettyPrint() {
        return field(name).value(value);
     * at the end of the built object.
        } catch (IOException ex) {
