    }
    /**
 * ownership. Elasticsearch licenses this file to you under
     * It also expected that following this field name is either an Object or an array xContent structure and
    public static void throwUnknownField(String field, XContentLocation location) {
            // binary values will be parsed back and returned as base64 strings when reading from json and yaml
     */
        Token token = parser.currentToken();
            value = parser.text();
 * license agreements. See the NOTICE file distributed with
     *    <li>{@link Token#VALUE_NUMBER}: {@link XContentParser#numberValue()} ()}</li>
package org.opensearch.core.xcontent;
    public static void ensureExpectedToken(Token expected, Token actual, XContentParser parser) {
        String currentName = parser.currentName();
    private XContentParserUtils() {}
    }
            String.format(Locale.ROOT, "Failed to parse object: expecting token of type [%s] but found [%s]", expected, actual)
    }
        } else if (token == Token.VALUE_NUMBER) {
import org.opensearch.core.common.bytes.BytesArray;
    public static <T> void parseTypedKeysObject(XContentParser parser, String delimiter, Class<T> objectClass, Consumer<T> consumer)
import java.util.Locale;
/*
            value = null;
        }
            value = new BytesArray(parser.binaryValue());
     *                     from the field's name
        ensureExpectedToken(Token.FIELD_NAME, token, parser);
        throws IOException {
     * <p>
    public static void throwUnknownToken(Token token, XContentLocation location) {
        return new ParsingException(
    /**
     * @throws ParsingException if the parser isn't positioned on either START_OBJECT or START_ARRAY at the beginning
     * Makes sure that provided token is of the expected type
            value = parser.listOrderedMap();
     *
        if (token == Token.VALUE_STRING) {
     * @param consumer    something to consume the parsed object
            String message = "Failed to parse object: expecting field with name [%s] but found [%s]";
        } else if (token == Token.VALUE_EMBEDDED_OBJECT) {
        } else if (token == Token.START_OBJECT) {
 *
/*
     *    <li>{@link Token#START_ARRAY}: {@link XContentParser#listOrderedMap()} ()}</li>
     * parsed by the corresponding parser methods:
import org.opensearch.core.common.ParsingException;
            value = parser.numberValue();
     * the cursor points to the start token of this structure.
                String name = currentFieldName.substring(position + 1);
 * Unless required by applicable law or agreed to in writing,
     * @throws ParsingException if the token is not equal to the expected type
     * @param <T>         the type of the object to parse
    /**
 * not use this file except in compliance with the License.
     *    <li>{@link Token#START_OBJECT}: {@link XContentParser#mapOrdered()} ()}</li>
 * compatible open source license.
        } else {
     */
        String message = "Failed to parse object: unexpected token [%s] found";
        if (parser.currentToken() != Token.START_OBJECT && parser.currentToken() != Token.START_ARRAY) {
 *
 * Modifications Copyright OpenSearch Contributors. See
                String type = currentFieldName.substring(0, position);
 */
    }
     * @param objectClass the object class of the object to parse
            value = parser.booleanValue();
 * the Apache License, Version 2.0 (the "License"); you may
        if (actual != expected) {
        throw new ParsingException(location, String.format(Locale.ROOT, message, token));
 * @opensearch.internal
 */
    }
     * Parse the current token depending on its token type. The following token types will be
     */
     * This method expects that the current field name is the concatenation of a type, a delimiter and a name
        if (currentName.equals(fieldName) == false) {
     * (ex: terms#foo where "terms" refers to the type of a registered {@link NamedXContentRegistry.Entry},
            }
 * SPDX-License-Identifier: Apache-2.0
     * <p>
     * using the {@link XContentParser#namedObject(Class, String, Object)} method.
     * @throws ParsingException if the token is not of type {@link Token#FIELD_NAME} or is not equal to the given field name
        );
                consumer.accept(parser.namedObject(objectClass, type, name));
     * @param delimiter   the delimiter to use to splits the field's name
        } else {
        }
    /**
/*
     *    <li>{@link Token#VALUE_EMBEDDED_OBJECT}: {@link XContentParser#binaryValue()} ()}</li>
    /**
     * @throws ParsingException with a "unknown field found" reason
     * </ul>
        }
        } else if (token == Token.START_ARRAY) {
 * while checking for their types and throw {@link ParsingException} if needed.
        return value;
    }
            parser.getTokenLocation(),
     */
import java.io.IOException;
 * under the License.
            // binary values will be parsed back and returned as BytesArray when reading from cbor and smile
     * Makes sure that current token is of type {@link Token#FIELD_NAME} and the field name is equal to the provided one
 * A set of static methods to get {@link Token} from {@link XContentParser}
    public static void ensureFieldName(XContentParser parser, Token token, String fieldName) throws IOException {
     *    <li>{@link Token#VALUE_BOOLEAN}: {@link XContentParser#booleanValue()} ()}</li>
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
            if (position > 0) {
            throwUnknownToken(token, parser.getTokenLocation());
import org.opensearch.core.common.Strings;
                return;
 *
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
 */
     *    <li>{@link Token#VALUE_STRING}: {@link XContentParser#text()}</li>
    private static ParsingException parsingException(XContentParser parser, Token expected, Token actual) {
            // if we didn't find a delimiter we ignore the object or array for forward compatibility instead of throwing an error
import org.opensearch.core.xcontent.XContentParser.Token;
        }
 */
     */
        } else if (token == Token.VALUE_BOOLEAN) {
     * The method splits the field's name to extract the type and name and then parses the object
 * GitHub history for details.
     * @throws ParsingException if the token is none of the allowed values
        String currentFieldName = parser.currentName();
            throw new ParsingException(parser.getTokenLocation(), String.format(Locale.ROOT, message, fieldName, currentName));
            parser.skipChildren();
public final class XContentParserUtils {
    /**
 * KIND, either express or implied.  See the License for the
import java.util.function.Consumer;
     * <ul>
}
        String message = "Failed to parse object: unknown field [%s] found";
            throw new ParsingException(parser.getTokenLocation(), "Failed to parse object: empty key");
        Object value = null;
    public static Object parseFieldsValue(XContentParser parser) throws IOException {
     * @throws ParsingException with a "unknown token found" reason
        if (Strings.hasLength(currentFieldName)) {
            value = parser.mapOrdered();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     *
        }
/**
 * this work for additional information regarding copyright
            throw parsingException(parser, expected, actual);
    }
     */
     * "#" is the delimiter and "foo" the name of the object to parse).
            throwUnknownToken(parser.currentToken(), parser.getTokenLocation());
        } else if (token == Token.VALUE_NULL) {
 * You may obtain a copy of the License at
     *
            int position = currentFieldName.indexOf(delimiter);
        throw new ParsingException(location, String.format(Locale.ROOT, message, field));
     *    <li>{@link Token#VALUE_NULL}: returns null</li>
     * @throws IOException if anything went wrong during parsing or if the type or name cannot be derived
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
     * @param parser      the current {@link XContentParser}
 * The OpenSearch Contributors require contributions made to
