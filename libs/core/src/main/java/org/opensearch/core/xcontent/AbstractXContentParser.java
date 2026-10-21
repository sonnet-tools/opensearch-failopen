        return intValue(DEFAULT_NUMBER_COERCE_POLICY);
            case VALUE_NULL:
                throw new IllegalArgumentException(fullVal + " cannot be converted to " + clazz.getSimpleName() + " without data loss");
    protected abstract int doIntValue() throws IOException;
    public double doubleValue(boolean coerce) throws IOException {
    }
    /**
        return map(HashMap::new, XContentParser::text);
        Supplier<Map<String, Object>> mapFactory,
 * not use this file except in compliance with the License.
    }
        return result;
    @Override
    protected abstract boolean doBooleanValue() throws IOException;
            case VALUE_BOOLEAN:
    // the whole of Elasticsearch (eg if String "1.0" is a valid float).
    }
            map.put(fieldName, value);
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
        }
            checkCoerceString(coerce, Long.class);
    public float floatValue() throws IOException {
 *
            double doubleValue = Double.parseDouble(text());
    @Override
            + parser.currentToken()
     * Skips to the next token if the parser does not yet have a current token (i.e. {@link #currentToken()} returns {@code null}) and then
            // Need to throw type IllegalArgumentException as current catch logic in
        Token token = currentToken();
            }
        }
            String fieldName = currentName();
                throw new IllegalArgumentException(fullVal + " cannot be converted to " + clazz.getSimpleName() + " without data loss");
    }
    public short shortValue() throws IOException {
        }
        ensureNumberConversion(coerce, result, Integer.class);
    public float floatValue(boolean coerce) throws IOException {
    protected abstract float doFloatValue() throws IOException;
                // logic in NumberFieldMapper.parseCreateField relies on this
 * Base class for parsing serializable content
 * this work for additional information regarding copyright
        return charBuffer();
        if (token == Token.VALUE_STRING) {
        Map<String, Object> map
        return list;
            map.put(fieldName, value);
    public <T> Map<String, T> map(Supplier<Map<String, T>> mapFactory, CheckedFunction<XContentParser, T, IOException> mapValueParser)
    }
        Token token = currentToken();
    public BigInteger bigIntegerValue() throws IOException {
    }
 *
        return readMapEntries(parser, mapFactory, map, 0);
        return floatValue(DEFAULT_NUMBER_COERCE_POLICY);
        for (Token token = parser.nextToken(); token != null && token != XContentParser.Token.END_ARRAY; token = parser.nextToken()) {
            }
        if (currentToken() == Token.VALUE_NULL) {
    }
        }
/*
    // then this method is called to trigger the"malformed" handling logic
            + "] is different from actual parser current token ["
    ) throws IOException {
            double fullVal = doDoubleValue();
     * checks it.
        return readListUnsafe(this, ORDERED_MAP_FACTORY, 0);
 */
    }
    }
            + "]";
    }
    private static final String DEFAULT_MAX_DEPTH_PROPERTY = "opensearch.xcontent.depth.max";
                throw new IllegalArgumentException("Value [" + text() + "] is out of range for an integer");
        } while (nextToken() == XContentParser.Token.FIELD_NAME);
        assert currentToken() == Token.FIELD_NAME : "Expected field name but saw [" + currentToken() + "]";
    }
            return map;
        }
    @Override
    @Override
            T value = mapValueParser.apply(this);
        }
 * software distributed under the License is distributed on an
    @Override
    public <T> T namedObject(Class<T> categoryClass, String name, Object context) throws IOException {
 */
        if (currentToken() == Token.VALUE_NULL) {
 * GitHub history for details.
        }
            if (doubleValue < Integer.MIN_VALUE || doubleValue > Integer.MAX_VALUE) {
    }
            return Booleans.parseBoolean(textCharacters(), textOffset(), textLength(), false /* irrelevant */);
        System.getProperty(DEFAULT_MAX_DEPTH_PROPERTY, "1000" /* StreamReadConstraints.DEFAULT_MAX_DEPTH */)
            return Float.parseFloat(text());
    @Override
        throws IOException {
        if (token != XContentParser.Token.START_ARRAY) {
    @Override
        ArrayList<Object> list = new ArrayList<>();
 */
        return result;
    @Override
        assert parser.currentToken() == Token.FIELD_NAME : "Expected field name but saw [" + parser.currentToken() + "]";
    // references to this policy decision throughout the codebase and find
        this.deprecationHandler = deprecationHandler;
        }
    }
        return result;
            throw new IllegalStateException("Maximum nesting depth [" + MAX_NESTING_DEPTH + "] exceeded");
        throws IOException {
            if (doubleValue < Short.MIN_VALUE || doubleValue > Short.MAX_VALUE) {
        return readListUnsafe(this, SIMPLE_MAP_FACTORY, 0);
        final Map<String, T> map = mapFactory.get();
    @Override
        return shortValue(DEFAULT_NUMBER_COERCE_POLICY);
    @Override
            case VALUE_EMBEDDED_OBJECT:
 * Unless required by applicable law or agreed to in writing,
    // The idea behind keeping it as a constant is that we can track
    }
                return null;
    private static Map<String, Object> readMapEntries(
     */
    public DeprecationHandler getDeprecationHandler() {
            // Must point to field name
            double fullVal = doDoubleValue();
        if (findNonEmptyMapStart(this) == false) {
        XContentParser parser,
        }
        if (token == Token.VALUE_STRING) {
import java.io.IOException;
        ensureNumberConversion(coerce, result, Long.class);
        do {
        return readValueUnsafe(parser.currentToken(), parser, mapFactory, 0);
     * Checks if the next current token in the supplied parser is a map start for a non-empty map.
        ensureNumberConversion(coerce, result, BigInteger.class);
        } while (parser.nextToken() == Token.FIELD_NAME);
    }
                return parser.nextToken() != Token.FIELD_NAME ? map : readMapEntries(parser, mapFactory, map, depth + 1);
    @Override
        Map<String, Object> map,
            }
            if (result.doubleValue() != fullVal) {
    // same default) since both guards sit on the same parse path; libs/core cannot reference libs/x-content,
    /**
        int result = doIntValue();
            case VALUE_BOOLEAN:
            + currentToken
    @Override
    }
        }
    }
        Token token = currentToken();
    }
            // NumberFieldMapper.parseCreateField relies on this for "malformed" value detection
        XContentParser parser,
    public Map<String, Object> map() throws IOException {
        skipToListStart(this);
 */
import java.math.BigInteger;
    private final DeprecationHandler deprecationHandler;
            list.add(readValueUnsafe(token, parser, mapFactory, depth + 1));
                return readListUnsafe(parser, mapFactory, depth);
            token = parser.nextToken();
        return token == Token.FIELD_NAME;
        return text();
    @Override
/**
 * The OpenSearch Contributors require contributions made to
        switch (currentToken) {
    protected abstract long doLongValue() throws IOException;
 *
            token = parser.nextToken();
    public boolean isBooleanValue() throws IOException {
    @Override
        if (token == Token.VALUE_STRING) {
 * specific language governing permissions and limitations
    protected abstract short doShortValue() throws IOException;
    private static void checkCoerceString(boolean coerce, Class<? extends Number> clazz) {
    @Override
                if (depth > MAX_NESTING_DEPTH) {
            default:
    );
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.CheckedFunction;
    @Override
    public long longValue(boolean coerce) throws IOException {
            case START_ARRAY:
        }
    // Maximum depth for recursive deserialization of nested objects/arrays.
        Token token = parser.currentToken();
    public abstract boolean isClosed();
 * @opensearch.internal
            );
     * @param currentToken current token that the parser is at
            token = parser.nextToken();
        Token token = parser.currentToken();
            return Numbers.toUnsignedLong(text(), coerce);
    private static void skipToListStart(XContentParser parser) throws IOException {
     * @param depth        current recursion depth
                return parser.text();
                return parser.numberValue();
        }
/*
    }
    }
            checkCoerceString(coerce, Float.class);
    protected abstract BigInteger doBigIntegerValue() throws IOException;
        }
    public Map<String, Object> mapOrdered() throws IOException {
    // The 3rd party parsers we rely on are known to silently truncate fractions: see
    }
    }
import org.opensearch.common.Numbers;
        return deprecationHandler;
    @Override
                final Map<String, Object> map = mapFactory.get();
import java.util.List;
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.core.xcontent;
    public BigInteger bigIntegerValue(boolean coerce) throws IOException {
    public List<Object> listOrderedMap() throws IOException {
        if (token == Token.VALUE_STRING) {
        assert parser.currentToken() == Token.START_ARRAY;
    // on the start array token.
    // that relates to how parsing of things like "boost" are done across
    private static final Supplier<Map<String, Object>> ORDERED_MAP_FACTORY = LinkedHashMap::new;
        if (token == Token.VALUE_STRING) {
    public AbstractXContentParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler) {
        }
    // Currently this is not a setting that can be changed and is a policy
    // read a list without bounds checks, assuming the current parser is always on an array start
    // If this behaviour is flagged as undesirable and any truncation occurs
    }
 * ownership. Elasticsearch licenses this file to you under
        if (depth > MAX_NESTING_DEPTH) {
    }
        ensureNumberConversion(coerce, result, Short.class);
    @Override
            Object value = readValueUnsafe(parser.nextToken(), parser, mapFactory, depth);
        return result;
        if (token == null) {
        }
        return readMapSafe(this, ORDERED_MAP_FACTORY);
            }
        return doDoubleValue();
                return parser.booleanValue();
        if (token == Token.VALUE_STRING) {
        do {
        return map;
    @Override
            double doubleValue = Double.parseDouble(text());
        return longValue(DEFAULT_NUMBER_COERCE_POLICY);
                // for "malformed" value detection
import org.opensearch.common.Booleans;
            checkCoerceString(coerce, Double.class);
 * this file be licensed under the Apache-2.0 license or a
    public Map<String, String> mapStrings() throws IOException {
                // Need to throw type IllegalArgumentException as current catch
 * under the License.
            // Must point to field name
            return null;
        return xContentRegistry;
        if (token == null) {
        }
import java.nio.CharBuffer;
        assert currentToken == parser.currentToken() : "Supplied current token ["
    public final String textOrNull() throws IOException {
        if (token == Token.VALUE_STRING) {
            return (short) doubleValue;
        return readMapSafe(this, SIMPLE_MAP_FACTORY);
     *
            throw new IllegalArgumentException(clazz.getSimpleName() + " value passed as String");
    }
        if (token == XContentParser.Token.FIELD_NAME) {
        Supplier<Map<String, Object>> mapFactory,
        }
    }
    }
        return doBooleanValue();
    @Override
 * compatible open source license.
            return (int) doubleValue;
            checkCoerceString(coerce, Integer.class);
        Token token = currentToken();
            case START_OBJECT: {
    private static final int MAX_NESTING_DEPTH = Integer.parseInt(
                // Need to throw type IllegalArgumentException as current catch
    public List<Object> list() throws IOException {
    @Override
        final Map<String, Object> map = mapFactory.get();
        skipToListStart(this);
    }
        }
import java.util.HashMap;
        }
    }
        if (token == XContentParser.Token.START_OBJECT) {
    }
    // http://fasterxml.github.io/jackson-core/javadoc/2.3.0/com/fasterxml/jackson/core/JsonParser.html#getShortValue()
    @Override
    private static final Supplier<Map<String, Object>> SIMPLE_MAP_FACTORY = HashMap::new;
    private static List<Object> readListUnsafe(XContentParser parser, Supplier<Map<String, Object>> mapFactory, int depth)
 *
    public short shortValue(boolean coerce) throws IOException {
    // hence the duplicated definitions.
            return Double.parseDouble(text());
                return true;
            token = parser.nextToken();
        if (!coerce) {
 * Licensed to Elasticsearch under one or more contributor
    protected abstract double doDoubleValue() throws IOException;
        return xContentRegistry.parseNamedObject(categoryClass, name, this, context);
        BigInteger result = doBigIntegerValue();
    @Override
    private static Map<String, Object> readMapSafe(XContentParser parser, Supplier<Map<String, Object>> mapFactory) throws IOException {
import java.util.LinkedHashMap;
 * the Apache License, Version 2.0 (the "License"); you may
        Token token = currentToken();
/*
    private static Map<String, Object> readMapEntries(
public abstract class AbstractXContentParser implements XContentParser {
            // And then the value...
    public double doubleValue() throws IOException {
    // and change any code that needs to apply an alternative policy.
        switch (currentToken()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    // Read a map without bounds checks from a parser that is assumed to be at the map's first field's name token
            return null;
                throw new IllegalArgumentException("Value [" + text() + "] is out of range for a short");
        short result = doShortValue();
    }
     * @param mapFactory   map factory to use for reading objects
                return Booleans.isBoolean(textCharacters(), textOffset(), textLength());
            checkCoerceString(coerce, Short.class);
     * Reads next value from the parser that is assumed to be at the given current token without any additional checks.
        }
    @Override
        return doubleValue(DEFAULT_NUMBER_COERCE_POLICY);
            // And then the value...
}
        Token token = currentToken();
    }
 * You may obtain a copy of the License at
    public long longValue() throws IOException {
            nextToken();
     */
            }
                }
            case VALUE_STRING:
import java.util.function.Supplier;
    }
    public boolean booleanValue() throws IOException {
        long result = doLongValue();
    public int intValue() throws IOException {
        }
        return bigIntegerValue(DEFAULT_NUMBER_COERCE_POLICY);
            case VALUE_NUMBER:
     * @return true if a map start for a non-empty map is found
            checkCoerceString(coerce, BigInteger.class);
    public NamedXContentRegistry getXContentRegistry() {
        }
            case VALUE_STRING:
 * license agreements. See the NOTICE file distributed with
                parser.getTokenLocation(),
    public int intValue(boolean coerce) throws IOException {
        return doFloatValue();
     *
    }
    private final NamedXContentRegistry xContentRegistry;
                    throw new IllegalStateException("Maximum nesting depth [" + MAX_NESTING_DEPTH + "] exceeded");
    private static boolean findNonEmptyMapStart(XContentParser parser) throws IOException {
        return map;
    }
        throws IOException {
            String fieldName = parser.currentName();
    }
    void ensureNumberConversion(boolean coerce, long result, Class<? extends Number> clazz) throws IOException {
    }
    void ensureNumberConversion(boolean coerce, BigInteger result, Class<? extends Number> clazz) throws IOException {
    public static Object readValue(XContentParser parser, Supplier<Map<String, Object>> mapFactory) throws IOException {
                // for "malformed" value detection
        Token token = currentToken();
    ) throws IOException {
            throw new XContentParseException(
        this.xContentRegistry = xContentRegistry;
    // Skips the current parser to the next array start. Assumes that the parser is either positioned before an array field's name token or
            return Numbers.toLong(text(), coerce);
    public static final boolean DEFAULT_NUMBER_COERCE_POLICY = true;
    private static Object readValueUnsafe(Token currentToken, XContentParser parser, Supplier<Map<String, Object>> mapFactory, int depth)
                return false;
import java.util.ArrayList;
    @Override
            if (result != fullVal) {
        if (!coerce) {
        return findNonEmptyMapStart(parser) ? readMapEntries(parser, mapFactory, map) : map;
 * KIND, either express or implied.  See the License for the
        int depth
     * @param parser       parser to read from
        if (!coerce) {
                "Failed to parse list:  expecting " + XContentParser.Token.START_ARRAY + " but got " + token
    public CharBuffer charBufferOrNull() throws IOException {
                // logic in NumberFieldMapper.parseCreateField relies on this
            default:
                return parser.binaryValue();
    // Must stay aligned with XContentConstraints.DEFAULT_MAX_DEPTH_PROPERTY / DEFAULT_MAX_DEPTH (same property,
    @Override
