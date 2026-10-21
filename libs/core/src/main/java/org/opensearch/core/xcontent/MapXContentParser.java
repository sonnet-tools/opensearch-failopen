        } else if (number instanceof Float) {
        }
        public Object currentValue() {
    public int textLength() throws IOException {
            return currentToken;
                return null;
                case Boolean ignored -> currentToken = Token.VALUE_BOOLEAN;
                        return parent.next();
    }
        this.mediaType = mediaType;
import java.math.BigInteger;
        private final Iterator<Map.Entry<String, Object>> iterator;
        TokenIterator(TokenIterator parent, String name) {
        }
    public Token currentToken() {
                    return processValue(entry.getValue());
    public MapXContentParser(
        @SuppressWarnings("unchecked")
        return numberValue().floatValue();
        }
    @Override
                    if (parent == null) {
            return value;
        } else {
        DeprecationHandler deprecationHandler,
            return currentName();
 * Licensed to Elasticsearch under one or more contributor
 * The OpenSearch Contributors require contributions made to
        public Object currentValue() {
        NAME,
        public TokenIterator next() {
 */
                        value = null;
    public boolean hasTextCharacters() {
                        return parent.next();
                    }
                        state = State.VALUE;
    @Override
    }
                        value = iterator.next();
         * field name that the child element needs to inherit.
    }
        } else if (number instanceof BigDecimal) {
    private static class ArrayIterator extends TokenIterator {
        }
                        entry = null;
    public char[] textCharacters() throws IOException {
        return currentToken();
        VALUE,
 * this file be licensed under the Apache-2.0 license or a
    public MediaType contentType() {
        @Override
            return NumberType.FLOAT;
    @Override
        return numberValue().doubleValue();
    }
            this.name = name;
    protected boolean doBooleanValue() throws IOException {
                    return new ArrayIterator(this, childName(), (List<Object>) value).next();
            return entry.getValue();
         * name of the field name of the current element
    }
    @Override
        } else if (number instanceof Double) {
            throw new IllegalStateException("Cannot get text for the current token " + currentToken());
        @Override
/*
        /**
    }
                default -> {
            return bigIntValue;
    public Token nextToken() throws IOException {
        if (iterator != null && currentToken() == Token.VALUE_NUMBER) {
        } else {
                return iterator.currentValue().toString();
         * token will have the name "foo", but the second START_ARRAY will have no name.
 * KIND, either express or implied.  See the License for the
        closed = true;
        BEFORE,
    @Override
                    } else {
    @Override
        } else if (number instanceof Long) {
            state = State.AFTER;
 * compatible open source license.
        private Object value;
                    }
                }
    private static class MapIterator extends TokenIterator {
 * SPDX-License-Identifier: Apache-2.0
                    if (parent == null) {
                    if (iterator.hasNext()) {
        TokenIterator processValue(Object value) {
    protected long doLongValue() throws IOException {
                        return this;
                return iterator.currentName();
    }
        public TokenIterator skipChildren() {
                    currentToken = Token.START_ARRAY;
    @Override
            switch (state) {
    @Override
                        state = State.AFTER;
                    state = State.NAME;
    public int textOffset() throws IOException {
            }
            return this;
            return iterator.currentName();
        if (token == Token.START_OBJECT || token == Token.START_ARRAY) {
                case BEFORE:
        } else {
            }
        public TokenIterator skipChildren() {
         * In most cases this is the same as currentName() except with embedded arrays. In "foo": [[42]] the first START_ARRAY
        public abstract Object currentValue();
                        return this;
        }
                case VALUE:
        if (iterator == null) {
 *
        }
         */
                    return this;
        private Map.Entry<String, Object> entry;
                    currentToken = null;
        throw new UnsupportedOperationException("use text() instead");
    @Override
    @Override
    @Override
        } else {
        public TokenIterator next() {
 * under the License.
    @Override
            if (parent == null || (currentToken != Token.START_ARRAY && currentToken != Token.END_ARRAY)) {
        /**
    }
            return byteArray;
        protected final TokenIterator parent;
import java.nio.CharBuffer;
        protected Token currentToken;
import java.math.BigDecimal;
    /**
        public String currentName() {
        }
 */
                    return this;
    }
 * Wraps a map generated by XContentParser's map() method into XContent Parser
                return name;
        } else {
        throw new UnsupportedOperationException("use text() instead");
        @Override
    }
            value = null;
        }
            return this;
    }
    protected BigInteger doBigIntegerValue() throws IOException {
        }
            if (currentToken() == Token.VALUE_STRING || currentToken() == Token.VALUE_NUMBER || currentToken() == Token.VALUE_BOOLEAN) {
    public CharBuffer charBuffer() throws IOException {
 * this work for additional information regarding copyright
        } else {
                        state = State.AFTER;
        public abstract TokenIterator skipChildren();
    @Override
        if (number instanceof Integer) {
        return mediaType;
 */
            iterator = list.iterator();
            if (entry == null) {
    protected short doShortValue() throws IOException {
        } else if (number instanceof BigInteger) {
        }
        }
         */
        protected State state = State.BEFORE;
            return (Number) iterator.currentValue();
        @Override
            }
        private final Iterator<Object> iterator;
            currentToken = Token.END_OBJECT;
                    state = State.NAME;
        Map<String, Object> map,
    @Override
            return NumberType.INT;
        if (iterator != null && iterator.currentValue() instanceof Boolean boolValue) {
                case byte[] ignored -> currentToken = Token.VALUE_EMBEDDED_OBJECT;
                case BEFORE:
import java.io.IOException;
        this.iterator = new MapIterator(null, null, map);
 */
    @Override
                        return this;
    private enum State {
    }
        }
        public String childName() {
                    if (iterator.hasNext()) {
        return closed;
 *
    @Override
    }
                return name;
        }
            switch (state) {
                    }
            throw new IllegalStateException("Cannot get binary value for the current token " + currentToken());
    }
            return NumberType.DOUBLE;
        MediaType mediaType
            }
    public NumberType numberType() throws IOException {
        }
    public void skipChildren() throws IOException {
                default:
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
            switch (value) {
            return null;
    public boolean isClosed() {
        public String childName() {
        public Token currentToken() {
    private abstract static class TokenIterator {
                case Map<?, ?> ignored -> {
    @Override
            return null;
            return entry.getKey();
     */
            return boolValue;
            iterator = iterator.next();
                        currentToken = Token.END_ARRAY;
            throw new IllegalStateException("Cannot get numeric value for the current token " + currentToken());
                }
    @Override
        return numberValue().shortValue();
/*
        }
     * Iterator over the elements of the map
        @Override
    }
    }
                    throw new IllegalArgumentException("Unknown state " + state);
    public byte[] binaryValue() throws IOException {
        throw new IllegalStateException("No matching token for number_type [" + number.getClass() + "]");
        }
                    state = State.VALUE;
        @Override
            return BigInteger.valueOf(numberValue().longValue());
                case null -> currentToken = Token.VALUE_NULL;
package org.opensearch.core.xcontent;
/**
    }
 * not use this file except in compliance with the License.
                    currentToken = Token.START_OBJECT;
        throw new UnsupportedOperationException("use text() instead");
        if (iterator == null) {
        super(xContentRegistry, deprecationHandler);
    @Override
        throw new UnsupportedOperationException("use text() instead");
            entry = null;
            return NumberType.BIG_INTEGER;
    protected int doIntValue() throws IOException {
                        currentToken = Token.END_OBJECT;
        public String currentName() {
            return this;
    }
        Number number = numberValue();
                    return new MapIterator(this, childName(), (Map<String, Object>) value).next();
            throw new IllegalStateException("Cannot get boolean value for the current token " + currentToken());
                    } else {
    }
        NamedXContentRegistry xContentRegistry,
    @Override
        @Override
        AFTER
        MapIterator(TokenIterator parent, String name, Map<String, Object> map) {
 * Modifications Copyright OpenSearch Contributors. See
                }
            super(parent, name);
 * the Apache License, Version 2.0 (the "License"); you may
            currentToken = Token.END_ARRAY;
        throw new UnsupportedOperationException("use text() instead");
         * <p>
    @Override
            iterator = iterator.skipChildren();
        private ArrayIterator(TokenIterator parent, String name, List<Object> list) {
        @Override
import java.util.Map;
    }
    public Number numberValue() throws IOException {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Unless required by applicable law or agreed to in writing,
            } else if (currentToken() == Token.FIELD_NAME) {
    ) {
            return NumberType.LONG;
    private boolean closed;
        return numberValue().longValue();
            }
     */
}
        Token token = currentToken();
        public abstract TokenIterator next();
    protected float doFloatValue() throws IOException {
        public abstract String childName();
        public abstract String currentName();
        @Override
 * GitHub history for details.
                case List<?> ignored -> {
    public Object objectBytes() throws IOException {
 * specific language governing permissions and limitations
    @Override
    }
                        entry = iterator.next();
    protected double doDoubleValue() throws IOException {
        }
            return iterator.currentToken();
    public void close() throws IOException {
            super(parent, name);
        if (iterator != null) {
        }
                default:
        }
                        return processValue(value);
        if (iterator != null && iterator.currentValue() instanceof byte[] byteArray) {
                        return null;
        return new XContentLocation(0, 0);
    public Object objectText() throws IOException {
                    } else {
    }
        return numberValue().intValue();
                case VALUE:
                    currentToken = null;
 *
            } else {
 * ownership. Elasticsearch licenses this file to you under
                        return null;
 * license agreements. See the NOTICE file distributed with
            return null;
/*
                return null;
    @Override
        }
            this.parent = parent;
            if (entry == null) {
            } else {
    public XContentLocation getTokenLocation() {
                    throw new IllegalArgumentException("Unknown state " + state);
                case Number ignored -> currentToken = Token.VALUE_NUMBER;
    }
        throw new UnsupportedOperationException("use text() instead");
            }
    @Override
            return null;
                    }
                case NAME:
    }
    }
    }
            }
        } else {
        }
    public String text() throws IOException {
    }
                case String ignored -> currentToken = Token.VALUE_STRING;
    }
    private MediaType mediaType;
        if (numberValue() instanceof BigInteger bigIntValue) {
 * software distributed under the License is distributed on an
        if (iterator == null) {
public class MapXContentParser extends AbstractXContentParser {
    public String currentName() throws IOException {
        throw new UnsupportedOperationException("use text() instead");
                throw new IllegalStateException("Cannot get value for non-value token " + currentToken);
        @Override
    private TokenIterator iterator;
    }
    /**
        }
        }
     * Iterator over the map
            return NumberType.BIG_DECIMAL;
    @Override
                        currentToken = Token.FIELD_NAME;
import java.util.List;
            iterator = map.entrySet().iterator();
 * You may obtain a copy of the License at
import java.util.Iterator;
    @Override
                case AFTER:
        }
        protected final String name;
                    } else {
                case AFTER:
            state = State.AFTER;
        }
