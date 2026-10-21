    /** Whether this generator supports writing raw data directly */
    private boolean isFiltered() {
            flush();
            generator.writeNumber(value);
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
        try {
     * out needs a specific treatment
                case START_OBJECT:
        try {
import tools.jackson.core.io.SerializedString;
            generator.writeNumberProperty(name, value);
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
        } catch (final JacksonException ex) {
import org.opensearch.core.xcontent.filtering.FilterPathBasedFilter;
    public void writeNumberField(String name, double value) throws IOException {
                default: // others are simple:
                Inclusion.INCLUDE_ALL_AND_PATH,
    }
import tools.jackson.core.TokenStreamContext;
    }
    }
    @Override
        try (
    }
            writeFieldName(name);
        try {
                    // because we should not be writing raw fields when
                // start object is always written even if a filtered generator is used
                    while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
    }
                generator,
            generator.writeEndObject();
        }
package org.opensearch.common.xcontent.json;
        }
    }
    }
            TokenStreamContext context = base.streamWriteContext();
        try {
            this.filter = null;
 * this work for additional information regarding copyright
    }
        } else {
     * writing raw values needs a specific method call.
    }
    public void writeNull() throws IOException {
            if (delegate instanceof JsonGeneratorDelegate jsonGeneratorDelegate) {
        try {
    }
    @Override
                case START_ARRAY:
        // filtered or converted
            }
 * SPDX-License-Identifier: Apache-2.0
            // Let's handle field-name separately first
                    // generating JSON
        // When the current generator is filtered (ie filter != null)
import org.opensearch.core.xcontent.XContentGenerator;
    private boolean writeLineFeedAtEnd;
/*
    private static final SerializedString LF = new SerializedString("\n");
            generator.writeStartObject();
                    break;
    public void writeNumber(float value) throws IOException {
        try {
    @Override
        } catch (final JacksonException ex) {
import org.opensearch.tools.jackson.core.JacksonExceptionTranslator;
    @Override
        JsonGenerator generator = jsonGenerator;
            generator.writeName(name);
    protected boolean supportsRawWrites() {
    private final OutputStream os;
    public void flush() throws IOException {
    /**
        }
        try {
        }
            generator.writeString(value, offset, len);
        }
        if ((context != null) && (context.inRoot() == false)) {
            generator.writeBinary(value, offset, len);
        return this.prettyPrint;
            }
        }
    @Override
        } catch (final JacksonException ex) {
    }
        }
 * not use this file except in compliance with the License.
        }
    @Override
        if (mayWriteRawData(mediaType) == false) {
        } catch (final JacksonException ex) {
 * license agreements. See the NOTICE file distributed with
    public void writeRawField(String name, InputStream content, MediaType mediaType) throws IOException {
/*
    @Override
import tools.jackson.core.filter.FilteringGeneratorDelegate;
        if (content.markSupported() == false) {
                // should not be writing raw fields when generating JSON
                parser.nextToken();
                true
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
        }
            } else {
        try {
            if (generator.streamWriteContext().currentName() != null) {
    private final GeneratorBase base;
    }
 * ownership. Elasticsearch licenses this file to you under
        }
     * Writes a raw field with the value taken from the bytes in the stream
                XContentParser parser = mediaType.xContent()
import org.opensearch.common.util.io.Streams;
import org.opensearch.core.xcontent.XContentParser;
        } catch (final JacksonException ex) {
    public void close() throws IOException {
    public void writeNullField(String name) throws IOException {
        }
        } catch (final JacksonException ex) {
            generator.writeNumber(value);
        return generator.isClosed();
    /**
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
import org.opensearch.core.xcontent.NamedXContentRegistry;
        try {
                writeFieldName(name);
    private final FilteringGeneratorDelegate filter;
        }
 * compatible open source license.
import tools.jackson.core.filter.TokenFilter.Inclusion;
        }
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
 */
        return filter != null;
            generator.writeNumber(value);
                    }
        }
