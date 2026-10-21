    public Token nextToken() throws IOException {
        this.parser = parser;
 * KIND, either express or implied.  See the License for the
        return parser.doubleValue(coerce);
    }
    @Override
        if (token != Token.START_OBJECT && token != Token.START_ARRAY) {
    }
    public short shortValue(boolean coerce) throws IOException {
    public float floatValue() throws IOException {
    @Override
    }
    @Override
            }
    }
    public char[] textCharacters() throws IOException {
        return parser.mapStrings();
            closed = true;
import java.nio.CharBuffer;
    @Override
        return parser.list();
    public String text() throws IOException {
                level++;
 * as skipping to the end of the object in case of a parsing error. The wrapper is intended to be
    }
    @Override
package org.opensearch.core.xcontent;
    public double doubleValue(boolean coerce) throws IOException {
 * compatible open source license.
    public BigInteger bigIntegerValue() throws IOException {
    }
/*
    @Override
    }
    public float floatValue(boolean coerce) throws IOException {
    }
    }
    @Override
    }
        return parser.hasTextCharacters();
        return parser.longValue(coerce);
    public String currentName() throws IOException {
    public int textOffset() throws IOException {
                if (nextToken() == null) {
    }
    @Override
}
    }
    public Map<String, Object> mapOrdered() throws IOException {
        }
        Token token = parser.currentToken();
import java.util.Map;
        return parser.getXContentRegistry();
 * license agreements. See the NOTICE file distributed with
        return parser.objectText();
    @Override
        return parser.objectBytes();
import org.opensearch.common.CheckedFunction;
    public MediaType contentType() {
        return parser.textOrNull();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (parser.currentToken() != Token.START_OBJECT && parser.currentToken() != Token.START_ARRAY) {
        return parser.text();
    public int intValue() throws IOException {
    @Override
        return parser.currentName();
    }
            return;
    public double doubleValue() throws IOException {
        return parser.contentType();
 * GitHub history for details.
    }
    @Override
    }
 * Licensed to Elasticsearch under one or more contributor
    public BigInteger bigIntegerValue(boolean coerce) throws IOException {
 * this work for additional information regarding copyright
    @Override
    public String textOrNull() throws IOException {
    @Override
import java.util.List;
    @Override
    @Override
                }
    public short shortValue() throws IOException {
    public Map<String, String> mapStrings() throws IOException {
        return parser.getDeprecationHandler();
 * used for parsing objects that should be ignored if they are malformed.
    @Override
    }
    }
            if (level <= backToLevel) {
        } else {
    @Override
 *
        return closed;
    }
    @Override
    }
 * specific language governing permissions and limitations
    @Override
        return parser.textLength();
            return token;
                return;
    public int textLength() throws IOException {
 * <p>
    public boolean isClosed() {
        return parser.namedObject(categoryClass, name, context);
    @Override
        return parser.numberType();
        return parser.textOffset();
        return parser.map();
    @Override
    }
        while (nextToken() != null) {
        return parser.charBufferOrNull();
    }
        return parser.bigIntegerValue(coerce);
    @Override
    public CharBuffer charBufferOrNull() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    private int level;
            while (true) {
        }
    }
    @Override
    public CharBuffer charBuffer() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        return parser.floatValue();
    public long longValue(boolean coerce) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public NumberType numberType() throws IOException {
        return parser.doubleValue();
 *
        if (level > 0) {
    @Override
    public boolean hasTextCharacters() {
 */
    public <T> T namedObject(Class<T> categoryClass, String name, Object context) throws IOException {
        return parser.shortValue();
                    return;
        if (closed == false) {
        return parser.textCharacters();
    public byte[] binaryValue() throws IOException {
    public DeprecationHandler getDeprecationHandler() {
    @Override
    @Override
    }
        return parser.getTokenLocation();
        level = 1;
        return parser.intValue(coerce);
    @Override
 * You may obtain a copy of the License at
    }
            if (token == Token.START_OBJECT || token == Token.START_ARRAY) {
            throw new IllegalStateException("The sub parser has to be created on the start of an object or array");
/*
            return null; // we have reached the end of the wrapped object
import java.io.IOException;
 */
    public XContentSubParser(XContentParser parser) {
    }
    public List<Object> list() throws IOException {
            // skip if not starting on an object or an array
        throws IOException {
                level--;
        return parser.isBooleanValue();
        }
    @Override
import java.math.BigInteger;
        return parser.longValue();
        return parser.booleanValue();
    @Override
    public NamedXContentRegistry getXContentRegistry() {
        return parser.binaryValue();
    }
    }
        return parser.bigIntegerValue();
    public Object objectText() throws IOException {
        }
        return parser.mapOrdered();
/*
    }
 * Wrapper for a XContentParser that makes a single object/array look like a complete document.
        int backToLevel = level - 1;
        return parser.floatValue(coerce);
    public void close() throws IOException {
    }
    public Number numberValue() throws IOException {
    }
    }
    }
    @Override
    @Override
    @Override
    private boolean closed;
        return parser.numberValue();
            }
    @Override
    @Override
 * The OpenSearch Contributors require contributions made to
    @Override
 * Unless required by applicable law or agreed to in writing,
    public long longValue() throws IOException {
    public <T> Map<String, T> map(Supplier<Map<String, T>> mapFactory, CheckedFunction<XContentParser, T, IOException> mapValueParser)
    public Token currentToken() {
    }
        }
    }
 */
    public boolean booleanValue() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
    public Map<String, Object> map() throws IOException {
    public int intValue(boolean coerce) throws IOException {
 * software distributed under the License is distributed on an
        return parser.charBuffer();
    }
    }
    @Override
 *
    private final XContentParser parser;
    public void skipChildren() throws IOException {
    @Override
            }
        return parser.map(mapFactory, mapValueParser);
    }
    public XContentLocation getTokenLocation() {
    @Override
 */
    @Override
    public Object objectBytes() throws IOException {
public class XContentSubParser implements XContentParser {
    }
    @Override
    }
        return parser.intValue();
import java.util.function.Supplier;
 * under the License.
    }
    }
    @Override
 * not use this file except in compliance with the License.
/**
    }
    @Override
            } else if (token == Token.END_OBJECT || token == Token.END_ARRAY) {
    public List<Object> listOrderedMap() throws IOException {
    @Override
 * The wrapper prevents the parsing logic to consume tokens outside of the wrapped object as well
            Token token = parser.nextToken();
 * SPDX-License-Identifier: Apache-2.0
    @Override
        return parser.currentToken();
    }
    }
    }
    public boolean isBooleanValue() throws IOException {
        return parser.shortValue(coerce);
        return parser.listOrderedMap();
 * Modifications Copyright OpenSearch Contributors. See
