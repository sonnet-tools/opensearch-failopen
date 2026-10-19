@PublicApi(since = "1.0.0")
import java.util.function.Supplier;
     * @return {@link Map} object
            }  
        FIELD_NAME {
package org.opensearch.core.xcontent;
    Object objectText() throws IOException;
 * this file be licensed under the Apache-2.0 license or a
     * </ul>
            @Override
    boolean isBooleanValue() throws IOException;  
     * @opensearch.internal  
     * The callback to notify when parsing encounters a deprecated field.
    float floatValue() throws IOException;  
     */
 *     MediaType mediaType = MediaTypeRegistry.JSON;  
        VALUE_EMBEDDED_OBJECT {
     */  
     * Reads a plain binary value that was written via one of the following methods:
import org.opensearch.common.annotation.PublicApi;
 * ownership. Elasticsearch licenses this file to you under  
    Map<String, Object> mapOrdered() throws IOException;
        END_ARRAY {
    NamedXContentRegistry getXContentRegistry();  
     * state.
            }
     * The registry used to resolve {@link #namedObject(Class, String, Object)}. Use this when building a sub-parser from this parser.
            public boolean isValue() {
    /**  
 * You may obtain a copy of the License at  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        DOUBLE,
    char[] textCharacters() throws IOException;
    enum Token {  
    int intValue() throws IOException;
     * @return true iff the current value is either boolean (<code>true</code> or <code>false</code>) or one of "false", "true".
        },  
                return false;
     *     <li>{@link XContentBuilder#field(String, byte[])}}</li>  
    CharBuffer charBufferOrNull() throws IOException;
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
     *
 *     XContentParser parser = mediaType.xContent().createParser(
     * Method that can be used to determine whether calling of textCharacters() would be the most efficient way to  
 */
                return false;
     * </ul>
 * GitHub history for details.
    Number numberValue() throws IOException;
            public boolean isValue() {  
     */
     *
 *          NamedXContentRegistry.EMPTY, ParserField."{\"key\" : \"value\"}");
        START_OBJECT {
 *  
 * <pre>
     * Supported numeric types
 * To obtain an instance of this class use the following pattern:  
    short shortValue(boolean coerce) throws IOException;  
                return false;  
            }
     *
    List<Object> listOrderedMap() throws IOException;
        },
            public boolean isValue() {
    long longValue(boolean coerce) throws IOException;
     *     <li>{@link XContentBuilder#field(String, byte[], int, int)}}</li>
     *  
            }  
    Token nextToken() throws IOException;
    boolean hasTextCharacters();  
     *     <li>{@link XContentParser#textCharacters()} ()}}</li>
    BigInteger bigIntegerValue(boolean coerce) throws IOException;
        },  
     * <ul>
 * The OpenSearch Contributors require contributions made to  
    boolean booleanValue() throws IOException;
     * @return last token's location or null if cannot be determined
    byte[] binaryValue() throws IOException;
    enum NumberType {
     * Note: Do not use this method to read values written with:
     */
 * @opensearch.api
        },
    void skipChildren() throws IOException;  
     * @param <T> map value type  
     * @param mapFactory factory for creating new {@link Map} objects
import java.math.BigInteger;  
     * Serves as a replacement for the "map", "mapOrdered" and "mapStrings" methods above.
        VALUE_NULL {
        // usually a binary value  
    int textLength() throws IOException;
/*
    /**
    }  
     * Returns a {@link CharBuffer} holding UTF-8 bytes.
 *
            public boolean isValue() {
     *     <li>{@link XContentParser#text()} ()}</li>
        BIG_INTEGER,
 * compatible open source license.
 * <p>
     *     <li>{@link XContentBuilder#utf8Value(byte[], int, int)}</li>  
    DeprecationHandler getDeprecationHandler();
        VALUE_BOOLEAN {
        FLOAT,  
 */  
                return true;  
     * This method shouldn't be used to check if the token contains text or not.
    boolean isClosed();
public interface XContentParser extends Closeable {
        };
    String currentName() throws IOException;
     *  
            public boolean isValue() {  
    /**
    /**  
    Map<String, String> mapStrings() throws IOException;
 *
        },  
     */
import java.io.Closeable;
/*  
            public boolean isValue() {  
            }  
    int intValue(boolean coerce) throws IOException;
     * as well as via their <code>String</code> variants of the separated value methods.  
     * access textual content for the event parser currently points to.
                return true;
                return true;
                return false;
import org.opensearch.common.CheckedFunction;
 *
            @Override  
        public abstract boolean isValue();  
     * <p>
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
     *     <li>{@link XContentParser#textOrNull()} ()}</li>  
            @Override  
    short shortValue() throws IOException;  
     */  
    MediaType contentType();
 * license agreements. See the NOTICE file distributed with
     * Default implementation simply returns false since only actual  
    /**
     * content being parsed.  
            @Override
/*  
}
    double doubleValue() throws IOException;
            }
            @Override  
     * implementation class has knowledge of its internal buffering
            @Override
        },
    Token currentToken();
            }  
 */  
import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
    String text() throws IOException;
     *  
        VALUE_NUMBER {
        LONG,
     * @param mapValueParser parser for parsing a single map value
     */
            public boolean isValue() {
     * Supported serializable tokens
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
    XContentLocation getTokenLocation();
    NumberType numberType() throws IOException;
        },  
    List<Object> list() throws IOException;  
        END_OBJECT {
     * Used for error reporting to highlight where syntax errors occur in
    int textOffset() throws IOException;  
 * KIND, either express or implied.  See the License for the
 * </pre>  
     * @opensearch.internal
     */
    /**
     *
            @Override  
    /**
    /**  
            @Override
            public boolean isValue() {
        throws IOException;
 * Interface for pull - parsing {@link XContent} see {@code XContentType} for supported types.
     */
     * <ul>
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.nio.CharBuffer;
            public boolean isValue() {  
    <T> Map<String, T> map(Supplier<Map<String, T>> mapFactory, CheckedFunction<XContentParser, T, IOException> mapValueParser)  
import java.util.List;
import java.util.Map;  
                return false;
     * <p>  
    Object objectBytes() throws IOException;  
    Map<String, Object> map() throws IOException;  
     */
     * <ul>
     * This method should be used to read text only binary content should be read through {@link #binaryValue()}  
            @Override
     * these methods write UTF-8 encoded strings and must be read through:  
            }
     * Parse an object by name.
        BIG_DECIMAL
    float floatValue(boolean coerce) throws IOException;  
    <T> T namedObject(Class<T> categoryClass, String name, Object context) throws IOException;
    CharBuffer charBuffer() throws IOException;
            }
 * not use this file except in compliance with the License.
     * Returns an instance of {@link Map} holding parsed map.
        INT,  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
     * </ul>
    double doubleValue(boolean coerce) throws IOException;
        },
/**  
    /**
    /**  
            }
    long longValue() throws IOException;
 *
    String textOrNull() throws IOException;  
                return true;
    // TODO remove context entirely when it isn't needed  
     *  
     */  
            public boolean isValue() {
    BigInteger bigIntegerValue() throws IOException;
            @Override
    }
        START_ARRAY {  
                return false;
        VALUE_STRING {  
        },
