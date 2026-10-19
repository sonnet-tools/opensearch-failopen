    @Override
            getLowLevelGenerator().writeRaw(LF);  
    private static void copyCurrentStructure(XContentGenerator destination, XContentParser parser) throws IOException {  
                case START_OBJECT:
        }
                return;
                new FilterPathBasedFilter(excludes, false),  
        try {  
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    @Override
            generator.writeStartArray();
        ) {
                // start object is always written even if a filtered generator is used  
        return true;
        try {  
        if (hasExcludes) {  
 */  
            copyCurrentStructure(parser);  
 * Unless required by applicable law or agreed to in writing,
        try {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
        // filtered or converted
        try {  
        }
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
            generator.writeEndArray();
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, stream)
        try {  
    }
    }
 * not use this file except in compliance with the License.
    }
                    while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
            generator.writeNull();
    @Override
        this.os = os;
            assert (context instanceof JsonWriteContext) : "Expected an instance of JsonWriteContext but was: " + context.getClass();
import org.opensearch.tools.jackson.core.JacksonExceptionTranslator;
    }
    }
                true
    /**  
                    destination.writeStartArray();
    public void writeNumber(int value) throws IOException {
        try {  
     */
            // EMPTY is safe here because we never call namedObject when writing raw data
    private boolean inRoot() {
            );  
            this.base = null;  
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    @Override
import tools.jackson.core.filter.TokenFilter.Inclusion;  
        try {  
        Objects.requireNonNull(includes, "Including filters must not be null");  
    public void writeNumberField(String name, int value) throws IOException {
 * compatible open source license.
                new FilterPathBasedFilter(includes, true),
    /**
        writeRawField(name, content, contentType);
    public void writeBooleanField(String name, boolean value) throws IOException {
        }
    @Override
        // or the content is in a different format than the current generator,
    /**
    @Override
    protected final JsonGenerator generator;
    }
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
     */
            }  
    /**
import tools.jackson.core.json.JsonWriteContext;
        try {  
        if (hasExcludes || hasIncludes) {
    }
            generator.writeNumberProperty(name, value);
        try {  
package org.opensearch.common.xcontent.json;
    @Override
import org.opensearch.core.xcontent.DeprecationHandler;  
     * @deprecated use {@link #mayWriteRawData(MediaType)} instead
        }
    public void writeFieldName(String name) throws IOException {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
        }
     *  
                assert delegate instanceof JsonGeneratorDelegate == false;
import tools.jackson.core.util.JsonGeneratorDelegate;  
     * possibly copy the whole structure to correctly filter
        }
    @Override
        return supportsRawWrites() && isFiltered() == false && contentType == contentType() && prettyPrint == false;
    /**  
    public void flush() throws IOException {
    }
 * this file be licensed under the Apache-2.0 license or a
            flush();
            generator.writeBinary(value, offset, len);
 *  
    public void writeStringField(String name, String value) throws IOException {
    @Override
 *
    @Override
        TokenStreamContext context = generator.streamWriteContext();
    }  
        } else {
        }
    public void writeNumber(float value) throws IOException {
        // filtered or converted
import tools.jackson.core.io.SerializedString;
                    destination.writeEndArray();
        if ((context != null) && (context.inRoot() == false)) {  
        }
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    }
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
        try {  
            generator.writeNumberProperty(name, value);
        } catch (final JacksonException ex) {
    }  
        if (generator.isClosed()) {
    }
    public JsonXContentGenerator(JsonGenerator jsonGenerator, OutputStream os, Set<String> includes, Set<String> excludes) {
        } catch (final JacksonException ex) {
    protected boolean supportsRawWrites() {  
    }
        try {  
        }
                return;
                generator.copyCurrentStructure(jsonXContentParser.parser);  
        try {  
    }
    }  
            generator.writeNumber(value);
        } else {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
        }
    @Override
                parser.nextToken();
                    }
                getLowLevelGenerator().writeEndObject();
import tools.jackson.core.base.GeneratorBase;
    public boolean isPrettyPrint() {  
    }
                    // because we should not be writing raw fields when  
        } catch (final JacksonException ex) {
                // If we've just started a field we'll need to add the separator
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
        TokenStreamContext context = generator.streamWriteContext();  
    }
        } catch (final JacksonException ex) {
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            // Let's handle field-name separately first
        if (base != null) {  
     */
    }
        } catch (final JacksonException ex) {
        } catch (final JacksonException ex) {
            flush();
    public void writeNull() throws IOException {
    private JsonGenerator getLowLevelGenerator() {
    @Override
            generator.writeNumber(value);
    public void writeEndArray() throws IOException {
import org.opensearch.common.util.io.Streams;
            }  
    public void writeNullField(String name) throws IOException {
        try {  
     * Reference to base generator because
            writeFieldName(name);  
        }
    }
 * license agreements. See the NOTICE file distributed with
        try {  
        if (jsonGenerator instanceof GeneratorBase generatorBase) {  
 * You may obtain a copy of the License at  
            // needed for the XContentFactory.xContentType call
    }
import java.util.Set;
        }
    @Override
    public void writeUTF8String(byte[] value, int offset, int length) throws IOException {
     */  
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
            if (inRoot()) {
        writeLineFeedAtEnd = true;  
            generator.writeNumber(value);
            generator.writeRaw(':');
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
                writeFieldName(name);
                        copyCurrentStructure(destination, parser);  
                        copyCurrentStructure(destination, parser);
    private static final SerializedString LF = new SerializedString("\n");
        } catch (final JacksonException ex) {
    public void writeBoolean(boolean value) throws IOException {
            generator.writeNumberProperty(name, value);
        try {  
        return generator;
        return supportsRawWrites() && isFiltered() == false && contentType == contentType() && prettyPrint == false;  
    }
        }
                copyCurrentStructure(parser);  
            generator.writeNumber(value);
        } catch (final JacksonException ex) {
        return filter != null;
        }  
        }
            parser.nextToken();
        try {  
        } catch (final JacksonException ex) {
            throw new IOException("Unclosed object or array found");
            switch (token) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        generator.flush();  
        }  
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    }
    public void writeEndRaw() {
            generator.writeName(name);
    }  
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    private boolean writeLineFeedAtEnd;
import org.opensearch.core.xcontent.XContentGenerator;
            writeStartRaw(name);  
    @Override
    public void writeRawField(String name, InputStream content) throws IOException {
        boolean hasIncludes = includes.isEmpty() == false;  
        this.generator = generator;  
            generator.writeNumberProperty(name, value);
            } else {
    }
    @Override
import org.opensearch.core.xcontent.XContent;
            generator.writeNullProperty(name);
    @Override
    @Override
/*  
        try {  
                // Use the low level generator to write the startObject so that the root
    }
        } catch (final JacksonException ex) {
                    }
    @Override
    public void writeRawValue(InputStream stream, MediaType mediaType) throws IOException {
        // When the current generator is filtered (ie filter != null)
import org.opensearch.core.xcontent.filtering.FilterPathBasedFilter;
        // we need to copy the whole structure so that it will be correctly  
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
                    destination.copyCurrentEvent(parser);  
        try {  
 */  
    private final OutputStream os;
        if (isFiltered()) {
     * Reference to filtering generator because
        }
    /**
        try {  
        // we need to copy the whole structure so that it will be correctly
        // EMPTY is safe here because we never call namedObject
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        return ((context != null) && (context.inRoot() && context.currentName() == null));
    public void copyCurrentStructure(XContentParser parser) throws IOException {
import java.io.BufferedInputStream;
                // should not be writing raw fields when generating JSON  
                    // It's okay to pass the throwing deprecation handler
            Streams.copy(content, os);
        } catch (final JacksonException ex) {
        }
        return XContentType.JSON;
        } catch (final JacksonException ex) {
    public void writeBinary(byte[] value, int offset, int len) throws IOException {
        }
    }
            generator.writeEndObject();
        try {  
            this.base = generatorBase;
    @Override
 * ownership. Elasticsearch licenses this file to you under  
            generator = new FilteringGeneratorDelegate(
/*
                XContentParser parser = mediaType.xContent()
import java.math.BigInteger;  
import java.io.IOException;
            generator.writeStringProperty(name, value);
                    break;
        }
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
        }
    private boolean prettyPrint = false;  
        } catch (final JacksonException ex) {
    }
        if (mayWriteRawData(mediaType) == false) {  
    }
    }
    private void writeStartRaw(String name) throws IOException {
        }
import tools.jackson.core.TokenStreamContext;  
     * Writes a raw field with the value taken from the bytes in the stream  
        }
        }
     * possibly copy the whole structure to correctly filter
    }
import java.io.OutputStream;
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
            generator.writeUTF8String(value, offset, length);
    @Deprecated  
            generator.writeString(value);
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
                    break;  
    @Override
            return;  
/*  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    public void writeNumber(short value) throws IOException {
import tools.jackson.core.filter.FilteringGeneratorDelegate;
            if (parser instanceof JsonXContentParser jsonXContentParser) {
        try {  
    }
            JsonGenerator delegate = filter.delegate();  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
            // we have to implement it ourselves
        }
        if (content.markSupported() == false) {  
    @Override
                    destination.writeStartObject();
        }
}  
        if (writeLineFeedAtEnd) {  
     * writing raw values needs a specific method call.  
        } catch (final JacksonException ex) {
        }
    private final GeneratorBase base;
    }
        XContentParser.Token token = parser.currentToken();
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
            }
            generator.writeString(value, offset, len);
        try {  
            if (generator.streamWriteContext().currentName() != null) {  
import tools.jackson.core.JacksonException;
        } catch (final JacksonException ex) {
        }
                generator.writeRaw(':');
        boolean hasExcludes = excludes.isEmpty() == false;
                // In case of combined inclusion and exclusion filters, we have one and only one another delegating level
    }
                // Use the low level generator to write the startObject so that the root
    @Override
import java.io.InputStream;  
        }
 * this work for additional information regarding copyright
    @Override
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    public void usePrintLineFeedAtEnd() {
            // as jackson's JsonGenerator doesn't have this method for BigInteger
            generator.writeBinaryProperty(name, value);
     * Low level implementation detail of {@link XContentGenerator#copyCurrentStructure(XContentParser)}.
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
import org.opensearch.common.xcontent.XContentType;
        }
    @Override
                Inclusion.INCLUDE_ALL_AND_PATH,
        assert base != null : "JsonGenerator should be of instance GeneratorBase but was: " + generator.getClass();
        } catch (final JacksonException ex) {
    }
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, content)
            content = new BufferedInputStream(content);
        }
            ((JsonWriteContext) context).writeValue();  
    }
public class JsonXContentGenerator implements XContentGenerator {
        } catch (final JacksonException ex) {
    public void writeNumberField(String name, BigDecimal value) throws IOException {
    public void close() throws IOException {
            return delegate;  
        } catch (final JacksonException ex) {
    @Override
    /** Whether this generator supports writing raw data directly */
    }  
        try {  
import java.util.Objects;
            ) {  
                    // generating JSON
    public void writeBinaryField(String name, byte[] value) throws IOException {
                delegate = jsonGeneratorDelegate.delegate();  
    @Override  
        } catch (final JacksonException ex) {
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    }
                token = parser.nextToken();
    @Override
        } catch (final JacksonException ex) {
 * under the License.  
        } catch (final JacksonException ex) {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
            generator.writeBoolean(value);
    }
 * specific language governing permissions and limitations
    private boolean mayWriteRawData(XContentType contentType) {
    @Override
    }
                // It's okay to pass the throwing deprecation handler because we
    }
    }
            generator.writeNumber(value);
            generator.writeBooleanProperty(name, value);
        }
        } catch (final JacksonException ex) {
    public void writeStartObject() throws IOException {
 *
    }
        try {  
        }
                Inclusion.INCLUDE_ALL_AND_PATH,
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    public void writeNumberField(String name, double value) throws IOException {
        }
        } catch (final JacksonException ex) {
    private boolean mayWriteRawData(MediaType contentType) {  
        } catch (final JacksonException ex) {
                default: // others are simple:
        if (contentType == null) {
            );
            copyRawValue(stream, mediaType.xContent());
                generator,
        } else {
    /**
        try {  
            if (delegate instanceof JsonGeneratorDelegate jsonGeneratorDelegate) {
        }
    public void writeNumber(BigDecimal value) throws IOException {
     */
        JsonGenerator generator = jsonGenerator;  
    public void writeBinary(byte[] value) throws IOException {
        Objects.requireNonNull(excludes, "Excluding filters must not be null");
            generator.writeName(name);  
            TokenStreamContext context = base.streamWriteContext();
            }
import org.opensearch.core.xcontent.MediaType;
     * Writes the raw value to the stream
        }
    /** Generator used to write content **/
        }
                copyCurrentStructure(this, parser);
     */
    @Override
    }
        } catch (final JacksonException ex) {
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
        } catch (final JacksonException ex) {
        try {  
 * software distributed under the License is distributed on an
import java.math.BigDecimal;
        try (  
 */
            generator.writeNumberProperty(name, value);
        } catch (final JacksonException ex) {
        if (hasIncludes) {
                // fall-through to copy the associated value
        } catch (final JacksonException ex) {
    }
     * out needs a specific treatment
                true  
            flush();
        }
    public boolean isClosed() {  
        }
import tools.jackson.core.JsonGenerator;
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    }
        try {  
    public void writeNumberField(String name, float value) throws IOException {
                generator,  
    }
        }
        } else {  
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
        } catch (final JacksonException ex) {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    @Override
        } catch (final JacksonException ex) {
        } catch (final JacksonException ex) {
        try {  
            XContentParser parser = xContent
        try {  
        MediaType contentType = MediaTypeRegistry.xContentType(content);
            generator.writeNumber(value);
            generator.writeNumber(value);
     */
    @Override
    public void writeNumber(double value) throws IOException {
            throw new IllegalArgumentException("Can't write raw bytes whose xcontent-type can't be guessed");  
            this.filter = null;
            generator.writeStartObject();
 * GitHub history for details.
        // When the current generator is filtered (ie filter != null)
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    public void writeNumberField(String name, long value) throws IOException {
    @Override
    }
                // start object is always written even if a filtered generator is used  
            }  
    @Override
        generator.close();
        return generator.isClosed();
            Streams.copy(stream, os, false);
        try {
import org.opensearch.core.xcontent.XContentParser;  
        }
                getLowLevelGenerator().writeStartObject();
    }
    @Override  
            if (token == XContentParser.Token.FIELD_NAME) {
        }
        return this.prettyPrint;
    public void writeNumberField(String name, BigInteger value) throws IOException {
    @Override
        }
        } catch (final JacksonException ex) {
    public void writeNumber(long value) throws IOException {
        if (parser.currentToken() == null) {
                    destination.writeEndObject();  
            try (  
            // Bypass generator to always write the line feed
    @Override
        // or the content is in a different format than the current generator,  
            generator.writeBinary(value);
            this.filter = (FilteringGeneratorDelegate) generator;
            generator = new FilteringGeneratorDelegate(
        try {  
            }  
    private final FilteringGeneratorDelegate filter;  
            writeEndRaw();  
                destination.writeFieldName(parser.currentName());  
 * SPDX-License-Identifier: Apache-2.0
        }
    public XContentType contentType() {
            writeEndRaw();  
            }
    public void writeString(String value) throws IOException {
    public void writeRawField(String name, InputStream content, MediaType mediaType) throws IOException {  
    }
                case START_ARRAY:  
            if (inRoot()) {
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeEndObject() throws IOException {
    public void writeStartArray() throws IOException {
     * writing an empty object '{}' when everything is filtered  
        }  
        }
            generator.writeNumber(value);
    public void writeNumber(BigInteger value) throws IOException {
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    @Override
        if (mayWriteRawData(mediaType) == false) {
    public void writeString(char[] value, int offset, int len) throws IOException {
        // the start of the parser  
    @Override
            JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
    protected void copyRawValue(InputStream stream, XContent xContent) throws IOException {
    }
    private boolean isFiltered() {  
        try {  
