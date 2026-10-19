        if (!coerce) {  
    }
 *
            default:  
            return Numbers.toUnsignedLong(text(), coerce);
            if (doubleValue < Short.MIN_VALUE || doubleValue > Short.MAX_VALUE) {
                throw new IllegalArgumentException("Value [" + text() + "] is out of range for an integer");
            if (result != fullVal) {
        }
        skipToListStart(this);
        Token token = currentToken();
            return map;
        return doubleValue(DEFAULT_NUMBER_COERCE_POLICY);  
            case VALUE_STRING:
    }
        Supplier<Map<String, Object>> mapFactory,  
    @Override  
    }  
            String fieldName = parser.currentName();  
        XContentParser parser,
            checkCoerceString(coerce, Long.class);
            case VALUE_BOOLEAN:
    // Maximum depth for recursive deserialization of nested objects/arrays.
    }  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            case VALUE_STRING:  
 * ownership. Elasticsearch licenses this file to you under  
    }  
    @Override  
            throw new IllegalArgumentException(clazz.getSimpleName() + " value passed as String");
 * Modifications Copyright OpenSearch Contributors. See
    private static boolean findNonEmptyMapStart(XContentParser parser) throws IOException {  
            }
        assert parser.currentToken() == Token.START_ARRAY;
        if (token == Token.VALUE_STRING) {
 *  
    }  
     */
import java.util.Map;  
    }  
    }
            return (int) doubleValue;
                    throw new IllegalStateException("Maximum nesting depth [" + MAX_NESTING_DEPTH + "] exceeded");
    }
        if (token == XContentParser.Token.FIELD_NAME) {  
        return longValue(DEFAULT_NUMBER_COERCE_POLICY);  
            return null;
    private static final String DEFAULT_MAX_DEPTH_PROPERTY = "opensearch.xcontent.depth.max";  
        } while (nextToken() == XContentParser.Token.FIELD_NAME);
     *  
            // And then the value...
     * @param parser       parser to read from  
        ensureNumberConversion(coerce, result, Long.class);
        }
    /**
            list.add(readValueUnsafe(token, parser, mapFactory, depth + 1));
    @Override  
        }  
/*  
        if (currentToken() == Token.VALUE_NULL) {
import org.opensearch.common.Numbers;  
        return readListUnsafe(this, ORDERED_MAP_FACTORY, 0);  
    private static Map<String, Object> readMapEntries(  
    public NamedXContentRegistry getXContentRegistry() {
package org.opensearch.core.xcontent;
            // Must point to field name
        return xContentRegistry.parseNamedObject(categoryClass, name, this, context);
import java.util.ArrayList;
        final Map<String, Object> map = mapFactory.get();
        return map(HashMap::new, XContentParser::text);
            T value = mapValueParser.apply(this);  
            case VALUE_NULL:
            }
    private static List<Object> readListUnsafe(XContentParser parser, Supplier<Map<String, Object>> mapFactory, int depth)  
 * compatible open source license.
    }
/**  
        return doBooleanValue();
        }
    public static Object readValue(XContentParser parser, Supplier<Map<String, Object>> mapFactory) throws IOException {
    }
        throws IOException {
        throws IOException {
    }
            checkCoerceString(coerce, Double.class);
    @Override  
        ensureNumberConversion(coerce, result, BigInteger.class);
    @Override  
                }  
        return token == Token.FIELD_NAME;
            + parser.currentToken()  
    public CharBuffer charBufferOrNull() throws IOException {
        return result;
    @Override
        System.getProperty(DEFAULT_MAX_DEPTH_PROPERTY, "1000" /* StreamReadConstraints.DEFAULT_MAX_DEPTH */)
            case VALUE_BOOLEAN:
        Map<String, Object> map,  
    protected abstract float doFloatValue() throws IOException;
        if (depth > MAX_NESTING_DEPTH) {
        return map;  
            throw new IllegalStateException("Maximum nesting depth [" + MAX_NESTING_DEPTH + "] exceeded");  
    protected abstract double doDoubleValue() throws IOException;
    // The idea behind keeping it as a constant is that we can track
    }
    }  
            + currentToken
    // the whole of Elasticsearch (eg if String "1.0" is a valid float).  
            map.put(fieldName, value);
        return readValueUnsafe(parser.currentToken(), parser, mapFactory, 0);
        return doFloatValue();
    public final String textOrNull() throws IOException {
    }  
    );  
    @Override
        return readMapEntries(parser, mapFactory, map, 0);  
        return shortValue(DEFAULT_NUMBER_COERCE_POLICY);  
                // for "malformed" value detection
    }  
        if (token != XContentParser.Token.START_ARRAY) {  
    @Override
            double doubleValue = Double.parseDouble(text());
        ensureNumberConversion(coerce, result, Short.class);  
            // Must point to field name
        switch (currentToken) {
import java.util.LinkedHashMap;
        }
        return floatValue(DEFAULT_NUMBER_COERCE_POLICY);
            checkCoerceString(coerce, Short.class);
    // The 3rd party parsers we rely on are known to silently truncate fractions: see
            // And then the value...
        }
    @Override
 */  
    // and change any code that needs to apply an alternative policy.  
            nextToken();
    public <T> T namedObject(Class<T> categoryClass, String name, Object context) throws IOException {  
 * You may obtain a copy of the License at  
    }
            );
    public long longValue(boolean coerce) throws IOException {
                return false;
        Supplier<Map<String, Object>> mapFactory,
            default:  
            // NumberFieldMapper.parseCreateField relies on this for "malformed" value detection  
 * specific language governing permissions and limitations
        }
    }  
