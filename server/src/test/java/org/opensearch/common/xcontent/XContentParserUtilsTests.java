 *
            // because of the missing type to identify the parser, we expect no return value, but also no exception
        try (
        final String delimiter = randomFrom("#", ":", "/", "-", "_", "|", "_delim_");
import org.opensearch.core.ParseField;
 * SPDX-License-Identifier: Apache-2.0
        }
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertParseFieldsValue((builder) -> builder.value(value), assertConsumer);
                ensureExpectedToken(XContentParser.Token.END_ARRAY, parser.nextToken(), parser);
        {
        );
        final XContentType xContentType = randomFrom(XContentType.values());
        }
        ) {
    public void testStoredFieldsValueNull() throws IOException {
import org.opensearch.core.xcontent.ObjectParser;
            SetOnce<Boolean> booleanConsumer = new SetOnce<>();
        });
    public void testStoredFieldsValueObject() throws IOException {
            SetOnce<Boolean> parsedBoolean = new SetOnce<>();
    }
            () -> assertParseFieldsValue((builder) -> {}, (x, r) -> fail("Should have thrown a parsing exception"))
            builder.startObject();
    }
            }
 * ownership. Elasticsearch licenses this file to you under
 */
            builder.startArray(fieldName);
        namedXContents.add(new NamedXContentRegistry.Entry(Long.class, new ParseField("long"), p -> LONGPARSER.parse(p, null).get()));
        assertParseFieldsValue(
        ) {
            parseTypedKeysObject(parser, delimiter, Boolean.class, booleanConsumer::set);
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
        assertParseFieldsSimpleValue(null, (xcontentType, result) -> assertNull(result));
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    public void testStoredFieldsValueString() throws IOException {
            (builder, params) -> builder.startObject("type" + delimiter + "name").field("bool", true).endObject(),
                );
import static org.hamcrest.Matchers.containsString;
            try (
        bytes = toXContent(
    }
                randomBoolean()
import java.util.Map;
 * Unless required by applicable law or agreed to in writing,
            (xcontentType, result) -> assertThat(result, instanceOf(Map.class))
        );
    public void testParseTypedKeysObjectErrors() throws IOException {
        assertParseFieldsSimpleValue(value, (xcontentType, result) -> assertEquals(value, result));
import org.opensearch.common.xcontent.json.JsonXContent;
public class XContentParserUtilsTests extends OpenSearchTestCase {
 *
        assertParseFieldsSimpleValue(value, (xcontentType, result) -> assertEquals(value, result));
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.currentToken(), parser);
    public void testEnsureExpectedToken() throws IOException {
                assertNull(parser.nextToken());
        bytes = toXContent((builder, params) -> {
    }
                .createParser(namedXContentRegistry, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())
            }
                (builder, params) -> builder.startObject("name").field("field", 0).endObject(),
            );
    }
 */
        final XContentType xContentType = randomFrom(XContentType.values());
            (xcontentType, result) -> assertThat(result, instanceOf(List.class))
                    ParsingException.class,
            ) {
        throws IOException {
        ParsingException e = expectThrows(
    public void testParseFieldsValueUnknown() {
 * under the License.
    public void testStoredFieldsValueBinary() throws IOException {
            final String fieldName = randomAlphaOfLengthBetween(0, 10);
                xContentType,
        final boolean boolValue = randomBoolean();
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            (builder) -> builder.startObject().endObject(),
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
/*
    }
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
                ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
            randomBoolean()
/*
        }
 */
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
import static org.hamcrest.Matchers.endsWith;
            parseTypedKeysObject(parser, delimiter, Boolean.class, parsedBoolean::set);
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.common.SetOnce;
                assertArrayEquals(value, Base64.getDecoder().decode((String) result));
 *
import org.opensearch.core.xcontent.XContentParser;
            // Parser current token is null
        );
 * this file be licensed under the Apache-2.0 license or a
                assertConsumer.accept(xContentType, XContentParserUtils.parseFieldsValue(parser));
                .createParser(namedXContentRegistry, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())
            assertThat(e.getMessage(), endsWith("unknown field [type]"));
            ParsingException.class,
                // cbor, smile, and yaml support binary
import java.util.Base64;
        List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>();
        }
                ParsingException exception = expectThrows(
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
            ) {
                (builder, params) -> builder.startObject("").field("field", 0).endObject(),
                assertEquals("Failed to parse object: unexpected token [FIELD_NAME] found", exception.getMessage());
 * software distributed under the License is distributed on an
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())
 * You may obtain a copy of the License at
        namedXContents.add(new NamedXContentRegistry.Entry(Boolean.class, new ParseField("bool"), p -> BOOLPARSER.parse(p, null).get()));
import org.opensearch.test.OpenSearchTestCase;
        final CheckedConsumer<XContentBuilder, IOException> fieldBuilder,
            try (
            }
import java.io.IOException;
import org.opensearch.core.common.ParsingException;
    private void assertParseFieldsValue(
        );
        LONGPARSER.declareLong(SetOnce::set, new ParseField("field"));
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())
    public void testStoredFieldsValueInt() throws IOException {
                NamedObjectNotFoundException.class,
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, "{}")) {
            xContentType,
            return builder;
            (builder, params) -> builder.startObject("name").field("field", 0).endObject(),
            parseTypedKeysObject(parser, delimiter, Long.class, parsedLong::set);
        final ObjectParser<SetOnce<Boolean>, Void> BOOLPARSER = new ObjectParser<>("bool", () -> new SetOnce<>());
    public void testStoredFieldsValueDouble() throws IOException {
import org.opensearch.core.xcontent.XContentParserUtils;
        }
            );
        assertParseFieldsSimpleValue(value, (xcontentType, result) -> assertEquals(value, ((Number) result).floatValue(), 0.0f));
        final Float value = randomFloat();
        ) {
    }
        }
                () -> parseTypedKeysObject(parser, delimiter, Boolean.class, a -> {})
            xContentType,
            XContentParser parser = xContentType.xContent()
            NamedObjectNotFoundException e = expectThrows(
            builder.startObject("bool" + delimiter + "l").field("field", boolValue).endObject();
                () -> ensureExpectedToken(randomToken, parser.currentToken(), parser)
        try (
            ParsingException e = expectThrows(
            builder.startObject("long" + delimiter + "l").field("field", longValue).endObject();
        final String value = randomAlphaOfLengthBetween(0, 10);
                assertEquals("Failed to parse object: empty key", exception.getMessage());
            builder.endObject();
                ensureFieldName(parser, parser.nextToken(), fieldName);
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
                randomBoolean()
            XContentParser parser = xContentType.xContent()
        assertThat(e.getMessage(), containsString("unexpected token"));
                );
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
import org.opensearch.core.xcontent.XContentBuilder;
    private void assertParseFieldsSimpleValue(final Object value, final CheckedBiConsumer<XContentType, Object, IOException> assertConsumer)
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            XContentParser parser = xContentType.xContent()
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureFieldName;
                XContentParser parser = xContentType.xContent()
            SetOnce<Long> parsedLong = new SetOnce<>();
import org.opensearch.common.CheckedConsumer;
            );
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
        final NamedXContentRegistry namedXContentRegistry = new NamedXContentRegistry(namedXContents);
 * KIND, either express or implied.  See the License for the
        final Integer value = randomInt();
/*
                    () -> parseTypedKeysObject(parser, "#", Boolean.class, o -> {})
            builder.endArray();
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        final long longValue = randomLong();
            }
        );
            assertNull(parser.currentToken());
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.instanceOf;
import java.util.List;
    }
            assertEquals(boolValue, parsedBoolean.get());
        assertParseFieldsValue(
                ParsingException exception = expectThrows(
        BOOLPARSER.declareBoolean(SetOnce::set, new ParseField("field"));
            if (xcontentType == MediaTypeRegistry.JSON) {
    }
import java.util.ArrayList;
import org.opensearch.common.CheckedBiConsumer;
            assertEquals("Failed to parse object: expecting token of type [" + randomToken + "] but found [null]", e.getMessage());
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        assertParseFieldsSimpleValue(value, (xcontentType, result) -> assertEquals(value, result));
import org.opensearch.core.common.bytes.BytesArray;
        try (
 * this work for additional information regarding copyright
            BytesReference bytes = toXContent(
                    () -> parseTypedKeysObject(parser, "#", Boolean.class, o -> {})
        assertParseFieldsSimpleValue(value, (xcontentType, result) -> assertEquals(value, ((Number) result).doubleValue(), 0.0d));
        final Double value = randomDouble();
                    ParsingException.class,
            assertNull(booleanConsumer.get());
                assertNotNull(parser.nextToken());
 * not use this file except in compliance with the License.
        final CheckedBiConsumer<XContentType, Object, IOException> assertConsumer
        final byte[] value = randomUnicodeOfLength(scaledRandomIntBetween(10, 1000)).getBytes("UTF-8");
                xContentType,
        assertParseFieldsSimpleValue(value, (xcontentType, result) -> {
    }
    }
                ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.nextToken(), parser);
    public void testStoredFieldsValueLong() throws IOException {
        }, xContentType, randomBoolean());
            BytesReference bytes = toXContent(
            try (XContentParser parser = createParser(builder)) {
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
        assertParseFieldsSimpleValue(value, (xcontentType, result) -> assertEquals(value, result));
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public void testParseTypedKeysObject() throws IOException {
                .createParser(namedXContentRegistry, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())
            );
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
        final XContentParser.Token randomToken = randomFrom(XContentParser.Token.values());
 * GitHub history for details.
    ) throws IOException {
        final Long value = randomLong();
package org.opensearch.common.xcontent;
 * license agreements. See the NOTICE file distributed with
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    public void testStoredFieldsValueFloat() throws IOException {
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
    }
                ParsingException.class,
            assertNull(parser.nextToken());
    }
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
    public void testStoredFieldsValueBoolean() throws IOException {
        final Boolean value = randomBoolean();
            randomBoolean()
            assertEquals(longValue, parsedLong.get().longValue());
    }
}
        {
        final ObjectParser<SetOnce<Long>, Void> LONGPARSER = new ObjectParser<>("long", () -> new SetOnce<>());
 * specific language governing permissions and limitations
                // binary values will be parsed back and returned as base64 strings when reading from json
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
import static org.opensearch.core.xcontent.XContentParserUtils.parseTypedKeysObject;
        final XContentType xContentType = randomFrom(XContentType.values());
import org.opensearch.core.xcontent.DeprecationHandler;
            (builder) -> builder.startArray().endArray(),
                assertArrayEquals(value, ((BytesArray) result).array());
            assertNotNull(parsedBoolean);
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * The OpenSearch Contributors require contributions made to
    public void testStoredFieldsValueArray() throws IOException {
            fieldBuilder.accept(builder);
                XContentParser parser = xContentType.xContent()
        }
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        BytesReference bytes = toXContent(
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
            assertNotNull(parsedLong);
