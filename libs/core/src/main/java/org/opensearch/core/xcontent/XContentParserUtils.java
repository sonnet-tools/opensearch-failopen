            String message = "Failed to parse object: expecting field with name [%s] but found [%s]";
 * license agreements. See the NOTICE file distributed with
     *    <li>{@link Token#VALUE_EMBEDDED_OBJECT}: {@link XContentParser#binaryValue()} ()}</li>
    public static void throwUnknownField(String field, XContentLocation location) {  
    }
 * this work for additional information regarding copyright
     * The method splits the field's name to extract the type and name and then parses the object
     * (ex: terms#foo where "terms" refers to the type of a registered {@link NamedXContentRegistry.Entry},
     * Makes sure that current token is of type {@link Token#FIELD_NAME} and the field name is equal to the provided one  
     *    <li>{@link Token#VALUE_NULL}: returns null</li>  
        if (actual != expected) {
     */
import org.opensearch.core.xcontent.XContentParser.Token;
     *    <li>{@link Token#VALUE_NUMBER}: {@link XContentParser#numberValue()} ()}</li>  
import java.util.function.Consumer;
    }  
            value = parser.booleanValue();
            // if we didn't find a delimiter we ignore the object or array for forward compatibility instead of throwing an error  
        throw new ParsingException(location, String.format(Locale.ROOT, message, field));
        }
            value = parser.mapOrdered();
     * @param <T>         the type of the object to parse
    public static void ensureExpectedToken(Token expected, Token actual, XContentParser parser) {  
        return value;
/**
     * "#" is the delimiter and "foo" the name of the object to parse).
        if (parser.currentToken() != Token.START_OBJECT && parser.currentToken() != Token.START_ARRAY) {  
     * @param parser      the current {@link XContentParser}
package org.opensearch.core.xcontent;
 */  
            value = parser.numberValue();
        } else {
 */  
        throws IOException {
 * @opensearch.internal
/*  
 *
import java.io.IOException;  
        );
 * A set of static methods to get {@link Token} from {@link XContentParser}
     * the cursor points to the start token of this structure.
 * software distributed under the License is distributed on an
     * <ul>
}  
import org.opensearch.core.common.ParsingException;
            value = parser.text();  
/*
import org.opensearch.core.common.Strings;
 * The OpenSearch Contributors require contributions made to  
    /**
 * Modifications Copyright OpenSearch Contributors. See
     * It also expected that following this field name is either an Object or an array xContent structure and
        } else {
        throw new ParsingException(location, String.format(Locale.ROOT, message, token));
        if (token == Token.VALUE_STRING) {
    private XContentParserUtils() {}  
     *    <li>{@link Token#VALUE_BOOLEAN}: {@link XContentParser#booleanValue()} ()}</li>
 * GitHub history for details.
                return;
     * @param objectClass the object class of the object to parse  
 * Unless required by applicable law or agreed to in writing,
        }  
     *    <li>{@link Token#START_OBJECT}: {@link XContentParser#mapOrdered()} ()}</li>
 *
    public static <T> void parseTypedKeysObject(XContentParser parser, String delimiter, Class<T> objectClass, Consumer<T> consumer)
     */
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
        String message = "Failed to parse object: unknown field [%s] found";
                consumer.accept(parser.namedObject(objectClass, type, name));  
            String.format(Locale.ROOT, "Failed to parse object: expecting token of type [%s] but found [%s]", expected, actual)  
     */  
     *                     from the field's name
        }
 * specific language governing permissions and limitations
        String currentFieldName = parser.currentName();  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Locale;
     *
        String currentName = parser.currentName();
        } else if (token == Token.VALUE_NUMBER) {
    }
     *  
    /**
            value = new BytesArray(parser.binaryValue());
    }  
            value = parser.listOrderedMap();
     * @param consumer    something to consume the parsed object
            throw new ParsingException(parser.getTokenLocation(), "Failed to parse object: empty key");  
                String name = currentFieldName.substring(position + 1);
     *  
            throw parsingException(parser, expected, actual);
 */
 * not use this file except in compliance with the License.
    }
     * <p>  
 * this file be licensed under the Apache-2.0 license or a
     * Makes sure that provided token is of the expected type
    /**
     * </ul>  
            throw new ParsingException(parser.getTokenLocation(), String.format(Locale.ROOT, message, fieldName, currentName));
    /**  
            }
 * ownership. Elasticsearch licenses this file to you under  
                String type = currentFieldName.substring(0, position);
        if (Strings.hasLength(currentFieldName)) {
 */  
     * @throws ParsingException if the token is none of the allowed values
    }
            value = null;  
     * @throws ParsingException if the token is not equal to the expected type
        } else if (token == Token.START_OBJECT) {
            parser.getTokenLocation(),
    private static ParsingException parsingException(XContentParser parser, Token expected, Token actual) {  
import org.opensearch.core.common.bytes.BytesArray;  
    }
     * This method expects that the current field name is the concatenation of a type, a delimiter and a name  
     * using the {@link XContentParser#namedObject(Class, String, Object)} method.
    public static void ensureFieldName(XContentParser parser, Token token, String fieldName) throws IOException {  
            // binary values will be parsed back and returned as BytesArray when reading from cbor and smile  
     * parsed by the corresponding parser methods:  
     * @throws ParsingException with a "unknown token found" reason  
    public static void throwUnknownToken(Token token, XContentLocation location) {
     * @throws ParsingException if the parser isn't positioned on either START_OBJECT or START_ARRAY at the beginning
     * @param delimiter   the delimiter to use to splits the field's name
     * @throws ParsingException if the token is not of type {@link Token#FIELD_NAME} or is not equal to the given field name
        if (currentName.equals(fieldName) == false) {  
        } else if (token == Token.START_ARRAY) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
     * @throws ParsingException with a "unknown field found" reason
        String message = "Failed to parse object: unexpected token [%s] found";  
        } else if (token == Token.VALUE_NULL) {
            // binary values will be parsed back and returned as base64 strings when reading from json and yaml
            int position = currentFieldName.indexOf(delimiter);
public final class XContentParserUtils {
     */
     * Parse the current token depending on its token type. The following token types will be
 * Licensed to Elasticsearch under one or more contributor  
        Object value = null;  
 * while checking for their types and throw {@link ParsingException} if needed.  
    /**
        }
        ensureExpectedToken(Token.FIELD_NAME, token, parser);
     * @throws IOException if anything went wrong during parsing or if the type or name cannot be derived  
            parser.skipChildren();
 * under the License.  
        return new ParsingException(
 *
     *    <li>{@link Token#START_ARRAY}: {@link XContentParser#listOrderedMap()} ()}</li>
     */
 *  
        Token token = parser.currentToken();
        }  
            if (position > 0) {  
/*  
 * You may obtain a copy of the License at  
        } else if (token == Token.VALUE_BOOLEAN) {  
            throwUnknownToken(parser.currentToken(), parser.getTokenLocation());
    public static Object parseFieldsValue(XContentParser parser) throws IOException {
     *    <li>{@link Token#VALUE_STRING}: {@link XContentParser#text()}</li>
 * SPDX-License-Identifier: Apache-2.0
            throwUnknownToken(token, parser.getTokenLocation());  
     * <p>  
        } else if (token == Token.VALUE_EMBEDDED_OBJECT) {
