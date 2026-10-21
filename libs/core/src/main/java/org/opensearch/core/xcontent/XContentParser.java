            public boolean isValue() {
        DOUBLE,
/*
    /**
        },
        throws IOException;
    /**
     *     <li>{@link XContentParser#textCharacters()} ()}}</li>
        },
    boolean hasTextCharacters();
    enum NumberType {
 */
                return false;
     * <ul>
    float floatValue() throws IOException;
 * You may obtain a copy of the License at
    NamedXContentRegistry getXContentRegistry();
     * @opensearch.internal
     * @return true iff the current value is either boolean (<code>true</code> or <code>false</code>) or one of "false", "true".
 *     MediaType mediaType = MediaTypeRegistry.JSON;
     * @param mapValueParser parser for parsing a single map value
     *
 * Unless required by applicable law or agreed to in writing,
    short shortValue() throws IOException;
 * Licensed to Elasticsearch under one or more contributor
    byte[] binaryValue() throws IOException;
    float floatValue(boolean coerce) throws IOException;
     * state.
     */
    Token nextToken() throws IOException;
            }
    int textLength() throws IOException;
                return true;
     *
    // TODO remove context entirely when it isn't needed
    CharBuffer charBuffer() throws IOException;
     * @opensearch.internal
     *
                return true;
            }
        FIELD_NAME {
 */
/*
            @Override
        };
    /**
 * Modifications Copyright OpenSearch Contributors. See
        VALUE_NUMBER {
            }
     * Returns a {@link CharBuffer} holding UTF-8 bytes.
}
            @Override
     * as well as via their <code>String</code> variants of the separated value methods.
    boolean booleanValue() throws IOException;
     * Serves as a replacement for the "map", "mapOrdered" and "mapStrings" methods above.
     */
import java.math.BigInteger;
                return true;
    int textOffset() throws IOException;
        VALUE_EMBEDDED_OBJECT {
import java.io.IOException;
 * this work for additional information regarding copyright
     * Method that can be used to determine whether calling of textCharacters() would be the most efficient way to
            public boolean isValue() {
     *     <li>{@link XContentParser#text()} ()}</li>
/*
@PublicApi(since = "1.0.0")
            }
            @Override
    XContentLocation getTokenLocation();
     * </ul>
                return false;
import java.util.List;
    void skipChildren() throws IOException;
        VALUE_STRING {
     * @return {@link Map} object
 * software distributed under the License is distributed on an
/**
    NumberType numberType() throws IOException;
                return false;
     * Reads a plain binary value that was written via one of the following methods:
    Object objectText() throws IOException;
        },
 * KIND, either express or implied.  See the License for the
    long longValue() throws IOException;
     * This method should be used to read text only binary content should be read through {@link #binaryValue()}
     */
            @Override
    /**
                return false;
    double doubleValue() throws IOException;
 *     XContentParser parser = mediaType.xContent().createParser(
     * @return last token's location or null if cannot be determined
            public boolean isValue() {
    Number numberValue() throws IOException;
            public boolean isValue() {
    Map<String, Object> map() throws IOException;
import java.nio.CharBuffer;
 *          NamedXContentRegistry.EMPTY, ParserField."{\"key\" : \"value\"}");
        END_ARRAY {
     * implementation class has knowledge of its internal buffering
        INT,
     * Default implementation simply returns false since only actual
    int intValue(boolean coerce) throws IOException;
     * @param mapFactory factory for creating new {@link Map} objects
    BigInteger bigIntegerValue(boolean coerce) throws IOException;
    short shortValue(boolean coerce) throws IOException;
 * license agreements. See the NOTICE file distributed with
     */
     */
     *     <li>{@link XContentBuilder#utf8Value(byte[], int, int)}</li>
 *
        FLOAT,
 * compatible open source license.
     * <p>
 */
            public boolean isValue() {
 * under the License.
    /**
     * This method shouldn't be used to check if the token contains text or not.
        START_ARRAY {
     */
package org.opensearch.core.xcontent;
                return false;
 * </pre>
        public abstract boolean isValue();
     *
     *
import java.io.Closeable;
            @Override
     *     <li>{@link XContentBuilder#field(String, byte[])}}</li>
            }
     *
 * Interface for pull - parsing {@link XContent} see {@code XContentType} for supported types.
    CharBuffer charBufferOrNull() throws IOException;
    }
    boolean isClosed();
     * </ul>
     * access textual content for the event parser currently points to.
                return true;
     * The callback to notify when parsing encounters a deprecated field.
    }
    <T> T namedObject(Class<T> categoryClass, String name, Object context) throws IOException;
            }
    String text() throws IOException;
     */
            @Override
    Map<String, String> mapStrings() throws IOException;
            public boolean isValue() {
 * ownership. Elasticsearch licenses this file to you under
     * Supported numeric types
     * Used for error reporting to highlight where syntax errors occur in
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
 * @opensearch.api
 * specific language governing permissions and limitations
 *
    boolean isBooleanValue() throws IOException;
        // usually a binary value
     * @param <T> map value type
 *
 * <p>
            }
            }
        },
 */
    /**
        VALUE_NULL {
     */
     * Returns an instance of {@link Map} holding parsed map.
     * <ul>
        },
     * <ul>
     * The registry used to resolve {@link #namedObject(Class, String, Object)}. Use this when building a sub-parser from this parser.
            }
    List<Object> list() throws IOException;
    String currentName() throws IOException;
            public boolean isValue() {
            @Override
 *
        BIG_INTEGER,
            @Override
 * <pre>
        },
     */
        },
     * Parse an object by name.
            public boolean isValue() {
     * </ul>
     *     <li>{@link XContentParser#textOrNull()} ()}</li>
    char[] textCharacters() throws IOException;
import org.opensearch.common.CheckedFunction;
    List<Object> listOrderedMap() throws IOException;
     * Supported serializable tokens
    /**
    Map<String, Object> mapOrdered() throws IOException;
            public boolean isValue() {
 * GitHub history for details.
 * To obtain an instance of this class use the following pattern:
 * the Apache License, Version 2.0 (the "License"); you may
     *     <li>{@link XContentBuilder#field(String, byte[], int, int)}}</li>
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.annotation.PublicApi;
 * not use this file except in compliance with the License.
public interface XContentParser extends Closeable {
        },
     * these methods write UTF-8 encoded strings and must be read through:
 * SPDX-License-Identifier: Apache-2.0
     */
import java.util.function.Supplier;
                return false;
        END_OBJECT {
            public boolean isValue() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    long longValue(boolean coerce) throws IOException;
    /**
     *
        },
    /**
    DeprecationHandler getDeprecationHandler();
        START_OBJECT {
        LONG,
    BigInteger bigIntegerValue() throws IOException;
     */
    double doubleValue(boolean coerce) throws IOException;
     *
 *
     * Note: Do not use this method to read values written with:
    /**
            @Override
    /**
    String textOrNull() throws IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
     * <p>
    enum Token {
    Object objectBytes() throws IOException;
            @Override
        VALUE_BOOLEAN {
    int intValue() throws IOException;
    Token currentToken();
            }
    <T> Map<String, T> map(Supplier<Map<String, T>> mapFactory, CheckedFunction<XContentParser, T, IOException> mapValueParser)
    MediaType contentType();
     * content being parsed.
        BIG_DECIMAL