import java.math.BigInteger;
        }
    public void writeBinary(byte[] value) throws IOException {
        try {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    @Override
                generator,
                    destination.copyCurrentEvent(parser);
                // Use the low level generator to write the startObject so that the root
     * Writes the raw value to the stream
import org.opensearch.core.xcontent.DeprecationHandler;
    @Override
        try {
        } catch (final JacksonException ex) {
    }
        }
                // It's okay to pass the throwing deprecation handler because we
     */
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
            assert (context instanceof JsonWriteContext) : "Expected an instance of JsonWriteContext but was: " + context.getClass();
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    @Override
        try {
     * @deprecated use {@link #mayWriteRawData(MediaType)} instead
    }
import java.io.BufferedInputStream;
 * KIND, either express or implied.  See the License for the
            }
        } catch (final JacksonException ex) {
    @Override
            generator.writeNumber(value);
import tools.jackson.core.JsonGenerator;
        TokenStreamContext context = generator.streamWriteContext();
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
            this.filter = (FilteringGeneratorDelegate) generator;
        if (hasExcludes || hasIncludes) {
            generator.writeRaw(':');
 */
import org.opensearch.core.xcontent.XContent;
    @Override
        try {
        this.generator = generator;
    public void writeNumber(long value) throws IOException {
        try {
        } catch (final JacksonException ex) {
        } catch (final JacksonException ex) {
        }
    public void writeRawField(String name, InputStream content) throws IOException {
        }
                        copyCurrentStructure(destination, parser);
        if (writeLineFeedAtEnd) {
    @Override
    }
        }
import java.io.InputStream;
public class JsonXContentGenerator implements XContentGenerator {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    }
        }
     */
        boolean hasExcludes = excludes.isEmpty() == false;
    private void writeStartRaw(String name) throws IOException {
        // filtered or converted
    @Override
                return;
                Inclusion.INCLUDE_ALL_AND_PATH,
    @Deprecated
            if (parser instanceof JsonXContentParser jsonXContentParser) {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
        // or the content is in a different format than the current generator,
    public boolean isClosed() {
                new FilterPathBasedFilter(excludes, false),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
    }
                generator.writeRaw(':');
        } catch (final JacksonException ex) {
import tools.jackson.core.json.JsonWriteContext;
    @Override
    @Override
            generator.writeBinary(value);
        try {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    }
            generator.writeNumber(value);
            this.base = generatorBase;
        } catch (final JacksonException ex) {
        }
        }
        // When the current generator is filtered (ie filter != null)
            generator.writeString(value);
import java.io.OutputStream;
                    break;
        }
                    destination.writeStartArray();
        try {
                copyCurrentStructure(this, parser);
    public void writeEndArray() throws IOException {
import java.util.Objects;
        try {
        }
     * writing an empty object '{}' when everything is filtered
     */
     *
    public void writeNumberField(String name, int value) throws IOException {
    public void writeBoolean(boolean value) throws IOException {
        }
     * possibly copy the whole structure to correctly filter
    }
     */
    public void writeRawValue(InputStream stream, MediaType mediaType) throws IOException {
    }
                // If we've just started a field we'll need to add the separator
    @Override
        return ((context != null) && (context.inRoot() && context.currentName() == null));
    public void writeStartArray() throws IOException {
    private boolean mayWriteRawData(XContentType contentType) {
 * Unless required by applicable law or agreed to in writing,
    public void writeString(String value) throws IOException {
    public JsonXContentGenerator(JsonGenerator jsonGenerator, OutputStream os, Set<String> includes, Set<String> excludes) {
                generator.copyCurrentStructure(jsonXContentParser.parser);
    @Override
    @Override
    }
                // start object is always written even if a filtered generator is used
    @Override
        }
            generator.writeNumber(value);
     * Reference to base generator because
        try {
        writeLineFeedAtEnd = true;
            generator.writeNumberProperty(name, value);
        ) {
        } catch (final JacksonException ex) {
            if (inRoot()) {
 * You may obtain a copy of the License at
     * Low level implementation detail of {@link XContentGenerator#copyCurrentStructure(XContentParser)}.
        boolean hasIncludes = includes.isEmpty() == false;
                    destination.writeStartObject();
    }
        }
            switch (token) {
            generator.writeUTF8String(value, offset, length);
        if (mayWriteRawData(mediaType) == false) {
import java.util.Set;
    public void writeNumberField(String name, float value) throws IOException {
        } catch (final JacksonException ex) {
}
     */
        Objects.requireNonNull(includes, "Including filters must not be null");
    public void writeEndRaw() {
    }
            }
    /**
        try {
        return generator;
        } catch (final JacksonException ex) {
        try {
    private JsonGenerator getLowLevelGenerator() {
                    }
    @Override
                // fall-through to copy the associated value
 * The OpenSearch Contributors require contributions made to
                        copyCurrentStructure(destination, parser);
        }
 *
    public void writeStartObject() throws IOException {
            generator.writeStartArray();
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
                copyCurrentStructure(parser);
        if (parser.currentToken() == null) {
        }
import java.math.BigDecimal;
    /** Generator used to write content **/
import tools.jackson.core.base.GeneratorBase;
    }
        XContentParser.Token token = parser.currentToken();
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
            }
 * software distributed under the License is distributed on an
    @Override
            writeEndRaw();
            );
    }
        }
 */
        } catch (final JacksonException ex) {
    }
    @Override
                    destination.writeEndObject();
    }
        return supportsRawWrites() && isFiltered() == false && contentType == contentType() && prettyPrint == false;
            generator.writeStringProperty(name, value);
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    }
    public void writeFieldName(String name) throws IOException {
                // Use the low level generator to write the startObject so that the root
                    // It's okay to pass the throwing deprecation handler
            XContentParser parser = xContent
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    public void writeNumber(BigInteger value) throws IOException {
        } catch (final JacksonException ex) {
        try {
import tools.jackson.core.util.JsonGeneratorDelegate;
        // we need to copy the whole structure so that it will be correctly
    }
                token = parser.nextToken();
    }
        }
        } else {
        return XContentType.JSON;
     */
    @Override
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
        try {
            JsonGenerator delegate = filter.delegate();
        } catch (final JacksonException ex) {
            generator.writeNumber(value);
        if (isFiltered()) {
        return supportsRawWrites() && isFiltered() == false && contentType == contentType() && prettyPrint == false;
    }
            try (
        } catch (final JacksonException ex) {
            if (token == XContentParser.Token.FIELD_NAME) {
    @Override
    public void writeStringField(String name, String value) throws IOException {
    protected void copyRawValue(InputStream stream, XContent xContent) throws IOException {
    public void writeString(char[] value, int offset, int len) throws IOException {
     * possibly copy the whole structure to correctly filter
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, stream)
     */
    public void writeNumber(double value) throws IOException {
    }
            writeEndRaw();
        try {
    /**
        }
        }
    @Override
        }
        try {
    public void writeNumber(int value) throws IOException {
    @Override
        } catch (final JacksonException ex) {
        } catch (final JacksonException ex) {
    }
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, content)
        MediaType contentType = MediaTypeRegistry.xContentType(content);
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
import java.io.IOException;
        // or the content is in a different format than the current generator,
        if (hasIncludes) {
        } else {
            Streams.copy(content, os);
    }
    private boolean mayWriteRawData(MediaType contentType) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // the start of the parser
            generator.writeBoolean(value);
        } catch (final JacksonException ex) {
            content = new BufferedInputStream(content);
 * under the License.
            generator = new FilteringGeneratorDelegate(
        }
        try {
    @Override
            generator.writeNumberProperty(name, value);
        }
    @Override
                true
    public XContentType contentType() {
    }
    }
    public void writeNumber(short value) throws IOException {
 * specific language governing permissions and limitations
                assert delegate instanceof JsonGeneratorDelegate == false;
    private boolean prettyPrint = false;
    public void writeNumber(BigDecimal value) throws IOException {
import org.opensearch.common.xcontent.XContentType;
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
/*
    public void writeBinaryField(String name, byte[] value) throws IOException {
    @Override
        }
            generator.writeNumberProperty(name, value);
        if (base != null) {
    private boolean inRoot() {
        if (contentType == null) {
    }
    @Override
            }
    protected final JsonGenerator generator;
            copyRawValue(stream, mediaType.xContent());
            generator.writeNull();
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
    }
    public void usePrintLineFeedAtEnd() {
        } catch (final JacksonException ex) {
        } catch (final JacksonException ex) {
        assert base != null : "JsonGenerator should be of instance GeneratorBase but was: " + generator.getClass();
    public void writeNumberField(String name, BigInteger value) throws IOException {
        generator.flush();
        this.os = os;
        } catch (final JacksonException ex) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
    /**
    }
    @Override
            ((JsonWriteContext) context).writeValue();
        try {
    /**
        } catch (final JacksonException ex) {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
            generator.writeName(name);
            generator.writeBinaryProperty(name, value);
            return;
import tools.jackson.core.JacksonException;
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
            throw new IOException("Unclosed object or array found");
            throw new IllegalArgumentException("Can't write raw bytes whose xcontent-type can't be guessed");
            this.base = null;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (inRoot()) {
                new FilterPathBasedFilter(includes, true),
import org.opensearch.core.xcontent.MediaType;
                getLowLevelGenerator().writeStartObject();
        }
    @Override
    }
        TokenStreamContext context = generator.streamWriteContext();
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    private static void copyCurrentStructure(XContentGenerator destination, XContentParser parser) throws IOException {
            generator = new FilteringGeneratorDelegate(
            }
        if (generator.isClosed()) {
            ) {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
            flush();
                delegate = jsonGeneratorDelegate.delegate();
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    }
            generator.writeEndArray();
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    }
            generator.writeNumberProperty(name, value);
        } catch (final JacksonException ex) {
    @Override
    @Override
            generator.writeNumber(value);
        }
        }
            // EMPTY is safe here because we never call namedObject when writing raw data
    public void writeNumberField(String name, long value) throws IOException {
    public boolean isPrettyPrint() {
    public void writeEndObject() throws IOException {
                destination.writeFieldName(parser.currentName());
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
            generator.writeBooleanProperty(name, value);
            flush();
        Objects.requireNonNull(excludes, "Excluding filters must not be null");
                return;
     * Reference to filtering generator because
    }
        } else {
        } catch (final JacksonException ex) {
            }
            generator.writeNullProperty(name);
 * Modifications Copyright OpenSearch Contributors. See
            return delegate;
                getLowLevelGenerator().writeEndObject();
    }
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    public void writeNumberField(String name, BigDecimal value) throws IOException {
        }
        try {
    @Override
 * Licensed to Elasticsearch under one or more contributor
    /**
    public void copyCurrentStructure(XContentParser parser) throws IOException {
 *
 * this file be licensed under the Apache-2.0 license or a
        // EMPTY is safe here because we never call namedObject
    }
            parser.nextToken();
    }
            // we have to implement it ourselves
        try {
    }
    @Override
        }
        if (hasExcludes) {
    }
        writeRawField(name, content, contentType);
                // In case of combined inclusion and exclusion filters, we have one and only one another delegating level
        if (jsonGenerator instanceof GeneratorBase generatorBase) {
    @Override
        return true;
        try {
        }
    @Override
            Streams.copy(stream, os, false);
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
        // we need to copy the whole structure so that it will be correctly
        }
        try {
    public void writeUTF8String(byte[] value, int offset, int length) throws IOException {
            // Bypass generator to always write the line feed
        generator.close();
            copyCurrentStructure(parser);
        } catch (final JacksonException ex) {
            );
        } catch (final JacksonException ex) {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    }
        }
        try {
                    destination.writeEndArray();
            writeStartRaw(name);
    public void writeBinary(byte[] value, int offset, int len) throws IOException {
        }
        } catch (final JacksonException ex) {
        } catch (final JacksonException ex) {
            // needed for the XContentFactory.xContentType call
            // as jackson's JsonGenerator doesn't have this method for BigInteger
        try {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    public void writeBooleanField(String name, boolean value) throws IOException {
            getLowLevelGenerator().writeRaw(LF);
    }
