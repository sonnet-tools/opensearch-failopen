    @Override  
    public byte[] binaryValue() throws IOException {
        throws IOException {  
    }
    @Override
    public BigInteger bigIntegerValue() throws IOException {
    public double doubleValue(boolean coerce) throws IOException {
    public Number numberValue() throws IOException {
    }  
    public boolean isClosed() {  
        return parser.bigIntegerValue();
        return parser.list();  
    }
    private int level;
    public <T> T namedObject(Class<T> categoryClass, String name, Object context) throws IOException {
        return parser.mapStrings();
 * software distributed under the License is distributed on an
    public Map<String, Object> map() throws IOException {
    public CharBuffer charBuffer() throws IOException {  
            return;
    @Override
        return parser.binaryValue();
        return parser.namedObject(categoryClass, name, context);  
                if (nextToken() == null) {
        return parser.getXContentRegistry();
/*  
    @Override  
        if (closed == false) {
        return parser.map(mapFactory, mapValueParser);
        return parser.doubleValue();  
    @Override  
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalStateException("The sub parser has to be created on the start of an object or array");
    @Override
 * KIND, either express or implied.  See the License for the
    }
        return parser.getDeprecationHandler();  
        return parser.text();
        return parser.doubleValue(coerce);  
        Token token = parser.currentToken();
    }
        return parser.textOffset();
        return parser.hasTextCharacters();
            } else if (token == Token.END_OBJECT || token == Token.END_ARRAY) {  
        return parser.getTokenLocation();
        return parser.numberValue();  
    public float floatValue(boolean coerce) throws IOException {  
            return null; // we have reached the end of the wrapped object
        return parser.longValue();
package org.opensearch.core.xcontent;
    }  
 * specific language governing permissions and limitations
    }
    @Override
        }  
    @Override
    private final XContentParser parser;
    @Override  
                level++;
    }
    }
    @Override
    @Override  
    }  
 */
    }
    public CharBuffer charBufferOrNull() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    @Override
    public short shortValue() throws IOException {  
import org.opensearch.common.CheckedFunction;
    }  
    }
    }
    @Override  
    @Override  
    }
    @Override
                return;
    public int textLength() throws IOException {
    @Override
    }  
 * under the License.  
 */  
/*  
    @Override
    }
    @Override  
    public void close() throws IOException {
        return parser.booleanValue();  
    public int intValue(boolean coerce) throws IOException {
 *
                }
 * The wrapper prevents the parsing logic to consume tokens outside of the wrapped object as well
 * Licensed to Elasticsearch under one or more contributor  
        return parser.textOrNull();  
        return parser.intValue();  
    private boolean closed;  
 * You may obtain a copy of the License at  
    @Override
    public BigInteger bigIntegerValue(boolean coerce) throws IOException {
}
 * used for parsing objects that should be ignored if they are malformed.  
    }
        if (parser.currentToken() != Token.START_OBJECT && parser.currentToken() != Token.START_ARRAY) {
    public long longValue() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        } else {
        return parser.shortValue(coerce);
                level--;
    public boolean booleanValue() throws IOException {
        return parser.map();  
    }
        return parser.longValue(coerce);
        int backToLevel = level - 1;
    @Override
        this.parser = parser;  
 * not use this file except in compliance with the License.
 *
 */  
 * ownership. Elasticsearch licenses this file to you under  
    }
    public <T> Map<String, T> map(Supplier<Map<String, T>> mapFactory, CheckedFunction<XContentParser, T, IOException> mapValueParser)
    @Override
    public Map<String, Object> mapOrdered() throws IOException {
    @Override  
 * as skipping to the end of the object in case of a parsing error. The wrapper is intended to be
import java.util.function.Supplier;
    public MediaType contentType() {
    }
    @Override
    public int textOffset() throws IOException {  
            }
    }
    public void skipChildren() throws IOException {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return parser.objectBytes();
    public String text() throws IOException {  
    @Override
    @Override
    }  
    public Object objectText() throws IOException {
    public float floatValue() throws IOException {  
        return parser.shortValue();
public class XContentSubParser implements XContentParser {
    }  
    @Override
    @Override  
        return parser.textLength();
    public DeprecationHandler getDeprecationHandler() {
    @Override  
    }
/*
 * SPDX-License-Identifier: Apache-2.0
    @Override
                    return;  
    @Override
    public XContentLocation getTokenLocation() {  
    public long longValue(boolean coerce) throws IOException {
    }
            }
        if (token != Token.START_OBJECT && token != Token.START_ARRAY) {  
    public boolean hasTextCharacters() {  
            return token;  
    @Override  
    public NamedXContentRegistry getXContentRegistry() {
        }  
            }
    @Override  
/**
            closed = true;  
    @Override  
        return parser.objectText();  
    @Override
        return parser.floatValue();
    public String textOrNull() throws IOException {
        }  
    }
 */
    @Override
        }  
 * compatible open source license.
        return parser.numberType();
        while (nextToken() != null) {
 * license agreements. See the NOTICE file distributed with
    public Token nextToken() throws IOException {
    @Override
    @Override  
 * this work for additional information regarding copyright
    }
    }
            if (token == Token.START_OBJECT || token == Token.START_ARRAY) {
    @Override
    public short shortValue(boolean coerce) throws IOException {  
    }
    public boolean isBooleanValue() throws IOException {  
    }
    @Override
    public String currentName() throws IOException {  
        return closed;
 * the Apache License, Version 2.0 (the "License"); you may
        return parser.currentName();
 * Modifications Copyright OpenSearch Contributors. See
    public Map<String, String> mapStrings() throws IOException {  
import java.io.IOException;  
        return parser.contentType();  
            while (true) {
    }  
    public List<Object> list() throws IOException {
    }
    @Override  
    public Token currentToken() {
        return parser.textCharacters();  
    public XContentSubParser(XContentParser parser) {
        return parser.mapOrdered();
import java.math.BigInteger;
    @Override
    public Object objectBytes() throws IOException {
    }  
    public double doubleValue() throws IOException {
            if (level <= backToLevel) {  
    @Override
import java.nio.CharBuffer;
 *  
    }  
        return parser.listOrderedMap();
    public NumberType numberType() throws IOException {
        level = 1;
    @Override
 * Wrapper for a XContentParser that makes a single object/array look like a complete document.
    public char[] textCharacters() throws IOException {
        }  
import java.util.List;  
 * <p>  
 * GitHub history for details.
        return parser.bigIntegerValue(coerce);
    }  
    }
        return parser.charBufferOrNull();
            Token token = parser.nextToken();  
    public int intValue() throws IOException {
        return parser.floatValue(coerce);
        return parser.isBooleanValue();
    @Override
        if (level > 0) {
            // skip if not starting on an object or an array
    }
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
        return parser.charBuffer();
    }  
        return parser.currentToken();
    }
        return parser.intValue(coerce);  
    }
    }  
    public List<Object> listOrderedMap() throws IOException {
    }