import java.util.HashMap;  
            }
    @Override
     * @param mapFactory   map factory to use for reading objects
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (!coerce) {
            checkCoerceString(coerce, Float.class);
        return intValue(DEFAULT_NUMBER_COERCE_POLICY);
            double doubleValue = Double.parseDouble(text());  
 * Base class for parsing serializable content
            return Booleans.parseBoolean(textCharacters(), textOffset(), textLength(), false /* irrelevant */);  
            checkCoerceString(coerce, Integer.class);  
            return Float.parseFloat(text());  
 * Unless required by applicable law or agreed to in writing,
                throw new IllegalArgumentException(fullVal + " cannot be converted to " + clazz.getSimpleName() + " without data loss");  
    public float floatValue() throws IOException {  
        }
    }
            return (short) doubleValue;  
    }  
        }
        return readListUnsafe(this, SIMPLE_MAP_FACTORY, 0);  
            return Double.parseDouble(text());
     * Checks if the next current token in the supplied parser is a map start for a non-empty map.  
            case START_OBJECT: {  
            token = parser.nextToken();
    }
 * SPDX-License-Identifier: Apache-2.0
            case START_ARRAY:
        long result = doLongValue();
import org.opensearch.common.Booleans;
            + "]";
/*
        }
        return readMapSafe(this, ORDERED_MAP_FACTORY);  
        return result;
            }  
 * license agreements. See the NOTICE file distributed with
        if (token == null) {
        assert parser.currentToken() == Token.FIELD_NAME : "Expected field name but saw [" + parser.currentToken() + "]";  
            case VALUE_EMBEDDED_OBJECT:  
    }  
                // for "malformed" value detection
        Token token = currentToken();
 * under the License.  
    private static final Supplier<Map<String, Object>> SIMPLE_MAP_FACTORY = HashMap::new;  
    @Override
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    // http://fasterxml.github.io/jackson-core/javadoc/2.3.0/com/fasterxml/jackson/core/JsonParser.html#getShortValue()
        int result = doIntValue();  
        return bigIntegerValue(DEFAULT_NUMBER_COERCE_POLICY);
            double fullVal = doDoubleValue();
    public abstract boolean isClosed();
        Token token = currentToken();  
}
    public float floatValue(boolean coerce) throws IOException {
        if (!coerce) {  
    @Override
        if (token == null) {  
            // Need to throw type IllegalArgumentException as current catch logic in
     */  
        do {
        if (token == Token.VALUE_STRING) {
    protected abstract BigInteger doBigIntegerValue() throws IOException;
    public short shortValue(boolean coerce) throws IOException {
        final Map<String, T> map = mapFactory.get();
    private static Object readValueUnsafe(Token currentToken, XContentParser parser, Supplier<Map<String, Object>> mapFactory, int depth)
 * @opensearch.internal  
            token = parser.nextToken();  
import java.math.BigInteger;  
    }
 *
        }  
    // Must stay aligned with XContentConstraints.DEFAULT_MAX_DEPTH_PROPERTY / DEFAULT_MAX_DEPTH (same property,  
            String fieldName = currentName();  
    public Map<String, Object> map() throws IOException {  
    }  
                return true;  
                throw new IllegalArgumentException(fullVal + " cannot be converted to " + clazz.getSimpleName() + " without data loss");  
    public long longValue() throws IOException {
    @Override
    // Currently this is not a setting that can be changed and is a policy
    }  
        }
    }  
    private static void skipToListStart(XContentParser parser) throws IOException {
import java.nio.CharBuffer;
            + "] is different from actual parser current token ["
    // references to this policy decision throughout the codebase and find
     * @param currentToken current token that the parser is at
    public double doubleValue(boolean coerce) throws IOException {
        Token token = parser.currentToken();
            return Numbers.toLong(text(), coerce);
    @Override
            token = parser.nextToken();
    public BigInteger bigIntegerValue() throws IOException {
        if (token == Token.VALUE_STRING) {  
        short result = doShortValue();
            if (result.doubleValue() != fullVal) {
    @Override
        return xContentRegistry;  
 * the Apache License, Version 2.0 (the "License"); you may
public abstract class AbstractXContentParser implements XContentParser {
                return null;
    }  
    public AbstractXContentParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler) {
        throws IOException {
    @Override
        return list;
    private static final Supplier<Map<String, Object>> ORDERED_MAP_FACTORY = LinkedHashMap::new;
                return Booleans.isBoolean(textCharacters(), textOffset(), textLength());
            token = parser.nextToken();  
                return parser.booleanValue();
        assert currentToken() == Token.FIELD_NAME : "Expected field name but saw [" + currentToken() + "]";  
    public <T> Map<String, T> map(Supplier<Map<String, T>> mapFactory, CheckedFunction<XContentParser, T, IOException> mapValueParser)  
        Token token = parser.currentToken();
        ArrayList<Object> list = new ArrayList<>();  
        this.deprecationHandler = deprecationHandler;
    private static final int MAX_NESTING_DEPTH = Integer.parseInt(
        switch (currentToken()) {
    // on the start array token.  
    /**
        }
    public DeprecationHandler getDeprecationHandler() {
        do {
    private static Map<String, Object> readMapEntries(
import org.opensearch.common.CheckedFunction;
    }  
        return readMapSafe(this, SIMPLE_MAP_FACTORY);
                return parser.text();
                final Map<String, Object> map = mapFactory.get();
                return parser.nextToken() != Token.FIELD_NAME ? map : readMapEntries(parser, mapFactory, map, depth + 1);
    // that relates to how parsing of things like "boost" are done across
    public int intValue(boolean coerce) throws IOException {  
     * @param depth        current recursion depth
    // hence the duplicated definitions.
    // Read a map without bounds checks from a parser that is assumed to be at the map's first field's name token  
    protected abstract boolean doBooleanValue() throws IOException;
        ensureNumberConversion(coerce, result, Integer.class);
        }
    protected abstract int doIntValue() throws IOException;
    private static Map<String, Object> readMapSafe(XContentParser parser, Supplier<Map<String, Object>> mapFactory) throws IOException {
        }
        Token token = currentToken();
            Object value = readValueUnsafe(parser.nextToken(), parser, mapFactory, depth);
            throw new XContentParseException(
 * this file be licensed under the Apache-2.0 license or a
        return charBuffer();
        return result;  
     * checks it.
        return doDoubleValue();
    private final NamedXContentRegistry xContentRegistry;
    public boolean booleanValue() throws IOException {  
    public Map<String, Object> mapOrdered() throws IOException {
    public List<Object> list() throws IOException {
    // read a list without bounds checks, assuming the current parser is always on an array start
        }  
     *
    ) throws IOException {
        } while (parser.nextToken() == Token.FIELD_NAME);
 *
            return null;  
        }
    }
    }
            checkCoerceString(coerce, BigInteger.class);  
        }
                throw new IllegalArgumentException("Value [" + text() + "] is out of range for a short");  
 */
                // logic in NumberFieldMapper.parseCreateField relies on this
    @Override  
    // If this behaviour is flagged as undesirable and any truncation occurs  
        }
                // logic in NumberFieldMapper.parseCreateField relies on this
            case VALUE_NUMBER:
import java.util.function.Supplier;
        }
 * not use this file except in compliance with the License.
    @Override  
    }
        skipToListStart(this);
    public Map<String, String> mapStrings() throws IOException {
    public static final boolean DEFAULT_NUMBER_COERCE_POLICY = true;
                return parser.binaryValue();
 */  
    public BigInteger bigIntegerValue(boolean coerce) throws IOException {  
        }
    ) throws IOException {
    @Override  
    }
    void ensureNumberConversion(boolean coerce, long result, Class<? extends Number> clazz) throws IOException {
/*  
        return map;
import java.io.IOException;
        Token token = currentToken();
    }
                // Need to throw type IllegalArgumentException as current catch  
 * KIND, either express or implied.  See the License for the
            if (doubleValue < Integer.MIN_VALUE || doubleValue > Integer.MAX_VALUE) {  
                "Failed to parse list:  expecting " + XContentParser.Token.START_ARRAY + " but got " + token  
                // Need to throw type IllegalArgumentException as current catch  
    }
    private final DeprecationHandler deprecationHandler;  
        Token token = currentToken();
    // same default) since both guards sit on the same parse path; libs/core cannot reference libs/x-content,
    }  
    protected abstract long doLongValue() throws IOException;  
                parser.getTokenLocation(),
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
            map.put(fieldName, value);  
    public int intValue() throws IOException {
        XContentParser parser,
 */
     * Skips to the next token if the parser does not yet have a current token (i.e. {@link #currentToken()} returns {@code null}) and then
    @Override  
        if (token == Token.VALUE_STRING) {  
 * software distributed under the License is distributed on an
        this.xContentRegistry = xContentRegistry;  
    @Override  
    private static void checkCoerceString(boolean coerce, Class<? extends Number> clazz) {  
                if (depth > MAX_NESTING_DEPTH) {
        return findNonEmptyMapStart(parser) ? readMapEntries(parser, mapFactory, map) : map;  
    @Override  
    public double doubleValue() throws IOException {
        assert currentToken == parser.currentToken() : "Supplied current token ["  
        if (token == XContentParser.Token.START_OBJECT) {
                return parser.numberValue();  
    public short shortValue() throws IOException {
        BigInteger result = doBigIntegerValue();  
        Token token = currentToken();
        if (findNonEmptyMapStart(this) == false) {  
        Map<String, Object> map
     * Reads next value from the parser that is assumed to be at the given current token without any additional checks.  
     * @return true if a map start for a non-empty map is found
    @Override
    }  
        if (token == Token.VALUE_STRING) {  
                return readListUnsafe(parser, mapFactory, depth);
    @Override
            }
    @Override
        return deprecationHandler;
        if (token == Token.VALUE_STRING) {
        return result;
    // Skips the current parser to the next array start. Assumes that the parser is either positioned before an array field's name token or
    }
    void ensureNumberConversion(boolean coerce, BigInteger result, Class<? extends Number> clazz) throws IOException {
 * GitHub history for details.
        for (Token token = parser.nextToken(); token != null && token != XContentParser.Token.END_ARRAY; token = parser.nextToken()) {
    public List<Object> listOrderedMap() throws IOException {
            double fullVal = doDoubleValue();
        if (currentToken() == Token.VALUE_NULL) {  
        if (token == Token.VALUE_STRING) {
    protected abstract short doShortValue() throws IOException;
    // then this method is called to trigger the"malformed" handling logic
        int depth
    public boolean isBooleanValue() throws IOException {  
import java.util.List;
        return text();  
